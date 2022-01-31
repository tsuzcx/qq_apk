import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader.1;
import com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader.2;
import com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader.3;
import com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader.4;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class aqrw
  extends aqrs
{
  private aqpg a;
  
  public aqrw(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Aqpg = new aqrx(this);
  }
  
  private aqry a(long paramLong, boolean paramBoolean)
  {
    aqrt localaqrt = a(paramLong);
    if (localaqrt == null) {
      return null;
    }
    if ((localaqrt instanceof aqry)) {
      return (aqry)localaqrt;
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
    String str = armo.a().d() + b(paramInt, bhma.a(paramFileManagerEntity.Uuid));
    if ((!arof.b(str)) && (!TextUtils.isEmpty(paramFileManagerEntity.strFileMd5))) {
      str = armo.a().d() + b(paramInt, bhma.a(paramFileManagerEntity.strFileMd5));
    }
    for (;;)
    {
      if (bdcs.b(str) == true)
      {
        if (paramInt == 7)
        {
          paramFileManagerEntity.strLargeThumPath = str;
          if (aroa.b(paramFileManagerEntity)) {
            ThreadManager.post(new DiscPicThumbDownloader.1(this, paramFileManagerEntity), 8, null, false);
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramFileManagerEntity);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 50, new Object[] { paramFileManagerEntity, Integer.valueOf(paramInt) });
          QLog.e("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb] Id[" + paramFileManagerEntity.nSessionId + "] thumb Downloaded:" + str);
          arni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileDiscThumb", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, 0L, 0L, 0L, 0, null);
          return str;
          if (paramInt == 5)
          {
            paramFileManagerEntity.strMiddleThumPath = str;
            if (aroa.b(paramFileManagerEntity)) {
              ThreadManager.post(new DiscPicThumbDownloader.2(this, paramFileManagerEntity), 8, null, false);
            }
          }
          else
          {
            paramFileManagerEntity.strThumbPath = str;
          }
        }
      }
      aqry localaqry = new aqry(paramFileManagerEntity);
      localaqry.jdField_a_of_type_Int = paramInt;
      a(localaqry, str);
      QLog.i("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb] download  nSession[" + paramFileManagerEntity.nSessionId + "], ThumbDownloadId[" + localaqry.jdField_a_of_type_Long + "]");
      return null;
    }
  }
  
  public void a(long paramLong, int paramInt, aqvy paramaqvy)
  {
    paramaqvy = a(paramLong, false);
    if (paramaqvy == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 52, new Object[] { paramaqvy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, Integer.valueOf(paramInt) });
  }
  
  public void a(long paramLong, aqvy paramaqvy)
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
    if (paramaqvy.jdField_b_of_type_Bdlo != null)
    {
      i = paramaqvy.jdField_b_of_type_Bdlo.f;
      if (paramaqvy.jdField_b_of_type_Bdlo == null) {
        break label228;
      }
      str1 = paramaqvy.jdField_b_of_type_Bdlo.d();
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      paramLong = ((aqry)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
      l1 = ((aqry)localObject).b;
      str2 = paramaqvy.jdField_a_of_type_JavaLangString;
      str3 = ((aqry)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
      str4 = ((aqry)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
      str5 = ((aqry)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
      l2 = i;
      l3 = paramaqvy.e;
      l4 = paramaqvy.jdField_c_of_type_Long;
      l5 = paramaqvy.jdField_a_of_type_Int;
      str6 = paramaqvy.jdField_a_of_type_JavaLangString;
      if (paramaqvy.jdField_b_of_type_Bdlo == null) {
        break label236;
      }
    }
    label228:
    label236:
    for (localObject = paramaqvy.jdField_b_of_type_Bdlo.d;; localObject = "respose null")
    {
      arni.a(localQQAppInterface, paramLong, "actFileDiscThumbDetail", l1, str2, str3, str4, str5, l2, str1, l3, l4, l5, str6, (String)localObject, paramaqvy.jdField_c_of_type_Int, str1, "");
      return;
      i = 0;
      break;
      str1 = "start retry";
      break label76;
    }
  }
  
  public void a(long paramLong, bdlo parambdlo)
  {
    aqry localaqry = a(paramLong, false);
    if (localaqry == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onSetHttpMsg no this session");
      return;
    }
    parambdlo.jdField_c_of_type_Int = 3000;
    parambdlo.a("Cookie", localaqry.jdField_a_of_type_JavaLangString);
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, String paramString, aqvy paramaqvy)
  {
    aqry localaqry = a(paramLong, false);
    if (localaqry == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    if (paramBoolean)
    {
      arni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumb", System.currentTimeMillis() - localaqry.b, paramaqvy.jdField_a_of_type_JavaLangString, localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramaqvy.e, paramaqvy.jdField_c_of_type_Long, paramaqvy.jdField_a_of_type_Int, paramaqvy.jdField_b_of_type_Int, null);
      if (localaqry.jdField_a_of_type_Int == 7)
      {
        localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strLargeThumPath = paramString;
        arni.e(localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        ThreadManager.post(new DiscPicThumbDownloader.3(this, localaqry), 8, null, false);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramBoolean, 50, new Object[] { localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, Integer.valueOf(localaqry.jdField_a_of_type_Int) });
      super.a(paramLong, paramBoolean, paramInt, paramString, paramaqvy);
      return;
      if (localaqry.jdField_a_of_type_Int == 5)
      {
        localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strMiddleThumPath = paramString;
        arni.e(localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        if (!aroa.b(localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity)) {
          break;
        }
        ThreadManager.post(new DiscPicThumbDownloader.4(this, localaqry), 8, null, false);
        break;
      }
      localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strThumbPath = paramString;
      break;
      switch (paramInt)
      {
      default: 
        break;
      case -10: 
        if (localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) {
          localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.thumbInvalidCode = 1;
        }
        break;
      case -3: 
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        l1 = localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
        l2 = localaqry.b;
        localObject2 = paramaqvy.jdField_a_of_type_JavaLangString;
        str2 = localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
        str3 = localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
        str4 = localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
        l3 = paramaqvy.e;
        l4 = paramaqvy.jdField_c_of_type_Long;
        l5 = localaqry.jdField_a_of_type_Int;
        str5 = paramaqvy.jdField_a_of_type_JavaLangString;
        if (paramaqvy.jdField_b_of_type_Bdlo != null)
        {
          str1 = paramaqvy.jdField_b_of_type_Bdlo.d;
          arni.a((QQAppInterface)localObject1, l1, "actFileDiscThumb", l2, (String)localObject2, str2, str3, str4, 9004L, "no network", l3, l4, l5, str5, str1, paramaqvy.jdField_b_of_type_Int, "no network", "");
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          l1 = localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
          l2 = localaqry.b;
          localObject2 = paramaqvy.jdField_a_of_type_JavaLangString;
          str2 = localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
          str3 = localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
          str4 = localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
          l3 = paramaqvy.e;
          l4 = paramaqvy.jdField_c_of_type_Long;
          l5 = localaqry.jdField_a_of_type_Int;
          str5 = paramaqvy.jdField_a_of_type_JavaLangString;
          if (paramaqvy.jdField_b_of_type_Bdlo == null) {
            break label695;
          }
        }
        for (str1 = paramaqvy.jdField_b_of_type_Bdlo.d;; str1 = "respose null")
        {
          arni.a((QQAppInterface)localObject1, l1, "actFileDiscThumbDetail", l2, (String)localObject2, str2, str3, str4, 9004L, "no network", l3, l4, l5, str5, str1, paramaqvy.jdField_c_of_type_Int, "no network", "");
          break;
          str1 = "respose null";
          break label486;
        }
      case -2: 
        arni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumb", localaqry.b, paramaqvy.jdField_a_of_type_JavaLangString, localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "FileNotFoundException", 0L, 0L, 0L, paramaqvy.jdField_a_of_type_JavaLangString, "", 0, "FileNotFoundException", "");
        arni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumbDetail", localaqry.b, paramaqvy.jdField_a_of_type_JavaLangString, localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "FileNotFoundException", 0L, 0L, 0L, paramaqvy.jdField_a_of_type_JavaLangString, "", 0, "size error", "");
        break;
      case -6: 
      case -5: 
      case -4: 
        int i;
        long l6;
        String str6;
        if (paramaqvy.jdField_b_of_type_Bdlo != null)
        {
          i = paramaqvy.jdField_b_of_type_Bdlo.f;
          if (paramaqvy.jdField_b_of_type_Bdlo == null) {
            break label1224;
          }
          str1 = paramaqvy.jdField_b_of_type_Bdlo.d();
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          l1 = localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
          l2 = localaqry.b;
          str2 = paramaqvy.jdField_a_of_type_JavaLangString;
          str3 = localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
          str4 = localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
          str5 = localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
          l3 = i;
          l4 = paramaqvy.e;
          l5 = paramaqvy.jdField_c_of_type_Long;
          l6 = paramaqvy.jdField_a_of_type_Int;
          str6 = paramaqvy.jdField_a_of_type_JavaLangString;
          if (paramaqvy.jdField_b_of_type_Bdlo == null) {
            break label1232;
          }
          localObject1 = paramaqvy.jdField_b_of_type_Bdlo.d;
          arni.a((QQAppInterface)localObject2, l1, "actFileDiscThumb", l2, str2, str3, str4, str5, l3, str1, l4, l5, l6, str6, (String)localObject1, paramaqvy.jdField_b_of_type_Int, str1, "");
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          l1 = localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
          l2 = localaqry.b;
          str2 = paramaqvy.jdField_a_of_type_JavaLangString;
          str3 = localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
          str4 = localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
          str5 = localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
          l3 = i;
          l4 = paramaqvy.e;
          l5 = paramaqvy.jdField_c_of_type_Long;
          l6 = paramaqvy.jdField_a_of_type_Int;
          str6 = paramaqvy.jdField_a_of_type_JavaLangString;
          if (paramaqvy.jdField_b_of_type_Bdlo == null) {
            break label1240;
          }
        }
        label1224:
        label1232:
        label1240:
        for (localObject1 = paramaqvy.jdField_b_of_type_Bdlo.d;; localObject1 = "respose null")
        {
          arni.a((QQAppInterface)localObject2, l1, "actFileDiscThumbDetail", l2, str2, str3, str4, str5, l3, str1, l4, l5, l6, str6, (String)localObject1, paramaqvy.jdField_c_of_type_Int, str1, "");
          if (localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
            break;
          }
          localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.thumbInvalidCode = 2;
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
        arni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumb", localaqry.b, paramaqvy.jdField_a_of_type_JavaLangString, localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, "noRs", 0L, 0L, 0L, paramaqvy.jdField_a_of_type_JavaLangString, "", 0, "noRs", "");
        label695:
        label1001:
        arni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumbDetail", localaqry.b, paramaqvy.jdField_a_of_type_JavaLangString, localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, "noRs", paramaqvy.e, paramaqvy.jdField_c_of_type_Long, paramaqvy.jdField_a_of_type_Int, paramaqvy.jdField_a_of_type_JavaLangString, "", 0, "noRs", "");
      }
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    long l1 = localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
    long l2 = localaqry.b;
    Object localObject2 = paramaqvy.jdField_a_of_type_JavaLangString;
    String str2 = localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
    String str3 = localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
    String str4 = localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
    long l3 = paramaqvy.jdField_c_of_type_Long;
    long l4 = paramaqvy.jdField_a_of_type_Int;
    String str5 = paramaqvy.jdField_a_of_type_JavaLangString;
    if (paramaqvy.jdField_b_of_type_Bdlo != null)
    {
      str1 = paramaqvy.jdField_b_of_type_Bdlo.d;
      label1511:
      arni.a((QQAppInterface)localObject1, l1, "actFileDiscThumb", l2, (String)localObject2, str2, str3, str4, 9003L, "revStream write Exception", 0L, l3, l4, str5, str1, paramaqvy.jdField_b_of_type_Int, "revStream write Exception", "");
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      l1 = localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
      l2 = localaqry.b;
      localObject2 = paramaqvy.jdField_a_of_type_JavaLangString;
      str2 = localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
      str3 = localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
      str4 = localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
      l3 = paramaqvy.jdField_c_of_type_Long;
      l4 = paramaqvy.jdField_a_of_type_Int;
      str5 = paramaqvy.jdField_a_of_type_JavaLangString;
      if (paramaqvy.jdField_b_of_type_Bdlo == null) {
        break label1711;
      }
    }
    label1711:
    for (String str1 = paramaqvy.jdField_b_of_type_Bdlo.d;; str1 = "respose null")
    {
      arni.a((QQAppInterface)localObject1, l1, "actFileDiscThumbDetail", l2, (String)localObject2, str2, str3, str4, 9003L, "revStream write Exception", 0L, l3, l4, str5, str1, paramaqvy.jdField_c_of_type_Int, "revStream write Exception", "");
      break;
      str1 = "respose null";
      break label1511;
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    l1 = localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
    l2 = localaqry.b;
    localObject2 = paramaqvy.jdField_a_of_type_JavaLangString;
    str2 = localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
    str3 = localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
    str4 = localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
    l3 = paramaqvy.e;
    l4 = paramaqvy.jdField_c_of_type_Long;
    long l5 = paramaqvy.jdField_a_of_type_Int;
    str5 = paramaqvy.jdField_a_of_type_JavaLangString;
    if (paramaqvy.jdField_b_of_type_Bdlo != null)
    {
      str1 = paramaqvy.jdField_b_of_type_Bdlo.d;
      label1826:
      arni.a((QQAppInterface)localObject1, l1, "actFileDiscThumb", l2, (String)localObject2, str2, str3, str4, 9003L, "rename error", l3, l4, l5, str5, str1, paramaqvy.jdField_b_of_type_Int, "rename error", "");
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      l1 = localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
      l2 = localaqry.b;
      localObject2 = paramaqvy.jdField_a_of_type_JavaLangString;
      str2 = localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
      str3 = localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
      str4 = localaqry.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
      l3 = paramaqvy.e;
      l4 = paramaqvy.jdField_c_of_type_Long;
      l5 = paramaqvy.jdField_a_of_type_Int;
      str5 = paramaqvy.jdField_a_of_type_JavaLangString;
      if (paramaqvy.jdField_b_of_type_Bdlo == null) {
        break label2035;
      }
    }
    label2035:
    for (str1 = paramaqvy.jdField_b_of_type_Bdlo.d;; str1 = "respose null")
    {
      arni.a((QQAppInterface)localObject1, l1, "actFileDiscThumbDetail", l2, (String)localObject2, str2, str3, str4, 9003L, "rename error", l3, l4, l5, str5, str1, paramaqvy.jdField_c_of_type_Int, "rename error", "");
      break;
      str1 = "respose null";
      break label1826;
    }
  }
  
  public boolean a(long paramLong, aqvy paramaqvy)
  {
    paramaqvy = a(paramLong, false);
    if (paramaqvy == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onGetDownloadUrl no this session");
      return false;
    }
    if (paramaqvy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 3000) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong, paramaqvy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, Long.parseLong(paramaqvy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin), paramaqvy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_Aqpg);
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong, paramaqvy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, paramaqvy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend, this.jdField_a_of_type_Aqpg);
    }
  }
  
  public void b(long paramLong, aqvy paramaqvy) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqrw
 * JD-Core Version:    0.7.0.1
 */