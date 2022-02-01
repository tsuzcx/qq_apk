package com.tencent.av.share;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.ReqGroupVideo.ReqCheckGroupCanJoin;
import com.tencent.av.ReqGroupVideo.ReqShareBackflowVerify;
import com.tencent.av.business.handler.MessageHandler;
import com.tencent.av.business.handler.MessageHandler.MsgListener;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.utils.AudioHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.handler.ITroopInfoHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopListHandler;
import com.tencent.mobileqq.troop.utils.TroopInfoUIUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import mqq.os.MqqHandler;

public class AVSchema
  extends PublicBaseFragment
{
  private static String jdField_a_of_type_JavaLangString;
  Handler jdField_a_of_type_AndroidOsHandler;
  AVSchema.Info jdField_a_of_type_ComTencentAvShareAVSchema$Info = new AVSchema.Info();
  AVSchema.MyTroopObserver jdField_a_of_type_ComTencentAvShareAVSchema$MyTroopObserver = new AVSchema.MyTroopObserver(this, null);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  
  public AVSchema()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AVSchema.");
    localStringBuilder.append(AudioHelper.b());
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "AVSchema");
  }
  
  static AVSchema.Info a(Bundle paramBundle)
  {
    AVSchema.Info localInfo = new AVSchema.Info();
    localInfo.jdField_a_of_type_JavaLangString = paramBundle.getString("guid");
    return localInfo;
  }
  
  static boolean a(AVSchema.Info paramInfo1, AVSchema.Info paramInfo2)
  {
    if (paramInfo1 == null) {
      return false;
    }
    if (paramInfo2 == null) {
      return false;
    }
    return TextUtils.equals(paramInfo1.jdField_a_of_type_JavaLangString, paramInfo2.jdField_a_of_type_JavaLangString);
  }
  
  QQAppInterface a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) && ((getBaseActivity().getAppInterface() instanceof QQAppInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getBaseActivity().getAppInterface());
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  QQCustomDialog a()
  {
    a();
    BaseActivity localBaseActivity = getBaseActivity();
    if ((localBaseActivity != null) && (!localBaseActivity.isFinishing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(localBaseActivity, 230);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(true);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new AVSchema.6(this));
      return this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    }
    return null;
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
    Object localObject1 = getArguments();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject2).append(".request_seq[");
    ((StringBuilder)localObject2).append(paramLong);
    ((StringBuilder)localObject2).append("]");
    AudioHelper.a(((StringBuilder)localObject2).toString(), (Bundle)localObject1);
    localObject1 = a((Bundle)localObject1);
    boolean bool = a(this.jdField_a_of_type_ComTencentAvShareAVSchema$Info, (AVSchema.Info)localObject1);
    localObject2 = jdField_a_of_type_JavaLangString;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("request, isSameInfo[");
    ((StringBuilder)localObject3).append(bool);
    ((StringBuilder)localObject3).append("], mInfo[");
    ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentAvShareAVSchema$Info);
    ((StringBuilder)localObject3).append("], seq[");
    ((StringBuilder)localObject3).append(paramLong);
    ((StringBuilder)localObject3).append("]");
    QLog.w((String)localObject2, 1, ((StringBuilder)localObject3).toString());
    if (bool) {
      return;
    }
    if ((this.jdField_a_of_type_AndroidOsHandler != null) && (this.jdField_a_of_type_JavaLangRunnable == null))
    {
      this.jdField_a_of_type_JavaLangRunnable = new AVSchema.1(this);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
    }
    a(paramLong, this.jdField_a_of_type_ComTencentAvShareAVSchema$Info);
    this.jdField_a_of_type_ComTencentAvShareAVSchema$Info = ((AVSchema.Info)localObject1);
    if (this.jdField_a_of_type_ComTencentAvShareAVSchema$Info == null) {
      return;
    }
    localObject2 = new AVSchema.2(this);
    localObject3 = new ReqGroupVideo.ReqCheckGroupCanJoin();
    ((ReqGroupVideo.ReqCheckGroupCanJoin)localObject3).uint64_uin.set(a().getLongAccountUin());
    ((ReqGroupVideo.ReqCheckGroupCanJoin)localObject3).bytes_crypt_room_info.set(ByteStringMicro.copyFromUtf8(((AVSchema.Info)localObject1).jdField_a_of_type_JavaLangString));
    MessageHandler.a(paramLong, a(), "QQRTCSvc.share_backflow_check_group_can_join", (MessageMicro)localObject3, (MessageHandler.MsgListener)localObject2);
  }
  
  void a(long paramLong, AVSchema.Info paramInfo)
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cancelLastRequest, info[");
    localStringBuilder.append(paramInfo);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
  }
  
  void a(long paramLong, String paramString)
  {
    Object localObject = a();
    if (localObject == null) {
      return;
    }
    ((QQCustomDialog)localObject).setMessage(paramString);
    a((QQCustomDialog)localObject);
    ((QQCustomDialog)localObject).show();
    localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleResult_I_Known, msg[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    new MqqHandler(Looper.getMainLooper()).postDelayed(new AVSchema.5(this, paramLong), 100L);
  }
  
  void a(long paramLong, String paramString1, String paramString2)
  {
    Object localObject = a();
    if (localObject == null) {
      return;
    }
    ((QQCustomDialog)localObject).setMessage(paramString1);
    b((QQCustomDialog)localObject);
    ((QQCustomDialog)localObject).setPositiveButton(HardCodeUtil.a(2131701115), new AVSchema.3(this, paramString2));
    ((QQCustomDialog)localObject).show();
    paramString2 = jdField_a_of_type_JavaLangString;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleResult_ROOM_CLOSE, msg[");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("], seq[");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("]");
    QLog.w(paramString2, 1, ((StringBuilder)localObject).toString());
  }
  
  void a(QQCustomDialog paramQQCustomDialog)
  {
    paramQQCustomDialog.setNegativeButton(HardCodeUtil.a(2131701113), new AVSchema.7(this));
  }
  
  void a(String paramString)
  {
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gotoAIO, groupUin[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], mHadGotoAIO[");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    localObject = AIOUtils.a(new Intent(BaseApplicationImpl.getApplication(), SplashActivity.class), new int[] { 2 });
    ((Intent)localObject).putExtra("uin", paramString);
    ((Intent)localObject).putExtra("uintype", 1);
    ((Intent)localObject).putExtra("entrance", 8);
    BaseApplicationImpl.getApplication().startActivity((Intent)localObject);
    this.jdField_a_of_type_Boolean = true;
  }
  
  void a(boolean paramBoolean)
  {
    if (getBaseActivity() == null) {
      return;
    }
    Object localObject1 = getBaseActivity().findViewById(2131363664);
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = (View)((View)localObject1).getParent();
    if (paramBoolean)
    {
      ((View)localObject1).setVisibility(0);
      ((View)localObject2).setBackgroundColor(-271725107);
      ((TextView)((View)localObject2).findViewById(2131371534)).setText(2131694668);
      return;
    }
    ((View)localObject1).setVisibility(4);
    ((View)localObject2).setBackgroundColor(16777216);
    localObject1 = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject1 != null)
    {
      localObject2 = this.jdField_a_of_type_JavaLangRunnable;
      if (localObject2 != null)
      {
        ((Handler)localObject1).removeCallbacks((Runnable)localObject2);
        this.jdField_a_of_type_JavaLangRunnable = null;
      }
    }
  }
  
  boolean a(String paramString, long paramLong)
  {
    String str;
    StringBuilder localStringBuilder;
    if (isDetached())
    {
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(", isDetached, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
      return true;
    }
    if (getBaseActivity() == null)
    {
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(", !Activity, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
      return true;
    }
    return false;
  }
  
  void b()
  {
    if (getBaseActivity() != null) {
      getBaseActivity().finish();
    }
    QLog.w(jdField_a_of_type_JavaLangString, 1, "finish", new Throwable("打印调用栈"));
  }
  
  void b(long paramLong, AVSchema.Info paramInfo)
  {
    Object localObject1 = new ReqGroupVideo.ReqShareBackflowVerify();
    ((ReqGroupVideo.ReqShareBackflowVerify)localObject1).uint64_uin.set(a().getLongAccountUin());
    ((ReqGroupVideo.ReqShareBackflowVerify)localObject1).bytes_crypt_room_info.set(ByteStringMicro.copyFromUtf8(paramInfo.jdField_a_of_type_JavaLangString));
    Object localObject2 = new AVSchema.MyMsgListener(this, paramInfo);
    MessageHandler.a(paramLong, a(), "QQRTCSvc.group_video_share_backflow_verify", (MessageMicro)localObject1, (MessageHandler.MsgListener)localObject2);
    localObject1 = jdField_a_of_type_JavaLangString;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("realyRequest, info[");
    ((StringBuilder)localObject2).append(paramInfo);
    ((StringBuilder)localObject2).append("], seq[");
    ((StringBuilder)localObject2).append(paramLong);
    ((StringBuilder)localObject2).append("]");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
  }
  
  void b(long paramLong, String paramString)
  {
    if (this.b) {
      return;
    }
    ShareChatReport.e();
    boolean bool = AVNotifyCenter.d();
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("joinVideoChat, groupUin[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], isBeInvitingOnDoubleVideo[");
    localStringBuilder.append(bool);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    if (bool)
    {
      QQToast.a(getBaseActivity(), 2131695889, 1).b(getBaseActivity().getResources().getDimensionPixelSize(2131299168));
      return;
    }
    this.b = true;
    localObject = new Bundle();
    ((Bundle)localObject).putInt("MultiAVType", 10);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append(".joinVideoChat");
    AudioHelper.b(localStringBuilder.toString());
    ChatActivityUtils.a(a(), a().getApp(), 1, paramString, true, true, new AVSchema.9(this, paramLong), (Bundle)localObject);
  }
  
  void b(long paramLong, String paramString1, String paramString2)
  {
    Object localObject = a();
    if (localObject == null) {
      return;
    }
    ((QQCustomDialog)localObject).setMessage(paramString1);
    b((QQCustomDialog)localObject);
    ((QQCustomDialog)localObject).setPositiveButton(HardCodeUtil.a(2131701116), new AVSchema.4(this, paramString2));
    ((QQCustomDialog)localObject).show();
    paramString2 = jdField_a_of_type_JavaLangString;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleResult_NEED_ADMIN_CONFIRM, msg[");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("], seq[");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("]");
    QLog.w(paramString2, 1, ((StringBuilder)localObject).toString());
  }
  
  void b(QQCustomDialog paramQQCustomDialog)
  {
    paramQQCustomDialog.setNegativeButton(HardCodeUtil.a(2131701112), new AVSchema.8(this));
  }
  
  void b(String paramString)
  {
    paramString = TroopInfoUIUtil.a(paramString, 14);
    TroopUtils.a(getActivity(), paramString, 2);
  }
  
  void c(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvShareAVSchema$MyTroopObserver.jdField_a_of_type_JavaLangString = paramString;
    ((ITroopInfoHandler)a().getBusinessHandler(BusinessHandlerFactory.TROOP_INFO_HANDLER)).a(paramString, false);
    ((ITroopListHandler)a().getBusinessHandler(BusinessHandlerFactory.TROOP_LIST_HANDLER)).a();
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    long l = AudioHelper.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append(".onActivityCreated_seq[");
    localStringBuilder.append(l);
    localStringBuilder.append("]");
    AudioHelper.a(localStringBuilder.toString(), paramBundle);
    paramBundle = jdField_a_of_type_JavaLangString;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onActivityCreated, seq[");
    localStringBuilder.append(l);
    localStringBuilder.append("]");
    QLog.w(paramBundle, 1, localStringBuilder.toString());
    a(l);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAttach, activity[");
    localStringBuilder.append(paramActivity);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    LiuHaiUtils.a(paramActivity);
    a().addObserver(this.jdField_a_of_type_ComTencentAvShareAVSchema$MyTroopObserver);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561394, paramViewGroup, false);
    paramLayoutInflater.getLayoutParams().height = -1;
    int i = LiuHaiUtils.b(getBaseActivity());
    paramViewGroup = paramLayoutInflater.findViewById(2131363664);
    ((FrameLayout.LayoutParams)paramViewGroup.getLayoutParams()).topMargin = i;
    paramViewGroup.setVisibility(4);
    ((View)paramViewGroup.getParent()).setBackgroundColor(16777216);
    paramViewGroup = jdField_a_of_type_JavaLangString;
    paramBundle = new StringBuilder();
    paramBundle.append("onCreateView, view[");
    paramBundle.append(paramLayoutInflater);
    paramBundle.append("], statusBarHeight[");
    paramBundle.append(i);
    paramBundle.append("]");
    QLog.w(paramViewGroup, 1, paramBundle.toString());
    return paramLayoutInflater;
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (QLog.isDevelopLevel()) {
      localObject = new Throwable("打印调用栈");
    } else {
      localObject = null;
    }
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onDetach", (Throwable)localObject);
    this.jdField_a_of_type_ComTencentAvShareAVSchema$MyTroopObserver.jdField_a_of_type_JavaLangString = "";
    a().removeObserver(this.jdField_a_of_type_ComTencentAvShareAVSchema$MyTroopObserver);
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null)
    {
      Runnable localRunnable = this.jdField_a_of_type_JavaLangRunnable;
      if (localRunnable != null)
      {
        ((Handler)localObject).removeCallbacks(localRunnable);
        this.jdField_a_of_type_JavaLangRunnable = null;
      }
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    a();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    long l = AudioHelper.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append(".onNewIntent_seq[");
    localStringBuilder.append(l);
    localStringBuilder.append("]");
    AudioHelper.a(localStringBuilder.toString(), paramIntent);
    a(l);
  }
  
  public void onPause()
  {
    super.onPause();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onPause");
  }
  
  public void onResume()
  {
    super.onResume();
    long l = AudioHelper.b();
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onResume, seq[");
    localStringBuilder.append(l);
    localStringBuilder.append("], mQQCustomDialog[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    a(l);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramBundle = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onViewCreated, view[");
    localStringBuilder.append(paramView);
    localStringBuilder.append("]");
    QLog.w(paramBundle, 1, localStringBuilder.toString());
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onWindowFocusChanged, hasFocus[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.share.AVSchema
 * JD-Core Version:    0.7.0.1
 */