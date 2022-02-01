import com.tencent.qphone.base.util.QLog;

public class apvk
{
  protected String a = "";
  
  public apvk() {}
  
  public apvk(String paramString)
  {
    if (paramString != null) {
      this.a = paramString;
    }
  }
  
  public apvl a()
  {
    if ((this instanceof apvl)) {
      return (apvl)this;
    }
    QLog.e("ArkConfBean", 1, "this object is not a ArkAIDictConfBean object");
    return null;
  }
  
  public apvm a()
  {
    if ((this instanceof apvm)) {
      return (apvm)this;
    }
    QLog.e("ArkConfBean", 1, "this object is not a ArkAIKeyWordConfBean object");
    return null;
  }
  
  public apvo a()
  {
    if ((this instanceof apvo)) {
      return (apvo)this;
    }
    QLog.e("ArkConfBean", 1, "this object is not a ArkMsgAIDisableConfBean object");
    return null;
  }
  
  public apvp a()
  {
    if ((this instanceof apvp)) {
      return (apvp)this;
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
 * Qualified Name:     apvk
 * JD-Core Version:    0.7.0.1
 */