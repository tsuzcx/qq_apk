package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
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
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.identification.IdentificationActivityHelper;
import com.tencent.mobileqq.identification.RequestHelper.IYTFaceView;
import com.tencent.mobileqq.identification.RequestHelper.RequestListener;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppConf;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppWordings;
import com.tencent.mobileqq.jsp.IdentificationApiPlugin;
import com.tencent.mobileqq.richmedia.capture.util.SensorShower;
import com.tencent.mobileqq.richmedia.capture.view.CircleBarView;
import com.tencent.mobileqq.richmedia.capture.view.QIdentifierCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.QIdentifierCaptureView.CaptureParam;
import com.tencent.mobileqq.richmedia.capture.view.QIdentifierCaptureView.OutPreviewCallback;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraAbility;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.IdentificationCircleDrawable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
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
import org.json.JSONException;
import org.json.JSONObject;

@RequiresApi(api=18)
public class QQIdentiferActivity
  extends BaseActivity
  implements Handler.Callback, View.OnClickListener, RequestHelper.IYTFaceView, RequestHelper.RequestListener, QIdentifierCaptureView.OutPreviewCallback
{
  public int a;
  private long jdField_a_of_type_Long;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new QQIdentiferActivity.7(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private IdentificationActivityHelper jdField_a_of_type_ComTencentMobileqqIdentificationIdentificationActivityHelper;
  private CircleBarView jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView;
  private QIdentifierCaptureView jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQIdentifierCaptureView;
  private IdentificationCircleDrawable jdField_a_of_type_ComTencentMobileqqWidgetIdentificationCircleDrawable;
  public YTReflectLayout a;
  private String jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131694349);
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
  private boolean jdField_d_of_type_Boolean;
  private int e;
  private int f = Color.rgb(0, 202, 252);
  private int g = Color.rgb(255, 64, 96);
  private int h = Color.argb(0, 0, 0, 0);
  private int i = 500;
  
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
  
  private QIdentifierCaptureView.CaptureParam a()
  {
    QIdentifierCaptureView.CaptureParam localCaptureParam = new QIdentifierCaptureView.CaptureParam();
    localCaptureParam.b(480);
    localCaptureParam.a(640);
    localCaptureParam.a(false);
    return localCaptureParam;
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
  
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("qq_Identification.act", 1, "parse msg to json error : originMsg is empty");
    }
    for (;;)
    {
      return paramString;
      try
      {
        Object localObject = new JSONObject(paramString);
        String str = ((JSONObject)localObject).optString("errormsg", "");
        localObject = ((JSONObject)localObject).optString("extrainfo", "");
        str = (String)this.jdField_c_of_type_JavaUtilMap.get(str);
        if (TextUtils.isEmpty(str))
        {
          boolean bool = TextUtils.isEmpty((CharSequence)localObject);
          if (!bool) {
            return localObject;
          }
        }
        else
        {
          return str;
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.e("qq_Identification.act", 1, new Object[] { "parse msg to json error : ", localJSONException.getMessage() });
      }
    }
    return paramString;
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
      ReportController.b(null, "dc00898", "", "", paramString1, paramString1, 0, 0, "1", paramString2, paramString3, "");
    }
    while (!"loginVerify".equals(this.jdField_b_of_type_JavaLangString)) {
      return;
    }
    ReportController.a(null, "dc00898", "", "", paramString1, paramString1, 0, 0, "2", paramString2, paramString3, "");
  }
  
  private boolean a()
  {
    if ((Build.VERSION.SDK_INT >= 23) && (checkSelfPermission("android.permission.CAMERA") != 0))
    {
      a(205, HardCodeUtil.a(2131710333));
      finish();
      return false;
    }
    if (!CameraAbility.c())
    {
      a(203, HardCodeUtil.a(2131710331));
      DialogUtil.a(this, 230, HardCodeUtil.a(2131710346), HardCodeUtil.a(2131710339), "", HardCodeUtil.a(2131710327), new QQIdentiferActivity.5(this), null).show();
      return false;
    }
    if (isInMultiWindow())
    {
      a(206, IdentificationApiPlugin.jdField_b_of_type_JavaLangString);
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
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(paramString, "tagIdentificationErrorCode", this.jdField_a_of_type_Boolean, 0L, 0L, localHashMap, "");
      return;
    }
  }
  
  private void b(String paramString)
  {
    a(paramString, "", "");
  }
  
  private void f()
  {
    if ("deleteFace".equals(this.jdField_b_of_type_JavaLangString)) {
      ReportController.b(null, "dc00898", "", "", "0X800AF62", "0X800AF62", 0, 0, "", "", "", "");
    }
    do
    {
      return;
      if ("changeSecureMobile".equals(this.jdField_b_of_type_JavaLangString))
      {
        ReportController.a(null, "dc00898", "", "", "0X800AEC3", "0X800AEC3", 0, 0, "", "", "", "");
        return;
      }
    } while (!"identify".equals(this.jdField_b_of_type_JavaLangString));
    QQIdentiferUtil.a((FaceDetectForThirdPartyManager.AppConf)getIntent().getSerializableExtra("FaceRecognition.AppConf"), "0X800B2BF");
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      a(210, IdentificationApiPlugin.jdField_c_of_type_JavaLangString);
    }
  }
  
  private void h()
  {
    ThreadManagerV2.executeOnFileThread(new QQIdentiferActivity.9(this));
  }
  
  private void i()
  {
    b("0X800A865");
    if ("changeSecureMobile".equals(this.jdField_b_of_type_JavaLangString)) {
      ReportController.b(null, "dc00898", "", "", "0X800AEC5", "0X800AEC5", 0, 0, "", "", "", "");
    }
  }
  
  public void a()
  {
    if (!NetworkUtil.g(this))
    {
      this.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131710325);
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
          this.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131710321);
          setResult(-1, a(null));
        }
        this.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131710329);
        setResult(-1, a(null));
      }
      j = -1;
    }
  }
  
  public void a(ColorMatrixColorFilter paramColorMatrixColorFilter)
  {
    this.jdField_a_of_type_ComTencentYoutuYtagreflectlivecheckUiYTReflectLayout.setColorMatrixColorFilter(paramColorMatrixColorFilter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIdentificationCircleDrawable.a(paramColorMatrixColorFilter);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQIdentifierCaptureView == null) || (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {}
    for (;;)
    {
      return;
      if (paramMap.containsKey("state_stats")) {
        QLog.d("qq_Identification.act", 1, paramMap.get("state_stats").toString());
      }
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
              break label336;
            }
            this.jdField_a_of_type_JavaUtilMap.put("keyStateIdentify", "stateNotPass");
          }
          if ((paramMap.containsKey("process_action")) && ("failed".equals(paramMap.get("process_action"))))
          {
            this.jdField_b_of_type_Boolean = true;
            str1 = (String)paramMap.get("message");
            this.jdField_a_of_type_JavaLangString = a(str1);
            QLog.e("qq_Identification.act", 1, new Object[] { "handleEvent process result failed : ", this.jdField_a_of_type_JavaLangString, " origin msg : ", str1 });
            b(this.jdField_a_of_type_JavaLangString);
            b(-10, this.jdField_a_of_type_JavaLangString);
          }
          if (!paramMap.containsKey("version_tips")) {
            break;
          }
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("qq_Identification.act", 1, "get resource string error : " + localException.getMessage());
          continue;
          label336:
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
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379501).setVisibility(8);
      if (!TextUtils.isEmpty(a()))
      {
        String str = a();
        a(str);
        a(str);
      }
      this.jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqWidgetIdentificationCircleDrawable.a(getResources().getColor(2131167305));
      findViewById(2131364357).post(new QQIdentiferActivity.8(this));
      return;
    }
    a(paramInt, this.jdField_a_of_type_JavaLangString);
    b(HardCodeUtil.a(2131710338));
  }
  
  public void a(byte[] paramArrayOfByte, Camera paramCamera)
  {
    paramCamera = paramCamera.getParameters().getPreviewSize();
    if (!this.jdField_d_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    YtSDKKitFramework.getInstance().updateWithFrameData(paramArrayOfByte, paramCamera.width, paramCamera.height, 1);
  }
  
  public void b()
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379501).setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIdentificationCircleDrawable.a(getResources().getColor(2131167307));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131710328));
    a(HardCodeUtil.a(2131710328));
  }
  
  public void b(CharSequence paramCharSequence)
  {
    int j = 0;
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = HardCodeUtil.a(2131710329);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQIdentifierCaptureView.onPause();
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379501).setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840571);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.a();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.a(getResources().getColor(2131165486));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.b(this.h);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIdentificationCircleDrawable.a(getResources().getColor(2131167307));
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(5);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    h();
    paramCharSequence = findViewById(2131379505);
    if (this.jdField_b_of_type_Boolean) {}
    for (;;)
    {
      paramCharSequence.setVisibility(j);
      a(((CharSequence)localObject).toString());
      i();
      return;
      j = 8;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQIdentifierCaptureView.onPause();
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379501).setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIdentificationCircleDrawable.a(getResources().getColor(2131167307));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131710322));
    findViewById(2131369126).setVisibility(8);
    a(HardCodeUtil.a(2131710322));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.a(this.h);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.b(this.f);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.a(1000);
    h();
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(5, 60000L);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQIdentifierCaptureView.onPause();
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379501).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131710337));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840572);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    findViewById(2131379505).setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.a();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.a(this.f);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.b(this.h);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(5);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    long l;
    if ("loginVerify".equals(this.jdField_b_of_type_JavaLangString))
    {
      ReportController.b(null, "dc00898", "", "", "0X800A31A", "0X800A31A", 0, 0, "", "", "", "");
      l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      if (!"setFaceData".equals(this.jdField_b_of_type_JavaLangString)) {
        break label375;
      }
      ReportController.b(null, "dc00898", "", "", "0X800A861", "0X800A861", 0, 0, String.valueOf(l), "1", "", "");
    }
    label375:
    do
    {
      return;
      if ("setFaceData".equals(this.jdField_b_of_type_JavaLangString))
      {
        ReportController.b(null, "dc00898", "", "", "0X800A31F", "0X800A31F", 0, 0, "", "", "", "");
        break;
      }
      if ("deleteFace".equals(this.jdField_b_of_type_JavaLangString))
      {
        ReportController.b(null, "dc00898", "", "", "0X800AE96", "0X800AE96", 0, 0, "", "", "", "");
        break;
      }
      if (!"changeSecureMobile".equals(this.jdField_b_of_type_JavaLangString)) {
        break;
      }
      ReportController.b(null, "dc00898", "", "", "0X800AEC4", "0X800AEC4", 0, 0, "", "", "", "");
      break;
      if ("loginVerify".equals(this.jdField_b_of_type_JavaLangString))
      {
        ReportController.b(null, "dc00898", "", "", "0X800A861", "0X800A861", 0, 0, String.valueOf(l), "2", "", "");
        return;
      }
    } while (!"identify".equals(this.jdField_b_of_type_JavaLangString));
    QQIdentiferUtil.a((FaceDetectForThirdPartyManager.AppConf)getIntent().getSerializableExtra("FaceRecognition.AppConf"), "0X800B2C0");
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidContentContext = this;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      ImmersiveUtils.clearCoverForStatus(getWindow(), this.isClearCoverLayer);
    }
    getWindow().setFlags(128, 128);
    try
    {
      requestWindowFeature(1);
      ImmersiveUtils.setStatusTextColor(true, getWindow());
      this.mNeedStatusTrans = false;
      super.doOnCreate(paramBundle);
      super.setContentView(2131561279);
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      this.jdField_b_of_type_JavaUtilMap = new HashMap();
      this.jdField_c_of_type_Boolean = a();
      if (!this.jdField_c_of_type_Boolean)
      {
        QLog.e("qq_Identification.act", 1, "preCheck not pass");
        findViewById(16908290).setVisibility(8);
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("qq_Identification.act", 1, new Object[] { "requestWindowFeature error : ", localException.getMessage() });
        b(-11, localException.getMessage());
      }
      paramBundle = getIntent();
      this.jdField_a_of_type_Int = paramBundle.getIntExtra("key_identification_type", 2);
      this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("method");
      if ((paramBundle.getIntExtra("srcAppId", 0) == 101868556) && ("changeSecureMobile".equals(this.jdField_b_of_type_JavaLangString))) {
        this.jdField_b_of_type_JavaLangString = "deleteFace";
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131379467));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131368712));
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQIdentifierCaptureView = ((QIdentifierCaptureView)findViewById(2131368711));
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQIdentifierCaptureView.a(false);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQIdentifierCaptureView.setCaptureParam(a());
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQIdentifierCaptureView.setPreviewCallback(this);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQIdentifierCaptureView.setCaptureListener(new QQIdentiferActivity.2(this));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373579));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379509));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379507));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379468));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364347));
      this.jdField_a_of_type_ComTencentYoutuYtagreflectlivecheckUiYTReflectLayout = ((YTReflectLayout)findViewById(2131382113));
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView = ((CircleBarView)findViewById(2131382112));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131379506));
      this.jdField_a_of_type_AndroidViewView = findViewById(2131381102);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131379508));
      this.jdField_b_of_type_AndroidViewView = findViewById(2131382114);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369590));
      this.jdField_a_of_type_ComTencentMobileqqWidgetIdentificationCircleDrawable = new IdentificationCircleDrawable();
      if (Build.VERSION.SDK_INT <= 15) {
        break label827;
      }
    }
    this.jdField_a_of_type_AndroidViewView.setBackground(this.jdField_a_of_type_ComTencentMobileqqWidgetIdentificationCircleDrawable);
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView.a(getResources().getColor(2131165486));
      paramBundle = findViewById(2131364357);
      paramBundle.setOnClickListener(this);
      paramBundle.post(new QQIdentiferActivity.3(this, paramBundle));
      findViewById(2131379505).setOnClickListener(this);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      this.jdField_a_of_type_ComTencentMobileqqIdentificationIdentificationActivityHelper = new IdentificationActivityHelper(this, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1, this.jdField_c_of_type_Int);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(4);
      b();
      if (TextUtils.isEmpty(a()))
      {
        QLog.d("qq_Identification.act", 1, "getAppWording return empty");
        SensorShower.a().a(getApplicationContext(), new QQIdentiferActivity.4(this));
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
      ReportController.b(this.app, "dc00898", "", "", "0X80097EA", "0X80097EA", 0, 0, j + "", "" + this.jdField_a_of_type_Int, getIntent().getIntExtra("srcAppId", 0) + "", "");
      b("0X800A85F");
      f();
      return true;
      label827:
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqWidgetIdentificationCircleDrawable);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (!this.jdField_c_of_type_Boolean) {}
    label276:
    for (;;)
    {
      return;
      this.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      if (TextUtils.isEmpty(a())) {
        SensorShower.a().a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqIdentificationIdentificationActivityHelper != null) {
        this.jdField_a_of_type_ComTencentMobileqqIdentificationIdentificationActivityHelper.c();
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
          break label232;
        }
        ReportController.b(null, "dc00898", "", "", "0X800A862", "0X800A862", 0, 0, String.valueOf(l), "1", "", "");
      }
      for (;;)
      {
        if ((this.jdField_b_of_type_JavaUtilMap == null) || (this.jdField_b_of_type_JavaUtilMap.isEmpty())) {
          break label276;
        }
        Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          a("0X800A863", String.valueOf(((Integer)this.jdField_b_of_type_JavaUtilMap.get(str)).intValue()), str);
        }
        break;
        label232:
        if ("loginVerify".equals(this.jdField_b_of_type_JavaLangString)) {
          ReportController.b(null, "dc00898", "", "", "0X800A862", "0X800A862", 0, 0, String.valueOf(l), "2", "", "");
        }
      }
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQIdentifierCaptureView.onPause();
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    YtSDKKitFramework.getInstance().deInit();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (!this.jdField_c_of_type_Boolean) {}
    do
    {
      return;
      QLog.d("qq_Identification.act", 1, new Object[] { "onResume isScanningFace : ", Boolean.valueOf(this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) });
    } while (!this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQIdentifierCaptureView.onResume();
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379501).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIdentificationCircleDrawable.a(getResources().getColor(2131167305));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQIdentifierCaptureView.setVisibility(0);
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
        ReportController.a(this.app, "dc00898", "", "", "0X800AD2C", "0X800AD2C", 0, 0, "", "", "", "");
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
    b(HardCodeUtil.a(2131710325));
    return false;
  }
  
  public boolean onBackEvent()
  {
    g();
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!"setFaceData".equals(this.jdField_b_of_type_JavaLangString))
      {
        QLog.d("qq_Identification.act", 1, "click cancel, method is not METHOD_SETTING_FACE_DATA");
        g();
      }
      b("0X800A860");
      finish();
      continue;
      b("0X800A866");
      YtSDKKitFramework.getInstance().deInit();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQIdentifierCaptureView.onResume();
      this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      e();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  @TargetApi(24)
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
    if ((paramBoolean) && (Build.VERSION.SDK_INT < 24)) {}
    while (!paramBoolean) {
      return;
    }
    a(206, HardCodeUtil.a(2131710332));
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQIdentiferActivity
 * JD-Core Version:    0.7.0.1
 */