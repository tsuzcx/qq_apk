package com.tencent.aelight.camera.aeeditor.module.edit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.YoutuResultItem;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.microrapid.opencv.ImageMainColorData;
import com.tencent.aelight.camera.ae.AEViewModelProviders;
import com.tencent.aelight.camera.ae.album.data.AEAlbumMediaBaseModel;
import com.tencent.aelight.camera.ae.play.FaceChangeUtils;
import com.tencent.aelight.camera.ae.protobuf.AEPbData.FaceInfo;
import com.tencent.aelight.camera.ae.protobuf.AEPbData.ImageInfo;
import com.tencent.aelight.camera.ae.protobuf.AEPbData.ImageStylizeRequest;
import com.tencent.aelight.camera.ae.protobuf.AEPbData.ImageStylizeResponse;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.report.AEEditReportData;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.ae.util.AECommonUtil;
import com.tencent.aelight.camera.ae.util.AEThemeUtil;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aeeditor.AEEditorModuleManager;
import com.tencent.aelight.camera.aeeditor.AEEditorPath.EDITOR.CACHE;
import com.tencent.aelight.camera.aeeditor.AEEditorPath.EDITOR.FILES;
import com.tencent.aelight.camera.aeeditor.data.AEEditorImageInfo;
import com.tencent.aelight.camera.aeeditor.module.aifilter.AEEditorAIFilterManager;
import com.tencent.aelight.camera.aeeditor.module.aifilter.AEEditorAIFilterManager.AIFilterObserver;
import com.tencent.aelight.camera.aeeditor.module.aifilter.AEEditorApplyAllLoadingView;
import com.tencent.aelight.camera.aeeditor.module.aifilter.AIFilterDataCache;
import com.tencent.aelight.camera.aeeditor.module.aifilter.AIFilterProxyBase;
import com.tencent.aelight.camera.aeeditor.module.aifilter.AIFilterResult;
import com.tencent.aelight.camera.aeeditor.module.aifilter.BatchImageAIFilterProxy;
import com.tencent.aelight.camera.aeeditor.module.aifilter.BatchImageAIFilterResult;
import com.tencent.aelight.camera.aeeditor.module.aifilter.ComicsFilterResult;
import com.tencent.aelight.camera.aeeditor.module.aifilter.SilentBatchImageAIFilterProxy;
import com.tencent.aelight.camera.aeeditor.module.aifilter.SingleImageAIFilterProxy;
import com.tencent.aelight.camera.aeeditor.module.aifilter.SingleImageAIFilterResult;
import com.tencent.aelight.camera.aeeditor.module.clip.image.AEEditorClipContainer;
import com.tencent.aelight.camera.aeeditor.module.clip.image.AEEditorClipPanel;
import com.tencent.aelight.camera.aeeditor.module.clip.image.EditorPicInfo;
import com.tencent.aelight.camera.aeeditor.module.edit.widgets.AEEditorCheckGroupView;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorFilterControlPanel;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorFilterControlPanel.FilterControlListener;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorFilterControlPanel.ImageFilterControlListener;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager;
import com.tencent.aelight.camera.aeeditor.module.filter.FilterChangedComparator;
import com.tencent.aelight.camera.aeeditor.module.filter.FilterMetaMaterialKt;
import com.tencent.aelight.camera.aeeditor.module.filter.ImageFilterInfoCache;
import com.tencent.aelight.camera.aeeditor.module.frame.AEEditorFramePanel;
import com.tencent.aelight.camera.aeeditor.module.imagetemplate.AEEditorImageTemplatePanel;
import com.tencent.aelight.camera.aeeditor.module.imagetemplate.ImageTemplateControlListener;
import com.tencent.aelight.camera.aeeditor.module.params.ImageParamStrategy;
import com.tencent.aelight.camera.aeeditor.module.params.ParamFactory;
import com.tencent.aelight.camera.aeeditor.module.params.ParamsUtil;
import com.tencent.aelight.camera.aeeditor.module.text.AEEditorStickerControlPanel;
import com.tencent.aelight.camera.aeeditor.module.text.AEEditorStickerPart.AEEditorTextDialogListener;
import com.tencent.aelight.camera.aeeditor.module.text.AEEditorTextViewModel;
import com.tencent.aelight.camera.aeeditor.record.AEEditorImageRecord;
import com.tencent.aelight.camera.aeeditor.util.AEExtractColorUtil;
import com.tencent.aelight.camera.aeeditor.util.AELocalMediaInfoUtil;
import com.tencent.aelight.camera.aeeditor.util.AEQCircleReport;
import com.tencent.aelight.camera.aeeditor.view.AEEditorLoadingView;
import com.tencent.aelight.camera.aeeditor.view.NumberIndicator;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qcircle.tavcut.bean.CropConfig;
import com.tencent.qcircle.tavcut.bean.Size;
import com.tencent.qcircle.tavcut.exporter.ImageExportConfig;
import com.tencent.qcircle.tavcut.exporter.ImageExporter;
import com.tencent.qcircle.tavcut.session.TAVCutImageSession;
import com.tencent.qcircle.tavcut.session.TAVCutSession;
import com.tencent.qcircle.tavcut.session.config.SessionConfig;
import com.tencent.qcircle.tavcut.session.config.StickerEditViewIconConfig;
import com.tencent.qcircle.tavcut.util.BitmapUtil;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.tavcut.util.Util;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.effect.MediaEffectModel;
import com.tencent.qcircle.weseevideo.model.effect.StickerModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaClipModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaResourceModel;
import com.tencent.qcircle.weseevideo.model.resource.VideoResourceModel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.openapi.PTFaceAttr;
import common.config.service.QzoneConfig;
import feedcloud.FeedCloudCommon.Entry;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class AEEditorImageEditFragment
  extends AEEditorCommonEditFragment
  implements Handler.Callback, ViewPager.OnPageChangeListener, AEEditorFilterControlPanel.ImageFilterControlListener, ImageTemplateControlListener
{
  AEEditorAIFilterManager.AIFilterObserver A = new AEEditorImageEditFragment.20(this);
  AEEditorAIFilterManager.AIFilterObserver B = new AEEditorImageEditFragment.21(this);
  private long C;
  private AEEditorImageViewPager D;
  private AEEditorImagePagerAdapter E;
  private NumberIndicator F;
  private FrameLayout G;
  private TAVCutImageSession H;
  private int I = 0;
  private ArrayList<String> J = new ArrayList();
  private ArrayList<String> K = new ArrayList();
  private ArrayList<String> L;
  private List<AEEditorImageInfo> M = new ArrayList();
  private AIFilterDataCache N = new AIFilterDataCache();
  private HashMap<String, ArrayList<String>> O = new HashMap();
  private ImageFilterInfoCache P = new ImageFilterInfoCache();
  private Map<String, ComicsFilterResult> Q = new HashMap();
  private HttpNetReq R;
  private SparseArray<List<ImageMainColorData>> S = new SparseArray();
  private SparseArray<List<ImageMainColorData>> T = new SparseArray();
  private SparseArray<String> U = new SparseArray();
  private ImageExporter V;
  private int W;
  private long X;
  private long Y;
  private boolean Z = false;
  private String aa = "";
  private boolean ab = false;
  private ImageParamStrategy ac = ParamFactory.a();
  private boolean ad = true;
  private FrameLayout ae;
  private AEEditorClipPanel af;
  private ImageView ag;
  private AEEditorImageTemplatePanel ah;
  private AEEditorFramePanel ai;
  private StringBuilder aj;
  private StringBuilder ak;
  private StringBuilder al;
  private StringBuilder am;
  private StringBuilder an;
  private boolean ao = true;
  private AEVideoEditViewModel ap;
  private int aq = -1;
  private Observer<List<MetaCategory>> ar;
  private Observer<List<MetaCategory>> as;
  private View at;
  private volatile boolean au = false;
  boolean z = false;
  
  private void Y()
  {
    QLog.d("AEEditorImageEditFragment", 1, "registerObserverData...");
    this.ar = new AEEditorImageEditFragment.1(this);
    AEEditorResourceManager.a().f().observeForever(this.ar);
    this.as = new AEEditorImageEditFragment.2(this);
    AEEditorResourceManager.a().e().observe(getViewLifecycleOwner(), this.as);
  }
  
  private void Z()
  {
    AEQLog.b("AEEditorImageEditFragment", "showImages");
    this.E = new AEEditorImagePagerAdapter(this.H, this.J, this.M, this.U, new AEEditorImageEditFragment.9(this));
    this.F.setTotalCount(this.E.getCount());
    NumberIndicator localNumberIndicator = this.F;
    int i;
    if (this.E.getCount() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    localNumberIndicator.setCurrentIndex(i);
    this.D.setAdapter(this.E);
    this.D.post(new AEEditorImageEditFragment.10(this));
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      i = 736;
    }
    paramInt = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    int k = Math.max(paramInt, j);
    float f = 1.0F;
    if (k > i) {
      f = i * 1.0F / k;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(f, f);
    return Bitmap.createBitmap(paramBitmap, 0, 0, paramInt, j, localMatrix, true);
  }
  
  private Bitmap a(String paramString, CropConfig paramCropConfig)
  {
    int j;
    try
    {
      localObject = BitmapUtil.getImageSize(paramString, false);
      Size localSize = Util.constrainMaxSize((Size)localObject, this.ac.c());
      j = ((Size)localObject).getWidth() / localSize.getWidth();
      if (((Size)localObject).getWidth() % localSize.getWidth() != 0) {
        break label293;
      }
      i = 0;
    }
    catch (Error paramString)
    {
      Object localObject;
      Logger.e(paramString);
      return null;
    }
    catch (Exception paramString)
    {
      Logger.e(paramString);
      return null;
    }
    localObject = BitmapUtil.decodeBitmap(paramString, i);
    if (!a((Bitmap)localObject)) {
      return null;
    }
    int i = new ExifInterface(paramString).getAttributeInt("Orientation", 1);
    if (i != 3) {
      if (i != 6) {
        if (i != 8) {
          i = 0;
        }
      }
    }
    for (;;)
    {
      paramString = new Matrix();
      paramString.postRotate(i);
      paramString = Bitmap.createBitmap((Bitmap)localObject, 0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight(), paramString, true);
      localObject = Bitmap.createBitmap((int)(paramString.getWidth() * paramCropConfig.getWidth()), (int)(paramString.getHeight() * paramCropConfig.getHeight()), paramString.getConfig());
      new Canvas((Bitmap)localObject).drawBitmap(paramString, new Rect((int)(paramString.getWidth() * paramCropConfig.getX()), (int)(paramString.getHeight() * paramCropConfig.getY()), (int)(paramString.getWidth() * (paramCropConfig.getX() + paramCropConfig.getWidth())), (int)(paramString.getHeight() * (paramCropConfig.getY() + paramCropConfig.getHeight()))), new Rect(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight()), new Paint());
      return localObject;
      label293:
      i = 1;
      j = i + j;
      i = j;
      if (j > 0) {
        break;
      }
      i = 1;
      break;
      i = 270;
      continue;
      i = 90;
      continue;
      i = 180;
    }
  }
  
  private String a(int paramInt, byte[] paramArrayOfByte, long paramLong, MetaMaterial paramMetaMaterial)
  {
    Object localObject = new AEPbData.ImageStylizeResponse();
    try
    {
      ((AEPbData.ImageStylizeResponse)localObject).mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    try
    {
      int i = ((AEPbData.ImageStylizeResponse)localObject).code.get();
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("comics response: code=");
      paramArrayOfByte.append(i);
      paramArrayOfByte.append(", msg=");
      paramArrayOfByte.append(((AEPbData.ImageStylizeResponse)localObject).msg.get());
      AEQLog.b("AEEditorImageEditFragment", paramArrayOfByte.toString());
      paramArrayOfByte = AEBaseDataReporter.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramLong);
      localStringBuilder.append("");
      paramArrayOfByte.a(1000, localStringBuilder.toString(), "lut_comics", i);
      if (((AEPbData.ImageStylizeResponse)localObject).imageRawData.has())
      {
        paramArrayOfByte = ((AEPbData.ImageStylizeResponse)localObject).imageRawData.get().toByteArray();
        paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(AEEditorPath.EDITOR.CACHE.d);
        ((StringBuilder)localObject).append(File.separator);
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(paramMetaMaterial.id);
        ((StringBuilder)localObject).append(".jpg");
        paramMetaMaterial = ((StringBuilder)localObject).toString();
        com.tencent.qapmsdk.common.util.FileUtil.createFile(paramMetaMaterial);
        BitmapUtil.saveBitmap(paramArrayOfByte, Bitmap.CompressFormat.PNG, 100, paramMetaMaterial, null);
        BitmapUtils.recycle(paramArrayOfByte);
        return paramMetaMaterial;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      AEQLog.d("AEEditorImageEditFragment", paramArrayOfByte.toString());
    }
    return "";
  }
  
  @Nullable
  private ArrayList<String> a(@Nullable BatchImageAIFilterResult paramBatchImageAIFilterResult, int paramInt)
  {
    if ((paramBatchImageAIFilterResult != null) && (!CollectionUtils.isEmpty(paramBatchImageAIFilterResult.b)) && (paramInt >= 0))
    {
      if (paramBatchImageAIFilterResult.b.size() <= paramInt) {
        return null;
      }
      paramBatchImageAIFilterResult = (SingleImageAIFilterResult)new LinkedList(paramBatchImageAIFilterResult.b).get(paramInt);
      if (paramBatchImageAIFilterResult != null)
      {
        if (CollectionUtils.isEmpty(paramBatchImageAIFilterResult.c)) {
          return null;
        }
        Object localObject = new LinkedList(paramBatchImageAIFilterResult.c);
        if ((((List)localObject).size() > 0) && (((List)localObject).get(0) != null)) {
          paramBatchImageAIFilterResult = ((YoutuResultItem)((List)localObject).get(0)).Label;
        } else {
          paramBatchImageAIFilterResult = null;
        }
        if ((((List)localObject).size() > 1) && (((List)localObject).get(1) != null)) {
          localObject = ((YoutuResultItem)((List)localObject).get(1)).Label;
        } else {
          localObject = null;
        }
        ArrayList localArrayList = new ArrayList();
        if (!TextUtils.isEmpty(paramBatchImageAIFilterResult)) {
          localArrayList.add(paramBatchImageAIFilterResult);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localArrayList.add(localObject);
        }
        if (CollectionUtils.isEmpty(localArrayList)) {
          return null;
        }
        return localArrayList;
      }
    }
    return null;
  }
  
  @Nullable
  private ArrayList<String> a(@Nullable HashMap<String, ArrayList<String>> paramHashMap, @NonNull String paramString)
  {
    if (paramHashMap == null) {
      return null;
    }
    return (ArrayList)paramHashMap.get(paramString);
  }
  
  private void a(int paramInt1, ComicsFilterResult paramComicsFilterResult, int paramInt2, MetaMaterial paramMetaMaterial)
  {
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.19(this, paramInt2, paramInt1, paramComicsFilterResult, paramMetaMaterial));
  }
  
  private void a(Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt1, int paramInt2, MetaMaterial paramMetaMaterial)
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = new AEEditorImageEditFragment.18(this, paramInt1, paramMetaMaterial, paramInt2);
    localHttpNetReq.mReqUrl = "https://api.shadowai.qq.com/trpc.mobile_qq_http.mobile_qq_http_cgi.MobileQQHttpCgi/ImageStylize";
    localHttpNetReq.mHttpMethod = 1;
    localHttpNetReq.mExcuteTimeLimit = 30000L;
    localHttpNetReq.mSendData = a(paramBitmap1, paramBitmap2, paramMetaMaterial);
    localHttpNetReq.mPrioty = 0;
    localHttpNetReq.mReqProperties.put("Content-Type", "application/proto; charset=UTF-8");
    localHttpNetReq.mReqProperties.put("Accept", "application/proto");
    paramBitmap1 = BaseApplicationImpl.getApplication().getRuntime();
    if (paramBitmap1 == null)
    {
      QLog.e("AEEditorImageEditFragment", 1, "app is null");
      return;
    }
    paramMetaMaterial = (TicketManager)paramBitmap1.getManager(2);
    paramBitmap1 = paramBitmap1.getAccount();
    paramBitmap2 = paramMetaMaterial.getSkey(paramBitmap1);
    paramMetaMaterial = paramMetaMaterial.getPskey(paramBitmap1, "shadowai.qq.com");
    StringBuilder localStringBuilder;
    if (!TextUtils.isEmpty(paramMetaMaterial))
    {
      paramBitmap2 = localHttpNetReq.mReqProperties;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("uin=");
      localStringBuilder.append(paramBitmap1);
      localStringBuilder.append(";pskey=");
      localStringBuilder.append(paramMetaMaterial);
      localStringBuilder.append(";qqversion=");
      localStringBuilder.append("8.8.17");
      localStringBuilder.append(";aekitversion=");
      localStringBuilder.append("2.6.0.23");
      localStringBuilder.append(";platform=");
      localStringBuilder.append("Android");
      paramBitmap2.put("Cookie", localStringBuilder.toString());
    }
    else
    {
      aa();
      paramMetaMaterial = localHttpNetReq.mReqProperties;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("uin=");
      localStringBuilder.append(paramBitmap1);
      localStringBuilder.append(";skey=");
      localStringBuilder.append(paramBitmap2);
      localStringBuilder.append(";qqversion=");
      localStringBuilder.append("8.8.17");
      localStringBuilder.append(";aekitversion=");
      localStringBuilder.append("2.6.0.23");
      localStringBuilder.append(";platform=");
      localStringBuilder.append("Android");
      paramMetaMaterial.put("Cookie", localStringBuilder.toString());
    }
    localHttpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    ((IHttpEngineService)MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IHttpEngineService.class, "all")).sendReq(localHttpNetReq);
    this.R = localHttpNetReq;
  }
  
  private void a(AEPbData.ImageStylizeRequest paramImageStylizeRequest, Bitmap paramBitmap, int paramInt)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Bitmap localBitmap = a(paramBitmap, paramInt);
    BitmapUtils.recycle(paramBitmap);
    localBitmap.compress(Bitmap.CompressFormat.JPEG, 90, localByteArrayOutputStream);
    paramBitmap = localByteArrayOutputStream.toByteArray();
    paramImageStylizeRequest.imgInfo.imageMask.set(ByteStringMicro.copyFrom(paramBitmap), true);
    BitmapUtils.recycle(localBitmap);
  }
  
  private void a(ImageExportConfig paramImageExportConfig)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("outputPaths=");
    localStringBuilder.append(paramImageExportConfig.getOutputPaths());
    localStringBuilder.append(", maxExportSize=");
    localStringBuilder.append(paramImageExportConfig.getMaxExportSize());
    localStringBuilder.append(", minRenderSize=");
    localStringBuilder.append(paramImageExportConfig.getMinIntermediateRenderSize());
    localStringBuilder.append(", maxRenderSize=");
    localStringBuilder.append(paramImageExportConfig.getMaxIntermediateRenderSize());
    localStringBuilder.append(", quality=");
    localStringBuilder.append(paramImageExportConfig.getQuality());
    paramImageExportConfig = new StringBuilder();
    paramImageExportConfig.append("[onGoNext], exportParams: ");
    paramImageExportConfig.append(localStringBuilder.toString());
    AEQLog.d("AEEditorImageEditFragment", paramImageExportConfig.toString());
  }
  
  private void a(HashMap<String, String> paramHashMap)
  {
    if (paramHashMap == null) {
      return;
    }
    if (this.aj.length() == 0)
    {
      this.aj.append((String)paramHashMap.get("filter_id"));
    }
    else
    {
      localStringBuilder = this.aj;
      localStringBuilder.append(",");
      localStringBuilder.append((String)paramHashMap.get("filter_id"));
    }
    if (this.ak.length() == 0)
    {
      this.ak.append((String)paramHashMap.get("text_item_id"));
    }
    else
    {
      localStringBuilder = this.ak;
      localStringBuilder.append(",");
      localStringBuilder.append((String)paramHashMap.get("text_item_id"));
    }
    if (this.al.length() == 0)
    {
      this.al.append((String)paramHashMap.get("ai_color_frame_states"));
    }
    else
    {
      localStringBuilder = this.al;
      localStringBuilder.append(",");
      localStringBuilder.append((String)paramHashMap.get("ai_color_frame_states"));
    }
    paramHashMap = AEBaseReportParam.a().k(this.K.size());
    if (this.am.length() == 0)
    {
      this.am.append((String)paramHashMap.get("template_id"));
    }
    else
    {
      localStringBuilder = this.am;
      localStringBuilder.append(",");
      localStringBuilder.append((String)paramHashMap.get("template_id"));
    }
    if (this.an.length() == 0)
    {
      this.an.append((String)paramHashMap.get("text_id"));
      return;
    }
    StringBuilder localStringBuilder = this.an;
    localStringBuilder.append(",");
    localStringBuilder.append((String)paramHashMap.get("text_id"));
  }
  
  private static boolean a(Bitmap paramBitmap)
  {
    return (paramBitmap != null) && (!paramBitmap.isRecycled());
  }
  
  private byte[] a(Bitmap paramBitmap1, Bitmap paramBitmap2, MetaMaterial paramMetaMaterial)
  {
    Object localObject2 = new ByteArrayOutputStream();
    int k = FilterMetaMaterialKt.k(paramMetaMaterial);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("before: ");
    ((StringBuilder)localObject1).append(System.currentTimeMillis());
    ((StringBuilder)localObject1).append(", uploadMaxSize=");
    ((StringBuilder)localObject1).append(k);
    ((StringBuilder)localObject1).append(", src bitmap size=[");
    ((StringBuilder)localObject1).append(paramBitmap1.getWidth());
    ((StringBuilder)localObject1).append(", ");
    ((StringBuilder)localObject1).append(paramBitmap1.getHeight());
    ((StringBuilder)localObject1).append("]");
    AEQLog.b("AEEditorImageEditFragment", ((StringBuilder)localObject1).toString());
    localObject1 = a(paramBitmap1, k);
    BitmapUtils.recycle(paramBitmap1);
    ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 90, (OutputStream)localObject2);
    paramBitmap1 = new StringBuilder();
    paramBitmap1.append("after: ");
    paramBitmap1.append(System.currentTimeMillis());
    paramBitmap1.append(", scaled bitmap size=[");
    paramBitmap1.append(((Bitmap)localObject1).getWidth());
    paramBitmap1.append(", ");
    paramBitmap1.append(((Bitmap)localObject1).getHeight());
    paramBitmap1.append("]");
    AEQLog.b("AEEditorImageEditFragment", paramBitmap1.toString());
    localObject2 = ((ByteArrayOutputStream)localObject2).toByteArray();
    paramBitmap1 = new AEPbData.ImageStylizeRequest();
    int j = FilterMetaMaterialKt.l(paramMetaMaterial);
    int i = j;
    if (j == 0) {
      i = 1;
    }
    paramBitmap1.stylizeType.set(i, true);
    paramBitmap1.imgInfo.setHasFlag(true);
    paramBitmap1.imgInfo.imgWidth.set(((Bitmap)localObject1).getWidth());
    paramBitmap1.imgInfo.imgHeight.set(((Bitmap)localObject1).getHeight());
    paramBitmap1.imgInfo.imageRawData.set(ByteStringMicro.copyFrom((byte[])localObject2), true);
    if (paramBitmap2 != null) {
      a(paramBitmap1, paramBitmap2, k);
    }
    paramBitmap2 = FaceChangeUtils.detectFaceOrigin((Bitmap)localObject1);
    BitmapUtils.recycle((Bitmap)localObject1);
    boolean bool = false;
    if ((paramBitmap2 != null) && (paramBitmap2.getAllFacePoints() != null) && (!paramBitmap2.getAllFacePoints().isEmpty()))
    {
      paramBitmap2 = paramBitmap2.getAllFacePoints().iterator();
      while (paramBitmap2.hasNext())
      {
        paramMetaMaterial = (List)paramBitmap2.next();
        if (paramMetaMaterial != null)
        {
          localObject1 = new AEPbData.FaceInfo();
          ((AEPbData.FaceInfo)localObject1).setHasFlag(true);
          i = 0;
          while (i < paramMetaMaterial.size())
          {
            ((AEPbData.FaceInfo)localObject1).pos.add(Float.valueOf(((PointF)paramMetaMaterial.get(i)).x));
            ((AEPbData.FaceInfo)localObject1).pos.add(Float.valueOf(((PointF)paramMetaMaterial.get(i)).y));
            i += 1;
          }
          paramBitmap1.imgInfo.faceInfos.add((MessageMicro)localObject1);
        }
      }
      i = paramBitmap1.imgInfo.faceInfos.size();
      paramBitmap2 = paramBitmap1.imgInfo.hasFace;
      if (i > 0) {
        bool = true;
      }
      paramBitmap2.set(bool);
      paramBitmap1.imgInfo.faceNum.set(i);
    }
    else
    {
      paramBitmap1.imgInfo.hasFace.set(false);
    }
    paramBitmap1.setHasFlag(true);
    return paramBitmap1.toByteArray();
  }
  
  private void aa()
  {
    if (!TextUtils.isEmpty(af()))
    {
      AEQLog.b("AEEditorImageEditFragment", "psKey not empty.");
      return;
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    TicketManager localTicketManager = (TicketManager)((AppRuntime)localObject).getManager(2);
    localObject = ((AppRuntime)localObject).getAccount();
    AEEditorImageEditFragment.11 local11 = new AEEditorImageEditFragment.11(this);
    localTicketManager.getPskey((String)localObject, 16L, new String[] { "shadowai.qq.com" }, local11);
  }
  
  private void ab()
  {
    AEQLog.b("AEEditorImageEditFragment", "initTAVCutSession");
    this.H = new TAVCutImageSession();
    this.H.initSingleLightNode();
    SessionConfig localSessionConfig = new SessionConfig();
    localSessionConfig.setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
    localSessionConfig.setMinIntermediateRenderSize(this.ac.a());
    localSessionConfig.setMaxIntermediateRenderSize(this.ac.b());
    localSessionConfig.setMaxImageDecodeSize(this.ac.c());
    Object localObject = new StickerEditViewIconConfig();
    ((StickerEditViewIconConfig)localObject).setDeleteIconResId(2063925440);
    ((StickerEditViewIconConfig)localObject).setEditIconResId(2063925439);
    ((StickerEditViewIconConfig)localObject).setZoomIconResId(2063925441);
    localSessionConfig.setStickerEditViewIconConfig((StickerEditViewIconConfig)localObject);
    localObject = new ArrayList();
    int i = 0;
    while (i < this.M.size())
    {
      ((List)localObject).add(((AEEditorImageInfo)this.M.get(i)).d);
      i += 1;
    }
    localSessionConfig.setImageInitCropConfigs((List)localObject);
    this.H.setSessionConfig(localSessionConfig);
    this.H.setImagePaths(this.J);
    this.H.setStickerOperationCallback(new AEEditorImageEditFragment.12(this));
    this.H.init(getActivity());
    this.ap.a(this.J);
  }
  
  private void ac()
  {
    v();
    x();
    y();
    this.D.setScrollable(true);
  }
  
  private void ad()
  {
    a(2063991132, "SP_KEY_RED_POINT_TIME_STAMP", false);
    a(2063991129, "SP_KEY_RED_POINT_TIME_STAMP", false);
    a(2063991131, "SP_KEY_RED_POINT_TIME_STAMP", false);
    a(2063991133, "SP_KEY_RED_POINT_TIME_STAMP", false);
    a(2063991130, "SP_KEY_RED_POINT_TIME_STAMP", false);
  }
  
  @NotNull
  private HashMap<String, ArrayList<String>> ae()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onResponseBack... isGoBack:");
    ((StringBuilder)localObject1).append(this.au);
    AEQLog.b("[QcirclePublish]AEEditorImageEditFragment", ((StringBuilder)localObject1).toString());
    localObject1 = new HashMap();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[onResponseBack], imageOutPaths=");
    ((StringBuilder)localObject2).append(this.K);
    AEQLog.b("[QcirclePublish]AEEditorImageEditFragment", ((StringBuilder)localObject2).toString());
    localObject2 = this.K.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      ArrayList localArrayList = a(this.O, str);
      int i = this.K.indexOf(str);
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[onResponseBack], pathIndex=");
      ((StringBuilder)localObject3).append(i);
      AEQLog.b("[QcirclePublish]AEEditorImageEditFragment", ((StringBuilder)localObject3).toString());
      localObject3 = a(AEEditorAIFilterManager.a().b.f(), i);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onResponseBack], path=");
      localStringBuilder.append(str);
      localStringBuilder.append(" silentTextList:");
      localStringBuilder.append(localObject3);
      localStringBuilder.append(" cachedTextList:");
      localStringBuilder.append(localArrayList);
      AEQLog.b("[QcirclePublish]AEEditorImageEditFragment", localStringBuilder.toString());
      if ((localArrayList != null) && (!CollectionUtils.isEmpty(localArrayList))) {
        ((HashMap)localObject1).put(str, localArrayList);
      } else if ((localObject3 != null) && (!CollectionUtils.isEmpty((Collection)localObject3))) {
        ((HashMap)localObject1).put(str, localObject3);
      }
    }
    return localObject1;
  }
  
  private String af()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null)
    {
      QLog.e("AEEditorImageEditFragment", 1, "app is null");
      return "";
    }
    String str = localAppRuntime.getAccount();
    return ((TicketManager)localAppRuntime.getManager(2)).getPskey(str, "shadowai.qq.com");
  }
  
  private void ag()
  {
    AEEditorApplyAllLoadingView localAEEditorApplyAllLoadingView = new AEEditorApplyAllLoadingView(getActivity());
    this.i.addView(localAEEditorApplyAllLoadingView);
  }
  
  private void ah()
  {
    boolean bool = AECameraPrefsUtil.a().b("ae_editor_tool_bar_red_dot_text", false, 0);
    if (!bool) {
      AECameraPrefsUtil.a().a("ae_editor_tool_bar_red_dot_text", true, 0);
    }
    AEBaseReportParam.a().n().F = (bool ^ true);
    AEBaseDataReporter.a().r();
  }
  
  private int ai()
  {
    return this.J.size();
  }
  
  private void aj()
  {
    AEEditorImageRecord.a().a(this.J, this.K, this.P, this.ah.b, this.M, 2);
    Intent localIntent = new Intent();
    Object localObject1 = this.M;
    int j = 0;
    int i = j;
    if (localObject1 != null)
    {
      i = j;
      if (((List)localObject1).get(0) != null) {
        i = ((AEEditorImageInfo)this.M.get(0)).e;
      }
    }
    localObject1 = AEEditorClipContainer.a(i);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("exportFinishActivity: before imageOutPaths:");
    ((StringBuilder)localObject2).append(this.K);
    AEQLog.a("[QcirclePublish]AEEditorImageEditFragment", ((StringBuilder)localObject2).toString());
    AEEditorImageRecord.a().a(localIntent, this.K);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("exportFinishActivity: imageOutPaths:");
    ((StringBuilder)localObject2).append(this.K);
    AEQLog.a("[QcirclePublish]AEEditorImageEditFragment", ((StringBuilder)localObject2).toString());
    localObject2 = b(this.K);
    localIntent.putExtra("key_image_sucai_info", new AEEditorImageEditFragment.27(this, (String)localObject1));
    localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", (Serializable)localObject2);
    localIntent.putExtra("PhotoConst.PHOTO_PATHS", this.K);
    if ((getActivity() != null) && (getActivity().getIntent() != null)) {
      i = getActivity().getIntent().getIntExtra("editorFrom", -1);
    } else {
      i = -1;
    }
    localIntent.putExtra("editorFrom", i);
    getActivity().setResult(-1, localIntent);
    getActivity().finish();
  }
  
  private void ak()
  {
    if (this.ag == null) {
      return;
    }
    if (AECommonUtil.a(getActivity(), "AEEditorImageEditFragment"))
    {
      this.ag.setImageResource(2063925398);
      return;
    }
    this.ag.setImageResource(2130837921);
  }
  
  private boolean al()
  {
    Object localObject = this.J;
    if (localObject == null) {
      return false;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (!new File((String)((Iterator)localObject).next()).exists()) {
        return false;
      }
    }
    return true;
  }
  
  private int am()
  {
    return this.ac.d();
  }
  
  private void an()
  {
    if (QzoneConfig.isOpenFunctionSavePicToVideo())
    {
      ao();
      return;
    }
    ap();
  }
  
  private void ao()
  {
    if (this.H.mediaChanged())
    {
      f(false);
      return;
    }
    ar();
    as();
  }
  
  private void ap()
  {
    if (this.H.mediaChanged())
    {
      aq();
      return;
    }
    as();
  }
  
  private void aq()
  {
    Object localObject = getActivity();
    localObject = DialogUtil.a((Context)localObject, 230).setTitle(HardCodeUtil.a(2064187505)).setMessage(((Context)localObject).getString(2064187504)).setPositiveButton(((Context)localObject).getString(2064187461), new AEEditorImageEditFragment.30(this)).setNegativeButton(((Context)localObject).getString(2064187459), new AEEditorImageEditFragment.29(this));
    if (localObject != null) {}
    try
    {
      if (((QQCustomDialog)localObject).isShowing()) {
        break label88;
      }
      ((QQCustomDialog)localObject).show();
      return;
    }
    catch (Throwable localThrowable)
    {
      label84:
      break label84;
    }
    as();
    label88:
  }
  
  private void ar()
  {
    if (this.x == null)
    {
      QLog.w("AEEditorImageEditFragment", 1, "resetMediaModel... mediaModels == null");
      return;
    }
    int i = 0;
    while (i < this.x.size())
    {
      ((AEAlbumMediaBaseModel)this.x.get(i)).setPath(((AEAlbumMediaBaseModel)this.x.get(i)).getOriginPath());
      i += 1;
    }
  }
  
  private void as()
  {
    Bundle localBundle = getArguments();
    a(localBundle);
    b().b("AEEditorImageEdit", localBundle);
  }
  
  private void at()
  {
    try
    {
      if (this.H != null)
      {
        this.H.setBasePicActive(false);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private HashMap<String, LocalMediaInfo> b(ArrayList<String> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramArrayList.iterator();
    Object localObject1 = "";
    int i = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject2 = AELocalMediaInfoUtil.a(str);
      Object localObject3 = ((MediaClipModel)((MediaModel)this.H.getMediaModels().get(i)).getMediaResourceModel().getVideos().get(0)).getResource().getPath();
      Object localObject4 = BitmapUtil.getImageSize((String)localObject3);
      ((LocalMediaInfo)localObject2).mediaOriginHeight = ((Size)localObject4).getHeight();
      ((LocalMediaInfo)localObject2).mediaOriginWidth = ((Size)localObject4).getWidth();
      ((LocalMediaInfo)localObject2).mediaOriginSize = com.tencent.mobileqq.filemanager.util.FileUtil.f((String)localObject3);
      AEBaseDataReporter.a().b((LocalMediaInfo)localObject2);
      localObject3 = AELocalMediaInfoUtil.a((LocalMediaInfo)localObject2, getArguments().getString("material_id"), getArguments().getString("material_topic"), getArguments().getString("key_camera_material_name"), getArguments().getInt("ae_editor_is_show_take_same"), this.P.j(i));
      if (AEEditorAIFilterManager.a().b == null)
      {
        AEQLog.b("[QcirclePublish]AEEditorImageEditFragment", "[getImageInfo], silentBatchImageAIFilterProxy == null");
        localObject2 = a(this.O, str);
        if ((localObject2 != null) && (!CollectionUtils.isEmpty((Collection)localObject2)))
        {
          ((LocalMediaInfo)localObject3).aiTextLabel = ((ArrayList)localObject2);
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("[getImageInfo], cachedTextList=");
          ((StringBuilder)localObject4).append(localObject2);
          AEQLog.a("[QcirclePublish]AEEditorImageEditFragment", ((StringBuilder)localObject4).toString());
        }
      }
      else
      {
        localObject2 = a(this.O, str);
        int j = paramArrayList.indexOf(str);
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("[getImageInfo], index=");
        ((StringBuilder)localObject4).append(i);
        ((StringBuilder)localObject4).append(" path:");
        ((StringBuilder)localObject4).append(str);
        AEQLog.a("[QcirclePublish]AEEditorImageEditFragment", ((StringBuilder)localObject4).toString());
        localObject4 = a(AEEditorAIFilterManager.a().b.f(), j);
        if ((localObject2 != null) && (!CollectionUtils.isEmpty((Collection)localObject2)))
        {
          ((LocalMediaInfo)localObject3).aiTextLabel = ((ArrayList)localObject2);
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("[getImageInfo], cachedTextList=");
          ((StringBuilder)localObject4).append(localObject2);
          AEQLog.a("[QcirclePublish]AEEditorImageEditFragment", ((StringBuilder)localObject4).toString());
        }
        else if ((localObject4 != null) && (!CollectionUtils.isEmpty((Collection)localObject4)))
        {
          ((LocalMediaInfo)localObject3).aiTextLabel = ((ArrayList)localObject4);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[getImageInfo], silentTextList=");
          ((StringBuilder)localObject2).append(localObject4);
          AEQLog.a("[QcirclePublish]AEEditorImageEditFragment", ((StringBuilder)localObject2).toString());
        }
        this.au = true;
      }
      a((LocalMediaInfo)localObject3, ((MediaModel)this.H.getMediaModels().get(i)).getMediaEffectModel().getStickerModelList());
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = d(i);
        localObject2 = localObject1;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = localObject1;
          if (!((LocalMediaInfo)localObject3).mHashTagList.contains(localObject1))
          {
            ((LocalMediaInfo)localObject3).mHashTagList.add(localObject1);
            localObject2 = localObject1;
          }
        }
      }
      localHashMap.put(str, localObject3);
      i += 1;
      localObject1 = localObject2;
    }
    return localHashMap;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void b(View paramView)
  {
    AEQLog.b("AEEditorImageEditFragment", "initViews");
    this.D = ((AEEditorImageViewPager)paramView.findViewById(2063991611));
    this.F = ((NumberIndicator)paramView.findViewById(2063991287));
    this.G = ((FrameLayout)paramView.findViewById(2063991081));
    this.at = paramView.findViewById(2063990910);
    this.D.setOnPageChangeListener(this);
    this.G.setOnClickListener(new AEEditorImageEditFragment.3(this));
    this.at.setOnTouchListener(new AEEditorImageEditFragment.4(this));
    this.ae = ((FrameLayout)paramView.findViewById(2063990992));
    this.af = ((AEEditorClipPanel)paramView.findViewById(2063990813));
    this.af.setCropChangeCallBack(new AEEditorImageEditFragment.5(this));
    this.ae.setOnClickListener(new AEEditorImageEditFragment.6(this));
    this.ag = ((ImageView)paramView.findViewById(2063991045));
    ak();
    this.ag.setOnClickListener(new AEEditorImageEditFragment.7(this));
    g(this.ao);
    c(paramView);
    d(paramView);
  }
  
  private void b(List<ImageMainColorData> paramList)
  {
    if (CollectionUtil.isEmptyList(paramList)) {
      return;
    }
    Collections.sort(paramList, new AEEditorImageEditFragment.14(this));
  }
  
  private void c(View paramView)
  {
    this.ah = ((AEEditorImageTemplatePanel)paramView.findViewById(2063991137));
    this.ah.setTavCutImageSession(this.H);
    this.ah.setControlListener(this);
    this.ah.setImageInfos(this.M);
    this.ah.setTextViewModel(this.w, this.v);
    this.ah.setToastValidListener(this);
  }
  
  private String d(int paramInt, MetaMaterial paramMetaMaterial)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramMetaMaterial.id);
    return localStringBuilder.toString();
  }
  
  private void d(View paramView)
  {
    this.ai = ((AEEditorFramePanel)paramView.findViewById(2063991111));
    this.ai.setTavCutImageSession(this.H);
    this.ai.setControlListener(this);
    this.ai.setToastValidListener(this);
  }
  
  private void e(int paramInt)
  {
    this.Q.clear();
    if (this.P.m(paramInt))
    {
      this.P.n(paramInt);
      this.H.clearAEKitModel(paramInt);
      int i = this.P.b(paramInt);
      if (!CollectionUtils.indexOutOfBounds(this.g.getFilterMaterials(), i))
      {
        MetaMaterial localMetaMaterial = (MetaMaterial)this.g.getFilterMaterials().get(i);
        if (paramInt == this.I) {
          b(i, localMetaMaterial);
        }
      }
    }
  }
  
  private void f(int paramInt)
  {
    List localList = AEExtractColorUtil.a((List)this.T.get(paramInt), 6);
    this.ai.a(localList);
  }
  
  private void f(boolean paramBoolean)
  {
    AEQLog.b("AEEditorImageEditFragment", "exportImages");
    if (this.H == null)
    {
      AEQLog.d("AEEditorImageEditFragment", "exportImages error: session is null");
      return;
    }
    if (!al())
    {
      QQToast.makeText(getActivity(), "图片不存在或被删除", 0).show();
      return;
    }
    if (this.I + 1 < this.J.size()) {
      this.H.releaseTAVCutWithoutView(this.I + 1);
    }
    int i = this.I;
    if ((i - 1 >= 0) && (i - 1 < this.J.size())) {
      this.H.releaseTAVCutWithoutView(this.I - 1);
    }
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.25(this, paramBoolean));
    Object localObject1 = AEEditorPath.EDITOR.FILES.d;
    Object localObject2 = new File((String)localObject1);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    localObject2 = this.L;
    if (localObject2 != null)
    {
      ((ArrayList)localObject2).clear();
      this.L = null;
      this.L = new ArrayList();
    }
    else
    {
      this.L = new ArrayList();
    }
    i = 0;
    while (i < this.J.size())
    {
      localObject2 = new File((String)this.J.get(i));
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(File.separator);
      ((StringBuilder)localObject3).append("output_");
      ((StringBuilder)localObject3).append(i);
      ((StringBuilder)localObject3).append("_");
      ((StringBuilder)localObject3).append(System.currentTimeMillis());
      ((StringBuilder)localObject3).append("_");
      ((StringBuilder)localObject3).append(VideoFilterTools.d(((File)localObject2).getName()));
      ((StringBuilder)localObject3).append(".jpg");
      localObject2 = ((StringBuilder)localObject3).toString();
      this.L.add(localObject2);
      localObject3 = this.O;
      if (localObject3 != null)
      {
        localObject3 = (ArrayList)((HashMap)localObject3).get(String.valueOf(i));
        if (localObject3 != null)
        {
          this.O.remove(String.valueOf(i));
          this.O.put(localObject2, localObject3);
        }
      }
      i += 1;
    }
    localObject1 = new ImageExportConfig();
    this.H.applyCurrentSticker(this.I);
    ac();
    if (this.W == 0) {
      this.W = am();
    }
    ((ImageExportConfig)localObject1).setMaxExportSize(am());
    ((ImageExportConfig)localObject1).setMinIntermediateRenderSize(this.ac.a());
    ((ImageExportConfig)localObject1).setMaxIntermediateRenderSize(am());
    ((ImageExportConfig)localObject1).setQuality(this.ac.e());
    ((ImageExportConfig)localObject1).setOutputPath(this.L);
    ((ImageExportConfig)localObject1).setScreenSize(new CGSize(this.D.getWidth(), this.D.getHeight()));
    a((ImageExportConfig)localObject1);
    this.V = this.H.getExporter((ImageExportConfig)localObject1);
    this.K.clear();
    this.X = System.currentTimeMillis();
    this.aj = new StringBuilder();
    this.ak = new StringBuilder();
    this.al = new StringBuilder();
    this.am = new StringBuilder();
    this.an = new StringBuilder();
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).reportPublishQuality(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).pExportStart(), Arrays.asList(new FeedCloudCommon.Entry[] { ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).ext1(), "pic"), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).ext2(), this.J.toString()), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).ext3(), this.L.toString()), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).keyRetCode(), "0") }));
    this.V.export(new AEEditorImageEditFragment.26(this, paramBoolean), this.H.getEglContext(), this.H.getImageProcessThread(), this.H.getRenderContext(), this.H.getAeFilterManager());
  }
  
  private void g(int paramInt)
  {
    ThreadManager.getFileThreadHandler().post(new AEEditorImageEditFragment.13(this, paramInt));
  }
  
  private void g(boolean paramBoolean)
  {
    ImageView localImageView = this.ag;
    if (localImageView == null) {
      return;
    }
    if (paramBoolean)
    {
      localImageView.setVisibility(0);
      return;
    }
    localImageView.setVisibility(8);
  }
  
  private void h(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateImageFilterByIndex: ");
    localStringBuilder.append(paramInt);
    AEQLog.b("AEEditorImageEditFragment", localStringBuilder.toString());
    if ((this.P.c(paramInt) == -1) && (this.P.b(paramInt) == -1))
    {
      this.H.render(paramInt, new AEEditorImageEditFragment.15(this, paramInt));
      return;
    }
    if (this.P.l(paramInt))
    {
      this.H.resetAEKitModelForAI(paramInt, this.P.f(paramInt).b(), this.P.f(paramInt).c(), this.P.f(paramInt).d(), (int)(this.P.f(paramInt).e() * 100.0F), this.P.f(paramInt).f());
      return;
    }
    if (this.P.m(paramInt))
    {
      if (this.P.g(paramInt) != null)
      {
        this.H.setOverlayImage(paramInt, this.P.g(paramInt).a());
        return;
      }
      paramInt = this.P.b(paramInt);
      if (!CollectionUtils.indexOutOfBounds(this.g.getFilterMaterials(), paramInt)) {
        b(paramInt, (MetaMaterial)this.g.getFilterMaterials().get(paramInt));
      }
    }
    else
    {
      if (this.P.k(paramInt))
      {
        this.H.resetAEKitModel(paramInt, this.P.d(paramInt), this.P.e(paramInt));
        return;
      }
      i(paramInt);
    }
  }
  
  private void i(int paramInt)
  {
    if ((this.g != null) && (this.g.getFilterMaterials() != null))
    {
      Object localObject1 = this.g.getFilterMaterials();
      int i = this.P.b(paramInt);
      if (!CollectionUtils.indexOutOfBounds((Collection)localObject1, i))
      {
        Object localObject2 = (MetaMaterial)((List)localObject1).get(i);
        float f = FilterMetaMaterialKt.n((MetaMaterial)localObject2);
        localObject1 = FilterMetaMaterialKt.p((MetaMaterial)localObject2);
        localObject2 = AEEditorResourceManager.a().e((MetaMaterial)localObject2);
        this.H.resetAEKitModel(paramInt, this.P.e(paramInt), this.P.d(paramInt), f, (Map)localObject1, (String)localObject2);
      }
      return;
    }
    AEQLog.d("AEEditorImageEditFragment", "filter list null.");
  }
  
  private void j(int paramInt)
  {
    if ((this.g != null) && (this.g.getFilterMaterials() != null))
    {
      Object localObject1 = this.g.getFilterMaterials();
      int i = this.P.b(paramInt);
      if (!CollectionUtils.indexOutOfBounds((Collection)localObject1, i))
      {
        Object localObject2 = (MetaMaterial)((List)localObject1).get(i);
        float f = FilterMetaMaterialKt.n((MetaMaterial)localObject2);
        localObject1 = FilterMetaMaterialKt.p((MetaMaterial)localObject2);
        localObject2 = AEEditorResourceManager.a().e((MetaMaterial)localObject2);
        this.H.resetAllAeKitModelWithOutRender(this.P.e(paramInt), this.P.d(paramInt), f, (Map)localObject1, (String)localObject2);
      }
      return;
    }
    AEQLog.d("AEEditorImageEditFragment", "filter list null.");
  }
  
  private void k(int paramInt)
  {
    if (this.g == null) {
      return;
    }
    if (this.J.size() > 1)
    {
      List localList = this.g.getFilterMaterials();
      if (!CollectionUtils.indexOutOfBounds(localList, paramInt))
      {
        bool = FilterMetaMaterialKt.d((MetaMaterial)localList.get(paramInt));
        break label54;
      }
    }
    boolean bool = false;
    label54:
    if (bool) {
      b(true);
    } else if (!this.g.c()) {
      b(false);
    }
    this.g.b(bool);
  }
  
  private void l(int paramInt)
  {
    if (paramInt >= 1) {
      h(paramInt - 1);
    }
    if (paramInt < ai() - 1) {
      h(paramInt + 1);
    }
  }
  
  private void m(int paramInt)
  {
    AEQLog.a("AEEditorImageEditFragment", "update all data.");
    if (this.P.l(paramInt))
    {
      int i = 0;
      while (i < ai())
      {
        if (paramInt != i) {
          this.H.resetAEKitNodeForAIWithoutRender(i, this.P.f(i).b(), this.P.f(i).c(), this.P.f(i).d(), (int)(this.P.f(i).e() * 100.0F), this.P.f(i).f());
        }
        i += 1;
      }
    }
    if (this.P.m(paramInt)) {
      return;
    }
    j(paramInt);
  }
  
  protected FilterChangedComparator C()
  {
    return new AEEditorImageEditFragment.28(this);
  }
  
  public void E()
  {
    at();
    super.E();
  }
  
  public void F()
  {
    at();
    super.F();
  }
  
  public void G()
  {
    AEEditorImageRecord.a().b();
  }
  
  public void N()
  {
    new Handler(Looper.getMainLooper()).postDelayed(new AEEditorImageEditFragment.8(this), 100L);
  }
  
  protected void O()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSilentAIFilterRequest... imagePaths:");
    localStringBuilder.append(this.J);
    AEQLog.c("[QcirclePublish]AEEditorImageEditFragment", localStringBuilder.toString());
    AEEditorAIFilterManager.a().a(getActivity(), this.J, this.M, new AEEditorImageEditFragment.16(this));
  }
  
  public void P()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onApplyAll current position = ");
    ((StringBuilder)localObject1).append(this.I);
    AEQLog.b("AEEditorImageEditFragment", ((StringBuilder)localObject1).toString());
    AEBaseDataReporter.a().t();
    if (this.g.d())
    {
      localObject1 = this.J.iterator();
      int j;
      Object localObject2;
      do
      {
        boolean bool = ((Iterator)localObject1).hasNext();
        j = 0;
        if (!bool) {
          break label134;
        }
        localObject2 = (String)((Iterator)localObject1).next();
        localObject2 = this.N.a((String)localObject2);
        if ((localObject2 == null) || (!(localObject2 instanceof SingleImageAIFilterResult))) {
          break;
        }
        AEQLog.b("AEEditorImageEditFragment", "onAIFilterRequest: has cache");
      } while (!((AIFilterResult)localObject2).a);
      int i = 1;
      break label136;
      label134:
      i = 0;
      label136:
      if (i != 0)
      {
        A();
        localObject1 = this.J;
        localObject2 = this.M;
        i = this.I;
        localObject1 = new BatchImageAIFilterProxy((List)localObject1, (List)localObject2, i, this.N.a((String)((ArrayList)localObject1).get(i)));
        ((BatchImageAIFilterProxy)localObject1).a(this.B);
        AEEditorAIFilterManager.a().a(getActivity(), (AIFilterProxyBase)localObject1);
        return;
      }
      a(AEEditorFilterControlPanel.a);
      this.g.setSelectedIndex(this.g.getSelectedIndex(), true);
      localObject1 = new StringBuilder();
      i = j;
      while (i < ai())
      {
        localObject2 = (SingleImageAIFilterResult)this.N.a((String)this.J.get(i));
        this.P.a(i, (AIFilterResult)localObject2);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((SingleImageAIFilterResult)localObject2).a());
        localStringBuilder.append("|");
        ((StringBuilder)localObject1).append(localStringBuilder.toString());
        i += 1;
      }
      a("智能滤镜label", ((StringBuilder)localObject1).toString());
      h(this.I);
      l(this.I);
      m(this.I);
      ag();
      return;
    }
    if (this.g.e())
    {
      this.P.a();
      l(this.I);
      m(this.I);
      ag();
      return;
    }
    if (I()) {
      return;
    }
    this.P.h(this.I);
    l(this.I);
    m(this.I);
    ag();
  }
  
  public void Q()
  {
    D();
    a(-1);
    k(-1);
    this.H.clearAEKitModel(this.I);
    this.P.i(this.I);
    ViewUtils.setVisible(this.F, 0);
    AEBaseReportParam.a().n().e.put(Integer.valueOf(this.I), "none");
    AEBaseReportParam.a().n().f.put(Integer.valueOf(this.I), Float.valueOf(-1.0F));
  }
  
  public void R()
  {
    ViewUtils.setVisible(this.F, 4);
  }
  
  public void S()
  {
    ViewUtils.setVisible(this.F, 0);
  }
  
  public void T() {}
  
  public boolean U()
  {
    List localList = ((MediaModel)this.H.getMediaModels().get(this.H.getCurrentIndex())).getMediaEffectModel().getStickerModelList();
    int i = 0;
    while (i < localList.size())
    {
      if ((((StickerModel)localList.get(i)).getInteractive() > 0) && (((StickerModel)localList.get(i)).getMaterialId().startsWith("qiukuolie"))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public void V()
  {
    this.g.setSelectedIndex(-1, true);
    this.P.i(this.I);
    this.ai.a();
  }
  
  public void W()
  {
    Object localObject = (AEEditorImageInfo)this.M.get(this.I);
    if ((((AEEditorImageInfo)localObject).c != 0) && (((AEEditorImageInfo)localObject).b != 0))
    {
      double d = ((AEEditorImageInfo)localObject).b * 1.0F / ((AEEditorImageInfo)localObject).c;
      if (d <= 0.333333343267441D) {
        localObject = new CropConfig(0.0F, (((AEEditorImageInfo)localObject).c - ((AEEditorImageInfo)localObject).b / 0.3333333F) * 1.0F / 2.0F / ((AEEditorImageInfo)localObject).c, 1.0F, ((AEEditorImageInfo)localObject).b / 0.3333333F * 1.0F / ((AEEditorImageInfo)localObject).c);
      } else if (d >= 1.777777791023254D) {
        localObject = new CropConfig((((AEEditorImageInfo)localObject).b - ((AEEditorImageInfo)localObject).c * 1.777778F) * 1.0F / 2.0F / ((AEEditorImageInfo)localObject).b, 0.0F, ((AEEditorImageInfo)localObject).c * 1.777778F * 1.0F / ((AEEditorImageInfo)localObject).b, 1.0F);
      } else {
        localObject = new CropConfig(0.0F, 0.0F, 1.0F, 1.0F);
      }
      ((AEEditorImageInfo)this.M.get(this.I)).a((CropConfig)localObject);
      ((AEEditorImageInfo)this.M.get(this.I)).a(0);
      this.H.updateTemplateCrop(this.I, (CropConfig)localObject);
    }
  }
  
  public void X()
  {
    this.Q.clear();
  }
  
  public String a()
  {
    return "AEEditorImageEdit";
  }
  
  protected String a(ArrayList<String> paramArrayList)
  {
    String str1 = "";
    String str2 = str1;
    if (paramArrayList != null)
    {
      int i = 0;
      for (;;)
      {
        str2 = str1;
        if (i >= paramArrayList.size()) {
          break;
        }
        str1 = d(i);
        if (!TextUtils.isEmpty(str1)) {
          return str1;
        }
        i += 1;
      }
    }
    return str2;
  }
  
  public void a(int paramInt, float paramFloat)
  {
    this.H.setEffectStrength(this.I, paramFloat);
    this.P.a(this.I, paramFloat);
    this.P.a(this.I, paramInt, paramFloat);
    AEBaseReportParam.a().n().f.put(Integer.valueOf(this.I), Float.valueOf(paramFloat));
  }
  
  public void a(int paramInt, @Nullable MetaMaterial paramMetaMaterial)
  {
    a(paramInt);
    float f = this.P.e(this.I);
    this.g.setSeekBarValue(f);
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle.putString("key_image_to_multi_video_hashtag", a(this.K));
      paramBundle.putInt("ae_video_editor_entrance_id", 3);
    }
  }
  
  protected void a(Pair<Integer, String> paramPair)
  {
    if ((paramPair != null) && (paramPair.first != null))
    {
      if (paramPair.second == null) {
        return;
      }
      String str = (String)paramPair.second;
      int i = ((Integer)paramPair.first).intValue();
      if (i != 2)
      {
        if (i != 6)
        {
          super.a(paramPair);
          return;
        }
        if (this.ai.a(str)) {
          this.l.a(2063991373);
        }
      }
      else if (this.ah.a(str))
      {
        this.l.a(2063991221);
      }
    }
  }
  
  public void a(CropConfig paramCropConfig, int paramInt, Matrix paramMatrix)
  {
    int i = this.H.getCurrentIndex();
    ((AEEditorImageInfo)this.M.get(i)).a(paramCropConfig);
    ((AEEditorImageInfo)this.M.get(i)).a(paramInt);
    ((AEEditorImageInfo)this.M.get(i)).a(paramMatrix);
    this.H.updateTemplateCrop(i, paramCropConfig);
  }
  
  public void a(String paramString)
  {
    if (this.ah != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onTemplateSet, materialId=");
      localStringBuilder.append(paramString);
      AEQLog.b("AEEditorImageEditFragment", localStringBuilder.toString());
      if (!this.ah.a(paramString, false)) {
        this.ah.setSelectedIndex(-1);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, float paramFloat)
  {
    int i = this.g.a(paramString1);
    if (i == -1)
    {
      this.P.i(this.I);
      return;
    }
    this.P.a(this.I, paramString2, paramFloat, i);
    this.P.a(this.I, paramString1);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.ae.setVisibility(4);
      g(false);
      return;
    }
    this.ae.setVisibility(0);
    g(this.ao);
    AEReportUtils.g();
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    at();
    switch (this.aq)
    {
    default: 
      break;
    case 2063991380: 
      ViewUtils.setVisible(this.h, 8);
      break;
    case 2063991373: 
      ViewUtils.setVisible(this.ai, 8);
      break;
    case 2063991372: 
      ViewUtils.setVisible(this.g, 8);
      break;
    case 2063991222: 
      ViewUtils.setVisible(this.k, 8);
      break;
    case 2063991221: 
      ViewUtils.setVisible(this.ah, 8);
    }
    switch (paramInt)
    {
    default: 
      break;
    case 2063991380: 
      if (!paramBoolean) {
        x();
      }
      ViewUtils.setVisible(this.h, 0);
      AEReportUtils.c(true);
      a(2063991131, "SP_KEY_RED_POINT_TIME_STAMP", true);
      break;
    case 2063991373: 
      v();
      x();
      ViewUtils.setVisible(this.ai, 0);
      AEReportUtils.j();
      a(2063991130, "SP_KEY_RED_POINT_TIME_STAMP", true);
      break;
    case 2063991372: 
      ViewUtils.setVisible(this.g, 0);
      v();
      x();
      AEReportUtils.b(true);
      a(2063991129, "SP_KEY_RED_POINT_TIME_STAMP", true);
      break;
    case 2063991222: 
      if (!paramBoolean) {
        v();
      }
      ViewUtils.setVisible(this.k, 0);
      a(2063991133, "SP_KEY_RED_POINT_TIME_STAMP", true);
      break;
    case 2063991221: 
      ViewUtils.setVisible(this.ah, 0);
      v();
      x();
      AEReportUtils.i();
      a(2063991132, "SP_KEY_RED_POINT_TIME_STAMP", true);
    }
    this.aq = paramInt;
  }
  
  public void b(String paramString1, String paramString2)
  {
    this.ai.setSelectedIndex(paramString1, paramString2);
    this.ai.a(paramString1, paramString2);
  }
  
  protected void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    a(paramBoolean);
  }
  
  public boolean b(int paramInt)
  {
    AEEditorImageTemplatePanel localAEEditorImageTemplatePanel = this.ah;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localAEEditorImageTemplatePanel != null)
    {
      bool1 = bool2;
      if (this.ai != null) {
        if (!localAEEditorImageTemplatePanel.b(paramInt))
        {
          bool1 = bool2;
          if (!this.ai.c(paramInt)) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean b(int paramInt, MetaMaterial paramMetaMaterial)
  {
    int i = this.I;
    ComicsFilterResult localComicsFilterResult = (ComicsFilterResult)this.Q.get(d(i, paramMetaMaterial));
    if (localComicsFilterResult == null)
    {
      if (!NetworkUtil.isNetworkAvailable())
      {
        QQToast.makeText(getActivity(), getActivity().getResources().getString(2064187646), 1).show();
        return false;
      }
      this.Z = false;
      B();
      FaceChangeUtils.runInGLThread(new AEEditorImageEditFragment.17(this, i, paramInt, paramMetaMaterial), false, "GLThread-changeFaceSingle");
      return false;
    }
    AEQCircleReport localAEQCircleReport = AEQCircleReport.a();
    String str;
    if (paramMetaMaterial != null) {
      str = paramMetaMaterial.id;
    } else {
      str = "";
    }
    localAEQCircleReport.a(str, "", QCircleConstants.z, "0");
    a(i, localComicsFilterResult, paramInt, paramMetaMaterial);
    return true;
  }
  
  public void c(int paramInt, MetaMaterial paramMetaMaterial)
  {
    D();
    String str1 = AEEditorResourceManager.a().c(paramMetaMaterial);
    float f1 = FilterMetaMaterialKt.j(paramMetaMaterial);
    a(paramInt);
    k(paramInt);
    float f2 = this.P.b(this.I, paramInt, f1);
    this.g.setSeekBarValue(f2);
    this.P.a(this.I, str1, f2, paramInt);
    this.P.a(this.I, paramMetaMaterial.id);
    float f3 = FilterMetaMaterialKt.n(paramMetaMaterial);
    Object localObject = FilterMetaMaterialKt.p(paramMetaMaterial);
    String str2 = AEEditorResourceManager.a().e(paramMetaMaterial);
    this.H.resetAEKitModel(this.I, f2, str1, f3, (Map)localObject, str2);
    localObject = AEQCircleReport.a();
    if (paramMetaMaterial == null) {
      str1 = "";
    } else {
      str1 = paramMetaMaterial.id;
    }
    ((AEQCircleReport)localObject).a(str1, QCircleConstants.y, "0");
    AEBaseReportParam.a().n().e.put(Integer.valueOf(this.I), paramMetaMaterial.id);
    AEBaseReportParam.a().n().f.put(Integer.valueOf(this.I), Float.valueOf(f1));
  }
  
  public void c(boolean paramBoolean)
  {
    a(paramBoolean);
  }
  
  public boolean c()
  {
    if (!this.H.mediaChanged())
    {
      AEEditorImageRecord.a().b();
      H();
      return false;
    }
    return super.c();
  }
  
  public boolean c(int paramInt)
  {
    this.C = System.currentTimeMillis();
    Object localObject = this.N.a((String)this.J.get(this.I));
    boolean bool1;
    if ((localObject instanceof SingleImageAIFilterResult))
    {
      AEQLog.b("AEEditorImageEditFragment", "onAIFilterRequest: has cache");
      bool1 = ((SingleImageAIFilterResult)localObject).a;
    }
    else
    {
      bool1 = true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAIFilterRequest: needRequest=");
    localStringBuilder.append(bool1);
    AEQLog.b("AEEditorImageEditFragment", localStringBuilder.toString());
    boolean bool2 = false;
    if (bool1)
    {
      A();
      localObject = new SingleImageAIFilterProxy((String)this.J.get(this.I), this.M, this.I);
      ((SingleImageAIFilterProxy)localObject).a(this.A);
      AEEditorAIFilterManager.a().a(getActivity(), (AIFilterProxyBase)localObject);
    }
    else
    {
      a(paramInt);
      k(paramInt);
      this.g.setSelectedIndex(paramInt, true);
      this.P.a(this.I, (AIFilterResult)localObject);
      this.H.resetAEKitModelForAI(this.I, ((AIFilterResult)localObject).b(), ((AIFilterResult)localObject).c(), ((AIFilterResult)localObject).d(), (int)(((AIFilterResult)localObject).e() * 100.0F), ((AIFilterResult)localObject).f());
      a(new String[] { "智能滤镜label", ((AIFilterResult)localObject).a(), "智能滤镜errCode", "0" });
      AEQCircleReport.a().a(QCircleConstants.B, QCircleConstants.y, QCircleConstants.z, "0");
    }
    if (!bool1) {
      bool2 = true;
    }
    return bool2;
  }
  
  protected String d(int paramInt)
  {
    Object localObject2 = "";
    Object localObject1 = localObject2;
    Object localObject3;
    if (TextUtils.isEmpty(""))
    {
      localObject3 = this.ah;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = a(((AEEditorImageTemplatePanel)localObject3).c(paramInt), this.ah.getTemplateMaterials());
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (this.h != null)
      {
        localObject3 = this.H.getMediaModels();
        localObject2 = localObject1;
        if (paramInt >= 0)
        {
          localObject2 = localObject1;
          if (paramInt < ((List)localObject3).size()) {
            localObject2 = a(((MediaModel)((List)localObject3).get(paramInt)).getMediaEffectModel().getStickerModelList(), this.h.getStickerMaterials());
          }
        }
      }
    }
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (this.k != null)
      {
        localObject3 = this.H.getMediaModels();
        localObject1 = localObject2;
        if (paramInt >= 0)
        {
          localObject1 = localObject2;
          if (paramInt < ((List)localObject3).size()) {
            localObject1 = a(((MediaModel)((List)localObject3).get(paramInt)).getMediaEffectModel().getStickerModelList(), this.w.j());
          }
        }
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject3 = this.ai;
      localObject2 = localObject1;
      if (localObject3 != null) {
        localObject2 = a(((AEEditorFramePanel)localObject3).a(paramInt), this.ai.getFrameMaterials());
      }
    }
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (this.g != null)
      {
        localObject1 = localObject2;
        if (!this.P.k(paramInt)) {
          localObject1 = a(this.P.j(paramInt), this.g.getFilterMaterials());
        }
      }
    }
    return localObject1;
  }
  
  public void d() {}
  
  public void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.i == null) {
        return;
      }
      this.i.removeAllViews();
      this.j = new AEEditorLoadingView(getActivity());
      this.j.setLoadingListener(new AEEditorImageEditFragment.31(this));
      this.j.a(3);
      this.i.addView(this.j);
    }
    this.D.setScrollable(false);
  }
  
  public void e(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.32(this, paramBoolean));
  }
  
  protected void f()
  {
    AEQLog.b("AEEditorImageEditFragment", "initImageInfos");
    Object localObject1 = new ArrayList();
    Object localObject2 = getArguments();
    if (((Bundle)localObject2).containsKey("AEEditorConstants_CLIPPED_PIC_INFOS")) {
      localObject1 = (List)((Bundle)localObject2).getSerializable("AEEditorConstants_CLIPPED_PIC_INFOS");
    } else {
      AEQLog.d("AEEditorImageEditFragment", "no image crop infos");
    }
    this.x = ((ArrayList)getArguments().getSerializable("ae_album_selected_media_models"));
    this.ao = ((Bundle)localObject2).getBoolean("BUNDLE_KEY_CIRCLE_CAN_PICK_VIDEO", true);
    this.M = new ArrayList();
    this.J = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (EditorPicInfo)((Iterator)localObject1).next();
      CropConfig localCropConfig = new CropConfig((float)((EditorPicInfo)localObject2).x, (float)((EditorPicInfo)localObject2).y, (float)Math.min(((EditorPicInfo)localObject2).w, 1.0D), (float)((EditorPicInfo)localObject2).h);
      this.J.add(((EditorPicInfo)localObject2).picPath);
      this.M.add(new AEEditorImageInfo(((EditorPicInfo)localObject2).picPath, (int)((EditorPicInfo)localObject2).originPicWidth, (int)((EditorPicInfo)localObject2).originPicHeight, localCropConfig));
    }
    this.W = am();
    this.P.a(this.J.size());
    this.ab = AEThemeUtil.b();
  }
  
  public int g()
  {
    return 2064056440;
  }
  
  public String h()
  {
    return HardCodeUtil.a(2064187495);
  }
  
  protected AEEditorFilterControlPanel.FilterControlListener i()
  {
    return this;
  }
  
  protected AEEditorStickerPart.AEEditorTextDialogListener j()
  {
    return new AEEditorImageEditFragment.24(this);
  }
  
  protected void k()
  {
    AEEditorAIFilterManager.a().b();
  }
  
  protected void l()
  {
    this.Z = true;
  }
  
  protected void m()
  {
    u();
    Boolean localBoolean = L();
    NumberIndicator localNumberIndicator = this.F;
    int i;
    if ((localBoolean != null) && (localBoolean.booleanValue())) {
      i = 4;
    } else {
      i = 0;
    }
    ViewUtils.setVisible(localNumberIndicator, i);
    ah();
  }
  
  protected void n()
  {
    w();
    Boolean localBoolean = L();
    NumberIndicator localNumberIndicator = this.F;
    int i;
    if ((localBoolean != null) && (localBoolean.booleanValue())) {
      i = 4;
    } else {
      i = 0;
    }
    ViewUtils.setVisible(localNumberIndicator, i);
    ah();
  }
  
  protected void o()
  {
    TAVCutImageSession localTAVCutImageSession = this.H;
    if (localTAVCutImageSession != null) {
      localTAVCutImageSession.applyCurrentSticker(this.I);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AEQLog.b("AEEditorImageEditFragment", "onCreate");
    super.onCreate(paramBundle);
    this.ap = ((AEVideoEditViewModel)AEViewModelProviders.a(getActivity()).get(AEVideoEditViewModel.class));
    aa();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy()
  {
    AEQLog.b("AEEditorImageEditFragment", "onDestroy");
    super.onDestroy();
    FileUtils.delete(AEEditorPath.EDITOR.CACHE.d, false);
  }
  
  public void onDestroyView()
  {
    AEQLog.b("AEEditorImageEditFragment", "onDestroyView");
    super.onDestroyView();
    if (this.R != null) {
      ((IHttpEngineService)MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IHttpEngineService.class, "all")).cancelReq(this.R);
    }
    AEEditorResourceManager.a().f().removeObserver(this.ar);
    AEEditorResourceManager.a().e().removeObserver(this.as);
    this.I = 0;
    this.E.a();
    this.E = null;
    TAVCutImageSession localTAVCutImageSession = this.H;
    if (localTAVCutImageSession != null)
    {
      localTAVCutImageSession.release();
      this.H = null;
    }
    this.P.b();
    this.J.clear();
    this.M.clear();
    this.ah.c();
    this.ai.b();
    ad();
  }
  
  public void onDetach()
  {
    super.onDetach();
    AEEditorImageRecord.a().c();
    AEEditorImageRecord.a().d();
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    this.z = paramBoolean;
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 1)
    {
      this.H.applyCurrentSticker(this.I);
      v();
      x();
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPageSelected: ");
    localStringBuilder.append(paramInt);
    AEQLog.b("AEEditorImageEditFragment", localStringBuilder.toString());
    this.I = paramInt;
    g(paramInt);
    this.H.setCurrentIndex(this.I);
    this.F.setCurrentIndex(paramInt + 1);
    int i = this.P.b(this.I);
    this.g.setSelectedIndex(i);
    this.g.setSeekBarValue(this.P.e(this.I));
    if (i == -1) {
      this.g.a(false);
    }
    this.ah.a(paramInt);
    h(paramInt);
  }
  
  public void onSaveInstanceState(@NonNull Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle = b().a();
    if ((paramBundle != null) && (paramBundle == this)) {
      AEEditorImageRecord.a().a(this.J, this.K, this.P, this.ah.b, this.M, 1);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    AEQLog.b("AEEditorImageEditFragment", "onViewCreated");
    super.onViewCreated(paramView, paramBundle);
    AEQLog.b("AEEditorImageEditFragment", "init");
    this.r = new CustomHandler(Looper.getMainLooper(), this);
    ab();
    this.P.b();
    b(paramView);
    Y();
    Z();
    g(0);
    if (AEEditorResourceManager.a().m()) {
      O();
    }
    AEEditorImageRecord.a().a(this.H, getArguments(), this.J, this.w, this.v);
    paramView = ParamsUtil.a();
    int i = this.ac.a();
    int j = this.ac.b();
    paramBundle = new StringBuilder();
    paramBundle.append(this.ac.e());
    paramBundle.append("%");
    a(new String[] { "设备级别", paramView, "图片最小预览尺寸", String.valueOf(i), "图片最大预览尺寸", String.valueOf(j), "图片导出质量", paramBundle.toString(), "图片最大导出尺寸", String.valueOf(this.W) });
    AEReportUtils.t();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {}
  
  protected TAVCutSession p()
  {
    return this.H;
  }
  
  protected int q()
  {
    return -1;
  }
  
  public void r()
  {
    f(true);
  }
  
  protected boolean s()
  {
    return true;
  }
  
  public void u()
  {
    super.u();
    this.D.setScrollable(false);
    ViewUtils.setVisible(this.F, 4);
  }
  
  public void v()
  {
    super.v();
    ViewUtils.setVisible(this.F, 0);
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.22(this));
    this.h.a();
  }
  
  public void w()
  {
    super.w();
    this.D.setScrollable(false);
    ViewUtils.setVisible(this.F, 4);
  }
  
  public void x()
  {
    super.x();
    ViewUtils.setVisible(this.F, 0);
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.23(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImageEditFragment
 * JD-Core Version:    0.7.0.1
 */