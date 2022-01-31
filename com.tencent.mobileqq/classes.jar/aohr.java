import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendGroupFragment;

class aohr
  implements View.OnClickListener
{
  aohr(aohp paramaohp, ExtendFriendGroupFragment paramExtendFriendGroupFragment) {}
  
  public void onClick(View paramView)
  {
    int j = this.jdField_a_of_type_Aohp.getPosition();
    int i = j;
    if (j > 0) {
      i = j - 1;
    }
    aohp.a(this.jdField_a_of_type_Aohp).a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aohr
 * JD-Core Version:    0.7.0.1
 */