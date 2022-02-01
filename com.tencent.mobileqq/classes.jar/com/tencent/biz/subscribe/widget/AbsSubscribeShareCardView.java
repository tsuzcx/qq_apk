package com.tencent.biz.subscribe.widget;

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
import com.tencent.biz.subscribe.beans.ShareInfoBean;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
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
  public static final int c = ScreenUtil.dip2px(375.0F);
  public static final int d = ScreenUtil.dip2px(701.0F);
  public static final int e = ScreenUtil.dip2px(667.0F);
  public float a;
  protected Bitmap a;
  protected View a;
  protected ShareInfoBean a;
  protected ArrayList<String> a;
  protected View b;
  protected ArrayList<ImageView> b;
  private volatile int f;
  
  static
  {
    jdField_a_of_type_Int = ScreenUtil.dip2px(311.0F);
    jdField_b_of_type_Int = ScreenUtil.dip2px(415.0F);
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
    Bitmap localBitmap = null;
    try
    {
      if (this.jdField_b_of_type_AndroidViewView != null)
      {
        localBitmap = Bitmap.createBitmap(this.jdField_b_of_type_AndroidViewView.getLayoutParams().width, this.jdField_b_of_type_AndroidViewView.getLayoutParams().height, Bitmap.Config.RGB_565);
        this.jdField_b_of_type_AndroidViewView.draw(new Canvas(localBitmap));
      }
      return localBitmap;
    }
    catch (Throwable localThrowable)
    {
      label53:
      break label53;
    }
    QLog.d("AbsSubscribeShareCardView", 4, "failed to get bitmap from view");
    return null;
  }
  
  protected abstract URLImageView a();
  
  public void a() {}
  
  public abstract void a(View paramView);
  
  public void a(FrameLayout paramFrameLayout, int paramInt1, int paramInt2)
  {
    int i = e;
    if (a() != null)
    {
      if ((paramInt1 != 0) && (paramInt2 != 0) && (paramInt1 != paramInt2))
      {
        if (paramInt1 > paramInt2)
        {
          paramInt1 = jdField_a_of_type_Int;
          paramInt2 = (int)(paramInt1 / this.jdField_a_of_type_Float);
        }
        else
        {
          i = d;
          paramInt1 = jdField_a_of_type_Int;
          paramInt2 = Math.min((int)(paramInt1 * this.jdField_a_of_type_Float), jdField_b_of_type_Int);
        }
      }
      else
      {
        paramInt1 = jdField_a_of_type_Int;
        paramInt2 = paramInt1;
      }
      a().getLayoutParams().width = paramInt1;
      a().getLayoutParams().height = paramInt2;
      a().setLayoutParams(a().getLayoutParams());
      if (paramFrameLayout != null)
      {
        paramFrameLayout.getLayoutParams().width = paramInt1;
        paramFrameLayout.getLayoutParams().height = (i - ScreenUtil.dip2px(168.0F));
        paramFrameLayout.setLayoutParams(paramFrameLayout.getLayoutParams());
      }
      this.jdField_b_of_type_AndroidViewView.getLayoutParams().height = i;
      measure(c, i);
      layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }
  }
  
  public void a(ShareInfoBean paramShareInfoBean, Bitmap paramBitmap, AbsSubscribeShareCardView.ShareDataBindListener paramShareDataBindListener)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBeansShareInfoBean = paramShareInfoBean;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    measure(c, e);
    layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
  }
  
  protected void a(ArrayList<String> paramArrayList, ArrayList<ImageView> paramArrayList1, AbsSubscribeShareCardView.ShareDataBindListener paramShareDataBindListener)
  {
    if ((paramArrayList != null) && (paramArrayList.size() == paramArrayList1.size()))
    {
      int i = 0;
      this.f = 0;
      while (i < paramArrayList.size())
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(SubscribeQRCodeShareHelper.a);
        ((StringBuilder)localObject).append(Md5Utils.getMD5((String)paramArrayList.get(i)));
        ((StringBuilder)localObject).append(".png");
        localObject = ((StringBuilder)localObject).toString();
        if (new File((String)localObject).exists())
        {
          ((ImageView)paramArrayList1.get(i)).setImageBitmap(SafeBitmapFactory.decodeFile((String)localObject));
          this.f += 1;
          if (this.f == paramArrayList.size()) {
            ThreadManager.getUIHandler().post(new AbsSubscribeShareCardView.1(this, paramShareDataBindListener));
          }
        }
        else
        {
          ThreadManagerV2.executeOnFileThread(new AbsSubscribeShareCardView.2(this, paramArrayList1, i, (String)localObject, paramArrayList, paramShareDataBindListener));
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.AbsSubscribeShareCardView
 * JD-Core Version:    0.7.0.1
 */