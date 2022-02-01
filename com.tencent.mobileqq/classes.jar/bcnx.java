import com.tencent.mobileqq.soload.LoadOptions;

public class bcnx
{
  private LoadOptions a = new LoadOptions();
  
  bcnx a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localLoadOptions = this.a;
      localLoadOptions.flag |= 0x1;
      return this;
    }
    LoadOptions localLoadOptions = this.a;
    localLoadOptions.flag &= 0xFFFFFFFE;
    return this;
  }
  
  public LoadOptions a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcnx
 * JD-Core Version:    0.7.0.1
 */