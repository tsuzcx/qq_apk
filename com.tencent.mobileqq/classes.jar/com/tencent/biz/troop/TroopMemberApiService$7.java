package com.tencent.biz.troop;

import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAppService;
import com.tencent.mobileqq.troop.troopapps.api.TroopAppObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

class TroopMemberApiService$7
  extends TroopAppObserver
{
  TroopMemberApiService$7(TroopMemberApiService paramTroopMemberApiService) {}
  
  protected void a(Boolean paramBoolean)
  {
    if ((paramBoolean.booleanValue()) && (this.a.a))
    {
      paramBoolean = (ITroopAppService)TroopMemberApiService.b(this.a).getRuntimeService(ITroopAppService.class, "all");
      ArrayList localArrayList = new ArrayList();
      if (paramBoolean != null)
      {
        Object localObject = paramBoolean.getTroopAppList(false, 0);
        if ((localObject != null) && (!((List)localObject).isEmpty()))
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)((Iterator)localObject).next();
            localArrayList.add(Integer.valueOf(localTroopAIOAppInfo.appid));
            if (localTroopAIOAppInfo.appid == this.a.d)
            {
              QQToast.a(BaseApplication.getContext(), 2, 2131719765, 0).b(this.a.getResources().getDimensionPixelSize(2131299168));
              return;
            }
          }
        }
        localArrayList.add(Integer.valueOf(this.a.d));
        localObject = new ArrayList();
        ((ArrayList)localObject).add(Integer.valueOf(this.a.d));
        paramBoolean.addTroopApp(localArrayList, (ArrayList)localObject);
      }
    }
  }
  
  protected void b(Boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", this.a.e);
    localBundle.putInt("type", b);
    localBundle.putBoolean("isSuccess", paramBoolean.booleanValue());
    this.a.a(44, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.7
 * JD-Core Version:    0.7.0.1
 */