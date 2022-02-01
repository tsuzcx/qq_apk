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
  private static final String a = "DynamicTextItem";
  private int b;
  private DynamicTextItem.TextMap c;
  private boolean d = false;
  private int e = 0;
  private volatile boolean f = false;
  private volatile boolean g = false;
  private Handler h = null;
  private Paint i;
  private volatile DynamicTextItem.Pair<Integer, Boolean> j = new DynamicTextItem.Pair(Integer.valueOf(-1), Boolean.valueOf(false));
  protected int k;
  protected boolean l;
  public Stack<Integer> m = new Stack();
  StaticLayout n;
  public boolean o;
  
  public DynamicTextItem(int paramInt, @NonNull List<String> paramList)
  {
    this.b = paramInt;
    this.c = new DynamicTextItem.TextMap(paramList);
    this.i = new Paint();
    this.i.setAntiAlias(true);
    this.i.setColor(Color.parseColor("#12b7f5"));
    this.i.setStyle(Paint.Style.STROKE);
    this.i.setStrokeWidth(2.0F);
    this.i.setPathEffect(new DashPathEffect(new float[] { 6.0F, 7.0F }, 1.0F));
  }
  
  private int a(int paramInt)
  {
    int i1;
    if (paramInt >= 0)
    {
      i1 = paramInt;
      if (paramInt < b()) {}
    }
    else
    {
      i1 = 0;
    }
    return i1;
  }
  
  public float a(StaticLayout paramStaticLayout)
  {
    float f1 = 0.0F;
    if (paramStaticLayout == null) {
      return 0.0F;
    }
    int i1 = 0;
    while (i1 < paramStaticLayout.getLineCount())
    {
      f1 = Math.max(f1, paramStaticLayout.getLineWidth(i1));
      i1 += 1;
    }
    return f1;
  }
  
  public int a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return -1;
  }
  
  public int a(@NonNull MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2, @Nullable TextLayer.TextItem paramTextItem, GestureHelper paramGestureHelper)
  {
    if (QLog.isColorLevel())
    {
      QLog.d(a, 2, "=========================================");
      Object localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Touch X: ");
      localStringBuilder.append(paramMotionEvent.getX());
      QLog.d((String)localObject, 2, localStringBuilder.toString());
      localObject = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Touch Y: ");
      localStringBuilder.append(paramMotionEvent.getY());
      QLog.d((String)localObject, 2, localStringBuilder.toString());
      paramMotionEvent = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Container W: ");
      ((StringBuilder)localObject).append(paramFloat1);
      QLog.d(paramMotionEvent, 2, ((StringBuilder)localObject).toString());
      paramMotionEvent = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Container H: ");
      ((StringBuilder)localObject).append(paramFloat2);
      QLog.d(paramMotionEvent, 2, ((StringBuilder)localObject).toString());
      if (paramTextItem == null)
      {
        QLog.d(a, 2, "Text Zoom info is null, use default info");
        paramMotionEvent = a;
        paramTextItem = new StringBuilder();
        paramTextItem.append("Text W: ");
        paramTextItem.append(c());
        QLog.d(paramMotionEvent, 2, paramTextItem.toString());
        paramMotionEvent = a;
        paramTextItem = new StringBuilder();
        paramTextItem.append("Text H: ");
        paramTextItem.append(d());
        QLog.d(paramMotionEvent, 2, paramTextItem.toString());
      }
      else
      {
        paramMotionEvent = a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Text X: ");
        ((StringBuilder)localObject).append(paramTextItem.A.x);
        QLog.d(paramMotionEvent, 2, ((StringBuilder)localObject).toString());
        paramMotionEvent = a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Text Y: ");
        ((StringBuilder)localObject).append(paramTextItem.A.y);
        QLog.d(paramMotionEvent, 2, ((StringBuilder)localObject).toString());
        paramMotionEvent = a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Text W: ");
        ((StringBuilder)localObject).append(paramTextItem.c.c());
        QLog.d(paramMotionEvent, 2, ((StringBuilder)localObject).toString());
        paramMotionEvent = a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Text H: ");
        ((StringBuilder)localObject).append(paramTextItem.c.d());
        QLog.d(paramMotionEvent, 2, ((StringBuilder)localObject).toString());
        paramMotionEvent = a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Text Scale: ");
        ((StringBuilder)localObject).append(paramGestureHelper.d(paramTextItem));
        QLog.d(paramMotionEvent, 2, ((StringBuilder)localObject).toString());
        paramMotionEvent = a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Text Matrix: ");
        ((StringBuilder)localObject).append(paramGestureHelper.b(paramTextItem));
        QLog.d(paramMotionEvent, 2, ((StringBuilder)localObject).toString());
        paramMotionEvent = a;
        paramGestureHelper = new StringBuilder();
        paramGestureHelper.append("Text translateX: ");
        paramGestureHelper.append(paramTextItem.D);
        QLog.d(paramMotionEvent, 2, paramGestureHelper.toString());
        paramMotionEvent = a;
        paramGestureHelper = new StringBuilder();
        paramGestureHelper.append("Text translateY: ");
        paramGestureHelper.append(paramTextItem.E);
        QLog.d(paramMotionEvent, 2, paramGestureHelper.toString());
        paramMotionEvent = a;
        paramGestureHelper = new StringBuilder();
        paramGestureHelper.append("Text rotate: ");
        paramGestureHelper.append(paramTextItem.C);
        QLog.d(paramMotionEvent, 2, paramGestureHelper.toString());
      }
      QLog.d(a, 2, "=========================================");
    }
    return -1;
  }
  
  @NonNull
  protected final String a(int paramInt, @Nullable DynamicTextItem.PreHandleTextHandler paramPreHandleTextHandler)
  {
    paramInt = a(paramInt);
    String str2 = b(paramInt);
    String str1 = str2;
    if (paramPreHandleTextHandler != null) {
      str1 = paramPreHandleTextHandler.a(paramInt, str2);
    }
    return a(str1);
  }
  
  protected String a(String paramString)
  {
    Object localObject = paramString;
    if (EditTextDialog.e(k()))
    {
      localObject = paramString;
      if (paramString.length() > 20)
      {
        localObject = new StringBuilder();
        int i1 = 0;
        int i3;
        for (int i2 = 0; (i1 < paramString.length()) && (i2 < 20); i2 = i3)
        {
          ((StringBuilder)localObject).append(paramString.charAt(i1));
          i3 = i2;
          if (paramString.charAt(i1) != '\n')
          {
            i3 = i2;
            if (paramString.charAt(i1) != '\r') {
              i3 = i2 + 1;
            }
          }
          i1 += 1;
        }
        paramString = ((StringBuilder)localObject).toString();
        localObject = paramString;
        if (!paramString.isEmpty())
        {
          if (Character.isHighSurrogate(paramString.charAt(paramString.length() - 1))) {
            i1 = paramString.length() - 1;
          } else {
            i1 = paramString.length();
          }
          localObject = paramString.substring(0, i1);
        }
      }
    }
    return localObject;
  }
  
  public void a(int paramInt1, View paramView, boolean paramBoolean, int paramInt2, int paramInt3, Runnable paramRunnable)
  {
    if (!this.f)
    {
      if (!a()) {
        return;
      }
      this.f = true;
      this.g = true;
      Handler localHandler = this.h;
      if (localHandler == null) {
        this.h = new Handler(Looper.getMainLooper());
      } else {
        localHandler.removeCallbacksAndMessages(null);
      }
      int i1 = 0;
      this.j.a = Integer.valueOf(paramInt1);
      paramInt1 = i1;
      while (paramInt1 < paramInt2 - paramInt3)
      {
        this.h.postDelayed(new DynamicTextItem.1(this, paramView), paramInt1);
        paramInt1 += paramInt3;
      }
      this.h.postDelayed(new DynamicTextItem.2(this, paramBoolean, paramView, paramRunnable), paramInt1);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    int i1 = paramInt;
    if (paramInt != a(paramInt))
    {
      paramString = new StringBuilder();
      paramString.append("setText index out of bound, support size is ");
      paramString.append(b());
      paramString.append(", current index is ");
      paramString.append(paramInt);
      paramString = paramString.toString();
      IndexOutOfBoundsException localIndexOutOfBoundsException = new IndexOutOfBoundsException(paramString);
      if (QLog.isColorLevel()) {
        QLog.e(a, 2, localIndexOutOfBoundsException, new Object[] { paramString });
      }
      i1 = 0;
    }
    this.c.a(i1, str);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    o();
    this.j.a = Integer.valueOf(paramInt);
    this.j.b = Boolean.valueOf(paramBoolean);
  }
  
  protected abstract void a(Canvas paramCanvas);
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public abstract boolean a();
  
  public abstract int b();
  
  @NonNull
  public String b(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt != a(paramInt))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getText index out of bound, support size is ");
      ((StringBuilder)localObject).append(b());
      ((StringBuilder)localObject).append(", current index is ");
      ((StringBuilder)localObject).append(paramInt);
      localObject = ((StringBuilder)localObject).toString();
      IndexOutOfBoundsException localIndexOutOfBoundsException = new IndexOutOfBoundsException((String)localObject);
      if (QLog.isColorLevel()) {
        QLog.e(a, 2, localIndexOutOfBoundsException, new Object[] { localObject });
      }
      i1 = 0;
    }
    return this.c.a(i1);
  }
  
  public String b(int paramInt, String paramString)
  {
    if (paramString.length() <= paramInt) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i3 = 0;
    int i1 = 0;
    while (i3 < paramString.length())
    {
      int i2;
      if (paramString.charAt(i3) == ' ') {
        i2 = i1 + 1;
      } else {
        i2 = 0;
      }
      localStringBuilder.append(paramString.charAt(i3));
      i1 = i2;
      if (i2 == paramInt)
      {
        int i4 = i3 + 1;
        i1 = i2;
        if (i4 <= paramString.length() - 1)
        {
          i1 = i2;
          if (paramString.charAt(i4) == ' ')
          {
            localStringBuilder.append("\r\n");
            i1 = 0;
          }
        }
      }
      i3 += 1;
    }
    return localStringBuilder.toString();
  }
  
  public final void b(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.translate(-c() / 2.0F, -d() / 2.0F);
    a(paramCanvas);
    paramCanvas.restore();
  }
  
  public abstract float c();
  
  @NonNull
  protected final String c(int paramInt)
  {
    return a(paramInt, null);
  }
  
  public abstract float d();
  
  public boolean d(int paramInt)
  {
    return b(paramInt).equals(DynamicTextBuilder.a(this.b, paramInt));
  }
  
  public void e(int paramInt)
  {
    if (h())
    {
      int i1 = paramInt;
      if (paramInt < 0) {
        i1 = 0;
      }
      this.e = i1;
      return;
    }
    this.e = 0;
  }
  
  public boolean e()
  {
    return this.c.a(0, b());
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
      if (this.b != paramObject.b) {
        return false;
      }
      DynamicTextItem.TextMap localTextMap = this.c;
      if (localTextMap != null) {
        return localTextMap.equals(paramObject.c);
      }
      return paramObject.c == null;
    }
    return false;
  }
  
  public InputFilter f()
  {
    return null;
  }
  
  public boolean f(int paramInt)
  {
    if ((((Integer)this.j.a).intValue() != paramInt) && (((Integer)this.j.a).intValue() != -1)) {
      return false;
    }
    return ((Boolean)this.j.b).booleanValue();
  }
  
  public int g()
  {
    if (this.e < 0) {
      this.e = 0;
    }
    if (this.e >= this.c.b()) {
      return 0;
    }
    return this.e;
  }
  
  public void g(int paramInt)
  {
    this.l = true;
    this.k = paramInt;
  }
  
  public final boolean h()
  {
    return b() > 1;
  }
  
  public int hashCode()
  {
    int i2 = this.b;
    DynamicTextItem.TextMap localTextMap = this.c;
    int i1;
    if (localTextMap != null) {
      i1 = localTextMap.hashCode();
    } else {
      i1 = 0;
    }
    return i2 * 31 + i1;
  }
  
  @NonNull
  public DynamicTextItem.TextMap i()
  {
    return this.c;
  }
  
  @NonNull
  public ArrayList<String> j()
  {
    return new ArrayList(this.c.a());
  }
  
  public int k()
  {
    return this.b;
  }
  
  public boolean l()
  {
    ArrayList localArrayList = j();
    List localList = DynamicTextBuilder.a(this.b);
    if (localList == null) {
      return false;
    }
    if (localArrayList.size() < localList.size()) {
      return false;
    }
    int i1 = 0;
    while (i1 < localList.size())
    {
      String str = (String)localList.get(i1);
      if (str == null)
      {
        if (localArrayList.get(i1) != null) {
          return false;
        }
      }
      else if (!str.equals(localArrayList.get(i1))) {
        return false;
      }
      i1 += 1;
    }
    return true;
  }
  
  public boolean m()
  {
    return this.d;
  }
  
  public String n()
  {
    return this.c.a(g());
  }
  
  public void o()
  {
    Handler localHandler = this.h;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
    this.f = false;
  }
  
  public void p()
  {
    o();
    this.j.b = Boolean.valueOf(false);
  }
  
  public boolean q()
  {
    return this.g;
  }
  
  public void r()
  {
    this.g = false;
  }
  
  @NonNull
  public Paint s()
  {
    return this.i;
  }
  
  public int t()
  {
    return this.k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
 * JD-Core Version:    0.7.0.1
 */