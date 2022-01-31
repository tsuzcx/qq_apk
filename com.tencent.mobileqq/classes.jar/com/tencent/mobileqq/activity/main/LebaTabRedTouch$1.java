package com.tencent.mobileqq.activity.main;

import agcd;
import agce;
import ajzo;
import amnj;
import asfl;
import atxd;
import atxe;
import avps;
import axmv;
import bcji;
import bhwl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.Map;
import mxu;
import nde;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class LebaTabRedTouch$1
  implements Runnable
{
  public LebaTabRedTouch$1(agcd paramagcd, agce paramagce) {}
  
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
        int j;
        int m;
        int i5;
        bhwl localbhwl;
        label739:
        int i3;
        int i2;
        label800:
        boolean bool7;
        QLog.e("MainAssistObserver.LebaTabRedTouch", 1, "updateTabLebaNotify Exception was thrown when update red point.", localException);
        return;
        bool1 = false;
        continue;
        int i = 0;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        break label1445;
        if (localObject5 == null) {
          continue;
        }
        QLog.i("MainAssistObserver.LebaTabRedTouch", 1, "updateTabLebaNotify redTypeInfo != null.");
        localObject2 = localObject5;
        continue;
        if ((k <= 0) && (!agcd.a(this.this$0)) && (!bool3) && (!bool2) && (i2 <= 0) && (!bool5)) {
          break label1395;
        }
        localObject2 = new BusinessInfoCheckUpdate.RedTypeInfo();
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.set(0);
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_content.set("");
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_desc.set("");
        QLog.i("MainAssistObserver.LebaTabRedTouch", 1, "updateTabLebaNotify hasReddot; redpointMums = " + k + ",isReadinjoyNotifyNeedsDisplay" + bool3 + ",nearbyHasRedPoint = " + bool2 + ", allPeopleVotePointCount=" + i2 + ", finalConfessShowRedDot=" + bool5);
        continue;
      }
      finally
      {
        if (this.a == null) {
          continue;
        }
        this.a.a();
      }
      localObject5 = (mxu)this.this$0.a.app.getManager(70);
      localRedDotInfo = ((mxu)localObject5).a();
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
        bool6 = axmv.a();
        localObject1 = Collections.emptyMap();
        if (bool6)
        {
          localObject1 = this.this$0.a();
          k = ((mxu)localObject5).a(this.this$0.a.app);
          j = ((mxu)localObject5).a();
          if (!ajzo.a(this.this$0.a.app, 826L, bool6, (Map)localObject1))
          {
            j = 0;
            k = 0;
            localStringBuilder.append("troop red point-->redPointNums= ").append(k).append(", redNumPointNums=").append(j).append(", isBuluoEntryShow=").append(j);
            ((atxd)this.this$0.a.app.getManager(160)).a(100510);
            localObject5 = ((mxu)localObject5).a(((mxu)localObject5).a(), false);
            if (((atxe)localObject5).a != -1)
            {
              bool1 = true;
              m = ((atxe)localObject5).b;
              bool3 = ajzo.a(this.this$0.a.app, 7719L, bool6, (Map)localObject1);
              if (bool3) {
                break label1432;
              }
              bool2 = false;
              m = 0;
              localStringBuilder.append("nearby red point-->nearbyNum= ").append(m).append(", nearbyHasRedPoint=").append(bool2).append(", isNearbyEntryShow=").append(bool3);
              localObject5 = ((avps)this.this$0.a.app.getManager(36)).a(this.this$0.a.app, bool6, (Map)localObject1);
              if ((localObject5 == null) || (((BusinessInfoCheckUpdate.RedTypeInfo)localObject5).red_type.get() != 5)) {
                break label1426;
              }
              n = Integer.parseInt(((BusinessInfoCheckUpdate.RedTypeInfo)localObject5).red_content.get());
              localStringBuilder.append("business red point-->numRedTouch=").append(n);
              i5 = agcd.a(this.this$0);
              localStringBuilder.append("QZone red point-->qzonMsgCount=").append(i5);
              localbhwl = agcd.a(this.this$0);
              if (localbhwl == null) {
                continue;
              }
              i = localbhwl.a();
              if ((localbhwl == null) || (!localbhwl.a())) {
                continue;
              }
              bool1 = true;
              bool4 = ajzo.a(this.this$0.a.app, 1130L, bool6, (Map)localObject1);
              if (bool4) {
                break label1419;
              }
              bool3 = false;
              i = 0;
              localStringBuilder.append("readInJoy red point-->readInJoyNotifyCount=").append(i).append(", isReadinjoyNotifyNeedsDisplay=").append(bool3).append(", isKanDianEntryShow=").append(bool4);
              if ((localRedDotInfo == null) || (localRedDotInfo.uint32_appid.get() != 52) || (this.this$0.a.app.a().a) || (!this.this$0.a.app.a().b())) {
                break label1413;
              }
              i1 = localRedDotInfo.uint32_number.get();
              i3 = bcji.a(this.this$0.a.app, true);
              i2 = bcji.a(this.this$0.a.app, false);
              if (ajzo.a(this.this$0.a.app, 770L, bool6, (Map)localObject1)) {
                break label1410;
              }
              i2 = 0;
              i3 = 0;
              bool7 = amnj.a(this.this$0.a.app, "redpoint_leba_show");
              if (!bool7) {
                break label1401;
              }
              bool4 = ajzo.a(this.this$0.a.app, 7759L, bool6, (Map)localObject1);
              if ((!bool7) || (!bool4)) {
                continue;
              }
              bool1 = true;
              break label1445;
            }
          }
        }
      }
    }
    for (;;)
    {
      localStringBuilder.append("confessRedPoit").append(bool5).append(",").append(bool7).append(",").append(bool1);
      int i4 = 0;
      if (ajzo.a(this.this$0.a.app, 7720L, bool6, (Map)localObject1)) {
        i4 = asfl.a(this.this$0.a.app);
      }
      localStringBuilder.append("matchChatRedNum,").append(i4);
      i4 = i5 + n + j + i + m + i1 + i3 + i4;
      QLog.i("MainAssistObserver.LebaTabRedTouch", 1, "updateTabLebaNotify: totalCount=" + i4 + ", qz=" + i5 + ", numRedTouch=" + n + ", redNumPointNums=" + j + ", readInJoyNotifyCount=" + i + ", nearbyNum=" + m + ", storyRedNum=" + i1 + ", allPeopleVoteRedNumCount=" + i3 + localStringBuilder.toString());
      if (i4 > 0)
      {
        localObject1 = new BusinessInfoCheckUpdate.RedTypeInfo();
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.set(5);
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_content.set(i4 + "");
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_desc.set("{'cn':'#FF0000'}");
        break;
      }
      Object localObject2;
      label1395:
      Object localObject4 = null;
      break;
      label1401:
      bool1 = false;
      boolean bool5 = false;
      continue;
      label1410:
      break label800;
      label1413:
      i1 = 0;
      break label739;
      label1419:
      bool3 = bool1;
      break label641;
      label1426:
      n = 0;
      break label538;
      label1432:
      bool2 = bool1;
      break label438;
      break label318;
      break label269;
      label1445:
      bool5 = bool1;
      bool1 = bool4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.LebaTabRedTouch.1
 * JD-Core Version:    0.7.0.1
 */