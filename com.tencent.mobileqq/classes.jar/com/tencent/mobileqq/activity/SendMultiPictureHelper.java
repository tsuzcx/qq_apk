package com.tencent.mobileqq.activity;

import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor;
import com.tencent.mobileqq.transfile.ForwardImageProcessor;
import com.tencent.mobileqq.transfile.GroupPicUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
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
import tok;
import tol;
import tom;
import ton;
import too;
import top;
import tor;

public class SendMultiPictureHelper
{
  public int a;
  DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new tom(this);
  protected Bundle a;
  protected SendMultiPictureHelper.SendingFileInfo a;
  public BaseActivity a;
  public QQAppInterface a;
  public FMObserver a;
  INetEventHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = null;
  private TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new tok(this);
  public QQCustomDialog a;
  public String a;
  public ArrayList a;
  public List a;
  public boolean a;
  public int b;
  DialogInterface.OnClickListener b;
  public String b;
  public boolean b;
  public int c;
  DialogInterface.OnClickListener c;
  protected String c;
  public boolean c;
  public String d;
  public boolean d;
  
  public SendMultiPictureHelper(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new tol(this);
    this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new ton(this);
    this.jdField_c_of_type_AndroidContentDialogInterface$OnClickListener = new too(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime());
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131436124);
  }
  
  private long a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (FileUtils.a(paramString1))
    {
      if ((paramInt != 1) && (paramInt != 0) && (paramInt != 1001) && (paramInt != 10002) && (paramInt != 3000)) {
        break label192;
      }
      ImageUtil.a(-1L, paramInt, true, "compress_start", "SendMultiPictureHelper.doSendPictues");
      String str = ImageUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString1, paramInt);
      ImageInfo localImageInfo = new ImageInfo();
      ImageUtil.a(4, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString1, str, true, localImageInfo, paramInt);
      paramString1 = localImageInfo.jdField_b_of_type_JavaLangString;
    }
    label192:
    for (;;)
    {
      long l1;
      if (!ImageUtil.a(null, paramString1, 1, null, "SendMultiPictureHelper.doSendPictues")) {
        l1 = 0L;
      }
      long l2;
      do
      {
        return l1;
        l2 = a(paramString1, paramString2, paramString3, paramInt);
        a(paramInt, paramString3, paramString1, l2, 1009);
        l1 = l2;
      } while (!QLog.isColorLevel());
      QLog.d("streamptt", 2, "ChatActivity.handleForwardData uploadImage,uniseq:" + l2 + ",filePath:" + paramString1 + ",curType:" + paramInt);
      return l2;
      return 0L;
    }
  }
  
  private long a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    long l = 0L;
    if (paramString1 != null)
    {
      paramString2 = MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString3, paramString2, paramInt);
      paramString2.path = paramString1;
      paramString2.size = 0L;
      paramString2.type = 1;
      paramString2.isRead = true;
      paramString2.localUUID = PicReq.a();
      paramString2.md5 = HexUtil.a(MD5.getFileMd5(paramString2.path));
      paramString2.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      l = paramString2.uniseq;
    }
    return l;
  }
  
  private void a(int paramInt, String paramString, long paramLong)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString + paramLong);
    if ((paramString instanceof BaseTransProcessor)) {
      ((BaseTransProcessor)paramString).c();
    }
  }
  
  private void a(int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2)
  {
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localTransferRequest.jdField_c_of_type_JavaLangString = paramString1;
    localTransferRequest.jdField_a_of_type_Int = paramInt1;
    localTransferRequest.jdField_b_of_type_Int = 1;
    localTransferRequest.jdField_a_of_type_Long = paramLong;
    localTransferRequest.jdField_a_of_type_Boolean = true;
    localTransferRequest.e = paramInt2;
    localTransferRequest.i = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localTransferRequest);
  }
  
  private void e()
  {
    BaseTransProcessor localBaseTransProcessor = (BaseTransProcessor)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper$SendingFileInfo.jdField_a_of_type_Long);
    if (localBaseTransProcessor != null)
    {
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_Boolean = false;
        QLog.w("SendMultiPictureHelper", 2, this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper$SendingFileInfo.jdField_a_of_type_Long + "has error");
        localBaseTransProcessor.h();
        a();
      }
      for (;;)
      {
        QLog.w("SendMultiPictureHelper", 2, "continue send " + this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper$SendingFileInfo.jdField_a_of_type_Long);
        return;
        localBaseTransProcessor.b();
      }
    }
    QLog.w("SendMultiPictureHelper", 2, "processor null");
    if (this.jdField_c_of_type_Boolean) {
      a();
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper$SendingFileInfo.jdField_a_of_type_Long == -1L) {
      if (QLog.isColorLevel()) {
        QLog.d("SendMultiPictureHelper", 2, "uniseq -1");
      }
    }
    do
    {
      do
      {
        return;
        BaseTransProcessor localBaseTransProcessor = (BaseTransProcessor)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper$SendingFileInfo.jdField_a_of_type_Long);
        if (localBaseTransProcessor == null) {
          break;
        }
        localBaseTransProcessor.h();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper$SendingFileInfo.jdField_a_of_type_Long);
      } while (!QLog.isColorLevel());
      QLog.d("SendMultiPictureHelper", 2, "stop send " + this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper$SendingFileInfo.jdField_a_of_type_Long);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("SendMultiPictureHelper", 2, "processor null");
  }
  
  private void g() {}
  
  public void a()
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
          this.jdField_a_of_type_JavaUtilArrayList.remove(0);
        }
        if (QLog.isColorLevel()) {
          QLog.e("SendMultiPictureHelper", 2, "sendNext " + (this.jdField_a_of_type_Int + 1));
        }
        this.jdField_a_of_type_Int += 1;
        if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
          break label258;
        }
        SendMultiPictureHelper.SendingFileInfo localSendingFileInfo = (SendMultiPictureHelper.SendingFileInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        Object localObject2 = localSendingFileInfo.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper$SendingFileInfo = localSendingFileInfo;
        localObject2 = new File((String)localObject2);
        if (!((File)localObject2).exists())
        {
          this.jdField_c_of_type_Boolean = true;
          Toast.makeText(BaseApplicationImpl.getApplication(), ((File)localObject2).getName() + "发送失败，己被移动或删除！", 0).show();
          if (!this.jdField_b_of_type_Boolean) {
            a();
          }
          return;
        }
        if (((File)localObject2).length() == 0L)
        {
          if (this.jdField_c_of_type_Int == 0) {
            Toast.makeText(BaseApplicationImpl.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131436270), 0).show();
          }
        }
        else
        {
          a(localSendingFileInfo, this.jdField_c_of_type_Int, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
          return;
        }
      }
      Toast.makeText(BaseApplicationImpl.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131436273), 0).show();
      continue;
      label258:
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
      }
      c();
    }
  }
  
  public void a(SendMultiPictureHelper.SendingFileInfo paramSendingFileInfo, int paramInt, String paramString1, String paramString2)
  {
    ThreadManager.getFileThreadHandler().post(new tor(this, paramSendingFileInfo, paramInt, paramString1, paramString2));
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3, Bundle paramBundle, ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.a(new Class[] { BuddyTransfileProcessor.class, C2CPicUploadProcessor.class, GroupPicUploadProcessor.class, ForwardImageProcessor.class });
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131436127), null, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    paramString1 = paramArrayList.iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (String)paramString1.next();
      paramString3 = new SendMultiPictureHelper.SendingFileInfo(this);
      paramString3.jdField_a_of_type_JavaLangString = paramString2;
      paramString3.jdField_a_of_type_Long = -1L;
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString3);
    }
    paramString1 = ((SendMultiPictureHelper.SendingFileInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaUtilArrayList.size();
    this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper$SendingFileInfo = ((SendMultiPictureHelper.SendingFileInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
    this.jdField_a_of_type_Int = 0;
    if (!NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      this.jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
      paramInt = 0;
      while (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(String.format(this.jdField_d_of_type_JavaLangString, new Object[] { Integer.valueOf(paramInt + 1), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(0) }));
        a((SendMultiPictureHelper.SendingFileInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), this.jdField_c_of_type_Int, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
        paramInt += 1;
      }
      c();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(String.format(this.jdField_d_of_type_JavaLangString, new Object[] { Integer.valueOf(1), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(0) }));
    if (new File(paramString1).length() == 0L)
    {
      if (this.jdField_c_of_type_Int != 0) {
        break label521;
      }
      Toast.makeText(BaseApplicationImpl.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131436270), 0).show();
    }
    for (;;)
    {
      a((SendMultiPictureHelper.SendingFileInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0), this.jdField_c_of_type_Int, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new top(this);
      }
      AppNetConnInfo.registerNetChangeReceiver(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
      return;
      label521:
      Toast.makeText(BaseApplicationImpl.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131436273), 0).show();
    }
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131436125);
    localObject = DialogUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131434764), (String)localObject, 2131436276, 2131432995, this.jdField_c_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener);
    ((QQCustomDialog)localObject).setCancelable(false);
    ((QQCustomDialog)localObject).show();
  }
  
  public void c()
  {
    Intent localIntent = AIOUtils.a(new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, SplashActivity.class), new int[] { 2 });
    localIntent.putExtra("isFromShare", true);
    localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(-1);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      label35:
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
      if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler != null) {
        AppNetConnInfo.unregisterNetEventHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
      }
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      return;
    }
    catch (Exception localException)
    {
      break label35;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SendMultiPictureHelper
 * JD-Core Version:    0.7.0.1
 */