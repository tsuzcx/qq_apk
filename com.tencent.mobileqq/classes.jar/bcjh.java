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

class bcjh
  implements View.OnClickListener
{
  bcjh(bcje parambcje, bcgd parambcgd, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    bcjs.a(null, 0, this.jdField_a_of_type_Bcgd.c, "0X8009D5D", 0, 0, null, null);
    bcjs.a(null, new ReportModelDC02528().module("all_result").action("clk_web_search").obj1("2073745984").ver1(this.jdField_a_of_type_Bcgd.g).ver2(bcjs.a(UniteSearchActivity.d)).ver5("1").ver6("1").ver7("{experiment_id:" + bcjs.b + "}"));
    String str;
    if (TextUtils.isEmpty(this.jdField_a_of_type_Bcgd.l))
    {
      str = bcmz.a(this.jdField_a_of_type_Bcgd.c);
      str = bcmz.a(this.jdField_a_of_type_Bcgd.a(), 0, str);
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
      str = bcmz.a(bcmz.a(this.jdField_a_of_type_Bcgd.l, this.jdField_a_of_type_Bcgd.a(), 0, bcjs.a(this.jdField_a_of_type_Bcgd.c)), this.jdField_a_of_type_Bcgd.c);
      bcnc.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bcgd.a(), str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcjh
 * JD-Core Version:    0.7.0.1
 */