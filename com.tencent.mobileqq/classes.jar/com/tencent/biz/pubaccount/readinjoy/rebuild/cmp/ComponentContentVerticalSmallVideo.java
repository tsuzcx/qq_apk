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
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.common.ApiCompatibilityUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell.CellListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo.PackArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import cooperation.readinjoy.ReadInJoyHelper.VideoPackSetting;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ComponentContentVerticalSmallVideo
  extends ComponentContentBig
{
  Pair<Integer, Integer> jdField_a_of_type_AndroidUtilPair;
  View jdField_a_of_type_AndroidViewView;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public boolean a;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  KandianUrlImageView jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  KandianUrlImageView jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  TextView d;
  TextView e;
  
  public ComponentContentVerticalSmallVideo(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public ComponentContentVerticalSmallVideo(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public ComponentContentVerticalSmallVideo(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = false;
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
          this.e.setTextColor(Color.parseColor("#ffffff"));
          ApiCompatibilityUtils.a(this.e, a(Color.parseColor(str), getContext()));
          this.e.setText(localArticleInfo.mVideoArticleSubsText);
          this.e.setVisibility(0);
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
          this.e.setTextColor(Color.parseColor("#ffffff"));
          ApiCompatibilityUtils.a(this.e, a(Color.parseColor("#FE6c6c"), getContext()));
        }
      }
    }
    this.e.setVisibility(8);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560251, this, true);
  }
  
  public URL a(IReadInJoyModel paramIReadInJoyModel)
  {
    URL localURL = null;
    Object localObject = paramIReadInJoyModel.a();
    if (ComponentPolymericView.a(paramIReadInJoyModel))
    {
      paramIReadInJoyModel = ((NewPolymericInfo.PackArticleInfo)((ArticleInfo)localObject).mNewPolymericInfo.a.get(0)).c;
      if (QLog.isColorLevel()) {
        QLog.d("PolymericSmallVideo_ComponentContentVerticalSmallVideo", 1, "getUrl new polymeric video cover rawUrl = " + paramIReadInJoyModel);
      }
      localURL = ((ArticleInfo)localObject).getVideoCoverUrlWithSmartCut(((Integer)this.jdField_a_of_type_AndroidUtilPair.first).intValue(), ((Integer)this.jdField_a_of_type_AndroidUtilPair.second).intValue(), paramIReadInJoyModel);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("getUrl new polymeric video cover after smartcut url = ");
        if (localURL != null)
        {
          paramIReadInJoyModel = localURL.getFile();
          QLog.d("PolymericSmallVideo_ComponentContentVerticalSmallVideo", 1, paramIReadInJoyModel);
        }
      }
      else
      {
        paramIReadInJoyModel = localURL;
      }
    }
    do
    {
      return paramIReadInJoyModel;
      paramIReadInJoyModel = null;
      break;
      paramIReadInJoyModel = ((ArticleInfo)localObject).getVideoCoverURL();
      if (paramIReadInJoyModel == null) {
        break label277;
      }
      paramIReadInJoyModel = paramIReadInJoyModel.getFile();
      if (QLog.isColorLevel()) {
        QLog.d("PolymericSmallVideo_ComponentContentVerticalSmallVideo", 1, "getUrl old polymeric video cover rawUrl = " + paramIReadInJoyModel);
      }
      localObject = ((ArticleInfo)localObject).getVideoCoverUrlWithSmartCut(((Integer)this.jdField_a_of_type_AndroidUtilPair.first).intValue(), ((Integer)this.jdField_a_of_type_AndroidUtilPair.second).intValue(), paramIReadInJoyModel);
      paramIReadInJoyModel = (IReadInJoyModel)localObject;
    } while (!QLog.isColorLevel());
    StringBuilder localStringBuilder = new StringBuilder().append("getUrl old polymeric video cover after smartcut url = ");
    paramIReadInJoyModel = localURL;
    if (localObject != null) {
      paramIReadInJoyModel = ((URL)localObject).getFile();
    }
    QLog.d("PolymericSmallVideo_ComponentContentVerticalSmallVideo", 1, paramIReadInJoyModel);
    return localObject;
    label277:
    return ((ArticleInfo)localObject).getVideoCoverURL();
  }
  
  public void a(View paramView)
  {
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131368803));
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131368802));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364454));
    this.d = ((TextView)paramView.findViewById(2131365061));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131381438));
    this.e = ((TextView)paramView.findViewById(2131378714));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131368804);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131377376));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373255));
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a(paramCellListener);
  }
  
  public void a(Object paramObject)
  {
    IReadInJoyModel localIReadInJoyModel;
    if ((paramObject instanceof IReadInJoyModel))
    {
      localIReadInJoyModel = (IReadInJoyModel)paramObject;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a(localIReadInJoyModel);
      if (localIReadInJoyModel.f() != 1) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      paramObject = localIReadInJoyModel.a();
      if (paramObject != null) {
        break;
      }
      return;
    }
    if (RIJFeedsType.g(paramObject))
    {
      this.jdField_a_of_type_AndroidUtilPair = new Pair(Integer.valueOf(AIOUtils.a(165.0F, getResources())), Integer.valueOf(AIOUtils.a(293.0F, getResources())));
      findViewById(2131365692).setVisibility(8);
    }
    for (;;)
    {
      b();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.e() == 56)
      {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setForeground(getResources().getDrawable(2130843393));
        label148:
        if (!this.jdField_a_of_type_Boolean) {
          break label411;
        }
        Object localObject = ReadInJoyDisplayUtils.a(1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.e());
        localObject = URLDrawable.getDrawable(a(localIReadInJoyModel), ((Integer)((Pair)localObject).first).intValue(), ((Integer)((Pair)localObject).second).intValue(), new ColorDrawable(-1447447), new ColorDrawable(-1447447));
        ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.u);
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageDrawable((Drawable)localObject);
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImagePlaceHolder(new ColorDrawable(-1447447));
      }
      try
      {
        this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImage(a(localIReadInJoyModel));
        if (RIJFeedsType.g(paramObject))
        {
          this.d.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          c();
          return;
          if (this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_AndroidUtilPair = ReadInJoyDisplayUtils.a(3, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.e());
            continue;
          }
          this.jdField_a_of_type_AndroidUtilPair = ReadInJoyDisplayUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.f(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.e());
          continue;
          this.jdField_a_of_type_AndroidWidgetFrameLayout.setForeground(null);
          break label148;
          label411:
          this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("PolymericSmallVideo_ComponentContentVerticalSmallVideo", 1, "bindData setVideoCover failed. Exception e = " + localException);
          continue;
          ReadInJoyHelper.VideoPackSetting localVideoPackSetting = ReadInJoyHelper.a(BaseApplicationImpl.getApplication().getRuntime());
          if ((localVideoPackSetting != null) && (localVideoPackSetting.jdField_a_of_type_Boolean))
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.a(3.0F, getResources()));
            this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130849740, 0, 0, 0);
            label521:
            if ((localVideoPackSetting == null) || (localVideoPackSetting.b)) {
              break label585;
            }
            this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          for (;;)
          {
            if ((localVideoPackSetting == null) || (localVideoPackSetting.c)) {
              break label658;
            }
            this.d.setVisibility(8);
            this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            break;
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            break label521;
            label585:
            if ((localVideoPackSetting != null) && (localVideoPackSetting.jdField_a_of_type_Int > 0)) {
              this.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(localVideoPackSetting.jdField_a_of_type_Int);
            }
            if (RIJItemViewType.q(paramObject)) {
              this.jdField_b_of_type_AndroidWidgetTextView.setText(paramObject.mTitle);
            } else {
              this.jdField_b_of_type_AndroidWidgetTextView.setText(((SocializeFeedsInfo.UGCVideoInfo)paramObject.mSocialFeedInfo.a.b.get(0)).e);
            }
          }
          label658:
          this.d.setText(getResources().getString(2131718138, new Object[] { paramObject.getCommentCount() + "" }));
          if (paramObject.mVideoPlayCount <= 0) {
            this.jdField_c_of_type_AndroidWidgetTextView.setText("0");
          } else {
            this.jdField_c_of_type_AndroidWidgetTextView.setText(VideoFeedsHelper.c(paramObject.mVideoPlayCount));
          }
        }
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentVerticalSmallVideo
 * JD-Core Version:    0.7.0.1
 */