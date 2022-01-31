package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.hardware.Camera;
import android.hardware.Camera.Size;
import android.media.MediaRecorder;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import sys;
import syt;
import syu;

public class MakeVideoActivity
  extends Activity
  implements View.OnClickListener
{
  final int jdField_a_of_type_Int = 1;
  public Camera a;
  private MediaRecorder jdField_a_of_type_AndroidMediaMediaRecorder;
  private Handler jdField_a_of_type_AndroidOsHandler = new sys(this);
  private SurfaceView jdField_a_of_type_AndroidViewSurfaceView;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  MakeVideoActivity.ScreenBroadcastReceiver jdField_a_of_type_ComTencentMobileqqActivityMakeVideoActivity$ScreenBroadcastReceiver;
  public File a;
  public String a;
  public ArrayList a;
  public boolean a;
  public String[] a;
  final int jdField_b_of_type_Int = 2;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString = null;
  public ArrayList b;
  final int jdField_c_of_type_Int = 3;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString = null;
  public int d;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  String jdField_d_of_type_JavaLangString = null;
  public int e;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  String jdField_e_of_type_JavaLangString = null;
  public int f;
  private TextView f;
  public int g;
  private TextView g;
  private TextView h;
  private TextView i;
  
  public MakeVideoActivity()
  {
    this.jdField_a_of_type_JavaLangString = "MakeVideoActivity";
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_ArrayOfJavaLangString = null;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaIoFile = null;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 0;
  }
  
  public static int a(float paramFloat1, float paramFloat2)
  {
    return (int)(paramFloat2 * paramFloat1 + 0.5F);
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static Drawable a(Context paramContext, float paramFloat1, int paramInt1, float paramFloat2, int paramInt2)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(paramInt1);
    localGradientDrawable.setCornerRadius(a(paramContext, paramFloat1));
    localGradientDrawable.setStroke(a(paramContext, paramFloat2), paramInt2);
    return localGradientDrawable;
  }
  
  private Camera.Size a(List paramList, int paramInt1, int paramInt2)
  {
    double d2 = paramInt1 / paramInt2;
    Object localObject2;
    if (paramList == null)
    {
      localObject2 = null;
      return localObject2;
    }
    Object localObject1 = null;
    double d1 = 1.7976931348623157E+308D;
    Iterator localIterator = paramList.iterator();
    label33:
    while (localIterator.hasNext())
    {
      localObject2 = (Camera.Size)localIterator.next();
      if (Math.abs(((Camera.Size)localObject2).height / ((Camera.Size)localObject2).width - d2) <= 0.05D)
      {
        if (Math.abs(((Camera.Size)localObject2).height - paramInt2) >= d1) {
          break label205;
        }
        d1 = Math.abs(((Camera.Size)localObject2).height - paramInt2);
        localObject1 = localObject2;
      }
    }
    label205:
    for (;;)
    {
      break label33;
      localObject2 = localObject1;
      if (localObject1 != null) {
        break;
      }
      d1 = 1.7976931348623157E+308D;
      localIterator = paramList.iterator();
      localObject2 = localObject1;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList = (Camera.Size)localIterator.next();
      if (Math.abs(paramList.height - paramInt2) < d1) {
        d1 = Math.abs(paramList.height - paramInt2);
      }
      for (;;)
      {
        localObject1 = paramList;
        break;
        paramList = (List)localObject1;
      }
    }
  }
  
  private boolean a(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    return (localPackageManager.hasSystemFeature("android.hardware.camera")) && (localPackageManager.checkPermission("android.permission.CAMERA", paramContext.getPackageName()) == 0);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewSurfaceView = ((SurfaceView)findViewById(2131364919));
    this.jdField_a_of_type_AndroidViewSurfaceView.getHolder().setType(3);
    this.jdField_a_of_type_AndroidViewSurfaceView.getHolder().setKeepScreenOn(true);
    this.jdField_a_of_type_AndroidViewSurfaceView.setZOrderOnTop(false);
    this.jdField_a_of_type_AndroidViewSurfaceView.getHolder().setFormat(-3);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131364920));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364925);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364926);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364924);
    Object localObject = getResources().getDisplayMetrics();
    int j = (((DisplayMetrics)localObject).widthPixels - a(((DisplayMetrics)localObject).density, 262.0F)) / 2;
    int k = ((DisplayMetrics)localObject).heightPixels;
    int m = a(((DisplayMetrics)localObject).density, 352.0F);
    int n = a(((DisplayMetrics)localObject).density, 190.0F);
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = j;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = j;
    this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = (k - m - n);
    this.jdField_c_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131364927));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364921));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364922));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131364940));
    localObject = a(this, 2.0F, 0, 1.0F, -16734752);
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable((Drawable)localObject);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.i = ((TextView)findViewById(2131363969));
    this.i.setTextColor(getResources().getColorStateList(2130839330));
    this.i.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364928));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364929));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364930));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364931));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364932));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364933));
    this.h = ((TextView)findViewById(2131364934));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_e_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_f_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_g_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.h);
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_d_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
    }
    this.jdField_d_of_type_AndroidViewView = findViewById(2131361800);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131364935));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364936));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364937));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364938));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364939));
    this.jdField_b_of_type_JavaUtilArrayList.add(this.jdField_b_of_type_AndroidWidgetImageView);
    this.jdField_b_of_type_JavaUtilArrayList.add(this.jdField_c_of_type_AndroidWidgetImageView);
    this.jdField_b_of_type_JavaUtilArrayList.add(this.jdField_d_of_type_AndroidWidgetImageView);
    this.jdField_b_of_type_JavaUtilArrayList.add(this.jdField_e_of_type_AndroidWidgetImageView);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaRecorder != null) {}
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setOnErrorListener(null);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setOnInfoListener(null);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setPreviewDisplay(null);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.stop();
      this.jdField_a_of_type_AndroidMediaMediaRecorder.reset();
      this.jdField_a_of_type_AndroidMediaMediaRecorder.release();
      this.jdField_a_of_type_AndroidMediaMediaRecorder = null;
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        Log.i("Exception", Log.getStackTraceString(localIllegalStateException));
        this.jdField_a_of_type_AndroidMediaMediaRecorder = null;
        this.jdField_a_of_type_AndroidMediaMediaRecorder = new MediaRecorder();
        this.jdField_a_of_type_AndroidMediaMediaRecorder.stop();
      }
    }
  }
  
  protected void c()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errCode", -1);
      localJSONObject.put("msg", "取消视频录制");
      localJSONObject.put("content", "");
      Intent localIntent = new Intent();
      localIntent.putExtra("result", localJSONObject.toString());
      setResult(0, localIntent);
      finish();
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131364940: 
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_d_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#33000000"));
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaRecorder = new MediaRecorder();
        this.jdField_a_of_type_AndroidMediaMediaRecorder.reset();
        if (this.jdField_a_of_type_AndroidHardwareCamera != null)
        {
          this.jdField_a_of_type_AndroidHardwareCamera.unlock();
          this.jdField_a_of_type_AndroidMediaMediaRecorder.setCamera(this.jdField_a_of_type_AndroidHardwareCamera);
          this.jdField_a_of_type_AndroidMediaMediaRecorder.setOrientationHint(270);
          this.jdField_a_of_type_AndroidMediaMediaRecorder.setAudioSource(1);
          this.jdField_a_of_type_AndroidMediaMediaRecorder.setVideoSource(1);
          this.jdField_a_of_type_AndroidMediaMediaRecorder.setOutputFormat(2);
          if ((this.jdField_f_of_type_Int != 0) && (this.jdField_g_of_type_Int != 0)) {
            this.jdField_a_of_type_AndroidMediaMediaRecorder.setVideoSize(this.jdField_f_of_type_Int, this.jdField_g_of_type_Int);
          }
          this.jdField_a_of_type_AndroidMediaMediaRecorder.setVideoEncodingBitRate(524288);
          this.jdField_a_of_type_AndroidMediaMediaRecorder.setAudioEncoder(3);
          this.jdField_a_of_type_AndroidMediaMediaRecorder.setVideoEncoder(2);
          this.jdField_a_of_type_AndroidMediaMediaRecorder.setMaxFileSize(2097152L);
          this.jdField_a_of_type_AndroidMediaMediaRecorder.setOutputFile(this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
          this.jdField_a_of_type_AndroidMediaMediaRecorder.setOnInfoListener(new syt(this));
          this.jdField_a_of_type_AndroidMediaMediaRecorder.setOnErrorListener(new syu(this));
          this.jdField_a_of_type_AndroidMediaMediaRecorder.setPreviewDisplay(this.jdField_a_of_type_AndroidViewSurfaceView.getHolder().getSurface());
          this.jdField_a_of_type_AndroidMediaMediaRecorder.prepare();
          this.jdField_a_of_type_AndroidMediaMediaRecorder.start();
        }
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          paramView.printStackTrace();
          b();
        }
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, this.jdField_d_of_type_Int);
      return;
    }
    c();
  }
  
  /* Error */
  public void onCreate(android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: aload_1
    //   5: invokespecial 549	android/app/Activity:onCreate	(Landroid/os/Bundle;)V
    //   8: aload_0
    //   9: iconst_1
    //   10: invokevirtual 553	com/tencent/mobileqq/activity/MakeVideoActivity:requestWindowFeature	(I)Z
    //   13: pop
    //   14: aload_0
    //   15: invokevirtual 557	com/tencent/mobileqq/activity/MakeVideoActivity:getWindow	()Landroid/view/Window;
    //   18: sipush 1024
    //   21: sipush 1024
    //   24: invokevirtual 562	android/view/Window:setFlags	(II)V
    //   27: aload_0
    //   28: iconst_1
    //   29: invokevirtual 565	com/tencent/mobileqq/activity/MakeVideoActivity:setRequestedOrientation	(I)V
    //   32: aload_0
    //   33: ldc_w 566
    //   36: invokevirtual 569	com/tencent/mobileqq/activity/MakeVideoActivity:setContentView	(I)V
    //   39: invokestatic 574	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   42: ldc_w 576
    //   45: invokevirtual 581	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   48: ifne +4 -> 52
    //   51: return
    //   52: aload_0
    //   53: new 511	java/io/File
    //   56: dup
    //   57: invokestatic 585	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   60: new 587	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 588	java/lang/StringBuilder:<init>	()V
    //   67: invokestatic 594	java/lang/System:currentTimeMillis	()J
    //   70: invokevirtual 598	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   73: ldc_w 600
    //   76: invokevirtual 603	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 604	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokespecial 607	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   85: putfield 71	com/tencent/mobileqq/activity/MakeVideoActivity:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   88: aload_0
    //   89: new 609	com/tencent/mobileqq/activity/MakeVideoActivity$ScreenBroadcastReceiver
    //   92: dup
    //   93: aload_0
    //   94: invokespecial 610	com/tencent/mobileqq/activity/MakeVideoActivity$ScreenBroadcastReceiver:<init>	(Lcom/tencent/mobileqq/activity/MakeVideoActivity;)V
    //   97: putfield 612	com/tencent/mobileqq/activity/MakeVideoActivity:jdField_a_of_type_ComTencentMobileqqActivityMakeVideoActivity$ScreenBroadcastReceiver	Lcom/tencent/mobileqq/activity/MakeVideoActivity$ScreenBroadcastReceiver;
    //   100: new 614	android/content/IntentFilter
    //   103: dup
    //   104: invokespecial 615	android/content/IntentFilter:<init>	()V
    //   107: astore_1
    //   108: aload_1
    //   109: ldc_w 617
    //   112: invokevirtual 620	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   115: aload_1
    //   116: ldc_w 622
    //   119: invokevirtual 620	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   122: aload_0
    //   123: aload_0
    //   124: getfield 612	com/tencent/mobileqq/activity/MakeVideoActivity:jdField_a_of_type_ComTencentMobileqqActivityMakeVideoActivity$ScreenBroadcastReceiver	Lcom/tencent/mobileqq/activity/MakeVideoActivity$ScreenBroadcastReceiver;
    //   127: aload_1
    //   128: invokevirtual 626	com/tencent/mobileqq/activity/MakeVideoActivity:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   131: pop
    //   132: aload_0
    //   133: invokevirtual 630	com/tencent/mobileqq/activity/MakeVideoActivity:getIntent	()Landroid/content/Intent;
    //   136: ldc_w 632
    //   139: invokevirtual 636	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   142: astore_1
    //   143: new 404	org/json/JSONObject
    //   146: dup
    //   147: aload_1
    //   148: invokespecial 638	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   151: astore_1
    //   152: new 404	org/json/JSONObject
    //   155: dup
    //   156: aload_1
    //   157: ldc_w 640
    //   160: invokevirtual 643	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   163: invokespecial 638	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   166: astore 5
    //   168: aload_0
    //   169: aload 5
    //   171: ldc_w 645
    //   174: invokevirtual 643	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   177: putfield 48	com/tencent/mobileqq/activity/MakeVideoActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   180: aload_0
    //   181: aload 5
    //   183: ldc_w 647
    //   186: invokevirtual 643	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   189: putfield 50	com/tencent/mobileqq/activity/MakeVideoActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   192: aload_0
    //   193: aload 5
    //   195: ldc_w 649
    //   198: invokevirtual 643	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   201: putfield 52	com/tencent/mobileqq/activity/MakeVideoActivity:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   204: aload 5
    //   206: ldc_w 651
    //   209: invokevirtual 643	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   212: pop
    //   213: aload_0
    //   214: aload_1
    //   215: ldc_w 653
    //   218: invokevirtual 643	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   221: putfield 54	com/tencent/mobileqq/activity/MakeVideoActivity:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   224: aload_1
    //   225: ldc_w 655
    //   228: invokevirtual 658	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   231: istore_2
    //   232: aload_0
    //   233: aload_1
    //   234: ldc_w 660
    //   237: invokevirtual 658	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   240: putfield 56	com/tencent/mobileqq/activity/MakeVideoActivity:jdField_d_of_type_Int	I
    //   243: aload_0
    //   244: getfield 54	com/tencent/mobileqq/activity/MakeVideoActivity:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   247: invokestatic 340	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   250: ifeq +10 -> 260
    //   253: aload_0
    //   254: ldc_w 662
    //   257: putfield 54	com/tencent/mobileqq/activity/MakeVideoActivity:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   260: aload_0
    //   261: invokevirtual 664	com/tencent/mobileqq/activity/MakeVideoActivity:a	()V
    //   264: iload_2
    //   265: istore_3
    //   266: iload_2
    //   267: ifgt +7 -> 274
    //   270: sipush 2000
    //   273: istore_3
    //   274: aload_0
    //   275: iconst_4
    //   276: anewarray 578	java/lang/String
    //   279: putfield 67	com/tencent/mobileqq/activity/MakeVideoActivity:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   282: iload 4
    //   284: istore_2
    //   285: iload_2
    //   286: aload_0
    //   287: getfield 67	com/tencent/mobileqq/activity/MakeVideoActivity:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   290: arraylength
    //   291: if_icmpge +121 -> 412
    //   294: aload_0
    //   295: getfield 67	com/tencent/mobileqq/activity/MakeVideoActivity:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   298: iload_2
    //   299: aload_0
    //   300: getfield 54	com/tencent/mobileqq/activity/MakeVideoActivity:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   303: iload_2
    //   304: iload_2
    //   305: iconst_1
    //   306: iadd
    //   307: invokevirtual 668	java/lang/String:substring	(II)Ljava/lang/String;
    //   310: aastore
    //   311: iload_2
    //   312: iconst_1
    //   313: iadd
    //   314: istore_2
    //   315: goto -30 -> 285
    //   318: astore_1
    //   319: iconst_0
    //   320: istore_2
    //   321: aload_1
    //   322: invokevirtual 541	java/lang/Exception:printStackTrace	()V
    //   325: new 404	org/json/JSONObject
    //   328: dup
    //   329: invokespecial 405	org/json/JSONObject:<init>	()V
    //   332: astore_1
    //   333: aload_1
    //   334: ldc_w 407
    //   337: bipush 254
    //   339: invokevirtual 411	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   342: pop
    //   343: aload_1
    //   344: ldc_w 413
    //   347: ldc_w 670
    //   350: invokevirtual 418	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   353: pop
    //   354: aload_1
    //   355: ldc_w 420
    //   358: ldc_w 422
    //   361: invokevirtual 418	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   364: pop
    //   365: new 424	android/content/Intent
    //   368: dup
    //   369: invokespecial 425	android/content/Intent:<init>	()V
    //   372: astore 5
    //   374: aload 5
    //   376: ldc_w 427
    //   379: aload_1
    //   380: invokevirtual 430	org/json/JSONObject:toString	()Ljava/lang/String;
    //   383: invokevirtual 434	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   386: pop
    //   387: aload_0
    //   388: bipush 254
    //   390: aload 5
    //   392: invokevirtual 438	com/tencent/mobileqq/activity/MakeVideoActivity:setResult	(ILandroid/content/Intent;)V
    //   395: aload_0
    //   396: invokevirtual 441	com/tencent/mobileqq/activity/MakeVideoActivity:finish	()V
    //   399: goto -156 -> 243
    //   402: astore 5
    //   404: aload 5
    //   406: invokevirtual 444	org/json/JSONException:printStackTrace	()V
    //   409: goto -44 -> 365
    //   412: aload_0
    //   413: getfield 82	com/tencent/mobileqq/activity/MakeVideoActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   416: iconst_1
    //   417: iload_3
    //   418: i2l
    //   419: invokevirtual 540	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   422: pop
    //   423: aload_0
    //   424: getfield 167	com/tencent/mobileqq/activity/MakeVideoActivity:jdField_a_of_type_AndroidViewSurfaceView	Landroid/view/SurfaceView;
    //   427: invokevirtual 227	android/view/SurfaceView:getHolder	()Landroid/view/SurfaceHolder;
    //   430: new 672	syr
    //   433: dup
    //   434: aload_0
    //   435: invokespecial 673	syr:<init>	(Lcom/tencent/mobileqq/activity/MakeVideoActivity;)V
    //   438: invokeinterface 677 2 0
    //   443: return
    //   444: astore_1
    //   445: goto -124 -> 321
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	448	0	this	MakeVideoActivity
    //   0	448	1	paramBundle	android.os.Bundle
    //   231	90	2	j	int
    //   265	153	3	k	int
    //   1	282	4	m	int
    //   166	225	5	localObject	Object
    //   402	3	5	localJSONException	JSONException
    // Exception table:
    //   from	to	target	type
    //   143	232	318	java/lang/Exception
    //   333	365	402	org/json/JSONException
    //   232	243	444	java/lang/Exception
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqActivityMakeVideoActivity$ScreenBroadcastReceiver);
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    b();
    if (this.jdField_a_of_type_AndroidHardwareCamera != null)
    {
      this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallback(null);
      this.jdField_a_of_type_AndroidHardwareCamera.lock();
      this.jdField_a_of_type_AndroidHardwareCamera.stopPreview();
      this.jdField_a_of_type_AndroidHardwareCamera.release();
      this.jdField_a_of_type_AndroidHardwareCamera = null;
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_Boolean) {
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MakeVideoActivity
 * JD-Core Version:    0.7.0.1
 */