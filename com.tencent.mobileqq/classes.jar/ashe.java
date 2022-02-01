import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class ashe
  extends beyf
{
  ashe(ashd paramashd, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = (bete)paramMessage.obj;
    if ((localObject == null) || (((bete)localObject).c != this.a.a())) {}
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
          QLog.d("FavroamingManager", 2, "finish uploadFace favEmoticon resId=" + ((bete)localObject).g);
        }
      } while (this.a.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet() < this.a.jdField_b_of_type_Int);
      this.a.f();
      return;
      if (ashd.a(this.a) == null)
      {
        QLog.e("FavroamingManager", 1, "app is null");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "STATUS_SEND_AND_SAVE_FINISHED resId=" + ((bete)localObject).g);
      }
      paramMessage = ((ashc)this.a.a()).a(((bete)localObject).g);
      localObject = (anxd)ashd.b(this.a).a(72);
    } while ((localObject == null) || (paramMessage == null) || (paramMessage.isMarkFace));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramMessage);
    ((anxd)localObject).a(localArrayList, 1);
    return;
    QLog.i("FavroamingManager", 1, "upload fav error:" + ((bete)localObject).g);
    if (ashd.c(this.a) != null) {}
    for (int i = bhnv.b(ashd.d(this.a).getApplication());; i = -1)
    {
      biah.a("emotionType", "emotionActionFav", "4", "", "", i + "", ((bete)localObject).g, "", "", "");
      return;
      QLog.i("FavroamingManager", 1, "upload fav cancel:" + ((bete)localObject).g);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ashe
 * JD-Core Version:    0.7.0.1
 */