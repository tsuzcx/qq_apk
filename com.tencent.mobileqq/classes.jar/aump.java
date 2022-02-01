import com.tencent.mobileqq.filemanager.settings.FMSettings.4;

public class aump
  implements aumn
{
  public aump(FMSettings.4 param4) {}
  
  public void a()
  {
    synchronized (this.a.this$0)
    {
      aumo localaumo2 = this.a.this$0;
      localaumo2.jdField_a_of_type_Int += 1;
      aumo.a(1, "onMovedOver,count[" + this.a.this$0.jdField_a_of_type_Int + "],total[" + this.a.jdField_a_of_type_Int + "]");
      if (this.a.this$0.jdField_a_of_type_Int == this.a.jdField_a_of_type_Int)
      {
        aumo.a(1, "moveFileToDefaultPath,move over!");
        this.a.jdField_a_of_type_Aumn.a();
      }
      return;
    }
  }
  
  public void a(int paramInt)
  {
    synchronized (this.a.this$0)
    {
      aumo localaumo2 = this.a.this$0;
      localaumo2.jdField_a_of_type_Int += 1;
      aumo.a(1, "onMoveFail,count[" + this.a.this$0.jdField_a_of_type_Int + "],total[" + this.a.jdField_a_of_type_Int + "]");
      if (this.a.this$0.jdField_a_of_type_Int == this.a.jdField_a_of_type_Int)
      {
        aumo.a(1, "moveFileToDefaultPath,move over!");
        this.a.jdField_a_of_type_Aumn.a(16);
      }
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    aumo localaumo = this.a.this$0;
    localaumo.jdField_a_of_type_Long += paramLong1;
    this.a.jdField_a_of_type_Aumn.a(this.a.this$0.jdField_a_of_type_Long, this.a.this$0.b);
  }
  
  public void a(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aump
 * JD-Core Version:    0.7.0.1
 */