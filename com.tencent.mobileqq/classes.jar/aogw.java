import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment.ExtendFriendInfo;

public class aogw
  extends aoeu
{
  public aogw(ExtendFriendEditFragment paramExtendFriendEditFragment) {}
  
  protected void a(boolean paramBoolean, aogh paramaogh, int paramInt)
  {
    if ((paramBoolean) && (paramaogh != null)) {
      this.a.a.a(ExtendFriendEditFragment.a(this.a).app, paramaogh);
    }
  }
  
  protected void a(boolean paramBoolean, Card paramCard)
  {
    super.a(paramBoolean, paramCard);
    if (paramBoolean)
    {
      paramCard = new ExtendFriendProfileEditFragment.ExtendFriendInfo(paramCard);
      if ((TextUtils.isEmpty(paramCard.a)) && (TextUtils.isEmpty(paramCard.b)))
      {
        ExtendFriendEditFragment.a(this.a, true);
        this.a.a.a(paramCard);
      }
    }
    for (;;)
    {
      ExtendFriendEditFragment.a(this.a).dismiss();
      return;
      ExtendFriendEditFragment.a(this.a, false);
      break;
      bcpw.a(ExtendFriendEditFragment.a(this.a), "获取QQ扩列信息失败", 0).a();
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (paramBoolean)
    {
      ExtendFriendEditFragment.a(this.a).dismiss();
      ExtendFriendEditFragment.a(this.a).setResult(8193);
      if (ExtendFriendEditFragment.a(this.a) != null) {
        ExtendFriendEditFragment.a(this.a).finish();
      }
      return;
    }
    ExtendFriendEditFragment.a(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aogw
 * JD-Core Version:    0.7.0.1
 */