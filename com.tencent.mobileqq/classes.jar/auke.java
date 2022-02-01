import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.identification.IdentificationIpcServer.1;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.OldHttpEngine;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.download.AEResInfo;
import eipc.EIPCResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

public class auke
  extends QIPCModule
{
  private static volatile auke jdField_a_of_type_Auke;
  private static final List<String> jdField_a_of_type_JavaUtilList = Arrays.asList(new String[] { "setFaceData", "identify", "deleteFace", "changeSecureMobile" });
  private int jdField_a_of_type_Int;
  private ConfigManager jdField_a_of_type_ComTencentMobileqqHighwayConfigConfigManager;
  private OldHttpEngine jdField_a_of_type_ComTencentMobileqqTransfileOldHttpEngine;
  private String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private boolean c = true;
  
  private auke(String paramString)
  {
    super(paramString);
  }
  
  public static auke a()
  {
    if (jdField_a_of_type_Auke == null) {}
    try
    {
      if (jdField_a_of_type_Auke == null) {
        jdField_a_of_type_Auke = new auke("IdentificationIpcServer_Model");
      }
      return jdField_a_of_type_Auke;
    }
    finally {}
  }
  
  private ITransactionCallback a(File paramFile, EIPCResult paramEIPCResult, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, int paramInt3)
  {
    return new aukh(this, paramFile, paramEIPCResult, paramQQAppInterface, paramInt2, paramInt3, paramInt1);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHighwayConfigConfigManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqHighwayConfigConfigManager.onDestroy();
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        this.c &= paramBoolean;
        if (paramInt == 2)
        {
          this.jdField_b_of_type_Boolean = true;
          if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
          {
            EIPCResult localEIPCResult = new EIPCResult();
            if (!this.c) {
              break label147;
            }
            paramInt = i;
            localEIPCResult.code = paramInt;
            callbackResult(this.jdField_b_of_type_Int, localEIPCResult);
            this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
            QLog.d("qqidentification_server", 1, "downloadFinish download result = " + this.c);
          }
          return;
        }
        if (paramInt == 1)
        {
          this.jdField_a_of_type_Boolean = true;
          continue;
        }
        this.c = false;
      }
      finally {}
      QLog.d("qqidentification_server", 1, "unknown download type");
      continue;
      label147:
      paramInt = 1;
    }
  }
  
  private void a(Bundle paramBundle)
  {
    QLog.d("qqidentification_server", 1, "start upload file");
    EIPCResult localEIPCResult = new EIPCResult();
    Bundle localBundle = new Bundle();
    localEIPCResult.data = localBundle;
    Object localObject1 = paramBundle.getString("filePath", null);
    File localFile;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localFile = new File((String)localObject1);
      if (localFile.exists()) {}
    }
    else
    {
      QLog.e("qqidentification_server", 1, "invalid path");
      localEIPCResult.code = -102;
      localBundle.putString("subError", "no file");
      localBundle.putBoolean("reset_null", true);
      callbackResult(this.jdField_a_of_type_Int, localEIPCResult);
      return;
    }
    byte[] arrayOfByte = paramBundle.getByteArray("md5");
    if (arrayOfByte == null)
    {
      QLog.e("qqidentification_server", 1, "md5 is null");
      localEIPCResult.code = -102;
      localBundle.putString("subError", "no md5");
      localBundle.putBoolean("reset_null", true);
      callbackResult(this.jdField_a_of_type_Int, localEIPCResult);
      return;
    }
    int i = paramBundle.getInt("serviceType", -1);
    Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    int j = paramBundle.getInt("srcAppId", 0);
    int k = paramBundle.getInt("key_identification_type", 2);
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("method", null);
    bcef.b((QQAppInterface)localObject2, "dc00898", "", "", "0X80097EB", "0X80097EB", 0, 0, i + "", "" + k, j + "", "");
    if ((this.jdField_a_of_type_JavaLangString == null) || (jdField_a_of_type_JavaUtilList.contains(this.jdField_a_of_type_JavaLangString))) {}
    String str1;
    String str2;
    for (localObject1 = new Transaction(((QQAppInterface)localObject2).getCurrentAccountUin(), 61, (String)localObject1, 0, arrayOfByte, a(localFile, localEIPCResult, (QQAppInterface)localObject2, j, i, k), null, false);; localObject1 = new Transaction(str1, 61, (String)localObject1, 0, Base64.decode(str2, 11), arrayOfByte, a(localFile, localEIPCResult, (QQAppInterface)localObject2, j, i, k)))
    {
      localObject2 = ((QQAppInterface)localObject2).getHwEngine();
      if (aujs.c.contains(this.jdField_a_of_type_JavaLangString))
      {
        ((HwEngine)localObject2).currentUin = paramBundle.getString("uin", "");
        this.jdField_a_of_type_ComTencentMobileqqHighwayConfigConfigManager = ConfigManager.getInstance(BaseApplicationImpl.getContext(), (HwEngine)localObject2);
      }
      i = ((HwEngine)localObject2).submitTransactionTask((Transaction)localObject1);
      if (i == 0) {
        break;
      }
      QLog.e("qqidentification_server", 1, "submit error: " + i);
      localEIPCResult.code = -102;
      localBundle.putBoolean("reset_null", true);
      localBundle.putString("subError", "UPLOAD submitTransaction retCode=" + i);
      callbackResult(this.jdField_a_of_type_Int, localEIPCResult);
      return;
      str1 = paramBundle.getString("uin", "");
      str2 = paramBundle.getString("ticket", "");
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2))) {
        QLog.i("qqidentification_server", 1, "uin or ticket is null");
      }
    }
  }
  
  private void a(Bundle paramBundle, int paramInt)
  {
    if (paramBundle == null)
    {
      QLog.d("qqidentification_server", 1, " params = null");
      return;
    }
    int i = paramBundle.getInt("srcAppId", 0);
    String str1 = paramBundle.getString("key", "");
    String str2 = paramBundle.getString("lightInfo", null);
    String str3 = paramBundle.getString("method", null);
    String str4 = paramBundle.getString("uin", null);
    long l = paramBundle.getLong("nonce", -1L);
    if ((i == 0) || (TextUtils.isEmpty(str1)))
    {
      QLog.d("qqidentification_server", 1, " KEY_APP_ID not exist or temKey is empty");
      return;
    }
    if ((aujs.c.contains(str3)) && (TextUtils.isEmpty(str4)))
    {
      QLog.d("qqidentification_server", 1, "method is loginVerify but uin is empty");
      return;
    }
    paramBundle = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    FaceDetectForThirdPartyManager localFaceDetectForThirdPartyManager = (FaceDetectForThirdPartyManager)paramBundle.getManager(301);
    autp.a(paramBundle, str3, str4, i, AppSetting.a(), str2, str1, l, new aukg(this, localFaceDetectForThirdPartyManager, paramInt, paramBundle));
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    blvn localblvn = blvn.a();
    aukj localaukj = new aukj(this);
    if (paramQQAppInterface.isLogin())
    {
      localblvn.a(AEResInfo.AE_RES_BASE_PACKAGE, localaukj, false);
      return;
    }
    localblvn.a(AEResInfo.AE_RES_BASE_PACKAGE, localaukj);
  }
  
  private void a(QQAppInterface paramQQAppInterface, Bundle paramBundle, int paramInt)
  {
    String str = paramBundle.getString("method", null);
    int i = paramBundle.getInt("srcAppId");
    paramBundle = paramBundle.getString("uin");
    aujs.a().a(paramQQAppInterface, BaseApplicationImpl.getContext(), i, str, paramBundle, new aukf(this, paramInt));
  }
  
  private void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    String str = paramString3 + "identification.zip";
    paramString2 = new auki(this, paramString2, paramString3, paramString1, paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileOldHttpEngine == null)
    {
      paramQQAppInterface = new HttpCommunicator(paramQQAppInterface, 4);
      paramQQAppInterface.start();
      this.jdField_a_of_type_ComTencentMobileqqTransfileOldHttpEngine = new OldHttpEngine(paramQQAppInterface, false);
    }
    paramQQAppInterface = new HttpNetReq();
    paramQQAppInterface.mCallback = paramString2;
    paramQQAppInterface.mHttpMethod = 0;
    paramQQAppInterface.mReqUrl = paramString1;
    paramQQAppInterface.mOutPath = str;
    paramQQAppInterface.mPrioty = 0;
    this.jdField_a_of_type_ComTencentMobileqqTransfileOldHttpEngine.sendReq(paramQQAppInterface);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      QLog.d("qqidentification_server", 1, "identification res downloading,repeat request... ");
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.c = true;
    FileUtils.deleteFilesInDirectory(paramString3);
    a(paramQQAppInterface);
    b(paramQQAppInterface, paramString1, paramString2, paramString3, paramInt);
  }
  
  public boolean a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject1 = ShortVideoResourceManager.a();
    QLog.d("qqidentification_server", 1, "config content....." + (String)localObject1);
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      Object localObject2 = new ArrayList();
      QLog.d("qqidentification_server", 1, new Object[] { "configContent is not empty, parseConfig result is ", Integer.valueOf(ShortVideoResourceManager.a((String)localObject1, (List)localObject2)) });
      if (((List)localObject2).size() > 0)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = (ShortVideoResourceManager.SVConfigItem)((Iterator)localObject2).next();
          if (((ShortVideoResourceManager.SVConfigItem)localObject1).name.startsWith("new_qq_android_native_short_new_other_"))
          {
            localObject2 = localQQAppInterface.getApplication().getFilesDir().getAbsolutePath() + "/YT_identify_new/";
            String str1 = ((ShortVideoResourceManager.SVConfigItem)localObject1).armv7a_url;
            String str2 = ((ShortVideoResourceManager.SVConfigItem)localObject1).armv7a_md5;
            int i = ((ShortVideoResourceManager.SVConfigItem)localObject1).versionCode;
            QLog.d("qqidentification_server", 1, new Object[] { "no res,start download, localpath is", localObject2, " version is : ", Integer.valueOf(i), " app so bits is : ", Integer.valueOf(aukc.b()) });
            a(localQQAppInterface, str1, str2, (String)localObject2, i);
          }
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (!bool)
      {
        if (!localQQAppInterface.isLogin())
        {
          QLog.d("qqidentification_server", 1, "startDownloadResourceNoLogin");
          bbqy.b(localQQAppInterface);
        }
      }
      else {
        return bool;
      }
      QLog.d("qqidentification_server", 1, "startDownloadResource");
      blvn.a().a(AEResInfo.AE_RES_BASE_PACKAGE, null, false);
      bbqy.a(localQQAppInterface);
      return bool;
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("qqidentification_server", 2, "onCall, params=" + paramBundle + ", action=" + paramString + ", callBackId=" + paramInt);
    }
    if ("action_upload".equals(paramString))
    {
      if (paramBundle == null)
      {
        QLog.d("qqidentification_server", 1, "onCall, param is null, action=" + paramString + ", callBackId=" + paramInt);
        paramString = new Bundle();
        paramString.putString("subError", "no params");
        paramString.putBoolean("reset_null", true);
        callbackResult(paramInt, EIPCResult.createResult(-102, paramString));
        return null;
      }
      ThreadManager.excute(new IdentificationIpcServer.1(this, paramBundle), 128, null, false);
    }
    for (;;)
    {
      return null;
      if ("action_is_video_chatting".equals(paramString))
      {
        paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        paramBundle = new EIPCResult();
        if (paramString.isUsingCameraOnVideo()) {}
        for (paramInt = 1;; paramInt = 2)
        {
          paramBundle.code = paramInt;
          return paramBundle;
        }
      }
      if ("action_res_download".equals(paramString))
      {
        this.jdField_b_of_type_Int = paramInt;
        a();
        return null;
      }
      if ("action_face_usable".equals(paramString))
      {
        a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramBundle, paramInt);
      }
      else if ("action_app_conf".equals(paramString))
      {
        paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        a(paramBundle, paramInt);
        if (!"loginVerify".equals(paramBundle.getString("method", null)))
        {
          blvn.a().a(AEResInfo.AE_RES_BASE_PACKAGE, null, false);
          bbqy.a(paramString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auke
 * JD-Core Version:    0.7.0.1
 */