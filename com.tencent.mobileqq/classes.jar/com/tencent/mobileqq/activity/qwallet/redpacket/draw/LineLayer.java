package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import afaj;
import afba;
import afbd;
import ajcf;
import ajdq;
import ajds;
import ajdt;
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
  extends ajcf
  implements ajds, ajdt
{
  public static final int a;
  private long jdField_a_of_type_Long;
  private afaj jdField_a_of_type_Afaj = new afaj();
  private afbd jdField_a_of_type_Afbd;
  private ajdq jdField_a_of_type_Ajdq;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private LineLayer.LoadTempFileJob jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer$LoadTempFileJob;
  private List<afbd> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<Integer, String> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private int jdField_b_of_type_Int = jdField_a_of_type_Int;
  private Map<Integer, Integer> jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  private int jdField_c_of_type_Int;
  private Map<Integer, Integer> jdField_c_of_type_JavaUtilMap = new ConcurrentHashMap();
  private int d;
  private int e;
  private int f;
  private int g = -1;
  private int h;
  private int i;
  
  static
  {
    jdField_a_of_type_Int = Color.parseColor("#ff000000");
  }
  
  public LineLayer(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
  }
  
  private void a(Canvas paramCanvas, afbd paramafbd, boolean paramBoolean)
  {
    paramafbd.a(paramCanvas, paramBoolean);
  }
  
  private int[] a()
  {
    int[] arrayOfInt = new int[2];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 0;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    tmp9_5;
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return arrayOfInt;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      afbd localafbd = (afbd)localIterator.next();
      arrayOfInt[0] += 1;
    }
    return arrayOfInt;
  }
  
  private void c()
  {
    this.i += 1;
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()), Integer.valueOf(this.i));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer$LoadTempFileJob != null)
    {
      ThreadManager.remove(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer$LoadTempFileJob);
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer$LoadTempFileJob = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer$LoadTempFileJob = new LineLayer.LoadTempFileJob(this, this.jdField_a_of_type_JavaUtilList.size(), this.jdField_a_of_type_JavaUtilMap, this.i, this);
    ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer$LoadTempFileJob, 5, null, false);
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      e();
      return;
    }
    if (!c()) {
      d();
    }
    int j;
    if (this.jdField_a_of_type_JavaUtilList.size() - 1 > this.e)
    {
      j = this.e;
      while (j < this.jdField_a_of_type_JavaUtilList.size() - 1)
      {
        a(this.jdField_a_of_type_AndroidGraphicsCanvas, (afbd)this.jdField_a_of_type_JavaUtilList.get(j), false);
        j += 1;
      }
      this.f = 0;
      this.e = (this.jdField_a_of_type_JavaUtilList.size() - 1);
    }
    for (;;)
    {
      afbd localafbd = (afbd)this.jdField_a_of_type_JavaUtilList.get(this.e);
      j = localafbd.a();
      if (j <= this.f) {
        break;
      }
      localafbd.a(this.jdField_a_of_type_AndroidGraphicsCanvas, this.f, j);
      this.f = j;
      if (this.f != 1) {
        break;
      }
      this.f = 0;
      return;
      if (this.e > this.jdField_a_of_type_JavaUtilList.size() - 1) {
        this.e = (this.jdField_a_of_type_JavaUtilList.size() - 1);
      }
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsCanvas != null) && (this.jdField_a_of_type_AndroidGraphicsPaint != null)) {
      this.jdField_a_of_type_AndroidGraphicsCanvas.drawPaint(this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    this.e = 0;
    this.f = 0;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public final afaj a()
  {
    return this.jdField_a_of_type_Afaj;
  }
  
  public List<afba> a()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      afbd localafbd = (afbd)localIterator.next();
      afba localafba = new afba();
      localafba.a(localafbd.a());
      localArrayList.add(localafba);
    }
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.g = -1;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    this.jdField_a_of_type_Afaj.a(paramInt1, paramInt2);
    d();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer$LoadTempFileJob = null;
    Object localObject = (Integer)this.jdField_c_of_type_JavaUtilMap.remove(Integer.valueOf(paramInt1));
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d("LineLayer", 2, "undo result, seq not exist:" + paramInt1 + "-" + paramInt2 + "-" + paramInt3);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt3 == ((Integer)localObject).intValue()) {
            break;
          }
          this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(paramInt1), localObject);
        } while (!QLog.isColorLevel());
        QLog.d("LineLayer", 2, "undo result, seq not match:" + paramInt1 + "-" + paramInt2 + "-" + paramInt3 + "-" + ((Integer)localObject).intValue());
        return;
        if (paramInt1 == this.jdField_a_of_type_JavaUtilList.size()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("LineLayer", 2, "undo result, pathsize not match:" + paramInt1 + "-" + paramInt2 + "-" + paramInt3 + "-" + this.jdField_a_of_type_JavaUtilList.size());
      return;
      if ((paramInt2 != 0) && (paramBitmap != null)) {
        break;
      }
      e();
      super.a();
    } while (!QLog.isColorLevel());
    QLog.d("LineLayer", 2, "undo result, no cache:" + paramInt1 + "-" + paramInt2 + "-" + paramInt3);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("LineLayer", 2, "undo result, use cache:" + paramInt1 + "-" + paramInt2);
    }
    localObject = new Paint();
    ((Paint)localObject).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    this.jdField_a_of_type_AndroidGraphicsCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, (Paint)localObject);
    this.e = (paramInt2 - 1);
    paramBitmap = (afbd)this.jdField_a_of_type_JavaUtilList.get(this.e);
    if (paramBitmap != null)
    {
      this.f = paramBitmap.a();
      if (this.f == 1) {
        this.f = 0;
      }
    }
    if (paramInt2 < this.jdField_a_of_type_JavaUtilList.size()) {
      d();
    }
    super.a();
  }
  
  public void a(ajdq paramajdq)
  {
    this.jdField_a_of_type_Ajdq = paramajdq;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_Afbd = null;
    this.h = 0;
    ThreadManager.post(new LineLayer.ClearTempFileJob(this), 5, null, true);
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidGraphicsCanvas = null;
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    Integer localInteger = (Integer)this.jdField_b_of_type_JavaUtilMap.remove(Integer.valueOf(paramInt1));
    if (localInteger == null) {
      if (QLog.isColorLevel()) {
        QLog.d("LineLayer", 2, "save result, seq not exist:" + paramInt1 + "-" + paramInt2);
      }
    }
    do
    {
      do
      {
        return;
        if (paramInt2 == localInteger.intValue()) {
          break;
        }
        this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(paramInt1), localInteger);
      } while (!QLog.isColorLevel());
      QLog.d("LineLayer", 2, "save result, seq not match:" + paramInt1 + "-" + paramInt2 + "-" + localInteger.intValue());
      return;
      if ((paramBoolean) && (!TextUtils.isEmpty(paramString))) {
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt1), paramString);
      }
    } while (!QLog.isColorLevel());
    QLog.d("LineLayer", 2, "save result, add cache:" + paramInt1 + "-" + paramString + " : " + this.jdField_a_of_type_JavaUtilMap.size());
  }
  
  public int b()
  {
    int[] arrayOfInt = a();
    int j = arrayOfInt[0];
    return arrayOfInt[1] + j;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LineLayer", 2, "undo begin");
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      this.jdField_b_of_type_JavaUtilMap.remove(Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
      this.jdField_c_of_type_JavaUtilMap.remove(Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
      this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
      this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_JavaUtilList.size() - 1);
      if (this.jdField_a_of_type_JavaUtilList.size() == 0)
      {
        this.h = 0;
        ThreadManager.post(new LineLayer.ClearTempFileJob(this), 5, null, true);
        this.jdField_b_of_type_JavaUtilMap.clear();
        this.jdField_c_of_type_JavaUtilMap.clear();
        this.jdField_a_of_type_JavaUtilMap.clear();
        e();
      }
    }
    else
    {
      if (this.h >= 100) {
        break label242;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LineLayer", 2, "undo draw directly");
      }
      e();
      super.a();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LineLayer", 2, "undo end");
      }
      return;
      this.h = c();
      break;
      label242:
      c();
      if (QLog.isColorLevel()) {
        QLog.d("LineLayer", 2, "undo try use cache");
      }
    }
  }
  
  public void b(int paramInt)
  {
    if (this.g == paramInt) {
      return;
    }
    this.jdField_b_of_type_Int = -1;
    this.g = paramInt;
  }
  
  public void b(Canvas paramCanvas)
  {
    d();
    c(paramCanvas);
  }
  
  public boolean b()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    return true;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    int m = 0;
    if (this.h > 10000)
    {
      if (this.jdField_a_of_type_Ajdq != null)
      {
        this.jdField_a_of_type_Ajdq.a(2, 10000);
        this.jdField_a_of_type_Ajdq.b();
      }
      this.jdField_a_of_type_Afbd = null;
      return false;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      for (;;)
      {
        return true;
        if (this.jdField_a_of_type_Ajdq != null) {
          this.jdField_a_of_type_Ajdq.a();
        }
        this.jdField_a_of_type_Afbd = new afbd(this.jdField_a_of_type_Afaj, a(), null, this.g);
        this.jdField_a_of_type_Afbd.a();
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_Afbd.a(f1, f2);
        this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Afbd);
        this.h = c();
        continue;
        long l1 = System.currentTimeMillis();
        long l2 = this.jdField_a_of_type_Long;
        if (this.jdField_a_of_type_Afbd != null)
        {
          this.jdField_a_of_type_Afbd.a(f1, f2, l1 - l2);
          this.h += 1;
        }
      }
    }
    if (this.jdField_a_of_type_Ajdq != null) {
      this.jdField_a_of_type_Ajdq.b();
    }
    if (this.jdField_a_of_type_Afbd != null)
    {
      this.jdField_a_of_type_Afbd.a(false);
      d();
      this.jdField_a_of_type_Afbd.a(true);
      this.f = this.jdField_a_of_type_Afbd.a();
      if (this.f == 1) {
        this.f = 0;
      }
    }
    this.jdField_a_of_type_Afbd = null;
    this.h = c();
    paramMotionEvent = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    int j = 0;
    label322:
    int k;
    if (paramMotionEvent.hasNext())
    {
      k = ((Integer)paramMotionEvent.next()).intValue();
      if (j >= k) {
        break label546;
      }
      j = k;
    }
    label546:
    for (;;)
    {
      break label322;
      paramMotionEvent = this.jdField_b_of_type_JavaUtilMap.keySet().iterator();
      while (paramMotionEvent.hasNext())
      {
        k = ((Integer)paramMotionEvent.next()).intValue();
        if (j < k) {
          j = k;
        }
      }
      int n;
      for (k = 0; m < j; k = n + k)
      {
        n = ((afbd)this.jdField_a_of_type_JavaUtilList.get(m)).b();
        m += 1;
      }
      if (k + 100 >= this.h) {
        break;
      }
      d();
      this.i += 1;
      this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()), Integer.valueOf(this.i));
      ThreadManager.post(new LineLayer.SaveTempFileJob(this, this.jdField_a_of_type_JavaUtilList.size(), this.i, this.jdField_a_of_type_AndroidGraphicsBitmap, this), 5, null, true);
      break;
    }
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (int j = 0; localIterator.hasNext(); j = ((afbd)localIterator.next()).b() + j) {}
    return j;
  }
  
  public void c(Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (paramCanvas != null)) {
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, null);
    }
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (this.jdField_a_of_type_AndroidGraphicsCanvas != null);
  }
  
  public boolean d()
  {
    boolean bool = false;
    int j = this.jdField_a_of_type_AndroidGraphicsRect.width();
    int k = this.jdField_a_of_type_AndroidGraphicsRect.height();
    if ((j <= 0) || (k <= 0)) {
      return false;
    }
    try
    {
      if ((this.jdField_c_of_type_Int != j) || (this.d != k) || (this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsCanvas == null))
      {
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          this.jdField_a_of_type_AndroidGraphicsCanvas = null;
          this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
          this.jdField_a_of_type_AndroidGraphicsBitmap = null;
        }
        this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(j, k, Bitmap.Config.ARGB_8888);
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
          this.jdField_c_of_type_Int = j;
          this.d = k;
        }
        this.e = 0;
        this.f = 0;
        bool = true;
      }
      return bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
      this.jdField_c_of_type_Int = 0;
      this.d = 0;
      this.jdField_a_of_type_AndroidGraphicsCanvas = null;
      this.e = 0;
      this.f = 0;
      return true;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.e("LineLayer", 2, "checkcache oom:" + localOutOfMemoryError.toString());
      }
      this.jdField_c_of_type_Int = 0;
      this.d = 0;
      this.jdField_a_of_type_AndroidGraphicsCanvas = null;
      this.e = 0;
      this.f = 0;
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.LineLayer
 * JD-Core Version:    0.7.0.1
 */