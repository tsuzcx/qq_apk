package com.tencent.av.wtogether;

import com.tencent.av.app.SessionInfo;
import com.tencent.av.wtogether.callback.RealNameAuthCallback;
import com.tencent.av.wtogether.data.WatchTogetherInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

class WTogetherMng$1
  implements RealNameAuthCallback
{
  WTogetherMng$1(WTogetherMng paramWTogetherMng, SessionInfo paramSessionInfo, WatchTogetherInfo paramWatchTogetherInfo, WTogetherRealNameVideoProcessHelper paramWTogetherRealNameVideoProcessHelper) {}
  
  public void a()
  {
    WTogetherMng.a(this.d, this.b);
    this.c.a(null);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      WTogetherMng.a(this.d, this.a, this.b.f, this.b.g());
    }
    else
    {
      WTogetherMng.a(this.d, this.b);
      WTogetherMng.a(this.d, BaseApplicationImpl.getContext().getString(2131893773), 0L);
    }
    this.c.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.WTogetherMng.1
 * JD-Core Version:    0.7.0.1
 */