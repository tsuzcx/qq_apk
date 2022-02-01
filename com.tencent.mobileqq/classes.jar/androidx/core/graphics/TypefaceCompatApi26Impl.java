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
    //   14: ifne +166 -> 180
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
    //   46: astore_2
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
    //   112: astore_1
    //   113: aload_1
    //   114: astore_2
    //   115: aload_2
    //   116: astore_1
    //   117: aload_3
    //   118: ifnull -110 -> 8
    //   121: iconst_0
    //   122: ifeq +18 -> 140
    //   125: aload_3
    //   126: invokevirtual 270	android/os/ParcelFileDescriptor:close	()V
    //   129: aload_2
    //   130: areturn
    //   131: astore_1
    //   132: new 272	java/lang/NullPointerException
    //   135: dup
    //   136: invokespecial 273	java/lang/NullPointerException:<init>	()V
    //   139: athrow
    //   140: aload_3
    //   141: invokevirtual 270	android/os/ParcelFileDescriptor:close	()V
    //   144: aload_2
    //   145: areturn
    //   146: astore_2
    //   147: aload_2
    //   148: athrow
    //   149: astore_1
    //   150: aload_3
    //   151: ifnull +11 -> 162
    //   154: aload_2
    //   155: ifnull +18 -> 173
    //   158: aload_3
    //   159: invokevirtual 270	android/os/ParcelFileDescriptor:close	()V
    //   162: aload_1
    //   163: athrow
    //   164: astore_3
    //   165: aload_2
    //   166: aload_3
    //   167: invokevirtual 300	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   170: goto -8 -> 162
    //   173: aload_3
    //   174: invokevirtual 270	android/os/ParcelFileDescriptor:close	()V
    //   177: goto -15 -> 162
    //   180: aload_1
    //   181: aload_3
    //   182: aload_2
    //   183: invokestatic 306	androidx/core/provider/FontsContractCompat:prepareFontData	(Landroid/content/Context;[Landroidx/core/provider/FontsContractCompat$FontInfo;Landroid/os/CancellationSignal;)Ljava/util/Map;
    //   186: astore_1
    //   187: aload_0
    //   188: invokespecial 198	androidx/core/graphics/TypefaceCompatApi26Impl:newFamily	()Ljava/lang/Object;
    //   191: astore_2
    //   192: aload_2
    //   193: ifnonnull +5 -> 198
    //   196: aconst_null
    //   197: areturn
    //   198: aload_3
    //   199: arraylength
    //   200: istore 7
    //   202: iconst_0
    //   203: istore 5
    //   205: iconst_0
    //   206: istore 6
    //   208: iload 5
    //   210: iload 7
    //   212: if_icmpge +99 -> 311
    //   215: aload_3
    //   216: iload 5
    //   218: aaload
    //   219: astore 10
    //   221: aload_1
    //   222: aload 10
    //   224: invokevirtual 257	androidx/core/provider/FontsContractCompat$FontInfo:getUri	()Landroid/net/Uri;
    //   227: invokeinterface 312 2 0
    //   232: checkcast 314	java/nio/ByteBuffer
    //   235: astore 11
    //   237: aload 11
    //   239: ifnonnull +12 -> 251
    //   242: iload 5
    //   244: iconst_1
    //   245: iadd
    //   246: istore 5
    //   248: goto -40 -> 208
    //   251: aload 10
    //   253: invokevirtual 315	androidx/core/provider/FontsContractCompat$FontInfo:getTtcIndex	()I
    //   256: istore 8
    //   258: aload 10
    //   260: invokevirtual 283	androidx/core/provider/FontsContractCompat$FontInfo:getWeight	()I
    //   263: istore 9
    //   265: aload 10
    //   267: invokevirtual 288	androidx/core/provider/FontsContractCompat$FontInfo:isItalic	()Z
    //   270: ifeq +29 -> 299
    //   273: iconst_1
    //   274: istore 6
    //   276: aload_0
    //   277: aload_2
    //   278: aload 11
    //   280: iload 8
    //   282: iload 9
    //   284: iload 6
    //   286: invokespecial 317	androidx/core/graphics/TypefaceCompatApi26Impl:addFontFromBuffer	(Ljava/lang/Object;Ljava/nio/ByteBuffer;III)Z
    //   289: ifne +16 -> 305
    //   292: aload_0
    //   293: aload_2
    //   294: invokespecial 232	androidx/core/graphics/TypefaceCompatApi26Impl:abortCreation	(Ljava/lang/Object;)V
    //   297: aconst_null
    //   298: areturn
    //   299: iconst_0
    //   300: istore 6
    //   302: goto -26 -> 276
    //   305: iconst_1
    //   306: istore 6
    //   308: goto -66 -> 242
    //   311: iload 6
    //   313: ifne +10 -> 323
    //   316: aload_0
    //   317: aload_2
    //   318: invokespecial 232	androidx/core/graphics/TypefaceCompatApi26Impl:abortCreation	(Ljava/lang/Object;)V
    //   321: aconst_null
    //   322: areturn
    //   323: aload_0
    //   324: aload_2
    //   325: invokespecial 234	androidx/core/graphics/TypefaceCompatApi26Impl:freeze	(Ljava/lang/Object;)Z
    //   328: ifne +5 -> 333
    //   331: aconst_null
    //   332: areturn
    //   333: aload_0
    //   334: aload_2
    //   335: invokevirtual 236	androidx/core/graphics/TypefaceCompatApi26Impl:createFromFamiliesWithDefault	(Ljava/lang/Object;)Landroid/graphics/Typeface;
    //   338: astore_1
    //   339: aload_1
    //   340: ifnonnull +5 -> 345
    //   343: aconst_null
    //   344: areturn
    //   345: aload_1
    //   346: iload 4
    //   348: invokestatic 321	android/graphics/Typeface:create	(Landroid/graphics/Typeface;I)Landroid/graphics/Typeface;
    //   351: areturn
    //   352: astore_1
    //   353: goto -203 -> 150
    //   356: astore_1
    //   357: aconst_null
    //   358: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	359	0	this	TypefaceCompatApi26Impl
    //   0	359	1	paramContext	Context
    //   0	359	2	paramCancellationSignal	android.os.CancellationSignal
    //   0	359	3	paramArrayOfFontInfo	androidx.core.provider.FontsContractCompat.FontInfo[]
    //   0	359	4	paramInt	int
    //   203	44	5	i	int
    //   206	106	6	j	int
    //   200	13	7	k	int
    //   256	25	8	m	int
    //   263	20	9	n	int
    //   24	242	10	localFontInfo	androidx.core.provider.FontsContractCompat.FontInfo
    //   235	44	11	localByteBuffer	ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   61	65	67	java/lang/Throwable
    //   125	129	131	java/lang/Throwable
    //   82	113	146	java/lang/Throwable
    //   147	149	149	finally
    //   158	162	164	java/lang/Throwable
    //   82	113	352	finally
    //   31	45	356	java/io/IOException
    //   61	65	356	java/io/IOException
    //   68	76	356	java/io/IOException
    //   76	80	356	java/io/IOException
    //   125	129	356	java/io/IOException
    //   132	140	356	java/io/IOException
    //   140	144	356	java/io/IOException
    //   158	162	356	java/io/IOException
    //   162	164	356	java/io/IOException
    //   165	170	356	java/io/IOException
    //   173	177	356	java/io/IOException
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