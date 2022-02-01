package com.eclipsesource.mmv8;

public class PlatformDetector$Arch
{
  public static String getName()
  {
    String str = System.getProperty("os.arch");
    Object localObject = PlatformDetector.access$000(str);
    if (!((String)localObject).equals("unknown")) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unsupported arch: ");
    ((StringBuilder)localObject).append(str);
    throw new UnsatisfiedLinkError(((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.mmv8.PlatformDetector.Arch
 * JD-Core Version:    0.7.0.1
 */