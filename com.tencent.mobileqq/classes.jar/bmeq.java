class bmeq
{
  bmdi jdField_a_of_type_Bmdi;
  bmdl jdField_a_of_type_Bmdl;
  
  bmeq(bmdm parambmdm, bmdl parambmdl)
  {
    this.jdField_a_of_type_Bmdi = bmdo.a(parambmdm);
    this.jdField_a_of_type_Bmdl = parambmdl;
  }
  
  void a(bmdn parambmdn, bmdk parambmdk)
  {
    bmdl localbmdl = bmep.a(parambmdk);
    this.jdField_a_of_type_Bmdl = bmep.a(this.jdField_a_of_type_Bmdl, localbmdl);
    this.jdField_a_of_type_Bmdi.a(parambmdn, parambmdk);
    this.jdField_a_of_type_Bmdl = localbmdl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmeq
 * JD-Core Version:    0.7.0.1
 */