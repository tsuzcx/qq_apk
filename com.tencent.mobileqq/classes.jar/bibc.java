import com.tencent.vas.update.callback.listener.IUpdateListener;
import com.tencent.vas.update.entity.UpdateListenerParams;

final class bibc
  implements IUpdateListener
{
  bibc(String paramString) {}
  
  public void onLoadFail(UpdateListenerParams paramUpdateListenerParams) {}
  
  public void onLoadSuccess(UpdateListenerParams paramUpdateListenerParams)
  {
    bibb.a(this.a);
  }
  
  public void onProgress(UpdateListenerParams paramUpdateListenerParams) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bibc
 * JD-Core Version:    0.7.0.1
 */