package com.tencent.mobileqq.apollo.process.data;

import akyz;
import akzb;
import alfd;
import aliu;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class CmGameShareDataHandler$3
  implements Runnable
{
  public CmGameShareDataHandler$3(akyz paramakyz) {}
  
  public void run()
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject = new File(aliu.s + "gameShareResult.txt");
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        int j = akyz.a(this.this$0).size();
        if (j == 0) {
          return;
        }
        localObject = new JSONArray();
        akyz.a(this.this$0).clear();
        i = 0;
        if (i < j)
        {
          akzb localakzb = (akzb)akyz.a(this.this$0).get(i);
          if (localakzb != null)
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("shareTo", localakzb.d);
            localJSONObject.put("activity", localakzb.b);
            localJSONObject.put("aioType", localakzb.c);
            localJSONObject.put("gameId", localakzb.jdField_a_of_type_Int);
            localJSONObject.put("uin", localakzb.jdField_a_of_type_JavaLangString);
            localJSONObject.put("shareTS", localakzb.jdField_a_of_type_Long);
            localJSONObject.put("shareRet", localakzb.e);
            ((JSONArray)localObject).put(localJSONObject);
            akyz.a(this.this$0).put(localakzb.a(), Boolean.TRUE);
          }
        }
        else
        {
          alfd.a(aliu.s + "gameShareResult.txt", ((JSONArray)localObject).toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameShareDataHandler.3
 * JD-Core Version:    0.7.0.1
 */