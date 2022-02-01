import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class bqqa
  implements URLDrawable.URLDrawableListener
{
  bqqa(bqpz parambqpz, String paramString1, bqpg parambqpg, ImageView paramImageView, String paramString2) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    yuk.b("NormalFaceAdapter", "applyNormalPaster onLoadFialed path:" + this.jdField_a_of_type_JavaLangString);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    yuk.b("NormalFaceAdapter", "applyNormalPaster onLoadSuccessed path:" + this.jdField_a_of_type_JavaLangString);
    paramURLDrawable.setBounds(0, 0, paramURLDrawable.getIntrinsicWidth(), paramURLDrawable.getIntrinsicHeight());
    bqpz.a(this.jdField_a_of_type_Bqpz).a(this.jdField_a_of_type_JavaLangString, paramURLDrawable);
    bqpz.a(this.jdField_a_of_type_Bqpz, this.jdField_a_of_type_Bqpg, paramURLDrawable, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_JavaLangString, this.b, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqqa
 * JD-Core Version:    0.7.0.1
 */