import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URLEncoder;

class bbzj
  implements View.OnClickListener
{
  public int a;
  public boolean a;
  
  bbzj(bbzi parambbzi) {}
  
  public void onClick(View paramView)
  {
    aohb localaohb = (aohb)bbzi.a(this.jdField_a_of_type_Bbzi).getManager(299);
    String str3 = (String)this.jdField_a_of_type_Bbzi.getItem(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Boolean)
    {
      localaohb.a(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bbzi.a.a();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      String str2 = arij.a().c;
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = "https://sou.qq.com/kandian/kd.html?_bid=3216&_wv=3&_wwv=1293&_wvSb=0&keyword=$KEYWORD$&from=$FROM$";
      }
      str1 = str1.replace("$KEYWORD$", URLEncoder.encode(str3)).replace("$FROM$", "kandian_history").replace("$SEARCHID$", "" + URLEncoder.encode(UniteSearchActivity.c));
      bcni.a(bbzi.a(this.jdField_a_of_type_Bbzi), bbzi.a(this.jdField_a_of_type_Bbzi), str1);
      localaohb.a(str3);
      bcjy.a(null, new ReportModelDC02528().module("search_his").action("clk_search_his").ver2("kandian").ver4(str3).ver7("{experiment_id:" + bcjy.b + "}"));
      new aokg(bbzi.a(this.jdField_a_of_type_Bbzi)).b(bbzi.a(this.jdField_a_of_type_Bbzi), "clk_search_his", "search_his", "kandian", "", str3, "{experiment_id:" + bcjy.b + "}");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbzj
 * JD-Core Version:    0.7.0.1
 */