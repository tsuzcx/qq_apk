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
  public Button b;
  public CheckBox c;
  public MqqHandler d = new MqqHandler(Looper.getMainLooper(), this);
  public Dialog e;
  private int f;
  private FaceConf g;
  private QIphoneTitleBarActivity h;
  private AtomicBoolean i = new AtomicBoolean(false);
  private AtomicInteger j = new AtomicInteger(0);
  private boolean k;
  private TextView l;
  private View m;
  private String n;
  private Runnable o = new QQIdentiferLegacy.1(this);
  private BroadcastReceiver p = new QQIdentiferLegacy.5(this);
  
  private void a(String paramString)
  {
    ThreadManager.getUIHandler().post(new QQIdentiferLegacy.3(this, paramString));
  }
  
  private void a(String paramString1, String paramString2)
  {
    if ("setFaceData".equals(this.n))
    {
      ReportController.b(null, "dc00898", "", "", paramString1, paramString1, 0, 0, "", "", "", "");
      return;
    }
    if ("loginVerify".equals(this.n)) {
      ReportController.a(null, "dc00898", "", "", paramString2, paramString2, 0, 0, "", "", "", "");
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    int i1 = this.g.getPlatformAppId();
    String str1 = this.g.getKey();
    String str2 = this.g.getMethod();
    String str3 = this.g.getUin();
    long l1 = this.g.getNonce();
    if (i1 != 0)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("srcAppId", i1);
      localBundle.putString("key", str1);
      localBundle.putString("lightInfo", paramString);
      localBundle.putString("method", str2);
      localBundle.putString("uin", str3);
      localBundle.putLong("nonce", l1);
      this.i.set(true);
      QLog.d("QQIdentiferLegacy", 1, "sendPacket start");
      QIPCClientHelper.getInstance().callServer("IdentificationIpcServer_Model", "action_app_conf", localBundle, new QQIdentiferLegacy.7(this, paramBoolean, str2));
      return;
    }
    b(true);
  }
  
  private void a(boolean paramBoolean)
  {
    this.k = false;
    this.g.setAppConf(null);
    this.d.sendEmptyMessage(1);
    YTAGReflectLiveCheckInterface.getLiveCheckType(getActivity().getApplicationContext(), new QQIdentiferLegacy.6(this, paramBoolean));
  }
  
  private CharSequence b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i1 = Build.VERSION.SDK_INT;
    int i2 = 0;
    if (i1 >= 24) {
      paramString = Html.fromHtml(paramString, 0);
    } else {
      paramString = Html.fromHtml(paramString);
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramString);
    URLSpan[] arrayOfURLSpan = (URLSpan[])localSpannableStringBuilder.getSpans(0, paramString.length(), URLSpan.class);
    int i3 = arrayOfURLSpan.length;
    i1 = 0;
    int i4;
    int i5;
    while (i1 < i3)
    {
      URLSpan localURLSpan = arrayOfURLSpan[i1];
      i4 = localSpannableStringBuilder.getSpanStart(localURLSpan);
      i5 = localSpannableStringBuilder.getSpanEnd(localURLSpan);
      int i6 = localSpannableStringBuilder.getSpanFlags(localURLSpan);
      QQIdentiferLegacy.4 local4 = new QQIdentiferLegacy.4(this, localURLSpan.getURL());
      localSpannableStringBuilder.removeSpan(localURLSpan);
      localSpannableStringBuilder.setSpan(local4, i4, i5, i6);
      i1 += 1;
    }
    paramString = (ForegroundColorSpan[])localSpannableStringBuilder.getSpans(0, paramString.length(), ForegroundColorSpan.class);
    i3 = paramString.length;
    i1 = i2;
    while (i1 < i3)
    {
      arrayOfURLSpan = paramString[i1];
      i2 = localSpannableStringBuilder.getSpanStart(arrayOfURLSpan);
      i4 = localSpannableStringBuilder.getSpanEnd(arrayOfURLSpan);
      i5 = localSpannableStringBuilder.getSpanFlags(arrayOfURLSpan);
      localSpannableStringBuilder.removeSpan(arrayOfURLSpan);
      localSpannableStringBuilder.setSpan(arrayOfURLSpan, i2, i4, i5);
      i1 += 1;
    }
    return localSpannableStringBuilder;
  }
  
  private void b(boolean paramBoolean)
  {
    int i1 = 0;
    QLog.d("QQIdentiferLegacy", 1, new Object[] { "updateCheckoutLayout visible=", Boolean.valueOf(paramBoolean), ", method=", this.n });
    if (!"identify".equals(this.n)) {
      return;
    }
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.d.post(new QQIdentiferLegacy.9(this, paramBoolean));
      return;
    }
    View localView = this.m;
    if (!paramBoolean) {
      i1 = 8;
    }
    localView.setVisibility(i1);
  }
  
  private void c()
  {
    if (!NetworkUtil.isNetSupport(getActivity()))
    {
      QQToast.makeText(getActivity(), getString(2131889169), 0).show(this.h.getTitleBarHeight());
      return;
    }
    if (this.i.compareAndSet(true, true))
    {
      QLog.e("QQIdentiferLegacy", 1, "onClick is loading");
      QQToast.makeText(this.h, HardCodeUtil.a(2131908017), 1).show(this.h.getTitleBarHeight());
      return;
    }
    AppConf localAppConf = this.g.getAppConf();
    if ((this.k) || (localAppConf == null) || (localAppConf.ret == 15))
    {
      a(true);
      if (this.k)
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
    QLog.d("QQIdentiferLegacy", 1, new Object[] { "toNextPage, method is ", this.n });
    if ((!"setFaceData".equals(this.n)) && (!"deleteFace".equals(this.n)))
    {
      localIntent = new Intent();
      localIntent.putExtra("FaceRecognition.AppConf", this.g.getAppConf());
      this.h.setResult(-1, localIntent);
      this.h.finish();
      return;
    }
    Intent localIntent = new Intent(this.h, QQIdentiferActivity.class);
    localIntent.putExtra("faceConf", this.g);
    startActivityForResult(localIntent, 22);
  }
  
  private void e()
  {
    if (this.h == null)
    {
      QLog.e("QQIdentiferLegacy", 1, "dealAppconfResult error : activity is null");
      return;
    }
    if (this.k)
    {
      a("0X800A85A", "0X800A85B");
      a(getString(2131889130));
      return;
    }
    AppConf localAppConf = this.g.getAppConf();
    if (localAppConf == null)
    {
      a(HardCodeUtil.a(2131908017));
      return;
    }
    if (localAppConf.ret == 15)
    {
      a("0X800A85A", "0X800A85B");
      a(getString(2131889130));
      return;
    }
    d();
  }
  
  private void f()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.d.post(new QQIdentiferLegacy.8(this));
      return;
    }
    Object localObject = this.g.getAppConf();
    if ((localObject != null) && (!((AppConf)localObject).serviceProtocols.isEmpty()))
    {
      localObject = (AppConf.ServiceProtocolSerializable)((AppConf)localObject).serviceProtocols.get(0);
      if ((!TextUtils.isEmpty(((AppConf.ServiceProtocolSerializable)localObject).name)) && (!TextUtils.isEmpty(((AppConf.ServiceProtocolSerializable)localObject).url)))
      {
        localObject = getString(2131897861, new Object[] { ((AppConf.ServiceProtocolSerializable)localObject).url, ((AppConf.ServiceProtocolSerializable)localObject).name });
        QLog.d("QQIdentiferLegacy", 1, new Object[] { "updateProtocolText text=", localObject });
        this.l.setText(b((String)localObject));
        return;
      }
      QLog.d("QQIdentiferLegacy", 1, "updateProtocolText sp.name empty or  sp.url empty");
      return;
    }
    QLog.d("QQIdentiferLegacy", 1, "updateProtocolText null == mAppConf || mAppConf.serviceProtocols.isEmpty()");
  }
  
  public void a()
  {
    if (this.e == null) {
      this.e = DialogUtil.b(getActivity(), 2131908015);
    }
    this.e.show();
  }
  
  public void b()
  {
    Dialog localDialog = this.e;
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
        localObject = this.h;
        if (localObject != null)
        {
          ((QIphoneTitleBarActivity)localObject).setResult(paramInt2, paramIntent);
          this.h.finish();
        }
      }
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    QLog.d("QQIdentiferLegacy", 1, "onAttach");
    this.h = ((QIphoneTitleBarActivity)paramActivity);
    this.g = ((FaceConf)this.h.getIntent().getSerializableExtra("faceConf"));
    if (this.g == null)
    {
      QLog.e("QQIdentiferLegacy", 1, "mFaceConf is null");
      this.h.finish();
      return;
    }
    a(false);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    a = paramBoolean;
    this.h.findViewById(2131439284).setEnabled(paramBoolean);
    if (paramBoolean) {
      a("0X800A858", "0X800A859");
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131439284)
    {
      if ((Build.VERSION.SDK_INT >= 23) && (this.h.checkSelfPermission("android.permission.CAMERA") != 0)) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      if (i1 == 0) {
        this.h.requestPermissions(new QQIdentiferLegacy.2(this), 1, new String[] { "android.permission.CAMERA" });
      } else {
        c();
      }
      if ("loginVerify".equals(this.n)) {
        ReportController.b(null, "dc00898", "", "", "0X800A319", "0X800A319", 0, 0, "", "", "", "");
      } else if ("setFaceData".equals(this.n)) {
        ReportController.b(null, "dc00898", "", "", "0X800A31E", "0X800A31E", 0, 0, "", "", "", "");
      }
      ReportController.b(null, "dc00898", "", "", "0X800BD78", "0X800BD78", QQIdentiferUtil.a(this.n), 0, "", "", "", "");
    }
    else if ((i1 == 2131430668) || (i1 == 2131447095))
    {
      CheckBox localCheckBox = this.c;
      localCheckBox.setChecked(true ^ localCheckBox.isChecked());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2131627473, paramViewGroup, false);
    this.h.setTitle(HardCodeUtil.a(2131907999));
    this.h.setLeftViewName(2131887440);
    paramViewGroup = this.g.getName();
    this.n = this.g.getMethod();
    if ((TextUtils.isEmpty(this.n)) && (paramBundle != null))
    {
      this.n = paramBundle.getString("method");
      this.g.setMethod(this.n);
      QLog.d("QQIdentiferLegacy", 1, new Object[] { "saveInstanceState is not null, method is ", this.n });
    }
    if ("setFaceData".equalsIgnoreCase(this.n))
    {
      paramLayoutInflater = getString(2131896898);
    }
    else
    {
      paramBundle = getString(2131897858);
      paramLayoutInflater = paramViewGroup;
      if (paramViewGroup == null) {
        paramLayoutInflater = "";
      }
      paramLayoutInflater = String.format(paramBundle, new Object[] { paramLayoutInflater });
    }
    ((TextView)localView.findViewById(2131447094)).setText(paramLayoutInflater);
    this.c = ((CheckBox)localView.findViewById(2131430663));
    this.l = ((TextView)localView.findViewById(2131447095));
    this.l.setMovementMethod(LinkMovementMethod.getInstance());
    if ("setFaceData".equals(this.n)) {
      i1 = 2131897860;
    } else {
      i1 = 2131897859;
    }
    this.l.setText(b(getString(i1)));
    this.c.setOnCheckedChangeListener(this);
    this.b = ((Button)localView.findViewById(2131439284));
    this.b.setOnClickListener(this);
    localView.findViewById(2131447095).setOnClickListener(this);
    this.m = localView.findViewById(2131430668);
    this.m.setOnClickListener(this);
    b(false);
    if ("identify".equals(this.n)) {
      this.d.postDelayed(this.o, 6000L);
    }
    int i1 = this.g.getServiceType();
    int i2 = QQIdentiferUtil.a(this.n);
    paramLayoutInflater = new StringBuilder();
    paramLayoutInflater.append(i1);
    paramLayoutInflater.append("");
    ReportController.b(null, "dc00898", "", "", "0X80097E9", "0X80097E9", i2, 0, paramLayoutInflater.toString(), "", String.valueOf(this.g.getAppId()), "");
    if (this.f == 0)
    {
      paramLayoutInflater = new IntentFilter();
      paramLayoutInflater.addAction("tencent.av.v2q.StartVideoChat");
      paramLayoutInflater.addAction("tencent.av.v2q.AvSwitch");
      paramLayoutInflater.addAction("mqq.intent.action.ACCOUNT_KICKED");
      this.h.registerReceiver(this.p, paramLayoutInflater);
      this.f = 1;
    }
    if ("loginVerify".equals(this.n)) {
      ReportController.b(null, "dc00898", "", "", "0X800A318", "0X800A318", 0, 0, "", "", "", "");
    } else if ("setFaceData".equals(this.n)) {
      ReportController.b(null, "dc00898", "", "", "0X800A31D", "0X800A31D", 0, 0, "", "", "", "");
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, localView);
    return localView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.d.removeCallbacksAndMessages(null);
    if (this.f == 1)
    {
      this.h.unregisterReceiver(this.p);
      this.f = 0;
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    QLog.d("QQIdentiferLegacy", 1, "onSaveInstanceState");
    paramBundle.putString("method", this.n);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQIdentiferLegacy
 * JD-Core Version:    0.7.0.1
 */