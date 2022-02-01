package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.avgame.business.api.IAvGameManager;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.avgameshare.AVGameShareUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class AVGameShareJoinRoomAction
  extends JumpAction
{
  public AVGameShareJoinRoomAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramBoolean)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doAction success, roomId: ");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(" shareUin: ");
      ((StringBuilder)localObject).append(paramLong2);
      QLog.d("AVGameShareJoinRoomAction", 1, ((StringBuilder)localObject).toString());
      localObject = AVGameShareUtil.a().a(this.b);
      if (localObject == null)
      {
        QLog.e("AVGameShareJoinRoomAction", 1, "doAction error: intent is null");
        return;
      }
      if (paramLong3 != 3L)
      {
        ((Intent)localObject).putExtra("thridparty_av_game_type_key", "thridparty_av_game_type_join_room");
        ((Intent)localObject).putExtra("thridparty_av_game_share_uin", paramLong2);
        ((Intent)localObject).putExtra("thridparty_av_game_room_id", paramLong1);
        this.b.startActivity((Intent)localObject);
      }
      else
      {
        ((Intent)localObject).putExtra("thridparty_av_game_type_key", "thridparty_av_game_type_create_room");
        ((Intent)localObject).putExtra("avgame_create_game_type_key", Integer.valueOf(String.valueOf(1)));
        ((Intent)localObject).putExtra("avgame_from_type_key", 4);
        this.b.startActivity((Intent)localObject);
      }
    }
    else
    {
      QLog.e("AVGameShareJoinRoomAction", 1, "doAction fail");
    }
    if ((this.b instanceof JumpActivity))
    {
      ((JumpActivity)this.b).finish();
      ((JumpActivity)this.b).overridePendingTransition(0, 0);
    }
  }
  
  public boolean a()
  {
    try
    {
      if (TextUtils.isEmpty((String)this.f.get("key"))) {
        return c();
      }
      boolean bool = b();
      return bool;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doAction error: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("AVGameShareJoinRoomAction", 1, localStringBuilder.toString());
      h_("AVGameShareJoinRoomAction");
    }
    return true;
  }
  
  protected boolean b()
  {
    QLog.d("AVGameShareJoinRoomAction", 1, "doAction getRoomInfoAndJoinRoom");
    String str = (String)this.f.get("key");
    if (TextUtils.isEmpty(str))
    {
      QLog.e("AVGameShareJoinRoomAction", 1, "doAction error: key is empty");
      return true;
    }
    AVGameShareUtil.a().a(this.a, str, new AVGameShareJoinRoomAction.1(this));
    return false;
  }
  
  protected boolean c()
  {
    QLog.d("AVGameShareJoinRoomAction", 1, "doAction directJoinRoom");
    String str1 = (String)this.f.get("uin");
    String str2 = (String)this.f.get("room");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      IAvGameManager localIAvGameManager = (IAvGameManager)this.a.getRuntimeService(IAvGameManager.class, "");
      if (localIAvGameManager != null) {
        ThreadManager.getUIHandler().post(new AVGameShareJoinRoomAction.2(this, localIAvGameManager, str2, str1));
      }
      return true;
    }
    QLog.e("AVGameShareJoinRoomAction", 1, "doAction error: data is empty");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.AVGameShareJoinRoomAction
 * JD-Core Version:    0.7.0.1
 */