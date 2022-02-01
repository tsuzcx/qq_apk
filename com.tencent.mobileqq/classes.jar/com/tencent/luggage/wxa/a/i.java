package com.tencent.luggage.wxa.a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Path.Op;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.util.Base64;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Stack;

class i
{
  private static HashSet<String> h;
  private Canvas a;
  private float b;
  private h c;
  private i.g d;
  private Stack<i.g> e;
  private Stack<h.aj> f;
  private Stack<Matrix> g;
  private b.p i = null;
  
  i(Canvas paramCanvas, float paramFloat)
  {
    this.a = paramCanvas;
    this.b = paramFloat;
  }
  
  private static double a(double paramDouble)
  {
    if (paramDouble < -1.0D) {
      return 3.141592653589793D;
    }
    if (paramDouble > 1.0D) {
      return 0.0D;
    }
    return Math.acos(paramDouble);
  }
  
  private float a(h.ay paramay)
  {
    i.j localj = new i.j(this, null);
    a(paramay, localj);
    return localj.a;
  }
  
  private static int a(float paramFloat)
  {
    int k = (int)(paramFloat * 256.0F);
    if (k < 0) {
      return 0;
    }
    int j = k;
    if (k > 255) {
      j = 255;
    }
    return j;
  }
  
  private static int a(int paramInt, float paramFloat)
  {
    int j = 255;
    int k = Math.round((paramInt >> 24 & 0xFF) * paramFloat);
    if (k < 0) {
      j = 0;
    } else if (k <= 255) {
      j = k;
    }
    return paramInt & 0xFFFFFF | j << 24;
  }
  
  private Bitmap a(String paramString)
  {
    if (!paramString.startsWith("data:")) {
      return null;
    }
    if (paramString.length() < 14) {
      return null;
    }
    int j = paramString.indexOf(',');
    if (j < 12) {
      return null;
    }
    if (!";base64".equals(paramString.substring(j - 7, j))) {
      return null;
    }
    try
    {
      paramString = Base64.decode(paramString.substring(j + 1), 0);
      paramString = BitmapFactory.decodeByteArray(paramString, 0, paramString.length);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.e("SVGAndroidRenderer", "Could not decode bad Data URL", paramString);
    }
    return null;
  }
  
  private Matrix a(h.b paramb1, h.b paramb2, f paramf)
  {
    Matrix localMatrix = new Matrix();
    if (paramf != null)
    {
      if (paramf.a() == null) {
        return localMatrix;
      }
      float f1 = paramb1.c / paramb2.c;
      float f2 = paramb1.d / paramb2.d;
      float f3 = -paramb2.a;
      float f4 = -paramb2.b;
      if (paramf.equals(f.b))
      {
        localMatrix.preTranslate(paramb1.a, paramb1.b);
        localMatrix.preScale(f1, f2);
        localMatrix.preTranslate(f3, f4);
        return localMatrix;
      }
      if (paramf.b() == f.b.b) {
        f1 = Math.max(f1, f2);
      } else {
        f1 = Math.min(f1, f2);
      }
      f2 = paramb1.c / f1;
      float f5 = paramb1.d / f1;
      switch (i.1.a[paramf.a().ordinal()])
      {
      default: 
        f2 = f3;
        break;
      case 4: 
      case 5: 
      case 6: 
        f2 = paramb2.c - f2;
        break;
      case 1: 
      case 2: 
      case 3: 
        f2 = (paramb2.c - f2) / 2.0F;
      }
      f2 = f3 - f2;
      int j = i.1.a[paramf.a().ordinal()];
      if (j != 2)
      {
        if (j != 3)
        {
          if (j == 5) {
            break label312;
          }
          if (j != 6)
          {
            if (j == 7) {
              break label312;
            }
            if (j != 8)
            {
              f3 = f4;
              break label330;
            }
          }
        }
        f3 = paramb2.d - f5;
        break label323;
      }
      label312:
      f3 = (paramb2.d - f5) / 2.0F;
      label323:
      f3 = f4 - f3;
      label330:
      localMatrix.preTranslate(paramb1.a, paramb1.b);
      localMatrix.preScale(f1, f1);
      localMatrix.preTranslate(f2, f3);
    }
    return localMatrix;
  }
  
  @TargetApi(19)
  private Path a(h.ak paramak, boolean paramBoolean)
  {
    this.e.push(this.d);
    this.d = new i.g(this, this.d);
    a(this.d, paramak);
    if ((m()) && (n()))
    {
      Object localObject3;
      Object localObject1;
      Object localObject2;
      if ((paramak instanceof h.be))
      {
        if (!paramBoolean) {
          e("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
        }
        localObject3 = (h.be)paramak;
        localObject1 = paramak.u.a(((h.be)localObject3).a);
        if (localObject1 == null)
        {
          e("Use reference '%s' not found", new Object[] { ((h.be)localObject3).a });
          this.d = ((i.g)this.e.pop());
          return null;
        }
        if (!(localObject1 instanceof h.ak))
        {
          this.d = ((i.g)this.e.pop());
          return null;
        }
        localObject2 = a((h.ak)localObject1, false);
        if (localObject2 == null) {
          return null;
        }
        if (((h.be)localObject3).o == null) {
          ((h.be)localObject3).o = b((Path)localObject2);
        }
        localObject1 = localObject2;
        if (((h.be)localObject3).b != null)
        {
          ((Path)localObject2).transform(((h.be)localObject3).b);
          localObject1 = localObject2;
        }
      }
      else if ((paramak instanceof h.l))
      {
        localObject3 = (h.l)paramak;
        if ((paramak instanceof h.v))
        {
          localObject2 = new i.c(((h.v)paramak).a).a();
          localObject1 = localObject2;
          if (paramak.o == null)
          {
            paramak.o = b((Path)localObject2);
            localObject1 = localObject2;
          }
        }
        else if ((paramak instanceof h.ab))
        {
          localObject1 = b((h.ab)paramak);
        }
        else if ((paramak instanceof h.d))
        {
          localObject1 = b((h.d)paramak);
        }
        else if ((paramak instanceof h.i))
        {
          localObject1 = b((h.i)paramak);
        }
        else if ((paramak instanceof h.z))
        {
          localObject1 = c((h.z)paramak);
        }
        else
        {
          localObject1 = null;
        }
        if (localObject1 == null) {
          return null;
        }
        if (((h.l)localObject3).o == null) {
          ((h.l)localObject3).o = b((Path)localObject1);
        }
        if (((h.l)localObject3).e != null) {
          ((Path)localObject1).transform(((h.l)localObject3).e);
        }
        ((Path)localObject1).setFillType(s());
      }
      else
      {
        if (!(paramak instanceof h.aw)) {
          break label515;
        }
        localObject2 = (h.aw)paramak;
        localObject1 = b((h.aw)localObject2);
        if (localObject1 == null) {
          return null;
        }
        if (((h.aw)localObject2).a != null) {
          ((Path)localObject1).transform(((h.aw)localObject2).a);
        }
        ((Path)localObject1).setFillType(s());
      }
      if (this.d.a.E != null)
      {
        paramak = c(paramak, paramak.o);
        if (paramak != null) {
          ((Path)localObject1).op(paramak, Path.Op.INTERSECT);
        }
      }
      this.d = ((i.g)this.e.pop());
      return localObject1;
      label515:
      e("Invalid %s element found in clipPath definition", new Object[] { paramak.a() });
      return null;
    }
    this.d = ((i.g)this.e.pop());
    return null;
  }
  
  private Typeface a(String paramString, Integer paramInteger, h.ae.b paramb)
  {
    if (paramb == h.ae.b.b) {
      j = 1;
    } else {
      j = 0;
    }
    int k;
    if (paramInteger.intValue() > 500)
    {
      if (j != 0) {
        k = 3;
      } else {
        k = 1;
      }
    }
    else if (j != 0) {
      k = 2;
    } else {
      k = 0;
    }
    int j = -1;
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 1126973893: 
      if (paramString.equals("cursive")) {
        j = 3;
      }
      break;
    case 109326717: 
      if (paramString.equals("serif")) {
        j = 0;
      }
      break;
    case -1081737434: 
      if (paramString.equals("fantasy")) {
        j = 4;
      }
      break;
    case -1431958525: 
      if (paramString.equals("monospace")) {
        j = 2;
      }
      break;
    case -1536685117: 
      if (paramString.equals("sans-serif")) {
        j = 1;
      }
      break;
    }
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3)
          {
            if (j != 4) {
              return null;
            }
            return Typeface.create(Typeface.SANS_SERIF, k);
          }
          return Typeface.create(Typeface.SANS_SERIF, k);
        }
        return Typeface.create(Typeface.MONOSPACE, k);
      }
      return Typeface.create(Typeface.SANS_SERIF, k);
    }
    return Typeface.create(Typeface.SERIF, k);
  }
  
  private h.b a(h.p paramp1, h.p paramp2, h.p paramp3, h.p paramp4)
  {
    float f2 = 0.0F;
    float f1;
    if (paramp1 != null) {
      f1 = paramp1.a(this);
    } else {
      f1 = 0.0F;
    }
    if (paramp2 != null) {
      f2 = paramp2.b(this);
    }
    paramp1 = d();
    float f3;
    if (paramp3 != null) {
      f3 = paramp3.a(this);
    } else {
      f3 = paramp1.c;
    }
    float f4;
    if (paramp4 != null) {
      f4 = paramp4.b(this);
    } else {
      f4 = paramp1.d;
    }
    return new h.b(f1, f2, f3, f4);
  }
  
  private i.b a(i.b paramb1, i.b paramb2, i.b paramb3)
  {
    float f2 = b(paramb2.c, paramb2.d, paramb2.a - paramb1.a, paramb2.b - paramb1.b);
    float f1 = f2;
    if (f2 == 0.0F) {
      f1 = b(paramb2.c, paramb2.d, paramb3.a - paramb2.a, paramb3.b - paramb2.b);
    }
    if (f1 > 0.0F) {
      return paramb2;
    }
    if ((f1 == 0.0F) && ((paramb2.c > 0.0F) || (paramb2.d >= 0.0F))) {
      return paramb2;
    }
    paramb2.c = (-paramb2.c);
    paramb2.d = (-paramb2.d);
    return paramb2;
  }
  
  private i.g a(h.an paraman, i.g paramg)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      if ((paraman instanceof h.al)) {
        localArrayList.add(0, (h.al)paraman);
      }
      if (paraman.v == null)
      {
        paraman = localArrayList.iterator();
        while (paraman.hasNext()) {
          a(paramg, (h.al)paraman.next());
        }
        paramg.g = this.d.g;
        paramg.f = this.d.f;
        return paramg;
      }
      paraman = (h.an)paraman.v;
    }
  }
  
  private String a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.d.h) {
      return paramString.replaceAll("[\\n\\t]", " ");
    }
    String str = paramString.replaceAll("\\n", "").replaceAll("\\t", " ");
    paramString = str;
    if (paramBoolean1) {
      paramString = str.replaceAll("^\\s+", "");
    }
    str = paramString;
    if (paramBoolean2) {
      str = paramString.replaceAll("\\s+$", "");
    }
    return str.replaceAll("\\s{2,}", " ");
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f3 = paramFloat3 + paramFloat1;
    float f4 = paramFloat4 + paramFloat2;
    float f2 = paramFloat1;
    float f1 = paramFloat2;
    paramFloat4 = f3;
    paramFloat3 = f4;
    if (this.d.a.w != null)
    {
      f2 = paramFloat1 + this.d.a.w.d.a(this);
      f1 = paramFloat2 + this.d.a.w.a.b(this);
      paramFloat4 = f3 - this.d.a.w.b.a(this);
      paramFloat3 = f4 - this.d.a.w.c.b(this);
    }
    this.a.clipRect(f2, f1, paramFloat4, paramFloat3);
  }
  
  private void a(Path paramPath)
  {
    if (this.d.a.L == h.ae.i.b)
    {
      Matrix localMatrix1 = this.a.getMatrix();
      Path localPath = new Path();
      paramPath.transform(localMatrix1, localPath);
      this.a.setMatrix(new Matrix());
      paramPath = this.d.e.getShader();
      Matrix localMatrix2 = new Matrix();
      if (paramPath != null)
      {
        paramPath.getLocalMatrix(localMatrix2);
        Matrix localMatrix3 = new Matrix(localMatrix2);
        localMatrix3.postConcat(localMatrix1);
        paramPath.setLocalMatrix(localMatrix3);
      }
      this.a.drawPath(localPath, this.d.e);
      this.a.setMatrix(localMatrix1);
      if (paramPath != null) {
        paramPath.setLocalMatrix(localMatrix2);
      }
    }
    else
    {
      this.a.drawPath(paramPath, this.d.e);
    }
  }
  
  private void a(h.aa paramaa)
  {
    f("Polygon render", new Object[0]);
    a(this.d, paramaa);
    if (!m()) {
      return;
    }
    if (!n()) {
      return;
    }
    if ((!this.d.c) && (!this.d.b)) {
      return;
    }
    if (paramaa.e != null) {
      this.a.concat(paramaa.e);
    }
    if (paramaa.a.length < 2) {
      return;
    }
    Path localPath = c(paramaa);
    a(paramaa);
    c(paramaa);
    d(paramaa);
    boolean bool = i();
    if (this.d.b) {
      a(paramaa, localPath);
    }
    if (this.d.c) {
      a(localPath);
    }
    a(paramaa);
    if (bool) {
      b(paramaa);
    }
  }
  
  private void a(h.ab paramab)
  {
    f("Rect render", new Object[0]);
    if ((paramab.c != null) && (paramab.d != null) && (!paramab.c.b()))
    {
      if (paramab.d.b()) {
        return;
      }
      a(this.d, paramab);
      if (!m()) {
        return;
      }
      if (!n()) {
        return;
      }
      if (paramab.e != null) {
        this.a.concat(paramab.e);
      }
      Path localPath = b(paramab);
      a(paramab);
      c(paramab);
      d(paramab);
      boolean bool = i();
      if (this.d.b) {
        a(paramab, localPath);
      }
      if (this.d.c) {
        a(localPath);
      }
      if (bool) {
        b(paramab);
      }
    }
  }
  
  private void a(h.af paramaf)
  {
    a(paramaf, a(paramaf.a, paramaf.b, paramaf.c, paramaf.d), paramaf.x, paramaf.w);
  }
  
  private void a(h.af paramaf, h.b paramb)
  {
    a(paramaf, paramb, paramaf.x, paramaf.w);
  }
  
  private void a(h.af paramaf, h.b paramb1, h.b paramb2, f paramf)
  {
    f("Svg render", new Object[0]);
    if (paramb1.c != 0.0F)
    {
      if (paramb1.d == 0.0F) {
        return;
      }
      f localf = paramf;
      if (paramf == null) {
        if (paramaf.w != null) {
          localf = paramaf.w;
        } else {
          localf = f.c;
        }
      }
      a(this.d, paramaf);
      if (!m()) {
        return;
      }
      paramf = this.d;
      paramf.f = paramb1;
      if (!paramf.a.v.booleanValue()) {
        a(this.d.f.a, this.d.f.b, this.d.f.c, this.d.f.d);
      }
      b(paramaf, this.d.f);
      if (paramb2 != null)
      {
        this.a.concat(a(this.d.f, paramb2, localf));
        this.d.g = paramaf.x;
      }
      else
      {
        this.a.translate(this.d.f.a, this.d.f.b);
      }
      boolean bool = i();
      p();
      a(paramaf, true);
      if (bool) {
        b(paramaf);
      }
      a(paramaf);
    }
  }
  
  private void a(h.aj paramaj)
  {
    this.f.push(paramaj);
    this.g.push(this.a.getMatrix());
  }
  
  private void a(h.aj paramaj, boolean paramBoolean)
  {
    if (paramBoolean) {
      a(paramaj);
    }
    paramaj = paramaj.b().iterator();
    while (paramaj.hasNext()) {
      a((h.an)paramaj.next());
    }
    if (paramBoolean) {
      h();
    }
  }
  
  private void a(h.ak paramak)
  {
    if (paramak.v == null) {
      return;
    }
    if (paramak.o == null) {
      return;
    }
    Matrix localMatrix = new Matrix();
    if (((Matrix)this.g.peek()).invert(localMatrix))
    {
      Object localObject = new float[8];
      localObject[0] = paramak.o.a;
      localObject[1] = paramak.o.b;
      float f1 = paramak.o.a();
      int j = 2;
      localObject[2] = f1;
      localObject[3] = paramak.o.b;
      localObject[4] = paramak.o.a();
      localObject[5] = paramak.o.b();
      localObject[6] = paramak.o.a;
      localObject[7] = paramak.o.b();
      localMatrix.preConcat(this.a.getMatrix());
      localMatrix.mapPoints((float[])localObject);
      paramak = new RectF(localObject[0], localObject[1], localObject[0], localObject[1]);
      while (j <= 6)
      {
        if (localObject[j] < paramak.left) {
          paramak.left = localObject[j];
        }
        if (localObject[j] > paramak.right) {
          paramak.right = localObject[j];
        }
        int k = j + 1;
        if (localObject[k] < paramak.top) {
          paramak.top = localObject[k];
        }
        if (localObject[k] > paramak.bottom) {
          paramak.bottom = localObject[k];
        }
        j += 2;
      }
      localObject = (h.ak)this.f.peek();
      if (((h.ak)localObject).o == null)
      {
        ((h.ak)localObject).o = h.b.a(paramak.left, paramak.top, paramak.right, paramak.bottom);
        return;
      }
      ((h.ak)localObject).o.a(h.b.a(paramak.left, paramak.top, paramak.right, paramak.bottom));
    }
  }
  
  private void a(h.ak paramak, Path paramPath)
  {
    if ((this.d.a.b instanceof h.u))
    {
      h.an localan = this.c.a(((h.u)this.d.a.b).a);
      if ((localan instanceof h.y))
      {
        a(paramak, paramPath, (h.y)localan);
        return;
      }
    }
    this.a.drawPath(paramPath, this.d.d);
  }
  
  private void a(h.ak paramak, Path paramPath, h.y paramy)
  {
    int j;
    if ((paramy.a != null) && (paramy.a.booleanValue())) {
      j = 1;
    } else {
      j = 0;
    }
    if (paramy.h != null) {
      a(paramy, paramy.h);
    }
    float f1;
    float f3;
    float f2;
    float f4;
    float f5;
    float f6;
    float f7;
    if (j != 0)
    {
      if (paramy.d != null) {
        f1 = paramy.d.a(this);
      } else {
        f1 = 0.0F;
      }
      if (paramy.e != null) {
        f3 = paramy.e.b(this);
      } else {
        f3 = 0.0F;
      }
      if (paramy.f != null) {
        f2 = paramy.f.a(this);
      } else {
        f2 = 0.0F;
      }
      if (paramy.g != null) {
        f4 = paramy.g.b(this);
      } else {
        f4 = 0.0F;
      }
      f5 = f3;
      f3 = f4;
    }
    else
    {
      if (paramy.d != null) {
        f3 = paramy.d.a(this, 1.0F);
      } else {
        f3 = 0.0F;
      }
      if (paramy.e != null) {
        f1 = paramy.e.a(this, 1.0F);
      } else {
        f1 = 0.0F;
      }
      if (paramy.f != null) {
        f2 = paramy.f.a(this, 1.0F);
      } else {
        f2 = 0.0F;
      }
      if (paramy.g != null) {
        f4 = paramy.g.a(this, 1.0F);
      } else {
        f4 = 0.0F;
      }
      f5 = paramak.o.a;
      f6 = f3 * paramak.o.c + f5;
      f5 = paramak.o.b;
      float f8 = paramak.o.d;
      f7 = paramak.o.c;
      f3 = f4 * paramak.o.d;
      f5 = f1 * f8 + f5;
      f2 *= f7;
      f1 = f6;
    }
    if (f2 != 0.0F)
    {
      if (f3 == 0.0F) {
        return;
      }
      f localf;
      if (paramy.w != null) {
        localf = paramy.w;
      } else {
        localf = f.c;
      }
      f();
      this.a.clipPath(paramPath);
      paramPath = new i.g(this);
      a(paramPath, h.ae.a());
      paramPath.a.v = Boolean.valueOf(false);
      this.d = a(paramy, paramPath);
      Object localObject = paramak.o;
      paramPath = (Path)localObject;
      if (paramy.c != null)
      {
        this.a.concat(paramy.c);
        Matrix localMatrix = new Matrix();
        paramPath = (Path)localObject;
        if (paramy.c.invert(localMatrix))
        {
          paramPath = new float[8];
          paramPath[0] = paramak.o.a;
          paramPath[1] = paramak.o.b;
          paramPath[2] = paramak.o.a();
          paramPath[3] = paramak.o.b;
          paramPath[4] = paramak.o.a();
          paramPath[5] = paramak.o.b();
          paramPath[6] = paramak.o.a;
          paramPath[7] = paramak.o.b();
          localMatrix.mapPoints(paramPath);
          localObject = new RectF(paramPath[0], paramPath[1], paramPath[0], paramPath[1]);
          j = 2;
          while (j <= 6)
          {
            if (paramPath[j] < ((RectF)localObject).left) {
              ((RectF)localObject).left = paramPath[j];
            }
            if (paramPath[j] > ((RectF)localObject).right) {
              ((RectF)localObject).right = paramPath[j];
            }
            int k = j + 1;
            if (paramPath[k] < ((RectF)localObject).top) {
              ((RectF)localObject).top = paramPath[k];
            }
            if (paramPath[k] > ((RectF)localObject).bottom) {
              ((RectF)localObject).bottom = paramPath[k];
            }
            j += 2;
          }
          paramPath = new h.b(((RectF)localObject).left, ((RectF)localObject).top, ((RectF)localObject).right - ((RectF)localObject).left, ((RectF)localObject).bottom - ((RectF)localObject).top);
        }
      }
      f1 += (float)Math.floor((paramPath.a - f1) / f2) * f2;
      f4 = f5 + (float)Math.floor((paramPath.b - f5) / f3) * f3;
      f6 = paramPath.a();
      f7 = paramPath.b();
      paramPath = new h.b(0.0F, 0.0F, f2, f3);
      boolean bool = i();
      while (f4 < f7)
      {
        for (f5 = f1; f5 < f6; f5 += f2)
        {
          paramPath.a = f5;
          paramPath.b = f4;
          f();
          if (!this.d.a.v.booleanValue()) {
            a(paramPath.a, paramPath.b, paramPath.c, paramPath.d);
          }
          if (paramy.x != null)
          {
            this.a.concat(a(paramPath, paramy.x, localf));
          }
          else
          {
            if ((paramy.b != null) && (!paramy.b.booleanValue())) {
              j = 0;
            } else {
              j = 1;
            }
            this.a.translate(f5, f4);
            if (j == 0) {
              this.a.scale(paramak.o.c, paramak.o.d);
            }
          }
          localObject = paramy.i.iterator();
          while (((Iterator)localObject).hasNext()) {
            a((h.an)((Iterator)localObject).next());
          }
          g();
        }
        f4 += f3;
      }
      if (bool) {
        b(paramy);
      }
      g();
    }
  }
  
  private void a(h.ak paramak, h.b paramb)
  {
    if (this.d.a.G != null)
    {
      Object localObject = new Paint();
      ((Paint)localObject).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      this.a.saveLayer(null, (Paint)localObject, 31);
      localObject = new Paint();
      ((Paint)localObject).setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2127F, 0.7151F, 0.0722F, 0.0F, 0.0F })));
      this.a.saveLayer(null, (Paint)localObject, 31);
      localObject = (h.s)this.c.a(this.d.a.G);
      a((h.s)localObject, paramak, paramb);
      this.a.restore();
      Paint localPaint = new Paint();
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      this.a.saveLayer(null, localPaint, 31);
      a((h.s)localObject, paramak, paramb);
      this.a.restore();
      this.a.restore();
    }
    g();
  }
  
  private void a(h.am paramam1, h.am paramam2)
  {
    if (paramam1.f == null) {
      paramam1.f = paramam2.f;
    }
    if (paramam1.g == null) {
      paramam1.g = paramam2.g;
    }
    if (paramam1.h == null) {
      paramam1.h = paramam2.h;
    }
    if (paramam1.i == null) {
      paramam1.i = paramam2.i;
    }
  }
  
  private void a(h.an paraman)
  {
    if ((paraman instanceof h.t)) {
      return;
    }
    f();
    b(paraman);
    if ((paraman instanceof h.af)) {
      a((h.af)paraman);
    } else if ((paraman instanceof h.be)) {
      a((h.be)paraman);
    } else if ((paraman instanceof h.as)) {
      a((h.as)paraman);
    } else if ((paraman instanceof h.m)) {
      a((h.m)paraman);
    } else if ((paraman instanceof h.o)) {
      a((h.o)paraman);
    } else if ((paraman instanceof h.v)) {
      a((h.v)paraman);
    } else if ((paraman instanceof h.ab)) {
      a((h.ab)paraman);
    } else if ((paraman instanceof h.d)) {
      a((h.d)paraman);
    } else if ((paraman instanceof h.i)) {
      a((h.i)paraman);
    } else if ((paraman instanceof h.q)) {
      a((h.q)paraman);
    } else if ((paraman instanceof h.aa)) {
      a((h.aa)paraman);
    } else if ((paraman instanceof h.z)) {
      a((h.z)paraman);
    } else if ((paraman instanceof h.aw)) {
      a((h.aw)paraman);
    }
    g();
  }
  
  private void a(h.an paraman, i.i parami)
  {
    if (!parami.a((h.ay)paraman)) {
      return;
    }
    if ((paraman instanceof h.az))
    {
      f();
      a((h.az)paraman);
      g();
      return;
    }
    boolean bool = paraman instanceof h.av;
    int j = 1;
    Object localObject;
    if (bool)
    {
      f("TSpan render", new Object[0]);
      f();
      paraman = (h.av)paraman;
      a(this.d, paraman);
      if (m())
      {
        if ((paraman.b == null) || (paraman.b.size() <= 0)) {
          j = 0;
        }
        bool = parami instanceof i.e;
        float f2 = 0.0F;
        float f5 = 0.0F;
        float f1;
        float f3;
        float f4;
        if (bool)
        {
          if (j == 0) {
            f2 = ((i.e)parami).b;
          } else {
            f2 = ((h.p)paraman.b.get(0)).a(this);
          }
          if ((paraman.c != null) && (paraman.c.size() != 0)) {
            f1 = ((h.p)paraman.c.get(0)).b(this);
          } else {
            f1 = ((i.e)parami).c;
          }
          if ((paraman.d != null) && (paraman.d.size() != 0)) {
            f3 = ((h.p)paraman.d.get(0)).a(this);
          } else {
            f3 = 0.0F;
          }
          f4 = f5;
          if (paraman.e != null) {
            if (paraman.e.size() == 0) {
              f4 = f5;
            } else {
              f4 = ((h.p)paraman.e.get(0)).b(this);
            }
          }
        }
        else
        {
          f4 = 0.0F;
          f1 = 0.0F;
          f3 = 0.0F;
        }
        f5 = f2;
        if (j != 0)
        {
          localObject = l();
          f5 = f2;
          if (localObject != h.ae.f.a)
          {
            float f6 = a(paraman);
            f5 = f6;
            if (localObject == h.ae.f.b) {
              f5 = f6 / 2.0F;
            }
            f5 = f2 - f5;
          }
        }
        c((h.ak)paraman.h());
        if (bool)
        {
          localObject = (i.e)parami;
          ((i.e)localObject).b = (f5 + f3);
          ((i.e)localObject).c = (f1 + f4);
        }
        bool = i();
        a(paraman, parami);
        if (bool) {
          b(paraman);
        }
      }
      g();
      return;
    }
    if ((paraman instanceof h.au))
    {
      f();
      localObject = (h.au)paraman;
      a(this.d, (h.al)localObject);
      if (m())
      {
        c((h.ak)((h.au)localObject).h());
        paraman = paraman.u.a(((h.au)localObject).a);
        if ((paraman != null) && ((paraman instanceof h.ay)))
        {
          localObject = new StringBuilder();
          a((h.ay)paraman, (StringBuilder)localObject);
          if (((StringBuilder)localObject).length() > 0) {
            parami.a(((StringBuilder)localObject).toString());
          }
        }
        else
        {
          e("Tref reference '%s' not found", new Object[] { ((h.au)localObject).a });
        }
      }
      g();
    }
  }
  
  private void a(h.an paraman, boolean paramBoolean, Path paramPath, Matrix paramMatrix)
  {
    if (!m()) {
      return;
    }
    q();
    if ((paraman instanceof h.be))
    {
      if (paramBoolean) {
        a((h.be)paraman, paramPath, paramMatrix);
      } else {
        e("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
      }
    }
    else if ((paraman instanceof h.v)) {
      a((h.v)paraman, paramPath, paramMatrix);
    } else if ((paraman instanceof h.aw)) {
      a((h.aw)paraman, paramPath, paramMatrix);
    } else if ((paraman instanceof h.l)) {
      a((h.l)paraman, paramPath, paramMatrix);
    } else {
      e("Invalid %s element found in clipPath definition", new Object[] { paraman.toString() });
    }
    r();
  }
  
  private void a(h.aq paramaq1, h.aq paramaq2)
  {
    if (paramaq1.f == null) {
      paramaq1.f = paramaq2.f;
    }
    if (paramaq1.g == null) {
      paramaq1.g = paramaq2.g;
    }
    if (paramaq1.h == null) {
      paramaq1.h = paramaq2.h;
    }
    if (paramaq1.i == null) {
      paramaq1.i = paramaq2.i;
    }
    if (paramaq1.j == null) {
      paramaq1.j = paramaq2.j;
    }
  }
  
  private void a(h.as paramas)
  {
    f("Switch render", new Object[0]);
    a(this.d, paramas);
    if (!m()) {
      return;
    }
    if (paramas.b != null) {
      this.a.concat(paramas.b);
    }
    d(paramas);
    boolean bool = i();
    b(paramas);
    if (bool) {
      b(paramas);
    }
    a(paramas);
  }
  
  private void a(h.at paramat, h.b paramb)
  {
    f("Symbol render", new Object[0]);
    if (paramb.c != 0.0F)
    {
      if (paramb.d == 0.0F) {
        return;
      }
      f localf;
      if (paramat.w != null) {
        localf = paramat.w;
      } else {
        localf = f.c;
      }
      a(this.d, paramat);
      i.g localg = this.d;
      localg.f = paramb;
      if (!localg.a.v.booleanValue()) {
        a(this.d.f.a, this.d.f.b, this.d.f.c, this.d.f.d);
      }
      if (paramat.x != null)
      {
        this.a.concat(a(this.d.f, paramat.x, localf));
        this.d.g = paramat.x;
      }
      else
      {
        this.a.translate(this.d.f.a, this.d.f.b);
      }
      boolean bool = i();
      a(paramat, true);
      if (bool) {
        b(paramat);
      }
      a(paramat);
    }
  }
  
  private void a(h.aw paramaw)
  {
    f("Text render", new Object[0]);
    a(this.d, paramaw);
    if (!m()) {
      return;
    }
    if (paramaw.a != null) {
      this.a.concat(paramaw.a);
    }
    Object localObject = paramaw.b;
    float f5 = 0.0F;
    float f1;
    if ((localObject != null) && (paramaw.b.size() != 0)) {
      f1 = ((h.p)paramaw.b.get(0)).a(this);
    } else {
      f1 = 0.0F;
    }
    float f2;
    if ((paramaw.c != null) && (paramaw.c.size() != 0)) {
      f2 = ((h.p)paramaw.c.get(0)).b(this);
    } else {
      f2 = 0.0F;
    }
    float f3;
    if ((paramaw.d != null) && (paramaw.d.size() != 0)) {
      f3 = ((h.p)paramaw.d.get(0)).a(this);
    } else {
      f3 = 0.0F;
    }
    float f4 = f5;
    if (paramaw.e != null) {
      if (paramaw.e.size() == 0) {
        f4 = f5;
      } else {
        f4 = ((h.p)paramaw.e.get(0)).b(this);
      }
    }
    localObject = l();
    f5 = f1;
    if (localObject != h.ae.f.a)
    {
      float f6 = a(paramaw);
      f5 = f6;
      if (localObject == h.ae.f.b) {
        f5 = f6 / 2.0F;
      }
      f5 = f1 - f5;
    }
    if (paramaw.o == null)
    {
      localObject = new i.h(this, f5, f2);
      a(paramaw, (i.i)localObject);
      paramaw.o = new h.b(((i.h)localObject).c.left, ((i.h)localObject).c.top, ((i.h)localObject).c.width(), ((i.h)localObject).c.height());
    }
    a(paramaw);
    c(paramaw);
    d(paramaw);
    boolean bool = i();
    a(paramaw, new i.e(this, f5 + f3, f2 + f4));
    if (bool) {
      b(paramaw);
    }
  }
  
  private void a(h.aw paramaw, Path paramPath, Matrix paramMatrix)
  {
    a(this.d, paramaw);
    if (!m()) {
      return;
    }
    if (paramaw.a != null) {
      paramMatrix.preConcat(paramaw.a);
    }
    Object localObject = paramaw.b;
    float f5 = 0.0F;
    float f1;
    if ((localObject != null) && (paramaw.b.size() != 0)) {
      f1 = ((h.p)paramaw.b.get(0)).a(this);
    } else {
      f1 = 0.0F;
    }
    float f2;
    if ((paramaw.c != null) && (paramaw.c.size() != 0)) {
      f2 = ((h.p)paramaw.c.get(0)).b(this);
    } else {
      f2 = 0.0F;
    }
    float f3;
    if ((paramaw.d != null) && (paramaw.d.size() != 0)) {
      f3 = ((h.p)paramaw.d.get(0)).a(this);
    } else {
      f3 = 0.0F;
    }
    float f4 = f5;
    if (paramaw.e != null) {
      if (paramaw.e.size() == 0) {
        f4 = f5;
      } else {
        f4 = ((h.p)paramaw.e.get(0)).b(this);
      }
    }
    f5 = f1;
    if (this.d.a.u != h.ae.f.a)
    {
      float f6 = a(paramaw);
      f5 = f6;
      if (this.d.a.u == h.ae.f.b) {
        f5 = f6 / 2.0F;
      }
      f5 = f1 - f5;
    }
    if (paramaw.o == null)
    {
      localObject = new i.h(this, f5, f2);
      a(paramaw, (i.i)localObject);
      paramaw.o = new h.b(((i.h)localObject).c.left, ((i.h)localObject).c.top, ((i.h)localObject).c.width(), ((i.h)localObject).c.height());
    }
    d(paramaw);
    localObject = new Path();
    a(paramaw, new i.f(this, f5 + f3, f2 + f4, (Path)localObject));
    paramPath.setFillType(s());
    paramPath.addPath((Path)localObject, paramMatrix);
  }
  
  private void a(h.ay paramay, i.i parami)
  {
    if (!m()) {
      return;
    }
    paramay = paramay.i.iterator();
    for (boolean bool = true; paramay.hasNext(); bool = false)
    {
      h.an localan = (h.an)paramay.next();
      if ((localan instanceof h.bc)) {
        parami.a(a(((h.bc)localan).a, bool, paramay.hasNext() ^ true));
      } else {
        a(localan, parami);
      }
    }
  }
  
  private void a(h.ay paramay, StringBuilder paramStringBuilder)
  {
    paramay = paramay.i.iterator();
    for (boolean bool = true; paramay.hasNext(); bool = false)
    {
      h.an localan = (h.an)paramay.next();
      if ((localan instanceof h.ay)) {
        a((h.ay)localan, paramStringBuilder);
      } else if ((localan instanceof h.bc)) {
        paramStringBuilder.append(a(((h.bc)localan).a, bool, paramay.hasNext() ^ true));
      }
    }
  }
  
  private void a(h.az paramaz)
  {
    f("TextPath render", new Object[0]);
    a(this.d, paramaz);
    if (!m()) {
      return;
    }
    if (!n()) {
      return;
    }
    Object localObject1 = paramaz.u.a(paramaz.a);
    if (localObject1 == null)
    {
      e("TextPath reference '%s' not found", new Object[] { paramaz.a });
      return;
    }
    Object localObject2 = (h.v)localObject1;
    localObject1 = new i.c(((h.v)localObject2).a).a();
    if (((h.v)localObject2).e != null) {
      ((Path)localObject1).transform(((h.v)localObject2).e);
    }
    localObject2 = new PathMeasure((Path)localObject1, false);
    float f1;
    if (paramaz.b != null) {
      f1 = paramaz.b.a(this, ((PathMeasure)localObject2).getLength());
    } else {
      f1 = 0.0F;
    }
    localObject2 = l();
    float f2 = f1;
    if (localObject2 != h.ae.f.a)
    {
      float f3 = a(paramaz);
      f2 = f3;
      if (localObject2 == h.ae.f.b) {
        f2 = f3 / 2.0F;
      }
      f2 = f1 - f2;
    }
    c((h.ak)paramaz.h());
    boolean bool = i();
    a(paramaz, new i.d(this, (Path)localObject1, f2, 0.0F));
    if (bool) {
      b(paramaz);
    }
  }
  
  private void a(h.be parambe)
  {
    f("Use render", new Object[0]);
    if (((parambe.e != null) && (parambe.e.b())) || ((parambe.f != null) && (parambe.f.b()))) {
      return;
    }
    a(this.d, parambe);
    if (!m()) {
      return;
    }
    h.an localan = parambe.u.a(parambe.a);
    if (localan == null)
    {
      e("Use reference '%s' not found", new Object[] { parambe.a });
      return;
    }
    if (parambe.b != null) {
      this.a.concat(parambe.b);
    }
    Object localObject1 = parambe.c;
    float f2 = 0.0F;
    float f1;
    if (localObject1 != null) {
      f1 = parambe.c.a(this);
    } else {
      f1 = 0.0F;
    }
    if (parambe.d != null) {
      f2 = parambe.d.b(this);
    }
    this.a.translate(f1, f2);
    d(parambe);
    boolean bool = i();
    a(parambe);
    Object localObject2;
    if ((localan instanceof h.af))
    {
      localObject1 = (h.af)localan;
      localObject2 = a(null, null, parambe.e, parambe.f);
      f();
      a((h.af)localObject1, (h.b)localObject2);
      g();
    }
    else if ((localan instanceof h.at))
    {
      if (parambe.e != null) {
        localObject1 = parambe.e;
      } else {
        localObject1 = new h.p(100.0F, h.bd.i);
      }
      if (parambe.f != null) {
        localObject2 = parambe.f;
      } else {
        localObject2 = new h.p(100.0F, h.bd.i);
      }
      localObject1 = a(null, null, (h.p)localObject1, (h.p)localObject2);
      f();
      a((h.at)localan, (h.b)localObject1);
      g();
    }
    else
    {
      a(localan);
    }
    h();
    if (bool) {
      b(parambe);
    }
    a(parambe);
  }
  
  private void a(h.be parambe, Path paramPath, Matrix paramMatrix)
  {
    a(this.d, parambe);
    if (!m()) {
      return;
    }
    if (!n()) {
      return;
    }
    if (parambe.b != null) {
      paramMatrix.preConcat(parambe.b);
    }
    h.an localan = parambe.u.a(parambe.a);
    if (localan == null)
    {
      e("Use reference '%s' not found", new Object[] { parambe.a });
      return;
    }
    d(parambe);
    a(localan, false, paramPath, paramMatrix);
  }
  
  private void a(h.d paramd)
  {
    f("Circle render", new Object[0]);
    if (paramd.c != null)
    {
      if (paramd.c.b()) {
        return;
      }
      a(this.d, paramd);
      if (!m()) {
        return;
      }
      if (!n()) {
        return;
      }
      if (paramd.e != null) {
        this.a.concat(paramd.e);
      }
      Path localPath = b(paramd);
      a(paramd);
      c(paramd);
      d(paramd);
      boolean bool = i();
      if (this.d.b) {
        a(paramd, localPath);
      }
      if (this.d.c) {
        a(localPath);
      }
      if (bool) {
        b(paramd);
      }
    }
  }
  
  private void a(h.i parami)
  {
    f("Ellipse render", new Object[0]);
    if ((parami.c != null) && (parami.d != null) && (!parami.c.b()))
    {
      if (parami.d.b()) {
        return;
      }
      a(this.d, parami);
      if (!m()) {
        return;
      }
      if (!n()) {
        return;
      }
      if (parami.e != null) {
        this.a.concat(parami.e);
      }
      Path localPath = b(parami);
      a(parami);
      c(parami);
      d(parami);
      boolean bool = i();
      if (this.d.b) {
        a(parami, localPath);
      }
      if (this.d.c) {
        a(localPath);
      }
      if (bool) {
        b(parami);
      }
    }
  }
  
  private void a(h.j paramj, String paramString)
  {
    h.an localan = paramj.u.a(paramString);
    if (localan == null)
    {
      d("Gradient reference '%s' not found", new Object[] { paramString });
      return;
    }
    if (!(localan instanceof h.j))
    {
      e("Gradient href attributes must point to other gradient elements", new Object[0]);
      return;
    }
    if (localan == paramj)
    {
      e("Circular reference in gradient href attribute '%s'", new Object[] { paramString });
      return;
    }
    paramString = (h.j)localan;
    if (paramj.b == null) {
      paramj.b = paramString.b;
    }
    if (paramj.c == null) {
      paramj.c = paramString.c;
    }
    if (paramj.d == null) {
      paramj.d = paramString.d;
    }
    if (paramj.a.isEmpty()) {
      paramj.a = paramString.a;
    }
    try
    {
      if ((paramj instanceof h.am)) {
        a((h.am)paramj, (h.am)localan);
      } else {
        a((h.aq)paramj, (h.aq)localan);
      }
    }
    catch (ClassCastException localClassCastException)
    {
      label170:
      break label170;
    }
    if (paramString.e != null) {
      a(paramj, paramString.e);
    }
  }
  
  private void a(h.l paraml)
  {
    if ((this.d.a.x == null) && (this.d.a.y == null) && (this.d.a.z == null)) {
      return;
    }
    Object localObject1;
    if (this.d.a.x != null)
    {
      localObject1 = paraml.u.a(this.d.a.x);
      if (localObject1 != null) {
        localObject1 = (h.r)localObject1;
      } else {
        e("Marker reference '%s' not found", new Object[] { this.d.a.x });
      }
    }
    else
    {
      localObject1 = null;
    }
    h.r localr1;
    if (this.d.a.y != null)
    {
      localObject2 = paraml.u.a(this.d.a.y);
      if (localObject2 != null) {
        localr1 = (h.r)localObject2;
      } else {
        e("Marker reference '%s' not found", new Object[] { this.d.a.y });
      }
    }
    else
    {
      localr1 = null;
    }
    h.r localr2;
    if (this.d.a.z != null)
    {
      localObject2 = paraml.u.a(this.d.a.z);
      if (localObject2 != null) {
        localr2 = (h.r)localObject2;
      } else {
        e("Marker reference '%s' not found", new Object[] { this.d.a.z });
      }
    }
    else
    {
      localr2 = null;
    }
    if ((paraml instanceof h.v)) {
      paraml = new i.a(this, ((h.v)paraml).a).a();
    } else if ((paraml instanceof h.q)) {
      paraml = b((h.q)paraml);
    } else {
      paraml = b((h.z)paraml);
    }
    if (paraml == null) {
      return;
    }
    int k = paraml.size();
    if (k == 0) {
      return;
    }
    Object localObject2 = this.d.a;
    Object localObject3 = this.d.a;
    this.d.a.z = null;
    ((h.ae)localObject3).y = null;
    ((h.ae)localObject2).x = null;
    if (localObject1 != null) {
      a((h.r)localObject1, (i.b)paraml.get(0));
    }
    if ((localr1 != null) && (paraml.size() > 2))
    {
      localObject3 = (i.b)paraml.get(0);
      localObject1 = (i.b)paraml.get(1);
      int j = 1;
      while (j < k - 1)
      {
        j += 1;
        i.b localb = (i.b)paraml.get(j);
        localObject2 = localObject1;
        if (((i.b)localObject1).e) {
          localObject2 = a((i.b)localObject3, (i.b)localObject1, localb);
        }
        a(localr1, (i.b)localObject2);
        localObject1 = localb;
        localObject3 = localObject2;
      }
    }
    if (localr2 != null) {
      a(localr2, (i.b)paraml.get(k - 1));
    }
  }
  
  private void a(h.l paraml, Path paramPath, Matrix paramMatrix)
  {
    a(this.d, paraml);
    if (!m()) {
      return;
    }
    if (!n()) {
      return;
    }
    if (paraml.e != null) {
      paramMatrix.preConcat(paraml.e);
    }
    Path localPath;
    if ((paraml instanceof h.ab))
    {
      localPath = b((h.ab)paraml);
    }
    else if ((paraml instanceof h.d))
    {
      localPath = b((h.d)paraml);
    }
    else if ((paraml instanceof h.i))
    {
      localPath = b((h.i)paraml);
    }
    else
    {
      if (!(paraml instanceof h.z)) {
        return;
      }
      localPath = c((h.z)paraml);
    }
    d(paraml);
    paramPath.setFillType(s());
    paramPath.addPath(localPath, paramMatrix);
  }
  
  private void a(h.m paramm)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramm.a());
    localStringBuilder.append(" render");
    f(localStringBuilder.toString(), new Object[0]);
    a(this.d, paramm);
    if (!m()) {
      return;
    }
    if (paramm.b != null) {
      this.a.concat(paramm.b);
    }
    d(paramm);
    boolean bool = i();
    a(paramm, true);
    if (bool) {
      b(paramm);
    }
    a(paramm);
  }
  
  private void a(h.o paramo)
  {
    int j = 0;
    f("Image render", new Object[0]);
    if ((paramo.d != null) && (!paramo.d.b()) && (paramo.e != null))
    {
      if (paramo.e.b()) {
        return;
      }
      if (paramo.a == null) {
        return;
      }
      if (paramo.w != null) {
        localObject1 = paramo.w;
      } else {
        localObject1 = f.c;
      }
      Object localObject3 = a(paramo.a);
      Object localObject2 = localObject3;
      if (localObject3 == null)
      {
        localObject2 = h.h();
        if (localObject2 == null) {
          return;
        }
        localObject2 = ((j)localObject2).a(paramo.a);
      }
      if (localObject2 == null)
      {
        e("Could not locate image '%s'", new Object[] { paramo.a });
        return;
      }
      localObject3 = new h.b(0.0F, 0.0F, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight());
      a(this.d, paramo);
      if (!m()) {
        return;
      }
      if (!n()) {
        return;
      }
      if (paramo.f != null) {
        this.a.concat(paramo.f);
      }
      float f1;
      if (paramo.b != null) {
        f1 = paramo.b.a(this);
      } else {
        f1 = 0.0F;
      }
      float f2;
      if (paramo.c != null) {
        f2 = paramo.c.b(this);
      } else {
        f2 = 0.0F;
      }
      float f3 = paramo.d.a(this);
      float f4 = paramo.e.a(this);
      this.d.f = new h.b(f1, f2, f3, f4);
      if (!this.d.a.v.booleanValue()) {
        a(this.d.f.a, this.d.f.b, this.d.f.c, this.d.f.d);
      }
      paramo.o = this.d.f;
      a(paramo);
      d(paramo);
      boolean bool = i();
      p();
      this.a.save();
      this.a.concat(a(this.d.f, (h.b)localObject3, (f)localObject1));
      if (this.d.a.M != h.ae.e.c) {
        j = 2;
      }
      Object localObject1 = new Paint(j);
      this.a.drawBitmap((Bitmap)localObject2, 0.0F, 0.0F, (Paint)localObject1);
      this.a.restore();
      if (bool) {
        b(paramo);
      }
    }
  }
  
  private void a(h.q paramq)
  {
    f("Line render", new Object[0]);
    a(this.d, paramq);
    if (!m()) {
      return;
    }
    if (!n()) {
      return;
    }
    if (!this.d.c) {
      return;
    }
    if (paramq.e != null) {
      this.a.concat(paramq.e);
    }
    Path localPath = c(paramq);
    a(paramq);
    c(paramq);
    d(paramq);
    boolean bool = i();
    a(localPath);
    a(paramq);
    if (bool) {
      b(paramq);
    }
  }
  
  private void a(h.r paramr, i.b paramb)
  {
    f();
    Object localObject = paramr.f;
    float f7 = 0.0F;
    if (localObject != null) {
      if (Float.isNaN(paramr.f.floatValue()))
      {
        if ((paramb.c != 0.0F) || (paramb.d != 0.0F))
        {
          f1 = (float)Math.toDegrees(Math.atan2(paramb.d, paramb.c));
          break label83;
        }
      }
      else
      {
        f1 = paramr.f.floatValue();
        break label83;
      }
    }
    float f1 = 0.0F;
    label83:
    float f2;
    if (paramr.a) {
      f2 = 1.0F;
    } else {
      f2 = this.d.a.g.a(this.b);
    }
    this.d = c(paramr);
    localObject = new Matrix();
    ((Matrix)localObject).preTranslate(paramb.a, paramb.b);
    ((Matrix)localObject).preRotate(f1);
    ((Matrix)localObject).preScale(f2, f2);
    float f5;
    if (paramr.b != null) {
      f5 = paramr.b.a(this);
    } else {
      f5 = 0.0F;
    }
    float f6;
    if (paramr.c != null) {
      f6 = paramr.c.b(this);
    } else {
      f6 = 0.0F;
    }
    paramb = paramr.d;
    float f3 = 3.0F;
    if (paramb != null) {
      f2 = paramr.d.a(this);
    } else {
      f2 = 3.0F;
    }
    if (paramr.e != null) {
      f3 = paramr.e.b(this);
    }
    if (paramr.x != null)
    {
      float f8 = f2 / paramr.x.c;
      float f9 = f3 / paramr.x.d;
      if (paramr.w != null) {
        paramb = paramr.w;
      } else {
        paramb = f.c;
      }
      f1 = f8;
      float f4 = f9;
      if (!paramb.equals(f.b))
      {
        if (paramb.b() == f.b.b) {
          f1 = Math.max(f8, f9);
        } else {
          f1 = Math.min(f8, f9);
        }
        f4 = f1;
      }
      ((Matrix)localObject).preTranslate(-f5 * f1, -f6 * f4);
      this.a.concat((Matrix)localObject);
      f5 = paramr.x.c * f1;
      f6 = paramr.x.d * f4;
      switch (i.1.a[paramb.a().ordinal()])
      {
      default: 
        f5 = 0.0F;
        break;
      case 4: 
      case 5: 
      case 6: 
        f5 = f2 - f5;
        break;
      case 1: 
      case 2: 
      case 3: 
        f5 = (f2 - f5) / 2.0F;
      }
      f5 = 0.0F - f5;
      int j = i.1.a[paramb.a().ordinal()];
      if (j != 2)
      {
        if (j != 3)
        {
          if (j == 5) {
            break label556;
          }
          if (j != 6)
          {
            if (j == 7) {
              break label556;
            }
            if (j != 8)
            {
              f6 = f7;
              break label571;
            }
          }
        }
        f6 = f3 - f6;
        break label565;
      }
      label556:
      f6 = (f3 - f6) / 2.0F;
      label565:
      f6 = 0.0F - f6;
      label571:
      if (!this.d.a.v.booleanValue()) {
        a(f5, f6, f2, f3);
      }
      ((Matrix)localObject).reset();
      ((Matrix)localObject).preScale(f1, f4);
      this.a.concat((Matrix)localObject);
    }
    else
    {
      ((Matrix)localObject).preTranslate(-f5, -f6);
      this.a.concat((Matrix)localObject);
      if (!this.d.a.v.booleanValue()) {
        a(0.0F, 0.0F, f2, f3);
      }
    }
    boolean bool = i();
    a(paramr, false);
    if (bool) {
      b(paramr);
    }
    g();
  }
  
  private void a(h.s params, h.ak paramak, h.b paramb)
  {
    f("Mask render", new Object[0]);
    Object localObject = params.a;
    int k = 1;
    int j;
    if ((localObject != null) && (params.a.booleanValue())) {
      j = 1;
    } else {
      j = 0;
    }
    float f1;
    float f3;
    float f2;
    if (j != 0)
    {
      if (params.e != null) {
        f1 = params.e.a(this);
      } else {
        f1 = paramb.c;
      }
      if (params.f != null)
      {
        f3 = params.f.b(this);
        f2 = f1;
        f1 = f3;
      }
      else
      {
        f3 = paramb.d;
        f2 = f1;
        f1 = f3;
      }
    }
    else
    {
      localObject = params.e;
      f2 = 1.2F;
      if (localObject != null) {
        f1 = params.e.a(this, 1.0F);
      } else {
        f1 = 1.2F;
      }
      if (params.f != null) {
        f2 = params.f.a(this, 1.0F);
      }
      f3 = f1 * paramb.c;
      f1 = f2 * paramb.d;
      f2 = f3;
    }
    if (f2 != 0.0F)
    {
      if (f1 == 0.0F) {
        return;
      }
      f();
      this.d = c(params);
      this.d.a.m = Float.valueOf(1.0F);
      boolean bool = i();
      this.a.save();
      j = k;
      if (params.b != null) {
        if (params.b.booleanValue()) {
          j = k;
        } else {
          j = 0;
        }
      }
      if (j == 0)
      {
        this.a.translate(paramb.a, paramb.b);
        this.a.scale(paramb.c, paramb.d);
      }
      a(params, false);
      this.a.restore();
      if (bool) {
        a(paramak, paramb);
      }
      g();
    }
  }
  
  private void a(h.v paramv)
  {
    f("Path render", new Object[0]);
    if (paramv.a == null) {
      return;
    }
    a(this.d, paramv);
    if (!m()) {
      return;
    }
    if (!n()) {
      return;
    }
    if ((!this.d.c) && (!this.d.b)) {
      return;
    }
    if (paramv.e != null) {
      this.a.concat(paramv.e);
    }
    Path localPath = new i.c(paramv.a).a();
    if (paramv.o == null) {
      paramv.o = b(localPath);
    }
    a(paramv);
    c(paramv);
    d(paramv);
    boolean bool = i();
    if (this.d.b)
    {
      localPath.setFillType(o());
      a(paramv, localPath);
    }
    if (this.d.c) {
      a(localPath);
    }
    a(paramv);
    if (bool) {
      b(paramv);
    }
  }
  
  private void a(h.v paramv, Path paramPath, Matrix paramMatrix)
  {
    a(this.d, paramv);
    if (!m()) {
      return;
    }
    if (!n()) {
      return;
    }
    if (paramv.e != null) {
      paramMatrix.preConcat(paramv.e);
    }
    Path localPath = new i.c(paramv.a).a();
    if (paramv.o == null) {
      paramv.o = b(localPath);
    }
    d(paramv);
    paramPath.setFillType(s());
    paramPath.addPath(localPath, paramMatrix);
  }
  
  private void a(h.y paramy, String paramString)
  {
    h.an localan = paramy.u.a(paramString);
    if (localan == null)
    {
      d("Pattern reference '%s' not found", new Object[] { paramString });
      return;
    }
    if (!(localan instanceof h.y))
    {
      e("Pattern href attributes must point to other pattern elements", new Object[0]);
      return;
    }
    if (localan == paramy)
    {
      e("Circular reference in pattern href attribute '%s'", new Object[] { paramString });
      return;
    }
    paramString = (h.y)localan;
    if (paramy.a == null) {
      paramy.a = paramString.a;
    }
    if (paramy.b == null) {
      paramy.b = paramString.b;
    }
    if (paramy.c == null) {
      paramy.c = paramString.c;
    }
    if (paramy.d == null) {
      paramy.d = paramString.d;
    }
    if (paramy.e == null) {
      paramy.e = paramString.e;
    }
    if (paramy.f == null) {
      paramy.f = paramString.f;
    }
    if (paramy.g == null) {
      paramy.g = paramString.g;
    }
    if (paramy.i.isEmpty()) {
      paramy.i = paramString.i;
    }
    if (paramy.x == null) {
      paramy.x = paramString.x;
    }
    if (paramy.w == null) {
      paramy.w = paramString.w;
    }
    if (paramString.h != null) {
      a(paramy, paramString.h);
    }
  }
  
  private void a(h.z paramz)
  {
    f("PolyLine render", new Object[0]);
    a(this.d, paramz);
    if (!m()) {
      return;
    }
    if (!n()) {
      return;
    }
    if ((!this.d.c) && (!this.d.b)) {
      return;
    }
    if (paramz.e != null) {
      this.a.concat(paramz.e);
    }
    if (paramz.a.length < 2) {
      return;
    }
    Path localPath = c(paramz);
    a(paramz);
    localPath.setFillType(o());
    c(paramz);
    d(paramz);
    boolean bool = i();
    if (this.d.b) {
      a(paramz, localPath);
    }
    if (this.d.c) {
      a(localPath);
    }
    a(paramz);
    if (bool) {
      b(paramz);
    }
  }
  
  private void a(i.g paramg, h.ae paramae)
  {
    if (a(paramae, 4096L)) {
      paramg.a.n = paramae.n;
    }
    if (a(paramae, 2048L)) {
      paramg.a.m = paramae.m;
    }
    boolean bool1 = a(paramae, 1L);
    boolean bool2 = false;
    if (bool1)
    {
      paramg.a.b = paramae.b;
      if ((paramae.b != null) && (paramae.b != h.f.c)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramg.b = bool1;
    }
    if (a(paramae, 4L)) {
      paramg.a.d = paramae.d;
    }
    if (a(paramae, 6149L)) {
      a(paramg, true, paramg.a.b);
    }
    if (a(paramae, 2L)) {
      paramg.a.c = paramae.c;
    }
    if (a(paramae, 8L))
    {
      paramg.a.e = paramae.e;
      if ((paramae.e != null) && (paramae.e != h.f.c)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramg.c = bool1;
    }
    if (a(paramae, 16L)) {
      paramg.a.f = paramae.f;
    }
    if (a(paramae, 6168L)) {
      a(paramg, false, paramg.a.e);
    }
    if (a(paramae, 34359738368L)) {
      paramg.a.L = paramae.L;
    }
    if (a(paramae, 32L))
    {
      paramg.a.g = paramae.g;
      paramg.e.setStrokeWidth(paramg.a.g.c(this));
    }
    int j;
    if (a(paramae, 64L))
    {
      paramg.a.h = paramae.h;
      j = i.1.b[paramae.h.ordinal()];
      if (j != 1)
      {
        if (j != 2)
        {
          if (j == 3) {
            paramg.e.setStrokeCap(Paint.Cap.SQUARE);
          }
        }
        else {
          paramg.e.setStrokeCap(Paint.Cap.ROUND);
        }
      }
      else {
        paramg.e.setStrokeCap(Paint.Cap.BUTT);
      }
    }
    if (a(paramae, 128L))
    {
      paramg.a.i = paramae.i;
      j = i.1.c[paramae.i.ordinal()];
      if (j != 1)
      {
        if (j != 2)
        {
          if (j == 3) {
            paramg.e.setStrokeJoin(Paint.Join.BEVEL);
          }
        }
        else {
          paramg.e.setStrokeJoin(Paint.Join.ROUND);
        }
      }
      else {
        paramg.e.setStrokeJoin(Paint.Join.MITER);
      }
    }
    if (a(paramae, 256L))
    {
      paramg.a.j = paramae.j;
      paramg.e.setStrokeMiter(paramae.j.floatValue());
    }
    if (a(paramae, 512L)) {
      paramg.a.k = paramae.k;
    }
    if (a(paramae, 1024L)) {
      paramg.a.l = paramae.l;
    }
    bool1 = a(paramae, 1536L);
    j localj = null;
    Object localObject2 = null;
    Object localObject1;
    float f1;
    if (bool1) {
      if (paramg.a.k == null)
      {
        paramg.e.setPathEffect(null);
      }
      else
      {
        int m = paramg.a.k.length;
        if (m % 2 == 0) {
          j = m;
        } else {
          j = m * 2;
        }
        localObject1 = new float[j];
        int k = 0;
        f1 = 0.0F;
        while (k < j)
        {
          localObject1[k] = paramg.a.k[(k % m)].c(this);
          f1 += localObject1[k];
          k += 1;
        }
        if (f1 == 0.0F)
        {
          paramg.e.setPathEffect(null);
        }
        else
        {
          float f3 = paramg.a.l.c(this);
          float f2 = f3;
          if (f3 < 0.0F) {
            f2 = f3 % f1 + f1;
          }
          paramg.e.setPathEffect(new DashPathEffect((float[])localObject1, f2));
        }
      }
    }
    if (a(paramae, 16384L))
    {
      f1 = b();
      paramg.a.p = paramae.p;
      paramg.d.setTextSize(paramae.p.a(this, f1));
      paramg.e.setTextSize(paramae.p.a(this, f1));
    }
    if (a(paramae, 8192L)) {
      paramg.a.o = paramae.o;
    }
    if (a(paramae, 32768L)) {
      if ((paramae.q.intValue() == -1) && (paramg.a.q.intValue() > 100))
      {
        localObject1 = paramg.a;
        ((h.ae)localObject1).q = Integer.valueOf(((h.ae)localObject1).q.intValue() - 100);
      }
      else if ((paramae.q.intValue() == 1) && (paramg.a.q.intValue() < 900))
      {
        localObject1 = paramg.a;
        ((h.ae)localObject1).q = Integer.valueOf(((h.ae)localObject1).q.intValue() + 100);
      }
      else
      {
        paramg.a.q = paramae.q;
      }
    }
    if (a(paramae, 65536L)) {
      paramg.a.r = paramae.r;
    }
    if (a(paramae, 106496L))
    {
      localObject1 = localj;
      if (paramg.a.o != null)
      {
        localObject1 = localj;
        if (this.c != null)
        {
          localj = h.h();
          Iterator localIterator = paramg.a.o.iterator();
          do
          {
            localObject1 = localObject2;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject2 = (String)localIterator.next();
            localObject1 = a((String)localObject2, paramg.a.q, paramg.a.r);
            if ((localObject1 == null) && (localj != null)) {
              localObject1 = localj.a((String)localObject2, paramg.a.q.intValue(), String.valueOf(paramg.a.r));
            }
            localObject2 = localObject1;
          } while (localObject1 == null);
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = a("serif", paramg.a.q, paramg.a.r);
      }
      paramg.d.setTypeface((Typeface)localObject2);
      paramg.e.setTypeface((Typeface)localObject2);
    }
    if (a(paramae, 131072L))
    {
      paramg.a.s = paramae.s;
      localObject1 = paramg.d;
      if (paramae.s == h.ae.g.d) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((Paint)localObject1).setStrikeThruText(bool1);
      localObject1 = paramg.d;
      if (paramae.s == h.ae.g.b) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((Paint)localObject1).setUnderlineText(bool1);
      if (Build.VERSION.SDK_INT >= 17)
      {
        localObject1 = paramg.e;
        if (paramae.s == h.ae.g.d) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        ((Paint)localObject1).setStrikeThruText(bool1);
        localObject1 = paramg.e;
        bool1 = bool2;
        if (paramae.s == h.ae.g.b) {
          bool1 = true;
        }
        ((Paint)localObject1).setUnderlineText(bool1);
      }
    }
    if (a(paramae, 68719476736L)) {
      paramg.a.t = paramae.t;
    }
    if (a(paramae, 262144L)) {
      paramg.a.u = paramae.u;
    }
    if (a(paramae, 524288L)) {
      paramg.a.v = paramae.v;
    }
    if (a(paramae, 2097152L)) {
      paramg.a.x = paramae.x;
    }
    if (a(paramae, 4194304L)) {
      paramg.a.y = paramae.y;
    }
    if (a(paramae, 8388608L)) {
      paramg.a.z = paramae.z;
    }
    if (a(paramae, 16777216L)) {
      paramg.a.A = paramae.A;
    }
    if (a(paramae, 33554432L)) {
      paramg.a.B = paramae.B;
    }
    if (a(paramae, 1048576L)) {
      paramg.a.w = paramae.w;
    }
    if (a(paramae, 268435456L)) {
      paramg.a.E = paramae.E;
    }
    if (a(paramae, 536870912L)) {
      paramg.a.F = paramae.F;
    }
    if (a(paramae, 1073741824L)) {
      paramg.a.G = paramae.G;
    }
    if (a(paramae, 67108864L)) {
      paramg.a.C = paramae.C;
    }
    if (a(paramae, 134217728L)) {
      paramg.a.D = paramae.D;
    }
    if (a(paramae, 8589934592L)) {
      paramg.a.J = paramae.J;
    }
    if (a(paramae, 17179869184L)) {
      paramg.a.K = paramae.K;
    }
    if (a(paramae, 137438953472L)) {
      paramg.a.M = paramae.M;
    }
  }
  
  private void a(i.g paramg, h.al paramal)
  {
    boolean bool;
    if (paramal.v == null) {
      bool = true;
    } else {
      bool = false;
    }
    paramg.a.a(bool);
    if (paramal.r != null) {
      a(paramg, paramal.r);
    }
    if (this.c.f())
    {
      Iterator localIterator = this.c.e().iterator();
      while (localIterator.hasNext())
      {
        b.o localo = (b.o)localIterator.next();
        if (b.a(this.i, localo.a, paramal)) {
          a(paramg, localo.b);
        }
      }
    }
    if (paramal.s != null) {
      a(paramg, paramal.s);
    }
  }
  
  private void a(i.g paramg, boolean paramBoolean, h.ao paramao)
  {
    Float localFloat;
    if (paramBoolean) {
      localFloat = paramg.a.d;
    } else {
      localFloat = paramg.a.f;
    }
    float f1 = localFloat.floatValue();
    if ((paramao instanceof h.f))
    {
      j = ((h.f)paramao).a;
    }
    else
    {
      if (!(paramao instanceof h.g)) {
        return;
      }
      j = paramg.a.n.a;
    }
    int j = a(j, f1);
    if (paramBoolean)
    {
      paramg.d.setColor(j);
      return;
    }
    paramg.e.setColor(j);
  }
  
  private void a(boolean paramBoolean, h.ac paramac)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    i.g localg;
    if (paramBoolean)
    {
      if (a(paramac.r, 2147483648L))
      {
        this.d.a.b = paramac.r.H;
        localg = this.d;
        if (paramac.r.H == null) {
          bool1 = false;
        }
        localg.b = bool1;
      }
      if (a(paramac.r, 4294967296L)) {
        this.d.a.d = paramac.r.I;
      }
      if (a(paramac.r, 6442450944L))
      {
        paramac = this.d;
        a(paramac, paramBoolean, paramac.a.b);
      }
    }
    else
    {
      if (a(paramac.r, 2147483648L))
      {
        this.d.a.e = paramac.r.H;
        localg = this.d;
        if (paramac.r.H != null) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
        localg.c = bool1;
      }
      if (a(paramac.r, 4294967296L)) {
        this.d.a.f = paramac.r.I;
      }
      if (a(paramac.r, 6442450944L))
      {
        paramac = this.d;
        a(paramac, paramBoolean, paramac.a.e);
      }
    }
  }
  
  private void a(boolean paramBoolean, h.b paramb, h.am paramam)
  {
    if (paramam.e != null) {
      a(paramam, paramam.e);
    }
    Object localObject1 = paramam.b;
    int k = 0;
    if ((localObject1 != null) && (paramam.b.booleanValue())) {
      j = 1;
    } else {
      j = 0;
    }
    if (paramBoolean) {
      localObject1 = this.d.d;
    } else {
      localObject1 = this.d.e;
    }
    float f1;
    float f2;
    float f4;
    float f3;
    float f5;
    if (j != 0)
    {
      localObject2 = d();
      if (paramam.f != null) {
        f1 = paramam.f.a(this);
      } else {
        f1 = 0.0F;
      }
      if (paramam.g != null) {
        f2 = paramam.g.b(this);
      } else {
        f2 = 0.0F;
      }
      if (paramam.h != null) {
        f4 = paramam.h.a(this);
      } else {
        f4 = ((h.b)localObject2).c;
      }
      if (paramam.i != null) {
        f3 = paramam.i.b(this);
      } else {
        f3 = 0.0F;
      }
      f6 = f2;
      f5 = f3;
      f2 = f1;
      f3 = f6;
    }
    else
    {
      if (paramam.f != null) {
        f1 = paramam.f.a(this, 1.0F);
      } else {
        f1 = 0.0F;
      }
      if (paramam.g != null) {
        f2 = paramam.g.a(this, 1.0F);
      } else {
        f2 = 0.0F;
      }
      if (paramam.h != null) {
        f3 = paramam.h.a(this, 1.0F);
      } else {
        f3 = 1.0F;
      }
      if (paramam.i != null) {
        f4 = paramam.i.a(this, 1.0F);
      } else {
        f4 = 0.0F;
      }
      f5 = f4;
      f4 = f3;
      f3 = f2;
      f2 = f1;
    }
    f();
    this.d = c(paramam);
    Matrix localMatrix = new Matrix();
    if (j == 0)
    {
      localMatrix.preTranslate(paramb.a, paramb.b);
      localMatrix.preScale(paramb.c, paramb.d);
    }
    if (paramam.c != null) {
      localMatrix.preConcat(paramam.c);
    }
    int m = paramam.a.size();
    if (m == 0)
    {
      g();
      if (paramBoolean)
      {
        this.d.b = false;
        return;
      }
      this.d.c = false;
      return;
    }
    int[] arrayOfInt = new int[m];
    float[] arrayOfFloat = new float[m];
    float f6 = -1.0F;
    Iterator localIterator = paramam.a.iterator();
    int j = k;
    while (localIterator.hasNext())
    {
      paramb = (h.ad)localIterator.next();
      if (paramb.a != null) {
        f1 = paramb.a.floatValue();
      } else {
        f1 = 0.0F;
      }
      if ((j != 0) && (f1 < f6))
      {
        arrayOfFloat[j] = f6;
        f1 = f6;
      }
      else
      {
        arrayOfFloat[j] = f1;
      }
      f();
      a(this.d, paramb);
      localObject2 = (h.f)this.d.a.C;
      paramb = (h.b)localObject2;
      if (localObject2 == null) {
        paramb = h.f.b;
      }
      arrayOfInt[j] = a(paramb.a, this.d.a.D.floatValue());
      j += 1;
      g();
      f6 = f1;
    }
    if (((f2 == f4) && (f3 == f5)) || (m == 1))
    {
      g();
      ((Paint)localObject1).setColor(arrayOfInt[(m - 1)]);
      return;
    }
    Object localObject2 = Shader.TileMode.CLAMP;
    paramb = (h.b)localObject2;
    if (paramam.d != null) {
      if (paramam.d == h.k.b)
      {
        paramb = Shader.TileMode.MIRROR;
      }
      else
      {
        paramb = (h.b)localObject2;
        if (paramam.d == h.k.c) {
          paramb = Shader.TileMode.REPEAT;
        }
      }
    }
    g();
    paramb = new LinearGradient(f2, f3, f4, f5, arrayOfInt, arrayOfFloat, paramb);
    paramb.setLocalMatrix(localMatrix);
    ((Paint)localObject1).setShader(paramb);
    ((Paint)localObject1).setAlpha(a(this.d.a.d.floatValue()));
  }
  
  private void a(boolean paramBoolean, h.b paramb, h.aq paramaq)
  {
    if (paramaq.e != null) {
      a(paramaq, paramaq.e);
    }
    Object localObject1 = paramaq.b;
    int k = 0;
    if ((localObject1 != null) && (paramaq.b.booleanValue())) {
      j = 1;
    } else {
      j = 0;
    }
    if (paramBoolean) {
      localObject1 = this.d.d;
    } else {
      localObject1 = this.d.e;
    }
    Object localObject2;
    float f1;
    float f2;
    float f4;
    float f3;
    if (j != 0)
    {
      localObject2 = new h.p(50.0F, h.bd.i);
      if (paramaq.f != null) {
        f1 = paramaq.f.a(this);
      } else {
        f1 = ((h.p)localObject2).a(this);
      }
      if (paramaq.g != null) {
        f2 = paramaq.g.b(this);
      } else {
        f2 = ((h.p)localObject2).b(this);
      }
      if (paramaq.h != null) {
        localObject2 = paramaq.h;
      }
      f4 = ((h.p)localObject2).c(this);
      f3 = f2;
      f2 = f1;
    }
    else
    {
      if (paramaq.f != null) {
        f1 = paramaq.f.a(this, 1.0F);
      } else {
        f1 = 0.5F;
      }
      if (paramaq.g != null) {
        f2 = paramaq.g.a(this, 1.0F);
      } else {
        f2 = 0.5F;
      }
      if (paramaq.h != null) {
        f3 = paramaq.h.a(this, 1.0F);
      } else {
        f3 = 0.5F;
      }
      f4 = f3;
      f3 = f2;
      f2 = f1;
    }
    f();
    this.d = c(paramaq);
    Matrix localMatrix = new Matrix();
    if (j == 0)
    {
      localMatrix.preTranslate(paramb.a, paramb.b);
      localMatrix.preScale(paramb.c, paramb.d);
    }
    if (paramaq.c != null) {
      localMatrix.preConcat(paramaq.c);
    }
    int m = paramaq.a.size();
    if (m == 0)
    {
      g();
      if (paramBoolean)
      {
        this.d.b = false;
        return;
      }
      this.d.c = false;
      return;
    }
    int[] arrayOfInt = new int[m];
    float[] arrayOfFloat = new float[m];
    float f5 = -1.0F;
    Iterator localIterator = paramaq.a.iterator();
    int j = k;
    for (;;)
    {
      paramBoolean = localIterator.hasNext();
      f1 = 0.0F;
      if (!paramBoolean) {
        break;
      }
      paramb = (h.ad)localIterator.next();
      if (paramb.a != null) {
        f1 = paramb.a.floatValue();
      }
      if ((j != 0) && (f1 < f5))
      {
        arrayOfFloat[j] = f5;
        f1 = f5;
      }
      else
      {
        arrayOfFloat[j] = f1;
      }
      f();
      a(this.d, paramb);
      localObject2 = (h.f)this.d.a.C;
      paramb = (h.b)localObject2;
      if (localObject2 == null) {
        paramb = h.f.b;
      }
      arrayOfInt[j] = a(paramb.a, this.d.a.D.floatValue());
      j += 1;
      g();
      f5 = f1;
    }
    if ((f4 != 0.0F) && (m != 1))
    {
      localObject2 = Shader.TileMode.CLAMP;
      paramb = (h.b)localObject2;
      if (paramaq.d != null) {
        if (paramaq.d == h.k.b)
        {
          paramb = Shader.TileMode.MIRROR;
        }
        else
        {
          paramb = (h.b)localObject2;
          if (paramaq.d == h.k.c) {
            paramb = Shader.TileMode.REPEAT;
          }
        }
      }
      g();
      paramb = new RadialGradient(f2, f3, f4, arrayOfInt, arrayOfFloat, paramb);
      paramb.setLocalMatrix(localMatrix);
      ((Paint)localObject1).setShader(paramb);
      ((Paint)localObject1).setAlpha(a(this.d.a.d.floatValue()));
      return;
    }
    g();
    ((Paint)localObject1).setColor(arrayOfInt[(m - 1)]);
  }
  
  private void a(boolean paramBoolean, h.b paramb, h.u paramu)
  {
    h.an localan = this.c.a(paramu.a);
    if (localan == null)
    {
      if (paramBoolean) {
        paramb = "Fill";
      } else {
        paramb = "Stroke";
      }
      e("%s reference '%s' not found", new Object[] { paramb, paramu.a });
      if (paramu.b != null)
      {
        a(this.d, paramBoolean, paramu.b);
        return;
      }
      if (paramBoolean)
      {
        this.d.b = false;
        return;
      }
      this.d.c = false;
      return;
    }
    if ((localan instanceof h.am))
    {
      a(paramBoolean, paramb, (h.am)localan);
      return;
    }
    if ((localan instanceof h.aq))
    {
      a(paramBoolean, paramb, (h.aq)localan);
      return;
    }
    if ((localan instanceof h.ac)) {
      a(paramBoolean, (h.ac)localan);
    }
  }
  
  private boolean a(h.ae paramae, long paramLong)
  {
    return (paramLong & paramae.a) != 0L;
  }
  
  private static float[] a(double paramDouble1, double paramDouble2)
  {
    int m = (int)Math.ceil(Math.abs(paramDouble2) * 2.0D / 3.141592653589793D);
    double d1 = m;
    Double.isNaN(d1);
    paramDouble2 /= d1;
    d1 = paramDouble2 / 2.0D;
    d1 = Math.sin(d1) * 1.333333333333333D / (Math.cos(d1) + 1.0D);
    float[] arrayOfFloat = new float[m * 6];
    int j = 0;
    int k = 0;
    while (j < m)
    {
      double d2 = j;
      Double.isNaN(d2);
      d2 = paramDouble1 + d2 * paramDouble2;
      double d3 = Math.cos(d2);
      double d4 = Math.sin(d2);
      int n = k + 1;
      arrayOfFloat[k] = ((float)(d3 - d1 * d4));
      k = n + 1;
      arrayOfFloat[n] = ((float)(d4 + d3 * d1));
      d3 = d2 + paramDouble2;
      d2 = Math.cos(d3);
      d3 = Math.sin(d3);
      n = k + 1;
      arrayOfFloat[k] = ((float)(d1 * d3 + d2));
      k = n + 1;
      arrayOfFloat[n] = ((float)(d3 - d1 * d2));
      n = k + 1;
      arrayOfFloat[k] = ((float)d2);
      k = n + 1;
      arrayOfFloat[n] = ((float)d3);
      j += 1;
    }
    return arrayOfFloat;
  }
  
  private float b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return paramFloat1 * paramFloat3 + paramFloat2 * paramFloat4;
  }
  
  private Path b(h.ab paramab)
  {
    float f1;
    float f2;
    if ((paramab.f == null) && (paramab.g == null))
    {
      f1 = 0.0F;
      f2 = 0.0F;
    }
    else
    {
      if (paramab.f == null) {}
      for (f1 = paramab.g.b(this);; f1 = paramab.f.a(this))
      {
        f2 = f1;
        break label79;
        if (paramab.g != null) {
          break;
        }
      }
      f1 = paramab.f.a(this);
      f2 = paramab.g.b(this);
    }
    label79:
    float f4 = Math.min(f1, paramab.c.a(this) / 2.0F);
    float f3 = Math.min(f2, paramab.d.b(this) / 2.0F);
    if (paramab.a != null) {
      f1 = paramab.a.a(this);
    } else {
      f1 = 0.0F;
    }
    if (paramab.b != null) {
      f2 = paramab.b.b(this);
    } else {
      f2 = 0.0F;
    }
    float f5 = paramab.c.a(this);
    float f6 = paramab.d.b(this);
    if (paramab.o == null) {
      paramab.o = new h.b(f1, f2, f5, f6);
    }
    f5 = f1 + f5;
    f6 = f2 + f6;
    paramab = new Path();
    h.ab localab;
    if ((f4 != 0.0F) && (f3 != 0.0F))
    {
      float f12 = f4 * 0.5522848F;
      float f10 = 0.5522848F * f3;
      float f7 = f2 + f3;
      paramab.moveTo(f1, f7);
      float f11 = f7 - f10;
      float f8 = f1 + f4;
      float f9 = f8 - f12;
      paramab.cubicTo(f1, f11, f9, f2, f8, f2);
      f4 = f5 - f4;
      paramab.lineTo(f4, f2);
      f12 = f4 + f12;
      paramab.cubicTo(f12, f2, f5, f11, f5, f7);
      f2 = f6 - f3;
      paramab.lineTo(f5, f2);
      f3 = f10 + f2;
      localab = paramab;
      paramab.cubicTo(f5, f3, f12, f6, f4, f6);
      localab.lineTo(f8, f6);
      localab.cubicTo(f9, f6, f1, f3, f1, f2);
      localab.lineTo(f1, f7);
    }
    else
    {
      localab = paramab;
      localab.moveTo(f1, f2);
      localab.lineTo(f5, f2);
      localab.lineTo(f5, f6);
      localab.lineTo(f1, f6);
      localab.lineTo(f1, f2);
    }
    paramab.close();
    return paramab;
  }
  
  private Path b(h.aw paramaw)
  {
    Object localObject = paramaw.b;
    float f5 = 0.0F;
    float f1;
    if ((localObject != null) && (paramaw.b.size() != 0)) {
      f1 = ((h.p)paramaw.b.get(0)).a(this);
    } else {
      f1 = 0.0F;
    }
    float f2;
    if ((paramaw.c != null) && (paramaw.c.size() != 0)) {
      f2 = ((h.p)paramaw.c.get(0)).b(this);
    } else {
      f2 = 0.0F;
    }
    float f3;
    if ((paramaw.d != null) && (paramaw.d.size() != 0)) {
      f3 = ((h.p)paramaw.d.get(0)).a(this);
    } else {
      f3 = 0.0F;
    }
    float f4 = f5;
    if (paramaw.e != null) {
      if (paramaw.e.size() == 0) {
        f4 = f5;
      } else {
        f4 = ((h.p)paramaw.e.get(0)).b(this);
      }
    }
    f5 = f1;
    if (this.d.a.u != h.ae.f.a)
    {
      float f6 = a(paramaw);
      f5 = f6;
      if (this.d.a.u == h.ae.f.b) {
        f5 = f6 / 2.0F;
      }
      f5 = f1 - f5;
    }
    if (paramaw.o == null)
    {
      localObject = new i.h(this, f5, f2);
      a(paramaw, (i.i)localObject);
      paramaw.o = new h.b(((i.h)localObject).c.left, ((i.h)localObject).c.top, ((i.h)localObject).c.width(), ((i.h)localObject).c.height());
    }
    localObject = new Path();
    a(paramaw, new i.f(this, f5 + f3, f2 + f4, (Path)localObject));
    return localObject;
  }
  
  private Path b(h.d paramd)
  {
    h.p localp = paramd.a;
    float f2 = 0.0F;
    float f1;
    if (localp != null) {
      f1 = paramd.a.a(this);
    } else {
      f1 = 0.0F;
    }
    if (paramd.b != null) {
      f2 = paramd.b.b(this);
    }
    float f7 = paramd.c.c(this);
    float f3 = f1 - f7;
    float f4 = f2 - f7;
    float f6 = f1 + f7;
    float f5 = f2 + f7;
    if (paramd.o == null)
    {
      f8 = 2.0F * f7;
      paramd.o = new h.b(f3, f4, f8, f8);
    }
    float f9 = 0.5522848F * f7;
    paramd = new Path();
    paramd.moveTo(f1, f4);
    float f10 = f1 + f9;
    f7 = f2 - f9;
    paramd.cubicTo(f10, f4, f6, f7, f6, f2);
    float f8 = f2 + f9;
    paramd.cubicTo(f6, f8, f10, f5, f1, f5);
    f6 = f1 - f9;
    paramd.cubicTo(f6, f5, f3, f8, f3, f2);
    paramd.cubicTo(f3, f7, f6, f4, f1, f4);
    paramd.close();
    return paramd;
  }
  
  private Path b(h.i parami)
  {
    h.p localp = parami.a;
    float f2 = 0.0F;
    float f1;
    if (localp != null) {
      f1 = parami.a.a(this);
    } else {
      f1 = 0.0F;
    }
    if (parami.b != null) {
      f2 = parami.b.b(this);
    }
    float f7 = parami.c.a(this);
    float f8 = parami.d.b(this);
    float f3 = f1 - f7;
    float f4 = f2 - f8;
    float f6 = f1 + f7;
    float f5 = f2 + f8;
    if (parami.o == null) {
      parami.o = new h.b(f3, f4, f7 * 2.0F, 2.0F * f8);
    }
    f7 *= 0.5522848F;
    float f10 = 0.5522848F * f8;
    parami = new Path();
    parami.moveTo(f1, f4);
    float f9 = f1 + f7;
    f8 = f2 - f10;
    parami.cubicTo(f9, f4, f6, f8, f6, f2);
    f10 += f2;
    parami.cubicTo(f6, f10, f9, f5, f1, f5);
    f6 = f1 - f7;
    parami.cubicTo(f6, f5, f3, f10, f3, f2);
    parami.cubicTo(f3, f8, f6, f4, f1, f4);
    parami.close();
    return parami;
  }
  
  private h.b b(Path paramPath)
  {
    RectF localRectF = new RectF();
    paramPath.computeBounds(localRectF, true);
    return new h.b(localRectF.left, localRectF.top, localRectF.width(), localRectF.height());
  }
  
  private List<i.b> b(h.q paramq)
  {
    float f1;
    if (paramq.a != null) {
      f1 = paramq.a.a(this);
    } else {
      f1 = 0.0F;
    }
    float f2;
    if (paramq.b != null) {
      f2 = paramq.b.b(this);
    } else {
      f2 = 0.0F;
    }
    float f3;
    if (paramq.c != null) {
      f3 = paramq.c.a(this);
    } else {
      f3 = 0.0F;
    }
    float f4;
    if (paramq.d != null) {
      f4 = paramq.d.b(this);
    } else {
      f4 = 0.0F;
    }
    paramq = new ArrayList(2);
    float f5 = f3 - f1;
    float f6 = f4 - f2;
    paramq.add(new i.b(this, f1, f2, f5, f6));
    paramq.add(new i.b(this, f3, f4, f5, f6));
    return paramq;
  }
  
  private List<i.b> b(h.z paramz)
  {
    int k = paramz.a.length;
    int j = 2;
    if (k < 2) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    i.b localb = new i.b(this, paramz.a[0], paramz.a[1], 0.0F, 0.0F);
    float f1 = 0.0F;
    float f2 = 0.0F;
    while (j < k)
    {
      f1 = paramz.a[j];
      f2 = paramz.a[(j + 1)];
      localb.a(f1, f2);
      localArrayList.add(localb);
      localb = new i.b(this, f1, f2, f1 - localb.a, f2 - localb.b);
      j += 2;
    }
    if ((paramz instanceof h.aa))
    {
      if ((f1 != paramz.a[0]) && (f2 != paramz.a[1]))
      {
        f1 = paramz.a[0];
        f2 = paramz.a[1];
        localb.a(f1, f2);
        localArrayList.add(localb);
        paramz = new i.b(this, f1, f2, f1 - localb.a, f2 - localb.b);
        paramz.a((i.b)localArrayList.get(0));
        localArrayList.add(paramz);
        localArrayList.set(0, paramz);
        return localArrayList;
      }
    }
    else {
      localArrayList.add(localb);
    }
    return localArrayList;
  }
  
  private static void b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, boolean paramBoolean1, boolean paramBoolean2, float paramFloat6, float paramFloat7, h.x paramx)
  {
    if ((paramFloat1 == paramFloat6) && (paramFloat2 == paramFloat7)) {
      return;
    }
    if ((paramFloat3 != 0.0F) && (paramFloat4 != 0.0F))
    {
      float f1 = Math.abs(paramFloat3);
      float f2 = Math.abs(paramFloat4);
      double d1 = paramFloat5;
      Double.isNaN(d1);
      d1 = Math.toRadians(d1 % 360.0D);
      double d5 = Math.cos(d1);
      double d6 = Math.sin(d1);
      d1 = paramFloat1 - paramFloat6;
      Double.isNaN(d1);
      d1 /= 2.0D;
      double d2 = paramFloat2 - paramFloat7;
      Double.isNaN(d2);
      d2 /= 2.0D;
      double d7 = d5 * d1 + d6 * d2;
      double d8 = -d6 * d1 + d2 * d5;
      d1 = f1 * f1;
      d2 = f2 * f2;
      double d9 = d7 * d7;
      double d10 = d8 * d8;
      Double.isNaN(d1);
      double d3 = d9 / d1;
      Double.isNaN(d2);
      d3 += d10 / d2;
      paramFloat4 = f1;
      paramFloat3 = f2;
      if (d3 > 0.9999900000000001D)
      {
        d1 = Math.sqrt(d3) * 1.00001D;
        d2 = f1;
        Double.isNaN(d2);
        paramFloat4 = (float)(d2 * d1);
        d2 = f2;
        Double.isNaN(d2);
        paramFloat3 = (float)(d1 * d2);
        d1 = paramFloat4 * paramFloat4;
        d2 = paramFloat3 * paramFloat3;
      }
      double d4 = -1.0D;
      if (paramBoolean1 == paramBoolean2) {
        d3 = -1.0D;
      } else {
        d3 = 1.0D;
      }
      d10 = d1 * d10;
      d9 = d2 * d9;
      d2 = (d1 * d2 - d10 - d9) / (d10 + d9);
      d1 = d2;
      if (d2 < 0.0D) {
        d1 = 0.0D;
      }
      d3 *= Math.sqrt(d1);
      d2 = paramFloat4;
      Double.isNaN(d2);
      d1 = paramFloat3;
      Double.isNaN(d1);
      d9 = d2 * d8 / d1 * d3;
      Double.isNaN(d1);
      Double.isNaN(d2);
      d10 = d3 * -(d1 * d7 / d2);
      d3 = paramFloat1 + paramFloat6;
      Double.isNaN(d3);
      double d11 = d3 / 2.0D;
      d3 = paramFloat2 + paramFloat7;
      Double.isNaN(d3);
      double d12 = d3 / 2.0D;
      Double.isNaN(d2);
      d3 = (d7 - d9) / d2;
      Double.isNaN(d1);
      double d13 = (d8 - d10) / d1;
      d7 = -d7;
      Double.isNaN(d2);
      d7 = (d7 - d9) / d2;
      d2 = -d8;
      Double.isNaN(d1);
      double d14 = (d2 - d10) / d1;
      d1 = d3 * d3 + d13 * d13;
      d8 = Math.sqrt(d1);
      if (d13 < 0.0D) {
        d2 = -1.0D;
      } else {
        d2 = 1.0D;
      }
      d8 = Math.acos(d3 / d8);
      double d15 = Math.sqrt(d1 * (d7 * d7 + d14 * d14));
      if (d3 * d14 - d13 * d7 < 0.0D) {
        d1 = d4;
      } else {
        d1 = 1.0D;
      }
      d3 = d1 * a((d3 * d7 + d13 * d14) / d15);
      if (d3 == 0.0D)
      {
        paramx.b(paramFloat6, paramFloat7);
        return;
      }
      if ((!paramBoolean2) && (d3 > 0.0D))
      {
        d1 = d3 - 6.283185307179586D;
      }
      else
      {
        d1 = d3;
        if (paramBoolean2)
        {
          d1 = d3;
          if (d3 < 0.0D) {
            d1 = d3 + 6.283185307179586D;
          }
        }
      }
      float[] arrayOfFloat = a(d2 * d8 % 6.283185307179586D, d1 % 6.283185307179586D);
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(paramFloat4, paramFloat3);
      localMatrix.postRotate(paramFloat5);
      localMatrix.postTranslate((float)(d11 + (d5 * d9 - d6 * d10)), (float)(d12 + (d6 * d9 + d5 * d10)));
      localMatrix.mapPoints(arrayOfFloat);
      arrayOfFloat[(arrayOfFloat.length - 2)] = paramFloat6;
      arrayOfFloat[(arrayOfFloat.length - 1)] = paramFloat7;
      int j = 0;
      while (j < arrayOfFloat.length)
      {
        paramx.a(arrayOfFloat[j], arrayOfFloat[(j + 1)], arrayOfFloat[(j + 2)], arrayOfFloat[(j + 3)], arrayOfFloat[(j + 4)], arrayOfFloat[(j + 5)]);
        j += 6;
      }
      return;
    }
    paramx.b(paramFloat6, paramFloat7);
  }
  
  private void b(h.ak paramak)
  {
    a(paramak, paramak.o);
  }
  
  private void b(h.ak paramak, h.b paramb)
  {
    if (this.d.a.E == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramak = c(paramak, paramb);
      if (paramak != null) {
        this.a.clipPath(paramak);
      }
    }
    else
    {
      d(paramak, paramb);
    }
  }
  
  private void b(h.an paraman)
  {
    if (!(paraman instanceof h.al)) {
      return;
    }
    paraman = (h.al)paraman;
    if (paraman.q != null) {
      this.d.h = paraman.q.booleanValue();
    }
  }
  
  private void b(h.as paramas)
  {
    String str = Locale.getDefault().getLanguage();
    j localj = h.h();
    paramas = paramas.b().iterator();
    while (paramas.hasNext())
    {
      h.an localan = (h.an)paramas.next();
      if ((localan instanceof h.ag))
      {
        Object localObject1 = (h.ag)localan;
        if (((h.ag)localObject1).d() == null)
        {
          Object localObject2 = ((h.ag)localObject1).e();
          if ((localObject2 == null) || ((!((Set)localObject2).isEmpty()) && (((Set)localObject2).contains(str))))
          {
            localObject2 = ((h.ag)localObject1).c();
            if (localObject2 != null)
            {
              if (h == null) {
                k();
              }
              if ((((Set)localObject2).isEmpty()) || (!h.containsAll((Collection)localObject2))) {
                break;
              }
            }
            else
            {
              localObject2 = ((h.ag)localObject1).f();
              if (localObject2 != null)
              {
                if ((!((Set)localObject2).isEmpty()) && (localj != null))
                {
                  localObject2 = ((Set)localObject2).iterator();
                  for (;;)
                  {
                    if (((Iterator)localObject2).hasNext()) {
                      if (!localj.c((String)((Iterator)localObject2).next())) {
                        break;
                      }
                    }
                  }
                }
              }
              else
              {
                localObject1 = ((h.ag)localObject1).g();
                if (localObject1 != null)
                {
                  if ((!((Set)localObject1).isEmpty()) && (localj != null))
                  {
                    localObject1 = ((Set)localObject1).iterator();
                    for (;;)
                    {
                      if (((Iterator)localObject1).hasNext()) {
                        if (localj.a((String)((Iterator)localObject1).next(), this.d.a.q.intValue(), String.valueOf(this.d.a.r)) == null) {
                          break;
                        }
                      }
                    }
                  }
                }
                else {
                  a(localan);
                }
              }
            }
          }
        }
      }
    }
  }
  
  @TargetApi(19)
  private Path c(h.ak paramak, h.b paramb)
  {
    paramak = paramak.u.a(this.d.a.E);
    int j = 0;
    if (paramak == null)
    {
      e("ClipPath reference '%s' not found", new Object[] { this.d.a.E });
      return null;
    }
    Object localObject1 = (h.e)paramak;
    this.e.push(this.d);
    this.d = c((h.an)localObject1);
    if ((((h.e)localObject1).a == null) || (((h.e)localObject1).a.booleanValue())) {
      j = 1;
    }
    paramak = new Matrix();
    if (j == 0)
    {
      paramak.preTranslate(paramb.a, paramb.b);
      paramak.preScale(paramb.c, paramb.d);
    }
    if (((h.e)localObject1).b != null) {
      paramak.preConcat(((h.e)localObject1).b);
    }
    paramb = new Path();
    Iterator localIterator = ((h.e)localObject1).i.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (h.an)localIterator.next();
      if ((localObject2 instanceof h.ak))
      {
        localObject2 = a((h.ak)localObject2, true);
        if (localObject2 != null) {
          paramb.op((Path)localObject2, Path.Op.UNION);
        }
      }
    }
    if (this.d.a.E != null)
    {
      if (((h.e)localObject1).o == null) {
        ((h.e)localObject1).o = b(paramb);
      }
      localObject1 = c((h.ak)localObject1, ((h.e)localObject1).o);
      if (localObject1 != null) {
        paramb.op((Path)localObject1, Path.Op.INTERSECT);
      }
    }
    paramb.transform(paramak);
    this.d = ((i.g)this.e.pop());
    return paramb;
  }
  
  private Path c(h.q paramq)
  {
    h.p localp = paramq.a;
    float f4 = 0.0F;
    float f1;
    if (localp == null) {
      f1 = 0.0F;
    } else {
      f1 = paramq.a.a(this);
    }
    float f2;
    if (paramq.b == null) {
      f2 = 0.0F;
    } else {
      f2 = paramq.b.b(this);
    }
    float f3;
    if (paramq.c == null) {
      f3 = 0.0F;
    } else {
      f3 = paramq.c.a(this);
    }
    if (paramq.d != null) {
      f4 = paramq.d.b(this);
    }
    if (paramq.o == null) {
      paramq.o = new h.b(Math.min(f1, f3), Math.min(f2, f4), Math.abs(f3 - f1), Math.abs(f4 - f2));
    }
    paramq = new Path();
    paramq.moveTo(f1, f2);
    paramq.lineTo(f3, f4);
    return paramq;
  }
  
  private Path c(h.z paramz)
  {
    Path localPath = new Path();
    localPath.moveTo(paramz.a[0], paramz.a[1]);
    int j = 2;
    while (j < paramz.a.length)
    {
      localPath.lineTo(paramz.a[j], paramz.a[(j + 1)]);
      j += 2;
    }
    if ((paramz instanceof h.aa)) {
      localPath.close();
    }
    if (paramz.o == null) {
      paramz.o = b(localPath);
    }
    return localPath;
  }
  
  private i.g c(h.an paraman)
  {
    i.g localg = new i.g(this);
    a(localg, h.ae.a());
    return a(paraman, localg);
  }
  
  private void c(h.ak paramak)
  {
    if ((this.d.a.b instanceof h.u)) {
      a(true, paramak.o, (h.u)this.d.a.b);
    }
    if ((this.d.a.e instanceof h.u)) {
      a(false, paramak.o, (h.u)this.d.a.e);
    }
  }
  
  private void d(h.ak paramak)
  {
    b(paramak, paramak.o);
  }
  
  private void d(h.ak paramak, h.b paramb)
  {
    Object localObject = paramak.u.a(this.d.a.E);
    if (localObject == null)
    {
      e("ClipPath reference '%s' not found", new Object[] { this.d.a.E });
      return;
    }
    localObject = (h.e)localObject;
    if (((h.e)localObject).i.isEmpty())
    {
      this.a.clipRect(0, 0, 0, 0);
      return;
    }
    int j;
    if ((((h.e)localObject).a != null) && (!((h.e)localObject).a.booleanValue())) {
      j = 0;
    } else {
      j = 1;
    }
    if (((paramak instanceof h.m)) && (j == 0))
    {
      d("<clipPath clipPathUnits=\"objectBoundingBox\"> is not supported when referenced from container elements (like %s)", new Object[] { paramak.a() });
      return;
    }
    q();
    if (j == 0)
    {
      paramak = new Matrix();
      paramak.preTranslate(paramb.a, paramb.b);
      paramak.preScale(paramb.c, paramb.d);
      this.a.concat(paramak);
    }
    if (((h.e)localObject).b != null) {
      this.a.concat(((h.e)localObject).b);
    }
    this.d = c((h.an)localObject);
    d((h.ak)localObject);
    paramak = new Path();
    paramb = ((h.e)localObject).i.iterator();
    while (paramb.hasNext()) {
      a((h.an)paramb.next(), true, paramak, new Matrix());
    }
    this.a.clipPath(paramak);
    r();
  }
  
  private static void d(String paramString, Object... paramVarArgs)
  {
    Log.w("SVGAndroidRenderer", String.format(paramString, paramVarArgs));
  }
  
  private void e()
  {
    this.d = new i.g(this);
    this.e = new Stack();
    a(this.d, h.ae.a());
    i.g localg = this.d;
    localg.f = null;
    localg.h = false;
    this.e.push(new i.g(this, localg));
    this.g = new Stack();
    this.f = new Stack();
  }
  
  private static void e(String paramString, Object... paramVarArgs)
  {
    Log.e("SVGAndroidRenderer", String.format(paramString, paramVarArgs));
  }
  
  private void f()
  {
    this.a.save();
    this.e.push(this.d);
    this.d = new i.g(this, this.d);
  }
  
  private static void f(String paramString, Object... paramVarArgs) {}
  
  private void g()
  {
    this.a.restore();
    this.d = ((i.g)this.e.pop());
  }
  
  private void h()
  {
    this.f.pop();
    this.g.pop();
  }
  
  private boolean i()
  {
    if (!j()) {
      return false;
    }
    this.a.saveLayerAlpha(null, a(this.d.a.m.floatValue()), 31);
    this.e.push(this.d);
    this.d = new i.g(this, this.d);
    if (this.d.a.G != null)
    {
      h.an localan = this.c.a(this.d.a.G);
      if ((localan == null) || (!(localan instanceof h.s)))
      {
        e("Mask reference '%s' not found", new Object[] { this.d.a.G });
        this.d.a.G = null;
      }
    }
    return true;
  }
  
  private boolean j()
  {
    return (this.d.a.m.floatValue() < 1.0F) || (this.d.a.G != null);
  }
  
  private static void k()
  {
    try
    {
      h = new HashSet();
      h.add("Structure");
      h.add("BasicStructure");
      h.add("ConditionalProcessing");
      h.add("Image");
      h.add("Style");
      h.add("ViewportAttribute");
      h.add("Shape");
      h.add("BasicText");
      h.add("PaintAttribute");
      h.add("BasicPaintAttribute");
      h.add("OpacityAttribute");
      h.add("BasicGraphicsAttribute");
      h.add("Marker");
      h.add("Gradient");
      h.add("Pattern");
      h.add("Clip");
      h.add("BasicClip");
      h.add("Mask");
      h.add("View");
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private h.ae.f l()
  {
    if ((this.d.a.t != h.ae.h.a) && (this.d.a.u != h.ae.f.b))
    {
      if (this.d.a.u == h.ae.f.a) {
        return h.ae.f.c;
      }
      return h.ae.f.a;
    }
    return this.d.a.u;
  }
  
  private boolean m()
  {
    if (this.d.a.A != null) {
      return this.d.a.A.booleanValue();
    }
    return true;
  }
  
  private boolean n()
  {
    if (this.d.a.B != null) {
      return this.d.a.B.booleanValue();
    }
    return true;
  }
  
  private Path.FillType o()
  {
    if ((this.d.a.c != null) && (this.d.a.c == h.ae.a.b)) {
      return Path.FillType.EVEN_ODD;
    }
    return Path.FillType.WINDING;
  }
  
  private void p()
  {
    int j;
    if ((this.d.a.J instanceof h.f))
    {
      j = ((h.f)this.d.a.J).a;
    }
    else
    {
      if (!(this.d.a.J instanceof h.g)) {
        return;
      }
      j = this.d.a.n.a;
    }
    int k = j;
    if (this.d.a.K != null) {
      k = a(j, this.d.a.K.floatValue());
    }
    this.a.drawColor(k);
  }
  
  private void q()
  {
    c.a(this.a, c.a);
    this.e.push(this.d);
    this.d = new i.g(this, this.d);
  }
  
  private void r()
  {
    this.a.restore();
    this.d = ((i.g)this.e.pop());
  }
  
  private Path.FillType s()
  {
    if ((this.d.a.F != null) && (this.d.a.F == h.ae.a.b)) {
      return Path.FillType.EVEN_ODD;
    }
    return Path.FillType.WINDING;
  }
  
  float a()
  {
    return this.b;
  }
  
  void a(h paramh, g paramg)
  {
    if (paramg != null)
    {
      this.c = paramh;
      h.af localaf = paramh.d();
      if (localaf == null)
      {
        d("Nothing to render. Document is empty.", new Object[0]);
        return;
      }
      Object localObject1;
      Object localObject2;
      if (paramg.c())
      {
        localObject1 = this.c.d(paramg.e);
        if ((localObject1 != null) && ((localObject1 instanceof h.bf)))
        {
          localObject2 = (h.bf)localObject1;
          if (((h.bf)localObject2).x == null)
          {
            Log.w("SVGAndroidRenderer", String.format("View element with id \"%s\" is missing a viewBox attribute.", new Object[] { paramg.e }));
            return;
          }
          localObject1 = ((h.bf)localObject2).x;
          localObject2 = ((h.bf)localObject2).w;
        }
        else
        {
          Log.w("SVGAndroidRenderer", String.format("View element with id \"%s\" not found.", new Object[] { paramg.e }));
        }
      }
      else
      {
        if (paramg.d()) {
          localObject1 = paramg.d;
        } else {
          localObject1 = localaf.x;
        }
        if (paramg.b()) {
          localObject2 = paramg.b;
        } else {
          localObject2 = localaf.w;
        }
      }
      if (paramg.a()) {
        paramh.a(paramg.a);
      }
      if (paramg.f())
      {
        this.i = new b.p();
        this.i.a = paramh.d(paramg.c);
      }
      e();
      b(localaf);
      f();
      h.b localb = new h.b(paramg.f);
      if (localaf.c != null) {
        localb.c = localaf.c.a(this, localb.c);
      }
      if (localaf.d != null) {
        localb.d = localaf.d.a(this, localb.d);
      }
      a(localaf, localb, (h.b)localObject1, (f)localObject2);
      g();
      if (paramg.a()) {
        paramh.g();
      }
      return;
    }
    throw new NullPointerException("renderOptions shouldn't be null");
  }
  
  float b()
  {
    return this.d.d.getTextSize();
  }
  
  float c()
  {
    return this.d.d.getTextSize() / 2.0F;
  }
  
  h.b d()
  {
    if (this.d.g != null) {
      return this.d.g;
    }
    return this.d.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.a.i
 * JD-Core Version:    0.7.0.1
 */