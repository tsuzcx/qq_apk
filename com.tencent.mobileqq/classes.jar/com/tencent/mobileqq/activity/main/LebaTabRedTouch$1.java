package com.tencent.mobileqq.activity.main;

import aiev;
import aiey;
import alvr;
import aoiq;
import auau;
import avsm;
import avsq;
import axlx;
import azmk;
import bems;
import bkcd;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.Collections;
import java.util.Map;
import nan;
import nga;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class LebaTabRedTouch$1
  implements Runnable
{
  public LebaTabRedTouch$1(aiev paramaiev, aiey paramaiey) {}
  
  public void run()
  {
    label269:
    label318:
    boolean bool1;
    boolean bool3;
    boolean bool2;
    label438:
    int n;
    label538:
    boolean bool4;
    label641:
    int i1;
    label739:
    boolean bool5;
    for (;;)
    {
      try
      {
        if (this.this$0.a != null)
        {
          localObject1 = this.this$0.a.app;
          if (localObject1 != null) {}
        }
        else
        {
          return;
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        Object localObject5;
        oidb_0x791.RedDotInfo localRedDotInfo;
        StringBuilder localStringBuilder;
        boolean bool6;
        int k;
        int m;
        int i7;
        bkcd localbkcd;
        int i3;
        int i2;
        label800:
        boolean bool7;
        QLog.e("MainAssistObserver.LebaTabRedTouch", 1, "updateTabLebaNotify Exception was thrown when update red point.", localException);
        return;
        bool1 = false;
        continue;
        int j = 0;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        break label1542;
        i6 = ((Integer)localException.first).intValue();
        continue;
        if (localObject5 == null) {
          continue;
        }
        QLog.i("MainAssistObserver.LebaTabRedTouch", 1, "updateTabLebaNotify redTypeInfo != null.");
        localObject2 = localObject5;
        continue;
        if (i4 > 0) {
          continue;
        }
        j = aiev.b(this.this$0);
        int i = j;
        if (j > 0) {
          continue;
        }
        i = j;
        if (bool3) {
          continue;
        }
        i = j;
        if (bool2) {
          continue;
        }
        i = j;
        if (i2 > 0) {
          continue;
        }
        if (!bool4) {
          break label1486;
        }
        i = j;
        localObject2 = new BusinessInfoCheckUpdate.RedTypeInfo();
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.set(0);
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_content.set("");
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_desc.set("");
        aiev.a(i7, i);
        QLog.i("MainAssistObserver.LebaTabRedTouch", 1, "updateTabLebaNotify hasReddot; redpointMums = " + i4 + ",isReadinjoyNotifyNeedsDisplay" + bool3 + ",nearbyHasRedPoint = " + bool2 + ", allPeopleVotePointCount=" + i2 + ", finalConfessShowRedDot=" + bool4);
        continue;
      }
      finally
      {
        if (this.a == null) {
          continue;
        }
        this.a.a();
      }
      localObject5 = (nan)this.this$0.a.app.getManager(70);
      localRedDotInfo = ((nan)localObject5).a();
      i = -1;
      if (localRedDotInfo != null) {
        i = localRedDotInfo.uint32_appid.get();
      }
      if ((!this.this$0.a.app.a().a) && (i == 11))
      {
        localObject1 = new BusinessInfoCheckUpdate.RedTypeInfo();
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.set(4);
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_content.set(localRedDotInfo.str_custom_buffer.get().toStringUtf8());
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_desc.set("{'cn':'#FF0000', 'av':1}");
        QLog.i("Q.qqstory.redPointMainAssistObserver", 1, "story文字、图片红点,storyAppid:" + i);
        this.a.a((BusinessInfoCheckUpdate.RedTypeInfo)localObject1);
        if (this.a != null) {
          this.a.a();
        }
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("mIsShowNewLeba=").append(this.this$0.a.app.q);
        bool6 = azmk.a();
        localObject1 = Collections.emptyMap();
        if (bool6)
        {
          localObject1 = this.this$0.a();
          i = ((nan)localObject5).a(this.this$0.a.app);
          k = ((nan)localObject5).a();
          if (!alvr.a(this.this$0.a.app, 826L, bool6, (Map)localObject1))
          {
            i = 0;
            k = 0;
            localStringBuilder.append("troop red point-->redPointNums= ").append(i).append(", redNumPointNums=").append(k).append(", isBuluoEntryShow=").append(k);
            ((avsm)this.this$0.a.app.getManager(160)).a(100510);
            localObject5 = ((nan)localObject5).a(((nan)localObject5).a(), false);
            if (((avsq)localObject5).a != -1)
            {
              bool1 = true;
              m = ((avsq)localObject5).b;
              bool3 = alvr.a(this.this$0.a.app, 7719L, bool6, (Map)localObject1);
              if (bool3) {
                break label1529;
              }
              bool2 = false;
              m = 0;
              localStringBuilder.append("nearby red point-->nearbyNum= ").append(m).append(", nearbyHasRedPoint=").append(bool2).append(", isNearbyEntryShow=").append(bool3);
              localObject5 = ((axlx)this.this$0.a.app.getManager(36)).a(this.this$0.a.app, bool6, (Map)localObject1);
              if ((localObject5 == null) || (((BusinessInfoCheckUpdate.RedTypeInfo)localObject5).red_type.get() != 5)) {
                break label1523;
              }
              n = Integer.parseInt(((BusinessInfoCheckUpdate.RedTypeInfo)localObject5).red_content.get());
              localStringBuilder.append("business red point-->numRedTouch=").append(n);
              i7 = aiev.a(this.this$0);
              localStringBuilder.append("QZone red point-->qzonMsgCount=").append(i7);
              localbkcd = aiev.a(this.this$0);
              if (localbkcd == null) {
                continue;
              }
              j = localbkcd.a();
              if ((localbkcd == null) || (!localbkcd.a())) {
                continue;
              }
              bool1 = true;
              bool4 = alvr.a(this.this$0.a.app, 1130L, bool6, (Map)localObject1);
              if (bool4) {
                break label1516;
              }
              bool3 = false;
              j = 0;
              localStringBuilder.append("readInJoy red point-->readInJoyNotifyCount=").append(j).append(", isReadinjoyNotifyNeedsDisplay=").append(bool3).append(", isKanDianEntryShow=").append(bool4);
              if ((localRedDotInfo == null) || (localRedDotInfo.uint32_appid.get() != 52) || (this.this$0.a.app.a().a) || (!this.this$0.a.app.a().b())) {
                break label1510;
              }
              i1 = localRedDotInfo.uint32_number.get();
              i3 = bems.a(this.this$0.a.app, true);
              i2 = bems.a(this.this$0.a.app, false);
              if (alvr.a(this.this$0.a.app, 770L, bool6, (Map)localObject1)) {
                break label1507;
              }
              i2 = 0;
              i3 = 0;
              bool7 = aoiq.a(this.this$0.a.app, "redpoint_leba_show");
              if (!bool7) {
                break label1498;
              }
              bool5 = alvr.a(this.this$0.a.app, 7759L, bool6, (Map)localObject1);
              if ((!bool7) || (!bool5)) {
                continue;
              }
              bool1 = true;
              break label1542;
            }
          }
        }
      }
    }
    for (;;)
    {
      localStringBuilder.append("confessRedPoit").append(bool4).append(",").append(bool7).append(",").append(bool1);
      if (alvr.a(this.this$0.a.app, 7720L, bool6, (Map)localObject1)) {}
      for (int i5 = auau.a(this.this$0.a.app);; i5 = 0)
      {
        localStringBuilder.append("matchChatRedNum,").append(i5);
        localObject1 = aiev.a(this.this$0);
        int i6;
        int i4;
        if (localObject1 == null)
        {
          i6 = 0;
          i4 = i;
          if (localObject1 != null)
          {
            i4 = i;
            if (((Boolean)((Pair)localObject1).second).booleanValue()) {
              i4 = i + 1;
            }
          }
          i5 = i6 + (i7 + n + k + j + m + i1 + i3 + i5);
          QLog.i("MainAssistObserver.LebaTabRedTouch", 1, "updateTabLebaNotify: totalCount=" + i5 + ", qz=" + i7 + ", numRedTouch=" + n + ", redNumPointNums=" + k + ", readInJoyNotifyCount=" + j + ", nearbyNum=" + m + ", storyRedNum=" + i1 + ", allPeopleVoteRedNumCount=" + i3 + localStringBuilder.toString());
          i = 0;
          if (i5 <= 0) {
            break label1275;
          }
          localObject1 = new BusinessInfoCheckUpdate.RedTypeInfo();
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.set(5);
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_content.set(i5 + "");
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_desc.set("{'cn':'#FF0000'}");
          aiev.a(i7, 0);
          break;
        }
        label1275:
        Object localObject2;
        label1486:
        Object localObject4 = null;
        break;
      }
      label1498:
      bool4 = false;
      bool1 = false;
      continue;
      label1507:
      break label800;
      label1510:
      i1 = 0;
      break label739;
      label1516:
      bool3 = bool1;
      break label641;
      label1523:
      n = 0;
      break label538;
      label1529:
      bool2 = bool1;
      break label438;
      break label318;
      break label269;
      label1542:
      bool4 = bool1;
      bool1 = bool5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.LebaTabRedTouch.1
 * JD-Core Version:    0.7.0.1
 */