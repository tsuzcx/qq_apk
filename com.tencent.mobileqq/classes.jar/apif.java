import com.tencent.qphone.base.util.QLog;

public class apif
{
  @ausx(a="isShowAssistantEntrance")
  public int a;
  @ausx(a="kuolieAIOEnable")
  public int b;
  
  public static apif a(String paramString)
  {
    apif localapif = (apif)ausy.a(paramString, apif.class);
    if (QLog.isColorLevel()) {
      if ("parse: " + localapif == null) {
        break label52;
      }
    }
    label52:
    for (paramString = localapif.toString();; paramString = " C2CShortcutBarConfBean is null")
    {
      QLog.d("C2CShortcutBarConfBean", 2, paramString);
      return localapif;
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
 * Qualified Name:     apif
 * JD-Core Version:    0.7.0.1
 */