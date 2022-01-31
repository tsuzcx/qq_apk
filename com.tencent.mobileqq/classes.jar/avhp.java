import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import java.util.List;

class avhp
  implements View.OnClickListener
{
  avhp(avho paramavho, View paramView1, avmt paramavmt, View paramView2, String paramString, List paramList) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (((this.jdField_a_of_type_AndroidViewView.getTag() instanceof Long)) && (l - ((Long)this.jdField_a_of_type_AndroidViewView.getTag()).longValue() < 400L)) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setTag(Long.valueOf(l));
    if (this.jdField_a_of_type_Avmt.jdField_c_of_type_JavaLangString.equals("mqqapi://contact/search_might_know")) {
      awqx.b(null, "dc00898", "", "", "0X800A336", "0X800A336", 0, 0, "", "", "", "");
    }
    String str;
    int i;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Avmt.jdField_c_of_type_JavaLangString))
    {
      str = this.jdField_a_of_type_Avmt.jdField_c_of_type_JavaLangString;
      if (MiniAppLauncher.isMiniAppUrl(str))
      {
        MiniAppLauncher.startMiniApp(avho.a(this.jdField_a_of_type_Avho), str, 2005, null);
        i = 1;
        if (this.jdField_a_of_type_Avmt.jdField_c_of_type_Int == 1)
        {
          if (i == 0) {
            break label574;
          }
          MiniProgramLpReportDC04239.reportAsync("search", "headentrance", "click", "2");
        }
      }
    }
    for (;;)
    {
      if (this.b.getVisibility() == 0)
      {
        this.b.setVisibility(8);
        baig.a(this.jdField_a_of_type_Avmt.jdField_c_of_type_Int, this.jdField_a_of_type_JavaLangString);
      }
      avwf.a("home_page", "clk_entry", new String[] { this.jdField_a_of_type_Avmt.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Avho.a), String.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
      avsv.a(null, new ReportModelDC02528().module("all_result").action("clk_entry").ver2(avsv.a(this.jdField_a_of_type_Avho.a)).ver3(this.jdField_a_of_type_JavaUtilList.size() + "").ver4(this.jdField_a_of_type_Avmt.jdField_a_of_type_JavaLangString).ver7("{experiment_id:" + avsv.b + "}"));
      avsv.a(avho.a(this.jdField_a_of_type_Avho), 0, SearchEntryFragment.a(this.jdField_a_of_type_Avho.a), "0X8009D1C", 0, 0, this.jdField_a_of_type_Avmt.jdField_a_of_type_JavaLangString, null);
      return;
      if ((str.startsWith("http://")) || (str.startsWith("https://")))
      {
        paramView = new Intent(avho.a(this.jdField_a_of_type_Avho), QQBrowserActivity.class);
        paramView.putExtra("url", str);
        avho.a(this.jdField_a_of_type_Avho).startActivity(paramView);
        i = 0;
        break;
      }
      if ((avho.a(this.jdField_a_of_type_Avho) instanceof BaseActivity))
      {
        paramView = bade.a(((BaseActivity)paramView.getContext()).app, avho.a(this.jdField_a_of_type_Avho), str);
        if (paramView != null) {
          paramView.c();
        }
        for (;;)
        {
          i = 0;
          break;
          avho.a(this.jdField_a_of_type_Avho).startActivity(new Intent(avho.a(this.jdField_a_of_type_Avho), JumpActivity.class).setData(Uri.parse(str)));
        }
      }
      avho.a(this.jdField_a_of_type_Avho).startActivity(new Intent(avho.a(this.jdField_a_of_type_Avho), JumpActivity.class).setData(Uri.parse(str)));
      i = 0;
      break;
      label574:
      MiniProgramLpReportDC04239.reportAsync("search", "headentrance", "click", "1");
      continue;
      i = this.jdField_a_of_type_Avho.a;
      if (this.jdField_a_of_type_Avho.a == 3) {
        i = 21;
      }
      ActiveEntitySearchActivity.a(avho.a(this.jdField_a_of_type_Avho), this.jdField_a_of_type_Avmt.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Avmt.jdField_a_of_type_ArrayOfLong, i);
      if (!badq.g(avho.a(this.jdField_a_of_type_Avho))) {
        bbmy.a(avho.a(this.jdField_a_of_type_Avho), 0, avho.a(this.jdField_a_of_type_Avho).getResources().getString(2131652572), 0).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avhp
 * JD-Core Version:    0.7.0.1
 */