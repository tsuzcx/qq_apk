package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

class TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$10
  implements Runnable
{
  TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$10(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment, String paramString) {}
  
  public void run()
  {
    if (this.this$0.getAppRuntime() == null) {
      return;
    }
    Object localObject1 = new JSONObject();
    try
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("saveTempPadFromQQ: prvurl ");
        ((StringBuilder)localObject2).append(this.a);
        QLog.e("WebLog_WebViewFragment", 2, ((StringBuilder)localObject2).toString());
      }
      ((JSONObject)localObject1).put("prvurl", this.a);
      Object localObject2 = String.format("https://%s.docs.qq.com/preview/imp/save_to_mylist", new Object[] { this.this$0.getAppRuntime().getCurrentAccountUin() });
      localObject1 = ((ITeamWorkHttpUtils)QRoute.api(ITeamWorkHttpUtils.class)).sendHttpsPost((JSONObject)localObject1, this.this$0.getAppRuntime().getCurrentAccountUin(), (String)localObject2, "docs.qq.com");
      this.this$0.c((String)localObject1);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.10
 * JD-Core Version:    0.7.0.1
 */