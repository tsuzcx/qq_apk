import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aojk
{
  public static final String c = asiv.jdField_a_of_type_JavaLangString + "GameCenterMsgBean";
  public int a;
  public String a;
  public String b = asin.c;
  
  public aojk()
  {
    this.jdField_a_of_type_JavaLangString = asin.b;
  }
  
  public static aojk a(aogf[] paramArrayOfaogf)
  {
    aojk localaojk = new aojk();
    int i = 0;
    for (;;)
    {
      if (i < paramArrayOfaogf.length)
      {
        Object localObject = paramArrayOfaogf[i].jdField_a_of_type_JavaLangString;
        try
        {
          localObject = new JSONObject((String)localObject);
          localaojk.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("gameMsgFuncSwitch");
          localaojk.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("gameMsgListUrl");
          localaojk.b = ((JSONObject)localObject).optString("gamePrefix");
          QLog.i(c, 1, "[parse], mGraySwitch:" + localaojk.jdField_a_of_type_Int + ",url:" + localaojk.jdField_a_of_type_JavaLangString);
          i += 1;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            QLog.e(c, 1, localThrowable, new Object[0]);
          }
        }
      }
    }
    return localaojk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aojk
 * JD-Core Version:    0.7.0.1
 */