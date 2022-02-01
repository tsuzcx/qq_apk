package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCaptureLauncher;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus;
import com.tencent.biz.pubaccount.readinjoy.dt.RIJDtReportHelper;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyNinePicDeliverDynamicGridView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.HotPicDownLoader;
import com.tencent.mobileqq.hotpic.HotPicManager;
import com.tencent.mobileqq.hotpic.HotPicPageView;
import com.tencent.mobileqq.hotpic.HotVideoData;
import com.tencent.mobileqq.hotpic.HotVideoPreviewDownloader;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyDeliverUGCActivity
  extends ReadInJoyBaseDeliverActivity
{
  public static Drawable a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  ReadInJoyObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new ReadInJoyDeliverUGCActivity.16(this);
  private ReadInJoyDeliverUGCActivity.DeliverData jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity$DeliverData = new ReadInJoyDeliverUGCActivity.DeliverData();
  private ReadInJoyDeliverUGCActivity.ReportInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity$ReportInfo = new ReadInJoyDeliverUGCActivity.ReportInfo(this);
  private ReadInJoyNinePicAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyNinePicAdapter;
  private ReadInJoyNinePicDeliverDynamicGridView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private JSONObject jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
  private long jdField_b_of_type_Long = 0L;
  private QQProgressDialog jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private ArrayList<SocializeFeedsInfo.BiuCommentInfo> jdField_b_of_type_JavaUtilArrayList;
  private List<Integer> jdField_b_of_type_JavaUtilList = new ArrayList();
  private float jdField_c_of_type_Float;
  private ActionSheet jdField_c_of_type_ComTencentWidgetActionSheet;
  private List<ReadInJoyDeliverUGCActivity.UGCTransProcessorHandler> jdField_c_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  private float jdField_d_of_type_Float;
  private List<TransferRequest> jdField_d_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  private String jdField_e_of_type_JavaLangString = "";
  private List<String> jdField_e_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  private String f;
  private String g;
  private String h;
  private int k = 0;
  private int l = 0;
  private int m;
  private int n;
  private int o;
  private int p = 40000;
  private int jdField_q_of_type_Int = 0;
  private boolean jdField_q_of_type_Boolean = false;
  private int jdField_r_of_type_Int;
  private boolean jdField_r_of_type_Boolean = false;
  private boolean s = false;
  private boolean t = false;
  private boolean u = false;
  private boolean v = false;
  private boolean w;
  private boolean x;
  private boolean y;
  private boolean z = false;
  
  static
  {
    jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(-855310);
  }
  
  public ReadInJoyDeliverUGCActivity()
  {
    this.jdField_m_of_type_Int = 0;
    this.jdField_o_of_type_Int = 0;
  }
  
  private int a()
  {
    if ((b() == 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText()))) {
      return 3;
    }
    if ((b() != 0) && (TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText())))
    {
      if (b()) {
        return 4;
      }
      return 1;
    }
    if ((b() != 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText())))
    {
      if (b()) {
        return 5;
      }
      return 2;
    }
    return 0;
  }
  
  public static URLDrawable a(HotPicData paramHotPicData)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    localURLDrawableOptions.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    boolean bool;
    if (paramHotPicData.getDataType() != 2)
    {
      bool = true;
      localURLDrawableOptions.mPlayGifImage = bool;
      localURLDrawableOptions.mExtraInfo = paramHotPicData;
      if (paramHotPicData.getDataType() != 2) {
        break label65;
      }
    }
    label65:
    for (paramHotPicData = HotVideoPreviewDownloader.a((HotVideoData)paramHotPicData);; paramHotPicData = HotPicDownLoader.a(paramHotPicData.url))
    {
      if (paramHotPicData != null) {
        break label76;
      }
      return null;
      bool = false;
      break;
    }
    label76:
    return URLDrawable.getDrawable(paramHotPicData, localURLDrawableOptions);
  }
  
  private String a(int paramInt)
  {
    String str = RIJTransMergeKanDianReport.c();
    try
    {
      Object localObject = new JSONObject(str);
      ((JSONObject)localObject).put("save", paramInt);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return str;
  }
  
  private String a(Object paramObject)
  {
    String str = this.jdField_e_of_type_JavaLangString;
    if ((this.jdField_e_of_type_JavaLangString.equals(paramObject)) || (!(paramObject instanceof String))) {
      paramObject = str;
    }
    do
    {
      do
      {
        return paramObject;
        str = (String)paramObject;
        paramObject = str;
      } while (TextUtils.isEmpty(str));
      paramObject = str;
    } while (!new File(str).exists());
    return HexUtil.bytes2HexStr(FileManagerUtil.e(str));
  }
  
  @Nullable
  private String a(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof HotPicData))
    {
      a((HotPicData)paramObject, paramInt);
      paramObject = null;
    }
    String str;
    do
    {
      return paramObject;
      if (!(paramObject instanceof String)) {
        break;
      }
      str = (String)paramObject;
      paramObject = str;
    } while (!a(str));
    return null;
    x();
    return null;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return paramString.replace("\\/", "/").replaceAll("https://qqpublic.qpic.cn/qq_public/", "");
  }
  
  private void a(long paramLong1, long paramLong2, String paramString, CompressInfo paramCompressInfo, boolean paramBoolean)
  {
    if (paramBoolean) {
      try
      {
        paramString = paramString.substring(paramString.lastIndexOf(".") + 1);
        if (paramLong2 == paramLong1)
        {
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800951E", "0X800951E", 0, 0, String.valueOf(paramCompressInfo.jdField_d_of_type_Int), String.valueOf(paramCompressInfo.jdField_e_of_type_Int), paramString, RIJTransMergeKanDianReport.a(0), false);
          return;
        }
        if (paramLong2 > paramLong1)
        {
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800951E", "0X800951E", 0, 0, String.valueOf(paramCompressInfo.jdField_d_of_type_Int), String.valueOf(paramCompressInfo.jdField_e_of_type_Int), paramString, RIJTransMergeKanDianReport.a(1), false);
          return;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyDeliverUGCActivity", 2, "0X800951E reportError");
        }
      }
    }
  }
  
  private void a(long paramLong, String paramString, CompressInfo paramCompressInfo, boolean paramBoolean, int paramInt)
  {
    if (TextUtils.isEmpty(paramCompressInfo.jdField_e_of_type_JavaLangString)) {}
    long l1;
    for (String str = paramString;; str = paramCompressInfo.jdField_e_of_type_JavaLangString)
    {
      l1 = new File(str).length();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity$ReportInfo.b(paramInt, l1);
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "afterCompress picture: w:" + paramCompressInfo.jdField_d_of_type_Int + "  h:" + paramCompressInfo.jdField_e_of_type_Int + " size:" + l1 / 1024L + "kb");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity$ReportInfo.d(paramInt, NetConnInfoCenter.getServerTimeMillis());
      if (!a(str, paramInt)) {
        break;
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity$ReportInfo.e(paramInt, NetConnInfoCenter.getServerTimeMillis());
    a(paramLong, l1, paramString, paramCompressInfo, paramBoolean);
  }
  
  private void a(HotPicData paramHotPicData, int paramInt)
  {
    if (paramInt < 9)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity$DeliverData.a(paramInt, paramHotPicData.originalUrl);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity$DeliverData.b(paramInt, paramHotPicData.md5);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity$DeliverData.b(paramInt, Integer.valueOf(paramHotPicData.height));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity$DeliverData.a(paramInt, Integer.valueOf(paramHotPicData.width));
      this.k += 1;
    }
    for (;;)
    {
      if (this.k == b())
      {
        this.v = true;
        ReadInJoyLogicEngine.a().a(this.app.getCurrentUin(), this.jdField_f_of_type_JavaLangString, this.jdField_h_of_type_JavaLangString, this.jdField_n_of_type_Int, this.jdField_b_of_type_JavaUtilList, c(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity$DeliverData.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity$DeliverData.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity$DeliverData.b(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity$DeliverData.b(), this.k, this.jdField_b_of_type_JavaUtilArrayList, this.w, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVisibleSetParam, this.jdField_r_of_type_Int);
      }
      return;
      this.u = false;
      l();
    }
  }
  
  private void a(Object paramObject)
  {
    List localList = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyNinePicAdapter.a();
    if (b() < 9)
    {
      if ((!(paramObject instanceof String)) || (!localList.contains(paramObject))) {
        break label149;
      }
      paramObject = b((String)paramObject);
    }
    label149:
    for (;;)
    {
      Object localObject1 = paramObject;
      if ((paramObject instanceof HotPicData))
      {
        localObject1 = paramObject;
        if (!localList.contains(paramObject)) {}
      }
      for (;;)
      {
        try
        {
          localObject1 = ((HotPicData)paramObject).clone();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyNinePicAdapter.a(localList.size() - 1, localObject1);
          b(localObject1);
          if (localList.size() > 9) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyNinePicAdapter.d(localList.get(9));
          }
          p();
          return;
        }
        catch (CloneNotSupportedException localCloneNotSupportedException)
        {
          localCloneNotSupportedException.printStackTrace();
          Object localObject2 = paramObject;
          continue;
        }
        a(1, getString(2131718212));
      }
    }
  }
  
  private void a(Object paramObject, int paramInt)
  {
    new Thread(new ReadInJoyDeliverUGCActivity.15(this, paramObject, paramInt)).start();
  }
  
  private void a(String paramString, long paramLong, ReadInJoyDeliverUGCActivity.CompressFile paramCompressFile, int paramInt)
  {
    CompressInfo localCompressInfo = paramCompressFile.a();
    boolean bool = paramCompressFile.b();
    if (a(paramCompressFile.a(), paramInt)) {
      return;
    }
    a(paramLong, paramString, localCompressInfo, bool, paramInt);
  }
  
  private void a(List<?> paramList)
  {
    if (paramList.size() > 0)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a(paramList.next());
      }
    }
  }
  
  private boolean a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 8)) {
      return false;
    }
    List localList = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyNinePicAdapter.a();
    if (((localList.get(paramInt) instanceof HotPicData)) || (this.jdField_e_of_type_JavaLangString.equals(localList.get(paramInt)))) {
      return true;
    }
    String str = a(localList.get(paramInt));
    int i = 0;
    for (;;)
    {
      if (i >= paramInt) {
        break label98;
      }
      if (str.equals(a(localList.get(i)))) {
        break;
      }
      i += 1;
    }
    label98:
    return true;
  }
  
  private boolean a(BitmapFactory.Options paramOptions, int paramInt)
  {
    if (this.u)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity$DeliverData.a(paramInt, Integer.valueOf(paramOptions.outWidth));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity$DeliverData.b(paramInt, Integer.valueOf(paramOptions.outHeight));
      return false;
    }
    return true;
  }
  
  private boolean a(FileMsg paramFileMsg)
  {
    return (paramFileMsg == null) || (paramFileMsg.fileType != 24) || (paramFileMsg.commandId != 10);
  }
  
  private boolean a(Object paramObject)
  {
    if (!this.u) {}
    while (paramObject.equals(this.jdField_e_of_type_JavaLangString)) {
      return true;
    }
    return false;
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      l();
      a(1, getString(2131718211));
      i();
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverUGCActivity", 2, "startUploadPic empty path!");
      }
      return true;
    }
    return false;
  }
  
  private boolean a(String paramString, int paramInt)
  {
    ITransFileController localITransFileController = (ITransFileController)this.app.getRuntimeService(ITransFileController.class);
    ReadInJoyDeliverUGCActivity.UGCTransProcessorHandler localUGCTransProcessorHandler = new ReadInJoyDeliverUGCActivity.UGCTransProcessorHandler(this, getMainLooper());
    TransferRequest localTransferRequest = new TransferRequest();
    if (this.u)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverUGCActivity", 2, "doStartUploadPicposition" + paramInt);
      }
      localUGCTransProcessorHandler.addFilter(new Class[] { BDHCommonUploadProcessor.class });
      localITransFileController.addHandle(localUGCTransProcessorHandler);
      localTransferRequest.mIsUp = true;
      localTransferRequest.mCommandId = 10;
      localTransferRequest.mLocalPath = paramString;
      localTransferRequest.mUniseq = paramInt;
      localTransferRequest.mPeerUin = "0";
      localTransferRequest.mFileType = 24;
      localTransferRequest.mRichTag = "KandianUGCPicUpload";
      localITransFileController.transferAsync(localTransferRequest);
      localUGCTransProcessorHandler.a = true;
      this.jdField_c_of_type_JavaUtilList.add(localUGCTransProcessorHandler);
      this.jdField_d_of_type_JavaUtilList.add(localTransferRequest);
      return false;
    }
    return true;
  }
  
  private int b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyNinePicAdapter != null)
    {
      int j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyNinePicAdapter.a().size();
      int i = j;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyNinePicAdapter.a().get(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyNinePicAdapter.a().size() - 1).equals(this.jdField_e_of_type_JavaLangString)) {
        i = j - 1;
      }
      return i;
    }
    return 0;
  }
  
  private void b(Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      if (com.tencent.mobileqq.pic.compress.Utils.a((String)paramObject))
      {
        this.jdField_b_of_type_JavaUtilList.add(Integer.valueOf(2));
        return;
      }
      this.jdField_b_of_type_JavaUtilList.add(Integer.valueOf(3));
      return;
    }
    this.jdField_b_of_type_JavaUtilList.add(Integer.valueOf(2));
  }
  
  private void b(Object paramObject, int paramInt)
  {
    List localList = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyNinePicAdapter.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyNinePicAdapter.a(paramInt, paramObject);
    c(paramObject, paramInt);
    if (localList.size() > 9) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyNinePicAdapter.d(localList.get(9));
    }
    p();
  }
  
  private boolean b()
  {
    if (b() != 0)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyNinePicAdapter.a().size() - 1)
      {
        if (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyNinePicAdapter.a().get(i) instanceof HotPicData)) {
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
  
  private void c(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof String))
    {
      if (com.tencent.mobileqq.pic.compress.Utils.a((String)paramObject))
      {
        this.jdField_b_of_type_JavaUtilList.add(paramInt, Integer.valueOf(2));
        return;
      }
      this.jdField_b_of_type_JavaUtilList.add(paramInt, Integer.valueOf(3));
      return;
    }
    this.jdField_b_of_type_JavaUtilList.add(paramInt, Integer.valueOf(2));
  }
  
  private String e()
  {
    int j = 1;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", RIJKanDianFolderStatus.jdField_a_of_type_Int);
      String str1;
      if (a().intValue() > 0)
      {
        i = 1;
        localJSONObject.put("topic", i);
        String str2 = d();
        str1 = str2;
        if ("0".equalsIgnoreCase(str2)) {
          str1 = "";
        }
        localJSONObject.put("topicid", str1);
        localJSONObject.put("topic_num", a());
        localJSONObject.put("sticker", RIJDeliverUGCReportUtil.a(c()));
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI == null) {
          break label202;
        }
        i = 1;
        label116:
        localJSONObject.put("location", i);
        if (!c().contains("@")) {
          break label207;
        }
        i = 1;
        label141:
        localJSONObject.put("at", i);
        if (!b()) {
          break label212;
        }
        i = 1;
        label160:
        localJSONObject.put("gif", i);
        if (b() <= 0) {
          break label217;
        }
      }
      label202:
      label207:
      label212:
      label217:
      for (int i = j;; i = 0)
      {
        localJSONObject.put("pic", i);
        str1 = localJSONObject.toString();
        return str1;
        i = 0;
        break;
        i = 0;
        break label116;
        i = 0;
        break label141;
        i = 0;
        break label160;
      }
      return "";
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void e(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if ((this.jdField_n_of_type_Boolean) && (paramInt - this.jdField_c_of_type_Int <= 0)) {
        break label82;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_c_of_type_Int - paramInt));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    while (paramInt - this.jdField_c_of_type_Int > 0)
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF4222"));
      }
      this.jdField_d_of_type_Boolean = true;
      return;
      label82:
      if (this.jdField_n_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#BBBBBB"));
    }
    this.jdField_d_of_type_Boolean = false;
  }
  
  private String f()
  {
    if ((b() == 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText()))) {
      return "3";
    }
    if (((b() != 0) || (b())) && (TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText()))) {
      return "1";
    }
    if (((b() != 0) || (b())) && (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText()))) {
      return "2";
    }
    return "0";
  }
  
  private void f(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 8)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyNinePicAdapter.a().get(paramInt);
    if ((localObject instanceof HotPicData))
    {
      HotPicData localHotPicData = (HotPicData)localObject;
      if (HotPicPageView.a((HotPicData)localObject) == 0)
      {
        HotPicDownLoader.a(localHotPicData.url).getAbsolutePath();
        g(paramInt);
      }
    }
    for (;;)
    {
      RIJDeliverUGCReportUtil.b();
      return;
      if (((String)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyNinePicAdapter.a().get(paramInt)).equals(this.jdField_e_of_type_JavaLangString))
      {
        if (9 - b() > 0)
        {
          n();
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008238", "0X8008238", 0, 0, "", "", "", RIJTransMergeKanDianReport.c(), false);
        }
        else
        {
          a(1, getString(2131718212));
        }
      }
      else {
        g(paramInt);
      }
    }
  }
  
  private void g(int paramInt)
  {
    Intent localIntent = new Intent();
    this.l = paramInt;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyNinePicAdapter.a().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!localObject.equals(this.jdField_e_of_type_JavaLangString)) {
        if ((localObject instanceof String)) {
          localArrayList.add((String)localObject);
        } else if ((localObject instanceof HotPicData)) {
          localArrayList.add(HotPicDownLoader.a(((HotPicData)localObject).url).getAbsolutePath());
        }
      }
    }
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ReadInJoyDeliverUGCActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    localIntent.putExtra("back_btn_text", HardCodeUtil.a(2131712795));
    localIntent.putExtra("from_readinjoy_ugc_deliver", true);
    localIntent.putExtra("keep_selected_status_after_finish", true);
    localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramInt);
    localIntent.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", true);
    localIntent.setClass(this, NewPhotoPreviewActivity.class);
    localIntent.putExtra("enter_from", 25);
    localIntent.putExtra("extra.busi_type", 8);
    startActivityForResult(localIntent, 1002);
    this.jdField_o_of_type_Int = 1002;
    overridePendingTransition(2130772307, 2130772309);
  }
  
  private void h(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = this.jdField_b_of_type_Long;
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(this);
    String str = this.app.getCurrentAccountUin();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localStatisticCollector.collectPerformance(str, "actReadInJoyUGCPicture", bool, l1 - l2, 0L, localHashMap, "");
      return;
    }
  }
  
  private void i(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyNinePicAdapter.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyNinePicAdapter.a().get(paramInt));
    this.jdField_b_of_type_JavaUtilList.remove(paramInt);
    if (b() == 0)
    {
      a(false);
      if (this.jdField_r_of_type_Int == 1)
      {
        a(true);
        this.rightViewText.setTextColor(Color.parseColor("#BBBBBB"));
      }
    }
    p();
    RIJDeliverUGCReportUtil.l();
  }
  
  private void q()
  {
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      this.jdField_a_of_type_Long = localIntent.getLongExtra("readinjoy_draftbox_id", -1L);
      if (this.jdField_a_of_type_Long != -1L) {
        ThreadManager.getSubThreadHandler().post(new ReadInJoyDeliverUGCActivity.5(this));
      }
    }
  }
  
  private void r()
  {
    ThreadManager.getUIHandler().post(new ReadInJoyDeliverUGCActivity.6(this));
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_Long != -1L) {
      ThreadManager.getSubThreadHandler().post(new ReadInJoyDeliverUGCActivity.7(this));
    }
  }
  
  private void t()
  {
    if ((Build.VERSION.SDK_INT >= 23) && (checkSelfPermission("android.permission.CAMERA") != 0))
    {
      requestPermissions(new ReadInJoyDeliverUGCActivity.10(this), 2000, new String[] { "android.permission.CAMERA" });
      return;
    }
    o();
  }
  
  private void u()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    localIntent.putExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
    localIntent.putExtra("peak.myUin", this.app.getAccount());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ReadInJoyDeliverUGCActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("extra.busi_type", 8);
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", false);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 9 - b());
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    if (9 - b() == 1) {
      localIntent.putExtra("from_readinjoy_ugc", true);
    }
    for (;;)
    {
      localIntent.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", true);
      localIntent.putExtra("PhotoConst.original_button", false);
      localIntent.setClass(this, NewPhotoListActivity.class);
      localIntent.putExtra("enter_from", 25);
      startActivityForResult(localIntent, 1000);
      this.jdField_o_of_type_Int = 1000;
      overridePendingTransition(2130771981, 2130771979);
      return;
      localIntent.putExtra("from_readinjoy_ugc_deliver_preview", true);
    }
  }
  
  private void v()
  {
    ReadInJoyCaptureLauncher.a(this);
    this.jdField_o_of_type_Int = 1001;
    overridePendingTransition(2130771981, 2130771979);
  }
  
  private void w()
  {
    ThreadManager.executeOnFileThread(new ReadInJoyDeliverUGCActivity.11(this));
  }
  
  private void x()
  {
    l();
    a(1, getString(2131718211));
    i();
    QLog.d("ReadInJoyDeliverUGCActivity", 2, "startUploadPic oncommon error!");
  }
  
  private void y()
  {
    this.k = 0;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity$DeliverData.a();
  }
  
  private void z()
  {
    y();
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ReadInJoyDeliverUGCActivity.UGCTransProcessorHandler)localIterator.next()).a = false;
    }
    localIterator = this.jdField_d_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      TransferRequest localTransferRequest = (TransferRequest)localIterator.next();
      ((ITransFileController)this.app.getRuntimeService(ITransFileController.class)).stop(localTransferRequest);
    }
    this.jdField_c_of_type_JavaUtilList.clear();
  }
  
  public void a()
  {
    this.jdField_f_of_type_Int = 178;
    super.a();
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView = ((ReadInJoyNinePicDeliverDynamicGridView)findViewById(2131376569));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367913));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379696));
    boolean bool = RIJUgcUtils.d();
    if ((!HotPicManager.a(this.app).b()) || (!bool) || (this.jdField_r_of_type_Int == 1)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    while ((this.jdField_r_of_type_Int == 1) || (!RIJUgcUtils.f()))
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    a(false);
  }
  
  public void a(Editable paramEditable)
  {
    super.a(paramEditable);
    if (b() != 0) {
      a(true);
    }
    for (;;)
    {
      if (a().intValue() < this.jdField_q_of_type_Int) {
        RIJDeliverUGCReportUtil.m();
      }
      return;
      if (paramEditable.length() <= 0)
      {
        a(false);
      }
      else if (this.jdField_r_of_type_Int == 1)
      {
        a(true);
        if (b() == 0) {
          this.rightViewText.setTextColor(Color.parseColor("#BBBBBB"));
        } else {
          this.rightViewText.setTextColor(Color.parseColor("#262626"));
        }
      }
      else
      {
        String str = UUID.randomUUID().toString();
        if (Utils.a(paramEditable.toString(), str).trim().length() <= 0) {
          a(false);
        } else {
          a(true);
        }
      }
    }
  }
  
  public void a(PicEmoticonInfo paramPicEmoticonInfo)
  {
    getActivity().getApplicationContext();
    a(true);
  }
  
  public void a(HotPicData paramHotPicData)
  {
    if ((paramHotPicData != null) && (paramHotPicData.url != null))
    {
      a(paramHotPicData);
      a(true);
      RIJDeliverUGCReportUtil.i();
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverUGCActivity", 2, "url=" + paramHotPicData.url);
      }
    }
  }
  
  public void a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.a(paramCharSequence, paramInt1, paramInt2, paramInt3);
    this.jdField_q_of_type_Int = a().intValue();
    if (paramInt3 < paramInt2) {
      e(paramCharSequence.length());
    }
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 1135	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:getCurrentAccountUin	()Ljava/lang/String;
    //   4: new 1137	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity$14
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 1138	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity$14:<init>	(Lcom/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity;)V
    //   12: invokestatic 1143	com/tencent/mobileqq/pic/aio/AioPicTransFileController:a	(Ljava/lang/String;Lcom/tencent/mobileqq/transfile/api/impl/TransFileControllerImpl$OnCancelListener;)V
    //   15: invokestatic 377	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   18: ifeq +13 -> 31
    //   21: ldc_w 379
    //   24: iconst_2
    //   25: ldc_w 1145
    //   28: invokestatic 384	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: aload_0
    //   32: invokespecial 1147	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:f	()Ljava/lang/String;
    //   35: aload_0
    //   36: invokespecial 146	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:b	()I
    //   39: aload_0
    //   40: invokespecial 1149	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:e	()Ljava/lang/String;
    //   43: invokestatic 1151	com/tencent/biz/pubaccount/readinjoy/ugc/RIJDeliverUGCReportUtil:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: ldc_w 349
    //   49: invokestatic 355	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   52: checkcast 349	com/tencent/biz/pubaccount/api/IPublicAccountReportUtils
    //   55: aconst_null
    //   56: ldc 122
    //   58: ldc_w 1153
    //   61: ldc_w 1153
    //   64: iconst_0
    //   65: iconst_0
    //   66: aload_0
    //   67: invokespecial 1155	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:a	()I
    //   70: invokestatic 364	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   73: aload_0
    //   74: invokespecial 146	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:b	()I
    //   77: invokestatic 472	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   80: invokevirtual 1156	java/lang/Integer:toString	()Ljava/lang/String;
    //   83: ldc 122
    //   85: aload_0
    //   86: invokevirtual 1158	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:b	()Ljava/lang/String;
    //   89: iconst_0
    //   90: invokeinterface 372 12 0
    //   95: aload_0
    //   96: invokespecial 1160	com/tencent/biz/pubaccount/readinjoy/activity/ReadInJoyBaseDeliverActivity:a	()Z
    //   99: ifne +5 -> 104
    //   102: iconst_0
    //   103: ireturn
    //   104: aload_0
    //   105: invokespecial 146	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:b	()I
    //   108: ifne +167 -> 275
    //   111: iconst_1
    //   112: istore_1
    //   113: aload_0
    //   114: getfield 129	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   117: ldc_w 1162
    //   120: iload_1
    //   121: invokevirtual 263	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   124: pop
    //   125: aload_0
    //   126: ldc_w 1163
    //   129: invokevirtual 1165	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:d	(I)V
    //   132: aload_0
    //   133: iconst_1
    //   134: putfield 93	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:u	Z
    //   137: aload_0
    //   138: new 66	java/util/ArrayList
    //   141: dup
    //   142: invokespecial 67	java/util/ArrayList:<init>	()V
    //   145: putfield 332	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   148: aload_0
    //   149: getfield 149	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_a_of_type_AndroidWidgetEditText	Landroid/widget/EditText;
    //   152: aload_0
    //   153: getfield 489	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   156: invokevirtual 916	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   159: aload_0
    //   160: getfield 717	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_o_of_type_Boolean	Z
    //   163: aload_0
    //   164: getfield 332	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   167: invokestatic 1168	com/tencent/biz/pubaccount/readinjoy/ugc/Utils:a	(Landroid/widget/EditText;Ljava/lang/String;ZLjava/util/List;)Z
    //   170: pop
    //   171: aload_0
    //   172: invokestatic 422	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   175: putfield 131	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_b_of_type_Long	J
    //   178: iload_1
    //   179: iconst_1
    //   180: if_icmpne +149 -> 329
    //   183: aload_0
    //   184: getfield 129	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   187: ldc_w 1170
    //   190: iconst_0
    //   191: invokevirtual 263	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   194: pop
    //   195: invokestatic 485	com/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyLogicEngine:a	()Lcom/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyLogicEngine;
    //   198: aload_0
    //   199: getfield 489	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   202: invokevirtual 494	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   205: aload_0
    //   206: getfield 281	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   209: aload_0
    //   210: getfield 496	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   213: aload_0
    //   214: getfield 498	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_n_of_type_Int	I
    //   217: aload_0
    //   218: getfield 71	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   221: aload_0
    //   222: invokevirtual 499	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:c	()Ljava/lang/String;
    //   225: aconst_null
    //   226: aload_0
    //   227: getfield 100	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity$DeliverData	Lcom/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity$DeliverData;
    //   230: invokevirtual 507	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity$DeliverData:b	()[I
    //   233: aload_0
    //   234: getfield 100	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity$DeliverData	Lcom/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity$DeliverData;
    //   237: invokevirtual 505	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity$DeliverData:a	()[I
    //   240: aconst_null
    //   241: aload_0
    //   242: getfield 109	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:k	I
    //   245: aload_0
    //   246: getfield 332	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   249: aload_0
    //   250: getfield 511	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:w	Z
    //   253: aload_0
    //   254: getfield 243	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI	Lcom/tencent/mobileqq/troop/data/TroopBarPOI;
    //   257: aload_0
    //   258: getfield 185	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVisibleSetParam	Lcom/tencent/biz/pubaccount/readinjoy/struct/VisibleSetParam;
    //   261: aload_0
    //   262: getfield 513	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_r_of_type_Int	I
    //   265: invokevirtual 516	com/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyLogicEngine:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/lang/String;[Ljava/lang/String;[I[I[Ljava/lang/String;ILjava/util/ArrayList;ZLcom/tencent/mobileqq/troop/data/TroopBarPOI;Lcom/tencent/biz/pubaccount/readinjoy/struct/VisibleSetParam;I)V
    //   268: aload_0
    //   269: iconst_0
    //   270: putfield 93	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:u	Z
    //   273: iconst_1
    //   274: ireturn
    //   275: aload_0
    //   276: getfield 1172	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_m_of_type_Boolean	Z
    //   279: ifne +150 -> 429
    //   282: aload_0
    //   283: invokestatic 1177	com/tencent/mobileqq/utils/NetworkUtil:h	(Landroid/content/Context;)Z
    //   286: ifne +143 -> 429
    //   289: aload_0
    //   290: invokevirtual 1179	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:k	()V
    //   293: iconst_0
    //   294: ireturn
    //   295: astore_2
    //   296: ldc_w 379
    //   299: iconst_2
    //   300: new 395	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 396	java/lang/StringBuilder:<init>	()V
    //   307: ldc_w 1181
    //   310: invokevirtual 402	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: aload_2
    //   314: invokevirtual 1182	java/lang/Exception:toString	()Ljava/lang/String;
    //   317: invokevirtual 402	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: invokevirtual 417	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokestatic 384	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   326: goto -201 -> 125
    //   329: aload_0
    //   330: getfield 190	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyNinePicAdapter	Lcom/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyNinePicAdapter;
    //   333: invokevirtual 526	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyNinePicAdapter:a	()Ljava/util/List;
    //   336: astore_2
    //   337: iconst_0
    //   338: istore_1
    //   339: aload_2
    //   340: invokeinterface 590 1 0
    //   345: astore_2
    //   346: aload_2
    //   347: invokeinterface 595 1 0
    //   352: ifeq -79 -> 273
    //   355: aload_2
    //   356: invokeinterface 598 1 0
    //   361: astore_3
    //   362: aload_0
    //   363: getfield 93	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:u	Z
    //   366: ifeq +57 -> 423
    //   369: invokestatic 377	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   372: ifeq +30 -> 402
    //   375: ldc_w 379
    //   378: iconst_2
    //   379: new 395	java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial 396	java/lang/StringBuilder:<init>	()V
    //   386: ldc_w 1184
    //   389: invokevirtual 402	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: iload_1
    //   393: invokevirtual 405	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   396: invokevirtual 417	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: invokestatic 384	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   402: aload_0
    //   403: iload_1
    //   404: invokespecial 1186	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:a	(I)Z
    //   407: ifeq +9 -> 416
    //   410: aload_0
    //   411: aload_3
    //   412: iload_1
    //   413: invokespecial 1188	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:a	(Ljava/lang/Object;I)V
    //   416: iload_1
    //   417: iconst_1
    //   418: iadd
    //   419: istore_1
    //   420: goto -74 -> 346
    //   423: iconst_1
    //   424: ireturn
    //   425: astore_2
    //   426: goto -231 -> 195
    //   429: iconst_2
    //   430: istore_1
    //   431: goto -318 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	434	0	this	ReadInJoyDeliverUGCActivity
    //   112	319	1	i	int
    //   295	19	2	localException1	Exception
    //   336	20	2	localObject1	Object
    //   425	1	2	localException2	Exception
    //   361	51	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   113	125	295	java/lang/Exception
    //   183	195	425	java/lang/Exception
  }
  
  /* Error */
  public String b(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: iconst_0
    //   4: aload_1
    //   5: bipush 46
    //   7: invokevirtual 1194	java/lang/String:indexOf	(I)I
    //   10: invokevirtual 1197	java/lang/String:substring	(II)Ljava/lang/String;
    //   13: astore 5
    //   15: aload_1
    //   16: aload_1
    //   17: bipush 46
    //   19: invokevirtual 1194	java/lang/String:indexOf	(I)I
    //   22: invokevirtual 347	java/lang/String:substring	(I)Ljava/lang/String;
    //   25: astore 4
    //   27: new 395	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 396	java/lang/StringBuilder:<init>	()V
    //   34: aload 5
    //   36: invokevirtual 402	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc_w 1199
    //   42: invokevirtual 402	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 417	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: astore 5
    //   50: new 395	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 396	java/lang/StringBuilder:<init>	()V
    //   57: aload 5
    //   59: invokevirtual 402	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload 4
    //   64: invokevirtual 402	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 417	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: astore 5
    //   72: new 289	java/io/File
    //   75: dup
    //   76: aload 5
    //   78: invokespecial 290	java/io/File:<init>	(Ljava/lang/String;)V
    //   81: invokevirtual 293	java/io/File:exists	()Z
    //   84: ifeq +12 -> 96
    //   87: aload_0
    //   88: aload 5
    //   90: invokevirtual 533	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:b	(Ljava/lang/String;)Ljava/lang/String;
    //   93: astore_3
    //   94: aload_3
    //   95: areturn
    //   96: new 1201	java/io/FileInputStream
    //   99: dup
    //   100: aload_1
    //   101: invokespecial 1202	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   104: astore 4
    //   106: new 1204	java/io/FileOutputStream
    //   109: dup
    //   110: aload 5
    //   112: invokespecial 1205	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   115: astore_1
    //   116: sipush 1024
    //   119: newarray byte
    //   121: astore_3
    //   122: aload 4
    //   124: aload_3
    //   125: invokevirtual 1211	java/io/InputStream:read	([B)I
    //   128: istore_2
    //   129: iload_2
    //   130: ifle +53 -> 183
    //   133: aload_1
    //   134: aload_3
    //   135: iconst_0
    //   136: iload_2
    //   137: invokevirtual 1217	java/io/OutputStream:write	([BII)V
    //   140: goto -18 -> 122
    //   143: astore_3
    //   144: aload 4
    //   146: astore_3
    //   147: aload_0
    //   148: getfield 124	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   151: astore 4
    //   153: aload_3
    //   154: ifnull +7 -> 161
    //   157: aload_3
    //   158: invokevirtual 1220	java/io/InputStream:close	()V
    //   161: aload 4
    //   163: astore_3
    //   164: aload_1
    //   165: ifnull -71 -> 94
    //   168: aload_1
    //   169: invokevirtual 1221	java/io/OutputStream:close	()V
    //   172: aload 4
    //   174: areturn
    //   175: astore_1
    //   176: aload_1
    //   177: invokevirtual 1222	java/io/IOException:printStackTrace	()V
    //   180: aload 4
    //   182: areturn
    //   183: aload_0
    //   184: getfield 69	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   187: aload 5
    //   189: invokeinterface 702 2 0
    //   194: pop
    //   195: aload 4
    //   197: ifnull +8 -> 205
    //   200: aload 4
    //   202: invokevirtual 1220	java/io/InputStream:close	()V
    //   205: aload 5
    //   207: astore_3
    //   208: aload_1
    //   209: ifnull -115 -> 94
    //   212: aload_1
    //   213: invokevirtual 1221	java/io/OutputStream:close	()V
    //   216: aload 5
    //   218: areturn
    //   219: astore_1
    //   220: aload_1
    //   221: invokevirtual 1222	java/io/IOException:printStackTrace	()V
    //   224: aload 5
    //   226: areturn
    //   227: astore_3
    //   228: aload_3
    //   229: invokevirtual 1222	java/io/IOException:printStackTrace	()V
    //   232: goto -27 -> 205
    //   235: astore_3
    //   236: aload_3
    //   237: invokevirtual 1222	java/io/IOException:printStackTrace	()V
    //   240: goto -79 -> 161
    //   243: astore_3
    //   244: aconst_null
    //   245: astore_1
    //   246: aconst_null
    //   247: astore 4
    //   249: aload 4
    //   251: ifnull +8 -> 259
    //   254: aload 4
    //   256: invokevirtual 1220	java/io/InputStream:close	()V
    //   259: aload_1
    //   260: ifnull +7 -> 267
    //   263: aload_1
    //   264: invokevirtual 1221	java/io/OutputStream:close	()V
    //   267: aload_3
    //   268: athrow
    //   269: astore 4
    //   271: aload 4
    //   273: invokevirtual 1222	java/io/IOException:printStackTrace	()V
    //   276: goto -17 -> 259
    //   279: astore_1
    //   280: aload_1
    //   281: invokevirtual 1222	java/io/IOException:printStackTrace	()V
    //   284: goto -17 -> 267
    //   287: astore_3
    //   288: aconst_null
    //   289: astore_1
    //   290: goto -41 -> 249
    //   293: astore_3
    //   294: goto -45 -> 249
    //   297: astore 5
    //   299: aload_3
    //   300: astore 4
    //   302: aload 5
    //   304: astore_3
    //   305: goto -56 -> 249
    //   308: astore_1
    //   309: aconst_null
    //   310: astore_1
    //   311: goto -164 -> 147
    //   314: astore_1
    //   315: aconst_null
    //   316: astore_1
    //   317: aload 4
    //   319: astore_3
    //   320: goto -173 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	this	ReadInJoyDeliverUGCActivity
    //   0	323	1	paramString	String
    //   128	9	2	i	int
    //   1	134	3	localObject1	Object
    //   143	1	3	localException	Exception
    //   146	62	3	localObject2	Object
    //   227	2	3	localIOException1	java.io.IOException
    //   235	2	3	localIOException2	java.io.IOException
    //   243	25	3	localObject3	Object
    //   287	1	3	localObject4	Object
    //   293	7	3	localObject5	Object
    //   304	16	3	localObject6	Object
    //   25	230	4	localObject7	Object
    //   269	3	4	localIOException3	java.io.IOException
    //   300	18	4	localObject8	Object
    //   13	212	5	str	String
    //   297	6	5	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   116	122	143	java/lang/Exception
    //   122	129	143	java/lang/Exception
    //   133	140	143	java/lang/Exception
    //   183	195	143	java/lang/Exception
    //   168	172	175	java/io/IOException
    //   212	216	219	java/io/IOException
    //   200	205	227	java/io/IOException
    //   157	161	235	java/io/IOException
    //   96	106	243	finally
    //   254	259	269	java/io/IOException
    //   263	267	279	java/io/IOException
    //   106	116	287	finally
    //   116	122	293	finally
    //   122	129	293	finally
    //   133	140	293	finally
    //   183	195	293	finally
    //   147	153	297	finally
    //   96	106	308	java/lang/Exception
    //   106	116	314	java/lang/Exception
  }
  
  public void b()
  {
    boolean bool = false;
    this.jdField_n_of_type_Boolean = true;
    this.jdField_o_of_type_Boolean = true;
    this.jdField_h_of_type_Boolean = getIntent().getBooleanExtra("support_topic", false);
    this.jdField_i_of_type_Boolean = getIntent().getBooleanExtra("support_linkify", true);
    super.b();
    this.jdField_d_of_type_JavaLangString = "0X800865D";
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyNinePicAdapter = new ReadInJoyNinePicAdapter(getApplicationContext(), 3);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyNinePicAdapter.a(new ReadInJoyDeliverUGCActivity.1(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyNinePicAdapter.a(new ReadInJoyDeliverUGCActivity.2(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView.setOnItemLongClickListener(new ReadInJoyDeliverUGCActivity.3(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView.setOnDragListener(new ReadInJoyDeliverUGCActivity.4(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyNinePicAdapter);
    p();
    this.jdField_f_of_type_JavaLangString = getIntent().getStringExtra("arg_topic_id");
    this.jdField_g_of_type_JavaLangString = getIntent().getStringExtra("arg_topic_name");
    this.jdField_n_of_type_Int = getIntent().getIntExtra("arg_ad_tag", 0);
    this.jdField_h_of_type_JavaLangString = getIntent().getStringExtra("arg_ugc_edit_cookie");
    this.w = getIntent().getBooleanExtra("is_from_dian_dian", false);
    this.x = getIntent().getBooleanExtra("is_from_kan_dian", false);
    this.y = getIntent().getBooleanExtra("is_from_poly_topic", false);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "initData mTopicId=" + this.jdField_f_of_type_JavaLangString + ", mTopicName=" + this.jdField_g_of_type_JavaLangString + ", mAdTag=" + this.jdField_n_of_type_Int);
    }
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    String str1;
    if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
    {
      str1 = "0";
      if (!this.w) {
        break label436;
      }
    }
    label436:
    for (String str2 = "1";; str2 = "2")
    {
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, "", "0X8008237", "0X8008237", 0, 0, "", str1, str2, RIJTransMergeKanDianReport.c(), false);
      if (ReadInJoyHelper.k(this.app) == 0) {
        bool = true;
      }
      this.jdField_g_of_type_Boolean = bool;
      if ((!this.jdField_g_of_type_Boolean) && (this.jdField_b_of_type_AndroidWidgetImageView != null)) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      q();
      return;
      str1 = String.valueOf(this.jdField_f_of_type_JavaLangString);
      break;
    }
  }
  
  public void b(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.b(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if (!this.z)
    {
      RIJDeliverUGCReportUtil.a();
      this.z = true;
    }
    if (RIJDeliverUGCReportUtil.a(paramCharSequence.toString()))
    {
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "onTextChanged | insert Emoji");
      RIJDeliverUGCReportUtil.f();
    }
  }
  
  public void c()
  {
    super.c();
    RIJDeliverUGCReportUtil.j();
  }
  
  public void c(int paramInt)
  {
    this.jdField_i_of_type_Int = 1;
    super.c(paramInt);
    RIJDeliverUGCReportUtil.b(String.valueOf(paramInt));
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800957A", "0X800957A", 0, 0, "", "", "", RIJTransMergeKanDianReport.c(), false);
  }
  
  public void d()
  {
    super.d();
  }
  
  public void d(int paramInt)
  {
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnDismissListener(new ReadInJoyDeliverUGCActivity.17(this));
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(paramInt);
    if (!this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    if (paramMotionEvent.getAction() == 0) {
      this.jdField_c_of_type_Float = paramMotionEvent.getY();
    }
    if (paramMotionEvent.getAction() == 1)
    {
      this.jdField_d_of_type_Float = paramMotionEvent.getY();
      if ((this.jdField_c_of_type_Float - this.jdField_d_of_type_Float > 50.0F) || (this.jdField_d_of_type_Float - this.jdField_c_of_type_Float > 50.0F)) {
        this.jdField_q_of_type_Boolean = false;
      }
      if (!this.jdField_q_of_type_Boolean) {
        break label116;
      }
      f(this.jdField_m_of_type_Int);
      this.jdField_q_of_type_Boolean = false;
    }
    for (;;)
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
      return bool;
      label116:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView.a();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131560286);
    PtvFilterSoLoad.a(this.app, BaseApplicationImpl.getContext());
    overridePendingTransition(2130771981, 2130771979);
    if (isInMultiWindow())
    {
      QQToast.a(this, HardCodeUtil.a(2131712764), 0).a();
      finish();
      return true;
    }
    this.jdField_r_of_type_Int = getIntent().getIntExtra("ugcPushType", 0);
    if (this.jdField_r_of_type_Int == 1) {
      a(2131718208);
    }
    for (;;)
    {
      a();
      b();
      RIJDtReportHelper.a.a(getActivity());
      return true;
      a(2131718217);
    }
  }
  
  public void doOnDestroy()
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ReadInJoyDeliverUGCActivity.UGCTransProcessorHandler localUGCTransProcessorHandler = (ReadInJoyDeliverUGCActivity.UGCTransProcessorHandler)localIterator.next();
      ((ITransFileController)this.app.getRuntimeService(ITransFileController.class)).removeHandle(localUGCTransProcessorHandler);
    }
    this.jdField_c_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    super.doOnDestroy();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (this.jdField_o_of_type_Int == 1002)
    {
      String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      this.l = paramIntent.getIntExtra("PhotoConst.readinjoy_delete_pic_position", 0);
      if ((!TextUtils.isEmpty(str)) && (this.l < this.jdField_b_of_type_JavaUtilList.size()))
      {
        this.jdField_b_of_type_JavaUtilList.remove(this.l);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyNinePicAdapter.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyNinePicAdapter.a().get(this.l));
        b(str, this.l);
        this.jdField_e_of_type_JavaUtilList.add(str);
      }
    }
    if (this.jdField_o_of_type_Int == 1001)
    {
      paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      if (!TextUtils.isEmpty(paramIntent)) {
        a(paramIntent);
      }
    }
    label245:
    do
    {
      do
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyDeliverUGCActivity", 2, "doOnNewIntent mRequestCode=" + this.jdField_o_of_type_Int + ", path=");
        }
        a(true);
        this.rightViewText.setTextColor(Color.parseColor("#262626"));
        this.jdField_o_of_type_Int = 0;
        this.jdField_b_of_type_Int = 0;
        return;
      } while (this.jdField_o_of_type_Int != 1000);
      int i;
      if (9 - b() == 1)
      {
        paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        if (!(paramIntent instanceof String)) {
          break label327;
        }
        paramIntent = (String)paramIntent;
        if (!TextUtils.isEmpty(paramIntent)) {
          a(paramIntent);
        }
        i = 1;
      }
      for (;;)
      {
        this.s = true;
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800823A", "0X800823A", 0, 0, String.valueOf(i), "", "", RIJTransMergeKanDianReport.c(), false);
        break;
        paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        break label245;
        if (paramIntent == null) {
          break label351;
        }
        paramIntent = (List)paramIntent;
        i = paramIntent.size();
        a(paramIntent);
      }
    } while (!QLog.isColorLevel());
    label327:
    label351:
    QLog.d("ReadInJoyDeliverUGCActivity", 2, "error  back empty path ");
  }
  
  public void doOnPostResume()
  {
    super.doOnPostResume();
    AbstractGifImage.resumeAll();
    RIJDeliverUGCReportUtil.a("：");
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
  }
  
  public void e()
  {
    super.e();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800823E", "0X800823E", 0, 0, "" + a(), "", "", RIJTransMergeKanDianReport.c(), false);
  }
  
  public void f()
  {
    super.f();
    RIJDeliverUGCReportUtil.c("1");
  }
  
  public void finish()
  {
    if (this.jdField_a_of_type_OrgJsonJSONObject != null)
    {
      String str = this.jdField_a_of_type_OrgJsonJSONObject.toString();
      getIntent().putExtra("arg_result_json", str);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverUGCActivity", 2, "finish resultJson=" + a(str));
      }
    }
    super.finish();
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "onEmotionBtn!");
    }
    RIJDeliverUGCReportUtil.e();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800823F", "0X800823F", 0, 0, "", "", "", RIJTransMergeKanDianReport.c(), false);
    super.g();
  }
  
  public void i()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800823D", "0X800823D", 0, 0, "", "", "", a(1), false);
    ThreadManager.getSubThreadHandler().post(new ReadInJoyDeliverUGCActivity.13(this));
  }
  
  public void j()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800823D", "0X800823D", 0, 0, "", "", "", a(2), false);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyDraftboxItem$ReadInJoyDraftboxContent != null) {
      ThreadManager.getSubThreadHandler().post(new ReadInJoyDeliverUGCActivity.12(this));
    }
    for (;;)
    {
      w();
      finish();
      return;
      s();
    }
  }
  
  public void l()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  protected void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "onGifBtn!");
    }
    if (this.jdField_a_of_type_Int == 3) {
      b(1);
    }
    for (;;)
    {
      RIJDeliverUGCReportUtil.h();
      return;
      b(3);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008449", "0X8008449", 0, 0, "", "", "", RIJTransMergeKanDianReport.c(), false);
    }
  }
  
  protected void n()
  {
    if (this.jdField_c_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_c_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      this.jdField_c_of_type_ComTencentWidgetActionSheet.addButton(2131718207, 5);
      this.jdField_c_of_type_ComTencentWidgetActionSheet.addButton(2131718209, 5);
      this.jdField_c_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690800);
      this.jdField_c_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new ReadInJoyDeliverUGCActivity.8(this));
      this.jdField_c_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new ReadInJoyDeliverUGCActivity.9(this));
    }
    if (!this.jdField_c_of_type_ComTencentWidgetActionSheet.isShowing())
    {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      this.jdField_r_of_type_Boolean = false;
      this.jdField_c_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  public void o()
  {
    v();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800823A", "0X800823A", 0, 0, "", "", "", RIJTransMergeKanDianReport.c(), false);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1002))
    {
      paramInt1 = paramIntent.getIntExtra("PhotoConst.readinjoy_delete_pic_position", -1);
      if (paramInt1 != -1) {
        i(paramInt1);
      }
      this.jdField_b_of_type_Int = 0;
    }
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 3))
    {
      b(0);
      return true;
    }
    if (((this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString().trim().length() > 0) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyNinePicAdapter.a().size() > 1)) && (!this.t))
    {
      h();
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      super.onClick(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      m();
      continue;
      if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 3)) {
        b(0);
      }
      if (((this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString().trim().length() > 0) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyNinePicAdapter.a().size() > 1)) && (!this.t))
      {
        h();
      }
      else
      {
        finish();
        continue;
        if ((this.jdField_r_of_type_Int == 1) && (b() == 0)) {
          QQToast.a(this, 1, HardCodeUtil.a(2131712887), 0).a();
        } else {
          a();
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onPause()
  {
    super.onPause();
    AbstractGifImage.pauseAll();
  }
  
  public void p()
  {
    List localList = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyNinePicAdapter.a();
    if (localList.size() == 0) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyNinePicAdapter.c(this.jdField_e_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyNinePicAdapter.notifyDataSetChanged();
      return;
      if ((localList.size() < 9) && (!localList.get(localList.size() - 1).equals(this.jdField_e_of_type_JavaLangString))) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyNinePicAdapter.c(this.jdField_e_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity
 * JD-Core Version:    0.7.0.1
 */