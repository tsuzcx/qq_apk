package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
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
import androidx.core.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat.FontFileResourceEntry;
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
    catch (IllegalAccessException paramObject)
    {
      throw new RuntimeException(paramObject);
    }
    catch (InvocationTargetException paramObject)
    {
      label42:
      break label42;
    }
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
    catch (IllegalAccessException paramObject)
    {
      throw new RuntimeException(paramObject);
    }
    catch (InvocationTargetException paramObject)
    {
      label39:
      break label39;
    }
  }
  
  private File getFile(@NonNull ParcelFileDescriptor paramParcelFileDescriptor)
  {
    try
    {
      paramParcelFileDescriptor = Os.readlink("/proc/self/fd/" + paramParcelFileDescriptor.getFd());
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
    Object localObject2 = null;
    if (sHasInitBeenCalled) {
      return;
    }
    sHasInitBeenCalled = true;
    try
    {
      localClass = Class.forName("android.graphics.FontFamily");
      localConstructor = localClass.getConstructor(new Class[0]);
      Method localMethod2 = localClass.getMethod("addFontWeightStyle", new Class[] { String.class, Integer.TYPE, Boolean.TYPE });
      localMethod1 = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[] { Array.newInstance(localClass, 1).getClass() });
      localObject2 = localMethod2;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        Method localMethod1;
        Log.e("TypefaceCompatApi21Impl", localClassNotFoundException.getClass().getName(), localClassNotFoundException);
        Object localObject1 = null;
        Constructor localConstructor = null;
        Class localClass = null;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label101;
    }
    sFontFamilyCtor = localConstructor;
    sFontFamily = localClass;
    sAddFontWeightStyle = localObject2;
    sCreateFromFamiliesWithDefault = localMethod1;
  }
  
  private static Object newFamily()
  {
    
    try
    {
      Object localObject = sFontFamilyCtor.newInstance(new Object[0]);
      return localObject;
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new RuntimeException(localInstantiationException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label17;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label17:
      break label17;
    }
  }
  
  public Typeface createFromFontFamilyFilesResourceEntry(Context paramContext, FontResourcesParserCompat.FontFamilyFilesResourceEntry paramFontFamilyFilesResourceEntry, Resources paramResources, int paramInt)
  {
    Object localObject = newFamily();
    FontResourcesParserCompat.FontFileResourceEntry[] arrayOfFontFileResourceEntry = paramFontFamilyFilesResourceEntry.getEntries();
    int i = arrayOfFontFileResourceEntry.length;
    paramInt = 0;
    while (paramInt < i)
    {
      FontResourcesParserCompat.FontFileResourceEntry localFontFileResourceEntry = arrayOfFontFileResourceEntry[paramInt];
      paramFontFamilyFilesResourceEntry = TypefaceCompatUtil.getTempFile(paramContext);
      if (paramFontFamilyFilesResourceEntry == null) {
        return null;
      }
      try
      {
        boolean bool = TypefaceCompatUtil.copyToFile(paramFontFamilyFilesResourceEntry, paramResources, localFontFileResourceEntry.getResourceId());
        if (!bool) {
          return null;
        }
        bool = addFontWeightStyle(localObject, paramFontFamilyFilesResourceEntry.getPath(), localFontFileResourceEntry.getWeight(), localFontFileResourceEntry.isItalic());
        if (!bool) {
          return null;
        }
        paramFontFamilyFilesResourceEntry.delete();
        paramInt += 1;
      }
      catch (RuntimeException paramContext)
      {
        return null;
      }
      finally
      {
        paramFontFamilyFilesResourceEntry.delete();
      }
    }
    return createFromFamiliesWithDefault(localObject);
  }
  
  /* Error */
  public Typeface createFromFontInfo(Context paramContext, android.os.CancellationSignal paramCancellationSignal, @NonNull androidx.core.provider.FontsContractCompat.FontInfo[] paramArrayOfFontInfo, int paramInt)
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
    //   12: invokevirtual 251	androidx/core/graphics/TypefaceCompatApi21Impl:findBestInfo	([Landroidx/core/provider/FontsContractCompat$FontInfo;I)Landroidx/core/provider/FontsContractCompat$FontInfo;
    //   15: astore 5
    //   17: aload_1
    //   18: invokevirtual 257	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   21: astore_3
    //   22: aload_3
    //   23: aload 5
    //   25: invokevirtual 263	androidx/core/provider/FontsContractCompat$FontInfo:getUri	()Landroid/net/Uri;
    //   28: ldc_w 265
    //   31: aload_2
    //   32: invokevirtual 271	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   35: astore_3
    //   36: aload_3
    //   37: ifnonnull +32 -> 69
    //   40: aload_3
    //   41: ifnull -35 -> 6
    //   44: iconst_0
    //   45: ifeq +18 -> 63
    //   48: aload_3
    //   49: invokevirtual 274	android/os/ParcelFileDescriptor:close	()V
    //   52: aconst_null
    //   53: areturn
    //   54: astore_1
    //   55: new 276	java/lang/NullPointerException
    //   58: dup
    //   59: invokespecial 277	java/lang/NullPointerException:<init>	()V
    //   62: athrow
    //   63: aload_3
    //   64: invokevirtual 274	android/os/ParcelFileDescriptor:close	()V
    //   67: aconst_null
    //   68: areturn
    //   69: aload_0
    //   70: aload_3
    //   71: invokespecial 279	androidx/core/graphics/TypefaceCompatApi21Impl:getFile	(Landroid/os/ParcelFileDescriptor;)Ljava/io/File;
    //   74: astore_2
    //   75: aload_2
    //   76: ifnull +10 -> 86
    //   79: aload_2
    //   80: invokevirtual 282	java/io/File:canRead	()Z
    //   83: ifne +148 -> 231
    //   86: new 284	java/io/FileInputStream
    //   89: dup
    //   90: aload_3
    //   91: invokevirtual 288	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   94: invokespecial 291	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   97: astore 5
    //   99: aload_0
    //   100: aload_1
    //   101: aload 5
    //   103: invokespecial 295	androidx/core/graphics/TypefaceCompatBaseImpl:createFromInputStream	(Landroid/content/Context;Ljava/io/InputStream;)Landroid/graphics/Typeface;
    //   106: astore_1
    //   107: aload 5
    //   109: ifnull +12 -> 121
    //   112: iconst_0
    //   113: ifeq +49 -> 162
    //   116: aload 5
    //   118: invokevirtual 296	java/io/FileInputStream:close	()V
    //   121: aload_3
    //   122: ifnull +11 -> 133
    //   125: iconst_0
    //   126: ifeq +59 -> 185
    //   129: aload_3
    //   130: invokevirtual 274	android/os/ParcelFileDescriptor:close	()V
    //   133: aload_1
    //   134: areturn
    //   135: astore_1
    //   136: new 276	java/lang/NullPointerException
    //   139: dup
    //   140: invokespecial 277	java/lang/NullPointerException:<init>	()V
    //   143: athrow
    //   144: astore_1
    //   145: aload_1
    //   146: athrow
    //   147: astore_2
    //   148: aload_3
    //   149: ifnull +11 -> 160
    //   152: aload_1
    //   153: ifnull +122 -> 275
    //   156: aload_3
    //   157: invokevirtual 274	android/os/ParcelFileDescriptor:close	()V
    //   160: aload_2
    //   161: athrow
    //   162: aload 5
    //   164: invokevirtual 296	java/io/FileInputStream:close	()V
    //   167: goto -46 -> 121
    //   170: astore_2
    //   171: aconst_null
    //   172: astore_1
    //   173: goto -25 -> 148
    //   176: astore_1
    //   177: new 276	java/lang/NullPointerException
    //   180: dup
    //   181: invokespecial 277	java/lang/NullPointerException:<init>	()V
    //   184: athrow
    //   185: aload_3
    //   186: invokevirtual 274	android/os/ParcelFileDescriptor:close	()V
    //   189: goto -56 -> 133
    //   192: astore_2
    //   193: aload_2
    //   194: athrow
    //   195: astore_1
    //   196: aload 5
    //   198: ifnull +12 -> 210
    //   201: aload_2
    //   202: ifnull +21 -> 223
    //   205: aload 5
    //   207: invokevirtual 296	java/io/FileInputStream:close	()V
    //   210: aload_1
    //   211: athrow
    //   212: astore 5
    //   214: aload_2
    //   215: aload 5
    //   217: invokevirtual 299	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   220: goto -10 -> 210
    //   223: aload 5
    //   225: invokevirtual 296	java/io/FileInputStream:close	()V
    //   228: goto -18 -> 210
    //   231: aload_2
    //   232: invokestatic 303	android/graphics/Typeface:createFromFile	(Ljava/io/File;)Landroid/graphics/Typeface;
    //   235: astore_1
    //   236: aload_3
    //   237: ifnull +11 -> 248
    //   240: iconst_0
    //   241: ifeq +18 -> 259
    //   244: aload_3
    //   245: invokevirtual 274	android/os/ParcelFileDescriptor:close	()V
    //   248: aload_1
    //   249: areturn
    //   250: astore_1
    //   251: new 276	java/lang/NullPointerException
    //   254: dup
    //   255: invokespecial 277	java/lang/NullPointerException:<init>	()V
    //   258: athrow
    //   259: aload_3
    //   260: invokevirtual 274	android/os/ParcelFileDescriptor:close	()V
    //   263: goto -15 -> 248
    //   266: astore_3
    //   267: aload_1
    //   268: aload_3
    //   269: invokevirtual 299	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   272: goto -112 -> 160
    //   275: aload_3
    //   276: invokevirtual 274	android/os/ParcelFileDescriptor:close	()V
    //   279: goto -119 -> 160
    //   282: astore_1
    //   283: aconst_null
    //   284: astore_2
    //   285: goto -89 -> 196
    //   288: astore_1
    //   289: aconst_null
    //   290: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	291	0	this	TypefaceCompatApi21Impl
    //   0	291	1	paramContext	Context
    //   0	291	2	paramCancellationSignal	android.os.CancellationSignal
    //   0	291	3	paramArrayOfFontInfo	androidx.core.provider.FontsContractCompat.FontInfo[]
    //   0	291	4	paramInt	int
    //   15	191	5	localObject	Object
    //   212	12	5	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   48	52	54	java/lang/Throwable
    //   116	121	135	java/lang/Throwable
    //   69	75	144	java/lang/Throwable
    //   79	86	144	java/lang/Throwable
    //   86	99	144	java/lang/Throwable
    //   136	144	144	java/lang/Throwable
    //   162	167	144	java/lang/Throwable
    //   210	212	144	java/lang/Throwable
    //   214	220	144	java/lang/Throwable
    //   223	228	144	java/lang/Throwable
    //   231	236	144	java/lang/Throwable
    //   145	147	147	finally
    //   69	75	170	finally
    //   79	86	170	finally
    //   86	99	170	finally
    //   116	121	170	finally
    //   136	144	170	finally
    //   162	167	170	finally
    //   205	210	170	finally
    //   210	212	170	finally
    //   214	220	170	finally
    //   223	228	170	finally
    //   231	236	170	finally
    //   129	133	176	java/lang/Throwable
    //   99	107	192	java/lang/Throwable
    //   193	195	195	finally
    //   205	210	212	java/lang/Throwable
    //   244	248	250	java/lang/Throwable
    //   156	160	266	java/lang/Throwable
    //   99	107	282	finally
    //   22	36	288	java/io/IOException
    //   48	52	288	java/io/IOException
    //   55	63	288	java/io/IOException
    //   63	67	288	java/io/IOException
    //   129	133	288	java/io/IOException
    //   156	160	288	java/io/IOException
    //   160	162	288	java/io/IOException
    //   177	185	288	java/io/IOException
    //   185	189	288	java/io/IOException
    //   244	248	288	java/io/IOException
    //   251	259	288	java/io/IOException
    //   259	263	288	java/io/IOException
    //   267	272	288	java/io/IOException
    //   275	279	288	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.core.graphics.TypefaceCompatApi21Impl
 * JD-Core Version:    0.7.0.1
 */