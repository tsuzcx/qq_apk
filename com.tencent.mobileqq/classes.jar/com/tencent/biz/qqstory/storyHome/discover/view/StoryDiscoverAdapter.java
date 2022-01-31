package com.tencent.biz.qqstory.storyHome.discover.view;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.HotTopicInfoItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playmode.child.DiscoverPlayMode.PlayVideoEvent;
import com.tencent.biz.qqstory.storyHome.discover.model.CardItem;
import com.tencent.biz.qqstory.storyHome.discover.model.CardItem.ActivityCardInfo;
import com.tencent.biz.qqstory.storyHome.discover.model.CardItem.CardVideoInfo;
import com.tencent.biz.qqstory.storyHome.discover.model.CardItem.NearbyCardInfo;
import com.tencent.biz.qqstory.storyHome.discover.model.CardItem.NormalCardInfo;
import com.tencent.biz.qqstory.storyHome.discover.model.CardItem.OperationCardInfo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.ThumbnailUrlHelper;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.xrecyclerview.RecyclerViewWithHeaderFooter;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import oaz;

public class StoryDiscoverAdapter
  extends RecyclerView.Adapter
{
  private final int jdField_a_of_type_Int;
  private final Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private View jdField_a_of_type_AndroidViewView;
  private HotTopicInfoItem jdField_a_of_type_ComTencentBizQqstoryModelItemHotTopicInfoItem;
  private StoryDiscoverAdapter.OnHolderItemClickListener jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewStoryDiscoverAdapter$OnHolderItemClickListener;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private final int jdField_b_of_type_Int;
  private final Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private SparseIntArray jdField_b_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private final int jdField_c_of_type_Int;
  private final Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  private final int jdField_d_of_type_Int;
  private final Drawable jdField_d_of_type_AndroidGraphicsDrawableDrawable;
  private final int e;
  private final int f;
  private int g = 0;
  private int h = 1;
  
  StoryDiscoverAdapter(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.g = paramInt1;
    this.h = paramInt2;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewStoryDiscoverAdapter$OnHolderItemClickListener = new oaz(this);
    paramInt1 = UIUtils.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getContext(), 5.0F);
    this.jdField_b_of_type_Int = ((ScreenUtil.jdField_a_of_type_Int - paramInt1 * 3) / 2);
    this.jdField_c_of_type_Int = (this.jdField_b_of_type_Int * 17 / 12);
    this.jdField_d_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Int = UIUtils.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getContext(), 34.0F);
    this.e = UIUtils.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getContext(), 4.0F);
    this.f = (this.jdField_b_of_type_Int - this.jdField_a_of_type_Int - UIUtils.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getContext(), 43.0F));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getResources().getDrawable(2130843477);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getMinimumWidth(), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getMinimumHeight());
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getResources().getDrawable(2130843476);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getMinimumWidth(), this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getMinimumHeight());
    this.jdField_d_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getResources().getDrawable(2130843855);
    this.jdField_d_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_d_of_type_AndroidGraphicsDrawableDrawable.getMinimumWidth(), this.jdField_d_of_type_AndroidGraphicsDrawableDrawable.getMinimumHeight());
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getResources().getDrawable(2130843478);
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.getMinimumWidth(), this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.getMinimumHeight());
  }
  
  private String a(long paramLong)
  {
    if (paramLong < 10000L) {
      return String.valueOf(paramLong);
    }
    NumberFormat localNumberFormat = NumberFormat.getInstance();
    localNumberFormat.setMaximumFractionDigits(1);
    localNumberFormat.setMinimumFractionDigits(0);
    if (paramLong < 100000000L) {
      return localNumberFormat.format((float)paramLong / 10000.0F) + "万";
    }
    return localNumberFormat.format((float)paramLong / 1.0E+008F) + "亿";
  }
  
  private void a(int paramInt1, StoryDiscoverAdapter.StoryDiscoverViewHolder paramStoryDiscoverViewHolder, long paramLong, int paramInt2)
  {
    if (((paramInt1 == 1) || (paramInt1 == 3)) && (paramLong == 0L) && (paramInt2 == 0))
    {
      paramStoryDiscoverViewHolder.d.setVisibility(8);
      paramStoryDiscoverViewHolder.e.setVisibility(8);
    }
  }
  
  private void a(ImageView paramImageView, int paramInt, String paramString)
  {
    if (paramImageView == null) {
      SLog.e("Q.qqstory.discover:StoryDiscoverAdapter", "update imageView error. imageView is null.");
    }
    do
    {
      return;
      paramImageView.setVisibility(paramInt);
    } while (paramInt != 0);
    UIUtils.b(paramImageView, ThumbnailUrlHelper.a(paramString), 80, 80, null, "StoryDiscoverHeadImage");
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    if (paramImageView == null)
    {
      SLog.e("Q.qqstory.discover:StoryDiscoverAdapter", "update cover image error. view is null.");
      return;
    }
    int i = paramImageView.getLayoutParams().height;
    if (i == this.jdField_c_of_type_Int) {}
    for (String str = "QQStoryDiscoverCard";; str = "QQStoryDiscoverSmallCard")
    {
      UIUtils.a(paramImageView, paramString, this.jdField_b_of_type_Int / 2, i / 2, this.e / 2, this.jdField_c_of_type_AndroidGraphicsDrawableDrawable, str);
      return;
    }
  }
  
  private void a(TextView paramTextView, int paramInt1, int paramInt2, String paramString)
  {
    if (paramTextView == null)
    {
      SLog.e("Q.qqstory.discover:StoryDiscoverAdapter", "update label error. textView is null.");
      return;
    }
    if ((paramInt1 != 0) || (TextUtils.isEmpty(paramString)))
    {
      paramTextView.setVisibility(8);
      return;
    }
    paramTextView.setVisibility(paramInt1);
    paramTextView.setText(paramString);
    paramTextView.setBackgroundResource(paramInt2);
  }
  
  private void a(TextView paramTextView, int paramInt, Drawable paramDrawable, String paramString)
  {
    if (paramTextView == null) {
      SLog.e("Q.qqstory.discover:StoryDiscoverAdapter", "update textView error. textView is null.");
    }
    do
    {
      return;
      paramTextView.setVisibility(paramInt);
    } while (paramInt != 0);
    paramTextView.setCompoundDrawables(paramDrawable, null, null, null);
    paramTextView.setText(paramString);
  }
  
  private void a(StoryDiscoverAdapter.StoryDiscoverViewHolder paramStoryDiscoverViewHolder, CardItem.ActivityCardInfo paramActivityCardInfo)
  {
    if ((paramStoryDiscoverViewHolder == null) || (paramActivityCardInfo == null))
    {
      SLog.e("Q.qqstory.discover:StoryDiscoverAdapter", "bind gather view holder error. view holder or card info is null.");
      return;
    }
    paramStoryDiscoverViewHolder.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = this.jdField_d_of_type_Int;
    a(paramStoryDiscoverViewHolder.jdField_a_of_type_AndroidWidgetTextView, 0, 2130843479, "热门话题");
    a(paramStoryDiscoverViewHolder.jdField_b_of_type_AndroidWidgetTextView, 4, null, null);
    a(paramStoryDiscoverViewHolder.jdField_b_of_type_AndroidWidgetImageView, 8, null);
    a(paramStoryDiscoverViewHolder.jdField_c_of_type_AndroidWidgetTextView, 0, null, paramActivityCardInfo.a());
    a(paramStoryDiscoverViewHolder.d, 0, null, String.format("%s次参与", new Object[] { a(paramActivityCardInfo.a()) }));
    a(paramStoryDiscoverViewHolder.e, 8, null, null);
  }
  
  private void a(StoryDiscoverAdapter.StoryDiscoverViewHolder paramStoryDiscoverViewHolder, CardItem.NearbyCardInfo paramNearbyCardInfo)
  {
    if ((paramStoryDiscoverViewHolder == null) || (paramNearbyCardInfo == null))
    {
      SLog.e("Q.qqstory.discover:StoryDiscoverAdapter", "bind nearby view holder error. view holder or card info is null.");
      return;
    }
    paramStoryDiscoverViewHolder.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = this.jdField_c_of_type_Int;
    a(paramStoryDiscoverViewHolder.jdField_a_of_type_AndroidWidgetTextView, 8, 0, null);
    Object localObject;
    if (paramNearbyCardInfo.a() == null)
    {
      localObject = "";
      a(paramStoryDiscoverViewHolder.jdField_b_of_type_AndroidWidgetImageView, 0, (String)localObject);
      if (paramNearbyCardInfo.a() != null) {
        break label175;
      }
      localObject = "nickName";
      label78:
      a(paramStoryDiscoverViewHolder.jdField_c_of_type_AndroidWidgetTextView, 0, null, (String)localObject);
      String str = paramNearbyCardInfo.a();
      if (!TextUtils.isEmpty(str))
      {
        localObject = str;
        if (str.length() <= 5) {}
      }
      else
      {
        localObject = "0.01km";
      }
      a(paramStoryDiscoverViewHolder.d, 0, null, (String)localObject);
      if (paramNearbyCardInfo.a() != null) {
        break label187;
      }
    }
    label175:
    label187:
    for (int i = 0;; i = paramNearbyCardInfo.a().a())
    {
      a(paramStoryDiscoverViewHolder.e, 0, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, a(i));
      return;
      localObject = paramNearbyCardInfo.a().headUrl;
      break;
      localObject = paramNearbyCardInfo.a().nickName;
      break label78;
    }
  }
  
  private void a(StoryDiscoverAdapter.StoryDiscoverViewHolder paramStoryDiscoverViewHolder, CardItem.NormalCardInfo paramNormalCardInfo)
  {
    if ((paramStoryDiscoverViewHolder == null) || (paramNormalCardInfo == null))
    {
      SLog.e("Q.qqstory.discover:StoryDiscoverAdapter", "bind normal view holder error. view holder or card info is null.");
      return;
    }
    paramStoryDiscoverViewHolder.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = this.jdField_c_of_type_Int;
    a(paramStoryDiscoverViewHolder.jdField_a_of_type_AndroidWidgetTextView, 8, 0, null);
    Object localObject;
    int i;
    if (paramNormalCardInfo.a() == null)
    {
      localObject = "";
      a(paramStoryDiscoverViewHolder.jdField_b_of_type_AndroidWidgetImageView, 0, (String)localObject);
      localObject = paramNormalCardInfo.a();
      if (localObject == null) {
        break label276;
      }
      localObject = ((CardItem.CardVideoInfo)localObject).a();
      if (localObject == null) {
        break label230;
      }
      i = ((List)localObject).size();
    }
    for (;;)
    {
      label97:
      localObject = paramStoryDiscoverViewHolder.jdField_b_of_type_AndroidWidgetTextView;
      int j;
      label111:
      long l;
      if (i > 1)
      {
        j = 0;
        a((TextView)localObject, j, this.jdField_d_of_type_AndroidGraphicsDrawableDrawable, String.valueOf(i));
        if (paramNormalCardInfo.a() != null) {
          break label241;
        }
        localObject = "nickName";
        label139:
        a(paramStoryDiscoverViewHolder.jdField_c_of_type_AndroidWidgetTextView, 0, null, (String)localObject);
        if (paramNormalCardInfo.a() != null) {
          break label253;
        }
        l = 0L;
        label161:
        a(paramStoryDiscoverViewHolder.d, 0, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, a(l));
        if (paramNormalCardInfo.a() != null) {
          break label265;
        }
      }
      label265:
      for (i = 0;; i = paramNormalCardInfo.a().a())
      {
        a(paramStoryDiscoverViewHolder.e, 0, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, a(i));
        a(1, paramStoryDiscoverViewHolder, l, i);
        return;
        localObject = paramNormalCardInfo.a().headUrl;
        break;
        label230:
        i = 0;
        break label97;
        j = 4;
        break label111;
        label241:
        localObject = paramNormalCardInfo.a().nickName;
        break label139;
        label253:
        l = paramNormalCardInfo.a().a();
        break label161;
      }
      label276:
      i = 0;
    }
  }
  
  private void a(StoryDiscoverAdapter.StoryDiscoverViewHolder paramStoryDiscoverViewHolder, CardItem.OperationCardInfo paramOperationCardInfo)
  {
    if ((paramStoryDiscoverViewHolder == null) || (paramOperationCardInfo == null))
    {
      SLog.e("Q.qqstory.discover:StoryDiscoverAdapter", "bind operation view holder error. view holder or card info is null.");
      return;
    }
    paramStoryDiscoverViewHolder.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = this.jdField_c_of_type_Int;
    a(paramStoryDiscoverViewHolder.jdField_a_of_type_AndroidWidgetTextView, 0, 2130843475, paramOperationCardInfo.a());
    String str;
    label82:
    long l;
    if (paramOperationCardInfo.a() == null)
    {
      str = "";
      a(paramStoryDiscoverViewHolder.jdField_b_of_type_AndroidWidgetImageView, 0, str);
      if (paramOperationCardInfo.a() != null) {
        break label173;
      }
      str = "nickName";
      a(paramStoryDiscoverViewHolder.jdField_c_of_type_AndroidWidgetTextView, 0, null, str);
      if (paramOperationCardInfo.a() != null) {
        break label185;
      }
      l = 0L;
      label104:
      a(paramStoryDiscoverViewHolder.d, 0, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, a(l));
      if (paramOperationCardInfo.a() != null) {
        break label197;
      }
    }
    label173:
    label185:
    label197:
    for (int i = 0;; i = paramOperationCardInfo.a().a())
    {
      a(paramStoryDiscoverViewHolder.e, 0, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, a(i));
      a(1, paramStoryDiscoverViewHolder, l, i);
      return;
      str = paramOperationCardInfo.a().headUrl;
      break;
      str = paramOperationCardInfo.a().nickName;
      break label82;
      l = paramOperationCardInfo.a().a();
      break label104;
    }
  }
  
  private boolean a(@NonNull CardItem paramCardItem)
  {
    if ((paramCardItem.normalCardInfo != null) && (paramCardItem.normalCardInfo.a() != null)) {
      return paramCardItem.normalCardInfo.a().isVip;
    }
    return false;
  }
  
  public int a(DiscoverPlayMode.PlayVideoEvent paramPlayVideoEvent)
  {
    int k = 0;
    int i;
    if ((this.jdField_a_of_type_JavaUtilArrayList.size() > paramPlayVideoEvent.jdField_b_of_type_Int) && (paramPlayVideoEvent.jdField_b_of_type_Int >= 0)) {
      i = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(paramPlayVideoEvent.jdField_b_of_type_Int, -1);
    }
    do
    {
      return i;
      i = k;
    } while (paramPlayVideoEvent.a == null);
    int j = 0;
    for (;;)
    {
      i = k;
      if (j >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break;
      }
      if (((CardItem.CardVideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(j)).c().equals(paramPlayVideoEvent.a)) {
        return this.jdField_a_of_type_AndroidUtilSparseIntArray.get(j, -1);
      }
      j += 1;
    }
  }
  
  public StoryDiscoverAdapter.StoryDiscoverViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new StoryDiscoverAdapter.StoryDiscoverViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getContext()).inflate(2130970765, paramViewGroup, false), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewStoryDiscoverAdapter$OnHolderItemClickListener);
    if (paramViewGroup.jdField_c_of_type_AndroidWidgetTextView != null) {
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setMaxWidth(this.f);
    }
    return paramViewGroup;
  }
  
  public void a(View paramView)
  {
    if (paramView == null)
    {
      SLog.e("Q.qqstory.discover:StoryDiscoverAdapter", "add header view failed. view is null.");
      return;
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView instanceof RecyclerViewWithHeaderFooter))
    {
      ((RecyclerViewWithHeaderFooter)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView).a(this.jdField_a_of_type_AndroidViewView);
      notifyDataSetChanged();
      return;
    }
    SLog.e("Q.qqstory.discover:StoryDiscoverAdapter", "add header view failed. this recycle view can't add header..");
  }
  
  public void a(HotTopicInfoItem paramHotTopicInfoItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemHotTopicInfoItem = paramHotTopicInfoItem;
  }
  
  public void a(StoryDiscoverAdapter.StoryDiscoverViewHolder paramStoryDiscoverViewHolder, int paramInt)
  {
    paramStoryDiscoverViewHolder.jdField_a_of_type_Int = paramInt;
    Object localObject = (CardItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    String str;
    switch (((CardItem)localObject).cardType)
    {
    default: 
      if ((this.g == 0) && (paramInt == 1)) {
        paramStoryDiscoverViewHolder.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = this.jdField_d_of_type_Int;
      }
      if (((CardItem)localObject).cardType == 4) {
        if (((CardItem)localObject).gatherCardInfo == null)
        {
          str = "";
          label103:
          str = ThumbnailUrlHelper.b(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getContext(), str);
          a(paramStoryDiscoverViewHolder.jdField_a_of_type_AndroidWidgetImageView, str);
          str = ((CardItem)localObject).normalCardInfo.a().getUserIconUrl();
          if ((!a((CardItem)localObject)) || (TextUtils.isEmpty(str))) {
            break label380;
          }
          paramStoryDiscoverViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          UIUtils.a(paramStoryDiscoverViewHolder.jdField_c_of_type_AndroidWidgetImageView, str, 20, 20, null, 1);
          label174:
          if (!((CardItem)localObject).hasReportExp)
          {
            ((CardItem)localObject).hasReportExp = true;
            str = "";
            if (((CardItem)localObject).getCardVideoInfo() != null) {
              str = ((CardItem)localObject).getCardVideoInfo().c();
            }
            if (this.g != 0) {
              break label427;
            }
            paramStoryDiscoverViewHolder = "";
            switch (((CardItem)localObject).cardType)
            {
            default: 
              StoryReportor.a("content_flow", "exp_card", this.h, 0, new String[] { paramStoryDiscoverViewHolder, "", str });
            }
          }
        }
      }
      break;
    }
    label380:
    while (this.g != 2) {
      for (;;)
      {
        return;
        a(paramStoryDiscoverViewHolder, ((CardItem)localObject).normalCardInfo);
        break;
        a(paramStoryDiscoverViewHolder, ((CardItem)localObject).operationCardInfo);
        break;
        a(paramStoryDiscoverViewHolder, ((CardItem)localObject).gatherCardInfo);
        break;
        a(paramStoryDiscoverViewHolder, ((CardItem)localObject).nearByCardInfo);
        break;
        str = ((CardItem)localObject).gatherCardInfo.b();
        break label103;
        if (((CardItem)localObject).getCardVideoInfo() == null)
        {
          str = "";
          break label103;
        }
        str = ((CardItem)localObject).getCardVideoInfo().b();
        break label103;
        paramStoryDiscoverViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        UIUtils.a(paramStoryDiscoverViewHolder.jdField_c_of_type_AndroidWidgetImageView);
        break label174;
        paramStoryDiscoverViewHolder = "1";
        continue;
        paramStoryDiscoverViewHolder = "2";
        continue;
        paramStoryDiscoverViewHolder = "3";
        continue;
        paramStoryDiscoverViewHolder = "4";
      }
    }
    label427:
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemHotTopicInfoItem != null)
    {
      paramStoryDiscoverViewHolder = String.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryModelItemHotTopicInfoItem.mTopicId);
      if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemHotTopicInfoItem == null) {
        break label508;
      }
    }
    label508:
    for (localObject = this.jdField_a_of_type_ComTencentBizQqstoryModelItemHotTopicInfoItem.mSubjectName;; localObject = "")
    {
      StoryReportor.a("content_flow", "exp_hot_card", this.h, 0, new String[] { paramStoryDiscoverViewHolder, localObject, str });
      return;
      paramStoryDiscoverViewHolder = "";
      break;
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      SLog.e("Q.qqstory.discover:StoryDiscoverAdapter", "update header view failed because header view is null.");
      return;
    }
    ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371801);
    TextView localTextView1 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371803);
    TextView localTextView2 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371804);
    TextView localTextView3 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371805);
    localTextView1.setText(paramString1);
    localTextView2.setText(String.format("%d次参与", new Object[] { Integer.valueOf(paramInt) }));
    localTextView3.setText(paramString2);
    UIUtils.a(localImageView, paramString3, UIUtils.jdField_c_of_type_Int, UIUtils.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getContext(), 180.0F), 0, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getResources().getDrawable(2131493771), "QQStoryDiscoverHeader");
  }
  
  public void a(List paramList)
  {
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_AndroidUtilSparseIntArray.clear();
    this.jdField_b_of_type_AndroidUtilSparseIntArray.clear();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      CardItem.CardVideoInfo localCardVideoInfo = ((CardItem)this.jdField_a_of_type_JavaUtilList.get(i)).getCardVideoInfo();
      if (localCardVideoInfo != null)
      {
        this.jdField_a_of_type_AndroidUtilSparseIntArray.append(this.jdField_a_of_type_JavaUtilArrayList.size(), i);
        this.jdField_b_of_type_AndroidUtilSparseIntArray.append(i, this.jdField_a_of_type_JavaUtilArrayList.size());
        this.jdField_a_of_type_JavaUtilArrayList.add(localCardVideoInfo);
      }
      i += 1;
    }
    long l2 = System.currentTimeMillis();
    SLog.a("Q.qqstory.discover:StoryDiscoverAdapter", "add data %d take time %d, data count %d", Integer.valueOf(paramList.size()), Long.valueOf(l2 - l1), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return super.getItemViewType(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.discover.view.StoryDiscoverAdapter
 * JD-Core Version:    0.7.0.1
 */