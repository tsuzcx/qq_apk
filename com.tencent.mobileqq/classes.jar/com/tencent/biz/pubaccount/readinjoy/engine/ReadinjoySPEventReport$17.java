package com.tencent.biz.pubaccount.readinjoy.engine;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.List;
import pha;
import pmy;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;
import tzo;

public final class ReadinjoySPEventReport$17
  implements Runnable
{
  public ReadinjoySPEventReport$17(int paramInt) {}
  
  public void run()
  {
    for (;;)
    {
      int j;
      int i;
      try
      {
        if (!pmy.b(61)) {
          return;
        }
        j = -1;
        Object localObject1 = BaseActivity.sTopActivity;
        i = j;
        if ((localObject1 instanceof SplashActivity))
        {
          localObject1 = (SplashActivity)localObject1;
          i = j;
          if (SplashActivity.a == 1)
          {
            i = ((SplashActivity)localObject1).a();
            if (i != MainFragment.h) {
              break label266;
            }
            i = 3;
          }
        }
        if (this.a != 22) {
          break label302;
        }
        j = 1;
        Object localObject2 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(1);
        ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("tab");
        ((oidb_cmd0x80a.AttributeList)localObject2).att_value.set(String.valueOf(i));
        oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
        localAttributeList.att_id.set(2);
        localAttributeList.att_name.set("type");
        localAttributeList.att_value.set(j + "");
        localObject1 = new ArrayList();
        ((List)localObject1).add(localObject2);
        ((List)localObject1).add(localAttributeList);
        localObject2 = pha.d(1008);
        if ((i == 1) && (!TextUtils.isEmpty((CharSequence)localObject2)))
        {
          localAttributeList = new oidb_cmd0x80a.AttributeList();
          localAttributeList.att_id.set(3);
          localAttributeList.att_name.set("FuncRed");
          localAttributeList.att_value.set((String)localObject2);
          ((List)localObject1).add(localAttributeList);
        }
        tzo.a(61, (List)localObject1);
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.fillInStackTrace();
        return;
      }
      label266:
      if (i == MainFragment.d)
      {
        i = 2;
      }
      else if (i == MainFragment.b)
      {
        i = 1;
      }
      else if (i == MainFragment.e)
      {
        i = 4;
        continue;
        label302:
        if (this.a == 23)
        {
          j = 2;
        }
        else
        {
          j = this.a;
          if (j == 24) {
            j = 3;
          } else {
            j = 4;
          }
        }
      }
      else
      {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.17
 * JD-Core Version:    0.7.0.1
 */