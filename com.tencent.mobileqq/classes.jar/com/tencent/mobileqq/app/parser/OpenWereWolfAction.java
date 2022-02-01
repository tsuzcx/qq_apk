package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class OpenWereWolfAction
  extends JumpAction
{
  public OpenWereWolfAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    boolean bool = false;
    try
    {
      if ("openInvitationRoom".equals(this.c)) {
        return b();
      }
      if ("enterGameRoom".equals(this.c)) {
        bool = c();
      }
      return bool;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doAction error: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("OpenWereWolfAction", 1, localStringBuilder.toString());
      b_("OpenWereWolfAction");
    }
    return false;
  }
  
  protected boolean b()
  {
    boolean bool = NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getApplication());
    int j = 0;
    if (!bool)
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131694425, 1).a();
      return false;
    }
    Object localObject = (String)this.a.get("invitorId");
    int i = 10;
    try
    {
      k = Integer.parseInt((String)this.a.get("roomNum"));
      i = k;
    }
    catch (Exception localException1)
    {
      int k;
      label66:
      label84:
      long l1;
      break label66;
    }
    try
    {
      k = Integer.parseInt((String)this.a.get("zoneId"));
      j = k;
    }
    catch (Exception localException2)
    {
      break label84;
    }
    l1 = -1L;
    try
    {
      long l2 = Long.parseLong((String)this.a.get("gc"));
      l1 = l2;
    }
    catch (Exception localException3)
    {
      label110:
      Intent localIntent;
      break label110;
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("roomNum", i);
      ((Intent)localObject).putExtra("action", 3);
      ((Intent)localObject).putExtra("zoneId", j);
      ((Intent)localObject).putExtra("gc", l1);
      RouteUtils.a(BaseApplicationImpl.getContext(), (Intent)localObject, "/nearby/gameroom/trans");
      return true;
    }
    localIntent = new Intent();
    localIntent.putExtra("inviteId", (String)localObject);
    localIntent.putExtra("roomNum", i);
    localIntent.putExtra("zoneId", j);
    localIntent.putExtra("action", 2);
    RouteUtils.a(BaseApplicationImpl.getContext(), localIntent, "/nearby/gameroom/trans");
    return true;
  }
  
  protected boolean c()
  {
    boolean bool = NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getApplication());
    int j = 0;
    if (!bool)
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131694425, 1).a();
      return false;
    }
    int i = 10;
    try
    {
      k = Integer.parseInt((String)this.a.get("roomNum"));
      i = k;
    }
    catch (Exception localException1)
    {
      int k;
      label52:
      label70:
      Intent localIntent;
      break label52;
    }
    try
    {
      k = Integer.parseInt((String)this.a.get("zoneId"));
      j = k;
    }
    catch (Exception localException2)
    {
      break label70;
    }
    localIntent = new Intent();
    localIntent.putExtra("roomNum", i);
    localIntent.putExtra("zoneId", j);
    localIntent.putExtra("action", 1);
    RouteUtils.a(BaseApplicationImpl.getContext(), localIntent, "/nearby/gameroom/trans");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.OpenWereWolfAction
 * JD-Core Version:    0.7.0.1
 */