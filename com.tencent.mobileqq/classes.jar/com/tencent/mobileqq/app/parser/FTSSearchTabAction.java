package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FTSSearchTabAction
  extends JumpActionBase
{
  public FTSSearchTabAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean C()
  {
    int i = 0;
    if (!NetworkUtil.g(BaseApplicationImpl.getApplication()))
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131694460, 1).a();
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("params")) {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("params");
    }
    try
    {
      String str2;
      long[] arrayOfLong;
      for (;;)
      {
        localObject = new JSONObject(new String(Base64Util.decode(str1, 0)));
        str2 = ((JSONObject)localObject).optString("keyword");
        JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray("groupmask");
        arrayOfLong = new long[localJSONArray.length()];
        while (i < localJSONArray.length())
        {
          arrayOfLong[i] = localJSONArray.optLong(i);
          i += 1;
        }
        str1 = "";
      }
      Object localObject = ((JSONObject)localObject).optString("groupname");
      ActiveEntitySearchActivity.a(this.jdField_a_of_type_AndroidContentContext, str2, (String)localObject, arrayOfLong);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("FTSSearchTabActionQ.uniteSearch.", 2, "参数解析成json错误.  params=" + str1);
      }
    }
    return true;
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = C();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("FTSSearchTabAction", 1, "doAction error: " + localException.getMessage());
      a("FTSSearchTabAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.FTSSearchTabAction
 * JD-Core Version:    0.7.0.1
 */