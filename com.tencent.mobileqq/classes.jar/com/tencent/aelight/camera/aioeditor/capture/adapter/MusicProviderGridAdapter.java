package com.tencent.aelight.camera.aioeditor.capture.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.music.QIMMusicConfigManager;
import com.tencent.aelight.camera.aioeditor.capture.music.QimMusicPlayer;
import com.tencent.aelight.camera.aioeditor.capture.view.MusicProviderView;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMCommonLoadingProgress;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMCommonLoadingView;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class MusicProviderGridAdapter
  extends BaseAdapter
{
  MusicProviderView a;
  List<MusicItemInfo> b;
  int c;
  int d;
  private Context e;
  
  public MusicProviderGridAdapter(Context paramContext, MusicProviderView paramMusicProviderView)
  {
    this.e = paramContext;
    this.a = paramMusicProviderView;
  }
  
  private void a(MusicProviderGridAdapter.ViewHolder paramViewHolder)
  {
    MusicItemInfo localMusicItemInfo2 = paramViewHolder.e;
    int k = localMusicItemInfo2.mType;
    MusicItemInfo localMusicItemInfo1 = ((QimMusicPlayer)QIMManager.a().d(8)).j();
    Object localObject = localMusicItemInfo1;
    if (localMusicItemInfo1 == null) {
      localObject = ((QIMMusicConfigManager)QIMManager.a(2)).a(-1, -1);
    }
    boolean bool = localMusicItemInfo2.equals((MusicItemInfo)localObject);
    int i;
    if ((k != 1) && (k != 5))
    {
      paramViewHolder.c.a(null);
      paramViewHolder.c.setVisibility(8);
      paramViewHolder.i.setVisibility(8);
      paramViewHolder.a.setVisibility(8);
      paramViewHolder.b.setVisibility(8);
      paramViewHolder.f.setVisibility(0);
      paramViewHolder.h.setVisibility(8);
      localObject = HardCodeUtil.a(2131904914);
      i = 2130845969;
      int j = 2130845966;
      if (k == 3)
      {
        localObject = HardCodeUtil.a(2131904911);
        i = 2130845967;
        j = 2130845968;
      }
      else if (k == 4)
      {
        localObject = HardCodeUtil.a(2131904909);
        i = 2130845962;
        j = 2130845963;
      }
      else if (k == 10)
      {
        localObject = HardCodeUtil.a(2131904915);
        paramViewHolder.i.setVisibility(0);
        i = 2130845970;
        j = 2130845970;
      }
      if (bool) {
        paramViewHolder.d.setImageResource(j);
      } else {
        paramViewHolder.d.setImageResource(i);
      }
      paramViewHolder.g.setVisibility(8);
      paramViewHolder.f.setText((CharSequence)localObject);
      return;
    }
    paramViewHolder.a.setVisibility(0);
    paramViewHolder.b.setVisibility(8);
    paramViewHolder.f.setVisibility(8);
    paramViewHolder.i.setVisibility(8);
    paramViewHolder.a.setText(localMusicItemInfo2.mMusicName);
    paramViewHolder.b.setText(localMusicItemInfo2.mSingername);
    if ((bool) && (!localMusicItemInfo2.isDownloading()))
    {
      i = 2130845949;
      if (localMusicItemInfo2.isMyMusicInfo())
      {
        i = 2130845965;
        paramViewHolder.f.setText(HardCodeUtil.a(2131904908));
        paramViewHolder.f.setVisibility(0);
      }
      else
      {
        paramViewHolder.f.setVisibility(8);
      }
      paramViewHolder.h.setImageResource(i);
      paramViewHolder.h.setVisibility(0);
    }
    else
    {
      paramViewHolder.h.setVisibility(8);
      paramViewHolder.f.setVisibility(8);
    }
    paramViewHolder.c.setVisibility(0);
    localObject = QIMCommonLoadingProgress.a(localMusicItemInfo2);
    paramViewHolder.c.a((QIMCommonLoadingProgress)localObject);
    if ((localMusicItemInfo2.isDownloading()) && (((QIMCommonLoadingProgress)localObject).d == 2)) {
      paramViewHolder.g.setVisibility(8);
    } else if (!localMusicItemInfo2.isFileExist()) {
      paramViewHolder.g.setVisibility(0);
    } else {
      paramViewHolder.g.setVisibility(8);
    }
    a(paramViewHolder, localMusicItemInfo2);
  }
  
  public View a()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.e);
    Object localObject1 = new RelativeLayout(this.e);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    int i = ViewUtils.dpToPx(5.0F);
    ((RelativeLayout.LayoutParams)localObject2).setMargins(i, i, i, i);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new ImageView(this.e);
    ((ImageView)localObject2).setId(2131439047);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject2 = new TextView(this.e);
    ((TextView)localObject2).setId(2131439048);
    ((TextView)localObject2).setPadding(((TextView)localObject2).getPaddingLeft(), ((TextView)localObject2).getPaddingTop(), ((TextView)localObject2).getPaddingRight(), ViewUtils.dpToPx(10.0F));
    ((TextView)localObject2).setMaxLines(4);
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject2).setTextColor(Color.parseColor("#ffffffff"));
    ((TextView)localObject2).setTextSize(2, 12.0F);
    ((TextView)localObject2).setShadowLayer(4.0F, 0.0F, 2.0F, Color.parseColor("#80000000"));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
    i = ViewUtils.dpToPx(5.0F);
    localLayoutParams.topMargin = ViewUtils.dpToPx(8.0F);
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = i;
    localLayoutParams.addRule(10, -1);
    localLayoutParams.addRule(9, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new TextView(this.e);
    ((TextView)localObject2).setId(2131439046);
    ((TextView)localObject2).setTextColor(Color.parseColor("#9fffffff"));
    ((TextView)localObject2).setTextSize(2, 9.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(9, -1);
    i = ViewUtils.dpToPx(5.0F);
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = i;
    localLayoutParams.bottomMargin = ViewUtils.dpToPx(4.0F);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new ImageView(this.e);
    ((ImageView)localObject2).setId(2131439049);
    ((ImageView)localObject2).setImageResource(2130845949);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject2 = new TextView(this.e);
    ((TextView)localObject2).setId(2131442072);
    ((TextView)localObject2).setTextSize(2, 12.0F);
    ((TextView)localObject2).setTextColor(Color.parseColor("#ffffffff"));
    ((TextView)localObject2).setVisibility(8);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.bottomMargin = ViewUtils.dpToPx(5.0F);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(14, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new QIMCommonLoadingView(this.e);
    ((QIMCommonLoadingView)localObject2).setId(2131439066);
    ((QIMCommonLoadingView)localObject2).setVisibility(8);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject1 = new ImageView(this.e);
    ((ImageView)localObject1).setId(2131439041);
    ((ImageView)localObject1).setVisibility(8);
    ((ImageView)localObject1).setImageResource(2130847601);
    i = ViewUtils.dpToPx(18.0F);
    localObject2 = new RelativeLayout.LayoutParams(i, i);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new ImageView(this.e);
    ((ImageView)localObject1).setId(2131450262);
    ((ImageView)localObject1).setImageResource(2130847606);
    ((ImageView)localObject1).setVisibility(8);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    return localRelativeLayout;
  }
  
  public void a(View paramView)
  {
    paramView = (MusicProviderGridAdapter.ViewHolder)paramView.getTag();
    if (paramView != null) {
      a(paramView);
    }
  }
  
  public void a(MusicProviderGridAdapter.ViewHolder paramViewHolder, MusicItemInfo paramMusicItemInfo)
  {
    if (TextUtils.isEmpty(paramMusicItemInfo.mAlbumUrl))
    {
      paramViewHolder.d.setImageResource(2130845964);
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    int i = AIOUtils.b(80.0F, paramViewHolder.d.getResources());
    localURLDrawableOptions.mRequestWidth = i;
    localURLDrawableOptions.mRequestHeight = i;
    localURLDrawableOptions.mRetryCount = 3;
    localURLDrawableOptions.mFailedDrawable = this.e.getResources().getDrawable(2130845964);
    localURLDrawableOptions.mLoadingDrawable = this.e.getResources().getDrawable(2130845964);
    paramMusicItemInfo = URLDrawable.getDrawable(paramMusicItemInfo.mAlbumUrl, localURLDrawableOptions);
    if (paramMusicItemInfo.getStatus() == 2) {
      paramMusicItemInfo.restartDownload();
    }
    paramMusicItemInfo.setDecodeHandler(URLDrawableDecodeHandler.v);
    paramViewHolder.d.setImageDrawable(paramMusicItemInfo);
  }
  
  public void a(List<MusicItemInfo> paramList)
  {
    this.b = paramList;
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
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((this.c <= 0) && (paramViewGroup != null))
    {
      this.c = paramViewGroup.getMeasuredWidth();
      this.d = ((int)((this.c - MusicProviderPagerAdapter.b * 3 - paramViewGroup.getPaddingLeft() - paramViewGroup.getPaddingRight()) / 4 + 0.5F));
    }
    MusicItemInfo localMusicItemInfo = (MusicItemInfo)getItem(paramInt);
    if (paramView == null)
    {
      paramViewGroup = new MusicProviderGridAdapter.ViewHolder(this);
      paramView = a();
      paramViewGroup.a = ((TextView)paramView.findViewById(2131439048));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131439046));
      paramViewGroup.c = ((QIMCommonLoadingView)paramView.findViewById(2131439066));
      paramViewGroup.d = ((ImageView)paramView.findViewById(2131439047));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131442072));
      paramViewGroup.h = ((ImageView)paramView.findViewById(2131439049));
      paramViewGroup.g = ((ImageView)paramView.findViewById(2131439041));
      paramViewGroup.i = ((ImageView)paramView.findViewById(2131450262));
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (MusicProviderGridAdapter.ViewHolder)paramView.getTag();
    }
    paramViewGroup.c.setVisibility(0);
    paramViewGroup.e = localMusicItemInfo;
    paramViewGroup.j = paramInt;
    AbsListView.LayoutParams localLayoutParams2 = (AbsListView.LayoutParams)paramView.getLayoutParams();
    AbsListView.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null)
    {
      localLayoutParams1 = new AbsListView.LayoutParams(-1, -1);
      paramView.setLayoutParams(localLayoutParams1);
    }
    localLayoutParams1.height = this.d;
    a(paramViewGroup);
    if (localMusicItemInfo.isWsBanner()) {
      WeishiGuideUtils.a(localMusicItemInfo);
    }
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.adapter.MusicProviderGridAdapter
 * JD-Core Version:    0.7.0.1
 */