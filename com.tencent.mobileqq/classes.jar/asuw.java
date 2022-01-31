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

public class asuw
  implements Handler.Callback, Manager
{
  private long jdField_a_of_type_Long;
  protected aeje a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private aoya jdField_a_of_type_Aoya;
  private asuu jdField_a_of_type_Asuu;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ConcurrentHashMap<String, asus> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public asuw(QQAppInterface paramQQAppInterface)
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
        asus localasus = (asus)((Map.Entry)localIterator.next()).getValue();
        if ((localasus != null) && (localasus.jdField_a_of_type_Asur != null)) {
          switch (localasus.jdField_a_of_type_Asur.jdField_a_of_type_Int)
          {
          default: 
            break;
          case 1: 
            if ((localasus.jdField_a_of_type_Asur.jdField_a_of_type_Aunv != null) && (localasus.jdField_a_of_type_Asur.jdField_a_of_type_Aunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)) {
              this.jdField_a_of_type_Long += localasus.jdField_a_of_type_Asur.jdField_a_of_type_Aunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
            }
            break;
          case 2: 
          case 3: 
            if ((localasus.jdField_a_of_type_Asur.jdField_a_of_type_Axei != null) && (localasus.jdField_a_of_type_Asur.jdField_a_of_type_Axei.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
              this.jdField_a_of_type_Long += localasus.jdField_a_of_type_Asur.jdField_a_of_type_Axei.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
            }
            break;
          case 4: 
          case 5: 
          case 6: 
          case 7: 
            if (localasus.jdField_a_of_type_Asur.jdField_a_of_type_Apsn != null) {
              this.jdField_a_of_type_Long += localasus.jdField_a_of_type_Asur.jdField_a_of_type_Apsn.a();
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
  
  private void a(int paramInt, asur paramasur)
  {
    asus localasus = new asus();
    localasus.jdField_a_of_type_Int = -1;
    localasus.jdField_a_of_type_Asur = paramasur;
    localasus.b = paramInt;
    localasus.jdField_a_of_type_JavaLangString = asuq.a(paramInt);
    b(localasus);
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
  
  private void a(apsn paramapsn)
  {
    if (paramapsn != null) {
      paramapsn.a(paramapsn.b(), new asuy(this, paramapsn));
    }
  }
  
  private void a(asur paramasur, int paramInt)
  {
    if ((paramasur != null) && (paramasur.jdField_a_of_type_Aunv != null))
    {
      paramasur = a(paramasur.jdField_a_of_type_Aunv.jdField_a_of_type_Aunn);
      asus localasus = a(paramasur);
      if ((localasus != null) && (!localasus.jdField_a_of_type_Boolean))
      {
        paramInt /= 100;
        localasus.c = paramInt;
        a(paramasur, localasus);
        c(localasus, paramInt);
      }
    }
  }
  
  private void a(asur paramasur, boolean paramBoolean)
  {
    String str;
    asus localasus;
    if ((paramasur != null) && (paramasur.jdField_a_of_type_Apsn != null))
    {
      str = paramasur.jdField_a_of_type_Apsn.a();
      localasus = a(str);
      if ((localasus == null) || (localasus.jdField_a_of_type_Boolean)) {
        break label97;
      }
      localasus.jdField_a_of_type_Boolean = true;
      localasus.c = 100;
      a(str, localasus);
      if (!paramBoolean) {
        break label188;
      }
    }
    switch (paramasur.jdField_a_of_type_Int)
    {
    default: 
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("MultiRichMediaSaveManager", 2, "dealFileMultilDownloadComplete fileType= " + paramasur.jdField_a_of_type_Int);
      return;
    case 4: 
    case 6: 
      label97:
      paramasur = paramasur.jdField_a_of_type_Apsn.b();
      str = Utils.Crc64String(paramasur + NetConnInfoCenter.getServerTime());
      localasus.jdField_a_of_type_Int = 0;
      a(paramasur, str, localasus);
      return;
    }
    a(paramasur.jdField_a_of_type_Apsn);
    return;
    label188:
    if (QLog.isColorLevel()) {
      QLog.d("MultiRichMediaSaveManager", 2, "dealFileMultilDownloadComplete errorType= " + paramasur.jdField_a_of_type_Int);
    }
    localasus.jdField_a_of_type_Int = -1;
    b(localasus);
  }
  
  private void a(asus paramasus, long paramLong)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4);
    localMessage.obj = paramasus;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  private void a(String paramString1, String paramString2, asus paramasus)
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
        if ((paramasus != null) && (paramasus.jdField_a_of_type_Asur != null))
        {
          paramasus.jdField_a_of_type_Int = -1;
          paramasus.b = i;
          paramasus.jdField_a_of_type_JavaLangString = asuq.a(i);
          b(paramasus);
        }
        return;
        if (TextUtils.isEmpty(paramString2))
        {
          i = 10002;
          continue;
        }
        if (!bbdx.a(paramString1)) {
          i = 10003;
        }
      }
      else
      {
        new File(ajsd.bc).mkdirs();
        String str = paramString2;
        if (!paramString2.contains("."))
        {
          str = bbdx.b(paramString1);
          str = paramString2 + "." + str;
        }
        paramString2 = new File(ajsd.bc, str);
        ThreadManager.getFileThreadHandler().post(new FileSaveRunnable(new File(paramString1), paramString2, this.jdField_a_of_type_AndroidOsHandler, paramasus, false));
        return;
      }
      i = 0;
    }
  }
  
  private void a(List<asur> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((asur)paramList.next());
    }
  }
  
  private boolean a()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        asus localasus = (asus)((Map.Entry)localIterator.next()).getValue();
        if ((localasus == null) || (!localasus.jdField_a_of_type_Boolean)) {
          return false;
        }
      }
    }
    return true;
  }
  
  private void b(asur paramasur)
  {
    String str;
    if (paramasur != null)
    {
      str = "";
      switch (paramasur.jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      a(str);
      return;
      if (paramasur.jdField_a_of_type_Aunv != null)
      {
        str = a(paramasur.jdField_a_of_type_Aunv.jdField_a_of_type_Aunn);
        continue;
        if (paramasur.jdField_a_of_type_Axei != null)
        {
          str = a(paramasur.jdField_a_of_type_Axei.jdField_a_of_type_Axdt);
          continue;
          if (paramasur.jdField_a_of_type_Apsn != null) {
            str = paramasur.jdField_a_of_type_Apsn.a();
          }
        }
      }
    }
  }
  
  private void b(asur paramasur, int paramInt1, int paramInt2, String paramString)
  {
    asus localasus;
    if ((paramasur != null) && (paramasur.jdField_a_of_type_Aunv != null) && (paramasur.jdField_a_of_type_Aunv.jdField_a_of_type_Aunn != null))
    {
      String str = a(paramasur.jdField_a_of_type_Aunv.jdField_a_of_type_Aunn);
      localasus = a(str);
      if ((localasus != null) && (localasus.jdField_a_of_type_Asur != null) && (!localasus.jdField_a_of_type_Boolean))
      {
        localasus.jdField_a_of_type_Boolean = true;
        localasus.jdField_a_of_type_Int = paramInt1;
        localasus.c = 100;
        a(str, localasus);
        if (paramInt1 != 0) {
          break label136;
        }
        paramasur = paramasur.jdField_a_of_type_Aunv.jdField_a_of_type_Aunn.c();
        a(paramasur, Utils.Crc64String(paramasur + NetConnInfoCenter.getServerTime()), localasus);
      }
    }
    return;
    label136:
    localasus.b = paramInt2;
    localasus.jdField_a_of_type_JavaLangString = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("MultiRichMediaSaveManager", 2, "dealPicDownloadComplete errorCode= " + paramInt2 + ", errorDec= " + paramString);
    }
    b(localasus);
  }
  
  private void b(asus paramasus)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
    localMessage.obj = paramasus;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void b(asus paramasus, int paramInt)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(6);
    localMessage.obj = paramasus;
    localMessage.arg1 = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void b(String paramString1, String paramString2, asus paramasus)
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
        if ((paramasus != null) && (paramasus.jdField_a_of_type_Asur != null))
        {
          paramasus.jdField_a_of_type_Int = -1;
          paramasus.b = i;
          paramasus.jdField_a_of_type_JavaLangString = asuq.a(i);
          b(paramasus);
        }
        return;
        if (TextUtils.isEmpty(paramString2))
        {
          i = 10002;
          continue;
        }
        if (!bbdx.a(paramString1)) {
          i = 10003;
        }
      }
      else
      {
        if (bfnz.b()) {}
        for (File localFile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);; localFile = new File(ajsd.bq))
        {
          localFile.mkdirs();
          paramString2 = new File(localFile, ShortVideoUtils.b(paramString2));
          ThreadManager.getFileThreadHandler().post(new FileSaveRunnable(new File(paramString1), paramString2, this.jdField_a_of_type_AndroidOsHandler, paramasus, false));
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
        asus localasus = (asus)((Map.Entry)localIterator.next()).getValue();
        if ((localasus != null) && (localasus.d == 1) && (!localasus.jdField_a_of_type_Boolean)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean b(asur paramasur)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramasur == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload fileSaveReq is empty!");
      }
      return false;
    }
    switch (paramasur.jdField_a_of_type_Int)
    {
    default: 
      bool2 = bool1;
      label74:
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      if ((paramasur.jdField_a_of_type_Aunv == null) || (paramasur.jdField_a_of_type_Aunv.jdField_a_of_type_Aunn == null) || (paramasur.jdField_a_of_type_Aunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload picReq is empty!");
        return false;
      }
      if ((paramasur.jdField_a_of_type_Aunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) && (paramasur.jdField_a_of_type_Aunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.fileSizeFlag == 1)) {
        break;
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(ayvx.a(paramasur.jdField_a_of_type_Aunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.md5, paramasur.jdField_a_of_type_Aunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uuid, 1));
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if ((localObject instanceof ayow)) {
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (!bool1) {
        break label74;
      }
      localObject = (ayow)localObject;
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload picReq addDownCallback");
      }
      ((ayow)localObject).b(new asvc(this, paramasur));
      continue;
      if ((paramasur.jdField_a_of_type_Axei == null) || (paramasur.jdField_a_of_type_Axei.jdField_a_of_type_Axdt == null))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload shortVideoReq is empty!");
        return false;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramasur.jdField_a_of_type_Axei.jdField_a_of_type_Axdt.c, paramasur.jdField_a_of_type_Axei.jdField_a_of_type_Axdt.jdField_a_of_type_Long);
      bool2 = bool1;
      if (localObject == null) {
        break label74;
      }
      bool2 = bool1;
      if (!(localObject instanceof ayow)) {
        break label74;
      }
      localObject = (ayow)localObject;
      if ((((ayow)localObject).a != null) && ((((ayow)localObject).a.b == 7) || (((ayow)localObject).a.b == 16) || (((ayow)localObject).a.b == 18)))
      {
        ((ayow)localObject).a();
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload shortVideoReq addDownCallback");
      }
      ((ayow)localObject).b(new asvd(this, paramasur));
      bool1 = false;
      continue;
      bool1 = false;
      continue;
      bool2 = bool1;
      if (paramasur.jdField_a_of_type_Apsn == null) {
        break label74;
      }
      bool2 = paramasur.jdField_a_of_type_Apsn.b();
      bool1 = bool2;
      if (bool2)
      {
        paramasur.jdField_a_of_type_Apsn.a(new asve(this, paramasur));
        bool1 = bool2;
        if (this.jdField_a_of_type_Aoya != null)
        {
          this.jdField_a_of_type_Aoya.a(paramasur.jdField_a_of_type_Apsn.a());
          bool1 = bool2;
        }
      }
    }
  }
  
  private void c(asur paramasur)
  {
    if (paramasur == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "downloadFile fileSaveReq is empty!");
      }
      a(10007, new asur());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadFile fileType = " + paramasur.jdField_a_of_type_Int);
    }
    String str;
    switch (paramasur.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      if (paramasur.jdField_a_of_type_Aunv != null)
      {
        str = a(paramasur.jdField_a_of_type_Aunv.jdField_a_of_type_Aunn);
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "downloadPic key = " + str);
        }
        paramasur.jdField_a_of_type_Aunv.a(new asvf(this, str, paramasur));
        aunl.a(paramasur.jdField_a_of_type_Aunv, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
      a(10007, paramasur);
      return;
    case 2: 
      if (paramasur.jdField_a_of_type_Axei != null)
      {
        str = a(paramasur.jdField_a_of_type_Axei.jdField_a_of_type_Axdt);
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "downloadShortVideo key = " + str);
        }
        paramasur.jdField_a_of_type_Axei.a(new asvg(this, str, paramasur));
        axdq.a(paramasur.jdField_a_of_type_Axei, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
      a(10007, paramasur);
      return;
    case 3: 
      if (paramasur.jdField_a_of_type_Axei != null)
      {
        str = a(paramasur.jdField_a_of_type_Axei.jdField_a_of_type_Axdt);
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "downloadVideo key = " + str);
        }
        paramasur.jdField_a_of_type_Axei.jdField_a_of_type_Boolean = true;
        paramasur.jdField_a_of_type_Axei.jdField_a_of_type_Axeg = new asvh(this, paramasur, str);
        ((axed)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(95)).a(paramasur);
        return;
      }
      a(10007, paramasur);
      return;
    }
    if (paramasur.jdField_a_of_type_Apsn != null)
    {
      str = paramasur.jdField_a_of_type_Apsn.a();
      if (QLog.isColorLevel()) {
        QLog.i("MultiRichMediaSaveManager", 2, "downloadFile key = " + str);
      }
      paramasur.jdField_a_of_type_Apsn.a(new asvi(this, str, paramasur));
      if (this.jdField_a_of_type_Aoya != null) {
        this.jdField_a_of_type_Aoya.a(paramasur.jdField_a_of_type_Apsn.a());
      }
      paramasur.jdField_a_of_type_Apsn.a();
      return;
    }
    a(10007, paramasur);
  }
  
  private void c(asus paramasus)
  {
    HashMap localHashMap;
    if (paramasus != null)
    {
      localHashMap = new HashMap();
      if (paramasus.d != 1) {
        break label70;
      }
      localHashMap.put("isMultiSave", "1");
      if (paramasus.jdField_a_of_type_Int != 0) {
        break label84;
      }
      localHashMap.put("isSuccess", "0");
    }
    for (;;)
    {
      axrn.a(BaseApplication.getContext()).a(null, "MultiRichMediaFileSave", true, 0L, 0L, localHashMap, "");
      return;
      label70:
      localHashMap.put("isMultiSave", "0");
      break;
      label84:
      localHashMap.put("isSuccess", "1");
      localHashMap.put("errorCode", String.valueOf(paramasus.b));
      localHashMap.put("isSuccess", paramasus.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void c(asus paramasus, int paramInt)
  {
    if (paramasus != null)
    {
      paramasus.c = paramInt;
      d(paramasus, paramInt);
    }
  }
  
  private void d(asur paramasur)
  {
    if (paramasur != null) {}
    switch (paramasur.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      b(paramasur, 0, 0, "");
      return;
    case 2: 
    case 3: 
      a(paramasur, 0, 0, "");
      return;
    }
    a(paramasur, true);
  }
  
  private void d(asus paramasus)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "notifySingleComplete");
    }
    if (paramasus != null)
    {
      a(paramasus);
      if ((paramasus.jdField_a_of_type_Asvj != null) && (this.jdField_a_of_type_Aeje != null)) {
        this.jdField_a_of_type_Aeje.a(paramasus.jdField_a_of_type_Asvj.jdField_a_of_type_Long, paramasus.jdField_a_of_type_Asvj.jdField_a_of_type_Int, paramasus.jdField_a_of_type_Asvj.b, paramasus.jdField_a_of_type_Asvj.c, paramasus.jdField_a_of_type_Asvj.jdField_a_of_type_JavaLangString, paramasus.jdField_a_of_type_Asvj.jdField_a_of_type_Boolean);
      }
    }
  }
  
  private void d(asus paramasus, int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    long l = 0L;
    if (localIterator.hasNext())
    {
      asus localasus = (asus)((Map.Entry)localIterator.next()).getValue();
      if ((localasus != null) && (localasus.jdField_a_of_type_Asur != null)) {
        switch (localasus.jdField_a_of_type_Asur.jdField_a_of_type_Int)
        {
        }
      }
      for (;;)
      {
        break;
        if ((localasus.jdField_a_of_type_Asur.jdField_a_of_type_Aunv != null) && (localasus.jdField_a_of_type_Asur.jdField_a_of_type_Aunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)) {
          if (localasus.jdField_a_of_type_Boolean)
          {
            l += localasus.jdField_a_of_type_Asur.jdField_a_of_type_Aunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
          }
          else
          {
            float f1 = (float)l;
            float f2 = (float)localasus.jdField_a_of_type_Asur.jdField_a_of_type_Aunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
            l = (localasus.c / 100.0F * f2 + f1);
            continue;
            if ((localasus.jdField_a_of_type_Asur.jdField_a_of_type_Axei != null) && (localasus.jdField_a_of_type_Asur.jdField_a_of_type_Axei.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
              if (localasus.jdField_a_of_type_Boolean)
              {
                l += localasus.jdField_a_of_type_Asur.jdField_a_of_type_Axei.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
              }
              else
              {
                f1 = (float)l;
                f2 = localasus.jdField_a_of_type_Asur.jdField_a_of_type_Axei.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
                l = (localasus.c / 100.0F * f2 + f1);
                continue;
                if (localasus.jdField_a_of_type_Asur.jdField_a_of_type_Apsn != null) {
                  if (localasus.jdField_a_of_type_Boolean)
                  {
                    l += localasus.jdField_a_of_type_Asur.jdField_a_of_type_Apsn.a();
                  }
                  else
                  {
                    f1 = (float)l;
                    f2 = (float)localasus.jdField_a_of_type_Asur.jdField_a_of_type_Apsn.a();
                    l = (localasus.c / 100.0F * f2 + f1);
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
      paramasus.d = 0;
      b(paramasus, paramInt);
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
    if (this.jdField_a_of_type_Asuu != null) {
      this.jdField_a_of_type_Asuu.a();
    }
  }
  
  private void e(asur paramasur)
  {
    if (paramasur != null)
    {
      paramasur = paramasur.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (paramasur.hasNext()) {
        ((asuv)paramasur.next()).a();
      }
    }
  }
  
  private void e(asus paramasus)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(5);
    localMessage.obj = paramasus;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "saveCancel");
    }
    if (this.jdField_a_of_type_Asuu != null) {
      this.jdField_a_of_type_Asuu.b();
    }
    this.c = false;
    this.jdField_a_of_type_Long = 0L;
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "saveTips");
    }
    if (this.jdField_a_of_type_Asuu != null) {
      this.jdField_a_of_type_Asuu.c();
    }
  }
  
  private void h()
  {
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      asus localasus = (asus)localEntry.getValue();
      if ((localasus != null) && (localasus.jdField_a_of_type_Asur != null) && (localasus.d == 1))
      {
        Iterator localIterator2 = localasus.jdField_a_of_type_Asur.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        while (localIterator2.hasNext()) {
          ((asuv)localIterator2.next()).a();
        }
        localasus.d = 0;
        a((String)localEntry.getKey(), localasus);
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
    asus localasus;
    bbmw localbbmw;
    while (localIterator.hasNext())
    {
      localasus = (asus)((Map.Entry)localIterator.next()).getValue();
      if ((localasus != null) && (localasus.jdField_a_of_type_Asur != null)) {
        switch (localasus.jdField_a_of_type_Asur.jdField_a_of_type_Int)
        {
        default: 
          break;
        case 1: 
          if ((localasus.jdField_a_of_type_Asur.jdField_a_of_type_Aunv != null) && (localasus.jdField_a_of_type_Asur.jdField_a_of_type_Aunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null))
          {
            localbbmw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(ayvx.a(localasus.jdField_a_of_type_Asur.jdField_a_of_type_Aunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.md5, localasus.jdField_a_of_type_Asur.jdField_a_of_type_Aunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uuid, 131075));
            if (localbbmw != null) {
              break label406;
            }
            localbbmw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(ayvx.a(localasus.jdField_a_of_type_Asur.jdField_a_of_type_Aunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.md5, localasus.jdField_a_of_type_Asur.jdField_a_of_type_Aunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uuid, 1));
          }
          break;
        }
      }
    }
    label406:
    for (;;)
    {
      if (!(localbbmw instanceof ayow)) {
        break label39;
      }
      ((ayow)localbbmw).a();
      break label39;
      if ((localasus.jdField_a_of_type_Asur.jdField_a_of_type_Axei != null) && (localasus.jdField_a_of_type_Asur.jdField_a_of_type_Axei.jdField_a_of_type_Axdt != null)) {}
      localbbmw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localasus.jdField_a_of_type_Asur.jdField_a_of_type_Axei.jdField_a_of_type_Axdt.c, localasus.jdField_a_of_type_Asur.jdField_a_of_type_Axei.jdField_a_of_type_Axdt.jdField_a_of_type_Long);
      if (!(localbbmw instanceof ayow)) {
        break label39;
      }
      ((ayow)localbbmw).a();
      break label39;
      if ((localasus.jdField_a_of_type_Asur.jdField_a_of_type_Axei == null) || (localasus.jdField_a_of_type_Asur.jdField_a_of_type_Axei.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
        break label39;
      }
      ((axed)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(95)).b(localasus.jdField_a_of_type_Asur);
      break label39;
      if (localasus.jdField_a_of_type_Asur.jdField_a_of_type_Apsn == null) {
        break label39;
      }
      localasus.jdField_a_of_type_Asur.jdField_a_of_type_Apsn.b();
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
        asus localasus = (asus)((Map.Entry)localIterator.next()).getValue();
        if ((localasus != null) && (localasus.jdField_a_of_type_Asur != null)) {
          localasus.jdField_a_of_type_Asur.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
        }
      }
    }
  }
  
  public asus a(String paramString)
  {
    return (asus)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public String a(aunn paramaunn)
  {
    if (paramaunn != null) {
      return paramaunn.c + paramaunn.jdField_a_of_type_Long;
    }
    return "";
  }
  
  public String a(axdt paramaxdt)
  {
    if (paramaxdt != null) {
      return paramaxdt.c + paramaxdt.jdField_a_of_type_Long;
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
  
  public void a(aeje paramaeje)
  {
    this.jdField_a_of_type_Aeje = paramaeje;
  }
  
  public void a(Activity paramActivity, List<asur> paramList)
  {
    a(paramActivity, bbdj.a(paramActivity, 230, paramActivity.getString(2131718837), paramActivity.getString(2131718836), new asux(this, paramList), new asvb(this)));
  }
  
  public void a(asur paramasur)
  {
    if (paramasur != null) {
      switch (paramasur.jdField_a_of_type_Int)
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
            } while (paramasur.jdField_a_of_type_Aunv == null);
            localasus = new asus();
            localasus.jdField_a_of_type_Asur = paramasur;
            paramasur = a(paramasur.jdField_a_of_type_Aunv.jdField_a_of_type_Aunn);
          } while (TextUtils.isEmpty(paramasur));
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramasur, localasus);
          return;
        } while (paramasur.jdField_a_of_type_Axei == null);
        localasus = new asus();
        localasus.jdField_a_of_type_Asur = paramasur;
        paramasur = a(paramasur.jdField_a_of_type_Axei.jdField_a_of_type_Axdt);
      } while (TextUtils.isEmpty(paramasur));
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramasur, localasus);
      return;
      if (this.jdField_a_of_type_Aoya == null)
      {
        this.jdField_a_of_type_Aoya = new aoya(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_Aoya.a();
      }
    } while (paramasur.jdField_a_of_type_Apsn == null);
    asus localasus = new asus();
    localasus.jdField_a_of_type_Asur = paramasur;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramasur.jdField_a_of_type_Apsn.a(), localasus);
  }
  
  public void a(asur paramasur, int paramInt1, int paramInt2, String paramString)
  {
    asus localasus;
    if ((paramasur != null) && (paramasur.jdField_a_of_type_Axei != null) && (paramasur.jdField_a_of_type_Axei.jdField_a_of_type_Axdt != null))
    {
      String str = a(paramasur.jdField_a_of_type_Axei.jdField_a_of_type_Axdt);
      localasus = a(str);
      if ((localasus != null) && (localasus.jdField_a_of_type_Asur != null) && (!localasus.jdField_a_of_type_Boolean))
      {
        localasus.jdField_a_of_type_Boolean = true;
        localasus.jdField_a_of_type_Int = paramInt1;
        localasus.c = 100;
        a(str, localasus);
        if (paramInt1 != 0) {
          break label196;
        }
        paramasur = new File(paramasur.jdField_a_of_type_Axei.jdField_a_of_type_Axdt.h);
        if ((!paramasur.exists()) && (QLog.isColorLevel())) {
          QLog.d("MultiRichMediaSaveManager", 2, "dealShortVideoDownloadComplete srcFile not exists");
        }
        b(paramasur.getAbsolutePath(), new StringBuilder().append(paramasur.getParentFile().getName()).append(NetConnInfoCenter.getServerTime()).toString().toLowerCase(Locale.US) + ".mp4", localasus);
      }
    }
    return;
    label196:
    localasus.b = paramInt2;
    localasus.jdField_a_of_type_JavaLangString = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("MultiRichMediaSaveManager", 2, "dealShortVideoDownloadComplete errorCode= " + paramInt2 + ", errorDec= " + paramString);
    }
    b(localasus);
  }
  
  public void a(asus paramasus)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "saveComplete");
    }
    if (paramasus != null)
    {
      if (paramasus.d == 1)
      {
        if (paramasus.jdField_a_of_type_Asur != null)
        {
          Iterator localIterator = paramasus.jdField_a_of_type_Asur.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          while (localIterator.hasNext())
          {
            asuv localasuv = (asuv)localIterator.next();
            if (paramasus.jdField_a_of_type_Int == 0) {
              localasuv.a(paramasus, 100);
            }
            localasuv.a(paramasus);
          }
        }
        b(paramasus.jdField_a_of_type_Asur);
        c(paramasus);
      }
    }
    else {
      return;
    }
    if (this.jdField_a_of_type_Asuu != null) {
      this.jdField_a_of_type_Asuu.a(paramasus);
    }
    this.c = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    c(paramasus);
  }
  
  public void a(asus paramasus, int paramInt)
  {
    if (paramasus != null) {
      if (paramasus.d == 1)
      {
        if (paramasus.jdField_a_of_type_Asur != null)
        {
          Iterator localIterator = paramasus.jdField_a_of_type_Asur.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          while (localIterator.hasNext()) {
            ((asuv)localIterator.next()).a(paramasus, paramInt);
          }
        }
      }
      else if (this.jdField_a_of_type_Asuu != null) {
        this.jdField_a_of_type_Asuu.a(paramasus, paramInt);
      }
    }
  }
  
  public void a(asuu paramasuu)
  {
    this.jdField_a_of_type_Asuu = paramasuu;
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
        aunv localaunv = aunl.a(7, 1);
        localaunv.a(paramMessageForPic, paramMessageForPic.getPicDownloadInfo());
        String str1 = ayoi.d(aywm.a(paramMessageForPic, 131075, null).toString().toString());
        long l = paramMessageForPic.size;
        String str2 = a(paramMessageForPic.getPicDownloadInfo());
        if (a(str2) == null)
        {
          asus localasus = new asus();
          localasus.jdField_a_of_type_Asur = asur.a(paramMessageForPic);
          localasus.d = 1;
          a(str2, localasus);
        }
        localaunv.a(new asuz(this, paramLong, paramInt1, paramInt2, l, str2, str1));
        aunl.a(localaunv, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    asur localasur;
    do
    {
      for (;;)
      {
        return;
        try
        {
          localasur = asur.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForShortVideo);
          if ((localasur != null) && (localasur.jdField_a_of_type_Axei != null))
          {
            paramMessageForShortVideo = a(paramMessageForShortVideo.getDownloadInfo(paramMessageForShortVideo.busiType));
            if (a(paramMessageForShortVideo) == null)
            {
              asus localasus = new asus();
              localasus.jdField_a_of_type_Asur = localasur;
              localasus.d = 1;
              a(paramMessageForShortVideo, localasus);
            }
            if ((!a(localasur)) || (localasur.jdField_a_of_type_Axei.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (this.jdField_a_of_type_Aeje == null)) {
              break label244;
            }
            paramMessageForShortVideo = ShortVideoUtils.a(localasur.jdField_a_of_type_Axei.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
            this.jdField_a_of_type_Aeje.a(paramLong, paramInt1, paramInt2, 1, paramMessageForShortVideo, false);
            return;
          }
        }
        catch (Exception paramMessageForShortVideo) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("MultiRichMediaSaveManager", 2, "dealSaveVideo exception: " + paramMessageForShortVideo.getMessage());
    return;
    label244:
    localasur.jdField_a_of_type_Axei.jdField_a_of_type_Boolean = true;
    localasur.jdField_a_of_type_Axei.jdField_a_of_type_Axeg = new asva(this, paramLong, localasur, paramMessageForShortVideo, paramInt1, paramInt2);
    ((axed)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(95)).a(localasur);
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
  
  public void a(String paramString, asus paramasus)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramasus);
    }
  }
  
  public void a(List<asur> paramList, int paramInt1, int paramInt2)
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
          switch (((asur)paramList.next()).jdField_a_of_type_Int)
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
        axqy.b(null, "dc00898", "", "", str, str, paramInt2, 0, String.valueOf(paramInt1), String.valueOf(i), String.valueOf(j), String.valueOf(k));
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
  
  public void a(List<asur> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "saveMultiRichMedialFile fileSaveReqList is empty!");
      }
      paramList = new asus();
      paramList.jdField_a_of_type_Int = -1;
      paramList.b = 10006;
      paramList.jdField_a_of_type_JavaLangString = asuq.a(10006);
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
        asur localasur = (asur)paramList.next();
        if (a(localasur)) {
          d(localasur);
        } else if (!b(localasur)) {
          c(localasur);
        }
      }
    }
  }
  
  public boolean a(asur paramasur)
  {
    boolean bool2 = true;
    if (paramasur == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFileExist fileSaveReq is empty!");
      }
    }
    do
    {
      return false;
      switch (paramasur.jdField_a_of_type_Int)
      {
      default: 
        return false;
      }
    } while ((paramasur.jdField_a_of_type_Aunv == null) || (paramasur.jdField_a_of_type_Aunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null));
    Object localObject = paramasur.jdField_a_of_type_Aunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.getPicDownloadInfo();
    if (localObject != null)
    {
      localObject = ((aunn)localObject).c();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new File((String)localObject);
        if ((((File)localObject).exists()) && (((File)localObject).length() == paramasur.jdField_a_of_type_Aunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size))
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
      if (paramasur.jdField_a_of_type_Axei == null) {
        break;
      }
      localObject = ShortVideoUtils.a(paramasur.jdField_a_of_type_Axei.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
      if (localObject == null) {
        break;
      }
      localObject = new File((String)localObject);
      if ((!((File)localObject).exists()) || (paramasur.jdField_a_of_type_Axei.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (((File)localObject).length() != paramasur.jdField_a_of_type_Axei.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFileExist shortVideo exists");
      }
      return true;
      if (paramasur.jdField_a_of_type_Apsn == null) {
        break;
      }
      return paramasur.jdField_a_of_type_Apsn.a();
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
  
  public boolean a(List<asur> paramList)
  {
    if ((!AppNetConnInfo.isWifiConn()) && (paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      long l = 0L;
      while (paramList.hasNext())
      {
        asur localasur = (asur)paramList.next();
        if (!a(localasur))
        {
          switch (localasur.jdField_a_of_type_Int)
          {
          }
          for (;;)
          {
            break;
            if ((localasur.jdField_a_of_type_Aunv != null) && (localasur.jdField_a_of_type_Aunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null))
            {
              l += localasur.jdField_a_of_type_Aunv.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
              continue;
              if ((localasur.jdField_a_of_type_Axei != null) && (localasur.jdField_a_of_type_Axei.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
              {
                l += localasur.jdField_a_of_type_Axei.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
                continue;
                if (localasur.jdField_a_of_type_Apsn != null) {
                  l += localasur.jdField_a_of_type_Apsn.a();
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
    this.jdField_a_of_type_Asuu = null;
  }
  
  public void b(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "cancelSavePic id = " + paramLong);
    }
    paramMessageForPic = a(paramMessageForPic);
    asus localasus = a(paramMessageForPic);
    if (localasus != null)
    {
      localasus.jdField_a_of_type_Boolean = true;
      localasus.jdField_a_of_type_Int = -1;
      a(paramMessageForPic, localasus);
      e(localasus);
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
    asus localasus = a(str);
    if (localasus != null)
    {
      localasus.jdField_a_of_type_Boolean = true;
      localasus.jdField_a_of_type_Int = -1;
      a(str, localasus);
      e(localasus);
    }
    ((axed)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(95)).b(asur.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForShortVideo));
    a(str);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Aeje = null;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "clearFileSaveRequest");
    }
    j();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_Asuu = null;
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    this.c = false;
    this.jdField_a_of_type_Long = 0L;
    if (this.jdField_a_of_type_Aoya != null)
    {
      this.jdField_a_of_type_Aoya.b();
      this.jdField_a_of_type_Aoya = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    asus localasus;
    if ((paramMessage.obj instanceof asus))
    {
      localasus = (asus)paramMessage.obj;
      if (localasus.jdField_a_of_type_Asur == null) {}
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
          a(localasus, paramMessage.arg1);
          return true;
        } while (localasus.d != 1);
        e(localasus.jdField_a_of_type_Asur);
        return true;
        if (localasus.d == 1)
        {
          d(localasus);
          return true;
        }
        if (paramMessage.what == 2)
        {
          this.jdField_a_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            QLog.i("MultiRichMediaSaveManager", 2, "MSG_TYPE_SAVE_FAIL errorCode = " + localasus.b + ", errorMsg = " + localasus.jdField_a_of_type_JavaLangString);
          }
        }
        for (;;)
        {
          paramMessage = localasus.jdField_a_of_type_Asur.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          while (paramMessage.hasNext()) {
            ((asuv)paramMessage.next()).a(localasus);
          }
          this.b = true;
        }
      } while (!a());
      b(localasus, 100);
      if ((this.b) && (!this.jdField_a_of_type_Boolean)) {
        localasus.jdField_a_of_type_Int = 0;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "last result = " + localasus.jdField_a_of_type_Int);
        }
        this.jdField_a_of_type_Boolean = false;
        this.b = false;
        if (this.jdField_a_of_type_Aoya != null)
        {
          this.jdField_a_of_type_Aoya.b();
          this.jdField_a_of_type_Aoya = null;
        }
        a(localasus, 200L);
        return true;
        if ((this.jdField_a_of_type_Boolean) && (!this.b)) {
          localasus.jdField_a_of_type_Int = -1;
        } else {
          localasus.jdField_a_of_type_Int = 3;
        }
      }
    case 3: 
      paramMessage = localasus.jdField_a_of_type_Asur.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (paramMessage.hasNext()) {
        ((asuv)paramMessage.next()).b(localasus);
      }
    }
    a(localasus);
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
 * Qualified Name:     asuw
 * JD-Core Version:    0.7.0.1
 */