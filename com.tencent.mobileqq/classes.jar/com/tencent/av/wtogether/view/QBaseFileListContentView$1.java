package com.tencent.av.wtogether.view;

import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Comparator;

class QBaseFileListContentView$1
  implements Comparator<FileManagerEntity>
{
  QBaseFileListContentView$1(QBaseFileListContentView paramQBaseFileListContentView) {}
  
  public int a(FileManagerEntity paramFileManagerEntity1, FileManagerEntity paramFileManagerEntity2)
  {
    if (paramFileManagerEntity2.srvTime > paramFileManagerEntity1.srvTime) {
      return 1;
    }
    if (paramFileManagerEntity2.srvTime < paramFileManagerEntity1.srvTime) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.view.QBaseFileListContentView.1
 * JD-Core Version:    0.7.0.1
 */