import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class anst
  extends ayvz
{
  anst(anss paramanss, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = (ayqm)paramMessage.obj;
    if ((localObject == null) || (((ayqm)localObject).c != this.a.a())) {}
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
          QLog.d("FavroamingManager", 2, "finish uploadFace favEmoticon resId=" + ((ayqm)localObject).g);
        }
      } while (this.a.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet() < this.a.jdField_b_of_type_Int);
      this.a.f();
      return;
      if (anss.a(this.a) == null)
      {
        QLog.e("FavroamingManager", 1, "app is null");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "STATUS_SEND_AND_SAVE_FINISHED resId=" + ((ayqm)localObject).g);
      }
      paramMessage = ((ansr)this.a.a()).a(((ayqm)localObject).g);
      localObject = (ajwa)anss.b(this.a).a(72);
    } while ((localObject == null) || (paramMessage == null) || (paramMessage.isMarkFace));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramMessage);
    ((ajwa)localObject).a(localArrayList, 1);
    return;
    QLog.i("FavroamingManager", 1, "upload fav error:" + ((ayqm)localObject).g);
    if (anss.c(this.a) != null) {}
    for (int i = bbev.b(anss.d(this.a).getApplication());; i = -1)
    {
      bbrj.a("emotionType", "emotionActionFav", "4", "", "", i + "", ((ayqm)localObject).g, "", "", "");
      return;
      QLog.i("FavroamingManager", 1, "upload fav cancel:" + ((ayqm)localObject).g);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anst
 * JD-Core Version:    0.7.0.1
 */