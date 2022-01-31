package com.tencent.mobileqq.activity.qwallet.emoj;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import axwd;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPicHelper;
import vms;

class EmojiFragment$TempListItem
  extends FrameLayout
{
  private ImageView mCornerImageView;
  private ImageView mImageView;
  private TextView mItem;
  private View mLoadingView;
  private LinearLayout mRootLayout;
  
  public EmojiFragment$TempListItem(EmojiFragment paramEmojiFragment, @NonNull Context paramContext)
  {
    super(paramContext);
    this.mRootLayout = new LinearLayout(paramContext);
    this.mRootLayout.setOrientation(1);
    this.mRootLayout.setClickable(true);
    addView(this.mRootLayout);
    paramEmojiFragment = (FrameLayout.LayoutParams)this.mRootLayout.getLayoutParams();
    paramEmojiFragment.width = -2;
    paramEmojiFragment.height = -2;
    paramEmojiFragment = new RelativeLayout(paramContext);
    this.mRootLayout.addView(paramEmojiFragment);
    Object localObject = (LinearLayout.LayoutParams)paramEmojiFragment.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).width = vms.a(paramContext, 66.0F);
    ((LinearLayout.LayoutParams)localObject).height = vms.a(paramContext, 66.0F);
    ((LinearLayout.LayoutParams)localObject).gravity = 17;
    this.mCornerImageView = new ImageView(paramContext);
    paramEmojiFragment.addView(this.mCornerImageView);
    this.mCornerImageView.getLayoutParams().width = vms.a(paramContext, 66.0F);
    this.mCornerImageView.getLayoutParams().height = vms.a(paramContext, 66.0F);
    this.mCornerImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    this.mCornerImageView.setImageResource(2130842678);
    this.mCornerImageView.setVisibility(8);
    this.mLoadingView = new View(paramContext);
    paramEmojiFragment.addView(this.mLoadingView);
    localObject = (RelativeLayout.LayoutParams)this.mLoadingView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = vms.a(paramContext, 40.0F);
    ((RelativeLayout.LayoutParams)localObject).height = vms.a(paramContext, 40.0F);
    ((RelativeLayout.LayoutParams)localObject).addRule(13, -1);
    this.mImageView = new ImageView(paramContext);
    paramEmojiFragment.addView(this.mImageView);
    this.mImageView.getLayoutParams().width = -1;
    this.mImageView.getLayoutParams().height = -1;
    this.mItem = new TextView(paramContext);
    this.mItem.setSingleLine(true);
    this.mItem.setMaxEms(5);
    this.mItem.setEllipsize(TextUtils.TruncateAt.END);
    this.mItem.setTextSize(1, 14.0F);
    this.mItem.setTextColor(Color.parseColor("#FF777777"));
    this.mRootLayout.addView(this.mItem);
    paramEmojiFragment = (LinearLayout.LayoutParams)this.mItem.getLayoutParams();
    paramEmojiFragment.width = -2;
    paramEmojiFragment.height = -2;
    paramEmojiFragment.gravity = 1;
    paramEmojiFragment.topMargin = vms.a(paramContext, 6.0F);
  }
  
  public void setData(EmojiFragment.TemplateInfo paramTemplateInfo)
  {
    if (this.mRootLayout != null) {
      this.mRootLayout.setOnClickListener(new EmojiFragment.TempListItem.1(this, paramTemplateInfo));
    }
    if (this.mItem != null) {
      this.mItem.setText(paramTemplateInfo.text);
    }
    Object localObject1;
    if (this.mImageView != null)
    {
      localObject1 = paramTemplateInfo.url;
      if (QLog.isColorLevel()) {
        QLog.i("EmojiFragment", 2, "模板url: " + (String)localObject1);
      }
      Object localObject2 = getResources().getDrawable(2130842772);
      this.mLoadingView.setBackgroundDrawable((Drawable)localObject2);
      ((Animatable)localObject2).start();
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("qwallet_config_md5", paramTemplateInfo.md5);
      localObject1 = QWalletPicHelper.getNetDrawableForQWallet((String)localObject1, axwd.a, axwd.a, (Bundle)localObject2);
      this.mImageView.setImageDrawable((Drawable)localObject1);
      if (localObject1 == null) {
        break label252;
      }
      if (((URLDrawable)localObject1).getStatus() != 1) {
        break label230;
      }
      this.mLoadingView.setBackgroundDrawable(null);
      this.mCornerImageView.setVisibility(0);
      this.this$0.handleDrawableSucc((URLDrawable)localObject1, paramTemplateInfo.isSelected, paramTemplateInfo.rId, this.mImageView);
      ((URLDrawable)localObject1).setURLDrawableListener(new EmojiFragment.TempListItem.2(this, paramTemplateInfo));
    }
    for (;;)
    {
      if (paramTemplateInfo.isSelected) {
        this.this$0.onTempSelected(paramTemplateInfo, this.mImageView);
      }
      return;
      label230:
      if ((((URLDrawable)localObject1).getStatus() == 1) || (((URLDrawable)localObject1).getStatus() == 0)) {
        break;
      }
      ((URLDrawable)localObject1).restartDownload();
      break;
      label252:
      this.mImageView.setImageDrawable(null);
      this.mLoadingView.setBackgroundDrawable(getResources().getDrawable(2130842849));
      this.mCornerImageView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.emoj.EmojiFragment.TempListItem
 * JD-Core Version:    0.7.0.1
 */