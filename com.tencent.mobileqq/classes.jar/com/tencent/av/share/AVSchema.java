package com.tencent.av.share;

import actj;
import ajya;
import akhp;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import banb;
import bbdj;
import bbgu;
import bcql;
import bkvi;
import com.tencent.av.ReqGroupVideo.ReqShareBackflowVerify;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import lgy;
import lxx;
import lxy;
import lxz;
import lya;
import lyb;
import lyc;
import lyd;
import lye;
import lyf;
import mqq.os.MqqHandler;
import mqy;

public class AVSchema
  extends PublicBaseFragment
{
  Handler jdField_a_of_type_AndroidOsHandler;
  public bbgu a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  public final String a;
  public lyd a;
  lyf jdField_a_of_type_Lyf = new lyf(this, null);
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  
  public AVSchema()
  {
    this.jdField_a_of_type_Lyd = new lyd();
    this.jdField_a_of_type_Bbgu = null;
    this.jdField_a_of_type_JavaLangString = ("AVSchema." + AudioHelper.b());
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "AVSchema");
  }
  
  static lyd a(Bundle paramBundle)
  {
    lyd locallyd = new lyd();
    locallyd.jdField_a_of_type_JavaLangString = paramBundle.getString("guid");
    return locallyd;
  }
  
  static boolean a(lyd paramlyd1, lyd paramlyd2)
  {
    if (paramlyd1 == null) {}
    while (paramlyd2 == null) {
      return false;
    }
    return TextUtils.equals(paramlyd1.jdField_a_of_type_JavaLangString, paramlyd2.jdField_a_of_type_JavaLangString);
  }
  
  bbgu a()
  {
    a();
    this.jdField_a_of_type_Bbgu = bbdj.a(getActivity(), 230);
    this.jdField_a_of_type_Bbgu.setCancelable(true);
    this.jdField_a_of_type_Bbgu.setOnDismissListener(new lxz(this));
    return this.jdField_a_of_type_Bbgu;
  }
  
  QQAppInterface a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) && ((getActivity().getAppInterface() instanceof QQAppInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppInterface());
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  void a()
  {
    bbgu localbbgu = this.jdField_a_of_type_Bbgu;
    this.jdField_a_of_type_Bbgu = null;
    if (localbbgu != null) {}
    try
    {
      localbbgu.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  void a(long paramLong)
  {
    Object localObject = getArguments();
    AudioHelper.a(this.jdField_a_of_type_JavaLangString + ".request_seq[" + paramLong + "]", (Bundle)localObject);
    localObject = a((Bundle)localObject);
    boolean bool = a(this.jdField_a_of_type_Lyd, (lyd)localObject);
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "request, isSameInfo[" + bool + "], mInfo[" + this.jdField_a_of_type_Lyd + "], seq[" + paramLong + "]");
    if (bool) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_AndroidOsHandler != null) && (this.jdField_a_of_type_JavaLangRunnable == null))
      {
        this.jdField_a_of_type_JavaLangRunnable = new AVSchema.1(this);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
      }
      a(paramLong, this.jdField_a_of_type_Lyd);
      this.jdField_a_of_type_Lyd = ((lyd)localObject);
    } while (this.jdField_a_of_type_Lyd == null);
    b(paramLong, this.jdField_a_of_type_Lyd);
  }
  
  void a(long paramLong, String paramString)
  {
    bbgu localbbgu = a();
    localbbgu.setMessage(paramString);
    a(localbbgu);
    localbbgu.show();
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "handleResult_I_Known, msg[" + paramString + "], seq[" + paramLong + "]");
    new MqqHandler(Looper.getMainLooper()).postDelayed(new AVSchema.4(this, paramLong), 100L);
  }
  
  void a(long paramLong, String paramString1, String paramString2)
  {
    bbgu localbbgu = a();
    localbbgu.setMessage(paramString1);
    b(localbbgu);
    localbbgu.setPositiveButton(ajya.a(2131700895), new lxx(this, paramString2));
    localbbgu.show();
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "handleResult_ROOM_CLOSE, msg[" + paramString1 + "], seq[" + paramLong + "]");
  }
  
  void a(long paramLong, lyd paramlyd)
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "cancelLastRequest, info[" + paramlyd + "], seq[" + paramLong + "]");
  }
  
  void a(bbgu parambbgu)
  {
    parambbgu.setNegativeButton(ajya.a(2131700893), new lya(this));
  }
  
  public void a(String paramString)
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "gotoAIO, groupUin[" + paramString + "], mHadGotoAIO[" + this.jdField_a_of_type_Boolean + "]");
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    Intent localIntent = actj.a(new Intent(BaseApplicationImpl.getApplication(), SplashActivity.class), new int[] { 2 });
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("entrance", 8);
    BaseApplicationImpl.getApplication().startActivity(localIntent);
    this.jdField_a_of_type_Boolean = true;
  }
  
  void a(boolean paramBoolean)
  {
    if (getActivity() == null) {}
    do
    {
      View localView1;
      do
      {
        return;
        localView1 = getActivity().findViewById(2131363292);
      } while (localView1 == null);
      View localView2 = (View)localView1.getParent();
      if (paramBoolean)
      {
        localView1.setVisibility(0);
        localView2.setBackgroundColor(-271725107);
        ((TextView)localView2.findViewById(2131370457)).setText(2131694931);
        return;
      }
      localView1.setVisibility(4);
      localView2.setBackgroundColor(16777216);
    } while ((this.jdField_a_of_type_AndroidOsHandler == null) || (this.jdField_a_of_type_JavaLangRunnable == null));
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_JavaLangRunnable = null;
  }
  
  public boolean a(String paramString, long paramLong)
  {
    if (isDetached())
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, paramString + ", isDetached, seq[" + paramLong + "]");
      return true;
    }
    if (getActivity() == null)
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, paramString + ", !Activity, seq[" + paramLong + "]");
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (getActivity() != null) {
      getActivity().finish();
    }
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "finish", new Throwable("打印调用栈"));
  }
  
  public void b(long paramLong, String paramString)
  {
    if (this.b) {
      return;
    }
    mqy.e();
    boolean bool = AVNotifyCenter.c();
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "joinVideoChat, groupUin[" + paramString + "], isBeInvitingOnDoubleVideo[" + bool + "], seq[" + paramLong + "]");
    if (bool)
    {
      bcql.a(getActivity(), 2131696182, 1).b(getActivity().getResources().getDimensionPixelSize(2131298865));
      return;
    }
    this.b = true;
    Bundle localBundle = new Bundle();
    localBundle.putInt("MultiAVType", 10);
    AudioHelper.b(this.jdField_a_of_type_JavaLangString + ".joinVideoChat");
    ChatActivityUtils.a(a(), a().getApp(), 1, paramString, true, true, new lyc(this, paramLong), localBundle);
  }
  
  void b(long paramLong, String paramString1, String paramString2)
  {
    bbgu localbbgu = a();
    localbbgu.setMessage(paramString1);
    b(localbbgu);
    localbbgu.setPositiveButton(ajya.a(2131700896), new lxy(this, paramString2));
    localbbgu.show();
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "handleResult_NEED_ADMIN_CONFIRM, msg[" + paramString1 + "], seq[" + paramLong + "]");
  }
  
  void b(long paramLong, lyd paramlyd)
  {
    ReqGroupVideo.ReqShareBackflowVerify localReqShareBackflowVerify = new ReqGroupVideo.ReqShareBackflowVerify();
    localReqShareBackflowVerify.uint64_uin.set(a().getLongAccountUin());
    localReqShareBackflowVerify.bytes_crypt_room_info.set(ByteStringMicro.copyFromUtf8(paramlyd.jdField_a_of_type_JavaLangString));
    lye locallye = new lye(this, paramlyd);
    lgy.a(paramLong, a(), "QQRTCSvc.group_video_share_backflow_verify", localReqShareBackflowVerify, locallye);
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "realyRequest, info[" + paramlyd + "], seq[" + paramLong + "]");
  }
  
  void b(bbgu parambbgu)
  {
    parambbgu.setNegativeButton(ajya.a(2131700892), new lyb(this));
  }
  
  public void b(String paramString)
  {
    paramString = TroopInfoActivity.a(paramString, 14);
    banb.a(getActivity(), paramString, 2);
  }
  
  void c(String paramString)
  {
    this.jdField_a_of_type_Lyf.jdField_a_of_type_JavaLangString = paramString;
    akhp localakhp = (akhp)a().a(20);
    localakhp.b(paramString, false);
    localakhp.b();
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    long l = AudioHelper.b();
    AudioHelper.a(this.jdField_a_of_type_JavaLangString + ".onActivityCreated_seq[" + l + "]", paramBundle);
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onActivityCreated, seq[" + l + "]");
    a(l);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onAttach, activity[" + paramActivity + "]");
    bkvi.a(paramActivity);
    a().addObserver(this.jdField_a_of_type_Lyf);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561031, paramViewGroup, false);
    paramLayoutInflater.getLayoutParams().height = -1;
    int i = bkvi.b(getActivity());
    paramViewGroup = paramLayoutInflater.findViewById(2131363292);
    ((FrameLayout.LayoutParams)paramViewGroup.getLayoutParams()).topMargin = i;
    paramViewGroup.setVisibility(4);
    ((View)paramViewGroup.getParent()).setBackgroundColor(16777216);
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onCreateView, view[" + paramLayoutInflater + "], status_bar_height[" + i + "]");
    return paramLayoutInflater;
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (QLog.isDevelopLevel()) {}
    for (Throwable localThrowable = new Throwable("打印调用栈");; localThrowable = null)
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onDetach", localThrowable);
      this.jdField_a_of_type_Lyf.jdField_a_of_type_JavaLangString = "";
      a().removeObserver(this.jdField_a_of_type_Lyf);
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        if (this.jdField_a_of_type_JavaLangRunnable != null)
        {
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
          this.jdField_a_of_type_JavaLangRunnable = null;
        }
        this.jdField_a_of_type_AndroidOsHandler = null;
      }
      a();
      return;
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    long l = AudioHelper.b();
    AudioHelper.a(this.jdField_a_of_type_JavaLangString + ".onNewIntent_seq[" + l + "]", paramIntent);
    a(l);
  }
  
  public void onPause()
  {
    super.onPause();
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onPause");
  }
  
  public void onResume()
  {
    super.onResume();
    long l = AudioHelper.b();
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onResume, seq[" + l + "], mQQCustomDialog[" + this.jdField_a_of_type_Bbgu + "]");
    a(l);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onViewCreated, view[" + paramView + "]");
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onWindowFocusChanged, hasFocus[" + paramBoolean + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.share.AVSchema
 * JD-Core Version:    0.7.0.1
 */