import com.tencent.mobileqq.filemanager.settings.FMSettings.4;

public class aptn
  implements aptl
{
  public aptn(FMSettings.4 param4) {}
  
  public void a()
  {
    synchronized (this.a.this$0)
    {
      aptm localaptm2 = this.a.this$0;
      localaptm2.jdField_a_of_type_Int += 1;
      aptm.a(1, "onMovedOver,count[" + this.a.this$0.jdField_a_of_type_Int + "],total[" + this.a.jdField_a_of_type_Int + "]");
      if (this.a.this$0.jdField_a_of_type_Int == this.a.jdField_a_of_type_Int)
      {
        aptm.a(1, "moveFileToDefaultPath,move over!");
        this.a.jdField_a_of_type_Aptl.a();
      }
      return;
    }
  }
  
  public void a(int paramInt)
  {
    synchronized (this.a.this$0)
    {
      aptm localaptm2 = this.a.this$0;
      localaptm2.jdField_a_of_type_Int += 1;
      aptm.a(1, "onMoveFail,count[" + this.a.this$0.jdField_a_of_type_Int + "],total[" + this.a.jdField_a_of_type_Int + "]");
      if (this.a.this$0.jdField_a_of_type_Int == this.a.jdField_a_of_type_Int)
      {
        aptm.a(1, "moveFileToDefaultPath,move over!");
        this.a.jdField_a_of_type_Aptl.a(16);
      }
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    aptm localaptm = this.a.this$0;
    localaptm.jdField_a_of_type_Long += paramLong1;
    this.a.jdField_a_of_type_Aptl.a(this.a.this$0.jdField_a_of_type_Long, this.a.this$0.b);
  }
  
  public void a(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aptn
 * JD-Core Version:    0.7.0.1
 */