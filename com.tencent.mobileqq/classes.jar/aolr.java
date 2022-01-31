import com.tencent.qphone.base.util.QLog;

public class aolr
{
  protected String a = "";
  
  public aolr() {}
  
  public aolr(String paramString)
  {
    if (paramString != null) {
      this.a = paramString;
    }
  }
  
  public aols a()
  {
    if ((this instanceof aols)) {
      return (aols)this;
    }
    QLog.e("ArkConfBean", 1, "this object is not a ArkAIDictConfBean object");
    return null;
  }
  
  public aolt a()
  {
    if ((this instanceof aolt)) {
      return (aolt)this;
    }
    QLog.e("ArkConfBean", 1, "this object is not a ArkAIKeyWordConfBean object");
    return null;
  }
  
  public aolu a()
  {
    if ((this instanceof aolu)) {
      return (aolu)this;
    }
    QLog.e("ArkConfBean", 1, "this object is not a ArkAIKeyWordSDKShareConfBean object");
    return null;
  }
  
  public aolv a()
  {
    if ((this instanceof aolv)) {
      return (aolv)this;
    }
    QLog.e("ArkConfBean", 1, "this object is not a ArkMsgAIDisableConfBean object");
    return null;
  }
  
  public aolw a()
  {
    if ((this instanceof aolw)) {
      return (aolw)this;
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
 * Qualified Name:     aolr
 * JD-Core Version:    0.7.0.1
 */