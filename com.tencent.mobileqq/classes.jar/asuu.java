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

public class asuu
  implements Handler.Callback, Manager
{
  private long jdField_a_of_type_Long;
  protected aejg a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private aoxw jdField_a_of_type_Aoxw;
  private asus jdField_a_of_type_Asus;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ConcurrentHashMap<String, asuq> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public asuu(QQAppInterface paramQQAppInterface)
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
        asuq localasuq = (asuq)((Map.Entry)localIterator.next()).getValue();
        if ((localasuq != null) && (localasuq.jdField_a_of_type_Asup != null)) {
          switch (localasuq.jdField_a_of_type_Asup.jdField_a_of_type_Int)
          {
          default: 
            break;
          case 1: 
            if ((localasuq.jdField_a_of_type_Asup.jdField_a_of_type_Aunt != null) && (localasuq.jdField_a_of_type_Asup.jdField_a_of_type_Aunt.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)) {
              this.jdField_a_of_type_Long += localasuq.jdField_a_of_type_Asup.jdField_a_of_type_Aunt.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
            }
            break;
          case 2: 
          case 3: 
            if ((localasuq.jdField_a_of_type_Asup.jdField_a_of_type_Axeg != null) && (localasuq.jdField_a_of_type_Asup.jdField_a_of_type_Axeg.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
              this.jdField_a_of_type_Long += localasuq.jdField_a_of_type_Asup.jdField_a_of_type_Axeg.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
            }
            break;
          case 4: 
          case 5: 
          case 6: 
          case 7: 
            if (localasuq.jdField_a_of_type_Asup.jdField_a_of_type_Apsj != null) {
              this.jdField_a_of_type_Long += localasuq.jdField_a_of_type_Asup.jdField_a_of_type_Apsj.a();
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
  
  private void a(int paramInt, asup paramasup)
  {
    asuq localasuq = new asuq();
    localasuq.jdField_a_of_type_Int = -1;
    localasuq.jdField_a_of_type_Asup = paramasup;
    localasuq.b = paramInt;
    localasuq.jdField_a_of_type_JavaLangString = asuo.a(paramInt);
    b(localasuq);
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
  
  private void a(apsj paramapsj)
  {
    if (paramapsj != null) {
      paramapsj.a(paramapsj.b(), new asuw(this, paramapsj));
    }
  }
  
  private void a(asup paramasup, int paramInt)
  {
    if ((paramasup != null) && (paramasup.jdField_a_of_type_Aunt != null))
    {
      paramasup = a(paramasup.jdField_a_of_type_Aunt.jdField_a_of_type_Aunl);
      asuq localasuq = a(paramasup);
      if ((localasuq != null) && (!localasuq.jdField_a_of_type_Boolean))
      {
        paramInt /= 100;
        localasuq.c = paramInt;
        a(paramasup, localasuq);
        c(localasuq, paramInt);
      }
    }
  }
  
  private void a(asup paramasup, boolean paramBoolean)
  {
    String str;
    asuq localasuq;
    if ((paramasup != null) && (paramasup.jdField_a_of_type_Apsj != null))
    {
      str = paramasup.jdField_a_of_type_Apsj.a();
      localasuq = a(str);
      if ((localasuq == null) || (localasuq.jdField_a_of_type_Boolean)) {
        break label97;
      }
      localasuq.jdField_a_of_type_Boolean = true;
      localasuq.c = 100;
      a(str, localasuq);
      if (!paramBoolean) {
        break label188;
      }
    }
    switch (paramasup.jdField_a_of_type_Int)
    {
    default: 
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("MultiRichMediaSaveManager", 2, "dealFileMultilDownloadComplete fileType= " + paramasup.jdField_a_of_type_Int);
      return;
    case 4: 
    case 6: 
      label97:
      paramasup = paramasup.jdField_a_of_type_Apsj.b();
      str = Utils.Crc64String(paramasup + NetConnInfoCenter.getServerTime());
      localasuq.jdField_a_of_type_Int = 0;
      a(paramasup, str, localasuq);
      return;
    }
    a(paramasup.jdField_a_of_type_Apsj);
    return;
    label188:
    if (QLog.isColorLevel()) {
      QLog.d("MultiRichMediaSaveManager", 2, "dealFileMultilDownloadComplete errorType= " + paramasup.jdField_a_of_type_Int);
    }
    localasuq.jdField_a_of_type_Int = -1;
    b(localasuq);
  }
  
  private void a(asuq paramasuq, long paramLong)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4);
    localMessage.obj = paramasuq;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  private void a(String paramString1, String paramString2, asuq paramasuq)
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
        if ((paramasuq != null) && (paramasuq.jdField_a_of_type_Asup != null))
        {
          paramasuq.jdField_a_of_type_Int = -1;
          paramasuq.b = i;
          paramasuq.jdField_a_of_type_JavaLangString = asuo.a(i);
          b(paramasuq);
        }
        return;
        if (TextUtils.isEmpty(paramString2))
        {
          i = 10002;
          continue;
        }
        if (!bbdj.a(paramString1)) {
          i = 10003;
        }
      }
      else
      {
        new File(ajsf.bc).mkdirs();
        String str = paramString2;
        if (!paramString2.contains("."))
        {
          str = bbdj.b(paramString1);
          str = paramString2 + "." + str;
        }
        paramString2 = new File(ajsf.bc, str);
        ThreadManager.getFileThreadHandler().post(new FileSaveRunnable(new File(paramString1), paramString2, this.jdField_a_of_type_AndroidOsHandler, paramasuq, false));
        return;
      }
      i = 0;
    }
  }
  
  private void a(List<asup> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((asup)paramList.next());
    }
  }
  
  private boolean a()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        asuq localasuq = (asuq)((Map.Entry)localIterator.next()).getValue();
        if ((localasuq == null) || (!localasuq.jdField_a_of_type_Boolean)) {
          return false;
        }
      }
    }
    return true;
  }
  
  private void b(asup paramasup)
  {
    String str;
    if (paramasup != null)
    {
      str = "";
      switch (paramasup.jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      a(str);
      return;
      if (paramasup.jdField_a_of_type_Aunt != null)
      {
        str = a(paramasup.jdField_a_of_type_Aunt.jdField_a_of_type_Aunl);
        continue;
        if (paramasup.jdField_a_of_type_Axeg != null)
        {
          str = a(paramasup.jdField_a_of_type_Axeg.jdField_a_of_type_Axdr);
          continue;
          if (paramasup.jdField_a_of_type_Apsj != null) {
            str = paramasup.jdField_a_of_type_Apsj.a();
          }
        }
      }
    }
  }
  
  private void b(asup paramasup, int paramInt1, int paramInt2, String paramString)
  {
    asuq localasuq;
    if ((paramasup != null) && (paramasup.jdField_a_of_type_Aunt != null) && (paramasup.jdField_a_of_type_Aunt.jdField_a_of_type_Aunl != null))
    {
      String str = a(paramasup.jdField_a_of_type_Aunt.jdField_a_of_type_Aunl);
      localasuq = a(str);
      if ((localasuq != null) && (localasuq.jdField_a_of_type_Asup != null) && (!localasuq.jdField_a_of_type_Boolean))
      {
        localasuq.jdField_a_of_type_Boolean = true;
        localasuq.jdField_a_of_type_Int = paramInt1;
        localasuq.c = 100;
        a(str, localasuq);
        if (paramInt1 != 0) {
          break label136;
        }
        paramasup = paramasup.jdField_a_of_type_Aunt.jdField_a_of_type_Aunl.c();
        a(paramasup, Utils.Crc64String(paramasup + NetConnInfoCenter.getServerTime()), localasuq);
      }
    }
    return;
    label136:
    localasuq.b = paramInt2;
    localasuq.jdField_a_of_type_JavaLangString = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("MultiRichMediaSaveManager", 2, "dealPicDownloadComplete errorCode= " + paramInt2 + ", errorDec= " + paramString);
    }
    b(localasuq);
  }
  
  private void b(asuq paramasuq)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
    localMessage.obj = paramasuq;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void b(asuq paramasuq, int paramInt)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(6);
    localMessage.obj = paramasuq;
    localMessage.arg1 = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void b(String paramString1, String paramString2, asuq paramasuq)
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
        if ((paramasuq != null) && (paramasuq.jdField_a_of_type_Asup != null))
        {
          paramasuq.jdField_a_of_type_Int = -1;
          paramasuq.b = i;
          paramasuq.jdField_a_of_type_JavaLangString = asuo.a(i);
          b(paramasuq);
        }
        return;
        if (TextUtils.isEmpty(paramString2))
        {
          i = 10002;
          continue;
        }
        if (!bbdj.a(paramString1)) {
          i = 10003;
        }
      }
      else
      {
        if (bfni.b()) {}
        for (File localFile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);; localFile = new File(ajsf.bq))
        {
          localFile.mkdirs();
          paramString2 = new File(localFile, ShortVideoUtils.b(paramString2));
          ThreadManager.getFileThreadHandler().post(new FileSaveRunnable(new File(paramString1), paramString2, this.jdField_a_of_type_AndroidOsHandler, paramasuq, false));
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
        asuq localasuq = (asuq)((Map.Entry)localIterator.next()).getValue();
        if ((localasuq != null) && (localasuq.d == 1) && (!localasuq.jdField_a_of_type_Boolean)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean b(asup paramasup)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramasup == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload fileSaveReq is empty!");
      }
      return false;
    }
    switch (paramasup.jdField_a_of_type_Int)
    {
    default: 
      bool2 = bool1;
      label74:
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      if ((paramasup.jdField_a_of_type_Aunt == null) || (paramasup.jdField_a_of_type_Aunt.jdField_a_of_type_Aunl == null) || (paramasup.jdField_a_of_type_Aunt.jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload picReq is empty!");
        return false;
      }
      if ((paramasup.jdField_a_of_type_Aunt.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) && (paramasup.jdField_a_of_type_Aunt.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.fileSizeFlag == 1)) {
        break;
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(ayvv.a(paramasup.jdField_a_of_type_Aunt.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.md5, paramasup.jdField_a_of_type_Aunt.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uuid, 1));
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if ((localObject instanceof ayou)) {
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (!bool1) {
        break label74;
      }
      localObject = (ayou)localObject;
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload picReq addDownCallback");
      }
      ((ayou)localObject).b(new asva(this, paramasup));
      continue;
      if ((paramasup.jdField_a_of_type_Axeg == null) || (paramasup.jdField_a_of_type_Axeg.jdField_a_of_type_Axdr == null))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload shortVideoReq is empty!");
        return false;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramasup.jdField_a_of_type_Axeg.jdField_a_of_type_Axdr.c, paramasup.jdField_a_of_type_Axeg.jdField_a_of_type_Axdr.jdField_a_of_type_Long);
      bool2 = bool1;
      if (localObject == null) {
        break label74;
      }
      bool2 = bool1;
      if (!(localObject instanceof ayou)) {
        break label74;
      }
      localObject = (ayou)localObject;
      if ((((ayou)localObject).a != null) && ((((ayou)localObject).a.b == 7) || (((ayou)localObject).a.b == 16) || (((ayou)localObject).a.b == 18)))
      {
        ((ayou)localObject).a();
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload shortVideoReq addDownCallback");
      }
      ((ayou)localObject).b(new asvb(this, paramasup));
      bool1 = false;
      continue;
      bool1 = false;
      continue;
      bool2 = bool1;
      if (paramasup.jdField_a_of_type_Apsj == null) {
        break label74;
      }
      bool2 = paramasup.jdField_a_of_type_Apsj.b();
      bool1 = bool2;
      if (bool2)
      {
        paramasup.jdField_a_of_type_Apsj.a(new asvc(this, paramasup));
        bool1 = bool2;
        if (this.jdField_a_of_type_Aoxw != null)
        {
          this.jdField_a_of_type_Aoxw.a(paramasup.jdField_a_of_type_Apsj.a());
          bool1 = bool2;
        }
      }
    }
  }
  
  private void c(asup paramasup)
  {
    if (paramasup == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "downloadFile fileSaveReq is empty!");
      }
      a(10007, new asup());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadFile fileType = " + paramasup.jdField_a_of_type_Int);
    }
    String str;
    switch (paramasup.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      if (paramasup.jdField_a_of_type_Aunt != null)
      {
        str = a(paramasup.jdField_a_of_type_Aunt.jdField_a_of_type_Aunl);
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "downloadPic key = " + str);
        }
        paramasup.jdField_a_of_type_Aunt.a(new asvd(this, str, paramasup));
        aunj.a(paramasup.jdField_a_of_type_Aunt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
      a(10007, paramasup);
      return;
    case 2: 
      if (paramasup.jdField_a_of_type_Axeg != null)
      {
        str = a(paramasup.jdField_a_of_type_Axeg.jdField_a_of_type_Axdr);
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "downloadShortVideo key = " + str);
        }
        paramasup.jdField_a_of_type_Axeg.a(new asve(this, str, paramasup));
        axdo.a(paramasup.jdField_a_of_type_Axeg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
      a(10007, paramasup);
      return;
    case 3: 
      if (paramasup.jdField_a_of_type_Axeg != null)
      {
        str = a(paramasup.jdField_a_of_type_Axeg.jdField_a_of_type_Axdr);
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "downloadVideo key = " + str);
        }
        paramasup.jdField_a_of_type_Axeg.jdField_a_of_type_Boolean = true;
        paramasup.jdField_a_of_type_Axeg.jdField_a_of_type_Axee = new asvf(this, paramasup, str);
        ((axeb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(95)).a(paramasup);
        return;
      }
      a(10007, paramasup);
      return;
    }
    if (paramasup.jdField_a_of_type_Apsj != null)
    {
      str = paramasup.jdField_a_of_type_Apsj.a();
      if (QLog.isColorLevel()) {
        QLog.i("MultiRichMediaSaveManager", 2, "downloadFile key = " + str);
      }
      paramasup.jdField_a_of_type_Apsj.a(new asvg(this, str, paramasup));
      if (this.jdField_a_of_type_Aoxw != null) {
        this.jdField_a_of_type_Aoxw.a(paramasup.jdField_a_of_type_Apsj.a());
      }
      paramasup.jdField_a_of_type_Apsj.a();
      return;
    }
    a(10007, paramasup);
  }
  
  private void c(asuq paramasuq)
  {
    HashMap localHashMap;
    if (paramasuq != null)
    {
      localHashMap = new HashMap();
      if (paramasuq.d != 1) {
        break label70;
      }
      localHashMap.put("isMultiSave", "1");
      if (paramasuq.jdField_a_of_type_Int != 0) {
        break label84;
      }
      localHashMap.put("isSuccess", "0");
    }
    for (;;)
    {
      axrl.a(BaseApplication.getContext()).a(null, "MultiRichMediaFileSave", true, 0L, 0L, localHashMap, "");
      return;
      label70:
      localHashMap.put("isMultiSave", "0");
      break;
      label84:
      localHashMap.put("isSuccess", "1");
      localHashMap.put("errorCode", String.valueOf(paramasuq.b));
      localHashMap.put("isSuccess", paramasuq.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void c(asuq paramasuq, int paramInt)
  {
    if (paramasuq != null)
    {
      paramasuq.c = paramInt;
      d(paramasuq, paramInt);
    }
  }
  
  private void d(asup paramasup)
  {
    if (paramasup != null) {}
    switch (paramasup.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      b(paramasup, 0, 0, "");
      return;
    case 2: 
    case 3: 
      a(paramasup, 0, 0, "");
      return;
    }
    a(paramasup, true);
  }
  
  private void d(asuq paramasuq)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "notifySingleComplete");
    }
    if (paramasuq != null)
    {
      a(paramasuq);
      if ((paramasuq.jdField_a_of_type_Asvh != null) && (this.jdField_a_of_type_Aejg != null)) {
        this.jdField_a_of_type_Aejg.a(paramasuq.jdField_a_of_type_Asvh.jdField_a_of_type_Long, paramasuq.jdField_a_of_type_Asvh.jdField_a_of_type_Int, paramasuq.jdField_a_of_type_Asvh.b, paramasuq.jdField_a_of_type_Asvh.c, paramasuq.jdField_a_of_type_Asvh.jdField_a_of_type_JavaLangString, paramasuq.jdField_a_of_type_Asvh.jdField_a_of_type_Boolean);
      }
    }
  }
  
  private void d(asuq paramasuq, int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    long l = 0L;
    if (localIterator.hasNext())
    {
      asuq localasuq = (asuq)((Map.Entry)localIterator.next()).getValue();
      if ((localasuq != null) && (localasuq.jdField_a_of_type_Asup != null)) {
        switch (localasuq.jdField_a_of_type_Asup.jdField_a_of_type_Int)
        {
        }
      }
      for (;;)
      {
        break;
        if ((localasuq.jdField_a_of_type_Asup.jdField_a_of_type_Aunt != null) && (localasuq.jdField_a_of_type_Asup.jdField_a_of_type_Aunt.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)) {
          if (localasuq.jdField_a_of_type_Boolean)
          {
            l += localasuq.jdField_a_of_type_Asup.jdField_a_of_type_Aunt.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
          }
          else
          {
            float f1 = (float)l;
            float f2 = (float)localasuq.jdField_a_of_type_Asup.jdField_a_of_type_Aunt.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
            l = (localasuq.c / 100.0F * f2 + f1);
            continue;
            if ((localasuq.jdField_a_of_type_Asup.jdField_a_of_type_Axeg != null) && (localasuq.jdField_a_of_type_Asup.jdField_a_of_type_Axeg.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
              if (localasuq.jdField_a_of_type_Boolean)
              {
                l += localasuq.jdField_a_of_type_Asup.jdField_a_of_type_Axeg.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
              }
              else
              {
                f1 = (float)l;
                f2 = localasuq.jdField_a_of_type_Asup.jdField_a_of_type_Axeg.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
                l = (localasuq.c / 100.0F * f2 + f1);
                continue;
                if (localasuq.jdField_a_of_type_Asup.jdField_a_of_type_Apsj != null) {
                  if (localasuq.jdField_a_of_type_Boolean)
                  {
                    l += localasuq.jdField_a_of_type_Asup.jdField_a_of_type_Apsj.a();
                  }
                  else
                  {
                    f1 = (float)l;
                    f2 = (float)localasuq.jdField_a_of_type_Asup.jdField_a_of_type_Apsj.a();
                    l = (localasuq.c / 100.0F * f2 + f1);
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
      paramasuq.d = 0;
      b(paramasuq, paramInt);
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
    if (this.jdField_a_of_type_Asus != null) {
      this.jdField_a_of_type_Asus.a();
    }
  }
  
  private void e(asup paramasup)
  {
    if (paramasup != null)
    {
      paramasup = paramasup.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (paramasup.hasNext()) {
        ((asut)paramasup.next()).a();
      }
    }
  }
  
  private void e(asuq paramasuq)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(5);
    localMessage.obj = paramasuq;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "saveCancel");
    }
    if (this.jdField_a_of_type_Asus != null) {
      this.jdField_a_of_type_Asus.b();
    }
    this.c = false;
    this.jdField_a_of_type_Long = 0L;
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "saveTips");
    }
    if (this.jdField_a_of_type_Asus != null) {
      this.jdField_a_of_type_Asus.c();
    }
  }
  
  private void h()
  {
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      asuq localasuq = (asuq)localEntry.getValue();
      if ((localasuq != null) && (localasuq.jdField_a_of_type_Asup != null) && (localasuq.d == 1))
      {
        Iterator localIterator2 = localasuq.jdField_a_of_type_Asup.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        while (localIterator2.hasNext()) {
          ((asut)localIterator2.next()).a();
        }
        localasuq.d = 0;
        a((String)localEntry.getKey(), localasuq);
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
    asuq localasuq;
    bbmi localbbmi;
    while (localIterator.hasNext())
    {
      localasuq = (asuq)((Map.Entry)localIterator.next()).getValue();
      if ((localasuq != null) && (localasuq.jdField_a_of_type_Asup != null)) {
        switch (localasuq.jdField_a_of_type_Asup.jdField_a_of_type_Int)
        {
        default: 
          break;
        case 1: 
          if ((localasuq.jdField_a_of_type_Asup.jdField_a_of_type_Aunt != null) && (localasuq.jdField_a_of_type_Asup.jdField_a_of_type_Aunt.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null))
          {
            localbbmi = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(ayvv.a(localasuq.jdField_a_of_type_Asup.jdField_a_of_type_Aunt.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.md5, localasuq.jdField_a_of_type_Asup.jdField_a_of_type_Aunt.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uuid, 131075));
            if (localbbmi != null) {
              break label406;
            }
            localbbmi = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(ayvv.a(localasuq.jdField_a_of_type_Asup.jdField_a_of_type_Aunt.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.md5, localasuq.jdField_a_of_type_Asup.jdField_a_of_type_Aunt.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uuid, 1));
          }
          break;
        }
      }
    }
    label406:
    for (;;)
    {
      if (!(localbbmi instanceof ayou)) {
        break label39;
      }
      ((ayou)localbbmi).a();
      break label39;
      if ((localasuq.jdField_a_of_type_Asup.jdField_a_of_type_Axeg != null) && (localasuq.jdField_a_of_type_Asup.jdField_a_of_type_Axeg.jdField_a_of_type_Axdr != null)) {}
      localbbmi = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localasuq.jdField_a_of_type_Asup.jdField_a_of_type_Axeg.jdField_a_of_type_Axdr.c, localasuq.jdField_a_of_type_Asup.jdField_a_of_type_Axeg.jdField_a_of_type_Axdr.jdField_a_of_type_Long);
      if (!(localbbmi instanceof ayou)) {
        break label39;
      }
      ((ayou)localbbmi).a();
      break label39;
      if ((localasuq.jdField_a_of_type_Asup.jdField_a_of_type_Axeg == null) || (localasuq.jdField_a_of_type_Asup.jdField_a_of_type_Axeg.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
        break label39;
      }
      ((axeb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(95)).b(localasuq.jdField_a_of_type_Asup);
      break label39;
      if (localasuq.jdField_a_of_type_Asup.jdField_a_of_type_Apsj == null) {
        break label39;
      }
      localasuq.jdField_a_of_type_Asup.jdField_a_of_type_Apsj.b();
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
        asuq localasuq = (asuq)((Map.Entry)localIterator.next()).getValue();
        if ((localasuq != null) && (localasuq.jdField_a_of_type_Asup != null)) {
          localasuq.jdField_a_of_type_Asup.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
        }
      }
    }
  }
  
  public asuq a(String paramString)
  {
    return (asuq)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public String a(aunl paramaunl)
  {
    if (paramaunl != null) {
      return paramaunl.c + paramaunl.jdField_a_of_type_Long;
    }
    return "";
  }
  
  public String a(axdr paramaxdr)
  {
    if (paramaxdr != null) {
      return paramaxdr.c + paramaxdr.jdField_a_of_type_Long;
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
  
  public void a(aejg paramaejg)
  {
    this.jdField_a_of_type_Aejg = paramaejg;
  }
  
  public void a(Activity paramActivity, List<asup> paramList)
  {
    a(paramActivity, bbcv.a(paramActivity, 230, paramActivity.getString(2131718826), paramActivity.getString(2131718825), new asuv(this, paramList), new asuz(this)));
  }
  
  public void a(asup paramasup)
  {
    if (paramasup != null) {
      switch (paramasup.jdField_a_of_type_Int)
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
            } while (paramasup.jdField_a_of_type_Aunt == null);
            localasuq = new asuq();
            localasuq.jdField_a_of_type_Asup = paramasup;
            paramasup = a(paramasup.jdField_a_of_type_Aunt.jdField_a_of_type_Aunl);
          } while (TextUtils.isEmpty(paramasup));
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramasup, localasuq);
          return;
        } while (paramasup.jdField_a_of_type_Axeg == null);
        localasuq = new asuq();
        localasuq.jdField_a_of_type_Asup = paramasup;
        paramasup = a(paramasup.jdField_a_of_type_Axeg.jdField_a_of_type_Axdr);
      } while (TextUtils.isEmpty(paramasup));
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramasup, localasuq);
      return;
      if (this.jdField_a_of_type_Aoxw == null)
      {
        this.jdField_a_of_type_Aoxw = new aoxw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_Aoxw.a();
      }
    } while (paramasup.jdField_a_of_type_Apsj == null);
    asuq localasuq = new asuq();
    localasuq.jdField_a_of_type_Asup = paramasup;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramasup.jdField_a_of_type_Apsj.a(), localasuq);
  }
  
  public void a(asup paramasup, int paramInt1, int paramInt2, String paramString)
  {
    asuq localasuq;
    if ((paramasup != null) && (paramasup.jdField_a_of_type_Axeg != null) && (paramasup.jdField_a_of_type_Axeg.jdField_a_of_type_Axdr != null))
    {
      String str = a(paramasup.jdField_a_of_type_Axeg.jdField_a_of_type_Axdr);
      localasuq = a(str);
      if ((localasuq != null) && (localasuq.jdField_a_of_type_Asup != null) && (!localasuq.jdField_a_of_type_Boolean))
      {
        localasuq.jdField_a_of_type_Boolean = true;
        localasuq.jdField_a_of_type_Int = paramInt1;
        localasuq.c = 100;
        a(str, localasuq);
        if (paramInt1 != 0) {
          break label196;
        }
        paramasup = new File(paramasup.jdField_a_of_type_Axeg.jdField_a_of_type_Axdr.h);
        if ((!paramasup.exists()) && (QLog.isColorLevel())) {
          QLog.d("MultiRichMediaSaveManager", 2, "dealShortVideoDownloadComplete srcFile not exists");
        }
        b(paramasup.getAbsolutePath(), new StringBuilder().append(paramasup.getParentFile().getName()).append(NetConnInfoCenter.getServerTime()).toString().toLowerCase(Locale.US) + ".mp4", localasuq);
      }
    }
    return;
    label196:
    localasuq.b = paramInt2;
    localasuq.jdField_a_of_type_JavaLangString = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("MultiRichMediaSaveManager", 2, "dealShortVideoDownloadComplete errorCode= " + paramInt2 + ", errorDec= " + paramString);
    }
    b(localasuq);
  }
  
  public void a(asuq paramasuq)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "saveComplete");
    }
    if (paramasuq != null)
    {
      if (paramasuq.d == 1)
      {
        if (paramasuq.jdField_a_of_type_Asup != null)
        {
          Iterator localIterator = paramasuq.jdField_a_of_type_Asup.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          while (localIterator.hasNext())
          {
            asut localasut = (asut)localIterator.next();
            if (paramasuq.jdField_a_of_type_Int == 0) {
              localasut.a(paramasuq, 100);
            }
            localasut.a(paramasuq);
          }
        }
        b(paramasuq.jdField_a_of_type_Asup);
        c(paramasuq);
      }
    }
    else {
      return;
    }
    if (this.jdField_a_of_type_Asus != null) {
      this.jdField_a_of_type_Asus.a(paramasuq);
    }
    this.c = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    c(paramasuq);
  }
  
  public void a(asuq paramasuq, int paramInt)
  {
    if (paramasuq != null) {
      if (paramasuq.d == 1)
      {
        if (paramasuq.jdField_a_of_type_Asup != null)
        {
          Iterator localIterator = paramasuq.jdField_a_of_type_Asup.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          while (localIterator.hasNext()) {
            ((asut)localIterator.next()).a(paramasuq, paramInt);
          }
        }
      }
      else if (this.jdField_a_of_type_Asus != null) {
        this.jdField_a_of_type_Asus.a(paramasuq, paramInt);
      }
    }
  }
  
  public void a(asus paramasus)
  {
    this.jdField_a_of_type_Asus = paramasus;
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
        aunt localaunt = aunj.a(7, 1);
        localaunt.a(paramMessageForPic, paramMessageForPic.getPicDownloadInfo());
        String str1 = ayog.d(aywk.a(paramMessageForPic, 131075, null).toString().toString());
        long l = paramMessageForPic.size;
        String str2 = a(paramMessageForPic.getPicDownloadInfo());
        if (a(str2) == null)
        {
          asuq localasuq = new asuq();
          localasuq.jdField_a_of_type_Asup = asup.a(paramMessageForPic);
          localasuq.d = 1;
          a(str2, localasuq);
        }
        localaunt.a(new asux(this, paramLong, paramInt1, paramInt2, l, str2, str1));
        aunj.a(localaunt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    asup localasup;
    do
    {
      for (;;)
      {
        return;
        try
        {
          localasup = asup.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForShortVideo);
          if ((localasup != null) && (localasup.jdField_a_of_type_Axeg != null))
          {
            paramMessageForShortVideo = a(paramMessageForShortVideo.getDownloadInfo(paramMessageForShortVideo.busiType));
            if (a(paramMessageForShortVideo) == null)
            {
              asuq localasuq = new asuq();
              localasuq.jdField_a_of_type_Asup = localasup;
              localasuq.d = 1;
              a(paramMessageForShortVideo, localasuq);
            }
            if ((!a(localasup)) || (localasup.jdField_a_of_type_Axeg.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (this.jdField_a_of_type_Aejg == null)) {
              break label244;
            }
            paramMessageForShortVideo = ShortVideoUtils.a(localasup.jdField_a_of_type_Axeg.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
            this.jdField_a_of_type_Aejg.a(paramLong, paramInt1, paramInt2, 1, paramMessageForShortVideo, false);
            return;
          }
        }
        catch (Exception paramMessageForShortVideo) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("MultiRichMediaSaveManager", 2, "dealSaveVideo exception: " + paramMessageForShortVideo.getMessage());
    return;
    label244:
    localasup.jdField_a_of_type_Axeg.jdField_a_of_type_Boolean = true;
    localasup.jdField_a_of_type_Axeg.jdField_a_of_type_Axee = new asuy(this, paramLong, localasup, paramMessageForShortVideo, paramInt1, paramInt2);
    ((axeb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(95)).a(localasup);
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
  
  public void a(String paramString, asuq paramasuq)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramasuq);
    }
  }
  
  public void a(List<asup> paramList, int paramInt1, int paramInt2)
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
          switch (((asup)paramList.next()).jdField_a_of_type_Int)
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
        axqw.b(null, "dc00898", "", "", str, str, paramInt2, 0, String.valueOf(paramInt1), String.valueOf(i), String.valueOf(j), String.valueOf(k));
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
  
  public void a(List<asup> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "saveMultiRichMedialFile fileSaveReqList is empty!");
      }
      paramList = new asuq();
      paramList.jdField_a_of_type_Int = -1;
      paramList.b = 10006;
      paramList.jdField_a_of_type_JavaLangString = asuo.a(10006);
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
        asup localasup = (asup)paramList.next();
        if (a(localasup)) {
          d(localasup);
        } else if (!b(localasup)) {
          c(localasup);
        }
      }
    }
  }
  
  public boolean a(asup paramasup)
  {
    boolean bool2 = true;
    if (paramasup == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFileExist fileSaveReq is empty!");
      }
    }
    do
    {
      return false;
      switch (paramasup.jdField_a_of_type_Int)
      {
      default: 
        return false;
      }
    } while ((paramasup.jdField_a_of_type_Aunt == null) || (paramasup.jdField_a_of_type_Aunt.jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null));
    Object localObject = paramasup.jdField_a_of_type_Aunt.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.getPicDownloadInfo();
    if (localObject != null)
    {
      localObject = ((aunl)localObject).c();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new File((String)localObject);
        if ((((File)localObject).exists()) && (((File)localObject).length() == paramasup.jdField_a_of_type_Aunt.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size))
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
      if (paramasup.jdField_a_of_type_Axeg == null) {
        break;
      }
      localObject = ShortVideoUtils.a(paramasup.jdField_a_of_type_Axeg.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
      if (localObject == null) {
        break;
      }
      localObject = new File((String)localObject);
      if ((!((File)localObject).exists()) || (paramasup.jdField_a_of_type_Axeg.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (((File)localObject).length() != paramasup.jdField_a_of_type_Axeg.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFileExist shortVideo exists");
      }
      return true;
      if (paramasup.jdField_a_of_type_Apsj == null) {
        break;
      }
      return paramasup.jdField_a_of_type_Apsj.a();
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
  
  public boolean a(List<asup> paramList)
  {
    if ((!AppNetConnInfo.isWifiConn()) && (paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      long l = 0L;
      while (paramList.hasNext())
      {
        asup localasup = (asup)paramList.next();
        if (!a(localasup))
        {
          switch (localasup.jdField_a_of_type_Int)
          {
          }
          for (;;)
          {
            break;
            if ((localasup.jdField_a_of_type_Aunt != null) && (localasup.jdField_a_of_type_Aunt.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null))
            {
              l += localasup.jdField_a_of_type_Aunt.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
              continue;
              if ((localasup.jdField_a_of_type_Axeg != null) && (localasup.jdField_a_of_type_Axeg.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
              {
                l += localasup.jdField_a_of_type_Axeg.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
                continue;
                if (localasup.jdField_a_of_type_Apsj != null) {
                  l += localasup.jdField_a_of_type_Apsj.a();
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
    this.jdField_a_of_type_Asus = null;
  }
  
  public void b(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "cancelSavePic id = " + paramLong);
    }
    paramMessageForPic = a(paramMessageForPic);
    asuq localasuq = a(paramMessageForPic);
    if (localasuq != null)
    {
      localasuq.jdField_a_of_type_Boolean = true;
      localasuq.jdField_a_of_type_Int = -1;
      a(paramMessageForPic, localasuq);
      e(localasuq);
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
    asuq localasuq = a(str);
    if (localasuq != null)
    {
      localasuq.jdField_a_of_type_Boolean = true;
      localasuq.jdField_a_of_type_Int = -1;
      a(str, localasuq);
      e(localasuq);
    }
    ((axeb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(95)).b(asup.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForShortVideo));
    a(str);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Aejg = null;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "clearFileSaveRequest");
    }
    j();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_Asus = null;
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    this.c = false;
    this.jdField_a_of_type_Long = 0L;
    if (this.jdField_a_of_type_Aoxw != null)
    {
      this.jdField_a_of_type_Aoxw.b();
      this.jdField_a_of_type_Aoxw = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    asuq localasuq;
    if ((paramMessage.obj instanceof asuq))
    {
      localasuq = (asuq)paramMessage.obj;
      if (localasuq.jdField_a_of_type_Asup == null) {}
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
          a(localasuq, paramMessage.arg1);
          return true;
        } while (localasuq.d != 1);
        e(localasuq.jdField_a_of_type_Asup);
        return true;
        if (localasuq.d == 1)
        {
          d(localasuq);
          return true;
        }
        if (paramMessage.what == 2)
        {
          this.jdField_a_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            QLog.i("MultiRichMediaSaveManager", 2, "MSG_TYPE_SAVE_FAIL errorCode = " + localasuq.b + ", errorMsg = " + localasuq.jdField_a_of_type_JavaLangString);
          }
        }
        for (;;)
        {
          paramMessage = localasuq.jdField_a_of_type_Asup.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          while (paramMessage.hasNext()) {
            ((asut)paramMessage.next()).a(localasuq);
          }
          this.b = true;
        }
      } while (!a());
      b(localasuq, 100);
      if ((this.b) && (!this.jdField_a_of_type_Boolean)) {
        localasuq.jdField_a_of_type_Int = 0;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "last result = " + localasuq.jdField_a_of_type_Int);
        }
        this.jdField_a_of_type_Boolean = false;
        this.b = false;
        if (this.jdField_a_of_type_Aoxw != null)
        {
          this.jdField_a_of_type_Aoxw.b();
          this.jdField_a_of_type_Aoxw = null;
        }
        a(localasuq, 200L);
        return true;
        if ((this.jdField_a_of_type_Boolean) && (!this.b)) {
          localasuq.jdField_a_of_type_Int = -1;
        } else {
          localasuq.jdField_a_of_type_Int = 3;
        }
      }
    case 3: 
      paramMessage = localasuq.jdField_a_of_type_Asup.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (paramMessage.hasNext()) {
        ((asut)paramMessage.next()).b(localasuq);
      }
    }
    a(localasuq);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     asuu
 * JD-Core Version:    0.7.0.1
 */