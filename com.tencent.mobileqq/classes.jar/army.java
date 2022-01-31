class army
  extends armu<armw>
{
  public army(armw paramarmw)
  {
    super(paramarmw);
  }
  
  public void a(armw paramarmw, boolean paramBoolean, armr paramarmr)
  {
    if (paramarmw == null) {
      return;
    }
    if (paramBoolean)
    {
      armp localarmp = paramarmw.a(paramarmr.f);
      if (localarmp != null)
      {
        armw.a(paramarmw).a(paramarmr, localarmp);
        return;
      }
    }
    armw.a(paramarmw, paramarmr.jdField_a_of_type_JavaLangString, paramarmr.jdField_a_of_type_Int, 1002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     army
 * JD-Core Version:    0.7.0.1
 */