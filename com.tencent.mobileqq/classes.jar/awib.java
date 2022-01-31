import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener2;
import com.tencent.image.URLImageView;
import java.lang.ref.SoftReference;

final class awib
  implements URLDrawable.URLDrawableListener2
{
  awib(SoftReference paramSoftReference, URLDrawable paramURLDrawable, awid paramawid) {}
  
  public void onFileDownloaded(URLDrawable paramURLDrawable) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (this.jdField_a_of_type_JavaLangRefSoftReference.get() == null) {}
    do
    {
      do
      {
        return;
        paramURLDrawable = (URLImageView)this.jdField_a_of_type_JavaLangRefSoftReference.get();
      } while (!(this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof GifDrawable));
      AbstractGifImage localAbstractGifImage = ((GifDrawable)this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable()).getImage();
      localAbstractGifImage.reset();
      localAbstractGifImage.setStrongGIFPlayOnceListener(new awic(this, localAbstractGifImage));
      paramURLDrawable.setVisibility(0);
      paramURLDrawable.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
    } while (this.jdField_a_of_type_Awid == null);
    this.jdField_a_of_type_Awid.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awib
 * JD-Core Version:    0.7.0.1
 */