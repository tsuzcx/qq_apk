import com.tencent.qphone.base.util.QLog;

public class aqmp
{
  protected String a = "";
  
  public aqmp() {}
  
  public aqmp(String paramString)
  {
    if (paramString != null) {
      this.a = paramString;
    }
  }
  
  public aqmq a()
  {
    if ((this instanceof aqmq)) {
      return (aqmq)this;
    }
    QLog.e("ArkConfBean", 1, "this object is not a ArkAIDictConfBean object");
    return null;
  }
  
  public aqmr a()
  {
    if ((this instanceof aqmr)) {
      return (aqmr)this;
    }
    QLog.e("ArkConfBean", 1, "this object is not a ArkAIKeyWordConfBean object");
    return null;
  }
  
  public aqmt a()
  {
    if ((this instanceof aqmt)) {
      return (aqmt)this;
    }
    QLog.e("ArkConfBean", 1, "this object is not a ArkMsgAIDisableConfBean object");
    return null;
  }
  
  public aqmu a()
  {
    if ((this instanceof aqmu)) {
      return (aqmu)this;
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
 * Qualified Name:     aqmp
 * JD-Core Version:    0.7.0.1
 */