package com.tencent.mobileqq.activity;

import aepp;
import aepq;
import aepr;
import aeps;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import anvx;
import bdla;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppConf;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.ServiceProtocolSerializable;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import cooperation.troop.TroopBaseProxyActivity;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public class QQIdentiferLegacy
  extends ReportV4Fragment
  implements Handler.Callback, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static boolean a;
  private int jdField_a_of_type_Int;
  public Dialog a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new aepq(this);
  private View jdField_a_of_type_AndroidViewView;
  public Button a;
  public CheckBox a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private IphoneTitleBarActivity jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity;
  private FaceDetectForThirdPartyManager.AppConf jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf;
  private Runnable jdField_a_of_type_JavaLangRunnable = new QQIdentiferLegacy.1(this);
  private String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  public MqqHandler a;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  public QQIdentiferLegacy()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
  }
  
  private CharSequence a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (Build.VERSION.SDK_INT >= 24) {}
    SpannableStringBuilder localSpannableStringBuilder;
    URLSpan[] arrayOfURLSpan;
    int k;
    int m;
    int n;
    for (paramString = Html.fromHtml(paramString, 0);; paramString = Html.fromHtml(paramString))
    {
      localSpannableStringBuilder = new SpannableStringBuilder(paramString);
      arrayOfURLSpan = (URLSpan[])localSpannableStringBuilder.getSpans(0, paramString.length(), URLSpan.class);
      j = arrayOfURLSpan.length;
      i = 0;
      while (i < j)
      {
        URLSpan localURLSpan = arrayOfURLSpan[i];
        k = localSpannableStringBuilder.getSpanStart(localURLSpan);
        m = localSpannableStringBuilder.getSpanEnd(localURLSpan);
        n = localSpannableStringBuilder.getSpanFlags(localURLSpan);
        QQIdentiferLegacy.4 local4 = new QQIdentiferLegacy.4(this, localURLSpan.getURL());
        localSpannableStringBuilder.removeSpan(localURLSpan);
        localSpannableStringBuilder.setSpan(local4, k, m, n);
        i += 1;
      }
    }
    paramString = (ForegroundColorSpan[])localSpannableStringBuilder.getSpans(0, paramString.length(), ForegroundColorSpan.class);
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      arrayOfURLSpan = paramString[i];
      k = localSpannableStringBuilder.getSpanStart(arrayOfURLSpan);
      m = localSpannableStringBuilder.getSpanEnd(arrayOfURLSpan);
      n = localSpannableStringBuilder.getSpanFlags(arrayOfURLSpan);
      localSpannableStringBuilder.removeSpan(arrayOfURLSpan);
      localSpannableStringBuilder.setSpan(arrayOfURLSpan, k, m, n);
      i += 1;
    }
    return localSpannableStringBuilder;
  }
  
  private void a(String paramString)
  {
    ThreadManager.getUIHandler().post(new QQIdentiferLegacy.3(this, paramString));
  }
  
  private void a(String paramString1, String paramString2)
  {
    if ("setFaceData".equals(this.jdField_a_of_type_JavaLangString)) {
      bdla.b(null, "dc00898", "", "", paramString1, paramString1, 0, 0, "", "", "", "");
    }
    while (!"loginVerify".equals(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    bdla.a(null, "dc00898", "", "", paramString2, paramString2, 0, 0, "", "", "", "");
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent().getIntExtra("platformAppId", 0);
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent().getStringExtra("key");
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent().getStringExtra("method");
    String str3 = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent().getStringExtra("uin");
    long l = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent().getLongExtra("nonce", -1L);
    if (i != 0)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("srcAppId", i);
      localBundle.putString("key", str1);
      localBundle.putString("lightInfo", paramString);
      localBundle.putString("method", str2);
      localBundle.putString("uin", str3);
      localBundle.putLong("nonce", l);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      QLog.d("QQIdentiferLegacy", 1, "sendPacket start");
      QIPCClientHelper.getInstance().callServer("IdentificationIpcServer_Model", "action_app_conf", localBundle, new aeps(this, paramBoolean, str2));
      return;
    }
    b(true);
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf = null;
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
    YTAGReflectLiveCheckInterface.getLiveCheckType(getActivity().getApplicationContext(), new aepr(this, paramBoolean));
  }
  
  private void b(boolean paramBoolean)
  {
    int i = 0;
    QLog.d("QQIdentiferLegacy", 1, new Object[] { "updateCheckoutLayout visible=", Boolean.valueOf(paramBoolean), ", method=", this.jdField_a_of_type_JavaLangString });
    if (!"identify".equals(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.jdField_a_of_type_MqqOsMqqHandler.post(new QQIdentiferLegacy.9(this, paramBoolean));
      return;
    }
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (paramBoolean) {}
    for (;;)
    {
      localView.setVisibility(i);
      return;
      i = 8;
    }
  }
  
  private void c()
  {
    if (!NetworkUtil.isNetSupport(getActivity()))
    {
      QQToast.a(getActivity(), getString(2131692125), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getTitleBarHeight());
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, true))
    {
      QLog.e("QQIdentiferLegacy", 1, "onClick is loading");
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, anvx.a(2131709827), 1).b(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getTitleBarHeight());
      return;
    }
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf == null) || (this.jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf.ret == 15))
    {
      a(true);
      if (this.jdField_b_of_type_Boolean)
      {
        QLog.e("QQIdentiferLegacy", 1, "onClick is light error");
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf == null)
      {
        QLog.e("QQIdentiferLegacy", 1, "onClick mAppConf == null");
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf.ret == 15)
      {
        QLog.e("QQIdentiferLegacy", 1, "onClick appconf.ret is 15, light error");
        return;
      }
    }
    d();
  }
  
  private void d()
  {
    if (("setFaceData".equals(this.jdField_a_of_type_JavaLangString)) || ("deleteFace".equals(this.jdField_a_of_type_JavaLangString)))
    {
      QLog.d("QQIdentiferLegacy", 1, "method is METHOD_SETTING_FACE_DATA, nextPage is QQIdentiferActivity");
      localIntent1 = getActivity().getIntent();
      Intent localIntent2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, QQIdentiferActivity.class);
      localIntent2.putExtra("platformAppId", this.jdField_b_of_type_Int);
      localIntent2.putExtra("srcAppId", this.jdField_b_of_type_Int);
      localIntent2.putExtra("srcOpenId", localIntent1.getStringExtra("srcOpenId"));
      localIntent2.putExtra("key", localIntent1.getStringExtra("key"));
      localIntent2.putExtra("method", this.jdField_a_of_type_JavaLangString);
      localIntent2.putExtra("serviceType", localIntent1.getIntExtra("serviceType", -1));
      localIntent2.putExtra("FaceRecognition.AppConf", this.jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf);
      localIntent2.putExtra("key_identification_type", this.jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf.mode);
      startActivityForResult(localIntent2, 22);
      return;
    }
    QLog.d("QQIdentiferLegacy", 1, new Object[] { "set result ok, method is ", this.jdField_a_of_type_JavaLangString });
    Intent localIntent1 = new Intent();
    localIntent1.putExtra("FaceRecognition.AppConf", this.jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf);
    this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.setResult(-1, localIntent1);
    this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.finish();
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity == null)
    {
      QLog.e("QQIdentiferLegacy", 1, "dealAppconfResult error : activity is null");
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      a("0X800A85A", "0X800A85B");
      a(getString(2131692089));
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf == null)
    {
      a(anvx.a(2131709831));
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf.ret == 15)
    {
      a("0X800A85A", "0X800A85B");
      a(getString(2131692089));
      return;
    }
    d();
  }
  
  private void f()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.jdField_a_of_type_MqqOsMqqHandler.post(new QQIdentiferLegacy.8(this));
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf == null) || (this.jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf.serviceProtocols.isEmpty()))
    {
      QLog.d("QQIdentiferLegacy", 1, "updateProtocolText null == mAppConf || mAppConf.serviceProtocols.isEmpty()");
      return;
    }
    Object localObject = (FaceDetectForThirdPartyManager.ServiceProtocolSerializable)this.jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf.serviceProtocols.get(0);
    if ((TextUtils.isEmpty(((FaceDetectForThirdPartyManager.ServiceProtocolSerializable)localObject).name)) || (TextUtils.isEmpty(((FaceDetectForThirdPartyManager.ServiceProtocolSerializable)localObject).url)))
    {
      QLog.d("QQIdentiferLegacy", 1, "updateProtocolText sp.name empty or  sp.url empty");
      return;
    }
    localObject = getString(2131699121, new Object[] { ((FaceDetectForThirdPartyManager.ServiceProtocolSerializable)localObject).url, ((FaceDetectForThirdPartyManager.ServiceProtocolSerializable)localObject).name });
    QLog.d("QQIdentiferLegacy", 1, new Object[] { "updateProtocolText text=", localObject });
    this.jdField_a_of_type_AndroidWidgetTextView.setText(a((String)localObject));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = TroopBaseProxyActivity.a(getActivity());
      this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372432).getLayoutParams().width = -2;
      TextView localTextView = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372740);
      localTextView.setSingleLine();
      AIOUtils.dp2px(15.0F, getResources());
      localTextView.setPadding(15, 0, 15, 0);
      localTextView.setText(anvx.a(2131709825));
    }
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.cancel();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      a();
      return true;
    }
    if ((paramMessage.arg1 == 24) && (paramMessage.obj != null) && ((paramMessage.obj instanceof String))) {
      a((String)paramMessage.obj, false);
    }
    b();
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 22)
    {
      QLog.d("QQIdentiferLegacy", 1, "onActivity requestCode == AuthDevActivity.REQ_IDENTIFICATION, resultCode is : " + paramInt2);
      if ((paramInt2 == -1) && (this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.setResult(paramInt2, paramIntent);
        this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.finish();
      }
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    QLog.d("QQIdentiferLegacy", 1, "onAttach");
    this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity = ((IphoneTitleBarActivity)paramActivity);
    a(false);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.findViewById(2131371945).setEnabled(paramBoolean);
    if (paramBoolean) {
      a("0X800A858", "0X800A859");
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    int i;
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    case 2131371945: 
      if (Build.VERSION.SDK_INT >= 23) {
        if (this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.checkSelfPermission("android.permission.CAMERA") == 0) {
          i = 1;
        }
      }
      break;
    }
    for (;;)
    {
      label71:
      if (i == 0) {
        this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.requestPermissions(new aepp(this), 1, new String[] { "android.permission.CAMERA" });
      }
      for (;;)
      {
        if (!"loginVerify".equals(this.jdField_a_of_type_JavaLangString)) {
          break label154;
        }
        bdla.b(null, "dc00898", "", "", "0X800A319", "0X800A319", 0, 0, "", "", "", "");
        break;
        i = 0;
        break label71;
        c();
      }
      label154:
      if (!"setFaceData".equals(this.jdField_a_of_type_JavaLangString)) {
        break;
      }
      bdla.b(null, "dc00898", "", "", "0X800A31E", "0X800A31E", 0, 0, "", "", "", "");
      break;
      CheckBox localCheckBox = this.jdField_a_of_type_AndroidWidgetCheckBox;
      if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {}
      for (;;)
      {
        localCheckBox.setChecked(bool);
        break;
        bool = false;
      }
      i = 1;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2131561179, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.setTitle(anvx.a(2131709807));
    this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.setLeftViewName(2131690499);
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent().getStringExtra("method");
    this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent().getIntExtra("srcAppId", 0);
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent().getStringExtra("name");
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (paramBundle != null))
    {
      this.jdField_a_of_type_JavaLangString = paramBundle.getString("method");
      QLog.d("QQIdentiferLegacy", 1, new Object[] { "saveInstanceState is not null, method is ", this.jdField_a_of_type_JavaLangString });
    }
    int i;
    if ("setFaceData".equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))
    {
      paramLayoutInflater = getString(2131698551);
      ((TextView)localView.findViewById(2131378677)).setText(paramLayoutInflater);
      this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131364593));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378678));
      this.jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
      if (!"setFaceData".equals(this.jdField_a_of_type_JavaLangString)) {
        break label557;
      }
      i = 2131699120;
      label221:
      this.jdField_a_of_type_AndroidWidgetTextView.setText(a(getString(i)));
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131371945));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      localView.findViewById(2131378678).setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131364597);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      b(false);
      if ("identify".equals(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 6000L);
      }
      i = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent().getIntExtra("serviceType", -1);
      bdla.b(null, "dc00898", "", "", "0X80097E9", "0X80097E9", 0, 0, i + "", "", this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent().getIntExtra("srcAppId", 0) + "", "");
      if (this.jdField_a_of_type_Int == 0)
      {
        paramLayoutInflater = new IntentFilter();
        paramLayoutInflater.addAction("tencent.av.v2q.StartVideoChat");
        paramLayoutInflater.addAction("tencent.av.v2q.AvSwitch");
        paramLayoutInflater.addAction("mqq.intent.action.ACCOUNT_KICKED");
        this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramLayoutInflater);
        this.jdField_a_of_type_Int = 1;
      }
      if (!"loginVerify".equals(this.jdField_a_of_type_JavaLangString)) {
        break label565;
      }
      bdla.b(null, "dc00898", "", "", "0X800A318", "0X800A318", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, localView);
      return localView;
      paramBundle = getString(2131699118);
      paramLayoutInflater = paramViewGroup;
      if (paramViewGroup == null) {
        paramLayoutInflater = "";
      }
      paramLayoutInflater = String.format(paramBundle, new Object[] { paramLayoutInflater });
      break;
      label557:
      i = 2131699119;
      break label221;
      label565:
      if ("setFaceData".equals(this.jdField_a_of_type_JavaLangString)) {
        bdla.b(null, "dc00898", "", "", "0X800A31D", "0X800A31D", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_Int = 0;
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    QLog.d("QQIdentiferLegacy", 1, "onSaveInstanceState");
    paramBundle.putString("method", this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQIdentiferLegacy
 * JD-Core Version:    0.7.0.1
 */