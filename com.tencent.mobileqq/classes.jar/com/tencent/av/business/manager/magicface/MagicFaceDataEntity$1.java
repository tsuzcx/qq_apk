package com.tencent.av.business.manager.magicface;

import android.os.Handler;
import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;

class MagicFaceDataEntity$1
  implements Runnable
{
  MagicFaceDataEntity$1(MagicFaceDataEntity paramMagicFaceDataEntity, String paramString) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reloadDecrateList 2:");
    ((StringBuilder)localObject).append(this.a);
    AVLog.printColorLog("MagicFaceDataEntity", ((StringBuilder)localObject).toString());
    localObject = new MagicFaceDataEntity.1.1(this);
    this.this$0.a.a().post((Runnable)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicFaceDataEntity.1
 * JD-Core Version:    0.7.0.1
 */