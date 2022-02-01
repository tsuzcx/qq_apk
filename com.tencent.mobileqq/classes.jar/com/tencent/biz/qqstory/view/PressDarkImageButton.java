package com.tencent.biz.qqstory.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageButton;

@TargetApi(14)
public class PressDarkImageButton
  extends ImageButton
{
  public static final int[] a = { 16843210, 16843211, 2131034825 };
  public float b;
  public float c;
  public int d;
  public int e;
  private Bitmap f;
  private boolean g;
  private boolean h;
  private boolean i;
  private Paint j;
  
  public PressDarkImageButton(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public PressDarkImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  /* Error */
  public PressDarkImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: iload_3
    //   4: invokespecial 40	android/widget/ImageButton:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   7: aload_0
    //   8: fconst_1
    //   9: putfield 42	com/tencent/biz/qqstory/view/PressDarkImageButton:b	F
    //   12: aload_0
    //   13: ldc 43
    //   15: putfield 45	com/tencent/biz/qqstory/view/PressDarkImageButton:c	F
    //   18: aload_0
    //   19: iconst_0
    //   20: putfield 47	com/tencent/biz/qqstory/view/PressDarkImageButton:d	I
    //   23: aload_0
    //   24: iconst_0
    //   25: putfield 49	com/tencent/biz/qqstory/view/PressDarkImageButton:e	I
    //   28: aload_0
    //   29: iconst_0
    //   30: putfield 51	com/tencent/biz/qqstory/view/PressDarkImageButton:g	Z
    //   33: aload_0
    //   34: iconst_0
    //   35: putfield 53	com/tencent/biz/qqstory/view/PressDarkImageButton:h	Z
    //   38: aload_0
    //   39: iconst_1
    //   40: putfield 55	com/tencent/biz/qqstory/view/PressDarkImageButton:i	Z
    //   43: aload_1
    //   44: aload_2
    //   45: getstatic 30	com/tencent/biz/qqstory/view/PressDarkImageButton:a	[I
    //   48: invokevirtual 61	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   51: astore 4
    //   53: aload_0
    //   54: aload 4
    //   56: iconst_0
    //   57: aload_0
    //   58: getfield 42	com/tencent/biz/qqstory/view/PressDarkImageButton:b	F
    //   61: invokevirtual 67	android/content/res/TypedArray:getFloat	(IF)F
    //   64: putfield 42	com/tencent/biz/qqstory/view/PressDarkImageButton:b	F
    //   67: aload_0
    //   68: aload 4
    //   70: iconst_1
    //   71: aload_0
    //   72: getfield 45	com/tencent/biz/qqstory/view/PressDarkImageButton:c	F
    //   75: invokevirtual 67	android/content/res/TypedArray:getFloat	(IF)F
    //   78: putfield 45	com/tencent/biz/qqstory/view/PressDarkImageButton:c	F
    //   81: aload_0
    //   82: aload 4
    //   84: iconst_2
    //   85: iconst_0
    //   86: invokevirtual 71	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   89: putfield 51	com/tencent/biz/qqstory/view/PressDarkImageButton:g	Z
    //   92: aload 4
    //   94: invokevirtual 74	android/content/res/TypedArray:recycle	()V
    //   97: aload_0
    //   98: getfield 51	com/tencent/biz/qqstory/view/PressDarkImageButton:g	Z
    //   101: ifeq +231 -> 332
    //   104: aconst_null
    //   105: astore 4
    //   107: aconst_null
    //   108: astore 5
    //   110: aload_1
    //   111: aload_2
    //   112: iconst_2
    //   113: newarray int
    //   115: dup
    //   116: iconst_0
    //   117: ldc 75
    //   119: iastore
    //   120: dup
    //   121: iconst_1
    //   122: ldc 76
    //   124: iastore
    //   125: invokevirtual 61	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   128: astore_1
    //   129: aload_1
    //   130: astore 5
    //   132: aload_1
    //   133: astore 4
    //   135: aload_0
    //   136: aload_1
    //   137: iconst_0
    //   138: iconst_0
    //   139: invokevirtual 80	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   142: putfield 47	com/tencent/biz/qqstory/view/PressDarkImageButton:d	I
    //   145: aload_1
    //   146: astore 5
    //   148: aload_1
    //   149: astore 4
    //   151: aload_0
    //   152: aload_1
    //   153: iconst_1
    //   154: iconst_0
    //   155: invokevirtual 80	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   158: putfield 49	com/tencent/biz/qqstory/view/PressDarkImageButton:e	I
    //   161: aload_1
    //   162: astore 5
    //   164: aload_1
    //   165: astore 4
    //   167: aload_0
    //   168: getfield 82	com/tencent/biz/qqstory/view/PressDarkImageButton:f	Landroid/graphics/Bitmap;
    //   171: ifnonnull +116 -> 287
    //   174: aload_1
    //   175: astore 5
    //   177: aload_1
    //   178: astore 4
    //   180: getstatic 87	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   183: astore_2
    //   184: aload_2
    //   185: ifnull +24 -> 209
    //   188: aload_1
    //   189: astore 5
    //   191: aload_1
    //   192: astore 4
    //   194: aload_0
    //   195: getstatic 87	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   198: ldc 89
    //   200: invokevirtual 95	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   203: checkcast 97	android/graphics/Bitmap
    //   206: putfield 82	com/tencent/biz/qqstory/view/PressDarkImageButton:f	Landroid/graphics/Bitmap;
    //   209: aload_1
    //   210: astore 5
    //   212: aload_1
    //   213: astore 4
    //   215: aload_0
    //   216: getfield 82	com/tencent/biz/qqstory/view/PressDarkImageButton:f	Landroid/graphics/Bitmap;
    //   219: ifnonnull +68 -> 287
    //   222: aload_1
    //   223: astore 5
    //   225: aload_1
    //   226: astore 4
    //   228: aload_0
    //   229: invokestatic 103	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   232: invokevirtual 107	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   235: ldc 108
    //   237: invokestatic 113	com/tencent/mobileqq/util/BitmapManager:b	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   240: putfield 82	com/tencent/biz/qqstory/view/PressDarkImageButton:f	Landroid/graphics/Bitmap;
    //   243: aload_1
    //   244: astore 5
    //   246: aload_1
    //   247: astore 4
    //   249: aload_0
    //   250: getfield 82	com/tencent/biz/qqstory/view/PressDarkImageButton:f	Landroid/graphics/Bitmap;
    //   253: ifnull +34 -> 287
    //   256: aload_1
    //   257: astore 5
    //   259: aload_1
    //   260: astore 4
    //   262: getstatic 87	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   265: ifnull +22 -> 287
    //   268: aload_1
    //   269: astore 5
    //   271: aload_1
    //   272: astore 4
    //   274: getstatic 87	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   277: ldc 89
    //   279: aload_0
    //   280: getfield 82	com/tencent/biz/qqstory/view/PressDarkImageButton:f	Landroid/graphics/Bitmap;
    //   283: invokevirtual 117	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   286: pop
    //   287: aload_1
    //   288: ifnull +44 -> 332
    //   291: goto +24 -> 315
    //   294: astore_1
    //   295: goto +25 -> 320
    //   298: astore_1
    //   299: aload 4
    //   301: astore 5
    //   303: aload_1
    //   304: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   307: aload 4
    //   309: ifnull +23 -> 332
    //   312: aload 4
    //   314: astore_1
    //   315: aload_1
    //   316: invokevirtual 74	android/content/res/TypedArray:recycle	()V
    //   319: return
    //   320: aload 5
    //   322: ifnull +8 -> 330
    //   325: aload 5
    //   327: invokevirtual 74	android/content/res/TypedArray:recycle	()V
    //   330: aload_1
    //   331: athrow
    //   332: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	333	0	this	PressDarkImageButton
    //   0	333	1	paramContext	Context
    //   0	333	2	paramAttributeSet	AttributeSet
    //   0	333	3	paramInt	int
    //   51	262	4	localObject1	java.lang.Object
    //   108	218	5	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   110	129	294	finally
    //   135	145	294	finally
    //   151	161	294	finally
    //   167	174	294	finally
    //   180	184	294	finally
    //   194	209	294	finally
    //   215	222	294	finally
    //   228	243	294	finally
    //   249	256	294	finally
    //   262	268	294	finally
    //   274	287	294	finally
    //   303	307	294	finally
    //   110	129	298	java/lang/Exception
    //   135	145	298	java/lang/Exception
    //   151	161	298	java/lang/Exception
    //   167	174	298	java/lang/Exception
    //   180	184	298	java/lang/Exception
    //   194	209	298	java/lang/Exception
    //   215	222	298	java/lang/Exception
    //   228	243	298	java/lang/Exception
    //   249	256	298	java/lang/Exception
    //   262	268	298	java/lang/Exception
    //   274	287	298	java/lang/Exception
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if ((this.g) && (this.h) && (this.d != 0) && (this.e != 0) && (this.f != null))
    {
      if (this.j == null) {
        this.j = new Paint();
      }
      float f1 = getResources().getDisplayMetrics().density / 2.0F;
      Matrix localMatrix = new Matrix();
      localMatrix.setScale(f1, f1);
      localMatrix.setTranslate(this.d * 0.625F, this.e * 0.2564103F);
      if (isPressed()) {
        this.j.setAlpha((int)(this.c * 255.0F));
      } else {
        this.j.setAlpha((int)(this.b * 255.0F));
      }
      paramCanvas.drawBitmap(this.f, localMatrix, this.j);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (!this.i) {
      return;
    }
    if (isPressed())
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        super.setImageAlpha((int)(this.c * 255.0F));
        return;
      }
      if (Build.VERSION.SDK_INT >= 11)
      {
        super.setAlpha(this.c);
        return;
      }
      super.setColorFilter(-3355444, PorterDuff.Mode.MULTIPLY);
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      super.setImageAlpha((int)(this.b * 255.0F));
      return;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      super.setAlpha(this.b);
      return;
    }
    super.clearColorFilter();
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.h != paramBoolean)
    {
      this.h = paramBoolean;
      invalidate();
    }
  }
  
  public void setEnableDark(boolean paramBoolean)
  {
    this.i = paramBoolean;
    if (!paramBoolean)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        super.setImageAlpha((int)(this.b * 255.0F));
        return;
      }
      if (Build.VERSION.SDK_INT >= 11)
      {
        super.setAlpha(this.b);
        return;
      }
      super.clearColorFilter();
    }
  }
  
  public void setInvalid()
  {
    this.i = false;
    super.setEnabled(false);
    super.setClickable(false);
    if (Build.VERSION.SDK_INT >= 16)
    {
      super.setImageAlpha((int)(this.c * 255.0F));
      return;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      super.setAlpha(this.c);
      return;
    }
    super.setColorFilter(-3355444, PorterDuff.Mode.MULTIPLY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.PressDarkImageButton
 * JD-Core Version:    0.7.0.1
 */