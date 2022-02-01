package com.tencent.mobileqq.apollo.process.data;

import com.tencent.mobileqq.apollo.store.webview.ApolloClientUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

class CmGameShareDataHandler$3
  implements Runnable
{
  CmGameShareDataHandler$3(CmGameShareDataHandler paramCmGameShareDataHandler) {}
  
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
        int j = CmGameShareDataHandler.a(this.this$0).size();
        if (j == 0) {
          return;
        }
        localObject = new JSONArray();
        CmGameShareDataHandler.a(this.this$0).clear();
        i = 0;
        if (i < j)
        {
          CmGameShareDataHandler.GameShareResult localGameShareResult = (CmGameShareDataHandler.GameShareResult)CmGameShareDataHandler.a(this.this$0).get(i);
          if (localGameShareResult != null)
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("shareTo", localGameShareResult.d);
            localJSONObject.put("activity", localGameShareResult.b);
            localJSONObject.put("aioType", localGameShareResult.c);
            localJSONObject.put("gameId", localGameShareResult.jdField_a_of_type_Int);
            localJSONObject.put("uin", localGameShareResult.jdField_a_of_type_JavaLangString);
            localJSONObject.put("shareTS", localGameShareResult.jdField_a_of_type_Long);
            localJSONObject.put("shareRet", localGameShareResult.e);
            ((JSONArray)localObject).put(localJSONObject);
            CmGameShareDataHandler.a(this.this$0).put(localGameShareResult.a(), Boolean.TRUE);
          }
        }
        else
        {
          ApolloClientUtil.a("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/gameShareResult.txt", ((JSONArray)localObject).toString());
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