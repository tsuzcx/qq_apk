import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment;

public class aoix
  implements aola
{
  public aoix(ExtendFriendSquareFragment paramExtendFriendSquareFragment) {}
  
  public void a(String paramString, int paramInt)
  {
    if (!paramString.equals(ExtendFriendSquareFragment.a(this.a)))
    {
      ExtendFriendSquareFragment.a(this.a, paramString);
      if (!aoeu.a.equals(ExtendFriendSquareFragment.a(this.a))) {
        break label187;
      }
      ExtendFriendSquareFragment.a(this.a, false);
    }
    label187:
    for (boolean bool1 = ExtendFriendSquareFragment.f(this.a);; bool1 = false)
    {
      boolean bool2 = ExtendFriendSquareFragment.a(this.a, false, paramString);
      long l = Math.abs(System.currentTimeMillis() - ExtendFriendSquareFragment.b(this.a));
      if ((!bool2) || (l > 60000L) || (bool1))
      {
        ExtendFriendSquareFragment.b(this.a, false);
        this.a.a.a();
        this.a.a.notifyDataSetChanged();
        this.a.a.a(false);
        ExtendFriendSquareFragment.a(this.a);
        ExtendFriendSquareFragment.a(this.a).removeMessages(11);
        ExtendFriendSquareFragment.a(this.a).sendEmptyMessageDelayed(11, 500L);
        return;
      }
      ExtendFriendSquareFragment.b(this.a, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aoix
 * JD-Core Version:    0.7.0.1
 */