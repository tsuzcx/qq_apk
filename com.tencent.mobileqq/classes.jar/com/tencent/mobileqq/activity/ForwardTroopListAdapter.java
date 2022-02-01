package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contacts.friend.SimpleTextView;
import com.tencent.mobileqq.activity.selectmember.TroopListBaseAdapter;
import com.tencent.mobileqq.activity.selectmember.TroopListBaseAdapter.ItemInfo;
import com.tencent.mobileqq.adapter.FacePreloadHolder.ViewHolder;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.troop.adapter.contact.GroupTag;
import com.tencent.mobileqq.troop.api.IDiscussionService;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.ExpandableListView.OnGroupClickListener;
import com.tencent.widget.SingleLineTextView;
import java.util.HashSet;
import java.util.List;

public class ForwardTroopListAdapter
  extends TroopListBaseAdapter
  implements ExpandableListView.OnGroupClickListener
{
  private ForwardTroopListAdapter.IForwardTroopListAdapterCallback o;
  private View.OnClickListener p = new ForwardTroopListAdapter.1(this);
  private View.OnClickListener q = new ForwardTroopListAdapter.2(this);
  
  public ForwardTroopListAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView, ForwardTroopListAdapter.IForwardTroopListAdapterCallback paramIForwardTroopListAdapterCallback)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView);
    this.o = paramIForwardTroopListAdapterCallback;
  }
  
  private void a(GroupTag paramGroupTag)
  {
    int i;
    if (this.d.size() == 1) {
      i = 0;
    } else {
      i = paramGroupTag.a;
    }
    if (this.n.isGroupExpanded(i))
    {
      this.n.collapseGroup(i);
      this.k.remove(this.d.get(i));
      return;
    }
    this.n.expandGroup(i);
    this.k.add(this.d.get(i));
  }
  
  private void a(GroupTag paramGroupTag, int paramInt, boolean paramBoolean)
  {
    if (paramGroupTag != null)
    {
      if ((paramInt >= 0) && (paramInt < this.d.size()))
      {
        i = ((Integer)this.d.get(paramInt)).intValue();
        if (i != 0)
        {
          if (i != 2)
          {
            if (i != 4)
            {
              if (i != 6)
              {
                if (i != 8)
                {
                  if (i == 13)
                  {
                    str = HardCodeUtil.a(2131902835);
                    i = this.j.size();
                    break label213;
                  }
                }
                else
                {
                  str = HardCodeUtil.a(2131902841);
                  i = this.i.size();
                  break label213;
                }
              }
              else
              {
                str = HardCodeUtil.a(2131902839);
                i = this.g.size();
                break label213;
              }
            }
            else
            {
              str = HardCodeUtil.a(2131902834);
              i = this.f.size();
              break label213;
            }
          }
          else
          {
            str = HardCodeUtil.a(2131902844);
            i = this.h.size();
            break label213;
          }
        }
        else
        {
          str = HardCodeUtil.a(2131902838);
          i = this.e.size();
          break label213;
        }
      }
      String str = "";
      int i = 0;
      label213:
      StringBuilder localStringBuilder1 = paramGroupTag.g;
      if (AppSetting.e)
      {
        if (localStringBuilder1 == null) {
          localStringBuilder1 = new StringBuilder(24);
        } else {
          localStringBuilder1.delete(0, localStringBuilder1.length());
        }
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(str);
        localStringBuilder2.append(" 分组");
        localStringBuilder1.append(localStringBuilder2.toString());
      }
      paramGroupTag.a = paramInt;
      paramGroupTag.d.setText(str);
      paramGroupTag.e.setVisibility(8);
      paramGroupTag.c.setVisibility(8);
      paramGroupTag.f.setText(String.valueOf(i));
      paramGroupTag.b.setVisibility(0);
      paramGroupTag.b.setChecked(paramBoolean);
    }
  }
  
  public void configHeaderView(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    if (this.d.size() == 1) {
      return;
    }
    Object localObject;
    if (!(paramView.getTag() instanceof GroupTag))
    {
      localObject = new GroupTag();
      ((GroupTag)localObject).b = ((CheckBox)paramView.findViewById(2131436369));
      ((GroupTag)localObject).d = ((SingleLineTextView)paramView.findViewById(2131434435));
      ((GroupTag)localObject).d.setDefaultTextColor(-8355712);
      ((GroupTag)localObject).e = ((SingleLineTextView)paramView.findViewById(2131448697));
      ((GroupTag)localObject).f = ((SimpleTextView)paramView.findViewById(2131431254));
      ((GroupTag)localObject).f.setDefaultTextColor(1711276032);
      ((GroupTag)localObject).c = ((ProgressBar)paramView.findViewById(2131436506));
      paramView.setTag(localObject);
      paramView = (View)localObject;
    }
    else
    {
      paramView = (GroupTag)paramView.getTag();
    }
    if (ThemeUtil.isNowThemeIsDefaultCache(this.a, false))
    {
      paramView.f.setTextColor(-5196865);
    }
    else
    {
      localObject = this.b.getResources().getColorStateList(2131168122);
      paramView.f.setTextColor((ColorStateList)localObject);
    }
    a(paramView, paramInt, this.n.isGroupExpanded(paramInt));
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = new ForwardRecentItemView(this.b);
      paramViewGroup = new FacePreloadHolder.ViewHolder();
      paramView.setTag(paramViewGroup);
    }
    else
    {
      localObject1 = (ForwardRecentItemView)paramView;
      paramViewGroup = (FacePreloadHolder.ViewHolder)paramView.getTag();
      paramView = (View)localObject1;
    }
    paramViewGroup.A = paramView.d;
    Object localObject2 = paramView.k;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ResultRecord();
    }
    localObject2 = a(paramInt1, paramInt2);
    if ((localObject2 != null) && (((TroopListBaseAdapter.ItemInfo)localObject2).a != null))
    {
      if ((((TroopListBaseAdapter.ItemInfo)localObject2).a instanceof TroopInfo))
      {
        TroopInfo localTroopInfo = (TroopInfo)((TroopListBaseAdapter.ItemInfo)localObject2).a;
        paramViewGroup.y = localTroopInfo.troopuin;
        paramViewGroup.z = 4;
        if (!TextUtils.isEmpty(localTroopInfo.getTroopDisplayName())) {
          localObject2 = localTroopInfo.getTroopDisplayName();
        } else {
          localObject2 = localTroopInfo.troopuin;
        }
        ((ResultRecord)localObject1).init(localTroopInfo.troopuin, (String)localObject2, 1, "", "");
        paramBoolean = this.o.a(localTroopInfo.troopuin, 1);
        paramView.a((String)localObject2, String.valueOf(localTroopInfo.wMemberNumClient), null, (ResultRecord)localObject1, true, paramBoolean);
        a(paramViewGroup, null);
        paramView.setOnClickListener(this.q);
        return paramView;
      }
      if ((((TroopListBaseAdapter.ItemInfo)localObject2).a instanceof DiscussionInfo))
      {
        localObject2 = (DiscussionInfo)((TroopListBaseAdapter.ItemInfo)localObject2).a;
        paramViewGroup.y = ((DiscussionInfo)localObject2).uin;
        paramViewGroup.z = 101;
        ((ResultRecord)localObject1).init(((DiscussionInfo)localObject2).uin, ((DiscussionInfo)localObject2).discussionName, 3000, "", "");
        paramBoolean = this.o.a(((DiscussionInfo)localObject2).uin, 3000);
        paramInt1 = ((IDiscussionService)this.a.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberNum(((DiscussionInfo)localObject2).uin);
        paramView.a(((DiscussionInfo)localObject2).discussionName, String.valueOf(paramInt1), null, (ResultRecord)localObject1, true, paramBoolean);
        a(paramViewGroup, null);
        paramView.setOnClickListener(this.q);
        return paramView;
      }
      if (QLog.isColorLevel())
      {
        paramViewGroup = new StringBuilder();
        paramViewGroup.append("getChildView data:");
        paramViewGroup.append(((TroopListBaseAdapter.ItemInfo)localObject2).a);
        paramViewGroup.append(" groupPosition:");
        paramViewGroup.append(paramInt1);
        paramViewGroup.append(" childPosition:");
        paramViewGroup.append(paramInt2);
        QLog.d("ContactsTroopAdapter", 2, paramViewGroup.toString());
        return paramView;
      }
    }
    else if (QLog.isColorLevel())
    {
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("getChildView itemInfo data null");
      paramViewGroup.append(paramInt1);
      paramViewGroup.append(" childPosition:");
      paramViewGroup.append(paramInt2);
      QLog.d("ContactsTroopAdapter", 2, paramViewGroup.toString());
    }
    return paramView;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.b).inflate(2131624548, paramViewGroup, false);
      paramViewGroup = new GroupTag();
      paramViewGroup.d = ((SingleLineTextView)paramView.findViewById(2131434435));
      paramViewGroup.d.setDefaultTextColor(-8355712);
      paramViewGroup.b = ((CheckBox)paramView.findViewById(2131436369));
      paramViewGroup.f = ((SimpleTextView)paramView.findViewById(2131431254));
      paramViewGroup.f.setDefaultTextColor(1711276032);
      paramViewGroup.c = ((ProgressBar)paramView.findViewById(2131436506));
      paramViewGroup.e = ((SingleLineTextView)paramView.findViewById(2131448697));
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (GroupTag)paramView.getTag();
    }
    if (this.d.size() == 1)
    {
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
      return paramView;
    }
    paramView.setLayoutParams(new AbsListView.LayoutParams(-1, this.l));
    if (ThemeUtil.isNowThemeIsDefaultCache(this.a, false))
    {
      paramViewGroup.f.setTextColor(-5196865);
    }
    else
    {
      ColorStateList localColorStateList = this.b.getResources().getColorStateList(2131168122);
      paramViewGroup.f.setTextColor(localColorStateList);
    }
    a(paramViewGroup, paramInt, paramBoolean);
    paramView.setOnClickListener(this.p);
    return paramView;
  }
  
  public int getHeaderViewLayoutResourceId()
  {
    return 2131624548;
  }
  
  public boolean needHideBackgroundGroup()
  {
    return true;
  }
  
  public boolean onGroupClick(ExpandableListView paramExpandableListView, View paramView, int paramInt, long paramLong)
  {
    paramExpandableListView = paramView.getTag();
    if ((paramExpandableListView instanceof GroupTag)) {
      a((GroupTag)paramExpandableListView);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardTroopListAdapter
 * JD-Core Version:    0.7.0.1
 */