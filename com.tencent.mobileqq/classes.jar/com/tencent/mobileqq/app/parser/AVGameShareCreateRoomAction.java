package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.avgame.business.api.IAvGameManager;
import com.tencent.avgame.ui.AVGameRoomCenterFragment;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.avgameshare.AVGameShareUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class AVGameShareCreateRoomAction
  extends JumpAction
{
  private Activity H = null;
  
  public AVGameShareCreateRoomAction(BaseQQAppInterface paramBaseQQAppInterface, Activity paramActivity)
  {
    super(paramBaseQQAppInterface, paramActivity);
    this.H = paramActivity;
  }
  
  public AVGameShareCreateRoomAction(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    super(paramBaseQQAppInterface, paramContext);
  }
  
  private void i(String paramString)
  {
    Intent localIntent = AVGameShareUtil.a().a(this.b);
    if (localIntent == null)
    {
      QLog.e("AVGameShareCreateRoomAction", 1, "doAction error: intent is null");
      return;
    }
    localIntent.putExtra("thridparty_av_game_type_key", "thridparty_av_game_type_create_room");
    String str2 = (String)this.f.get("gameType");
    String str1 = str2;
    if ("0".equals(str2)) {
      str1 = String.valueOf(1);
    }
    localIntent.putExtra("avgame_create_game_type_key", Integer.valueOf(str1));
    int i = 4;
    if (!TextUtils.isEmpty(paramString)) {
      i = Integer.valueOf(paramString).intValue();
    }
    localIntent.putExtra("avgame_from_type_key", i);
    this.b.startActivity(localIntent);
  }
  
  public void a(String paramString)
  {
    if (this.H == null) {
      return;
    }
    int i = 4;
    if (!TextUtils.isEmpty(paramString)) {
      i = Integer.valueOf(paramString).intValue();
    }
    Object localObject = (String)this.f.get("gameType");
    paramString = (String)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramString = "0";
    }
    localObject = (IAvGameManager)this.a.getRuntimeService(IAvGameManager.class, "");
    if (localObject != null) {}
    try
    {
      ((IAvGameManager)localObject).createAvGameRoom(this.H, i, this.a.getCurrentAccountUin(), Integer.parseInt(paramString));
      return;
    }
    catch (NumberFormatException paramString)
    {
      label92:
      break label92;
    }
    if (QLog.isColorLevel())
    {
      QLog.d(AVGameRoomCenterFragment.a, 2, " gameType or fromType NumberFormatException");
      return;
      QQToast.makeText(this.H, 2, 2131887404, 0).show();
    }
  }
  
  public boolean a()
  {
    try
    {
      String str = (String)this.f.get("startFrom");
      localObject = (String)this.f.get("fromType");
      if ("1".equals(str))
      {
        a((String)localObject);
        return true;
      }
      i((String)localObject);
      return true;
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doAction error: ");
      ((StringBuilder)localObject).append(localException.getMessage());
      QLog.e("AVGameShareCreateRoomAction", 1, ((StringBuilder)localObject).toString());
      h_("AVGameShareCreateRoomAction");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.AVGameShareCreateRoomAction
 * JD-Core Version:    0.7.0.1
 */