import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aont
{
  public static final String c = asne.jdField_a_of_type_JavaLangString + "GameCenterMsgBean";
  public int a;
  public String a;
  public String b = asmw.c;
  
  public aont()
  {
    this.jdField_a_of_type_JavaLangString = asmw.b;
  }
  
  public static aont a(aoko[] paramArrayOfaoko)
  {
    aont localaont = new aont();
    int i = 0;
    for (;;)
    {
      if (i < paramArrayOfaoko.length)
      {
        Object localObject = paramArrayOfaoko[i].jdField_a_of_type_JavaLangString;
        try
        {
          localObject = new JSONObject((String)localObject);
          localaont.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("gameMsgFuncSwitch");
          localaont.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("gameMsgListUrl");
          localaont.b = ((JSONObject)localObject).optString("gamePrefix");
          QLog.i(c, 1, "[parse], mGraySwitch:" + localaont.jdField_a_of_type_Int + ",url:" + localaont.jdField_a_of_type_JavaLangString);
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
    return localaont;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aont
 * JD-Core Version:    0.7.0.1
 */