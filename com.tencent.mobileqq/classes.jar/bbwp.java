import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.MD5;
import java.util.ArrayList;
import java.util.List;

public class bbwp
  extends bbwj
{
  protected List<String> a;
  yub a;
  protected boolean a;
  protected String f;
  protected String g;
  
  protected bbwp(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, bbwl parambbwl)
  {
    super(paramLong, paramItem, paramBundle, parambbwl);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Yub = new bbwq(this);
  }
  
  public static bbwp a(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, bbwl parambbwl)
  {
    if (paramLong == 0L)
    {
      bbvl.a("TroopZipInnerFileDownloadWorker", bbvl.a, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      bbvl.a("TroopZipInnerFileDownloadWorker", bbvl.a, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      bbvl.a("TroopZipInnerFileDownloadWorker", bbvl.a, "getWoker. item.id=null");
      return null;
    }
    if (TextUtils.isEmpty(paramItem.zipFilePath))
    {
      bbvl.a("TroopZipInnerFileDownloadWorker", bbvl.a, "getWoker. zipFilePath=null");
      return null;
    }
    if (TextUtils.isEmpty(paramItem.zipInnerPath))
    {
      bbvl.a("TroopZipInnerFileDownloadWorker", bbvl.a, "getWoker. zipInnerPath=null");
      return null;
    }
    return new bbwp(paramLong, paramItem, paramBundle, parambbwl);
  }
  
  String a(long paramLong)
  {
    return (paramLong & 0xFF) + "." + (paramLong >> 8 & 0xFF) + "." + (paramLong >> 16 & 0xFF) + "." + (paramLong >> 24 & 0xFF);
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    return super.a();
  }
  
  protected void f()
  {
    bbuv.a(this.b, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 8);
    QQAppInterface localQQAppInterface = bbvj.a();
    if (localQQAppInterface == null)
    {
      bbvl.a("TroopZipInnerFileDownloadWorker", bbvl.a, "[" + this.jdField_a_of_type_JavaLangString + "] reqDownload app=null");
      this.jdField_a_of_type_Bbux.c = 9;
      this.jdField_a_of_type_Bbux.d = 902;
      a(true, bcps.b, bcps.w, 1);
      return;
    }
    bbvl.c("TroopZipInnerFileDownloadWorker", bbvl.a, "[" + this.jdField_a_of_type_JavaLangString + "] reqDownload");
    Object localObject = bbvj.a(this.b);
    if (localObject != null)
    {
      bbsa localbbsa = ((bcmu)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
      if (localbbsa != null)
      {
        localObject = ((bcmu)localObject).a(localbbsa.f);
        if (localObject != null)
        {
          localbbsa.e = 8;
          ((bbsa)localObject).a(localbbsa);
        }
      }
    }
    this.jdField_a_of_type_Boolean = false;
    this.g = null;
    this.jdField_a_of_type_Bbuz = ytu.a(localQQAppInterface, this.b, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.zipFilePath, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.zipBusId, this.jdField_a_of_type_Yub);
    b(1);
    bcpr.b();
  }
  
  protected void g()
  {
    QQAppInterface localQQAppInterface = bbvj.a();
    if (localQQAppInterface == null)
    {
      bbvl.a("TroopZipInnerFileDownloadWorker", bbvl.a, "[" + this.jdField_a_of_type_JavaLangString + "] startDownload app=null");
      this.jdField_a_of_type_Bbux.c = 9;
      this.jdField_a_of_type_Bbux.d = 902;
      a(true, bcps.b, bcps.w, 1);
      return;
    }
    String str = MD5.toMD5(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
    this.d = (this.jdField_c_of_type_JavaLangString + str);
    if (this.jdField_a_of_type_Bbwd != null)
    {
      this.jdField_a_of_type_Bbwd.c();
      this.jdField_a_of_type_Bbwd = null;
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Bbux.a = arso.a(this.d);
    long l = bbvj.a();
    bbvl.c("TroopZipInnerFileDownloadWorker", bbvl.a, "[" + this.jdField_a_of_type_JavaLangString + "] startDownload. nSessionId:" + l + " firstIP=" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp + " urlParams:" + this.f + " mTmpFilePath:" + this.d);
    this.jdField_a_of_type_Bbwd = bbwm.a(localQQAppInterface, l, this.d, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal, this.jdField_a_of_type_JavaUtilList, this.f, null, this.jdField_a_of_type_Boolean, this.g);
    if (this.jdField_a_of_type_Bbwd == null)
    {
      this.jdField_a_of_type_Bbux.c = 9;
      this.jdField_a_of_type_Bbux.d = 903;
      a(true, bcps.b, bcps.w, 1);
      return;
    }
    this.jdField_a_of_type_Bbwd.a(this);
    this.jdField_a_of_type_Bbwd.b();
    b(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbwp
 * JD-Core Version:    0.7.0.1
 */