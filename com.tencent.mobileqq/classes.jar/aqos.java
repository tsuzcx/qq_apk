import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;

public class aqos
  implements arvg
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public aqos(QfileCloudFileTabView paramQfileCloudFileTabView) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -2147483648;
    this.b = 2147483647;
    WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView.a.getChild(paramInt1, paramInt2);
    if (localWeiYunFileInfo == null) {}
    do
    {
      return;
      if (!arbs.a(localWeiYunFileInfo)) {
        bool = true;
      }
      this.jdField_a_of_type_Boolean = bool;
    } while (!QfileCloudFileTabView.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView, localWeiYunFileInfo, this.jdField_a_of_type_Boolean));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView.o();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 != paramInt3) {
      return;
    }
    paramInt3 = Math.min(paramInt2, paramInt4);
    int i = Math.max(paramInt2, paramInt4);
    if (paramInt4 < paramInt2) {
      this.b = Math.min(paramInt4, this.b);
    }
    for (;;)
    {
      paramInt2 = paramInt3;
      while (paramInt2 <= i)
      {
        QfileCloudFileTabView.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView, (WeiYunFileInfo)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView.a.getChild(paramInt1, paramInt2), this.jdField_a_of_type_Boolean);
        paramInt2 += 1;
      }
      this.jdField_a_of_type_Int = Math.max(paramInt4, this.jdField_a_of_type_Int);
    }
    paramInt2 = this.b;
    QfileCloudFileTabView localQfileCloudFileTabView;
    WeiYunFileInfo localWeiYunFileInfo;
    boolean bool;
    if (paramInt2 < paramInt3)
    {
      localQfileCloudFileTabView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView;
      localWeiYunFileInfo = (WeiYunFileInfo)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView.a.getChild(paramInt1, paramInt2);
      if (!this.jdField_a_of_type_Boolean) {}
      for (bool = true;; bool = false)
      {
        QfileCloudFileTabView.a(localQfileCloudFileTabView, localWeiYunFileInfo, bool);
        paramInt2 += 1;
        break;
      }
    }
    paramInt2 = i + 1;
    if (paramInt2 <= this.jdField_a_of_type_Int)
    {
      localQfileCloudFileTabView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView;
      localWeiYunFileInfo = (WeiYunFileInfo)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView.a.getChild(paramInt1, paramInt2);
      if (!this.jdField_a_of_type_Boolean) {}
      for (bool = true;; bool = false)
      {
        QfileCloudFileTabView.a(localQfileCloudFileTabView, localWeiYunFileInfo, bool);
        paramInt2 += 1;
        break;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView.o();
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqos
 * JD-Core Version:    0.7.0.1
 */