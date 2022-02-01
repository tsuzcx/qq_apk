package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloBoxItem;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.MyGridView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomImgView;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.List;

public class SayHelloBoxItemBuilder
  extends RecentItemBaseBuilder
{
  protected RecentFaceDecoder a;
  private List<String> a;
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder = paramRecentFaceDecoder;
    if ((paramView != null) && (paramView.getTag() != null) && ((paramView.getTag() instanceof SayHelloBoxItemBuilder.SayHelloBoxItemHolder))) {
      paramRecentFaceDecoder = (SayHelloBoxItemBuilder.SayHelloBoxItemHolder)paramView.getTag();
    } else {
      paramRecentFaceDecoder = null;
    }
    if (paramRecentFaceDecoder == null)
    {
      paramRecentFaceDecoder = new SayHelloBoxItemBuilder.SayHelloBoxItemHolder();
      paramView = super.a(paramContext, 2131561193, paramRecentFaceDecoder);
      paramRecentFaceDecoder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368366));
      paramRecentFaceDecoder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378884));
      paramRecentFaceDecoder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131380208));
      paramRecentFaceDecoder.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131371571));
      paramRecentFaceDecoder.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView = ((MyGridView)paramView.findViewById(2131371544));
      paramViewGroup = paramContext.getResources();
      paramOnDragModeChangedListener = paramViewGroup.getDisplayMetrics();
      int m = (int)(Math.min(paramOnDragModeChangedListener.widthPixels, paramOnDragModeChangedListener.heightPixels) - paramOnDragModeChangedListener.density * 119.0F);
      int j = paramViewGroup.getDimensionPixelSize(2131298948);
      int k = paramViewGroup.getDimensionPixelSize(2131298947);
      int i = j;
      if (j <= 0) {
        i = 45;
      }
      j = k;
      if (k <= 0) {
        j = 10;
      }
      k = m / (i + j);
      m = 6;
      if (k > 6) {
        k = m;
      }
      paramViewGroup = new SayHelloBoxItemBuilder.MsgHeaderAdapter(this, paramContext, k, i);
      paramRecentFaceDecoder.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setColumnWidth(i);
      paramRecentFaceDecoder.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setNumColumns(k);
      paramRecentFaceDecoder.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setHorizontalSpacing(j);
      paramRecentFaceDecoder.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setStretchMode(0);
      paramRecentFaceDecoder.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.a();
      paramRecentFaceDecoder.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setAdapter(paramViewGroup);
      paramRecentFaceDecoder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(14.0F, 1);
      paramView.setTag(paramRecentFaceDecoder);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
        paramRecentFaceDecoder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a());
      }
    }
    paramRecentFaceDecoder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
    paramViewGroup = paramContext.getResources().getDrawable(2130845716);
    if ((paramRecentFaceDecoder != null) && ((paramObject instanceof RecentBaseData)))
    {
      a(paramView, (RecentBaseData)paramObject, paramContext, paramViewGroup);
    }
    else if (paramRecentFaceDecoder != null)
    {
      paramRecentFaceDecoder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup);
      paramRecentFaceDecoder.jdField_a_of_type_AndroidWidgetTextView.setText("");
      paramRecentFaceDecoder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText("");
    }
    super.a(paramContext, paramView, paramInt, paramObject, paramRecentFaceDecoder, paramOnClickListener);
    paramView.setOnClickListener(paramOnClickListener);
    paramView.setOnLongClickListener(paramOnLongClickListener);
    paramView.setTag(-1, Integer.valueOf(paramInt));
    if (AppSetting.d) {
      paramView.setContentDescription(null);
    }
    return paramView;
  }
  
  public List<String> a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    if ((paramRecentBaseData != null) && (paramContext != null))
    {
      paramRecentBaseData = paramContext.getResources();
      paramContext = this.jdField_a_of_type_JavaUtilList;
      if (paramContext == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      } else {
        paramContext.clear();
      }
      this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[0]));
      return this.jdField_a_of_type_JavaUtilList;
    }
    return null;
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable arg4)
  {
    if ((paramView != null) && (paramRecentBaseData != null))
    {
      if (!(paramRecentBaseData instanceof RecentSayHelloBoxItem)) {
        return;
      }
      Object localObject = paramView.getTag();
      if (!(localObject instanceof SayHelloBoxItemBuilder.SayHelloBoxItemHolder)) {
        return;
      }
      localObject = (SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject;
      RecentSayHelloBoxItem localRecentSayHelloBoxItem = (RecentSayHelloBoxItem)paramRecentBaseData;
      ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(???);
      ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(2131699017);
      int k = paramRecentBaseData.mUnreadNum;
      int i = paramRecentBaseData.mUnreadFlag;
      int j;
      if (k > 0)
      {
        if (i == 3)
        {
          ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1);
          i = 3;
          j = 2130850774;
        }
        else
        {
          ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
          i = 3;
          j = 2130850770;
        }
      }
      else
      {
        i = 0;
        j = 0;
      }
      CustomWidgetUtil.a(((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, k, j, 99, null);
      i = paramRecentBaseData.mExtraInfoColor;
      ??? = paramRecentBaseData.mMsgExtroInfo;
      if (??? != null) {
        ??? = ???.toString();
      } else {
        ??? = "";
      }
      if (!TextUtils.isEmpty(???)) {
        ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(ColorStateList.valueOf(i), 1);
      }
      ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(???, 1);
      synchronized (localRecentSayHelloBoxItem.lock)
      {
        if (!TextUtils.isEmpty(localRecentSayHelloBoxItem.mMsgExtroInfo))
        {
          ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setVisibility(8);
          ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
          ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localRecentSayHelloBoxItem.mLastMsg);
          ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131167138));
        }
        else if ((localRecentSayHelloBoxItem.mUnreadMRList != null) && (localRecentSayHelloBoxItem.mUnreadMRList.size() > 0))
        {
          ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setVisibility(8);
          ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setVisibility(0);
          ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131167138));
          if (((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getAdapter() != null) {
            SayHelloBoxItemBuilder.MsgHeaderAdapter.a((SayHelloBoxItemBuilder.MsgHeaderAdapter)((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getAdapter(), localRecentSayHelloBoxItem.mUnreadMRList);
          }
        }
        else
        {
          ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setVisibility(8);
          ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
          ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localRecentSayHelloBoxItem.mLastMsg);
          ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131167138));
        }
        if (AppSetting.d) {
          paramView.setContentDescription(paramRecentBaseData.mContentDesc);
        }
        return;
      }
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, MessageRecord paramMessageRecord, Drawable paramDrawable)
  {
    if ((paramView != null) && (paramMessageRecord != null) && (paramDrawable != null))
    {
      if (!(paramRecentBaseData instanceof RecentSayHelloBoxItem)) {
        return;
      }
      paramView = paramView.getTag();
      if (!(paramView instanceof SayHelloBoxItemBuilder.SayHelloBoxItemHolder)) {
        return;
      }
      paramView = (SayHelloBoxItemBuilder.SayHelloBoxItemHolder)paramView;
      int j = paramView.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getCount();
      int i = 0;
      while (i < j)
      {
        Object localObject = paramView.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getChildAt(i);
        if ((localObject != null) && ((((View)localObject).getTag(-1) instanceof String)))
        {
          paramRecentBaseData = (String)((View)localObject).getTag(-1);
          if (paramRecentBaseData.equals(paramMessageRecord.senderuin))
          {
            ((CustomImgView)localObject).setImageDrawable(paramDrawable);
            return;
          }
          if (QLog.isDevelopLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("updateMsgHeader,childView uin:");
            ((StringBuilder)localObject).append(paramRecentBaseData);
            QLog.d("SAYHELL_BOX", 4, ((StringBuilder)localObject).toString());
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.SayHelloBoxItemBuilder
 * JD-Core Version:    0.7.0.1
 */