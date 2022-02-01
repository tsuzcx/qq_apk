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
  public static final int a = ScreenUtil.dip2px(311.0F);
  public static final int b = ScreenUtil.dip2px(415.0F);
  public static final int c = ScreenUtil.dip2px(375.0F);
  public static final int d = ScreenUtil.dip2px(701.0F);
  public static final int e = ScreenUtil.dip2px(667.0F);
  public float f = 1.333333F;
  protected ShareInfoBean g;
  protected Bitmap h;
  protected View i;
  protected ArrayList<String> j = new ArrayList();
  protected ArrayList<ImageView> k = new ArrayList();
  protected View l;
  private volatile int m;
  
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
    setWillNotDraw(false);
    this.i = LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
    a(this.i);
  }
  
  public void a() {}
  
  public abstract void a(View paramView);
  
  public void a(FrameLayout paramFrameLayout, int paramInt1, int paramInt2)
  {
    int n = e;
    if (getTopImg() != null)
    {
      if ((paramInt1 != 0) && (paramInt2 != 0) && (paramInt1 != paramInt2))
      {
        if (paramInt1 > paramInt2)
        {
          paramInt1 = a;
          paramInt2 = (int)(paramInt1 / this.f);
        }
        else
        {
          n = d;
          paramInt1 = a;
          paramInt2 = Math.min((int)(paramInt1 * this.f), b);
        }
      }
      else
      {
        paramInt1 = a;
        paramInt2 = paramInt1;
      }
      getTopImg().getLayoutParams().width = paramInt1;
      getTopImg().getLayoutParams().height = paramInt2;
      getTopImg().setLayoutParams(getTopImg().getLayoutParams());
      if (paramFrameLayout != null)
      {
        paramFrameLayout.getLayoutParams().width = paramInt1;
        paramFrameLayout.getLayoutParams().height = (n - ScreenUtil.dip2px(168.0F));
        paramFrameLayout.setLayoutParams(paramFrameLayout.getLayoutParams());
      }
      this.l.getLayoutParams().height = n;
      measure(c, n);
      layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }
  }
  
  public void a(ShareInfoBean paramShareInfoBean, Bitmap paramBitmap, AbsSubscribeShareCardView.ShareDataBindListener paramShareDataBindListener)
  {
    this.g = paramShareInfoBean;
    this.h = paramBitmap;
    measure(c, e);
    layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
  }
  
  protected void a(ArrayList<String> paramArrayList, ArrayList<ImageView> paramArrayList1, AbsSubscribeShareCardView.ShareDataBindListener paramShareDataBindListener)
  {
    if ((paramArrayList != null) && (paramArrayList.size() == paramArrayList1.size()))
    {
      int n = 0;
      this.m = 0;
      while (n < paramArrayList.size())
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(SubscribeQRCodeShareHelper.a);
        ((StringBuilder)localObject).append(Md5Utils.getMD5((String)paramArrayList.get(n)));
        ((StringBuilder)localObject).append(".png");
        localObject = ((StringBuilder)localObject).toString();
        if (new File((String)localObject).exists())
        {
          ((ImageView)paramArrayList1.get(n)).setImageBitmap(SafeBitmapFactory.decodeFile((String)localObject));
          this.m += 1;
          if (this.m == paramArrayList.size()) {
            ThreadManager.getUIHandler().post(new AbsSubscribeShareCardView.1(this, paramShareDataBindListener));
          }
        }
        else
        {
          ThreadManagerV2.executeOnFileThread(new AbsSubscribeShareCardView.2(this, paramArrayList1, n, (String)localObject, paramArrayList, paramShareDataBindListener));
        }
        n += 1;
      }
    }
  }
  
  public abstract int getLayoutId();
  
  public Bitmap getSharedBitmap()
  {
    Bitmap localBitmap = null;
    try
    {
      if (this.l != null)
      {
        localBitmap = Bitmap.createBitmap(this.l.getLayoutParams().width, this.l.getLayoutParams().height, Bitmap.Config.RGB_565);
        this.l.draw(new Canvas(localBitmap));
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
  
  protected abstract URLImageView getTopImg();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.AbsSubscribeShareCardView
 * JD-Core Version:    0.7.0.1
 */