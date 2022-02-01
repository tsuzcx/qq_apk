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
import com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl;
import com.tencent.biz.pubaccount.util.api.IPublicAccountHttpDownloader;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.IFaceDecoder;
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
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377546);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377547);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377549));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377548));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363061));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363066));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378717));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378718));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131367274));
    this.d = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367275));
    if (!paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramSubscriptRecommendAdapter.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166093));
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843448);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new SubscriptRecommendAdapter.RecommendItem.1(this, paramSubscriptRecommendAdapter));
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new SubscriptRecommendAdapter.RecommendItem.2(this, paramSubscriptRecommendAdapter));
      this.jdField_c_of_type_AndroidViewView.setOnTouchListener(new SubscriptRecommendAdapter.RecommendItem.3(this, paramSubscriptRecommendAdapter, paramBoolean));
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(new SubscriptRecommendAdapter.RecommendItem.4(this, paramSubscriptRecommendAdapter));
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramSubscriptRecommendAdapter.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166094));
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843447);
    }
  }
  
  private void a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAccountInfo.b))
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_AndroidAppActivity, PublicAccountBrowserImpl.class);
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
    switch (paramInt)
    {
    default: 
    case 1: 
    case 2: 
      do
      {
        return;
        if (!this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843445);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetButton.setTextColor(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166108));
          this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131714548));
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          this.d.setVisibility(8);
          return;
          this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843446);
        }
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.d.setVisibility(0);
      } while (!(this.d.getDrawable() instanceof Animatable));
      ((Animatable)this.d.getDrawable()).start();
      return;
    }
    if (!this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843448);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166107));
      this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131714539));
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.d.setVisibility(8);
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843447);
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
    Object localObject1;
    if (paramSubscriptRecommendAccountInfo.jdField_a_of_type_ComTencentBizPubaccountSubscriptReadInJoyArticle != null)
    {
      localObject1 = this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      SubscriptRecommendAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter).a(((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(paramSubscriptRecommendAccountInfo.jdField_a_of_type_ComTencentBizPubaccountSubscriptReadInJoyArticle.mFirstPagePicUrl, 1, Long.valueOf(paramSubscriptRecommendAccountInfo.jdField_a_of_type_Long)), this.jdField_b_of_type_AndroidWidgetImageView, ((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height, null, 5);
    }
    label164:
    Object localObject2;
    if (paramSubscriptRecommendAccountInfo.jdField_a_of_type_ComTencentBizPubaccountSubscriptReadInJoyArticle != null)
    {
      localObject1 = paramSubscriptRecommendAccountInfo.jdField_a_of_type_ComTencentBizPubaccountSubscriptReadInJoyArticle.mTitle.replaceFirst("^\\s+", "");
      localObject2 = localObject1;
      if (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.b) {
        localObject2 = (String)localObject1 + "\n";
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      localObject1 = String.valueOf(paramSubscriptRecommendAccountInfo.jdField_a_of_type_Long);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramSubscriptRecommendAccountInfo.jdField_a_of_type_JavaLangString);
      if (AppSetting.d) {
        this.jdField_a_of_type_AndroidViewView.setContentDescription(paramSubscriptRecommendAccountInfo.jdField_a_of_type_JavaLangString);
      }
      localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, (String)localObject1);
      if (localObject2 != null) {
        break label341;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace((String)localObject1, 1, true);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840452);
    }
    for (;;)
    {
      localObject2 = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
      if (localObject2 == null) {
        break;
      }
      if (((PublicAccountDataManager)localObject2).c((String)localObject1) == null) {
        break label353;
      }
      a(1);
      paramSubscriptRecommendAccountInfo.c = 1;
      return;
      localObject1 = "";
      break label164;
      label341:
      this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
    }
    label353:
    if (paramSubscriptRecommendAccountInfo.c == 2)
    {
      a(2);
      return;
    }
    a(0);
    paramSubscriptRecommendAccountInfo.c = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptRecommendAdapter.RecommendItem
 * JD-Core Version:    0.7.0.1
 */