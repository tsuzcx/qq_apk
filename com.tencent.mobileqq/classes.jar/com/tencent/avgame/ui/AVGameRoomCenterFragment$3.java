package com.tencent.avgame.ui;

import com.tencent.avgame.business.observer.AvGameRoomListObserver;
import com.tencent.avgame.gamelobby.data.AVGameBaseData;
import com.tencent.avgame.gamelobby.data.AVGameLobbyBannerContentInfo;
import com.tencent.avgame.gamelobby.data.AVGameLobbyCommonContentInfo;
import com.tencent.avgame.gamelobby.data.AVGameLobbyConstants.BannerInfo;
import com.tencent.avgame.gamelobby.data.AVGameLobbyConstants.RandomMatchInfo;
import com.tencent.avgame.gamelobby.data.AVGameLobbyDataSource;
import com.tencent.avgame.gamelobby.data.AVGameLobbyFixedContentInfo;
import com.tencent.avgame.gamelobby.data.AVGameLobbyRandomMatchContentInfo;
import com.tencent.avgame.gamelobby.data.AVGameLobbySurvivalContentInfo;
import com.tencent.avgame.gamelobby.data.AVGameLobbyTitleContentInfo;
import com.tencent.avgame.gamelobby.rv.BaseAdapter;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class AVGameRoomCenterFragment$3
  extends AvGameRoomListObserver
{
  AVGameRoomCenterFragment$3(AVGameRoomCenterFragment paramAVGameRoomCenterFragment) {}
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvGameRoomListObserver", 2, "onPkProcessRestart");
    }
    AVGameRoomCenterFragment.a(this.a, true);
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      paramString = AVGameRoomCenterFragment.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReservePKGame mObserver get isSuc : ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" errorCode: ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" pkId: ");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.d(paramString, 2, ((StringBuilder)localObject).toString());
    }
    paramString = AVGameRoomCenterFragment.a(this.a, paramInt1);
    if (paramString == null) {
      return;
    }
    if (paramBoolean)
    {
      paramString.a(paramString.i() ^ true);
      if (paramString.i())
      {
        localObject = this.a;
        AVGameRoomCenterFragment.a((AVGameRoomCenterFragment)localObject, ((AVGameRoomCenterFragment)localObject).getString(2131887340), this.a.getString(2131887339), this.a.getString(2131887410), new AVGameRoomCenterFragment.3.1(this), null, null);
      }
    }
    paramString.b(true);
    AVGameRoomCenterFragment.e(this.a).notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean, long paramLong, List<AVGameLobbyConstants.BannerInfo> paramList, AVGameLobbyConstants.RandomMatchInfo paramRandomMatchInfo, List<AVGameLobbySurvivalContentInfo> paramList1, List<AVGameLobbyCommonContentInfo> paramList2, List<AVGameLobbyRandomMatchContentInfo> paramList3, int paramInt, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      String str = AVGameRoomCenterFragment.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGameLobbyInfo mObserver get isSuc : ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("errorCode: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" uin: ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" bannerlist size:");
      localObject = "";
      if (paramList != null) {
        paramString = Integer.valueOf(paramList.size());
      } else {
        paramString = "";
      }
      localStringBuilder.append(paramString);
      localStringBuilder.append(" commonList size: ");
      if (paramList2 != null) {
        paramString = Integer.valueOf(paramList2.size());
      } else {
        paramString = "";
      }
      localStringBuilder.append(paramString);
      localStringBuilder.append(" newRandomMatchList size:");
      if (paramList3 != null) {
        paramString = Integer.valueOf(paramList3.size());
      } else {
        paramString = "";
      }
      localStringBuilder.append(paramString);
      localStringBuilder.append(" pkCardInfos size:");
      paramString = (String)localObject;
      if (paramList1 != null) {
        paramString = Integer.valueOf(paramList1.size());
      }
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (!paramBoolean) {
      return;
    }
    AVGameRoomCenterFragment.b(this.a).d();
    AVGameRoomCenterFragment.b(this.a).b();
    if ((paramList == null) || (paramList.size() == 0)) {
      AVGameRoomCenterFragment.c(this.a);
    }
    int j = 0;
    paramInt = 0;
    int i;
    while (paramInt < AVGameRoomCenterFragment.b(this.a).a())
    {
      if (AVGameRoomCenterFragment.b(this.a).a(paramInt) != null)
      {
        i = AVGameRoomCenterFragment.b(this.a).a(paramInt).a();
        if (i != 0)
        {
          if (i == 1)
          {
            paramString = (AVGameLobbyFixedContentInfo)AVGameRoomCenterFragment.b(this.a).b(paramInt);
            if ((paramString != null) && (paramRandomMatchInfo != null))
            {
              paramString.a(paramRandomMatchInfo.a);
              localObject = new String[paramRandomMatchInfo.b.size()];
              i = 0;
              while (i < paramRandomMatchInfo.b.size())
              {
                localObject[i] = ((Long)paramRandomMatchInfo.b.get(i)).toString();
                i += 1;
              }
              paramString.a((String[])localObject);
            }
          }
        }
        else
        {
          paramString = (AVGameLobbyBannerContentInfo)AVGameRoomCenterFragment.b(this.a).b(paramInt);
          if (paramString != null) {
            paramString.a(paramList);
          }
        }
      }
      paramInt += 1;
    }
    if ((!AVGameRoomCenterFragment.d(this.a)) && (((paramList1 != null) && (paramList1.size() != 0)) || ((paramList2 != null) && (paramList2.size() != 0)))) {
      AVGameRoomCenterFragment.b(this.a).a(new AVGameLobbyTitleContentInfo(6, 1));
    }
    if ((paramList1 != null) && (paramList1.size() != 0))
    {
      if (AVGameRoomCenterFragment.d(this.a)) {
        AVGameRoomCenterFragment.b(this.a).a(paramList1, 1);
      } else {
        AVGameRoomCenterFragment.b(this.a).a(paramList1);
      }
      paramInt = 0;
      while (paramInt < paramList1.size())
      {
        if (((AVGameLobbySurvivalContentInfo)paramList1.get(paramInt)).t()) {
          ReportController.b(AVGameRoomCenterFragment.a(this.a).getAppRuntime(), "dc00898", "", "", "survival_main_exp", "survival_main_exp", 0, 0, "", "", "", String.valueOf(((AVGameLobbySurvivalContentInfo)paramList1.get(paramInt)).f()));
        }
        ReportController.b(AVGameRoomCenterFragment.a(this.a).getAppRuntime(), "dc00898", "", "", "0X800B68F", "0X800B68F", 0, 0, "", "", "", "");
        paramInt += 1;
      }
    }
    if ((!AVGameRoomCenterFragment.d(this.a)) && (paramList2 != null) && (paramList2.size() != 0)) {
      AVGameRoomCenterFragment.b(this.a).a(paramList2);
    }
    if ((!AVGameRoomCenterFragment.d(this.a)) && (paramList3 != null) && (paramList3.size() != 0))
    {
      AVGameRoomCenterFragment.b(this.a).a(new AVGameLobbyTitleContentInfo(6, 0));
      paramInt = j;
      while (paramInt < paramList3.size())
      {
        i = ((AVGameLobbyRandomMatchContentInfo)paramList3.get(paramInt)).c;
        ReportController.b(AVGameRoomCenterFragment.a(this.a).getAppRuntime(), "dc00898", "", "", "0X800B49E", "0X800B49E", 0, 0, String.valueOf(i), "2", "", "");
        paramInt += 1;
      }
      AVGameRoomCenterFragment.b(this.a).a(paramList3);
    }
    AVGameRoomCenterFragment.b(this.a).c();
    AVGameRoomCenterFragment.e(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameRoomCenterFragment.3
 * JD-Core Version:    0.7.0.1
 */