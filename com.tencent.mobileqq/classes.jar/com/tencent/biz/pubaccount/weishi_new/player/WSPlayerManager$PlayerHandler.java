package com.tencent.biz.pubaccount.weishi_new.player;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.util.WeakReference;

class WSPlayerManager$PlayerHandler
  extends Handler
{
  private final WeakReference<WSPlayerManager> a;
  
  WSPlayerManager$PlayerHandler(WSPlayerManager paramWSPlayerManager, Looper paramLooper)
  {
    super(paramLooper);
    this.a = new WeakReference(paramWSPlayerManager);
  }
  
  public void dispatchMessage(Message paramMessage)
  {
    WSPlayerManager localWSPlayerManager = (WSPlayerManager)this.a.get();
    if (localWSPlayerManager != null)
    {
      if (WSPlayerManager.f(localWSPlayerManager)) {
        return;
      }
      if ((paramMessage.obj instanceof WSPlayerParam))
      {
        if (WSPlayerManager.a(localWSPlayerManager, (WSPlayerParam)paramMessage.obj)) {
          super.dispatchMessage(paramMessage);
        }
      }
      else {
        super.dispatchMessage(paramMessage);
      }
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    WSPlayerManager localWSPlayerManager = (WSPlayerManager)this.a.get();
    if (localWSPlayerManager == null) {
      return;
    }
    int i = paramMessage.what;
    boolean bool2 = true;
    if (i != -4)
    {
      if (i != -3)
      {
        if (i != -2) {
          return;
        }
        paramMessage = WSPlayerManager.a(localWSPlayerManager);
        localObject = WSPlayerManager.b(localWSPlayerManager);
        if ((paramMessage != null) && (paramMessage.b()) && ((((WSPlayerParam)localObject).jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate == null) || (!((WSPlayerParam)localObject).jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate.a((WSPlayerParam)localObject))) && (!paramMessage.f()))
        {
          long l2 = paramMessage.a();
          long l1 = paramMessage.b();
          if (((WSPlayerParam)localObject).jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate != null) {
            ((WSPlayerParam)localObject).jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate.a((WSPlayerParam)localObject, l2, l1);
          }
          if (l2 >= l1 - 300L)
          {
            WSPlayerManager.e(localWSPlayerManager, true);
            i = (int)(l1 - l2);
            paramMessage = new StringBuilder();
            paramMessage.append("[WSPlayerManager.java][handleMessage] MSG_FOR_UPDATE_VIDEO_PLAY_POSITION onVideoEndSoon pos:");
            paramMessage.append(l2);
            paramMessage.append(", duration:");
            paramMessage.append(l1);
            paramMessage.append(", remainDuration:");
            paramMessage.append(i);
            paramMessage.append(", mHasCallEndingSoon:");
            paramMessage.append(WSPlayerManager.g(localWSPlayerManager));
            WSLog.e("WS_VIDEO_PLAYER", paramMessage.toString());
            if ((!WSPlayerManager.g(localWSPlayerManager)) && (WSPlayerManager.a(localWSPlayerManager) != null))
            {
              WSPlayerManager.f(localWSPlayerManager, true);
              if ((((WSPlayerParam)localObject).jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate != null) && (!WSPlayerManager.h(localWSPlayerManager)))
              {
                boolean bool1 = bool2;
                if (!WSPlayerManager.e(localWSPlayerManager)) {
                  if (WSPlayerManager.i(localWSPlayerManager)) {
                    bool1 = bool2;
                  } else {
                    bool1 = false;
                  }
                }
                ((WSPlayerParam)localObject).jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate.a(WSPlayerManager.b(localWSPlayerManager), i, bool1);
              }
            }
          }
          else if ((l2 <= 500L) && (l2 >= 0L) && (WSPlayerManager.j(localWSPlayerManager)))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("[WSPlayerManager.java][handleMessage] MSG_FOR_UPDATE_VIDEO_PLAY_POSITION onVideoReplayOnLoop pos:");
            ((StringBuilder)localObject).append(l2);
            WSLog.e("WS_VIDEO_PLAYER", ((StringBuilder)localObject).toString());
            WSPlayerManager.g(localWSPlayerManager, false);
            WSPlayerManager.f(localWSPlayerManager, false);
            WSPlayerManager.e(localWSPlayerManager, false);
            WSPlayerManager.b(localWSPlayerManager);
            paramMessage.i();
            paramMessage.j();
            if (WSPlayerManager.a(localWSPlayerManager) != null)
            {
              paramMessage = WSPlayerManager.a(localWSPlayerManager).iterator();
              while (paramMessage.hasNext()) {
                ((WSPlayerStatusListener)paramMessage.next()).a(WSPlayerManager.b(localWSPlayerManager), WSPlayerManager.c(localWSPlayerManager));
              }
            }
          }
        }
        WSPlayerManager.a(localWSPlayerManager).sendEmptyMessageDelayed(-2, 100L);
        return;
      }
      WSLog.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][handleMessage] MSG_PRE_PLAY_TIME_OUT. prePlay timeout, try rePlay");
      paramMessage = WSPlayerManager.a(localWSPlayerManager, WSPlayerManager.b(localWSPlayerManager));
      if ((paramMessage != null) && (paramMessage.e()) && (paramMessage.a() == WSPlayerManager.b(localWSPlayerManager).jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo))
      {
        WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][handleMessage] MSG_PRE_PLAY_TIME_OUT. startVideoAfterPrepared!");
        WSPlayerManager.a(localWSPlayerManager).a();
        return;
      }
      WSPlayerManager.b(localWSPlayerManager).jdField_a_of_type_Boolean = false;
      WSPlayerManager.a(localWSPlayerManager, WSPlayerManager.b(localWSPlayerManager));
      WSPlayerManager.a(localWSPlayerManager, WSPlayerManager.b(localWSPlayerManager), false);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSPlayerManager.java][handleMessage] MSG_PLAY_BY_URL_FAILED. playerStartByUrl failed, retry again. RetryVideoUrl:");
    if (WSPlayerManager.b(localWSPlayerManager).jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo != null) {
      paramMessage = WSPlayerManager.b(localWSPlayerManager).jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.b;
    } else {
      paramMessage = "videoInfo is null.";
    }
    ((StringBuilder)localObject).append(paramMessage);
    WSLog.d("WS_VIDEO_PLAYER", ((StringBuilder)localObject).toString());
    if (WSPlayerManager.d(localWSPlayerManager) == 1) {
      return;
    }
    WSPlayerManager.b(localWSPlayerManager).jdField_a_of_type_Boolean = false;
    WSPlayerManager.a(localWSPlayerManager, WSPlayerManager.b(localWSPlayerManager));
    WSPlayerManager.a(localWSPlayerManager, WSPlayerManager.b(localWSPlayerManager), false);
    WSPlayerManager.e(localWSPlayerManager);
  }
  
  public boolean sendMessageAtTime(Message paramMessage, long paramLong)
  {
    WSPlayerManager localWSPlayerManager = (WSPlayerManager)this.a.get();
    if ((localWSPlayerManager != null) && (!WSPlayerManager.f(localWSPlayerManager)))
    {
      if ((Looper.myLooper() == Looper.getMainLooper()) && (paramLong <= SystemClock.uptimeMillis()))
      {
        if (paramMessage.getCallback() != null) {
          paramMessage.getCallback().run();
        } else {
          handleMessage(paramMessage);
        }
        return true;
      }
      if (paramMessage.obj == null) {
        paramMessage.obj = WSPlayerManager.b(localWSPlayerManager);
      }
      return super.sendMessageAtTime(paramMessage, paramLong);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.PlayerHandler
 * JD-Core Version:    0.7.0.1
 */