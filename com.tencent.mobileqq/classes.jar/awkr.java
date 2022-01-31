import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.search.fragment.ActiveEntitySearchFragment;

class awkr
  implements View.OnClickListener
{
  awkr(awkq paramawkq, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_Awkq.a.getActivity(), QQBrowserActivity.class);
    paramView.putExtra("url", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Awkq.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awkr
 * JD-Core Version:    0.7.0.1
 */