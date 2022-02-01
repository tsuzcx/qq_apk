package com.tencent.ark;

final class ArkEGLContextManager
{
  public static final int ApplicationContext = 2;
  public static final int GlobalContext = 1;
  private static final ArkEGLApplicationContextManager _appMgr = new ArkEGLApplicationContextManager();
  private static final ArkEGLGlobalContextManager _globalMgr = new ArkEGLGlobalContextManager();
  
  public static IArkEGLContextManager getManager(int paramInt)
  {
    if (paramInt == 1) {
      return _globalMgr;
    }
    if (paramInt == 2) {
      return _appMgr;
    }
    throw new IllegalArgumentException("unknown context manager type");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ArkEGLContextManager
 * JD-Core Version:    0.7.0.1
 */