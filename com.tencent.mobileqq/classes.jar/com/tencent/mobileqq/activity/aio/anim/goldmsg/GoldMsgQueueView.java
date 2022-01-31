package com.tencent.mobileqq.activity.aio.anim.goldmsg;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import upf;
import upg;
import uph;

public class GoldMsgQueueView
  extends View
{
  private float jdField_a_of_type_Float = 12.0F;
  public int a;
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(5);
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private List jdField_a_of_type_JavaUtilList = new LinkedList();
  private boolean jdField_a_of_type_Boolean;
  public int b;
  private List b;
  public int c;
  private int d;
  
  public GoldMsgQueueView(Context paramContext)
  {
    this(paramContext, 5);
  }
  
  public GoldMsgQueueView(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.jdField_b_of_type_JavaUtilList = new LinkedList();
    if (paramInt > 1) {}
    for (;;)
    {
      this.d = paramInt;
      this.jdField_a_of_type_Int = DisplayUtil.a(getContext(), 1.0F);
      this.jdField_b_of_type_Int = DisplayUtil.a(getContext(), 22.0F);
      this.c = DisplayUtil.a(getContext(), 5.5F);
      return;
      paramInt = 5;
    }
  }
  
  private int a(String paramString, Paint paramPaint)
  {
    int i = DisplayUtil.a(getContext(), this.jdField_a_of_type_Float);
    paramPaint.setTextSize(i);
    this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.getTextBounds(paramString, 0, paramString.length(), this.jdField_a_of_type_AndroidGraphicsRect);
    int j = this.jdField_b_of_type_Int;
    int k = this.c;
    while ((this.jdField_a_of_type_AndroidGraphicsRect.width() > j - k * 2) && (this.jdField_a_of_type_Float > 0.2F))
    {
      this.jdField_a_of_type_Float -= 0.2F;
      i = DisplayUtil.a(getContext(), this.jdField_a_of_type_Float);
      paramPaint.setTextSize(i);
      this.jdField_a_of_type_AndroidGraphicsPaint.getTextBounds(paramString, 0, paramString.length(), this.jdField_a_of_type_AndroidGraphicsRect);
    }
    return i;
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GoldMsgQueueView", 2, "tryDoInsert coming");
    }
    Object localObject1;
    GoldMsgQueueView.DrawItem localDrawItem1;
    LinkedList localLinkedList;
    upf localupf;
    int j;
    int m;
    int k;
    label227:
    GoldMsgQueueView.DrawItem localDrawItem2;
    PropertyValuesHolder localPropertyValuesHolder2;
    Object localObject2;
    int i;
    boolean bool1;
    label345:
    PropertyValuesHolder localPropertyValuesHolder1;
    boolean bool2;
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GoldMsgQueueView", 2, "tryDoInsert start");
      }
      localObject1 = (GoldMsgQueueView.ItemData)this.jdField_a_of_type_JavaUtilList.get(0);
      this.jdField_a_of_type_JavaUtilList.remove(0);
      localDrawItem1 = new GoldMsgQueueView.DrawItem(null);
      localDrawItem1.tag = ((GoldMsgQueueView.ItemData)localObject1).jdField_a_of_type_JavaLangString;
      localDrawItem1.drawable = ((GoldMsgQueueView.ItemData)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      localDrawItem1.scale = 0.0F;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      localLinkedList = new LinkedList();
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
      localupf = new upf(this);
      localObject1 = ObjectAnimator.ofFloat(localDrawItem1, "scale", new float[] { 0.0F, 1.0F });
      ((ObjectAnimator)localObject1).setDuration(250L);
      ((ObjectAnimator)localObject1).addUpdateListener(localupf);
      localLinkedList.add(localObject1);
      if (this.jdField_b_of_type_JavaUtilList.size() >= this.d)
      {
        j = 1;
        m = 0;
        k = 0;
        if (k >= this.jdField_b_of_type_JavaUtilList.size()) {
          break label650;
        }
        localDrawItem2 = (GoldMsgQueueView.DrawItem)this.jdField_b_of_type_JavaUtilList.get(k);
        localPropertyValuesHolder2 = null;
        localObject2 = null;
        localObject1 = null;
        i = localDrawItem2.offset;
        i = this.jdField_b_of_type_Int - this.c + i;
        bool1 = false;
        if (k != this.d - 1) {
          break label538;
        }
        i = localDrawItem2.offset;
        if (!localDrawItem2.isUseToShowNum) {
          break label502;
        }
        localObject1 = PropertyValuesHolder.ofFloat("numAlpha", new float[] { 1.0F, 1.0F });
        localDrawItem2.numScale = 0.0F;
        localDrawItem2.num += 1;
        localPropertyValuesHolder1 = PropertyValuesHolder.ofFloat("numScale", new float[] { 0.0F, 1.0F });
        boolean bool3 = false;
        localObject2 = localObject1;
        localObject1 = localPropertyValuesHolder1;
        bool2 = bool1;
        bool1 = bool3;
      }
    }
    for (;;)
    {
      label382:
      localPropertyValuesHolder1 = PropertyValuesHolder.ofInt("offset", new int[] { localDrawItem2.offset, i });
      if (localPropertyValuesHolder2 != null) {
        localObject1 = ObjectAnimator.ofPropertyValuesHolder(localDrawItem2, new PropertyValuesHolder[] { localPropertyValuesHolder2, localPropertyValuesHolder1 });
      }
      for (;;)
      {
        ((ObjectAnimator)localObject1).addListener(new upg(this, bool2, localDrawItem2, bool1));
        ((ObjectAnimator)localObject1).setDuration(250L);
        m += 83;
        ((ObjectAnimator)localObject1).setStartDelay(m);
        ((ObjectAnimator)localObject1).addUpdateListener(localupf);
        localLinkedList.add(localObject1);
        k += 1;
        break label227;
        j = 0;
        break;
        label502:
        bool1 = true;
        localObject1 = PropertyValuesHolder.ofFloat("numAlpha", new float[] { 0.0F, 1.0F });
        localDrawItem2.num += 1;
        break label345;
        label538:
        if ((k != this.d - 2) || (j == 0)) {
          break label725;
        }
        i = this.jdField_b_of_type_Int / 2 + i;
        localPropertyValuesHolder2 = PropertyValuesHolder.ofFloat("scale", new float[] { localDrawItem2.scale, 0.0F });
        bool2 = false;
        bool1 = true;
        break label382;
        if ((localObject2 != null) && (localObject1 != null)) {
          localObject1 = ObjectAnimator.ofPropertyValuesHolder(localDrawItem2, new PropertyValuesHolder[] { localObject2, localObject1, localPropertyValuesHolder1 });
        } else {
          localObject1 = ObjectAnimator.ofPropertyValuesHolder(localDrawItem2, new PropertyValuesHolder[] { localPropertyValuesHolder1 });
        }
      }
      label650:
      this.jdField_b_of_type_JavaUtilList.add(0, localDrawItem1);
      if (localDrawItem1.drawable != null) {
        localDrawItem1.drawable.setCallback(this);
      }
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.playTogether(localLinkedList);
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.addListener(new uph(this));
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
      if (QLog.isColorLevel()) {
        QLog.d("GoldMsgQueueView", 2, "tryDoInsert play");
      }
      return;
      label725:
      bool2 = false;
      bool1 = false;
    }
  }
  
  private void b()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (GoldMsgQueueView.DrawItem)localIterator.next();
      if (((GoldMsgQueueView.DrawItem)localObject).drawable != null) {
        ((GoldMsgQueueView.DrawItem)localObject).drawable.setCallback(null);
      }
    }
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null)
    {
      localIterator = this.jdField_a_of_type_AndroidAnimationAnimatorSet.getChildAnimations().iterator();
      while (localIterator.hasNext())
      {
        localObject = (Animator)localIterator.next();
        ((Animator)localObject).removeAllListeners();
        ((Animator)localObject).cancel();
      }
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.removeAllListeners();
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
    }
  }
  
  private void b(List paramList, int paramInt)
  {
    b();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("initInner list size=");
      if (paramList == null) {
        break label84;
      }
    }
    label84:
    for (Object localObject1 = Integer.valueOf(paramList.size());; localObject1 = "empty")
    {
      QLog.d("GoldMsgQueueView", 2, localObject1 + ",totalNum=" + paramInt);
      if ((paramList != null) && (paramList.size() > 0)) {
        break;
      }
      invalidate();
      return;
    }
    int i;
    if (paramList.size() < this.d - 1)
    {
      i = paramList.size();
      paramList = paramList.subList(0, paramList.size());
      Collections.reverse(paramList);
      paramInt = i - (this.d - 1);
      if (paramInt <= 1) {
        break label317;
      }
    }
    label317:
    for (paramList = paramList.subList(0, this.d - 1);; paramList = paramList.subList(0, paramList.size()))
    {
      if (paramList.size() <= 0) {
        break label334;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject1 = (GoldMsgQueueView.ItemData)paramList.next();
        if (!TextUtils.isEmpty(((GoldMsgQueueView.ItemData)localObject1).jdField_a_of_type_JavaLangString))
        {
          localObject2 = new GoldMsgQueueView.DrawItem(null);
          ((GoldMsgQueueView.DrawItem)localObject2).drawable = ((GoldMsgQueueView.ItemData)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          ((GoldMsgQueueView.DrawItem)localObject2).tag = ((GoldMsgQueueView.ItemData)localObject1).jdField_a_of_type_JavaLangString;
          this.jdField_b_of_type_JavaUtilList.add(localObject2);
          if (((GoldMsgQueueView.DrawItem)localObject2).drawable != null) {
            ((GoldMsgQueueView.DrawItem)localObject2).drawable.setCallback(this);
          }
          ((GoldMsgQueueView.DrawItem)localObject2).offset = ((this.jdField_b_of_type_JavaUtilList.size() - 1) * (this.jdField_b_of_type_Int - this.c));
        }
      }
      i = paramInt;
      if (paramList.size() <= paramInt) {
        break;
      }
      i = paramList.size();
      break;
    }
    label334:
    if (paramInt > 1)
    {
      paramList = new GoldMsgQueueView.DrawItem(null);
      paramList.isUseToShowNum = true;
      paramList.num = paramInt;
      this.jdField_b_of_type_JavaUtilList.add(paramList);
      paramList.offset = ((this.jdField_b_of_type_JavaUtilList.size() - 1) * (this.jdField_b_of_type_Int - this.c));
    }
    invalidate();
  }
  
  public void a(GoldMsgQueueView.ItemData paramItemData)
  {
    if ((paramItemData != null) && (!TextUtils.isEmpty(paramItemData.jdField_a_of_type_JavaLangString)))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      Object localObject;
      while (localIterator.hasNext())
      {
        localObject = (GoldMsgQueueView.ItemData)localIterator.next();
        if (paramItemData.jdField_a_of_type_JavaLangString.equals(((GoldMsgQueueView.ItemData)localObject).jdField_a_of_type_JavaLangString)) {
          return;
        }
      }
      localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localObject = (GoldMsgQueueView.DrawItem)localIterator.next();
        if (paramItemData.jdField_a_of_type_JavaLangString.equals(((GoldMsgQueueView.DrawItem)localObject).tag)) {
          return;
        }
      }
      this.jdField_a_of_type_JavaUtilList.add(paramItemData);
    }
    a();
  }
  
  public void a(List paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((GoldMsgQueueView.ItemData)paramList.next());
      }
    }
  }
  
  public void a(List paramList, int paramInt)
  {
    b(paramList, paramInt);
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    super.invalidateDrawable(paramDrawable);
    invalidate();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    b();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onDraw mDrawItems size=");
      if (this.jdField_b_of_type_JavaUtilList == null) {
        break label510;
      }
    }
    label510:
    for (Object localObject = Integer.valueOf(this.jdField_b_of_type_JavaUtilList.size());; localObject = "empty")
    {
      QLog.d("GoldMsgQueueView", 2, localObject);
      if (this.jdField_b_of_type_JavaUtilList == null) {
        break;
      }
      int i = this.jdField_b_of_type_JavaUtilList.size() - 1;
      while (i >= 0)
      {
        localObject = (GoldMsgQueueView.DrawItem)this.jdField_b_of_type_JavaUtilList.get(i);
        paramCanvas.save();
        paramCanvas.translate(((GoldMsgQueueView.DrawItem)localObject).offset, 0.0F);
        paramCanvas.scale(((GoldMsgQueueView.DrawItem)localObject).scale, ((GoldMsgQueueView.DrawItem)localObject).scale, 0.0F, getHeight() / 2);
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(1);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
        this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
        paramCanvas.drawOval(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
        if (((GoldMsgQueueView.DrawItem)localObject).drawable != null)
        {
          ((GoldMsgQueueView.DrawItem)localObject).drawable.setBounds(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int - this.jdField_a_of_type_Int, this.jdField_b_of_type_Int - this.jdField_a_of_type_Int);
          ((GoldMsgQueueView.DrawItem)localObject).drawable.draw(paramCanvas);
        }
        if (((GoldMsgQueueView.DrawItem)localObject).isUseToShowNum)
        {
          this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
          this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1249807);
          this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
          this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha((int)(255.0F * ((GoldMsgQueueView.DrawItem)localObject).numAlpha));
          paramCanvas.drawOval(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
          paramCanvas.save();
          paramCanvas.scale(((GoldMsgQueueView.DrawItem)localObject).numScale, ((GoldMsgQueueView.DrawItem)localObject).numScale, this.jdField_b_of_type_Int / 2, getHeight() / 2);
          localObject = ((GoldMsgQueueView.DrawItem)localObject).num + "";
          this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16777216);
          this.jdField_a_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.LEFT);
          this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
          int j = a((String)localObject, this.jdField_a_of_type_AndroidGraphicsPaint);
          this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(j);
          this.jdField_a_of_type_AndroidGraphicsPaint.getTextBounds((String)localObject, 0, ((String)localObject).length(), this.jdField_a_of_type_AndroidGraphicsRect);
          paramCanvas.drawText((String)localObject, this.jdField_b_of_type_Int / 2 - this.jdField_a_of_type_AndroidGraphicsRect.width() / 2, getMeasuredHeight() / 2 + this.jdField_a_of_type_AndroidGraphicsRect.height() / 2, this.jdField_a_of_type_AndroidGraphicsPaint);
          paramCanvas.restore();
        }
        paramCanvas.restore();
        i -= 1;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(DisplayUtil.a(getContext(), this.d * 22.0F - (this.d - 1) * 5.5F), DisplayUtil.a(getContext(), 22.0F));
    if (QLog.isColorLevel()) {
      QLog.d("GoldMsgQueueView", 2, "onMeasure");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.goldmsg.GoldMsgQueueView
 * JD-Core Version:    0.7.0.1
 */