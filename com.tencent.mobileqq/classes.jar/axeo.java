class axeo
  extends axek<axem>
{
  public axeo(axem paramaxem)
  {
    super(paramaxem);
  }
  
  public void a(axem paramaxem, boolean paramBoolean, axeh paramaxeh)
  {
    if (paramaxem == null) {
      return;
    }
    if (paramBoolean)
    {
      axef localaxef = paramaxem.a(paramaxeh.f);
      if (localaxef != null)
      {
        axem.a(paramaxem).a(paramaxeh, localaxef);
        return;
      }
    }
    axem.a(paramaxem, paramaxeh.jdField_a_of_type_JavaLangString, paramaxeh.jdField_a_of_type_Int, 1002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axeo
 * JD-Core Version:    0.7.0.1
 */