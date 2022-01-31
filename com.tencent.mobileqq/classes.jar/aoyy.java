import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader.1;
import com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader.2;
import com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader.3;
import com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader.4;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class aoyy
  extends aoyu
{
  private aowi a;
  
  public aoyy(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Aowi = new aoyz(this);
  }
  
  private aoza a(long paramLong, boolean paramBoolean)
  {
    aoyv localaoyv = a(paramLong);
    if (localaoyv == null) {
      return null;
    }
    if ((localaoyv instanceof aoza)) {
      return (aoza)localaoyv;
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
    String str = aptm.a().d() + b(paramInt, bflg.a(paramFileManagerEntity.Uuid));
    if ((!apvd.b(str)) && (!TextUtils.isEmpty(paramFileManagerEntity.strFileMd5))) {
      str = aptm.a().d() + b(paramInt, bflg.a(paramFileManagerEntity.strFileMd5));
    }
    for (;;)
    {
      if (bbdx.b(str) == true)
      {
        if (paramInt == 7)
        {
          paramFileManagerEntity.strLargeThumPath = str;
          if (apuy.b(paramFileManagerEntity)) {
            ThreadManager.post(new DiscPicThumbDownloader.1(this, paramFileManagerEntity), 8, null, false);
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramFileManagerEntity);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 50, new Object[] { paramFileManagerEntity, Integer.valueOf(paramInt) });
          QLog.e("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb] Id[" + paramFileManagerEntity.nSessionId + "] thumb Downloaded:" + str);
          apug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileDiscThumb", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, 0L, 0L, 0L, 0, null);
          return str;
          if (paramInt == 5)
          {
            paramFileManagerEntity.strMiddleThumPath = str;
            if (apuy.b(paramFileManagerEntity)) {
              ThreadManager.post(new DiscPicThumbDownloader.2(this, paramFileManagerEntity), 8, null, false);
            }
          }
          else
          {
            paramFileManagerEntity.strThumbPath = str;
          }
        }
      }
      aoza localaoza = new aoza(paramFileManagerEntity);
      localaoza.jdField_a_of_type_Int = paramInt;
      a(localaoza, str);
      QLog.i("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb] download  nSession[" + paramFileManagerEntity.nSessionId + "], ThumbDownloadId[" + localaoza.jdField_a_of_type_Long + "]");
      return null;
    }
  }
  
  public void a(long paramLong, int paramInt, apda paramapda)
  {
    paramapda = a(paramLong, false);
    if (paramapda == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 52, new Object[] { paramapda.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, Integer.valueOf(paramInt) });
  }
  
  public void a(long paramLong, apda paramapda)
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
    if (paramapda.jdField_b_of_type_Bbmu != null)
    {
      i = paramapda.jdField_b_of_type_Bbmu.f;
      if (paramapda.jdField_b_of_type_Bbmu == null) {
        break label228;
      }
      str1 = paramapda.jdField_b_of_type_Bbmu.d();
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      paramLong = ((aoza)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
      l1 = ((aoza)localObject).b;
      str2 = paramapda.jdField_a_of_type_JavaLangString;
      str3 = ((aoza)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
      str4 = ((aoza)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
      str5 = ((aoza)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
      l2 = i;
      l3 = paramapda.e;
      l4 = paramapda.jdField_c_of_type_Long;
      l5 = paramapda.jdField_a_of_type_Int;
      str6 = paramapda.jdField_a_of_type_JavaLangString;
      if (paramapda.jdField_b_of_type_Bbmu == null) {
        break label236;
      }
    }
    label228:
    label236:
    for (localObject = paramapda.jdField_b_of_type_Bbmu.d;; localObject = "respose null")
    {
      apug.a(localQQAppInterface, paramLong, "actFileDiscThumbDetail", l1, str2, str3, str4, str5, l2, str1, l3, l4, l5, str6, (String)localObject, paramapda.jdField_c_of_type_Int, str1, "");
      return;
      i = 0;
      break;
      str1 = "start retry";
      break label76;
    }
  }
  
  public void a(long paramLong, bbmu parambbmu)
  {
    aoza localaoza = a(paramLong, false);
    if (localaoza == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onSetHttpMsg no this session");
      return;
    }
    parambbmu.jdField_c_of_type_Int = 3000;
    parambbmu.a("Cookie", localaoza.jdField_a_of_type_JavaLangString);
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, String paramString, apda paramapda)
  {
    aoza localaoza = a(paramLong, false);
    if (localaoza == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    if (paramBoolean)
    {
      apug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumb", System.currentTimeMillis() - localaoza.b, paramapda.jdField_a_of_type_JavaLangString, localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramapda.e, paramapda.jdField_c_of_type_Long, paramapda.jdField_a_of_type_Int, paramapda.jdField_b_of_type_Int, null);
      if (localaoza.jdField_a_of_type_Int == 7)
      {
        localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strLargeThumPath = paramString;
        apug.e(localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        ThreadManager.post(new DiscPicThumbDownloader.3(this, localaoza), 8, null, false);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramBoolean, 50, new Object[] { localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, Integer.valueOf(localaoza.jdField_a_of_type_Int) });
      super.a(paramLong, paramBoolean, paramInt, paramString, paramapda);
      return;
      if (localaoza.jdField_a_of_type_Int == 5)
      {
        localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strMiddleThumPath = paramString;
        apug.e(localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        if (!apuy.b(localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity)) {
          break;
        }
        ThreadManager.post(new DiscPicThumbDownloader.4(this, localaoza), 8, null, false);
        break;
      }
      localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strThumbPath = paramString;
      break;
      switch (paramInt)
      {
      default: 
        break;
      case -10: 
        if (localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) {
          localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.thumbInvalidCode = 1;
        }
        break;
      case -3: 
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        l1 = localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
        l2 = localaoza.b;
        localObject2 = paramapda.jdField_a_of_type_JavaLangString;
        str2 = localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
        str3 = localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
        str4 = localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
        l3 = paramapda.e;
        l4 = paramapda.jdField_c_of_type_Long;
        l5 = localaoza.jdField_a_of_type_Int;
        str5 = paramapda.jdField_a_of_type_JavaLangString;
        if (paramapda.jdField_b_of_type_Bbmu != null)
        {
          str1 = paramapda.jdField_b_of_type_Bbmu.d;
          apug.a((QQAppInterface)localObject1, l1, "actFileDiscThumb", l2, (String)localObject2, str2, str3, str4, 9004L, "no network", l3, l4, l5, str5, str1, paramapda.jdField_b_of_type_Int, "no network", "");
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          l1 = localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
          l2 = localaoza.b;
          localObject2 = paramapda.jdField_a_of_type_JavaLangString;
          str2 = localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
          str3 = localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
          str4 = localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
          l3 = paramapda.e;
          l4 = paramapda.jdField_c_of_type_Long;
          l5 = localaoza.jdField_a_of_type_Int;
          str5 = paramapda.jdField_a_of_type_JavaLangString;
          if (paramapda.jdField_b_of_type_Bbmu == null) {
            break label695;
          }
        }
        for (str1 = paramapda.jdField_b_of_type_Bbmu.d;; str1 = "respose null")
        {
          apug.a((QQAppInterface)localObject1, l1, "actFileDiscThumbDetail", l2, (String)localObject2, str2, str3, str4, 9004L, "no network", l3, l4, l5, str5, str1, paramapda.jdField_c_of_type_Int, "no network", "");
          break;
          str1 = "respose null";
          break label486;
        }
      case -2: 
        apug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumb", localaoza.b, paramapda.jdField_a_of_type_JavaLangString, localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "FileNotFoundException", 0L, 0L, 0L, paramapda.jdField_a_of_type_JavaLangString, "", 0, "FileNotFoundException", "");
        apug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumbDetail", localaoza.b, paramapda.jdField_a_of_type_JavaLangString, localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "FileNotFoundException", 0L, 0L, 0L, paramapda.jdField_a_of_type_JavaLangString, "", 0, "size error", "");
        break;
      case -6: 
      case -5: 
      case -4: 
        int i;
        long l6;
        String str6;
        if (paramapda.jdField_b_of_type_Bbmu != null)
        {
          i = paramapda.jdField_b_of_type_Bbmu.f;
          if (paramapda.jdField_b_of_type_Bbmu == null) {
            break label1224;
          }
          str1 = paramapda.jdField_b_of_type_Bbmu.d();
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          l1 = localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
          l2 = localaoza.b;
          str2 = paramapda.jdField_a_of_type_JavaLangString;
          str3 = localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
          str4 = localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
          str5 = localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
          l3 = i;
          l4 = paramapda.e;
          l5 = paramapda.jdField_c_of_type_Long;
          l6 = paramapda.jdField_a_of_type_Int;
          str6 = paramapda.jdField_a_of_type_JavaLangString;
          if (paramapda.jdField_b_of_type_Bbmu == null) {
            break label1232;
          }
          localObject1 = paramapda.jdField_b_of_type_Bbmu.d;
          apug.a((QQAppInterface)localObject2, l1, "actFileDiscThumb", l2, str2, str3, str4, str5, l3, str1, l4, l5, l6, str6, (String)localObject1, paramapda.jdField_b_of_type_Int, str1, "");
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          l1 = localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
          l2 = localaoza.b;
          str2 = paramapda.jdField_a_of_type_JavaLangString;
          str3 = localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
          str4 = localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
          str5 = localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
          l3 = i;
          l4 = paramapda.e;
          l5 = paramapda.jdField_c_of_type_Long;
          l6 = paramapda.jdField_a_of_type_Int;
          str6 = paramapda.jdField_a_of_type_JavaLangString;
          if (paramapda.jdField_b_of_type_Bbmu == null) {
            break label1240;
          }
        }
        label1224:
        label1232:
        label1240:
        for (localObject1 = paramapda.jdField_b_of_type_Bbmu.d;; localObject1 = "respose null")
        {
          apug.a((QQAppInterface)localObject2, l1, "actFileDiscThumbDetail", l2, str2, str3, str4, str5, l3, str1, l4, l5, l6, str6, (String)localObject1, paramapda.jdField_c_of_type_Int, str1, "");
          if (localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
            break;
          }
          localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.thumbInvalidCode = 2;
          break;
          i = 0;
          break label871;
          str1 = "http resp err";
          break label889;
          localObject1 = "respose null";
          break label1001;
        }
      case -7: 
        label486:
        label871:
        label889:
        apug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumb", localaoza.b, paramapda.jdField_a_of_type_JavaLangString, localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, "noRs", 0L, 0L, 0L, paramapda.jdField_a_of_type_JavaLangString, "", 0, "noRs", "");
        label695:
        label1001:
        apug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumbDetail", localaoza.b, paramapda.jdField_a_of_type_JavaLangString, localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, "noRs", paramapda.e, paramapda.jdField_c_of_type_Long, paramapda.jdField_a_of_type_Int, paramapda.jdField_a_of_type_JavaLangString, "", 0, "noRs", "");
      }
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    long l1 = localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
    long l2 = localaoza.b;
    Object localObject2 = paramapda.jdField_a_of_type_JavaLangString;
    String str2 = localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
    String str3 = localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
    String str4 = localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
    long l3 = paramapda.jdField_c_of_type_Long;
    long l4 = paramapda.jdField_a_of_type_Int;
    String str5 = paramapda.jdField_a_of_type_JavaLangString;
    if (paramapda.jdField_b_of_type_Bbmu != null)
    {
      str1 = paramapda.jdField_b_of_type_Bbmu.d;
      label1511:
      apug.a((QQAppInterface)localObject1, l1, "actFileDiscThumb", l2, (String)localObject2, str2, str3, str4, 9003L, "revStream write Exception", 0L, l3, l4, str5, str1, paramapda.jdField_b_of_type_Int, "revStream write Exception", "");
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      l1 = localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
      l2 = localaoza.b;
      localObject2 = paramapda.jdField_a_of_type_JavaLangString;
      str2 = localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
      str3 = localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
      str4 = localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
      l3 = paramapda.jdField_c_of_type_Long;
      l4 = paramapda.jdField_a_of_type_Int;
      str5 = paramapda.jdField_a_of_type_JavaLangString;
      if (paramapda.jdField_b_of_type_Bbmu == null) {
        break label1711;
      }
    }
    label1711:
    for (String str1 = paramapda.jdField_b_of_type_Bbmu.d;; str1 = "respose null")
    {
      apug.a((QQAppInterface)localObject1, l1, "actFileDiscThumbDetail", l2, (String)localObject2, str2, str3, str4, 9003L, "revStream write Exception", 0L, l3, l4, str5, str1, paramapda.jdField_c_of_type_Int, "revStream write Exception", "");
      break;
      str1 = "respose null";
      break label1511;
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    l1 = localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
    l2 = localaoza.b;
    localObject2 = paramapda.jdField_a_of_type_JavaLangString;
    str2 = localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
    str3 = localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
    str4 = localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
    l3 = paramapda.e;
    l4 = paramapda.jdField_c_of_type_Long;
    long l5 = paramapda.jdField_a_of_type_Int;
    str5 = paramapda.jdField_a_of_type_JavaLangString;
    if (paramapda.jdField_b_of_type_Bbmu != null)
    {
      str1 = paramapda.jdField_b_of_type_Bbmu.d;
      label1826:
      apug.a((QQAppInterface)localObject1, l1, "actFileDiscThumb", l2, (String)localObject2, str2, str3, str4, 9003L, "rename error", l3, l4, l5, str5, str1, paramapda.jdField_b_of_type_Int, "rename error", "");
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      l1 = localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
      l2 = localaoza.b;
      localObject2 = paramapda.jdField_a_of_type_JavaLangString;
      str2 = localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
      str3 = localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
      str4 = localaoza.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
      l3 = paramapda.e;
      l4 = paramapda.jdField_c_of_type_Long;
      l5 = paramapda.jdField_a_of_type_Int;
      str5 = paramapda.jdField_a_of_type_JavaLangString;
      if (paramapda.jdField_b_of_type_Bbmu == null) {
        break label2035;
      }
    }
    label2035:
    for (str1 = paramapda.jdField_b_of_type_Bbmu.d;; str1 = "respose null")
    {
      apug.a((QQAppInterface)localObject1, l1, "actFileDiscThumbDetail", l2, (String)localObject2, str2, str3, str4, 9003L, "rename error", l3, l4, l5, str5, str1, paramapda.jdField_c_of_type_Int, "rename error", "");
      break;
      str1 = "respose null";
      break label1826;
    }
  }
  
  public boolean a(long paramLong, apda paramapda)
  {
    paramapda = a(paramLong, false);
    if (paramapda == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onGetDownloadUrl no this session");
      return false;
    }
    if (paramapda.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 3000) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong, paramapda.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, Long.parseLong(paramapda.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin), paramapda.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_Aowi);
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong, paramapda.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, paramapda.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend, this.jdField_a_of_type_Aowi);
    }
  }
  
  public void b(long paramLong, apda paramapda) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoyy
 * JD-Core Version:    0.7.0.1
 */