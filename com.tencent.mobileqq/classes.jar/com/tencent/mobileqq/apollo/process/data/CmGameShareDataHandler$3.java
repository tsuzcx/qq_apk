package com.tencent.mobileqq.apollo.process.data;

import andx;
import andz;
import anke;
import annv;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class CmGameShareDataHandler$3
  implements Runnable
{
  public CmGameShareDataHandler$3(andx paramandx) {}
  
  public void run()
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject = new File(annv.s + "gameShareResult.txt");
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        int j = andx.a(this.this$0).size();
        if (j == 0) {
          return;
        }
        localObject = new JSONArray();
        andx.a(this.this$0).clear();
        i = 0;
        if (i < j)
        {
          andz localandz = (andz)andx.a(this.this$0).get(i);
          if (localandz != null)
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("shareTo", localandz.d);
            localJSONObject.put("activity", localandz.b);
            localJSONObject.put("aioType", localandz.c);
            localJSONObject.put("gameId", localandz.jdField_a_of_type_Int);
            localJSONObject.put("uin", localandz.jdField_a_of_type_JavaLangString);
            localJSONObject.put("shareTS", localandz.jdField_a_of_type_Long);
            localJSONObject.put("shareRet", localandz.e);
            ((JSONArray)localObject).put(localJSONObject);
            andx.a(this.this$0).put(localandz.a(), Boolean.TRUE);
          }
        }
        else
        {
          anke.a(annv.s + "gameShareResult.txt", ((JSONArray)localObject).toString());
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