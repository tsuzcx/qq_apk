package com.tencent.av.wtogether.adapter;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.av.wtogether.view.ChildPressEffectRelativeLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.search.ContactSearchableFriend;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchItemData;
import com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchManager;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.ArrayList;
import java.util.UUID;

class GroupFileSearchExpandableListAdapter$ViewHolder
{
  public View a;
  public ChildPressEffectRelativeLayout b;
  public AsyncImageView c;
  public EllipsizingTextView d;
  public TextView e;
  public TextView f;
  public CheckBox g;
  
  public GroupFileSearchExpandableListAdapter$ViewHolder(GroupFileSearchExpandableListAdapter paramGroupFileSearchExpandableListAdapter, View paramView, View.OnClickListener paramOnClickListener)
  {
    this.b = ((ChildPressEffectRelativeLayout)paramView.findViewById(2013331475));
    this.b.setOnClickListener(paramOnClickListener);
    this.a = paramView;
    this.c = ((AsyncImageView)paramView.findViewById(2013331478));
    this.d = ((EllipsizingTextView)paramView.findViewById(2013331479));
    this.d.setMaxLines(2);
    this.e = ((TextView)paramView.findViewById(2013331477));
    this.f = ((TextView)paramView.findViewById(2013331480));
    this.f.setOnClickListener(paramOnClickListener);
    this.g = ((CheckBox)paramView.findViewById(2013331461));
    this.g.setVisibility(0);
  }
  
  public void a(TroopFileSearchItemData paramTroopFileSearchItemData, int paramInt, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramTroopFileSearchItemData.b))
    {
      this.f.setText(paramTroopFileSearchItemData.b);
      this.f.setVisibility(0);
    }
    else
    {
      this.f.setVisibility(8);
    }
    if (paramInt == 0) {
      this.f.setVisibility(8);
    } else {
      this.f.setTag(2131441532, paramTroopFileSearchItemData);
    }
    this.b.setTag(2131441532, paramTroopFileSearchItemData);
    TroopFileInfo localTroopFileInfo = paramTroopFileSearchItemData.i;
    Object localObject1 = (TroopManager)this.h.d.getManager(QQManagerFactory.TROOP_MANAGER);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramTroopFileSearchItemData.a);
    ((StringBuilder)localObject2).append("");
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(paramTroopFileSearchItemData.c);
    ((StringBuilder)localObject3).append("");
    localObject1 = ((TroopManager)localObject1).g((String)localObject2, ((StringBuilder)localObject3).toString());
    if (localObject1 != null)
    {
      localObject2 = ((TroopMemberInfo)localObject1).troopnick;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramTroopFileSearchItemData.f);
      ((StringBuilder)localObject3).append("");
      if (ContactUtils.a((String)localObject2, ((StringBuilder)localObject3).toString()))
      {
        paramInt = 1;
        break label235;
      }
    }
    paramInt = 0;
    label235:
    if (paramInt != 0) {
      localObject2 = ((TroopMemberInfo)localObject1).troopnick;
    } else {
      localObject2 = null;
    }
    if (paramTroopFileSearchItemData.f > 0L)
    {
      localObject3 = String.valueOf(paramTroopFileSearchItemData.f);
      localObject4 = TroopFileSearchManager.a();
      localObject1 = ((TroopFileSearchManager)localObject4).a((String)localObject3);
      if (localObject1 != null)
      {
        paramInt = TroopFileSearchManager.a(this.h.j, (String)localObject2, paramTroopFileSearchItemData.g, ((ContactSearchableFriend)localObject1).c, ((ContactSearchableFriend)localObject1).d, paramTroopFileSearchItemData.h, ((ContactSearchableFriend)localObject1).a, ((ContactSearchableFriend)localObject1).b);
        localObject2 = TroopFileSearchManager.a((String)localObject2, paramTroopFileSearchItemData.g, paramTroopFileSearchItemData.h, paramInt);
      }
      else
      {
        paramInt = TroopFileSearchManager.a(this.h.j, (String)localObject2, paramTroopFileSearchItemData.g, null, null, paramTroopFileSearchItemData.h, null, null);
        localObject2 = TroopFileSearchManager.a((String)localObject2, paramTroopFileSearchItemData.g, paramTroopFileSearchItemData.h, paramInt);
      }
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        if (TextUtils.isEmpty(paramTroopFileSearchItemData.g)) {
          localObject1 = paramTroopFileSearchItemData.h;
        } else {
          localObject1 = paramTroopFileSearchItemData.g;
        }
      }
      do
      {
        localObject3 = "";
        localObject2 = localObject1;
        localObject1 = localObject3;
        break label510;
        if ((paramInt == 1) || (paramInt == 4) || (paramInt == 7)) {
          break label501;
        }
        if ((paramInt == 5) || (paramInt == 6) || (paramInt == 2)) {
          break;
        }
        localObject1 = localObject2;
      } while (paramInt != 3);
      localObject1 = ((TroopFileSearchManager)localObject4).a(this.h.j, (String)localObject3);
    }
    label501:
    for (localObject1 = this.h.j;; localObject1 = "") {
      label510:
      do
      {
        break label587;
        if (paramInt == 0) {
          localObject2 = paramTroopFileSearchItemData.d;
        }
        if ((paramTroopFileSearchItemData.e == null) || (paramTroopFileSearchItemData.e.size() <= 0)) {
          break;
        }
        localObject1 = (String)paramTroopFileSearchItemData.e.get(0);
      } while ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).toLowerCase().contains(((String)localObject1).toLowerCase())));
    }
    label587:
    if ((paramTroopFileSearchItemData.e != null) && (paramTroopFileSearchItemData.e.size() > 0))
    {
      localObject3 = (String)paramTroopFileSearchItemData.e.get(0);
      if ((!TextUtils.isEmpty(localTroopFileInfo.d)) && (localTroopFileInfo.d.toLowerCase().contains(((String)localObject3).toLowerCase()))) {}
    }
    else
    {
      localObject3 = "";
    }
    GroupFileSearchExpandableListAdapter.a(this.h, this.d, localTroopFileInfo, (String)localObject3);
    localObject3 = localTroopFileInfo.a();
    Object localObject4 = localTroopFileInfo.E;
    GroupFileSearchExpandableListAdapter.a(this.h, paramBoolean, localTroopFileInfo, this.c, paramTroopFileSearchItemData);
    paramTroopFileSearchItemData = GroupFileSearchExpandableListAdapter.a(this.h, (String)localObject4, (String)localObject1, this.e, (String)localObject2, (String)localObject3);
    this.e.setText(paramTroopFileSearchItemData);
    paramTroopFileSearchItemData = new StringBuilder();
    paramTroopFileSearchItemData.append(this.d.getText());
    paramTroopFileSearchItemData.append(",");
    paramTroopFileSearchItemData.append((String)localObject3);
    paramTroopFileSearchItemData.append(",");
    paramTroopFileSearchItemData.append("来自");
    paramTroopFileSearchItemData.append(",");
    paramTroopFileSearchItemData.append((String)localObject2);
    paramTroopFileSearchItemData.append(",");
    paramTroopFileSearchItemData.append((String)localObject4);
    this.a.setContentDescription(paramTroopFileSearchItemData.toString());
    this.g.setChecked(localTroopFileInfo.b.equals(GroupFileSearchExpandableListAdapter.a(this.h)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.adapter.GroupFileSearchExpandableListAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */