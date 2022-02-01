import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.MD5;
import java.util.ArrayList;
import java.util.List;

public class bfni
  extends bfnc
{
  aahg a;
  protected List<String> a;
  protected boolean a;
  protected String f;
  protected String g;
  
  protected bfni(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, bfne parambfne)
  {
    super(paramLong, paramItem, paramBundle, parambfne);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Aahg = new bfnj(this);
  }
  
  public static bfni a(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, bfne parambfne)
  {
    if (paramLong == 0L)
    {
      bfmf.a("TroopZipInnerFileDownloadWorker", bfmf.a, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      bfmf.a("TroopZipInnerFileDownloadWorker", bfmf.a, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      bfmf.a("TroopZipInnerFileDownloadWorker", bfmf.a, "getWoker. item.id=null");
      return null;
    }
    if (TextUtils.isEmpty(paramItem.zipFilePath))
    {
      bfmf.a("TroopZipInnerFileDownloadWorker", bfmf.a, "getWoker. zipFilePath=null");
      return null;
    }
    if (TextUtils.isEmpty(paramItem.zipInnerPath))
    {
      bfmf.a("TroopZipInnerFileDownloadWorker", bfmf.a, "getWoker. zipInnerPath=null");
      return null;
    }
    return new bfni(paramLong, paramItem, paramBundle, parambfne);
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
    bflo.a(this.b, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 8);
    QQAppInterface localQQAppInterface = bfmd.a();
    if (localQQAppInterface == null)
    {
      bfmf.a("TroopZipInnerFileDownloadWorker", bfmf.a, "[" + this.jdField_a_of_type_JavaLangString + "] reqDownload app=null");
      this.jdField_a_of_type_Bflq.c = 9;
      this.jdField_a_of_type_Bflq.d = 902;
      a(true, bgme.b, bgme.w, 1);
      return;
    }
    bfmf.c("TroopZipInnerFileDownloadWorker", bfmf.a, "[" + this.jdField_a_of_type_JavaLangString + "] reqDownload");
    Object localObject = bfmd.a(this.b);
    if (localObject != null)
    {
      bfif localbfif = ((bgjh)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
      if (localbfif != null)
      {
        localObject = ((bgjh)localObject).a(localbfif.g);
        if (localObject != null)
        {
          localbfif.e = 8;
          ((bfif)localObject).a(localbfif);
        }
      }
    }
    this.jdField_a_of_type_Boolean = false;
    this.g = null;
    this.jdField_a_of_type_Bfls = aagu.a(localQQAppInterface, this.b, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.zipFilePath, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.zipBusId, this.jdField_a_of_type_Aahg);
    b(1);
    bgmd.b();
  }
  
  protected void g()
  {
    QQAppInterface localQQAppInterface = bfmd.a();
    if (localQQAppInterface == null)
    {
      bfmf.a("TroopZipInnerFileDownloadWorker", bfmf.a, "[" + this.jdField_a_of_type_JavaLangString + "] startDownload app=null");
      this.jdField_a_of_type_Bflq.c = 9;
      this.jdField_a_of_type_Bflq.d = 902;
      a(true, bgme.b, bgme.w, 1);
      return;
    }
    String str = MD5.toMD5(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
    this.d = (this.jdField_c_of_type_JavaLangString + str);
    if (this.jdField_a_of_type_Bfmx != null)
    {
      this.jdField_a_of_type_Bfmx.c();
      this.jdField_a_of_type_Bfmx = null;
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Bflq.a = FileUtil.getFileSize(this.d);
    long l = bfmd.a();
    bfmf.c("TroopZipInnerFileDownloadWorker", bfmf.a, "[" + this.jdField_a_of_type_JavaLangString + "] startDownload. nSessionId:" + l + " firstIP=" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp + " urlParams:" + this.f + " mTmpFilePath:" + this.d);
    this.jdField_a_of_type_Bfmx = bfnf.a(localQQAppInterface, l, this.d, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal, this.jdField_a_of_type_JavaUtilList, this.f, null, this.jdField_a_of_type_Boolean, this.g);
    if (this.jdField_a_of_type_Bfmx == null)
    {
      this.jdField_a_of_type_Bflq.c = 9;
      this.jdField_a_of_type_Bflq.d = 903;
      a(true, bgme.b, bgme.w, 1);
      return;
    }
    this.jdField_a_of_type_Bfmx.a(this);
    this.jdField_a_of_type_Bfmx.b();
    b(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfni
 * JD-Core Version:    0.7.0.1
 */