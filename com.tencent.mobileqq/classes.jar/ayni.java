import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;

class ayni
  implements View.OnClickListener
{
  ayni(aynf paramaynf, aykf paramaykf, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    aynt.a(null, 0, this.jdField_a_of_type_Aykf.c, "0X8009D5D", 0, 0, null, null);
    aynt.a(null, new ReportModelDC02528().module("all_result").action("clk_web_search").obj1("2073745984").ver1(this.jdField_a_of_type_Aykf.g).ver2(aynt.a(UniteSearchActivity.d)).ver5("1").ver6("1").ver7("{experiment_id:" + aynt.b + "}"));
    if (TextUtils.isEmpty(this.jdField_a_of_type_Aykf.l))
    {
      paramView = ayra.a(this.jdField_a_of_type_Aykf.c);
      paramView = ayra.a(this.jdField_a_of_type_Aykf.a(), 0, paramView);
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramView);
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.SearchTemplatePresenter", 2, "open Browser append suffix url = " + paramView);
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return;
    }
    paramView = ayra.a(ayra.a(this.jdField_a_of_type_Aykf.l, this.jdField_a_of_type_Aykf.a(), 0, aynt.a(this.jdField_a_of_type_Aykf.c)), this.jdField_a_of_type_Aykf.c);
    ayrd.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Aykf.a(), paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayni
 * JD-Core Version:    0.7.0.1
 */