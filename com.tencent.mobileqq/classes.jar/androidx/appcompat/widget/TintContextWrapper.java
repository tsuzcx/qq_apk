package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TintContextWrapper
  extends ContextWrapper
{
  private static final Object CACHE_LOCK = new Object();
  private static ArrayList<WeakReference<TintContextWrapper>> sCache;
  private final Resources mResources;
  private final Resources.Theme mTheme;
  
  private TintContextWrapper(@NonNull Context paramContext)
  {
    super(paramContext);
    if (VectorEnabledTintResources.shouldBeUsed())
    {
      this.mResources = new VectorEnabledTintResources(this, paramContext.getResources());
      this.mTheme = this.mResources.newTheme();
      this.mTheme.setTo(paramContext.getTheme());
      return;
    }
    this.mResources = new TintResources(this, paramContext.getResources());
    this.mTheme = null;
  }
  
  private static boolean shouldWrap(@NonNull Context paramContext)
  {
    boolean bool3 = paramContext instanceof TintContextWrapper;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (!(paramContext.getResources() instanceof TintResources))
      {
        if ((paramContext.getResources() instanceof VectorEnabledTintResources)) {
          return false;
        }
        if (Build.VERSION.SDK_INT >= 21)
        {
          bool1 = bool2;
          if (!VectorEnabledTintResources.shouldBeUsed()) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static Context wrap(@NonNull Context paramContext)
  {
    if (shouldWrap(paramContext)) {}
    for (;;)
    {
      int i;
      synchronized (CACHE_LOCK)
      {
        if (sCache == null)
        {
          sCache = new ArrayList();
        }
        else
        {
          i = sCache.size() - 1;
          if (i >= 0)
          {
            localObject1 = (WeakReference)sCache.get(i);
            if ((localObject1 != null) && (((WeakReference)localObject1).get() != null)) {
              break label168;
            }
            sCache.remove(i);
            break label168;
          }
          i = sCache.size() - 1;
          if (i >= 0)
          {
            localObject1 = (WeakReference)sCache.get(i);
            if (localObject1 == null) {
              break label175;
            }
            localObject1 = (TintContextWrapper)((WeakReference)localObject1).get();
            if ((localObject1 == null) || (((TintContextWrapper)localObject1).getBaseContext() != paramContext)) {
              break label180;
            }
            return localObject1;
          }
        }
        paramContext = new TintContextWrapper(paramContext);
        sCache.add(new WeakReference(paramContext));
        return paramContext;
      }
      return paramContext;
      label168:
      i -= 1;
      continue;
      label175:
      Object localObject1 = null;
      continue;
      label180:
      i -= 1;
    }
  }
  
  public AssetManager getAssets()
  {
    return this.mResources.getAssets();
  }
  
  public Resources getResources()
  {
    return this.mResources;
  }
  
  public Resources.Theme getTheme()
  {
    Resources.Theme localTheme2 = this.mTheme;
    Resources.Theme localTheme1 = localTheme2;
    if (localTheme2 == null) {
      localTheme1 = super.getTheme();
    }
    return localTheme1;
  }
  
  public void setTheme(int paramInt)
  {
    Resources.Theme localTheme = this.mTheme;
    if (localTheme == null)
    {
      super.setTheme(paramInt);
      return;
    }
    localTheme.applyStyle(paramInt, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.TintContextWrapper
 * JD-Core Version:    0.7.0.1
 */