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

public class aztr
  implements aztm
{
  protected int a;
  protected Bundle a;
  protected azsf a;
  protected azsh a;
  protected aztl a;
  protected aztt a;
  public TroopFileTransferManager.Item a;
  public String a;
  protected Timer a;
  xba a;
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
  
  protected aztr(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, aztt paramaztt)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Azsf = new azsf();
    this.jdField_a_of_type_Xba = new azts(this);
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item = paramItem;
    this.jdField_a_of_type_Aztt = paramaztt;
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
  
  public static aztr b(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, aztt paramaztt)
  {
    if (paramLong == 0L)
    {
      azst.a("TroopFileDownloadWorker", azst.jdField_a_of_type_Int, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      azst.a("TroopFileDownloadWorker", azst.jdField_a_of_type_Int, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      azst.a("TroopFileDownloadWorker", azst.jdField_a_of_type_Int, "getWoker. item.id=null");
      return null;
    }
    return new aztr(paramLong, paramItem, paramBundle, paramaztt);
  }
  
  protected int a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return azse.a(paramInt1, paramInt2);
  }
  
  protected int a(int paramInt, Bundle paramBundle)
  {
    return 3;
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  protected aztl a(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, boolean paramBoolean, String paramString3)
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
      azst.c("TroopFileDownloadWorker", azst.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop. but had stoped. mStatus:" + this.jdField_a_of_type_Int);
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    a(8, 0);
    azst.c("TroopFileDownloadWorker", azst.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop. mStatus:" + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Aztl != null)
    {
      this.jdField_a_of_type_Aztl.c();
      this.jdField_a_of_type_Aztl = null;
    }
    i();
    if (this.jdField_a_of_type_Azsh != null)
    {
      xam.a(azsr.a(), this.jdField_a_of_type_Azsh);
      this.jdField_a_of_type_Azsh = null;
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
      azsd.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, j);
      b(0);
      this.jdField_a_of_type_Azsf.jdField_c_of_type_Int = i;
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
    if (this.jdField_a_of_type_Aztl != null)
    {
      this.jdField_a_of_type_Azsf.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Aztl.d();
      this.jdField_a_of_type_Azsf.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Aztl.e();
      this.jdField_a_of_type_Azsf.jdField_a_of_type_Int = this.jdField_a_of_type_Aztl.c();
      this.jdField_a_of_type_Azsf.jdField_b_of_type_Int = this.jdField_a_of_type_Aztl.d();
    }
    this.jdField_a_of_type_Azsf.jdField_c_of_type_Int = paramInt1;
    this.jdField_a_of_type_Azsf.jdField_d_of_type_Int = paramInt2;
    this.jdField_a_of_type_Azsf.jdField_b_of_type_Long = this.jdField_d_of_type_Long;
    if (this.jdField_c_of_type_Long != 0L)
    {
      this.jdField_a_of_type_Azsf.jdField_c_of_type_Long = (System.currentTimeMillis() - this.jdField_c_of_type_Long);
      if ((this.jdField_d_of_type_Long > 0L) && (this.jdField_a_of_type_Azsf.jdField_c_of_type_Long > 0L))
      {
        float f1 = (float)this.jdField_a_of_type_Azsf.jdField_c_of_type_Long / 1000.0F;
        this.jdField_a_of_type_Azsf.jdField_e_of_type_Long = (((float)this.jdField_d_of_type_Long / f1));
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Azsf.jdField_e_of_type_Long = 0L;
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
      azsd.b(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
      return;
    }
  }
  
  protected final void a(azqv paramazqv, String paramString1, String paramString2, String paramString3)
  {
    QQAppInterface localQQAppInterface = azsr.a();
    if (localQQAppInterface == null)
    {
      azst.a("TroopFileDownloadWorker", azst.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] addFMEntity fail app=null ");
      return;
    }
    FileManagerEntity localFileManagerEntity = apug.a(paramazqv);
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerUin = String.valueOf(paramazqv.jdField_b_of_type_Long);
    localFileManagerEntity.peerNick = bbcz.o(localQQAppInterface, localFileManagerEntity.peerUin);
    localFileManagerEntity.srvTime = (awzy.a() * 1000L);
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
        localFileManagerEntity.strFileSha3 = apgt.a(apug.b(paramazqv.jdField_a_of_type_JavaLangString));
      }
      if ((localFileManagerEntity.fileSize < 104857600L) && (TextUtils.isEmpty(localFileManagerEntity.strFileSHA))) {
        localFileManagerEntity.strFileSHA = apgt.a(apug.a(paramazqv.jdField_a_of_type_JavaLangString));
      }
    }
    localFileManagerEntity.str10Md5 = bbea.a(apug.d(paramazqv.jdField_a_of_type_JavaLangString));
    try
    {
      localFileManagerEntity.localModifyTime = new VFSFile(paramazqv.jdField_a_of_type_JavaLangString).lastModified();
      label264:
      localQQAppInterface.a().a(localFileManagerEntity);
      localFileManagerEntity.status = 1;
      localQQAppInterface.a().c(localFileManagerEntity);
      return;
    }
    catch (Exception paramazqv)
    {
      break label264;
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal >= this.jdField_a_of_type_Azsf.jdField_a_of_type_Long) {
      this.jdField_d_of_type_Long = (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal - this.jdField_a_of_type_Azsf.jdField_a_of_type_Long);
    }
    h();
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Azsh = null;
    i();
    b(4);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ErrorCode = 0;
    azsd.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 12);
    b();
    j();
    if (paramBoolean)
    {
      String str = "";
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp)) {
        str = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp;
      }
      bamv.b(paramInt1, paramInt2, str);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = 0;
    azst.a("TroopFileDownloadWorker", azst.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onFileInvailDel  nReportResultCode:" + paramInt1 + " nReportSecResultCode:" + paramInt2);
    if (this.jdField_a_of_type_Aztt != null) {
      this.jdField_a_of_type_Aztt.a(a(), false, paramInt2, this);
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Azsh = null;
    i();
    b(4);
    azsd.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 10, paramInt3);
    b();
    j();
    if (paramBoolean)
    {
      String str = "";
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp)) {
        str = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp;
      }
      bamv.b(paramInt1, paramInt2, str);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = 0;
    azst.a("TroopFileDownloadWorker", azst.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onDownloadErr  nReportResultCode:" + paramInt1 + " nReportSecResultCode:" + paramInt2 + " troopFileError:" + paramInt3);
    if (this.jdField_a_of_type_Aztt != null) {
      this.jdField_a_of_type_Aztt.a(a(), false, paramInt2, this);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2, Bundle paramBundle)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    int i = azsr.a(paramString1);
    int n = i;
    if (i == 0) {
      n = azsr.b(paramString2);
    }
    int i5 = azsr.c(paramString1);
    int j;
    if (!paramBoolean)
    {
      i = a(paramInt, paramBundle);
      j = a(paramInt, i5, paramBundle);
      if (paramInt == 9050) {
        i = 4;
      }
      a(i, j);
      this.jdField_a_of_type_Azsf.jdField_e_of_type_Int = i5;
      this.jdField_a_of_type_Azsf.f = n;
      k();
      this.jdField_a_of_type_Azsf.jdField_e_of_type_Int = 0;
      this.jdField_a_of_type_Azsf.f = 0;
      this.jdField_a_of_type_Azsf.jdField_c_of_type_Int = 0;
      this.jdField_a_of_type_Azsf.jdField_d_of_type_Int = 0;
      return;
    }
    azst.a("TroopFileDownloadWorker", azst.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onHasErr. download fail. errCode:" + paramInt + " transferedSize:" + paramLong);
    int i1 = a(paramInt, paramBundle);
    int i2 = a(paramInt, i5, paramBundle);
    int i4 = 1;
    int i3 = bamw.jdField_d_of_type_Int;
    int k;
    int m;
    if (!bbfj.d(BaseApplication.getContext()))
    {
      k = 306;
      j = bamw.jdField_b_of_type_Int;
      paramInt = bamw.k;
      i = 106;
      m = i1;
    }
    for (;;)
    {
      a(m, k);
      this.jdField_a_of_type_Azsf.jdField_e_of_type_Int = i5;
      this.jdField_a_of_type_Azsf.f = n;
      a(true, j, paramInt, i);
      return;
      if (paramInt == -5000)
      {
        m = 7;
        k = 708;
        j = bamw.jdField_b_of_type_Int;
        paramInt = bamw.h;
        i = 303;
      }
      else if (paramInt == -5001)
      {
        m = 7;
        k = 709;
        j = bamw.jdField_b_of_type_Int;
        paramInt = bamw.g;
        i = 304;
      }
      else if (paramInt == 9039)
      {
        m = 7;
        k = 710;
        j = bamw.jdField_b_of_type_Int;
        paramInt = bamw.n;
        i = 308;
      }
      else if (paramInt == 9004)
      {
        m = 3;
        k = 306;
        j = bamw.jdField_b_of_type_Int;
        paramInt = bamw.k;
        i = 106;
      }
      else if (paramInt == 9301)
      {
        m = 7;
        k = 705;
        j = bamw.jdField_b_of_type_Int;
        paramInt = bamw.i;
        i = 306;
      }
      else if (paramInt == -5001)
      {
        m = 7;
        k = 704;
        j = bamw.jdField_b_of_type_Int;
        paramInt = bamw.q;
        i = 305;
      }
      else if (this.jdField_a_of_type_Aztl.b())
      {
        m = 4;
        paramInt = bamw.p;
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
      azst.a("TroopFileDownloadWorker", azst.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] start filepath is null");
      return false;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Azsf.jdField_d_of_type_Long = System.currentTimeMillis();
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
      azst.c("TroopFileDownloadWorker", azst.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] start filename:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName + " filePath:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath + " bResueFromW2MPause:" + bool1);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Pausing = 0;
      Object localObject = azsr.a(this.jdField_b_of_type_Long);
      if (localObject != null)
      {
        localObject = ((bajy)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
        if (localObject != null) {
          this.jdField_a_of_type_Azsf.h = ((azpi)localObject).jdField_c_of_type_Int;
        }
      }
      if (!bbfj.g(BaseApplication.getContext()))
      {
        azst.a("TroopFileDownloadWorker", azst.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] no network");
        this.jdField_b_of_type_Boolean = true;
        b(4);
        this.jdField_a_of_type_Azsf.jdField_c_of_type_Int = 9;
        this.jdField_a_of_type_Azsf.jdField_d_of_type_Int = 901;
        b();
        this.jdField_a_of_type_Azsf.a();
        azsd.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 10, 106);
        bamv.b(bamw.jdField_b_of_type_Int, bamw.k);
        return false;
      }
      ThreadManager.post(new TroopFileDownloadWorker.1(this), 8, null, false);
      return true;
    }
  }
  
  protected void b()
  {
    if (b()) {}
    for (this.jdField_a_of_type_Azsf.g = 1;; this.jdField_a_of_type_Azsf.g = 0)
    {
      azse.b(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, "actGroupFileDown", this.jdField_a_of_type_Azsf);
      return;
    }
  }
  
  protected void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(String paramString)
  {
    azst.c("TroopFileDownloadWorker", azst.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onChangeUrl:" + paramString);
  }
  
  protected boolean b()
  {
    return false;
  }
  
  protected void c()
  {
    if (b()) {}
    for (this.jdField_a_of_type_Azsf.g = 1;; this.jdField_a_of_type_Azsf.g = 0)
    {
      azse.b(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Azsf);
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
      this.jdField_b_of_type_JavaLangString = ajsd.bl;
      localVFSFile = new VFSFile(this.jdField_b_of_type_JavaLangString);
      if (!localVFSFile.exists()) {
        localVFSFile.mkdirs();
      }
      this.jdField_c_of_type_JavaLangString = ajsd.bo;
      bool = true;
      localVFSFile = new VFSFile(this.jdField_c_of_type_JavaLangString);
    } while (localVFSFile.exists());
    return true | localVFSFile.mkdirs();
  }
  
  public void d()
  {
    azst.c("TroopFileDownloadWorker", azst.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onRetryDownload");
    if (this.jdField_a_of_type_Aztl != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = this.jdField_a_of_type_Aztl.b();
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Azsf.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue;
    this.jdField_a_of_type_Azsf.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_Azsf.f = 0;
    this.jdField_a_of_type_Azsf.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_Azsf.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_Azsf.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_Azsf.jdField_d_of_type_JavaLangString = "";
  }
  
  public void e()
  {
    azsd.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 8);
    b(5);
  }
  
  public void f()
  {
    this.jdField_c_of_type_Boolean = false;
    azsd.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 8);
    QQAppInterface localQQAppInterface = azsr.a();
    if (localQQAppInterface == null)
    {
      azst.a("TroopFileDownloadWorker", azst.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] reqDownload app=null");
      this.jdField_a_of_type_Azsf.jdField_c_of_type_Int = 9;
      this.jdField_a_of_type_Azsf.jdField_d_of_type_Int = 902;
      a(true, bamw.jdField_b_of_type_Int, bamw.w, 1);
      return;
    }
    azst.c("TroopFileDownloadWorker", azst.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] reqDownload");
    Object localObject = azsr.a(this.jdField_b_of_type_Long);
    if (localObject != null)
    {
      azpi localazpi = ((bajy)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
      if (localazpi != null)
      {
        localObject = ((bajy)localObject).a(localazpi.f);
        if (localObject != null)
        {
          localazpi.jdField_e_of_type_Int = 8;
          ((azpi)localObject).a(localazpi);
        }
      }
    }
    this.jdField_a_of_type_Azsh = xam.a(localQQAppInterface, this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 0, false, false, this.jdField_a_of_type_Xba);
    b(1);
    this.f = awzy.a();
    bamv.b();
  }
  
  protected void g()
  {
    QQAppInterface localQQAppInterface = azsr.a();
    if (localQQAppInterface == null)
    {
      azst.a("TroopFileDownloadWorker", azst.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] startDownload app=null");
      this.jdField_a_of_type_Azsf.jdField_c_of_type_Int = 9;
      this.jdField_a_of_type_Azsf.jdField_d_of_type_Int = 902;
      a(true, bamw.jdField_b_of_type_Int, bamw.w, 1);
      return;
    }
    if (this.jdField_a_of_type_Aztl != null)
    {
      this.jdField_a_of_type_Aztl.c();
      this.jdField_a_of_type_Aztl = null;
    }
    String str = "/ftn_handler/" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadUrl + "/?fname=" + bbea.b(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp);
    long l;
    boolean bool1;
    Object localObject1;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS))
    {
      if (apvm.b(localQQAppInterface))
      {
        QLog.i("TroopFileDownloadWorker<FileAssistant>", 1, "[Troop Download] download support IPv6. domain[" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS + "]");
        localArrayList.add(0, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS);
      }
    }
    else
    {
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Azsf.jdField_a_of_type_Long = apvd.a(this.jdField_d_of_type_JavaLangString);
      l = azsr.a();
      boolean bool2 = false;
      Object localObject2 = null;
      bool1 = bool2;
      localObject1 = localObject2;
      if (bakx.b(localQQAppInterface))
      {
        bool1 = bool2;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS))
        {
          bool1 = true;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS;
        }
      }
      azst.c("TroopFileDownloadWorker", azst.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] startDownload. nSessionId:" + l + " firstIP=" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp + " urlParams:" + str + " mTmpFilePath:" + this.jdField_d_of_type_JavaLangString + " bUseHttps:" + bool1 + " httpsDomain:" + (String)localObject1);
      if (!b()) {
        break label507;
      }
    }
    label507:
    for (this.jdField_a_of_type_Aztl = a(localQQAppInterface, l, this.jdField_d_of_type_JavaLangString, str, bool1, (String)localObject1);; this.jdField_a_of_type_Aztl = aztu.a(localQQAppInterface, l, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal, localArrayList, str, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.cookieValue, bool1, (String)localObject1))
    {
      if (this.jdField_a_of_type_Aztl != null) {
        break label545;
      }
      this.jdField_a_of_type_Azsf.jdField_c_of_type_Int = 9;
      this.jdField_a_of_type_Azsf.jdField_d_of_type_Int = 903;
      a(true, bamw.jdField_b_of_type_Int, bamw.w, 1);
      return;
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS);
      break;
    }
    label545:
    this.jdField_a_of_type_Aztl.a(this);
    this.jdField_a_of_type_Aztl.b();
    b(2);
  }
  
  protected void h()
  {
    long l = new VFSFile(this.jdField_d_of_type_JavaLangString).length();
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal != 0L) && (l != this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal))
    {
      azst.a("TroopFileDownloadWorker", azst.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "]  file size check fail. filesize:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal + " transSize:" + l);
      a(7, 704);
      a(true, bamw.jdField_b_of_type_Int, bamw.q, 305);
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
        if (bbdx.a(this.jdField_e_of_type_JavaLangString)) {
          this.jdField_e_of_type_JavaLangString = apug.b(this.jdField_e_of_type_JavaLangString);
        }
        if (apug.a(new VFSFile(this.jdField_d_of_type_JavaLangString), new VFSFile(this.jdField_e_of_type_JavaLangString))) {
          break;
        }
        azst.a("TroopFileDownloadWorker", azst.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] renameFile fail  mFilePath:" + this.jdField_e_of_type_JavaLangString);
        a(7, 706);
        a(true, bamw.jdField_b_of_type_Int, bamw.o, 307);
        return;
        if (i > j)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName.substring(0, i - j) + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName.substring(i);
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName = ((String)localObject1);
        }
      }
      azst.c("TroopFileDownloadWorker", azst.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onDownlaodSuc  mFilePath:" + this.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile = this.jdField_e_of_type_JavaLangString;
      int i = apug.a(apvd.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName));
      if (((i == 2) || (i == 0)) && (!apvd.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getThumbnailFile(this.jdField_b_of_type_Long, 383)))) {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.genThumb_Middle_OnGettedLargeOrOrigPic = true;
      }
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Azsh = null;
      i();
      b(3);
      azsd.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 11);
      Object localObject1 = HexUtil.bytes2HexStr(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Md5);
      Object localObject2 = HexUtil.bytes2HexStr(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha);
      a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getInfo(this.jdField_b_of_type_Long), (String)localObject1, (String)localObject2, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha3);
      a(0, 0);
      c();
      j();
      bamv.b(bamw.jdField_a_of_type_Int, 0);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = 0;
    } while (this.jdField_a_of_type_Aztt == null);
    this.jdField_a_of_type_Aztt.a(a(), true, 0, this);
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
    this.jdField_a_of_type_Azsf.a();
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
  }
  
  protected final void k()
  {
    if (b()) {}
    for (this.jdField_a_of_type_Azsf.g = 1;; this.jdField_a_of_type_Azsf.g = 0)
    {
      azse.b(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, "actGroupFileDownDetail", this.jdField_a_of_type_Azsf);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aztr
 * JD-Core Version:    0.7.0.1
 */