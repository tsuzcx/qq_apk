import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendFragment;

public class asoz
  implements asut
{
  public asoz(ExtendFriendFragment paramExtendFriendFragment) {}
  
  public void a(int paramInt)
  {
    anri localanri = (anri)ExtendFriendFragment.a(this.a).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
    if (localanri != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("birthday", paramInt);
      localanri.a(localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asoz
 * JD-Core Version:    0.7.0.1
 */