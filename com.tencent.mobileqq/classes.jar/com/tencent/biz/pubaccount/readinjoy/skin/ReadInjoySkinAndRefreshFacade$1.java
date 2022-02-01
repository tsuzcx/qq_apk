package com.tencent.biz.pubaccount.readinjoy.skin;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQManagerFactory;
import rmt;
import rmu;
import rmx;
import rna;
import rno;
import rns;

public class ReadInjoySkinAndRefreshFacade$1
  implements Runnable
{
  public ReadInjoySkinAndRefreshFacade$1(rno paramrno) {}
  
  public void run()
  {
    Object localObject = (rmu)this.this$0.a.getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER);
    int i = rno.a(this.this$0);
    RefreshData localRefreshData = ((rmu)localObject).a(this.this$0.a.getApp(), i);
    int j = (int)(System.currentTimeMillis() / 1000L);
    if ((localRefreshData != null) && (localRefreshData.isShowInSource(rno.a(this.this$0))) && (j >= localRefreshData.beginTime) && (j <= localRefreshData.endTime)) {
      if (rns.a(localRefreshData.id)) {
        if (localRefreshData.isShown)
        {
          ((rmu)localObject).a(1, localRefreshData.id, localRefreshData.seq, i);
          ((rmu)localObject).a(true);
        }
      }
    }
    for (;;)
    {
      localObject = (GuideData)((rmt)this.this$0.a.getManager(QQManagerFactory.READ_IN_JOY_OPERATION_MANAGER)).a("operation_guide");
      SkinData localSkinData = ((rna)this.this$0.a.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).a(this.this$0.a.getApp());
      ((rmx)this.this$0.a.getBusinessHandler(BusinessHandlerFactory.READ_INJOY_SKIN_HANDLER)).a(localSkinData, null, localRefreshData, (GuideData)localObject, rno.a(this.this$0));
      return;
      ((rmu)localObject).a(0, "", -1L, i);
      continue;
      ((rmu)localObject).a(0, "", -1L, i);
      ((rmu)localObject).a(localRefreshData, rno.a(this.this$0));
      continue;
      ((rmu)localObject).a(0, "", -1L, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.skin.ReadInjoySkinAndRefreshFacade.1
 * JD-Core Version:    0.7.0.1
 */