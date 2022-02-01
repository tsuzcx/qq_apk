package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.InputFilter;
import android.text.StaticLayout;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer.TextItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.GestureHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public abstract class DynamicTextItem
{
  private static final String jdField_a_of_type_JavaLangString = "DynamicTextItem";
  protected int a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Handler jdField_a_of_type_AndroidOsHandler = null;
  private volatile DynamicTextItem.Pair<Integer, Boolean> jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem$Pair = new DynamicTextItem.Pair(Integer.valueOf(-1), Boolean.valueOf(false));
  private DynamicTextItem.TextMap jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem$TextMap;
  public Stack<Integer> a;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  StaticLayout jdField_b_of_type_AndroidTextStaticLayout;
  private volatile boolean jdField_b_of_type_Boolean = false;
  private int c;
  protected boolean c;
  public boolean d;
  private volatile boolean e = false;
  
  public DynamicTextItem(int paramInt, @NonNull List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilStack = new Stack();
    this.jdField_c_of_type_Int = 0;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem$TextMap = new DynamicTextItem.TextMap(paramList);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.parseColor("#12b7f5"));
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setPathEffect(new DashPathEffect(new float[] { 6.0F, 7.0F }, 1.0F));
  }
  
  private int a(int paramInt)
  {
    int i;
    if (paramInt >= 0)
    {
      i = paramInt;
      if (paramInt < a()) {}
    }
    else
    {
      i = 0;
    }
    return i;
  }
  
  public abstract float a();
  
  public float a(StaticLayout paramStaticLayout)
  {
    float f = 0.0F;
    if (paramStaticLayout == null) {
      return 0.0F;
    }
    int i = 0;
    while (i < paramStaticLayout.getLineCount())
    {
      f = Math.max(f, paramStaticLayout.getLineWidth(i));
      i += 1;
    }
    return f;
  }
  
  public abstract int a();
  
  public int a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return -1;
  }
  
  public int a(@NonNull MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2, @Nullable TextLayer.TextItem paramTextItem, GestureHelper paramGestureHelper)
  {
    if (QLog.isColorLevel())
    {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "=========================================");
      Object localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Touch X: ");
      localStringBuilder.append(paramMotionEvent.getX());
      QLog.d((String)localObject, 2, localStringBuilder.toString());
      localObject = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Touch Y: ");
      localStringBuilder.append(paramMotionEvent.getY());
      QLog.d((String)localObject, 2, localStringBuilder.toString());
      paramMotionEvent = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Container W: ");
      ((StringBuilder)localObject).append(paramFloat1);
      QLog.d(paramMotionEvent, 2, ((StringBuilder)localObject).toString());
      paramMotionEvent = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Container H: ");
      ((StringBuilder)localObject).append(paramFloat2);
      QLog.d(paramMotionEvent, 2, ((StringBuilder)localObject).toString());
      if (paramTextItem == null)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "Text Zoom info is null, use default info");
        paramMotionEvent = jdField_a_of_type_JavaLangString;
        paramTextItem = new StringBuilder();
        paramTextItem.append("Text W: ");
        paramTextItem.append(a());
        QLog.d(paramMotionEvent, 2, paramTextItem.toString());
        paramMotionEvent = jdField_a_of_type_JavaLangString;
        paramTextItem = new StringBuilder();
        paramTextItem.append("Text H: ");
        paramTextItem.append(b());
        QLog.d(paramMotionEvent, 2, paramTextItem.toString());
      }
      else
      {
        paramMotionEvent = jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Text X: ");
        ((StringBuilder)localObject).append(paramTextItem.jdField_a_of_type_AndroidGraphicsPointF.x);
        QLog.d(paramMotionEvent, 2, ((StringBuilder)localObject).toString());
        paramMotionEvent = jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Text Y: ");
        ((StringBuilder)localObject).append(paramTextItem.jdField_a_of_type_AndroidGraphicsPointF.y);
        QLog.d(paramMotionEvent, 2, ((StringBuilder)localObject).toString());
        paramMotionEvent = jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Text W: ");
        ((StringBuilder)localObject).append(paramTextItem.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.a());
        QLog.d(paramMotionEvent, 2, ((StringBuilder)localObject).toString());
        paramMotionEvent = jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Text H: ");
        ((StringBuilder)localObject).append(paramTextItem.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.b());
        QLog.d(paramMotionEvent, 2, ((StringBuilder)localObject).toString());
        paramMotionEvent = jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Text Scale: ");
        ((StringBuilder)localObject).append(paramGestureHelper.a(paramTextItem));
        QLog.d(paramMotionEvent, 2, ((StringBuilder)localObject).toString());
        paramMotionEvent = jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Text Matrix: ");
        ((StringBuilder)localObject).append(paramGestureHelper.a(paramTextItem));
        QLog.d(paramMotionEvent, 2, ((StringBuilder)localObject).toString());
        paramMotionEvent = jdField_a_of_type_JavaLangString;
        paramGestureHelper = new StringBuilder();
        paramGestureHelper.append("Text translateX: ");
        paramGestureHelper.append(paramTextItem.l);
        QLog.d(paramMotionEvent, 2, paramGestureHelper.toString());
        paramMotionEvent = jdField_a_of_type_JavaLangString;
        paramGestureHelper = new StringBuilder();
        paramGestureHelper.append("Text translateY: ");
        paramGestureHelper.append(paramTextItem.m);
        QLog.d(paramMotionEvent, 2, paramGestureHelper.toString());
        paramMotionEvent = jdField_a_of_type_JavaLangString;
        paramGestureHelper = new StringBuilder();
        paramGestureHelper.append("Text rotate: ");
        paramGestureHelper.append(paramTextItem.k);
        QLog.d(paramMotionEvent, 2, paramGestureHelper.toString());
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "=========================================");
    }
    return -1;
  }
  
  @NonNull
  public Paint a()
  {
    return this.jdField_a_of_type_AndroidGraphicsPaint;
  }
  
  public InputFilter a()
  {
    return null;
  }
  
  @NonNull
  public DynamicTextItem.TextMap a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem$TextMap;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem$TextMap.a(b());
  }
  
  @NonNull
  public String a(int paramInt)
  {
    int i = paramInt;
    if (paramInt != a(paramInt))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getText index out of bound, support size is ");
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append(", current index is ");
      ((StringBuilder)localObject).append(paramInt);
      localObject = ((StringBuilder)localObject).toString();
      IndexOutOfBoundsException localIndexOutOfBoundsException = new IndexOutOfBoundsException((String)localObject);
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, localIndexOutOfBoundsException, new Object[] { localObject });
      }
      i = 0;
    }
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem$TextMap.a(i);
  }
  
  @NonNull
  protected final String a(int paramInt, @Nullable DynamicTextItem.PreHandleTextHandler paramPreHandleTextHandler)
  {
    paramInt = a(paramInt);
    String str2 = a(paramInt);
    String str1 = str2;
    if (paramPreHandleTextHandler != null) {
      str1 = paramPreHandleTextHandler.a(paramInt, str2);
    }
    return a(str1);
  }
  
  public String a(int paramInt, String paramString)
  {
    if (paramString.length() <= paramInt) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int k = 0;
    int i = 0;
    while (k < paramString.length())
    {
      int j;
      if (paramString.charAt(k) == ' ') {
        j = i + 1;
      } else {
        j = 0;
      }
      localStringBuilder.append(paramString.charAt(k));
      i = j;
      if (j == paramInt)
      {
        int m = k + 1;
        i = j;
        if (m <= paramString.length() - 1)
        {
          i = j;
          if (paramString.charAt(m) == ' ')
          {
            localStringBuilder.append("\r\n");
            i = 0;
          }
        }
      }
      k += 1;
    }
    return localStringBuilder.toString();
  }
  
  protected String a(String paramString)
  {
    Object localObject = paramString;
    if (EditTextDialog.b(c()))
    {
      localObject = paramString;
      if (paramString.length() > 20)
      {
        localObject = new StringBuilder();
        int i = 0;
        int k;
        for (int j = 0; (i < paramString.length()) && (j < 20); j = k)
        {
          ((StringBuilder)localObject).append(paramString.charAt(i));
          k = j;
          if (paramString.charAt(i) != '\n')
          {
            k = j;
            if (paramString.charAt(i) != '\r') {
              k = j + 1;
            }
          }
          i += 1;
        }
        paramString = ((StringBuilder)localObject).toString();
        localObject = paramString;
        if (!paramString.isEmpty())
        {
          if (Character.isHighSurrogate(paramString.charAt(paramString.length() - 1))) {
            i = paramString.length() - 1;
          } else {
            i = paramString.length();
          }
          localObject = paramString.substring(0, i);
        }
      }
    }
    return localObject;
  }
  
  @NonNull
  public ArrayList<String> a()
  {
    return new ArrayList(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem$TextMap.a());
  }
  
  public void a()
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(int paramInt1, View paramView, boolean paramBoolean, int paramInt2, int paramInt3, Runnable paramRunnable)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      if (!a()) {
        return;
      }
      this.jdField_b_of_type_Boolean = true;
      this.e = true;
      Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
      if (localHandler == null) {
        this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
      } else {
        localHandler.removeCallbacksAndMessages(null);
      }
      int i = 0;
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem$Pair.a = Integer.valueOf(paramInt1);
      paramInt1 = i;
      while (paramInt1 < paramInt2 - paramInt3)
      {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new DynamicTextItem.1(this, paramView), paramInt1);
        paramInt1 += paramInt3;
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new DynamicTextItem.2(this, paramBoolean, paramView, paramRunnable), paramInt1);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    int i = paramInt;
    if (paramInt != a(paramInt))
    {
      paramString = new StringBuilder();
      paramString.append("setText index out of bound, support size is ");
      paramString.append(a());
      paramString.append(", current index is ");
      paramString.append(paramInt);
      paramString = paramString.toString();
      IndexOutOfBoundsException localIndexOutOfBoundsException = new IndexOutOfBoundsException(paramString);
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, localIndexOutOfBoundsException, new Object[] { paramString });
      }
      i = 0;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem$TextMap.a(i, str);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    a();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem$Pair.a = Integer.valueOf(paramInt);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem$Pair.b = Boolean.valueOf(paramBoolean);
  }
  
  protected abstract void a(Canvas paramCanvas);
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public abstract boolean a();
  
  public boolean a(int paramInt)
  {
    return a(paramInt).equals(DynamicTextBuilder.a(this.jdField_b_of_type_Int, paramInt));
  }
  
  public abstract float b();
  
  public int b()
  {
    if (this.jdField_c_of_type_Int < 0) {
      this.jdField_c_of_type_Int = 0;
    }
    if (this.jdField_c_of_type_Int >= this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem$TextMap.a()) {
      return 0;
    }
    return this.jdField_c_of_type_Int;
  }
  
  @NonNull
  protected final String b(int paramInt)
  {
    return a(paramInt, null);
  }
  
  public void b()
  {
    a();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem$Pair.b = Boolean.valueOf(false);
  }
  
  public void b(int paramInt)
  {
    if (c())
    {
      int i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      this.jdField_c_of_type_Int = i;
      return;
    }
    this.jdField_c_of_type_Int = 0;
  }
  
  public final void b(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.translate(-a() / 2.0F, -b() / 2.0F);
    a(paramCanvas);
    paramCanvas.restore();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem$TextMap.a(0, a());
  }
  
  public boolean b(int paramInt)
  {
    if ((((Integer)this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem$Pair.a).intValue() != paramInt) && (((Integer)this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem$Pair.a).intValue() != -1)) {
      return false;
    }
    return ((Boolean)this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem$Pair.b).booleanValue();
  }
  
  public int c()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void c()
  {
    this.e = false;
  }
  
  public void c(int paramInt)
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final boolean c()
  {
    return a() > 1;
  }
  
  public int d()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public boolean d()
  {
    ArrayList localArrayList = a();
    List localList = DynamicTextBuilder.a(this.jdField_b_of_type_Int);
    if (localList == null) {
      return false;
    }
    if (localArrayList.size() < localList.size()) {
      return false;
    }
    int i = 0;
    while (i < localList.size())
    {
      String str = (String)localList.get(i);
      if (str == null)
      {
        if (localArrayList.get(i) != null) {
          return false;
        }
      }
      else if (!str.equals(localArrayList.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (DynamicTextItem)paramObject;
      if (this.jdField_b_of_type_Int != paramObject.jdField_b_of_type_Int) {
        return false;
      }
      DynamicTextItem.TextMap localTextMap = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem$TextMap;
      if (localTextMap != null) {
        return localTextMap.equals(paramObject.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem$TextMap);
      }
      return paramObject.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem$TextMap == null;
    }
    return false;
  }
  
  public boolean f()
  {
    return this.e;
  }
  
  public int hashCode()
  {
    int j = this.jdField_b_of_type_Int;
    DynamicTextItem.TextMap localTextMap = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem$TextMap;
    int i;
    if (localTextMap != null) {
      i = localTextMap.hashCode();
    } else {
      i = 0;
    }
    return j * 31 + i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
 * JD-Core Version:    0.7.0.1
 */