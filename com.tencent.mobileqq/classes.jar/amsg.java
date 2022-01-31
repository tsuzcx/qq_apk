import com.tencent.qphone.base.util.QLog;

public class amsg
{
  public String a = "";
  
  public static amsg a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        amsg localamsg = new amsg();
        localamsg.a = paramString;
        QLog.d("ConfBean", 2, "confBean = " + localamsg.toString());
        return localamsg;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("ConfBean", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("configContent:").append(this.a);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amsg
 * JD-Core Version:    0.7.0.1
 */