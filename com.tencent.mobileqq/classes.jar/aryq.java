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

public class aryq
  implements Handler.Callback, Manager
{
  private long jdField_a_of_type_Long;
  protected adyh a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private aohc jdField_a_of_type_Aohc;
  private aryo jdField_a_of_type_Aryo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ConcurrentHashMap<String, arym> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public aryq(QQAppInterface paramQQAppInterface)
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
        arym localarym = (arym)((Map.Entry)localIterator.next()).getValue();
        if ((localarym != null) && (localarym.jdField_a_of_type_Aryl != null)) {
          switch (localarym.jdField_a_of_type_Aryl.jdField_a_of_type_Int)
          {
          default: 
            break;
          case 1: 
            if ((localarym.jdField_a_of_type_Aryl.jdField_a_of_type_Atpv != null) && (localarym.jdField_a_of_type_Aryl.jdField_a_of_type_Atpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)) {
              this.jdField_a_of_type_Long += localarym.jdField_a_of_type_Aryl.jdField_a_of_type_Atpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
            }
            break;
          case 2: 
          case 3: 
            if ((localarym.jdField_a_of_type_Aryl.jdField_a_of_type_Awey != null) && (localarym.jdField_a_of_type_Aryl.jdField_a_of_type_Awey.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
              this.jdField_a_of_type_Long += localarym.jdField_a_of_type_Aryl.jdField_a_of_type_Awey.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
            }
            break;
          case 4: 
          case 5: 
          case 6: 
          case 7: 
            if (localarym.jdField_a_of_type_Aryl.jdField_a_of_type_Apap != null) {
              this.jdField_a_of_type_Long += localarym.jdField_a_of_type_Aryl.jdField_a_of_type_Apap.a();
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
  
  private void a(int paramInt, aryl paramaryl)
  {
    arym localarym = new arym();
    localarym.jdField_a_of_type_Int = -1;
    localarym.jdField_a_of_type_Aryl = paramaryl;
    localarym.b = paramInt;
    localarym.jdField_a_of_type_JavaLangString = aryk.a(paramInt);
    b(localarym);
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
  
  private void a(apap paramapap)
  {
    if (paramapap != null) {
      paramapap.a(paramapap.b(), new arys(this, paramapap));
    }
  }
  
  private void a(aryl paramaryl, int paramInt)
  {
    if ((paramaryl != null) && (paramaryl.jdField_a_of_type_Atpv != null))
    {
      paramaryl = a(paramaryl.jdField_a_of_type_Atpv.jdField_a_of_type_Atpn);
      arym localarym = a(paramaryl);
      if ((localarym != null) && (!localarym.jdField_a_of_type_Boolean))
      {
        paramInt /= 100;
        localarym.c = paramInt;
        a(paramaryl, localarym);
        c(localarym, paramInt);
      }
    }
  }
  
  private void a(aryl paramaryl, boolean paramBoolean)
  {
    String str;
    arym localarym;
    if ((paramaryl != null) && (paramaryl.jdField_a_of_type_Apap != null))
    {
      str = paramaryl.jdField_a_of_type_Apap.a();
      localarym = a(str);
      if ((localarym == null) || (localarym.jdField_a_of_type_Boolean)) {
        break label97;
      }
      localarym.jdField_a_of_type_Boolean = true;
      localarym.c = 100;
      a(str, localarym);
      if (!paramBoolean) {
        break label188;
      }
    }
    switch (paramaryl.jdField_a_of_type_Int)
    {
    default: 
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("MultiRichMediaSaveManager", 2, "dealFileMultilDownloadComplete fileType= " + paramaryl.jdField_a_of_type_Int);
      return;
    case 4: 
    case 6: 
      label97:
      paramaryl = paramaryl.jdField_a_of_type_Apap.b();
      str = Utils.Crc64String(paramaryl + NetConnInfoCenter.getServerTime());
      localarym.jdField_a_of_type_Int = 0;
      a(paramaryl, str, localarym);
      return;
    }
    a(paramaryl.jdField_a_of_type_Apap);
    return;
    label188:
    if (QLog.isColorLevel()) {
      QLog.d("MultiRichMediaSaveManager", 2, "dealFileMultilDownloadComplete errorType= " + paramaryl.jdField_a_of_type_Int);
    }
    localarym.jdField_a_of_type_Int = -1;
    b(localarym);
  }
  
  private void a(arym paramarym, long paramLong)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4);
    localMessage.obj = paramarym;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  private void a(String paramString1, String paramString2, arym paramarym)
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
        if ((paramarym != null) && (paramarym.jdField_a_of_type_Aryl != null))
        {
          paramarym.jdField_a_of_type_Int = -1;
          paramarym.b = i;
          paramarym.jdField_a_of_type_JavaLangString = aryk.a(i);
          b(paramarym);
        }
        return;
        if (TextUtils.isEmpty(paramString2))
        {
          i = 10002;
          continue;
        }
        if (!bace.a(paramString1)) {
          i = 10003;
        }
      }
      else
      {
        new File(ajed.ba).mkdirs();
        String str = paramString2;
        if (!paramString2.contains("."))
        {
          str = bace.b(paramString1);
          str = paramString2 + "." + str;
        }
        paramString2 = new File(ajed.ba, str);
        ThreadManager.getFileThreadHandler().post(new FileSaveRunnable(new File(paramString1), paramString2, this.jdField_a_of_type_AndroidOsHandler, paramarym, false));
        return;
      }
      i = 0;
    }
  }
  
  private void a(List<aryl> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((aryl)paramList.next());
    }
  }
  
  private boolean a()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        arym localarym = (arym)((Map.Entry)localIterator.next()).getValue();
        if ((localarym == null) || (!localarym.jdField_a_of_type_Boolean)) {
          return false;
        }
      }
    }
    return true;
  }
  
  private void b(aryl paramaryl)
  {
    String str;
    if (paramaryl != null)
    {
      str = "";
      switch (paramaryl.jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      a(str);
      return;
      if (paramaryl.jdField_a_of_type_Atpv != null)
      {
        str = a(paramaryl.jdField_a_of_type_Atpv.jdField_a_of_type_Atpn);
        continue;
        if (paramaryl.jdField_a_of_type_Awey != null)
        {
          str = a(paramaryl.jdField_a_of_type_Awey.jdField_a_of_type_Awej);
          continue;
          if (paramaryl.jdField_a_of_type_Apap != null) {
            str = paramaryl.jdField_a_of_type_Apap.a();
          }
        }
      }
    }
  }
  
  private void b(aryl paramaryl, int paramInt1, int paramInt2, String paramString)
  {
    arym localarym;
    if ((paramaryl != null) && (paramaryl.jdField_a_of_type_Atpv != null) && (paramaryl.jdField_a_of_type_Atpv.jdField_a_of_type_Atpn != null))
    {
      String str = a(paramaryl.jdField_a_of_type_Atpv.jdField_a_of_type_Atpn);
      localarym = a(str);
      if ((localarym != null) && (localarym.jdField_a_of_type_Aryl != null) && (!localarym.jdField_a_of_type_Boolean))
      {
        localarym.jdField_a_of_type_Boolean = true;
        localarym.jdField_a_of_type_Int = paramInt1;
        localarym.c = 100;
        a(str, localarym);
        if (paramInt1 != 0) {
          break label136;
        }
        paramaryl = paramaryl.jdField_a_of_type_Atpv.jdField_a_of_type_Atpn.c();
        a(paramaryl, Utils.Crc64String(paramaryl + NetConnInfoCenter.getServerTime()), localarym);
      }
    }
    return;
    label136:
    localarym.b = paramInt2;
    localarym.jdField_a_of_type_JavaLangString = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("MultiRichMediaSaveManager", 2, "dealPicDownloadComplete errorCode= " + paramInt2 + ", errorDec= " + paramString);
    }
    b(localarym);
  }
  
  private void b(arym paramarym)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
    localMessage.obj = paramarym;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void b(arym paramarym, int paramInt)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(6);
    localMessage.obj = paramarym;
    localMessage.arg1 = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void b(String paramString1, String paramString2, arym paramarym)
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
        if ((paramarym != null) && (paramarym.jdField_a_of_type_Aryl != null))
        {
          paramarym.jdField_a_of_type_Int = -1;
          paramarym.b = i;
          paramarym.jdField_a_of_type_JavaLangString = aryk.a(i);
          b(paramarym);
        }
        return;
        if (TextUtils.isEmpty(paramString2))
        {
          i = 10002;
          continue;
        }
        if (!bace.a(paramString1)) {
          i = 10003;
        }
      }
      else
      {
        if (befo.b()) {}
        for (File localFile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);; localFile = new File(ajed.bo))
        {
          localFile.mkdirs();
          paramString2 = new File(localFile, ShortVideoUtils.b(paramString2));
          ThreadManager.getFileThreadHandler().post(new FileSaveRunnable(new File(paramString1), paramString2, this.jdField_a_of_type_AndroidOsHandler, paramarym, false));
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
        arym localarym = (arym)((Map.Entry)localIterator.next()).getValue();
        if ((localarym != null) && (localarym.d == 1) && (!localarym.jdField_a_of_type_Boolean)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean b(aryl paramaryl)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramaryl == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload fileSaveReq is empty!");
      }
      return false;
    }
    switch (paramaryl.jdField_a_of_type_Int)
    {
    default: 
      bool2 = bool1;
      label74:
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      if ((paramaryl.jdField_a_of_type_Atpv == null) || (paramaryl.jdField_a_of_type_Atpv.jdField_a_of_type_Atpn == null) || (paramaryl.jdField_a_of_type_Atpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload picReq is empty!");
        return false;
      }
      if ((paramaryl.jdField_a_of_type_Atpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) && (paramaryl.jdField_a_of_type_Atpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.fileSizeFlag == 1)) {
        break;
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(axvo.a(paramaryl.jdField_a_of_type_Atpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.md5, paramaryl.jdField_a_of_type_Atpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uuid, 1));
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if ((localObject instanceof axoo)) {
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (!bool1) {
        break label74;
      }
      localObject = (axoo)localObject;
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload picReq addDownCallback");
      }
      ((axoo)localObject).b(new aryw(this, paramaryl));
      continue;
      if ((paramaryl.jdField_a_of_type_Awey == null) || (paramaryl.jdField_a_of_type_Awey.jdField_a_of_type_Awej == null))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload shortVideoReq is empty!");
        return false;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramaryl.jdField_a_of_type_Awey.jdField_a_of_type_Awej.c, paramaryl.jdField_a_of_type_Awey.jdField_a_of_type_Awej.jdField_a_of_type_Long);
      bool2 = bool1;
      if (localObject == null) {
        break label74;
      }
      bool2 = bool1;
      if (!(localObject instanceof axoo)) {
        break label74;
      }
      localObject = (axoo)localObject;
      if ((((axoo)localObject).a != null) && ((((axoo)localObject).a.b == 7) || (((axoo)localObject).a.b == 16) || (((axoo)localObject).a.b == 18)))
      {
        ((axoo)localObject).a();
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload shortVideoReq addDownCallback");
      }
      ((axoo)localObject).b(new aryx(this, paramaryl));
      bool1 = false;
      continue;
      bool1 = false;
      continue;
      bool2 = bool1;
      if (paramaryl.jdField_a_of_type_Apap == null) {
        break label74;
      }
      bool2 = paramaryl.jdField_a_of_type_Apap.b();
      bool1 = bool2;
      if (bool2)
      {
        paramaryl.jdField_a_of_type_Apap.a(new aryy(this, paramaryl));
        bool1 = bool2;
        if (this.jdField_a_of_type_Aohc != null)
        {
          this.jdField_a_of_type_Aohc.a(paramaryl.jdField_a_of_type_Apap.a());
          bool1 = bool2;
        }
      }
    }
  }
  
  private void c(aryl paramaryl)
  {
    if (paramaryl == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "downloadFile fileSaveReq is empty!");
      }
      a(10007, new aryl());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadFile fileType = " + paramaryl.jdField_a_of_type_Int);
    }
    String str;
    switch (paramaryl.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      if (paramaryl.jdField_a_of_type_Atpv != null)
      {
        str = a(paramaryl.jdField_a_of_type_Atpv.jdField_a_of_type_Atpn);
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "downloadPic key = " + str);
        }
        paramaryl.jdField_a_of_type_Atpv.a(new aryz(this, str, paramaryl));
        atpl.a(paramaryl.jdField_a_of_type_Atpv, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
      a(10007, paramaryl);
      return;
    case 2: 
      if (paramaryl.jdField_a_of_type_Awey != null)
      {
        str = a(paramaryl.jdField_a_of_type_Awey.jdField_a_of_type_Awej);
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "downloadShortVideo key = " + str);
        }
        paramaryl.jdField_a_of_type_Awey.a(new arza(this, str, paramaryl));
        aweg.a(paramaryl.jdField_a_of_type_Awey, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
      a(10007, paramaryl);
      return;
    case 3: 
      if (paramaryl.jdField_a_of_type_Awey != null)
      {
        str = a(paramaryl.jdField_a_of_type_Awey.jdField_a_of_type_Awej);
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "downloadVideo key = " + str);
        }
        paramaryl.jdField_a_of_type_Awey.jdField_a_of_type_Boolean = true;
        paramaryl.jdField_a_of_type_Awey.jdField_a_of_type_Awew = new arzb(this, paramaryl, str);
        ((awet)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(95)).a(paramaryl);
        return;
      }
      a(10007, paramaryl);
      return;
    }
    if (paramaryl.jdField_a_of_type_Apap != null)
    {
      str = paramaryl.jdField_a_of_type_Apap.a();
      if (QLog.isColorLevel()) {
        QLog.i("MultiRichMediaSaveManager", 2, "downloadFile key = " + str);
      }
      paramaryl.jdField_a_of_type_Apap.a(new arzc(this, str, paramaryl));
      if (this.jdField_a_of_type_Aohc != null) {
        this.jdField_a_of_type_Aohc.a(paramaryl.jdField_a_of_type_Apap.a());
      }
      paramaryl.jdField_a_of_type_Apap.a();
      return;
    }
    a(10007, paramaryl);
  }
  
  private void c(arym paramarym)
  {
    HashMap localHashMap;
    if (paramarym != null)
    {
      localHashMap = new HashMap();
      if (paramarym.d != 1) {
        break label70;
      }
      localHashMap.put("isMultiSave", "1");
      if (paramarym.jdField_a_of_type_Int != 0) {
        break label84;
      }
      localHashMap.put("isSuccess", "0");
    }
    for (;;)
    {
      awrn.a(BaseApplication.getContext()).a(null, "MultiRichMediaFileSave", true, 0L, 0L, localHashMap, "");
      return;
      label70:
      localHashMap.put("isMultiSave", "0");
      break;
      label84:
      localHashMap.put("isSuccess", "1");
      localHashMap.put("errorCode", String.valueOf(paramarym.b));
      localHashMap.put("isSuccess", paramarym.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void c(arym paramarym, int paramInt)
  {
    if (paramarym != null)
    {
      paramarym.c = paramInt;
      d(paramarym, paramInt);
    }
  }
  
  private void d(aryl paramaryl)
  {
    if (paramaryl != null) {}
    switch (paramaryl.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      b(paramaryl, 0, 0, "");
      return;
    case 2: 
    case 3: 
      a(paramaryl, 0, 0, "");
      return;
    }
    a(paramaryl, true);
  }
  
  private void d(arym paramarym)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "notifySingleComplete");
    }
    if (paramarym != null)
    {
      a(paramarym);
      if ((paramarym.jdField_a_of_type_Arzd != null) && (this.jdField_a_of_type_Adyh != null)) {
        this.jdField_a_of_type_Adyh.a(paramarym.jdField_a_of_type_Arzd.jdField_a_of_type_Long, paramarym.jdField_a_of_type_Arzd.jdField_a_of_type_Int, paramarym.jdField_a_of_type_Arzd.b, paramarym.jdField_a_of_type_Arzd.c, paramarym.jdField_a_of_type_Arzd.jdField_a_of_type_JavaLangString, paramarym.jdField_a_of_type_Arzd.jdField_a_of_type_Boolean);
      }
    }
  }
  
  private void d(arym paramarym, int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    long l = 0L;
    if (localIterator.hasNext())
    {
      arym localarym = (arym)((Map.Entry)localIterator.next()).getValue();
      if ((localarym != null) && (localarym.jdField_a_of_type_Aryl != null)) {
        switch (localarym.jdField_a_of_type_Aryl.jdField_a_of_type_Int)
        {
        }
      }
      for (;;)
      {
        break;
        if ((localarym.jdField_a_of_type_Aryl.jdField_a_of_type_Atpv != null) && (localarym.jdField_a_of_type_Aryl.jdField_a_of_type_Atpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)) {
          if (localarym.jdField_a_of_type_Boolean)
          {
            l += localarym.jdField_a_of_type_Aryl.jdField_a_of_type_Atpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
          }
          else
          {
            float f1 = (float)l;
            float f2 = (float)localarym.jdField_a_of_type_Aryl.jdField_a_of_type_Atpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
            l = (localarym.c / 100.0F * f2 + f1);
            continue;
            if ((localarym.jdField_a_of_type_Aryl.jdField_a_of_type_Awey != null) && (localarym.jdField_a_of_type_Aryl.jdField_a_of_type_Awey.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
              if (localarym.jdField_a_of_type_Boolean)
              {
                l += localarym.jdField_a_of_type_Aryl.jdField_a_of_type_Awey.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
              }
              else
              {
                f1 = (float)l;
                f2 = localarym.jdField_a_of_type_Aryl.jdField_a_of_type_Awey.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
                l = (localarym.c / 100.0F * f2 + f1);
                continue;
                if (localarym.jdField_a_of_type_Aryl.jdField_a_of_type_Apap != null) {
                  if (localarym.jdField_a_of_type_Boolean)
                  {
                    l += localarym.jdField_a_of_type_Aryl.jdField_a_of_type_Apap.a();
                  }
                  else
                  {
                    f1 = (float)l;
                    f2 = (float)localarym.jdField_a_of_type_Aryl.jdField_a_of_type_Apap.a();
                    l = (localarym.c / 100.0F * f2 + f1);
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
      paramarym.d = 0;
      b(paramarym, paramInt);
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
    if (this.jdField_a_of_type_Aryo != null) {
      this.jdField_a_of_type_Aryo.a();
    }
  }
  
  private void e(aryl paramaryl)
  {
    if (paramaryl != null)
    {
      paramaryl = paramaryl.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (paramaryl.hasNext()) {
        ((aryp)paramaryl.next()).a();
      }
    }
  }
  
  private void e(arym paramarym)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(5);
    localMessage.obj = paramarym;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "saveCancel");
    }
    if (this.jdField_a_of_type_Aryo != null) {
      this.jdField_a_of_type_Aryo.b();
    }
    this.c = false;
    this.jdField_a_of_type_Long = 0L;
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "saveTips");
    }
    if (this.jdField_a_of_type_Aryo != null) {
      this.jdField_a_of_type_Aryo.c();
    }
  }
  
  private void h()
  {
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      arym localarym = (arym)localEntry.getValue();
      if ((localarym != null) && (localarym.jdField_a_of_type_Aryl != null) && (localarym.d == 1))
      {
        Iterator localIterator2 = localarym.jdField_a_of_type_Aryl.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        while (localIterator2.hasNext()) {
          ((aryp)localIterator2.next()).a();
        }
        localarym.d = 0;
        a((String)localEntry.getKey(), localarym);
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
    arym localarym;
    baky localbaky;
    while (localIterator.hasNext())
    {
      localarym = (arym)((Map.Entry)localIterator.next()).getValue();
      if ((localarym != null) && (localarym.jdField_a_of_type_Aryl != null)) {
        switch (localarym.jdField_a_of_type_Aryl.jdField_a_of_type_Int)
        {
        default: 
          break;
        case 1: 
          if ((localarym.jdField_a_of_type_Aryl.jdField_a_of_type_Atpv != null) && (localarym.jdField_a_of_type_Aryl.jdField_a_of_type_Atpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null))
          {
            localbaky = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(axvo.a(localarym.jdField_a_of_type_Aryl.jdField_a_of_type_Atpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.md5, localarym.jdField_a_of_type_Aryl.jdField_a_of_type_Atpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uuid, 131075));
            if (localbaky != null) {
              break label406;
            }
            localbaky = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(axvo.a(localarym.jdField_a_of_type_Aryl.jdField_a_of_type_Atpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.md5, localarym.jdField_a_of_type_Aryl.jdField_a_of_type_Atpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uuid, 1));
          }
          break;
        }
      }
    }
    label406:
    for (;;)
    {
      if (!(localbaky instanceof axoo)) {
        break label39;
      }
      ((axoo)localbaky).a();
      break label39;
      if ((localarym.jdField_a_of_type_Aryl.jdField_a_of_type_Awey != null) && (localarym.jdField_a_of_type_Aryl.jdField_a_of_type_Awey.jdField_a_of_type_Awej != null)) {}
      localbaky = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localarym.jdField_a_of_type_Aryl.jdField_a_of_type_Awey.jdField_a_of_type_Awej.c, localarym.jdField_a_of_type_Aryl.jdField_a_of_type_Awey.jdField_a_of_type_Awej.jdField_a_of_type_Long);
      if (!(localbaky instanceof axoo)) {
        break label39;
      }
      ((axoo)localbaky).a();
      break label39;
      if ((localarym.jdField_a_of_type_Aryl.jdField_a_of_type_Awey == null) || (localarym.jdField_a_of_type_Aryl.jdField_a_of_type_Awey.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
        break label39;
      }
      ((awet)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(95)).b(localarym.jdField_a_of_type_Aryl);
      break label39;
      if (localarym.jdField_a_of_type_Aryl.jdField_a_of_type_Apap == null) {
        break label39;
      }
      localarym.jdField_a_of_type_Aryl.jdField_a_of_type_Apap.b();
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
        arym localarym = (arym)((Map.Entry)localIterator.next()).getValue();
        if ((localarym != null) && (localarym.jdField_a_of_type_Aryl != null)) {
          localarym.jdField_a_of_type_Aryl.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
        }
      }
    }
  }
  
  public arym a(String paramString)
  {
    return (arym)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public String a(atpn paramatpn)
  {
    if (paramatpn != null) {
      return paramatpn.c + paramatpn.jdField_a_of_type_Long;
    }
    return "";
  }
  
  public String a(awej paramawej)
  {
    if (paramawej != null) {
      return paramawej.c + paramawej.jdField_a_of_type_Long;
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
  
  public void a(adyh paramadyh)
  {
    this.jdField_a_of_type_Adyh = paramadyh;
  }
  
  public void a(Activity paramActivity, List<aryl> paramList)
  {
    a(paramActivity, babr.a(paramActivity, 230, paramActivity.getString(2131652999), paramActivity.getString(2131652998), new aryr(this, paramList), new aryv(this)));
  }
  
  public void a(aryl paramaryl)
  {
    if (paramaryl != null) {
      switch (paramaryl.jdField_a_of_type_Int)
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
            } while (paramaryl.jdField_a_of_type_Atpv == null);
            localarym = new arym();
            localarym.jdField_a_of_type_Aryl = paramaryl;
            paramaryl = a(paramaryl.jdField_a_of_type_Atpv.jdField_a_of_type_Atpn);
          } while (TextUtils.isEmpty(paramaryl));
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramaryl, localarym);
          return;
        } while (paramaryl.jdField_a_of_type_Awey == null);
        localarym = new arym();
        localarym.jdField_a_of_type_Aryl = paramaryl;
        paramaryl = a(paramaryl.jdField_a_of_type_Awey.jdField_a_of_type_Awej);
      } while (TextUtils.isEmpty(paramaryl));
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramaryl, localarym);
      return;
      if (this.jdField_a_of_type_Aohc == null)
      {
        this.jdField_a_of_type_Aohc = new aohc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_Aohc.a();
      }
    } while (paramaryl.jdField_a_of_type_Apap == null);
    arym localarym = new arym();
    localarym.jdField_a_of_type_Aryl = paramaryl;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramaryl.jdField_a_of_type_Apap.a(), localarym);
  }
  
  public void a(aryl paramaryl, int paramInt1, int paramInt2, String paramString)
  {
    arym localarym;
    if ((paramaryl != null) && (paramaryl.jdField_a_of_type_Awey != null) && (paramaryl.jdField_a_of_type_Awey.jdField_a_of_type_Awej != null))
    {
      String str = a(paramaryl.jdField_a_of_type_Awey.jdField_a_of_type_Awej);
      localarym = a(str);
      if ((localarym != null) && (localarym.jdField_a_of_type_Aryl != null) && (!localarym.jdField_a_of_type_Boolean))
      {
        localarym.jdField_a_of_type_Boolean = true;
        localarym.jdField_a_of_type_Int = paramInt1;
        localarym.c = 100;
        a(str, localarym);
        if (paramInt1 != 0) {
          break label196;
        }
        paramaryl = new File(paramaryl.jdField_a_of_type_Awey.jdField_a_of_type_Awej.h);
        if ((!paramaryl.exists()) && (QLog.isColorLevel())) {
          QLog.d("MultiRichMediaSaveManager", 2, "dealShortVideoDownloadComplete srcFile not exists");
        }
        b(paramaryl.getAbsolutePath(), new StringBuilder().append(paramaryl.getParentFile().getName()).append(NetConnInfoCenter.getServerTime()).toString().toLowerCase(Locale.US) + ".mp4", localarym);
      }
    }
    return;
    label196:
    localarym.b = paramInt2;
    localarym.jdField_a_of_type_JavaLangString = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("MultiRichMediaSaveManager", 2, "dealShortVideoDownloadComplete errorCode= " + paramInt2 + ", errorDec= " + paramString);
    }
    b(localarym);
  }
  
  public void a(arym paramarym)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "saveComplete");
    }
    if (paramarym != null)
    {
      if (paramarym.d == 1)
      {
        if (paramarym.jdField_a_of_type_Aryl != null)
        {
          Iterator localIterator = paramarym.jdField_a_of_type_Aryl.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          while (localIterator.hasNext())
          {
            aryp localaryp = (aryp)localIterator.next();
            if (paramarym.jdField_a_of_type_Int == 0) {
              localaryp.a(paramarym, 100);
            }
            localaryp.a(paramarym);
          }
        }
        b(paramarym.jdField_a_of_type_Aryl);
        c(paramarym);
      }
    }
    else {
      return;
    }
    if (this.jdField_a_of_type_Aryo != null) {
      this.jdField_a_of_type_Aryo.a(paramarym);
    }
    this.c = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    c(paramarym);
  }
  
  public void a(arym paramarym, int paramInt)
  {
    if (paramarym != null) {
      if (paramarym.d == 1)
      {
        if (paramarym.jdField_a_of_type_Aryl != null)
        {
          Iterator localIterator = paramarym.jdField_a_of_type_Aryl.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          while (localIterator.hasNext()) {
            ((aryp)localIterator.next()).a(paramarym, paramInt);
          }
        }
      }
      else if (this.jdField_a_of_type_Aryo != null) {
        this.jdField_a_of_type_Aryo.a(paramarym, paramInt);
      }
    }
  }
  
  public void a(aryo paramaryo)
  {
    this.jdField_a_of_type_Aryo = paramaryo;
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
        atpv localatpv = atpl.a(7, 1);
        localatpv.a(paramMessageForPic, paramMessageForPic.getPicDownloadInfo());
        String str1 = axoa.d(axwd.a(paramMessageForPic, 131075, null).toString().toString());
        long l = paramMessageForPic.size;
        String str2 = a(paramMessageForPic.getPicDownloadInfo());
        if (a(str2) == null)
        {
          arym localarym = new arym();
          localarym.jdField_a_of_type_Aryl = aryl.a(paramMessageForPic);
          localarym.d = 1;
          a(str2, localarym);
        }
        localatpv.a(new aryt(this, paramLong, paramInt1, paramInt2, l, str2, str1));
        atpl.a(localatpv, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    aryl localaryl;
    do
    {
      for (;;)
      {
        return;
        try
        {
          localaryl = aryl.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForShortVideo);
          if ((localaryl != null) && (localaryl.jdField_a_of_type_Awey != null))
          {
            paramMessageForShortVideo = a(paramMessageForShortVideo.getDownloadInfo(paramMessageForShortVideo.busiType));
            if (a(paramMessageForShortVideo) == null)
            {
              arym localarym = new arym();
              localarym.jdField_a_of_type_Aryl = localaryl;
              localarym.d = 1;
              a(paramMessageForShortVideo, localarym);
            }
            if ((!a(localaryl)) || (localaryl.jdField_a_of_type_Awey.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (this.jdField_a_of_type_Adyh == null)) {
              break label244;
            }
            paramMessageForShortVideo = ShortVideoUtils.a(localaryl.jdField_a_of_type_Awey.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
            this.jdField_a_of_type_Adyh.a(paramLong, paramInt1, paramInt2, 1, paramMessageForShortVideo, false);
            return;
          }
        }
        catch (Exception paramMessageForShortVideo) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("MultiRichMediaSaveManager", 2, "dealSaveVideo exception: " + paramMessageForShortVideo.getMessage());
    return;
    label244:
    localaryl.jdField_a_of_type_Awey.jdField_a_of_type_Boolean = true;
    localaryl.jdField_a_of_type_Awey.jdField_a_of_type_Awew = new aryu(this, paramLong, localaryl, paramMessageForShortVideo, paramInt1, paramInt2);
    ((awet)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(95)).a(localaryl);
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
  
  public void a(String paramString, arym paramarym)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramarym);
    }
  }
  
  public void a(List<aryl> paramList, int paramInt1, int paramInt2)
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
          switch (((aryl)paramList.next()).jdField_a_of_type_Int)
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
        awqx.b(null, "dc00898", "", "", str, str, paramInt2, 0, String.valueOf(paramInt1), String.valueOf(i), String.valueOf(j), String.valueOf(k));
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
  
  public void a(List<aryl> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "saveMultiRichMedialFile fileSaveReqList is empty!");
      }
      paramList = new arym();
      paramList.jdField_a_of_type_Int = -1;
      paramList.b = 10006;
      paramList.jdField_a_of_type_JavaLangString = aryk.a(10006);
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
        aryl localaryl = (aryl)paramList.next();
        if (a(localaryl)) {
          d(localaryl);
        } else if (!b(localaryl)) {
          c(localaryl);
        }
      }
    }
  }
  
  public boolean a(aryl paramaryl)
  {
    boolean bool2 = true;
    if (paramaryl == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFileExist fileSaveReq is empty!");
      }
    }
    do
    {
      return false;
      switch (paramaryl.jdField_a_of_type_Int)
      {
      default: 
        return false;
      }
    } while ((paramaryl.jdField_a_of_type_Atpv == null) || (paramaryl.jdField_a_of_type_Atpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null));
    Object localObject = paramaryl.jdField_a_of_type_Atpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.getPicDownloadInfo();
    if (localObject != null)
    {
      localObject = ((atpn)localObject).c();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new File((String)localObject);
        if ((((File)localObject).exists()) && (((File)localObject).length() == paramaryl.jdField_a_of_type_Atpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size))
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
      if (paramaryl.jdField_a_of_type_Awey == null) {
        break;
      }
      localObject = ShortVideoUtils.a(paramaryl.jdField_a_of_type_Awey.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
      if (localObject == null) {
        break;
      }
      localObject = new File((String)localObject);
      if ((!((File)localObject).exists()) || (paramaryl.jdField_a_of_type_Awey.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (((File)localObject).length() != paramaryl.jdField_a_of_type_Awey.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFileExist shortVideo exists");
      }
      return true;
      if (paramaryl.jdField_a_of_type_Apap == null) {
        break;
      }
      return paramaryl.jdField_a_of_type_Apap.a();
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
  
  public boolean a(List<aryl> paramList)
  {
    if ((!AppNetConnInfo.isWifiConn()) && (paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      long l = 0L;
      while (paramList.hasNext())
      {
        aryl localaryl = (aryl)paramList.next();
        if (!a(localaryl))
        {
          switch (localaryl.jdField_a_of_type_Int)
          {
          }
          for (;;)
          {
            break;
            if ((localaryl.jdField_a_of_type_Atpv != null) && (localaryl.jdField_a_of_type_Atpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null))
            {
              l += localaryl.jdField_a_of_type_Atpv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
              continue;
              if ((localaryl.jdField_a_of_type_Awey != null) && (localaryl.jdField_a_of_type_Awey.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
              {
                l += localaryl.jdField_a_of_type_Awey.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
                continue;
                if (localaryl.jdField_a_of_type_Apap != null) {
                  l += localaryl.jdField_a_of_type_Apap.a();
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
    this.jdField_a_of_type_Aryo = null;
  }
  
  public void b(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "cancelSavePic id = " + paramLong);
    }
    paramMessageForPic = a(paramMessageForPic);
    arym localarym = a(paramMessageForPic);
    if (localarym != null)
    {
      localarym.jdField_a_of_type_Boolean = true;
      localarym.jdField_a_of_type_Int = -1;
      a(paramMessageForPic, localarym);
      e(localarym);
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
    arym localarym = a(str);
    if (localarym != null)
    {
      localarym.jdField_a_of_type_Boolean = true;
      localarym.jdField_a_of_type_Int = -1;
      a(str, localarym);
      e(localarym);
    }
    ((awet)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(95)).b(aryl.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForShortVideo));
    a(str);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Adyh = null;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "clearFileSaveRequest");
    }
    j();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_Aryo = null;
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    this.c = false;
    this.jdField_a_of_type_Long = 0L;
    if (this.jdField_a_of_type_Aohc != null)
    {
      this.jdField_a_of_type_Aohc.b();
      this.jdField_a_of_type_Aohc = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    arym localarym;
    if ((paramMessage.obj instanceof arym))
    {
      localarym = (arym)paramMessage.obj;
      if (localarym.jdField_a_of_type_Aryl == null) {}
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
          a(localarym, paramMessage.arg1);
          return true;
        } while (localarym.d != 1);
        e(localarym.jdField_a_of_type_Aryl);
        return true;
        if (localarym.d == 1)
        {
          d(localarym);
          return true;
        }
        if (paramMessage.what == 2)
        {
          this.jdField_a_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            QLog.i("MultiRichMediaSaveManager", 2, "MSG_TYPE_SAVE_FAIL errorCode = " + localarym.b + ", errorMsg = " + localarym.jdField_a_of_type_JavaLangString);
          }
        }
        for (;;)
        {
          paramMessage = localarym.jdField_a_of_type_Aryl.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          while (paramMessage.hasNext()) {
            ((aryp)paramMessage.next()).a(localarym);
          }
          this.b = true;
        }
      } while (!a());
      b(localarym, 100);
      if ((this.b) && (!this.jdField_a_of_type_Boolean)) {
        localarym.jdField_a_of_type_Int = 0;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "last result = " + localarym.jdField_a_of_type_Int);
        }
        this.jdField_a_of_type_Boolean = false;
        this.b = false;
        if (this.jdField_a_of_type_Aohc != null)
        {
          this.jdField_a_of_type_Aohc.b();
          this.jdField_a_of_type_Aohc = null;
        }
        a(localarym, 200L);
        return true;
        if ((this.jdField_a_of_type_Boolean) && (!this.b)) {
          localarym.jdField_a_of_type_Int = -1;
        } else {
          localarym.jdField_a_of_type_Int = 3;
        }
      }
    case 3: 
      paramMessage = localarym.jdField_a_of_type_Aryl.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (paramMessage.hasNext()) {
        ((aryp)paramMessage.next()).b(localarym);
      }
    }
    a(localarym);
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
 * Qualified Name:     aryq
 * JD-Core Version:    0.7.0.1
 */