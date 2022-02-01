import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable.OnGIFPlayOnceListener;
import com.tencent.image.URLImageView;
import java.lang.ref.SoftReference;

class basl
  implements GifDrawable.OnGIFPlayOnceListener
{
  basl(bask parambask, AbstractGifImage paramAbstractGifImage) {}
  
  public void onPlayOnce()
  {
    this.jdField_a_of_type_ComTencentImageAbstractGifImage.setStrongGIFPlayOnceListener(null);
    if (this.jdField_a_of_type_Bask.jdField_a_of_type_Basm != null) {
      this.jdField_a_of_type_Bask.jdField_a_of_type_Basm.b();
    }
    if (this.jdField_a_of_type_Bask.jdField_a_of_type_JavaLangRefSoftReference.get() == null) {
      return;
    }
    AbstractGifImage.pauseAll();
    ((URLImageView)this.jdField_a_of_type_Bask.jdField_a_of_type_JavaLangRefSoftReference.get()).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     basl
 * JD-Core Version:    0.7.0.1
 */