import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;

class aomg
  extends aomf
{
  private String a;
  
  public aomg(String paramString)
  {
    this.a = paramString;
  }
  
  public Object a(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return null;
      paramObject = (LinkedHashMap)paramObject;
      if (!(paramObject instanceof LinkedHashMap))
      {
        QLog.e("ArkMsgReplyConfigMgr", 1, "getElement instance wrong");
        return null;
      }
    } while (TextUtils.isEmpty(this.a));
    return paramObject.get(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aomg
 * JD-Core Version:    0.7.0.1
 */