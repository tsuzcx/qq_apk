package com.tencent.mobileqq.activity.aio.core;

import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivityConstants;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.helper.QidianHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class FriendChatPie$14
  extends QidianBusinessObserver
{
  FriendChatPie$14(FriendChatPie paramFriendChatPie) {}
  
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
    if ((paramBoolean) && (paramHashMap != null) && (this.a.ah != null) && (paramHashMap.containsKey("external")) && (paramHashMap.get("external") != null))
    {
      paramHashMap = (QidianExternalInfo)paramHashMap.get("external");
      if ((this.a.ah.b != null) && (paramHashMap != null) && (this.a.ah.b.equals(paramHashMap.uin)))
      {
        paramHashMap = ((QidianHelper)this.a.g.a(61)).a();
        if (paramHashMap != null)
        {
          this.a.b(true);
          this.a.I.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          this.a.q.setOnClickListener(null);
          this.a.r.setOnClickListener(null);
          this.a.b(paramHashMap);
          if (ChatActivityConstants.b) {
            this.a.I.setContentDescription(paramHashMap);
          }
          this.a.P = true;
          return;
        }
        this.a.b(false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.14
 * JD-Core Version:    0.7.0.1
 */