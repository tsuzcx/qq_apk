import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class bpnv
  implements URLDrawable.URLDrawableListener
{
  bpnv(bpnu parambpnu, String paramString, bpnf parambpnf) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    yqp.b("InformationFaceAdapter", "applyNormalPaster onLoadFialed path:" + this.jdField_a_of_type_JavaLangString);
    bpnu.a(this.jdField_a_of_type_Bpnu, this.jdField_a_of_type_JavaLangString);
    paramURLDrawable.setURLDrawableListener(null);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    yqp.b("InformationFaceAdapter", "applyNormalPaster onLoadSuccessed path:" + this.jdField_a_of_type_JavaLangString);
    paramURLDrawable.setBounds(0, 0, paramURLDrawable.getIntrinsicWidth(), paramURLDrawable.getIntrinsicHeight());
    bpnu.a(this.jdField_a_of_type_Bpnu).a(this.jdField_a_of_type_JavaLangString, paramURLDrawable);
    bpnu.a(this.jdField_a_of_type_Bpnu, paramURLDrawable, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bpnf.b, 1);
    paramURLDrawable.setURLDrawableListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpnv
 * JD-Core Version:    0.7.0.1
 */