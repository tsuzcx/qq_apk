import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker.1;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class befz
  implements befv
{
  protected int a;
  protected Bundle a;
  protected been a;
  protected beep a;
  protected befu a;
  protected begb a;
  public TroopFileTransferManager.Item a;
  public String a;
  zsa a;
  protected int b;
  protected long b;
  protected String b;
  public boolean b;
  protected long c;
  public String c;
  protected boolean c;
  protected long d;
  public String d;
  protected boolean d;
  protected long e;
  protected String e;
  protected long f;
  protected long g;
  
  protected befz(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, begb parambegb)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Been = new been();
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Zsa = new bega(this);
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item = paramItem;
    this.jdField_a_of_type_Begb = parambegb;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id != null) {}
    for (paramItem = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id.toString();; paramItem = "")
    {
      this.jdField_a_of_type_JavaLangString = paramItem;
      this.jdField_a_of_type_AndroidOsBundle = paramBundle;
      return;
    }
  }
  
  public static String a()
  {
    try
    {
      Thread.sleep(1L);
      long l = System.currentTimeMillis();
      String str = new SimpleDateFormat("yyyyMMddHHmmssSS", Locale.US).format(new Date(l));
      return str;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
    finally {}
  }
  
  public static befz b(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, begb parambegb)
  {
    if (paramLong == 0L)
    {
      befc.a("TroopFileDownloadWorker", befc.jdField_a_of_type_Int, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      befc.a("TroopFileDownloadWorker", befc.jdField_a_of_type_Int, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      befc.a("TroopFileDownloadWorker", befc.jdField_a_of_type_Int, "getWoker. item.id=null");
      return null;
    }
    return new befz(paramLong, paramItem, paramBundle, parambegb);
  }
  
  protected int a()
  {
    if (this.jdField_a_of_type_Befu == null) {
      return 0;
    }
    return ataw.c(this.jdField_a_of_type_Befu.d());
  }
  
  protected int a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return beem.a(paramInt1, paramInt2);
  }
  
  protected int a(int paramInt, Bundle paramBundle)
  {
    return 3;
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  protected befu a(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    return null;
  }
  
  public UUID a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id;
  }
  
  public void a(int paramInt)
  {
    int i = 8;
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Int != 5))
    {
      befc.c("TroopFileDownloadWorker", befc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop. but had stoped. mStatus:" + this.jdField_a_of_type_Int);
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    a(8, 0);
    befc.c("TroopFileDownloadWorker", befc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop. mStatus:" + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Befu != null)
    {
      this.jdField_a_of_type_Befu.c();
      this.jdField_a_of_type_Befu = null;
    }
    if (this.jdField_a_of_type_Beep != null)
    {
      zrj.a(befa.a(), this.jdField_a_of_type_Beep);
      this.jdField_a_of_type_Beep = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Pausing = 1;
    int j = 9;
    if (paramInt == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.W2MPause = 2;
      i = 11;
    }
    for (;;)
    {
      beel.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, j);
      b(0);
      this.jdField_a_of_type_Been.jdField_c_of_type_Int = i;
      b();
      i();
      return;
      if (paramInt == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Pausing = -1;
        i = 12;
      }
      else if (paramInt == 3)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Pausing = -1;
        j = 10;
        i = 11;
      }
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Befu != null)
    {
      this.jdField_a_of_type_Been.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Befu.d();
      this.jdField_a_of_type_Been.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Befu.e();
      this.jdField_a_of_type_Been.jdField_a_of_type_Int = this.jdField_a_of_type_Befu.c();
      this.jdField_a_of_type_Been.jdField_b_of_type_Int = this.jdField_a_of_type_Befu.d();
    }
    this.jdField_a_of_type_Been.jdField_c_of_type_Int = paramInt1;
    this.jdField_a_of_type_Been.jdField_d_of_type_Int = paramInt2;
    this.jdField_a_of_type_Been.jdField_b_of_type_Long = this.jdField_d_of_type_Long;
    if (this.jdField_c_of_type_Long != 0L)
    {
      this.jdField_a_of_type_Been.jdField_c_of_type_Long = (System.currentTimeMillis() - this.jdField_c_of_type_Long);
      if ((this.jdField_d_of_type_Long > 0L) && (this.jdField_a_of_type_Been.jdField_c_of_type_Long > 0L))
      {
        float f1 = (float)this.jdField_a_of_type_Been.jdField_c_of_type_Long / 1000.0F;
        this.jdField_a_of_type_Been.jdField_e_of_type_Long = (((float)this.jdField_d_of_type_Long / f1));
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Been.jdField_e_of_type_Long = 0L;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    if (paramLong1 > this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue) {}
    for (this.jdField_d_of_type_Long += paramLong1 - this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue;; this.jdField_d_of_type_Long = paramLong1)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue = paramLong1;
      paramLong1 = System.currentTimeMillis();
      if ((this.jdField_e_of_type_Long != 0L) && (paramLong1 - this.jdField_e_of_type_Long < 1500L)) {
        break;
      }
      this.jdField_e_of_type_Long = paramLong1;
      beel.b(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
      return;
    }
  }
  
  protected final void a(becp parambecp, String paramString1, String paramString2, String paramString3)
  {
    QQAppInterface localQQAppInterface = befa.a();
    if (localQQAppInterface == null)
    {
      befc.a("TroopFileDownloadWorker", befc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] addFMEntity fail app=null ");
      return;
    }
    FileManagerEntity localFileManagerEntity = aszt.a(parambecp);
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerUin = String.valueOf(parambecp.jdField_b_of_type_Long);
    localFileManagerEntity.peerNick = ContactUtils.getTroopNickNameByTroopCode(localQQAppInterface, localFileManagerEntity.peerUin);
    localFileManagerEntity.srvTime = (bbko.a() * 1000L);
    localFileManagerEntity.setCloudType(3);
    localFileManagerEntity.bSend = false;
    localFileManagerEntity.status = 1;
    localFileManagerEntity.fProgress = 1.0F;
    localFileManagerEntity.TroopUin = this.jdField_b_of_type_Long;
    localFileManagerEntity.strFileMd5 = paramString1;
    localFileManagerEntity.strFileSHA = paramString2;
    localFileManagerEntity.strFileSha3 = paramString3;
    if ((localFileManagerEntity.nFileType == 0) || (localFileManagerEntity.nFileType == 2))
    {
      if (TextUtils.isEmpty(localFileManagerEntity.strFileSha3)) {
        localFileManagerEntity.strFileSha3 = asnl.a(aszt.c(parambecp.jdField_a_of_type_JavaLangString));
      }
      if ((localFileManagerEntity.fileSize < 104857600L) && (TextUtils.isEmpty(localFileManagerEntity.strFileSHA))) {
        localFileManagerEntity.strFileSHA = asnl.a(aszt.a(parambecp.jdField_a_of_type_JavaLangString));
      }
    }
    localFileManagerEntity.str10Md5 = com.tencent.mobileqq.utils.HexUtil.bytes2HexStr(aszt.e(parambecp.jdField_a_of_type_JavaLangString));
    try
    {
      localFileManagerEntity.localModifyTime = new File(parambecp.jdField_a_of_type_JavaLangString).lastModified();
      label264:
      localQQAppInterface.getFileManagerDataCenter().a(localFileManagerEntity);
      localFileManagerEntity.status = 1;
      localQQAppInterface.getFileManagerDataCenter().c(localFileManagerEntity);
      return;
    }
    catch (Exception parambecp)
    {
      break label264;
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal >= this.jdField_a_of_type_Been.jdField_a_of_type_Long) {
      this.jdField_d_of_type_Long = (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal - this.jdField_a_of_type_Been.jdField_a_of_type_Long);
    }
    h();
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    befc.a(paramString1, paramInt, paramString2);
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Beep = null;
    b(4);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ErrorCode = 0;
    beel.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 12);
    b();
    i();
    if (paramBoolean)
    {
      String str = "";
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp)) {
        str = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp;
      }
      bfdx.b(paramInt1, paramInt2, str);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = 0;
    befc.a("TroopFileDownloadWorker", befc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onFileInvailDel  nReportResultCode:" + paramInt1 + " nReportSecResultCode:" + paramInt2);
    if (this.jdField_a_of_type_Begb != null) {
      this.jdField_a_of_type_Begb.a(a(), false, paramInt2, this);
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Beep = null;
    b(4);
    beel.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 10, paramInt3);
    b();
    i();
    if (paramBoolean)
    {
      String str = "";
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp)) {
        str = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp;
      }
      bfdx.b(paramInt1, paramInt2, str);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = 0;
    befc.a("TroopFileDownloadWorker", befc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onDownloadErr  nReportResultCode:" + paramInt1 + " nReportSecResultCode:" + paramInt2 + " troopFileError:" + paramInt3);
    if (this.jdField_a_of_type_Begb != null) {
      this.jdField_a_of_type_Begb.a(a(), false, paramInt2, this);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2, Bundle paramBundle)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    int i = befa.a(paramString1);
    int n = i;
    if (i == 0) {
      n = befa.b(paramString2);
    }
    int i5 = befa.c(paramString1);
    int j;
    if (!paramBoolean)
    {
      i = a(paramInt, paramBundle);
      j = a(paramInt, i5, paramBundle);
      if (paramInt == 9050) {
        i = 4;
      }
      a(i, j);
      this.jdField_a_of_type_Been.jdField_e_of_type_Int = i5;
      this.jdField_a_of_type_Been.f = n;
      j();
      this.jdField_a_of_type_Been.jdField_e_of_type_Int = 0;
      this.jdField_a_of_type_Been.f = 0;
      this.jdField_a_of_type_Been.jdField_c_of_type_Int = 0;
      this.jdField_a_of_type_Been.jdField_d_of_type_Int = 0;
      return;
    }
    a("TroopFileDownloadWorker", befc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onHasErr. download fail. errCode:" + paramInt + " transferedSize:" + paramLong);
    int i1 = a(paramInt, paramBundle);
    int i2 = a(paramInt, i5, paramBundle);
    int i4 = 1;
    int i3 = bfdy.jdField_d_of_type_Int;
    int k;
    int m;
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      k = 306;
      j = bfdy.jdField_b_of_type_Int;
      paramInt = bfdy.k;
      i = 106;
      m = i1;
    }
    for (;;)
    {
      a(m, k);
      this.jdField_a_of_type_Been.jdField_e_of_type_Int = i5;
      this.jdField_a_of_type_Been.f = n;
      a(true, j, paramInt, i);
      return;
      if (paramInt == -5000)
      {
        m = 7;
        k = 708;
        j = bfdy.jdField_b_of_type_Int;
        paramInt = bfdy.jdField_h_of_type_Int;
        i = 303;
      }
      else if (paramInt == -5001)
      {
        m = 7;
        k = 709;
        j = bfdy.jdField_b_of_type_Int;
        paramInt = bfdy.g;
        i = 304;
      }
      else if (paramInt == 9039)
      {
        m = 7;
        k = 710;
        j = bfdy.jdField_b_of_type_Int;
        paramInt = bfdy.n;
        i = 308;
      }
      else if (paramInt == 9004)
      {
        m = 3;
        k = 306;
        j = bfdy.jdField_b_of_type_Int;
        paramInt = bfdy.k;
        i = 106;
      }
      else if (paramInt == 9301)
      {
        m = 7;
        k = 705;
        j = bfdy.jdField_b_of_type_Int;
        paramInt = bfdy.i;
        i = 306;
      }
      else if (paramInt == -5001)
      {
        m = 7;
        k = 704;
        j = bfdy.jdField_b_of_type_Int;
        paramInt = bfdy.q;
        i = 305;
      }
      else if (this.jdField_a_of_type_Befu.b())
      {
        m = 4;
        paramInt = bfdy.p;
        i = 105;
        j = i3;
        k = i2;
      }
      else
      {
        j = i3;
        i = i4;
        k = i2;
        m = i1;
        if (n != 0)
        {
          paramInt = n;
          j = i3;
          i = i4;
          k = i2;
          m = i1;
        }
      }
    }
  }
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath))
    {
      befc.a("TroopFileDownloadWorker", befc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] start filepath is null");
      return false;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Been.jdField_d_of_type_Long = System.currentTimeMillis();
    this.f = 0L;
    this.g = 0L;
    this.jdField_d_of_type_Boolean = false;
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
      befc.c("TroopFileDownloadWorker", befc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] start filename:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName + " filePath:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath + " bResueFromW2MPause:" + bool1);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Pausing = 0;
      Object localObject = befa.a(this.jdField_b_of_type_Long);
      if (localObject != null)
      {
        localObject = ((bfbb)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
        if (localObject != null) {
          this.jdField_a_of_type_Been.jdField_h_of_type_Long = ((bebc)localObject).jdField_c_of_type_Int;
        }
      }
      if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext()))
      {
        befc.a("TroopFileDownloadWorker", befc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] no network");
        this.jdField_b_of_type_Boolean = true;
        b(4);
        this.jdField_a_of_type_Been.jdField_c_of_type_Int = 9;
        this.jdField_a_of_type_Been.jdField_d_of_type_Int = 901;
        b();
        this.jdField_a_of_type_Been.a();
        beel.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 10, 106);
        bfdx.b(bfdy.jdField_b_of_type_Int, bfdy.k);
        return false;
      }
      ThreadManager.post(new TroopFileDownloadWorker.1(this), 8, null, false);
      return true;
    }
  }
  
  protected void b()
  {
    int i = 1;
    been localbeen;
    if (b())
    {
      this.jdField_a_of_type_Been.g = 1;
      this.jdField_a_of_type_Been.jdField_h_of_type_Int = this.jdField_b_of_type_Int;
      this.jdField_a_of_type_Been.i = a();
      localbeen = this.jdField_a_of_type_Been;
      if (!this.jdField_d_of_type_Boolean) {
        break label86;
      }
    }
    for (;;)
    {
      localbeen.j = i;
      beem.b(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, "actGroupFileDown", this.jdField_a_of_type_Been);
      return;
      this.jdField_a_of_type_Been.g = 0;
      break;
      label86:
      i = 0;
    }
  }
  
  protected void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(String paramString)
  {
    befc.c("TroopFileDownloadWorker", befc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onChangeUrl:" + paramString);
  }
  
  protected boolean b()
  {
    return false;
  }
  
  protected void c()
  {
    int i = 1;
    been localbeen;
    if (b())
    {
      this.jdField_a_of_type_Been.g = 1;
      this.jdField_a_of_type_Been.jdField_h_of_type_Int = this.jdField_b_of_type_Int;
      this.jdField_a_of_type_Been.i = a();
      localbeen = this.jdField_a_of_type_Been;
      if (!this.jdField_d_of_type_Boolean) {
        break label86;
      }
    }
    for (;;)
    {
      localbeen.j = i;
      beem.b(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Been, "actGroupFileDown");
      return;
      this.jdField_a_of_type_Been.g = 0;
      break;
      label86:
      i = 0;
    }
  }
  
  public boolean c()
  {
    boolean bool;
    if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {
      bool = false;
    }
    File localFile;
    do
    {
      return bool;
      this.jdField_b_of_type_JavaLangString = AppConstants.SDCARD_FILE_SAVE_PATH;
      localFile = new File(this.jdField_b_of_type_JavaLangString);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      this.jdField_c_of_type_JavaLangString = AppConstants.SDCARD_FILE_SAVE_TROOPTMP_PATH;
      bool = true;
      localFile = new File(this.jdField_c_of_type_JavaLangString);
    } while (localFile.exists());
    return true | localFile.mkdirs();
  }
  
  public void d()
  {
    befc.c("TroopFileDownloadWorker", befc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onRetryDownload");
    if (this.jdField_a_of_type_Befu != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = this.jdField_a_of_type_Befu.b();
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Been.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue;
    this.jdField_a_of_type_Been.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_Been.f = 0;
    this.jdField_a_of_type_Been.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_Been.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_Been.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_Been.jdField_d_of_type_JavaLangString = "";
  }
  
  public void e()
  {
    beel.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 8);
    b(5);
  }
  
  public void f()
  {
    this.jdField_c_of_type_Boolean = false;
    beel.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 8);
    QQAppInterface localQQAppInterface = befa.a();
    if (localQQAppInterface == null)
    {
      befc.a("TroopFileDownloadWorker", befc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] reqDownload app=null");
      this.jdField_a_of_type_Been.jdField_c_of_type_Int = 9;
      this.jdField_a_of_type_Been.jdField_d_of_type_Int = 902;
      a(true, bfdy.jdField_b_of_type_Int, bfdy.w, 1);
      return;
    }
    befc.c("TroopFileDownloadWorker", befc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] reqDownload");
    Object localObject = befa.a(this.jdField_b_of_type_Long);
    if (localObject != null)
    {
      bebc localbebc = ((bfbb)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
      if (localbebc != null)
      {
        localObject = ((bfbb)localObject).a(localbebc.f);
        if (localObject != null)
        {
          localbebc.jdField_e_of_type_Int = 8;
          ((bebc)localObject).a(localbebc);
        }
      }
    }
    this.jdField_a_of_type_Beep = zrj.a(localQQAppInterface, this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 0, false, false, this.jdField_a_of_type_Zsa);
    b(1);
    this.f = bbko.a();
    bfdx.b();
  }
  
  protected void g()
  {
    QQAppInterface localQQAppInterface = befa.a();
    if (localQQAppInterface == null)
    {
      befc.a("TroopFileDownloadWorker", befc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] startDownload app=null");
      this.jdField_a_of_type_Been.jdField_c_of_type_Int = 9;
      this.jdField_a_of_type_Been.jdField_d_of_type_Int = 902;
      a(true, bfdy.jdField_b_of_type_Int, bfdy.w, 1);
      return;
    }
    if (this.jdField_a_of_type_Befu != null)
    {
      this.jdField_a_of_type_Befu.c();
      this.jdField_a_of_type_Befu = null;
    }
    String str = "/ftn_handler/" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadUrl + "/?fname=" + com.tencent.mobileqq.utils.HexUtil.String2HexString(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp);
    Object localObject1;
    long l;
    boolean bool1;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS)) {
      if (asgv.a().a(localQQAppInterface, 3))
      {
        QLog.i("TroopFileDownloadWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] [IPv6-File] download troopfile. is config enable IPv6. domain[" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS + "]");
        localObject1 = new asgw(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS, 0);
        localObject1 = asgv.a().a(localQQAppInterface, (asgw)localObject1, 3);
        if ((localObject1 != null) && (!((asgy)localObject1).a()))
        {
          if (asgv.a())
          {
            QLog.d("TroopFileDownloadWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] [IPv6-File] download troopfile. debugIsDisableIPv4OnDoubleStack");
            localArrayList.clear();
          }
          asgv.a(((asgy)localObject1).jdField_a_of_type_JavaUtilList, localArrayList, true, false);
          this.jdField_b_of_type_Int = 2;
          if (((asgy)localObject1).jdField_a_of_type_Int == 1) {
            this.jdField_b_of_type_Int = 3;
          }
          QLog.i("TroopFileDownloadWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] [IPv6-File] download troopfile. use IPv6. iplist:" + localArrayList.toString());
          this.jdField_c_of_type_Long = System.currentTimeMillis();
          this.jdField_a_of_type_Been.jdField_a_of_type_Long = FileUtil.getFileSize(this.jdField_d_of_type_JavaLangString);
          l = befa.a();
          boolean bool2 = false;
          Object localObject2 = null;
          bool1 = bool2;
          localObject1 = localObject2;
          if (bfby.b(localQQAppInterface))
          {
            bool1 = bool2;
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS))
            {
              bool1 = true;
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS;
            }
          }
          this.jdField_d_of_type_Boolean = bool1;
          befc.c("TroopFileDownloadWorker", befc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] startDownload. nSessionId:" + l + " firstIP=" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp + " urlParams:" + str + " mTmpFilePath:" + this.jdField_d_of_type_JavaLangString + " bUseHttps:" + bool1 + " httpsDomain:" + (String)localObject1);
          if (!b()) {
            break label745;
          }
        }
      }
    }
    label745:
    for (this.jdField_a_of_type_Befu = a(localQQAppInterface, l, this.jdField_d_of_type_JavaLangString, str, bool1, (String)localObject1);; this.jdField_a_of_type_Befu = begc.a(localQQAppInterface, l, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal, localArrayList, str, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.cookieValue, bool1, (String)localObject1))
    {
      if (this.jdField_a_of_type_Befu != null) {
        break label783;
      }
      this.jdField_a_of_type_Been.jdField_c_of_type_Int = 9;
      this.jdField_a_of_type_Been.jdField_d_of_type_Int = 903;
      a(true, bfdy.jdField_b_of_type_Int, bfdy.w, 1);
      return;
      QLog.i("TroopFileDownloadWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] [IPv6-File] download troopfile. use IPv4");
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS);
      this.jdField_b_of_type_Int = 1;
      break;
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS);
      this.jdField_b_of_type_Int = 1;
      break;
      this.jdField_b_of_type_Int = 1;
      break;
    }
    label783:
    this.jdField_a_of_type_Befu.a(this);
    this.jdField_a_of_type_Befu.b();
    b(2);
  }
  
  protected void h()
  {
    long l1 = new File(this.jdField_d_of_type_JavaLangString).length();
    long l2 = l1;
    File localFile;
    if (l1 == 0L)
    {
      QLog.i("TroopFileDownloadWorkerfile_debug", 1, "vfs file get length error. use normal try again.");
      localFile = new File(this.jdField_d_of_type_JavaLangString);
    }
    try
    {
      l2 = localFile.length();
      l1 = l2;
    }
    catch (Exception localException)
    {
      label627:
      do
      {
        for (;;)
        {
          QLog.i("TroopFileDownloadWorkerfile_debug", 1, "normal file get length exception: " + localException.getMessage());
        }
        int j;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName.length() > 85)
        {
          j = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName.lastIndexOf('.');
          i = j;
          if (j < 0) {
            i = 0;
          }
          j = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName.length() - 85;
          if (i != 0) {
            break label627;
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName.substring(0, 85);
        }
        for (;;)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName;
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.NameForSave))
          {
            localObject1 = localObject2;
            if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.SafeCheckRes == 2) {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.NameForSave;
            }
          }
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = a();
          }
          this.jdField_e_of_type_JavaLangString = new File(this.jdField_b_of_type_JavaLangString + (String)localObject2).getAbsoluteFile().toString();
          if (FileUtils.fileExists(this.jdField_e_of_type_JavaLangString)) {
            this.jdField_e_of_type_JavaLangString = aszt.b(this.jdField_e_of_type_JavaLangString);
          }
          boolean bool2 = aszt.a(new File(this.jdField_d_of_type_JavaLangString), new File(this.jdField_e_of_type_JavaLangString));
          boolean bool1 = bool2;
          if (!bool2)
          {
            bool1 = aszt.a(new File(this.jdField_d_of_type_JavaLangString), new File(this.jdField_e_of_type_JavaLangString));
            QLog.e("TroopFileDownloadWorker", 1, "rename with vfs error, normalResult[" + bool1 + "]");
          }
          if (bool1) {
            break;
          }
          befc.a("TroopFileDownloadWorker", befc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] renameFile fail  mFilePath:" + this.jdField_e_of_type_JavaLangString);
          a(7, 706);
          a(true, bfdy.jdField_b_of_type_Int, bfdy.o, 307);
          return;
          if (i > j)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName.substring(0, i - j) + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName.substring(i);
            this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName = ((String)localObject1);
          }
        }
        befc.c("TroopFileDownloadWorker", befc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onDownlaodSuc  mFilePath:" + this.jdField_e_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile = this.jdField_e_of_type_JavaLangString;
        int i = aszt.a(FileUtil.getExtension(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName));
        if (((i == 2) || (i == 0)) && (!FileUtil.isFileExists(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getThumbnailFile(this.jdField_b_of_type_Long, 383)))) {
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.genThumb_Middle_OnGettedLargeOrOrigPic = true;
        }
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_Beep = null;
        b(3);
        beel.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 11);
        Object localObject1 = com.tencent.commonsdk.util.HexUtil.bytes2HexStr(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Md5);
        Object localObject2 = com.tencent.commonsdk.util.HexUtil.bytes2HexStr(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha);
        a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getInfo(this.jdField_b_of_type_Long), (String)localObject1, (String)localObject2, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha3);
        if (5 == aszt.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName))
        {
          localObject1 = befa.a();
          if (localObject1 != null) {
            ((QQAppInterface)localObject1).getFileManagerEngine().a().a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
          }
        }
        a(0, 0);
        c();
        if (!b()) {
          k();
        }
        i();
        bfdx.b(bfdy.jdField_a_of_type_Int, 0);
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = 0;
      } while (this.jdField_a_of_type_Begb == null);
      this.jdField_a_of_type_Begb.a(a(), true, 0, this);
    }
    QLog.i("TroopFileDownloadWorkerfile_debug", 1, "normal file get length[" + l1 + "]");
    l2 = l1;
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal != 0L) && (l2 != this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal))
    {
      befc.a("TroopFileDownloadWorker", befc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "]  file size check fail. filesize:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal + " transSize:" + l2);
      a(7, 704);
      a(true, bfdy.jdField_b_of_type_Int, bfdy.q, 305);
      new File(this.jdField_d_of_type_JavaLangString).delete();
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue = 0L;
      return;
    }
  }
  
  protected void i()
  {
    this.jdField_a_of_type_Been.a();
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
  }
  
  protected final void j()
  {
    int i = 1;
    been localbeen;
    if (b())
    {
      this.jdField_a_of_type_Been.g = 1;
      this.jdField_a_of_type_Been.jdField_h_of_type_Int = this.jdField_b_of_type_Int;
      this.jdField_a_of_type_Been.i = a();
      localbeen = this.jdField_a_of_type_Been;
      if (!this.jdField_d_of_type_Boolean) {
        break label86;
      }
    }
    for (;;)
    {
      localbeen.j = i;
      beem.b(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, "actGroupFileDownDetail", this.jdField_a_of_type_Been);
      return;
      this.jdField_a_of_type_Been.g = 0;
      break;
      label86:
      i = 0;
    }
  }
  
  protected void k()
  {
    int i = 1;
    been localbeen;
    if (b())
    {
      this.jdField_a_of_type_Been.g = 1;
      this.jdField_a_of_type_Been.jdField_h_of_type_Int = this.jdField_b_of_type_Int;
      this.jdField_a_of_type_Been.i = a();
      localbeen = this.jdField_a_of_type_Been;
      if (!this.jdField_d_of_type_Boolean) {
        break label86;
      }
    }
    for (;;)
    {
      localbeen.j = i;
      beem.b(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Been, "actGroupFileDownDetail");
      return;
      this.jdField_a_of_type_Been.g = 0;
      break;
      label86:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     befz
 * JD-Core Version:    0.7.0.1
 */