package com.tencent.aelight.camera.aeeditor.lyric.interaction;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Iterator;
import java.util.List;

public class AESlidingUpPanelLayout
  extends ViewGroup
{
  private static AESlidingUpPanelLayout.PanelState a = AESlidingUpPanelLayout.PanelState.COLLAPSED;
  private static final int[] b = { 16842927 };
  private float A;
  private float B;
  private float C;
  private float D;
  private boolean E;
  private final List<AESlidingUpPanelLayout.PanelSlideListener> F;
  private View.OnClickListener G;
  private final ViewDragHelper H;
  private boolean I;
  private final Rect J;
  private int c;
  private int d;
  private final Paint e;
  private final Drawable f;
  private int g;
  private int h;
  private int i;
  private boolean j;
  private boolean k;
  private boolean l;
  private View m;
  private int n;
  private View o;
  private int p;
  private ScrollableViewHelper q;
  private View r;
  private View s;
  private AESlidingUpPanelLayout.PanelState t;
  private AESlidingUpPanelLayout.PanelState u;
  private float v;
  private int w;
  private float x;
  private boolean y;
  private boolean z;
  
  public AESlidingUpPanelLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AESlidingUpPanelLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  /* Error */
  public AESlidingUpPanelLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: iload_3
    //   4: invokespecial 76	android/view/ViewGroup:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   7: aload_0
    //   8: sipush 400
    //   11: putfield 78	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:c	I
    //   14: aload_0
    //   15: iconst_0
    //   16: putfield 80	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:d	I
    //   19: aload_0
    //   20: new 82	android/graphics/Paint
    //   23: dup
    //   24: invokespecial 84	android/graphics/Paint:<init>	()V
    //   27: putfield 86	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:e	Landroid/graphics/Paint;
    //   30: aload_0
    //   31: iconst_m1
    //   32: putfield 88	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:g	I
    //   35: aload_0
    //   36: iconst_m1
    //   37: putfield 90	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:h	I
    //   40: aload_0
    //   41: iconst_m1
    //   42: putfield 92	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:i	I
    //   45: aload_0
    //   46: iconst_0
    //   47: putfield 94	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:k	Z
    //   50: aload_0
    //   51: iconst_1
    //   52: putfield 96	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:l	Z
    //   55: aload_0
    //   56: iconst_m1
    //   57: putfield 98	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:n	I
    //   60: aload_0
    //   61: new 100	com/tencent/aelight/camera/aeeditor/lyric/interaction/ScrollableViewHelper
    //   64: dup
    //   65: invokespecial 101	com/tencent/aelight/camera/aeeditor/lyric/interaction/ScrollableViewHelper:<init>	()V
    //   68: putfield 103	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:q	Lcom/tencent/aelight/camera/aeeditor/lyric/interaction/ScrollableViewHelper;
    //   71: getstatic 61	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:a	Lcom/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout$PanelState;
    //   74: astore 5
    //   76: aload_0
    //   77: aload 5
    //   79: putfield 105	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:t	Lcom/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout$PanelState;
    //   82: aload_0
    //   83: aload 5
    //   85: putfield 107	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:u	Lcom/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout$PanelState;
    //   88: aload_0
    //   89: fconst_1
    //   90: putfield 109	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:x	F
    //   93: aload_0
    //   94: iconst_0
    //   95: putfield 111	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:E	Z
    //   98: aload_0
    //   99: new 113	java/util/concurrent/CopyOnWriteArrayList
    //   102: dup
    //   103: invokespecial 114	java/util/concurrent/CopyOnWriteArrayList:<init>	()V
    //   106: putfield 116	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:F	Ljava/util/List;
    //   109: aload_0
    //   110: iconst_1
    //   111: putfield 118	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:I	Z
    //   114: aload_0
    //   115: new 120	android/graphics/Rect
    //   118: dup
    //   119: invokespecial 121	android/graphics/Rect:<init>	()V
    //   122: putfield 123	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:J	Landroid/graphics/Rect;
    //   125: aload_0
    //   126: invokevirtual 127	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:isInEditMode	()Z
    //   129: ifeq +14 -> 143
    //   132: aload_0
    //   133: aconst_null
    //   134: putfield 129	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:f	Landroid/graphics/drawable/Drawable;
    //   137: aload_0
    //   138: aconst_null
    //   139: putfield 131	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:H	Lcom/tencent/aelight/camera/aeeditor/lyric/interaction/ViewDragHelper;
    //   142: return
    //   143: aload_2
    //   144: ifnull +245 -> 389
    //   147: aload_1
    //   148: aload_2
    //   149: getstatic 64	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:b	[I
    //   152: invokevirtual 137	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   155: astore 5
    //   157: aload 5
    //   159: ifnull +19 -> 178
    //   162: aload_0
    //   163: aload 5
    //   165: iconst_0
    //   166: iconst_0
    //   167: invokevirtual 143	android/content/res/TypedArray:getInt	(II)I
    //   170: invokevirtual 147	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:setGravity	(I)V
    //   173: aload 5
    //   175: invokevirtual 150	android/content/res/TypedArray:recycle	()V
    //   178: aload_1
    //   179: aload_2
    //   180: getstatic 154	com/tencent/aelight/camera/impl/R$styleable:g	[I
    //   183: invokevirtual 137	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   186: astore 5
    //   188: aload 5
    //   190: ifnull +199 -> 389
    //   193: aload_0
    //   194: aload 5
    //   196: bipush 7
    //   198: iconst_m1
    //   199: invokevirtual 157	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   202: putfield 88	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:g	I
    //   205: aload_0
    //   206: aload 5
    //   208: bipush 11
    //   210: iconst_m1
    //   211: invokevirtual 157	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   214: putfield 90	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:h	I
    //   217: aload_0
    //   218: aload 5
    //   220: bipush 8
    //   222: iconst_m1
    //   223: invokevirtual 157	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   226: putfield 92	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:i	I
    //   229: aload_0
    //   230: aload 5
    //   232: iconst_4
    //   233: sipush 400
    //   236: invokevirtual 143	android/content/res/TypedArray:getInt	(II)I
    //   239: putfield 78	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:c	I
    //   242: aload_0
    //   243: aload 5
    //   245: iconst_3
    //   246: iconst_0
    //   247: invokevirtual 160	android/content/res/TypedArray:getColor	(II)I
    //   250: putfield 80	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:d	I
    //   253: aload_0
    //   254: aload 5
    //   256: iconst_2
    //   257: iconst_m1
    //   258: invokevirtual 163	android/content/res/TypedArray:getResourceId	(II)I
    //   261: putfield 98	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:n	I
    //   264: aload_0
    //   265: aload 5
    //   267: bipush 10
    //   269: iconst_m1
    //   270: invokevirtual 163	android/content/res/TypedArray:getResourceId	(II)I
    //   273: putfield 165	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:p	I
    //   276: aload_0
    //   277: aload 5
    //   279: bipush 6
    //   281: iconst_0
    //   282: invokevirtual 169	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   285: putfield 94	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:k	Z
    //   288: aload_0
    //   289: aload 5
    //   291: iconst_1
    //   292: iconst_1
    //   293: invokevirtual 169	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   296: putfield 96	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:l	Z
    //   299: aload_0
    //   300: aload 5
    //   302: iconst_0
    //   303: fconst_1
    //   304: invokevirtual 173	android/content/res/TypedArray:getFloat	(IF)F
    //   307: putfield 109	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:x	F
    //   310: aload_0
    //   311: invokestatic 177	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout$PanelState:values	()[Lcom/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout$PanelState;
    //   314: aload 5
    //   316: iconst_5
    //   317: getstatic 61	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:a	Lcom/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout$PanelState;
    //   320: invokevirtual 181	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout$PanelState:ordinal	()I
    //   323: invokevirtual 143	android/content/res/TypedArray:getInt	(II)I
    //   326: aaload
    //   327: putfield 105	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:t	Lcom/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout$PanelState;
    //   330: aload 5
    //   332: bipush 9
    //   334: iconst_m1
    //   335: invokevirtual 163	android/content/res/TypedArray:getResourceId	(II)I
    //   338: istore_3
    //   339: iload_3
    //   340: iconst_m1
    //   341: if_icmpeq +12 -> 353
    //   344: aload_1
    //   345: iload_3
    //   346: invokestatic 187	android/view/animation/AnimationUtils:loadInterpolator	(Landroid/content/Context;I)Landroid/view/animation/Interpolator;
    //   349: astore_2
    //   350: goto +5 -> 355
    //   353: aconst_null
    //   354: astore_2
    //   355: aload 5
    //   357: invokevirtual 150	android/content/res/TypedArray:recycle	()V
    //   360: goto +31 -> 391
    //   363: astore_1
    //   364: goto +18 -> 382
    //   367: astore_2
    //   368: ldc 189
    //   370: aload_2
    //   371: invokestatic 194	com/tencent/aelight/camera/log/AEQLog:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   374: aload 5
    //   376: invokevirtual 150	android/content/res/TypedArray:recycle	()V
    //   379: goto +10 -> 389
    //   382: aload 5
    //   384: invokevirtual 150	android/content/res/TypedArray:recycle	()V
    //   387: aload_1
    //   388: athrow
    //   389: aconst_null
    //   390: astore_2
    //   391: aload_1
    //   392: invokevirtual 198	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   395: invokevirtual 204	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   398: getfield 209	android/util/DisplayMetrics:density	F
    //   401: fstore 4
    //   403: aload_0
    //   404: getfield 88	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:g	I
    //   407: iconst_m1
    //   408: if_icmpne +16 -> 424
    //   411: aload_0
    //   412: ldc 210
    //   414: fload 4
    //   416: fmul
    //   417: ldc 211
    //   419: fadd
    //   420: f2i
    //   421: putfield 88	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:g	I
    //   424: aload_0
    //   425: getfield 90	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:h	I
    //   428: iconst_m1
    //   429: if_icmpne +16 -> 445
    //   432: aload_0
    //   433: ldc 212
    //   435: fload 4
    //   437: fmul
    //   438: ldc 211
    //   440: fadd
    //   441: f2i
    //   442: putfield 90	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:h	I
    //   445: aload_0
    //   446: getfield 92	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:i	I
    //   449: iconst_m1
    //   450: if_icmpne +12 -> 462
    //   453: aload_0
    //   454: fconst_0
    //   455: fload 4
    //   457: fmul
    //   458: f2i
    //   459: putfield 92	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:i	I
    //   462: aload_0
    //   463: getfield 90	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:h	I
    //   466: ifle +42 -> 508
    //   469: aload_0
    //   470: getfield 214	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:j	Z
    //   473: ifeq +19 -> 492
    //   476: aload_0
    //   477: aload_0
    //   478: invokevirtual 215	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:getResources	()Landroid/content/res/Resources;
    //   481: ldc 216
    //   483: invokevirtual 220	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   486: putfield 129	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:f	Landroid/graphics/drawable/Drawable;
    //   489: goto +24 -> 513
    //   492: aload_0
    //   493: aload_0
    //   494: invokevirtual 215	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:getResources	()Landroid/content/res/Resources;
    //   497: ldc 221
    //   499: invokevirtual 220	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   502: putfield 129	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:f	Landroid/graphics/drawable/Drawable;
    //   505: goto +8 -> 513
    //   508: aload_0
    //   509: aconst_null
    //   510: putfield 129	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:f	Landroid/graphics/drawable/Drawable;
    //   513: aload_0
    //   514: iconst_0
    //   515: invokevirtual 225	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:setWillNotDraw	(Z)V
    //   518: aload_0
    //   519: aload_0
    //   520: ldc 211
    //   522: aload_2
    //   523: new 227	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout$DragHelperCallback
    //   526: dup
    //   527: aload_0
    //   528: aconst_null
    //   529: invokespecial 230	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout$DragHelperCallback:<init>	(Lcom/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout;Lcom/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout$1;)V
    //   532: invokestatic 235	com/tencent/aelight/camera/aeeditor/lyric/interaction/ViewDragHelper:a	(Landroid/view/ViewGroup;FLandroid/view/animation/Interpolator;Lcom/tencent/aelight/camera/aeeditor/lyric/interaction/ViewDragHelper$Callback;)Lcom/tencent/aelight/camera/aeeditor/lyric/interaction/ViewDragHelper;
    //   535: putfield 131	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:H	Lcom/tencent/aelight/camera/aeeditor/lyric/interaction/ViewDragHelper;
    //   538: aload_0
    //   539: getfield 131	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:H	Lcom/tencent/aelight/camera/aeeditor/lyric/interaction/ViewDragHelper;
    //   542: aload_0
    //   543: getfield 78	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:c	I
    //   546: i2f
    //   547: fload 4
    //   549: fmul
    //   550: invokevirtual 238	com/tencent/aelight/camera/aeeditor/lyric/interaction/ViewDragHelper:a	(F)V
    //   553: aload_0
    //   554: iconst_1
    //   555: putfield 240	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:z	Z
    //   558: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	559	0	this	AESlidingUpPanelLayout
    //   0	559	1	paramContext	Context
    //   0	559	2	paramAttributeSet	AttributeSet
    //   0	559	3	paramInt	int
    //   401	147	4	f1	float
    //   74	309	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   193	339	363	finally
    //   344	350	363	finally
    //   368	374	363	finally
    //   193	339	367	java/lang/Throwable
    //   344	350	367	java/lang/Throwable
  }
  
  private float a(int paramInt)
  {
    int i1 = a(0.0F);
    float f1;
    if (this.j) {
      f1 = i1 - paramInt;
    } else {
      f1 = paramInt - i1;
    }
    return f1 / this.w;
  }
  
  private int a(float paramFloat)
  {
    View localView = this.r;
    int i1;
    if (localView != null) {
      i1 = localView.getMeasuredHeight();
    } else {
      i1 = 0;
    }
    int i2 = (int)(paramFloat * this.w);
    if (this.j) {
      return getMeasuredHeight() - getPaddingBottom() - this.g - i2;
    }
    return getPaddingTop() - i1 + this.g + i2;
  }
  
  private boolean a(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {
      return false;
    }
    int[] arrayOfInt1 = new int[2];
    paramView.getLocationOnScreen(arrayOfInt1);
    int[] arrayOfInt2 = new int[2];
    getLocationOnScreen(arrayOfInt2);
    paramInt1 = arrayOfInt2[0] + paramInt1;
    paramInt2 = arrayOfInt2[1] + paramInt2;
    return (paramInt1 >= arrayOfInt1[0]) && (paramInt1 < arrayOfInt1[0] + paramView.getWidth()) && (paramInt2 >= arrayOfInt1[1]) && (paramInt2 < arrayOfInt1[1] + paramView.getHeight());
  }
  
  private void b(int paramInt)
  {
    if (this.t != AESlidingUpPanelLayout.PanelState.DRAGGING) {
      this.u = this.t;
    }
    setPanelStateInternal(AESlidingUpPanelLayout.PanelState.DRAGGING);
    this.v = a(paramInt);
    e();
    a(this.r);
    ViewGroup.LayoutParams localLayoutParams1 = this.s.getLayoutParams();
    AESlidingUpPanelLayout.LayoutParams localLayoutParams = null;
    if ((localLayoutParams1 instanceof AESlidingUpPanelLayout.LayoutParams)) {
      localLayoutParams = (AESlidingUpPanelLayout.LayoutParams)localLayoutParams1;
    }
    if (localLayoutParams == null) {
      return;
    }
    int i1 = getHeight();
    int i2 = getPaddingBottom();
    int i3 = getPaddingTop();
    int i4 = this.g;
    if ((this.v <= 0.0F) && (!this.k))
    {
      if (this.j) {
        paramInt -= getPaddingBottom();
      } else {
        paramInt = getHeight() - getPaddingBottom() - this.r.getMeasuredHeight() - paramInt;
      }
      localLayoutParams.height = paramInt;
      if (localLayoutParams.height == i1 - i2 - i3 - i4) {
        localLayoutParams.height = -1;
      }
      this.s.requestLayout();
      return;
    }
    if ((localLayoutParams.height != -1) && (!this.k))
    {
      localLayoutParams.height = -1;
      this.s.requestLayout();
    }
  }
  
  private static boolean b(View paramView)
  {
    paramView = paramView.getBackground();
    return (paramView != null) && (paramView.getOpacity() == -1);
  }
  
  @SuppressLint({"NewApi"})
  private void e()
  {
    if (this.i > 0)
    {
      int i1 = getCurrentParallaxOffset();
      ViewCompat.setTranslationY(this.s, i1);
    }
  }
  
  private void setPanelStateInternal(AESlidingUpPanelLayout.PanelState paramPanelState)
  {
    AESlidingUpPanelLayout.PanelState localPanelState = this.t;
    if (localPanelState == paramPanelState) {
      return;
    }
    this.t = paramPanelState;
    a(this, localPanelState, paramPanelState);
  }
  
  void a(View paramView)
  {
    Iterator localIterator = this.F.iterator();
    while (localIterator.hasNext()) {
      ((AESlidingUpPanelLayout.PanelSlideListener)localIterator.next()).a(paramView, this.v);
    }
  }
  
  void a(View paramView, AESlidingUpPanelLayout.PanelState paramPanelState1, AESlidingUpPanelLayout.PanelState paramPanelState2)
  {
    Iterator localIterator = this.F.iterator();
    while (localIterator.hasNext()) {
      ((AESlidingUpPanelLayout.PanelSlideListener)localIterator.next()).a(paramView, paramPanelState1, paramPanelState2);
    }
    sendAccessibilityEvent(32);
  }
  
  public void a(AESlidingUpPanelLayout.PanelSlideListener paramPanelSlideListener)
  {
    if (paramPanelSlideListener != null) {
      this.F.add(paramPanelSlideListener);
    }
  }
  
  public boolean a()
  {
    return (this.z) && (this.r != null) && (this.t != AESlidingUpPanelLayout.PanelState.HIDDEN);
  }
  
  boolean a(float paramFloat, int paramInt)
  {
    if (isEnabled())
    {
      if (this.r == null) {
        return false;
      }
      paramInt = a(paramFloat);
      ViewDragHelper localViewDragHelper = this.H;
      View localView = this.r;
      if (localViewDragHelper.a(localView, localView.getLeft(), paramInt))
      {
        d();
        ViewCompat.postInvalidateOnAnimation(this);
        return true;
      }
    }
    return false;
  }
  
  protected void b()
  {
    a(0.0F, 0);
  }
  
  void c()
  {
    if (getChildCount() == 0) {
      return;
    }
    int i11 = getPaddingLeft();
    int i8 = getWidth();
    int i9 = getPaddingRight();
    int i10 = getPaddingTop();
    int i5 = getHeight();
    int i7 = getPaddingBottom();
    View localView = this.r;
    int i6 = 0;
    int i1;
    int i2;
    int i3;
    int i4;
    if ((localView != null) && (b(localView)))
    {
      i1 = this.r.getLeft();
      i2 = this.r.getRight();
      i3 = this.r.getTop();
      i4 = this.r.getBottom();
    }
    else
    {
      i1 = 0;
      i2 = 0;
      i3 = 0;
      i4 = 0;
    }
    localView = getChildAt(0);
    i11 = Math.max(i11, localView.getLeft());
    i10 = Math.max(i10, localView.getTop());
    i8 = Math.min(i8 - i9, localView.getRight());
    i7 = Math.min(i5 - i7, localView.getBottom());
    i5 = i6;
    if (i11 >= i1)
    {
      i5 = i6;
      if (i10 >= i3)
      {
        i5 = i6;
        if (i8 <= i2)
        {
          i5 = i6;
          if (i7 <= i4) {
            i5 = 4;
          }
        }
      }
    }
    localView.setVisibility(i5);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof AESlidingUpPanelLayout.LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    ViewDragHelper localViewDragHelper = this.H;
    if ((localViewDragHelper != null) && (localViewDragHelper.a(true)))
    {
      if (!isEnabled())
      {
        this.H.d();
        return;
      }
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  void d()
  {
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 4) {
        localView.setVisibility(0);
      }
      i1 += 1;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = MotionEventCompat.getActionMasked(paramMotionEvent);
    if ((isEnabled()) && (a()) && ((!this.y) || (i1 == 0)))
    {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if (i1 == 0)
      {
        this.E = false;
        this.A = f1;
        this.B = f2;
      }
      else if (i1 == 2)
      {
        float f3 = this.A;
        float f4 = f2 - this.B;
        this.A = f1;
        this.B = f2;
        if (Math.abs(f1 - f3) > Math.abs(f4)) {
          return super.dispatchTouchEvent(paramMotionEvent);
        }
        if (!a(this.o, (int)this.C, (int)this.D)) {
          return super.dispatchTouchEvent(paramMotionEvent);
        }
        boolean bool = this.j;
        int i2 = -1;
        if (bool) {
          i1 = 1;
        } else {
          i1 = -1;
        }
        if (i1 * f4 > 0.0F)
        {
          if (this.q.a(this.o, this.j) > 0)
          {
            this.E = true;
            return super.dispatchTouchEvent(paramMotionEvent);
          }
          if (this.E)
          {
            MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
            localMotionEvent.setAction(3);
            super.dispatchTouchEvent(localMotionEvent);
            localMotionEvent.recycle();
            paramMotionEvent.setAction(0);
          }
          this.E = false;
          return onTouchEvent(paramMotionEvent);
        }
        i1 = i2;
        if (this.j) {
          i1 = 1;
        }
        if (f4 * i1 < 0.0F)
        {
          if (this.v < 1.0F)
          {
            this.E = false;
            return onTouchEvent(paramMotionEvent);
          }
          if ((!this.E) && (this.H.e()))
          {
            this.H.c();
            paramMotionEvent.setAction(0);
          }
          this.E = true;
          return super.dispatchTouchEvent(paramMotionEvent);
        }
      }
      else if ((i1 == 1) && (this.E))
      {
        this.H.a(0);
      }
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    this.H.d();
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.f != null)
    {
      View localView = this.r;
      if (localView != null)
      {
        int i3 = localView.getRight();
        int i1;
        int i2;
        if (this.j)
        {
          i1 = this.r.getTop() - this.h;
          i2 = this.r.getTop();
        }
        else
        {
          i1 = this.r.getBottom();
          i2 = this.r.getBottom() + this.h;
        }
        int i4 = this.r.getLeft();
        this.f.setBounds(i4, i1, i3, i2);
        this.f.draw(paramCanvas);
      }
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    int i1 = paramCanvas.save();
    Object localObject = this.r;
    boolean bool1;
    if ((localObject != null) && (!localObject.equals(paramView)))
    {
      paramCanvas.getClipBounds(this.J);
      if (!this.k) {
        if (this.j)
        {
          localObject = this.J;
          ((Rect)localObject).bottom = Math.min(((Rect)localObject).bottom, this.r.getTop());
        }
        else
        {
          localObject = this.J;
          ((Rect)localObject).top = Math.max(((Rect)localObject).top, this.r.getBottom());
        }
      }
      if (this.l) {
        paramCanvas.clipRect(this.J);
      }
      boolean bool2 = super.drawChild(paramCanvas, paramView, paramLong);
      int i2 = this.d;
      bool1 = bool2;
      if (i2 != 0)
      {
        float f1 = this.v;
        bool1 = bool2;
        if (f1 > 0.0F)
        {
          int i3 = (int)(((0xFF000000 & i2) >>> 24) * f1);
          this.e.setColor(i2 & 0xFFFFFF | i3 << 24);
          paramCanvas.drawRect(this.J, this.e);
          bool1 = bool2;
        }
      }
    }
    else
    {
      bool1 = super.drawChild(paramCanvas, paramView, paramLong);
    }
    paramCanvas.restoreToCount(i1);
    return bool1;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new AESlidingUpPanelLayout.LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new AESlidingUpPanelLayout.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new AESlidingUpPanelLayout.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new AESlidingUpPanelLayout.LayoutParams(paramLayoutParams);
  }
  
  public float getAnchorPoint()
  {
    return this.x;
  }
  
  public int getCurrentParallaxOffset()
  {
    int i2 = (int)(this.i * Math.max(this.v, 0.0F));
    int i1 = i2;
    if (this.j) {
      i1 = -i2;
    }
    return i1;
  }
  
  public int getPanelHeight()
  {
    return this.g;
  }
  
  public AESlidingUpPanelLayout.PanelState getPanelState()
  {
    return this.t;
  }
  
  public int getShadowHeight()
  {
    return this.h;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.I = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.I = true;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    int i1 = this.n;
    if (i1 != -1) {
      setDragView(findViewById(i1));
    }
    i1 = this.p;
    if (i1 != -1) {
      setScrollableView(findViewById(i1));
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!this.E) && (a()))
    {
      int i1 = MotionEventCompat.getActionMasked(paramMotionEvent);
      float f3 = paramMotionEvent.getX();
      float f4 = paramMotionEvent.getY();
      float f1 = Math.abs(f3 - this.C);
      float f2 = Math.abs(f4 - this.D);
      int i2 = this.H.b();
      if (i1 != 0)
      {
        if (i1 != 1) {
          if (i1 != 2)
          {
            if (i1 != 3) {
              break label261;
            }
          }
          else
          {
            if ((f2 <= i2) || (f1 <= f2)) {
              break label261;
            }
            this.H.c();
            this.y = true;
            return false;
          }
        }
        if (this.H.e())
        {
          this.H.b(paramMotionEvent);
          return true;
        }
        f3 = i2;
        if ((f2 <= f3) && (f1 <= f3) && (this.v > 0.0F) && (!a(this.r, (int)this.C, (int)this.D)) && (this.G != null))
        {
          playSoundEffect(0);
          this.G.onClick(this);
          return true;
        }
      }
      else
      {
        this.y = false;
        this.C = f3;
        this.D = f4;
        if (!a(this.m, (int)f3, (int)f4))
        {
          this.H.c();
          this.y = true;
          return false;
        }
      }
      label261:
      return this.H.a(paramMotionEvent);
    }
    this.H.d();
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = getPaddingLeft();
    paramInt4 = getPaddingTop();
    int i2 = getChildCount();
    if (this.I)
    {
      paramInt1 = AESlidingUpPanelLayout.2.a[this.t.ordinal()];
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          if (paramInt1 != 3)
          {
            this.v = 0.0F;
          }
          else
          {
            paramInt2 = a(0.0F);
            if (this.j) {
              paramInt1 = this.g;
            } else {
              paramInt1 = -this.g;
            }
            this.v = a(paramInt2 + paramInt1);
          }
        }
        else {
          this.v = this.x;
        }
      }
      else {
        this.v = 1.0F;
      }
    }
    paramInt2 = 0;
    while (paramInt2 < i2)
    {
      View localView = getChildAt(paramInt2);
      if (localView != null)
      {
        ViewGroup.LayoutParams localLayoutParams1 = localView.getLayoutParams();
        AESlidingUpPanelLayout.LayoutParams localLayoutParams = null;
        if ((localLayoutParams1 instanceof AESlidingUpPanelLayout.LayoutParams)) {
          localLayoutParams = (AESlidingUpPanelLayout.LayoutParams)localLayoutParams1;
        }
        if ((localLayoutParams != null) && ((localView.getVisibility() != 8) || ((paramInt2 != 0) && (!this.I))))
        {
          int i3 = localView.getMeasuredHeight();
          if (localView.equals(this.r)) {
            paramInt1 = a(this.v);
          } else {
            paramInt1 = paramInt4;
          }
          paramInt3 = paramInt1;
          if (!this.j)
          {
            paramInt3 = paramInt1;
            if (localView.equals(this.s))
            {
              paramInt3 = paramInt1;
              if (!this.k) {
                paramInt3 = a(this.v) + this.r.getMeasuredHeight();
              }
            }
          }
          paramInt1 = localLayoutParams.leftMargin + i1;
          localView.layout(paramInt1, paramInt3, localView.getMeasuredWidth() + paramInt1, i3 + paramInt3);
        }
      }
      paramInt2 += 1;
    }
    if (this.I) {
      c();
    }
    e();
    this.I = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int i4 = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getMode(paramInt2);
    int i5 = View.MeasureSpec.getSize(paramInt2);
    if ((i1 != 1073741824) && (i1 != -2147483648)) {
      throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
    }
    if ((paramInt1 != 1073741824) && (paramInt1 != -2147483648)) {
      throw new IllegalStateException("Height must have an exact value or MATCH_PARENT");
    }
    int i6 = getChildCount();
    if (i6 == 2)
    {
      int i2 = 0;
      this.s = getChildAt(0);
      this.r = getChildAt(1);
      if (this.m == null) {
        setDragView(this.r);
      }
      if (this.r.getVisibility() != 0) {
        this.t = AESlidingUpPanelLayout.PanelState.HIDDEN;
      }
      i1 = i5 - getPaddingTop() - getPaddingBottom();
      int i3 = i4 - getPaddingLeft() - getPaddingRight();
      while (i2 < i6)
      {
        localObject = getChildAt(i2);
        if (localObject != null)
        {
          AESlidingUpPanelLayout.LayoutParams localLayoutParams = (AESlidingUpPanelLayout.LayoutParams)((View)localObject).getLayoutParams();
          if ((localLayoutParams != null) && ((((View)localObject).getVisibility() != 8) || (i2 != 0)))
          {
            if (localObject.equals(this.s))
            {
              if ((!this.k) && (this.t != AESlidingUpPanelLayout.PanelState.HIDDEN)) {
                paramInt2 = i1 - this.g;
              } else {
                paramInt2 = i1;
              }
              paramInt1 = i3 - (localLayoutParams.leftMargin + localLayoutParams.rightMargin);
            }
            else
            {
              if (localObject.equals(this.r)) {
                paramInt2 = i1 - localLayoutParams.topMargin;
              } else {
                paramInt2 = i1;
              }
              paramInt1 = i3;
            }
            if (localLayoutParams.width == -2) {
              paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, -2147483648);
            } else if (localLayoutParams.width == -1) {
              paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
            } else {
              paramInt1 = View.MeasureSpec.makeMeasureSpec(localLayoutParams.width, 1073741824);
            }
            if (localLayoutParams.height == -2)
            {
              paramInt2 = View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648);
            }
            else
            {
              if ((localLayoutParams.a > 0.0F) && (localLayoutParams.a < 1.0F)) {
                paramInt2 = (int)(paramInt2 * localLayoutParams.a);
              } else if (localLayoutParams.height != -1) {
                paramInt2 = localLayoutParams.height;
              }
              paramInt2 = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
            }
            ((View)localObject).measure(paramInt1, paramInt2);
            if (localObject.equals(this.r)) {
              this.w = (this.r.getMeasuredHeight() - this.g);
            }
          }
        }
        i2 += 1;
      }
      setMeasuredDimension(i4, i5);
      return;
    }
    Object localObject = new IllegalStateException("Sliding up panel layout must have exactly 2 children!");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    Object localObject = paramParcelable;
    if ((paramParcelable instanceof Bundle))
    {
      Bundle localBundle = (Bundle)paramParcelable;
      this.t = ((AESlidingUpPanelLayout.PanelState)localBundle.getSerializable("sliding_state"));
      localObject = this.t;
      paramParcelable = (Parcelable)localObject;
      if (localObject == null) {
        paramParcelable = a;
      }
      this.t = paramParcelable;
      localObject = localBundle.getParcelable("superState");
    }
    super.onRestoreInstanceState((Parcelable)localObject);
  }
  
  public Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("superState", super.onSaveInstanceState());
    AESlidingUpPanelLayout.PanelState localPanelState;
    if (this.t != AESlidingUpPanelLayout.PanelState.DRAGGING) {
      localPanelState = this.t;
    } else {
      localPanelState = this.u;
    }
    localBundle.putSerializable("sliding_state", localPanelState);
    return localBundle;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt2 != paramInt4) {
      this.I = true;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((isEnabled()) && (a())) {}
    try
    {
      this.H.b(paramMotionEvent);
      paramMotionEvent = this.t;
      AESlidingUpPanelLayout.PanelState localPanelState = AESlidingUpPanelLayout.PanelState.COLLAPSED;
      return paramMotionEvent != localPanelState;
    }
    catch (Exception paramMotionEvent) {}
    return super.onTouchEvent(paramMotionEvent);
    return false;
  }
  
  public void setAnchorPoint(float paramFloat)
  {
    if ((paramFloat > 0.0F) && (paramFloat <= 1.0F))
    {
      this.x = paramFloat;
      this.I = true;
      requestLayout();
    }
  }
  
  public void setDragView(int paramInt)
  {
    this.n = paramInt;
    setDragView(findViewById(paramInt));
  }
  
  public void setDragView(View paramView)
  {
    View localView = this.m;
    if (localView != null) {
      localView.setOnClickListener(null);
    }
    this.m = paramView;
    paramView = this.m;
    if (paramView != null)
    {
      paramView.setClickable(true);
      this.m.setFocusable(false);
      this.m.setFocusableInTouchMode(false);
      this.m.setOnClickListener(new AESlidingUpPanelLayout.1(this));
    }
  }
  
  public void setFadeOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.G = paramOnClickListener;
  }
  
  public void setGravity(int paramInt)
  {
    if ((paramInt != 48) && (paramInt != 80)) {
      throw new IllegalArgumentException("gravity must be set to either top or bottom");
    }
    boolean bool;
    if (paramInt == 80) {
      bool = true;
    } else {
      bool = false;
    }
    this.j = bool;
    if (!this.I) {
      requestLayout();
    }
  }
  
  public void setPanelHeight(int paramInt)
  {
    if (getPanelHeight() == paramInt) {
      return;
    }
    this.g = paramInt;
    if (!this.I) {
      requestLayout();
    }
    if (getPanelState() == AESlidingUpPanelLayout.PanelState.COLLAPSED)
    {
      b();
      invalidate();
    }
  }
  
  public void setPanelState(AESlidingUpPanelLayout.PanelState paramPanelState)
  {
    if (this.H.a() == 2)
    {
      Log.d("SlidingUpPanelLayout", "View is settling. Aborting animation.");
      this.H.d();
    }
    if ((paramPanelState != null) && (paramPanelState != AESlidingUpPanelLayout.PanelState.DRAGGING))
    {
      if ((isEnabled()) && ((this.I) || (this.r != null)))
      {
        AESlidingUpPanelLayout.PanelState localPanelState = this.t;
        if (paramPanelState != localPanelState)
        {
          if (localPanelState == AESlidingUpPanelLayout.PanelState.DRAGGING) {
            return;
          }
          if (this.I)
          {
            setPanelStateInternal(paramPanelState);
            return;
          }
          if (this.t == AESlidingUpPanelLayout.PanelState.HIDDEN)
          {
            this.r.setVisibility(0);
            requestLayout();
          }
          int i1 = AESlidingUpPanelLayout.2.a[paramPanelState.ordinal()];
          if (i1 != 1)
          {
            if (i1 != 2)
            {
              if (i1 != 3)
              {
                if (i1 != 4) {
                  return;
                }
                a(0.0F, 0);
                return;
              }
              int i2 = a(0.0F);
              if (this.j) {
                i1 = this.g;
              } else {
                i1 = -this.g;
              }
              a(a(i2 + i1), 0);
              return;
            }
            a(this.x, 0);
            return;
          }
          a(1.0F, 0);
        }
      }
      return;
    }
    throw new IllegalArgumentException("Panel state cannot be null or DRAGGING.");
  }
  
  public void setScrollableView(View paramView)
  {
    this.o = paramView;
  }
  
  public void setShadowHeight(int paramInt)
  {
    this.h = paramInt;
    if (!this.I) {
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.lyric.interaction.AESlidingUpPanelLayout
 * JD-Core Version:    0.7.0.1
 */