package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.Typeface.CustomFallbackBuilder;
import android.graphics.fonts.Font;
import android.graphics.fonts.Font.Builder;
import android.graphics.fonts.FontFamily.Builder;
import android.graphics.fonts.FontStyle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat.FontFileResourceEntry;
import androidx.core.provider.FontsContractCompat.FontInfo;
import java.io.IOException;
import java.io.InputStream;

@RequiresApi(29)
@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class TypefaceCompatApi29Impl
  extends TypefaceCompatBaseImpl
{
  @Nullable
  public Typeface createFromFontFamilyFilesResourceEntry(Context paramContext, FontResourcesParserCompat.FontFamilyFilesResourceEntry paramFontFamilyFilesResourceEntry, Resources paramResources, int paramInt)
  {
    FontResourcesParserCompat.FontFileResourceEntry[] arrayOfFontFileResourceEntry = paramFontFamilyFilesResourceEntry.getEntries();
    int m = arrayOfFontFileResourceEntry.length;
    int k = 0;
    paramContext = null;
    int i = 0;
    for (;;)
    {
      j = 1;
      if (i >= m) {
        break;
      }
      paramFontFamilyFilesResourceEntry = arrayOfFontFileResourceEntry[i];
      try
      {
        localBuilder = new Font.Builder(paramResources, paramFontFamilyFilesResourceEntry.getResourceId()).setWeight(paramFontFamilyFilesResourceEntry.getWeight());
        if (!paramFontFamilyFilesResourceEntry.isItalic()) {
          break label199;
        }
      }
      catch (IOException paramFontFamilyFilesResourceEntry)
      {
        for (;;)
        {
          Font.Builder localBuilder;
          continue;
          j = 0;
        }
      }
      paramFontFamilyFilesResourceEntry = localBuilder.setSlant(j).setTtcIndex(paramFontFamilyFilesResourceEntry.getTtcIndex()).setFontVariationSettings(paramFontFamilyFilesResourceEntry.getVariationSettings()).build();
      if (paramContext == null)
      {
        paramFontFamilyFilesResourceEntry = new FontFamily.Builder(paramFontFamilyFilesResourceEntry);
        paramContext = paramFontFamilyFilesResourceEntry;
      }
      else
      {
        paramContext.addFont(paramFontFamilyFilesResourceEntry);
      }
      i += 1;
    }
    if (paramContext == null) {
      return null;
    }
    if ((paramInt & 0x1) != 0) {
      i = 700;
    } else {
      i = 400;
    }
    j = k;
    if ((paramInt & 0x2) != 0) {
      j = 1;
    }
    paramFontFamilyFilesResourceEntry = new FontStyle(i, j);
    return new Typeface.CustomFallbackBuilder(paramContext.build()).setStyle(paramFontFamilyFilesResourceEntry).build();
  }
  
  /* Error */
  @Nullable
  public Typeface createFromFontInfo(Context paramContext, @Nullable android.os.CancellationSignal paramCancellationSignal, @androidx.annotation.NonNull FontsContractCompat.FontInfo[] paramArrayOfFontInfo, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 110	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore 11
    //   6: aload_3
    //   7: arraylength
    //   8: istore 8
    //   10: iconst_0
    //   11: istore 7
    //   13: aconst_null
    //   14: astore_1
    //   15: iconst_0
    //   16: istore 5
    //   18: iconst_1
    //   19: istore 6
    //   21: iload 5
    //   23: iload 8
    //   25: if_icmpge +191 -> 216
    //   28: aload_3
    //   29: iload 5
    //   31: aaload
    //   32: astore 10
    //   34: aload_1
    //   35: astore 9
    //   37: aload 11
    //   39: aload 10
    //   41: invokevirtual 116	androidx/core/provider/FontsContractCompat$FontInfo:getUri	()Landroid/net/Uri;
    //   44: ldc 118
    //   46: aload_2
    //   47: invokevirtual 124	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   50: astore 12
    //   52: aload 12
    //   54: ifnonnull +25 -> 79
    //   57: aload_1
    //   58: astore 9
    //   60: aload 12
    //   62: ifnull +142 -> 204
    //   65: aload_1
    //   66: astore 9
    //   68: aload 12
    //   70: invokevirtual 129	android/os/ParcelFileDescriptor:close	()V
    //   73: aload_1
    //   74: astore 9
    //   76: goto +128 -> 204
    //   79: aload_1
    //   80: astore 9
    //   82: new 28	android/graphics/fonts/Font$Builder
    //   85: dup
    //   86: aload 12
    //   88: invokespecial 132	android/graphics/fonts/Font$Builder:<init>	(Landroid/os/ParcelFileDescriptor;)V
    //   91: aload 10
    //   93: invokevirtual 133	androidx/core/provider/FontsContractCompat$FontInfo:getWeight	()I
    //   96: invokevirtual 44	android/graphics/fonts/Font$Builder:setWeight	(I)Landroid/graphics/fonts/Font$Builder;
    //   99: astore 13
    //   101: aload_1
    //   102: astore 9
    //   104: aload 10
    //   106: invokevirtual 134	androidx/core/provider/FontsContractCompat$FontInfo:isItalic	()Z
    //   109: ifeq +187 -> 296
    //   112: goto +3 -> 115
    //   115: aload_1
    //   116: astore 9
    //   118: aload 13
    //   120: iload 6
    //   122: invokevirtual 51	android/graphics/fonts/Font$Builder:setSlant	(I)Landroid/graphics/fonts/Font$Builder;
    //   125: aload 10
    //   127: invokevirtual 135	androidx/core/provider/FontsContractCompat$FontInfo:getTtcIndex	()I
    //   130: invokevirtual 57	android/graphics/fonts/Font$Builder:setTtcIndex	(I)Landroid/graphics/fonts/Font$Builder;
    //   133: invokevirtual 69	android/graphics/fonts/Font$Builder:build	()Landroid/graphics/fonts/Font;
    //   136: astore 10
    //   138: aload_1
    //   139: ifnonnull +23 -> 162
    //   142: aload_1
    //   143: astore 9
    //   145: new 71	android/graphics/fonts/FontFamily$Builder
    //   148: dup
    //   149: aload 10
    //   151: invokespecial 74	android/graphics/fonts/FontFamily$Builder:<init>	(Landroid/graphics/fonts/Font;)V
    //   154: astore 10
    //   156: aload 10
    //   158: astore_1
    //   159: goto +13 -> 172
    //   162: aload_1
    //   163: astore 9
    //   165: aload_1
    //   166: aload 10
    //   168: invokevirtual 78	android/graphics/fonts/FontFamily$Builder:addFont	(Landroid/graphics/fonts/Font;)Landroid/graphics/fonts/FontFamily$Builder;
    //   171: pop
    //   172: aload_1
    //   173: astore 9
    //   175: aload 12
    //   177: ifnull +27 -> 204
    //   180: goto -115 -> 65
    //   183: astore 10
    //   185: aload 12
    //   187: ifnull +11 -> 198
    //   190: aload_1
    //   191: astore 9
    //   193: aload 12
    //   195: invokevirtual 129	android/os/ParcelFileDescriptor:close	()V
    //   198: aload_1
    //   199: astore 9
    //   201: aload 10
    //   203: athrow
    //   204: iload 5
    //   206: iconst_1
    //   207: iadd
    //   208: istore 5
    //   210: aload 9
    //   212: astore_1
    //   213: goto -195 -> 18
    //   216: aload_1
    //   217: ifnonnull +5 -> 222
    //   220: aconst_null
    //   221: areturn
    //   222: iload 4
    //   224: iconst_1
    //   225: iand
    //   226: ifeq +11 -> 237
    //   229: sipush 700
    //   232: istore 5
    //   234: goto +8 -> 242
    //   237: sipush 400
    //   240: istore 5
    //   242: iload 7
    //   244: istore 6
    //   246: iload 4
    //   248: iconst_2
    //   249: iand
    //   250: ifeq +6 -> 256
    //   253: iconst_1
    //   254: istore 6
    //   256: new 80	android/graphics/fonts/FontStyle
    //   259: dup
    //   260: iload 5
    //   262: iload 6
    //   264: invokespecial 83	android/graphics/fonts/FontStyle:<init>	(II)V
    //   267: astore_2
    //   268: new 85	android/graphics/Typeface$CustomFallbackBuilder
    //   271: dup
    //   272: aload_1
    //   273: invokevirtual 88	android/graphics/fonts/FontFamily$Builder:build	()Landroid/graphics/fonts/FontFamily;
    //   276: invokespecial 91	android/graphics/Typeface$CustomFallbackBuilder:<init>	(Landroid/graphics/fonts/FontFamily;)V
    //   279: aload_2
    //   280: invokevirtual 95	android/graphics/Typeface$CustomFallbackBuilder:setStyle	(Landroid/graphics/fonts/FontStyle;)Landroid/graphics/Typeface$CustomFallbackBuilder;
    //   283: invokevirtual 98	android/graphics/Typeface$CustomFallbackBuilder:build	()Landroid/graphics/Typeface;
    //   286: areturn
    //   287: astore_1
    //   288: goto -84 -> 204
    //   291: astore 9
    //   293: goto -95 -> 198
    //   296: iconst_0
    //   297: istore 6
    //   299: goto -184 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	302	0	this	TypefaceCompatApi29Impl
    //   0	302	1	paramContext	Context
    //   0	302	2	paramCancellationSignal	android.os.CancellationSignal
    //   0	302	3	paramArrayOfFontInfo	FontsContractCompat.FontInfo[]
    //   0	302	4	paramInt	int
    //   16	245	5	i	int
    //   19	279	6	j	int
    //   11	232	7	k	int
    //   8	18	8	m	int
    //   35	176	9	localContext	Context
    //   291	1	9	localThrowable1	java.lang.Throwable
    //   32	135	10	localObject	java.lang.Object
    //   183	19	10	localThrowable2	java.lang.Throwable
    //   4	34	11	localContentResolver	android.content.ContentResolver
    //   50	144	12	localParcelFileDescriptor	android.os.ParcelFileDescriptor
    //   99	20	13	localBuilder	Font.Builder
    // Exception table:
    //   from	to	target	type
    //   82	101	183	java/lang/Throwable
    //   104	112	183	java/lang/Throwable
    //   118	138	183	java/lang/Throwable
    //   145	156	183	java/lang/Throwable
    //   165	172	183	java/lang/Throwable
    //   37	52	287	java/io/IOException
    //   68	73	287	java/io/IOException
    //   82	101	287	java/io/IOException
    //   104	112	287	java/io/IOException
    //   118	138	287	java/io/IOException
    //   145	156	287	java/io/IOException
    //   165	172	287	java/io/IOException
    //   193	198	287	java/io/IOException
    //   201	204	287	java/io/IOException
    //   193	198	291	java/lang/Throwable
  }
  
  protected Typeface createFromInputStream(Context paramContext, InputStream paramInputStream)
  {
    throw new RuntimeException("Do not use this function in API 29 or later.");
  }
  
  @Nullable
  public Typeface createFromResourcesFontFile(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2)
  {
    try
    {
      paramContext = new Font.Builder(paramResources, paramInt1).build();
      paramResources = new FontFamily.Builder(paramContext).build();
      return new Typeface.CustomFallbackBuilder(paramResources).setStyle(paramContext.getStyle()).build();
    }
    catch (IOException paramContext)
    {
      label44:
      break label44;
    }
    return null;
  }
  
  protected FontsContractCompat.FontInfo findBestInfo(FontsContractCompat.FontInfo[] paramArrayOfFontInfo, int paramInt)
  {
    throw new RuntimeException("Do not use this function in API 29 or later.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.graphics.TypefaceCompatApi29Impl
 * JD-Core Version:    0.7.0.1
 */