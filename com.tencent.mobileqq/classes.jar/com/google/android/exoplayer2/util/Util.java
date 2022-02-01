package com.google.android.exoplayer2.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.Display.Mode;
import android.view.WindowManager;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.upstream.DataSource;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Util
{
  private static final int[] CRC32_BYTES_MSBF;
  public static final String DEVICE;
  public static final String DEVICE_DEBUG_INFO;
  private static final Pattern ESCAPED_CHARACTER_PATTERN;
  public static final String MANUFACTURER;
  public static final String MODEL;
  public static final int SDK_INT;
  private static final String TAG = "Util";
  private static final Pattern XS_DATE_TIME_PATTERN;
  private static final Pattern XS_DURATION_PATTERN;
  
  static
  {
    if ((Build.VERSION.SDK_INT == 25) && (Build.VERSION.CODENAME.charAt(0) == 'O')) {}
    for (int i = 26;; i = Build.VERSION.SDK_INT)
    {
      SDK_INT = i;
      DEVICE = Build.DEVICE;
      MANUFACTURER = Build.MANUFACTURER;
      MODEL = Build.MODEL;
      DEVICE_DEBUG_INFO = DEVICE + ", " + MODEL + ", " + MANUFACTURER + ", " + SDK_INT;
      XS_DATE_TIME_PATTERN = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
      XS_DURATION_PATTERN = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
      ESCAPED_CHARACTER_PATTERN = Pattern.compile("%([A-Fa-f0-9]{2})");
      CRC32_BYTES_MSBF = new int[] { 0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108 };
      return;
    }
  }
  
  public static long addWithOverflowDefault(long paramLong1, long paramLong2, long paramLong3)
  {
    long l = paramLong1 + paramLong2;
    if (((paramLong1 ^ l) & (paramLong2 ^ l)) < 0L) {
      return paramLong3;
    }
    return l;
  }
  
  public static boolean areEqual(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  public static <T> int binarySearchCeil(List<? extends Comparable<? super T>> paramList, T paramT, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = Collections.binarySearch(paramList, paramT);
    if (i < 0) {
      i ^= 0xFFFFFFFF;
    }
    for (;;)
    {
      int j = i;
      if (paramBoolean2) {
        j = Math.min(paramList.size() - 1, i);
      }
      return j;
      int k = paramList.size();
      do
      {
        j = i + 1;
        if (j >= k) {
          break;
        }
        i = j;
      } while (((Comparable)paramList.get(j)).compareTo(paramT) == 0);
      if (paramBoolean1) {
        i = j - 1;
      } else {
        i = j;
      }
    }
  }
  
  public static int binarySearchCeil(long[] paramArrayOfLong, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = Arrays.binarySearch(paramArrayOfLong, paramLong);
    int i = j;
    if (j < 0) {
      i = j ^ 0xFFFFFFFF;
    }
    for (;;)
    {
      j = i;
      if (paramBoolean2) {
        j = Math.min(paramArrayOfLong.length - 1, i);
      }
      return j;
      do
      {
        j = i + 1;
        if (j >= paramArrayOfLong.length) {
          break;
        }
        i = j;
      } while (paramArrayOfLong[j] == paramLong);
      i = j;
      if (paramBoolean1) {
        i = j - 1;
      }
    }
  }
  
  public static <T> int binarySearchFloor(List<? extends Comparable<? super T>> paramList, T paramT, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = Collections.binarySearch(paramList, paramT);
    int i = j;
    if (j < 0) {
      i = -(j + 2);
    }
    for (;;)
    {
      j = i;
      if (paramBoolean2) {
        j = Math.max(0, i);
      }
      return j;
      do
      {
        j = i - 1;
        if (j < 0) {
          break;
        }
        i = j;
      } while (((Comparable)paramList.get(j)).compareTo(paramT) == 0);
      if (paramBoolean1) {
        i = j + 1;
      } else {
        i = j;
      }
    }
  }
  
  public static int binarySearchFloor(int[] paramArrayOfInt, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = Arrays.binarySearch(paramArrayOfInt, paramInt);
    int i = j;
    if (j < 0) {
      paramInt = -(j + 2);
    }
    for (;;)
    {
      i = paramInt;
      if (paramBoolean2) {
        i = Math.max(0, paramInt);
      }
      return i;
      do
      {
        j = i - 1;
        if (j < 0) {
          break;
        }
        i = j;
      } while (paramArrayOfInt[j] == paramInt);
      paramInt = j;
      if (paramBoolean1) {
        paramInt = j + 1;
      }
    }
  }
  
  public static int binarySearchFloor(long[] paramArrayOfLong, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = Arrays.binarySearch(paramArrayOfLong, paramLong);
    int i = j;
    if (j < 0) {
      i = -(j + 2);
    }
    for (;;)
    {
      j = i;
      if (paramBoolean2) {
        j = Math.max(0, i);
      }
      return j;
      do
      {
        j = i - 1;
        if (j < 0) {
          break;
        }
        i = j;
      } while (paramArrayOfLong[j] == paramLong);
      i = j;
      if (paramBoolean1) {
        i = j + 1;
      }
    }
  }
  
  public static int ceilDivide(int paramInt1, int paramInt2)
  {
    return (paramInt1 + paramInt2 - 1) / paramInt2;
  }
  
  public static long ceilDivide(long paramLong1, long paramLong2)
  {
    return (paramLong1 + paramLong2 - 1L) / paramLong2;
  }
  
  public static void closeQuietly(DataSource paramDataSource)
  {
    if (paramDataSource != null) {}
    try
    {
      paramDataSource.close();
      return;
    }
    catch (IOException paramDataSource) {}
  }
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  public static int compareLong(long paramLong1, long paramLong2)
  {
    if (paramLong1 < paramLong2) {
      return -1;
    }
    if (paramLong1 == paramLong2) {
      return 0;
    }
    return 1;
  }
  
  public static float constrainValue(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.max(paramFloat2, Math.min(paramFloat1, paramFloat3));
  }
  
  public static int constrainValue(int paramInt1, int paramInt2, int paramInt3)
  {
    return Math.max(paramInt2, Math.min(paramInt1, paramInt3));
  }
  
  public static long constrainValue(long paramLong1, long paramLong2, long paramLong3)
  {
    return Math.max(paramLong2, Math.min(paramLong1, paramLong3));
  }
  
  public static boolean contains(Object[] paramArrayOfObject, Object paramObject)
  {
    boolean bool2 = false;
    int j = paramArrayOfObject.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (areEqual(paramArrayOfObject[i], paramObject)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static int crc(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    while (paramInt1 < paramInt2)
    {
      paramInt3 = paramInt3 << 8 ^ CRC32_BYTES_MSBF[((paramInt3 >>> 24 ^ paramArrayOfByte[paramInt1] & 0xFF) & 0xFF)];
      paramInt1 += 1;
    }
    return paramInt3;
  }
  
  public static File createTempDirectory(Context paramContext, String paramString)
  {
    paramContext = createTempFile(paramContext, paramString);
    paramContext.delete();
    paramContext.mkdir();
    return paramContext;
  }
  
  public static File createTempFile(Context paramContext, String paramString)
  {
    return File.createTempFile(paramString, null, paramContext.getCacheDir());
  }
  
  public static String escapeFileName(String paramString)
  {
    int m = 0;
    int n = paramString.length();
    int j = 0;
    int k;
    for (int i = 0; j < n; i = k)
    {
      k = i;
      if (shouldEscapeCharacter(paramString.charAt(j))) {
        k = i + 1;
      }
      j += 1;
    }
    if (i == 0) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder(i * 2 + n);
    j = m;
    if (i > 0)
    {
      char c = paramString.charAt(j);
      if (shouldEscapeCharacter(c))
      {
        localStringBuilder.append('%').append(Integer.toHexString(c));
        i -= 1;
      }
      for (;;)
      {
        j += 1;
        break;
        localStringBuilder.append(c);
      }
    }
    if (j < n) {
      localStringBuilder.append(paramString, j, n);
    }
    return localStringBuilder.toString();
  }
  
  public static String fromUtf8Bytes(byte[] paramArrayOfByte)
  {
    return new String(paramArrayOfByte, Charset.forName("UTF-8"));
  }
  
  public static int getAudioContentTypeForStreamType(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    case 6: 
    case 7: 
    default: 
      return 2;
    case 1: 
    case 2: 
    case 4: 
    case 5: 
    case 8: 
      return 4;
    }
    return 1;
  }
  
  public static int getAudioUsageForStreamType(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    case 6: 
    case 7: 
    default: 
      return 1;
    case 4: 
      return 4;
    case 8: 
      return 3;
    case 5: 
      return 5;
    case 2: 
      return 6;
    case 1: 
      return 13;
    }
    return 2;
  }
  
  public static byte[] getBytesFromHexString(String paramString)
  {
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    int i = 0;
    while (i < arrayOfByte.length)
    {
      int j = i * 2;
      int k = Character.digit(paramString.charAt(j), 16);
      arrayOfByte[i] = ((byte)(Character.digit(paramString.charAt(j + 1), 16) + (k << 4)));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static String getCodecsOfType(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    StringBuilder localStringBuilder;
    do
    {
      return null;
      paramString = paramString.trim().split("(\\s*,\\s*)");
      localStringBuilder = new StringBuilder();
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramString[i];
        if (paramInt == MimeTypes.getTrackTypeOfCodec(str))
        {
          if (localStringBuilder.length() > 0) {
            localStringBuilder.append(",");
          }
          localStringBuilder.append(str);
        }
        i += 1;
      }
    } while (localStringBuilder.length() <= 0);
    return localStringBuilder.toString();
  }
  
  public static String getCommaDelimitedSimpleClassNames(Object[] paramArrayOfObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfObject.length)
    {
      localStringBuilder.append(paramArrayOfObject[i].getClass().getSimpleName());
      if (i < paramArrayOfObject.length - 1) {
        localStringBuilder.append(", ");
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static int getDefaultBufferSize(int paramInt)
  {
    int i = 131072;
    switch (paramInt)
    {
    default: 
      throw new IllegalStateException();
    case 0: 
      i = 16777216;
    case 3: 
    case 4: 
      return i;
    case 1: 
      return 3538944;
    }
    return 13107200;
  }
  
  @TargetApi(16)
  private static void getDisplaySizeV16(Display paramDisplay, Point paramPoint)
  {
    paramDisplay.getSize(paramPoint);
  }
  
  @TargetApi(17)
  private static void getDisplaySizeV17(Display paramDisplay, Point paramPoint)
  {
    paramDisplay.getRealSize(paramPoint);
  }
  
  @TargetApi(23)
  private static void getDisplaySizeV23(Display paramDisplay, Point paramPoint)
  {
    paramDisplay = paramDisplay.getMode();
    paramPoint.x = paramDisplay.getPhysicalWidth();
    paramPoint.y = paramDisplay.getPhysicalHeight();
  }
  
  private static void getDisplaySizeV9(Display paramDisplay, Point paramPoint)
  {
    paramPoint.x = paramDisplay.getWidth();
    paramPoint.y = paramDisplay.getHeight();
  }
  
  public static UUID getDrmUuid(String paramString)
  {
    String str = toLowerInvariant(paramString);
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      }
      try
      {
        paramString = UUID.fromString(paramString);
        return paramString;
      }
      catch (RuntimeException paramString) {}
      if (str.equals("widevine"))
      {
        i = 0;
        continue;
        if (str.equals("playready"))
        {
          i = 1;
          continue;
          if (str.equals("clearkey")) {
            i = 2;
          }
        }
      }
    }
    return C.WIDEVINE_UUID;
    return C.PLAYREADY_UUID;
    return C.CLEARKEY_UUID;
    return null;
  }
  
  public static int getIntegerCodeForString(String paramString)
  {
    int i = 0;
    int k = paramString.length();
    if (k <= 4) {}
    int j;
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkArgument(bool);
      j = 0;
      while (i < k)
      {
        j = j << 8 | paramString.charAt(i);
        i += 1;
      }
    }
    return j;
  }
  
  public static long getMediaDurationForPlayoutDuration(long paramLong, float paramFloat)
  {
    if (paramFloat == 1.0F) {
      return paramLong;
    }
    return Math.round(paramLong * paramFloat);
  }
  
  public static int getPcmEncoding(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 8: 
      return 3;
    case 16: 
      return 2;
    case 24: 
      return -2147483648;
    }
    return 1073741824;
  }
  
  public static int getPcmFrameSize(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    switch (paramInt1)
    {
    default: 
      throw new IllegalArgumentException();
    case 2: 
      i = paramInt2 * 2;
    case 3: 
      return i;
    case -2147483648: 
      return paramInt2 * 3;
    }
    return paramInt2 * 4;
  }
  
  public static Point getPhysicalDisplaySize(Context paramContext)
  {
    return getPhysicalDisplaySize(paramContext, ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay());
  }
  
  public static Point getPhysicalDisplaySize(Context paramContext, Display paramDisplay)
  {
    if ((SDK_INT < 25) && (paramDisplay.getDisplayId() == 0))
    {
      if (("Sony".equals(MANUFACTURER)) && (MODEL.startsWith("BRAVIA")) && (paramContext.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd"))) {
        return new Point(3840, 2160);
      }
      if ((("NVIDIA".equals(MANUFACTURER)) && (MODEL.contains("SHIELD"))) || (("philips".equals(toLowerInvariant(MANUFACTURER))) && ((MODEL.startsWith("QM1")) || (MODEL.equals("QV151E")) || (MODEL.equals("TPM171E"))))) {
        try
        {
          paramContext = Class.forName("android.os.SystemProperties");
          paramContext = (String)paramContext.getMethod("get", new Class[] { String.class }).invoke(paramContext, new Object[] { "sys.display-size" });
          if (TextUtils.isEmpty(paramContext)) {}
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            try
            {
              Object localObject = paramContext.trim().split("x");
              if (localObject.length != 2) {
                continue;
              }
              int i = Integer.parseInt(localObject[0]);
              int j = Integer.parseInt(localObject[1]);
              if ((i <= 0) || (j <= 0)) {
                continue;
              }
              localObject = new Point(i, j);
              return localObject;
            }
            catch (NumberFormatException localNumberFormatException)
            {
              Log.e("Util", "Invalid sys.display-size: " + paramContext);
            }
            paramContext = paramContext;
            Log.e("Util", "Failed to read sys.display-size", paramContext);
            paramContext = null;
          }
        }
      }
    }
    paramContext = new Point();
    if (SDK_INT >= 23)
    {
      getDisplaySizeV23(paramDisplay, paramContext);
      return paramContext;
    }
    if (SDK_INT >= 17)
    {
      getDisplaySizeV17(paramDisplay, paramContext);
      return paramContext;
    }
    if (SDK_INT >= 16)
    {
      getDisplaySizeV16(paramDisplay, paramContext);
      return paramContext;
    }
    getDisplaySizeV9(paramDisplay, paramContext);
    return paramContext;
  }
  
  public static long getPlayoutDurationForMediaDuration(long paramLong, float paramFloat)
  {
    if (paramFloat == 1.0F) {
      return paramLong;
    }
    return Math.round(paramLong / paramFloat);
  }
  
  public static int getStreamTypeForAudioUsage(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 11: 
    case 12: 
    case 14: 
    default: 
      return 3;
    case 13: 
      return 1;
    case 2: 
      return 0;
    case 3: 
      return 8;
    case 4: 
      return 4;
    case 6: 
      return 2;
    }
    return 5;
  }
  
  public static String getStringForTime(StringBuilder paramStringBuilder, Formatter paramFormatter, long paramLong)
  {
    long l1 = paramLong;
    if (paramLong == -9223372036854775807L) {
      l1 = 0L;
    }
    long l2 = (500L + l1) / 1000L;
    paramLong = l2 % 60L;
    l1 = l2 / 60L % 60L;
    l2 /= 3600L;
    paramStringBuilder.setLength(0);
    if (l2 > 0L) {
      return paramFormatter.format("%d:%02d:%02d", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(paramLong) }).toString();
    }
    return paramFormatter.format("%02d:%02d", new Object[] { Long.valueOf(l1), Long.valueOf(paramLong) }).toString();
  }
  
  public static String getUserAgent(Context paramContext, String paramString)
  {
    try
    {
      String str = paramContext.getPackageName();
      paramContext = paramContext.getPackageManager().getPackageInfo(str, 0).versionName;
      return paramString + "/" + paramContext + " (Linux;Android " + Build.VERSION.RELEASE + ") " + "ExoPlayerLib/2.7.1";
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = "?";
      }
    }
  }
  
  public static byte[] getUtf8Bytes(String paramString)
  {
    return paramString.getBytes(Charset.forName("UTF-8"));
  }
  
  public static int inferContentType(Uri paramUri)
  {
    paramUri = paramUri.getPath();
    if (paramUri == null) {
      return 3;
    }
    return inferContentType(paramUri);
  }
  
  public static int inferContentType(String paramString)
  {
    paramString = toLowerInvariant(paramString);
    if (paramString.endsWith(".mpd")) {
      return 0;
    }
    if (paramString.endsWith(".m3u8")) {
      return 2;
    }
    if (paramString.matches(".*\\.ism(l)?(/manifest(\\(.+\\))?)?")) {
      return 1;
    }
    return 3;
  }
  
  public static boolean isEncodingHighResolutionIntegerPcm(int paramInt)
  {
    return (paramInt == -2147483648) || (paramInt == 1073741824);
  }
  
  public static boolean isLinebreak(int paramInt)
  {
    return (paramInt == 10) || (paramInt == 13);
  }
  
  public static boolean isLocalFileUri(Uri paramUri)
  {
    paramUri = paramUri.getScheme();
    return (TextUtils.isEmpty(paramUri)) || (paramUri.equals("file"));
  }
  
  @TargetApi(23)
  public static boolean maybeRequestReadExternalStoragePermission(Activity paramActivity, Uri... paramVarArgs)
  {
    if (SDK_INT < 23) {}
    label61:
    for (;;)
    {
      return false;
      int j = paramVarArgs.length;
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label61;
        }
        if (isLocalFileUri(paramVarArgs[i]))
        {
          if (paramActivity.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) {
            break;
          }
          paramActivity.requestPermissions(new String[] { "android.permission.READ_EXTERNAL_STORAGE" }, 0);
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static ExecutorService newSingleThreadExecutor(String paramString)
  {
    return Executors.newSingleThreadExecutor(new Util.1(paramString));
  }
  
  public static String normalizeLanguageCode(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      String str = new Locale(paramString).getISO3Language();
      return str;
    }
    catch (MissingResourceException localMissingResourceException) {}
    return toLowerInvariant(paramString);
  }
  
  public static long parseXsDateTime(String paramString)
  {
    Matcher localMatcher = XS_DATE_TIME_PATTERN.matcher(paramString);
    if (!localMatcher.matches()) {
      throw new ParserException("Invalid date/time format: " + paramString);
    }
    int i;
    if (localMatcher.group(9) == null) {
      i = 0;
    }
    for (;;)
    {
      paramString = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
      paramString.clear();
      paramString.set(Integer.parseInt(localMatcher.group(1)), Integer.parseInt(localMatcher.group(2)) - 1, Integer.parseInt(localMatcher.group(3)), Integer.parseInt(localMatcher.group(4)), Integer.parseInt(localMatcher.group(5)), Integer.parseInt(localMatcher.group(6)));
      if (!TextUtils.isEmpty(localMatcher.group(8))) {
        paramString.set(14, new BigDecimal("0." + localMatcher.group(8)).movePointRight(3).intValue());
      }
      long l2 = paramString.getTimeInMillis();
      long l1 = l2;
      if (i != 0) {
        l1 = l2 - 60000 * i;
      }
      return l1;
      if (localMatcher.group(9).equalsIgnoreCase("Z"))
      {
        i = 0;
      }
      else
      {
        i = Integer.parseInt(localMatcher.group(12)) * 60 + Integer.parseInt(localMatcher.group(13));
        if (localMatcher.group(11).equals("-")) {
          i *= -1;
        }
      }
    }
  }
  
  public static long parseXsDuration(String paramString)
  {
    int i = 1;
    double d6 = 0.0D;
    Matcher localMatcher = XS_DURATION_PATTERN.matcher(paramString);
    if (localMatcher.matches())
    {
      double d1;
      label55:
      double d2;
      label75:
      double d3;
      label97:
      double d4;
      if (!TextUtils.isEmpty(localMatcher.group(1)))
      {
        paramString = localMatcher.group(3);
        if (paramString == null) {
          break label196;
        }
        d1 = Double.parseDouble(paramString) * 31556908.0D;
        paramString = localMatcher.group(5);
        if (paramString == null) {
          break label201;
        }
        d2 = Double.parseDouble(paramString) * 2629739.0D;
        paramString = localMatcher.group(7);
        if (paramString == null) {
          break label206;
        }
        d3 = Double.parseDouble(paramString) * 86400.0D;
        paramString = localMatcher.group(10);
        if (paramString == null) {
          break label212;
        }
        d4 = Double.parseDouble(paramString) * 3600.0D;
        label119:
        paramString = localMatcher.group(12);
        if (paramString == null) {
          break label218;
        }
      }
      long l;
      label196:
      label201:
      label206:
      label212:
      label218:
      for (double d5 = Double.parseDouble(paramString) * 60.0D;; d5 = 0.0D)
      {
        paramString = localMatcher.group(14);
        if (paramString != null) {
          d6 = Double.parseDouble(paramString);
        }
        l = ((d5 + (d2 + d1 + d3 + d4) + d6) * 1000.0D);
        if (i == 0) {
          break label224;
        }
        return -l;
        i = 0;
        break;
        d1 = 0.0D;
        break label55;
        d2 = 0.0D;
        break label75;
        d3 = 0.0D;
        break label97;
        d4 = 0.0D;
        break label119;
      }
      label224:
      return l;
    }
    return (Double.parseDouble(paramString) * 3600.0D * 1000.0D);
  }
  
  public static void recursiveDelete(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        recursiveDelete(arrayOfFile[i]);
        i += 1;
      }
    }
    paramFile.delete();
  }
  
  public static <T> void removeRange(List<T> paramList, int paramInt1, int paramInt2)
  {
    paramList.subList(paramInt1, paramInt2).clear();
  }
  
  public static long resolveSeekPositionUs(long paramLong1, SeekParameters paramSeekParameters, long paramLong2, long paramLong3)
  {
    long l1;
    if (SeekParameters.EXACT.equals(paramSeekParameters)) {
      l1 = paramLong1;
    }
    long l2;
    int i;
    label59:
    int j;
    label117:
    label123:
    do
    {
      return l1;
      l2 = subtractWithOverflowDefault(paramLong1, paramSeekParameters.toleranceBeforeUs, -9223372036854775808L);
      l1 = addWithOverflowDefault(paramLong1, paramSeekParameters.toleranceAfterUs, 9223372036854775807L);
      if ((l2 <= paramLong2) && (paramLong2 <= l1))
      {
        i = 1;
        if ((l2 > paramLong3) || (paramLong3 > l1)) {
          break label117;
        }
      }
      for (j = 1;; j = 0)
      {
        if ((i == 0) || (j == 0)) {
          break label123;
        }
        l1 = paramLong2;
        if (Math.abs(paramLong2 - paramLong1) <= Math.abs(paramLong3 - paramLong1)) {
          break;
        }
        return paramLong3;
        i = 0;
        break label59;
      }
      l1 = paramLong2;
    } while (i != 0);
    if (j != 0) {
      return paramLong3;
    }
    return l2;
  }
  
  public static long scaleLargeTimestamp(long paramLong1, long paramLong2, long paramLong3)
  {
    if ((paramLong3 >= paramLong2) && (paramLong3 % paramLong2 == 0L)) {
      return paramLong1 / (paramLong3 / paramLong2);
    }
    if ((paramLong3 < paramLong2) && (paramLong2 % paramLong3 == 0L)) {
      return paramLong2 / paramLong3 * paramLong1;
    }
    return (paramLong2 / paramLong3 * paramLong1);
  }
  
  public static long[] scaleLargeTimestamps(List<Long> paramList, long paramLong1, long paramLong2)
  {
    long[] arrayOfLong = new long[paramList.size()];
    int i;
    if ((paramLong2 >= paramLong1) && (paramLong2 % paramLong1 == 0L))
    {
      paramLong1 = paramLong2 / paramLong1;
      i = 0;
    }
    while (i < arrayOfLong.length)
    {
      arrayOfLong[i] = (((Long)paramList.get(i)).longValue() / paramLong1);
      i += 1;
      continue;
      if ((paramLong2 < paramLong1) && (paramLong1 % paramLong2 == 0L))
      {
        paramLong1 /= paramLong2;
        i = 0;
      }
      while (i < arrayOfLong.length)
      {
        arrayOfLong[i] = (((Long)paramList.get(i)).longValue() * paramLong1);
        i += 1;
        continue;
        double d = paramLong1 / paramLong2;
        i = 0;
        while (i < arrayOfLong.length)
        {
          arrayOfLong[i] = ((((Long)paramList.get(i)).longValue() * d));
          i += 1;
        }
      }
    }
    return arrayOfLong;
  }
  
  public static void scaleLargeTimestampsInPlace(long[] paramArrayOfLong, long paramLong1, long paramLong2)
  {
    int j = 0;
    int k = 0;
    int i = 0;
    if ((paramLong2 >= paramLong1) && (paramLong2 % paramLong1 == 0L)) {
      paramLong1 = paramLong2 / paramLong1;
    }
    while (i < paramArrayOfLong.length)
    {
      paramArrayOfLong[i] /= paramLong1;
      i += 1;
      continue;
      if ((paramLong2 < paramLong1) && (paramLong1 % paramLong2 == 0L))
      {
        paramLong1 /= paramLong2;
        i = j;
      }
      while (i < paramArrayOfLong.length)
      {
        paramArrayOfLong[i] *= paramLong1;
        i += 1;
        continue;
        double d = paramLong1 / paramLong2;
        i = k;
        while (i < paramArrayOfLong.length)
        {
          paramArrayOfLong[i] = ((paramArrayOfLong[i] * d));
          i += 1;
        }
      }
    }
  }
  
  private static boolean shouldEscapeCharacter(char paramChar)
  {
    switch (paramChar)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static void sneakyThrow(Throwable paramThrowable)
  {
    sneakyThrowInternal(paramThrowable);
  }
  
  private static <T extends Throwable> void sneakyThrowInternal(Throwable paramThrowable)
  {
    throw paramThrowable;
  }
  
  public static long subtractWithOverflowDefault(long paramLong1, long paramLong2, long paramLong3)
  {
    long l = paramLong1 - paramLong2;
    if (((paramLong1 ^ paramLong2) & (paramLong1 ^ l)) < 0L) {
      return paramLong3;
    }
    return l;
  }
  
  public static int[] toArray(List<Integer> paramList)
  {
    if (paramList == null) {
      return null;
    }
    int j = paramList.size();
    int[] arrayOfInt = new int[j];
    int i = 0;
    while (i < j)
    {
      arrayOfInt[i] = ((Integer)paramList.get(i)).intValue();
      i += 1;
    }
    return arrayOfInt;
  }
  
  public static byte[] toByteArray(InputStream paramInputStream)
  {
    byte[] arrayOfByte = new byte[4096];
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static String toLowerInvariant(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return paramString.toLowerCase(Locale.US);
  }
  
  public static String unescapeFileName(String paramString)
  {
    int m = paramString.length();
    int j = 0;
    for (int i = 0; j < m; i = k)
    {
      k = i;
      if (paramString.charAt(j) == '%') {
        k = i + 1;
      }
      j += 1;
    }
    if (i == 0) {
      return paramString;
    }
    int k = m - i * 2;
    StringBuilder localStringBuilder = new StringBuilder(k);
    Matcher localMatcher = ESCAPED_CHARACTER_PATTERN.matcher(paramString);
    j = 0;
    while ((i > 0) && (localMatcher.find()))
    {
      char c = (char)Integer.parseInt(localMatcher.group(1), 16);
      localStringBuilder.append(paramString, j, localMatcher.start()).append(c);
      j = localMatcher.end();
      i -= 1;
    }
    if (j < m) {
      localStringBuilder.append(paramString, j, m);
    }
    if (localStringBuilder.length() != k) {
      return null;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.util.Util
 * JD-Core Version:    0.7.0.1
 */