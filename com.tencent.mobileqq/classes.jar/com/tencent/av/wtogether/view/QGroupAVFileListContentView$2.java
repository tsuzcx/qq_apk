package com.tencent.av.wtogether.view;

import com.tencent.av.wtogether.handler.WatchTogetherHandler;
import com.tencent.av.wtogether.observer.WatchTogetherObserver;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchItemData;
import java.util.List;

class QGroupAVFileListContentView$2
  extends WatchTogetherObserver
{
  QGroupAVFileListContentView$2(QGroupAVFileListContentView paramQGroupAVFileListContentView) {}
  
  public void a(int paramInt, String paramString) {}
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, List<TroopFileSearchItemData> paramList)
  {
    this.a.a(paramList);
    if (paramInt1 == 0)
    {
      ((WatchTogetherHandler)this.a.a.getBusinessHandler(BusinessHandlerFactory.QAV_WT_HANDLER)).a(QGroupAVFileListContentView.a(this.a), ByteStringMicro.copyFromUtf8(paramString1));
      return;
    }
    this.a.i();
    this.a.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.wtogether.view.QGroupAVFileListContentView.2
 * JD-Core Version:    0.7.0.1
 */