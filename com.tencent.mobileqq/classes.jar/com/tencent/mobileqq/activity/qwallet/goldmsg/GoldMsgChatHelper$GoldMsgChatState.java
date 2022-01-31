package com.tencent.mobileqq.activity.qwallet.goldmsg;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.GoldConfigObserver;
import com.tencent.mobileqq.activity.qwallet.PriceSettingDialog.PriceTextWater;
import com.tencent.mobileqq.activity.qwallet.QWalletSetting;
import mqq.app.AppRuntime;

public class GoldMsgChatHelper$GoldMsgChatState
{
  public long a;
  public boolean a;
  public long b = 1L;
  public long c = 3L;
  
  public GoldMsgChatHelper$GoldMsgChatState(String paramString, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_Long = 1L;
    this.jdField_a_of_type_Boolean = true;
    if ((paramSessionInfo.jdField_a_of_type_Int == 1) || (paramSessionInfo.jdField_a_of_type_Int == 3000))
    {
      this.b = QWalletSetting.a(paramString, "goldmsg_setmoney_" + paramSessionInfo.jdField_a_of_type_Int + "_" + paramSessionInfo.jdField_a_of_type_JavaLangString, 3L);
      this.c = QWalletSetting.a(paramString, "goldmsg_setreceivecount_" + paramSessionInfo.jdField_a_of_type_Int + "_" + paramSessionInfo.jdField_a_of_type_JavaLangString, 3L);
      return;
    }
    this.b = QWalletSetting.a(paramString, "goldmsg_setmoney_" + paramSessionInfo.jdField_a_of_type_JavaLangString, 3L);
    this.jdField_a_of_type_Long = QWalletSetting.a(paramString, "goldmsg_setmoneyfrom_" + paramSessionInfo.jdField_a_of_type_JavaLangString, 1L);
  }
  
  public TextWatcher a(Context paramContext, int paramInt)
  {
    Object localObject = paramContext.getResources();
    if (paramInt == 0) {}
    for (localObject = ((Resources)localObject).getString(2131432302);; localObject = ((Resources)localObject).getString(2131432328)) {
      return new PriceSettingDialog.PriceTextWater(paramContext, 1L, 9223372036854775807L, (String)localObject, null);
    }
  }
  
  public void a(String paramString, SessionInfo paramSessionInfo, long paramLong, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramSessionInfo == null) || (paramLong <= 0L)) {
      return;
    }
    a(paramString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong, paramInt);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong, int paramInt2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramLong <= 0L)) {
      break label21;
    }
    label21:
    while (((paramInt1 == 1) || (paramInt1 == 3000)) && ((paramInt2 <= 0) || (!GoldMsgChatHelper.a(paramInt1)))) {
      return;
    }
    this.b = paramLong;
    this.c = paramInt2;
    if ((paramInt1 == 1) || (paramInt1 == 3000))
    {
      QWalletSetting.a(paramString1, "goldmsg_setmoney_" + paramInt1 + "_" + paramString2, paramLong);
      QWalletSetting.a(paramString1, "goldmsg_setreceivecount_" + paramInt1 + "_" + paramString2, paramInt2);
    }
    for (;;)
    {
      paramString1 = new Bundle();
      paramString1.putString("goldmsg_frienduin", paramString2);
      paramString1.putLong("goldmsg_min_value_", paramLong);
      paramString2 = BaseApplicationImpl.getApplication().getRuntime();
      if (paramString2 == null) {
        break;
      }
      paramString2.notifyObservers(GoldConfigObserver.class, 8, true, paramString1);
      return;
      QWalletSetting.a(paramString1, "goldmsg_setmoney_" + paramString2, paramLong);
    }
  }
  
  public TextWatcher b(Context paramContext, int paramInt)
  {
    Object localObject = paramContext.getResources();
    if ((paramInt == 1) || (paramInt == 3000)) {}
    for (localObject = ((Resources)localObject).getString(2131432330);; localObject = null) {
      return new PriceSettingDialog.PriceTextWater(paramContext, 1L, 9223372036854775807L, (String)localObject, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper.GoldMsgChatState
 * JD-Core Version:    0.7.0.1
 */