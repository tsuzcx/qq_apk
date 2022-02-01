import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceDownloader;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.util.QQAvatarFHDDecoder.2;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class bfro
  implements Handler.Callback, bfvm
{
  private amsu jdField_a_of_type_Amsu = new bfrp(this);
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private volatile String jdField_a_of_type_JavaLangString;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private WeakReference<QQAppInterface> jdField_a_of_type_MqqUtilWeakReference;
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile WeakReference<bfrq> jdField_b_of_type_MqqUtilWeakReference;
  private volatile boolean jdField_b_of_type_Boolean;
  
  public bfro(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramQQAppInterface);
    a();
  }
  
  private QQAppInterface a()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() != null) {
      return (QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get();
    }
    return (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  }
  
  private void a()
  {
    a().addObserver(this.jdField_a_of_type_Amsu);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)a().getBusinessHandler(1));
    this.jdField_a_of_type_MqqOsMqqHandler = new bfum(Looper.getMainLooper(), this);
  }
  
  private void a(String paramString)
  {
    try
    {
      paramString = BitmapFactory.decodeFile(paramString);
      paramString = new BitmapDrawable(a().getApp().getResources(), paramString);
      Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1);
      localMessage.obj = paramString;
      localMessage.sendToTarget();
      return;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QQAvatarFHDDecoder", 2, "downloadFHDAvatar getDrawable " + paramString.toString());
        }
        paramString = null;
      }
    }
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQAvatarFHDDecoder", 2, "getLocalThumbFile ");
    }
    paramString = a().getCustomFaceFilePath(1, paramString, 0);
    if (new File(paramString).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQAvatarFHDDecoder", 2, "getLocalThumbFile exist");
      }
      a(paramString);
    }
  }
  
  public void a(Setting paramSetting)
  {
    boolean bool1 = false;
    Object localObject;
    if ((paramSetting == null) || (TextUtils.isEmpty(paramSetting.uin)) || (TextUtils.isEmpty(paramSetting.url))) {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("downloadFHDAvatar return ");
        if (paramSetting == null) {
          break label71;
        }
        paramSetting = paramSetting.toString();
        QLog.i("QQAvatarFHDDecoder", 2, paramSetting);
      }
    }
    for (;;)
    {
      return;
      label71:
      paramSetting = "";
      break;
      localObject = bfrj.b(paramSetting.uin);
      if (FileUtil.isFileExists((String)localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QQAvatarFHDDecoder", 2, "downloadFHDAvatar already exist " + (String)localObject);
        }
        a((String)localObject);
        return;
      }
      paramSetting = FaceDownloader.get1080QQHeadDownLoadUrl(paramSetting.url, paramSetting.bFaceFlags);
      File localFile1 = new File((String)localObject);
      File localFile2 = new File(localFile1.getPath() + System.currentTimeMillis());
      if (HttpDownloadUtil.downloadData(a(), new ardx(MsfSdkUtils.insertMtype("friendlist", paramSetting), localFile2, 0), this) == 0) {
        bool1 = true;
      }
      boolean bool2;
      if (bool1)
      {
        if (localFile2.exists()) {
          bool1 = localFile2.renameTo(localFile1);
        }
        if (QLog.isColorLevel()) {
          QLog.i("QQAvatarFHDDecoder", 2, "downloadFHDAvatar suc " + bool1 + " " + (String)localObject);
        }
        bool2 = bool1;
        if (bool1)
        {
          a((String)localObject);
          bool2 = bool1;
        }
      }
      while (!bool2)
      {
        b(this.jdField_a_of_type_JavaLangString);
        return;
        bool2 = bool1;
        if (localFile2.exists())
        {
          localFile2.delete();
          bool2 = bool1;
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQAvatarFHDDecoder", 2, "onHttpStart " + paramString + " " + paramInt);
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2) {}
  
  public boolean a(String paramString, boolean paramBoolean, bfrq parambfrq)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQAvatarFHDDecoder", 2, "getFHDAvatar " + paramString + " mIsGettingHead：" + this.jdField_a_of_type_Boolean + " mCurrentUin：" + this.jdField_a_of_type_JavaLangString + " forceUpdate：" + paramBoolean);
    }
    if ((this.jdField_b_of_type_Boolean) || (TextUtils.isEmpty(paramString)) || (!Friends.isValidUin(paramString))) {}
    do
    {
      do
      {
        return false;
        if (NetworkUtil.isNetSupport(a().getApp())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("QQAvatarFHDDecoder", 2, "getFHDAvatar no network");
      return false;
    } while (this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_MqqUtilWeakReference = new WeakReference(parambfrq);
    ThreadManagerV2.excute(new QQAvatarFHDDecoder.2(this, paramString, paramBoolean), 128, null, true);
    return true;
  }
  
  public void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQAvatarFHDDecoder", 2, "onHttpEnd " + paramString + " " + paramInt);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    }
    if ((paramMessage.obj instanceof Drawable)) {}
    for (paramMessage = (Drawable)paramMessage.obj;; paramMessage = null)
    {
      bfrq localbfrq;
      String str;
      if (this.jdField_b_of_type_MqqUtilWeakReference != null)
      {
        localbfrq = (bfrq)this.jdField_b_of_type_MqqUtilWeakReference.get();
        if (localbfrq != null)
        {
          str = this.jdField_a_of_type_JavaLangString;
          if (paramMessage == null) {
            break label105;
          }
        }
      }
      label105:
      for (boolean bool = true;; bool = false)
      {
        localbfrq.a(str, bool, paramMessage);
        this.jdField_b_of_type_MqqUtilWeakReference = null;
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_JavaLangString = null;
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfro
 * JD-Core Version:    0.7.0.1
 */