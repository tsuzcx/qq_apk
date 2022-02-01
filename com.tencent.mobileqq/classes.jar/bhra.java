import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class bhra
  extends bhri
{
  public void a(String paramString)
  {
    QLog.i("GLDrawable", 1, paramString);
  }
  
  public void a(String paramString, Exception paramException)
  {
    QLog.e("GLDrawable", 1, paramString, paramException);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("status_code", paramString2);
    localHashMap.put("status_msg", paramString3);
    localHashMap.put("scid", "GLDrawableV848");
    bhpu.a(paramString1, paramLong, localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhra
 * JD-Core Version:    0.7.0.1
 */