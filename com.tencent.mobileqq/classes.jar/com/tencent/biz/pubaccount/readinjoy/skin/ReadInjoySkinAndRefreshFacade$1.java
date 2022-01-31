package com.tencent.biz.pubaccount.readinjoy.skin;

import com.tencent.common.app.AppInterface;
import pyx;
import pzb;
import pzc;
import pzf;
import pzi;
import pzw;
import qaa;

public class ReadInjoySkinAndRefreshFacade$1
  implements Runnable
{
  public ReadInjoySkinAndRefreshFacade$1(pzw parampzw) {}
  
  public void run()
  {
    Object localObject = (pzc)this.this$0.a.getManager(270);
    int i = pzw.a(this.this$0);
    RefreshData localRefreshData = ((pzc)localObject).a(this.this$0.a.getApp(), i);
    int j = (int)(System.currentTimeMillis() / 1000L);
    boolean bool;
    pzi localpzi;
    SkinData localSkinData;
    if ((localRefreshData != null) && (localRefreshData.isShowInSource(pzw.a(this.this$0))) && (j >= localRefreshData.beginTime) && (j <= localRefreshData.endTime)) {
      if (qaa.a(localRefreshData.id)) {
        if (localRefreshData.isShown)
        {
          ((pzc)localObject).a(1, localRefreshData.id, localRefreshData.seq, i);
          ((pzc)localObject).a(true);
          bool = true;
          localObject = (GuideData)((pzb)this.this$0.a.getManager(271)).a("operation_guide");
          localpzi = (pzi)this.this$0.a.getManager(261);
          localSkinData = localpzi.a(this.this$0.a.getApp());
          if ((localSkinData == null) || (j < localSkinData.beginTime) || (j > localSkinData.endTime)) {
            break label361;
          }
          if (!pyx.a(localSkinData.id)) {
            break label341;
          }
          localpzi.a(1, localSkinData.id, bool);
        }
      }
    }
    for (;;)
    {
      ((pzf)this.this$0.a.getBusinessHandler(121)).a(localSkinData, null, localRefreshData, (GuideData)localObject, pzw.a(this.this$0));
      return;
      ((pzc)localObject).a(0, "", -1L, i);
      bool = false;
      break;
      ((pzc)localObject).a(0, "", -1L, i);
      ((pzc)localObject).a(localRefreshData, pzw.a(this.this$0));
      bool = false;
      break;
      ((pzc)localObject).a(0, "", -1L, i);
      bool = false;
      break;
      label341:
      localpzi.a(0, "", bool);
      localpzi.a(localSkinData);
      continue;
      label361:
      localpzi.a(0, "", bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.skin.ReadInjoySkinAndRefreshFacade.1
 * JD-Core Version:    0.7.0.1
 */