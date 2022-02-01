import android.app.Activity;
import android.app.Dialog;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.multimsg.save.FileSaveRunnable;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.BaseDownloadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
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

public class axjk
  implements Handler.Callback, Manager
{
  private long jdField_a_of_type_Long;
  protected ahts a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private atkb jdField_a_of_type_Atkb;
  private axji jdField_a_of_type_Axji;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ConcurrentHashMap<String, axjg> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public axjk(QQAppInterface paramQQAppInterface)
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
        axjg localaxjg = (axjg)((Map.Entry)localIterator.next()).getValue();
        if ((localaxjg != null) && (localaxjg.jdField_a_of_type_Axjf != null)) {
          switch (localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_Int)
          {
          default: 
            break;
          case 1: 
            if ((localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_Azke != null) && (localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_Azke.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)) {
              this.jdField_a_of_type_Long += localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_Azke.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
            }
            break;
          case 2: 
          case 3: 
            if ((localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_Bcxr != null) && (localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_Bcxr.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
              this.jdField_a_of_type_Long += localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_Bcxr.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
            }
            break;
          case 4: 
          case 5: 
          case 6: 
          case 7: 
            if (localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_Auch != null) {
              this.jdField_a_of_type_Long += localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_Auch.a();
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
  
  private void a(int paramInt, axjf paramaxjf)
  {
    axjg localaxjg = new axjg();
    localaxjg.jdField_a_of_type_Int = -1;
    localaxjg.jdField_a_of_type_Axjf = paramaxjf;
    localaxjg.b = paramInt;
    localaxjg.jdField_a_of_type_JavaLangString = axje.a(paramInt);
    b(localaxjg);
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
  
  private void a(auch paramauch)
  {
    if (paramauch != null) {
      paramauch.a(paramauch.b(), new axjm(this, paramauch));
    }
  }
  
  private void a(axjf paramaxjf, int paramInt)
  {
    if ((paramaxjf != null) && (paramaxjf.jdField_a_of_type_Azke != null))
    {
      paramaxjf = a(paramaxjf.jdField_a_of_type_Azke.jdField_a_of_type_Azjx);
      axjg localaxjg = a(paramaxjf);
      if ((localaxjg != null) && (!localaxjg.jdField_a_of_type_Boolean))
      {
        paramInt /= 100;
        localaxjg.c = paramInt;
        a(paramaxjf, localaxjg);
        c(localaxjg, paramInt);
      }
    }
  }
  
  private void a(axjf paramaxjf, boolean paramBoolean)
  {
    String str;
    axjg localaxjg;
    if ((paramaxjf != null) && (paramaxjf.jdField_a_of_type_Auch != null))
    {
      str = paramaxjf.jdField_a_of_type_Auch.a();
      localaxjg = a(str);
      if ((localaxjg == null) || (localaxjg.jdField_a_of_type_Boolean)) {
        break label97;
      }
      localaxjg.jdField_a_of_type_Boolean = true;
      localaxjg.c = 100;
      a(str, localaxjg);
      if (!paramBoolean) {
        break label188;
      }
    }
    switch (paramaxjf.jdField_a_of_type_Int)
    {
    default: 
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("MultiRichMediaSaveManager", 2, "dealFileMultilDownloadComplete fileType= " + paramaxjf.jdField_a_of_type_Int);
      return;
    case 4: 
    case 6: 
      label97:
      paramaxjf = paramaxjf.jdField_a_of_type_Auch.b();
      str = Utils.Crc64String(paramaxjf + NetConnInfoCenter.getServerTime());
      localaxjg.jdField_a_of_type_Int = 0;
      a(paramaxjf, str, localaxjg);
      return;
    }
    a(paramaxjf.jdField_a_of_type_Auch);
    return;
    label188:
    if (QLog.isColorLevel()) {
      QLog.d("MultiRichMediaSaveManager", 2, "dealFileMultilDownloadComplete errorType= " + paramaxjf.jdField_a_of_type_Int);
    }
    localaxjg.jdField_a_of_type_Int = -1;
    b(localaxjg);
  }
  
  private void a(axjg paramaxjg, long paramLong)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4);
    localMessage.obj = paramaxjg;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  private void a(String paramString1, String paramString2, axjg paramaxjg)
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
        if ((paramaxjg != null) && (paramaxjg.jdField_a_of_type_Axjf != null))
        {
          paramaxjg.jdField_a_of_type_Int = -1;
          paramaxjg.b = i;
          paramaxjg.jdField_a_of_type_JavaLangString = axje.a(i);
          b(paramaxjg);
        }
        return;
        if (TextUtils.isEmpty(paramString2))
        {
          i = 10002;
          continue;
        }
        if (!FileUtils.fileExists(paramString1)) {
          i = 10003;
        }
      }
      else
      {
        new File(AppConstants.SDCARD_IMG_SAVE).mkdirs();
        String str = paramString2;
        if (!paramString2.contains("."))
        {
          str = FileUtils.estimateFileType(paramString1);
          str = paramString2 + "." + str;
        }
        paramString2 = new File(AppConstants.SDCARD_IMG_SAVE, str);
        ThreadManager.getFileThreadHandler().post(new FileSaveRunnable(new File(paramString1), paramString2, this.jdField_a_of_type_AndroidOsHandler, paramaxjg, false));
        return;
      }
      i = 0;
    }
  }
  
  private void a(List<axjf> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((axjf)paramList.next());
    }
  }
  
  private boolean a()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        axjg localaxjg = (axjg)((Map.Entry)localIterator.next()).getValue();
        if ((localaxjg == null) || (!localaxjg.jdField_a_of_type_Boolean)) {
          return false;
        }
      }
    }
    return true;
  }
  
  private void b(axjf paramaxjf)
  {
    String str;
    if (paramaxjf != null)
    {
      str = "";
      switch (paramaxjf.jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      a(str);
      return;
      if (paramaxjf.jdField_a_of_type_Azke != null)
      {
        str = a(paramaxjf.jdField_a_of_type_Azke.jdField_a_of_type_Azjx);
        continue;
        if (paramaxjf.jdField_a_of_type_Bcxr != null)
        {
          str = a(paramaxjf.jdField_a_of_type_Bcxr.jdField_a_of_type_Bcxb);
          continue;
          if (paramaxjf.jdField_a_of_type_Auch != null) {
            str = paramaxjf.jdField_a_of_type_Auch.a();
          }
        }
      }
    }
  }
  
  private void b(axjf paramaxjf, int paramInt1, int paramInt2, String paramString)
  {
    axjg localaxjg;
    if ((paramaxjf != null) && (paramaxjf.jdField_a_of_type_Azke != null) && (paramaxjf.jdField_a_of_type_Azke.jdField_a_of_type_Azjx != null))
    {
      String str = a(paramaxjf.jdField_a_of_type_Azke.jdField_a_of_type_Azjx);
      localaxjg = a(str);
      if ((localaxjg != null) && (localaxjg.jdField_a_of_type_Axjf != null) && (!localaxjg.jdField_a_of_type_Boolean))
      {
        localaxjg.jdField_a_of_type_Boolean = true;
        localaxjg.jdField_a_of_type_Int = paramInt1;
        localaxjg.c = 100;
        a(str, localaxjg);
        if (paramInt1 != 0) {
          break label136;
        }
        paramaxjf = paramaxjf.jdField_a_of_type_Azke.jdField_a_of_type_Azjx.c();
        a(paramaxjf, Utils.Crc64String(paramaxjf + NetConnInfoCenter.getServerTime()), localaxjg);
      }
    }
    return;
    label136:
    localaxjg.b = paramInt2;
    localaxjg.jdField_a_of_type_JavaLangString = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("MultiRichMediaSaveManager", 2, "dealPicDownloadComplete errorCode= " + paramInt2 + ", errorDec= " + paramString);
    }
    b(localaxjg);
  }
  
  private void b(axjg paramaxjg)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
    localMessage.obj = paramaxjg;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void b(axjg paramaxjg, int paramInt)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(6);
    localMessage.obj = paramaxjg;
    localMessage.arg1 = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void b(String paramString1, String paramString2, axjg paramaxjg)
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
        if ((paramaxjg != null) && (paramaxjg.jdField_a_of_type_Axjf != null))
        {
          paramaxjg.jdField_a_of_type_Int = -1;
          paramaxjg.b = i;
          paramaxjg.jdField_a_of_type_JavaLangString = axje.a(i);
          b(paramaxjg);
        }
        return;
        if (TextUtils.isEmpty(paramString2))
        {
          i = 10002;
          continue;
        }
        if (!FileUtils.fileExists(paramString1)) {
          i = 10003;
        }
      }
      else
      {
        if (VersionUtils.isrFroyo()) {}
        for (File localFile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);; localFile = new File(AppConstants.SDCARD_VIDEO))
        {
          localFile.mkdirs();
          paramString2 = new File(localFile, ShortVideoUtils.getShortVideoSaveFileName(paramString2));
          ThreadManager.getFileThreadHandler().post(new FileSaveRunnable(new File(paramString1), paramString2, this.jdField_a_of_type_AndroidOsHandler, paramaxjg, false));
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
        axjg localaxjg = (axjg)((Map.Entry)localIterator.next()).getValue();
        if ((localaxjg != null) && (localaxjg.d == 1) && (!localaxjg.jdField_a_of_type_Boolean)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean b(axjf paramaxjf)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramaxjf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload fileSaveReq is empty!");
      }
      return false;
    }
    switch (paramaxjf.jdField_a_of_type_Int)
    {
    default: 
      bool2 = bool1;
      label74:
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      if ((paramaxjf.jdField_a_of_type_Azke == null) || (paramaxjf.jdField_a_of_type_Azke.jdField_a_of_type_Azjx == null) || (paramaxjf.jdField_a_of_type_Azke.jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload picReq is empty!");
        return false;
      }
      if ((paramaxjf.jdField_a_of_type_Azke.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) && (paramaxjf.jdField_a_of_type_Azke.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.fileSizeFlag == 1)) {
        break;
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(TransFileController.makeReceiveKey(paramaxjf.jdField_a_of_type_Azke.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.md5, paramaxjf.jdField_a_of_type_Azke.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uuid, 1));
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if ((localObject instanceof BaseDownloadProcessor)) {
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (!bool1) {
        break label74;
      }
      localObject = (BaseDownloadProcessor)localObject;
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload picReq addDownCallback");
      }
      ((BaseDownloadProcessor)localObject).addDownCallback(new axjq(this, paramaxjf));
      continue;
      if ((paramaxjf.jdField_a_of_type_Bcxr == null) || (paramaxjf.jdField_a_of_type_Bcxr.jdField_a_of_type_Bcxb == null))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload shortVideoReq is empty!");
        return false;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(paramaxjf.jdField_a_of_type_Bcxr.jdField_a_of_type_Bcxb.c, paramaxjf.jdField_a_of_type_Bcxr.jdField_a_of_type_Bcxb.jdField_a_of_type_Long);
      bool2 = bool1;
      if (localObject == null) {
        break label74;
      }
      bool2 = bool1;
      if (!(localObject instanceof BaseDownloadProcessor)) {
        break label74;
      }
      localObject = (BaseDownloadProcessor)localObject;
      if ((((BaseDownloadProcessor)localObject).mUiRequest != null) && ((((BaseDownloadProcessor)localObject).mUiRequest.mFileType == 7) || (((BaseDownloadProcessor)localObject).mUiRequest.mFileType == 16) || (((BaseDownloadProcessor)localObject).mUiRequest.mFileType == 18)))
      {
        ((BaseDownloadProcessor)localObject).cancel();
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload shortVideoReq addDownCallback");
      }
      ((BaseDownloadProcessor)localObject).addDownCallback(new axjr(this, paramaxjf));
      bool1 = false;
      continue;
      bool1 = false;
      continue;
      bool2 = bool1;
      if (paramaxjf.jdField_a_of_type_Auch == null) {
        break label74;
      }
      bool2 = paramaxjf.jdField_a_of_type_Auch.b();
      bool1 = bool2;
      if (bool2)
      {
        paramaxjf.jdField_a_of_type_Auch.a(new axjs(this, paramaxjf));
        bool1 = bool2;
        if (this.jdField_a_of_type_Atkb != null)
        {
          this.jdField_a_of_type_Atkb.a(paramaxjf.jdField_a_of_type_Auch.a());
          bool1 = bool2;
        }
      }
    }
  }
  
  private void c(axjf paramaxjf)
  {
    if (paramaxjf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "downloadFile fileSaveReq is empty!");
      }
      a(10007, new axjf());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadFile fileType = " + paramaxjf.jdField_a_of_type_Int);
    }
    String str;
    switch (paramaxjf.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      if (paramaxjf.jdField_a_of_type_Azke != null)
      {
        str = a(paramaxjf.jdField_a_of_type_Azke.jdField_a_of_type_Azjx);
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "downloadPic key = " + str);
        }
        paramaxjf.jdField_a_of_type_Azke.a(new axjt(this, str, paramaxjf));
        azjv.a(paramaxjf.jdField_a_of_type_Azke, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
      a(10007, paramaxjf);
      return;
    case 2: 
      if (paramaxjf.jdField_a_of_type_Bcxr != null)
      {
        str = a(paramaxjf.jdField_a_of_type_Bcxr.jdField_a_of_type_Bcxb);
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "downloadShortVideo key = " + str);
        }
        paramaxjf.jdField_a_of_type_Bcxr.a(new axju(this, str, paramaxjf));
        bcwz.a(paramaxjf.jdField_a_of_type_Bcxr, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
      a(10007, paramaxjf);
      return;
    case 3: 
      if (paramaxjf.jdField_a_of_type_Bcxr != null)
      {
        str = a(paramaxjf.jdField_a_of_type_Bcxr.jdField_a_of_type_Bcxb);
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "downloadVideo key = " + str);
        }
        paramaxjf.jdField_a_of_type_Bcxr.jdField_a_of_type_Boolean = true;
        paramaxjf.jdField_a_of_type_Bcxr.jdField_a_of_type_Bcxq = new axjv(this, paramaxjf, str);
        ((bcxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SHORT_VIDEO_PREDOWNLOAD_MANAGER)).a(paramaxjf);
        return;
      }
      a(10007, paramaxjf);
      return;
    }
    if (paramaxjf.jdField_a_of_type_Auch != null)
    {
      str = paramaxjf.jdField_a_of_type_Auch.a();
      if (QLog.isColorLevel()) {
        QLog.i("MultiRichMediaSaveManager", 2, "downloadFile key = " + str);
      }
      paramaxjf.jdField_a_of_type_Auch.a(new axjw(this, str, paramaxjf));
      if (this.jdField_a_of_type_Atkb != null) {
        this.jdField_a_of_type_Atkb.a(paramaxjf.jdField_a_of_type_Auch.a());
      }
      paramaxjf.jdField_a_of_type_Auch.a();
      return;
    }
    a(10007, paramaxjf);
  }
  
  private void c(axjg paramaxjg)
  {
    HashMap localHashMap;
    if (paramaxjg != null)
    {
      localHashMap = new HashMap();
      if (paramaxjg.d != 1) {
        break label70;
      }
      localHashMap.put("isMultiSave", "1");
      if (paramaxjg.jdField_a_of_type_Int != 0) {
        break label84;
      }
      localHashMap.put("isSuccess", "0");
    }
    for (;;)
    {
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "MultiRichMediaFileSave", true, 0L, 0L, localHashMap, "");
      return;
      label70:
      localHashMap.put("isMultiSave", "0");
      break;
      label84:
      localHashMap.put("isSuccess", "1");
      localHashMap.put("errorCode", String.valueOf(paramaxjg.b));
      localHashMap.put("isSuccess", paramaxjg.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void c(axjg paramaxjg, int paramInt)
  {
    if (paramaxjg != null)
    {
      paramaxjg.c = paramInt;
      d(paramaxjg, paramInt);
    }
  }
  
  private void d(axjf paramaxjf)
  {
    if (paramaxjf != null) {}
    switch (paramaxjf.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      b(paramaxjf, 0, 0, "");
      return;
    case 2: 
    case 3: 
      a(paramaxjf, 0, 0, "");
      return;
    }
    a(paramaxjf, true);
  }
  
  private void d(axjg paramaxjg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "notifySingleComplete");
    }
    if (paramaxjg != null)
    {
      a(paramaxjg);
      if ((paramaxjg.jdField_a_of_type_Axjx != null) && (this.jdField_a_of_type_Ahts != null)) {
        this.jdField_a_of_type_Ahts.a(paramaxjg.jdField_a_of_type_Axjx.jdField_a_of_type_Long, paramaxjg.jdField_a_of_type_Axjx.jdField_a_of_type_Int, paramaxjg.jdField_a_of_type_Axjx.b, paramaxjg.jdField_a_of_type_Axjx.c, paramaxjg.jdField_a_of_type_Axjx.jdField_a_of_type_JavaLangString, paramaxjg.jdField_a_of_type_Axjx.jdField_a_of_type_Boolean);
      }
    }
  }
  
  private void d(axjg paramaxjg, int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    long l = 0L;
    if (localIterator.hasNext())
    {
      axjg localaxjg = (axjg)((Map.Entry)localIterator.next()).getValue();
      if ((localaxjg != null) && (localaxjg.jdField_a_of_type_Axjf != null)) {
        switch (localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_Int)
        {
        }
      }
      for (;;)
      {
        break;
        if ((localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_Azke != null) && (localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_Azke.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)) {
          if (localaxjg.jdField_a_of_type_Boolean)
          {
            l += localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_Azke.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
          }
          else
          {
            float f1 = (float)l;
            float f2 = (float)localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_Azke.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
            l = (localaxjg.c / 100.0F * f2 + f1);
            continue;
            if ((localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_Bcxr != null) && (localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_Bcxr.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
              if (localaxjg.jdField_a_of_type_Boolean)
              {
                l += localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_Bcxr.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
              }
              else
              {
                f1 = (float)l;
                f2 = localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_Bcxr.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
                l = (localaxjg.c / 100.0F * f2 + f1);
                continue;
                if (localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_Auch != null) {
                  if (localaxjg.jdField_a_of_type_Boolean)
                  {
                    l += localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_Auch.a();
                  }
                  else
                  {
                    f1 = (float)l;
                    f2 = (float)localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_Auch.a();
                    l = (localaxjg.c / 100.0F * f2 + f1);
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
      paramaxjg.d = 0;
      b(paramaxjg, paramInt);
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
    if (this.jdField_a_of_type_Axji != null) {
      this.jdField_a_of_type_Axji.a();
    }
  }
  
  private void e(axjf paramaxjf)
  {
    if (paramaxjf != null)
    {
      paramaxjf = paramaxjf.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (paramaxjf.hasNext()) {
        ((axjj)paramaxjf.next()).a();
      }
    }
  }
  
  private void e(axjg paramaxjg)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(5);
    localMessage.obj = paramaxjg;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "saveCancel");
    }
    if (this.jdField_a_of_type_Axji != null) {
      this.jdField_a_of_type_Axji.b();
    }
    this.c = false;
    this.jdField_a_of_type_Long = 0L;
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "saveTips");
    }
    if (this.jdField_a_of_type_Axji != null) {
      this.jdField_a_of_type_Axji.c();
    }
  }
  
  private void h()
  {
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      axjg localaxjg = (axjg)localEntry.getValue();
      if ((localaxjg != null) && (localaxjg.jdField_a_of_type_Axjf != null) && (localaxjg.d == 1))
      {
        Iterator localIterator2 = localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        while (localIterator2.hasNext()) {
          ((axjj)localIterator2.next()).a();
        }
        localaxjg.d = 0;
        a((String)localEntry.getKey(), localaxjg);
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
    axjg localaxjg;
    IHttpCommunicatorListener localIHttpCommunicatorListener;
    while (localIterator.hasNext())
    {
      localaxjg = (axjg)((Map.Entry)localIterator.next()).getValue();
      if ((localaxjg != null) && (localaxjg.jdField_a_of_type_Axjf != null)) {
        switch (localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_Int)
        {
        default: 
          break;
        case 1: 
          if ((localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_Azke != null) && (localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_Azke.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null))
          {
            localIHttpCommunicatorListener = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(TransFileController.makeReceiveKey(localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_Azke.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.md5, localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_Azke.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uuid, 131075));
            if (localIHttpCommunicatorListener != null) {
              break label407;
            }
            localIHttpCommunicatorListener = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(TransFileController.makeReceiveKey(localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_Azke.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.md5, localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_Azke.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uuid, 1));
          }
          break;
        }
      }
    }
    label407:
    for (;;)
    {
      if (!(localIHttpCommunicatorListener instanceof BaseDownloadProcessor)) {
        break label39;
      }
      ((BaseDownloadProcessor)localIHttpCommunicatorListener).cancel();
      break label39;
      if ((localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_Bcxr != null) && (localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_Bcxr.jdField_a_of_type_Bcxb != null)) {}
      localIHttpCommunicatorListener = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_Bcxr.jdField_a_of_type_Bcxb.c, localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_Bcxr.jdField_a_of_type_Bcxb.jdField_a_of_type_Long);
      if (!(localIHttpCommunicatorListener instanceof BaseDownloadProcessor)) {
        break label39;
      }
      ((BaseDownloadProcessor)localIHttpCommunicatorListener).cancel();
      break label39;
      if ((localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_Bcxr == null) || (localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_Bcxr.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
        break label39;
      }
      ((bcxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SHORT_VIDEO_PREDOWNLOAD_MANAGER)).b(localaxjg.jdField_a_of_type_Axjf);
      break label39;
      if (localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_Auch == null) {
        break label39;
      }
      localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_Auch.b();
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
        axjg localaxjg = (axjg)((Map.Entry)localIterator.next()).getValue();
        if ((localaxjg != null) && (localaxjg.jdField_a_of_type_Axjf != null)) {
          localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
        }
      }
    }
  }
  
  public axjg a(String paramString)
  {
    return (axjg)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public String a(azjx paramazjx)
  {
    if (paramazjx != null) {
      return paramazjx.c + paramazjx.jdField_a_of_type_Long;
    }
    return "";
  }
  
  public String a(bcxb parambcxb)
  {
    if (parambcxb != null) {
      return parambcxb.c + parambcxb.jdField_a_of_type_Long;
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
  
  public void a(ahts paramahts)
  {
    this.jdField_a_of_type_Ahts = paramahts;
  }
  
  public void a(Activity paramActivity, List<axjf> paramList)
  {
    a(paramActivity, bhdj.a(paramActivity, 230, paramActivity.getString(2131718160), paramActivity.getString(2131718159), new axjl(this, paramList), new axjp(this)));
  }
  
  public void a(axjf paramaxjf)
  {
    if (paramaxjf != null) {
      switch (paramaxjf.jdField_a_of_type_Int)
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
            } while (paramaxjf.jdField_a_of_type_Azke == null);
            localaxjg = new axjg();
            localaxjg.jdField_a_of_type_Axjf = paramaxjf;
            paramaxjf = a(paramaxjf.jdField_a_of_type_Azke.jdField_a_of_type_Azjx);
          } while (TextUtils.isEmpty(paramaxjf));
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramaxjf, localaxjg);
          return;
        } while (paramaxjf.jdField_a_of_type_Bcxr == null);
        localaxjg = new axjg();
        localaxjg.jdField_a_of_type_Axjf = paramaxjf;
        paramaxjf = a(paramaxjf.jdField_a_of_type_Bcxr.jdField_a_of_type_Bcxb);
      } while (TextUtils.isEmpty(paramaxjf));
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramaxjf, localaxjg);
      return;
      if (this.jdField_a_of_type_Atkb == null)
      {
        this.jdField_a_of_type_Atkb = new atkb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_Atkb.a();
      }
    } while (paramaxjf.jdField_a_of_type_Auch == null);
    axjg localaxjg = new axjg();
    localaxjg.jdField_a_of_type_Axjf = paramaxjf;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramaxjf.jdField_a_of_type_Auch.a(), localaxjg);
  }
  
  public void a(axjf paramaxjf, int paramInt1, int paramInt2, String paramString)
  {
    axjg localaxjg;
    if ((paramaxjf != null) && (paramaxjf.jdField_a_of_type_Bcxr != null) && (paramaxjf.jdField_a_of_type_Bcxr.jdField_a_of_type_Bcxb != null))
    {
      String str = a(paramaxjf.jdField_a_of_type_Bcxr.jdField_a_of_type_Bcxb);
      localaxjg = a(str);
      if ((localaxjg != null) && (localaxjg.jdField_a_of_type_Axjf != null) && (!localaxjg.jdField_a_of_type_Boolean))
      {
        localaxjg.jdField_a_of_type_Boolean = true;
        localaxjg.jdField_a_of_type_Int = paramInt1;
        localaxjg.c = 100;
        a(str, localaxjg);
        if (paramInt1 != 0) {
          break label196;
        }
        paramaxjf = new File(paramaxjf.jdField_a_of_type_Bcxr.jdField_a_of_type_Bcxb.h);
        if ((!paramaxjf.exists()) && (QLog.isColorLevel())) {
          QLog.d("MultiRichMediaSaveManager", 2, "dealShortVideoDownloadComplete srcFile not exists");
        }
        b(paramaxjf.getAbsolutePath(), new StringBuilder().append(paramaxjf.getParentFile().getName()).append(NetConnInfoCenter.getServerTime()).toString().toLowerCase(Locale.US) + ".mp4", localaxjg);
      }
    }
    return;
    label196:
    localaxjg.b = paramInt2;
    localaxjg.jdField_a_of_type_JavaLangString = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("MultiRichMediaSaveManager", 2, "dealShortVideoDownloadComplete errorCode= " + paramInt2 + ", errorDec= " + paramString);
    }
    b(localaxjg);
  }
  
  public void a(axjg paramaxjg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "saveComplete");
    }
    if (paramaxjg != null)
    {
      if (paramaxjg.d == 1)
      {
        if (paramaxjg.jdField_a_of_type_Axjf != null)
        {
          Iterator localIterator = paramaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          while (localIterator.hasNext())
          {
            axjj localaxjj = (axjj)localIterator.next();
            if (paramaxjg.jdField_a_of_type_Int == 0) {
              localaxjj.a(paramaxjg, 100);
            }
            localaxjj.a(paramaxjg);
          }
        }
        b(paramaxjg.jdField_a_of_type_Axjf);
        c(paramaxjg);
      }
    }
    else {
      return;
    }
    if (this.jdField_a_of_type_Axji != null) {
      this.jdField_a_of_type_Axji.a(paramaxjg);
    }
    this.c = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    c(paramaxjg);
  }
  
  public void a(axjg paramaxjg, int paramInt)
  {
    if (paramaxjg != null) {
      if (paramaxjg.d == 1)
      {
        if (paramaxjg.jdField_a_of_type_Axjf != null)
        {
          Iterator localIterator = paramaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          while (localIterator.hasNext()) {
            ((axjj)localIterator.next()).a(paramaxjg, paramInt);
          }
        }
      }
      else if (this.jdField_a_of_type_Axji != null) {
        this.jdField_a_of_type_Axji.a(paramaxjg, paramInt);
      }
    }
  }
  
  public void a(axji paramaxji)
  {
    this.jdField_a_of_type_Axji = paramaxji;
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
        azke localazke = azjv.a(7, 1);
        localazke.a(paramMessageForPic, paramMessageForPic.getPicDownloadInfo());
        String str1 = AbsDownloader.getFilePath(URLDrawableHelper.getURL(paramMessageForPic, 131075, null).toString().toString());
        long l = paramMessageForPic.size;
        String str2 = a(paramMessageForPic.getPicDownloadInfo());
        if (a(str2) == null)
        {
          axjg localaxjg = new axjg();
          localaxjg.jdField_a_of_type_Axjf = axjf.a(paramMessageForPic);
          localaxjg.d = 1;
          a(str2, localaxjg);
        }
        localazke.a(new axjn(this, paramLong, paramInt1, paramInt2, l, str2, str1));
        azjv.a(localazke, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    axjf localaxjf;
    do
    {
      for (;;)
      {
        return;
        try
        {
          localaxjf = axjf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForShortVideo);
          if ((localaxjf != null) && (localaxjf.jdField_a_of_type_Bcxr != null))
          {
            paramMessageForShortVideo = a(paramMessageForShortVideo.getDownloadInfo(paramMessageForShortVideo.busiType));
            if (a(paramMessageForShortVideo) == null)
            {
              axjg localaxjg = new axjg();
              localaxjg.jdField_a_of_type_Axjf = localaxjf;
              localaxjg.d = 1;
              a(paramMessageForShortVideo, localaxjg);
            }
            if ((!a(localaxjf)) || (localaxjf.jdField_a_of_type_Bcxr.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (this.jdField_a_of_type_Ahts == null)) {
              break label244;
            }
            paramMessageForShortVideo = ShortVideoUtils.getShortVideoSavePath(localaxjf.jdField_a_of_type_Bcxr.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
            this.jdField_a_of_type_Ahts.a(paramLong, paramInt1, paramInt2, 1, paramMessageForShortVideo, false);
            return;
          }
        }
        catch (Exception paramMessageForShortVideo) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("MultiRichMediaSaveManager", 2, "dealSaveVideo exception: " + paramMessageForShortVideo.getMessage());
    return;
    label244:
    localaxjf.jdField_a_of_type_Bcxr.jdField_a_of_type_Boolean = true;
    localaxjf.jdField_a_of_type_Bcxr.jdField_a_of_type_Bcxq = new axjo(this, paramLong, localaxjf, paramMessageForShortVideo, paramInt1, paramInt2);
    ((bcxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SHORT_VIDEO_PREDOWNLOAD_MANAGER)).a(localaxjf);
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
  
  public void a(String paramString, axjg paramaxjg)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramaxjg);
    }
  }
  
  public void a(List<axjf> paramList, int paramInt1, int paramInt2)
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
          switch (((axjf)paramList.next()).jdField_a_of_type_Int)
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
        bdla.b(null, "dc00898", "", "", str, str, paramInt2, 0, String.valueOf(paramInt1), String.valueOf(i), String.valueOf(j), String.valueOf(k));
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
  
  public void a(List<axjf> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "saveMultiRichMedialFile fileSaveReqList is empty!");
      }
      paramList = new axjg();
      paramList.jdField_a_of_type_Int = -1;
      paramList.b = 10006;
      paramList.jdField_a_of_type_JavaLangString = axje.a(10006);
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
        axjf localaxjf = (axjf)paramList.next();
        if (a(localaxjf)) {
          d(localaxjf);
        } else if (!b(localaxjf)) {
          c(localaxjf);
        }
      }
    }
  }
  
  public boolean a(axjf paramaxjf)
  {
    boolean bool2 = true;
    if (paramaxjf == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFileExist fileSaveReq is empty!");
      }
    }
    do
    {
      return false;
      switch (paramaxjf.jdField_a_of_type_Int)
      {
      default: 
        return false;
      }
    } while ((paramaxjf.jdField_a_of_type_Azke == null) || (paramaxjf.jdField_a_of_type_Azke.jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null));
    Object localObject = paramaxjf.jdField_a_of_type_Azke.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.getPicDownloadInfo();
    if (localObject != null)
    {
      localObject = ((azjx)localObject).c();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new File((String)localObject);
        if ((((File)localObject).exists()) && (((File)localObject).length() == paramaxjf.jdField_a_of_type_Azke.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size))
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
      if (paramaxjf.jdField_a_of_type_Bcxr == null) {
        break;
      }
      localObject = ShortVideoUtils.getShortVideoSavePath(paramaxjf.jdField_a_of_type_Bcxr.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
      if (localObject == null) {
        break;
      }
      localObject = new File((String)localObject);
      if ((!((File)localObject).exists()) || (paramaxjf.jdField_a_of_type_Bcxr.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (((File)localObject).length() != paramaxjf.jdField_a_of_type_Bcxr.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFileExist shortVideo exists");
      }
      return true;
      if (paramaxjf.jdField_a_of_type_Auch == null) {
        break;
      }
      return paramaxjf.jdField_a_of_type_Auch.a();
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
  
  public boolean a(List<axjf> paramList)
  {
    if ((!AppNetConnInfo.isWifiConn()) && (paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      long l = 0L;
      while (paramList.hasNext())
      {
        axjf localaxjf = (axjf)paramList.next();
        if (!a(localaxjf))
        {
          switch (localaxjf.jdField_a_of_type_Int)
          {
          }
          for (;;)
          {
            break;
            if ((localaxjf.jdField_a_of_type_Azke != null) && (localaxjf.jdField_a_of_type_Azke.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null))
            {
              l += localaxjf.jdField_a_of_type_Azke.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
              continue;
              if ((localaxjf.jdField_a_of_type_Bcxr != null) && (localaxjf.jdField_a_of_type_Bcxr.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
              {
                l += localaxjf.jdField_a_of_type_Bcxr.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
                continue;
                if (localaxjf.jdField_a_of_type_Auch != null) {
                  l += localaxjf.jdField_a_of_type_Auch.a();
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
    this.jdField_a_of_type_Axji = null;
  }
  
  public void b(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "cancelSavePic id = " + paramLong);
    }
    paramMessageForPic = a(paramMessageForPic);
    axjg localaxjg = a(paramMessageForPic);
    if (localaxjg != null)
    {
      localaxjg.jdField_a_of_type_Boolean = true;
      localaxjg.jdField_a_of_type_Int = -1;
      a(paramMessageForPic, localaxjg);
      e(localaxjg);
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
    axjg localaxjg = a(str);
    if (localaxjg != null)
    {
      localaxjg.jdField_a_of_type_Boolean = true;
      localaxjg.jdField_a_of_type_Int = -1;
      a(str, localaxjg);
      e(localaxjg);
    }
    ((bcxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SHORT_VIDEO_PREDOWNLOAD_MANAGER)).b(axjf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForShortVideo));
    a(str);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Ahts = null;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "clearFileSaveRequest");
    }
    j();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_Axji = null;
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    this.c = false;
    this.jdField_a_of_type_Long = 0L;
    if (this.jdField_a_of_type_Atkb != null)
    {
      this.jdField_a_of_type_Atkb.b();
      this.jdField_a_of_type_Atkb = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    axjg localaxjg;
    if ((paramMessage.obj instanceof axjg))
    {
      localaxjg = (axjg)paramMessage.obj;
      if (localaxjg.jdField_a_of_type_Axjf == null) {}
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
          a(localaxjg, paramMessage.arg1);
          return true;
        } while (localaxjg.d != 1);
        e(localaxjg.jdField_a_of_type_Axjf);
        return true;
        if (localaxjg.d == 1)
        {
          d(localaxjg);
          return true;
        }
        if (paramMessage.what == 2)
        {
          this.jdField_a_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            QLog.i("MultiRichMediaSaveManager", 2, "MSG_TYPE_SAVE_FAIL errorCode = " + localaxjg.b + ", errorMsg = " + localaxjg.jdField_a_of_type_JavaLangString);
          }
        }
        for (;;)
        {
          paramMessage = localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          while (paramMessage.hasNext()) {
            ((axjj)paramMessage.next()).a(localaxjg);
          }
          this.b = true;
        }
      } while (!a());
      b(localaxjg, 100);
      if ((this.b) && (!this.jdField_a_of_type_Boolean)) {
        localaxjg.jdField_a_of_type_Int = 0;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "last result = " + localaxjg.jdField_a_of_type_Int);
        }
        this.jdField_a_of_type_Boolean = false;
        this.b = false;
        if (this.jdField_a_of_type_Atkb != null)
        {
          this.jdField_a_of_type_Atkb.b();
          this.jdField_a_of_type_Atkb = null;
        }
        a(localaxjg, 200L);
        return true;
        if ((this.jdField_a_of_type_Boolean) && (!this.b)) {
          localaxjg.jdField_a_of_type_Int = -1;
        } else {
          localaxjg.jdField_a_of_type_Int = 3;
        }
      }
    case 3: 
      paramMessage = localaxjg.jdField_a_of_type_Axjf.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (paramMessage.hasNext()) {
        ((axjj)paramMessage.next()).b(localaxjg);
      }
    }
    a(localaxjg);
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
 * Qualified Name:     axjk
 * JD-Core Version:    0.7.0.1
 */