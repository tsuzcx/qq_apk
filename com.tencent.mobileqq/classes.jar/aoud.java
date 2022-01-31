import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aoud
{
  private int a;
  private int b;
  private int c;
  private int d;
  
  public static aoud a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf == null) || (paramArrayOfaogf.length <= 0)) {
      paramArrayOfaogf = null;
    }
    aoud localaoud;
    for (;;)
    {
      return paramArrayOfaogf;
      localaoud = new aoud();
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaogf[0].a);
        if (localJSONObject.has("flag"))
        {
          localaoud.d = localJSONObject.getInt("flag");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips flag = " + localaoud.d);
          }
        }
        if (localJSONObject.has("showCount"))
        {
          localaoud.c = localJSONObject.getInt("showCount");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips showCount = " + localaoud.c);
          }
        }
        if (localJSONObject.has("groupFlag"))
        {
          localaoud.b = localJSONObject.getInt("groupFlag");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips groupFlag = " + localaoud.b);
          }
        }
        paramArrayOfaogf = localaoud;
        if (localJSONObject.has("groupShowCount"))
        {
          localaoud.a = localJSONObject.getInt("groupShowCount");
          paramArrayOfaogf = localaoud;
          if (QLog.isColorLevel())
          {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips groupShowCount = " + localaoud.a);
            return localaoud;
          }
        }
      }
      catch (Exception paramArrayOfaogf)
      {
        QLog.e("TencentDocStructMsgGrayTipsConfigBean", 1, "handleDocsStructMsgGrayTips e " + paramArrayOfaogf.toString());
      }
    }
    return localaoud;
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
 * Qualified Name:     aoud
 * JD-Core Version:    0.7.0.1
 */