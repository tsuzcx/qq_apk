import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import cooperation.qzone.util.QZLog;

class blaz
  implements URLDrawable.URLDrawableListener
{
  blaz(blax paramblax) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    QZLog.i("FileBannerTianshuManger", "onLoadSuccessed picUrlDrawable ");
    this.a.a(this.a.jdField_a_of_type_JavaLangString, paramURLDrawable);
    this.a.a(this.a.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem, 101);
    if (this.a.b == 1) {
      this.a.a(this.a.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem, 137);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blaz
 * JD-Core Version:    0.7.0.1
 */