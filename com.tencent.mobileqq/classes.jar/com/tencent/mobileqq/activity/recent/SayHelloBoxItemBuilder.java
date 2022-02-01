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
import com.tencent.mobileqq.newnearby.INearbyMsgbox;
import com.tencent.mobileqq.qroute.QRoute;
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
  private List<String> b;
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    this.a = paramRecentFaceDecoder;
    if ((paramView != null) && (paramView.getTag() != null) && ((paramView.getTag() instanceof SayHelloBoxItemBuilder.SayHelloBoxItemHolder))) {
      paramRecentFaceDecoder = (SayHelloBoxItemBuilder.SayHelloBoxItemHolder)paramView.getTag();
    } else {
      paramRecentFaceDecoder = null;
    }
    if (paramRecentFaceDecoder == null)
    {
      paramRecentFaceDecoder = new SayHelloBoxItemBuilder.SayHelloBoxItemHolder();
      paramView = super.a(paramContext, 2131627545, paramRecentFaceDecoder);
      paramRecentFaceDecoder.a = ((ImageView)paramView.findViewById(2131435245));
      paramRecentFaceDecoder.b = ((TextView)paramView.findViewById(2131447585));
      paramRecentFaceDecoder.c = ((DragTextView)paramView.findViewById(2131449126));
      paramRecentFaceDecoder.d = ((SingleLineTextView)paramView.findViewById(2131438952));
      paramRecentFaceDecoder.e = ((MyGridView)paramView.findViewById(2131438923));
      paramViewGroup = paramContext.getResources();
      paramOnDragModeChangedListener = paramViewGroup.getDisplayMetrics();
      int m = (int)(Math.min(paramOnDragModeChangedListener.widthPixels, paramOnDragModeChangedListener.heightPixels) - paramOnDragModeChangedListener.density * 119.0F);
      int j = paramViewGroup.getDimensionPixelSize(2131299670);
      int k = paramViewGroup.getDimensionPixelSize(2131299669);
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
      paramRecentFaceDecoder.e.setColumnWidth(i);
      paramRecentFaceDecoder.e.setNumColumns(k);
      paramRecentFaceDecoder.e.setHorizontalSpacing(j);
      paramRecentFaceDecoder.e.setStretchMode(0);
      paramRecentFaceDecoder.e.a();
      paramRecentFaceDecoder.e.setAdapter(paramViewGroup);
      paramRecentFaceDecoder.d.setExtendTextSize(14.0F, 1);
      paramView.setTag(paramRecentFaceDecoder);
      if (this.f != null) {
        paramRecentFaceDecoder.c.setOnModeChangeListener(this.f.b());
      }
    }
    paramRecentFaceDecoder.c.setTag(Integer.valueOf(paramInt));
    if (((INearbyMsgbox)QRoute.api(INearbyMsgbox.class)).isNewNearby()) {
      paramViewGroup = paramContext.getResources().getDrawable(2130847186);
    } else {
      paramViewGroup = paramContext.getResources().getDrawable(2130847185);
    }
    if ((paramRecentFaceDecoder != null) && ((paramObject instanceof RecentBaseData)))
    {
      a(paramView, (RecentBaseData)paramObject, paramContext, paramViewGroup);
    }
    else if (paramRecentFaceDecoder != null)
    {
      paramRecentFaceDecoder.a.setImageDrawable(paramViewGroup);
      paramRecentFaceDecoder.b.setText("");
      paramRecentFaceDecoder.d.setText("");
    }
    super.a(paramContext, paramView, paramInt, paramObject, paramRecentFaceDecoder, paramOnClickListener);
    paramView.setOnClickListener(paramOnClickListener);
    paramView.setOnLongClickListener(paramOnLongClickListener);
    paramView.setTag(-1, Integer.valueOf(paramInt));
    if (AppSetting.e) {
      paramView.setContentDescription(null);
    }
    return paramView;
  }
  
  public List<String> a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    if ((paramRecentBaseData != null) && (paramContext != null))
    {
      paramRecentBaseData = paramContext.getResources();
      paramContext = this.b;
      if (paramContext == null) {
        this.b = new ArrayList();
      } else {
        paramContext.clear();
      }
      this.b.add(paramRecentBaseData.getString(c[0]));
      return this.b;
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
      ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).a.setImageDrawable(???);
      ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).b.setText(2131897025);
      int k = paramRecentBaseData.mUnreadNum;
      int i = paramRecentBaseData.mUnreadFlag;
      int j;
      if (k > 0)
      {
        if (i == 3)
        {
          ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).c.setDragViewType(1);
          i = 3;
          j = 2130852596;
        }
        else
        {
          ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).c.setDragViewType(0);
          i = 3;
          j = 2130852592;
        }
      }
      else
      {
        i = 0;
        j = 0;
      }
      CustomWidgetUtil.a(((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).c, i, k, j, 99, null);
      i = paramRecentBaseData.mExtraInfoColor;
      ??? = paramRecentBaseData.mMsgExtroInfo;
      if (??? != null) {
        ??? = ???.toString();
      } else {
        ??? = "";
      }
      if (!TextUtils.isEmpty(???)) {
        ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).d.setExtendTextColor(ColorStateList.valueOf(i), 1);
      }
      ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).d.setExtendText(???, 1);
      synchronized (localRecentSayHelloBoxItem.lock)
      {
        if (!TextUtils.isEmpty(localRecentSayHelloBoxItem.mMsgExtroInfo))
        {
          ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).e.setVisibility(8);
          ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).d.setVisibility(0);
          ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).d.setText(localRecentSayHelloBoxItem.mLastMsg);
          ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).d.setTextColor(paramContext.getResources().getColor(2131168118));
        }
        else if ((localRecentSayHelloBoxItem.mUnreadMRList != null) && (localRecentSayHelloBoxItem.mUnreadMRList.size() > 0))
        {
          ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).d.setVisibility(8);
          ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).e.setVisibility(0);
          ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).d.setTextColor(paramContext.getResources().getColor(2131168118));
          if (((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).e.getAdapter() != null) {
            SayHelloBoxItemBuilder.MsgHeaderAdapter.a((SayHelloBoxItemBuilder.MsgHeaderAdapter)((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).e.getAdapter(), localRecentSayHelloBoxItem.mUnreadMRList);
          }
        }
        else
        {
          ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).e.setVisibility(8);
          ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).d.setVisibility(0);
          ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).d.setText(localRecentSayHelloBoxItem.mLastMsg);
          ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).d.setTextColor(paramContext.getResources().getColor(2131168118));
        }
        if (AppSetting.e) {
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
      int j = paramView.e.getCount();
      int i = 0;
      while (i < j)
      {
        Object localObject = paramView.e.getChildAt(i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.SayHelloBoxItemBuilder
 * JD-Core Version:    0.7.0.1
 */