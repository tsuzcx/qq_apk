import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class arrb
{
  private int a;
  private int b;
  private int c;
  private int d;
  
  public static arrb a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length <= 0)) {
      paramArrayOfaraj = null;
    }
    arrb localarrb;
    for (;;)
    {
      return paramArrayOfaraj;
      localarrb = new arrb();
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaraj[0].a);
        if (localJSONObject.has("flag"))
        {
          localarrb.d = localJSONObject.getInt("flag");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips flag = " + localarrb.d);
          }
        }
        if (localJSONObject.has("showCount"))
        {
          localarrb.c = localJSONObject.getInt("showCount");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips showCount = " + localarrb.c);
          }
        }
        if (localJSONObject.has("groupFlag"))
        {
          localarrb.b = localJSONObject.getInt("groupFlag");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips groupFlag = " + localarrb.b);
          }
        }
        paramArrayOfaraj = localarrb;
        if (localJSONObject.has("groupShowCount"))
        {
          localarrb.a = localJSONObject.getInt("groupShowCount");
          paramArrayOfaraj = localarrb;
          if (QLog.isColorLevel())
          {
            QLog.d("TencentDocStructMsgGrayTipsConfigBean", 2, "handleDocsStructMsgGrayTips groupShowCount = " + localarrb.a);
            return localarrb;
          }
        }
      }
      catch (Exception paramArrayOfaraj)
      {
        QLog.e("TencentDocStructMsgGrayTipsConfigBean", 1, "handleDocsStructMsgGrayTips e " + paramArrayOfaraj.toString());
      }
    }
    return localarrb;
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
 * Qualified Name:     arrb
 * JD-Core Version:    0.7.0.1
 */