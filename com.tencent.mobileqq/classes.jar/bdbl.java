import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.CameraPreviewObservable.1;

public class bdbl
  extends bczq
{
  public Handler a;
  
  public bdbl(Handler paramHandler)
  {
    if (paramHandler != null)
    {
      this.a = paramHandler;
      return;
    }
    this.a = new Handler(Looper.getMainLooper());
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (this.a == null) {
      return;
    }
    this.a.post(new CameraProxy.CameraPreviewObservable.1(this, paramInt, paramVarArgs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdbl
 * JD-Core Version:    0.7.0.1
 */