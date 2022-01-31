import android.view.View;
import com.tencent.image.URLDrawable;
import cooperation.qzone.QzoneGiftFullScreenViewController;
import cooperation.qzone.QzoneGiftFullScreenViewController.GiftFullScreenPlayListener;
import cooperation.qzone.QzoneGiftFullScreenViewController.MagicData;
import java.util.List;

class anae
  implements Runnable
{
  anae(anac paramanac) {}
  
  public void run()
  {
    URLDrawable.resume();
    ((View)this.a.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenViewController.a).setBackgroundColor(0);
    QzoneGiftFullScreenViewController.a(this.a.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenViewController);
    this.a.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenViewController$GiftFullScreenPlayListener.a();
    if (QzoneGiftFullScreenViewController.a(this.a.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenViewController).size() > 0)
    {
      QzoneGiftFullScreenViewController.MagicData localMagicData = (QzoneGiftFullScreenViewController.MagicData)QzoneGiftFullScreenViewController.a(this.a.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenViewController).get(0);
      this.a.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenViewController.a(localMagicData.jdField_a_of_type_JavaLangString, localMagicData.b, localMagicData.jdField_a_of_type_Boolean, localMagicData.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenViewController$GiftFullScreenPlayListener);
      QzoneGiftFullScreenViewController.a(this.a.jdField_a_of_type_CooperationQzoneQzoneGiftFullScreenViewController).remove(localMagicData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anae
 * JD-Core Version:    0.7.0.1
 */