import android.os.Handler;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback.1;
import com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback.2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.util.WeakReference;

public class aody
  implements auna, auon
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private MessageForPic jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
  private WeakReference<aodz> jdField_a_of_type_MqqUtilWeakReference;
  
  public aody(MessageForPic paramMessageForPic, Handler paramHandler, aodz paramaodz)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = paramMessageForPic;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramaodz);
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, aunw paramaunw)
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() == null) {
      QLog.d("EmotionDownGIFCallback", 1, "onDownload fail, callback is null");
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EmotionDownGIFCallback", 2, new Object[] { "onDownload ", Integer.valueOf(paramaunw.jdField_a_of_type_Int) });
      }
      if (paramaunw.jdField_a_of_type_Int == 0)
      {
        ((aodz)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(true, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
        return;
      }
    } while (-1 != paramaunw.jdField_a_of_type_Int);
    if (paramaunw.jdField_a_of_type_Aunr != null) {
      QLog.d("EmotionDownGIFCallback", 1, new Object[] { "onDownloadFail errDec:", paramaunw.jdField_a_of_type_Aunr.b });
    }
    ((aodz)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(false, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
  }
  
  public void a(int paramInt, ArrayList<aunw> paramArrayList) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new EmotionDownGIFCallback.2(this, paramInt));
  }
  
  public void a(aunb paramaunb)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new EmotionDownGIFCallback.1(this, paramaunb));
  }
  
  public void a_(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionDownGIFCallback", 2, new Object[] { "onUpdateProgress:", paramInt + " needRefresh:" + paramBoolean, " picMr:", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uniseq) });
    }
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() != null) {
      ((aodz)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramInt, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
    }
  }
  
  public void b(int paramInt, aunw paramaunw) {}
  
  public void c(int paramInt, aunw paramaunw) {}
  
  public void d(int paramInt, aunw paramaunw) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aody
 * JD-Core Version:    0.7.0.1
 */