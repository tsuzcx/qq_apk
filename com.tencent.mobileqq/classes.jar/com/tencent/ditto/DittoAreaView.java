package com.tencent.ditto;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.ditto.annoations.DittoField;
import com.tencent.ditto.annoations.DittoOnClick;
import com.tencent.ditto.annoations.DittoOnLongClick;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoAreaGroup;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.func.DittoIdFuncPoly;
import com.tencent.ditto.func.DittoIdFuncPolyInf;
import com.tencent.ditto.reflect.DittoValue;
import com.tencent.ditto.shell.DittoUIEngine;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.ditto.utils.DittoLog;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DittoAreaView
  extends View
  implements DittoHost
{
  private static final Map<Class<? extends DittoAreaView>, DittoIdFuncPolyInf> REFLECT_FUNC_POLY_MAP = new ConcurrentHashMap();
  protected static volatile Map<Class<? extends DittoAreaView>, DittoIdFuncPolyInf> sAptIdFuncPolyMap;
  protected final Set<DittoArea> exposureReportingAreas = new HashSet();
  private boolean hardwareAccelerationTurned = false;
  protected DittoArea mDittoArea;
  private DittoHost mHost;
  protected Handler mMainHandler = new Handler(Looper.getMainLooper());
  private List<DittoAreaView.KVCNode> needKVCAreas = Collections.synchronizedList(new ArrayList());
  private Object viewModel;
  
  public DittoAreaView(Context paramContext)
  {
    super(paramContext);
  }
  
  public DittoAreaView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static void classFieldList(Class paramClass, ArrayList<Field> paramArrayList)
  {
    if (paramClass == DittoAreaView.class) {
      return;
    }
    paramArrayList.addAll(Arrays.asList(paramClass.getDeclaredFields()));
    classFieldList(paramClass.getSuperclass(), paramArrayList);
  }
  
  private static void classMethodList(Class paramClass, ArrayList<Method> paramArrayList)
  {
    if (paramClass == DittoAreaView.class) {
      return;
    }
    paramArrayList.addAll(Arrays.asList(paramClass.getDeclaredMethods()));
    classMethodList(paramClass.getSuperclass(), paramArrayList);
  }
  
  private void doSetUIElement(DittoArea paramDittoArea)
  {
    if (this.mDittoArea == paramDittoArea) {
      return;
    }
    this.mDittoArea = paramDittoArea;
    requestLayout();
  }
  
  public static ArrayMap<String, Field> getFields(Class paramClass)
  {
    ArrayMap localArrayMap = new ArrayMap();
    Object localObject = new ArrayList();
    classFieldList(paramClass, (ArrayList)localObject);
    Iterator localIterator = ((ArrayList)localObject).iterator();
    while (localIterator.hasNext())
    {
      Field localField = (Field)localIterator.next();
      paramClass = localField.getAnnotation(DittoField.class);
      if ((paramClass != null) && (DittoArea.class.isAssignableFrom(localField.getType())))
      {
        localObject = ((DittoField)paramClass).value();
        paramClass = (Class)localObject;
        if ("0".equals(localObject)) {
          paramClass = localField.getName();
        }
        localArrayMap.put(paramClass, localField);
      }
    }
    return localArrayMap;
  }
  
  public static int[] getLocationToViewHost(DittoArea paramDittoArea)
  {
    if (paramDittoArea == null) {
      return new int[] { 0, 0 };
    }
    int i = 0;
    int j = 0;
    Object localObject = paramDittoArea;
    int m;
    int k;
    while (localObject != null)
    {
      m = j + ((DittoArea)localObject).getLeft();
      k = i + ((DittoArea)localObject).getTop();
      DittoArea localDittoArea = ((DittoArea)localObject).getParent();
      localObject = localDittoArea;
      i = k;
      j = m;
      if (localDittoArea != null)
      {
        j = m + localDittoArea.getPaddingLeft();
        i = k + localDittoArea.getPaddingTop();
        localObject = localDittoArea;
      }
    }
    if (paramDittoArea.getHost() == null) {
      k = 0;
    } else {
      k = paramDittoArea.getHost().getPaddingTop();
    }
    if (paramDittoArea.getHost() == null) {
      m = 0;
    } else {
      m = paramDittoArea.getHost().getPaddingLeft();
    }
    return new int[] { j + m, i + k };
  }
  
  public static ArrayMap<String, Method>[] getMethods(Class paramClass)
  {
    ArrayMap[] arrayOfArrayMap = new ArrayMap[2];
    arrayOfArrayMap[0] = new ArrayMap();
    arrayOfArrayMap[1] = new ArrayMap();
    Object localObject1 = new ArrayList();
    classMethodList(paramClass, (ArrayList)localObject1);
    paramClass = ((ArrayList)localObject1).iterator();
    while (paramClass.hasNext())
    {
      localObject1 = (Method)paramClass.next();
      Annotation[] arrayOfAnnotation = ((Method)localObject1).getAnnotations();
      int k = arrayOfAnnotation.length;
      int i = 0;
      while (i < k)
      {
        Object localObject2 = arrayOfAnnotation[i];
        String[] arrayOfString;
        int m;
        int j;
        String str;
        if ((localObject2 instanceof DittoOnClick))
        {
          localObject2 = (DittoOnClick)localObject2;
          if (((DittoOnClick)localObject2).values().length != 0)
          {
            arrayOfString = ((DittoOnClick)localObject2).values();
            m = arrayOfString.length;
            j = 0;
            while (j < m)
            {
              str = arrayOfString[j];
              arrayOfArrayMap[0].put(str, localObject1);
              j += 1;
            }
          }
          if ((!((DittoOnClick)localObject2).value().equals("0")) && (!arrayOfArrayMap[0].containsKey(((DittoOnClick)localObject2).value()))) {
            arrayOfArrayMap[0].put(((DittoOnClick)localObject2).value(), localObject1);
          }
        }
        else if ((localObject2 instanceof DittoOnLongClick))
        {
          localObject2 = (DittoOnLongClick)localObject2;
          if (((DittoOnLongClick)localObject2).values().length != 0)
          {
            arrayOfString = ((DittoOnLongClick)localObject2).values();
            m = arrayOfString.length;
            j = 0;
            while (j < m)
            {
              str = arrayOfString[j];
              arrayOfArrayMap[1].put(str, localObject1);
              j += 1;
            }
          }
          if ((!((DittoOnLongClick)localObject2).value().equals("0")) && (!arrayOfArrayMap[1].containsKey(((DittoOnLongClick)localObject2).value()))) {
            arrayOfArrayMap[1].put(((DittoOnLongClick)localObject2).value(), localObject1);
          }
        }
        i += 1;
      }
    }
    return arrayOfArrayMap;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (getTouchDelegate() != null) {
      getTouchDelegate().onTouchEvent(paramMotionEvent);
    }
    int i = getPaddingLeft();
    int j = getPaddingTop();
    paramMotionEvent.offsetLocation(i * -1, j * -1);
    DittoArea localDittoArea = this.mDittoArea;
    if ((localDittoArea != null) && (localDittoArea.dispatchTouchEvent(paramMotionEvent))) {
      return true;
    }
    paramMotionEvent.offsetLocation(i, j);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public DittoArea findAreaById(String paramString)
  {
    if ((this.mDittoArea != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (paramString.equals(this.mDittoArea.getId())) {
        return this.mDittoArea;
      }
      DittoArea localDittoArea = this.mDittoArea;
      if ((localDittoArea instanceof DittoAreaGroup)) {
        return ((DittoAreaGroup)localDittoArea).findChildById(paramString);
      }
    }
    return null;
  }
  
  public DittoArea findAreaByPosition(float paramFloat1, float paramFloat2)
  {
    DittoArea localDittoArea = this.mDittoArea;
    if (localDittoArea != null) {
      return localDittoArea.findTarget(paramFloat1, paramFloat2);
    }
    return null;
  }
  
  public DittoArea getCanvasArea()
  {
    return this.mDittoArea;
  }
  
  public View getContainerView()
  {
    return this;
  }
  
  public Object getCurrentViewModel()
  {
    return this.viewModel;
  }
  
  public void handleSilentRequest(String paramString1, String paramString2, int paramInt, DittoArea paramDittoArea, MotionEvent paramMotionEvent) {}
  
  public void handleSilentUri(String paramString, DittoArea paramDittoArea, MotionEvent paramMotionEvent) {}
  
  public void handleUri(String paramString, DittoArea paramDittoArea, MotionEvent paramMotionEvent) {}
  
  public void invalidate()
  {
    DittoHost localDittoHost = this.mHost;
    if (localDittoHost != null) {
      localDittoHost.invalidate();
    }
    super.invalidate();
  }
  
  public void invalidate(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    DittoHost localDittoHost = this.mHost;
    if (localDittoHost != null) {
      localDittoHost.invalidate(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    super.invalidate(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void invokeAreaClick(String paramString, MotionEvent paramMotionEvent)
  {
    DittoArea localDittoArea = this.mDittoArea;
    if ((localDittoArea instanceof DittoAreaGroup))
    {
      paramString = ((DittoAreaGroup)localDittoArea).findChildById(paramString);
      if (paramString != null) {
        paramString.performClick(paramMotionEvent);
      }
    }
  }
  
  public void onContentDescriptionChanged(DittoArea paramDittoArea)
  {
    DittoHost localDittoHost = this.mHost;
    if (localDittoHost != null) {
      localDittoHost.onContentDescriptionChanged(paramDittoArea);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = paramCanvas.getSaveCount();
    paramCanvas.save();
    paramCanvas.translate(getPaddingLeft(), getPaddingTop());
    DittoArea localDittoArea = this.mDittoArea;
    if (localDittoArea != null) {
      localDittoArea.draw(paramCanvas);
    }
    paramCanvas.restoreToCount(i);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      if (this.mDittoArea != null)
      {
        int i = getPaddingLeft();
        int j = getPaddingTop();
        int k = getPaddingRight();
        int m = getPaddingBottom();
        this.mDittoArea.layout(i, j, paramInt3 - paramInt1 - k, paramInt4 - paramInt2 - m);
        super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
    }
    catch (Exception localException)
    {
      DittoLog.e("DITTO_UI", "layout error", localException);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        int k = getPaddingLeft();
        int i = getPaddingTop();
        int m = getPaddingRight();
        int j = getPaddingBottom();
        if ((this.mDittoArea != null) && (this.mDittoArea.getVisibility() != 8))
        {
          paramInt1 = DittoAreaGroup.getChildMeasureSpec(paramInt1, k + m, this.mDittoArea.getLayoutAttr().width);
          paramInt2 = DittoAreaGroup.getChildMeasureSpec(paramInt2, i + j, this.mDittoArea.getLayoutAttr().height);
          this.mDittoArea.measure(paramInt1, paramInt2);
          paramInt1 = this.mDittoArea.getMeasuredWidth() + k + m;
          paramInt2 = this.mDittoArea.getMeasuredHeight() + i + j;
          setMeasuredDimension(Math.max(paramInt1, getSuggestedMinimumWidth()), Math.max(paramInt2, getSuggestedMinimumHeight()));
          return;
        }
      }
      catch (Exception localException)
      {
        DittoLog.e("DITTO_UI", "measure error", localException);
        setMeasuredDimension(0, 0);
        return;
      }
      paramInt1 = 0;
      paramInt2 = 0;
    }
  }
  
  public void postInvalidate()
  {
    DittoHost localDittoHost = this.mHost;
    if (localDittoHost != null) {
      localDittoHost.postInvalidate();
    }
    super.postInvalidate();
  }
  
  public void postInvalidateDelayed(long paramLong)
  {
    DittoHost localDittoHost = this.mHost;
    if (localDittoHost != null) {
      localDittoHost.postInvalidateDelayed(paramLong);
    }
    super.postInvalidateDelayed(paramLong);
  }
  
  public void removeAccessibilityArea(List<DittoArea> paramList)
  {
    DittoHost localDittoHost = this.mHost;
    if (localDittoHost != null) {
      localDittoHost.removeAccessibilityArea(paramList);
    }
  }
  
  public void reportTTTClick(int paramInt) {}
  
  public void requestLayout()
  {
    DittoHost localDittoHost = this.mHost;
    if (localDittoHost != null) {
      localDittoHost.requestLayout();
    }
    super.requestLayout();
  }
  
  public void setCanvasArea(DittoArea paramDittoArea)
  {
    doSetUIElement(paramDittoArea);
  }
  
  public void setContentAreaForJsonFile(String paramString, boolean paramBoolean)
  {
    this.needKVCAreas.clear();
    Class localClass = getClass();
    DittoIdFuncPolyInf localDittoIdFuncPolyInf;
    if (sAptIdFuncPolyMap != null) {
      localDittoIdFuncPolyInf = (DittoIdFuncPolyInf)sAptIdFuncPolyMap.get(localClass);
    } else {
      localDittoIdFuncPolyInf = null;
    }
    Object localObject = localDittoIdFuncPolyInf;
    if (localDittoIdFuncPolyInf == null)
    {
      localDittoIdFuncPolyInf = (DittoIdFuncPolyInf)REFLECT_FUNC_POLY_MAP.get(localClass);
      localObject = localDittoIdFuncPolyInf;
      if (localDittoIdFuncPolyInf == null)
      {
        localObject = DittoIdFuncPoly.createReflectIdFuncPoly(localClass);
        REFLECT_FUNC_POLY_MAP.put(localClass, localObject);
      }
    }
    this.exposureReportingAreas.clear();
    setCanvasArea(DittoUIEngine.g().inflateDittoArea(this, paramString, new DittoAreaView.1(this, (DittoIdFuncPolyInf)localObject), paramBoolean));
    updateViewModel(getCurrentViewModel());
  }
  
  public void setHost(DittoHost paramDittoHost)
  {
    this.mHost = paramDittoHost;
  }
  
  public void storageViewModel(boolean paramBoolean) {}
  
  public void turnOffHardwareAcceleration()
  {
    if (!this.hardwareAccelerationTurned)
    {
      setLayerType(1, null);
      this.hardwareAccelerationTurned = true;
      DittoHost localDittoHost = this.mHost;
      if (localDittoHost != null) {
        localDittoHost.turnOffHardwareAcceleration();
      }
    }
  }
  
  public void updateViewModel(Object paramObject)
  {
    this.viewModel = paramObject;
    Iterator localIterator1 = this.needKVCAreas.iterator();
    int i = 0;
    while (localIterator1.hasNext())
    {
      DittoAreaView.KVCNode localKVCNode = (DittoAreaView.KVCNode)localIterator1.next();
      if (localKVCNode.area != null)
      {
        LayoutAttrSet localLayoutAttrSet = localKVCNode.area.getLayoutAttr();
        Iterator localIterator2 = localKVCNode.kvcSet.keySet().iterator();
        while (localIterator2.hasNext())
        {
          String str = (String)localIterator2.next();
          Object localObject = (DittoValue)localKVCNode.kvcSet.get(str);
          if (localObject != null)
          {
            localObject = ((DittoValue)localObject).getValue(paramObject);
            if (localObject != null)
            {
              localLayoutAttrSet.addLayoutAttr(str, localObject);
              if (i == 0) {
                i = 1;
              }
            }
          }
        }
        localKVCNode.area.setLayoutAttr(localLayoutAttrSet);
      }
    }
    if (i != 0) {
      requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ditto.DittoAreaView
 * JD-Core Version:    0.7.0.1
 */