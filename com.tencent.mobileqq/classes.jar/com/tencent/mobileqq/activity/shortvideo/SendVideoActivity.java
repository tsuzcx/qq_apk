package com.tencent.mobileqq.activity.shortvideo;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.MotionEvent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.api.IShortVideoUploadProcessor;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.mobileqq.video.AioVideoTransFileController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import mqq.os.MqqHandler;

public class SendVideoActivity
  extends BaseActivity
  implements Handler.Callback
{
  private static MqqWeakReferenceHandler a;
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    int i = getIntent().getIntExtra("file_send_business_type", 0);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("doOnCreate(), ===>> busiType=");
      paramBundle.append(i);
      paramBundle.append(",VideoFileDir = ");
      paramBundle.append(getIntent().getStringExtra("file_video_source_dir"));
      QLog.d("SendVideoActivity", 2, paramBundle.toString());
    }
    if (i != 0)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i == 4) {
            ThreadManager.getSubThreadHandler().post(new SendTask(this, null));
          }
        }
        else
        {
          paramBundle = getIntent().getStringExtra("uin");
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("doOnCreate, uin= ");
            localStringBuilder.append(paramBundle);
            QLog.d("SendVideoActivity", 2, localStringBuilder.toString());
          }
          if ((paramBundle != null) && (paramBundle.equals("0")))
          {
            int j = getIntent().getIntExtra("uintype", -1);
            if (j != 0)
            {
              if (QLog.isColorLevel())
              {
                paramBundle = new StringBuilder();
                paramBundle.append("doOnCreate error, uinType= ");
                paramBundle.append(j);
                paramBundle.append(" busiType= ");
                paramBundle.append(i);
                QLog.d("SendVideoActivity", 2, paramBundle.toString());
              }
              finish();
            }
            else
            {
              a = new MqqWeakReferenceHandler(this);
              a.sendEmptyMessageDelayed(1, 45000L);
            }
          }
          else
          {
            ThreadManager.getSubThreadHandler().post(new SendTask(this, null));
          }
        }
      }
      else
      {
        paramBundle = getIntent().getStringExtra("activity_before_enter_send_video");
        if ((paramBundle != null) && (ShortVideoPreviewActivity.class.getName().equals(paramBundle))) {
          new SendAppShortVideoTask(this).execute(new Void[0]);
        } else {
          ThreadManager.getSubThreadHandler().post(new SendTask(this, null));
        }
      }
    }
    else {
      new SendVideoTask(this, null).execute(new Void[0]);
    }
    if (QLog.isColorLevel()) {
      QLog.d("SendVideoActivity", 2, "doOnCreate(), <<===");
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    MqqWeakReferenceHandler localMqqWeakReferenceHandler = a;
    if (localMqqWeakReferenceHandler != null) {
      localMqqWeakReferenceHandler.removeMessages(1);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SendVideoActivity", 2, "handleMessage: send video timeout!");
      }
      paramMessage = ((BlessManager)getAppInterface().getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).z();
      if (paramMessage != null)
      {
        IHttpCommunicatorListener localIHttpCommunicatorListener = ((ITransFileController)this.app.getRuntimeService(ITransFileController.class)).findProcessor(paramMessage.frienduin, paramMessage.uniseq);
        if ((localIHttpCommunicatorListener != null) && (IShortVideoUploadProcessor.class.isInstance(localIHttpCommunicatorListener)))
        {
          boolean bool = ((BaseTransProcessor)localIHttpCommunicatorListener).isPause();
          int i = paramMessage.videoFileStatus;
          if ((bool) || (i == 1002) || (i == 1001)) {
            AioVideoTransFileController.d(this.app, paramMessage.frienduin, paramMessage.uniseq);
          }
        }
      }
    }
    return false;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.SendVideoActivity
 * JD-Core Version:    0.7.0.1
 */