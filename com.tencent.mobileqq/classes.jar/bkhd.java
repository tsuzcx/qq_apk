import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class bkhd
  implements URLDrawable.URLDrawableListener
{
  bkhd(bkhc parambkhc, String paramString1, bkgj parambkgj, ImageView paramImageView, String paramString2) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    ved.b("NormalFaceAdapter", "applyNormalPaster onLoadFialed path:" + this.jdField_a_of_type_JavaLangString);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    ved.b("NormalFaceAdapter", "applyNormalPaster onLoadSuccessed path:" + this.jdField_a_of_type_JavaLangString);
    paramURLDrawable.setBounds(0, 0, paramURLDrawable.getIntrinsicWidth(), paramURLDrawable.getIntrinsicHeight());
    bkhc.a(this.jdField_a_of_type_Bkhc).a(this.jdField_a_of_type_JavaLangString, paramURLDrawable);
    bkhc.a(this.jdField_a_of_type_Bkhc, this.jdField_a_of_type_Bkgj, paramURLDrawable, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_JavaLangString, this.b, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkhd
 * JD-Core Version:    0.7.0.1
 */