package com.tencent.biz.qqcircle.widgets.childviewpresenter;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.fragments.content.stick.QCircleExpandStickView;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.utils.QCircleDrawableCacheUtils;
import com.tencent.biz.qqcircle.utils.QCirclePreLoadPicUtil;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.widgets.QCirclePaiTongKuanIconView;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import qqcircle.QQCircleFeedBase.StImageBusiData;
import qqcircle.QQCircleFeedBase.StSimulateData;

public class QCircleFeedItemPicPresenter$MultiPicAdapter
  extends PagerAdapter
{
  private final ArrayList<FeedCloudMeta.StImage> b = new ArrayList();
  private final LinkedList<View> c = new LinkedList();
  private FeedBlockData d;
  
  public QCircleFeedItemPicPresenter$MultiPicAdapter(QCircleFeedItemPicPresenter paramQCircleFeedItemPicPresenter) {}
  
  private View a(QCircleFeedItemPicPresenter.MultiPicAdapter.ViewHolder paramViewHolder, FeedCloudMeta.StImage paramStImage, int paramInt)
  {
    String str = paramStImage.picUrl.get();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" feedpicurl= ");
    ((StringBuilder)localObject).append(str);
    QLog.d("QCircleFeedItemPicPresent", 1, ((StringBuilder)localObject).toString());
    URLImageView localURLImageView = paramViewHolder.b;
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = QCircleDrawableCacheUtils.a(2130848395);
    localURLDrawableOptions.mFailedDrawable = QCircleDrawableCacheUtils.a(2130845199);
    if (QCircleFeedItemPicPresenter.access$400(this.a) != 0)
    {
      if ((paramStImage.width.get() != 0) && (paramStImage.height.get() != 0) && ((this.a.mData instanceof FeedBlockData)))
      {
        localObject = QCirclePreLoadPicUtil.a(((FeedBlockData)this.a.mData).b(), paramStImage.width.get(), paramStImage.height.get());
        ViewGroup.LayoutParams localLayoutParams = localURLImageView.getLayoutParams();
        localLayoutParams.width = ((Integer)((Pair)localObject).first).intValue();
        localLayoutParams.height = ((Integer)((Pair)localObject).second).intValue();
        localURLDrawableOptions.mRequestWidth = localLayoutParams.width;
        localURLDrawableOptions.mRequestHeight = localLayoutParams.height;
      }
    }
    else if (localURLImageView.getLayoutParams() != null)
    {
      localURLDrawableOptions.mRequestWidth = localURLImageView.getLayoutParams().width;
      localURLDrawableOptions.mRequestHeight = localURLImageView.getLayoutParams().height;
    }
    if ((localURLImageView.getTag(2131441759) instanceof String)) {
      localObject = (String)localURLImageView.getTag(2131441759);
    } else {
      localObject = "";
    }
    localURLImageView.setTag(2131441759, str);
    if (!((String)localObject).equals(str))
    {
      localObject = new Option().setUrl(str).setTargetView((URLImageView)localURLImageView).setFromPreLoad(false).setPredecode(true).setRequestWidth(localURLDrawableOptions.mRequestWidth).setRequestHeight(localURLDrawableOptions.mRequestHeight);
      localURLImageView.setTag(2131441709, Integer.valueOf(paramInt));
      localURLImageView.setTag(2131441711, paramViewHolder.d);
      QCircleFeedPicLoader.g().loadImage((Option)localObject, new QCircleFeedItemPicPresenter.MultiPicAdapter.1(this));
    }
    else
    {
      a(paramViewHolder.d, localURLImageView, localURLDrawableOptions, paramInt);
    }
    b(paramViewHolder, paramStImage, paramInt);
    SimpleEventBus.getInstance().registerReceiver(this.a);
    a(paramViewHolder, paramStImage);
    return paramViewHolder.a;
  }
  
  private QCircleFeedItemPicPresenter.MultiPicAdapter.ViewHolder a(ViewGroup paramViewGroup)
  {
    FrameLayout localFrameLayout = new FrameLayout(paramViewGroup.getContext());
    int i;
    if (QCircleFeedItemPicPresenter.access$400(this.a) == 0) {
      i = -1;
    } else {
      i = QCircleFeedItemPicPresenter.access$400(this.a);
    }
    localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, i));
    URLImageView localURLImageView = new URLImageView(paramViewGroup.getContext());
    localURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    if (QCircleFeedItemPicPresenter.access$400(this.a) == 0) {
      i = -1;
    } else {
      i = QCircleFeedItemPicPresenter.access$400(this.a);
    }
    localFrameLayout.addView(localURLImageView, new ViewGroup.LayoutParams(-1, i));
    QCirclePaiTongKuanIconView localQCirclePaiTongKuanIconView = new QCirclePaiTongKuanIconView(paramViewGroup.getContext());
    Object localObject = new FrameLayout.LayoutParams(-2, -2);
    ((FrameLayout.LayoutParams)localObject).topMargin = ViewUtils.a(12.0F);
    ((FrameLayout.LayoutParams)localObject).rightMargin = ViewUtils.a(10.0F);
    ((FrameLayout.LayoutParams)localObject).gravity = 53;
    localFrameLayout.addView(localQCirclePaiTongKuanIconView, (ViewGroup.LayoutParams)localObject);
    paramViewGroup = new QCircleExpandStickView(paramViewGroup.getContext());
    paramViewGroup.setReportBean(this.a.getReportBean());
    paramViewGroup.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    paramViewGroup.setVisibility(8);
    localFrameLayout.addView(paramViewGroup);
    localObject = new QCircleFeedItemPicPresenter.MultiPicAdapter.ViewHolder(this);
    ((QCircleFeedItemPicPresenter.MultiPicAdapter.ViewHolder)localObject).a = localFrameLayout;
    ((QCircleFeedItemPicPresenter.MultiPicAdapter.ViewHolder)localObject).b = localURLImageView;
    ((QCircleFeedItemPicPresenter.MultiPicAdapter.ViewHolder)localObject).c = localQCirclePaiTongKuanIconView;
    ((QCircleFeedItemPicPresenter.MultiPicAdapter.ViewHolder)localObject).d = paramViewGroup;
    return localObject;
  }
  
  private void a(QCircleExpandStickView paramQCircleExpandStickView, View paramView, URLDrawable.URLDrawableOptions paramURLDrawableOptions, int paramInt)
  {
    Option localOption = new Option();
    localOption.setRequestWidth(paramURLDrawableOptions.mRequestWidth);
    localOption.setRequestHeight(paramURLDrawableOptions.mRequestHeight);
    if (!(paramView instanceof URLImageView)) {
      return;
    }
    paramView = ((URLImageView)paramView).getDrawable();
    if ((paramView instanceof BitmapDrawable)) {
      localOption.setResultBitMap(((BitmapDrawable)paramView).getBitmap());
    }
    a(paramQCircleExpandStickView, localOption, paramInt);
  }
  
  private void a(QCircleExpandStickView paramQCircleExpandStickView, Option paramOption, int paramInt)
  {
    if (paramQCircleExpandStickView == null)
    {
      QLog.w("QCircleFeedItemPicPresent", 1, "[configStickViewBounds] expand stick view not is null.");
      return;
    }
    if (paramOption == null)
    {
      QLog.w("QCircleFeedItemPicPresent", 1, "[configStickViewBounds] option == null.");
      return;
    }
    Object localObject = paramOption.getResultBitMap();
    if (localObject == null)
    {
      QLog.w("QCircleFeedItemPicPresent", 1, "[configStickViewBounds] bitmap == null.");
      return;
    }
    int i = ((Bitmap)localObject).getWidth();
    int j = ((Bitmap)localObject).getHeight();
    int k = paramOption.getRequestWidth();
    int m = paramOption.getRequestHeight();
    QLog.d("QCircleFeedItemPicPresent", 1, new Object[] { "[initStickParam] oWidth: ", Integer.valueOf(i), " | oHeight: ", Integer.valueOf(j), " | rWidth: ", Integer.valueOf(k), " | rHeight: ", Integer.valueOf(m), ", pos: ", Integer.valueOf(paramInt) });
    paramOption = new Rect(0, 0, i, j);
    localObject = new Rect(0, 0, k, m);
    paramQCircleExpandStickView.a(this.d, paramOption, (Rect)localObject, paramInt, ImageView.ScaleType.CENTER_CROP);
  }
  
  private void a(QCircleFeedItemPicPresenter.MultiPicAdapter.ViewHolder paramViewHolder, MotionEvent paramMotionEvent)
  {
    this.a.mClickPointY = paramMotionEvent.getRawY();
    this.a.mClickPointX = paramMotionEvent.getRawX();
    if (QLog.isColorLevel())
    {
      paramMotionEvent = new StringBuilder();
      paramMotionEvent.append("mCLickPointY:");
      paramMotionEvent.append(this.a.mClickPointX);
      paramMotionEvent.append(" mClickPointX:");
      paramMotionEvent.append(this.a.mClickPointY);
      QLog.e("QCircleFeedItemPicPresent", 1, paramMotionEvent.toString());
    }
    if ((paramViewHolder != null) && (paramViewHolder.d != null)) {
      paramViewHolder.d.b(new Point((int)this.a.mClickPointX, (int)this.a.mClickPointY));
    }
  }
  
  private void a(QCircleFeedItemPicPresenter.MultiPicAdapter.ViewHolder paramViewHolder, FeedCloudMeta.StImage paramStImage)
  {
    if (paramViewHolder.c == null)
    {
      QLog.w("QCircleFeedItemPicPresent", 1, "[setPaiTongKuanView] holder tongkuan view is null.");
      return;
    }
    Object localObject2 = null;
    try
    {
      Object localObject1 = new QQCircleFeedBase.StImageBusiData();
      try
      {
        ((QQCircleFeedBase.StImageBusiData)localObject1).mergeFrom(paramStImage.busiData.get().toByteArray());
        paramStImage = (FeedCloudMeta.StImage)localObject1;
      }
      catch (Exception localException2)
      {
        paramStImage = (FeedCloudMeta.StImage)localObject1;
        localObject1 = localException2;
      }
      QLog.e("QCircleFeedItemPicPresent", 1, "[setPaiTongKuanView] exception:", localException1);
    }
    catch (Exception localException1)
    {
      paramStImage = null;
    }
    if ((paramStImage != null) && (paramStImage.simulate_date != null) && (paramStImage.simulate_date.get() != null) && (paramStImage.simulate_date.is_show_button.get() == 1) && (Build.VERSION.SDK_INT >= 21))
    {
      paramViewHolder.c.setVisibility(0);
      String str2 = paramStImage.simulate_date.simulate_name.get();
      String str1 = "";
      if (str2.equals("")) {
        paramViewHolder.c.a();
      } else {
        paramViewHolder.c.setTongKuanText(str2);
      }
      paramViewHolder.c.setOnClickListener(new QCircleFeedItemPicPresenter.MultiPicAdapter.4(this, paramStImage));
      paramViewHolder = localObject2;
      if (this.a.mReportInfo != null) {
        paramViewHolder = this.a.mReportInfo.mFeed;
      }
      paramStImage = QCirclePluginReportUtil.b(paramViewHolder).setActionType(86).setSubActionType(1);
      paramViewHolder = str1;
      if (this.a.mReportInfo != null)
      {
        paramViewHolder = str1;
        if (this.a.mReportInfo.mFeed != null) {
          paramViewHolder = this.a.mReportInfo.mFeed.poster.id.get();
        }
      }
      paramViewHolder = paramStImage.setToUin(paramViewHolder);
      int i;
      if (this.a.mReportInfo != null) {
        i = this.a.mReportInfo.mDataPosition;
      } else {
        i = -1;
      }
      QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(paramViewHolder.setIndex(i).setPageId(this.a.getPageId())));
      return;
    }
    paramViewHolder.c.setVisibility(8);
  }
  
  private void a(Option paramOption)
  {
    RFThreadManager.getUIHandler().post(new QCircleFeedItemPicPresenter.MultiPicAdapter.5(this, paramOption));
  }
  
  private void b(QCircleFeedItemPicPresenter.MultiPicAdapter.ViewHolder paramViewHolder, FeedCloudMeta.StImage paramStImage, int paramInt)
  {
    URLImageView localURLImageView = paramViewHolder.b;
    localURLImageView.setOnTouchListener(new QCircleFeedItemPicPresenter.MultiPicAdapter.2(this, paramViewHolder));
    localURLImageView.setOnClickListener(new QCircleFeedItemPicPresenter.MultiPicAdapter.3(this, paramViewHolder, paramInt, localURLImageView, paramStImage));
  }
  
  public int a()
  {
    return this.b.size();
  }
  
  public View a(ViewGroup paramViewGroup, int paramInt)
  {
    FeedCloudMeta.StImage localStImage = (FeedCloudMeta.StImage)this.b.get(paramInt);
    Object localObject;
    QCircleFeedItemPicPresenter.MultiPicAdapter.ViewHolder localViewHolder;
    if (this.c.size() > 0)
    {
      localObject = (View)this.c.removeFirst();
      localViewHolder = (QCircleFeedItemPicPresenter.MultiPicAdapter.ViewHolder)((View)localObject).getTag();
    }
    else
    {
      localViewHolder = a(paramViewGroup);
      localObject = localViewHolder.a;
      ((View)localObject).setTag(localViewHolder);
    }
    paramViewGroup.addView((View)localObject);
    return a(localViewHolder, localStImage, paramInt);
  }
  
  public void a(FeedBlockData paramFeedBlockData)
  {
    this.d = paramFeedBlockData;
  }
  
  public void a(List<FeedCloudMeta.StImage> paramList)
  {
    this.b.clear();
    notifyDataSetChanged();
    if (paramList != null)
    {
      this.b.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (View)paramObject;
    paramViewGroup.removeView(paramObject);
    this.c.add(paramObject);
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    if (getCount() == 0) {
      return -2;
    }
    return super.getItemPosition(paramObject);
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemPicPresenter.MultiPicAdapter
 * JD-Core Version:    0.7.0.1
 */