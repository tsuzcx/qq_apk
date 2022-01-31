package com.tencent.biz.pubaccount.readinjoy.ugc;

import actj;
import ajya;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.PopupWindow;
import android.widget.TextView;
import axdu;
import axeq;
import axes;
import axrn;
import bbfj;
import bcql;
import bfnk;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyUgcVideoReportItem;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import nol;
import npu;
import oek;
import onh;
import osg;
import osj;
import osm;
import qew;
import qex;
import qez;
import qfa;
import qfb;
import qgo;
import rph;

public class ReadInJoyDeliverVideoActivity
  extends ReadInJoyBaseDeliverActivity
  implements Handler.Callback, axeq, axes
{
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private View jdField_a_of_type_AndroidViewView;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private CircleProgress jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress;
  private List<ReadInJoyUgcVideoReportItem> jdField_a_of_type_JavaUtilList;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new bfnk(Looper.getMainLooper(), this, true);
  private oek jdField_a_of_type_Oek;
  osm jdField_a_of_type_Osm = new qew(this);
  private long jdField_b_of_type_Long;
  protected Dialog b;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ArrayList<TagInfo> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private long jdField_d_of_type_Long;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private long jdField_e_of_type_Long;
  private String jdField_e_of_type_JavaLangString;
  private long jdField_f_of_type_Long;
  private String jdField_f_of_type_JavaLangString;
  private String g;
  private String h;
  private String i;
  private String j;
  private int k;
  private int l;
  private int m;
  private int n;
  private boolean q = true;
  private boolean r;
  private boolean s;
  private boolean t;
  private boolean u;
  private boolean v;
  private boolean w;
  private boolean x;
  private boolean y;
  
  public ReadInJoyDeliverVideoActivity()
  {
    this.jdField_h_of_type_JavaLangString = "";
  }
  
  private int a()
  {
    if (TextUtils.isEmpty(c())) {
      return 1;
    }
    return 2;
  }
  
  private Intent a()
  {
    Intent localIntent = getIntent();
    localIntent.putExtra("arg_video_path", this.jdField_e_of_type_JavaLangString);
    localIntent.putExtra("arg_video_cover", this.jdField_h_of_type_JavaLangString);
    localIntent.putExtra("supportShortVideo", this.t);
    localIntent.putExtra("shortVideoSoReady", this.u);
    localIntent.putExtra("commentString", c());
    localIntent.putExtra("mFakeVidForComposition", this.jdField_g_of_type_JavaLangString);
    localIntent.putParcelableArrayListExtra("mSelectedTagList", this.jdField_b_of_type_JavaUtilArrayList);
    localIntent.putExtra("arg_visible_set_params", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVisibleSetParam);
    if (this.s)
    {
      localIntent.putExtra("arg_video_cover", this.jdField_f_of_type_JavaLangString);
      localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null) {
      localIntent.putExtra("location", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
    }
    Bundle localBundle = localIntent.getExtras();
    localIntent.setClass(getApplicationContext(), KandianVideoUploadService.class);
    ArrayList localArrayList = new ArrayList();
    qgo.a(this.jdField_a_of_type_AndroidWidgetEditText, this.app.getCurrentAccountUin(), this.o, localArrayList);
    if (localBundle != null) {
      localBundle.putParcelableArrayList("multiBiuStruct", localArrayList);
    }
    localIntent.putExtras(localBundle);
    return localIntent;
  }
  
  private void a(float paramFloat)
  {
    if (this.jdField_b_of_type_AndroidViewView.getVisibility() != 0) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    if (this.jdField_c_of_type_AndroidViewView.getVisibility() != 0) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(paramFloat);
  }
  
  private void a(ArrayList<TagInfo> paramArrayList)
  {
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
    String str = getString(2131718566);
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localStringBuilder.append(paramArrayList.get(0));
      int i2 = paramArrayList.size();
      int i1 = 1;
      while (i1 < i2)
      {
        localStringBuilder.append("，").append(paramArrayList.get(i1));
        i1 += 1;
      }
      paramArrayList = localStringBuilder.toString();
      this.jdField_d_of_type_AndroidWidgetTextView.setSelected(true);
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramArrayList);
      return;
      this.jdField_d_of_type_AndroidWidgetTextView.setSelected(false);
      paramArrayList = str;
    }
  }
  
  private void c(String paramString)
  {
    Intent localIntent = new Intent(this, ShortVideoPreviewActivity.class);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ReadInJoyDeliverVideoActivity.class.getName());
    localIntent.putExtra("file_send_path", paramString);
    localIntent.putExtra("preview_only", true);
    startActivity(localIntent);
    overridePendingTransition(2130772271, 2130772273);
    nol.a(this.app, "", "0X80081D9", "0X80081D9", 0, 0, "", "2", "", npu.a(null), false);
  }
  
  private void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("ReadInJoyDeliverVideoActivity", 2, "king moment cover url is null");
      return;
    }
    rph localrph = new rph();
    try
    {
      localrph.jdField_a_of_type_JavaNetURL = new URL(paramString);
      localrph.b = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getHeight();
      localrph.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getWidth();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.a(localrph, new qez(this));
      return;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void n()
  {
    this.jdField_a_of_type_Oek = new oek();
    this.jdField_a_of_type_Oek.a(new qex(this));
    PublishParam localPublishParam = (PublishParam)getIntent().getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
    if (localPublishParam != null)
    {
      this.jdField_g_of_type_JavaLangString = localPublishParam.b;
      this.jdField_a_of_type_Oek.a(this.jdField_g_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
      QLog.d("ReadInJoyDeliverVideoActivity", 2, "initCompositionManager: performCompositeVideo");
      return;
    }
    QLog.d("ReadInJoyDeliverVideoActivity", 2, "initCompositionManager: publish param is null, no need to composite");
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setClickable(true);
    a(true);
  }
  
  private void o()
  {
    if ((this.k == 0) || (this.jdField_l_of_type_Int == 0))
    {
      localObject = ShortVideoTrimmer.a(this.jdField_e_of_type_JavaLangString);
      if ((localObject != null) && (localObject.length == 5))
      {
        this.k = localObject[1];
        this.jdField_l_of_type_Int = localObject[2];
        this.jdField_b_of_type_Long = localObject[4];
        getIntent().putExtra("arg_video_width", this.k);
        getIntent().putExtra("arg_video_height", this.jdField_l_of_type_Int);
        getIntent().putExtra("arg_video_duration", this.jdField_b_of_type_Long);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyDeliverVideoActivity", 2, "generateVideoInfo width=" + this.k + ", height=" + this.jdField_l_of_type_Int + ", duration=" + this.jdField_b_of_type_Long);
        }
      }
    }
    if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
      if (this.jdField_b_of_type_Long < 3000L) {
        break label256;
      }
    }
    label256:
    for (Object localObject = ShortVideoUtils.a(this, this.jdField_e_of_type_JavaLangString, 640, 3000000L);; localObject = ShortVideoUtils.a(this, this.jdField_e_of_type_JavaLangString, 640))
    {
      this.jdField_f_of_type_JavaLangString = ShortVideoPreviewActivity.a((Bitmap)localObject);
      getIntent().putExtra("arg_video_cover", this.jdField_f_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverVideoActivity", 2, "generateVideoInfo cover=" + this.jdField_f_of_type_JavaLangString);
      }
      return;
    }
  }
  
  private void p()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(0.0F);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void q()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      this.jdField_a_of_type_MqqOsMqqHandler.post(new ReadInJoyDeliverVideoActivity.6(this));
    }
    do
    {
      return;
      if (this.jdField_b_of_type_AndroidAppDialog == null)
      {
        this.jdField_b_of_type_AndroidAppDialog = a(this, null, getString(2131718602), new qfa(this), getString(2131718603), new qfb(this), getString(2131718604));
        this.jdField_b_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
      }
    } while (this.jdField_b_of_type_AndroidAppDialog.isShowing());
    this.jdField_b_of_type_AndroidAppDialog.show();
  }
  
  private void r()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      this.jdField_a_of_type_MqqOsMqqHandler.post(new ReadInJoyDeliverVideoActivity.9(this));
    }
    while ((this.jdField_b_of_type_AndroidAppDialog == null) || (!this.jdField_b_of_type_AndroidAppDialog.isShowing())) {
      return;
    }
    this.jdField_b_of_type_AndroidAppDialog.dismiss();
  }
  
  private void s()
  {
    this.t = VideoEnvironment.c(this.app);
    this.u = VideoEnvironment.e(this.app);
    if (!this.t)
    {
      VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", ajya.a(2131712936), null);
      return;
    }
    if (this.u)
    {
      VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", "短视频插件ready", null);
      return;
    }
    VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", "短视频插件not ready", null);
    if (bbfj.g(null))
    {
      VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", ajya.a(2131712891), null);
      ShortVideoResourceManager.b(this.app, this);
      this.v = true;
      return;
    }
    VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", ajya.a(2131712934), null);
  }
  
  private void t()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (localInputMethodManager != null) {
      localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    }
  }
  
  private void u()
  {
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363783));
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(LayoutInflater.from(this).inflate(2131560040, (ViewGroup)this.mContentView, false), -2, -2);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setAnimationStyle(2131755317);
    this.q = true;
  }
  
  private void v()
  {
    Intent localIntent = new Intent();
    localIntent.putParcelableArrayListExtra("EXTRA_SELECTED_TAG_LIST", this.jdField_b_of_type_JavaUtilArrayList);
    localIntent.putExtra("EXTRA_TOPIC_ID", this.jdField_a_of_type_JavaLangString);
    PublicFragmentActivity.a(this, localIntent, ReadInJoyVideoTagSelectionFragment.class, 1000);
    nol.a(null, "", "0X80092F1", "0X80092F1", 0, 0, "", "", "", onh.e(), false);
  }
  
  public void G_()
  {
    VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", ajya.a(2131713006), null);
    axdu.a(3, -1500);
    this.v = false;
  }
  
  public void a()
  {
    this.jdField_f_of_type_Int = 178;
    super.a();
    this.jdField_a_of_type_AndroidViewView = findViewById(2131378570);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setClickable(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)findViewById(2131378571));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378572));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378569));
    this.jdField_c_of_type_AndroidViewView = new View(this);
    this.jdField_c_of_type_AndroidViewView.setBackgroundColor(1996488704);
    addContentView(this.jdField_c_of_type_AndroidViewView, new ViewGroup.LayoutParams(-1, -1));
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView = View.inflate(this, 2131560045, null);
    addContentView(this.jdField_b_of_type_AndroidViewView, new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = ((CircleProgress)this.jdField_b_of_type_AndroidViewView.findViewById(2131378662));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(5.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(100, -1, 100, getResources().getColor(2131166730));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131363862));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    u();
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    setRightButton(2131718442, this);
    a(false);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", "onConfigResult result=" + paramInt1 + ", serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", ajya.a(2131712935) + paramInt2 + "]", null);
        axdu.a(1, paramInt2);
        this.v = false;
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a(this.app, localArrayList);
      if (paramInt1 == 0)
      {
        VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", ajya.a(2131713022), null);
        ShortVideoResourceManager.a(this.app, localArrayList, this);
        return;
      }
      VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", ajya.a(2131713028) + paramInt1 + "]", null);
      axdu.a(1, paramInt1);
      this.v = false;
      return;
    }
    VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", ajya.a(2131712818) + paramInt2 + "]", null);
    axdu.a(1, paramInt2);
    this.v = false;
  }
  
  public void a(Editable paramEditable)
  {
    super.a(paramEditable);
    int i1 = paramEditable.length();
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_c_of_type_Int - i1));
    }
    if (i1 - this.jdField_c_of_type_Int > 0)
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF4222"));
      }
      this.jdField_d_of_type_Boolean = true;
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#BBBBBB"));
    }
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_"))
    {
      if (paramInt == 0) {
        break label108;
      }
      VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", ajya.a(2131712839) + paramInt + "]", null);
      axdu.a(2, paramInt);
    }
    for (;;)
    {
      this.v = false;
      VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", "onDownloadFinish name=" + paramString1 + ", result=" + paramInt + ", filePath=" + paramString2, null);
      return;
      label108:
      this.u = true;
      VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", ajya.a(2131712927) + paramInt + "]", null);
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2) {}
  
  public boolean a()
  {
    this.jdField_f_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverVideoActivity", 2, "onDeliver!");
    }
    nol.a(this.app, "", "0X80081D8", "0X80081D8", 0, 0, "1", "2", "", npu.a(null), false);
    nol.a(null, "", "0X8008245", "0X8008245", 0, 0, String.valueOf(a()), "", "", b(), false);
    if ((this.jdField_h_of_type_JavaLangString.equals("")) && (!this.s))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverVideoActivity", 2, "onDeliver no video!");
      }
      a(1, getString(2131718441));
    }
    while (!super.a()) {
      return false;
    }
    t();
    if (KandianVideoUploadService.a() >= 2)
    {
      bcql.a(this, 0, getString(2131718435), 0).b(getResources().getDimensionPixelSize(2131298865));
      return false;
    }
    Intent localIntent = a();
    try
    {
      startService(localIntent);
      QLog.d("ReadInJoyDeliverVideoActivity", 1, "start video upload Service!");
      label200:
      if (this.y) {
        KandianSubscribeManager.a(this, 4);
      }
      for (;;)
      {
        finish();
        return true;
        osg.a().b(true);
      }
    }
    catch (Throwable localThrowable)
    {
      break label200;
    }
  }
  
  public void b()
  {
    this.jdField_l_of_type_Boolean = true;
    this.jdField_n_of_type_Boolean = true;
    this.o = true;
    this.jdField_h_of_type_Boolean = true;
    super.b();
    this.jdField_d_of_type_JavaLangString = "0X800865E";
    Object localObject = getIntent();
    this.jdField_e_of_type_JavaLangString = ((Intent)localObject).getStringExtra("arg_video_path");
    this.jdField_f_of_type_JavaLangString = ((Intent)localObject).getStringExtra("arg_video_cover");
    this.k = ((Intent)localObject).getIntExtra("arg_video_width", 0);
    this.jdField_l_of_type_Int = ((Intent)localObject).getIntExtra("arg_video_height", 0);
    this.jdField_b_of_type_Long = ((Intent)localObject).getLongExtra("arg_video_duration", 0L);
    this.s = ((Intent)localObject).getBooleanExtra("arg_is_from_wang_zhe", false);
    this.jdField_c_of_type_Long = ((Intent)localObject).getLongExtra("arg_wang_zhe_app_id", 0L);
    this.x = ((Intent)localObject).getBooleanExtra("is_from_dian_dian", false);
    this.y = ((Intent)localObject).getBooleanExtra("is_from_kan_dian", false);
    this.j = ((Intent)localObject).getStringExtra("captureMode");
    this.jdField_a_of_type_JavaUtilList = ((Intent)localObject).getParcelableArrayListExtra("key_read_in_joy_video_upload_report");
    osj.a().a(this.jdField_a_of_type_Osm);
    o();
    b(this.jdField_f_of_type_JavaLangString);
    int i1 = ((Intent)localObject).getIntExtra("arg_video_source", 0);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localObject = "0";
      if (!this.x) {
        break label331;
      }
    }
    label331:
    for (String str = "1";; str = "2")
    {
      nol.a(null, "", "0X8008241", "0X8008241", 0, 0, String.valueOf(i1), (String)localObject, str, onh.e(), false);
      this.jdField_g_of_type_Boolean = true;
      if ((!this.jdField_g_of_type_Boolean) && (this.jdField_b_of_type_AndroidWidgetImageView != null)) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (this.s)
      {
        setRightViewTextDisable(0);
        this.jdField_a_of_type_AndroidWidgetEditText.setHint(getString(2131718412));
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new ReadInJoyDeliverVideoActivity.3(this), 30000L);
      }
      s();
      return;
      localObject = String.valueOf(this.jdField_a_of_type_JavaLangString);
      break;
    }
  }
  
  public void b(String paramString)
  {
    int i2 = 1;
    if ((!TextUtils.isEmpty(paramString)) && (new File(paramString).exists()))
    {
      this.jdField_h_of_type_JavaLangString = paramString;
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(this.jdField_h_of_type_JavaLangString, (BitmapFactory.Options)localObject);
      int i1 = actj.a(110.0F, getResources());
      int i3 = actj.a(110.0F, getResources());
      float f1 = ((BitmapFactory.Options)localObject).outWidth / i1;
      float f2 = ((BitmapFactory.Options)localObject).outHeight / i3;
      this.jdField_m_of_type_Int = ((BitmapFactory.Options)localObject).outWidth;
      this.jdField_n_of_type_Int = ((BitmapFactory.Options)localObject).outHeight;
      getIntent().putExtra("arg_video_cover_width", this.jdField_m_of_type_Int);
      getIntent().putExtra("arg_video_cover_height", this.jdField_n_of_type_Int);
      i1 = i2;
      if (f1 >= 1.0F)
      {
        i1 = i2;
        if (f2 >= 1.0F) {
          i1 = (int)Math.floor(Math.min(f1, f2));
        }
      }
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      ((BitmapFactory.Options)localObject).inSampleSize = i1;
      try
      {
        localObject = BitmapFactory.decodeFile(this.jdField_h_of_type_JavaLangString, (BitmapFactory.Options)localObject);
        localObject = a(a(this.jdField_h_of_type_JavaLangString), (Bitmap)localObject);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageBitmap((Bitmap)localObject);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyDeliverVideoActivity", 2, "setSelectedImage sampleSize=" + i1 + ", path=" + paramString);
        }
        return;
      }
      catch (OutOfMemoryError paramString)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageDrawable(new ColorDrawable(-16777216));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageDrawable(new ColorDrawable(-16777216));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0) {
      q();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    super.c(paramBoolean);
    if (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0) {
      q();
    }
  }
  
  public void d()
  {
    super.d();
    nol.a(this.app, "", "0X80081D8", "0X80081D8", 0, 0, "2", "2", "", npu.a(null), false);
    nol.a(null, "", "0X8008242", "0X8008242", 0, 0, String.valueOf(a()), "", "", onh.e(), false);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    super.doOnCreate(paramBundle);
    super.setContentView(2131559903);
    a(2131718443);
    a();
    b();
    n();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    osj.a().b(this.jdField_a_of_type_Osm);
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
  }
  
  public void doOnPostResume()
  {
    super.doOnPostResume();
    this.jdField_e_of_type_Long = System.currentTimeMillis();
    axrn.a(this).a(getAppRuntime().getAccount(), "actReadInJoyEnterVideoDeliverPage", true, this.jdField_e_of_type_Long - this.jdField_d_of_type_Long, 0L, null, "");
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
  
  public void e()
  {
    super.e();
    nol.a(null, "", "0X8008243", "0X8008243", 0, 0, String.valueOf(a()), "", "", onh.e(), false);
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_a_of_type_Oek != null) {
      this.jdField_a_of_type_Oek.a(null);
    }
  }
  
  public void g()
  {
    this.jdField_i_of_type_Int = 2;
    super.g();
    nol.a(null, "", "0X8009577", "0X8009577", 0, 0, "", "", "", onh.e(), false);
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverVideoActivity", 2, "onEmotionBtn!");
    }
    nol.a(null, "", "0X8008244", "0X8008244", 0, 0, "", "", "", onh.e(), false);
    super.h();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(100);
      p();
      a(1, getString(2131718598));
    }
    do
    {
      return true;
      if (paramMessage.what == 101)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(101);
        p();
        a(1, getString(2131719581));
        return true;
      }
      if (paramMessage.what == 102)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(102);
        p();
        a(1, getString(2131718600));
        return true;
      }
      if (paramMessage.what == 103)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(103);
        p();
        return true;
      }
      if (paramMessage.what == 104)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(104);
        p();
        r();
        a(1, getString(2131718605));
        return true;
      }
      if (paramMessage.what == 105)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(105);
        p();
        a(1, getString(2131718599));
        return true;
      }
      if (paramMessage.what == 106)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(106);
        p();
        a(1, getString(2131718606));
        return true;
      }
      if (paramMessage.what == 107)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(107);
        p();
        if (this.v)
        {
          a(0, getString(2131718611));
          return true;
        }
        a(0, getString(2131718610));
        return true;
      }
    } while (paramMessage.what != 108);
    a(((Float)paramMessage.obj).floatValue());
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1000) && (paramInt2 == -1)) {
      a(paramIntent.getParcelableArrayListExtra("EXTRA_SELECTED_TAG_LIST"));
    }
  }
  
  public boolean onBackEvent()
  {
    if (!this.r)
    {
      if ((this.s) && (!this.w)) {
        return super.onBackEvent();
      }
      a(false, 0, this.s, this.jdField_c_of_type_Long);
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
    case 2131378570: 
      do
      {
        return;
      } while (this.s);
      c(this.jdField_e_of_type_JavaLangString);
      return;
    case 2131363862: 
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(103);
      nol.a(this.app, "", "0X80081DA", "0X80081DA", 0, 0, "", "", "", npu.a(null), false);
      return;
    }
    v();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity
 * JD-Core Version:    0.7.0.1
 */