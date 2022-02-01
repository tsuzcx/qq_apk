import android.view.View;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.ProfileCardExtendFriendView;

public class bhzt
  implements bkhw
{
  public bhzt(ProfileCardExtendFriendView paramProfileCardExtendFriendView) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((ProfileCardExtendFriendView.c(this.a)) && (!ProfileCardExtendFriendView.d(this.a))) {
      if (paramInt == 0)
      {
        this.a.a(false, true);
        VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "card_actionsheet", "", 0, "", "1");
      }
    }
    for (;;)
    {
      VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "card_actionsheet", "", 0, "", "4");
      ProfileCardExtendFriendView.a(this.a).cancel();
      return;
      if ((!ProfileCardExtendFriendView.c(this.a)) && (ProfileCardExtendFriendView.d(this.a)))
      {
        if (paramInt == 0)
        {
          this.a.a(true, false);
          VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "card_actionsheet", "", 0, "", "2");
        }
      }
      else if ((ProfileCardExtendFriendView.d(this.a)) && (ProfileCardExtendFriendView.c(this.a)))
      {
        if (paramInt == 0)
        {
          this.a.a(false, true);
          VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "card_actionsheet", "", 0, "", "1");
        }
        else if (paramInt == 1)
        {
          this.a.a(true, false);
          VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "card_actionsheet", "", 0, "", "2");
        }
      }
      else if ((!ProfileCardExtendFriendView.c(this.a)) && (!ProfileCardExtendFriendView.d(this.a)) && (paramInt == 0))
      {
        this.a.a(false, false);
        VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "card_actionsheet", "", 0, "", "3");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhzt
 * JD-Core Version:    0.7.0.1
 */