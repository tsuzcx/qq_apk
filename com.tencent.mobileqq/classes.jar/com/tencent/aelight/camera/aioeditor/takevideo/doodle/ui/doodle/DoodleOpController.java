package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.aelight.camera.aioeditor.shortvideo.PtvTemplateManager;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.util.VideoSDKMaterialParser;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DoodleOpController
  implements DoodleLineListener
{
  public Bitmap a;
  private final CopyOnWriteArrayList<DoodleLinePath> b = new CopyOnWriteArrayList();
  private CopyOnWriteArrayList<DoodleLinePath> c = new CopyOnWriteArrayList();
  private PureOperator d = new PureOperator(this);
  private EraserOperator e = new EraserOperator(this);
  private PersonalityOperator f = new PersonalityOperator(this);
  private MosaicOperator g = new MosaicOperator(this);
  private Matrix h = new Matrix();
  private DoodleGLCallback i;
  private DoodleOpController.DoodleOpListener j;
  private int k = -1;
  private int l = -1;
  private int m = -1;
  private int n = -1;
  private DoodleLinePath o = null;
  private boolean p = false;
  private int q = -1;
  private int r = 0;
  private boolean s = false;
  
  public DoodleOpController(Context paramContext) {}
  
  private void t()
  {
    AEQLog.b("DoodleOpController", "realAddLinePath---");
    this.b.add(this.o);
    if (this.o.a == 102)
    {
      String str = ((PersonalityLinePath)this.o).b;
      if (DoodleLayout.c) {
        VideoEditReport.b(a(str, 0));
      } else {
        VideoEditReport.a(a(str, 0));
      }
      int i1 = this.q;
      if (i1 != -1) {
        ((PersonalityLinePath)this.o).d = i1;
      }
    }
  }
  
  public DoodleOperator a(int paramInt)
  {
    if (paramInt != 111)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 103: 
      case 104: 
      case 105: 
        return this.g;
      case 102: 
        return this.f;
      }
      return this.d;
    }
    return this.e;
  }
  
  String a(String paramString, int paramInt)
  {
    if ("doodle_fireworks".equals(paramString))
    {
      if (paramInt == 0)
      {
        if (DoodleLayout.c) {
          return "0X80079F0";
        }
        return "0X80079EE";
      }
      if (paramInt == 1)
      {
        if (DoodleLayout.c) {
          return "0X80079F1";
        }
        return "0X80079EF";
      }
    }
    else if ("doodle_image_xin".equals(paramString))
    {
      if (paramInt == 0)
      {
        if (DoodleLayout.c) {
          return "0X80079EB";
        }
        return "0X80079E9";
      }
      if (paramInt == 1)
      {
        if (DoodleLayout.c) {
          return "0X80079EC";
        }
        return "0X80079EA";
      }
    }
    else if ("doodle_image_mouth".equals(paramString))
    {
      if (paramInt == 0)
      {
        if (DoodleLayout.c) {
          return "0X80079E7";
        }
        return "0X80079E5";
      }
      if (paramInt == 1)
      {
        if (DoodleLayout.c) {
          return "0X80079E8";
        }
        return "0X80079E6";
      }
    }
    else if ("doodle_highlighter".equals(paramString))
    {
      if (paramInt == 0)
      {
        if (DoodleLayout.c) {
          return "0X80079E3";
        }
        return "0X8007C0A";
      }
      if (paramInt == 1)
      {
        if (DoodleLayout.c) {
          return "0X80079E4";
        }
        return "0X8007C0B";
      }
    }
    else if ("doodle_image_family".equals(paramString))
    {
      if (paramInt == 0)
      {
        if (DoodleLayout.c) {
          return "0X8007C06";
        }
        return "0X8007C08";
      }
      if (paramInt == 1)
      {
        if (DoodleLayout.c) {
          return "0X8007C07";
        }
        return "0X8007C09";
      }
    }
    return "";
  }
  
  public void a()
  {
    DoodleGLCallback localDoodleGLCallback = this.i;
    if (localDoodleGLCallback != null) {
      localDoodleGLCallback.a();
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.a = paramBitmap;
    this.s = false;
    Object localObject = this.j;
    if (localObject != null) {
      ((DoodleOpController.DoodleOpListener)localObject).a();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveStillBitmap end bitmap:");
      ((StringBuilder)localObject).append(paramBitmap);
      QLog.d("DoodleOpController", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(Canvas paramCanvas)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      DoodleLinePath localDoodleLinePath = (DoodleLinePath)localIterator.next();
      if (localDoodleLinePath.a == 104)
      {
        paramCanvas.save();
        paramCanvas.concat(this.h);
        this.g.a(paramCanvas, (MosaicLinePath)localDoodleLinePath, 0.0F);
        paramCanvas.restore();
      }
    }
  }
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    if ((this.b.isEmpty()) && (this.p))
    {
      paramCanvas.drawColor(0);
      this.p = false;
    }
    Object localObject1 = null;
    Object localObject3 = this.b.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject2 = (DoodleLinePath)((Iterator)localObject3).next();
      if (((DoodleLinePath)localObject2).a == 105) {
        localObject1 = localObject2;
      }
    }
    Object localObject2 = this.b.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (DoodleLinePath)((Iterator)localObject2).next();
      Object localObject4;
      if (((DoodleLinePath)localObject3).a == 101)
      {
        this.p = true;
        localObject4 = this.d;
        ((PureOperator)localObject4).a(paramCanvas, (DoodleLinePath)localObject3, ((PureOperator)localObject4).b());
      }
      else if (((DoodleLinePath)localObject3).a == 105)
      {
        this.p = true;
        this.g.a(paramCanvas, (MosaicLinePath)localObject3, paramFloat);
        if (localObject3 == localObject1) {
          this.g.c();
        }
      }
      else if (((DoodleLinePath)localObject3).a == 111)
      {
        localObject4 = this.e;
        ((EraserOperator)localObject4).a(paramCanvas, (DoodleLinePath)localObject3, ((EraserOperator)localObject4).b());
      }
    }
    if ((localObject1 == null) && (this.p)) {
      this.g.a(true);
    }
    this.d.c();
  }
  
  public void a(Matrix paramMatrix)
  {
    this.h.set(paramMatrix);
  }
  
  public void a(DoodleGLCallback paramDoodleGLCallback)
  {
    this.i = paramDoodleGLCallback;
  }
  
  public void a(DoodleLinePath paramDoodleLinePath)
  {
    this.o = paramDoodleLinePath;
    if ((paramDoodleLinePath instanceof ShapeLinePath)) {
      t();
    }
  }
  
  public void a(DoodleOpController.DoodleOpListener paramDoodleOpListener)
  {
    this.j = paramDoodleOpListener;
  }
  
  public void a(AppInterface paramAppInterface, int paramInt)
  {
    this.q = -1;
    if (this.k == paramInt) {
      return;
    }
    paramAppInterface = PtvTemplateManager.a().a(paramInt);
    if (paramAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DoodleOpController", 2, "changeStroke error ");
      }
      return;
    }
    paramAppInterface = VideoSDKMaterialParser.parseVideoMaterialForEdit(paramAppInterface, "params");
    VideoMemoryManager.getInstance().loadAllImages(paramAppInterface);
    this.f.a(paramAppInterface);
    this.k = paramInt;
    paramAppInterface = new StringBuilder();
    paramAppInterface.append("change stroke");
    paramAppInterface.append(paramInt);
    SLog.b("DoodleOpController", paramAppInterface.toString());
  }
  
  public void a(Runnable paramRunnable)
  {
    DoodleGLCallback localDoodleGLCallback = this.i;
    if (localDoodleGLCallback != null) {
      localDoodleGLCallback.a(paramRunnable);
    }
  }
  
  public boolean a(int paramInt, MotionEvent paramMotionEvent)
  {
    int i1 = Math.round(paramMotionEvent.getY());
    int i2 = Math.round(paramMotionEvent.getX());
    int i3 = paramMotionEvent.getActionMasked();
    if (i3 != 0)
    {
      if (i3 != 1) {
        if (i3 != 2)
        {
          if (i3 != 3) {
            break label164;
          }
        }
        else
        {
          if ((this.o == null) || ((Math.abs(i2 - this.m) < 3) && (Math.abs(i1 - this.n) < 3)) || (paramMotionEvent.getEventTime() - paramMotionEvent.getDownTime() <= 100L)) {
            break label164;
          }
          t();
          this.o = null;
          AEQLog.b("DoodleOpController", "clear mCurPath after real add");
          break label164;
        }
      }
      if (this.o != null)
      {
        this.o = null;
        AEQLog.b("DoodleOpController", "clear mCurPath when touch up or cancel");
      }
    }
    else
    {
      this.m = Math.round(paramMotionEvent.getX());
      this.n = Math.round(paramMotionEvent.getY());
    }
    label164:
    DoodleOperator localDoodleOperator = a(paramInt);
    if (localDoodleOperator != null) {
      return localDoodleOperator.a(paramMotionEvent);
    }
    return false;
  }
  
  public int b()
  {
    return this.k;
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoodleOpController", 2, "preSavePersonality");
    }
    this.f.a(paramInt);
  }
  
  public void b(Canvas paramCanvas, float paramFloat)
  {
    paramCanvas.save();
    paramCanvas.scale(paramFloat, paramFloat);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (DoodleLinePath)localIterator.next();
      Object localObject2;
      if (((DoodleLinePath)localObject1).a == 101)
      {
        localObject1 = new PureLinePath((DoodleLinePath)localObject1, 1.0F);
        localObject2 = this.d;
        ((PureOperator)localObject2).a(paramCanvas, (DoodleLinePath)localObject1, ((PureOperator)localObject2).a());
      }
      else if (((DoodleLinePath)localObject1).a == 111)
      {
        localObject1 = new PureLinePath((DoodleLinePath)localObject1, 1.0F);
        localObject2 = this.e;
        ((EraserOperator)localObject2).a(paramCanvas, (DoodleLinePath)localObject1, ((EraserOperator)localObject2).a());
      }
    }
    paramCanvas.restore();
  }
  
  public int c()
  {
    return this.b.size();
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoodleOpController", 2, "savePersonality start");
    }
    this.f.a(paramInt);
    try
    {
      this.r = 0;
      this.s = true;
      while ((this.r < 25) && (this.s))
      {
        Thread.sleep(200L);
        this.r += 1;
      }
      StringBuilder localStringBuilder;
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("savePersonality error ");
        localStringBuilder.append(localException.toString());
        QLog.e("DoodleOpController", 2, localStringBuilder.toString());
      }
      if (QLog.isColorLevel()) {
        QLog.d("DoodleOpController", 2, "savePersonality end");
      }
    }
  }
  
  public void c(Canvas paramCanvas, float paramFloat)
  {
    paramCanvas.save();
    paramCanvas.scale(paramFloat, paramFloat);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (DoodleLinePath)localIterator.next();
      if (((DoodleLinePath)localObject).a == 104)
      {
        localObject = new MosaicLinePath((DoodleLinePath)localObject, 1.0F);
        this.g.a(paramCanvas, (MosaicLinePath)localObject, 0.0F);
      }
    }
    paramCanvas.restore();
  }
  
  public void d()
  {
    e();
  }
  
  public void d(int paramInt)
  {
    if (paramInt != this.l)
    {
      if (paramInt == 0)
      {
        n();
        this.f.a(false);
      }
      else
      {
        this.f.h();
      }
      this.l = paramInt;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refresh visibility:");
      localStringBuilder.append(paramInt);
      SLog.b("DoodleOpController", localStringBuilder.toString());
    }
  }
  
  public void e()
  {
    Bitmap localBitmap = this.a;
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      this.a.recycle();
      this.a = null;
    }
  }
  
  public void e(int paramInt)
  {
    if (paramInt == 101)
    {
      this.d.c();
      return;
    }
    if (paramInt == 104)
    {
      this.g.a();
      return;
    }
    if (paramInt == 105) {
      this.g.a();
    }
  }
  
  public void f()
  {
    this.f.a();
  }
  
  public boolean g()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      if (((DoodleLinePath)localIterator.next()).a == 102) {
        return true;
      }
    }
    return false;
  }
  
  public EraserOperator h()
  {
    return this.e;
  }
  
  public void i()
  {
    System.currentTimeMillis();
    this.f.d();
    System.currentTimeMillis();
    int i1 = 0;
    while (i1 < this.b.size())
    {
      Object localObject = (DoodleLinePath)this.b.get(i1);
      if (((DoodleLinePath)localObject).a == 102)
      {
        localObject = (PersonalityLinePath)localObject;
        this.f.a((PersonalityLinePath)localObject);
      }
      i1 += 1;
    }
    System.currentTimeMillis();
    this.f.e();
    System.currentTimeMillis();
    QLog.isColorLevel();
  }
  
  public void j()
  {
    if (!this.c.isEmpty())
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext()) {
        ((DoodleLinePath)localIterator.next()).a();
      }
    }
  }
  
  public void k()
  {
    if (!this.b.isEmpty())
    {
      int i1 = 0;
      while (i1 < this.b.size())
      {
        ((DoodleLinePath)this.b.get(i1)).a();
        i1 += 1;
      }
    }
    if (!this.c.isEmpty())
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext()) {
        ((DoodleLinePath)localIterator.next()).a();
      }
    }
    SLog.b("Personality", "releaseAllPaths");
  }
  
  public String l()
  {
    Object localObject1 = new HashSet();
    Object localObject2 = this.b.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      DoodleLinePath localDoodleLinePath = (DoodleLinePath)((Iterator)localObject2).next();
      if (localDoodleLinePath != null)
      {
        int i1 = localDoodleLinePath.a;
        if (i1 != 101)
        {
          if (i1 != 111) {
            switch (i1)
            {
            default: 
              break;
            case 103: 
            case 104: 
            case 105: 
              ((HashSet)localObject1).add(Integer.valueOf(3));
              break;
            }
          } else {
            ((HashSet)localObject1).add(Integer.valueOf(2));
          }
        }
        else {
          ((HashSet)localObject1).add(Integer.valueOf(1));
        }
      }
    }
    localObject2 = new StringBuilder();
    localObject1 = ((HashSet)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      ((StringBuilder)localObject2).append((Integer)((Iterator)localObject1).next());
      ((StringBuilder)localObject2).append("|");
    }
    if (((StringBuilder)localObject2).length() > 0) {
      ((StringBuilder)localObject2).deleteCharAt(((StringBuilder)localObject2).length() - 1);
    }
    return ((StringBuilder)localObject2).toString();
  }
  
  public boolean m()
  {
    if (!this.b.isEmpty())
    {
      Object localObject = this.b;
      localObject = (DoodleLinePath)((CopyOnWriteArrayList)localObject).remove(((CopyOnWriteArrayList)localObject).size() - 1);
      this.c.add(localObject);
      VideoEditReport.a("0X80076BF");
      VideoEditReport.b("0X80075CC");
      if ((((DoodleLinePath)localObject).a != 103) && (((DoodleLinePath)localObject).a != 104) && (((DoodleLinePath)localObject).a != 105))
      {
        if (((DoodleLinePath)localObject).a == 102)
        {
          n();
          this.f.f();
          return true;
        }
      }
      else {
        this.g.a((MosaicLinePath)localObject);
      }
      return true;
    }
    return false;
  }
  
  public void n()
  {
    int i1 = this.b.size() - 1;
    while (i1 >= 0)
    {
      if (((DoodleLinePath)this.b.get(i1)).a == 102)
      {
        PersonalityLinePath localPersonalityLinePath = (PersonalityLinePath)this.b.get(i1);
        localPersonalityLinePath.f = false;
        if (localPersonalityLinePath.h) {
          return;
        }
      }
      i1 -= 1;
    }
  }
  
  public void o()
  {
    this.b.clear();
    this.d.d();
    this.g.d();
    this.f.g();
    this.e.d();
  }
  
  public boolean p()
  {
    if (g()) {
      return false;
    }
    if (this.b.isEmpty()) {
      return true;
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      if (((DoodleLinePath)localIterator.next()).a != 103) {
        return false;
      }
    }
    return true;
  }
  
  public int[] q()
  {
    int[] arrayOfInt = new int[2];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 0;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    tmp9_5;
    if (this.b.isEmpty()) {
      return arrayOfInt;
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      DoodleLinePath localDoodleLinePath = (DoodleLinePath)localIterator.next();
      if ((localDoodleLinePath.a != 103) && (localDoodleLinePath.a != 104)) {
        arrayOfInt[0] += 1;
      } else {
        arrayOfInt[1] += 1;
      }
    }
    return arrayOfInt;
  }
  
  public List<String> r()
  {
    if (this.b.isEmpty()) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = this.b.iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (DoodleLinePath)localIterator1.next();
      if (((DoodleLinePath)localObject).a == 102)
      {
        localObject = (PersonalityLinePath)localObject;
        int i2 = 0;
        Iterator localIterator2 = localArrayList.iterator();
        do
        {
          i1 = i2;
          if (!localIterator2.hasNext()) {
            break;
          }
        } while (!TextUtils.equals((String)localIterator2.next(), ((PersonalityLinePath)localObject).b));
        int i1 = 1;
        if (i1 == 0) {
          localArrayList.add(((PersonalityLinePath)localObject).b);
        }
      }
    }
    return localArrayList;
  }
  
  public void s()
  {
    Object localObject1 = new HashSet();
    Object localObject2 = this.b.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (DoodleLinePath)((Iterator)localObject2).next();
      if (((DoodleLinePath)localObject3).a == 102)
      {
        localObject3 = a(((PersonalityLinePath)localObject3).b, 1);
        if (!((HashSet)localObject1).contains(localObject3)) {
          ((HashSet)localObject1).add(localObject3);
        }
      }
    }
    localObject1 = ((HashSet)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (DoodleLayout.c) {
        VideoEditReport.b((String)localObject2);
      } else {
        VideoEditReport.a((String)localObject2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleOpController
 * JD-Core Version:    0.7.0.1
 */