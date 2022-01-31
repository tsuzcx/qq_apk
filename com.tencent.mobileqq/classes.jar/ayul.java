import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadWorker.3;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.UploadFileRspBody;

public class ayul
  extends ayub
  implements aytx, ayua, ayuh
{
  protected Bundle a;
  public ayrn a;
  protected ayrp a;
  protected aytw a;
  protected ayui a;
  protected Timer a;
  wmc jdField_a_of_type_Wmc = new ayun(this);
  wme jdField_a_of_type_Wme = new ayum(this);
  public boolean a;
  protected byte[] a;
  protected int b;
  @Deprecated
  protected boolean b;
  protected long e;
  protected long f;
  protected long g;
  protected long h;
  protected long i;
  
  protected ayul(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, ayui paramayui)
  {
    super(paramLong, paramItem);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Ayrn = new ayrn();
    this.jdField_a_of_type_Ayui = paramayui;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public static ayul b(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, ayui paramayui)
  {
    if (paramLong == 0L)
    {
      aysb.a("TroopFileUploadWorker", aysb.jdField_a_of_type_Int, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      aysb.a("TroopFileUploadWorker", aysb.jdField_a_of_type_Int, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null) {
      aysb.a("TroopFileUploadWorker", aysb.jdField_a_of_type_Int, "getWoker. item.id=null");
    }
    return new ayul(paramLong, paramItem, paramBundle, paramayui);
  }
  
  private void e()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void o()
  {
    this.jdField_a_of_type_Ayrn.a();
    this.jdField_g_of_type_Long = 0L;
    this.f = 0L;
    this.h = 0L;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.BusId;
  }
  
  protected int a(int paramInt)
  {
    return 3;
  }
  
  protected int a(int paramInt1, int paramInt2)
  {
    return ayrm.a(paramInt1, paramInt2);
  }
  
  protected aytw a(QQAppInterface paramQQAppInterface, long paramLong, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    return null;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath;
  }
  
  protected void a() {}
  
  public void a(int paramInt)
  {
    int k = 2;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Int != 7))
    {
      aysb.c("TroopFileUploadWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop. but had stoped. mStatus:" + this.jdField_b_of_type_Int);
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    a(8, 0);
    aysb.c("TroopFileUploadWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop. mStatus:" + this.jdField_b_of_type_Int + " reason:" + paramInt);
    int j;
    if (this.jdField_b_of_type_Int == 1)
    {
      aytz.a().a(this.jdField_e_of_type_Long);
      e();
      if (this.jdField_a_of_type_Ayrp != null)
      {
        wln.a(ayrz.a(), this.jdField_a_of_type_Ayrp);
        this.jdField_a_of_type_Ayrp = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Pausing = 1;
      j = 8;
      if (paramInt != 1) {
        break label299;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.W2MPause = 2;
      j = 11;
    }
    for (;;)
    {
      ayrl.a(this.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, k);
      b(0);
      this.jdField_a_of_type_Ayrn.jdField_c_of_type_Int = j;
      c();
      o();
      return;
      if (this.jdField_b_of_type_Int != 3) {
        break;
      }
      if (this.jdField_a_of_type_Aytw != null)
      {
        this.jdField_a_of_type_Aytw.a();
        this.jdField_a_of_type_Aytw = null;
        break;
      }
      aysb.b("TroopFileUploadWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop upload. uploader=null");
      break;
      label299:
      if (paramInt == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Pausing = -1;
        j = 12;
      }
      else if (paramInt == 3)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Pausing = -1;
        j = 11;
        k = 3;
      }
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Aytw != null)
    {
      this.jdField_a_of_type_Ayrn.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Aytw.a();
      this.jdField_a_of_type_Ayrn.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Aytw.b();
      this.jdField_a_of_type_Ayrn.jdField_a_of_type_Int = this.jdField_a_of_type_Aytw.b();
      this.jdField_a_of_type_Ayrn.jdField_b_of_type_Int = this.jdField_a_of_type_Aytw.g();
    }
    this.jdField_a_of_type_Ayrn.jdField_c_of_type_Int = paramInt1;
    this.jdField_a_of_type_Ayrn.jdField_d_of_type_Int = paramInt2;
    long l2 = this.h;
    long l1 = l2;
    if (paramInt1 == 0)
    {
      l1 = l2;
      if (this.jdField_a_of_type_Aytw != null)
      {
        this.jdField_a_of_type_Ayrn.jdField_a_of_type_Long = this.jdField_a_of_type_Aytw.a();
        this.jdField_a_of_type_Ayrn.jdField_a_of_type_Boolean = this.jdField_a_of_type_Aytw.d();
        if (!this.jdField_a_of_type_Ayrn.jdField_a_of_type_Boolean) {
          break label245;
        }
      }
    }
    label245:
    for (l1 = 0L;; l1 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal - this.jdField_a_of_type_Aytw.a())
    {
      this.jdField_a_of_type_Ayrn.jdField_b_of_type_Long = l1;
      if (this.jdField_g_of_type_Long != 0L)
      {
        this.jdField_a_of_type_Ayrn.jdField_c_of_type_Long = (System.currentTimeMillis() - this.jdField_g_of_type_Long);
        if ((this.jdField_a_of_type_Ayrn.jdField_b_of_type_Long <= 0L) || (this.jdField_a_of_type_Ayrn.jdField_c_of_type_Long <= 0L)) {
          break;
        }
        float f1 = (float)this.jdField_a_of_type_Ayrn.jdField_c_of_type_Long / 1000.0F;
        this.jdField_a_of_type_Ayrn.jdField_e_of_type_Long = (((float)this.jdField_a_of_type_Ayrn.jdField_b_of_type_Long / f1));
      }
      return;
    }
    this.jdField_a_of_type_Ayrn.jdField_e_of_type_Long = 0L;
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramLong > this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue) {}
    for (this.h += paramLong - this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue;; this.h = paramLong)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue = paramLong;
      paramLong = System.currentTimeMillis();
      if ((this.i != 0L) && (paramLong - this.i < 1500L)) {
        break;
      }
      this.i = paramLong;
      ayrl.b(this.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.f = System.currentTimeMillis();
    int k = 0;
    int j = k;
    if (paramLong2 != 0L)
    {
      j = k;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal == 0L)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal = paramLong2;
        j = 1;
      }
    }
    azld.a();
    if (j != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.StatusUpdateTimeMs = 0L;
      ayrl.b(this.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
    }
  }
  
  public void a(long paramLong1, String paramString, long paramLong2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, Bundle paramBundle, int paramInt)
  {
    if (this.jdField_e_of_type_Long != paramLong1) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      aysb.b("TroopFileUploadWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onFileScanResult. but had stop");
      return;
    }
    if (this.f != 0L)
    {
      this.jdField_a_of_type_Ayrn.jdField_g_of_type_Long = (System.currentTimeMillis() - this.f);
      this.f = 0L;
    }
    aysb.c("TroopFileUploadWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onFileScanResult. errCode:" + paramInt);
    if (paramInt != 0)
    {
      int j = 1;
      int k = azle.l;
      if (paramInt == -2)
      {
        this.jdField_a_of_type_Ayrn.jdField_c_of_type_Int = 5;
        this.jdField_a_of_type_Ayrn.jdField_d_of_type_Int = 501;
        j = 102;
        paramInt = azle.s;
      }
      for (;;)
      {
        a(true, azle.jdField_b_of_type_Int, paramInt, j);
        return;
        if (paramInt == -1)
        {
          this.jdField_a_of_type_Ayrn.jdField_c_of_type_Int = 7;
          this.jdField_a_of_type_Ayrn.jdField_d_of_type_Int = 700;
          j = 201;
          paramInt = azle.jdField_g_of_type_Int;
        }
        else if (paramInt == -4)
        {
          this.jdField_a_of_type_Ayrn.jdField_c_of_type_Int = 5;
          this.jdField_a_of_type_Ayrn.jdField_d_of_type_Int = 502;
          j = 205;
          paramInt = azle.jdField_e_of_type_Int;
        }
        else if (paramInt == -3)
        {
          this.jdField_a_of_type_Ayrn.jdField_c_of_type_Int = 7;
          this.jdField_a_of_type_Ayrn.jdField_d_of_type_Int = 701;
          j = 203;
          paramInt = azle.j;
        }
        else
        {
          this.jdField_a_of_type_Ayrn.jdField_c_of_type_Int = 5;
          this.jdField_a_of_type_Ayrn.jdField_d_of_type_Int = 503;
          paramInt = k;
        }
      }
    }
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length == 0) || (paramArrayOfByte2 == null) || (paramArrayOfByte2.length == 0))
    {
      aysb.a("TroopFileUploadWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onFileScanResult. md5 or sha is null");
      this.jdField_a_of_type_Ayrn.jdField_c_of_type_Int = 5;
      this.jdField_a_of_type_Ayrn.jdField_d_of_type_Int = 503;
      a(true, azle.jdField_b_of_type_Int, azle.l, 211);
      return;
    }
    if ((paramLong2 != 0L) && (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal == 0L)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal = paramLong2;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Md5 = paramArrayOfByte1;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha = paramArrayOfByte2;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha3 = com.tencent.commonsdk.util.HexUtil.bytes2HexStr(paramArrayOfByte3);
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte3;
    if (paramBundle != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.width = paramBundle.getInt("_with_", 0);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.height = paramBundle.getInt("_height_", 0);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.duration = paramBundle.getInt("_duration_", 0);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.StatusUpdateTimeMs = 0L;
    ayrl.b(this.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
    m();
  }
  
  protected final void a(ayqd paramayqd, String paramString1, String paramString2, String paramString3)
  {
    QQAppInterface localQQAppInterface = ayrz.a();
    if (localQQAppInterface == null) {
      return;
    }
    FileManagerEntity localFileManagerEntity = apck.a(paramayqd);
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerUin = String.valueOf(paramayqd.jdField_b_of_type_Long);
    localFileManagerEntity.peerNick = babh.o(localQQAppInterface, localFileManagerEntity.peerUin);
    localFileManagerEntity.srvTime = (awao.a() * 1000L);
    localFileManagerEntity.setCloudType(3);
    localFileManagerEntity.bSend = true;
    localFileManagerEntity.status = 1;
    localFileManagerEntity.fProgress = 1.0F;
    localFileManagerEntity.TroopUin = this.jdField_d_of_type_Long;
    localFileManagerEntity.strFileMd5 = paramString1;
    localFileManagerEntity.strFileSHA = paramString2;
    localFileManagerEntity.strFileSha3 = paramString3;
    if ((localFileManagerEntity.nFileType == 0) || (localFileManagerEntity.nFileType == 2))
    {
      if (TextUtils.isEmpty(localFileManagerEntity.strFileSha3)) {
        localFileManagerEntity.strFileSha3 = aopg.a(apck.b(paramayqd.jdField_a_of_type_JavaLangString));
      }
      if ((localFileManagerEntity.fileSize < 104857600L) && (TextUtils.isEmpty(localFileManagerEntity.strFileSHA))) {
        localFileManagerEntity.strFileSHA = aopg.a(apck.a(paramayqd.jdField_a_of_type_JavaLangString));
      }
    }
    localFileManagerEntity.str10Md5 = bach.a(apck.d(paramayqd.jdField_a_of_type_JavaLangString));
    try
    {
      localFileManagerEntity.localModifyTime = new File(paramayqd.jdField_a_of_type_JavaLangString).lastModified();
      label229:
      localQQAppInterface.a().a(localFileManagerEntity);
      localFileManagerEntity.status = 1;
      localQQAppInterface.a().c(localFileManagerEntity);
      return;
    }
    catch (Exception paramayqd)
    {
      break label229;
    }
  }
  
  public void a(String paramString)
  {
    aysb.c("TroopFileUploadWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onChangeUrl:" + paramString);
  }
  
  protected void a(oidb_0x6d6.UploadFileRspBody paramUploadFileRspBody) {}
  
  protected void a(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = ayrz.a();
    if (localQQAppInterface == null)
    {
      aysb.a("TroopFileUploadWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] startUpload app=null");
      this.jdField_a_of_type_Ayrn.jdField_c_of_type_Int = 9;
      this.jdField_a_of_type_Ayrn.jdField_d_of_type_Int = 902;
      a(true, azle.jdField_b_of_type_Int, azle.w, 1);
      return;
    }
    if (this.jdField_a_of_type_Aytw != null)
    {
      this.jdField_a_of_type_Aytw.a();
      this.jdField_a_of_type_Aytw.a(null);
    }
    String str1 = com.qq.taf.jce.HexUtil.bytes2HexStr(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.CheckKey);
    String str2 = com.qq.taf.jce.HexUtil.bytes2HexStr(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha);
    long l = ayrz.a();
    Object localObject2;
    boolean bool1;
    Object localObject1;
    if (b())
    {
      boolean bool2 = false;
      localObject2 = null;
      bool1 = bool2;
      localObject1 = localObject2;
      if (azjg.a(localQQAppInterface))
      {
        bool1 = bool2;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ServerDns))
        {
          bool1 = true;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ServerDns;
        }
      }
      aysb.c("TroopFileUploadWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] startUpload. nSessionId:" + l + " use custom fileuploader bUseHttps:" + bool1 + " httpsDomain:" + (String)localObject1);
      this.jdField_a_of_type_Aytw = a(localQQAppInterface, l, paramBoolean, bool1, (String)localObject1);
    }
    while (this.jdField_a_of_type_Aytw == null)
    {
      this.jdField_a_of_type_Ayrn.jdField_c_of_type_Int = 9;
      this.jdField_a_of_type_Ayrn.jdField_d_of_type_Int = 904;
      a(true, azle.jdField_b_of_type_Int, azle.w, 1);
      return;
      if (this.jdField_b_of_type_Boolean)
      {
        localObject1 = "http://" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.UploadIp + "/ftn_handler";
        this.jdField_a_of_type_Aytw = ayuo.a(localQQAppInterface, l, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile, str1, str2, (String)localObject1);
        aysb.c("TroopFileUploadWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] startUpload.  nSessionId:" + l + " UseLastUploadIp=true strUrl=" + (String)localObject1);
      }
      else
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.UploadIp);
        if ((!paramBoolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ServerDns)))
        {
          if (!apdq.b(localQQAppInterface)) {
            break label689;
          }
          QLog.i("TroopFileUploadWorker<FileAssistant>", 1, "[Troop Upload] upload support IPv6. domain[" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ServerDns + "]");
          localArrayList.add(0, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ServerDns);
        }
        for (;;)
        {
          bool1 = false;
          localObject2 = null;
          paramBoolean = bool1;
          localObject1 = localObject2;
          if (azjg.a(localQQAppInterface))
          {
            paramBoolean = bool1;
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ServerDns))
            {
              paramBoolean = true;
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ServerDns;
            }
          }
          aysb.c("TroopFileUploadWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] startUpload. nSessionId:" + l + " UseLastUploadIp=false firstIP=" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.UploadIp + " bUseHttps:" + paramBoolean + " httpsDomain:" + (String)localObject1);
          this.jdField_a_of_type_Aytw = ayuo.a(localQQAppInterface, l, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile, str1, str2, localArrayList, "/ftn_handler", paramBoolean, (String)localObject1);
          break;
          label689:
          localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ServerDns);
        }
      }
    }
    this.jdField_g_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Ayrn.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue;
    this.jdField_a_of_type_Aytw.a(this);
    this.jdField_a_of_type_Aytw.a();
    b(3);
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Ayrp = null;
    e();
    b(6);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ErrorCode = 0;
    ayrl.a(this.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 12);
    c();
    o();
    if (paramBoolean)
    {
      String str = "";
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.UploadIp)) {
        str = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.UploadIp;
      }
      azld.a(paramInt1, paramInt2, str);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = 0;
    aysb.a("TroopFileUploadWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onFileInvailDel  nReportResultCode:" + paramInt1 + " nReportSecResultCode:" + paramInt2);
    if (this.jdField_a_of_type_Ayui != null) {
      this.jdField_a_of_type_Ayui.a(a(), false, paramInt2, this);
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Ayrp = null;
    e();
    b(6);
    ayrl.a(this.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 3, paramInt3);
    c();
    o();
    if (paramBoolean)
    {
      String str = "";
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.UploadIp)) {
        str = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.UploadIp;
      }
      azld.a(paramInt1, paramInt2, str);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = 0;
    aysb.a("TroopFileUploadWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onUploadErr  nReportResultCode:" + paramInt1 + " nReportSecResultCode:" + paramInt2 + " troopFileError:" + paramInt3);
    if (this.jdField_a_of_type_Ayui != null) {
      this.jdField_a_of_type_Ayui.a(a(), false, paramInt2, this);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, azie paramazie)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Ayrp = null;
    e();
    b(6);
    ayrl.a(this.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 3, paramazie);
    c();
    o();
    if (paramBoolean)
    {
      String str = "";
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.UploadIp)) {
        str = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.UploadIp;
      }
      azld.a(paramInt1, paramInt2, str);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = 0;
    aysb.a("TroopFileUploadWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onUploadErr  nReportResultCode:" + paramInt1 + " nReportSecResultCode:" + paramInt2 + " troopFileError:" + paramazie.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Ayui != null) {
      this.jdField_a_of_type_Ayui.a(a(), false, paramInt2, this);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    int j = ayrz.a(paramString1);
    int m = j;
    if (j == 0) {
      m = ayrz.b(paramString2);
    }
    int i6 = ayrz.c(paramString1);
    int k;
    if (!paramBoolean)
    {
      j = a(paramInt);
      k = a(paramInt, i6);
      if (paramInt == 9050) {
        j = 4;
      }
      a(j, k);
      this.jdField_a_of_type_Ayrn.jdField_e_of_type_Int = i6;
      this.jdField_a_of_type_Ayrn.f = m;
      n();
      this.jdField_a_of_type_Ayrn.jdField_e_of_type_Int = 0;
      this.jdField_a_of_type_Ayrn.f = 0;
      this.jdField_a_of_type_Ayrn.jdField_c_of_type_Int = 0;
      this.jdField_a_of_type_Ayrn.jdField_d_of_type_Int = 0;
      return;
    }
    aysb.a("TroopFileUploadWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onHasErr. upload fail. errCode:" + paramInt + " transferedSize:" + paramLong + " rspHeader:" + paramString2 + " errMsg:" + paramString1);
    int i2 = a(paramInt);
    int i4 = a(paramInt, i6);
    int i5 = 1;
    int i3 = azle.jdField_d_of_type_Int;
    int n;
    int i1;
    if (!badq.d(BaseApplication.getContext()))
    {
      k = 306;
      n = azle.jdField_b_of_type_Int;
      paramInt = azle.k;
      j = 106;
      i1 = i2;
    }
    for (;;)
    {
      a(i1, k);
      this.jdField_a_of_type_Ayrn.jdField_e_of_type_Int = i6;
      this.jdField_a_of_type_Ayrn.f = m;
      a(true, n, paramInt, j);
      return;
      if (paramInt == 9343)
      {
        k = 313;
        paramInt = azle.B;
        n = i3;
        j = i5;
        i1 = i2;
      }
      else if (paramInt == 9303)
      {
        i1 = 7;
        k = 707;
        n = azle.jdField_b_of_type_Int;
        paramInt = azle.j;
        j = 203;
      }
      else if (paramInt == 9042)
      {
        k = 311;
        paramInt = azle.jdField_g_of_type_Int;
        j = 206;
        n = i3;
        i1 = i2;
      }
      else if ((m == -38006) || (m == -38007) || (m == -38020))
      {
        k = 311;
        j = 206;
        paramInt = m;
        n = i3;
        i1 = i2;
      }
      else if (this.jdField_a_of_type_Aytw.c())
      {
        i1 = 4;
        if (m != 0) {
          paramInt = m;
        }
        j = 105;
        n = i3;
        k = i4;
      }
      else
      {
        n = i3;
        j = i5;
        k = i4;
        i1 = i2;
        if (m != 0)
        {
          paramInt = m;
          n = i3;
          j = i5;
          k = i4;
          i1 = i2;
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Boolean) {}
    while (!paramBoolean) {
      return;
    }
    a(3, 312);
    a(true, azle.jdField_d_of_type_Int, azle.v, 102);
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Ayrn.a();
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.bExtfTransfer = false;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.mExcitingSpeed = null;
    this.jdField_a_of_type_Ayrn.jdField_d_of_type_Long = System.currentTimeMillis();
    boolean bool2;
    if (this.jdField_a_of_type_AndroidOsBundle != null)
    {
      bool2 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("_wifi2mobile_resume_", false);
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.W2MPause == 2) {
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.W2MPause = 0;
        }
      }
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      aysb.c("TroopFileUploadWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] start filepath:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile + " bResueFromW2MPause:" + bool1);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Pausing = 0;
      if (!badq.g(BaseApplication.getContext()))
      {
        aysb.a("TroopFileUploadWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] no network");
        this.jdField_a_of_type_Boolean = true;
        b(6);
        ayrl.a(this.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 3, 106);
        this.jdField_a_of_type_Ayrn.jdField_c_of_type_Int = 9;
        this.jdField_a_of_type_Ayrn.jdField_d_of_type_Int = 901;
        c();
        this.jdField_a_of_type_Ayrn.a();
        azld.a(azle.jdField_b_of_type_Int, azle.k);
        return false;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Md5 == null) {
        l();
      }
      for (;;)
      {
        return true;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath == null) {
          m();
        } else {
          b();
        }
      }
    }
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.width;
  }
  
  public long b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile;
  }
  
  protected void b()
  {
    QQAppInterface localQQAppInterface = ayrz.a();
    if (localQQAppInterface == null)
    {
      aysb.a("TroopFileUploadWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] reqReUpload app=null");
      this.jdField_a_of_type_Ayrn.jdField_c_of_type_Int = 9;
      this.jdField_a_of_type_Ayrn.jdField_d_of_type_Int = 902;
      a(true, azle.jdField_b_of_type_Int, azle.w, 1);
      return;
    }
    aysb.c("TroopFileUploadWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] reqReUpload");
    ayrl.a(this.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 1);
    this.jdField_a_of_type_Ayrp = wln.a(localQQAppInterface, this.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Wmc);
    b(2);
  }
  
  protected void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.jdField_e_of_type_Long != paramLong1) {}
    while (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ScanPos = paramLong2;
  }
  
  public void b(boolean paramBoolean)
  {
    aysb.c("TroopFileUploadWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onUploadSuc. bHit:" + paramBoolean);
    e();
    b(5);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal;
    ayrl.a(this.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 6);
    j();
    Object localObject = com.tencent.commonsdk.util.HexUtil.bytes2HexStr(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Md5);
    String str = com.tencent.commonsdk.util.HexUtil.bytes2HexStr(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha);
    a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getInfo(this.jdField_d_of_type_Long), (String)localObject, str, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha3);
    this.jdField_a_of_type_Ayrp = null;
    this.jdField_a_of_type_Ayrn.jdField_a_of_type_Boolean = paramBoolean;
    a(0, 0);
    d();
    o();
    localObject = ayrz.a();
    str = this.jdField_d_of_type_Long + "";
    StringBuilder localStringBuilder = new StringBuilder();
    if ("/".equals(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.mParentId)) {}
    for (int j = 0;; j = 1)
    {
      awqx.b((QQAppInterface)localObject, "P_CliOper", "Grp_files", "", "oper", "upload_suc", 0, 0, str, j + "", "", "");
      azld.a(azle.jdField_a_of_type_Int, 0);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Md5 = null;
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha = null;
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.CheckKey = null;
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.UploadIp = null;
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = 0;
      if (this.jdField_a_of_type_Ayui != null) {
        this.jdField_a_of_type_Ayui.a(a(), true, 0, this);
      }
      return;
    }
  }
  
  protected boolean b()
  {
    return false;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.height;
  }
  
  public String c()
  {
    return aopg.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Md5);
  }
  
  protected void c()
  {
    if (b()) {}
    for (this.jdField_a_of_type_Ayrn.jdField_g_of_type_Int = 1;; this.jdField_a_of_type_Ayrn.jdField_g_of_type_Int = 0)
    {
      ayrm.a(this.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, "actGroupFileUp", this.jdField_a_of_type_Ayrn);
      return;
    }
  }
  
  public int d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.duration;
  }
  
  public String d()
  {
    return aopg.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha);
  }
  
  protected void d()
  {
    if (b()) {}
    for (this.jdField_a_of_type_Ayrn.jdField_g_of_type_Int = 1;; this.jdField_a_of_type_Ayrn.jdField_g_of_type_Int = 0)
    {
      ayrm.a(this.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Ayrn);
      return;
    }
  }
  
  public boolean d()
  {
    return true;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    new Handler().postDelayed(new TroopFileUploadWorker.3(this), 200L);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    b(false);
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      aysb.a("TroopFileUploadWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] mbUseLastUploadIp onOutDate. reqReUpload");
      this.jdField_b_of_type_Boolean = false;
      b();
      return;
    }
    aysb.a("TroopFileUploadWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onOutDate. upload fail");
    a(3, 302);
    this.jdField_a_of_type_Ayrn.f = -29120;
    a(true, azle.jdField_d_of_type_Int, -29120, 206);
  }
  
  public void i()
  {
    aysb.c("TroopFileUploadWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onRetrySend");
    if (this.jdField_a_of_type_Aytw != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = this.jdField_a_of_type_Aytw.a();
    }
    this.jdField_g_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Ayrn.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue;
    this.jdField_a_of_type_Ayrn.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_Ayrn.f = 0;
    this.jdField_a_of_type_Ayrn.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_Ayrn.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_Ayrn.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_Ayrn.jdField_d_of_type_JavaLangString = "";
  }
  
  public void k()
  {
    ayrl.a(this.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 0);
    b(7);
  }
  
  protected void l()
  {
    ayrl.a(this.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 0);
    this.jdField_e_of_type_Long = aytz.a().a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile, this, null);
    if (this.jdField_e_of_type_Long == 0L)
    {
      this.jdField_a_of_type_Ayrn.jdField_c_of_type_Int = 5;
      this.jdField_a_of_type_Ayrn.jdField_d_of_type_Int = 504;
      a(true, azle.jdField_b_of_type_Int, azle.w, 1);
      return;
    }
    b(1);
    aysb.c("TroopFileUploadWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] scanFile. cookie:" + this.jdField_e_of_type_Long);
  }
  
  protected void m()
  {
    QQAppInterface localQQAppInterface = ayrz.a();
    if (localQQAppInterface == null)
    {
      aysb.a("TroopFileUploadWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] reqUploadFile app=null");
      this.jdField_a_of_type_Ayrn.jdField_c_of_type_Int = 9;
      this.jdField_a_of_type_Ayrn.jdField_d_of_type_Int = 902;
      a(true, azle.jdField_b_of_type_Int, azle.w, 1);
      return;
    }
    aysb.c("TroopFileUploadWorker", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] reqUploadFile");
    ayrl.a(this.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 1);
    a();
    this.jdField_a_of_type_Ayrp = wln.a(localQQAppInterface, Long.valueOf(this.jdField_d_of_type_Long).longValue(), this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Wme);
    b(2);
  }
  
  protected final void n()
  {
    if (b()) {}
    for (this.jdField_a_of_type_Ayrn.jdField_g_of_type_Int = 1;; this.jdField_a_of_type_Ayrn.jdField_g_of_type_Int = 0)
    {
      ayrm.a(this.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, "actGroupFileUpDetail", this.jdField_a_of_type_Ayrn);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayul
 * JD-Core Version:    0.7.0.1
 */