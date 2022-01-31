package com.tencent.map.sdk.a;

final class fc$19
  implements ef
{
  public final <T> ee<T> a(dn paramdn, fd<T> paramfd)
  {
    paramfd = paramfd.a;
    if ((!Enum.class.isAssignableFrom(paramfd)) || (paramfd == Enum.class)) {
      return null;
    }
    paramdn = paramfd;
    if (!paramfd.isEnum()) {
      paramdn = paramfd.getSuperclass();
    }
    return new fc.a(paramdn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.fc.19
 * JD-Core Version:    0.7.0.1
 */