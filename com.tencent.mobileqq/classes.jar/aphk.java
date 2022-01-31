import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploaderRp;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.QLog;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.UploadFileRspBody;

public class aphk
  extends azvb
  implements aphy
{
  protected int a;
  protected long a;
  protected List<String> a;
  protected long b;
  protected List<String> b;
  protected long c;
  private boolean c;
  private boolean d = true;
  
  protected aphk(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, azuy paramazuy)
  {
    super(paramLong, paramItem, paramBundle, paramazuy);
  }
  
  public static azvb a(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, azuy paramazuy)
  {
    if (paramLong == 0L)
    {
      azsr.a("ExcitingTransfer.TroopFileUploadWorker", azsr.jdField_a_of_type_Int, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      azsr.a("ExcitingTransfer.TroopFileUploadWorker", azsr.jdField_a_of_type_Int, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null) {
      azsr.a("ExcitingTransfer.TroopFileUploadWorker", azsr.jdField_a_of_type_Int, "getWoker. item.id=null");
    }
    return new aphk(paramLong, paramItem, paramBundle, paramazuy);
  }
  
  private ExcitingTransferUploadResultRp a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Azum != null)
    {
      localObject1 = localObject2;
      if ((this.jdField_a_of_type_Azum instanceof aphv)) {
        localObject1 = ((aphv)this.jdField_a_of_type_Azum).a();
      }
    }
    return localObject1;
  }
  
  private int b(int paramInt)
  {
    int i = 307;
    switch (paramInt)
    {
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
    default: 
      i = 9;
    case 1: 
    case 4: 
    case 18: 
      return i;
    case 0: 
      return 0;
    case 2: 
      return 901;
    case 3: 
      return 300;
    case 5: 
      return 309;
    case 6: 
      return 308;
    case 7: 
      return 10;
    case 8: 
      return 707;
    case 9: 
      return 4;
    case 10: 
      return 4;
    case 11: 
      return 9;
    case 12: 
      return 309;
    case 13: 
      return 312;
    case 14: 
      return 309;
    case 15: 
      return 309;
    case 16: 
      return 300;
    case 17: 
      return 9;
    case 19: 
      return 4;
    case 20: 
      return 4;
    case 30: 
      return 2;
    case 31: 
      return 1;
    case 32: 
      return 503;
    }
    return 8;
  }
  
  private int c(int paramInt)
  {
    switch (paramInt)
    {
    case 11: 
    case 17: 
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
    default: 
      return 9;
    case 0: 
      return 0;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 10: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 18: 
      return 3;
    case 9: 
    case 19: 
    case 20: 
      return 4;
    case 7: 
      return 10;
    case 8: 
      return 7;
    case 30: 
    case 31: 
      return 1;
    case 32: 
      return 5;
    }
    return 8;
  }
  
  private void c(int paramInt)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    Object localObject = a();
    aphj localaphj = new aphj(azsp.a());
    localaphj.a(paramInt);
    if (localObject != null) {
      if (((ExcitingTransferUploadResultRp)localObject).m_nResult == 0L)
      {
        bool1 = bool2;
        localaphj.a((ExcitingTransferUploadResultRp)localObject);
        localaphj.c(this.jdField_a_of_type_Long);
        localObject = apue.f(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile);
        localaphj.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.troopuin, this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName, (String)localObject, this.jdField_c_of_type_Long);
        localaphj.c(this.jdField_a_of_type_Azsd.jdField_a_of_type_Boolean);
        long l = System.currentTimeMillis() - this.jdField_a_of_type_Azsd.jdField_d_of_type_Long;
        if (l <= 0L) {
          break label339;
        }
        localaphj.b(l);
        label143:
        l = this.jdField_a_of_type_Azsd.g;
        if (l <= 0L) {
          break label348;
        }
        localaphj.a(l);
      }
    }
    for (;;)
    {
      localaphj.a(bool1);
      return;
      bool1 = false;
      break;
      if (paramInt == 0) {
        bool1 = true;
      }
      localObject = new ExcitingTransferUploadResultRp();
      ((ExcitingTransferUploadResultRp)localObject).m_nResult = paramInt;
      if (this.g > 0L) {
        ((ExcitingTransferUploadResultRp)localObject).m_u64HttpTime = (System.currentTimeMillis() - this.g);
      }
      if (this.jdField_a_of_type_Azsd.jdField_a_of_type_Long > 0L) {
        ((ExcitingTransferUploadResultRp)localObject).m_u64StartSize = this.jdField_a_of_type_Azsd.jdField_a_of_type_Long;
      }
      if (this.jdField_a_of_type_Azsd.jdField_b_of_type_Long > 0L) {
        ((ExcitingTransferUploadResultRp)localObject).m_u64TransferSize = this.jdField_a_of_type_Azsd.jdField_b_of_type_Long;
      }
      float f;
      if ((((ExcitingTransferUploadResultRp)localObject).m_u64HttpTime > 0L) && (((ExcitingTransferUploadResultRp)localObject).m_u64TransferSize > 0L)) {
        f = (float)((ExcitingTransferUploadResultRp)localObject).m_u64HttpTime / 1000.0F;
      }
      for (((ExcitingTransferUploadResultRp)localObject).m_u64TransferSpeed = (((float)((ExcitingTransferUploadResultRp)localObject).m_u64TransferSize / f));; ((ExcitingTransferUploadResultRp)localObject).m_u64TransferSpeed = 0L)
      {
        ((ExcitingTransferUploadResultRp)localObject).m_bIsXTFValid = true;
        localaphj.a((ExcitingTransferUploadResultRp)localObject);
        break;
      }
      label339:
      localaphj.b(0L);
      break label143;
      label348:
      localaphj.a(0L);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    QLog.w("ExcitingTransfer.TroopFileUploadWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] setCloseExtfAbility:" + this.jdField_c_of_type_Boolean + "->" + paramBoolean);
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  private int d(int paramInt)
  {
    int i = 11;
    switch (paramInt)
    {
    default: 
      i = 17;
    case 7: 
    case 11: 
    case 12: 
    case 700: 
    case 703: 
    case 704: 
      return i;
    case 0: 
      return 0;
    case 1: 
    case 100: 
    case 101: 
    case 102: 
      return 31;
    case 2: 
      return 30;
    case 3: 
    case 300: 
    case 301: 
    case 302: 
    case 303: 
    case 304: 
    case 305: 
    case 309: 
    case 313: 
      return 5;
    case 306: 
    case 901: 
      return 2;
    case 4: 
    case 307: 
    case 308: 
      return 1;
    case 312: 
      return 13;
    case 5: 
    case 501: 
    case 502: 
    case 503: 
    case 504: 
    case 701: 
    case 702: 
      return 32;
    case 707: 
    case 708: 
    case 709: 
    case 710: 
      return 8;
    case 8: 
      return 33;
    case 9: 
    case 902: 
    case 904: 
      return 17;
    }
    return 7;
  }
  
  private void o()
  {
    aphj localaphj = new aphj(azsp.a());
    localaphj.a(33);
    localaphj.c(this.jdField_a_of_type_Long);
    Object localObject = apue.f(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile);
    localaphj.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.troopuin, this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName, (String)localObject, this.jdField_c_of_type_Long);
    localaphj.c(false);
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Azsd.jdField_d_of_type_Long;
    label119:
    float f;
    if (l > 0L)
    {
      localaphj.b(l);
      l = this.jdField_a_of_type_Azsd.g;
      if (l <= 0L) {
        break label279;
      }
      localaphj.a(l);
      localObject = new ExcitingTransferUploadResultRp();
      if (this.g > 0L) {
        ((ExcitingTransferUploadResultRp)localObject).m_u64HttpTime = (System.currentTimeMillis() - this.g);
      }
      if (this.jdField_a_of_type_Azsd.jdField_a_of_type_Long > 0L) {
        ((ExcitingTransferUploadResultRp)localObject).m_u64StartSize = this.jdField_a_of_type_Azsd.jdField_a_of_type_Long;
      }
      if (this.jdField_a_of_type_Azsd.jdField_b_of_type_Long > 0L) {
        ((ExcitingTransferUploadResultRp)localObject).m_u64TransferSize = this.jdField_a_of_type_Azsd.jdField_b_of_type_Long;
      }
      if ((((ExcitingTransferUploadResultRp)localObject).m_u64HttpTime <= 0L) || (((ExcitingTransferUploadResultRp)localObject).m_u64TransferSize <= 0L)) {
        break label288;
      }
      f = (float)((ExcitingTransferUploadResultRp)localObject).m_u64HttpTime / 1000.0F;
    }
    label279:
    label288:
    for (((ExcitingTransferUploadResultRp)localObject).m_u64TransferSpeed = (((float)((ExcitingTransferUploadResultRp)localObject).m_u64TransferSize / f));; ((ExcitingTransferUploadResultRp)localObject).m_u64TransferSpeed = 0L)
    {
      ((ExcitingTransferUploadResultRp)localObject).m_bIsXTFValid = true;
      ((ExcitingTransferUploadResultRp)localObject).m_nResult = 33;
      localaphj.a((ExcitingTransferUploadResultRp)localObject);
      localaphj.a(false);
      return;
      localaphj.b(0L);
      break;
      localaphj.a(0L);
      break label119;
    }
  }
  
  protected int a(int paramInt)
  {
    if (b()) {
      return c(paramInt);
    }
    return super.a(paramInt);
  }
  
  protected int a(int paramInt1, int paramInt2)
  {
    if (b()) {
      return b(paramInt1);
    }
    return super.a(paramInt1, paramInt2);
  }
  
  protected azum a(QQAppInterface paramQQAppInterface, long paramLong, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    QLog.i("ExcitingTransfer.TroopFileUploadWorker", 1, "^_^ nSessionID[" + paramLong + "] get ExtfFileUploader. bIsHttps:" + paramBoolean2 + " strHttpsDomain:" + paramString + " bResend:" + paramBoolean1);
    if ((TroopManager)paramQQAppInterface.getManager(52) == null)
    {
      QLog.e("ExcitingTransfer.TroopFileUploadWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] getCustomFileUploader.troopManager=null");
      return null;
    }
    this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.troopuin;
    Object localObject1 = null;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath)) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath.getBytes();
    }
    if (localObject1 == null)
    {
      QLog.e("ExcitingTransfer.TroopFileUploadWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] getCustomFileUploader. uuid err");
      return null;
    }
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_c_of_type_Long = apue.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile);
    aphw localaphw = new aphw(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile, null, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Md5, null, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha, this.jdField_b_of_type_Long, (byte[])localObject1, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.CheckKey);
    ArrayList localArrayList1 = new ArrayList();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      localObject3 = this.jdField_a_of_type_JavaUtilList.iterator();
      for (localObject1 = "";; localObject1 = (String)localObject1 + "[" + (String)localObject2 + ":" + this.jdField_a_of_type_Int + "] ")
      {
        localObject2 = localObject1;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject2 = (String)((Iterator)localObject3).next();
        localArrayList1.add(new ExcitingTransferHostInfo((String)localObject2, this.jdField_a_of_type_Int));
      }
    }
    Object localObject2 = "";
    Object localObject3 = "";
    ArrayList localArrayList2 = new ArrayList();
    localObject1 = localObject3;
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      localObject1 = localObject3;
      if (this.jdField_b_of_type_JavaUtilList.size() > 0)
      {
        localObject3 = this.jdField_b_of_type_JavaUtilList.iterator();
        String str;
        for (localObject1 = ""; ((Iterator)localObject3).hasNext(); localObject1 = (String)localObject1 + "[" + str + ":" + this.jdField_a_of_type_Int + "] ")
        {
          str = (String)((Iterator)localObject3).next();
          localArrayList2.add(new ExcitingTransferHostInfo(str, this.jdField_a_of_type_Int));
        }
      }
    }
    QLog.i("ExcitingTransfer.TroopFileUploadWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] ExtfGroupFileUploader LanIpV4list:" + (String)localObject2);
    QLog.i("ExcitingTransfer.TroopFileUploadWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] ExtfGroupFileUploader LanIpV6list:" + (String)localObject1);
    paramString = new aphx(localArrayList1, localArrayList2, paramBoolean2, paramString, null);
    paramQQAppInterface = aphv.a(paramQQAppInterface, paramLong, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.troopuin, localaphw, paramString);
    if (paramQQAppInterface != null)
    {
      ((aphv)paramQQAppInterface).a(this);
      return paramQQAppInterface;
    }
    QLog.e("ExcitingTransfer.TroopFileUploadWorker", 1, "^_^ [" + this.jdField_a_of_type_JavaLangString + "] get ExtfFileUploader fail.");
    return paramQQAppInterface;
  }
  
  protected void a()
  {
    if (b()) {}
    for (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.bExtfTransfer = true;; this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.bExtfTransfer = false)
    {
      QLog.i("ExcitingTransfer.TroopFileUploadWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] onBeforeReqUploadFile bExtfTransfer:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.bExtfTransfer);
      return;
    }
  }
  
  public void a(int paramInt, ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp) {}
  
  public void a(int paramInt, ExcitingTransferUploaderRp paramExcitingTransferUploaderRp)
  {
    boolean bool = true;
    if (paramInt != 0)
    {
      a(c(paramInt), b(paramInt));
      this.jdField_a_of_type_Azsd.e = 0;
      this.jdField_a_of_type_Azsd.f = 0;
      n();
      this.jdField_a_of_type_Azsd.c = 0;
      this.jdField_a_of_type_Azsd.jdField_d_of_type_Int = 0;
    }
    if (paramExcitingTransferUploaderRp != null)
    {
      aphl localaphl = new aphl(azsp.a());
      localaphl.c(this.jdField_a_of_type_Long);
      String str = apue.f(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile);
      localaphl.a(paramInt);
      localaphl.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.troopuin, this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName, str, this.jdField_c_of_type_Long);
      localaphl.a(paramExcitingTransferUploaderRp);
      if (paramInt == 0) {}
      for (;;)
      {
        localaphl.a(bool);
        return;
        bool = false;
      }
    }
    QLog.e("ExcitingTransfer.TroopFileUploadWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] onExtfSubUploaderResult DataReport fail. no rp");
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    float f;
    String str;
    if (paramLong3 > 1048576L)
    {
      f = (float)paramLong3 / 1048576.0F;
      str = new DecimalFormat("0.00").format(f);
      str = "加速上传 " + str + "MB/s";
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.mExcitingSpeed = str;
      return;
      if (paramLong3 > 1024L)
      {
        f = (float)paramLong3 / 1024.0F;
        str = new DecimalFormat("0.00").format(f);
        str = "加速上传 " + str + "KB/s";
      }
      else
      {
        str = "加速上传 " + paramLong3 + "KB/s";
      }
    }
  }
  
  protected void a(oidb_0x6d6.UploadFileRspBody paramUploadFileRspBody)
  {
    if ((b()) && (paramUploadFileRspBody != null))
    {
      if (paramUploadFileRspBody.str_upload_ip_lan_v4.has()) {
        this.jdField_a_of_type_JavaUtilList = paramUploadFileRspBody.str_upload_ip_lan_v4.get();
      }
      if (paramUploadFileRspBody.str_upload_ip_lan_v6.has()) {
        this.jdField_b_of_type_JavaUtilList = paramUploadFileRspBody.str_upload_ip_lan_v6.get();
      }
      if (paramUploadFileRspBody.uint32_upload_port.has()) {
        this.jdField_a_of_type_Int = paramUploadFileRspBody.uint32_upload_port.get();
      }
      if ("[" + this.jdField_a_of_type_JavaLangString + "] onReqUploadFileRspSuc LanIpV4list:{" + this.jdField_a_of_type_JavaUtilList == null) {
        break label128;
      }
      paramUploadFileRspBody = this.jdField_a_of_type_JavaUtilList.toString();
    }
    for (;;)
    {
      QLog.i("ExcitingTransfer.TroopFileUploadWorker", 1, paramUploadFileRspBody);
      return;
      label128:
      if ("} LanIpV6List:{" + this.jdField_b_of_type_JavaUtilList != null) {
        paramUploadFileRspBody = this.jdField_b_of_type_JavaUtilList.toString();
      } else {
        paramUploadFileRspBody = "} LanPort:" + this.jdField_a_of_type_Int;
      }
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if ((this.d) && (paramBoolean) && (b()))
    {
      QLog.e("ExcitingTransfer.TroopFileUploadWorker", 1, "*_* [" + this.jdField_a_of_type_JavaLangString + "] exciting tansfer fail. ftnUploader try again");
      c(paramInt);
      c(true);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath = null;
      a();
      return;
    }
    super.a(paramBoolean, paramLong, paramInt, paramString1, paramString2);
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_b_of_type_JavaUtilList = null;
    this.g = 0L;
    return super.a();
  }
  
  public void ay_()
  {
    this.g = System.currentTimeMillis();
  }
  
  protected void b()
  {
    if (b())
    {
      m();
      return;
    }
    super.b();
  }
  
  protected boolean b()
  {
    return !c();
  }
  
  protected void c()
  {
    super.c();
    if (b())
    {
      if ((this.jdField_a_of_type_Azsd.c == 8) || (this.jdField_a_of_type_Azsd.c == 11) || (this.jdField_a_of_type_Azsd.c == 12)) {
        o();
      }
    }
    else {
      return;
    }
    ExcitingTransferUploadResultRp localExcitingTransferUploadResultRp = a();
    int j;
    if (localExcitingTransferUploadResultRp != null) {
      j = (int)localExcitingTransferUploadResultRp.m_nResult;
    }
    for (;;)
    {
      c(j);
      return;
      j = this.jdField_a_of_type_Azsd.jdField_d_of_type_Int;
      int i = j;
      if (j == 0) {
        i = this.jdField_a_of_type_Azsd.c;
      }
      j = i;
      if (this.g != 0L) {
        j = d(i);
      }
    }
  }
  
  public boolean c()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  protected void d()
  {
    super.d();
    if (b()) {
      c(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aphk
 * JD-Core Version:    0.7.0.1
 */