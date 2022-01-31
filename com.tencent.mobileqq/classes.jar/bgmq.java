public class bgmq
  implements bgmc<Void>
{
  private int jdField_a_of_type_Int = -1;
  private bglv jdField_a_of_type_Bglv;
  private int b;
  
  public static bgmq a(bglv parambglv)
  {
    bgmq localbgmq = new bgmq();
    localbgmq.jdField_a_of_type_Bglv = parambglv;
    return localbgmq;
  }
  
  public Void a(bgls parambgls)
  {
    parambgls = parambgls.a();
    if (parambgls == null) {
      return null;
    }
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return null;
    case 1: 
      parambgls.setTabBarVisibility(this.b);
      return null;
    }
    parambgls.setNaviVisibility(this.b);
    return null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Bglv.a(this);
    this.b = paramInt;
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_Bglv.a(this);
    this.b = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgmq
 * JD-Core Version:    0.7.0.1
 */