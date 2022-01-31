import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import java.util.List;

class awsf
  implements View.OnClickListener
{
  awsf(awsa paramawsa, awoz paramawoz, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Awoz.m))
    {
      paramView = awvv.a(this.jdField_a_of_type_Awoz.a(), 0, awso.a(this.jdField_a_of_type_Awoz.c));
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramView);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      paramView = new StringBuilder();
      int i = 0;
      if (i < this.jdField_a_of_type_Awoz.a.size())
      {
        if (i != this.jdField_a_of_type_Awoz.a.size() - 1) {
          paramView.append(((awom)this.jdField_a_of_type_Awoz.a.get(i)).b).append("::");
        }
        for (;;)
        {
          i += 1;
          break;
          paramView.append(((awom)this.jdField_a_of_type_Awoz.a.get(i)).b);
        }
      }
      awso.a(null, new ReportModelDC02528().module("all_result").action("clk_web_search").obj1("2073745984").ver1(this.jdField_a_of_type_Awoz.g).ver2(awso.a(UniteSearchActivity.d)).ver4(paramView.toString()).ver5("1").ver6("2").ver7("{experiment_id:" + awso.b + "}"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awsf
 * JD-Core Version:    0.7.0.1
 */