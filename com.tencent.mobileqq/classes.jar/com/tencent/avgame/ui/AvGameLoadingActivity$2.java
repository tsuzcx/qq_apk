package com.tencent.avgame.ui;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.avgame.business.observer.AvGameRoomListObserver;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class AvGameLoadingActivity$2
  extends AvGameRoomListObserver
{
  AvGameLoadingActivity$2(AvGameLoadingActivity paramAvGameLoadingActivity) {}
  
  public void a(int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong1, long paramLong2)
  {
    AvGameLoadingActivity.a(this.a, true, paramInt, paramString, paramRoomInfo, paramArrayOfByte, paramLong1, paramLong2);
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameLoadingActivity", 2, String.format("onStrangerMatchNotify isSuc:%b type:%d roomId:%d mWaitingStrangerMatchPush:%b", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Long.valueOf(paramLong), Boolean.valueOf(AvGameLoadingActivity.c(this.a)) }));
    }
    if (AvGameLoadingActivity.c(this.a))
    {
      AvGameLoadingActivity.a(this.a, false);
      AvGameLoadingActivity.a(this.a, -1);
      this.a.b.removeMessages(9);
      if (paramBoolean)
      {
        ReportController.b(null, "dc00898", "", "", "0X800B495", "0X800B495", 0, 0, "", "", "", "");
        AvGameLoadingActivity localAvGameLoadingActivity;
        if (paramInt == 1)
        {
          localAvGameLoadingActivity = this.a;
          AvGameLoadingActivity.a(localAvGameLoadingActivity, AvGameLoadingActivity.d(localAvGameLoadingActivity), null);
          return;
        }
        if (paramInt == 2)
        {
          localAvGameLoadingActivity = this.a;
          AvGameLoadingActivity.b(localAvGameLoadingActivity, AvGameLoadingActivity.c(localAvGameLoadingActivity, 6));
          localAvGameLoadingActivity = this.a;
          AvGameLoadingActivity.a(localAvGameLoadingActivity, AvGameLoadingActivity.d(localAvGameLoadingActivity), String.valueOf(paramLong), null);
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameLoadingActivity", 2, String.format("onStrangerMatchStart isSuc:%b uin:%d shareId:%d errCode:%d errMsg:%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }));
    }
    if ((AvGameLoadingActivity.a(this.a)) && (!AvGameLoadingActivity.b(this.a)))
    {
      if (paramBoolean)
      {
        AvGameLoadingActivity.a(this.a, true);
        AvGameLoadingActivity.a(this.a, paramInt1);
        return;
      }
      Object localObject = null;
      if (paramInt2 == 601) {
        localObject = paramString;
      }
      paramString = (String)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramString = this.a.getString(2131887376);
      }
      localObject = this.a;
      AvGameLoadingActivity.a((AvGameLoadingActivity)localObject, null, paramString, ((AvGameLoadingActivity)localObject).getString(2131887410), new AvGameLoadingActivity.2.1(this), null, null);
      ReportController.b(null, "dc00898", "", "", "0X800B496", "0X800B496", paramInt2, 0, "", "", "", "");
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameLoadingActivity", 2, String.format("onStrangerMatchStop isSuc:%b uin:%d errCode:%d errMsg:%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), Integer.valueOf(paramInt), paramString }));
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameLoadingActivity", 2, String.format("onStrangerMatchV2Start isSuc:%b uin:%d gameType:%d extra:%s errCode:%d errMsg:%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), Integer.valueOf(paramInt1), paramArrayOfByte, Integer.valueOf(paramInt2), paramString }));
    }
    if ((AvGameLoadingActivity.e(this.a)) && (!AvGameLoadingActivity.f(this.a))) {
      if (paramBoolean)
      {
        AvGameLoadingActivity.b(this.a, true);
        AvGameLoadingActivity.a(this.a, paramArrayOfByte);
        if (AvGameLoadingActivity.g(this.a) == 0) {
          AvGameLoadingActivity.d(this.a, paramInt1);
        }
      }
      else
      {
        paramArrayOfByte = null;
        if (paramInt2 == 750) {
          paramArrayOfByte = paramString;
        }
        paramString = paramArrayOfByte;
        if (TextUtils.isEmpty(paramArrayOfByte)) {
          paramString = this.a.getString(2131887376);
        }
        paramArrayOfByte = this.a;
        AvGameLoadingActivity.a(paramArrayOfByte, null, paramString, paramArrayOfByte.getString(2131887410), new AvGameLoadingActivity.2.2(this), null, null);
      }
    }
  }
  
  public void b(int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong1, long paramLong2)
  {
    AvGameLoadingActivity.a(this.a, false, paramInt, paramString, paramRoomInfo, paramArrayOfByte, paramLong1, paramLong2);
  }
  
  protected void b(boolean paramBoolean, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameLoadingActivity", 2, String.format("onStrangerMatchV2Notify isSuc:%b type:%d roomId:%d mWaitingStrangerMatchPush:%b", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Long.valueOf(paramLong), Boolean.valueOf(AvGameLoadingActivity.c(this.a)) }));
    }
    if (AvGameLoadingActivity.f(this.a))
    {
      AvGameLoadingActivity.b(this.a, false);
      AvGameLoadingActivity.a(this.a, null);
      if (paramBoolean)
      {
        AvGameLoadingActivity localAvGameLoadingActivity;
        if (paramInt == 1)
        {
          localAvGameLoadingActivity = this.a;
          AvGameLoadingActivity.a(localAvGameLoadingActivity, AvGameLoadingActivity.d(localAvGameLoadingActivity), null);
          return;
        }
        if (paramInt == 2)
        {
          if (AvGameLoadingActivity.d(this.a) == 13)
          {
            localAvGameLoadingActivity = this.a;
            AvGameLoadingActivity.b(localAvGameLoadingActivity, AvGameLoadingActivity.c(localAvGameLoadingActivity, 1000));
          }
          else
          {
            localAvGameLoadingActivity = this.a;
            AvGameLoadingActivity.b(localAvGameLoadingActivity, AvGameLoadingActivity.c(localAvGameLoadingActivity, 8));
          }
          localAvGameLoadingActivity = this.a;
          AvGameLoadingActivity.a(localAvGameLoadingActivity, AvGameLoadingActivity.d(localAvGameLoadingActivity), String.valueOf(paramLong), null);
        }
      }
    }
  }
  
  protected void b(boolean paramBoolean, long paramLong, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameLoadingActivity", 2, String.format("onStrangerMatchStopV2 isSuc:%b uin:%d errCode:%d errMsg:%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), Integer.valueOf(paramInt), paramString }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AvGameLoadingActivity.2
 * JD-Core Version:    0.7.0.1
 */