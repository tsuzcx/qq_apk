import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ancr
{
  private int a;
  private int b;
  private int c;
  private int d;
  
  public static ancr a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi == null) || (paramArrayOfampi.length <= 0)) {
      paramArrayOfampi = null;
    }
    ancr localancr;
    for (;;)
    {
      return paramArrayOfampi;
      localancr = new ancr();
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfampi[0].a);
        if (localJSONObject.has("flag"))
        {
          localancr.d = localJSONObject.getInt("flag");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips flag = " + localancr.d);
          }
        }
        if (localJSONObject.has("showCount"))
        {
          localancr.c = localJSONObject.getInt("showCount");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips showCount = " + localancr.c);
          }
        }
        if (localJSONObject.has("groupFlag"))
        {
          localancr.b = localJSONObject.getInt("groupFlag");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips groupFlag = " + localancr.b);
          }
        }
        paramArrayOfampi = localancr;
        if (localJSONObject.has("groupShowCount"))
        {
          localancr.a = localJSONObject.getInt("groupShowCount");
          paramArrayOfampi = localancr;
          if (QLog.isColorLevel())
          {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips groupShowCount = " + localancr.a);
            return localancr;
          }
        }
      }
      catch (Exception paramArrayOfampi)
      {
        QLog.e("TencentDocStructMsgGrayTipsConfigBean", 1, "handleDocsStructMsgGrayTips e " + paramArrayOfampi.toString());
      }
    }
    return localancr;
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
 * Qualified Name:     ancr
 * JD-Core Version:    0.7.0.1
 */