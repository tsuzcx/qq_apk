package androidx.loader.content;

import android.database.ContentObserver;
import android.os.Handler;

public final class Loader$ForceLoadContentObserver
  extends ContentObserver
{
  public Loader$ForceLoadContentObserver(Loader paramLoader)
  {
    super(new Handler());
  }
  
  public boolean deliverSelfNotifications()
  {
    return true;
  }
  
  public void onChange(boolean paramBoolean)
  {
    this.this$0.onContentChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.loader.content.Loader.ForceLoadContentObserver
 * JD-Core Version:    0.7.0.1
 */