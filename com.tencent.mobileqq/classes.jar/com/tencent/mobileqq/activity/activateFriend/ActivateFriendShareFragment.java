package com.tencent.mobileqq.activity.activateFriend;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardOptionBuilder;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemAvatar;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.utils.ContactUtils;

public class ActivateFriendShareFragment
  extends PublicBaseFragment
{
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  
  private Intent a()
  {
    Intent localIntent = new Intent();
    Object localObject = this.c;
    localObject = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(97).a(HardCodeUtil.a(2131699848) + this.b).a("web", (String)localObject, (String)localObject, (String)localObject, (String)localObject).a();
    AbsStructMsgItem localAbsStructMsgItem = StructMsgElementFactory.a(27);
    localAbsStructMsgItem.o = 1;
    localAbsStructMsgItem.a(new StructMsgItemTitle(this.b));
    localAbsStructMsgItem.a(new StructMsgItemSummary(String.valueOf(this.jdField_a_of_type_Long)));
    localAbsStructMsgItem.a(new StructMsgItemAvatar(1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), ""));
    localAbsStructMsgItem.a(new StructMsgItemAvatar(1, this.jdField_a_of_type_JavaLangString, ""));
    ((AbsShareMsg)localObject).addItem(localAbsStructMsgItem);
    ((AbsShareMsg)localObject).mCompatibleText = HardCodeUtil.a(2131699847);
    localIntent.putExtra("stuctmsg_bytes", ((AbsShareMsg)localObject).getBytes());
    localIntent.putExtra("forward_type", -3);
    localIntent.putExtra("uin", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("emoInputType", 2);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007AD9", "0X8007AD9", 1, 0, "", "", "", "");
    return localIntent;
  }
  
  private void a()
  {
    ForwardBaseOption localForwardBaseOption = ForwardOptionBuilder.a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity);
    localForwardBaseOption.d();
    Bundle localBundle = new Bundle();
    localBundle.putInt("uintype", 0);
    localBundle.putString("uin", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("uinname", ContactUtils.m(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString));
    localForwardBaseOption.a(ForwardAbility.ForwardAbilityType.a.intValue(), localBundle);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    paramBundle = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("friend_uin");
    this.b = paramBundle.getStringExtra("content");
    this.jdField_a_of_type_Long = paramBundle.getLongExtra("timestamp", System.currentTimeMillis());
    this.c = paramBundle.getStringExtra("jumpUrl");
    a();
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = getActivity();
    if ((getActivity().getAppInterface() instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppInterface());
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriendShareFragment", 0, "onWindowFocusChanged: isFocused=" + paramBoolean);
    }
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateFriendShareFragment
 * JD-Core Version:    0.7.0.1
 */