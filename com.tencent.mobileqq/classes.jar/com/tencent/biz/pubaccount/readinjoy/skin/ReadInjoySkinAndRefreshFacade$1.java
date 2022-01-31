package com.tencent.biz.pubaccount.readinjoy.skin;

import com.tencent.common.app.AppInterface;
import pnc;
import png;
import pnh;
import pnk;
import pnn;
import pob;
import pof;

public class ReadInjoySkinAndRefreshFacade$1
  implements Runnable
{
  public ReadInjoySkinAndRefreshFacade$1(pob parampob) {}
  
  public void run()
  {
    Object localObject = (pnh)this.this$0.a.getManager(270);
    int i = pob.a(this.this$0);
    RefreshData localRefreshData = ((pnh)localObject).a(this.this$0.a.getApp(), i);
    int j = (int)(System.currentTimeMillis() / 1000L);
    boolean bool;
    pnn localpnn;
    SkinData localSkinData;
    if ((localRefreshData != null) && (localRefreshData.isShowInSource(pob.a(this.this$0))) && (j >= localRefreshData.beginTime) && (j <= localRefreshData.endTime)) {
      if (pof.a(localRefreshData.id)) {
        if (localRefreshData.isShown)
        {
          ((pnh)localObject).a(1, localRefreshData.id, localRefreshData.seq, i);
          ((pnh)localObject).a(true);
          bool = true;
          localObject = (GuideData)((png)this.this$0.a.getManager(271)).a("operation_guide");
          localpnn = (pnn)this.this$0.a.getManager(261);
          localSkinData = localpnn.a(this.this$0.a.getApp());
          if ((localSkinData == null) || (j < localSkinData.beginTime) || (j > localSkinData.endTime)) {
            break label361;
          }
          if (!pnc.a(localSkinData.id)) {
            break label341;
          }
          localpnn.a(1, localSkinData.id, bool);
        }
      }
    }
    for (;;)
    {
      ((pnk)this.this$0.a.getBusinessHandler(121)).a(localSkinData, null, localRefreshData, (GuideData)localObject, pob.a(this.this$0));
      return;
      ((pnh)localObject).a(0, "", -1L, i);
      bool = false;
      break;
      ((pnh)localObject).a(0, "", -1L, i);
      ((pnh)localObject).a(localRefreshData, pob.a(this.this$0));
      bool = false;
      break;
      ((pnh)localObject).a(0, "", -1L, i);
      bool = false;
      break;
      label341:
      localpnn.a(0, "", bool);
      localpnn.a(localSkinData);
      continue;
      label361:
      localpnn.a(0, "", bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.skin.ReadInjoySkinAndRefreshFacade.1
 * JD-Core Version:    0.7.0.1
 */