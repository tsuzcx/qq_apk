import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aoym
{
  private int a;
  private int b;
  private int c;
  private int d;
  
  public static aoym a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko == null) || (paramArrayOfaoko.length <= 0)) {
      paramArrayOfaoko = null;
    }
    aoym localaoym;
    for (;;)
    {
      return paramArrayOfaoko;
      localaoym = new aoym();
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaoko[0].a);
        if (localJSONObject.has("flag"))
        {
          localaoym.d = localJSONObject.getInt("flag");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips flag = " + localaoym.d);
          }
        }
        if (localJSONObject.has("showCount"))
        {
          localaoym.c = localJSONObject.getInt("showCount");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips showCount = " + localaoym.c);
          }
        }
        if (localJSONObject.has("groupFlag"))
        {
          localaoym.b = localJSONObject.getInt("groupFlag");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips groupFlag = " + localaoym.b);
          }
        }
        paramArrayOfaoko = localaoym;
        if (localJSONObject.has("groupShowCount"))
        {
          localaoym.a = localJSONObject.getInt("groupShowCount");
          paramArrayOfaoko = localaoym;
          if (QLog.isColorLevel())
          {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips groupShowCount = " + localaoym.a);
            return localaoym;
          }
        }
      }
      catch (Exception paramArrayOfaoko)
      {
        QLog.e("TencentDocStructMsgGrayTipsConfigBean", 1, "handleDocsStructMsgGrayTips e " + paramArrayOfaoko.toString());
      }
    }
    return localaoym;
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
 * Qualified Name:     aoym
 * JD-Core Version:    0.7.0.1
 */