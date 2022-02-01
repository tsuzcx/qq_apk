package com.tencent.biz.pubaccount.readinjoy.engine;

import android.support.v4.app.FragmentManager;
import com.tencent.biz.pubaccount.readinjoy.common.RIJXTabFrameUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contacts.base.Contacts;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.leba.ILebaFrameApi;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

final class ReadinjoySPEventReport$2
  implements Runnable
{
  public void run()
  {
    ArrayList localArrayList;
    Object localObject2;
    Object localObject1;
    if (ReadinjoySPEventReport.b(8))
    {
      localArrayList = new ArrayList();
      localObject2 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(1);
      ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("DTHasRed");
      PBStringField localPBStringField = ((oidb_cmd0x80a.AttributeList)localObject2).att_value;
      if (!ReadinjoySPEventReport.b()) {
        break label201;
      }
      localObject1 = String.valueOf(1);
      localPBStringField.set((String)localObject1);
      localArrayList.add(localObject2);
      localObject1 = BaseActivity.sTopActivity;
      if ((localObject1 != null) && ((localObject1 instanceof SplashActivity)))
      {
        localObject2 = (MainFragment)((SplashActivity)localObject1).getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
        localObject1 = null;
        if (localObject2 != null) {
          localObject1 = ((MainFragment)localObject2).c();
        }
        if (localObject1 != null)
        {
          if (!((String)localObject1).equals(Conversation.class.getName())) {
            break label209;
          }
          localObject1 = "1";
        }
      }
    }
    for (;;)
    {
      localObject2 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(2);
      ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("tab");
      ((oidb_cmd0x80a.AttributeList)localObject2).att_value.set((String)localObject1);
      localArrayList.add(localObject2);
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPushEffectEvent(8, localArrayList);
      ReadinjoySPEventReport.b(System.currentTimeMillis());
      return;
      label201:
      localObject1 = String.valueOf(0);
      break;
      label209:
      if (((String)localObject1).equals(Contacts.class.getName())) {
        localObject1 = "2";
      } else if (((ILebaFrameApi)QRoute.api(ILebaFrameApi.class)).isLeba((String)localObject1)) {
        localObject1 = "4";
      } else if (RIJXTabFrameUtils.a.a((String)localObject1)) {
        localObject1 = "3";
      } else {
        localObject1 = "0";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.2
 * JD-Core Version:    0.7.0.1
 */