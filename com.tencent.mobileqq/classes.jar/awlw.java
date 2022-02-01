class awlw
  extends awls<awlu>
{
  public awlw(awlu paramawlu)
  {
    super(paramawlu);
  }
  
  public void a(awlu paramawlu, boolean paramBoolean, awlp paramawlp)
  {
    if (paramawlu == null) {
      return;
    }
    if (paramBoolean)
    {
      awln localawln = paramawlu.a(paramawlp.f);
      if (localawln != null)
      {
        awlu.a(paramawlu).a(paramawlp, localawln);
        return;
      }
    }
    awlu.a(paramawlu, paramawlp.jdField_a_of_type_JavaLangString, paramawlp.jdField_a_of_type_Int, 1002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awlw
 * JD-Core Version:    0.7.0.1
 */