import com.tencent.qphone.base.util.QLog;

public class aqow
{
  @awfx(a="isShowAssistantEntrance")
  public int a;
  @awfx(a="kuolieAIOEnable")
  public int b;
  
  public static aqow a(String paramString)
  {
    aqow localaqow = (aqow)awfy.a(paramString, aqow.class);
    if (QLog.isColorLevel()) {
      if ("parse: " + localaqow == null) {
        break label52;
      }
    }
    label52:
    for (paramString = localaqow.toString();; paramString = " C2CShortcutBarConfBean is null")
    {
      QLog.d("C2CShortcutBarConfBean", 2, paramString);
      return localaqow;
    }
  }
  
  public boolean a()
  {
    return this.a == 1;
  }
  
  public boolean b()
  {
    return this.b == 1;
  }
  
  public String toString()
  {
    return "C2CShortcutBarConfBean{isShowAssistantEntrance = " + this.a + "kuolieAIOEnable = " + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqow
 * JD-Core Version:    0.7.0.1
 */