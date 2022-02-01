import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class arok
{
  private int a;
  private int b;
  private int c;
  private int d;
  
  public static arok a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length <= 0)) {
      paramArrayOfaqxa = null;
    }
    arok localarok;
    for (;;)
    {
      return paramArrayOfaqxa;
      localarok = new arok();
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaqxa[0].a);
        if (localJSONObject.has("flag"))
        {
          localarok.d = localJSONObject.getInt("flag");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips flag = " + localarok.d);
          }
        }
        if (localJSONObject.has("showCount"))
        {
          localarok.c = localJSONObject.getInt("showCount");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips showCount = " + localarok.c);
          }
        }
        if (localJSONObject.has("groupFlag"))
        {
          localarok.b = localJSONObject.getInt("groupFlag");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips groupFlag = " + localarok.b);
          }
        }
        paramArrayOfaqxa = localarok;
        if (localJSONObject.has("groupShowCount"))
        {
          localarok.a = localJSONObject.getInt("groupShowCount");
          paramArrayOfaqxa = localarok;
          if (QLog.isColorLevel())
          {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips groupShowCount = " + localarok.a);
            return localarok;
          }
        }
      }
      catch (Exception paramArrayOfaqxa)
      {
        QLog.e("TencentDocStructMsgGrayTipsConfigBean", 1, "handleDocsStructMsgGrayTips e " + paramArrayOfaqxa.toString());
      }
    }
    return localarok;
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
 * Qualified Name:     arok
 * JD-Core Version:    0.7.0.1
 */