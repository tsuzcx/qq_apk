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
  private Activity a;
  
  public AVGameShareCreateRoomAction(BaseQQAppInterface paramBaseQQAppInterface, Activity paramActivity)
  {
    super(paramBaseQQAppInterface, paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public AVGameShareCreateRoomAction(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    super(paramBaseQQAppInterface, paramContext);
    this.jdField_a_of_type_AndroidAppActivity = null;
  }
  
  private void g(String paramString)
  {
    Intent localIntent = AVGameShareUtil.a().a(this.jdField_a_of_type_AndroidContentContext);
    if (localIntent == null)
    {
      QLog.e("AVGameShareCreateRoomAction", 1, "doAction error: intent is null");
      return;
    }
    localIntent.putExtra("thridparty_av_game_type_key", "thridparty_av_game_type_create_room");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("gameType");
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
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return;
    }
    int i = 4;
    if (!TextUtils.isEmpty(paramString)) {
      i = Integer.valueOf(paramString).intValue();
    }
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("gameType");
    paramString = (String)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramString = "0";
    }
    localObject = (IAvGameManager)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IAvGameManager.class, "");
    if (localObject != null) {}
    try
    {
      ((IAvGameManager)localObject).createAvGameRoom(this.jdField_a_of_type_AndroidAppActivity, i, this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getCurrentAccountUin(), Integer.parseInt(paramString));
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
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2, 2131690493, 0).a();
    }
  }
  
  public boolean a()
  {
    try
    {
      String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("startFrom");
      localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromType");
      if ("1".equals(str))
      {
        a((String)localObject);
        return true;
      }
      g((String)localObject);
      return true;
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doAction error: ");
      ((StringBuilder)localObject).append(localException.getMessage());
      QLog.e("AVGameShareCreateRoomAction", 1, ((StringBuilder)localObject).toString());
      b_("AVGameShareCreateRoomAction");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.AVGameShareCreateRoomAction
 * JD-Core Version:    0.7.0.1
 */