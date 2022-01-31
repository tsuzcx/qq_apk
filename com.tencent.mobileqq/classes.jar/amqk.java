import com.tencent.qphone.base.util.QLog;

public class amqk
{
  protected String a = "";
  
  public amqk() {}
  
  public amqk(String paramString)
  {
    if (paramString != null) {
      this.a = paramString;
    }
  }
  
  public amql a()
  {
    if ((this instanceof amql)) {
      return (amql)this;
    }
    QLog.e("ArkConfBean", 1, "this object is not a ArkAIDictConfBean object");
    return null;
  }
  
  public amqm a()
  {
    if ((this instanceof amqm)) {
      return (amqm)this;
    }
    QLog.e("ArkConfBean", 1, "this object is not a ArkAIKeyWordConfBean object");
    return null;
  }
  
  public amqn a()
  {
    if ((this instanceof amqn)) {
      return (amqn)this;
    }
    QLog.e("ArkConfBean", 1, "this object is not a ArkAIKeyWordSDKShareConfBean object");
    return null;
  }
  
  public amqo a()
  {
    if ((this instanceof amqo)) {
      return (amqo)this;
    }
    QLog.e("ArkConfBean", 1, "this object is not a ArkMsgAIDisableConfBean object");
    return null;
  }
  
  public amqp a()
  {
    if ((this instanceof amqp)) {
      return (amqp)this;
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
 * Qualified Name:     amqk
 * JD-Core Version:    0.7.0.1
 */