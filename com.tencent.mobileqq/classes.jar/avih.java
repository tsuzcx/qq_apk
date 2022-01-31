import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable.OnGIFPlayOnceListener;
import com.tencent.image.URLImageView;
import java.lang.ref.SoftReference;

class avih
  implements GifDrawable.OnGIFPlayOnceListener
{
  avih(avig paramavig, AbstractGifImage paramAbstractGifImage) {}
  
  public void onPlayOnce()
  {
    this.jdField_a_of_type_ComTencentImageAbstractGifImage.setStrongGIFPlayOnceListener(null);
    AbstractGifImage.pauseAll();
    if (this.jdField_a_of_type_Avig.jdField_a_of_type_Avii != null) {
      this.jdField_a_of_type_Avig.jdField_a_of_type_Avii.b();
    }
    if (this.jdField_a_of_type_Avig.jdField_a_of_type_JavaLangRefSoftReference.get() == null) {
      return;
    }
    ((URLImageView)this.jdField_a_of_type_Avig.jdField_a_of_type_JavaLangRefSoftReference.get()).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avih
 * JD-Core Version:    0.7.0.1
 */