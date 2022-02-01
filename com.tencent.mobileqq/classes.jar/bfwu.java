import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.MD5;
import java.util.ArrayList;
import java.util.List;

public class bfwu
  extends bfwo
{
  aavh a;
  protected List<String> a;
  protected boolean a;
  protected String f;
  protected String g;
  
  protected bfwu(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, bfwq parambfwq)
  {
    super(paramLong, paramItem, paramBundle, parambfwq);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Aavh = new bfwv(this);
  }
  
  public static bfwu a(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, bfwq parambfwq)
  {
    if (paramLong == 0L)
    {
      bfvr.a("TroopZipInnerFileDownloadWorker", bfvr.a, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      bfvr.a("TroopZipInnerFileDownloadWorker", bfvr.a, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      bfvr.a("TroopZipInnerFileDownloadWorker", bfvr.a, "getWoker. item.id=null");
      return null;
    }
    if (TextUtils.isEmpty(paramItem.zipFilePath))
    {
      bfvr.a("TroopZipInnerFileDownloadWorker", bfvr.a, "getWoker. zipFilePath=null");
      return null;
    }
    if (TextUtils.isEmpty(paramItem.zipInnerPath))
    {
      bfvr.a("TroopZipInnerFileDownloadWorker", bfvr.a, "getWoker. zipInnerPath=null");
      return null;
    }
    return new bfwu(paramLong, paramItem, paramBundle, parambfwq);
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
    bfva.a(this.b, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 8);
    QQAppInterface localQQAppInterface = bfvp.a();
    if (localQQAppInterface == null)
    {
      bfvr.a("TroopZipInnerFileDownloadWorker", bfvr.a, "[" + this.jdField_a_of_type_JavaLangString + "] reqDownload app=null");
      this.jdField_a_of_type_Bfvc.c = 9;
      this.jdField_a_of_type_Bfvc.d = 902;
      a(true, bguk.b, bguk.w, 1);
      return;
    }
    bfvr.c("TroopZipInnerFileDownloadWorker", bfvr.a, "[" + this.jdField_a_of_type_JavaLangString + "] reqDownload");
    Object localObject = bfvp.a(this.b);
    if (localObject != null)
    {
      bfrs localbfrs = ((bgrn)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
      if (localbfrs != null)
      {
        localObject = ((bgrn)localObject).a(localbfrs.f);
        if (localObject != null)
        {
          localbfrs.e = 8;
          ((bfrs)localObject).a(localbfrs);
        }
      }
    }
    this.jdField_a_of_type_Boolean = false;
    this.g = null;
    this.jdField_a_of_type_Bfve = aauw.a(localQQAppInterface, this.b, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.zipFilePath, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.zipBusId, this.jdField_a_of_type_Aavh);
    b(1);
    bguj.b();
  }
  
  protected void g()
  {
    QQAppInterface localQQAppInterface = bfvp.a();
    if (localQQAppInterface == null)
    {
      bfvr.a("TroopZipInnerFileDownloadWorker", bfvr.a, "[" + this.jdField_a_of_type_JavaLangString + "] startDownload app=null");
      this.jdField_a_of_type_Bfvc.c = 9;
      this.jdField_a_of_type_Bfvc.d = 902;
      a(true, bguk.b, bguk.w, 1);
      return;
    }
    String str = MD5.toMD5(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
    this.d = (this.jdField_c_of_type_JavaLangString + str);
    if (this.jdField_a_of_type_Bfwj != null)
    {
      this.jdField_a_of_type_Bfwj.c();
      this.jdField_a_of_type_Bfwj = null;
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Bfvc.a = auog.a(this.d);
    long l = bfvp.a();
    bfvr.c("TroopZipInnerFileDownloadWorker", bfvr.a, "[" + this.jdField_a_of_type_JavaLangString + "] startDownload. nSessionId:" + l + " firstIP=" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp + " urlParams:" + this.f + " mTmpFilePath:" + this.d);
    this.jdField_a_of_type_Bfwj = bfwr.a(localQQAppInterface, l, this.d, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal, this.jdField_a_of_type_JavaUtilList, this.f, null, this.jdField_a_of_type_Boolean, this.g);
    if (this.jdField_a_of_type_Bfwj == null)
    {
      this.jdField_a_of_type_Bfvc.c = 9;
      this.jdField_a_of_type_Bfvc.d = 903;
      a(true, bguk.b, bguk.w, 1);
      return;
    }
    this.jdField_a_of_type_Bfwj.a(this);
    this.jdField_a_of_type_Bfwj.b();
    b(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfwu
 * JD-Core Version:    0.7.0.1
 */