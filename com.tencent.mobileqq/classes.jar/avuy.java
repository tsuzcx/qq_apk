import dov.com.qq.im.QIMEffectCameraCaptureUnit;

public class avuy
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
  
  public static avuy a(avvc paramavvc)
  {
    Object localObject;
    if ((paramavvc instanceof QIMEffectCameraCaptureUnit))
    {
      localObject = (bkzp)bjav.a(3);
      if (localObject == null) {
        break label290;
      }
      localObject = ((bkzp)localObject).a();
      if ((localObject != null) || (!(paramavvc instanceof bihx))) {
        break label292;
      }
    }
    label290:
    label292:
    for (paramavvc = ((bjru)bjav.a(17)).a();; paramavvc = (avvc)localObject)
    {
      if (paramavvc != null)
      {
        localObject = new avuy();
        ((avuy)localObject).e = bkzp.jdField_a_of_type_JavaLangString;
        ((avuy)localObject).jdField_a_of_type_Boolean = paramavvc.usable;
        ((avuy)localObject).jdField_a_of_type_Int = paramavvc.kind;
        ((avuy)localObject).jdField_a_of_type_JavaLangString = paramavvc.id;
        ((avuy)localObject).jdField_b_of_type_JavaLangString = paramavvc.name;
        ((avuy)localObject).jdField_c_of_type_JavaLangString = paramavvc.dgStageName;
        ((avuy)localObject).d = paramavvc.dgModelName;
        ((avuy)localObject).jdField_b_of_type_Boolean = paramavvc.hasFace();
        ((avuy)localObject).jdField_c_of_type_Boolean = paramavvc.hasGesture();
        ((avuy)localObject).jdField_b_of_type_Int = paramavvc.category;
        ((avuy)localObject).f = paramavvc.gestureType;
        ((avuy)localObject).g = paramavvc.gestureWording;
        ((avuy)localObject).h = paramavvc.bigHeadName;
        return localObject;
        paramavvc = avrv.a().a();
        if (paramavvc != null)
        {
          localObject = new avuy();
          ((avuy)localObject).e = avrv.jdField_a_of_type_JavaLangString;
          ((avuy)localObject).jdField_a_of_type_Boolean = paramavvc.usable;
          ((avuy)localObject).jdField_a_of_type_Int = paramavvc.kind;
          ((avuy)localObject).jdField_a_of_type_JavaLangString = paramavvc.id;
          ((avuy)localObject).jdField_b_of_type_JavaLangString = paramavvc.name;
          ((avuy)localObject).jdField_c_of_type_JavaLangString = paramavvc.dgStageName;
          ((avuy)localObject).d = paramavvc.dgModelName;
          ((avuy)localObject).jdField_b_of_type_Boolean = paramavvc.hasFace();
          ((avuy)localObject).jdField_c_of_type_Boolean = paramavvc.hasGesture();
          ((avuy)localObject).jdField_b_of_type_Int = paramavvc.category;
          ((avuy)localObject).f = paramavvc.gestureType;
          ((avuy)localObject).g = paramavvc.gestureWording;
          ((avuy)localObject).h = paramavvc.bigHeadName;
          return localObject;
        }
        return null;
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avuy
 * JD-Core Version:    0.7.0.1
 */