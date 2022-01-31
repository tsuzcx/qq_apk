import android.os.Handler;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback.1;
import com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback.2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.util.WeakReference;

public class apwa
  implements aweh, awfv
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private MessageForPic jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
  private WeakReference<apwb> jdField_a_of_type_MqqUtilWeakReference;
  
  public apwa(MessageForPic paramMessageForPic, Handler paramHandler, apwb paramapwb)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = paramMessageForPic;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramapwb);
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, awfd paramawfd)
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() == null) {
      QLog.d("EmotionDownGIFCallback", 1, "onDownload fail, callback is null");
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EmotionDownGIFCallback", 2, new Object[] { "onDownload ", Integer.valueOf(paramawfd.jdField_a_of_type_Int) });
      }
      if (paramawfd.jdField_a_of_type_Int == 0)
      {
        ((apwb)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(true, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
        return;
      }
    } while (-1 != paramawfd.jdField_a_of_type_Int);
    if (paramawfd.jdField_a_of_type_Awey != null) {
      QLog.d("EmotionDownGIFCallback", 1, new Object[] { "onDownloadFail errDec:", paramawfd.jdField_a_of_type_Awey.b });
    }
    ((apwb)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(false, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
  }
  
  public void a(int paramInt, ArrayList<awfd> paramArrayList) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new EmotionDownGIFCallback.2(this, paramInt));
  }
  
  public void a(awei paramawei)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new EmotionDownGIFCallback.1(this, paramawei));
  }
  
  public void a_(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionDownGIFCallback", 2, new Object[] { "onUpdateProgress:", paramInt + " needRefresh:" + paramBoolean, " picMr:", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uniseq) });
    }
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() != null) {
      ((apwb)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramInt, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
    }
  }
  
  public void b(int paramInt, awfd paramawfd) {}
  
  public void c(int paramInt, awfd paramawfd) {}
  
  public void d(int paramInt, awfd paramawfd) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apwa
 * JD-Core Version:    0.7.0.1
 */