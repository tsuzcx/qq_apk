package com.bumptech.glide.load.engine.bitmap_recycle;

final class LruArrayPool$Key
  implements Poolable
{
  int a;
  private final LruArrayPool.KeyPool b;
  private Class<?> c;
  
  LruArrayPool$Key(LruArrayPool.KeyPool paramKeyPool)
  {
    this.b = paramKeyPool;
  }
  
  public void a()
  {
    this.b.a(this);
  }
  
  void a(int paramInt, Class<?> paramClass)
  {
    this.a = paramInt;
    this.c = paramClass;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof Key;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (Key)paramObject;
      bool1 = bool2;
      if (this.a == paramObject.a)
      {
        bool1 = bool2;
        if (this.c == paramObject.c) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    int j = this.a;
    Class localClass = this.c;
    int i;
    if (localClass != null) {
      i = localClass.hashCode();
    } else {
      i = 0;
    }
    return j * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Key{size=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("array=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool.Key
 * JD-Core Version:    0.7.0.1
 */