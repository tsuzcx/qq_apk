package com.tencent.mobileqq.activity;

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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.identification.AppConf;
import com.tencent.mobileqq.identification.AppConf.ServiceProtocolSerializable;
import com.tencent.mobileqq.identification.FaceConf;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public class QQIdentiferLegacy
  extends ReportAndroidXFragment
  implements Handler.Callback, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static boolean a;
  private int jdField_a_of_type_Int;
  public Dialog a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new QQIdentiferLegacy.5(this);
  private View jdField_a_of_type_AndroidViewView;
  public Button a;
  public CheckBox a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QIphoneTitleBarActivity jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity;
  private FaceConf jdField_a_of_type_ComTencentMobileqqIdentificationFaceConf;
  private Runnable jdField_a_of_type_JavaLangRunnable = new QQIdentiferLegacy.1(this);
  private String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  public MqqHandler a;
  private boolean b;
  
  public QQIdentiferLegacy()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
  }
  
  private CharSequence a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i = Build.VERSION.SDK_INT;
    int j = 0;
    if (i >= 24) {
      paramString = Html.fromHtml(paramString, 0);
    } else {
      paramString = Html.fromHtml(paramString);
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramString);
    URLSpan[] arrayOfURLSpan = (URLSpan[])localSpannableStringBuilder.getSpans(0, paramString.length(), URLSpan.class);
    int k = arrayOfURLSpan.length;
    i = 0;
    int m;
    int n;
    while (i < k)
    {
      URLSpan localURLSpan = arrayOfURLSpan[i];
      m = localSpannableStringBuilder.getSpanStart(localURLSpan);
      n = localSpannableStringBuilder.getSpanEnd(localURLSpan);
      int i1 = localSpannableStringBuilder.getSpanFlags(localURLSpan);
      QQIdentiferLegacy.4 local4 = new QQIdentiferLegacy.4(this, localURLSpan.getURL());
      localSpannableStringBuilder.removeSpan(localURLSpan);
      localSpannableStringBuilder.setSpan(local4, m, n, i1);
      i += 1;
    }
    paramString = (ForegroundColorSpan[])localSpannableStringBuilder.getSpans(0, paramString.length(), ForegroundColorSpan.class);
    k = paramString.length;
    i = j;
    while (i < k)
    {
      arrayOfURLSpan = paramString[i];
      j = localSpannableStringBuilder.getSpanStart(arrayOfURLSpan);
      m = localSpannableStringBuilder.getSpanEnd(arrayOfURLSpan);
      n = localSpannableStringBuilder.getSpanFlags(arrayOfURLSpan);
      localSpannableStringBuilder.removeSpan(arrayOfURLSpan);
      localSpannableStringBuilder.setSpan(arrayOfURLSpan, j, m, n);
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
    if ("setFaceData".equals(this.jdField_a_of_type_JavaLangString))
    {
      ReportController.b(null, "dc00898", "", "", paramString1, paramString1, 0, 0, "", "", "", "");
      return;
    }
    if ("loginVerify".equals(this.jdField_a_of_type_JavaLangString)) {
      ReportController.a(null, "dc00898", "", "", paramString2, paramString2, 0, 0, "", "", "", "");
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceConf.getPlatformAppId();
    String str1 = this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceConf.getKey();
    String str2 = this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceConf.getMethod();
    String str3 = this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceConf.getUin();
    long l = this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceConf.getNonce();
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
      QIPCClientHelper.getInstance().callServer("IdentificationIpcServer_Model", "action_app_conf", localBundle, new QQIdentiferLegacy.7(this, paramBoolean, str2));
      return;
    }
    b(true);
  }
  
  private void a(boolean paramBoolean)
  {
    this.b = false;
    this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceConf.setAppConf(null);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
    YTAGReflectLiveCheckInterface.getLiveCheckType(getActivity().getApplicationContext(), new QQIdentiferLegacy.6(this, paramBoolean));
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
    if (!paramBoolean) {
      i = 8;
    }
    localView.setVisibility(i);
  }
  
  private void c()
  {
    if (!NetworkUtil.isNetSupport(getActivity()))
    {
      QQToast.a(getActivity(), getString(2131692183), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.getTitleBarHeight());
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, true))
    {
      QLog.e("QQIdentiferLegacy", 1, "onClick is loading");
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity, HardCodeUtil.a(2131710323), 1).b(this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.getTitleBarHeight());
      return;
    }
    AppConf localAppConf = this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceConf.getAppConf();
    if ((this.b) || (localAppConf == null) || (localAppConf.ret == 15))
    {
      a(true);
      if (this.b)
      {
        QLog.e("QQIdentiferLegacy", 1, "onClick is light error");
        return;
      }
      if (localAppConf == null)
      {
        QLog.e("QQIdentiferLegacy", 1, "onClick mAppConf == null");
        return;
      }
      if (localAppConf.ret == 15)
      {
        QLog.e("QQIdentiferLegacy", 1, "onClick appconf.ret is 15, light error");
        return;
      }
    }
    d();
  }
  
  private void d()
  {
    QLog.d("QQIdentiferLegacy", 1, new Object[] { "toNextPage, method is ", this.jdField_a_of_type_JavaLangString });
    if ((!"setFaceData".equals(this.jdField_a_of_type_JavaLangString)) && (!"deleteFace".equals(this.jdField_a_of_type_JavaLangString)))
    {
      localIntent = new Intent();
      localIntent.putExtra("FaceRecognition.AppConf", this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceConf.getAppConf());
      this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.setResult(-1, localIntent);
      this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.finish();
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity, QQIdentiferActivity.class);
    localIntent.putExtra("faceConf", this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceConf);
    startActivityForResult(localIntent, 22);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity == null)
    {
      QLog.e("QQIdentiferLegacy", 1, "dealAppconfResult error : activity is null");
      return;
    }
    if (this.b)
    {
      a("0X800A85A", "0X800A85B");
      a(getString(2131692147));
      return;
    }
    AppConf localAppConf = this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceConf.getAppConf();
    if (localAppConf == null)
    {
      a(HardCodeUtil.a(2131710323));
      return;
    }
    if (localAppConf.ret == 15)
    {
      a("0X800A85A", "0X800A85B");
      a(getString(2131692147));
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceConf.getAppConf();
    if ((localObject != null) && (!((AppConf)localObject).serviceProtocols.isEmpty()))
    {
      localObject = (AppConf.ServiceProtocolSerializable)((AppConf)localObject).serviceProtocols.get(0);
      if ((!TextUtils.isEmpty(((AppConf.ServiceProtocolSerializable)localObject).name)) && (!TextUtils.isEmpty(((AppConf.ServiceProtocolSerializable)localObject).url)))
      {
        localObject = getString(2131699816, new Object[] { ((AppConf.ServiceProtocolSerializable)localObject).url, ((AppConf.ServiceProtocolSerializable)localObject).name });
        QLog.d("QQIdentiferLegacy", 1, new Object[] { "updateProtocolText text=", localObject });
        this.jdField_a_of_type_AndroidWidgetTextView.setText(a((String)localObject));
        return;
      }
      QLog.d("QQIdentiferLegacy", 1, "updateProtocolText sp.name empty or  sp.url empty");
      return;
    }
    QLog.d("QQIdentiferLegacy", 1, "updateProtocolText null == mAppConf || mAppConf.serviceProtocols.isEmpty()");
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null) {
      this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(getActivity(), 2131710321);
    }
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void b()
  {
    Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
    if (localDialog != null) {
      localDialog.cancel();
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
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onActivity requestCode == AuthDevActivity.REQ_IDENTIFICATION, resultCode is : ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("QQIdentiferLegacy", 1, ((StringBuilder)localObject).toString());
      if (paramInt2 == -1)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity;
        if (localObject != null)
        {
          ((QIphoneTitleBarActivity)localObject).setResult(paramInt2, paramIntent);
          this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.finish();
        }
      }
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    QLog.d("QQIdentiferLegacy", 1, "onAttach");
    this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity = ((QIphoneTitleBarActivity)paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceConf = ((FaceConf)this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.getIntent().getSerializableExtra("faceConf"));
    if (this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceConf == null)
    {
      QLog.e("QQIdentiferLegacy", 1, "mFaceConf is null");
      this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.finish();
      return;
    }
    a(false);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.findViewById(2131371845).setEnabled(paramBoolean);
    if (paramBoolean) {
      a("0X800A858", "0X800A859");
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131371845)
    {
      if ((Build.VERSION.SDK_INT >= 23) && (this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.checkSelfPermission("android.permission.CAMERA") != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0) {
        this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.requestPermissions(new QQIdentiferLegacy.2(this), 1, new String[] { "android.permission.CAMERA" });
      } else {
        c();
      }
      if ("loginVerify".equals(this.jdField_a_of_type_JavaLangString)) {
        ReportController.b(null, "dc00898", "", "", "0X800A319", "0X800A319", 0, 0, "", "", "", "");
      } else if ("setFaceData".equals(this.jdField_a_of_type_JavaLangString)) {
        ReportController.b(null, "dc00898", "", "", "0X800A31E", "0X800A31E", 0, 0, "", "", "", "");
      }
    }
    else if ((i == 2131364598) || (i == 2131378481))
    {
      CheckBox localCheckBox = this.jdField_a_of_type_AndroidWidgetCheckBox;
      localCheckBox.setChecked(true ^ localCheckBox.isChecked());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2131561123, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.setTitle(HardCodeUtil.a(2131710304));
    this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.setLeftViewName(2131690529);
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceConf.getName();
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceConf.getMethod();
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (paramBundle != null))
    {
      this.jdField_a_of_type_JavaLangString = paramBundle.getString("method");
      this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceConf.setMethod(this.jdField_a_of_type_JavaLangString);
      QLog.d("QQIdentiferLegacy", 1, new Object[] { "saveInstanceState is not null, method is ", this.jdField_a_of_type_JavaLangString });
    }
    if ("setFaceData".equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))
    {
      paramLayoutInflater = getString(2131698924);
    }
    else
    {
      paramBundle = getString(2131699813);
      paramLayoutInflater = paramViewGroup;
      if (paramViewGroup == null) {
        paramLayoutInflater = "";
      }
      paramLayoutInflater = String.format(paramBundle, new Object[] { paramLayoutInflater });
    }
    ((TextView)localView.findViewById(2131378480)).setText(paramLayoutInflater);
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131364594));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378481));
    this.jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
    if ("setFaceData".equals(this.jdField_a_of_type_JavaLangString)) {
      i = 2131699815;
    } else {
      i = 2131699814;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(a(getString(i)));
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131371845));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    localView.findViewById(2131378481).setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131364598);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    b(false);
    if ("identify".equals(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 6000L);
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceConf.getServiceType();
    paramLayoutInflater = new StringBuilder();
    paramLayoutInflater.append(i);
    paramLayoutInflater.append("");
    ReportController.b(null, "dc00898", "", "", "0X80097E9", "0X80097E9", 0, 0, paramLayoutInflater.toString(), "", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceConf.getAppId()), "");
    if (this.jdField_a_of_type_Int == 0)
    {
      paramLayoutInflater = new IntentFilter();
      paramLayoutInflater.addAction("tencent.av.v2q.StartVideoChat");
      paramLayoutInflater.addAction("tencent.av.v2q.AvSwitch");
      paramLayoutInflater.addAction("mqq.intent.action.ACCOUNT_KICKED");
      this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramLayoutInflater);
      this.jdField_a_of_type_Int = 1;
    }
    if ("loginVerify".equals(this.jdField_a_of_type_JavaLangString)) {
      ReportController.b(null, "dc00898", "", "", "0X800A318", "0X800A318", 0, 0, "", "", "", "");
    } else if ("setFaceData".equals(this.jdField_a_of_type_JavaLangString)) {
      ReportController.b(null, "dc00898", "", "", "0X800A31D", "0X800A31D", 0, 0, "", "", "", "");
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, localView);
    return localView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQIdentiferLegacy
 * JD-Core Version:    0.7.0.1
 */