package com.tencent.mobileqq.activity.activateFriend;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardOptionBuilder;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
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
  QQAppInterface a;
  private String b;
  private String c;
  private long d;
  private String e;
  private Activity f;
  
  private void a()
  {
    ForwardBaseOption localForwardBaseOption = ForwardOptionBuilder.a(b(), this.a, this.f);
    localForwardBaseOption.m();
    Bundle localBundle = new Bundle();
    localBundle.putInt("uintype", 0);
    localBundle.putString("uin", this.b);
    localBundle.putString("uinname", ContactUtils.g(this.a, this.b));
    localForwardBaseOption.a(ForwardAbility.ForwardAbilityType.b.intValue(), localBundle);
  }
  
  private Intent b()
  {
    Intent localIntent = new Intent();
    Object localObject1 = this.e;
    Object localObject2 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(97);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131898035));
    localStringBuilder.append(this.c);
    localObject1 = ((AbsShareMsg.Builder)localObject2).a(localStringBuilder.toString()).a("web", (String)localObject1, (String)localObject1, (String)localObject1, (String)localObject1).a();
    localObject2 = StructMsgElementFactory.a(27);
    ((AbsStructMsgItem)localObject2).au = 1;
    ((AbsStructMsgItem)localObject2).a(new StructMsgItemTitle(this.c));
    ((AbsStructMsgItem)localObject2).a(new StructMsgItemSummary(String.valueOf(this.d)));
    ((AbsStructMsgItem)localObject2).a(new StructMsgItemAvatar(1, this.a.getCurrentAccountUin(), ""));
    ((AbsStructMsgItem)localObject2).a(new StructMsgItemAvatar(1, this.b, ""));
    ((AbsShareMsg)localObject1).addItem((AbsStructMsgElement)localObject2);
    ((AbsShareMsg)localObject1).mCompatibleText = HardCodeUtil.a(2131898034);
    localIntent.putExtra("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
    localIntent.putExtra("forward_type", -3);
    localIntent.putExtra("uin", this.b);
    localIntent.putExtra("emoInputType", 2);
    ReportController.b(this.a, "dc00898", "", "", "0X8007AD9", "0X8007AD9", 1, 0, "", "", "", "");
    return localIntent;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    paramBundle = this.f.getIntent();
    this.b = paramBundle.getStringExtra("friend_uin");
    this.c = paramBundle.getStringExtra("content");
    this.d = paramBundle.getLongExtra("timestamp", System.currentTimeMillis());
    this.e = paramBundle.getStringExtra("jumpUrl");
    a();
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.f = getBaseActivity();
    if ((getBaseActivity().getAppInterface() instanceof QQAppInterface)) {
      this.a = ((QQAppInterface)getBaseActivity().getAppInterface());
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onWindowFocusChanged: isFocused=");
      localStringBuilder.append(paramBoolean);
      QLog.d("ActivateFriendShareFragment", 0, localStringBuilder.toString());
    }
    if (paramBoolean) {
      this.f.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateFriendShareFragment
 * JD-Core Version:    0.7.0.1
 */