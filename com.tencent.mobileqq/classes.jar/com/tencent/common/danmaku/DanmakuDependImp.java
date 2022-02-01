package com.tencent.common.danmaku;

public class DanmakuDependImp
{
  private IDanmakuDepend a;
  
  public static DanmakuDependImp a()
  {
    return DanmakuDependImp.SingletonPatternHolder.a();
  }
  
  public void a(IDanmakuDepend paramIDanmakuDepend)
  {
    this.a = paramIDanmakuDepend;
  }
  
  public IDanmakuDepend b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.DanmakuDependImp
 * JD-Core Version:    0.7.0.1
 */