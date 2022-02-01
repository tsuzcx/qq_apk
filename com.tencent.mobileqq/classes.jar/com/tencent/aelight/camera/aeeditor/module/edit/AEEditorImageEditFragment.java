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
import com.tencent.aelight.camera.aeeditor.module.clip.image.AEEditorCropperPanel;
import com.tencent.aelight.camera.aeeditor.module.clip.image.AEImageCropperContainer;
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
import com.tencent.qphone.base.util.QLog;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tavcut.bean.CropConfig;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.exporter.ImageExportConfig;
import com.tencent.tavcut.exporter.ImageExporter;
import com.tencent.tavcut.session.TAVCutImageSession;
import com.tencent.tavcut.session.TAVCutSession;
import com.tencent.tavcut.session.config.SessionConfig;
import com.tencent.tavcut.session.config.StickerEditViewIconConfig;
import com.tencent.tavcut.util.BitmapUtil;
import com.tencent.tavcut.util.Logger;
import com.tencent.tavcut.util.Util;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.effect.StickerModel;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import common.config.service.QzoneConfig;
import feedcloud.FeedCloudCommon.Entry;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
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

public class AEEditorImageEditFragment
  extends AEEditorCommonEditFragment
  implements Handler.Callback, ViewPager.OnPageChangeListener, AEEditorFilterControlPanel.ImageFilterControlListener, ImageTemplateControlListener
{
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private Observer<List<MetaCategory>> jdField_a_of_type_AndroidxLifecycleObserver;
  AEEditorAIFilterManager.AIFilterObserver jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAifilterAEEditorAIFilterManager$AIFilterObserver = new AEEditorImageEditFragment.20(this);
  private AIFilterDataCache jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAifilterAIFilterDataCache = new AIFilterDataCache();
  private BatchImageAIFilterResult jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAifilterBatchImageAIFilterResult;
  private AEEditorCropperPanel jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEEditorCropperPanel;
  private AEEditorImagePagerAdapter jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImagePagerAdapter;
  private AEEditorImageViewPager jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageViewPager;
  private AEVideoEditViewModel jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEVideoEditViewModel;
  private ImageFilterInfoCache jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache = new ImageFilterInfoCache();
  private AEEditorFramePanel jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFrameAEEditorFramePanel;
  private AEEditorImageTemplatePanel jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel;
  private ImageParamStrategy jdField_a_of_type_ComTencentAelightCameraAeeditorModuleParamsImageParamStrategy = ParamFactory.a();
  private NumberIndicator jdField_a_of_type_ComTencentAelightCameraAeeditorViewNumberIndicator;
  private HttpNetReq jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq;
  private ImageExporter jdField_a_of_type_ComTencentTavcutExporterImageExporter;
  private TAVCutImageSession jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private HashMap<String, ArrayList<String>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<AEEditorImageInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<String, ComicsFilterResult> jdField_a_of_type_JavaUtilMap = new HashMap();
  private long jdField_b_of_type_Long;
  private SparseArray<List<ImageMainColorData>> jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  private Observer<List<MetaCategory>> jdField_b_of_type_AndroidxLifecycleObserver;
  AEEditorAIFilterManager.AIFilterObserver jdField_b_of_type_ComTencentAelightCameraAeeditorModuleAifilterAEEditorAIFilterManager$AIFilterObserver = new AEEditorImageEditFragment.21(this);
  private String jdField_b_of_type_JavaLangString = "";
  private StringBuilder jdField_b_of_type_JavaLangStringBuilder;
  private ArrayList<String> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long;
  private SparseArray<List<ImageMainColorData>> jdField_c_of_type_AndroidUtilSparseArray = new SparseArray();
  private FrameLayout jdField_c_of_type_AndroidWidgetFrameLayout;
  private StringBuilder jdField_c_of_type_JavaLangStringBuilder;
  private ArrayList<String> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int;
  private SparseArray<String> jdField_d_of_type_AndroidUtilSparseArray = new SparseArray();
  private StringBuilder jdField_d_of_type_JavaLangStringBuilder;
  private ArrayList<String> jdField_d_of_type_JavaUtilArrayList;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = -1;
  private StringBuilder jdField_e_of_type_JavaLangStringBuilder;
  private boolean jdField_e_of_type_Boolean = false;
  private boolean f = true;
  private boolean g = true;
  
  private void H()
  {
    QLog.d("AEEditorImageEditFragment", 1, "registerObserverData...");
    this.jdField_a_of_type_AndroidxLifecycleObserver = new AEEditorImageEditFragment.1(this);
    AEEditorResourceManager.a().c().observeForever(this.jdField_a_of_type_AndroidxLifecycleObserver);
    this.jdField_b_of_type_AndroidxLifecycleObserver = new AEEditorImageEditFragment.2(this);
    AEEditorResourceManager.a().b().observe(getViewLifecycleOwner(), this.jdField_b_of_type_AndroidxLifecycleObserver);
  }
  
  private void I()
  {
    AEQLog.b("AEEditorImageEditFragment", "showImages");
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImagePagerAdapter = new AEEditorImagePagerAdapter(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession, this.jdField_b_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaUtilList, this.jdField_d_of_type_AndroidUtilSparseArray, new AEEditorImageEditFragment.9(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewNumberIndicator.setTotalCount(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImagePagerAdapter.getCount());
    NumberIndicator localNumberIndicator = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewNumberIndicator;
    int i;
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImagePagerAdapter.getCount() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    localNumberIndicator.setCurrentIndex(i);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageViewPager.setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImagePagerAdapter);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageViewPager.post(new AEEditorImageEditFragment.10(this));
  }
  
  private void J()
  {
    if (!TextUtils.isEmpty(d()))
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
  
  private void K()
  {
    AEQLog.b("AEEditorImageEditFragment", "initTAVCutSession");
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession = new TAVCutImageSession();
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.initSingleLightNode();
    SessionConfig localSessionConfig = new SessionConfig();
    localSessionConfig.setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
    localSessionConfig.setMinIntermediateRenderSize(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleParamsImageParamStrategy.a());
    localSessionConfig.setMaxIntermediateRenderSize(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleParamsImageParamStrategy.b());
    localSessionConfig.setMaxImageDecodeSize(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleParamsImageParamStrategy.c());
    Object localObject = new StickerEditViewIconConfig();
    ((StickerEditViewIconConfig)localObject).setDeleteIconResId(2064056472);
    ((StickerEditViewIconConfig)localObject).setEditIconResId(2064056471);
    ((StickerEditViewIconConfig)localObject).setZoomIconResId(2064056473);
    localSessionConfig.setStickerEditViewIconConfig((StickerEditViewIconConfig)localObject);
    localObject = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((List)localObject).add(((AEEditorImageInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_ComTencentTavcutBeanCropConfig);
      i += 1;
    }
    localSessionConfig.setImageInitCropConfigs((List)localObject);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setSessionConfig(localSessionConfig);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setImagePaths(this.jdField_b_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setStickerOperationCallback(new AEEditorImageEditFragment.12(this));
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.init(getActivity());
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEVideoEditViewModel.a(this.jdField_b_of_type_JavaUtilArrayList);
  }
  
  private void L()
  {
    l();
    n();
    o();
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageViewPager.setScrollable(true);
  }
  
  private void M()
  {
    a(2064122258, "SP_KEY_RED_POINT_TIME_STAMP", false);
    a(2064122255, "SP_KEY_RED_POINT_TIME_STAMP", false);
    a(2064122257, "SP_KEY_RED_POINT_TIME_STAMP", false);
    a(2064122259, "SP_KEY_RED_POINT_TIME_STAMP", false);
    a(2064122256, "SP_KEY_RED_POINT_TIME_STAMP", false);
  }
  
  private void N()
  {
    AEEditorApplyAllLoadingView localAEEditorApplyAllLoadingView = new AEEditorApplyAllLoadingView(getActivity());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localAEEditorApplyAllLoadingView);
  }
  
  private void O()
  {
    boolean bool = AECameraPrefsUtil.a().a("ae_editor_tool_bar_red_dot_text", false, 0);
    if (!bool) {
      AECameraPrefsUtil.a().a("ae_editor_tool_bar_red_dot_text", true, 0);
    }
    AEBaseReportParam.a().a().i = (bool ^ true);
    AEBaseDataReporter.a().q();
  }
  
  private void P()
  {
    AEEditorImageRecord.a().a(this.jdField_b_of_type_JavaUtilArrayList, this.jdField_c_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel.a, this.jdField_a_of_type_JavaUtilList, 2);
    Intent localIntent = new Intent();
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    int j = 0;
    int i = j;
    if (localObject != null)
    {
      i = j;
      if (((List)localObject).get(0) != null) {
        i = ((AEEditorImageInfo)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_c_of_type_Int;
      }
    }
    localObject = AEImageCropperContainer.a(i);
    HashMap localHashMap = a(this.jdField_c_of_type_JavaUtilArrayList);
    localIntent.putExtra("key_image_sucai_info", new AEEditorImageEditFragment.27(this, (String)localObject));
    localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", localHashMap);
    AEEditorImageRecord.a().a(localIntent, this.jdField_c_of_type_JavaUtilArrayList);
    localIntent.putExtra("PhotoConst.PHOTO_PATHS", this.jdField_c_of_type_JavaUtilArrayList);
    if ((getActivity() != null) && (getActivity().getIntent() != null)) {
      i = getActivity().getIntent().getIntExtra("editorFrom", -1);
    } else {
      i = -1;
    }
    localIntent.putExtra("editorFrom", i);
    getActivity().setResult(-1, localIntent);
    getActivity().finish();
  }
  
  private void Q()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (AECommonUtil.a(getActivity(), "AEEditorImageEditFragment"))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2064056429);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837758);
  }
  
  private void R()
  {
    if (QzoneConfig.isOpenFunctionSavePicToVideo())
    {
      S();
      return;
    }
    T();
  }
  
  private void S()
  {
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.mediaChanged())
    {
      f(false);
      return;
    }
    V();
    W();
  }
  
  private void T()
  {
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.mediaChanged())
    {
      U();
      return;
    }
    W();
  }
  
  private void U()
  {
    Object localObject = getActivity();
    localObject = DialogUtil.a((Context)localObject, 230).setTitle(HardCodeUtil.a(2064515163)).setMessage(((Context)localObject).getString(2064515162)).setPositiveButton(((Context)localObject).getString(2064515119), new AEEditorImageEditFragment.30(this)).setNegativeButton(((Context)localObject).getString(2064515117), new AEEditorImageEditFragment.29(this));
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
    W();
    label88:
  }
  
  private void V()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      QLog.w("AEEditorImageEditFragment", 1, "resetMediaModel... mediaModels == null");
      return;
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((AEAlbumMediaBaseModel)this.jdField_a_of_type_JavaUtilArrayList.get(i)).setPath(((AEAlbumMediaBaseModel)this.jdField_a_of_type_JavaUtilArrayList.get(i)).getOriginPath());
      i += 1;
    }
  }
  
  private void W()
  {
    Bundle localBundle = getArguments();
    a(localBundle);
    a().b("AEEditorImageEdit", localBundle);
  }
  
  private void X()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession != null)
      {
        this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setBasePicActive(false);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
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
    float f1 = 1.0F;
    if (k > i) {
      f1 = i * 1.0F / k;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(f1, f1);
    return Bitmap.createBitmap(paramBitmap, 0, 0, paramInt, j, localMatrix, true);
  }
  
  private Bitmap a(String paramString, CropConfig paramCropConfig)
  {
    int j;
    try
    {
      localObject = BitmapUtil.getImageSize(paramString, false);
      Size localSize = Util.constrainMaxSize((Size)localObject, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleParamsImageParamStrategy.c());
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
  
  private String a(int paramInt, MetaMaterial paramMetaMaterial)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramMetaMaterial.id);
    return localStringBuilder.toString();
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
        BitmapUtil.saveBitmap(paramArrayOfByte, 100, paramMetaMaterial);
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
    if ((paramBatchImageAIFilterResult != null) && (!CollectionUtils.isEmpty(paramBatchImageAIFilterResult.jdField_a_of_type_JavaUtilList)) && (paramInt >= 0))
    {
      if (paramBatchImageAIFilterResult.jdField_a_of_type_JavaUtilList.size() <= paramInt) {
        return null;
      }
      paramBatchImageAIFilterResult = (SingleImageAIFilterResult)new LinkedList(paramBatchImageAIFilterResult.jdField_a_of_type_JavaUtilList).get(paramInt);
      if (paramBatchImageAIFilterResult != null)
      {
        if (CollectionUtils.isEmpty(paramBatchImageAIFilterResult.jdField_a_of_type_JavaUtilList)) {
          return null;
        }
        Object localObject = new LinkedList(paramBatchImageAIFilterResult.jdField_a_of_type_JavaUtilList);
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
  
  private HashMap<String, LocalMediaInfo> a(ArrayList<String> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramArrayList.iterator();
    Object localObject1 = "";
    int i = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject2 = AELocalMediaInfoUtil.a(str);
      Object localObject3 = ((MediaClipModel)((MediaModel)this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.getMediaModels().get(i)).getMediaResourceModel().getVideos().get(0)).getResource().getPath();
      Object localObject4 = BitmapUtil.getImageSize((String)localObject3);
      ((LocalMediaInfo)localObject2).mediaOriginHeight = ((Size)localObject4).getHeight();
      ((LocalMediaInfo)localObject2).mediaOriginWidth = ((Size)localObject4).getWidth();
      ((LocalMediaInfo)localObject2).mediaOriginSize = com.tencent.mobileqq.filemanager.util.FileUtil.a((String)localObject3);
      AEBaseDataReporter.a().b((LocalMediaInfo)localObject2);
      localObject3 = AELocalMediaInfoUtil.a((LocalMediaInfo)localObject2, getArguments().getString("material_id"), getArguments().getString("material_topic"), getArguments().getString("key_camera_material_name"), getArguments().getInt("ae_editor_is_show_take_same"), this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.b(i));
      localObject2 = a(this.jdField_a_of_type_JavaUtilHashMap, str);
      int j = paramArrayList.indexOf(str);
      localObject4 = a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAifilterBatchImageAIFilterResult, j);
      if ((localObject2 != null) && (!CollectionUtils.isEmpty((Collection)localObject2))) {
        ((LocalMediaInfo)localObject3).aiTextLabel = ((ArrayList)localObject2);
      } else if ((localObject4 != null) && (!CollectionUtils.isEmpty((Collection)localObject4))) {
        ((LocalMediaInfo)localObject3).aiTextLabel = ((ArrayList)localObject4);
      }
      a((LocalMediaInfo)localObject3, ((MediaModel)this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.getMediaModels().get(i)).getMediaEffectModel().getStickerModelList());
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = a(i);
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
  
  private void a(int paramInt1, ComicsFilterResult paramComicsFilterResult, int paramInt2, MetaMaterial paramMetaMaterial)
  {
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.19(this, paramInt2, paramInt1, paramComicsFilterResult, paramMetaMaterial));
  }
  
  private void a(Bitmap paramBitmap, int paramInt1, int paramInt2, MetaMaterial paramMetaMaterial)
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = new AEEditorImageEditFragment.18(this, paramInt1, paramMetaMaterial, paramInt2);
    localHttpNetReq.mReqUrl = "https://api.shadowai.qq.com/trpc.mobile_qq_http.mobile_qq_http_cgi.MobileQQHttpCgi/ImageStylize";
    localHttpNetReq.mHttpMethod = 1;
    localHttpNetReq.mExcuteTimeLimit = 30000L;
    localHttpNetReq.mSendData = a(paramBitmap, paramMetaMaterial);
    localHttpNetReq.mPrioty = 0;
    localHttpNetReq.mReqProperties.put("Content-Type", "application/proto; charset=UTF-8");
    localHttpNetReq.mReqProperties.put("Accept", "application/proto");
    paramBitmap = BaseApplicationImpl.getApplication().getRuntime();
    if (paramBitmap == null)
    {
      QLog.e("AEEditorImageEditFragment", 1, "app is null");
      return;
    }
    Object localObject = (TicketManager)paramBitmap.getManager(2);
    paramBitmap = paramBitmap.getAccount();
    paramMetaMaterial = ((TicketManager)localObject).getSkey(paramBitmap);
    localObject = ((TicketManager)localObject).getPskey(paramBitmap, "shadowai.qq.com");
    StringBuilder localStringBuilder;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramMetaMaterial = localHttpNetReq.mReqProperties;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("uin=");
      localStringBuilder.append(paramBitmap);
      localStringBuilder.append(";pskey=");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(";qqversion=");
      localStringBuilder.append("8.7.0");
      localStringBuilder.append(";aekitversion=");
      localStringBuilder.append("2.2.6.40");
      localStringBuilder.append(";platform=");
      localStringBuilder.append("Android");
      paramMetaMaterial.put("Cookie", localStringBuilder.toString());
    }
    else
    {
      J();
      localObject = localHttpNetReq.mReqProperties;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("uin=");
      localStringBuilder.append(paramBitmap);
      localStringBuilder.append(";skey=");
      localStringBuilder.append(paramMetaMaterial);
      localStringBuilder.append(";qqversion=");
      localStringBuilder.append("8.7.0");
      localStringBuilder.append(";aekitversion=");
      localStringBuilder.append("2.2.6.40");
      localStringBuilder.append(";platform=");
      localStringBuilder.append("Android");
      ((HashMap)localObject).put("Cookie", localStringBuilder.toString());
    }
    localHttpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    ((IHttpEngineService)MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IHttpEngineService.class, "all")).sendReq(localHttpNetReq);
    this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = localHttpNetReq;
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
    if (this.jdField_a_of_type_JavaLangStringBuilder.length() == 0)
    {
      this.jdField_a_of_type_JavaLangStringBuilder.append((String)paramHashMap.get("filter_id"));
    }
    else
    {
      localStringBuilder = this.jdField_a_of_type_JavaLangStringBuilder;
      localStringBuilder.append(",");
      localStringBuilder.append((String)paramHashMap.get("filter_id"));
    }
    if (this.jdField_b_of_type_JavaLangStringBuilder.length() == 0)
    {
      this.jdField_b_of_type_JavaLangStringBuilder.append((String)paramHashMap.get("text_item_id"));
    }
    else
    {
      localStringBuilder = this.jdField_b_of_type_JavaLangStringBuilder;
      localStringBuilder.append(",");
      localStringBuilder.append((String)paramHashMap.get("text_item_id"));
    }
    if (this.jdField_c_of_type_JavaLangStringBuilder.length() == 0)
    {
      this.jdField_c_of_type_JavaLangStringBuilder.append((String)paramHashMap.get("ai_color_frame_states"));
    }
    else
    {
      localStringBuilder = this.jdField_c_of_type_JavaLangStringBuilder;
      localStringBuilder.append(",");
      localStringBuilder.append((String)paramHashMap.get("ai_color_frame_states"));
    }
    paramHashMap = AEBaseReportParam.a().b(this.jdField_c_of_type_JavaUtilArrayList.size());
    if (this.jdField_d_of_type_JavaLangStringBuilder.length() == 0)
    {
      this.jdField_d_of_type_JavaLangStringBuilder.append((String)paramHashMap.get("template_id"));
    }
    else
    {
      localStringBuilder = this.jdField_d_of_type_JavaLangStringBuilder;
      localStringBuilder.append(",");
      localStringBuilder.append((String)paramHashMap.get("template_id"));
    }
    if (this.jdField_e_of_type_JavaLangStringBuilder.length() == 0)
    {
      this.jdField_e_of_type_JavaLangStringBuilder.append((String)paramHashMap.get("text_id"));
      return;
    }
    StringBuilder localStringBuilder = this.jdField_e_of_type_JavaLangStringBuilder;
    localStringBuilder.append(",");
    localStringBuilder.append((String)paramHashMap.get("text_id"));
  }
  
  private static boolean a(Bitmap paramBitmap)
  {
    return (paramBitmap != null) && (!paramBitmap.isRecycled());
  }
  
  private byte[] a(Bitmap paramBitmap, MetaMaterial paramMetaMaterial)
  {
    Object localObject2 = new ByteArrayOutputStream();
    int i = FilterMetaMaterialKt.c(paramMetaMaterial);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("before: ");
    ((StringBuilder)localObject1).append(System.currentTimeMillis());
    ((StringBuilder)localObject1).append(", uploadMaxSize=");
    ((StringBuilder)localObject1).append(i);
    ((StringBuilder)localObject1).append(", src bitmap size=[");
    ((StringBuilder)localObject1).append(paramBitmap.getWidth());
    ((StringBuilder)localObject1).append(", ");
    ((StringBuilder)localObject1).append(paramBitmap.getHeight());
    ((StringBuilder)localObject1).append("]");
    AEQLog.b("AEEditorImageEditFragment", ((StringBuilder)localObject1).toString());
    localObject1 = a(paramBitmap, i);
    BitmapUtils.recycle(paramBitmap);
    ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 90, (OutputStream)localObject2);
    paramBitmap = new StringBuilder();
    paramBitmap.append("after: ");
    paramBitmap.append(System.currentTimeMillis());
    paramBitmap.append(", scaled bitmap size=[");
    paramBitmap.append(((Bitmap)localObject1).getWidth());
    paramBitmap.append(", ");
    paramBitmap.append(((Bitmap)localObject1).getHeight());
    paramBitmap.append("]");
    AEQLog.b("AEEditorImageEditFragment", paramBitmap.toString());
    localObject2 = ((ByteArrayOutputStream)localObject2).toByteArray();
    paramBitmap = new AEPbData.ImageStylizeRequest();
    int j = FilterMetaMaterialKt.d(paramMetaMaterial);
    i = j;
    if (j == 0) {
      i = 1;
    }
    paramBitmap.stylizeType.set(i, true);
    paramBitmap.imgInfo.setHasFlag(true);
    paramBitmap.imgInfo.imgWidth.set(((Bitmap)localObject1).getWidth());
    paramBitmap.imgInfo.imgHeight.set(((Bitmap)localObject1).getHeight());
    paramBitmap.imgInfo.imageRawData.set(ByteStringMicro.copyFrom((byte[])localObject2), true);
    paramMetaMaterial = FaceChangeUtils.detectFaceOrigin((Bitmap)localObject1);
    BitmapUtils.recycle((Bitmap)localObject1);
    boolean bool = false;
    if ((paramMetaMaterial != null) && (paramMetaMaterial.getAllFacePoints() != null) && (!paramMetaMaterial.getAllFacePoints().isEmpty()))
    {
      paramMetaMaterial = paramMetaMaterial.getAllFacePoints().iterator();
      while (paramMetaMaterial.hasNext())
      {
        localObject1 = (List)paramMetaMaterial.next();
        if (localObject1 != null)
        {
          localObject2 = new AEPbData.FaceInfo();
          ((AEPbData.FaceInfo)localObject2).setHasFlag(true);
          i = 0;
          while (i < ((List)localObject1).size())
          {
            ((AEPbData.FaceInfo)localObject2).pos.add(Float.valueOf(((PointF)((List)localObject1).get(i)).x));
            ((AEPbData.FaceInfo)localObject2).pos.add(Float.valueOf(((PointF)((List)localObject1).get(i)).y));
            i += 1;
          }
          paramBitmap.imgInfo.faceInfos.add((MessageMicro)localObject2);
        }
      }
      i = paramBitmap.imgInfo.faceInfos.size();
      paramMetaMaterial = paramBitmap.imgInfo.hasFace;
      if (i > 0) {
        bool = true;
      }
      paramMetaMaterial.set(bool);
      paramBitmap.imgInfo.faceNum.set(i);
    }
    else
    {
      paramBitmap.imgInfo.hasFace.set(false);
    }
    paramBitmap.setHasFlag(true);
    return paramBitmap.toByteArray();
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.c(paramInt))
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.d(paramInt);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.clearAEKitModel(paramInt);
      int i = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.a(paramInt);
      if (!CollectionUtils.indexOutOfBounds(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel.a(), i))
      {
        MetaMaterial localMetaMaterial = (MetaMaterial)this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel.a().get(i);
        if (paramInt == this.jdField_c_of_type_Int) {
          a(i, localMetaMaterial);
        }
      }
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void b(View paramView)
  {
    AEQLog.b("AEEditorImageEditFragment", "initViews");
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageViewPager = ((AEEditorImageViewPager)paramView.findViewById(2064122838));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewNumberIndicator = ((NumberIndicator)paramView.findViewById(2064122461));
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2064122202));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2064121984);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageViewPager.setOnPageChangeListener(this);
    this.jdField_b_of_type_AndroidWidgetFrameLayout.setOnClickListener(new AEEditorImageEditFragment.3(this));
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new AEEditorImageEditFragment.4(this));
    this.jdField_c_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2064122078));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEEditorCropperPanel = ((AEEditorCropperPanel)paramView.findViewById(2064121886));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEEditorCropperPanel.setCropChangeCallBack(new AEEditorImageEditFragment.5(this));
    this.jdField_c_of_type_AndroidWidgetFrameLayout.setOnClickListener(new AEEditorImageEditFragment.6(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2064122155));
    Q();
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new AEEditorImageEditFragment.7(this));
    g(this.g);
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
  
  private int c()
  {
    return this.jdField_b_of_type_JavaUtilArrayList.size();
  }
  
  private void c(int paramInt)
  {
    List localList = AEExtractColorUtil.a((List)this.jdField_c_of_type_AndroidUtilSparseArray.get(paramInt), 6);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFrameAEEditorFramePanel.a(localList);
  }
  
  private void c(View paramView)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel = ((AEEditorImageTemplatePanel)paramView.findViewById(2064122262));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel.setTavCutImageSession(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel.setControlListener(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel.setImageInfos(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel.setTextViewModel(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextViewModel, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerViewModel);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel.setToastValidListener(this);
  }
  
  private int d()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleParamsImageParamStrategy.d();
  }
  
  private String d()
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
  
  private void d(int paramInt)
  {
    ThreadManager.getFileThreadHandler().post(new AEEditorImageEditFragment.13(this, paramInt));
  }
  
  private void d(View paramView)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFrameAEEditorFramePanel = ((AEEditorFramePanel)paramView.findViewById(2064122229));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFrameAEEditorFramePanel.setTavCutImageSession(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFrameAEEditorFramePanel.setControlListener(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFrameAEEditorFramePanel.setToastValidListener(this);
  }
  
  private void e(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateImageFilterByIndex: ");
    localStringBuilder.append(paramInt);
    AEQLog.b("AEEditorImageEditFragment", localStringBuilder.toString());
    if ((this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.b(paramInt) == -1) && (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.a(paramInt) == -1))
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.render(paramInt, new AEEditorImageEditFragment.15(this, paramInt));
      return;
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.b(paramInt))
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.resetAEKitModelForAI(paramInt, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.a(paramInt).b(), this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.a(paramInt).a(), this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.a(paramInt).a(), (int)(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.a(paramInt).b() * 100.0F), this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.a(paramInt).c());
      return;
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.c(paramInt))
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.a(paramInt) != null)
      {
        this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setOverlayImage(paramInt, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.a(paramInt).a());
        return;
      }
      paramInt = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.a(paramInt);
      if (!CollectionUtils.indexOutOfBounds(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel.a(), paramInt)) {
        a(paramInt, (MetaMaterial)this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel.a().get(paramInt));
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.a(paramInt))
      {
        this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.resetAEKitModel(paramInt, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.a(paramInt), this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.a(paramInt));
        return;
      }
      f(paramInt);
    }
  }
  
  private void f(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel != null) && (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel.a() != null))
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel.a();
      int i = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.a(paramInt);
      if (!CollectionUtils.indexOutOfBounds((Collection)localObject1, i))
      {
        Object localObject2 = (MetaMaterial)((List)localObject1).get(i);
        float f1 = FilterMetaMaterialKt.b((MetaMaterial)localObject2);
        localObject1 = FilterMetaMaterialKt.a((MetaMaterial)localObject2);
        localObject2 = AEEditorResourceManager.a().d((MetaMaterial)localObject2);
        this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.resetAEKitModel(paramInt, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.a(paramInt), this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.a(paramInt), f1, (Map)localObject1, (String)localObject2);
      }
      return;
    }
    AEQLog.d("AEEditorImageEditFragment", "filter list null.");
  }
  
  private void f(boolean paramBoolean)
  {
    AEQLog.b("AEEditorImageEditFragment", "exportImages");
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession == null)
    {
      AEQLog.d("AEEditorImageEditFragment", "exportImages error: session is null");
      return;
    }
    if (!g())
    {
      QQToast.a(getActivity(), "图片不存在或被删除", 0).a();
      return;
    }
    if (this.jdField_c_of_type_Int + 1 < this.jdField_b_of_type_JavaUtilArrayList.size()) {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.releaseTAVCutWithoutView(this.jdField_c_of_type_Int + 1);
    }
    int i = this.jdField_c_of_type_Int;
    if ((i - 1 >= 0) && (i - 1 < this.jdField_b_of_type_JavaUtilArrayList.size())) {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.releaseTAVCutWithoutView(this.jdField_c_of_type_Int - 1);
    }
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.25(this, paramBoolean));
    Object localObject1 = AEEditorPath.EDITOR.FILES.d;
    Object localObject2 = new File((String)localObject1);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    localObject2 = this.jdField_d_of_type_JavaUtilArrayList;
    if (localObject2 != null)
    {
      ((ArrayList)localObject2).clear();
      this.jdField_d_of_type_JavaUtilArrayList = null;
      this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    }
    else
    {
      this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    }
    i = 0;
    while (i < this.jdField_b_of_type_JavaUtilArrayList.size())
    {
      localObject2 = new File((String)this.jdField_b_of_type_JavaUtilArrayList.get(i));
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(File.separator);
      ((StringBuilder)localObject3).append("output_");
      ((StringBuilder)localObject3).append(i);
      ((StringBuilder)localObject3).append("_");
      ((StringBuilder)localObject3).append(System.currentTimeMillis());
      ((StringBuilder)localObject3).append("_");
      ((StringBuilder)localObject3).append(VideoFilterTools.a(((File)localObject2).getName()));
      ((StringBuilder)localObject3).append(".jpg");
      localObject2 = ((StringBuilder)localObject3).toString();
      this.jdField_d_of_type_JavaUtilArrayList.add(localObject2);
      localObject3 = this.jdField_a_of_type_JavaUtilHashMap;
      if (localObject3 != null)
      {
        localObject3 = (ArrayList)((HashMap)localObject3).get(String.valueOf(i));
        if (localObject3 != null)
        {
          this.jdField_a_of_type_JavaUtilHashMap.remove(String.valueOf(i));
          this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, localObject3);
        }
      }
      i += 1;
    }
    localObject1 = new ImageExportConfig();
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.applyCurrentSticker(this.jdField_c_of_type_Int);
    L();
    if (this.jdField_d_of_type_Int == 0) {
      this.jdField_d_of_type_Int = d();
    }
    ((ImageExportConfig)localObject1).setMaxExportSize(d());
    ((ImageExportConfig)localObject1).setMinIntermediateRenderSize(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleParamsImageParamStrategy.a());
    ((ImageExportConfig)localObject1).setMaxIntermediateRenderSize(d());
    ((ImageExportConfig)localObject1).setQuality(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleParamsImageParamStrategy.e());
    ((ImageExportConfig)localObject1).setOutputPath(this.jdField_d_of_type_JavaUtilArrayList);
    ((ImageExportConfig)localObject1).setScreenSize(new CGSize(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageViewPager.getWidth(), this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageViewPager.getHeight()));
    a((ImageExportConfig)localObject1);
    this.jdField_a_of_type_ComTencentTavcutExporterImageExporter = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.getExporter((ImageExportConfig)localObject1);
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    this.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
    this.jdField_c_of_type_JavaLangStringBuilder = new StringBuilder();
    this.jdField_d_of_type_JavaLangStringBuilder = new StringBuilder();
    this.jdField_e_of_type_JavaLangStringBuilder = new StringBuilder();
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).reportPublishQuality(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).P_EXPORT_START(), Arrays.asList(new FeedCloudCommon.Entry[] { ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).EXT1(), "pic"), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).EXT2(), this.jdField_b_of_type_JavaUtilArrayList.toString()), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).EXT3(), this.jdField_d_of_type_JavaUtilArrayList.toString()), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).KEY_RET_CODE(), "0") }));
    this.jdField_a_of_type_ComTencentTavcutExporterImageExporter.export(new AEEditorImageEditFragment.26(this, paramBoolean), this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.getEglContext(), this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.getImageProcessThread(), this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.getRenderContext(), this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.getAeFilterManager());
  }
  
  private void g(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel != null) && (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel.a() != null))
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel.a();
      int i = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.a(paramInt);
      if (!CollectionUtils.indexOutOfBounds((Collection)localObject1, i))
      {
        Object localObject2 = (MetaMaterial)((List)localObject1).get(i);
        float f1 = FilterMetaMaterialKt.b((MetaMaterial)localObject2);
        localObject1 = FilterMetaMaterialKt.a((MetaMaterial)localObject2);
        localObject2 = AEEditorResourceManager.a().d((MetaMaterial)localObject2);
        this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.resetAllAeKitModelWithOutRender(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.a(paramInt), this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.a(paramInt), f1, (Map)localObject1, (String)localObject2);
      }
      return;
    }
    AEQLog.d("AEEditorImageEditFragment", "filter list null.");
  }
  
  private void g(boolean paramBoolean)
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
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
  
  private boolean g()
  {
    Object localObject = this.jdField_b_of_type_JavaUtilArrayList;
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
  
  private void h(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel == null) {
      return;
    }
    if (this.jdField_b_of_type_JavaUtilArrayList.size() > 1)
    {
      List localList = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel.a();
      if (!CollectionUtils.indexOutOfBounds(localList, paramInt))
      {
        bool = FilterMetaMaterialKt.c((MetaMaterial)localList.get(paramInt));
        break label54;
      }
    }
    boolean bool = false;
    label54:
    if (bool) {
      b(true);
    } else if (!this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel.b()) {
      b(false);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel.b(bool);
  }
  
  private void i(int paramInt)
  {
    if (paramInt >= 1) {
      e(paramInt - 1);
    }
    if (paramInt < c() - 1) {
      e(paramInt + 1);
    }
  }
  
  private void j(int paramInt)
  {
    AEQLog.a("AEEditorImageEditFragment", "update all data.");
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.b(paramInt))
    {
      int i = 0;
      while (i < c())
      {
        if (paramInt != i) {
          this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.resetAEKitNodeForAIWithoutRender(i, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.a(i).b(), this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.a(i).a(), this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.a(i).a(), (int)(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.a(i).b() * 100.0F), this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.a(i).c());
        }
        i += 1;
      }
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.c(paramInt)) {
      return;
    }
    g(paramInt);
  }
  
  public void A()
  {
    s();
    a(-1);
    h(-1);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.clearAEKitModel(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.c(this.jdField_c_of_type_Int);
    ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewNumberIndicator, 0);
    AEBaseReportParam.a().a().jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_c_of_type_Int), "none");
    AEBaseReportParam.a().a().b.put(Integer.valueOf(this.jdField_c_of_type_Int), Float.valueOf(-1.0F));
  }
  
  public void B()
  {
    ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewNumberIndicator, 4);
  }
  
  public void C()
  {
    ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewNumberIndicator, 0);
  }
  
  public void D() {}
  
  public void E()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel.setSelectedIndex(-1, true);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.c(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFrameAEEditorFramePanel.a();
  }
  
  public void F()
  {
    Object localObject = (AEEditorImageInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_c_of_type_Int);
    if ((((AEEditorImageInfo)localObject).b != 0) && (((AEEditorImageInfo)localObject).jdField_a_of_type_Int != 0))
    {
      double d1 = ((AEEditorImageInfo)localObject).jdField_a_of_type_Int * 1.0F / ((AEEditorImageInfo)localObject).b;
      if (d1 <= 0.333333343267441D) {
        localObject = new CropConfig(0.0F, (((AEEditorImageInfo)localObject).b - ((AEEditorImageInfo)localObject).jdField_a_of_type_Int / 0.3333333F) * 1.0F / 2.0F / ((AEEditorImageInfo)localObject).b, 1.0F, ((AEEditorImageInfo)localObject).jdField_a_of_type_Int / 0.3333333F * 1.0F / ((AEEditorImageInfo)localObject).b);
      } else if (d1 >= 1.777777791023254D) {
        localObject = new CropConfig((((AEEditorImageInfo)localObject).jdField_a_of_type_Int - ((AEEditorImageInfo)localObject).b * 1.777778F) * 1.0F / 2.0F / ((AEEditorImageInfo)localObject).jdField_a_of_type_Int, 0.0F, ((AEEditorImageInfo)localObject).b * 1.777778F * 1.0F / ((AEEditorImageInfo)localObject).jdField_a_of_type_Int, 1.0F);
      } else {
        localObject = new CropConfig(0.0F, 0.0F, 1.0F, 1.0F);
      }
      ((AEEditorImageInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_c_of_type_Int)).a((CropConfig)localObject);
      ((AEEditorImageInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_c_of_type_Int)).a(0);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.updateTemplateCrop(this.jdField_c_of_type_Int, (CropConfig)localObject);
    }
  }
  
  public void G()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public int a()
  {
    return 2064318568;
  }
  
  protected AEEditorFilterControlPanel.FilterControlListener a()
  {
    return this;
  }
  
  protected FilterChangedComparator a()
  {
    return new AEEditorImageEditFragment.28(this);
  }
  
  protected AEEditorStickerPart.AEEditorTextDialogListener a()
  {
    return new AEEditorImageEditFragment.24(this);
  }
  
  protected TAVCutSession a()
  {
    return this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession;
  }
  
  public String a()
  {
    return "AEEditorImageEdit";
  }
  
  protected String a(int paramInt)
  {
    Object localObject2 = "";
    Object localObject1 = localObject2;
    Object localObject3;
    if (TextUtils.isEmpty(""))
    {
      localObject3 = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = a(((AEEditorImageTemplatePanel)localObject3).a(paramInt), this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel.a());
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerControlPanel != null)
      {
        localObject3 = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.getMediaModels();
        localObject2 = localObject1;
        if (paramInt >= 0)
        {
          localObject2 = localObject1;
          if (paramInt < ((List)localObject3).size()) {
            localObject2 = a(((MediaModel)((List)localObject3).get(paramInt)).getMediaEffectModel().getStickerModelList(), this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerControlPanel.a());
          }
        }
      }
    }
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextControlPanel != null)
      {
        localObject3 = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.getMediaModels();
        localObject1 = localObject2;
        if (paramInt >= 0)
        {
          localObject1 = localObject2;
          if (paramInt < ((List)localObject3).size()) {
            localObject1 = a(((MediaModel)((List)localObject3).get(paramInt)).getMediaEffectModel().getStickerModelList(), this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextViewModel.a());
          }
        }
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject3 = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFrameAEEditorFramePanel;
      localObject2 = localObject1;
      if (localObject3 != null) {
        localObject2 = a(((AEEditorFramePanel)localObject3).a(paramInt), this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFrameAEEditorFramePanel.a());
      }
    }
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel != null)
      {
        localObject1 = localObject2;
        if (!this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.a(paramInt)) {
          localObject1 = a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.b(paramInt), this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel.a());
        }
      }
    }
    return localObject1;
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
        str1 = a(i);
        if (!TextUtils.isEmpty(str1)) {
          return str1;
        }
        i += 1;
      }
    }
    return str2;
  }
  
  public void a() {}
  
  public void a(int paramInt, float paramFloat)
  {
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setEffectStrength(this.jdField_c_of_type_Int, paramFloat);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.a(this.jdField_c_of_type_Int, paramFloat);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.a(this.jdField_c_of_type_Int, paramInt, paramFloat);
    AEBaseReportParam.a().a().b.put(Integer.valueOf(this.jdField_c_of_type_Int), Float.valueOf(paramFloat));
  }
  
  public void a(int paramInt, @Nullable MetaMaterial paramMetaMaterial)
  {
    a(paramInt);
    float f1 = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.a(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel.setSeekBarValue(f1);
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle.putString("key_image_to_multi_video_hashtag", a(this.jdField_c_of_type_JavaUtilArrayList));
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
        if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFrameAEEditorFramePanel.a(str)) {
          this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditWidgetsAEEditorCheckGroupView.a(2064122556);
        }
      }
      else if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel.a(str))
      {
        this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditWidgetsAEEditorCheckGroupView.a(2064122348);
      }
    }
  }
  
  public void a(CropConfig paramCropConfig, int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.getCurrentIndex();
    ((AEEditorImageInfo)this.jdField_a_of_type_JavaUtilList.get(i)).a(paramCropConfig);
    ((AEEditorImageInfo)this.jdField_a_of_type_JavaUtilList.get(i)).a(paramInt);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.updateTemplateCrop(i, paramCropConfig);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onTemplateSet, materialId=");
      localStringBuilder.append(paramString);
      AEQLog.b("AEEditorImageEditFragment", localStringBuilder.toString());
      if (!this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel.a(paramString, false)) {
        this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel.setSelectedIndex(-1);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, float paramFloat)
  {
    int i = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel.a(paramString1);
    if (i == -1)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.c(this.jdField_c_of_type_Int);
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.a(this.jdField_c_of_type_Int, paramString2, paramFloat, i);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.a(this.jdField_c_of_type_Int, paramString1);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_c_of_type_AndroidWidgetFrameLayout.setVisibility(4);
      g(false);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    g(this.g);
    AEReportUtils.h();
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    X();
    switch (this.jdField_e_of_type_Int)
    {
    default: 
      break;
    case 2064122562: 
      ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerControlPanel, 8);
      break;
    case 2064122556: 
      ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFrameAEEditorFramePanel, 8);
      break;
    case 2064122555: 
      ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel, 8);
      break;
    case 2064122349: 
      ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextControlPanel, 8);
      break;
    case 2064122348: 
      ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel, 8);
    }
    switch (paramInt)
    {
    default: 
      break;
    case 2064122562: 
      if (!paramBoolean) {
        n();
      }
      ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerControlPanel, 0);
      AEReportUtils.d(true);
      a(2064122257, "SP_KEY_RED_POINT_TIME_STAMP", true);
      break;
    case 2064122556: 
      l();
      n();
      ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFrameAEEditorFramePanel, 0);
      AEReportUtils.k();
      a(2064122256, "SP_KEY_RED_POINT_TIME_STAMP", true);
      break;
    case 2064122555: 
      ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel, 0);
      l();
      n();
      AEReportUtils.c(true);
      a(2064122255, "SP_KEY_RED_POINT_TIME_STAMP", true);
      break;
    case 2064122349: 
      if (!paramBoolean) {
        l();
      }
      ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextControlPanel, 0);
      a(2064122259, "SP_KEY_RED_POINT_TIME_STAMP", true);
      break;
    case 2064122348: 
      ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel, 0);
      l();
      n();
      AEReportUtils.j();
      a(2064122258, "SP_KEY_RED_POINT_TIME_STAMP", true);
    }
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public boolean a()
  {
    if (!this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.mediaChanged())
    {
      AEEditorImageRecord.a().a();
      return false;
    }
    return super.a();
  }
  
  public boolean a(int paramInt)
  {
    AEEditorImageTemplatePanel localAEEditorImageTemplatePanel = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localAEEditorImageTemplatePanel != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFrameAEEditorFramePanel != null) {
        if (!localAEEditorImageTemplatePanel.a(paramInt))
        {
          bool1 = bool2;
          if (!this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFrameAEEditorFramePanel.a(paramInt)) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean a(int paramInt, MetaMaterial paramMetaMaterial)
  {
    int i = this.jdField_c_of_type_Int;
    ComicsFilterResult localComicsFilterResult = (ComicsFilterResult)this.jdField_a_of_type_JavaUtilMap.get(a(i, paramMetaMaterial));
    if (localComicsFilterResult == null)
    {
      if (!NetworkUtil.isNetworkAvailable())
      {
        QQToast.a(getActivity(), getActivity().getResources().getString(2064515301), 1).a();
        return false;
      }
      this.jdField_d_of_type_Boolean = false;
      r();
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
    localAEQCircleReport.a(str, "", QCircleConstants.KEY_CACHE, "0");
    a(i, localComicsFilterResult, paramInt, paramMetaMaterial);
    return true;
  }
  
  protected int b()
  {
    return -1;
  }
  
  public String b()
  {
    return HardCodeUtil.a(2064515153);
  }
  
  public void b(int paramInt, MetaMaterial paramMetaMaterial)
  {
    s();
    String str1 = AEEditorResourceManager.a().b(paramMetaMaterial);
    float f1 = FilterMetaMaterialKt.a(paramMetaMaterial);
    a(paramInt);
    h(paramInt);
    float f2 = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.a(this.jdField_c_of_type_Int, paramInt, f1);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel.setSeekBarValue(f2);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.a(this.jdField_c_of_type_Int, str1, f2, paramInt);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.a(this.jdField_c_of_type_Int, paramMetaMaterial.id);
    float f3 = FilterMetaMaterialKt.b(paramMetaMaterial);
    Object localObject = FilterMetaMaterialKt.a(paramMetaMaterial);
    String str2 = AEEditorResourceManager.a().d(paramMetaMaterial);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.resetAEKitModel(this.jdField_c_of_type_Int, f2, str1, f3, (Map)localObject, str2);
    localObject = AEQCircleReport.a();
    if (paramMetaMaterial == null) {
      str1 = "";
    } else {
      str1 = paramMetaMaterial.id;
    }
    ((AEQCircleReport)localObject).a(str1, QCircleConstants.KEY_PIC, "0");
    AEBaseReportParam.a().a().jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_c_of_type_Int), paramMetaMaterial.id);
    AEBaseReportParam.a().a().b.put(Integer.valueOf(this.jdField_c_of_type_Int), Float.valueOf(f1));
  }
  
  public void b(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFrameAEEditorFramePanel.setSelectedIndex(paramString1, paramString2);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFrameAEEditorFramePanel.a(paramString1, paramString2);
  }
  
  protected void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    a(paramBoolean);
  }
  
  protected boolean b()
  {
    return true;
  }
  
  public boolean b(int paramInt)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAifilterAIFilterDataCache.a((String)this.jdField_b_of_type_JavaUtilArrayList.get(this.jdField_c_of_type_Int));
    boolean bool1;
    if ((localObject instanceof SingleImageAIFilterResult))
    {
      AEQLog.b("AEEditorImageEditFragment", "onAIFilterRequest: has cache");
      bool1 = ((SingleImageAIFilterResult)localObject).jdField_a_of_type_Boolean;
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
      q();
      localObject = new SingleImageAIFilterProxy((String)this.jdField_b_of_type_JavaUtilArrayList.get(this.jdField_c_of_type_Int), this.jdField_a_of_type_JavaUtilList, this.jdField_c_of_type_Int);
      ((SingleImageAIFilterProxy)localObject).a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAifilterAEEditorAIFilterManager$AIFilterObserver);
      AEEditorAIFilterManager.a().a(getActivity(), (AIFilterProxyBase)localObject);
    }
    else
    {
      a(paramInt);
      h(paramInt);
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel.setSelectedIndex(paramInt, true);
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.a(this.jdField_c_of_type_Int, (AIFilterResult)localObject);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.resetAEKitModelForAI(this.jdField_c_of_type_Int, ((AIFilterResult)localObject).b(), ((AIFilterResult)localObject).a(), ((AIFilterResult)localObject).a(), (int)(((AIFilterResult)localObject).b() * 100.0F), ((AIFilterResult)localObject).c());
      a(new String[] { "智能滤镜label", ((AIFilterResult)localObject).a(), "智能滤镜errCode", "0" });
      AEQCircleReport.a().a(QCircleConstants.KEY_AIPHOTOCONFIG, QCircleConstants.KEY_PIC, QCircleConstants.KEY_CACHE, "0");
    }
    if (!bool1) {
      bool2 = true;
    }
    return bool2;
  }
  
  protected void c()
  {
    AEQLog.b("AEEditorImageEditFragment", "initImageInfos");
    Object localObject1 = new ArrayList();
    Object localObject2 = getArguments();
    if (((Bundle)localObject2).containsKey("AEEditorConstants_CLIPPED_PIC_INFOS")) {
      localObject1 = (List)((Bundle)localObject2).getSerializable("AEEditorConstants_CLIPPED_PIC_INFOS");
    } else {
      AEQLog.d("AEEditorImageEditFragment", "no image crop infos");
    }
    this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)getArguments().getSerializable("ae_album_selected_media_models"));
    this.g = ((Bundle)localObject2).getBoolean("BUNDLE_KEY_CIRCLE_CAN_PICK_VIDEO", true);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (EditorPicInfo)((Iterator)localObject1).next();
      CropConfig localCropConfig = new CropConfig((float)((EditorPicInfo)localObject2).x, (float)((EditorPicInfo)localObject2).y, (float)Math.min(((EditorPicInfo)localObject2).w, 1.0D), (float)((EditorPicInfo)localObject2).h);
      this.jdField_b_of_type_JavaUtilArrayList.add(((EditorPicInfo)localObject2).picPath);
      this.jdField_a_of_type_JavaUtilList.add(new AEEditorImageInfo(((EditorPicInfo)localObject2).picPath, (int)((EditorPicInfo)localObject2).originPicWidth, (int)((EditorPicInfo)localObject2).originPicHeight, localCropConfig));
    }
    this.jdField_d_of_type_Int = d();
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.a(this.jdField_b_of_type_JavaUtilArrayList.size());
    this.jdField_e_of_type_Boolean = AEThemeUtil.a();
  }
  
  public void c(boolean paramBoolean)
  {
    a(paramBoolean);
  }
  
  protected void d()
  {
    AEEditorAIFilterManager.a().a();
  }
  
  public void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
        return;
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorLoadingView = new AEEditorLoadingView(getActivity());
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorLoadingView.setLoadingListener(new AEEditorImageEditFragment.31(this));
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorLoadingView.a(3);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorLoadingView);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageViewPager.setScrollable(false);
  }
  
  protected void e()
  {
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void e(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.32(this, paramBoolean));
  }
  
  protected void f()
  {
    k();
    Boolean localBoolean = a();
    NumberIndicator localNumberIndicator = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewNumberIndicator;
    int i;
    if ((localBoolean != null) && (localBoolean.booleanValue())) {
      i = 4;
    } else {
      i = 0;
    }
    ViewUtils.b(localNumberIndicator, i);
    O();
  }
  
  public boolean f()
  {
    List localList = ((MediaModel)this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.getMediaModels().get(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.getCurrentIndex())).getMediaEffectModel().getStickerModelList();
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
  
  protected void g()
  {
    m();
    Boolean localBoolean = a();
    NumberIndicator localNumberIndicator = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewNumberIndicator;
    int i;
    if ((localBoolean != null) && (localBoolean.booleanValue())) {
      i = 4;
    } else {
      i = 0;
    }
    ViewUtils.b(localNumberIndicator, i);
    O();
  }
  
  protected void h()
  {
    TAVCutImageSession localTAVCutImageSession = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession;
    if (localTAVCutImageSession != null) {
      localTAVCutImageSession.applyCurrentSticker(this.jdField_c_of_type_Int);
    }
  }
  
  public void i()
  {
    f(true);
  }
  
  public void k()
  {
    super.k();
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageViewPager.setScrollable(false);
    ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewNumberIndicator, 4);
  }
  
  public void l()
  {
    super.l();
    ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewNumberIndicator, 0);
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.22(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerControlPanel.a();
  }
  
  public void m()
  {
    super.m();
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageViewPager.setScrollable(false);
    ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewNumberIndicator, 4);
  }
  
  public void n()
  {
    super.n();
    ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewNumberIndicator, 0);
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.23(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AEQLog.b("AEEditorImageEditFragment", "onCreate");
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEVideoEditViewModel = ((AEVideoEditViewModel)AEViewModelProviders.a(getActivity()).get(AEVideoEditViewModel.class));
    J();
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
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq != null) {
      ((IHttpEngineService)MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IHttpEngineService.class, "all")).cancelReq(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
    }
    AEEditorResourceManager.a().c().removeObserver(this.jdField_a_of_type_AndroidxLifecycleObserver);
    AEEditorResourceManager.a().b().removeObserver(this.jdField_b_of_type_AndroidxLifecycleObserver);
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImagePagerAdapter.a();
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImagePagerAdapter = null;
    TAVCutImageSession localTAVCutImageSession = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession;
    if (localTAVCutImageSession != null)
    {
      localTAVCutImageSession.release();
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession = null;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.b();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel.b();
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFrameAEEditorFramePanel.b();
    M();
  }
  
  public void onDetach()
  {
    super.onDetach();
    AEEditorImageRecord.a().b();
    AEEditorImageRecord.a().c();
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.applyCurrentSticker(this.jdField_c_of_type_Int);
      l();
      n();
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPageSelected: ");
    localStringBuilder.append(paramInt);
    AEQLog.b("AEEditorImageEditFragment", localStringBuilder.toString());
    this.jdField_c_of_type_Int = paramInt;
    d(paramInt);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setCurrentIndex(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewNumberIndicator.setCurrentIndex(paramInt + 1);
    int i = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.a(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel.setSelectedIndex(i);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel.setSeekBarValue(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.a(this.jdField_c_of_type_Int));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel.a(paramInt);
    e(paramInt);
  }
  
  public void onSaveInstanceState(@NonNull Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle = a().a();
    if ((paramBundle != null) && (paramBundle == this)) {
      AEEditorImageRecord.a().a(this.jdField_b_of_type_JavaUtilArrayList, this.jdField_c_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleImagetemplateAEEditorImageTemplatePanel.a, this.jdField_a_of_type_JavaUtilList, 1);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    AEQLog.b("AEEditorImageEditFragment", "onViewCreated");
    super.onViewCreated(paramView, paramBundle);
    AEQLog.b("AEEditorImageEditFragment", "init");
    this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler = new CustomHandler(Looper.getMainLooper(), this);
    K();
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.b();
    b(paramView);
    H();
    I();
    d(0);
    if (AEEditorResourceManager.a().b()) {
      y();
    }
    AEEditorImageRecord.a().a(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession, getArguments(), this.jdField_b_of_type_JavaUtilArrayList);
    paramView = ParamsUtil.a();
    int i = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleParamsImageParamStrategy.a();
    int j = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleParamsImageParamStrategy.b();
    paramBundle = new StringBuilder();
    paramBundle.append(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleParamsImageParamStrategy.e());
    paramBundle.append("%");
    a(new String[] { "设备级别", paramView, "图片最小预览尺寸", String.valueOf(i), "图片最大预览尺寸", String.valueOf(j), "图片导出质量", paramBundle.toString(), "图片最大导出尺寸", String.valueOf(this.jdField_d_of_type_Int) });
    AEReportUtils.u();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {}
  
  public void t()
  {
    X();
    super.t();
  }
  
  public void u()
  {
    X();
    super.u();
  }
  
  public void v()
  {
    AEEditorImageRecord.a().a();
  }
  
  public void x()
  {
    new Handler(Looper.getMainLooper()).postDelayed(new AEEditorImageEditFragment.8(this), 100L);
  }
  
  protected void y()
  {
    SilentBatchImageAIFilterProxy localSilentBatchImageAIFilterProxy = new SilentBatchImageAIFilterProxy(this.jdField_b_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaUtilList);
    localSilentBatchImageAIFilterProxy.a(new AEEditorImageEditFragment.16(this));
    AEEditorAIFilterManager.a().a(getActivity(), localSilentBatchImageAIFilterProxy);
  }
  
  public void z()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onApplyAll current position = ");
    ((StringBuilder)localObject1).append(this.jdField_c_of_type_Int);
    AEQLog.b("AEEditorImageEditFragment", ((StringBuilder)localObject1).toString());
    AEBaseDataReporter.a().s();
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel.c())
    {
      localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
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
        localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAifilterAIFilterDataCache.a((String)localObject2);
        if ((localObject2 == null) || (!(localObject2 instanceof SingleImageAIFilterResult))) {
          break;
        }
        AEQLog.b("AEEditorImageEditFragment", "onAIFilterRequest: has cache");
      } while (!((AIFilterResult)localObject2).jdField_a_of_type_Boolean);
      int i = 1;
      break label136;
      label134:
      i = 0;
      label136:
      if (i != 0)
      {
        q();
        localObject1 = this.jdField_b_of_type_JavaUtilArrayList;
        localObject2 = this.jdField_a_of_type_JavaUtilList;
        i = this.jdField_c_of_type_Int;
        localObject1 = new BatchImageAIFilterProxy((List)localObject1, (List)localObject2, i, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAifilterAIFilterDataCache.a((String)((ArrayList)localObject1).get(i)));
        ((BatchImageAIFilterProxy)localObject1).a(this.jdField_b_of_type_ComTencentAelightCameraAeeditorModuleAifilterAEEditorAIFilterManager$AIFilterObserver);
        AEEditorAIFilterManager.a().a(getActivity(), (AIFilterProxyBase)localObject1);
        return;
      }
      a(AEEditorFilterControlPanel.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel.setSelectedIndex(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel.a(), true);
      localObject1 = new StringBuilder();
      i = j;
      while (i < c())
      {
        localObject2 = (SingleImageAIFilterResult)this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAifilterAIFilterDataCache.a((String)this.jdField_b_of_type_JavaUtilArrayList.get(i));
        this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.a(i, (AIFilterResult)localObject2);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((SingleImageAIFilterResult)localObject2).a());
        localStringBuilder.append("|");
        ((StringBuilder)localObject1).append(localStringBuilder.toString());
        i += 1;
      }
      a("智能滤镜label", ((StringBuilder)localObject1).toString());
      e(this.jdField_c_of_type_Int);
      i(this.jdField_c_of_type_Int);
      j(this.jdField_c_of_type_Int);
      N();
      return;
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel.d())
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.a();
      i(this.jdField_c_of_type_Int);
      j(this.jdField_c_of_type_Int);
      N();
      return;
    }
    if (c()) {
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterImageFilterInfoCache.b(this.jdField_c_of_type_Int);
    i(this.jdField_c_of_type_Int);
    j(this.jdField_c_of_type_Int);
    N();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImageEditFragment
 * JD-Core Version:    0.7.0.1
 */