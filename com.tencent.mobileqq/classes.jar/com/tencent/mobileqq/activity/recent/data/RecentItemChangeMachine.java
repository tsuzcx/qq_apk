package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.troop.utils.ChangeMachineManager;
import org.json.JSONException;
import org.json.JSONObject;

public class RecentItemChangeMachine
  extends RecentUserBaseData
{
  boolean c;
  
  public RecentItemChangeMachine(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.jdField_c_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 2;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
    String str;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.msg != null) && ((this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.msg instanceof String)))
    {
      str = (String)this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.msg;
      if (str == null) {}
    }
    try
    {
      this.jdField_c_of_type_Boolean = new JSONObject(str).getBoolean("isRead");
      if (this.jdField_c_of_type_Boolean)
      {
        i = 0;
        this.jdField_c_of_type_Int = i;
        this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.showUpTime;
        paramQQAppInterface = (ChangeMachineManager)paramQQAppInterface.getManager(182);
        if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
        {
          if (!TextUtils.isEmpty(paramQQAppInterface.a)) {
            break label181;
          }
          this.jdField_b_of_type_JavaLangString = paramContext.getResources().getString(2131430848);
        }
        if (!TextUtils.isEmpty(paramQQAppInterface.jdField_b_of_type_JavaLangString)) {
          break label192;
        }
        this.jdField_c_of_type_JavaLangCharSequence = paramContext.getResources().getString(2131430849);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        continue;
        int i = 1;
        continue;
        label181:
        this.jdField_b_of_type_JavaLangString = paramQQAppInterface.a;
      }
      label192:
      this.jdField_c_of_type_JavaLangCharSequence = paramQQAppInterface.jdField_b_of_type_JavaLangString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemChangeMachine
 * JD-Core Version:    0.7.0.1
 */