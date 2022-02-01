package com.tencent.mobileqq.apollo.process.data;

import amzh;
import amzj;
import angg;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class CmGameShareDataHandler$3
  implements Runnable
{
  public CmGameShareDataHandler$3(amzh paramamzh) {}
  
  public void run()
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/gameShareResult.txt");
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        int j = amzh.a(this.this$0).size();
        if (j == 0) {
          return;
        }
        localObject = new JSONArray();
        amzh.a(this.this$0).clear();
        i = 0;
        if (i < j)
        {
          amzj localamzj = (amzj)amzh.a(this.this$0).get(i);
          if (localamzj != null)
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("shareTo", localamzj.d);
            localJSONObject.put("activity", localamzj.b);
            localJSONObject.put("aioType", localamzj.c);
            localJSONObject.put("gameId", localamzj.jdField_a_of_type_Int);
            localJSONObject.put("uin", localamzj.jdField_a_of_type_JavaLangString);
            localJSONObject.put("shareTS", localamzj.jdField_a_of_type_Long);
            localJSONObject.put("shareRet", localamzj.e);
            ((JSONArray)localObject).put(localJSONObject);
            amzh.a(this.this$0).put(localamzj.a(), Boolean.TRUE);
          }
        }
        else
        {
          angg.a("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/gameShareResult.txt", ((JSONArray)localObject).toString());
          QLog.d("cmgame_process.CmGameShareDataHandler", 1, "saveShareResult finish");
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("cmgame_process.CmGameShareDataHandler", 1, "saveShareResult e:", localException);
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          QLog.e("cmgame_process.CmGameShareDataHandler", 1, localOutOfMemoryError, new Object[0]);
        }
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameShareDataHandler.3
 * JD-Core Version:    0.7.0.1
 */