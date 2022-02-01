import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URLEncoder;

class bbgp
  implements View.OnClickListener
{
  public int a;
  public boolean a;
  
  bbgp(bbgo parambbgo) {}
  
  public void onClick(View paramView)
  {
    anur localanur = (anur)bbgo.a(this.jdField_a_of_type_Bbgo).getManager(299);
    String str3 = (String)this.jdField_a_of_type_Bbgo.getItem(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Boolean)
    {
      localanur.a(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bbgo.a.a();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      String str2 = aqsx.a().c;
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = "https://sou.qq.com/kandian/kd.html?_bid=3216&_wv=3&_wwv=1293&_wvSb=0&keyword=$KEYWORD$&from=$FROM$";
      }
      str1 = str1.replace("$KEYWORD$", URLEncoder.encode(str3)).replace("$FROM$", "kandian_history").replace("$SEARCHID$", "" + URLEncoder.encode(UniteSearchActivity.c));
      bbup.a(bbgo.a(this.jdField_a_of_type_Bbgo), bbgo.a(this.jdField_a_of_type_Bbgo), str1);
      localanur.a(str3);
      bbrf.a(null, new ReportModelDC02528().module("search_his").action("clk_search_his").ver2("kandian").ver4(str3).ver7("{experiment_id:" + bbrf.b + "}"));
      new anxu(bbgo.a(this.jdField_a_of_type_Bbgo)).b(bbgo.a(this.jdField_a_of_type_Bbgo), "clk_search_his", "search_his", "kandian", "", str3, "{experiment_id:" + bbrf.b + "}");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbgp
 * JD-Core Version:    0.7.0.1
 */