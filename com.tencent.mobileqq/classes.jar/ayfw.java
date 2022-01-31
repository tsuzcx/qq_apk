import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.AssociateItem;

public class ayfw
  implements View.OnClickListener
{
  public ayfw(AssociateSearchWordsFragment paramAssociateSearchWordsFragment) {}
  
  public void onClick(View paramView)
  {
    FragmentActivity localFragmentActivity;
    Object localObject;
    if (paramView.getTag() != null)
    {
      localFragmentActivity = this.a.getActivity();
      localObject = (Integer)paramView.getTag(2131379914);
      localObject = (AssociateSearchWordsFragment.AssociateItem)paramView.getTag(2131379913);
      switch (((AssociateSearchWordsFragment.AssociateItem)localObject).jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      return;
      if ((localFragmentActivity instanceof ayfz))
      {
        Intent localIntent = new Intent(localFragmentActivity, QQBrowserActivity.class);
        localObject = ((AssociateSearchWordsFragment.AssociateItem)localObject).e;
        paramView = (View)localObject;
        if (!((String)localObject).startsWith("http")) {
          paramView = "http://" + (String)localObject;
        }
        localIntent.putExtra("url", paramView);
        localFragmentActivity.startActivity(localIntent);
        localFragmentActivity.finish();
        return;
        if ((localFragmentActivity instanceof ayfz)) {
          paramView = (ayfz)localFragmentActivity;
        }
        while (paramView != null)
        {
          paramView.a(((AssociateSearchWordsFragment.AssociateItem)localObject).jdField_a_of_type_JavaLangString, ((AssociateSearchWordsFragment.AssociateItem)localObject).d);
          return;
          if (AssociateSearchWordsFragment.a(this.a) != null) {
            paramView = AssociateSearchWordsFragment.a(this.a);
          } else {
            paramView = null;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayfw
 * JD-Core Version:    0.7.0.1
 */