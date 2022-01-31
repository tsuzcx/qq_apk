package com.tencent.component.media.gif;

import android.util.SparseArray;
import java.util.Locale;

public class GifError
{
  public static final int CLOSE_FAILED = 110;
  public static final int DATA_TOO_BIG = 108;
  public static final int EOF_TOO_SOON = 113;
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
  private static SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(21);
  int jdField_a_of_type_Int;
  public final String description;
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseArray.put(-1, "Unknown error");
    jdField_a_of_type_AndroidUtilSparseArray.put(0, "No error");
    jdField_a_of_type_AndroidUtilSparseArray.put(101, "Failed to open given input");
    jdField_a_of_type_AndroidUtilSparseArray.put(102, "Failed to read from given input");
    jdField_a_of_type_AndroidUtilSparseArray.put(103, "Data is not in GIF format");
    jdField_a_of_type_AndroidUtilSparseArray.put(104, "No screen descriptor detected");
    jdField_a_of_type_AndroidUtilSparseArray.put(105, "No image descriptor detected");
    jdField_a_of_type_AndroidUtilSparseArray.put(106, "Neither global nor local color map found");
    jdField_a_of_type_AndroidUtilSparseArray.put(107, "Wrong record type detected");
    jdField_a_of_type_AndroidUtilSparseArray.put(108, "Number of pixels bigger than width * height");
    jdField_a_of_type_AndroidUtilSparseArray.put(109, "Failed to allocate required memory");
    jdField_a_of_type_AndroidUtilSparseArray.put(110, "Failed to close given input");
    jdField_a_of_type_AndroidUtilSparseArray.put(111, "Given file was not opened for read");
    jdField_a_of_type_AndroidUtilSparseArray.put(112, "Image is defective, decoding aborted");
    jdField_a_of_type_AndroidUtilSparseArray.put(113, "Image EOF detected before image complete");
    jdField_a_of_type_AndroidUtilSparseArray.put(1000, "No frames found, at least one frame required");
    jdField_a_of_type_AndroidUtilSparseArray.put(1001, "Invalid screen size, dimensions must be positive");
    jdField_a_of_type_AndroidUtilSparseArray.put(1002, "Invalid image size, dimensions must be positive");
    jdField_a_of_type_AndroidUtilSparseArray.put(1003, "Image size exceeds screen size");
    jdField_a_of_type_AndroidUtilSparseArray.put(1004, "Input source rewind has failed, animation is stopped");
    jdField_a_of_type_AndroidUtilSparseArray.put(1005, "Invalid and/or indirect byte buffer specified");
  }
  
  GifError(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.description = paramString;
  }
  
  static GifError a(int paramInt)
  {
    return new GifError(paramInt, (String)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt, "Unknown error"));
  }
  
  String a()
  {
    return String.format(Locale.US, "GifError %d: %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), this.description });
  }
  
  public int getErrorCode()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.gif.GifError
 * JD-Core Version:    0.7.0.1
 */