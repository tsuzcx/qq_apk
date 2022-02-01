package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import bcvr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import java.util.ArrayList;

class Leba$33
  implements Runnable
{
  Leba$33(Leba paramLeba) {}
  
  public void run()
  {
    localObject4 = (bcvr)this.this$0.a.getManager(QQManagerFactory.QZONE_MANAGER);
    int j;
    Object localObject1;
    if (localObject4 != null)
    {
      j = ((bcvr)localObject4).a(1);
      if (localObject4 == null) {
        break label181;
      }
      localObject1 = ((bcvr)localObject4).a();
      label42:
      if (QLog.isColorLevel()) {
        QLog.d("UndealCount.Q.lebatab.leba", 2, "TYPE_PASSIVE_FEED freshEntryItemUI num=" + j);
      }
      this.this$0.b(new Leba.33.1(this, j));
      if (localObject4 == null) {
        break label187;
      }
      i = ((bcvr)localObject4).a(2);
      label101:
      if ((i <= 0) || (localObject1 == null) || (((ArrayList)localObject1).size() <= 0)) {
        break label192;
      }
      if ((!QLog.isColorLevel()) || (QLog.isColorLevel())) {
        QLog.d("UndealCount.Q.lebatab.leba", 2, "TYPE_ACTIVE_FEED updateQZoneFlag.mQzoneFeedSubIcon setImageDrawable");
      }
      i = 8;
      this.this$0.b(new Leba.33.2(this, (ArrayList)localObject1));
    }
    for (;;)
    {
      this.this$0.b(new Leba.33.5(this, i, j));
      return;
      j = 0;
      break;
      label181:
      localObject1 = null;
      break label42;
      label187:
      i = 0;
      break label101;
      for (;;)
      {
        for (;;)
        {
          try
          {
            label192:
            if (QLog.isColorLevel()) {
              QLog.d("UndealCount.Q.lebatab.leba", 2, "updateQZoneFlag.noflag count=" + i);
            }
            if (localObject4 == null) {
              continue;
            }
            localObject1 = ((bcvr)localObject4).a(6);
            if (localObject4 == null) {
              continue;
            }
            localObject5 = ((bcvr)localObject4).a(61);
            if (localObject4 == null) {
              continue;
            }
            localQZoneCountInfo = ((bcvr)localObject4).a(3);
            localObject6 = "";
            localObject4 = "";
            if ((localObject1 == null) || (((QZoneCountInfo)localObject1).friendList == null) || (((QZoneCountInfo)localObject1).friendList.size() <= 0) || (((QZoneCountUserInfo)((QZoneCountInfo)localObject1).friendList.get(0)).uin <= 0L) || (((QZoneCountInfo)localObject1).uCount <= 0L)) {
              continue;
            }
            localObject4 = ((QZoneCountInfo)localObject1).strShowMsg;
            localObject6 = ((QZoneCountUserInfo)((QZoneCountInfo)localObject1).friendList.get(0)).uin + "";
            i = 1;
            localObject1 = localObject4;
            localObject4 = localObject6;
          }
          catch (Exception localException2)
          {
            QZoneCountInfo localQZoneCountInfo;
            Object localObject6;
            boolean bool;
            Object localObject2;
            i = 0;
            continue;
            Object localObject5 = localException2;
            Object localObject3 = localObject4;
            localObject4 = localObject5;
            continue;
            i = 0;
            localObject3 = localObject6;
            continue;
          }
          if ((i != 0) || (localObject5 == null) || (((QZoneCountInfo)localObject5).friendList == null) || (((QZoneCountInfo)localObject5).friendList.size() <= 0) || (((QZoneCountUserInfo)((QZoneCountInfo)localObject5).friendList.get(0)).uin <= 0L) || (((QZoneCountInfo)localObject5).uCount <= 0L)) {
            continue;
          }
          localObject4 = ((QZoneCountInfo)localObject5).strShowMsg;
          localObject1 = ((QZoneCountUserInfo)((QZoneCountInfo)localObject5).friendList.get(0)).uin + "";
          i = 1;
          localObject6 = localObject1;
          localObject5 = localObject4;
          if (i == 0)
          {
            localObject6 = localObject1;
            localObject5 = localObject4;
            if (localQZoneCountInfo != null)
            {
              localObject6 = localObject1;
              localObject5 = localObject4;
              if (localQZoneCountInfo.friendList != null)
              {
                localObject6 = localObject1;
                localObject5 = localObject4;
                if (localQZoneCountInfo.friendList.size() > 0)
                {
                  localObject6 = localObject1;
                  localObject5 = localObject4;
                  if (((QZoneCountUserInfo)localQZoneCountInfo.friendList.get(0)).uin > 0L)
                  {
                    localObject6 = localObject1;
                    localObject5 = localObject4;
                    if (localQZoneCountInfo.uCount > 0L)
                    {
                      localObject5 = localQZoneCountInfo.strShowMsg;
                      localObject6 = ((QZoneCountUserInfo)localQZoneCountInfo.friendList.get(0)).uin + "";
                    }
                  }
                }
              }
            }
          }
          bool = TextUtils.isEmpty((CharSequence)localObject5);
          if (bool) {
            continue;
          }
          i = -1;
          try
          {
            this.this$0.b(new Leba.33.3(this, (String)localObject5, (String)localObject6));
          }
          catch (Exception localException1) {}
        }
        QLog.e("Leba", 1, "updateQZoneRedFlag" + localException1);
        break;
        localObject2 = null;
        continue;
        localObject5 = null;
        continue;
        localQZoneCountInfo = null;
      }
      this.this$0.b(new Leba.33.4(this));
      if (QLog.isColorLevel()) {
        QLog.d("UndealCount.ZebraAlbum.Q.lebatab.leba", 2, "freshEntryItemUI set style NOTETXT_STYLE_DEFAULT and mQzoneFeedSubIcon GONE");
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.33
 * JD-Core Version:    0.7.0.1
 */