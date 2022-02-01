class awxq
  implements atty
{
  awxq(awxi paramawxi, awxd paramawxd) {}
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Awxd != null) && (this.jdField_a_of_type_Awxd.a != null))
    {
      String str = this.jdField_a_of_type_Awxd.a.a();
      awxe localawxe = this.jdField_a_of_type_Awxi.a(str);
      if ((localawxe != null) && (!localawxe.a))
      {
        localawxe.c = paramInt;
        this.jdField_a_of_type_Awxi.a(str, localawxe);
        awxi.a(this.jdField_a_of_type_Awxi, localawxe, paramInt);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    awxi.a(this.jdField_a_of_type_Awxi, this.jdField_a_of_type_Awxd, paramBoolean);
  }
  
  public void b(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awxq
 * JD-Core Version:    0.7.0.1
 */