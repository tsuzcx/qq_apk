package com.tencent.biz.subscribe.widget;

import aabx;
import aako;
import aakt;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import bclx;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.Md5Utils;
import java.io.File;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public abstract class AbsSubscribeShareCardView
  extends FrameLayout
{
  public static final int a;
  public static final int b;
  public static final int c = bclx.a(375.0F);
  public static final int d = bclx.a(701.0F);
  public static final int e = bclx.a(667.0F);
  public float a;
  protected aabx a;
  protected Bitmap a;
  protected View a;
  protected ArrayList<String> a;
  protected View b;
  protected ArrayList<ImageView> b;
  private volatile int f;
  
  static
  {
    jdField_a_of_type_Int = bclx.a(311.0F);
    jdField_b_of_type_Int = bclx.a(415.0F);
  }
  
  public AbsSubscribeShareCardView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AbsSubscribeShareCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AbsSubscribeShareCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Float = 1.333333F;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    setWillNotDraw(false);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(a(), this);
    a(this.jdField_a_of_type_AndroidViewView);
  }
  
  public abstract int a();
  
  public Bitmap a()
  {
    try
    {
      if (this.jdField_b_of_type_AndroidViewView != null)
      {
        Bitmap localBitmap = Bitmap.createBitmap(this.jdField_b_of_type_AndroidViewView.getLayoutParams().width, this.jdField_b_of_type_AndroidViewView.getLayoutParams().height, Bitmap.Config.RGB_565);
        this.jdField_b_of_type_AndroidViewView.draw(new Canvas(localBitmap));
        return localBitmap;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.d("AbsSubscribeShareCardView", 4, "failed to get bitmap from view");
      return null;
    }
    return null;
  }
  
  protected abstract URLImageView a();
  
  public void a() {}
  
  public void a(aabx paramaabx, Bitmap paramBitmap, aako paramaako)
  {
    this.jdField_a_of_type_Aabx = paramaabx;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    measure(c, e);
    layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
  }
  
  public abstract void a(View paramView);
  
  public void a(FrameLayout paramFrameLayout, int paramInt1, int paramInt2)
  {
    int i = e;
    if (a() != null)
    {
      if ((paramInt1 != 0) && (paramInt2 != 0) && (paramInt1 != paramInt2)) {
        break label140;
      }
      paramInt2 = jdField_a_of_type_Int;
      paramInt1 = jdField_a_of_type_Int;
    }
    for (;;)
    {
      a().getLayoutParams().width = paramInt2;
      a().getLayoutParams().height = paramInt1;
      a().setLayoutParams(a().getLayoutParams());
      if (paramFrameLayout != null)
      {
        paramFrameLayout.getLayoutParams().width = paramInt2;
        paramFrameLayout.getLayoutParams().height = (i - bclx.a(168.0F));
        paramFrameLayout.setLayoutParams(paramFrameLayout.getLayoutParams());
      }
      this.jdField_b_of_type_AndroidViewView.getLayoutParams().height = i;
      measure(c, i);
      layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
      return;
      label140:
      if (paramInt1 > paramInt2)
      {
        paramInt2 = jdField_a_of_type_Int;
        paramInt1 = (int)(paramInt2 / this.jdField_a_of_type_Float);
      }
      else
      {
        i = d;
        paramInt2 = jdField_a_of_type_Int;
        paramInt1 = Math.min((int)(paramInt2 * this.jdField_a_of_type_Float), jdField_b_of_type_Int);
      }
    }
  }
  
  protected void a(ArrayList<String> paramArrayList, ArrayList<ImageView> paramArrayList1, aako paramaako)
  {
    int i = 0;
    if ((paramArrayList != null) && (paramArrayList.size() == paramArrayList1.size()))
    {
      this.f = 0;
      if (i < paramArrayList.size())
      {
        String str = aakt.a + Md5Utils.getMD5((String)paramArrayList.get(i)) + ".png";
        if (new File(str).exists())
        {
          ((ImageView)paramArrayList1.get(i)).setImageBitmap(SafeBitmapFactory.decodeFile(str));
          this.f += 1;
          if (this.f == paramArrayList.size()) {
            ThreadManager.getUIHandler().post(new AbsSubscribeShareCardView.1(this, paramaako));
          }
        }
        for (;;)
        {
          i += 1;
          break;
          ThreadManagerV2.executeOnFileThread(new AbsSubscribeShareCardView.2(this, paramArrayList1, i, str, paramArrayList, paramaako));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.AbsSubscribeShareCardView
 * JD-Core Version:    0.7.0.1
 */