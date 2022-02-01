import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bcjo
  implements View.OnClickListener
{
  bcjo(bcjk parambcjk, bcgk parambcgk, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Bcgk.m))
    {
      String str = bcnf.a(this.jdField_a_of_type_Bcgk.a(), 0, bcjy.a(this.jdField_a_of_type_Bcgk.c));
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", str);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      bcjy.a(null, new ReportModelDC02528().module("all_result").action("clk_web_search").obj1("2073745984").ver1(this.jdField_a_of_type_Bcgk.g).ver2(bcjy.a(UniteSearchActivity.d)).ver5("1").ver6("1").ver7("{experiment_id:" + bcjy.b + "}"));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcjo
 * JD-Core Version:    0.7.0.1
 */