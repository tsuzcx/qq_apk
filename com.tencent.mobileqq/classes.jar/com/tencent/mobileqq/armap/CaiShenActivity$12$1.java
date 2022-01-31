package com.tencent.mobileqq.armap;

import com.tencent.mobileqq.armap.map.ARGridMapViewDialog;
import com.tencent.mobileqq.armap.map.ARGridMapViewDialog.OpenBoxExtraData;

class CaiShenActivity$12$1
  implements Runnable
{
  CaiShenActivity$12$1(CaiShenActivity.12 param12, ItemInfo paramItemInfo) {}
  
  public void run()
  {
    if (!this.this$1.this$0.isFinishing())
    {
      Object localObject = new ARGridMapViewDialog.OpenBoxExtraData(CaiShenActivity.access$200(this.this$1.this$0), CaiShenActivity.access$1000(this.this$1.this$0), this.val$itemInfo);
      localObject = new ARGridMapViewDialog(this.this$1.this$0, this.this$1.this$0.app, null, 0, 0, 1, localObject, false);
      ((ARGridMapViewDialog)localObject).show();
      ((ARGridMapViewDialog)localObject).setOnDismissListener(new CaiShenActivity.12.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.CaiShenActivity.12.1
 * JD-Core Version:    0.7.0.1
 */