import android.view.View;
import com.tencent.mobileqq.widget.ProfileCardExtendFriendView;

public class besm
  implements bhuk
{
  public besm(ProfileCardExtendFriendView paramProfileCardExtendFriendView) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((ProfileCardExtendFriendView.c(this.a)) && (!ProfileCardExtendFriendView.d(this.a))) {
      if (paramInt == 0) {
        this.a.a(false, true);
      }
    }
    for (;;)
    {
      ProfileCardExtendFriendView.a(this.a).cancel();
      return;
      if ((!ProfileCardExtendFriendView.c(this.a)) && (ProfileCardExtendFriendView.d(this.a)))
      {
        if (paramInt == 0) {
          this.a.a(true, false);
        }
      }
      else if ((ProfileCardExtendFriendView.d(this.a)) && (ProfileCardExtendFriendView.c(this.a)))
      {
        if (paramInt == 0) {
          this.a.a(false, true);
        } else if (paramInt == 1) {
          this.a.a(true, false);
        }
      }
      else if ((!ProfileCardExtendFriendView.c(this.a)) && (!ProfileCardExtendFriendView.d(this.a)) && (paramInt == 0)) {
        this.a.a(false, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     besm
 * JD-Core Version:    0.7.0.1
 */