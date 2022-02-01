package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FTSSearchTabAction
  extends JumpAction
{
  public FTSSearchTabAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean c()
  {
    boolean bool = NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getApplication());
    int i = 0;
    if (!bool)
    {
      QQToast.makeText(BaseApplicationImpl.getApplication(), 1, 2131892105, 1).show();
      return false;
    }
    String str;
    if (this.f.containsKey("params")) {
      str = (String)this.f.get("params");
    } else {
      str = "";
    }
    try
    {
      Object localObject2 = new JSONObject(new String(Base64Util.decode(str, 0)));
      localObject1 = ((JSONObject)localObject2).optString("keyword");
      JSONArray localJSONArray = ((JSONObject)localObject2).optJSONArray("groupmask");
      long[] arrayOfLong = new long[localJSONArray.length()];
      while (i < localJSONArray.length())
      {
        arrayOfLong[i] = localJSONArray.optLong(i);
        i += 1;
      }
      localObject2 = ((JSONObject)localObject2).optString("groupname");
      ActiveEntitySearchActivity.a(this.b, (String)localObject1, (String)localObject2, arrayOfLong);
      return true;
    }
    catch (JSONException localJSONException)
    {
      Object localObject1;
      label158:
      break label158;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("参数解析成json错误.  params=");
    ((StringBuilder)localObject1).append(str);
    QLog.e("FTSSearchTabActionQ.uniteSearch.", 2, ((StringBuilder)localObject1).toString());
    return true;
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
      QLog.e("FTSSearchTabAction", 1, localStringBuilder.toString());
      h_("FTSSearchTabAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.FTSSearchTabAction
 * JD-Core Version:    0.7.0.1
 */