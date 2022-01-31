import com.tencent.mobileqq.filemanager.settings.FMSettings.4;

public class apbp
  implements apbn
{
  public apbp(FMSettings.4 param4) {}
  
  public void a()
  {
    synchronized (this.a.this$0)
    {
      apbo localapbo2 = this.a.this$0;
      localapbo2.jdField_a_of_type_Int += 1;
      apbo.a(1, "onMovedOver,count[" + this.a.this$0.jdField_a_of_type_Int + "],total[" + this.a.jdField_a_of_type_Int + "]");
      if (this.a.this$0.jdField_a_of_type_Int == this.a.jdField_a_of_type_Int)
      {
        apbo.a(1, "moveFileToDefaultPath,move over!");
        this.a.jdField_a_of_type_Apbn.a();
      }
      return;
    }
  }
  
  public void a(int paramInt)
  {
    synchronized (this.a.this$0)
    {
      apbo localapbo2 = this.a.this$0;
      localapbo2.jdField_a_of_type_Int += 1;
      apbo.a(1, "onMoveFail,count[" + this.a.this$0.jdField_a_of_type_Int + "],total[" + this.a.jdField_a_of_type_Int + "]");
      if (this.a.this$0.jdField_a_of_type_Int == this.a.jdField_a_of_type_Int)
      {
        apbo.a(1, "moveFileToDefaultPath,move over!");
        this.a.jdField_a_of_type_Apbn.a(16);
      }
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    apbo localapbo = this.a.this$0;
    localapbo.jdField_a_of_type_Long += paramLong1;
    this.a.jdField_a_of_type_Apbn.a(this.a.this$0.jdField_a_of_type_Long, this.a.this$0.b);
  }
  
  public void a(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apbp
 * JD-Core Version:    0.7.0.1
 */