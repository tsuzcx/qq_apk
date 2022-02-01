import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import org.json.JSONObject;

public class aotb
  extends aouc
{
  public aotb(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean c(String paramString)
  {
    int k = 0;
    int j = 0;
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return true;
      paramString = paramString.split("\\?");
    } while ((paramString == null) || (paramString.length < 2));
    long l1 = 0L;
    paramString = paramString[1];
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(URLDecoder.decode(paramString.substring(paramString.indexOf('=') + 1), "UTF-8"));
        int i = ((JSONObject)localObject).optInt("gameId");
        j = k;
        long l2;
        paramString.printStackTrace();
      }
      catch (Exception paramString)
      {
        try
        {
          l2 = ((JSONObject)localObject).optLong("roomId");
          l1 = l2;
          j = k;
          paramString = ((JSONObject)localObject).optString("gameName");
          l1 = l2;
          j = k;
          k = ((JSONObject)localObject).optInt("gameMode");
          l1 = l2;
          j = k;
          localObject = ((JSONObject)localObject).optString("extendInfo");
          l1 = l2;
          j = k;
          ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, l2, k, (String)localObject, 204, paramString);
          j = k;
          l1 = l2;
          QLog.i("CMShowGameInviteAction", 1, "[gotoCmShowGame], gameId:" + i + ",roomId:" + l1 + ",gameMode:" + j);
          return true;
        }
        catch (Exception paramString)
        {
          break label212;
        }
        paramString = paramString;
        i = 0;
      }
      label212:
      QLog.w("CMShowGameInviteAction", 1, "[gotoCmShowGame], errInfo->" + paramString.getMessage());
    }
  }
  
  public boolean a()
  {
    try
    {
      QLog.i("CMShowGameInviteAction", 1, "[cmshow.game_invite], source:" + this.jdField_a_of_type_JavaLangString);
      boolean bool = c(this.jdField_a_of_type_JavaLangString);
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("CMShowGameInviteAction", 1, "doAction error: " + localException.getMessage());
      a("CMShowGameInviteAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aotb
 * JD-Core Version:    0.7.0.1
 */