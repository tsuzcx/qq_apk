package com.tencent.mobileqq.activity.main;

import afqg;
import afqh;
import ajlj;
import alxu;
import arjg;
import atax;
import atay;
import auqh;
import awnu;
import bbfu;
import bgnc;
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
import mmy;
import msg;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class LebaTabRedTouch$1
  implements Runnable
{
  public LebaTabRedTouch$1(afqg paramafqg, afqh paramafqh) {}
  
  public void run()
  {
    label314:
    boolean bool1;
    label367:
    boolean bool3;
    boolean bool2;
    label507:
    int n;
    label626:
    boolean bool4;
    label767:
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
        boolean bool6;
        int k;
        int j;
        int m;
        int i5;
        Object localObject6;
        label891:
        int i3;
        int i2;
        label952:
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
        break label1624;
        if (localObject5 == null) {
          continue;
        }
        QLog.i("MainAssistObserver.LebaTabRedTouch", 1, "updateTabLebaNotify redTypeInfo != null.");
        localObject2 = localObject5;
        continue;
        if ((k <= 0) && (!afqg.a(this.this$0)) && (!bool3) && (!bool2) && (i2 <= 0) && (!bool5)) {
          break label1574;
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
      localObject5 = (mmy)this.this$0.a.app.getManager(70);
      localRedDotInfo = ((mmy)localObject5).a();
      i = -1;
      if (localRedDotInfo != null) {
        i = localRedDotInfo.uint32_appid.get();
      }
      if ((!this.this$0.a.app.a().a) && (i == 11))
      {
        localObject5 = new BusinessInfoCheckUpdate.RedTypeInfo();
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject5).red_type.set(4);
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject5).red_content.set(localRedDotInfo.str_custom_buffer.get().toStringUtf8());
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject5).red_desc.set("{'cn':'#FF0000', 'av':1}");
        localObject1 = localObject5;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.qqstory.redPointMainAssistObserver", 2, "story文字、图片红点,storyAppid:" + i);
          localObject1 = localObject5;
        }
        this.a.a((BusinessInfoCheckUpdate.RedTypeInfo)localObject1);
        if (this.a != null) {
          this.a.a();
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("MainAssistObserver.LebaTabRedTouch", 2, "mIsShowNewLeba=" + this.this$0.a.app.q + ", uin=" + this.this$0.a.app.getCurrentAccountUin());
        }
        bool6 = awnu.a();
        localObject1 = Collections.emptyMap();
        if (bool6)
        {
          localObject1 = this.this$0.a();
          k = ((mmy)localObject5).a(this.this$0.a.app);
          j = ((mmy)localObject5).a();
          bool1 = ajlj.a(this.this$0.a.app, 826L, bool6, (Map)localObject1);
          if (!bool1)
          {
            j = 0;
            k = 0;
            if (QLog.isColorLevel()) {
              QLog.i("MainAssistObserver.LebaTabRedTouch", 2, "troop red point-->redPointNums=" + k + ", redNumPointNums=" + j + ", isBuluoEntryShow=" + bool1);
            }
            ((atax)this.this$0.a.app.getManager(160)).a(100510);
            localObject5 = ((mmy)localObject5).a(((mmy)localObject5).a(), false);
            if (((atay)localObject5).a != -1)
            {
              bool1 = true;
              m = ((atay)localObject5).b;
              bool3 = ajlj.a(this.this$0.a.app, 7719L, bool6, (Map)localObject1);
              if (bool3) {
                break label1611;
              }
              bool2 = false;
              m = 0;
              if (QLog.isColorLevel()) {
                QLog.i("MainAssistObserver.LebaTabRedTouch", 2, "nearby red point-->nearbyNum=" + m + ", nearbyHasRedPoint=" + bool2 + ", isNearbyEntryShow=" + bool3);
              }
              localObject5 = ((auqh)this.this$0.a.app.getManager(36)).a(this.this$0.a.app, bool6, (Map)localObject1);
              if ((localObject5 == null) || (((BusinessInfoCheckUpdate.RedTypeInfo)localObject5).red_type.get() != 5)) {
                break label1605;
              }
              n = Integer.parseInt(((BusinessInfoCheckUpdate.RedTypeInfo)localObject5).red_content.get());
              if (QLog.isColorLevel()) {
                QLog.i("MainAssistObserver.LebaTabRedTouch", 2, "business red point-->numRedTouch=" + n);
              }
              i5 = afqg.a(this.this$0);
              if (QLog.isColorLevel()) {
                QLog.i("MainAssistObserver.LebaTabRedTouch", 2, "QZone red point-->qzonMsgCount=" + i5);
              }
              localObject6 = afqg.a(this.this$0);
              if (localObject6 == null) {
                continue;
              }
              i = ((bgnc)localObject6).a();
              if ((localObject6 == null) || (!((bgnc)localObject6).a())) {
                continue;
              }
              bool1 = true;
              bool4 = ajlj.a(this.this$0.a.app, 1130L, bool6, (Map)localObject1);
              if (bool4) {
                break label1598;
              }
              bool3 = false;
              i = 0;
              if (QLog.isColorLevel())
              {
                localObject6 = new StringBuilder();
                ((StringBuilder)localObject6).append("readInJoy red point-->readInJoyNotifyCount=").append(i).append(", isReadinjoyNotifyNeedsDisplay=").append(bool3).append(", isKanDianEntryShow=").append(bool4);
                QLog.i("MainAssistObserver.LebaTabRedTouch", 2, ((StringBuilder)localObject6).toString());
              }
              if ((localRedDotInfo == null) || (localRedDotInfo.uint32_appid.get() != 52) || (this.this$0.a.app.a().a) || (!this.this$0.a.app.a().b())) {
                break label1592;
              }
              i1 = localRedDotInfo.uint32_number.get();
              i3 = bbfu.a(this.this$0.a.app, true);
              i2 = bbfu.a(this.this$0.a.app, false);
              if (ajlj.a(this.this$0.a.app, 770L, bool6, (Map)localObject1)) {
                break label1589;
              }
              i2 = 0;
              i3 = 0;
              bool7 = alxu.a(this.this$0.a.app, "redpoint_leba_show");
              if (!bool7) {
                break label1580;
              }
              bool4 = ajlj.a(this.this$0.a.app, 7759L, bool6, (Map)localObject1);
              if ((!bool7) || (!bool4)) {
                continue;
              }
              bool1 = true;
              break label1624;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MainAssistObserver.LebaTabRedTouch", 2, "confessRedPoit," + bool5 + "," + bool7 + "," + bool1);
      }
      int i4 = 0;
      if (ajlj.a(this.this$0.a.app, 7720L, bool6, (Map)localObject1)) {
        i4 = arjg.a(this.this$0.a.app);
      }
      if (QLog.isColorLevel()) {
        QLog.i("MainAssistObserver.LebaTabRedTouch", 2, "matchChatRedNum," + i4);
      }
      i4 = i5 + n + j + i + m + i1 + i3 + i4;
      QLog.i("MainAssistObserver.LebaTabRedTouch", 1, "updateTabLebaNotify: totalCount=" + i4 + ", qz=" + i5 + ", numRedTouch=" + n + ", redNumPointNums=" + j + ", readInJoyNotifyCount=" + i + ", nearbyNum=" + m + ", storyRedNum=" + i1 + ", allPeopleVoteRedNumCount=" + i3);
      if (i4 > 0)
      {
        localObject1 = new BusinessInfoCheckUpdate.RedTypeInfo();
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.set(5);
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_content.set(i4 + "");
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_desc.set("{'cn':'#FF0000'}");
        break;
      }
      Object localObject2;
      label1574:
      Object localObject4 = null;
      break;
      label1580:
      bool1 = false;
      boolean bool5 = false;
      continue;
      label1589:
      break label952;
      label1592:
      i1 = 0;
      break label891;
      label1598:
      bool3 = bool1;
      break label767;
      label1605:
      n = 0;
      break label626;
      label1611:
      bool2 = bool1;
      break label507;
      break label367;
      break label314;
      label1624:
      bool5 = bool1;
      bool1 = bool4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.LebaTabRedTouch.1
 * JD-Core Version:    0.7.0.1
 */