package com.tencent.mobileqq.activity.aio.rebuild.input.edittext;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.coreui.input.EditTextUI;
import com.tencent.mobileqq.activity.aio.coreui.input.IEditTextChangeCallback;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.helper.AIOAtHelper;
import com.tencent.mobileqq.activity.aio.helper.QWalletAIOLifeCycleHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.util.URLUtil;

public class AtTextChangeCallback
  implements IEditTextChangeCallback
{
  private void a(AIOContext paramAIOContext)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("troop_uin", paramAIOContext.a().jdField_a_of_type_JavaLangString);
    localIntent.putExtra("param_from", 11);
    localIntent.putExtra("param_is_pop_up_style", true);
    localIntent.setFlags(603979776);
    if (paramAIOContext.a() == 21) {
      localIntent.putExtra("param_troop_send_apollo_msg", true);
    }
    RouteUtils.a(paramAIOContext.a(), localIntent, "/troop/memberlist/TroopMemberList", 6001);
  }
  
  private void c(AIOContext paramAIOContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 == 1) && ((paramCharSequence.charAt(paramInt1) == '@') || (paramCharSequence.charAt(paramInt1) == 65312)) && (!paramAIOContext.e()))
    {
      paramCharSequence = (HotChatManager)paramAIOContext.a().getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      if (paramCharSequence != null) {
        paramCharSequence = paramCharSequence.a(paramAIOContext.a().jdField_a_of_type_JavaLangString);
      } else {
        paramCharSequence = null;
      }
      if (paramCharSequence != null)
      {
        Intent localIntent = new Intent(paramAIOContext.a(), QQBrowserActivity.class);
        localIntent.putExtra("url", URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a("https://nearby.qq.com/hot_chat/member_list.html", "_wv", "3"), "_bid", "2581"), "gc", paramCharSequence.troopUin), "rid", paramCharSequence.uuid), "from", String.valueOf(1)));
        paramCharSequence = new Bundle();
        paramCharSequence.putBoolean("hide_left_button", true);
        localIntent.putExtras(paramCharSequence);
        paramAIOContext.a().startActivity(localIntent);
      }
    }
  }
  
  public void a(AIOContext paramAIOContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0)
    {
      AtTroopMemberSpan[] arrayOfAtTroopMemberSpan = (AtTroopMemberSpan[])paramAIOContext.a().a().a().b().getSpans(paramInt1, paramInt1 + paramInt2, AtTroopMemberSpan.class);
      if ((arrayOfAtTroopMemberSpan != null) && (arrayOfAtTroopMemberSpan.length > 0)) {
        ReportController.b(null, "dc00898", "", "", "0X800A9AC", "0X800A9AC", 0, 0, "", "", "", "");
      }
    }
    if (paramAIOContext.a().jdField_a_of_type_Int == 1) {
      ((AIOAtHelper)paramAIOContext.a(34)).a(paramCharSequence, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public boolean a(AIOContext paramAIOContext, Editable paramEditable)
  {
    return false;
  }
  
  public void b(AIOContext paramAIOContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramAIOContext.a().jdField_a_of_type_Int == 3000)
    {
      DiscussionInfo localDiscussionInfo = ((DiscussionManager)paramAIOContext.a().getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramAIOContext.a().jdField_a_of_type_JavaLangString);
      boolean bool = false;
      if (localDiscussionInfo != null) {
        bool = localDiscussionInfo.isDiscussHrMeeting();
      }
      if ((!bool) && (paramAIOContext.a().jdField_a_of_type_Int == 3000) && (paramAIOContext.a().jdField_a_of_type_JavaLangString != null) && (paramAIOContext.a().jdField_a_of_type_JavaLangString.length() != 0) && (paramInt3 == 1) && ((paramCharSequence.charAt(paramInt1) == '@') || (paramCharSequence.charAt(paramInt1) == 65312)) && (!paramAIOContext.e()) && (!((QWalletAIOLifeCycleHelper)paramAIOContext.a(27)).a)) {
        a(paramAIOContext);
      }
    }
    else if (paramAIOContext.a().jdField_a_of_type_Int == 1043)
    {
      c(paramAIOContext, paramCharSequence, paramInt1, paramInt2, paramInt3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.edittext.AtTextChangeCallback
 * JD-Core Version:    0.7.0.1
 */