class bchp
  implements bevp
{
  bchp(bchk parambchk, bceh parambceh) {}
  
  public void a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_Bceh.b != null) && (this.jdField_a_of_type_Bceh.b.equals(paramString)))
    {
      if (paramInt != 3) {
        break label45;
      }
      this.jdField_a_of_type_Bceh.m = 2;
    }
    for (;;)
    {
      this.jdField_a_of_type_Bchk.a();
      return;
      label45:
      if ((paramInt == 2) || (paramInt == 4)) {
        this.jdField_a_of_type_Bceh.m = 1;
      } else if (paramInt == 1) {
        this.jdField_a_of_type_Bceh.m = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bchp
 * JD-Core Version:    0.7.0.1
 */