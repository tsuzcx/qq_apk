import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment;

public class avlb
  implements View.OnClickListener
{
  public avlb(AssociateSearchWordsFragment paramAssociateSearchWordsFragment) {}
  
  public void onClick(View paramView)
  {
    FragmentActivity localFragmentActivity;
    Object localObject;
    if (paramView.getTag() != null)
    {
      localFragmentActivity = this.a.getActivity();
      localObject = (Integer)paramView.getTag(2131313374);
      paramView = (avld)paramView.getTag(2131313373);
      switch (paramView.jdField_a_of_type_Int)
      {
      }
    }
    do
    {
      do
      {
        return;
      } while (!(localFragmentActivity instanceof avle));
      Intent localIntent = new Intent(localFragmentActivity, QQBrowserActivity.class);
      localObject = paramView.e;
      paramView = (View)localObject;
      if (!((String)localObject).startsWith("http")) {
        paramView = "http://" + (String)localObject;
      }
      localIntent.putExtra("url", paramView);
      localFragmentActivity.startActivity(localIntent);
      localFragmentActivity.finish();
      return;
    } while (!(localFragmentActivity instanceof avle));
    ((avle)localFragmentActivity).a(paramView.jdField_a_of_type_JavaLangString, paramView.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avlb
 * JD-Core Version:    0.7.0.1
 */