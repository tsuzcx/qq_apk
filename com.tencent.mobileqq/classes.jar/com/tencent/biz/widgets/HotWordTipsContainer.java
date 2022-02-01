package com.tencent.biz.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.search.HotWordSearchEntryModel;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.GIFInfo;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class HotWordTipsContainer
  extends LinearLayout
  implements View.OnClickListener
{
  HotWordTipsContainer.OnTipClickListener a;
  protected Context b;
  private final String c = "defaultmode";
  private final String d = "darkmode";
  private String[] e = { "https://wezone-theme.cdn-go.cn/url-resource/latest/defaultmode/870/qsearch_qcircle/hotseatch_order_1@3x.png", "https://wezone-theme.cdn-go.cn/url-resource/latest/defaultmode/870/qsearch_qcircle/hotseatch_order_2@3x.png", "https://wezone-theme.cdn-go.cn/url-resource/latest/defaultmode/870/qsearch_qcircle/hotseatch_order_3@3x.png", "https://wezone-theme.cdn-go.cn/url-resource/latest/defaultmode/870/qsearch_qcircle/hotseatch_order_4@3x.png", "https://wezone-theme.cdn-go.cn/url-resource/latest/defaultmode/870/qsearch_qcircle/hotseatch_order_5@3x.png", "https://wezone-theme.cdn-go.cn/url-resource/latest/defaultmode/870/qsearch_qcircle/hotseatch_order_6@3x.png", "https://wezone-theme.cdn-go.cn/url-resource/latest/defaultmode/870/qsearch_qcircle/hotseatch_order_7@3x.png", "https://wezone-theme.cdn-go.cn/url-resource/latest/defaultmode/870/qsearch_qcircle/hotseatch_order_8@3x.png" };
  private HotWordSearchEntryDataModel f = null;
  private RelativeLayout g;
  private LinearLayout h;
  private View i;
  private TextView j;
  private TextView k;
  
  public HotWordTipsContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.b = paramContext;
    setOrientation(1);
  }
  
  private String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    try
    {
      Color.parseColor(paramString1);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getValidColor ");
        localStringBuilder.append(paramString1);
        QLog.d("HotWordTipsContainer", 2, localStringBuilder.toString());
      }
    }
    return paramString2;
  }
  
  private void a()
  {
    this.i.setVisibility(8);
    this.k.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.j.getLayoutParams();
    localLayoutParams.leftMargin = 0;
    this.j.setLayoutParams(localLayoutParams);
  }
  
  private void a(int paramInt, URLImageView paramURLImageView, HotWordSearchEntryDataModel.HotSearchItem paramHotSearchItem)
  {
    if (paramHotSearchItem != null)
    {
      if (paramURLImageView == null) {
        return;
      }
      paramURLImageView.setVisibility(0);
      this.k.setVisibility(8);
      this.i.setVisibility(8);
      Object localObject = paramHotSearchItem.imgUrl;
      paramHotSearchItem = (HotWordSearchEntryDataModel.HotSearchItem)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        String[] arrayOfString = this.e;
        paramHotSearchItem = (HotWordSearchEntryDataModel.HotSearchItem)localObject;
        if (paramInt < arrayOfString.length) {
          paramHotSearchItem = arrayOfString[paramInt];
        }
      }
      if (!TextUtils.isEmpty(paramHotSearchItem))
      {
        localObject = paramHotSearchItem;
        if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
          localObject = paramHotSearchItem.replace("defaultmode", "darkmode");
        }
        paramURLImageView.setImageDrawable(URLDrawable.getDrawable((String)localObject, URLDrawable.URLDrawableOptions.obtain()));
      }
      paramURLImageView = (RelativeLayout.LayoutParams)this.j.getLayoutParams();
      paramURLImageView.setMargins(DisplayUtil.a(getContext(), 2.0F), 0, 0, 0);
      this.j.setLayoutParams(paramURLImageView);
    }
  }
  
  private void a(int paramInt, HotWordSearchEntryDataModel.HotSearchItem paramHotSearchItem)
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      if (paramHotSearchItem == null) {
        return;
      }
      localObject = (URLImageView)((RelativeLayout)localObject).findViewById(2131429406);
      ((URLImageView)localObject).setVisibility(8);
      if ((paramInt == 10) && (UniteSearchActivity.h != null) && (TextUtils.equals(UniteSearchActivity.h.title, paramHotSearchItem.title)) && (!HotWordSearchEntryModel.a(this.f.d)) && (!TextUtils.isEmpty(this.f.d.hotWordGifUrl))) {
        HotWordSearchEntryModel.a(getContext(), (URLImageView)localObject, this.f.d.hotWordGifUrl, this.f.d.hotWordGifUrlNight, null);
      }
    }
  }
  
  private void a(int paramInt, boolean paramBoolean, HotWordSearchEntryDataModel.HotSearchItem paramHotSearchItem)
  {
    if (this.i != null)
    {
      if (paramHotSearchItem == null) {
        return;
      }
      this.k.setText(String.valueOf(paramInt + 1));
      String str = a(paramHotSearchItem.indexTextColor, "#777777");
      paramHotSearchItem = a(paramHotSearchItem.indexBgColor, "#00000000");
      this.i.setBackgroundColor(Color.parseColor(paramHotSearchItem));
      if (paramBoolean)
      {
        this.k.setTextColor(Color.parseColor("#5F6062"));
        if (!TextUtils.equals(paramHotSearchItem, "#00000000")) {
          this.k.setTextColor(-1);
        }
      }
      else
      {
        this.k.setTextColor(Color.parseColor(str));
      }
    }
  }
  
  private void a(HotWordSearchEntryDataModel.HotSearchItem paramHotSearchItem)
  {
    TextView localTextView = this.j;
    if (localTextView != null)
    {
      if (paramHotSearchItem == null) {
        return;
      }
      localTextView.setText(paramHotSearchItem.title);
      if (!TextUtils.isEmpty(paramHotSearchItem.titleTextColor)) {
        this.j.setTextColor(Color.parseColor(paramHotSearchItem.titleTextColor));
      }
    }
  }
  
  private void b(int paramInt, HotWordSearchEntryDataModel.HotSearchItem paramHotSearchItem)
  {
    if (paramHotSearchItem == null) {
      return;
    }
    TextView localTextView = (TextView)this.g.findViewById(2131448380);
    localTextView.setVisibility(0);
    localTextView.setText(paramHotSearchItem.detailText);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.g.findViewById(2131444987);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams();
    int m = DisplayUtil.a(getContext(), 12.0F);
    this.h.setPadding(0, 0, 0, 0);
    localLayoutParams.height = DisplayUtil.a(getContext(), 20.0F);
    if (paramInt % 2 == 0)
    {
      localTextView.setPadding(m, 0, 0, 0);
      localLayoutParams.setMargins(m, m, m, 0);
    }
    else
    {
      localLayoutParams.setMargins(0, m, m, 0);
    }
    localRelativeLayout.setLayoutParams(localLayoutParams);
    a(paramInt, (URLImageView)localRelativeLayout.findViewById(2131436424), paramHotSearchItem);
    this.k.setVisibility(8);
    this.i.setVisibility(8);
  }
  
  private void b(HotWordSearchEntryDataModel.HotSearchItem paramHotSearchItem)
  {
    if ((this.h != null) && (paramHotSearchItem != null))
    {
      if (TextUtils.isEmpty(paramHotSearchItem.rightIconUrl)) {
        return;
      }
      URLImageView localURLImageView = (URLImageView)this.h.findViewById(2131444823);
      ColorDrawable localColorDrawable = new ColorDrawable();
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        localColorDrawable.setColor(this.b.getResources().getColor(2131168420));
      } else {
        localColorDrawable.setColor(this.b.getResources().getColor(2131168419));
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
      localURLDrawableOptions.mFailedDrawable = localColorDrawable;
      paramHotSearchItem = URLDrawable.getDrawable(paramHotSearchItem.rightIconUrl, localURLDrawableOptions);
      if (paramHotSearchItem.getStatus() != 1) {
        paramHotSearchItem.startDownload();
      }
      localURLImageView.setVisibility(0);
      localURLImageView.setImageDrawable(paramHotSearchItem);
    }
  }
  
  public void a(HotWordSearchEntryDataModel paramHotWordSearchEntryDataModel, int paramInt)
  {
    removeAllViews();
    this.f = paramHotWordSearchEntryDataModel;
    paramHotWordSearchEntryDataModel = this.f;
    if ((paramHotWordSearchEntryDataModel != null) && (paramHotWordSearchEntryDataModel.b() != null))
    {
      if (this.f.b().size() < 2) {
        return;
      }
      new ArrayList();
      int i2 = this.f.b().size() / 2;
      boolean bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
      int n;
      for (int m = 0; m < i2 * 2; m = n + 1)
      {
        paramHotWordSearchEntryDataModel = new LinearLayout(this.b);
        paramHotWordSearchEntryDataModel.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        paramHotWordSearchEntryDataModel.setOrientation(0);
        super.addView(paramHotWordSearchEntryDataModel);
        int i1 = 0;
        n = m;
        m = i1;
        while (m < 2)
        {
          n += m;
          HotWordSearchEntryDataModel.HotSearchItem localHotSearchItem = (HotWordSearchEntryDataModel.HotSearchItem)this.f.b().get(n);
          this.g = ((RelativeLayout)LayoutInflater.from(this.b).inflate(2131627232, null));
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2);
          localLayoutParams.weight = 1.0F;
          this.g.setLayoutParams(localLayoutParams);
          paramHotWordSearchEntryDataModel.addView(this.g);
          this.h = ((LinearLayout)this.g.findViewById(2131435167));
          this.h.setVisibility(0);
          this.j = ((TextView)this.h.findViewById(2131447547));
          this.k = ((TextView)this.h.findViewById(2131435675));
          this.i = this.h.findViewById(2131435673);
          a(paramInt, localHotSearchItem);
          a(localHotSearchItem);
          b(localHotSearchItem);
          a(n, bool, localHotSearchItem);
          i1 = localHotSearchItem.type;
          if (i1 != 7)
          {
            if (i1 == 8) {
              b(n, localHotSearchItem);
            }
          }
          else {
            a();
          }
          this.g.setTag(localHotSearchItem);
          this.g.setOnClickListener(this);
          m += 1;
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    HotWordTipsContainer.OnTipClickListener localOnTipClickListener = this.a;
    if (localOnTipClickListener != null) {
      localOnTipClickListener.a((HotWordSearchEntryDataModel.HotSearchItem)paramView.getTag());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setOnTipsClickListener(HotWordTipsContainer.OnTipClickListener paramOnTipClickListener)
  {
    this.a = paramOnTipClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.widgets.HotWordTipsContainer
 * JD-Core Version:    0.7.0.1
 */