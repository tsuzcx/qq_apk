import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.MD5;
import java.util.ArrayList;
import java.util.List;

public class aztv
  extends aztp
{
  protected List<String> a;
  xaw a;
  protected boolean a;
  protected String f;
  protected String g;
  
  protected aztv(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, aztr paramaztr)
  {
    super(paramLong, paramItem, paramBundle, paramaztr);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Xaw = new aztw(this);
  }
  
  public static aztv a(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, aztr paramaztr)
  {
    if (paramLong == 0L)
    {
      azsr.a("TroopZipInnerFileDownloadWorker", azsr.a, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      azsr.a("TroopZipInnerFileDownloadWorker", azsr.a, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      azsr.a("TroopZipInnerFileDownloadWorker", azsr.a, "getWoker. item.id=null");
      return null;
    }
    if (TextUtils.isEmpty(paramItem.zipFilePath))
    {
      azsr.a("TroopZipInnerFileDownloadWorker", azsr.a, "getWoker. zipFilePath=null");
      return null;
    }
    if (TextUtils.isEmpty(paramItem.zipInnerPath))
    {
      azsr.a("TroopZipInnerFileDownloadWorker", azsr.a, "getWoker. zipInnerPath=null");
      return null;
    }
    return new aztv(paramLong, paramItem, paramBundle, paramaztr);
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
    azsb.a(this.b, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 8);
    QQAppInterface localQQAppInterface = azsp.a();
    if (localQQAppInterface == null)
    {
      azsr.a("TroopZipInnerFileDownloadWorker", azsr.a, "[" + this.jdField_a_of_type_JavaLangString + "] reqDownload app=null");
      this.jdField_a_of_type_Azsd.c = 9;
      this.jdField_a_of_type_Azsd.d = 902;
      a(true, bami.b, bami.w, 1);
      return;
    }
    azsr.c("TroopZipInnerFileDownloadWorker", azsr.a, "[" + this.jdField_a_of_type_JavaLangString + "] reqDownload");
    Object localObject = azsp.a(this.b);
    if (localObject != null)
    {
      azpg localazpg = ((bajk)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
      if (localazpg != null)
      {
        localObject = ((bajk)localObject).a(localazpg.f);
        if (localObject != null)
        {
          localazpg.e = 8;
          ((azpg)localObject).a(localazpg);
        }
      }
    }
    this.jdField_a_of_type_Boolean = false;
    this.g = null;
    this.jdField_a_of_type_Azsf = xap.a(localQQAppInterface, this.b, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.zipFilePath, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.zipBusId, this.jdField_a_of_type_Xaw);
    b(1);
    bamh.b();
  }
  
  protected void g()
  {
    QQAppInterface localQQAppInterface = azsp.a();
    if (localQQAppInterface == null)
    {
      azsr.a("TroopZipInnerFileDownloadWorker", azsr.a, "[" + this.jdField_a_of_type_JavaLangString + "] startDownload app=null");
      this.jdField_a_of_type_Azsd.c = 9;
      this.jdField_a_of_type_Azsd.d = 902;
      a(true, bami.b, bami.w, 1);
      return;
    }
    String str = MD5.toMD5(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
    this.d = (this.jdField_c_of_type_JavaLangString + str);
    if (this.jdField_a_of_type_Aztj != null)
    {
      this.jdField_a_of_type_Aztj.c();
      this.jdField_a_of_type_Aztj = null;
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Azsd.a = apvb.a(this.d);
    long l = azsp.a();
    azsr.c("TroopZipInnerFileDownloadWorker", azsr.a, "[" + this.jdField_a_of_type_JavaLangString + "] startDownload. nSessionId:" + l + " firstIP=" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp + " urlParams:" + this.f + " mTmpFilePath:" + this.d);
    this.jdField_a_of_type_Aztj = azts.a(localQQAppInterface, l, this.d, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal, this.jdField_a_of_type_JavaUtilList, this.f, null, this.jdField_a_of_type_Boolean, this.g);
    if (this.jdField_a_of_type_Aztj == null)
    {
      this.jdField_a_of_type_Azsd.c = 9;
      this.jdField_a_of_type_Azsd.d = 903;
      a(true, bami.b, bami.w, 1);
      return;
    }
    this.jdField_a_of_type_Aztj.a(this);
    this.jdField_a_of_type_Aztj.b();
    b(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aztv
 * JD-Core Version:    0.7.0.1
 */