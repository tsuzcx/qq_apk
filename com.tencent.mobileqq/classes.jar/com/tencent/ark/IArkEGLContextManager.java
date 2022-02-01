package com.tencent.ark;

abstract interface IArkEGLContextManager
{
  public abstract EGLContextHolder createContext(String paramString);
  
  public abstract EGLContextHolder getContext(String paramString);
  
  public abstract boolean releaseContext(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.IArkEGLContextManager
 * JD-Core Version:    0.7.0.1
 */