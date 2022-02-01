import com.tencent.mobileqq.filemanager.settings.FMSettings.4;

public class asyz
  implements asyx
{
  public asyz(FMSettings.4 param4) {}
  
  public void a()
  {
    synchronized (this.a.this$0)
    {
      asyy localasyy2 = this.a.this$0;
      localasyy2.jdField_a_of_type_Int += 1;
      asyy.a(1, "onMovedOver,count[" + this.a.this$0.jdField_a_of_type_Int + "],total[" + this.a.jdField_a_of_type_Int + "]");
      if (this.a.this$0.jdField_a_of_type_Int == this.a.jdField_a_of_type_Int)
      {
        asyy.a(1, "moveFileToDefaultPath,move over!");
        this.a.jdField_a_of_type_Asyx.a();
      }
      return;
    }
  }
  
  public void a(int paramInt)
  {
    synchronized (this.a.this$0)
    {
      asyy localasyy2 = this.a.this$0;
      localasyy2.jdField_a_of_type_Int += 1;
      asyy.a(1, "onMoveFail,count[" + this.a.this$0.jdField_a_of_type_Int + "],total[" + this.a.jdField_a_of_type_Int + "]");
      if (this.a.this$0.jdField_a_of_type_Int == this.a.jdField_a_of_type_Int)
      {
        asyy.a(1, "moveFileToDefaultPath,move over!");
        this.a.jdField_a_of_type_Asyx.a(16);
      }
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    asyy localasyy = this.a.this$0;
    localasyy.jdField_a_of_type_Long += paramLong1;
    this.a.jdField_a_of_type_Asyx.a(this.a.this$0.jdField_a_of_type_Long, this.a.this$0.b);
  }
  
  public void a(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asyz
 * JD-Core Version:    0.7.0.1
 */