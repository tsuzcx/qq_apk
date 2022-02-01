import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.QQTemplateParser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class bqnt
  implements bqnr
{
  int jdField_a_of_type_Int = -1;
  public Bitmap a;
  bqmp jdField_a_of_type_Bqmp;
  bqns jdField_a_of_type_Bqns = null;
  bqnu jdField_a_of_type_Bqnu;
  bqol jdField_a_of_type_Bqol = new bqol(this);
  public bqoq a;
  bqou jdField_a_of_type_Bqou = new bqou(this);
  public CopyOnWriteArrayList<bqns> a;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = -1;
  CopyOnWriteArrayList<bqns> jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private boolean jdField_b_of_type_Boolean;
  int c = -1;
  int d = -1;
  int e = -1;
  int f = 0;
  
  public bqnt()
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_Bqoq = new bqoq(this);
  }
  
  private void k()
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(this.jdField_a_of_type_Bqns);
    String str;
    if (this.jdField_a_of_type_Bqns.jdField_a_of_type_Int == 102)
    {
      str = ((bqop)this.jdField_a_of_type_Bqns).jdField_a_of_type_JavaLangString;
      if (!DoodleLayout.jdField_a_of_type_Boolean) {
        break label73;
      }
      yuq.b(a(str, 0));
    }
    for (;;)
    {
      if (this.e != -1) {
        ((bqop)this.jdField_a_of_type_Bqns).jdField_b_of_type_Int = this.e;
      }
      return;
      label73:
      yuq.a(a(str, 0));
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public bqnv a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 101: 
      return this.jdField_a_of_type_Bqou;
    case 102: 
      return this.jdField_a_of_type_Bqoq;
    }
    return this.jdField_a_of_type_Bqol;
  }
  
  String a(String paramString, int paramInt)
  {
    String str2 = "";
    String str1;
    if ("doodle_fireworks".equals(paramString)) {
      if (paramInt == 0) {
        if (DoodleLayout.jdField_a_of_type_Boolean) {
          str1 = "0X80079F0";
        }
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return str1;
                return "0X80079EE";
                str1 = str2;
              } while (paramInt != 1);
              if (DoodleLayout.jdField_a_of_type_Boolean) {
                return "0X80079F1";
              }
              return "0X80079EF";
              if (!"doodle_image_xin".equals(paramString)) {
                break;
              }
              if (paramInt == 0)
              {
                if (DoodleLayout.jdField_a_of_type_Boolean) {
                  return "0X80079EB";
                }
                return "0X80079E9";
              }
              str1 = str2;
            } while (paramInt != 1);
            if (DoodleLayout.jdField_a_of_type_Boolean) {
              return "0X80079EC";
            }
            return "0X80079EA";
            if (!"doodle_image_mouth".equals(paramString)) {
              break;
            }
            if (paramInt == 0)
            {
              if (DoodleLayout.jdField_a_of_type_Boolean) {
                return "0X80079E7";
              }
              return "0X80079E5";
            }
            str1 = str2;
          } while (paramInt != 1);
          if (DoodleLayout.jdField_a_of_type_Boolean) {
            return "0X80079E8";
          }
          return "0X80079E6";
          if (!"doodle_highlighter".equals(paramString)) {
            break;
          }
          if (paramInt == 0)
          {
            if (DoodleLayout.jdField_a_of_type_Boolean) {
              return "0X80079E3";
            }
            return "0X8007C0A";
          }
          str1 = str2;
        } while (paramInt != 1);
        if (DoodleLayout.jdField_a_of_type_Boolean) {
          return "0X80079E4";
        }
        return "0X8007C0B";
        str1 = str2;
      } while (!"doodle_image_family".equals(paramString));
      if (paramInt == 0)
      {
        if (DoodleLayout.jdField_a_of_type_Boolean) {
          return "0X8007C06";
        }
        return "0X8007C08";
      }
      str1 = str2;
    } while (paramInt != 1);
    if (DoodleLayout.jdField_a_of_type_Boolean) {
      return "0X8007C07";
    }
    return "0X8007C09";
  }
  
  public List<String> a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty()) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    label130:
    for (;;)
    {
      Object localObject;
      if (localIterator1.hasNext())
      {
        localObject = (bqns)localIterator1.next();
        if (((bqns)localObject).jdField_a_of_type_Int == 102)
        {
          localObject = (bqop)localObject;
          Iterator localIterator2 = localArrayList.iterator();
          do
          {
            if (!localIterator2.hasNext()) {
              break;
            }
          } while (!TextUtils.equals((String)localIterator2.next(), ((bqop)localObject).jdField_a_of_type_JavaLangString));
        }
      }
      else
      {
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label130;
          }
          localArrayList.add(((bqop)localObject).jdField_a_of_type_JavaLangString);
          break;
          return localArrayList;
        }
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bqmp != null) {
      this.jdField_a_of_type_Bqmp.a();
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoodleOpController", 2, "preSavePersonality");
    }
    this.jdField_a_of_type_Bqoq.a(paramInt);
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Bqnu != null) {
      this.jdField_a_of_type_Bqnu.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("DoodleOpController", 2, "saveStillBitmap end bitmap:" + paramBitmap);
    }
  }
  
  public void a(Canvas paramCanvas)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      bqns localbqns = (bqns)localIterator.next();
      if (localbqns.jdField_a_of_type_Int == 104) {
        this.jdField_a_of_type_Bqol.a(paramCanvas, (bqok)localbqns, 0.0F);
      }
    }
  }
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty()) && (this.jdField_b_of_type_Boolean))
    {
      paramCanvas.drawColor(0);
      this.jdField_b_of_type_Boolean = false;
    }
    Object localObject1 = null;
    Object localObject3 = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    Object localObject2;
    if (((Iterator)localObject3).hasNext())
    {
      localObject2 = (bqns)((Iterator)localObject3).next();
      if (((bqns)localObject2).jdField_a_of_type_Int != 105) {
        break label214;
      }
      localObject1 = localObject2;
    }
    label214:
    for (;;)
    {
      break;
      localObject2 = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (bqns)((Iterator)localObject2).next();
        if (((bqns)localObject3).jdField_a_of_type_Int == 101)
        {
          this.jdField_b_of_type_Boolean = true;
          this.jdField_a_of_type_Bqou.a(paramCanvas, (bqns)localObject3, this.jdField_a_of_type_Bqou.b());
        }
        else if (((bqns)localObject3).jdField_a_of_type_Int == 105)
        {
          this.jdField_b_of_type_Boolean = true;
          this.jdField_a_of_type_Bqol.a(paramCanvas, (bqok)localObject3, paramFloat);
          if (localObject3 == localObject1) {
            this.jdField_a_of_type_Bqol.c();
          }
        }
      }
      if ((localObject1 == null) && (this.jdField_b_of_type_Boolean)) {
        this.jdField_a_of_type_Bqol.a(true);
      }
      this.jdField_a_of_type_Bqou.a();
      return;
    }
  }
  
  public void a(bqmp parambqmp)
  {
    this.jdField_a_of_type_Bqmp = parambqmp;
  }
  
  public void a(bqns parambqns)
  {
    this.jdField_a_of_type_Bqns = parambqns;
  }
  
  public void a(bqnu parambqnu)
  {
    this.jdField_a_of_type_Bqnu = parambqnu;
  }
  
  public void a(AppInterface paramAppInterface, int paramInt)
  {
    this.e = -1;
    if (this.jdField_a_of_type_Int == paramInt) {}
    do
    {
      return;
      paramAppInterface = PtvTemplateManager.a(paramAppInterface).a(paramInt);
      if (paramAppInterface != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("DoodleOpController", 2, "changeStroke error ");
    return;
    paramAppInterface = QQTemplateParser.parseVideoMaterial(paramAppInterface, "params");
    VideoMemoryManager.getInstance().loadAllImages(paramAppInterface);
    this.jdField_a_of_type_Bqoq.a(paramAppInterface);
    this.jdField_a_of_type_Int = paramInt;
    yuk.b("DoodleOpController", "change stroke" + paramInt);
  }
  
  public void a(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_Bqmp != null) {
      this.jdField_a_of_type_Bqmp.a(paramRunnable);
    }
  }
  
  public boolean a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      if (((bqns)localIterator.next()).jdField_a_of_type_Int == 102) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(int paramInt, MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    int i = Math.round(paramMotionEvent.getY());
    int j = Math.round(paramMotionEvent.getX());
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      bqnv localbqnv = a(paramInt);
      if (localbqnv != null) {
        bool = localbqnv.a(paramMotionEvent);
      }
      return bool;
      this.c = Math.round(paramMotionEvent.getX());
      this.d = Math.round(paramMotionEvent.getY());
      continue;
      if ((Math.abs(j - this.c) < 3) && (Math.abs(i - this.d) < 3) && (this.jdField_a_of_type_Bqns != null))
      {
        this.jdField_a_of_type_Bqns = null;
        continue;
        if (((Math.abs(j - this.c) >= 3) || (Math.abs(i - this.d) >= 3)) && (this.jdField_a_of_type_Bqns != null))
        {
          k();
          this.jdField_a_of_type_Bqns = null;
        }
      }
    }
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty())) {
      return false;
    }
    try
    {
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = ((CopyOnWriteArrayList)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clone()).iterator();
      while (localIterator.hasNext())
      {
        bqns localbqns = (bqns)localIterator.next();
        JSONObject localJSONObject = localbqns.a();
        if ((localJSONObject != null) && ((localbqns instanceof bqok)))
        {
          localJSONObject.put("mosaicBitmapW", this.jdField_a_of_type_Bqol.i);
          localJSONObject.put("mosaicBitmapH", this.jdField_a_of_type_Bqol.j);
        }
        localJSONArray.put(localJSONObject);
      }
      paramJSONObject.put(bqjt.jdField_a_of_type_JavaLangString, localJSONArray);
      return true;
    }
    catch (Exception paramJSONObject) {}
    return false;
  }
  
  public int[] a()
  {
    int[] arrayOfInt = new int[2];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 0;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    tmp9_5;
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty()) {
      return arrayOfInt;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      bqns localbqns = (bqns)localIterator.next();
      if ((localbqns.jdField_a_of_type_Int == 103) || (localbqns.jdField_a_of_type_Int == 104)) {
        arrayOfInt[1] += 1;
      } else {
        arrayOfInt[0] += 1;
      }
    }
    return arrayOfInt;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
  }
  
  public void b()
  {
    c();
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoodleOpController", 2, "savePersonality start");
    }
    this.jdField_a_of_type_Bqoq.a(paramInt);
    try
    {
      this.f = 0;
      this.jdField_a_of_type_Boolean = true;
      while ((this.f < 25) && (this.jdField_a_of_type_Boolean))
      {
        Thread.sleep(200L);
        this.f += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DoodleOpController", 2, "savePersonality error " + localException.toString());
      }
      if (QLog.isColorLevel()) {
        QLog.d("DoodleOpController", 2, "savePersonality end");
      }
    }
  }
  
  public void b(Canvas paramCanvas, float paramFloat)
  {
    paramCanvas.save();
    paramCanvas.scale(paramFloat, paramFloat);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (bqns)localIterator.next();
      if (((bqns)localObject).jdField_a_of_type_Int == 101)
      {
        localObject = new bqot((bqns)localObject, 1.0F);
        this.jdField_a_of_type_Bqou.a(paramCanvas, (bqns)localObject, this.jdField_a_of_type_Bqou.a());
      }
    }
    paramCanvas.restore();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Bqoq.d;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public void c(int paramInt)
  {
    if (paramInt != this.jdField_b_of_type_Int)
    {
      if (paramInt != 0) {
        break label55;
      }
      h();
      this.jdField_a_of_type_Bqoq.a(false);
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = paramInt;
      yuk.b("DoodleOpController", "refresh visibility:" + paramInt);
      return;
      label55:
      this.jdField_a_of_type_Bqoq.i();
    }
  }
  
  public void c(Canvas paramCanvas, float paramFloat)
  {
    paramCanvas.save();
    paramCanvas.scale(paramFloat, paramFloat);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (bqns)localIterator.next();
      if (((bqns)localObject).jdField_a_of_type_Int == 104)
      {
        localObject = new bqok((bqns)localObject, 1.0F);
        this.jdField_a_of_type_Bqol.a(paramCanvas, (bqok)localObject, 0.0F);
      }
    }
    paramCanvas.restore();
  }
  
  public boolean c()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty())
    {
      bqns localbqns = (bqns)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() - 1);
      this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localbqns);
      yuq.a("0X80076BF");
      yuq.b("0X80075CC");
      if ((localbqns.jdField_a_of_type_Int == 103) || (localbqns.jdField_a_of_type_Int == 104) || (localbqns.jdField_a_of_type_Int == 105)) {
        this.jdField_a_of_type_Bqol.a((bqok)localbqns);
      }
      for (;;)
      {
        return true;
        if (localbqns.jdField_a_of_type_Int == 102)
        {
          h();
          this.jdField_a_of_type_Bqoq.f();
        }
      }
    }
    return false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Bqoq.a();
  }
  
  public void d(int paramInt)
  {
    if (paramInt == 101) {
      this.jdField_a_of_type_Bqou.a();
    }
    do
    {
      return;
      if (paramInt == 104)
      {
        this.jdField_a_of_type_Bqol.a();
        return;
      }
    } while (paramInt != 105);
    this.jdField_a_of_type_Bqol.a();
  }
  
  public boolean d()
  {
    if (a()) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty()) {
      return true;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      if (((bqns)localIterator.next()).jdField_a_of_type_Int != 103) {
        return false;
      }
    }
    return true;
  }
  
  public void e()
  {
    System.currentTimeMillis();
    this.jdField_a_of_type_Bqoq.d();
    System.currentTimeMillis();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
    {
      Object localObject = (bqns)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
      if (((bqns)localObject).jdField_a_of_type_Int == 102)
      {
        localObject = (bqop)localObject;
        this.jdField_a_of_type_Bqoq.a((bqop)localObject);
      }
      i += 1;
    }
    System.currentTimeMillis();
    this.jdField_a_of_type_Bqoq.e();
    System.currentTimeMillis();
    if (QLog.isColorLevel()) {}
  }
  
  public void f()
  {
    if (!this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty())
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        ((bqns)localIterator.next()).a();
      }
    }
  }
  
  public void g()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty())
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
      {
        ((bqns)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i)).a();
        i += 1;
      }
    }
    if (!this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty())
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        ((bqns)localIterator.next()).a();
      }
    }
    yuk.b("Personality", "releaseAllPaths");
  }
  
  public void h()
  {
    int i = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        if (((bqns)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i)).jdField_a_of_type_Int == 102)
        {
          bqop localbqop = (bqop)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
          localbqop.jdField_a_of_type_Boolean = false;
          if (!localbqop.c) {}
        }
      }
      else {
        return;
      }
      i -= 1;
    }
  }
  
  public void i()
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_Bqou.b();
    this.jdField_a_of_type_Bqol.d();
    this.jdField_a_of_type_Bqoq.h();
  }
  
  public void j()
  {
    Object localObject1 = new HashSet();
    Object localObject2 = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (bqns)((Iterator)localObject2).next();
      if (((bqns)localObject3).jdField_a_of_type_Int == 102)
      {
        localObject3 = a(((bqop)localObject3).jdField_a_of_type_JavaLangString, 1);
        if (!((HashSet)localObject1).contains(localObject3)) {
          ((HashSet)localObject1).add(localObject3);
        }
      }
    }
    localObject1 = ((HashSet)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (DoodleLayout.jdField_a_of_type_Boolean) {
        yuq.b((String)localObject2);
      } else {
        yuq.a((String)localObject2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqnt
 * JD-Core Version:    0.7.0.1
 */