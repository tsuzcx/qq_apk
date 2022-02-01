package com.tencent.biz.pubaccount.readinjoyAd.ad.proteus;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.data.ReadInjoyAdExpandLiveCell;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.ProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInjoyImageView;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.utils.CommonImageCacheHelper;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import org.json.JSONObject;

public class AdLiveExpandCardProteusItem
  implements ProteusItem
{
  private String a;
  private ReadInjoyImageView b;
  private int c = 0;
  private final Handler d = new AdLiveExpandCardProteusItem.1(this, Looper.getMainLooper());
  
  private InputStream a(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
    return new ByteArrayInputStream(localByteArrayOutputStream.toByteArray());
  }
  
  private void a()
  {
    if (this.b != null)
    {
      Bitmap localBitmap = CommonImageCacheHelper.a(this.a);
      this.b.setBitmap(localBitmap, true);
    }
  }
  
  private void a(AdvertisementInfo paramAdvertisementInfo, ViewBase paramViewBase)
  {
    paramViewBase = paramViewBase.findViewBaseByName("id_large_video_icon");
    if (paramViewBase != null)
    {
      boolean bool = TextUtils.isEmpty(paramAdvertisementInfo.mAdVideoUrl);
      int i = 8;
      if (bool)
      {
        paramViewBase.setVisibility(8);
        return;
      }
      if (!paramAdvertisementInfo.isSmallCard) {
        i = 0;
      }
      paramViewBase.setVisibility(i);
    }
  }
  
  private void a(ViewBase paramViewBase, Container paramContainer, boolean paramBoolean)
  {
    try
    {
      a(paramViewBase, paramBoolean);
      b(paramViewBase, paramBoolean);
      paramViewBase.findViewBaseByName("id_ad_expand_back").getNativeView().post(new AdLiveExpandCardProteusItem.3(this, paramViewBase, paramBoolean, paramContainer));
      return;
    }
    catch (Exception paramViewBase)
    {
      paramContainer = new StringBuilder();
      paramContainer.append("handle expand view error");
      paramContainer.append(paramViewBase.getMessage());
      QLog.e("AdLiveExpandCardProteusItem", 1, paramContainer.toString());
    }
  }
  
  private void a(ViewBase paramViewBase, boolean paramBoolean)
  {
    ViewBase localViewBase = paramViewBase.findViewBaseByName("id_ad_zhibo_small_container");
    int j = 0;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 4;
    }
    localViewBase.setVisibility(i);
    localViewBase = paramViewBase.findViewBaseByName("id_ad_zhibo_small");
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localViewBase.setVisibility(i);
    localViewBase = paramViewBase.findViewBaseByName("id_ad_tag_small_view");
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localViewBase.setVisibility(i);
    localViewBase = paramViewBase.findViewBaseByName("id_ad_fu_title_small_container");
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localViewBase.setVisibility(i);
    localViewBase = paramViewBase.findViewBaseByName("id_ad_left_bottom_small_back");
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localViewBase.setVisibility(i);
    paramViewBase = paramViewBase.findViewBaseByName("id_ad_left_bottom_wenzi_back_small");
    if (paramBoolean) {
      i = j;
    } else {
      i = 8;
    }
    paramViewBase.setVisibility(i);
  }
  
  private void a(IReadInJoyModel paramIReadInJoyModel, URLDrawable paramURLDrawable)
  {
    paramURLDrawable = ImageUtil.a(paramURLDrawable.getCurrDrawable(), 750, 674);
    if ((paramURLDrawable != null) && (paramIReadInJoyModel != null) && (paramIReadInJoyModel.u() != null))
    {
      if (paramIReadInJoyModel.u().a() == null) {
        return;
      }
      int i = ViewUtils.dip2px(44.0F) + ImmersiveUtils.getStatusBarHeight(paramIReadInJoyModel.u().a());
      int j = ViewUtils.dip2px(260.0F);
      float f2 = i;
      float f1 = j + i;
      f2 /= f1;
      f1 = j / f1;
      i = (int)(paramURLDrawable.getHeight() * f2);
      a(this.a, f1, i, paramURLDrawable.getHeight(), paramURLDrawable.getWidth(), paramURLDrawable);
    }
  }
  
  private void b(AdvertisementInfo paramAdvertisementInfo, ViewBase paramViewBase)
  {
    TextView localTextView = (TextView)paramViewBase.findViewBaseByName("id_ad_fu_title_text").getNativeView();
    localTextView.setMaxEms(15);
    localTextView.setSingleLine();
    localTextView.setMaxLines(1);
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    if (paramAdvertisementInfo.mAdvertisementExtInfo == null) {
      return;
    }
    if (TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementExtInfo.J)) {
      return;
    }
    paramAdvertisementInfo = paramViewBase.findViewBaseByName("id_ad_fu_social_container_right");
    if (paramAdvertisementInfo != null)
    {
      paramAdvertisementInfo.setVisibility(0);
      localTextView.setMaxEms(10);
      return;
    }
    paramAdvertisementInfo.setVisibility(8);
  }
  
  private void b(ViewBase paramViewBase, boolean paramBoolean)
  {
    ViewBase localViewBase = paramViewBase.findViewBaseByName("id_ad_expand_back");
    int j = 8;
    int i;
    if (paramBoolean) {
      i = 8;
    } else {
      i = 0;
    }
    localViewBase.setVisibility(i);
    localViewBase = paramViewBase.findViewBaseByName("id_article_large_imge");
    if (paramBoolean) {
      i = 8;
    } else {
      i = 0;
    }
    localViewBase.setVisibility(i);
    localViewBase = paramViewBase.findViewBaseByName("id_ad_tag_view");
    if (paramBoolean) {
      i = 8;
    } else {
      i = 0;
    }
    localViewBase.setVisibility(i);
    localViewBase = paramViewBase.findViewBaseByName("id_ad_fu_title_container");
    if (paramBoolean) {
      i = 8;
    } else {
      i = 0;
    }
    localViewBase.setVisibility(i);
    localViewBase = paramViewBase.findViewBaseByName("id_ad_left_bottom_wenzi_back");
    if (paramBoolean) {
      i = 8;
    } else {
      i = 0;
    }
    localViewBase.setVisibility(i);
    paramViewBase = paramViewBase.findViewBaseByName("id_ad_player_container");
    if (paramBoolean) {
      i = j;
    } else {
      i = 0;
    }
    paramViewBase.setVisibility(i);
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadInjoyAdExpandLiveCell.a(paramAbsBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    if ((paramIReadInJoyModel.k() != null) && (!(paramIReadInJoyModel.k() instanceof AdvertisementInfo))) {
      return;
    }
    AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)paramIReadInJoyModel.k();
    if (localAdvertisementInfo != null)
    {
      if (paramContainer == null) {
        return;
      }
      Object localObject = paramContainer.getVirtualView();
      if (localObject == null) {
        return;
      }
      a(localAdvertisementInfo, (ViewBase)localObject);
      b(localAdvertisementInfo, (ViewBase)localObject);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ad_expand_bottom");
      localStringBuilder.append(localAdvertisementInfo.mAdAid);
      this.a = localStringBuilder.toString();
      if (localAdvertisementInfo.isSmallCard)
      {
        a((ViewBase)localObject, paramContainer, true);
        return;
      }
      a((ViewBase)localObject, paramContainer, false);
      paramContainer = URLDrawable.URLDrawableOptions.obtain();
      paramContainer = URLDrawable.getDrawable(localAdvertisementInfo.mAdvertisementExtInfo.I, paramContainer);
      this.b = ((ReadInjoyImageView)((ViewBase)localObject).findViewBaseByName("id_ad_expand_back"));
      if (CommonImageCacheHelper.a(this.a) != null)
      {
        this.b.setBitmap(CommonImageCacheHelper.a(this.a), true);
        return;
      }
      this.b.setImageDrawable(paramContainer, true);
      if ((paramContainer.getStatus() == 1) || (paramContainer.getStatus() == 4))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("AdLiveExpandCardProteusItem.bindView");
        ((StringBuilder)localObject).append(paramContainer.getStatus());
        ReadInJoyAdLog.a("AdLiveExpandCardProteusItem", ((StringBuilder)localObject).toString());
        a(paramIReadInJoyModel, paramContainer);
      }
      paramContainer.setURLDrawableListener(new AdLiveExpandCardProteusItem.2(this, paramIReadInJoyModel));
    }
  }
  
  public void a(String paramString, float paramFloat, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    ThreadManagerV2.excute(new AdLiveExpandCardProteusItem.4(this, paramBitmap, paramInt1, paramInt2, paramFloat, paramInt3, paramString), 16, null, false);
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdLiveExpandCardProteusItem
 * JD-Core Version:    0.7.0.1
 */