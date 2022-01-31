import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.homework.recite.data.ArticleInfo;
import com.tencent.mobileqq.troop.homework.recite.ui.SelectReciteParagraphFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.json.JSONException;

public class bbyt
  implements View.OnClickListener
{
  public bbyt(SelectReciteParagraphFragment paramSelectReciteParagraphFragment) {}
  
  public void onClick(View paramView)
  {
    try
    {
      if (!this.a.jdField_a_of_type_JavaUtilSet.isEmpty())
      {
        paramView = new ArrayList(this.a.jdField_a_of_type_JavaUtilSet);
        SelectReciteParagraphFragment.a(this.a, bbzr.a(this.a.c, this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.title, this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.kid, paramView, this.a.jdField_a_of_type_Bbyu.getCount()));
        this.a.getActivity().finish();
        bdaj.a("Grp_edu", "Grp_recite", "Clk_Success", 0, 0, new String[] { this.a.c, String.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.type - 1) });
        String str1 = this.a.c;
        String str2 = this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.title;
        if (paramView != null) {}
        int i;
        for (paramView = String.valueOf(paramView.size());; paramView = String.valueOf(i))
        {
          bdaj.a("Grp_edu", "Grp_recite", "Section_Count", 0, 0, new String[] { str1, str2, paramView });
          return;
          i = this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.size();
        }
      }
      return;
    }
    catch (JSONException paramView)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SelectReciteParagraphFragment", 2, paramView, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbyt
 * JD-Core Version:    0.7.0.1
 */