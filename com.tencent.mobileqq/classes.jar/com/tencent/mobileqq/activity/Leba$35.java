package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import bcvn;
import bmwi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import java.util.ArrayList;

class Leba$35
  implements Runnable
{
  Leba$35(Leba paramLeba) {}
  
  public void run()
  {
    localObject4 = (bcvn)this.this$0.a.getManager(10);
    int j;
    Object localObject1;
    if (localObject4 != null)
    {
      j = ((bcvn)localObject4).a(1);
      if (localObject4 == null) {
        break label180;
      }
      localObject1 = ((bcvn)localObject4).a();
      label41:
      if (QLog.isColorLevel()) {
        QLog.d("UndealCount.Q.lebatab.leba", 2, "TYPE_PASSIVE_FEED freshEntryItemUI num=" + j);
      }
      this.this$0.a(new Leba.35.1(this, j));
      if (localObject4 == null) {
        break label186;
      }
      i = ((bcvn)localObject4).a(2);
      label100:
      if ((i <= 0) || (localObject1 == null) || (((ArrayList)localObject1).size() <= 0)) {
        break label191;
      }
      if ((!QLog.isColorLevel()) || (QLog.isColorLevel())) {
        QLog.d("UndealCount.Q.lebatab.leba", 2, "TYPE_ACTIVE_FEED updateQZoneFlag.mQzoneFeedSubIcon setImageDrawable");
      }
      i = 8;
      this.this$0.a(new Leba.35.2(this, (ArrayList)localObject1));
    }
    for (;;)
    {
      this.this$0.a(new Leba.35.5(this, i, j));
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
            localObject1 = ((bcvn)localObject4).a(6);
            if (localObject4 == null) {
              continue;
            }
            localObject5 = ((bcvn)localObject4).a(61);
            if (localObject4 == null) {
              continue;
            }
            localbmwi = ((bcvn)localObject4).a(3);
            localObject6 = "";
            localObject4 = "";
            if ((localObject1 == null) || (((bmwi)localObject1).jdField_a_of_type_JavaUtilArrayList == null) || (((bmwi)localObject1).jdField_a_of_type_JavaUtilArrayList.size() <= 0) || (((QZoneCountUserInfo)((bmwi)localObject1).jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long <= 0L) || (((bmwi)localObject1).jdField_a_of_type_Long <= 0L)) {
              continue;
            }
            localObject4 = ((bmwi)localObject1).f;
            localObject6 = ((QZoneCountUserInfo)((bmwi)localObject1).jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long + "";
            i = 1;
            localObject1 = localObject4;
            localObject4 = localObject6;
          }
          catch (Exception localException2)
          {
            bmwi localbmwi;
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
          if ((i != 0) || (localObject5 == null) || (((bmwi)localObject5).jdField_a_of_type_JavaUtilArrayList == null) || (((bmwi)localObject5).jdField_a_of_type_JavaUtilArrayList.size() <= 0) || (((QZoneCountUserInfo)((bmwi)localObject5).jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long <= 0L) || (((bmwi)localObject5).jdField_a_of_type_Long <= 0L)) {
            continue;
          }
          localObject4 = ((bmwi)localObject5).f;
          localObject1 = ((QZoneCountUserInfo)((bmwi)localObject5).jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long + "";
          i = 1;
          localObject6 = localObject1;
          localObject5 = localObject4;
          if (i == 0)
          {
            localObject6 = localObject1;
            localObject5 = localObject4;
            if (localbmwi != null)
            {
              localObject6 = localObject1;
              localObject5 = localObject4;
              if (localbmwi.jdField_a_of_type_JavaUtilArrayList != null)
              {
                localObject6 = localObject1;
                localObject5 = localObject4;
                if (localbmwi.jdField_a_of_type_JavaUtilArrayList.size() > 0)
                {
                  localObject6 = localObject1;
                  localObject5 = localObject4;
                  if (((QZoneCountUserInfo)localbmwi.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long > 0L)
                  {
                    localObject6 = localObject1;
                    localObject5 = localObject4;
                    if (localbmwi.jdField_a_of_type_Long > 0L)
                    {
                      localObject5 = localbmwi.f;
                      localObject6 = ((QZoneCountUserInfo)localbmwi.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long + "";
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
            this.this$0.a(new Leba.35.3(this, (String)localObject5, (String)localObject6));
          }
          catch (Exception localException1) {}
        }
        QLog.e("Leba", 1, "updateQZoneRedFlag" + localException1);
        break;
        localObject2 = null;
        continue;
        localObject5 = null;
        continue;
        localbmwi = null;
      }
      this.this$0.a(new Leba.35.4(this));
      if (QLog.isColorLevel()) {
        QLog.d("UndealCount.ZebraAlbum.Q.lebatab.leba", 2, "freshEntryItemUI set style NOTETXT_STYLE_DEFAULT and mQzoneFeedSubIcon GONE");
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.35
 * JD-Core Version:    0.7.0.1
 */