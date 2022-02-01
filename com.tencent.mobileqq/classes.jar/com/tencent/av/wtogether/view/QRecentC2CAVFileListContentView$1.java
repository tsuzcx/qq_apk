package com.tencent.av.wtogether.view;

import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import java.util.Comparator;

class QRecentC2CAVFileListContentView$1
  implements Comparator<OfflineFileInfo>
{
  QRecentC2CAVFileListContentView$1(QRecentC2CAVFileListContentView paramQRecentC2CAVFileListContentView) {}
  
  public int a(OfflineFileInfo paramOfflineFileInfo1, OfflineFileInfo paramOfflineFileInfo2)
  {
    return Long.valueOf(paramOfflineFileInfo1.h).compareTo(Long.valueOf(paramOfflineFileInfo2.h));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.view.QRecentC2CAVFileListContentView.1
 * JD-Core Version:    0.7.0.1
 */