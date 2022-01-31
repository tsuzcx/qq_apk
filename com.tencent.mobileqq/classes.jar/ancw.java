import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ancw
{
  private int a;
  private int b;
  private int c;
  private int d;
  
  public static ancw a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph == null) || (paramArrayOfamph.length <= 0)) {
      paramArrayOfamph = null;
    }
    ancw localancw;
    for (;;)
    {
      return paramArrayOfamph;
      localancw = new ancw();
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfamph[0].a);
        if (localJSONObject.has("flag"))
        {
          localancw.d = localJSONObject.getInt("flag");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips flag = " + localancw.d);
          }
        }
        if (localJSONObject.has("showCount"))
        {
          localancw.c = localJSONObject.getInt("showCount");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips showCount = " + localancw.c);
          }
        }
        if (localJSONObject.has("groupFlag"))
        {
          localancw.b = localJSONObject.getInt("groupFlag");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips groupFlag = " + localancw.b);
          }
        }
        paramArrayOfamph = localancw;
        if (localJSONObject.has("groupShowCount"))
        {
          localancw.a = localJSONObject.getInt("groupShowCount");
          paramArrayOfamph = localancw;
          if (QLog.isColorLevel())
          {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips groupShowCount = " + localancw.a);
            return localancw;
          }
        }
      }
      catch (Exception paramArrayOfamph)
      {
        QLog.e("TencentDocStructMsgGrayTipsConfigBean", 1, "handleDocsStructMsgGrayTips e " + paramArrayOfamph.toString());
      }
    }
    return localancw;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public int d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ancw
 * JD-Core Version:    0.7.0.1
 */