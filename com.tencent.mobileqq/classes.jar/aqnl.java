import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.filemanager.app.FMObserver.1;
import com.tencent.mobileqq.filemanager.app.FMObserver.2;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class aqnl
  implements Observer
{
  private void a(Object paramObject)
  {
    paramObject = (Object[])paramObject;
    int i = ((Integer)paramObject[0]).intValue();
    long l1;
    long l2;
    Object localObject1;
    int j;
    boolean bool;
    Object localObject5;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject6;
    switch (i)
    {
    default: 
      QLog.e("FMObserver<FileAssistant>", 1, "OnUpdate : Status[" + i + "] not processed");
    case 17: 
    case 0: 
    case 25: 
    case 10: 
    case 13: 
    case 16: 
    case 11: 
    case 14: 
    case 35: 
    case 37: 
    case 1: 
    case 12: 
    case 15: 
    case 36: 
    case 38: 
    case 22: 
    case 4: 
    case 18: 
    case 21: 
    case 278: 
    case 30: 
    case 31: 
    case 32: 
    case 33: 
    case 46: 
    case 34: 
    case 39: 
    case 40: 
    case 3: 
      for (;;)
      {
        return;
        l1 = ((Long)paramObject[1]).longValue();
        l2 = ((Long)paramObject[2]).longValue();
        localObject1 = (String)paramObject[3];
        i = ((Integer)paramObject[4]).intValue();
        QLog.i("FMObserver<FileAssistant>", 1, "OnFileCome uniseq[" + String.valueOf(l1) + "],nSessionId[" + String.valueOf(l2) + "], strUin[" + arni.e((String)localObject1) + "], peerType[" + String.valueOf(i) + "]");
        a(l1, l2, (String)localObject1, i);
        return;
        a();
        return;
        c();
        return;
        l1 = ((Long)paramObject[1]).longValue();
        l2 = ((Long)paramObject[2]).longValue();
        localObject1 = (String)paramObject[3];
        i = ((Integer)paramObject[4]).intValue();
        QLog.i("FMObserver<FileAssistant>", 1, "OnFileTransferStart uniseq[" + String.valueOf(l1) + "],nSessionId[" + String.valueOf(l2) + "], strUin[" + arni.e((String)localObject1) + "], peerType[" + String.valueOf(i) + "]");
        b(l1, l2, (String)localObject1, i);
        return;
        l1 = ((Long)paramObject[1]).longValue();
        l2 = ((Long)paramObject[2]).longValue();
        localObject1 = (String)paramObject[3];
        i = ((Integer)paramObject[4]).intValue();
        if (((Integer)paramObject[5]).intValue() == 14)
        {
          a(false, l1, l2, (String)localObject1, i);
          return;
        }
        a(true, l1, l2, (String)localObject1, i);
        return;
        l1 = ((Long)paramObject[1]).longValue();
        l2 = ((Long)paramObject[2]).longValue();
        localObject1 = (String)paramObject[3];
        i = ((Integer)paramObject[4]).intValue();
        a();
        QLog.i("FMObserver<FileAssistant>", 1, "OnFileTransferEnd uniseq[" + l1 + "],nSessionId[" + l2 + "], peerType[" + i + "]");
        a(true, l1, l2, (String)localObject1, i, 0, null);
        return;
        l1 = ((Long)paramObject[1]).longValue();
        l2 = ((Long)paramObject[2]).longValue();
        localObject1 = (String)paramObject[3];
        i = ((Integer)paramObject[4]).intValue();
        j = ((Integer)paramObject[5]).intValue();
        if (paramObject[6] == null) {}
        for (paramObject = null;; paramObject = (String)paramObject[6])
        {
          a();
          QLog.i("FMObserver<FileAssistant>", 1, "OnFileTransferEnd uniseq[" + String.valueOf(l1) + "],nSessionId[" + String.valueOf(l2) + "],errCode[" + String.valueOf(j) + "],errMsg[" + String.valueOf(paramObject) + "], peerType[" + String.valueOf(i) + "]");
          a(false, l1, l2, (String)localObject1, i, j, paramObject);
          return;
        }
        paramObject = (Object[])paramObject[2];
        a(((Long)paramObject[0]).longValue(), ((Long)paramObject[1]).longValue());
        return;
        l1 = ((Long)paramObject[1]).longValue();
        l2 = ((Long)paramObject[2]).longValue();
        localObject1 = (String)paramObject[3];
        i = ((Integer)paramObject[4]).intValue();
        j = ((Integer)paramObject[5]).intValue();
        if (paramObject[6] == null) {}
        for (paramObject = null;; paramObject = (String)paramObject[6])
        {
          a();
          QLog.i("FMObserver<FileAssistant>", 1, "OnFileTransferEnd uniseq[" + String.valueOf(l1) + "],nSessionId[" + String.valueOf(l2) + "],errCode[" + String.valueOf(j) + "],errMsg[" + String.valueOf(paramObject) + "], peerType[" + String.valueOf(i) + "]");
          c(j, paramObject);
          return;
        }
        bool = ((Boolean)paramObject[1]).booleanValue();
        localObject5 = (Object[])paramObject[2];
        i = ((Integer)localObject5[0]).intValue();
        paramObject = (String)localObject5[1];
        localObject1 = (String)localObject5[2];
        localObject2 = (String)localObject5[3];
        localObject3 = (String)localObject5[4];
        localObject4 = (String)localObject5[5];
        j = ((Integer)localObject5[6]).intValue();
        localObject5 = (Bundle)localObject5[7];
        QLog.i("FMObserver<FileAssistant>", 1, "OnFileOfflinePreview retCode[" + String.valueOf(i) + "],retMsg[" + paramObject + "], downloadKey[" + (String)localObject2 + "], downloadIp[" + (String)localObject3 + "], downloadDomain[" + (String)localObject4 + "], port[" + String.valueOf(j) + "]");
        b(bool, i, (String)localObject1, paramObject, (String)localObject2, (String)localObject3, (String)localObject4, j, null, (Bundle)localObject5);
        return;
        bool = ((Boolean)paramObject[1]).booleanValue();
        localObject5 = (Object[])paramObject[2];
        i = ((Integer)localObject5[0]).intValue();
        paramObject = (String)localObject5[1];
        localObject1 = (String)localObject5[2];
        localObject2 = (String)localObject5[3];
        localObject3 = (String)localObject5[4];
        localObject4 = (String)localObject5[5];
        j = ((Integer)localObject5[6]).intValue();
        localObject5 = (Bundle)localObject5[7];
        QLog.i("FMObserver<FileAssistant>", 1, "OnDiscFilePreview retCode[" + String.valueOf(i) + "],retMsg[" + paramObject + "], downloadKey[" + (String)localObject2 + "], downloadIp[" + (String)localObject3 + "], downloadDomain[" + (String)localObject4 + "], port[" + String.valueOf(j) + "]");
        a(bool, i, paramObject, (String)localObject1, (String)localObject2, (String)localObject3, (String)localObject4, j, null, (Bundle)localObject5);
        return;
        bool = ((Boolean)paramObject[1]).booleanValue();
        Object[] arrayOfObject = (Object[])paramObject[2];
        i = ((Integer)arrayOfObject[0]).intValue();
        localObject2 = (String)arrayOfObject[1];
        localObject3 = (String)arrayOfObject[2];
        localObject4 = (String)arrayOfObject[3];
        localObject5 = (String)arrayOfObject[4];
        localObject6 = (String)arrayOfObject[5];
        j = ((Integer)arrayOfObject[6]).intValue();
        localObject1 = null;
        paramObject = localObject1;
        if (arrayOfObject.length > 7)
        {
          paramObject = localObject1;
          if (arrayOfObject[7] != null) {
            paramObject = (String)arrayOfObject[7];
          }
        }
        QLog.i("FMObserver<FileAssistant>", 1, "OnWeiYunFilePreview retCode[" + String.valueOf(i) + "],retMsg[" + (String)localObject2 + "], downloadKey[" + (String)localObject3 + "], downloadIp[" + (String)localObject5 + "], downloadDomain[" + (String)localObject6 + "], port[" + String.valueOf(j) + "]");
        a(bool, i, (String)localObject2, (String)localObject3, (String)localObject4, (String)localObject5, (String)localObject6, j, paramObject);
        return;
        if (((Boolean)paramObject[1]).booleanValue())
        {
          paramObject = (List)paramObject[2];
          if (paramObject == null) {
            QLog.w("FMObserver<FileAssistant>", 1, "OnWeiYunClassificationTypeSuccess, but WeiYunClassificationType is null");
          }
          for (;;)
          {
            a(paramObject);
            return;
            QLog.i("FMObserver<FileAssistant>", 1, "OnWeiYunClassificationTypeSuccess, WeiYunClassificationType size[" + String.valueOf(paramObject.size()) + "]");
          }
        }
        paramObject = (Object[])paramObject[2];
        i = ((Integer)paramObject[0]).intValue();
        paramObject = (String)paramObject[1];
        QLog.i("FMObserver<FileAssistant>", 1, "OnWeiYunOneClassificationInfoFaild, , errorCode[" + String.valueOf(i) + "], strErrMsg[" + String.valueOf(paramObject) + "]");
        d(i, paramObject);
        return;
        if (((Boolean)paramObject[1]).booleanValue())
        {
          localObject3 = (Object[])paramObject[2];
          paramObject = (String)localObject3[0];
          bool = ((Boolean)localObject3[1]).booleanValue();
          j = ((Integer)localObject3[2]).intValue();
          localObject1 = (String)localObject3[3];
          localObject2 = (List)localObject3[4];
          int k = ((Integer)localObject3[5]).intValue();
          localObject3 = new StringBuilder().append("OnWeiYunOneClassificationInfoSuccess, categoryId[").append(paramObject).append("], isEnd[").append(String.valueOf(bool)).append("], count[").append(String.valueOf(j)).append("], localVersion[").append((String)localObject1).append("], List<WeiYunFileInfo> size[");
          if (localObject2 != null) {}
          for (i = ((List)localObject2).size();; i = 0)
          {
            QLog.i("FMObserver<FileAssistant>", 1, String.valueOf(i) + "], index[" + String.valueOf(k) + "]");
            a(paramObject, bool, j, (String)localObject1, (List)localObject2, k);
            return;
          }
        }
        localObject1 = (Object[])paramObject[2];
        i = ((Integer)localObject1[0]).intValue();
        paramObject = (String)localObject1[1];
        localObject1 = (String)localObject1[2];
        QLog.i("FMObserver<FileAssistant>", 1, "OnWeiYunOneClassificationInfoFaild, , errorCode[" + String.valueOf(i) + "], strErrMsg[" + String.valueOf(paramObject) + "], strCategoryId[" + String.valueOf(localObject1) + "]");
        a(i, paramObject, (String)localObject1);
        return;
        if (((Boolean)paramObject[1]).booleanValue())
        {
          paramObject = (Object[])paramObject[2];
          bool = ((Boolean)paramObject[0]).booleanValue();
          paramObject = (List)paramObject[1];
          localObject1 = new StringBuilder().append("OnWeiYunOfflineListSucess, , isEnd[").append(String.valueOf(bool)).append("], List<OfflineFileInfo> size[");
          if (paramObject != null) {}
          for (i = paramObject.size();; i = 0)
          {
            QLog.i("FMObserver<FileAssistant>", 1, String.valueOf(i) + "]");
            a(Boolean.valueOf(bool), paramObject);
            return;
          }
        }
        paramObject = (Object[])paramObject[2];
        i = ((Integer)paramObject[0]).intValue();
        paramObject = (String)paramObject[1];
        QLog.e("FMObserver<FileAssistant>", 1, "OnWeiYunOfflineListFaild, , errorCode[" + String.valueOf(i) + "], strErrMsg[" + String.valueOf(paramObject) + "]");
        a(Integer.valueOf(i), paramObject);
        return;
        if (((Boolean)paramObject[1]).booleanValue())
        {
          if (QLog.isColorLevel()) {
            QLog.d("FMObserver<FileAssistant>", 2, "OnWeiYunSendToOfflineSuccess");
          }
          d();
          return;
        }
        paramObject = (Object[])paramObject[2];
        i = ((Integer)paramObject[0]).intValue();
        localObject1 = (String)paramObject[1];
        l1 = ((Long)paramObject[2]).longValue();
        QLog.e("FMObserver<FileAssistant>", 1, "OnWeiYunSendToOfflineFaild, , nSessionId[" + String.valueOf(l1) + "], errorCode[" + String.valueOf(i) + "], strErrMsg[" + String.valueOf(localObject1) + "]");
        a(Integer.valueOf(i), l1, (String)localObject1);
        return;
        bool = ((Boolean)paramObject[1]).booleanValue();
        paramObject = (Object[])paramObject[2];
        a(((Long)paramObject[0]).longValue(), bool, ((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
        return;
        if (((Boolean)paramObject[1]).booleanValue())
        {
          paramObject = (Object[])paramObject[2];
          i = ((Integer)paramObject[0]).intValue();
          localObject1 = (String)paramObject[1];
          localObject2 = (String)paramObject[2];
          l1 = ((Long)paramObject[3]).longValue();
          if (QLog.isColorLevel()) {
            QLog.d("FMObserver<FileAssistant>", 2, "OnOfflineSendToWeiYunSuccess, nSessionId[" + String.valueOf(l1) + "]");
          }
          a(l1, (String)localObject2, i, (String)localObject1);
          return;
        }
        paramObject = (Object[])paramObject[2];
        i = ((Integer)paramObject[0]).intValue();
        localObject1 = (String)paramObject[1];
        localObject2 = (String)paramObject[2];
        l1 = ((Long)paramObject[3]).longValue();
        QLog.e("FMObserver<FileAssistant>", 1, "OnWeiYunSendToOfflineFaild, , nSessionId[" + String.valueOf(l1) + "], errorCode[" + String.valueOf(i) + "], strErrMsg[" + String.valueOf(localObject1) + "]");
        a(i, l1, (String)localObject1);
        return;
        if (((Boolean)paramObject[1]).booleanValue())
        {
          paramObject = (Object[])paramObject[2];
          localObject1 = new aqxx();
          ((aqxx)localObject1).jdField_a_of_type_JavaLangString = ((String)paramObject[0]);
          ((aqxx)localObject1).jdField_a_of_type_Int = ((Integer)paramObject[1]).intValue();
          ((aqxx)localObject1).jdField_b_of_type_JavaLangString = ((String)paramObject[2]);
          ((aqxx)localObject1).jdField_a_of_type_JavaLangObject = paramObject[3];
          QLog.i("FMObserver<FileAssistant>", 1, "OnThumbDownLoadSuccess,fileId[" + ((aqxx)localObject1).jdField_a_of_type_JavaLangString + "],filePath[" + ((aqxx)localObject1).jdField_b_of_type_JavaLangString + "]");
          if ((((aqxx)localObject1).jdField_a_of_type_JavaLangObject != null) && (((aqxx)localObject1).jdField_b_of_type_JavaLangString != null) && (((aqxx)localObject1).jdField_b_of_type_JavaLangString.length() > 0))
          {
            if (!(((aqxx)localObject1).jdField_a_of_type_JavaLangObject instanceof WeiYunFileInfo)) {
              break label3135;
            }
            ((WeiYunFileInfo)((aqxx)localObject1).jdField_a_of_type_JavaLangObject).h = ((aqxx)localObject1).jdField_b_of_type_JavaLangString;
          }
          for (;;)
          {
            a((aqxx)localObject1);
            return;
            if ((((aqxx)localObject1).jdField_a_of_type_JavaLangObject instanceof OfflineFileInfo)) {
              ((OfflineFileInfo)((aqxx)localObject1).jdField_a_of_type_JavaLangObject).c = ((aqxx)localObject1).jdField_b_of_type_JavaLangString;
            } else if ((((aqxx)localObject1).jdField_a_of_type_JavaLangObject instanceof FileManagerEntity)) {
              ((FileManagerEntity)((aqxx)localObject1).jdField_a_of_type_JavaLangObject).strThumbPath = ((aqxx)localObject1).jdField_b_of_type_JavaLangString;
            }
          }
        }
        localObject1 = (Object[])paramObject[2];
        localObject2 = (String)localObject1[0];
        paramObject = new aqxx();
        paramObject.jdField_b_of_type_JavaLangString = null;
        paramObject.jdField_a_of_type_JavaLangString = ((String)localObject2);
        paramObject.jdField_a_of_type_JavaLangObject = localObject1[1];
        localObject1 = new Handler();
        QLog.i("FMObserver<FileAssistant>", 1, "OnThumbDownLoadSuccess(faild),fileId[" + paramObject.jdField_a_of_type_JavaLangString + "],delay 1000ms");
        ((Handler)localObject1).postDelayed(new FMObserver.2(this, paramObject), 1000L);
        return;
        if (((Boolean)paramObject[1]).booleanValue())
        {
          paramObject = (String)paramObject[2];
          QLog.i("FMObserver<FileAssistant>", 1, "OnGetWeiYunPriviewUrlSuccess,strUrlString[" + paramObject + "]");
          a(paramObject);
          return;
        }
        paramObject = (Object[])paramObject[2];
        i = ((Integer)paramObject[0]).intValue();
        paramObject = (String)paramObject[1];
        QLog.e("FMObserver<FileAssistant>", 1, "OnGetWeiYunPriviewUrlFaild, , errorCode[" + String.valueOf(i) + "], strErrString[" + String.valueOf(paramObject) + "]");
        b(Integer.valueOf(i), paramObject);
        return;
        try
        {
          bool = ((Boolean)paramObject[1]).booleanValue();
          if (bool)
          {
            b();
            return;
          }
        }
        catch (Exception paramObject)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("FMObserver<FileAssistant>", 1, "OnRefreshList param error!");
            }
            bool = false;
          }
        }
      }
    case 19: 
      bool = ((Boolean)paramObject[1]).booleanValue();
      paramObject = (Object[])paramObject[2];
      i = ((Integer)paramObject[0]).intValue();
      localObject1 = (String)paramObject[1];
      l1 = ((Long)paramObject[2]).longValue();
      l2 = ((Long)paramObject[3]).longValue();
      localObject2 = (String)paramObject[4];
      long l3 = ((Long)paramObject[5]).longValue();
      QLog.i("FMObserver<FileAssistant>", 1, "OnForwardOfflineFile, bSuccess[" + String.valueOf(bool) + "], retCode[" + String.valueOf(i) + "], retMsg[" + String.valueOf(localObject1) + "], totalSpace[" + String.valueOf(l1) + "], usedSpace[" + String.valueOf(l2) + "], strUuid[" + String.valueOf(localObject2) + "], nSessionId[" + String.valueOf(l3) + "]");
      a(bool, i, (String)localObject1, l1, l2, (String)localObject2, l3);
      return;
    case 190: 
      bool = ((Boolean)paramObject[1]).booleanValue();
      localObject1 = (Object[])paramObject[2];
      localObject2 = (Integer)localObject1[0];
      localObject3 = (String)localObject1[1];
      paramObject = (Long)localObject1[2];
      if (!bool)
      {
        a(paramObject.longValue(), ((Integer)localObject2).intValue(), (String)localObject3);
        return;
      }
      localObject2 = (String)localObject1[3];
      localObject3 = (Integer)localObject1[4];
      localObject1 = (Long)localObject1[5];
      a(paramObject.longValue(), (String)localObject2, ((Integer)localObject3).intValue(), ((Long)localObject1).longValue());
      return;
    case 20: 
      bool = ((Boolean)paramObject[1]).booleanValue();
      localObject4 = (Object[])paramObject[2];
      paramObject = (Integer)localObject4[0];
      localObject1 = (String)localObject4[1];
      localObject2 = (String)localObject4[2];
      localObject3 = (String)localObject4[3];
      localObject4 = (Boolean)localObject4[4];
      if (!bool)
      {
        QLog.i("FMObserver<FileAssistant>", 1, "OnDelClouldFileFaild,  uuid[" + (String)localObject2 + "]strFileName[" + String.valueOf(localObject3) + "]errorCode[" + String.valueOf(paramObject) + "],retMsg[" + (String)localObject1 + "],bOffline[" + String.valueOf(localObject4) + "]");
        a((String)localObject2, (String)localObject3, paramObject, (String)localObject1, ((Boolean)localObject4).booleanValue());
        return;
      }
      QLog.i("FMObserver<FileAssistant>", 1, "OnDelClouldFileSuccess,  uuid[" + (String)localObject2 + "]strFileName[" + String.valueOf(localObject3) + "],bOffline[" + String.valueOf(localObject4) + "]");
      a((String)localObject2, (String)localObject3, ((Boolean)localObject4).booleanValue());
      return;
    case 41: 
      paramObject = (Long)((Object[])(Object[])paramObject[2])[0];
      QLog.i("FMObserver<FileAssistant>", 1, "OnOnlineFileProgressDirectDone, nSessionId=" + paramObject);
      a(paramObject.longValue());
      return;
    case 42: 
      paramObject = (Long)((Object[])(Object[])paramObject[2])[0];
      QLog.i("FMObserver<FileAssistant>", 1, "OnOnlineFileRecvButSenderReplayTimeOut, nSessionId=" + paramObject);
      b(paramObject.longValue());
      return;
    case 43: 
      paramObject = (Long)((Object[])(Object[])paramObject[2])[0];
      QLog.i("FMObserver<FileAssistant>", 1, "OnOnlineFileQueryUpProgressTimeOut, nSessionId=" + paramObject);
      c(paramObject.longValue());
      return;
    case 44: 
      bool = ((Boolean)paramObject[1]).booleanValue();
      paramObject = (Object[])paramObject[2];
      localObject1 = (Integer)paramObject[0];
      localObject2 = (String)paramObject[1];
      if (!bool)
      {
        QLog.i("FMObserver<FileAssistant>", 1, "OnNeedVerifyPwdFailed");
        b(((Integer)localObject1).intValue(), (String)localObject2);
        return;
      }
      paramObject = (Boolean)paramObject[2];
      QLog.i("FMObserver<FileAssistant>", 1, "OnNeedVerifyPwdSuccess,  need verify[" + paramObject + "]");
      a(paramObject.booleanValue());
      return;
    case 45: 
      bool = ((Boolean)paramObject[1]).booleanValue();
      localObject1 = (Object[])paramObject[2];
      paramObject = (Integer)localObject1[0];
      localObject1 = (String)localObject1[1];
      if (!bool)
      {
        QLog.i("FMObserver<FileAssistant>", 1, "OnVerifyPwdFailed");
        a(paramObject.intValue(), (String)localObject1);
        return;
      }
      QLog.i("FMObserver<FileAssistant>", 1, "OnVerifyPwdSuccess");
      e();
      return;
    case 50: 
    case 51: 
      label3135:
      bool = ((Boolean)paramObject[1]).booleanValue();
      localObject1 = (Object[])paramObject[2];
      paramObject = (FileManagerEntity)localObject1[0];
      if (localObject1.length <= 1) {
        break;
      }
    }
    for (i = ((Integer)localObject1[1]).intValue();; i = 0)
    {
      if (bool)
      {
        localObject1 = new aqxx();
        ((aqxx)localObject1).jdField_a_of_type_JavaLangObject = paramObject;
        ((aqxx)localObject1).jdField_a_of_type_JavaLangString = paramObject.Uuid;
        ((aqxx)localObject1).jdField_b_of_type_Int = i;
        if (i == 7) {
          ((aqxx)localObject1).jdField_b_of_type_JavaLangString = paramObject.strLargeThumPath;
        }
        for (;;)
        {
          ((aqxx)localObject1).jdField_a_of_type_Long = paramObject.nSessionId;
          a((aqxx)localObject1);
          return;
          if (i == 5) {
            ((aqxx)localObject1).jdField_b_of_type_JavaLangString = paramObject.strMiddleThumPath;
          } else {
            ((aqxx)localObject1).jdField_b_of_type_JavaLangString = paramObject.strThumbPath;
          }
        }
      }
      localObject1 = new aqxx();
      ((aqxx)localObject1).jdField_a_of_type_JavaLangObject = paramObject;
      ((aqxx)localObject1).jdField_a_of_type_JavaLangString = paramObject.Uuid;
      ((aqxx)localObject1).jdField_b_of_type_JavaLangString = null;
      ((aqxx)localObject1).jdField_b_of_type_Int = i;
      ((aqxx)localObject1).jdField_a_of_type_Long = paramObject.nSessionId;
      a((aqxx)localObject1);
      return;
      ((Boolean)paramObject[1]).booleanValue();
      localObject1 = (Object[])paramObject[2];
      paramObject = (FileManagerEntity)localObject1[0];
      i = ((Integer)localObject1[1]).intValue();
      localObject1 = new aqxx();
      ((aqxx)localObject1).jdField_a_of_type_JavaLangObject = paramObject;
      ((aqxx)localObject1).jdField_a_of_type_JavaLangString = paramObject.Uuid;
      ((aqxx)localObject1).jdField_b_of_type_JavaLangString = null;
      ((aqxx)localObject1).jdField_a_of_type_Long = paramObject.nSessionId;
      a((aqxx)localObject1, i);
      return;
      bool = ((Boolean)paramObject[1]).booleanValue();
      localObject6 = (Object[])paramObject[2];
      i = ((Integer)localObject6[0]).intValue();
      paramObject = (String)localObject6[1];
      localObject1 = (String)localObject6[2];
      localObject2 = (String)localObject6[3];
      localObject3 = (String)localObject6[4];
      localObject4 = (String)localObject6[5];
      j = ((Integer)localObject6[6]).intValue();
      localObject5 = (String)localObject6[7];
      l1 = ((Long)localObject6[8]).longValue();
      localObject6 = (Bundle)localObject6[9];
      QLog.i("FMObserver<FileAssistant>", 1, "OnGetOfflineVideoThumbInfo retCode[" + String.valueOf(i) + "],retMsg[" + paramObject + "], downloadKey[" + (String)localObject2 + "], downloadIp[" + (String)localObject3 + "], downloadDomain[" + (String)localObject4 + "], port[" + String.valueOf(j) + "]");
      a(bool, i, paramObject, (String)localObject1, (String)localObject2, (String)localObject3, (String)localObject4, j, (String)localObject5, l1, (Bundle)localObject6);
      return;
      bool = ((Boolean)paramObject[1]).booleanValue();
      localObject6 = (Object[])paramObject[2];
      i = ((Integer)localObject6[0]).intValue();
      paramObject = (String)localObject6[1];
      localObject1 = (String)localObject6[2];
      localObject2 = (String)localObject6[3];
      localObject3 = (String)localObject6[4];
      localObject4 = (String)localObject6[5];
      j = ((Integer)localObject6[6]).intValue();
      localObject5 = (String)localObject6[7];
      l1 = ((Long)localObject6[8]).longValue();
      localObject6 = (Bundle)localObject6[9];
      QLog.i("FMObserver<FileAssistant>", 1, "OnGetDiscVideoThumbInfo retCode[" + String.valueOf(i) + "],retMsg[" + paramObject + "], downloadKey[" + (String)localObject2 + "], downloadIp[" + (String)localObject3 + "], downloadDomain[" + (String)localObject4 + "], port[" + String.valueOf(j) + "]");
      b(bool, i, paramObject, (String)localObject1, (String)localObject2, (String)localObject3, (String)localObject4, j, (String)localObject5, l1, (Bundle)localObject6);
      return;
      bool = ((Boolean)paramObject[1]).booleanValue();
      localObject1 = (Object[])paramObject[2];
      l1 = ((Long)localObject1[0]).longValue();
      i = ((Integer)localObject1[1]).intValue();
      paramObject = (String)localObject1[2];
      localObject1 = (String)localObject1[3];
      QLog.i("FMObserver<FileAssistant>", 1, "OnZipImageThumbDownloadCompleted thumbUrl[" + (String)localObject1 + "]");
      a(bool, i, l1, (String)localObject1, paramObject);
      return;
    }
  }
  
  protected void a() {}
  
  protected void a(int paramInt, long paramLong, String paramString) {}
  
  protected void a(int paramInt, String paramString) {}
  
  protected void a(int paramInt, String paramString1, String paramString2) {}
  
  protected void a(long paramLong) {}
  
  protected void a(long paramLong, int paramInt, String paramString) {}
  
  protected void a(long paramLong1, long paramLong2) {}
  
  protected void a(long paramLong1, long paramLong2, String paramString, int paramInt) {}
  
  protected void a(long paramLong1, String paramString, int paramInt, long paramLong2) {}
  
  protected void a(long paramLong, String paramString1, int paramInt, String paramString2) {}
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt, String paramString) {}
  
  public void a(aqxx paramaqxx) {}
  
  protected void a(aqxx paramaqxx, int paramInt) {}
  
  protected void a(Boolean paramBoolean, List<OfflineFileInfo> paramList) {}
  
  protected void a(Integer paramInteger, long paramLong, String paramString) {}
  
  protected void a(Integer paramInteger, String paramString) {}
  
  protected void a(String paramString) {}
  
  protected void a(String paramString1, String paramString2, Integer paramInteger, String paramString3, boolean paramBoolean) {}
  
  protected void a(String paramString1, String paramString2, boolean paramBoolean) {}
  
  protected void a(String paramString1, boolean paramBoolean, int paramInt1, String paramString2, List<WeiYunFileInfo> paramList, int paramInt2) {}
  
  protected void a(List<Object> paramList) {}
  
  protected void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, String paramString1, String paramString2) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString1, long paramLong1, long paramLong2, String paramString2, long paramLong3) {}
  
  protected void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6) {}
  
  protected void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, long paramLong, Bundle paramBundle) {}
  
  protected void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, Bundle paramBundle) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2) {}
  
  protected void b() {}
  
  protected void b(int paramInt, String paramString) {}
  
  protected void b(long paramLong) {}
  
  protected void b(long paramLong1, long paramLong2, String paramString, int paramInt) {}
  
  protected void b(Integer paramInteger, String paramString) {}
  
  protected void b(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, long paramLong, Bundle paramBundle) {}
  
  protected void b(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, Bundle paramBundle) {}
  
  protected void c() {}
  
  protected void c(int paramInt, String paramString) {}
  
  protected void c(long paramLong) {}
  
  protected void d() {}
  
  protected void d(int paramInt, String paramString) {}
  
  protected void e() {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = Looper.getMainLooper();
    if (Thread.currentThread() != paramObservable.getThread())
    {
      new Handler(paramObservable).post(new FMObserver.1(this, paramObject));
      return;
    }
    a(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqnl
 * JD-Core Version:    0.7.0.1
 */