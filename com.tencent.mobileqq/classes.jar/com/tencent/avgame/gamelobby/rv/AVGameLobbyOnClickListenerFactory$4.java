package com.tencent.avgame.gamelobby.rv;

import android.view.View;
import com.tencent.avgame.gamelobby.data.IBaseData;
import com.tencent.avgame.ui.AVGameRoomCenterFragment;
import com.tencent.qphone.base.util.QLog;

class AVGameLobbyOnClickListenerFactory$4
  implements BaseViewHolder.OnClickListener
{
  AVGameLobbyOnClickListenerFactory$4(AVGameLobbyOnClickListenerFactory paramAVGameLobbyOnClickListenerFactory) {}
  
  public void a(View paramView, IBaseData paramIBaseData, int paramInt)
  {
    if (paramIBaseData == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (paramView.getId() != 2131363281) {
            break;
          }
          this.a.a.c();
        } while (!QLog.isColorLevel());
        QLog.d(AVGameRoomCenterFragment.a, 2, "Create room button click");
        return;
        if (paramView.getId() != 2131363293) {
          break;
        }
        this.a.a.a(2);
      } while (!QLog.isColorLevel());
      QLog.d(AVGameRoomCenterFragment.a, 2, "Search room button click");
      return;
    } while (!QLog.isColorLevel());
    QLog.d(AVGameRoomCenterFragment.a, 2, "Create and search button click err");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.rv.AVGameLobbyOnClickListenerFactory.4
 * JD-Core Version:    0.7.0.1
 */