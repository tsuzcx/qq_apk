import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class bmwp
  implements URLDrawable.URLDrawableListener
{
  bmwp(bmwo parambmwo, String paramString, bmvz parambmvz) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    wxe.b("InformationFaceAdapter", "applyNormalPaster onLoadFialed path:" + this.jdField_a_of_type_JavaLangString);
    bmwo.a(this.jdField_a_of_type_Bmwo, this.jdField_a_of_type_JavaLangString);
    paramURLDrawable.setURLDrawableListener(null);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    wxe.b("InformationFaceAdapter", "applyNormalPaster onLoadSuccessed path:" + this.jdField_a_of_type_JavaLangString);
    paramURLDrawable.setBounds(0, 0, paramURLDrawable.getIntrinsicWidth(), paramURLDrawable.getIntrinsicHeight());
    bmwo.a(this.jdField_a_of_type_Bmwo).a(this.jdField_a_of_type_JavaLangString, paramURLDrawable);
    bmwo.a(this.jdField_a_of_type_Bmwo, paramURLDrawable, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bmvz.b, 1);
    paramURLDrawable.setURLDrawableListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmwp
 * JD-Core Version:    0.7.0.1
 */