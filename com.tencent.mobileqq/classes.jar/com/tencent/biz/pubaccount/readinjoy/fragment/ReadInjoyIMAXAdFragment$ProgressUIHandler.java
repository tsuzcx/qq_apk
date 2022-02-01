package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.lang.ref.WeakReference;

public class ReadInjoyIMAXAdFragment$ProgressUIHandler
  extends Handler
{
  WeakReference<ReadInjoyIMAXAdFragment> a;
  
  public ReadInjoyIMAXAdFragment$ProgressUIHandler(Looper paramLooper, ReadInjoyIMAXAdFragment paramReadInjoyIMAXAdFragment)
  {
    super(paramLooper);
    this.a = new WeakReference(paramReadInjoyIMAXAdFragment);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ReadInjoyIMAXAdFragment localReadInjoyIMAXAdFragment = (ReadInjoyIMAXAdFragment)this.a.get();
    if (localReadInjoyIMAXAdFragment == null) {
      return;
    }
    if (paramMessage.what != -2) {
      return;
    }
    if (ReadInjoyIMAXAdFragment.a(localReadInjoyIMAXAdFragment) != null)
    {
      long l1 = ReadInjoyIMAXAdFragment.a(localReadInjoyIMAXAdFragment).getCurrentPostion();
      long l2 = ReadInjoyIMAXAdFragment.a(localReadInjoyIMAXAdFragment).getDuration();
      if (l1 >= l2 - 300L)
      {
        ReadInjoyIMAXAdFragment.b(localReadInjoyIMAXAdFragment, true);
        int i = (int)(l2 - l1);
        if (QLog.isColorLevel())
        {
          paramMessage = new StringBuilder();
          paramMessage.append("onVideoEndSoon: pos=");
          paramMessage.append(l1);
          paramMessage.append(", duration=");
          paramMessage.append(l2);
          paramMessage.append(", remainDuration=");
          paramMessage.append(i);
          paramMessage.append(", mHasCallEndingSoon=");
          paramMessage.append(ReadInjoyIMAXAdFragment.c(localReadInjoyIMAXAdFragment));
          QLog.d("ReadInjoyIMAXAdFragment", 2, paramMessage.toString());
        }
        if (!ReadInjoyIMAXAdFragment.c(localReadInjoyIMAXAdFragment))
        {
          ReadInjoyIMAXAdFragment.c(localReadInjoyIMAXAdFragment, true);
          if (QLog.isColorLevel()) {
            QLog.d("ReadInjoyIMAXAdFragment", 2, "onVideoEndSoon: !!!");
          }
          ReadInjoyIMAXAdFragment.d(localReadInjoyIMAXAdFragment);
        }
      }
      else if ((l1 <= 500L) && (l1 >= 0L) && (ReadInjoyIMAXAdFragment.d(localReadInjoyIMAXAdFragment)))
      {
        if (QLog.isColorLevel())
        {
          paramMessage = new StringBuilder();
          paramMessage.append("onVideoReplayOnLoop: pos=");
          paramMessage.append(l1);
          QLog.d("ReadInjoyIMAXAdFragment", 2, paramMessage.toString());
        }
        ReadInjoyIMAXAdFragment.c(localReadInjoyIMAXAdFragment, false);
        ReadInjoyIMAXAdFragment.b(localReadInjoyIMAXAdFragment, false);
        if (ReadInjoyIMAXAdFragment.a(localReadInjoyIMAXAdFragment) != null)
        {
          ReadInjoyIMAXAdFragment.a(localReadInjoyIMAXAdFragment).pause();
          ReadInjoyIMAXAdFragment.a(localReadInjoyIMAXAdFragment).post(new ReadInjoyIMAXAdFragment.ProgressUIHandler.1(this));
        }
      }
      ReadInjoyIMAXAdFragment.a(localReadInjoyIMAXAdFragment, l1);
    }
    else
    {
      ReadInjoyIMAXAdFragment.f(localReadInjoyIMAXAdFragment, ReadInjoyIMAXAdFragment.f(localReadInjoyIMAXAdFragment) + 100);
      ReadInjoyIMAXAdFragment.a(localReadInjoyIMAXAdFragment, ReadInjoyIMAXAdFragment.f(localReadInjoyIMAXAdFragment));
    }
    ReadInjoyIMAXAdFragment.a(localReadInjoyIMAXAdFragment).sendEmptyMessageDelayed(-2, 100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInjoyIMAXAdFragment.ProgressUIHandler
 * JD-Core Version:    0.7.0.1
 */