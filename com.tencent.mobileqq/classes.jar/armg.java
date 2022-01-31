class armg
  implements bdvt
{
  armg(armf paramarmf, army paramarmy) {}
  
  public void callback(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2))
    {
      this.jdField_a_of_type_Army.a();
      return;
    }
    this.jdField_a_of_type_Army.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     armg
 * JD-Core Version:    0.7.0.1
 */