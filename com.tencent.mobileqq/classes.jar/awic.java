import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable.OnGIFPlayOnceListener;
import com.tencent.image.URLImageView;
import java.lang.ref.SoftReference;

class awic
  implements GifDrawable.OnGIFPlayOnceListener
{
  awic(awib paramawib, AbstractGifImage paramAbstractGifImage) {}
  
  public void onPlayOnce()
  {
    this.jdField_a_of_type_ComTencentImageAbstractGifImage.setStrongGIFPlayOnceListener(null);
    AbstractGifImage.pauseAll();
    if (this.jdField_a_of_type_Awib.jdField_a_of_type_Awid != null) {
      this.jdField_a_of_type_Awib.jdField_a_of_type_Awid.b();
    }
    if (this.jdField_a_of_type_Awib.jdField_a_of_type_JavaLangRefSoftReference.get() == null) {
      return;
    }
    ((URLImageView)this.jdField_a_of_type_Awib.jdField_a_of_type_JavaLangRefSoftReference.get()).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awic
 * JD-Core Version:    0.7.0.1
 */