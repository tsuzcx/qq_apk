import com.tencent.qphone.base.util.QLog;

public class arbu
{
  protected String a = "";
  
  public arbu() {}
  
  public arbu(String paramString)
  {
    if (paramString != null) {
      this.a = paramString;
    }
  }
  
  public arbv a()
  {
    if ((this instanceof arbv)) {
      return (arbv)this;
    }
    QLog.e("ArkConfBean", 1, "this object is not a ArkAIDictConfBean object");
    return null;
  }
  
  public arbw a()
  {
    if ((this instanceof arbw)) {
      return (arbw)this;
    }
    QLog.e("ArkConfBean", 1, "this object is not a ArkAIKeyWordConfBean object");
    return null;
  }
  
  public arby a()
  {
    if ((this instanceof arby)) {
      return (arby)this;
    }
    QLog.e("ArkConfBean", 1, "this object is not a ArkMsgAIDisableConfBean object");
    return null;
  }
  
  public arbz a()
  {
    if ((this instanceof arbz)) {
      return (arbz)this;
    }
    QLog.e("ArkConfBean", 1, "this object is not a ArkPlatformConfigBean object");
    return null;
  }
  
  public String a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arbu
 * JD-Core Version:    0.7.0.1
 */