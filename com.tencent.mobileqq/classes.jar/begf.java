import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.MD5;
import java.util.ArrayList;
import java.util.List;

public class begf
  extends befz
{
  protected List<String> a;
  zru a;
  protected boolean a;
  protected String f;
  protected String g;
  
  protected begf(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, begb parambegb)
  {
    super(paramLong, paramItem, paramBundle, parambegb);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Zru = new begg(this);
  }
  
  public static begf a(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, begb parambegb)
  {
    if (paramLong == 0L)
    {
      befc.a("TroopZipInnerFileDownloadWorker", befc.a, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      befc.a("TroopZipInnerFileDownloadWorker", befc.a, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      befc.a("TroopZipInnerFileDownloadWorker", befc.a, "getWoker. item.id=null");
      return null;
    }
    if (TextUtils.isEmpty(paramItem.zipFilePath))
    {
      befc.a("TroopZipInnerFileDownloadWorker", befc.a, "getWoker. zipFilePath=null");
      return null;
    }
    if (TextUtils.isEmpty(paramItem.zipInnerPath))
    {
      befc.a("TroopZipInnerFileDownloadWorker", befc.a, "getWoker. zipInnerPath=null");
      return null;
    }
    return new begf(paramLong, paramItem, paramBundle, parambegb);
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
    beel.a(this.b, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 8);
    QQAppInterface localQQAppInterface = befa.a();
    if (localQQAppInterface == null)
    {
      befc.a("TroopZipInnerFileDownloadWorker", befc.a, "[" + this.jdField_a_of_type_JavaLangString + "] reqDownload app=null");
      this.jdField_a_of_type_Been.c = 9;
      this.jdField_a_of_type_Been.d = 902;
      a(true, bfdy.b, bfdy.w, 1);
      return;
    }
    befc.c("TroopZipInnerFileDownloadWorker", befc.a, "[" + this.jdField_a_of_type_JavaLangString + "] reqDownload");
    Object localObject = befa.a(this.b);
    if (localObject != null)
    {
      bebc localbebc = ((bfbb)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
      if (localbebc != null)
      {
        localObject = ((bfbb)localObject).a(localbebc.f);
        if (localObject != null)
        {
          localbebc.e = 8;
          ((bebc)localObject).a(localbebc);
        }
      }
    }
    this.jdField_a_of_type_Boolean = false;
    this.g = null;
    this.jdField_a_of_type_Beep = zrj.a(localQQAppInterface, this.b, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.zipFilePath, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.zipBusId, this.jdField_a_of_type_Zru);
    b(1);
    bfdx.b();
  }
  
  protected void g()
  {
    QQAppInterface localQQAppInterface = befa.a();
    if (localQQAppInterface == null)
    {
      befc.a("TroopZipInnerFileDownloadWorker", befc.a, "[" + this.jdField_a_of_type_JavaLangString + "] startDownload app=null");
      this.jdField_a_of_type_Been.c = 9;
      this.jdField_a_of_type_Been.d = 902;
      a(true, bfdy.b, bfdy.w, 1);
      return;
    }
    String str = MD5.toMD5(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
    this.d = (this.jdField_c_of_type_JavaLangString + str);
    if (this.jdField_a_of_type_Befu != null)
    {
      this.jdField_a_of_type_Befu.c();
      this.jdField_a_of_type_Befu = null;
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Been.a = FileUtil.getFileSize(this.d);
    long l = befa.a();
    befc.c("TroopZipInnerFileDownloadWorker", befc.a, "[" + this.jdField_a_of_type_JavaLangString + "] startDownload. nSessionId:" + l + " firstIP=" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp + " urlParams:" + this.f + " mTmpFilePath:" + this.d);
    this.jdField_a_of_type_Befu = begc.a(localQQAppInterface, l, this.d, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal, this.jdField_a_of_type_JavaUtilList, this.f, null, this.jdField_a_of_type_Boolean, this.g);
    if (this.jdField_a_of_type_Befu == null)
    {
      this.jdField_a_of_type_Been.c = 9;
      this.jdField_a_of_type_Been.d = 903;
      a(true, bfdy.b, bfdy.w, 1);
      return;
    }
    this.jdField_a_of_type_Befu.a(this);
    this.jdField_a_of_type_Befu.b();
    b(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     begf
 * JD-Core Version:    0.7.0.1
 */