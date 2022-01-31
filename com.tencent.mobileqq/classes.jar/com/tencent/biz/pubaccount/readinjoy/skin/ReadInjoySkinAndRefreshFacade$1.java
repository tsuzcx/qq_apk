package com.tencent.biz.pubaccount.readinjoy.skin;

import com.tencent.common.app.AppInterface;
import qip;
import qit;
import qiu;
import qix;
import qja;
import qjo;
import qjs;

public class ReadInjoySkinAndRefreshFacade$1
  implements Runnable
{
  public ReadInjoySkinAndRefreshFacade$1(qjo paramqjo) {}
  
  public void run()
  {
    Object localObject = (qiu)this.this$0.a.getManager(270);
    int i = qjo.a(this.this$0);
    RefreshData localRefreshData = ((qiu)localObject).a(this.this$0.a.getApp(), i);
    int j = (int)(System.currentTimeMillis() / 1000L);
    boolean bool;
    qja localqja;
    SkinData localSkinData;
    if ((localRefreshData != null) && (localRefreshData.isShowInSource(qjo.a(this.this$0))) && (j >= localRefreshData.beginTime) && (j <= localRefreshData.endTime)) {
      if (qjs.a(localRefreshData.id)) {
        if (localRefreshData.isShown)
        {
          ((qiu)localObject).a(1, localRefreshData.id, localRefreshData.seq, i);
          ((qiu)localObject).a(true);
          bool = true;
          localObject = (GuideData)((qit)this.this$0.a.getManager(271)).a("operation_guide");
          localqja = (qja)this.this$0.a.getManager(261);
          localSkinData = localqja.a(this.this$0.a.getApp());
          if ((localSkinData == null) || (j < localSkinData.beginTime) || (j > localSkinData.endTime)) {
            break label361;
          }
          if (!qip.a(localSkinData.id)) {
            break label341;
          }
          localqja.a(1, localSkinData.id, bool);
        }
      }
    }
    for (;;)
    {
      ((qix)this.this$0.a.getBusinessHandler(121)).a(localSkinData, null, localRefreshData, (GuideData)localObject, qjo.a(this.this$0));
      return;
      ((qiu)localObject).a(0, "", -1L, i);
      bool = false;
      break;
      ((qiu)localObject).a(0, "", -1L, i);
      ((qiu)localObject).a(localRefreshData, qjo.a(this.this$0));
      bool = false;
      break;
      ((qiu)localObject).a(0, "", -1L, i);
      bool = false;
      break;
      label341:
      localqja.a(0, "", bool);
      localqja.a(localSkinData);
      continue;
      label361:
      localqja.a(0, "", bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.skin.ReadInjoySkinAndRefreshFacade.1
 * JD-Core Version:    0.7.0.1
 */