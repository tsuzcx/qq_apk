import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendGroupFragment;

class anra
  implements View.OnClickListener
{
  anra(anqy paramanqy, ExtendFriendGroupFragment paramExtendFriendGroupFragment) {}
  
  public void onClick(View paramView)
  {
    int j = this.jdField_a_of_type_Anqy.getPosition();
    int i = j;
    if (j > 0) {
      i = j - 1;
    }
    anqy.a(this.jdField_a_of_type_Anqy).a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anra
 * JD-Core Version:    0.7.0.1
 */