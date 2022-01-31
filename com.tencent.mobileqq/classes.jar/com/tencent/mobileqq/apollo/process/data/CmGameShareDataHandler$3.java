package com.tencent.mobileqq.apollo.process.data;

import aiqc;
import aiqe;
import aivc;
import aiys;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class CmGameShareDataHandler$3
  implements Runnable
{
  public CmGameShareDataHandler$3(aiqc paramaiqc) {}
  
  public void run()
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject = new File(aiys.s + "gameShareResult.txt");
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        int j = aiqc.a(this.this$0).size();
        if (j == 0) {
          return;
        }
        localObject = new JSONArray();
        aiqc.a(this.this$0).clear();
        i = 0;
        if (i < j)
        {
          aiqe localaiqe = (aiqe)aiqc.a(this.this$0).get(i);
          if (localaiqe != null)
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("shareTo", localaiqe.d);
            localJSONObject.put("activity", localaiqe.b);
            localJSONObject.put("aioType", localaiqe.c);
            localJSONObject.put("gameId", localaiqe.jdField_a_of_type_Int);
            localJSONObject.put("uin", localaiqe.jdField_a_of_type_JavaLangString);
            localJSONObject.put("shareTS", localaiqe.jdField_a_of_type_Long);
            localJSONObject.put("shareRet", localaiqe.e);
            ((JSONArray)localObject).put(localJSONObject);
            aiqc.a(this.this$0).put(localaiqe.a(), Boolean.TRUE);
          }
        }
        else
        {
          aivc.a(aiys.s + "gameShareResult.txt", ((JSONArray)localObject).toString());
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