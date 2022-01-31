import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker.1;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.UUID;

public class bbwj
  implements bbwe
{
  protected int a;
  protected Bundle a;
  protected bbux a;
  protected bbuz a;
  protected bbwd a;
  protected bbwl a;
  public TroopFileTransferManager.Item a;
  public String a;
  protected Timer a;
  yui a;
  protected long b;
  protected String b;
  public boolean b;
  protected long c;
  public String c;
  protected boolean c;
  protected long d;
  public String d;
  protected long e;
  protected String e;
  protected long f;
  protected long g;
  
  protected bbwj(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, bbwl parambbwl)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Bbux = new bbux();
    this.jdField_a_of_type_Yui = new bbwk(this);
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item = paramItem;
    this.jdField_a_of_type_Bbwl = parambbwl;
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
  
  public static bbwj b(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, bbwl parambbwl)
  {
    if (paramLong == 0L)
    {
      bbvl.a("TroopFileDownloadWorker", bbvl.jdField_a_of_type_Int, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      bbvl.a("TroopFileDownloadWorker", bbvl.jdField_a_of_type_Int, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      bbvl.a("TroopFileDownloadWorker", bbvl.jdField_a_of_type_Int, "getWoker. item.id=null");
      return null;
    }
    return new bbwj(paramLong, paramItem, paramBundle, parambbwl);
  }
  
  protected int a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return bbuw.a(paramInt1, paramInt2);
  }
  
  protected int a(int paramInt, Bundle paramBundle)
  {
    return 3;
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  protected bbwd a(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, boolean paramBoolean, String paramString3)
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
      bbvl.c("TroopFileDownloadWorker", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop. but had stoped. mStatus:" + this.jdField_a_of_type_Int);
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    a(8, 0);
    bbvl.c("TroopFileDownloadWorker", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop. mStatus:" + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Bbwd != null)
    {
      this.jdField_a_of_type_Bbwd.c();
      this.jdField_a_of_type_Bbwd = null;
    }
    i();
    if (this.jdField_a_of_type_Bbuz != null)
    {
      ytu.a(bbvj.a(), this.jdField_a_of_type_Bbuz);
      this.jdField_a_of_type_Bbuz = null;
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
      bbuv.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, j);
      b(0);
      this.jdField_a_of_type_Bbux.jdField_c_of_type_Int = i;
      b();
      j();
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
    if (this.jdField_a_of_type_Bbwd != null)
    {
      this.jdField_a_of_type_Bbux.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bbwd.d();
      this.jdField_a_of_type_Bbux.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Bbwd.e();
      this.jdField_a_of_type_Bbux.jdField_a_of_type_Int = this.jdField_a_of_type_Bbwd.c();
      this.jdField_a_of_type_Bbux.jdField_b_of_type_Int = this.jdField_a_of_type_Bbwd.d();
    }
    this.jdField_a_of_type_Bbux.jdField_c_of_type_Int = paramInt1;
    this.jdField_a_of_type_Bbux.jdField_d_of_type_Int = paramInt2;
    this.jdField_a_of_type_Bbux.jdField_b_of_type_Long = this.jdField_d_of_type_Long;
    if (this.jdField_c_of_type_Long != 0L)
    {
      this.jdField_a_of_type_Bbux.jdField_c_of_type_Long = (System.currentTimeMillis() - this.jdField_c_of_type_Long);
      if ((this.jdField_d_of_type_Long > 0L) && (this.jdField_a_of_type_Bbux.jdField_c_of_type_Long > 0L))
      {
        float f1 = (float)this.jdField_a_of_type_Bbux.jdField_c_of_type_Long / 1000.0F;
        this.jdField_a_of_type_Bbux.jdField_e_of_type_Long = (((float)this.jdField_d_of_type_Long / f1));
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Bbux.jdField_e_of_type_Long = 0L;
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
      bbuv.b(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
      return;
    }
  }
  
  protected final void a(bbtn parambbtn, String paramString1, String paramString2, String paramString3)
  {
    QQAppInterface localQQAppInterface = bbvj.a();
    if (localQQAppInterface == null)
    {
      bbvl.a("TroopFileDownloadWorker", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] addFMEntity fail app=null ");
      return;
    }
    FileManagerEntity localFileManagerEntity = arrr.a(parambbtn);
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerUin = String.valueOf(parambbtn.jdField_b_of_type_Long);
    localFileManagerEntity.peerNick = bdgc.o(localQQAppInterface, localFileManagerEntity.peerUin);
    localFileManagerEntity.srvTime = (ayzl.a() * 1000L);
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
        localFileManagerEntity.strFileSha3 = area.a(arrr.b(parambbtn.jdField_a_of_type_JavaLangString));
      }
      if ((localFileManagerEntity.fileSize < 104857600L) && (TextUtils.isEmpty(localFileManagerEntity.strFileSHA))) {
        localFileManagerEntity.strFileSHA = area.a(arrr.a(parambbtn.jdField_a_of_type_JavaLangString));
      }
    }
    localFileManagerEntity.str10Md5 = bdhe.a(arrr.d(parambbtn.jdField_a_of_type_JavaLangString));
    try
    {
      localFileManagerEntity.localModifyTime = new VFSFile(parambbtn.jdField_a_of_type_JavaLangString).lastModified();
      label264:
      localQQAppInterface.a().a(localFileManagerEntity);
      localFileManagerEntity.status = 1;
      localQQAppInterface.a().c(localFileManagerEntity);
      return;
    }
    catch (Exception parambbtn)
    {
      break label264;
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal >= this.jdField_a_of_type_Bbux.jdField_a_of_type_Long) {
      this.jdField_d_of_type_Long = (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal - this.jdField_a_of_type_Bbux.jdField_a_of_type_Long);
    }
    h();
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Bbuz = null;
    i();
    b(4);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ErrorCode = 0;
    bbuv.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 12);
    b();
    j();
    if (paramBoolean)
    {
      String str = "";
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp)) {
        str = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp;
      }
      bcpr.b(paramInt1, paramInt2, str);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = 0;
    bbvl.a("TroopFileDownloadWorker", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onFileInvailDel  nReportResultCode:" + paramInt1 + " nReportSecResultCode:" + paramInt2);
    if (this.jdField_a_of_type_Bbwl != null) {
      this.jdField_a_of_type_Bbwl.a(a(), false, paramInt2, this);
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Bbuz = null;
    i();
    b(4);
    bbuv.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 10, paramInt3);
    b();
    j();
    if (paramBoolean)
    {
      String str = "";
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp)) {
        str = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp;
      }
      bcpr.b(paramInt1, paramInt2, str);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = 0;
    bbvl.a("TroopFileDownloadWorker", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onDownloadErr  nReportResultCode:" + paramInt1 + " nReportSecResultCode:" + paramInt2 + " troopFileError:" + paramInt3);
    if (this.jdField_a_of_type_Bbwl != null) {
      this.jdField_a_of_type_Bbwl.a(a(), false, paramInt2, this);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2, Bundle paramBundle)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    int i = bbvj.a(paramString1);
    int n = i;
    if (i == 0) {
      n = bbvj.b(paramString2);
    }
    int i5 = bbvj.c(paramString1);
    int j;
    if (!paramBoolean)
    {
      i = a(paramInt, paramBundle);
      j = a(paramInt, i5, paramBundle);
      if (paramInt == 9050) {
        i = 4;
      }
      a(i, j);
      this.jdField_a_of_type_Bbux.jdField_e_of_type_Int = i5;
      this.jdField_a_of_type_Bbux.f = n;
      k();
      this.jdField_a_of_type_Bbux.jdField_e_of_type_Int = 0;
      this.jdField_a_of_type_Bbux.f = 0;
      this.jdField_a_of_type_Bbux.jdField_c_of_type_Int = 0;
      this.jdField_a_of_type_Bbux.jdField_d_of_type_Int = 0;
      return;
    }
    bbvl.a("TroopFileDownloadWorker", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onHasErr. download fail. errCode:" + paramInt + " transferedSize:" + paramLong);
    int i1 = a(paramInt, paramBundle);
    int i2 = a(paramInt, i5, paramBundle);
    int i4 = 1;
    int i3 = bcps.jdField_d_of_type_Int;
    int k;
    int m;
    if (!bdin.d(BaseApplication.getContext()))
    {
      k = 306;
      j = bcps.jdField_b_of_type_Int;
      paramInt = bcps.k;
      i = 106;
      m = i1;
    }
    for (;;)
    {
      a(m, k);
      this.jdField_a_of_type_Bbux.jdField_e_of_type_Int = i5;
      this.jdField_a_of_type_Bbux.f = n;
      a(true, j, paramInt, i);
      return;
      if (paramInt == -5000)
      {
        m = 7;
        k = 708;
        j = bcps.jdField_b_of_type_Int;
        paramInt = bcps.h;
        i = 303;
      }
      else if (paramInt == -5001)
      {
        m = 7;
        k = 709;
        j = bcps.jdField_b_of_type_Int;
        paramInt = bcps.g;
        i = 304;
      }
      else if (paramInt == 9039)
      {
        m = 7;
        k = 710;
        j = bcps.jdField_b_of_type_Int;
        paramInt = bcps.n;
        i = 308;
      }
      else if (paramInt == 9004)
      {
        m = 3;
        k = 306;
        j = bcps.jdField_b_of_type_Int;
        paramInt = bcps.k;
        i = 106;
      }
      else if (paramInt == 9301)
      {
        m = 7;
        k = 705;
        j = bcps.jdField_b_of_type_Int;
        paramInt = bcps.i;
        i = 306;
      }
      else if (paramInt == -5001)
      {
        m = 7;
        k = 704;
        j = bcps.jdField_b_of_type_Int;
        paramInt = bcps.q;
        i = 305;
      }
      else if (this.jdField_a_of_type_Bbwd.b())
      {
        m = 4;
        paramInt = bcps.p;
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
      bbvl.a("TroopFileDownloadWorker", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] start filepath is null");
      return false;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Bbux.jdField_d_of_type_Long = System.currentTimeMillis();
    this.f = 0L;
    this.g = 0L;
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
      bbvl.c("TroopFileDownloadWorker", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] start filename:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName + " filePath:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath + " bResueFromW2MPause:" + bool1);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Pausing = 0;
      Object localObject = bbvj.a(this.jdField_b_of_type_Long);
      if (localObject != null)
      {
        localObject = ((bcmu)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
        if (localObject != null) {
          this.jdField_a_of_type_Bbux.h = ((bbsa)localObject).jdField_c_of_type_Int;
        }
      }
      if (!bdin.g(BaseApplication.getContext()))
      {
        bbvl.a("TroopFileDownloadWorker", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] no network");
        this.jdField_b_of_type_Boolean = true;
        b(4);
        this.jdField_a_of_type_Bbux.jdField_c_of_type_Int = 9;
        this.jdField_a_of_type_Bbux.jdField_d_of_type_Int = 901;
        b();
        this.jdField_a_of_type_Bbux.a();
        bbuv.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 10, 106);
        bcpr.b(bcps.jdField_b_of_type_Int, bcps.k);
        return false;
      }
      ThreadManager.post(new TroopFileDownloadWorker.1(this), 8, null, false);
      return true;
    }
  }
  
  protected void b()
  {
    if (b()) {}
    for (this.jdField_a_of_type_Bbux.g = 1;; this.jdField_a_of_type_Bbux.g = 0)
    {
      bbuw.b(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, "actGroupFileDown", this.jdField_a_of_type_Bbux);
      return;
    }
  }
  
  protected void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(String paramString)
  {
    bbvl.c("TroopFileDownloadWorker", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onChangeUrl:" + paramString);
  }
  
  protected boolean b()
  {
    return false;
  }
  
  protected void c()
  {
    if (b()) {}
    for (this.jdField_a_of_type_Bbux.g = 1;; this.jdField_a_of_type_Bbux.g = 0)
    {
      bbuw.b(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Bbux);
      return;
    }
  }
  
  public boolean c()
  {
    boolean bool;
    if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {
      bool = false;
    }
    VFSFile localVFSFile;
    do
    {
      return bool;
      this.jdField_b_of_type_JavaLangString = alof.bm;
      localVFSFile = new VFSFile(this.jdField_b_of_type_JavaLangString);
      if (!localVFSFile.exists()) {
        localVFSFile.mkdirs();
      }
      this.jdField_c_of_type_JavaLangString = alof.bp;
      bool = true;
      localVFSFile = new VFSFile(this.jdField_c_of_type_JavaLangString);
    } while (localVFSFile.exists());
    return true | localVFSFile.mkdirs();
  }
  
  public void d()
  {
    bbvl.c("TroopFileDownloadWorker", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onRetryDownload");
    if (this.jdField_a_of_type_Bbwd != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = this.jdField_a_of_type_Bbwd.b();
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Bbux.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue;
    this.jdField_a_of_type_Bbux.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_Bbux.f = 0;
    this.jdField_a_of_type_Bbux.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_Bbux.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_Bbux.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_Bbux.jdField_d_of_type_JavaLangString = "";
  }
  
  public void e()
  {
    bbuv.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 8);
    b(5);
  }
  
  public void f()
  {
    this.jdField_c_of_type_Boolean = false;
    bbuv.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 8);
    QQAppInterface localQQAppInterface = bbvj.a();
    if (localQQAppInterface == null)
    {
      bbvl.a("TroopFileDownloadWorker", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] reqDownload app=null");
      this.jdField_a_of_type_Bbux.jdField_c_of_type_Int = 9;
      this.jdField_a_of_type_Bbux.jdField_d_of_type_Int = 902;
      a(true, bcps.jdField_b_of_type_Int, bcps.w, 1);
      return;
    }
    bbvl.c("TroopFileDownloadWorker", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] reqDownload");
    Object localObject = bbvj.a(this.jdField_b_of_type_Long);
    if (localObject != null)
    {
      bbsa localbbsa = ((bcmu)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
      if (localbbsa != null)
      {
        localObject = ((bcmu)localObject).a(localbbsa.f);
        if (localObject != null)
        {
          localbbsa.jdField_e_of_type_Int = 8;
          ((bbsa)localObject).a(localbbsa);
        }
      }
    }
    this.jdField_a_of_type_Bbuz = ytu.a(localQQAppInterface, this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 0, false, false, this.jdField_a_of_type_Yui);
    b(1);
    this.f = ayzl.a();
    bcpr.b();
  }
  
  protected void g()
  {
    QQAppInterface localQQAppInterface = bbvj.a();
    if (localQQAppInterface == null)
    {
      bbvl.a("TroopFileDownloadWorker", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] startDownload app=null");
      this.jdField_a_of_type_Bbux.jdField_c_of_type_Int = 9;
      this.jdField_a_of_type_Bbux.jdField_d_of_type_Int = 902;
      a(true, bcps.jdField_b_of_type_Int, bcps.w, 1);
      return;
    }
    if (this.jdField_a_of_type_Bbwd != null)
    {
      this.jdField_a_of_type_Bbwd.c();
      this.jdField_a_of_type_Bbwd = null;
    }
    String str = "/ftn_handler/" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadUrl + "/?fname=" + bdhe.b(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp);
    long l;
    boolean bool1;
    Object localObject1;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS))
    {
      if (arsx.b(localQQAppInterface))
      {
        QLog.i("TroopFileDownloadWorker<FileAssistant>", 1, "[Troop Download] download support IPv6. domain[" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS + "]");
        localArrayList.add(0, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS);
      }
    }
    else
    {
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Bbux.jdField_a_of_type_Long = arso.a(this.jdField_d_of_type_JavaLangString);
      l = bbvj.a();
      boolean bool2 = false;
      Object localObject2 = null;
      bool1 = bool2;
      localObject1 = localObject2;
      if (bcnt.b(localQQAppInterface))
      {
        bool1 = bool2;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS))
        {
          bool1 = true;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS;
        }
      }
      bbvl.c("TroopFileDownloadWorker", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] startDownload. nSessionId:" + l + " firstIP=" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp + " urlParams:" + str + " mTmpFilePath:" + this.jdField_d_of_type_JavaLangString + " bUseHttps:" + bool1 + " httpsDomain:" + (String)localObject1);
      if (!b()) {
        break label507;
      }
    }
    label507:
    for (this.jdField_a_of_type_Bbwd = a(localQQAppInterface, l, this.jdField_d_of_type_JavaLangString, str, bool1, (String)localObject1);; this.jdField_a_of_type_Bbwd = bbwm.a(localQQAppInterface, l, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal, localArrayList, str, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.cookieValue, bool1, (String)localObject1))
    {
      if (this.jdField_a_of_type_Bbwd != null) {
        break label545;
      }
      this.jdField_a_of_type_Bbux.jdField_c_of_type_Int = 9;
      this.jdField_a_of_type_Bbux.jdField_d_of_type_Int = 903;
      a(true, bcps.jdField_b_of_type_Int, bcps.w, 1);
      return;
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS);
      break;
    }
    label545:
    this.jdField_a_of_type_Bbwd.a(this);
    this.jdField_a_of_type_Bbwd.b();
    b(2);
  }
  
  protected void h()
  {
    long l = new VFSFile(this.jdField_d_of_type_JavaLangString).length();
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal != 0L) && (l != this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal))
    {
      bbvl.a("TroopFileDownloadWorker", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "]  file size check fail. filesize:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal + " transSize:" + l);
      a(7, 704);
      a(true, bcps.jdField_b_of_type_Int, bcps.q, 305);
      new VFSFile(this.jdField_d_of_type_JavaLangString).delete();
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue = 0L;
    }
    label438:
    do
    {
      return;
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
          break label438;
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
        this.jdField_e_of_type_JavaLangString = new VFSFile(this.jdField_b_of_type_JavaLangString + (String)localObject2).getAbsoluteFile().toString();
        if (bdhb.a(this.jdField_e_of_type_JavaLangString)) {
          this.jdField_e_of_type_JavaLangString = arrr.b(this.jdField_e_of_type_JavaLangString);
        }
        if (arrr.a(new VFSFile(this.jdField_d_of_type_JavaLangString), new VFSFile(this.jdField_e_of_type_JavaLangString))) {
          break;
        }
        bbvl.a("TroopFileDownloadWorker", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] renameFile fail  mFilePath:" + this.jdField_e_of_type_JavaLangString);
        a(7, 706);
        a(true, bcps.jdField_b_of_type_Int, bcps.o, 307);
        return;
        if (i > j)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName.substring(0, i - j) + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName.substring(i);
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName = ((String)localObject1);
        }
      }
      bbvl.c("TroopFileDownloadWorker", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onDownlaodSuc  mFilePath:" + this.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile = this.jdField_e_of_type_JavaLangString;
      int i = arrr.a(arso.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName));
      if (((i == 2) || (i == 0)) && (!arso.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getThumbnailFile(this.jdField_b_of_type_Long, 383)))) {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.genThumb_Middle_OnGettedLargeOrOrigPic = true;
      }
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Bbuz = null;
      i();
      b(3);
      bbuv.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 11);
      Object localObject1 = HexUtil.bytes2HexStr(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Md5);
      Object localObject2 = HexUtil.bytes2HexStr(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha);
      a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getInfo(this.jdField_b_of_type_Long), (String)localObject1, (String)localObject2, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha3);
      a(0, 0);
      c();
      j();
      bcpr.b(bcps.jdField_a_of_type_Int, 0);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = 0;
    } while (this.jdField_a_of_type_Bbwl == null);
    this.jdField_a_of_type_Bbwl.a(a(), true, 0, this);
  }
  
  protected void i()
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
  
  protected void j()
  {
    this.jdField_a_of_type_Bbux.a();
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
  }
  
  protected final void k()
  {
    if (b()) {}
    for (this.jdField_a_of_type_Bbux.g = 1;; this.jdField_a_of_type_Bbux.g = 0)
    {
      bbuw.b(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, "actGroupFileDownDetail", this.jdField_a_of_type_Bbux);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbwj
 * JD-Core Version:    0.7.0.1
 */