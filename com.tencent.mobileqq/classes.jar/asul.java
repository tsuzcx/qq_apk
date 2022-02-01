import android.os.Handler;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback.1;
import com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback.2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.util.WeakReference;

public class asul
  implements azpp, azrd
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private MessageForPic jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
  private WeakReference<asum> jdField_a_of_type_MqqUtilWeakReference;
  
  public asul(MessageForPic paramMessageForPic, Handler paramHandler, asum paramasum)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = paramMessageForPic;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramasum);
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, azql paramazql)
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() == null) {
      QLog.d("EmotionDownGIFCallback", 1, "onDownload fail, callback is null");
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EmotionDownGIFCallback", 2, new Object[] { "onDownload ", Integer.valueOf(paramazql.jdField_a_of_type_Int) });
      }
      if (paramazql.jdField_a_of_type_Int == 0)
      {
        ((asum)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(true, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
        return;
      }
    } while (-1 != paramazql.jdField_a_of_type_Int);
    if (paramazql.jdField_a_of_type_Azqh != null) {
      QLog.d("EmotionDownGIFCallback", 1, new Object[] { "onDownloadFail errDec:", paramazql.jdField_a_of_type_Azqh.b });
    }
    ((asum)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(false, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
  }
  
  public void a(int paramInt, ArrayList<azql> paramArrayList) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new EmotionDownGIFCallback.2(this, paramInt));
  }
  
  public void a(azpq paramazpq)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new EmotionDownGIFCallback.1(this, paramazpq));
  }
  
  public void a_(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionDownGIFCallback", 2, new Object[] { "onUpdateProgress:", paramInt + " needRefresh:" + paramBoolean, " picMr:", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uniseq) });
    }
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() != null) {
      ((asum)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramInt, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
    }
  }
  
  public void b(int paramInt, azql paramazql) {}
  
  public void c(int paramInt, azql paramazql) {}
  
  public void d(int paramInt, azql paramazql) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asul
 * JD-Core Version:    0.7.0.1
 */