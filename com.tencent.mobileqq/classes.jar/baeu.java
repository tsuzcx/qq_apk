import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.QQCustomArkDialog.2.1;
import com.tencent.mobileqq.utils.QQCustomArkDialog.2.2;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class baeu
  implements ArkViewImplement.LoadCallback
{
  baeu(baes parambaes) {}
  
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    onLoadState(paramInt1);
  }
  
  public void onLoadState(int paramInt)
  {
    ThreadManager.getUIHandler().post(new QQCustomArkDialog.2.1(this, paramInt));
    if (paramInt == 0) {}
    do
    {
      return;
      baes.a(this.a, true);
      if (QLog.isColorLevel()) {
        QLog.d("QQCustomArkDialog", 2, new Object[] { "arkView init finish,load state = ", Integer.valueOf(paramInt), ";outsideShowDialog = ", Boolean.valueOf(baes.a(this.a)), ";alreadyShowDialog:", Boolean.valueOf(baes.b(this.a)) });
      }
    } while (!baes.a(this.a));
    ThreadManager.getUIHandler().post(new QQCustomArkDialog.2.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baeu
 * JD-Core Version:    0.7.0.1
 */