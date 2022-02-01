package com.eclipsesource.mmv8;

public class PlatformDetector$OS
{
  public static String getLibFileExtension()
  {
    if (isWindows()) {
      return "dll";
    }
    if (isMac()) {
      return "dylib";
    }
    if ((!isLinux()) && (!isAndroid()) && (!isNativeClient()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unsupported platform library-extension for: ");
      localStringBuilder.append(getName());
      throw new UnsatisfiedLinkError(localStringBuilder.toString());
    }
    return "so";
  }
  
  public static String getName()
  {
    String str1 = System.getProperty("os.name");
    Object localObject = PlatformDetector.access$100(str1);
    String str2 = System.getProperty("java.specification.vendor");
    if (!PlatformDetector.access$200(str2).contains("android"))
    {
      if (((String)localObject).contains("android")) {
        return "android";
      }
      if (!((String)localObject).equals("unknown")) {
        return localObject;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unsupported platform/vendor: ");
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append(" / ");
      ((StringBuilder)localObject).append(str2);
      throw new UnsatisfiedLinkError(((StringBuilder)localObject).toString());
    }
    return "android";
  }
  
  public static boolean isAndroid()
  {
    return getName().equals("android");
  }
  
  public static boolean isLinux()
  {
    return getName().equals("linux");
  }
  
  public static boolean isMac()
  {
    return getName().equals("macosx");
  }
  
  public static boolean isNativeClient()
  {
    return getName().equals("nacl");
  }
  
  public static boolean isWindows()
  {
    return getName().equals("windows");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.mmv8.PlatformDetector.OS
 * JD-Core Version:    0.7.0.1
 */