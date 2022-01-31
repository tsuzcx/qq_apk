import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;

public class azxi
  implements View.OnClickListener
{
  public azxi(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(4) >= 6)
    {
      bcql.a(this.a.getActivity(), String.format(ajya.a(2131708851), new Object[] { Integer.valueOf(6) }), 0).a();
      return;
    }
    ((InputMethodManager)this.a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.a.jdField_a_of_type_AndroidViewViewGroup.getWindowToken(), 0);
    this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.b();
    SearchReciteArticleFragment.a(this.a.getActivity(), this.a.b);
    bbbp.a("Grp_edu", "Grp_recite", "Assign_Clk", 0, 0, new String[] { this.a.b });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azxi
 * JD-Core Version:    0.7.0.1
 */