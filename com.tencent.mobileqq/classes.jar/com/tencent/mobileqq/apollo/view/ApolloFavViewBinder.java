package com.tencent.mobileqq.apollo.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.barrage.ApolloBarrageUtil;
import com.tencent.mobileqq.apollo.store.ApolloImageDownloader;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.List;
import yxc;

public class ApolloFavViewBinder
  extends ApolloViewBinder
{
  private static int g;
  private static int h;
  private static int i;
  private static int j;
  private int a;
  private int b;
  
  public ApolloFavViewBinder(Context paramContext, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_Int = 4;
    this.jdField_b_of_type_Int = 2;
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    this.d = 2;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  public int a()
  {
    int m = 1;
    int n = this.jdField_a_of_type_Int * this.jdField_b_of_type_Int;
    int k = m;
    switch (this.c)
    {
    default: 
      k = 0;
    }
    int i1;
    do
    {
      do
      {
        do
        {
          return k;
          k = m;
        } while (this.jdField_a_of_type_JavaUtilList == null);
        k = m;
      } while (this.jdField_a_of_type_JavaUtilList.size() == 0);
      i1 = this.jdField_a_of_type_JavaUtilList.size();
      if ((this.jdField_a_of_type_JavaUtilList == null) || (i1 <= 0)) {
        break;
      }
      m = i1 / n + 0;
      k = m;
    } while (i1 % n == 0);
    return m + 1;
  }
  
  public int a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return -1;
    }
    return paramInt / (this.jdField_b_of_type_Int * this.jdField_a_of_type_Int);
  }
  
  public View a()
  {
    switch (this.c)
    {
    default: 
      return new ApolloLinearLayout(this.jdField_b_of_type_AndroidContentContext, null, this.d, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    case 4: 
      return LayoutInflater.from(this.jdField_b_of_type_AndroidContentContext).inflate(2130968682, null);
    }
    return new ApolloLinearLayout(this.jdField_b_of_type_AndroidContentContext, null, this.d, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
  }
  
  public ApolloInfo a(String paramString)
  {
    return new ApolloMainInfo(paramString);
  }
  
  public ArrayList a(int paramInt)
  {
    if ((this.c != 0) || (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {}
    do
    {
      return null;
      k = a();
    } while ((paramInt < 0) || (paramInt >= k));
    int k = this.jdField_a_of_type_Int;
    int m = this.jdField_b_of_type_Int * k;
    k = paramInt * m;
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_Int * this.jdField_b_of_type_Int);
    paramInt = k;
    while ((paramInt < this.jdField_a_of_type_JavaUtilList.size()) && (paramInt <= m + k - 1))
    {
      localArrayList.add(this.jdField_a_of_type_JavaUtilList.get(paramInt));
      paramInt += 1;
    }
    return localArrayList;
  }
  
  public void a(View paramView, int paramInt)
  {
    b(paramView, paramInt);
  }
  
  public void b(View paramView, int paramInt)
  {
    if (!(paramView instanceof ApolloLinearLayout)) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "panel is not apolloLinearLayout");
      }
    }
    label196:
    label464:
    label1386:
    for (;;)
    {
      return;
      int i2 = this.jdField_a_of_type_Int;
      int i3 = this.jdField_b_of_type_Int;
      int k = 0;
      int m = 0;
      for (;;)
      {
        if (m >= this.jdField_b_of_type_Int) {
          break label1386;
        }
        LinearLayout localLinearLayout = (LinearLayout)((ApolloLinearLayout)paramView).getChildAt(m);
        int n = 0;
        if (n < this.jdField_a_of_type_Int)
        {
          View localView = localLinearLayout.getChildAt(n);
          ApolloLinearLayout.ViewHolder localViewHolder = (ApolloLinearLayout.ViewHolder)localView.getTag();
          int i1 = i2 * i3 * paramInt + k;
          if (this.jdField_a_of_type_JavaUtilList == null) {
            break;
          }
          label250:
          float f;
          int i4;
          Object localObject1;
          if (i1 < this.jdField_a_of_type_JavaUtilList.size())
          {
            ApolloActionData localApolloActionData = ((ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(i1)).a;
            localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo = ((ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(i1));
            if (localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.jdField_b_of_type_Int == 2)
            {
              localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838115);
              localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
              localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localApolloActionData.actionName);
              localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.c = 0;
              if (TextUtils.isEmpty(localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.jdField_b_of_type_JavaLangString)) {
                break label1282;
              }
              if (XPanelContainer.d != 0) {
                break label1057;
              }
              i1 = 1;
              localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
              localViewHolder.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
              localViewHolder.e.setVisibility(0);
              localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.jdField_b_of_type_JavaLangString);
              if (i1 == 0) {
                break label1063;
              }
              f = 3.0F;
              i4 = AIOUtils.a(f, this.jdField_b_of_type_AndroidContentContext.getResources());
              localObject1 = (RelativeLayout.LayoutParams)localViewHolder.jdField_c_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
              ((RelativeLayout.LayoutParams)localObject1).topMargin = i4;
              ((RelativeLayout.LayoutParams)localObject1).width = (ApolloLinearLayout.e - i4 * 2);
              localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setMaxHeight(ApolloLinearLayout.e - i4 * 3);
              localObject1 = (RelativeLayout.LayoutParams)localViewHolder.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
              if (i1 == 0) {
                break label1070;
              }
              f = 2.0F;
              label383:
              ((RelativeLayout.LayoutParams)localObject1).topMargin = AIOUtils.a(f, this.jdField_b_of_type_AndroidContentContext.getResources());
              localViewHolder.e.setBackgroundResource(2130838010);
              if (localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.d != 1) {
                break label1135;
              }
              if (i1 == 0) {
                break label1077;
              }
              localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTextSize(8.0F);
              if (i == 0) {
                i = ApolloBarrageUtil.a(localViewHolder.jdField_c_of_type_AndroidWidgetTextView.getPaint());
              }
              ((RelativeLayout.LayoutParams)localObject1).width = i;
              localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-4473925);
              localViewHolder.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(null);
              localObject1 = localViewHolder.jdField_c_of_type_AndroidWidgetRelativeLayout;
              if (i1 == 0) {
                break label1275;
              }
              f = 3.0F;
              label498:
              ((RelativeLayout)localObject1).setPadding(0, 0, 0, AIOUtils.a(f, this.jdField_b_of_type_AndroidContentContext.getResources()));
              localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setMaxLines(3);
              if (!TextUtils.isEmpty(localApolloActionData.iconUrl))
              {
                localViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(ApolloImageDownloader.a(String.valueOf(localApolloActionData.iconUrl.hashCode()), null, localApolloActionData.iconUrl, true));
                localViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
              }
              ApolloLinearLayout.setApolloActionIcon(localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.g, localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.a, localViewHolder);
              if ((localApolloActionData.personNum != 1) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000))) {
                break label1324;
              }
              localViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
              label638:
              localObject1 = (RelativeLayout)localView;
              i1 = this.jdField_b_of_type_Int;
              i4 = this.jdField_a_of_type_Int;
              int i5 = this.jdField_a_of_type_Int;
              if ((this.f == -1) || (this.f != i1 * paramInt * i4 + i5 * m + n)) {
                break label1337;
              }
              if (QLog.isColorLevel()) {
                QLog.d("ApolloMainViewBinder", 2, new Object[] { "[updateBinderPanel] highlight item, start animation, mHighlightItemIndex=", Integer.valueOf(this.f), ", name=", localApolloActionData.actionName, ",id=", Integer.valueOf(localApolloActionData.actionId), ", pkgId=", Integer.valueOf(this.e) });
              }
              if (localViewHolder.jdField_a_of_type_AndroidViewView != null)
              {
                ((RelativeLayout)localObject1).removeView(localViewHolder.jdField_a_of_type_AndroidViewView);
                localViewHolder.jdField_a_of_type_AndroidViewView = null;
              }
              Object localObject2 = new RelativeLayout.LayoutParams(-1, -1);
              ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131363232);
              ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131363232);
              ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131363232);
              ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131363232);
              RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_b_of_type_AndroidContentContext);
              localRelativeLayout.setId(2131362379);
              localRelativeLayout.setBackgroundDrawable(null);
              ((RelativeLayout)localObject1).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject2);
              localViewHolder.jdField_a_of_type_AndroidViewView = localRelativeLayout;
              localObject2 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
              ((ImageView)localObject2).setImageResource(2130838139);
              ((ImageView)localObject2).setVisibility(8);
              localRelativeLayout.addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
              ((ImageView)localObject2).postDelayed(new yxc(this, (ImageView)localObject2, localRelativeLayout, (RelativeLayout)localObject1, localViewHolder), 200L);
              this.f = -1;
              localView.setContentDescription(localApolloActionData.actionName + "按钮");
            }
          }
          for (;;)
          {
            k += 1;
            n += 1;
            break;
            localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(((ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(i1)).a(this.jdField_b_of_type_AndroidContentContext, this.jdField_b_of_type_AndroidContentContext.getResources().getDisplayMetrics().density));
            break label196;
            i1 = 0;
            break label250;
            f = 5.0F;
            break label301;
            f = 5.0F;
            break label383;
            localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setMaxHeight(ApolloLinearLayout.e - i4 * 2);
            localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTextSize(12.0F);
            if (g == 0) {
              g = ApolloBarrageUtil.a(localViewHolder.jdField_c_of_type_AndroidWidgetTextView.getPaint());
            }
            ((RelativeLayout.LayoutParams)localObject1).width = g;
            break label464;
            label1135:
            if (i1 != 0)
            {
              localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTextSize(7.0F);
              if (j == 0) {
                j = ApolloBarrageUtil.a(localViewHolder.jdField_c_of_type_AndroidWidgetTextView.getPaint());
              }
              ((RelativeLayout.LayoutParams)localObject1).width = j;
              localObject1 = localViewHolder.jdField_c_of_type_AndroidWidgetTextView;
              if (i1 == 0) {
                break label1268;
              }
            }
            label1268:
            for (f = 7.0F;; f = 10.0F)
            {
              ((TextView)localObject1).setTextSize(f);
              localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-8947849);
              localViewHolder.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838011);
              break;
              localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTextSize(10.0F);
              if (h == 0) {
                h = ApolloBarrageUtil.a(localViewHolder.jdField_c_of_type_AndroidWidgetTextView.getPaint());
              }
              ((RelativeLayout.LayoutParams)localObject1).width = h;
              break label1179;
            }
            label1275:
            f = 9.0F;
            break label498;
            localViewHolder.e.setBackgroundDrawable(null);
            localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            localViewHolder.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            localViewHolder.e.setVisibility(8);
            break label526;
            localViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
            break label638;
            if (localViewHolder.jdField_a_of_type_AndroidViewView == null) {
              break label968;
            }
            ((RelativeLayout)localObject1).removeView(localViewHolder.jdField_a_of_type_AndroidViewView);
            localViewHolder.jdField_a_of_type_AndroidViewView = null;
            break label968;
            localView.setContentDescription(null);
            localView.setOnClickListener(null);
          }
        }
        m += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloFavViewBinder
 * JD-Core Version:    0.7.0.1
 */