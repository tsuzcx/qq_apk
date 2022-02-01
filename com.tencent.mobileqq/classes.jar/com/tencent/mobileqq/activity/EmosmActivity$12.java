package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.view.DragSortAdapter;
import com.tencent.mobileqq.emosm.view.DragSortListView.DropListener;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.statistics.ReportController;

class EmosmActivity$12
  implements DragSortListView.DropListener
{
  EmosmActivity$12(EmosmActivity paramEmosmActivity) {}
  
  public void a_(int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2)
    {
      Object localObject = (EmoticonPackage)this.a.mAdapter.getItem(paramInt1);
      this.a.mAdapter.a(localObject);
      this.a.mAdapter.b(true);
      this.a.mAdapter.a(localObject, paramInt2);
      EmojiListenerManager.a().a((EmoticonPackage)localObject, paramInt1, paramInt2);
      localObject = this.a;
      ((EmosmActivity)localObject).mIsChange = true;
      ReportController.b(((EmosmActivity)localObject).app, "CliOper", "", "", "EmosSetting", "EpMove", 0, 0, "", "", "", "");
      if (this.a.mLaunchMode == 1)
      {
        ReportController.b(this.a.app, "dc00898", "", "", "0X800AB10", "0X800AB10", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(this.a.app, "dc00898", "", "", "0X800AB18", "0X800AB18", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EmosmActivity.12
 * JD-Core Version:    0.7.0.1
 */