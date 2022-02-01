package com.tencent.biz.pubaccount.readinjoy.skin;

import com.tencent.common.app.AppInterface;
import qtp;
import qtq;
import qtt;
import qtw;
import quk;
import quo;

public class ReadInjoySkinAndRefreshFacade$1
  implements Runnable
{
  public ReadInjoySkinAndRefreshFacade$1(quk paramquk) {}
  
  public void run()
  {
    Object localObject = (qtq)this.this$0.a.getManager(270);
    int i = quk.a(this.this$0);
    RefreshData localRefreshData = ((qtq)localObject).a(this.this$0.a.getApp(), i);
    int j = (int)(System.currentTimeMillis() / 1000L);
    if ((localRefreshData != null) && (localRefreshData.isShowInSource(quk.a(this.this$0))) && (j >= localRefreshData.beginTime) && (j <= localRefreshData.endTime)) {
      if (quo.a(localRefreshData.id)) {
        if (localRefreshData.isShown)
        {
          ((qtq)localObject).a(1, localRefreshData.id, localRefreshData.seq, i);
          ((qtq)localObject).a(true);
        }
      }
    }
    for (;;)
    {
      localObject = (GuideData)((qtp)this.this$0.a.getManager(271)).a("operation_guide");
      SkinData localSkinData = ((qtw)this.this$0.a.getManager(261)).a(this.this$0.a.getApp());
      ((qtt)this.this$0.a.getBusinessHandler(121)).a(localSkinData, null, localRefreshData, (GuideData)localObject, quk.a(this.this$0));
      return;
      ((qtq)localObject).a(0, "", -1L, i);
      continue;
      ((qtq)localObject).a(0, "", -1L, i);
      ((qtq)localObject).a(localRefreshData, quk.a(this.this$0));
      continue;
      ((qtq)localObject).a(0, "", -1L, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.skin.ReadInjoySkinAndRefreshFacade.1
 * JD-Core Version:    0.7.0.1
 */