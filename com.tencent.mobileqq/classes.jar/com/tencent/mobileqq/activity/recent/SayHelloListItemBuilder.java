package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloListItem;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.mobileqq.nearby.api.INearbyFlowerUtil;
import com.tencent.mobileqq.nearby.now.utils.IImageLoader;
import com.tencent.mobileqq.nearby.profilecard.MiniCardManagerUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.BizTroopUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.nowsummarycard.NowSummaryCard.MiniCard;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.List;

public class SayHelloListItemBuilder
  extends RecentItemBaseBuilder
{
  private List<String> a;
  
  private void a(RecentBaseData paramRecentBaseData, Context paramContext, SayHelloListItemBuilder.SayHelloListItemHolder paramSayHelloListItemHolder)
  {
    if (MiniCardManagerUtils.a(paramRecentBaseData.getRecentUserUin()))
    {
      paramRecentBaseData = MiniCardManagerUtils.b(paramRecentBaseData.getRecentUserUin());
      paramSayHelloListItemHolder.d.setText(paramRecentBaseData.nick.get());
      ((IImageLoader)QRoute.api(IImageLoader.class)).displayImage(paramSayHelloListItemHolder.a, paramRecentBaseData.logo.get(), paramContext.getResources().getDrawable(2130847053), paramContext.getResources().getDrawable(2130847053), null, true);
    }
  }
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    paramOnDragModeChangedListener = null;
    if ((paramView != null) && (paramView.getTag() != null) && ((paramView.getTag() instanceof SayHelloListItemBuilder.SayHelloListItemHolder))) {
      paramViewGroup = (SayHelloListItemBuilder.SayHelloListItemHolder)paramView.getTag();
    } else {
      paramViewGroup = null;
    }
    if (paramViewGroup == null)
    {
      paramViewGroup = new SayHelloListItemBuilder.SayHelloListItemHolder();
      paramView = super.a(paramContext, 2131627760, paramViewGroup);
      paramViewGroup.a = ((ImageView)paramView.findViewById(2131445255));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131447063));
      paramViewGroup.i = ((DragTextView)paramView.findViewById(2131449128));
      paramViewGroup.h = ((SingleLineTextView)paramView.findViewById(2131431661));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131447382));
      paramViewGroup.b = ((ImageView)paramView.findViewById(2131449927));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131434144));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131430381));
      paramViewGroup.g = ((TextView)paramView.findViewById(2131450349));
      paramViewGroup.j = ((TextView)paramView.findViewById(2131430528));
      paramViewGroup.k = ((TextView)paramView.findViewById(2131431131));
      paramViewGroup.l = ((LinearLayout)paramView.findViewById(2131445477));
      paramView.setTag(paramViewGroup);
      if (this.f != null) {
        paramViewGroup.i.setOnModeChangeListener(this.f.b());
      }
      paramViewGroup.h.setExtendTextSize(13.0F, 1);
    }
    paramViewGroup.i.setTag(Integer.valueOf(paramInt));
    if ((paramViewGroup != null) && ((paramObject instanceof RecentBaseData)))
    {
      RecentBaseData localRecentBaseData = (RecentBaseData)paramObject;
      if (paramRecentFaceDecoder != null) {
        paramOnDragModeChangedListener = paramRecentFaceDecoder.a(localRecentBaseData);
      }
      a(paramView, localRecentBaseData, paramContext, paramOnDragModeChangedListener);
    }
    else if (paramViewGroup != null)
    {
      paramViewGroup.a.setImageDrawable(null);
      paramViewGroup.d.setText("");
      paramViewGroup.h.setText("");
    }
    super.a(paramContext, paramView, paramInt, paramObject, paramViewGroup, paramOnClickListener);
    paramView.setOnClickListener(paramOnClickListener);
    paramView.setOnLongClickListener(paramOnLongClickListener);
    paramView.setTag(-1, Integer.valueOf(paramInt));
    return paramView;
  }
  
  public List<String> a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    if ((paramRecentBaseData != null) && (paramContext != null))
    {
      paramRecentBaseData = paramContext.getResources();
      paramContext = this.a;
      if (paramContext == null) {
        this.a = new ArrayList();
      } else {
        paramContext.clear();
      }
      this.a.add(paramRecentBaseData.getString(c[0]));
      return this.a;
    }
    return null;
  }
  
  public void a(Context paramContext, SayHelloListItemBuilder.SayHelloListItemHolder paramSayHelloListItemHolder, RecentSayHelloListItem paramRecentSayHelloListItem)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramRecentSayHelloListItem.mTitleName);
    int i = paramRecentSayHelloListItem.gender;
    int k = 1;
    if (i != 1)
    {
      if (i != 2)
      {
        i = 2130841311;
        paramSayHelloListItemHolder.e.setBackgroundDrawable(BizTroopUtil.a(paramSayHelloListItemHolder.e.getResources(), Color.parseColor("#ff9cc4f7")));
        j = 0;
        break label169;
      }
      i = 2130842235;
      paramSayHelloListItemHolder.e.setBackgroundDrawable(BizTroopUtil.a(paramSayHelloListItemHolder.e.getResources(), Color.parseColor("#ffffb4c8")));
      localStringBuilder.append(",");
      localStringBuilder.append("女");
    }
    else
    {
      i = 2130842237;
      paramSayHelloListItemHolder.e.setBackgroundDrawable(BizTroopUtil.a(paramSayHelloListItemHolder.e.getResources(), Color.parseColor("#ff9cc4f7")));
      localStringBuilder.append(",");
      localStringBuilder.append("男");
    }
    int j = 1;
    label169:
    if (paramRecentSayHelloListItem.age > 0)
    {
      paramSayHelloListItemHolder.e.setText(String.valueOf(paramRecentSayHelloListItem.age));
      localStringBuilder.append(paramRecentSayHelloListItem.age);
      localStringBuilder.append("岁");
    }
    else
    {
      paramSayHelloListItemHolder.e.setText("");
    }
    paramSayHelloListItemHolder.e.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    if (j != 0)
    {
      paramSayHelloListItemHolder.e.setVisibility(0);
      i = 1;
    }
    else
    {
      paramSayHelloListItemHolder.e.setVisibility(8);
      i = 0;
    }
    if ((paramRecentSayHelloListItem.career > 0) && (paramRecentSayHelloListItem.career < 14))
    {
      i += 1;
      paramSayHelloListItemHolder.f.setText(com.tencent.mobileqq.util.NearbyProfileUtil.f[paramRecentSayHelloListItem.career]);
      paramSayHelloListItemHolder.f.setBackgroundDrawable(BizTroopUtil.a(paramSayHelloListItemHolder.f.getResources(), Color.parseColor("#ff81d4f3")));
      paramSayHelloListItemHolder.f.setVisibility(0);
      localStringBuilder.append(",");
      localStringBuilder.append(com.tencent.mobileqq.util.NearbyProfileUtil.f[paramRecentSayHelloListItem.career]);
    }
    else
    {
      paramSayHelloListItemHolder.f.setVisibility(8);
    }
    Object localObject = ProfileCardUtil.a((byte)paramRecentSayHelloListItem.constellation);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramSayHelloListItemHolder.g.setVisibility(8);
    }
    else
    {
      i += 1;
      paramSayHelloListItemHolder.g.setText((CharSequence)localObject);
      paramSayHelloListItemHolder.g.setBackgroundResource(2130847209);
      paramSayHelloListItemHolder.g.setVisibility(0);
      localStringBuilder.append(",");
      localStringBuilder.append((String)localObject);
    }
    if (paramRecentSayHelloListItem.vip > 0)
    {
      paramSayHelloListItemHolder.b.setVisibility(0);
      if (paramRecentSayHelloListItem.vip == 1) {
        paramSayHelloListItemHolder.b.setImageResource(2130842241);
      } else {
        paramSayHelloListItemHolder.b.setImageResource(2130842242);
      }
      paramSayHelloListItemHolder.d.setTextColor(paramContext.getResources().getColorStateList(2131168185));
      j = i + 1;
    }
    else
    {
      paramSayHelloListItemHolder.d.setTextColor(paramContext.getResources().getColorStateList(2131168102));
      paramSayHelloListItemHolder.b.setVisibility(8);
      j = i;
    }
    if (paramRecentSayHelloListItem.charmIcon)
    {
      if (paramSayHelloListItemHolder.j.getVisibility() != 0) {
        paramSayHelloListItemHolder.j.setVisibility(0);
      }
      j += 1;
      paramContext = paramSayHelloListItemHolder.j;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("LV");
      ((StringBuilder)localObject).append(paramRecentSayHelloListItem.charmLevel);
      paramContext.setText(((StringBuilder)localObject).toString());
      paramContext = paramSayHelloListItemHolder.j.getContext().getResources().getDrawable(2130847146);
      localObject = ((INearbyFlowerUtil)QRoute.api(INearbyFlowerUtil.class)).getGlamourLevelColors(paramSayHelloListItemHolder.j.getContext());
      int m = Color.parseColor("#FFCC59");
      i = m;
      if (localObject != null)
      {
        i = m;
        if (paramRecentSayHelloListItem.charmLevel < localObject.length) {
          i = localObject[paramRecentSayHelloListItem.charmLevel];
        }
      }
      paramSayHelloListItemHolder.j.setBackgroundDrawable(BizTroopUtil.a(paramSayHelloListItemHolder.j.getContext().getResources(), i, paramContext));
      localStringBuilder.append(",");
      localStringBuilder.append("拥有魅力勋章");
      i = j;
    }
    else
    {
      i = j;
      if (paramSayHelloListItemHolder.j.getVisibility() != 8)
      {
        paramSayHelloListItemHolder.j.setVisibility(8);
        i = j;
      }
    }
    if ((paramRecentSayHelloListItem.commonId > 0) && (!TextUtils.isEmpty(paramRecentSayHelloListItem.common)))
    {
      i += 1;
      paramSayHelloListItemHolder.g.setVisibility(8);
      paramSayHelloListItemHolder.k.setVisibility(0);
      paramSayHelloListItemHolder.k.setText(paramRecentSayHelloListItem.common);
      paramSayHelloListItemHolder.k.setTag(Integer.valueOf(paramRecentSayHelloListItem.commonId));
      localStringBuilder.append(",");
      localStringBuilder.append(paramRecentSayHelloListItem.common);
      j = k;
    }
    else
    {
      j = 0;
    }
    if (j == 0)
    {
      paramSayHelloListItemHolder.k.setVisibility(8);
      paramSayHelloListItemHolder.k.setTag(Integer.valueOf(0));
    }
    if (i > 0) {
      paramSayHelloListItemHolder.l.setVisibility(0);
    } else {
      paramSayHelloListItemHolder.l.setVisibility(4);
    }
    if (AppSetting.e)
    {
      if (paramRecentSayHelloListItem.mUnreadNum > 0)
      {
        localStringBuilder.append(",");
        localStringBuilder.append(paramRecentSayHelloListItem.mUnreadNum);
        localStringBuilder.append("条未读消息");
      }
      localStringBuilder.append(",");
      localStringBuilder.append(paramSayHelloListItemHolder.h.getText().toString());
      localStringBuilder.append(",");
      localStringBuilder.append(paramSayHelloListItemHolder.c.getText().toString());
      if (localStringBuilder.length() > 0) {
        paramRecentSayHelloListItem.mContentDesc = localStringBuilder.toString();
      }
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("talkback|");
        paramContext.append(localStringBuilder.toString());
        QLog.i("Q.recent", 2, paramContext.toString());
      }
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    if ((paramView != null) && (paramRecentBaseData != null))
    {
      Object localObject1 = paramView.getTag();
      SayHelloListItemBuilder.SayHelloListItemHolder localSayHelloListItemHolder;
      if ((localObject1 instanceof SayHelloListItemBuilder.SayHelloListItemHolder)) {
        localSayHelloListItemHolder = (SayHelloListItemBuilder.SayHelloListItemHolder)localObject1;
      } else {
        localSayHelloListItemHolder = null;
      }
      if (localSayHelloListItemHolder == null)
      {
        paramView = new StringBuilder();
        paramView.append("bindView|holder is null, tag = ");
        paramView.append(localObject1);
        QLog.i("Q.recent", 1, paramView.toString());
        return;
      }
      localSayHelloListItemHolder.a.setImageDrawable(paramDrawable);
      if ((paramRecentBaseData instanceof RecentSayHelloListItem))
      {
        RecentSayHelloListItem localRecentSayHelloListItem = (RecentSayHelloListItem)paramRecentBaseData;
        localObject1 = localRecentSayHelloListItem.mTitleName;
        Object localObject3 = localSayHelloListItemHolder.d.getText();
        paramDrawable = (Drawable)localObject1;
        if (localObject1 == null) {
          paramDrawable = "";
        }
        if (!paramDrawable.equals(localObject3)) {
          localSayHelloListItemHolder.d.setText(paramDrawable);
        }
        int i = paramRecentBaseData.mExtraInfoColor;
        paramDrawable = paramRecentBaseData.mMsgExtroInfo;
        if (paramDrawable != null) {
          paramDrawable = paramDrawable.toString();
        } else {
          paramDrawable = "";
        }
        if (!TextUtils.isEmpty(paramDrawable)) {
          localSayHelloListItemHolder.h.setExtendTextColor(ColorStateList.valueOf(i), 1);
        }
        localSayHelloListItemHolder.h.setExtendText(paramDrawable, 1);
        paramDrawable = localRecentSayHelloListItem.mLastMsg;
        localObject1 = localSayHelloListItemHolder.h.getText();
        if (paramDrawable == null) {
          paramDrawable = "";
        }
        if (!paramDrawable.equals(localObject1)) {
          try
          {
            localSayHelloListItemHolder.h.setText(paramDrawable);
            localSayHelloListItemHolder.h.setCompoundDrawables(null, null);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            localObject2 = localSayHelloListItemHolder.h;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(paramDrawable);
            ((StringBuilder)localObject3).append(" ");
            ((SingleLineTextView)localObject2).setText(((StringBuilder)localObject3).toString());
          }
        }
        if (paramRecentBaseData.mStatus == 4) {
          localSayHelloListItemHolder.h.setCompoundDrawables(paramContext.getResources().getDrawable(2130839732), null);
        }
        Object localObject2 = localRecentSayHelloListItem.mShowTime;
        localObject3 = localSayHelloListItemHolder.c.getText();
        paramDrawable = (Drawable)localObject2;
        if (localObject2 == null) {
          paramDrawable = "";
        }
        if (!paramDrawable.equals(localObject3)) {
          localSayHelloListItemHolder.c.setText(paramDrawable);
        }
        int j = localRecentSayHelloListItem.mUnreadNum;
        i = localRecentSayHelloListItem.mUnreadFlag;
        if (j > 0) {
          if (i == 0)
          {
            localSayHelloListItemHolder.i.setDragViewType(-1);
          }
          else
          {
            if (i == 2)
            {
              localSayHelloListItemHolder.i.setDragViewType(-1);
              i = 1;
              break label554;
            }
            if (i == 3)
            {
              boolean bool = paramRecentBaseData instanceof RecentTroopAssistantItem;
              localSayHelloListItemHolder.i.setDragViewType(1);
              localSayHelloListItemHolder.i.setTextColor(paramContext.getResources().getColor(2131168173));
              i = 3;
              k = 2130852596;
              break label560;
            }
            localSayHelloListItemHolder.i.setDragViewType(0);
            localSayHelloListItemHolder.i.setTextColor(paramContext.getResources().getColor(2131168174));
            i = 3;
            k = 2130852592;
            break label560;
          }
        }
        i = 0;
        label554:
        j = 0;
        int k = 0;
        label560:
        CustomWidgetUtil.a(localSayHelloListItemHolder.i, i, j, k, 99, null);
        if (localSayHelloListItemHolder.c.getVisibility() != 0) {
          localSayHelloListItemHolder.c.setVisibility(0);
        }
        a(paramContext, localSayHelloListItemHolder, localRecentSayHelloListItem);
        if (AppSetting.e) {
          paramView.setContentDescription(paramRecentBaseData.mContentDesc);
        }
        a(paramRecentBaseData, paramContext, localSayHelloListItemHolder);
        return;
      }
      QLog.d("SayHelloListItemBuilder", 1, "data is not RecentSayHelloItem");
      throw new RuntimeException("data is null");
    }
    QLog.i("Q.recent", 1, "bindView|param invalidate");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.SayHelloListItemBuilder
 * JD-Core Version:    0.7.0.1
 */