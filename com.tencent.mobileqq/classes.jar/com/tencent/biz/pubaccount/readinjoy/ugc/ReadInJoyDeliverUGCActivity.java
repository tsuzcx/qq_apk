package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.HotPicDownLoader;
import com.tencent.mobileqq.hotpic.HotPicManager;
import com.tencent.mobileqq.hotpic.HotPicPageView;
import com.tencent.mobileqq.hotpic.HotVideoData;
import com.tencent.mobileqq.hotpic.HotVideoPreviewDownloader;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import mbn;
import mbo;
import mbq;
import mbr;
import mbs;
import mbt;
import mbu;
import org.json.JSONObject;

public class ReadInJoyDeliverUGCActivity
  extends ReadInJoyBaseDeliverActivity
{
  public static Drawable a;
  private long jdField_a_of_type_Long;
  ReadInJoyObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new mbu(this);
  private HotPicData jdField_a_of_type_ComTencentMobileqqHotpicHotPicData;
  private CompressInfo jdField_a_of_type_ComTencentMobileqqPicCompressInfo;
  public TransProcessorHandler a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
  private long jdField_b_of_type_Long;
  private ActionSheet jdField_b_of_type_ComTencentWidgetActionSheet;
  private long jdField_c_of_type_Long;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private String jdField_c_of_type_JavaLangString;
  private long jdField_d_of_type_Long;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private String jdField_d_of_type_JavaLangString;
  private long jdField_e_of_type_Long;
  private String jdField_e_of_type_JavaLangString = "";
  private long jdField_f_of_type_Long;
  private String jdField_f_of_type_JavaLangString = "";
  private long jdField_g_of_type_Long;
  private String jdField_g_of_type_JavaLangString = "";
  private int i;
  private int j = 0;
  private int k;
  private int l;
  private boolean n;
  private boolean o;
  private boolean p;
  private boolean q;
  private boolean r;
  
  static
  {
    jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(-855310);
  }
  
  public ReadInJoyDeliverUGCActivity()
  {
    this.jdField_k_of_type_Int = 20000;
    this.jdField_l_of_type_Int = 3;
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new mbt(this);
  }
  
  private int a()
  {
    if (this.jdField_l_of_type_Int == 3) {
      if (TextUtils.isEmpty(b())) {
        if (this.q) {}
      }
    }
    do
    {
      return 6;
      return 4;
      if (!this.q) {
        return 3;
      }
      return 5;
      if (!TextUtils.isEmpty(b())) {
        break;
      }
    } while (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString));
    return 1;
    if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
      return 3;
    }
    return 2;
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
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return paramString.replace("\\/", "/").replaceAll("http://qqpublic.qpic.cn/qq_public/", "");
  }
  
  private void c(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    StatisticCollector localStatisticCollector = StatisticCollector.a(this);
    String str = this.app.getCurrentAccountUin();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localStatisticCollector.a(str, "actReadInJoyUGCPicture", bool, l1 - l2, 0L, localHashMap, "");
      return;
    }
  }
  
  private void d(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
    localIntent.putExtra("back_btn_text", "返回");
    localIntent.putExtra("from_readinjoy_ugc_preview", true);
    localIntent.putExtra("keep_selected_status_after_finish", true);
    localIntent.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", true);
    localIntent.setClass(this, PhotoPreviewActivity.class);
    startActivityForResult(localIntent, 1002);
    this.j = 1002;
    overridePendingTransition(2131034373, 2131034375);
  }
  
  private void k()
  {
    if ((this.q) && (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData != null))
    {
      if (HotPicPageView.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData) == 0)
      {
        String str = HotPicDownLoader.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.url).getAbsolutePath();
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyDeliverUGCActivity", 2, "senHotPic, urlHotPic = " + this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.url + ", paths = " + str);
        }
        d(str);
      }
      return;
    }
    if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
    {
      j();
      PublicAccountReportUtils.a(null, "", "0X8008238", "0X8008238", 0, 0, "", "", "", ReadInJoyUtils.e(), false);
      return;
    }
    d(this.jdField_e_of_type_JavaLangString);
  }
  
  private void l()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    localIntent.putExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
    localIntent.putExtra("peak.myUin", this.app.getAccount());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ReadInJoyDeliverUGCActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", false);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    localIntent.putExtra("from_readinjoy_ugc", true);
    localIntent.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", true);
    localIntent.putExtra("PhotoConst.original_button", false);
    localIntent.setClass(this, PhotoListActivity.class);
    startActivityForResult(localIntent, 1000);
    this.j = 1000;
    overridePendingTransition(2131034123, 2131034121);
  }
  
  private void m()
  {
    if (QavCameraUsage.b(BaseApplicationImpl.getContext()))
    {
      a(1, getString(2131434809));
      return;
    }
    if (!Utils.a())
    {
      a(1, getString(2131434786));
      return;
    }
    PtvFilterSoLoad.a(this.app, BaseApplicationImpl.getContext());
    Object localObject = new File(AppConstants.aW);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = PlusPanelUtils.a(AppConstants.aW);
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), NewFlowCameraActivity.class);
    localIntent.putExtra("flow_camera_capture_mode", true);
    localIntent.putExtra("qcamera_photo_filepath", (String)localObject);
    localIntent.putExtra("flow_camera_use_filter_function", true);
    localIntent.putExtra("support_photo_shot", true);
    localIntent.putExtra("support_video_shot", false);
    localIntent.putExtra("flow_camera_video_mode", false);
    localIntent.putExtra("flow_camera_capture_mode", true);
    localIntent.putExtra("extra.busi_type", 8);
    localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", getClass().getName());
    localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    startActivityForResult(localIntent, 1001);
    this.j = 1001;
    overridePendingTransition(2131034123, 2131034121);
  }
  
  private void n()
  {
    Editable localEditable;
    if ((!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) || (this.q))
    {
      this.jdField_e_of_type_JavaLangString = "";
      this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo = null;
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130839740);
      this.jdField_c_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_l_of_type_Int = 3;
      localEditable = this.jdField_a_of_type_AndroidWidgetEditText.getText();
      if ((localEditable != null) && (localEditable.length() > 0)) {
        break label130;
      }
      a(false);
    }
    for (;;)
    {
      if (this.q)
      {
        this.q = false;
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData = null;
      }
      PublicAccountReportUtils.a(null, "", "0X800823C", "0X800823C", 0, 0, "", "", "", ReadInJoyUtils.e(), false);
      return;
      label130:
      String str = UUID.randomUUID().toString();
      if (a(localEditable.toString(), str).trim().length() <= 0) {
        a(false);
      } else {
        a(true);
      }
    }
  }
  
  private void o()
  {
    ThreadManager.executeOnFileThread(new mbr(this));
  }
  
  protected void a()
  {
    this.jdField_f_of_type_Int = 178;
    super.a();
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367075));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367076));
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366975));
    int m = ReadInJoyHelper.p(this.app);
    if ((!HotPicManager.a(this.app).b()) || (m == 1))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  protected void a(int paramInt)
  {
    super.a(paramInt);
    a(false);
  }
  
  protected void a(Editable paramEditable)
  {
    super.a(paramEditable);
    if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
    {
      a(true);
      return;
    }
    if (paramEditable.length() <= 0)
    {
      a(false);
      return;
    }
    String str = UUID.randomUUID().toString();
    if (a(paramEditable.toString(), str).trim().length() <= 0)
    {
      a(false);
      return;
    }
    a(true);
  }
  
  public void a(PicEmoticonInfo paramPicEmoticonInfo)
  {
    Context localContext = getActivity().getApplicationContext();
    this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(paramPicEmoticonInfo.a(localContext, localContext.getResources().getDisplayMetrics().density));
    this.jdField_c_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    a(true);
  }
  
  public void a(HotPicData paramHotPicData)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData = paramHotPicData;
    if ((this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData != null) && (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.url != null))
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData));
      this.jdField_c_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      a(true);
      this.o = true;
      this.q = true;
      this.jdField_l_of_type_Int = 3;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverUGCActivity", 2, "url=" + this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.url);
      }
    }
  }
  
  protected boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "onDeliver!");
    }
    PublicAccountReportUtils.a(null, "", "0X8008240", "0X8008240", 0, 0, String.valueOf(a()), "", "", ReadInJoyUtils.e(), false);
    if (!super.a()) {
      return false;
    }
    int m;
    if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
      m = 1;
    }
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("type", m);
      label78:
      this.jdField_e_of_type_Boolean = false;
      a(2131430109, 2131438908, this.jdField_k_of_type_Int);
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      a(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
      if ((this.q) && (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.url))) {
        ReadInJoyLogicEngine.a().a(this.app.c(), this.jdField_c_of_type_JavaLangString, this.i, 3, b(), this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.originalUrl, this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.width, this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.height, this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.md5, true, this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.url, this.jdField_l_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList, this.r);
      }
      for (;;)
      {
        return true;
        int i1 = 2;
        m = i1;
        if (this.jdField_k_of_type_Boolean) {
          break;
        }
        m = i1;
        if (NetworkUtil.h(this)) {
          break;
        }
        g();
        return false;
        if (m == 1) {}
        try
        {
          this.jdField_a_of_type_OrgJsonJSONObject.put("picCount", 0);
          label270:
          ReadInJoyLogicEngine.a().a(this.app.c(), this.jdField_c_of_type_JavaLangString, this.i, 1, b(), null, 0, 0, null, false, null, this.jdField_l_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList, this.r);
          continue;
          c(this.jdField_e_of_type_JavaLangString);
        }
        catch (Exception localException1)
        {
          break label270;
        }
      }
    }
    catch (Exception localException2)
    {
      break label78;
    }
  }
  
  protected void b()
  {
    boolean bool = false;
    this.jdField_l_of_type_Boolean = true;
    this.m = true;
    super.b();
    this.jdField_b_of_type_JavaLangString = "0X800865D";
    this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("arg_topic_id");
    this.jdField_d_of_type_JavaLangString = getIntent().getStringExtra("arg_topic_name");
    this.i = getIntent().getIntExtra("arg_ad_tag", 0);
    this.r = getIntent().getBooleanExtra("is_from_dian_dian", false);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "initData mTopicId=" + this.jdField_c_of_type_JavaLangString + ", mTopicName=" + this.jdField_d_of_type_JavaLangString + ", mAdTag=" + this.i);
    }
    String str1;
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      str1 = "0";
      if (!this.r) {
        break label263;
      }
    }
    label263:
    for (String str2 = "1";; str2 = "2")
    {
      PublicAccountReportUtils.a(null, "", "0X8008237", "0X8008237", 0, 0, "", str1, str2, ReadInJoyUtils.e(), false);
      if (ReadInJoyHelper.q(this.app) == 0) {
        bool = true;
      }
      this.jdField_g_of_type_Boolean = bool;
      if ((!this.jdField_g_of_type_Boolean) && (this.jdField_b_of_type_AndroidWidgetImageView != null)) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      return;
      str1 = String.valueOf(this.jdField_c_of_type_JavaLangString);
      break;
    }
  }
  
  protected void b(String paramString)
  {
    Object localObject;
    float f1;
    float f2;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = new File(paramString);
      if (((File)localObject).exists())
      {
        ThreadManager.executeOnSubThread(new mbn(this, (File)localObject));
        this.jdField_e_of_type_JavaLangString = paramString;
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
        BitmapFactory.decodeFile(this.jdField_e_of_type_JavaLangString, (BitmapFactory.Options)localObject);
        m = this.jdField_c_of_type_AndroidWidgetImageView.getWidth();
        int i1 = this.jdField_c_of_type_AndroidWidgetImageView.getHeight();
        f1 = ((BitmapFactory.Options)localObject).outWidth / m;
        f2 = ((BitmapFactory.Options)localObject).outHeight / i1;
        if ((f1 < 1.0F) || (f2 < 1.0F)) {
          break label251;
        }
      }
    }
    label251:
    for (int m = (int)Math.floor(Math.min(f1, f2));; m = 1)
    {
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      ((BitmapFactory.Options)localObject).inSampleSize = m;
      try
      {
        localObject = BitmapFactory.decodeFile(this.jdField_e_of_type_JavaLangString, (BitmapFactory.Options)localObject);
        localObject = a(a(this.jdField_e_of_type_JavaLangString), (Bitmap)localObject);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
        this.jdField_c_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        a(true);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyDeliverUGCActivity", 2, "setSelectedImage sampleSize=" + m + ", path=" + paramString);
        }
        return;
      }
      catch (OutOfMemoryError paramString)
      {
        return;
      }
    }
  }
  
  protected void c()
  {
    super.c();
    PublicAccountReportUtils.a(null, "", "0X800823D", "0X800823D", 0, 0, "" + a(), "", "", ReadInJoyUtils.e(), false);
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "startUploadPic path=" + paramString);
    }
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_e_of_type_Boolean = true;
      h();
      a(1, getString(2131438908));
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverUGCActivity", 2, "startUploadPic empty path!");
      }
      return;
    }
    ThreadManager.executeOnSubThread(new mbs(this, paramString));
  }
  
  protected void d()
  {
    super.d();
    PublicAccountReportUtils.a(null, "", "0X800823E", "0X800823E", 0, 0, "" + a(), "", "", ReadInJoyUtils.e(), false);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130969593);
    overridePendingTransition(2131034123, 2131034121);
    if (isInMultiWindow())
    {
      QQToast.a(this, "该功能无法在分屏模式下使用。", 0).a();
      finish();
      return true;
    }
    a(2131438903);
    a();
    b();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.a().b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    String str = null;
    if ((this.j == 1000) || (this.j == 1001) || (this.j == 1002))
    {
      str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverUGCActivity", 2, "doOnNewIntent mRequestCode=" + this.j + ", path=" + str);
      }
      this.o = true;
    }
    b(str);
    this.j = 0;
  }
  
  protected void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "onEmotionBtn!");
    }
    PublicAccountReportUtils.a(null, "", "0X800823F", "0X800823F", 0, 0, "", "", "", ReadInJoyUtils.e(), false);
    super.f();
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
    o();
    super.finish();
  }
  
  protected void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "onGifBtn!");
    }
    if (this.jdField_a_of_type_Int == 3)
    {
      b(1);
      return;
    }
    b(3);
    PublicAccountReportUtils.a(null, "", "0X8008449", "0X8008449", 0, 0, "", "", "", ReadInJoyUtils.e(), false);
  }
  
  protected void j()
  {
    if (this.jdField_b_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_b_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      this.jdField_b_of_type_ComTencentWidgetActionSheet.a(2131438905, 5);
      this.jdField_b_of_type_ComTencentWidgetActionSheet.a(2131438906, 5);
      this.jdField_b_of_type_ComTencentWidgetActionSheet.c(2131433029);
      this.jdField_b_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new mbo(this));
      this.jdField_b_of_type_ComTencentWidgetActionSheet.a(new mbq(this));
    }
    if (!this.jdField_b_of_type_ComTencentWidgetActionSheet.isShowing())
    {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      this.n = false;
      this.jdField_b_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  protected boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 3))
    {
      b(0);
      return true;
    }
    if (((this.jdField_b_of_type_Boolean) || (this.o)) && (!this.p))
    {
      a(false, 0, false, 0L);
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
      return;
    case 2131367075: 
      k();
      return;
    case 2131367076: 
      n();
      return;
    case 2131366975: 
      i();
      return;
    }
    if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 3)) {
      b(0);
    }
    if (((this.jdField_b_of_type_Boolean) || (this.o)) && (!this.p)) {
      a(false, 0, false, 0L);
    }
    for (;;)
    {
      PublicAccountReportUtils.a(null, "", "0X800823D", "0X800823D", 0, 0, "" + a(), "", "", ReadInJoyUtils.e(), false);
      return;
      finish();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    AbstractGifImage.pauseAll();
  }
  
  public void onResume()
  {
    super.onResume();
    AbstractGifImage.resumeAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity
 * JD-Core Version:    0.7.0.1
 */