package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat.FontFileResourceEntry;
import androidx.core.provider.FontsContractCompat.FontInfo;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class TypefaceCompatBaseImpl
{
  private static final int INVALID_KEY = 0;
  private static final String TAG = "TypefaceCompatBaseImpl";
  private ConcurrentHashMap<Long, FontResourcesParserCompat.FontFamilyFilesResourceEntry> mFontFamilies = new ConcurrentHashMap();
  
  private void addFontFamily(Typeface paramTypeface, FontResourcesParserCompat.FontFamilyFilesResourceEntry paramFontFamilyFilesResourceEntry)
  {
    long l = getUniqueKey(paramTypeface);
    if (l != 0L) {
      this.mFontFamilies.put(Long.valueOf(l), paramFontFamilyFilesResourceEntry);
    }
  }
  
  private FontResourcesParserCompat.FontFileResourceEntry findBestEntry(FontResourcesParserCompat.FontFamilyFilesResourceEntry paramFontFamilyFilesResourceEntry, int paramInt)
  {
    return (FontResourcesParserCompat.FontFileResourceEntry)findBestFont(paramFontFamilyFilesResourceEntry.getEntries(), paramInt, new TypefaceCompatBaseImpl.2(this));
  }
  
  private static <T> T findBestFont(T[] paramArrayOfT, int paramInt, TypefaceCompatBaseImpl.StyleExtractor<T> paramStyleExtractor)
  {
    int i;
    if ((paramInt & 0x1) == 0) {
      i = 400;
    } else {
      i = 700;
    }
    int i1;
    if ((paramInt & 0x2) != 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int n = paramArrayOfT.length;
    Object localObject = null;
    paramInt = 0;
    int k;
    for (int j = 2147483647; paramInt < n; j = k)
    {
      T ? = paramArrayOfT[paramInt];
      int m = Math.abs(paramStyleExtractor.getWeight(?) - i);
      if (paramStyleExtractor.isItalic(?) == i1) {
        k = 0;
      } else {
        k = 1;
      }
      m = m * 2 + k;
      if (localObject != null)
      {
        k = j;
        if (j <= m) {}
      }
      else
      {
        localObject = ?;
        k = m;
      }
      paramInt += 1;
    }
    return localObject;
  }
  
  private static long getUniqueKey(@Nullable Typeface paramTypeface)
  {
    if (paramTypeface == null) {
      return 0L;
    }
    try
    {
      Field localField = Typeface.class.getDeclaredField("native_instance");
      localField.setAccessible(true);
      long l = ((Number)localField.get(paramTypeface)).longValue();
      return l;
    }
    catch (IllegalAccessException paramTypeface)
    {
      Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", paramTypeface);
      return 0L;
    }
    catch (NoSuchFieldException paramTypeface)
    {
      Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", paramTypeface);
    }
    return 0L;
  }
  
  @Nullable
  public Typeface createFromFontFamilyFilesResourceEntry(Context paramContext, FontResourcesParserCompat.FontFamilyFilesResourceEntry paramFontFamilyFilesResourceEntry, Resources paramResources, int paramInt)
  {
    FontResourcesParserCompat.FontFileResourceEntry localFontFileResourceEntry = findBestEntry(paramFontFamilyFilesResourceEntry, paramInt);
    if (localFontFileResourceEntry == null) {
      return null;
    }
    paramContext = TypefaceCompat.createFromResourcesFontFile(paramContext, paramResources, localFontFileResourceEntry.getResourceId(), localFontFileResourceEntry.getFileName(), paramInt);
    addFontFamily(paramContext, paramFontFamilyFilesResourceEntry);
    return paramContext;
  }
  
  /* Error */
  @Nullable
  public Typeface createFromFontInfo(Context paramContext, @Nullable android.os.CancellationSignal paramCancellationSignal, @androidx.annotation.NonNull FontsContractCompat.FontInfo[] paramArrayOfFontInfo, int paramInt)
  {
    // Byte code:
    //   0: aload_3
    //   1: arraylength
    //   2: istore 5
    //   4: aconst_null
    //   5: astore 6
    //   7: iload 5
    //   9: iconst_1
    //   10: if_icmpge +5 -> 15
    //   13: aconst_null
    //   14: areturn
    //   15: aload_0
    //   16: aload_3
    //   17: iload 4
    //   19: invokevirtual 152	androidx/core/graphics/TypefaceCompatBaseImpl:findBestInfo	([Landroidx/core/provider/FontsContractCompat$FontInfo;I)Landroidx/core/provider/FontsContractCompat$FontInfo;
    //   22: astore_2
    //   23: aload_1
    //   24: invokevirtual 158	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   27: aload_2
    //   28: invokevirtual 164	androidx/core/provider/FontsContractCompat$FontInfo:getUri	()Landroid/net/Uri;
    //   31: invokevirtual 170	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   34: astore_2
    //   35: aload_0
    //   36: aload_1
    //   37: aload_2
    //   38: invokevirtual 174	androidx/core/graphics/TypefaceCompatBaseImpl:createFromInputStream	(Landroid/content/Context;Ljava/io/InputStream;)Landroid/graphics/Typeface;
    //   41: astore_1
    //   42: aload_2
    //   43: invokestatic 180	androidx/core/graphics/TypefaceCompatUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   46: aload_1
    //   47: areturn
    //   48: astore_3
    //   49: aload_2
    //   50: astore_1
    //   51: aload_3
    //   52: astore_2
    //   53: goto +7 -> 60
    //   56: astore_2
    //   57: aload 6
    //   59: astore_1
    //   60: aload_1
    //   61: invokestatic 180	androidx/core/graphics/TypefaceCompatUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   64: aload_2
    //   65: athrow
    //   66: aconst_null
    //   67: astore_2
    //   68: aload_2
    //   69: invokestatic 180	androidx/core/graphics/TypefaceCompatUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   72: aconst_null
    //   73: areturn
    //   74: astore_1
    //   75: goto -9 -> 66
    //   78: astore_1
    //   79: goto -11 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	TypefaceCompatBaseImpl
    //   0	82	1	paramContext	Context
    //   0	82	2	paramCancellationSignal	android.os.CancellationSignal
    //   0	82	3	paramArrayOfFontInfo	FontsContractCompat.FontInfo[]
    //   0	82	4	paramInt	int
    //   2	9	5	i	int
    //   5	53	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   35	42	48	finally
    //   23	35	56	finally
    //   23	35	74	java/io/IOException
    //   35	42	78	java/io/IOException
  }
  
  /* Error */
  protected Typeface createFromInputStream(Context paramContext, java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 186	androidx/core/graphics/TypefaceCompatUtil:getTempFile	(Landroid/content/Context;)Ljava/io/File;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnonnull +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: aload_1
    //   12: aload_2
    //   13: invokestatic 190	androidx/core/graphics/TypefaceCompatUtil:copyToFile	(Ljava/io/File;Ljava/io/InputStream;)Z
    //   16: istore_3
    //   17: iload_3
    //   18: ifne +10 -> 28
    //   21: aload_1
    //   22: invokevirtual 196	java/io/File:delete	()Z
    //   25: pop
    //   26: aconst_null
    //   27: areturn
    //   28: aload_1
    //   29: invokevirtual 199	java/io/File:getPath	()Ljava/lang/String;
    //   32: invokestatic 203	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   35: astore_2
    //   36: aload_1
    //   37: invokevirtual 196	java/io/File:delete	()Z
    //   40: pop
    //   41: aload_2
    //   42: areturn
    //   43: astore_2
    //   44: aload_1
    //   45: invokevirtual 196	java/io/File:delete	()Z
    //   48: pop
    //   49: aload_2
    //   50: athrow
    //   51: aload_1
    //   52: invokevirtual 196	java/io/File:delete	()Z
    //   55: pop
    //   56: aconst_null
    //   57: areturn
    //   58: astore_2
    //   59: goto -8 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	TypefaceCompatBaseImpl
    //   0	62	1	paramContext	Context
    //   0	62	2	paramInputStream	java.io.InputStream
    //   16	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   11	17	43	finally
    //   28	36	43	finally
    //   11	17	58	java/lang/RuntimeException
    //   28	36	58	java/lang/RuntimeException
  }
  
  /* Error */
  @Nullable
  public Typeface createFromResourcesFontFile(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 186	androidx/core/graphics/TypefaceCompatUtil:getTempFile	(Landroid/content/Context;)Ljava/io/File;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnonnull +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: aload_1
    //   12: aload_2
    //   13: iload_3
    //   14: invokestatic 206	androidx/core/graphics/TypefaceCompatUtil:copyToFile	(Ljava/io/File;Landroid/content/res/Resources;I)Z
    //   17: istore 6
    //   19: iload 6
    //   21: ifne +10 -> 31
    //   24: aload_1
    //   25: invokevirtual 196	java/io/File:delete	()Z
    //   28: pop
    //   29: aconst_null
    //   30: areturn
    //   31: aload_1
    //   32: invokevirtual 199	java/io/File:getPath	()Ljava/lang/String;
    //   35: invokestatic 203	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   38: astore_2
    //   39: aload_1
    //   40: invokevirtual 196	java/io/File:delete	()Z
    //   43: pop
    //   44: aload_2
    //   45: areturn
    //   46: astore_2
    //   47: aload_1
    //   48: invokevirtual 196	java/io/File:delete	()Z
    //   51: pop
    //   52: aload_2
    //   53: athrow
    //   54: aload_1
    //   55: invokevirtual 196	java/io/File:delete	()Z
    //   58: pop
    //   59: aconst_null
    //   60: areturn
    //   61: astore_2
    //   62: goto -8 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	TypefaceCompatBaseImpl
    //   0	65	1	paramContext	Context
    //   0	65	2	paramResources	Resources
    //   0	65	3	paramInt1	int
    //   0	65	4	paramString	String
    //   0	65	5	paramInt2	int
    //   17	3	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   11	19	46	finally
    //   31	39	46	finally
    //   11	19	61	java/lang/RuntimeException
    //   31	39	61	java/lang/RuntimeException
  }
  
  protected FontsContractCompat.FontInfo findBestInfo(FontsContractCompat.FontInfo[] paramArrayOfFontInfo, int paramInt)
  {
    return (FontsContractCompat.FontInfo)findBestFont(paramArrayOfFontInfo, paramInt, new TypefaceCompatBaseImpl.1(this));
  }
  
  @Nullable
  FontResourcesParserCompat.FontFamilyFilesResourceEntry getFontFamily(Typeface paramTypeface)
  {
    long l = getUniqueKey(paramTypeface);
    if (l == 0L) {
      return null;
    }
    return (FontResourcesParserCompat.FontFamilyFilesResourceEntry)this.mFontFamilies.get(Long.valueOf(l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.graphics.TypefaceCompatBaseImpl
 * JD-Core Version:    0.7.0.1
 */