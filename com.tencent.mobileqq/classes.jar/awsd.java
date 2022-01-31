import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;

class awsd
  implements View.OnClickListener
{
  awsd(awsa paramawsa, awpa paramawpa, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    awso.a(null, 0, this.jdField_a_of_type_Awpa.c, "0X8009D5D", 0, 0, null, null);
    awso.a(null, new ReportModelDC02528().module("all_result").action("clk_web_search").obj1("2073745984").ver1(this.jdField_a_of_type_Awpa.g).ver2(awso.a(UniteSearchActivity.d)).ver5("1").ver6("1").ver7("{experiment_id:" + awso.b + "}"));
    if (TextUtils.isEmpty(this.jdField_a_of_type_Awpa.l))
    {
      paramView = awvv.b(this.jdField_a_of_type_Awpa.c);
      paramView = awvv.a(this.jdField_a_of_type_Awpa.a(), 0, paramView);
      localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramView);
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.SearchTemplatePresenter", 2, "open Browser append suffix url = " + paramView);
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return;
    }
    paramView = awvv.a(awvv.a(this.jdField_a_of_type_Awpa.l, this.jdField_a_of_type_Awpa.a(), 0, awso.a(this.jdField_a_of_type_Awpa.c)), this.jdField_a_of_type_Awpa.c);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramView);
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.SearchTemplatePresenter", 2, "open Browser append suffix url = " + paramView);
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awsd
 * JD-Core Version:    0.7.0.1
 */