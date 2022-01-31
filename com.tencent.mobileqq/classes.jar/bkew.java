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

public class bkew
  implements bkeu
{
  int jdField_a_of_type_Int = -1;
  public Bitmap a;
  bkds jdField_a_of_type_Bkds;
  bkev jdField_a_of_type_Bkev = null;
  bkex jdField_a_of_type_Bkex;
  bkfo jdField_a_of_type_Bkfo = new bkfo(this);
  public bkft a;
  bkfx jdField_a_of_type_Bkfx = new bkfx(this);
  public CopyOnWriteArrayList<bkev> a;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = -1;
  CopyOnWriteArrayList<bkev> jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private boolean jdField_b_of_type_Boolean;
  int c = -1;
  int d = -1;
  int e = -1;
  int f = 0;
  
  public bkew()
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_Bkft = new bkft(this);
  }
  
  private void k()
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(this.jdField_a_of_type_Bkev);
    String str;
    if (this.jdField_a_of_type_Bkev.jdField_a_of_type_Int == 102)
    {
      str = ((bkfs)this.jdField_a_of_type_Bkev).jdField_a_of_type_JavaLangString;
      if (!DoodleLayout.jdField_a_of_type_Boolean) {
        break label73;
      }
      vej.b(a(str, 0));
    }
    for (;;)
    {
      if (this.e != -1) {
        ((bkfs)this.jdField_a_of_type_Bkev).jdField_b_of_type_Int = this.e;
      }
      return;
      label73:
      vej.a(a(str, 0));
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public bkey a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 101: 
      return this.jdField_a_of_type_Bkfx;
    case 102: 
      return this.jdField_a_of_type_Bkft;
    }
    return this.jdField_a_of_type_Bkfo;
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
  
  public List<bkev> a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bkds != null) {
      this.jdField_a_of_type_Bkds.a();
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoodleOpController", 2, "preSavePersonality");
    }
    this.jdField_a_of_type_Bkft.a(paramInt);
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Bkex != null) {
      this.jdField_a_of_type_Bkex.a();
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
      bkev localbkev = (bkev)localIterator.next();
      if (localbkev.jdField_a_of_type_Int == 104) {
        this.jdField_a_of_type_Bkfo.a(paramCanvas, (bkfn)localbkev, 0.0F);
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
      localObject2 = (bkev)((Iterator)localObject3).next();
      if (((bkev)localObject2).jdField_a_of_type_Int != 105) {
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
        localObject3 = (bkev)((Iterator)localObject2).next();
        if (((bkev)localObject3).jdField_a_of_type_Int == 101)
        {
          this.jdField_b_of_type_Boolean = true;
          this.jdField_a_of_type_Bkfx.a(paramCanvas, (bkev)localObject3, this.jdField_a_of_type_Bkfx.b());
        }
        else if (((bkev)localObject3).jdField_a_of_type_Int == 105)
        {
          this.jdField_b_of_type_Boolean = true;
          this.jdField_a_of_type_Bkfo.a(paramCanvas, (bkfn)localObject3, paramFloat);
          if (localObject3 == localObject1) {
            this.jdField_a_of_type_Bkfo.c();
          }
        }
      }
      if ((localObject1 == null) && (this.jdField_b_of_type_Boolean)) {
        this.jdField_a_of_type_Bkfo.a(true);
      }
      this.jdField_a_of_type_Bkfx.a();
      return;
    }
  }
  
  public void a(bkds parambkds)
  {
    this.jdField_a_of_type_Bkds = parambkds;
  }
  
  public void a(bkev parambkev)
  {
    this.jdField_a_of_type_Bkev = parambkev;
  }
  
  public void a(bkex parambkex)
  {
    this.jdField_a_of_type_Bkex = parambkex;
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
    this.jdField_a_of_type_Bkft.a(paramAppInterface);
    this.jdField_a_of_type_Int = paramInt;
    ved.b("DoodleOpController", "change stroke" + paramInt);
  }
  
  public void a(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_Bkds != null) {
      this.jdField_a_of_type_Bkds.a(paramRunnable);
    }
  }
  
  public boolean a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      if (((bkev)localIterator.next()).jdField_a_of_type_Int == 102) {
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
      bkey localbkey = a(paramInt);
      if (localbkey != null) {
        bool = localbkey.a(paramMotionEvent);
      }
      return bool;
      this.c = Math.round(paramMotionEvent.getX());
      this.d = Math.round(paramMotionEvent.getY());
      continue;
      if ((Math.abs(j - this.c) < 3) && (Math.abs(i - this.d) < 3) && (this.jdField_a_of_type_Bkev != null))
      {
        this.jdField_a_of_type_Bkev = null;
        continue;
        if (((Math.abs(j - this.c) >= 3) || (Math.abs(i - this.d) >= 3)) && (this.jdField_a_of_type_Bkev != null))
        {
          k();
          this.jdField_a_of_type_Bkev = null;
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
        bkev localbkev = (bkev)localIterator.next();
        JSONObject localJSONObject = localbkev.a();
        if ((localJSONObject != null) && ((localbkev instanceof bkfn)))
        {
          localJSONObject.put("mosaicBitmapW", this.jdField_a_of_type_Bkfo.i);
          localJSONObject.put("mosaicBitmapH", this.jdField_a_of_type_Bkfo.j);
        }
        localJSONArray.put(localJSONObject);
      }
      paramJSONObject.put(bkaw.jdField_a_of_type_JavaLangString, localJSONArray);
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
      bkev localbkev = (bkev)localIterator.next();
      if ((localbkev.jdField_a_of_type_Int == 103) || (localbkev.jdField_a_of_type_Int == 104)) {
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
  
  public List<String> b()
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
        localObject = (bkev)localIterator1.next();
        if (((bkev)localObject).jdField_a_of_type_Int == 102)
        {
          localObject = (bkfs)localObject;
          Iterator localIterator2 = localArrayList.iterator();
          do
          {
            if (!localIterator2.hasNext()) {
              break;
            }
          } while (!TextUtils.equals((String)localIterator2.next(), ((bkfs)localObject).jdField_a_of_type_JavaLangString));
        }
      }
      else
      {
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label130;
          }
          localArrayList.add(((bkfs)localObject).jdField_a_of_type_JavaLangString);
          break;
          return localArrayList;
        }
      }
    }
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
    this.jdField_a_of_type_Bkft.a(paramInt);
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
      Object localObject = (bkev)localIterator.next();
      if (((bkev)localObject).jdField_a_of_type_Int == 101)
      {
        localObject = new bkfw((bkev)localObject, 1.0F);
        this.jdField_a_of_type_Bkfx.a(paramCanvas, (bkev)localObject, this.jdField_a_of_type_Bkfx.a());
      }
    }
    paramCanvas.restore();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Bkft.d;
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
      this.jdField_a_of_type_Bkft.a(false);
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = paramInt;
      ved.b("DoodleOpController", "refresh visibility:" + paramInt);
      return;
      label55:
      this.jdField_a_of_type_Bkft.i();
    }
  }
  
  public void c(Canvas paramCanvas, float paramFloat)
  {
    paramCanvas.save();
    paramCanvas.scale(paramFloat, paramFloat);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (bkev)localIterator.next();
      if (((bkev)localObject).jdField_a_of_type_Int == 104)
      {
        localObject = new bkfn((bkev)localObject, 1.0F);
        this.jdField_a_of_type_Bkfo.a(paramCanvas, (bkfn)localObject, 0.0F);
      }
    }
    paramCanvas.restore();
  }
  
  public boolean c()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty())
    {
      bkev localbkev = (bkev)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() - 1);
      this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localbkev);
      vej.a("0X80076BF");
      vej.b("0X80075CC");
      if ((localbkev.jdField_a_of_type_Int == 103) || (localbkev.jdField_a_of_type_Int == 104) || (localbkev.jdField_a_of_type_Int == 105)) {
        this.jdField_a_of_type_Bkfo.a((bkfn)localbkev);
      }
      for (;;)
      {
        return true;
        if (localbkev.jdField_a_of_type_Int == 102)
        {
          h();
          this.jdField_a_of_type_Bkft.f();
        }
      }
    }
    return false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Bkft.a();
  }
  
  public void d(int paramInt)
  {
    if (paramInt == 101) {
      this.jdField_a_of_type_Bkfx.a();
    }
    do
    {
      return;
      if (paramInt == 104)
      {
        this.jdField_a_of_type_Bkfo.a();
        return;
      }
    } while (paramInt != 105);
    this.jdField_a_of_type_Bkfo.a();
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
      if (((bkev)localIterator.next()).jdField_a_of_type_Int != 103) {
        return false;
      }
    }
    return true;
  }
  
  public void e()
  {
    System.currentTimeMillis();
    this.jdField_a_of_type_Bkft.d();
    System.currentTimeMillis();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
    {
      Object localObject = (bkev)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
      if (((bkev)localObject).jdField_a_of_type_Int == 102)
      {
        localObject = (bkfs)localObject;
        this.jdField_a_of_type_Bkft.a((bkfs)localObject);
      }
      i += 1;
    }
    System.currentTimeMillis();
    this.jdField_a_of_type_Bkft.e();
    System.currentTimeMillis();
    if (QLog.isColorLevel()) {}
  }
  
  public void f()
  {
    if (!this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty())
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        ((bkev)localIterator.next()).a();
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
        ((bkev)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i)).a();
        i += 1;
      }
    }
    if (!this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty())
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        ((bkev)localIterator.next()).a();
      }
    }
    ved.b("Personality", "releaseAllPaths");
  }
  
  public void h()
  {
    int i = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        if (((bkev)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i)).jdField_a_of_type_Int == 102)
        {
          bkfs localbkfs = (bkfs)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
          localbkfs.jdField_a_of_type_Boolean = false;
          if (!localbkfs.c) {}
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
    this.jdField_a_of_type_Bkfx.b();
    this.jdField_a_of_type_Bkfo.d();
    this.jdField_a_of_type_Bkft.h();
  }
  
  public void j()
  {
    Object localObject1 = new HashSet();
    Object localObject2 = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (bkev)((Iterator)localObject2).next();
      if (((bkev)localObject3).jdField_a_of_type_Int == 102)
      {
        localObject3 = a(((bkfs)localObject3).jdField_a_of_type_JavaLangString, 1);
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
        vej.b((String)localObject2);
      } else {
        vej.a((String)localObject2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkew
 * JD-Core Version:    0.7.0.1
 */