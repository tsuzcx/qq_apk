import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable.OnGIFPlayOnceListener;
import com.tencent.image.URLImageView;
import java.lang.ref.SoftReference;

class awia
  implements GifDrawable.OnGIFPlayOnceListener
{
  awia(awhz paramawhz, AbstractGifImage paramAbstractGifImage) {}
  
  public void onPlayOnce()
  {
    this.jdField_a_of_type_ComTencentImageAbstractGifImage.setStrongGIFPlayOnceListener(null);
    AbstractGifImage.pauseAll();
    if (this.jdField_a_of_type_Awhz.jdField_a_of_type_Awib != null) {
      this.jdField_a_of_type_Awhz.jdField_a_of_type_Awib.b();
    }
    if (this.jdField_a_of_type_Awhz.jdField_a_of_type_JavaLangRefSoftReference.get() == null) {
      return;
    }
    ((URLImageView)this.jdField_a_of_type_Awhz.jdField_a_of_type_JavaLangRefSoftReference.get()).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awia
 * JD-Core Version:    0.7.0.1
 */