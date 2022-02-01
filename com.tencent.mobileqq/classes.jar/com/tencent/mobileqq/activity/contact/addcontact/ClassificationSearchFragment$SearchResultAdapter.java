package com.tencent.mobileqq.activity.contact.addcontact;

import addcontacts.AccountSearchPb.record;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ThemeImageView;
import java.util.List;

class ClassificationSearchFragment$SearchResultAdapter
  extends BaseAdapter
{
  private List<AccountSearchPb.record> jdField_a_of_type_JavaUtilList;
  
  private ClassificationSearchFragment$SearchResultAdapter(ClassificationSearchFragment paramClassificationSearchFragment) {}
  
  public List<AccountSearchPb.record> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(List<AccountSearchPb.record> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.jdField_a_of_type_Int != 0) {
      i = 1;
    } else {
      i = 0;
    }
    return j + i;
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (((AccountSearchPb.record)this.jdField_a_of_type_JavaUtilList.get(paramInt)).account_id.has()) {
        return 2;
      }
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2) {
          localObject1 = paramView;
        }
      }
      for (;;)
      {
        break;
        localObject1 = (AccountSearchPb.record)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        if (paramView == null)
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a().getLayoutInflater().inflate(2131561417, null);
          localObject2 = new SearchBaseFragment.ArticleItemViewHolder();
          ((SearchBaseFragment.ArticleItemViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368066));
          ((SearchBaseFragment.ArticleItemViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371876));
          ((SearchBaseFragment.ArticleItemViewHolder)localObject2).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378722));
          ((SearchBaseFragment.ArticleItemViewHolder)localObject2).d = ((TextView)paramView.findViewById(2131363075));
          ((SearchBaseFragment.ArticleItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363800));
          ((SearchBaseFragment.ArticleItemViewHolder)localObject2).jdField_a_of_type_Long = ((AccountSearchPb.record)localObject1).account_id.get();
          paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment);
          paramView.setTag(localObject2);
        }
        localObject2 = (SearchBaseFragment.ArticleItemViewHolder)paramView.getTag();
        ((SearchBaseFragment.ArticleItemViewHolder)localObject2).jdField_c_of_type_AndroidWidgetTextView.setText(((AccountSearchPb.record)localObject1).article_create_time.get());
        if ((((AccountSearchPb.record)localObject1).article_author.has()) && (!"".equals(((AccountSearchPb.record)localObject1).article_author.get()))) {
          ((SearchBaseFragment.ArticleItemViewHolder)localObject2).d.setText(((AccountSearchPb.record)localObject1).article_author.get());
        }
        i = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.getResources().getDimensionPixelSize(2131297515);
        if (!TextUtils.isEmpty(((AccountSearchPb.record)localObject1).title_image.get())) {
          try
          {
            URLDrawable localURLDrawable = URLDrawable.getDrawable(((AccountSearchPb.record)localObject1).title_image.get(), i, i);
            ((SearchBaseFragment.ArticleItemViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localURLDrawable);
          }
          catch (Exception localException)
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("classification urldrawable error:");
            ((StringBuilder)localObject4).append(localException.toString());
            QLog.d("ClassificationSearchFragment", 1, ((StringBuilder)localObject4).toString());
          }
        }
        ((SearchBaseFragment.ArticleItemViewHolder)localObject2).jdField_a_of_type_JavaLangString = ((AccountSearchPb.record)localObject1).article_short_url.get();
        if (((AccountSearchPb.record)localObject1).name.has()) {
          ((SearchBaseFragment.ArticleItemViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a(80000003, ((AccountSearchPb.record)localObject1).name.get()));
        }
        if ((((AccountSearchPb.record)localObject1).brief.has()) && (!"".equals(((AccountSearchPb.record)localObject1).brief.get())))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a(((SearchBaseFragment.ArticleItemViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a()) > 1) {
            ((SearchBaseFragment.ArticleItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setMaxLines(1);
          } else {
            ((SearchBaseFragment.ArticleItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setMaxLines(2);
          }
          ((SearchBaseFragment.ArticleItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          ((SearchBaseFragment.ArticleItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a(80000003, ((AccountSearchPb.record)localObject1).brief.get());
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("brief = ");
            ((StringBuilder)localObject4).append(localObject3);
            QLog.d("ClassificationSearchFragment", 2, ((StringBuilder)localObject4).toString());
          }
          ((SearchBaseFragment.ArticleItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
          paramView.setLayoutParams(new AbsListView.LayoutParams(new AbsListView.LayoutParams(-1, AIOUtils.b(110.0F, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a().getResources()))));
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("ClassificationSearchFragment", 2, "brief = gone");
          }
          ((SearchBaseFragment.ArticleItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          paramView.setLayoutParams(new AbsListView.LayoutParams(new AbsListView.LayoutParams(-1, AIOUtils.b(90.0F, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a().getResources()))));
        }
        Object localObject3 = (ImageView)paramView.findViewById(2131381027);
        ((ImageView)localObject3).setVisibility(4);
        Object localObject4 = (ImageView)paramView.findViewById(2131365284);
        ((ImageView)localObject4).setVisibility(4);
        if ((((AccountSearchPb.record)localObject1).video_article.has()) && (((AccountSearchPb.record)localObject1).video_article.get() == 11))
        {
          ((ImageView)localObject3).setVisibility(0);
          ((ImageView)localObject4).getBackground().setAlpha(25);
          ((ImageView)localObject4).setVisibility(0);
        }
        ((SearchBaseFragment.ArticleItemViewHolder)localObject2).jdField_a_of_type_Int = (paramInt + 1);
        localObject1 = paramView;
        break;
        if (paramView == null)
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a().getLayoutInflater().inflate(2131559469, null);
          paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment);
          localObject1 = new ClassificationSearchFragment.MoreViewHolder();
          paramView.setTag(localObject1);
          ((ClassificationSearchFragment.MoreViewHolder)localObject1).jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131376345));
          paramView.findViewById(2131370354).setVisibility(8);
          ((ClassificationSearchFragment.MoreViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371517));
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.b();
        localObject2 = (ClassificationSearchFragment.MoreViewHolder)paramView.getTag();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.jdField_a_of_type_Int == 3)
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.jdField_a_of_type_Boolean = true;
            ((ClassificationSearchFragment.MoreViewHolder)localObject2).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            ((ClassificationSearchFragment.MoreViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131702115));
            localObject1 = paramView;
          }
          else
          {
            localObject1 = paramView;
            if (NetworkUtil.isNetSupport(BaseApplicationImpl.getContext()))
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.jdField_a_of_type_Boolean = false;
              ((ClassificationSearchFragment.MoreViewHolder)localObject2).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
              ((ClassificationSearchFragment.MoreViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131702124));
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment;
              ((ClassificationSearchFragment)localObject1).a(((ClassificationSearchFragment)localObject1).jdField_a_of_type_JavaLangString, true);
              localObject1 = paramView;
            }
          }
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.jdField_a_of_type_Int == 2)
        {
          ((ClassificationSearchFragment.MoreViewHolder)localObject2).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          ((ClassificationSearchFragment.MoreViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131702132));
          localObject1 = paramView;
        }
        else
        {
          localObject1 = paramView;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.jdField_a_of_type_Int == 4)
          {
            ((ClassificationSearchFragment.MoreViewHolder)localObject2).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            ((ClassificationSearchFragment.MoreViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131702128));
            localObject1 = paramView;
          }
        }
      }
    }
    if (paramView == null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a().getLayoutInflater().inflate(2131560887, paramViewGroup, false);
      ((View)localObject1).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment);
      localObject2 = new SearchBaseFragment.ItemViewHolder();
      ((SearchBaseFragment.ItemViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131368066));
      ((SearchBaseFragment.ItemViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131371876));
      ((SearchBaseFragment.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131380152));
      ((SearchBaseFragment.ItemViewHolder)localObject2).jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131365534));
      ((SearchBaseFragment.ItemViewHolder)localObject2).d = ((TextView)((View)localObject1).findViewById(2131370399));
      ((SearchBaseFragment.ItemViewHolder)localObject2).jdField_a_of_type_AddcontactsAccountSearchPb$record = ((AccountSearchPb.record)getItem(paramInt));
      ((SearchBaseFragment.ItemViewHolder)localObject2).jdField_b_of_type_Int = ClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment);
      ((View)localObject1).setTag(2131370666, Integer.valueOf(paramInt));
      ((View)localObject1).setTag(localObject2);
      paramView = (View)localObject1;
      if ((((SearchBaseFragment.ItemViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView instanceof ThemeImageView))
      {
        ((ThemeImageView)((SearchBaseFragment.ItemViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView).setSupportMaskView(false);
        paramView = (View)localObject1;
      }
    }
    Object localObject1 = (SearchBaseFragment.ItemViewHolder)paramView.getTag();
    ((SearchBaseFragment.ItemViewHolder)localObject1).jdField_a_of_type_AddcontactsAccountSearchPb$record = ((AccountSearchPb.record)getItem(paramInt));
    ((SearchBaseFragment.ItemViewHolder)localObject1).jdField_c_of_type_Int = (paramInt + 1);
    Object localObject2 = ClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment, (SearchBaseFragment.ItemViewHolder)localObject1, (AccountSearchPb.record)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    localObject1 = paramView;
    if (AppSetting.d)
    {
      paramView.setContentDescription((CharSequence)localObject2);
      localObject1 = paramView;
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchFragment.SearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */