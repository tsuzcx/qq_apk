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
  protected BaseActivity a;
  protected QQAppInterface b;
  protected QQCustomDialog c;
  protected ArrayList<SendMultiPictureHelper.SendingFileInfo> d;
  protected int e = 0;
  protected int f = 0;
  protected SendMultiPictureHelper.SendingFileInfo g;
  protected String h;
  protected String i;
  protected String j;
  protected int k;
  protected boolean l = false;
  protected boolean m = false;
  protected Bundle n;
  protected String o;
  protected boolean p;
  protected boolean q = true;
  protected boolean r = false;
  protected boolean s = false;
  INetEventHandler t = null;
  List<FileManagerEntity> u = null;
  FMObserver v = new SendMultiPictureHelper.2(this);
  DialogInterface.OnClickListener w = new SendMultiPictureHelper.3(this);
  DialogInterface.OnClickListener x = new SendMultiPictureHelper.4(this);
  DialogInterface.OnClickListener y = new SendMultiPictureHelper.5(this);
  private TransProcessorHandler z = new SendMultiPictureHelper.1(this);
  
  public SendMultiPictureHelper(BaseActivity paramBaseActivity)
  {
    this.a = paramBaseActivity;
    this.b = ((QQAppInterface)this.a.getAppRuntime());
    this.o = this.a.getString(2131916273);
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
        str = ImageUtil.b(this.a, paramString1, paramInt);
        ImageInfo localImageInfo = new ImageInfo();
        ImageUtil.a(4, this.a, paramString1, str, true, localImageInfo, paramInt);
        str = localImageInfo.f;
      }
      if (!ImageUtil.a(null, str, 1, null, "SendMultiPictureHelper.doSendPictues")) {
        return 0L;
      }
      long l1 = a(str, paramString2, paramString3, paramInt);
      a(paramInt, paramString3, str, l1, 1009);
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("ChatActivity.handleForwardData uploadImage,uniseq:");
        paramString1.append(l1);
        paramString1.append(",filePath:");
        paramString1.append(str);
        paramString1.append(",curType:");
        paramString1.append(paramInt);
        QLog.d("streamptt", 2, paramString1.toString());
      }
      return l1;
    }
    return 0L;
  }
  
  private long a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (paramString1 != null)
    {
      paramString2 = MessageRecordFactory.a(this.b, paramString3, paramString2, paramInt);
      paramString2.path = paramString1;
      paramString2.size = 0L;
      paramString2.type = 1;
      paramString2.isRead = true;
      paramString2.localUUID = PicReq.a();
      paramString2.md5 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString2.path));
      paramString2.serial();
      this.b.getMessageFacade().a(paramString2, this.b.getCurrentAccountUin());
      return paramString2.uniseq;
    }
    return 0L;
  }
  
  private void a(int paramInt, String paramString, long paramLong)
  {
    ITransFileController localITransFileController = (ITransFileController)this.b.getRuntimeService(ITransFileController.class);
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
    localTransferRequest.mSelfUin = this.b.getAccount();
    localTransferRequest.mPeerUin = paramString1;
    localTransferRequest.mUinType = paramInt1;
    localTransferRequest.mFileType = 1;
    localTransferRequest.mUniseq = paramLong;
    localTransferRequest.mIsUp = true;
    localTransferRequest.mBusiType = paramInt2;
    localTransferRequest.mLocalPath = paramString2;
    ((ITransFileController)this.b.getRuntimeService(ITransFileController.class)).transferAsync(localTransferRequest);
  }
  
  private void e()
  {
    Object localObject = (ITransFileController)this.b.getRuntimeService(ITransFileController.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.h);
    localStringBuilder.append(this.g.b);
    localObject = (BaseTransProcessor)((ITransFileController)localObject).findProcessor(localStringBuilder.toString());
    if (localObject != null)
    {
      if (this.r)
      {
        this.r = false;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.h);
        localStringBuilder.append(this.g.b);
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
      ((StringBuilder)localObject).append(this.h);
      ((StringBuilder)localObject).append(this.g.b);
      QLog.w("SendMultiPictureHelper", 2, ((StringBuilder)localObject).toString());
      return;
    }
    QLog.w("SendMultiPictureHelper", 2, "processor null");
    if (this.r) {
      a();
    }
    this.r = false;
  }
  
  private void f()
  {
    if (this.g.b == -1L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendMultiPictureHelper", 2, "uniseq -1");
      }
      return;
    }
    Object localObject = (ITransFileController)this.b.getRuntimeService(ITransFileController.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.h);
    localStringBuilder.append(this.g.b);
    localObject = (BaseTransProcessor)((ITransFileController)localObject).findProcessor(localStringBuilder.toString());
    if (localObject != null)
    {
      ((BaseTransProcessor)localObject).stop();
      localObject = (ITransFileController)this.b.getRuntimeService(ITransFileController.class);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.h);
      localStringBuilder.append(this.g.b);
      ((ITransFileController)localObject).removeProcessor(localStringBuilder.toString());
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("stop send ");
        ((StringBuilder)localObject).append(this.h);
        ((StringBuilder)localObject).append(this.g.b);
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
    synchronized (this.d)
    {
      if (this.d.size() > 0) {
        this.d.remove(0);
      }
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("sendNext ");
        ((StringBuilder)localObject1).append(this.e + 1);
        QLog.e("SendMultiPictureHelper", 2, ((StringBuilder)localObject1).toString());
      }
      this.e += 1;
      if (this.d.size() > 0)
      {
        Object localObject3 = (SendMultiPictureHelper.SendingFileInfo)this.d.get(0);
        localObject1 = ((SendMultiPictureHelper.SendingFileInfo)localObject3).a;
        this.g = ((SendMultiPictureHelper.SendingFileInfo)localObject3);
        localObject1 = new File((String)localObject1);
        if (!((File)localObject1).exists())
        {
          this.r = true;
          localObject3 = BaseApplicationImpl.getApplication();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(((File)localObject1).getName());
          localStringBuilder.append(HardCodeUtil.a(2131911245));
          Toast.makeText((Context)localObject3, localStringBuilder.toString(), 0).show();
          if (!this.m) {
            a();
          }
          return;
        }
        if (((File)localObject1).length() == 0L) {
          if (this.k == 0) {
            Toast.makeText(BaseApplicationImpl.getApplication(), this.a.getString(2131889400), 0).show();
          } else {
            Toast.makeText(BaseApplicationImpl.getApplication(), this.a.getString(2131892596), 0).show();
          }
        }
        a((SendMultiPictureHelper.SendingFileInfo)localObject3, this.k, this.i, this.h);
      }
      else
      {
        if (this.c != null) {
          this.c.cancel();
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
    this.h = paramString2;
    this.i = paramString1;
    this.k = paramInt;
    this.j = paramString3;
    this.n = paramBundle;
    paramString2 = this.n;
    paramString1 = Integer.valueOf(0);
    this.p = paramString2.getBoolean("sendMultiple", false);
    ((ITransFileController)this.b.getRuntimeService(ITransFileController.class)).addHandle(this.z);
    this.z.addFilter(new Class[] { BuddyTransfileProcessor.class, ((IPicTransFile)this.b.getRuntimeService(IPicTransFile.class)).getC2CUploadProClass(), ((IPicTransFile)this.b.getRuntimeService(IPicTransFile.class)).getGroupUploadProClass(), ForwardImageProcessor.class });
    paramString2 = this.a;
    this.c = DialogUtil.a(paramString2, 230, this.j, paramString2.getString(2131888019), null, this.w);
    this.c.setCanceledOnTouchOutside(false);
    this.c.setCancelable(false);
    this.c.show();
    this.d = new ArrayList();
    paramString2 = paramArrayList.iterator();
    while (paramString2.hasNext())
    {
      paramString3 = (String)paramString2.next();
      paramBundle = new SendMultiPictureHelper.SendingFileInfo(this);
      paramBundle.a = paramString3;
      paramBundle.b = -1L;
      this.d.add(paramBundle);
    }
    paramString2 = ((SendMultiPictureHelper.SendingFileInfo)this.d.get(0)).a;
    this.f = this.d.size();
    this.g = ((SendMultiPictureHelper.SendingFileInfo)this.d.get(0));
    this.e = 0;
    if (!NetworkUtil.isNetSupport(this.a))
    {
      this.s = true;
      this.b.getFileManagerNotifyCenter().deleteObserver(this.v);
      int i1;
      for (paramInt = 0; paramInt < this.d.size(); paramInt = i1)
      {
        paramString2 = this.c;
        paramString3 = this.o;
        i1 = paramInt + 1;
        paramString2.setMessage(String.format(paramString3, new Object[] { Integer.valueOf(i1), Integer.valueOf(this.f), paramString1 }));
        a((SendMultiPictureHelper.SendingFileInfo)this.d.get(paramInt), this.k, this.i, this.h);
      }
      c();
      return;
    }
    this.c.setMessage(String.format(this.o, new Object[] { Integer.valueOf(1), Integer.valueOf(this.f), paramString1 }));
    if (new File(paramString2).length() == 0L) {
      if (this.k == 0) {
        Toast.makeText(BaseApplicationImpl.getApplication(), this.a.getString(2131889400), 0).show();
      } else {
        Toast.makeText(BaseApplicationImpl.getApplication(), this.a.getString(2131892596), 0).show();
      }
    }
    a((SendMultiPictureHelper.SendingFileInfo)this.d.get(0), this.k, this.i, this.h);
    if (this.t == null) {
      this.t = new SendMultiPictureHelper.6(this);
    }
    AppNetConnInfo.registerNetChangeReceiver(this.a, this.t);
  }
  
  void b()
  {
    Object localObject = this.a.getString(2131888020);
    BaseActivity localBaseActivity = this.a;
    localObject = DialogUtil.a(localBaseActivity, 230, localBaseActivity.getString(2131917233), (String)localObject, 2131890045, 2131892140, this.y, this.x);
    ((QQCustomDialog)localObject).setCancelable(false);
    ((QQCustomDialog)localObject).show();
  }
  
  void c()
  {
    if ((this.p) && (!this.q)) {
      return;
    }
    Intent localIntent = AIOUtils.a(new Intent(this.a, SplashActivity.class), new int[] { 2 });
    localIntent.putExtra("isFromShare", true);
    localIntent.putExtras(this.n);
    if (this.p)
    {
      localIntent.putExtra("open_chatfragment", false);
      if (localIntent.getBooleanExtra("is_need_show_toast", true)) {
        ForwardUtils.a(this.b, 500L);
      }
      this.q = false;
    }
    this.a.startActivity(localIntent);
    this.a.setResult(-1);
    this.a.finish();
  }
  
  public void d()
  {
    ((ITransFileController)this.b.getRuntimeService(ITransFileController.class)).removeHandle(this.z);
    this.b.getFileManagerNotifyCenter().deleteObserver(this.v);
    try
    {
      this.c.dismiss();
      label42:
      this.c = null;
      Object localObject = this.t;
      if (localObject != null) {
        AppNetConnInfo.unregisterNetEventHandler((INetEventHandler)localObject);
      }
      localObject = this.d;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SendMultiPictureHelper
 * JD-Core Version:    0.7.0.1
 */