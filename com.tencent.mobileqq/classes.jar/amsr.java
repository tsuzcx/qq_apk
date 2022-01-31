import android.os.Handler;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import cooperation.qzone.QzoneGiftFullScreenActionManager;
import cooperation.qzone.QzoneGiftFullScreenActionManager.MagicfaceActionListener;
import cooperation.qzone.QzoneGiftFullScreenViewController;
import cooperation.qzone.QzoneGiftFullScreenViewController.GiftFullScreenPlayListener;

public class amsr
  implements QzoneGiftFullScreenActionManager.MagicfaceActionListener
{
  public amsr(QzoneGiftFullScreenViewController paramQzoneGiftFullScreenViewController, long paramLong, QzoneGiftFullScreenViewController.GiftFullScreenPlayListener paramGiftFullScreenPlayListener) {}
  
  public void a(ActionGlobalData paramActionGlobalData)
  {
    System.currentTimeMillis();
    long l = this.jdField_a_of_type_Long;
    boolean bool = this.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenViewController.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenActionManager.b();
    this.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenViewController.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenActionManager.a(bool);
    this.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenViewController.jdField_a_of_type_AndroidOsHandler.post(new amss(this, paramActionGlobalData));
  }
  
  public void b(ActionGlobalData paramActionGlobalData)
  {
    this.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenViewController.jdField_a_of_type_AndroidOsHandler.post(new amst(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amsr
 * JD-Core Version:    0.7.0.1
 */