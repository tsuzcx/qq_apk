package com.tencent.TMG.sdk;

public class AVEndpoint$Info
{
  public static final int AVTerminal_Android = 4;
  public static final int AVTerminal_AndroidPad = 8;
  public static final int AVTerminal_Mobile = 1;
  public static final int AVTerminal_PC = 5;
  public static final int AVTerminal_Unknown = 0;
  public static final int AVTerminal_WINRTPAD = 6;
  public static final int AVTerminal_WINRTPHONE = 7;
  public static final int AVTerminal_iPad = 3;
  public static final int AVTerminal_iPhone = 2;
  static final String TAG = "SdkJni";
  public String openId;
  public int sdkVersion;
  public int state;
  public int terminalType;
  
  public AVEndpoint$Info()
  {
    this.openId = "";
    this.sdkVersion = 0;
    this.terminalType = 0;
    this.state = 0;
  }
  
  public AVEndpoint$Info(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.openId = paramString;
    this.sdkVersion = paramInt1;
    this.terminalType = paramInt2;
    this.state = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVEndpoint.Info
 * JD-Core Version:    0.7.0.1
 */