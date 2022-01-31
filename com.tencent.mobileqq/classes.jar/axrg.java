import dov.com.qq.im.QIMEffectCameraCaptureUnit;

public class axrg
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
  
  public static axrg a(axrk paramaxrk)
  {
    Object localObject;
    if ((paramaxrk instanceof QIMEffectCameraCaptureUnit))
    {
      localObject = (bnpl)blqr.a(3);
      if (localObject == null) {
        break label290;
      }
      localObject = ((bnpl)localObject).a();
      if ((localObject != null) || (!(paramaxrk instanceof bkoa))) {
        break label292;
      }
    }
    label290:
    label292:
    for (paramaxrk = ((bmhq)blqr.a(17)).a();; paramaxrk = (axrk)localObject)
    {
      if (paramaxrk != null)
      {
        localObject = new axrg();
        ((axrg)localObject).e = bnpl.jdField_a_of_type_JavaLangString;
        ((axrg)localObject).jdField_a_of_type_Boolean = paramaxrk.usable;
        ((axrg)localObject).jdField_a_of_type_Int = paramaxrk.kind;
        ((axrg)localObject).jdField_a_of_type_JavaLangString = paramaxrk.id;
        ((axrg)localObject).jdField_b_of_type_JavaLangString = paramaxrk.name;
        ((axrg)localObject).jdField_c_of_type_JavaLangString = paramaxrk.dgStageName;
        ((axrg)localObject).d = paramaxrk.dgModelName;
        ((axrg)localObject).jdField_b_of_type_Boolean = paramaxrk.hasFace();
        ((axrg)localObject).jdField_c_of_type_Boolean = paramaxrk.hasGesture();
        ((axrg)localObject).jdField_b_of_type_Int = paramaxrk.category;
        ((axrg)localObject).f = paramaxrk.gestureType;
        ((axrg)localObject).g = paramaxrk.gestureWording;
        ((axrg)localObject).h = paramaxrk.bigHeadName;
        return localObject;
        paramaxrk = axoc.a().a();
        if (paramaxrk != null)
        {
          localObject = new axrg();
          ((axrg)localObject).e = axoc.jdField_a_of_type_JavaLangString;
          ((axrg)localObject).jdField_a_of_type_Boolean = paramaxrk.usable;
          ((axrg)localObject).jdField_a_of_type_Int = paramaxrk.kind;
          ((axrg)localObject).jdField_a_of_type_JavaLangString = paramaxrk.id;
          ((axrg)localObject).jdField_b_of_type_JavaLangString = paramaxrk.name;
          ((axrg)localObject).jdField_c_of_type_JavaLangString = paramaxrk.dgStageName;
          ((axrg)localObject).d = paramaxrk.dgModelName;
          ((axrg)localObject).jdField_b_of_type_Boolean = paramaxrk.hasFace();
          ((axrg)localObject).jdField_c_of_type_Boolean = paramaxrk.hasGesture();
          ((axrg)localObject).jdField_b_of_type_Int = paramaxrk.category;
          ((axrg)localObject).f = paramaxrk.gestureType;
          ((axrg)localObject).g = paramaxrk.gestureWording;
          ((axrg)localObject).h = paramaxrk.bigHeadName;
          return localObject;
        }
        return null;
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axrg
 * JD-Core Version:    0.7.0.1
 */