package com.tencent.aekit.api.standard;

import com.tencent.ttpic.baseutils.log.LogUtils;

final class GLCapabilities$1
  implements Runnable
{
  GLCapabilities$1(boolean paramBoolean) {}
  
  public void run()
  {
    GLCapabilities.access$000(this.val$enableFramebufferFetch);
    GLCapabilities.access$102(true);
    LogUtils.i("GLCapabilities", "init: async end");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.aekit.api.standard.GLCapabilities.1
 * JD-Core Version:    0.7.0.1
 */