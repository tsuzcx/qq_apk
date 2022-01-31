package com.tencent.biz.pubaccount.readinjoy.rebuild;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class FeedItemCellTypeNow
  extends FeedItemCell
  implements View.OnClickListener
{
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private View jdField_b_of_type_AndroidViewView;
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  
  public FeedItemCellTypeNow(Context paramContext, FaceDecoder paramFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  private TextView a(int paramInt)
  {
    TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    localTextView.setId(2131362207);
    localTextView.setTextSize(2, 11.0F);
    localTextView.setGravity(17);
    localTextView.setText("直播");
    localTextView.setWidth(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 30.0F));
    localTextView.setHeight(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 17.0F));
    if (paramInt == 0)
    {
      localTextView.setTextColor(Color.argb(255, 255, 255, 255));
      localTextView.setBackgroundResource(2130845415);
      return localTextView;
    }
    localTextView.setTextColor(-89258);
    localTextView.setBackgroundResource(2130845416);
    return localTextView;
  }
  
  public FeedItemCell a()
  {
    this.jdField_a_of_type_Boolean = true;
    return this;
  }
  
  public FeedItemCell d()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130969643, localRelativeLayout, true);
    this.jdField_d_of_type_AndroidViewView = localView.findViewById(2131367257);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131367258));
    this.jdField_b_of_type_AndroidViewView = localView.findViewById(2131365227);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)localView.findViewById(2131366378));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131361926));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367259));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131363385));
    this.jdField_c_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
    localLayoutParams.gravity = 16;
    this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(2, 12.0F);
    this.jdField_c_of_type_AndroidWidgetTextView.setId(2131362204);
    ((FrameLayout)localView.findViewById(2131367263)).addView(this.jdField_c_of_type_AndroidWidgetTextView, localLayoutParams);
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131367261));
    this.jdField_c_of_type_AndroidViewView = localView.findViewById(2131367265);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367260));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localView.findViewById(2131367262));
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localView.findViewById(2131367264));
    a(localRelativeLayout);
    return this;
  }
  
  public FeedItemCell e()
  {
    return this;
  }
  
  public FeedItemCell o()
  {
    IReadInJoyModel localIReadInJoyModel;
    ArticleInfo localArticleInfo;
    if ((this.jdField_a_of_type_JavaLangObject instanceof IReadInJoyModel))
    {
      localIReadInJoyModel = (IReadInJoyModel)this.jdField_a_of_type_JavaLangObject;
      localArticleInfo = localIReadInJoyModel.a();
      if (localArticleInfo != null) {}
    }
    else
    {
      return this;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FeedItemCellTypeNow", 2, "bindData articleId = " + localArticleInfo.mArticleID + "roomId = " + localArticleInfo.mSubscribeID);
    }
    Object localObject1 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).width = ScreenUtil.a;
    ((RelativeLayout.LayoutParams)localObject1).height = (((RelativeLayout.LayoutParams)localObject1).width * 9 / 16);
    this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
    if (localArticleInfo.mVideoCoverUrl != null)
    {
      localObject1 = localArticleInfo.mVideoCoverUrl;
      ReadInJoyDisplayUtils.a((KandianUrlImageView)localObject2, (URL)localObject1, this.jdField_a_of_type_AndroidContentContext, true);
      if (jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        jdField_a_of_type_AndroidGraphicsDrawableDrawable = ImageUtil.b();
      }
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.jdField_a_of_type_ComTencentImageURLImageView.getWidth();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.jdField_a_of_type_ComTencentImageURLImageView.getHeight();
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    }
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(localArticleInfo.thirdIcon)) {
          continue;
        }
        localObject1 = new URL("https://q.url.cn/s/jBJuV");
        localObject1 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
        ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.a);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
      }
      catch (MalformedURLException localMalformedURLException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FeedItemCellTypeNow", 2, "configVideoItemUI() ERROR e = " + localMalformedURLException.getMessage());
        continue;
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localArticleInfo.mTitle);
        this.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-8947849);
        this.jdField_c_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.jdField_b_of_type_AndroidWidgetFrameLayout.removeAllViews();
        this.jdField_b_of_type_AndroidWidgetFrameLayout.addView(a(56), localLayoutParams);
        if (localArticleInfo.mVideoPlayCount != 0) {
          break label766;
        }
      }
      localObject2 = localArticleInfo.mSubscribeName;
      localObject1 = localObject2;
      if (((String)localObject2).length() > 18) {
        localObject1 = localArticleInfo.mSubscribeName.substring(0, 17) + "…";
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      if (localIReadInJoyModel.e() == 0)
      {
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(localArticleInfo.mTitle);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.argb(255, 157, 157, 157));
        localObject1 = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject1).setMargins(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.0F), 0, 0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 2.0F));
        ((FrameLayout.LayoutParams)localObject1).gravity = 16;
        this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(a(0), (ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(this.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingLeft(), 0, this.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingRight(), this.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingBottom());
        localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 47.0F);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(this.jdField_a_of_type_AndroidWidgetLinearLayout.getResources().getColor(2131492969));
        return this;
        if (localArticleInfo.mSinglePicture != null)
        {
          localObject1 = localArticleInfo.mSinglePicture;
          break;
        }
        localObject1 = ReadInJoyUtils.a(localArticleInfo.mFirstPagePicUrl);
        break;
        localObject1 = new URL(localArticleInfo.thirdIcon);
        continue;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      return this;
      label766:
      this.jdField_b_of_type_AndroidWidgetTextView.setText(VideoFeedsHelper.c(localArticleInfo.mVideoPlayCount));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCellTypeNow
 * JD-Core Version:    0.7.0.1
 */