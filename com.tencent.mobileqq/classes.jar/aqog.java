import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView.13.1;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView.13.2;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView.13.3;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import java.util.ArrayList;
import java.util.Iterator;

public class aqog
  extends aqru
{
  public aqog(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  protected void a(arcg paramarcg)
  {
    if (paramarcg == null) {}
    do
    {
      FileManagerEntity localFileManagerEntity;
      do
      {
        return;
        if (!(paramarcg.a instanceof FileManagerEntity)) {
          break;
        }
        localFileManagerEntity = (FileManagerEntity)paramarcg.a;
      } while ((paramarcg.b == null) || (paramarcg.b.length() <= 0));
      localFileManagerEntity.strThumbPath = paramarcg.b;
      QfileBaseCloudFileTabView.k(this.a).a().c(localFileManagerEntity);
      this.a.i();
      return;
    } while (!(paramarcg.a instanceof WeiYunFileInfo));
    this.a.i();
  }
  
  protected void a(String paramString1, String paramString2, Integer paramInteger, String paramString3, boolean paramBoolean)
  {
    arbs.a(paramString1);
    arrr.a(paramInteger.intValue(), paramString2);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(false);
  }
  
  protected void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString2 = arbs.a(paramString1);
    if ((!this.a.b(paramString2)) && (this.a.jdField_a_of_type_JavaUtilArrayList != null) && (this.a.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      paramString2 = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramString2.hasNext())
      {
        WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)paramString2.next();
        if (localWeiYunFileInfo.a.equalsIgnoreCase(paramString1) == true) {
          this.a.b(localWeiYunFileInfo);
        }
      }
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(false);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    QfileBaseCloudFileTabView.a(this.a, new QfileBaseCloudFileTabView.13.1(this));
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    QfileBaseCloudFileTabView.b(this.a, new QfileBaseCloudFileTabView.13.2(this, paramLong2));
  }
  
  protected void b()
  {
    super.b();
    QfileBaseCloudFileTabView.c(this.a, new QfileBaseCloudFileTabView.13.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqog
 * JD-Core Version:    0.7.0.1
 */