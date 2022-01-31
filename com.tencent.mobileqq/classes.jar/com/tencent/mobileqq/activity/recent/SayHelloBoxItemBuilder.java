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
  private List a;
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder = paramRecentFaceDecoder;
    paramViewGroup = null;
    paramRecentFaceDecoder = paramViewGroup;
    if (paramView != null)
    {
      paramRecentFaceDecoder = paramViewGroup;
      if (paramView.getTag() != null)
      {
        paramRecentFaceDecoder = paramViewGroup;
        if ((paramView.getTag() instanceof SayHelloBoxItemBuilder.SayHelloBoxItemHolder)) {
          paramRecentFaceDecoder = (SayHelloBoxItemBuilder.SayHelloBoxItemHolder)paramView.getTag();
        }
      }
    }
    if (paramRecentFaceDecoder == null)
    {
      paramViewGroup = new SayHelloBoxItemBuilder.SayHelloBoxItemHolder();
      paramOnDragModeChangedListener = super.a(paramContext, 2130970397, paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramOnDragModeChangedListener.findViewById(2131365230));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramOnDragModeChangedListener.findViewById(2131369715));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramOnDragModeChangedListener.findViewById(2131370384));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramOnDragModeChangedListener.findViewById(2131370382));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView = ((MyGridView)paramOnDragModeChangedListener.findViewById(2131370383));
      paramRecentFaceDecoder = paramContext.getResources();
      paramView = paramRecentFaceDecoder.getDisplayMetrics();
      int m = (int)(Math.min(paramView.widthPixels, paramView.heightPixels) - paramView.density * 119.0F);
      int i = paramRecentFaceDecoder.getDimensionPixelSize(2131559098);
      int k = paramRecentFaceDecoder.getDimensionPixelSize(2131559099);
      if (i <= 0)
      {
        i = 45;
        int j = k;
        if (k <= 0) {
          j = 10;
        }
        m /= (i + j);
        k = m;
        if (m > 6) {
          k = 6;
        }
        paramRecentFaceDecoder = new SayHelloBoxItemBuilder.MsgHeaderAdapter(this, paramContext, k, i);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setColumnWidth(i);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setNumColumns(k);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setHorizontalSpacing(j);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setStretchMode(0);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.a();
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setAdapter(paramRecentFaceDecoder);
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(14.0F, 1);
        paramOnDragModeChangedListener.setTag(paramViewGroup);
        paramView = paramOnDragModeChangedListener;
        paramRecentFaceDecoder = paramViewGroup;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)
        {
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a());
          paramRecentFaceDecoder = paramViewGroup;
          paramView = paramOnDragModeChangedListener;
        }
      }
    }
    for (;;)
    {
      paramRecentFaceDecoder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      paramViewGroup = paramContext.getResources().getDrawable(2130842777);
      if ((paramRecentFaceDecoder != null) && ((paramObject instanceof RecentBaseData))) {
        a(paramView, (RecentBaseData)paramObject, paramContext, paramViewGroup);
      }
      for (;;)
      {
        super.a(paramContext, paramView, paramInt, paramObject, paramRecentFaceDecoder, paramOnClickListener);
        paramView.setOnClickListener(paramOnClickListener);
        paramView.setOnLongClickListener(paramOnLongClickListener);
        paramView.setTag(-1, Integer.valueOf(paramInt));
        if (AppSetting.b) {
          paramView.setContentDescription(null);
        }
        return paramView;
        if (paramRecentFaceDecoder != null)
        {
          paramRecentFaceDecoder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup);
          paramRecentFaceDecoder.jdField_a_of_type_AndroidWidgetTextView.setText("");
          paramRecentFaceDecoder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText("");
        }
      }
      break;
    }
  }
  
  public List a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    if ((paramRecentBaseData == null) || (paramContext == null)) {
      return null;
    }
    paramRecentBaseData = paramContext.getResources();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[0]));
      return this.jdField_a_of_type_JavaUtilList;
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable arg4)
  {
    int i = 0;
    if ((paramView == null) || (paramRecentBaseData == null) || (!(paramRecentBaseData instanceof RecentSayHelloBoxItem))) {}
    do
    {
      return;
      localObject = paramView.getTag();
    } while (!(localObject instanceof SayHelloBoxItemBuilder.SayHelloBoxItemHolder));
    Object localObject = (SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject;
    RecentSayHelloBoxItem localRecentSayHelloBoxItem = (RecentSayHelloBoxItem)paramRecentBaseData;
    ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(???);
    ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(2131437935);
    int k = paramRecentBaseData.c;
    int j = paramRecentBaseData.b;
    if (k > 0) {
      if (j == 3)
      {
        j = 2130845928;
        ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1);
        i = 3;
      }
    }
    for (;;)
    {
      label105:
      CustomWidgetUtil.a(((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, k, j, 99, null);
      i = paramRecentBaseData.e;
      ??? = paramRecentBaseData.jdField_d_of_type_JavaLangCharSequence;
      if (??? != null)
      {
        ??? = ???.toString();
        label148:
        if (!TextUtils.isEmpty(???)) {
          ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(ColorStateList.valueOf(i), 1);
        }
        ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(???, 1);
      }
      for (;;)
      {
        synchronized (localRecentSayHelloBoxItem.jdField_a_of_type_JavaLangObject)
        {
          if (!TextUtils.isEmpty(localRecentSayHelloBoxItem.jdField_d_of_type_JavaLangCharSequence))
          {
            ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setVisibility(8);
            ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
            ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localRecentSayHelloBoxItem.c);
            ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131494257));
            if (!AppSetting.b) {
              break;
            }
            paramView.setContentDescription(paramRecentBaseData.jdField_d_of_type_JavaLangString);
            return;
            j = 2130845927;
            ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
            i = 3;
            break label105;
            ??? = "";
            break label148;
          }
          if ((localRecentSayHelloBoxItem.jdField_a_of_type_JavaUtilList != null) && (localRecentSayHelloBoxItem.jdField_a_of_type_JavaUtilList.size() > 0))
          {
            ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setVisibility(8);
            ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setVisibility(0);
            ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131494257));
            if (((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getAdapter() == null) {
              continue;
            }
            SayHelloBoxItemBuilder.MsgHeaderAdapter.a((SayHelloBoxItemBuilder.MsgHeaderAdapter)((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getAdapter(), localRecentSayHelloBoxItem.jdField_a_of_type_JavaUtilList);
          }
        }
        ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setVisibility(8);
        ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
        ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localRecentSayHelloBoxItem.c);
        ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131494257));
      }
      j = 0;
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, MessageRecord paramMessageRecord, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramMessageRecord == null) || (paramDrawable == null) || (!(paramRecentBaseData instanceof RecentSayHelloBoxItem))) {}
    for (;;)
    {
      return;
      paramView = paramView.getTag();
      if ((paramView instanceof SayHelloBoxItemBuilder.SayHelloBoxItemHolder))
      {
        paramView = (SayHelloBoxItemBuilder.SayHelloBoxItemHolder)paramView;
        int j = paramView.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getCount();
        int i = 0;
        while (i < j)
        {
          paramRecentBaseData = paramView.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getChildAt(i);
          if ((paramRecentBaseData != null) && ((paramRecentBaseData.getTag(-1) instanceof String)))
          {
            String str = (String)paramRecentBaseData.getTag(-1);
            if (str.equals(paramMessageRecord.senderuin))
            {
              ((CustomImgView)paramRecentBaseData).setImageDrawable(paramDrawable);
              return;
            }
            if (QLog.isDevelopLevel()) {
              QLog.d("SAYHELL_BOX", 4, "updateMsgHeader,childView uin:" + str);
            }
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.SayHelloBoxItemBuilder
 * JD-Core Version:    0.7.0.1
 */