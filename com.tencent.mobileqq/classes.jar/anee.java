import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.process.download.CmGameSubRscHandler.1;
import com.tencent.mobileqq.apollo.process.download.CmGameSubRscHandler.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class anee
  implements anej
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private Map<String, anei> jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new LinkedHashMap());
  
  public anee(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilMap.clear();
    ThreadManager.excute(new CmGameSubRscHandler.1(this), 64, null, true);
  }
  
  private int a(String paramString1, String paramString2)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder(100);
      localStringBuilder.append(annv.s).append(this.jdField_a_of_type_Int).append(File.separator).append(paramString2).append(File.separator).append("config.json");
      paramString2 = new File(localStringBuilder.toString());
      if (!paramString2.exists()) {
        return -1;
      }
      int i = (int)new JSONObject(bhmi.b(paramString2)).optDouble("version");
      paramString1 = (anei)this.jdField_a_of_type_JavaUtilMap.get(paramString1);
      if (paramString1 != null) {
        paramString1.jdField_a_of_type_Int = i;
      }
      return i;
    }
    catch (Throwable paramString1)
    {
      QLog.e("cmgame_process.CmGameSubRscHandler", 1, paramString1, new Object[0]);
    }
    return -1;
  }
  
  public String a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append(annv.s).append(this.jdField_a_of_type_Int).append("/").append(a(paramString));
    return localStringBuilder.toString();
  }
  
  public String a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilMap.size() == 0) {
      a();
    }
    Object localObject = (anei)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localObject == null)
    {
      localObject = "";
      return localObject;
    }
    String str = ((anei)localObject).jdField_b_of_type_JavaLangString;
    if (TextUtils.isEmpty(str))
    {
      a();
      str = ((anei)localObject).jdField_b_of_type_JavaLangString;
    }
    for (;;)
    {
      localObject = str;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("cmgame_process.CmGameSubRscHandler", 2, new Object[] { "name:", paramString, ",root:", str });
      return str;
    }
  }
  
  public void a()
  {
    try
    {
      QLog.i("cmgame_process.CmGameSubRscHandler", 1, "[parseConfig]");
      Object localObject1 = new StringBuilder(100);
      ((StringBuilder)localObject1).append(annv.s).append(this.jdField_a_of_type_Int).append(File.separator).append("gameConfig.json");
      localObject1 = new File(((StringBuilder)localObject1).toString());
      if (!((File)localObject1).exists()) {
        QLog.w("cmgame_process.CmGameSubRscHandler", 1, "[parsePackRoot], gameConfig.json NOT exist.");
      }
      for (;;)
      {
        return;
        JSONArray localJSONArray = new JSONObject(bhmi.b((File)localObject1)).optJSONArray("subpackages");
        if (localJSONArray != null)
        {
          int i = 0;
          while (i < localJSONArray.length())
          {
            localObject1 = localJSONArray.optJSONObject(i);
            String str1 = ((JSONObject)localObject1).optString("name");
            String str2 = ((JSONObject)localObject1).optString("root");
            anei localanei = (anei)this.jdField_a_of_type_JavaUtilMap.get(str1);
            localObject1 = localanei;
            if (localanei == null) {
              localObject1 = new anei();
            }
            ((anei)localObject1).jdField_a_of_type_JavaLangString = str1;
            ((anei)localObject1).jdField_b_of_type_JavaLangString = str2;
            this.jdField_a_of_type_JavaUtilMap.put(str1, localObject1);
            a(str1, str2);
            i += 1;
          }
          QLog.i("cmgame_process.CmGameSubRscHandler", 1, "[parseConfig], done.");
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("cmgame_process.CmGameSubRscHandler", 1, localThrowable, new Object[0]);
      }
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("packName", paramString);
      localJSONObject.put("percentage", paramInt1);
      paramString = anbd.a();
      if (paramString != null) {
        paramString.callbackFromRequest(this.jdField_a_of_type_Long, 0, "sc.load_percentage_nofity.local", localJSONObject.toString());
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameSubRscHandler", 1, paramString, new Object[0]);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    QLog.i("cmgame_process.CmGameSubRscHandler", 1, "[onStartDownload], gameId:" + paramInt + ",packN:" + paramString);
  }
  
  public void a(long paramLong, String paramString)
  {
    anen localanen;
    String str;
    try
    {
      this.jdField_a_of_type_Long = paramLong;
      localanen = anbd.a();
      if (localanen == null)
      {
        QLog.w("cmgame_process.CmGameSubRscHandler", 1, "jsState:" + paramLong);
        return;
      }
      str = new JSONObject(paramString).optString("packName");
      if (TextUtils.isEmpty(str))
      {
        c(-10003, "");
        return;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameSubRscHandler", 1, paramString, new Object[0]);
      return;
    }
    andv localandv = new andv();
    localandv.jdField_a_of_type_Int = 10001;
    localandv.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_Int + "_" + str);
    paramString = (anei)this.jdField_a_of_type_JavaUtilMap.get(str);
    if (paramString != null)
    {
      if ((paramString.jdField_a_of_type_Anea != null) && (paramString.jdField_a_of_type_Anea.a() == 1))
      {
        c(-1004, str);
        return;
      }
      localandv.jdField_b_of_type_Int = paramString.jdField_a_of_type_Int;
      paramString.jdField_a_of_type_JavaLangString = str;
    }
    while ((paramString.jdField_a_of_type_Boolean) && (!BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 4).getBoolean("apollo_sp_game_rsc_verify_" + localandv.jdField_a_of_type_JavaLangString, false)))
    {
      QLog.i("cmgame_process.CmGameSubRscHandler", 1, "each pack requst only once in game.");
      b(this.jdField_a_of_type_Int, str);
      return;
      paramString = new anei();
      paramString.jdField_a_of_type_JavaLangString = str;
      localandv.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_JavaUtilMap.put(str, paramString);
    }
    QLog.i("cmgame_process.CmGameSubRscHandler", 1, "[cmgame_pack_sub], request, packname:" + str + ",ver:" + localandv.jdField_b_of_type_Int);
    paramString = new ArrayList();
    paramString.add(localandv);
    localanen.a(this.jdField_a_of_type_Int, str, paramString);
  }
  
  public void a(amxj paramamxj, long paramLong)
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) && (paramamxj != null))
    {
      QLog.w("cmgame_process.CmGameSubRscHandler", 1, "[onDownloadConfirm], ctx:" + this.jdField_a_of_type_AndroidContentContext);
      paramamxj.a(null);
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameSubRscHandler.2(this, paramLong, paramamxj));
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(aned paramaned)
  {
    if (paramaned == null) {}
    anea localanea = new anea(paramaned, this);
    anei localanei = (anei)this.jdField_a_of_type_JavaUtilMap.get(paramaned.jdField_b_of_type_JavaLangString);
    if (localanei != null) {
      localanei.jdField_a_of_type_Anea = localanea;
    }
    QLog.i("cmgame_process.CmGameSubRscHandler", 1, "[cmgame_pack_sub], response, isUpdate:" + paramaned.jdField_a_of_type_Boolean + ",svrVer:" + paramaned.jdField_a_of_type_Int + ",isPatch:" + paramaned.jdField_b_of_type_Boolean);
    if (!localanea.a()) {
      b(paramaned.jdField_b_of_type_Int, paramaned.jdField_b_of_type_JavaLangString);
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    c(0, paramString);
    anei localanei = (anei)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localanei != null)
    {
      localanei.jdField_a_of_type_Boolean = true;
      paramInt = a(paramString, localanei.jdField_b_of_type_JavaLangString);
      QLog.i("cmgame_process.CmGameSubRscHandler", 1, "[onDownloadSuccess], newV:" + paramInt + ",packName:" + paramString);
    }
  }
  
  public void b(long paramLong, String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameSubRscHandler", 2, "[verifyRsc]");
      }
      paramString = new JSONObject(paramString).optString("packName");
      Object localObject = (anei)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if (localObject == null) {
        return;
      }
      if (TextUtils.isEmpty(((anei)localObject).jdField_b_of_type_JavaLangString)) {
        a();
      }
      localObject = new anop(this.jdField_a_of_type_Int, 1, paramString, ((anei)localObject).jdField_b_of_type_JavaLangString);
      ((anop)localObject).a(new aneh(this, paramString));
      ((anop)localObject).a();
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameSubRscHandler", 1, paramString, new Object[0]);
    }
  }
  
  public void c(int paramInt, String paramString)
  {
    try
    {
      QLog.i("cmgame_process.CmGameSubRscHandler", 1, "[onDownloadFailure], ret:" + paramInt + ",packName:" + paramString);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("packName", paramString);
      localJSONObject.put("result", paramInt);
      paramString = anbd.a();
      if (paramString != null) {
        paramString.callbackFromRequest(this.jdField_a_of_type_Long, 0, "cs.load_subpackage.local", localJSONObject.toString());
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameSubRscHandler", 1, paramString, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anee
 * JD-Core Version:    0.7.0.1
 */