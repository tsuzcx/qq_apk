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

class awhi
  implements View.OnClickListener
{
  awhi(awhh paramawhh, View paramView1, awmm paramawmm, View paramView2, String paramString, List paramList) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (((this.jdField_a_of_type_AndroidViewView.getTag() instanceof Long)) && (l - ((Long)this.jdField_a_of_type_AndroidViewView.getTag()).longValue() < 400L)) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setTag(Long.valueOf(l));
    if (this.jdField_a_of_type_Awmm.jdField_c_of_type_JavaLangString.equals("mqqapi://contact/search_might_know")) {
      axqw.b(null, "dc00898", "", "", "0X800A336", "0X800A336", 0, 0, "", "", "", "");
    }
    String str;
    int i;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Awmm.jdField_c_of_type_JavaLangString))
    {
      str = this.jdField_a_of_type_Awmm.jdField_c_of_type_JavaLangString;
      if (MiniAppLauncher.isMiniAppUrl(str))
      {
        MiniAppLauncher.startMiniApp(awhh.a(this.jdField_a_of_type_Awhh), str, 2005, null);
        i = 1;
        if (this.jdField_a_of_type_Awmm.jdField_c_of_type_Int == 1)
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
        bbjn.a(this.jdField_a_of_type_Awmm.jdField_c_of_type_Int, this.jdField_a_of_type_JavaLangString);
      }
      awvy.a("home_page", "clk_entry", new String[] { this.jdField_a_of_type_Awmm.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Awhh.a), String.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
      awso.a(null, new ReportModelDC02528().module("all_result").action("clk_entry").ver2(awso.a(this.jdField_a_of_type_Awhh.a)).ver3(this.jdField_a_of_type_JavaUtilList.size() + "").ver4(this.jdField_a_of_type_Awmm.jdField_a_of_type_JavaLangString).ver7("{experiment_id:" + awso.b + "}"));
      awso.a(awhh.a(this.jdField_a_of_type_Awhh), 0, SearchEntryFragment.a(this.jdField_a_of_type_Awhh.a), "0X8009D1C", 0, 0, this.jdField_a_of_type_Awmm.jdField_a_of_type_JavaLangString, null);
      return;
      if ((str.startsWith("http://")) || (str.startsWith("https://")))
      {
        paramView = new Intent(awhh.a(this.jdField_a_of_type_Awhh), QQBrowserActivity.class);
        paramView.putExtra("url", str);
        awhh.a(this.jdField_a_of_type_Awhh).startActivity(paramView);
        i = 0;
        break;
      }
      if ((awhh.a(this.jdField_a_of_type_Awhh) instanceof BaseActivity))
      {
        paramView = bbej.a(((BaseActivity)paramView.getContext()).app, awhh.a(this.jdField_a_of_type_Awhh), str);
        if (paramView != null) {
          paramView.c();
        }
        for (;;)
        {
          i = 0;
          break;
          awhh.a(this.jdField_a_of_type_Awhh).startActivity(new Intent(awhh.a(this.jdField_a_of_type_Awhh), JumpActivity.class).setData(Uri.parse(str)));
        }
      }
      awhh.a(this.jdField_a_of_type_Awhh).startActivity(new Intent(awhh.a(this.jdField_a_of_type_Awhh), JumpActivity.class).setData(Uri.parse(str)));
      i = 0;
      break;
      label574:
      MiniProgramLpReportDC04239.reportAsync("search", "headentrance", "click", "1");
      continue;
      i = this.jdField_a_of_type_Awhh.a;
      if (this.jdField_a_of_type_Awhh.a == 3) {
        i = 21;
      }
      ActiveEntitySearchActivity.a(awhh.a(this.jdField_a_of_type_Awhh), this.jdField_a_of_type_Awmm.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Awmm.jdField_a_of_type_ArrayOfLong, i);
      if (!bbev.g(awhh.a(this.jdField_a_of_type_Awhh))) {
        bcpw.a(awhh.a(this.jdField_a_of_type_Awhh), 0, awhh.a(this.jdField_a_of_type_Awhh).getResources().getString(2131718391), 0).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awhi
 * JD-Core Version:    0.7.0.1
 */