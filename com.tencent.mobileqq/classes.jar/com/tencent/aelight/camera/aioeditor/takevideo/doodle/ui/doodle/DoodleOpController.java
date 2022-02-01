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
  private int jdField_a_of_type_Int = -1;
  public Bitmap a;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private DoodleGLCallback jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleGLCallback;
  private DoodleLinePath jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLinePath = null;
  private DoodleOpController.DoodleOpListener jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleOpController$DoodleOpListener;
  private EraserOperator jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleEraserOperator = new EraserOperator(this);
  private MosaicOperator jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicOperator = new MosaicOperator(this);
  private PersonalityOperator jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodlePersonalityOperator = new PersonalityOperator(this);
  private PureOperator jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodlePureOperator = new PureOperator(this);
  private final CopyOnWriteArrayList<DoodleLinePath> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = -1;
  private CopyOnWriteArrayList<DoodleLinePath> jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private boolean jdField_b_of_type_Boolean = false;
  private int c = -1;
  private int d = -1;
  private int e = -1;
  private int f = 0;
  
  public DoodleOpController(Context paramContext) {}
  
  private void k()
  {
    AEQLog.b("DoodleOpController", "realAddLinePath---");
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLinePath);
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLinePath.jdField_a_of_type_Int == 102)
    {
      String str = ((PersonalityLinePath)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLinePath).jdField_a_of_type_JavaLangString;
      if (DoodleLayout.jdField_a_of_type_Boolean) {
        VideoEditReport.b(a(str, 0));
      } else {
        VideoEditReport.a(a(str, 0));
      }
      int i = this.e;
      if (i != -1) {
        ((PersonalityLinePath)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLinePath).jdField_b_of_type_Int = i;
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
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
        return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicOperator;
      case 102: 
        return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodlePersonalityOperator;
      }
      return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodlePureOperator;
    }
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleEraserOperator;
  }
  
  public EraserOperator a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleEraserOperator;
  }
  
  public String a()
  {
    Object localObject1 = new HashSet();
    Object localObject2 = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      DoodleLinePath localDoodleLinePath = (DoodleLinePath)((Iterator)localObject2).next();
      if (localDoodleLinePath != null)
      {
        int i = localDoodleLinePath.jdField_a_of_type_Int;
        if (i != 101)
        {
          if (i != 111) {
            switch (i)
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
  
  String a(String paramString, int paramInt)
  {
    if ("doodle_fireworks".equals(paramString))
    {
      if (paramInt == 0)
      {
        if (DoodleLayout.jdField_a_of_type_Boolean) {
          return "0X80079F0";
        }
        return "0X80079EE";
      }
      if (paramInt == 1)
      {
        if (DoodleLayout.jdField_a_of_type_Boolean) {
          return "0X80079F1";
        }
        return "0X80079EF";
      }
    }
    else if ("doodle_image_xin".equals(paramString))
    {
      if (paramInt == 0)
      {
        if (DoodleLayout.jdField_a_of_type_Boolean) {
          return "0X80079EB";
        }
        return "0X80079E9";
      }
      if (paramInt == 1)
      {
        if (DoodleLayout.jdField_a_of_type_Boolean) {
          return "0X80079EC";
        }
        return "0X80079EA";
      }
    }
    else if ("doodle_image_mouth".equals(paramString))
    {
      if (paramInt == 0)
      {
        if (DoodleLayout.jdField_a_of_type_Boolean) {
          return "0X80079E7";
        }
        return "0X80079E5";
      }
      if (paramInt == 1)
      {
        if (DoodleLayout.jdField_a_of_type_Boolean) {
          return "0X80079E8";
        }
        return "0X80079E6";
      }
    }
    else if ("doodle_highlighter".equals(paramString))
    {
      if (paramInt == 0)
      {
        if (DoodleLayout.jdField_a_of_type_Boolean) {
          return "0X80079E3";
        }
        return "0X8007C0A";
      }
      if (paramInt == 1)
      {
        if (DoodleLayout.jdField_a_of_type_Boolean) {
          return "0X80079E4";
        }
        return "0X8007C0B";
      }
    }
    else if ("doodle_image_family".equals(paramString))
    {
      if (paramInt == 0)
      {
        if (DoodleLayout.jdField_a_of_type_Boolean) {
          return "0X8007C06";
        }
        return "0X8007C08";
      }
      if (paramInt == 1)
      {
        if (DoodleLayout.jdField_a_of_type_Boolean) {
          return "0X8007C07";
        }
        return "0X8007C09";
      }
    }
    return "";
  }
  
  public List<String> a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty()) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (DoodleLinePath)localIterator1.next();
      if (((DoodleLinePath)localObject).jdField_a_of_type_Int == 102)
      {
        localObject = (PersonalityLinePath)localObject;
        int j = 0;
        Iterator localIterator2 = localArrayList.iterator();
        do
        {
          i = j;
          if (!localIterator2.hasNext()) {
            break;
          }
        } while (!TextUtils.equals((String)localIterator2.next(), ((PersonalityLinePath)localObject).jdField_a_of_type_JavaLangString));
        int i = 1;
        if (i == 0) {
          localArrayList.add(((PersonalityLinePath)localObject).jdField_a_of_type_JavaLangString);
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    DoodleGLCallback localDoodleGLCallback = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleGLCallback;
    if (localDoodleGLCallback != null) {
      localDoodleGLCallback.a();
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoodleOpController", 2, "preSavePersonality");
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodlePersonalityOperator.a(paramInt);
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_b_of_type_Boolean = false;
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleOpController$DoodleOpListener;
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
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      DoodleLinePath localDoodleLinePath = (DoodleLinePath)localIterator.next();
      if (localDoodleLinePath.jdField_a_of_type_Int == 104)
      {
        paramCanvas.save();
        paramCanvas.concat(this.jdField_a_of_type_AndroidGraphicsMatrix);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicOperator.a(paramCanvas, (MosaicLinePath)localDoodleLinePath, 0.0F);
        paramCanvas.restore();
      }
    }
  }
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty()) && (this.jdField_a_of_type_Boolean))
    {
      paramCanvas.drawColor(0);
      this.jdField_a_of_type_Boolean = false;
    }
    Object localObject1 = null;
    Object localObject3 = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject2 = (DoodleLinePath)((Iterator)localObject3).next();
      if (((DoodleLinePath)localObject2).jdField_a_of_type_Int == 105) {
        localObject1 = localObject2;
      }
    }
    Object localObject2 = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (DoodleLinePath)((Iterator)localObject2).next();
      Object localObject4;
      if (((DoodleLinePath)localObject3).jdField_a_of_type_Int == 101)
      {
        this.jdField_a_of_type_Boolean = true;
        localObject4 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodlePureOperator;
        ((PureOperator)localObject4).a(paramCanvas, (DoodleLinePath)localObject3, ((PureOperator)localObject4).b());
      }
      else if (((DoodleLinePath)localObject3).jdField_a_of_type_Int == 105)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicOperator.a(paramCanvas, (MosaicLinePath)localObject3, paramFloat);
        if (localObject3 == localObject1) {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicOperator.c();
        }
      }
      else if (((DoodleLinePath)localObject3).jdField_a_of_type_Int == 111)
      {
        localObject4 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleEraserOperator;
        ((EraserOperator)localObject4).a(paramCanvas, (DoodleLinePath)localObject3, ((EraserOperator)localObject4).b());
      }
    }
    if ((localObject1 == null) && (this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicOperator.a(true);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodlePureOperator.a();
  }
  
  public void a(Matrix paramMatrix)
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.set(paramMatrix);
  }
  
  public void a(DoodleGLCallback paramDoodleGLCallback)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleGLCallback = paramDoodleGLCallback;
  }
  
  public void a(DoodleLinePath paramDoodleLinePath)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLinePath = paramDoodleLinePath;
    if ((paramDoodleLinePath instanceof ShapeLinePath)) {
      k();
    }
  }
  
  public void a(DoodleOpController.DoodleOpListener paramDoodleOpListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleOpController$DoodleOpListener = paramDoodleOpListener;
  }
  
  public void a(AppInterface paramAppInterface, int paramInt)
  {
    this.e = -1;
    if (this.jdField_a_of_type_Int == paramInt) {
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
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodlePersonalityOperator.a(paramAppInterface);
    this.jdField_a_of_type_Int = paramInt;
    paramAppInterface = new StringBuilder();
    paramAppInterface.append("change stroke");
    paramAppInterface.append(paramInt);
    SLog.b("DoodleOpController", paramAppInterface.toString());
  }
  
  public void a(Runnable paramRunnable)
  {
    DoodleGLCallback localDoodleGLCallback = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleGLCallback;
    if (localDoodleGLCallback != null) {
      localDoodleGLCallback.a(paramRunnable);
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
    int i = Math.round(paramMotionEvent.getY());
    int j = Math.round(paramMotionEvent.getX());
    int k = paramMotionEvent.getActionMasked();
    if (k != 0)
    {
      if (k != 1) {
        if (k != 2)
        {
          if (k != 3) {
            break label164;
          }
        }
        else
        {
          if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLinePath == null) || ((Math.abs(j - this.c) < 3) && (Math.abs(i - this.d) < 3)) || (paramMotionEvent.getEventTime() - paramMotionEvent.getDownTime() <= 100L)) {
            break label164;
          }
          k();
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLinePath = null;
          AEQLog.b("DoodleOpController", "clear mCurPath after real add");
          break label164;
        }
      }
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLinePath != null)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLinePath = null;
        AEQLog.b("DoodleOpController", "clear mCurPath when touch up or cancel");
      }
    }
    else
    {
      this.c = Math.round(paramMotionEvent.getX());
      this.d = Math.round(paramMotionEvent.getY());
    }
    label164:
    DoodleOperator localDoodleOperator = a(paramInt);
    if (localDoodleOperator != null) {
      return localDoodleOperator.a(paramMotionEvent);
    }
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
      DoodleLinePath localDoodleLinePath = (DoodleLinePath)localIterator.next();
      if ((localDoodleLinePath.jdField_a_of_type_Int != 103) && (localDoodleLinePath.jdField_a_of_type_Int != 104)) {
        arrayOfInt[0] += 1;
      } else {
        arrayOfInt[1] += 1;
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
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodlePersonalityOperator.a(paramInt);
    try
    {
      this.f = 0;
      this.jdField_b_of_type_Boolean = true;
      while ((this.f < 25) && (this.jdField_b_of_type_Boolean))
      {
        Thread.sleep(200L);
        this.f += 1;
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
  
  public void b(Canvas paramCanvas, float paramFloat)
  {
    paramCanvas.save();
    paramCanvas.scale(paramFloat, paramFloat);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (DoodleLinePath)localIterator.next();
      Object localObject2;
      if (((DoodleLinePath)localObject1).jdField_a_of_type_Int == 101)
      {
        localObject1 = new PureLinePath((DoodleLinePath)localObject1, 1.0F);
        localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodlePureOperator;
        ((PureOperator)localObject2).a(paramCanvas, (DoodleLinePath)localObject1, ((PureOperator)localObject2).a());
      }
      else if (((DoodleLinePath)localObject1).jdField_a_of_type_Int == 111)
      {
        localObject1 = new PureLinePath((DoodleLinePath)localObject1, 1.0F);
        localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleEraserOperator;
        ((EraserOperator)localObject2).a(paramCanvas, (DoodleLinePath)localObject1, ((EraserOperator)localObject2).a());
      }
    }
    paramCanvas.restore();
  }
  
  public boolean b()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty())
    {
      Object localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
      localObject = (DoodleLinePath)((CopyOnWriteArrayList)localObject).remove(((CopyOnWriteArrayList)localObject).size() - 1);
      this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject);
      VideoEditReport.a("0X80076BF");
      VideoEditReport.b("0X80075CC");
      if ((((DoodleLinePath)localObject).jdField_a_of_type_Int != 103) && (((DoodleLinePath)localObject).jdField_a_of_type_Int != 104) && (((DoodleLinePath)localObject).jdField_a_of_type_Int != 105))
      {
        if (((DoodleLinePath)localObject).jdField_a_of_type_Int == 102)
        {
          h();
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodlePersonalityOperator.f();
          return true;
        }
      }
      else {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicOperator.a((MosaicLinePath)localObject);
      }
      return true;
    }
    return false;
  }
  
  public void c()
  {
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public void c(int paramInt)
  {
    if (paramInt != this.jdField_b_of_type_Int)
    {
      if (paramInt == 0)
      {
        h();
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodlePersonalityOperator.a(false);
      }
      else
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodlePersonalityOperator.h();
      }
      this.jdField_b_of_type_Int = paramInt;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refresh visibility:");
      localStringBuilder.append(paramInt);
      SLog.b("DoodleOpController", localStringBuilder.toString());
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
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicOperator.a(paramCanvas, (MosaicLinePath)localObject, 0.0F);
      }
    }
    paramCanvas.restore();
  }
  
  public boolean c()
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
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodlePersonalityOperator.a();
  }
  
  public void d(int paramInt)
  {
    if (paramInt == 101)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodlePureOperator.a();
      return;
    }
    if (paramInt == 104)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicOperator.a();
      return;
    }
    if (paramInt == 105) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicOperator.a();
    }
  }
  
  public void e()
  {
    System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodlePersonalityOperator.d();
    System.currentTimeMillis();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
    {
      Object localObject = (DoodleLinePath)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
      if (((DoodleLinePath)localObject).jdField_a_of_type_Int == 102)
      {
        localObject = (PersonalityLinePath)localObject;
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodlePersonalityOperator.a((PersonalityLinePath)localObject);
      }
      i += 1;
    }
    System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodlePersonalityOperator.e();
    System.currentTimeMillis();
    QLog.isColorLevel();
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
    while (i >= 0)
    {
      if (((DoodleLinePath)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i)).jdField_a_of_type_Int == 102)
      {
        PersonalityLinePath localPersonalityLinePath = (PersonalityLinePath)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
        localPersonalityLinePath.jdField_a_of_type_Boolean = false;
        if (localPersonalityLinePath.c) {
          return;
        }
      }
      i -= 1;
    }
  }
  
  public void i()
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodlePureOperator.b();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleMosaicOperator.d();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodlePersonalityOperator.g();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleEraserOperator.b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleOpController
 * JD-Core Version:    0.7.0.1
 */