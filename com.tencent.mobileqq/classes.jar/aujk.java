import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.filemanageraux.fileviewer.FileView.TdsDebugView;
import java.lang.ref.WeakReference;

public final class aujk
  implements Handler.Callback
{
  private final WeakReference<TdsDebugView> a;
  
  private aujk(TdsDebugView paramTdsDebugView)
  {
    this.a = new WeakReference(paramTdsDebugView);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    TdsDebugView localTdsDebugView = (TdsDebugView)this.a.get();
    if (localTdsDebugView == null) {
      return true;
    }
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 1: 
      TdsDebugView.a(localTdsDebugView, (String)paramMessage.obj, paramMessage.arg1);
      return true;
    case 2: 
      TdsDebugView.b(localTdsDebugView, (String)paramMessage.obj, paramMessage.arg1);
      return true;
    }
    TdsDebugView.c(localTdsDebugView, (String)paramMessage.obj, paramMessage.arg1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aujk
 * JD-Core Version:    0.7.0.1
 */