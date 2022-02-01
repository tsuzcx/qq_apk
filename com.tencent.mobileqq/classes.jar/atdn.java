import com.tencent.qphone.base.util.BaseApplication;

class atdn
  implements atdp
{
  private bktt jdField_a_of_type_Bktt = new bktt();
  
  public atdn(atdm paramatdm)
  {
    this.jdField_a_of_type_Bktt.a();
  }
  
  public int a(long paramLong1, long paramLong2)
  {
    int j = this.jdField_a_of_type_Bktt.a(BaseApplication.getContext(), paramLong2, paramLong1, 1048576);
    int k = bktw.a(BaseApplication.getContext());
    int i;
    if (k != 1)
    {
      i = j;
      if (k != 2) {}
    }
    else
    {
      i = j;
      if (j > 16384) {
        i = 16384;
      }
    }
    return i;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bktt.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atdn
 * JD-Core Version:    0.7.0.1
 */