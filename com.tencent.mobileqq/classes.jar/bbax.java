class bbax
  implements bdom
{
  bbax(bbau parambbau, baxr parambaxr) {}
  
  public void a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_Baxr.b != null) && (this.jdField_a_of_type_Baxr.b.equals(paramString)))
    {
      if (paramInt != 3) {
        break label45;
      }
      this.jdField_a_of_type_Baxr.m = 2;
    }
    for (;;)
    {
      this.jdField_a_of_type_Bbau.a();
      return;
      label45:
      if ((paramInt == 2) || (paramInt == 4)) {
        this.jdField_a_of_type_Baxr.m = 1;
      } else if (paramInt == 1) {
        this.jdField_a_of_type_Baxr.m = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbax
 * JD-Core Version:    0.7.0.1
 */