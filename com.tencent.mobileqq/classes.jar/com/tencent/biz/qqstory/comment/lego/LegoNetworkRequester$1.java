package com.tencent.biz.qqstory.comment.lego;

import android.os.Bundle;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import mqq.observer.BusinessObserver;

class LegoNetworkRequester$1
  implements BusinessObserver
{
  LegoNetworkRequester$1(LegoNetworkRequester paramLegoNetworkRequester, long paramLong, LegoRequestBase paramLegoRequestBase, String paramString, LegoResponseBase paramLegoResponseBase) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    long l = System.currentTimeMillis() - this.a;
    Object localObject1 = Integer.valueOf(-1);
    Object localObject2;
    Object localObject3;
    if (paramBoolean)
    {
      localObject2 = paramBundle.getByteArray("data");
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        localObject1 = this.b.a((byte[])localObject2);
        if (localObject1 != null)
        {
          paramInt = ((LegoResponseBase)localObject1).d;
          localObject3 = ((LegoResponseBase)localObject1).e;
          if (paramInt == 0)
          {
            ((LegoResponseBase)localObject1).a();
            SLog.a("Q.qqstory.net:LegoNetworkRequester", "get cmd:%s success take time:%d data length=%d", this.c, Long.valueOf(l), Integer.valueOf(localObject2.length));
          }
          else
          {
            ((LegoResponseBase)localObject1).a(paramInt, (String)localObject3);
            SLog.d("Q.qqstory.net:LegoNetworkRequester", "get cmd:%s error:%d msg:%s take time:%d data length%d", new Object[] { this.c, Integer.valueOf(paramInt), localObject3, Long.valueOf(l), Integer.valueOf(localObject2.length) });
          }
          StoryReportor.b("story_net", this.c, 0, paramInt, new String[] { localObject3, String.valueOf(l), StoryReportor.a(BaseApplication.getContext()) });
        }
        else
        {
          SLog.d("Q.qqstory.net:LegoNetworkRequester", "get cmd:%s error. response is null", new Object[] { this.c });
          StoryReportor.b("story_net", this.c, 0, 940002, new String[] { "response is null", String.valueOf(l), StoryReportor.a(BaseApplication.getContext()) });
        }
      }
      else
      {
        this.d.a(-2, paramBundle);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("get cmd:");
        ((StringBuilder)localObject2).append(this.b.a());
        ((StringBuilder)localObject2).append(" channel error:%d, take time:%d");
        SLog.d("Q.qqstory.net:LegoNetworkRequester", ((StringBuilder)localObject2).toString(), new Object[] { localObject1, Long.valueOf(l) });
        StoryReportor.b("story_net", this.b.a(), 0, 940002, new String[] { "rsp data error", String.valueOf(l), StoryReportor.a(BaseApplication.getContext()) });
      }
    }
    else
    {
      paramInt = paramBundle.getInt("data_error_code");
      localObject2 = paramBundle.getString("data_error_msg");
      this.d.a(paramInt, paramBundle);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("get cmd:");
      ((StringBuilder)localObject3).append(this.c);
      ((StringBuilder)localObject3).append(" channel error:%d, take time:%d");
      SLog.d("Q.qqstory.net:LegoNetworkRequester", ((StringBuilder)localObject3).toString(), new Object[] { localObject1, Long.valueOf(l) });
      StoryReportor.b("story_net", this.c, 0, paramInt, new String[] { localObject2, String.valueOf(l), StoryReportor.a(BaseApplication.getContext()) });
    }
    this.d.a(paramBoolean, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.lego.LegoNetworkRequester.1
 * JD-Core Version:    0.7.0.1
 */