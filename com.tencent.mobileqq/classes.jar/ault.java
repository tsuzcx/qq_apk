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

public class ault
  implements Handler.Callback, Manager
{
  private long jdField_a_of_type_Long;
  protected agfw a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private aqqy jdField_a_of_type_Aqqy;
  private aulr jdField_a_of_type_Aulr;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ConcurrentHashMap<String, aulp> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public ault(QQAppInterface paramQQAppInterface)
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
        aulp localaulp = (aulp)((Map.Entry)localIterator.next()).getValue();
        if ((localaulp != null) && (localaulp.jdField_a_of_type_Aulo != null)) {
          switch (localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_Int)
          {
          default: 
            break;
          case 1: 
            if ((localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_Awfc != null) && (localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_Awfc.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)) {
              this.jdField_a_of_type_Long += localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_Awfc.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
            }
            break;
          case 2: 
          case 3: 
            if ((localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_Ayzo != null) && (localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_Ayzo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
              this.jdField_a_of_type_Long += localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_Ayzo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
            }
            break;
          case 4: 
          case 5: 
          case 6: 
          case 7: 
            if (localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_Arlp != null) {
              this.jdField_a_of_type_Long += localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_Arlp.a();
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
  
  private void a(int paramInt, aulo paramaulo)
  {
    aulp localaulp = new aulp();
    localaulp.jdField_a_of_type_Int = -1;
    localaulp.jdField_a_of_type_Aulo = paramaulo;
    localaulp.b = paramInt;
    localaulp.jdField_a_of_type_JavaLangString = auln.a(paramInt);
    b(localaulp);
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
  
  private void a(arlp paramarlp)
  {
    if (paramarlp != null) {
      paramarlp.a(paramarlp.b(), new aulv(this, paramarlp));
    }
  }
  
  private void a(aulo paramaulo, int paramInt)
  {
    if ((paramaulo != null) && (paramaulo.jdField_a_of_type_Awfc != null))
    {
      paramaulo = a(paramaulo.jdField_a_of_type_Awfc.jdField_a_of_type_Aweu);
      aulp localaulp = a(paramaulo);
      if ((localaulp != null) && (!localaulp.jdField_a_of_type_Boolean))
      {
        paramInt /= 100;
        localaulp.c = paramInt;
        a(paramaulo, localaulp);
        c(localaulp, paramInt);
      }
    }
  }
  
  private void a(aulo paramaulo, boolean paramBoolean)
  {
    String str;
    aulp localaulp;
    if ((paramaulo != null) && (paramaulo.jdField_a_of_type_Arlp != null))
    {
      str = paramaulo.jdField_a_of_type_Arlp.a();
      localaulp = a(str);
      if ((localaulp == null) || (localaulp.jdField_a_of_type_Boolean)) {
        break label97;
      }
      localaulp.jdField_a_of_type_Boolean = true;
      localaulp.c = 100;
      a(str, localaulp);
      if (!paramBoolean) {
        break label188;
      }
    }
    switch (paramaulo.jdField_a_of_type_Int)
    {
    default: 
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("MultiRichMediaSaveManager", 2, "dealFileMultilDownloadComplete fileType= " + paramaulo.jdField_a_of_type_Int);
      return;
    case 4: 
    case 6: 
      label97:
      paramaulo = paramaulo.jdField_a_of_type_Arlp.b();
      str = Utils.Crc64String(paramaulo + NetConnInfoCenter.getServerTime());
      localaulp.jdField_a_of_type_Int = 0;
      a(paramaulo, str, localaulp);
      return;
    }
    a(paramaulo.jdField_a_of_type_Arlp);
    return;
    label188:
    if (QLog.isColorLevel()) {
      QLog.d("MultiRichMediaSaveManager", 2, "dealFileMultilDownloadComplete errorType= " + paramaulo.jdField_a_of_type_Int);
    }
    localaulp.jdField_a_of_type_Int = -1;
    b(localaulp);
  }
  
  private void a(aulp paramaulp, long paramLong)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4);
    localMessage.obj = paramaulp;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  private void a(String paramString1, String paramString2, aulp paramaulp)
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
        if ((paramaulp != null) && (paramaulp.jdField_a_of_type_Aulo != null))
        {
          paramaulp.jdField_a_of_type_Int = -1;
          paramaulp.b = i;
          paramaulp.jdField_a_of_type_JavaLangString = auln.a(i);
          b(paramaulp);
        }
        return;
        if (TextUtils.isEmpty(paramString2))
        {
          i = 10002;
          continue;
        }
        if (!bdcs.a(paramString1)) {
          i = 10003;
        }
      }
      else
      {
        new File(aljq.bd).mkdirs();
        String str = paramString2;
        if (!paramString2.contains("."))
        {
          str = bdcs.b(paramString1);
          str = paramString2 + "." + str;
        }
        paramString2 = new File(aljq.bd, str);
        ThreadManager.getFileThreadHandler().post(new FileSaveRunnable(new File(paramString1), paramString2, this.jdField_a_of_type_AndroidOsHandler, paramaulp, false));
        return;
      }
      i = 0;
    }
  }
  
  private void a(List<aulo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((aulo)paramList.next());
    }
  }
  
  private boolean a()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        aulp localaulp = (aulp)((Map.Entry)localIterator.next()).getValue();
        if ((localaulp == null) || (!localaulp.jdField_a_of_type_Boolean)) {
          return false;
        }
      }
    }
    return true;
  }
  
  private void b(aulo paramaulo)
  {
    String str;
    if (paramaulo != null)
    {
      str = "";
      switch (paramaulo.jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      a(str);
      return;
      if (paramaulo.jdField_a_of_type_Awfc != null)
      {
        str = a(paramaulo.jdField_a_of_type_Awfc.jdField_a_of_type_Aweu);
        continue;
        if (paramaulo.jdField_a_of_type_Ayzo != null)
        {
          str = a(paramaulo.jdField_a_of_type_Ayzo.jdField_a_of_type_Ayyx);
          continue;
          if (paramaulo.jdField_a_of_type_Arlp != null) {
            str = paramaulo.jdField_a_of_type_Arlp.a();
          }
        }
      }
    }
  }
  
  private void b(aulo paramaulo, int paramInt1, int paramInt2, String paramString)
  {
    aulp localaulp;
    if ((paramaulo != null) && (paramaulo.jdField_a_of_type_Awfc != null) && (paramaulo.jdField_a_of_type_Awfc.jdField_a_of_type_Aweu != null))
    {
      String str = a(paramaulo.jdField_a_of_type_Awfc.jdField_a_of_type_Aweu);
      localaulp = a(str);
      if ((localaulp != null) && (localaulp.jdField_a_of_type_Aulo != null) && (!localaulp.jdField_a_of_type_Boolean))
      {
        localaulp.jdField_a_of_type_Boolean = true;
        localaulp.jdField_a_of_type_Int = paramInt1;
        localaulp.c = 100;
        a(str, localaulp);
        if (paramInt1 != 0) {
          break label136;
        }
        paramaulo = paramaulo.jdField_a_of_type_Awfc.jdField_a_of_type_Aweu.c();
        a(paramaulo, Utils.Crc64String(paramaulo + NetConnInfoCenter.getServerTime()), localaulp);
      }
    }
    return;
    label136:
    localaulp.b = paramInt2;
    localaulp.jdField_a_of_type_JavaLangString = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("MultiRichMediaSaveManager", 2, "dealPicDownloadComplete errorCode= " + paramInt2 + ", errorDec= " + paramString);
    }
    b(localaulp);
  }
  
  private void b(aulp paramaulp)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
    localMessage.obj = paramaulp;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void b(aulp paramaulp, int paramInt)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(6);
    localMessage.obj = paramaulp;
    localMessage.arg1 = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void b(String paramString1, String paramString2, aulp paramaulp)
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
        if ((paramaulp != null) && (paramaulp.jdField_a_of_type_Aulo != null))
        {
          paramaulp.jdField_a_of_type_Int = -1;
          paramaulp.b = i;
          paramaulp.jdField_a_of_type_JavaLangString = auln.a(i);
          b(paramaulp);
        }
        return;
        if (TextUtils.isEmpty(paramString2))
        {
          i = 10002;
          continue;
        }
        if (!bdcs.a(paramString1)) {
          i = 10003;
        }
      }
      else
      {
        if (bhou.b()) {}
        for (File localFile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);; localFile = new File(aljq.br))
        {
          localFile.mkdirs();
          paramString2 = new File(localFile, ShortVideoUtils.b(paramString2));
          ThreadManager.getFileThreadHandler().post(new FileSaveRunnable(new File(paramString1), paramString2, this.jdField_a_of_type_AndroidOsHandler, paramaulp, false));
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
        aulp localaulp = (aulp)((Map.Entry)localIterator.next()).getValue();
        if ((localaulp != null) && (localaulp.d == 1) && (!localaulp.jdField_a_of_type_Boolean)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean b(aulo paramaulo)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramaulo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload fileSaveReq is empty!");
      }
      return false;
    }
    switch (paramaulo.jdField_a_of_type_Int)
    {
    default: 
      bool2 = bool1;
      label74:
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      if ((paramaulo.jdField_a_of_type_Awfc == null) || (paramaulo.jdField_a_of_type_Awfc.jdField_a_of_type_Aweu == null) || (paramaulo.jdField_a_of_type_Awfc.jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload picReq is empty!");
        return false;
      }
      if ((paramaulo.jdField_a_of_type_Awfc.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) && (paramaulo.jdField_a_of_type_Awfc.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.fileSizeFlag == 1)) {
        break;
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(batw.a(paramaulo.jdField_a_of_type_Awfc.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.md5, paramaulo.jdField_a_of_type_Awfc.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uuid, 1));
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if ((localObject instanceof bamr)) {
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (!bool1) {
        break label74;
      }
      localObject = (bamr)localObject;
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload picReq addDownCallback");
      }
      ((bamr)localObject).b(new aulz(this, paramaulo));
      continue;
      if ((paramaulo.jdField_a_of_type_Ayzo == null) || (paramaulo.jdField_a_of_type_Ayzo.jdField_a_of_type_Ayyx == null))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload shortVideoReq is empty!");
        return false;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramaulo.jdField_a_of_type_Ayzo.jdField_a_of_type_Ayyx.c, paramaulo.jdField_a_of_type_Ayzo.jdField_a_of_type_Ayyx.jdField_a_of_type_Long);
      bool2 = bool1;
      if (localObject == null) {
        break label74;
      }
      bool2 = bool1;
      if (!(localObject instanceof bamr)) {
        break label74;
      }
      localObject = (bamr)localObject;
      if ((((bamr)localObject).a != null) && ((((bamr)localObject).a.b == 7) || (((bamr)localObject).a.b == 16) || (((bamr)localObject).a.b == 18)))
      {
        ((bamr)localObject).a();
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload shortVideoReq addDownCallback");
      }
      ((bamr)localObject).b(new auma(this, paramaulo));
      bool1 = false;
      continue;
      bool1 = false;
      continue;
      bool2 = bool1;
      if (paramaulo.jdField_a_of_type_Arlp == null) {
        break label74;
      }
      bool2 = paramaulo.jdField_a_of_type_Arlp.b();
      bool1 = bool2;
      if (bool2)
      {
        paramaulo.jdField_a_of_type_Arlp.a(new aumb(this, paramaulo));
        bool1 = bool2;
        if (this.jdField_a_of_type_Aqqy != null)
        {
          this.jdField_a_of_type_Aqqy.a(paramaulo.jdField_a_of_type_Arlp.a());
          bool1 = bool2;
        }
      }
    }
  }
  
  private void c(aulo paramaulo)
  {
    if (paramaulo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "downloadFile fileSaveReq is empty!");
      }
      a(10007, new aulo());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadFile fileType = " + paramaulo.jdField_a_of_type_Int);
    }
    String str;
    switch (paramaulo.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      if (paramaulo.jdField_a_of_type_Awfc != null)
      {
        str = a(paramaulo.jdField_a_of_type_Awfc.jdField_a_of_type_Aweu);
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "downloadPic key = " + str);
        }
        paramaulo.jdField_a_of_type_Awfc.a(new aumc(this, str, paramaulo));
        awes.a(paramaulo.jdField_a_of_type_Awfc, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
      a(10007, paramaulo);
      return;
    case 2: 
      if (paramaulo.jdField_a_of_type_Ayzo != null)
      {
        str = a(paramaulo.jdField_a_of_type_Ayzo.jdField_a_of_type_Ayyx);
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "downloadShortVideo key = " + str);
        }
        paramaulo.jdField_a_of_type_Ayzo.a(new aumd(this, str, paramaulo));
        ayyu.a(paramaulo.jdField_a_of_type_Ayzo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
      a(10007, paramaulo);
      return;
    case 3: 
      if (paramaulo.jdField_a_of_type_Ayzo != null)
      {
        str = a(paramaulo.jdField_a_of_type_Ayzo.jdField_a_of_type_Ayyx);
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "downloadVideo key = " + str);
        }
        paramaulo.jdField_a_of_type_Ayzo.jdField_a_of_type_Boolean = true;
        paramaulo.jdField_a_of_type_Ayzo.jdField_a_of_type_Ayzm = new aume(this, paramaulo, str);
        ((ayzh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(95)).a(paramaulo);
        return;
      }
      a(10007, paramaulo);
      return;
    }
    if (paramaulo.jdField_a_of_type_Arlp != null)
    {
      str = paramaulo.jdField_a_of_type_Arlp.a();
      if (QLog.isColorLevel()) {
        QLog.i("MultiRichMediaSaveManager", 2, "downloadFile key = " + str);
      }
      paramaulo.jdField_a_of_type_Arlp.a(new aumf(this, str, paramaulo));
      if (this.jdField_a_of_type_Aqqy != null) {
        this.jdField_a_of_type_Aqqy.a(paramaulo.jdField_a_of_type_Arlp.a());
      }
      paramaulo.jdField_a_of_type_Arlp.a();
      return;
    }
    a(10007, paramaulo);
  }
  
  private void c(aulp paramaulp)
  {
    HashMap localHashMap;
    if (paramaulp != null)
    {
      localHashMap = new HashMap();
      if (paramaulp.d != 1) {
        break label70;
      }
      localHashMap.put("isMultiSave", "1");
      if (paramaulp.jdField_a_of_type_Int != 0) {
        break label84;
      }
      localHashMap.put("isSuccess", "0");
    }
    for (;;)
    {
      azmz.a(BaseApplication.getContext()).a(null, "MultiRichMediaFileSave", true, 0L, 0L, localHashMap, "");
      return;
      label70:
      localHashMap.put("isMultiSave", "0");
      break;
      label84:
      localHashMap.put("isSuccess", "1");
      localHashMap.put("errorCode", String.valueOf(paramaulp.b));
      localHashMap.put("isSuccess", paramaulp.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void c(aulp paramaulp, int paramInt)
  {
    if (paramaulp != null)
    {
      paramaulp.c = paramInt;
      d(paramaulp, paramInt);
    }
  }
  
  private void d(aulo paramaulo)
  {
    if (paramaulo != null) {}
    switch (paramaulo.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      b(paramaulo, 0, 0, "");
      return;
    case 2: 
    case 3: 
      a(paramaulo, 0, 0, "");
      return;
    }
    a(paramaulo, true);
  }
  
  private void d(aulp paramaulp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "notifySingleComplete");
    }
    if (paramaulp != null)
    {
      a(paramaulp);
      if ((paramaulp.jdField_a_of_type_Aumg != null) && (this.jdField_a_of_type_Agfw != null)) {
        this.jdField_a_of_type_Agfw.a(paramaulp.jdField_a_of_type_Aumg.jdField_a_of_type_Long, paramaulp.jdField_a_of_type_Aumg.jdField_a_of_type_Int, paramaulp.jdField_a_of_type_Aumg.b, paramaulp.jdField_a_of_type_Aumg.c, paramaulp.jdField_a_of_type_Aumg.jdField_a_of_type_JavaLangString, paramaulp.jdField_a_of_type_Aumg.jdField_a_of_type_Boolean);
      }
    }
  }
  
  private void d(aulp paramaulp, int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    long l = 0L;
    if (localIterator.hasNext())
    {
      aulp localaulp = (aulp)((Map.Entry)localIterator.next()).getValue();
      if ((localaulp != null) && (localaulp.jdField_a_of_type_Aulo != null)) {
        switch (localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_Int)
        {
        }
      }
      for (;;)
      {
        break;
        if ((localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_Awfc != null) && (localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_Awfc.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)) {
          if (localaulp.jdField_a_of_type_Boolean)
          {
            l += localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_Awfc.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
          }
          else
          {
            float f1 = (float)l;
            float f2 = (float)localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_Awfc.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
            l = (localaulp.c / 100.0F * f2 + f1);
            continue;
            if ((localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_Ayzo != null) && (localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_Ayzo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
              if (localaulp.jdField_a_of_type_Boolean)
              {
                l += localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_Ayzo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
              }
              else
              {
                f1 = (float)l;
                f2 = localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_Ayzo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
                l = (localaulp.c / 100.0F * f2 + f1);
                continue;
                if (localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_Arlp != null) {
                  if (localaulp.jdField_a_of_type_Boolean)
                  {
                    l += localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_Arlp.a();
                  }
                  else
                  {
                    f1 = (float)l;
                    f2 = (float)localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_Arlp.a();
                    l = (localaulp.c / 100.0F * f2 + f1);
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
      paramaulp.d = 0;
      b(paramaulp, paramInt);
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
    if (this.jdField_a_of_type_Aulr != null) {
      this.jdField_a_of_type_Aulr.a();
    }
  }
  
  private void e(aulo paramaulo)
  {
    if (paramaulo != null)
    {
      paramaulo = paramaulo.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (paramaulo.hasNext()) {
        ((auls)paramaulo.next()).a();
      }
    }
  }
  
  private void e(aulp paramaulp)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(5);
    localMessage.obj = paramaulp;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "saveCancel");
    }
    if (this.jdField_a_of_type_Aulr != null) {
      this.jdField_a_of_type_Aulr.b();
    }
    this.c = false;
    this.jdField_a_of_type_Long = 0L;
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "saveTips");
    }
    if (this.jdField_a_of_type_Aulr != null) {
      this.jdField_a_of_type_Aulr.c();
    }
  }
  
  private void h()
  {
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      aulp localaulp = (aulp)localEntry.getValue();
      if ((localaulp != null) && (localaulp.jdField_a_of_type_Aulo != null) && (localaulp.d == 1))
      {
        Iterator localIterator2 = localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        while (localIterator2.hasNext()) {
          ((auls)localIterator2.next()).a();
        }
        localaulp.d = 0;
        a((String)localEntry.getKey(), localaulp);
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
    aulp localaulp;
    bdlq localbdlq;
    while (localIterator.hasNext())
    {
      localaulp = (aulp)((Map.Entry)localIterator.next()).getValue();
      if ((localaulp != null) && (localaulp.jdField_a_of_type_Aulo != null)) {
        switch (localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_Int)
        {
        default: 
          break;
        case 1: 
          if ((localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_Awfc != null) && (localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_Awfc.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null))
          {
            localbdlq = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(batw.a(localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_Awfc.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.md5, localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_Awfc.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uuid, 131075));
            if (localbdlq != null) {
              break label406;
            }
            localbdlq = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(batw.a(localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_Awfc.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.md5, localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_Awfc.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uuid, 1));
          }
          break;
        }
      }
    }
    label406:
    for (;;)
    {
      if (!(localbdlq instanceof bamr)) {
        break label39;
      }
      ((bamr)localbdlq).a();
      break label39;
      if ((localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_Ayzo != null) && (localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_Ayzo.jdField_a_of_type_Ayyx != null)) {}
      localbdlq = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_Ayzo.jdField_a_of_type_Ayyx.c, localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_Ayzo.jdField_a_of_type_Ayyx.jdField_a_of_type_Long);
      if (!(localbdlq instanceof bamr)) {
        break label39;
      }
      ((bamr)localbdlq).a();
      break label39;
      if ((localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_Ayzo == null) || (localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_Ayzo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
        break label39;
      }
      ((ayzh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(95)).b(localaulp.jdField_a_of_type_Aulo);
      break label39;
      if (localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_Arlp == null) {
        break label39;
      }
      localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_Arlp.b();
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
        aulp localaulp = (aulp)((Map.Entry)localIterator.next()).getValue();
        if ((localaulp != null) && (localaulp.jdField_a_of_type_Aulo != null)) {
          localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
        }
      }
    }
  }
  
  public aulp a(String paramString)
  {
    return (aulp)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public String a(aweu paramaweu)
  {
    if (paramaweu != null) {
      return paramaweu.c + paramaweu.jdField_a_of_type_Long;
    }
    return "";
  }
  
  public String a(ayyx paramayyx)
  {
    if (paramayyx != null) {
      return paramayyx.c + paramayyx.jdField_a_of_type_Long;
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
  
  public void a(agfw paramagfw)
  {
    this.jdField_a_of_type_Agfw = paramagfw;
  }
  
  public void a(Activity paramActivity, List<aulo> paramList)
  {
    a(paramActivity, bdcd.a(paramActivity, 230, paramActivity.getString(2131719312), paramActivity.getString(2131719311), new aulu(this, paramList), new auly(this)));
  }
  
  public void a(aulo paramaulo)
  {
    if (paramaulo != null) {
      switch (paramaulo.jdField_a_of_type_Int)
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
            } while (paramaulo.jdField_a_of_type_Awfc == null);
            localaulp = new aulp();
            localaulp.jdField_a_of_type_Aulo = paramaulo;
            paramaulo = a(paramaulo.jdField_a_of_type_Awfc.jdField_a_of_type_Aweu);
          } while (TextUtils.isEmpty(paramaulo));
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramaulo, localaulp);
          return;
        } while (paramaulo.jdField_a_of_type_Ayzo == null);
        localaulp = new aulp();
        localaulp.jdField_a_of_type_Aulo = paramaulo;
        paramaulo = a(paramaulo.jdField_a_of_type_Ayzo.jdField_a_of_type_Ayyx);
      } while (TextUtils.isEmpty(paramaulo));
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramaulo, localaulp);
      return;
      if (this.jdField_a_of_type_Aqqy == null)
      {
        this.jdField_a_of_type_Aqqy = new aqqy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_Aqqy.a();
      }
    } while (paramaulo.jdField_a_of_type_Arlp == null);
    aulp localaulp = new aulp();
    localaulp.jdField_a_of_type_Aulo = paramaulo;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramaulo.jdField_a_of_type_Arlp.a(), localaulp);
  }
  
  public void a(aulo paramaulo, int paramInt1, int paramInt2, String paramString)
  {
    aulp localaulp;
    if ((paramaulo != null) && (paramaulo.jdField_a_of_type_Ayzo != null) && (paramaulo.jdField_a_of_type_Ayzo.jdField_a_of_type_Ayyx != null))
    {
      String str = a(paramaulo.jdField_a_of_type_Ayzo.jdField_a_of_type_Ayyx);
      localaulp = a(str);
      if ((localaulp != null) && (localaulp.jdField_a_of_type_Aulo != null) && (!localaulp.jdField_a_of_type_Boolean))
      {
        localaulp.jdField_a_of_type_Boolean = true;
        localaulp.jdField_a_of_type_Int = paramInt1;
        localaulp.c = 100;
        a(str, localaulp);
        if (paramInt1 != 0) {
          break label196;
        }
        paramaulo = new File(paramaulo.jdField_a_of_type_Ayzo.jdField_a_of_type_Ayyx.h);
        if ((!paramaulo.exists()) && (QLog.isColorLevel())) {
          QLog.d("MultiRichMediaSaveManager", 2, "dealShortVideoDownloadComplete srcFile not exists");
        }
        b(paramaulo.getAbsolutePath(), new StringBuilder().append(paramaulo.getParentFile().getName()).append(NetConnInfoCenter.getServerTime()).toString().toLowerCase(Locale.US) + ".mp4", localaulp);
      }
    }
    return;
    label196:
    localaulp.b = paramInt2;
    localaulp.jdField_a_of_type_JavaLangString = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("MultiRichMediaSaveManager", 2, "dealShortVideoDownloadComplete errorCode= " + paramInt2 + ", errorDec= " + paramString);
    }
    b(localaulp);
  }
  
  public void a(aulp paramaulp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "saveComplete");
    }
    if (paramaulp != null)
    {
      if (paramaulp.d == 1)
      {
        if (paramaulp.jdField_a_of_type_Aulo != null)
        {
          Iterator localIterator = paramaulp.jdField_a_of_type_Aulo.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          while (localIterator.hasNext())
          {
            auls localauls = (auls)localIterator.next();
            if (paramaulp.jdField_a_of_type_Int == 0) {
              localauls.a(paramaulp, 100);
            }
            localauls.a(paramaulp);
          }
        }
        b(paramaulp.jdField_a_of_type_Aulo);
        c(paramaulp);
      }
    }
    else {
      return;
    }
    if (this.jdField_a_of_type_Aulr != null) {
      this.jdField_a_of_type_Aulr.a(paramaulp);
    }
    this.c = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    c(paramaulp);
  }
  
  public void a(aulp paramaulp, int paramInt)
  {
    if (paramaulp != null) {
      if (paramaulp.d == 1)
      {
        if (paramaulp.jdField_a_of_type_Aulo != null)
        {
          Iterator localIterator = paramaulp.jdField_a_of_type_Aulo.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          while (localIterator.hasNext()) {
            ((auls)localIterator.next()).a(paramaulp, paramInt);
          }
        }
      }
      else if (this.jdField_a_of_type_Aulr != null) {
        this.jdField_a_of_type_Aulr.a(paramaulp, paramInt);
      }
    }
  }
  
  public void a(aulr paramaulr)
  {
    this.jdField_a_of_type_Aulr = paramaulr;
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
        awfc localawfc = awes.a(7, 1);
        localawfc.a(paramMessageForPic, paramMessageForPic.getPicDownloadInfo());
        String str1 = bame.d(baul.a(paramMessageForPic, 131075, null).toString().toString());
        long l = paramMessageForPic.size;
        String str2 = a(paramMessageForPic.getPicDownloadInfo());
        if (a(str2) == null)
        {
          aulp localaulp = new aulp();
          localaulp.jdField_a_of_type_Aulo = aulo.a(paramMessageForPic);
          localaulp.d = 1;
          a(str2, localaulp);
        }
        localawfc.a(new aulw(this, paramLong, paramInt1, paramInt2, l, str2, str1));
        awes.a(localawfc, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    aulo localaulo;
    do
    {
      for (;;)
      {
        return;
        try
        {
          localaulo = aulo.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForShortVideo);
          if ((localaulo != null) && (localaulo.jdField_a_of_type_Ayzo != null))
          {
            paramMessageForShortVideo = a(paramMessageForShortVideo.getDownloadInfo(paramMessageForShortVideo.busiType));
            if (a(paramMessageForShortVideo) == null)
            {
              aulp localaulp = new aulp();
              localaulp.jdField_a_of_type_Aulo = localaulo;
              localaulp.d = 1;
              a(paramMessageForShortVideo, localaulp);
            }
            if ((!a(localaulo)) || (localaulo.jdField_a_of_type_Ayzo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (this.jdField_a_of_type_Agfw == null)) {
              break label244;
            }
            paramMessageForShortVideo = ShortVideoUtils.a(localaulo.jdField_a_of_type_Ayzo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
            this.jdField_a_of_type_Agfw.a(paramLong, paramInt1, paramInt2, 1, paramMessageForShortVideo, false);
            return;
          }
        }
        catch (Exception paramMessageForShortVideo) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("MultiRichMediaSaveManager", 2, "dealSaveVideo exception: " + paramMessageForShortVideo.getMessage());
    return;
    label244:
    localaulo.jdField_a_of_type_Ayzo.jdField_a_of_type_Boolean = true;
    localaulo.jdField_a_of_type_Ayzo.jdField_a_of_type_Ayzm = new aulx(this, paramLong, localaulo, paramMessageForShortVideo, paramInt1, paramInt2);
    ((ayzh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(95)).a(localaulo);
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
  
  public void a(String paramString, aulp paramaulp)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramaulp);
    }
  }
  
  public void a(List<aulo> paramList, int paramInt1, int paramInt2)
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
          switch (((aulo)paramList.next()).jdField_a_of_type_Int)
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
        azmj.b(null, "dc00898", "", "", str, str, paramInt2, 0, String.valueOf(paramInt1), String.valueOf(i), String.valueOf(j), String.valueOf(k));
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
  
  public void a(List<aulo> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "saveMultiRichMedialFile fileSaveReqList is empty!");
      }
      paramList = new aulp();
      paramList.jdField_a_of_type_Int = -1;
      paramList.b = 10006;
      paramList.jdField_a_of_type_JavaLangString = auln.a(10006);
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
        aulo localaulo = (aulo)paramList.next();
        if (a(localaulo)) {
          d(localaulo);
        } else if (!b(localaulo)) {
          c(localaulo);
        }
      }
    }
  }
  
  public boolean a(aulo paramaulo)
  {
    boolean bool2 = true;
    if (paramaulo == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFileExist fileSaveReq is empty!");
      }
    }
    do
    {
      return false;
      switch (paramaulo.jdField_a_of_type_Int)
      {
      default: 
        return false;
      }
    } while ((paramaulo.jdField_a_of_type_Awfc == null) || (paramaulo.jdField_a_of_type_Awfc.jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null));
    Object localObject = paramaulo.jdField_a_of_type_Awfc.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.getPicDownloadInfo();
    if (localObject != null)
    {
      localObject = ((aweu)localObject).c();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new File((String)localObject);
        if ((((File)localObject).exists()) && (((File)localObject).length() == paramaulo.jdField_a_of_type_Awfc.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size))
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
      if (paramaulo.jdField_a_of_type_Ayzo == null) {
        break;
      }
      localObject = ShortVideoUtils.a(paramaulo.jdField_a_of_type_Ayzo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
      if (localObject == null) {
        break;
      }
      localObject = new File((String)localObject);
      if ((!((File)localObject).exists()) || (paramaulo.jdField_a_of_type_Ayzo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (((File)localObject).length() != paramaulo.jdField_a_of_type_Ayzo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFileExist shortVideo exists");
      }
      return true;
      if (paramaulo.jdField_a_of_type_Arlp == null) {
        break;
      }
      return paramaulo.jdField_a_of_type_Arlp.a();
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
  
  public boolean a(List<aulo> paramList)
  {
    if ((!AppNetConnInfo.isWifiConn()) && (paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      long l = 0L;
      while (paramList.hasNext())
      {
        aulo localaulo = (aulo)paramList.next();
        if (!a(localaulo))
        {
          switch (localaulo.jdField_a_of_type_Int)
          {
          }
          for (;;)
          {
            break;
            if ((localaulo.jdField_a_of_type_Awfc != null) && (localaulo.jdField_a_of_type_Awfc.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null))
            {
              l += localaulo.jdField_a_of_type_Awfc.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
              continue;
              if ((localaulo.jdField_a_of_type_Ayzo != null) && (localaulo.jdField_a_of_type_Ayzo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
              {
                l += localaulo.jdField_a_of_type_Ayzo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
                continue;
                if (localaulo.jdField_a_of_type_Arlp != null) {
                  l += localaulo.jdField_a_of_type_Arlp.a();
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
    this.jdField_a_of_type_Aulr = null;
  }
  
  public void b(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "cancelSavePic id = " + paramLong);
    }
    paramMessageForPic = a(paramMessageForPic);
    aulp localaulp = a(paramMessageForPic);
    if (localaulp != null)
    {
      localaulp.jdField_a_of_type_Boolean = true;
      localaulp.jdField_a_of_type_Int = -1;
      a(paramMessageForPic, localaulp);
      e(localaulp);
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
    aulp localaulp = a(str);
    if (localaulp != null)
    {
      localaulp.jdField_a_of_type_Boolean = true;
      localaulp.jdField_a_of_type_Int = -1;
      a(str, localaulp);
      e(localaulp);
    }
    ((ayzh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(95)).b(aulo.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForShortVideo));
    a(str);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Agfw = null;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "clearFileSaveRequest");
    }
    j();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_Aulr = null;
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    this.c = false;
    this.jdField_a_of_type_Long = 0L;
    if (this.jdField_a_of_type_Aqqy != null)
    {
      this.jdField_a_of_type_Aqqy.b();
      this.jdField_a_of_type_Aqqy = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    aulp localaulp;
    if ((paramMessage.obj instanceof aulp))
    {
      localaulp = (aulp)paramMessage.obj;
      if (localaulp.jdField_a_of_type_Aulo == null) {}
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
          a(localaulp, paramMessage.arg1);
          return true;
        } while (localaulp.d != 1);
        e(localaulp.jdField_a_of_type_Aulo);
        return true;
        if (localaulp.d == 1)
        {
          d(localaulp);
          return true;
        }
        if (paramMessage.what == 2)
        {
          this.jdField_a_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            QLog.i("MultiRichMediaSaveManager", 2, "MSG_TYPE_SAVE_FAIL errorCode = " + localaulp.b + ", errorMsg = " + localaulp.jdField_a_of_type_JavaLangString);
          }
        }
        for (;;)
        {
          paramMessage = localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          while (paramMessage.hasNext()) {
            ((auls)paramMessage.next()).a(localaulp);
          }
          this.b = true;
        }
      } while (!a());
      b(localaulp, 100);
      if ((this.b) && (!this.jdField_a_of_type_Boolean)) {
        localaulp.jdField_a_of_type_Int = 0;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "last result = " + localaulp.jdField_a_of_type_Int);
        }
        this.jdField_a_of_type_Boolean = false;
        this.b = false;
        if (this.jdField_a_of_type_Aqqy != null)
        {
          this.jdField_a_of_type_Aqqy.b();
          this.jdField_a_of_type_Aqqy = null;
        }
        a(localaulp, 200L);
        return true;
        if ((this.jdField_a_of_type_Boolean) && (!this.b)) {
          localaulp.jdField_a_of_type_Int = -1;
        } else {
          localaulp.jdField_a_of_type_Int = 3;
        }
      }
    case 3: 
      paramMessage = localaulp.jdField_a_of_type_Aulo.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (paramMessage.hasNext()) {
        ((auls)paramMessage.next()).b(localaulp);
      }
    }
    a(localaulp);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ault
 * JD-Core Version:    0.7.0.1
 */