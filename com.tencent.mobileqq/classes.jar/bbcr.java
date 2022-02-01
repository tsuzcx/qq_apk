import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class bbcr
  implements View.OnClickListener
{
  bbcr(bbcm parambbcm, bazm parambazm, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Bazm.m))
    {
      Object localObject = bbgh.a(this.jdField_a_of_type_Bazm.a(), 0, bbda.a(this.jdField_a_of_type_Bazm.c));
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", (String)localObject);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      localObject = new StringBuilder();
      int i = 0;
      if (i < this.jdField_a_of_type_Bazm.a.size())
      {
        if (i != this.jdField_a_of_type_Bazm.a.size() - 1) {
          ((StringBuilder)localObject).append(((bayz)this.jdField_a_of_type_Bazm.a.get(i)).b).append("::");
        }
        for (;;)
        {
          i += 1;
          break;
          ((StringBuilder)localObject).append(((bayz)this.jdField_a_of_type_Bazm.a.get(i)).b);
        }
      }
      bbda.a(null, new ReportModelDC02528().module("all_result").action("clk_web_search").obj1("2073745984").ver1(this.jdField_a_of_type_Bazm.g).ver2(bbda.a(UniteSearchActivity.d)).ver4(((StringBuilder)localObject).toString()).ver5("1").ver6("2").ver7("{experiment_id:" + bbda.b + "}"));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbcr
 * JD-Core Version:    0.7.0.1
 */