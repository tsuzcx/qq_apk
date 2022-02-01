import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable.OnGIFPlayOnceListener;
import com.tencent.image.URLImageView;
import java.lang.ref.SoftReference;

class bbzd
  implements GifDrawable.OnGIFPlayOnceListener
{
  bbzd(bbzc parambbzc, AbstractGifImage paramAbstractGifImage) {}
  
  public void onPlayOnce()
  {
    this.jdField_a_of_type_ComTencentImageAbstractGifImage.setStrongGIFPlayOnceListener(null);
    if (this.jdField_a_of_type_Bbzc.jdField_a_of_type_Bbze != null) {
      this.jdField_a_of_type_Bbzc.jdField_a_of_type_Bbze.b();
    }
    if (this.jdField_a_of_type_Bbzc.jdField_a_of_type_JavaLangRefSoftReference.get() == null) {
      return;
    }
    AbstractGifImage.pauseAll();
    ((URLImageView)this.jdField_a_of_type_Bbzc.jdField_a_of_type_JavaLangRefSoftReference.get()).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbzd
 * JD-Core Version:    0.7.0.1
 */