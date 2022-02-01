import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class arbm
{
  private int a;
  private int b;
  private int c;
  private int d;
  
  public static arbm a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg == null) || (paramArrayOfaqlg.length <= 0)) {
      paramArrayOfaqlg = null;
    }
    arbm localarbm;
    for (;;)
    {
      return paramArrayOfaqlg;
      localarbm = new arbm();
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaqlg[0].a);
        if (localJSONObject.has("flag"))
        {
          localarbm.d = localJSONObject.getInt("flag");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips flag = " + localarbm.d);
          }
        }
        if (localJSONObject.has("showCount"))
        {
          localarbm.c = localJSONObject.getInt("showCount");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips showCount = " + localarbm.c);
          }
        }
        if (localJSONObject.has("groupFlag"))
        {
          localarbm.b = localJSONObject.getInt("groupFlag");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips groupFlag = " + localarbm.b);
          }
        }
        paramArrayOfaqlg = localarbm;
        if (localJSONObject.has("groupShowCount"))
        {
          localarbm.a = localJSONObject.getInt("groupShowCount");
          paramArrayOfaqlg = localarbm;
          if (QLog.isColorLevel())
          {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips groupShowCount = " + localarbm.a);
            return localarbm;
          }
        }
      }
      catch (Exception paramArrayOfaqlg)
      {
        QLog.e("TencentDocStructMsgGrayTipsConfigBean", 1, "handleDocsStructMsgGrayTips e " + paramArrayOfaqlg.toString());
      }
    }
    return localarbm;
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
 * Qualified Name:     arbm
 * JD-Core Version:    0.7.0.1
 */