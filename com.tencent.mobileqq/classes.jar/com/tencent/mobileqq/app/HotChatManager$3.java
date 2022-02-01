package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class HotChatManager$3
  implements Runnable
{
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatManager", 2, "isUinInVList,init");
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(BaseApplicationImpl.getContext().getFilesDir());
    ((StringBuilder)localObject1).append(File.separator);
    ((StringBuilder)localObject1).append(this.this$0.d.getAccount());
    ((StringBuilder)localObject1).append("_nearby_hotchat_v_list");
    localObject1 = new File(((StringBuilder)localObject1).toString());
    String str = null;
    Object localObject2;
    try
    {
      localObject1 = FileUtils.readFileToString((File)localObject1);
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isUinInVList, readFile exception:");
        localStringBuilder.append(localIOException.getMessage());
        QLog.i("HotChatManager", 2, localStringBuilder.toString());
      }
      localIOException.printStackTrace();
      localObject2 = null;
    }
    this.this$0.q = new ArrayList();
    if (localObject2 != null)
    {
      try
      {
        localObject2 = new JSONObject((String)localObject2).getJSONArray("vusers");
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        localObject3 = str;
      }
      if (localObject3 != null)
      {
        int i = 0;
        while (i < ((JSONArray)localObject3).length())
        {
          str = ((JSONArray)localObject3).optString(i);
          if (!TextUtils.isEmpty(str)) {
            this.this$0.q.add(str);
          }
          i += 1;
        }
      }
    }
    Object localObject3 = this.this$0;
    ((HotChatManager)localObject3).s = false;
    if (((HotChatManager)localObject3).r != null) {
      this.this$0.r.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotChatManager.3
 * JD-Core Version:    0.7.0.1
 */