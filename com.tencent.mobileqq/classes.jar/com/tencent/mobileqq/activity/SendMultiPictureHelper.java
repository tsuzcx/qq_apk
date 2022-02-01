package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.api.IPicTransFile;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.ForwardImageProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class SendMultiPictureHelper
{
  protected int a;
  DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new SendMultiPictureHelper.3(this);
  protected Bundle a;
  protected SendMultiPictureHelper.SendingFileInfo a;
  protected BaseActivity a;
  protected QQAppInterface a;
  FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new SendMultiPictureHelper.2(this);
  INetEventHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = null;
  private TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new SendMultiPictureHelper.1(this);
  protected QQCustomDialog a;
  protected String a;
  protected ArrayList<SendMultiPictureHelper.SendingFileInfo> a;
  List<FileManagerEntity> jdField_a_of_type_JavaUtilList = null;
  protected boolean a;
  protected int b;
  DialogInterface.OnClickListener b;
  protected String b;
  protected boolean b;
  protected int c;
  DialogInterface.OnClickListener c;
  protected String c;
  protected boolean c;
  protected String d;
  protected boolean d;
  protected boolean e = false;
  protected boolean f = false;
  
  public SendMultiPictureHelper(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new SendMultiPictureHelper.4(this);
    this.jdField_c_of_type_AndroidContentDialogInterface$OnClickListener = new SendMultiPictureHelper.5(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime());
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131718767);
  }
  
  private long a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (FileUtils.fileExists(paramString1))
    {
      String str;
      if ((paramInt != 1) && (paramInt != 0) && (paramInt != 1001) && (paramInt != 10002))
      {
        str = paramString1;
        if (paramInt != 3000) {}
      }
      else
      {
        ImageUtil.a(-1L, paramInt, true, "compress_start", "SendMultiPictureHelper.doSendPictues");
        str = ImageUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString1, paramInt);
        ImageInfo localImageInfo = new ImageInfo();
        ImageUtil.a(4, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString1, str, true, localImageInfo, paramInt);
        str = localImageInfo.jdField_b_of_type_JavaLangString;
      }
      if (!ImageUtil.a(null, str, 1, null, "SendMultiPictureHelper.doSendPictues")) {
        return 0L;
      }
      long l = a(str, paramString2, paramString3, paramInt);
      a(paramInt, paramString3, str, l, 1009);
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("ChatActivity.handleForwardData uploadImage,uniseq:");
        paramString1.append(l);
        paramString1.append(",filePath:");
        paramString1.append(str);
        paramString1.append(",curType:");
        paramString1.append(paramInt);
        QLog.d("streamptt", 2, paramString1.toString());
      }
      return l;
    }
    return 0L;
  }
  
  private long a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (paramString1 != null)
    {
      paramString2 = MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString3, paramString2, paramInt);
      paramString2.path = paramString1;
      paramString2.size = 0L;
      paramString2.type = 1;
      paramString2.isRead = true;
      paramString2.localUUID = PicReq.a();
      paramString2.md5 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString2.path));
      paramString2.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      return paramString2.uniseq;
    }
    return 0L;
  }
  
  private void a(int paramInt, String paramString, long paramLong)
  {
    ITransFileController localITransFileController = (ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(paramLong);
    paramString = localITransFileController.findProcessor(localStringBuilder.toString());
    if ((paramString instanceof BaseTransProcessor)) {
      ((BaseTransProcessor)paramString).pause();
    }
  }
  
  private void a(int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2)
  {
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mSelfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localTransferRequest.mPeerUin = paramString1;
    localTransferRequest.mUinType = paramInt1;
    localTransferRequest.mFileType = 1;
    localTransferRequest.mUniseq = paramLong;
    localTransferRequest.mIsUp = true;
    localTransferRequest.mBusiType = paramInt2;
    localTransferRequest.mLocalPath = paramString2;
    ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(localTransferRequest);
  }
  
  private void e()
  {
    Object localObject = (ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper$SendingFileInfo.jdField_a_of_type_Long);
    localObject = (BaseTransProcessor)((ITransFileController)localObject).findProcessor(localStringBuilder.toString());
    if (localObject != null)
    {
      if (this.e)
      {
        this.e = false;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper$SendingFileInfo.jdField_a_of_type_Long);
        localStringBuilder.append("has error");
        QLog.w("SendMultiPictureHelper", 2, localStringBuilder.toString());
        ((BaseTransProcessor)localObject).stop();
        a();
      }
      else
      {
        ((BaseTransProcessor)localObject).resume();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("continue send ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper$SendingFileInfo.jdField_a_of_type_Long);
      QLog.w("SendMultiPictureHelper", 2, ((StringBuilder)localObject).toString());
      return;
    }
    QLog.w("SendMultiPictureHelper", 2, "processor null");
    if (this.e) {
      a();
    }
    this.e = false;
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper$SendingFileInfo.jdField_a_of_type_Long == -1L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendMultiPictureHelper", 2, "uniseq -1");
      }
      return;
    }
    Object localObject = (ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper$SendingFileInfo.jdField_a_of_type_Long);
    localObject = (BaseTransProcessor)((ITransFileController)localObject).findProcessor(localStringBuilder.toString());
    if (localObject != null)
    {
      ((BaseTransProcessor)localObject).stop();
      localObject = (ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper$SendingFileInfo.jdField_a_of_type_Long);
      ((ITransFileController)localObject).removeProcessor(localStringBuilder.toString());
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("stop send ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper$SendingFileInfo.jdField_a_of_type_Long);
        QLog.d("SendMultiPictureHelper", 2, ((StringBuilder)localObject).toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("SendMultiPictureHelper", 2, "processor null");
    }
  }
  
  private void g() {}
  
  void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        this.jdField_a_of_type_JavaUtilArrayList.remove(0);
      }
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("sendNext ");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int + 1);
        QLog.e("SendMultiPictureHelper", 2, ((StringBuilder)localObject1).toString());
      }
      this.jdField_a_of_type_Int += 1;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        Object localObject3 = (SendMultiPictureHelper.SendingFileInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        localObject1 = ((SendMultiPictureHelper.SendingFileInfo)localObject3).jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper$SendingFileInfo = ((SendMultiPictureHelper.SendingFileInfo)localObject3);
        localObject1 = new File((String)localObject1);
        if (!((File)localObject1).exists())
        {
          this.e = true;
          localObject3 = BaseApplicationImpl.getApplication();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(((File)localObject1).getName());
          localStringBuilder.append(HardCodeUtil.a(2131713702));
          Toast.makeText((Context)localObject3, localStringBuilder.toString(), 0).show();
          if (!this.jdField_b_of_type_Boolean) {
            a();
          }
          return;
        }
        if (((File)localObject1).length() == 0L) {
          if (this.jdField_c_of_type_Int == 0) {
            Toast.makeText(BaseApplicationImpl.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692412), 0).show();
          } else {
            Toast.makeText(BaseApplicationImpl.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131694892), 0).show();
          }
        }
        a((SendMultiPictureHelper.SendingFileInfo)localObject3, this.jdField_c_of_type_Int, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
        }
        c();
      }
      return;
    }
  }
  
  void a(SendMultiPictureHelper.SendingFileInfo paramSendingFileInfo, int paramInt, String paramString1, String paramString2)
  {
    ThreadManager.getFileThreadHandler().post(new SendMultiPictureHelper.7(this, paramSendingFileInfo, paramInt, paramString1, paramString2));
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3, Bundle paramBundle, ArrayList<String> paramArrayList)
  {
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    paramString2 = this.jdField_a_of_type_AndroidOsBundle;
    paramString1 = Integer.valueOf(0);
    this.jdField_c_of_type_Boolean = paramString2.getBoolean("sendMultiple", false);
    ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).addHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { BuddyTransfileProcessor.class, ((IPicTransFile)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPicTransFile.class)).getC2CUploadProClass(), ((IPicTransFile)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPicTransFile.class)).getGroupUploadProClass(), ForwardImageProcessor.class });
    paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(paramString2, 230, this.jdField_c_of_type_JavaLangString, paramString2.getString(2131691073), null, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    paramString2 = paramArrayList.iterator();
    while (paramString2.hasNext())
    {
      paramString3 = (String)paramString2.next();
      paramBundle = new SendMultiPictureHelper.SendingFileInfo(this);
      paramBundle.jdField_a_of_type_JavaLangString = paramString3;
      paramBundle.jdField_a_of_type_Long = -1L;
      this.jdField_a_of_type_JavaUtilArrayList.add(paramBundle);
    }
    paramString2 = ((SendMultiPictureHelper.SendingFileInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaUtilArrayList.size();
    this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper$SendingFileInfo = ((SendMultiPictureHelper.SendingFileInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
    this.jdField_a_of_type_Int = 0;
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      this.f = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
      int i;
      for (paramInt = 0; paramInt < this.jdField_a_of_type_JavaUtilArrayList.size(); paramInt = i)
      {
        paramString2 = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
        paramString3 = this.jdField_d_of_type_JavaLangString;
        i = paramInt + 1;
        paramString2.setMessage(String.format(paramString3, new Object[] { Integer.valueOf(i), Integer.valueOf(this.jdField_b_of_type_Int), paramString1 }));
        a((SendMultiPictureHelper.SendingFileInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), this.jdField_c_of_type_Int, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
      }
      c();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(String.format(this.jdField_d_of_type_JavaLangString, new Object[] { Integer.valueOf(1), Integer.valueOf(this.jdField_b_of_type_Int), paramString1 }));
    if (new File(paramString2).length() == 0L) {
      if (this.jdField_c_of_type_Int == 0) {
        Toast.makeText(BaseApplicationImpl.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692412), 0).show();
      } else {
        Toast.makeText(BaseApplicationImpl.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131694892), 0).show();
      }
    }
    a((SendMultiPictureHelper.SendingFileInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0), this.jdField_c_of_type_Int, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler == null) {
      this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new SendMultiPictureHelper.6(this);
    }
    AppNetConnInfo.registerNetChangeReceiver(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
  }
  
  void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691074);
    BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    localObject = DialogUtil.a(localBaseActivity, 230, localBaseActivity.getString(2131719632), (String)localObject, 2131692932, 2131694460, this.jdField_c_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener);
    ((QQCustomDialog)localObject).setCancelable(false);
    ((QQCustomDialog)localObject).show();
  }
  
  void c()
  {
    if ((this.jdField_c_of_type_Boolean) && (!this.jdField_d_of_type_Boolean)) {
      return;
    }
    Intent localIntent = AIOUtils.a(new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, SplashActivity.class), new int[] { 2 });
    localIntent.putExtra("isFromShare", true);
    localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    if (this.jdField_c_of_type_Boolean)
    {
      localIntent.putExtra("open_chatfragment", false);
      if (localIntent.getBooleanExtra("is_need_show_toast", true)) {
        ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 500L);
      }
      this.jdField_d_of_type_Boolean = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(-1);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
  }
  
  public void d()
  {
    ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).removeHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      label42:
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler;
      if (localObject != null) {
        AppNetConnInfo.unregisterNetEventHandler((INetEventHandler)localObject);
      }
      localObject = this.jdField_a_of_type_JavaUtilArrayList;
      if (localObject != null) {
        ((ArrayList)localObject).clear();
      }
      return;
    }
    catch (Exception localException)
    {
      break label42;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SendMultiPictureHelper
 * JD-Core Version:    0.7.0.1
 */