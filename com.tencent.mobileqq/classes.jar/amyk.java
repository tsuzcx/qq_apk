import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.mobileqq.app.QQAppInterface;

public final class amyk
  implements Runnable
{
  public amyk(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    HtmlOffline.b("2036", this.a, true, new amyl(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amyk
 * JD-Core Version:    0.7.0.1
 */