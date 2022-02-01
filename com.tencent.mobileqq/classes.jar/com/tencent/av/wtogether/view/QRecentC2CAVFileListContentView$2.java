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
  private int b = 0;
  private int c = 0;
  private boolean d = false;
  private boolean e = false;
  
  QRecentC2CAVFileListContentView$2(QRecentC2CAVFileListContentView paramQRecentC2CAVFileListContentView) {}
  
  private void b()
  {
    this.a.getRecentFileRecords();
    this.a.h();
    c();
  }
  
  private void c()
  {
    this.b = 1;
    this.c = 1;
    this.d = false;
    this.e = false;
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, List<OfflineFileInfo> paramList)
  {
    if (paramBoolean1) {
      this.a.a(paramList);
    }
    if (!paramBoolean2)
    {
      paramList = ((QQAppInterface)this.a.b).getFileTransferHandler();
      i = this.c + 1;
      this.c = i;
      paramList.a(i * 30, 30, QRecentC2CAVFileListContentView.a(this.a), 3);
      return;
    }
    paramList = new StringBuilder();
    paramList.append("finish recv querying, use ");
    int i = this.c + 1;
    this.c = i;
    paramList.append(i);
    paramList.append(" times");
    QLog.d("QRecentC2CAVFileListContentView", 2, paramList.toString());
    this.e = true;
    if (this.d) {
      b();
    }
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2, List<OfflineFileInfo> paramList)
  {
    if (paramBoolean1) {
      this.a.a(paramList);
    }
    if (!paramBoolean2)
    {
      paramList = ((QQAppInterface)this.a.b).getFileTransferHandler();
      i = this.b + 1;
      this.b = i;
      paramList.b(i * 30, 30, QRecentC2CAVFileListContentView.a(this.a), 3);
      return;
    }
    paramList = new StringBuilder();
    paramList.append("finish send querying, use ");
    int i = this.b + 1;
    this.b = i;
    paramList.append(i);
    paramList.append(" times");
    QLog.d("QRecentC2CAVFileListContentView", 2, paramList.toString());
    this.d = true;
    if (this.e) {
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.view.QRecentC2CAVFileListContentView.2
 * JD-Core Version:    0.7.0.1
 */