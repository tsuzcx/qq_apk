package com.tencent.biz.qqcircle.localphoto.scan.data;

import android.content.res.AssetManager.AssetInputStream;
import android.util.Log;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TimeZone;
import java.util.regex.Pattern;

public class ExpandExifInterface
{
  private static final Pattern A = Pattern.compile(".*[1-9].*");
  private static final Pattern B = Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
  private static final byte[] a = { -1, -40, -1 };
  private static SimpleDateFormat b;
  private static final String[] c = { "", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE" };
  private static final int[] d = { 0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8 };
  private static final byte[] e = { 65, 83, 67, 73, 73, 0, 0, 0 };
  private static byte[] f = new byte[8192];
  private static final ExpandExifInterface.ExifTag[] g = { new ExpandExifInterface.ExifTag("ImageWidth", 256, 3, 4, null), new ExpandExifInterface.ExifTag("ImageLength", 257, 3, 4, null), new ExpandExifInterface.ExifTag("BitsPerSample", 258, 3, null), new ExpandExifInterface.ExifTag("Compression", 259, 3, null), new ExpandExifInterface.ExifTag("PhotometricInterpretation", 262, 3, null), new ExpandExifInterface.ExifTag("ImageDescription", 270, 2, null), new ExpandExifInterface.ExifTag("Make", 271, 2, null), new ExpandExifInterface.ExifTag("Model", 272, 2, null), new ExpandExifInterface.ExifTag("StripOffsets", 273, 3, 4, null), new ExpandExifInterface.ExifTag("Orientation", 274, 3, null), new ExpandExifInterface.ExifTag("SamplesPerPixel", 277, 3, null), new ExpandExifInterface.ExifTag("RowsPerStrip", 278, 3, 4, null), new ExpandExifInterface.ExifTag("StripByteCounts", 279, 3, 4, null), new ExpandExifInterface.ExifTag("XResolution", 282, 5, null), new ExpandExifInterface.ExifTag("YResolution", 283, 5, null), new ExpandExifInterface.ExifTag("PlanarConfiguration", 284, 3, null), new ExpandExifInterface.ExifTag("ResolutionUnit", 296, 3, null), new ExpandExifInterface.ExifTag("TransferFunction", 301, 3, null), new ExpandExifInterface.ExifTag("Software", 305, 2, null), new ExpandExifInterface.ExifTag("DateTime", 306, 2, null), new ExpandExifInterface.ExifTag("Artist", 315, 2, null), new ExpandExifInterface.ExifTag("WhitePoint", 318, 5, null), new ExpandExifInterface.ExifTag("PrimaryChromaticities", 319, 5, null), new ExpandExifInterface.ExifTag("JPEGInterchangeFormat", 513, 4, null), new ExpandExifInterface.ExifTag("JPEGInterchangeFormatLength", 514, 4, null), new ExpandExifInterface.ExifTag("YCbCrCoefficients", 529, 5, null), new ExpandExifInterface.ExifTag("YCbCrSubSampling", 530, 3, null), new ExpandExifInterface.ExifTag("YCbCrPositioning", 531, 3, null), new ExpandExifInterface.ExifTag("ReferenceBlackWhite", 532, 5, null), new ExpandExifInterface.ExifTag("Copyright", 33432, 2, null), new ExpandExifInterface.ExifTag("ExifIFDPointer", 34665, 4, null), new ExpandExifInterface.ExifTag("GPSInfoIFDPointer", 34853, 4, null) };
  private static final ExpandExifInterface.ExifTag[] h = { new ExpandExifInterface.ExifTag("ExposureTime", 33434, 5, null), new ExpandExifInterface.ExifTag("FNumber", 33437, 5, null), new ExpandExifInterface.ExifTag("ExposureProgram", 34850, 3, null), new ExpandExifInterface.ExifTag("SpectralSensitivity", 34852, 2, null), new ExpandExifInterface.ExifTag("ISOSpeedRatings", 34855, 3, null), new ExpandExifInterface.ExifTag("OECF", 34856, 7, null), new ExpandExifInterface.ExifTag("ExifVersion", 36864, 2, null), new ExpandExifInterface.ExifTag("DateTimeOriginal", 36867, 2, null), new ExpandExifInterface.ExifTag("DateTimeDigitized", 36868, 2, null), new ExpandExifInterface.ExifTag("ComponentsConfiguration", 37121, 7, null), new ExpandExifInterface.ExifTag("CompressedBitsPerPixel", 37122, 5, null), new ExpandExifInterface.ExifTag("ShutterSpeedValue", 37377, 10, null), new ExpandExifInterface.ExifTag("ApertureValue", 37378, 5, null), new ExpandExifInterface.ExifTag("BrightnessValue", 37379, 10, null), new ExpandExifInterface.ExifTag("ExposureBiasValue", 37380, 10, null), new ExpandExifInterface.ExifTag("MaxApertureValue", 37381, 5, null), new ExpandExifInterface.ExifTag("SubjectDistance", 37382, 5, null), new ExpandExifInterface.ExifTag("MeteringMode", 37383, 3, null), new ExpandExifInterface.ExifTag("LightSource", 37384, 3, null), new ExpandExifInterface.ExifTag("Flash", 37385, 3, null), new ExpandExifInterface.ExifTag("FocalLength", 37386, 5, null), new ExpandExifInterface.ExifTag("SubjectArea", 37396, 3, null), new ExpandExifInterface.ExifTag("MakerNote", 37500, 7, null), new ExpandExifInterface.ExifTag("UserComment", 37510, 7, null), new ExpandExifInterface.ExifTag("SubSecTime", 37520, 2, null), new ExpandExifInterface.ExifTag("SubSecTimeOriginal", 37521, 2, null), new ExpandExifInterface.ExifTag("SubSecTimeDigitized", 37522, 2, null), new ExpandExifInterface.ExifTag("FlashpixVersion", 40960, 7, null), new ExpandExifInterface.ExifTag("ColorSpace", 40961, 3, null), new ExpandExifInterface.ExifTag("PixelXDimension", 40962, 3, 4, null), new ExpandExifInterface.ExifTag("PixelYDimension", 40963, 3, 4, null), new ExpandExifInterface.ExifTag("RelatedSoundFile", 40964, 2, null), new ExpandExifInterface.ExifTag("InteroperabilityIFDPointer", 40965, 4, null), new ExpandExifInterface.ExifTag("FlashEnergy", 41483, 5, null), new ExpandExifInterface.ExifTag("SpatialFrequencyResponse", 41484, 7, null), new ExpandExifInterface.ExifTag("FocalPlaneXResolution", 41486, 5, null), new ExpandExifInterface.ExifTag("FocalPlaneYResolution", 41487, 5, null), new ExpandExifInterface.ExifTag("FocalPlaneResolutionUnit", 41488, 3, null), new ExpandExifInterface.ExifTag("SubjectLocation", 41492, 3, null), new ExpandExifInterface.ExifTag("ExposureIndex", 41493, 5, null), new ExpandExifInterface.ExifTag("SensingMethod", 41495, 3, null), new ExpandExifInterface.ExifTag("FileSource", 41728, 7, null), new ExpandExifInterface.ExifTag("SceneType", 41729, 7, null), new ExpandExifInterface.ExifTag("CFAPattern", 41730, 7, null), new ExpandExifInterface.ExifTag("CustomRendered", 41985, 3, null), new ExpandExifInterface.ExifTag("ExposureMode", 41986, 3, null), new ExpandExifInterface.ExifTag("WhiteBalance", 41987, 3, null), new ExpandExifInterface.ExifTag("DigitalZoomRatio", 41988, 5, null), new ExpandExifInterface.ExifTag("FocalLengthIn35mmFilm", 41989, 3, null), new ExpandExifInterface.ExifTag("SceneCaptureType", 41990, 3, null), new ExpandExifInterface.ExifTag("GainControl", 41991, 3, null), new ExpandExifInterface.ExifTag("Contrast", 41992, 3, null), new ExpandExifInterface.ExifTag("Saturation", 41993, 3, null), new ExpandExifInterface.ExifTag("Sharpness", 41994, 3, null), new ExpandExifInterface.ExifTag("DeviceSettingDescription", 41995, 7, null), new ExpandExifInterface.ExifTag("SubjectDistanceRange", 41996, 3, null), new ExpandExifInterface.ExifTag("ImageUniqueID", 42016, 2, null) };
  private static final ExpandExifInterface.ExifTag[] i = { new ExpandExifInterface.ExifTag("GPSVersionID", 0, 1, null), new ExpandExifInterface.ExifTag("GPSLatitudeRef", 1, 2, null), new ExpandExifInterface.ExifTag("GPSLatitude", 2, 5, null), new ExpandExifInterface.ExifTag("GPSLongitudeRef", 3, 2, null), new ExpandExifInterface.ExifTag("GPSLongitude", 4, 5, null), new ExpandExifInterface.ExifTag("GPSAltitudeRef", 5, 1, null), new ExpandExifInterface.ExifTag("GPSAltitude", 6, 5, null), new ExpandExifInterface.ExifTag("GPSTimeStamp", 7, 5, null), new ExpandExifInterface.ExifTag("GPSSatellites", 8, 2, null), new ExpandExifInterface.ExifTag("GPSStatus", 9, 2, null), new ExpandExifInterface.ExifTag("GPSMeasureMode", 10, 2, null), new ExpandExifInterface.ExifTag("GPSDOP", 11, 5, null), new ExpandExifInterface.ExifTag("GPSSpeedRef", 12, 2, null), new ExpandExifInterface.ExifTag("GPSSpeed", 13, 5, null), new ExpandExifInterface.ExifTag("GPSTrackRef", 14, 2, null), new ExpandExifInterface.ExifTag("GPSTrack", 15, 5, null), new ExpandExifInterface.ExifTag("GPSImgDirectionRef", 16, 2, null), new ExpandExifInterface.ExifTag("GPSImgDirection", 17, 5, null), new ExpandExifInterface.ExifTag("GPSMapDatum", 18, 2, null), new ExpandExifInterface.ExifTag("GPSDestLatitudeRef", 19, 2, null), new ExpandExifInterface.ExifTag("GPSDestLatitude", 20, 5, null), new ExpandExifInterface.ExifTag("GPSDestLongitudeRef", 21, 2, null), new ExpandExifInterface.ExifTag("GPSDestLongitude", 22, 5, null), new ExpandExifInterface.ExifTag("GPSDestBearingRef", 23, 2, null), new ExpandExifInterface.ExifTag("GPSDestBearing", 24, 5, null), new ExpandExifInterface.ExifTag("GPSDestDistanceRef", 25, 2, null), new ExpandExifInterface.ExifTag("GPSDestDistance", 26, 5, null), new ExpandExifInterface.ExifTag("GPSProcessingMethod", 27, 7, null), new ExpandExifInterface.ExifTag("GPSAreaInformation", 28, 7, null), new ExpandExifInterface.ExifTag("GPSDateStamp", 29, 2, null), new ExpandExifInterface.ExifTag("GPSDifferential", 30, 3, null) };
  private static final ExpandExifInterface.ExifTag[] j = { new ExpandExifInterface.ExifTag("InteroperabilityIndex", 1, 2, null) };
  private static final ExpandExifInterface.ExifTag[] k = { new ExpandExifInterface.ExifTag("ThumbnailImageWidth", 256, 3, 4, null), new ExpandExifInterface.ExifTag("ThumbnailImageLength", 257, 3, 4, null), new ExpandExifInterface.ExifTag("BitsPerSample", 258, 3, null), new ExpandExifInterface.ExifTag("Compression", 259, 3, null), new ExpandExifInterface.ExifTag("PhotometricInterpretation", 262, 3, null), new ExpandExifInterface.ExifTag("ImageDescription", 270, 2, null), new ExpandExifInterface.ExifTag("Make", 271, 2, null), new ExpandExifInterface.ExifTag("Model", 272, 2, null), new ExpandExifInterface.ExifTag("StripOffsets", 3, 4, null), new ExpandExifInterface.ExifTag("Orientation", 274, 3, null), new ExpandExifInterface.ExifTag("SamplesPerPixel", 277, 3, null), new ExpandExifInterface.ExifTag("RowsPerStrip", 278, 3, 4, null), new ExpandExifInterface.ExifTag("StripByteCounts", 279, 3, 4, null), new ExpandExifInterface.ExifTag("XResolution", 282, 5, null), new ExpandExifInterface.ExifTag("YResolution", 283, 5, null), new ExpandExifInterface.ExifTag("PlanarConfiguration", 284, 3, null), new ExpandExifInterface.ExifTag("ResolutionUnit", 296, 3, null), new ExpandExifInterface.ExifTag("TransferFunction", 301, 3, null), new ExpandExifInterface.ExifTag("Software", 305, 2, null), new ExpandExifInterface.ExifTag("DateTime", 306, 2, null), new ExpandExifInterface.ExifTag("Artist", 315, 2, null), new ExpandExifInterface.ExifTag("WhitePoint", 318, 5, null), new ExpandExifInterface.ExifTag("PrimaryChromaticities", 319, 5, null), new ExpandExifInterface.ExifTag("JPEGInterchangeFormat", 513, 4, null), new ExpandExifInterface.ExifTag("JPEGInterchangeFormatLength", 514, 4, null), new ExpandExifInterface.ExifTag("YCbCrCoefficients", 529, 5, null), new ExpandExifInterface.ExifTag("YCbCrSubSampling", 530, 3, null), new ExpandExifInterface.ExifTag("YCbCrPositioning", 531, 3, null), new ExpandExifInterface.ExifTag("ReferenceBlackWhite", 532, 5, null), new ExpandExifInterface.ExifTag("Copyright", 33432, 2, null), new ExpandExifInterface.ExifTag("ExifIFDPointer", 34665, 4, null), new ExpandExifInterface.ExifTag("GPSInfoIFDPointer", 34853, 4, null) };
  private static final ExpandExifInterface.ExifTag[][] l = { g, h, i, j, k };
  private static final ExpandExifInterface.ExifTag[] m = { new ExpandExifInterface.ExifTag("ExifIFDPointer", 34665, 4, null), new ExpandExifInterface.ExifTag("GPSInfoIFDPointer", 34853, 4, null), new ExpandExifInterface.ExifTag("InteroperabilityIFDPointer", 40965, 4, null) };
  private static final int[] n = { 1, 2, 3 };
  private static final ExpandExifInterface.ExifTag o = new ExpandExifInterface.ExifTag("JPEGInterchangeFormat", 513, 4, null);
  private static final ExpandExifInterface.ExifTag p = new ExpandExifInterface.ExifTag("JPEGInterchangeFormatLength", 514, 4, null);
  private static final HashMap[] q;
  private static final HashMap[] r;
  private static final HashSet<String> s;
  private static final Charset t;
  private static final byte[] u;
  private final String v;
  private final AssetManager.AssetInputStream w;
  private final boolean x;
  private final HashMap[] y;
  private ByteOrder z;
  
  static
  {
    Object localObject1 = l;
    q = new HashMap[localObject1.length];
    r = new HashMap[localObject1.length];
    s = new HashSet(Arrays.asList(new String[] { "FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp" }));
    t = Charset.forName("US-ASCII");
    u = "".getBytes(t);
    b = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
    b.setTimeZone(TimeZone.getTimeZone("UTC"));
    int i1 = 0;
    while (i1 < l.length)
    {
      q[i1] = new HashMap();
      r[i1] = new HashMap();
      localObject1 = l[i1];
      int i3 = localObject1.length;
      int i2 = 0;
      while (i2 < i3)
      {
        Object localObject2 = localObject1[i2];
        q[i1].put(Integer.valueOf(localObject2.a), localObject2);
        r[i1].put(localObject2.b, localObject2);
        i2 += 1;
      }
      i1 += 1;
    }
  }
  
  /* Error */
  public ExpandExifInterface(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 522	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: getstatic 423	com/tencent/biz/qqcircle/localphoto/scan/data/ExpandExifInterface:l	[[Lcom/tencent/biz/qqcircle/localphoto/scan/data/ExpandExifInterface$ExifTag;
    //   8: arraylength
    //   9: anewarray 433	java/util/HashMap
    //   12: putfield 524	com/tencent/biz/qqcircle/localphoto/scan/data/ExpandExifInterface:y	[Ljava/util/HashMap;
    //   15: aload_0
    //   16: getstatic 529	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
    //   19: putfield 531	com/tencent/biz/qqcircle/localphoto/scan/data/ExpandExifInterface:z	Ljava/nio/ByteOrder;
    //   22: aload_1
    //   23: ifnull +52 -> 75
    //   26: aconst_null
    //   27: astore_3
    //   28: aload_0
    //   29: aconst_null
    //   30: putfield 533	com/tencent/biz/qqcircle/localphoto/scan/data/ExpandExifInterface:w	Landroid/content/res/AssetManager$AssetInputStream;
    //   33: aload_0
    //   34: aload_1
    //   35: putfield 535	com/tencent/biz/qqcircle/localphoto/scan/data/ExpandExifInterface:v	Ljava/lang/String;
    //   38: aload_0
    //   39: iconst_0
    //   40: putfield 537	com/tencent/biz/qqcircle/localphoto/scan/data/ExpandExifInterface:x	Z
    //   43: new 539	java/io/FileInputStream
    //   46: dup
    //   47: aload_1
    //   48: invokespecial 540	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   51: astore_1
    //   52: aload_0
    //   53: aload_1
    //   54: invokespecial 543	com/tencent/biz/qqcircle/localphoto/scan/data/ExpandExifInterface:a	(Ljava/io/InputStream;)V
    //   57: aload_1
    //   58: invokestatic 546	com/tencent/biz/qqcircle/localphoto/scan/data/ExpandExifInterface:a	(Ljava/io/Closeable;)V
    //   61: return
    //   62: astore_2
    //   63: goto +6 -> 69
    //   66: astore_2
    //   67: aload_3
    //   68: astore_1
    //   69: aload_1
    //   70: invokestatic 546	com/tencent/biz/qqcircle/localphoto/scan/data/ExpandExifInterface:a	(Ljava/io/Closeable;)V
    //   73: aload_2
    //   74: athrow
    //   75: new 548	java/lang/IllegalArgumentException
    //   78: dup
    //   79: ldc_w 550
    //   82: invokespecial 551	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	ExpandExifInterface
    //   0	86	1	paramString	String
    //   62	1	2	localObject1	Object
    //   66	8	2	localObject2	Object
    //   27	41	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   52	57	62	finally
    //   43	52	66	finally
  }
  
  private static float a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = paramString1.split(",");
      String[] arrayOfString = paramString1[0].split("/");
      double d1 = Double.parseDouble(arrayOfString[0].trim()) / Double.parseDouble(arrayOfString[1].trim());
      arrayOfString = paramString1[1].split("/");
      double d2 = Double.parseDouble(arrayOfString[0].trim()) / Double.parseDouble(arrayOfString[1].trim());
      paramString1 = paramString1[2].split("/");
      double d3 = Double.parseDouble(paramString1[0].trim()) / Double.parseDouble(paramString1[1].trim());
      d1 = d1 + d2 / 60.0D + d3 / 3600.0D;
      if (!paramString2.equals("S"))
      {
        boolean bool = paramString2.equals("W");
        if (!bool) {
          return (float)d1;
        }
      }
      return (float)-d1;
    }
    catch (NumberFormatException paramString1)
    {
      break label164;
    }
    catch (ArrayIndexOutOfBoundsException paramString1)
    {
      label156:
      label164:
      break label156;
    }
    throw new IllegalArgumentException();
    throw new IllegalArgumentException();
  }
  
  private static int a(int paramInt)
  {
    int i1 = 0;
    while (i1 < n.length)
    {
      if (m[i1].a == paramInt) {
        return n[i1];
      }
      i1 += 1;
    }
    return -1;
  }
  
  private void a(ExpandExifInterface.ByteOrderAwarenessDataInputStream paramByteOrderAwarenessDataInputStream, int paramInt)
  {
    for (;;)
    {
      int i1;
      try
      {
        if (paramByteOrderAwarenessDataInputStream.a() + 2L > ExpandExifInterface.ByteOrderAwarenessDataInputStream.a(paramByteOrderAwarenessDataInputStream)) {
          return;
        }
        i3 = paramByteOrderAwarenessDataInputStream.b();
        if (paramByteOrderAwarenessDataInputStream.a() + i3 * 12 <= ExpandExifInterface.ByteOrderAwarenessDataInputStream.a(paramByteOrderAwarenessDataInputStream)) {
          break label651;
        }
        return;
      }
      catch (OutOfMemoryError paramByteOrderAwarenessDataInputStream)
      {
        int i3;
        int i4;
        int i5;
        long l2;
        int i6;
        byte[] arrayOfByte;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("OutOfMemoryError : ");
        ((StringBuilder)localObject).append(paramByteOrderAwarenessDataInputStream);
        Log.w("ExpandExifInterface", ((StringBuilder)localObject).toString());
        return;
      }
      catch (StackOverflowError paramByteOrderAwarenessDataInputStream)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("StackOverflowError : ");
        ((StringBuilder)localObject).append(paramByteOrderAwarenessDataInputStream);
        Log.w("ExpandExifInterface", ((StringBuilder)localObject).toString());
      }
      if (i2 < i3)
      {
        i4 = paramByteOrderAwarenessDataInputStream.d();
        i1 = paramByteOrderAwarenessDataInputStream.d();
        i5 = paramByteOrderAwarenessDataInputStream.c();
        l2 = paramByteOrderAwarenessDataInputStream.a() + 4L;
        localObject = (ExpandExifInterface.ExifTag)q[paramInt].get(Integer.valueOf(i4));
        if ((localObject != null) && (i1 > 0) && (i1 < d.length))
        {
          i6 = d[i1] * i5;
          if (i6 > 4)
          {
            l1 = paramByteOrderAwarenessDataInputStream.e();
            if (i6 + l1 <= ExpandExifInterface.ByteOrderAwarenessDataInputStream.a(paramByteOrderAwarenessDataInputStream))
            {
              paramByteOrderAwarenessDataInputStream.a(l1);
            }
            else
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("Skip the tag entry since data offset is invalid: ");
              ((StringBuilder)localObject).append(l1);
              Log.w("ExpandExifInterface", ((StringBuilder)localObject).toString());
              paramByteOrderAwarenessDataInputStream.a(l2);
              break label667;
            }
            i4 = a(i4);
            if (i4 >= 0)
            {
              l1 = -1L;
              if (i1 != 3)
              {
                if (i1 != 4)
                {
                  if (i1 != 8)
                  {
                    if (i1 == 9)
                    {
                      i1 = paramByteOrderAwarenessDataInputStream.c();
                      break label660;
                    }
                  }
                  else
                  {
                    i1 = paramByteOrderAwarenessDataInputStream.b();
                    break label660;
                  }
                }
                else {
                  l1 = paramByteOrderAwarenessDataInputStream.e();
                }
              }
              else
              {
                i1 = paramByteOrderAwarenessDataInputStream.d();
                break label660;
              }
              if ((l1 > 0L) && (l1 < ExpandExifInterface.ByteOrderAwarenessDataInputStream.a(paramByteOrderAwarenessDataInputStream)))
              {
                paramByteOrderAwarenessDataInputStream.a(l1);
                a(paramByteOrderAwarenessDataInputStream, i4);
              }
              else
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("Skip jump into the IFD since its offset is invalid: ");
                ((StringBuilder)localObject).append(l1);
                Log.w("ExpandExifInterface", ((StringBuilder)localObject).toString());
              }
              paramByteOrderAwarenessDataInputStream.a(l2);
              break label667;
            }
            arrayOfByte = new byte[d[i1] * i5];
            paramByteOrderAwarenessDataInputStream.a(arrayOfByte);
            this.y[paramInt].put(((ExpandExifInterface.ExifTag)localObject).b, new ExpandExifInterface.ExifAttribute(i1, i5, arrayOfByte, null));
            if (paramByteOrderAwarenessDataInputStream.a() == l2) {
              break label667;
            }
            paramByteOrderAwarenessDataInputStream.a(l2);
            break label667;
          }
        }
        else
        {
          if (localObject == null)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Skip the tag entry since tag number is not defined: ");
            ((StringBuilder)localObject).append(i4);
            Log.w("ExpandExifInterface", ((StringBuilder)localObject).toString());
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Skip the tag entry since data format is invalid: ");
            ((StringBuilder)localObject).append(i1);
            Log.w("ExpandExifInterface", ((StringBuilder)localObject).toString());
          }
          paramByteOrderAwarenessDataInputStream.a(l2);
          break label667;
        }
      }
      else
      {
        if (paramByteOrderAwarenessDataInputStream.a() + 4L <= ExpandExifInterface.ByteOrderAwarenessDataInputStream.a(paramByteOrderAwarenessDataInputStream))
        {
          l1 = paramByteOrderAwarenessDataInputStream.e();
          if ((l1 > 8L) && (l1 < ExpandExifInterface.ByteOrderAwarenessDataInputStream.a(paramByteOrderAwarenessDataInputStream)))
          {
            paramByteOrderAwarenessDataInputStream.a(l1);
            a(paramByteOrderAwarenessDataInputStream, 4);
            return;
          }
        }
        return;
        label651:
        i2 = 0;
        continue;
      }
      continue;
      label660:
      long l1 = i1;
      continue;
      label667:
      int i2 = (short)(i2 + 1);
    }
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (RuntimeException paramCloseable)
    {
      throw paramCloseable;
      return;
    }
    catch (Exception paramCloseable) {}
  }
  
  /* Error */
  private void a(InputStream paramInputStream)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iload_2
    //   3: getstatic 423	com/tencent/biz/qqcircle/localphoto/scan/data/ExpandExifInterface:l	[[Lcom/tencent/biz/qqcircle/localphoto/scan/data/ExpandExifInterface$ExifTag;
    //   6: arraylength
    //   7: if_icmpge +23 -> 30
    //   10: aload_0
    //   11: getfield 524	com/tencent/biz/qqcircle/localphoto/scan/data/ExpandExifInterface:y	[Ljava/util/HashMap;
    //   14: iload_2
    //   15: new 433	java/util/HashMap
    //   18: dup
    //   19: invokespecial 491	java/util/HashMap:<init>	()V
    //   22: aastore
    //   23: iload_2
    //   24: iconst_1
    //   25: iadd
    //   26: istore_2
    //   27: goto -25 -> 2
    //   30: new 689	com/tencent/biz/qqcircle/localphoto/scan/data/ExpandBufferedInputStream
    //   33: dup
    //   34: aload_1
    //   35: getstatic 95	com/tencent/biz/qqcircle/localphoto/scan/data/ExpandExifInterface:f	[B
    //   38: invokespecial 692	com/tencent/biz/qqcircle/localphoto/scan/data/ExpandBufferedInputStream:<init>	(Ljava/io/InputStream;[B)V
    //   41: astore_1
    //   42: aload_1
    //   43: checkcast 689	com/tencent/biz/qqcircle/localphoto/scan/data/ExpandBufferedInputStream
    //   46: invokestatic 695	com/tencent/biz/qqcircle/localphoto/scan/data/ExpandExifInterface:a	(Lcom/tencent/biz/qqcircle/localphoto/scan/data/ExpandBufferedInputStream;)Z
    //   49: istore_3
    //   50: iload_3
    //   51: ifne +8 -> 59
    //   54: aload_0
    //   55: invokespecial 697	com/tencent/biz/qqcircle/localphoto/scan/data/ExpandExifInterface:e	()V
    //   58: return
    //   59: aload_0
    //   60: aload_1
    //   61: invokespecial 699	com/tencent/biz/qqcircle/localphoto/scan/data/ExpandExifInterface:b	(Ljava/io/InputStream;)V
    //   64: goto +19 -> 83
    //   67: astore_1
    //   68: goto +20 -> 88
    //   71: astore_1
    //   72: ldc_w 636
    //   75: ldc_w 701
    //   78: aload_1
    //   79: invokestatic 704	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   82: pop
    //   83: aload_0
    //   84: invokespecial 697	com/tencent/biz/qqcircle/localphoto/scan/data/ExpandExifInterface:e	()V
    //   87: return
    //   88: aload_0
    //   89: invokespecial 697	com/tencent/biz/qqcircle/localphoto/scan/data/ExpandExifInterface:e	()V
    //   92: goto +5 -> 97
    //   95: aload_1
    //   96: athrow
    //   97: goto -2 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	ExpandExifInterface
    //   0	100	1	paramInputStream	InputStream
    //   1	26	2	i1	int
    //   49	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	23	67	finally
    //   30	50	67	finally
    //   59	64	67	finally
    //   72	83	67	finally
    //   2	23	71	java/io/IOException
    //   30	50	71	java/io/IOException
    //   59	64	71	java/io/IOException
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    ExpandExifInterface.ByteOrderAwarenessDataInputStream localByteOrderAwarenessDataInputStream = new ExpandExifInterface.ByteOrderAwarenessDataInputStream(paramArrayOfByte);
    paramInt = localByteOrderAwarenessDataInputStream.b();
    if (paramInt != 18761)
    {
      if (paramInt == 19789)
      {
        this.z = ByteOrder.BIG_ENDIAN;
      }
      else
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("Invalid byte order: ");
        paramArrayOfByte.append(Integer.toHexString(paramInt));
        throw new IOException(paramArrayOfByte.toString());
      }
    }
    else {
      this.z = ByteOrder.LITTLE_ENDIAN;
    }
    localByteOrderAwarenessDataInputStream.a(this.z);
    paramInt = localByteOrderAwarenessDataInputStream.d();
    if (paramInt == 42)
    {
      long l1 = localByteOrderAwarenessDataInputStream.e();
      if ((l1 >= 8L) && (l1 < paramArrayOfByte.length))
      {
        l1 -= 8L;
        if ((l1 > 0L) && (localByteOrderAwarenessDataInputStream.skip(l1) != l1))
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("Couldn't jump to first Ifd: ");
          paramArrayOfByte.append(l1);
          throw new IOException(paramArrayOfByte.toString());
        }
        a(localByteOrderAwarenessDataInputStream, 0);
        return;
      }
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("Invalid first Ifd offset: ");
      paramArrayOfByte.append(l1);
      throw new IOException(paramArrayOfByte.toString());
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("Invalid exif start: ");
    paramArrayOfByte.append(Integer.toHexString(paramInt));
    throw new IOException(paramArrayOfByte.toString());
  }
  
  private static boolean a(ExpandBufferedInputStream paramExpandBufferedInputStream)
  {
    paramExpandBufferedInputStream.mark(3);
    byte[] arrayOfByte = new byte[3];
    if (paramExpandBufferedInputStream.read(arrayOfByte) == 3)
    {
      boolean bool = Arrays.equals(a, arrayOfByte);
      paramExpandBufferedInputStream.reset();
      return bool;
    }
    throw new EOFException();
  }
  
  private ExpandExifInterface.ExifAttribute b(String paramString)
  {
    int i1 = 0;
    while (i1 < l.length)
    {
      Object localObject = this.y[i1].get(paramString);
      if (localObject != null) {
        return (ExpandExifInterface.ExifAttribute)localObject;
      }
      i1 += 1;
    }
    return null;
  }
  
  private void b(InputStream paramInputStream)
  {
    DataInputStream localDataInputStream = new DataInputStream(paramInputStream);
    int i1 = localDataInputStream.readByte();
    if (i1 == -1)
    {
      if (localDataInputStream.readByte() == -40)
      {
        int i2;
        for (i1 = 2;; i1 = i2 + i1)
        {
          i2 = localDataInputStream.readByte();
          if (i2 != -1) {
            break label595;
          }
          i2 = localDataInputStream.readByte();
          i1 = i1 + 1 + 1;
          if ((i2 == -39) || (i2 == -38)) {
            break label561;
          }
          int i3 = localDataInputStream.readUnsignedShort() - 2;
          i1 += 2;
          if (i3 < 0) {
            break label550;
          }
          byte[] arrayOfByte;
          if (i2 != -31)
          {
            if (i2 != -2) {
              switch (i2)
              {
              default: 
                switch (i2)
                {
                default: 
                  switch (i2)
                  {
                  default: 
                    switch (i2)
                    {
                    default: 
                      i2 = i1;
                      i1 = i3;
                    }
                    break;
                  }
                  break;
                }
                break;
              case -64: 
              case -63: 
              case -62: 
              case -61: 
                if (localDataInputStream.skipBytes(1) == 1)
                {
                  this.y[0].put("ImageLength", ExpandExifInterface.ExifAttribute.a(localDataInputStream.readUnsignedShort(), this.z));
                  this.y[0].put("ImageWidth", ExpandExifInterface.ExifAttribute.a(localDataInputStream.readUnsignedShort(), this.z));
                  i3 -= 5;
                  i2 = i1;
                  i1 = i3;
                  break;
                }
                throw new IOException("Invalid SOFx");
              }
            }
            arrayOfByte = new byte[i3];
            if (localDataInputStream.read(arrayOfByte) == i3)
            {
              i2 = i1;
              if (a("UserComment") == null)
              {
                this.y[1].put("UserComment", ExpandExifInterface.ExifAttribute.a(new String(arrayOfByte, t)));
                i2 = i1;
              }
            }
          }
          for (;;)
          {
            i1 = 0;
            break;
            throw new IOException("Invalid exif");
            if (i3 < 6)
            {
              i2 = i1;
              i1 = i3;
              break;
            }
            arrayOfByte = new byte[6];
            if (paramInputStream.read(arrayOfByte) != 6) {
              break label539;
            }
            i2 = i1 + 6;
            i1 = i3 - 6;
            if (!Arrays.equals(arrayOfByte, u)) {
              break;
            }
            if (i1 <= 0) {
              break label528;
            }
            arrayOfByte = new byte[i1];
            if (localDataInputStream.read(arrayOfByte) != i1) {
              break label517;
            }
            a(arrayOfByte, i2);
            i2 += i1;
          }
          if (i1 < 0) {
            break label506;
          }
          if (localDataInputStream.skipBytes(i1) != i1) {
            break;
          }
        }
        throw new IOException("Invalid JPEG segment");
        label506:
        throw new IOException("Invalid length");
        label517:
        throw new IOException("Invalid exif");
        label528:
        throw new IOException("Invalid exif");
        label539:
        throw new IOException("Invalid exif");
        label550:
        throw new IOException("Invalid length");
        label561:
        paramInputStream = new StringBuilder();
        paramInputStream.append("bytesRead : ");
        paramInputStream.append(i1);
        Log.w("exif-demo", paramInputStream.toString());
        return;
        label595:
        paramInputStream = new StringBuilder();
        paramInputStream.append("Invalid marker:");
        paramInputStream.append(Integer.toHexString(i2 & 0xFF));
        throw new IOException(paramInputStream.toString());
      }
      paramInputStream = new StringBuilder();
      paramInputStream.append("Invalid marker: ");
      paramInputStream.append(Integer.toHexString(i1 & 0xFF));
      throw new IOException(paramInputStream.toString());
    }
    paramInputStream = new StringBuilder();
    paramInputStream.append("Invalid marker: ");
    paramInputStream.append(Integer.toHexString(i1 & 0xFF));
    paramInputStream = new IOException(paramInputStream.toString());
    for (;;)
    {
      throw paramInputStream;
    }
  }
  
  private void e()
  {
    String str = a("DateTimeOriginal");
    if (str != null) {
      this.y[0].put("DateTime", ExpandExifInterface.ExifAttribute.a(str));
    }
    if (a("ImageWidth") == null) {
      this.y[0].put("ImageWidth", ExpandExifInterface.ExifAttribute.a(0L, this.z));
    }
    if (a("ImageLength") == null) {
      this.y[0].put("ImageLength", ExpandExifInterface.ExifAttribute.a(0L, this.z));
    }
    if (a("Orientation") == null) {
      this.y[0].put("Orientation", ExpandExifInterface.ExifAttribute.a(0L, this.z));
    }
    if (a("LightSource") == null) {
      this.y[1].put("LightSource", ExpandExifInterface.ExifAttribute.a(0L, this.z));
    }
  }
  
  public int a(String paramString, int paramInt)
  {
    paramString = b(paramString);
    if (paramString == null) {
      return paramInt;
    }
    try
    {
      int i1 = paramString.b(this.z);
      return i1;
    }
    catch (NumberFormatException paramString) {}
    return paramInt;
  }
  
  public String a(String paramString)
  {
    ExpandExifInterface.ExifAttribute localExifAttribute = b(paramString);
    if (localExifAttribute != null)
    {
      if (!s.contains(paramString)) {
        return localExifAttribute.c(this.z);
      }
      if (paramString.equals("GPSTimeStamp"))
      {
        if ((localExifAttribute.a != 5) && (localExifAttribute.a != 10)) {
          return null;
        }
        paramString = (ExpandExifInterface.Rational[])ExpandExifInterface.ExifAttribute.a(localExifAttribute, this.z);
        if (paramString != null)
        {
          if (paramString.length != 3) {
            return null;
          }
          return String.format("%02d:%02d:%02d", new Object[] { Integer.valueOf((int)((float)paramString[0].a / (float)paramString[0].b)), Integer.valueOf((int)((float)paramString[1].a / (float)paramString[1].b)), Integer.valueOf((int)((float)paramString[2].a / (float)paramString[2].b)) });
        }
        return null;
      }
    }
    try
    {
      paramString = Double.toString(localExifAttribute.a(this.z));
      return paramString;
    }
    catch (NumberFormatException paramString) {}
    return null;
    return null;
  }
  
  public boolean a(float[] paramArrayOfFloat)
  {
    String str1 = a("GPSLatitude");
    String str2 = a("GPSLatitudeRef");
    String str3 = a("GPSLongitude");
    String str4 = a("GPSLongitudeRef");
    if ((str1 != null) && (str2 != null) && (str3 != null) && (str4 != null)) {}
    try
    {
      paramArrayOfFloat[0] = a(str1, str2);
      paramArrayOfFloat[1] = a(str3, str4);
      return true;
    }
    catch (IllegalArgumentException paramArrayOfFloat) {}
    return false;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.localphoto.scan.data.ExpandExifInterface
 * JD-Core Version:    0.7.0.1
 */