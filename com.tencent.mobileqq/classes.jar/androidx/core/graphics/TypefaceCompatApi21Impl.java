package androidx.core.graphics;

import android.graphics.Typeface;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RequiresApi(21)
@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class TypefaceCompatApi21Impl
  extends TypefaceCompatBaseImpl
{
  private static final String ADD_FONT_WEIGHT_STYLE_METHOD = "addFontWeightStyle";
  private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
  private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
  private static final String TAG = "TypefaceCompatApi21Impl";
  private static Method sAddFontWeightStyle;
  private static Method sCreateFromFamiliesWithDefault;
  private static Class<?> sFontFamily;
  private static Constructor<?> sFontFamilyCtor;
  private static boolean sHasInitBeenCalled = false;
  
  private static boolean addFontWeightStyle(Object paramObject, String paramString, int paramInt, boolean paramBoolean)
  {
    
    try
    {
      paramBoolean = ((Boolean)sAddFontWeightStyle.invoke(paramObject, new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) })).booleanValue();
      return paramBoolean;
    }
    catch (InvocationTargetException paramObject) {}catch (IllegalAccessException paramObject) {}
    throw new RuntimeException(paramObject);
  }
  
  private static Typeface createFromFamiliesWithDefault(Object paramObject)
  {
    
    try
    {
      Object localObject = Array.newInstance(sFontFamily, 1);
      Array.set(localObject, 0, paramObject);
      paramObject = (Typeface)sCreateFromFamiliesWithDefault.invoke(null, new Object[] { localObject });
      return paramObject;
    }
    catch (InvocationTargetException paramObject) {}catch (IllegalAccessException paramObject) {}
    throw new RuntimeException(paramObject);
  }
  
  private File getFile(@NonNull ParcelFileDescriptor paramParcelFileDescriptor)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("/proc/self/fd/");
      localStringBuilder.append(paramParcelFileDescriptor.getFd());
      paramParcelFileDescriptor = Os.readlink(localStringBuilder.toString());
      if (OsConstants.S_ISREG(Os.stat(paramParcelFileDescriptor).st_mode))
      {
        paramParcelFileDescriptor = new File(paramParcelFileDescriptor);
        return paramParcelFileDescriptor;
      }
      return null;
    }
    catch (ErrnoException paramParcelFileDescriptor) {}
    return null;
  }
  
  private static void init()
  {
    if (sHasInitBeenCalled) {
      return;
    }
    sHasInitBeenCalled = true;
    Object localObject4 = null;
    try
    {
      localObject2 = Class.forName("android.graphics.FontFamily");
      Constructor localConstructor = ((Class)localObject2).getConstructor(new Class[0]);
      localObject3 = ((Class)localObject2).getMethod("addFontWeightStyle", new Class[] { String.class, Integer.TYPE, Boolean.TYPE });
      localMethod = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[] { Array.newInstance((Class)localObject2, 1).getClass() });
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}catch (ClassNotFoundException localClassNotFoundException) {}
    Log.e("TypefaceCompatApi21Impl", localClassNotFoundException.getClass().getName(), localClassNotFoundException);
    Method localMethod = null;
    Object localObject1 = localMethod;
    Object localObject3 = localObject1;
    Object localObject2 = localObject1;
    localObject1 = localObject4;
    sFontFamilyCtor = localObject1;
    sFontFamily = (Class)localObject2;
    sAddFontWeightStyle = (Method)localObject3;
    sCreateFromFamiliesWithDefault = localMethod;
  }
  
  private static Object newFamily()
  {
    
    try
    {
      Object localObject = sFontFamilyCtor.newInstance(new Object[0]);
      return localObject;
    }
    catch (InvocationTargetException localInvocationTargetException) {}catch (InstantiationException localInstantiationException) {}catch (IllegalAccessException localIllegalAccessException) {}
    throw new RuntimeException(localIllegalAccessException);
  }
  
  /* Error */
  public Typeface createFromFontFamilyFilesResourceEntry(android.content.Context paramContext, androidx.core.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry paramFontFamilyFilesResourceEntry, android.content.res.Resources paramResources, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 205	androidx/core/graphics/TypefaceCompatApi21Impl:newFamily	()Ljava/lang/Object;
    //   3: astore 7
    //   5: aload_2
    //   6: invokevirtual 211	androidx/core/content/res/FontResourcesParserCompat$FontFamilyFilesResourceEntry:getEntries	()[Landroidx/core/content/res/FontResourcesParserCompat$FontFileResourceEntry;
    //   9: astore 8
    //   11: aload 8
    //   13: arraylength
    //   14: istore 5
    //   16: iconst_0
    //   17: istore 4
    //   19: iload 4
    //   21: iload 5
    //   23: if_icmpge +107 -> 130
    //   26: aload 8
    //   28: iload 4
    //   30: aaload
    //   31: astore 9
    //   33: aload_1
    //   34: invokestatic 217	androidx/core/graphics/TypefaceCompatUtil:getTempFile	(Landroid/content/Context;)Ljava/io/File;
    //   37: astore_2
    //   38: aload_2
    //   39: ifnonnull +5 -> 44
    //   42: aconst_null
    //   43: areturn
    //   44: aload_2
    //   45: aload_3
    //   46: aload 9
    //   48: invokevirtual 222	androidx/core/content/res/FontResourcesParserCompat$FontFileResourceEntry:getResourceId	()I
    //   51: invokestatic 226	androidx/core/graphics/TypefaceCompatUtil:copyToFile	(Ljava/io/File;Landroid/content/res/Resources;I)Z
    //   54: istore 6
    //   56: iload 6
    //   58: ifne +10 -> 68
    //   61: aload_2
    //   62: invokevirtual 229	java/io/File:delete	()Z
    //   65: pop
    //   66: aconst_null
    //   67: areturn
    //   68: aload 7
    //   70: aload_2
    //   71: invokevirtual 232	java/io/File:getPath	()Ljava/lang/String;
    //   74: aload 9
    //   76: invokevirtual 235	androidx/core/content/res/FontResourcesParserCompat$FontFileResourceEntry:getWeight	()I
    //   79: aload 9
    //   81: invokevirtual 238	androidx/core/content/res/FontResourcesParserCompat$FontFileResourceEntry:isItalic	()Z
    //   84: invokestatic 240	androidx/core/graphics/TypefaceCompatApi21Impl:addFontWeightStyle	(Ljava/lang/Object;Ljava/lang/String;IZ)Z
    //   87: istore 6
    //   89: iload 6
    //   91: ifne +10 -> 101
    //   94: aload_2
    //   95: invokevirtual 229	java/io/File:delete	()Z
    //   98: pop
    //   99: aconst_null
    //   100: areturn
    //   101: aload_2
    //   102: invokevirtual 229	java/io/File:delete	()Z
    //   105: pop
    //   106: iload 4
    //   108: iconst_1
    //   109: iadd
    //   110: istore 4
    //   112: goto -93 -> 19
    //   115: astore_1
    //   116: aload_2
    //   117: invokevirtual 229	java/io/File:delete	()Z
    //   120: pop
    //   121: aload_1
    //   122: athrow
    //   123: aload_2
    //   124: invokevirtual 229	java/io/File:delete	()Z
    //   127: pop
    //   128: aconst_null
    //   129: areturn
    //   130: aload 7
    //   132: invokestatic 242	androidx/core/graphics/TypefaceCompatApi21Impl:createFromFamiliesWithDefault	(Ljava/lang/Object;)Landroid/graphics/Typeface;
    //   135: areturn
    //   136: astore_1
    //   137: goto -14 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	TypefaceCompatApi21Impl
    //   0	140	1	paramContext	android.content.Context
    //   0	140	2	paramFontFamilyFilesResourceEntry	androidx.core.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry
    //   0	140	3	paramResources	android.content.res.Resources
    //   0	140	4	paramInt	int
    //   14	10	5	i	int
    //   54	36	6	bool	boolean
    //   3	128	7	localObject	Object
    //   9	18	8	arrayOfFontFileResourceEntry	androidx.core.content.res.FontResourcesParserCompat.FontFileResourceEntry[]
    //   31	49	9	localFontFileResourceEntry	androidx.core.content.res.FontResourcesParserCompat.FontFileResourceEntry
    // Exception table:
    //   from	to	target	type
    //   44	56	115	finally
    //   68	89	115	finally
    //   44	56	136	java/lang/RuntimeException
    //   68	89	136	java/lang/RuntimeException
  }
  
  /* Error */
  public Typeface createFromFontInfo(android.content.Context paramContext, android.os.CancellationSignal paramCancellationSignal, @NonNull androidx.core.provider.FontsContractCompat.FontInfo[] paramArrayOfFontInfo, int paramInt)
  {
    // Byte code:
    //   0: aload_3
    //   1: arraylength
    //   2: iconst_1
    //   3: if_icmpge +5 -> 8
    //   6: aconst_null
    //   7: areturn
    //   8: aload_0
    //   9: aload_3
    //   10: iload 4
    //   12: invokevirtual 252	androidx/core/graphics/TypefaceCompatApi21Impl:findBestInfo	([Landroidx/core/provider/FontsContractCompat$FontInfo;I)Landroidx/core/provider/FontsContractCompat$FontInfo;
    //   15: astore_3
    //   16: aload_1
    //   17: invokevirtual 258	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   20: astore 5
    //   22: aload 5
    //   24: aload_3
    //   25: invokevirtual 264	androidx/core/provider/FontsContractCompat$FontInfo:getUri	()Landroid/net/Uri;
    //   28: ldc_w 266
    //   31: aload_2
    //   32: invokevirtual 272	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   35: astore_2
    //   36: aload_2
    //   37: ifnonnull +13 -> 50
    //   40: aload_2
    //   41: ifnull +7 -> 48
    //   44: aload_2
    //   45: invokevirtual 275	android/os/ParcelFileDescriptor:close	()V
    //   48: aconst_null
    //   49: areturn
    //   50: aload_0
    //   51: aload_2
    //   52: invokespecial 277	androidx/core/graphics/TypefaceCompatApi21Impl:getFile	(Landroid/os/ParcelFileDescriptor;)Ljava/io/File;
    //   55: astore_3
    //   56: aload_3
    //   57: ifnull +28 -> 85
    //   60: aload_3
    //   61: invokevirtual 280	java/io/File:canRead	()Z
    //   64: ifne +6 -> 70
    //   67: goto +18 -> 85
    //   70: aload_3
    //   71: invokestatic 284	android/graphics/Typeface:createFromFile	(Ljava/io/File;)Landroid/graphics/Typeface;
    //   74: astore_1
    //   75: aload_2
    //   76: ifnull +7 -> 83
    //   79: aload_2
    //   80: invokevirtual 275	android/os/ParcelFileDescriptor:close	()V
    //   83: aload_1
    //   84: areturn
    //   85: new 286	java/io/FileInputStream
    //   88: dup
    //   89: aload_2
    //   90: invokevirtual 290	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   93: invokespecial 293	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   96: astore_3
    //   97: aload_0
    //   98: aload_1
    //   99: aload_3
    //   100: invokespecial 297	androidx/core/graphics/TypefaceCompatBaseImpl:createFromInputStream	(Landroid/content/Context;Ljava/io/InputStream;)Landroid/graphics/Typeface;
    //   103: astore_1
    //   104: aload_3
    //   105: invokevirtual 298	java/io/FileInputStream:close	()V
    //   108: aload_2
    //   109: ifnull +7 -> 116
    //   112: aload_2
    //   113: invokevirtual 275	android/os/ParcelFileDescriptor:close	()V
    //   116: aload_1
    //   117: areturn
    //   118: astore_1
    //   119: aload_3
    //   120: invokevirtual 298	java/io/FileInputStream:close	()V
    //   123: aload_1
    //   124: athrow
    //   125: astore_1
    //   126: aload_2
    //   127: ifnull +7 -> 134
    //   130: aload_2
    //   131: invokevirtual 275	android/os/ParcelFileDescriptor:close	()V
    //   134: aload_1
    //   135: athrow
    //   136: astore_1
    //   137: aconst_null
    //   138: areturn
    //   139: astore_3
    //   140: goto -17 -> 123
    //   143: astore_2
    //   144: goto -10 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	TypefaceCompatApi21Impl
    //   0	147	1	paramContext	android.content.Context
    //   0	147	2	paramCancellationSignal	android.os.CancellationSignal
    //   0	147	3	paramArrayOfFontInfo	androidx.core.provider.FontsContractCompat.FontInfo[]
    //   0	147	4	paramInt	int
    //   20	3	5	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   97	104	118	java/lang/Throwable
    //   50	56	125	java/lang/Throwable
    //   60	67	125	java/lang/Throwable
    //   70	75	125	java/lang/Throwable
    //   85	97	125	java/lang/Throwable
    //   104	108	125	java/lang/Throwable
    //   123	125	125	java/lang/Throwable
    //   22	36	136	java/io/IOException
    //   44	48	136	java/io/IOException
    //   50	56	136	java/io/IOException
    //   60	67	136	java/io/IOException
    //   70	75	136	java/io/IOException
    //   79	83	136	java/io/IOException
    //   85	97	136	java/io/IOException
    //   97	104	136	java/io/IOException
    //   104	108	136	java/io/IOException
    //   112	116	136	java/io/IOException
    //   119	123	136	java/io/IOException
    //   123	125	136	java/io/IOException
    //   130	134	136	java/io/IOException
    //   134	136	136	java/io/IOException
    //   119	123	139	java/lang/Throwable
    //   130	134	143	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.graphics.TypefaceCompatApi21Impl
 * JD-Core Version:    0.7.0.1
 */