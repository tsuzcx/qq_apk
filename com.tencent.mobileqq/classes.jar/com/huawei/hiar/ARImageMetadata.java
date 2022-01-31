package com.huawei.hiar;

import android.util.Rational;
import com.huawei.hiar.exceptions.ARFatalException;

public class ARImageMetadata
{
  public static final int BLACK_LEVEL_LOCK = 1441792;
  private static final int BLACK_LEVEL_START = 1441792;
  public static final int COLOR_CORRECTION_ABERRATION_MODE = 3;
  public static final int COLOR_CORRECTION_GAINS = 2;
  public static final int COLOR_CORRECTION_MODE = 0;
  private static final int COLOR_CORRECTION_START = 0;
  public static final int COLOR_CORRECTION_TRANSFORM = 1;
  public static final int CONTROL_AE_ANTIBANDING_MODE = 65536;
  public static final int CONTROL_AE_EXPOSURE_COMPENSATION = 65537;
  public static final int CONTROL_AE_LOCK = 65538;
  public static final int CONTROL_AE_MODE = 65539;
  public static final int CONTROL_AE_PRECAPTURE_TRIGGER = 65542;
  public static final int CONTROL_AE_REGIONS = 65540;
  public static final int CONTROL_AE_STATE = 65567;
  public static final int CONTROL_AE_TARGET_FPS_RANGE = 65541;
  public static final int CONTROL_AF_MODE = 65543;
  public static final int CONTROL_AF_REGIONS = 65544;
  public static final int CONTROL_AF_STATE = 65568;
  public static final int CONTROL_AF_TRIGGER = 65545;
  public static final int CONTROL_AWB_LOCK = 65546;
  public static final int CONTROL_AWB_MODE = 65547;
  public static final int CONTROL_AWB_REGIONS = 65548;
  public static final int CONTROL_AWB_STATE = 65570;
  public static final int CONTROL_CAPTURE_INTENT = 65549;
  public static final int CONTROL_EFFECT_MODE = 65550;
  public static final int CONTROL_MODE = 65551;
  public static final int CONTROL_POST_RAW_SENSITIVITY_BOOST = 65576;
  public static final int CONTROL_SCENE_MODE = 65552;
  private static final int CONTROL_START = 65536;
  public static final int CONTROL_VIDEO_STABILIZATION_MODE = 65553;
  private static final int DEPTH_START = 1638400;
  public static final int EDGE_MODE = 196608;
  private static final int EDGE_START = 196608;
  private static final int FLASH_INFO_START = 327680;
  public static final int FLASH_MODE = 262146;
  private static final int FLASH_START = 262144;
  public static final int FLASH_STATE = 262149;
  public static final int HOT_PIXEL_MODE = 393216;
  private static final int HOT_PIXEL_START = 393216;
  private static final int INFO_START = 1376256;
  public static final int JPEG_GPS_COORDINATES = 458752;
  public static final int JPEG_GPS_PROCESSING_METHOD = 458753;
  public static final int JPEG_GPS_TIMESTAMP = 458754;
  public static final int JPEG_ORIENTATION = 458755;
  public static final int JPEG_QUALITY = 458756;
  private static final int JPEG_START = 458752;
  public static final int JPEG_THUMBNAIL_QUALITY = 458757;
  public static final int JPEG_THUMBNAIL_SIZE = 458758;
  public static final int LENS_APERTURE = 524288;
  public static final int LENS_FILTER_DENSITY = 524289;
  public static final int LENS_FOCAL_LENGTH = 524290;
  public static final int LENS_FOCUS_DISTANCE = 524291;
  public static final int LENS_FOCUS_RANGE = 524296;
  private static final int LENS_INFO_START = 589824;
  public static final int LENS_INTRINSIC_CALIBRATION = 524298;
  public static final int LENS_OPTICAL_STABILIZATION_MODE = 524292;
  public static final int LENS_POSE_ROTATION = 524294;
  public static final int LENS_POSE_TRANSLATION = 524295;
  public static final int LENS_RADIAL_DISTORTION = 524299;
  private static final int LENS_START = 524288;
  public static final int LENS_STATE = 524297;
  public static final int NOISE_REDUCTION_MODE = 655360;
  private static final int NOISE_REDUCTION_START = 655360;
  public static final int REQUEST_PIPELINE_DEPTH = 786441;
  private static final int REQUEST_START = 786432;
  public static final int SCALER_CROP_REGION = 851968;
  private static final int SCALER_START = 851968;
  private static final int SECTION_BLACK_LEVEL = 22;
  private static final int SECTION_COLOR_CORRECTION = 0;
  private static final int SECTION_CONTROL = 1;
  private static final int SECTION_DEPTH = 25;
  private static final int SECTION_EDGE = 3;
  private static final int SECTION_FLASH = 4;
  private static final int SECTION_FLASH_INFO = 5;
  private static final int SECTION_HOT_PIXEL = 6;
  private static final int SECTION_INFO = 21;
  private static final int SECTION_JPEG = 7;
  private static final int SECTION_LENS = 8;
  private static final int SECTION_LENS_INFO = 9;
  private static final int SECTION_NOISE_REDUCTION = 10;
  private static final int SECTION_REQUEST = 12;
  private static final int SECTION_SCALER = 13;
  private static final int SECTION_SENSOR = 14;
  private static final int SECTION_SENSOR_INFO = 15;
  private static final int SECTION_SHADING = 16;
  private static final int SECTION_STATISTICS = 17;
  private static final int SECTION_STATISTICS_INFO = 18;
  private static final int SECTION_SYNC = 23;
  private static final int SECTION_TONEMAP = 19;
  public static final int SENSOR_DYNAMIC_BLACK_LEVEL = 917532;
  public static final int SENSOR_DYNAMIC_WHITE_LEVEL = 917533;
  public static final int SENSOR_EXPOSURE_TIME = 917504;
  public static final int SENSOR_FRAME_DURATION = 917505;
  public static final int SENSOR_GREEN_SPLIT = 917526;
  private static final int SENSOR_INFO_START = 983040;
  public static final int SENSOR_NEUTRAL_COLOR_POINT = 917522;
  public static final int SENSOR_NOISE_PROFILE = 917523;
  public static final int SENSOR_ROLLING_SHUTTER_SKEW = 917530;
  public static final int SENSOR_SENSITIVITY = 917506;
  private static final int SENSOR_START = 917504;
  public static final int SENSOR_TEST_PATTERN_DATA = 917527;
  public static final int SENSOR_TEST_PATTERN_MODE = 917528;
  public static final int SENSOR_TIMESTAMP = 917520;
  public static final int SHADING_MODE = 1048576;
  private static final int SHADING_START = 1048576;
  public static final int STATISTICS_FACE_DETECT_MODE = 1114112;
  public static final int STATISTICS_FACE_IDS = 1114116;
  public static final int STATISTICS_FACE_LANDMARKS = 1114117;
  public static final int STATISTICS_FACE_RECTANGLES = 1114118;
  public static final int STATISTICS_FACE_SCORES = 1114119;
  public static final int STATISTICS_HOT_PIXEL_MAP = 1114127;
  public static final int STATISTICS_HOT_PIXEL_MAP_MODE = 1114115;
  private static final int STATISTICS_INFO_START = 1179648;
  public static final int STATISTICS_LENS_SHADING_MAP = 1114123;
  public static final int STATISTICS_LENS_SHADING_MAP_MODE = 1114128;
  public static final int STATISTICS_SCENE_FLICKER = 1114126;
  private static final int STATISTICS_START = 1114112;
  public static final int SYNC_FRAME_NUMBER = 1507328;
  private static final int SYNC_START = 1507328;
  private static final String TAG = ARImageMetadata.class.getSimpleName();
  public static final int TONEMAP_CURVE_BLUE = 1245184;
  public static final int TONEMAP_CURVE_GREEN = 1245185;
  public static final int TONEMAP_CURVE_RED = 1245186;
  public static final int TONEMAP_GAMMA = 1245190;
  public static final int TONEMAP_MODE = 1245187;
  public static final int TONEMAP_PRESET_CURVE = 1245191;
  private static final int TONEMAP_START = 1245184;
  private static final int TYPE_BYTE = 0;
  private static final int TYPE_DOUBLE = 4;
  private static final int TYPE_FLOAT = 2;
  private static final int TYPE_INT = 1;
  private static final int TYPE_LONG = 3;
  private static final int TYPE_RATIONAL = 5;
  private final long mNativeHandle;
  private final ARSession mSession;
  private final ARImageMetadata.a mSketchEntry;
  
  protected ARImageMetadata()
  {
    this.mSession = null;
    this.mNativeHandle = 0L;
    this.mSketchEntry = null;
  }
  
  ARImageMetadata(long paramLong, ARSession paramARSession)
  {
    this.mSession = paramARSession;
    this.mNativeHandle = paramLong;
    this.mSketchEntry = new ARImageMetadata.a();
  }
  
  private void getMetdataEntry(int paramInt, ARImageMetadata.a parama)
  {
    parama.a = nativeGetMetadataEntry(this.mSession.mNativeHandle, this.mNativeHandle, paramInt);
    if (parama.a == 0L) {
      throw new IllegalArgumentException(String.format("Invalid ImageMetadata key: %1$d", new Object[] { Integer.valueOf(paramInt) }));
    }
    parama.b = ARImageMetadata.a.a.a(nativeGetMetadataEntryValueType(this.mSession.mNativeHandle, parama.a));
    parama.c = nativeGetMetadataEntryValueCount(this.mSession.mNativeHandle, parama.a);
  }
  
  private native void nativeDestroyMetadataEntry(long paramLong1, long paramLong2);
  
  private native int[] nativeGetAllKeys(long paramLong1, long paramLong2);
  
  private native byte[] nativeGetByteArrayFromMetadataEntry(long paramLong1, long paramLong2);
  
  private native byte nativeGetByteFromMetadataEntry(long paramLong1, long paramLong2);
  
  private native double[] nativeGetDoubleArrayFromMetadataEntry(long paramLong1, long paramLong2);
  
  private native double nativeGetDoubleFromMetadataEntry(long paramLong1, long paramLong2);
  
  private native float[] nativeGetFloatArrayFromMetadataEntry(long paramLong1, long paramLong2);
  
  private native float nativeGetFloatFromMetadataEntry(long paramLong1, long paramLong2);
  
  private native int[] nativeGetIntArrayFromMetadataEntry(long paramLong1, long paramLong2);
  
  private native int nativeGetIntFromMetadataEntry(long paramLong1, long paramLong2);
  
  private native long[] nativeGetLongArrayFromMetadataEntry(long paramLong1, long paramLong2);
  
  private native long nativeGetLongFromMetadataEntry(long paramLong1, long paramLong2);
  
  private native long nativeGetMetadataEntry(long paramLong1, long paramLong2, int paramInt);
  
  private native int nativeGetMetadataEntryValueCount(long paramLong1, long paramLong2);
  
  private native int nativeGetMetadataEntryValueType(long paramLong1, long paramLong2);
  
  private native Rational[] nativeGetRationalArrayFromMetadataEntry(long paramLong1, long paramLong2);
  
  private native Rational nativeGetRationalFromMetadataEntry(long paramLong1, long paramLong2);
  
  private static native void nativeReleaseImageMetadata(long paramLong);
  
  protected void finalize()
  {
    if (this.mNativeHandle != 0L) {
      nativeReleaseImageMetadata(this.mNativeHandle);
    }
    super.finalize();
  }
  
  public byte getByte(int paramInt)
  {
    getMetdataEntry(paramInt, this.mSketchEntry);
    if ((this.mSketchEntry.b != ARImageMetadata.a.a.b) || (this.mSketchEntry.c != 1)) {
      throw new IllegalArgumentException(String.format("Wrong return type for ImageMetadata key: %1$d.", new Object[] { Integer.valueOf(paramInt) }));
    }
    byte b = nativeGetByteFromMetadataEntry(this.mSession.mNativeHandle, this.mSketchEntry.a);
    nativeDestroyMetadataEntry(this.mSession.mNativeHandle, this.mSketchEntry.a);
    return b;
  }
  
  public byte[] getByteArray(int paramInt)
  {
    getMetdataEntry(paramInt, this.mSketchEntry);
    if (this.mSketchEntry.b != ARImageMetadata.a.a.b) {
      throw new IllegalArgumentException(String.format("Wrong return type for ImageMetadata key: %1$d.", new Object[] { Integer.valueOf(paramInt) }));
    }
    byte[] arrayOfByte = nativeGetByteArrayFromMetadataEntry(this.mSession.mNativeHandle, this.mSketchEntry.a);
    nativeDestroyMetadataEntry(this.mSession.mNativeHandle, this.mSketchEntry.a);
    return arrayOfByte;
  }
  
  public double getDouble(int paramInt)
  {
    getMetdataEntry(paramInt, this.mSketchEntry);
    if ((this.mSketchEntry.b != ARImageMetadata.a.a.f) || (this.mSketchEntry.c != 1)) {
      throw new IllegalArgumentException(String.format("Wrong return type for ImageMetadata key: %1$d.", new Object[] { Integer.valueOf(paramInt) }));
    }
    double d = nativeGetDoubleFromMetadataEntry(this.mSession.mNativeHandle, this.mSketchEntry.a);
    nativeDestroyMetadataEntry(this.mSession.mNativeHandle, this.mSketchEntry.a);
    return d;
  }
  
  public double[] getDoubleArray(int paramInt)
  {
    getMetdataEntry(paramInt, this.mSketchEntry);
    if (this.mSketchEntry.b != ARImageMetadata.a.a.f) {
      throw new IllegalArgumentException(String.format("Wrong return type for ImageMetadata key: %1$d.", new Object[] { Integer.valueOf(paramInt) }));
    }
    double[] arrayOfDouble = nativeGetDoubleArrayFromMetadataEntry(this.mSession.mNativeHandle, this.mSketchEntry.a);
    nativeDestroyMetadataEntry(this.mSession.mNativeHandle, this.mSketchEntry.a);
    return arrayOfDouble;
  }
  
  public float getFloat(int paramInt)
  {
    getMetdataEntry(paramInt, this.mSketchEntry);
    if ((this.mSketchEntry.b != ARImageMetadata.a.a.d) || (this.mSketchEntry.c != 1)) {
      throw new IllegalArgumentException(String.format("Wrong return type for ImageMetadata key: %1$d.", new Object[] { Integer.valueOf(paramInt) }));
    }
    float f = nativeGetFloatFromMetadataEntry(this.mSession.mNativeHandle, this.mSketchEntry.a);
    nativeDestroyMetadataEntry(this.mSession.mNativeHandle, this.mSketchEntry.a);
    return f;
  }
  
  public float[] getFloatArray(int paramInt)
  {
    getMetdataEntry(paramInt, this.mSketchEntry);
    if (this.mSketchEntry.b != ARImageMetadata.a.a.d) {
      throw new IllegalArgumentException(String.format("Wrong return type for ImageMetadata key: %1$d.", new Object[] { Integer.valueOf(paramInt) }));
    }
    float[] arrayOfFloat = nativeGetFloatArrayFromMetadataEntry(this.mSession.mNativeHandle, this.mSketchEntry.a);
    nativeDestroyMetadataEntry(this.mSession.mNativeHandle, this.mSketchEntry.a);
    return arrayOfFloat;
  }
  
  public int getInt(int paramInt)
  {
    getMetdataEntry(paramInt, this.mSketchEntry);
    if ((this.mSketchEntry.b != ARImageMetadata.a.a.c) || (this.mSketchEntry.c != 1)) {
      throw new IllegalArgumentException(String.format("Wrong return type for ImageMetadata key: %1$d.", new Object[] { Integer.valueOf(paramInt) }));
    }
    paramInt = nativeGetIntFromMetadataEntry(this.mSession.mNativeHandle, this.mSketchEntry.a);
    nativeDestroyMetadataEntry(this.mSession.mNativeHandle, this.mSketchEntry.a);
    return paramInt;
  }
  
  public int[] getIntArray(int paramInt)
  {
    getMetdataEntry(paramInt, this.mSketchEntry);
    if (this.mSketchEntry.b != ARImageMetadata.a.a.c) {
      throw new IllegalArgumentException(String.format("Wrong return type for ImageMetadata key: %1$d.", new Object[] { Integer.valueOf(paramInt) }));
    }
    int[] arrayOfInt = nativeGetIntArrayFromMetadataEntry(this.mSession.mNativeHandle, this.mSketchEntry.a);
    nativeDestroyMetadataEntry(this.mSession.mNativeHandle, this.mSketchEntry.a);
    return arrayOfInt;
  }
  
  public int[] getKeys()
  {
    int[] arrayOfInt = nativeGetAllKeys(this.mSession.mNativeHandle, this.mNativeHandle);
    if (arrayOfInt == null) {
      throw new ARFatalException("Unknown error in ImageMetadata.getKeys().");
    }
    return arrayOfInt;
  }
  
  public long getLong(int paramInt)
  {
    getMetdataEntry(paramInt, this.mSketchEntry);
    if ((this.mSketchEntry.b != ARImageMetadata.a.a.e) || (this.mSketchEntry.c != 1)) {
      throw new IllegalArgumentException(String.format("Wrong return type for ImageMetadata key: %1$d.", new Object[] { Integer.valueOf(paramInt) }));
    }
    long l = nativeGetLongFromMetadataEntry(this.mSession.mNativeHandle, this.mSketchEntry.a);
    nativeDestroyMetadataEntry(this.mSession.mNativeHandle, this.mSketchEntry.a);
    return l;
  }
  
  public long[] getLongArray(int paramInt)
  {
    getMetdataEntry(paramInt, this.mSketchEntry);
    if (this.mSketchEntry.b != ARImageMetadata.a.a.e) {
      throw new IllegalArgumentException(String.format("Wrong return type for ImageMetadata key: %1$d.", new Object[] { Integer.valueOf(paramInt) }));
    }
    long[] arrayOfLong = nativeGetLongArrayFromMetadataEntry(this.mSession.mNativeHandle, this.mSketchEntry.a);
    nativeDestroyMetadataEntry(this.mSession.mNativeHandle, this.mSketchEntry.a);
    return arrayOfLong;
  }
  
  public Rational getRational(int paramInt)
  {
    getMetdataEntry(paramInt, this.mSketchEntry);
    if ((this.mSketchEntry.b != ARImageMetadata.a.a.g) || (this.mSketchEntry.c != 1)) {
      throw new IllegalArgumentException(String.format("Wrong return type for ImageMetadata key: %1$d.", new Object[] { Integer.valueOf(paramInt) }));
    }
    Rational localRational = nativeGetRationalFromMetadataEntry(this.mSession.mNativeHandle, this.mSketchEntry.a);
    nativeDestroyMetadataEntry(this.mSession.mNativeHandle, this.mSketchEntry.a);
    return localRational;
  }
  
  public Rational[] getRationalArray(int paramInt)
  {
    getMetdataEntry(paramInt, this.mSketchEntry);
    if (this.mSketchEntry.b != ARImageMetadata.a.a.g) {
      throw new IllegalArgumentException(String.format("Wrong return type for ImageMetadata key: %1$d.", new Object[] { Integer.valueOf(paramInt) }));
    }
    Rational[] arrayOfRational = nativeGetRationalArrayFromMetadataEntry(this.mSession.mNativeHandle, this.mSketchEntry.a);
    nativeDestroyMetadataEntry(this.mSession.mNativeHandle, this.mSketchEntry.a);
    return arrayOfRational;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.huawei.hiar.ARImageMetadata
 * JD-Core Version:    0.7.0.1
 */