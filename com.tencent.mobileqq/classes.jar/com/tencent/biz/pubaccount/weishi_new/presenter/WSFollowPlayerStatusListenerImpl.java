package com.tencent.biz.pubaccount.weishi_new.presenter;

import com.tencent.biz.pubaccount.weishi_new.WSFollowAdapter;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerStatusListener;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoInfo;
import com.tencent.biz.pubaccount.weishi_new.report.WSFollowBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

public class WSFollowPlayerStatusListenerImpl
  implements WSPlayerStatusListener
{
  private WSFollowAdapter a;
  
  public WSFollowPlayerStatusListenerImpl(WSFollowAdapter paramWSFollowAdapter)
  {
    this.a = paramWSFollowAdapter;
  }
  
  public void a(WSPlayerParam paramWSPlayerParam) {}
  
  public void a(WSPlayerParam paramWSPlayerParam, int paramInt) {}
  
  public void a(WSPlayerParam paramWSPlayerParam, int paramInt1, int paramInt2, String paramString)
  {
    paramString = new StringBuilder();
    paramString.append("[onVideoError] video: ");
    if ((paramWSPlayerParam != null) && (paramWSPlayerParam.b != null)) {
      paramWSPlayerParam = paramWSPlayerParam.c.g;
    } else {
      paramWSPlayerParam = "";
    }
    paramString.append(paramWSPlayerParam);
    WSLog.b("WSFollowPlayerStatusListenerImpl", paramString.toString());
  }
  
  public void a(WSPlayerParam paramWSPlayerParam, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onVideoStop] video: ");
    String str;
    if ((paramWSPlayerParam != null) && (paramWSPlayerParam.b != null)) {
      str = paramWSPlayerParam.c.g;
    } else {
      str = "";
    }
    localStringBuilder.append(str);
    WSLog.b("WSFollowPlayerStatusListenerImpl", localStringBuilder.toString());
    new WSFollowPlayerStatusListenerImpl.1(this, paramWSPlayerParam, paramBoolean).run();
  }
  
  public void b(WSPlayerParam paramWSPlayerParam)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onVideoStart] video: ");
    String str;
    if ((paramWSPlayerParam != null) && (paramWSPlayerParam.c != null)) {
      str = paramWSPlayerParam.c.g;
    } else {
      str = "";
    }
    localStringBuilder.append(str);
    WSLog.b("WSFollowPlayerStatusListenerImpl", localStringBuilder.toString());
    WSFollowBeaconReport.a(paramWSPlayerParam);
    paramWSPlayerParam = this.a;
    if (paramWSPlayerParam != null) {
      paramWSPlayerParam.c();
    }
  }
  
  public void c(WSPlayerParam paramWSPlayerParam)
  {
    if (paramWSPlayerParam != null)
    {
      if (this.a == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onCompletion] videoTitle: ");
      if (paramWSPlayerParam.c != null) {
        localObject = paramWSPlayerParam.c.g;
      } else {
        localObject = "videoInfo is null!";
      }
      localStringBuilder.append((String)localObject);
      WSLog.e("WSFollowPlayerStatusListenerImpl", localStringBuilder.toString());
      Object localObject = this.a.e();
      if ((localObject != null) && (((WSPlayerManager)localObject).s()))
      {
        WSLog.e("WSFollowPlayerStatusListenerImpl", "[onCompletion] loopPlayMode: true");
        ((WSPlayerManager)localObject).b(paramWSPlayerParam, false);
      }
    }
  }
  
  public void d(WSPlayerParam paramWSPlayerParam)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onVideoPause] video: ");
    if ((paramWSPlayerParam != null) && (paramWSPlayerParam.b != null)) {
      paramWSPlayerParam = paramWSPlayerParam.c.g;
    } else {
      paramWSPlayerParam = "";
    }
    localStringBuilder.append(paramWSPlayerParam);
    WSLog.b("WSFollowPlayerStatusListenerImpl", localStringBuilder.toString());
  }
  
  public void e(WSPlayerParam paramWSPlayerParam)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onVideoRestart] video: ");
    if ((paramWSPlayerParam != null) && (paramWSPlayerParam.b != null)) {
      paramWSPlayerParam = paramWSPlayerParam.c.g;
    } else {
      paramWSPlayerParam = "";
    }
    localStringBuilder.append(paramWSPlayerParam);
    WSLog.b("WSFollowPlayerStatusListenerImpl", localStringBuilder.toString());
  }
  
  public void f(WSPlayerParam paramWSPlayerParam)
  {
    paramWSPlayerParam = this.a;
    if (paramWSPlayerParam != null) {
      paramWSPlayerParam.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.presenter.WSFollowPlayerStatusListenerImpl
 * JD-Core Version:    0.7.0.1
 */