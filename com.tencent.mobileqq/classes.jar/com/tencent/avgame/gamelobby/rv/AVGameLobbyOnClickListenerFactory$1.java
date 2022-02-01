package com.tencent.avgame.gamelobby.rv;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.avgame.gamelobby.IAVGameRoomCenterFragment;
import com.tencent.avgame.gamelobby.data.AVGameLobbyBannerContentInfo;
import com.tencent.avgame.gamelobby.data.AVGameLobbyConstants.BannerInfo;
import com.tencent.avgame.gamelobby.data.IBaseData;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class AVGameLobbyOnClickListenerFactory$1
  implements BaseViewHolder.OnClickListener
{
  AVGameLobbyOnClickListenerFactory$1(AVGameLobbyOnClickListenerFactory paramAVGameLobbyOnClickListenerFactory) {}
  
  public void a(View paramView, IBaseData paramIBaseData, int paramInt)
  {
    if (paramIBaseData == null) {
      return;
    }
    paramIBaseData = ((AVGameLobbyBannerContentInfo)paramIBaseData).b();
    if ((paramIBaseData != null) && (paramIBaseData.size() != 0))
    {
      if (paramInt >= paramIBaseData.size()) {
        return;
      }
      paramView = paramView.getContext();
      paramIBaseData = ((AVGameLobbyConstants.BannerInfo)paramIBaseData.get(0)).b;
      if (paramIBaseData == null) {
        return;
      }
      if (paramIBaseData.startsWith("http"))
      {
        ReportController.b(this.a.b, "dc00898", "", "", "0X800B494", "0X800B494", 1, 0, "", "", "", "");
        Intent localIntent = new Intent(paramView, QQBrowserActivity.class);
        localIntent.putExtra("url", paramIBaseData);
        paramView.startActivity(localIntent);
        paramView = paramIBaseData;
      }
      else
      {
        paramView = paramIBaseData;
        if (paramIBaseData.startsWith("mqqapi"))
        {
          ReportController.b(this.a.b, "dc00898", "", "", "0X800B494", "0X800B494", 2, 0, "", "", "", "");
          paramView = AVGameLobbyOnClickListenerFactory.a(this.a, paramIBaseData);
          this.a.a.a(paramView);
        }
      }
      if (QLog.isColorLevel())
      {
        paramIBaseData = new StringBuilder();
        paramIBaseData.append("Banner click,skipUrl:");
        paramIBaseData.append(paramView);
        QLog.d("BannerClick", 2, paramIBaseData.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.rv.AVGameLobbyOnClickListenerFactory.1
 * JD-Core Version:    0.7.0.1
 */