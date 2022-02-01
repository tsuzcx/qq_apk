package com.tencent.biz.pubaccount.subscript;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.pubaccount.util.api.IPublicAccountHttpDownloader;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.qroute.QRoute;

public class SubscriptRecommendAdapter$RecommendItem
{
  public View a;
  public Button a;
  public ImageView a;
  public TextView a;
  public SubscriptRecommendAccountInfo a;
  public View b;
  public ImageView b;
  public TextView b;
  public View c;
  public ImageView c;
  public TextView c;
  public ImageView d;
  
  public SubscriptRecommendAdapter$RecommendItem(SubscriptRecommendAdapter paramSubscriptRecommendAdapter, View paramView, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131376988);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131376989);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376991));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376990));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363007));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363010));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378112));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378113));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131367057));
    this.d = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367058));
    if (!paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramSubscriptRecommendAdapter.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166104));
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843362);
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramSubscriptRecommendAdapter.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166105));
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843361);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new SubscriptRecommendAdapter.RecommendItem.1(this, paramSubscriptRecommendAdapter));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new SubscriptRecommendAdapter.RecommendItem.2(this, paramSubscriptRecommendAdapter));
    this.jdField_c_of_type_AndroidViewView.setOnTouchListener(new SubscriptRecommendAdapter.RecommendItem.3(this, paramSubscriptRecommendAdapter, paramBoolean));
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(new SubscriptRecommendAdapter.RecommendItem.4(this, paramSubscriptRecommendAdapter));
  }
  
  private void a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAccountInfo.b))
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_AndroidAppActivity, ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountBrowser.class));
      localIntent.putExtra("key_isReadModeEnabled", true);
      localIntent.putExtra("url", this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAccountInfo.b);
      localIntent.putExtra("hide_operation_bar", true);
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(localIntent, this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAccountInfo.b);
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.d.isShown()) && ((this.d.getDrawable() instanceof Animatable))) {
      ((Animatable)this.d.getDrawable()).stop();
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.d.setVisibility(0);
        if ((this.d.getDrawable() instanceof Animatable)) {
          ((Animatable)this.d.getDrawable()).start();
        }
      }
      else
      {
        if (!this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843359);
        } else {
          this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843360);
        }
        this.jdField_a_of_type_AndroidWidgetButton.setTextColor(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166119));
        this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131714469));
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        this.d.setVisibility(8);
      }
    }
    else
    {
      if (!this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843362);
      } else {
        this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843361);
      }
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166118));
      this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131714460));
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.d.setVisibility(8);
    }
  }
  
  public void a(SubscriptRecommendAccountInfo paramSubscriptRecommendAccountInfo, int paramInt)
  {
    if (paramSubscriptRecommendAccountInfo == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAccountInfo = paramSubscriptRecommendAccountInfo;
    if (paramSubscriptRecommendAccountInfo.jdField_a_of_type_Long == -1L)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    if (paramSubscriptRecommendAccountInfo.jdField_a_of_type_ComTencentBizPubaccountSubscriptReadInJoyArticle != null)
    {
      localObject1 = this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      SubscriptRecommendAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter).a(((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(paramSubscriptRecommendAccountInfo.jdField_a_of_type_ComTencentBizPubaccountSubscriptReadInJoyArticle.mFirstPagePicUrl, 1, Long.valueOf(paramSubscriptRecommendAccountInfo.jdField_a_of_type_Long)), this.jdField_b_of_type_AndroidWidgetImageView, ((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height, null, 5);
    }
    Object localObject2 = paramSubscriptRecommendAccountInfo.jdField_a_of_type_ComTencentBizPubaccountSubscriptReadInJoyArticle;
    Object localObject1 = "";
    if (localObject2 != null) {
      localObject1 = paramSubscriptRecommendAccountInfo.jdField_a_of_type_ComTencentBizPubaccountSubscriptReadInJoyArticle.mTitle.replaceFirst("^\\s+", "");
    }
    localObject2 = localObject1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.b)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("\n");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
    localObject1 = String.valueOf(paramSubscriptRecommendAccountInfo.jdField_a_of_type_Long);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramSubscriptRecommendAccountInfo.jdField_a_of_type_JavaLangString);
    if (AppSetting.d) {
      this.jdField_a_of_type_AndroidViewView.setContentDescription(paramSubscriptRecommendAccountInfo.jdField_a_of_type_JavaLangString);
    }
    localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, (String)localObject1);
    if (localObject2 == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace((String)localObject1, 1, true);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840321);
    }
    else
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
    }
    localObject2 = (IPublicAccountDataManager)this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
    if (localObject2 != null)
    {
      if ((PublicAccountInfo)((IPublicAccountDataManager)localObject2).findPublicAccountInfoCache((String)localObject1) != null)
      {
        a(1);
        paramSubscriptRecommendAccountInfo.c = 1;
        return;
      }
      if (paramSubscriptRecommendAccountInfo.c == 2)
      {
        a(2);
        return;
      }
      a(0);
      paramSubscriptRecommendAccountInfo.c = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptRecommendAdapter.RecommendItem
 * JD-Core Version:    0.7.0.1
 */