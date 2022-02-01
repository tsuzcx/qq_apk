import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.MD5;
import java.util.ArrayList;
import java.util.List;

public class bexa
  extends bewu
{
  aare a;
  protected List<String> a;
  protected boolean a;
  protected String f;
  protected String g;
  
  protected bexa(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, beww parambeww)
  {
    super(paramLong, paramItem, paramBundle, parambeww);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Aare = new bexb(this);
  }
  
  public static bexa a(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, beww parambeww)
  {
    if (paramLong == 0L)
    {
      bevx.a("TroopZipInnerFileDownloadWorker", bevx.a, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      bevx.a("TroopZipInnerFileDownloadWorker", bevx.a, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      bevx.a("TroopZipInnerFileDownloadWorker", bevx.a, "getWoker. item.id=null");
      return null;
    }
    if (TextUtils.isEmpty(paramItem.zipFilePath))
    {
      bevx.a("TroopZipInnerFileDownloadWorker", bevx.a, "getWoker. zipFilePath=null");
      return null;
    }
    if (TextUtils.isEmpty(paramItem.zipInnerPath))
    {
      bevx.a("TroopZipInnerFileDownloadWorker", bevx.a, "getWoker. zipInnerPath=null");
      return null;
    }
    return new bexa(paramLong, paramItem, paramBundle, parambeww);
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
    bevg.a(this.b, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 8);
    QQAppInterface localQQAppInterface = bevv.a();
    if (localQQAppInterface == null)
    {
      bevx.a("TroopZipInnerFileDownloadWorker", bevx.a, "[" + this.jdField_a_of_type_JavaLangString + "] reqDownload app=null");
      this.jdField_a_of_type_Bevi.c = 9;
      this.jdField_a_of_type_Bevi.d = 902;
      a(true, bfuj.b, bfuj.w, 1);
      return;
    }
    bevx.c("TroopZipInnerFileDownloadWorker", bevx.a, "[" + this.jdField_a_of_type_JavaLangString + "] reqDownload");
    Object localObject = bevv.a(this.b);
    if (localObject != null)
    {
      besl localbesl = ((bfrm)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
      if (localbesl != null)
      {
        localObject = ((bfrm)localObject).a(localbesl.f);
        if (localObject != null)
        {
          localbesl.e = 8;
          ((besl)localObject).a(localbesl);
        }
      }
    }
    this.jdField_a_of_type_Boolean = false;
    this.g = null;
    this.jdField_a_of_type_Bevk = aaqt.a(localQQAppInterface, this.b, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.zipFilePath, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.zipBusId, this.jdField_a_of_type_Aare);
    b(1);
    bfui.b();
  }
  
  protected void g()
  {
    QQAppInterface localQQAppInterface = bevv.a();
    if (localQQAppInterface == null)
    {
      bevx.a("TroopZipInnerFileDownloadWorker", bevx.a, "[" + this.jdField_a_of_type_JavaLangString + "] startDownload app=null");
      this.jdField_a_of_type_Bevi.c = 9;
      this.jdField_a_of_type_Bevi.d = 902;
      a(true, bfuj.b, bfuj.w, 1);
      return;
    }
    String str = MD5.toMD5(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
    this.d = (this.jdField_c_of_type_JavaLangString + str);
    if (this.jdField_a_of_type_Bewp != null)
    {
      this.jdField_a_of_type_Bewp.c();
      this.jdField_a_of_type_Bewp = null;
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Bevi.a = atwl.a(this.d);
    long l = bevv.a();
    bevx.c("TroopZipInnerFileDownloadWorker", bevx.a, "[" + this.jdField_a_of_type_JavaLangString + "] startDownload. nSessionId:" + l + " firstIP=" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp + " urlParams:" + this.f + " mTmpFilePath:" + this.d);
    this.jdField_a_of_type_Bewp = bewx.a(localQQAppInterface, l, this.d, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal, this.jdField_a_of_type_JavaUtilList, this.f, null, this.jdField_a_of_type_Boolean, this.g);
    if (this.jdField_a_of_type_Bewp == null)
    {
      this.jdField_a_of_type_Bevi.c = 9;
      this.jdField_a_of_type_Bevi.d = 903;
      a(true, bfuj.b, bfuj.w, 1);
      return;
    }
    this.jdField_a_of_type_Bewp.a(this);
    this.jdField_a_of_type_Bewp.b();
    b(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bexa
 * JD-Core Version:    0.7.0.1
 */