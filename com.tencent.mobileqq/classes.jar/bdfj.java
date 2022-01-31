import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.QQCustomArkDialog.2.1;
import com.tencent.mobileqq.utils.QQCustomArkDialog.2.2;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class bdfj
  implements ArkViewImplement.LoadCallback
{
  bdfj(bdfh parambdfh) {}
  
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    onLoadState(paramInt1);
  }
  
  public void onLoadState(int paramInt)
  {
    WeakReference localWeakReference = new WeakReference(this.a);
    ThreadManager.getUIHandler().post(new QQCustomArkDialog.2.1(this, localWeakReference, paramInt));
    if (paramInt == 0) {}
    do
    {
      return;
      bdfh.a(this.a, true);
      if (QLog.isColorLevel()) {
        QLog.d("QQCustomArkDialog", 2, new Object[] { "arkView init finish,load state = ", Integer.valueOf(paramInt), ";outsideShowDialog = ", Boolean.valueOf(bdfh.a(this.a)), ";alreadyShowDialog:", Boolean.valueOf(bdfh.b(this.a)) });
      }
    } while (!bdfh.a(this.a));
    ThreadManager.getUIHandler().post(new QQCustomArkDialog.2.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdfj
 * JD-Core Version:    0.7.0.1
 */