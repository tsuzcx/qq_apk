package com.tencent.mobileqq.apollo.process.data;

import amsd;
import amsf;
import amyk;
import ancb;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class CmGameShareDataHandler$3
  implements Runnable
{
  public CmGameShareDataHandler$3(amsd paramamsd) {}
  
  public void run()
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject = new File(ancb.s + "gameShareResult.txt");
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        int j = amsd.a(this.this$0).size();
        if (j == 0) {
          return;
        }
        localObject = new JSONArray();
        amsd.a(this.this$0).clear();
        i = 0;
        if (i < j)
        {
          amsf localamsf = (amsf)amsd.a(this.this$0).get(i);
          if (localamsf != null)
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("shareTo", localamsf.d);
            localJSONObject.put("activity", localamsf.b);
            localJSONObject.put("aioType", localamsf.c);
            localJSONObject.put("gameId", localamsf.jdField_a_of_type_Int);
            localJSONObject.put("uin", localamsf.jdField_a_of_type_JavaLangString);
            localJSONObject.put("shareTS", localamsf.jdField_a_of_type_Long);
            localJSONObject.put("shareRet", localamsf.e);
            ((JSONArray)localObject).put(localJSONObject);
            amsd.a(this.this$0).put(localamsf.a(), Boolean.TRUE);
          }
        }
        else
        {
          amyk.a(ancb.s + "gameShareResult.txt", ((JSONArray)localObject).toString());
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