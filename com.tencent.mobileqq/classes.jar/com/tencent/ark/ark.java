package com.tencent.ark;

public class ark
{
  public static final int APP_APPLICATION_NULL = 0;
  public static final int APP_INPUTMENU_COPYPASTE = 2;
  public static final int APP_INPUTMENU_PASTEONLY = 0;
  public static final int APP_INPUTMENU_SELECTPASTE = 1;
  public static final int APP_INPUTTYPE_DECIMAL = 4;
  public static final int APP_INPUTTYPE_EMAIL = 3;
  public static final int APP_INPUTTYPE_NUMBER = 2;
  public static final int APP_INPUTTYPE_PASSWORD = 1;
  public static final int APP_INPUTTYPE_TELEPHONE = 5;
  public static final int APP_INPUTTYPE_TEXT = 0;
  public static final int APP_MINVER_HIGHER = 3;
  public static final int APP_SCRIPT_TYPE_JAVASCRIPT = 2;
  public static final int APP_SCRIPT_TYPE_LUA = 1;
  public static final int APP_SCRIPT_TYPE_NULL = 0;
  public static final String APP_SPECIFIC_APPNAME = "appName";
  public static final String APP_SPECIFIC_APPPATH = "appPath";
  public static final int APP_TARGETVER_LOWER = 2;
  public static final int APP_URLCHECKING_LIST_TYPE_BLACK = 1;
  public static final int APP_URLCHECKING_LIST_TYPE_WHITE = 0;
  public static final int APP_VER_ERROR = 0;
  public static final int APP_VER_MATCH = 1;
  public static final String ARKMETADATA_JSON = "json";
  public static final String ARKMETADATA_XML = "xml";
  public static final int BORDER_RECTANGLE = 0;
  public static final int BORDER_ROUND_CORNER = 1;
  public static final int BORDER_ROUND_CORNER_WITH_HORN = 2;
  public static final int BORDER_ROUND_CORNER_WITH_MULTI_RADIUS = 3;
  public static final int VariantType_Bool = 2;
  public static final int VariantType_Double = 4;
  public static final int VariantType_Int32 = 3;
  public static final int VariantType_None = 0;
  public static final int VariantType_Null = 1;
  public static final int VariantType_Object = 6;
  public static final int VariantType_String = 5;
  
  public static final native void MediaSetStub(ark.PlayerStubFactory paramPlayerStubFactory);
  
  public static final native void PlayerBufferingChange(long paramLong1, long paramLong2, boolean paramBoolean);
  
  public static final native void PlayerStateChange(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  public static final native void PlayerUpdateFrame(long paramLong1, long paramLong2, ark.PlayerStub.FrameInfo paramFrameInfo);
  
  public static final native void SetEnvironmentManager(ArkEnvironmentManager paramArkEnvironmentManager);
  
  public static final native void SetUseAndroidHTTP(boolean paramBoolean);
  
  public static final native void arkApplicationSetConfig(ark.Application paramApplication, String paramString);
  
  public static final long arkGetARMv7LibCRC32()
  {
    return 674159483L;
  }
  
  public static final int arkGetARMv7LibSize()
  {
    return 3498536;
  }
  
  public static final native ark.Container arkGetContainer(long paramLong);
  
  public static final int arkGetMaxTouchPoints()
  {
    return 8;
  }
  
  public static final int arkGetMinPlatformVersion()
  {
    return 2;
  }
  
  public static final native float arkGetPixelScale();
  
  public static final int arkGetPlatformBuildNumber()
  {
    return 145405536;
  }
  
  public static final int arkGetPlatformVersion()
  {
    return 32;
  }
  
  public static final long arkGetPngARMv7LibCRC32()
  {
    return 199180749L;
  }
  
  public static final int arkGetPngARMv7LibSize()
  {
    return 79992;
  }
  
  public static final native void arkHTTPSetDefaultHttpProxy(String paramString, int paramInt);
  
  public static final native int arkHTTPSetDownloadDirectory(String paramString);
  
  public static final native int arkHTTPShutdown();
  
  public static final native int arkHTTPStartup();
  
  public static final native boolean arkNotify(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public static final native void arkSetAndroid9EmojiFeatureSupport(boolean paramBoolean);
  
  public static final native void arkSetLibraryPath(String paramString1, String paramString2);
  
  public static final native void arkSetPixelScale(float paramFloat);
  
  public static final native void arkSetScreenSize(float paramFloat1, float paramFloat2);
  
  public static final native void arkSetStoragePath(String paramString1, String paramString2);
  
  public static final long getArkSOArm64CRC()
  {
    return 2576444729L;
  }
  
  public static final int getArkSOArm64Size()
  {
    return 5391296;
  }
  
  public static final long getPngArm64CRC()
  {
    return 273271347L;
  }
  
  public static final int getPngArm64Size()
  {
    return 110184;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.ark
 * JD-Core Version:    0.7.0.1
 */