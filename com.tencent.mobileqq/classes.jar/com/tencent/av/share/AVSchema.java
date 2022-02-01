package com.tencent.av.share;

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
import anvx;
import aoep;
import bhdj;
import com.tencent.av.ReqGroupVideo.ReqCheckGroupCanJoin;
import com.tencent.av.ReqGroupVideo.ReqShareBackflowVerify;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import lgk;
import lye;
import lyh;
import lyi;
import lyj;
import lyk;
import lyl;
import lym;
import lyn;
import lyo;
import lyp;
import mqq.os.MqqHandler;
import msc;

public class AVSchema
  extends PublicBaseFragment
{
  Handler jdField_a_of_type_AndroidOsHandler;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public QQCustomDialog a;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  public final String a;
  public lyn a;
  lyp jdField_a_of_type_Lyp = new lyp(this, null);
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  
  public AVSchema()
  {
    this.jdField_a_of_type_Lyn = new lyn();
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.jdField_a_of_type_JavaLangString = ("AVSchema." + AudioHelper.b());
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "AVSchema");
  }
  
  static lyn a(Bundle paramBundle)
  {
    lyn locallyn = new lyn();
    locallyn.jdField_a_of_type_JavaLangString = paramBundle.getString("guid");
    return locallyn;
  }
  
  static boolean a(lyn paramlyn1, lyn paramlyn2)
  {
    if (paramlyn1 == null) {}
    while (paramlyn2 == null) {
      return false;
    }
    return TextUtils.equals(paramlyn1.jdField_a_of_type_JavaLangString, paramlyn2.jdField_a_of_type_JavaLangString);
  }
  
  QQAppInterface a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) && ((getActivity().getAppInterface() instanceof QQAppInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppInterface());
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  QQCustomDialog a()
  {
    a();
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing())) {
      return null;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(localFragmentActivity, 230);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(true);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new lyj(this));
    return this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  }
  
  void a()
  {
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    if (localQQCustomDialog != null) {}
    try
    {
      localQQCustomDialog.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  void a(long paramLong)
  {
    Object localObject = getArguments();
    AudioHelper.a(this.jdField_a_of_type_JavaLangString + ".request_seq[" + paramLong + "]", (Bundle)localObject);
    localObject = a((Bundle)localObject);
    boolean bool = a(this.jdField_a_of_type_Lyn, (lyn)localObject);
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "request, isSameInfo[" + bool + "], mInfo[" + this.jdField_a_of_type_Lyn + "], seq[" + paramLong + "]");
    if (bool) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_AndroidOsHandler != null) && (this.jdField_a_of_type_JavaLangRunnable == null))
      {
        this.jdField_a_of_type_JavaLangRunnable = new AVSchema.1(this);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
      }
      a(paramLong, this.jdField_a_of_type_Lyn);
      this.jdField_a_of_type_Lyn = ((lyn)localObject);
    } while (this.jdField_a_of_type_Lyn == null);
    lye locallye = new lye(this);
    ReqGroupVideo.ReqCheckGroupCanJoin localReqCheckGroupCanJoin = new ReqGroupVideo.ReqCheckGroupCanJoin();
    localReqCheckGroupCanJoin.uint64_uin.set(a().getLongAccountUin());
    localReqCheckGroupCanJoin.bytes_crypt_room_info.set(ByteStringMicro.copyFromUtf8(((lyn)localObject).jdField_a_of_type_JavaLangString));
    lgk.a(paramLong, a(), "QQRTCSvc.share_backflow_check_group_can_join", localReqCheckGroupCanJoin, locallye);
  }
  
  void a(long paramLong, String paramString)
  {
    QQCustomDialog localQQCustomDialog = a();
    if (localQQCustomDialog == null) {
      return;
    }
    localQQCustomDialog.setMessage(paramString);
    a(localQQCustomDialog);
    localQQCustomDialog.show();
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "handleResult_I_Known, msg[" + paramString + "], seq[" + paramLong + "]");
    new MqqHandler(Looper.getMainLooper()).postDelayed(new AVSchema.5(this, paramLong), 100L);
  }
  
  void a(long paramLong, String paramString1, String paramString2)
  {
    QQCustomDialog localQQCustomDialog = a();
    if (localQQCustomDialog == null) {
      return;
    }
    localQQCustomDialog.setMessage(paramString1);
    b(localQQCustomDialog);
    localQQCustomDialog.setPositiveButton(anvx.a(2131700394), new lyh(this, paramString2));
    localQQCustomDialog.show();
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "handleResult_ROOM_CLOSE, msg[" + paramString1 + "], seq[" + paramLong + "]");
  }
  
  void a(long paramLong, lyn paramlyn)
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "cancelLastRequest, info[" + paramlyn + "], seq[" + paramLong + "]");
  }
  
  void a(QQCustomDialog paramQQCustomDialog)
  {
    paramQQCustomDialog.setNegativeButton(anvx.a(2131700392), new lyk(this));
  }
  
  public void a(String paramString)
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "gotoAIO, groupUin[" + paramString + "], mHadGotoAIO[" + this.jdField_a_of_type_Boolean + "]");
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    Intent localIntent = AIOUtils.setOpenAIOIntent(new Intent(BaseApplicationImpl.getApplication(), SplashActivity.class), new int[] { 2 });
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("entrance", 8);
    BaseApplicationImpl.getApplication().startActivity(localIntent);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(boolean paramBoolean)
  {
    if (getActivity() == null) {}
    do
    {
      View localView1;
      do
      {
        return;
        localView1 = getActivity().findViewById(2131363641);
      } while (localView1 == null);
      View localView2 = (View)localView1.getParent();
      if (paramBoolean)
      {
        localView1.setVisibility(0);
        localView2.setBackgroundColor(-271725107);
        ((TextView)localView2.findViewById(2131371603)).setText(2131694477);
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
    msc.e();
    boolean bool = AVNotifyCenter.d();
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "joinVideoChat, groupUin[" + paramString + "], isBeInvitingOnDoubleVideo[" + bool + "], seq[" + paramLong + "]");
    if (bool)
    {
      QQToast.a(getActivity(), 2131695634, 1).b(getActivity().getResources().getDimensionPixelSize(2131299080));
      return;
    }
    this.b = true;
    Bundle localBundle = new Bundle();
    localBundle.putInt("MultiAVType", 10);
    AudioHelper.b(this.jdField_a_of_type_JavaLangString + ".joinVideoChat");
    ChatActivityUtils.a(a(), a().getApp(), 1, paramString, true, true, new lym(this, paramLong), localBundle);
  }
  
  void b(long paramLong, String paramString1, String paramString2)
  {
    QQCustomDialog localQQCustomDialog = a();
    if (localQQCustomDialog == null) {
      return;
    }
    localQQCustomDialog.setMessage(paramString1);
    b(localQQCustomDialog);
    localQQCustomDialog.setPositiveButton(anvx.a(2131700395), new lyi(this, paramString2));
    localQQCustomDialog.show();
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "handleResult_NEED_ADMIN_CONFIRM, msg[" + paramString1 + "], seq[" + paramLong + "]");
  }
  
  public void b(long paramLong, lyn paramlyn)
  {
    ReqGroupVideo.ReqShareBackflowVerify localReqShareBackflowVerify = new ReqGroupVideo.ReqShareBackflowVerify();
    localReqShareBackflowVerify.uint64_uin.set(a().getLongAccountUin());
    localReqShareBackflowVerify.bytes_crypt_room_info.set(ByteStringMicro.copyFromUtf8(paramlyn.jdField_a_of_type_JavaLangString));
    lyo locallyo = new lyo(this, paramlyn);
    lgk.a(paramLong, a(), "QQRTCSvc.group_video_share_backflow_verify", localReqShareBackflowVerify, locallyo);
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "realyRequest, info[" + paramlyn + "], seq[" + paramLong + "]");
  }
  
  void b(QQCustomDialog paramQQCustomDialog)
  {
    paramQQCustomDialog.setNegativeButton(anvx.a(2131700391), new lyl(this));
  }
  
  public void b(String paramString)
  {
    paramString = TroopInfoActivity.a(paramString, 14);
    TroopUtils.openTroopInfoActivity(getActivity(), paramString, 2);
  }
  
  void c(String paramString)
  {
    this.jdField_a_of_type_Lyp.jdField_a_of_type_JavaLangString = paramString;
    aoep localaoep = (aoep)a().getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    localaoep.b(paramString, false);
    localaoep.b();
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
    LiuHaiUtils.a(paramActivity);
    a().addObserver(this.jdField_a_of_type_Lyp);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561446, paramViewGroup, false);
    paramLayoutInflater.getLayoutParams().height = -1;
    int i = LiuHaiUtils.b(getActivity());
    paramViewGroup = paramLayoutInflater.findViewById(2131363641);
    ((FrameLayout.LayoutParams)paramViewGroup.getLayoutParams()).topMargin = i;
    paramViewGroup.setVisibility(4);
    ((View)paramViewGroup.getParent()).setBackgroundColor(16777216);
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onCreateView, view[" + paramLayoutInflater + "], status_bar_height[" + i + "]");
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (QLog.isDevelopLevel()) {}
    for (Throwable localThrowable = new Throwable("打印调用栈");; localThrowable = null)
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onDetach", localThrowable);
      this.jdField_a_of_type_Lyp.jdField_a_of_type_JavaLangString = "";
      a().removeObserver(this.jdField_a_of_type_Lyp);
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
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onResume, seq[" + l + "], mQQCustomDialog[" + this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog + "]");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.share.AVSchema
 * JD-Core Version:    0.7.0.1
 */