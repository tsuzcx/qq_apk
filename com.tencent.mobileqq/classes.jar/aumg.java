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
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;

public class aumg
{
  private FileManagerEntity a;
  
  public static aumg a(MessageForFile paramMessageForFile)
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
      return a(aunj.a(localQQAppInterface2, paramMessageForFile));
    }
  }
  
  public static aumg a(FileManagerEntity paramFileManagerEntity)
  {
    aumg localaumg = new aumg();
    if ((paramFileManagerEntity == null) && (QLog.isDevelopLevel())) {
      throw new NullPointerException("newFileModel entity is null!");
    }
    localaumg.a = paramFileManagerEntity;
    return localaumg;
  }
  
  public static aumg a(String paramString)
  {
    try
    {
      paramString = a(aunj.a(new FileInfo(paramString)));
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
        localObject.a().a(this.a.nSessionId);
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
      ((Intent)localObject).putExtra("selfSet_leftViewText", anzj.a(2131703454));
      paramActivity.startActivityForResult((Intent)localObject, 102);
      paramActivity.overridePendingTransition(2130772037, 2130772039);
      return;
    }
  }
  
  public void a(Activity paramActivity, int paramInt)
  {
    if (this.a.nFileType == 2)
    {
      if (!bhnv.d(BaseApplicationImpl.getContext())) {
        auna.a(2131694197);
      }
      aumj localaumj;
      boolean bool1;
      do
      {
        return;
        if ((this.a.getCloudType() != 1) || (!aunj.a()) || (this.a.status == 2) || (this.a.fileSize <= 1048576L)) {
          break;
        }
        localaumj = new aumj(this, paramActivity, paramInt);
        boolean bool2 = bihq.a(paramActivity, 2, new aumk(this, paramActivity, paramInt), "");
        bool1 = bool2;
        if (bool2) {
          bool1 = bjhk.a(paramActivity, 3, new auml(this, paramActivity, paramInt));
        }
      } while (!bool1);
      aumw.a(paramActivity, paramActivity.getString(2131692326), paramActivity.getString(2131692328), localaumj);
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
  
  public void a(boolean paramBoolean, Context paramContext, aumz paramaumz)
  {
    int j = 2;
    if (!bhnv.e(BaseApplicationImpl.getContext())) {
      auna.a(2131692905);
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
      boolean bool2 = bihq.a(localActivity, i, new aumh(this, paramaumz), "");
      bool1 = bool2;
      if (bool2)
      {
        localActivity = (Activity)paramContext;
        if (!paramBoolean) {
          break label146;
        }
        i = j;
        bool1 = bjhk.a(localActivity, i, new aumi(this, paramaumz));
      }
    } while (!bool1);
    if (paramBoolean) {}
    for (int i = 2131692331;; i = 2131692328)
    {
      aumw.a(paramContext, 2131692326, i, paramaumz);
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
    paramaumz.a();
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (!bhnv.d(BaseApplicationImpl.getContext())) {}
    long l2;
    long l1;
    do
    {
      do
      {
        return false;
        if (!aunj.a())
        {
          a("FlowShow", " donot ShowFlowDialog! Wi-Fi");
          return false;
        }
        l2 = atyt.a();
        l1 = atyt.b();
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
      l2 = bcrg.a();
      a("FlowShow", "last Succ " + this.a.lastSuccessTime + " now " + bcrg.a() + " = " + (l2 - this.a.lastSuccessTime) + " limit[" + l1 + "]");
    } while (l2 - this.a.lastSuccessTime < l1);
    a("FlowShow", "Must show!");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aumg
 * JD-Core Version:    0.7.0.1
 */