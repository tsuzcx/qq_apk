package com.tencent.biz.pubaccount.readinjoy.view.fastweb.video;

import android.telephony.PhoneStateListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class FastWebVideoFeedsPlayActivity$PhoneCallStateListener
  extends PhoneStateListener
{
  WeakReference a;
  
  public FastWebVideoFeedsPlayActivity$PhoneCallStateListener(FastWebVideoFeedsPlayManager paramFastWebVideoFeedsPlayManager)
  {
    this.a = new WeakReference(paramFastWebVideoFeedsPlayManager);
  }
  
  public void onCallStateChanged(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayActivity", 2, "onCallStateChanged:" + paramInt);
    }
    switch (paramInt)
    {
    }
    do
    {
      return;
      paramString = (FastWebVideoFeedsPlayManager)this.a.get();
    } while (paramString == null);
    paramString.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsPlayActivity.PhoneCallStateListener
 * JD-Core Version:    0.7.0.1
 */