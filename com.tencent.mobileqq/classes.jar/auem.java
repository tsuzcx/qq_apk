class auem
  extends auei<auek>
{
  public auem(auek paramauek)
  {
    super(paramauek);
  }
  
  public void a(auek paramauek, boolean paramBoolean, auef paramauef)
  {
    if (paramauek == null) {
      return;
    }
    if (paramBoolean)
    {
      aued localaued = paramauek.a(paramauef.f);
      if (localaued != null)
      {
        auek.a(paramauek).a(paramauef, localaued);
        return;
      }
    }
    auek.a(paramauek, paramauef.jdField_a_of_type_JavaLangString, paramauef.jdField_a_of_type_Int, 1002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auem
 * JD-Core Version:    0.7.0.1
 */