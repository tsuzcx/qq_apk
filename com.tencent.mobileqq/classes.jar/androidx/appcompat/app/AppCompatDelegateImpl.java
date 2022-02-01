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
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
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
import androidx.collection.ArrayMap;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NavUtils;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.KeyEventDispatcher.Component;
import androidx.core.view.LayoutInflaterCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.widget.PopupWindowCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleOwner;
import java.lang.reflect.Constructor;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
class AppCompatDelegateImpl
  extends AppCompatDelegate
  implements LayoutInflater.Factory2, MenuBuilder.Callback
{
  private static final boolean DEBUG = false;
  static final String EXCEPTION_HANDLER_MESSAGE_SUFFIX = ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.";
  private static final boolean IS_PRE_LOLLIPOP;
  private static final boolean sAlwaysOverrideConfiguration;
  private static boolean sInstalledExceptionHandler;
  private static final Map<Class<?>, Integer> sLocalNightModes = new ArrayMap();
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
  private ViewGroup mSubDecor;
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
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 21)
    {
      bool1 = bool2;
      if (Build.VERSION.SDK_INT <= 25) {
        bool1 = true;
      }
    }
    sAlwaysOverrideConfiguration = bool1;
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
      paramContext = (Integer)sLocalNightModes.get(this.mHost.getClass());
      if (paramContext != null)
      {
        this.mLocalNightMode = paramContext.intValue();
        sLocalNightModes.remove(this.mHost.getClass());
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
    paramBoolean = updateForNightMode(mapNightMode(i), paramBoolean);
    if (i == 0)
    {
      getAutoTimeNightModeManager().setup();
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
      getAutoBatteryNightModeManager().setup();
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
          localObject1 = (ViewGroup)((LayoutInflater)localObject1).inflate(2131558412, null);
          this.mOverlayActionBar = false;
          this.mHasActionBar = false;
        }
        else if (this.mHasActionBar)
        {
          localObject1 = new TypedValue();
          this.mContext.getTheme().resolveAttribute(2131034126, (TypedValue)localObject1, true);
          if (((TypedValue)localObject1).resourceId != 0) {
            localObject1 = new androidx.appcompat.view.ContextThemeWrapper(this.mContext, ((TypedValue)localObject1).resourceId);
          } else {
            localObject1 = this.mContext;
          }
          localObject2 = (ViewGroup)LayoutInflater.from((Context)localObject1).inflate(2131558423, null);
          this.mDecorContentParent = ((DecorContentParent)((ViewGroup)localObject2).findViewById(2131365456));
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
      else
      {
        if (this.mOverlayActionMode) {
          localObject1 = (ViewGroup)((LayoutInflater)localObject1).inflate(2131558422, null);
        } else {
          localObject1 = (ViewGroup)((LayoutInflater)localObject1).inflate(2131558421, null);
        }
        if (Build.VERSION.SDK_INT >= 21) {
          ViewCompat.setOnApplyWindowInsetsListener((View)localObject1, new AppCompatDelegateImpl.3(this));
        } else {
          ((FitWindowsViewGroup)localObject1).setOnFitSystemWindowsListener(new AppCompatDelegateImpl.4(this));
        }
      }
      if (localObject1 != null)
      {
        if (this.mDecorContentParent == null) {
          this.mTitleView = ((TextView)((ViewGroup)localObject1).findViewById(2131378784));
        }
        ViewUtils.makeOptionalFitsSystemWindows((View)localObject1);
        localObject2 = (ContentFrameLayout)((ViewGroup)localObject1).findViewById(2131361955);
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
  
  private AppCompatDelegateImpl.AutoNightModeManager getAutoBatteryNightModeManager()
  {
    if (this.mAutoBatteryNightModeManager == null) {
      this.mAutoBatteryNightModeManager = new AppCompatDelegateImpl.AutoBatteryNightModeManager(this, this.mContext);
    }
    return this.mAutoBatteryNightModeManager;
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
        localTheme.resolveAttribute(2131034126, localTypedValue, true);
        localObject1 = null;
        if (localTypedValue.resourceId != 0)
        {
          localObject1 = localContext.getResources().newTheme();
          ((Resources.Theme)localObject1).setTo(localTheme);
          ((Resources.Theme)localObject1).applyStyle(localTypedValue.resourceId, true);
          ((Resources.Theme)localObject1).resolveAttribute(2131034127, localTypedValue, true);
        }
        else
        {
          localTheme.resolveAttribute(2131034127, localTypedValue, true);
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
        localObject = ((PackageManager)localObject).getActivityInfo(new ComponentName(this.mContext, this.mHost.getClass()), 0);
        if ((localObject == null) || ((((ActivityInfo)localObject).configChanges & 0x200) == 0)) {
          break label110;
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
      label110:
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
      paramKeyEvent = (AudioManager)this.mContext.getSystemService("audio");
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
            break label337;
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
        if (!initializePanelContent(paramPanelFeatureState)) {
          return;
        }
        if (!paramPanelFeatureState.hasPanelItems()) {
          return;
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
      label337:
      paramPanelFeatureState.isHandled = false;
      paramKeyEvent = new WindowManager.LayoutParams(i, -2, paramPanelFeatureState.x, paramPanelFeatureState.y, 1002, 8519680, -3);
      paramKeyEvent.gravity = paramPanelFeatureState.gravity;
      paramKeyEvent.windowAnimations = paramPanelFeatureState.windowAnimations;
      localWindowManager.addView(paramPanelFeatureState.decorView, paramKeyEvent);
      paramPanelFeatureState.isOpen = true;
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
  
  private void reopenMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    paramMenuBuilder = this.mDecorContentParent;
    if ((paramMenuBuilder != null) && (paramMenuBuilder.canShowOverflowMenu()) && ((!ViewConfiguration.get(this.mContext).hasPermanentMenuKey()) || (this.mDecorContentParent.isOverflowMenuShowPending())))
    {
      paramMenuBuilder = getWindowCallback();
      if ((this.mDecorContentParent.isOverflowMenuShowing()) && (paramBoolean))
      {
        this.mDecorContentParent.hideOverflowMenu();
        if (!this.mIsDestroyed) {
          paramMenuBuilder.onPanelClosed(108, getPanelState(0, true).menu);
        }
      }
      else if ((paramMenuBuilder != null) && (!this.mIsDestroyed))
      {
        if ((this.mInvalidatePanelMenuPosted) && ((this.mInvalidatePanelMenuFeatures & 0x1) != 0))
        {
          this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
          this.mInvalidatePanelMenuRunnable.run();
        }
        AppCompatDelegateImpl.PanelFeatureState localPanelFeatureState = getPanelState(0, true);
        if ((localPanelFeatureState.menu != null) && (!localPanelFeatureState.refreshMenuContent) && (paramMenuBuilder.onPreparePanel(0, localPanelFeatureState.createdPanelView, localPanelFeatureState.menu)))
        {
          paramMenuBuilder.onMenuOpened(108, localPanelFeatureState.menu);
          this.mDecorContentParent.showOverflowMenu();
        }
      }
      return;
    }
    paramMenuBuilder = getPanelState(0, true);
    paramMenuBuilder.refreshDecorView = true;
    closePanel(paramMenuBuilder, false);
    openPanel(paramMenuBuilder, null);
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
    int j = this.mContext.getApplicationContext().getResources().getConfiguration().uiMode & 0x30;
    boolean bool3 = true;
    int i;
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        i = j;
      } else {
        i = 32;
      }
    }
    else {
      i = 16;
    }
    boolean bool4 = isActivityManifestHandlingUiMode();
    boolean bool1 = sAlwaysOverrideConfiguration;
    boolean bool2 = false;
    if (!bool1)
    {
      bool1 = bool2;
      if (i == j) {}
    }
    else
    {
      bool1 = bool2;
      if (!bool4)
      {
        bool1 = bool2;
        if (Build.VERSION.SDK_INT >= 17)
        {
          bool1 = bool2;
          if (!this.mBaseContextAttached)
          {
            bool1 = bool2;
            if ((this.mHost instanceof android.view.ContextThemeWrapper))
            {
              Configuration localConfiguration = new Configuration();
              localConfiguration.uiMode = (localConfiguration.uiMode & 0xFFFFFFCF | i);
              try
              {
                ((android.view.ContextThemeWrapper)this.mHost).applyOverrideConfiguration(localConfiguration);
                bool1 = true;
              }
              catch (IllegalStateException localIllegalStateException)
              {
                Log.e("AppCompatDelegate", "updateForNightMode. Calling applyOverrideConfiguration() failed with an exception. Will fall back to using Resources.updateConfiguration()", localIllegalStateException);
                bool1 = bool2;
              }
            }
          }
        }
      }
    }
    j = this.mContext.getResources().getConfiguration().uiMode & 0x30;
    bool2 = bool1;
    Object localObject;
    if (!bool1)
    {
      bool2 = bool1;
      if (j != i)
      {
        bool2 = bool1;
        if (paramBoolean)
        {
          bool2 = bool1;
          if (!bool4)
          {
            bool2 = bool1;
            if (this.mBaseContextAttached) {
              if (Build.VERSION.SDK_INT < 17)
              {
                bool2 = bool1;
                if (!this.mCreated) {}
              }
              else
              {
                localObject = this.mHost;
                bool2 = bool1;
                if ((localObject instanceof Activity))
                {
                  ActivityCompat.recreate((Activity)localObject);
                  bool2 = true;
                }
              }
            }
          }
        }
      }
    }
    if ((!bool2) && (j != i))
    {
      updateResourcesConfigurationForNightMode(i, bool4);
      bool2 = bool3;
    }
    if (bool2)
    {
      localObject = this.mHost;
      if ((localObject instanceof AppCompatActivity)) {
        ((AppCompatActivity)localObject).onNightModeChanged(paramInt);
      }
    }
    return bool2;
  }
  
  private void updateResourcesConfigurationForNightMode(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.mContext.getResources();
    Configuration localConfiguration = new Configuration(((Resources)localObject).getConfiguration());
    localConfiguration.uiMode = (paramInt | ((Resources)localObject).getConfiguration().uiMode & 0xFFFFFFCF);
    ((Resources)localObject).updateConfiguration(localConfiguration, null);
    if (Build.VERSION.SDK_INT < 26) {
      ResourcesFlusher.flush((Resources)localObject);
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
      localObject = this.mHost;
      if ((localObject instanceof Activity))
      {
        localObject = (Activity)localObject;
        if ((localObject instanceof LifecycleOwner))
        {
          if (((LifecycleOwner)localObject).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            ((Activity)localObject).onConfigurationChanged(localConfiguration);
          }
        }
        else if (this.mStarted) {
          ((Activity)localObject).onConfigurationChanged(localConfiguration);
        }
      }
    }
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
  
  public void attachBaseContext(Context paramContext)
  {
    applyDayNight(false);
    this.mBaseContextAttached = true;
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
  
  void checkCloseActionMenu(MenuBuilder paramMenuBuilder)
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
      if ((localObject != null) && (!AppCompatViewInflater.class.getName().equals(localObject))) {
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
      } else {
        this.mAppCompatViewInflater = new AppCompatViewInflater();
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
  final AppCompatDelegateImpl.AutoNightModeManager getAutoTimeNightModeManager()
  {
    if (this.mAutoTimeNightModeManager == null) {
      this.mAutoTimeNightModeManager = new AppCompatDelegateImpl.AutoTimeNightModeManager(this, TwilightManager.getInstance(this.mContext));
    }
    return this.mAutoTimeNightModeManager;
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
  
  int mapNightMode(int paramInt)
  {
    if (paramInt != -100)
    {
      int i = paramInt;
      if (paramInt != -1) {
        if (paramInt != 0)
        {
          i = paramInt;
          if (paramInt != 1)
          {
            i = paramInt;
            if (paramInt != 2)
            {
              if (paramInt == 3) {
                return getAutoBatteryNightModeManager().getApplyableNightMode();
              }
              throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
            }
          }
        }
        else
        {
          if ((Build.VERSION.SDK_INT >= 23) && (((UiModeManager)this.mContext.getSystemService(UiModeManager.class)).getNightMode() == 0)) {
            return -1;
          }
          i = getAutoTimeNightModeManager().getApplyableNightMode();
        }
      }
      return i;
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
    markStopped(this);
    if (this.mInvalidatePanelMenuPosted) {
      this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
    }
    this.mStarted = false;
    this.mIsDestroyed = true;
    ActionBar localActionBar = this.mActionBar;
    if (localActionBar != null) {
      localActionBar.onDestroy();
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
  
  public boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
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
  
  public void onMenuModeChange(MenuBuilder paramMenuBuilder)
  {
    reopenMenu(paramMenuBuilder, true);
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
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (this.mLocalNightMode != -100) {
      sLocalNightModes.put(this.mHost.getClass(), Integer.valueOf(this.mLocalNightMode));
    }
  }
  
  public void onStart()
  {
    this.mStarted = true;
    applyDayNight();
    markStarted(this);
  }
  
  public void onStop()
  {
    this.mStarted = false;
    markStopped(this);
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null) {
      localActionBar.setShowHideAnimationEnabled(false);
    }
    if ((this.mHost instanceof Dialog)) {
      cleanupAutoManagers();
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
  
  public void setLocalNightMode(int paramInt)
  {
    if (this.mLocalNightMode != paramInt)
    {
      this.mLocalNightMode = paramInt;
      applyDayNight();
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
          paramCallback.resolveAttribute(2131034126, (TypedValue)localObject2, true);
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
          this.mActionModePopup = new PopupWindow(paramCallback, null, 2131034140);
          PopupWindowCompat.setWindowLayoutType(this.mActionModePopup, 2);
          this.mActionModePopup.setContentView(this.mActionModeView);
          this.mActionModePopup.setWidth(-1);
          paramCallback.getTheme().resolveAttribute(2131034120, (TypedValue)localObject2, true);
          i = TypedValue.complexToDimensionPixelSize(((TypedValue)localObject2).data, paramCallback.getResources().getDisplayMetrics());
          this.mActionModeView.setContentHeight(i);
          this.mActionModePopup.setHeight(-2);
          this.mShowActionModePopup = new AppCompatDelegateImpl.6(this);
        }
        else
        {
          paramCallback = (ViewStubCompat)this.mSubDecor.findViewById(2131361976);
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
  
  int updateStatusGuard(int paramInt)
  {
    Object localObject1 = this.mActionModeView;
    int i1 = 0;
    int i;
    int k;
    if ((localObject1 != null) && ((((ActionBarContextView)localObject1).getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      localObject1 = (ViewGroup.MarginLayoutParams)this.mActionModeView.getLayoutParams();
      boolean bool = this.mActionModeView.isShown();
      int m = 1;
      int n;
      int j;
      if (bool)
      {
        if (this.mTempRect1 == null)
        {
          this.mTempRect1 = new Rect();
          this.mTempRect2 = new Rect();
        }
        Object localObject2 = this.mTempRect1;
        Rect localRect = this.mTempRect2;
        ((Rect)localObject2).set(0, paramInt, 0, 0);
        ViewUtils.computeFitSystemWindows(this.mSubDecor, (Rect)localObject2, localRect);
        if (localRect.top == 0) {
          i = paramInt;
        } else {
          i = 0;
        }
        if (((ViewGroup.MarginLayoutParams)localObject1).topMargin != i)
        {
          ((ViewGroup.MarginLayoutParams)localObject1).topMargin = paramInt;
          localObject2 = this.mStatusGuard;
          if (localObject2 == null)
          {
            this.mStatusGuard = new View(this.mContext);
            this.mStatusGuard.setBackgroundColor(this.mContext.getResources().getColor(2131165206));
            this.mSubDecor.addView(this.mStatusGuard, -1, new ViewGroup.LayoutParams(-1, paramInt));
          }
          else
          {
            localObject2 = ((View)localObject2).getLayoutParams();
            if (((ViewGroup.LayoutParams)localObject2).height != paramInt)
            {
              ((ViewGroup.LayoutParams)localObject2).height = paramInt;
              this.mStatusGuard.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            }
          }
          k = 1;
        }
        else
        {
          k = 0;
        }
        if (this.mStatusGuard == null) {
          m = 0;
        }
        n = k;
        i = m;
        j = paramInt;
        if (!this.mOverlayActionMode)
        {
          n = k;
          i = m;
          j = paramInt;
          if (m != 0)
          {
            j = 0;
            n = k;
            i = m;
          }
        }
      }
      else
      {
        if (((ViewGroup.MarginLayoutParams)localObject1).topMargin != 0)
        {
          ((ViewGroup.MarginLayoutParams)localObject1).topMargin = 0;
          k = 1;
        }
        else
        {
          k = 0;
        }
        i = 0;
        j = paramInt;
        n = k;
      }
      k = i;
      paramInt = j;
      if (n != 0)
      {
        this.mActionModeView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        k = i;
        paramInt = j;
      }
    }
    else
    {
      k = 0;
    }
    localObject1 = this.mStatusGuard;
    if (localObject1 != null)
    {
      if (k != 0) {
        i = i1;
      } else {
        i = 8;
      }
      ((View)localObject1).setVisibility(i);
    }
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.AppCompatDelegateImpl
 * JD-Core Version:    0.7.0.1
 */