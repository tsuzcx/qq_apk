import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class apkg
  extends baua
{
  apkg(apkf paramapkf, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = (baoj)paramMessage.obj;
    if ((localObject == null) || (((baoj)localObject).c != this.a.a())) {}
    do
    {
      do
      {
        do
        {
          return;
          switch (paramMessage.what)
          {
          case 1002: 
          case 1006: 
          case 1007: 
          default: 
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.d("FavroamingManager", 2, "start uploadFace favEmoticon");
        return;
        if (QLog.isColorLevel()) {
          QLog.d("FavroamingManager", 2, "finish uploadFace favEmoticon resId=" + ((baoj)localObject).g);
        }
      } while (this.a.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet() < this.a.jdField_b_of_type_Int);
      this.a.f();
      return;
      if (apkf.a(this.a) == null)
      {
        QLog.e("FavroamingManager", 1, "app is null");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "STATUS_SEND_AND_SAVE_FINISHED resId=" + ((baoj)localObject).g);
      }
      paramMessage = ((apke)this.a.a()).a(((baoj)localObject).g);
      localObject = (alnm)apkf.b(this.a).a(72);
    } while ((localObject == null) || (paramMessage == null) || (paramMessage.isMarkFace));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramMessage);
    ((alnm)localObject).a(localArrayList, 1);
    return;
    QLog.i("FavroamingManager", 1, "upload fav error:" + ((baoj)localObject).g);
    if (apkf.c(this.a) != null) {}
    for (int i = bdee.b(apkf.d(this.a).getApplication());; i = -1)
    {
      bdqr.a("emotionType", "emotionActionFav", "4", "", "", i + "", ((baoj)localObject).g, "", "", "");
      return;
      QLog.i("FavroamingManager", 1, "upload fav cancel:" + ((baoj)localObject).g);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apkg
 * JD-Core Version:    0.7.0.1
 */