package com.tencent.mobileqq.activity;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.emosm.view.DragSortListView.RemoveListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

class EmosmActivity$13
  implements DragSortListView.RemoveListener
{
  EmosmActivity$13(EmosmActivity paramEmosmActivity) {}
  
  public void a(int paramInt)
  {
    paramInt -= this.a.mListView.getHeaderViewsCount();
    if (paramInt < 0) {
      return;
    }
    Object localObject = (EmoticonPackage)this.a.mEPDatas.get(paramInt);
    if (!NetworkUtil.isNetSupport(this.a))
    {
      localObject = new QQToast(this.a);
      ((QQToast)localObject).setToastIcon(2130839752);
      ((QQToast)localObject).setDuration(1500);
      ((QQToast)localObject).setToastMsg(HardCodeUtil.a(2131902071));
      ((QQToast)localObject).show(0);
      return;
    }
    this.a.progressDialog.a(this.a.getString(2131888895));
    this.a.progressDialog.show();
    ((EmoticonHandler)this.a.app.getBusinessHandler(EmoticonHandler.a)).a(Integer.parseInt(((EmoticonPackage)localObject).epId));
    URLDrawable.clearMemoryCache();
    if (this.a.mLaunchMode == 1)
    {
      ReportController.b(this.a.app, "dc00898", "", "", "0X800AB12", "0X800AB12", 1, 0, "", "", "", "");
      return;
    }
    ReportController.b(this.a.app, "dc00898", "", "", "0X800AB15", "0X800AB15", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EmosmActivity.13
 * JD-Core Version:    0.7.0.1
 */