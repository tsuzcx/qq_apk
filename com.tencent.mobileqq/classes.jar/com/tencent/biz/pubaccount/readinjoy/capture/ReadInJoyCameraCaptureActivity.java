package com.tencent.biz.pubaccount.readinjoy.capture;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity;
import com.tencent.biz.qqstory.takevideo.CameraFocusView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraZoomGesture;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.richmedia.capture.util.SVParamManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.CaptureParam;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView.EffectListener;
import com.tencent.mobileqq.richmedia.capture.view.SplitEffectsCameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.SplitEffectsCameraCaptureView.EventListener;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.QQVideoMaterial;
import com.tencent.mobileqq.shortvideo.util.VidUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.File;
import lgs;
import lgt;
import lgv;
import lgx;
import lgy;
import lgz;
import lha;
import lhb;
import lhc;
import lhd;
import lhe;
import lhh;
import lhi;
import lhj;
import lhk;
import lhl;
import lhm;
import lhr;
import lhx;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class ReadInJoyCameraCaptureActivity
  extends PeakActivity
  implements View.OnClickListener, View.OnTouchListener, EffectsCameraCaptureView.EffectListener, SplitEffectsCameraCaptureView.EventListener, lhr, lhx
{
  private static int jdField_a_of_type_Int = 100;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ReadInJoyCameraProgressView jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraProgressView;
  private ReadInJoyCameraStatusLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraStatusLayout;
  private ReadInJoyCameraTemplateManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraTemplateManager;
  private ReadInJoyVideoDownloadManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyVideoDownloadManager;
  protected CameraFocusView a;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new lhb(this);
  private CameraZoomGesture jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraZoomGesture;
  private SplitEffectsCameraCaptureView jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private CircleProgress jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private Button jdField_c_of_type_AndroidWidgetButton;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private ViewGroup jdField_d_of_type_AndroidViewViewGroup;
  private String jdField_d_of_type_JavaLangString;
  private long jdField_e_of_type_Long;
  private ViewGroup jdField_e_of_type_AndroidViewViewGroup;
  private String jdField_e_of_type_JavaLangString;
  private long jdField_f_of_type_Long;
  private ViewGroup jdField_f_of_type_AndroidViewViewGroup;
  private String jdField_f_of_type_JavaLangString;
  
  private String a()
  {
    if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
      return this.jdField_f_of_type_JavaLangString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(VidUtil.a());
    localStringBuilder.append(".mp4");
    this.jdField_f_of_type_JavaLangString = localStringBuilder.toString();
    return this.jdField_f_of_type_JavaLangString;
  }
  
  /* Error */
  public static String a(android.graphics.Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 6
    //   5: aconst_null
    //   6: astore 7
    //   8: aconst_null
    //   9: astore 4
    //   11: new 124	java/io/File
    //   14: dup
    //   15: new 115	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   22: getstatic 146	com/tencent/mobileqq/app/AppConstants:aJ	Ljava/lang/String;
    //   25: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 148
    //   30: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokespecial 151	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: astore 5
    //   41: aload 5
    //   43: invokevirtual 155	java/io/File:exists	()Z
    //   46: ifne +9 -> 55
    //   49: aload 5
    //   51: invokevirtual 158	java/io/File:mkdirs	()Z
    //   54: pop
    //   55: invokestatic 164	java/lang/System:currentTimeMillis	()J
    //   58: lstore_1
    //   59: aload_0
    //   60: ifnull +92 -> 152
    //   63: new 124	java/io/File
    //   66: dup
    //   67: aload 5
    //   69: new 115	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   76: lload_1
    //   77: invokestatic 170	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   80: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc 172
    //   85: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokespecial 175	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   94: astore 5
    //   96: aload 5
    //   98: invokevirtual 178	java/io/File:createNewFile	()Z
    //   101: ifeq +205 -> 306
    //   104: aload 5
    //   106: invokevirtual 181	java/io/File:getPath	()Ljava/lang/String;
    //   109: astore_3
    //   110: new 183	java/io/FileOutputStream
    //   113: dup
    //   114: aload 5
    //   116: invokevirtual 181	java/io/File:getPath	()Ljava/lang/String;
    //   119: invokespecial 184	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   122: astore 4
    //   124: aload_0
    //   125: getstatic 190	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   128: bipush 100
    //   130: aload 4
    //   132: invokevirtual 196	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   135: pop
    //   136: aload_3
    //   137: astore_0
    //   138: aload_0
    //   139: astore_3
    //   140: aload 4
    //   142: ifnull +10 -> 152
    //   145: aload 4
    //   147: invokevirtual 199	java/io/FileOutputStream:close	()V
    //   150: aload_0
    //   151: astore_3
    //   152: aload_3
    //   153: areturn
    //   154: astore 5
    //   156: aconst_null
    //   157: astore 4
    //   159: aload 6
    //   161: astore_0
    //   162: aload 4
    //   164: astore_3
    //   165: aload 5
    //   167: invokevirtual 202	java/lang/OutOfMemoryError:printStackTrace	()V
    //   170: aload_0
    //   171: astore_3
    //   172: aload 4
    //   174: ifnull -22 -> 152
    //   177: aload 4
    //   179: invokevirtual 199	java/io/FileOutputStream:close	()V
    //   182: aload_0
    //   183: areturn
    //   184: astore_3
    //   185: aload_0
    //   186: areturn
    //   187: astore 5
    //   189: aconst_null
    //   190: astore 4
    //   192: aload 7
    //   194: astore_0
    //   195: aload 4
    //   197: astore_3
    //   198: ldc 204
    //   200: iconst_1
    //   201: new 115	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   208: ldc 206
    //   210: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload 5
    //   215: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 215	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   224: aload_0
    //   225: astore_3
    //   226: aload 4
    //   228: ifnull -76 -> 152
    //   231: aload 4
    //   233: invokevirtual 199	java/io/FileOutputStream:close	()V
    //   236: aload_0
    //   237: areturn
    //   238: astore_3
    //   239: aload_0
    //   240: areturn
    //   241: astore_0
    //   242: aconst_null
    //   243: astore_3
    //   244: aload_3
    //   245: ifnull +7 -> 252
    //   248: aload_3
    //   249: invokevirtual 199	java/io/FileOutputStream:close	()V
    //   252: aload_0
    //   253: athrow
    //   254: astore_3
    //   255: aload_0
    //   256: areturn
    //   257: astore_3
    //   258: goto -6 -> 252
    //   261: astore_0
    //   262: aload 4
    //   264: astore_3
    //   265: goto -21 -> 244
    //   268: astore_0
    //   269: goto -25 -> 244
    //   272: astore 5
    //   274: aload_3
    //   275: astore_0
    //   276: aconst_null
    //   277: astore 4
    //   279: goto -84 -> 195
    //   282: astore 5
    //   284: aload_3
    //   285: astore_0
    //   286: goto -91 -> 195
    //   289: astore 5
    //   291: aload_3
    //   292: astore_0
    //   293: aconst_null
    //   294: astore 4
    //   296: goto -134 -> 162
    //   299: astore 5
    //   301: aload_3
    //   302: astore_0
    //   303: goto -141 -> 162
    //   306: aconst_null
    //   307: astore_3
    //   308: aload 4
    //   310: astore_0
    //   311: aload_3
    //   312: astore 4
    //   314: goto -176 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	317	0	paramBitmap	android.graphics.Bitmap
    //   58	19	1	l	long
    //   1	171	3	localObject1	Object
    //   184	1	3	localException1	Exception
    //   197	29	3	localObject2	Object
    //   238	1	3	localException2	Exception
    //   243	6	3	localObject3	Object
    //   254	1	3	localException3	Exception
    //   257	1	3	localException4	Exception
    //   264	48	3	localObject4	Object
    //   9	304	4	localObject5	Object
    //   39	76	5	localFile	File
    //   154	12	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   187	27	5	localException5	Exception
    //   272	1	5	localException6	Exception
    //   282	1	5	localException7	Exception
    //   289	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   299	1	5	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   3	157	6	localObject6	Object
    //   6	187	7	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   96	110	154	java/lang/OutOfMemoryError
    //   177	182	184	java/lang/Exception
    //   96	110	187	java/lang/Exception
    //   231	236	238	java/lang/Exception
    //   96	110	241	finally
    //   110	124	241	finally
    //   145	150	254	java/lang/Exception
    //   248	252	257	java/lang/Exception
    //   124	136	261	finally
    //   165	170	268	finally
    //   198	224	268	finally
    //   110	124	272	java/lang/Exception
    //   124	136	282	java/lang/Exception
    //   110	124	289	java/lang/OutOfMemoryError
    //   124	136	299	java/lang/OutOfMemoryError
  }
  
  private void a(Context paramContext)
  {
    if (!CaptureUtil.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView.setVisibility(4);
      this.jdField_e_of_type_AndroidViewViewGroup.setVisibility(4);
      DialogUtil.a(paramContext, 230, null, "暂不支持该机型", null, paramContext.getString(2131433016), new lhd(this), null).show();
    }
  }
  
  private void a(String paramString)
  {
    String str = a(ShortVideoUtils.a(this, paramString));
    Intent localIntent = new Intent(this, ReadInJoyDeliverVideoActivity.class);
    localIntent.putExtras(getIntent().getExtras());
    localIntent.putExtra("arg_video_source", 2);
    localIntent.putExtra("arg_video_duration", this.jdField_b_of_type_Long);
    localIntent.putExtra("arg_video_path", paramString);
    localIntent.putExtra("arg_video_cover", str);
    localIntent.putExtra("arg_video_width", this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView.f());
    localIntent.putExtra("arg_video_height", this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView.g());
    startActivityForResult(localIntent, jdField_a_of_type_Int);
  }
  
  private boolean b()
  {
    return this.jdField_d_of_type_Int == 1;
  }
  
  private void e()
  {
    this.jdField_d_of_type_JavaLangString = getIntent().getStringExtra("OPEN_ACTIVITY_KEY_VID");
    this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("OPEN_ACTIVITY_KEY_VIDEO_MD5");
    this.jdField_d_of_type_Int = getIntent().getIntExtra("OPEN_ACTIVITY_KEY_MODE", 1);
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("OPEN_ACTIVITY_KEY_COVER_PATH");
    this.jdField_a_of_type_JavaLangString = (AppConstants.cj + System.currentTimeMillis());
    if (b()) {}
    for (int i = 6;; i = 2)
    {
      this.jdField_b_of_type_Int = i;
      if (QLog.isColorLevel())
      {
        QLog.i("Q.pubaccount.video.cameracapture.ReadInJoyCameraCaptureActivity", 2, "initData() bundle=" + getIntent().getExtras().toString());
        QLog.i("Q.pubaccount.video.cameracapture.ReadInJoyCameraCaptureActivity", 2, "initData() mVideoCaptureDir=" + this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
  }
  
  private void f()
  {
    int i = -1;
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131492971));
    View localView = findViewById(2131366244);
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)localView.findViewById(2131366944));
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewViewGroup.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = -1;
    if (b()) {
      i = (int)(com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper.a(this)[0] * 0.88F);
    }
    ((RelativeLayout.LayoutParams)localObject).height = i;
    if (b()) {
      ((RelativeLayout.LayoutParams)localObject).topMargin = AIOUtils.a(64.0F, getResources());
    }
    this.jdField_c_of_type_AndroidViewViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView = ((SplitEffectsCameraCaptureView)localView.findViewById(2131366945));
    localObject = new CameraCaptureView.CaptureParam();
    if (b())
    {
      ((CameraCaptureView.CaptureParam)localObject).a(640);
      ((CameraCaptureView.CaptureParam)localObject).b(480);
      ((CameraCaptureView.CaptureParam)localObject).a(1.0F);
      ((CameraCaptureView.CaptureParam)localObject).d(819200);
      ((CameraCaptureView.CaptureParam)localObject).e(1);
      ((CameraCaptureView.CaptureParam)localObject).c(2);
      ((CameraCaptureView.CaptureParam)localObject).a(this.jdField_a_of_type_JavaLangString);
      if (b()) {
        break label799;
      }
    }
    label799:
    for (boolean bool = true;; bool = false)
    {
      ((CameraCaptureView.CaptureParam)localObject).a(bool);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView.setSplitEnable(b());
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView.setBeautyEnable(false);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView.setFaceEffectEnable(true);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView.setEffectMute(b());
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView.setFilterEnable(false);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView.setCaptureParam((CameraCaptureView.CaptureParam)localObject);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView.setOnTouchListener(this);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView.setEventListener(this);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView.setFaceEffectListener(this);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraZoomGesture = new CameraZoomGesture(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView = ((CameraFocusView)localView.findViewById(2131366946));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131366948));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131366949));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131366951));
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = ((CircleProgress)localView.findViewById(2131366950));
      this.jdField_e_of_type_AndroidViewViewGroup = ((ViewGroup)localView.findViewById(2131366947));
      this.jdField_b_of_type_AndroidViewView = localView.findViewById(2131366952);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraProgressView = ((ReadInJoyCameraProgressView)localView.findViewById(2131365656));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131366964));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131366959));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)localView.findViewById(2131366961));
      this.jdField_d_of_type_AndroidViewViewGroup.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131366960);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraStatusLayout = ((ReadInJoyCameraStatusLayout)localView.findViewById(2131366957));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraStatusLayout.setStatus(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraStatusLayout.setOnBottonClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131366962));
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localView.findViewById(2131366953));
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)localView.findViewById(2131366956));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131366955));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131363993));
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131366954));
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_f_of_type_AndroidViewViewGroup = ((ViewGroup)localView.findViewById(2131366965));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131366966));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraTemplateManager = new ReadInJoyCameraTemplateManager(this, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView, this.jdField_d_of_type_Int);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraTemplateManager.a(this);
      return;
      Size localSize = SVParamManager.a().a(2);
      if (localSize != null)
      {
        ((CameraCaptureView.CaptureParam)localObject).a(localSize.a());
        ((CameraCaptureView.CaptureParam)localObject).b(localSize.b());
      }
      for (;;)
      {
        ((CameraCaptureView.CaptureParam)localObject).a(SVParamManager.a().a(2));
        ((CameraCaptureView.CaptureParam)localObject).d(SVParamManager.a().a(2) * 1024);
        ((CameraCaptureView.CaptureParam)localObject).e(1);
        break;
        ((CameraCaptureView.CaptureParam)localObject).a(960);
        ((CameraCaptureView.CaptureParam)localObject).b(720);
      }
    }
  }
  
  private void g()
  {
    if (!b()) {
      return;
    }
    this.jdField_e_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(3.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(40, 16777215, 100, 16777215);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setScaleType(ImageView.ScaleType.FIT_XY);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_a_of_type_ComTencentImageURLImageView.getWidth();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_a_of_type_ComTencentImageURLImageView.getHeight();
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localObject = URLDrawable.getDrawable(this.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyVideoDownloadManager = new ReadInJoyVideoDownloadManager(this.jdField_d_of_type_JavaLangString, new lhe(this));
    h();
  }
  
  private void h()
  {
    if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyVideoDownloadManager.a()) {
      if (!NetworkUtil.g(this))
      {
        QQToast.a(BaseApplication.getContext(), 1, 2131433009, 0).a(e()).show();
        this.jdField_b_of_type_Int = 7;
      }
    }
    for (;;)
    {
      i();
      return;
      if (NetworkUtil.h(this))
      {
        this.jdField_b_of_type_Int = 6;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyVideoDownloadManager.a();
      }
      else
      {
        DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131428449), this.jdField_a_of_type_AndroidContentContext.getString(2131428453), this.jdField_a_of_type_AndroidContentContext.getString(2131428450), this.jdField_a_of_type_AndroidContentContext.getString(2131428452), new lhh(this), new lhi(this)).show();
        this.jdField_b_of_type_Int = 7;
        continue;
        this.jdField_b_of_type_Int = 6;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyVideoDownloadManager.a();
      }
    }
  }
  
  @TargetApi(11)
  private void i()
  {
    switch (this.jdField_b_of_type_Int)
    {
    default: 
    case 6: 
    case 7: 
    case 2: 
    case 1: 
    case 4: 
    case 3: 
    case 9: 
      do
      {
        for (;;)
        {
          return;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraStatusLayout.setStatus(this.jdField_b_of_type_Int);
          this.jdField_a_of_type_AndroidWidgetTextView.setText("素材下载中，稍等一下~");
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetTextView.setText("");
          this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
          this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
          return;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraStatusLayout.setStatus(this.jdField_b_of_type_Int);
          this.jdField_a_of_type_AndroidWidgetTextView.setText("素材未下载");
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetTextView.setText("下载素材");
          this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
          this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
          return;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraStatusLayout.setStatus(this.jdField_b_of_type_Int);
          this.jdField_a_of_type_AndroidWidgetTextView.setText("点击开始录制");
          this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
          this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          return;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraStatusLayout.setStatus(this.jdField_b_of_type_Int);
          this.jdField_a_of_type_AndroidWidgetTextView.setText("点击暂停录制");
          this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
          this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
          if (b())
          {
            this.jdField_e_of_type_AndroidViewViewGroup.setVisibility(8);
            this.jdField_b_of_type_AndroidViewView.setVisibility(8);
            return;
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraStatusLayout.setStatus(this.jdField_b_of_type_Int);
            this.jdField_a_of_type_AndroidWidgetTextView.setText("点击继续录制");
            this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(0);
            this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
            if (this.jdField_b_of_type_Boolean) {
              this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
            }
            this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            if (this.jdField_a_of_type_Long < 3000L) {
              this.jdField_d_of_type_AndroidViewViewGroup.setAlpha(0.3F);
            }
            while (b())
            {
              this.jdField_b_of_type_AndroidViewView.setVisibility(0);
              return;
              this.jdField_d_of_type_AndroidViewViewGroup.setAlpha(1.0F);
            }
          }
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraStatusLayout.setStatus(this.jdField_b_of_type_Int);
        this.jdField_f_of_type_AndroidViewViewGroup.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetImageView.clearAnimation();
        this.jdField_a_of_type_AndroidWidgetTextView.setText("已录制达最长时长");
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(0);
        this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
        this.jdField_d_of_type_AndroidViewViewGroup.setAlpha(1.0F);
      } while (!b());
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      return;
    case 5: 
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
    if (b()) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_f_of_type_AndroidViewViewGroup.setVisibility(0);
    RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(1000L);
    localRotateAnimation.setRepeatCount(-1);
    localRotateAnimation.setRepeatMode(1);
    localRotateAnimation.setStartTime(-1L);
    localRotateAnimation.setInterpolator(new LinearInterpolator());
    this.jdField_c_of_type_AndroidWidgetImageView.startAnimation(localRotateAnimation);
  }
  
  private void j()
  {
    ThreadManager.postImmediately(new lgv(this), null, false);
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      return;
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230, "生成失败", "很遗憾，发生了一个错误，导致无法顺利生成视频。", "退出拍摄", "留在此页", new lgx(this), new lgy(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void l()
  {
    QQToast.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), "无网络连接,请检测网络配置!", 0).a();
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView.e() > 0)
    {
      ActionSheet localActionSheet = ActionSheet.d(this.jdField_a_of_type_AndroidContentContext);
      localActionSheet.a("退出将丢失所有已编辑的内容");
      localActionSheet.a("退出", 3);
      localActionSheet.c(2131433015);
      localActionSheet.a(new lhc(this, localActionSheet));
      localActionSheet.show();
      return;
    }
    d();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.cameracapture.ReadInJoyCameraCaptureActivity", 2, "onCaptureButtonClick() mStatus=" + this.jdField_b_of_type_Int);
    }
    if ((this.jdField_b_of_type_Int == 6) || (this.jdField_b_of_type_Int == 7) || (this.jdField_b_of_type_Int == 3) || (this.jdField_b_of_type_Int == 8)) {}
    do
    {
      return;
      if (this.jdField_b_of_type_Int != 1) {
        break;
      }
    } while (System.currentTimeMillis() - this.jdField_c_of_type_Long < 1000L);
    PublicAccountReportUtils.a(null, "", "0X80081CD", "0X80081CD", 0, 0, "2", "", "", VideoReporter.a(this.jdField_d_of_type_Int), false);
    this.jdField_b_of_type_Int = 4;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView.l();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraProgressView.a(this.jdField_a_of_type_Long, this.jdField_b_of_type_Long);
    for (;;)
    {
      i();
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new lhl(this), 100L);
      return;
      PublicAccountReportUtils.a(null, "", "0X80081CD", "0X80081CD", 0, 0, "1", "", "", VideoReporter.a(this.jdField_d_of_type_Int), false);
      this.jdField_b_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView.k();
      this.jdField_c_of_type_Long = System.currentTimeMillis();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView.a() != null))
    {
      int i = ReadInJoyHelper.a(paramInt1, paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView.a().d(i);
      if (QLog.isColorLevel()) {
        QLog.i("Q.pubaccount.video.cameracapture.ReadInJoyCameraCaptureActivity", 2, "onCameraSizeSelected(): targetWidth=" + paramInt1 + ", targetHeight=" + paramInt2 + ", configBitRate=" + i);
      }
    }
  }
  
  public void a(long paramLong) {}
  
  public void a(QQVideoMaterial paramQQVideoMaterial) {}
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      ThreadManager.getUIHandler().post(new lgt(this));
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.cameracapture.ReadInJoyCameraCaptureActivity", 2, "onDetectStateChange(): needFace=" + paramBoolean1 + "，faceDetected=" + paramBoolean2);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.cameracapture.ReadInJoyCameraCaptureActivity", 2, "onCompletion()");
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new lhm(this));
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new lgz(this), 500L);
  }
  
  public void c(boolean paramBoolean) {}
  
  public void d()
  {
    setResult(0, getIntent());
    finish();
    PublicAccountReportUtils.a(null, "", "0X80081D0", "0X80081D0", 0, 0, "", "", "", VideoReporter.a(this.jdField_d_of_type_Int), false);
  }
  
  public void d(boolean paramBoolean) {}
  
  public void d_(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.cameracapture.ReadInJoyCameraCaptureActivity", 2, "onSoload(): success=" + paramBoolean);
    }
    if (!paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView.setBeautyEnable(false);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView.setFaceEffectEnable(false);
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.post(new lha(this));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == jdField_a_of_type_Int)
    {
      super.setResult(paramInt2, paramIntent);
      super.finish();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131366955: 
    case 2131363993: 
    case 2131366959: 
    case 2131366961: 
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i("Q.pubaccount.video.cameracapture.ReadInJoyCameraCaptureActivity", 2, "onClick() R.id.change_camera");
        }
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView.i();
        return;
        if (QLog.isColorLevel()) {
          QLog.i("Q.pubaccount.video.cameracapture.ReadInJoyCameraCaptureActivity", 2, "onClick() R.id.cancel");
        }
        m();
        return;
        if (QLog.isColorLevel()) {
          QLog.i("Q.pubaccount.video.cameracapture.ReadInJoyCameraCaptureActivity", 2, "onClick() R.id.delete_segment_button");
        }
        PublicAccountReportUtils.a(null, "", "0X80081CE", "0X80081CE", 0, 0, "", "", "", VideoReporter.a(this.jdField_d_of_type_Int), false);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView.A();
        this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView.h();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraProgressView.a();
        this.jdField_b_of_type_Int = 4;
        i();
        return;
        if (QLog.isColorLevel()) {
          QLog.i("Q.pubaccount.video.cameracapture.ReadInJoyCameraCaptureActivity", 2, "onClick() R.id.jump_to_next_button");
        }
      } while (this.jdField_a_of_type_Long < 3000L);
      paramView = ActionSheet.d(this.jdField_a_of_type_AndroidContentContext);
      paramView.a("生成视频后，将无法修改内容");
      paramView.c("生成视频");
      paramView.c(2131433015);
      paramView.a(new lhk(this, paramView));
      paramView.show();
      return;
    case 2131366960: 
      if (QLog.isColorLevel()) {
        QLog.i("Q.pubaccount.video.cameracapture.ReadInJoyCameraCaptureActivity", 2, "onClick() R.id.jump_to_back_button");
      }
      this.jdField_b_of_type_Int = 4;
      i();
      return;
    case 2131366954: 
      if (QLog.isColorLevel()) {
        QLog.i("Q.pubaccount.video.cameracapture.ReadInJoyCameraCaptureActivity", 2, "onClick() R.id.template_btn");
      }
      PublicAccountReportUtils.a(null, "", "0X80081D1", "0X80081D1", 0, 0, "", "", "", VideoReporter.a(this.jdField_d_of_type_Int), false);
      this.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
      this.jdField_b_of_type_Int = 5;
      i();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraTemplateManager.a();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.cameracapture.ReadInJoyCameraCaptureActivity", 2, "onClick() R.id.source_video_download_imageview");
    }
    h();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    this.jdField_e_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.cameracapture.ReadInJoyCameraCaptureActivity", 2, "onCreate()");
    }
    this.V = false;
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)getSystemService("audio"));
    super.getWindow().addFlags(128);
    super.getWindow().addFlags(256);
    super.getWindow().addFlags(512);
    super.getWindow().addFlags(67108864);
    getWindow().setFlags(1024, 1024);
    AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    requestWindowFeature(1);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_AndroidContentContext = this;
    super.onCreate(paramBundle);
    super.setContentView(2130969558);
    ThreadManager.post(new lgs(this), 8, null, true);
    e();
    f();
    g();
    i();
    a(this);
  }
  
  protected void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.cameracapture.ReadInJoyCameraCaptureActivity", 2, "onDestroy()");
    }
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView.B();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraTemplateManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraTemplateManager.c();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraTemplateManager = null;
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
      this.jdField_a_of_type_AndroidMediaAudioManager = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler != null) {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    }
    ThreadManager.post(new lhj(this), 5, null, false);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    m();
    return true;
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.cameracapture.ReadInJoyCameraCaptureActivity", 2, "onPause()");
    }
    super.onPause();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView.onPause();
    if (this.jdField_b_of_type_Int == 1) {
      a();
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
      this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(null);
    }
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.cameracapture.ReadInJoyCameraCaptureActivity", 2, "onResume()");
    }
    super.onResume();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView.onResume();
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
      this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(null, 3, 1);
    }
    this.jdField_f_of_type_Long = System.currentTimeMillis();
    StatisticCollector.a(this).a(getAppRuntime().getAccount(), "actReadInJoyEnterVideoCapturePage", true, this.jdField_f_of_type_Long - this.jdField_e_of_type_Long, 0L, null, "");
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return false;
    } while (b());
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraZoomGesture.a(paramMotionEvent, false)) {
      return true;
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
      return false;
    case 0: 
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      return true;
    }
    if ((System.currentTimeMillis() - this.jdField_d_of_type_Long < 600L) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView.a() != 1))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView.a(paramMotionEvent);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView.a(paramMotionEvent.getX(), paramMotionEvent.getY());
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraCaptureActivity
 * JD-Core Version:    0.7.0.1
 */