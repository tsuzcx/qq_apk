package com.tencent.av.business.manager.magicface;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import lek;

class MagicFaceDataEntity$1
  implements Runnable
{
  MagicFaceDataEntity$1(MagicFaceDataEntity paramMagicFaceDataEntity, String paramString) {}
  
  public void run()
  {
    lek.c("MagicFaceDataEntity", "reloadDecrateList 2:" + this.a);
    MagicFaceDataEntity.1.1 local1 = new MagicFaceDataEntity.1.1(this);
    this.this$0.a.a().post(local1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicFaceDataEntity.1
 * JD-Core Version:    0.7.0.1
 */