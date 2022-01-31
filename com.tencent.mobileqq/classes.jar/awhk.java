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

class awhk
  implements View.OnClickListener
{
  awhk(awhj paramawhj, View paramView1, awmo paramawmo, View paramView2, String paramString, List paramList) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (((this.jdField_a_of_type_AndroidViewView.getTag() instanceof Long)) && (l - ((Long)this.jdField_a_of_type_AndroidViewView.getTag()).longValue() < 400L)) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setTag(Long.valueOf(l));
    if (this.jdField_a_of_type_Awmo.jdField_c_of_type_JavaLangString.equals("mqqapi://contact/search_might_know")) {
      axqy.b(null, "dc00898", "", "", "0X800A336", "0X800A336", 0, 0, "", "", "", "");
    }
    String str;
    int i;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Awmo.jdField_c_of_type_JavaLangString))
    {
      str = this.jdField_a_of_type_Awmo.jdField_c_of_type_JavaLangString;
      if (MiniAppLauncher.isMiniAppUrl(str))
      {
        MiniAppLauncher.startMiniApp(awhj.a(this.jdField_a_of_type_Awhj), str, 2005, null);
        i = 1;
        if (this.jdField_a_of_type_Awmo.jdField_c_of_type_Int == 1)
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
        bbkb.a(this.jdField_a_of_type_Awmo.jdField_c_of_type_Int, this.jdField_a_of_type_JavaLangString);
      }
      awwa.a("home_page", "clk_entry", new String[] { this.jdField_a_of_type_Awmo.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Awhj.a), String.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
      awsq.a(null, new ReportModelDC02528().module("all_result").action("clk_entry").ver2(awsq.a(this.jdField_a_of_type_Awhj.a)).ver3(this.jdField_a_of_type_JavaUtilList.size() + "").ver4(this.jdField_a_of_type_Awmo.jdField_a_of_type_JavaLangString).ver7("{experiment_id:" + awsq.b + "}"));
      awsq.a(awhj.a(this.jdField_a_of_type_Awhj), 0, SearchEntryFragment.a(this.jdField_a_of_type_Awhj.a), "0X8009D1C", 0, 0, this.jdField_a_of_type_Awmo.jdField_a_of_type_JavaLangString, null);
      return;
      if ((str.startsWith("http://")) || (str.startsWith("https://")))
      {
        paramView = new Intent(awhj.a(this.jdField_a_of_type_Awhj), QQBrowserActivity.class);
        paramView.putExtra("url", str);
        awhj.a(this.jdField_a_of_type_Awhj).startActivity(paramView);
        i = 0;
        break;
      }
      if ((awhj.a(this.jdField_a_of_type_Awhj) instanceof BaseActivity))
      {
        paramView = bbex.a(((BaseActivity)paramView.getContext()).app, awhj.a(this.jdField_a_of_type_Awhj), str);
        if (paramView != null) {
          paramView.c();
        }
        for (;;)
        {
          i = 0;
          break;
          awhj.a(this.jdField_a_of_type_Awhj).startActivity(new Intent(awhj.a(this.jdField_a_of_type_Awhj), JumpActivity.class).setData(Uri.parse(str)));
        }
      }
      awhj.a(this.jdField_a_of_type_Awhj).startActivity(new Intent(awhj.a(this.jdField_a_of_type_Awhj), JumpActivity.class).setData(Uri.parse(str)));
      i = 0;
      break;
      label574:
      MiniProgramLpReportDC04239.reportAsync("search", "headentrance", "click", "1");
      continue;
      i = this.jdField_a_of_type_Awhj.a;
      if (this.jdField_a_of_type_Awhj.a == 3) {
        i = 21;
      }
      ActiveEntitySearchActivity.a(awhj.a(this.jdField_a_of_type_Awhj), this.jdField_a_of_type_Awmo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Awmo.jdField_a_of_type_ArrayOfLong, i);
      if (!bbfj.g(awhj.a(this.jdField_a_of_type_Awhj))) {
        bcql.a(awhj.a(this.jdField_a_of_type_Awhj), 0, awhj.a(this.jdField_a_of_type_Awhj).getResources().getString(2131718402), 0).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awhk
 * JD-Core Version:    0.7.0.1
 */