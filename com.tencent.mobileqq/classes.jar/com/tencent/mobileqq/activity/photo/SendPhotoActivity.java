package com.tencent.mobileqq.activity.photo;

import aipp;
import aipq;
import alof;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.SystemClock;
import android.widget.TextView;
import awiw;
import awka;
import axlk;
import bdhb;
import bhpp;
import bhsb;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import nrt;
import syb;

public class SendPhotoActivity
  extends BaseActivity
{
  public static final String a;
  public long a;
  public ProgressDialog a;
  public Handler a;
  public MessageQueue.IdleHandler a;
  Messenger jdField_a_of_type_AndroidOsMessenger;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public SendPhotoTask a;
  boolean jdField_a_of_type_Boolean = false;
  public long b;
  
  static
  {
    jdField_a_of_type_JavaLangString = SendPhotoActivity.class.getName();
  }
  
  public SendPhotoActivity()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new aipp(this);
    this.jdField_a_of_type_AndroidOsHandler = new aipq(this);
  }
  
  static void a()
  {
    String str1 = alof.aX + "photo/" + ".nomedia";
    String str2 = alof.aX + "thumb/" + ".nomedia";
    String str3 = alof.aX + "thumb2/" + ".nomedia";
    bdhb.c(str1);
    bdhb.c(str2);
    bdhb.c(str3);
  }
  
  private static void b(BaseActivity paramBaseActivity, ArrayList<String> paramArrayList)
  {
    if (paramBaseActivity == null) {}
    for (;;)
    {
      return;
      Object localObject1 = paramBaseActivity.getIntent();
      int j = ((Intent)localObject1).getIntExtra("uintype", 0);
      ArrayList localArrayList;
      int i;
      if (j == 1008)
      {
        localArrayList = new ArrayList();
        Object localObject2 = paramBaseActivity.getClass().getSimpleName();
        QLog.d((String)localObject2, 2, "[report]Send Picture count=" + paramArrayList.size());
        i = 0;
        while (i < paramArrayList.size())
        {
          localArrayList.add(bhpp.a((String)paramArrayList.get(i)));
          QLog.d((String)localObject2, 2, "[report] picture " + i + "md5=" + bhpp.a((String)paramArrayList.get(i)) + ": path=" + (String)paramArrayList.get(i));
          i += 1;
        }
        localObject2 = new Intent("com.tencent.biz.pubaccount.picResultAction");
        ((Intent)localObject2).putExtra("com.tencent.biz.pubaccount.picResultData", paramArrayList.size());
        ((Intent)localObject2).putStringArrayListExtra("com.tencent.biz.pubaccount.picResult_md5s", localArrayList);
        paramBaseActivity.sendBroadcast((Intent)localObject2, "com.tencent.msg.permission.pushnotify");
      }
      if (paramBaseActivity.app != null)
      {
        i = ((Intent)localObject1).getIntExtra("PhotoConst.SEND_SIZE_SPEC", -1);
        if (i != -1)
        {
          localArrayList = new ArrayList(Arrays.asList(new String[paramArrayList.size()]));
          Collections.copy(localArrayList, paramArrayList);
          PhotoUtils.a(paramBaseActivity.app, i, localArrayList);
        }
      }
      localObject1 = ((Intent)localObject1).getStringExtra("uin");
      if ((localObject1 != null) && (j == 1008) && (syb.a(paramBaseActivity.app, (String)localObject1)))
      {
        i = 0;
        while (i < paramArrayList.size())
        {
          nrt.a(paramBaseActivity.app, "P_CliOper", "Pb_account_lifeservice", (String)localObject1, "0X8005C9D", "0X8005C9D", 0, 0, "", "", "", "", false);
          i += 1;
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        b();
      }
      while (!this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())
      {
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        return;
        this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(this, 2131755801);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2131559437);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131371894));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      awiw.b("PIC_TAG_ERROR", "SendPhotoActivity.showProgressDialog", localThrowable.toString());
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "TestPicSend finish compress,currentTime = " + System.currentTimeMillis());
    }
    if ((this.jdField_a_of_type_AndroidAppProgressDialog != null) && (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppProgressDialog.cancel();
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 102))
    {
      super.setResult(paramInt2, paramIntent);
      super.finish();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = true;
    super.doOnCreate(paramBundle);
    ThreadManager.executeOnFileThread(bdhb.a);
    Object localObject1 = getIntent();
    paramBundle = ((Intent)localObject1).getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if (paramBundle == null)
    {
      awiw.b(jdField_a_of_type_JavaLangString, "initPicUploadInfos", "paths is null");
      finish();
      return true;
    }
    bhsb.a(true, paramBundle);
    int i;
    if (((Intent)localObject1).getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false))
    {
      localObject2 = (SessionInfo)((Intent)localObject1).getParcelableExtra("session_info");
      i = ((Intent)localObject1).getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0);
      if (localObject2 != null) {
        axlk.a().a(this.app, (SessionInfo)localObject2, paramBundle, i);
      }
      setResult(-1, getIntent());
      finish();
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "TestPicSend start compress,currentTime = " + System.currentTimeMillis());
    }
    Object localObject2 = (BinderWarpper)((Intent)localObject1).getParcelableExtra("presend_handler");
    if (localObject2 != null)
    {
      this.jdField_a_of_type_AndroidOsMessenger = new Messenger(((BinderWarpper)localObject2).a);
      localObject2 = Message.obtain(null, 1);
      ((Message)localObject2).replyTo = new Messenger(this.jdField_a_of_type_AndroidOsHandler);
      i = ((Intent)localObject1).getIntExtra("key_is_sync_qzone", 0);
      if (i == 1)
      {
        awka localawka = awka.a();
        if (localawka != null) {
          localawka.a(i, ((Intent)localObject1).getLongExtra("key_qzone_batch_id", 0L), ((Intent)localObject1).getStringExtra("key_qzone_album_id"));
        }
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidOsMessenger.send((Message)localObject2);
      i = paramBundle.size();
      if (i > 0)
      {
        localObject1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, "TimeOut");
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject1, i * 10000);
        awiw.b(jdField_a_of_type_JavaLangString, "doOnCreate", "send delayed Message:MSG_CANCLE_PROGRESS, delayTime = " + i * 5000);
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, localRemoteException.getMessage());
        }
        localRemoteException.printStackTrace();
      }
    }
    this.b = System.nanoTime();
    awiw.a(jdField_a_of_type_JavaLangString, "initPicUploadInfos", "  totalCount:" + paramBundle.size());
    setCanLock(false);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    Looper.myQueue().removeIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
    getIntent().removeExtra("PhotoConst.SEND_BUSINESS_TYPE");
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "doOnDestroy ," + this);
    }
    b();
    isUnLockSuccess = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "doOnResume 1,mSend = " + this.jdField_a_of_type_Boolean + "," + this);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      Looper.myQueue().addIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 500L);
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "doOnResume 2,mSend = " + this.jdField_a_of_type_Boolean + "," + this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SendPhotoActivity
 * JD-Core Version:    0.7.0.1
 */