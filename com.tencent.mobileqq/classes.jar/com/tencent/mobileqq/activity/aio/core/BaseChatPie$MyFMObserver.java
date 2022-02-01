package com.tencent.mobileqq.activity.aio.core;

import aezn;
import android.text.TextUtils;
import asbj;
import asgz;
import aslv;
import aszt;
import bleg;
import blfa;
import blho;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$MyFMObserver
  extends asbj
{
  private BaseChatPie$MyFMObserver(BaseChatPie paramBaseChatPie) {}
  
  public void onAIOMusicChanged()
  {
    this.this$0.listAdapter.notifyDataSetChanged();
  }
  
  public void onFileCome(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    this.this$0.listAdapter.notifyDataSetChanged();
  }
  
  public void onFileTransferEnd(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.tag, 2, "OnFileTransferEnd : isSuccess[" + paramBoolean + "], uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + paramString1 + "], peerType[" + paramInt1 + "]");
    }
    paramString1 = this.this$0.app.getFileManagerDataCenter().a(paramLong2);
    if ((paramString1 != null) && (paramString1.nOpType == 6)) {
      if (bleg.a(paramInt2))
      {
        if (!paramBoolean) {
          break label154;
        }
        blfa.a(this.this$0.app, this.this$0.getActivity(), this.this$0.getTitleBarHeight());
      }
    }
    for (;;)
    {
      this.this$0.listAdapter.notifyDataSetChanged();
      return;
      label154:
      if (bleg.b())
      {
        bleg.a(this.this$0.app);
      }
      else
      {
        if (!TextUtils.isEmpty(paramString2)) {
          QQToast.a(this.this$0.app.getApp(), paramString2, 1).b(this.this$0.getTitleBarHeight());
        }
        for (;;)
        {
          blho.a(null, paramInt2);
          break;
          QQToast.a(this.this$0.app.getApp(), 2131692492, 1).b(this.this$0.getTitleBarHeight());
        }
        if ((!paramBoolean) && (paramString1 != null) && (!TextUtils.isEmpty(paramString1.peerUin)) && (paramString1.peerUin.equalsIgnoreCase(this.this$0.sessionInfo.curFriendUin)))
        {
          aszt.a(paramLong2, paramInt2, paramString2);
          blho.a(null, paramInt2);
        }
      }
    }
  }
  
  public void onFileTransferProgress(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    this.this$0.listAdapter.notifyDataSetChanged();
  }
  
  public void onFileTransferStart(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    this.this$0.listAdapter.notifyDataSetChanged();
  }
  
  public void onOfflineSendToWeiYunFaild(int paramInt, long paramLong, String paramString)
  {
    aszt.a(paramLong, paramInt, paramString);
    blho.a(null, paramInt);
    if (this.this$0.listAdapter != null) {
      this.this$0.listAdapter.notifyDataSetChanged();
    }
  }
  
  public void onOfflineSendToWeiYunSuccess(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if ((paramString2 != null) && (paramString2.length() > 0))
    {
      aszt.c(paramString2);
      return;
    }
    aszt.a(paramLong);
  }
  
  public void onOnlineFileUpDone(long paramLong1, long paramLong2)
  {
    this.this$0.listAdapter.notifyDataSetChanged();
  }
  
  public void onRefreshList()
  {
    this.this$0.listAdapter.notifyDataSetChanged();
  }
  
  public void onSomethingChaned()
  {
    this.this$0.listAdapter.notifyDataSetChanged();
  }
  
  public void onThumbDownLoadSuccess(aslv paramaslv)
  {
    if (paramaslv == null) {}
    label4:
    do
    {
      FileManagerEntity localFileManagerEntity;
      do
      {
        do
        {
          break label4;
          do
          {
            return;
          } while (!(paramaslv.a instanceof FileManagerEntity));
          localFileManagerEntity = (FileManagerEntity)paramaslv.a;
          if ((paramaslv.b == null) || (paramaslv.b.length() <= 0)) {
            break;
          }
          localFileManagerEntity.strThumbPath = paramaslv.b;
          this.this$0.app.getFileManagerDataCenter().c(localFileManagerEntity);
        } while (this.this$0.listAdapter == null);
        this.this$0.listAdapter.notifyDataSetChanged();
        return;
      } while (localFileManagerEntity.thumbInvalidCode != 1);
      this.this$0.app.getFileManagerDataCenter().c(localFileManagerEntity);
    } while (this.this$0.listAdapter == null);
    this.this$0.listAdapter.notifyDataSetChanged();
  }
  
  public void onTroopFileCopyToC2cDisc(long paramLong, boolean paramBoolean, int paramInt, String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      aszt.c(paramString);
    }
    this.this$0.listAdapter.notifyDataSetChanged();
  }
  
  public void onWeiYunSendToOfflineFaild(Integer paramInteger, long paramLong, String paramString)
  {
    if (this.this$0.listAdapter != null) {
      this.this$0.listAdapter.notifyDataSetChanged();
    }
    aszt.a(paramLong, paramInteger.intValue(), paramString);
    blho.a(null, paramInteger.intValue());
  }
  
  public void onWeiYunSendToOfflineSuccess()
  {
    if (this.this$0.listAdapter != null) {
      this.this$0.listAdapter.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.MyFMObserver
 * JD-Core Version:    0.7.0.1
 */