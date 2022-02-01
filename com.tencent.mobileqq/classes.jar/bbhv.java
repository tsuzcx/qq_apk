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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;
import org.json.JSONObject;

class bbhv
  implements View.OnClickListener
{
  bbhv(bbhu parambbhu) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag(2131378207);
    Object localObject3 = paramView.getTag(2131378208);
    Context localContext;
    Object localObject2;
    if ((localObject1 != null) && ((localObject1 instanceof String)))
    {
      localContext = paramView.getContext();
      localObject1 = (String)localObject1;
      localObject2 = paramView.getTag(2131378177);
      if (!(localObject2 instanceof Integer)) {
        break label511;
      }
    }
    label145:
    label421:
    label511:
    for (int i = ((Integer)localObject2).intValue();; i = 0)
    {
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = bbgh.c(i);
        localObject1 = bbgh.a((String)localObject3, 3, (String)localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("NetSearchTemplateNewEntranceView", 2, "open Browser append suffix url = " + (String)localObject1);
        }
        if (localObject1 != null) {
          break label145;
        }
        QLog.e("NetSearchTemplateNewEntranceView", 2, "NetSearchSubView click jumpurl is null");
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localObject1 = bbgh.b((String)localObject1, i);
        break;
        bbda.a(null, 0, i, "0X8009D5F", 0, 0, null, null);
        localObject2 = (bazn)paramView.getTag(2131380831);
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("project", bbda.a());
          localJSONObject.put("event_src", "client");
          localJSONObject.put("experiment_id", bbda.b);
          if (localObject2 != null)
          {
            QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528().module("all_result").action("clk_relatedsearch_list").obj1(((bazn)localObject2).a + "").obj2(((bazn)localObject2).d).ver1(((bazn)localObject2).a()).ver2(bbda.a(i));
            if (localObject3 == null)
            {
              localObject2 = "";
              bbda.a(null, localReportModelDC02528.ver4((String)localObject2).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + batb.a));
            }
          }
          else
          {
            if ((!((String)localObject1).startsWith("https://")) && (!((String)localObject1).startsWith("http://"))) {
              break label421;
            }
            bbgk.a(localContext, (String)localObject3, (String)localObject1);
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            QLog.e("NetSearchTemplateNewEntranceView", 2, "e = " + localJSONException);
            continue;
            localObject2 = localObject3.toString();
          }
          if ((localContext instanceof BaseActivity))
          {
            localObject2 = bfwg.a(((BaseActivity)localContext).app, localContext, (String)localObject1);
            if (localObject2 != null) {
              ((bfvp)localObject2).a();
            } else {
              localContext.startActivity(new Intent(localContext, JumpActivity.class).setData(Uri.parse((String)localObject1)));
            }
          }
          else
          {
            localContext.startActivity(new Intent(localContext, JumpActivity.class).setData(Uri.parse((String)localObject1)));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbhv
 * JD-Core Version:    0.7.0.1
 */