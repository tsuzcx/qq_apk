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

public class axqb
  implements Handler.Callback, Manager
{
  private long jdField_a_of_type_Long;
  protected aiec a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private attl jdField_a_of_type_Attl;
  private axpz jdField_a_of_type_Axpz;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ConcurrentHashMap<String, axpx> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public axqb(QQAppInterface paramQQAppInterface)
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
        axpx localaxpx = (axpx)((Map.Entry)localIterator.next()).getValue();
        if ((localaxpx != null) && (localaxpx.jdField_a_of_type_Axpw != null)) {
          switch (localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_Int)
          {
          default: 
            break;
          case 1: 
            if ((localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_Azqk != null) && (localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_Azqk.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)) {
              this.jdField_a_of_type_Long += localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_Azqk.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
            }
            break;
          case 2: 
          case 3: 
            if ((localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_Bcxn != null) && (localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_Bcxn.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
              this.jdField_a_of_type_Long += localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_Bcxn.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
            }
            break;
          case 4: 
          case 5: 
          case 6: 
          case 7: 
            if (localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_Aulq != null) {
              this.jdField_a_of_type_Long += localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_Aulq.a();
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
  
  private void a(int paramInt, axpw paramaxpw)
  {
    axpx localaxpx = new axpx();
    localaxpx.jdField_a_of_type_Int = -1;
    localaxpx.jdField_a_of_type_Axpw = paramaxpw;
    localaxpx.b = paramInt;
    localaxpx.jdField_a_of_type_JavaLangString = axpv.a(paramInt);
    b(localaxpx);
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
  
  private void a(aulq paramaulq)
  {
    if (paramaulq != null) {
      paramaulq.a(paramaulq.b(), new axqd(this, paramaulq));
    }
  }
  
  private void a(axpw paramaxpw, int paramInt)
  {
    if ((paramaxpw != null) && (paramaxpw.jdField_a_of_type_Azqk != null))
    {
      paramaxpw = a(paramaxpw.jdField_a_of_type_Azqk.jdField_a_of_type_Azqd);
      axpx localaxpx = a(paramaxpw);
      if ((localaxpx != null) && (!localaxpx.jdField_a_of_type_Boolean))
      {
        paramInt /= 100;
        localaxpx.c = paramInt;
        a(paramaxpw, localaxpx);
        c(localaxpx, paramInt);
      }
    }
  }
  
  private void a(axpw paramaxpw, boolean paramBoolean)
  {
    String str;
    axpx localaxpx;
    if ((paramaxpw != null) && (paramaxpw.jdField_a_of_type_Aulq != null))
    {
      str = paramaxpw.jdField_a_of_type_Aulq.a();
      localaxpx = a(str);
      if ((localaxpx == null) || (localaxpx.jdField_a_of_type_Boolean)) {
        break label97;
      }
      localaxpx.jdField_a_of_type_Boolean = true;
      localaxpx.c = 100;
      a(str, localaxpx);
      if (!paramBoolean) {
        break label188;
      }
    }
    switch (paramaxpw.jdField_a_of_type_Int)
    {
    default: 
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("MultiRichMediaSaveManager", 2, "dealFileMultilDownloadComplete fileType= " + paramaxpw.jdField_a_of_type_Int);
      return;
    case 4: 
    case 6: 
      label97:
      paramaxpw = paramaxpw.jdField_a_of_type_Aulq.b();
      str = Utils.Crc64String(paramaxpw + NetConnInfoCenter.getServerTime());
      localaxpx.jdField_a_of_type_Int = 0;
      a(paramaxpw, str, localaxpx);
      return;
    }
    a(paramaxpw.jdField_a_of_type_Aulq);
    return;
    label188:
    if (QLog.isColorLevel()) {
      QLog.d("MultiRichMediaSaveManager", 2, "dealFileMultilDownloadComplete errorType= " + paramaxpw.jdField_a_of_type_Int);
    }
    localaxpx.jdField_a_of_type_Int = -1;
    b(localaxpx);
  }
  
  private void a(axpx paramaxpx, long paramLong)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4);
    localMessage.obj = paramaxpx;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  private void a(String paramString1, String paramString2, axpx paramaxpx)
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
        if ((paramaxpx != null) && (paramaxpx.jdField_a_of_type_Axpw != null))
        {
          paramaxpx.jdField_a_of_type_Int = -1;
          paramaxpx.b = i;
          paramaxpx.jdField_a_of_type_JavaLangString = axpv.a(i);
          b(paramaxpx);
        }
        return;
        if (TextUtils.isEmpty(paramString2))
        {
          i = 10002;
          continue;
        }
        if (!bhmi.a(paramString1)) {
          i = 10003;
        }
      }
      else
      {
        new File(antf.bg).mkdirs();
        String str = paramString2;
        if (!paramString2.contains("."))
        {
          str = bhmi.b(paramString1);
          str = paramString2 + "." + str;
        }
        paramString2 = new File(antf.bg, str);
        ThreadManager.getFileThreadHandler().post(new FileSaveRunnable(new File(paramString1), paramString2, this.jdField_a_of_type_AndroidOsHandler, paramaxpx, false));
        return;
      }
      i = 0;
    }
  }
  
  private void a(List<axpw> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((axpw)paramList.next());
    }
  }
  
  private boolean a()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        axpx localaxpx = (axpx)((Map.Entry)localIterator.next()).getValue();
        if ((localaxpx == null) || (!localaxpx.jdField_a_of_type_Boolean)) {
          return false;
        }
      }
    }
    return true;
  }
  
  private void b(axpw paramaxpw)
  {
    String str;
    if (paramaxpw != null)
    {
      str = "";
      switch (paramaxpw.jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      a(str);
      return;
      if (paramaxpw.jdField_a_of_type_Azqk != null)
      {
        str = a(paramaxpw.jdField_a_of_type_Azqk.jdField_a_of_type_Azqd);
        continue;
        if (paramaxpw.jdField_a_of_type_Bcxn != null)
        {
          str = a(paramaxpw.jdField_a_of_type_Bcxn.jdField_a_of_type_Bcwx);
          continue;
          if (paramaxpw.jdField_a_of_type_Aulq != null) {
            str = paramaxpw.jdField_a_of_type_Aulq.a();
          }
        }
      }
    }
  }
  
  private void b(axpw paramaxpw, int paramInt1, int paramInt2, String paramString)
  {
    axpx localaxpx;
    if ((paramaxpw != null) && (paramaxpw.jdField_a_of_type_Azqk != null) && (paramaxpw.jdField_a_of_type_Azqk.jdField_a_of_type_Azqd != null))
    {
      String str = a(paramaxpw.jdField_a_of_type_Azqk.jdField_a_of_type_Azqd);
      localaxpx = a(str);
      if ((localaxpx != null) && (localaxpx.jdField_a_of_type_Axpw != null) && (!localaxpx.jdField_a_of_type_Boolean))
      {
        localaxpx.jdField_a_of_type_Boolean = true;
        localaxpx.jdField_a_of_type_Int = paramInt1;
        localaxpx.c = 100;
        a(str, localaxpx);
        if (paramInt1 != 0) {
          break label136;
        }
        paramaxpw = paramaxpw.jdField_a_of_type_Azqk.jdField_a_of_type_Azqd.c();
        a(paramaxpw, Utils.Crc64String(paramaxpw + NetConnInfoCenter.getServerTime()), localaxpx);
      }
    }
    return;
    label136:
    localaxpx.b = paramInt2;
    localaxpx.jdField_a_of_type_JavaLangString = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("MultiRichMediaSaveManager", 2, "dealPicDownloadComplete errorCode= " + paramInt2 + ", errorDec= " + paramString);
    }
    b(localaxpx);
  }
  
  private void b(axpx paramaxpx)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
    localMessage.obj = paramaxpx;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void b(axpx paramaxpx, int paramInt)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(6);
    localMessage.obj = paramaxpx;
    localMessage.arg1 = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void b(String paramString1, String paramString2, axpx paramaxpx)
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
        if ((paramaxpx != null) && (paramaxpx.jdField_a_of_type_Axpw != null))
        {
          paramaxpx.jdField_a_of_type_Int = -1;
          paramaxpx.b = i;
          paramaxpx.jdField_a_of_type_JavaLangString = axpv.a(i);
          b(paramaxpx);
        }
        return;
        if (TextUtils.isEmpty(paramString2))
        {
          i = 10002;
          continue;
        }
        if (!bhmi.a(paramString1)) {
          i = 10003;
        }
      }
      else
      {
        if (VersionUtils.isrFroyo()) {}
        for (File localFile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);; localFile = new File(antf.bu))
        {
          localFile.mkdirs();
          paramString2 = new File(localFile, ShortVideoUtils.b(paramString2));
          ThreadManager.getFileThreadHandler().post(new FileSaveRunnable(new File(paramString1), paramString2, this.jdField_a_of_type_AndroidOsHandler, paramaxpx, false));
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
        axpx localaxpx = (axpx)((Map.Entry)localIterator.next()).getValue();
        if ((localaxpx != null) && (localaxpx.d == 1) && (!localaxpx.jdField_a_of_type_Boolean)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean b(axpw paramaxpw)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramaxpw == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload fileSaveReq is empty!");
      }
      return false;
    }
    switch (paramaxpw.jdField_a_of_type_Int)
    {
    default: 
      bool2 = bool1;
      label74:
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      if ((paramaxpw.jdField_a_of_type_Azqk == null) || (paramaxpw.jdField_a_of_type_Azqk.jdField_a_of_type_Azqd == null) || (paramaxpw.jdField_a_of_type_Azqk.jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload picReq is empty!");
        return false;
      }
      if ((paramaxpw.jdField_a_of_type_Azqk.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) && (paramaxpw.jdField_a_of_type_Azqk.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.fileSizeFlag == 1)) {
        break;
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(beyb.a(paramaxpw.jdField_a_of_type_Azqk.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.md5, paramaxpw.jdField_a_of_type_Azqk.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uuid, 1));
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if ((localObject instanceof berj)) {
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (!bool1) {
        break label74;
      }
      localObject = (berj)localObject;
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload picReq addDownCallback");
      }
      ((berj)localObject).b(new axqh(this, paramaxpw));
      continue;
      if ((paramaxpw.jdField_a_of_type_Bcxn == null) || (paramaxpw.jdField_a_of_type_Bcxn.jdField_a_of_type_Bcwx == null))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload shortVideoReq is empty!");
        return false;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramaxpw.jdField_a_of_type_Bcxn.jdField_a_of_type_Bcwx.c, paramaxpw.jdField_a_of_type_Bcxn.jdField_a_of_type_Bcwx.jdField_a_of_type_Long);
      bool2 = bool1;
      if (localObject == null) {
        break label74;
      }
      bool2 = bool1;
      if (!(localObject instanceof berj)) {
        break label74;
      }
      localObject = (berj)localObject;
      if ((((berj)localObject).a != null) && ((((berj)localObject).a.b == 7) || (((berj)localObject).a.b == 16) || (((berj)localObject).a.b == 18)))
      {
        ((berj)localObject).a();
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload shortVideoReq addDownCallback");
      }
      ((berj)localObject).b(new axqi(this, paramaxpw));
      bool1 = false;
      continue;
      bool1 = false;
      continue;
      bool2 = bool1;
      if (paramaxpw.jdField_a_of_type_Aulq == null) {
        break label74;
      }
      bool2 = paramaxpw.jdField_a_of_type_Aulq.b();
      bool1 = bool2;
      if (bool2)
      {
        paramaxpw.jdField_a_of_type_Aulq.a(new axqj(this, paramaxpw));
        bool1 = bool2;
        if (this.jdField_a_of_type_Attl != null)
        {
          this.jdField_a_of_type_Attl.a(paramaxpw.jdField_a_of_type_Aulq.a());
          bool1 = bool2;
        }
      }
    }
  }
  
  private void c(axpw paramaxpw)
  {
    if (paramaxpw == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "downloadFile fileSaveReq is empty!");
      }
      a(10007, new axpw());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadFile fileType = " + paramaxpw.jdField_a_of_type_Int);
    }
    String str;
    switch (paramaxpw.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      if (paramaxpw.jdField_a_of_type_Azqk != null)
      {
        str = a(paramaxpw.jdField_a_of_type_Azqk.jdField_a_of_type_Azqd);
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "downloadPic key = " + str);
        }
        paramaxpw.jdField_a_of_type_Azqk.a(new axqk(this, str, paramaxpw));
        azqb.a(paramaxpw.jdField_a_of_type_Azqk, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
      a(10007, paramaxpw);
      return;
    case 2: 
      if (paramaxpw.jdField_a_of_type_Bcxn != null)
      {
        str = a(paramaxpw.jdField_a_of_type_Bcxn.jdField_a_of_type_Bcwx);
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "downloadShortVideo key = " + str);
        }
        paramaxpw.jdField_a_of_type_Bcxn.a(new axql(this, str, paramaxpw));
        bcwu.a(paramaxpw.jdField_a_of_type_Bcxn, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
      a(10007, paramaxpw);
      return;
    case 3: 
      if (paramaxpw.jdField_a_of_type_Bcxn != null)
      {
        str = a(paramaxpw.jdField_a_of_type_Bcxn.jdField_a_of_type_Bcwx);
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "downloadVideo key = " + str);
        }
        paramaxpw.jdField_a_of_type_Bcxn.jdField_a_of_type_Boolean = true;
        paramaxpw.jdField_a_of_type_Bcxn.jdField_a_of_type_Bcxm = new axqm(this, paramaxpw, str);
        ((bcxh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(95)).a(paramaxpw);
        return;
      }
      a(10007, paramaxpw);
      return;
    }
    if (paramaxpw.jdField_a_of_type_Aulq != null)
    {
      str = paramaxpw.jdField_a_of_type_Aulq.a();
      if (QLog.isColorLevel()) {
        QLog.i("MultiRichMediaSaveManager", 2, "downloadFile key = " + str);
      }
      paramaxpw.jdField_a_of_type_Aulq.a(new axqn(this, str, paramaxpw));
      if (this.jdField_a_of_type_Attl != null) {
        this.jdField_a_of_type_Attl.a(paramaxpw.jdField_a_of_type_Aulq.a());
      }
      paramaxpw.jdField_a_of_type_Aulq.a();
      return;
    }
    a(10007, paramaxpw);
  }
  
  private void c(axpx paramaxpx)
  {
    HashMap localHashMap;
    if (paramaxpx != null)
    {
      localHashMap = new HashMap();
      if (paramaxpx.d != 1) {
        break label70;
      }
      localHashMap.put("isMultiSave", "1");
      if (paramaxpx.jdField_a_of_type_Int != 0) {
        break label84;
      }
      localHashMap.put("isSuccess", "0");
    }
    for (;;)
    {
      bdmc.a(BaseApplication.getContext()).a(null, "MultiRichMediaFileSave", true, 0L, 0L, localHashMap, "");
      return;
      label70:
      localHashMap.put("isMultiSave", "0");
      break;
      label84:
      localHashMap.put("isSuccess", "1");
      localHashMap.put("errorCode", String.valueOf(paramaxpx.b));
      localHashMap.put("isSuccess", paramaxpx.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void c(axpx paramaxpx, int paramInt)
  {
    if (paramaxpx != null)
    {
      paramaxpx.c = paramInt;
      d(paramaxpx, paramInt);
    }
  }
  
  private void d(axpw paramaxpw)
  {
    if (paramaxpw != null) {}
    switch (paramaxpw.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      b(paramaxpw, 0, 0, "");
      return;
    case 2: 
    case 3: 
      a(paramaxpw, 0, 0, "");
      return;
    }
    a(paramaxpw, true);
  }
  
  private void d(axpx paramaxpx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "notifySingleComplete");
    }
    if (paramaxpx != null)
    {
      a(paramaxpx);
      if ((paramaxpx.jdField_a_of_type_Axqo != null) && (this.jdField_a_of_type_Aiec != null)) {
        this.jdField_a_of_type_Aiec.a(paramaxpx.jdField_a_of_type_Axqo.jdField_a_of_type_Long, paramaxpx.jdField_a_of_type_Axqo.jdField_a_of_type_Int, paramaxpx.jdField_a_of_type_Axqo.b, paramaxpx.jdField_a_of_type_Axqo.c, paramaxpx.jdField_a_of_type_Axqo.jdField_a_of_type_JavaLangString, paramaxpx.jdField_a_of_type_Axqo.jdField_a_of_type_Boolean);
      }
    }
  }
  
  private void d(axpx paramaxpx, int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    long l = 0L;
    if (localIterator.hasNext())
    {
      axpx localaxpx = (axpx)((Map.Entry)localIterator.next()).getValue();
      if ((localaxpx != null) && (localaxpx.jdField_a_of_type_Axpw != null)) {
        switch (localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_Int)
        {
        }
      }
      for (;;)
      {
        break;
        if ((localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_Azqk != null) && (localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_Azqk.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)) {
          if (localaxpx.jdField_a_of_type_Boolean)
          {
            l += localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_Azqk.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
          }
          else
          {
            float f1 = (float)l;
            float f2 = (float)localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_Azqk.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
            l = (localaxpx.c / 100.0F * f2 + f1);
            continue;
            if ((localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_Bcxn != null) && (localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_Bcxn.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
              if (localaxpx.jdField_a_of_type_Boolean)
              {
                l += localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_Bcxn.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
              }
              else
              {
                f1 = (float)l;
                f2 = localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_Bcxn.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
                l = (localaxpx.c / 100.0F * f2 + f1);
                continue;
                if (localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_Aulq != null) {
                  if (localaxpx.jdField_a_of_type_Boolean)
                  {
                    l += localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_Aulq.a();
                  }
                  else
                  {
                    f1 = (float)l;
                    f2 = (float)localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_Aulq.a();
                    l = (localaxpx.c / 100.0F * f2 + f1);
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
      paramaxpx.d = 0;
      b(paramaxpx, paramInt);
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
    if (this.jdField_a_of_type_Axpz != null) {
      this.jdField_a_of_type_Axpz.a();
    }
  }
  
  private void e(axpw paramaxpw)
  {
    if (paramaxpw != null)
    {
      paramaxpw = paramaxpw.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (paramaxpw.hasNext()) {
        ((axqa)paramaxpw.next()).a();
      }
    }
  }
  
  private void e(axpx paramaxpx)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(5);
    localMessage.obj = paramaxpx;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "saveCancel");
    }
    if (this.jdField_a_of_type_Axpz != null) {
      this.jdField_a_of_type_Axpz.b();
    }
    this.c = false;
    this.jdField_a_of_type_Long = 0L;
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "saveTips");
    }
    if (this.jdField_a_of_type_Axpz != null) {
      this.jdField_a_of_type_Axpz.c();
    }
  }
  
  private void h()
  {
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      axpx localaxpx = (axpx)localEntry.getValue();
      if ((localaxpx != null) && (localaxpx.jdField_a_of_type_Axpw != null) && (localaxpx.d == 1))
      {
        Iterator localIterator2 = localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        while (localIterator2.hasNext()) {
          ((axqa)localIterator2.next()).a();
        }
        localaxpx.d = 0;
        a((String)localEntry.getKey(), localaxpx);
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
    axpx localaxpx;
    bhvc localbhvc;
    while (localIterator.hasNext())
    {
      localaxpx = (axpx)((Map.Entry)localIterator.next()).getValue();
      if ((localaxpx != null) && (localaxpx.jdField_a_of_type_Axpw != null)) {
        switch (localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_Int)
        {
        default: 
          break;
        case 1: 
          if ((localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_Azqk != null) && (localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_Azqk.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null))
          {
            localbhvc = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(beyb.a(localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_Azqk.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.md5, localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_Azqk.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uuid, 131075));
            if (localbhvc != null) {
              break label406;
            }
            localbhvc = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(beyb.a(localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_Azqk.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.md5, localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_Azqk.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uuid, 1));
          }
          break;
        }
      }
    }
    label406:
    for (;;)
    {
      if (!(localbhvc instanceof berj)) {
        break label39;
      }
      ((berj)localbhvc).a();
      break label39;
      if ((localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_Bcxn != null) && (localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_Bcxn.jdField_a_of_type_Bcwx != null)) {}
      localbhvc = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_Bcxn.jdField_a_of_type_Bcwx.c, localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_Bcxn.jdField_a_of_type_Bcwx.jdField_a_of_type_Long);
      if (!(localbhvc instanceof berj)) {
        break label39;
      }
      ((berj)localbhvc).a();
      break label39;
      if ((localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_Bcxn == null) || (localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_Bcxn.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
        break label39;
      }
      ((bcxh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(95)).b(localaxpx.jdField_a_of_type_Axpw);
      break label39;
      if (localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_Aulq == null) {
        break label39;
      }
      localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_Aulq.b();
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
        axpx localaxpx = (axpx)((Map.Entry)localIterator.next()).getValue();
        if ((localaxpx != null) && (localaxpx.jdField_a_of_type_Axpw != null)) {
          localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
        }
      }
    }
  }
  
  public axpx a(String paramString)
  {
    return (axpx)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public String a(azqd paramazqd)
  {
    if (paramazqd != null) {
      return paramazqd.c + paramazqd.jdField_a_of_type_Long;
    }
    return "";
  }
  
  public String a(bcwx parambcwx)
  {
    if (parambcwx != null) {
      return parambcwx.c + parambcwx.jdField_a_of_type_Long;
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
  
  public void a(aiec paramaiec)
  {
    this.jdField_a_of_type_Aiec = paramaiec;
  }
  
  public void a(Activity paramActivity, List<axpw> paramList)
  {
    a(paramActivity, bhlq.a(paramActivity, 230, paramActivity.getString(2131717542), paramActivity.getString(2131717541), new axqc(this, paramList), new axqg(this)));
  }
  
  public void a(axpw paramaxpw)
  {
    if (paramaxpw != null) {
      switch (paramaxpw.jdField_a_of_type_Int)
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
            } while (paramaxpw.jdField_a_of_type_Azqk == null);
            localaxpx = new axpx();
            localaxpx.jdField_a_of_type_Axpw = paramaxpw;
            paramaxpw = a(paramaxpw.jdField_a_of_type_Azqk.jdField_a_of_type_Azqd);
          } while (TextUtils.isEmpty(paramaxpw));
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramaxpw, localaxpx);
          return;
        } while (paramaxpw.jdField_a_of_type_Bcxn == null);
        localaxpx = new axpx();
        localaxpx.jdField_a_of_type_Axpw = paramaxpw;
        paramaxpw = a(paramaxpw.jdField_a_of_type_Bcxn.jdField_a_of_type_Bcwx);
      } while (TextUtils.isEmpty(paramaxpw));
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramaxpw, localaxpx);
      return;
      if (this.jdField_a_of_type_Attl == null)
      {
        this.jdField_a_of_type_Attl = new attl(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_Attl.a();
      }
    } while (paramaxpw.jdField_a_of_type_Aulq == null);
    axpx localaxpx = new axpx();
    localaxpx.jdField_a_of_type_Axpw = paramaxpw;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramaxpw.jdField_a_of_type_Aulq.a(), localaxpx);
  }
  
  public void a(axpw paramaxpw, int paramInt1, int paramInt2, String paramString)
  {
    axpx localaxpx;
    if ((paramaxpw != null) && (paramaxpw.jdField_a_of_type_Bcxn != null) && (paramaxpw.jdField_a_of_type_Bcxn.jdField_a_of_type_Bcwx != null))
    {
      String str = a(paramaxpw.jdField_a_of_type_Bcxn.jdField_a_of_type_Bcwx);
      localaxpx = a(str);
      if ((localaxpx != null) && (localaxpx.jdField_a_of_type_Axpw != null) && (!localaxpx.jdField_a_of_type_Boolean))
      {
        localaxpx.jdField_a_of_type_Boolean = true;
        localaxpx.jdField_a_of_type_Int = paramInt1;
        localaxpx.c = 100;
        a(str, localaxpx);
        if (paramInt1 != 0) {
          break label196;
        }
        paramaxpw = new File(paramaxpw.jdField_a_of_type_Bcxn.jdField_a_of_type_Bcwx.h);
        if ((!paramaxpw.exists()) && (QLog.isColorLevel())) {
          QLog.d("MultiRichMediaSaveManager", 2, "dealShortVideoDownloadComplete srcFile not exists");
        }
        b(paramaxpw.getAbsolutePath(), new StringBuilder().append(paramaxpw.getParentFile().getName()).append(NetConnInfoCenter.getServerTime()).toString().toLowerCase(Locale.US) + ".mp4", localaxpx);
      }
    }
    return;
    label196:
    localaxpx.b = paramInt2;
    localaxpx.jdField_a_of_type_JavaLangString = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("MultiRichMediaSaveManager", 2, "dealShortVideoDownloadComplete errorCode= " + paramInt2 + ", errorDec= " + paramString);
    }
    b(localaxpx);
  }
  
  public void a(axpx paramaxpx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "saveComplete");
    }
    if (paramaxpx != null)
    {
      if (paramaxpx.d == 1)
      {
        if (paramaxpx.jdField_a_of_type_Axpw != null)
        {
          Iterator localIterator = paramaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          while (localIterator.hasNext())
          {
            axqa localaxqa = (axqa)localIterator.next();
            if (paramaxpx.jdField_a_of_type_Int == 0) {
              localaxqa.a(paramaxpx, 100);
            }
            localaxqa.a(paramaxpx);
          }
        }
        b(paramaxpx.jdField_a_of_type_Axpw);
        c(paramaxpx);
      }
    }
    else {
      return;
    }
    if (this.jdField_a_of_type_Axpz != null) {
      this.jdField_a_of_type_Axpz.a(paramaxpx);
    }
    this.c = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    c(paramaxpx);
  }
  
  public void a(axpx paramaxpx, int paramInt)
  {
    if (paramaxpx != null) {
      if (paramaxpx.d == 1)
      {
        if (paramaxpx.jdField_a_of_type_Axpw != null)
        {
          Iterator localIterator = paramaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          while (localIterator.hasNext()) {
            ((axqa)localIterator.next()).a(paramaxpx, paramInt);
          }
        }
      }
      else if (this.jdField_a_of_type_Axpz != null) {
        this.jdField_a_of_type_Axpz.a(paramaxpx, paramInt);
      }
    }
  }
  
  public void a(axpz paramaxpz)
  {
    this.jdField_a_of_type_Axpz = paramaxpz;
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
        azqk localazqk = azqb.a(7, 1);
        localazqk.a(paramMessageForPic, paramMessageForPic.getPicDownloadInfo());
        String str1 = beqz.d(beyq.a(paramMessageForPic, 131075, null).toString().toString());
        long l = paramMessageForPic.size;
        String str2 = a(paramMessageForPic.getPicDownloadInfo());
        if (a(str2) == null)
        {
          axpx localaxpx = new axpx();
          localaxpx.jdField_a_of_type_Axpw = axpw.a(paramMessageForPic);
          localaxpx.d = 1;
          a(str2, localaxpx);
        }
        localazqk.a(new axqe(this, paramLong, paramInt1, paramInt2, l, str2, str1));
        azqb.a(localazqk, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    axpw localaxpw;
    do
    {
      for (;;)
      {
        return;
        try
        {
          localaxpw = axpw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForShortVideo);
          if ((localaxpw != null) && (localaxpw.jdField_a_of_type_Bcxn != null))
          {
            paramMessageForShortVideo = a(paramMessageForShortVideo.getDownloadInfo(paramMessageForShortVideo.busiType));
            if (a(paramMessageForShortVideo) == null)
            {
              axpx localaxpx = new axpx();
              localaxpx.jdField_a_of_type_Axpw = localaxpw;
              localaxpx.d = 1;
              a(paramMessageForShortVideo, localaxpx);
            }
            if ((!a(localaxpw)) || (localaxpw.jdField_a_of_type_Bcxn.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (this.jdField_a_of_type_Aiec == null)) {
              break label244;
            }
            paramMessageForShortVideo = ShortVideoUtils.a(localaxpw.jdField_a_of_type_Bcxn.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
            this.jdField_a_of_type_Aiec.a(paramLong, paramInt1, paramInt2, 1, paramMessageForShortVideo, false);
            return;
          }
        }
        catch (Exception paramMessageForShortVideo) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("MultiRichMediaSaveManager", 2, "dealSaveVideo exception: " + paramMessageForShortVideo.getMessage());
    return;
    label244:
    localaxpw.jdField_a_of_type_Bcxn.jdField_a_of_type_Boolean = true;
    localaxpw.jdField_a_of_type_Bcxn.jdField_a_of_type_Bcxm = new axqf(this, paramLong, localaxpw, paramMessageForShortVideo, paramInt1, paramInt2);
    ((bcxh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(95)).a(localaxpw);
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
  
  public void a(String paramString, axpx paramaxpx)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramaxpx);
    }
  }
  
  public void a(List<axpw> paramList, int paramInt1, int paramInt2)
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
          switch (((axpw)paramList.next()).jdField_a_of_type_Int)
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
        bdll.b(null, "dc00898", "", "", str, str, paramInt2, 0, String.valueOf(paramInt1), String.valueOf(i), String.valueOf(j), String.valueOf(k));
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
  
  public void a(List<axpw> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "saveMultiRichMedialFile fileSaveReqList is empty!");
      }
      paramList = new axpx();
      paramList.jdField_a_of_type_Int = -1;
      paramList.b = 10006;
      paramList.jdField_a_of_type_JavaLangString = axpv.a(10006);
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
        axpw localaxpw = (axpw)paramList.next();
        if (a(localaxpw)) {
          d(localaxpw);
        } else if (!b(localaxpw)) {
          c(localaxpw);
        }
      }
    }
  }
  
  public boolean a(axpw paramaxpw)
  {
    boolean bool2 = true;
    if (paramaxpw == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFileExist fileSaveReq is empty!");
      }
    }
    do
    {
      return false;
      switch (paramaxpw.jdField_a_of_type_Int)
      {
      default: 
        return false;
      }
    } while ((paramaxpw.jdField_a_of_type_Azqk == null) || (paramaxpw.jdField_a_of_type_Azqk.jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null));
    Object localObject = paramaxpw.jdField_a_of_type_Azqk.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.getPicDownloadInfo();
    if (localObject != null)
    {
      localObject = ((azqd)localObject).c();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new File((String)localObject);
        if ((((File)localObject).exists()) && (((File)localObject).length() == paramaxpw.jdField_a_of_type_Azqk.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size))
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
      if (paramaxpw.jdField_a_of_type_Bcxn == null) {
        break;
      }
      localObject = ShortVideoUtils.a(paramaxpw.jdField_a_of_type_Bcxn.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
      if (localObject == null) {
        break;
      }
      localObject = new File((String)localObject);
      if ((!((File)localObject).exists()) || (paramaxpw.jdField_a_of_type_Bcxn.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (((File)localObject).length() != paramaxpw.jdField_a_of_type_Bcxn.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFileExist shortVideo exists");
      }
      return true;
      if (paramaxpw.jdField_a_of_type_Aulq == null) {
        break;
      }
      return paramaxpw.jdField_a_of_type_Aulq.a();
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
  
  public boolean a(List<axpw> paramList)
  {
    if ((!AppNetConnInfo.isWifiConn()) && (paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      long l = 0L;
      while (paramList.hasNext())
      {
        axpw localaxpw = (axpw)paramList.next();
        if (!a(localaxpw))
        {
          switch (localaxpw.jdField_a_of_type_Int)
          {
          }
          for (;;)
          {
            break;
            if ((localaxpw.jdField_a_of_type_Azqk != null) && (localaxpw.jdField_a_of_type_Azqk.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null))
            {
              l += localaxpw.jdField_a_of_type_Azqk.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
              continue;
              if ((localaxpw.jdField_a_of_type_Bcxn != null) && (localaxpw.jdField_a_of_type_Bcxn.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
              {
                l += localaxpw.jdField_a_of_type_Bcxn.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
                continue;
                if (localaxpw.jdField_a_of_type_Aulq != null) {
                  l += localaxpw.jdField_a_of_type_Aulq.a();
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
    this.jdField_a_of_type_Axpz = null;
  }
  
  public void b(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "cancelSavePic id = " + paramLong);
    }
    paramMessageForPic = a(paramMessageForPic);
    axpx localaxpx = a(paramMessageForPic);
    if (localaxpx != null)
    {
      localaxpx.jdField_a_of_type_Boolean = true;
      localaxpx.jdField_a_of_type_Int = -1;
      a(paramMessageForPic, localaxpx);
      e(localaxpx);
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
    axpx localaxpx = a(str);
    if (localaxpx != null)
    {
      localaxpx.jdField_a_of_type_Boolean = true;
      localaxpx.jdField_a_of_type_Int = -1;
      a(str, localaxpx);
      e(localaxpx);
    }
    ((bcxh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(95)).b(axpw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForShortVideo));
    a(str);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Aiec = null;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "clearFileSaveRequest");
    }
    j();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_Axpz = null;
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    this.c = false;
    this.jdField_a_of_type_Long = 0L;
    if (this.jdField_a_of_type_Attl != null)
    {
      this.jdField_a_of_type_Attl.b();
      this.jdField_a_of_type_Attl = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    axpx localaxpx;
    if ((paramMessage.obj instanceof axpx))
    {
      localaxpx = (axpx)paramMessage.obj;
      if (localaxpx.jdField_a_of_type_Axpw == null) {}
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
          a(localaxpx, paramMessage.arg1);
          return true;
        } while (localaxpx.d != 1);
        e(localaxpx.jdField_a_of_type_Axpw);
        return true;
        if (localaxpx.d == 1)
        {
          d(localaxpx);
          return true;
        }
        if (paramMessage.what == 2)
        {
          this.jdField_a_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            QLog.i("MultiRichMediaSaveManager", 2, "MSG_TYPE_SAVE_FAIL errorCode = " + localaxpx.b + ", errorMsg = " + localaxpx.jdField_a_of_type_JavaLangString);
          }
        }
        for (;;)
        {
          paramMessage = localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          while (paramMessage.hasNext()) {
            ((axqa)paramMessage.next()).a(localaxpx);
          }
          this.b = true;
        }
      } while (!a());
      b(localaxpx, 100);
      if ((this.b) && (!this.jdField_a_of_type_Boolean)) {
        localaxpx.jdField_a_of_type_Int = 0;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "last result = " + localaxpx.jdField_a_of_type_Int);
        }
        this.jdField_a_of_type_Boolean = false;
        this.b = false;
        if (this.jdField_a_of_type_Attl != null)
        {
          this.jdField_a_of_type_Attl.b();
          this.jdField_a_of_type_Attl = null;
        }
        a(localaxpx, 200L);
        return true;
        if ((this.jdField_a_of_type_Boolean) && (!this.b)) {
          localaxpx.jdField_a_of_type_Int = -1;
        } else {
          localaxpx.jdField_a_of_type_Int = 3;
        }
      }
    case 3: 
      paramMessage = localaxpx.jdField_a_of_type_Axpw.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (paramMessage.hasNext()) {
        ((axqa)paramMessage.next()).b(localaxpx);
      }
    }
    a(localaxpx);
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
 * Qualified Name:     axqb
 * JD-Core Version:    0.7.0.1
 */