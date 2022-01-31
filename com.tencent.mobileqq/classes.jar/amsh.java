import com.tencent.qphone.base.util.QLog;

public class amsh
{
  public String a = "";
  
  public static amsh a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        amsh localamsh = new amsh();
        localamsh.a = paramString;
        QLog.d("ConfBean", 2, "confBean = " + localamsh.toString());
        return localamsh;
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
 * Qualified Name:     amsh
 * JD-Core Version:    0.7.0.1
 */