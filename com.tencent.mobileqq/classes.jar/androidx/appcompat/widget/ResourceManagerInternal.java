package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.resources.R.drawable;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ResourceManagerInternal
{
  private static final ResourceManagerInternal.ColorFilterLruCache COLOR_FILTER_CACHE = new ResourceManagerInternal.ColorFilterLruCache(6);
  private static final boolean DEBUG = false;
  private static final PorterDuff.Mode DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
  private static ResourceManagerInternal INSTANCE;
  private static final String PLATFORM_VD_CLAZZ = "android.graphics.drawable.VectorDrawable";
  private static final String SKIP_DRAWABLE_TAG = "appcompat_skip_skip";
  private static final String TAG = "ResourceManagerInternal";
  private SimpleArrayMap<String, ResourceManagerInternal.InflateDelegate> mDelegates;
  private final WeakHashMap<Context, LongSparseArray<WeakReference<Drawable.ConstantState>>> mDrawableCaches = new WeakHashMap(0);
  private boolean mHasCheckedVectorDrawableSetup;
  private ResourceManagerInternal.ResourceManagerHooks mHooks;
  private SparseArrayCompat<String> mKnownDrawableIdTags;
  private WeakHashMap<Context, SparseArrayCompat<ColorStateList>> mTintLists;
  private TypedValue mTypedValue;
  
  private void addDelegate(@NonNull String paramString, @NonNull ResourceManagerInternal.InflateDelegate paramInflateDelegate)
  {
    if (this.mDelegates == null) {
      this.mDelegates = new SimpleArrayMap();
    }
    this.mDelegates.put(paramString, paramInflateDelegate);
  }
  
  private boolean addDrawableToCache(@NonNull Context paramContext, long paramLong, @NonNull Drawable paramDrawable)
  {
    try
    {
      Drawable.ConstantState localConstantState = paramDrawable.getConstantState();
      if (localConstantState != null)
      {
        LongSparseArray localLongSparseArray = (LongSparseArray)this.mDrawableCaches.get(paramContext);
        paramDrawable = localLongSparseArray;
        if (localLongSparseArray == null)
        {
          paramDrawable = new LongSparseArray();
          this.mDrawableCaches.put(paramContext, paramDrawable);
        }
        paramDrawable.put(paramLong, new WeakReference(localConstantState));
        return true;
      }
      return false;
    }
    finally {}
  }
  
  private void addTintListToCache(@NonNull Context paramContext, @DrawableRes int paramInt, @NonNull ColorStateList paramColorStateList)
  {
    if (this.mTintLists == null) {
      this.mTintLists = new WeakHashMap();
    }
    SparseArrayCompat localSparseArrayCompat2 = (SparseArrayCompat)this.mTintLists.get(paramContext);
    SparseArrayCompat localSparseArrayCompat1 = localSparseArrayCompat2;
    if (localSparseArrayCompat2 == null)
    {
      localSparseArrayCompat1 = new SparseArrayCompat();
      this.mTintLists.put(paramContext, localSparseArrayCompat1);
    }
    localSparseArrayCompat1.append(paramInt, paramColorStateList);
  }
  
  private void checkVectorDrawableSetup(@NonNull Context paramContext)
  {
    if (this.mHasCheckedVectorDrawableSetup) {
      return;
    }
    this.mHasCheckedVectorDrawableSetup = true;
    paramContext = getDrawable(paramContext, R.drawable.abc_vector_test);
    if ((paramContext != null) && (isVectorDrawable(paramContext))) {
      return;
    }
    this.mHasCheckedVectorDrawableSetup = false;
    throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
  }
  
  private static long createCacheKey(TypedValue paramTypedValue)
  {
    return paramTypedValue.assetCookie << 32 | paramTypedValue.data;
  }
  
  private Drawable createDrawableIfNeeded(@NonNull Context paramContext, @DrawableRes int paramInt)
  {
    if (this.mTypedValue == null) {
      this.mTypedValue = new TypedValue();
    }
    TypedValue localTypedValue = this.mTypedValue;
    paramContext.getResources().getValue(paramInt, localTypedValue, true);
    long l = createCacheKey(localTypedValue);
    Object localObject = getCachedDrawable(paramContext, l);
    if (localObject != null) {
      return localObject;
    }
    localObject = this.mHooks;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((ResourceManagerInternal.ResourceManagerHooks)localObject).createDrawableFor(this, paramContext, paramInt);
    }
    if (localObject != null)
    {
      ((Drawable)localObject).setChangingConfigurations(localTypedValue.changingConfigurations);
      addDrawableToCache(paramContext, l, (Drawable)localObject);
    }
    return localObject;
  }
  
  private static PorterDuffColorFilter createTintFilter(ColorStateList paramColorStateList, PorterDuff.Mode paramMode, int[] paramArrayOfInt)
  {
    if ((paramColorStateList != null) && (paramMode != null)) {
      return getPorterDuffColorFilter(paramColorStateList.getColorForState(paramArrayOfInt, 0), paramMode);
    }
    return null;
  }
  
  public static ResourceManagerInternal get()
  {
    try
    {
      if (INSTANCE == null)
      {
        INSTANCE = new ResourceManagerInternal();
        installDefaultInflateDelegates(INSTANCE);
      }
      ResourceManagerInternal localResourceManagerInternal = INSTANCE;
      return localResourceManagerInternal;
    }
    finally {}
  }
  
  private Drawable getCachedDrawable(@NonNull Context paramContext, long paramLong)
  {
    try
    {
      LongSparseArray localLongSparseArray = (LongSparseArray)this.mDrawableCaches.get(paramContext);
      if (localLongSparseArray == null) {
        return null;
      }
      Object localObject = (WeakReference)localLongSparseArray.get(paramLong);
      if (localObject != null)
      {
        localObject = (Drawable.ConstantState)((WeakReference)localObject).get();
        if (localObject != null)
        {
          paramContext = ((Drawable.ConstantState)localObject).newDrawable(paramContext.getResources());
          return paramContext;
        }
        localLongSparseArray.remove(paramLong);
      }
      return null;
    }
    finally {}
  }
  
  public static PorterDuffColorFilter getPorterDuffColorFilter(int paramInt, PorterDuff.Mode paramMode)
  {
    try
    {
      PorterDuffColorFilter localPorterDuffColorFilter2 = COLOR_FILTER_CACHE.get(paramInt, paramMode);
      PorterDuffColorFilter localPorterDuffColorFilter1 = localPorterDuffColorFilter2;
      if (localPorterDuffColorFilter2 == null)
      {
        localPorterDuffColorFilter1 = new PorterDuffColorFilter(paramInt, paramMode);
        COLOR_FILTER_CACHE.put(paramInt, paramMode, localPorterDuffColorFilter1);
      }
      return localPorterDuffColorFilter1;
    }
    finally {}
  }
  
  private ColorStateList getTintListFromCache(@NonNull Context paramContext, @DrawableRes int paramInt)
  {
    WeakHashMap localWeakHashMap = this.mTintLists;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localWeakHashMap != null)
    {
      paramContext = (SparseArrayCompat)localWeakHashMap.get(paramContext);
      localObject1 = localObject2;
      if (paramContext != null) {
        localObject1 = (ColorStateList)paramContext.get(paramInt);
      }
    }
    return localObject1;
  }
  
  private static void installDefaultInflateDelegates(@NonNull ResourceManagerInternal paramResourceManagerInternal)
  {
    if (Build.VERSION.SDK_INT < 24)
    {
      paramResourceManagerInternal.addDelegate("vector", new ResourceManagerInternal.VdcInflateDelegate());
      paramResourceManagerInternal.addDelegate("animated-vector", new ResourceManagerInternal.AvdcInflateDelegate());
      paramResourceManagerInternal.addDelegate("animated-selector", new ResourceManagerInternal.AsldcInflateDelegate());
    }
  }
  
  private static boolean isVectorDrawable(@NonNull Drawable paramDrawable)
  {
    return ((paramDrawable instanceof VectorDrawableCompat)) || ("android.graphics.drawable.VectorDrawable".equals(paramDrawable.getClass().getName()));
  }
  
  private Drawable loadDrawableFromDelegates(@NonNull Context paramContext, @DrawableRes int paramInt)
  {
    Object localObject1 = this.mDelegates;
    if ((localObject1 != null) && (!((SimpleArrayMap)localObject1).isEmpty()))
    {
      localObject1 = this.mKnownDrawableIdTags;
      if (localObject1 != null)
      {
        localObject1 = (String)((SparseArrayCompat)localObject1).get(paramInt);
        if (("appcompat_skip_skip".equals(localObject1)) || ((localObject1 != null) && (this.mDelegates.get(localObject1) == null))) {
          return null;
        }
      }
      else
      {
        this.mKnownDrawableIdTags = new SparseArrayCompat();
      }
      if (this.mTypedValue == null) {
        this.mTypedValue = new TypedValue();
      }
      TypedValue localTypedValue = this.mTypedValue;
      localObject1 = paramContext.getResources();
      ((Resources)localObject1).getValue(paramInt, localTypedValue, true);
      long l = createCacheKey(localTypedValue);
      Drawable localDrawable = getCachedDrawable(paramContext, l);
      if (localDrawable != null) {
        return localDrawable;
      }
      Object localObject2 = localDrawable;
      if (localTypedValue.string != null)
      {
        localObject2 = localDrawable;
        if (localTypedValue.string.toString().endsWith(".xml"))
        {
          localObject2 = localDrawable;
          try
          {
            XmlResourceParser localXmlResourceParser = ((Resources)localObject1).getXml(paramInt);
            localObject2 = localDrawable;
            AttributeSet localAttributeSet = Xml.asAttributeSet(localXmlResourceParser);
            int i;
            do
            {
              localObject2 = localDrawable;
              i = localXmlResourceParser.next();
            } while ((i != 2) && (i != 1));
            if (i == 2)
            {
              localObject2 = localDrawable;
              localObject1 = localXmlResourceParser.getName();
              localObject2 = localDrawable;
              this.mKnownDrawableIdTags.append(paramInt, localObject1);
              localObject2 = localDrawable;
              ResourceManagerInternal.InflateDelegate localInflateDelegate = (ResourceManagerInternal.InflateDelegate)this.mDelegates.get(localObject1);
              localObject1 = localDrawable;
              if (localInflateDelegate != null)
              {
                localObject2 = localDrawable;
                localObject1 = localInflateDelegate.createFromXmlInner(paramContext, localXmlResourceParser, localAttributeSet, paramContext.getTheme());
              }
              localObject2 = localObject1;
              if (localObject1 != null)
              {
                localObject2 = localObject1;
                ((Drawable)localObject1).setChangingConfigurations(localTypedValue.changingConfigurations);
                localObject2 = localObject1;
                addDrawableToCache(paramContext, l, (Drawable)localObject1);
                localObject2 = localObject1;
              }
            }
            else
            {
              localObject2 = localDrawable;
              throw new XmlPullParserException("No start tag found");
            }
          }
          catch (Exception paramContext)
          {
            Log.e("ResourceManagerInternal", "Exception while inflating drawable", paramContext);
          }
        }
      }
      if (localObject2 == null) {
        this.mKnownDrawableIdTags.append(paramInt, "appcompat_skip_skip");
      }
      return localObject2;
    }
    return null;
  }
  
  private Drawable tintDrawable(@NonNull Context paramContext, @DrawableRes int paramInt, boolean paramBoolean, @NonNull Drawable paramDrawable)
  {
    Object localObject = getTintList(paramContext, paramInt);
    if (localObject != null)
    {
      paramContext = paramDrawable;
      if (DrawableUtils.canSafelyMutateDrawable(paramDrawable)) {
        paramContext = paramDrawable.mutate();
      }
      paramContext = DrawableCompat.wrap(paramContext);
      DrawableCompat.setTintList(paramContext, (ColorStateList)localObject);
      paramDrawable = getTintMode(paramInt);
      localObject = paramContext;
      if (paramDrawable != null)
      {
        DrawableCompat.setTintMode(paramContext, paramDrawable);
        return paramContext;
      }
    }
    else
    {
      localObject = this.mHooks;
      if ((localObject != null) && (((ResourceManagerInternal.ResourceManagerHooks)localObject).tintDrawable(paramContext, paramInt, paramDrawable))) {
        return paramDrawable;
      }
      localObject = paramDrawable;
      if (!tintDrawableUsingColorFilter(paramContext, paramInt, paramDrawable))
      {
        localObject = paramDrawable;
        if (paramBoolean) {
          localObject = null;
        }
      }
    }
    return localObject;
  }
  
  static void tintDrawable(Drawable paramDrawable, TintInfo paramTintInfo, int[] paramArrayOfInt)
  {
    if ((DrawableUtils.canSafelyMutateDrawable(paramDrawable)) && (paramDrawable.mutate() != paramDrawable))
    {
      Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
      return;
    }
    if ((!paramTintInfo.mHasTintList) && (!paramTintInfo.mHasTintMode))
    {
      paramDrawable.clearColorFilter();
    }
    else
    {
      ColorStateList localColorStateList;
      if (paramTintInfo.mHasTintList) {
        localColorStateList = paramTintInfo.mTintList;
      } else {
        localColorStateList = null;
      }
      if (paramTintInfo.mHasTintMode) {
        paramTintInfo = paramTintInfo.mTintMode;
      } else {
        paramTintInfo = DEFAULT_MODE;
      }
      paramDrawable.setColorFilter(createTintFilter(localColorStateList, paramTintInfo, paramArrayOfInt));
    }
    if (Build.VERSION.SDK_INT <= 23) {
      paramDrawable.invalidateSelf();
    }
  }
  
  public Drawable getDrawable(@NonNull Context paramContext, @DrawableRes int paramInt)
  {
    try
    {
      paramContext = getDrawable(paramContext, paramInt, false);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  Drawable getDrawable(@NonNull Context paramContext, @DrawableRes int paramInt, boolean paramBoolean)
  {
    try
    {
      checkVectorDrawableSetup(paramContext);
      Object localObject2 = loadDrawableFromDelegates(paramContext, paramInt);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = createDrawableIfNeeded(paramContext, paramInt);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = ContextCompat.getDrawable(paramContext, paramInt);
      }
      localObject1 = localObject2;
      if (localObject2 != null) {
        localObject1 = tintDrawable(paramContext, paramInt, paramBoolean, (Drawable)localObject2);
      }
      if (localObject1 != null) {
        DrawableUtils.fixDrawable((Drawable)localObject1);
      }
      return localObject1;
    }
    finally {}
  }
  
  ColorStateList getTintList(@NonNull Context paramContext, @DrawableRes int paramInt)
  {
    try
    {
      ColorStateList localColorStateList1 = getTintListFromCache(paramContext, paramInt);
      ColorStateList localColorStateList2 = localColorStateList1;
      if (localColorStateList1 == null)
      {
        if (this.mHooks == null) {
          localColorStateList1 = null;
        } else {
          localColorStateList1 = this.mHooks.getTintListForDrawableRes(paramContext, paramInt);
        }
        localColorStateList2 = localColorStateList1;
        if (localColorStateList1 != null)
        {
          addTintListToCache(paramContext, paramInt, localColorStateList1);
          localColorStateList2 = localColorStateList1;
        }
      }
      return localColorStateList2;
    }
    finally {}
  }
  
  PorterDuff.Mode getTintMode(int paramInt)
  {
    ResourceManagerInternal.ResourceManagerHooks localResourceManagerHooks = this.mHooks;
    if (localResourceManagerHooks == null) {
      return null;
    }
    return localResourceManagerHooks.getTintModeForDrawableRes(paramInt);
  }
  
  public void onConfigurationChanged(@NonNull Context paramContext)
  {
    try
    {
      paramContext = (LongSparseArray)this.mDrawableCaches.get(paramContext);
      if (paramContext != null) {
        paramContext.clear();
      }
      return;
    }
    finally {}
  }
  
  Drawable onDrawableLoadedFromResources(@NonNull Context paramContext, @NonNull VectorEnabledTintResources paramVectorEnabledTintResources, @DrawableRes int paramInt)
  {
    try
    {
      Drawable localDrawable2 = loadDrawableFromDelegates(paramContext, paramInt);
      Drawable localDrawable1 = localDrawable2;
      if (localDrawable2 == null) {
        localDrawable1 = paramVectorEnabledTintResources.superGetDrawable(paramInt);
      }
      if (localDrawable1 != null)
      {
        paramContext = tintDrawable(paramContext, paramInt, false, localDrawable1);
        return paramContext;
      }
      return null;
    }
    finally {}
  }
  
  public void setHooks(ResourceManagerInternal.ResourceManagerHooks paramResourceManagerHooks)
  {
    try
    {
      this.mHooks = paramResourceManagerHooks;
      return;
    }
    finally
    {
      paramResourceManagerHooks = finally;
      throw paramResourceManagerHooks;
    }
  }
  
  boolean tintDrawableUsingColorFilter(@NonNull Context paramContext, @DrawableRes int paramInt, @NonNull Drawable paramDrawable)
  {
    ResourceManagerInternal.ResourceManagerHooks localResourceManagerHooks = this.mHooks;
    return (localResourceManagerHooks != null) && (localResourceManagerHooks.tintDrawableUsingColorFilter(paramContext, paramInt, paramDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.ResourceManagerInternal
 * JD-Core Version:    0.7.0.1
 */