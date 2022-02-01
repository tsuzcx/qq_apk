import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener2;
import com.tencent.image.URLImageView;
import java.lang.ref.SoftReference;

final class bbyz
  implements URLDrawable.URLDrawableListener2
{
  bbyz(SoftReference paramSoftReference, URLDrawable paramURLDrawable, bbzb parambbzb) {}
  
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
      localAbstractGifImage.setStrongGIFPlayOnceListener(new bbza(this, localAbstractGifImage));
      paramURLDrawable.setVisibility(0);
      paramURLDrawable.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
    } while (this.jdField_a_of_type_Bbzb == null);
    this.jdField_a_of_type_Bbzb.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbyz
 * JD-Core Version:    0.7.0.1
 */