package com.tencent.biz.qqstory.takevideo.music;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.aelight.camera.qqstory.api.IAELaunchMusicConfigManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public class EditVideoMusicCache
{
  protected BroadcastReceiver a = new EditVideoMusicCache.1(this);
  private Context b;
  private Handler c;
  private boolean d;
  private EditVideoMusicCache.IMusicCacheController e;
  
  public EditVideoMusicCache(Context paramContext, EditVideoMusicCache.IMusicCacheController paramIMusicCacheController, Handler paramHandler)
  {
    this.b = paramContext;
    this.c = paramHandler;
    this.e = paramIMusicCacheController;
    paramContext = new IntentFilter("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    paramContext.addAction("action_music_start");
    paramContext.addAction("action_music_refresh_list");
    this.b.registerReceiver(this.a, paramContext);
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MusicCache", 2, "songMid not exist");
      }
      a(7, this.b.getResources().getString(2131896293));
      return;
    }
    if (!NetworkUtil.isNetSupport(this.b))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MusicCache", 2, "Net not Support");
      }
      a(7, this.b.getResources().getString(2131896298));
      return;
    }
    if (NetworkUtil.isMobileNetWork(this.b)) {
      a(7, this.b.getResources().getString(2131896297));
    }
    ((IAELaunchMusicConfigManager)QRoute.api(IAELaunchMusicConfigManager.class)).getSingleFullMusicInfo(paramString, this.d, new EditVideoMusicCache.2(this));
  }
  
  public void a()
  {
    this.b.unregisterReceiver(this.a);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    paramObject = this.c.obtainMessage(paramInt, paramObject);
    this.c.sendMessage(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.music.EditVideoMusicCache
 * JD-Core Version:    0.7.0.1
 */