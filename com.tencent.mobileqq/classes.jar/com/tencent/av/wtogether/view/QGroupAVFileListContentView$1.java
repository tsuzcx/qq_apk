package com.tencent.av.wtogether.view;

import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchItemData;
import java.util.Comparator;

class QGroupAVFileListContentView$1
  implements Comparator<TroopFileSearchItemData>
{
  QGroupAVFileListContentView$1(QGroupAVFileListContentView paramQGroupAVFileListContentView) {}
  
  public int a(TroopFileSearchItemData paramTroopFileSearchItemData1, TroopFileSearchItemData paramTroopFileSearchItemData2)
  {
    return Integer.valueOf(paramTroopFileSearchItemData1.a.b).compareTo(Integer.valueOf(paramTroopFileSearchItemData2.a.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.view.QGroupAVFileListContentView.1
 * JD-Core Version:    0.7.0.1
 */