package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.Typeface.CustomFallbackBuilder;
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
    int k = arrayOfFontFileResourceEntry.length;
    int i = 0;
    paramContext = null;
    if (i < k) {
      paramFontFamilyFilesResourceEntry = arrayOfFontFileResourceEntry[i];
    }
    for (;;)
    {
      try
      {
        Font.Builder localBuilder = new Font.Builder(paramResources, paramFontFamilyFilesResourceEntry.getResourceId()).setWeight(paramFontFamilyFilesResourceEntry.getWeight());
        if (!paramFontFamilyFilesResourceEntry.isItalic()) {
          break label198;
        }
        j = 1;
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
      }
      catch (IOException paramFontFamilyFilesResourceEntry) {}
      if (paramContext == null) {
        return null;
      }
      if ((paramInt & 0x1) != 0)
      {
        i = 700;
        if ((paramInt & 0x2) == 0) {
          break label183;
        }
      }
      label183:
      for (paramInt = 1;; paramInt = 0)
      {
        paramFontFamilyFilesResourceEntry = new FontStyle(i, paramInt);
        return new Typeface.CustomFallbackBuilder(paramContext.build()).setStyle(paramFontFamilyFilesResourceEntry).build();
        i = 400;
        break;
      }
      i += 1;
      break;
      label198:
      int j = 0;
    }
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
    //   8: istore 7
    //   10: iconst_0
    //   11: istore 5
    //   13: aconst_null
    //   14: astore_1
    //   15: iload 5
    //   17: iload 7
    //   19: if_icmpge +291 -> 310
    //   22: aload_3
    //   23: iload 5
    //   25: aaload
    //   26: astore 10
    //   28: aload_1
    //   29: astore 8
    //   31: aload 11
    //   33: aload 10
    //   35: invokevirtual 116	androidx/core/provider/FontsContractCompat$FontInfo:getUri	()Landroid/net/Uri;
    //   38: ldc 118
    //   40: aload_2
    //   41: invokevirtual 124	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   44: astore 12
    //   46: aconst_null
    //   47: astore 9
    //   49: aload 12
    //   51: ifnonnull +65 -> 116
    //   54: aload_1
    //   55: astore 8
    //   57: aload 12
    //   59: ifnull +18 -> 77
    //   62: iconst_0
    //   63: ifeq +39 -> 102
    //   66: aload_1
    //   67: astore 8
    //   69: aload 12
    //   71: invokevirtual 129	android/os/ParcelFileDescriptor:close	()V
    //   74: aload_1
    //   75: astore 8
    //   77: iload 5
    //   79: iconst_1
    //   80: iadd
    //   81: istore 5
    //   83: aload 8
    //   85: astore_1
    //   86: goto -71 -> 15
    //   89: astore 8
    //   91: aload_1
    //   92: astore 8
    //   94: new 131	java/lang/NullPointerException
    //   97: dup
    //   98: invokespecial 132	java/lang/NullPointerException:<init>	()V
    //   101: athrow
    //   102: aload_1
    //   103: astore 8
    //   105: aload 12
    //   107: invokevirtual 129	android/os/ParcelFileDescriptor:close	()V
    //   110: aload_1
    //   111: astore 8
    //   113: goto -36 -> 77
    //   116: new 28	android/graphics/fonts/Font$Builder
    //   119: dup
    //   120: aload 12
    //   122: invokespecial 135	android/graphics/fonts/Font$Builder:<init>	(Landroid/os/ParcelFileDescriptor;)V
    //   125: aload 10
    //   127: invokevirtual 136	androidx/core/provider/FontsContractCompat$FontInfo:getWeight	()I
    //   130: invokevirtual 44	android/graphics/fonts/Font$Builder:setWeight	(I)Landroid/graphics/fonts/Font$Builder;
    //   133: astore 8
    //   135: aload 10
    //   137: invokevirtual 137	androidx/core/provider/FontsContractCompat$FontInfo:isItalic	()Z
    //   140: ifeq +83 -> 223
    //   143: iconst_1
    //   144: istore 6
    //   146: aload 8
    //   148: iload 6
    //   150: invokevirtual 51	android/graphics/fonts/Font$Builder:setSlant	(I)Landroid/graphics/fonts/Font$Builder;
    //   153: aload 10
    //   155: invokevirtual 138	androidx/core/provider/FontsContractCompat$FontInfo:getTtcIndex	()I
    //   158: invokevirtual 57	android/graphics/fonts/Font$Builder:setTtcIndex	(I)Landroid/graphics/fonts/Font$Builder;
    //   161: invokevirtual 69	android/graphics/fonts/Font$Builder:build	()Landroid/graphics/fonts/Font;
    //   164: astore 8
    //   166: aload_1
    //   167: ifnonnull +62 -> 229
    //   170: new 71	android/graphics/fonts/FontFamily$Builder
    //   173: dup
    //   174: aload 8
    //   176: invokespecial 74	android/graphics/fonts/FontFamily$Builder:<init>	(Landroid/graphics/fonts/Font;)V
    //   179: astore 8
    //   181: aload 8
    //   183: astore_1
    //   184: aload_1
    //   185: astore 8
    //   187: aload 12
    //   189: ifnull -112 -> 77
    //   192: iconst_0
    //   193: ifeq +77 -> 270
    //   196: aload_1
    //   197: astore 8
    //   199: aload 12
    //   201: invokevirtual 129	android/os/ParcelFileDescriptor:close	()V
    //   204: aload_1
    //   205: astore 8
    //   207: goto -130 -> 77
    //   210: astore 8
    //   212: aload_1
    //   213: astore 8
    //   215: new 131	java/lang/NullPointerException
    //   218: dup
    //   219: invokespecial 132	java/lang/NullPointerException:<init>	()V
    //   222: athrow
    //   223: iconst_0
    //   224: istore 6
    //   226: goto -80 -> 146
    //   229: aload_1
    //   230: aload 8
    //   232: invokevirtual 78	android/graphics/fonts/FontFamily$Builder:addFont	(Landroid/graphics/fonts/Font;)Landroid/graphics/fonts/FontFamily$Builder;
    //   235: pop
    //   236: goto -52 -> 184
    //   239: astore 9
    //   241: aload 9
    //   243: athrow
    //   244: astore 10
    //   246: aload 12
    //   248: ifnull +16 -> 264
    //   251: aload 9
    //   253: ifnull +46 -> 299
    //   256: aload_1
    //   257: astore 8
    //   259: aload 12
    //   261: invokevirtual 129	android/os/ParcelFileDescriptor:close	()V
    //   264: aload_1
    //   265: astore 8
    //   267: aload 10
    //   269: athrow
    //   270: aload_1
    //   271: astore 8
    //   273: aload 12
    //   275: invokevirtual 129	android/os/ParcelFileDescriptor:close	()V
    //   278: aload_1
    //   279: astore 8
    //   281: goto -204 -> 77
    //   284: astore 12
    //   286: aload_1
    //   287: astore 8
    //   289: aload 9
    //   291: aload 12
    //   293: invokevirtual 142	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   296: goto -32 -> 264
    //   299: aload_1
    //   300: astore 8
    //   302: aload 12
    //   304: invokevirtual 129	android/os/ParcelFileDescriptor:close	()V
    //   307: goto -43 -> 264
    //   310: aload_1
    //   311: ifnonnull +5 -> 316
    //   314: aconst_null
    //   315: areturn
    //   316: iload 4
    //   318: iconst_1
    //   319: iand
    //   320: ifeq +49 -> 369
    //   323: sipush 700
    //   326: istore 5
    //   328: iload 4
    //   330: iconst_2
    //   331: iand
    //   332: ifeq +45 -> 377
    //   335: iconst_1
    //   336: istore 4
    //   338: new 80	android/graphics/fonts/FontStyle
    //   341: dup
    //   342: iload 5
    //   344: iload 4
    //   346: invokespecial 83	android/graphics/fonts/FontStyle:<init>	(II)V
    //   349: astore_2
    //   350: new 85	android/graphics/Typeface$CustomFallbackBuilder
    //   353: dup
    //   354: aload_1
    //   355: invokevirtual 88	android/graphics/fonts/FontFamily$Builder:build	()Landroid/graphics/fonts/FontFamily;
    //   358: invokespecial 91	android/graphics/Typeface$CustomFallbackBuilder:<init>	(Landroid/graphics/fonts/FontFamily;)V
    //   361: aload_2
    //   362: invokevirtual 95	android/graphics/Typeface$CustomFallbackBuilder:setStyle	(Landroid/graphics/fonts/FontStyle;)Landroid/graphics/Typeface$CustomFallbackBuilder;
    //   365: invokevirtual 98	android/graphics/Typeface$CustomFallbackBuilder:build	()Landroid/graphics/Typeface;
    //   368: areturn
    //   369: sipush 400
    //   372: istore 5
    //   374: goto -46 -> 328
    //   377: iconst_0
    //   378: istore 4
    //   380: goto -42 -> 338
    //   383: astore 10
    //   385: goto -139 -> 246
    //   388: astore_1
    //   389: goto -312 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	392	0	this	TypefaceCompatApi29Impl
    //   0	392	1	paramContext	Context
    //   0	392	2	paramCancellationSignal	android.os.CancellationSignal
    //   0	392	3	paramArrayOfFontInfo	FontsContractCompat.FontInfo[]
    //   0	392	4	paramInt	int
    //   11	362	5	i	int
    //   144	81	6	j	int
    //   8	12	7	k	int
    //   29	55	8	localContext1	Context
    //   89	1	8	localThrowable1	java.lang.Throwable
    //   92	114	8	localObject1	java.lang.Object
    //   210	1	8	localThrowable2	java.lang.Throwable
    //   213	88	8	localContext2	Context
    //   47	1	9	localObject2	java.lang.Object
    //   239	51	9	localThrowable3	java.lang.Throwable
    //   26	128	10	localFontInfo	FontsContractCompat.FontInfo
    //   244	24	10	localObject3	java.lang.Object
    //   383	1	10	localObject4	java.lang.Object
    //   4	28	11	localContentResolver	android.content.ContentResolver
    //   44	230	12	localParcelFileDescriptor	android.os.ParcelFileDescriptor
    //   284	19	12	localThrowable4	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   69	74	89	java/lang/Throwable
    //   199	204	210	java/lang/Throwable
    //   116	143	239	java/lang/Throwable
    //   146	166	239	java/lang/Throwable
    //   170	181	239	java/lang/Throwable
    //   229	236	239	java/lang/Throwable
    //   241	244	244	finally
    //   259	264	284	java/lang/Throwable
    //   116	143	383	finally
    //   146	166	383	finally
    //   170	181	383	finally
    //   229	236	383	finally
    //   31	46	388	java/io/IOException
    //   69	74	388	java/io/IOException
    //   94	102	388	java/io/IOException
    //   105	110	388	java/io/IOException
    //   199	204	388	java/io/IOException
    //   215	223	388	java/io/IOException
    //   259	264	388	java/io/IOException
    //   267	270	388	java/io/IOException
    //   273	278	388	java/io/IOException
    //   289	296	388	java/io/IOException
    //   302	307	388	java/io/IOException
  }
  
  protected Typeface createFromInputStream(Context paramContext, InputStream paramInputStream)
  {
    throw new RuntimeException("Do not use this function in API 29 or later.");
  }
  
  @Nullable
  public Typeface createFromResourcesFontFile(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2)
  {
    for (;;)
    {
      try
      {
        paramContext = new FontFamily.Builder(new Font.Builder(paramResources, paramInt1).build()).build();
        if ((paramInt2 & 0x1) != 0)
        {
          paramInt1 = 700;
          if ((paramInt2 & 0x2) == 0) {
            break label81;
          }
          paramInt2 = 1;
          paramResources = new FontStyle(paramInt1, paramInt2);
          return new Typeface.CustomFallbackBuilder(paramContext).setStyle(paramResources).build();
        }
      }
      catch (IOException paramContext)
      {
        return null;
      }
      paramInt1 = 400;
      continue;
      label81:
      paramInt2 = 0;
    }
  }
  
  protected FontsContractCompat.FontInfo findBestInfo(FontsContractCompat.FontInfo[] paramArrayOfFontInfo, int paramInt)
  {
    throw new RuntimeException("Do not use this function in API 29 or later.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.graphics.TypefaceCompatApi29Impl
 * JD-Core Version:    0.7.0.1
 */