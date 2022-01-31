import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;

class ayrr
  implements View.OnClickListener
{
  ayrr(ayro paramayro, ayoo paramayoo, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    aysc.a(null, 0, this.jdField_a_of_type_Ayoo.c, "0X8009D5D", 0, 0, null, null);
    aysc.a(null, new ReportModelDC02528().module("all_result").action("clk_web_search").obj1("2073745984").ver1(this.jdField_a_of_type_Ayoo.g).ver2(aysc.a(UniteSearchActivity.d)).ver5("1").ver6("1").ver7("{experiment_id:" + aysc.b + "}"));
    if (TextUtils.isEmpty(this.jdField_a_of_type_Ayoo.l))
    {
      paramView = ayvj.a(this.jdField_a_of_type_Ayoo.c);
      paramView = ayvj.a(this.jdField_a_of_type_Ayoo.a(), 0, paramView);
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramView);
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.SearchTemplatePresenter", 2, "open Browser append suffix url = " + paramView);
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return;
    }
    paramView = ayvj.a(ayvj.a(this.jdField_a_of_type_Ayoo.l, this.jdField_a_of_type_Ayoo.a(), 0, aysc.a(this.jdField_a_of_type_Ayoo.c)), this.jdField_a_of_type_Ayoo.c);
    ayvm.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ayoo.a(), paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayrr
 * JD-Core Version:    0.7.0.1
 */