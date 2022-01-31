import dov.com.qq.im.QIMEffectCameraCaptureUnit;

public class auvf
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
  
  public static auvf a(auvj paramauvj)
  {
    Object localObject;
    if ((paramauvj instanceof QIMEffectCameraCaptureUnit))
    {
      localObject = (bjin)bhfm.a(3);
      if (localObject == null) {
        break label290;
      }
      localObject = ((bjin)localObject).a();
      if ((localObject != null) || (!(paramauvj instanceof bheq))) {
        break label292;
      }
    }
    label290:
    label292:
    for (paramauvj = ((bhzl)bhfm.a(17)).a();; paramauvj = (auvj)localObject)
    {
      if (paramauvj != null)
      {
        localObject = new auvf();
        ((auvf)localObject).e = bjin.jdField_a_of_type_JavaLangString;
        ((auvf)localObject).jdField_a_of_type_Boolean = paramauvj.usable;
        ((auvf)localObject).jdField_a_of_type_Int = paramauvj.kind;
        ((auvf)localObject).jdField_a_of_type_JavaLangString = paramauvj.id;
        ((auvf)localObject).jdField_b_of_type_JavaLangString = paramauvj.name;
        ((auvf)localObject).jdField_c_of_type_JavaLangString = paramauvj.dgStageName;
        ((auvf)localObject).d = paramauvj.dgModelName;
        ((auvf)localObject).jdField_b_of_type_Boolean = paramauvj.hasFace();
        ((auvf)localObject).jdField_c_of_type_Boolean = paramauvj.hasGesture();
        ((auvf)localObject).jdField_b_of_type_Int = paramauvj.category;
        ((auvf)localObject).f = paramauvj.gestureType;
        ((auvf)localObject).g = paramauvj.gestureWording;
        ((auvf)localObject).h = paramauvj.bigHeadName;
        return localObject;
        paramauvj = ausk.a().a();
        if (paramauvj != null)
        {
          localObject = new auvf();
          ((auvf)localObject).e = ausk.jdField_a_of_type_JavaLangString;
          ((auvf)localObject).jdField_a_of_type_Boolean = paramauvj.usable;
          ((auvf)localObject).jdField_a_of_type_Int = paramauvj.kind;
          ((auvf)localObject).jdField_a_of_type_JavaLangString = paramauvj.id;
          ((auvf)localObject).jdField_b_of_type_JavaLangString = paramauvj.name;
          ((auvf)localObject).jdField_c_of_type_JavaLangString = paramauvj.dgStageName;
          ((auvf)localObject).d = paramauvj.dgModelName;
          ((auvf)localObject).jdField_b_of_type_Boolean = paramauvj.hasFace();
          ((auvf)localObject).jdField_c_of_type_Boolean = paramauvj.hasGesture();
          ((auvf)localObject).jdField_b_of_type_Int = paramauvj.category;
          ((auvf)localObject).f = paramauvj.gestureType;
          ((auvf)localObject).g = paramauvj.gestureWording;
          ((auvf)localObject).h = paramauvj.bigHeadName;
          return localObject;
        }
        return null;
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     auvf
 * JD-Core Version:    0.7.0.1
 */