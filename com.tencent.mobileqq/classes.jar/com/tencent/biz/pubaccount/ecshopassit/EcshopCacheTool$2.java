package com.tencent.biz.pubaccount.ecshopassit;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.qqshop.qqshop.SQQSHPAccoutRelation;
import tencent.im.oidb.qqshop.qqshop.SQQSHPClientRsp;
import tencent.im.oidb.qqshop.qqshop.SQQSHPNewUserRecmd;

class EcshopCacheTool$2
  implements BusinessObserver
{
  EcshopCacheTool$2(EcshopCacheTool paramEcshopCacheTool) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("extra_cmd");
    if (paramBoolean)
    {
      paramBoolean = "SQQShopFolderSvc.GetShopBindUin".equals(localObject);
      paramInt = 0;
      if (paramBoolean)
      {
        paramBundle = paramBundle.getByteArray("extra_data");
        localObject = new qqshop.SQQSHPClientRsp();
      }
    }
    try
    {
      ((qqshop.SQQSHPClientRsp)localObject).mergeFrom(paramBundle);
      paramBundle = ((qqshop.SQQSHPClientRsp)localObject).bindlist.get();
      while (paramInt < paramBundle.size())
      {
        localObject = (qqshop.SQQSHPAccoutRelation)paramBundle.get(paramInt);
        String str = String.valueOf(((qqshop.SQQSHPAccoutRelation)localObject).puin.get());
        long l = ((qqshop.SQQSHPAccoutRelation)localObject).binduin.get();
        this.a.d.put(str, Integer.valueOf(((qqshop.SQQSHPAccoutRelation)localObject).distance.get()));
        this.a.e.put(str, String.valueOf(l));
        paramInt += 1;
      }
      if ((this.a.h != null) && (this.a.h.k != null) && (this.a.h.l == 1))
      {
        this.a.h.k.notifyDataSetChanged();
        return;
        if ("SQQShopFolderSvc.GetFolderInfo".equals(localObject))
        {
          paramBundle = paramBundle.getByteArray("extra_data");
          localObject = new qqshop.SQQSHPClientRsp();
          ((qqshop.SQQSHPClientRsp)localObject).mergeFrom(paramBundle);
          if (((qqshop.SQQSHPClientRsp)localObject).newusrrecmd.has())
          {
            paramBundle = (qqshop.SQQSHPNewUserRecmd)((qqshop.SQQSHPClientRsp)localObject).newusrrecmd.get();
            if ((paramBundle.recmdflag.has()) && (paramBundle.recmdflag.get() == 1))
            {
              paramBundle = paramBundle.recmdurl.get();
              if ((!TextUtils.isEmpty(paramBundle)) && (this.a.h != null))
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("newusrrecmd url:");
                ((StringBuilder)localObject).append(paramBundle);
                QLog.i("EcshopCacheTool", 2, ((StringBuilder)localObject).toString());
                localObject = new Intent(this.a.h.getQBaseActivity(), QQBrowserActivity.class);
                ((Intent)localObject).putExtra("url", paramBundle);
                ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
                this.a.h.startActivity((Intent)localObject);
                this.a.h.getQBaseActivity().overridePendingTransition(2130771996, 0);
                ReportController.b(null, "CliOper", "", "", "Shop_newuser", "Pv_shopnewuserpage", 0, 0, "", "", "", "");
              }
            }
          }
        }
      }
      return;
    }
    catch (Exception paramBundle) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcshopCacheTool.2
 * JD-Core Version:    0.7.0.1
 */