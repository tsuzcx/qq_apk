import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class aooo
  implements Runnable
{
  public aooo(PtvTemplateManager paramPtvTemplateManager, AppInterface paramAppInterface, File paramFile) {}
  
  public void run()
  {
    boolean bool;
    if (QLog.isColorLevel())
    {
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
      {
        bool = true;
        QLog.i("PtvTemplateManager", 2, String.format("initBlessSpecialPendantConfigInfo, app[%s], isUpdateedByServer[%s], cur_runnable[%s]", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager.jdField_e_of_type_Boolean), Integer.valueOf(hashCode()) }));
      }
    }
    else {
      if (!this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager.jdField_e_of_type_Boolean) {
        break label76;
      }
    }
    label76:
    Object localObject1;
    do
    {
      do
      {
        return;
        bool = false;
        break;
        localObject1 = PtvTemplateManager.a(this.jdField_a_of_type_JavaIoFile);
      } while (TextUtils.isEmpty((CharSequence)localObject1));
      localObject1 = PtvTemplateManager.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager, (String)localObject1);
    } while ((localObject1 == null) || (((List)localObject1).isEmpty()));
    ??? = ((List)localObject1).iterator();
    while (((Iterator)???).hasNext())
    {
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)???).next();
      if (localPtvTemplateInfo != null)
      {
        localPtvTemplateInfo.usable = this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager.a(localPtvTemplateInfo);
        localPtvTemplateInfo.businessID = 1;
      }
    }
    synchronized (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager.jdField_e_of_type_JavaUtilArrayList)
    {
      if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager.jdField_e_of_type_Boolean) {
        return;
      }
    }
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager.jdField_e_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager.jdField_e_of_type_JavaUtilArrayList.addAll(localCollection);
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager.f = true;
    PtvTemplateManager.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aooo
 * JD-Core Version:    0.7.0.1
 */