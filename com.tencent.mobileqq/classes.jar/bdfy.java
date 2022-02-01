import com.tencent.mobileqq.soload.LoadOptions;

public class bdfy
{
  private LoadOptions a = new LoadOptions();
  
  bdfy a(boolean paramBoolean)
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
  
  bdfy b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localLoadOptions = this.a;
      localLoadOptions.flag |= 0x8;
      return this;
    }
    LoadOptions localLoadOptions = this.a;
    localLoadOptions.flag &= 0xFFFFFFF7;
    return this;
  }
  
  bdfy c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localLoadOptions = this.a;
      localLoadOptions.flag |= 0x10;
      return this;
    }
    LoadOptions localLoadOptions = this.a;
    localLoadOptions.flag &= 0xFFFFFFEF;
    return this;
  }
  
  bdfy d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localLoadOptions = this.a;
      localLoadOptions.flag |= 0x20;
      return this;
    }
    LoadOptions localLoadOptions = this.a;
    localLoadOptions.flag &= 0xFFFFFFDF;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdfy
 * JD-Core Version:    0.7.0.1
 */