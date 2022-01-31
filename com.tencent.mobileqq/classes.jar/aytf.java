import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.MD5;
import java.util.ArrayList;
import java.util.List;

public class aytf
  extends aysz
{
  protected List<String> a;
  wlu a;
  protected boolean a;
  protected String f;
  protected String g;
  
  protected aytf(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, aytb paramaytb)
  {
    super(paramLong, paramItem, paramBundle, paramaytb);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Wlu = new aytg(this);
  }
  
  public static aytf a(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, aytb paramaytb)
  {
    if (paramLong == 0L)
    {
      aysb.a("TroopZipInnerFileDownloadWorker", aysb.a, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      aysb.a("TroopZipInnerFileDownloadWorker", aysb.a, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      aysb.a("TroopZipInnerFileDownloadWorker", aysb.a, "getWoker. item.id=null");
      return null;
    }
    if (TextUtils.isEmpty(paramItem.zipFilePath))
    {
      aysb.a("TroopZipInnerFileDownloadWorker", aysb.a, "getWoker. zipFilePath=null");
      return null;
    }
    if (TextUtils.isEmpty(paramItem.zipInnerPath))
    {
      aysb.a("TroopZipInnerFileDownloadWorker", aysb.a, "getWoker. zipInnerPath=null");
      return null;
    }
    return new aytf(paramLong, paramItem, paramBundle, paramaytb);
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
    ayrl.a(this.b, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 8);
    QQAppInterface localQQAppInterface = ayrz.a();
    if (localQQAppInterface == null)
    {
      aysb.a("TroopZipInnerFileDownloadWorker", aysb.a, "[" + this.jdField_a_of_type_JavaLangString + "] reqDownload app=null");
      this.jdField_a_of_type_Ayrn.c = 9;
      this.jdField_a_of_type_Ayrn.d = 902;
      a(true, azle.b, azle.w, 1);
      return;
    }
    aysb.c("TroopZipInnerFileDownloadWorker", aysb.a, "[" + this.jdField_a_of_type_JavaLangString + "] reqDownload");
    Object localObject = ayrz.a(this.b);
    if (localObject != null)
    {
      ayoq localayoq = ((azih)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
      if (localayoq != null)
      {
        localObject = ((azih)localObject).a(localayoq.f);
        if (localObject != null)
        {
          localayoq.e = 8;
          ((ayoq)localObject).a(localayoq);
        }
      }
    }
    this.jdField_a_of_type_Boolean = false;
    this.g = null;
    this.jdField_a_of_type_Ayrp = wln.a(localQQAppInterface, this.b, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.zipFilePath, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.zipBusId, this.jdField_a_of_type_Wlu);
    b(1);
    azld.b();
  }
  
  protected void g()
  {
    QQAppInterface localQQAppInterface = ayrz.a();
    if (localQQAppInterface == null)
    {
      aysb.a("TroopZipInnerFileDownloadWorker", aysb.a, "[" + this.jdField_a_of_type_JavaLangString + "] startDownload app=null");
      this.jdField_a_of_type_Ayrn.c = 9;
      this.jdField_a_of_type_Ayrn.d = 902;
      a(true, azle.b, azle.w, 1);
      return;
    }
    String str = MD5.toMD5(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
    this.d = (this.jdField_c_of_type_JavaLangString + str);
    if (this.jdField_a_of_type_Ayst != null)
    {
      this.jdField_a_of_type_Ayst.c();
      this.jdField_a_of_type_Ayst = null;
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Ayrn.a = apdh.a(this.d);
    long l = ayrz.a();
    aysb.c("TroopZipInnerFileDownloadWorker", aysb.a, "[" + this.jdField_a_of_type_JavaLangString + "] startDownload. nSessionId:" + l + " firstIP=" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp + " urlParams:" + this.f + " mTmpFilePath:" + this.d);
    this.jdField_a_of_type_Ayst = aytc.a(localQQAppInterface, l, this.d, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal, this.jdField_a_of_type_JavaUtilList, this.f, null, this.jdField_a_of_type_Boolean, this.g);
    if (this.jdField_a_of_type_Ayst == null)
    {
      this.jdField_a_of_type_Ayrn.c = 9;
      this.jdField_a_of_type_Ayrn.d = 903;
      a(true, azle.b, azle.w, 1);
      return;
    }
    this.jdField_a_of_type_Ayst.a(this);
    this.jdField_a_of_type_Ayst.b();
    b(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aytf
 * JD-Core Version:    0.7.0.1
 */