class avrv
  extends avrr<avrt>
{
  public avrv(avrt paramavrt)
  {
    super(paramavrt);
  }
  
  public void a(avrt paramavrt, boolean paramBoolean, avro paramavro)
  {
    if (paramavrt == null) {
      return;
    }
    if (paramBoolean)
    {
      avrm localavrm = paramavrt.a(paramavro.f);
      if (localavrm != null)
      {
        avrt.a(paramavrt).a(paramavro, localavrm);
        return;
      }
    }
    avrt.a(paramavrt, paramavro.jdField_a_of_type_JavaLangString, paramavro.jdField_a_of_type_Int, 1002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avrv
 * JD-Core Version:    0.7.0.1
 */