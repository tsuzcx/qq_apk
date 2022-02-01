package com.tencent.avgame.gamelobby.rv;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.avgame.gamelobby.data.AVGameLobbyBannerContentInfo;
import com.tencent.avgame.gamelobby.data.IBaseData;
import com.tencent.avgame.ui.AVGameRoomCenterFragment;
import com.tencent.avgame.ui.AVGameRoomCenterFragment.BannerInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.parser.AVGameShareCreateRoomAction;
import com.tencent.mobileqq.app.parser.AVGameShareCreateRoomParser;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class AVGameLobbyOnClickListenerFactory$1
  implements BaseViewHolder.OnClickListener
{
  AVGameLobbyOnClickListenerFactory$1(AVGameLobbyOnClickListenerFactory paramAVGameLobbyOnClickListenerFactory) {}
  
  public void a(View paramView, IBaseData paramIBaseData, int paramInt)
  {
    if (paramIBaseData == null) {}
    for (;;)
    {
      return;
      paramIBaseData = ((AVGameLobbyBannerContentInfo)paramIBaseData).a();
      if ((paramIBaseData != null) && (paramIBaseData.size() != 0) && (paramInt < paramIBaseData.size()))
      {
        paramView = paramView.getContext();
        paramIBaseData = ((AVGameRoomCenterFragment.BannerInfo)paramIBaseData.get(0)).b;
        if (paramIBaseData != null)
        {
          if (paramIBaseData.startsWith("http"))
          {
            ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B494", "0X800B494", 1, 0, "", "", "", "");
            Intent localIntent = new Intent(paramView, QQBrowserActivity.class);
            localIntent.putExtra("url", paramIBaseData);
            paramView.startActivity(localIntent);
          }
          while (QLog.isColorLevel())
          {
            QLog.d("BannerClick", 2, "Banner click,skipUrl:" + paramIBaseData);
            return;
            if (paramIBaseData.startsWith("mqqapi"))
            {
              ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B494", "0X800B494", 2, 0, "", "", "", "");
              paramView = new AVGameShareCreateRoomParser().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentAvgameUiAVGameRoomCenterFragment.getActivity(), paramIBaseData);
              if ((paramView instanceof AVGameShareCreateRoomAction)) {
                ((AVGameShareCreateRoomAction)paramView).a(4);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.rv.AVGameLobbyOnClickListenerFactory.1
 * JD-Core Version:    0.7.0.1
 */