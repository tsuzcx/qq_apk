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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.UploadFileRspBody;

public class atjz
  extends beyg
  implements atkn
{
  protected int a;
  protected long a;
  protected List<String> a;
  private Map<Integer, Integer> a;
  protected long b;
  protected List<String> b;
  private Map<Integer, Integer> b;
  protected long c;
  private Map<Integer, Integer> jdField_c_of_type_JavaUtilMap;
  private boolean jdField_c_of_type_Boolean;
  private boolean d = true;
  
  protected atjz(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, beyd parambeyd)
  {
    super(paramLong, paramItem, paramBundle, parambeyd);
  }
  
  public static beyg a(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, beyd parambeyd)
  {
    if (paramLong == 0L)
    {
      bevx.a("ExcitingTransfer.TroopFileUploadWorker", bevx.jdField_a_of_type_Int, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      bevx.a("ExcitingTransfer.TroopFileUploadWorker", bevx.jdField_a_of_type_Int, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null) {
      bevx.a("ExcitingTransfer.TroopFileUploadWorker", bevx.jdField_a_of_type_Int, "getWoker. item.id=null");
    }
    return new atjz(paramLong, paramItem, paramBundle, parambeyd);
  }
  
  private ExcitingTransferUploadResultRp a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Bexr != null)
    {
      localObject1 = localObject2;
      if ((this.jdField_a_of_type_Bexr instanceof atkk)) {
        localObject1 = ((atkk)this.jdField_a_of_type_Bexr).a();
      }
    }
    return localObject1;
  }
  
  private int b(int paramInt)
  {
    p();
    if (this.jdField_b_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt))) {
      return ((Integer)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(paramInt))).intValue();
    }
    return 9;
  }
  
  private int c(int paramInt)
  {
    q();
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt))) {
      return ((Integer)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt))).intValue();
    }
    return 9;
  }
  
  private void c(int paramInt)
  {
    boolean bool = true;
    Object localObject = a();
    atjy localatjy = new atjy(bevv.a());
    localatjy.c(paramInt);
    int i = f();
    if (localObject != null) {
      if (((ExcitingTransferUploadResultRp)localObject).m_nResult == 0L)
      {
        localatjy.a((ExcitingTransferUploadResultRp)localObject);
        paramInt = atwt.b(((ExcitingTransferUploadResultRp)localObject).m_strServerIp);
        localatjy.c(this.jdField_a_of_type_Long);
        localObject = atvo.f(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile);
        localatjy.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.troopuin, this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName, (String)localObject, this.jdField_c_of_type_Long);
        localatjy.c(this.jdField_a_of_type_Bevi.jdField_a_of_type_Boolean);
        long l = System.currentTimeMillis() - this.jdField_a_of_type_Bevi.jdField_d_of_type_Long;
        if (l <= 0L) {
          break label380;
        }
        localatjy.b(l);
        label152:
        l = this.jdField_a_of_type_Bevi.g;
        if (l <= 0L) {
          break label389;
        }
        localatjy.a(l);
      }
    }
    for (;;)
    {
      localatjy.a(i);
      localatjy.b(paramInt);
      localatjy.d(this.jdField_b_of_type_Boolean);
      localatjy.a(bool);
      return;
      bool = false;
      break;
      label217:
      float f;
      if (paramInt == 0)
      {
        bool = true;
        localObject = new ExcitingTransferUploadResultRp();
        ((ExcitingTransferUploadResultRp)localObject).m_nResult = paramInt;
        if (this.g > 0L) {
          ((ExcitingTransferUploadResultRp)localObject).m_u64HttpTime = (System.currentTimeMillis() - this.g);
        }
        if (this.jdField_a_of_type_Bevi.jdField_a_of_type_Long > 0L) {
          ((ExcitingTransferUploadResultRp)localObject).m_u64StartSize = this.jdField_a_of_type_Bevi.jdField_a_of_type_Long;
        }
        if (this.jdField_a_of_type_Bevi.jdField_b_of_type_Long > 0L) {
          ((ExcitingTransferUploadResultRp)localObject).m_u64TransferSize = this.jdField_a_of_type_Bevi.jdField_b_of_type_Long;
        }
        if ((((ExcitingTransferUploadResultRp)localObject).m_u64HttpTime <= 0L) || (((ExcitingTransferUploadResultRp)localObject).m_u64TransferSize <= 0L)) {
          break label371;
        }
        f = (float)((ExcitingTransferUploadResultRp)localObject).m_u64HttpTime / 1000.0F;
      }
      label371:
      for (((ExcitingTransferUploadResultRp)localObject).m_u64TransferSpeed = (((float)((ExcitingTransferUploadResultRp)localObject).m_u64TransferSize / f));; ((ExcitingTransferUploadResultRp)localObject).m_u64TransferSpeed = 0L)
      {
        ((ExcitingTransferUploadResultRp)localObject).m_bIsXTFValid = true;
        localatjy.a((ExcitingTransferUploadResultRp)localObject);
        paramInt = 0;
        break;
        bool = false;
        break label217;
      }
      label380:
      localatjy.b(0L);
      break label152;
      label389:
      localatjy.a(0L);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    QLog.w("ExcitingTransfer.TroopFileUploadWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] setCloseExtfAbility:" + this.jdField_c_of_type_Boolean + "->" + paramBoolean);
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  private int d(int paramInt)
  {
    r();
    if (this.jdField_c_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt))) {
      return ((Integer)this.jdField_c_of_type_JavaUtilMap.get(Integer.valueOf(paramInt))).intValue();
    }
    return 17;
  }
  
  private int f()
  {
    if ((this.jdField_a_of_type_Bexr != null) && ((this.jdField_a_of_type_Bexr instanceof atkk))) {
      return ((atkk)this.jdField_a_of_type_Bexr).g();
    }
    return 0;
  }
  
  private void p()
  {
    if (this.jdField_b_of_type_JavaUtilMap != null) {
      return;
    }
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(0), Integer.valueOf(0));
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(1), Integer.valueOf(307));
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(2), Integer.valueOf(901));
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(3), Integer.valueOf(300));
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(4), Integer.valueOf(307));
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(5), Integer.valueOf(309));
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(6), Integer.valueOf(308));
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(7), Integer.valueOf(10));
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(8), Integer.valueOf(707));
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(9), Integer.valueOf(4));
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(10), Integer.valueOf(4));
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(11), Integer.valueOf(9));
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(12), Integer.valueOf(309));
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(13), Integer.valueOf(312));
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(14), Integer.valueOf(309));
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(15), Integer.valueOf(309));
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(16), Integer.valueOf(300));
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(17), Integer.valueOf(9));
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(18), Integer.valueOf(307));
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(19), Integer.valueOf(4));
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(20), Integer.valueOf(4));
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(30), Integer.valueOf(2));
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(31), Integer.valueOf(1));
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(32), Integer.valueOf(503));
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(33), Integer.valueOf(8));
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(0), Integer.valueOf(0));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1), Integer.valueOf(3));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2), Integer.valueOf(3));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(3), Integer.valueOf(3));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(4), Integer.valueOf(3));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(5), Integer.valueOf(3));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(6), Integer.valueOf(3));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(10), Integer.valueOf(3));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(12), Integer.valueOf(3));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(13), Integer.valueOf(3));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(14), Integer.valueOf(3));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(15), Integer.valueOf(3));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(16), Integer.valueOf(3));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(18), Integer.valueOf(3));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(9), Integer.valueOf(4));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(19), Integer.valueOf(4));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(20), Integer.valueOf(4));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(17), Integer.valueOf(9));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(11), Integer.valueOf(9));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(7), Integer.valueOf(10));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(8), Integer.valueOf(7));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(30), Integer.valueOf(1));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(31), Integer.valueOf(1));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(32), Integer.valueOf(5));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(33), Integer.valueOf(8));
  }
  
  private void r()
  {
    if (this.jdField_c_of_type_JavaUtilMap != null) {
      return;
    }
    this.jdField_c_of_type_JavaUtilMap = new HashMap();
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(0), Integer.valueOf(0));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(1), Integer.valueOf(31));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(100), Integer.valueOf(31));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(101), Integer.valueOf(31));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(102), Integer.valueOf(31));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(2), Integer.valueOf(30));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(3), Integer.valueOf(5));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(300), Integer.valueOf(5));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(301), Integer.valueOf(5));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(302), Integer.valueOf(5));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(303), Integer.valueOf(5));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(304), Integer.valueOf(5));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(305), Integer.valueOf(5));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(313), Integer.valueOf(5));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(309), Integer.valueOf(5));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(306), Integer.valueOf(2));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(901), Integer.valueOf(2));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(4), Integer.valueOf(1));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(307), Integer.valueOf(1));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(308), Integer.valueOf(1));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(312), Integer.valueOf(13));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(5), Integer.valueOf(32));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(501), Integer.valueOf(32));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(502), Integer.valueOf(32));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(503), Integer.valueOf(32));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(504), Integer.valueOf(32));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(701), Integer.valueOf(32));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(702), Integer.valueOf(32));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(7), Integer.valueOf(11));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(700), Integer.valueOf(11));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(703), Integer.valueOf(11));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(704), Integer.valueOf(11));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(707), Integer.valueOf(8));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(708), Integer.valueOf(8));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(709), Integer.valueOf(8));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(710), Integer.valueOf(8));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(8), Integer.valueOf(33));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(9), Integer.valueOf(17));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(902), Integer.valueOf(17));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(904), Integer.valueOf(17));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(10), Integer.valueOf(7));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(11), Integer.valueOf(11));
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(12), Integer.valueOf(11));
  }
  
  private void s()
  {
    atjy localatjy = new atjy(bevv.a());
    localatjy.c(33);
    localatjy.c(this.jdField_a_of_type_Long);
    Object localObject = atvo.f(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile);
    localatjy.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.troopuin, this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName, (String)localObject, this.jdField_c_of_type_Long);
    localatjy.c(false);
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Bevi.jdField_d_of_type_Long;
    label119:
    float f;
    if (l > 0L)
    {
      localatjy.b(l);
      l = this.jdField_a_of_type_Bevi.g;
      if (l <= 0L) {
        break label297;
      }
      localatjy.a(l);
      localObject = new ExcitingTransferUploadResultRp();
      if (this.g > 0L) {
        ((ExcitingTransferUploadResultRp)localObject).m_u64HttpTime = (System.currentTimeMillis() - this.g);
      }
      if (this.jdField_a_of_type_Bevi.jdField_a_of_type_Long > 0L) {
        ((ExcitingTransferUploadResultRp)localObject).m_u64StartSize = this.jdField_a_of_type_Bevi.jdField_a_of_type_Long;
      }
      if (this.jdField_a_of_type_Bevi.jdField_b_of_type_Long > 0L) {
        ((ExcitingTransferUploadResultRp)localObject).m_u64TransferSize = this.jdField_a_of_type_Bevi.jdField_b_of_type_Long;
      }
      if ((((ExcitingTransferUploadResultRp)localObject).m_u64HttpTime <= 0L) || (((ExcitingTransferUploadResultRp)localObject).m_u64TransferSize <= 0L)) {
        break label306;
      }
      f = (float)((ExcitingTransferUploadResultRp)localObject).m_u64HttpTime / 1000.0F;
    }
    label297:
    label306:
    for (((ExcitingTransferUploadResultRp)localObject).m_u64TransferSpeed = (((float)((ExcitingTransferUploadResultRp)localObject).m_u64TransferSize / f));; ((ExcitingTransferUploadResultRp)localObject).m_u64TransferSpeed = 0L)
    {
      ((ExcitingTransferUploadResultRp)localObject).m_bIsXTFValid = true;
      ((ExcitingTransferUploadResultRp)localObject).m_nResult = 33;
      localatjy.a((ExcitingTransferUploadResultRp)localObject);
      localatjy.a(f());
      localatjy.d(this.jdField_b_of_type_Boolean);
      localatjy.a(false);
      return;
      localatjy.b(0L);
      break;
      localatjy.a(0L);
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
  
  protected bexr a(QQAppInterface paramQQAppInterface, long paramLong, boolean paramBoolean1, boolean paramBoolean2, String paramString)
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
    this.jdField_c_of_type_Long = atvo.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile);
    atkl localatkl = new atkl(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile, null, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Md5, null, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha, this.jdField_b_of_type_Long, (byte[])localObject1, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.CheckKey);
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
    paramString = new atkm(localArrayList1, localArrayList2, paramBoolean2, paramString, null);
    paramQQAppInterface = atkk.a(paramQQAppInterface, paramLong, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.troopuin, localatkl, paramString);
    if (paramQQAppInterface != null)
    {
      ((atkk)paramQQAppInterface).a(this);
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
    this.jdField_c_of_type_Int = f();
    a(c(paramInt), b(paramInt));
    atka localatka;
    if (paramInt != 0)
    {
      this.jdField_a_of_type_Bevi.e = 0;
      this.jdField_a_of_type_Bevi.f = 0;
      n();
      this.jdField_a_of_type_Bevi.jdField_c_of_type_Int = 0;
      this.jdField_a_of_type_Bevi.jdField_d_of_type_Int = 0;
      if (paramExcitingTransferUploaderRp == null) {
        break label211;
      }
      localatka = new atka(bevv.a());
      localatka.c(this.jdField_a_of_type_Long);
      String str = atvo.f(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile);
      localatka.c(paramInt);
      localatka.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.troopuin, this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName, str, this.jdField_c_of_type_Long);
      localatka.a(paramExcitingTransferUploaderRp);
      localatka.a(f());
      localatka.b(atwt.b(paramExcitingTransferUploaderRp.m_strServerIp));
      localatka.c(this.jdField_b_of_type_Boolean);
      if (paramInt != 0) {
        break label206;
      }
    }
    for (;;)
    {
      localatka.a(bool);
      return;
      this.jdField_a_of_type_Bevi.jdField_c_of_type_Int = 0;
      this.jdField_a_of_type_Bevi.jdField_d_of_type_Int = 0;
      o();
      break;
      label206:
      bool = false;
    }
    label211:
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
  
  public void az_()
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
    if (b()) {
      this.jdField_c_of_type_Int = f();
    }
    super.c();
    if (b())
    {
      if ((this.jdField_a_of_type_Bevi.jdField_c_of_type_Int == 8) || (this.jdField_a_of_type_Bevi.jdField_c_of_type_Int == 11) || (this.jdField_a_of_type_Bevi.jdField_c_of_type_Int == 12)) {
        s();
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
      j = this.jdField_a_of_type_Bevi.jdField_d_of_type_Int;
      int i = j;
      if (j == 0) {
        i = this.jdField_a_of_type_Bevi.jdField_c_of_type_Int;
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
    if (b()) {
      this.jdField_c_of_type_Int = f();
    }
    super.d();
    if (b()) {
      c(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atjz
 * JD-Core Version:    0.7.0.1
 */