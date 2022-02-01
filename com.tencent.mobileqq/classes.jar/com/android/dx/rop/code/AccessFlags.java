package com.android.dx.rop.code;

import com.android.dx.util.Hex;

public final class AccessFlags
{
  public static final int ACC_ABSTRACT = 1024;
  public static final int ACC_ANNOTATION = 8192;
  public static final int ACC_BRIDGE = 64;
  public static final int ACC_CONSTRUCTOR = 65536;
  public static final int ACC_DECLARED_SYNCHRONIZED = 131072;
  public static final int ACC_ENUM = 16384;
  public static final int ACC_FINAL = 16;
  public static final int ACC_INTERFACE = 512;
  public static final int ACC_NATIVE = 256;
  public static final int ACC_PRIVATE = 2;
  public static final int ACC_PROTECTED = 4;
  public static final int ACC_PUBLIC = 1;
  public static final int ACC_STATIC = 8;
  public static final int ACC_STRICT = 2048;
  public static final int ACC_SUPER = 32;
  public static final int ACC_SYNCHRONIZED = 32;
  public static final int ACC_SYNTHETIC = 4096;
  public static final int ACC_TRANSIENT = 128;
  public static final int ACC_VARARGS = 128;
  public static final int ACC_VOLATILE = 64;
  public static final int CLASS_FLAGS = 30257;
  private static final int CONV_CLASS = 1;
  private static final int CONV_FIELD = 2;
  private static final int CONV_METHOD = 3;
  public static final int FIELD_FLAGS = 20703;
  public static final int INNER_CLASS_FLAGS = 30239;
  public static final int METHOD_FLAGS = 204287;
  
  public static String classString(int paramInt)
  {
    return humanHelper(paramInt, 30257, 1);
  }
  
  public static String fieldString(int paramInt)
  {
    return humanHelper(paramInt, 20703, 2);
  }
  
  private static String humanHelper(int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuffer localStringBuffer = new StringBuffer(80);
    int i = (paramInt2 ^ 0xFFFFFFFF) & paramInt1;
    paramInt1 &= paramInt2;
    if ((paramInt1 & 0x1) != 0) {
      localStringBuffer.append("|public");
    }
    if ((paramInt1 & 0x2) != 0) {
      localStringBuffer.append("|private");
    }
    if ((paramInt1 & 0x4) != 0) {
      localStringBuffer.append("|protected");
    }
    if ((paramInt1 & 0x8) != 0) {
      localStringBuffer.append("|static");
    }
    if ((paramInt1 & 0x10) != 0) {
      localStringBuffer.append("|final");
    }
    if ((paramInt1 & 0x20) != 0)
    {
      if (paramInt3 == 1) {
        localStringBuffer.append("|super");
      }
    }
    else
    {
      if ((paramInt1 & 0x40) != 0)
      {
        if (paramInt3 != 3) {
          break label344;
        }
        localStringBuffer.append("|bridge");
      }
      label133:
      if ((paramInt1 & 0x80) != 0)
      {
        if (paramInt3 != 3) {
          break label355;
        }
        localStringBuffer.append("|varargs");
      }
    }
    for (;;)
    {
      if ((paramInt1 & 0x100) != 0) {
        localStringBuffer.append("|native");
      }
      if ((paramInt1 & 0x200) != 0) {
        localStringBuffer.append("|interface");
      }
      if ((paramInt1 & 0x400) != 0) {
        localStringBuffer.append("|abstract");
      }
      if ((paramInt1 & 0x800) != 0) {
        localStringBuffer.append("|strictfp");
      }
      if ((paramInt1 & 0x1000) != 0) {
        localStringBuffer.append("|synthetic");
      }
      if ((paramInt1 & 0x2000) != 0) {
        localStringBuffer.append("|annotation");
      }
      if ((paramInt1 & 0x4000) != 0) {
        localStringBuffer.append("|enum");
      }
      if ((0x10000 & paramInt1) != 0) {
        localStringBuffer.append("|constructor");
      }
      if ((paramInt1 & 0x20000) != 0) {
        localStringBuffer.append("|declared_synchronized");
      }
      if ((i != 0) || (localStringBuffer.length() == 0))
      {
        localStringBuffer.append('|');
        localStringBuffer.append(Hex.u2(i));
      }
      return localStringBuffer.substring(1);
      localStringBuffer.append("|synchronized");
      break;
      label344:
      localStringBuffer.append("|volatile");
      break label133;
      label355:
      localStringBuffer.append("|transient");
    }
  }
  
  public static String innerClassString(int paramInt)
  {
    return humanHelper(paramInt, 30239, 1);
  }
  
  public static boolean isAbstract(int paramInt)
  {
    return (paramInt & 0x400) != 0;
  }
  
  public static boolean isAnnotation(int paramInt)
  {
    return (paramInt & 0x2000) != 0;
  }
  
  public static boolean isConstructor(int paramInt)
  {
    return (0x10000 & paramInt) != 0;
  }
  
  public static boolean isDeclaredSynchronized(int paramInt)
  {
    return (0x20000 & paramInt) != 0;
  }
  
  public static boolean isEnum(int paramInt)
  {
    return (paramInt & 0x4000) != 0;
  }
  
  public static boolean isInterface(int paramInt)
  {
    return (paramInt & 0x200) != 0;
  }
  
  public static boolean isNative(int paramInt)
  {
    return (paramInt & 0x100) != 0;
  }
  
  public static boolean isPrivate(int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public static boolean isProtected(int paramInt)
  {
    return (paramInt & 0x4) != 0;
  }
  
  public static boolean isPublic(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static boolean isStatic(int paramInt)
  {
    return (paramInt & 0x8) != 0;
  }
  
  public static boolean isSynchronized(int paramInt)
  {
    return (paramInt & 0x20) != 0;
  }
  
  public static String methodString(int paramInt)
  {
    return humanHelper(paramInt, 204287, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.code.AccessFlags
 * JD-Core Version:    0.7.0.1
 */