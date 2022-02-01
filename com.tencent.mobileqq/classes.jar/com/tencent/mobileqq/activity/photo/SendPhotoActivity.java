package com.tencent.mobileqq.activity.photo;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PresendPicMgrService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.receipt.ReceiptMsgManager;
import com.tencent.mobileqq.transfile.BaseUploadProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.FolderUtils;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import com.tencent.util.AutoSaveUtils;
import com.tencent.util.BinderWarpper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.pic.CompressInfo;>;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class SendPhotoActivity
  extends BaseActivity
{
  public static final String a = "com.tencent.mobileqq.activity.photo.SendPhotoActivity";
  long jdField_a_of_type_Long = 0L;
  ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  Handler jdField_a_of_type_AndroidOsHandler = new SendPhotoActivity.MyHandler(this, this);
  MessageQueue.IdleHandler jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new SendPhotoActivity.1(this);
  Messenger jdField_a_of_type_AndroidOsMessenger;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  SendPhotoTask jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoTask;
  boolean jdField_a_of_type_Boolean = false;
  long b;
  
  static void a()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject1).append("photo/");
    ((StringBuilder)localObject1).append(".nomedia");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject2).append("thumb/");
    ((StringBuilder)localObject2).append(".nomedia");
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject3).append("thumb2/");
    ((StringBuilder)localObject3).append(".nomedia");
    localObject3 = ((StringBuilder)localObject3).toString();
    FileUtils.createFileIfNotExits((String)localObject1);
    FileUtils.createFileIfNotExits((String)localObject2);
    FileUtils.createFileIfNotExits((String)localObject3);
  }
  
  public static void a(Context paramContext, List<CompressInfo> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      int i = paramList.size();
      int m = 1;
      int k;
      if (i > 1) {
        k = 1;
      } else {
        k = 0;
      }
      String str1 = BaseApplication.getContext().getString(2131691038);
      String str2 = BaseApplication.getContext().getString(2131691039);
      String str3 = BaseApplication.getContext().getString(2131691034);
      String str4 = BaseApplication.getContext().getString(2131691035);
      String str5 = BaseApplication.getContext().getString(2131691036);
      String str6 = BaseApplication.getContext().getString(2131691037);
      Object localObject1 = BaseApplication.getContext().getString(2131691041);
      Object localObject2 = BaseApplication.getContext().getString(2131691042);
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        CompressInfo localCompressInfo = (CompressInfo)localIterator.next();
        if ((localCompressInfo != null) && (localCompressInfo.c))
        {
          if (k != 0) {
            localObject1 = localObject2;
          }
          i = 1;
          break label181;
        }
      }
      localObject1 = "";
      i = 0;
      label181:
      int j = i;
      if (i == 0)
      {
        paramList = paramList.iterator();
        do
        {
          for (;;)
          {
            j = i;
            if (!paramList.hasNext()) {
              break label390;
            }
            localObject2 = (CompressInfo)paramList.next();
            if ((localObject2 == null) || (((CompressInfo)localObject2).e) || (!((CompressInfo)localObject2).jdField_b_of_type_Boolean)) {
              break;
            }
            if (str3.equals(((CompressInfo)localObject2).jdField_b_of_type_JavaLangString))
            {
              i = m;
              paramList = (List<CompressInfo>)localObject1;
              if (str3.equals(localObject1)) {
                break label395;
              }
              if (k != 0)
              {
                paramList = str4;
                i = m;
                break label395;
              }
              paramList = str3;
              i = m;
              break label395;
            }
            if (str1.equals(((CompressInfo)localObject2).jdField_b_of_type_JavaLangString))
            {
              i = m;
              paramList = (List<CompressInfo>)localObject1;
              if (str1.equals(localObject1)) {
                break label395;
              }
              if (k != 0)
              {
                paramList = str2;
                i = m;
                break label395;
              }
              paramList = str1;
              i = m;
              break label395;
            }
            i = 1;
          }
        } while ((localObject2 == null) || (!((CompressInfo)localObject2).e) || (!((CompressInfo)localObject2).jdField_b_of_type_Boolean));
        if (k != 0)
        {
          paramList = str6;
          i = m;
        }
        else
        {
          paramList = str5;
          i = m;
        }
      }
      else
      {
        label390:
        i = j;
        paramList = (List<CompressInfo>)localObject1;
      }
      label395:
      if (i != 0) {
        QQToast.a(paramContext, paramList, 0).b(paramContext.getResources().getDimensionPixelSize(2131299168));
      }
    }
  }
  
  private static void b(BaseActivity paramBaseActivity, ArrayList<String> paramArrayList)
  {
    if (paramBaseActivity == null) {
      return;
    }
    Object localObject1 = paramBaseActivity.getIntent();
    int j = 0;
    int k = ((Intent)localObject1).getIntExtra("uintype", 0);
    ArrayList localArrayList;
    int i;
    if (k == 1008)
    {
      localArrayList = new ArrayList();
      Object localObject2 = paramBaseActivity.getClass().getSimpleName();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[report]Send Picture count=");
      localStringBuilder.append(paramArrayList.size());
      QLog.d((String)localObject2, 2, localStringBuilder.toString());
      i = 0;
      while (i < paramArrayList.size())
      {
        localArrayList.add(MD5FileUtil.a((String)paramArrayList.get(i)));
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[report] picture ");
        localStringBuilder.append(i);
        localStringBuilder.append("md5=");
        localStringBuilder.append(MD5FileUtil.a((String)paramArrayList.get(i)));
        localStringBuilder.append(": path=");
        localStringBuilder.append((String)paramArrayList.get(i));
        QLog.d((String)localObject2, 2, localStringBuilder.toString());
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
        PhotoUtils.reportSendSize(paramBaseActivity.app, i, localArrayList);
      }
    }
    localObject1 = ((Intent)localObject1).getStringExtra("uin");
    if ((localObject1 != null) && (k == 1008) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isMediaAndOtherSubscript(paramBaseActivity.app, (String)localObject1)))
    {
      i = j;
      while (i < paramArrayList.size())
      {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(paramBaseActivity.app, "P_CliOper", "Pb_account_lifeservice", (String)localObject1, "0X8005C9D", "0X8005C9D", 0, 0, "", "", "", "", false);
        i += 1;
      }
    }
  }
  
  void a(int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null)
      {
        b();
      }
      else
      {
        this.jdField_a_of_type_AndroidAppProgressDialog = new ReportProgressDialog(this, 2131756189);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2131559561);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131372646));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
      }
      if (!this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())
      {
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      Logger.b("PIC_TAG_ERROR", "SendPhotoActivity.showProgressDialog", localThrowable.toString());
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    paramQQAppInterface = ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).getProcessMap().entrySet().iterator();
    for (boolean bool = false; paramQQAppInterface.hasNext(); bool = true)
    {
      label27:
      Object localObject = (IHttpCommunicatorListener)((Map.Entry)paramQQAppInterface.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof BaseUploadProcessor))) {
        break label27;
      }
      localObject = (BaseUploadProcessor)localObject;
      if ((((BaseUploadProcessor)localObject).mUiRequest == null) || (!((BaseUploadProcessor)localObject).mUiRequest.mIsPresend)) {
        break label27;
      }
      ((BaseUploadProcessor)localObject).mEnterAioTime = paramLong;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("initAllPSProcessorEnterAioTime ,Processor:");
        localStringBuilder.append(localObject);
        localStringBuilder.append(",time = ");
        localStringBuilder.append(paramLong);
        QLog.d("PresendPicReport", 2, localStringBuilder.toString());
      }
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("initAllPSProcessorEnterAioTime result:");
      paramQQAppInterface.append(bool);
      QLog.d("PresendPicReport", 2, paramQQAppInterface.toString());
    }
    return bool;
  }
  
  void b()
  {
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("TestPicSend finish compress,currentTime = ");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = this.jdField_a_of_type_AndroidAppProgressDialog;
    if ((localObject != null) && (((ProgressDialog)localObject).isShowing())) {
      this.jdField_a_of_type_AndroidAppProgressDialog.cancel();
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 102))
    {
      super.setResult(paramInt2, paramIntent);
      super.finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = true;
    super.doOnCreate(paramBundle);
    ThreadManager.executeOnFileThread(FolderUtils.a);
    Object localObject1 = getIntent();
    paramBundle = ((Intent)localObject1).getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if (paramBundle == null)
    {
      Logger.b(jdField_a_of_type_JavaLangString, "initPicUploadInfos", "paths is null");
      finish();
      return true;
    }
    AutoSaveUtils.a(true, paramBundle);
    int i;
    if (((Intent)localObject1).getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false))
    {
      localObject2 = (SessionInfo)((Intent)localObject1).getParcelableExtra("session_info");
      i = ((Intent)localObject1).getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0);
      if (localObject2 != null) {
        ReceiptMsgManager.a().a(this.app, (SessionInfo)localObject2, paramBundle, i);
      }
      setResult(-1, getIntent());
      finish();
    }
    Object localObject3;
    if (QLog.isColorLevel())
    {
      localObject2 = jdField_a_of_type_JavaLangString;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("TestPicSend start compress,currentTime = ");
      ((StringBuilder)localObject3).append(System.currentTimeMillis());
      QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
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
        localObject3 = PresendPicMgrService.a();
        if (localObject3 != null) {
          ((PresendPicMgrService)localObject3).a(i, ((Intent)localObject1).getLongExtra("key_qzone_batch_id", 0L), ((Intent)localObject1).getStringExtra("key_qzone_album_id"));
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
          localObject1 = jdField_a_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("send delayed Message:MSG_CANCLE_PROGRESS, delayTime = ");
          ((StringBuilder)localObject2).append(i * 5000);
          Logger.b(localObject1, "doOnCreate", ((StringBuilder)localObject2).toString());
        }
      }
      catch (RemoteException localRemoteException)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, localRemoteException.getMessage());
        }
        localRemoteException.printStackTrace();
      }
      this.b = System.nanoTime();
    }
    String str = jdField_a_of_type_JavaLangString;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("  totalCount:");
    ((StringBuilder)localObject2).append(paramBundle.size());
    Logger.a(str, "initPicUploadInfos", ((StringBuilder)localObject2).toString());
    setCanLock(false);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    Looper.myQueue().removeIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
    getIntent().removeExtra("PhotoConst.SEND_BUSINESS_TYPE");
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnDestroy ,");
      localStringBuilder.append(this);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    b();
    isUnLockSuccess = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnResume 1,mSend = ");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append(",");
      localStringBuilder.append(this);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      Looper.myQueue().addIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 500L);
    }
    if (QLog.isColorLevel())
    {
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnResume 2,mSend = ");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append(",");
      localStringBuilder.append(this);
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SendPhotoActivity
 * JD-Core Version:    0.7.0.1
 */