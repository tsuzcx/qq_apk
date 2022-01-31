package com.tencent.mobileqq.activity;

import adqa;
import adqc;
import adqd;
import adqe;
import alud;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import asxl;
import asxw;
import atho;
import axpz;
import axqt;
import axrv;
import azhe;
import azqs;
import azri;
import bdgm;
import bdin;
import bdjz;
import beqm;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppConf;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppWordings;
import com.tencent.mobileqq.richmedia.capture.view.CircleBarView;
import com.tencent.mobileqq.richmedia.capture.view.IdentifierCameraCaptureView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import com.tencent.youtu.ytagreflectlivecheck.ui.YTReflectLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

@RequiresApi(api=18)
public class QQIdentiferActivity
  extends BaseActivity
  implements Handler.Callback, View.OnClickListener, asxw, axrv
{
  public int a;
  private long jdField_a_of_type_Long;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new adqe(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private asxl jdField_a_of_type_Asxl;
  private beqm jdField_a_of_type_Beqm;
  private CircleBarView jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView;
  private IdentifierCameraCaptureView jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewIdentifierCameraCaptureView;
  public YTReflectLayout a;
  private String jdField_a_of_type_JavaLangString = alud.a(2131694575);
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  private Map<String, Object> jdField_a_of_type_JavaUtilMap = new HashMap();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(this);
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int = -1;
  private final long jdField_b_of_type_Long = 60000L;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private Map<String, Integer> jdField_b_of_type_JavaUtilMap;
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private MqqHandler jdField_b_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManager.getSubThreadLooper(), this);
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 120000;
  private volatile long jdField_c_of_type_Long;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private Map<String, String> jdField_c_of_type_JavaUtilMap = new QQIdentiferActivity.1(this);
  private AtomicBoolean jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 1500;
  private long jdField_d_of_type_Long;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private AtomicBoolean jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  private int e;
  private int f = Color.rgb(0, 202, 252);
  private int g = Color.rgb(255, 64, 96);
  private int h = Color.argb(0, 0, 0, 0);
  private int i = 1000;
  
  private Intent a(Intent paramIntent)
  {
    String str = this.jdField_a_of_type_JavaLangStringBuilder.toString();
    if ((paramIntent != null) && (paramIntent.hasExtra("data"))) {
      b(paramIntent.getBundleExtra("data").getInt("ret", 299), "");
    }
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
  
  private axqt a()
  {
    axqt localaxqt = new axqt();
    localaxqt.b(480);
    localaxqt.a(640);
    localaxqt.a(false);
    return localaxqt;
  }
  
  private String a()
  {
    int j = getIntent().getIntExtra("serviceType", -1);
    Object localObject = (FaceDetectForThirdPartyManager.AppConf)getIntent().getSerializableExtra("FaceRecognition.AppConf");
    if ((localObject == null) || (j == -1) || (((FaceDetectForThirdPartyManager.AppConf)localObject).al == null) || (((FaceDetectForThirdPartyManager.AppConf)localObject).al.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("qq_Identification.act", 2, "getAppWording PARAMS ERROR serviceType=" + j + " appConf=" + localObject);
      }
      return null;
    }
    localObject = ((FaceDetectForThirdPartyManager.AppConf)localObject).al.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FaceDetectForThirdPartyManager.AppWordings localAppWordings = (FaceDetectForThirdPartyManager.AppWordings)((Iterator)localObject).next();
      if (localAppWordings.serviceType == j) {
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
  
  private void a(String paramString)
  {
    if ("identify".equals(this.jdField_b_of_type_JavaLangString)) {
      return;
    }
    if (paramString == null)
    {
      QLog.e("qq_Identification.act", 1, "add wording record, wording is null");
      return;
    }
    if (this.jdField_b_of_type_JavaUtilMap.containsKey(paramString))
    {
      Integer localInteger = (Integer)this.jdField_b_of_type_JavaUtilMap.get(paramString);
      this.jdField_b_of_type_JavaUtilMap.put(paramString, Integer.valueOf(localInteger.intValue() + 1));
      return;
    }
    this.jdField_b_of_type_JavaUtilMap.put(paramString, Integer.valueOf(1));
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    if ("setFaceData".equals(this.jdField_b_of_type_JavaLangString)) {
      azqs.b(null, "dc00898", "", "", paramString1, paramString1, 0, 0, "1", paramString2, paramString3, "");
    }
    if ("loginVerify".equals(this.jdField_b_of_type_JavaLangString)) {
      azqs.a(null, "dc00898", "", "", paramString1, paramString1, 0, 0, "2", paramString2, paramString3, "");
    }
  }
  
  private boolean a()
  {
    if ((Build.VERSION.SDK_INT >= 23) && (checkSelfPermission("android.permission.CAMERA") != 0))
    {
      a(205, alud.a(2131710753));
      finish();
      return false;
    }
    if (!azhe.c())
    {
      a(203, alud.a(2131710751));
      bdgm.a(this, 230, alud.a(2131710766), alud.a(2131710759), "", alud.a(2131710747), new adqd(this), null).show();
      return false;
    }
    if (isInMultiWindow())
    {
      a(206, atho.jdField_b_of_type_JavaLangString);
      finish();
      return false;
    }
    return true;
  }
  
  private void b(int paramInt, String paramString)
  {
    QLog.d("qq_Identification.act", 1, new Object[] { "collectErrorCode error code : ", Integer.valueOf(paramInt) });
    HashMap localHashMap = new HashMap(4);
    localHashMap.put("errorCode", String.valueOf(paramInt));
    if (!TextUtils.isEmpty(paramString)) {
      localHashMap.put("errorMsg", paramString);
    }
    paramString = getAppInterface();
    if (paramString == null) {}
    for (paramString = "";; paramString = paramString.getAccount())
    {
      if (!TextUtils.isEmpty(paramString)) {
        localHashMap.put("key_uin", paramString);
      }
      azri.a(BaseApplicationImpl.getApplication()).a(paramString, "tagIdentificationErrorCode", this.jdField_a_of_type_Boolean, 0L, 0L, localHashMap, "");
      return;
    }
  }
  
  private void b(String paramString)
  {
    a(paramString, "", "");
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      a(210, atho.jdField_c_of_type_JavaLangString);
    }
  }
  
  private void g()
  {
    ThreadManagerV2.executeOnFileThread(new QQIdentiferActivity.9(this));
  }
  
  public void a()
  {
    if (!bdin.g(this))
    {
      this.jdField_a_of_type_JavaLangString = alud.a(2131710745);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = true;
      a(202, this.jdField_a_of_type_JavaLangString);
      QLog.e("qq_Identification.act", 1, "onUploadVideo net error");
      b(this.jdField_a_of_type_JavaLangString);
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    c();
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    int j;
    if (paramBundle != null)
    {
      j = paramBundle.getInt("ret", -1);
      if ((j != -1) && (paramBundle.getBoolean("needRetry", false))) {
        this.jdField_a_of_type_JavaLangStringBuilder.append(j).append("|");
      }
      if (QLog.isColorLevel()) {
        QLog.d("qq_Identification.act", 2, "QQIdentifer onRequestFinish: ,ret=" + j);
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
          this.jdField_a_of_type_JavaLangString = paramBundle.getString("errMsg");
          localIntent = new Intent();
          localIntent.putExtra("data", paramBundle);
          setResult(-1, a(localIntent));
        }
        break;
      }
      for (;;)
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_b_of_type_Boolean = true;
        for (;;)
        {
          QLog.d("qq_Identification.act", 1, new Object[] { "onRequestFinish: code=", Integer.valueOf(paramInt), ",ret=", Integer.valueOf(j), "|", this.jdField_a_of_type_JavaLangString, " isSuccess : ", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
          this.jdField_a_of_type_MqqOsMqqHandler.post(new QQIdentiferActivity.6(this));
          return;
          if (paramBundle != null)
          {
            if (paramBundle.getInt("ret") == 0) {}
            for (boolean bool = true;; bool = false)
            {
              this.jdField_a_of_type_Boolean = bool;
              this.jdField_b_of_type_Boolean = paramBundle.getBoolean("needRetry");
              this.jdField_a_of_type_JavaLangString = paramBundle.getString("errMsg");
              localIntent = new Intent();
              localIntent.putExtra("data", paramBundle);
              paramBundle = a(localIntent);
              if (this.jdField_a_of_type_Boolean) {
                paramBundle.putExtra("key_face_scan_result", true);
              }
              setResult(-1, paramBundle);
              break;
            }
          }
          this.jdField_a_of_type_Boolean = false;
          this.jdField_b_of_type_Boolean = true;
          this.jdField_a_of_type_JavaLangString = alud.a(2131710741);
          setResult(-1, a(null));
        }
        this.jdField_a_of_type_JavaLangString = alud.a(2131710749);
        setResult(-1, a(null));
      }
      j = -1;
    }
  }
  
  public void a(ColorMatrixColorFilter paramColorMatrixColorFilter)
  {
    this.jdField_a_of_type_ComTencentYoutuYtagreflectlivecheckUiYTReflectLayout.setColorMatrixColorFilter(paramColorMatrixColorFilter);
    this.jdField_a_of_type_Beqm.a(paramColorMatrixColorFilter);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.a(this.h);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    long l = System.currentTimeMillis();
    if (this.jdField_d_of_type_Long != 0L) {
      QLog.d("qq_Identification.act", 1, new Object[] { "reflect delta time is : ", Long.valueOf(l - this.jdField_d_of_type_Long) });
    }
    this.jdField_d_of_type_Long = l;
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    a(paramCharSequence.toString());
  }
  
  public void a(CharSequence paramCharSequence, Map<String, Object> paramMap)
  {
    if ((this.jdField_b_of_type_AndroidWidgetLinearLayout.getVisibility() != 0) || (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.b(this.h);
      if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramCharSequence);
      }
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    paramMap = paramMap.get("keyStateIdentify");
    if ("statePass".equals(paramMap))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.a(this.f);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.b(this.h);
    }
    for (;;)
    {
      a(paramCharSequence.toString());
      return;
      if ("stateNotPass".equals(paramMap))
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.a(this.g);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.b(this.h);
      }
    }
  }
  
  public void a(Map<String, Object> paramMap)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewIdentifierCameraCaptureView == null) || (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {}
    for (;;)
    {
      return;
      if (paramMap.containsKey("ui_tips")) {}
      try
      {
        String str1 = getActivity().getPackageName();
        String str2 = (String)paramMap.get("ui_tips");
        String str3 = (String)this.jdField_c_of_type_JavaUtilMap.get(str2);
        if (!TextUtils.isEmpty(str3)) {}
        for (this.jdField_c_of_type_JavaLangString = str3;; this.jdField_c_of_type_JavaLangString = getString(getResources().getIdentifier(str2, "string", str1)))
        {
          if (paramMap.containsKey("ui_action"))
          {
            if (!"not_pass".equals(paramMap.get("ui_action"))) {
              break label275;
            }
            this.jdField_a_of_type_JavaUtilMap.put("keyStateIdentify", "stateNotPass");
          }
          if ((!paramMap.containsKey("process_action")) || (!"failed".equals(paramMap.get("process_action")))) {
            break;
          }
          this.jdField_b_of_type_Boolean = true;
          this.jdField_a_of_type_JavaLangString = ((String)paramMap.get("message"));
          QLog.e("qq_Identification.act", 1, new Object[] { "handleEvent process result failed : ", this.jdField_a_of_type_JavaLangString });
          b(this.jdField_a_of_type_JavaLangString);
          b(-10, this.jdField_a_of_type_JavaLangString);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("qq_Identification.act", 1, "get resource string error : " + localException.getMessage());
          continue;
          label275:
          if ("pass".equals(paramMap.get("ui_action"))) {
            this.jdField_a_of_type_JavaUtilMap.put("keyStateIdentify", "statePass");
          } else {
            this.jdField_a_of_type_JavaUtilMap.put("keyStateIdentify", null);
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378002).setVisibility(8);
      if (!TextUtils.isEmpty(a()))
      {
        String str = a();
        a(str);
        a(str);
      }
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_Beqm.a(getResources().getColor(2131167140));
      findViewById(2131363909).post(new QQIdentiferActivity.8(this));
      return;
    }
    a(paramInt, this.jdField_a_of_type_JavaLangString);
    b(alud.a(2131710758));
  }
  
  public void a(byte[] paramArrayOfByte, Camera paramCamera)
  {
    paramCamera = paramCamera.getParameters().getPreviewSize();
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    YtFSM.getInstance().update(paramArrayOfByte, paramCamera.width, paramCamera.height, 1);
  }
  
  public void b()
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378002).setVisibility(0);
    this.jdField_a_of_type_Beqm.a(getResources().getColor(2131167142));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131710748));
    a(alud.a(2131710748));
  }
  
  public void b(CharSequence paramCharSequence)
  {
    int j = 0;
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = alud.a(2131710749);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewIdentifierCameraCaptureView.onPause();
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378002).setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840191);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.a();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.a(getResources().getColor(2131165438));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.b(this.h);
    this.jdField_a_of_type_Beqm.a(getResources().getColor(2131167142));
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(5);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    g();
    paramCharSequence = findViewById(2131378005);
    if (this.jdField_b_of_type_Boolean) {}
    for (;;)
    {
      paramCharSequence.setVisibility(j);
      a(((CharSequence)localObject).toString());
      b("0X800A865");
      return;
      j = 8;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewIdentifierCameraCaptureView.onPause();
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378002).setVisibility(0);
    this.jdField_a_of_type_Beqm.a(getResources().getColor(2131167142));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131710742));
    findViewById(2131368330).setVisibility(8);
    a(alud.a(2131710742));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.a(this.h);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.b(this.f);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.a(1000);
    g();
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(5, 60000L);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewIdentifierCameraCaptureView.onPause();
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378002).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(alud.a(2131710757));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840192);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    findViewById(2131378005).setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.a();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.a(this.f);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.b(this.h);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(5);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    if ("loginVerify".equals(this.jdField_b_of_type_JavaLangString)) {
      azqs.b(null, "dc00898", "", "", "0X800A31A", "0X800A31A", 0, 0, "", "", "", "");
    }
    long l;
    do
    {
      for (;;)
      {
        l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
        if (!"setFaceData".equals(this.jdField_b_of_type_JavaLangString)) {
          break;
        }
        azqs.b(null, "dc00898", "", "", "0X800A861", "0X800A861", 0, 0, String.valueOf(l), "1", "", "");
        return;
        if ("setFaceData".equals(this.jdField_b_of_type_JavaLangString)) {
          azqs.b(null, "dc00898", "", "", "0X800A31F", "0X800A31F", 0, 0, "", "", "", "");
        }
      }
    } while (!"loginVerify".equals(this.jdField_b_of_type_JavaLangString));
    azqs.b(null, "dc00898", "", "", "0X800A861", "0X800A861", 0, 0, String.valueOf(l), "2", "", "");
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidContentContext = this;
    if (Build.VERSION.SDK_INT >= 19) {
      getWindow().setFlags(67108864, 67108864);
    }
    getWindow().setFlags(128, 128);
    requestWindowFeature(1);
    ImmersiveUtils.a(true, getWindow());
    this.mNeedStatusTrans = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131560997);
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    paramBundle = getIntent();
    this.jdField_a_of_type_Int = paramBundle.getIntExtra("key_identification_type", 2);
    this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("method");
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131377971));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131367912));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewIdentifierCameraCaptureView = ((IdentifierCameraCaptureView)findViewById(2131367911));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewIdentifierCameraCaptureView.d(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewIdentifierCameraCaptureView.setCaptureParam(a());
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewIdentifierCameraCaptureView.setDarkModeEnable(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewIdentifierCameraCaptureView.setPreviewCallback(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewIdentifierCameraCaptureView.setCaptureListener(new adqa(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372366));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378009));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378007));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377972));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363899));
    this.jdField_a_of_type_ComTencentYoutuYtagreflectlivecheckUiYTReflectLayout = ((YTReflectLayout)findViewById(2131380374));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView = ((CircleBarView)findViewById(2131380373));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131378006));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131379480);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131378008));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131380375);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368722));
    this.jdField_a_of_type_Beqm = new beqm();
    if (Build.VERSION.SDK_INT > 15) {
      this.jdField_a_of_type_AndroidViewView.setBackground(this.jdField_a_of_type_Beqm);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.a(getResources().getColor(2131165438));
      paramBundle = findViewById(2131363909);
      paramBundle.setOnClickListener(this);
      paramBundle.post(new QQIdentiferActivity.3(this, paramBundle));
      findViewById(2131378005).setOnClickListener(this);
      if (a()) {
        break;
      }
      QLog.e("qq_Identification.act", 1, "preCheck not pass");
      return true;
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_Beqm);
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_a_of_type_Asxl = new asxl(this, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(4);
    b();
    if (TextUtils.isEmpty(a()))
    {
      QLog.d("qq_Identification.act", 1, "getAppWording return empty");
      axpz.a().a(getApplicationContext(), new adqc(this));
    }
    if (this.e == 0)
    {
      paramBundle = new IntentFilter();
      paramBundle.addAction("tencent.av.v2q.StartVideoChat");
      paramBundle.addAction("tencent.av.v2q.AvSwitch");
      paramBundle.addAction("mqq.intent.action.ACCOUNT_KICKED");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
      this.e = 1;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    int j = getIntent().getIntExtra("serviceType", -1);
    azqs.b(this.app, "dc00898", "", "", "0X80097EA", "0X80097EA", 0, 0, j + "", "" + this.jdField_a_of_type_Int, getIntent().getIntExtra("srcAppId", 0) + "", "");
    b("0X800A85F");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    if (TextUtils.isEmpty(a())) {
      axpz.a().a();
    }
    if (this.jdField_a_of_type_Asxl != null) {
      this.jdField_a_of_type_Asxl.c();
    }
    if (this.e == 1)
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.e = 0;
    }
    long l;
    if (!this.jdField_a_of_type_Boolean)
    {
      l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      if (!"setFaceData".equals(this.jdField_b_of_type_JavaLangString)) {
        break label224;
      }
      azqs.b(null, "dc00898", "", "", "0X800A862", "0X800A862", 0, 0, String.valueOf(l), "1", "", "");
    }
    while ((this.jdField_b_of_type_JavaUtilMap != null) && (!this.jdField_b_of_type_JavaUtilMap.isEmpty()))
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        a("0X800A863", String.valueOf(((Integer)this.jdField_b_of_type_JavaUtilMap.get(str)).intValue()), str);
      }
      label224:
      if ("loginVerify".equals(this.jdField_b_of_type_JavaLangString)) {
        azqs.b(null, "dc00898", "", "", "0X800A862", "0X800A862", 0, 0, String.valueOf(l), "2", "", "");
      }
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewIdentifierCameraCaptureView.onPause();
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    YtSDKKitFramework.getInstance().deInit();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    QLog.d("qq_Identification.act", 1, new Object[] { "onResume isScanningFace : ", Boolean.valueOf(this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) });
    if (this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewIdentifierCameraCaptureView.onResume();
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378002).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_Beqm.a(getResources().getColor(2131167140));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewIdentifierCameraCaptureView.setVisibility(0);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 2: 
    default: 
      return false;
    case 3: 
      if ("loginVerify".equals(this.jdField_b_of_type_JavaLangString))
      {
        azqs.a(this.app, "dc00898", "", "", "0X800AD2C", "0X800AD2C", 0, 0, "", "", "", "");
        paramMessage = new Intent();
        paramMessage.setAction("com.tencent.mobileqq.InvitationWebViewPlugin");
        paramMessage.setPackage(MobileQQ.getContext().getPackageName());
        sendBroadcast(paramMessage);
      }
      finish();
      return false;
    case 1: 
      QLog.d("qq_Identification.act", 1, "init time out");
      a(false, 218);
      return false;
    case 4: 
      if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (!this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
        a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilMap);
      }
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(4, this.i);
      return false;
    }
    QLog.d("qq_Identification.act", 1, "MSG_POST_FILE_TIME_OUT");
    b(alud.a(2131710745));
    return false;
  }
  
  public boolean onBackEvent()
  {
    f();
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363909: 
      if (!"setFaceData".equals(this.jdField_b_of_type_JavaLangString))
      {
        QLog.d("qq_Identification.act", 1, "click cancel, method is not METHOD_SETTING_FACE_DATA");
        f();
      }
      b("0X800A860");
      finish();
      return;
    }
    b("0X800A866");
    YtSDKKitFramework.getInstance().deInit();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewIdentifierCameraCaptureView.onResume();
    this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    e();
  }
  
  @TargetApi(24)
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
    if ((paramBoolean) && (Build.VERSION.SDK_INT < 24)) {}
    while (!paramBoolean) {
      return;
    }
    a(206, alud.a(2131710752));
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQIdentiferActivity
 * JD-Core Version:    0.7.0.1
 */