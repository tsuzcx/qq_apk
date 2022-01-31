import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader.1;
import com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader.2;
import com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader.3;
import com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader.4;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class aoyu
  extends aoyq
{
  private aowe a;
  
  public aoyu(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Aowe = new aoyv(this);
  }
  
  private aoyw a(long paramLong, boolean paramBoolean)
  {
    aoyr localaoyr = a(paramLong);
    if (localaoyr == null) {
      return null;
    }
    if ((localaoyr instanceof aoyw)) {
      return (aoyw)localaoyr;
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
    String str = apti.a().d() + b(paramInt, bfkp.a(paramFileManagerEntity.Uuid));
    if ((!apvb.b(str)) && (!TextUtils.isEmpty(paramFileManagerEntity.strFileMd5))) {
      str = apti.a().d() + b(paramInt, bfkp.a(paramFileManagerEntity.strFileMd5));
    }
    for (;;)
    {
      if (bbdj.b(str) == true)
      {
        if (paramInt == 7)
        {
          paramFileManagerEntity.strLargeThumPath = str;
          if (apuw.b(paramFileManagerEntity)) {
            ThreadManager.post(new DiscPicThumbDownloader.1(this, paramFileManagerEntity), 8, null, false);
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramFileManagerEntity);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 50, new Object[] { paramFileManagerEntity, Integer.valueOf(paramInt) });
          QLog.e("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb] Id[" + paramFileManagerEntity.nSessionId + "] thumb Downloaded:" + str);
          apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileDiscThumb", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, 0L, 0L, 0L, 0, null);
          return str;
          if (paramInt == 5)
          {
            paramFileManagerEntity.strMiddleThumPath = str;
            if (apuw.b(paramFileManagerEntity)) {
              ThreadManager.post(new DiscPicThumbDownloader.2(this, paramFileManagerEntity), 8, null, false);
            }
          }
          else
          {
            paramFileManagerEntity.strThumbPath = str;
          }
        }
      }
      aoyw localaoyw = new aoyw(paramFileManagerEntity);
      localaoyw.jdField_a_of_type_Int = paramInt;
      a(localaoyw, str);
      QLog.i("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb] download  nSession[" + paramFileManagerEntity.nSessionId + "], ThumbDownloadId[" + localaoyw.jdField_a_of_type_Long + "]");
      return null;
    }
  }
  
  public void a(long paramLong, int paramInt, apcw paramapcw)
  {
    paramapcw = a(paramLong, false);
    if (paramapcw == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 52, new Object[] { paramapcw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, Integer.valueOf(paramInt) });
  }
  
  public void a(long paramLong, apcw paramapcw)
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
    if (paramapcw.jdField_b_of_type_Bbmg != null)
    {
      i = paramapcw.jdField_b_of_type_Bbmg.f;
      if (paramapcw.jdField_b_of_type_Bbmg == null) {
        break label228;
      }
      str1 = paramapcw.jdField_b_of_type_Bbmg.d();
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      paramLong = ((aoyw)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
      l1 = ((aoyw)localObject).b;
      str2 = paramapcw.jdField_a_of_type_JavaLangString;
      str3 = ((aoyw)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
      str4 = ((aoyw)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
      str5 = ((aoyw)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
      l2 = i;
      l3 = paramapcw.e;
      l4 = paramapcw.jdField_c_of_type_Long;
      l5 = paramapcw.jdField_a_of_type_Int;
      str6 = paramapcw.jdField_a_of_type_JavaLangString;
      if (paramapcw.jdField_b_of_type_Bbmg == null) {
        break label236;
      }
    }
    label228:
    label236:
    for (localObject = paramapcw.jdField_b_of_type_Bbmg.d;; localObject = "respose null")
    {
      apue.a(localQQAppInterface, paramLong, "actFileDiscThumbDetail", l1, str2, str3, str4, str5, l2, str1, l3, l4, l5, str6, (String)localObject, paramapcw.jdField_c_of_type_Int, str1, "");
      return;
      i = 0;
      break;
      str1 = "start retry";
      break label76;
    }
  }
  
  public void a(long paramLong, bbmg parambbmg)
  {
    aoyw localaoyw = a(paramLong, false);
    if (localaoyw == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onSetHttpMsg no this session");
      return;
    }
    parambbmg.jdField_c_of_type_Int = 3000;
    parambbmg.a("Cookie", localaoyw.jdField_a_of_type_JavaLangString);
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, String paramString, apcw paramapcw)
  {
    aoyw localaoyw = a(paramLong, false);
    if (localaoyw == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    if (paramBoolean)
    {
      apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumb", System.currentTimeMillis() - localaoyw.b, paramapcw.jdField_a_of_type_JavaLangString, localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramapcw.e, paramapcw.jdField_c_of_type_Long, paramapcw.jdField_a_of_type_Int, paramapcw.jdField_b_of_type_Int, null);
      if (localaoyw.jdField_a_of_type_Int == 7)
      {
        localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strLargeThumPath = paramString;
        apue.e(localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        ThreadManager.post(new DiscPicThumbDownloader.3(this, localaoyw), 8, null, false);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramBoolean, 50, new Object[] { localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, Integer.valueOf(localaoyw.jdField_a_of_type_Int) });
      super.a(paramLong, paramBoolean, paramInt, paramString, paramapcw);
      return;
      if (localaoyw.jdField_a_of_type_Int == 5)
      {
        localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strMiddleThumPath = paramString;
        apue.e(localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        if (!apuw.b(localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity)) {
          break;
        }
        ThreadManager.post(new DiscPicThumbDownloader.4(this, localaoyw), 8, null, false);
        break;
      }
      localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strThumbPath = paramString;
      break;
      switch (paramInt)
      {
      default: 
        break;
      case -10: 
        if (localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) {
          localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.thumbInvalidCode = 1;
        }
        break;
      case -3: 
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        l1 = localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
        l2 = localaoyw.b;
        localObject2 = paramapcw.jdField_a_of_type_JavaLangString;
        str2 = localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
        str3 = localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
        str4 = localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
        l3 = paramapcw.e;
        l4 = paramapcw.jdField_c_of_type_Long;
        l5 = localaoyw.jdField_a_of_type_Int;
        str5 = paramapcw.jdField_a_of_type_JavaLangString;
        if (paramapcw.jdField_b_of_type_Bbmg != null)
        {
          str1 = paramapcw.jdField_b_of_type_Bbmg.d;
          apue.a((QQAppInterface)localObject1, l1, "actFileDiscThumb", l2, (String)localObject2, str2, str3, str4, 9004L, "no network", l3, l4, l5, str5, str1, paramapcw.jdField_b_of_type_Int, "no network", "");
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          l1 = localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
          l2 = localaoyw.b;
          localObject2 = paramapcw.jdField_a_of_type_JavaLangString;
          str2 = localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
          str3 = localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
          str4 = localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
          l3 = paramapcw.e;
          l4 = paramapcw.jdField_c_of_type_Long;
          l5 = localaoyw.jdField_a_of_type_Int;
          str5 = paramapcw.jdField_a_of_type_JavaLangString;
          if (paramapcw.jdField_b_of_type_Bbmg == null) {
            break label695;
          }
        }
        for (str1 = paramapcw.jdField_b_of_type_Bbmg.d;; str1 = "respose null")
        {
          apue.a((QQAppInterface)localObject1, l1, "actFileDiscThumbDetail", l2, (String)localObject2, str2, str3, str4, 9004L, "no network", l3, l4, l5, str5, str1, paramapcw.jdField_c_of_type_Int, "no network", "");
          break;
          str1 = "respose null";
          break label486;
        }
      case -2: 
        apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumb", localaoyw.b, paramapcw.jdField_a_of_type_JavaLangString, localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "FileNotFoundException", 0L, 0L, 0L, paramapcw.jdField_a_of_type_JavaLangString, "", 0, "FileNotFoundException", "");
        apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumbDetail", localaoyw.b, paramapcw.jdField_a_of_type_JavaLangString, localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "FileNotFoundException", 0L, 0L, 0L, paramapcw.jdField_a_of_type_JavaLangString, "", 0, "size error", "");
        break;
      case -6: 
      case -5: 
      case -4: 
        int i;
        long l6;
        String str6;
        if (paramapcw.jdField_b_of_type_Bbmg != null)
        {
          i = paramapcw.jdField_b_of_type_Bbmg.f;
          if (paramapcw.jdField_b_of_type_Bbmg == null) {
            break label1224;
          }
          str1 = paramapcw.jdField_b_of_type_Bbmg.d();
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          l1 = localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
          l2 = localaoyw.b;
          str2 = paramapcw.jdField_a_of_type_JavaLangString;
          str3 = localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
          str4 = localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
          str5 = localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
          l3 = i;
          l4 = paramapcw.e;
          l5 = paramapcw.jdField_c_of_type_Long;
          l6 = paramapcw.jdField_a_of_type_Int;
          str6 = paramapcw.jdField_a_of_type_JavaLangString;
          if (paramapcw.jdField_b_of_type_Bbmg == null) {
            break label1232;
          }
          localObject1 = paramapcw.jdField_b_of_type_Bbmg.d;
          apue.a((QQAppInterface)localObject2, l1, "actFileDiscThumb", l2, str2, str3, str4, str5, l3, str1, l4, l5, l6, str6, (String)localObject1, paramapcw.jdField_b_of_type_Int, str1, "");
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          l1 = localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
          l2 = localaoyw.b;
          str2 = paramapcw.jdField_a_of_type_JavaLangString;
          str3 = localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
          str4 = localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
          str5 = localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
          l3 = i;
          l4 = paramapcw.e;
          l5 = paramapcw.jdField_c_of_type_Long;
          l6 = paramapcw.jdField_a_of_type_Int;
          str6 = paramapcw.jdField_a_of_type_JavaLangString;
          if (paramapcw.jdField_b_of_type_Bbmg == null) {
            break label1240;
          }
        }
        label1224:
        label1232:
        label1240:
        for (localObject1 = paramapcw.jdField_b_of_type_Bbmg.d;; localObject1 = "respose null")
        {
          apue.a((QQAppInterface)localObject2, l1, "actFileDiscThumbDetail", l2, str2, str3, str4, str5, l3, str1, l4, l5, l6, str6, (String)localObject1, paramapcw.jdField_c_of_type_Int, str1, "");
          if (localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
            break;
          }
          localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.thumbInvalidCode = 2;
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
        apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumb", localaoyw.b, paramapcw.jdField_a_of_type_JavaLangString, localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, "noRs", 0L, 0L, 0L, paramapcw.jdField_a_of_type_JavaLangString, "", 0, "noRs", "");
        label695:
        label1001:
        apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumbDetail", localaoyw.b, paramapcw.jdField_a_of_type_JavaLangString, localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, "noRs", paramapcw.e, paramapcw.jdField_c_of_type_Long, paramapcw.jdField_a_of_type_Int, paramapcw.jdField_a_of_type_JavaLangString, "", 0, "noRs", "");
      }
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    long l1 = localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
    long l2 = localaoyw.b;
    Object localObject2 = paramapcw.jdField_a_of_type_JavaLangString;
    String str2 = localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
    String str3 = localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
    String str4 = localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
    long l3 = paramapcw.jdField_c_of_type_Long;
    long l4 = paramapcw.jdField_a_of_type_Int;
    String str5 = paramapcw.jdField_a_of_type_JavaLangString;
    if (paramapcw.jdField_b_of_type_Bbmg != null)
    {
      str1 = paramapcw.jdField_b_of_type_Bbmg.d;
      label1511:
      apue.a((QQAppInterface)localObject1, l1, "actFileDiscThumb", l2, (String)localObject2, str2, str3, str4, 9003L, "revStream write Exception", 0L, l3, l4, str5, str1, paramapcw.jdField_b_of_type_Int, "revStream write Exception", "");
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      l1 = localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
      l2 = localaoyw.b;
      localObject2 = paramapcw.jdField_a_of_type_JavaLangString;
      str2 = localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
      str3 = localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
      str4 = localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
      l3 = paramapcw.jdField_c_of_type_Long;
      l4 = paramapcw.jdField_a_of_type_Int;
      str5 = paramapcw.jdField_a_of_type_JavaLangString;
      if (paramapcw.jdField_b_of_type_Bbmg == null) {
        break label1711;
      }
    }
    label1711:
    for (String str1 = paramapcw.jdField_b_of_type_Bbmg.d;; str1 = "respose null")
    {
      apue.a((QQAppInterface)localObject1, l1, "actFileDiscThumbDetail", l2, (String)localObject2, str2, str3, str4, 9003L, "revStream write Exception", 0L, l3, l4, str5, str1, paramapcw.jdField_c_of_type_Int, "revStream write Exception", "");
      break;
      str1 = "respose null";
      break label1511;
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    l1 = localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
    l2 = localaoyw.b;
    localObject2 = paramapcw.jdField_a_of_type_JavaLangString;
    str2 = localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
    str3 = localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
    str4 = localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
    l3 = paramapcw.e;
    l4 = paramapcw.jdField_c_of_type_Long;
    long l5 = paramapcw.jdField_a_of_type_Int;
    str5 = paramapcw.jdField_a_of_type_JavaLangString;
    if (paramapcw.jdField_b_of_type_Bbmg != null)
    {
      str1 = paramapcw.jdField_b_of_type_Bbmg.d;
      label1826:
      apue.a((QQAppInterface)localObject1, l1, "actFileDiscThumb", l2, (String)localObject2, str2, str3, str4, 9003L, "rename error", l3, l4, l5, str5, str1, paramapcw.jdField_b_of_type_Int, "rename error", "");
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      l1 = localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
      l2 = localaoyw.b;
      localObject2 = paramapcw.jdField_a_of_type_JavaLangString;
      str2 = localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
      str3 = localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
      str4 = localaoyw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
      l3 = paramapcw.e;
      l4 = paramapcw.jdField_c_of_type_Long;
      l5 = paramapcw.jdField_a_of_type_Int;
      str5 = paramapcw.jdField_a_of_type_JavaLangString;
      if (paramapcw.jdField_b_of_type_Bbmg == null) {
        break label2035;
      }
    }
    label2035:
    for (str1 = paramapcw.jdField_b_of_type_Bbmg.d;; str1 = "respose null")
    {
      apue.a((QQAppInterface)localObject1, l1, "actFileDiscThumbDetail", l2, (String)localObject2, str2, str3, str4, 9003L, "rename error", l3, l4, l5, str5, str1, paramapcw.jdField_c_of_type_Int, "rename error", "");
      break;
      str1 = "respose null";
      break label1826;
    }
  }
  
  public boolean a(long paramLong, apcw paramapcw)
  {
    paramapcw = a(paramLong, false);
    if (paramapcw == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onGetDownloadUrl no this session");
      return false;
    }
    if (paramapcw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 3000) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong, paramapcw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, Long.parseLong(paramapcw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin), paramapcw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_Aowe);
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong, paramapcw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, paramapcw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend, this.jdField_a_of_type_Aowe);
    }
  }
  
  public void b(long paramLong, apcw paramapcw) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoyu
 * JD-Core Version:    0.7.0.1
 */