package com.tencent.mobileqq.activity.contact.addcontact;

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
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.troop.data.NearbyTroops.CustomViewHolder;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import cooperation.qzone.widget.QzoneSearchResultView;
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
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getLayoutInflater().inflate(2131559335, paramViewGroup, false);
    }
    paramView = (TextView)localView.findViewById(2131379432);
    if (UniteSearchActivity.d == 12) {
      if (((SearchContactsFragment.ListItemData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString.equals(HardCodeUtil.a(2131713569)))
      {
        paramView.setText(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getApplication().getApplicationContext()));
        this.jdField_a_of_type_JavaLangString = ((SearchContactsFragment.ListItemData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString;
        if (AppSetting.d)
        {
          localView.setFocusable(true);
          localView.setContentDescription(paramView.getText() + HardCodeUtil.a(2131713575));
        }
        paramView = localView.findViewById(2131365939);
        if (paramInt <= 0) {
          break label222;
        }
        paramView.setVisibility(0);
      }
    }
    label222:
    while (paramInt != 0)
    {
      return localView;
      paramView.setText(((SearchContactsFragment.ListItemData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString);
      break;
      paramView.setText(((SearchContactsFragment.ListItemData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString);
      break;
    }
    paramView.setVisibility(8);
    return localView;
  }
  
  private View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    SearchContactsFragment.ListItemData localListItemData = (SearchContactsFragment.ListItemData)getItem(paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = GroupViewAdapter.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(), paramViewGroup, 5, false, 1);
    }
    paramView = ((SearchContactsFragment.ListItemData)getItem(paramInt)).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
    GroupViewAdapter.a(localView, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(), localListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record);
    paramViewGroup = (NearbyTroops.CustomViewHolder)localView.getTag();
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getResources().getColor(2131167038));
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(80000001, String.valueOf(paramView.name.get())));
    paramViewGroup.jdField_a_of_type_JavaLangString = Long.toString(localListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.code.get());
    paramViewGroup.jdField_c_of_type_Int = 4;
    paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(4, paramViewGroup.jdField_a_of_type_JavaLangString));
    paramViewGroup.jdField_a_of_type_Int = a(paramInt);
    paramViewGroup.jdField_b_of_type_JavaLangString = localListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.bytes_join_group_auth.get().toStringUtf8();
    paramViewGroup.jdField_a_of_type_Boolean = localListItemData.jdField_a_of_type_Boolean;
    localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
    return localView;
  }
  
  private View c(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getLayoutInflater().inflate(2131562707, paramViewGroup, false);
    }
    for (;;)
    {
      if ((paramView instanceof QzoneSearchResultView))
      {
        paramViewGroup = (QzoneSearchResultView)paramView;
        SearchContactsFragment.ListItemData localListItemData = (SearchContactsFragment.ListItemData)getItem(paramInt);
        paramViewGroup.bindData(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment, localListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$ResultItem);
        paramViewGroup.setAvartaView(a(1, paramViewGroup.getUin()));
        paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
      }
      return paramView;
    }
  }
  
  private View d(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getLayoutInflater().inflate(2131561575, null);
      paramView = new SearchBaseFragment.ArticleItemViewHolder();
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131368314));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131372287));
      paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131379371));
      paramView.d = ((TextView)paramViewGroup.findViewById(2131363135));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131363872));
      paramViewGroup.setTag(paramView);
    }
    SearchBaseFragment.ArticleItemViewHolder localArticleItemViewHolder = (SearchBaseFragment.ArticleItemViewHolder)paramViewGroup.getTag();
    paramViewGroup.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
    SearchContactsFragment.ListItemData localListItemData = (SearchContactsFragment.ListItemData)getItem(paramInt);
    if (localListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord != null) {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F29", "0X8006F29", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.jdField_a_of_type_JavaLangString, localListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword.get(), String.valueOf(localListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_type.get()), "");
    }
    for (paramInt = 1;; paramInt = 0)
    {
      String str3 = "";
      String str1;
      String str2;
      Object localObject1;
      Object localObject2;
      if (paramInt != 0)
      {
        str1 = localListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword.get();
        str2 = localListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_description.get();
        localObject1 = localListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_title.get();
        localObject2 = localListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_cover_url.get();
        paramView = localListItemData.jdField_b_of_type_JavaLangString;
        SearchContactsFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment, str1);
        SearchContactsFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment, String.valueOf(localListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_type.get()));
        localArticleItemViewHolder.jdField_b_of_type_JavaLangString = SearchContactsFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
        localArticleItemViewHolder.jdField_c_of_type_JavaLangString = SearchContactsFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(localListItemData.jdField_b_of_type_JavaLangString)) {
          SearchContactsFragment.c(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment, localListItemData.jdField_b_of_type_JavaLangString);
        }
        localArticleItemViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(str3);
        int i = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.getResources().getDimensionPixelSize(2131297524);
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
        try
        {
          localObject2 = URLDrawable.getDrawable((String)localObject2, i, i);
          localArticleItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
          label409:
          localArticleItemViewHolder.jdField_a_of_type_JavaLangString = paramView;
          if (!"".equals(str2)) {
            localArticleItemViewHolder.d.setText(str2);
          }
          paramViewGroup.setTag(localArticleItemViewHolder);
          if (!"".equals(str1)) {
            localArticleItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(80000003, str1));
          }
          if (paramInt == 0) {
            if (!"".equals(localObject1)) {
              if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(localArticleItemViewHolder.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a()) > 1)
              {
                localArticleItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(1);
                label517:
                localArticleItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(80000003, (String)localObject1));
              }
            }
          }
          for (;;)
          {
            paramView = (ImageView)paramViewGroup.findViewById(2131381805);
            paramView.setVisibility(4);
            localObject1 = (ImageView)paramViewGroup.findViewById(2131365419);
            ((ImageView)localObject1).setVisibility(4);
            if ((localListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record != null) && (localListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.video_article.has()) && (localListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.video_article.get() == SearchUtils.jdField_a_of_type_Int))
            {
              paramView.setVisibility(0);
              ((ImageView)localObject1).getBackground().setAlpha(25);
              ((ImageView)localObject1).setVisibility(0);
            }
            paramView = (TextView)paramViewGroup.findViewById(2131368570);
            paramView.setVisibility(4);
            if (paramInt != 0) {
              paramView.setVisibility(0);
            }
            return paramViewGroup;
            str1 = localListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.name.get();
            str2 = localListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.article_author.get();
            localObject1 = localListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.brief.get();
            localObject2 = localListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.title_image.get();
            str3 = localListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.article_create_time.get();
            paramView = localListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.article_short_url.get();
            localArticleItemViewHolder.jdField_a_of_type_Long = localListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.account_id.get();
            localArticleItemViewHolder.jdField_a_of_type_Int = localListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.number.get();
            break;
            localArticleItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(2);
            break label517;
            localArticleItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
            continue;
            if (!"".equals(localObject1))
            {
              localArticleItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(1);
              localArticleItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(80000003, (String)localObject1));
            }
            localArticleItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(AIOUtils.a(190.0F, paramViewGroup.getResources()));
            localArticleItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
            localArticleItemViewHolder.d.setMaxLines(1);
          }
        }
        catch (Exception localException)
        {
          break label409;
        }
      }
    }
  }
  
  private View e(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getLayoutInflater().inflate(2131561023, paramViewGroup, false);
    }
    localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
    paramView = new SearchBaseFragment.ItemViewHolder();
    paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368314));
    paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131372287));
    paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380888));
    paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131365697));
    paramView.d = ((TextView)localView.findViewById(2131370765));
    paramView.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = ((SearchContactsFragment.ListItemData)getItem(paramInt)).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
    paramView.jdField_b_of_type_Int = ((SearchContactsFragment.ListItemData)getItem(paramInt)).jdField_b_of_type_Int;
    localView.setTag(paramView);
    paramView = (SearchBaseFragment.ItemViewHolder)localView.getTag();
    paramView.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = ((SearchContactsFragment.ListItemData)getItem(paramInt)).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
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
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getLayoutInflater().inflate(2131561025, paramViewGroup, false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment$JumpListener == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment$JumpListener = new SearchContactsFragment.JumpListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
    }
    localView.setTag(this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
    localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment$JumpListener);
    if (AppSetting.d) {
      localView.setContentDescription(HardCodeUtil.a(2131713565) + this.jdField_a_of_type_JavaLangString + HardCodeUtil.a(2131713571));
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
    if (((SearchContactsFragment.ListItemData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int == 2) {}
    switch (((SearchContactsFragment.ListItemData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_b_of_type_Int)
    {
    case 80000002: 
    default: 
      return ((SearchContactsFragment.ListItemData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int;
    case 80000001: 
      return 3;
    case 80000003: 
      return 4;
    }
    return 5;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    switch (getItemViewType(paramInt))
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      paramView = a(paramInt, paramView, paramViewGroup);
      continue;
      paramView = b(paramInt, paramView, paramViewGroup);
      continue;
      paramView = c(paramInt, paramView, paramViewGroup);
      continue;
      paramView = d(paramInt, paramView, paramViewGroup);
      continue;
      paramView = e(paramInt, paramView, paramViewGroup);
      continue;
      paramView = f(paramInt, paramView, paramViewGroup);
    }
  }
  
  public int getViewTypeCount()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment.SearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */