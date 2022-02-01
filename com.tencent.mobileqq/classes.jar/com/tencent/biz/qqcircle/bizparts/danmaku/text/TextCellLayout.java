package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import NS_MOBILE_MATERIAL.BubbleSource;
import android.app.Application;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import com.etrump.mixlayout.api.IETDecoration;
import com.etrump.mixlayout.api.IETEngine;
import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostFontHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostZipHelper;
import com.tencent.biz.qcircleshadow.lib.QCirclrHostFontHelper;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleFullTypeResult;
import com.tencent.biz.qqcircle.bizparts.danmaku.model.QzoneBarrageEffectData.BarrageEffectInfo;
import com.tencent.biz.qqcircle.bizparts.danmaku.util.EmotcationUtils;
import com.tencent.biz.qqcircle.bizparts.danmaku.util.TouchAnalizer;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.component.media.image.ImageLoader.ImageLoadListener;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.utils.BaseConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public class TextCellLayout
{
  public static boolean a = false;
  private static final int bV = ViewUtils.a(30.0F);
  private static final int bW = ViewUtils.a(10.0F);
  private static final int bX = ViewUtils.a(40.0F);
  private static final int bY = ViewUtils.a(20.0F);
  private static final int bZ = ViewUtils.a(50.0F);
  private static final AtomicInteger bg;
  private static int bz;
  private static final int ca = ViewUtils.a(70.0F);
  protected static final boolean p;
  protected static Object r;
  private int A = -1;
  private int B = -1;
  private int C = 0;
  private int D = 0;
  private int E = 0;
  private int F = 0;
  private String G = QCircleConfigHelper.a("QZoneTextSetting", "TextViewPack", "收起");
  private String H = QCircleConfigHelper.a("QZoneTextSetting", "TextViewShow", "展开");
  private String I = QCircleConfigHelper.a("QZoneTextSetting", "TextViewLookUpAll", "查看全文");
  private boolean J = false;
  private int K = 0;
  private int L = 0;
  private int M = 0;
  private boolean N = false;
  private int O = -1;
  private ArrayList<TextCell> P;
  private boolean Q = false;
  private ArrayList<TextCellLayout.MeasuredLine> R = new ArrayList();
  private ArrayList<Integer> S = new ArrayList();
  private boolean T = true;
  private boolean U = false;
  private boolean V = false;
  private int W = 0;
  private int X = 0;
  private int Y = 0;
  private int Z;
  private boolean aA = true;
  private float[] aB = new float[26];
  private ReasignablePair<Integer, Float> aC;
  private ReasignablePair<Integer, Integer> aD;
  private String aE = "...";
  private TextCell aF = new TextCell(0, this.aE);
  private ColorTextCell aG = new ColorTextCell(10, HardCodeUtil.a(2131912170), -8947849);
  private InnerOperateTextCell aH;
  private InnerOperateTextCell aI;
  private float aJ;
  private int aK = 0;
  private int aL = 0;
  private int aM = 0;
  private int aN = 0;
  private String aO;
  private Drawable aP;
  private long aQ = 0L;
  private long aR = 0L;
  private boolean aS = false;
  private int aT;
  private Typeface aU;
  private Typeface aV;
  private LinearGradient aW;
  private int[] aX;
  private float[] aY;
  private GradientDrawable.Orientation aZ;
  private int aa = 0;
  private int ab = 0;
  private int ac = -1;
  private int ad = -16777216;
  private int ae = -16777216;
  private int af = QCircleApplication.APP.getResources().getColor(2131167773);
  private int ag = -2763307;
  private boolean ah = true;
  private int ai = -1710619;
  private ColorStateList aj = null;
  private ColorStateList ak = null;
  private RectF al = new RectF();
  private TextCell am;
  private ReasignablePair<Integer, Integer> an;
  private ArrayList<TextCell> ao = new ArrayList();
  private float ap = -1.0F;
  private float aq = -1.0F;
  private boolean ar = true;
  private boolean as = true;
  private TextCellLayout.OnCellClickListener at;
  private boolean au = true;
  private boolean av = true;
  private boolean aw = true;
  private boolean ax = false;
  private boolean ay = false;
  private int az = 16;
  protected Paint b;
  private Transformation bA = new Transformation();
  private Transformation bB = new Transformation();
  private Drawable.Callback bC = new TextCellLayout.2(this);
  private int bD = -1;
  private int bE = -1;
  private ImageLoader.ImageLoadListener bF = null;
  private boolean bG = false;
  private boolean bH = false;
  private Drawable bI;
  private Drawable bJ;
  private long bK = 0L;
  private int bL = 0;
  private Integer bM = Integer.valueOf(-1);
  private String bN = null;
  private int bO = -1;
  private boolean bP = true;
  private int bQ;
  private int bR;
  private TranslateAnimation bS;
  private Animatable bT = null;
  private float[] bU;
  private int ba;
  private int bb;
  private int bc;
  private int bd;
  private int be;
  private boolean bf = false;
  private int bh = 0;
  private int bi = 0;
  private Integer bj = null;
  private int bk = -1;
  private int bl = -1;
  private boolean bm = true;
  private TextCellLayout.RecycleCacheTag bn = null;
  private TextCellLayout.RecycleCacheTag bo = null;
  private int bp = 0;
  private volatile boolean bq = false;
  private ArrayList<TextCellLayout.SideDrawable> br;
  private ArrayList<TextCellLayout.SideDrawable> bs;
  private int bt = 0;
  private TextCellLayout.OnSideDrawableClickListener bu;
  private int bv = ViewUtils.a(5.0F);
  private TextLayoutBase bw;
  private int bx = 0;
  private TextCellLayout.SideDrawable by = null;
  protected int c;
  private boolean cb = true;
  private QzoneFontManager.OnFontLoadListener cc;
  private QCircleFullTypeResult cd;
  private String ce = null;
  public TextCellLayout.TextCellLayoutFadeAnimationListener d;
  protected TextColorAnimation e = null;
  protected Drawable f = null;
  public Boolean g = Boolean.valueOf(true);
  public int h = 0;
  public boolean i = false;
  public boolean j = false;
  public int k = 0;
  public ETAnimator l;
  public IETDecoration m;
  public ETTextLayout n;
  public boolean o = true;
  protected volatile boolean q = false;
  private boolean s = false;
  private int t;
  private float u;
  private int v = 0;
  private int w = 0;
  private int x = ViewUtils.a(2.0F);
  private int y = 1048576;
  private float z = 0.0F;
  
  static
  {
    boolean bool = true;
    bg = new AtomicInteger(1);
    if ((Build.VERSION.SDK_INT >= 18) || (Build.VERSION.SDK_INT <= 13)) {
      bool = false;
    }
    p = bool;
    r = new Object();
    bz = 100;
  }
  
  public TextCellLayout(TextLayoutBase paramTextLayoutBase)
  {
    this(paramTextLayoutBase, new Paint(1));
  }
  
  public TextCellLayout(TextLayoutBase paramTextLayoutBase, Paint paramPaint)
  {
    Paint localPaint = paramPaint;
    if (paramPaint == null) {
      localPaint = new Paint(1);
    }
    this.b = localPaint;
    this.bw = paramTextLayoutBase;
  }
  
  private boolean A()
  {
    IETDecoration localIETDecoration = this.m;
    boolean bool = false;
    if (localIETDecoration == null) {
      return false;
    }
    if (localIETDecoration.getFrameNum() > 0) {
      bool = true;
    }
    return bool;
  }
  
  private void B()
  {
    if (this.bk > 0)
    {
      Bitmap localBitmap = (Bitmap)TextCellLayoutCache.a().b().remove(Integer.valueOf(G()));
      if (localBitmap != null) {
        localBitmap.recycle();
      }
    }
  }
  
  private Bitmap C()
  {
    if (!this.o)
    {
      Bitmap localBitmap = (Bitmap)TextCellLayoutCache.a().b().get(Integer.valueOf(G()));
      if (localBitmap != null) {
        return localBitmap;
      }
    }
    return null;
  }
  
  private void D()
  {
    if (this.bn == null)
    {
      int i1 = this.bk;
      if (i1 > 0) {
        this.bn = new TextCellLayout.RecycleCacheTag(this, i1);
      }
    }
  }
  
  private Bitmap E()
  {
    try
    {
      B();
      Bitmap localBitmap = Bitmap.createBitmap(this.W, this.Z, Bitmap.Config.ARGB_8888);
      TextCellLayoutCache.a().b().put(Integer.valueOf(G()), localBitmap);
      D();
      return localBitmap;
    }
    catch (Throwable localThrowable)
    {
      this.bm = false;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("allocCacheBitmap OutOfMemoryError.errMsg = ");
      localStringBuilder.append(localThrowable.getMessage());
      QLog.e("TextCellLayout", 1, localStringBuilder.toString());
    }
    return null;
  }
  
  private boolean F()
  {
    return (this.bm) && ((this.b instanceof ETPaint)) && (FontManager.a()) && (this.R.size() <= 9) && (this.R.size() >= 0);
  }
  
  private int G()
  {
    if (this.bk < 0) {
      this.bk = bg.addAndGet(1);
    }
    return this.bk;
  }
  
  private int H()
  {
    if (this.bl < 0) {
      this.bl = bg.addAndGet(1);
    }
    return this.bl;
  }
  
  private void I()
  {
    if (this.aX != null)
    {
      if (this.aY == null) {
        return;
      }
      if ((this.aW != null) && (this.ba == this.X)) {
        return;
      }
      this.ba = this.X;
      Rect localRect = new Rect(0, 0, this.ba, this.Z);
      switch (TextCellLayout.7.a[this.aZ.ordinal()])
      {
      default: 
        f1 = localRect.left;
        f2 = localRect.top;
        f3 = localRect.right * 1.0F;
        i1 = localRect.bottom;
      case 7: 
      case 6: 
      case 5: 
      case 4: 
      case 3: 
      case 2: 
        for (;;)
        {
          f4 = i1 * 1.0F;
          break label376;
          f2 = localRect.left;
          f1 = localRect.top;
          i1 = localRect.right;
          break label291;
          f1 = localRect.left;
          f2 = localRect.bottom;
          f3 = localRect.right * 1.0F;
          i1 = localRect.top;
          continue;
          f1 = localRect.left;
          f2 = localRect.bottom;
          i1 = localRect.top;
          break;
          f1 = localRect.right;
          f2 = localRect.bottom;
          f3 = localRect.left * 1.0F;
          i1 = localRect.top;
          continue;
          f2 = localRect.right;
          f1 = localRect.top;
          i1 = localRect.left;
          label291:
          float f5 = i1 * 1.0F;
          f3 = f2;
          f2 = f1;
          f4 = f2;
          f1 = f3;
          f3 = f5;
          break label376;
          f1 = localRect.right;
          f2 = localRect.top;
          f3 = localRect.left * 1.0F;
          i1 = localRect.bottom;
        }
      }
      float f1 = localRect.left;
      float f2 = localRect.top;
      int i1 = localRect.bottom;
      float f4 = i1 * 1.0F;
      float f3 = f1;
      label376:
      this.aW = new LinearGradient(f1, f2, f3, f4, this.aX, this.aY, Shader.TileMode.CLAMP);
    }
  }
  
  private int J()
  {
    int i1 = this.ac;
    if (i1 > -1) {
      return i1;
    }
    this.ac = 0;
    try
    {
      if ((this.R != null) && (this.R.size() > 0))
      {
        TextCellLayout.MeasuredLine localMeasuredLine = (TextCellLayout.MeasuredLine)this.R.get(0);
        if ((localMeasuredLine != null) && (localMeasuredLine.c() > 0)) {
          localMeasuredLine.a(0);
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return this.ac;
  }
  
  private Boolean K()
  {
    boolean bool;
    if ((L()) && (!M()) && (!TextUtils.isEmpty(this.aO))) {
      bool = true;
    } else {
      bool = false;
    }
    return Boolean.valueOf(bool);
  }
  
  private boolean L()
  {
    return this.bi == 4;
  }
  
  private boolean M()
  {
    boolean bool1 = L();
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    ArrayList localArrayList = this.P;
    bool1 = bool2;
    if (localArrayList != null)
    {
      bool1 = bool2;
      if (localArrayList.size() > 0) {
        bool1 = ((TextCell)this.P.get(0)).useDefaultFont;
      }
    }
    return bool1;
  }
  
  private int a(String paramString, int paramInt)
  {
    while (paramInt >= 0)
    {
      char c1 = paramString.charAt(paramInt);
      int i1 = paramInt;
      if (c1 != ' ') {
        if (!c(c1))
        {
          i1 = paramInt;
        }
        else
        {
          paramInt -= 1;
          continue;
        }
      }
      do
      {
        paramInt = i1 - 1;
        if (paramInt < 0) {
          break;
        }
        i1 = paramInt;
      } while (paramString.charAt(paramInt) == ' ');
      return paramInt + 2;
    }
    return 0;
  }
  
  private ReasignablePair<Integer, Float> a(TextCell paramTextCell, int paramInt)
  {
    if (this.aC == null) {
      this.aC = new ReasignablePair(Integer.valueOf(-1), Float.valueOf(-1.0F));
    }
    if (!paramTextCell.canBreak()) {
      return this.aC.a(Integer.valueOf(paramTextCell.getLength()), Float.valueOf(paramTextCell.getWidth(this.b)));
    }
    int i2 = paramTextCell.getText().indexOf('\n');
    int i1;
    if (i2 >= 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    String str;
    if (i1 == 0) {
      str = paramTextCell.getText();
    } else {
      str = paramTextCell.getText().substring(0, i2 + 1);
    }
    int i4 = str.length();
    i2 = 0;
    float f1 = 0.0F;
    for (;;)
    {
      int i3 = 25;
      int i5 = i2 + 25;
      i1 = i3;
      if (i5 < i4)
      {
        i1 = i3;
        if (Character.isHighSurrogate(str.charAt(i5 - 1))) {
          i1 = 26;
        }
      }
      if (i2 >= i4) {
        break;
      }
      i3 = i1;
      if (i2 + i1 >= i4) {
        i3 = i4 - i2;
      }
      i5 = paramTextCell.getWidths(this.b, i2, i3, this.aB);
      i1 = 0;
      while (i1 < i5)
      {
        float f2 = this.aB[i1] + f1;
        if (f2 > paramInt - 6) {
          return this.aC.a(Integer.valueOf(i1 + i2), Float.valueOf(f1));
        }
        i1 += 1;
        f1 = f2;
      }
      if ((i5 < i3) || (i3 == 0)) {
        break;
      }
      i2 += i3;
    }
    return this.aC.a(Integer.valueOf(i4), Float.valueOf(f1));
  }
  
  private TextCell a(TextCell paramTextCell, int paramInt1, TextCellLayout.MeasuredLine paramMeasuredLine, float paramFloat, int paramInt2)
  {
    if ((paramInt1 == 0) && (this.v != 0)) {
      return paramTextCell;
    }
    TextCell localTextCell = paramTextCell.copy();
    int i2 = paramInt1;
    float f1 = paramFloat;
    if (paramTextCell.canBreak())
    {
      i2 = paramTextCell.getLength();
      int i1 = paramInt1;
      if (paramInt1 > i2) {
        i1 = i2;
      }
      localTextCell.text = paramTextCell.getText().substring(0, i1);
      i2 = i1;
      f1 = paramFloat;
      if (paramFloat <= 0.0F)
      {
        f1 = c(localTextCell);
        i2 = i1;
      }
    }
    if ((i2 == 0) && (this.v == 0))
    {
      a(paramMeasuredLine, localTextCell, f1);
      return null;
    }
    if ((!paramTextCell.canBreak()) && (f1 > paramInt2) && (this.v != 0)) {
      return paramTextCell;
    }
    a(paramMeasuredLine, localTextCell, f1);
    if (i2 >= paramTextCell.getLength()) {
      return null;
    }
    paramMeasuredLine = paramTextCell.copy();
    paramMeasuredLine.text = paramTextCell.text.substring(i2);
    return paramMeasuredLine;
  }
  
  private TextCellLayout.SideDrawable a(ArrayList<TextCellLayout.SideDrawable> paramArrayList, float paramFloat1, float paramFloat2)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.isEmpty()) {
        return null;
      }
      int i1 = 0;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        TextCellLayout.SideDrawable localSideDrawable = (TextCellLayout.SideDrawable)paramArrayList.next();
        if (a(paramFloat1 - i1, paramFloat2, localSideDrawable.c)) {
          return localSideDrawable;
        }
        i1 += this.bv + localSideDrawable.c.width();
      }
    }
    return null;
  }
  
  private void a(int paramInt1, String paramString, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramInt1 != this.aT) {
      return;
    }
    Object localObject = this.b;
    if ((localObject instanceof ETPaint)) {
      localObject = (ETPaint)localObject;
    } else {
      localObject = new ETPaint(1);
    }
    if (!((ETPaint)localObject).a(paramInt1, paramString, this.b, paramInt2))
    {
      paramString = this.b;
      if ((paramString instanceof ETPaint)) {
        this.b = ((ETPaint)paramString).a();
      }
      return;
    }
    this.b = ((Paint)localObject);
    paramString = this.bw.getAttachedView();
    if (paramString != null) {
      paramString.post(new TextCellLayout.5(this, paramString));
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    Object localObject = this.br;
    if (localObject != null)
    {
      if (((ArrayList)localObject).isEmpty()) {
        return;
      }
      int i1 = 0;
      localObject = this.br.iterator();
      while (((Iterator)localObject).hasNext())
      {
        TextCellLayout.SideDrawable localSideDrawable = (TextCellLayout.SideDrawable)((Iterator)localObject).next();
        int i2 = (this.Z - localSideDrawable.c.height()) / 2;
        paramCanvas.translate(0.0F, i2);
        a(localSideDrawable);
        localSideDrawable.a.draw(paramCanvas);
        paramCanvas.translate(0.0F, -i2);
        i2 = localSideDrawable.c.width() + this.bv;
        paramCanvas.translate(i2, 0.0F);
        i1 += i2;
      }
      paramCanvas.translate(-i1, 0.0F);
    }
  }
  
  private void a(Canvas paramCanvas, TextCellLayout.MeasuredLine paramMeasuredLine)
  {
    int i1;
    if (this.az == 1)
    {
      i1 = paramMeasuredLine.a();
      i1 = (this.W - i1) / 2;
      paramMeasuredLine.d(i1);
      paramCanvas.translate(i1, 0.0F);
    }
    if ((this.f != null) && (paramMeasuredLine.b(0) != null))
    {
      Rect localRect = paramMeasuredLine.b(0);
      i1 = localRect.bottom - localRect.top;
      paramCanvas.translate(-ViewUtils.a(3.0F), 0.0F);
      paramMeasuredLine = new Rect(0, localRect.top + i1 / 4, paramMeasuredLine.a() + ViewUtils.a(6.0F), localRect.top + i1 * 3 / 4);
      this.f.setBounds(paramMeasuredLine);
      this.f.draw(paramCanvas);
      paramCanvas.translate(ViewUtils.a(3.0F), 0.0F);
    }
  }
  
  private void a(Typeface paramTypeface)
  {
    if (this.b.getTypeface() != paramTypeface)
    {
      this.b.setTypeface(paramTypeface);
      this.aV = paramTypeface;
      h();
    }
  }
  
  private void a(ReasignablePair<Integer, Integer> paramReasignablePair)
  {
    if (this.am == null) {
      return;
    }
    int i3 = this.R.size();
    int i1 = ((Integer)paramReasignablePair.a).intValue();
    TextCellLayout.MeasuredLine localMeasuredLine;
    TextCell localTextCell;
    while (i1 >= 0)
    {
      localMeasuredLine = (TextCellLayout.MeasuredLine)this.R.get(i1);
      i2 = localMeasuredLine.c() - 1;
      while (i2 >= 0)
      {
        localTextCell = localMeasuredLine.a(i2);
        if (this.am.linebreakSeq != localTextCell.linebreakSeq) {
          break;
        }
        localTextCell.isPresseding = true;
        this.ao.add(localTextCell);
        i2 -= 1;
      }
      i1 -= 1;
    }
    int i2 = ((Integer)paramReasignablePair.a).intValue();
    while (i2 < i3)
    {
      localMeasuredLine = (TextCellLayout.MeasuredLine)this.R.get(i2);
      int i4 = localMeasuredLine.c();
      if (i2 == ((Integer)paramReasignablePair.a).intValue()) {
        i1 = ((Integer)paramReasignablePair.b).intValue();
      } else {
        i1 = 0;
      }
      while (i1 < i4)
      {
        localTextCell = localMeasuredLine.a(i1);
        if (this.am.linebreakSeq != localTextCell.linebreakSeq) {
          break;
        }
        localTextCell.isPresseding = true;
        this.ao.add(localTextCell);
        i1 += 1;
      }
      i2 += 1;
    }
    this.bw.invalidate();
  }
  
  private void a(TextCell paramTextCell, MotionEvent paramMotionEvent)
  {
    if (paramTextCell != null)
    {
      paramTextCell.lastClickEvent = paramMotionEvent;
      paramTextCell.commentSpanHeight = this.L;
      paramTextCell.maxCommentHeight = this.M;
    }
    if ((paramTextCell != null) && (paramTextCell.type == 18))
    {
      if (this.aI == null)
      {
        this.aI = new InnerOperateTextCell(18, this.H);
        this.aI.setCanCopy(false);
        paramMotionEvent = this.aI;
        paramMotionEvent.useDefaultFont = true;
        paramMotionEvent.setFontSize(this.b, this.u);
      }
      this.aI.setDefaultShadowLayer(this.bb, this.bc, this.bd, this.be);
      this.aI.setLinkColor(this.af);
      if (!this.bf)
      {
        this.aI.setText(this.G);
        this.bf = true;
      }
      else
      {
        this.aI.setText(this.H);
        this.bf = false;
      }
      i();
      this.bw.requestLayout();
    }
    else if ((paramTextCell != null) && (paramTextCell.type == 10) && (this.N))
    {
      i();
      d(0);
      this.bw.invalidate();
      this.bw.requestLayout();
    }
    this.bw.a(paramTextCell);
  }
  
  private void a(TextCellLayout.MeasuredLine paramMeasuredLine, TextCell paramTextCell, float paramFloat)
  {
    int i1 = b(paramTextCell);
    int i2 = ((Integer)this.S.get(this.R.size() - 1)).intValue();
    if (i1 <= i2) {
      i1 = i2;
    }
    this.S.set(this.R.size() - 1, Integer.valueOf(i1));
    i2 = this.v;
    int i3 = this.w;
    Rect localRect = new Rect(i2, i3, (int)(i2 + paramFloat), i1 + i3);
    this.v = ((int)(this.v + paramFloat));
    i1 = this.v;
    i2 = this.W;
    if (i1 <= i2) {
      i1 = i2;
    }
    this.W = i1;
    paramMeasuredLine.a(paramTextCell, localRect);
  }
  
  private void a(TextCellLayout.SideDrawable paramSideDrawable)
  {
    if (!paramSideDrawable.a.getBounds().equals(paramSideDrawable.c)) {
      paramSideDrawable.a.setBounds(paramSideDrawable.c);
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    float f1 = this.ap;
    boolean bool2 = true;
    boolean bool1 = true;
    if (f1 >= 0.0F)
    {
      float f2 = this.aq;
      if (f2 < 0.0F) {
        return true;
      }
      if ((f1 - paramFloat1) * (f1 - paramFloat1) + (f2 - paramFloat2) * (f2 - paramFloat2) <= TouchAnalizer.a) {
        bool1 = false;
      }
      bool2 = bool1;
      if (bool1)
      {
        this.aq = -1.0F;
        this.ap = -1.0F;
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  private boolean a(float paramFloat1, float paramFloat2, Rect paramRect)
  {
    boolean bool2 = false;
    if (paramRect == null) {
      return false;
    }
    int i1 = paramRect.top;
    int i2 = paramRect.bottom;
    int i3 = paramRect.left;
    int i4 = paramRect.right;
    if (this.bG)
    {
      i2 = this.Z;
      i1 = 0;
    }
    float f1 = this.aJ * 4.0F;
    boolean bool1 = bool2;
    if (paramFloat1 >= i3 - f1)
    {
      bool1 = bool2;
      if (paramFloat1 <= i4 + f1)
      {
        bool1 = bool2;
        if (paramFloat2 >= i1 - f1)
        {
          bool1 = bool2;
          if (paramFloat2 <= i2 + f1) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean a(float paramFloat1, float paramFloat2, Rect paramRect, TextCell paramTextCell)
  {
    boolean bool2 = false;
    if (paramRect == null) {
      return false;
    }
    int i1 = paramRect.top;
    int i2 = paramRect.bottom;
    int i3 = paramRect.left;
    int i4 = paramRect.right;
    if (this.bG)
    {
      i2 = this.Z;
      if (!TextUtils.isEmpty(paramTextCell.getUrl())) {
        i1 = 0;
      } else {
        return false;
      }
    }
    float f1 = this.aJ * 4.0F;
    boolean bool1 = bool2;
    if (paramFloat1 >= i3 - f1)
    {
      bool1 = bool2;
      if (paramFloat1 <= i4 + f1)
      {
        bool1 = bool2;
        if (paramFloat2 >= i1 - f1)
        {
          bool1 = bool2;
          if (paramFloat2 <= i2 + f1) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean a(Bitmap paramBitmap, Canvas paramCanvas)
  {
    if (paramCanvas != null) {
      paramCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, null);
    }
    return true;
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    Object localObject = this.bu;
    boolean bool2 = false;
    boolean bool1 = false;
    if (localObject == null) {
      return false;
    }
    int i1 = paramMotionEvent.getAction();
    int i2;
    int i3;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3) {
            return false;
          }
          this.by = null;
          return false;
        }
        TextCellLayout.SideDrawable localSideDrawable = a(this.br, paramMotionEvent.getX(), paramMotionEvent.getY());
        localObject = localSideDrawable;
        if (localSideDrawable == null)
        {
          i1 = b(this.br);
          i2 = this.X;
          i3 = this.bv;
          localObject = a(this.bs, paramMotionEvent.getX() - (i1 + i2 + i3), paramMotionEvent.getY());
        }
        if (localObject == this.by) {
          bool1 = true;
        }
        return bool1;
      }
      paramMotionEvent = this.by;
      if (paramMotionEvent != null)
      {
        this.bu.a(paramMotionEvent.a, this.by.b);
        this.by = null;
        return true;
      }
      return false;
    }
    this.by = a(this.br, paramMotionEvent.getX(), paramMotionEvent.getY());
    if (this.by == null)
    {
      i1 = b(this.br);
      i2 = this.X;
      i3 = this.bv;
      this.by = a(this.bs, paramMotionEvent.getX() - (i1 + i2 + i3), paramMotionEvent.getY());
    }
    bool1 = bool2;
    if (this.by != null) {
      bool1 = true;
    }
    return bool1;
  }
  
  private char b(String paramString, int paramInt)
  {
    if ((paramInt >= 0) && (paramString != null) && (paramInt < paramString.length())) {
      return paramString.charAt(paramInt);
    }
    return '\000';
  }
  
  private int b(ArrayList<TextCellLayout.SideDrawable> paramArrayList)
  {
    int i2 = 0;
    int i1 = 0;
    if (paramArrayList != null)
    {
      if (paramArrayList.isEmpty()) {
        return 0;
      }
      paramArrayList = paramArrayList.iterator();
      for (;;)
      {
        i2 = i1;
        if (!paramArrayList.hasNext()) {
          break;
        }
        i1 += ((TextCellLayout.SideDrawable)paramArrayList.next()).c.width() + this.bv;
      }
    }
    return i2;
  }
  
  private ReasignablePair<Integer, Integer> b(float paramFloat1, float paramFloat2)
  {
    Object localObject = this.aD;
    Integer localInteger = Integer.valueOf(-1);
    if (localObject == null) {
      this.aD = new ReasignablePair(localInteger, localInteger);
    }
    int i3 = this.R.size();
    int i1 = 0;
    while (i1 < i3)
    {
      localObject = (TextCellLayout.MeasuredLine)this.R.get(i1);
      int i4 = ((TextCellLayout.MeasuredLine)localObject).c();
      int i2 = 0;
      while (i2 < i4)
      {
        if (a(paramFloat1, paramFloat2, ((TextCellLayout.MeasuredLine)localObject).b(i2), ((TextCellLayout.MeasuredLine)localObject).a(i2))) {
          return this.aD.a(Integer.valueOf(i1), Integer.valueOf(i2));
        }
        i2 += 1;
      }
      i1 += 1;
    }
    return this.aD.a(localInteger, localInteger);
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    if (this.R.size() < 2) {
      l(0);
    }
    Object localObject1 = this.R;
    TextCellLayout.MeasuredLine localMeasuredLine = (TextCellLayout.MeasuredLine)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 2);
    float f2 = c(this.aF) + this.bp;
    int i3 = (int)c(this.aG);
    float f1 = f2;
    if (paramBoolean) {
      f1 = f2 + i3;
    }
    this.v = 0;
    int i4 = localMeasuredLine.c();
    int i1 = 0;
    Object localObject2;
    int i2;
    while (i1 < i4)
    {
      localObject2 = localMeasuredLine.a(i1);
      int i5 = (int)(paramInt - f1 - this.v);
      if (i5 <= 0) {
        return;
      }
      localObject1 = a((TextCell)localObject2, i5);
      i2 = ((Integer)((ReasignablePair)localObject1).a).intValue();
      f2 = localMeasuredLine.b(i1).width();
      if (f2 <= i5)
      {
        this.v = ((int)(this.v + f2));
        i1 += 1;
      }
      else
      {
        if (((TextCell)localObject2).canBreak())
        {
          paramInt = i2;
          if (b(((TextCell)localObject2).text, i2 - 1) == '\n') {
            paramInt = i2 - 1;
          }
          Object localObject3;
          if ("...".equals(this.aE))
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(((TextCell)localObject2).text.substring(0, paramInt));
            ((StringBuilder)localObject3).append(this.aE);
            ((TextCell)localObject2).text = ((StringBuilder)localObject3).toString();
            localMeasuredLine.c(i1 + 1);
            this.v = ((int)(this.v + ((Float)((ReasignablePair)localObject1).b).floatValue()));
          }
          else
          {
            ((TextCell)localObject2).text = ((TextCell)localObject2).text.substring(0, paramInt);
            localMeasuredLine.c(i1 + 1);
            localMeasuredLine.b(localMeasuredLine.c() - 1).right = (this.v + ((Float)((ReasignablePair)localObject1).b).intValue());
            localObject2 = new Rect(localMeasuredLine.b(localMeasuredLine.c() - 1));
            localObject3 = localMeasuredLine.a(localMeasuredLine.c() - 1);
            if ((((TextCell)localObject3).canBreak()) && (((TextCell)localObject3).text.endsWith("\n"))) {
              ((TextCell)localObject3).text = ((TextCell)localObject3).text.substring(0, ((TextCell)localObject3).text.length() - 1);
            }
            ((Rect)localObject2).left = (this.v + ((Float)((ReasignablePair)localObject1).b).intValue());
            ((Rect)localObject2).right = (this.v + ((Float)((ReasignablePair)localObject1).b).intValue() + (int)f1);
            localMeasuredLine.a(this.aF, (Rect)localObject2);
          }
          if (paramBoolean)
          {
            localObject1 = localMeasuredLine.b(localMeasuredLine.c() - 1);
            ((Rect)localObject1).right -= i3;
          }
          paramInt = 1;
          break label561;
        }
        localMeasuredLine.c(i1);
      }
    }
    paramInt = 0;
    label561:
    this.v += (int)f1;
    if ((this.R.size() == 2) && (((TextCellLayout.MeasuredLine)this.R.get(1)).a(0) == null))
    {
      this.W = this.v;
      i1 = paramInt;
      if (paramInt == 0)
      {
        i1 = paramInt;
        if ("...".equals(this.aE))
        {
          localObject1 = localMeasuredLine.a(localMeasuredLine.c() - 1);
          i1 = paramInt;
          if (localObject1 != null)
          {
            i1 = paramInt;
            if (((TextCell)localObject1).canBreak())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(((TextCell)localObject1).text);
              ((StringBuilder)localObject2).append(this.aE);
              ((TextCell)localObject1).text = ((StringBuilder)localObject2).toString();
              i1 = 1;
            }
          }
        }
      }
    }
    else
    {
      i1 = this.v;
      i2 = this.W;
      if (i1 <= i2) {
        i1 = i2;
      }
      this.W = i1;
      i1 = paramInt;
    }
    localObject1 = new Rect(localMeasuredLine.b(localMeasuredLine.c() - 1));
    ((Rect)localObject1).left = ((Rect)localObject1).right;
    if (paramBoolean) {
      paramInt = (int)(((Rect)localObject1).left + c(this.aF));
    } else {
      paramInt = this.v;
    }
    ((Rect)localObject1).right = paramInt;
    if (i1 == 0)
    {
      localObject2 = localMeasuredLine.a(localMeasuredLine.c() - 1);
      if ((((TextCell)localObject2).canBreak()) && (((TextCell)localObject2).text.endsWith("\n"))) {
        ((TextCell)localObject2).text = ((TextCell)localObject2).text.substring(0, ((TextCell)localObject2).text.length() - 1);
      }
      localMeasuredLine.a(this.aF, (Rect)localObject1);
    }
    if (paramBoolean)
    {
      if (i1 == 0)
      {
        localObject1 = new Rect(localMeasuredLine.b(localMeasuredLine.c() - 1));
        ((Rect)localObject1).left = ((Rect)localObject1).right;
      }
      ((Rect)localObject1).right = (((Rect)localObject1).left + i3);
      localMeasuredLine.a(this.aG, (Rect)localObject1);
    }
  }
  
  private void b(Canvas paramCanvas)
  {
    Object localObject = this.bs;
    if (localObject != null)
    {
      if (((ArrayList)localObject).isEmpty()) {
        return;
      }
      int i1 = b(this.br) + this.X + this.bv;
      paramCanvas.translate(i1, 0.0F);
      localObject = this.bs.iterator();
      while (((Iterator)localObject).hasNext())
      {
        TextCellLayout.SideDrawable localSideDrawable = (TextCellLayout.SideDrawable)((Iterator)localObject).next();
        int i2 = (this.Z - localSideDrawable.c.height()) / 2;
        paramCanvas.translate(0.0F, i2);
        a(localSideDrawable);
        localSideDrawable.a.draw(paramCanvas);
        paramCanvas.translate(0.0F, -i2);
        i2 = localSideDrawable.c.width() + this.bv;
        paramCanvas.translate(i2, 0.0F);
        i1 += i2;
      }
      paramCanvas.translate(-i1, 0.0F);
    }
  }
  
  private boolean b(TextLayoutBase paramTextLayoutBase, Canvas paramCanvas)
  {
    boolean bool4 = F();
    Bitmap localBitmap = C();
    Object localObject1 = this.b;
    boolean bool3;
    if ((localObject1 instanceof ETPaint)) {
      bool3 = ((ETPaint)localObject1).a;
    } else {
      bool3 = true;
    }
    if ((paramCanvas != null) && (L()) && (!M()) && (this.aP != null)) {
      f(paramCanvas);
    }
    if (paramCanvas != null) {
      paramCanvas.translate(this.aK, this.aL);
    }
    if ((bool4) && (localBitmap != null) && (paramCanvas != null) && (bool3)) {
      return a(localBitmap, paramCanvas);
    }
    if ((paramCanvas == null) && (localBitmap != null) && (!this.o)) {
      return false;
    }
    if (bool4)
    {
      if (bool3)
      {
        localBitmap = E();
        if (localBitmap != null)
        {
          localObject1 = new Canvas(localBitmap);
          break label205;
        }
        this.bm = false;
        localObject1 = paramCanvas;
        bool4 = false;
        break label205;
      }
    }
    else if (localBitmap != null)
    {
      B();
      localObject1 = paramCanvas;
      localBitmap = null;
      break label205;
    }
    localObject1 = paramCanvas;
    label205:
    if ((paramCanvas == null) && (localObject1 == null)) {
      return false;
    }
    if ((L()) && (!M())) {
      d((Canvas)localObject1);
    }
    Object localObject2;
    if ((this.ah) && (paramTextLayoutBase.isPressed()))
    {
      if (this.az == 80)
      {
        i1 = this.Z;
        i1 = this.Y;
      }
      i1 = this.b.getColor();
      this.b.setColor(this.ai);
      localObject2 = this.b.getShader();
      this.b.setShader(null);
      ((Canvas)localObject1).drawRect(0.0F, 0.0F, this.W, this.Z, this.b);
      this.b.setShader((Shader)localObject2);
      this.b.setColor(i1);
    }
    a((Canvas)localObject1);
    b((Canvas)localObject1);
    if (this.az == 80) {
      ((Canvas)localObject1).translate(b(this.br), this.Z - this.Y);
    } else {
      ((Canvas)localObject1).translate(b(this.br), 0.0F);
    }
    int i5;
    if (this.bG)
    {
      i5 = (bX - this.t) / 2;
      ((Canvas)localObject1).save();
    }
    else
    {
      i5 = 0;
    }
    int i2 = this.R.size();
    int i3 = this.S.size();
    int i1 = 0;
    boolean bool1 = false;
    int i6;
    for (int i4 = 0; i4 < i2; i4 = i6 + 1)
    {
      localObject2 = (TextCellLayout.MeasuredLine)this.R.get(i4);
      int i7 = ((TextCellLayout.MeasuredLine)localObject2).c();
      a((Canvas)localObject1, (TextCellLayout.MeasuredLine)localObject2);
      int i8 = 0;
      i6 = i4;
      int i9;
      for (i4 = i8;; i4 = i9 + 1)
      {
        Object localObject3 = paramTextLayoutBase;
        if (i4 >= i7) {
          break;
        }
        TextCell localTextCell = ((TextCellLayout.MeasuredLine)localObject2).a(i4);
        Rect localRect = ((TextCellLayout.MeasuredLine)localObject2).b(i4);
        if (i6 < i3) {
          i8 = ((Integer)this.S.get(i6)).intValue();
        } else {
          i8 = TextCellHelper.a;
        }
        if ((localTextCell.isEmo()) && (!localTextCell.isDrawableLoaded)) {
          ((EmoCell)localTextCell).reloadDrawable((TextLayoutBase)localObject3, this.bF);
        } else if (((localTextCell instanceof SystemEmoCell)) && (!localTextCell.isDrawableLoaded)) {
          ((SystemEmoCell)localTextCell).reloadDrawable((TextLayoutBase)localObject3, this.bF);
        }
        i9 = i4;
        int i10;
        if (this.Q)
        {
          localObject3 = this.am;
          if ((localObject3 != null) && (!((TextCell)localObject3).canCopy()) && (this.am.type == 3))
          {
            if (localTextCell.linebreakSeq == this.am.linebreakSeq)
            {
              this.b.setColor(this.ag);
              this.al.set(localRect.left - this.aJ, localRect.top - this.aJ, localRect.right + this.aJ, localRect.top + i8 + this.aJ);
              localObject3 = this.b.getShader();
              this.b.setShader(null);
              ((Canvas)localObject1).drawRect(this.al, this.b);
              this.b.setShader((Shader)localObject3);
            }
            localObject3 = this.b;
            i4 = this.ad;
            i10 = this.af;
            localTextCell.draw((Canvas)localObject1, (Paint)localObject3, i8, localRect, i4, i10, localBitmap);
            if ((this.az == 1) && (((TextCellLayout.MeasuredLine)localObject2).b() != 0)) {
              ((Canvas)localObject1).translate(-((TextCellLayout.MeasuredLine)localObject2).b(), 0.0F);
            }
            continue;
          }
        }
        localObject3 = localObject2;
        i4 = i1;
        int i11;
        int i12;
        if (this.bG)
        {
          i4 = i1;
          if (!localTextCell.useDefaultFont)
          {
            i4 = i1;
            if (i1 == 0)
            {
              i4 = i1;
              if (TextUtils.isEmpty(localTextCell.getUrl()))
              {
                i4 = ca;
                i10 = bV * 2 + i4;
                i1 = i10;
                if (((Canvas)localObject1).getWidth() < localRect.left + i10)
                {
                  i4 = ((Canvas)localObject1).getWidth();
                  i10 = localRect.left;
                  i1 = bV;
                  i4 = i4 - i10 - i1 * 2;
                  i1 = i1 * 2 + i4;
                }
                i10 = localRect.left + i1 - bV;
                i11 = localRect.left - (this.X - localRect.left);
                if ((this.bS == null) || (this.bD != i10) || (this.bE != i11))
                {
                  this.bD = i10;
                  this.bE = i11;
                  this.bS = new TranslateAnimation(0, i10, 0, i11, 0, 0.0F, 0, 0.0F);
                  this.bS.setFillAfter(true);
                  this.bS.setRepeatCount(-1);
                  this.bS.setRepeatMode(1);
                  this.bS.setInterpolator(new LinearInterpolator());
                  this.bS.setDuration(2000L);
                  this.bS.setStartTime(0L);
                  this.bS.setAnimationListener(new TextCellLayout.3(this));
                }
                this.bS.initialize(this.X, 0, 0, 0);
                this.bS.setDuration((int)Math.max(Math.abs(i11 - i10) * 1000.0F / bZ, 1000.0F));
                if (this.bL == 1)
                {
                  if (this.bK == 0L) {
                    this.bK = System.currentTimeMillis();
                  }
                  if (System.currentTimeMillis() - this.bK > 1200L)
                  {
                    this.bK = System.currentTimeMillis();
                    this.bP ^= true;
                  }
                  if (this.bP)
                  {
                    localObject2 = this.bI;
                    if (localObject2 != null)
                    {
                      ((Drawable)localObject2).setBounds(localRect.left, 0, localRect.left + i1, bX);
                      this.bI.draw((Canvas)localObject1);
                    }
                  }
                  else
                  {
                    localObject2 = this.bJ;
                    if (localObject2 != null)
                    {
                      ((Drawable)localObject2).setBounds(localRect.left, 0, localRect.left + i1, bX);
                      this.bJ.draw((Canvas)localObject1);
                    }
                  }
                }
                else
                {
                  localObject2 = this.bI;
                  if (localObject2 != null)
                  {
                    ((Drawable)localObject2).setBounds(localRect.left, 0, localRect.left + i1, bX);
                    this.bI.draw((Canvas)localObject1);
                  }
                }
                if (this.bL == 2)
                {
                  if (this.bK == 0L) {
                    this.bK = System.currentTimeMillis();
                  }
                  if (System.currentTimeMillis() - this.bK > 2200L) {
                    this.cb = false;
                  }
                  if ((!this.cb) && (this.bJ != null))
                  {
                    ((Canvas)localObject1).translate(0.0F, i5);
                    localObject2 = this.bJ;
                    i10 = localRect.left;
                    i11 = localRect.left;
                    i12 = bY;
                    ((Drawable)localObject2).setBounds(i10, 0, i11 + i12 * 70 / 42, i12);
                    this.bJ.draw((Canvas)localObject1);
                    ((Canvas)localObject1).translate(0.0F, -i5);
                  }
                }
                if ((!TextUtils.isEmpty(this.bN)) && (this.bO > 0) && (this.bT != null))
                {
                  ((Canvas)localObject1).translate(this.aK, this.aL);
                  QCircleHostZipHelper.setBounds(this.bT, localRect.left, 0, localRect.left + i1, bX);
                  QCircleHostZipHelper.draw(this.bT, (Canvas)localObject1);
                  ((Canvas)localObject1).translate(-this.aK, -this.aL);
                }
                ((Canvas)localObject1).translate(bV, 0.0F);
                ((Canvas)localObject1).clipRect(localRect.left, 0, localRect.left + i4, bX);
                if ((this.bS.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.bA)) && (!this.bS.hasEnded()))
                {
                  if (this.bU == null) {
                    this.bU = new float[9];
                  }
                  this.bA.getMatrix().getValues(this.bU);
                  ((Canvas)localObject1).translate(this.bU[2] - localRect.left, 0.0F);
                  v();
                }
                i4 = 1;
              }
            }
          }
        }
        if (this.bG)
        {
          float f1 = i5;
          ((Canvas)localObject1).translate(0.0F, f1);
          i1 = this.bQ;
          this.ad = i1;
          if (this.bL == 1)
          {
            if (!this.bP) {
              i1 = this.bR;
            }
            this.ad = i1;
          }
          if (!TextUtils.isEmpty(localTextCell.getUrl()))
          {
            ((Canvas)localObject1).restore();
            ((Canvas)localObject1).translate(0.0F, f1);
            this.bH = true;
            i1 = localRect.right;
            i10 = localRect.left;
            i11 = ca;
            i12 = bV;
            localRect.right = (i1 - i10 + i11 + i12 * 2);
            localRect.left = (i11 + i12 * 2);
          }
        }
        if (((localTextCell.isPresseding) && (this.au)) || ((this.Q) && (localTextCell.canCopy())))
        {
          this.b.setColor(this.ag);
          this.al.set(localRect.left - this.aJ, localRect.top - this.aJ, localRect.right + this.aJ, localRect.top + i8 + this.aJ);
          localObject2 = this.b.getShader();
          this.b.setShader(null);
          ((Canvas)localObject1).drawRect(this.al, this.b);
          this.b.setShader((Shader)localObject2);
        }
        boolean bool2;
        if ((this.cb) && (this.bL == 2) && (!localTextCell.useDefaultFont) && (this.bJ != null) && (TextUtils.isEmpty(localTextCell.getUrl())))
        {
          localObject2 = this.bJ;
          i1 = localRect.left;
          i8 = localRect.left;
          i10 = bY;
          ((Drawable)localObject2).setBounds(i1, 0, i8 + i10 * 70 / 42, i10);
          this.bJ.draw((Canvas)localObject1);
          bool2 = bool1;
        }
        else
        {
          bool2 = this.bG;
          localTextCell.draw((Canvas)localObject1, this.b, i8, localRect, this.ad, this.af, localBitmap);
          bool2 = bool1;
          if (this.bG)
          {
            bool2 = bool1;
            if (i4 != 0) {
              bool2 = true;
            }
          }
        }
        i1 = i4;
        bool1 = bool2;
        localObject2 = localObject3;
        if (this.bG)
        {
          ((Canvas)localObject1).translate(0.0F, -i5);
          localObject2 = localObject3;
          bool1 = bool2;
          i1 = i4;
        }
      }
      if ((this.az == 1) && (((TextCellLayout.MeasuredLine)localObject2).b() != 0)) {
        ((Canvas)localObject1).translate(-((TextCellLayout.MeasuredLine)localObject2).b(), 0.0F);
      }
    }
    if (this.bG) {
      ((Canvas)localObject1).restore();
    }
    if (this.az == 80) {
      ((Canvas)localObject1).translate(-(this.aK + b(this.br)), -this.aL - this.Z + this.Y);
    } else {
      ((Canvas)localObject1).translate(-(this.aK + b(this.br)), -this.aL);
    }
    if ((bool4) && (paramCanvas != null) && (bool3)) {
      a(localBitmap, paramCanvas);
    }
    this.o = false;
    return true;
  }
  
  private int c(String paramString, int paramInt)
  {
    int i2 = paramInt - 1;
    if (b(paramString, i2) == '\n') {
      return paramInt;
    }
    char c1 = b(paramString, i2 + 1);
    int i1;
    if (!a(c1))
    {
      i1 = i2;
      if (!b(c1)) {}
    }
    else
    {
      paramInt = e(paramString, i2);
      i1 = paramInt - 1;
    }
    if ((c(b(paramString, i1))) && (c(b(paramString, i1 + 1)))) {
      return a(paramString, i1);
    }
    i1 += 1;
    if ((b(paramString, i1) != ' ') && (b(paramString, i1) != '\n')) {
      return paramInt;
    }
    return paramInt + 1;
  }
  
  private boolean c(char paramChar)
  {
    return ((paramChar >= 'a') && (paramChar <= 'z')) || ((paramChar >= 'A') && (paramChar <= 'Z')) || ((paramChar >= '0') && (paramChar <= '9')) || (paramChar == '\'') || (paramChar == ';') || (paramChar == ',') || (paramChar == '.') || (paramChar == '?') || (paramChar == '!') || (paramChar == '"') || (paramChar == '_') || (paramChar == '-') || (paramChar == ':') || (paramChar == '@');
  }
  
  private boolean c(Canvas paramCanvas)
  {
    if (this.n != null)
    {
      if (this.m == null) {
        return false;
      }
      if (this.i)
      {
        int i1 = J();
        int i2 = this.aK;
        int i3 = this.aL;
        if (K().booleanValue()) {
          f(paramCanvas);
        }
        Bitmap localBitmap = r();
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          paramCanvas.drawBitmap(localBitmap, i2 + i1, i3, null);
          return i1 <= 0;
        }
      }
    }
    return false;
  }
  
  private boolean c(TextLayoutBase paramTextLayoutBase, Canvas paramCanvas)
  {
    boolean bool2 = F();
    Bitmap localBitmap = C();
    if ((bool2) && (localBitmap != null) && (paramCanvas != null)) {
      return a(localBitmap, paramCanvas);
    }
    if ((paramCanvas == null) && (localBitmap != null) && (!this.o)) {
      return false;
    }
    Canvas localCanvas;
    if (bool2)
    {
      localBitmap = E();
      if (localBitmap != null)
      {
        localCanvas = new Canvas(localBitmap);
      }
      else
      {
        this.bm = false;
        localCanvas = paramCanvas;
        bool2 = false;
      }
    }
    else if (localBitmap != null)
    {
      B();
      localCanvas = paramCanvas;
      localBitmap = null;
    }
    else
    {
      localCanvas = paramCanvas;
    }
    if ((paramCanvas == null) && (localCanvas == null)) {
      return false;
    }
    localCanvas.translate(this.aK, this.aL);
    a(localCanvas);
    b(localCanvas);
    if (this.az == 80) {
      localCanvas.translate(b(this.br), this.Z - this.Y);
    } else {
      localCanvas.translate(b(this.br), 0.0F);
    }
    if ((this.ah) && (paramTextLayoutBase.isPressed()))
    {
      i1 = this.b.getColor();
      this.b.setColor(this.ai);
      localObject = this.b.getShader();
      this.b.setShader(null);
      localCanvas.drawRect(0.0F, 0.0F, this.W, this.Z, this.b);
      this.b.setShader((Shader)localObject);
      this.b.setColor(i1);
    }
    int i7 = this.R.size();
    Object localObject = this.S;
    int i2;
    if (localObject != null) {
      i2 = ((ArrayList)localObject).size();
    } else {
      i2 = 0;
    }
    long l1 = System.currentTimeMillis();
    boolean bool1 = false;
    int i3 = 0;
    int i4;
    for (int i1 = 0; i1 < i7; i1 = i4)
    {
      localObject = (TextCellLayout.MeasuredLine)this.R.get(i1);
      int i5 = ((TextCellLayout.MeasuredLine)localObject).c();
      if (this.az == 1)
      {
        i4 = ((TextCellLayout.MeasuredLine)localObject).a();
        i4 = (this.W - i4) / 2;
        ((TextCellLayout.MeasuredLine)localObject).d(i4);
        localCanvas.translate(i4, 0.0F);
      }
      int i6 = 0;
      i4 = i1;
      for (;;)
      {
        TextLayoutBase localTextLayoutBase = paramTextLayoutBase;
        if (i6 >= i5) {
          break;
        }
        TextCell localTextCell = ((TextCellLayout.MeasuredLine)localObject).a(i6);
        Rect localRect = ((TextCellLayout.MeasuredLine)localObject).b(i6);
        ArrayList localArrayList = this.S;
        if ((localArrayList != null) && (i4 < i2)) {
          i1 = ((Integer)localArrayList.get(i4)).intValue();
        } else {
          i1 = TextCellHelper.a;
        }
        if ((localTextCell.isEmo()) && (!localTextCell.isDrawableLoaded)) {
          ((EmoCell)localTextCell).reloadDrawable(localTextLayoutBase, this.bF);
        } else if (((localTextCell instanceof SystemEmoCell)) && (!localTextCell.isDrawableLoaded)) {
          ((SystemEmoCell)localTextCell).reloadDrawable(localTextLayoutBase, this.bF);
        }
        if (!this.aS) {
          bool1 = localTextCell.fadedDraw(localCanvas, this.b, i1, localRect, this.ad, this.af, localBitmap, i3, this.aR - this.aQ);
        } else {
          bool1 = localTextCell.fadedDraw(localCanvas, this.b, i1, localRect, this.ad, this.af, localBitmap, i3, l1 - this.aQ);
        }
        if ((!(localTextCell instanceof ImageCell)) && (!(localTextCell instanceof EmoCell))) {
          i1 = i3 + localTextCell.getDrawTextLength();
        } else {
          i1 = i3 + 1;
        }
        if (bool1) {
          break label689;
        }
        i6 += 1;
        i3 = i1;
      }
      i1 = i3;
      label689:
      if ((this.az == 1) && (((TextCellLayout.MeasuredLine)localObject).b() != 0)) {
        localCanvas.translate(-((TextCellLayout.MeasuredLine)localObject).b(), 0.0F);
      }
      i4 += 1;
      i3 = i1;
    }
    paramTextLayoutBase = this.d;
    if (paramTextLayoutBase != null) {
      if (!this.aS) {
        paramTextLayoutBase.a(this.aR - this.aQ);
      } else {
        paramTextLayoutBase.a(l1 - this.aQ);
      }
    }
    if (!bool1) {
      m(false);
    }
    if (this.az == 80) {
      localCanvas.translate(-(this.aK + b(this.br)), -this.aL - this.Z + this.Y);
    } else {
      localCanvas.translate(-(this.aK + b(this.br)), -this.aL);
    }
    if ((bool2) && (paramCanvas != null)) {
      a(localBitmap, paramCanvas);
    }
    this.o = false;
    return true;
  }
  
  private Animatable d(String paramString, int paramInt)
  {
    return QCircleHostZipHelper.createZipAnimationDrawable(paramString, paramInt, this.bC);
  }
  
  private void d(float paramFloat)
  {
    this.b.setTextSize(paramFloat);
    Paint.FontMetrics localFontMetrics = this.b.getFontMetrics();
    this.t = ((int)Math.ceil(localFontMetrics.descent - localFontMetrics.top));
  }
  
  private void d(Canvas paramCanvas)
  {
    Object localObject1 = this.n;
    if (localObject1 != null)
    {
      if (this.m == null) {
        return;
      }
      ((ETTextLayout)localObject1).b();
      int i4 = this.aK;
      int i3 = this.aL;
      Object localObject2 = r();
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (!((Bitmap)localObject2).isRecycled()) {}
      }
      else
      {
        localObject2 = s();
        localObject1 = localObject2;
        if (localObject2 == null) {
          return;
        }
      }
      localObject2 = this.m.getMargins();
      int i2 = i4;
      int i1 = i3;
      if (localObject2 != null)
      {
        i2 = i4 + ((Rect)localObject2).left;
        i1 = i3 + ((Rect)localObject2).top;
      }
      ((Bitmap)localObject1).eraseColor(0);
      localObject2 = this.b;
      if ((localObject2 instanceof ETPaint)) {
        localObject2 = (ETPaint)localObject2;
      } else {
        localObject2 = null;
      }
      if (localObject2 != null)
      {
        this.m.drawBackgroundSpace((Bitmap)localObject1, ((ETPaint)localObject2).c(), i2, i1);
        paramCanvas.drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, null);
      }
    }
  }
  
  private int e(String paramString, int paramInt)
  {
    int i1 = paramInt;
    while (i1 >= 0)
    {
      char c1 = paramString.charAt(i1);
      if ((!b(c1)) && (!a(c1)) && (c1 != ' ')) {
        return i1;
      }
      i1 -= 1;
    }
    return paramInt + 1;
  }
  
  private boolean e(Canvas paramCanvas)
  {
    Object localObject = this.n;
    if ((localObject != null) && (this.m != null) && (this.i))
    {
      int i1 = ((ETTextLayout)localObject).e();
      int i2 = this.aK;
      int i3 = this.n.f();
      int i4 = this.aL;
      localObject = r();
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        paramCanvas.drawBitmap((Bitmap)localObject, i1 + i2, i3 + i4, null);
      }
      return false;
    }
    return true;
  }
  
  private void f(Canvas paramCanvas)
  {
    if ((paramCanvas != null) && (this.aP != null) && (K().booleanValue()))
    {
      Object localObject = r();
      int i2 = this.aK + this.X + this.aM;
      int i3 = this.Y;
      int i1;
      if (this.aI == null)
      {
        i1 = i3;
        if (this.aH == null) {}
      }
      else
      {
        ArrayList localArrayList = this.S;
        i1 = i3 - ((Integer)localArrayList.get(localArrayList.size() - 1)).intValue();
      }
      if (localObject != null) {
        i2 = this.aK + this.aM + ((Bitmap)localObject).getWidth();
      }
      localObject = new Rect(0, 0, i2, i1);
      this.aP.setBounds((Rect)localObject);
      this.aP.draw(paramCanvas);
    }
  }
  
  private boolean k(int paramInt)
  {
    Integer localInteger = Integer.valueOf(0);
    this.y = 0;
    this.W = 0;
    this.R.clear();
    this.S.clear();
    Object localObject1 = new TextCellLayout.MeasuredLine();
    this.R.add(localObject1);
    int i6 = 0;
    while (i6 < this.P.size())
    {
      TextCell localTextCell2 = (TextCell)this.P.get(i6);
      localTextCell2.text = EmotcationUtils.a(localTextCell2.text);
      int i8 = b(localTextCell2);
      if (this.S.isEmpty()) {
        this.S.add(localInteger);
      }
      if (localTextCell2.isEmo()) {
        EmoObjectPool.a().a((EmoCell)localTextCell2, this.bw, this.bF);
      }
      if (localTextCell2.cellIndex == 0) {
        this.y += 1048576;
      }
      TextCell localTextCell1 = localTextCell2;
      Object localObject2;
      for (;;)
      {
        localObject2 = localObject1;
        if (localTextCell1 == null) {
          break label838;
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty(localTextCell1.getText())) {
          break label838;
        }
        localTextCell1.linebreakSeq = this.y;
        int i1;
        if (((this.C != 0) && (this.R.size() > this.D)) || ((this.C == 0) && (this.B > 0) && (this.R.size() > this.B)))
        {
          paramInt = this.S.size() - 1;
          i1 = ((Integer)this.S.get(paramInt)).intValue();
          this.S.set(paramInt, Integer.valueOf(i1 - this.x));
          return false;
        }
        int i4 = paramInt - this.v;
        localObject2 = a(localTextCell1, i4);
        int i2 = ((Integer)((ReasignablePair)localObject2).a).intValue();
        float f1 = ((Float)((ReasignablePair)localObject2).b).floatValue();
        int i3;
        label628:
        float f2;
        int i7;
        if (this.aA)
        {
          i3 = c(localTextCell1.getText(), i2);
          if ((QCircleConfigHelper.a("QZoneTextCellSetting", "emojiShouldNotBreak", localInteger).intValue() == 0) && (this.v != 0))
          {
            i5 = ((TextCellLayout.MeasuredLine)localObject1).c();
            if (i5 > 1)
            {
              char c1 = b(localTextCell1.getText(), i3);
              localObject2 = localTextCell1.getText();
              if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).startsWith("\n"))) {
                i1 = 1;
              } else {
                i1 = 0;
              }
              if ((i1 == 0) && ((a(c1)) || (b(c1))))
              {
                i1 = i5 - 1;
                TextCell localTextCell3 = ((TextCellLayout.MeasuredLine)localObject1).a(i1);
                if ((localTextCell3 != null) && ((localTextCell3.isEmo()) || ((localTextCell3 instanceof SystemEmoCell))))
                {
                  ((TextCellLayout.MeasuredLine)localObject1).c(i1);
                  localObject2 = l(i8);
                  localObject1 = a(localTextCell3, i4);
                  a(localTextCell3, ((Integer)((ReasignablePair)localObject1).a).intValue(), (TextCellLayout.MeasuredLine)localObject2, ((Float)((ReasignablePair)localObject1).b).floatValue(), i4);
                  i4 = paramInt - this.v;
                  localObject1 = a(localTextCell1, i4);
                  i5 = ((Integer)((ReasignablePair)localObject1).a).intValue();
                  f1 = ((Float)((ReasignablePair)localObject1).b).floatValue();
                  i3 = c(localTextCell1.getText(), i5);
                  break label628;
                }
              }
            }
          }
          localObject2 = localObject1;
          int i5 = i2;
          f2 = f1;
          i2 = i3;
          i7 = i4;
          i1 = i5;
          localObject1 = localObject2;
          if (this.v != 0)
          {
            f2 = f1;
            i2 = i3;
            i7 = i4;
            i1 = i5;
            localObject1 = localObject2;
            if (i3 == 0)
            {
              i1 = 0;
              f2 = f1;
              i2 = i3;
              i7 = i4;
              localObject1 = localObject2;
            }
          }
        }
        else
        {
          i1 = i2;
          i7 = i4;
          f2 = f1;
        }
        if ((i2 != 0) && (i2 != i1)) {
          i3 = 1;
        } else {
          i3 = 0;
        }
        if (i3 != 0) {
          i1 = i2;
        }
        if (i3 != 0) {
          f2 = 0.0F;
        }
        localTextCell1 = a(localTextCell1, i1, (TextCellLayout.MeasuredLine)localObject1, f2, i7);
        if ((localTextCell1 == null) || (TextUtils.isEmpty(localTextCell1.getText()))) {
          break;
        }
        localObject1 = l(i8);
      }
      if ((localTextCell1 == null) && (b(localTextCell2.getText(), localTextCell2.getLength() - 1) == '\n')) {
        localObject2 = l(i8);
      } else {
        localObject2 = localObject1;
      }
      label838:
      i6 += 1;
      localObject1 = localObject2;
    }
    return true;
  }
  
  private TextCellLayout.MeasuredLine l(int paramInt)
  {
    this.v = 0;
    int i1 = this.R.size();
    if (i1 > 0) {
      paramInt = ((Integer)this.S.get(i1 - 1)).intValue();
    }
    this.w += this.x + paramInt;
    TextCellLayout.MeasuredLine localMeasuredLine = new TextCellLayout.MeasuredLine();
    this.R.add(localMeasuredLine);
    this.S.add(Integer.valueOf(0));
    return localMeasuredLine;
  }
  
  private void m(int paramInt)
  {
    this.w = (this.w - ((Integer)this.S.get(paramInt)).intValue() - this.x);
    this.R.remove(paramInt);
    this.S.remove(paramInt);
  }
  
  private void n(int paramInt)
  {
    this.S.clear();
    int i4 = 0;
    this.v = 0;
    this.w = this.x;
    if (this.P == null) {
      return;
    }
    if (this.c == 1) {
      b(t());
    } else {
      b(this.u);
    }
    this.b.setTypeface(this.aU);
    Object localObject1 = this.P.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (TextCell)((Iterator)localObject1).next();
      ((TextCell)localObject2).setDefaultShadowLayer(this.bb, this.bc, this.bd, this.be);
      ((TextCell)localObject2).setLinkColor(this.af);
      ((TextCell)localObject2).setFontSize(this.b, this.u);
    }
    int i1 = paramInt;
    if (L())
    {
      i1 = paramInt;
      if (!M())
      {
        localObject2 = ETSpace.a().c();
        localObject1 = this.b;
        if ((localObject1 instanceof ETPaint)) {
          localObject1 = (ETPaint)localObject1;
        } else {
          localObject1 = null;
        }
        if ((this.bj == null) && (localObject2 != null) && (localObject1 != null)) {
          this.bj = Integer.valueOf(((IETEngine)localObject2).nativeGetHorizontalMarginThreshold(((ETPaint)localObject1).c(), paramInt));
        }
        if (this.bj == null) {
          this.bj = Integer.valueOf(0);
        }
        i1 = paramInt - this.bj.intValue();
      }
    }
    if (this.C < 0) {
      this.C = 1;
    }
    paramInt = 20;
    int i2 = 8;
    int i5 = this.c;
    int i3 = 5;
    if (i5 == 1)
    {
      paramInt = 10;
      i2 = 5;
    }
    else
    {
      i3 = 10;
    }
    if (this.C != 0)
    {
      this.D = paramInt;
      this.E = i3;
      this.F = i2;
    }
    boolean bool = k(i1);
    if ((this.ay) && (bool)) {
      l(0);
    }
    this.L = 0;
    this.M = 0;
    if ((this.K > 0) && (this.R.size() > this.K))
    {
      paramInt = this.R.size();
      i2 = this.K;
      if ((paramInt > i2 + 1) || (((Integer)this.S.get(i2)).intValue() > 0))
      {
        paramInt = this.R.size() - 1;
        while (paramInt >= this.K)
        {
          this.L += this.x;
          this.L += ((Integer)this.S.get(paramInt)).intValue();
          m(paramInt);
          paramInt -= 1;
        }
        if (((Integer)this.S.get(this.R.size() - 1)).intValue() > 0) {
          l(0);
        }
        b(i1, true);
        paramInt = i4;
        for (;;)
        {
          i1 = this.K;
          if (paramInt >= i1 - 1) {
            break;
          }
          this.M += ((Integer)this.S.get(paramInt)).intValue();
          this.M += this.x;
          paramInt += 1;
        }
        this.M += ((Integer)this.S.get(i1 - 1)).intValue() / 2;
        bool = this.N;
        return;
      }
    }
    if (this.C != 0) {
      if ((bool) && (!this.ay))
      {
        if ((this.R.size() > this.E) && (this.R.size() <= this.D))
        {
          l(0);
          if (!this.bf)
          {
            paramInt = this.R.size() - 1;
            while (paramInt >= this.F)
            {
              m(paramInt);
              paramInt -= 1;
            }
            this.w -= this.x;
          }
        }
      }
      else
      {
        paramInt = this.R.size() - 1;
        while (paramInt >= this.F)
        {
          m(paramInt);
          paramInt -= 1;
        }
        paramInt = this.w;
        localObject1 = this.S;
        this.w = (paramInt - ((Integer)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 1)).intValue() - this.x);
        l(0);
      }
    }
  }
  
  private boolean n(boolean paramBoolean)
  {
    if (!L()) {
      return false;
    }
    IETEngine localIETEngine = ETSpace.a().c();
    Object localObject = this.b;
    if ((localObject instanceof ETPaint)) {
      localObject = (ETPaint)localObject;
    } else {
      localObject = null;
    }
    if (localIETEngine != null)
    {
      if (localObject == null) {
        return false;
      }
      if (this.n == null) {
        this.n = new ETTextLayout();
      }
      if (this.l == null) {
        this.l = new ETAnimator(this, Looper.getMainLooper());
      }
      int i1 = this.X;
      paramBoolean = this.n.a(this.R, i1, this.Y - this.aL - this.aN, i1, this.bh, paramBoolean, M() ^ true, QCircleHostFontHelper.createETFont(((ETPaint)localObject).c()));
      localObject = this.m;
      if (localObject == null)
      {
        this.m = this.n.a(localIETEngine, false);
        return paramBoolean;
      }
      if (paramBoolean)
      {
        ((IETDecoration)localObject).deleteDescriptor();
        this.m = this.n.a(localIETEngine, false);
      }
      return paramBoolean;
    }
    return false;
  }
  
  public void a(float paramFloat)
  {
    this.u = paramFloat;
    b(paramFloat);
    h();
  }
  
  public void a(int paramInt)
  {
    if (paramInt != 0)
    {
      this.f = QCircleApplication.APP.getResources().getDrawable(paramInt);
      return;
    }
    this.f = null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    try
    {
      this.q = true;
      this.bj = null;
      b(paramInt1, paramInt2);
      if (L())
      {
        if (M())
        {
          n(false);
        }
        else
        {
          n(true);
          if (this.m == null)
          {
            this.bj = Integer.valueOf(0);
            this.T = true;
            b(paramInt1, paramInt2);
            n(false);
          }
        }
        if (!this.i) {
          l();
        }
      }
      this.q = false;
      if ((F()) && (!L())) {
        a(this.bw, null);
      }
      return;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.aK = paramInt1;
    this.aL = paramInt2;
    this.aM = paramInt3;
    this.aN = paramInt4;
  }
  
  public void a(int paramInt, String paramString)
  {
    Paint localPaint = this.b;
    if ((localPaint instanceof ETPaint)) {
      this.b = ((ETPaint)localPaint).a();
    }
    if (TextUtils.isEmpty(paramString))
    {
      this.aT = 0;
      this.aU = this.aV;
      return;
    }
    if (this.aT == paramInt) {
      return;
    }
    this.aT = paramInt;
    if (this.cc == null) {
      this.cc = new TextCellLayout.4(this, paramInt);
    }
    paramString = QzoneFontManager.a().a(paramInt, paramString, this.cc);
    if (paramString != null) {
      this.aU = paramString;
    }
  }
  
  public void a(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    if (!FontManager.a(paramInt2)) {
      return;
    }
    this.bi = paramInt2;
    if ((paramInt2 != 1) && (paramInt2 != 2))
    {
      if ((paramInt2 != 3) && (paramInt2 != 4))
      {
        x();
        return;
      }
      b(paramInt1, paramString1, paramInt2, paramString2);
      if ((!M()) && (!TextUtils.isEmpty(paramString2))) {
        a(39, 39, 39, 39);
      }
    }
    else
    {
      a(paramInt1, paramString1);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.K = paramInt;
    this.N = paramBoolean;
    h();
  }
  
  public void a(long paramLong)
  {
    Object localObject = this.bw;
    if (localObject != null)
    {
      localObject = ((TextLayoutBase)localObject).getAttachedView();
      if (localObject != null) {
        ((View)localObject).postInvalidateDelayed(paramLong);
      }
    }
  }
  
  public void a(ColorStateList paramColorStateList)
  {
    this.aj = paramColorStateList;
  }
  
  public void a(Typeface paramTypeface, int paramInt)
  {
    float f1 = 0.0F;
    boolean bool = false;
    if (paramInt > 0)
    {
      if (paramTypeface == null) {
        paramTypeface = Typeface.defaultFromStyle(paramInt);
      } else {
        paramTypeface = Typeface.create(paramTypeface, paramInt);
      }
      a(paramTypeface);
      int i1;
      if (paramTypeface != null) {
        i1 = paramTypeface.getStyle();
      } else {
        i1 = 0;
      }
      paramInt = (i1 ^ 0xFFFFFFFF) & paramInt;
      paramTypeface = this.b;
      if ((paramInt & 0x1) != 0) {
        bool = true;
      }
      paramTypeface.setFakeBoldText(bool);
      paramTypeface = this.b;
      if ((paramInt & 0x2) != 0) {
        f1 = -0.25F;
      }
      paramTypeface.setTextSkewX(f1);
      return;
    }
    this.b.setFakeBoldText(false);
    this.b.setTextSkewX(0.0F);
    a(paramTypeface);
  }
  
  public void a(TextCell paramTextCell)
  {
    this.P = new ArrayList();
    this.P.add(paramTextCell);
    h();
  }
  
  public void a(TextCellLayout.OnCellClickListener paramOnCellClickListener)
  {
    this.at = paramOnCellClickListener;
  }
  
  public void a(TextCellLayout.OnSideDrawableClickListener paramOnSideDrawableClickListener)
  {
    this.bu = paramOnSideDrawableClickListener;
  }
  
  public void a(TextLayoutBase paramTextLayoutBase)
  {
    this.bw = paramTextLayoutBase;
  }
  
  public void a(ImageLoader.ImageLoadListener paramImageLoadListener)
  {
    this.bF = paramImageLoadListener;
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.aE = paramString;
    this.aF = new TextCell(0, paramString);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (paramString != null)
    {
      localObject = Typeface.create(paramString, paramInt2);
      paramString = (String)localObject;
      if (localObject != null) {
        a((Typeface)localObject);
      }
    }
    else
    {
      paramString = null;
    }
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 == 3) {
          paramString = Typeface.MONOSPACE;
        }
      }
      else {
        paramString = Typeface.SERIF;
      }
    }
    else {
      paramString = Typeface.SANS_SERIF;
    }
    if (paramString != Typeface.DEFAULT)
    {
      localObject = paramString;
      if (paramString != null) {}
    }
    else
    {
      localObject = HostStaticInvokeHelper.getSystemDefaultFont();
    }
    a((Typeface)localObject, paramInt2);
  }
  
  public void a(ArrayList<TextCell> paramArrayList)
  {
    this.P = paramArrayList;
    h();
  }
  
  public void a(ArrayList<Integer> paramArrayList, int paramInt)
  {
    TextColorAnimation localTextColorAnimation = this.e;
    if (localTextColorAnimation != null) {
      localTextColorAnimation.cancel();
    }
    if ((paramArrayList != null) && (paramArrayList.size() >= 2) && (paramInt > 0))
    {
      this.e = new TextColorAnimation(this, paramArrayList);
      this.e.setFillAfter(true);
      this.e.setRepeatCount(-1);
      this.e.setRepeatMode(2);
      this.e.setInterpolator(new LinearInterpolator());
      this.e.setDuration(paramInt);
      this.e.setStartTime(0L);
      return;
    }
    this.e = null;
  }
  
  public void a(boolean paramBoolean)
  {
    this.ah = paramBoolean;
  }
  
  public void a(boolean paramBoolean, QzoneBarrageEffectData.BarrageEffectInfo paramBarrageEffectInfo)
  {
    Object localObject = Integer.valueOf(-1);
    if (!paramBoolean)
    {
      this.bG = false;
      this.bI = null;
      this.bQ = 0;
      this.bS = null;
      this.bT = null;
      this.bM = ((Integer)localObject);
      this.bO = -1;
      this.bN = null;
      return;
    }
    this.bG = true;
    this.bL = paramBarrageEffectInfo.m;
    if (paramBarrageEffectInfo.m == 0)
    {
      localObject = paramBarrageEffectInfo.k;
      this.bQ = QzoneBarrageEffectData.BarrageEffectInfo.a(paramBarrageEffectInfo.j);
      this.bO = paramBarrageEffectInfo.p;
      this.bN = paramBarrageEffectInfo.o;
      this.bM = Integer.valueOf(paramBarrageEffectInfo.i);
      if ((this.bO > 0) && (!TextUtils.isEmpty(this.bN)))
      {
        paramBarrageEffectInfo = this.bT;
        if (paramBarrageEffectInfo != null)
        {
          paramBarrageEffectInfo.stop();
          QCircleHostZipHelper.release(this.bT);
        }
        this.bT = d(this.bN, this.bO);
      }
    }
    else
    {
      if (paramBarrageEffectInfo.m == 1)
      {
        localObject = paramBarrageEffectInfo.n.strAndUrl1;
        localObject = paramBarrageEffectInfo.n.strAndUrl2;
        this.bQ = QzoneBarrageEffectData.BarrageEffectInfo.a(paramBarrageEffectInfo.n.strTextColor1);
        this.bR = QzoneBarrageEffectData.BarrageEffectInfo.a(paramBarrageEffectInfo.n.strTextColor2);
        this.bT = null;
        this.bN = null;
        return;
      }
      if (paramBarrageEffectInfo.m != 2) {
        break label295;
      }
      localObject = paramBarrageEffectInfo.n.strAndUrl1;
      localObject = paramBarrageEffectInfo.n.strAndUrl2;
      this.bQ = QzoneBarrageEffectData.BarrageEffectInfo.a(paramBarrageEffectInfo.n.strTextColor1);
      this.bR = QzoneBarrageEffectData.BarrageEffectInfo.a(paramBarrageEffectInfo.n.strTextColor2);
      this.bT = null;
      this.bN = null;
    }
    return;
    label295:
    this.bG = false;
    this.bI = null;
    this.bQ = 0;
    this.bS = null;
    this.bT = null;
    this.bM = ((Integer)localObject);
    this.bO = -1;
    this.bN = null;
  }
  
  public void a(int[] paramArrayOfInt, float[] paramArrayOfFloat, GradientDrawable.Orientation paramOrientation)
  {
    this.aW = null;
    this.aX = paramArrayOfInt;
    this.aY = paramArrayOfFloat;
    this.aZ = paramOrientation;
  }
  
  public boolean a()
  {
    Object localObject = this.bw;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = ((TextLayoutBase)localObject).getAttachedView();
      bool1 = bool2;
      if (localObject != null)
      {
        int[] arrayOfInt = new int[2];
        ((View)localObject).getLocationOnScreen(arrayOfInt);
        int i1 = ((View)localObject).getHeight();
        bool1 = bool2;
        if (arrayOfInt[1] + i1 > ViewUtils.a(50.0F))
        {
          bool1 = bool2;
          if (arrayOfInt[1] < BaseConfig.getScreenHeight() + ViewUtils.a()) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean a(char paramChar)
  {
    Character.UnicodeBlock localUnicodeBlock = Character.UnicodeBlock.of(paramChar);
    if ((localUnicodeBlock != Character.UnicodeBlock.GENERAL_PUNCTUATION) && (localUnicodeBlock != Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) && (localUnicodeBlock != Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS))
    {
      if (localUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS) {
        return true;
      }
      return (Build.VERSION.SDK_INT >= 19) && (localUnicodeBlock == Character.UnicodeBlock.VERTICAL_FORMS);
    }
    return true;
  }
  
  public boolean a(MotionEvent paramMotionEvent, Handler paramHandler)
  {
    paramMotionEvent.offsetLocation(this.aK, 0.0F);
    if (a(paramMotionEvent)) {
      return true;
    }
    paramMotionEvent.offsetLocation(b(this.br), 0.0F);
    if (paramMotionEvent.getAction() == 0)
    {
      this.o = true;
      p();
      this.ap = paramMotionEvent.getX();
      this.aq = paramMotionEvent.getY();
      if ((this.as) && (!paramHandler.hasMessages(0)))
      {
        this.bw.setLongClickTrig(false);
        this.bw.b();
      }
      if (this.au)
      {
        paramMotionEvent = b(paramMotionEvent.getX(), paramMotionEvent.getY());
        if (((Integer)paramMotionEvent.a).intValue() != -1)
        {
          this.an = paramMotionEvent;
          TextCell localTextCell = ((TextCellLayout.MeasuredLine)this.R.get(((Integer)paramMotionEvent.a).intValue())).a(((Integer)paramMotionEvent.b).intValue());
          if (((!this.bG) || (localTextCell.useDefaultFont) || (this.bH)) && (localTextCell.clickable()))
          {
            this.an = paramMotionEvent;
            this.am = localTextCell;
            a(this.an);
            return true;
          }
        }
      }
      if (this.ar)
      {
        this.bw.setPressed(true);
        this.bw.invalidate();
        return true;
      }
      if (!this.as)
      {
        paramHandler.removeMessages(0);
        return false;
      }
      return true;
    }
    if (paramMotionEvent.getAction() == 2)
    {
      this.o = true;
      if (this.bw.d()) {
        return true;
      }
      boolean bool = a(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (this.am != null)
      {
        if (a(paramMotionEvent.getX(), paramMotionEvent.getY(), ((TextCellLayout.MeasuredLine)this.R.get(((Integer)this.an.a).intValue())).b(((Integer)this.an.b).intValue()))) {
          return true;
        }
        p();
        paramHandler.removeMessages(0);
        this.bw.setLongClickTrig(false);
        return false;
      }
      if ((!bool) && ((this.ar) || (!this.bw.d()))) {
        return true;
      }
    }
    else
    {
      if (paramMotionEvent.getAction() == 1)
      {
        this.o = true;
        this.bw.setPressed(false);
        if (this.bw.d())
        {
          p();
          return true;
        }
        paramHandler.removeMessages(0);
        this.bw.setLongClickTrig(false);
        if (this.am != null)
        {
          if (a(paramMotionEvent.getX(), paramMotionEvent.getY(), ((TextCellLayout.MeasuredLine)this.R.get(((Integer)this.an.a).intValue())).b(((Integer)this.an.b).intValue())))
          {
            a(this.am, paramMotionEvent);
            p();
            return true;
          }
          a(null, paramMotionEvent);
          p();
          return false;
        }
        a(null, paramMotionEvent);
        p();
        return true;
      }
      this.bw.setPressed(false);
      this.bw.setLongClickTrig(false);
      paramHandler.removeMessages(0);
      p();
    }
    return false;
  }
  
  public boolean a(ETAnimator.DecorationHolder paramDecorationHolder, IETEngine paramIETEngine, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramBitmap1 != null)
    {
      bool1 = bool2;
      if (paramBitmap2 != null) {
        bool1 = bool2;
      }
    }
    try
    {
      if (!paramBitmap2.isRecycled())
      {
        bool1 = bool2;
        if (paramDecorationHolder.b == this.k)
        {
          paramBitmap2.eraseColor(0);
          paramIETEngine.nativeCloneBitmap(paramBitmap1, paramBitmap2);
          bool1 = true;
        }
      }
      return bool1;
    }
    finally {}
  }
  
  public boolean a(TextLayoutBase paramTextLayoutBase, Canvas paramCanvas)
  {
    if (this.q) {
      return false;
    }
    for (;;)
    {
      try
      {
        if (this.q) {
          return false;
        }
        if (L())
        {
          if (paramTextLayoutBase != null)
          {
            View localView = paramTextLayoutBase.getAttachedView();
            if (localView != null) {
              localView.postDelayed(new TextCellLayout.1(this), 100L);
            }
          }
          if (M())
          {
            bool = e(paramCanvas);
          }
          else
          {
            if (!c(paramCanvas)) {
              break label352;
            }
            return true;
          }
          if ((this.b instanceof ETPaint)) {
            ((ETPaint)this.b).a = bool;
          }
        }
        if (this.c == 1) {
          b(t());
        } else {
          b(this.u);
        }
        this.b.setTypeface(this.aU);
        int i1 = this.ad;
        int i2 = this.af;
        if (this.e != null)
        {
          if (this.e.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.bA)) {
            v();
          }
          this.ad = this.e.a();
          this.af = this.e.a();
        }
        this.b.setTypeface(this.aU);
        this.b.setShadowLayer(this.bb, this.bc, this.bd, this.be);
        I();
        if (this.aW != null) {
          this.b.setShader(this.aW);
        }
        if (this.h == 1)
        {
          c(paramTextLayoutBase, paramCanvas);
          if (this.aS) {
            w();
          }
        }
        else if (paramTextLayoutBase != null)
        {
          b(paramTextLayoutBase, paramCanvas);
        }
        if (this.aW != null) {
          this.b.setShader(null);
        }
        this.ad = i1;
        this.af = i2;
        return true;
      }
      finally {}
      label352:
      boolean bool = true;
    }
  }
  
  protected int b(TextCell paramTextCell)
  {
    return paramTextCell.getHeight(this.b);
  }
  
  protected void b(float paramFloat)
  {
    this.b.setTextSize(paramFloat);
    d(paramFloat);
  }
  
  public void b(int paramInt)
  {
    this.bv = paramInt;
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    if (p) {
      synchronized (r)
      {
        c(paramInt1, paramInt2);
        return;
      }
    }
    c(paramInt1, paramInt2);
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.bb = paramInt1;
    this.bc = paramInt2;
    this.bd = paramInt3;
    this.be = paramInt4;
  }
  
  public void b(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      paramString1 = this.b;
      if ((paramString1 instanceof ETPaint)) {
        this.b = ((ETPaint)paramString1).a();
      }
      this.aT = 0;
      this.aU = this.aV;
      return;
    }
    Paint localPaint = this.b;
    if (((localPaint instanceof ETPaint)) && (paramString1.equals(((ETPaint)localPaint).b()))) {
      return;
    }
    this.aT = paramInt1;
    if (this.cd == null) {
      this.cd = new TextCellLayout.6(this, paramInt1, paramInt2);
    }
    paramString1 = QCirclrHostFontHelper.getFullTypeFont(paramInt1, paramString1, null, this.cd);
    if (!TextUtils.isEmpty(paramString1)) {
      a(paramInt1, paramString1, paramInt2);
    }
    if ((!TextUtils.isEmpty(paramString2)) && (!M()) && (L())) {
      this.aO = paramString2;
    }
  }
  
  public void b(ColorStateList paramColorStateList)
  {
    this.ak = paramColorStateList;
  }
  
  public void b(boolean paramBoolean)
  {
    this.ax = paramBoolean;
  }
  
  public boolean b()
  {
    return this.bq;
  }
  
  public boolean b(char paramChar)
  {
    return (paramChar == '\'') || (paramChar == ';') || (paramChar == ',') || (paramChar == '.') || (paramChar == '?') || (paramChar == '!') || (paramChar == '"') || (paramChar == '_') || (paramChar == '-') || (paramChar == ':') || (paramChar == '@');
  }
  
  protected float c(TextCell paramTextCell)
  {
    return paramTextCell.getWidth(this.b);
  }
  
  public int c()
  {
    return this.W;
  }
  
  public int c(float paramFloat)
  {
    if (this.t == 0) {
      d(paramFloat);
    }
    return this.t;
  }
  
  public void c(int paramInt)
  {
    this.B = paramInt;
  }
  
  protected void c(int paramInt1, int paramInt2)
  {
    int i5 = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = paramInt1;
    if (paramInt1 <= 0) {
      paramInt2 = BaseConfig.getScreenWidth();
    }
    int i1 = this.O;
    paramInt1 = paramInt2;
    if (i1 > 0)
    {
      paramInt1 = paramInt2;
      if (i1 < paramInt2) {
        paramInt1 = i1;
      }
    }
    int i6 = this.B;
    if (this.bG)
    {
      i1 = BaseConfig.getScreenWidth() * 3;
      this.B = 1;
    }
    else
    {
      i1 = paramInt1;
    }
    if ((!this.T) && (this.W == i1)) {
      return;
    }
    paramInt2 = 0;
    this.T = false;
    int i7 = b(this.br) + b(this.bs);
    int i2 = i1 - i7 - this.aK - this.aM;
    this.bh = i2;
    Object localObject;
    if (this.V)
    {
      localObject = UiElementFixedCache.a().a(i2, (int)this.b.getTextSize(), j());
      if ((localObject != null) && (!this.U))
      {
        this.S = ((UiElementFixedCache.MeasuredTextResult)localObject).b;
        this.R = ((UiElementFixedCache.MeasuredTextResult)localObject).a;
        this.W = ((UiElementFixedCache.MeasuredTextResult)localObject).c;
      }
      else
      {
        n(i2);
        UiElementFixedCache.a().a(i2, (int)this.b.getTextSize(), j(), new UiElementFixedCache.MeasuredTextResult(this.R, this.S, this.W));
        this.U = false;
      }
    }
    else
    {
      n(i2);
    }
    i2 = this.x;
    if (this.g.booleanValue()) {
      paramInt2 = i2;
    }
    this.X = this.W;
    i2 = this.S.size() - 1;
    while (i2 >= 0)
    {
      paramInt2 += ((Integer)this.S.get(i2)).intValue() + this.x;
      i2 -= 1;
    }
    int i3;
    if ((this.A > this.S.size()) && (this.C != 0))
    {
      i3 = this.D;
      if (i3 <= this.A)
      {
        i2 = i3;
        if (i3 >= 0) {}
      }
      else
      {
        i2 = this.A;
      }
      i3 = i2 - this.S.size();
      localObject = this.S;
      i2 = ((Integer)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1)).intValue();
    }
    for (int i4 = this.x;; i4 = this.x)
    {
      i2 = paramInt2 + i3 * (i2 + i4);
      break;
      i2 = paramInt2;
      if (this.A <= this.S.size()) {
        break;
      }
      i2 = paramInt2;
      if (this.C != 0) {
        break;
      }
      i3 = this.B;
      if (i3 <= this.A)
      {
        i2 = i3;
        if (i3 >= 0) {}
      }
      else
      {
        i2 = this.A;
      }
      i3 = i2 - this.S.size();
      localObject = this.S;
      i2 = ((Integer)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1)).intValue();
    }
    this.Y = (this.aL + this.aN + i2);
    if ((i5 != 1073741824) && ((i5 != 0) || (i1 <= 0))) {
      this.W = (this.W + this.aM + this.aK + i7);
    } else {
      this.W = paramInt1;
    }
    this.Z = Math.max(this.Y, this.bt);
    if (this.bG)
    {
      this.Z = bX;
      this.B = i6;
    }
    this.bx = this.R.size();
  }
  
  public void c(boolean paramBoolean)
  {
    this.au = paramBoolean;
  }
  
  public int d()
  {
    return this.Z;
  }
  
  public void d(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void d(boolean paramBoolean)
  {
    this.av = paramBoolean;
  }
  
  public String e()
  {
    if (this.P == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i3 = this.R.size();
    int i1 = 0;
    while (i1 < i3)
    {
      TextCellLayout.MeasuredLine localMeasuredLine = (TextCellLayout.MeasuredLine)this.R.get(i1);
      int i4 = localMeasuredLine.c();
      int i2 = 0;
      while (i2 < i4)
      {
        TextCell localTextCell1 = localMeasuredLine.a(i2);
        TextCell localTextCell2 = this.am;
        if ((localTextCell2 != null) && (!localTextCell2.canCopy()) && (this.am.type == 3))
        {
          if (localTextCell1.linebreakSeq == this.am.linebreakSeq) {
            localStringBuilder.append(localTextCell1.getText());
          }
        }
        else if (localTextCell1.canCopy()) {
          localStringBuilder.append(localTextCell1.getText());
        }
        i2 += 1;
      }
      i1 += 1;
    }
    return localStringBuilder.toString();
  }
  
  public void e(int paramInt)
  {
    this.az = paramInt;
  }
  
  public void e(boolean paramBoolean)
  {
    this.aw = paramBoolean;
  }
  
  public String f()
  {
    if (this.P == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i3 = this.R.size();
    int i1 = 0;
    while (i1 < i3)
    {
      TextCellLayout.MeasuredLine localMeasuredLine = (TextCellLayout.MeasuredLine)this.R.get(i1);
      int i4 = localMeasuredLine.c();
      int i2 = 0;
      while (i2 < i4)
      {
        localStringBuilder.append(localMeasuredLine.a(i2).getText());
        i2 += 1;
      }
      i1 += 1;
    }
    return localStringBuilder.toString();
  }
  
  public void f(int paramInt)
  {
    this.ad = paramInt;
    this.ae = paramInt;
    this.o = true;
  }
  
  public void f(boolean paramBoolean)
  {
    this.ar = paramBoolean;
  }
  
  public float g()
  {
    return this.b.getTextSize();
  }
  
  public void g(int paramInt)
  {
    this.x = paramInt;
  }
  
  public void g(boolean paramBoolean)
  {
    this.as = paramBoolean;
  }
  
  public void h()
  {
    this.T = true;
    this.o = true;
  }
  
  public void h(int paramInt)
  {
    this.af = paramInt;
  }
  
  public void h(boolean paramBoolean)
  {
    this.b.setFakeBoldText(paramBoolean);
  }
  
  public void i()
  {
    this.U = true;
    h();
  }
  
  public void i(int paramInt)
  {
    this.ag = paramInt;
  }
  
  public void i(boolean paramBoolean)
  {
    this.V = paramBoolean;
  }
  
  public String j()
  {
    if (this.P == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.P.iterator();
    while (localIterator.hasNext())
    {
      String str = ((TextCell)localIterator.next()).getText();
      if (str != null) {
        localStringBuilder.append(str);
      }
    }
    return localStringBuilder.toString();
  }
  
  public void j(int paramInt)
  {
    this.O = paramInt;
  }
  
  public void j(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }
  
  public void k()
  {
    if (!L()) {
      return;
    }
    if (!this.i)
    {
      if (!a()) {
        return;
      }
      ETAnimator localETAnimator = this.l;
      if ((localETAnimator != null) && (this.m != null))
      {
        localETAnimator.b();
        this.l.c();
        if ((!this.i) && (!this.j) && (!b())) {
          this.i = true;
        }
        if (this.i) {
          this.l.a();
        }
        return;
      }
      this.i = false;
    }
  }
  
  public void k(boolean paramBoolean)
  {
    this.ay = paramBoolean;
  }
  
  public void l()
  {
    if (!L()) {
      return;
    }
    ETAnimator localETAnimator = this.l;
    if (localETAnimator != null)
    {
      localETAnimator.b();
      this.l.c();
    }
    this.i = false;
    this.j = false;
    if (A()) {
      this.m.gotoLastFrame();
    }
  }
  
  public void l(boolean paramBoolean)
  {
    this.aA = paramBoolean;
  }
  
  public int m()
  {
    int i1 = this.A;
    if (i1 > 0)
    {
      int i2 = this.B;
      if (i2 >= i1) {
        return i1;
      }
      return i2;
    }
    return this.bx;
  }
  
  public void m(boolean paramBoolean)
  {
    boolean bool = this.aS;
    if (bool == paramBoolean) {
      return;
    }
    if (paramBoolean)
    {
      if (this.aR != 0L) {
        this.aQ = (System.currentTimeMillis() - (this.aR - this.aQ));
      } else {
        this.aQ = System.currentTimeMillis();
      }
      this.aR = 0L;
    }
    else if (bool)
    {
      this.aR = System.currentTimeMillis();
    }
    this.aS = paramBoolean;
  }
  
  public void n()
  {
    Object localObject = this.bw;
    if (localObject != null)
    {
      localObject = ((TextLayoutBase)localObject).getAttachedView();
      if (localObject != null) {
        ((View)localObject).invalidate();
      }
    }
  }
  
  public void o()
  {
    Object localObject = this.bw;
    if (localObject != null)
    {
      localObject = ((TextLayoutBase)localObject).getAttachedView();
      if (localObject != null) {
        ((View)localObject).postInvalidate();
      }
    }
  }
  
  public void p()
  {
    this.Q = false;
    this.bw.setPressed(false);
    this.bw.postInvalidate();
    if (this.am == null) {
      return;
    }
    Iterator localIterator = this.ao.iterator();
    while (localIterator.hasNext()) {
      ((TextCell)localIterator.next()).isPresseding = false;
    }
    this.ao.clear();
    this.am = null;
    this.ap = -1.0F;
    this.aq = -1.0F;
  }
  
  public Paint q()
  {
    return this.b;
  }
  
  Bitmap r()
  {
    Bitmap localBitmap = (Bitmap)TextCellLayoutCache.a().b().get(Integer.valueOf(H()));
    if (localBitmap != null) {
      return localBitmap;
    }
    return null;
  }
  
  Bitmap s()
  {
    if (this.m != null)
    {
      if (this.n == null) {
        return null;
      }
      int i2;
      int i1;
      Object localObject1;
      int i3;
      if (M())
      {
        i2 = this.n.c();
        i1 = this.n.d();
      }
      else
      {
        localObject1 = this.m.getMargins();
        if (localObject1 != null)
        {
          i1 = ((Rect)localObject1).left + ((Rect)localObject1).right;
          i2 = ((Rect)localObject1).top;
          i2 = ((Rect)localObject1).bottom + i2;
        }
        else
        {
          i2 = 0;
          i1 = 0;
        }
        i3 = this.X;
        i2 += this.Y;
        i3 = i1 + i3;
        i1 = i2;
        i2 = i3;
      }
      Object localObject2 = r();
      try
      {
        int i4 = (int)g() * 4;
        i3 = i1;
        if (i1 < i4) {
          i3 = i4;
        }
        localObject1 = localObject2;
        if (localObject2 != null) {
          if ((((Bitmap)localObject2).getHeight() >= i3) && (((Bitmap)localObject2).getWidth() >= i2))
          {
            localObject1 = localObject2;
            if (((Bitmap)localObject2).getHeight() <= i4 + i3) {}
          }
          else
          {
            TextCellLayoutCache.a().b().remove(Integer.valueOf(H()));
            ((Bitmap)localObject2).recycle();
            localObject1 = null;
          }
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        }
        ((Bitmap)localObject2).eraseColor(0);
        TextCellLayoutCache.a().b().put(Integer.valueOf(H()), localObject2);
        if (this.bo == null) {
          this.bo = new TextCellLayout.RecycleCacheTag(this, H());
        }
        return localObject2;
      }
      catch (Throwable localThrowable)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("allocCacheBitmap2XuanDong OutOfMemoryError.errMsg = ");
        ((StringBuilder)localObject2).append(localThrowable.getMessage());
        QLog.e("TextCellLayout", 1, ((StringBuilder)localObject2).toString());
      }
    }
    return null;
  }
  
  public int t()
  {
    if (this.ab <= 0) {
      this.ab = ViewUtils.a(QCircleConfigHelper.a("QzCustomFont", "LargeFontSize", Integer.valueOf(30)).intValue());
    }
    return this.ab;
  }
  
  public void u()
  {
    Object localObject = this.e;
    if ((localObject != null) && ((!((TextColorAnimation)localObject).hasStarted()) || (this.e.hasEnded())))
    {
      this.e.start();
      o();
    }
    localObject = this.bS;
    if ((localObject != null) && ((!((TranslateAnimation)localObject).hasStarted()) || (this.bS.hasEnded())))
    {
      this.bS.start();
      o();
    }
    localObject = this.bT;
    if (localObject != null)
    {
      ((Animatable)localObject).start();
      o();
      return;
    }
    if (!TextUtils.isEmpty(this.bN))
    {
      int i1 = this.bO;
      if (i1 > 0) {
        this.bT = d(this.bN, i1);
      }
    }
  }
  
  public void v()
  {
    Object localObject = this.bw;
    if (localObject != null)
    {
      localObject = ((TextLayoutBase)localObject).getAttachedView();
      if (localObject != null) {
        ((View)localObject).postInvalidateDelayed(16L);
      }
    }
  }
  
  public void w()
  {
    Object localObject = this.bw;
    if (localObject != null)
    {
      localObject = ((TextLayoutBase)localObject).getAttachedView();
      if (localObject != null) {
        ((View)localObject).postInvalidateDelayed(16L);
      }
    }
  }
  
  public void x()
  {
    Paint localPaint = this.b;
    if ((localPaint instanceof ETPaint)) {
      this.b = ((ETPaint)localPaint).a();
    }
    if (this.aV == null) {
      this.aV = HostStaticInvokeHelper.getSystemDefaultFont();
    }
    this.aT = 0;
    this.aU = this.aV;
  }
  
  public void y()
  {
    Animatable localAnimatable = this.bT;
    if (localAnimatable != null) {
      localAnimatable.stop();
    }
  }
  
  public void z()
  {
    u();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.TextCellLayout
 * JD-Core Version:    0.7.0.1
 */