import dov.com.qq.im.QIMEffectCameraCaptureUnit;

public class baph
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
  
  public static baph a(bapl parambapl)
  {
    Object localObject;
    if ((parambapl instanceof QIMEffectCameraCaptureUnit))
    {
      localObject = (bqgc)bojv.a(3);
      if (localObject == null) {
        break label290;
      }
      localObject = ((bqgc)localObject).a();
      if ((localObject != null) || (!(parambapl instanceof bncn))) {
        break label292;
      }
    }
    label290:
    label292:
    for (parambapl = ((boyw)bojv.a(17)).a();; parambapl = (bapl)localObject)
    {
      if (parambapl != null)
      {
        localObject = new baph();
        ((baph)localObject).e = bqgc.jdField_a_of_type_JavaLangString;
        ((baph)localObject).jdField_a_of_type_Boolean = parambapl.usable;
        ((baph)localObject).jdField_a_of_type_Int = parambapl.kind;
        ((baph)localObject).jdField_a_of_type_JavaLangString = parambapl.id;
        ((baph)localObject).jdField_b_of_type_JavaLangString = parambapl.name;
        ((baph)localObject).jdField_c_of_type_JavaLangString = parambapl.dgStageName;
        ((baph)localObject).d = parambapl.dgModelName;
        ((baph)localObject).jdField_b_of_type_Boolean = parambapl.hasFace();
        ((baph)localObject).jdField_c_of_type_Boolean = parambapl.hasGesture();
        ((baph)localObject).jdField_b_of_type_Int = parambapl.category;
        ((baph)localObject).f = parambapl.gestureType;
        ((baph)localObject).g = parambapl.gestureWording;
        ((baph)localObject).h = parambapl.bigHeadName;
        return localObject;
        parambapl = bamd.a().a();
        if (parambapl != null)
        {
          localObject = new baph();
          ((baph)localObject).e = bamd.jdField_a_of_type_JavaLangString;
          ((baph)localObject).jdField_a_of_type_Boolean = parambapl.usable;
          ((baph)localObject).jdField_a_of_type_Int = parambapl.kind;
          ((baph)localObject).jdField_a_of_type_JavaLangString = parambapl.id;
          ((baph)localObject).jdField_b_of_type_JavaLangString = parambapl.name;
          ((baph)localObject).jdField_c_of_type_JavaLangString = parambapl.dgStageName;
          ((baph)localObject).d = parambapl.dgModelName;
          ((baph)localObject).jdField_b_of_type_Boolean = parambapl.hasFace();
          ((baph)localObject).jdField_c_of_type_Boolean = parambapl.hasGesture();
          ((baph)localObject).jdField_b_of_type_Int = parambapl.category;
          ((baph)localObject).f = parambapl.gestureType;
          ((baph)localObject).g = parambapl.gestureWording;
          ((baph)localObject).h = parambapl.bigHeadName;
          return localObject;
        }
        return null;
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baph
 * JD-Core Version:    0.7.0.1
 */