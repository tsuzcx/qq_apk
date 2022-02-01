class bchv
  implements bffy
{
  bchv(bchs parambchs, bcep parambcep) {}
  
  public void a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_Bcep.b != null) && (this.jdField_a_of_type_Bcep.b.equals(paramString)))
    {
      if (paramInt != 3) {
        break label45;
      }
      this.jdField_a_of_type_Bcep.m = 2;
    }
    for (;;)
    {
      this.jdField_a_of_type_Bchs.a();
      return;
      label45:
      if ((paramInt == 2) || (paramInt == 4)) {
        this.jdField_a_of_type_Bcep.m = 1;
      } else if (paramInt == 1) {
        this.jdField_a_of_type_Bcep.m = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bchv
 * JD-Core Version:    0.7.0.1
 */