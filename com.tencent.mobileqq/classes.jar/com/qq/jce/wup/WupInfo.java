package com.qq.jce.wup;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Properties;

public class WupInfo
{
  private static String clientBuilt;
  private static String clientInfo;
  private static String clientNumber;
  
  static
  {
    try
    {
      InputStream localInputStream = WupInfo.class.getResourceAsStream("/com/qq/jce/wup/wup.properties");
      Properties localProperties = new Properties();
      localProperties.load(localInputStream);
      localInputStream.close();
      clientInfo = localProperties.getProperty("client.info");
      clientBuilt = localProperties.getProperty("client.built");
      clientNumber = localProperties.getProperty("client.number");
      label52:
      if (clientInfo == null) {
        clientInfo = "Tencent Taf";
      }
      if (clientBuilt == null) {
        clientBuilt = "unknown";
      }
      if (clientNumber == null) {
        clientNumber = "unknown";
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      break label52;
    }
  }
  
  public static String getClientBuilt()
  {
    return clientBuilt;
  }
  
  public static String getClientInfo()
  {
    return clientInfo;
  }
  
  public static String getClientNumber()
  {
    return clientNumber;
  }
  
  public static void main(String[] paramArrayOfString)
  {
    System.out.println(showString());
    paramArrayOfString = System.out;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Client version: ");
    localStringBuilder.append(getClientInfo());
    paramArrayOfString.println(localStringBuilder.toString());
    paramArrayOfString = System.out;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Client built:   ");
    localStringBuilder.append(getClientBuilt());
    paramArrayOfString.println(localStringBuilder.toString());
    paramArrayOfString = System.out;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Client number:  ");
    localStringBuilder.append(getClientNumber());
    paramArrayOfString.println(localStringBuilder.toString());
    paramArrayOfString = System.out;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("OS Name:        ");
    localStringBuilder.append(System.getProperty("os.name"));
    paramArrayOfString.println(localStringBuilder.toString());
    paramArrayOfString = System.out;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("OS Version:     ");
    localStringBuilder.append(System.getProperty("os.version"));
    paramArrayOfString.println(localStringBuilder.toString());
    paramArrayOfString = System.out;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Architecture:   ");
    localStringBuilder.append(System.getProperty("os.arch"));
    paramArrayOfString.println(localStringBuilder.toString());
    paramArrayOfString = System.out;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("JVM Version:    ");
    localStringBuilder.append(System.getProperty("java.runtime.version"));
    paramArrayOfString.println(localStringBuilder.toString());
    paramArrayOfString = System.out;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("JVM Vendor:     ");
    localStringBuilder.append(System.getProperty("java.vm.vendor"));
    paramArrayOfString.println(localStringBuilder.toString());
  }
  
  public static String showString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Client version: ");
    localStringBuilder.append(getClientInfo());
    localStringBuilder.append("\n");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Client built:   ");
    localStringBuilder.append(getClientBuilt());
    localStringBuilder.append("\n");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Client number:  ");
    localStringBuilder.append(getClientNumber());
    localStringBuilder.append("\n");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("OS Name:        ");
    localStringBuilder.append(System.getProperty("os.name"));
    localStringBuilder.append("\n");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("OS Version:     ");
    localStringBuilder.append(System.getProperty("os.version"));
    localStringBuilder.append("\n");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Architecture:   ");
    localStringBuilder.append(System.getProperty("os.arch"));
    localStringBuilder.append("\n");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("JVM Version:    ");
    localStringBuilder.append(System.getProperty("java.runtime.version"));
    localStringBuilder.append("\n");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("JVM Vendor:     ");
    localStringBuilder.append(System.getProperty("java.vm.vendor"));
    localStringBuilder.append("\n");
    localStringBuffer.append(localStringBuilder.toString());
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.jce.wup.WupInfo
 * JD-Core Version:    0.7.0.1
 */