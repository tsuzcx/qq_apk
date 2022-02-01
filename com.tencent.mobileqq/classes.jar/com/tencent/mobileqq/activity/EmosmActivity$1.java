package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.EmoticonObserver;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class EmosmActivity$1
  extends EmoticonObserver
{
  EmosmActivity$1(EmosmActivity paramEmosmActivity) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 1)
    {
      if (paramBoolean)
      {
        paramObject = (EmoticonResp)paramObject;
        this.a.updatePackageStatus(paramObject.delEpId);
      }
      else
      {
        this.a.showAuthErrorTips();
        EmosmActivity.access$000(this.a, (EmoticonResp)paramObject);
      }
      this.a.dismissDialog();
      this.a.mListView.e();
      return;
    }
    if (paramInt == 2)
    {
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("emoticon fetch:");
        paramObject.append(paramBoolean);
        QLog.i("EmosmActivity", 2, paramObject.toString());
      }
      if (paramBoolean)
      {
        paramObject = this.a;
        paramObject.runOnUiThread(paramObject.mRefreshTask);
      }
    }
    else if (paramInt == 17)
    {
      if (paramBoolean)
      {
        paramObject = ((EmoticonResp)paramObject).ids.iterator();
        while (paramObject.hasNext())
        {
          Integer localInteger = (Integer)paramObject.next();
          this.a.updatePackageStatus(localInteger.intValue());
        }
      }
      this.a.showAuthErrorTips();
      EmosmActivity.access$000(this.a, (EmoticonResp)paramObject);
      this.a.dismissDialog();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EmosmActivity.1
 * JD-Core Version:    0.7.0.1
 */