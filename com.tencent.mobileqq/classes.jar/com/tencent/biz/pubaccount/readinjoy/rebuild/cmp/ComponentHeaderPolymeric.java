package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyTimeUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyModelImpl;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell.CellListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.PolymericInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.Base64Util;
import java.util.ArrayList;
import java.util.List;
import lvp;
import lvq;
import lvs;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class ComponentHeaderPolymeric
  extends ComponentHeaderBase
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected ReadInJoyObserver a;
  private ReadInJoyHeadImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView;
  private ReadInJoyNickNameTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  
  public ComponentHeaderPolymeric(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new lvs(this);
  }
  
  public ComponentHeaderPolymeric(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new lvs(this);
  }
  
  public ComponentHeaderPolymeric(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new lvs(this);
  }
  
  private void a(BaseArticleInfo paramBaseArticleInfo)
  {
    PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8008F55", "0X8008F55", 0, 0, "", "", "", ReadInJoyUtils.a(paramBaseArticleInfo.mPolymericInfo).toString(), false);
    if (ReadInJoyUtils.e(paramBaseArticleInfo))
    {
      BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)paramBaseArticleInfo.mGroupSubArticleList.get(0);
      String str = ReadinjoyReportUtils.a(getContext(), localBaseArticleInfo.mArticleID, localBaseArticleInfo.mAlgorithmID, 54, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(), localBaseArticleInfo.getInnerUniqueID(), localBaseArticleInfo.getVideoVid(), ReadinjoyReportUtils.a(localBaseArticleInfo));
      PublicAccountReportUtils.a(null, "CliOper", "", String.valueOf(paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long), "0X8007625", "0X8007625", 0, 0, Long.toString(localBaseArticleInfo.mFeedId), String.valueOf(localBaseArticleInfo.mArticleID), Integer.toString(localBaseArticleInfo.mStrategyId), str, false);
      return;
    }
    ReadInJoyBaseAdapter.a((ArticleInfo)paramBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a());
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2130969580, this, true);
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(long paramLong, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_Long != paramLong) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImageBitmap(paramBitmap);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131366817);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramView.findViewById(2131367040));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367041));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramView.findViewById(2131367039));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367025));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367042));
    this.c = ((TextView)paramView.findViewById(2131367043));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367024));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131362840);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setOnClickListener(this);
    this.c.setOnClickListener(this);
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    super.a(paramCellListener);
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    ArticleInfo localArticleInfo = ((IReadInJoyModel)paramObject).a();
    Object localObject1;
    Object localObject2;
    if ((localArticleInfo != null) && (localArticleInfo.mPolymericInfo != null))
    {
      if (localArticleInfo.mPolymericInfo.jdField_a_of_type_Long <= 0L) {
        break label306;
      }
      localObject1 = ReadInJoyTimeUtils.a(localArticleInfo.mPolymericInfo.jdField_a_of_type_Long, true);
      localObject2 = localObject1;
      if (!TextUtils.isEmpty(localArticleInfo.mPolymericInfo.jdField_b_of_type_JavaLangString)) {
        localObject2 = (String)localObject1 + " " + localArticleInfo.mPolymericInfo.jdField_b_of_type_JavaLangString;
      }
      if (localArticleInfo.mPolymericInfo.jdField_a_of_type_Int != 10) {
        break label314;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setVisibility(8);
      label147:
      switch (localArticleInfo.mPolymericInfo.jdField_a_of_type_Int)
      {
      case 7: 
      case 8: 
      default: 
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(localArticleInfo.mPolymericInfo.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        this.jdField_a_of_type_Long = 0L;
        if (!TextUtils.isEmpty(localArticleInfo.mPolymericInfo.c))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.a(ReadInJoyUtils.a(localArticleInfo.mPolymericInfo.c));
          localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView;
          if (localArticleInfo.mPolymericInfo.jdField_b_of_type_Int != 0) {
            break label843;
          }
        }
        break;
      }
    }
    label306:
    label314:
    label843:
    for (boolean bool = true;; bool = false)
    {
      ((ReadInJoyHeadImageView)localObject1).setRound(bool);
      for (;;)
      {
        if ((localArticleInfo != null) && (!localArticleInfo.mGroupSubArticleList.isEmpty()) && (localArticleInfo.mPolymericInfo != null)) {
          break label848;
        }
        return;
        localObject1 = "刚刚";
        break;
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setVisibility(0);
        break label147;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(localArticleInfo.mPolymericInfo.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        this.jdField_a_of_type_Long = localArticleInfo.mPolymericInfo.jdField_b_of_type_Long;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImageDrawable(SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, String.valueOf(this.jdField_a_of_type_Long), 1));
        continue;
        localObject2 = localArticleInfo.mPolymericInfo.jdField_a_of_type_JavaLangString;
        if (((String)localObject2).startsWith("#"))
        {
          localObject1 = localObject2;
          if (!((String)localObject2).startsWith("# ")) {
            localObject1 = "# " + ((String)localObject2).substring(1);
          }
          localObject1 = new SpannableString((CharSequence)localObject1);
          ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(getResources().getColor(2131493399)), 0, 1, 33);
          ((SpannableString)localObject1).setSpan(new ImageSpan(getContext(), 2130840800), 1, 2, 33);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText((CharSequence)localObject1);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(localArticleInfo.mPolymericInfo.jdField_b_of_type_JavaLangString);
          this.jdField_a_of_type_Long = 0L;
          if (TextUtils.isEmpty(localArticleInfo.mPolymericInfo.c)) {
            break;
          }
          localObject1 = URLDrawable.URLDrawableOptions.obtain();
          localObject2 = new ColorDrawable(0);
          ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2);
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
          localObject1 = URLDrawable.getDrawable(ReadInJoyUtils.a(localArticleInfo.mPolymericInfo.c), (URLDrawable.URLDrawableOptions)localObject1);
          ((URLDrawable)localObject1).setTag(URLDrawableDecodeHandler.a(72, 72, DisplayUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.getContext(), 2.0F)));
          ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.g);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImageDrawable((Drawable)localObject1);
          break;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(localArticleInfo.mPolymericInfo.jdField_a_of_type_JavaLangString);
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(localArticleInfo.mPolymericInfo.jdField_b_of_type_JavaLangString);
        continue;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localArticleInfo.mPolymericInfo.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_Long = localArticleInfo.mPolymericInfo.jdField_b_of_type_Long;
        if ((localArticleInfo.mGroupSubArticleList != null) && (localArticleInfo.mGroupSubArticleList.size() > 0))
        {
          localObject1 = (BaseArticleInfo)localArticleInfo.mGroupSubArticleList.get(0);
          if (((localObject1 instanceof ArticleInfo)) && (ReadInJoyBaseAdapter.m((ArticleInfo)localObject1)))
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(localArticleInfo.mPolymericInfo.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImageDrawable(SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, String.valueOf(this.jdField_a_of_type_Long), 1));
          }
          else
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(this.jdField_a_of_type_Long);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setNickNameByUin(this.jdField_a_of_type_Long);
          }
        }
      }
    }
    label848:
    int i;
    if ((localArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 11) && ((localArticleInfo.mGroupSubArticleList.get(0) instanceof ArticleInfo)) && (ReadInJoyBaseAdapter.o((ArticleInfo)localArticleInfo.mGroupSubArticleList.get(0))))
    {
      localObject1 = ((BaseArticleInfo)localArticleInfo.mGroupSubArticleList.get(0)).mSocialFeedInfo;
      if ((localObject1 == null) || (((SocializeFeedsInfo)localObject1).a == null))
      {
        this.c.setVisibility(8);
        return;
      }
      if (((SocializeFeedsInfo)localObject1).h == 2)
      {
        i = 1;
        this.c.setTag(String.valueOf(((SocializeFeedsInfo)localObject1).a.jdField_a_of_type_Long));
        if (((SocializeFeedsInfo)localObject1).a == null) {
          break label1142;
        }
        if (((SocializeFeedsInfo)localObject1).a.jdField_a_of_type_Int != 1) {
          break label1130;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    for (;;)
    {
      label997:
      this.c.setEnabled(true);
      if (i == 0)
      {
        this.c.setVisibility(0);
        this.c.setTextColor(getResources().getColor(2131493399));
        this.c.setText("关注");
        label1044:
        localObject1 = (LinearLayout.LayoutParams)this.c.getLayoutParams();
        if (!a()) {
          break label1388;
        }
      }
      label1130:
      label1388:
      for (((LinearLayout.LayoutParams)localObject1).rightMargin = DisplayUtil.a(getContext(), 12.0F);; ((LinearLayout.LayoutParams)localObject1).rightMargin = DisplayUtil.a(getContext(), 0.0F))
      {
        this.c.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        if (!(paramObject instanceof ReadInJoyModelImpl)) {
          break label1414;
        }
        if ((((ReadInJoyModelImpl)paramObject).e() != 56) || (((ReadInJoyModelImpl)paramObject).jdField_b_of_type_Int == 0)) {
          break label1404;
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        return;
        i = 0;
        break;
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break label997;
        label1142:
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break label997;
        if ((localArticleInfo.mPolymericInfo.jdField_a_of_type_Int != 9) || (((BaseArticleInfo)localArticleInfo.mGroupSubArticleList.get(0)).mTopicRecommendFeedsInfo == null) || (!(localArticleInfo.mGroupSubArticleList.get(0) instanceof ArticleInfo)) || (!ReadInJoyBaseAdapter.o((ArticleInfo)localArticleInfo.mGroupSubArticleList.get(0)))) {
          break label1424;
        }
        localObject1 = (TopicRecommendFeedsInfo.TopicRecommendInfo)((BaseArticleInfo)localArticleInfo.mGroupSubArticleList.get(0)).mTopicRecommendFeedsInfo.a.get(0);
        localObject2 = ReadInJoyLogicEngine.a().a(((ReadInJoyModelImpl)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a).jdField_a_of_type_Int, ((BaseArticleInfo)localArticleInfo.mGroupSubArticleList.get(0)).mRecommendSeq);
        if ((localObject2 != null) && (((ArticleInfo)localObject2).mTopicRecommendFeedsInfo != null) && (((ArticleInfo)localObject2).mTopicRecommendFeedsInfo.a.get(0) != null)) {
          ((TopicRecommendFeedsInfo.TopicRecommendInfo)localObject1).c = ((TopicRecommendFeedsInfo.TopicRecommendInfo)((ArticleInfo)localObject2).mTopicRecommendFeedsInfo.a.get(0)).c;
        }
        if (((TopicRecommendFeedsInfo.TopicRecommendInfo)localObject1).c == 1) {}
        for (i = 1;; i = 0)
        {
          this.c.setTag(String.valueOf(((TopicRecommendFeedsInfo.TopicRecommendInfo)localObject1).jdField_a_of_type_Int));
          break;
        }
        this.c.setVisibility(8);
        break label1044;
      }
      label1404:
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      return;
      label1414:
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      return;
      label1424:
      i = 1;
    }
  }
  
  public boolean a()
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a();
    if ((localArticleInfo != null) && (localArticleInfo.mPolymericInfo != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a instanceof ReadInJoyModelImpl)))
    {
      ReadInJoyModelImpl localReadInJoyModelImpl = (ReadInJoyModelImpl)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a;
      int i = localArticleInfo.mPolymericInfo.jdField_a_of_type_Int;
      if (((i == 9) || (i == 10) || (i == 11)) && (localReadInJoyModelImpl.jdField_a_of_type_Int == 56)) {
        return true;
      }
    }
    return super.a();
  }
  
  protected void d()
  {
    AppRuntime localAppRuntime = ReadInJoyUtils.a();
    if (localAppRuntime != null)
    {
      ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a();
      ReadInJoyBaseAdapter.a(localArticleInfo, "0X80080EC", "0X80080EC", 70);
      ReadInJoyLogicEngine.b(localArticleInfo);
      SocializeFeedsInfo localSocializeFeedsInfo = ((BaseArticleInfo)localArticleInfo.mGroupSubArticleList.get(0)).mSocialFeedInfo;
      if (localSocializeFeedsInfo != null)
      {
        long l = localSocializeFeedsInfo.a.jdField_a_of_type_Long;
        ReadInJoyLogicEngine.a().a().a(localAppRuntime.getAccount(), String.valueOf(l), true, new lvp(this, localSocializeFeedsInfo, localArticleInfo), 1);
      }
    }
  }
  
  protected void e()
  {
    Object localObject = ReadInJoyUtils.a();
    TopicRecommendFeedsInfo.TopicRecommendInfo localTopicRecommendInfo = (TopicRecommendFeedsInfo.TopicRecommendInfo)((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mGroupSubArticleList.get(0)).mTopicRecommendFeedsInfo.a.get(0);
    localObject = ((AppRuntime)localObject).getAccount();
    ReadInJoyLogicEngine.a().a().a((String)localObject, Long.toString(localTopicRecommendInfo.jdField_a_of_type_Int), true, new lvq(this, localTopicRecommendInfo), 3);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
  }
  
  public void onClick(View paramView)
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a();
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      switch (localArticleInfo.mPolymericInfo.jdField_a_of_type_Int)
      {
      }
      for (;;)
      {
        a(localArticleInfo);
        return;
        paramView = ReadInJoyConstants.f + Base64Util.encodeToString(String.valueOf(localArticleInfo.mPolymericInfo.jdField_b_of_type_Long).getBytes(), 2);
        ReadInJoyUtils.a(getContext(), paramView);
        continue;
        paramView = ReadInJoyConstants.i + Base64Util.encodeToString(String.valueOf(localArticleInfo.mPolymericInfo.jdField_b_of_type_Long).getBytes(), 2);
        ReadInJoyUtils.a(getContext(), paramView);
        continue;
        ReadInJoyUtils.a(getContext(), localArticleInfo.mPolymericInfo.d);
      }
      if (localArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 11)
      {
        d();
        return;
      }
    } while (localArticleInfo.mPolymericInfo.jdField_a_of_type_Int != 9);
    e();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderPolymeric
 * JD-Core Version:    0.7.0.1
 */