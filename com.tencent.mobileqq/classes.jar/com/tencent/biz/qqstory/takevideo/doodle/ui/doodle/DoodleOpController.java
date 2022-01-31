package com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.TemplateParser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.cache.ImageMemoryManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DoodleOpController
  implements DoodleLineListener
{
  int jdField_a_of_type_Int = -1;
  public Bitmap a;
  DoodleGLCallback jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleGLCallback;
  DoodleLinePath jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLinePath = null;
  DoodleOpController.DoodleOpListener jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController$DoodleOpListener;
  MosaicOperator jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicOperator = new MosaicOperator(this);
  PersonalityOperator jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityOperator = new PersonalityOperator(this);
  PureOperator jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodlePureOperator = new PureOperator(this);
  CopyOnWriteArrayList jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = -1;
  CopyOnWriteArrayList jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  int c = -1;
  int d = -1;
  int e = -1;
  int f = 0;
  
  private boolean a(int paramInt)
  {
    return (paramInt == 103) || (paramInt == 104) || (paramInt == 105);
  }
  
  private void k()
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLinePath);
    String str;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLinePath.jdField_a_of_type_Int == 102)
    {
      str = ((PersonalityLinePath)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLinePath).jdField_a_of_type_JavaLangString;
      if (!DoodleLayout.jdField_a_of_type_Boolean) {
        break label73;
      }
      VideoEditReport.b(a(str, 0));
    }
    for (;;)
    {
      if (this.e != -1) {
        ((PersonalityLinePath)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLinePath).jdField_b_of_type_Int = this.e;
      }
      return;
      label73:
      VideoEditReport.a(a(str, 0));
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
  }
  
  public DoodleOperator a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 101: 
      return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodlePureOperator;
    case 102: 
      return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityOperator;
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicOperator;
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
  
  public List a()
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
        localObject = (DoodleLinePath)localIterator1.next();
        if (((DoodleLinePath)localObject).jdField_a_of_type_Int == 102)
        {
          localObject = (PersonalityLinePath)localObject;
          Iterator localIterator2 = localArrayList.iterator();
          do
          {
            if (!localIterator2.hasNext()) {
              break;
            }
          } while (!TextUtils.equals((String)localIterator2.next(), ((PersonalityLinePath)localObject).jdField_a_of_type_JavaLangString));
        }
      }
      else
      {
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label130;
          }
          localArrayList.add(((PersonalityLinePath)localObject).jdField_a_of_type_JavaLangString);
          break;
          return localArrayList;
        }
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleGLCallback != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleGLCallback.a();
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoodleOpController", 2, "preSavePersonality");
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityOperator.a(paramInt);
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController$DoodleOpListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController$DoodleOpListener.a();
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
      DoodleLinePath localDoodleLinePath = (DoodleLinePath)localIterator.next();
      if (localDoodleLinePath.jdField_a_of_type_Int == 104) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicOperator.a(paramCanvas, (MosaicLinePath)localDoodleLinePath, 0.0F);
      }
    }
  }
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty()) && (Build.MODEL.contains("vivo X5"))) {
      paramCanvas.drawColor(0);
    }
    Object localObject1 = null;
    Object localObject3 = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    Object localObject2;
    if (((Iterator)localObject3).hasNext())
    {
      localObject2 = (DoodleLinePath)((Iterator)localObject3).next();
      if (((DoodleLinePath)localObject2).jdField_a_of_type_Int != 105) {
        break label196;
      }
      localObject1 = localObject2;
    }
    label196:
    for (;;)
    {
      break;
      localObject2 = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (DoodleLinePath)((Iterator)localObject2).next();
        if (((DoodleLinePath)localObject3).jdField_a_of_type_Int == 101)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodlePureOperator.a(paramCanvas, (DoodleLinePath)localObject3, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodlePureOperator.b());
        }
        else if (((DoodleLinePath)localObject3).jdField_a_of_type_Int == 105)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicOperator.a(paramCanvas, (MosaicLinePath)localObject3, paramFloat);
          if (localObject3 == localObject1) {
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicOperator.c();
          }
        }
      }
      if (localObject1 == null) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicOperator.a(true);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodlePureOperator.a();
      return;
    }
  }
  
  public void a(DoodleGLCallback paramDoodleGLCallback)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleGLCallback = paramDoodleGLCallback;
  }
  
  public void a(DoodleLinePath paramDoodleLinePath)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLinePath = paramDoodleLinePath;
  }
  
  public void a(DoodleOpController.DoodleOpListener paramDoodleOpListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController$DoodleOpListener = paramDoodleOpListener;
  }
  
  public void a(AppInterface paramAppInterface, int paramInt)
  {
    this.e = -1;
    if (this.jdField_a_of_type_Int == paramInt) {}
    do
    {
      return;
      paramAppInterface = PtvTemplateManager.a(paramAppInterface).b(paramInt);
      if (paramAppInterface != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("DoodleOpController", 2, "changeStroke error ");
    return;
    paramAppInterface = TemplateParser.a(paramAppInterface, "params");
    ImageMemoryManager.getInstance().loadAllImages(paramAppInterface);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityOperator.a(paramAppInterface);
    this.jdField_a_of_type_Int = paramInt;
    SLog.b("DoodleOpController", "change stroke" + paramInt);
  }
  
  public void a(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleGLCallback != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleGLCallback.a(paramRunnable);
    }
  }
  
  public boolean a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      if (((DoodleLinePath)localIterator.next()).jdField_a_of_type_Int == 102) {
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
      DoodleOperator localDoodleOperator = a(paramInt);
      if (localDoodleOperator != null) {
        bool = localDoodleOperator.a(paramMotionEvent);
      }
      return bool;
      this.c = Math.round(paramMotionEvent.getX());
      this.d = Math.round(paramMotionEvent.getY());
      continue;
      if ((Math.abs(j - this.c) < 3) && (Math.abs(i - this.d) < 3) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLinePath != null))
      {
        if (a(paramInt)) {
          k();
        }
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLinePath = null;
        continue;
        if (((Math.abs(j - this.c) >= 3) || (Math.abs(i - this.d) >= 3)) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLinePath != null))
        {
          k();
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLinePath = null;
        }
      }
    }
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
      DoodleLinePath localDoodleLinePath = (DoodleLinePath)localIterator.next();
      if ((localDoodleLinePath.jdField_a_of_type_Int == 103) || (localDoodleLinePath.jdField_a_of_type_Int == 104)) {
        arrayOfInt[1] += 1;
      } else {
        arrayOfInt[0] += 1;
      }
    }
    return arrayOfInt;
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
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityOperator.a(paramInt);
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
      Object localObject = (DoodleLinePath)localIterator.next();
      if (((DoodleLinePath)localObject).jdField_a_of_type_Int == 101)
      {
        localObject = new PureLinePath((DoodleLinePath)localObject, 1.0F);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodlePureOperator.a(paramCanvas, (DoodleLinePath)localObject, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodlePureOperator.a());
      }
    }
    paramCanvas.restore();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityOperator.d;
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
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityOperator.a(false);
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = paramInt;
      SLog.b("DoodleOpController", "refresh visibility:" + paramInt);
      return;
      label55:
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityOperator.h();
    }
  }
  
  public void c(Canvas paramCanvas, float paramFloat)
  {
    paramCanvas.save();
    paramCanvas.scale(paramFloat, paramFloat);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (DoodleLinePath)localIterator.next();
      if (((DoodleLinePath)localObject).jdField_a_of_type_Int == 104)
      {
        localObject = new MosaicLinePath((DoodleLinePath)localObject, 1.0F);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicOperator.a(paramCanvas, (MosaicLinePath)localObject, 0.0F);
      }
    }
    paramCanvas.restore();
  }
  
  public boolean c()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty())
    {
      DoodleLinePath localDoodleLinePath = (DoodleLinePath)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() - 1);
      this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localDoodleLinePath);
      VideoEditReport.a("0X80076BF");
      VideoEditReport.b("0X80075CC");
      if ((localDoodleLinePath.jdField_a_of_type_Int == 103) || (localDoodleLinePath.jdField_a_of_type_Int == 104) || (localDoodleLinePath.jdField_a_of_type_Int == 105)) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicOperator.a((MosaicLinePath)localDoodleLinePath);
      }
      for (;;)
      {
        return true;
        if (localDoodleLinePath.jdField_a_of_type_Int == 102)
        {
          h();
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityOperator.f();
        }
      }
    }
    return false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityOperator.a();
  }
  
  public void d(int paramInt)
  {
    if (paramInt == 101) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodlePureOperator.a();
    }
    do
    {
      return;
      if (paramInt == 104)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicOperator.a();
        return;
      }
    } while (paramInt != 105);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicOperator.a();
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
      if (((DoodleLinePath)localIterator.next()).jdField_a_of_type_Int != 103) {
        return false;
      }
    }
    return true;
  }
  
  public void e()
  {
    System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityOperator.d();
    System.currentTimeMillis();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
    {
      Object localObject = (DoodleLinePath)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
      if (((DoodleLinePath)localObject).jdField_a_of_type_Int == 102)
      {
        localObject = (PersonalityLinePath)localObject;
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityOperator.a((PersonalityLinePath)localObject);
      }
      i += 1;
    }
    System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityOperator.e();
    System.currentTimeMillis();
    if (QLog.isColorLevel()) {}
  }
  
  public void f()
  {
    if (!this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty())
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        ((DoodleLinePath)localIterator.next()).a();
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
        ((DoodleLinePath)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i)).a();
        i += 1;
      }
    }
    if (!this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty())
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        ((DoodleLinePath)localIterator.next()).a();
      }
    }
    SLog.b("Personality", "releaseAllPaths");
  }
  
  public void h()
  {
    int i = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        if (((DoodleLinePath)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i)).jdField_a_of_type_Int == 102)
        {
          PersonalityLinePath localPersonalityLinePath = (PersonalityLinePath)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
          localPersonalityLinePath.jdField_a_of_type_Boolean = false;
          if (!localPersonalityLinePath.c) {}
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
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodlePureOperator.b();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleMosaicOperator.d();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityOperator.g();
  }
  
  public void j()
  {
    Object localObject1 = new HashSet();
    Object localObject2 = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (DoodleLinePath)((Iterator)localObject2).next();
      if (((DoodleLinePath)localObject3).jdField_a_of_type_Int == 102)
      {
        localObject3 = a(((PersonalityLinePath)localObject3).jdField_a_of_type_JavaLangString, 1);
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
        VideoEditReport.b((String)localObject2);
      } else {
        VideoEditReport.a((String)localObject2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleOpController
 * JD-Core Version:    0.7.0.1
 */