package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.color;
import androidx.appcompat.R.id;
import androidx.appcompat.R.layout;
import androidx.appcompat.R.style;
import androidx.appcompat.R.styleable;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ActionMode.Callback;
import androidx.appcompat.view.StandaloneActionMode;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuBuilder.Callback;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorContentParent;
import androidx.appcompat.widget.FitWindowsViewGroup;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.ViewUtils;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NavUtils;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat.ThemeCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.KeyEventDispatcher.Component;
import androidx.core.view.LayoutInflaterCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.PopupWindowCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleOwner;
import java.lang.reflect.Constructor;
import org.xmlpull.v1.XmlPullParser;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
class AppCompatDelegateImpl
  extends AppCompatDelegate
  implements LayoutInflater.Factory2, MenuBuilder.Callback
{
  static final String EXCEPTION_HANDLER_MESSAGE_SUFFIX = ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.";
  private static final boolean IS_PRE_LOLLIPOP;
  private static final boolean sCanApplyOverrideConfiguration;
  private static final boolean sCanReturnDifferentContext;
  private static boolean sInstalledExceptionHandler;
  private static final SimpleArrayMap<String, Integer> sLocalNightModes = new SimpleArrayMap();
  private static final int[] sWindowBackgroundStyleable;
  ActionBar mActionBar;
  private AppCompatDelegateImpl.ActionMenuPresenterCallback mActionMenuPresenterCallback;
  ActionMode mActionMode;
  PopupWindow mActionModePopup;
  ActionBarContextView mActionModeView;
  private boolean mActivityHandlesUiMode;
  private boolean mActivityHandlesUiModeChecked;
  final AppCompatCallback mAppCompatCallback;
  private AppCompatViewInflater mAppCompatViewInflater;
  private AppCompatDelegateImpl.AppCompatWindowCallback mAppCompatWindowCallback;
  private AppCompatDelegateImpl.AutoNightModeManager mAutoBatteryNightModeManager;
  private AppCompatDelegateImpl.AutoNightModeManager mAutoTimeNightModeManager;
  private boolean mBaseContextAttached;
  private boolean mClosingActionMenu;
  final Context mContext;
  private boolean mCreated;
  private DecorContentParent mDecorContentParent;
  private boolean mEnableDefaultActionBarUp;
  ViewPropertyAnimatorCompat mFadeAnim = null;
  private boolean mFeatureIndeterminateProgress;
  private boolean mFeatureProgress;
  private boolean mHandleNativeActionModes = true;
  boolean mHasActionBar;
  final Object mHost;
  int mInvalidatePanelMenuFeatures;
  boolean mInvalidatePanelMenuPosted;
  private final Runnable mInvalidatePanelMenuRunnable = new AppCompatDelegateImpl.2(this);
  boolean mIsDestroyed;
  boolean mIsFloating;
  private int mLocalNightMode = -100;
  private boolean mLongPressBackDown;
  MenuInflater mMenuInflater;
  boolean mOverlayActionBar;
  boolean mOverlayActionMode;
  private AppCompatDelegateImpl.PanelMenuPresenterCallback mPanelMenuPresenterCallback;
  private AppCompatDelegateImpl.PanelFeatureState[] mPanels;
  private AppCompatDelegateImpl.PanelFeatureState mPreparedPanel;
  Runnable mShowActionModePopup;
  private boolean mStarted;
  private View mStatusGuard;
  ViewGroup mSubDecor;
  private boolean mSubDecorInstalled;
  private Rect mTempRect1;
  private Rect mTempRect2;
  private int mThemeResId;
  private CharSequence mTitle;
  private TextView mTitleView;
  Window mWindow;
  boolean mWindowNoTitle;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool2 = false;
    if (i < 21) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    IS_PRE_LOLLIPOP = bool1;
    sWindowBackgroundStyleable = new int[] { 16842836 };
    sCanReturnDifferentContext = "robolectric".equals(Build.FINGERPRINT) ^ true;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 17) {
      bool1 = true;
    }
    sCanApplyOverrideConfiguration = bool1;
    if ((IS_PRE_LOLLIPOP) && (!sInstalledExceptionHandler))
    {
      Thread.setDefaultUncaughtExceptionHandler(new AppCompatDelegateImpl.1(Thread.getDefaultUncaughtExceptionHandler()));
      sInstalledExceptionHandler = true;
    }
  }
  
  AppCompatDelegateImpl(Activity paramActivity, AppCompatCallback paramAppCompatCallback)
  {
    this(paramActivity, null, paramAppCompatCallback, paramActivity);
  }
  
  AppCompatDelegateImpl(Dialog paramDialog, AppCompatCallback paramAppCompatCallback)
  {
    this(paramDialog.getContext(), paramDialog.getWindow(), paramAppCompatCallback, paramDialog);
  }
  
  AppCompatDelegateImpl(Context paramContext, Activity paramActivity, AppCompatCallback paramAppCompatCallback)
  {
    this(paramContext, null, paramAppCompatCallback, paramActivity);
  }
  
  AppCompatDelegateImpl(Context paramContext, Window paramWindow, AppCompatCallback paramAppCompatCallback)
  {
    this(paramContext, paramWindow, paramAppCompatCallback, paramContext);
  }
  
  private AppCompatDelegateImpl(Context paramContext, Window paramWindow, AppCompatCallback paramAppCompatCallback, Object paramObject)
  {
    this.mContext = paramContext;
    this.mAppCompatCallback = paramAppCompatCallback;
    this.mHost = paramObject;
    if ((this.mLocalNightMode == -100) && ((this.mHost instanceof Dialog)))
    {
      paramContext = tryUnwrapContext();
      if (paramContext != null) {
        this.mLocalNightMode = paramContext.getDelegate().getLocalNightMode();
      }
    }
    if (this.mLocalNightMode == -100)
    {
      paramContext = (Integer)sLocalNightModes.get(this.mHost.getClass().getName());
      if (paramContext != null)
      {
        this.mLocalNightMode = paramContext.intValue();
        sLocalNightModes.remove(this.mHost.getClass().getName());
      }
    }
    if (paramWindow != null) {
      attachToWindow(paramWindow);
    }
    AppCompatDrawableManager.preload();
  }
  
  private boolean applyDayNight(boolean paramBoolean)
  {
    if (this.mIsDestroyed) {
      return false;
    }
    int i = calculateNightMode();
    paramBoolean = updateForNightMode(mapNightMode(this.mContext, i), paramBoolean);
    if (i == 0)
    {
      getAutoTimeNightModeManager(this.mContext).setup();
    }
    else
    {
      localAutoNightModeManager = this.mAutoTimeNightModeManager;
      if (localAutoNightModeManager != null) {
        localAutoNightModeManager.cleanup();
      }
    }
    if (i == 3)
    {
      getAutoBatteryNightModeManager(this.mContext).setup();
      return paramBoolean;
    }
    AppCompatDelegateImpl.AutoNightModeManager localAutoNightModeManager = this.mAutoBatteryNightModeManager;
    if (localAutoNightModeManager != null) {
      localAutoNightModeManager.cleanup();
    }
    return paramBoolean;
  }
  
  private void applyFixedSizeWindow()
  {
    ContentFrameLayout localContentFrameLayout = (ContentFrameLayout)this.mSubDecor.findViewById(16908290);
    Object localObject = this.mWindow.getDecorView();
    localContentFrameLayout.setDecorPadding(((View)localObject).getPaddingLeft(), ((View)localObject).getPaddingTop(), ((View)localObject).getPaddingRight(), ((View)localObject).getPaddingBottom());
    localObject = this.mContext.obtainStyledAttributes(R.styleable.AppCompatTheme);
    ((TypedArray)localObject).getValue(R.styleable.AppCompatTheme_windowMinWidthMajor, localContentFrameLayout.getMinWidthMajor());
    ((TypedArray)localObject).getValue(R.styleable.AppCompatTheme_windowMinWidthMinor, localContentFrameLayout.getMinWidthMinor());
    if (((TypedArray)localObject).hasValue(R.styleable.AppCompatTheme_windowFixedWidthMajor)) {
      ((TypedArray)localObject).getValue(R.styleable.AppCompatTheme_windowFixedWidthMajor, localContentFrameLayout.getFixedWidthMajor());
    }
    if (((TypedArray)localObject).hasValue(R.styleable.AppCompatTheme_windowFixedWidthMinor)) {
      ((TypedArray)localObject).getValue(R.styleable.AppCompatTheme_windowFixedWidthMinor, localContentFrameLayout.getFixedWidthMinor());
    }
    if (((TypedArray)localObject).hasValue(R.styleable.AppCompatTheme_windowFixedHeightMajor)) {
      ((TypedArray)localObject).getValue(R.styleable.AppCompatTheme_windowFixedHeightMajor, localContentFrameLayout.getFixedHeightMajor());
    }
    if (((TypedArray)localObject).hasValue(R.styleable.AppCompatTheme_windowFixedHeightMinor)) {
      ((TypedArray)localObject).getValue(R.styleable.AppCompatTheme_windowFixedHeightMinor, localContentFrameLayout.getFixedHeightMinor());
    }
    ((TypedArray)localObject).recycle();
    localContentFrameLayout.requestLayout();
  }
  
  private void attachToWindow(@NonNull Window paramWindow)
  {
    if (this.mWindow == null)
    {
      Object localObject = paramWindow.getCallback();
      if (!(localObject instanceof AppCompatDelegateImpl.AppCompatWindowCallback))
      {
        this.mAppCompatWindowCallback = new AppCompatDelegateImpl.AppCompatWindowCallback(this, (Window.Callback)localObject);
        paramWindow.setCallback(this.mAppCompatWindowCallback);
        localObject = TintTypedArray.obtainStyledAttributes(this.mContext, null, sWindowBackgroundStyleable);
        Drawable localDrawable = ((TintTypedArray)localObject).getDrawableIfKnown(0);
        if (localDrawable != null) {
          paramWindow.setBackgroundDrawable(localDrawable);
        }
        ((TintTypedArray)localObject).recycle();
        this.mWindow = paramWindow;
        return;
      }
      throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }
    throw new IllegalStateException("AppCompat has already installed itself into the Window");
  }
  
  private int calculateNightMode()
  {
    int i = this.mLocalNightMode;
    if (i != -100) {
      return i;
    }
    return getDefaultNightMode();
  }
  
  private void cleanupAutoManagers()
  {
    AppCompatDelegateImpl.AutoNightModeManager localAutoNightModeManager = this.mAutoTimeNightModeManager;
    if (localAutoNightModeManager != null) {
      localAutoNightModeManager.cleanup();
    }
    localAutoNightModeManager = this.mAutoBatteryNightModeManager;
    if (localAutoNightModeManager != null) {
      localAutoNightModeManager.cleanup();
    }
  }
  
  @NonNull
  private Configuration createOverrideConfigurationForDayNight(@NonNull Context paramContext, int paramInt, @Nullable Configuration paramConfiguration)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        paramInt = paramContext.getApplicationContext().getResources().getConfiguration().uiMode & 0x30;
      } else {
        paramInt = 32;
      }
    }
    else {
      paramInt = 16;
    }
    paramContext = new Configuration();
    paramContext.fontScale = 0.0F;
    if (paramConfiguration != null) {
      paramContext.setTo(paramConfiguration);
    }
    paramContext.uiMode = (paramInt | paramContext.uiMode & 0xFFFFFFCF);
    return paramContext;
  }
  
  private ViewGroup createSubDecor()
  {
    Object localObject1 = this.mContext.obtainStyledAttributes(R.styleable.AppCompatTheme);
    if (((TypedArray)localObject1).hasValue(R.styleable.AppCompatTheme_windowActionBar))
    {
      if (((TypedArray)localObject1).getBoolean(R.styleable.AppCompatTheme_windowNoTitle, false)) {
        requestWindowFeature(1);
      } else if (((TypedArray)localObject1).getBoolean(R.styleable.AppCompatTheme_windowActionBar, false)) {
        requestWindowFeature(108);
      }
      if (((TypedArray)localObject1).getBoolean(R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
        requestWindowFeature(109);
      }
      if (((TypedArray)localObject1).getBoolean(R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
        requestWindowFeature(10);
      }
      this.mIsFloating = ((TypedArray)localObject1).getBoolean(R.styleable.AppCompatTheme_android_windowIsFloating, false);
      ((TypedArray)localObject1).recycle();
      ensureWindow();
      this.mWindow.getDecorView();
      localObject1 = LayoutInflater.from(this.mContext);
      Object localObject2;
      if (!this.mWindowNoTitle)
      {
        if (this.mIsFloating)
        {
          localObject1 = (ViewGroup)((LayoutInflater)localObject1).inflate(R.layout.abc_dialog_title_material, null);
          this.mOverlayActionBar = false;
          this.mHasActionBar = false;
        }
        else if (this.mHasActionBar)
        {
          localObject1 = new TypedValue();
          this.mContext.getTheme().resolveAttribute(R.attr.actionBarTheme, (TypedValue)localObject1, true);
          if (((TypedValue)localObject1).resourceId != 0) {
            localObject1 = new androidx.appcompat.view.ContextThemeWrapper(this.mContext, ((TypedValue)localObject1).resourceId);
          } else {
            localObject1 = this.mContext;
          }
          localObject2 = (ViewGroup)LayoutInflater.from((Context)localObject1).inflate(R.layout.abc_screen_toolbar, null);
          this.mDecorContentParent = ((DecorContentParent)((ViewGroup)localObject2).findViewById(R.id.decor_content_parent));
          this.mDecorContentParent.setWindowCallback(getWindowCallback());
          if (this.mOverlayActionBar) {
            this.mDecorContentParent.initFeature(109);
          }
          if (this.mFeatureProgress) {
            this.mDecorContentParent.initFeature(2);
          }
          localObject1 = localObject2;
          if (this.mFeatureIndeterminateProgress)
          {
            this.mDecorContentParent.initFeature(5);
            localObject1 = localObject2;
          }
        }
        else
        {
          localObject1 = null;
        }
      }
      else if (this.mOverlayActionMode) {
        localObject1 = (ViewGroup)((LayoutInflater)localObject1).inflate(R.layout.abc_screen_simple_overlay_action_mode, null);
      } else {
        localObject1 = (ViewGroup)((LayoutInflater)localObject1).inflate(R.layout.abc_screen_simple, null);
      }
      if (localObject1 != null)
      {
        if (Build.VERSION.SDK_INT >= 21) {
          ViewCompat.setOnApplyWindowInsetsListener((View)localObject1, new AppCompatDelegateImpl.3(this));
        } else if ((localObject1 instanceof FitWindowsViewGroup)) {
          ((FitWindowsViewGroup)localObject1).setOnFitSystemWindowsListener(new AppCompatDelegateImpl.4(this));
        }
        if (this.mDecorContentParent == null) {
          this.mTitleView = ((TextView)((ViewGroup)localObject1).findViewById(R.id.title));
        }
        ViewUtils.makeOptionalFitsSystemWindows((View)localObject1);
        localObject2 = (ContentFrameLayout)((ViewGroup)localObject1).findViewById(R.id.action_bar_activity_content);
        ViewGroup localViewGroup = (ViewGroup)this.mWindow.findViewById(16908290);
        if (localViewGroup != null)
        {
          while (localViewGroup.getChildCount() > 0)
          {
            View localView = localViewGroup.getChildAt(0);
            localViewGroup.removeViewAt(0);
            ((ContentFrameLayout)localObject2).addView(localView);
          }
          localViewGroup.setId(-1);
          ((ContentFrameLayout)localObject2).setId(16908290);
          if ((localViewGroup instanceof FrameLayout)) {
            ((FrameLayout)localViewGroup).setForeground(null);
          }
        }
        this.mWindow.setContentView((View)localObject1);
        ((ContentFrameLayout)localObject2).setAttachListener(new AppCompatDelegateImpl.5(this));
        return localObject1;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("AppCompat does not support the current theme features: { windowActionBar: ");
      ((StringBuilder)localObject1).append(this.mHasActionBar);
      ((StringBuilder)localObject1).append(", windowActionBarOverlay: ");
      ((StringBuilder)localObject1).append(this.mOverlayActionBar);
      ((StringBuilder)localObject1).append(", android:windowIsFloating: ");
      ((StringBuilder)localObject1).append(this.mIsFloating);
      ((StringBuilder)localObject1).append(", windowActionModeOverlay: ");
      ((StringBuilder)localObject1).append(this.mOverlayActionMode);
      ((StringBuilder)localObject1).append(", windowNoTitle: ");
      ((StringBuilder)localObject1).append(this.mWindowNoTitle);
      ((StringBuilder)localObject1).append(" }");
      throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
    }
    ((TypedArray)localObject1).recycle();
    localObject1 = new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
  
  private void ensureSubDecor()
  {
    if (!this.mSubDecorInstalled)
    {
      this.mSubDecor = createSubDecor();
      Object localObject1 = getTitle();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        Object localObject2 = this.mDecorContentParent;
        if (localObject2 != null)
        {
          ((DecorContentParent)localObject2).setWindowTitle((CharSequence)localObject1);
        }
        else if (peekSupportActionBar() != null)
        {
          peekSupportActionBar().setWindowTitle((CharSequence)localObject1);
        }
        else
        {
          localObject2 = this.mTitleView;
          if (localObject2 != null) {
            ((TextView)localObject2).setText((CharSequence)localObject1);
          }
        }
      }
      applyFixedSizeWindow();
      onSubDecorInstalled(this.mSubDecor);
      this.mSubDecorInstalled = true;
      localObject1 = getPanelState(0, false);
      if ((!this.mIsDestroyed) && ((localObject1 == null) || (((AppCompatDelegateImpl.PanelFeatureState)localObject1).menu == null))) {
        invalidatePanelMenu(108);
      }
    }
  }
  
  private void ensureWindow()
  {
    if (this.mWindow == null)
    {
      Object localObject = this.mHost;
      if ((localObject instanceof Activity)) {
        attachToWindow(((Activity)localObject).getWindow());
      }
    }
    if (this.mWindow != null) {
      return;
    }
    throw new IllegalStateException("We have not been given a Window");
  }
  
  @NonNull
  private static Configuration generateConfigDelta(@NonNull Configuration paramConfiguration1, @Nullable Configuration paramConfiguration2)
  {
    Configuration localConfiguration = new Configuration();
    localConfiguration.fontScale = 0.0F;
    if (paramConfiguration2 != null)
    {
      if (paramConfiguration1.diff(paramConfiguration2) == 0) {
        return localConfiguration;
      }
      if (paramConfiguration1.fontScale != paramConfiguration2.fontScale) {
        localConfiguration.fontScale = paramConfiguration2.fontScale;
      }
      if (paramConfiguration1.mcc != paramConfiguration2.mcc) {
        localConfiguration.mcc = paramConfiguration2.mcc;
      }
      if (paramConfiguration1.mnc != paramConfiguration2.mnc) {
        localConfiguration.mnc = paramConfiguration2.mnc;
      }
      if (Build.VERSION.SDK_INT >= 24) {
        AppCompatDelegateImpl.ConfigurationImplApi24.generateConfigDelta_locale(paramConfiguration1, paramConfiguration2, localConfiguration);
      } else if (!ObjectsCompat.equals(paramConfiguration1.locale, paramConfiguration2.locale)) {
        localConfiguration.locale = paramConfiguration2.locale;
      }
      if (paramConfiguration1.touchscreen != paramConfiguration2.touchscreen) {
        localConfiguration.touchscreen = paramConfiguration2.touchscreen;
      }
      if (paramConfiguration1.keyboard != paramConfiguration2.keyboard) {
        localConfiguration.keyboard = paramConfiguration2.keyboard;
      }
      if (paramConfiguration1.keyboardHidden != paramConfiguration2.keyboardHidden) {
        localConfiguration.keyboardHidden = paramConfiguration2.keyboardHidden;
      }
      if (paramConfiguration1.navigation != paramConfiguration2.navigation) {
        localConfiguration.navigation = paramConfiguration2.navigation;
      }
      if (paramConfiguration1.navigationHidden != paramConfiguration2.navigationHidden) {
        localConfiguration.navigationHidden = paramConfiguration2.navigationHidden;
      }
      if (paramConfiguration1.orientation != paramConfiguration2.orientation) {
        localConfiguration.orientation = paramConfiguration2.orientation;
      }
      if ((paramConfiguration1.screenLayout & 0xF) != (paramConfiguration2.screenLayout & 0xF)) {
        localConfiguration.screenLayout |= paramConfiguration2.screenLayout & 0xF;
      }
      if ((paramConfiguration1.screenLayout & 0xC0) != (paramConfiguration2.screenLayout & 0xC0)) {
        localConfiguration.screenLayout |= paramConfiguration2.screenLayout & 0xC0;
      }
      if ((paramConfiguration1.screenLayout & 0x30) != (paramConfiguration2.screenLayout & 0x30)) {
        localConfiguration.screenLayout |= paramConfiguration2.screenLayout & 0x30;
      }
      if ((paramConfiguration1.screenLayout & 0x300) != (paramConfiguration2.screenLayout & 0x300)) {
        localConfiguration.screenLayout |= paramConfiguration2.screenLayout & 0x300;
      }
      if (Build.VERSION.SDK_INT >= 26) {
        AppCompatDelegateImpl.ConfigurationImplApi26.generateConfigDelta_colorMode(paramConfiguration1, paramConfiguration2, localConfiguration);
      }
      if ((paramConfiguration1.uiMode & 0xF) != (paramConfiguration2.uiMode & 0xF)) {
        localConfiguration.uiMode |= paramConfiguration2.uiMode & 0xF;
      }
      if ((paramConfiguration1.uiMode & 0x30) != (paramConfiguration2.uiMode & 0x30)) {
        localConfiguration.uiMode |= paramConfiguration2.uiMode & 0x30;
      }
      if (paramConfiguration1.screenWidthDp != paramConfiguration2.screenWidthDp) {
        localConfiguration.screenWidthDp = paramConfiguration2.screenWidthDp;
      }
      if (paramConfiguration1.screenHeightDp != paramConfiguration2.screenHeightDp) {
        localConfiguration.screenHeightDp = paramConfiguration2.screenHeightDp;
      }
      if (paramConfiguration1.smallestScreenWidthDp != paramConfiguration2.smallestScreenWidthDp) {
        localConfiguration.smallestScreenWidthDp = paramConfiguration2.smallestScreenWidthDp;
      }
      if (Build.VERSION.SDK_INT >= 17) {
        AppCompatDelegateImpl.ConfigurationImplApi17.generateConfigDelta_densityDpi(paramConfiguration1, paramConfiguration2, localConfiguration);
      }
    }
    return localConfiguration;
  }
  
  private AppCompatDelegateImpl.AutoNightModeManager getAutoBatteryNightModeManager(@NonNull Context paramContext)
  {
    if (this.mAutoBatteryNightModeManager == null) {
      this.mAutoBatteryNightModeManager = new AppCompatDelegateImpl.AutoBatteryNightModeManager(this, paramContext);
    }
    return this.mAutoBatteryNightModeManager;
  }
  
  private AppCompatDelegateImpl.AutoNightModeManager getAutoTimeNightModeManager(@NonNull Context paramContext)
  {
    if (this.mAutoTimeNightModeManager == null) {
      this.mAutoTimeNightModeManager = new AppCompatDelegateImpl.AutoTimeNightModeManager(this, TwilightManager.getInstance(paramContext));
    }
    return this.mAutoTimeNightModeManager;
  }
  
  private void initWindowDecorActionBar()
  {
    ensureSubDecor();
    if (this.mHasActionBar)
    {
      if (this.mActionBar != null) {
        return;
      }
      Object localObject = this.mHost;
      if ((localObject instanceof Activity)) {
        this.mActionBar = new WindowDecorActionBar((Activity)localObject, this.mOverlayActionBar);
      } else if ((localObject instanceof Dialog)) {
        this.mActionBar = new WindowDecorActionBar((Dialog)localObject);
      }
      localObject = this.mActionBar;
      if (localObject != null) {
        ((ActionBar)localObject).setDefaultDisplayHomeAsUpEnabled(this.mEnableDefaultActionBarUp);
      }
    }
  }
  
  private boolean initializePanelContent(AppCompatDelegateImpl.PanelFeatureState paramPanelFeatureState)
  {
    if (paramPanelFeatureState.createdPanelView != null)
    {
      paramPanelFeatureState.shownPanelView = paramPanelFeatureState.createdPanelView;
      return true;
    }
    if (paramPanelFeatureState.menu == null) {
      return false;
    }
    if (this.mPanelMenuPresenterCallback == null) {
      this.mPanelMenuPresenterCallback = new AppCompatDelegateImpl.PanelMenuPresenterCallback(this);
    }
    paramPanelFeatureState.shownPanelView = ((View)paramPanelFeatureState.getListMenuView(this.mPanelMenuPresenterCallback));
    return paramPanelFeatureState.shownPanelView != null;
  }
  
  private boolean initializePanelDecor(AppCompatDelegateImpl.PanelFeatureState paramPanelFeatureState)
  {
    paramPanelFeatureState.setStyle(getActionBarThemedContext());
    paramPanelFeatureState.decorView = new AppCompatDelegateImpl.ListMenuDecorView(this, paramPanelFeatureState.listPresenterContext);
    paramPanelFeatureState.gravity = 81;
    return true;
  }
  
  private boolean initializePanelMenu(AppCompatDelegateImpl.PanelFeatureState paramPanelFeatureState)
  {
    Context localContext = this.mContext;
    if (paramPanelFeatureState.featureId != 0)
    {
      localObject1 = localContext;
      if (paramPanelFeatureState.featureId != 108) {}
    }
    else
    {
      localObject1 = localContext;
      if (this.mDecorContentParent != null)
      {
        TypedValue localTypedValue = new TypedValue();
        Resources.Theme localTheme = localContext.getTheme();
        localTheme.resolveAttribute(R.attr.actionBarTheme, localTypedValue, true);
        localObject1 = null;
        if (localTypedValue.resourceId != 0)
        {
          localObject1 = localContext.getResources().newTheme();
          ((Resources.Theme)localObject1).setTo(localTheme);
          ((Resources.Theme)localObject1).applyStyle(localTypedValue.resourceId, true);
          ((Resources.Theme)localObject1).resolveAttribute(R.attr.actionBarWidgetTheme, localTypedValue, true);
        }
        else
        {
          localTheme.resolveAttribute(R.attr.actionBarWidgetTheme, localTypedValue, true);
        }
        Object localObject2 = localObject1;
        if (localTypedValue.resourceId != 0)
        {
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = localContext.getResources().newTheme();
            ((Resources.Theme)localObject2).setTo(localTheme);
          }
          ((Resources.Theme)localObject2).applyStyle(localTypedValue.resourceId, true);
        }
        localObject1 = localContext;
        if (localObject2 != null)
        {
          localObject1 = new androidx.appcompat.view.ContextThemeWrapper(localContext, 0);
          ((Context)localObject1).getTheme().setTo((Resources.Theme)localObject2);
        }
      }
    }
    Object localObject1 = new MenuBuilder((Context)localObject1);
    ((MenuBuilder)localObject1).setCallback(this);
    paramPanelFeatureState.setMenu((MenuBuilder)localObject1);
    return true;
  }
  
  private void invalidatePanelMenu(int paramInt)
  {
    this.mInvalidatePanelMenuFeatures = (1 << paramInt | this.mInvalidatePanelMenuFeatures);
    if (!this.mInvalidatePanelMenuPosted)
    {
      ViewCompat.postOnAnimation(this.mWindow.getDecorView(), this.mInvalidatePanelMenuRunnable);
      this.mInvalidatePanelMenuPosted = true;
    }
  }
  
  private boolean isActivityManifestHandlingUiMode()
  {
    Object localObject;
    if ((!this.mActivityHandlesUiModeChecked) && ((this.mHost instanceof Activity)))
    {
      localObject = this.mContext.getPackageManager();
      if (localObject == null) {
        return false;
      }
    }
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 29)
        {
          i = 269221888;
        }
        else
        {
          if (Build.VERSION.SDK_INT < 24) {
            break label140;
          }
          i = 786432;
        }
        localObject = ((PackageManager)localObject).getActivityInfo(new ComponentName(this.mContext, this.mHost.getClass()), i);
        if ((localObject == null) || ((((ActivityInfo)localObject).configChanges & 0x200) == 0)) {
          break label145;
        }
        bool = true;
        this.mActivityHandlesUiMode = bool;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", localNameNotFoundException);
        this.mActivityHandlesUiMode = false;
      }
      this.mActivityHandlesUiModeChecked = true;
      return this.mActivityHandlesUiMode;
      label140:
      int i = 0;
      continue;
      label145:
      boolean bool = false;
    }
  }
  
  private boolean onKeyDownPanel(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getRepeatCount() == 0)
    {
      AppCompatDelegateImpl.PanelFeatureState localPanelFeatureState = getPanelState(paramInt, true);
      if (!localPanelFeatureState.isOpen) {
        return preparePanel(localPanelFeatureState, paramKeyEvent);
      }
    }
    return false;
  }
  
  private boolean onKeyUpPanel(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.mActionMode != null) {
      return false;
    }
    AppCompatDelegateImpl.PanelFeatureState localPanelFeatureState = getPanelState(paramInt, true);
    boolean bool;
    if (paramInt == 0)
    {
      DecorContentParent localDecorContentParent = this.mDecorContentParent;
      if ((localDecorContentParent != null) && (localDecorContentParent.canShowOverflowMenu()) && (!ViewConfiguration.get(this.mContext).hasPermanentMenuKey()))
      {
        if (!this.mDecorContentParent.isOverflowMenuShowing())
        {
          if ((this.mIsDestroyed) || (!preparePanel(localPanelFeatureState, paramKeyEvent))) {
            break label180;
          }
          bool = this.mDecorContentParent.showOverflowMenu();
          break label198;
        }
        bool = this.mDecorContentParent.hideOverflowMenu();
        break label198;
      }
    }
    if ((!localPanelFeatureState.isOpen) && (!localPanelFeatureState.isHandled))
    {
      if (localPanelFeatureState.isPrepared)
      {
        if (localPanelFeatureState.refreshMenuContent)
        {
          localPanelFeatureState.isPrepared = false;
          bool = preparePanel(localPanelFeatureState, paramKeyEvent);
        }
        else
        {
          bool = true;
        }
        if (bool)
        {
          openPanel(localPanelFeatureState, paramKeyEvent);
          bool = true;
          break label198;
        }
      }
      label180:
      bool = false;
    }
    else
    {
      bool = localPanelFeatureState.isOpen;
      closePanel(localPanelFeatureState, true);
    }
    label198:
    if (bool)
    {
      paramKeyEvent = (AudioManager)this.mContext.getApplicationContext().getSystemService("audio");
      if (paramKeyEvent != null)
      {
        paramKeyEvent.playSoundEffect(0);
        return bool;
      }
      Log.w("AppCompatDelegate", "Couldn't get audio manager");
    }
    return bool;
  }
  
  private void openPanel(AppCompatDelegateImpl.PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    if (!paramPanelFeatureState.isOpen)
    {
      if (this.mIsDestroyed) {
        return;
      }
      if (paramPanelFeatureState.featureId == 0)
      {
        if ((this.mContext.getResources().getConfiguration().screenLayout & 0xF) == 4) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          return;
        }
      }
      Object localObject = getWindowCallback();
      if ((localObject != null) && (!((Window.Callback)localObject).onMenuOpened(paramPanelFeatureState.featureId, paramPanelFeatureState.menu)))
      {
        closePanel(paramPanelFeatureState, true);
        return;
      }
      WindowManager localWindowManager = (WindowManager)this.mContext.getSystemService("window");
      if (localWindowManager == null) {
        return;
      }
      if (!preparePanel(paramPanelFeatureState, paramKeyEvent)) {
        return;
      }
      if ((paramPanelFeatureState.decorView != null) && (!paramPanelFeatureState.refreshDecorView))
      {
        if (paramPanelFeatureState.createdPanelView != null)
        {
          paramKeyEvent = paramPanelFeatureState.createdPanelView.getLayoutParams();
          if ((paramKeyEvent != null) && (paramKeyEvent.width == -1))
          {
            i = -1;
            break label339;
          }
        }
      }
      else
      {
        if (paramPanelFeatureState.decorView == null)
        {
          if ((initializePanelDecor(paramPanelFeatureState)) && (paramPanelFeatureState.decorView != null)) {}
        }
        else if ((paramPanelFeatureState.refreshDecorView) && (paramPanelFeatureState.decorView.getChildCount() > 0)) {
          paramPanelFeatureState.decorView.removeAllViews();
        }
        if ((!initializePanelContent(paramPanelFeatureState)) || (!paramPanelFeatureState.hasPanelItems())) {
          break label405;
        }
        localObject = paramPanelFeatureState.shownPanelView.getLayoutParams();
        paramKeyEvent = (KeyEvent)localObject;
        if (localObject == null) {
          paramKeyEvent = new ViewGroup.LayoutParams(-2, -2);
        }
        i = paramPanelFeatureState.background;
        paramPanelFeatureState.decorView.setBackgroundResource(i);
        localObject = paramPanelFeatureState.shownPanelView.getParent();
        if ((localObject instanceof ViewGroup)) {
          ((ViewGroup)localObject).removeView(paramPanelFeatureState.shownPanelView);
        }
        paramPanelFeatureState.decorView.addView(paramPanelFeatureState.shownPanelView, paramKeyEvent);
        if (!paramPanelFeatureState.shownPanelView.hasFocus()) {
          paramPanelFeatureState.shownPanelView.requestFocus();
        }
      }
      int i = -2;
      label339:
      paramPanelFeatureState.isHandled = false;
      paramKeyEvent = new WindowManager.LayoutParams(i, -2, paramPanelFeatureState.x, paramPanelFeatureState.y, 1002, 8519680, -3);
      paramKeyEvent.gravity = paramPanelFeatureState.gravity;
      paramKeyEvent.windowAnimations = paramPanelFeatureState.windowAnimations;
      localWindowManager.addView(paramPanelFeatureState.decorView, paramKeyEvent);
      paramPanelFeatureState.isOpen = true;
      return;
      label405:
      paramPanelFeatureState.refreshDecorView = true;
    }
  }
  
  private boolean performPanelShortcut(AppCompatDelegateImpl.PanelFeatureState paramPanelFeatureState, int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    boolean bool1 = paramKeyEvent.isSystem();
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    if (!paramPanelFeatureState.isPrepared)
    {
      bool1 = bool2;
      if (!preparePanel(paramPanelFeatureState, paramKeyEvent)) {}
    }
    else
    {
      bool1 = bool2;
      if (paramPanelFeatureState.menu != null) {
        bool1 = paramPanelFeatureState.menu.performShortcut(paramInt1, paramKeyEvent, paramInt2);
      }
    }
    if ((bool1) && ((paramInt2 & 0x1) == 0) && (this.mDecorContentParent == null)) {
      closePanel(paramPanelFeatureState, true);
    }
    return bool1;
  }
  
  private boolean preparePanel(AppCompatDelegateImpl.PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    if (this.mIsDestroyed) {
      return false;
    }
    if (paramPanelFeatureState.isPrepared) {
      return true;
    }
    Object localObject = this.mPreparedPanel;
    if ((localObject != null) && (localObject != paramPanelFeatureState)) {
      closePanel((AppCompatDelegateImpl.PanelFeatureState)localObject, false);
    }
    localObject = getWindowCallback();
    if (localObject != null) {
      paramPanelFeatureState.createdPanelView = ((Window.Callback)localObject).onCreatePanelView(paramPanelFeatureState.featureId);
    }
    int i;
    if ((paramPanelFeatureState.featureId != 0) && (paramPanelFeatureState.featureId != 108)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      DecorContentParent localDecorContentParent = this.mDecorContentParent;
      if (localDecorContentParent != null) {
        localDecorContentParent.setMenuPrepared();
      }
    }
    if ((paramPanelFeatureState.createdPanelView == null) && ((i == 0) || (!(peekSupportActionBar() instanceof ToolbarActionBar))))
    {
      if ((paramPanelFeatureState.menu == null) || (paramPanelFeatureState.refreshMenuContent))
      {
        if ((paramPanelFeatureState.menu == null) && ((!initializePanelMenu(paramPanelFeatureState)) || (paramPanelFeatureState.menu == null))) {
          return false;
        }
        if ((i != 0) && (this.mDecorContentParent != null))
        {
          if (this.mActionMenuPresenterCallback == null) {
            this.mActionMenuPresenterCallback = new AppCompatDelegateImpl.ActionMenuPresenterCallback(this);
          }
          this.mDecorContentParent.setMenu(paramPanelFeatureState.menu, this.mActionMenuPresenterCallback);
        }
        paramPanelFeatureState.menu.stopDispatchingItemsChanged();
        if (!((Window.Callback)localObject).onCreatePanelMenu(paramPanelFeatureState.featureId, paramPanelFeatureState.menu))
        {
          paramPanelFeatureState.setMenu(null);
          if (i != 0)
          {
            paramPanelFeatureState = this.mDecorContentParent;
            if (paramPanelFeatureState != null) {
              paramPanelFeatureState.setMenu(null, this.mActionMenuPresenterCallback);
            }
          }
          return false;
        }
        paramPanelFeatureState.refreshMenuContent = false;
      }
      paramPanelFeatureState.menu.stopDispatchingItemsChanged();
      if (paramPanelFeatureState.frozenActionViewState != null)
      {
        paramPanelFeatureState.menu.restoreActionViewStates(paramPanelFeatureState.frozenActionViewState);
        paramPanelFeatureState.frozenActionViewState = null;
      }
      if (!((Window.Callback)localObject).onPreparePanel(0, paramPanelFeatureState.createdPanelView, paramPanelFeatureState.menu))
      {
        if (i != 0)
        {
          paramKeyEvent = this.mDecorContentParent;
          if (paramKeyEvent != null) {
            paramKeyEvent.setMenu(null, this.mActionMenuPresenterCallback);
          }
        }
        paramPanelFeatureState.menu.startDispatchingItemsChanged();
        return false;
      }
      if (paramKeyEvent != null) {
        i = paramKeyEvent.getDeviceId();
      } else {
        i = -1;
      }
      boolean bool;
      if (KeyCharacterMap.load(i).getKeyboardType() != 1) {
        bool = true;
      } else {
        bool = false;
      }
      paramPanelFeatureState.qwertyMode = bool;
      paramPanelFeatureState.menu.setQwertyMode(paramPanelFeatureState.qwertyMode);
      paramPanelFeatureState.menu.startDispatchingItemsChanged();
    }
    paramPanelFeatureState.isPrepared = true;
    paramPanelFeatureState.isHandled = false;
    this.mPreparedPanel = paramPanelFeatureState;
    return true;
  }
  
  private void reopenMenu(boolean paramBoolean)
  {
    Object localObject = this.mDecorContentParent;
    if ((localObject != null) && (((DecorContentParent)localObject).canShowOverflowMenu()) && ((!ViewConfiguration.get(this.mContext).hasPermanentMenuKey()) || (this.mDecorContentParent.isOverflowMenuShowPending())))
    {
      localObject = getWindowCallback();
      if ((this.mDecorContentParent.isOverflowMenuShowing()) && (paramBoolean))
      {
        this.mDecorContentParent.hideOverflowMenu();
        if (!this.mIsDestroyed) {
          ((Window.Callback)localObject).onPanelClosed(108, getPanelState(0, true).menu);
        }
      }
      else if ((localObject != null) && (!this.mIsDestroyed))
      {
        if ((this.mInvalidatePanelMenuPosted) && ((this.mInvalidatePanelMenuFeatures & 0x1) != 0))
        {
          this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
          this.mInvalidatePanelMenuRunnable.run();
        }
        AppCompatDelegateImpl.PanelFeatureState localPanelFeatureState = getPanelState(0, true);
        if ((localPanelFeatureState.menu != null) && (!localPanelFeatureState.refreshMenuContent) && (((Window.Callback)localObject).onPreparePanel(0, localPanelFeatureState.createdPanelView, localPanelFeatureState.menu)))
        {
          ((Window.Callback)localObject).onMenuOpened(108, localPanelFeatureState.menu);
          this.mDecorContentParent.showOverflowMenu();
        }
      }
      return;
    }
    localObject = getPanelState(0, true);
    ((AppCompatDelegateImpl.PanelFeatureState)localObject).refreshDecorView = true;
    closePanel((AppCompatDelegateImpl.PanelFeatureState)localObject, false);
    openPanel((AppCompatDelegateImpl.PanelFeatureState)localObject, null);
  }
  
  private int sanitizeWindowFeatureId(int paramInt)
  {
    if (paramInt == 8)
    {
      Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
      return 108;
    }
    int i = paramInt;
    if (paramInt == 9)
    {
      Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
      i = 109;
    }
    return i;
  }
  
  private boolean shouldInheritContext(ViewParent paramViewParent)
  {
    if (paramViewParent == null) {
      return false;
    }
    View localView = this.mWindow.getDecorView();
    for (;;)
    {
      if (paramViewParent == null) {
        return true;
      }
      if ((paramViewParent == localView) || (!(paramViewParent instanceof View))) {
        break;
      }
      if (ViewCompat.isAttachedToWindow((View)paramViewParent)) {
        return false;
      }
      paramViewParent = paramViewParent.getParent();
    }
    return false;
  }
  
  private void throwFeatureRequestIfSubDecorInstalled()
  {
    if (!this.mSubDecorInstalled) {
      return;
    }
    throw new AndroidRuntimeException("Window feature must be requested before adding content");
  }
  
  @Nullable
  private AppCompatActivity tryUnwrapContext()
  {
    for (Context localContext = this.mContext; localContext != null; localContext = ((ContextWrapper)localContext).getBaseContext())
    {
      if ((localContext instanceof AppCompatActivity)) {
        return (AppCompatActivity)localContext;
      }
      if (!(localContext instanceof ContextWrapper)) {
        break;
      }
    }
    return null;
  }
  
  private boolean updateForNightMode(int paramInt, boolean paramBoolean)
  {
    Object localObject = createOverrideConfigurationForDayNight(this.mContext, paramInt, null);
    boolean bool2 = isActivityManifestHandlingUiMode();
    int i = this.mContext.getResources().getConfiguration().uiMode & 0x30;
    int j = ((Configuration)localObject).uiMode & 0x30;
    if ((i != j) && (paramBoolean) && (!bool2) && (this.mBaseContextAttached) && ((sCanReturnDifferentContext) || (this.mCreated)))
    {
      localObject = this.mHost;
      if (((localObject instanceof Activity)) && (!((Activity)localObject).isChild()))
      {
        ActivityCompat.recreate((Activity)this.mHost);
        paramBoolean = true;
        break label122;
      }
    }
    paramBoolean = false;
    label122:
    boolean bool1 = paramBoolean;
    if (!paramBoolean)
    {
      bool1 = paramBoolean;
      if (i != j)
      {
        updateResourcesConfigurationForNightMode(j, bool2, null);
        bool1 = true;
      }
    }
    if (bool1)
    {
      localObject = this.mHost;
      if ((localObject instanceof AppCompatActivity)) {
        ((AppCompatActivity)localObject).onNightModeChanged(paramInt);
      }
    }
    return bool1;
  }
  
  private void updateResourcesConfigurationForNightMode(int paramInt, boolean paramBoolean, @Nullable Configuration paramConfiguration)
  {
    Resources localResources = this.mContext.getResources();
    Configuration localConfiguration = new Configuration(localResources.getConfiguration());
    if (paramConfiguration != null) {
      localConfiguration.updateFrom(paramConfiguration);
    }
    localConfiguration.uiMode = (paramInt | localResources.getConfiguration().uiMode & 0xFFFFFFCF);
    localResources.updateConfiguration(localConfiguration, null);
    if (Build.VERSION.SDK_INT < 26) {
      ResourcesFlusher.flush(localResources);
    }
    paramInt = this.mThemeResId;
    if (paramInt != 0)
    {
      this.mContext.setTheme(paramInt);
      if (Build.VERSION.SDK_INT >= 23) {
        this.mContext.getTheme().applyStyle(this.mThemeResId, true);
      }
    }
    if (paramBoolean)
    {
      paramConfiguration = this.mHost;
      if ((paramConfiguration instanceof Activity))
      {
        paramConfiguration = (Activity)paramConfiguration;
        if ((paramConfiguration instanceof LifecycleOwner))
        {
          if (((LifecycleOwner)paramConfiguration).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            paramConfiguration.onConfigurationChanged(localConfiguration);
          }
        }
        else if (this.mStarted) {
          paramConfiguration.onConfigurationChanged(localConfiguration);
        }
      }
    }
  }
  
  private void updateStatusGuardColor(View paramView)
  {
    int i;
    if ((ViewCompat.getWindowSystemUiVisibility(paramView) & 0x2000) != 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      i = ContextCompat.getColor(this.mContext, R.color.abc_decor_view_status_guard_light);
    } else {
      i = ContextCompat.getColor(this.mContext, R.color.abc_decor_view_status_guard);
    }
    paramView.setBackgroundColor(i);
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    ensureSubDecor();
    ((ViewGroup)this.mSubDecor.findViewById(16908290)).addView(paramView, paramLayoutParams);
    this.mAppCompatWindowCallback.getWrapped().onContentChanged();
  }
  
  public boolean applyDayNight()
  {
    return applyDayNight(true);
  }
  
  @CallSuper
  @NonNull
  public Context attachBaseContext2(@NonNull Context paramContext)
  {
    this.mBaseContextAttached = true;
    int i = mapNightMode(paramContext, calculateNightMode());
    boolean bool = sCanApplyOverrideConfiguration;
    Object localObject = null;
    Configuration localConfiguration1;
    if ((bool) && ((paramContext instanceof android.view.ContextThemeWrapper))) {
      localConfiguration1 = createOverrideConfigurationForDayNight(paramContext, i, null);
    }
    label179:
    try
    {
      AppCompatDelegateImpl.ContextThemeWrapperCompatApi17Impl.applyOverrideConfiguration((android.view.ContextThemeWrapper)paramContext, localConfiguration1);
      return paramContext;
    }
    catch (IllegalStateException localIllegalStateException1)
    {
      label53:
      label80:
      break label53;
    }
    if ((paramContext instanceof androidx.appcompat.view.ContextThemeWrapper)) {
      localConfiguration1 = createOverrideConfigurationForDayNight(paramContext, i, null);
    }
    try
    {
      ((androidx.appcompat.view.ContextThemeWrapper)paramContext).applyOverrideConfiguration(localConfiguration1);
      return paramContext;
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      break label80;
    }
    if (!sCanReturnDifferentContext) {
      return super.attachBaseContext2(paramContext);
    }
    try
    {
      localConfiguration1 = paramContext.getPackageManager().getResourcesForApplication(paramContext.getApplicationInfo()).getConfiguration();
      Configuration localConfiguration2 = paramContext.getResources().getConfiguration();
      if (!localConfiguration1.equals(localConfiguration2)) {
        localObject = generateConfigDelta(localConfiguration1, localConfiguration2);
      }
      localConfiguration1 = createOverrideConfigurationForDayNight(paramContext, i, (Configuration)localObject);
      localObject = new androidx.appcompat.view.ContextThemeWrapper(paramContext, R.style.Theme_AppCompat_Empty);
      ((androidx.appcompat.view.ContextThemeWrapper)localObject).applyOverrideConfiguration(localConfiguration1);
      i = 0;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      throw new RuntimeException("Application failed to obtain resources from itself", paramContext);
    }
    try
    {
      paramContext = paramContext.getTheme();
      if (paramContext != null) {
        i = 1;
      }
    }
    catch (NullPointerException paramContext)
    {
      break label179;
    }
    if (i != 0) {
      ResourcesCompat.ThemeCompat.rebase(((androidx.appcompat.view.ContextThemeWrapper)localObject).getTheme());
    }
    return super.attachBaseContext2((Context)localObject);
  }
  
  void callOnPanelClosed(int paramInt, AppCompatDelegateImpl.PanelFeatureState paramPanelFeatureState, Menu paramMenu)
  {
    Object localObject1 = paramPanelFeatureState;
    Object localObject2 = paramMenu;
    if (paramMenu == null)
    {
      AppCompatDelegateImpl.PanelFeatureState localPanelFeatureState = paramPanelFeatureState;
      if (paramPanelFeatureState == null)
      {
        localPanelFeatureState = paramPanelFeatureState;
        if (paramInt >= 0)
        {
          localObject1 = this.mPanels;
          localPanelFeatureState = paramPanelFeatureState;
          if (paramInt < localObject1.length) {
            localPanelFeatureState = localObject1[paramInt];
          }
        }
      }
      localObject1 = localPanelFeatureState;
      localObject2 = paramMenu;
      if (localPanelFeatureState != null)
      {
        localObject2 = localPanelFeatureState.menu;
        localObject1 = localPanelFeatureState;
      }
    }
    if ((localObject1 != null) && (!((AppCompatDelegateImpl.PanelFeatureState)localObject1).isOpen)) {
      return;
    }
    if (!this.mIsDestroyed) {
      this.mAppCompatWindowCallback.getWrapped().onPanelClosed(paramInt, (Menu)localObject2);
    }
  }
  
  void checkCloseActionMenu(@NonNull MenuBuilder paramMenuBuilder)
  {
    if (this.mClosingActionMenu) {
      return;
    }
    this.mClosingActionMenu = true;
    this.mDecorContentParent.dismissPopups();
    Window.Callback localCallback = getWindowCallback();
    if ((localCallback != null) && (!this.mIsDestroyed)) {
      localCallback.onPanelClosed(108, paramMenuBuilder);
    }
    this.mClosingActionMenu = false;
  }
  
  void closePanel(int paramInt)
  {
    closePanel(getPanelState(paramInt, true), true);
  }
  
  void closePanel(AppCompatDelegateImpl.PanelFeatureState paramPanelFeatureState, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramPanelFeatureState.featureId == 0))
    {
      localObject = this.mDecorContentParent;
      if ((localObject != null) && (((DecorContentParent)localObject).isOverflowMenuShowing()))
      {
        checkCloseActionMenu(paramPanelFeatureState.menu);
        return;
      }
    }
    Object localObject = (WindowManager)this.mContext.getSystemService("window");
    if ((localObject != null) && (paramPanelFeatureState.isOpen) && (paramPanelFeatureState.decorView != null))
    {
      ((WindowManager)localObject).removeView(paramPanelFeatureState.decorView);
      if (paramBoolean) {
        callOnPanelClosed(paramPanelFeatureState.featureId, paramPanelFeatureState, null);
      }
    }
    paramPanelFeatureState.isPrepared = false;
    paramPanelFeatureState.isHandled = false;
    paramPanelFeatureState.isOpen = false;
    paramPanelFeatureState.shownPanelView = null;
    paramPanelFeatureState.refreshDecorView = true;
    if (this.mPreparedPanel == paramPanelFeatureState) {
      this.mPreparedPanel = null;
    }
  }
  
  public View createView(View paramView, String paramString, @NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet)
  {
    Object localObject = this.mAppCompatViewInflater;
    boolean bool = false;
    if (localObject == null)
    {
      localObject = this.mContext.obtainStyledAttributes(R.styleable.AppCompatTheme).getString(R.styleable.AppCompatTheme_viewInflaterClass);
      if (localObject == null) {
        this.mAppCompatViewInflater = new AppCompatViewInflater();
      } else {
        try
        {
          this.mAppCompatViewInflater = ((AppCompatViewInflater)Class.forName((String)localObject).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        catch (Throwable localThrowable)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Failed to instantiate custom view inflater ");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(". Falling back to default.");
          Log.i("AppCompatDelegate", localStringBuilder.toString(), localThrowable);
          this.mAppCompatViewInflater = new AppCompatViewInflater();
        }
      }
    }
    if (IS_PRE_LOLLIPOP)
    {
      if ((paramAttributeSet instanceof XmlPullParser))
      {
        if (((XmlPullParser)paramAttributeSet).getDepth() > 1) {
          bool = true;
        }
      }
      else {
        bool = shouldInheritContext((ViewParent)paramView);
      }
    }
    else {
      bool = false;
    }
    return this.mAppCompatViewInflater.createView(paramView, paramString, paramContext, paramAttributeSet, bool, IS_PRE_LOLLIPOP, true, VectorEnabledTintResources.shouldBeUsed());
  }
  
  void dismissPopups()
  {
    Object localObject = this.mDecorContentParent;
    if (localObject != null) {
      ((DecorContentParent)localObject).dismissPopups();
    }
    if (this.mActionModePopup != null)
    {
      this.mWindow.getDecorView().removeCallbacks(this.mShowActionModePopup);
      if (!this.mActionModePopup.isShowing()) {}
    }
    try
    {
      this.mActionModePopup.dismiss();
      label54:
      this.mActionModePopup = null;
      endOnGoingFadeAnimation();
      localObject = getPanelState(0, false);
      if ((localObject != null) && (((AppCompatDelegateImpl.PanelFeatureState)localObject).menu != null)) {
        ((AppCompatDelegateImpl.PanelFeatureState)localObject).menu.close();
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label54;
    }
  }
  
  boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    Object localObject = this.mHost;
    boolean bool = localObject instanceof KeyEventDispatcher.Component;
    int i = 1;
    if ((bool) || ((localObject instanceof AppCompatDialog)))
    {
      localObject = this.mWindow.getDecorView();
      if ((localObject != null) && (KeyEventDispatcher.dispatchBeforeHierarchy((View)localObject, paramKeyEvent))) {
        return true;
      }
    }
    if ((paramKeyEvent.getKeyCode() == 82) && (this.mAppCompatWindowCallback.getWrapped().dispatchKeyEvent(paramKeyEvent))) {
      return true;
    }
    int j = paramKeyEvent.getKeyCode();
    if (paramKeyEvent.getAction() != 0) {
      i = 0;
    }
    if (i != 0) {
      return onKeyDown(j, paramKeyEvent);
    }
    return onKeyUp(j, paramKeyEvent);
  }
  
  void doInvalidatePanelMenu(int paramInt)
  {
    AppCompatDelegateImpl.PanelFeatureState localPanelFeatureState = getPanelState(paramInt, true);
    if (localPanelFeatureState.menu != null)
    {
      Bundle localBundle = new Bundle();
      localPanelFeatureState.menu.saveActionViewStates(localBundle);
      if (localBundle.size() > 0) {
        localPanelFeatureState.frozenActionViewState = localBundle;
      }
      localPanelFeatureState.menu.stopDispatchingItemsChanged();
      localPanelFeatureState.menu.clear();
    }
    localPanelFeatureState.refreshMenuContent = true;
    localPanelFeatureState.refreshDecorView = true;
    if (((paramInt == 108) || (paramInt == 0)) && (this.mDecorContentParent != null))
    {
      localPanelFeatureState = getPanelState(0, false);
      if (localPanelFeatureState != null)
      {
        localPanelFeatureState.isPrepared = false;
        preparePanel(localPanelFeatureState, null);
      }
    }
  }
  
  void endOnGoingFadeAnimation()
  {
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = this.mFadeAnim;
    if (localViewPropertyAnimatorCompat != null) {
      localViewPropertyAnimatorCompat.cancel();
    }
  }
  
  AppCompatDelegateImpl.PanelFeatureState findMenuPanel(Menu paramMenu)
  {
    AppCompatDelegateImpl.PanelFeatureState[] arrayOfPanelFeatureState = this.mPanels;
    int j = 0;
    int i;
    if (arrayOfPanelFeatureState != null) {
      i = arrayOfPanelFeatureState.length;
    } else {
      i = 0;
    }
    while (j < i)
    {
      AppCompatDelegateImpl.PanelFeatureState localPanelFeatureState = arrayOfPanelFeatureState[j];
      if ((localPanelFeatureState != null) && (localPanelFeatureState.menu == paramMenu)) {
        return localPanelFeatureState;
      }
      j += 1;
    }
    return null;
  }
  
  @Nullable
  public <T extends View> T findViewById(@IdRes int paramInt)
  {
    ensureSubDecor();
    return this.mWindow.findViewById(paramInt);
  }
  
  final Context getActionBarThemedContext()
  {
    Object localObject1 = getSupportActionBar();
    if (localObject1 != null) {
      localObject1 = ((ActionBar)localObject1).getThemedContext();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.mContext;
    }
    return localObject2;
  }
  
  @NonNull
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  @VisibleForTesting
  final AppCompatDelegateImpl.AutoNightModeManager getAutoTimeNightModeManager()
  {
    return getAutoTimeNightModeManager(this.mContext);
  }
  
  public final ActionBarDrawerToggle.Delegate getDrawerToggleDelegate()
  {
    return new AppCompatDelegateImpl.ActionBarDrawableToggleImpl(this);
  }
  
  public int getLocalNightMode()
  {
    return this.mLocalNightMode;
  }
  
  public MenuInflater getMenuInflater()
  {
    if (this.mMenuInflater == null)
    {
      initWindowDecorActionBar();
      Object localObject = this.mActionBar;
      if (localObject != null) {
        localObject = ((ActionBar)localObject).getThemedContext();
      } else {
        localObject = this.mContext;
      }
      this.mMenuInflater = new SupportMenuInflater((Context)localObject);
    }
    return this.mMenuInflater;
  }
  
  protected AppCompatDelegateImpl.PanelFeatureState getPanelState(int paramInt, boolean paramBoolean)
  {
    Object localObject2 = this.mPanels;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length > paramInt) {}
    }
    else
    {
      localObject1 = new AppCompatDelegateImpl.PanelFeatureState[paramInt + 1];
      if (localObject2 != null) {
        System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
      }
      this.mPanels = ((AppCompatDelegateImpl.PanelFeatureState[])localObject1);
    }
    Object localObject3 = localObject1[paramInt];
    localObject2 = localObject3;
    if (localObject3 == null)
    {
      localObject2 = new AppCompatDelegateImpl.PanelFeatureState(paramInt);
      localObject1[paramInt] = localObject2;
    }
    return localObject2;
  }
  
  ViewGroup getSubDecor()
  {
    return this.mSubDecor;
  }
  
  public ActionBar getSupportActionBar()
  {
    initWindowDecorActionBar();
    return this.mActionBar;
  }
  
  final CharSequence getTitle()
  {
    Object localObject = this.mHost;
    if ((localObject instanceof Activity)) {
      return ((Activity)localObject).getTitle();
    }
    return this.mTitle;
  }
  
  final Window.Callback getWindowCallback()
  {
    return this.mWindow.getCallback();
  }
  
  public boolean hasWindowFeature(int paramInt)
  {
    int i = sanitizeWindowFeatureId(paramInt);
    boolean bool2 = true;
    boolean bool1;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 5)
        {
          if (i != 10)
          {
            if (i != 108)
            {
              if (i != 109) {
                bool1 = false;
              } else {
                bool1 = this.mOverlayActionBar;
              }
            }
            else {
              bool1 = this.mHasActionBar;
            }
          }
          else {
            bool1 = this.mOverlayActionMode;
          }
        }
        else {
          bool1 = this.mFeatureIndeterminateProgress;
        }
      }
      else {
        bool1 = this.mFeatureProgress;
      }
    }
    else {
      bool1 = this.mWindowNoTitle;
    }
    if (!bool1)
    {
      if (this.mWindow.hasFeature(paramInt)) {
        return true;
      }
      bool2 = false;
    }
    return bool2;
  }
  
  public void installViewFactory()
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.mContext);
    if (localLayoutInflater.getFactory() == null)
    {
      LayoutInflaterCompat.setFactory2(localLayoutInflater, this);
      return;
    }
    if (!(localLayoutInflater.getFactory2() instanceof AppCompatDelegateImpl)) {
      Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
    }
  }
  
  public void invalidateOptionsMenu()
  {
    ActionBar localActionBar = getSupportActionBar();
    if ((localActionBar != null) && (localActionBar.invalidateOptionsMenu())) {
      return;
    }
    invalidatePanelMenu(0);
  }
  
  public boolean isHandleNativeActionModesEnabled()
  {
    return this.mHandleNativeActionModes;
  }
  
  int mapNightMode(@NonNull Context paramContext, int paramInt)
  {
    if (paramInt != -100)
    {
      if (paramInt != -1) {
        if (paramInt != 0)
        {
          if ((paramInt != 1) && (paramInt != 2))
          {
            if (paramInt == 3) {
              return getAutoBatteryNightModeManager(paramContext).getApplyableNightMode();
            }
            throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
          }
        }
        else
        {
          if ((Build.VERSION.SDK_INT >= 23) && (((UiModeManager)paramContext.getApplicationContext().getSystemService(UiModeManager.class)).getNightMode() == 0)) {
            return -1;
          }
          return getAutoTimeNightModeManager(paramContext).getApplyableNightMode();
        }
      }
      return paramInt;
    }
    return -1;
  }
  
  boolean onBackPressed()
  {
    Object localObject = this.mActionMode;
    if (localObject != null)
    {
      ((ActionMode)localObject).finish();
      return true;
    }
    localObject = getSupportActionBar();
    return (localObject != null) && (((ActionBar)localObject).collapseActionView());
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((this.mHasActionBar) && (this.mSubDecorInstalled))
    {
      ActionBar localActionBar = getSupportActionBar();
      if (localActionBar != null) {
        localActionBar.onConfigurationChanged(paramConfiguration);
      }
    }
    AppCompatDrawableManager.get().onConfigurationChanged(this.mContext);
    applyDayNight(false);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mBaseContextAttached = true;
    applyDayNight(false);
    ensureWindow();
    Object localObject = this.mHost;
    if ((localObject instanceof Activity)) {
      paramBundle = null;
    }
    try
    {
      localObject = NavUtils.getParentActivityName((Activity)localObject);
      paramBundle = (Bundle)localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      label39:
      break label39;
    }
    if (paramBundle != null)
    {
      paramBundle = peekSupportActionBar();
      if (paramBundle == null) {
        this.mEnableDefaultActionBarUp = true;
      } else {
        paramBundle.setDefaultDisplayHomeAsUpEnabled(true);
      }
    }
    addActiveDelegate(this);
    this.mCreated = true;
  }
  
  public final View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return createView(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return onCreateView(null, paramString, paramContext, paramAttributeSet);
  }
  
  public void onDestroy()
  {
    if ((this.mHost instanceof Activity)) {
      removeActivityDelegate(this);
    }
    if (this.mInvalidatePanelMenuPosted) {
      this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
    }
    this.mStarted = false;
    this.mIsDestroyed = true;
    if (this.mLocalNightMode != -100)
    {
      localObject = this.mHost;
      if (((localObject instanceof Activity)) && (((Activity)localObject).isChangingConfigurations()))
      {
        sLocalNightModes.put(this.mHost.getClass().getName(), Integer.valueOf(this.mLocalNightMode));
        break label121;
      }
    }
    sLocalNightModes.remove(this.mHost.getClass().getName());
    label121:
    Object localObject = this.mActionBar;
    if (localObject != null) {
      ((ActionBar)localObject).onDestroy();
    }
    cleanupAutoManagers();
  }
  
  boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    if (paramInt != 4)
    {
      if (paramInt != 82) {
        return false;
      }
      onKeyDownPanel(0, paramKeyEvent);
      return true;
    }
    if ((paramKeyEvent.getFlags() & 0x80) == 0) {
      bool = false;
    }
    this.mLongPressBackDown = bool;
    return false;
  }
  
  boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    Object localObject = getSupportActionBar();
    if ((localObject != null) && (((ActionBar)localObject).onKeyShortcut(paramInt, paramKeyEvent))) {
      return true;
    }
    localObject = this.mPreparedPanel;
    if ((localObject != null) && (performPanelShortcut((AppCompatDelegateImpl.PanelFeatureState)localObject, paramKeyEvent.getKeyCode(), paramKeyEvent, 1)))
    {
      paramKeyEvent = this.mPreparedPanel;
      if (paramKeyEvent != null) {
        paramKeyEvent.isHandled = true;
      }
      return true;
    }
    if (this.mPreparedPanel == null)
    {
      localObject = getPanelState(0, true);
      preparePanel((AppCompatDelegateImpl.PanelFeatureState)localObject, paramKeyEvent);
      boolean bool = performPanelShortcut((AppCompatDelegateImpl.PanelFeatureState)localObject, paramKeyEvent.getKeyCode(), paramKeyEvent, 1);
      ((AppCompatDelegateImpl.PanelFeatureState)localObject).isPrepared = false;
      if (bool) {
        return true;
      }
    }
    return false;
  }
  
  boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt != 4)
    {
      if (paramInt != 82) {
        return false;
      }
      onKeyUpPanel(0, paramKeyEvent);
      return true;
    }
    boolean bool = this.mLongPressBackDown;
    this.mLongPressBackDown = false;
    paramKeyEvent = getPanelState(0, false);
    if ((paramKeyEvent != null) && (paramKeyEvent.isOpen))
    {
      if (!bool) {
        closePanel(paramKeyEvent, true);
      }
      return true;
    }
    return onBackPressed();
  }
  
  public boolean onMenuItemSelected(@NonNull MenuBuilder paramMenuBuilder, @NonNull MenuItem paramMenuItem)
  {
    Window.Callback localCallback = getWindowCallback();
    if ((localCallback != null) && (!this.mIsDestroyed))
    {
      paramMenuBuilder = findMenuPanel(paramMenuBuilder.getRootMenu());
      if (paramMenuBuilder != null) {
        return localCallback.onMenuItemSelected(paramMenuBuilder.featureId, paramMenuItem);
      }
    }
    return false;
  }
  
  public void onMenuModeChange(@NonNull MenuBuilder paramMenuBuilder)
  {
    reopenMenu(true);
  }
  
  void onMenuOpened(int paramInt)
  {
    if (paramInt == 108)
    {
      ActionBar localActionBar = getSupportActionBar();
      if (localActionBar != null) {
        localActionBar.dispatchMenuVisibilityChanged(true);
      }
    }
  }
  
  void onPanelClosed(int paramInt)
  {
    Object localObject;
    if (paramInt == 108)
    {
      localObject = getSupportActionBar();
      if (localObject != null) {
        ((ActionBar)localObject).dispatchMenuVisibilityChanged(false);
      }
    }
    else if (paramInt == 0)
    {
      localObject = getPanelState(paramInt, true);
      if (((AppCompatDelegateImpl.PanelFeatureState)localObject).isOpen) {
        closePanel((AppCompatDelegateImpl.PanelFeatureState)localObject, false);
      }
    }
  }
  
  public void onPostCreate(Bundle paramBundle)
  {
    ensureSubDecor();
  }
  
  public void onPostResume()
  {
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null) {
      localActionBar.setShowHideAnimationEnabled(true);
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onStart()
  {
    this.mStarted = true;
    applyDayNight();
  }
  
  public void onStop()
  {
    this.mStarted = false;
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null) {
      localActionBar.setShowHideAnimationEnabled(false);
    }
  }
  
  void onSubDecorInstalled(ViewGroup paramViewGroup) {}
  
  final ActionBar peekSupportActionBar()
  {
    return this.mActionBar;
  }
  
  public boolean requestWindowFeature(int paramInt)
  {
    paramInt = sanitizeWindowFeatureId(paramInt);
    if ((this.mWindowNoTitle) && (paramInt == 108)) {
      return false;
    }
    if ((this.mHasActionBar) && (paramInt == 1)) {
      this.mHasActionBar = false;
    }
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 5)
        {
          if (paramInt != 10)
          {
            if (paramInt != 108)
            {
              if (paramInt != 109) {
                return this.mWindow.requestFeature(paramInt);
              }
              throwFeatureRequestIfSubDecorInstalled();
              this.mOverlayActionBar = true;
              return true;
            }
            throwFeatureRequestIfSubDecorInstalled();
            this.mHasActionBar = true;
            return true;
          }
          throwFeatureRequestIfSubDecorInstalled();
          this.mOverlayActionMode = true;
          return true;
        }
        throwFeatureRequestIfSubDecorInstalled();
        this.mFeatureIndeterminateProgress = true;
        return true;
      }
      throwFeatureRequestIfSubDecorInstalled();
      this.mFeatureProgress = true;
      return true;
    }
    throwFeatureRequestIfSubDecorInstalled();
    this.mWindowNoTitle = true;
    return true;
  }
  
  public void setContentView(int paramInt)
  {
    ensureSubDecor();
    ViewGroup localViewGroup = (ViewGroup)this.mSubDecor.findViewById(16908290);
    localViewGroup.removeAllViews();
    LayoutInflater.from(this.mContext).inflate(paramInt, localViewGroup);
    this.mAppCompatWindowCallback.getWrapped().onContentChanged();
  }
  
  public void setContentView(View paramView)
  {
    ensureSubDecor();
    ViewGroup localViewGroup = (ViewGroup)this.mSubDecor.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView);
    this.mAppCompatWindowCallback.getWrapped().onContentChanged();
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    ensureSubDecor();
    ViewGroup localViewGroup = (ViewGroup)this.mSubDecor.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView, paramLayoutParams);
    this.mAppCompatWindowCallback.getWrapped().onContentChanged();
  }
  
  public void setHandleNativeActionModesEnabled(boolean paramBoolean)
  {
    this.mHandleNativeActionModes = paramBoolean;
  }
  
  @RequiresApi(17)
  public void setLocalNightMode(int paramInt)
  {
    if (this.mLocalNightMode != paramInt)
    {
      this.mLocalNightMode = paramInt;
      if (this.mBaseContextAttached) {
        applyDayNight();
      }
    }
  }
  
  public void setSupportActionBar(Toolbar paramToolbar)
  {
    if (!(this.mHost instanceof Activity)) {
      return;
    }
    ActionBar localActionBar = getSupportActionBar();
    if (!(localActionBar instanceof WindowDecorActionBar))
    {
      this.mMenuInflater = null;
      if (localActionBar != null) {
        localActionBar.onDestroy();
      }
      if (paramToolbar != null)
      {
        paramToolbar = new ToolbarActionBar(paramToolbar, getTitle(), this.mAppCompatWindowCallback);
        this.mActionBar = paramToolbar;
        this.mWindow.setCallback(paramToolbar.getWrappedWindowCallback());
      }
      else
      {
        this.mActionBar = null;
        this.mWindow.setCallback(this.mAppCompatWindowCallback);
      }
      invalidateOptionsMenu();
      return;
    }
    throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
  }
  
  public void setTheme(@StyleRes int paramInt)
  {
    this.mThemeResId = paramInt;
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.mTitle = paramCharSequence;
    Object localObject = this.mDecorContentParent;
    if (localObject != null)
    {
      ((DecorContentParent)localObject).setWindowTitle(paramCharSequence);
      return;
    }
    if (peekSupportActionBar() != null)
    {
      peekSupportActionBar().setWindowTitle(paramCharSequence);
      return;
    }
    localObject = this.mTitleView;
    if (localObject != null) {
      ((TextView)localObject).setText(paramCharSequence);
    }
  }
  
  final boolean shouldAnimateActionModeView()
  {
    if (this.mSubDecorInstalled)
    {
      ViewGroup localViewGroup = this.mSubDecor;
      if ((localViewGroup != null) && (ViewCompat.isLaidOut(localViewGroup))) {
        return true;
      }
    }
    return false;
  }
  
  public ActionMode startSupportActionMode(@NonNull ActionMode.Callback paramCallback)
  {
    if (paramCallback != null)
    {
      Object localObject = this.mActionMode;
      if (localObject != null) {
        ((ActionMode)localObject).finish();
      }
      paramCallback = new AppCompatDelegateImpl.ActionModeCallbackWrapperV9(this, paramCallback);
      localObject = getSupportActionBar();
      if (localObject != null)
      {
        this.mActionMode = ((ActionBar)localObject).startActionMode(paramCallback);
        localObject = this.mActionMode;
        if (localObject != null)
        {
          AppCompatCallback localAppCompatCallback = this.mAppCompatCallback;
          if (localAppCompatCallback != null) {
            localAppCompatCallback.onSupportActionModeStarted((ActionMode)localObject);
          }
        }
      }
      if (this.mActionMode == null) {
        this.mActionMode = startSupportActionModeFromWindow(paramCallback);
      }
      return this.mActionMode;
    }
    throw new IllegalArgumentException("ActionMode callback can not be null.");
  }
  
  ActionMode startSupportActionModeFromWindow(@NonNull ActionMode.Callback paramCallback)
  {
    endOnGoingFadeAnimation();
    Object localObject1 = this.mActionMode;
    if (localObject1 != null) {
      ((ActionMode)localObject1).finish();
    }
    localObject1 = paramCallback;
    if (!(paramCallback instanceof AppCompatDelegateImpl.ActionModeCallbackWrapperV9)) {
      localObject1 = new AppCompatDelegateImpl.ActionModeCallbackWrapperV9(this, paramCallback);
    }
    paramCallback = this.mAppCompatCallback;
    if ((paramCallback != null) && (!this.mIsDestroyed)) {}
    try
    {
      paramCallback = paramCallback.onWindowStartingSupportActionMode((ActionMode.Callback)localObject1);
    }
    catch (AbstractMethodError paramCallback)
    {
      label69:
      boolean bool;
      Object localObject2;
      Resources.Theme localTheme;
      int i;
      break label69;
    }
    paramCallback = null;
    if (paramCallback != null)
    {
      this.mActionMode = paramCallback;
    }
    else
    {
      paramCallback = this.mActionModeView;
      bool = true;
      if (paramCallback == null) {
        if (this.mIsFloating)
        {
          localObject2 = new TypedValue();
          paramCallback = this.mContext.getTheme();
          paramCallback.resolveAttribute(R.attr.actionBarTheme, (TypedValue)localObject2, true);
          if (((TypedValue)localObject2).resourceId != 0)
          {
            localTheme = this.mContext.getResources().newTheme();
            localTheme.setTo(paramCallback);
            localTheme.applyStyle(((TypedValue)localObject2).resourceId, true);
            paramCallback = new androidx.appcompat.view.ContextThemeWrapper(this.mContext, 0);
            paramCallback.getTheme().setTo(localTheme);
          }
          else
          {
            paramCallback = this.mContext;
          }
          this.mActionModeView = new ActionBarContextView(paramCallback);
          this.mActionModePopup = new PopupWindow(paramCallback, null, R.attr.actionModePopupWindowStyle);
          PopupWindowCompat.setWindowLayoutType(this.mActionModePopup, 2);
          this.mActionModePopup.setContentView(this.mActionModeView);
          this.mActionModePopup.setWidth(-1);
          paramCallback.getTheme().resolveAttribute(R.attr.actionBarSize, (TypedValue)localObject2, true);
          i = TypedValue.complexToDimensionPixelSize(((TypedValue)localObject2).data, paramCallback.getResources().getDisplayMetrics());
          this.mActionModeView.setContentHeight(i);
          this.mActionModePopup.setHeight(-2);
          this.mShowActionModePopup = new AppCompatDelegateImpl.6(this);
        }
        else
        {
          paramCallback = (ViewStubCompat)this.mSubDecor.findViewById(R.id.action_mode_bar_stub);
          if (paramCallback != null)
          {
            paramCallback.setLayoutInflater(LayoutInflater.from(getActionBarThemedContext()));
            this.mActionModeView = ((ActionBarContextView)paramCallback.inflate());
          }
        }
      }
      if (this.mActionModeView != null)
      {
        endOnGoingFadeAnimation();
        this.mActionModeView.killMode();
        paramCallback = this.mActionModeView.getContext();
        localObject2 = this.mActionModeView;
        if (this.mActionModePopup != null) {
          bool = false;
        }
        paramCallback = new StandaloneActionMode(paramCallback, (ActionBarContextView)localObject2, (ActionMode.Callback)localObject1, bool);
        if (((ActionMode.Callback)localObject1).onCreateActionMode(paramCallback, paramCallback.getMenu()))
        {
          paramCallback.invalidate();
          this.mActionModeView.initForMode(paramCallback);
          this.mActionMode = paramCallback;
          if (shouldAnimateActionModeView())
          {
            this.mActionModeView.setAlpha(0.0F);
            this.mFadeAnim = ViewCompat.animate(this.mActionModeView).alpha(1.0F);
            this.mFadeAnim.setListener(new AppCompatDelegateImpl.7(this));
          }
          else
          {
            this.mActionModeView.setAlpha(1.0F);
            this.mActionModeView.setVisibility(0);
            this.mActionModeView.sendAccessibilityEvent(32);
            if ((this.mActionModeView.getParent() instanceof View)) {
              ViewCompat.requestApplyInsets((View)this.mActionModeView.getParent());
            }
          }
          if (this.mActionModePopup != null) {
            this.mWindow.getDecorView().post(this.mShowActionModePopup);
          }
        }
        else
        {
          this.mActionMode = null;
        }
      }
    }
    paramCallback = this.mActionMode;
    if (paramCallback != null)
    {
      localObject1 = this.mAppCompatCallback;
      if (localObject1 != null) {
        ((AppCompatCallback)localObject1).onSupportActionModeStarted(paramCallback);
      }
    }
    return this.mActionMode;
  }
  
  final int updateStatusGuard(@Nullable WindowInsetsCompat paramWindowInsetsCompat, @Nullable Rect paramRect)
  {
    int i2 = 0;
    int i;
    if (paramWindowInsetsCompat != null) {
      i = paramWindowInsetsCompat.getSystemWindowInsetTop();
    } else if (paramRect != null) {
      i = paramRect.top;
    } else {
      i = 0;
    }
    Object localObject = this.mActionModeView;
    int j;
    if ((localObject != null) && ((((ActionBarContextView)localObject).getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      localObject = (ViewGroup.MarginLayoutParams)this.mActionModeView.getLayoutParams();
      boolean bool = this.mActionModeView.isShown();
      int n = 1;
      int i1;
      int k;
      int m;
      if (bool)
      {
        if (this.mTempRect1 == null)
        {
          this.mTempRect1 = new Rect();
          this.mTempRect2 = new Rect();
        }
        Rect localRect1 = this.mTempRect1;
        Rect localRect2 = this.mTempRect2;
        if (paramWindowInsetsCompat == null) {
          localRect1.set(paramRect);
        } else {
          localRect1.set(paramWindowInsetsCompat.getSystemWindowInsetLeft(), paramWindowInsetsCompat.getSystemWindowInsetTop(), paramWindowInsetsCompat.getSystemWindowInsetRight(), paramWindowInsetsCompat.getSystemWindowInsetBottom());
        }
        ViewUtils.computeFitSystemWindows(this.mSubDecor, localRect1, localRect2);
        i1 = localRect1.top;
        j = localRect1.left;
        int i3 = localRect1.right;
        paramWindowInsetsCompat = ViewCompat.getRootWindowInsets(this.mSubDecor);
        if (paramWindowInsetsCompat == null) {
          k = 0;
        } else {
          k = paramWindowInsetsCompat.getSystemWindowInsetLeft();
        }
        if (paramWindowInsetsCompat == null) {
          m = 0;
        } else {
          m = paramWindowInsetsCompat.getSystemWindowInsetRight();
        }
        if ((((ViewGroup.MarginLayoutParams)localObject).topMargin == i1) && (((ViewGroup.MarginLayoutParams)localObject).leftMargin == j) && (((ViewGroup.MarginLayoutParams)localObject).rightMargin == i3))
        {
          j = 0;
        }
        else
        {
          ((ViewGroup.MarginLayoutParams)localObject).topMargin = i1;
          ((ViewGroup.MarginLayoutParams)localObject).leftMargin = j;
          ((ViewGroup.MarginLayoutParams)localObject).rightMargin = i3;
          j = 1;
        }
        if ((i1 > 0) && (this.mStatusGuard == null))
        {
          this.mStatusGuard = new View(this.mContext);
          this.mStatusGuard.setVisibility(8);
          paramWindowInsetsCompat = new FrameLayout.LayoutParams(-1, ((ViewGroup.MarginLayoutParams)localObject).topMargin, 51);
          paramWindowInsetsCompat.leftMargin = k;
          paramWindowInsetsCompat.rightMargin = m;
          this.mSubDecor.addView(this.mStatusGuard, -1, paramWindowInsetsCompat);
        }
        else
        {
          paramWindowInsetsCompat = this.mStatusGuard;
          if (paramWindowInsetsCompat != null)
          {
            paramWindowInsetsCompat = (ViewGroup.MarginLayoutParams)paramWindowInsetsCompat.getLayoutParams();
            if ((paramWindowInsetsCompat.height != ((ViewGroup.MarginLayoutParams)localObject).topMargin) || (paramWindowInsetsCompat.leftMargin != k) || (paramWindowInsetsCompat.rightMargin != m))
            {
              paramWindowInsetsCompat.height = ((ViewGroup.MarginLayoutParams)localObject).topMargin;
              paramWindowInsetsCompat.leftMargin = k;
              paramWindowInsetsCompat.rightMargin = m;
              this.mStatusGuard.setLayoutParams(paramWindowInsetsCompat);
            }
          }
        }
        if (this.mStatusGuard == null) {
          n = 0;
        }
        if ((n != 0) && (this.mStatusGuard.getVisibility() != 0)) {
          updateStatusGuardColor(this.mStatusGuard);
        }
        k = i;
        m = n;
        i1 = j;
        if (!this.mOverlayActionMode)
        {
          k = i;
          m = n;
          i1 = j;
          if (n != 0)
          {
            k = 0;
            m = n;
            i1 = j;
          }
        }
      }
      else
      {
        if (((ViewGroup.MarginLayoutParams)localObject).topMargin != 0)
        {
          ((ViewGroup.MarginLayoutParams)localObject).topMargin = 0;
          j = 1;
        }
        else
        {
          j = 0;
        }
        m = 0;
        i1 = j;
        k = i;
      }
      i = k;
      j = m;
      if (i1 != 0)
      {
        this.mActionModeView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        i = k;
        j = m;
      }
    }
    else
    {
      j = 0;
    }
    paramWindowInsetsCompat = this.mStatusGuard;
    if (paramWindowInsetsCompat != null)
    {
      if (j != 0) {
        j = i2;
      } else {
        j = 8;
      }
      paramWindowInsetsCompat.setVisibility(j);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.AppCompatDelegateImpl
 * JD-Core Version:    0.7.0.1
 */