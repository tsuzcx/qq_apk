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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class bbxy
  implements View.OnClickListener
{
  bbxy(bbxx parambbxx, View paramView1, bcdx parambcdx, View paramView2, String paramString, List paramList) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (((this.jdField_a_of_type_AndroidViewView.getTag() instanceof Long)) && (l - ((Long)this.jdField_a_of_type_AndroidViewView.getTag()).longValue() < 400L))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setTag(Long.valueOf(l));
    if (this.jdField_a_of_type_Bcdx.jdField_c_of_type_JavaLangString.equals("mqqapi://contact/search_might_know")) {
      bdll.b(null, "dc00898", "", "", "0X800A336", "0X800A336", 0, 0, "", "", "", "");
    }
    Object localObject1;
    int i;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Bcdx.jdField_c_of_type_JavaLangString))
    {
      localObject1 = this.jdField_a_of_type_Bcdx.jdField_c_of_type_JavaLangString;
      if (MiniAppLauncher.isMiniAppUrl((String)localObject1)) {
        if (this.jdField_a_of_type_Bcdx.jdField_c_of_type_Int == 103)
        {
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("key_refer", 4001);
          PublicFragmentActivity.a(paramView.getContext(), (Intent)localObject1, MiniAppSearchFragment.class);
          i = 0;
          label172:
          if (this.jdField_a_of_type_Bcdx.jdField_c_of_type_Int == 1)
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
        bhsi.a(this.jdField_a_of_type_Bcdx.jdField_c_of_type_Int, this.jdField_a_of_type_JavaLangString);
      }
      bcni.a("home_page", "clk_entry", new String[] { this.jdField_a_of_type_Bcdx.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Bbxx.a), String.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
      bcjy.a(null, new ReportModelDC02528().module("all_result").action("clk_entry").ver2(bcjy.a(this.jdField_a_of_type_Bbxx.a)).ver3(this.jdField_a_of_type_JavaUtilList.size() + "").ver4(this.jdField_a_of_type_Bcdx.jdField_a_of_type_JavaLangString).ver7("{experiment_id:" + bcjy.b + "}"));
      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      new aokg((QQAppInterface)localObject1).b((QQAppInterface)localObject1, "clk_entry", "all_result", bcjy.a(this.jdField_a_of_type_Bbxx.a), "", this.jdField_a_of_type_Bcdx.jdField_a_of_type_JavaLangString, "{experiment_id:" + bcjy.b + "}");
      bcjy.a(bbxx.a(this.jdField_a_of_type_Bbxx), 0, SearchEntryFragment.a(this.jdField_a_of_type_Bbxx.a), "0X8009D1C", 0, 0, this.jdField_a_of_type_Bcdx.jdField_a_of_type_JavaLangString, null);
      break;
      i = 1;
      MiniAppLauncher.startMiniApp(bbxx.a(this.jdField_a_of_type_Bbxx), (String)localObject1, 2005, null);
      break label172;
      Object localObject2;
      if ((((String)localObject1).startsWith("http://")) || (((String)localObject1).startsWith("https://")))
      {
        localObject2 = new Intent(bbxx.a(this.jdField_a_of_type_Bbxx), QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        bbxx.a(this.jdField_a_of_type_Bbxx).startActivity((Intent)localObject2);
        i = 0;
        break label172;
      }
      if ((bbxx.a(this.jdField_a_of_type_Bbxx) instanceof BaseActivity))
      {
        localObject2 = bhni.a(((BaseActivity)paramView.getContext()).app, bbxx.a(this.jdField_a_of_type_Bbxx), (String)localObject1);
        if (localObject2 != null) {
          ((bhmr)localObject2).a();
        }
        for (;;)
        {
          i = 0;
          break;
          bbxx.a(this.jdField_a_of_type_Bbxx).startActivity(new Intent(bbxx.a(this.jdField_a_of_type_Bbxx), JumpActivity.class).setData(Uri.parse((String)localObject1)));
        }
      }
      bbxx.a(this.jdField_a_of_type_Bbxx).startActivity(new Intent(bbxx.a(this.jdField_a_of_type_Bbxx), JumpActivity.class).setData(Uri.parse((String)localObject1)));
      i = 0;
      break label172;
      label716:
      MiniProgramLpReportDC04239.reportAsync("search", "headentrance", "click", "1");
      continue;
      i = this.jdField_a_of_type_Bbxx.a;
      if (this.jdField_a_of_type_Bbxx.a == 3) {
        i = 21;
      }
      ActiveEntitySearchActivity.a(bbxx.a(this.jdField_a_of_type_Bbxx), this.jdField_a_of_type_Bcdx.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bcdx.jdField_a_of_type_ArrayOfLong, i);
      if (!bhnv.g(bbxx.a(this.jdField_a_of_type_Bbxx))) {
        QQToast.a(bbxx.a(this.jdField_a_of_type_Bbxx), 0, bbxx.a(this.jdField_a_of_type_Bbxx).getResources().getString(2131717088), 0).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbxy
 * JD-Core Version:    0.7.0.1
 */