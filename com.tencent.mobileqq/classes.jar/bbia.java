import dov.com.qq.im.QIMEffectCameraCaptureUnit;

public class bbia
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
  
  public static bbia a(bbie parambbie)
  {
    Object localObject;
    if ((parambbie instanceof QIMEffectCameraCaptureUnit))
    {
      localObject = (brhn)bplq.a(3);
      if (localObject == null) {
        break label290;
      }
      localObject = ((brhn)localObject).a();
      if ((localObject != null) || (!(parambbie instanceof bodv))) {
        break label292;
      }
    }
    label290:
    label292:
    for (parambbie = ((bqar)bplq.a(17)).a();; parambbie = (bbie)localObject)
    {
      if (parambbie != null)
      {
        localObject = new bbia();
        ((bbia)localObject).e = brhn.jdField_a_of_type_JavaLangString;
        ((bbia)localObject).jdField_a_of_type_Boolean = parambbie.usable;
        ((bbia)localObject).jdField_a_of_type_Int = parambbie.kind;
        ((bbia)localObject).jdField_a_of_type_JavaLangString = parambbie.id;
        ((bbia)localObject).jdField_b_of_type_JavaLangString = parambbie.name;
        ((bbia)localObject).jdField_c_of_type_JavaLangString = parambbie.dgStageName;
        ((bbia)localObject).d = parambbie.dgModelName;
        ((bbia)localObject).jdField_b_of_type_Boolean = parambbie.hasFace();
        ((bbia)localObject).jdField_c_of_type_Boolean = parambbie.hasGesture();
        ((bbia)localObject).jdField_b_of_type_Int = parambbie.category;
        ((bbia)localObject).f = parambbie.gestureType;
        ((bbia)localObject).g = parambbie.gestureWording;
        ((bbia)localObject).h = parambbie.bigHeadName;
        return localObject;
        parambbie = bbew.a().a();
        if (parambbie != null)
        {
          localObject = new bbia();
          ((bbia)localObject).e = bbew.jdField_a_of_type_JavaLangString;
          ((bbia)localObject).jdField_a_of_type_Boolean = parambbie.usable;
          ((bbia)localObject).jdField_a_of_type_Int = parambbie.kind;
          ((bbia)localObject).jdField_a_of_type_JavaLangString = parambbie.id;
          ((bbia)localObject).jdField_b_of_type_JavaLangString = parambbie.name;
          ((bbia)localObject).jdField_c_of_type_JavaLangString = parambbie.dgStageName;
          ((bbia)localObject).d = parambbie.dgModelName;
          ((bbia)localObject).jdField_b_of_type_Boolean = parambbie.hasFace();
          ((bbia)localObject).jdField_c_of_type_Boolean = parambbie.hasGesture();
          ((bbia)localObject).jdField_b_of_type_Int = parambbie.category;
          ((bbia)localObject).f = parambbie.gestureType;
          ((bbia)localObject).g = parambbie.gestureWording;
          ((bbia)localObject).h = parambbie.bigHeadName;
          return localObject;
        }
        return null;
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbia
 * JD-Core Version:    0.7.0.1
 */