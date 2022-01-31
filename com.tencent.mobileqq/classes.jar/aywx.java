import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class aywx
  implements View.OnClickListener
{
  aywx(ayww paramayww) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag(2131377450);
    Object localObject2 = paramView.getTag(2131377451);
    Context localContext;
    Object localObject3;
    if ((localObject1 != null) && ((localObject1 instanceof String)))
    {
      localContext = paramView.getContext();
      localObject1 = (String)localObject1;
      localObject3 = paramView.getTag(2131377424);
      if (!(localObject3 instanceof Integer)) {
        break label485;
      }
    }
    label404:
    label485:
    for (int i = ((Integer)localObject3).intValue();; i = 0)
    {
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject1 = ayvj.c(i);
      }
      for (localObject1 = ayvj.a((String)localObject2, 3, (String)localObject1);; localObject1 = ayvj.b((String)localObject1, i))
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
      aysc.a(null, 0, i, "0X8009D5F", 0, 0, null, null);
      paramView = (ayoo)paramView.getTag(2131379971);
      localObject3 = new JSONObject();
      try
      {
        ((JSONObject)localObject3).put("project", aysc.a());
        ((JSONObject)localObject3).put("event_src", "client");
        ((JSONObject)localObject3).put("experiment_id", aysc.b);
        if (paramView != null)
        {
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528().module("all_result").action("clk_relatedsearch_list").obj1(paramView.a + "").obj2(paramView.d).ver1(paramView.a()).ver2(aysc.a(i));
          if (localObject2 == null)
          {
            paramView = "";
            aysc.a(null, localReportModelDC02528.ver4(paramView).ver7(((JSONObject)localObject3).toString()).session_id(localQQAppInterface.getCurrentAccountUin() + ayif.a));
          }
        }
        else
        {
          if ((!((String)localObject1).startsWith("https://")) && (!((String)localObject1).startsWith("http://"))) {
            break label404;
          }
          ayvm.a(localContext, (String)localObject2, (String)localObject1);
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
          paramView = bdib.a(((BaseActivity)localContext).app, localContext, (String)localObject1);
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
 * Qualified Name:     aywx
 * JD-Core Version:    0.7.0.1
 */