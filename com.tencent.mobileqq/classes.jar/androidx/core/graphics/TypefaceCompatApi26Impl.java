package androidx.core.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat.FontFileResourceEntry;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

@RequiresApi(26)
@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TypefaceCompatApi26Impl
  extends TypefaceCompatApi21Impl
{
  private static final String ABORT_CREATION_METHOD = "abortCreation";
  private static final String ADD_FONT_FROM_ASSET_MANAGER_METHOD = "addFontFromAssetManager";
  private static final String ADD_FONT_FROM_BUFFER_METHOD = "addFontFromBuffer";
  private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
  private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
  private static final String FREEZE_METHOD = "freeze";
  private static final int RESOLVE_BY_FONT_TABLE = -1;
  private static final String TAG = "TypefaceCompatApi26Impl";
  protected final Method mAbortCreation;
  protected final Method mAddFontFromAssetManager;
  protected final Method mAddFontFromBuffer;
  protected final Method mCreateFromFamiliesWithDefault;
  protected final Class<?> mFontFamily;
  protected final Constructor<?> mFontFamilyCtor;
  protected final Method mFreeze;
  
  public TypefaceCompatApi26Impl()
  {
    try
    {
      localClass = obtainFontFamily();
      localConstructor = obtainFontFamilyCtor(localClass);
      localMethod4 = obtainAddFontFromAssetManagerMethod(localClass);
      localMethod3 = obtainAddFontFromBufferMethod(localClass);
      localMethod2 = obtainFreezeMethod(localClass);
      Method localMethod5 = obtainAbortCreationMethod(localClass);
      localMethod1 = obtainCreateFromFamiliesWithDefaultMethod(localClass);
      localObject2 = localMethod5;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        Method localMethod1;
        Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + localClassNotFoundException.getClass().getName(), localClassNotFoundException);
        Object localObject1 = null;
        Method localMethod2 = null;
        Method localMethod3 = null;
        Method localMethod4 = null;
        Constructor localConstructor = null;
        Class localClass = null;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label102;
    }
    this.mFontFamily = localClass;
    this.mFontFamilyCtor = localConstructor;
    this.mAddFontFromAssetManager = localMethod4;
    this.mAddFontFromBuffer = localMethod3;
    this.mFreeze = localMethod2;
    this.mAbortCreation = localObject2;
    this.mCreateFromFamiliesWithDefault = localMethod1;
  }
  
  private void abortCreation(Object paramObject)
  {
    try
    {
      this.mAbortCreation.invoke(paramObject, new Object[0]);
      return;
    }
    catch (IllegalAccessException paramObject) {}catch (InvocationTargetException paramObject) {}
  }
  
  private boolean addFontFromAssetManager(Context paramContext, Object paramObject, String paramString, int paramInt1, int paramInt2, int paramInt3, @Nullable FontVariationAxis[] paramArrayOfFontVariationAxis)
  {
    try
    {
      boolean bool = ((Boolean)this.mAddFontFromAssetManager.invoke(paramObject, new Object[] { paramContext.getAssets(), paramString, Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramArrayOfFontVariationAxis })).booleanValue();
      return bool;
    }
    catch (IllegalAccessException paramContext)
    {
      return false;
    }
    catch (InvocationTargetException paramContext)
    {
      label81:
      break label81;
    }
  }
  
  private boolean addFontFromBuffer(Object paramObject, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      boolean bool = ((Boolean)this.mAddFontFromBuffer.invoke(paramObject, new Object[] { paramByteBuffer, Integer.valueOf(paramInt1), null, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) })).booleanValue();
      return bool;
    }
    catch (IllegalAccessException paramObject)
    {
      return false;
    }
    catch (InvocationTargetException paramObject)
    {
      label55:
      break label55;
    }
  }
  
  private boolean freeze(Object paramObject)
  {
    try
    {
      boolean bool = ((Boolean)this.mFreeze.invoke(paramObject, new Object[0])).booleanValue();
      return bool;
    }
    catch (IllegalAccessException paramObject)
    {
      return false;
    }
    catch (InvocationTargetException paramObject)
    {
      label22:
      break label22;
    }
  }
  
  private boolean isFontFamilyPrivateAPIAvailable()
  {
    if (this.mAddFontFromAssetManager == null) {
      Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
    }
    return this.mAddFontFromAssetManager != null;
  }
  
  @Nullable
  private Object newFamily()
  {
    try
    {
      Object localObject = this.mFontFamilyCtor.newInstance(new Object[0]);
      return localObject;
    }
    catch (InstantiationException localInstantiationException)
    {
      return null;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label15;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label15:
      break label15;
    }
  }
  
  @Nullable
  protected Typeface createFromFamiliesWithDefault(Object paramObject)
  {
    try
    {
      Object localObject = Array.newInstance(this.mFontFamily, 1);
      Array.set(localObject, 0, paramObject);
      paramObject = (Typeface)this.mCreateFromFamiliesWithDefault.invoke(null, new Object[] { localObject, Integer.valueOf(-1), Integer.valueOf(-1) });
      return paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      return null;
    }
    catch (InvocationTargetException paramObject)
    {
      label52:
      break label52;
    }
  }
  
  @Nullable
  public Typeface createFromFontFamilyFilesResourceEntry(Context paramContext, FontResourcesParserCompat.FontFamilyFilesResourceEntry paramFontFamilyFilesResourceEntry, Resources paramResources, int paramInt)
  {
    if (!isFontFamilyPrivateAPIAvailable()) {
      return super.createFromFontFamilyFilesResourceEntry(paramContext, paramFontFamilyFilesResourceEntry, paramResources, paramInt);
    }
    paramResources = newFamily();
    if (paramResources == null) {
      return null;
    }
    paramFontFamilyFilesResourceEntry = paramFontFamilyFilesResourceEntry.getEntries();
    int j = paramFontFamilyFilesResourceEntry.length;
    paramInt = 0;
    while (paramInt < j)
    {
      Object localObject = paramFontFamilyFilesResourceEntry[paramInt];
      String str = localObject.getFileName();
      int k = localObject.getTtcIndex();
      int m = localObject.getWeight();
      if (localObject.isItalic()) {}
      for (int i = 1; !addFontFromAssetManager(paramContext, paramResources, str, k, m, i, FontVariationAxis.fromFontVariationSettings(localObject.getVariationSettings())); i = 0)
      {
        abortCreation(paramResources);
        return null;
      }
      paramInt += 1;
    }
    if (!freeze(paramResources)) {
      return null;
    }
    return createFromFamiliesWithDefault(paramResources);
  }
  
  /* Error */
  @Nullable
  public Typeface createFromFontInfo(Context paramContext, @Nullable android.os.CancellationSignal paramCancellationSignal, @androidx.annotation.NonNull androidx.core.provider.FontsContractCompat.FontInfo[] paramArrayOfFontInfo, int paramInt)
  {
    // Byte code:
    //   0: aload_3
    //   1: arraylength
    //   2: iconst_1
    //   3: if_icmpge +7 -> 10
    //   6: aconst_null
    //   7: astore_1
    //   8: aload_1
    //   9: areturn
    //   10: aload_0
    //   11: invokespecial 194	androidx/core/graphics/TypefaceCompatApi26Impl:isFontFamilyPrivateAPIAvailable	()Z
    //   14: ifne +164 -> 178
    //   17: aload_0
    //   18: aload_3
    //   19: iload 4
    //   21: invokevirtual 247	androidx/core/graphics/TypefaceCompatApi26Impl:findBestInfo	([Landroidx/core/provider/FontsContractCompat$FontInfo;I)Landroidx/core/provider/FontsContractCompat$FontInfo;
    //   24: astore 10
    //   26: aload_1
    //   27: invokevirtual 251	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   30: astore_1
    //   31: aload_1
    //   32: aload 10
    //   34: invokevirtual 257	androidx/core/provider/FontsContractCompat$FontInfo:getUri	()Landroid/net/Uri;
    //   37: ldc_w 259
    //   40: aload_2
    //   41: invokevirtual 265	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   44: astore_3
    //   45: aconst_null
    //   46: astore_1
    //   47: aload_3
    //   48: ifnonnull +34 -> 82
    //   51: aconst_null
    //   52: astore_1
    //   53: aload_3
    //   54: ifnull -46 -> 8
    //   57: iconst_0
    //   58: ifeq +18 -> 76
    //   61: aload_3
    //   62: invokevirtual 270	android/os/ParcelFileDescriptor:close	()V
    //   65: aconst_null
    //   66: areturn
    //   67: astore_1
    //   68: new 272	java/lang/NullPointerException
    //   71: dup
    //   72: invokespecial 273	java/lang/NullPointerException:<init>	()V
    //   75: athrow
    //   76: aload_3
    //   77: invokevirtual 270	android/os/ParcelFileDescriptor:close	()V
    //   80: aconst_null
    //   81: areturn
    //   82: new 275	android/graphics/Typeface$Builder
    //   85: dup
    //   86: aload_3
    //   87: invokevirtual 279	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   90: invokespecial 282	android/graphics/Typeface$Builder:<init>	(Ljava/io/FileDescriptor;)V
    //   93: aload 10
    //   95: invokevirtual 283	androidx/core/provider/FontsContractCompat$FontInfo:getWeight	()I
    //   98: invokevirtual 287	android/graphics/Typeface$Builder:setWeight	(I)Landroid/graphics/Typeface$Builder;
    //   101: aload 10
    //   103: invokevirtual 288	androidx/core/provider/FontsContractCompat$FontInfo:isItalic	()Z
    //   106: invokevirtual 292	android/graphics/Typeface$Builder:setItalic	(Z)Landroid/graphics/Typeface$Builder;
    //   109: invokevirtual 296	android/graphics/Typeface$Builder:build	()Landroid/graphics/Typeface;
    //   112: astore_2
    //   113: aload_2
    //   114: astore_1
    //   115: aload_3
    //   116: ifnull -108 -> 8
    //   119: iconst_0
    //   120: ifeq +18 -> 138
    //   123: aload_3
    //   124: invokevirtual 270	android/os/ParcelFileDescriptor:close	()V
    //   127: aload_2
    //   128: areturn
    //   129: astore_1
    //   130: new 272	java/lang/NullPointerException
    //   133: dup
    //   134: invokespecial 273	java/lang/NullPointerException:<init>	()V
    //   137: athrow
    //   138: aload_3
    //   139: invokevirtual 270	android/os/ParcelFileDescriptor:close	()V
    //   142: aload_2
    //   143: areturn
    //   144: astore_1
    //   145: aload_1
    //   146: athrow
    //   147: astore_2
    //   148: aload_3
    //   149: ifnull +11 -> 160
    //   152: aload_1
    //   153: ifnull +18 -> 171
    //   156: aload_3
    //   157: invokevirtual 270	android/os/ParcelFileDescriptor:close	()V
    //   160: aload_2
    //   161: athrow
    //   162: astore_3
    //   163: aload_1
    //   164: aload_3
    //   165: invokevirtual 300	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   168: goto -8 -> 160
    //   171: aload_3
    //   172: invokevirtual 270	android/os/ParcelFileDescriptor:close	()V
    //   175: goto -15 -> 160
    //   178: aload_1
    //   179: aload_3
    //   180: aload_2
    //   181: invokestatic 306	androidx/core/provider/FontsContractCompat:prepareFontData	(Landroid/content/Context;[Landroidx/core/provider/FontsContractCompat$FontInfo;Landroid/os/CancellationSignal;)Ljava/util/Map;
    //   184: astore 10
    //   186: aload_0
    //   187: invokespecial 198	androidx/core/graphics/TypefaceCompatApi26Impl:newFamily	()Ljava/lang/Object;
    //   190: astore_2
    //   191: aload_2
    //   192: ifnonnull +5 -> 197
    //   195: aconst_null
    //   196: areturn
    //   197: aload_3
    //   198: arraylength
    //   199: istore 7
    //   201: iconst_0
    //   202: istore 5
    //   204: iconst_0
    //   205: istore 6
    //   207: iload 5
    //   209: iload 7
    //   211: if_icmpge +97 -> 308
    //   214: aload_3
    //   215: iload 5
    //   217: aaload
    //   218: astore 11
    //   220: aload 10
    //   222: aload 11
    //   224: invokevirtual 257	androidx/core/provider/FontsContractCompat$FontInfo:getUri	()Landroid/net/Uri;
    //   227: invokeinterface 312 2 0
    //   232: checkcast 314	java/nio/ByteBuffer
    //   235: astore_1
    //   236: aload_1
    //   237: ifnonnull +12 -> 249
    //   240: iload 5
    //   242: iconst_1
    //   243: iadd
    //   244: istore 5
    //   246: goto -39 -> 207
    //   249: aload 11
    //   251: invokevirtual 315	androidx/core/provider/FontsContractCompat$FontInfo:getTtcIndex	()I
    //   254: istore 9
    //   256: aload 11
    //   258: invokevirtual 283	androidx/core/provider/FontsContractCompat$FontInfo:getWeight	()I
    //   261: istore 8
    //   263: aload 11
    //   265: invokevirtual 288	androidx/core/provider/FontsContractCompat$FontInfo:isItalic	()Z
    //   268: ifeq +28 -> 296
    //   271: iconst_1
    //   272: istore 6
    //   274: aload_0
    //   275: aload_2
    //   276: aload_1
    //   277: iload 9
    //   279: iload 8
    //   281: iload 6
    //   283: invokespecial 317	androidx/core/graphics/TypefaceCompatApi26Impl:addFontFromBuffer	(Ljava/lang/Object;Ljava/nio/ByteBuffer;III)Z
    //   286: ifne +16 -> 302
    //   289: aload_0
    //   290: aload_2
    //   291: invokespecial 232	androidx/core/graphics/TypefaceCompatApi26Impl:abortCreation	(Ljava/lang/Object;)V
    //   294: aconst_null
    //   295: areturn
    //   296: iconst_0
    //   297: istore 6
    //   299: goto -25 -> 274
    //   302: iconst_1
    //   303: istore 6
    //   305: goto -65 -> 240
    //   308: iload 6
    //   310: ifne +10 -> 320
    //   313: aload_0
    //   314: aload_2
    //   315: invokespecial 232	androidx/core/graphics/TypefaceCompatApi26Impl:abortCreation	(Ljava/lang/Object;)V
    //   318: aconst_null
    //   319: areturn
    //   320: aload_0
    //   321: aload_2
    //   322: invokespecial 234	androidx/core/graphics/TypefaceCompatApi26Impl:freeze	(Ljava/lang/Object;)Z
    //   325: ifne +5 -> 330
    //   328: aconst_null
    //   329: areturn
    //   330: aload_0
    //   331: aload_2
    //   332: invokevirtual 236	androidx/core/graphics/TypefaceCompatApi26Impl:createFromFamiliesWithDefault	(Ljava/lang/Object;)Landroid/graphics/Typeface;
    //   335: astore_1
    //   336: aload_1
    //   337: ifnonnull +5 -> 342
    //   340: aconst_null
    //   341: areturn
    //   342: aload_1
    //   343: iload 4
    //   345: invokestatic 321	android/graphics/Typeface:create	(Landroid/graphics/Typeface;I)Landroid/graphics/Typeface;
    //   348: areturn
    //   349: astore_2
    //   350: goto -202 -> 148
    //   353: astore_1
    //   354: aconst_null
    //   355: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	356	0	this	TypefaceCompatApi26Impl
    //   0	356	1	paramContext	Context
    //   0	356	2	paramCancellationSignal	android.os.CancellationSignal
    //   0	356	3	paramArrayOfFontInfo	androidx.core.provider.FontsContractCompat.FontInfo[]
    //   0	356	4	paramInt	int
    //   202	43	5	i	int
    //   205	104	6	j	int
    //   199	13	7	k	int
    //   261	19	8	m	int
    //   254	24	9	n	int
    //   24	197	10	localObject	Object
    //   218	46	11	localFontInfo	androidx.core.provider.FontsContractCompat.FontInfo
    // Exception table:
    //   from	to	target	type
    //   61	65	67	java/lang/Throwable
    //   123	127	129	java/lang/Throwable
    //   82	113	144	java/lang/Throwable
    //   145	147	147	finally
    //   156	160	162	java/lang/Throwable
    //   82	113	349	finally
    //   31	45	353	java/io/IOException
    //   61	65	353	java/io/IOException
    //   68	76	353	java/io/IOException
    //   76	80	353	java/io/IOException
    //   123	127	353	java/io/IOException
    //   130	138	353	java/io/IOException
    //   138	142	353	java/io/IOException
    //   156	160	353	java/io/IOException
    //   160	162	353	java/io/IOException
    //   163	168	353	java/io/IOException
    //   171	175	353	java/io/IOException
  }
  
  @Nullable
  public Typeface createFromResourcesFontFile(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2)
  {
    Object localObject1 = null;
    if (!isFontFamilyPrivateAPIAvailable()) {
      paramResources = super.createFromResourcesFontFile(paramContext, paramResources, paramInt1, paramString, paramInt2);
    }
    Object localObject2;
    do
    {
      do
      {
        return paramResources;
        localObject2 = newFamily();
        paramResources = localObject1;
      } while (localObject2 == null);
      if (!addFontFromAssetManager(paramContext, localObject2, paramString, 0, -1, -1, null))
      {
        abortCreation(localObject2);
        return null;
      }
      paramResources = localObject1;
    } while (!freeze(localObject2));
    return createFromFamiliesWithDefault(localObject2);
  }
  
  protected Method obtainAbortCreationMethod(Class<?> paramClass)
  {
    return paramClass.getMethod("abortCreation", new Class[0]);
  }
  
  protected Method obtainAddFontFromAssetManagerMethod(Class<?> paramClass)
  {
    return paramClass.getMethod("addFontFromAssetManager", new Class[] { AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, [Landroid.graphics.fonts.FontVariationAxis.class });
  }
  
  protected Method obtainAddFontFromBufferMethod(Class<?> paramClass)
  {
    return paramClass.getMethod("addFontFromBuffer", new Class[] { ByteBuffer.class, Integer.TYPE, [Landroid.graphics.fonts.FontVariationAxis.class, Integer.TYPE, Integer.TYPE });
  }
  
  protected Method obtainCreateFromFamiliesWithDefaultMethod(Class<?> paramClass)
  {
    paramClass = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[] { Array.newInstance(paramClass, 1).getClass(), Integer.TYPE, Integer.TYPE });
    paramClass.setAccessible(true);
    return paramClass;
  }
  
  protected Class<?> obtainFontFamily()
  {
    return Class.forName("android.graphics.FontFamily");
  }
  
  protected Constructor<?> obtainFontFamilyCtor(Class<?> paramClass)
  {
    return paramClass.getConstructor(new Class[0]);
  }
  
  protected Method obtainFreezeMethod(Class<?> paramClass)
  {
    return paramClass.getMethod("freeze", new Class[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.core.graphics.TypefaceCompatApi26Impl
 * JD-Core Version:    0.7.0.1
 */