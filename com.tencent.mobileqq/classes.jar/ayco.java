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
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class ayco
  implements View.OnClickListener
{
  ayco(aycn paramaycn, View paramView1, ayhr paramayhr, View paramView2, String paramString, List paramList) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (((this.jdField_a_of_type_AndroidViewView.getTag() instanceof Long)) && (l - ((Long)this.jdField_a_of_type_AndroidViewView.getTag()).longValue() < 400L)) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setTag(Long.valueOf(l));
    if (this.jdField_a_of_type_Ayhr.jdField_c_of_type_JavaLangString.equals("mqqapi://contact/search_might_know")) {
      azmj.b(null, "dc00898", "", "", "0X800A336", "0X800A336", 0, 0, "", "", "", "");
    }
    String str;
    int i;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Ayhr.jdField_c_of_type_JavaLangString))
    {
      str = this.jdField_a_of_type_Ayhr.jdField_c_of_type_JavaLangString;
      if (MiniAppLauncher.isMiniAppUrl(str))
      {
        MiniAppLauncher.startMiniApp(aycn.a(this.jdField_a_of_type_Aycn), str, 2005, null);
        i = 1;
        if (this.jdField_a_of_type_Ayhr.jdField_c_of_type_Int == 1)
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
        bdiv.a(this.jdField_a_of_type_Ayhr.jdField_c_of_type_Int, this.jdField_a_of_type_JavaLangString);
      }
      ayrd.a("home_page", "clk_entry", new String[] { this.jdField_a_of_type_Ayhr.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Aycn.a), String.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
      aynt.a(null, new ReportModelDC02528().module("all_result").action("clk_entry").ver2(aynt.a(this.jdField_a_of_type_Aycn.a)).ver3(this.jdField_a_of_type_JavaUtilList.size() + "").ver4(this.jdField_a_of_type_Ayhr.jdField_a_of_type_JavaLangString).ver7("{experiment_id:" + aynt.b + "}"));
      aynt.a(aycn.a(this.jdField_a_of_type_Aycn), 0, SearchEntryFragment.a(this.jdField_a_of_type_Aycn.a), "0X8009D1C", 0, 0, this.jdField_a_of_type_Ayhr.jdField_a_of_type_JavaLangString, null);
      return;
      if ((str.startsWith("http://")) || (str.startsWith("https://")))
      {
        paramView = new Intent(aycn.a(this.jdField_a_of_type_Aycn), QQBrowserActivity.class);
        paramView.putExtra("url", str);
        aycn.a(this.jdField_a_of_type_Aycn).startActivity(paramView);
        i = 0;
        break;
      }
      if ((aycn.a(this.jdField_a_of_type_Aycn) instanceof BaseActivity))
      {
        paramView = bdds.a(((BaseActivity)paramView.getContext()).app, aycn.a(this.jdField_a_of_type_Aycn), str);
        if (paramView != null) {
          paramView.c();
        }
        for (;;)
        {
          i = 0;
          break;
          aycn.a(this.jdField_a_of_type_Aycn).startActivity(new Intent(aycn.a(this.jdField_a_of_type_Aycn), JumpActivity.class).setData(Uri.parse(str)));
        }
      }
      aycn.a(this.jdField_a_of_type_Aycn).startActivity(new Intent(aycn.a(this.jdField_a_of_type_Aycn), JumpActivity.class).setData(Uri.parse(str)));
      i = 0;
      break;
      label574:
      MiniProgramLpReportDC04239.reportAsync("search", "headentrance", "click", "1");
      continue;
      i = this.jdField_a_of_type_Aycn.a;
      if (this.jdField_a_of_type_Aycn.a == 3) {
        i = 21;
      }
      ActiveEntitySearchActivity.a(aycn.a(this.jdField_a_of_type_Aycn), this.jdField_a_of_type_Ayhr.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Ayhr.jdField_a_of_type_ArrayOfLong, i);
      if (!bdee.g(aycn.a(this.jdField_a_of_type_Aycn))) {
        QQToast.a(aycn.a(this.jdField_a_of_type_Aycn), 0, aycn.a(this.jdField_a_of_type_Aycn).getResources().getString(2131718824), 0).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayco
 * JD-Core Version:    0.7.0.1
 */