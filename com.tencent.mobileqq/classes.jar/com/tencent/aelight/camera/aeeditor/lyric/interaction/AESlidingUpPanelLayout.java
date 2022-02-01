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
  private static AESlidingUpPanelLayout.PanelState jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState = AESlidingUpPanelLayout.PanelState.COLLAPSED;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 16842927 };
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint;
  private final Rect jdField_a_of_type_AndroidGraphicsRect;
  private final Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View jdField_a_of_type_AndroidViewView;
  private ScrollableViewHelper jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionScrollableViewHelper;
  private final ViewDragHelper jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper;
  private final List<AESlidingUpPanelLayout.PanelSlideListener> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private AESlidingUpPanelLayout.PanelState jdField_b_of_type_ComTencentAelightCameraAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private AESlidingUpPanelLayout.PanelState jdField_c_of_type_ComTencentAelightCameraAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private float jdField_f_of_type_Float;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int h;
  
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
    //   4: invokespecial 50	android/view/ViewGroup:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   7: aload_0
    //   8: sipush 400
    //   11: putfield 52	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_a_of_type_Int	I
    //   14: aload_0
    //   15: iconst_0
    //   16: putfield 54	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_b_of_type_Int	I
    //   19: aload_0
    //   20: new 56	android/graphics/Paint
    //   23: dup
    //   24: invokespecial 58	android/graphics/Paint:<init>	()V
    //   27: putfield 60	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   30: aload_0
    //   31: iconst_m1
    //   32: putfield 62	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_c_of_type_Int	I
    //   35: aload_0
    //   36: iconst_m1
    //   37: putfield 64	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_d_of_type_Int	I
    //   40: aload_0
    //   41: iconst_m1
    //   42: putfield 66	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_e_of_type_Int	I
    //   45: aload_0
    //   46: iconst_0
    //   47: putfield 68	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_b_of_type_Boolean	Z
    //   50: aload_0
    //   51: iconst_1
    //   52: putfield 70	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_c_of_type_Boolean	Z
    //   55: aload_0
    //   56: iconst_m1
    //   57: putfield 72	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_f_of_type_Int	I
    //   60: aload_0
    //   61: new 74	com/tencent/aelight/camera/aeeditor/lyric/interaction/ScrollableViewHelper
    //   64: dup
    //   65: invokespecial 75	com/tencent/aelight/camera/aeeditor/lyric/interaction/ScrollableViewHelper:<init>	()V
    //   68: putfield 77	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionScrollableViewHelper	Lcom/tencent/aelight/camera/aeeditor/lyric/interaction/ScrollableViewHelper;
    //   71: getstatic 35	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState	Lcom/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout$PanelState;
    //   74: astore 5
    //   76: aload_0
    //   77: aload 5
    //   79: putfield 79	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_b_of_type_ComTencentAelightCameraAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState	Lcom/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout$PanelState;
    //   82: aload_0
    //   83: aload 5
    //   85: putfield 81	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_c_of_type_ComTencentAelightCameraAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState	Lcom/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout$PanelState;
    //   88: aload_0
    //   89: fconst_1
    //   90: putfield 83	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_b_of_type_Float	F
    //   93: aload_0
    //   94: iconst_0
    //   95: putfield 85	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_f_of_type_Boolean	Z
    //   98: aload_0
    //   99: new 87	java/util/concurrent/CopyOnWriteArrayList
    //   102: dup
    //   103: invokespecial 88	java/util/concurrent/CopyOnWriteArrayList:<init>	()V
    //   106: putfield 90	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   109: aload_0
    //   110: iconst_1
    //   111: putfield 92	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_g_of_type_Boolean	Z
    //   114: aload_0
    //   115: new 94	android/graphics/Rect
    //   118: dup
    //   119: invokespecial 95	android/graphics/Rect:<init>	()V
    //   122: putfield 97	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   125: aload_0
    //   126: invokevirtual 101	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:isInEditMode	()Z
    //   129: ifeq +14 -> 143
    //   132: aload_0
    //   133: aconst_null
    //   134: putfield 103	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   137: aload_0
    //   138: aconst_null
    //   139: putfield 105	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper	Lcom/tencent/aelight/camera/aeeditor/lyric/interaction/ViewDragHelper;
    //   142: return
    //   143: aload_2
    //   144: ifnull +245 -> 389
    //   147: aload_1
    //   148: aload_2
    //   149: getstatic 38	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_a_of_type_ArrayOfInt	[I
    //   152: invokevirtual 111	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   155: astore 5
    //   157: aload 5
    //   159: ifnull +19 -> 178
    //   162: aload_0
    //   163: aload 5
    //   165: iconst_0
    //   166: iconst_0
    //   167: invokevirtual 117	android/content/res/TypedArray:getInt	(II)I
    //   170: invokevirtual 121	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:setGravity	(I)V
    //   173: aload 5
    //   175: invokevirtual 124	android/content/res/TypedArray:recycle	()V
    //   178: aload_1
    //   179: aload_2
    //   180: getstatic 128	com/tencent/aelight/camera/impl/R$styleable:g	[I
    //   183: invokevirtual 111	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   186: astore 5
    //   188: aload 5
    //   190: ifnull +199 -> 389
    //   193: aload_0
    //   194: aload 5
    //   196: bipush 7
    //   198: iconst_m1
    //   199: invokevirtual 131	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   202: putfield 62	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_c_of_type_Int	I
    //   205: aload_0
    //   206: aload 5
    //   208: bipush 11
    //   210: iconst_m1
    //   211: invokevirtual 131	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   214: putfield 64	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_d_of_type_Int	I
    //   217: aload_0
    //   218: aload 5
    //   220: bipush 8
    //   222: iconst_m1
    //   223: invokevirtual 131	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   226: putfield 66	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_e_of_type_Int	I
    //   229: aload_0
    //   230: aload 5
    //   232: iconst_4
    //   233: sipush 400
    //   236: invokevirtual 117	android/content/res/TypedArray:getInt	(II)I
    //   239: putfield 52	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_a_of_type_Int	I
    //   242: aload_0
    //   243: aload 5
    //   245: iconst_3
    //   246: iconst_0
    //   247: invokevirtual 134	android/content/res/TypedArray:getColor	(II)I
    //   250: putfield 54	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_b_of_type_Int	I
    //   253: aload_0
    //   254: aload 5
    //   256: iconst_2
    //   257: iconst_m1
    //   258: invokevirtual 137	android/content/res/TypedArray:getResourceId	(II)I
    //   261: putfield 72	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_f_of_type_Int	I
    //   264: aload_0
    //   265: aload 5
    //   267: bipush 10
    //   269: iconst_m1
    //   270: invokevirtual 137	android/content/res/TypedArray:getResourceId	(II)I
    //   273: putfield 139	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_g_of_type_Int	I
    //   276: aload_0
    //   277: aload 5
    //   279: bipush 6
    //   281: iconst_0
    //   282: invokevirtual 143	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   285: putfield 68	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_b_of_type_Boolean	Z
    //   288: aload_0
    //   289: aload 5
    //   291: iconst_1
    //   292: iconst_1
    //   293: invokevirtual 143	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   296: putfield 70	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_c_of_type_Boolean	Z
    //   299: aload_0
    //   300: aload 5
    //   302: iconst_0
    //   303: fconst_1
    //   304: invokevirtual 147	android/content/res/TypedArray:getFloat	(IF)F
    //   307: putfield 83	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_b_of_type_Float	F
    //   310: aload_0
    //   311: invokestatic 151	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout$PanelState:values	()[Lcom/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout$PanelState;
    //   314: aload 5
    //   316: iconst_5
    //   317: getstatic 35	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState	Lcom/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout$PanelState;
    //   320: invokevirtual 155	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout$PanelState:ordinal	()I
    //   323: invokevirtual 117	android/content/res/TypedArray:getInt	(II)I
    //   326: aaload
    //   327: putfield 79	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_b_of_type_ComTencentAelightCameraAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState	Lcom/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout$PanelState;
    //   330: aload 5
    //   332: bipush 9
    //   334: iconst_m1
    //   335: invokevirtual 137	android/content/res/TypedArray:getResourceId	(II)I
    //   338: istore_3
    //   339: iload_3
    //   340: iconst_m1
    //   341: if_icmpeq +12 -> 353
    //   344: aload_1
    //   345: iload_3
    //   346: invokestatic 161	android/view/animation/AnimationUtils:loadInterpolator	(Landroid/content/Context;I)Landroid/view/animation/Interpolator;
    //   349: astore_2
    //   350: goto +5 -> 355
    //   353: aconst_null
    //   354: astore_2
    //   355: aload 5
    //   357: invokevirtual 124	android/content/res/TypedArray:recycle	()V
    //   360: goto +31 -> 391
    //   363: astore_1
    //   364: goto +18 -> 382
    //   367: astore_2
    //   368: ldc 163
    //   370: aload_2
    //   371: invokestatic 168	com/tencent/aelight/camera/log/AEQLog:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   374: aload 5
    //   376: invokevirtual 124	android/content/res/TypedArray:recycle	()V
    //   379: goto +10 -> 389
    //   382: aload 5
    //   384: invokevirtual 124	android/content/res/TypedArray:recycle	()V
    //   387: aload_1
    //   388: athrow
    //   389: aconst_null
    //   390: astore_2
    //   391: aload_1
    //   392: invokevirtual 172	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   395: invokevirtual 178	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   398: getfield 183	android/util/DisplayMetrics:density	F
    //   401: fstore 4
    //   403: aload_0
    //   404: getfield 62	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_c_of_type_Int	I
    //   407: iconst_m1
    //   408: if_icmpne +16 -> 424
    //   411: aload_0
    //   412: ldc 184
    //   414: fload 4
    //   416: fmul
    //   417: ldc 185
    //   419: fadd
    //   420: f2i
    //   421: putfield 62	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_c_of_type_Int	I
    //   424: aload_0
    //   425: getfield 64	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_d_of_type_Int	I
    //   428: iconst_m1
    //   429: if_icmpne +16 -> 445
    //   432: aload_0
    //   433: ldc 186
    //   435: fload 4
    //   437: fmul
    //   438: ldc 185
    //   440: fadd
    //   441: f2i
    //   442: putfield 64	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_d_of_type_Int	I
    //   445: aload_0
    //   446: getfield 66	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_e_of_type_Int	I
    //   449: iconst_m1
    //   450: if_icmpne +12 -> 462
    //   453: aload_0
    //   454: fconst_0
    //   455: fload 4
    //   457: fmul
    //   458: f2i
    //   459: putfield 66	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_e_of_type_Int	I
    //   462: aload_0
    //   463: getfield 64	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_d_of_type_Int	I
    //   466: ifle +42 -> 508
    //   469: aload_0
    //   470: getfield 188	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_a_of_type_Boolean	Z
    //   473: ifeq +19 -> 492
    //   476: aload_0
    //   477: aload_0
    //   478: invokevirtual 189	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:getResources	()Landroid/content/res/Resources;
    //   481: ldc 190
    //   483: invokevirtual 194	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   486: putfield 103	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   489: goto +24 -> 513
    //   492: aload_0
    //   493: aload_0
    //   494: invokevirtual 189	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:getResources	()Landroid/content/res/Resources;
    //   497: ldc 195
    //   499: invokevirtual 194	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   502: putfield 103	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   505: goto +8 -> 513
    //   508: aload_0
    //   509: aconst_null
    //   510: putfield 103	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   513: aload_0
    //   514: iconst_0
    //   515: invokevirtual 199	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:setWillNotDraw	(Z)V
    //   518: aload_0
    //   519: aload_0
    //   520: ldc 185
    //   522: aload_2
    //   523: new 201	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout$DragHelperCallback
    //   526: dup
    //   527: aload_0
    //   528: aconst_null
    //   529: invokespecial 204	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout$DragHelperCallback:<init>	(Lcom/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout;Lcom/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout$1;)V
    //   532: invokestatic 209	com/tencent/aelight/camera/aeeditor/lyric/interaction/ViewDragHelper:a	(Landroid/view/ViewGroup;FLandroid/view/animation/Interpolator;Lcom/tencent/aelight/camera/aeeditor/lyric/interaction/ViewDragHelper$Callback;)Lcom/tencent/aelight/camera/aeeditor/lyric/interaction/ViewDragHelper;
    //   535: putfield 105	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper	Lcom/tencent/aelight/camera/aeeditor/lyric/interaction/ViewDragHelper;
    //   538: aload_0
    //   539: getfield 105	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper	Lcom/tencent/aelight/camera/aeeditor/lyric/interaction/ViewDragHelper;
    //   542: aload_0
    //   543: getfield 52	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_a_of_type_Int	I
    //   546: i2f
    //   547: fload 4
    //   549: fmul
    //   550: invokevirtual 212	com/tencent/aelight/camera/aeeditor/lyric/interaction/ViewDragHelper:a	(F)V
    //   553: aload_0
    //   554: iconst_1
    //   555: putfield 214	com/tencent/aelight/camera/aeeditor/lyric/interaction/AESlidingUpPanelLayout:jdField_e_of_type_Boolean	Z
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
    int i = a(0.0F);
    float f1;
    if (this.jdField_a_of_type_Boolean) {
      f1 = i - paramInt;
    } else {
      f1 = paramInt - i;
    }
    return f1 / this.h;
  }
  
  private int a(float paramFloat)
  {
    View localView = this.jdField_c_of_type_AndroidViewView;
    int i;
    if (localView != null) {
      i = localView.getMeasuredHeight();
    } else {
      i = 0;
    }
    int j = (int)(paramFloat * this.h);
    if (this.jdField_a_of_type_Boolean) {
      return getMeasuredHeight() - getPaddingBottom() - this.jdField_c_of_type_Int - j;
    }
    return getPaddingTop() - i + this.jdField_c_of_type_Int + j;
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_b_of_type_ComTencentAelightCameraAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState != AESlidingUpPanelLayout.PanelState.DRAGGING) {
      this.jdField_c_of_type_ComTencentAelightCameraAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState = this.jdField_b_of_type_ComTencentAelightCameraAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState;
    }
    a(AESlidingUpPanelLayout.PanelState.DRAGGING);
    this.jdField_a_of_type_Float = a(paramInt);
    d();
    a(this.jdField_c_of_type_AndroidViewView);
    ViewGroup.LayoutParams localLayoutParams1 = this.jdField_d_of_type_AndroidViewView.getLayoutParams();
    AESlidingUpPanelLayout.LayoutParams localLayoutParams = null;
    if ((localLayoutParams1 instanceof AESlidingUpPanelLayout.LayoutParams)) {
      localLayoutParams = (AESlidingUpPanelLayout.LayoutParams)localLayoutParams1;
    }
    if (localLayoutParams == null) {
      return;
    }
    int i = getHeight();
    int j = getPaddingBottom();
    int k = getPaddingTop();
    int m = this.jdField_c_of_type_Int;
    if ((this.jdField_a_of_type_Float <= 0.0F) && (!this.jdField_b_of_type_Boolean))
    {
      if (this.jdField_a_of_type_Boolean) {
        paramInt -= getPaddingBottom();
      } else {
        paramInt = getHeight() - getPaddingBottom() - this.jdField_c_of_type_AndroidViewView.getMeasuredHeight() - paramInt;
      }
      localLayoutParams.height = paramInt;
      if (localLayoutParams.height == i - j - k - m) {
        localLayoutParams.height = -1;
      }
      this.jdField_d_of_type_AndroidViewView.requestLayout();
      return;
    }
    if ((localLayoutParams.height != -1) && (!this.jdField_b_of_type_Boolean))
    {
      localLayoutParams.height = -1;
      this.jdField_d_of_type_AndroidViewView.requestLayout();
    }
  }
  
  private void a(AESlidingUpPanelLayout.PanelState paramPanelState)
  {
    AESlidingUpPanelLayout.PanelState localPanelState = this.jdField_b_of_type_ComTencentAelightCameraAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState;
    if (localPanelState == paramPanelState) {
      return;
    }
    this.jdField_b_of_type_ComTencentAelightCameraAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState = paramPanelState;
    a(this, localPanelState, paramPanelState);
  }
  
  private static boolean a(View paramView)
  {
    paramView = paramView.getBackground();
    return (paramView != null) && (paramView.getOpacity() == -1);
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
  
  @SuppressLint({"NewApi"})
  private void d()
  {
    if (this.jdField_e_of_type_Int > 0)
    {
      int i = b();
      ViewCompat.setTranslationY(this.jdField_d_of_type_AndroidViewView, i);
    }
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public AESlidingUpPanelLayout.PanelState a()
  {
    return this.jdField_b_of_type_ComTencentAelightCameraAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState;
  }
  
  protected void a()
  {
    a(0.0F, 0);
  }
  
  void a(View paramView)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((AESlidingUpPanelLayout.PanelSlideListener)localIterator.next()).a(paramView, this.jdField_a_of_type_Float);
    }
  }
  
  void a(View paramView, AESlidingUpPanelLayout.PanelState paramPanelState1, AESlidingUpPanelLayout.PanelState paramPanelState2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((AESlidingUpPanelLayout.PanelSlideListener)localIterator.next()).a(paramView, paramPanelState1, paramPanelState2);
    }
    sendAccessibilityEvent(32);
  }
  
  public void a(AESlidingUpPanelLayout.PanelSlideListener paramPanelSlideListener)
  {
    if (paramPanelSlideListener != null) {
      this.jdField_a_of_type_JavaUtilList.add(paramPanelSlideListener);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_e_of_type_Boolean) && (this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_b_of_type_ComTencentAelightCameraAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState != AESlidingUpPanelLayout.PanelState.HIDDEN);
  }
  
  boolean a(float paramFloat, int paramInt)
  {
    if (isEnabled())
    {
      if (this.jdField_c_of_type_AndroidViewView == null) {
        return false;
      }
      paramInt = a(paramFloat);
      ViewDragHelper localViewDragHelper = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper;
      View localView = this.jdField_c_of_type_AndroidViewView;
      if (localViewDragHelper.a(localView, localView.getLeft(), paramInt))
      {
        c();
        ViewCompat.postInvalidateOnAnimation(this);
        return true;
      }
    }
    return false;
  }
  
  public int b()
  {
    int j = (int)(this.jdField_e_of_type_Int * Math.max(this.jdField_a_of_type_Float, 0.0F));
    int i = j;
    if (this.jdField_a_of_type_Boolean) {
      i = -j;
    }
    return i;
  }
  
  void b()
  {
    if (getChildCount() == 0) {
      return;
    }
    int i6 = getPaddingLeft();
    int i3 = getWidth();
    int i4 = getPaddingRight();
    int i5 = getPaddingTop();
    int n = getHeight();
    int i2 = getPaddingBottom();
    View localView = this.jdField_c_of_type_AndroidViewView;
    int i1 = 0;
    int i;
    int j;
    int k;
    int m;
    if ((localView != null) && (a(localView)))
    {
      i = this.jdField_c_of_type_AndroidViewView.getLeft();
      j = this.jdField_c_of_type_AndroidViewView.getRight();
      k = this.jdField_c_of_type_AndroidViewView.getTop();
      m = this.jdField_c_of_type_AndroidViewView.getBottom();
    }
    else
    {
      i = 0;
      j = 0;
      k = 0;
      m = 0;
    }
    localView = getChildAt(0);
    i6 = Math.max(i6, localView.getLeft());
    i5 = Math.max(i5, localView.getTop());
    i3 = Math.min(i3 - i4, localView.getRight());
    i2 = Math.min(n - i2, localView.getBottom());
    n = i1;
    if (i6 >= i)
    {
      n = i1;
      if (i5 >= k)
      {
        n = i1;
        if (i3 <= j)
        {
          n = i1;
          if (i2 <= m) {
            n = 4;
          }
        }
      }
    }
    localView.setVisibility(n);
  }
  
  void c()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 4) {
        localView.setVisibility(0);
      }
      i += 1;
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof AESlidingUpPanelLayout.LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    ViewDragHelper localViewDragHelper = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper;
    if ((localViewDragHelper != null) && (localViewDragHelper.a(true)))
    {
      if (!isEnabled())
      {
        this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper.b();
        return;
      }
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    if ((isEnabled()) && (a()) && ((!this.jdField_d_of_type_Boolean) || (i == 0)))
    {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if (i == 0)
      {
        this.jdField_f_of_type_Boolean = false;
        this.jdField_c_of_type_Float = f1;
        this.jdField_d_of_type_Float = f2;
      }
      else if (i == 2)
      {
        float f3 = this.jdField_c_of_type_Float;
        float f4 = f2 - this.jdField_d_of_type_Float;
        this.jdField_c_of_type_Float = f1;
        this.jdField_d_of_type_Float = f2;
        if (Math.abs(f1 - f3) > Math.abs(f4)) {
          return super.dispatchTouchEvent(paramMotionEvent);
        }
        if (!a(this.jdField_b_of_type_AndroidViewView, (int)this.jdField_e_of_type_Float, (int)this.jdField_f_of_type_Float)) {
          return super.dispatchTouchEvent(paramMotionEvent);
        }
        boolean bool = this.jdField_a_of_type_Boolean;
        int j = -1;
        if (bool) {
          i = 1;
        } else {
          i = -1;
        }
        if (i * f4 > 0.0F)
        {
          if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionScrollableViewHelper.a(this.jdField_b_of_type_AndroidViewView, this.jdField_a_of_type_Boolean) > 0)
          {
            this.jdField_f_of_type_Boolean = true;
            return super.dispatchTouchEvent(paramMotionEvent);
          }
          if (this.jdField_f_of_type_Boolean)
          {
            MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
            localMotionEvent.setAction(3);
            super.dispatchTouchEvent(localMotionEvent);
            localMotionEvent.recycle();
            paramMotionEvent.setAction(0);
          }
          this.jdField_f_of_type_Boolean = false;
          return onTouchEvent(paramMotionEvent);
        }
        i = j;
        if (this.jdField_a_of_type_Boolean) {
          i = 1;
        }
        if (f4 * i < 0.0F)
        {
          if (this.jdField_a_of_type_Float < 1.0F)
          {
            this.jdField_f_of_type_Boolean = false;
            return onTouchEvent(paramMotionEvent);
          }
          if ((!this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper.a()))
          {
            this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper.a();
            paramMotionEvent.setAction(0);
          }
          this.jdField_f_of_type_Boolean = true;
          return super.dispatchTouchEvent(paramMotionEvent);
        }
      }
      else if ((i == 1) && (this.jdField_f_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper.a(0);
      }
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper.b();
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      View localView = this.jdField_c_of_type_AndroidViewView;
      if (localView != null)
      {
        int k = localView.getRight();
        int i;
        int j;
        if (this.jdField_a_of_type_Boolean)
        {
          i = this.jdField_c_of_type_AndroidViewView.getTop() - this.jdField_d_of_type_Int;
          j = this.jdField_c_of_type_AndroidViewView.getTop();
        }
        else
        {
          i = this.jdField_c_of_type_AndroidViewView.getBottom();
          j = this.jdField_c_of_type_AndroidViewView.getBottom() + this.jdField_d_of_type_Int;
        }
        int m = this.jdField_c_of_type_AndroidViewView.getLeft();
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(m, i, k, j);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    int i = paramCanvas.save();
    Object localObject = this.jdField_c_of_type_AndroidViewView;
    boolean bool1;
    if ((localObject != null) && (!localObject.equals(paramView)))
    {
      paramCanvas.getClipBounds(this.jdField_a_of_type_AndroidGraphicsRect);
      if (!this.jdField_b_of_type_Boolean) {
        if (this.jdField_a_of_type_Boolean)
        {
          localObject = this.jdField_a_of_type_AndroidGraphicsRect;
          ((Rect)localObject).bottom = Math.min(((Rect)localObject).bottom, this.jdField_c_of_type_AndroidViewView.getTop());
        }
        else
        {
          localObject = this.jdField_a_of_type_AndroidGraphicsRect;
          ((Rect)localObject).top = Math.max(((Rect)localObject).top, this.jdField_c_of_type_AndroidViewView.getBottom());
        }
      }
      if (this.jdField_c_of_type_Boolean) {
        paramCanvas.clipRect(this.jdField_a_of_type_AndroidGraphicsRect);
      }
      boolean bool2 = super.drawChild(paramCanvas, paramView, paramLong);
      int j = this.jdField_b_of_type_Int;
      bool1 = bool2;
      if (j != 0)
      {
        float f1 = this.jdField_a_of_type_Float;
        bool1 = bool2;
        if (f1 > 0.0F)
        {
          int k = (int)(((0xFF000000 & j) >>> 24) * f1);
          this.jdField_a_of_type_AndroidGraphicsPaint.setColor(j & 0xFFFFFF | k << 24);
          paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
          bool1 = bool2;
        }
      }
    }
    else
    {
      bool1 = super.drawChild(paramCanvas, paramView, paramLong);
    }
    paramCanvas.restoreToCount(i);
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
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_g_of_type_Boolean = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_g_of_type_Boolean = true;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    int i = this.jdField_f_of_type_Int;
    if (i != -1) {
      setDragView(findViewById(i));
    }
    i = this.jdField_g_of_type_Int;
    if (i != -1) {
      setScrollableView(findViewById(i));
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!this.jdField_f_of_type_Boolean) && (a()))
    {
      int i = MotionEventCompat.getActionMasked(paramMotionEvent);
      float f3 = paramMotionEvent.getX();
      float f4 = paramMotionEvent.getY();
      float f1 = Math.abs(f3 - this.jdField_e_of_type_Float);
      float f2 = Math.abs(f4 - this.jdField_f_of_type_Float);
      int j = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper.b();
      if (i != 0)
      {
        if (i != 1) {
          if (i != 2)
          {
            if (i != 3) {
              break label261;
            }
          }
          else
          {
            if ((f2 <= j) || (f1 <= f2)) {
              break label261;
            }
            this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper.a();
            this.jdField_d_of_type_Boolean = true;
            return false;
          }
        }
        if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper.a())
        {
          this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper.a(paramMotionEvent);
          return true;
        }
        f3 = j;
        if ((f2 <= f3) && (f1 <= f3) && (this.jdField_a_of_type_Float > 0.0F) && (!a(this.jdField_c_of_type_AndroidViewView, (int)this.jdField_e_of_type_Float, (int)this.jdField_f_of_type_Float)) && (this.jdField_a_of_type_AndroidViewView$OnClickListener != null))
        {
          playSoundEffect(0);
          this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(this);
          return true;
        }
      }
      else
      {
        this.jdField_d_of_type_Boolean = false;
        this.jdField_e_of_type_Float = f3;
        this.jdField_f_of_type_Float = f4;
        if (!a(this.jdField_a_of_type_AndroidViewView, (int)f3, (int)f4))
        {
          this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper.a();
          this.jdField_d_of_type_Boolean = true;
          return false;
        }
      }
      label261:
      return this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper.a(paramMotionEvent);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper.b();
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getPaddingLeft();
    paramInt4 = getPaddingTop();
    int j = getChildCount();
    if (this.jdField_g_of_type_Boolean)
    {
      paramInt1 = AESlidingUpPanelLayout.2.jdField_a_of_type_ArrayOfInt[this.jdField_b_of_type_ComTencentAelightCameraAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState.ordinal()];
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          if (paramInt1 != 3)
          {
            this.jdField_a_of_type_Float = 0.0F;
          }
          else
          {
            paramInt2 = a(0.0F);
            if (this.jdField_a_of_type_Boolean) {
              paramInt1 = this.jdField_c_of_type_Int;
            } else {
              paramInt1 = -this.jdField_c_of_type_Int;
            }
            this.jdField_a_of_type_Float = a(paramInt2 + paramInt1);
          }
        }
        else {
          this.jdField_a_of_type_Float = this.jdField_b_of_type_Float;
        }
      }
      else {
        this.jdField_a_of_type_Float = 1.0F;
      }
    }
    paramInt2 = 0;
    while (paramInt2 < j)
    {
      View localView = getChildAt(paramInt2);
      if (localView != null)
      {
        ViewGroup.LayoutParams localLayoutParams1 = localView.getLayoutParams();
        AESlidingUpPanelLayout.LayoutParams localLayoutParams = null;
        if ((localLayoutParams1 instanceof AESlidingUpPanelLayout.LayoutParams)) {
          localLayoutParams = (AESlidingUpPanelLayout.LayoutParams)localLayoutParams1;
        }
        if ((localLayoutParams != null) && ((localView.getVisibility() != 8) || ((paramInt2 != 0) && (!this.jdField_g_of_type_Boolean))))
        {
          int k = localView.getMeasuredHeight();
          if (localView.equals(this.jdField_c_of_type_AndroidViewView)) {
            paramInt1 = a(this.jdField_a_of_type_Float);
          } else {
            paramInt1 = paramInt4;
          }
          paramInt3 = paramInt1;
          if (!this.jdField_a_of_type_Boolean)
          {
            paramInt3 = paramInt1;
            if (localView.equals(this.jdField_d_of_type_AndroidViewView))
            {
              paramInt3 = paramInt1;
              if (!this.jdField_b_of_type_Boolean) {
                paramInt3 = a(this.jdField_a_of_type_Float) + this.jdField_c_of_type_AndroidViewView.getMeasuredHeight();
              }
            }
          }
          paramInt1 = localLayoutParams.leftMargin + i;
          localView.layout(paramInt1, paramInt3, localView.getMeasuredWidth() + paramInt1, k + paramInt3);
        }
      }
      paramInt2 += 1;
    }
    if (this.jdField_g_of_type_Boolean) {
      b();
    }
    d();
    this.jdField_g_of_type_Boolean = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    int m = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getMode(paramInt2);
    int n = View.MeasureSpec.getSize(paramInt2);
    if ((i != 1073741824) && (i != -2147483648)) {
      throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
    }
    if ((paramInt1 != 1073741824) && (paramInt1 != -2147483648)) {
      throw new IllegalStateException("Height must have an exact value or MATCH_PARENT");
    }
    int i1 = getChildCount();
    if (i1 == 2)
    {
      int j = 0;
      this.jdField_d_of_type_AndroidViewView = getChildAt(0);
      this.jdField_c_of_type_AndroidViewView = getChildAt(1);
      if (this.jdField_a_of_type_AndroidViewView == null) {
        setDragView(this.jdField_c_of_type_AndroidViewView);
      }
      if (this.jdField_c_of_type_AndroidViewView.getVisibility() != 0) {
        this.jdField_b_of_type_ComTencentAelightCameraAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState = AESlidingUpPanelLayout.PanelState.HIDDEN;
      }
      i = n - getPaddingTop() - getPaddingBottom();
      int k = m - getPaddingLeft() - getPaddingRight();
      while (j < i1)
      {
        localObject = getChildAt(j);
        if (localObject != null)
        {
          AESlidingUpPanelLayout.LayoutParams localLayoutParams = (AESlidingUpPanelLayout.LayoutParams)((View)localObject).getLayoutParams();
          if ((localLayoutParams != null) && ((((View)localObject).getVisibility() != 8) || (j != 0)))
          {
            if (localObject.equals(this.jdField_d_of_type_AndroidViewView))
            {
              if ((!this.jdField_b_of_type_Boolean) && (this.jdField_b_of_type_ComTencentAelightCameraAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState != AESlidingUpPanelLayout.PanelState.HIDDEN)) {
                paramInt2 = i - this.jdField_c_of_type_Int;
              } else {
                paramInt2 = i;
              }
              paramInt1 = k - (localLayoutParams.leftMargin + localLayoutParams.rightMargin);
            }
            else
            {
              if (localObject.equals(this.jdField_c_of_type_AndroidViewView)) {
                paramInt2 = i - localLayoutParams.topMargin;
              } else {
                paramInt2 = i;
              }
              paramInt1 = k;
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
              if ((localLayoutParams.jdField_a_of_type_Float > 0.0F) && (localLayoutParams.jdField_a_of_type_Float < 1.0F)) {
                paramInt2 = (int)(paramInt2 * localLayoutParams.jdField_a_of_type_Float);
              } else if (localLayoutParams.height != -1) {
                paramInt2 = localLayoutParams.height;
              }
              paramInt2 = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
            }
            ((View)localObject).measure(paramInt1, paramInt2);
            if (localObject.equals(this.jdField_c_of_type_AndroidViewView)) {
              this.h = (this.jdField_c_of_type_AndroidViewView.getMeasuredHeight() - this.jdField_c_of_type_Int);
            }
          }
        }
        j += 1;
      }
      setMeasuredDimension(m, n);
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
      this.jdField_b_of_type_ComTencentAelightCameraAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState = ((AESlidingUpPanelLayout.PanelState)localBundle.getSerializable("sliding_state"));
      localObject = this.jdField_b_of_type_ComTencentAelightCameraAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState;
      paramParcelable = (Parcelable)localObject;
      if (localObject == null) {
        paramParcelable = jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState;
      }
      this.jdField_b_of_type_ComTencentAelightCameraAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState = paramParcelable;
      localObject = localBundle.getParcelable("superState");
    }
    super.onRestoreInstanceState((Parcelable)localObject);
  }
  
  public Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("superState", super.onSaveInstanceState());
    AESlidingUpPanelLayout.PanelState localPanelState;
    if (this.jdField_b_of_type_ComTencentAelightCameraAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState != AESlidingUpPanelLayout.PanelState.DRAGGING) {
      localPanelState = this.jdField_b_of_type_ComTencentAelightCameraAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState;
    } else {
      localPanelState = this.jdField_c_of_type_ComTencentAelightCameraAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState;
    }
    localBundle.putSerializable("sliding_state", localPanelState);
    return localBundle;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt2 != paramInt4) {
      this.jdField_g_of_type_Boolean = true;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((isEnabled()) && (a())) {}
    try
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper.a(paramMotionEvent);
      paramMotionEvent = this.jdField_b_of_type_ComTencentAelightCameraAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState;
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
      this.jdField_b_of_type_Float = paramFloat;
      this.jdField_g_of_type_Boolean = true;
      requestLayout();
    }
  }
  
  public void setDragView(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
    setDragView(findViewById(paramInt));
  }
  
  public void setDragView(View paramView)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      localView.setOnClickListener(null);
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    paramView = this.jdField_a_of_type_AndroidViewView;
    if (paramView != null)
    {
      paramView.setClickable(true);
      this.jdField_a_of_type_AndroidViewView.setFocusable(false);
      this.jdField_a_of_type_AndroidViewView.setFocusableInTouchMode(false);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new AESlidingUpPanelLayout.1(this));
    }
  }
  
  public void setFadeOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
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
    this.jdField_a_of_type_Boolean = bool;
    if (!this.jdField_g_of_type_Boolean) {
      requestLayout();
    }
  }
  
  public void setPanelHeight(int paramInt)
  {
    if (a() == paramInt) {
      return;
    }
    this.jdField_c_of_type_Int = paramInt;
    if (!this.jdField_g_of_type_Boolean) {
      requestLayout();
    }
    if (a() == AESlidingUpPanelLayout.PanelState.COLLAPSED)
    {
      a();
      invalidate();
    }
  }
  
  public void setPanelState(AESlidingUpPanelLayout.PanelState paramPanelState)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper.a() == 2)
    {
      Log.d("SlidingUpPanelLayout", "View is settling. Aborting animation.");
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper.b();
    }
    if ((paramPanelState != null) && (paramPanelState != AESlidingUpPanelLayout.PanelState.DRAGGING))
    {
      if ((isEnabled()) && ((this.jdField_g_of_type_Boolean) || (this.jdField_c_of_type_AndroidViewView != null)))
      {
        AESlidingUpPanelLayout.PanelState localPanelState = this.jdField_b_of_type_ComTencentAelightCameraAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState;
        if (paramPanelState != localPanelState)
        {
          if (localPanelState == AESlidingUpPanelLayout.PanelState.DRAGGING) {
            return;
          }
          if (this.jdField_g_of_type_Boolean)
          {
            a(paramPanelState);
            return;
          }
          if (this.jdField_b_of_type_ComTencentAelightCameraAeeditorLyricInteractionAESlidingUpPanelLayout$PanelState == AESlidingUpPanelLayout.PanelState.HIDDEN)
          {
            this.jdField_c_of_type_AndroidViewView.setVisibility(0);
            requestLayout();
          }
          int i = AESlidingUpPanelLayout.2.jdField_a_of_type_ArrayOfInt[paramPanelState.ordinal()];
          if (i != 1)
          {
            if (i != 2)
            {
              if (i != 3)
              {
                if (i != 4) {
                  return;
                }
                a(0.0F, 0);
                return;
              }
              int j = a(0.0F);
              if (this.jdField_a_of_type_Boolean) {
                i = this.jdField_c_of_type_Int;
              } else {
                i = -this.jdField_c_of_type_Int;
              }
              a(a(j + i), 0);
              return;
            }
            a(this.jdField_b_of_type_Float, 0);
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
    this.jdField_b_of_type_AndroidViewView = paramView;
  }
  
  public void setShadowHeight(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    if (!this.jdField_g_of_type_Boolean) {
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.lyric.interaction.AESlidingUpPanelLayout
 * JD-Core Version:    0.7.0.1
 */