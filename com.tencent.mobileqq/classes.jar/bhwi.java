class bhwi
{
  bhvb jdField_a_of_type_Bhvb;
  bhve jdField_a_of_type_Bhve;
  
  bhwi(bhvf parambhvf, bhve parambhve)
  {
    this.jdField_a_of_type_Bhvb = bhvh.a(parambhvf);
    this.jdField_a_of_type_Bhve = parambhve;
  }
  
  void a(bhvg parambhvg, bhvd parambhvd)
  {
    bhve localbhve = bhwh.a(parambhvd);
    this.jdField_a_of_type_Bhve = bhwh.a(this.jdField_a_of_type_Bhve, localbhve);
    this.jdField_a_of_type_Bhvb.a(parambhvg, parambhvd);
    this.jdField_a_of_type_Bhve = localbhve;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhwi
 * JD-Core Version:    0.7.0.1
 */