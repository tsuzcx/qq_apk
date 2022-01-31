package com.tencent.mobileqq.activity.contacts.base;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class CardConfigManager
{
  private QQAppInterface a;
  
  public CardConfigManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public CardConfigManager.CardConfigs a()
  {
    boolean bool = true;
    CardConfigManager.CardConfigs localCardConfigs = new CardConfigManager.CardConfigs();
    Object localObject = SharedPreUtils.m(this.a.getApp(), this.a.getCurrentAccountUin());
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CardConfigManager", 2, "getCurrentAccountConfig, cardConfigJsonString is empty");
      }
      return localCardConfigs;
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject);
        int i = ((JSONObject)localObject).getInt("showcard");
        localCardConfigs.b = ((JSONObject)localObject).getInt("cardnumN");
        localCardConfigs.c = ((JSONObject)localObject).getInt("ignorecardM");
        localCardConfigs.d = ((JSONObject)localObject).getInt("showdayX");
        if (i == 1)
        {
          localCardConfigs.jdField_a_of_type_Boolean = bool;
          localCardConfigs.jdField_a_of_type_Int = 1;
          return localCardConfigs;
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.d("CardConfigManager", 2, "parse json failed, error = " + localJSONException.getMessage().toString());
        return localCardConfigs;
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.CardConfigManager
 * JD-Core Version:    0.7.0.1
 */