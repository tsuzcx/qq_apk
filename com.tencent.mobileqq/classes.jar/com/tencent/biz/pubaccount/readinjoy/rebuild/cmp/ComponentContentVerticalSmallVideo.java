package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.common.ApiCompatibilityUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell.CellListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.util.PubAccountHttpDownloader;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class ComponentContentVerticalSmallVideo
  extends ComponentContentBig
{
  Pair jdField_a_of_type_AndroidUtilPair;
  View jdField_a_of_type_AndroidViewView;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public boolean a;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  KandianUrlImageView jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  KandianUrlImageView jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  TextView d;
  
  public ComponentContentVerticalSmallVideo(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentContentVerticalSmallVideo(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentContentVerticalSmallVideo(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static ShapeDrawable a(int paramInt, Context paramContext)
  {
    int i = DisplayUtil.a(paramContext, 2.0F);
    paramContext = new ShapeDrawable(new RoundRectShape(new float[] { i, i, i, i, i, i, i, i }, null, null));
    paramContext.getPaint();
    paramContext.getPaint().setColor(paramInt);
    return paramContext;
  }
  
  @SuppressLint({"Range"})
  private void c()
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a();
    if (localArticleInfo == null) {
      return;
    }
    if (!TextUtils.isEmpty(localArticleInfo.mVideoArticleSubsText))
    {
      String str;
      if (TextUtils.isEmpty(localArticleInfo.mVideoArticleSubsColor)) {
        str = "#FE6c6c";
      }
      try
      {
        for (;;)
        {
          this.d.setTextColor(Color.parseColor("#ffffff"));
          ApiCompatibilityUtils.a(this.d, a(Color.parseColor(str), getContext()));
          this.d.setText(localArticleInfo.mVideoArticleSubsText);
          this.d.setVisibility(0);
          return;
          str = localArticleInfo.mVideoArticleSubsColor;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("PolymericSmallVideo_ComponentContentVerticalSmallVideo", 2, "configDefaultItem: ", localException);
          }
          this.d.setTextColor(Color.parseColor("#ffffff"));
          ApiCompatibilityUtils.a(this.d, a(Color.parseColor("#FE6c6c"), getContext()));
        }
      }
    }
    this.d.setVisibility(8);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2130969568, this, true);
  }
  
  public URL a(IReadInJoyModel paramIReadInJoyModel)
  {
    paramIReadInJoyModel = paramIReadInJoyModel.a();
    if (ReadInJoyUtils.b(paramIReadInJoyModel.mSinglePicture.getFile())) {
      paramIReadInJoyModel.mSinglePicture = PubAccountHttpDownloader.a(ReadInJoyUtils.b(paramIReadInJoyModel.mSinglePicture.getFile(), ((Integer)this.jdField_a_of_type_AndroidUtilPair.second).intValue(), ((Integer)this.jdField_a_of_type_AndroidUtilPair.first).intValue(), 3), 3);
    }
    return paramIReadInJoyModel.mSinglePicture;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131366972));
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131366929));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366974));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366977));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366976));
    this.d = ((TextView)paramView.findViewById(2131366835));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131366973);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131362693));
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a(paramCellListener);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      paramObject = (IReadInJoyModel)paramObject;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a(paramObject);
      if (paramObject.f() != 1) {
        break label49;
      }
    }
    ArticleInfo localArticleInfo;
    label49:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      localArticleInfo = paramObject.a();
      if (localArticleInfo != null) {
        break;
      }
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidUtilPair = ReadInJoyDisplayUtils.a(3, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.e());
      b();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.e() != 56) {
        break label418;
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setForeground(getResources().getDrawable(2130840845));
      label118:
      if (!this.jdField_a_of_type_Boolean) {
        break label429;
      }
      Object localObject = ReadInJoyDisplayUtils.a(1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.e());
      localObject = URLDrawable.getDrawable(a(paramObject), ((Integer)((Pair)localObject).first).intValue(), ((Integer)((Pair)localObject).second).intValue(), new ColorDrawable(-1447447), new ColorDrawable(-1447447));
      ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.o);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageDrawable((Drawable)localObject);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      label228:
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(-1447447);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(-1447447);
      paramObject = URLDrawable.getDrawable(a(paramObject).getFile(), (URLDrawable.URLDrawableOptions)localObject);
      paramObject.setTag(URLDrawableDecodeHandler.a(((Integer)this.jdField_a_of_type_AndroidUtilPair.first).intValue(), ((Integer)this.jdField_a_of_type_AndroidUtilPair.second).intValue()));
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageDrawable(paramObject);
      if (localArticleInfo.mVideoCommentCount != 0) {
        break label450;
      }
    }
    label418:
    label429:
    label450:
    for (paramObject = "0";; paramObject = VideoFeedsHelper.c(localArticleInfo.mVideoCommentCount))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(getResources().getString(2131439297, new Object[] { paramObject }));
      this.jdField_b_of_type_AndroidWidgetTextView.setText(VideoFeedsHelper.c(localArticleInfo.mVideoPlayCount));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localArticleInfo.mSummary);
      c();
      return;
      this.jdField_a_of_type_AndroidUtilPair = ReadInJoyDisplayUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.f(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.e());
      break;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setForeground(null);
      break label118;
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      break label228;
    }
  }
  
  public void b()
  {
    ViewGroup.LayoutParams localLayoutParams = this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
    localLayoutParams.width = ((Integer)this.jdField_a_of_type_AndroidUtilPair.first).intValue();
    localLayoutParams.height = ((Integer)this.jdField_a_of_type_AndroidUtilPair.second).intValue();
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentVerticalSmallVideo
 * JD-Core Version:    0.7.0.1
 */