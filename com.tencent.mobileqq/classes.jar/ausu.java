import android.os.Message;
import com.tencent.kwstudio.office.base.Log;
import com.tencent.kwstudio.office.debug.Debugger.IDebugCallback;
import com.tencent.mobileqq.filemanageraux.fileviewer.FileView.TdsDebugView;
import java.lang.ref.WeakReference;

public final class ausu
  implements Debugger.IDebugCallback
{
  private final WeakReference<TdsDebugView> a;
  
  private ausu(TdsDebugView paramTdsDebugView)
  {
    this.a = new WeakReference(paramTdsDebugView);
  }
  
  public void onCleanCache(String paramString, int paramInt)
  {
    Log.d("TdsDebugView", "onCleanCache: m=" + paramString + ", r=" + paramInt);
    TdsDebugView localTdsDebugView = (TdsDebugView)this.a.get();
    if (localTdsDebugView == null) {
      return;
    }
    Message.obtain(TdsDebugView.a(localTdsDebugView), 3, paramInt, 0, paramString).sendToTarget();
  }
  
  public void onCleanPlugin(String paramString, int paramInt)
  {
    Log.d("TdsDebugView", "onCleanPlugin: m=" + paramString + ", r=" + paramInt);
    TdsDebugView localTdsDebugView = (TdsDebugView)this.a.get();
    if (localTdsDebugView == null) {
      return;
    }
    Message.obtain(TdsDebugView.a(localTdsDebugView), 1, paramInt, 0, paramString).sendToTarget();
  }
  
  public void onUpgradePlugin(String paramString, int paramInt)
  {
    Log.d("TdsDebugView", "onUpgradePlugin: m=" + paramString + ", r=" + paramInt);
    TdsDebugView localTdsDebugView = (TdsDebugView)this.a.get();
    if (localTdsDebugView == null) {
      return;
    }
    Message.obtain(TdsDebugView.a(localTdsDebugView), 2, paramInt, 0, paramString).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ausu
 * JD-Core Version:    0.7.0.1
 */