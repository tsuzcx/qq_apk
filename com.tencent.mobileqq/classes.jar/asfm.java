import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class asfm
  extends TransProcessorHandler
{
  asfm(asfl paramasfl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = (FileMsg)paramMessage.obj;
    if ((localObject == null) || (((FileMsg)localObject).commandId != this.a.a())) {}
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
          QLog.d("FavroamingManager", 2, "finish uploadFace favEmoticon resId=" + ((FileMsg)localObject).serverPath);
        }
      } while (this.a.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet() < this.a.jdField_b_of_type_Int);
      this.a.f();
      return;
      if (asfl.a(this.a) == null)
      {
        QLog.e("FavroamingManager", 1, "app is null");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "STATUS_SEND_AND_SAVE_FINISHED resId=" + ((FileMsg)localObject).serverPath);
      }
      paramMessage = ((asfk)this.a.a()).a(((FileMsg)localObject).serverPath);
      localObject = (anua)asfl.b(this.a).getBusinessHandler(BusinessHandlerFactory.FAVEMO_ROAMING_HANDLER);
    } while ((localObject == null) || (paramMessage == null) || (paramMessage.isMarkFace));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramMessage);
    ((anua)localObject).a(localArrayList, 1);
    return;
    QLog.i("FavroamingManager", 1, "upload fav error:" + ((FileMsg)localObject).serverPath);
    if (asfl.c(this.a) != null) {}
    for (int i = NetworkUtil.getNetworkType(asfl.d(this.a).getApplication());; i = -1)
    {
      bhpl.a("emotionType", "emotionActionFav", "4", "", "", i + "", ((FileMsg)localObject).serverPath, "", "", "");
      return;
      QLog.i("FavroamingManager", 1, "upload fav cancel:" + ((FileMsg)localObject).serverPath);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asfm
 * JD-Core Version:    0.7.0.1
 */