package com.tencent.avgame.gameroom.video;

import android.graphics.Rect;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.business.handler.UserInfoHandler;
import com.tencent.avgame.gameroom.MemberVideoDisplayInfo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

class AVGameBusinessVideoLayer$1
  implements Runnable
{
  AVGameBusinessVideoLayer$1(AVGameBusinessVideoLayer paramAVGameBusinessVideoLayer) {}
  
  public void run()
  {
    long l1;
    if (!this.this$0.I.isEmpty())
    {
      if (this.this$0.L == null) {
        return;
      }
      l1 = this.this$0.J.getLongAccountUin();
    }
    for (;;)
    {
      int i;
      synchronized (this.this$0.I)
      {
        HashSet localHashSet = new HashSet();
        Object localObject2 = this.this$0.L;
        int j = localObject2.length;
        i = 0;
        Object localObject3;
        if (i < j)
        {
          localObject3 = localObject2[i];
          if (!((AVGameVideoView)localObject3).c()) {
            break label370;
          }
          long l2 = Long.valueOf(((AVGameVideoView)localObject3).R()).longValue();
          if (!AVGameBusinessVideoLayer.a(this.this$0, l2))
          {
            ((AVGameVideoView)localObject3).a(null, 0);
            ((AVGameVideoView)localObject3).a(1);
            break label370;
          }
          localHashSet.add(Long.valueOf(l2));
          break label370;
        }
        localObject2 = this.this$0.I.iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (MemberVideoDisplayInfo)((Iterator)localObject2).next();
          if ((l1 == ((MemberVideoDisplayInfo)localObject3).a) && (((MemberVideoDisplayInfo)localObject3).m)) {
            this.this$0.N = new Rect(((MemberVideoDisplayInfo)localObject3).i, ((MemberVideoDisplayInfo)localObject3).j, ((MemberVideoDisplayInfo)localObject3).i + ((MemberVideoDisplayInfo)localObject3).k, ((MemberVideoDisplayInfo)localObject3).j + ((MemberVideoDisplayInfo)localObject3).l);
          }
          if ((((MemberVideoDisplayInfo)localObject3).g) || (localHashSet.contains(Long.valueOf(((MemberVideoDisplayInfo)localObject3).a)))) {
            continue;
          }
          localObject3 = Long.toString(((MemberVideoDisplayInfo)localObject3).a);
          i = this.this$0.G();
          AVGameVideoView localAVGameVideoView = this.this$0.L[i];
          localAVGameVideoView.a(this.this$0.P.a((String)localObject3, (byte)1));
          localAVGameVideoView.a((String)localObject3, 0);
          localAVGameVideoView.a(this.this$0.J.getCurrentAccountUin());
          localAVGameVideoView.a(0);
          continue;
        }
        this.this$0.m();
        return;
      }
      return;
      label370:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameBusinessVideoLayer.1
 * JD-Core Version:    0.7.0.1
 */