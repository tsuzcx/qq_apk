import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class anci
  extends axvs
{
  anci(anch paramanch, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = (axqf)paramMessage.obj;
    if ((localObject == null) || (((axqf)localObject).c != this.a.a())) {}
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
          QLog.d("FavroamingManager", 2, "finish uploadFace favEmoticon resId=" + ((axqf)localObject).g);
        }
      } while (this.a.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet() < this.a.jdField_b_of_type_Int);
      this.a.f();
      return;
      if (anch.a(this.a) == null)
      {
        QLog.e("FavroamingManager", 1, "app is null");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "STATUS_SEND_AND_SAVE_FINISHED resId=" + ((axqf)localObject).g);
      }
      paramMessage = ((ancg)this.a.a()).a(((axqf)localObject).g);
      localObject = (ajhx)anch.b(this.a).a(72);
    } while ((localObject == null) || (paramMessage == null) || (paramMessage.isMarkFace));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramMessage);
    ((ajhx)localObject).a(localArrayList, 1);
    return;
    QLog.i("FavroamingManager", 1, "upload fav error:" + ((axqf)localObject).g);
    if (anch.c(this.a) != null) {}
    for (int i = badq.b(anch.d(this.a).getApplication());; i = -1)
    {
      bapm.a("emotionType", "emotionActionFav", "4", "", "", i + "", ((axqf)localObject).g, "", "", "");
      return;
      QLog.i("FavroamingManager", 1, "upload fav cancel:" + ((axqf)localObject).g);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anci
 * JD-Core Version:    0.7.0.1
 */