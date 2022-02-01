import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;

public class asyq
{
  private FileManagerEntity a;
  
  public static asyq a(MessageForFile paramMessageForFile)
  {
    try
    {
      QQAppInterface localQQAppInterface1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface1 == null) {
        throw new NullPointerException("newFileModel entity app null!");
      }
    }
    catch (Exception localException)
    {
      QQAppInterface localQQAppInterface2;
      for (;;)
      {
        localQQAppInterface2 = null;
      }
      return a(aszt.a(localQQAppInterface2, paramMessageForFile));
    }
  }
  
  public static asyq a(FileManagerEntity paramFileManagerEntity)
  {
    asyq localasyq = new asyq();
    if ((paramFileManagerEntity == null) && (QLog.isDevelopLevel())) {
      throw new NullPointerException("newFileModel entity is null!");
    }
    localasyq.a = paramFileManagerEntity;
    return localasyq;
  }
  
  public static asyq a(String paramString)
  {
    try
    {
      paramString = a(aszt.a(new FileInfo(paramString)));
      return paramString;
    }
    catch (FileNotFoundException paramString)
    {
      paramString.printStackTrace();
      if (QLog.isDevelopLevel()) {
        throw new NullPointerException("check localPath");
      }
    }
    return null;
  }
  
  private void a(String paramString1, String paramString2)
  {
    QLog.i("FileModel<FileAssistant>" + paramString1, 1, "Id[" + this.a.nSessionId + "]" + paramString2);
  }
  
  private void b(Activity paramActivity, int paramInt)
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface == null)
      {
        QLog.e("FileModel<FileAssistant>", 1, "Start VideoActivity is not in QQ!");
        return;
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      for (;;)
      {
        localObject = null;
      }
      if (((this.a.status == 0) || (this.a.status == 3)) && (((paramActivity instanceof ChatActivity)) || ((paramActivity instanceof SplashActivity))) && (!this.a.bSend))
      {
        localObject.getFileManagerEngine().a(this.a.nSessionId);
        return;
      }
      b(paramActivity, paramInt, 10004);
    }
  }
  
  private void b(Activity paramActivity, int paramInt1, int paramInt2)
  {
    ForwardFileInfo localForwardFileInfo;
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface == null)
      {
        QLog.e("FileModel<FileAssistant>", 1, "Start VideoActivity is not in QQ!");
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject = null;
      }
      localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.b(paramInt2);
      if (!this.a.bSend) {}
    }
    for (Object localObject = ((QQAppInterface)localObject).getAccount();; localObject = this.a.peerUin)
    {
      localForwardFileInfo.d(this.a.getCloudType());
      if (localObject != null) {
        localForwardFileInfo.a(Long.valueOf(((String)localObject).replace("+", "")).longValue());
      }
      localForwardFileInfo.c(this.a.uniseq);
      localForwardFileInfo.b(this.a.nSessionId);
      localForwardFileInfo.d(this.a.fileName);
      localForwardFileInfo.d(this.a.fileSize);
      localForwardFileInfo.b(this.a.Uuid);
      localForwardFileInfo.a(this.a.getFilePath());
      localObject = new Intent(paramActivity, FileBrowserActivity.class);
      ((Intent)localObject).putExtra("fileinfo", localForwardFileInfo);
      ((Intent)localObject).putExtra("file_enter_file_browser_type", paramInt1);
      ((Intent)localObject).putExtra("selfSet_leftViewText", amtj.a(2131703684));
      paramActivity.startActivityForResult((Intent)localObject, 102);
      paramActivity.overridePendingTransition(2130772039, 2130772041);
      return;
    }
  }
  
  public void a(Activity paramActivity, int paramInt)
  {
    if (this.a.nFileType == 2)
    {
      if (!NetworkUtil.isNetSupport(BaseApplicationImpl.getContext())) {
        aszk.a(2131694311);
      }
      asyt localasyt;
      boolean bool1;
      do
      {
        return;
        if ((this.a.getCloudType() != 1) || (!aszt.a()) || (this.a.status == 2) || (this.a.fileSize <= 1048576L)) {
          break;
        }
        localasyt = new asyt(this, paramActivity, paramInt);
        boolean bool2 = bgoa.a(paramActivity, 2, new asyu(this, paramActivity, paramInt), "");
        bool1 = bool2;
        if (bool2) {
          bool1 = bhnb.a(paramActivity, 3, new asyv(this, paramActivity, paramInt));
        }
      } while (!bool1);
      aszg.a(paramActivity, paramActivity.getString(2131692374), paramActivity.getString(2131692376), localasyt);
      return;
      b(paramActivity, paramInt);
      return;
    }
    b(paramActivity, paramInt, 10004);
  }
  
  public void a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    b(paramActivity, paramInt2, paramInt1);
  }
  
  public void a(boolean paramBoolean, Context paramContext, aszj paramaszj)
  {
    int j = 2;
    if (!NetworkUtil.isNetSupportHw(BaseApplicationImpl.getContext())) {
      aszk.a(2131692955);
    }
    boolean bool1;
    label48:
    label91:
    do
    {
      return;
      if (paramBoolean) {
        break;
      }
      bool1 = true;
      if (!a(bool1)) {
        break label160;
      }
      Activity localActivity = (Activity)paramContext;
      if (!paramBoolean) {
        break label140;
      }
      i = 3;
      boolean bool2 = bgoa.a(localActivity, i, new asyr(this, paramaszj), "");
      bool1 = bool2;
      if (bool2)
      {
        localActivity = (Activity)paramContext;
        if (!paramBoolean) {
          break label146;
        }
        i = j;
        bool1 = bhnb.a(localActivity, i, new asys(this, paramaszj));
      }
    } while (!bool1);
    if (paramBoolean) {}
    for (int i = 2131692379;; i = 2131692376)
    {
      aszg.a(paramContext, 2131692374, i, paramaszj);
      return;
      bool1 = false;
      break;
      label140:
      i = 2;
      break label48;
      label146:
      i = 1;
      break label91;
    }
    label160:
    paramaszj.onYes();
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (!NetworkUtil.isNetSupport(BaseApplicationImpl.getContext())) {}
    long l2;
    long l1;
    do
    {
      do
      {
        return false;
        if (!aszt.a())
        {
          a("FlowShow", " donot ShowFlowDialog! Wi-Fi");
          return false;
        }
        l2 = asld.a();
        l1 = asld.b();
        a("FlowShow", "fileSize " + this.a.fileSize + ",limit  " + l2);
      } while (this.a.fileSize < l2);
      if (paramBoolean)
      {
        a("FlowShow", "download model so Show!");
        return true;
      }
      if ((this.a.cloudType != 3) && (this.a.cloudType != 6))
      {
        a("FlowShow", "cloudeType " + this.a.cloudType + " is not local File donot show!");
        return false;
      }
      l2 = bbko.a();
      a("FlowShow", "last Succ " + this.a.lastSuccessTime + " now " + bbko.a() + " = " + (l2 - this.a.lastSuccessTime) + " limit[" + l1 + "]");
    } while (l2 - this.a.lastSuccessTime < l1);
    a("FlowShow", "Must show!");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asyq
 * JD-Core Version:    0.7.0.1
 */