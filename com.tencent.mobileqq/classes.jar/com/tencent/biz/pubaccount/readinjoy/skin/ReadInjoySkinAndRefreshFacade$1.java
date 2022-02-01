package com.tencent.biz.pubaccount.readinjoy.skin;

import com.tencent.common.app.AppInterface;
import ran;
import rao;
import rar;
import rau;
import rbi;
import rbm;

public class ReadInjoySkinAndRefreshFacade$1
  implements Runnable
{
  public ReadInjoySkinAndRefreshFacade$1(rbi paramrbi) {}
  
  public void run()
  {
    Object localObject = (rao)this.this$0.a.getManager(270);
    int i = rbi.a(this.this$0);
    RefreshData localRefreshData = ((rao)localObject).a(this.this$0.a.getApp(), i);
    int j = (int)(System.currentTimeMillis() / 1000L);
    if ((localRefreshData != null) && (localRefreshData.isShowInSource(rbi.a(this.this$0))) && (j >= localRefreshData.beginTime) && (j <= localRefreshData.endTime)) {
      if (rbm.a(localRefreshData.id)) {
        if (localRefreshData.isShown)
        {
          ((rao)localObject).a(1, localRefreshData.id, localRefreshData.seq, i);
          ((rao)localObject).a(true);
        }
      }
    }
    for (;;)
    {
      localObject = (GuideData)((ran)this.this$0.a.getManager(271)).a("operation_guide");
      SkinData localSkinData = ((rau)this.this$0.a.getManager(261)).a(this.this$0.a.getApp());
      ((rar)this.this$0.a.getBusinessHandler(121)).a(localSkinData, null, localRefreshData, (GuideData)localObject, rbi.a(this.this$0));
      return;
      ((rao)localObject).a(0, "", -1L, i);
      continue;
      ((rao)localObject).a(0, "", -1L, i);
      ((rao)localObject).a(localRefreshData, rbi.a(this.this$0));
      continue;
      ((rao)localObject).a(0, "", -1L, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.skin.ReadInjoySkinAndRefreshFacade.1
 * JD-Core Version:    0.7.0.1
 */