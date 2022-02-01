import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class bpby
  implements URLDrawable.URLDrawableListener
{
  bpby(bpbx parambpbx, String paramString1, bpbf parambpbf, ImageView paramImageView, String paramString2) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    ykq.b("NormalFaceAdapter", "applyNormalPaster onLoadFialed path:" + this.jdField_a_of_type_JavaLangString);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    ykq.b("NormalFaceAdapter", "applyNormalPaster onLoadSuccessed path:" + this.jdField_a_of_type_JavaLangString);
    paramURLDrawable.setBounds(0, 0, paramURLDrawable.getIntrinsicWidth(), paramURLDrawable.getIntrinsicHeight());
    bpbx.a(this.jdField_a_of_type_Bpbx).a(this.jdField_a_of_type_JavaLangString, paramURLDrawable);
    bpbx.a(this.jdField_a_of_type_Bpbx, this.jdField_a_of_type_Bpbf, paramURLDrawable, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_JavaLangString, this.b, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpby
 * JD-Core Version:    0.7.0.1
 */