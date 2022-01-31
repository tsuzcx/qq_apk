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
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.utils.TroopGiftManager.GiveGift;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import oxa;
import oxb;

public class GridListAdapter
  extends BaseAdapter
{
  protected int a;
  public Context a;
  protected Drawable a;
  protected LayoutInflater a;
  protected TroopGiftPanel a;
  protected String a;
  protected ArrayList a;
  protected int b;
  
  public GridListAdapter(Context paramContext, TroopGiftPanel paramTroopGiftPanel)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130845242);
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = AIOUtils.a(9.0F, paramContext.getResources());
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel = paramTroopGiftPanel;
  }
  
  public Bitmap a(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, int paramInt4)
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
      ((Canvas)localObject1).drawRoundRect(new RectF(paramFloat2 / 2.0F, paramFloat2 / 2.0F, paramInt1 - paramFloat2 / 2.0F, paramInt2 - paramFloat2 / 2.0F), paramInt3, paramInt3, (Paint)localObject2);
      localObject1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      localObject2 = new Canvas((Bitmap)localObject1);
      Paint localPaint = new Paint();
      ((Canvas)localObject2).drawARGB(0, 0, 0, 0);
      paramFloat1 = (paramInt1 - paramFloat1) / 2.0F;
      ((Canvas)localObject2).drawRect(paramFloat1, 0.0F, paramInt1 - paramFloat1, paramInt3, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
      ((Canvas)localObject2).drawBitmap(localBitmap, 0.0F, 0.0F, localPaint);
      localBitmap.recycle();
      return localObject1;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return null;
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_JavaLangString = paramString;
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("GridListAdapter setData items = ");
      if (paramArrayList != null) {
        break label51;
      }
    }
    label51:
    for (Object localObject = "null";; localObject = Integer.valueOf(paramArrayList.size()))
    {
      QLog.d("zivonchen", 2, localObject);
      this.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
      return;
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
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
    paramViewGroup = paramView;
    Object localObject;
    if (paramView == null)
    {
      paramViewGroup = new GridListAdapter.Holder();
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b() != 20) {
        break label632;
      }
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130969493, null);
      if (getCount() < 5) {
        break label1309;
      }
      localObject = new RelativeLayout.LayoutParams(-2, -1);
      ((ViewGroup.LayoutParams)localObject).width = (ScreenUtil.jdField_a_of_type_Int / 5 + 30);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    label384:
    label401:
    label660:
    label794:
    label1052:
    label1309:
    for (;;)
    {
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366694));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366688));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366689));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366691));
      paramViewGroup.g = ((TextView)paramView.findViewById(2131366692));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131366693));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131366687));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131366684));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131366690));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131366686);
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131366685));
      paramView.setTag(paramViewGroup);
      paramViewGroup = paramView;
      localObject = (GridListAdapter.Holder)paramViewGroup.getTag();
      TroopGiftAioItemData localTroopGiftAioItemData = (TroopGiftAioItemData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      ((GridListAdapter.Holder)localObject).jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData = localTroopGiftAioItemData;
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c())
      {
        ((GridListAdapter.Holder)localObject).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        ((GridListAdapter.Holder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(localTroopGiftAioItemData.jdField_a_of_type_JavaLangString);
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b() == 20) {
          ((GridListAdapter.Holder)localObject).jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
        }
        label313:
        if ((!localTroopGiftAioItemData.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c() <= 0)) {
          break label660;
        }
        ((GridListAdapter.Holder)localObject).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        ((GridListAdapter.Holder)localObject).g.setVisibility(0);
        ((GridListAdapter.Holder)localObject).g.setText("免费x" + this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c());
        if (localTroopGiftAioItemData.jdField_b_of_type_Int != 0) {
          break label1052;
        }
        ((GridListAdapter.Holder)localObject).e.setVisibility(0);
        paramView = URLDrawable.URLDrawableOptions.obtain();
        if (!localTroopGiftAioItemData.jdField_a_of_type_Boolean) {
          break label1191;
        }
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b() != 20) {
          break label1065;
        }
        ((GridListAdapter.Holder)localObject).jdField_a_of_type_AndroidViewView.setVisibility(4);
        ((GridListAdapter.Holder)localObject).c.setVisibility(4);
        ((GridListAdapter.Holder)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.post(new oxa(this, (GridListAdapter.Holder)localObject));
        paramView.mPlayGifImage = true;
        paramView.mLoadingDrawable = URLDrawableHelper.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        paramView = URLDrawable.getDrawable(localTroopGiftAioItemData.jdField_b_of_type_JavaLangString, paramView);
        if (!localTroopGiftAioItemData.jdField_c_of_type_Boolean) {
          break label1284;
        }
        if (!localTroopGiftAioItemData.jdField_a_of_type_Boolean) {
          break label1258;
        }
        ((GridListAdapter.Holder)localObject).d.setVisibility(0);
        ((GridListAdapter.Holder)localObject).d.setText("每天限量" + localTroopGiftAioItemData.i + "个");
        label547:
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.d()) {
          break label1271;
        }
        ((GridListAdapter.Holder)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      for (;;)
      {
        ((GridListAdapter.Holder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
        if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c()) || (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b() != 20) || (TextUtils.isEmpty(localTroopGiftAioItemData.jdField_d_of_type_JavaLangString))) {
          break label1297;
        }
        ((GridListAdapter.Holder)localObject).f.setVisibility(0);
        ((GridListAdapter.Holder)localObject).f.setText(localTroopGiftAioItemData.jdField_d_of_type_JavaLangString);
        return paramViewGroup;
        label632:
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130969881, null);
        break;
        ((GridListAdapter.Holder)localObject).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        break label313;
        if (((GridListAdapter.Holder)localObject).g != null) {
          ((GridListAdapter.Holder)localObject).g.setVisibility(8);
        }
        ((GridListAdapter.Holder)localObject).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramView = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a.jdField_a_of_type_AndroidUtilSparseArray;
        if (localTroopGiftAioItemData.e != 0)
        {
          paramInt = localTroopGiftAioItemData.e;
          label712:
          paramView = (TroopGiftManager.GiveGift)paramView.get(paramInt);
          if ((paramView != null) && (paramView.jdField_b_of_type_Int + paramView.c != 0)) {
            break label950;
          }
          ((GridListAdapter.Holder)localObject).jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(localTroopGiftAioItemData.f));
          if ((!localTroopGiftAioItemData.jdField_c_of_type_Boolean) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$CoinInfo.jdField_d_of_type_JavaLangString))) {
            break label905;
          }
          paramView = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$CoinInfo.jdField_d_of_type_JavaLangString;
          if (TextUtils.isEmpty(paramView)) {
            break label913;
          }
        }
        for (paramView = URLDrawable.getDrawable(paramView, URLDrawable.URLDrawableOptions.obtain());; paramView = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable)
        {
          paramView.setBounds(0, 0, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
          ((GridListAdapter.Holder)localObject).jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(paramView, null, null, null);
          if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b() == 20) {
            ((GridListAdapter.Holder)localObject).jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(8);
          }
          if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b() != 20) {
            break label933;
          }
          if (!this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c()) {
            break label921;
          }
          ((GridListAdapter.Holder)localObject).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#c3c3c3"));
          break;
          paramInt = localTroopGiftAioItemData.jdField_a_of_type_Int;
          break label712;
          paramView = this.jdField_a_of_type_JavaLangString;
          break label794;
        }
        ((GridListAdapter.Holder)localObject).jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
        break label384;
        label933:
        ((GridListAdapter.Holder)localObject).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#bbbbbb"));
        break label384;
        label950:
        ((GridListAdapter.Holder)localObject).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#fe6387"));
        if (paramView.c > 0)
        {
          ((GridListAdapter.Holder)localObject).jdField_b_of_type_AndroidWidgetTextView.setText("限免" + paramView.c + "次");
          break label384;
        }
        if (paramView.jdField_b_of_type_Int <= 0) {
          break label384;
        }
        ((GridListAdapter.Holder)localObject).jdField_b_of_type_AndroidWidgetTextView.setText("体验券×" + paramView.jdField_b_of_type_Int);
        break label384;
        ((GridListAdapter.Holder)localObject).e.setVisibility(8);
        break label401;
        label1065:
        if (localTroopGiftAioItemData.jdField_d_of_type_Int < 0)
        {
          paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131493603);
          ((GridListAdapter.Holder)localObject).c.setText(localTroopGiftAioItemData.jdField_d_of_type_JavaLangString);
          ((GridListAdapter.Holder)localObject).c.setTextColor(paramInt);
        }
        for (;;)
        {
          ((GridListAdapter.Holder)localObject).c.setVisibility(0);
          ((GridListAdapter.Holder)localObject).jdField_a_of_type_AndroidViewView.setVisibility(0);
          ((GridListAdapter.Holder)localObject).jdField_a_of_type_AndroidViewView.post(new oxb(this, (GridListAdapter.Holder)localObject, localTroopGiftAioItemData, paramInt));
          break;
          paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131493604);
          ((GridListAdapter.Holder)localObject).c.setText(localTroopGiftAioItemData.jdField_d_of_type_JavaLangString);
          ((GridListAdapter.Holder)localObject).c.setTextColor(paramInt);
        }
        label1191:
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b() == 20) {
          ((GridListAdapter.Holder)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(null);
        }
        for (;;)
        {
          paramView.mPlayGifImage = false;
          paramView.mLoadingDrawable = URLDrawableHelper.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          paramView = URLDrawable.getDrawable(localTroopGiftAioItemData.jdField_c_of_type_JavaLangString, paramView);
          break;
          ((GridListAdapter.Holder)localObject).jdField_a_of_type_AndroidViewView.setVisibility(4);
          ((GridListAdapter.Holder)localObject).c.setVisibility(4);
        }
        label1258:
        ((GridListAdapter.Holder)localObject).d.setVisibility(8);
        break label547;
        label1271:
        ((GridListAdapter.Holder)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        continue;
        ((GridListAdapter.Holder)localObject).d.setVisibility(8);
      }
      ((GridListAdapter.Holder)localObject).f.setVisibility(8);
      return paramViewGroup;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troopgift.GridListAdapter
 * JD-Core Version:    0.7.0.1
 */