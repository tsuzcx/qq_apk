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
  
  public void a(boolean paramBoolean, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameManagerAvGameLoadingActivity", 2, String.format("onStrangerMatchNotify isSuc:%b type:%d roomId:%d mWaitingStrangerMatchPush:%b", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Long.valueOf(paramLong), Boolean.valueOf(AvGameLoadingActivity.c(this.a)) }));
    }
    if (AvGameLoadingActivity.c(this.a))
    {
      AvGameLoadingActivity.a(this.a, false);
      AvGameLoadingActivity.a(this.a, -1);
      this.a.a.removeMessages(9);
      if (paramBoolean)
      {
        ReportController.b(null, "dc00898", "", "", "0X800B495", "0X800B495", 0, 0, "", "", "", "");
        if (paramInt != 1) {
          break label144;
        }
        AvGameLoadingActivity.a(this.a, AvGameLoadingActivity.a(this.a), null);
      }
    }
    label144:
    while (paramInt != 2) {
      return;
    }
    AvGameLoadingActivity.b(this.a, AvGameLoadingActivity.c(this.a, 6));
    AvGameLoadingActivity.a(this.a, AvGameLoadingActivity.a(this.a), String.valueOf(paramLong), null);
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameManagerAvGameLoadingActivity", 2, String.format("onStrangerMatchStart isSuc:%b uin:%d shareId:%d errCode:%d errMsg:%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }));
    }
    if ((AvGameLoadingActivity.a(this.a)) && (!AvGameLoadingActivity.b(this.a)))
    {
      if (paramBoolean)
      {
        AvGameLoadingActivity.a(this.a, true);
        AvGameLoadingActivity.a(this.a, paramInt1);
      }
    }
    else {
      return;
    }
    if (paramInt2 == 601) {}
    for (;;)
    {
      if (TextUtils.isEmpty(paramString)) {
        paramString = this.a.getString(2131690540);
      }
      for (;;)
      {
        AvGameLoadingActivity.a(this.a, null, paramString, this.a.getString(2131690571), new AvGameLoadingActivity.2.1(this), null, null);
        ReportController.b(null, "dc00898", "", "", "0X800B496", "0X800B496", paramInt2, 0, "", "", "", "");
        return;
      }
      paramString = null;
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameManagerAvGameLoadingActivity", 2, String.format("onStrangerMatchStop isSuc:%b uin:%d errCode:%d errMsg:%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), Integer.valueOf(paramInt), paramString }));
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameManagerAvGameLoadingActivity", 2, String.format("onStrangerMatchV2Start isSuc:%b uin:%d gameType:%d extra:%s errCode:%d errMsg:%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), Integer.valueOf(paramInt1), paramArrayOfByte, Integer.valueOf(paramInt2), paramString }));
    }
    if ((AvGameLoadingActivity.d(this.a)) && (!AvGameLoadingActivity.e(this.a)))
    {
      if (!paramBoolean) {
        break label126;
      }
      AvGameLoadingActivity.b(this.a, true);
      AvGameLoadingActivity.a(this.a, paramArrayOfByte);
      if (AvGameLoadingActivity.b(this.a) == 0) {
        AvGameLoadingActivity.d(this.a, paramInt1);
      }
    }
    return;
    label126:
    if (paramInt2 == 750) {}
    for (;;)
    {
      if (TextUtils.isEmpty(paramString)) {}
      for (paramArrayOfByte = this.a.getString(2131690540);; paramArrayOfByte = paramString)
      {
        AvGameLoadingActivity.a(this.a, null, paramArrayOfByte, this.a.getString(2131690571), new AvGameLoadingActivity.2.2(this), null, null);
        return;
      }
      paramString = null;
    }
  }
  
  public void b(int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong1, long paramLong2)
  {
    AvGameLoadingActivity.a(this.a, false, paramInt, paramString, paramRoomInfo, paramArrayOfByte, paramLong1, paramLong2);
  }
  
  public void b(boolean paramBoolean, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameManagerAvGameLoadingActivity", 2, String.format("onStrangerMatchV2Notify isSuc:%b type:%d roomId:%d mWaitingStrangerMatchPush:%b", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Long.valueOf(paramLong), Boolean.valueOf(AvGameLoadingActivity.c(this.a)) }));
    }
    if (AvGameLoadingActivity.e(this.a))
    {
      AvGameLoadingActivity.b(this.a, false);
      AvGameLoadingActivity.a(this.a, null);
      if (paramBoolean)
      {
        if (paramInt != 1) {
          break label108;
        }
        AvGameLoadingActivity.a(this.a, AvGameLoadingActivity.a(this.a), null);
      }
    }
    label108:
    while (paramInt != 2) {
      return;
    }
    if (AvGameLoadingActivity.a(this.a) == 13) {
      AvGameLoadingActivity.b(this.a, AvGameLoadingActivity.c(this.a, 1000));
    }
    for (;;)
    {
      AvGameLoadingActivity.a(this.a, AvGameLoadingActivity.a(this.a), String.valueOf(paramLong), null);
      return;
      AvGameLoadingActivity.b(this.a, AvGameLoadingActivity.c(this.a, 8));
    }
  }
  
  public void b(boolean paramBoolean, long paramLong, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameManagerAvGameLoadingActivity", 2, String.format("onStrangerMatchStopV2 isSuc:%b uin:%d errCode:%d errMsg:%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), Integer.valueOf(paramInt), paramString }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.ui.AvGameLoadingActivity.2
 * JD-Core Version:    0.7.0.1
 */