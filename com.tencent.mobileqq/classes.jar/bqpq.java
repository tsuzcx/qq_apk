import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class bqpq
  implements URLDrawable.URLDrawableListener
{
  bqpq(bqpp parambqpp, String paramString, bqpa parambqpa) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    yuk.b("InformationFaceAdapter", "applyNormalPaster onLoadFialed path:" + this.jdField_a_of_type_JavaLangString);
    bqpp.a(this.jdField_a_of_type_Bqpp, this.jdField_a_of_type_JavaLangString);
    paramURLDrawable.setURLDrawableListener(null);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    yuk.b("InformationFaceAdapter", "applyNormalPaster onLoadSuccessed path:" + this.jdField_a_of_type_JavaLangString);
    paramURLDrawable.setBounds(0, 0, paramURLDrawable.getIntrinsicWidth(), paramURLDrawable.getIntrinsicHeight());
    bqpp.a(this.jdField_a_of_type_Bqpp).a(this.jdField_a_of_type_JavaLangString, paramURLDrawable);
    bqpp.a(this.jdField_a_of_type_Bqpp, paramURLDrawable, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bqpa.b, 1);
    paramURLDrawable.setURLDrawableListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqpq
 * JD-Core Version:    0.7.0.1
 */