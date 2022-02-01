package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivityConstants;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.AddFriendHelper;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.helper.StrangerQidianHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class StrangerChatPie$4
  extends QidianBusinessObserver
{
  StrangerChatPie$4(StrangerChatPie paramStrangerChatPie) {}
  
  protected void c(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if (paramBoolean)
    {
      this.a.V.notifyDataSetChanged();
      QQToast.makeText(this.a.f, this.a.aX().getString(2131896247), 0).show(this.a.f.getTitleBarHeight());
      return;
    }
    QQToast.makeText(this.a.f, this.a.aX().getString(2131896246), 0).show(this.a.f.getTitleBarHeight());
  }
  
  protected void d(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if (((this.a.ah.a == 1025) || (this.a.ah.a == 1024)) && (paramBoolean) && (paramHashMap != null) && (this.a.ah != null) && (paramHashMap.containsKey("external")) && (paramHashMap.get("external") != null))
    {
      paramHashMap = (QidianExternalInfo)paramHashMap.get("external");
      if ((this.a.ah.b != null) && (paramHashMap != null) && (this.a.ah.b.equals(paramHashMap.uin)))
      {
        if (this.a.ah.a == 1024) {
          this.a.ah.a = 1025;
        }
        paramHashMap = ((StrangerQidianHelper)StrangerChatPie.a(this.a).a(61)).b();
        if (paramHashMap != null)
        {
          StrangerChatPie.a(this.a, true);
          this.a.I.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          StrangerChatPie.b(this.a).setOnClickListener(null);
          StrangerChatPie.c(this.a).setOnClickListener(null);
          this.a.I.setText(paramHashMap);
          if (ChatActivityConstants.b) {
            this.a.I.setContentDescription(paramHashMap);
          }
          StrangerChatPie.b(this.a, true);
        }
        else
        {
          StrangerChatPie.c(this.a, false);
        }
        ((AddFriendHelper)StrangerChatPie.d(this.a).a(113)).g();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.a.c, 2, "onGetQidianUserDetailInfo not current curFriendUin");
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d(this.a.c, 2, "onGetQidianUserDetailInfo fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie.4
 * JD-Core Version:    0.7.0.1
 */