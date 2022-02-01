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
    boolean bool = QLog.isColorLevel();
    paramInt = 0;
    if (bool) {
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
      if ((paramBoolean) && ((paramObject instanceof GetConciseThemeRsp)))
      {
        Object localObject1 = (GetConciseThemeRsp)paramObject;
        int i = Integer.decode(SimpleUIUtil.a(SimpleUIUtil.f())).intValue();
        paramObject = SimpleUIUtil.a();
        paramObject.clear();
        SimpleUIChoiceView.a().clear();
        while (paramInt < ((GetConciseThemeRsp)localObject1).vItems.size())
        {
          ItemDisDetail localItemDisDetail = (ItemDisDetail)((GetConciseThemeRsp)localObject1).vItems.get(paramInt);
          Object localObject2 = this.a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localItemDisDetail.itemId);
          localStringBuilder.append("");
          localObject2 = new SimpleUIChoiceView.ColorItemInfo((SimpleUIChoiceView)localObject2, localStringBuilder.toString(), localItemDisDetail.image, paramInt);
          if (i == localItemDisDetail.itemId) {
            ((SimpleUIChoiceView.ColorItemInfo)localObject2).a = true;
          }
          SimpleUIChoiceView.a(this.a, null, (SimpleUIChoiceView.ColorItemInfo)localObject2);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(localItemDisDetail.itemId);
          localStringBuilder.append("");
          paramObject.add(localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(localItemDisDetail.itemId);
          localStringBuilder.append("");
          if (TextUtils.equals("2920", localStringBuilder.toString())) {
            SimpleUIUtil.c = paramInt;
          }
          SimpleUIChoiceView.a().add(localObject2);
          MobileReportManager.getInstance().reportAction(SimpleUIUtil.a(localItemDisDetail.itemId), "4", "platform898", "4", "1", 101, 1, System.currentTimeMillis());
          ReportController.b(SimpleUIChoiceView.a(this.a).app, "dc00898", "", "", "qq_vip", "0X800B15B", Integer.decode(SimpleUIUtil.a(localItemDisDetail.itemId)).intValue(), 0, "", "", "", "");
          paramInt += 1;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append("");
        paramInt = SimpleUIUtil.a(((StringBuilder)localObject1).toString());
        SimpleUIProtocolUtil.a(SimpleUIChoiceView.a(this.a).getCurrentAccountUin(), paramInt, 3);
        SimpleUIChoiceView.a(this.a).a(SimpleUIChoiceView.a());
        SimpleUIChoiceView.a(this.a).notifyDataSetChanged();
        if (paramInt < paramObject.size()) {
          SimpleUIChoiceView.a(this.a).scrollToPosition(paramInt);
        }
      }
      return;
    }
    for (;;)
    {
      throw paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SimpleUIChoiceView.1
 * JD-Core Version:    0.7.0.1
 */