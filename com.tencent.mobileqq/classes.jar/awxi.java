import android.app.Activity;
import android.app.Dialog;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.multimsg.save.FileSaveRunnable;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class awxi
  implements Handler.Callback, Manager
{
  private long jdField_a_of_type_Long;
  protected ahuo a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private atbq jdField_a_of_type_Atbq;
  private awxg jdField_a_of_type_Awxg;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ConcurrentHashMap<String, awxe> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public awxi(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  private long a()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
    {
      this.jdField_a_of_type_Long = 0L;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        awxe localawxe = (awxe)((Map.Entry)localIterator.next()).getValue();
        if ((localawxe != null) && (localawxe.jdField_a_of_type_Awxd != null)) {
          switch (localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_Int)
          {
          default: 
            break;
          case 1: 
            if ((localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_Ayxx != null) && (localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_Ayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)) {
              this.jdField_a_of_type_Long += localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_Ayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
            }
            break;
          case 2: 
          case 3: 
            if ((localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_Bcev != null) && (localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_Bcev.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
              this.jdField_a_of_type_Long += localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_Bcev.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
            }
            break;
          case 4: 
          case 5: 
          case 6: 
          case 7: 
            if (localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_Attv != null) {
              this.jdField_a_of_type_Long += localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_Attv.a();
            }
            break;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "getTotalFileLength totalFileLength = " + this.jdField_a_of_type_Long);
    }
    return this.jdField_a_of_type_Long;
  }
  
  private void a(int paramInt, awxd paramawxd)
  {
    awxe localawxe = new awxe();
    localawxe.jdField_a_of_type_Int = -1;
    localawxe.jdField_a_of_type_Awxd = paramawxd;
    localawxe.b = paramInt;
    localawxe.jdField_a_of_type_JavaLangString = awxc.a(paramInt);
    b(localawxe);
  }
  
  private void a(Activity paramActivity, Dialog paramDialog)
  {
    if ((paramDialog != null) && (paramActivity != null) && (!paramActivity.isFinishing())) {}
    try
    {
      paramDialog.show();
      return;
    }
    catch (Throwable paramActivity)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MultiRichMediaSaveManager", 2, "showDialogSafe exception: " + paramActivity.getMessage());
    }
  }
  
  private void a(attv paramattv)
  {
    if (paramattv != null) {
      paramattv.a(paramattv.b(), new awxk(this, paramattv));
    }
  }
  
  private void a(awxd paramawxd, int paramInt)
  {
    if ((paramawxd != null) && (paramawxd.jdField_a_of_type_Ayxx != null))
    {
      paramawxd = a(paramawxd.jdField_a_of_type_Ayxx.jdField_a_of_type_Ayxp);
      awxe localawxe = a(paramawxd);
      if ((localawxe != null) && (!localawxe.jdField_a_of_type_Boolean))
      {
        paramInt /= 100;
        localawxe.c = paramInt;
        a(paramawxd, localawxe);
        c(localawxe, paramInt);
      }
    }
  }
  
  private void a(awxd paramawxd, boolean paramBoolean)
  {
    String str;
    awxe localawxe;
    if ((paramawxd != null) && (paramawxd.jdField_a_of_type_Attv != null))
    {
      str = paramawxd.jdField_a_of_type_Attv.a();
      localawxe = a(str);
      if ((localawxe == null) || (localawxe.jdField_a_of_type_Boolean)) {
        break label97;
      }
      localawxe.jdField_a_of_type_Boolean = true;
      localawxe.c = 100;
      a(str, localawxe);
      if (!paramBoolean) {
        break label188;
      }
    }
    switch (paramawxd.jdField_a_of_type_Int)
    {
    default: 
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("MultiRichMediaSaveManager", 2, "dealFileMultilDownloadComplete fileType= " + paramawxd.jdField_a_of_type_Int);
      return;
    case 4: 
    case 6: 
      label97:
      paramawxd = paramawxd.jdField_a_of_type_Attv.b();
      str = Utils.Crc64String(paramawxd + NetConnInfoCenter.getServerTime());
      localawxe.jdField_a_of_type_Int = 0;
      a(paramawxd, str, localawxe);
      return;
    }
    a(paramawxd.jdField_a_of_type_Attv);
    return;
    label188:
    if (QLog.isColorLevel()) {
      QLog.d("MultiRichMediaSaveManager", 2, "dealFileMultilDownloadComplete errorType= " + paramawxd.jdField_a_of_type_Int);
    }
    localawxe.jdField_a_of_type_Int = -1;
    b(localawxe);
  }
  
  private void a(awxe paramawxe, long paramLong)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4);
    localMessage.obj = paramawxe;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  private void a(String paramString1, String paramString2, awxe paramawxe)
  {
    int i;
    if (TextUtils.isEmpty(paramString1)) {
      i = 10001;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MultiRichMediaSaveManager", 2, "savePictureFile fail, errorCode = " + i);
        }
        if ((paramawxe != null) && (paramawxe.jdField_a_of_type_Awxd != null))
        {
          paramawxe.jdField_a_of_type_Int = -1;
          paramawxe.b = i;
          paramawxe.jdField_a_of_type_JavaLangString = awxc.a(i);
          b(paramawxe);
        }
        return;
        if (TextUtils.isEmpty(paramString2))
        {
          i = 10002;
          continue;
        }
        if (!bgmg.a(paramString1)) {
          i = 10003;
        }
      }
      else
      {
        new File(anhk.bg).mkdirs();
        String str = paramString2;
        if (!paramString2.contains("."))
        {
          str = bgmg.b(paramString1);
          str = paramString2 + "." + str;
        }
        paramString2 = new File(anhk.bg, str);
        ThreadManager.getFileThreadHandler().post(new FileSaveRunnable(new File(paramString1), paramString2, this.jdField_a_of_type_AndroidOsHandler, paramawxe, false));
        return;
      }
      i = 0;
    }
  }
  
  private void a(List<awxd> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((awxd)paramList.next());
    }
  }
  
  private boolean a()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        awxe localawxe = (awxe)((Map.Entry)localIterator.next()).getValue();
        if ((localawxe == null) || (!localawxe.jdField_a_of_type_Boolean)) {
          return false;
        }
      }
    }
    return true;
  }
  
  private void b(awxd paramawxd)
  {
    String str;
    if (paramawxd != null)
    {
      str = "";
      switch (paramawxd.jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      a(str);
      return;
      if (paramawxd.jdField_a_of_type_Ayxx != null)
      {
        str = a(paramawxd.jdField_a_of_type_Ayxx.jdField_a_of_type_Ayxp);
        continue;
        if (paramawxd.jdField_a_of_type_Bcev != null)
        {
          str = a(paramawxd.jdField_a_of_type_Bcev.jdField_a_of_type_Bcef);
          continue;
          if (paramawxd.jdField_a_of_type_Attv != null) {
            str = paramawxd.jdField_a_of_type_Attv.a();
          }
        }
      }
    }
  }
  
  private void b(awxd paramawxd, int paramInt1, int paramInt2, String paramString)
  {
    awxe localawxe;
    if ((paramawxd != null) && (paramawxd.jdField_a_of_type_Ayxx != null) && (paramawxd.jdField_a_of_type_Ayxx.jdField_a_of_type_Ayxp != null))
    {
      String str = a(paramawxd.jdField_a_of_type_Ayxx.jdField_a_of_type_Ayxp);
      localawxe = a(str);
      if ((localawxe != null) && (localawxe.jdField_a_of_type_Awxd != null) && (!localawxe.jdField_a_of_type_Boolean))
      {
        localawxe.jdField_a_of_type_Boolean = true;
        localawxe.jdField_a_of_type_Int = paramInt1;
        localawxe.c = 100;
        a(str, localawxe);
        if (paramInt1 != 0) {
          break label136;
        }
        paramawxd = paramawxd.jdField_a_of_type_Ayxx.jdField_a_of_type_Ayxp.c();
        a(paramawxd, Utils.Crc64String(paramawxd + NetConnInfoCenter.getServerTime()), localawxe);
      }
    }
    return;
    label136:
    localawxe.b = paramInt2;
    localawxe.jdField_a_of_type_JavaLangString = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("MultiRichMediaSaveManager", 2, "dealPicDownloadComplete errorCode= " + paramInt2 + ", errorDec= " + paramString);
    }
    b(localawxe);
  }
  
  private void b(awxe paramawxe)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
    localMessage.obj = paramawxe;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void b(awxe paramawxe, int paramInt)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(6);
    localMessage.obj = paramawxe;
    localMessage.arg1 = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void b(String paramString1, String paramString2, awxe paramawxe)
  {
    int i;
    if (TextUtils.isEmpty(paramString1)) {
      i = 10001;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MultiRichMediaSaveManager", 2, "saveShortVideoFile fail, errorCode = " + i);
        }
        if ((paramawxe != null) && (paramawxe.jdField_a_of_type_Awxd != null))
        {
          paramawxe.jdField_a_of_type_Int = -1;
          paramawxe.b = i;
          paramawxe.jdField_a_of_type_JavaLangString = awxc.a(i);
          b(paramawxe);
        }
        return;
        if (TextUtils.isEmpty(paramString2))
        {
          i = 10002;
          continue;
        }
        if (!bgmg.a(paramString1)) {
          i = 10003;
        }
      }
      else
      {
        if (VersionUtils.isrFroyo()) {}
        for (File localFile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);; localFile = new File(anhk.bu))
        {
          localFile.mkdirs();
          paramString2 = new File(localFile, ShortVideoUtils.b(paramString2));
          ThreadManager.getFileThreadHandler().post(new FileSaveRunnable(new File(paramString1), paramString2, this.jdField_a_of_type_AndroidOsHandler, paramawxe, false));
          return;
        }
      }
      i = 0;
    }
  }
  
  private boolean b()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        awxe localawxe = (awxe)((Map.Entry)localIterator.next()).getValue();
        if ((localawxe != null) && (localawxe.d == 1) && (!localawxe.jdField_a_of_type_Boolean)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean b(awxd paramawxd)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramawxd == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload fileSaveReq is empty!");
      }
      return false;
    }
    switch (paramawxd.jdField_a_of_type_Int)
    {
    default: 
      bool2 = bool1;
      label74:
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      if ((paramawxd.jdField_a_of_type_Ayxx == null) || (paramawxd.jdField_a_of_type_Ayxx.jdField_a_of_type_Ayxp == null) || (paramawxd.jdField_a_of_type_Ayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload picReq is empty!");
        return false;
      }
      if ((paramawxd.jdField_a_of_type_Ayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) && (paramawxd.jdField_a_of_type_Ayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.fileSizeFlag == 1)) {
        break;
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(bdzi.a(paramawxd.jdField_a_of_type_Ayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.md5, paramawxd.jdField_a_of_type_Ayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uuid, 1));
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if ((localObject instanceof bdsr)) {
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (!bool1) {
        break label74;
      }
      localObject = (bdsr)localObject;
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload picReq addDownCallback");
      }
      ((bdsr)localObject).b(new awxo(this, paramawxd));
      continue;
      if ((paramawxd.jdField_a_of_type_Bcev == null) || (paramawxd.jdField_a_of_type_Bcev.jdField_a_of_type_Bcef == null))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload shortVideoReq is empty!");
        return false;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramawxd.jdField_a_of_type_Bcev.jdField_a_of_type_Bcef.c, paramawxd.jdField_a_of_type_Bcev.jdField_a_of_type_Bcef.jdField_a_of_type_Long);
      bool2 = bool1;
      if (localObject == null) {
        break label74;
      }
      bool2 = bool1;
      if (!(localObject instanceof bdsr)) {
        break label74;
      }
      localObject = (bdsr)localObject;
      if ((((bdsr)localObject).a != null) && ((((bdsr)localObject).a.b == 7) || (((bdsr)localObject).a.b == 16) || (((bdsr)localObject).a.b == 18)))
      {
        ((bdsr)localObject).a();
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload shortVideoReq addDownCallback");
      }
      ((bdsr)localObject).b(new awxp(this, paramawxd));
      bool1 = false;
      continue;
      bool1 = false;
      continue;
      bool2 = bool1;
      if (paramawxd.jdField_a_of_type_Attv == null) {
        break label74;
      }
      bool2 = paramawxd.jdField_a_of_type_Attv.b();
      bool1 = bool2;
      if (bool2)
      {
        paramawxd.jdField_a_of_type_Attv.a(new awxq(this, paramawxd));
        bool1 = bool2;
        if (this.jdField_a_of_type_Atbq != null)
        {
          this.jdField_a_of_type_Atbq.a(paramawxd.jdField_a_of_type_Attv.a());
          bool1 = bool2;
        }
      }
    }
  }
  
  private void c(awxd paramawxd)
  {
    if (paramawxd == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "downloadFile fileSaveReq is empty!");
      }
      a(10007, new awxd());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadFile fileType = " + paramawxd.jdField_a_of_type_Int);
    }
    String str;
    switch (paramawxd.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      if (paramawxd.jdField_a_of_type_Ayxx != null)
      {
        str = a(paramawxd.jdField_a_of_type_Ayxx.jdField_a_of_type_Ayxp);
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "downloadPic key = " + str);
        }
        paramawxd.jdField_a_of_type_Ayxx.a(new awxr(this, str, paramawxd));
        ayxn.a(paramawxd.jdField_a_of_type_Ayxx, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
      a(10007, paramawxd);
      return;
    case 2: 
      if (paramawxd.jdField_a_of_type_Bcev != null)
      {
        str = a(paramawxd.jdField_a_of_type_Bcev.jdField_a_of_type_Bcef);
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "downloadShortVideo key = " + str);
        }
        paramawxd.jdField_a_of_type_Bcev.a(new awxs(this, str, paramawxd));
        bcec.a(paramawxd.jdField_a_of_type_Bcev, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
      a(10007, paramawxd);
      return;
    case 3: 
      if (paramawxd.jdField_a_of_type_Bcev != null)
      {
        str = a(paramawxd.jdField_a_of_type_Bcev.jdField_a_of_type_Bcef);
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "downloadVideo key = " + str);
        }
        paramawxd.jdField_a_of_type_Bcev.jdField_a_of_type_Boolean = true;
        paramawxd.jdField_a_of_type_Bcev.jdField_a_of_type_Bceu = new awxt(this, paramawxd, str);
        ((bcep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(95)).a(paramawxd);
        return;
      }
      a(10007, paramawxd);
      return;
    }
    if (paramawxd.jdField_a_of_type_Attv != null)
    {
      str = paramawxd.jdField_a_of_type_Attv.a();
      if (QLog.isColorLevel()) {
        QLog.i("MultiRichMediaSaveManager", 2, "downloadFile key = " + str);
      }
      paramawxd.jdField_a_of_type_Attv.a(new awxu(this, str, paramawxd));
      if (this.jdField_a_of_type_Atbq != null) {
        this.jdField_a_of_type_Atbq.a(paramawxd.jdField_a_of_type_Attv.a());
      }
      paramawxd.jdField_a_of_type_Attv.a();
      return;
    }
    a(10007, paramawxd);
  }
  
  private void c(awxe paramawxe)
  {
    HashMap localHashMap;
    if (paramawxe != null)
    {
      localHashMap = new HashMap();
      if (paramawxe.d != 1) {
        break label70;
      }
      localHashMap.put("isMultiSave", "1");
      if (paramawxe.jdField_a_of_type_Int != 0) {
        break label84;
      }
      localHashMap.put("isSuccess", "0");
    }
    for (;;)
    {
      bctj.a(BaseApplication.getContext()).a(null, "MultiRichMediaFileSave", true, 0L, 0L, localHashMap, "");
      return;
      label70:
      localHashMap.put("isMultiSave", "0");
      break;
      label84:
      localHashMap.put("isSuccess", "1");
      localHashMap.put("errorCode", String.valueOf(paramawxe.b));
      localHashMap.put("isSuccess", paramawxe.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void c(awxe paramawxe, int paramInt)
  {
    if (paramawxe != null)
    {
      paramawxe.c = paramInt;
      d(paramawxe, paramInt);
    }
  }
  
  private void d(awxd paramawxd)
  {
    if (paramawxd != null) {}
    switch (paramawxd.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      b(paramawxd, 0, 0, "");
      return;
    case 2: 
    case 3: 
      a(paramawxd, 0, 0, "");
      return;
    }
    a(paramawxd, true);
  }
  
  private void d(awxe paramawxe)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "notifySingleComplete");
    }
    if (paramawxe != null)
    {
      a(paramawxe);
      if ((paramawxe.jdField_a_of_type_Awxv != null) && (this.jdField_a_of_type_Ahuo != null)) {
        this.jdField_a_of_type_Ahuo.a(paramawxe.jdField_a_of_type_Awxv.jdField_a_of_type_Long, paramawxe.jdField_a_of_type_Awxv.jdField_a_of_type_Int, paramawxe.jdField_a_of_type_Awxv.b, paramawxe.jdField_a_of_type_Awxv.c, paramawxe.jdField_a_of_type_Awxv.jdField_a_of_type_JavaLangString, paramawxe.jdField_a_of_type_Awxv.jdField_a_of_type_Boolean);
      }
    }
  }
  
  private void d(awxe paramawxe, int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    long l = 0L;
    if (localIterator.hasNext())
    {
      awxe localawxe = (awxe)((Map.Entry)localIterator.next()).getValue();
      if ((localawxe != null) && (localawxe.jdField_a_of_type_Awxd != null)) {
        switch (localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_Int)
        {
        }
      }
      for (;;)
      {
        break;
        if ((localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_Ayxx != null) && (localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_Ayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)) {
          if (localawxe.jdField_a_of_type_Boolean)
          {
            l += localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_Ayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
          }
          else
          {
            float f1 = (float)l;
            float f2 = (float)localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_Ayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
            l = (localawxe.c / 100.0F * f2 + f1);
            continue;
            if ((localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_Bcev != null) && (localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_Bcev.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
              if (localawxe.jdField_a_of_type_Boolean)
              {
                l += localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_Bcev.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
              }
              else
              {
                f1 = (float)l;
                f2 = localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_Bcev.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
                l = (localawxe.c / 100.0F * f2 + f1);
                continue;
                if (localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_Attv != null) {
                  if (localawxe.jdField_a_of_type_Boolean)
                  {
                    l += localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_Attv.a();
                  }
                  else
                  {
                    f1 = (float)l;
                    f2 = (float)localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_Attv.a();
                    l = (localawxe.c / 100.0F * f2 + f1);
                  }
                }
              }
            }
          }
        }
      }
    }
    if (this.jdField_a_of_type_Long > 0L) {}
    for (paramInt = (int)(100L * l / this.jdField_a_of_type_Long);; paramInt = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MultiRichMediaSaveManager", 2, "calculateWholeProgress totalProgress = " + paramInt);
      }
      paramawxe.d = 0;
      b(paramawxe, paramInt);
      return;
    }
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "saveBegin");
    }
    this.c = true;
    this.jdField_a_of_type_Long = a();
    if (this.jdField_a_of_type_Awxg != null) {
      this.jdField_a_of_type_Awxg.a();
    }
  }
  
  private void e(awxd paramawxd)
  {
    if (paramawxd != null)
    {
      paramawxd = paramawxd.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (paramawxd.hasNext()) {
        ((awxh)paramawxd.next()).a();
      }
    }
  }
  
  private void e(awxe paramawxe)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(5);
    localMessage.obj = paramawxe;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "saveCancel");
    }
    if (this.jdField_a_of_type_Awxg != null) {
      this.jdField_a_of_type_Awxg.b();
    }
    this.c = false;
    this.jdField_a_of_type_Long = 0L;
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "saveTips");
    }
    if (this.jdField_a_of_type_Awxg != null) {
      this.jdField_a_of_type_Awxg.c();
    }
  }
  
  private void h()
  {
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      awxe localawxe = (awxe)localEntry.getValue();
      if ((localawxe != null) && (localawxe.jdField_a_of_type_Awxd != null) && (localawxe.d == 1))
      {
        Iterator localIterator2 = localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        while (localIterator2.hasNext()) {
          ((awxh)localIterator2.next()).a();
        }
        localawxe.d = 0;
        a((String)localEntry.getKey(), localawxe);
      }
    }
  }
  
  private void i()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "cancelDownloading");
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    label39:
    awxe localawxe;
    bguz localbguz;
    while (localIterator.hasNext())
    {
      localawxe = (awxe)((Map.Entry)localIterator.next()).getValue();
      if ((localawxe != null) && (localawxe.jdField_a_of_type_Awxd != null)) {
        switch (localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_Int)
        {
        default: 
          break;
        case 1: 
          if ((localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_Ayxx != null) && (localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_Ayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null))
          {
            localbguz = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(bdzi.a(localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_Ayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.md5, localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_Ayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uuid, 131075));
            if (localbguz != null) {
              break label406;
            }
            localbguz = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(bdzi.a(localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_Ayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.md5, localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_Ayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uuid, 1));
          }
          break;
        }
      }
    }
    label406:
    for (;;)
    {
      if (!(localbguz instanceof bdsr)) {
        break label39;
      }
      ((bdsr)localbguz).a();
      break label39;
      if ((localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_Bcev != null) && (localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_Bcev.jdField_a_of_type_Bcef != null)) {}
      localbguz = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_Bcev.jdField_a_of_type_Bcef.c, localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_Bcev.jdField_a_of_type_Bcef.jdField_a_of_type_Long);
      if (!(localbguz instanceof bdsr)) {
        break label39;
      }
      ((bdsr)localbguz).a();
      break label39;
      if ((localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_Bcev == null) || (localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_Bcev.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
        break label39;
      }
      ((bcep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(95)).b(localawxe.jdField_a_of_type_Awxd);
      break label39;
      if (localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_Attv == null) {
        break label39;
      }
      localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_Attv.b();
      break label39;
      break;
    }
  }
  
  private void j()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        awxe localawxe = (awxe)((Map.Entry)localIterator.next()).getValue();
        if ((localawxe != null) && (localawxe.jdField_a_of_type_Awxd != null)) {
          localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
        }
      }
    }
  }
  
  public awxe a(String paramString)
  {
    return (awxe)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public String a(ayxp paramayxp)
  {
    if (paramayxp != null) {
      return paramayxp.c + paramayxp.jdField_a_of_type_Long;
    }
    return "";
  }
  
  public String a(bcef parambcef)
  {
    if (parambcef != null) {
      return parambcef.c + parambcef.jdField_a_of_type_Long;
    }
    return "";
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage != null) {
      return paramChatMessage.frienduin + paramChatMessage.uniseq;
    }
    return "";
  }
  
  public void a()
  {
    i();
    d();
  }
  
  public void a(ahuo paramahuo)
  {
    this.jdField_a_of_type_Ahuo = paramahuo;
  }
  
  public void a(Activity paramActivity, List<awxd> paramList)
  {
    a(paramActivity, bglp.a(paramActivity, 230, paramActivity.getString(2131717411), paramActivity.getString(2131717410), new awxj(this, paramList), new awxn(this)));
  }
  
  public void a(awxd paramawxd)
  {
    if (paramawxd != null) {
      switch (paramawxd.jdField_a_of_type_Int)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
            } while (paramawxd.jdField_a_of_type_Ayxx == null);
            localawxe = new awxe();
            localawxe.jdField_a_of_type_Awxd = paramawxd;
            paramawxd = a(paramawxd.jdField_a_of_type_Ayxx.jdField_a_of_type_Ayxp);
          } while (TextUtils.isEmpty(paramawxd));
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramawxd, localawxe);
          return;
        } while (paramawxd.jdField_a_of_type_Bcev == null);
        localawxe = new awxe();
        localawxe.jdField_a_of_type_Awxd = paramawxd;
        paramawxd = a(paramawxd.jdField_a_of_type_Bcev.jdField_a_of_type_Bcef);
      } while (TextUtils.isEmpty(paramawxd));
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramawxd, localawxe);
      return;
      if (this.jdField_a_of_type_Atbq == null)
      {
        this.jdField_a_of_type_Atbq = new atbq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_Atbq.a();
      }
    } while (paramawxd.jdField_a_of_type_Attv == null);
    awxe localawxe = new awxe();
    localawxe.jdField_a_of_type_Awxd = paramawxd;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramawxd.jdField_a_of_type_Attv.a(), localawxe);
  }
  
  public void a(awxd paramawxd, int paramInt1, int paramInt2, String paramString)
  {
    awxe localawxe;
    if ((paramawxd != null) && (paramawxd.jdField_a_of_type_Bcev != null) && (paramawxd.jdField_a_of_type_Bcev.jdField_a_of_type_Bcef != null))
    {
      String str = a(paramawxd.jdField_a_of_type_Bcev.jdField_a_of_type_Bcef);
      localawxe = a(str);
      if ((localawxe != null) && (localawxe.jdField_a_of_type_Awxd != null) && (!localawxe.jdField_a_of_type_Boolean))
      {
        localawxe.jdField_a_of_type_Boolean = true;
        localawxe.jdField_a_of_type_Int = paramInt1;
        localawxe.c = 100;
        a(str, localawxe);
        if (paramInt1 != 0) {
          break label196;
        }
        paramawxd = new File(paramawxd.jdField_a_of_type_Bcev.jdField_a_of_type_Bcef.h);
        if ((!paramawxd.exists()) && (QLog.isColorLevel())) {
          QLog.d("MultiRichMediaSaveManager", 2, "dealShortVideoDownloadComplete srcFile not exists");
        }
        b(paramawxd.getAbsolutePath(), new StringBuilder().append(paramawxd.getParentFile().getName()).append(NetConnInfoCenter.getServerTime()).toString().toLowerCase(Locale.US) + ".mp4", localawxe);
      }
    }
    return;
    label196:
    localawxe.b = paramInt2;
    localawxe.jdField_a_of_type_JavaLangString = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("MultiRichMediaSaveManager", 2, "dealShortVideoDownloadComplete errorCode= " + paramInt2 + ", errorDec= " + paramString);
    }
    b(localawxe);
  }
  
  public void a(awxe paramawxe)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "saveComplete");
    }
    if (paramawxe != null)
    {
      if (paramawxe.d == 1)
      {
        if (paramawxe.jdField_a_of_type_Awxd != null)
        {
          Iterator localIterator = paramawxe.jdField_a_of_type_Awxd.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          while (localIterator.hasNext())
          {
            awxh localawxh = (awxh)localIterator.next();
            if (paramawxe.jdField_a_of_type_Int == 0) {
              localawxh.a(paramawxe, 100);
            }
            localawxh.a(paramawxe);
          }
        }
        b(paramawxe.jdField_a_of_type_Awxd);
        c(paramawxe);
      }
    }
    else {
      return;
    }
    if (this.jdField_a_of_type_Awxg != null) {
      this.jdField_a_of_type_Awxg.a(paramawxe);
    }
    this.c = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    c(paramawxe);
  }
  
  public void a(awxe paramawxe, int paramInt)
  {
    if (paramawxe != null) {
      if (paramawxe.d == 1)
      {
        if (paramawxe.jdField_a_of_type_Awxd != null)
        {
          Iterator localIterator = paramawxe.jdField_a_of_type_Awxd.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          while (localIterator.hasNext()) {
            ((awxh)localIterator.next()).a(paramawxe, paramInt);
          }
        }
      }
      else if (this.jdField_a_of_type_Awxg != null) {
        this.jdField_a_of_type_Awxg.a(paramawxe, paramInt);
      }
    }
  }
  
  public void a(awxg paramawxg)
  {
    this.jdField_a_of_type_Awxg = paramawxg;
  }
  
  public void a(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadRawImage id = " + paramLong);
    }
    if (paramInt2 != 24) {
      if (QLog.isColorLevel()) {
        QLog.i("MultiRichMediaSaveManager", 2, "downloadRawImage type = " + paramInt2);
      }
    }
    do
    {
      return;
      try
      {
        ayxx localayxx = ayxn.a(7, 1);
        localayxx.a(paramMessageForPic, paramMessageForPic.getPicDownloadInfo());
        String str1 = bdsh.d(bdzx.a(paramMessageForPic, 131075, null).toString().toString());
        long l = paramMessageForPic.size;
        String str2 = a(paramMessageForPic.getPicDownloadInfo());
        if (a(str2) == null)
        {
          awxe localawxe = new awxe();
          localawxe.jdField_a_of_type_Awxd = awxd.a(paramMessageForPic);
          localawxe.d = 1;
          a(str2, localawxe);
        }
        localayxx.a(new awxl(this, paramLong, paramInt1, paramInt2, l, str2, str1));
        ayxn.a(localayxx, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
      catch (Exception paramMessageForPic) {}
    } while (!QLog.isColorLevel());
    QLog.i("MultiRichMediaSaveManager", 2, "downloadRawImage exception = " + paramMessageForPic.getMessage());
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadVideo id = " + paramLong);
    }
    if (paramInt2 != 256) {
      if (QLog.isColorLevel()) {
        QLog.i("MultiRichMediaSaveManager", 2, "downloadVideo type = " + paramInt2);
      }
    }
    awxd localawxd;
    do
    {
      for (;;)
      {
        return;
        try
        {
          localawxd = awxd.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForShortVideo);
          if ((localawxd != null) && (localawxd.jdField_a_of_type_Bcev != null))
          {
            paramMessageForShortVideo = a(paramMessageForShortVideo.getDownloadInfo(paramMessageForShortVideo.busiType));
            if (a(paramMessageForShortVideo) == null)
            {
              awxe localawxe = new awxe();
              localawxe.jdField_a_of_type_Awxd = localawxd;
              localawxe.d = 1;
              a(paramMessageForShortVideo, localawxe);
            }
            if ((!a(localawxd)) || (localawxd.jdField_a_of_type_Bcev.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (this.jdField_a_of_type_Ahuo == null)) {
              break label244;
            }
            paramMessageForShortVideo = ShortVideoUtils.a(localawxd.jdField_a_of_type_Bcev.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
            this.jdField_a_of_type_Ahuo.a(paramLong, paramInt1, paramInt2, 1, paramMessageForShortVideo, false);
            return;
          }
        }
        catch (Exception paramMessageForShortVideo) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("MultiRichMediaSaveManager", 2, "dealSaveVideo exception: " + paramMessageForShortVideo.getMessage());
    return;
    label244:
    localawxd.jdField_a_of_type_Bcev.jdField_a_of_type_Boolean = true;
    localawxd.jdField_a_of_type_Bcev.jdField_a_of_type_Bceu = new awxm(this, paramLong, localawxd, paramMessageForShortVideo, paramInt1, paramInt2);
    ((bcep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(95)).a(localawxd);
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("MultiRichMediaSaveManager", 2, "removeFileSaveResult exception = " + paramString.getMessage());
    }
  }
  
  public void a(String paramString, awxe paramawxe)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramawxe);
    }
  }
  
  public void a(List<awxd> paramList, int paramInt1, int paramInt2)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "reportSaveMultiFile fileSaveReqList is empty!");
      }
    }
    label571:
    for (;;)
    {
      return;
      String str = "";
      int k;
      int j;
      int i;
      label74:
      int m;
      int n;
      switch (paramInt1)
      {
      default: 
        paramList = paramList.iterator();
        k = 0;
        j = 0;
        i = 0;
        paramInt1 = 0;
        if (paramList.hasNext()) {
          switch (((awxd)paramList.next()).jdField_a_of_type_Int)
          {
          default: 
            m = k;
            n = j;
            k = paramInt1;
            j = i;
            i = n;
            paramInt1 = m;
          }
        }
        break;
      case 1: 
      case 2: 
        for (;;)
        {
          m = j;
          n = k;
          k = paramInt1;
          j = i;
          i = m;
          paramInt1 = n;
          break label74;
          str = "0X8009F89";
          break;
          str = "0X8009F8A";
          break;
          m = i;
          n = paramInt1 + 1;
          paramInt1 = k;
          i = j;
          j = m;
          k = n;
          continue;
          n = i + 1;
          m = paramInt1;
          paramInt1 = k;
          i = j;
          j = n;
          k = m;
          continue;
          n = j + 1;
          j = i;
          m = paramInt1;
          paramInt1 = k;
          i = n;
          k = m;
          continue;
          n = k + 1;
          k = i;
          m = paramInt1;
          paramInt1 = n;
          i = j;
          j = k;
          k = m;
        }
      }
      switch (paramInt2)
      {
      }
      for (;;)
      {
        if (TextUtils.isEmpty(str)) {
          break label571;
        }
        bcst.b(null, "dc00898", "", "", str, str, paramInt2, 0, String.valueOf(paramInt1), String.valueOf(i), String.valueOf(j), String.valueOf(k));
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MultiRichMediaSaveManager", 2, "reportSaveMultiFile reportTag = " + str + ", fromType = " + paramInt2 + ", picCount = " + paramInt1 + ", videoCount = " + i + ", filePicCount = " + j + ", fileVideoCount = " + k);
        return;
        paramInt2 = 1;
        continue;
        paramInt2 = 2;
        continue;
        paramInt2 = 3;
        continue;
        paramInt2 = 4;
      }
    }
  }
  
  public void a(List<awxd> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "saveMultiRichMedialFile fileSaveReqList is empty!");
      }
      paramList = new awxe();
      paramList.jdField_a_of_type_Int = -1;
      paramList.b = 10006;
      paramList.jdField_a_of_type_JavaLangString = awxc.a(10006);
      a(paramList);
    }
    for (;;)
    {
      return;
      if (b()) {
        h();
      }
      if ((paramBoolean) && (a(paramList)))
      {
        g();
        return;
      }
      a(paramList);
      e();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        awxd localawxd = (awxd)paramList.next();
        if (a(localawxd)) {
          d(localawxd);
        } else if (!b(localawxd)) {
          c(localawxd);
        }
      }
    }
  }
  
  public boolean a(awxd paramawxd)
  {
    boolean bool2 = true;
    if (paramawxd == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFileExist fileSaveReq is empty!");
      }
    }
    do
    {
      return false;
      switch (paramawxd.jdField_a_of_type_Int)
      {
      default: 
        return false;
      }
    } while ((paramawxd.jdField_a_of_type_Ayxx == null) || (paramawxd.jdField_a_of_type_Ayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null));
    Object localObject = paramawxd.jdField_a_of_type_Ayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.getPicDownloadInfo();
    if (localObject != null)
    {
      localObject = ((ayxp)localObject).c();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new File((String)localObject);
        if ((((File)localObject).exists()) && (((File)localObject).length() == paramawxd.jdField_a_of_type_Ayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size))
        {
          bool1 = bool2;
          if (QLog.isColorLevel()) {
            QLog.d("MultiRichMediaSaveManager", 2, "isFileExist picture exists");
          }
        }
      }
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return bool1;
      if (paramawxd.jdField_a_of_type_Bcev == null) {
        break;
      }
      localObject = ShortVideoUtils.a(paramawxd.jdField_a_of_type_Bcev.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
      if (localObject == null) {
        break;
      }
      localObject = new File((String)localObject);
      if ((!((File)localObject).exists()) || (paramawxd.jdField_a_of_type_Bcev.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (((File)localObject).length() != paramawxd.jdField_a_of_type_Bcev.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFileExist shortVideo exists");
      }
      return true;
      if (paramawxd.jdField_a_of_type_Attv == null) {
        break;
      }
      return paramawxd.jdField_a_of_type_Attv.a();
    }
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage != null)
    {
      paramChatMessage = a(a(paramChatMessage));
      return (paramChatMessage != null) && (paramChatMessage.d == 1) && (!paramChatMessage.jdField_a_of_type_Boolean) && (paramChatMessage.c < 100);
    }
    return false;
  }
  
  public boolean a(List<awxd> paramList)
  {
    if ((!AppNetConnInfo.isWifiConn()) && (paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      long l = 0L;
      while (paramList.hasNext())
      {
        awxd localawxd = (awxd)paramList.next();
        if (!a(localawxd))
        {
          switch (localawxd.jdField_a_of_type_Int)
          {
          }
          for (;;)
          {
            break;
            if ((localawxd.jdField_a_of_type_Ayxx != null) && (localawxd.jdField_a_of_type_Ayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null))
            {
              l += localawxd.jdField_a_of_type_Ayxx.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
              continue;
              if ((localawxd.jdField_a_of_type_Bcev != null) && (localawxd.jdField_a_of_type_Bcev.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
              {
                l += localawxd.jdField_a_of_type_Bcev.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
                continue;
                if (localawxd.jdField_a_of_type_Attv != null) {
                  l += localawxd.jdField_a_of_type_Attv.a();
                }
              }
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isSaveNeedTips totalSaveSize = " + l);
      }
      return l > 29360128L;
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Awxg = null;
  }
  
  public void b(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "cancelSavePic id = " + paramLong);
    }
    paramMessageForPic = a(paramMessageForPic);
    awxe localawxe = a(paramMessageForPic);
    if (localawxe != null)
    {
      localawxe.jdField_a_of_type_Boolean = true;
      localawxe.jdField_a_of_type_Int = -1;
      a(paramMessageForPic, localawxe);
      e(localawxe);
      a(paramMessageForPic);
    }
  }
  
  public void b(MessageForShortVideo paramMessageForShortVideo, long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "cancelSaveVideo id = " + paramLong);
    }
    if (paramInt2 != 256)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MultiRichMediaSaveManager", 2, "cancelSaveVideo type = " + paramInt2);
      }
      return;
    }
    String str = a(paramMessageForShortVideo);
    awxe localawxe = a(str);
    if (localawxe != null)
    {
      localawxe.jdField_a_of_type_Boolean = true;
      localawxe.jdField_a_of_type_Int = -1;
      a(str, localawxe);
      e(localawxe);
    }
    ((bcep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(95)).b(awxd.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForShortVideo));
    a(str);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Ahuo = null;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "clearFileSaveRequest");
    }
    j();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_Awxg = null;
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    this.c = false;
    this.jdField_a_of_type_Long = 0L;
    if (this.jdField_a_of_type_Atbq != null)
    {
      this.jdField_a_of_type_Atbq.b();
      this.jdField_a_of_type_Atbq = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    awxe localawxe;
    if ((paramMessage.obj instanceof awxe))
    {
      localawxe = (awxe)paramMessage.obj;
      if (localawxe.jdField_a_of_type_Awxd == null) {}
    }
    switch (paramMessage.what)
    {
    default: 
    case 6: 
    case 5: 
    case 1: 
    case 2: 
      do
      {
        do
        {
          return true;
          a(localawxe, paramMessage.arg1);
          return true;
        } while (localawxe.d != 1);
        e(localawxe.jdField_a_of_type_Awxd);
        return true;
        if (localawxe.d == 1)
        {
          d(localawxe);
          return true;
        }
        if (paramMessage.what == 2)
        {
          this.jdField_a_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            QLog.i("MultiRichMediaSaveManager", 2, "MSG_TYPE_SAVE_FAIL errorCode = " + localawxe.b + ", errorMsg = " + localawxe.jdField_a_of_type_JavaLangString);
          }
        }
        for (;;)
        {
          paramMessage = localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          while (paramMessage.hasNext()) {
            ((awxh)paramMessage.next()).a(localawxe);
          }
          this.b = true;
        }
      } while (!a());
      b(localawxe, 100);
      if ((this.b) && (!this.jdField_a_of_type_Boolean)) {
        localawxe.jdField_a_of_type_Int = 0;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "last result = " + localawxe.jdField_a_of_type_Int);
        }
        this.jdField_a_of_type_Boolean = false;
        this.b = false;
        if (this.jdField_a_of_type_Atbq != null)
        {
          this.jdField_a_of_type_Atbq.b();
          this.jdField_a_of_type_Atbq = null;
        }
        a(localawxe, 200L);
        return true;
        if ((this.jdField_a_of_type_Boolean) && (!this.b)) {
          localawxe.jdField_a_of_type_Int = -1;
        } else {
          localawxe.jdField_a_of_type_Int = 3;
        }
      }
    case 3: 
      paramMessage = localawxe.jdField_a_of_type_Awxd.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (paramMessage.hasNext()) {
        ((awxh)paramMessage.next()).b(localawxe);
      }
    }
    a(localawxe);
    return true;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "onDestroy");
    }
    f();
    i();
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awxi
 * JD-Core Version:    0.7.0.1
 */