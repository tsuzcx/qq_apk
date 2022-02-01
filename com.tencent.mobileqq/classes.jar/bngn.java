import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.qzone.util.QZLog;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicDefault.7.1;
import mqq.util.WeakReference;

public class bngn
  implements wiw
{
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt == 0)
    {
      QZLog.d("PhotoListActivity", 2, new Object[] { "encode video cost time = ", Long.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long) });
      ThreadManager.postImmediately(new AEPhotoListLogicDefault.7.1(this), null, true);
      return;
    }
    paramString1 = Message.obtain();
    paramString1.what = 2;
    paramString1.obj = Integer.valueOf(paramInt);
    ((bnfn)this.jdField_a_of_type_Bngh.a.get()).a.sendMessage(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bngn
 * JD-Core Version:    0.7.0.1
 */