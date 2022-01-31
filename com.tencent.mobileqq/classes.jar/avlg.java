import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment;
import com.tencent.mobileqq.search.report.ReportModelDC02528;

class avlg
  implements View.OnClickListener
{
  avlg(avlf paramavlf, String paramString, int paramInt) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_Avlf.a.getActivity();
    if ((this.jdField_a_of_type_Avlf.a.getActivity() instanceof avle))
    {
      ((avle)paramView).c(this.jdField_a_of_type_JavaLangString);
      paramView = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      avsv.a(null, new ReportModelDC02528().module("all_search").action("clk_frame_up").ver1(this.jdField_a_of_type_JavaLangString).ver2("kandian").ver3(UniteSearchActivity.d).ver4(this.jdField_a_of_type_Avlf.a.jdField_a_of_type_JavaLangString).ver5(this.jdField_a_of_type_Int / 2 + 1 + "").ver6(UniteSearchActivity.c).session_id(UniteSearchActivity.e));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avlg
 * JD-Core Version:    0.7.0.1
 */