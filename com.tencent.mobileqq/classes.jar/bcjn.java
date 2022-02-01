import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bcjn
  implements View.OnClickListener
{
  bcjn(bcjk parambcjk, bcgl parambcgl, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    bcjy.a(null, 0, this.jdField_a_of_type_Bcgl.c, "0X8009D5D", 0, 0, null, null);
    bcjy.a(null, new ReportModelDC02528().module("all_result").action("clk_web_search").obj1("2073745984").ver1(this.jdField_a_of_type_Bcgl.g).ver2(bcjy.a(UniteSearchActivity.d)).ver5("1").ver6("1").ver7("{experiment_id:" + bcjy.b + "}"));
    String str;
    if (TextUtils.isEmpty(this.jdField_a_of_type_Bcgl.l))
    {
      str = bcnf.a(this.jdField_a_of_type_Bcgl.c);
      str = bcnf.a(this.jdField_a_of_type_Bcgl.a(), 0, str);
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", str);
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.SearchTemplatePresenter", 2, "open Browser append suffix url = " + str);
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      str = bcnf.a(bcnf.a(this.jdField_a_of_type_Bcgl.l, this.jdField_a_of_type_Bcgl.a(), 0, bcjy.a(this.jdField_a_of_type_Bcgl.c)), this.jdField_a_of_type_Bcgl.c);
      bcni.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bcgl.a(), str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcjn
 * JD-Core Version:    0.7.0.1
 */