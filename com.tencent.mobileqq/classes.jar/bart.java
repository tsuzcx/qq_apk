import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.entry.search.ui.MiniAppSearchFragment;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class bart
  implements View.OnClickListener
{
  bart(bars parambars, View paramView1, bawz parambawz, View paramView2, String paramString, List paramList) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (((this.jdField_a_of_type_AndroidViewView.getTag() instanceof Long)) && (l - ((Long)this.jdField_a_of_type_AndroidViewView.getTag()).longValue() < 400L))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setTag(Long.valueOf(l));
    if (this.jdField_a_of_type_Bawz.jdField_c_of_type_JavaLangString.equals("mqqapi://contact/search_might_know")) {
      bcef.b(null, "dc00898", "", "", "0X800A336", "0X800A336", 0, 0, "", "", "", "");
    }
    Object localObject1;
    int i;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Bawz.jdField_c_of_type_JavaLangString))
    {
      localObject1 = this.jdField_a_of_type_Bawz.jdField_c_of_type_JavaLangString;
      if (MiniAppLauncher.isMiniAppUrl((String)localObject1)) {
        if (this.jdField_a_of_type_Bawz.jdField_c_of_type_Int == 103)
        {
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("key_refer", 4001);
          PublicFragmentActivity.a(paramView.getContext(), (Intent)localObject1, MiniAppSearchFragment.class);
          i = 0;
          label172:
          if (this.jdField_a_of_type_Bawz.jdField_c_of_type_Int == 1)
          {
            if (i == 0) {
              break label716;
            }
            MiniProgramLpReportDC04239.reportAsync("search", "headentrance", "click", "2");
          }
        }
      }
    }
    for (;;)
    {
      if (this.b.getVisibility() == 0)
      {
        this.b.setVisibility(8);
        bfyz.a(this.jdField_a_of_type_Bawz.jdField_c_of_type_Int, this.jdField_a_of_type_JavaLangString);
      }
      bbgk.a("home_page", "clk_entry", new String[] { this.jdField_a_of_type_Bawz.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Bars.a), String.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
      bbda.a(null, new ReportModelDC02528().module("all_result").action("clk_entry").ver2(bbda.a(this.jdField_a_of_type_Bars.a)).ver3(this.jdField_a_of_type_JavaUtilList.size() + "").ver4(this.jdField_a_of_type_Bawz.jdField_a_of_type_JavaLangString).ver7("{experiment_id:" + bbda.b + "}"));
      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      new andr((QQAppInterface)localObject1).b((QQAppInterface)localObject1, "clk_entry", "all_result", bbda.a(this.jdField_a_of_type_Bars.a), "", this.jdField_a_of_type_Bawz.jdField_a_of_type_JavaLangString, "{experiment_id:" + bbda.b + "}");
      bbda.a(bars.a(this.jdField_a_of_type_Bars), 0, SearchEntryFragment.a(this.jdField_a_of_type_Bars.a), "0X8009D1C", 0, 0, this.jdField_a_of_type_Bawz.jdField_a_of_type_JavaLangString, null);
      break;
      i = 1;
      MiniAppLauncher.startMiniApp(bars.a(this.jdField_a_of_type_Bars), (String)localObject1, 2005, null);
      break label172;
      Object localObject2;
      if ((((String)localObject1).startsWith("http://")) || (((String)localObject1).startsWith("https://")))
      {
        localObject2 = new Intent(bars.a(this.jdField_a_of_type_Bars), QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        bars.a(this.jdField_a_of_type_Bars).startActivity((Intent)localObject2);
        i = 0;
        break label172;
      }
      if ((bars.a(this.jdField_a_of_type_Bars) instanceof BaseActivity))
      {
        localObject2 = bfwg.a(((BaseActivity)paramView.getContext()).app, bars.a(this.jdField_a_of_type_Bars), (String)localObject1);
        if (localObject2 != null) {
          ((bfvp)localObject2).a();
        }
        for (;;)
        {
          i = 0;
          break;
          bars.a(this.jdField_a_of_type_Bars).startActivity(new Intent(bars.a(this.jdField_a_of_type_Bars), JumpActivity.class).setData(Uri.parse((String)localObject1)));
        }
      }
      bars.a(this.jdField_a_of_type_Bars).startActivity(new Intent(bars.a(this.jdField_a_of_type_Bars), JumpActivity.class).setData(Uri.parse((String)localObject1)));
      i = 0;
      break label172;
      label716:
      MiniProgramLpReportDC04239.reportAsync("search", "headentrance", "click", "1");
      continue;
      i = this.jdField_a_of_type_Bars.a;
      if (this.jdField_a_of_type_Bars.a == 3) {
        i = 21;
      }
      ActiveEntitySearchActivity.a(bars.a(this.jdField_a_of_type_Bars), this.jdField_a_of_type_Bawz.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bawz.jdField_a_of_type_ArrayOfLong, i);
      if (!NetworkUtil.isNetworkAvailable(bars.a(this.jdField_a_of_type_Bars))) {
        QQToast.a(bars.a(this.jdField_a_of_type_Bars), 0, bars.a(this.jdField_a_of_type_Bars).getResources().getString(2131717325), 0).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bart
 * JD-Core Version:    0.7.0.1
 */