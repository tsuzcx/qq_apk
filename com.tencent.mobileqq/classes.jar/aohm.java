import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendGroupFragment;

class aohm
  implements View.OnClickListener
{
  aohm(aohk paramaohk, ExtendFriendGroupFragment paramExtendFriendGroupFragment) {}
  
  public void onClick(View paramView)
  {
    int j = this.jdField_a_of_type_Aohk.getPosition();
    int i = j;
    if (j > 0) {
      i = j - 1;
    }
    aohk.a(this.jdField_a_of_type_Aohk).a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aohm
 * JD-Core Version:    0.7.0.1
 */