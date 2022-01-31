import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ammk
{
  private int a;
  private int b;
  private int c;
  private int d;
  
  public static ammk a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs == null) || (paramArrayOfalzs.length <= 0)) {
      paramArrayOfalzs = null;
    }
    ammk localammk;
    for (;;)
    {
      return paramArrayOfalzs;
      localammk = new ammk();
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfalzs[0].a);
        if (localJSONObject.has("flag"))
        {
          localammk.d = localJSONObject.getInt("flag");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips flag = " + localammk.d);
          }
        }
        if (localJSONObject.has("showCount"))
        {
          localammk.c = localJSONObject.getInt("showCount");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips showCount = " + localammk.c);
          }
        }
        if (localJSONObject.has("groupFlag"))
        {
          localammk.b = localJSONObject.getInt("groupFlag");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips groupFlag = " + localammk.b);
          }
        }
        paramArrayOfalzs = localammk;
        if (localJSONObject.has("groupShowCount"))
        {
          localammk.a = localJSONObject.getInt("groupShowCount");
          paramArrayOfalzs = localammk;
          if (QLog.isColorLevel())
          {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips groupShowCount = " + localammk.a);
            return localammk;
          }
        }
      }
      catch (Exception paramArrayOfalzs)
      {
        QLog.e("TencentDocStructMsgGrayTipsConfigBean", 1, "handleDocsStructMsgGrayTips e " + paramArrayOfalzs.toString());
      }
    }
    return localammk;
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
 * Qualified Name:     ammk
 * JD-Core Version:    0.7.0.1
 */