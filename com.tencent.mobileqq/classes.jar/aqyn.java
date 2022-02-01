import com.tencent.qphone.base.util.QLog;

public class aqyn
{
  protected String a = "";
  
  public aqyn() {}
  
  public aqyn(String paramString)
  {
    if (paramString != null) {
      this.a = paramString;
    }
  }
  
  public aqyo a()
  {
    if ((this instanceof aqyo)) {
      return (aqyo)this;
    }
    QLog.e("ArkConfBean", 1, "this object is not a ArkAIDictConfBean object");
    return null;
  }
  
  public aqyp a()
  {
    if ((this instanceof aqyp)) {
      return (aqyp)this;
    }
    QLog.e("ArkConfBean", 1, "this object is not a ArkAIKeyWordConfBean object");
    return null;
  }
  
  public aqyr a()
  {
    if ((this instanceof aqyr)) {
      return (aqyr)this;
    }
    QLog.e("ArkConfBean", 1, "this object is not a ArkMsgAIDisableConfBean object");
    return null;
  }
  
  public aqys a()
  {
    if ((this instanceof aqys)) {
      return (aqys)this;
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
 * Qualified Name:     aqyn
 * JD-Core Version:    0.7.0.1
 */