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
  private static final HashMap a = new HashMap();
  private static final HashMap b = new HashMap();
  private static final HashMap c = new HashMap();
  private static final HashMap d = new HashMap();
  private static final HashMap e = new HashMap();
  
  static
  {
    a("MP3", 1, "audio/mpeg", 12297);
    a("MPGA", 1, "audio/mpeg", 12297);
    a("M4A", 2, "audio/mp4", 12299);
    a("WAV", 3, "audio/x-wav", 12296);
    a("AMR", 4, "audio/amr");
    a("AWB", 5, "audio/amr-wb");
    if (a()) {
      a("WMA", 6, "audio/x-ms-wma", 47361);
    }
    a("OGG", 7, "audio/ogg", 47362);
    a("OGG", 7, "application/ogg", 47362);
    a("OGA", 7, "application/ogg", 47362);
    a("AAC", 8, "audio/aac", 47363);
    a("AAC", 8, "audio/aac-adts", 47363);
    a("MKA", 9, "audio/x-matroska");
    a("MID", 11, "audio/midi");
    a("MIDI", 11, "audio/midi");
    a("XMF", 11, "audio/midi");
    a("RTTTL", 11, "audio/midi");
    a("SMF", 12, "audio/sp-midi");
    a("IMY", 13, "audio/imelody");
    a("RTX", 11, "audio/midi");
    a("OTA", 11, "audio/midi");
    a("MXMF", 11, "audio/midi");
    a("MPEG", 21, "video/mpeg", 12299);
    a("MPG", 21, "video/mpeg", 12299);
    a("MP4", 21, "video/mp4", 12299);
    a("M4V", 22, "video/mp4", 12299);
    a("3GP", 23, "video/3gpp", 47492);
    a("3GPP", 23, "video/3gpp", 47492);
    a("3G2", 24, "video/3gpp2", 47492);
    a("3GPP2", 24, "video/3gpp2", 47492);
    a("MKV", 27, "video/x-matroska");
    a("WEBM", 30, "video/webm");
    a("TS", 28, "video/mp2ts");
    a("AVI", 29, "video/avi");
    if (b())
    {
      a("WMV", 25, "video/x-ms-wmv", 47489);
      a("ASF", 26, "video/x-ms-asf");
    }
    a("JPG", 31, "image/jpeg", 14337);
    a("JPEG", 31, "image/jpeg", 14337);
    a("GIF", 32, "image/gif", 14343);
    a("PNG", 33, "image/png", 14347);
    a("BMP", 34, "image/x-ms-bmp", 14340);
    a("WBMP", 35, "image/vnd.wap.wbmp");
    a("WEBP", 36, "image/webp");
    a("M3U", 41, "audio/x-mpegurl", 47633);
    a("M3U", 41, "application/x-mpegurl", 47633);
    a("PLS", 42, "audio/x-scpls", 47636);
    a("WPL", 43, "application/vnd.ms-wpl", 47632);
    a("M3U8", 44, "application/vnd.apple.mpegurl");
    a("M3U8", 44, "audio/mpegurl");
    a("M3U8", 44, "audio/x-mpegurl");
    a("FL", 51, "application/x-android-drm-fl");
    a("TXT", 100, "text/plain", 12292);
    a("HTM", 101, "text/html", 12293);
    a("HTML", 101, "text/html", 12293);
    a("PDF", 102, "application/pdf");
    a("DOC", 104, "application/msword", 47747);
    a("XLS", 105, "application/vnd.ms-excel", 47749);
    a("PPT", 106, "application/mspowerpoint", 47750);
    a("FLAC", 10, "audio/flac", 47366);
    a("ZIP", 107, "application/zip");
    a("MPG", 200, "video/mp2p");
    a("MPEG", 200, "video/mp2p");
    a("FLV", 201, "video/x-flv");
    a("MOV", 202, "video/quicktime");
    a("QT", 202, "video/quicktime");
    a("RMVB", 203, "video/vnd.rn-realvideo");
  }
  
  static void a(String paramString1, int paramInt, String paramString2)
  {
    a.put(paramString1, new MediaFile.MediaFileType(paramInt, paramString2));
    b.put(paramString2, Integer.valueOf(paramInt));
  }
  
  static void a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    a(paramString1, paramInt1, paramString2);
    c.put(paramString1, Integer.valueOf(paramInt2));
    d.put(paramString2, Integer.valueOf(paramInt2));
    e.put(Integer.valueOf(paramInt2), paramString2);
  }
  
  private static boolean a()
  {
    return true;
  }
  
  private static boolean b()
  {
    return true;
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
    return (MediaFile.MediaFileType)a.get(paramString.substring(i + 1).toUpperCase());
  }
  
  public static int getFileTypeForMimeType(String paramString)
  {
    paramString = (Integer)b.get(paramString);
    if (paramString == null) {
      return 0;
    }
    return paramString.intValue();
  }
  
  public static int getFormatCode(String paramString1, String paramString2)
  {
    if (paramString2 != null)
    {
      paramString2 = (Integer)d.get(paramString2);
      if (paramString2 != null) {
        return paramString2.intValue();
      }
    }
    int i = paramString1.lastIndexOf('.');
    if (i > 0)
    {
      paramString1 = paramString1.substring(i + 1).toUpperCase();
      paramString1 = (Integer)c.get(paramString1);
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
    return (String)e.get(Integer.valueOf(paramInt));
  }
  
  public static boolean isAudioFileType(int paramInt)
  {
    return ((paramInt >= 1) && (paramInt <= 10)) || ((paramInt >= 11) && (paramInt <= 13));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.MediaFile
 * JD-Core Version:    0.7.0.1
 */