package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class LineLayer
  extends BaseLayer
  implements LoadTempFileJobListener, SaveTempFileJobListener
{
  public static final int d = Color.parseColor("#ff000000");
  private DoodleParam e = new DoodleParam();
  private List<PathDesc> f = new ArrayList();
  private PathDesc g;
  private int h = d;
  private long i = 0L;
  private LineLayer.LineLayerListener j;
  private Bitmap k;
  private Canvas l;
  private int m = 0;
  private int n = 0;
  private int o = 0;
  private int p = 0;
  private Paint q;
  private int r = -1;
  private int s = 0;
  private Map<Integer, String> t = new ConcurrentHashMap();
  private Map<Integer, Integer> u = new ConcurrentHashMap();
  private Map<Integer, Integer> v = new ConcurrentHashMap();
  private int w = 0;
  private LineLayer.LoadTempFileJob x;
  
  public LineLayer(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
  }
  
  private void a(Canvas paramCanvas, PathDesc paramPathDesc, boolean paramBoolean)
  {
    paramPathDesc.a(paramCanvas, paramBoolean);
  }
  
  private void n()
  {
    this.w += 1;
    this.v.put(Integer.valueOf(this.f.size()), Integer.valueOf(this.w));
    LineLayer.LoadTempFileJob localLoadTempFileJob = this.x;
    if (localLoadTempFileJob != null)
    {
      ThreadManager.remove(localLoadTempFileJob);
      this.x = null;
    }
    this.x = new LineLayer.LoadTempFileJob(this, this.f.size(), this.t, this.w, this);
    ThreadManager.post(this.x, 5, null, false);
  }
  
  private void o()
  {
    Object localObject = this.f;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      if (!f()) {
        g();
      }
      int i2 = this.f.size();
      int i1 = this.o;
      if (i2 - 1 > i1)
      {
        while (i1 < this.f.size() - 1)
        {
          a(this.l, (PathDesc)this.f.get(i1), false);
          i1 += 1;
        }
        this.p = 0;
        this.o = (this.f.size() - 1);
      }
      else if (i1 > this.f.size() - 1)
      {
        this.o = (this.f.size() - 1);
      }
      localObject = (PathDesc)this.f.get(this.o);
      i1 = ((PathDesc)localObject).c();
      i2 = this.p;
      if (i1 > i2)
      {
        ((PathDesc)localObject).a(this.l, i2, i1);
        this.p = i1;
        if (this.p == 1) {
          this.p = 0;
        }
      }
      return;
    }
    p();
  }
  
  private void p()
  {
    Canvas localCanvas = this.l;
    if (localCanvas != null)
    {
      Paint localPaint = this.q;
      if (localPaint != null) {
        localCanvas.drawPaint(localPaint);
      }
    }
    this.o = 0;
    this.p = 0;
  }
  
  private int[] q()
  {
    int[] arrayOfInt = new int[2];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 0;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    tmp9_5;
    Object localObject = this.f;
    if (localObject == null) {
      return arrayOfInt;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      PathDesc localPathDesc = (PathDesc)((Iterator)localObject).next();
      arrayOfInt[0] += 1;
    }
    return arrayOfInt;
  }
  
  public void a(int paramInt)
  {
    this.h = paramInt;
    this.r = -1;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    this.e.a(paramInt1, paramInt2);
    g();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    this.x = null;
    Object localObject = (Integer)this.v.remove(Integer.valueOf(paramInt1));
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        paramBitmap = new StringBuilder();
        paramBitmap.append("undo result, seq not exist:");
        paramBitmap.append(paramInt1);
        paramBitmap.append("-");
        paramBitmap.append(paramInt2);
        paramBitmap.append("-");
        paramBitmap.append(paramInt3);
        QLog.d("LineLayer", 2, paramBitmap.toString());
      }
      return;
    }
    if (paramInt3 != ((Integer)localObject).intValue())
    {
      this.v.put(Integer.valueOf(paramInt1), localObject);
      if (QLog.isColorLevel())
      {
        paramBitmap = new StringBuilder();
        paramBitmap.append("undo result, seq not match:");
        paramBitmap.append(paramInt1);
        paramBitmap.append("-");
        paramBitmap.append(paramInt2);
        paramBitmap.append("-");
        paramBitmap.append(paramInt3);
        paramBitmap.append("-");
        paramBitmap.append(((Integer)localObject).intValue());
        QLog.d("LineLayer", 2, paramBitmap.toString());
      }
      return;
    }
    if (paramInt1 != this.f.size())
    {
      if (QLog.isColorLevel())
      {
        paramBitmap = new StringBuilder();
        paramBitmap.append("undo result, pathsize not match:");
        paramBitmap.append(paramInt1);
        paramBitmap.append("-");
        paramBitmap.append(paramInt2);
        paramBitmap.append("-");
        paramBitmap.append(paramInt3);
        paramBitmap.append("-");
        paramBitmap.append(this.f.size());
        QLog.d("LineLayer", 2, paramBitmap.toString());
      }
      return;
    }
    if ((paramInt2 != 0) && (paramBitmap != null))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("undo result, use cache:");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append("-");
        ((StringBuilder)localObject).append(paramInt2);
        QLog.d("LineLayer", 2, ((StringBuilder)localObject).toString());
      }
      localObject = new Paint();
      ((Paint)localObject).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
      this.l.drawBitmap(paramBitmap, 0.0F, 0.0F, (Paint)localObject);
      this.o = (paramInt2 - 1);
      paramBitmap = (PathDesc)this.f.get(this.o);
      if (paramBitmap != null)
      {
        this.p = paramBitmap.c();
        if (this.p == 1) {
          this.p = 0;
        }
      }
      if (paramInt2 < this.f.size()) {
        o();
      }
      super.c();
      return;
    }
    p();
    super.c();
    if (QLog.isColorLevel())
    {
      paramBitmap = new StringBuilder();
      paramBitmap.append("undo result, no cache:");
      paramBitmap.append(paramInt1);
      paramBitmap.append("-");
      paramBitmap.append(paramInt2);
      paramBitmap.append("-");
      paramBitmap.append(paramInt3);
      QLog.d("LineLayer", 2, paramBitmap.toString());
    }
  }
  
  public void a(LineLayer.LineLayerListener paramLineLayerListener)
  {
    this.j = paramLineLayerListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.f.clear();
    this.u.clear();
    this.t.clear();
    this.g = null;
    this.s = 0;
    ThreadManager.post(new LineLayer.ClearTempFileJob(this), 5, null, true);
    if (paramBoolean)
    {
      this.l = null;
      Bitmap localBitmap = this.k;
      if (localBitmap != null)
      {
        localBitmap.recycle();
        this.k = null;
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = (Integer)this.u.remove(Integer.valueOf(paramInt1));
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("save result, seq not exist:");
        paramString.append(paramInt1);
        paramString.append("-");
        paramString.append(paramInt2);
        QLog.d("LineLayer", 2, paramString.toString());
      }
      return;
    }
    if (paramInt2 != ((Integer)localObject).intValue())
    {
      this.u.put(Integer.valueOf(paramInt1), localObject);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("save result, seq not match:");
        paramString.append(paramInt1);
        paramString.append("-");
        paramString.append(paramInt2);
        paramString.append("-");
        paramString.append(((Integer)localObject).intValue());
        QLog.d("LineLayer", 2, paramString.toString());
      }
      return;
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString))) {
      this.t.put(Integer.valueOf(paramInt1), paramString);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("save result, add cache:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("-");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" : ");
      ((StringBuilder)localObject).append(this.t.size());
      QLog.d("LineLayer", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void b(int paramInt)
  {
    if (this.r == paramInt) {
      return;
    }
    this.h = -1;
    this.r = paramInt;
  }
  
  protected void b(Canvas paramCanvas)
  {
    o();
    c(paramCanvas);
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    int i1 = this.s;
    int i2 = 0;
    if (i1 > 10000)
    {
      paramMotionEvent = this.j;
      if (paramMotionEvent != null)
      {
        paramMotionEvent.a(2, 10000);
        this.j.a();
      }
      this.g = null;
      return false;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2) {
          return true;
        }
        long l1 = System.currentTimeMillis();
        long l2 = this.i;
        paramMotionEvent = this.g;
        if (paramMotionEvent != null)
        {
          paramMotionEvent.a(f1, f2, l1 - l2);
          this.s += 1;
          return true;
        }
      }
      else
      {
        paramMotionEvent = this.j;
        if (paramMotionEvent != null) {
          paramMotionEvent.a();
        }
        paramMotionEvent = this.g;
        if (paramMotionEvent != null)
        {
          paramMotionEvent.a(false);
          o();
          this.g.a(true);
          this.p = this.g.c();
          if (this.p == 1) {
            this.p = 0;
          }
        }
        this.g = null;
        this.s = m();
        paramMotionEvent = this.t.keySet().iterator();
        i1 = 0;
        while (paramMotionEvent.hasNext())
        {
          i3 = ((Integer)paramMotionEvent.next()).intValue();
          if (i1 < i3) {
            i1 = i3;
          }
        }
        paramMotionEvent = this.u.keySet().iterator();
        while (paramMotionEvent.hasNext())
        {
          i3 = ((Integer)paramMotionEvent.next()).intValue();
          if (i1 < i3) {
            i1 = i3;
          }
        }
        int i3 = 0;
        while (i2 < i1)
        {
          i3 += ((PathDesc)this.f.get(i2)).f();
          i2 += 1;
        }
        if (i3 + 100 < this.s)
        {
          o();
          this.w += 1;
          this.u.put(Integer.valueOf(this.f.size()), Integer.valueOf(this.w));
          ThreadManager.post(new LineLayer.SaveTempFileJob(this, this.f.size(), this.w, this.k, this), 5, null, true);
          return true;
        }
      }
    }
    else
    {
      this.g = new PathDesc(this.e, h(), null, this.r);
      this.g.a();
      this.i = System.currentTimeMillis();
      this.g.a(f1, f2);
      this.f.add(this.g);
      this.s = m();
    }
    return true;
  }
  
  public void c(Canvas paramCanvas)
  {
    Bitmap localBitmap = this.k;
    if ((localBitmap != null) && (paramCanvas != null)) {
      paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, null);
    }
  }
  
  public boolean d()
  {
    this.q = new Paint();
    this.q.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    return true;
  }
  
  public boolean d(Canvas paramCanvas)
  {
    Iterator localIterator = this.f.iterator();
    for (boolean bool = false; localIterator.hasNext(); bool = true) {
      a(paramCanvas, new PathDesc((PathDesc)localIterator.next()), true);
    }
    return bool;
  }
  
  public void e()
  {
    super.e();
    Object localObject = this.f;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.f.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((PathDesc)((Iterator)localObject).next()).b();
      }
      this.f.clear();
    }
    this.t.clear();
    this.u.clear();
    this.v.clear();
    this.x = null;
    this.g = null;
    this.l = null;
    localObject = this.k;
    if (localObject != null)
    {
      ((Bitmap)localObject).recycle();
      this.k = null;
    }
    this.n = 0;
    this.m = 0;
    this.r = -1;
    this.j = null;
    ThreadManager.post(new LineLayer.ClearTempFileJob(this), 5, null, true);
  }
  
  public boolean f()
  {
    return (this.k != null) && (this.l != null);
  }
  
  public boolean g()
  {
    int i1 = this.c.width();
    int i2 = this.c.height();
    if (i1 > 0)
    {
      if (i2 <= 0) {
        return false;
      }
      try
      {
        if ((this.m == i1) && (this.n == i2) && (this.k != null)) {
          if (this.l != null) {
            break label269;
          }
        }
        if (this.k != null)
        {
          this.l = null;
          this.k.recycle();
          this.k = null;
        }
        this.k = Bitmap.createBitmap(i1, i2, Bitmap.Config.ARGB_8888);
        if (this.k != null)
        {
          this.l = new Canvas(this.k);
          this.m = i1;
          this.n = i2;
        }
        this.o = 0;
        this.p = 0;
        return true;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("checkcache oom:");
          localStringBuilder.append(localOutOfMemoryError.toString());
          QLog.e("LineLayer", 2, localStringBuilder.toString());
        }
        this.m = 0;
        this.n = 0;
        this.l = null;
        this.o = 0;
        this.p = 0;
        this.k = null;
        return true;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        Bitmap localBitmap = this.k;
        if (localBitmap != null)
        {
          localBitmap.recycle();
          this.k = null;
        }
        this.m = 0;
        this.n = 0;
        this.l = null;
        this.o = 0;
        this.p = 0;
        return true;
      }
    }
    else
    {
      return false;
    }
    label269:
    return false;
  }
  
  public int h()
  {
    return this.h;
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LineLayer", 2, "undo begin");
    }
    List localList = this.f;
    if ((localList != null) && (!localList.isEmpty()))
    {
      this.u.remove(Integer.valueOf(this.f.size()));
      this.v.remove(Integer.valueOf(this.f.size()));
      this.t.remove(Integer.valueOf(this.f.size()));
      localList = this.f;
      localList.remove(localList.size() - 1);
      if (this.f.size() == 0)
      {
        this.s = 0;
        ThreadManager.post(new LineLayer.ClearTempFileJob(this), 5, null, true);
        this.u.clear();
        this.v.clear();
        this.t.clear();
        p();
      }
      else
      {
        this.s = m();
      }
    }
    if (this.s < 100)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LineLayer", 2, "undo draw directly");
      }
      p();
      super.c();
    }
    else
    {
      n();
      if (QLog.isColorLevel()) {
        QLog.d("LineLayer", 2, "undo try use cache");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("LineLayer", 2, "undo end");
    }
  }
  
  public List<PathData> j()
  {
    if (this.f.size() == 0) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      PathDesc localPathDesc = (PathDesc)localIterator.next();
      PathData localPathData = new PathData();
      localPathData.a(localPathDesc.e());
      localArrayList.add(localPathData);
    }
    return localArrayList;
  }
  
  public final DoodleParam k()
  {
    return this.e;
  }
  
  public int l()
  {
    int[] arrayOfInt = q();
    return arrayOfInt[0] + arrayOfInt[1];
  }
  
  public int m()
  {
    Object localObject = this.f;
    int i1 = 0;
    if (localObject == null) {
      return 0;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      i1 += ((PathDesc)((Iterator)localObject).next()).f();
    }
    return i1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.LineLayer
 * JD-Core Version:    0.7.0.1
 */