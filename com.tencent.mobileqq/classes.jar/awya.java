class awya
  extends awxw<awxy>
{
  public awya(awxy paramawxy)
  {
    super(paramawxy);
  }
  
  public void a(awxy paramawxy, boolean paramBoolean, awxt paramawxt)
  {
    if (paramawxy == null) {
      return;
    }
    if (paramBoolean)
    {
      awxr localawxr = paramawxy.a(paramawxt.f);
      if (localawxr != null)
      {
        awxy.a(paramawxy).a(paramawxt, localawxr);
        return;
      }
    }
    awxy.a(paramawxy, paramawxt.jdField_a_of_type_JavaLangString, paramawxt.jdField_a_of_type_Int, 1002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awya
 * JD-Core Version:    0.7.0.1
 */