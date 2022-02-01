package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.utils.FileUtils;

final class PlusPanelUtils$5
  implements Runnable
{
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(".nomedia");
    FileUtils.createFileIfNotExits(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils.5
 * JD-Core Version:    0.7.0.1
 */