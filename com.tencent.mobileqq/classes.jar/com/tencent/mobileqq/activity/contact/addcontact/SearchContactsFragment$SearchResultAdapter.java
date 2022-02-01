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
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<SearchContactsFragment.ListItemData> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean = false;
  
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
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getLayoutInflater().inflate(2131559212, paramViewGroup, false);
    }
    paramView = (TextView)localView.findViewById(2131378784);
    if (UniteSearchActivity.d == 12)
    {
      if (((SearchContactsFragment.ListItemData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString.equals(HardCodeUtil.a(2131713536))) {
        paramView.setText(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getApplication().getApplicationContext()));
      } else {
        paramView.setText(((SearchContactsFragment.ListItemData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString);
      }
    }
    else {
      paramView.setText(((SearchContactsFragment.ListItemData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_JavaLangString = ((SearchContactsFragment.ListItemData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString;
    if (AppSetting.d)
    {
      localView.setFocusable(true);
      paramViewGroup = new StringBuilder();
      paramViewGroup.append(paramView.getText());
      paramViewGroup.append(HardCodeUtil.a(2131713542));
      localView.setContentDescription(paramViewGroup.toString());
    }
    paramView = localView.findViewById(2131365776);
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
      localView = GroupViewAdapter.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(), paramViewGroup, 5, false, 1);
    }
    paramView = ((SearchContactsFragment.ListItemData)getItem(paramInt)).jdField_a_of_type_AddcontactsAccountSearchPb$record;
    GroupViewAdapter.a(localView, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(), localListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$record);
    paramViewGroup = (NearbyTroops.CustomViewHolder)localView.getTag();
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getResources().getColor(2131167061));
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(80000001, String.valueOf(paramView.name.get())));
    paramViewGroup.jdField_a_of_type_JavaLangString = Long.toString(localListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$record.code.get());
    paramViewGroup.jdField_c_of_type_Int = 4;
    paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(4, paramViewGroup.jdField_a_of_type_JavaLangString));
    paramViewGroup.jdField_a_of_type_Int = a(paramInt);
    paramViewGroup.jdField_b_of_type_JavaLangString = localListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$record.bytes_join_group_auth.get().toStringUtf8();
    paramViewGroup.jdField_a_of_type_Boolean = localListItemData.jdField_a_of_type_Boolean;
    localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
    return localView;
  }
  
  private View c(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getLayoutInflater().inflate(2131562518, paramViewGroup, false);
    }
    if ((localView instanceof QzoneSearchResultView))
    {
      paramView = (QzoneSearchResultView)localView;
      paramViewGroup = (SearchContactsFragment.ListItemData)getItem(paramInt);
      paramView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment, paramViewGroup.jdField_a_of_type_AddcontactsAccountSearchPb$ResultItem);
      paramView.setAvartaView(a(1, paramView.a()));
      localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
    }
    return localView;
  }
  
  private View d(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getLayoutInflater().inflate(2131561416, null);
      paramViewGroup = new SearchBaseFragment.ArticleItemViewHolder();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368066));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371876));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378722));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131363075));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363800));
      paramView.setTag(paramViewGroup);
    }
    SearchBaseFragment.ArticleItemViewHolder localArticleItemViewHolder = (SearchBaseFragment.ArticleItemViewHolder)paramView.getTag();
    paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
    SearchContactsFragment.ListItemData localListItemData = (SearchContactsFragment.ListItemData)getItem(paramInt);
    if (localListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$hotwordrecord != null)
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F29", "0X8006F29", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.jdField_a_of_type_JavaLangString, localListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$hotwordrecord.hotword.get(), String.valueOf(localListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$hotwordrecord.hotword_type.get()), "");
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
      paramViewGroup = localListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$hotwordrecord.hotword.get();
      localObject1 = localListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$hotwordrecord.hotword_description.get();
      str1 = localListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$hotwordrecord.hotword_title.get();
      localObject2 = localListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$hotwordrecord.hotword_cover_url.get();
      str2 = localListItemData.jdField_b_of_type_JavaLangString;
      SearchContactsFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment, paramViewGroup);
      SearchContactsFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment, String.valueOf(localListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$hotwordrecord.hotword_type.get()));
      localArticleItemViewHolder.jdField_b_of_type_JavaLangString = SearchContactsFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
      localArticleItemViewHolder.jdField_c_of_type_JavaLangString = SearchContactsFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
      str3 = "";
    }
    else
    {
      paramViewGroup = localListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$record.name.get();
      localObject1 = localListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$record.article_author.get();
      str1 = localListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$record.brief.get();
      localObject2 = localListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$record.title_image.get();
      str3 = localListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$record.article_create_time.get();
      str2 = localListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$record.article_short_url.get();
      localArticleItemViewHolder.jdField_a_of_type_Long = localListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$record.account_id.get();
      localArticleItemViewHolder.jdField_a_of_type_Int = localListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$record.number.get();
    }
    if (!TextUtils.isEmpty(localListItemData.jdField_b_of_type_JavaLangString)) {
      SearchContactsFragment.c(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment, localListItemData.jdField_b_of_type_JavaLangString);
    }
    localArticleItemViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(str3);
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.getResources().getDimensionPixelSize(2131297515);
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
    try
    {
      localObject2 = URLDrawable.getDrawable((String)localObject2, i, i);
      localArticleItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
    }
    catch (Exception localException)
    {
      label529:
      break label529;
    }
    localArticleItemViewHolder.jdField_a_of_type_JavaLangString = str2;
    if (!"".equals(localObject1)) {
      localArticleItemViewHolder.d.setText((CharSequence)localObject1);
    }
    paramView.setTag(localArticleItemViewHolder);
    if (!"".equals(paramViewGroup)) {
      localArticleItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(80000003, paramViewGroup));
    }
    if (paramInt == 0)
    {
      if (!"".equals(str1))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(localArticleItemViewHolder.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a()) > 1) {
          localArticleItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(1);
        } else {
          localArticleItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(2);
        }
        localArticleItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(80000003, str1));
      }
      else
      {
        localArticleItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    else
    {
      if (!"".equals(str1))
      {
        localArticleItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(1);
        localArticleItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(80000003, str1));
      }
      localArticleItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(AIOUtils.b(190.0F, paramView.getResources()));
      localArticleItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
      localArticleItemViewHolder.d.setMaxLines(1);
    }
    paramViewGroup = (ImageView)paramView.findViewById(2131381027);
    paramViewGroup.setVisibility(4);
    Object localObject1 = (ImageView)paramView.findViewById(2131365284);
    ((ImageView)localObject1).setVisibility(4);
    if ((localListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$record != null) && (localListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$record.video_article.has()) && (localListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$record.video_article.get() == SearchUtils.jdField_a_of_type_Int))
    {
      paramViewGroup.setVisibility(0);
      ((ImageView)localObject1).getBackground().setAlpha(25);
      ((ImageView)localObject1).setVisibility(0);
    }
    paramViewGroup = (TextView)paramView.findViewById(2131368313);
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
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getLayoutInflater().inflate(2131560887, paramViewGroup, false);
    }
    localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
    paramView = new SearchBaseFragment.ItemViewHolder();
    paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368066));
    paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371876));
    paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380152));
    paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131365534));
    paramView.d = ((TextView)localView.findViewById(2131370399));
    paramView.jdField_a_of_type_AddcontactsAccountSearchPb$record = ((SearchContactsFragment.ListItemData)getItem(paramInt)).jdField_a_of_type_AddcontactsAccountSearchPb$record;
    paramView.jdField_b_of_type_Int = ((SearchContactsFragment.ListItemData)getItem(paramInt)).jdField_b_of_type_Int;
    localView.setTag(paramView);
    paramView = (SearchBaseFragment.ItemViewHolder)localView.getTag();
    paramView.jdField_a_of_type_AddcontactsAccountSearchPb$record = ((SearchContactsFragment.ListItemData)getItem(paramInt)).jdField_a_of_type_AddcontactsAccountSearchPb$record;
    paramView.jdField_b_of_type_Int = ((SearchContactsFragment.ListItemData)getItem(paramInt)).jdField_b_of_type_Int;
    paramView.jdField_c_of_type_Int = a(paramInt);
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(paramView, (SearchContactsFragment.ListItemData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
    if (AppSetting.d) {
      localView.setContentDescription(paramView);
    }
    return localView;
  }
  
  private View f(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getLayoutInflater().inflate(2131560889, paramViewGroup, false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment$JumpListener == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment;
      paramView.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment$JumpListener = new SearchContactsFragment.JumpListener(paramView);
    }
    localView.setTag(this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
    localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment$JumpListener);
    if (AppSetting.d)
    {
      paramView = new StringBuilder();
      paramView.append(HardCodeUtil.a(2131713532));
      paramView.append(this.jdField_a_of_type_JavaLangString);
      paramView.append(HardCodeUtil.a(2131713538));
      localView.setContentDescription(paramView.toString());
    }
    return localView;
  }
  
  public void a(ArrayList<SearchContactsFragment.ListItemData> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    SearchContactsFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment).clear();
    int i = 0;
    int k;
    for (int j = 0; i < this.jdField_a_of_type_JavaUtilArrayList.size(); j = k)
    {
      k = j;
      if (((SearchContactsFragment.ListItemData)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int == 0)
      {
        paramArrayList = SearchContactsFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
        int m = ((SearchContactsFragment.ListItemData)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_b_of_type_Int;
        k = j + 1;
        paramArrayList.put(Integer.valueOf(m), Integer.valueOf(k));
      }
      i += 1;
    }
  }
  
  public int getCount()
  {
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
  
  public int getItemViewType(int paramInt)
  {
    if (((SearchContactsFragment.ListItemData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int == 2) {
      switch (((SearchContactsFragment.ListItemData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_b_of_type_Int)
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
    return ((SearchContactsFragment.ListItemData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment.SearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */