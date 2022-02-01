import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable.OnGIFPlayOnceListener;
import com.tencent.image.URLImageView;
import java.lang.ref.SoftReference;

class bbza
  implements GifDrawable.OnGIFPlayOnceListener
{
  bbza(bbyz parambbyz, AbstractGifImage paramAbstractGifImage) {}
  
  public void onPlayOnce()
  {
    this.jdField_a_of_type_ComTencentImageAbstractGifImage.setStrongGIFPlayOnceListener(null);
    if (this.jdField_a_of_type_Bbyz.jdField_a_of_type_Bbzb != null) {
      this.jdField_a_of_type_Bbyz.jdField_a_of_type_Bbzb.b();
    }
    if (this.jdField_a_of_type_Bbyz.jdField_a_of_type_JavaLangRefSoftReference.get() == null) {
      return;
    }
    AbstractGifImage.pauseAll();
    ((URLImageView)this.jdField_a_of_type_Bbyz.jdField_a_of_type_JavaLangRefSoftReference.get()).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbza
 * JD-Core Version:    0.7.0.1
 */