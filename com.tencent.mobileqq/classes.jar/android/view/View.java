package android.view;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Property;
import android.util.SparseArray;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityEventSource;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import java.util.ArrayList;

@SuppressLint({"NewApi"})
public class View
  implements Drawable.Callback, KeyEvent.Callback, AccessibilityEventSource
{
  public static Property<View, Float> ALPHA;
  public static final int DRAWING_CACHE_QUALITY_AUTO = 0;
  public static final int DRAWING_CACHE_QUALITY_HIGH = 1048576;
  public static final int DRAWING_CACHE_QUALITY_LOW = 524288;
  public static final int[] EMPTY_STATE_SET = null;
  protected static final int[] ENABLED_FOCUSED_SELECTED_STATE_SET;
  protected static final int[] ENABLED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET;
  protected static final int[] ENABLED_FOCUSED_STATE_SET;
  protected static final int[] ENABLED_FOCUSED_WINDOW_FOCUSED_STATE_SET;
  protected static final int[] ENABLED_SELECTED_STATE_SET;
  protected static final int[] ENABLED_SELECTED_WINDOW_FOCUSED_STATE_SET;
  protected static final int[] ENABLED_STATE_SET = null;
  protected static final int[] ENABLED_WINDOW_FOCUSED_STATE_SET;
  public static final int FIND_VIEWS_WITH_CONTENT_DESCRIPTION = 2;
  public static final int FIND_VIEWS_WITH_TEXT = 1;
  public static final int FOCUSABLES_ALL = 0;
  public static final int FOCUSABLES_TOUCH_MODE = 1;
  protected static final int[] FOCUSED_SELECTED_STATE_SET;
  protected static final int[] FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET;
  protected static final int[] FOCUSED_STATE_SET = null;
  protected static final int[] FOCUSED_WINDOW_FOCUSED_STATE_SET;
  public static final int FOCUS_BACKWARD = 1;
  public static final int FOCUS_DOWN = 130;
  public static final int FOCUS_FORWARD = 2;
  public static final int FOCUS_LEFT = 17;
  public static final int FOCUS_RIGHT = 66;
  public static final int FOCUS_UP = 33;
  public static final int GONE = 8;
  public static final int HAPTIC_FEEDBACK_ENABLED = 268435456;
  public static final int INVISIBLE = 4;
  public static final int KEEP_SCREEN_ON = 67108864;
  public static final int LAYER_TYPE_HARDWARE = 2;
  public static final int LAYER_TYPE_NONE = 0;
  public static final int LAYER_TYPE_SOFTWARE = 1;
  public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
  public static final int MEASURED_SIZE_MASK = 16777215;
  public static final int MEASURED_STATE_MASK = -16777216;
  public static final int MEASURED_STATE_TOO_SMALL = 16777216;
  public static final int NO_ID = -1;
  public static final int OVER_SCROLL_ALWAYS = 0;
  public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
  public static final int OVER_SCROLL_NEVER = 2;
  protected static final int[] PRESSED_ENABLED_FOCUSED_SELECTED_STATE_SET = null;
  protected static final int[] PRESSED_ENABLED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET = null;
  protected static final int[] PRESSED_ENABLED_FOCUSED_STATE_SET;
  protected static final int[] PRESSED_ENABLED_FOCUSED_WINDOW_FOCUSED_STATE_SET;
  protected static final int[] PRESSED_ENABLED_SELECTED_STATE_SET;
  protected static final int[] PRESSED_ENABLED_SELECTED_WINDOW_FOCUSED_STATE_SET;
  public static final int[] PRESSED_ENABLED_STATE_SET;
  protected static final int[] PRESSED_ENABLED_WINDOW_FOCUSED_STATE_SET;
  protected static final int[] PRESSED_FOCUSED_SELECTED_STATE_SET;
  protected static final int[] PRESSED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET;
  protected static final int[] PRESSED_FOCUSED_STATE_SET;
  protected static final int[] PRESSED_FOCUSED_WINDOW_FOCUSED_STATE_SET;
  protected static final int[] PRESSED_SELECTED_STATE_SET;
  protected static final int[] PRESSED_SELECTED_WINDOW_FOCUSED_STATE_SET;
  protected static final int[] PRESSED_WINDOW_FOCUSED_STATE_SET;
  public static Property<View, Float> ROTATION;
  public static Property<View, Float> ROTATION_X;
  public static Property<View, Float> ROTATION_Y;
  public static Property<View, Float> SCALE_X;
  public static Property<View, Float> SCALE_Y;
  public static final int SCROLLBARS_INSIDE_INSET = 16777216;
  public static final int SCROLLBARS_INSIDE_OVERLAY = 0;
  public static final int SCROLLBARS_OUTSIDE_INSET = 50331648;
  public static final int SCROLLBARS_OUTSIDE_OVERLAY = 33554432;
  public static final int SCROLLBAR_POSITION_DEFAULT = 0;
  public static final int SCROLLBAR_POSITION_LEFT = 1;
  public static final int SCROLLBAR_POSITION_RIGHT = 2;
  public static final int[] SELECTED_STATE_SET = null;
  protected static final int[] SELECTED_WINDOW_FOCUSED_STATE_SET;
  public static final int SOUND_EFFECTS_ENABLED = 134217728;
  @Deprecated
  public static final int STATUS_BAR_HIDDEN = 1;
  @Deprecated
  public static final int STATUS_BAR_VISIBLE = 0;
  public static final int SYSTEM_UI_FLAG_FULLSCREEN = 4;
  public static final int SYSTEM_UI_FLAG_HIDE_NAVIGATION = 2;
  public static final int SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN = 1024;
  public static final int SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION = 512;
  public static final int SYSTEM_UI_FLAG_LAYOUT_STABLE = 256;
  public static final int SYSTEM_UI_FLAG_LIGHT_STATUS_BAR = 8192;
  public static final int SYSTEM_UI_FLAG_LOW_PROFILE = 1;
  public static final int SYSTEM_UI_FLAG_VISIBLE = 0;
  public static Property<View, Float> TRANSLATION_X;
  public static Property<View, Float> TRANSLATION_Y;
  protected static final String VIEW_LOG_TAG = "View";
  public static final int VISIBLE = 0;
  protected static final int[] WINDOW_FOCUSED_STATE_SET = null;
  public static Property<View, Float> X;
  public static Property<View, Float> Y;
  @ViewDebug.ExportedProperty(category="layout")
  public int mBottom;
  @ViewDebug.ExportedProperty(category="layout")
  protected int mLeft;
  @ViewDebug.ExportedProperty(category="padding")
  public int mPaddingBottom;
  @ViewDebug.ExportedProperty(category="padding")
  protected int mPaddingLeft;
  @ViewDebug.ExportedProperty(category="padding")
  protected int mPaddingRight;
  @ViewDebug.ExportedProperty(category="padding")
  public int mPaddingTop;
  public ViewParent mParent;
  @ViewDebug.ExportedProperty(category="layout")
  protected int mRight;
  @ViewDebug.ExportedProperty(category="scrolling")
  protected int mScrollX;
  @ViewDebug.ExportedProperty(category="scrolling")
  public int mScrollY;
  @ViewDebug.ExportedProperty(category="layout")
  public int mTop;
  
  static
  {
    ENABLED_FOCUSED_STATE_SET = null;
    ENABLED_SELECTED_STATE_SET = null;
    ENABLED_WINDOW_FOCUSED_STATE_SET = null;
    FOCUSED_SELECTED_STATE_SET = null;
    FOCUSED_WINDOW_FOCUSED_STATE_SET = null;
    SELECTED_WINDOW_FOCUSED_STATE_SET = null;
    ENABLED_FOCUSED_SELECTED_STATE_SET = null;
    ENABLED_FOCUSED_WINDOW_FOCUSED_STATE_SET = null;
    ENABLED_SELECTED_WINDOW_FOCUSED_STATE_SET = null;
    FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET = null;
    ENABLED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET = null;
    PRESSED_WINDOW_FOCUSED_STATE_SET = null;
    PRESSED_SELECTED_STATE_SET = null;
    PRESSED_SELECTED_WINDOW_FOCUSED_STATE_SET = null;
    PRESSED_FOCUSED_STATE_SET = null;
    PRESSED_FOCUSED_WINDOW_FOCUSED_STATE_SET = null;
    PRESSED_FOCUSED_SELECTED_STATE_SET = null;
    PRESSED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET = null;
    PRESSED_ENABLED_STATE_SET = null;
    PRESSED_ENABLED_WINDOW_FOCUSED_STATE_SET = null;
    PRESSED_ENABLED_SELECTED_STATE_SET = null;
    PRESSED_ENABLED_SELECTED_WINDOW_FOCUSED_STATE_SET = null;
    PRESSED_ENABLED_FOCUSED_STATE_SET = null;
    PRESSED_ENABLED_FOCUSED_WINDOW_FOCUSED_STATE_SET = null;
  }
  
  public View(Context paramContext)
  {
    throw new RuntimeException("Stub!");
  }
  
  public View(Context paramContext, AttributeSet paramAttributeSet)
  {
    throw new RuntimeException("Stub!");
  }
  
  public View(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public static int combineMeasuredStates(int paramInt1, int paramInt2)
  {
    throw new RuntimeException("Stub!");
  }
  
  public static int generateViewId()
  {
    throw new RuntimeException("Stub!");
  }
  
  public static int getDefaultSize(int paramInt1, int paramInt2)
  {
    throw new RuntimeException("Stub!");
  }
  
  public static View inflate(Context paramContext, int paramInt, ViewGroup paramViewGroup)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected static int[] mergeDrawableStates(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    throw new RuntimeException("Stub!");
  }
  
  public static int resolveSize(int paramInt1, int paramInt2)
  {
    throw new RuntimeException("Stub!");
  }
  
  public static int resolveSizeAndState(int paramInt1, int paramInt2, int paramInt3)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void addChildrenForAccessibility(ArrayList<View> paramArrayList)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void addOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void addOnLayoutChangeListener(View.OnLayoutChangeListener paramOnLayoutChangeListener)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void addTouchables(ArrayList<View> paramArrayList)
  {
    throw new RuntimeException("Stub!");
  }
  
  public ViewPropertyAnimator animate()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean awakenScrollBars()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected boolean awakenScrollBars(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected boolean awakenScrollBars(int paramInt, boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void bringToFront()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void buildDrawingCache()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void buildDrawingCache(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void buildLayer()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean callOnClick()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean canResolveLayoutDirection()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean canResolveTextAlignment()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean canResolveTextDirection()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void cancelLongPress()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean checkInputConnectionProxy(View paramView)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void clearAnimation()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void clearFocus()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected int computeHorizontalScrollExtent()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected int computeHorizontalScrollOffset()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected int computeHorizontalScrollRange()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void computeScroll()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected int computeVerticalScrollExtent()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected int computeVerticalScrollOffset()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected int computeVerticalScrollRange()
  {
    throw new RuntimeException("Stub!");
  }
  
  public AccessibilityNodeInfo createAccessibilityNodeInfo()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void createContextMenu(ContextMenu paramContextMenu)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void destroyDrawingCache()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void dispatchDisplayHint(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean dispatchDragEvent(DragEvent paramDragEvent)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected boolean dispatchGenericFocusedEvent(MotionEvent paramMotionEvent)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean dispatchGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected boolean dispatchGenericPointerEvent(MotionEvent paramMotionEvent)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean dispatchKeyEventPreIme(KeyEvent paramKeyEvent)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void dispatchSaveInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void dispatchSetActivated(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void dispatchSetPressed(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void dispatchSetSelected(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void dispatchSystemUiVisibilityChanged(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean dispatchTrackballEvent(MotionEvent paramMotionEvent)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean dispatchUnhandledMove(View paramView, int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void dispatchVisibilityChanged(View paramView, int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void dispatchWindowFocusChanged(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void dispatchWindowVisibilityChanged(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void draw(Canvas paramCanvas)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void drawableStateChanged()
  {
    throw new RuntimeException("Stub!");
  }
  
  public View findFocus()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final <T extends View> T findViewById(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final View findViewWithTag(Object paramObject)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void findViewsWithText(ArrayList<View> paramArrayList, CharSequence paramCharSequence, int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean fitsSystemWindows()
  {
    throw new RuntimeException("Stub!");
  }
  
  public View focusSearch(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void forceLayout()
  {
    throw new RuntimeException("Stub!");
  }
  
  public View.AccessibilityDelegate getAccessibilityDelegate()
  {
    throw new RuntimeException("Stub!");
  }
  
  public Object getAccessibilityNodeProvider()
  {
    throw new RuntimeException("Stub!");
  }
  
  public float getAlpha()
  {
    throw new RuntimeException("Stub!");
  }
  
  public Animation getAnimation()
  {
    throw new RuntimeException("Stub!");
  }
  
  public IBinder getApplicationWindowToken()
  {
    throw new RuntimeException("Stub!");
  }
  
  public Drawable getBackground()
  {
    throw new RuntimeException("Stub!");
  }
  
  @ViewDebug.ExportedProperty(category="layout")
  public int getBaseline()
  {
    throw new RuntimeException("Stub!");
  }
  
  @ViewDebug.CapturedViewProperty
  public final int getBottom()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected float getBottomFadingEdgeStrength()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected int getBottomPaddingOffset()
  {
    throw new RuntimeException("Stub!");
  }
  
  public Rect getClipBounds()
  {
    throw new RuntimeException("Stub!");
  }
  
  public CharSequence getContentDescription()
  {
    throw new RuntimeException("Stub!");
  }
  
  @ViewDebug.CapturedViewProperty
  public final Context getContext()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected ContextMenu.ContextMenuInfo getContextMenuInfo()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final int[] getDrawableState()
  {
    throw new RuntimeException("Stub!");
  }
  
  public Bitmap getDrawingCache()
  {
    throw new RuntimeException("Stub!");
  }
  
  public Bitmap getDrawingCache(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getDrawingCacheBackgroundColor()
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getDrawingCacheQuality()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void getDrawingRect(Rect paramRect)
  {
    throw new RuntimeException("Stub!");
  }
  
  public long getDrawingTime()
  {
    throw new RuntimeException("Stub!");
  }
  
  @ViewDebug.ExportedProperty
  public boolean getFilterTouchesWhenObscured()
  {
    throw new RuntimeException("Stub!");
  }
  
  public ArrayList<View> getFocusables(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void getFocusedRect(Rect paramRect)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final boolean getGlobalVisibleRect(Rect paramRect)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean getGlobalVisibleRect(Rect paramRect, Point paramPoint)
  {
    throw new RuntimeException("Stub!");
  }
  
  public Handler getHandler()
  {
    throw new RuntimeException("Stub!");
  }
  
  @ViewDebug.ExportedProperty(category="layout")
  public final int getHeight()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void getHitRect(Rect paramRect)
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getHorizontalFadingEdgeLength()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected int getHorizontalScrollbarHeight()
  {
    throw new RuntimeException("Stub!");
  }
  
  @ViewDebug.CapturedViewProperty
  public int getId()
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getImportantForAccessibility()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean getKeepScreenOn()
  {
    throw new RuntimeException("Stub!");
  }
  
  public KeyEvent.DispatcherState getKeyDispatcherState()
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getLayerType()
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getLayoutDirection()
  {
    throw new RuntimeException("Stub!");
  }
  
  @ViewDebug.ExportedProperty(deepExport=true, prefix="layout_")
  public ViewGroup.LayoutParams getLayoutParams()
  {
    throw new RuntimeException("Stub!");
  }
  
  @ViewDebug.CapturedViewProperty
  public final int getLeft()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected float getLeftFadingEdgeStrength()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected int getLeftPaddingOffset()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final boolean getLocalVisibleRect(Rect paramRect)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void getLocationInWindow(int[] paramArrayOfInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void getLocationOnScreen(int[] paramArrayOfInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public Matrix getMatrix()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final int getMeasuredHeight()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final int getMeasuredHeightAndState()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final int getMeasuredState()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final int getMeasuredWidth()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final int getMeasuredWidthAndState()
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getNextFocusDownId()
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getNextFocusForwardId()
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getNextFocusLeftId()
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getNextFocusRightId()
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getNextFocusUpId()
  {
    throw new RuntimeException("Stub!");
  }
  
  public View.OnFocusChangeListener getOnFocusChangeListener()
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getOverScrollMode()
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getPaddingBottom()
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getPaddingLeft()
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getPaddingRight()
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getPaddingTop()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final ViewParent getParent()
  {
    throw new RuntimeException("Stub!");
  }
  
  public ViewParent getParentForAccessibility()
  {
    throw new RuntimeException("Stub!");
  }
  
  public float getPivotX()
  {
    throw new RuntimeException("Stub!");
  }
  
  public float getPivotY()
  {
    throw new RuntimeException("Stub!");
  }
  
  public Resources getResources()
  {
    throw new RuntimeException("Stub!");
  }
  
  @ViewDebug.CapturedViewProperty
  public final int getRight()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected float getRightFadingEdgeStrength()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected int getRightPaddingOffset()
  {
    throw new RuntimeException("Stub!");
  }
  
  public View getRootView()
  {
    throw new RuntimeException("Stub!");
  }
  
  public float getRotation()
  {
    throw new RuntimeException("Stub!");
  }
  
  public float getRotationX()
  {
    throw new RuntimeException("Stub!");
  }
  
  public float getRotationY()
  {
    throw new RuntimeException("Stub!");
  }
  
  public float getScaleX()
  {
    throw new RuntimeException("Stub!");
  }
  
  public float getScaleY()
  {
    throw new RuntimeException("Stub!");
  }
  
  @ViewDebug.ExportedProperty(mapping={@ViewDebug.IntToString(from=0, to="INSIDE_OVERLAY"), @ViewDebug.IntToString(from=16777216, to="INSIDE_INSET"), @ViewDebug.IntToString(from=33554432, to="OUTSIDE_OVERLAY"), @ViewDebug.IntToString(from=50331648, to="OUTSIDE_INSET")})
  public int getScrollBarStyle()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final int getScrollX()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final int getScrollY()
  {
    throw new RuntimeException("Stub!");
  }
  
  @ViewDebug.ExportedProperty(category="drawing")
  public int getSolidColor()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected int getSuggestedMinimumHeight()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected int getSuggestedMinimumWidth()
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getSystemUiVisibility()
  {
    throw new RuntimeException("Stub!");
  }
  
  @ViewDebug.ExportedProperty
  public Object getTag()
  {
    throw new RuntimeException("Stub!");
  }
  
  public Object getTag(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getTextAlignment()
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getTextDirection()
  {
    throw new RuntimeException("Stub!");
  }
  
  @ViewDebug.CapturedViewProperty
  public final int getTop()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected float getTopFadingEdgeStrength()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected int getTopPaddingOffset()
  {
    throw new RuntimeException("Stub!");
  }
  
  public TouchDelegate getTouchDelegate()
  {
    throw new RuntimeException("Stub!");
  }
  
  public ArrayList<View> getTouchables()
  {
    throw new RuntimeException("Stub!");
  }
  
  public float getTranslationX()
  {
    throw new RuntimeException("Stub!");
  }
  
  public float getTranslationY()
  {
    throw new RuntimeException("Stub!");
  }
  
  public float getTranslationZ()
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getVerticalFadingEdgeLength()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected float getVerticalScrollFactor()
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getVerticalScrollbarPosition()
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getVerticalScrollbarWidth()
  {
    throw new RuntimeException("Stub!");
  }
  
  public ViewTreeObserver getViewTreeObserver()
  {
    throw new RuntimeException("Stub!");
  }
  
  @ViewDebug.ExportedProperty(mapping={@ViewDebug.IntToString(from=0, to="VISIBLE"), @ViewDebug.IntToString(from=4, to="INVISIBLE"), @ViewDebug.IntToString(from=8, to="GONE")})
  public int getVisibility()
  {
    throw new RuntimeException("Stub!");
  }
  
  @ViewDebug.ExportedProperty(category="layout")
  public final int getWidth()
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getWindowAttachCount()
  {
    throw new RuntimeException("Stub!");
  }
  
  public IBinder getWindowToken()
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getWindowVisibility()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void getWindowVisibleDisplayFrame(Rect paramRect)
  {
    throw new RuntimeException("Stub!");
  }
  
  public float getX()
  {
    throw new RuntimeException("Stub!");
  }
  
  public float getY()
  {
    throw new RuntimeException("Stub!");
  }
  
  @ViewDebug.ExportedProperty(category="focus")
  public boolean hasFocus()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean hasFocusable()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean hasOnClickListeners()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean hasTransientState()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean hasWindowFocus()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean includeForAccessibility()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void initializeFadingEdge(TypedArray paramTypedArray)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void initializeScrollbars(TypedArray paramTypedArray)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void invalidate()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void invalidate(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void invalidate(Rect paramRect)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    throw new RuntimeException("Stub!");
  }
  
  @ViewDebug.ExportedProperty
  public boolean isActivated()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isAttachedToWindow()
  {
    throw new RuntimeException("Stub!");
  }
  
  @ViewDebug.ExportedProperty
  public boolean isClickable()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isDirty()
  {
    throw new RuntimeException("Stub!");
  }
  
  @ViewDebug.ExportedProperty(category="drawing")
  public boolean isDrawingCacheEnabled()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isDuplicateParentStateEnabled()
  {
    throw new RuntimeException("Stub!");
  }
  
  @ViewDebug.ExportedProperty
  public boolean isEnabled()
  {
    throw new RuntimeException("Stub!");
  }
  
  @ViewDebug.ExportedProperty(category="focus")
  public final boolean isFocusable()
  {
    throw new RuntimeException("Stub!");
  }
  
  @ViewDebug.ExportedProperty
  public final boolean isFocusableInTouchMode()
  {
    throw new RuntimeException("Stub!");
  }
  
  @ViewDebug.ExportedProperty(category="focus")
  public boolean isFocused()
  {
    throw new RuntimeException("Stub!");
  }
  
  @ViewDebug.ExportedProperty
  public boolean isHapticFeedbackEnabled()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isHardwareAccelerated()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isHorizontalFadingEdgeEnabled()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isHorizontalScrollBarEnabled()
  {
    throw new RuntimeException("Stub!");
  }
  
  @ViewDebug.ExportedProperty
  public boolean isHovered()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isInEditMode()
  {
    throw new RuntimeException("Stub!");
  }
  
  @ViewDebug.ExportedProperty
  public boolean isInTouchMode()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isLayoutDirectionResolved()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isLayoutRequested()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isLongClickable()
  {
    throw new RuntimeException("Stub!");
  }
  
  @ViewDebug.ExportedProperty(category="drawing")
  public boolean isOpaque()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected boolean isPaddingOffsetRequired()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isPressed()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isSaveEnabled()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isSaveFromParentEnabled()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isScrollbarFadingEnabled()
  {
    throw new RuntimeException("Stub!");
  }
  
  @ViewDebug.ExportedProperty
  public boolean isSelected()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isShown()
  {
    throw new RuntimeException("Stub!");
  }
  
  @ViewDebug.ExportedProperty
  public boolean isSoundEffectsEnabled()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isTextAlignmentResolved()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isTextDirectionResolved()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isVerticalFadingEdgeEnabled()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isVerticalScrollBarEnabled()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void jumpDrawablesToCurrentState()
  {
    throw new RuntimeException("Stub!");
  }
  
  public View keyboardNavigationClusterSearch(View paramView, int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void layout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final void measure(int paramInt1, int paramInt2)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void notifyViewAccessibilityStateChangedIfNeeded(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void offsetLeftAndRight(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void offsetTopAndBottom(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void onAnimationEnd()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void onAnimationStart()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void onAttachedToWindow()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean onCheckIsTextEditor()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected boolean onConsistencyCheck(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void onCreateContextMenu(ContextMenu paramContextMenu)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void onDetachedFromWindow()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void onDisplayHint(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean onDragEvent(DragEvent paramDragEvent)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected final void onDrawScrollBars(Canvas paramCanvas)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean onFilterTouchEventForSecurity(MotionEvent paramMotionEvent)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void onFinishInflate()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void onFinishTemporaryDetach()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void onHoverChanged(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean onKeyLongPress(int paramInt, KeyEvent paramKeyEvent)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean onKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    throw new RuntimeException("Stub!");
  }
  
  public Parcelable onSaveInstanceState()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected boolean onSetAlpha(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void onStartTemporaryDetach()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean onTrackballEvent(MotionEvent paramMotionEvent)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean performAccessibilityAction(int paramInt, Bundle paramBundle)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean performClick()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean performHapticFeedback(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean performHapticFeedback(int paramInt1, int paramInt2)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean performLongClick()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void playSoundEffect(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean post(Runnable paramRunnable)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean postDelayed(Runnable paramRunnable, long paramLong)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void postInvalidate()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void postInvalidate(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void postInvalidateDelayed(long paramLong)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void postInvalidateDelayed(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void postInvalidateOnAnimation()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void postOnAnimation(Runnable paramRunnable)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void postOnAnimationDelayed(Runnable paramRunnable, long paramLong)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void refreshDrawableState()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean removeCallbacks(Runnable paramRunnable)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void removeOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void removeOnLayoutChangeListener(View.OnLayoutChangeListener paramOnLayoutChangeListener)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final boolean requestFocus()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final boolean requestFocus(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean requestFocus(int paramInt, Rect paramRect)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final boolean requestFocusFromTouch()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void requestLayout()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean requestRectangleOnScreen(Rect paramRect)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean requestRectangleOnScreen(Rect paramRect, boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void restoreHierarchyState(SparseArray<Parcelable> paramSparseArray)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void saveHierarchyState(SparseArray<Parcelable> paramSparseArray)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void sendAccessibilityEvent(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void sendAccessibilityEventUnchecked(AccessibilityEvent paramAccessibilityEvent)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setAccessibilityDelegate(View.AccessibilityDelegate paramAccessibilityDelegate)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setActivated(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setAlpha(float paramFloat)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setAnimation(Animation paramAnimation)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setBackgroundColor(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setBackgroundResource(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final void setBottom(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setCameraDistance(float paramFloat)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setClickable(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setClipBounds(Rect paramRect)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setClipToOutline(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setContentDescription(CharSequence paramCharSequence)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setDrawingCacheBackgroundColor(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setDrawingCacheEnabled(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setDrawingCacheQuality(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setDuplicateParentStateEnabled(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setElevation(float paramFloat)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setFadingEdgeLength(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setFilterTouchesWhenObscured(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setFitsSystemWindows(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setFocusable(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setFocusableInTouchMode(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setForeground(Drawable paramDrawable)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setHapticFeedbackEnabled(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setHasTransientState(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setHorizontalFadingEdgeEnabled(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setHorizontalScrollBarEnabled(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setHovered(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setId(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setImportantForAccessibility(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setKeepScreenOn(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setLayerType(int paramInt, Paint paramPaint)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final void setLeft(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setLongClickable(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final void setMeasuredDimension(int paramInt1, int paramInt2)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setMinimumHeight(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setMinimumWidth(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setNextFocusDownId(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setNextFocusForwardId(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setNextFocusLeftId(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setNextFocusRightId(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setNextFocusUpId(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setOnCreateContextMenuListener(View.OnCreateContextMenuListener paramOnCreateContextMenuListener)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setOnDragListener(View.OnDragListener paramOnDragListener)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setOnGenericMotionListener(View.OnGenericMotionListener paramOnGenericMotionListener)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setOnHoverListener(View.OnHoverListener paramOnHoverListener)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setOnKeyListener(View.OnKeyListener paramOnKeyListener)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setOnSystemUiVisibilityChangeListener(View.OnSystemUiVisibilityChangeListener paramOnSystemUiVisibilityChangeListener)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setOutlineProvider(ViewOutlineProvider paramViewOutlineProvider)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setOverScrollMode(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setPivotX(float paramFloat)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setPivotY(float paramFloat)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setPressed(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final void setRight(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setRotation(float paramFloat)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setRotationX(float paramFloat)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setRotationY(float paramFloat)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setSaveEnabled(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setSaveFromParentEnabled(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setScaleX(float paramFloat)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setScaleY(float paramFloat)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setScrollBarStyle(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setScrollContainer(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setScrollX(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setScrollY(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setScrollbarFadingEnabled(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setSelected(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setSoundEffectsEnabled(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setSystemUiVisibility(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setTag(int paramInt, Object paramObject)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setTag(Object paramObject)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final void setTop(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setTouchDelegate(TouchDelegate paramTouchDelegate)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setTranslationX(float paramFloat)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setTranslationY(float paramFloat)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setTranslationZ(float paramFloat)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setVerticalFadingEdgeEnabled(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setVerticalScrollBarEnabled(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setVerticalScrollbarPosition(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setVisibility(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setWillNotCacheDrawing(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setWillNotDraw(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setX(float paramFloat)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setY(float paramFloat)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean showContextMenu()
  {
    throw new RuntimeException("Stub!");
  }
  
  public ActionMode startActionMode(ActionMode.Callback paramCallback)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void startAnimation(Animation paramAnimation)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final boolean startDrag(ClipData paramClipData, View.DragShadowBuilder paramDragShadowBuilder, Object paramObject, int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void unscheduleDrawable(Drawable paramDrawable)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    throw new RuntimeException("Stub!");
  }
  
  @ViewDebug.ExportedProperty(category="drawing")
  public boolean willNotCacheDrawing()
  {
    throw new RuntimeException("Stub!");
  }
  
  @ViewDebug.ExportedProperty(category="drawing")
  public boolean willNotDraw()
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     android.view.View
 * JD-Core Version:    0.7.0.1
 */