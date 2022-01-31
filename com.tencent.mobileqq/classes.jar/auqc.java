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

public class auqc
  implements Handler.Callback, Manager
{
  private long jdField_a_of_type_Long;
  protected agkl a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private aqvh jdField_a_of_type_Aqvh;
  private auqa jdField_a_of_type_Auqa;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ConcurrentHashMap<String, aupy> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public auqc(QQAppInterface paramQQAppInterface)
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
        aupy localaupy = (aupy)((Map.Entry)localIterator.next()).getValue();
        if ((localaupy != null) && (localaupy.jdField_a_of_type_Aupx != null)) {
          switch (localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_Int)
          {
          default: 
            break;
          case 1: 
            if ((localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_Awjl != null) && (localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_Awjl.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)) {
              this.jdField_a_of_type_Long += localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_Awjl.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
            }
            break;
          case 2: 
          case 3: 
            if ((localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_Azdx != null) && (localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_Azdx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
              this.jdField_a_of_type_Long += localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_Azdx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
            }
            break;
          case 4: 
          case 5: 
          case 6: 
          case 7: 
            if (localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_Arpy != null) {
              this.jdField_a_of_type_Long += localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_Arpy.a();
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
  
  private void a(int paramInt, aupx paramaupx)
  {
    aupy localaupy = new aupy();
    localaupy.jdField_a_of_type_Int = -1;
    localaupy.jdField_a_of_type_Aupx = paramaupx;
    localaupy.b = paramInt;
    localaupy.jdField_a_of_type_JavaLangString = aupw.a(paramInt);
    b(localaupy);
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
  
  private void a(arpy paramarpy)
  {
    if (paramarpy != null) {
      paramarpy.a(paramarpy.b(), new auqe(this, paramarpy));
    }
  }
  
  private void a(aupx paramaupx, int paramInt)
  {
    if ((paramaupx != null) && (paramaupx.jdField_a_of_type_Awjl != null))
    {
      paramaupx = a(paramaupx.jdField_a_of_type_Awjl.jdField_a_of_type_Awjd);
      aupy localaupy = a(paramaupx);
      if ((localaupy != null) && (!localaupy.jdField_a_of_type_Boolean))
      {
        paramInt /= 100;
        localaupy.c = paramInt;
        a(paramaupx, localaupy);
        c(localaupy, paramInt);
      }
    }
  }
  
  private void a(aupx paramaupx, boolean paramBoolean)
  {
    String str;
    aupy localaupy;
    if ((paramaupx != null) && (paramaupx.jdField_a_of_type_Arpy != null))
    {
      str = paramaupx.jdField_a_of_type_Arpy.a();
      localaupy = a(str);
      if ((localaupy == null) || (localaupy.jdField_a_of_type_Boolean)) {
        break label97;
      }
      localaupy.jdField_a_of_type_Boolean = true;
      localaupy.c = 100;
      a(str, localaupy);
      if (!paramBoolean) {
        break label188;
      }
    }
    switch (paramaupx.jdField_a_of_type_Int)
    {
    default: 
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("MultiRichMediaSaveManager", 2, "dealFileMultilDownloadComplete fileType= " + paramaupx.jdField_a_of_type_Int);
      return;
    case 4: 
    case 6: 
      label97:
      paramaupx = paramaupx.jdField_a_of_type_Arpy.b();
      str = Utils.Crc64String(paramaupx + NetConnInfoCenter.getServerTime());
      localaupy.jdField_a_of_type_Int = 0;
      a(paramaupx, str, localaupy);
      return;
    }
    a(paramaupx.jdField_a_of_type_Arpy);
    return;
    label188:
    if (QLog.isColorLevel()) {
      QLog.d("MultiRichMediaSaveManager", 2, "dealFileMultilDownloadComplete errorType= " + paramaupx.jdField_a_of_type_Int);
    }
    localaupy.jdField_a_of_type_Int = -1;
    b(localaupy);
  }
  
  private void a(aupy paramaupy, long paramLong)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4);
    localMessage.obj = paramaupy;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  private void a(String paramString1, String paramString2, aupy paramaupy)
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
        if ((paramaupy != null) && (paramaupy.jdField_a_of_type_Aupx != null))
        {
          paramaupy.jdField_a_of_type_Int = -1;
          paramaupy.b = i;
          paramaupy.jdField_a_of_type_JavaLangString = aupw.a(i);
          b(paramaupy);
        }
        return;
        if (TextUtils.isEmpty(paramString2))
        {
          i = 10002;
          continue;
        }
        if (!bdhb.a(paramString1)) {
          i = 10003;
        }
      }
      else
      {
        new File(alof.bd).mkdirs();
        String str = paramString2;
        if (!paramString2.contains("."))
        {
          str = bdhb.b(paramString1);
          str = paramString2 + "." + str;
        }
        paramString2 = new File(alof.bd, str);
        ThreadManager.getFileThreadHandler().post(new FileSaveRunnable(new File(paramString1), paramString2, this.jdField_a_of_type_AndroidOsHandler, paramaupy, false));
        return;
      }
      i = 0;
    }
  }
  
  private void a(List<aupx> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((aupx)paramList.next());
    }
  }
  
  private boolean a()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        aupy localaupy = (aupy)((Map.Entry)localIterator.next()).getValue();
        if ((localaupy == null) || (!localaupy.jdField_a_of_type_Boolean)) {
          return false;
        }
      }
    }
    return true;
  }
  
  private void b(aupx paramaupx)
  {
    String str;
    if (paramaupx != null)
    {
      str = "";
      switch (paramaupx.jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      a(str);
      return;
      if (paramaupx.jdField_a_of_type_Awjl != null)
      {
        str = a(paramaupx.jdField_a_of_type_Awjl.jdField_a_of_type_Awjd);
        continue;
        if (paramaupx.jdField_a_of_type_Azdx != null)
        {
          str = a(paramaupx.jdField_a_of_type_Azdx.jdField_a_of_type_Azdg);
          continue;
          if (paramaupx.jdField_a_of_type_Arpy != null) {
            str = paramaupx.jdField_a_of_type_Arpy.a();
          }
        }
      }
    }
  }
  
  private void b(aupx paramaupx, int paramInt1, int paramInt2, String paramString)
  {
    aupy localaupy;
    if ((paramaupx != null) && (paramaupx.jdField_a_of_type_Awjl != null) && (paramaupx.jdField_a_of_type_Awjl.jdField_a_of_type_Awjd != null))
    {
      String str = a(paramaupx.jdField_a_of_type_Awjl.jdField_a_of_type_Awjd);
      localaupy = a(str);
      if ((localaupy != null) && (localaupy.jdField_a_of_type_Aupx != null) && (!localaupy.jdField_a_of_type_Boolean))
      {
        localaupy.jdField_a_of_type_Boolean = true;
        localaupy.jdField_a_of_type_Int = paramInt1;
        localaupy.c = 100;
        a(str, localaupy);
        if (paramInt1 != 0) {
          break label136;
        }
        paramaupx = paramaupx.jdField_a_of_type_Awjl.jdField_a_of_type_Awjd.c();
        a(paramaupx, Utils.Crc64String(paramaupx + NetConnInfoCenter.getServerTime()), localaupy);
      }
    }
    return;
    label136:
    localaupy.b = paramInt2;
    localaupy.jdField_a_of_type_JavaLangString = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("MultiRichMediaSaveManager", 2, "dealPicDownloadComplete errorCode= " + paramInt2 + ", errorDec= " + paramString);
    }
    b(localaupy);
  }
  
  private void b(aupy paramaupy)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
    localMessage.obj = paramaupy;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void b(aupy paramaupy, int paramInt)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(6);
    localMessage.obj = paramaupy;
    localMessage.arg1 = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void b(String paramString1, String paramString2, aupy paramaupy)
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
        if ((paramaupy != null) && (paramaupy.jdField_a_of_type_Aupx != null))
        {
          paramaupy.jdField_a_of_type_Int = -1;
          paramaupy.b = i;
          paramaupy.jdField_a_of_type_JavaLangString = aupw.a(i);
          b(paramaupy);
        }
        return;
        if (TextUtils.isEmpty(paramString2))
        {
          i = 10002;
          continue;
        }
        if (!bdhb.a(paramString1)) {
          i = 10003;
        }
      }
      else
      {
        if (bhtb.b()) {}
        for (File localFile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);; localFile = new File(alof.br))
        {
          localFile.mkdirs();
          paramString2 = new File(localFile, ShortVideoUtils.b(paramString2));
          ThreadManager.getFileThreadHandler().post(new FileSaveRunnable(new File(paramString1), paramString2, this.jdField_a_of_type_AndroidOsHandler, paramaupy, false));
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
        aupy localaupy = (aupy)((Map.Entry)localIterator.next()).getValue();
        if ((localaupy != null) && (localaupy.d == 1) && (!localaupy.jdField_a_of_type_Boolean)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean b(aupx paramaupx)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramaupx == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload fileSaveReq is empty!");
      }
      return false;
    }
    switch (paramaupx.jdField_a_of_type_Int)
    {
    default: 
      bool2 = bool1;
      label74:
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      if ((paramaupx.jdField_a_of_type_Awjl == null) || (paramaupx.jdField_a_of_type_Awjl.jdField_a_of_type_Awjd == null) || (paramaupx.jdField_a_of_type_Awjl.jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload picReq is empty!");
        return false;
      }
      if ((paramaupx.jdField_a_of_type_Awjl.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) && (paramaupx.jdField_a_of_type_Awjl.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.fileSizeFlag == 1)) {
        break;
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(bayf.a(paramaupx.jdField_a_of_type_Awjl.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.md5, paramaupx.jdField_a_of_type_Awjl.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uuid, 1));
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if ((localObject instanceof bara)) {
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (!bool1) {
        break label74;
      }
      localObject = (bara)localObject;
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload picReq addDownCallback");
      }
      ((bara)localObject).b(new auqi(this, paramaupx));
      continue;
      if ((paramaupx.jdField_a_of_type_Azdx == null) || (paramaupx.jdField_a_of_type_Azdx.jdField_a_of_type_Azdg == null))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload shortVideoReq is empty!");
        return false;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramaupx.jdField_a_of_type_Azdx.jdField_a_of_type_Azdg.c, paramaupx.jdField_a_of_type_Azdx.jdField_a_of_type_Azdg.jdField_a_of_type_Long);
      bool2 = bool1;
      if (localObject == null) {
        break label74;
      }
      bool2 = bool1;
      if (!(localObject instanceof bara)) {
        break label74;
      }
      localObject = (bara)localObject;
      if ((((bara)localObject).a != null) && ((((bara)localObject).a.b == 7) || (((bara)localObject).a.b == 16) || (((bara)localObject).a.b == 18)))
      {
        ((bara)localObject).a();
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload shortVideoReq addDownCallback");
      }
      ((bara)localObject).b(new auqj(this, paramaupx));
      bool1 = false;
      continue;
      bool1 = false;
      continue;
      bool2 = bool1;
      if (paramaupx.jdField_a_of_type_Arpy == null) {
        break label74;
      }
      bool2 = paramaupx.jdField_a_of_type_Arpy.b();
      bool1 = bool2;
      if (bool2)
      {
        paramaupx.jdField_a_of_type_Arpy.a(new auqk(this, paramaupx));
        bool1 = bool2;
        if (this.jdField_a_of_type_Aqvh != null)
        {
          this.jdField_a_of_type_Aqvh.a(paramaupx.jdField_a_of_type_Arpy.a());
          bool1 = bool2;
        }
      }
    }
  }
  
  private void c(aupx paramaupx)
  {
    if (paramaupx == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "downloadFile fileSaveReq is empty!");
      }
      a(10007, new aupx());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadFile fileType = " + paramaupx.jdField_a_of_type_Int);
    }
    String str;
    switch (paramaupx.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      if (paramaupx.jdField_a_of_type_Awjl != null)
      {
        str = a(paramaupx.jdField_a_of_type_Awjl.jdField_a_of_type_Awjd);
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "downloadPic key = " + str);
        }
        paramaupx.jdField_a_of_type_Awjl.a(new auql(this, str, paramaupx));
        awjb.a(paramaupx.jdField_a_of_type_Awjl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
      a(10007, paramaupx);
      return;
    case 2: 
      if (paramaupx.jdField_a_of_type_Azdx != null)
      {
        str = a(paramaupx.jdField_a_of_type_Azdx.jdField_a_of_type_Azdg);
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "downloadShortVideo key = " + str);
        }
        paramaupx.jdField_a_of_type_Azdx.a(new auqm(this, str, paramaupx));
        azdd.a(paramaupx.jdField_a_of_type_Azdx, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
      a(10007, paramaupx);
      return;
    case 3: 
      if (paramaupx.jdField_a_of_type_Azdx != null)
      {
        str = a(paramaupx.jdField_a_of_type_Azdx.jdField_a_of_type_Azdg);
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "downloadVideo key = " + str);
        }
        paramaupx.jdField_a_of_type_Azdx.jdField_a_of_type_Boolean = true;
        paramaupx.jdField_a_of_type_Azdx.jdField_a_of_type_Azdv = new auqn(this, paramaupx, str);
        ((azdq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(95)).a(paramaupx);
        return;
      }
      a(10007, paramaupx);
      return;
    }
    if (paramaupx.jdField_a_of_type_Arpy != null)
    {
      str = paramaupx.jdField_a_of_type_Arpy.a();
      if (QLog.isColorLevel()) {
        QLog.i("MultiRichMediaSaveManager", 2, "downloadFile key = " + str);
      }
      paramaupx.jdField_a_of_type_Arpy.a(new auqo(this, str, paramaupx));
      if (this.jdField_a_of_type_Aqvh != null) {
        this.jdField_a_of_type_Aqvh.a(paramaupx.jdField_a_of_type_Arpy.a());
      }
      paramaupx.jdField_a_of_type_Arpy.a();
      return;
    }
    a(10007, paramaupx);
  }
  
  private void c(aupy paramaupy)
  {
    HashMap localHashMap;
    if (paramaupy != null)
    {
      localHashMap = new HashMap();
      if (paramaupy.d != 1) {
        break label70;
      }
      localHashMap.put("isMultiSave", "1");
      if (paramaupy.jdField_a_of_type_Int != 0) {
        break label84;
      }
      localHashMap.put("isSuccess", "0");
    }
    for (;;)
    {
      azri.a(BaseApplication.getContext()).a(null, "MultiRichMediaFileSave", true, 0L, 0L, localHashMap, "");
      return;
      label70:
      localHashMap.put("isMultiSave", "0");
      break;
      label84:
      localHashMap.put("isSuccess", "1");
      localHashMap.put("errorCode", String.valueOf(paramaupy.b));
      localHashMap.put("isSuccess", paramaupy.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void c(aupy paramaupy, int paramInt)
  {
    if (paramaupy != null)
    {
      paramaupy.c = paramInt;
      d(paramaupy, paramInt);
    }
  }
  
  private void d(aupx paramaupx)
  {
    if (paramaupx != null) {}
    switch (paramaupx.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      b(paramaupx, 0, 0, "");
      return;
    case 2: 
    case 3: 
      a(paramaupx, 0, 0, "");
      return;
    }
    a(paramaupx, true);
  }
  
  private void d(aupy paramaupy)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "notifySingleComplete");
    }
    if (paramaupy != null)
    {
      a(paramaupy);
      if ((paramaupy.jdField_a_of_type_Auqp != null) && (this.jdField_a_of_type_Agkl != null)) {
        this.jdField_a_of_type_Agkl.a(paramaupy.jdField_a_of_type_Auqp.jdField_a_of_type_Long, paramaupy.jdField_a_of_type_Auqp.jdField_a_of_type_Int, paramaupy.jdField_a_of_type_Auqp.b, paramaupy.jdField_a_of_type_Auqp.c, paramaupy.jdField_a_of_type_Auqp.jdField_a_of_type_JavaLangString, paramaupy.jdField_a_of_type_Auqp.jdField_a_of_type_Boolean);
      }
    }
  }
  
  private void d(aupy paramaupy, int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    long l = 0L;
    if (localIterator.hasNext())
    {
      aupy localaupy = (aupy)((Map.Entry)localIterator.next()).getValue();
      if ((localaupy != null) && (localaupy.jdField_a_of_type_Aupx != null)) {
        switch (localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_Int)
        {
        }
      }
      for (;;)
      {
        break;
        if ((localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_Awjl != null) && (localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_Awjl.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)) {
          if (localaupy.jdField_a_of_type_Boolean)
          {
            l += localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_Awjl.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
          }
          else
          {
            float f1 = (float)l;
            float f2 = (float)localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_Awjl.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
            l = (localaupy.c / 100.0F * f2 + f1);
            continue;
            if ((localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_Azdx != null) && (localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_Azdx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
              if (localaupy.jdField_a_of_type_Boolean)
              {
                l += localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_Azdx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
              }
              else
              {
                f1 = (float)l;
                f2 = localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_Azdx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
                l = (localaupy.c / 100.0F * f2 + f1);
                continue;
                if (localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_Arpy != null) {
                  if (localaupy.jdField_a_of_type_Boolean)
                  {
                    l += localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_Arpy.a();
                  }
                  else
                  {
                    f1 = (float)l;
                    f2 = (float)localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_Arpy.a();
                    l = (localaupy.c / 100.0F * f2 + f1);
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
      paramaupy.d = 0;
      b(paramaupy, paramInt);
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
    if (this.jdField_a_of_type_Auqa != null) {
      this.jdField_a_of_type_Auqa.a();
    }
  }
  
  private void e(aupx paramaupx)
  {
    if (paramaupx != null)
    {
      paramaupx = paramaupx.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (paramaupx.hasNext()) {
        ((auqb)paramaupx.next()).a();
      }
    }
  }
  
  private void e(aupy paramaupy)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(5);
    localMessage.obj = paramaupy;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "saveCancel");
    }
    if (this.jdField_a_of_type_Auqa != null) {
      this.jdField_a_of_type_Auqa.b();
    }
    this.c = false;
    this.jdField_a_of_type_Long = 0L;
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "saveTips");
    }
    if (this.jdField_a_of_type_Auqa != null) {
      this.jdField_a_of_type_Auqa.c();
    }
  }
  
  private void h()
  {
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      aupy localaupy = (aupy)localEntry.getValue();
      if ((localaupy != null) && (localaupy.jdField_a_of_type_Aupx != null) && (localaupy.d == 1))
      {
        Iterator localIterator2 = localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        while (localIterator2.hasNext()) {
          ((auqb)localIterator2.next()).a();
        }
        localaupy.d = 0;
        a((String)localEntry.getKey(), localaupy);
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
    aupy localaupy;
    bdpz localbdpz;
    while (localIterator.hasNext())
    {
      localaupy = (aupy)((Map.Entry)localIterator.next()).getValue();
      if ((localaupy != null) && (localaupy.jdField_a_of_type_Aupx != null)) {
        switch (localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_Int)
        {
        default: 
          break;
        case 1: 
          if ((localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_Awjl != null) && (localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_Awjl.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null))
          {
            localbdpz = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(bayf.a(localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_Awjl.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.md5, localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_Awjl.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uuid, 131075));
            if (localbdpz != null) {
              break label406;
            }
            localbdpz = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(bayf.a(localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_Awjl.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.md5, localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_Awjl.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uuid, 1));
          }
          break;
        }
      }
    }
    label406:
    for (;;)
    {
      if (!(localbdpz instanceof bara)) {
        break label39;
      }
      ((bara)localbdpz).a();
      break label39;
      if ((localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_Azdx != null) && (localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_Azdx.jdField_a_of_type_Azdg != null)) {}
      localbdpz = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_Azdx.jdField_a_of_type_Azdg.c, localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_Azdx.jdField_a_of_type_Azdg.jdField_a_of_type_Long);
      if (!(localbdpz instanceof bara)) {
        break label39;
      }
      ((bara)localbdpz).a();
      break label39;
      if ((localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_Azdx == null) || (localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_Azdx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
        break label39;
      }
      ((azdq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(95)).b(localaupy.jdField_a_of_type_Aupx);
      break label39;
      if (localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_Arpy == null) {
        break label39;
      }
      localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_Arpy.b();
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
        aupy localaupy = (aupy)((Map.Entry)localIterator.next()).getValue();
        if ((localaupy != null) && (localaupy.jdField_a_of_type_Aupx != null)) {
          localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
        }
      }
    }
  }
  
  public aupy a(String paramString)
  {
    return (aupy)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public String a(awjd paramawjd)
  {
    if (paramawjd != null) {
      return paramawjd.c + paramawjd.jdField_a_of_type_Long;
    }
    return "";
  }
  
  public String a(azdg paramazdg)
  {
    if (paramazdg != null) {
      return paramazdg.c + paramazdg.jdField_a_of_type_Long;
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
  
  public void a(agkl paramagkl)
  {
    this.jdField_a_of_type_Agkl = paramagkl;
  }
  
  public void a(Activity paramActivity, List<aupx> paramList)
  {
    a(paramActivity, bdgm.a(paramActivity, 230, paramActivity.getString(2131719324), paramActivity.getString(2131719323), new auqd(this, paramList), new auqh(this)));
  }
  
  public void a(aupx paramaupx)
  {
    if (paramaupx != null) {
      switch (paramaupx.jdField_a_of_type_Int)
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
            } while (paramaupx.jdField_a_of_type_Awjl == null);
            localaupy = new aupy();
            localaupy.jdField_a_of_type_Aupx = paramaupx;
            paramaupx = a(paramaupx.jdField_a_of_type_Awjl.jdField_a_of_type_Awjd);
          } while (TextUtils.isEmpty(paramaupx));
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramaupx, localaupy);
          return;
        } while (paramaupx.jdField_a_of_type_Azdx == null);
        localaupy = new aupy();
        localaupy.jdField_a_of_type_Aupx = paramaupx;
        paramaupx = a(paramaupx.jdField_a_of_type_Azdx.jdField_a_of_type_Azdg);
      } while (TextUtils.isEmpty(paramaupx));
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramaupx, localaupy);
      return;
      if (this.jdField_a_of_type_Aqvh == null)
      {
        this.jdField_a_of_type_Aqvh = new aqvh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_Aqvh.a();
      }
    } while (paramaupx.jdField_a_of_type_Arpy == null);
    aupy localaupy = new aupy();
    localaupy.jdField_a_of_type_Aupx = paramaupx;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramaupx.jdField_a_of_type_Arpy.a(), localaupy);
  }
  
  public void a(aupx paramaupx, int paramInt1, int paramInt2, String paramString)
  {
    aupy localaupy;
    if ((paramaupx != null) && (paramaupx.jdField_a_of_type_Azdx != null) && (paramaupx.jdField_a_of_type_Azdx.jdField_a_of_type_Azdg != null))
    {
      String str = a(paramaupx.jdField_a_of_type_Azdx.jdField_a_of_type_Azdg);
      localaupy = a(str);
      if ((localaupy != null) && (localaupy.jdField_a_of_type_Aupx != null) && (!localaupy.jdField_a_of_type_Boolean))
      {
        localaupy.jdField_a_of_type_Boolean = true;
        localaupy.jdField_a_of_type_Int = paramInt1;
        localaupy.c = 100;
        a(str, localaupy);
        if (paramInt1 != 0) {
          break label196;
        }
        paramaupx = new File(paramaupx.jdField_a_of_type_Azdx.jdField_a_of_type_Azdg.h);
        if ((!paramaupx.exists()) && (QLog.isColorLevel())) {
          QLog.d("MultiRichMediaSaveManager", 2, "dealShortVideoDownloadComplete srcFile not exists");
        }
        b(paramaupx.getAbsolutePath(), new StringBuilder().append(paramaupx.getParentFile().getName()).append(NetConnInfoCenter.getServerTime()).toString().toLowerCase(Locale.US) + ".mp4", localaupy);
      }
    }
    return;
    label196:
    localaupy.b = paramInt2;
    localaupy.jdField_a_of_type_JavaLangString = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("MultiRichMediaSaveManager", 2, "dealShortVideoDownloadComplete errorCode= " + paramInt2 + ", errorDec= " + paramString);
    }
    b(localaupy);
  }
  
  public void a(aupy paramaupy)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "saveComplete");
    }
    if (paramaupy != null)
    {
      if (paramaupy.d == 1)
      {
        if (paramaupy.jdField_a_of_type_Aupx != null)
        {
          Iterator localIterator = paramaupy.jdField_a_of_type_Aupx.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          while (localIterator.hasNext())
          {
            auqb localauqb = (auqb)localIterator.next();
            if (paramaupy.jdField_a_of_type_Int == 0) {
              localauqb.a(paramaupy, 100);
            }
            localauqb.a(paramaupy);
          }
        }
        b(paramaupy.jdField_a_of_type_Aupx);
        c(paramaupy);
      }
    }
    else {
      return;
    }
    if (this.jdField_a_of_type_Auqa != null) {
      this.jdField_a_of_type_Auqa.a(paramaupy);
    }
    this.c = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    c(paramaupy);
  }
  
  public void a(aupy paramaupy, int paramInt)
  {
    if (paramaupy != null) {
      if (paramaupy.d == 1)
      {
        if (paramaupy.jdField_a_of_type_Aupx != null)
        {
          Iterator localIterator = paramaupy.jdField_a_of_type_Aupx.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          while (localIterator.hasNext()) {
            ((auqb)localIterator.next()).a(paramaupy, paramInt);
          }
        }
      }
      else if (this.jdField_a_of_type_Auqa != null) {
        this.jdField_a_of_type_Auqa.a(paramaupy, paramInt);
      }
    }
  }
  
  public void a(auqa paramauqa)
  {
    this.jdField_a_of_type_Auqa = paramauqa;
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
        awjl localawjl = awjb.a(7, 1);
        localawjl.a(paramMessageForPic, paramMessageForPic.getPicDownloadInfo());
        String str1 = baqn.d(bayu.a(paramMessageForPic, 131075, null).toString().toString());
        long l = paramMessageForPic.size;
        String str2 = a(paramMessageForPic.getPicDownloadInfo());
        if (a(str2) == null)
        {
          aupy localaupy = new aupy();
          localaupy.jdField_a_of_type_Aupx = aupx.a(paramMessageForPic);
          localaupy.d = 1;
          a(str2, localaupy);
        }
        localawjl.a(new auqf(this, paramLong, paramInt1, paramInt2, l, str2, str1));
        awjb.a(localawjl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    aupx localaupx;
    do
    {
      for (;;)
      {
        return;
        try
        {
          localaupx = aupx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForShortVideo);
          if ((localaupx != null) && (localaupx.jdField_a_of_type_Azdx != null))
          {
            paramMessageForShortVideo = a(paramMessageForShortVideo.getDownloadInfo(paramMessageForShortVideo.busiType));
            if (a(paramMessageForShortVideo) == null)
            {
              aupy localaupy = new aupy();
              localaupy.jdField_a_of_type_Aupx = localaupx;
              localaupy.d = 1;
              a(paramMessageForShortVideo, localaupy);
            }
            if ((!a(localaupx)) || (localaupx.jdField_a_of_type_Azdx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (this.jdField_a_of_type_Agkl == null)) {
              break label244;
            }
            paramMessageForShortVideo = ShortVideoUtils.a(localaupx.jdField_a_of_type_Azdx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
            this.jdField_a_of_type_Agkl.a(paramLong, paramInt1, paramInt2, 1, paramMessageForShortVideo, false);
            return;
          }
        }
        catch (Exception paramMessageForShortVideo) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("MultiRichMediaSaveManager", 2, "dealSaveVideo exception: " + paramMessageForShortVideo.getMessage());
    return;
    label244:
    localaupx.jdField_a_of_type_Azdx.jdField_a_of_type_Boolean = true;
    localaupx.jdField_a_of_type_Azdx.jdField_a_of_type_Azdv = new auqg(this, paramLong, localaupx, paramMessageForShortVideo, paramInt1, paramInt2);
    ((azdq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(95)).a(localaupx);
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
  
  public void a(String paramString, aupy paramaupy)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramaupy);
    }
  }
  
  public void a(List<aupx> paramList, int paramInt1, int paramInt2)
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
          switch (((aupx)paramList.next()).jdField_a_of_type_Int)
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
        azqs.b(null, "dc00898", "", "", str, str, paramInt2, 0, String.valueOf(paramInt1), String.valueOf(i), String.valueOf(j), String.valueOf(k));
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
  
  public void a(List<aupx> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "saveMultiRichMedialFile fileSaveReqList is empty!");
      }
      paramList = new aupy();
      paramList.jdField_a_of_type_Int = -1;
      paramList.b = 10006;
      paramList.jdField_a_of_type_JavaLangString = aupw.a(10006);
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
        aupx localaupx = (aupx)paramList.next();
        if (a(localaupx)) {
          d(localaupx);
        } else if (!b(localaupx)) {
          c(localaupx);
        }
      }
    }
  }
  
  public boolean a(aupx paramaupx)
  {
    boolean bool2 = true;
    if (paramaupx == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFileExist fileSaveReq is empty!");
      }
    }
    do
    {
      return false;
      switch (paramaupx.jdField_a_of_type_Int)
      {
      default: 
        return false;
      }
    } while ((paramaupx.jdField_a_of_type_Awjl == null) || (paramaupx.jdField_a_of_type_Awjl.jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null));
    Object localObject = paramaupx.jdField_a_of_type_Awjl.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.getPicDownloadInfo();
    if (localObject != null)
    {
      localObject = ((awjd)localObject).c();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new File((String)localObject);
        if ((((File)localObject).exists()) && (((File)localObject).length() == paramaupx.jdField_a_of_type_Awjl.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size))
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
      if (paramaupx.jdField_a_of_type_Azdx == null) {
        break;
      }
      localObject = ShortVideoUtils.a(paramaupx.jdField_a_of_type_Azdx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
      if (localObject == null) {
        break;
      }
      localObject = new File((String)localObject);
      if ((!((File)localObject).exists()) || (paramaupx.jdField_a_of_type_Azdx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (((File)localObject).length() != paramaupx.jdField_a_of_type_Azdx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFileExist shortVideo exists");
      }
      return true;
      if (paramaupx.jdField_a_of_type_Arpy == null) {
        break;
      }
      return paramaupx.jdField_a_of_type_Arpy.a();
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
  
  public boolean a(List<aupx> paramList)
  {
    if ((!AppNetConnInfo.isWifiConn()) && (paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      long l = 0L;
      while (paramList.hasNext())
      {
        aupx localaupx = (aupx)paramList.next();
        if (!a(localaupx))
        {
          switch (localaupx.jdField_a_of_type_Int)
          {
          }
          for (;;)
          {
            break;
            if ((localaupx.jdField_a_of_type_Awjl != null) && (localaupx.jdField_a_of_type_Awjl.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null))
            {
              l += localaupx.jdField_a_of_type_Awjl.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
              continue;
              if ((localaupx.jdField_a_of_type_Azdx != null) && (localaupx.jdField_a_of_type_Azdx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
              {
                l += localaupx.jdField_a_of_type_Azdx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
                continue;
                if (localaupx.jdField_a_of_type_Arpy != null) {
                  l += localaupx.jdField_a_of_type_Arpy.a();
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
    this.jdField_a_of_type_Auqa = null;
  }
  
  public void b(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "cancelSavePic id = " + paramLong);
    }
    paramMessageForPic = a(paramMessageForPic);
    aupy localaupy = a(paramMessageForPic);
    if (localaupy != null)
    {
      localaupy.jdField_a_of_type_Boolean = true;
      localaupy.jdField_a_of_type_Int = -1;
      a(paramMessageForPic, localaupy);
      e(localaupy);
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
    aupy localaupy = a(str);
    if (localaupy != null)
    {
      localaupy.jdField_a_of_type_Boolean = true;
      localaupy.jdField_a_of_type_Int = -1;
      a(str, localaupy);
      e(localaupy);
    }
    ((azdq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(95)).b(aupx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForShortVideo));
    a(str);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Agkl = null;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "clearFileSaveRequest");
    }
    j();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_Auqa = null;
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    this.c = false;
    this.jdField_a_of_type_Long = 0L;
    if (this.jdField_a_of_type_Aqvh != null)
    {
      this.jdField_a_of_type_Aqvh.b();
      this.jdField_a_of_type_Aqvh = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    aupy localaupy;
    if ((paramMessage.obj instanceof aupy))
    {
      localaupy = (aupy)paramMessage.obj;
      if (localaupy.jdField_a_of_type_Aupx == null) {}
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
          a(localaupy, paramMessage.arg1);
          return true;
        } while (localaupy.d != 1);
        e(localaupy.jdField_a_of_type_Aupx);
        return true;
        if (localaupy.d == 1)
        {
          d(localaupy);
          return true;
        }
        if (paramMessage.what == 2)
        {
          this.jdField_a_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            QLog.i("MultiRichMediaSaveManager", 2, "MSG_TYPE_SAVE_FAIL errorCode = " + localaupy.b + ", errorMsg = " + localaupy.jdField_a_of_type_JavaLangString);
          }
        }
        for (;;)
        {
          paramMessage = localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          while (paramMessage.hasNext()) {
            ((auqb)paramMessage.next()).a(localaupy);
          }
          this.b = true;
        }
      } while (!a());
      b(localaupy, 100);
      if ((this.b) && (!this.jdField_a_of_type_Boolean)) {
        localaupy.jdField_a_of_type_Int = 0;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "last result = " + localaupy.jdField_a_of_type_Int);
        }
        this.jdField_a_of_type_Boolean = false;
        this.b = false;
        if (this.jdField_a_of_type_Aqvh != null)
        {
          this.jdField_a_of_type_Aqvh.b();
          this.jdField_a_of_type_Aqvh = null;
        }
        a(localaupy, 200L);
        return true;
        if ((this.jdField_a_of_type_Boolean) && (!this.b)) {
          localaupy.jdField_a_of_type_Int = -1;
        } else {
          localaupy.jdField_a_of_type_Int = 3;
        }
      }
    case 3: 
      paramMessage = localaupy.jdField_a_of_type_Aupx.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (paramMessage.hasNext()) {
        ((auqb)paramMessage.next()).b(localaupy);
      }
    }
    a(localaupy);
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
 * Qualified Name:     auqc
 * JD-Core Version:    0.7.0.1
 */