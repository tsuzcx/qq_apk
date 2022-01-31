package com.tencent.mobileqq.activity;

import abkh;
import abkj;
import abkk;
import aciy;
import ajjy;
import android.animation.ObjectAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqid;
import aqit;
import aqrw;
import auuv;
import auvu;
import awih;
import awij;
import awqx;
import babr;
import badq;
import bafb;
import bbjp;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppConf;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppWordings;
import com.tencent.mobileqq.richmedia.capture.view.IdentifierCameraCaptureView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytagreflectlivecheck.ui.YTReflectLayout;
import com.tencent.youtufacetrack.YoutuFaceTracker.FaceStatus;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

@RequiresApi(api=18)
public class QQIdentiferActivity
  extends BaseActivity
  implements Handler.Callback, View.OnClickListener, aqit, auvu, Runnable
{
  public static final String a;
  public static final String b;
  public static final String c;
  public static final String d;
  public static final String e;
  public int a;
  private long jdField_a_of_type_Long;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new abkk(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aqid jdField_a_of_type_Aqid;
  private bbjp jdField_a_of_type_Bbjp;
  private IdentifierCameraCaptureView jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewIdentifierCameraCaptureView;
  public YTReflectLayout a;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  private Map<String, Integer> jdField_a_of_type_JavaUtilMap;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(this);
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int[] jdField_a_of_type_ArrayOfInt = { 1, 2 };
  private String[] jdField_a_of_type_ArrayOfJavaLangString = { ajjy.a(2131644576), ajjy.a(2131644570) };
  private int jdField_b_of_type_Int;
  private volatile long jdField_b_of_type_Long;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private MqqHandler jdField_b_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManager.getSubThreadLooper(), this);
  private volatile boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private volatile long jdField_c_of_type_Long;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private volatile boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private volatile long jdField_d_of_type_Long;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = -1;
  private volatile long jdField_e_of_type_Long;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = 30;
  private volatile long jdField_f_of_type_Long;
  private String jdField_f_of_type_JavaLangString = ajjy.a(2131644582);
  private int jdField_g_of_type_Int = 120000;
  private String jdField_g_of_type_JavaLangString;
  private int h = 2000;
  private int i = 1000;
  private int j = 500;
  private int k = 10000;
  private int l = 150;
  private int m = 115;
  private int n = 5;
  private int o = 480;
  private int p = 640;
  private int q;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajjy.a(2131644574);
    jdField_b_of_type_JavaLangString = ajjy.a(2131644560);
    jdField_c_of_type_JavaLangString = ajjy.a(2131644559);
    jdField_d_of_type_JavaLangString = ajjy.a(2131644585);
    jdField_e_of_type_JavaLangString = ajjy.a(2131644564);
  }
  
  private Intent a(Intent paramIntent)
  {
    String str = this.jdField_a_of_type_JavaLangStringBuilder.toString();
    if (TextUtils.isEmpty(str)) {
      return paramIntent;
    }
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("allResults", str);
    return localIntent;
  }
  
  private auuv a()
  {
    auuv localauuv = new auuv();
    localauuv.b(480);
    localauuv.a(640);
    localauuv.a(false);
    return localauuv;
  }
  
  private String a()
  {
    int i1 = getIntent().getIntExtra("serviceType", -1);
    Object localObject = (FaceDetectForThirdPartyManager.AppConf)getIntent().getSerializableExtra("FaceRecognition.AppConf");
    if ((localObject == null) || (i1 == -1) || (((FaceDetectForThirdPartyManager.AppConf)localObject).al == null) || (((FaceDetectForThirdPartyManager.AppConf)localObject).al.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("qq_Identification.act", 2, "getAppWording PARAMS ERROR serviceType=" + i1 + " appConf=" + localObject);
      }
      return null;
    }
    localObject = ((FaceDetectForThirdPartyManager.AppConf)localObject).al.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FaceDetectForThirdPartyManager.AppWordings localAppWordings = (FaceDetectForThirdPartyManager.AppWordings)((Iterator)localObject).next();
      if (localAppWordings.serviceType == i1) {
        return localAppWordings.text;
      }
    }
    return null;
  }
  
  private void a(int paramInt, String paramString)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("ret", paramInt);
    localBundle.putString("errMsg", paramString);
    localIntent.putExtra("data", localBundle);
    setResult(-1, a(localIntent));
  }
  
  private void a(TextView paramTextView1, TextView paramTextView2, String paramString)
  {
    paramTextView1.setText(paramString);
    paramTextView2 = new TranslateAnimation(1, 0.5F, 1, 0.0F, 1, 0.0F, 1, 0.0F);
    paramTextView2.setDuration('È');
    paramTextView1.startAnimation(paramTextView2);
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#ffff4222"));
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      b(paramString);
      return;
    }
    paramString = a();
    if (paramString == null)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    b(paramString);
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    if ("setFaceData".equals(this.jdField_g_of_type_JavaLangString)) {
      awqx.b(null, "dc00898", "", "", paramString1, paramString1, 0, 0, "1", paramString2, paramString3, "");
    }
    if ("loginVerify".equals(this.jdField_g_of_type_JavaLangString)) {
      awqx.a(null, "dc00898", "", "", paramString1, paramString1, 0, 0, "2", paramString2, paramString3, "");
    }
  }
  
  private boolean a()
  {
    if ((Build.VERSION.SDK_INT >= 23) && (checkSelfPermission("android.permission.CAMERA") != 0))
    {
      a(205, ajjy.a(2131644573));
      finish();
      return false;
    }
    if (!awih.c())
    {
      a(203, ajjy.a(2131644571));
      babr.a(this, 230, ajjy.a(2131644586), ajjy.a(2131644579), "", ajjy.a(2131644567), new abkj(this), null).show();
      return false;
    }
    if (isInMultiWindow())
    {
      a(206, aqrw.jdField_b_of_type_JavaLangString);
      finish();
      return false;
    }
    return true;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      a(210, aqrw.jdField_c_of_type_JavaLangString);
    }
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_c_of_type_Int == paramInt) {
      return;
    }
    int i1 = bbjp.jdField_a_of_type_Int;
    int i3 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount();
    int i2 = 0;
    if (i2 < i3)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(i2);
      if (((View)localObject).getId() == 2131313731) {}
      for (;;)
      {
        i2 += 1;
        break;
        ((View)localObject).setVisibility(8);
      }
    }
    switch (paramInt)
    {
    default: 
      localObject = null;
    case 0: 
    case 1: 
    case 2: 
      for (;;)
      {
        if (localObject != null)
        {
          ((View)localObject).setVisibility(0);
          this.jdField_a_of_type_Bbjp.c(i1);
        }
        this.jdField_c_of_type_Int = paramInt;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("qq_Identification.act", 2, "change page mPageId = " + this.jdField_c_of_type_Int);
        return;
        localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131311598);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131644568));
        b(ajjy.a(2131644568));
        i1 = bbjp.jdField_a_of_type_Int;
        continue;
        localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131311567);
        i1 = 1;
        a(1, 0);
        continue;
        localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131311598);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131644562));
        b(ajjy.a(2131644562));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("qq_Identification.act", 2, "in result page, success: " + this.jdField_d_of_type_Boolean + ", retry: " + this.jdField_e_of_type_Boolean);
    }
    View localView1 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131311604);
    if (this.jdField_d_of_type_Boolean)
    {
      localObject = ajjy.a(2131644577);
      b((String)localObject);
      localView1.findViewById(2131311602).setVisibility(8);
      label406:
      long l1;
      if ("loginVerify".equals(this.jdField_g_of_type_JavaLangString))
      {
        awqx.b(null, "dc00898", "", "", "0X800A31A", "0X800A31A", 0, 0, "", "", "", "");
        l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
        if (!"setFaceData".equals(this.jdField_g_of_type_JavaLangString)) {
          break label555;
        }
        awqx.b(null, "dc00898", "", "", "0X800A861", "0X800A861", 0, 0, String.valueOf(l1), "1", "", "");
      }
      for (;;)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(3, this.h);
        i2 = 2130839795;
        this.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(i2);
        localObject = localView1;
        break;
        if (!"setFaceData".equals(this.jdField_g_of_type_JavaLangString)) {
          break label406;
        }
        awqx.b(null, "dc00898", "", "", "0X800A31F", "0X800A31F", 0, 0, "", "", "", "");
        break label406;
        label555:
        if ("loginVerify".equals(this.jdField_g_of_type_JavaLangString)) {
          awqx.b(null, "dc00898", "", "", "0X800A861", "0X800A861", 0, 0, String.valueOf(l1), "2", "", "");
        }
      }
    }
    Object localObject = this.jdField_f_of_type_JavaLangString;
    View localView2 = localView1.findViewById(2131311602);
    if (this.jdField_e_of_type_Boolean) {}
    for (i2 = 0;; i2 = 8)
    {
      localView2.setVisibility(i2);
      c("0X800A865");
      i2 = 2130839794;
      break;
    }
  }
  
  private void b(String paramString)
  {
    if ("identify".equals(this.jdField_g_of_type_JavaLangString)) {
      return;
    }
    if (paramString == null)
    {
      QLog.e("qq_Identification.act", 1, "add wording record, wording is null");
      return;
    }
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
    {
      Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      this.jdField_a_of_type_JavaUtilMap.put(paramString, Integer.valueOf(localInteger.intValue() + 1));
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramString, Integer.valueOf(1));
  }
  
  private void c(String paramString)
  {
    a(paramString, "", "");
  }
  
  public Bundle a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("params_pose", this.jdField_a_of_type_ArrayOfInt[this.jdField_d_of_type_Int]);
    return localBundle;
  }
  
  public void a()
  {
    this.jdField_c_of_type_Boolean = true;
    if (!badq.g(this))
    {
      this.jdField_f_of_type_JavaLangString = ajjy.a(2131644565);
      this.jdField_d_of_type_Boolean = false;
      this.jdField_e_of_type_Boolean = true;
      a(202, this.jdField_f_of_type_JavaLangString);
      localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(0);
      localMessage.arg1 = 3;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
      return;
    }
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(0);
    localMessage.arg1 = 2;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 0L);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new QQIdentiferActivity.4(this, paramInt));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_b_of_type_Int == paramInt1) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("qq_Identification.act", 2, String.format(" currentState = %d,pendingState = %d", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(paramInt1) }));
    }
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    Object localObject;
    switch (paramInt1)
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      for (;;)
      {
        if (Math.abs(paramInt1 - this.jdField_b_of_type_Int) > 1) {}
        this.jdField_b_of_type_Int = paramInt1;
        return;
        if (((this.jdField_b_of_type_Int == 3) || (this.jdField_b_of_type_Int == 4)) && (!this.jdField_e_of_type_Boolean))
        {
          this.jdField_e_of_type_Boolean = false;
          a(this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_c_of_type_AndroidWidgetTextView, jdField_a_of_type_JavaLangString);
        }
        for (;;)
        {
          b(jdField_a_of_type_JavaLangString);
          a(null);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_a_of_type_Bbjp.c(1);
          localObject = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "rotation", new float[] { 0.0F, 360.0F });
          ((ObjectAnimator)localObject).setInterpolator(new LinearInterpolator());
          ((ObjectAnimator)localObject).setRepeatCount(-1);
          ((ObjectAnimator)localObject).setRepeatMode(1);
          ((ObjectAnimator)localObject).setDuration(10000L);
          ((ObjectAnimator)localObject).start();
          this.jdField_b_of_type_Long = System.currentTimeMillis();
          break;
          a(this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_c_of_type_AndroidWidgetTextView, jdField_a_of_type_JavaLangString);
        }
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        this.jdField_b_of_type_AndroidWidgetTextView.setText(jdField_a_of_type_JavaLangString);
        b(jdField_a_of_type_JavaLangString);
        a(jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_Bbjp.c(2);
        continue;
        this.jdField_c_of_type_Long = System.currentTimeMillis();
        localObject = this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_d_of_type_Int];
        localObject = String.format(jdField_c_of_type_JavaLangString, new Object[] { localObject });
        if ((this.jdField_b_of_type_Int == 1) || (this.jdField_b_of_type_Int == 2)) {
          a(this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_c_of_type_AndroidWidgetTextView, (String)localObject);
        }
        for (;;)
        {
          this.jdField_a_of_type_Bbjp.c(3);
          a(null);
          this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          break;
          this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        }
        this.jdField_c_of_type_Long = System.currentTimeMillis();
        localObject = this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_d_of_type_Int];
        localObject = String.format(jdField_c_of_type_JavaLangString, new Object[] { localObject });
        this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        a(jdField_d_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_Bbjp.c(4);
      }
    case 5: 
      this.jdField_e_of_type_Long = System.currentTimeMillis();
      localObject = "";
      if (paramInt2 == aqid.jdField_d_of_type_Int)
      {
        localObject = ajjy.a(2131644558);
        label540:
        if ((this.jdField_b_of_type_Int == paramInt1) || (Math.abs(this.jdField_f_of_type_Long - this.jdField_e_of_type_Long) <= 300L)) {
          break label648;
        }
        a(this.jdField_b_of_type_AndroidWidgetTextView, null, (String)localObject);
      }
      for (;;)
      {
        b((String)localObject);
        this.jdField_a_of_type_Bbjp.c(5);
        a(null);
        this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break;
        if (paramInt2 == aqid.jdField_e_of_type_Int)
        {
          localObject = ajjy.a(2131644584);
          break label540;
        }
        if (paramInt2 != aqid.jdField_g_of_type_Int) {
          break label540;
        }
        localObject = ajjy.a(2131644580);
        break label540;
        label648:
        this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
    }
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    this.jdField_f_of_type_Long = this.jdField_d_of_type_Long;
    if ((this.jdField_b_of_type_Int != paramInt1) && (Math.abs(this.jdField_f_of_type_Long - this.jdField_e_of_type_Long) > 300L)) {
      a(this.jdField_b_of_type_AndroidWidgetTextView, null, jdField_e_of_type_JavaLangString);
    }
    for (;;)
    {
      b(jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_Bbjp.c(5);
      a(null);
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(jdField_e_of_type_JavaLangString);
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    int i1;
    if (paramBundle != null)
    {
      i1 = paramBundle.getInt("ret", -1);
      if ((i1 != -1) && (paramBundle.getBoolean("needRetry", false))) {
        this.jdField_a_of_type_JavaLangStringBuilder.append(i1).append("|");
      }
      if (QLog.isColorLevel()) {
        QLog.d("qq_Identification.act", 2, "QQIdentifer onRequestFinish: ,ret=" + i1);
      }
    }
    for (;;)
    {
      Intent localIntent;
      switch (paramInt)
      {
      default: 
        if (paramBundle != null)
        {
          this.jdField_f_of_type_JavaLangString = paramBundle.getString("errMsg");
          localIntent = new Intent();
          localIntent.putExtra("data", paramBundle);
          setResult(-1, a(localIntent));
        }
        break;
      }
      for (;;)
      {
        this.jdField_d_of_type_Boolean = false;
        this.jdField_e_of_type_Boolean = true;
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("qq_Identification.act", 2, "onRequestFinish: code=" + paramInt + ",ret=" + i1 + "|" + this.jdField_f_of_type_JavaLangString);
          }
          paramBundle = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(0);
          paramBundle.arg1 = 3;
          this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramBundle);
          return;
          if (paramBundle != null)
          {
            if (paramBundle.getInt("ret") == 0) {}
            for (boolean bool = true;; bool = false)
            {
              this.jdField_d_of_type_Boolean = bool;
              this.jdField_e_of_type_Boolean = paramBundle.getBoolean("needRetry");
              this.jdField_f_of_type_JavaLangString = paramBundle.getString("errMsg");
              localIntent = new Intent();
              localIntent.putExtra("data", paramBundle);
              paramBundle = a(localIntent);
              if (this.jdField_d_of_type_Boolean) {
                paramBundle.putExtra("key_face_scan_result", true);
              }
              setResult(-1, paramBundle);
              break;
            }
          }
          this.jdField_d_of_type_Boolean = false;
          this.jdField_e_of_type_Boolean = true;
          this.jdField_f_of_type_JavaLangString = ajjy.a(2131644561);
          setResult(-1, a(null));
        }
        this.jdField_f_of_type_JavaLangString = ajjy.a(2131644569);
        setResult(-1, a(null));
      }
      i1 = -1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(0);
    if (paramBoolean) {
      localMessage.arg1 = 1;
    }
    for (;;)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 0L);
      return;
      localMessage.arg1 = 3;
      this.jdField_f_of_type_JavaLangString = ajjy.a(2131644578);
      a(207, this.jdField_f_of_type_JavaLangString);
    }
  }
  
  public void a(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if ((paramArrayOfByte != null) && (!this.jdField_a_of_type_Boolean) && (!this.jdField_c_of_type_Boolean) && (this.jdField_c_of_type_Int == 1))
    {
      this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      if (this.jdField_a_of_type_Int == 2)
      {
        int i1 = YTAGReflectLiveCheckInterface.getProcessState();
        if (i1 == 2) {
          YTAGReflectLiveCheckInterface.onPreviewFrame(paramArrayOfByte, paramCamera);
        }
        if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (i1 != 2) && (i1 != 3)) {}
      }
    }
    else
    {
      return;
    }
    this.jdField_b_of_type_MqqOsMqqHandler.post(this);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidContentContext = this;
    getWindow().setFlags(1024, 1024);
    getWindow().setFlags(128, 128);
    requestWindowFeature(1);
    this.mNeedStatusTrans = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131495220);
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    paramBundle = getIntent();
    this.jdField_a_of_type_Int = paramBundle.getIntExtra("key_identification_type", 2);
    this.jdField_g_of_type_JavaLangString = paramBundle.getStringExtra("method");
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131302149));
    this.jdField_a_of_type_Bbjp = new bbjp();
    int i1 = aciy.a(this.l, getResources());
    int i3 = getResources().getDisplayMetrics().widthPixels;
    int i2 = getResources().getDisplayMetrics().heightPixels;
    float f1 = this.o / i3;
    float f2 = this.p / i2;
    if (f1 < f2)
    {
      i3 = this.o / 2;
      int i4 = this.p / 2;
      int i5 = (int)(f1 * i1) + 30;
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect(i3 - i5, i4 - i5, i3 + i5, i5 + i4);
      this.jdField_a_of_type_Bbjp.a(i1);
      this.jdField_a_of_type_Bbjp.b(aciy.a(this.n, getResources()));
      this.jdField_a_of_type_Bbjp.c(bbjp.jdField_a_of_type_Int);
      if (Build.VERSION.SDK_INT <= 15) {
        break label594;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackground(this.jdField_a_of_type_Bbjp);
    }
    for (;;)
    {
      i2 /= 2;
      i3 = aciy.a(this.m, getResources());
      findViewById(2131298297).post(new QQIdentiferActivity.1(this, i2 - i1 - i3));
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewIdentifierCameraCaptureView = ((IdentifierCameraCaptureView)findViewById(2131302148));
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewIdentifierCameraCaptureView.d(false);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewIdentifierCameraCaptureView.setCaptureParam(a());
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewIdentifierCameraCaptureView.setDarkModeEnable(false);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewIdentifierCameraCaptureView.setPreviewCallback(this);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewIdentifierCameraCaptureView.setCaptureListener(new abkh(this));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131311598));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131306332));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131311606));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131311603));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131311568));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131311569));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298286));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131296999));
      this.jdField_a_of_type_ComTencentYoutuYtagreflectlivecheckUiYTReflectLayout = ((YTReflectLayout)findViewById(2131313731));
      a(null);
      findViewById(2131298297).setOnClickListener(this);
      findViewById(2131311601).setOnClickListener(this);
      findViewById(2131311602).setOnClickListener(this);
      if (a()) {
        break label608;
      }
      return true;
      f1 = f2;
      break;
      label594:
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(this.jdField_a_of_type_Bbjp);
    }
    label608:
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_d_of_type_Int = ((int)(Math.random() * 2.0D));
    b(0);
    if (this.q == 0)
    {
      paramBundle = new IntentFilter();
      paramBundle.addAction("tencent.av.v2q.StartVideoChat");
      paramBundle.addAction("tencent.av.v2q.AvSwitch");
      paramBundle.addAction("mqq.intent.action.ACCOUNT_KICKED");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
      this.q = 1;
    }
    this.jdField_a_of_type_Aqid = new aqid(this, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1, this.jdField_g_of_type_Int);
    i1 = getIntent().getIntExtra("serviceType", -1);
    awqx.b(this.app, "dc00898", "", "", "0X80097EA", "0X80097EA", 0, 0, i1 + "", "" + this.jdField_a_of_type_Int, getIntent().getIntExtra("srcAppId", 0) + "", "");
    c("0X800A85F");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Aqid != null) {
      this.jdField_a_of_type_Aqid.c();
    }
    if (this.q == 1)
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.q = 0;
    }
    long l1;
    if (!this.jdField_d_of_type_Boolean)
    {
      l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      if (!"setFaceData".equals(this.jdField_g_of_type_JavaLangString)) {
        break label207;
      }
      awqx.b(null, "dc00898", "", "", "0X800A862", "0X800A862", 0, 0, String.valueOf(l1), "1", "", "");
    }
    while ((this.jdField_a_of_type_JavaUtilMap != null) && (!this.jdField_a_of_type_JavaUtilMap.isEmpty()))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        a("0X800A863", String.valueOf(((Integer)this.jdField_a_of_type_JavaUtilMap.get(str)).intValue()), str);
      }
      label207:
      if ("loginVerify".equals(this.jdField_g_of_type_JavaLangString)) {
        awqx.b(null, "dc00898", "", "", "0X800A862", "0X800A862", 0, 0, String.valueOf(l1), "2", "", "");
      }
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewIdentifierCameraCaptureView.onPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewIdentifierCameraCaptureView.onResume();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 0: 
      b(paramMessage.arg1);
      return false;
    case 2: 
      a(paramMessage.arg1, paramMessage.arg2);
      return false;
    case 3: 
      finish();
      return false;
    }
    a(false);
    return false;
  }
  
  public boolean onBackEvent()
  {
    b();
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131298297: 
      if (!"setFaceData".equals(this.jdField_g_of_type_JavaLangString))
      {
        QLog.d("qq_Identification.act", 1, "click cancel, method is not METHOD_SETTING_FACE_DATA");
        b();
      }
      c("0X800A860");
      finish();
      return;
    case 2131311601: 
      if ("setFaceData".equals(this.jdField_g_of_type_JavaLangString))
      {
        QLog.d("qq_Identification.act", 1, new Object[] { "click title_result_btn1, method not METHOD_SETTING_FACE_DATA， result is ", Boolean.valueOf(this.jdField_d_of_type_Boolean) });
        if (!this.jdField_d_of_type_Boolean) {
          setResult(-1);
        }
      }
      c("0X800A867");
      finish();
      return;
    }
    if (this.jdField_e_of_type_Int == this.jdField_d_of_type_Int) {
      if (QLog.isColorLevel()) {
        QLog.d("qq_Identification.act", 2, "failed");
      }
    }
    for (this.jdField_d_of_type_Int = ((this.jdField_d_of_type_Int + 1) % this.jdField_a_of_type_ArrayOfInt.length);; this.jdField_d_of_type_Int = ((int)(Math.random() * 2.0D)))
    {
      b(1);
      this.jdField_c_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      c("0X800A866");
      return;
      this.jdField_e_of_type_Int = this.jdField_d_of_type_Int;
    }
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
    if (paramBoolean)
    {
      a(206, ajjy.a(2131644572));
      finish();
    }
  }
  
  public void run()
  {
    Object localObject = awij.a().jdField_a_of_type_AndroidHardwareCamera;
    int i4 = awij.a().jdField_a_of_type_Int;
    if ((localObject == null) || (!isResume()) || (this.jdField_a_of_type_Aqid == null) || (!this.jdField_a_of_type_Aqid.b())) {}
    int i1;
    do
    {
      return;
      i1 = ((Camera)localObject).getParameters().getPreviewSize().width;
      i2 = ((Camera)localObject).getParameters().getPreviewSize().height;
    } while ((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_b_of_type_Int < 1));
    this.jdField_a_of_type_Boolean = true;
    YoutuFaceTracker.FaceStatus[] arrayOfFaceStatus = this.jdField_a_of_type_Aqid.a(this.jdField_a_of_type_ArrayOfByte, i1, i2);
    int i2 = 0;
    int i3 = 0;
    boolean bool;
    long l1;
    if (this.jdField_a_of_type_Int == 3) {
      if (arrayOfFaceStatus != null)
      {
        bool = aqid.a(arrayOfFaceStatus[0], this.jdField_a_of_type_AndroidGraphicsRect);
        l1 = System.currentTimeMillis() - this.jdField_b_of_type_Long;
        if (l1 >= this.i) {
          break label335;
        }
        i1 = 1;
        label158:
        if ((arrayOfFaceStatus == null) || (!bool) || (i1 != 0)) {
          break label379;
        }
        l1 = System.currentTimeMillis() - this.jdField_c_of_type_Long;
        if ((l1 <= this.k) || (this.jdField_c_of_type_Long == 0L)) {
          break label340;
        }
        i2 = 4;
        label204:
        if (this.jdField_c_of_type_Long != 0L) {
          break label358;
        }
        i3 = 1;
        label215:
        i1 = i2;
        if (i3 == 0)
        {
          if (!this.jdField_b_of_type_Boolean)
          {
            this.jdField_b_of_type_Boolean = true;
            this.jdField_a_of_type_Aqid.a((Camera)localObject, i4);
          }
          this.jdField_a_of_type_Aqid.a(arrayOfFaceStatus[0], this.jdField_a_of_type_ArrayOfInt[this.jdField_d_of_type_Int], this.jdField_a_of_type_ArrayOfByte, (Camera)localObject);
          i1 = i2;
        }
        label272:
        i3 = 0;
        i2 = i1;
        i1 = i3;
      }
    }
    for (;;)
    {
      if ((i2 != this.jdField_b_of_type_Int) || (i2 == 5))
      {
        localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(2);
        ((Message)localObject).arg1 = i2;
        ((Message)localObject).arg2 = i1;
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
      }
      this.jdField_a_of_type_Boolean = false;
      return;
      bool = false;
      break;
      label335:
      i1 = 0;
      break label158;
      label340:
      if (this.jdField_b_of_type_Int == 4)
      {
        i2 = 4;
        break label204;
      }
      i2 = 3;
      break label204;
      label358:
      if (l1 < this.j)
      {
        i3 = 1;
        break label215;
      }
      i3 = 0;
      break label215;
      label379:
      if ((l1 > this.k) && (this.jdField_b_of_type_Long != 0L))
      {
        i1 = 2;
        break label272;
      }
      if (this.jdField_b_of_type_Int == 2)
      {
        i1 = 2;
        break label272;
      }
      i1 = 1;
      break label272;
      if (this.jdField_a_of_type_Int == 2)
      {
        i1 = aqid.a(this.jdField_a_of_type_AndroidGraphicsRect, arrayOfFaceStatus);
        l1 = System.currentTimeMillis() - this.jdField_b_of_type_Long;
        if (l1 < this.i) {
          i2 = 1;
        }
        for (;;)
        {
          if ((i1 != aqid.jdField_c_of_type_Int) && (i1 != aqid.jdField_f_of_type_Int) && (i2 == 0))
          {
            if (i1 == aqid.jdField_b_of_type_Int)
            {
              i2 = 6;
              i3 = i1;
              if (this.jdField_d_of_type_Long == 0L) {
                break label599;
              }
              if ((System.currentTimeMillis() - this.jdField_d_of_type_Long > 1000L) && (!this.jdField_b_of_type_Boolean))
              {
                this.jdField_b_of_type_Boolean = true;
                this.jdField_a_of_type_Aqid.a((Camera)localObject, i4);
              }
              i2 = 6;
              break;
              i2 = 0;
              continue;
            }
            i2 = 5;
            break;
          }
        }
        if ((l1 > this.k) && (this.jdField_b_of_type_Long != 0L)) {
          i2 = 2;
        } else if (this.jdField_b_of_type_Int == 2) {
          i2 = 2;
        } else {
          i2 = 1;
        }
      }
      else
      {
        label599:
        i1 = i3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQIdentiferActivity
 * JD-Core Version:    0.7.0.1
 */