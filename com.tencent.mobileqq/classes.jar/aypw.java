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
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class aypw
  implements View.OnClickListener
{
  aypw(aypv paramaypv) {}
  
  public void onClick(View paramView)
  {
    Object localObject2 = paramView.getTag(2131377450);
    Object localObject3 = paramView.getTag(2131377451);
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "tag_url=" + localObject2 + "  tag_wording=" + localObject3);
    }
    Object localObject1 = "";
    Context localContext;
    int i;
    if ((localObject2 instanceof String))
    {
      localContext = paramView.getContext();
      localObject2 = (String)localObject2;
      if ((localContext instanceof UniteSearchActivity))
      {
        localObject1 = (UniteSearchActivity)localContext;
        switch (((UniteSearchActivity)localObject1).a)
        {
        default: 
          i = 0;
          ayvm.a("all_result", "clk_relatedsearch_list", new String[] { "" + localObject3, ((UniteSearchActivity)localObject1).a + "", "" + ayvj.a((String)localObject3, i) });
          paramView = (ayms)paramView.getTag(2131379971);
          localObject1 = new JSONObject();
        }
      }
    }
    for (;;)
    {
      try
      {
        ((JSONObject)localObject1).put("project", aysc.a());
        ((JSONObject)localObject1).put("event_src", "client");
        ((JSONObject)localObject1).put("experiment_id", aysc.b);
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528().module("all_result").action("clk_relatedsearch_list").obj1(paramView.d() + "").obj2(paramView.b).ver1(paramView.a()).ver2(aysc.a(paramView.a));
        if (localObject3 == null)
        {
          paramView = "";
          aysc.a(null, localReportModelDC02528.ver4(paramView).ver7(((JSONObject)localObject1).toString()).session_id(localQQAppInterface.getCurrentAccountUin() + ayif.a));
          localObject1 = ayvj.d(i);
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label645;
          }
          paramView = (View)localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            paramView = "user_relative_word";
          }
          paramView = ayvj.a((String)localObject3, 3, paramView);
          if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "open Browser append suffix url = " + paramView);
          }
          if ((!paramView.startsWith("https://")) && (!paramView.startsWith("http://"))) {
            continue;
          }
          localObject1 = new Intent(localContext, QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("url", paramView);
          localContext.startActivity((Intent)localObject1);
          return;
          i = 1;
          break;
          i = 2;
          break;
          i = 3;
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "e = " + localJSONException);
        continue;
        paramView = localObject3.toString();
        continue;
        if ((localContext instanceof BaseActivity))
        {
          localObject1 = bdib.a(((BaseActivity)localContext).app, localContext, paramView);
          if (localObject1 != null)
          {
            ((bdhk)localObject1).c();
            return;
          }
          localContext.startActivity(new Intent(localContext, JumpActivity.class).setData(Uri.parse(paramView)));
          return;
        }
        localContext.startActivity(new Intent(localContext, JumpActivity.class).setData(Uri.parse(paramView)));
        return;
      }
      label645:
      paramView = (View)localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aypw
 * JD-Core Version:    0.7.0.1
 */