import android.os.Handler;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback.1;
import com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback.2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.util.WeakReference;

public class askr
  implements azjj, azkx
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private MessageForPic jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
  private WeakReference<asks> jdField_a_of_type_MqqUtilWeakReference;
  
  public askr(MessageForPic paramMessageForPic, Handler paramHandler, asks paramasks)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = paramMessageForPic;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramasks);
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, azkf paramazkf)
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() == null) {
      QLog.d("EmotionDownGIFCallback", 1, "onDownload fail, callback is null");
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EmotionDownGIFCallback", 2, new Object[] { "onDownload ", Integer.valueOf(paramazkf.jdField_a_of_type_Int) });
      }
      if (paramazkf.jdField_a_of_type_Int == 0)
      {
        ((asks)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(true, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
        return;
      }
    } while (-1 != paramazkf.jdField_a_of_type_Int);
    if (paramazkf.jdField_a_of_type_Azkb != null) {
      QLog.d("EmotionDownGIFCallback", 1, new Object[] { "onDownloadFail errDec:", paramazkf.jdField_a_of_type_Azkb.b });
    }
    ((asks)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(false, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
  }
  
  public void a(int paramInt, ArrayList<azkf> paramArrayList) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new EmotionDownGIFCallback.2(this, paramInt));
  }
  
  public void a(azjk paramazjk)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new EmotionDownGIFCallback.1(this, paramazjk));
  }
  
  public void a_(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionDownGIFCallback", 2, new Object[] { "onUpdateProgress:", paramInt + " needRefresh:" + paramBoolean, " picMr:", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uniseq) });
    }
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() != null) {
      ((asks)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramInt, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
    }
  }
  
  public void b(int paramInt, azkf paramazkf) {}
  
  public void c(int paramInt, azkf paramazkf) {}
  
  public void d(int paramInt, azkf paramazkf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     askr
 * JD-Core Version:    0.7.0.1
 */