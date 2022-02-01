import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader.1;
import com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader.2;
import com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader.3;
import com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader.4;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class atud
  extends atub
{
  private SparseArray<String> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private atrl jdField_a_of_type_Atrl = new atue(this);
  
  public atud(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    b();
  }
  
  private atuf a(long paramLong, boolean paramBoolean)
  {
    atuc localatuc = a(paramLong);
    if (localatuc == null) {
      return null;
    }
    if ((localatuc instanceof atuf)) {
      return (atuf)localatuc;
    }
    QLog.e("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb] getSession  ID[" + paramLong + "] no instance");
    return null;
  }
  
  private void a(int paramInt, atuf paramatuf, atyq paramatyq)
  {
    switch (paramInt)
    {
    }
    label333:
    label483:
    label499:
    do
    {
      return;
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      long l1 = paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
      long l2 = paramatuf.b;
      Object localObject3 = paramatyq.jdField_a_of_type_JavaLangString;
      String str1 = paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
      String str2 = paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
      String str3 = paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
      long l3 = paramatyq.e;
      long l4 = paramatyq.jdField_c_of_type_Long;
      long l5 = paramatuf.jdField_a_of_type_Int;
      String str4 = paramatyq.jdField_a_of_type_JavaLangString;
      Object localObject1;
      if (paramatyq.jdField_b_of_type_Bhva != null)
      {
        localObject1 = paramatyq.jdField_b_of_type_Bhva.d;
        aunj.a((QQAppInterface)localObject2, l1, "actFileDiscThumb", l2, (String)localObject3, str1, str2, str3, 9004L, "no network", l3, l4, l5, str4, (String)localObject1, paramatyq.jdField_b_of_type_Int, "no network", "");
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        l1 = paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
        l2 = paramatuf.b;
        localObject2 = paramatyq.jdField_a_of_type_JavaLangString;
        localObject3 = paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
        str1 = paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
        str2 = paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
        l3 = paramatyq.e;
        l4 = paramatyq.jdField_c_of_type_Long;
        l5 = paramatuf.jdField_a_of_type_Int;
        str3 = paramatyq.jdField_a_of_type_JavaLangString;
        if (paramatyq.jdField_b_of_type_Bhva == null) {
          break label333;
        }
      }
      for (paramatuf = paramatyq.jdField_b_of_type_Bhva.d;; paramatuf = "respose null")
      {
        aunj.a((QQAppInterface)localObject1, l1, "actFileDiscThumbDetail", l2, (String)localObject2, (String)localObject3, str1, str2, 9004L, "no network", l3, l4, l5, str3, paramatuf, paramatyq.jdField_c_of_type_Int, "no network", "");
        return;
        localObject1 = "respose null";
        break;
      }
      aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumb", paramatuf.b, paramatyq.jdField_a_of_type_JavaLangString, paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "FileNotFoundException", 0L, 0L, 0L, paramatyq.jdField_a_of_type_JavaLangString, "", 0, "FileNotFoundException", "");
      aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumbDetail", paramatuf.b, paramatyq.jdField_a_of_type_JavaLangString, paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "FileNotFoundException", 0L, 0L, 0L, paramatyq.jdField_a_of_type_JavaLangString, "", 0, "size error", "");
      return;
      long l6;
      String str5;
      if (paramatyq.jdField_b_of_type_Bhva != null)
      {
        paramInt = paramatyq.jdField_b_of_type_Bhva.f;
        if (paramatyq.jdField_b_of_type_Bhva == null) {
          break label800;
        }
        localObject1 = paramatyq.jdField_b_of_type_Bhva.d();
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        l1 = paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
        l2 = paramatuf.b;
        str1 = paramatyq.jdField_a_of_type_JavaLangString;
        str2 = paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
        str3 = paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
        str4 = paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
        l3 = paramInt;
        l4 = paramatyq.e;
        l5 = paramatyq.jdField_c_of_type_Long;
        l6 = paramatyq.jdField_a_of_type_Int;
        str5 = paramatyq.jdField_a_of_type_JavaLangString;
        if (paramatyq.jdField_b_of_type_Bhva == null) {
          break label807;
        }
        localObject2 = paramatyq.jdField_b_of_type_Bhva.d;
        aunj.a((QQAppInterface)localObject3, l1, "actFileDiscThumb", l2, str1, str2, str3, str4, l3, (String)localObject1, l4, l5, l6, str5, (String)localObject2, paramatyq.jdField_b_of_type_Int, (String)localObject1, "");
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        l1 = paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
        l2 = paramatuf.b;
        str1 = paramatyq.jdField_a_of_type_JavaLangString;
        str2 = paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
        str3 = paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
        str4 = paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
        l3 = paramInt;
        l4 = paramatyq.e;
        l5 = paramatyq.jdField_c_of_type_Long;
        l6 = paramatyq.jdField_a_of_type_Int;
        str5 = paramatyq.jdField_a_of_type_JavaLangString;
        if (paramatyq.jdField_b_of_type_Bhva == null) {
          break label814;
        }
      }
      for (localObject2 = paramatyq.jdField_b_of_type_Bhva.d;; localObject2 = "respose null")
      {
        aunj.a((QQAppInterface)localObject3, l1, "actFileDiscThumbDetail", l2, str1, str2, str3, str4, l3, (String)localObject1, l4, l5, l6, str5, (String)localObject2, paramatyq.jdField_c_of_type_Int, (String)localObject1, "");
        if (paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
          break;
        }
        paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.thumbInvalidCode = 2;
        return;
        paramInt = 0;
        break label483;
        localObject1 = "http resp err";
        break label499;
        localObject2 = "respose null";
        break label598;
      }
      aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumb", paramatuf.b, paramatyq.jdField_a_of_type_JavaLangString, paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, "noRs", 0L, 0L, 0L, paramatyq.jdField_a_of_type_JavaLangString, "", 0, "noRs", "");
      aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumbDetail", paramatuf.b, paramatyq.jdField_a_of_type_JavaLangString, paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, "noRs", paramatyq.e, paramatyq.jdField_c_of_type_Long, paramatyq.jdField_a_of_type_Int, paramatyq.jdField_a_of_type_JavaLangString, "", 0, "noRs", "");
      return;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      l1 = paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
      l2 = paramatuf.b;
      localObject3 = paramatyq.jdField_a_of_type_JavaLangString;
      str1 = paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
      str2 = paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
      str3 = paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
      l3 = paramatyq.jdField_c_of_type_Long;
      l4 = paramatyq.jdField_a_of_type_Int;
      str4 = paramatyq.jdField_a_of_type_JavaLangString;
      if (paramatyq.jdField_b_of_type_Bhva != null)
      {
        localObject1 = paramatyq.jdField_b_of_type_Bhva.d;
        aunj.a((QQAppInterface)localObject2, l1, "actFileDiscThumb", l2, (String)localObject3, str1, str2, str3, 9003L, "revStream write Exception", 0L, l3, l4, str4, (String)localObject1, paramatyq.jdField_b_of_type_Int, "revStream write Exception", "");
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        l1 = paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
        l2 = paramatuf.b;
        localObject2 = paramatyq.jdField_a_of_type_JavaLangString;
        localObject3 = paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
        str1 = paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
        str2 = paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
        l3 = paramatyq.jdField_c_of_type_Long;
        l4 = paramatyq.jdField_a_of_type_Int;
        str3 = paramatyq.jdField_a_of_type_JavaLangString;
        if (paramatyq.jdField_b_of_type_Bhva == null) {
          break label1226;
        }
      }
      for (paramatuf = paramatyq.jdField_b_of_type_Bhva.d;; paramatuf = "respose null")
      {
        aunj.a((QQAppInterface)localObject1, l1, "actFileDiscThumbDetail", l2, (String)localObject2, (String)localObject3, str1, str2, 9003L, "revStream write Exception", 0L, l3, l4, str3, paramatuf, paramatyq.jdField_c_of_type_Int, "revStream write Exception", "");
        return;
        localObject1 = "respose null";
        break;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      l1 = paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
      l2 = paramatuf.b;
      localObject3 = paramatyq.jdField_a_of_type_JavaLangString;
      str1 = paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
      str2 = paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
      str3 = paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
      l3 = paramatyq.e;
      l4 = paramatyq.jdField_c_of_type_Long;
      l5 = paramatyq.jdField_a_of_type_Int;
      str4 = paramatyq.jdField_a_of_type_JavaLangString;
      if (paramatyq.jdField_b_of_type_Bhva != null)
      {
        localObject1 = paramatyq.jdField_b_of_type_Bhva.d;
        aunj.a((QQAppInterface)localObject2, l1, "actFileDiscThumb", l2, (String)localObject3, str1, str2, str3, 9003L, "rename error", l3, l4, l5, str4, (String)localObject1, paramatyq.jdField_b_of_type_Int, "rename error", "");
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        l1 = paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
        l2 = paramatuf.b;
        localObject2 = paramatyq.jdField_a_of_type_JavaLangString;
        localObject3 = paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
        str1 = paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
        str2 = paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
        l3 = paramatyq.e;
        l4 = paramatyq.jdField_c_of_type_Long;
        l5 = paramatyq.jdField_a_of_type_Int;
        str3 = paramatyq.jdField_a_of_type_JavaLangString;
        if (paramatyq.jdField_b_of_type_Bhva == null) {
          break label1512;
        }
      }
      for (paramatuf = paramatyq.jdField_b_of_type_Bhva.d;; paramatuf = "respose null")
      {
        aunj.a((QQAppInterface)localObject1, l1, "actFileDiscThumbDetail", l2, (String)localObject2, (String)localObject3, str1, str2, 9003L, "rename error", l3, l4, l5, str3, paramatuf, paramatyq.jdField_c_of_type_Int, "rename error", "");
        return;
        localObject1 = "respose null";
        break;
      }
    } while (paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null);
    label598:
    label1512:
    paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.thumbInvalidCode = 1;
    label800:
    label807:
    label814:
    label1226:
    return;
  }
  
  private void a(long paramLong1, String paramString1, String paramString2, ByteStringMicro paramByteStringMicro, boolean paramBoolean, String paramString3, short paramShort, String paramString4, String paramString5, long paramLong2, Bundle paramBundle)
  {
    if (paramBoolean) {
      paramString4 = paramString4 + "&isthumb=1";
    }
    for (;;)
    {
      atuf localatuf = a(paramLong2, false);
      if (localatuf == null)
      {
        QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "onUpdateGetOfflineDownloadInfo, mapDowload is not existed taskid[" + String.valueOf(paramLong2) + "]");
        a(paramLong2, false, null, 0, null, null, paramString2, false, null, (short)0, null);
        return;
      }
      if ((TextUtils.isEmpty(localatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5)) && (!TextUtils.isEmpty(paramString5))) {
        localatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 = paramString5;
      }
      aunj.a(localatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null);
      if (paramLong1 != 0L)
      {
        QLog.e("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong2 + "] OnDiscDownloadInfo isSuccess[false],retCode[" + String.valueOf(paramLong1) + "],retMsg[" + String.valueOf(paramString1) + "]");
        if (paramLong1 == -100001L) {}
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 51, new Object[] { localatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, Integer.valueOf(localatuf.jdField_a_of_type_Int) });
          a(paramLong2);
          a(paramLong2, false, null, 0, null, null, paramString2, false, null, (short)0, null);
          return;
          if ((paramLong1 == -25081L) || (paramLong1 == -6101L) || (paramLong1 == -7003L))
          {
            localatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
          }
        }
      }
      if ((paramString3 == null) || (paramByteStringMicro == null))
      {
        QLog.i("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong2 + "]  get DiscdownLoad info Url is null ");
        if ((paramLong1 == -25081L) || (paramLong1 == -6101L) || (paramLong1 == -7003L))
        {
          localatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        }
        a(paramLong2);
        a(paramLong2, false, null, 0, null, null, paramString2, false, null, (short)0, null);
        return;
      }
      if ((TextUtils.isEmpty(localatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5)) && (!TextUtils.isEmpty(paramString5))) {
        localatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 = paramString5;
      }
      paramString1 = (String)this.jdField_a_of_type_AndroidUtilSparseArray.get(localatuf.jdField_a_of_type_Int, "");
      if (TextUtils.isEmpty(paramString1))
      {
        QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong2 + "] unknow thumbSize!!!info:" + localatuf.toString());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 51, new Object[] { localatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, Integer.valueOf(localatuf.jdField_a_of_type_Int) });
        a(paramLong2);
        a(paramLong2, false, paramString3, paramShort, paramString4, null, paramString2, false, null, (short)0, null);
        return;
      }
      paramString5 = paramString4 + paramString1;
      boolean bool1 = false;
      short s1 = 0;
      if ((atyt.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (paramBundle != null))
      {
        paramByteStringMicro = paramBundle.getString("strHttpsDomain");
        if (!TextUtils.isEmpty(paramByteStringMicro))
        {
          boolean bool2 = true;
          short s2 = paramBundle.getShort("httpsPort", (short)0);
          bool1 = bool2;
          paramString1 = paramByteStringMicro;
          s1 = s2;
          if (s2 == 0)
          {
            s1 = 443;
            paramString1 = paramByteStringMicro;
            bool1 = bool2;
          }
        }
      }
      for (;;)
      {
        paramString4 = "";
        paramByteStringMicro = null;
        if (paramBundle != null)
        {
          paramString4 = paramBundle.getString("IPv6Dns");
          paramByteStringMicro = paramBundle.getStringArrayList("ipv6list");
        }
        paramBundle = new Bundle();
        paramBundle.putBoolean("usemediaplatform", paramBoolean);
        if ((paramByteStringMicro != null) && (paramByteStringMicro.size() > 0)) {
          paramBundle.putStringArrayList("ipv6list", paramByteStringMicro);
        }
        a(paramLong2, true, paramString3, paramShort, paramString5, null, paramString2, bool1, paramString1, s1, paramString4, paramBundle);
        return;
        paramString1 = null;
      }
    }
  }
  
  private void a(atuf paramatuf, String paramString, atyq paramatyq)
  {
    aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumb", System.currentTimeMillis() - paramatuf.b, paramatyq.jdField_a_of_type_JavaLangString, paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramatyq.e, paramatyq.jdField_c_of_type_Long, paramatyq.jdField_a_of_type_Int, paramatyq.jdField_b_of_type_Int, null);
    if (paramatuf.jdField_a_of_type_Int == 7)
    {
      paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strLargeThumPath = paramString;
      aunj.d(paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      ThreadManager.post(new DiscPicThumbDownloader.3(this, paramatuf), 8, null, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return;
      if (paramatuf.jdField_a_of_type_Int == 5)
      {
        paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strMiddleThumPath = paramString;
        aunj.d(paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        if (auob.b(paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity)) {
          ThreadManager.post(new DiscPicThumbDownloader.4(this, paramatuf), 8, null, false);
        }
      }
      else
      {
        paramatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strThumbPath = paramString;
      }
    }
  }
  
  private String b(int paramInt, String paramString)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "x-dsc-";
    }
    for (;;)
    {
      return str + paramString;
      str = "micro-dsc-";
      continue;
      str = "minni-dsc-";
      continue;
      str = "small-dsc-";
      continue;
      str = "middle-dsc-";
      continue;
      str = "large-dsc-";
      continue;
      str = "qlarge-dsc-";
      continue;
      str = "xlarge-dsc-";
      continue;
      str = "qxlarge-dsc-";
      continue;
      str = "screen-dsc-";
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(0, "?pictype=scaled&size=16*16");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1, "?pictype=scaled&size=32*32");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(2, "?pictype=scaled&size=64*64");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(3, "?pictype=scaled&size=128*128");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(4, "?pictype=scaled&size=320*320");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(5, "?pictype=scaled&size=384*384");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(6, "?pictype=scaled&size=640*640");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(7, "?pictype=scaled&size=750*750");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(8, "?pictype=scaled&size=1024*1024");
  }
  
  public String a(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    if (TextUtils.isEmpty(paramFileManagerEntity.Uuid))
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb]  download. uuid = null nSession[" + paramFileManagerEntity.nSessionId + "]");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 50, new Object[] { paramFileManagerEntity, Integer.valueOf(paramInt) });
      return null;
    }
    a();
    if ((TextUtils.isEmpty(paramFileManagerEntity.Uuid)) && (QLog.isDevelopLevel())) {
      throw new NullPointerException("uuid is null!!!");
    }
    String str = aumo.a().d() + b(paramInt, blev.a(paramFileManagerEntity.Uuid));
    if ((!auog.b(str)) && (!TextUtils.isEmpty(paramFileManagerEntity.strFileMd5))) {
      str = aumo.a().d() + b(paramInt, blev.a(paramFileManagerEntity.strFileMd5));
    }
    for (;;)
    {
      if (bhmi.b(str) == true)
      {
        if (paramInt == 7)
        {
          paramFileManagerEntity.strLargeThumPath = str;
          if (auob.b(paramFileManagerEntity)) {
            ThreadManager.post(new DiscPicThumbDownloader.1(this, paramFileManagerEntity), 8, null, false);
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramFileManagerEntity);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 50, new Object[] { paramFileManagerEntity, Integer.valueOf(paramInt) });
          QLog.e("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb] Id[" + paramFileManagerEntity.nSessionId + "] thumb Downloaded:" + str);
          aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileDiscThumb", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, 0L, 0L, 0L, 0, null);
          return str;
          if (paramInt == 5)
          {
            paramFileManagerEntity.strMiddleThumPath = str;
            if (auob.b(paramFileManagerEntity)) {
              ThreadManager.post(new DiscPicThumbDownloader.2(this, paramFileManagerEntity), 8, null, false);
            }
          }
          else
          {
            paramFileManagerEntity.strThumbPath = str;
          }
        }
      }
      atuf localatuf = new atuf(paramFileManagerEntity);
      localatuf.jdField_a_of_type_Int = paramInt;
      a(localatuf, str);
      QLog.i("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb] download  nSession[" + paramFileManagerEntity.nSessionId + "], ThumbDownloadId[" + localatuf.jdField_a_of_type_Long + "]");
      return null;
    }
  }
  
  public List<String> a(long paramLong, String paramString, int paramInt, boolean paramBoolean, List<String> paramList)
  {
    Object localObject = a(paramLong, false);
    int i;
    if ((localObject != null) && (((atuf)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null))
    {
      if (((atuf)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 3000) {}
      for (i = 5; !atul.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i); i = 1) {
        return null;
      }
      if ((!paramBoolean) || (paramList == null) || (paramList.size() <= 0)) {
        break label333;
      }
      QLog.i("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] [IPv6-File] image thumb mediaplatform. is config enable IPv6. v6ipsize[" + paramList.size() + "] busiType:" + i);
      paramString = atul.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, paramList);
      if ((paramString != null) && (paramString.size() > 0))
      {
        paramList = new ArrayList();
        int j = paramString.size();
        i = 0;
        while (i < j)
        {
          localObject = (String)paramString.get(i);
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            paramList.add(0, "[" + (String)localObject + "]:" + paramInt);
          }
          i += 1;
        }
        QLog.i("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] [IPv6-File] image thumb mediaplatform. use IPv6. hostlist:" + paramList.toString());
        return paramList;
      }
      QLog.i("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] [IPv6-File] image thumb mediaplatform. use IPv4:");
    }
    for (;;)
    {
      return null;
      label333:
      if (!TextUtils.isEmpty(paramString))
      {
        QLog.i("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] [IPv6-File] image thumb. is config enable IPv6. domain[" + paramString + "] busiType:" + i);
        paramString = new atum(paramString, paramInt);
        paramList = atul.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, i);
        if ((paramList != null) && (!paramList.a()))
        {
          paramString = new ArrayList();
          paramList = paramList.a.iterator();
          while (paramList.hasNext())
          {
            localObject = (atun)paramList.next();
            paramString.add(((atun)localObject).jdField_a_of_type_JavaLangString + ":" + ((atun)localObject).jdField_a_of_type_Int);
          }
          QLog.i("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] [IPv6-File] image thumb. use IPv6. hostlist:" + paramString.toString());
          return paramString;
        }
        QLog.i("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] [IPv6-File] image thumb. use IPv4:");
      }
    }
  }
  
  public void a(long paramLong, int paramInt, atyq paramatyq)
  {
    paramatyq = a(paramLong, false);
    if (paramatyq == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 52, new Object[] { paramatyq.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, Integer.valueOf(paramInt) });
  }
  
  public void a(long paramLong, atyq paramatyq)
  {
    Object localObject = a(paramLong, false);
    if (localObject == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    int i;
    String str1;
    label77:
    QQAppInterface localQQAppInterface;
    long l1;
    String str2;
    String str3;
    String str4;
    String str5;
    long l2;
    long l3;
    long l4;
    long l5;
    String str6;
    if (paramatyq.jdField_b_of_type_Bhva != null)
    {
      i = paramatyq.jdField_b_of_type_Bhva.f;
      if (paramatyq.jdField_b_of_type_Bhva == null) {
        break label228;
      }
      str1 = paramatyq.jdField_b_of_type_Bhva.d();
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      paramLong = ((atuf)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
      l1 = ((atuf)localObject).b;
      str2 = paramatyq.jdField_a_of_type_JavaLangString;
      str3 = ((atuf)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
      str4 = ((atuf)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
      str5 = ((atuf)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
      l2 = i;
      l3 = paramatyq.e;
      l4 = paramatyq.jdField_c_of_type_Long;
      l5 = paramatyq.jdField_a_of_type_Int;
      str6 = paramatyq.jdField_a_of_type_JavaLangString;
      if (paramatyq.jdField_b_of_type_Bhva == null) {
        break label236;
      }
    }
    label228:
    label236:
    for (localObject = paramatyq.jdField_b_of_type_Bhva.d;; localObject = "respose null")
    {
      aunj.a(localQQAppInterface, paramLong, "actFileDiscThumbDetail", l1, str2, str3, str4, str5, l2, str1, l3, l4, l5, str6, (String)localObject, paramatyq.jdField_c_of_type_Int, str1, "");
      return;
      i = 0;
      break;
      str1 = "start retry";
      break label77;
    }
  }
  
  public void a(long paramLong, bhva parambhva)
  {
    atuf localatuf = a(paramLong, false);
    if (localatuf == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onSetHttpMsg no this session");
      return;
    }
    parambhva.jdField_c_of_type_Int = 3000;
    parambhva.a("Cookie", localatuf.jdField_a_of_type_JavaLangString);
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, String paramString, atyq paramatyq)
  {
    atuf localatuf = a(paramLong, false);
    if (localatuf == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    if (paramBoolean) {
      a(localatuf, paramString, paramatyq);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramBoolean, 50, new Object[] { localatuf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, Integer.valueOf(localatuf.jdField_a_of_type_Int) });
      super.a(paramLong, paramBoolean, paramInt, paramString, paramatyq);
      return;
      a(paramInt, localatuf, paramatyq);
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, long paramLong2, Bundle paramBundle)
  {
    Object localObject = a(paramLong2, false);
    if (localObject == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "OnDiscDownloadInfo, mapDowload is not existed taskid[" + String.valueOf(paramLong2) + "]");
      aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0L, "actFileDiscThumb", 0L, "", "", "", "", 9005L, "get info null", 0L, 0L, 0L, "", "", 0, "get info null", "");
      aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0L, "actFileDiscThumbDetail", 0L, "", "", "", "", 9005L, "get info null", 0L, 0L, 0L, "", "", 0, "get info null", "");
      a(paramLong2, false, null, 0, null, null, paramString4, false, null, (short)0, null);
      return;
    }
    if (!paramBoolean)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong2 + "] OnDiscDownloadInfo isSuccess[false],retCode[" + String.valueOf(paramLong1) + "],retMsg[" + String.valueOf(paramString1) + "]");
      long l = 0L;
      if (paramLong1 == -100001L) {
        l = 9043L;
      }
      for (;;)
      {
        aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((atuf)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumb", ((atuf)localObject).b, "", ((atuf)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, ((atuf)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, ((atuf)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, l, String.valueOf(paramInt2) + "&" + String.valueOf(paramLong1), 0L, 0L, 0L, "", "", 0, "ret error", null);
        aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((atuf)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumbDetail", ((atuf)localObject).b, "", ((atuf)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, ((atuf)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, ((atuf)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, l, String.valueOf(paramInt2) + "&" + String.valueOf(paramLong1), 0L, 0L, 0L, "", "", 0, "ret error", null);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 50, new Object[] { ((atuf)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, Integer.valueOf(((atuf)localObject).jdField_a_of_type_Int) });
        a(paramLong2);
        a(paramLong2, false, null, 0, null, null, paramString4, false, null, (short)0, null);
        return;
        if ((paramLong1 == -25081L) || (paramLong1 == -6101L) || (paramLong1 == -7003L))
        {
          ((atuf)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(((atuf)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        }
        else
        {
          l = 9045L;
        }
      }
    }
    ((atuf)localObject).jdField_a_of_type_JavaLangString = paramString4;
    paramString1 = (String)this.jdField_a_of_type_AndroidUtilSparseArray.get(((atuf)localObject).jdField_a_of_type_Int, "");
    if (TextUtils.isEmpty(paramString1))
    {
      paramString1 = "http://" + paramString2 + ":" + String.valueOf(paramInt1) + "/ftn_handler/" + paramString3;
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong2 + "] unknow thumbSize!!!info:" + localObject.toString());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 50, new Object[] { ((atuf)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, Integer.valueOf(((atuf)localObject).jdField_a_of_type_Int) });
      aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((atuf)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumb", ((atuf)localObject).b, paramString1, ((atuf)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, ((atuf)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, ((atuf)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, "size error", 0L, 0L, 0L, paramString1, "", 0, "size error", "");
      aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((atuf)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumbDetail", ((atuf)localObject).b, paramString1, ((atuf)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, ((atuf)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, ((atuf)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, "size error", 0L, 0L, 0L, paramString1, "", 0, "size error", "");
      a(paramLong2);
      a(paramLong2, false, paramString2, paramInt1, "/ftn_handler/" + paramString3, null, paramString4, false, null, (short)0, null);
      return;
    }
    localObject = "/ftn_handler/" + paramString3 + paramString1;
    paramBoolean = false;
    short s1 = 0;
    if ((atyt.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (paramBundle != null))
    {
      paramString3 = paramBundle.getString("strHttpsDomain");
      if (!TextUtils.isEmpty(paramString3))
      {
        boolean bool = true;
        short s2 = paramBundle.getShort("httpsPort", (short)0);
        paramBoolean = bool;
        paramString1 = paramString3;
        s1 = s2;
        if (s2 == 0)
        {
          s1 = 443;
          paramString1 = paramString3;
          paramBoolean = bool;
        }
      }
    }
    for (;;)
    {
      paramString3 = "";
      if (paramBundle != null) {
        paramString3 = paramBundle.getString("IPv6Dns");
      }
      a(paramLong2, true, paramString2, paramInt1, (String)localObject, null, paramString4, paramBoolean, paramString1, s1, paramString3);
      return;
      paramString1 = null;
    }
  }
  
  public boolean a(long paramLong, atyq paramatyq)
  {
    paramatyq = a(paramLong, false);
    if (paramatyq == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onGetDownloadUrl no this session");
      return false;
    }
    if (paramatyq.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 3000) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong, paramatyq.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, Long.parseLong(paramatyq.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin), paramatyq.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_Atrl);
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong, paramatyq.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, paramatyq.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileIdCrc, paramatyq.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend, this.jdField_a_of_type_Atrl);
    }
  }
  
  public void b(long paramLong, atyq paramatyq) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atud
 * JD-Core Version:    0.7.0.1
 */