package com.tencent.biz.qqstory.base;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.utils.HexUtil;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import org.json.JSONObject;

class VideoServerInfoManager$1
  extends SimpleJob<Object>
{
  VideoServerInfoManager$1(VideoServerInfoManager paramVideoServerInfoManager, String paramString)
  {
    super(paramString);
  }
  
  protected Object a(@NonNull JobContext arg1, @Nullable Void... paramVarArgs)
  {
    Object localObject = (String)((StoryConfigManager)SuperManager.a(10)).c("SP_KEY_AUTHKEY_SERVER_INFO", "");
    synchronized (this.a.d)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        long l = this.a.a.g;
        if (l == 0L) {
          try
          {
            paramVarArgs = new VideoServerInfoManager.ServerInfo();
            localObject = new JSONObject((String)localObject);
            paramVarArgs.g = ((JSONObject)localObject).getLong("t");
            paramVarArgs.f = HexUtil.hexStr2Bytes(((JSONObject)localObject).getString("ak"));
            this.a.a = paramVarArgs;
            SLog.a("Q.qqstory.publish:VideoServerInfoManager", "ServerInfo init success -> %s", localObject);
          }
          catch (Exception paramVarArgs)
          {
            SLog.b("Q.qqstory.publish:VideoServerInfoManager", "ServerInfo init error , %s", paramVarArgs);
          }
        }
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.VideoServerInfoManager.1
 * JD-Core Version:    0.7.0.1
 */