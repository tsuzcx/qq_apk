package com.tencent.biz.troopgift;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.troop.utils.TroopGiftManager.GiveGift;
import com.tencent.mobileqq.troop.utils.TroopGiftManager.PackGift;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class GridListAdapter
  extends BaseAdapter
{
  protected ArrayList<Object> a;
  protected Context b;
  protected LayoutInflater c;
  protected int d = -1;
  protected Drawable e = null;
  protected String f = null;
  protected int g;
  protected TroopGiftPanel h;
  
  public GridListAdapter(Context paramContext, TroopGiftPanel paramTroopGiftPanel)
  {
    this.b = paramContext;
    this.c = LayoutInflater.from(paramContext);
    this.e = paramContext.getResources().getDrawable(2130851259);
    this.d = -1;
    this.g = AIOUtils.b(9.0F, paramContext.getResources());
    this.h = paramTroopGiftPanel;
  }
  
  public static Bitmap a(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, int paramInt4)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      Object localObject1 = new Canvas(localBitmap);
      Object localObject2 = new Paint();
      ((Paint)localObject2).setColor(paramInt4);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setStrokeWidth(paramFloat2);
      ((Paint)localObject2).setAntiAlias(true);
      float f1 = paramFloat2 / 2.0F;
      paramFloat2 = paramInt1;
      Object localObject3 = new RectF(f1, f1, paramFloat2 - f1, paramInt2 - f1);
      f1 = paramInt3;
      ((Canvas)localObject1).drawRoundRect((RectF)localObject3, f1, f1, (Paint)localObject2);
      localObject1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      localObject2 = new Canvas((Bitmap)localObject1);
      localObject3 = new Paint();
      ((Canvas)localObject2).drawARGB(0, 0, 0, 0);
      paramFloat1 = (paramFloat2 - paramFloat1) / 2.0F;
      ((Canvas)localObject2).drawRect(paramFloat1, 0.0F, paramFloat2 - paramFloat1, f1, (Paint)localObject3);
      ((Paint)localObject3).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
      ((Canvas)localObject2).drawBitmap(localBitmap, 0.0F, 0.0F, (Paint)localObject3);
      localBitmap.recycle();
      return localObject1;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label204:
      break label204;
    }
    return null;
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.f = paramString;
    }
  }
  
  public void a(ArrayList<Object> paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("GridListAdapter setData items = ");
      Object localObject;
      if (paramArrayList == null) {
        localObject = "null";
      } else {
        localObject = Integer.valueOf(paramArrayList.size());
      }
      localStringBuilder.append(localObject);
      QLog.d("zivonchen", 2, localStringBuilder.toString());
    }
    this.d = -1;
    this.a = paramArrayList;
  }
  
  public int getCount()
  {
    ArrayList localArrayList = this.a;
    if (localArrayList == null) {
      return 0;
    }
    return localArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localHolder = new GridListAdapter.Holder();
      if (this.h.getComeFrom() == 20)
      {
        localView = this.c.inflate(2131625985, null);
        paramView = localView;
        if (getCount() >= 5)
        {
          paramView = new RelativeLayout.LayoutParams(-2, -1);
          paramView.width = (ScreenUtil.SCREEN_WIDTH / 5 + 30);
          localView.setLayoutParams(paramView);
          paramView = localView;
        }
      }
      else
      {
        paramView = this.c.inflate(2131626700, null);
      }
      localHolder.b = ((ImageView)paramView.findViewById(2131433680));
      localHolder.a = ((ImageView)paramView.findViewById(2131434254));
      localHolder.c = ((TextView)paramView.findViewById(2131434263));
      localHolder.d = ((TextView)paramView.findViewById(2131434279));
      localHolder.k = ((TextView)paramView.findViewById(2131433681));
      localHolder.i = ((TextView)paramView.findViewById(2131447353));
      localHolder.e = ((TextView)paramView.findViewById(2131434280));
      localHolder.f = ((TextView)paramView.findViewById(2131434258));
      localHolder.g = ((TextView)paramView.findViewById(2131434262));
      localHolder.h = paramView.findViewById(2131429339);
      localHolder.j = ((LinearLayout)paramView.findViewById(2131434255));
      localHolder.m = ((ImageView)paramView.findViewById(2131434283));
      paramView.setTag(localHolder);
      localView = paramView;
    }
    GridListAdapter.Holder localHolder = (GridListAdapter.Holder)localView.getTag();
    TroopGiftAioItemData localTroopGiftAioItemData = (TroopGiftAioItemData)this.a.get(paramInt);
    localHolder.l = localTroopGiftAioItemData;
    if (this.h.h())
    {
      localHolder.c.setVisibility(0);
      localHolder.c.setText(localTroopGiftAioItemData.a);
      if (this.h.getComeFrom() == 20) {
        localHolder.c.setTextColor(-1);
      }
    }
    else
    {
      localHolder.c.setVisibility(8);
    }
    if (localHolder.m != null) {
      if ((localTroopGiftAioItemData.r == 1) && (!TextUtils.isEmpty(localTroopGiftAioItemData.t)))
      {
        localHolder.m.setVisibility(0);
        paramView = URLDrawable.URLDrawableOptions.obtain();
        paramView.mPlayGifImage = false;
        paramView.mLoadingDrawable = URLDrawableHelperConstants.a;
        paramView = URLDrawable.getDrawable(localTroopGiftAioItemData.t, paramView);
        localHolder.m.setImageDrawable(paramView);
      }
      else
      {
        localHolder.m.setVisibility(8);
      }
    }
    Object localObject;
    int i;
    StringBuilder localStringBuilder;
    if ((localTroopGiftAioItemData.n) && (this.h.getRewardGiftCnt() > 0))
    {
      localHolder.d.setVisibility(8);
      localHolder.k.setVisibility(0);
      paramView = localHolder.k;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("免费x");
      ((StringBuilder)localObject).append(this.h.getRewardGiftCnt());
      paramView.setText(((StringBuilder)localObject).toString());
    }
    else if (localTroopGiftAioItemData.q)
    {
      if (localHolder.k != null) {
        localHolder.k.setVisibility(8);
      }
      localHolder.d.setVisibility(0);
      localHolder.d.setTextColor(Color.parseColor("#bbbbbb"));
      paramView = (TroopGiftManager.PackGift)this.h.B.w.get(localTroopGiftAioItemData.d);
      if (paramView == null)
      {
        paramView = HardCodeUtil.a(2131903322);
        localHolder.d.setText(paramView);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("×");
        ((StringBuilder)localObject).append(paramView.b);
        paramView = ((StringBuilder)localObject).toString();
        localHolder.d.setText(paramView);
      }
    }
    else
    {
      if (localHolder.k != null) {
        localHolder.k.setVisibility(8);
      }
      localHolder.d.setVisibility(0);
      paramView = this.h.B.s;
      if (localTroopGiftAioItemData.i != 0) {
        i = localTroopGiftAioItemData.i;
      } else {
        i = localTroopGiftAioItemData.d;
      }
      paramView = (TroopGiftManager.GiveGift)paramView.get(i);
      if ((paramView != null) && (paramView.b + paramView.c != 0))
      {
        localHolder.d.setTextColor(Color.parseColor("#fe6387"));
        if (paramView.c > 0)
        {
          localObject = localHolder.d;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(HardCodeUtil.a(2131903324));
          localStringBuilder.append(paramView.c);
          localStringBuilder.append(HardCodeUtil.a(2131903320));
          ((TextView)localObject).setText(localStringBuilder.toString());
        }
        else if (paramView.b > 0)
        {
          localObject = localHolder.d;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(HardCodeUtil.a(2131903323));
          localStringBuilder.append(paramView.b);
          ((TextView)localObject).setText(localStringBuilder.toString());
        }
      }
      else
      {
        localHolder.d.setText(String.valueOf(localTroopGiftAioItemData.j));
        if ((localTroopGiftAioItemData.n) && (!TextUtils.isEmpty(this.h.B.m.d))) {
          paramView = this.h.B.m.d;
        } else {
          paramView = this.f;
        }
        if (!TextUtils.isEmpty(paramView)) {
          paramView = URLDrawable.getDrawable(paramView, URLDrawable.URLDrawableOptions.obtain());
        } else {
          paramView = this.e;
        }
        i = this.g;
        paramView.setBounds(0, 0, i, i);
        localHolder.d.setCompoundDrawables(paramView, null, null, null);
        if (this.h.getComeFrom() == 20) {
          localHolder.d.setCompoundDrawablePadding(8);
        }
        if (this.h.getComeFrom() == 20)
        {
          if (this.h.h()) {
            localHolder.d.setTextColor(Color.parseColor("#c3c3c3"));
          } else {
            localHolder.d.setTextColor(-1);
          }
        }
        else {
          localHolder.d.setTextColor(Color.parseColor("#bbbbbb"));
        }
      }
    }
    if (localTroopGiftAioItemData.e == 0) {
      localHolder.g.setVisibility(0);
    } else {
      localHolder.g.setVisibility(8);
    }
    paramView = URLDrawable.URLDrawableOptions.obtain();
    if (localTroopGiftAioItemData.k)
    {
      if (this.h.getComeFrom() == 20)
      {
        localHolder.h.setVisibility(4);
        localHolder.e.setVisibility(4);
        localHolder.j.post(new GridListAdapter.1(this, localHolder));
      }
      else
      {
        if (localTroopGiftAioItemData.g < 0)
        {
          i = this.b.getResources().getColor(2131166992);
          localHolder.e.setText(localTroopGiftAioItemData.h);
          localHolder.e.setTextColor(i);
        }
        else
        {
          i = this.b.getResources().getColor(2131166991);
          localHolder.e.setText(localTroopGiftAioItemData.h);
          localHolder.e.setTextColor(i);
        }
        localHolder.e.setVisibility(0);
        localHolder.h.setVisibility(0);
        localHolder.h.post(new GridListAdapter.2(this, localHolder, localTroopGiftAioItemData, i));
      }
      paramView.mPlayGifImage = true;
      paramView.mLoadingDrawable = URLDrawableHelperConstants.a;
      paramView = URLDrawable.getDrawable(localTroopGiftAioItemData.b, paramView);
    }
    else
    {
      if (this.h.getComeFrom() == 20)
      {
        localHolder.j.setBackgroundDrawable(null);
      }
      else
      {
        localHolder.h.setVisibility(4);
        localHolder.e.setVisibility(4);
      }
      paramView.mPlayGifImage = false;
      paramView.mLoadingDrawable = URLDrawableHelperConstants.a;
      paramView = URLDrawable.getDrawable(localTroopGiftAioItemData.c, paramView);
    }
    if (localTroopGiftAioItemData.n)
    {
      if (localTroopGiftAioItemData.k)
      {
        localHolder.f.setVisibility(0);
        localObject = localHolder.f;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131903319));
        localStringBuilder.append(localTroopGiftAioItemData.p);
        localStringBuilder.append(HardCodeUtil.a(2131903321));
        ((TextView)localObject).setText(localStringBuilder.toString());
      }
      else
      {
        localHolder.f.setVisibility(8);
      }
      if (!this.h.i()) {
        localHolder.b.setVisibility(0);
      } else {
        localHolder.b.setVisibility(8);
      }
    }
    else
    {
      localHolder.f.setVisibility(8);
    }
    localHolder.a.setImageDrawable(paramView);
    if ((!this.h.h()) && (this.h.getComeFrom() == 20) && (!TextUtils.isEmpty(localTroopGiftAioItemData.h)))
    {
      localHolder.i.setVisibility(0);
      localHolder.i.setText(localTroopGiftAioItemData.h);
    }
    else
    {
      localHolder.i.setVisibility(8);
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troopgift.GridListAdapter
 * JD-Core Version:    0.7.0.1
 */