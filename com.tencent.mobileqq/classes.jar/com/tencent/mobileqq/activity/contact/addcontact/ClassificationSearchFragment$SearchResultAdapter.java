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
  private List<AccountSearchPb.record> b;
  
  private ClassificationSearchFragment$SearchResultAdapter(ClassificationSearchFragment paramClassificationSearchFragment) {}
  
  public List<AccountSearchPb.record> a()
  {
    return this.b;
  }
  
  public void a(List<AccountSearchPb.record> paramList)
  {
    this.b = paramList;
  }
  
  public int getCount()
  {
    int j = this.b.size();
    int i;
    if (this.a.a != 0) {
      i = 1;
    } else {
      i = 0;
    }
    return j + i;
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
    if (paramInt < this.b.size())
    {
      if (((AccountSearchPb.record)this.b.get(paramInt)).account_id.has()) {
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
        localObject1 = (AccountSearchPb.record)this.b.get(paramInt);
        if (paramView == null)
        {
          paramView = this.a.o().getLayoutInflater().inflate(2131627773, null);
          localObject2 = new SearchBaseFragment.ArticleItemViewHolder();
          ((SearchBaseFragment.ArticleItemViewHolder)localObject2).a = ((ImageView)paramView.findViewById(2131434916));
          ((SearchBaseFragment.ArticleItemViewHolder)localObject2).b = ((TextView)paramView.findViewById(2131439319));
          ((SearchBaseFragment.ArticleItemViewHolder)localObject2).d = ((TextView)paramView.findViewById(2131447381));
          ((SearchBaseFragment.ArticleItemViewHolder)localObject2).e = ((TextView)paramView.findViewById(2131428910));
          ((SearchBaseFragment.ArticleItemViewHolder)localObject2).c = ((TextView)paramView.findViewById(2131429733));
          ((SearchBaseFragment.ArticleItemViewHolder)localObject2).h = ((AccountSearchPb.record)localObject1).account_id.get();
          paramView.setOnClickListener(this.a);
          paramView.setTag(localObject2);
        }
        localObject2 = (SearchBaseFragment.ArticleItemViewHolder)paramView.getTag();
        ((SearchBaseFragment.ArticleItemViewHolder)localObject2).d.setText(((AccountSearchPb.record)localObject1).article_create_time.get());
        if ((((AccountSearchPb.record)localObject1).article_author.has()) && (!"".equals(((AccountSearchPb.record)localObject1).article_author.get()))) {
          ((SearchBaseFragment.ArticleItemViewHolder)localObject2).e.setText(((AccountSearchPb.record)localObject1).article_author.get());
        }
        i = this.a.getResources().getDimensionPixelSize(2131298168);
        if (!TextUtils.isEmpty(((AccountSearchPb.record)localObject1).title_image.get())) {
          try
          {
            URLDrawable localURLDrawable = URLDrawable.getDrawable(((AccountSearchPb.record)localObject1).title_image.get(), i, i);
            ((SearchBaseFragment.ArticleItemViewHolder)localObject2).a.setImageDrawable(localURLDrawable);
          }
          catch (Exception localException)
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("classification urldrawable error:");
            ((StringBuilder)localObject4).append(localException.toString());
            QLog.d("ClassificationSearchFragment", 1, ((StringBuilder)localObject4).toString());
          }
        }
        ((SearchBaseFragment.ArticleItemViewHolder)localObject2).f = ((AccountSearchPb.record)localObject1).article_short_url.get();
        if (((AccountSearchPb.record)localObject1).name.has()) {
          ((SearchBaseFragment.ArticleItemViewHolder)localObject2).b.setText(this.a.a(80000003, ((AccountSearchPb.record)localObject1).name.get()));
        }
        if ((((AccountSearchPb.record)localObject1).brief.has()) && (!"".equals(((AccountSearchPb.record)localObject1).brief.get())))
        {
          if (this.a.a(((SearchBaseFragment.ArticleItemViewHolder)localObject2).b, this.a.o()) > 1) {
            ((SearchBaseFragment.ArticleItemViewHolder)localObject2).c.setMaxLines(1);
          } else {
            ((SearchBaseFragment.ArticleItemViewHolder)localObject2).c.setMaxLines(2);
          }
          ((SearchBaseFragment.ArticleItemViewHolder)localObject2).c.setVisibility(0);
          ((SearchBaseFragment.ArticleItemViewHolder)localObject2).c.setEllipsize(TextUtils.TruncateAt.END);
          localObject3 = this.a.a(80000003, ((AccountSearchPb.record)localObject1).brief.get());
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("brief = ");
            ((StringBuilder)localObject4).append(localObject3);
            QLog.d("ClassificationSearchFragment", 2, ((StringBuilder)localObject4).toString());
          }
          ((SearchBaseFragment.ArticleItemViewHolder)localObject2).c.setText((CharSequence)localObject3);
          paramView.setLayoutParams(new AbsListView.LayoutParams(new AbsListView.LayoutParams(-1, AIOUtils.b(110.0F, this.a.o().getResources()))));
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("ClassificationSearchFragment", 2, "brief = gone");
          }
          ((SearchBaseFragment.ArticleItemViewHolder)localObject2).c.setVisibility(8);
          paramView.setLayoutParams(new AbsListView.LayoutParams(new AbsListView.LayoutParams(-1, AIOUtils.b(90.0F, this.a.o().getResources()))));
        }
        Object localObject3 = (ImageView)paramView.findViewById(2131450036);
        ((ImageView)localObject3).setVisibility(4);
        Object localObject4 = (ImageView)paramView.findViewById(2131431458);
        ((ImageView)localObject4).setVisibility(4);
        if ((((AccountSearchPb.record)localObject1).video_article.has()) && (((AccountSearchPb.record)localObject1).video_article.get() == 11))
        {
          ((ImageView)localObject3).setVisibility(0);
          ((ImageView)localObject4).getBackground().setAlpha(25);
          ((ImageView)localObject4).setVisibility(0);
        }
        ((SearchBaseFragment.ArticleItemViewHolder)localObject2).g = (paramInt + 1);
        localObject1 = paramView;
        break;
        if (paramView == null)
        {
          paramView = this.a.o().getLayoutInflater().inflate(2131625460, null);
          paramView.setOnClickListener(this.a);
          localObject1 = new ClassificationSearchFragment.MoreViewHolder();
          paramView.setTag(localObject1);
          ((ClassificationSearchFragment.MoreViewHolder)localObject1).a = ((ProgressBar)paramView.findViewById(2131444560));
          paramView.findViewById(2131437616).setVisibility(8);
          ((ClassificationSearchFragment.MoreViewHolder)localObject1).b = ((TextView)paramView.findViewById(2131438894));
        }
        this.a.b();
        localObject2 = (ClassificationSearchFragment.MoreViewHolder)paramView.getTag();
        if (this.a.a == 3)
        {
          if (!this.a.c)
          {
            this.a.c = true;
            ((ClassificationSearchFragment.MoreViewHolder)localObject2).a.setVisibility(8);
            ((ClassificationSearchFragment.MoreViewHolder)localObject2).b.setText(HardCodeUtil.a(2131900123));
            localObject1 = paramView;
          }
          else
          {
            localObject1 = paramView;
            if (NetworkUtil.isNetSupport(BaseApplicationImpl.getContext()))
            {
              this.a.c = false;
              ((ClassificationSearchFragment.MoreViewHolder)localObject2).a.setVisibility(0);
              ((ClassificationSearchFragment.MoreViewHolder)localObject2).b.setText(HardCodeUtil.a(2131900132));
              localObject1 = this.a;
              ((ClassificationSearchFragment)localObject1).a(((ClassificationSearchFragment)localObject1).e, true);
              localObject1 = paramView;
            }
          }
        }
        else if (this.a.a == 2)
        {
          ((ClassificationSearchFragment.MoreViewHolder)localObject2).a.setVisibility(0);
          ((ClassificationSearchFragment.MoreViewHolder)localObject2).b.setText(HardCodeUtil.a(2131900140));
          localObject1 = paramView;
        }
        else
        {
          localObject1 = paramView;
          if (this.a.a == 4)
          {
            ((ClassificationSearchFragment.MoreViewHolder)localObject2).a.setVisibility(8);
            ((ClassificationSearchFragment.MoreViewHolder)localObject2).b.setText(HardCodeUtil.a(2131900136));
            localObject1 = paramView;
          }
        }
      }
    }
    if (paramView == null)
    {
      localObject1 = this.a.o().getLayoutInflater().inflate(2131627228, paramViewGroup, false);
      ((View)localObject1).setOnClickListener(this.a);
      localObject2 = new SearchBaseFragment.ItemViewHolder();
      ((SearchBaseFragment.ItemViewHolder)localObject2).a = ((ImageView)((View)localObject1).findViewById(2131434916));
      ((SearchBaseFragment.ItemViewHolder)localObject2).b = ((TextView)((View)localObject1).findViewById(2131439319));
      ((SearchBaseFragment.ItemViewHolder)localObject2).c = ((TextView)((View)localObject1).findViewById(2131449066));
      ((SearchBaseFragment.ItemViewHolder)localObject2).d = ((TextView)((View)localObject1).findViewById(2131431753));
      ((SearchBaseFragment.ItemViewHolder)localObject2).e = ((TextView)((View)localObject1).findViewById(2131437667));
      ((SearchBaseFragment.ItemViewHolder)localObject2).k = ((AccountSearchPb.record)getItem(paramInt));
      ((SearchBaseFragment.ItemViewHolder)localObject2).j = ClassificationSearchFragment.a(this.a);
      ((View)localObject1).setTag(2131437943, Integer.valueOf(paramInt));
      ((View)localObject1).setTag(localObject2);
      paramView = (View)localObject1;
      if ((((SearchBaseFragment.ItemViewHolder)localObject2).a instanceof ThemeImageView))
      {
        ((ThemeImageView)((SearchBaseFragment.ItemViewHolder)localObject2).a).setSupportMaskView(false);
        paramView = (View)localObject1;
      }
    }
    Object localObject1 = (SearchBaseFragment.ItemViewHolder)paramView.getTag();
    ((SearchBaseFragment.ItemViewHolder)localObject1).k = ((AccountSearchPb.record)getItem(paramInt));
    ((SearchBaseFragment.ItemViewHolder)localObject1).m = (paramInt + 1);
    Object localObject2 = ClassificationSearchFragment.a(this.a, (SearchBaseFragment.ItemViewHolder)localObject1, (AccountSearchPb.record)this.b.get(paramInt));
    localObject1 = paramView;
    if (AppSetting.e)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchFragment.SearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */