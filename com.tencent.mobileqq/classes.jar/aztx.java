import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.MD5;
import java.util.ArrayList;
import java.util.List;

public class aztx
  extends aztr
{
  protected List<String> a;
  xat a;
  protected boolean a;
  protected String f;
  protected String g;
  
  protected aztx(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, aztt paramaztt)
  {
    super(paramLong, paramItem, paramBundle, paramaztt);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Xat = new azty(this);
  }
  
  public static aztx a(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, aztt paramaztt)
  {
    if (paramLong == 0L)
    {
      azst.a("TroopZipInnerFileDownloadWorker", azst.a, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      azst.a("TroopZipInnerFileDownloadWorker", azst.a, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      azst.a("TroopZipInnerFileDownloadWorker", azst.a, "getWoker. item.id=null");
      return null;
    }
    if (TextUtils.isEmpty(paramItem.zipFilePath))
    {
      azst.a("TroopZipInnerFileDownloadWorker", azst.a, "getWoker. zipFilePath=null");
      return null;
    }
    if (TextUtils.isEmpty(paramItem.zipInnerPath))
    {
      azst.a("TroopZipInnerFileDownloadWorker", azst.a, "getWoker. zipInnerPath=null");
      return null;
    }
    return new aztx(paramLong, paramItem, paramBundle, paramaztt);
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
    azsd.a(this.b, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 8);
    QQAppInterface localQQAppInterface = azsr.a();
    if (localQQAppInterface == null)
    {
      azst.a("TroopZipInnerFileDownloadWorker", azst.a, "[" + this.jdField_a_of_type_JavaLangString + "] reqDownload app=null");
      this.jdField_a_of_type_Azsf.c = 9;
      this.jdField_a_of_type_Azsf.d = 902;
      a(true, bamw.b, bamw.w, 1);
      return;
    }
    azst.c("TroopZipInnerFileDownloadWorker", azst.a, "[" + this.jdField_a_of_type_JavaLangString + "] reqDownload");
    Object localObject = azsr.a(this.b);
    if (localObject != null)
    {
      azpi localazpi = ((bajy)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
      if (localazpi != null)
      {
        localObject = ((bajy)localObject).a(localazpi.f);
        if (localObject != null)
        {
          localazpi.e = 8;
          ((azpi)localObject).a(localazpi);
        }
      }
    }
    this.jdField_a_of_type_Boolean = false;
    this.g = null;
    this.jdField_a_of_type_Azsh = xam.a(localQQAppInterface, this.b, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.zipFilePath, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.zipBusId, this.jdField_a_of_type_Xat);
    b(1);
    bamv.b();
  }
  
  protected void g()
  {
    QQAppInterface localQQAppInterface = azsr.a();
    if (localQQAppInterface == null)
    {
      azst.a("TroopZipInnerFileDownloadWorker", azst.a, "[" + this.jdField_a_of_type_JavaLangString + "] startDownload app=null");
      this.jdField_a_of_type_Azsf.c = 9;
      this.jdField_a_of_type_Azsf.d = 902;
      a(true, bamw.b, bamw.w, 1);
      return;
    }
    String str = MD5.toMD5(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
    this.d = (this.jdField_c_of_type_JavaLangString + str);
    if (this.jdField_a_of_type_Aztl != null)
    {
      this.jdField_a_of_type_Aztl.c();
      this.jdField_a_of_type_Aztl = null;
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Azsf.a = apvd.a(this.d);
    long l = azsr.a();
    azst.c("TroopZipInnerFileDownloadWorker", azst.a, "[" + this.jdField_a_of_type_JavaLangString + "] startDownload. nSessionId:" + l + " firstIP=" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp + " urlParams:" + this.f + " mTmpFilePath:" + this.d);
    this.jdField_a_of_type_Aztl = aztu.a(localQQAppInterface, l, this.d, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal, this.jdField_a_of_type_JavaUtilList, this.f, null, this.jdField_a_of_type_Boolean, this.g);
    if (this.jdField_a_of_type_Aztl == null)
    {
      this.jdField_a_of_type_Azsf.c = 9;
      this.jdField_a_of_type_Azsf.d = 903;
      a(true, bamw.b, bamw.w, 1);
      return;
    }
    this.jdField_a_of_type_Aztl.a(this);
    this.jdField_a_of_type_Aztl.b();
    b(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aztx
 * JD-Core Version:    0.7.0.1
 */