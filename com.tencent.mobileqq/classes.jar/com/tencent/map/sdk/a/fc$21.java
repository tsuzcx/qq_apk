package com.tencent.map.sdk.a;

final class fc$21
  implements ef
{
  fc$21(Class paramClass, ee paramee) {}
  
  public final <T> ee<T> a(dn paramdn, fd<T> paramfd)
  {
    if (paramfd.a == this.a) {
      return this.b;
    }
    return null;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Factory[type=");
    localStringBuilder.append(this.a.getName());
    localStringBuilder.append(",adapter=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.fc.21
 * JD-Core Version:    0.7.0.1
 */