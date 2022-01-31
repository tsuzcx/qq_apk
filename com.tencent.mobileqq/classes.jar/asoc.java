import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class asoc
  extends alsi
{
  private WeakReference<Context> a;
  
  public asoc(Context paramContext)
  {
    this.a = new WeakReference(paramContext);
  }
  
  protected void a(int paramInt, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont.HiBoomManager", 2, "onHiBoomAuthResult errorCode = " + paramInt);
    }
    Context localContext = (Context)this.a.get();
    if ((paramInt != 0) && (localContext != null)) {
      asnx.a(localContext, paramArrayOfByte, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asoc
 * JD-Core Version:    0.7.0.1
 */