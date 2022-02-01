import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqkz
{
  private int a;
  private int b;
  private int c;
  private int d;
  
  public static aqkz a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx == null) || (paramArrayOfaptx.length <= 0)) {
      paramArrayOfaptx = null;
    }
    aqkz localaqkz;
    for (;;)
    {
      return paramArrayOfaptx;
      localaqkz = new aqkz();
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaptx[0].a);
        if (localJSONObject.has("flag"))
        {
          localaqkz.d = localJSONObject.getInt("flag");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips flag = " + localaqkz.d);
          }
        }
        if (localJSONObject.has("showCount"))
        {
          localaqkz.c = localJSONObject.getInt("showCount");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips showCount = " + localaqkz.c);
          }
        }
        if (localJSONObject.has("groupFlag"))
        {
          localaqkz.b = localJSONObject.getInt("groupFlag");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips groupFlag = " + localaqkz.b);
          }
        }
        paramArrayOfaptx = localaqkz;
        if (localJSONObject.has("groupShowCount"))
        {
          localaqkz.a = localJSONObject.getInt("groupShowCount");
          paramArrayOfaptx = localaqkz;
          if (QLog.isColorLevel())
          {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips groupShowCount = " + localaqkz.a);
            return localaqkz;
          }
        }
      }
      catch (Exception paramArrayOfaptx)
      {
        QLog.e("TencentDocStructMsgGrayTipsConfigBean", 1, "handleDocsStructMsgGrayTips e " + paramArrayOfaptx.toString());
      }
    }
    return localaqkz;
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
 * Qualified Name:     aqkz
 * JD-Core Version:    0.7.0.1
 */