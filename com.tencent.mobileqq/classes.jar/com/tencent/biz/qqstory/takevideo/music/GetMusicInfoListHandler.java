package com.tencent.biz.qqstory.takevideo.music;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.network.request.GetMusicConfigRequest;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import java.util.ArrayList;
import java.util.Iterator;
import old;

public class GetMusicInfoListHandler
{
  public static QQStoryMusicInfo a(Context paramContext, String paramString)
  {
    paramContext = QQStoryMusicInfo.a(paramContext);
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        QQStoryMusicInfo localQQStoryMusicInfo = (QQStoryMusicInfo)paramContext.next();
        if (TextUtils.equals(paramString, localQQStoryMusicInfo.a)) {
          return localQQStoryMusicInfo;
        }
      }
    }
    return null;
  }
  
  public static void a(Context paramContext)
  {
    GetMusicConfigRequest localGetMusicConfigRequest = new GetMusicConfigRequest();
    CmdTaskManger.a().a(localGetMusicConfigRequest, new old(paramContext));
  }
  
  public static boolean a(Context paramContext)
  {
    return !TextUtils.isEmpty(SharePreferenceUtils.a(paramContext, "qqstory_savedMusicList"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.music.GetMusicInfoListHandler
 * JD-Core Version:    0.7.0.1
 */