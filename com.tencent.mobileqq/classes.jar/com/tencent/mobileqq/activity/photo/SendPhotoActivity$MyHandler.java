package com.tencent.mobileqq.activity.photo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.SystemClock;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

class SendPhotoActivity$MyHandler
  extends Handler
{
  private final WeakReference<SendPhotoActivity> jdField_a_of_type_JavaLangRefWeakReference;
  
  public SendPhotoActivity$MyHandler(SendPhotoActivity paramSendPhotoActivity1, SendPhotoActivity paramSendPhotoActivity2)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramSendPhotoActivity2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    SendPhotoActivity localSendPhotoActivity = (SendPhotoActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localSendPhotoActivity != null)
    {
      int i = paramMessage.what;
      if (i != 1)
      {
        Object localObject1 = null;
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              super.handleMessage(paramMessage);
              return;
            }
            localSendPhotoActivity.finish();
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.e(SendPhotoActivity.jdField_a_of_type_JavaLangString, 2, "idleHandler time out");
          }
          if (localSendPhotoActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoTask == null)
          {
            Looper.myQueue().removeIdleHandler(localSendPhotoActivity.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
            localSendPhotoActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoTask = new SendPhotoTask(localSendPhotoActivity, null, localSendPhotoActivity.jdField_a_of_type_AndroidOsHandler);
            if (localSendPhotoActivity.jdField_a_of_type_Long != 0L) {
              localSendPhotoActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoTask.jdField_a_of_type_Long = (SystemClock.uptimeMillis() - localSendPhotoActivity.jdField_a_of_type_Long);
            }
            ThreadManager.post(localSendPhotoActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoTask, 8, null, false);
          }
        }
        else
        {
          if (localSendPhotoActivity.jdField_a_of_type_AndroidOsHandler.hasMessages(2))
          {
            Logger.b(SendPhotoActivity.jdField_a_of_type_JavaLangString, "handleMessage", "remove delayed Message:MSG_CANCLE_PROGRESS");
            localSendPhotoActivity.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
          }
          if ((localSendPhotoActivity.jdField_a_of_type_AndroidAppProgressDialog != null) && (localSendPhotoActivity.jdField_a_of_type_AndroidAppProgressDialog.isShowing())) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          localSendPhotoActivity.b();
          Object localObject3 = localSendPhotoActivity.getIntent().getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
          if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
          {
            localObject2 = new String[((ArrayList)localObject3).size()];
            ((ArrayList)localObject3).toArray((Object[])localObject2);
            i = localSendPhotoActivity.getIntent().getIntExtra("uintype", 1003);
            localObject3 = localSendPhotoActivity.app;
            boolean bool2;
            if ((paramMessage.obj != null) && ("TimeOut".equals(paramMessage.obj.toString()))) {
              bool2 = true;
            } else {
              bool2 = false;
            }
            ThreadManager.post(new SendPhotoActivity.MyHandler.1(this, bool2, (String[])localObject2, i, (QQAppInterface)localObject3), 5, null, true);
          }
          Object localObject2 = localSendPhotoActivity.getIntent();
          ((Intent)localObject2).putExtra(AlbumConstants.h, 2);
          if (!((Intent)localObject2).hasExtra("extra_image_sender_tag")) {
            ((Intent)localObject2).putExtra("extra_image_sender_tag", "SendPhotoActivity.handlePhoto");
          }
          Object localObject4 = paramMessage.getData();
          localObject3 = new ArrayList();
          paramMessage = (Message)localObject1;
          if (localObject4 != null)
          {
            ((Bundle)localObject4).setClassLoader(CompressInfo.class.getClassLoader());
            localObject1 = ((Bundle)localObject4).getParcelableArrayList("flag_compressinfolist");
            paramMessage = (Message)localObject1;
            if (localObject1 != null)
            {
              paramMessage = ((ArrayList)localObject1).iterator();
              while (paramMessage.hasNext())
              {
                localObject4 = (CompressInfo)paramMessage.next();
                String str = SendPhotoActivity.jdField_a_of_type_JavaLangString;
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("info:");
                localStringBuilder.append(localObject4);
                Logger.a(str, "handleMessage print CompressInfo", localStringBuilder.toString());
                ((ArrayList)localObject3).add(((CompressInfo)localObject4).e);
              }
              i = ((ArrayList)localObject1).size();
              long l1 = System.nanoTime();
              long l2 = (l1 - localSendPhotoActivity.b) / 1000000L;
              paramMessage = SendPhotoActivity.jdField_a_of_type_JavaLangString;
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("compress startTime = ");
              ((StringBuilder)localObject4).append(localSendPhotoActivity.b);
              ((StringBuilder)localObject4).append("ns,finishTime = ");
              ((StringBuilder)localObject4).append(l1);
              ((StringBuilder)localObject4).append("ns,duration = ");
              ((StringBuilder)localObject4).append(l2);
              ((StringBuilder)localObject4).append("ms,count = ");
              ((StringBuilder)localObject4).append(i);
              ((StringBuilder)localObject4).append(",isShowing = ");
              ((StringBuilder)localObject4).append(bool1);
              Logger.a(paramMessage, "CompressLog", ((StringBuilder)localObject4).toString());
              StatisticConstants.a(l2, i, bool1);
              paramMessage = localSendPhotoActivity.app;
              this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity.a(paramMessage, l1);
              paramMessage = SendPhotoActivity.jdField_a_of_type_JavaLangString;
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("CompressFinish Time = ");
              ((StringBuilder)localObject4).append(l1);
              ((StringBuilder)localObject4).append("ns");
              Logger.a(paramMessage, "TimeCompare", ((StringBuilder)localObject4).toString());
              paramMessage = (Message)localObject1;
            }
          }
          ((Intent)localObject2).putExtra("open_chatfragment_fromphoto", true);
          SendPhotoActivity.a(localSendPhotoActivity, (ArrayList)localObject3);
          ((Intent)localObject2).removeExtra("PhotoConst.SEND_BUSINESS_TYPE");
          localSendPhotoActivity.setResult(-1, localSendPhotoActivity.getIntent());
          localSendPhotoActivity.finish();
          boolean bool1 = localSendPhotoActivity.getIntent().getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("sendPhotoActivity isWaitForResult=");
            ((StringBuilder)localObject1).append(bool1);
            QLog.d("forward", 2, ((StringBuilder)localObject1).toString());
          }
          if (!bool1)
          {
            localObject1 = localSendPhotoActivity.getIntent();
            localObject2 = ((Intent)localObject1).getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
            ((Intent)localObject1).setClassName(((Intent)localObject1).getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), (String)localObject2);
            ((Intent)localObject1).addFlags(603979776);
            localSendPhotoActivity.startActivity((Intent)localObject1);
          }
          SendPhotoActivity.a(BaseApplication.getContext(), paramMessage);
        }
      }
      else
      {
        localSendPhotoActivity.a(2131694878);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SendPhotoActivity.MyHandler
 * JD-Core Version:    0.7.0.1
 */