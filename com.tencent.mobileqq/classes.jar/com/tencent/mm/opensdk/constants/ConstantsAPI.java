package com.tencent.mm.opensdk.constants;

public abstract interface ConstantsAPI
{
  public static final String ACTION_HANDLE_APP_REGISTER = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_REGISTER";
  public static final String ACTION_HANDLE_APP_UNREGISTER = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_UNREGISTER";
  public static final String ACTION_REFRESH_WXAPP = "com.tencent.mm.plugin.openapi.Intent.ACTION_REFRESH_WXAPP";
  public static final String APP_PACKAGE = "_mmessage_appPackage";
  public static final String APP_SUPORT_CONTENT_TYPE = "_mmessage_support_content_type";
  public static final String CHECK_SUM = "_mmessage_checksum";
  public static final int COMMAND_ADD_CARD_TO_EX_CARD_PACKAGE = 9;
  public static final int COMMAND_CHOOSE_CARD_FROM_EX_CARD_PACKAGE = 16;
  public static final int COMMAND_CREATE_CHATROOM = 14;
  public static final int COMMAND_GETMESSAGE_FROM_WX = 3;
  public static final int COMMAND_HANDLE_SCAN_RESULT = 17;
  public static final int COMMAND_INVOICE_AUTH_INSERT = 20;
  public static final int COMMAND_JOIN_CHATROOM = 15;
  public static final int COMMAND_JUMP_BIZ_TEMPSESSION = 10;
  public static final int COMMAND_JUMP_BIZ_WEBVIEW = 8;
  public static final int COMMAND_JUMP_TO_BIZ_PROFILE = 7;
  public static final int COMMAND_LAUNCH_BY_WX = 6;
  public static final int COMMAND_LAUNCH_WX_MINIPROGRAM = 19;
  public static final int COMMAND_NON_TAX_PAY = 21;
  public static final int COMMAND_OPEN_BUSI_LUCKY_MONEY = 13;
  public static final int COMMAND_OPEN_RANK_LIST = 11;
  public static final int COMMAND_OPEN_WEBVIEW = 12;
  public static final int COMMAND_PAY_BY_WX = 5;
  public static final int COMMAND_PAY_INSURANCE = 22;
  public static final int COMMAND_SENDAUTH = 1;
  public static final int COMMAND_SENDMESSAGE_TO_WX = 2;
  public static final int COMMAND_SHOWMESSAGE_FROM_WX = 4;
  public static final int COMMAND_SUBSCRIBE_MESSAGE = 18;
  public static final int COMMAND_UNKNOWN = 0;
  public static final String CONTENT = "_mmessage_content";
  public static final String SDK_VERSION = "_mmessage_sdkVersion";
  
  public static final class AppSupportContentFlag
  {
    public static final long MMAPP_SUPPORT_AUDIO = 16L;
    public static final long MMAPP_SUPPORT_DOC = 64L;
    public static final long MMAPP_SUPPORT_DOCX = 128L;
    public static final long MMAPP_SUPPORT_LOCATION = 4L;
    public static final long MMAPP_SUPPORT_PDF = 4096L;
    public static final long MMAPP_SUPPORT_PICTURE = 2L;
    public static final long MMAPP_SUPPORT_PPT = 256L;
    public static final long MMAPP_SUPPORT_PPTX = 512L;
    public static final long MMAPP_SUPPORT_TEXT = 1L;
    public static final long MMAPP_SUPPORT_VIDEO = 8L;
    public static final long MMAPP_SUPPORT_WEBPAGE = 32L;
    public static final long MMAPP_SUPPORT_XLS = 1024L;
    public static final long MMAPP_SUPPORT_XLSX = 2048L;
  }
  
  public static final class OpenWebviewType
  {
    public static final int TYPE_INVOICE_AUTH_INSERT = 2;
    public static final int TYPE_NONTAX_PAY = 3;
    public static final int TYPE_PAYINSURANCE = 4;
    public static final int TYPE_SUBSCRIBE_MESSAGE = 1;
  }
  
  public static final class Token
  {
    public static final String WX_LAUNCH_PARAM_KEY = "launchParam";
    public static final String WX_TOKEN_KEY = "wx_token_key";
    public static final String WX_TOKEN_PLATFORMID_KEY = "platformId";
    public static final String WX_TOKEN_PLATFORMID_VALUE = "wechat";
    public static final String WX_TOKEN_VALUE_MSG = "com.tencent.mm.openapi.token";
  }
  
  public static final class WXApp
  {
    public static final String WXAPP_BROADCAST_PERMISSION = "com.tencent.mm.permission.MM_MESSAGE";
    public static final String WXAPP_MSG_ENTRY_CLASSNAME = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
    public static final String WXAPP_PACKAGE_NAME = "com.tencent.mm";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mm.opensdk.constants.ConstantsAPI
 * JD-Core Version:    0.7.0.1
 */