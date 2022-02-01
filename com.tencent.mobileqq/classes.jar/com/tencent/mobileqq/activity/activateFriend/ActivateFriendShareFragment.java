package com.tencent.mobileqq.activity.activateFriend;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import anzj;
import auxr;
import auxu;
import avad;
import bdll;
import bdoi;
import bdom;
import bdov;
import bdqh;
import bdtj;
import bhlg;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;

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
    localObject = new bdoi(StructMsgForGeneralShare.class).c(97).a(anzj.a(2131698684) + this.b).a("web", (String)localObject, (String)localObject, (String)localObject, (String)localObject).a();
    bdom localbdom = bdov.a(27);
    localbdom.o = 1;
    localbdom.a(new StructMsgItemTitle(this.b));
    localbdom.a(new bdtj(String.valueOf(this.jdField_a_of_type_Long)));
    localbdom.a(new bdqh(1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), ""));
    localbdom.a(new bdqh(1, this.jdField_a_of_type_JavaLangString, ""));
    ((AbsShareMsg)localObject).addItem(localbdom);
    ((AbsShareMsg)localObject).mCompatibleText = anzj.a(2131698683);
    localIntent.putExtra("stuctmsg_bytes", ((AbsShareMsg)localObject).getBytes());
    localIntent.putExtra("forward_type", -3);
    localIntent.putExtra("uin", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("emoInputType", 2);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007AD9", "0X8007AD9", 1, 0, "", "", "", "");
    return localIntent;
  }
  
  private void a()
  {
    auxu localauxu = avad.a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity);
    localauxu.c();
    Bundle localBundle = new Bundle();
    localBundle.putInt("uintype", 0);
    localBundle.putString("uin", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("uinname", bhlg.m(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString));
    localauxu.a(auxr.a.intValue(), localBundle);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateFriendShareFragment
 * JD-Core Version:    0.7.0.1
 */