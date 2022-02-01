import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bcbz
  implements View.OnClickListener
{
  bcbz(bcby parambcby, String paramString, int paramInt) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_Bcby.a.getActivity();
    if ((this.jdField_a_of_type_Bcby.a.getActivity() instanceof bcbx))
    {
      localObject = (bcbx)localObject;
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      bcjs.a(null, new ReportModelDC02528().module("all_search").action("clk_frame_up").ver1(this.jdField_a_of_type_JavaLangString).ver2("kandian").ver3(UniteSearchActivity.d).ver4(this.jdField_a_of_type_Bcby.a.jdField_a_of_type_JavaLangString).ver5(this.jdField_a_of_type_Int / 2 + 1 + "").ver6(UniteSearchActivity.c).session_id(UniteSearchActivity.e));
    }
    for (;;)
    {
      if (localObject != null) {
        ((bcbx)localObject).c(this.jdField_a_of_type_JavaLangString);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (AssociateSearchWordsFragment.a(this.jdField_a_of_type_Bcby.a) != null) {
        localObject = AssociateSearchWordsFragment.a(this.jdField_a_of_type_Bcby.a);
      } else {
        localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcbz
 * JD-Core Version:    0.7.0.1
 */