package com.tencent.avgame.gamelobby.rv;

import android.view.View;
import com.tencent.avgame.gamelobby.IAVGameRoomCenterFragment;
import com.tencent.avgame.gamelobby.data.AVGameLobbySurvivalContentInfo;
import com.tencent.avgame.gamelobby.data.IBaseData;
import com.tencent.avgame.qav.AsyncExitTask;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class AVGameLobbyOnClickListenerFactory$3
  implements BaseViewHolder.OnClickListener
{
  AVGameLobbyOnClickListenerFactory$3(AVGameLobbyOnClickListenerFactory paramAVGameLobbyOnClickListenerFactory) {}
  
  public void a(View paramView, IBaseData paramIBaseData, int paramInt)
  {
    if (paramIBaseData == null) {
      return;
    }
    if (AsyncExitTask.b())
    {
      QQToast.makeText(this.a.b.getApplicationContext(), 2131887337, 0).show();
      return;
    }
    paramIBaseData = (AVGameLobbySurvivalContentInfo)paramIBaseData;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getTimeType is ");
    localStringBuilder.append(paramIBaseData.d());
    QLog.d("AVGameLobbyOnClickListenerFactory", 2, localStringBuilder.toString());
    if (paramView.getId() == 2131429110)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVGameLobbyOnClickListenerFactory", 2, "reserve button click");
      }
      if (paramIBaseData.i()) {
        return;
      }
      if (this.a.a.e())
      {
        this.a.a.a(paramIBaseData.f(), paramIBaseData.i() ^ true);
        paramIBaseData.b(false);
        paramView.setClickable(false);
        ReportController.b(this.a.b, "dc00898", "", "", "0X800B690", "0X800B690", 0, 0, "", "", "", "");
        return;
      }
      this.a.a.b(paramIBaseData.f());
      this.a.a.f();
      return;
    }
    if (paramIBaseData.d() == 3)
    {
      if (paramIBaseData.t()) {
        this.a.a.a(paramIBaseData.i(), paramIBaseData.f());
      }
      this.a.a.c(paramIBaseData.f(), paramIBaseData.t());
      if (QLog.isColorLevel()) {
        QLog.d("AVGameLobbyOnClickListenerFactory", 2, "reserve item click");
      }
    }
    else
    {
      if (paramIBaseData.t()) {
        this.a.a.a(paramIBaseData.i(), paramIBaseData.f());
      }
      QQToast.makeText(this.a.b.getApplicationContext(), 0, 2131887341, 0).show();
      if (QLog.isColorLevel()) {
        QLog.d("AVGameLobbyOnClickListenerFactory", 2, "reserve item click err");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.rv.AVGameLobbyOnClickListenerFactory.3
 * JD-Core Version:    0.7.0.1
 */