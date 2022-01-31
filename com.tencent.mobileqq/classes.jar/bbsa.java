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

public class bbsa
  implements bbrv
{
  protected int a;
  protected Bundle a;
  protected bbqo a;
  protected bbqq a;
  protected bbru a;
  protected bbsc a;
  public TroopFileTransferManager.Item a;
  public String a;
  protected Timer a;
  ypt a;
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
  
  protected bbsa(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, bbsc parambbsc)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Bbqo = new bbqo();
    this.jdField_a_of_type_Ypt = new bbsb(this);
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item = paramItem;
    this.jdField_a_of_type_Bbsc = parambbsc;
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
  
  public static bbsa b(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, bbsc parambbsc)
  {
    if (paramLong == 0L)
    {
      bbrc.a("TroopFileDownloadWorker", bbrc.jdField_a_of_type_Int, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      bbrc.a("TroopFileDownloadWorker", bbrc.jdField_a_of_type_Int, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      bbrc.a("TroopFileDownloadWorker", bbrc.jdField_a_of_type_Int, "getWoker. item.id=null");
      return null;
    }
    return new bbsa(paramLong, paramItem, paramBundle, parambbsc);
  }
  
  protected int a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return bbqn.a(paramInt1, paramInt2);
  }
  
  protected int a(int paramInt, Bundle paramBundle)
  {
    return 3;
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  protected bbru a(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, boolean paramBoolean, String paramString3)
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
      bbrc.c("TroopFileDownloadWorker", bbrc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop. but had stoped. mStatus:" + this.jdField_a_of_type_Int);
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    a(8, 0);
    bbrc.c("TroopFileDownloadWorker", bbrc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop. mStatus:" + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Bbru != null)
    {
      this.jdField_a_of_type_Bbru.c();
      this.jdField_a_of_type_Bbru = null;
    }
    i();
    if (this.jdField_a_of_type_Bbqq != null)
    {
      ypf.a(bbra.a(), this.jdField_a_of_type_Bbqq);
      this.jdField_a_of_type_Bbqq = null;
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
      bbqm.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, j);
      b(0);
      this.jdField_a_of_type_Bbqo.jdField_c_of_type_Int = i;
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
    if (this.jdField_a_of_type_Bbru != null)
    {
      this.jdField_a_of_type_Bbqo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bbru.d();
      this.jdField_a_of_type_Bbqo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Bbru.e();
      this.jdField_a_of_type_Bbqo.jdField_a_of_type_Int = this.jdField_a_of_type_Bbru.c();
      this.jdField_a_of_type_Bbqo.jdField_b_of_type_Int = this.jdField_a_of_type_Bbru.d();
    }
    this.jdField_a_of_type_Bbqo.jdField_c_of_type_Int = paramInt1;
    this.jdField_a_of_type_Bbqo.jdField_d_of_type_Int = paramInt2;
    this.jdField_a_of_type_Bbqo.jdField_b_of_type_Long = this.jdField_d_of_type_Long;
    if (this.jdField_c_of_type_Long != 0L)
    {
      this.jdField_a_of_type_Bbqo.jdField_c_of_type_Long = (System.currentTimeMillis() - this.jdField_c_of_type_Long);
      if ((this.jdField_d_of_type_Long > 0L) && (this.jdField_a_of_type_Bbqo.jdField_c_of_type_Long > 0L))
      {
        float f1 = (float)this.jdField_a_of_type_Bbqo.jdField_c_of_type_Long / 1000.0F;
        this.jdField_a_of_type_Bbqo.jdField_e_of_type_Long = (((float)this.jdField_d_of_type_Long / f1));
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Bbqo.jdField_e_of_type_Long = 0L;
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
      bbqm.b(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
      return;
    }
  }
  
  protected final void a(bbpe parambbpe, String paramString1, String paramString2, String paramString3)
  {
    QQAppInterface localQQAppInterface = bbra.a();
    if (localQQAppInterface == null)
    {
      bbrc.a("TroopFileDownloadWorker", bbrc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] addFMEntity fail app=null ");
      return;
    }
    FileManagerEntity localFileManagerEntity = arni.a(parambbpe);
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerUin = String.valueOf(parambbpe.jdField_b_of_type_Long);
    localFileManagerEntity.peerNick = bdbt.o(localQQAppInterface, localFileManagerEntity.peerUin);
    localFileManagerEntity.srvTime = (ayvc.a() * 1000L);
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
        localFileManagerEntity.strFileSha3 = aqzr.a(arni.b(parambbpe.jdField_a_of_type_JavaLangString));
      }
      if ((localFileManagerEntity.fileSize < 104857600L) && (TextUtils.isEmpty(localFileManagerEntity.strFileSHA))) {
        localFileManagerEntity.strFileSHA = aqzr.a(arni.a(parambbpe.jdField_a_of_type_JavaLangString));
      }
    }
    localFileManagerEntity.str10Md5 = bdcv.a(arni.d(parambbpe.jdField_a_of_type_JavaLangString));
    try
    {
      localFileManagerEntity.localModifyTime = new VFSFile(parambbpe.jdField_a_of_type_JavaLangString).lastModified();
      label264:
      localQQAppInterface.a().a(localFileManagerEntity);
      localFileManagerEntity.status = 1;
      localQQAppInterface.a().c(localFileManagerEntity);
      return;
    }
    catch (Exception parambbpe)
    {
      break label264;
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal >= this.jdField_a_of_type_Bbqo.jdField_a_of_type_Long) {
      this.jdField_d_of_type_Long = (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal - this.jdField_a_of_type_Bbqo.jdField_a_of_type_Long);
    }
    h();
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Bbqq = null;
    i();
    b(4);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ErrorCode = 0;
    bbqm.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 12);
    b();
    j();
    if (paramBoolean)
    {
      String str = "";
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp)) {
        str = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp;
      }
      bcli.b(paramInt1, paramInt2, str);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = 0;
    bbrc.a("TroopFileDownloadWorker", bbrc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onFileInvailDel  nReportResultCode:" + paramInt1 + " nReportSecResultCode:" + paramInt2);
    if (this.jdField_a_of_type_Bbsc != null) {
      this.jdField_a_of_type_Bbsc.a(a(), false, paramInt2, this);
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Bbqq = null;
    i();
    b(4);
    bbqm.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 10, paramInt3);
    b();
    j();
    if (paramBoolean)
    {
      String str = "";
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp)) {
        str = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp;
      }
      bcli.b(paramInt1, paramInt2, str);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = 0;
    bbrc.a("TroopFileDownloadWorker", bbrc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onDownloadErr  nReportResultCode:" + paramInt1 + " nReportSecResultCode:" + paramInt2 + " troopFileError:" + paramInt3);
    if (this.jdField_a_of_type_Bbsc != null) {
      this.jdField_a_of_type_Bbsc.a(a(), false, paramInt2, this);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2, Bundle paramBundle)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    int i = bbra.a(paramString1);
    int n = i;
    if (i == 0) {
      n = bbra.b(paramString2);
    }
    int i5 = bbra.c(paramString1);
    int j;
    if (!paramBoolean)
    {
      i = a(paramInt, paramBundle);
      j = a(paramInt, i5, paramBundle);
      if (paramInt == 9050) {
        i = 4;
      }
      a(i, j);
      this.jdField_a_of_type_Bbqo.jdField_e_of_type_Int = i5;
      this.jdField_a_of_type_Bbqo.f = n;
      k();
      this.jdField_a_of_type_Bbqo.jdField_e_of_type_Int = 0;
      this.jdField_a_of_type_Bbqo.f = 0;
      this.jdField_a_of_type_Bbqo.jdField_c_of_type_Int = 0;
      this.jdField_a_of_type_Bbqo.jdField_d_of_type_Int = 0;
      return;
    }
    bbrc.a("TroopFileDownloadWorker", bbrc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onHasErr. download fail. errCode:" + paramInt + " transferedSize:" + paramLong);
    int i1 = a(paramInt, paramBundle);
    int i2 = a(paramInt, i5, paramBundle);
    int i4 = 1;
    int i3 = bclj.jdField_d_of_type_Int;
    int k;
    int m;
    if (!bdee.d(BaseApplication.getContext()))
    {
      k = 306;
      j = bclj.jdField_b_of_type_Int;
      paramInt = bclj.k;
      i = 106;
      m = i1;
    }
    for (;;)
    {
      a(m, k);
      this.jdField_a_of_type_Bbqo.jdField_e_of_type_Int = i5;
      this.jdField_a_of_type_Bbqo.f = n;
      a(true, j, paramInt, i);
      return;
      if (paramInt == -5000)
      {
        m = 7;
        k = 708;
        j = bclj.jdField_b_of_type_Int;
        paramInt = bclj.h;
        i = 303;
      }
      else if (paramInt == -5001)
      {
        m = 7;
        k = 709;
        j = bclj.jdField_b_of_type_Int;
        paramInt = bclj.g;
        i = 304;
      }
      else if (paramInt == 9039)
      {
        m = 7;
        k = 710;
        j = bclj.jdField_b_of_type_Int;
        paramInt = bclj.n;
        i = 308;
      }
      else if (paramInt == 9004)
      {
        m = 3;
        k = 306;
        j = bclj.jdField_b_of_type_Int;
        paramInt = bclj.k;
        i = 106;
      }
      else if (paramInt == 9301)
      {
        m = 7;
        k = 705;
        j = bclj.jdField_b_of_type_Int;
        paramInt = bclj.i;
        i = 306;
      }
      else if (paramInt == -5001)
      {
        m = 7;
        k = 704;
        j = bclj.jdField_b_of_type_Int;
        paramInt = bclj.q;
        i = 305;
      }
      else if (this.jdField_a_of_type_Bbru.b())
      {
        m = 4;
        paramInt = bclj.p;
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
      bbrc.a("TroopFileDownloadWorker", bbrc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] start filepath is null");
      return false;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Bbqo.jdField_d_of_type_Long = System.currentTimeMillis();
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
      bbrc.c("TroopFileDownloadWorker", bbrc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] start filename:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName + " filePath:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath + " bResueFromW2MPause:" + bool1);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Pausing = 0;
      Object localObject = bbra.a(this.jdField_b_of_type_Long);
      if (localObject != null)
      {
        localObject = ((bcil)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
        if (localObject != null) {
          this.jdField_a_of_type_Bbqo.h = ((bbnr)localObject).jdField_c_of_type_Int;
        }
      }
      if (!bdee.g(BaseApplication.getContext()))
      {
        bbrc.a("TroopFileDownloadWorker", bbrc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] no network");
        this.jdField_b_of_type_Boolean = true;
        b(4);
        this.jdField_a_of_type_Bbqo.jdField_c_of_type_Int = 9;
        this.jdField_a_of_type_Bbqo.jdField_d_of_type_Int = 901;
        b();
        this.jdField_a_of_type_Bbqo.a();
        bbqm.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 10, 106);
        bcli.b(bclj.jdField_b_of_type_Int, bclj.k);
        return false;
      }
      ThreadManager.post(new TroopFileDownloadWorker.1(this), 8, null, false);
      return true;
    }
  }
  
  protected void b()
  {
    if (b()) {}
    for (this.jdField_a_of_type_Bbqo.g = 1;; this.jdField_a_of_type_Bbqo.g = 0)
    {
      bbqn.b(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, "actGroupFileDown", this.jdField_a_of_type_Bbqo);
      return;
    }
  }
  
  protected void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(String paramString)
  {
    bbrc.c("TroopFileDownloadWorker", bbrc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onChangeUrl:" + paramString);
  }
  
  protected boolean b()
  {
    return false;
  }
  
  protected void c()
  {
    if (b()) {}
    for (this.jdField_a_of_type_Bbqo.g = 1;; this.jdField_a_of_type_Bbqo.g = 0)
    {
      bbqn.b(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Bbqo);
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
      this.jdField_b_of_type_JavaLangString = aljq.bm;
      localVFSFile = new VFSFile(this.jdField_b_of_type_JavaLangString);
      if (!localVFSFile.exists()) {
        localVFSFile.mkdirs();
      }
      this.jdField_c_of_type_JavaLangString = aljq.bp;
      bool = true;
      localVFSFile = new VFSFile(this.jdField_c_of_type_JavaLangString);
    } while (localVFSFile.exists());
    return true | localVFSFile.mkdirs();
  }
  
  public void d()
  {
    bbrc.c("TroopFileDownloadWorker", bbrc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onRetryDownload");
    if (this.jdField_a_of_type_Bbru != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = this.jdField_a_of_type_Bbru.b();
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Bbqo.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue;
    this.jdField_a_of_type_Bbqo.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_Bbqo.f = 0;
    this.jdField_a_of_type_Bbqo.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_Bbqo.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_Bbqo.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_Bbqo.jdField_d_of_type_JavaLangString = "";
  }
  
  public void e()
  {
    bbqm.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 8);
    b(5);
  }
  
  public void f()
  {
    this.jdField_c_of_type_Boolean = false;
    bbqm.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 8);
    QQAppInterface localQQAppInterface = bbra.a();
    if (localQQAppInterface == null)
    {
      bbrc.a("TroopFileDownloadWorker", bbrc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] reqDownload app=null");
      this.jdField_a_of_type_Bbqo.jdField_c_of_type_Int = 9;
      this.jdField_a_of_type_Bbqo.jdField_d_of_type_Int = 902;
      a(true, bclj.jdField_b_of_type_Int, bclj.w, 1);
      return;
    }
    bbrc.c("TroopFileDownloadWorker", bbrc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] reqDownload");
    Object localObject = bbra.a(this.jdField_b_of_type_Long);
    if (localObject != null)
    {
      bbnr localbbnr = ((bcil)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
      if (localbbnr != null)
      {
        localObject = ((bcil)localObject).a(localbbnr.f);
        if (localObject != null)
        {
          localbbnr.jdField_e_of_type_Int = 8;
          ((bbnr)localObject).a(localbbnr);
        }
      }
    }
    this.jdField_a_of_type_Bbqq = ypf.a(localQQAppInterface, this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 0, false, false, this.jdField_a_of_type_Ypt);
    b(1);
    this.f = ayvc.a();
    bcli.b();
  }
  
  protected void g()
  {
    QQAppInterface localQQAppInterface = bbra.a();
    if (localQQAppInterface == null)
    {
      bbrc.a("TroopFileDownloadWorker", bbrc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] startDownload app=null");
      this.jdField_a_of_type_Bbqo.jdField_c_of_type_Int = 9;
      this.jdField_a_of_type_Bbqo.jdField_d_of_type_Int = 902;
      a(true, bclj.jdField_b_of_type_Int, bclj.w, 1);
      return;
    }
    if (this.jdField_a_of_type_Bbru != null)
    {
      this.jdField_a_of_type_Bbru.c();
      this.jdField_a_of_type_Bbru = null;
    }
    String str = "/ftn_handler/" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadUrl + "/?fname=" + bdcv.b(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp);
    long l;
    boolean bool1;
    Object localObject1;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS))
    {
      if (aroo.b(localQQAppInterface))
      {
        QLog.i("TroopFileDownloadWorker<FileAssistant>", 1, "[Troop Download] download support IPv6. domain[" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS + "]");
        localArrayList.add(0, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS);
      }
    }
    else
    {
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Bbqo.jdField_a_of_type_Long = arof.a(this.jdField_d_of_type_JavaLangString);
      l = bbra.a();
      boolean bool2 = false;
      Object localObject2 = null;
      bool1 = bool2;
      localObject1 = localObject2;
      if (bcjk.b(localQQAppInterface))
      {
        bool1 = bool2;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS))
        {
          bool1 = true;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS;
        }
      }
      bbrc.c("TroopFileDownloadWorker", bbrc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] startDownload. nSessionId:" + l + " firstIP=" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp + " urlParams:" + str + " mTmpFilePath:" + this.jdField_d_of_type_JavaLangString + " bUseHttps:" + bool1 + " httpsDomain:" + (String)localObject1);
      if (!b()) {
        break label507;
      }
    }
    label507:
    for (this.jdField_a_of_type_Bbru = a(localQQAppInterface, l, this.jdField_d_of_type_JavaLangString, str, bool1, (String)localObject1);; this.jdField_a_of_type_Bbru = bbsd.a(localQQAppInterface, l, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal, localArrayList, str, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.cookieValue, bool1, (String)localObject1))
    {
      if (this.jdField_a_of_type_Bbru != null) {
        break label545;
      }
      this.jdField_a_of_type_Bbqo.jdField_c_of_type_Int = 9;
      this.jdField_a_of_type_Bbqo.jdField_d_of_type_Int = 903;
      a(true, bclj.jdField_b_of_type_Int, bclj.w, 1);
      return;
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS);
      break;
    }
    label545:
    this.jdField_a_of_type_Bbru.a(this);
    this.jdField_a_of_type_Bbru.b();
    b(2);
  }
  
  protected void h()
  {
    long l = new VFSFile(this.jdField_d_of_type_JavaLangString).length();
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal != 0L) && (l != this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal))
    {
      bbrc.a("TroopFileDownloadWorker", bbrc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "]  file size check fail. filesize:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal + " transSize:" + l);
      a(7, 704);
      a(true, bclj.jdField_b_of_type_Int, bclj.q, 305);
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
        if (bdcs.a(this.jdField_e_of_type_JavaLangString)) {
          this.jdField_e_of_type_JavaLangString = arni.b(this.jdField_e_of_type_JavaLangString);
        }
        if (arni.a(new VFSFile(this.jdField_d_of_type_JavaLangString), new VFSFile(this.jdField_e_of_type_JavaLangString))) {
          break;
        }
        bbrc.a("TroopFileDownloadWorker", bbrc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] renameFile fail  mFilePath:" + this.jdField_e_of_type_JavaLangString);
        a(7, 706);
        a(true, bclj.jdField_b_of_type_Int, bclj.o, 307);
        return;
        if (i > j)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName.substring(0, i - j) + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName.substring(i);
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName = ((String)localObject1);
        }
      }
      bbrc.c("TroopFileDownloadWorker", bbrc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onDownlaodSuc  mFilePath:" + this.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile = this.jdField_e_of_type_JavaLangString;
      int i = arni.a(arof.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName));
      if (((i == 2) || (i == 0)) && (!arof.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getThumbnailFile(this.jdField_b_of_type_Long, 383)))) {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.genThumb_Middle_OnGettedLargeOrOrigPic = true;
      }
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Bbqq = null;
      i();
      b(3);
      bbqm.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 11);
      Object localObject1 = HexUtil.bytes2HexStr(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Md5);
      Object localObject2 = HexUtil.bytes2HexStr(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha);
      a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getInfo(this.jdField_b_of_type_Long), (String)localObject1, (String)localObject2, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha3);
      a(0, 0);
      c();
      j();
      bcli.b(bclj.jdField_a_of_type_Int, 0);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = 0;
    } while (this.jdField_a_of_type_Bbsc == null);
    this.jdField_a_of_type_Bbsc.a(a(), true, 0, this);
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
    this.jdField_a_of_type_Bbqo.a();
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
  }
  
  protected final void k()
  {
    if (b()) {}
    for (this.jdField_a_of_type_Bbqo.g = 1;; this.jdField_a_of_type_Bbqo.g = 0)
    {
      bbqn.b(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, "actGroupFileDownDetail", this.jdField_a_of_type_Bbqo);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbsa
 * JD-Core Version:    0.7.0.1
 */