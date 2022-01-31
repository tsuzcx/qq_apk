import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment;
import com.tencent.mobileqq.search.report.ReportModelDC02528;

class aykk
  implements View.OnClickListener
{
  aykk(aykj paramaykj, String paramString, int paramInt) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_Aykj.a.getActivity();
    if ((this.jdField_a_of_type_Aykj.a.getActivity() instanceof ayki))
    {
      paramView = (ayki)paramView;
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      aysc.a(null, new ReportModelDC02528().module("all_search").action("clk_frame_up").ver1(this.jdField_a_of_type_JavaLangString).ver2("kandian").ver3(UniteSearchActivity.d).ver4(this.jdField_a_of_type_Aykj.a.jdField_a_of_type_JavaLangString).ver5(this.jdField_a_of_type_Int / 2 + 1 + "").ver6(UniteSearchActivity.c).session_id(UniteSearchActivity.e));
    }
    for (;;)
    {
      if (paramView != null) {
        paramView.c(this.jdField_a_of_type_JavaLangString);
      }
      return;
      if (AssociateSearchWordsFragment.a(this.jdField_a_of_type_Aykj.a) != null) {
        paramView = AssociateSearchWordsFragment.a(this.jdField_a_of_type_Aykj.a);
      } else {
        paramView = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aykk
 * JD-Core Version:    0.7.0.1
 */