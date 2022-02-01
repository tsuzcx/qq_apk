package com.tencent.mobileqq.activity;

import QC.GetConciseThemeRsp;
import QC.ItemDisDetail;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.simpleui.SimpleUIProtocolUtil;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.ArrayList;
import java.util.List;

class SimpleUIChoiceView$1
  implements BusinessObserver
{
  SimpleUIChoiceView$1(SimpleUIChoiceView paramSimpleUIChoiceView) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleUIChoiceView", 1, new Object[] { "loadSimpleThemeListData isSuccess: ", Boolean.valueOf(paramBoolean) });
    }
    if (SimpleUIChoiceView.a() == null) {
      return;
    }
    synchronized (SimpleUIChoiceView.a())
    {
      if (SimpleUIChoiceView.a() == null) {
        return;
      }
    }
    if ((paramBoolean) && ((paramObject instanceof GetConciseThemeRsp)))
    {
      paramObject = (GetConciseThemeRsp)paramObject;
      int i = Integer.decode(SimpleUIUtil.a(SimpleUIUtil.f())).intValue();
      List localList2 = SimpleUIUtil.a();
      localList2.clear();
      SimpleUIChoiceView.a().clear();
      paramInt = 0;
      while (paramInt < paramObject.vItems.size())
      {
        ItemDisDetail localItemDisDetail = (ItemDisDetail)paramObject.vItems.get(paramInt);
        SimpleUIChoiceView.ColorItemInfo localColorItemInfo = new SimpleUIChoiceView.ColorItemInfo(this.a, localItemDisDetail.itemId + "", localItemDisDetail.image, paramInt);
        if (i == localItemDisDetail.itemId) {
          localColorItemInfo.a = true;
        }
        SimpleUIChoiceView.a(this.a, null, localColorItemInfo);
        localList2.add(localItemDisDetail.itemId + "");
        if (TextUtils.equals("2920", localItemDisDetail.itemId + "")) {
          SimpleUIUtil.c = paramInt;
        }
        SimpleUIChoiceView.a().add(localColorItemInfo);
        MobileReportManager.getInstance().reportAction(SimpleUIUtil.a(localItemDisDetail.itemId), "4", "platform898", "4", "1", 101, 1, System.currentTimeMillis());
        ReportController.b(SimpleUIChoiceView.a(this.a).app, "dc00898", "", "", "qq_vip", "0X800B15B", Integer.decode(SimpleUIUtil.a(localItemDisDetail.itemId)).intValue(), 0, "", "", "", "");
        paramInt += 1;
      }
      paramInt = SimpleUIUtil.a(i + "");
      SimpleUIProtocolUtil.a(SimpleUIChoiceView.a(this.a).getCurrentAccountUin(), paramInt, 3);
      SimpleUIChoiceView.a(this.a).a(SimpleUIChoiceView.a());
      SimpleUIChoiceView.a(this.a).notifyDataSetChanged();
      if (paramInt < localList2.size()) {
        SimpleUIChoiceView.a(this.a).scrollToPosition(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SimpleUIChoiceView.1
 * JD-Core Version:    0.7.0.1
 */