import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class awxj
  implements View.OnClickListener
{
  awxj(awxi paramawxi) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag(2131376880);
    Object localObject2 = paramView.getTag(2131376881);
    Context localContext;
    Object localObject3;
    if ((localObject1 != null) && ((localObject1 instanceof String)))
    {
      localContext = paramView.getContext();
      localObject1 = (String)localObject1;
      localObject3 = paramView.getTag(2131376854);
      if (!(localObject3 instanceof Integer)) {
        break label500;
      }
    }
    label419:
    label500:
    for (int i = ((Integer)localObject3).intValue();; i = 0)
    {
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject1 = awvv.d(i);
      }
      for (localObject1 = awvv.a((String)localObject2, 3, (String)localObject1);; localObject1 = awvv.b((String)localObject1, i))
      {
        if (QLog.isColorLevel()) {
          QLog.d("NetSearchTemplateNewEntranceView", 2, "open Browser append suffix url = " + (String)localObject1);
        }
        if (localObject1 != null) {
          break;
        }
        QLog.e("NetSearchTemplateNewEntranceView", 2, "NetSearchSubView click jumpurl is null");
        return;
      }
      awso.a(null, 0, i, "0X8009D5F", 0, 0, null, null);
      paramView = (awpa)paramView.getTag(2131379208);
      localObject3 = new JSONObject();
      try
      {
        ((JSONObject)localObject3).put("project", awso.a());
        ((JSONObject)localObject3).put("event_src", "client");
        ((JSONObject)localObject3).put("experiment_id", awso.b);
        if (paramView != null)
        {
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528().module("all_result").action("clk_relatedsearch_list").obj1(paramView.a + "").obj2(paramView.d).ver1(paramView.a()).ver2(awso.a(i));
          if (localObject2 == null)
          {
            paramView = "";
            awso.a(null, localReportModelDC02528.ver4(paramView).ver7(((JSONObject)localObject3).toString()).session_id(localQQAppInterface.getCurrentAccountUin() + awiu.a));
          }
        }
        else
        {
          if ((!((String)localObject1).startsWith("https://")) && (!((String)localObject1).startsWith("http://"))) {
            break label419;
          }
          paramView = new Intent(localContext, QQBrowserActivity.class);
          paramView.putExtra("url", (String)localObject1);
          localContext.startActivity(paramView);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("NetSearchTemplateNewEntranceView", 2, "e = " + localJSONException);
          continue;
          paramView = localObject2.toString();
        }
        if ((localContext instanceof BaseActivity))
        {
          paramView = bbej.a(((BaseActivity)localContext).app, localContext, (String)localObject1);
          if (paramView != null)
          {
            paramView.c();
            return;
          }
          localContext.startActivity(new Intent(localContext, JumpActivity.class).setData(Uri.parse((String)localObject1)));
          return;
        }
        localContext.startActivity(new Intent(localContext, JumpActivity.class).setData(Uri.parse((String)localObject1)));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awxj
 * JD-Core Version:    0.7.0.1
 */