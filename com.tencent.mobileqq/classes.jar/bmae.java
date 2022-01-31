class bmae
{
  blyw jdField_a_of_type_Blyw;
  blyz jdField_a_of_type_Blyz;
  
  bmae(blza paramblza, blyz paramblyz)
  {
    this.jdField_a_of_type_Blyw = blzc.a(paramblza);
    this.jdField_a_of_type_Blyz = paramblyz;
  }
  
  void a(blzb paramblzb, blyy paramblyy)
  {
    blyz localblyz = bmad.a(paramblyy);
    this.jdField_a_of_type_Blyz = bmad.a(this.jdField_a_of_type_Blyz, localblyz);
    this.jdField_a_of_type_Blyw.a(paramblzb, paramblyy);
    this.jdField_a_of_type_Blyz = localblyz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmae
 * JD-Core Version:    0.7.0.1
 */