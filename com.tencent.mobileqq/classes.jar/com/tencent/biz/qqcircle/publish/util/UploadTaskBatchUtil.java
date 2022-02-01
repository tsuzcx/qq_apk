package com.tencent.biz.qqcircle.publish.util;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.publish.account.LoginData;
import com.tencent.biz.qqcircle.publish.common.config.LocalConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class UploadTaskBatchUtil
{
  public static HashMap<Long, UploadTaskBatchUtil.UploadInfo> a = new HashMap();
  
  static
  {
    Object localObject1 = LocalConfig.c("key_upload_task_flag", "", LoginData.a().b());
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("values:");
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.i("[QcirclePublish]UploadTaskBatchUtil", 1, ((StringBuilder)localObject2).toString());
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = ((String)localObject1).split("\\|");
      if (localObject1 != null)
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          localObject2 = localObject1[i];
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject2 = ((String)localObject2).split(",");
            if ((localObject2 != null) && (localObject2.length >= 5)) {
              try
              {
                a.put(Long.valueOf(Long.parseLong(localObject2[0])), new UploadTaskBatchUtil.UploadInfo(Integer.parseInt(localObject2[1]), Integer.parseInt(localObject2[2]), Integer.parseInt(localObject2[3]), Integer.parseInt(localObject2[4])));
              }
              catch (Exception localException)
              {
                QLog.e("[QcirclePublish]UploadTaskBatchUtil", 1, "warn!!!", localException);
              }
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public static long a(long paramLong)
  {
    return LocalConfig.b("upload_multi_pic_pref_cache", String.valueOf(paramLong), 0L);
  }
  
  public static void a(long paramLong1, long paramLong2)
  {
    LocalConfig.a("upload_multi_pic_pref_cache", String.valueOf(paramLong1), paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.util.UploadTaskBatchUtil
 * JD-Core Version:    0.7.0.1
 */