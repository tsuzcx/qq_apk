package com.tencent.TMG.audio;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class TraeAudioSessionHost
{
  private ArrayList<TraeAudioSessionHost.SessionInfo> _sessionInfoList = new ArrayList();
  private ReentrantLock mLock = new ReentrantLock();
  
  public void add(TraeAudioSession paramTraeAudioSession, long paramLong, Context paramContext)
  {
    if (find(paramLong) != null) {
      return;
    }
    paramContext = new TraeAudioSessionHost.SessionInfo(this);
    paramContext.sessionId = paramLong;
    paramContext._traeAs = paramTraeAudioSession;
    this.mLock.lock();
    this._sessionInfoList.add(paramContext);
    this.mLock.unlock();
  }
  
  public TraeAudioSessionHost.SessionInfo find(long paramLong)
  {
    this.mLock.lock();
    int i = 0;
    TraeAudioSessionHost.SessionInfo localSessionInfo;
    if (i < this._sessionInfoList.size())
    {
      localSessionInfo = (TraeAudioSessionHost.SessionInfo)this._sessionInfoList.get(i);
      if (localSessionInfo.sessionId != paramLong) {}
    }
    for (;;)
    {
      this.mLock.unlock();
      return localSessionInfo;
      i += 1;
      break;
      localSessionInfo = null;
    }
  }
  
  public void remove(long paramLong)
  {
    this.mLock.lock();
    int i = 0;
    for (;;)
    {
      if (i < this._sessionInfoList.size())
      {
        if (((TraeAudioSessionHost.SessionInfo)this._sessionInfoList.get(i)).sessionId == paramLong) {
          this._sessionInfoList.remove(i);
        }
      }
      else
      {
        this.mLock.unlock();
        return;
      }
      i += 1;
    }
  }
  
  public void sendToAudioSessionMessage(Intent paramIntent)
  {
    this.mLock.lock();
    int i = 0;
    while (i < this._sessionInfoList.size())
    {
      ((TraeAudioSessionHost.SessionInfo)this._sessionInfoList.get(i))._traeAs.onReceiveCallback(paramIntent);
      i += 1;
    }
    this.mLock.unlock();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.audio.TraeAudioSessionHost
 * JD-Core Version:    0.7.0.1
 */