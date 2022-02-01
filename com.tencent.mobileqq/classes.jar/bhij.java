import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;

public class bhij
  extends bmts
{
  private MQLruCache<String, Object> a;
  
  public bhij(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public MQLruCache<String, Object> a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.a = new bhik(this, paramInt);
    this.a.setLargeSize(1);
  }
  
  public void c()
  {
    super.c();
    if (this.a != null)
    {
      Iterator localIterator = this.a.getLargeCache().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = this.a.get(str);
        if ((localObject != null) && ((localObject instanceof Bitmap)))
        {
          ((Bitmap)localObject).recycle();
          QZLog.i("DIYProfileTemplate.DIYLottieLoader", 4, "recycle bitmap key = " + str);
        }
      }
      this.a.releaseLargeCache();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhij
 * JD-Core Version:    0.7.0.1
 */