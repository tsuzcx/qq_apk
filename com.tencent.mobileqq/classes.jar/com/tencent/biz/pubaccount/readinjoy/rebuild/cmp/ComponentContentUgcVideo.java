package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import aciy;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.URLThemeImageView;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import obj;
import obz;
import opw;
import pjg;
import pqq;
import pre;
import prg;

public class ComponentContentUgcVideo
  extends ComponentContentBigImageVideo
{
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private URLThemeImageView jdField_a_of_type_ComTencentWidgetURLThemeImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  
  public ComponentContentUgcVideo(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentContentUgcVideo(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentContentUgcVideo(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131494294, this, true);
  }
  
  public URL a(opw paramopw)
  {
    ArticleInfo localArticleInfo = paramopw.a();
    if ((localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.b.size() > 0))
    {
      Object localObject = (prg)localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.b.get(0);
      int i = ((prg)localObject).c;
      int j = ((prg)localObject).d;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams() != null))
      {
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
        int k = ((ViewGroup.LayoutParams)localObject).width;
        int m = ((ViewGroup.LayoutParams)localObject).height;
        if (k == m)
        {
          localObject = localArticleInfo.getVideoCoverWithSmartCut(k, m);
          if (QLog.isColorLevel())
          {
            if (localObject == null) {
              break label204;
            }
            QLog.d("ComponentContentUgcVideo", 2, "url: " + ((URL)localObject).toString() + ", ivWidth: " + k + ", ivHeight: " + m);
          }
          while (localObject != null)
          {
            paramopw = (opw)localObject;
            return paramopw;
            label204:
            QLog.d("ComponentContentUgcVideo", 2, "ivWidth: " + k + ", ivHeight: " + m);
          }
        }
      }
      if (i * 4 > j * 3)
      {
        i = 1;
        label254:
        if (i != 0) {
          break label321;
        }
      }
      label321:
      for (boolean bool = true;; bool = false)
      {
        localObject = localArticleInfo.getVideoCoverUrlWithSmartCut(bool);
        if (localObject == null) {
          break label327;
        }
        paramopw = (opw)localObject;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ComponentContentUgcVideo", 2, "url: " + ((URL)localObject).toString());
        return localObject;
        i = 0;
        break label254;
      }
    }
    label327:
    return super.a(paramopw);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131301327));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131301311));
    this.jdField_a_of_type_ComTencentWidgetURLThemeImageView = ((URLThemeImageView)paramView.findViewById(2131301310));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131309044));
    this.c = ((TextView)paramView.findViewById(2131303673));
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    if ((paramObject instanceof opw))
    {
      paramObject = ((opw)paramObject).a();
      if ((paramObject != null) && (paramObject.mSocialFeedInfo != null) && (paramObject.mSocialFeedInfo.jdField_a_of_type_Pqq != null))
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if (paramObject.mSocialFeedInfo.jdField_a_of_type_Pqq.a != 0) {
          break label108;
        }
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramObject.mSocialFeedInfo.jdField_a_of_type_Pqq.f);
      }
    }
    return;
    label108:
    this.c.setText(paramObject.mSocialFeedInfo.jdField_a_of_type_Pqq.f);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    if (!TextUtils.isEmpty(paramObject.mSocialFeedInfo.jdField_a_of_type_Pqq.g)) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setVisibility(0);
        Object localObject = new URL(paramObject.mSocialFeedInfo.jdField_a_of_type_Pqq.g);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mPlayGifImage = true;
        localObject = URLDrawable.getDrawable((URL)localObject, localURLDrawableOptions);
        this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageDrawable((Drawable)localObject);
        if (TextUtils.isEmpty(paramObject.mSocialFeedInfo.jdField_a_of_type_Pqq.e)) {
          break;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramObject.mSocialFeedInfo.jdField_a_of_type_Pqq.e);
        return;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setVisibility(8);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ComponentContentBigImageVideo", 2, "RecentLiveTipItemBuilder getview get nowBoardcastGif error, " + localMalformedURLException);
        continue;
      }
      this.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setVisibility(8);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void b()
  {
    ArticleInfo localArticleInfo;
    ViewGroup.LayoutParams localLayoutParams;
    Object localObject;
    int i;
    int k;
    boolean bool;
    int j;
    if ((this.jdField_a_of_type_Pjg.a != null) && (this.jdField_a_of_type_Pjg.a.a() != null))
    {
      localArticleInfo = this.jdField_a_of_type_Pjg.a.a();
      if ((localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.b.size() > 0))
      {
        localLayoutParams = getLayoutParams();
        localObject = getResources().getDisplayMetrics();
        i = Math.min(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
        k = aciy.a(12.0F, getResources());
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
        prg localprg = (prg)localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.b.get(0);
        if (obz.a(localprg.c, localprg.d)) {
          break label303;
        }
        bool = true;
        QLog.d("ComponentContentUgcVideo", 2, "isHorizontalScreen " + bool);
        if (!bool) {
          break label309;
        }
        j = i - k * 2;
        i = j * 9 / 16;
      }
    }
    for (;;)
    {
      ((ViewGroup.LayoutParams)localObject).width = j;
      ((ViewGroup.LayoutParams)localObject).height = i;
      localLayoutParams.width = j;
      localLayoutParams.height = i;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      setLayoutParams(localLayoutParams);
      QLog.d("ComponentContentUgcVideo", 2, "imageParams.width is " + ((ViewGroup.LayoutParams)localObject).width + "; imageParams.height is " + ((ViewGroup.LayoutParams)localObject).height);
      return;
      label303:
      bool = false;
      break;
      label309:
      if (localArticleInfo.mChannelID == 0L)
      {
        i = obj.a(i, getResources());
        QLog.d("ComponentContentUgcVideo", 2, "main feeds | ivWidth is " + i + "; ivHeight is " + i);
        j = i;
      }
      else
      {
        j = (i - k * 2 + 9) / 2;
        i = (i - k * 2) / 3 * 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcVideo
 * JD-Core Version:    0.7.0.1
 */