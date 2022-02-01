package com.tencent.av.business.manager.magicface;

import com.tencent.av.AVLog;

class MagicFaceDataEntity$1$1
  implements Runnable
{
  MagicFaceDataEntity$1$1(MagicFaceDataEntity.1 param1) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reloadDecrateList 3:");
    localStringBuilder.append(this.a.a);
    AVLog.printColorLog("MagicFaceDataEntity", localStringBuilder.toString());
    MagicFaceDataEntity.a(this.a.this$0, this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicFaceDataEntity.1.1
 * JD-Core Version:    0.7.0.1
 */