class asjb
  extends asix<asiz>
{
  public asjb(asiz paramasiz)
  {
    super(paramasiz);
  }
  
  public void a(asiz paramasiz, boolean paramBoolean, asiu paramasiu)
  {
    if (paramasiz == null) {
      return;
    }
    if (paramBoolean)
    {
      asis localasis = paramasiz.a(paramasiu.f);
      if (localasis != null)
      {
        asiz.a(paramasiz).a(paramasiu, localasis);
        return;
      }
    }
    asiz.a(paramasiz, paramasiu.jdField_a_of_type_JavaLangString, paramasiu.jdField_a_of_type_Int, 1002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     asjb
 * JD-Core Version:    0.7.0.1
 */