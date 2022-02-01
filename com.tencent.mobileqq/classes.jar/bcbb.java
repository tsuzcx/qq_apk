import com.tencent.mobileqq.imcore.proxy.RecentRoute.QQTextProxy.Proxy;
import com.tencent.mobileqq.text.AbsQQText;
import com.tencent.mobileqq.text.QQText;

public final class bcbb
  implements RecentRoute.QQTextProxy.Proxy
{
  public AbsQQText generalQQText(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    return new QQText(paramCharSequence, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcbb
 * JD-Core Version:    0.7.0.1
 */