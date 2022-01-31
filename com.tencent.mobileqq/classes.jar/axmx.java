import dov.com.qq.im.QIMEffectCameraCaptureUnit;

public class axmx
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public String c;
  public boolean c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  
  public static axmx a(axnb paramaxnb)
  {
    Object localObject;
    if ((paramaxnb instanceof QIMEffectCameraCaptureUnit))
    {
      localObject = (bnkz)blmf.a(3);
      if (localObject == null) {
        break label290;
      }
      localObject = ((bnkz)localObject).a();
      if ((localObject != null) || (!(paramaxnb instanceof bkjt))) {
        break label292;
      }
    }
    label290:
    label292:
    for (paramaxnb = ((bmde)blmf.a(17)).a();; paramaxnb = (axnb)localObject)
    {
      if (paramaxnb != null)
      {
        localObject = new axmx();
        ((axmx)localObject).e = bnkz.jdField_a_of_type_JavaLangString;
        ((axmx)localObject).jdField_a_of_type_Boolean = paramaxnb.usable;
        ((axmx)localObject).jdField_a_of_type_Int = paramaxnb.kind;
        ((axmx)localObject).jdField_a_of_type_JavaLangString = paramaxnb.id;
        ((axmx)localObject).jdField_b_of_type_JavaLangString = paramaxnb.name;
        ((axmx)localObject).jdField_c_of_type_JavaLangString = paramaxnb.dgStageName;
        ((axmx)localObject).d = paramaxnb.dgModelName;
        ((axmx)localObject).jdField_b_of_type_Boolean = paramaxnb.hasFace();
        ((axmx)localObject).jdField_c_of_type_Boolean = paramaxnb.hasGesture();
        ((axmx)localObject).jdField_b_of_type_Int = paramaxnb.category;
        ((axmx)localObject).f = paramaxnb.gestureType;
        ((axmx)localObject).g = paramaxnb.gestureWording;
        ((axmx)localObject).h = paramaxnb.bigHeadName;
        return localObject;
        paramaxnb = axjt.a().a();
        if (paramaxnb != null)
        {
          localObject = new axmx();
          ((axmx)localObject).e = axjt.jdField_a_of_type_JavaLangString;
          ((axmx)localObject).jdField_a_of_type_Boolean = paramaxnb.usable;
          ((axmx)localObject).jdField_a_of_type_Int = paramaxnb.kind;
          ((axmx)localObject).jdField_a_of_type_JavaLangString = paramaxnb.id;
          ((axmx)localObject).jdField_b_of_type_JavaLangString = paramaxnb.name;
          ((axmx)localObject).jdField_c_of_type_JavaLangString = paramaxnb.dgStageName;
          ((axmx)localObject).d = paramaxnb.dgModelName;
          ((axmx)localObject).jdField_b_of_type_Boolean = paramaxnb.hasFace();
          ((axmx)localObject).jdField_c_of_type_Boolean = paramaxnb.hasGesture();
          ((axmx)localObject).jdField_b_of_type_Int = paramaxnb.category;
          ((axmx)localObject).f = paramaxnb.gestureType;
          ((axmx)localObject).g = paramaxnb.gestureWording;
          ((axmx)localObject).h = paramaxnb.bigHeadName;
          return localObject;
        }
        return null;
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axmx
 * JD-Core Version:    0.7.0.1
 */