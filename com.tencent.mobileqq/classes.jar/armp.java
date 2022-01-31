import com.tencent.mobileqq.filemanager.settings.FMSettings.4;

public class armp
  implements armn
{
  public armp(FMSettings.4 param4) {}
  
  public void a()
  {
    synchronized (this.a.this$0)
    {
      armo localarmo2 = this.a.this$0;
      localarmo2.jdField_a_of_type_Int += 1;
      armo.a(1, "onMovedOver,count[" + this.a.this$0.jdField_a_of_type_Int + "],total[" + this.a.jdField_a_of_type_Int + "]");
      if (this.a.this$0.jdField_a_of_type_Int == this.a.jdField_a_of_type_Int)
      {
        armo.a(1, "moveFileToDefaultPath,move over!");
        this.a.jdField_a_of_type_Armn.a();
      }
      return;
    }
  }
  
  public void a(int paramInt)
  {
    synchronized (this.a.this$0)
    {
      armo localarmo2 = this.a.this$0;
      localarmo2.jdField_a_of_type_Int += 1;
      armo.a(1, "onMoveFail,count[" + this.a.this$0.jdField_a_of_type_Int + "],total[" + this.a.jdField_a_of_type_Int + "]");
      if (this.a.this$0.jdField_a_of_type_Int == this.a.jdField_a_of_type_Int)
      {
        armo.a(1, "moveFileToDefaultPath,move over!");
        this.a.jdField_a_of_type_Armn.a(16);
      }
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    armo localarmo = this.a.this$0;
    localarmo.jdField_a_of_type_Long += paramLong1;
    this.a.jdField_a_of_type_Armn.a(this.a.this$0.jdField_a_of_type_Long, this.a.this$0.b);
  }
  
  public void a(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     armp
 * JD-Core Version:    0.7.0.1
 */