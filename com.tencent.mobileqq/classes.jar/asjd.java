class asjd
  extends asiz<asjb>
{
  public asjd(asjb paramasjb)
  {
    super(paramasjb);
  }
  
  public void a(asjb paramasjb, boolean paramBoolean, asiw paramasiw)
  {
    if (paramasjb == null) {
      return;
    }
    if (paramBoolean)
    {
      asiu localasiu = paramasjb.a(paramasiw.f);
      if (localasiu != null)
      {
        asjb.a(paramasjb).a(paramasiw, localasiu);
        return;
      }
    }
    asjb.a(paramasjb, paramasiw.jdField_a_of_type_JavaLangString, paramasiw.jdField_a_of_type_Int, 1002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     asjd
 * JD-Core Version:    0.7.0.1
 */