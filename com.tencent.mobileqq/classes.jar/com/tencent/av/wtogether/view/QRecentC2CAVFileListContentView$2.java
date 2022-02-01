package com.tencent.av.wtogether.view;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class QRecentC2CAVFileListContentView$2
  extends FileTransferObserver
{
  private int jdField_a_of_type_Int = 0;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = false;
  
  QRecentC2CAVFileListContentView$2(QRecentC2CAVFileListContentView paramQRecentC2CAVFileListContentView) {}
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentAvWtogetherViewQRecentC2CAVFileListContentView.i();
    this.jdField_a_of_type_ComTencentAvWtogetherViewQRecentC2CAVFileListContentView.h();
    c();
  }
  
  private void c()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, List<OfflineFileInfo> paramList)
  {
    if (paramBoolean1) {
      this.jdField_a_of_type_ComTencentAvWtogetherViewQRecentC2CAVFileListContentView.a(paramList);
    }
    if (!paramBoolean2)
    {
      paramList = ((QQAppInterface)this.jdField_a_of_type_ComTencentAvWtogetherViewQRecentC2CAVFileListContentView.a).getFileTransferHandler();
      i = this.jdField_b_of_type_Int + 1;
      this.jdField_b_of_type_Int = i;
      paramList.a(i * 30, 30, QRecentC2CAVFileListContentView.a(this.jdField_a_of_type_ComTencentAvWtogetherViewQRecentC2CAVFileListContentView), 3);
      return;
    }
    paramList = new StringBuilder();
    paramList.append("finish recv querying, use ");
    int i = this.jdField_b_of_type_Int + 1;
    this.jdField_b_of_type_Int = i;
    paramList.append(i);
    paramList.append(" times");
    QLog.d("QRecentC2CAVFileListContentView", 2, paramList.toString());
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2, List<OfflineFileInfo> paramList)
  {
    if (paramBoolean1) {
      this.jdField_a_of_type_ComTencentAvWtogetherViewQRecentC2CAVFileListContentView.a(paramList);
    }
    if (!paramBoolean2)
    {
      paramList = ((QQAppInterface)this.jdField_a_of_type_ComTencentAvWtogetherViewQRecentC2CAVFileListContentView.a).getFileTransferHandler();
      i = this.jdField_a_of_type_Int + 1;
      this.jdField_a_of_type_Int = i;
      paramList.b(i * 30, 30, QRecentC2CAVFileListContentView.a(this.jdField_a_of_type_ComTencentAvWtogetherViewQRecentC2CAVFileListContentView), 3);
      return;
    }
    paramList = new StringBuilder();
    paramList.append("finish send querying, use ");
    int i = this.jdField_a_of_type_Int + 1;
    this.jdField_a_of_type_Int = i;
    paramList.append(i);
    paramList.append(" times");
    QLog.d("QRecentC2CAVFileListContentView", 2, paramList.toString());
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_b_of_type_Boolean) {
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.wtogether.view.QRecentC2CAVFileListContentView.2
 * JD-Core Version:    0.7.0.1
 */