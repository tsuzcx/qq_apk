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
    if ((paramBoolean.booleanValue()) && (this.a.p))
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
            if (localTroopAIOAppInfo.appid == this.a.m)
            {
              QQToast.makeText(BaseApplication.getContext(), 2, 2131917369, 0).show(this.a.getResources().getDimensionPixelSize(2131299920));
              return;
            }
          }
        }
        localArrayList.add(Integer.valueOf(this.a.m));
        localObject = new ArrayList();
        ((ArrayList)localObject).add(Integer.valueOf(this.a.m));
        paramBoolean.addTroopApp(localArrayList, (ArrayList)localObject);
      }
    }
  }
  
  protected void b(Boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", this.a.n);
    localBundle.putInt("type", c);
    localBundle.putBoolean("isSuccess", paramBoolean.booleanValue());
    this.a.a(44, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.7
 * JD-Core Version:    0.7.0.1
 */