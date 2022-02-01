package android.content.res;

import android.content.Context;
import android.content.pm.PackageParser;
import android.content.pm.PackageParser.PackageLite;
import android.content.pm.PackageParser.PackageParserException;
import android.graphics.Movie;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import de.robv.android.xposed.XC_MethodHook.MethodHookParam;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedBridge.CopyOnWriteSortedSet;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LayoutInflated;
import de.robv.android.xposed.callbacks.XC_LayoutInflated.Unhook;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import xposed.dummy.XResourcesSuperClass;

public class XResources
  extends XResourcesSuperClass
{
  private static final String EXTRA_XML_INSTANCE_DETAILS = "xmlInstanceDetails";
  private static final SparseArray<ColorStateList> sColorStateListCache;
  private static final ThreadLocal<LinkedList<XC_MethodHook.MethodHookParam>> sIncludedLayouts;
  private static ThreadLocal<Object> sLatestResKey = null;
  private static final SparseArray<HashMap<String, XposedBridge.CopyOnWriteSortedSet<XC_LayoutInflated>>> sLayoutCallbacks;
  private static final SparseArray<HashMap<String, Object>> sReplacements = new SparseArray();
  private static final HashMap<String, byte[]> sReplacementsCacheMap;
  private static final HashMap<String, Long> sResDirLastModified;
  private static final HashMap<String, String> sResDirPackageNames;
  private static final SparseArray<HashMap<String, XResources.ResourceNames>> sResourceNames = new SparseArray();
  private static final byte[] sSystemReplacementsCache = new byte[256];
  private static final WeakHashMap<XmlResourceParser, XResources.XMLInstanceDetails> sXmlInstanceDetails;
  private boolean mIsObjectInited;
  private String mPackageName;
  private byte[] mReplacementsCache;
  private String mResDir;
  
  static
  {
    sReplacementsCacheMap = new HashMap();
    sColorStateListCache = new SparseArray(0);
    sLayoutCallbacks = new SparseArray();
    sXmlInstanceDetails = new WeakHashMap();
    sIncludedLayouts = new XResources.1();
    sResDirLastModified = new HashMap();
    sResDirPackageNames = new HashMap();
  }
  
  private XResources()
  {
    throw new UnsupportedOperationException();
  }
  
  public static int getFakeResId(Resources paramResources, int paramInt)
  {
    return getFakeResId(paramResources.getResourceName(paramInt));
  }
  
  public static int getFakeResId(String paramString)
  {
    return 0x7E000000 | paramString.hashCode() & 0xFFFFFF;
  }
  
  private static String getPackageName(String paramString)
  {
    if (paramString == null)
    {
      ??? = "android";
      return ???;
    }
    for (;;)
    {
      synchronized (sResDirPackageNames)
      {
        String str = (String)sResDirPackageNames.get(paramString);
        ??? = str;
        if (str != null) {
          break;
        }
        if (Build.VERSION.SDK_INT < 21) {}
      }
      PackageParser.PackageLite localPackageLite = PackageParser.parsePackageLite(paramString, 0);
    }
    throw new IllegalStateException("Could not determine package name for " + paramString);
  }
  
  public static String getPackageNameDuringConstruction()
  {
    Object localObject;
    if (sLatestResKey != null)
    {
      localObject = sLatestResKey.get();
      if (localObject != null) {}
    }
    else
    {
      throw new IllegalStateException("This method can only be called during getTopLevelResources()");
    }
    return getPackageName((String)XposedHelpers.getObjectField(localObject, "mResDir"));
  }
  
  private Object getReplacement(int paramInt)
  {
    if (paramInt <= 0) {
      return null;
    }
    if (paramInt < 2130706432)
    {
      if ((sSystemReplacementsCache[((paramInt & 0x70000) >> 11 | (paramInt & 0xF8) >> 3)] & 1 << (paramInt & 0x7)) == 0) {
        return null;
      }
    }
    else if ((this.mResDir != null) && ((this.mReplacementsCache[((paramInt & 0x70000) >> 12 | (paramInt & 0x78) >> 3)] & 1 << (paramInt & 0x7)) == 0)) {
      return null;
    }
    synchronized (sReplacements)
    {
      HashMap localHashMap = (HashMap)sReplacements.get(paramInt);
      if (localHashMap == null) {
        return null;
      }
    }
    try
    {
      ??? = localObject1.get(this.mResDir);
      if ((??? != null) || (this.mResDir == null)) {
        return ???;
      }
      ??? = localObject1.get(null);
      return ???;
    }
    finally {}
  }
  
  private XResources.ResourceNames getResourceNames(int paramInt)
  {
    return new XResources.ResourceNames(paramInt, getResourcePackageName(paramInt), getResourceTypeName(paramInt), getResourceEntryName(paramInt), null);
  }
  
  private static XResources.ResourceNames getSystemResourceNames(int paramInt)
  {
    Resources localResources = getSystem();
    return new XResources.ResourceNames(paramInt, localResources.getResourcePackageName(paramInt), localResources.getResourceTypeName(paramInt), localResources.getResourceEntryName(paramInt), null);
  }
  
  private static XC_LayoutInflated.Unhook hookLayoutInternal(String paramString, int paramInt, XResources.ResourceNames paramResourceNames, XC_LayoutInflated paramXC_LayoutInflated)
  {
    if (paramInt == 0) {
      throw new IllegalArgumentException("id 0 is not an allowed resource identifier");
    }
    HashMap localHashMap;
    for (;;)
    {
      XposedBridge.CopyOnWriteSortedSet localCopyOnWriteSortedSet;
      synchronized (sLayoutCallbacks)
      {
        localHashMap = (HashMap)sLayoutCallbacks.get(paramInt);
        if (localHashMap == null)
        {
          localHashMap = new HashMap();
          sLayoutCallbacks.put(paramInt, localHashMap);
        }
      }
    }
  }
  
  public static XC_LayoutInflated.Unhook hookSystemWideLayout(int paramInt, XC_LayoutInflated paramXC_LayoutInflated)
  {
    if (paramInt >= 2130706432) {
      throw new IllegalArgumentException("ids >= 0x7f000000 are app specific and cannot be set for the framework");
    }
    return hookLayoutInternal(null, paramInt, getSystemResourceNames(paramInt), paramXC_LayoutInflated);
  }
  
  @Deprecated
  public static XC_LayoutInflated.Unhook hookSystemWideLayout(String paramString, XC_LayoutInflated paramXC_LayoutInflated)
  {
    int i = getSystem().getIdentifier(paramString, null, null);
    if (i == 0) {
      throw new Resources.NotFoundException(paramString);
    }
    return hookSystemWideLayout(i, paramXC_LayoutInflated);
  }
  
  public static XC_LayoutInflated.Unhook hookSystemWideLayout(String paramString1, String paramString2, String paramString3, XC_LayoutInflated paramXC_LayoutInflated)
  {
    int i = getSystem().getIdentifier(paramString3, paramString2, paramString1);
    if (i == 0) {
      throw new Resources.NotFoundException(paramString1 + ":" + paramString2 + "/" + paramString3);
    }
    return hookSystemWideLayout(i, paramXC_LayoutInflated);
  }
  
  public static void init(ThreadLocal<Object> paramThreadLocal)
  {
    sLatestResKey = paramThreadLocal;
    XposedHelpers.findAndHookMethod(LayoutInflater.class, "inflate", new Object[] { XmlPullParser.class, ViewGroup.class, Boolean.TYPE, new XResources.2() });
    paramThreadLocal = new XResources.3();
    if (Build.VERSION.SDK_INT < 21)
    {
      XposedHelpers.findAndHookMethod(LayoutInflater.class, "parseInclude", new Object[] { XmlPullParser.class, View.class, AttributeSet.class, paramThreadLocal });
      return;
    }
    if (Build.VERSION.SDK_INT < 23)
    {
      XposedHelpers.findAndHookMethod(LayoutInflater.class, "parseInclude", new Object[] { XmlPullParser.class, View.class, AttributeSet.class, Boolean.TYPE, paramThreadLocal });
      return;
    }
    XposedHelpers.findAndHookMethod(LayoutInflater.class, "parseInclude", new Object[] { XmlPullParser.class, Context.class, View.class, AttributeSet.class, paramThreadLocal });
  }
  
  private static boolean isXmlCached(Resources arg0, int paramInt)
  {
    for (;;)
    {
      int i;
      synchronized ((int[])XposedHelpers.getObjectField(???, "mCachedXmlBlockIds"))
      {
        int j = ???.length;
        i = 0;
        if (i < j)
        {
          if (???[i] == paramInt) {
            return true;
          }
        }
        else {
          return false;
        }
      }
      i += 1;
    }
  }
  
  private static void putResourceNames(String paramString, XResources.ResourceNames paramResourceNames)
  {
    int i = paramResourceNames.id;
    for (;;)
    {
      synchronized (sResourceNames)
      {
        HashMap localHashMap = (HashMap)sResourceNames.get(i);
        if (localHashMap == null)
        {
          localHashMap = new HashMap();
          sResourceNames.put(i, localHashMap);
          try
          {
            localHashMap.put(paramString, paramResourceNames);
            return;
          }
          finally {}
        }
      }
    }
  }
  
  private static native void rewriteXmlReferencesNative(long paramLong, XResources paramXResources, Resources paramResources);
  
  public static void setPackageNameForResDir(String paramString1, String paramString2)
  {
    synchronized (sResDirPackageNames)
    {
      sResDirPackageNames.put(paramString2, paramString1);
      return;
    }
  }
  
  private static void setReplacement(int paramInt, Object paramObject, XResources arg2)
  {
    if (??? != null) {}
    for (String str = ???.mResDir; paramInt == 0; str = null) {
      throw new IllegalArgumentException("id 0 is not an allowed resource identifier");
    }
    if ((str == null) && (paramInt >= 2130706432)) {
      throw new IllegalArgumentException("ids >= 0x7f000000 are app specific and cannot be set for the framework");
    }
    if ((paramObject instanceof Drawable)) {
      throw new IllegalArgumentException("Drawable replacements are deprecated since Xposed 2.1. Use DrawableLoader instead.");
    }
    int i;
    if (paramInt < 2130706432)
    {
      i = (paramInt & 0x70000) >> 11 | (paramInt & 0xF8) >> 3;
      synchronized (sSystemReplacementsCache)
      {
        ??? = sSystemReplacementsCache;
        ???[i] = ((byte)(???[i] | 1 << (paramInt & 0x7)));
      }
    }
    synchronized (sReplacements)
    {
      for (;;)
      {
        ??? = (HashMap)sReplacements.get(paramInt);
        ??? = (XResources)???;
        if (??? == null)
        {
          ??? = new HashMap();
          sReplacements.put(paramInt, ???);
        }
        ???.put(str, paramObject);
        return;
        paramObject = finally;
        throw paramObject;
        i = (paramInt & 0x70000) >> 12 | (paramInt & 0x78) >> 3;
        synchronized (???.mReplacementsCache)
        {
          ??? = ???.mReplacementsCache;
          ???[i] = ((byte)(???[i] | 1 << (paramInt & 0x7)));
        }
      }
    }
  }
  
  public static void setSystemWideReplacement(int paramInt, Object paramObject)
  {
    setReplacement(paramInt, paramObject, null);
  }
  
  @Deprecated
  public static void setSystemWideReplacement(String paramString, Object paramObject)
  {
    int i = getSystem().getIdentifier(paramString, null, null);
    if (i == 0) {
      throw new Resources.NotFoundException(paramString);
    }
    setReplacement(i, paramObject, null);
  }
  
  public static void setSystemWideReplacement(String paramString1, String paramString2, String paramString3, Object paramObject)
  {
    int i = getSystem().getIdentifier(paramString3, paramString2, paramString1);
    if (i == 0) {
      throw new Resources.NotFoundException(paramString1 + ":" + paramString2 + "/" + paramString3);
    }
    setReplacement(i, paramObject, null);
  }
  
  private static int translateAttrId(String paramString, XResources paramXResources)
  {
    String str = paramXResources.mPackageName;
    try
    {
      int i = paramXResources.getIdentifier(paramString, "attr", str);
      return i;
    }
    catch (Resources.NotFoundException paramXResources)
    {
      XposedBridge.log("Attribute " + paramString + " not found in original resources");
    }
    return 0;
  }
  
  /* Error */
  private static int translateResId(int paramInt, XResources paramXResources, Resources paramResources)
  {
    // Byte code:
    //   0: aload_2
    //   1: iload_0
    //   2: invokevirtual 235	android/content/res/Resources:getResourceEntryName	(I)Ljava/lang/String;
    //   5: astore 5
    //   7: aload_2
    //   8: iload_0
    //   9: invokevirtual 234	android/content/res/Resources:getResourceTypeName	(I)Ljava/lang/String;
    //   12: astore 6
    //   14: aload_1
    //   15: getfield 358	android/content/res/XResources:mPackageName	Ljava/lang/String;
    //   18: astore 7
    //   20: aload_1
    //   21: aload 5
    //   23: aload 6
    //   25: aload 7
    //   27: invokevirtual 361	android/content/res/XResources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   30: istore_3
    //   31: new 376	android/util/TypedValue
    //   34: dup
    //   35: invokespecial 377	android/util/TypedValue:<init>	()V
    //   38: astore 7
    //   40: aload_2
    //   41: iload_0
    //   42: aload 7
    //   44: iconst_0
    //   45: invokevirtual 381	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   48: aload 7
    //   50: getfield 384	android/util/TypedValue:type	I
    //   53: bipush 18
    //   55: if_icmpne +15 -> 70
    //   58: aload 7
    //   60: getfield 387	android/util/TypedValue:data	I
    //   63: istore 4
    //   65: iload 4
    //   67: ifeq +124 -> 191
    //   70: iconst_1
    //   71: istore 4
    //   73: iload 4
    //   75: ifne +55 -> 130
    //   78: iload_3
    //   79: ifne +51 -> 130
    //   82: aload 6
    //   84: ldc_w 388
    //   87: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   90: ifne +40 -> 130
    //   93: new 152	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   100: aload 6
    //   102: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: ldc_w 296
    //   108: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload 5
    //   113: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: ldc_w 393
    //   119: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 370	de/robv/android/xposed/XposedBridge:log	(Ljava/lang/String;)V
    //   128: iconst_0
    //   129: ireturn
    //   130: iload_3
    //   131: ifne +48 -> 179
    //   134: aload_2
    //   135: iload_0
    //   136: invokestatic 395	android/content/res/XResources:getFakeResId	(Landroid/content/res/Resources;I)I
    //   139: istore_3
    //   140: iload 4
    //   142: ifeq +40 -> 182
    //   145: aload 6
    //   147: ldc_w 388
    //   150: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   153: ifne +29 -> 182
    //   156: aload_1
    //   157: iload_3
    //   158: new 397	android/content/res/XResForwarder
    //   161: dup
    //   162: aload_2
    //   163: iload_0
    //   164: invokespecial 400	android/content/res/XResForwarder:<init>	(Landroid/content/res/Resources;I)V
    //   167: invokevirtual 402	android/content/res/XResources:setReplacement	(ILjava/lang/Object;)V
    //   170: iload_3
    //   171: ireturn
    //   172: astore_1
    //   173: aload_1
    //   174: invokestatic 405	de/robv/android/xposed/XposedBridge:log	(Ljava/lang/Throwable;)V
    //   177: iload_0
    //   178: ireturn
    //   179: goto -39 -> 140
    //   182: iload_3
    //   183: ireturn
    //   184: astore 7
    //   186: iconst_0
    //   187: istore_3
    //   188: goto -157 -> 31
    //   191: iconst_0
    //   192: istore 4
    //   194: goto -121 -> 73
    //   197: astore 7
    //   199: iconst_0
    //   200: istore 4
    //   202: goto -129 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	paramInt	int
    //   0	205	1	paramXResources	XResources
    //   0	205	2	paramResources	Resources
    //   30	158	3	i	int
    //   63	138	4	j	int
    //   5	107	5	str1	String
    //   12	134	6	str2	String
    //   18	41	7	localObject	Object
    //   184	1	7	localNotFoundException1	Resources.NotFoundException
    //   197	1	7	localNotFoundException2	Resources.NotFoundException
    // Exception table:
    //   from	to	target	type
    //   0	20	172	java/lang/Exception
    //   20	31	172	java/lang/Exception
    //   31	65	172	java/lang/Exception
    //   82	128	172	java/lang/Exception
    //   134	140	172	java/lang/Exception
    //   145	170	172	java/lang/Exception
    //   20	31	184	android/content/res/Resources$NotFoundException
    //   31	65	197	android/content/res/Resources$NotFoundException
  }
  
  public static void unhookLayout(String paramString, int paramInt, XC_LayoutInflated paramXC_LayoutInflated)
  {
    HashMap localHashMap;
    synchronized (sLayoutCallbacks)
    {
      localHashMap = (HashMap)sLayoutCallbacks.get(paramInt);
      if (localHashMap == null) {
        return;
      }
      try
      {
        paramString = (XposedBridge.CopyOnWriteSortedSet)localHashMap.get(paramString);
        if (paramString == null) {
          return;
        }
      }
      finally {}
    }
    paramString.remove(paramXC_LayoutInflated);
  }
  
  public int addResource(Resources paramResources, int paramInt)
  {
    int i = getFakeResId(paramResources, paramInt);
    synchronized (sReplacements)
    {
      if (sReplacements.indexOfKey(i) < 0) {
        setReplacement(i, new XResForwarder(paramResources, paramInt));
      }
      return i;
    }
  }
  
  public XmlResourceParser getAnimation(int paramInt)
  {
    Object localObject = getReplacement(paramInt);
    if ((localObject instanceof XResForwarder))
    {
      Resources localResources = ((XResForwarder)localObject).getResources();
      paramInt = ((XResForwarder)localObject).getId();
      boolean bool = isXmlCached(localResources, paramInt);
      localObject = localResources.getAnimation(paramInt);
      if (!bool) {
        if (Build.VERSION.SDK_INT < 21) {
          break label80;
        }
      }
      label80:
      for (long l = XposedHelpers.getLongField(localObject, "mParseState");; l = XposedHelpers.getIntField(localObject, "mParseState"))
      {
        rewriteXmlReferencesNative(l, this, localResources);
        return localObject;
      }
    }
    return super.getAnimation(paramInt);
  }
  
  public boolean getBoolean(int paramInt)
  {
    Object localObject = getReplacement(paramInt);
    if ((localObject instanceof Boolean)) {
      return ((Boolean)localObject).booleanValue();
    }
    if ((localObject instanceof XResForwarder)) {
      return ((XResForwarder)localObject).getResources().getBoolean(((XResForwarder)localObject).getId());
    }
    return super.getBoolean(paramInt);
  }
  
  public int getColor(int paramInt)
  {
    Object localObject = getReplacement(paramInt);
    if ((localObject instanceof Integer)) {
      return ((Integer)localObject).intValue();
    }
    if ((localObject instanceof XResForwarder)) {
      return ((XResForwarder)localObject).getResources().getColor(((XResForwarder)localObject).getId());
    }
    return super.getColor(paramInt);
  }
  
  public ColorStateList getColorStateList(int paramInt)
  {
    Object localObject1 = getReplacement(paramInt);
    if ((localObject1 instanceof ColorStateList)) {
      return (ColorStateList)localObject1;
    }
    if ((localObject1 instanceof Integer))
    {
      paramInt = ((Integer)localObject1).intValue();
      synchronized (sColorStateListCache)
      {
        ColorStateList localColorStateList = (ColorStateList)sColorStateListCache.get(paramInt);
        localObject1 = localColorStateList;
        if (localColorStateList == null)
        {
          localObject1 = ColorStateList.valueOf(paramInt);
          sColorStateListCache.put(paramInt, localObject1);
        }
        return localObject1;
      }
    }
    if ((localObject2 instanceof XResForwarder)) {
      return ((XResForwarder)localObject2).getResources().getColorStateList(((XResForwarder)localObject2).getId());
    }
    return super.getColorStateList(paramInt);
  }
  
  public float getDimension(int paramInt)
  {
    Object localObject = getReplacement(paramInt);
    if ((localObject instanceof XResources.DimensionReplacement)) {
      return ((XResources.DimensionReplacement)localObject).getDimension(getDisplayMetrics());
    }
    if ((localObject instanceof XResForwarder)) {
      return ((XResForwarder)localObject).getResources().getDimension(((XResForwarder)localObject).getId());
    }
    return super.getDimension(paramInt);
  }
  
  public int getDimensionPixelOffset(int paramInt)
  {
    Object localObject = getReplacement(paramInt);
    if ((localObject instanceof XResources.DimensionReplacement)) {
      return ((XResources.DimensionReplacement)localObject).getDimensionPixelOffset(getDisplayMetrics());
    }
    if ((localObject instanceof XResForwarder)) {
      return ((XResForwarder)localObject).getResources().getDimensionPixelOffset(((XResForwarder)localObject).getId());
    }
    return super.getDimensionPixelOffset(paramInt);
  }
  
  public int getDimensionPixelSize(int paramInt)
  {
    Object localObject = getReplacement(paramInt);
    if ((localObject instanceof XResources.DimensionReplacement)) {
      return ((XResources.DimensionReplacement)localObject).getDimensionPixelSize(getDisplayMetrics());
    }
    if ((localObject instanceof XResForwarder)) {
      return ((XResForwarder)localObject).getResources().getDimensionPixelSize(((XResForwarder)localObject).getId());
    }
    return super.getDimensionPixelSize(paramInt);
  }
  
  public Drawable getDrawable(int paramInt)
  {
    try
    {
      if (XposedHelpers.incrementMethodDepth("getDrawable") == 1)
      {
        Object localObject1 = getReplacement(paramInt);
        boolean bool = localObject1 instanceof XResources.DrawableLoader;
        if (!bool) {
          break label68;
        }
        try
        {
          localObject1 = ((XResources.DrawableLoader)localObject1).newDrawable(this, paramInt);
          if (localObject1 != null) {
            return localObject1;
          }
        }
        catch (Throwable localThrowable)
        {
          XposedBridge.log(localThrowable);
        }
      }
      label68:
      do
      {
        localObject2 = super.getDrawable(paramInt);
        return localObject2;
        if ((localObject2 instanceof Integer))
        {
          localObject2 = new ColorDrawable(((Integer)localObject2).intValue());
          return localObject2;
        }
      } while (!(localObject2 instanceof XResForwarder));
      Object localObject2 = ((XResForwarder)localObject2).getResources().getDrawable(((XResForwarder)localObject2).getId());
      return localObject2;
    }
    finally
    {
      XposedHelpers.decrementMethodDepth("getDrawable");
    }
  }
  
  public Drawable getDrawable(int paramInt, Resources.Theme paramTheme)
  {
    try
    {
      if (XposedHelpers.incrementMethodDepth("getDrawable") == 1)
      {
        Object localObject = getReplacement(paramInt);
        boolean bool = localObject instanceof XResources.DrawableLoader;
        if (!bool) {
          break label77;
        }
        try
        {
          localObject = ((XResources.DrawableLoader)localObject).newDrawable(this, paramInt);
          if (localObject != null) {
            return localObject;
          }
        }
        catch (Throwable localThrowable)
        {
          XposedBridge.log(localThrowable);
        }
      }
      label77:
      do
      {
        paramTheme = super.getDrawable(paramInt, paramTheme);
        return paramTheme;
        if ((localThrowable instanceof Integer))
        {
          paramTheme = new ColorDrawable(((Integer)localThrowable).intValue());
          return paramTheme;
        }
      } while (!(localThrowable instanceof XResForwarder));
      paramTheme = ((XResForwarder)localThrowable).getResources().getDrawable(((XResForwarder)localThrowable).getId());
      return paramTheme;
    }
    finally
    {
      XposedHelpers.decrementMethodDepth("getDrawable");
    }
  }
  
  public Drawable getDrawable(int paramInt, Resources.Theme paramTheme, boolean paramBoolean)
  {
    try
    {
      if (XposedHelpers.incrementMethodDepth("getDrawable") == 1)
      {
        Object localObject = getReplacement(paramInt);
        boolean bool = localObject instanceof XResources.DrawableLoader;
        if (!bool) {
          break label80;
        }
        try
        {
          localObject = ((XResources.DrawableLoader)localObject).newDrawable(this, paramInt);
          if (localObject != null) {
            return localObject;
          }
        }
        catch (Throwable localThrowable)
        {
          XposedBridge.log(localThrowable);
        }
      }
      label80:
      do
      {
        paramTheme = super.getDrawable(paramInt, paramTheme, paramBoolean);
        return paramTheme;
        if ((localThrowable instanceof Integer))
        {
          paramTheme = new ColorDrawable(((Integer)localThrowable).intValue());
          return paramTheme;
        }
      } while (!(localThrowable instanceof XResForwarder));
      paramTheme = ((XResForwarder)localThrowable).getResources().getDrawable(((XResForwarder)localThrowable).getId());
      return paramTheme;
    }
    finally
    {
      XposedHelpers.decrementMethodDepth("getDrawable");
    }
  }
  
  public Drawable getDrawableForDensity(int paramInt1, int paramInt2)
  {
    try
    {
      if (XposedHelpers.incrementMethodDepth("getDrawableForDensity") == 1)
      {
        Object localObject1 = getReplacement(paramInt1);
        boolean bool = localObject1 instanceof XResources.DrawableLoader;
        if (!bool) {
          break label80;
        }
        try
        {
          localObject1 = ((XResources.DrawableLoader)localObject1).newDrawableForDensity(this, paramInt1, paramInt2);
          if (localObject1 != null) {
            return localObject1;
          }
        }
        catch (Throwable localThrowable)
        {
          XposedBridge.log(localThrowable);
        }
      }
      label80:
      do
      {
        localObject2 = super.getDrawableForDensity(paramInt1, paramInt2);
        return localObject2;
        if ((localObject2 instanceof Integer))
        {
          localObject2 = new ColorDrawable(((Integer)localObject2).intValue());
          return localObject2;
        }
      } while (!(localObject2 instanceof XResForwarder));
      Object localObject2 = ((XResForwarder)localObject2).getResources().getDrawableForDensity(((XResForwarder)localObject2).getId(), paramInt2);
      return localObject2;
    }
    finally
    {
      XposedHelpers.decrementMethodDepth("getDrawableForDensity");
    }
  }
  
  public Drawable getDrawableForDensity(int paramInt1, int paramInt2, Resources.Theme paramTheme)
  {
    try
    {
      if (XposedHelpers.incrementMethodDepth("getDrawableForDensity") == 1)
      {
        Object localObject = getReplacement(paramInt1);
        boolean bool = localObject instanceof XResources.DrawableLoader;
        if (!bool) {
          break label81;
        }
        try
        {
          localObject = ((XResources.DrawableLoader)localObject).newDrawableForDensity(this, paramInt1, paramInt2);
          if (localObject != null) {
            return localObject;
          }
        }
        catch (Throwable localThrowable)
        {
          XposedBridge.log(localThrowable);
        }
      }
      label81:
      do
      {
        paramTheme = super.getDrawableForDensity(paramInt1, paramInt2, paramTheme);
        return paramTheme;
        if ((localThrowable instanceof Integer))
        {
          paramTheme = new ColorDrawable(((Integer)localThrowable).intValue());
          return paramTheme;
        }
      } while (!(localThrowable instanceof XResForwarder));
      paramTheme = ((XResForwarder)localThrowable).getResources().getDrawableForDensity(((XResForwarder)localThrowable).getId(), paramInt2);
      return paramTheme;
    }
    finally
    {
      XposedHelpers.decrementMethodDepth("getDrawableForDensity");
    }
  }
  
  public Drawable getDrawableForDensity(int paramInt1, int paramInt2, Resources.Theme paramTheme, boolean paramBoolean)
  {
    try
    {
      if (XposedHelpers.incrementMethodDepth("getDrawableForDensity") == 1)
      {
        Object localObject = getReplacement(paramInt1);
        boolean bool = localObject instanceof XResources.DrawableLoader;
        if (!bool) {
          break label83;
        }
        try
        {
          localObject = ((XResources.DrawableLoader)localObject).newDrawableForDensity(this, paramInt1, paramInt2);
          if (localObject != null) {
            return localObject;
          }
        }
        catch (Throwable localThrowable)
        {
          XposedBridge.log(localThrowable);
        }
      }
      label83:
      do
      {
        paramTheme = super.getDrawableForDensity(paramInt1, paramInt2, paramTheme, paramBoolean);
        return paramTheme;
        if ((localThrowable instanceof Integer))
        {
          paramTheme = new ColorDrawable(((Integer)localThrowable).intValue());
          return paramTheme;
        }
      } while (!(localThrowable instanceof XResForwarder));
      paramTheme = ((XResForwarder)localThrowable).getResources().getDrawableForDensity(((XResForwarder)localThrowable).getId(), paramInt2);
      return paramTheme;
    }
    finally
    {
      XposedHelpers.decrementMethodDepth("getDrawableForDensity");
    }
  }
  
  public float getFraction(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = getReplacement(paramInt1);
    if ((localObject instanceof XResForwarder)) {
      return ((XResForwarder)localObject).getResources().getFraction(((XResForwarder)localObject).getId(), paramInt2, paramInt3);
    }
    return super.getFraction(paramInt1, paramInt2, paramInt3);
  }
  
  public int[] getIntArray(int paramInt)
  {
    Object localObject = getReplacement(paramInt);
    if ((localObject instanceof int[])) {
      return (int[])localObject;
    }
    if ((localObject instanceof XResForwarder)) {
      return ((XResForwarder)localObject).getResources().getIntArray(((XResForwarder)localObject).getId());
    }
    return super.getIntArray(paramInt);
  }
  
  public int getInteger(int paramInt)
  {
    Object localObject = getReplacement(paramInt);
    if ((localObject instanceof Integer)) {
      return ((Integer)localObject).intValue();
    }
    if ((localObject instanceof XResForwarder)) {
      return ((XResForwarder)localObject).getResources().getInteger(((XResForwarder)localObject).getId());
    }
    return super.getInteger(paramInt);
  }
  
  /* Error */
  public XmlResourceParser getLayout(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: invokespecial 95	android/content/res/XResources:getReplacement	(I)Ljava/lang/Object;
    //   5: astore 7
    //   7: aload 7
    //   9: instanceof 397
    //   12: ifeq +335 -> 347
    //   15: aload 7
    //   17: checkcast 397	android/content/res/XResForwarder
    //   20: invokevirtual 420	android/content/res/XResForwarder:getResources	()Landroid/content/res/Resources;
    //   23: astore 6
    //   25: aload 7
    //   27: checkcast 397	android/content/res/XResForwarder
    //   30: invokevirtual 423	android/content/res/XResForwarder:getId	()I
    //   33: istore_2
    //   34: aload 6
    //   36: iload_2
    //   37: invokestatic 425	android/content/res/XResources:isXmlCached	(Landroid/content/res/Resources;I)Z
    //   40: istore_3
    //   41: aload 6
    //   43: iload_2
    //   44: invokevirtual 557	android/content/res/Resources:getLayout	(I)Landroid/content/res/XmlResourceParser;
    //   47: astore 7
    //   49: iload_3
    //   50: ifne +29 -> 79
    //   53: getstatic 132	android/os/Build$VERSION:SDK_INT	I
    //   56: bipush 21
    //   58: if_icmplt +275 -> 333
    //   61: aload 7
    //   63: ldc_w 429
    //   66: invokestatic 433	de/robv/android/xposed/XposedHelpers:getLongField	(Ljava/lang/Object;Ljava/lang/String;)J
    //   69: lstore 4
    //   71: lload 4
    //   73: aload_0
    //   74: aload 6
    //   76: invokestatic 435	android/content/res/XResources:rewriteXmlReferencesNative	(JLandroid/content/res/XResources;Landroid/content/res/Resources;)V
    //   79: getstatic 64	android/content/res/XResources:sLayoutCallbacks	Landroid/util/SparseArray;
    //   82: astore 8
    //   84: aload 8
    //   86: monitorenter
    //   87: getstatic 64	android/content/res/XResources:sLayoutCallbacks	Landroid/util/SparseArray;
    //   90: iload_1
    //   91: invokevirtual 211	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   94: checkcast 54	java/util/HashMap
    //   97: astore 6
    //   99: aload 8
    //   101: monitorexit
    //   102: aload 6
    //   104: ifnull +226 -> 330
    //   107: aload 6
    //   109: monitorenter
    //   110: aload 6
    //   112: aload_0
    //   113: getfield 207	android/content/res/XResources:mResDir	Ljava/lang/String;
    //   116: invokevirtual 126	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   119: checkcast 248	de/robv/android/xposed/XposedBridge$CopyOnWriteSortedSet
    //   122: astore 8
    //   124: aload 8
    //   126: ifnonnull +365 -> 491
    //   129: aload_0
    //   130: getfield 207	android/content/res/XResources:mResDir	Ljava/lang/String;
    //   133: ifnull +358 -> 491
    //   136: aload 6
    //   138: aconst_null
    //   139: invokevirtual 126	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   142: checkcast 248	de/robv/android/xposed/XposedBridge$CopyOnWriteSortedSet
    //   145: astore 8
    //   147: aload 6
    //   149: monitorexit
    //   150: aload 8
    //   152: ifnull +178 -> 330
    //   155: aload_0
    //   156: ldc_w 559
    //   159: invokestatic 201	de/robv/android/xposed/XposedHelpers:getObjectField	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   162: checkcast 376	android/util/TypedValue
    //   165: astore 6
    //   167: aload_0
    //   168: iload_1
    //   169: aload 6
    //   171: iconst_1
    //   172: invokevirtual 560	android/content/res/XResources:getValue	(ILandroid/util/TypedValue;Z)V
    //   175: aload 6
    //   177: getfield 384	android/util/TypedValue:type	I
    //   180: iconst_3
    //   181: if_icmpne +245 -> 426
    //   184: aload 6
    //   186: getfield 564	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   189: invokeinterface 567 1 0
    //   194: ldc_w 296
    //   197: iconst_3
    //   198: invokevirtual 571	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   201: astore 9
    //   203: aload 9
    //   205: arraylength
    //   206: iconst_3
    //   207: if_icmpne +166 -> 373
    //   210: aload 9
    //   212: iconst_1
    //   213: aaload
    //   214: astore 6
    //   216: getstatic 69	android/content/res/XResources:sXmlInstanceDetails	Ljava/util/WeakHashMap;
    //   219: astore 9
    //   221: aload 9
    //   223: monitorenter
    //   224: getstatic 50	android/content/res/XResources:sResourceNames	Landroid/util/SparseArray;
    //   227: astore 10
    //   229: aload 10
    //   231: monitorenter
    //   232: getstatic 50	android/content/res/XResources:sResourceNames	Landroid/util/SparseArray;
    //   235: iload_1
    //   236: invokevirtual 211	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   239: checkcast 54	java/util/HashMap
    //   242: astore 11
    //   244: aload 11
    //   246: ifnull +78 -> 324
    //   249: aload 11
    //   251: monitorenter
    //   252: new 573	android/content/res/XResources$XMLInstanceDetails
    //   255: dup
    //   256: aload_0
    //   257: aload 11
    //   259: aload_0
    //   260: getfield 207	android/content/res/XResources:mResDir	Ljava/lang/String;
    //   263: invokevirtual 126	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   266: checkcast 215	android/content/res/XResources$ResourceNames
    //   269: aload 6
    //   271: aload 8
    //   273: aconst_null
    //   274: invokespecial 576	android/content/res/XResources$XMLInstanceDetails:<init>	(Landroid/content/res/XResources;Landroid/content/res/XResources$ResourceNames;Ljava/lang/String;Lde/robv/android/xposed/XposedBridge$CopyOnWriteSortedSet;Landroid/content/res/XResources$1;)V
    //   277: astore 6
    //   279: getstatic 69	android/content/res/XResources:sXmlInstanceDetails	Ljava/util/WeakHashMap;
    //   282: aload 7
    //   284: aload 6
    //   286: invokevirtual 577	java/util/WeakHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   289: pop
    //   290: getstatic 74	android/content/res/XResources:sIncludedLayouts	Ljava/lang/ThreadLocal;
    //   293: invokevirtual 192	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   296: checkcast 579	java/util/LinkedList
    //   299: invokevirtual 582	java/util/LinkedList:peek	()Ljava/lang/Object;
    //   302: checkcast 584	de/robv/android/xposed/XC_MethodHook$MethodHookParam
    //   305: astore 8
    //   307: aload 8
    //   309: ifnull +12 -> 321
    //   312: aload 8
    //   314: ldc 8
    //   316: aload 6
    //   318: invokevirtual 587	de/robv/android/xposed/XC_MethodHook$MethodHookParam:setObjectExtra	(Ljava/lang/String;Ljava/lang/Object;)V
    //   321: aload 11
    //   323: monitorexit
    //   324: aload 10
    //   326: monitorexit
    //   327: aload 9
    //   329: monitorexit
    //   330: aload 7
    //   332: areturn
    //   333: aload 7
    //   335: ldc_w 429
    //   338: invokestatic 439	de/robv/android/xposed/XposedHelpers:getIntField	(Ljava/lang/Object;Ljava/lang/String;)I
    //   341: i2l
    //   342: lstore 4
    //   344: goto -273 -> 71
    //   347: aload_0
    //   348: iload_1
    //   349: invokespecial 588	xposed/dummy/XResourcesSuperClass:getLayout	(I)Landroid/content/res/XmlResourceParser;
    //   352: astore 7
    //   354: goto -275 -> 79
    //   357: astore 6
    //   359: aload 8
    //   361: monitorexit
    //   362: aload 6
    //   364: athrow
    //   365: astore 7
    //   367: aload 6
    //   369: monitorexit
    //   370: aload 7
    //   372: athrow
    //   373: new 152	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   380: ldc_w 590
    //   383: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: aload 6
    //   388: getfield 564	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   391: invokeinterface 567 1 0
    //   396: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: ldc_w 592
    //   402: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: iload_1
    //   406: invokestatic 595	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   409: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokestatic 370	de/robv/android/xposed/XposedBridge:log	(Ljava/lang/String;)V
    //   418: ldc_w 597
    //   421: astore 6
    //   423: goto -207 -> 216
    //   426: new 152	java/lang/StringBuilder
    //   429: dup
    //   430: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   433: new 287	android/content/res/Resources$NotFoundException
    //   436: dup
    //   437: ldc_w 599
    //   440: invokespecial 288	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   443: invokevirtual 602	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   446: iload_1
    //   447: invokestatic 595	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   450: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   456: invokestatic 370	de/robv/android/xposed/XposedBridge:log	(Ljava/lang/String;)V
    //   459: ldc_w 597
    //   462: astore 6
    //   464: goto -248 -> 216
    //   467: astore 6
    //   469: aload 11
    //   471: monitorexit
    //   472: aload 6
    //   474: athrow
    //   475: astore 6
    //   477: aload 10
    //   479: monitorexit
    //   480: aload 6
    //   482: athrow
    //   483: astore 6
    //   485: aload 9
    //   487: monitorexit
    //   488: aload 6
    //   490: athrow
    //   491: goto -344 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	494	0	this	XResources
    //   0	494	1	paramInt	int
    //   33	11	2	i	int
    //   40	10	3	bool	boolean
    //   69	274	4	l	long
    //   23	294	6	localObject1	Object
    //   357	30	6	localObject2	Object
    //   421	42	6	str	String
    //   467	6	6	localObject3	Object
    //   475	6	6	localObject4	Object
    //   483	6	6	localObject5	Object
    //   5	348	7	localObject6	Object
    //   365	6	7	localObject7	Object
    //   82	278	8	localObject8	Object
    //   242	228	11	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   87	102	357	finally
    //   359	362	357	finally
    //   110	124	365	finally
    //   129	147	365	finally
    //   147	150	365	finally
    //   367	370	365	finally
    //   252	307	467	finally
    //   312	321	467	finally
    //   321	324	467	finally
    //   469	472	467	finally
    //   232	244	475	finally
    //   249	252	475	finally
    //   324	327	475	finally
    //   472	475	475	finally
    //   477	480	475	finally
    //   224	232	483	finally
    //   327	330	483	finally
    //   480	483	483	finally
    //   485	488	483	finally
  }
  
  public Movie getMovie(int paramInt)
  {
    Object localObject = getReplacement(paramInt);
    if ((localObject instanceof XResForwarder)) {
      return ((XResForwarder)localObject).getResources().getMovie(((XResForwarder)localObject).getId());
    }
    return super.getMovie(paramInt);
  }
  
  public String getPackageName()
  {
    return this.mPackageName;
  }
  
  public CharSequence getQuantityText(int paramInt1, int paramInt2)
  {
    Object localObject = getReplacement(paramInt1);
    if ((localObject instanceof XResForwarder)) {
      return ((XResForwarder)localObject).getResources().getQuantityText(((XResForwarder)localObject).getId(), paramInt2);
    }
    return super.getQuantityText(paramInt1, paramInt2);
  }
  
  public String[] getStringArray(int paramInt)
  {
    Object localObject = getReplacement(paramInt);
    if ((localObject instanceof String[])) {
      return (String[])localObject;
    }
    if ((localObject instanceof XResForwarder)) {
      return ((XResForwarder)localObject).getResources().getStringArray(((XResForwarder)localObject).getId());
    }
    return super.getStringArray(paramInt);
  }
  
  public CharSequence getText(int paramInt)
  {
    Object localObject = getReplacement(paramInt);
    if ((localObject instanceof CharSequence)) {
      return (CharSequence)localObject;
    }
    if ((localObject instanceof XResForwarder)) {
      return ((XResForwarder)localObject).getResources().getText(((XResForwarder)localObject).getId());
    }
    return super.getText(paramInt);
  }
  
  public CharSequence getText(int paramInt, CharSequence paramCharSequence)
  {
    Object localObject = getReplacement(paramInt);
    if ((localObject instanceof CharSequence)) {
      return (CharSequence)localObject;
    }
    if ((localObject instanceof XResForwarder)) {
      return ((XResForwarder)localObject).getResources().getText(((XResForwarder)localObject).getId(), paramCharSequence);
    }
    return super.getText(paramInt, paramCharSequence);
  }
  
  public CharSequence[] getTextArray(int paramInt)
  {
    Object localObject = getReplacement(paramInt);
    if ((localObject instanceof CharSequence[])) {
      return (CharSequence[])localObject;
    }
    if ((localObject instanceof XResForwarder)) {
      return ((XResForwarder)localObject).getResources().getTextArray(((XResForwarder)localObject).getId());
    }
    return super.getTextArray(paramInt);
  }
  
  public XmlResourceParser getXml(int paramInt)
  {
    Object localObject = getReplacement(paramInt);
    if ((localObject instanceof XResForwarder))
    {
      Resources localResources = ((XResForwarder)localObject).getResources();
      paramInt = ((XResForwarder)localObject).getId();
      boolean bool = isXmlCached(localResources, paramInt);
      localObject = localResources.getXml(paramInt);
      if (!bool) {
        if (Build.VERSION.SDK_INT < 21) {
          break label80;
        }
      }
      label80:
      for (long l = XposedHelpers.getLongField(localObject, "mParseState");; l = XposedHelpers.getIntField(localObject, "mParseState"))
      {
        rewriteXmlReferencesNative(l, this, localResources);
        return localObject;
      }
    }
    return super.getXml(paramInt);
  }
  
  public XC_LayoutInflated.Unhook hookLayout(int paramInt, XC_LayoutInflated paramXC_LayoutInflated)
  {
    return hookLayoutInternal(this.mResDir, paramInt, getResourceNames(paramInt), paramXC_LayoutInflated);
  }
  
  @Deprecated
  public XC_LayoutInflated.Unhook hookLayout(String paramString, XC_LayoutInflated paramXC_LayoutInflated)
  {
    int i = getIdentifier(paramString, null, null);
    if (i == 0) {
      throw new Resources.NotFoundException(paramString);
    }
    return hookLayout(i, paramXC_LayoutInflated);
  }
  
  public XC_LayoutInflated.Unhook hookLayout(String paramString1, String paramString2, String paramString3, XC_LayoutInflated paramXC_LayoutInflated)
  {
    int i = getIdentifier(paramString3, paramString2, paramString1);
    if (i == 0) {
      throw new Resources.NotFoundException(paramString1 + ":" + paramString2 + "/" + paramString3);
    }
    return hookLayout(i, paramXC_LayoutInflated);
  }
  
  public void initObject(String paramString)
  {
    if (this.mIsObjectInited) {
      throw new IllegalStateException("Object has already been initialized");
    }
    this.mResDir = paramString;
    this.mPackageName = getPackageName(paramString);
    if (paramString != null) {}
    synchronized (sReplacementsCacheMap)
    {
      this.mReplacementsCache = ((byte[])sReplacementsCacheMap.get(paramString));
      if (this.mReplacementsCache == null)
      {
        this.mReplacementsCache = new byte[''];
        sReplacementsCacheMap.put(paramString, this.mReplacementsCache);
      }
      this.mIsObjectInited = true;
      return;
    }
  }
  
  public boolean isFirstLoad()
  {
    int i = 0;
    synchronized (sReplacements)
    {
      if (this.mResDir == null) {
        return false;
      }
      Long localLong1 = Long.valueOf(new File(this.mResDir).lastModified());
      Long localLong2 = (Long)sResDirLastModified.get(this.mResDir);
      if (localLong1.equals(localLong2)) {
        return false;
      }
      sResDirLastModified.put(this.mResDir, localLong1);
      if (localLong2 == null) {
        return true;
      }
      while (i < sReplacements.size())
      {
        ((HashMap)sReplacements.valueAt(i)).remove(this.mResDir);
        i += 1;
      }
      Arrays.fill(this.mReplacementsCache, (byte)0);
      return true;
    }
  }
  
  public void setReplacement(int paramInt, Object paramObject)
  {
    setReplacement(paramInt, paramObject, this);
  }
  
  @Deprecated
  public void setReplacement(String paramString, Object paramObject)
  {
    int i = getIdentifier(paramString, null, null);
    if (i == 0) {
      throw new Resources.NotFoundException(paramString);
    }
    setReplacement(i, paramObject, this);
  }
  
  public void setReplacement(String paramString1, String paramString2, String paramString3, Object paramObject)
  {
    int i = getIdentifier(paramString3, paramString2, paramString1);
    if (i == 0) {
      throw new Resources.NotFoundException(paramString1 + ":" + paramString2 + "/" + paramString3);
    }
    setReplacement(i, paramObject, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     android.content.res.XResources
 * JD-Core Version:    0.7.0.1
 */