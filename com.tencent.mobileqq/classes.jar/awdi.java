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

public class awdi
  implements Handler.Callback, Manager
{
  private long jdField_a_of_type_Long;
  protected ahas a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private asfv jdField_a_of_type_Asfv;
  private awdg jdField_a_of_type_Awdg;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ConcurrentHashMap<String, awde> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public awdi(QQAppInterface paramQQAppInterface)
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
        awde localawde = (awde)((Map.Entry)localIterator.next()).getValue();
        if ((localawde != null) && (localawde.jdField_a_of_type_Awdd != null)) {
          switch (localawde.jdField_a_of_type_Awdd.jdField_a_of_type_Int)
          {
          default: 
            break;
          case 1: 
            if ((localawde.jdField_a_of_type_Awdd.jdField_a_of_type_Ayds != null) && (localawde.jdField_a_of_type_Awdd.jdField_a_of_type_Ayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)) {
              this.jdField_a_of_type_Long += localawde.jdField_a_of_type_Awdd.jdField_a_of_type_Ayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
            }
            break;
          case 2: 
          case 3: 
            if ((localawde.jdField_a_of_type_Awdd.jdField_a_of_type_Bbqx != null) && (localawde.jdField_a_of_type_Awdd.jdField_a_of_type_Bbqx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
              this.jdField_a_of_type_Long += localawde.jdField_a_of_type_Awdd.jdField_a_of_type_Bbqx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
            }
            break;
          case 4: 
          case 5: 
          case 6: 
          case 7: 
            if (localawde.jdField_a_of_type_Awdd.jdField_a_of_type_Asya != null) {
              this.jdField_a_of_type_Long += localawde.jdField_a_of_type_Awdd.jdField_a_of_type_Asya.a();
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
  
  private void a(int paramInt, awdd paramawdd)
  {
    awde localawde = new awde();
    localawde.jdField_a_of_type_Int = -1;
    localawde.jdField_a_of_type_Awdd = paramawdd;
    localawde.b = paramInt;
    localawde.jdField_a_of_type_JavaLangString = awdc.a(paramInt);
    b(localawde);
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
  
  private void a(asya paramasya)
  {
    if (paramasya != null) {
      paramasya.a(paramasya.b(), new awdk(this, paramasya));
    }
  }
  
  private void a(awdd paramawdd, int paramInt)
  {
    if ((paramawdd != null) && (paramawdd.jdField_a_of_type_Ayds != null))
    {
      paramawdd = a(paramawdd.jdField_a_of_type_Ayds.jdField_a_of_type_Aydl);
      awde localawde = a(paramawdd);
      if ((localawde != null) && (!localawde.jdField_a_of_type_Boolean))
      {
        paramInt /= 100;
        localawde.c = paramInt;
        a(paramawdd, localawde);
        c(localawde, paramInt);
      }
    }
  }
  
  private void a(awdd paramawdd, boolean paramBoolean)
  {
    String str;
    awde localawde;
    if ((paramawdd != null) && (paramawdd.jdField_a_of_type_Asya != null))
    {
      str = paramawdd.jdField_a_of_type_Asya.a();
      localawde = a(str);
      if ((localawde == null) || (localawde.jdField_a_of_type_Boolean)) {
        break label97;
      }
      localawde.jdField_a_of_type_Boolean = true;
      localawde.c = 100;
      a(str, localawde);
      if (!paramBoolean) {
        break label188;
      }
    }
    switch (paramawdd.jdField_a_of_type_Int)
    {
    default: 
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("MultiRichMediaSaveManager", 2, "dealFileMultilDownloadComplete fileType= " + paramawdd.jdField_a_of_type_Int);
      return;
    case 4: 
    case 6: 
      label97:
      paramawdd = paramawdd.jdField_a_of_type_Asya.b();
      str = Utils.Crc64String(paramawdd + NetConnInfoCenter.getServerTime());
      localawde.jdField_a_of_type_Int = 0;
      a(paramawdd, str, localawde);
      return;
    }
    a(paramawdd.jdField_a_of_type_Asya);
    return;
    label188:
    if (QLog.isColorLevel()) {
      QLog.d("MultiRichMediaSaveManager", 2, "dealFileMultilDownloadComplete errorType= " + paramawdd.jdField_a_of_type_Int);
    }
    localawde.jdField_a_of_type_Int = -1;
    b(localawde);
  }
  
  private void a(awde paramawde, long paramLong)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4);
    localMessage.obj = paramawde;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  private void a(String paramString1, String paramString2, awde paramawde)
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
        if ((paramawde != null) && (paramawde.jdField_a_of_type_Awdd != null))
        {
          paramawde.jdField_a_of_type_Int = -1;
          paramawde.b = i;
          paramawde.jdField_a_of_type_JavaLangString = awdc.a(i);
          b(paramawde);
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
        ThreadManager.getFileThreadHandler().post(new FileSaveRunnable(new File(paramString1), paramString2, this.jdField_a_of_type_AndroidOsHandler, paramawde, false));
        return;
      }
      i = 0;
    }
  }
  
  private void a(List<awdd> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((awdd)paramList.next());
    }
  }
  
  private boolean a()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        awde localawde = (awde)((Map.Entry)localIterator.next()).getValue();
        if ((localawde == null) || (!localawde.jdField_a_of_type_Boolean)) {
          return false;
        }
      }
    }
    return true;
  }
  
  private void b(awdd paramawdd)
  {
    String str;
    if (paramawdd != null)
    {
      str = "";
      switch (paramawdd.jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      a(str);
      return;
      if (paramawdd.jdField_a_of_type_Ayds != null)
      {
        str = a(paramawdd.jdField_a_of_type_Ayds.jdField_a_of_type_Aydl);
        continue;
        if (paramawdd.jdField_a_of_type_Bbqx != null)
        {
          str = a(paramawdd.jdField_a_of_type_Bbqx.jdField_a_of_type_Bbqh);
          continue;
          if (paramawdd.jdField_a_of_type_Asya != null) {
            str = paramawdd.jdField_a_of_type_Asya.a();
          }
        }
      }
    }
  }
  
  private void b(awdd paramawdd, int paramInt1, int paramInt2, String paramString)
  {
    awde localawde;
    if ((paramawdd != null) && (paramawdd.jdField_a_of_type_Ayds != null) && (paramawdd.jdField_a_of_type_Ayds.jdField_a_of_type_Aydl != null))
    {
      String str = a(paramawdd.jdField_a_of_type_Ayds.jdField_a_of_type_Aydl);
      localawde = a(str);
      if ((localawde != null) && (localawde.jdField_a_of_type_Awdd != null) && (!localawde.jdField_a_of_type_Boolean))
      {
        localawde.jdField_a_of_type_Boolean = true;
        localawde.jdField_a_of_type_Int = paramInt1;
        localawde.c = 100;
        a(str, localawde);
        if (paramInt1 != 0) {
          break label136;
        }
        paramawdd = paramawdd.jdField_a_of_type_Ayds.jdField_a_of_type_Aydl.c();
        a(paramawdd, Utils.Crc64String(paramawdd + NetConnInfoCenter.getServerTime()), localawde);
      }
    }
    return;
    label136:
    localawde.b = paramInt2;
    localawde.jdField_a_of_type_JavaLangString = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("MultiRichMediaSaveManager", 2, "dealPicDownloadComplete errorCode= " + paramInt2 + ", errorDec= " + paramString);
    }
    b(localawde);
  }
  
  private void b(awde paramawde)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
    localMessage.obj = paramawde;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void b(awde paramawde, int paramInt)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(6);
    localMessage.obj = paramawde;
    localMessage.arg1 = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void b(String paramString1, String paramString2, awde paramawde)
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
        if ((paramawde != null) && (paramawde.jdField_a_of_type_Awdd != null))
        {
          paramawde.jdField_a_of_type_Int = -1;
          paramawde.b = i;
          paramawde.jdField_a_of_type_JavaLangString = awdc.a(i);
          b(paramawde);
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
          ThreadManager.getFileThreadHandler().post(new FileSaveRunnable(new File(paramString1), paramString2, this.jdField_a_of_type_AndroidOsHandler, paramawde, false));
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
        awde localawde = (awde)((Map.Entry)localIterator.next()).getValue();
        if ((localawde != null) && (localawde.d == 1) && (!localawde.jdField_a_of_type_Boolean)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean b(awdd paramawdd)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramawdd == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload fileSaveReq is empty!");
      }
      return false;
    }
    switch (paramawdd.jdField_a_of_type_Int)
    {
    default: 
      bool2 = bool1;
      label74:
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      if ((paramawdd.jdField_a_of_type_Ayds == null) || (paramawdd.jdField_a_of_type_Ayds.jdField_a_of_type_Aydl == null) || (paramawdd.jdField_a_of_type_Ayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload picReq is empty!");
        return false;
      }
      if ((paramawdd.jdField_a_of_type_Ayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) && (paramawdd.jdField_a_of_type_Ayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.fileSizeFlag == 1)) {
        break;
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(TransFileController.makeReceiveKey(paramawdd.jdField_a_of_type_Ayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.md5, paramawdd.jdField_a_of_type_Ayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uuid, 1));
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
      ((BaseDownloadProcessor)localObject).addDownCallback(new awdo(this, paramawdd));
      continue;
      if ((paramawdd.jdField_a_of_type_Bbqx == null) || (paramawdd.jdField_a_of_type_Bbqx.jdField_a_of_type_Bbqh == null))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload shortVideoReq is empty!");
        return false;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(paramawdd.jdField_a_of_type_Bbqx.jdField_a_of_type_Bbqh.c, paramawdd.jdField_a_of_type_Bbqx.jdField_a_of_type_Bbqh.jdField_a_of_type_Long);
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
      ((BaseDownloadProcessor)localObject).addDownCallback(new awdp(this, paramawdd));
      bool1 = false;
      continue;
      bool1 = false;
      continue;
      bool2 = bool1;
      if (paramawdd.jdField_a_of_type_Asya == null) {
        break label74;
      }
      bool2 = paramawdd.jdField_a_of_type_Asya.b();
      bool1 = bool2;
      if (bool2)
      {
        paramawdd.jdField_a_of_type_Asya.a(new awdq(this, paramawdd));
        bool1 = bool2;
        if (this.jdField_a_of_type_Asfv != null)
        {
          this.jdField_a_of_type_Asfv.a(paramawdd.jdField_a_of_type_Asya.a());
          bool1 = bool2;
        }
      }
    }
  }
  
  private void c(awdd paramawdd)
  {
    if (paramawdd == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "downloadFile fileSaveReq is empty!");
      }
      a(10007, new awdd());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadFile fileType = " + paramawdd.jdField_a_of_type_Int);
    }
    String str;
    switch (paramawdd.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      if (paramawdd.jdField_a_of_type_Ayds != null)
      {
        str = a(paramawdd.jdField_a_of_type_Ayds.jdField_a_of_type_Aydl);
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "downloadPic key = " + str);
        }
        paramawdd.jdField_a_of_type_Ayds.a(new awdr(this, str, paramawdd));
        aydj.a(paramawdd.jdField_a_of_type_Ayds, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
      a(10007, paramawdd);
      return;
    case 2: 
      if (paramawdd.jdField_a_of_type_Bbqx != null)
      {
        str = a(paramawdd.jdField_a_of_type_Bbqx.jdField_a_of_type_Bbqh);
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "downloadShortVideo key = " + str);
        }
        paramawdd.jdField_a_of_type_Bbqx.a(new awds(this, str, paramawdd));
        bbqf.a(paramawdd.jdField_a_of_type_Bbqx, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
      a(10007, paramawdd);
      return;
    case 3: 
      if (paramawdd.jdField_a_of_type_Bbqx != null)
      {
        str = a(paramawdd.jdField_a_of_type_Bbqx.jdField_a_of_type_Bbqh);
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "downloadVideo key = " + str);
        }
        paramawdd.jdField_a_of_type_Bbqx.jdField_a_of_type_Boolean = true;
        paramawdd.jdField_a_of_type_Bbqx.jdField_a_of_type_Bbqw = new awdt(this, paramawdd, str);
        ((bbqr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(95)).a(paramawdd);
        return;
      }
      a(10007, paramawdd);
      return;
    }
    if (paramawdd.jdField_a_of_type_Asya != null)
    {
      str = paramawdd.jdField_a_of_type_Asya.a();
      if (QLog.isColorLevel()) {
        QLog.i("MultiRichMediaSaveManager", 2, "downloadFile key = " + str);
      }
      paramawdd.jdField_a_of_type_Asya.a(new awdu(this, str, paramawdd));
      if (this.jdField_a_of_type_Asfv != null) {
        this.jdField_a_of_type_Asfv.a(paramawdd.jdField_a_of_type_Asya.a());
      }
      paramawdd.jdField_a_of_type_Asya.a();
      return;
    }
    a(10007, paramawdd);
  }
  
  private void c(awde paramawde)
  {
    HashMap localHashMap;
    if (paramawde != null)
    {
      localHashMap = new HashMap();
      if (paramawde.d != 1) {
        break label70;
      }
      localHashMap.put("isMultiSave", "1");
      if (paramawde.jdField_a_of_type_Int != 0) {
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
      localHashMap.put("errorCode", String.valueOf(paramawde.b));
      localHashMap.put("isSuccess", paramawde.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void c(awde paramawde, int paramInt)
  {
    if (paramawde != null)
    {
      paramawde.c = paramInt;
      d(paramawde, paramInt);
    }
  }
  
  private void d(awdd paramawdd)
  {
    if (paramawdd != null) {}
    switch (paramawdd.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      b(paramawdd, 0, 0, "");
      return;
    case 2: 
    case 3: 
      a(paramawdd, 0, 0, "");
      return;
    }
    a(paramawdd, true);
  }
  
  private void d(awde paramawde)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "notifySingleComplete");
    }
    if (paramawde != null)
    {
      a(paramawde);
      if ((paramawde.jdField_a_of_type_Awdv != null) && (this.jdField_a_of_type_Ahas != null)) {
        this.jdField_a_of_type_Ahas.a(paramawde.jdField_a_of_type_Awdv.jdField_a_of_type_Long, paramawde.jdField_a_of_type_Awdv.jdField_a_of_type_Int, paramawde.jdField_a_of_type_Awdv.b, paramawde.jdField_a_of_type_Awdv.c, paramawde.jdField_a_of_type_Awdv.jdField_a_of_type_JavaLangString, paramawde.jdField_a_of_type_Awdv.jdField_a_of_type_Boolean);
      }
    }
  }
  
  private void d(awde paramawde, int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    long l = 0L;
    if (localIterator.hasNext())
    {
      awde localawde = (awde)((Map.Entry)localIterator.next()).getValue();
      if ((localawde != null) && (localawde.jdField_a_of_type_Awdd != null)) {
        switch (localawde.jdField_a_of_type_Awdd.jdField_a_of_type_Int)
        {
        }
      }
      for (;;)
      {
        break;
        if ((localawde.jdField_a_of_type_Awdd.jdField_a_of_type_Ayds != null) && (localawde.jdField_a_of_type_Awdd.jdField_a_of_type_Ayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)) {
          if (localawde.jdField_a_of_type_Boolean)
          {
            l += localawde.jdField_a_of_type_Awdd.jdField_a_of_type_Ayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
          }
          else
          {
            float f1 = (float)l;
            float f2 = (float)localawde.jdField_a_of_type_Awdd.jdField_a_of_type_Ayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
            l = (localawde.c / 100.0F * f2 + f1);
            continue;
            if ((localawde.jdField_a_of_type_Awdd.jdField_a_of_type_Bbqx != null) && (localawde.jdField_a_of_type_Awdd.jdField_a_of_type_Bbqx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
              if (localawde.jdField_a_of_type_Boolean)
              {
                l += localawde.jdField_a_of_type_Awdd.jdField_a_of_type_Bbqx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
              }
              else
              {
                f1 = (float)l;
                f2 = localawde.jdField_a_of_type_Awdd.jdField_a_of_type_Bbqx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
                l = (localawde.c / 100.0F * f2 + f1);
                continue;
                if (localawde.jdField_a_of_type_Awdd.jdField_a_of_type_Asya != null) {
                  if (localawde.jdField_a_of_type_Boolean)
                  {
                    l += localawde.jdField_a_of_type_Awdd.jdField_a_of_type_Asya.a();
                  }
                  else
                  {
                    f1 = (float)l;
                    f2 = (float)localawde.jdField_a_of_type_Awdd.jdField_a_of_type_Asya.a();
                    l = (localawde.c / 100.0F * f2 + f1);
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
      paramawde.d = 0;
      b(paramawde, paramInt);
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
    if (this.jdField_a_of_type_Awdg != null) {
      this.jdField_a_of_type_Awdg.a();
    }
  }
  
  private void e(awdd paramawdd)
  {
    if (paramawdd != null)
    {
      paramawdd = paramawdd.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (paramawdd.hasNext()) {
        ((awdh)paramawdd.next()).a();
      }
    }
  }
  
  private void e(awde paramawde)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(5);
    localMessage.obj = paramawde;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "saveCancel");
    }
    if (this.jdField_a_of_type_Awdg != null) {
      this.jdField_a_of_type_Awdg.b();
    }
    this.c = false;
    this.jdField_a_of_type_Long = 0L;
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "saveTips");
    }
    if (this.jdField_a_of_type_Awdg != null) {
      this.jdField_a_of_type_Awdg.c();
    }
  }
  
  private void h()
  {
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      awde localawde = (awde)localEntry.getValue();
      if ((localawde != null) && (localawde.jdField_a_of_type_Awdd != null) && (localawde.d == 1))
      {
        Iterator localIterator2 = localawde.jdField_a_of_type_Awdd.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        while (localIterator2.hasNext()) {
          ((awdh)localIterator2.next()).a();
        }
        localawde.d = 0;
        a((String)localEntry.getKey(), localawde);
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
    awde localawde;
    IHttpCommunicatorListener localIHttpCommunicatorListener;
    while (localIterator.hasNext())
    {
      localawde = (awde)((Map.Entry)localIterator.next()).getValue();
      if ((localawde != null) && (localawde.jdField_a_of_type_Awdd != null)) {
        switch (localawde.jdField_a_of_type_Awdd.jdField_a_of_type_Int)
        {
        default: 
          break;
        case 1: 
          if ((localawde.jdField_a_of_type_Awdd.jdField_a_of_type_Ayds != null) && (localawde.jdField_a_of_type_Awdd.jdField_a_of_type_Ayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null))
          {
            localIHttpCommunicatorListener = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(TransFileController.makeReceiveKey(localawde.jdField_a_of_type_Awdd.jdField_a_of_type_Ayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.md5, localawde.jdField_a_of_type_Awdd.jdField_a_of_type_Ayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uuid, 131075));
            if (localIHttpCommunicatorListener != null) {
              break label406;
            }
            localIHttpCommunicatorListener = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(TransFileController.makeReceiveKey(localawde.jdField_a_of_type_Awdd.jdField_a_of_type_Ayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.md5, localawde.jdField_a_of_type_Awdd.jdField_a_of_type_Ayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uuid, 1));
          }
          break;
        }
      }
    }
    label406:
    for (;;)
    {
      if (!(localIHttpCommunicatorListener instanceof BaseDownloadProcessor)) {
        break label39;
      }
      ((BaseDownloadProcessor)localIHttpCommunicatorListener).cancel();
      break label39;
      if ((localawde.jdField_a_of_type_Awdd.jdField_a_of_type_Bbqx != null) && (localawde.jdField_a_of_type_Awdd.jdField_a_of_type_Bbqx.jdField_a_of_type_Bbqh != null)) {}
      localIHttpCommunicatorListener = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(localawde.jdField_a_of_type_Awdd.jdField_a_of_type_Bbqx.jdField_a_of_type_Bbqh.c, localawde.jdField_a_of_type_Awdd.jdField_a_of_type_Bbqx.jdField_a_of_type_Bbqh.jdField_a_of_type_Long);
      if (!(localIHttpCommunicatorListener instanceof BaseDownloadProcessor)) {
        break label39;
      }
      ((BaseDownloadProcessor)localIHttpCommunicatorListener).cancel();
      break label39;
      if ((localawde.jdField_a_of_type_Awdd.jdField_a_of_type_Bbqx == null) || (localawde.jdField_a_of_type_Awdd.jdField_a_of_type_Bbqx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
        break label39;
      }
      ((bbqr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(95)).b(localawde.jdField_a_of_type_Awdd);
      break label39;
      if (localawde.jdField_a_of_type_Awdd.jdField_a_of_type_Asya == null) {
        break label39;
      }
      localawde.jdField_a_of_type_Awdd.jdField_a_of_type_Asya.b();
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
        awde localawde = (awde)((Map.Entry)localIterator.next()).getValue();
        if ((localawde != null) && (localawde.jdField_a_of_type_Awdd != null)) {
          localawde.jdField_a_of_type_Awdd.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
        }
      }
    }
  }
  
  public awde a(String paramString)
  {
    return (awde)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public String a(aydl paramaydl)
  {
    if (paramaydl != null) {
      return paramaydl.c + paramaydl.jdField_a_of_type_Long;
    }
    return "";
  }
  
  public String a(bbqh parambbqh)
  {
    if (parambbqh != null) {
      return parambbqh.c + parambbqh.jdField_a_of_type_Long;
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
  
  public void a(ahas paramahas)
  {
    this.jdField_a_of_type_Ahas = paramahas;
  }
  
  public void a(Activity paramActivity, List<awdd> paramList)
  {
    a(paramActivity, bfur.a(paramActivity, 230, paramActivity.getString(2131717778), paramActivity.getString(2131717777), new awdj(this, paramList), new awdn(this)));
  }
  
  public void a(awdd paramawdd)
  {
    if (paramawdd != null) {
      switch (paramawdd.jdField_a_of_type_Int)
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
            } while (paramawdd.jdField_a_of_type_Ayds == null);
            localawde = new awde();
            localawde.jdField_a_of_type_Awdd = paramawdd;
            paramawdd = a(paramawdd.jdField_a_of_type_Ayds.jdField_a_of_type_Aydl);
          } while (TextUtils.isEmpty(paramawdd));
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramawdd, localawde);
          return;
        } while (paramawdd.jdField_a_of_type_Bbqx == null);
        localawde = new awde();
        localawde.jdField_a_of_type_Awdd = paramawdd;
        paramawdd = a(paramawdd.jdField_a_of_type_Bbqx.jdField_a_of_type_Bbqh);
      } while (TextUtils.isEmpty(paramawdd));
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramawdd, localawde);
      return;
      if (this.jdField_a_of_type_Asfv == null)
      {
        this.jdField_a_of_type_Asfv = new asfv(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_Asfv.a();
      }
    } while (paramawdd.jdField_a_of_type_Asya == null);
    awde localawde = new awde();
    localawde.jdField_a_of_type_Awdd = paramawdd;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramawdd.jdField_a_of_type_Asya.a(), localawde);
  }
  
  public void a(awdd paramawdd, int paramInt1, int paramInt2, String paramString)
  {
    awde localawde;
    if ((paramawdd != null) && (paramawdd.jdField_a_of_type_Bbqx != null) && (paramawdd.jdField_a_of_type_Bbqx.jdField_a_of_type_Bbqh != null))
    {
      String str = a(paramawdd.jdField_a_of_type_Bbqx.jdField_a_of_type_Bbqh);
      localawde = a(str);
      if ((localawde != null) && (localawde.jdField_a_of_type_Awdd != null) && (!localawde.jdField_a_of_type_Boolean))
      {
        localawde.jdField_a_of_type_Boolean = true;
        localawde.jdField_a_of_type_Int = paramInt1;
        localawde.c = 100;
        a(str, localawde);
        if (paramInt1 != 0) {
          break label196;
        }
        paramawdd = new File(paramawdd.jdField_a_of_type_Bbqx.jdField_a_of_type_Bbqh.h);
        if ((!paramawdd.exists()) && (QLog.isColorLevel())) {
          QLog.d("MultiRichMediaSaveManager", 2, "dealShortVideoDownloadComplete srcFile not exists");
        }
        b(paramawdd.getAbsolutePath(), new StringBuilder().append(paramawdd.getParentFile().getName()).append(NetConnInfoCenter.getServerTime()).toString().toLowerCase(Locale.US) + ".mp4", localawde);
      }
    }
    return;
    label196:
    localawde.b = paramInt2;
    localawde.jdField_a_of_type_JavaLangString = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("MultiRichMediaSaveManager", 2, "dealShortVideoDownloadComplete errorCode= " + paramInt2 + ", errorDec= " + paramString);
    }
    b(localawde);
  }
  
  public void a(awde paramawde)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "saveComplete");
    }
    if (paramawde != null)
    {
      if (paramawde.d == 1)
      {
        if (paramawde.jdField_a_of_type_Awdd != null)
        {
          Iterator localIterator = paramawde.jdField_a_of_type_Awdd.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          while (localIterator.hasNext())
          {
            awdh localawdh = (awdh)localIterator.next();
            if (paramawde.jdField_a_of_type_Int == 0) {
              localawdh.a(paramawde, 100);
            }
            localawdh.a(paramawde);
          }
        }
        b(paramawde.jdField_a_of_type_Awdd);
        c(paramawde);
      }
    }
    else {
      return;
    }
    if (this.jdField_a_of_type_Awdg != null) {
      this.jdField_a_of_type_Awdg.a(paramawde);
    }
    this.c = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    c(paramawde);
  }
  
  public void a(awde paramawde, int paramInt)
  {
    if (paramawde != null) {
      if (paramawde.d == 1)
      {
        if (paramawde.jdField_a_of_type_Awdd != null)
        {
          Iterator localIterator = paramawde.jdField_a_of_type_Awdd.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          while (localIterator.hasNext()) {
            ((awdh)localIterator.next()).a(paramawde, paramInt);
          }
        }
      }
      else if (this.jdField_a_of_type_Awdg != null) {
        this.jdField_a_of_type_Awdg.a(paramawde, paramInt);
      }
    }
  }
  
  public void a(awdg paramawdg)
  {
    this.jdField_a_of_type_Awdg = paramawdg;
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
        ayds localayds = aydj.a(7, 1);
        localayds.a(paramMessageForPic, paramMessageForPic.getPicDownloadInfo());
        String str1 = AbsDownloader.getFilePath(URLDrawableHelper.getURL(paramMessageForPic, 131075, null).toString().toString());
        long l = paramMessageForPic.size;
        String str2 = a(paramMessageForPic.getPicDownloadInfo());
        if (a(str2) == null)
        {
          awde localawde = new awde();
          localawde.jdField_a_of_type_Awdd = awdd.a(paramMessageForPic);
          localawde.d = 1;
          a(str2, localawde);
        }
        localayds.a(new awdl(this, paramLong, paramInt1, paramInt2, l, str2, str1));
        aydj.a(localayds, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    awdd localawdd;
    do
    {
      for (;;)
      {
        return;
        try
        {
          localawdd = awdd.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForShortVideo);
          if ((localawdd != null) && (localawdd.jdField_a_of_type_Bbqx != null))
          {
            paramMessageForShortVideo = a(paramMessageForShortVideo.getDownloadInfo(paramMessageForShortVideo.busiType));
            if (a(paramMessageForShortVideo) == null)
            {
              awde localawde = new awde();
              localawde.jdField_a_of_type_Awdd = localawdd;
              localawde.d = 1;
              a(paramMessageForShortVideo, localawde);
            }
            if ((!a(localawdd)) || (localawdd.jdField_a_of_type_Bbqx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (this.jdField_a_of_type_Ahas == null)) {
              break label244;
            }
            paramMessageForShortVideo = ShortVideoUtils.getShortVideoSavePath(localawdd.jdField_a_of_type_Bbqx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
            this.jdField_a_of_type_Ahas.a(paramLong, paramInt1, paramInt2, 1, paramMessageForShortVideo, false);
            return;
          }
        }
        catch (Exception paramMessageForShortVideo) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("MultiRichMediaSaveManager", 2, "dealSaveVideo exception: " + paramMessageForShortVideo.getMessage());
    return;
    label244:
    localawdd.jdField_a_of_type_Bbqx.jdField_a_of_type_Boolean = true;
    localawdd.jdField_a_of_type_Bbqx.jdField_a_of_type_Bbqw = new awdm(this, paramLong, localawdd, paramMessageForShortVideo, paramInt1, paramInt2);
    ((bbqr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(95)).a(localawdd);
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
  
  public void a(String paramString, awde paramawde)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramawde);
    }
  }
  
  public void a(List<awdd> paramList, int paramInt1, int paramInt2)
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
          switch (((awdd)paramList.next()).jdField_a_of_type_Int)
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
        bcef.b(null, "dc00898", "", "", str, str, paramInt2, 0, String.valueOf(paramInt1), String.valueOf(i), String.valueOf(j), String.valueOf(k));
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
  
  public void a(List<awdd> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "saveMultiRichMedialFile fileSaveReqList is empty!");
      }
      paramList = new awde();
      paramList.jdField_a_of_type_Int = -1;
      paramList.b = 10006;
      paramList.jdField_a_of_type_JavaLangString = awdc.a(10006);
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
        awdd localawdd = (awdd)paramList.next();
        if (a(localawdd)) {
          d(localawdd);
        } else if (!b(localawdd)) {
          c(localawdd);
        }
      }
    }
  }
  
  public boolean a(awdd paramawdd)
  {
    boolean bool2 = true;
    if (paramawdd == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFileExist fileSaveReq is empty!");
      }
    }
    do
    {
      return false;
      switch (paramawdd.jdField_a_of_type_Int)
      {
      default: 
        return false;
      }
    } while ((paramawdd.jdField_a_of_type_Ayds == null) || (paramawdd.jdField_a_of_type_Ayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null));
    Object localObject = paramawdd.jdField_a_of_type_Ayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.getPicDownloadInfo();
    if (localObject != null)
    {
      localObject = ((aydl)localObject).c();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new File((String)localObject);
        if ((((File)localObject).exists()) && (((File)localObject).length() == paramawdd.jdField_a_of_type_Ayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size))
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
      if (paramawdd.jdField_a_of_type_Bbqx == null) {
        break;
      }
      localObject = ShortVideoUtils.getShortVideoSavePath(paramawdd.jdField_a_of_type_Bbqx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
      if (localObject == null) {
        break;
      }
      localObject = new File((String)localObject);
      if ((!((File)localObject).exists()) || (paramawdd.jdField_a_of_type_Bbqx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (((File)localObject).length() != paramawdd.jdField_a_of_type_Bbqx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFileExist shortVideo exists");
      }
      return true;
      if (paramawdd.jdField_a_of_type_Asya == null) {
        break;
      }
      return paramawdd.jdField_a_of_type_Asya.a();
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
  
  public boolean a(List<awdd> paramList)
  {
    if ((!AppNetConnInfo.isWifiConn()) && (paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      long l = 0L;
      while (paramList.hasNext())
      {
        awdd localawdd = (awdd)paramList.next();
        if (!a(localawdd))
        {
          switch (localawdd.jdField_a_of_type_Int)
          {
          }
          for (;;)
          {
            break;
            if ((localawdd.jdField_a_of_type_Ayds != null) && (localawdd.jdField_a_of_type_Ayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null))
            {
              l += localawdd.jdField_a_of_type_Ayds.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size;
              continue;
              if ((localawdd.jdField_a_of_type_Bbqx != null) && (localawdd.jdField_a_of_type_Bbqx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
              {
                l += localawdd.jdField_a_of_type_Bbqx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
                continue;
                if (localawdd.jdField_a_of_type_Asya != null) {
                  l += localawdd.jdField_a_of_type_Asya.a();
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
    this.jdField_a_of_type_Awdg = null;
  }
  
  public void b(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "cancelSavePic id = " + paramLong);
    }
    paramMessageForPic = a(paramMessageForPic);
    awde localawde = a(paramMessageForPic);
    if (localawde != null)
    {
      localawde.jdField_a_of_type_Boolean = true;
      localawde.jdField_a_of_type_Int = -1;
      a(paramMessageForPic, localawde);
      e(localawde);
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
    awde localawde = a(str);
    if (localawde != null)
    {
      localawde.jdField_a_of_type_Boolean = true;
      localawde.jdField_a_of_type_Int = -1;
      a(str, localawde);
      e(localawde);
    }
    ((bbqr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(95)).b(awdd.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForShortVideo));
    a(str);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Ahas = null;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "clearFileSaveRequest");
    }
    j();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_Awdg = null;
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    this.c = false;
    this.jdField_a_of_type_Long = 0L;
    if (this.jdField_a_of_type_Asfv != null)
    {
      this.jdField_a_of_type_Asfv.b();
      this.jdField_a_of_type_Asfv = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    awde localawde;
    if ((paramMessage.obj instanceof awde))
    {
      localawde = (awde)paramMessage.obj;
      if (localawde.jdField_a_of_type_Awdd == null) {}
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
          a(localawde, paramMessage.arg1);
          return true;
        } while (localawde.d != 1);
        e(localawde.jdField_a_of_type_Awdd);
        return true;
        if (localawde.d == 1)
        {
          d(localawde);
          return true;
        }
        if (paramMessage.what == 2)
        {
          this.jdField_a_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            QLog.i("MultiRichMediaSaveManager", 2, "MSG_TYPE_SAVE_FAIL errorCode = " + localawde.b + ", errorMsg = " + localawde.jdField_a_of_type_JavaLangString);
          }
        }
        for (;;)
        {
          paramMessage = localawde.jdField_a_of_type_Awdd.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          while (paramMessage.hasNext()) {
            ((awdh)paramMessage.next()).a(localawde);
          }
          this.b = true;
        }
      } while (!a());
      b(localawde, 100);
      if ((this.b) && (!this.jdField_a_of_type_Boolean)) {
        localawde.jdField_a_of_type_Int = 0;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MultiRichMediaSaveManager", 2, "last result = " + localawde.jdField_a_of_type_Int);
        }
        this.jdField_a_of_type_Boolean = false;
        this.b = false;
        if (this.jdField_a_of_type_Asfv != null)
        {
          this.jdField_a_of_type_Asfv.b();
          this.jdField_a_of_type_Asfv = null;
        }
        a(localawde, 200L);
        return true;
        if ((this.jdField_a_of_type_Boolean) && (!this.b)) {
          localawde.jdField_a_of_type_Int = -1;
        } else {
          localawde.jdField_a_of_type_Int = 3;
        }
      }
    case 3: 
      paramMessage = localawde.jdField_a_of_type_Awdd.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (paramMessage.hasNext()) {
        ((awdh)paramMessage.next()).b(localawde);
      }
    }
    a(localawde);
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
 * Qualified Name:     awdi
 * JD-Core Version:    0.7.0.1
 */