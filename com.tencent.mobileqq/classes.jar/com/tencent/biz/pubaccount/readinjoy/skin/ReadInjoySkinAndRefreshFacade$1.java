package com.tencent.biz.pubaccount.readinjoy.skin;

import com.tencent.common.app.AppInterface;
import rcs;
import rcw;
import rcx;
import rda;
import rdd;
import rdr;
import rdv;

public class ReadInjoySkinAndRefreshFacade$1
  implements Runnable
{
  public ReadInjoySkinAndRefreshFacade$1(rdr paramrdr) {}
  
  public void run()
  {
    Object localObject = (rcx)this.this$0.a.getManager(270);
    int i = rdr.a(this.this$0);
    RefreshData localRefreshData = ((rcx)localObject).a(this.this$0.a.getApp(), i);
    int j = (int)(System.currentTimeMillis() / 1000L);
    boolean bool;
    rdd localrdd;
    SkinData localSkinData;
    if ((localRefreshData != null) && (localRefreshData.isShowInSource(rdr.a(this.this$0))) && (j >= localRefreshData.beginTime) && (j <= localRefreshData.endTime)) {
      if (rdv.a(localRefreshData.id)) {
        if (localRefreshData.isShown)
        {
          ((rcx)localObject).a(1, localRefreshData.id, localRefreshData.seq, i);
          ((rcx)localObject).a(true);
          bool = true;
          localObject = (GuideData)((rcw)this.this$0.a.getManager(271)).a("operation_guide");
          localrdd = (rdd)this.this$0.a.getManager(261);
          localSkinData = localrdd.a(this.this$0.a.getApp());
          if ((localSkinData == null) || (j < localSkinData.beginTime) || (j > localSkinData.endTime)) {
            break label361;
          }
          if (!rcs.a(localSkinData.id)) {
            break label341;
          }
          localrdd.a(1, localSkinData.id, bool);
        }
      }
    }
    for (;;)
    {
      ((rda)this.this$0.a.getBusinessHandler(121)).a(localSkinData, null, localRefreshData, (GuideData)localObject, rdr.a(this.this$0));
      return;
      ((rcx)localObject).a(0, "", -1L, i);
      bool = false;
      break;
      ((rcx)localObject).a(0, "", -1L, i);
      ((rcx)localObject).a(localRefreshData, rdr.a(this.this$0));
      bool = false;
      break;
      ((rcx)localObject).a(0, "", -1L, i);
      bool = false;
      break;
      label341:
      localrdd.a(0, "", bool);
      localrdd.a(localSkinData);
      continue;
      label361:
      localrdd.a(0, "", bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.skin.ReadInjoySkinAndRefreshFacade.1
 * JD-Core Version:    0.7.0.1
 */