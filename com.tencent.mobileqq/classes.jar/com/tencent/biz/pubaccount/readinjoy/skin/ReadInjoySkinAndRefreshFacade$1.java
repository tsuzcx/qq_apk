package com.tencent.biz.pubaccount.readinjoy.skin;

import com.tencent.common.app.AppInterface;
import pyu;
import pyy;
import pyz;
import pzc;
import pzf;
import pzt;
import pzx;

public class ReadInjoySkinAndRefreshFacade$1
  implements Runnable
{
  public ReadInjoySkinAndRefreshFacade$1(pzt parampzt) {}
  
  public void run()
  {
    Object localObject = (pyz)this.this$0.a.getManager(270);
    int i = pzt.a(this.this$0);
    RefreshData localRefreshData = ((pyz)localObject).a(this.this$0.a.getApp(), i);
    int j = (int)(System.currentTimeMillis() / 1000L);
    boolean bool;
    pzf localpzf;
    SkinData localSkinData;
    if ((localRefreshData != null) && (localRefreshData.isShowInSource(pzt.a(this.this$0))) && (j >= localRefreshData.beginTime) && (j <= localRefreshData.endTime)) {
      if (pzx.a(localRefreshData.id)) {
        if (localRefreshData.isShown)
        {
          ((pyz)localObject).a(1, localRefreshData.id, localRefreshData.seq, i);
          ((pyz)localObject).a(true);
          bool = true;
          localObject = (GuideData)((pyy)this.this$0.a.getManager(271)).a("operation_guide");
          localpzf = (pzf)this.this$0.a.getManager(261);
          localSkinData = localpzf.a(this.this$0.a.getApp());
          if ((localSkinData == null) || (j < localSkinData.beginTime) || (j > localSkinData.endTime)) {
            break label361;
          }
          if (!pyu.a(localSkinData.id)) {
            break label341;
          }
          localpzf.a(1, localSkinData.id, bool);
        }
      }
    }
    for (;;)
    {
      ((pzc)this.this$0.a.getBusinessHandler(121)).a(localSkinData, null, localRefreshData, (GuideData)localObject, pzt.a(this.this$0));
      return;
      ((pyz)localObject).a(0, "", -1L, i);
      bool = false;
      break;
      ((pyz)localObject).a(0, "", -1L, i);
      ((pyz)localObject).a(localRefreshData, pzt.a(this.this$0));
      bool = false;
      break;
      ((pyz)localObject).a(0, "", -1L, i);
      bool = false;
      break;
      label341:
      localpzf.a(0, "", bool);
      localpzf.a(localSkinData);
      continue;
      label361:
      localpzf.a(0, "", bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.skin.ReadInjoySkinAndRefreshFacade.1
 * JD-Core Version:    0.7.0.1
 */