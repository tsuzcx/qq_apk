package com.tencent.mobileqq.activity.contact.addcontact;

import addcontacts.AccountSearchPb.hotwordrecord;
import addcontacts.AccountSearchPb.record;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.addContactTroopView.GroupViewAdapter;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.troop.data.NearbyTroops.CustomViewHolder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Map;

class SearchContactsFragment$SearchResultAdapter
  extends FacePreloadBaseAdapter
{
  private ArrayList<SearchContactsFragment.ListItemData> b;
  private String c = "";
  private boolean d = false;
  
  public SearchContactsFragment$SearchResultAdapter(SearchContactsFragment paramSearchContactsFragment, Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramListView, paramInt, paramBoolean);
  }
  
  private int a(int paramInt)
  {
    if (paramInt >= 1)
    {
      if (getItemViewType(paramInt - 1) == 0) {
        return 1;
      }
      if ((paramInt >= 2) && (getItemViewType(paramInt - 2) == 0)) {
        return 2;
      }
    }
    return 3;
  }
  
  private View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = this.a.o().getLayoutInflater().inflate(2131624969, paramViewGroup, false);
    }
    paramView = (TextView)localView.findViewById(2131447463);
    if (UniteSearchActivity.f == 12)
    {
      if (((SearchContactsFragment.ListItemData)this.b.get(paramInt)).e.equals(HardCodeUtil.a(2131911082))) {
        paramView.setText(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.a.r, BaseApplicationImpl.getApplication().getApplicationContext()));
      } else {
        paramView.setText(((SearchContactsFragment.ListItemData)this.b.get(paramInt)).e);
      }
    }
    else {
      paramView.setText(((SearchContactsFragment.ListItemData)this.b.get(paramInt)).e);
    }
    this.c = ((SearchContactsFragment.ListItemData)this.b.get(paramInt)).e;
    if (AppSetting.e)
    {
      localView.setFocusable(true);
      paramViewGroup = new StringBuilder();
      paramViewGroup.append(paramView.getText());
      paramViewGroup.append(HardCodeUtil.a(2131911088));
      localView.setContentDescription(paramViewGroup.toString());
    }
    paramView = localView.findViewById(2131432033);
    if (paramInt > 0)
    {
      paramView.setVisibility(0);
      return localView;
    }
    if (paramInt == 0) {
      paramView.setVisibility(8);
    }
    return localView;
  }
  
  private View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    SearchContactsFragment.ListItemData localListItemData = (SearchContactsFragment.ListItemData)getItem(paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = GroupViewAdapter.b(this.a.o(), paramViewGroup, 5, false, 1);
    }
    paramView = ((SearchContactsFragment.ListItemData)getItem(paramInt)).a;
    GroupViewAdapter.a(localView, this.a.o(), localListItemData.a);
    paramViewGroup = (NearbyTroops.CustomViewHolder)localView.getTag();
    paramViewGroup.a.setTextColor(this.a.o().getResources().getColor(2131167999));
    paramViewGroup.a.setText(this.a.a(80000001, String.valueOf(paramView.name.get())));
    paramViewGroup.y = Long.toString(localListItemData.a.code.get());
    paramViewGroup.z = 4;
    paramViewGroup.A.setImageBitmap(a(4, paramViewGroup.y));
    paramViewGroup.h = a(paramInt);
    paramViewGroup.j = localListItemData.a.bytes_join_group_auth.get().toStringUtf8();
    paramViewGroup.k = localListItemData.j;
    localView.setOnClickListener(this.a);
    return localView;
  }
  
  private View c(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = this.a.o().getLayoutInflater().inflate(2131628949, paramViewGroup, false);
    }
    if ((localView instanceof QzoneSearchResultView))
    {
      paramView = (QzoneSearchResultView)localView;
      paramViewGroup = (SearchContactsFragment.ListItemData)getItem(paramInt);
      paramView.a(this.a.r, this.a, paramViewGroup.h);
      paramView.setAvartaView(a(1, paramView.getUin()));
      localView.setOnClickListener(this.a);
    }
    return localView;
  }
  
  private View d(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.a.o().getLayoutInflater().inflate(2131627772, null);
      paramViewGroup = new SearchBaseFragment.ArticleItemViewHolder();
      paramViewGroup.a = ((ImageView)paramView.findViewById(2131434916));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131439319));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131447381));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131428910));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131429733));
      paramView.setTag(paramViewGroup);
    }
    SearchBaseFragment.ArticleItemViewHolder localArticleItemViewHolder = (SearchBaseFragment.ArticleItemViewHolder)paramView.getTag();
    paramView.setOnClickListener(this.a);
    SearchContactsFragment.ListItemData localListItemData = (SearchContactsFragment.ListItemData)getItem(paramInt);
    if (localListItemData.b != null)
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F29", "0X8006F29", 0, 0, this.a.e, localListItemData.b.hotword.get(), String.valueOf(localListItemData.b.hotword_type.get()), "");
      paramInt = 1;
    }
    else
    {
      paramInt = 0;
    }
    String str1;
    Object localObject2;
    String str2;
    String str3;
    if (paramInt != 0)
    {
      paramViewGroup = localListItemData.b.hotword.get();
      localObject1 = localListItemData.b.hotword_description.get();
      str1 = localListItemData.b.hotword_title.get();
      localObject2 = localListItemData.b.hotword_cover_url.get();
      str2 = localListItemData.g;
      SearchContactsFragment.a(this.a, paramViewGroup);
      SearchContactsFragment.b(this.a, String.valueOf(localListItemData.b.hotword_type.get()));
      localArticleItemViewHolder.i = SearchContactsFragment.b(this.a);
      localArticleItemViewHolder.j = SearchContactsFragment.c(this.a);
      str3 = "";
    }
    else
    {
      paramViewGroup = localListItemData.a.name.get();
      localObject1 = localListItemData.a.article_author.get();
      str1 = localListItemData.a.brief.get();
      localObject2 = localListItemData.a.title_image.get();
      str3 = localListItemData.a.article_create_time.get();
      str2 = localListItemData.a.article_short_url.get();
      localArticleItemViewHolder.h = localListItemData.a.account_id.get();
      localArticleItemViewHolder.g = localListItemData.a.number.get();
    }
    if (!TextUtils.isEmpty(localListItemData.g)) {
      SearchContactsFragment.c(this.a, localListItemData.g);
    }
    localArticleItemViewHolder.d.setText(str3);
    int i = this.a.getResources().getDimensionPixelSize(2131298168);
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
    try
    {
      localObject2 = URLDrawable.getDrawable((String)localObject2, i, i);
      localArticleItemViewHolder.a.setImageDrawable((Drawable)localObject2);
    }
    catch (Exception localException)
    {
      label529:
      break label529;
    }
    localArticleItemViewHolder.f = str2;
    if (!"".equals(localObject1)) {
      localArticleItemViewHolder.e.setText((CharSequence)localObject1);
    }
    paramView.setTag(localArticleItemViewHolder);
    if (!"".equals(paramViewGroup)) {
      localArticleItemViewHolder.b.setText(this.a.a(80000003, paramViewGroup));
    }
    if (paramInt == 0)
    {
      if (!"".equals(str1))
      {
        if (this.a.a(localArticleItemViewHolder.b, this.a.o()) > 1) {
          localArticleItemViewHolder.c.setMaxLines(1);
        } else {
          localArticleItemViewHolder.c.setMaxLines(2);
        }
        localArticleItemViewHolder.c.setText(this.a.a(80000003, str1));
      }
      else
      {
        localArticleItemViewHolder.c.setVisibility(8);
      }
    }
    else
    {
      if (!"".equals(str1))
      {
        localArticleItemViewHolder.c.setMaxLines(1);
        localArticleItemViewHolder.c.setText(this.a.a(80000003, str1));
      }
      localArticleItemViewHolder.b.setMaxWidth(AIOUtils.b(190.0F, paramView.getResources()));
      localArticleItemViewHolder.b.setMaxLines(1);
      localArticleItemViewHolder.e.setMaxLines(1);
    }
    paramViewGroup = (ImageView)paramView.findViewById(2131450036);
    paramViewGroup.setVisibility(4);
    Object localObject1 = (ImageView)paramView.findViewById(2131431458);
    ((ImageView)localObject1).setVisibility(4);
    if ((localListItemData.a != null) && (localListItemData.a.video_article.has()) && (localListItemData.a.video_article.get() == SearchUtils.f))
    {
      paramViewGroup.setVisibility(0);
      ((ImageView)localObject1).getBackground().setAlpha(25);
      ((ImageView)localObject1).setVisibility(0);
    }
    paramViewGroup = (TextView)paramView.findViewById(2131435186);
    paramViewGroup.setVisibility(4);
    if (paramInt != 0) {
      paramViewGroup.setVisibility(0);
    }
    return paramView;
  }
  
  private View e(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = this.a.o().getLayoutInflater().inflate(2131627228, paramViewGroup, false);
    }
    localView.setOnClickListener(this.a);
    paramView = new SearchBaseFragment.ItemViewHolder();
    paramView.a = ((ImageView)localView.findViewById(2131434916));
    paramView.b = ((TextView)localView.findViewById(2131439319));
    paramView.c = ((TextView)localView.findViewById(2131449066));
    paramView.d = ((TextView)localView.findViewById(2131431753));
    paramView.e = ((TextView)localView.findViewById(2131437667));
    paramView.k = ((SearchContactsFragment.ListItemData)getItem(paramInt)).a;
    paramView.j = ((SearchContactsFragment.ListItemData)getItem(paramInt)).d;
    localView.setTag(paramView);
    paramView = (SearchBaseFragment.ItemViewHolder)localView.getTag();
    paramView.k = ((SearchContactsFragment.ListItemData)getItem(paramInt)).a;
    paramView.j = ((SearchContactsFragment.ListItemData)getItem(paramInt)).d;
    paramView.m = a(paramInt);
    paramView = this.a.a(paramView, (SearchContactsFragment.ListItemData)this.b.get(paramInt));
    if (AppSetting.e) {
      localView.setContentDescription(paramView);
    }
    return localView;
  }
  
  private View f(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = this.a.o().getLayoutInflater().inflate(2131627230, paramViewGroup, false);
    }
    if (this.a.A == null)
    {
      paramView = this.a;
      paramView.A = new SearchContactsFragment.JumpListener(paramView);
    }
    localView.setTag(this.b.get(paramInt));
    localView.setOnClickListener(this.a.A);
    if (AppSetting.e)
    {
      paramView = new StringBuilder();
      paramView.append(HardCodeUtil.a(2131911078));
      paramView.append(this.c);
      paramView.append(HardCodeUtil.a(2131911084));
      localView.setContentDescription(paramView.toString());
    }
    return localView;
  }
  
  public void a(ArrayList<SearchContactsFragment.ListItemData> paramArrayList)
  {
    this.b = paramArrayList;
    SearchContactsFragment.a(this.a).clear();
    int i = 0;
    int k;
    for (int j = 0; i < this.b.size(); j = k)
    {
      k = j;
      if (((SearchContactsFragment.ListItemData)this.b.get(i)).c == 0)
      {
        paramArrayList = SearchContactsFragment.a(this.a);
        int m = ((SearchContactsFragment.ListItemData)this.b.get(i)).d;
        k = j + 1;
        paramArrayList.put(Integer.valueOf(m), Integer.valueOf(k));
      }
      i += 1;
    }
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (((SearchContactsFragment.ListItemData)this.b.get(paramInt)).c == 2) {
      switch (((SearchContactsFragment.ListItemData)this.b.get(paramInt)).d)
      {
      case 80000002: 
      default: 
        break;
      case 80000004: 
        return 5;
      case 80000003: 
        return 4;
      case 80000001: 
        return 3;
      }
    }
    return ((SearchContactsFragment.ListItemData)this.b.get(paramInt)).c;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i == 5) {
                paramView = c(paramInt, paramView, paramViewGroup);
              }
            }
            else {
              paramView = d(paramInt, paramView, paramViewGroup);
            }
          }
          else {
            paramView = b(paramInt, paramView, paramViewGroup);
          }
        }
        else {
          paramView = e(paramInt, paramView, paramViewGroup);
        }
      }
      else {
        paramView = f(paramInt, paramView, paramViewGroup);
      }
    }
    else {
      paramView = a(paramInt, paramView, paramViewGroup);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment.SearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */