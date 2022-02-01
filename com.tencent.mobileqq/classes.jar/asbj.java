import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import com.tencent.mobileqq.filemanager.app.FMObserver.1;
import com.tencent.mobileqq.filemanager.app.FMObserver.43;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class asbj
  implements Observer
{
  static final String TAG = "FMObserver<FileAssistant>";
  private ArrayMap<Integer, ascz> mFileEventActions;
  
  private void offlineFileCome(Object[] paramArrayOfObject)
  {
    long l1 = ((Long)paramArrayOfObject[1]).longValue();
    long l2 = ((Long)paramArrayOfObject[2]).longValue();
    String str = (String)paramArrayOfObject[3];
    int i = ((Integer)paramArrayOfObject[4]).intValue();
    QLog.i("FMObserver<FileAssistant>", 1, "OnFileCome uniseq[" + String.valueOf(l1) + "],nSessionId[" + String.valueOf(l2) + "], strUin[" + aszt.e(str) + "], peerType[" + String.valueOf(i) + "]");
    onFileCome(l1, l2, str, i);
  }
  
  private void onCompleted(Object paramObject)
  {
    paramObject = (Object[])paramObject;
    onOnlineFileUpDone(((Long)paramObject[0]).longValue(), ((Long)paramObject[1]).longValue());
  }
  
  private void onDiscPreivew(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    Object localObject = (Object[])paramArrayOfObject[2];
    int i = ((Integer)localObject[0]).intValue();
    paramArrayOfObject = (String)localObject[1];
    String str1 = (String)localObject[2];
    String str2 = (String)localObject[3];
    String str3 = (String)localObject[4];
    String str4 = (String)localObject[5];
    int j = ((Integer)localObject[6]).intValue();
    localObject = (Bundle)localObject[7];
    QLog.i("FMObserver<FileAssistant>", 1, "OnDiscFilePreview retCode[" + String.valueOf(i) + "],retMsg[" + paramArrayOfObject + "], downloadKey[" + str2 + "], downloadIp[" + str3 + "], downloadDomain[" + str4 + "], port[" + String.valueOf(j) + "]");
    onFileDiscOfflinePreview(bool, i, paramArrayOfObject, str1, str2, str3, str4, j, null, (Bundle)localObject);
  }
  
  private void onError(Object[] paramArrayOfObject)
  {
    long l1 = ((Long)paramArrayOfObject[1]).longValue();
    long l2 = ((Long)paramArrayOfObject[2]).longValue();
    String str = (String)paramArrayOfObject[3];
    int i = ((Integer)paramArrayOfObject[4]).intValue();
    int j = ((Integer)paramArrayOfObject[5]).intValue();
    if (paramArrayOfObject[6] == null) {}
    for (paramArrayOfObject = null;; paramArrayOfObject = (String)paramArrayOfObject[6])
    {
      onSomethingChaned();
      QLog.i("FMObserver<FileAssistant>", 1, "OnFileTransferEnd uniseq[" + String.valueOf(l1) + "],nSessionId[" + String.valueOf(l2) + "],errCode[" + String.valueOf(j) + "],errMsg[" + String.valueOf(paramArrayOfObject) + "], peerType[" + String.valueOf(i) + "]");
      onFileTransferEnd(false, l1, l2, str, i, j, paramArrayOfObject);
      return;
    }
  }
  
  private void onMMApkFileSafeCheckResult(Object[] paramArrayOfObject)
  {
    Object localObject = (Object[])paramArrayOfObject[2];
    long l = ((Long)localObject[0]).longValue();
    int i = ((Integer)localObject[1]).intValue();
    int j = ((Integer)localObject[2]).intValue();
    paramArrayOfObject = (String)localObject[3];
    String str = (String)localObject[4];
    localObject = (Bundle)localObject[5];
    QLog.i("FMObserver<FileAssistant>", 1, "onMMApkFileSafeCheckResult sessionId[" + l + "] errCode[" + i + "] safeLevel [" + j + "] tipString [" + paramArrayOfObject + "] jumpDetailUrl [" + str + "]");
    onMMApkFileSafeCheckResult(l, i, j, paramArrayOfObject, str, (Bundle)localObject);
  }
  
  private void onOf2Wy(Object[] paramArrayOfObject)
  {
    if (((Boolean)paramArrayOfObject[1]).booleanValue())
    {
      paramArrayOfObject = (Object[])paramArrayOfObject[2];
      i = ((Integer)paramArrayOfObject[0]).intValue();
      str1 = (String)paramArrayOfObject[1];
      str2 = (String)paramArrayOfObject[2];
      l = ((Long)paramArrayOfObject[3]).longValue();
      if (QLog.isColorLevel()) {
        QLog.d("FMObserver<FileAssistant>", 2, "OnOfflineSendToWeiYunSuccess, nSessionId[" + String.valueOf(l) + "]");
      }
      onOfflineSendToWeiYunSuccess(l, str2, i, str1);
      return;
    }
    paramArrayOfObject = (Object[])paramArrayOfObject[2];
    int i = ((Integer)paramArrayOfObject[0]).intValue();
    String str1 = (String)paramArrayOfObject[1];
    String str2 = (String)paramArrayOfObject[2];
    long l = ((Long)paramArrayOfObject[3]).longValue();
    QLog.e("FMObserver<FileAssistant>", 1, "OnWeiYunSendToOfflineFaild, , nSessionId[" + String.valueOf(l) + "], errorCode[" + String.valueOf(i) + "], strErrMsg[" + String.valueOf(str1) + "]");
    onOfflineSendToWeiYunFaild(i, l, str1);
  }
  
  private void onOfflineList(Object[] paramArrayOfObject)
  {
    boolean bool;
    StringBuilder localStringBuilder;
    if (((Boolean)paramArrayOfObject[1]).booleanValue())
    {
      paramArrayOfObject = (Object[])paramArrayOfObject[2];
      bool = ((Boolean)paramArrayOfObject[0]).booleanValue();
      paramArrayOfObject = (List)paramArrayOfObject[1];
      localStringBuilder = new StringBuilder().append("OnWeiYunOfflineListSucess, , isEnd[").append(String.valueOf(bool)).append("], List<OfflineFileInfo> size[");
      if (paramArrayOfObject == null) {
        break label111;
      }
    }
    label111:
    for (int i = paramArrayOfObject.size();; i = 0)
    {
      QLog.i("FMObserver<FileAssistant>", 1, String.valueOf(i) + "]");
      onWeiYunOfflineListSucess(Boolean.valueOf(bool), paramArrayOfObject);
      return;
    }
  }
  
  private void onOnlineUpPrgfailed(Object paramObject)
  {
    paramObject = (Long)((Object[])(Object[])paramObject)[0];
    QLog.i("FMObserver<FileAssistant>", 1, "OnOnlineFileQueryUpProgressTimeOut, nSessionId=" + paramObject);
    onOnlineFileQueryUpProgressTimeOut(paramObject.longValue());
  }
  
  private void onPreview(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    Object localObject = (Object[])paramArrayOfObject[2];
    int i = ((Integer)localObject[0]).intValue();
    paramArrayOfObject = (String)localObject[1];
    String str1 = (String)localObject[2];
    String str2 = (String)localObject[3];
    String str3 = (String)localObject[4];
    String str4 = (String)localObject[5];
    int j = ((Integer)localObject[6]).intValue();
    localObject = (Bundle)localObject[7];
    QLog.i("FMObserver<FileAssistant>", 1, "OnFileOfflinePreview retCode[" + String.valueOf(i) + "],retMsg[" + paramArrayOfObject + "], downloadKey[" + str2 + "], downloadIp[" + str3 + "], downloadDomain[" + str4 + "], port[" + String.valueOf(j) + "]");
    onFileOfflinePreview(bool, i, str1, paramArrayOfObject, str2, str3, str4, j, null, (Bundle)localObject);
  }
  
  private void onRefresh(Object[] paramArrayOfObject)
  {
    try
    {
      bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
      if (bool) {
        onRefreshList();
      }
      return;
    }
    catch (Exception paramArrayOfObject)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FMObserver<FileAssistant>", 1, "OnRefreshList param error!");
        }
        boolean bool = false;
      }
    }
  }
  
  private void onSendRplay(Object paramObject)
  {
    paramObject = (Long)((Object[])(Object[])paramObject)[0];
    QLog.i("FMObserver<FileAssistant>", 1, "OnOnlineFileRecvButSenderReplayTimeOut, nSessionId=" + paramObject);
    onOnlineFileRecvButSenderReplayTimeOut(paramObject.longValue());
  }
  
  private void onSuccess(Object[] paramArrayOfObject)
  {
    long l1 = ((Long)paramArrayOfObject[1]).longValue();
    long l2 = ((Long)paramArrayOfObject[2]).longValue();
    String str = (String)paramArrayOfObject[3];
    int i = ((Integer)paramArrayOfObject[4]).intValue();
    onSomethingChaned();
    QLog.i("FMObserver<FileAssistant>", 1, "OnFileTransferEnd uniseq[" + l1 + "],nSessionId[" + l2 + "], peerType[" + i + "]");
    onFileTransferEnd(true, l1, l2, str, i, 0, null);
  }
  
  private void onTaost(Object[] paramArrayOfObject)
  {
    long l1 = ((Long)paramArrayOfObject[1]).longValue();
    long l2 = ((Long)paramArrayOfObject[2]).longValue();
    String str = (String)paramArrayOfObject[3];
    int i = ((Integer)paramArrayOfObject[4]).intValue();
    int j = ((Integer)paramArrayOfObject[5]).intValue();
    if (paramArrayOfObject[6] == null) {}
    for (paramArrayOfObject = null;; paramArrayOfObject = (String)paramArrayOfObject[6])
    {
      onSomethingChaned();
      QLog.i("FMObserver<FileAssistant>", 1, "OnFileTransferEnd uniseq[" + String.valueOf(l1) + "],nSessionId[" + String.valueOf(l2) + "],errCode[" + String.valueOf(j) + "],errMsg[" + String.valueOf(paramArrayOfObject) + "], peerType[" + String.valueOf(i) + "]");
      onShowToast(j, paramArrayOfObject);
      return;
    }
  }
  
  private void onThumbDownload(Object[] paramArrayOfObject)
  {
    if (((Boolean)paramArrayOfObject[1]).booleanValue())
    {
      paramArrayOfObject = (Object[])paramArrayOfObject[2];
      localObject = new aslv();
      ((aslv)localObject).jdField_a_of_type_JavaLangString = ((String)paramArrayOfObject[0]);
      ((aslv)localObject).jdField_a_of_type_Int = ((Integer)paramArrayOfObject[1]).intValue();
      ((aslv)localObject).jdField_b_of_type_JavaLangString = ((String)paramArrayOfObject[2]);
      ((aslv)localObject).jdField_a_of_type_JavaLangObject = paramArrayOfObject[3];
      QLog.i("FMObserver<FileAssistant>", 1, "OnThumbDownLoadSuccess,fileId[" + ((aslv)localObject).jdField_a_of_type_JavaLangString + "],filePath[" + ((aslv)localObject).jdField_b_of_type_JavaLangString + "]");
      if ((((aslv)localObject).jdField_a_of_type_JavaLangObject != null) && (((aslv)localObject).jdField_b_of_type_JavaLangString != null) && (((aslv)localObject).jdField_b_of_type_JavaLangString.length() > 0))
      {
        if (!(((aslv)localObject).jdField_a_of_type_JavaLangObject instanceof WeiYunFileInfo)) {
          break label171;
        }
        ((WeiYunFileInfo)((aslv)localObject).jdField_a_of_type_JavaLangObject).h = ((aslv)localObject).jdField_b_of_type_JavaLangString;
      }
      for (;;)
      {
        onThumbDownLoadSuccess((aslv)localObject);
        return;
        label171:
        if ((((aslv)localObject).jdField_a_of_type_JavaLangObject instanceof OfflineFileInfo)) {
          ((OfflineFileInfo)((aslv)localObject).jdField_a_of_type_JavaLangObject).d = ((aslv)localObject).jdField_b_of_type_JavaLangString;
        } else if ((((aslv)localObject).jdField_a_of_type_JavaLangObject instanceof FileManagerEntity)) {
          ((FileManagerEntity)((aslv)localObject).jdField_a_of_type_JavaLangObject).strThumbPath = ((aslv)localObject).jdField_b_of_type_JavaLangString;
        }
      }
    }
    Object localObject = (Object[])paramArrayOfObject[2];
    String str = (String)localObject[0];
    paramArrayOfObject = new aslv();
    paramArrayOfObject.jdField_b_of_type_JavaLangString = null;
    paramArrayOfObject.jdField_a_of_type_JavaLangString = str;
    paramArrayOfObject.jdField_a_of_type_JavaLangObject = localObject[1];
    localObject = new Handler();
    QLog.i("FMObserver<FileAssistant>", 1, "OnThumbDownLoadSuccess(faild),fileId[" + paramArrayOfObject.jdField_a_of_type_JavaLangString + "],delay 1000ms");
    ((Handler)localObject).postDelayed(new FMObserver.43(this, paramArrayOfObject), 1000L);
  }
  
  private void onThumbPrgs(Object[] paramArrayOfObject)
  {
    ((Boolean)paramArrayOfObject[1]).booleanValue();
    Object localObject = (Object[])paramArrayOfObject[2];
    paramArrayOfObject = (FileManagerEntity)localObject[0];
    int i = ((Integer)localObject[1]).intValue();
    localObject = new aslv();
    ((aslv)localObject).jdField_a_of_type_JavaLangObject = paramArrayOfObject;
    ((aslv)localObject).jdField_a_of_type_JavaLangString = paramArrayOfObject.Uuid;
    ((aslv)localObject).jdField_b_of_type_JavaLangString = null;
    ((aslv)localObject).jdField_a_of_type_Long = paramArrayOfObject.nSessionId;
    onThumbDownLoadProgress((aslv)localObject, i);
  }
  
  private void onThumnDownload(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    Object localObject = (Object[])paramArrayOfObject[2];
    paramArrayOfObject = (FileManagerEntity)localObject[0];
    if (localObject.length > 1) {}
    for (int i = ((Integer)localObject[1]).intValue();; i = 0)
    {
      if (bool)
      {
        localObject = new aslv();
        ((aslv)localObject).jdField_a_of_type_JavaLangObject = paramArrayOfObject;
        ((aslv)localObject).jdField_a_of_type_JavaLangString = paramArrayOfObject.Uuid;
        ((aslv)localObject).jdField_b_of_type_Int = i;
        if (i == 7) {
          ((aslv)localObject).jdField_b_of_type_JavaLangString = paramArrayOfObject.strLargeThumPath;
        }
        for (;;)
        {
          ((aslv)localObject).jdField_a_of_type_Long = paramArrayOfObject.nSessionId;
          onThumbDownLoadSuccess((aslv)localObject);
          return;
          if (i == 5) {
            ((aslv)localObject).jdField_b_of_type_JavaLangString = paramArrayOfObject.strMiddleThumPath;
          } else {
            ((aslv)localObject).jdField_b_of_type_JavaLangString = paramArrayOfObject.strThumbPath;
          }
        }
      }
      localObject = new aslv();
      ((aslv)localObject).jdField_a_of_type_JavaLangObject = paramArrayOfObject;
      ((aslv)localObject).jdField_a_of_type_JavaLangString = paramArrayOfObject.Uuid;
      ((aslv)localObject).jdField_b_of_type_JavaLangString = null;
      ((aslv)localObject).jdField_b_of_type_Int = i;
      ((aslv)localObject).jdField_a_of_type_Long = paramArrayOfObject.nSessionId;
      onThumbDownLoadSuccess((aslv)localObject);
      return;
    }
  }
  
  private void onTransfer_Start(Object[] paramArrayOfObject)
  {
    long l1 = ((Long)paramArrayOfObject[1]).longValue();
    long l2 = ((Long)paramArrayOfObject[2]).longValue();
    String str = (String)paramArrayOfObject[3];
    int i = ((Integer)paramArrayOfObject[4]).intValue();
    QLog.i("FMObserver<FileAssistant>", 1, "OnFileTransferStart uniseq[" + String.valueOf(l1) + "],nSessionId[" + String.valueOf(l2) + "], strUin[" + aszt.e(str) + "], peerType[" + String.valueOf(i) + "]");
    onFileTransferStart(l1, l2, str, i);
  }
  
  private void onTransfer_progress(Object[] paramArrayOfObject)
  {
    long l1 = ((Long)paramArrayOfObject[1]).longValue();
    long l2 = ((Long)paramArrayOfObject[2]).longValue();
    String str = (String)paramArrayOfObject[3];
    int i = ((Integer)paramArrayOfObject[4]).intValue();
    if (((Integer)paramArrayOfObject[5]).intValue() == 14)
    {
      onFileTransferProgress(false, l1, l2, str, i);
      return;
    }
    onFileTransferProgress(true, l1, l2, str, i);
  }
  
  private void onTroop2disc_c2c(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    paramArrayOfObject = (Object[])paramArrayOfObject[2];
    onTroopFileCopyToC2cDisc(((Long)paramArrayOfObject[0]).longValue(), bool, ((Integer)paramArrayOfObject[1]).intValue(), (String)paramArrayOfObject[2]);
  }
  
  private void onUpdate(Object paramObject)
  {
    paramObject = (Object[])paramObject;
    int i = ((Integer)paramObject[0]).intValue();
    initEventActions();
    ascz localascz = (ascz)this.mFileEventActions.get(Integer.valueOf(i));
    if (localascz != null)
    {
      localascz.a(paramObject);
      return;
    }
    QLog.e("FMObserver<FileAssistant>", 1, "OnUpdate : Status[" + i + "] not processed");
  }
  
  private void onVerpwd(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    Object localObject = (Object[])paramArrayOfObject[2];
    paramArrayOfObject = (Integer)localObject[0];
    localObject = (String)localObject[1];
    if (!bool)
    {
      QLog.i("FMObserver<FileAssistant>", 1, "OnVerifyPwdFailed");
      onVerifyPwdFailed(paramArrayOfObject.intValue(), (String)localObject);
      return;
    }
    QLog.i("FMObserver<FileAssistant>", 1, "OnVerifyPwdSuccess");
    onVerifyPwdSuccess();
  }
  
  private void onVideoDiscThumbInfo(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    Object localObject = (Object[])paramArrayOfObject[2];
    int i = ((Integer)localObject[0]).intValue();
    paramArrayOfObject = (String)localObject[1];
    String str1 = (String)localObject[2];
    String str2 = (String)localObject[3];
    String str3 = (String)localObject[4];
    String str4 = (String)localObject[5];
    int j = ((Integer)localObject[6]).intValue();
    String str5 = (String)localObject[7];
    long l = ((Long)localObject[8]).longValue();
    localObject = (Bundle)localObject[9];
    QLog.i("FMObserver<FileAssistant>", 1, "OnGetDiscVideoThumbInfo retCode[" + String.valueOf(i) + "],retMsg[" + paramArrayOfObject + "], downloadKey[" + str2 + "], downloadIp[" + str3 + "], downloadDomain[" + str4 + "], port[" + String.valueOf(j) + "]");
    onGetDiscVideoThumbInfo(bool, i, paramArrayOfObject, str1, str2, str3, str4, j, str5, l, (Bundle)localObject);
  }
  
  private void onVideoThumbInfo(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    Object localObject = (Object[])paramArrayOfObject[2];
    int i = ((Integer)localObject[0]).intValue();
    paramArrayOfObject = (String)localObject[1];
    String str1 = (String)localObject[2];
    String str2 = (String)localObject[3];
    String str3 = (String)localObject[4];
    String str4 = (String)localObject[5];
    int j = ((Integer)localObject[6]).intValue();
    String str5 = (String)localObject[7];
    long l = ((Long)localObject[8]).longValue();
    localObject = (Bundle)localObject[9];
    QLog.i("FMObserver<FileAssistant>", 1, "OnGetOfflineVideoThumbInfo retCode[" + String.valueOf(i) + "],retMsg[" + paramArrayOfObject + "], downloadKey[" + str2 + "], downloadIp[" + str3 + "], downloadDomain[" + str4 + "], port[" + String.valueOf(j) + "]");
    onGetOfflineVideoThumbInfo(bool, i, paramArrayOfObject, str1, str2, str3, str4, j, str5, l, (Bundle)localObject);
  }
  
  private void onWeiYunPreview(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    Object[] arrayOfObject = (Object[])paramArrayOfObject[2];
    int i = ((Integer)arrayOfObject[0]).intValue();
    String str1 = (String)arrayOfObject[1];
    String str2 = (String)arrayOfObject[2];
    String str3 = (String)arrayOfObject[3];
    String str4 = (String)arrayOfObject[4];
    String str5 = (String)arrayOfObject[5];
    int j = ((Integer)arrayOfObject[6]).intValue();
    Object localObject = null;
    paramArrayOfObject = localObject;
    if (arrayOfObject.length > 7)
    {
      paramArrayOfObject = localObject;
      if (arrayOfObject[7] != null) {
        paramArrayOfObject = (String)arrayOfObject[7];
      }
    }
    QLog.i("FMObserver<FileAssistant>", 1, "OnWeiYunFilePreview retCode[" + String.valueOf(i) + "],retMsg[" + str1 + "], downloadKey[" + str2 + "], downloadIp[" + str4 + "], downloadDomain[" + str5 + "], port[" + String.valueOf(j) + "]");
    onFileWeiYunPreview(bool, i, str1, str2, str3, str4, str5, j, paramArrayOfObject);
  }
  
  private void onWyClassificationinfo(Object[] paramArrayOfObject)
  {
    if (((Boolean)paramArrayOfObject[1]).booleanValue())
    {
      paramArrayOfObject = (Object[])paramArrayOfObject[2];
      localObject = (String)paramArrayOfObject[0];
      boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
      i = ((Integer)paramArrayOfObject[2]).intValue();
      String str = (String)paramArrayOfObject[3];
      List localList = (List)paramArrayOfObject[4];
      int j = ((Integer)paramArrayOfObject[5]).intValue();
      QLog.i("FMObserver<FileAssistant>", 1, "OnWeiYunOneClassificationInfoSuccess, categoryId[" + (String)localObject + "], isEnd[" + String.valueOf(bool) + "], count[" + String.valueOf(i) + "], localVersion[" + str + "], List<WeiYunFileInfo> size[" + localList.size() + "], index[" + String.valueOf(j) + "]");
      onWeiYunOneClassificationInfoSuccess((String)localObject, bool, i, str, localList, j);
      return;
    }
    Object localObject = (Object[])paramArrayOfObject[2];
    int i = ((Integer)localObject[0]).intValue();
    paramArrayOfObject = (String)localObject[1];
    localObject = (String)localObject[2];
    QLog.i("FMObserver<FileAssistant>", 1, "OnWeiYunOneClassificationInfoFaild, , errorCode[" + String.valueOf(i) + "], strErrMsg[" + String.valueOf(paramArrayOfObject) + "], strCategoryId[" + String.valueOf(localObject) + "]");
    onWeiYunOneClassificationInfoFaild(i, paramArrayOfObject, (String)localObject);
  }
  
  private void onWyPsw(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    paramArrayOfObject = (Object[])paramArrayOfObject[2];
    Integer localInteger = (Integer)paramArrayOfObject[0];
    String str = (String)paramArrayOfObject[1];
    if (!bool)
    {
      QLog.i("FMObserver<FileAssistant>", 1, "OnNeedVerifyPwdFailed");
      onNeedVerifyPwdFailed(localInteger.intValue(), str);
      return;
    }
    paramArrayOfObject = (Boolean)paramArrayOfObject[2];
    QLog.i("FMObserver<FileAssistant>", 1, "OnNeedVerifyPwdSuccess,  need verify[" + paramArrayOfObject + "]");
    onNeedVerifyPwdSuccess(paramArrayOfObject.booleanValue());
  }
  
  private void onWyToOffline(Object[] paramArrayOfObject)
  {
    if (((Boolean)paramArrayOfObject[1]).booleanValue())
    {
      if (QLog.isColorLevel()) {
        QLog.d("FMObserver<FileAssistant>", 2, "OnWeiYunSendToOfflineSuccess");
      }
      onWeiYunSendToOfflineSuccess();
      return;
    }
    paramArrayOfObject = (Object[])paramArrayOfObject[2];
    int i = ((Integer)paramArrayOfObject[0]).intValue();
    String str = (String)paramArrayOfObject[1];
    long l = ((Long)paramArrayOfObject[2]).longValue();
    QLog.e("FMObserver<FileAssistant>", 1, "OnWeiYunSendToOfflineFaild, , nSessionId[" + String.valueOf(l) + "], errorCode[" + String.valueOf(i) + "], strErrMsg[" + String.valueOf(str) + "]");
    onWeiYunSendToOfflineFaild(Integer.valueOf(i), l, str);
  }
  
  private void onZipImgDownload(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    Object localObject = (Object[])paramArrayOfObject[2];
    long l = ((Long)localObject[0]).longValue();
    int i = ((Integer)localObject[1]).intValue();
    paramArrayOfObject = (String)localObject[2];
    localObject = (String)localObject[3];
    QLog.i("FMObserver<FileAssistant>", 1, "OnZipImageThumbDownloadCompleted thumbUrl[" + (String)localObject + "]");
    onZipImageThumbDownloadCompleted(bool, i, l, (String)localObject, paramArrayOfObject);
  }
  
  private void ondelWy(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    Object localObject = (Object[])paramArrayOfObject[2];
    paramArrayOfObject = (Integer)localObject[0];
    String str1 = (String)localObject[1];
    String str2 = (String)localObject[2];
    String str3 = (String)localObject[3];
    localObject = (Boolean)localObject[4];
    if (!bool)
    {
      QLog.i("FMObserver<FileAssistant>", 1, "OnDelClouldFileFaild,  uuid[" + str2 + "]strFileName[" + String.valueOf(str3) + "]errorCode[" + String.valueOf(paramArrayOfObject) + "],retMsg[" + str1 + "],bOffline[" + String.valueOf(localObject) + "]");
      onDelClouldFileFaild(str2, str3, paramArrayOfObject, str1, ((Boolean)localObject).booleanValue());
      return;
    }
    QLog.i("FMObserver<FileAssistant>", 1, "OnDelClouldFileSuccess,  uuid[" + str2 + "]strFileName[" + String.valueOf(str3) + "],bOffline[" + String.valueOf(localObject) + "]");
    onDelClouldFileSuccess(str2, str3, ((Boolean)localObject).booleanValue());
  }
  
  private void onforwardOf(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    paramArrayOfObject = (Object[])paramArrayOfObject[2];
    int i = ((Integer)paramArrayOfObject[0]).intValue();
    String str1 = (String)paramArrayOfObject[1];
    long l1 = ((Long)paramArrayOfObject[2]).longValue();
    long l2 = ((Long)paramArrayOfObject[3]).longValue();
    String str2 = (String)paramArrayOfObject[4];
    long l3 = ((Long)paramArrayOfObject[5]).longValue();
    QLog.i("FMObserver<FileAssistant>", 1, "OnForwardOfflineFile, bSuccess[" + String.valueOf(bool) + "], retCode[" + String.valueOf(i) + "], retMsg[" + String.valueOf(str1) + "], totalSpace[" + String.valueOf(l1) + "], usedSpace[" + String.valueOf(l2) + "], strUuid[" + String.valueOf(str2) + "], nSessionId[" + String.valueOf(l3) + "]");
    onForwardOfflineFile(bool, i, str1, l1, l2, str2, l3);
  }
  
  private void onlinePrgDirect(Object paramObject)
  {
    paramObject = (Long)((Object[])(Object[])paramObject)[0];
    QLog.i("FMObserver<FileAssistant>", 1, "OnOnlineFileProgressDirectDone, nSessionId=" + paramObject);
    onOnlineFileProgressDirectDone(paramObject.longValue());
  }
  
  protected final void initEventActions()
  {
    if (this.mFileEventActions != null) {
      return;
    }
    this.mFileEventActions = new ArrayMap();
    this.mFileEventActions.put(Integer.valueOf(17), new asbu(this));
    this.mFileEventActions.put(Integer.valueOf(0), new ascf(this));
    this.mFileEventActions.put(Integer.valueOf(25), new ascq(this));
    this.mFileEventActions.put(Integer.valueOf(10), new ascu(this));
    this.mFileEventActions.put(Integer.valueOf(13), new ascv(this));
    this.mFileEventActions.put(Integer.valueOf(16), new ascw(this));
    this.mFileEventActions.put(Integer.valueOf(14), new ascx(this));
    this.mFileEventActions.put(Integer.valueOf(11), new ascy(this));
    this.mFileEventActions.put(Integer.valueOf(35), new asbk(this));
    this.mFileEventActions.put(Integer.valueOf(37), new asbl(this));
    this.mFileEventActions.put(Integer.valueOf(1), new asbm(this));
    this.mFileEventActions.put(Integer.valueOf(15), new asbn(this));
    this.mFileEventActions.put(Integer.valueOf(12), new asbo(this));
    this.mFileEventActions.put(Integer.valueOf(36), new asbp(this));
    this.mFileEventActions.put(Integer.valueOf(38), new asbq(this));
    this.mFileEventActions.put(Integer.valueOf(22), new asbr(this));
    this.mFileEventActions.put(Integer.valueOf(4), new asbs(this));
    this.mFileEventActions.put(Integer.valueOf(18), new asbt(this));
    this.mFileEventActions.put(Integer.valueOf(21), new asbv(this));
    this.mFileEventActions.put(Integer.valueOf(278), new asbw(this));
    this.mFileEventActions.put(Integer.valueOf(31), new asbx(this));
    this.mFileEventActions.put(Integer.valueOf(32), new asby(this));
    this.mFileEventActions.put(Integer.valueOf(33), new asbz(this));
    this.mFileEventActions.put(Integer.valueOf(46), new asca(this));
    this.mFileEventActions.put(Integer.valueOf(34), new ascb(this));
    this.mFileEventActions.put(Integer.valueOf(39), new ascc(this));
    this.mFileEventActions.put(Integer.valueOf(3), new ascd(this));
    this.mFileEventActions.put(Integer.valueOf(19), new asce(this));
    this.mFileEventActions.put(Integer.valueOf(20), new ascg(this));
    this.mFileEventActions.put(Integer.valueOf(41), new asch(this));
    this.mFileEventActions.put(Integer.valueOf(42), new asci(this));
    this.mFileEventActions.put(Integer.valueOf(43), new ascj(this));
    this.mFileEventActions.put(Integer.valueOf(44), new asck(this));
    this.mFileEventActions.put(Integer.valueOf(45), new ascl(this));
    this.mFileEventActions.put(Integer.valueOf(51), new ascm(this));
    this.mFileEventActions.put(Integer.valueOf(50), new ascn(this));
    this.mFileEventActions.put(Integer.valueOf(52), new asco(this));
    this.mFileEventActions.put(Integer.valueOf(191), new ascp(this));
    this.mFileEventActions.put(Integer.valueOf(192), new ascr(this));
    this.mFileEventActions.put(Integer.valueOf(60), new ascs(this));
    this.mFileEventActions.put(Integer.valueOf(200), new asct(this));
  }
  
  protected void onAIOMusicChanged() {}
  
  protected void onDelClouldFileFaild(String paramString1, String paramString2, Integer paramInteger, String paramString3, boolean paramBoolean) {}
  
  protected void onDelClouldFileSuccess(String paramString1, String paramString2, boolean paramBoolean) {}
  
  protected void onFileCome(long paramLong1, long paramLong2, String paramString, int paramInt) {}
  
  protected void onFileDiscOfflinePreview(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, Bundle paramBundle) {}
  
  protected void onFileOfflinePreview(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, Bundle paramBundle) {}
  
  protected void onFileTransferEnd(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2) {}
  
  protected void onFileTransferProgress(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt) {}
  
  protected void onFileTransferStart(long paramLong1, long paramLong2, String paramString, int paramInt) {}
  
  protected void onFileWeiYunPreview(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6) {}
  
  protected void onForwardOfflineFile(boolean paramBoolean, int paramInt, String paramString1, long paramLong1, long paramLong2, String paramString2, long paramLong3) {}
  
  protected void onGetDiscVideoThumbInfo(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, long paramLong, Bundle paramBundle) {}
  
  protected void onGetOfflineVideoThumbInfo(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, long paramLong, Bundle paramBundle) {}
  
  protected void onMMApkFileSafeCheckResult(long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, Bundle paramBundle) {}
  
  protected void onNeedVerifyPwdFailed(int paramInt, String paramString) {}
  
  protected void onNeedVerifyPwdSuccess(boolean paramBoolean) {}
  
  protected void onOfflineSendToWeiYunFaild(int paramInt, long paramLong, String paramString) {}
  
  protected void onOfflineSendToWeiYunSuccess(long paramLong, String paramString1, int paramInt, String paramString2) {}
  
  protected void onOnlineFileProgressDirectDone(long paramLong) {}
  
  protected void onOnlineFileQueryUpProgressTimeOut(long paramLong) {}
  
  protected void onOnlineFileRecvButSenderReplayTimeOut(long paramLong) {}
  
  protected void onOnlineFileUpDone(long paramLong1, long paramLong2) {}
  
  protected void onRefreshList() {}
  
  protected void onShowToast(int paramInt, String paramString) {}
  
  protected void onSomethingChaned() {}
  
  protected void onThumbDownLoadProgress(aslv paramaslv, int paramInt) {}
  
  public void onThumbDownLoadSuccess(aslv paramaslv) {}
  
  protected void onTroopFileCopyToC2cDisc(long paramLong, boolean paramBoolean, int paramInt, String paramString) {}
  
  protected void onVerifyPwdFailed(int paramInt, String paramString) {}
  
  protected void onVerifyPwdSuccess() {}
  
  protected void onWeiYunOfflineListSucess(Boolean paramBoolean, List<OfflineFileInfo> paramList) {}
  
  protected void onWeiYunOneClassificationInfoFaild(int paramInt, String paramString1, String paramString2) {}
  
  protected void onWeiYunOneClassificationInfoSuccess(String paramString1, boolean paramBoolean, int paramInt1, String paramString2, List<WeiYunFileInfo> paramList, int paramInt2) {}
  
  protected void onWeiYunSendToOfflineFaild(Integer paramInteger, long paramLong, String paramString) {}
  
  protected void onWeiYunSendToOfflineSuccess() {}
  
  protected void onZipImageThumbDownloadCompleted(boolean paramBoolean, int paramInt, long paramLong, String paramString1, String paramString2) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = Looper.getMainLooper();
    if (Thread.currentThread() != paramObservable.getThread())
    {
      new Handler(paramObservable).post(new FMObserver.1(this, paramObject));
      return;
    }
    onUpdate(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     asbj
 * JD-Core Version:    0.7.0.1
 */