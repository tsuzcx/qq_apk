import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class bpbp
  implements URLDrawable.URLDrawableListener
{
  bpbp(bpbo parambpbo, String paramString, bpba parambpba) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    ykq.b("InformationFaceAdapter", "applyNormalPaster onLoadFialed path:" + this.jdField_a_of_type_JavaLangString);
    bpbo.a(this.jdField_a_of_type_Bpbo, this.jdField_a_of_type_JavaLangString);
    paramURLDrawable.setURLDrawableListener(null);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    ykq.b("InformationFaceAdapter", "applyNormalPaster onLoadSuccessed path:" + this.jdField_a_of_type_JavaLangString);
    paramURLDrawable.setBounds(0, 0, paramURLDrawable.getIntrinsicWidth(), paramURLDrawable.getIntrinsicHeight());
    bpbo.a(this.jdField_a_of_type_Bpbo).a(this.jdField_a_of_type_JavaLangString, paramURLDrawable);
    bpbo.a(this.jdField_a_of_type_Bpbo, paramURLDrawable, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bpba.b, 1);
    paramURLDrawable.setURLDrawableListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpbp
 * JD-Core Version:    0.7.0.1
 */