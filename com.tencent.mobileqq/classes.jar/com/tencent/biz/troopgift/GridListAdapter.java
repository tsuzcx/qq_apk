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
  protected int a;
  protected Context a;
  protected Drawable a;
  protected LayoutInflater a;
  protected TroopGiftPanel a;
  protected String a;
  protected ArrayList<Object> a;
  protected int b;
  
  public GridListAdapter(Context paramContext, TroopGiftPanel paramTroopGiftPanel)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130849575);
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = AIOUtils.b(9.0F, paramContext.getResources());
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel = paramTroopGiftPanel;
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
      float f = paramFloat2 / 2.0F;
      paramFloat2 = paramInt1;
      Object localObject3 = new RectF(f, f, paramFloat2 - f, paramInt2 - f);
      f = paramInt3;
      ((Canvas)localObject1).drawRoundRect((RectF)localObject3, f, f, (Paint)localObject2);
      localObject1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      localObject2 = new Canvas((Bitmap)localObject1);
      localObject3 = new Paint();
      ((Canvas)localObject2).drawARGB(0, 0, 0, 0);
      paramFloat1 = (paramFloat2 - paramFloat1) / 2.0F;
      ((Canvas)localObject2).drawRect(paramFloat1, 0.0F, paramFloat2 - paramFloat1, f, (Paint)localObject3);
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
      this.jdField_a_of_type_JavaLangString = paramString;
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
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public int getCount()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList == null) {
      return 0;
    }
    return localArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
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
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a() == 20)
      {
        localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559942, null);
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
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560655, null);
      }
      localHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367223));
      localHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367702));
      localHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367708));
      localHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367714));
      localHolder.g = ((TextView)paramView.findViewById(2131367224));
      localHolder.f = ((TextView)paramView.findViewById(2131378695));
      localHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367715));
      localHolder.d = ((TextView)paramView.findViewById(2131367705));
      localHolder.e = ((TextView)paramView.findViewById(2131367707));
      localHolder.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363441);
      localHolder.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367703));
      localHolder.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367718));
      paramView.setTag(localHolder);
      localView = paramView;
    }
    GridListAdapter.Holder localHolder = (GridListAdapter.Holder)localView.getTag();
    TroopGiftAioItemData localTroopGiftAioItemData = (TroopGiftAioItemData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    localHolder.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData = localTroopGiftAioItemData;
    if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b())
    {
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localTroopGiftAioItemData.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a() == 20) {
        localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      }
    }
    else
    {
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (localHolder.jdField_c_of_type_AndroidWidgetImageView != null) {
      if ((localTroopGiftAioItemData.j == 1) && (!TextUtils.isEmpty(localTroopGiftAioItemData.jdField_e_of_type_JavaLangString)))
      {
        localHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        paramView = URLDrawable.URLDrawableOptions.obtain();
        paramView.mPlayGifImage = false;
        paramView.mLoadingDrawable = URLDrawableHelperConstants.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        paramView = URLDrawable.getDrawable(localTroopGiftAioItemData.jdField_e_of_type_JavaLangString, paramView);
        localHolder.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
      }
      else
      {
        localHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    Object localObject;
    int i;
    StringBuilder localStringBuilder;
    if ((localTroopGiftAioItemData.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c() > 0))
    {
      localHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      localHolder.g.setVisibility(0);
      paramView = localHolder.g;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("免费x");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c());
      paramView.setText(((StringBuilder)localObject).toString());
    }
    else if (localTroopGiftAioItemData.jdField_d_of_type_Boolean)
    {
      if (localHolder.g != null) {
        localHolder.g.setVisibility(8);
      }
      localHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#bbbbbb"));
      paramView = (TroopGiftManager.PackGift)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a.b.get(localTroopGiftAioItemData.jdField_a_of_type_Int);
      if (paramView == null)
      {
        paramView = HardCodeUtil.a(2131705434);
        localHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramView);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("×");
        ((StringBuilder)localObject).append(paramView.jdField_b_of_type_Int);
        paramView = ((StringBuilder)localObject).toString();
        localHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramView);
      }
    }
    else
    {
      if (localHolder.g != null) {
        localHolder.g.setVisibility(8);
      }
      localHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramView = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a.jdField_a_of_type_AndroidUtilSparseArray;
      if (localTroopGiftAioItemData.jdField_e_of_type_Int != 0) {
        i = localTroopGiftAioItemData.jdField_e_of_type_Int;
      } else {
        i = localTroopGiftAioItemData.jdField_a_of_type_Int;
      }
      paramView = (TroopGiftManager.GiveGift)paramView.get(i);
      if ((paramView != null) && (paramView.jdField_b_of_type_Int + paramView.c != 0))
      {
        localHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#fe6387"));
        if (paramView.c > 0)
        {
          localObject = localHolder.jdField_b_of_type_AndroidWidgetTextView;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(HardCodeUtil.a(2131705436));
          localStringBuilder.append(paramView.c);
          localStringBuilder.append(HardCodeUtil.a(2131705432));
          ((TextView)localObject).setText(localStringBuilder.toString());
        }
        else if (paramView.jdField_b_of_type_Int > 0)
        {
          localObject = localHolder.jdField_b_of_type_AndroidWidgetTextView;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(HardCodeUtil.a(2131705435));
          localStringBuilder.append(paramView.jdField_b_of_type_Int);
          ((TextView)localObject).setText(localStringBuilder.toString());
        }
      }
      else
      {
        localHolder.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(localTroopGiftAioItemData.f));
        if ((localTroopGiftAioItemData.jdField_c_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$CoinInfo.jdField_d_of_type_JavaLangString))) {
          paramView = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$CoinInfo.jdField_d_of_type_JavaLangString;
        } else {
          paramView = this.jdField_a_of_type_JavaLangString;
        }
        if (!TextUtils.isEmpty(paramView)) {
          paramView = URLDrawable.getDrawable(paramView, URLDrawable.URLDrawableOptions.obtain());
        } else {
          paramView = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        }
        i = this.jdField_b_of_type_Int;
        paramView.setBounds(0, 0, i, i);
        localHolder.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(paramView, null, null, null);
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a() == 20) {
          localHolder.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(8);
        }
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a() == 20)
        {
          if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b()) {
            localHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#c3c3c3"));
          } else {
            localHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
          }
        }
        else {
          localHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#bbbbbb"));
        }
      }
    }
    if (localTroopGiftAioItemData.jdField_b_of_type_Int == 0) {
      localHolder.e.setVisibility(0);
    } else {
      localHolder.e.setVisibility(8);
    }
    paramView = URLDrawable.URLDrawableOptions.obtain();
    if (localTroopGiftAioItemData.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a() == 20)
      {
        localHolder.jdField_a_of_type_AndroidViewView.setVisibility(4);
        localHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
        localHolder.jdField_a_of_type_AndroidWidgetLinearLayout.post(new GridListAdapter.1(this, localHolder));
      }
      else
      {
        if (localTroopGiftAioItemData.jdField_d_of_type_Int < 0)
        {
          i = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166259);
          localHolder.jdField_c_of_type_AndroidWidgetTextView.setText(localTroopGiftAioItemData.jdField_d_of_type_JavaLangString);
          localHolder.jdField_c_of_type_AndroidWidgetTextView.setTextColor(i);
        }
        else
        {
          i = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166258);
          localHolder.jdField_c_of_type_AndroidWidgetTextView.setText(localTroopGiftAioItemData.jdField_d_of_type_JavaLangString);
          localHolder.jdField_c_of_type_AndroidWidgetTextView.setTextColor(i);
        }
        localHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        localHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localHolder.jdField_a_of_type_AndroidViewView.post(new GridListAdapter.2(this, localHolder, localTroopGiftAioItemData, i));
      }
      paramView.mPlayGifImage = true;
      paramView.mLoadingDrawable = URLDrawableHelperConstants.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      paramView = URLDrawable.getDrawable(localTroopGiftAioItemData.jdField_b_of_type_JavaLangString, paramView);
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a() == 20)
      {
        localHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(null);
      }
      else
      {
        localHolder.jdField_a_of_type_AndroidViewView.setVisibility(4);
        localHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      paramView.mPlayGifImage = false;
      paramView.mLoadingDrawable = URLDrawableHelperConstants.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      paramView = URLDrawable.getDrawable(localTroopGiftAioItemData.jdField_c_of_type_JavaLangString, paramView);
    }
    if (localTroopGiftAioItemData.jdField_c_of_type_Boolean)
    {
      if (localTroopGiftAioItemData.jdField_a_of_type_Boolean)
      {
        localHolder.d.setVisibility(0);
        localObject = localHolder.d;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131705431));
        localStringBuilder.append(localTroopGiftAioItemData.i);
        localStringBuilder.append(HardCodeUtil.a(2131705433));
        ((TextView)localObject).setText(localStringBuilder.toString());
      }
      else
      {
        localHolder.d.setVisibility(8);
      }
      if (!this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c()) {
        localHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      } else {
        localHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    else
    {
      localHolder.d.setVisibility(8);
    }
    localHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
    if ((!this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b()) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a() == 20) && (!TextUtils.isEmpty(localTroopGiftAioItemData.jdField_d_of_type_JavaLangString)))
    {
      localHolder.f.setVisibility(0);
      localHolder.f.setText(localTroopGiftAioItemData.jdField_d_of_type_JavaLangString);
    }
    else
    {
      localHolder.f.setVisibility(8);
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troopgift.GridListAdapter
 * JD-Core Version:    0.7.0.1
 */