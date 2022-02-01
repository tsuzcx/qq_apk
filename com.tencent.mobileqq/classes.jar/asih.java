import android.text.TextUtils;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.VipComicFavorEmoStructMsgInfo;
import com.tencent.mobileqq.emosm.favroaming.IPicDownloadListener;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class asih
  extends biht
{
  asih(asig paramasig, File paramFile, CustomEmotionData paramCustomEmotionData, ashc paramashc, List paramList1, IPicDownloadListener paramIPicDownloadListener, List paramList2, EntityManager paramEntityManager, VipComicFavorEmoStructMsgInfo paramVipComicFavorEmoStructMsgInfo, AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2) {}
  
  public void onDone(bihu parambihu)
  {
    super.onDone(parambihu);
    if ((parambihu.a() == 3) && (parambihu.a == 0) && (this.jdField_a_of_type_JavaIoFile.exists()))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.emoPath = this.jdField_a_of_type_JavaIoFile.getAbsolutePath();
      if ("needDownload".equals(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.RomaingType)) {
        this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.RomaingType = "isUpdate";
      }
      if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.emoPath)))
      {
        parambihu = SecUtil.getFileMd5(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.emoPath);
        if (!this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5.equals(parambihu)) {
          QLog.i("VipComicMqqManager", 2, "init = " + this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5 + " , compute = " + parambihu);
        }
      }
      this.jdField_a_of_type_Ashc.b(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
      asig.a(this.jdField_a_of_type_Asig, this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIPicDownloadListener, this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
      if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) && (this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIPicDownloadListener != null)) {
        this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIPicDownloadListener.onDone(this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList);
      }
      return;
      this.jdField_b_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
      this.jdField_a_of_type_Ashc.a(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(this.jdField_a_of_type_ComTencentMobileqqDataVipComicFavorEmoStructMsgInfo);
      asig.a(this.jdField_a_of_type_Asig, this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIPicDownloadListener, this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asih
 * JD-Core Version:    0.7.0.1
 */