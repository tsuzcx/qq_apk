package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import azbw;
import bjha;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import java.util.ArrayList;

class Leba$36
  implements Runnable
{
  Leba$36(Leba paramLeba) {}
  
  public void run()
  {
    localObject4 = (azbw)this.this$0.a.getManager(10);
    int j;
    Object localObject1;
    if (localObject4 != null)
    {
      j = ((azbw)localObject4).a(1);
      if (localObject4 == null) {
        break label180;
      }
      localObject1 = ((azbw)localObject4).a();
      label41:
      if (QLog.isColorLevel()) {
        QLog.d("UndealCount.Q.lebatab.leba", 2, "TYPE_PASSIVE_FEED freshEntryItemUI num=" + j);
      }
      this.this$0.a(new Leba.36.1(this, j));
      if (localObject4 == null) {
        break label186;
      }
      i = ((azbw)localObject4).a(2);
      label100:
      if ((i <= 0) || (localObject1 == null) || (((ArrayList)localObject1).size() <= 0)) {
        break label191;
      }
      if ((!QLog.isColorLevel()) || (QLog.isColorLevel())) {
        QLog.d("UndealCount.Q.lebatab.leba", 2, "TYPE_ACTIVE_FEED updateQZoneFlag.mQzoneFeedSubIcon setImageDrawable");
      }
      i = 8;
      this.this$0.a(new Leba.36.2(this, (ArrayList)localObject1));
    }
    for (;;)
    {
      this.this$0.a(new Leba.36.5(this, i, j));
      return;
      j = 0;
      break;
      label180:
      localObject1 = null;
      break label41;
      label186:
      i = 0;
      break label100;
      for (;;)
      {
        for (;;)
        {
          try
          {
            label191:
            if (QLog.isColorLevel()) {
              QLog.d("UndealCount.Q.lebatab.leba", 2, "updateQZoneFlag.noflag count=" + i);
            }
            if (localObject4 == null) {
              continue;
            }
            localObject1 = ((azbw)localObject4).a(6);
            if (localObject4 == null) {
              continue;
            }
            localObject5 = ((azbw)localObject4).a(61);
            if (localObject4 == null) {
              continue;
            }
            localbjha = ((azbw)localObject4).a(3);
            localObject6 = "";
            localObject4 = "";
            if ((localObject1 == null) || (((bjha)localObject1).jdField_a_of_type_JavaUtilArrayList == null) || (((bjha)localObject1).jdField_a_of_type_JavaUtilArrayList.size() <= 0) || (((QZoneCountUserInfo)((bjha)localObject1).jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long <= 0L) || (((bjha)localObject1).jdField_a_of_type_Long <= 0L)) {
              continue;
            }
            localObject4 = ((bjha)localObject1).f;
            localObject6 = ((QZoneCountUserInfo)((bjha)localObject1).jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long + "";
            i = 1;
            localObject1 = localObject4;
            localObject4 = localObject6;
          }
          catch (Exception localException2)
          {
            bjha localbjha;
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
          if ((i != 0) || (localObject5 == null) || (((bjha)localObject5).jdField_a_of_type_JavaUtilArrayList == null) || (((bjha)localObject5).jdField_a_of_type_JavaUtilArrayList.size() <= 0) || (((QZoneCountUserInfo)((bjha)localObject5).jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long <= 0L) || (((bjha)localObject5).jdField_a_of_type_Long <= 0L)) {
            continue;
          }
          localObject4 = ((bjha)localObject5).f;
          localObject1 = ((QZoneCountUserInfo)((bjha)localObject5).jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long + "";
          i = 1;
          localObject6 = localObject1;
          localObject5 = localObject4;
          if (i == 0)
          {
            localObject6 = localObject1;
            localObject5 = localObject4;
            if (localbjha != null)
            {
              localObject6 = localObject1;
              localObject5 = localObject4;
              if (localbjha.jdField_a_of_type_JavaUtilArrayList != null)
              {
                localObject6 = localObject1;
                localObject5 = localObject4;
                if (localbjha.jdField_a_of_type_JavaUtilArrayList.size() > 0)
                {
                  localObject6 = localObject1;
                  localObject5 = localObject4;
                  if (((QZoneCountUserInfo)localbjha.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long > 0L)
                  {
                    localObject6 = localObject1;
                    localObject5 = localObject4;
                    if (localbjha.jdField_a_of_type_Long > 0L)
                    {
                      localObject5 = localbjha.f;
                      localObject6 = ((QZoneCountUserInfo)localbjha.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long + "";
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
            this.this$0.a(new Leba.36.3(this, (String)localObject5, (String)localObject6));
          }
          catch (Exception localException1) {}
        }
        QLog.e("Leba", 1, "updateQZoneRedFlag" + localException1);
        break;
        localObject2 = null;
        continue;
        localObject5 = null;
        continue;
        localbjha = null;
      }
      this.this$0.a(new Leba.36.4(this));
      if (QLog.isColorLevel()) {
        QLog.d("UndealCount.ZebraAlbum.Q.lebatab.leba", 2, "freshEntryItemUI set style NOTETXT_STYLE_DEFAULT and mQzoneFeedSubIcon GONE");
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.36
 * JD-Core Version:    0.7.0.1
 */