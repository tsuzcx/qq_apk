package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.utils.QCircleToastUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudMeta.StUser;
import qqcircle.QQCircleProfile.SetProfileRsp;

class QCircleDataEditContentPart$2
  implements Observer<UIStateData<QQCircleProfile.SetProfileRsp>>
{
  QCircleDataEditContentPart$2(QCircleDataEditContentPart paramQCircleDataEditContentPart) {}
  
  public void a(@Nullable UIStateData<QQCircleProfile.SetProfileRsp> paramUIStateData)
  {
    if ((paramUIStateData != null) && (paramUIStateData.c() == 3) && (QCircleDataEditContentPart.b(this.a) != null))
    {
      paramUIStateData = new Intent();
      paramUIStateData.setAction("action_reload_get_main_page");
      paramUIStateData.putExtra("uin", QCircleDataEditContentPart.b(this.a).id.get());
      if (this.a.c() != null)
      {
        this.a.c().sendBroadcast(paramUIStateData);
        this.a.c().finish();
      }
    }
    else if ((paramUIStateData != null) && (paramUIStateData.c() == 4))
    {
      String str;
      if (paramUIStateData.f() == null) {
        str = HardCodeUtil.a(2131895632);
      } else {
        str = paramUIStateData.f();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onChanged() return error！errMsg:");
      localStringBuilder.append(str);
      QLog.e("QCircleDataEditContentP", 1, localStringBuilder.toString());
      QCircleToastUtil.a(paramUIStateData.g(), QCircleToast.c, str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleDataEditContentPart.2
 * JD-Core Version:    0.7.0.1
 */