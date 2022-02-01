package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.troopgag.api.TroopGagObserver;
import com.tencent.mobileqq.troop.troopgag.data.GagStatus;
import com.tencent.mobileqq.troop.troopgag.data.GagTroopMemberResult;
import com.tencent.mobileqq.troop.troopgag.data.GagTroopResult;
import com.tencent.mobileqq.troop.troopgag.data.MemberGagInfo;
import com.tencent.mobileqq.troop.troopgag.data.TroopGagInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class TroopGagActivity$2
  extends TroopGagObserver
{
  TroopGagActivity$2(TroopGagActivity paramTroopGagActivity) {}
  
  protected void a(GagStatus paramGagStatus)
  {
    if (paramGagStatus != null)
    {
      if (!paramGagStatus.a.equals(this.a.c)) {
        return;
      }
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onTroopGagStatusChange, statuCode=");
        ((StringBuilder)localObject).append(paramGagStatus.b);
        QLog.d("TroopGagActivity", 2, ((StringBuilder)localObject).toString());
      }
      TroopGagActivity.GagMemInfo localGagMemInfo;
      if (paramGagStatus.b == 3)
      {
        this.a.i.clear();
        if (paramGagStatus.e != null)
        {
          paramGagStatus = paramGagStatus.e.iterator();
          while (paramGagStatus.hasNext())
          {
            localObject = (MemberGagInfo)paramGagStatus.next();
            localGagMemInfo = new TroopGagActivity.GagMemInfo();
            localGagMemInfo.a = ((MemberGagInfo)localObject).a;
            localGagMemInfo.c = ((MemberGagInfo)localObject).b;
            this.a.i.add(localGagMemInfo);
          }
        }
        this.a.b.notifyDataSetChanged();
      }
      else if (paramGagStatus.b == 1)
      {
        paramGagStatus = paramGagStatus.c;
        this.a.h.setOnCheckedChangeListener(null);
        if (paramGagStatus.b != 0L) {
          this.a.h.setChecked(true);
        } else {
          this.a.h.setChecked(false);
        }
        this.a.h.setOnCheckedChangeListener(this.a);
      }
      else if (paramGagStatus.b == 5)
      {
        if (!paramGagStatus.g.a)
        {
          ThreadManager.post(new TroopGagActivity.2.1(this, new Handler(Looper.getMainLooper())), 8, null, false);
        }
        else
        {
          this.a.i.clear();
          if (paramGagStatus.e != null)
          {
            paramGagStatus = paramGagStatus.e.iterator();
            while (paramGagStatus.hasNext())
            {
              localObject = (MemberGagInfo)paramGagStatus.next();
              localGagMemInfo = new TroopGagActivity.GagMemInfo();
              localGagMemInfo.a = ((MemberGagInfo)localObject).a;
              localGagMemInfo.c = ((MemberGagInfo)localObject).b;
              this.a.i.add(localGagMemInfo);
            }
          }
          this.a.b.notifyDataSetChanged();
        }
      }
      else if (paramGagStatus.b == 4)
      {
        paramGagStatus = paramGagStatus.f;
        if (!paramGagStatus.a)
        {
          this.a.h.setOnCheckedChangeListener(null);
          if (paramGagStatus.b != 0L) {
            this.a.h.setChecked(false);
          } else {
            this.a.h.setChecked(true);
          }
          this.a.h.setOnCheckedChangeListener(this.a);
        }
      }
      if (this.a.i.size() == 0)
      {
        this.a.f.setVisibility(8);
        return;
      }
      this.a.f.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopGagActivity.2
 * JD-Core Version:    0.7.0.1
 */