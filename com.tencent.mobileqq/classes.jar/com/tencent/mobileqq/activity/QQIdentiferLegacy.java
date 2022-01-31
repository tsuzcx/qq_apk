package com.tencent.mobileqq.activity;

import abum;
import abun;
import abuo;
import abup;
import actn;
import ajyc;
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
import axqw;
import bbev;
import bcpw;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppConf;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import cooperation.troop.TroopBaseProxyActivity;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public class QQIdentiferLegacy
  extends Fragment
  implements Handler.Callback, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static boolean a;
  private int jdField_a_of_type_Int;
  public Dialog a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new abun(this);
  public Button a;
  public CheckBox a;
  private IphoneTitleBarActivity jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity;
  private FaceDetectForThirdPartyManager.AppConf jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf;
  private String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  public MqqHandler a;
  private boolean b;
  
  public QQIdentiferLegacy()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
  }
  
  private CharSequence a(int paramInt)
  {
    Object localObject = getString(paramInt);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    if (Build.VERSION.SDK_INT >= 24) {}
    SpannableStringBuilder localSpannableStringBuilder;
    URLSpan[] arrayOfURLSpan;
    int j;
    int k;
    int m;
    for (localObject = Html.fromHtml((String)localObject, 0);; localObject = Html.fromHtml((String)localObject))
    {
      localSpannableStringBuilder = new SpannableStringBuilder((CharSequence)localObject);
      arrayOfURLSpan = (URLSpan[])localSpannableStringBuilder.getSpans(0, ((Spanned)localObject).length(), URLSpan.class);
      i = arrayOfURLSpan.length;
      paramInt = 0;
      while (paramInt < i)
      {
        URLSpan localURLSpan = arrayOfURLSpan[paramInt];
        j = localSpannableStringBuilder.getSpanStart(localURLSpan);
        k = localSpannableStringBuilder.getSpanEnd(localURLSpan);
        m = localSpannableStringBuilder.getSpanFlags(localURLSpan);
        QQIdentiferLegacy.3 local3 = new QQIdentiferLegacy.3(this, localURLSpan.getURL());
        localSpannableStringBuilder.removeSpan(localURLSpan);
        localSpannableStringBuilder.setSpan(local3, j, k, m);
        paramInt += 1;
      }
    }
    localObject = (ForegroundColorSpan[])localSpannableStringBuilder.getSpans(0, ((Spanned)localObject).length(), ForegroundColorSpan.class);
    int i = localObject.length;
    paramInt = 0;
    while (paramInt < i)
    {
      arrayOfURLSpan = localObject[paramInt];
      j = localSpannableStringBuilder.getSpanStart(arrayOfURLSpan);
      k = localSpannableStringBuilder.getSpanEnd(arrayOfURLSpan);
      m = localSpannableStringBuilder.getSpanFlags(arrayOfURLSpan);
      localSpannableStringBuilder.removeSpan(arrayOfURLSpan);
      localSpannableStringBuilder.setSpan(arrayOfURLSpan, j, k, m);
      paramInt += 1;
    }
    return localSpannableStringBuilder;
  }
  
  private void a(String paramString)
  {
    ThreadManager.getUIHandler().post(new QQIdentiferLegacy.2(this, paramString));
  }
  
  private void a(String paramString1, String paramString2)
  {
    if ("setFaceData".equals(this.jdField_a_of_type_JavaLangString)) {
      axqw.b(null, "dc00898", "", "", paramString1, paramString1, 0, 0, "", "", "", "");
    }
    while (!"loginVerify".equals(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    axqw.a(null, "dc00898", "", "", paramString2, paramString2, 0, 0, "", "", "", "");
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent().getIntExtra("srcAppId", 0);
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
      QIPCClientHelper.getInstance().callServer("IdentificationIpcServer_Model", "action_app_conf", localBundle, new abup(this, paramBoolean));
    }
  }
  
  private void a(boolean paramBoolean)
  {
    this.b = false;
    this.jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf = null;
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
    YTAGReflectLiveCheckInterface.getLiveCheckType(getActivity().getApplicationContext(), new abuo(this, paramBoolean));
  }
  
  private void c()
  {
    if (!bbev.d(getActivity()))
    {
      bcpw.a(getActivity(), getString(2131692321), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getTitleBarHeight());
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, true))
    {
      QLog.e("QQIdentiferLegacy", 1, "onClick is loading");
      bcpw.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, ajyc.a(2131710368), 1).b(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getTitleBarHeight());
      return;
    }
    if ((this.b) || (this.jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf == null) || (this.jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf.ret == 15))
    {
      a(true);
      if (this.b)
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
    if ("setFaceData".equals(this.jdField_a_of_type_JavaLangString))
    {
      QLog.d("QQIdentiferLegacy", 1, "method is METHOD_SETTING_FACE_DATA, nextPage is QQIdentiferActivity");
      localIntent1 = getActivity().getIntent();
      Intent localIntent2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, QQIdentiferActivity.class);
      localIntent2.putExtra("platformAppId", 101810106);
      localIntent2.putExtra("srcAppId", 101810106);
      localIntent2.putExtra("srcOpenId", localIntent1.getStringExtra("srcOpenId"));
      localIntent2.putExtra("key", localIntent1.getStringExtra("key"));
      localIntent2.putExtra("method", "setFaceData");
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
    if (this.b)
    {
      a("0X800A85A", "0X800A85B");
      a(getString(2131692278));
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf == null)
    {
      a(ajyc.a(2131710372));
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf.ret == 15)
    {
      a("0X800A85A", "0X800A85B");
      a(getString(2131692278));
      return;
    }
    d();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = TroopBaseProxyActivity.a(getActivity());
      this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371256).getLayoutParams().width = -2;
      TextView localTextView = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371557);
      localTextView.setSingleLine();
      actn.a(15.0F, getResources());
      localTextView.setPadding(15, 0, 15, 0);
      localTextView.setText(ajyc.a(2131710366));
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
    this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity = ((IphoneTitleBarActivity)paramActivity);
    a(false);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.findViewById(2131370797).setEnabled(paramBoolean);
    if (paramBoolean) {
      a("0X800A858", "0X800A859");
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    int i;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131370797: 
      if (Build.VERSION.SDK_INT >= 23) {
        if (this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.checkSelfPermission("android.permission.CAMERA") == 0) {
          i = 1;
        }
      }
      break;
    }
    for (;;)
    {
      if (i == 0) {
        this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.requestPermissions(new abum(this), 1, new String[] { "android.permission.CAMERA" });
      }
      for (;;)
      {
        if (!"loginVerify".equals(this.jdField_a_of_type_JavaLangString)) {
          break label145;
        }
        axqw.b(null, "dc00898", "", "", "0X800A319", "0X800A319", 0, 0, "", "", "", "");
        return;
        i = 0;
        break;
        c();
      }
      label145:
      if (!"setFaceData".equals(this.jdField_a_of_type_JavaLangString)) {
        break;
      }
      axqw.b(null, "dc00898", "", "", "0X800A31E", "0X800A31E", 0, 0, "", "", "", "");
      return;
      paramView = this.jdField_a_of_type_AndroidWidgetCheckBox;
      if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {}
      for (;;)
      {
        paramView.setChecked(bool);
        return;
        bool = false;
      }
      i = 1;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2131560798, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.setTitle(ajyc.a(2131710348));
    this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.setLeftViewName(2131690331);
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent().getStringExtra("method");
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent().getStringExtra("name");
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (paramBundle != null))
    {
      this.jdField_a_of_type_JavaLangString = paramBundle.getString("method");
      QLog.d("QQIdentiferLegacy", 1, new Object[] { "saveInstanceState is not null, method is ", this.jdField_a_of_type_JavaLangString });
    }
    if ("setFaceData".equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))
    {
      paramLayoutInflater = getString(2131699010);
      ((TextView)localView.findViewById(2131377048)).setText(paramLayoutInflater);
      this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131364178));
      paramLayoutInflater = (TextView)localView.findViewById(2131377049);
      paramLayoutInflater.setMovementMethod(LinkMovementMethod.getInstance());
      if (!"setFaceData".equals(this.jdField_a_of_type_JavaLangString)) {
        break label475;
      }
      paramLayoutInflater.setText(a(2131699622));
      label203:
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131370797));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      localView.findViewById(2131377049).setOnClickListener(this);
      localView.findViewById(2131364182).setOnClickListener(this);
      int i = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent().getIntExtra("serviceType", -1);
      axqw.b(null, "dc00898", "", "", "0X80097E9", "0X80097E9", 0, 0, i + "", "", this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent().getIntExtra("srcAppId", 0) + "", "");
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
        break label489;
      }
      axqw.b(null, "dc00898", "", "", "0X800A318", "0X800A318", 0, 0, "", "", "", "");
    }
    label475:
    label489:
    while (!"setFaceData".equals(this.jdField_a_of_type_JavaLangString))
    {
      return localView;
      paramBundle = getString(2131699620);
      paramLayoutInflater = paramViewGroup;
      if (paramViewGroup == null) {
        paramLayoutInflater = "";
      }
      paramLayoutInflater = String.format(paramBundle, new Object[] { paramLayoutInflater });
      break;
      paramLayoutInflater.setText(a(2131699621));
      break label203;
    }
    axqw.b(null, "dc00898", "", "", "0X800A31D", "0X800A31D", 0, 0, "", "", "", "");
    return localView;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQIdentiferLegacy
 * JD-Core Version:    0.7.0.1
 */