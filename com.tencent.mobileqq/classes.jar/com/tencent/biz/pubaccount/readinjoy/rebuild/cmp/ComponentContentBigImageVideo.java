package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.preparse.RIJPreParseData;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJSmartCropUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianRoundCornerTextView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class ComponentContentBigImageVideo
  extends ComponentContentBig
{
  private ImageView a;
  private TextView b;
  private TextView c;
  
  public ComponentContentBigImageVideo(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentContentBigImageVideo(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentContentBigImageVideo(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560236, this, true);
  }
  
  public URL a(IReadInJoyModel paramIReadInJoyModel)
  {
    Object localObject1 = paramIReadInJoyModel.a();
    Object localObject2;
    if (paramIReadInJoyModel.a() == 51)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ComponentContentBigImageVideo", 2, "PolymericArticle use first page url");
      }
      if ((RIJFeedsType.g((BaseArticleInfo)localObject1)) && (((ArticleInfo)localObject1).mSinglePicture != null) && (((ArticleInfo)localObject1).mNewPolymericInfo != null) && (!((ArticleInfo)localObject1).mNewPolymericInfo.b))
      {
        paramIReadInJoyModel = ((ArticleInfo)localObject1).mSinglePicture.getFile();
        localObject2 = ReadInJoyDisplayUtils.f();
        paramIReadInJoyModel = RIJSmartCropUtils.a(paramIReadInJoyModel, ((Integer)((Pair)localObject2).first).intValue(), ((Integer)((Pair)localObject2).second).intValue());
        ((ArticleInfo)localObject1).mSinglePicture = RIJPreParseData.a(paramIReadInJoyModel);
        ((ArticleInfo)localObject1).mNewPolymericInfo.b = true;
        if (QLog.isColorLevel()) {
          QLog.e("ComponentContentBigImageVideo", 2, " handled url = " + paramIReadInJoyModel);
        }
      }
      paramIReadInJoyModel = ((ArticleInfo)localObject1).mSinglePicture;
      return paramIReadInJoyModel;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams() != null))
    {
      localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
      int i = ((ViewGroup.LayoutParams)localObject2).width;
      int j = ((ViewGroup.LayoutParams)localObject2).height;
      if (i == j) {
        localObject1 = ((ArticleInfo)localObject1).getVideoCoverWithSmartCut(i, j);
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label306;
        }
        paramIReadInJoyModel = (IReadInJoyModel)localObject1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ComponentContentBigImageVideo", 2, "cut url : " + localObject1 + " width:" + i + "    height:" + j);
        return localObject1;
        if (i > j) {
          localObject1 = ((ArticleInfo)localObject1).getVideoCoverUrlWithSmartCut(false);
        } else {
          localObject1 = ((ArticleInfo)localObject1).getVideoCoverUrlWithSmartCut(true);
        }
      }
    }
    label306:
    return super.a(paramIReadInJoyModel);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.b = ((TextView)paramView.findViewById(2131366079));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373255));
    this.c = ((TextView)paramView.findViewById(2131382092));
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof IReadInJoyModel))
    {
      paramObject = ((IReadInJoyModel)paramObject).a();
      if (paramObject != null) {
        if (((RIJItemViewType.g(paramObject)) || (RIJItemViewType.i(paramObject)) || (RIJItemViewType.j(paramObject)) || (RIJItemViewType.k(paramObject))) && ((RIJItemViewType.q(paramObject)) && (!RIJItemViewType.a(paramObject)) && (!RIJItemViewType.d(paramObject)))) {
          break label118;
        }
      }
    }
    while ((NetworkUtil.h(getContext())) || (Aladdin.getConfig(299).getIntegerFromString("rij_main_feeds_tips_off", 0) == 1))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.c.setVisibility(4);
      return;
      label118:
      if (RIJFeedsType.g(paramObject))
      {
        this.b.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(8);
      }
      else
      {
        this.b.setText(ReadInJoyDisplayUtils.a(paramObject.mVideoDuration));
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.c.setVisibility(0);
    Drawable localDrawable = getContext().getResources().getDrawable(2130843379);
    this.c.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
    this.c.setCompoundDrawablePadding(AIOUtils.a(6.0F, getContext().getResources()));
    this.c.setVisibility(0);
    if (CUKingCardHelper.a() == 1)
    {
      this.c.setText(HardCodeUtil.a(2131702314));
      return;
    }
    if (paramObject.mXGFileSize > 0L)
    {
      this.c.setText(VideoFeedsHelper.b(paramObject.mXGFileSize) + HardCodeUtil.a(2131702367));
      return;
    }
    this.c.setText(HardCodeUtil.a(2131702399));
  }
  
  public void b()
  {
    super.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentBigImageVideo
 * JD-Core Version:    0.7.0.1
 */