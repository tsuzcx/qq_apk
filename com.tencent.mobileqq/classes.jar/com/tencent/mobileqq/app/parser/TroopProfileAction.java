package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class TroopProfileAction
  extends JumpAction
{
  private QQAppInterface H;
  
  public TroopProfileAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
    this.H = paramQQAppInterface;
  }
  
  private boolean c()
  {
    Object localObject1 = (String)this.f.get("guin");
    Object localObject2 = (TroopManager)this.H.getManager(QQManagerFactory.TROOP_MANAGER);
    boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
    i = 0;
    if ((!bool) && (((TroopManager)localObject2).Y((String)localObject1)))
    {
      localObject2 = (String)this.f.get("type");
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        QLog.e("TroopProfileAction", 1, "illegal goToTroopProfileApp jumpAction. action type is null");
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("goToTroopProfileApp jumpAction. type[");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append("]");
        QLog.e("TroopProfileAction", 1, localStringBuilder.toString());
      }
      if ("group_file".equals(localObject2))
      {
        TroopUtils.a(this.H, (Activity)this.b, (String)localObject1);
        return true;
      }
      if ("group_album".equals(localObject2)) {
        localObject2 = (String)this.f.get("gname");
      }
    }
    label312:
    try
    {
      j = Integer.parseInt((String)this.f.get("unreadnum"));
      i = j;
    }
    catch (NumberFormatException localNumberFormatException4)
    {
      label203:
      break label203;
    }
    TroopUtils.a(this.H, (Activity)this.b, (String)localObject1, (String)localObject2, i);
    return true;
    if ("group_story".equals(localObject2)) {}
    try
    {
      if (this.f.containsKey("troopStoryMemoriesFrom")) {
        i = Integer.parseInt((String)this.f.get("troopStoryMemoriesFrom"));
      } else {
        i = 8;
      }
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      int m;
      break label312;
    }
    try
    {
      k = Integer.parseInt((String)this.f.get("playVideoFrom"));
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      j = i;
      break label314;
    }
    try
    {
      m = Integer.parseInt((String)this.f.get("lastOpenFrom"));
      j = k;
      k = m;
      m = j;
    }
    catch (NumberFormatException localNumberFormatException3)
    {
      j = i;
      i = k;
      break label316;
    }
    j = 0;
    label314:
    i = 0;
    label316:
    k = 0;
    m = i;
    i = j;
    localObject1 = QQStoryShareGroupProfileActivity.b(this.b, 1, null, (String)localObject1, i, m);
    ((Intent)localObject1).putExtra("extra_last_open_from", k);
    this.b.startActivity((Intent)localObject1);
    return true;
    if ("bulk_send_message".equals(localObject2))
    {
      localObject1 = (String)this.f.get("gc");
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("extra.GROUP_UIN", (String)localObject1);
      ((Bundle)localObject2).putString("selfSet_leftViewText", HardCodeUtil.a(2131898212));
      BulkSendMessageFragment.a((Activity)this.b, (Bundle)localObject2);
      return true;
    }
    return false;
    if (QLog.isColorLevel()) {
      QLog.e("TroopProfileAction", 2, new Object[] { "illegal goToTroopProfileApp jumpAction. troopUin=", localObject1 });
    }
    return false;
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = c();
      return bool;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doAction error: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("TroopProfileAction", 1, localStringBuilder.toString());
      h_("TroopProfileAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.TroopProfileAction
 * JD-Core Version:    0.7.0.1
 */