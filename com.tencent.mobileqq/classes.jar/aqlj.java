import com.tencent.qphone.base.util.QLog;

public class aqlj
{
  @avyw(a="isShowAssistantEntrance")
  public int a;
  @avyw(a="kuolieAIOEnable")
  public int b;
  
  public static aqlj a(String paramString)
  {
    aqlj localaqlj = (aqlj)avyx.a(paramString, aqlj.class);
    if (QLog.isColorLevel()) {
      if ("parse: " + localaqlj == null) {
        break label52;
      }
    }
    label52:
    for (paramString = localaqlj.toString();; paramString = " C2CShortcutBarConfBean is null")
    {
      QLog.d("C2CShortcutBarConfBean", 2, paramString);
      return localaqlj;
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
 * Qualified Name:     aqlj
 * JD-Core Version:    0.7.0.1
 */