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
    int i = 0;
    if ((this.this$0.jdField_b_of_type_JavaUtilList.isEmpty()) || (this.this$0.jdField_b_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView == null)) {
      return;
    }
    long l1 = this.this$0.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getLongAccountUin();
    for (;;)
    {
      Object localObject3;
      synchronized (this.this$0.jdField_b_of_type_JavaUtilList)
      {
        HashSet localHashSet = new HashSet();
        localObject2 = this.this$0.jdField_b_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView;
        int j = localObject2.length;
        if (i < j)
        {
          localObject3 = localObject2[i];
          if (!((AVGameVideoView)localObject3).a()) {
            break label369;
          }
          long l2 = Long.valueOf(((AVGameVideoView)localObject3).c()).longValue();
          if (!AVGameBusinessVideoLayer.a(this.this$0, l2))
          {
            ((AVGameVideoView)localObject3).a(null, 0);
            ((AVGameVideoView)localObject3).a(1);
          }
          else
          {
            localHashSet.add(Long.valueOf(l2));
          }
        }
      }
      Object localObject2 = this.this$0.jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (MemberVideoDisplayInfo)((Iterator)localObject2).next();
        if ((l1 == ((MemberVideoDisplayInfo)localObject3).jdField_a_of_type_Long) && (((MemberVideoDisplayInfo)localObject3).c)) {
          this.this$0.d = new Rect(((MemberVideoDisplayInfo)localObject3).f, ((MemberVideoDisplayInfo)localObject3).g, ((MemberVideoDisplayInfo)localObject3).f + ((MemberVideoDisplayInfo)localObject3).h, ((MemberVideoDisplayInfo)localObject3).g + ((MemberVideoDisplayInfo)localObject3).i);
        }
        if ((!((MemberVideoDisplayInfo)localObject3).jdField_a_of_type_Boolean) && (!localObject1.contains(Long.valueOf(((MemberVideoDisplayInfo)localObject3).jdField_a_of_type_Long))))
        {
          localObject3 = Long.toString(((MemberVideoDisplayInfo)localObject3).jdField_a_of_type_Long);
          i = this.this$0.g();
          AVGameVideoView localAVGameVideoView = this.this$0.jdField_b_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i];
          localAVGameVideoView.a(this.this$0.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler.a((String)localObject3, (byte)1));
          localAVGameVideoView.a((String)localObject3, 0);
          localAVGameVideoView.a(this.this$0.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin());
          localAVGameVideoView.a(0);
        }
      }
      this.this$0.b();
      return;
      label369:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameBusinessVideoLayer.1
 * JD-Core Version:    0.7.0.1
 */