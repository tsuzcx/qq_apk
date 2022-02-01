package com.tencent.avgame.ui;

import android.support.v4.app.FragmentActivity;
import com.tencent.avgame.business.observer.AvGameRoomListObserver;
import com.tencent.avgame.gamelobby.data.AVGameBaseData;
import com.tencent.avgame.gamelobby.data.AVGameLobbyBannerContentInfo;
import com.tencent.avgame.gamelobby.data.AVGameLobbyCommonContentInfo;
import com.tencent.avgame.gamelobby.data.AVGameLobbyDataSource;
import com.tencent.avgame.gamelobby.data.AVGameLobbyFixedContentInfo;
import com.tencent.avgame.gamelobby.data.AVGameLobbyRandomMatchContentInfo;
import com.tencent.avgame.gamelobby.data.AVGameLobbySurvivalContentInfo;
import com.tencent.avgame.gamelobby.data.AVGameLobbyTitleContentInfo;
import com.tencent.avgame.gamelobby.rv.BaseAdapter;
import com.tencent.avgame.gameroom.festivalreport.CJSurvivalFestivalReporter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class AVGameRoomCenterFragment$3
  extends AvGameRoomListObserver
{
  AVGameRoomCenterFragment$3(AVGameRoomCenterFragment paramAVGameRoomCenterFragment) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvGameRoomListObserver", 2, "onPkProcessRestart");
    }
    AVGameRoomCenterFragment.a(this.a, true);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(AVGameRoomCenterFragment.a, 2, "onReservePKGame mObserver get isSuc : " + paramBoolean + " errorCode: " + paramInt2 + " pkId: " + paramInt1);
    }
    paramString = AVGameRoomCenterFragment.a(this.a, paramInt1);
    if (paramString == null) {
      return;
    }
    if (paramBoolean) {
      if (paramString.b()) {
        break label155;
      }
    }
    label155:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramString.a(paramBoolean);
      if (paramString.b()) {
        AVGameRoomCenterFragment.a(this.a, this.a.getString(2131690504), this.a.getString(2131690503), this.a.getString(2131690571), new AVGameRoomCenterFragment.3.1(this), null, null);
      }
      paramString.b(true);
      AVGameRoomCenterFragment.a(this.a).notifyDataSetChanged();
      return;
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, List<AVGameRoomCenterFragment.BannerInfo> paramList, AVGameRoomCenterFragment.RandomMatchInfo paramRandomMatchInfo, List<AVGameLobbySurvivalContentInfo> paramList1, List<AVGameLobbyCommonContentInfo> paramList2, List<AVGameLobbyRandomMatchContentInfo> paramList3, int paramInt, String paramString)
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = AVGameRoomCenterFragment.a;
      localStringBuilder = new StringBuilder().append("onGameLobbyInfo mObserver get isSuc : ").append(paramBoolean).append("errorCode: ").append(paramInt).append(" uin: ").append(paramLong).append(" bannerlist size:");
      if (paramList == null) {
        break label184;
      }
      paramString = Integer.valueOf(paramList.size());
      localStringBuilder = localStringBuilder.append(paramString).append(" commonList size: ");
      if (paramList2 == null) {
        break label191;
      }
      paramString = Integer.valueOf(paramList2.size());
      label101:
      localStringBuilder = localStringBuilder.append(paramString).append(" newRandomMatchList size:");
      if (paramList3 == null) {
        break label198;
      }
      paramString = Integer.valueOf(paramList3.size());
      label132:
      localStringBuilder = localStringBuilder.append(paramString).append(" pkCardInfos size:");
      if (paramList1 == null) {
        break label205;
      }
    }
    label184:
    label191:
    label198:
    label205:
    for (paramString = Integer.valueOf(paramList1.size());; paramString = "")
    {
      QLog.d((String)localObject, 2, paramString);
      if (paramBoolean) {
        break label212;
      }
      return;
      paramString = "";
      break;
      paramString = "";
      break label101;
      paramString = "";
      break label132;
    }
    label212:
    AVGameRoomCenterFragment.a(this.a).c();
    AVGameRoomCenterFragment.a(this.a).a();
    if ((paramList == null) || (paramList.size() == 0)) {
      AVGameRoomCenterFragment.a(this.a);
    }
    paramInt = 0;
    int i;
    if (paramInt < AVGameRoomCenterFragment.a(this.a).a())
    {
      if (AVGameRoomCenterFragment.a(this.a).a(paramInt) == null) {}
      for (;;)
      {
        paramInt += 1;
        break;
        switch (AVGameRoomCenterFragment.a(this.a).a(paramInt).a())
        {
        default: 
          break;
        case 0: 
          paramString = (AVGameLobbyBannerContentInfo)AVGameRoomCenterFragment.a(this.a).a(paramInt);
          if (paramString != null) {
            paramString.a(paramList);
          }
          break;
        case 1: 
          paramString = (AVGameLobbyFixedContentInfo)AVGameRoomCenterFragment.a(this.a).a(paramInt);
          if ((paramString != null) && (paramRandomMatchInfo != null))
          {
            paramString.a(paramRandomMatchInfo.jdField_a_of_type_Int);
            localObject = new String[paramRandomMatchInfo.jdField_a_of_type_JavaUtilList.size()];
            i = 0;
            while (i < paramRandomMatchInfo.jdField_a_of_type_JavaUtilList.size())
            {
              localObject[i] = ((Long)paramRandomMatchInfo.jdField_a_of_type_JavaUtilList.get(i)).toString();
              i += 1;
            }
            paramString.a((String[])localObject);
          }
          break;
        }
      }
    }
    if ((!AVGameRoomCenterFragment.a(this.a)) && (((paramList1 != null) && (paramList1.size() != 0)) || ((paramList2 != null) && (paramList2.size() != 0)))) {
      AVGameRoomCenterFragment.a(this.a).a(new AVGameLobbyTitleContentInfo(6, 1));
    }
    if ((paramList1 != null) && (paramList1.size() != 0))
    {
      if (AVGameRoomCenterFragment.a(this.a)) {
        AVGameRoomCenterFragment.a(this.a).a(paramList1, 1);
      }
      for (;;)
      {
        paramInt = 0;
        while (paramInt < paramList1.size())
        {
          if (((AVGameLobbySurvivalContentInfo)paramList1.get(paramInt)).d()) {
            CJSurvivalFestivalReporter.a(1, 0, true, 0, ((AVGameLobbySurvivalContentInfo)paramList1.get(paramInt)).a(), ((AVGameLobbySurvivalContentInfo)paramList1.get(paramInt)).d(), "0", false);
          }
          ReportController.b(AVGameRoomCenterFragment.a(this.a).app, "dc00898", "", "", "0X800B68F", "0X800B68F", 0, 0, "", "", "", "");
          paramInt += 1;
        }
        AVGameRoomCenterFragment.a(this.a).a(paramList1);
      }
    }
    if ((!AVGameRoomCenterFragment.a(this.a)) && (paramList2 != null) && (paramList2.size() != 0)) {
      AVGameRoomCenterFragment.a(this.a).a(paramList2);
    }
    if ((!AVGameRoomCenterFragment.a(this.a)) && (paramList3 != null) && (paramList3.size() != 0))
    {
      AVGameRoomCenterFragment.a(this.a).a(new AVGameLobbyTitleContentInfo(6, 0));
      paramInt = 0;
      while (paramInt < paramList3.size())
      {
        i = ((AVGameLobbyRandomMatchContentInfo)paramList3.get(paramInt)).b;
        ReportController.b(AVGameRoomCenterFragment.a(this.a).app, "dc00898", "", "", "0X800B49E", "0X800B49E", 0, 0, String.valueOf(i), "2", "", "");
        paramInt += 1;
      }
      AVGameRoomCenterFragment.a(this.a).a(paramList3);
    }
    AVGameRoomCenterFragment.a(this.a).b();
    AVGameRoomCenterFragment.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameRoomCenterFragment.3
 * JD-Core Version:    0.7.0.1
 */