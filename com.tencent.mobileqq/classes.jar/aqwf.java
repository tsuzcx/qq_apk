import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader.1;
import com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader.2;
import com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader.3;
import com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader.4;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class aqwf
  extends aqwb
{
  private aqtp a;
  
  public aqwf(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Aqtp = new aqwg(this);
  }
  
  private aqwh a(long paramLong, boolean paramBoolean)
  {
    aqwc localaqwc = a(paramLong);
    if (localaqwc == null) {
      return null;
    }
    if ((localaqwc instanceof aqwh)) {
      return (aqwh)localaqwc;
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
    String str = arqx.a().d() + b(paramInt, bhqh.a(paramFileManagerEntity.Uuid));
    if ((!arso.b(str)) && (!TextUtils.isEmpty(paramFileManagerEntity.strFileMd5))) {
      str = arqx.a().d() + b(paramInt, bhqh.a(paramFileManagerEntity.strFileMd5));
    }
    for (;;)
    {
      if (bdhb.b(str) == true)
      {
        if (paramInt == 7)
        {
          paramFileManagerEntity.strLargeThumPath = str;
          if (arsj.b(paramFileManagerEntity)) {
            ThreadManager.post(new DiscPicThumbDownloader.1(this, paramFileManagerEntity), 8, null, false);
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramFileManagerEntity);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 50, new Object[] { paramFileManagerEntity, Integer.valueOf(paramInt) });
          QLog.e("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb] Id[" + paramFileManagerEntity.nSessionId + "] thumb Downloaded:" + str);
          arrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileDiscThumb", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, 0L, 0L, 0L, 0, null);
          return str;
          if (paramInt == 5)
          {
            paramFileManagerEntity.strMiddleThumPath = str;
            if (arsj.b(paramFileManagerEntity)) {
              ThreadManager.post(new DiscPicThumbDownloader.2(this, paramFileManagerEntity), 8, null, false);
            }
          }
          else
          {
            paramFileManagerEntity.strThumbPath = str;
          }
        }
      }
      aqwh localaqwh = new aqwh(paramFileManagerEntity);
      localaqwh.jdField_a_of_type_Int = paramInt;
      a(localaqwh, str);
      QLog.i("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb] download  nSession[" + paramFileManagerEntity.nSessionId + "], ThumbDownloadId[" + localaqwh.jdField_a_of_type_Long + "]");
      return null;
    }
  }
  
  public void a(long paramLong, int paramInt, arah paramarah)
  {
    paramarah = a(paramLong, false);
    if (paramarah == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 52, new Object[] { paramarah.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, Integer.valueOf(paramInt) });
  }
  
  public void a(long paramLong, arah paramarah)
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
    if (paramarah.jdField_b_of_type_Bdpx != null)
    {
      i = paramarah.jdField_b_of_type_Bdpx.f;
      if (paramarah.jdField_b_of_type_Bdpx == null) {
        break label228;
      }
      str1 = paramarah.jdField_b_of_type_Bdpx.d();
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      paramLong = ((aqwh)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
      l1 = ((aqwh)localObject).b;
      str2 = paramarah.jdField_a_of_type_JavaLangString;
      str3 = ((aqwh)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
      str4 = ((aqwh)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
      str5 = ((aqwh)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
      l2 = i;
      l3 = paramarah.e;
      l4 = paramarah.jdField_c_of_type_Long;
      l5 = paramarah.jdField_a_of_type_Int;
      str6 = paramarah.jdField_a_of_type_JavaLangString;
      if (paramarah.jdField_b_of_type_Bdpx == null) {
        break label236;
      }
    }
    label228:
    label236:
    for (localObject = paramarah.jdField_b_of_type_Bdpx.d;; localObject = "respose null")
    {
      arrr.a(localQQAppInterface, paramLong, "actFileDiscThumbDetail", l1, str2, str3, str4, str5, l2, str1, l3, l4, l5, str6, (String)localObject, paramarah.jdField_c_of_type_Int, str1, "");
      return;
      i = 0;
      break;
      str1 = "start retry";
      break label76;
    }
  }
  
  public void a(long paramLong, bdpx parambdpx)
  {
    aqwh localaqwh = a(paramLong, false);
    if (localaqwh == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onSetHttpMsg no this session");
      return;
    }
    parambdpx.jdField_c_of_type_Int = 3000;
    parambdpx.a("Cookie", localaqwh.jdField_a_of_type_JavaLangString);
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, String paramString, arah paramarah)
  {
    aqwh localaqwh = a(paramLong, false);
    if (localaqwh == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    if (paramBoolean)
    {
      arrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumb", System.currentTimeMillis() - localaqwh.b, paramarah.jdField_a_of_type_JavaLangString, localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramarah.e, paramarah.jdField_c_of_type_Long, paramarah.jdField_a_of_type_Int, paramarah.jdField_b_of_type_Int, null);
      if (localaqwh.jdField_a_of_type_Int == 7)
      {
        localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strLargeThumPath = paramString;
        arrr.e(localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        ThreadManager.post(new DiscPicThumbDownloader.3(this, localaqwh), 8, null, false);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramBoolean, 50, new Object[] { localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, Integer.valueOf(localaqwh.jdField_a_of_type_Int) });
      super.a(paramLong, paramBoolean, paramInt, paramString, paramarah);
      return;
      if (localaqwh.jdField_a_of_type_Int == 5)
      {
        localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strMiddleThumPath = paramString;
        arrr.e(localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        if (!arsj.b(localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity)) {
          break;
        }
        ThreadManager.post(new DiscPicThumbDownloader.4(this, localaqwh), 8, null, false);
        break;
      }
      localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strThumbPath = paramString;
      break;
      switch (paramInt)
      {
      default: 
        break;
      case -10: 
        if (localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) {
          localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.thumbInvalidCode = 1;
        }
        break;
      case -3: 
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        l1 = localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
        l2 = localaqwh.b;
        localObject2 = paramarah.jdField_a_of_type_JavaLangString;
        str2 = localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
        str3 = localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
        str4 = localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
        l3 = paramarah.e;
        l4 = paramarah.jdField_c_of_type_Long;
        l5 = localaqwh.jdField_a_of_type_Int;
        str5 = paramarah.jdField_a_of_type_JavaLangString;
        if (paramarah.jdField_b_of_type_Bdpx != null)
        {
          str1 = paramarah.jdField_b_of_type_Bdpx.d;
          arrr.a((QQAppInterface)localObject1, l1, "actFileDiscThumb", l2, (String)localObject2, str2, str3, str4, 9004L, "no network", l3, l4, l5, str5, str1, paramarah.jdField_b_of_type_Int, "no network", "");
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          l1 = localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
          l2 = localaqwh.b;
          localObject2 = paramarah.jdField_a_of_type_JavaLangString;
          str2 = localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
          str3 = localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
          str4 = localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
          l3 = paramarah.e;
          l4 = paramarah.jdField_c_of_type_Long;
          l5 = localaqwh.jdField_a_of_type_Int;
          str5 = paramarah.jdField_a_of_type_JavaLangString;
          if (paramarah.jdField_b_of_type_Bdpx == null) {
            break label695;
          }
        }
        for (str1 = paramarah.jdField_b_of_type_Bdpx.d;; str1 = "respose null")
        {
          arrr.a((QQAppInterface)localObject1, l1, "actFileDiscThumbDetail", l2, (String)localObject2, str2, str3, str4, 9004L, "no network", l3, l4, l5, str5, str1, paramarah.jdField_c_of_type_Int, "no network", "");
          break;
          str1 = "respose null";
          break label486;
        }
      case -2: 
        arrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumb", localaqwh.b, paramarah.jdField_a_of_type_JavaLangString, localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "FileNotFoundException", 0L, 0L, 0L, paramarah.jdField_a_of_type_JavaLangString, "", 0, "FileNotFoundException", "");
        arrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumbDetail", localaqwh.b, paramarah.jdField_a_of_type_JavaLangString, localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "FileNotFoundException", 0L, 0L, 0L, paramarah.jdField_a_of_type_JavaLangString, "", 0, "size error", "");
        break;
      case -6: 
      case -5: 
      case -4: 
        int i;
        long l6;
        String str6;
        if (paramarah.jdField_b_of_type_Bdpx != null)
        {
          i = paramarah.jdField_b_of_type_Bdpx.f;
          if (paramarah.jdField_b_of_type_Bdpx == null) {
            break label1224;
          }
          str1 = paramarah.jdField_b_of_type_Bdpx.d();
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          l1 = localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
          l2 = localaqwh.b;
          str2 = paramarah.jdField_a_of_type_JavaLangString;
          str3 = localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
          str4 = localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
          str5 = localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
          l3 = i;
          l4 = paramarah.e;
          l5 = paramarah.jdField_c_of_type_Long;
          l6 = paramarah.jdField_a_of_type_Int;
          str6 = paramarah.jdField_a_of_type_JavaLangString;
          if (paramarah.jdField_b_of_type_Bdpx == null) {
            break label1232;
          }
          localObject1 = paramarah.jdField_b_of_type_Bdpx.d;
          arrr.a((QQAppInterface)localObject2, l1, "actFileDiscThumb", l2, str2, str3, str4, str5, l3, str1, l4, l5, l6, str6, (String)localObject1, paramarah.jdField_b_of_type_Int, str1, "");
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          l1 = localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
          l2 = localaqwh.b;
          str2 = paramarah.jdField_a_of_type_JavaLangString;
          str3 = localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
          str4 = localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
          str5 = localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
          l3 = i;
          l4 = paramarah.e;
          l5 = paramarah.jdField_c_of_type_Long;
          l6 = paramarah.jdField_a_of_type_Int;
          str6 = paramarah.jdField_a_of_type_JavaLangString;
          if (paramarah.jdField_b_of_type_Bdpx == null) {
            break label1240;
          }
        }
        label1224:
        label1232:
        label1240:
        for (localObject1 = paramarah.jdField_b_of_type_Bdpx.d;; localObject1 = "respose null")
        {
          arrr.a((QQAppInterface)localObject2, l1, "actFileDiscThumbDetail", l2, str2, str3, str4, str5, l3, str1, l4, l5, l6, str6, (String)localObject1, paramarah.jdField_c_of_type_Int, str1, "");
          if (localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
            break;
          }
          localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.thumbInvalidCode = 2;
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
        arrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumb", localaqwh.b, paramarah.jdField_a_of_type_JavaLangString, localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, "noRs", 0L, 0L, 0L, paramarah.jdField_a_of_type_JavaLangString, "", 0, "noRs", "");
        label695:
        label1001:
        arrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumbDetail", localaqwh.b, paramarah.jdField_a_of_type_JavaLangString, localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, "noRs", paramarah.e, paramarah.jdField_c_of_type_Long, paramarah.jdField_a_of_type_Int, paramarah.jdField_a_of_type_JavaLangString, "", 0, "noRs", "");
      }
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    long l1 = localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
    long l2 = localaqwh.b;
    Object localObject2 = paramarah.jdField_a_of_type_JavaLangString;
    String str2 = localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
    String str3 = localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
    String str4 = localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
    long l3 = paramarah.jdField_c_of_type_Long;
    long l4 = paramarah.jdField_a_of_type_Int;
    String str5 = paramarah.jdField_a_of_type_JavaLangString;
    if (paramarah.jdField_b_of_type_Bdpx != null)
    {
      str1 = paramarah.jdField_b_of_type_Bdpx.d;
      label1511:
      arrr.a((QQAppInterface)localObject1, l1, "actFileDiscThumb", l2, (String)localObject2, str2, str3, str4, 9003L, "revStream write Exception", 0L, l3, l4, str5, str1, paramarah.jdField_b_of_type_Int, "revStream write Exception", "");
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      l1 = localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
      l2 = localaqwh.b;
      localObject2 = paramarah.jdField_a_of_type_JavaLangString;
      str2 = localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
      str3 = localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
      str4 = localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
      l3 = paramarah.jdField_c_of_type_Long;
      l4 = paramarah.jdField_a_of_type_Int;
      str5 = paramarah.jdField_a_of_type_JavaLangString;
      if (paramarah.jdField_b_of_type_Bdpx == null) {
        break label1711;
      }
    }
    label1711:
    for (String str1 = paramarah.jdField_b_of_type_Bdpx.d;; str1 = "respose null")
    {
      arrr.a((QQAppInterface)localObject1, l1, "actFileDiscThumbDetail", l2, (String)localObject2, str2, str3, str4, 9003L, "revStream write Exception", 0L, l3, l4, str5, str1, paramarah.jdField_c_of_type_Int, "revStream write Exception", "");
      break;
      str1 = "respose null";
      break label1511;
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    l1 = localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
    l2 = localaqwh.b;
    localObject2 = paramarah.jdField_a_of_type_JavaLangString;
    str2 = localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
    str3 = localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
    str4 = localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
    l3 = paramarah.e;
    l4 = paramarah.jdField_c_of_type_Long;
    long l5 = paramarah.jdField_a_of_type_Int;
    str5 = paramarah.jdField_a_of_type_JavaLangString;
    if (paramarah.jdField_b_of_type_Bdpx != null)
    {
      str1 = paramarah.jdField_b_of_type_Bdpx.d;
      label1826:
      arrr.a((QQAppInterface)localObject1, l1, "actFileDiscThumb", l2, (String)localObject2, str2, str3, str4, 9003L, "rename error", l3, l4, l5, str5, str1, paramarah.jdField_b_of_type_Int, "rename error", "");
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      l1 = localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
      l2 = localaqwh.b;
      localObject2 = paramarah.jdField_a_of_type_JavaLangString;
      str2 = localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
      str3 = localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
      str4 = localaqwh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
      l3 = paramarah.e;
      l4 = paramarah.jdField_c_of_type_Long;
      l5 = paramarah.jdField_a_of_type_Int;
      str5 = paramarah.jdField_a_of_type_JavaLangString;
      if (paramarah.jdField_b_of_type_Bdpx == null) {
        break label2035;
      }
    }
    label2035:
    for (str1 = paramarah.jdField_b_of_type_Bdpx.d;; str1 = "respose null")
    {
      arrr.a((QQAppInterface)localObject1, l1, "actFileDiscThumbDetail", l2, (String)localObject2, str2, str3, str4, 9003L, "rename error", l3, l4, l5, str5, str1, paramarah.jdField_c_of_type_Int, "rename error", "");
      break;
      str1 = "respose null";
      break label1826;
    }
  }
  
  public boolean a(long paramLong, arah paramarah)
  {
    paramarah = a(paramLong, false);
    if (paramarah == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onGetDownloadUrl no this session");
      return false;
    }
    if (paramarah.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 3000) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong, paramarah.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, Long.parseLong(paramarah.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin), paramarah.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_Aqtp);
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong, paramarah.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, paramarah.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend, this.jdField_a_of_type_Aqtp);
    }
  }
  
  public void b(long paramLong, arah paramarah) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqwf
 * JD-Core Version:    0.7.0.1
 */