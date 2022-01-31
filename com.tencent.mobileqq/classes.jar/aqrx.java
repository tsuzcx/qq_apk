import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class aqrx
  extends aqpg
{
  aqrx(aqrw paramaqrw) {}
  
  protected void a(boolean paramBoolean, long paramLong1, String paramString1, String paramString2, ByteStringMicro paramByteStringMicro, String paramString3, short paramShort, String paramString4, List<String> paramList, int paramInt, String paramString5, String paramString6, String paramString7, long paramLong2, Bundle paramBundle)
  {
    QLog.i("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong2 + "] OnDiscDownloadInfo");
    paramList = aqrw.a(this.a, paramLong2, false);
    if (paramList == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "onUpdateGetOfflineDownloadInfo, mapDowload is not existed taskid[" + String.valueOf(paramLong2) + "]");
      this.a.a(paramLong2, false, null, 0, null, null, paramString2, false, null, (short)0, null);
      return;
    }
    if ((TextUtils.isEmpty(paramList.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5)) && (!TextUtils.isEmpty(paramString6))) {
      paramList.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 = paramString6;
    }
    arni.a(paramList.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.a.a, null);
    if (paramLong1 != 0L)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong2 + "] OnDiscDownloadInfo isSuccess[false],retCode[" + String.valueOf(paramLong1) + "],retMsg[" + String.valueOf(paramString1) + "]");
      if (paramLong1 == -100001L) {}
      for (;;)
      {
        this.a.a.a().a(false, 51, new Object[] { paramList.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, Integer.valueOf(paramList.jdField_a_of_type_Int) });
        this.a.a(paramLong2);
        this.a.a(paramLong2, false, null, 0, null, null, paramString2, false, null, (short)0, null);
        return;
        if ((paramLong1 == -25081L) || (paramLong1 == -6101L) || (paramLong1 == -7003L))
        {
          paramList.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
          this.a.a.a().c(paramList.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        }
      }
    }
    if ((paramString3 == null) || (paramByteStringMicro == null))
    {
      QLog.i("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong2 + "]  get DiscdownLoad info Url is null ");
      if ((paramLong1 == -25081L) || (paramLong1 == -6101L) || (paramLong1 == -7003L))
      {
        paramList.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
        this.a.a.a().c(paramList.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      }
      if (paramLong1 == 0L) {}
      this.a.a(paramLong2);
      this.a.a(paramLong2, false, null, 0, null, null, paramString2, false, null, (short)0, null);
      return;
    }
    if ((TextUtils.isEmpty(paramList.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5)) && (!TextUtils.isEmpty(paramString6))) {
      paramList.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 = paramString6;
    }
    short s1;
    switch (paramList.jdField_a_of_type_Int)
    {
    default: 
      new StringBuilder().append("http://").append(paramString3).append(":").append(String.valueOf(paramShort)).append(paramString4).toString();
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong2 + "] unknow thumbSize!!!info:" + paramList.toString());
      this.a.a.a().a(false, 51, new Object[] { paramList.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, Integer.valueOf(paramList.jdField_a_of_type_Int) });
      this.a.a(paramLong2);
      this.a.a(paramLong2, false, paramString3, paramShort, paramString4, null, paramString2, false, null, (short)0, null);
      return;
    case 0: 
      paramString1 = "?pictype=scaled&size=16*16";
      paramString4 = paramString4 + paramString1;
      paramBoolean = false;
      s1 = 0;
      if ((aqxg.d(this.a.a)) && (paramBundle != null))
      {
        paramByteStringMicro = paramBundle.getString("strHttpsDomain");
        if (!TextUtils.isEmpty(paramByteStringMicro))
        {
          boolean bool = true;
          short s2 = paramBundle.getShort("httpsPort", (short)0);
          paramBoolean = bool;
          paramString1 = paramByteStringMicro;
          s1 = s2;
          if (s2 == 0)
          {
            s1 = 443;
            paramString1 = paramByteStringMicro;
            paramBoolean = bool;
          }
        }
      }
      break;
    }
    for (;;)
    {
      paramByteStringMicro = "";
      if (aroo.b(this.a.a)) {
        paramByteStringMicro = paramBundle.getString("IPv6Dns");
      }
      this.a.a(paramLong2, true, paramString3, paramShort, paramString4, null, paramString2, paramBoolean, paramString1, s1, paramByteStringMicro);
      return;
      paramString1 = "?pictype=scaled&size=32*32";
      break;
      paramString1 = "?pictype=scaled&size=64*64";
      break;
      paramString1 = "?pictype=scaled&size=128*128";
      break;
      paramString1 = "?pictype=scaled&size=320*320";
      break;
      paramString1 = "?pictype=scaled&size=384*384";
      break;
      paramString1 = "?pictype=scaled&size=640*640";
      break;
      paramString1 = "?pictype=scaled&size=750*750";
      break;
      paramString1 = "?pictype=scaled&size=1024*1024";
      break;
      paramString1 = null;
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, long paramLong2, Bundle paramBundle)
  {
    QLog.i("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong2 + "] OnDiscDownloadInfo");
    paramString2 = aqrw.a(this.a, paramLong2, false);
    if (paramString2 == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "OnDiscDownloadInfo, mapDowload is not existed taskid[" + String.valueOf(paramLong2) + "]");
      arni.a(this.a.a, 0L, "actFileDiscThumb", 0L, "", "", "", "", 9005L, "get info null", 0L, 0L, 0L, "", "", 0, "get info null", "");
      arni.a(this.a.a, 0L, "actFileDiscThumbDetail", 0L, "", "", "", "", 9005L, "get info null", 0L, 0L, 0L, "", "", 0, "get info null", "");
      this.a.a(paramLong2, false, null, 0, null, null, paramString5, false, null, (short)0, null);
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
        arni.a(this.a.a, paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumb", paramString2.b, "", paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, l, String.valueOf(paramInt2) + "&" + String.valueOf(paramLong1), 0L, 0L, 0L, "", "", 0, "ret error", null);
        arni.a(this.a.a, paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumbDetail", paramString2.b, "", paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, l, String.valueOf(paramInt2) + "&" + String.valueOf(paramLong1), 0L, 0L, 0L, "", "", 0, "ret error", null);
        this.a.a.a().a(false, 50, new Object[] { paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, Integer.valueOf(paramString2.jdField_a_of_type_Int) });
        this.a.a(paramLong2);
        this.a.a(paramLong2, false, null, 0, null, null, paramString5, false, null, (short)0, null);
        return;
        if ((paramLong1 == -25081L) || (paramLong1 == -6101L) || (paramLong1 == -7003L))
        {
          paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
          this.a.a.a().c(paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        }
        else
        {
          l = 9045L;
        }
      }
    }
    paramString2.jdField_a_of_type_JavaLangString = paramString5;
    short s1;
    switch (paramString2.jdField_a_of_type_Int)
    {
    default: 
      paramString1 = "http://" + paramString3 + ":" + String.valueOf(paramInt1) + "/ftn_handler/" + paramString4;
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong2 + "] unknow thumbSize!!!info:" + paramString2.toString());
      this.a.a.a().a(false, 50, new Object[] { paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, Integer.valueOf(paramString2.jdField_a_of_type_Int) });
      arni.a(this.a.a, paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumb", paramString2.b, paramString1, paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, "size error", 0L, 0L, 0L, paramString1, "", 0, "size error", "");
      arni.a(this.a.a, paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumbDetail", paramString2.b, paramString1, paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, "size error", 0L, 0L, 0L, paramString1, "", 0, "size error", "");
      this.a.a(paramLong2);
      this.a.a(paramLong2, false, paramString3, paramInt1, "/ftn_handler/" + paramString4, null, paramString5, false, null, (short)0, null);
      return;
    case 0: 
      paramString1 = "?pictype=scaled&size=16*16";
      paramString4 = "/ftn_handler/" + paramString4 + paramString1;
      paramBoolean = false;
      s1 = 0;
      if ((aqxg.h(this.a.a)) && (paramBundle != null))
      {
        paramString2 = paramBundle.getString("strHttpsDomain");
        if (!TextUtils.isEmpty(paramString2))
        {
          boolean bool = true;
          short s2 = paramBundle.getShort("httpsPort", (short)0);
          paramBoolean = bool;
          paramString1 = paramString2;
          s1 = s2;
          if (s2 == 0)
          {
            s1 = 443;
            paramString1 = paramString2;
            paramBoolean = bool;
          }
        }
      }
      break;
    }
    for (;;)
    {
      paramString2 = "";
      if (aroo.b(this.a.a)) {
        paramString2 = paramBundle.getString("IPv6Dns");
      }
      this.a.a(paramLong2, true, paramString3, paramInt1, paramString4, null, paramString5, paramBoolean, paramString1, s1, paramString2);
      return;
      paramString1 = "?pictype=scaled&size=32*32";
      break;
      paramString1 = "?pictype=scaled&size=64*64";
      break;
      paramString1 = "?pictype=scaled&size=128*128";
      break;
      paramString1 = "?pictype=scaled&size=320*320";
      break;
      paramString1 = "?pictype=scaled&size=384*384";
      break;
      paramString1 = "?pictype=scaled&size=640*640";
      break;
      paramString1 = "?pictype=scaled&size=750*750";
      break;
      paramString1 = "?pictype=scaled&size=1024*1024";
      break;
      paramString1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqrx
 * JD-Core Version:    0.7.0.1
 */