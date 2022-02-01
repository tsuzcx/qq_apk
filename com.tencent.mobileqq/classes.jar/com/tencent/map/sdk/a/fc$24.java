package com.tencent.map.sdk.a;

final class fc$24
  implements ef
{
  fc$24(Class paramClass1, Class paramClass2, ee paramee) {}
  
  public final <T> ee<T> a(dn paramdn, fd<T> paramfd)
  {
    paramdn = paramfd.a;
    if ((paramdn != this.a) && (paramdn != this.b)) {
      return null;
    }
    return this.c;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Factory[type=");
    localStringBuilder.append(this.a.getName());
    localStringBuilder.append("+");
    localStringBuilder.append(this.b.getName());
    localStringBuilder.append(",adapter=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.fc.24
 * JD-Core Version:    0.7.0.1
 */