package com.tencent.component.media.gif;

import android.util.SparseArray;
import java.util.Locale;

public class GifError
{
  public static final int CLOSE_FAILED = 110;
  public static final int DATA_TOO_BIG = 108;
  public static final int EOF_TOO_SOON = 113;
  private static SparseArray<String> ERR_MAP = new SparseArray(21);
  private static final String ERR_MSG_DEFAULT = "Unknown error";
  public static final int IMAGE_DEFECT = 112;
  public static final int IMG_NOT_CONFINED = 1003;
  public static final int INVALID_BYTE_BUFFER = 1005;
  public static final int INVALID_IMG_DIMS = 1002;
  public static final int INVALID_SCR_DIMS = 1001;
  public static final int NOT_ENOUGH_MEM = 109;
  public static final int NOT_GIF_FILE = 103;
  public static final int NOT_READABLE = 111;
  public static final int NO_COLOR_MAP = 106;
  public static final int NO_ERROR = 0;
  public static final int NO_FRAMES = 1000;
  public static final int NO_IMAG_DSCR = 105;
  public static final int NO_SCRN_DSCR = 104;
  public static final int OPEN_FAILED = 101;
  public static final int READ_FAILED = 102;
  public static final int REWIND_FAILED = 1004;
  public static final int UNKNOWN = -1;
  public static final int WRONG_RECORD = 107;
  public final String description;
  int errorCode;
  
  static
  {
    ERR_MAP.put(-1, "Unknown error");
    ERR_MAP.put(0, "No error");
    ERR_MAP.put(101, "Failed to open given input");
    ERR_MAP.put(102, "Failed to read from given input");
    ERR_MAP.put(103, "Data is not in GIF format");
    ERR_MAP.put(104, "No screen descriptor detected");
    ERR_MAP.put(105, "No image descriptor detected");
    ERR_MAP.put(106, "Neither global nor local color map found");
    ERR_MAP.put(107, "Wrong record type detected");
    ERR_MAP.put(108, "Number of pixels bigger than width * height");
    ERR_MAP.put(109, "Failed to allocate required memory");
    ERR_MAP.put(110, "Failed to close given input");
    ERR_MAP.put(111, "Given file was not opened for read");
    ERR_MAP.put(112, "Image is defective, decoding aborted");
    ERR_MAP.put(113, "Image EOF detected before image complete");
    ERR_MAP.put(1000, "No frames found, at least one frame required");
    ERR_MAP.put(1001, "Invalid screen size, dimensions must be positive");
    ERR_MAP.put(1002, "Invalid image size, dimensions must be positive");
    ERR_MAP.put(1003, "Image size exceeds screen size");
    ERR_MAP.put(1004, "Input source rewind has failed, animation is stopped");
    ERR_MAP.put(1005, "Invalid and/or indirect byte buffer specified");
  }
  
  GifError(int paramInt, String paramString)
  {
    this.errorCode = paramInt;
    this.description = paramString;
  }
  
  static GifError fromCode(int paramInt)
  {
    return new GifError(paramInt, (String)ERR_MAP.get(paramInt, "Unknown error"));
  }
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  String getFormattedDescription()
  {
    return String.format(Locale.US, "GifError %d: %s", new Object[] { Integer.valueOf(this.errorCode), this.description });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.media.gif.GifError
 * JD-Core Version:    0.7.0.1
 */