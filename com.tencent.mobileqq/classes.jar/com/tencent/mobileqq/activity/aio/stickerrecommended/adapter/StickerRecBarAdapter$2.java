package com.tencent.mobileqq.activity.aio.stickerrecommended.adapter;

import com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl;
import java.util.List;

class StickerRecBarAdapter$2
  implements Runnable
{
  StickerRecBarAdapter$2(StickerRecBarAdapter paramStickerRecBarAdapter, List paramList) {}
  
  public void run()
  {
    StickerRecManagerImpl localStickerRecManagerImpl = StickerRecManagerImpl.get(StickerRecBarAdapter.a(this.this$0));
    localStickerRecManagerImpl.updateSort(StickerRecBarAdapter.b(this.this$0));
    localStickerRecManagerImpl.updateStickerLastTime(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.StickerRecBarAdapter.2
 * JD-Core Version:    0.7.0.1
 */