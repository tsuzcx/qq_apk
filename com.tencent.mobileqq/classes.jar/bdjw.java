import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.QQCustomArkDialogForAio.2.1;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class bdjw
  implements ArkViewImplement.LoadCallback
{
  bdjw(bdju parambdju) {}
  
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    onLoadState(paramInt1);
  }
  
  public void onLoadState(int paramInt)
  {
    WeakReference localWeakReference = new WeakReference(this.a);
    ThreadManager.getUIHandler().post(new QQCustomArkDialogForAio.2.1(this, localWeakReference, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdjw
 * JD-Core Version:    0.7.0.1
 */