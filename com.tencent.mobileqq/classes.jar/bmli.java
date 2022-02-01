import android.os.Handler;
import android.os.Message;

public class bmli
  implements anui
{
  private Handler a;
  
  public bmli(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (this.a == null) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    }
    Handler localHandler = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localHandler.obtainMessage(paramInt, i, 0, paramObject).sendToTarget();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmli
 * JD-Core Version:    0.7.0.1
 */