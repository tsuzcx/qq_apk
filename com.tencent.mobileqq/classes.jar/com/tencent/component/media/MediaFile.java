package com.tencent.component.media;

import java.util.HashMap;

public class MediaFile
{
  public static final int FILE_TYPE_3GPP = 23;
  public static final int FILE_TYPE_3GPP2 = 24;
  public static final int FILE_TYPE_AAC = 8;
  public static final int FILE_TYPE_AMR = 4;
  public static final int FILE_TYPE_ASF = 26;
  public static final int FILE_TYPE_AVI = 29;
  public static final int FILE_TYPE_AWB = 5;
  public static final int FILE_TYPE_BMP = 34;
  public static final int FILE_TYPE_FL = 51;
  public static final int FILE_TYPE_FLAC = 10;
  public static final int FILE_TYPE_FLV = 201;
  public static final int FILE_TYPE_GIF = 32;
  public static final int FILE_TYPE_HTML = 101;
  public static final int FILE_TYPE_HTTPLIVE = 44;
  public static final int FILE_TYPE_IMY = 13;
  public static final int FILE_TYPE_JPEG = 31;
  public static final int FILE_TYPE_M3U = 41;
  public static final int FILE_TYPE_M4A = 2;
  public static final int FILE_TYPE_M4V = 22;
  public static final int FILE_TYPE_MID = 11;
  public static final int FILE_TYPE_MKA = 9;
  public static final int FILE_TYPE_MKV = 27;
  public static final int FILE_TYPE_MP2PS = 200;
  public static final int FILE_TYPE_MP2TS = 28;
  public static final int FILE_TYPE_MP3 = 1;
  public static final int FILE_TYPE_MP4 = 21;
  public static final int FILE_TYPE_MS_EXCEL = 105;
  public static final int FILE_TYPE_MS_POWERPOINT = 106;
  public static final int FILE_TYPE_MS_WORD = 104;
  public static final int FILE_TYPE_OGG = 7;
  public static final int FILE_TYPE_PDF = 102;
  public static final int FILE_TYPE_PLS = 42;
  public static final int FILE_TYPE_PNG = 33;
  public static final int FILE_TYPE_QUICKTIME = 202;
  public static final int FILE_TYPE_RMVB = 203;
  public static final int FILE_TYPE_SMF = 12;
  public static final int FILE_TYPE_TEXT = 100;
  public static final int FILE_TYPE_WAV = 3;
  public static final int FILE_TYPE_WBMP = 35;
  public static final int FILE_TYPE_WEBM = 30;
  public static final int FILE_TYPE_WEBP = 36;
  public static final int FILE_TYPE_WMA = 6;
  public static final int FILE_TYPE_WMV = 25;
  public static final int FILE_TYPE_WPL = 43;
  public static final int FILE_TYPE_XML = 103;
  public static final int FILE_TYPE_ZIP = 107;
  private static final int FIRST_AUDIO_FILE_TYPE = 1;
  private static final int FIRST_DRM_FILE_TYPE = 51;
  private static final int FIRST_IMAGE_FILE_TYPE = 31;
  private static final int FIRST_MIDI_FILE_TYPE = 11;
  private static final int FIRST_PLAYLIST_FILE_TYPE = 41;
  private static final int FIRST_VIDEO_FILE_TYPE = 21;
  private static final int FIRST_VIDEO_FILE_TYPE2 = 200;
  private static final int LAST_AUDIO_FILE_TYPE = 10;
  private static final int LAST_DRM_FILE_TYPE = 51;
  private static final int LAST_IMAGE_FILE_TYPE = 36;
  private static final int LAST_MIDI_FILE_TYPE = 13;
  private static final int LAST_PLAYLIST_FILE_TYPE = 44;
  private static final int LAST_VIDEO_FILE_TYPE = 30;
  private static final int LAST_VIDEO_FILE_TYPE2 = 203;
  private static final HashMap<String, MediaFile.MediaFileType> sFileTypeMap = new HashMap();
  private static final HashMap<String, Integer> sFileTypeToFormatMap;
  private static final HashMap<Integer, String> sFormatToMimeTypeMap;
  private static final HashMap<String, Integer> sMimeTypeMap = new HashMap();
  private static final HashMap<String, Integer> sMimeTypeToFormatMap;
  
  static
  {
    sFileTypeToFormatMap = new HashMap();
    sMimeTypeToFormatMap = new HashMap();
    sFormatToMimeTypeMap = new HashMap();
    addFileType("MP3", 1, "audio/mpeg", 12297);
    addFileType("MPGA", 1, "audio/mpeg", 12297);
    addFileType("M4A", 2, "audio/mp4", 12299);
    addFileType("WAV", 3, "audio/x-wav", 12296);
    addFileType("AMR", 4, "audio/amr");
    addFileType("AWB", 5, "audio/amr-wb");
    if (isWMAEnabled()) {
      addFileType("WMA", 6, "audio/x-ms-wma", 47361);
    }
    addFileType("OGG", 7, "audio/ogg", 47362);
    addFileType("OGG", 7, "application/ogg", 47362);
    addFileType("OGA", 7, "application/ogg", 47362);
    addFileType("AAC", 8, "audio/aac", 47363);
    addFileType("AAC", 8, "audio/aac-adts", 47363);
    addFileType("MKA", 9, "audio/x-matroska");
    addFileType("MID", 11, "audio/midi");
    addFileType("MIDI", 11, "audio/midi");
    addFileType("XMF", 11, "audio/midi");
    addFileType("RTTTL", 11, "audio/midi");
    addFileType("SMF", 12, "audio/sp-midi");
    addFileType("IMY", 13, "audio/imelody");
    addFileType("RTX", 11, "audio/midi");
    addFileType("OTA", 11, "audio/midi");
    addFileType("MXMF", 11, "audio/midi");
    addFileType("MPEG", 21, "video/mpeg", 12299);
    addFileType("MPG", 21, "video/mpeg", 12299);
    addFileType("MP4", 21, "video/mp4", 12299);
    addFileType("M4V", 22, "video/mp4", 12299);
    addFileType("3GP", 23, "video/3gpp", 47492);
    addFileType("3GPP", 23, "video/3gpp", 47492);
    addFileType("3G2", 24, "video/3gpp2", 47492);
    addFileType("3GPP2", 24, "video/3gpp2", 47492);
    addFileType("MKV", 27, "video/x-matroska");
    addFileType("WEBM", 30, "video/webm");
    addFileType("TS", 28, "video/mp2ts");
    addFileType("AVI", 29, "video/avi");
    if (isWMVEnabled())
    {
      addFileType("WMV", 25, "video/x-ms-wmv", 47489);
      addFileType("ASF", 26, "video/x-ms-asf");
    }
    addFileType("JPG", 31, "image/jpeg", 14337);
    addFileType("JPEG", 31, "image/jpeg", 14337);
    addFileType("GIF", 32, "image/gif", 14343);
    addFileType("PNG", 33, "image/png", 14347);
    addFileType("BMP", 34, "image/x-ms-bmp", 14340);
    addFileType("WBMP", 35, "image/vnd.wap.wbmp");
    addFileType("WEBP", 36, "image/webp");
    addFileType("M3U", 41, "audio/x-mpegurl", 47633);
    addFileType("M3U", 41, "application/x-mpegurl", 47633);
    addFileType("PLS", 42, "audio/x-scpls", 47636);
    addFileType("WPL", 43, "application/vnd.ms-wpl", 47632);
    addFileType("M3U8", 44, "application/vnd.apple.mpegurl");
    addFileType("M3U8", 44, "audio/mpegurl");
    addFileType("M3U8", 44, "audio/x-mpegurl");
    addFileType("FL", 51, "application/x-android-drm-fl");
    addFileType("TXT", 100, "text/plain", 12292);
    addFileType("HTM", 101, "text/html", 12293);
    addFileType("HTML", 101, "text/html", 12293);
    addFileType("PDF", 102, "application/pdf");
    addFileType("DOC", 104, "application/msword", 47747);
    addFileType("XLS", 105, "application/vnd.ms-excel", 47749);
    addFileType("PPT", 106, "application/mspowerpoint", 47750);
    addFileType("FLAC", 10, "audio/flac", 47366);
    addFileType("ZIP", 107, "application/zip");
    addFileType("MPG", 200, "video/mp2p");
    addFileType("MPEG", 200, "video/mp2p");
    addFileType("FLV", 201, "video/x-flv");
    addFileType("MOV", 202, "video/quicktime");
    addFileType("QT", 202, "video/quicktime");
    addFileType("RMVB", 203, "video/vnd.rn-realvideo");
  }
  
  static void addFileType(String paramString1, int paramInt, String paramString2)
  {
    sFileTypeMap.put(paramString1, new MediaFile.MediaFileType(paramInt, paramString2));
    sMimeTypeMap.put(paramString2, Integer.valueOf(paramInt));
  }
  
  static void addFileType(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    addFileType(paramString1, paramInt1, paramString2);
    sFileTypeToFormatMap.put(paramString1, Integer.valueOf(paramInt2));
    sMimeTypeToFormatMap.put(paramString2, Integer.valueOf(paramInt2));
    sFormatToMimeTypeMap.put(Integer.valueOf(paramInt2), paramString2);
  }
  
  public static String getFileTitle(String paramString)
  {
    int i = paramString.lastIndexOf('/');
    String str = paramString;
    if (i >= 0)
    {
      i += 1;
      str = paramString;
      if (i < paramString.length()) {
        str = paramString.substring(i);
      }
    }
    i = str.lastIndexOf('.');
    paramString = str;
    if (i > 0) {
      paramString = str.substring(0, i);
    }
    return paramString;
  }
  
  public static MediaFile.MediaFileType getFileType(String paramString)
  {
    int i = paramString.lastIndexOf(".");
    if (i < 0) {
      return null;
    }
    return (MediaFile.MediaFileType)sFileTypeMap.get(paramString.substring(i + 1).toUpperCase());
  }
  
  public static int getFileTypeForMimeType(String paramString)
  {
    paramString = (Integer)sMimeTypeMap.get(paramString);
    if (paramString == null) {
      return 0;
    }
    return paramString.intValue();
  }
  
  public static int getFormatCode(String paramString1, String paramString2)
  {
    if (paramString2 != null)
    {
      paramString2 = (Integer)sMimeTypeToFormatMap.get(paramString2);
      if (paramString2 != null) {
        return paramString2.intValue();
      }
    }
    int i = paramString1.lastIndexOf('.');
    if (i > 0)
    {
      paramString1 = paramString1.substring(i + 1).toUpperCase();
      paramString1 = (Integer)sFileTypeToFormatMap.get(paramString1);
      if (paramString1 != null) {
        return paramString1.intValue();
      }
    }
    return 12288;
  }
  
  public static String getMimeTypeForFile(String paramString)
  {
    paramString = getFileType(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.mimeType;
  }
  
  public static String getMimeTypeForFormatCode(int paramInt)
  {
    return (String)sFormatToMimeTypeMap.get(Integer.valueOf(paramInt));
  }
  
  public static boolean isAudioFileType(int paramInt)
  {
    boolean bool = true;
    if ((paramInt < 1) || (paramInt > 10))
    {
      if ((paramInt >= 11) && (paramInt <= 13)) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public static boolean isDrmFileType(int paramInt)
  {
    return (paramInt >= 51) && (paramInt <= 51);
  }
  
  public static boolean isImageFileType(int paramInt)
  {
    return (paramInt >= 31) && (paramInt <= 36);
  }
  
  public static boolean isMimeTypeMedia(String paramString)
  {
    int i = getFileTypeForMimeType(paramString);
    return (isAudioFileType(i)) || (isVideoFileType(i)) || (isImageFileType(i)) || (isPlayListFileType(i));
  }
  
  public static boolean isPlayListFileType(int paramInt)
  {
    return (paramInt >= 41) && (paramInt <= 44);
  }
  
  public static boolean isVideoFileType(int paramInt)
  {
    return ((paramInt >= 21) && (paramInt <= 30)) || ((paramInt >= 200) && (paramInt <= 203));
  }
  
  private static boolean isWMAEnabled()
  {
    return true;
  }
  
  private static boolean isWMVEnabled()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.MediaFile
 * JD-Core Version:    0.7.0.1
 */