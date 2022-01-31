import android.os.Handler;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback.1;
import com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback.2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class anni
  implements atpa, atqn
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private annj jdField_a_of_type_Annj;
  private MessageForPic jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
  
  public anni(MessageForPic paramMessageForPic, Handler paramHandler, annj paramannj)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = paramMessageForPic;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_Annj = paramannj;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, atpw paramatpw)
  {
    QLog.d("EmotionDownGIFCallback", 1, new Object[] { "onDownload ", Integer.valueOf(paramatpw.jdField_a_of_type_Int) });
    if (paramatpw.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_Annj.a(true, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
    }
    while (-1 != paramatpw.jdField_a_of_type_Int) {
      return;
    }
    if (paramatpw.jdField_a_of_type_Atpr != null) {
      QLog.d("EmotionDownGIFCallback", 1, new Object[] { "onDownloadFail errDec:", paramatpw.jdField_a_of_type_Atpr.b });
    }
    this.jdField_a_of_type_Annj.a(false, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
  }
  
  public void a(int paramInt, ArrayList<atpw> paramArrayList) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new EmotionDownGIFCallback.2(this, paramInt));
  }
  
  public void a(atpb paramatpb)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new EmotionDownGIFCallback.1(this, paramatpb));
  }
  
  public void a_(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionDownGIFCallback", 2, new Object[] { "onUpdateProgress:", paramInt + " needRefresh:" + paramBoolean, " picMr:", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uniseq) });
    }
    this.jdField_a_of_type_Annj.a(paramInt, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
  }
  
  public void b(int paramInt, atpw paramatpw) {}
  
  public void c(int paramInt, atpw paramatpw) {}
  
  public void d(int paramInt, atpw paramatpw) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anni
 * JD-Core Version:    0.7.0.1
 */