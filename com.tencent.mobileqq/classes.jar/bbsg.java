import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.MD5;
import java.util.ArrayList;
import java.util.List;

public class bbsg
  extends bbsa
{
  protected List<String> a;
  ypm a;
  protected boolean a;
  protected String f;
  protected String g;
  
  protected bbsg(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, bbsc parambbsc)
  {
    super(paramLong, paramItem, paramBundle, parambbsc);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Ypm = new bbsh(this);
  }
  
  public static bbsg a(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, bbsc parambbsc)
  {
    if (paramLong == 0L)
    {
      bbrc.a("TroopZipInnerFileDownloadWorker", bbrc.a, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      bbrc.a("TroopZipInnerFileDownloadWorker", bbrc.a, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      bbrc.a("TroopZipInnerFileDownloadWorker", bbrc.a, "getWoker. item.id=null");
      return null;
    }
    if (TextUtils.isEmpty(paramItem.zipFilePath))
    {
      bbrc.a("TroopZipInnerFileDownloadWorker", bbrc.a, "getWoker. zipFilePath=null");
      return null;
    }
    if (TextUtils.isEmpty(paramItem.zipInnerPath))
    {
      bbrc.a("TroopZipInnerFileDownloadWorker", bbrc.a, "getWoker. zipInnerPath=null");
      return null;
    }
    return new bbsg(paramLong, paramItem, paramBundle, parambbsc);
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
    bbqm.a(this.b, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 8);
    QQAppInterface localQQAppInterface = bbra.a();
    if (localQQAppInterface == null)
    {
      bbrc.a("TroopZipInnerFileDownloadWorker", bbrc.a, "[" + this.jdField_a_of_type_JavaLangString + "] reqDownload app=null");
      this.jdField_a_of_type_Bbqo.c = 9;
      this.jdField_a_of_type_Bbqo.d = 902;
      a(true, bclj.b, bclj.w, 1);
      return;
    }
    bbrc.c("TroopZipInnerFileDownloadWorker", bbrc.a, "[" + this.jdField_a_of_type_JavaLangString + "] reqDownload");
    Object localObject = bbra.a(this.b);
    if (localObject != null)
    {
      bbnr localbbnr = ((bcil)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
      if (localbbnr != null)
      {
        localObject = ((bcil)localObject).a(localbbnr.f);
        if (localObject != null)
        {
          localbbnr.e = 8;
          ((bbnr)localObject).a(localbbnr);
        }
      }
    }
    this.jdField_a_of_type_Boolean = false;
    this.g = null;
    this.jdField_a_of_type_Bbqq = ypf.a(localQQAppInterface, this.b, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.zipFilePath, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.zipBusId, this.jdField_a_of_type_Ypm);
    b(1);
    bcli.b();
  }
  
  protected void g()
  {
    QQAppInterface localQQAppInterface = bbra.a();
    if (localQQAppInterface == null)
    {
      bbrc.a("TroopZipInnerFileDownloadWorker", bbrc.a, "[" + this.jdField_a_of_type_JavaLangString + "] startDownload app=null");
      this.jdField_a_of_type_Bbqo.c = 9;
      this.jdField_a_of_type_Bbqo.d = 902;
      a(true, bclj.b, bclj.w, 1);
      return;
    }
    String str = MD5.toMD5(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
    this.d = (this.jdField_c_of_type_JavaLangString + str);
    if (this.jdField_a_of_type_Bbru != null)
    {
      this.jdField_a_of_type_Bbru.c();
      this.jdField_a_of_type_Bbru = null;
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Bbqo.a = arof.a(this.d);
    long l = bbra.a();
    bbrc.c("TroopZipInnerFileDownloadWorker", bbrc.a, "[" + this.jdField_a_of_type_JavaLangString + "] startDownload. nSessionId:" + l + " firstIP=" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp + " urlParams:" + this.f + " mTmpFilePath:" + this.d);
    this.jdField_a_of_type_Bbru = bbsd.a(localQQAppInterface, l, this.d, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal, this.jdField_a_of_type_JavaUtilList, this.f, null, this.jdField_a_of_type_Boolean, this.g);
    if (this.jdField_a_of_type_Bbru == null)
    {
      this.jdField_a_of_type_Bbqo.c = 9;
      this.jdField_a_of_type_Bbqo.d = 903;
      a(true, bclj.b, bclj.w, 1);
      return;
    }
    this.jdField_a_of_type_Bbru.a(this);
    this.jdField_a_of_type_Bbru.b();
    b(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbsg
 * JD-Core Version:    0.7.0.1
 */