class bjod
{
  bjmw jdField_a_of_type_Bjmw;
  bjmz jdField_a_of_type_Bjmz;
  
  bjod(bjna parambjna, bjmz parambjmz)
  {
    this.jdField_a_of_type_Bjmw = bjnc.a(parambjna);
    this.jdField_a_of_type_Bjmz = parambjmz;
  }
  
  void a(bjnb parambjnb, bjmy parambjmy)
  {
    bjmz localbjmz = bjoc.a(parambjmy);
    this.jdField_a_of_type_Bjmz = bjoc.a(this.jdField_a_of_type_Bjmz, localbjmz);
    this.jdField_a_of_type_Bjmw.a(parambjnb, parambjmy);
    this.jdField_a_of_type_Bjmz = localbjmz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjod
 * JD-Core Version:    0.7.0.1
 */