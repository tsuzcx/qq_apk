import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader.1;
import com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader.2;
import com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader.3;
import com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader.4;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class aoia
  extends aohw
{
  private aofk a;
  
  public aoia(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Aofk = new aoib(this);
  }
  
  private aoic a(long paramLong, boolean paramBoolean)
  {
    aohx localaohx = a(paramLong);
    if (localaohx == null) {
      return null;
    }
    if ((localaohx instanceof aoic)) {
      return (aoic)localaohx;
    }
    QLog.e("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb] getSession  ID[" + paramLong + "] no instance");
    return null;
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
    String str = apbo.a().d() + b(paramInt, becz.a(paramFileManagerEntity.Uuid));
    if ((!apdh.b(str)) && (!TextUtils.isEmpty(paramFileManagerEntity.strFileMd5))) {
      str = apbo.a().d() + b(paramInt, becz.a(paramFileManagerEntity.strFileMd5));
    }
    for (;;)
    {
      if (bace.b(str) == true)
      {
        if (paramInt == 7)
        {
          paramFileManagerEntity.strLargeThumPath = str;
          if (apdc.b(paramFileManagerEntity)) {
            ThreadManager.post(new DiscPicThumbDownloader.1(this, paramFileManagerEntity), 8, null, false);
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramFileManagerEntity);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 50, new Object[] { paramFileManagerEntity, Integer.valueOf(paramInt) });
          QLog.e("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb] Id[" + paramFileManagerEntity.nSessionId + "] thumb Downloaded:" + str);
          apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileDiscThumb", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, 0L, 0L, 0L, 0, null);
          return str;
          if (paramInt == 5)
          {
            paramFileManagerEntity.strMiddleThumPath = str;
            if (apdc.b(paramFileManagerEntity)) {
              ThreadManager.post(new DiscPicThumbDownloader.2(this, paramFileManagerEntity), 8, null, false);
            }
          }
          else
          {
            paramFileManagerEntity.strThumbPath = str;
          }
        }
      }
      aoic localaoic = new aoic(paramFileManagerEntity);
      localaoic.jdField_a_of_type_Int = paramInt;
      a(localaoic, str);
      QLog.i("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb] download  nSession[" + paramFileManagerEntity.nSessionId + "], ThumbDownloadId[" + localaoic.jdField_a_of_type_Long + "]");
      return null;
    }
  }
  
  public void a(long paramLong, int paramInt, aomc paramaomc)
  {
    paramaomc = a(paramLong, false);
    if (paramaomc == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 52, new Object[] { paramaomc.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, Integer.valueOf(paramInt) });
  }
  
  public void a(long paramLong, aomc paramaomc)
  {
    Object localObject = a(paramLong, false);
    if (localObject == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    int i;
    String str1;
    label76:
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
    if (paramaomc.jdField_b_of_type_Bakw != null)
    {
      i = paramaomc.jdField_b_of_type_Bakw.f;
      if (paramaomc.jdField_b_of_type_Bakw == null) {
        break label228;
      }
      str1 = paramaomc.jdField_b_of_type_Bakw.d();
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      paramLong = ((aoic)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
      l1 = ((aoic)localObject).b;
      str2 = paramaomc.jdField_a_of_type_JavaLangString;
      str3 = ((aoic)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
      str4 = ((aoic)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
      str5 = ((aoic)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
      l2 = i;
      l3 = paramaomc.e;
      l4 = paramaomc.jdField_c_of_type_Long;
      l5 = paramaomc.jdField_a_of_type_Int;
      str6 = paramaomc.jdField_a_of_type_JavaLangString;
      if (paramaomc.jdField_b_of_type_Bakw == null) {
        break label236;
      }
    }
    label228:
    label236:
    for (localObject = paramaomc.jdField_b_of_type_Bakw.d;; localObject = "respose null")
    {
      apck.a(localQQAppInterface, paramLong, "actFileDiscThumbDetail", l1, str2, str3, str4, str5, l2, str1, l3, l4, l5, str6, (String)localObject, paramaomc.jdField_c_of_type_Int, str1, "");
      return;
      i = 0;
      break;
      str1 = "start retry";
      break label76;
    }
  }
  
  public void a(long paramLong, bakw parambakw)
  {
    aoic localaoic = a(paramLong, false);
    if (localaoic == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onSetHttpMsg no this session");
      return;
    }
    parambakw.jdField_c_of_type_Int = 3000;
    parambakw.a("Cookie", localaoic.jdField_a_of_type_JavaLangString);
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, String paramString, aomc paramaomc)
  {
    aoic localaoic = a(paramLong, false);
    if (localaoic == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    if (paramBoolean)
    {
      apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumb", System.currentTimeMillis() - localaoic.b, paramaomc.jdField_a_of_type_JavaLangString, localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramaomc.e, paramaomc.jdField_c_of_type_Long, paramaomc.jdField_a_of_type_Int, paramaomc.jdField_b_of_type_Int, null);
      if (localaoic.jdField_a_of_type_Int == 7)
      {
        localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strLargeThumPath = paramString;
        apck.e(localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        ThreadManager.post(new DiscPicThumbDownloader.3(this, localaoic), 8, null, false);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramBoolean, 50, new Object[] { localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, Integer.valueOf(localaoic.jdField_a_of_type_Int) });
      super.a(paramLong, paramBoolean, paramInt, paramString, paramaomc);
      return;
      if (localaoic.jdField_a_of_type_Int == 5)
      {
        localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strMiddleThumPath = paramString;
        apck.e(localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        if (!apdc.b(localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity)) {
          break;
        }
        ThreadManager.post(new DiscPicThumbDownloader.4(this, localaoic), 8, null, false);
        break;
      }
      localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strThumbPath = paramString;
      break;
      switch (paramInt)
      {
      }
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    long l1 = localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
    long l2 = localaoic.b;
    Object localObject2 = paramaomc.jdField_a_of_type_JavaLangString;
    String str2 = localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
    String str3 = localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
    String str4 = localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
    long l3 = paramaomc.e;
    long l4 = paramaomc.jdField_c_of_type_Long;
    long l5 = paramaomc.jdField_a_of_type_Int;
    String str5 = paramaomc.jdField_a_of_type_JavaLangString;
    if (paramaomc.jdField_b_of_type_Bakw != null)
    {
      str1 = paramaomc.jdField_b_of_type_Bakw.d;
      label462:
      apck.a((QQAppInterface)localObject1, l1, "actFileDiscThumb", l2, (String)localObject2, str2, str3, str4, 9003L, "rename error", l3, l4, l5, str5, str1, paramaomc.jdField_b_of_type_Int, "rename error", "");
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      l1 = localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
      l2 = localaoic.b;
      localObject2 = paramaomc.jdField_a_of_type_JavaLangString;
      str2 = localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
      str3 = localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
      str4 = localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
      l3 = paramaomc.e;
      l4 = paramaomc.jdField_c_of_type_Long;
      l5 = paramaomc.jdField_a_of_type_Int;
      str5 = paramaomc.jdField_a_of_type_JavaLangString;
      if (paramaomc.jdField_b_of_type_Bakw == null) {
        break label1994;
      }
    }
    label770:
    label1155:
    label1173:
    label1978:
    label1994:
    for (String str1 = paramaomc.jdField_b_of_type_Bakw.d;; str1 = "respose null")
    {
      apck.a((QQAppInterface)localObject1, l1, "actFileDiscThumbDetail", l2, (String)localObject2, str2, str3, str4, 9003L, "rename error", l3, l4, l5, str5, str1, paramaomc.jdField_c_of_type_Int, "rename error", "");
      break;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      l1 = localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
      l2 = localaoic.b;
      localObject2 = paramaomc.jdField_a_of_type_JavaLangString;
      str2 = localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
      str3 = localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
      str4 = localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
      l3 = paramaomc.e;
      l4 = paramaomc.jdField_c_of_type_Long;
      l5 = localaoic.jdField_a_of_type_Int;
      str5 = paramaomc.jdField_a_of_type_JavaLangString;
      if (paramaomc.jdField_b_of_type_Bakw != null)
      {
        str1 = paramaomc.jdField_b_of_type_Bakw.d;
        apck.a((QQAppInterface)localObject1, l1, "actFileDiscThumb", l2, (String)localObject2, str2, str3, str4, 9004L, "no network", l3, l4, l5, str5, str1, paramaomc.jdField_b_of_type_Int, "no network", "");
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        l1 = localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
        l2 = localaoic.b;
        localObject2 = paramaomc.jdField_a_of_type_JavaLangString;
        str2 = localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
        str3 = localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
        str4 = localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
        l3 = paramaomc.e;
        l4 = paramaomc.jdField_c_of_type_Long;
        l5 = localaoic.jdField_a_of_type_Int;
        str5 = paramaomc.jdField_a_of_type_JavaLangString;
        if (paramaomc.jdField_b_of_type_Bakw == null) {
          break label979;
        }
      }
      label979:
      for (str1 = paramaomc.jdField_b_of_type_Bakw.d;; str1 = "respose null")
      {
        apck.a((QQAppInterface)localObject1, l1, "actFileDiscThumbDetail", l2, (String)localObject2, str2, str3, str4, 9004L, "no network", l3, l4, l5, str5, str1, paramaomc.jdField_c_of_type_Int, "no network", "");
        break;
        str1 = "respose null";
        break label770;
      }
      apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumb", localaoic.b, paramaomc.jdField_a_of_type_JavaLangString, localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "FileNotFoundException", 0L, 0L, 0L, paramaomc.jdField_a_of_type_JavaLangString, "", 0, "FileNotFoundException", "");
      apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumbDetail", localaoic.b, paramaomc.jdField_a_of_type_JavaLangString, localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "FileNotFoundException", 0L, 0L, 0L, paramaomc.jdField_a_of_type_JavaLangString, "", 0, "size error", "");
      break;
      int i;
      long l6;
      String str6;
      if (paramaomc.jdField_b_of_type_Bakw != null)
      {
        i = paramaomc.jdField_b_of_type_Bakw.f;
        if (paramaomc.jdField_b_of_type_Bakw == null) {
          break label1491;
        }
        str1 = paramaomc.jdField_b_of_type_Bakw.d();
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        l1 = localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
        l2 = localaoic.b;
        str2 = paramaomc.jdField_a_of_type_JavaLangString;
        str3 = localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
        str4 = localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
        str5 = localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
        l3 = i;
        l4 = paramaomc.e;
        l5 = paramaomc.jdField_c_of_type_Long;
        l6 = paramaomc.jdField_a_of_type_Int;
        str6 = paramaomc.jdField_a_of_type_JavaLangString;
        if (paramaomc.jdField_b_of_type_Bakw == null) {
          break label1499;
        }
        localObject1 = paramaomc.jdField_b_of_type_Bakw.d;
        apck.a((QQAppInterface)localObject2, l1, "actFileDiscThumb", l2, str2, str3, str4, str5, l3, str1, l4, l5, l6, str6, (String)localObject1, paramaomc.jdField_b_of_type_Int, str1, "");
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        l1 = localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
        l2 = localaoic.b;
        str2 = paramaomc.jdField_a_of_type_JavaLangString;
        str3 = localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
        str4 = localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
        str5 = localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
        l3 = i;
        l4 = paramaomc.e;
        l5 = paramaomc.jdField_c_of_type_Long;
        l6 = paramaomc.jdField_a_of_type_Int;
        str6 = paramaomc.jdField_a_of_type_JavaLangString;
        if (paramaomc.jdField_b_of_type_Bakw == null) {
          break label1507;
        }
      }
      label1491:
      label1499:
      label1507:
      for (localObject1 = paramaomc.jdField_b_of_type_Bakw.d;; localObject1 = "respose null")
      {
        apck.a((QQAppInterface)localObject2, l1, "actFileDiscThumbDetail", l2, str2, str3, str4, str5, l3, str1, l4, l5, l6, str6, (String)localObject1, paramaomc.jdField_c_of_type_Int, str1, "");
        break;
        i = 0;
        break label1155;
        str1 = "http resp err";
        break label1173;
        localObject1 = "respose null";
        break label1285;
      }
      apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumb", localaoic.b, paramaomc.jdField_a_of_type_JavaLangString, localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, "noRs", 0L, 0L, 0L, paramaomc.jdField_a_of_type_JavaLangString, "", 0, "noRs", "");
      apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumbDetail", localaoic.b, paramaomc.jdField_a_of_type_JavaLangString, localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, "noRs", paramaomc.e, paramaomc.jdField_c_of_type_Long, paramaomc.jdField_a_of_type_Int, paramaomc.jdField_a_of_type_JavaLangString, "", 0, "noRs", "");
      break;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      l1 = localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
      l2 = localaoic.b;
      localObject2 = paramaomc.jdField_a_of_type_JavaLangString;
      str2 = localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
      str3 = localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
      str4 = localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
      l3 = paramaomc.jdField_c_of_type_Long;
      l4 = paramaomc.jdField_a_of_type_Int;
      str5 = paramaomc.jdField_a_of_type_JavaLangString;
      if (paramaomc.jdField_b_of_type_Bakw != null)
      {
        str1 = paramaomc.jdField_b_of_type_Bakw.d;
        label1778:
        apck.a((QQAppInterface)localObject1, l1, "actFileDiscThumb", l2, (String)localObject2, str2, str3, str4, 9003L, "revStream write Exception", 0L, l3, l4, str5, str1, paramaomc.jdField_b_of_type_Int, "revStream write Exception", "");
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        l1 = localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
        l2 = localaoic.b;
        localObject2 = paramaomc.jdField_a_of_type_JavaLangString;
        str2 = localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
        str3 = localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
        str4 = localaoic.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
        l3 = paramaomc.jdField_c_of_type_Long;
        l4 = paramaomc.jdField_a_of_type_Int;
        str5 = paramaomc.jdField_a_of_type_JavaLangString;
        if (paramaomc.jdField_b_of_type_Bakw == null) {
          break label1978;
        }
      }
      for (str1 = paramaomc.jdField_b_of_type_Bakw.d;; str1 = "respose null")
      {
        apck.a((QQAppInterface)localObject1, l1, "actFileDiscThumbDetail", l2, (String)localObject2, str2, str3, str4, 9003L, "revStream write Exception", 0L, l3, l4, str5, str1, paramaomc.jdField_c_of_type_Int, "revStream write Exception", "");
        break;
        str1 = "respose null";
        break label1778;
      }
      str1 = "respose null";
      break label462;
    }
  }
  
  public boolean a(long paramLong, aomc paramaomc)
  {
    paramaomc = a(paramLong, false);
    if (paramaomc == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onGetDownloadUrl no this session");
      return false;
    }
    if (paramaomc.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 3000) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong, paramaomc.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, Long.parseLong(paramaomc.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin), paramaomc.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_Aofk);
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong, paramaomc.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, paramaomc.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend, this.jdField_a_of_type_Aofk);
    }
  }
  
  public void b(long paramLong, aomc paramaomc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoia
 * JD-Core Version:    0.7.0.1
 */