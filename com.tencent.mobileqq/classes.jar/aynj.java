import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;

class aynj
  implements View.OnClickListener
{
  aynj(aynf paramaynf, ayke paramayke, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Ayke.m))
    {
      paramView = ayra.a(this.jdField_a_of_type_Ayke.a(), 0, aynt.a(this.jdField_a_of_type_Ayke.c));
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramView);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      aynt.a(null, new ReportModelDC02528().module("all_result").action("clk_web_search").obj1("2073745984").ver1(this.jdField_a_of_type_Ayke.g).ver2(aynt.a(UniteSearchActivity.d)).ver5("1").ver6("1").ver7("{experiment_id:" + aynt.b + "}"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aynj
 * JD-Core Version:    0.7.0.1
 */