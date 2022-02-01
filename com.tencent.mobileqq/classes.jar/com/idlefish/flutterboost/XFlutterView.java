package com.idlefish.flutterboost;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import io.flutter.Log;
import io.flutter.embedding.android.AndroidTouchProcessor;
import io.flutter.embedding.android.FlutterSurfaceView;
import io.flutter.embedding.android.FlutterTextureView;
import io.flutter.embedding.android.FlutterView.FlutterEngineAttachmentListener;
import io.flutter.embedding.android.FlutterView.RenderMode;
import io.flutter.embedding.android.FlutterView.TransparencyMode;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.FlutterRenderer.ViewportMetrics;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.embedding.engine.renderer.RenderSurface;
import io.flutter.embedding.engine.systemchannels.LocalizationChannel;
import io.flutter.embedding.engine.systemchannels.SettingsChannel;
import io.flutter.embedding.engine.systemchannels.SettingsChannel.MessageBuilder;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.view.AccessibilityBridge;
import io.flutter.view.AccessibilityBridge.OnAccessibilityChangeListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class XFlutterView
  extends FrameLayout
{
  private static final String TAG = "FlutterView";
  @Nullable
  private AccessibilityBridge accessibilityBridge;
  @Nullable
  private XAndroidKeyProcessor androidKeyProcessor;
  @Nullable
  private AndroidTouchProcessor androidTouchProcessor;
  private boolean didRenderFirstFrame;
  @Nullable
  private FlutterEngine flutterEngine;
  @NonNull
  private final Set<FlutterView.FlutterEngineAttachmentListener> flutterEngineAttachmentListeners = new HashSet();
  private final FlutterUiDisplayListener flutterUiDisplayListener = new XFlutterView.2(this);
  private final Set<FlutterUiDisplayListener> flutterUiDisplayListeners = new HashSet();
  private boolean hasAddFirstFrameRenderedListener = false;
  private boolean isFlutterUiDisplayed;
  private final AccessibilityBridge.OnAccessibilityChangeListener onAccessibilityChangeListener = new XFlutterView.1(this);
  @NonNull
  private FlutterView.RenderMode renderMode;
  @Nullable
  private RenderSurface renderSurface;
  @Nullable
  private XTextInputPlugin textInputPlugin;
  @Nullable
  private FlutterView.TransparencyMode transparencyMode;
  private final FlutterRenderer.ViewportMetrics viewportMetrics = new FlutterRenderer.ViewportMetrics();
  
  public XFlutterView(@NonNull Context paramContext)
  {
    this(paramContext, null, null, null);
  }
  
  public XFlutterView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, null, null);
  }
  
  private XFlutterView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @Nullable FlutterView.RenderMode paramRenderMode, @Nullable FlutterView.TransparencyMode paramTransparencyMode)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramRenderMode;
    if (paramRenderMode == null) {
      paramContext = FlutterView.RenderMode.surface;
    }
    this.renderMode = paramContext;
    if (paramTransparencyMode != null) {}
    for (;;)
    {
      this.transparencyMode = paramTransparencyMode;
      init();
      return;
      paramTransparencyMode = FlutterView.TransparencyMode.opaque;
    }
  }
  
  public XFlutterView(@NonNull Context paramContext, @NonNull FlutterView.RenderMode paramRenderMode)
  {
    this(paramContext, null, paramRenderMode, null);
  }
  
  public XFlutterView(@NonNull Context paramContext, @NonNull FlutterView.RenderMode paramRenderMode, @NonNull FlutterView.TransparencyMode paramTransparencyMode)
  {
    this(paramContext, null, paramRenderMode, paramTransparencyMode);
  }
  
  public XFlutterView(@NonNull Context paramContext, @NonNull FlutterView.TransparencyMode paramTransparencyMode)
  {
    this(paramContext, null, FlutterView.RenderMode.surface, paramTransparencyMode);
  }
  
  private void init()
  {
    Log.v("FlutterView", "Initializing FlutterView");
    switch (XFlutterView.3.$SwitchMap$io$flutter$embedding$android$FlutterView$RenderMode[this.renderMode.ordinal()])
    {
    default: 
    case 2: 
      for (;;)
      {
        setFocusable(true);
        setFocusableInTouchMode(true);
        return;
        Log.v("FlutterView", "Internally using a FlutterTextureView.");
        localObject = new FlutterTextureView(getContext());
        this.renderSurface = ((RenderSurface)localObject);
        addView((View)localObject);
      }
    }
    Log.v("FlutterView", "Internally using a FlutterSurfaceView.");
    Object localObject = getContext();
    if (this.transparencyMode == FlutterView.TransparencyMode.transparent) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new FlutterSurfaceView((Context)localObject, bool);
      this.renderSurface = ((RenderSurface)localObject);
      addView((View)localObject);
      break;
    }
  }
  
  private void resetWillNotDraw(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    if (!this.flutterEngine.getRenderer().isSoftwareRenderingEnabled())
    {
      boolean bool1 = bool2;
      if (!paramBoolean1)
      {
        bool1 = bool2;
        if (!paramBoolean2) {
          bool1 = true;
        }
      }
      setWillNotDraw(bool1);
      return;
    }
    setWillNotDraw(false);
  }
  
  private void sendLocalesToFlutter(@NonNull Configuration paramConfiguration)
  {
    ArrayList localArrayList = new ArrayList();
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramConfiguration = paramConfiguration.getLocales();
      int j = paramConfiguration.size();
      int i = 0;
      while (i < j)
      {
        localArrayList.add(paramConfiguration.get(i));
        i += 1;
      }
    }
    localArrayList.add(paramConfiguration.locale);
    if ((this.flutterEngine != null) && (this.flutterEngine.getLocalizationChannel() != null)) {
      this.flutterEngine.getLocalizationChannel().sendLocales(localArrayList);
    }
  }
  
  private void sendUserSettingsToFlutter()
  {
    if ((this.flutterEngine != null) && (this.flutterEngine.getSettingsChannel() != null)) {
      this.flutterEngine.getSettingsChannel().startMessage().setTextScaleFactor(getResources().getConfiguration().fontScale).setUse24HourFormat(DateFormat.is24HourFormat(getContext())).send();
    }
  }
  
  private void sendViewportMetricsToFlutter()
  {
    if (!isAttachedToFlutterEngine()) {
      Log.w("FlutterView", "Tried to send viewport metrics from Android to Flutter but this FlutterView was not attached to a FlutterEngine.");
    }
    while ((this.viewportMetrics.width == 0) && (this.viewportMetrics.height == 0)) {
      return;
    }
    this.viewportMetrics.devicePixelRatio = getResources().getDisplayMetrics().density;
    this.flutterEngine.getRenderer().setViewportMetrics(this.viewportMetrics);
  }
  
  @VisibleForTesting
  public void addFlutterEngineAttachmentListener(@NonNull FlutterView.FlutterEngineAttachmentListener paramFlutterEngineAttachmentListener)
  {
    this.flutterEngineAttachmentListeners.add(paramFlutterEngineAttachmentListener);
  }
  
  public void addOnFirstFrameRenderedListener(@NonNull FlutterUiDisplayListener paramFlutterUiDisplayListener)
  {
    this.flutterUiDisplayListeners.add(paramFlutterUiDisplayListener);
  }
  
  public void attachToFlutterEngine(@NonNull FlutterEngine paramFlutterEngine)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Attaching to a FlutterEngine: ");
    ((StringBuilder)localObject).append(paramFlutterEngine);
    Log.d("FlutterView", ((StringBuilder)localObject).toString());
    if (isAttachedToFlutterEngine()) {
      if (paramFlutterEngine == this.flutterEngine) {
        Log.d("FlutterView", "Already attached to this engine. Doing nothing.");
      }
    }
    for (;;)
    {
      return;
      Log.d("FlutterView", "Currently attached to a different engine. Detaching and then attaching to new engine.");
      detachFromFlutterEngine();
      this.flutterEngine = paramFlutterEngine;
      localObject = this.flutterEngine.getRenderer();
      this.isFlutterUiDisplayed = ((FlutterRenderer)localObject).isDisplayingFlutterUi();
      this.renderSurface.attachToRenderer((FlutterRenderer)localObject);
      ((FlutterRenderer)localObject).addIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
      this.flutterEngine.getPlatformViewsController().attachToView(this);
      if (this.textInputPlugin == null) {
        this.textInputPlugin = new XTextInputPlugin(this, paramFlutterEngine.getTextInputChannel(), this.flutterEngine.getPlatformViewsController());
      }
      this.textInputPlugin.setTextInputMethodHandler();
      this.textInputPlugin.getInputMethodManager().restartInput(this);
      this.androidKeyProcessor = new XAndroidKeyProcessor(this.flutterEngine.getKeyEventChannel(), this.textInputPlugin);
      this.androidTouchProcessor = new AndroidTouchProcessor(this.flutterEngine.getRenderer());
      this.accessibilityBridge = new AccessibilityBridge(this, paramFlutterEngine.getAccessibilityChannel(), (AccessibilityManager)getContext().getSystemService("accessibility"), getContext().getContentResolver(), this.flutterEngine.getPlatformViewsController());
      this.accessibilityBridge.setOnAccessibilityChangeListener(this.onAccessibilityChangeListener);
      resetWillNotDraw(this.accessibilityBridge.isAccessibilityEnabled(), this.accessibilityBridge.isTouchExplorationEnabled());
      this.flutterEngine.getPlatformViewsController().attachAccessibilityBridge(this.accessibilityBridge);
      this.textInputPlugin.getInputMethodManager().restartInput(this);
      sendUserSettingsToFlutter();
      sendLocalesToFlutter(getResources().getConfiguration());
      sendViewportMetricsToFlutter();
      localObject = this.flutterEngineAttachmentListeners.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((FlutterView.FlutterEngineAttachmentListener)((Iterator)localObject).next()).onFlutterEngineAttachedToFlutterView(paramFlutterEngine);
      }
    }
  }
  
  public boolean checkInputConnectionProxy(View paramView)
  {
    if (this.flutterEngine != null) {
      return this.flutterEngine.getPlatformViewsController().checkInputConnectionProxy(paramView);
    }
    return super.checkInputConnectionProxy(paramView);
  }
  
  public void detachFromFlutterEngine()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Detaching from a FlutterEngine: ");
    ((StringBuilder)localObject).append(this.flutterEngine);
    Log.d("FlutterView", ((StringBuilder)localObject).toString());
    if (!isAttachedToFlutterEngine())
    {
      Log.d("FlutterView", "Not attached to an engine. Doing nothing.");
      return;
    }
    localObject = this.flutterEngineAttachmentListeners.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((FlutterView.FlutterEngineAttachmentListener)((Iterator)localObject).next()).onFlutterEngineDetachedFromFlutterView();
    }
    this.flutterEngine.getPlatformViewsController().detachAccessibiltyBridge();
    this.flutterEngine.getPlatformViewsController().detachFromView();
    this.accessibilityBridge.release();
    this.accessibilityBridge = null;
    localObject = this.flutterEngine.getRenderer();
    this.isFlutterUiDisplayed = false;
    ((FlutterRenderer)localObject).removeIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
    ((FlutterRenderer)localObject).stopRenderingToSurface();
    ((FlutterRenderer)localObject).setSemanticsEnabled(false);
    this.renderSurface.detachFromRenderer();
    this.flutterEngine = null;
  }
  
  protected boolean fitSystemWindows(@NonNull Rect paramRect)
  {
    if (Build.VERSION.SDK_INT <= 19)
    {
      this.viewportMetrics.paddingTop = paramRect.top;
      this.viewportMetrics.paddingRight = paramRect.right;
      this.viewportMetrics.paddingBottom = 0;
      this.viewportMetrics.paddingLeft = paramRect.left;
      this.viewportMetrics.viewInsetTop = 0;
      this.viewportMetrics.viewInsetRight = 0;
      this.viewportMetrics.viewInsetBottom = paramRect.bottom;
      this.viewportMetrics.viewInsetLeft = 0;
      paramRect = new StringBuilder();
      paramRect.append("Updating window insets (fitSystemWindows()):\nStatus bar insets: Top: ");
      paramRect.append(this.viewportMetrics.paddingTop);
      paramRect.append(", Left: ");
      paramRect.append(this.viewportMetrics.paddingLeft);
      paramRect.append(", Right: ");
      paramRect.append(this.viewportMetrics.paddingRight);
      paramRect.append("\nKeyboard insets: Bottom: ");
      paramRect.append(this.viewportMetrics.viewInsetBottom);
      paramRect.append(", Left: ");
      paramRect.append(this.viewportMetrics.viewInsetLeft);
      paramRect.append(", Right: ");
      paramRect.append(this.viewportMetrics.viewInsetRight);
      Log.v("FlutterView", paramRect.toString());
      sendViewportMetricsToFlutter();
      return true;
    }
    return super.fitSystemWindows(paramRect);
  }
  
  @Nullable
  public AccessibilityNodeProvider getAccessibilityNodeProvider()
  {
    if ((this.accessibilityBridge != null) && (this.accessibilityBridge.isAccessibilityEnabled())) {
      return this.accessibilityBridge;
    }
    return null;
  }
  
  @Nullable
  @VisibleForTesting
  public FlutterEngine getAttachedFlutterEngine()
  {
    return this.flutterEngine;
  }
  
  public boolean hasRenderedFirstFrame()
  {
    return this.didRenderFirstFrame;
  }
  
  @VisibleForTesting
  public boolean isAttachedToFlutterEngine()
  {
    return this.flutterEngine != null;
  }
  
  @SuppressLint({"InlinedApi", "NewApi"})
  @TargetApi(20)
  @NonNull
  @RequiresApi(20)
  public final WindowInsets onApplyWindowInsets(@NonNull WindowInsets paramWindowInsets)
  {
    WindowInsets localWindowInsets = super.onApplyWindowInsets(paramWindowInsets);
    this.viewportMetrics.paddingTop = paramWindowInsets.getSystemWindowInsetTop();
    this.viewportMetrics.paddingRight = paramWindowInsets.getSystemWindowInsetRight();
    this.viewportMetrics.paddingBottom = 0;
    this.viewportMetrics.paddingLeft = paramWindowInsets.getSystemWindowInsetLeft();
    this.viewportMetrics.viewInsetTop = 0;
    this.viewportMetrics.viewInsetRight = 0;
    this.viewportMetrics.viewInsetBottom = paramWindowInsets.getSystemWindowInsetBottom();
    this.viewportMetrics.viewInsetLeft = 0;
    paramWindowInsets = new StringBuilder();
    paramWindowInsets.append("Updating window insets (onApplyWindowInsets()):\nStatus bar insets: Top: ");
    paramWindowInsets.append(this.viewportMetrics.paddingTop);
    paramWindowInsets.append(", Left: ");
    paramWindowInsets.append(this.viewportMetrics.paddingLeft);
    paramWindowInsets.append(", Right: ");
    paramWindowInsets.append(this.viewportMetrics.paddingRight);
    paramWindowInsets.append("\nKeyboard insets: Bottom: ");
    paramWindowInsets.append(this.viewportMetrics.viewInsetBottom);
    paramWindowInsets.append(", Left: ");
    paramWindowInsets.append(this.viewportMetrics.viewInsetLeft);
    paramWindowInsets.append(", Right: ");
    paramWindowInsets.append(this.viewportMetrics.viewInsetRight);
    paramWindowInsets.append("System Gesture Insets - Left: ");
    paramWindowInsets.append(this.viewportMetrics.systemGestureInsetLeft);
    paramWindowInsets.append(", Top: ");
    paramWindowInsets.append(this.viewportMetrics.systemGestureInsetTop);
    paramWindowInsets.append(", Right: ");
    paramWindowInsets.append(this.viewportMetrics.systemGestureInsetRight);
    paramWindowInsets.append(", Bottom: ");
    paramWindowInsets.append(this.viewportMetrics.viewInsetBottom);
    Log.v("FlutterView", paramWindowInsets.toString());
    sendViewportMetricsToFlutter();
    return localWindowInsets;
  }
  
  protected void onConfigurationChanged(@NonNull Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    Log.v("FlutterView", "Configuration changed. Sending locales and user settings to Flutter.");
    try
    {
      sendLocalesToFlutter(paramConfiguration);
      sendUserSettingsToFlutter();
      return;
    }
    catch (Throwable paramConfiguration)
    {
      Log.e("FlutterView", "onConfigurationChanged error ");
    }
  }
  
  @Nullable
  public InputConnection onCreateInputConnection(@NonNull EditorInfo paramEditorInfo)
  {
    if (!isAttachedToFlutterEngine()) {
      return super.onCreateInputConnection(paramEditorInfo);
    }
    return this.textInputPlugin.createInputConnection(this, paramEditorInfo);
  }
  
  public boolean onGenericMotionEvent(@NonNull MotionEvent paramMotionEvent)
  {
    if ((isAttachedToFlutterEngine()) && (this.androidTouchProcessor.onGenericMotionEvent(paramMotionEvent))) {}
    for (int i = 1; i != 0; i = 0) {
      return true;
    }
    return super.onGenericMotionEvent(paramMotionEvent);
  }
  
  public boolean onHoverEvent(@NonNull MotionEvent paramMotionEvent)
  {
    if (!isAttachedToFlutterEngine()) {
      return super.onHoverEvent(paramMotionEvent);
    }
    return this.accessibilityBridge.onAccessibilityHoverEvent(paramMotionEvent);
  }
  
  public boolean onKeyDown(int paramInt, @NonNull KeyEvent paramKeyEvent)
  {
    if (!isAttachedToFlutterEngine()) {
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    this.androidKeyProcessor.onKeyDown(paramKeyEvent);
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, @NonNull KeyEvent paramKeyEvent)
  {
    if (!isAttachedToFlutterEngine()) {
      return super.onKeyUp(paramInt, paramKeyEvent);
    }
    this.androidKeyProcessor.onKeyUp(paramKeyEvent);
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Size changed. Sending Flutter new viewport metrics. FlutterView was ");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(" x ");
    localStringBuilder.append(paramInt4);
    localStringBuilder.append(", it is now ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" x ");
    localStringBuilder.append(paramInt2);
    Log.v("FlutterView", localStringBuilder.toString());
    this.viewportMetrics.width = paramInt1;
    this.viewportMetrics.height = paramInt2;
    sendViewportMetricsToFlutter();
  }
  
  public boolean onTouchEvent(@NonNull MotionEvent paramMotionEvent)
  {
    if (!isAttachedToFlutterEngine()) {
      return super.onTouchEvent(paramMotionEvent);
    }
    if (Build.VERSION.SDK_INT >= 21) {
      requestUnbufferedDispatch(paramMotionEvent);
    }
    return this.androidTouchProcessor.onTouchEvent(paramMotionEvent);
  }
  
  public void release()
  {
    if (this.textInputPlugin != null) {
      this.textInputPlugin.release();
    }
  }
  
  @VisibleForTesting
  public void removeFlutterEngineAttachmentListener(@NonNull FlutterView.FlutterEngineAttachmentListener paramFlutterEngineAttachmentListener)
  {
    this.flutterEngineAttachmentListeners.remove(paramFlutterEngineAttachmentListener);
  }
  
  public void removeOnFirstFrameRenderedListener(@NonNull FlutterUiDisplayListener paramFlutterUiDisplayListener)
  {
    this.flutterUiDisplayListeners.remove(paramFlutterUiDisplayListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.idlefish.flutterboost.XFlutterView
 * JD-Core Version:    0.7.0.1
 */