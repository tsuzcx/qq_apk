import dov.com.qq.im.QIMEffectCameraCaptureUnit;

public class avuw
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
  
  public static avuw a(avva paramavva)
  {
    Object localObject;
    if ((paramavva instanceof QIMEffectCameraCaptureUnit))
    {
      localObject = (bkyy)bjae.a(3);
      if (localObject == null) {
        break label290;
      }
      localObject = ((bkyy)localObject).a();
      if ((localObject != null) || (!(paramavva instanceof bihg))) {
        break label292;
      }
    }
    label290:
    label292:
    for (paramavva = ((bjrd)bjae.a(17)).a();; paramavva = (avva)localObject)
    {
      if (paramavva != null)
      {
        localObject = new avuw();
        ((avuw)localObject).e = bkyy.jdField_a_of_type_JavaLangString;
        ((avuw)localObject).jdField_a_of_type_Boolean = paramavva.usable;
        ((avuw)localObject).jdField_a_of_type_Int = paramavva.kind;
        ((avuw)localObject).jdField_a_of_type_JavaLangString = paramavva.id;
        ((avuw)localObject).jdField_b_of_type_JavaLangString = paramavva.name;
        ((avuw)localObject).jdField_c_of_type_JavaLangString = paramavva.dgStageName;
        ((avuw)localObject).d = paramavva.dgModelName;
        ((avuw)localObject).jdField_b_of_type_Boolean = paramavva.hasFace();
        ((avuw)localObject).jdField_c_of_type_Boolean = paramavva.hasGesture();
        ((avuw)localObject).jdField_b_of_type_Int = paramavva.category;
        ((avuw)localObject).f = paramavva.gestureType;
        ((avuw)localObject).g = paramavva.gestureWording;
        ((avuw)localObject).h = paramavva.bigHeadName;
        return localObject;
        paramavva = avrt.a().a();
        if (paramavva != null)
        {
          localObject = new avuw();
          ((avuw)localObject).e = avrt.jdField_a_of_type_JavaLangString;
          ((avuw)localObject).jdField_a_of_type_Boolean = paramavva.usable;
          ((avuw)localObject).jdField_a_of_type_Int = paramavva.kind;
          ((avuw)localObject).jdField_a_of_type_JavaLangString = paramavva.id;
          ((avuw)localObject).jdField_b_of_type_JavaLangString = paramavva.name;
          ((avuw)localObject).jdField_c_of_type_JavaLangString = paramavva.dgStageName;
          ((avuw)localObject).d = paramavva.dgModelName;
          ((avuw)localObject).jdField_b_of_type_Boolean = paramavva.hasFace();
          ((avuw)localObject).jdField_c_of_type_Boolean = paramavva.hasGesture();
          ((avuw)localObject).jdField_b_of_type_Int = paramavva.category;
          ((avuw)localObject).f = paramavva.gestureType;
          ((avuw)localObject).g = paramavva.gestureWording;
          ((avuw)localObject).h = paramavva.bigHeadName;
          return localObject;
        }
        return null;
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avuw
 * JD-Core Version:    0.7.0.1
 */