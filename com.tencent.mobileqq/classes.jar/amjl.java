import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.widget.presseffect.PressEffectImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URLEncoder;

class amjl
  implements View.OnClickListener
{
  public int a;
  public View a;
  public ImageView a;
  public TextView a;
  public PressEffectImageView a;
  public View b;
  
  amjl(amjk paramamjk) {}
  
  public void onClick(View paramView)
  {
    String str3 = this.jdField_a_of_type_Amjk.a(this.jdField_a_of_type_Int);
    if (paramView == this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectImageView)
    {
      if (this.jdField_a_of_type_Amjk.jdField_a_of_type_Aodf != null) {
        this.jdField_a_of_type_Amjk.jdField_a_of_type_Aodf.a(this.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_Amjk.a();
    }
    while (paramView != this.jdField_a_of_type_AndroidViewView)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    String str2 = arfh.a().c;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "https://sou.qq.com/kandian/kd.html?_bid=3216&_wv=3&_wwv=1293&_wvSb=0&keyword=$KEYWORD$&from=$FROM$";
    }
    str1 = str1.replace("$KEYWORD$", URLEncoder.encode(str3));
    if ((this.jdField_a_of_type_Amjk.jdField_a_of_type_Int == 25) || (this.jdField_a_of_type_Amjk.jdField_a_of_type_Int == 10)) {}
    for (str1 = str1.replace("$FROM$", "kandian_history");; str1 = str1.replace("$FROM$", bcjs.a(this.jdField_a_of_type_Amjk.jdField_a_of_type_Int)))
    {
      str1 = str1.replace("$SEARCHID$", "" + URLEncoder.encode(UniteSearchActivity.c));
      bcnc.a(this.jdField_a_of_type_Amjk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Amjk.jdField_a_of_type_AndroidContentContext, str1);
      this.jdField_a_of_type_Amjk.jdField_a_of_type_Aodf.a(str3);
      bcjs.a(null, new ReportModelDC02528().module("search_his").action("clk_search_his").ver2(bcjs.a(this.jdField_a_of_type_Amjk.jdField_a_of_type_Int)).ver4(str3).ver7("{experiment_id:" + bcjs.b + "}"));
      new aogi(this.jdField_a_of_type_Amjk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_Amjk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "clk_search_his", "search_his", bcjs.a(this.jdField_a_of_type_Amjk.jdField_a_of_type_Int), "", str3, "{experiment_id:" + bcjs.b + "}");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amjl
 * JD-Core Version:    0.7.0.1
 */