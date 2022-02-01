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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyTimeUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.preparse.RIJPreParseData;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus;
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
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
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
  private boolean jdField_a_of_type_Boolean = true;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  
  public ComponentHeaderPolymeric(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new ComponentHeaderPolymeric.6(this);
  }
  
  public ComponentHeaderPolymeric(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new ComponentHeaderPolymeric.6(this);
  }
  
  public ComponentHeaderPolymeric(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new ComponentHeaderPolymeric.6(this);
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 1)
    {
      a(false);
      QQToast.a(getContext(), HardCodeUtil.a(2131702373), 0).a();
    }
    while (paramInt != 2) {
      return;
    }
    a(true);
    QQToast.a(getContext(), HardCodeUtil.a(2131702378), 0).a();
  }
  
  private void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    paramArticleInfo.mPolymericInfo.e = paramInt;
    Object localObject = ((BaseArticleInfo)paramArticleInfo.mGroupSubArticleList.get(0)).mSocialFeedInfo;
    if (localObject != null) {
      ((SocializeFeedsInfo)localObject).h = paramInt;
    }
    localObject = ReadInJoyLogicEngineEventDispatcher.a();
    long l = paramArticleInfo.mPolymericInfo.jdField_b_of_type_Long;
    if (paramArticleInfo.mPolymericInfo.e == 2) {}
    for (boolean bool = true;; bool = false)
    {
      ((ReadInJoyLogicEngineEventDispatcher)localObject).b(l, bool);
      ThreadManager.post(new ComponentHeaderPolymeric.5(this, paramArticleInfo, paramInt), 5, null, true);
      return;
    }
  }
  
  private void a(AppRuntime paramAppRuntime, String paramString, ArticleInfo paramArticleInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentHeaderPolymeric", 2, "followUGCAccount followUin = " + paramString + ", followStatus = " + paramArticleInfo.mPolymericInfo.e + ", articleInfoID = " + paramArticleInfo.mArticleID);
    }
    UserOperationModule localUserOperationModule = ReadInJoyLogicEngine.a().a();
    paramAppRuntime = paramAppRuntime.getAccount();
    if (paramArticleInfo.mPolymericInfo.e != 2) {}
    for (boolean bool = true;; bool = false)
    {
      localUserOperationModule.a(paramAppRuntime, paramString, bool, paramArticleInfo.mPolymericInfo.c, new ComponentHeaderPolymeric.1(this, paramArticleInfo), 2);
      return;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.c.setBackgroundResource(2130849723);
      this.c.setText(HardCodeUtil.a(2131702312));
      this.c.setTextColor(-2147483648);
      this.c.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      return;
    }
    this.c.setBackgroundResource(2130849722);
    this.c.setText(HardCodeUtil.a(2131702349));
    this.c.setTextColor(-1);
    this.c.setCompoundDrawablePadding(AIOUtils.a(3.0F, getResources()));
    this.c.setCompoundDrawablesWithIntrinsicBounds(2130849720, 0, 0, 0);
  }
  
  private void b(BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject = RIJKanDianFolderStatus.a(paramBaseArticleInfo.mPolymericInfo);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8008F55", "0X8008F55", 0, 0, "", "", "", ((JSONObject)localObject).toString(), false);
    if (RIJFeedsType.j(paramBaseArticleInfo))
    {
      localObject = (BaseArticleInfo)paramBaseArticleInfo.mGroupSubArticleList.get(0);
      String str1 = ReadinjoyReportUtils.a(getContext(), ((BaseArticleInfo)localObject).mArticleID, ((BaseArticleInfo)localObject).mAlgorithmID, 54, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(), ((BaseArticleInfo)localObject).getInnerUniqueID(), ((BaseArticleInfo)localObject).getVideoVid(), ReadinjoyReportUtils.a((BaseArticleInfo)localObject), ((BaseArticleInfo)localObject).videoReportInfo);
      String str2 = ReadinjoyReportUtils.b(paramBaseArticleInfo.mChannelID);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", String.valueOf(paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long), str2, str2, 0, 0, Long.toString(((BaseArticleInfo)localObject).mFeedId), String.valueOf(((BaseArticleInfo)localObject).mArticleID), Integer.toString(((BaseArticleInfo)localObject).mStrategyId), str1, false);
      return;
    }
    RIJFrameworkReportManager.b((ArticleInfo)paramBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a());
  }
  
  private void b(AppRuntime paramAppRuntime, String paramString, ArticleInfo paramArticleInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentHeaderPolymeric", 2, "followPGCAccount followUin = " + paramString + ", followStatus = " + paramArticleInfo.mPolymericInfo.e + ", articleInfoID = " + paramArticleInfo.mArticleID);
    }
    if ((paramAppRuntime instanceof QQAppInterface))
    {
      paramAppRuntime = (QQAppInterface)paramAppRuntime;
      if (paramArticleInfo.mPolymericInfo.e != 1) {
        break label131;
      }
      ReadInJoyLogicEngine.a().a().a(paramAppRuntime.getAccount(), paramString, true, paramArticleInfo.mPolymericInfo.c, new ComponentHeaderPolymeric.2(this, paramArticleInfo), 1);
    }
    label131:
    while (paramArticleInfo.mPolymericInfo.e != 2)
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.e("ComponentHeaderPolymeric", 2, "followPGCAccount fail, appInterface is null!");
      return;
    }
    ReadInJoyLogicEngine.a().a().a(paramAppRuntime.getAccount(), paramString, false, paramArticleInfo.mPolymericInfo.c, new ComponentHeaderPolymeric.3(this, paramArticleInfo), 1);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560258, this, true);
  }
  
  String a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Long > 0L) {}
    for (String str1 = ReadInJoyTimeUtils.a(paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Long, true);; str1 = HardCodeUtil.a(2131702331))
    {
      String str2 = str1;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_JavaLangString)) {
        str2 = str1 + " " + paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_JavaLangString;
      }
      return str2;
    }
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
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131379661);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramView.findViewById(2131376527));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376519));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramView.findViewById(2131376522));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131376530));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376531));
    this.c = ((TextView)paramView.findViewById(2131376521));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376523));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131377356);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setOnClickListener(this);
    this.c.setOnClickListener(this);
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    super.a(paramCellListener);
  }
  
  void a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 10)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setVisibility(8);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setVisibility(0);
  }
  
  void a(BaseArticleInfo paramBaseArticleInfo, String paramString)
  {
    switch (paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int)
    {
    case 7: 
    case 8: 
    default: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_a_of_type_Long = 0L;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mPolymericInfo.c))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImage(RIJPreParseData.a(paramBaseArticleInfo.mPolymericInfo.c));
        paramString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView;
        if (paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Int != 0) {
          break label583;
        }
      }
      break;
    }
    label583:
    for (boolean bool = true;; bool = false)
    {
      paramString.setRound(bool);
      do
      {
        return;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
        this.jdField_a_of_type_Long = paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImageDrawable(SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, String.valueOf(this.jdField_a_of_type_Long), 1));
        return;
        Object localObject = paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_JavaLangString;
        if (((String)localObject).startsWith("#"))
        {
          paramString = (String)localObject;
          if (!((String)localObject).startsWith("# ")) {
            paramString = "# " + ((String)localObject).substring(1);
          }
          paramString = new SpannableString(paramString);
          paramString.setSpan(new ForegroundColorSpan(getResources().getColor(2131166899)), 0, 1, 33);
          paramString.setSpan(new ImageSpan(getContext(), 2130843121), 1, 2, 33);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(paramString);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_JavaLangString);
          this.jdField_a_of_type_Long = 0L;
          if (TextUtils.isEmpty(paramBaseArticleInfo.mPolymericInfo.c)) {
            break;
          }
          paramString = URLDrawable.URLDrawableOptions.obtain();
          localObject = new ColorDrawable(0);
          paramString.mFailedDrawable = ((Drawable)localObject);
          paramString.mLoadingDrawable = ((Drawable)localObject);
          paramBaseArticleInfo = URLDrawable.getDrawable(RIJPreParseData.a(paramBaseArticleInfo.mPolymericInfo.c), paramString);
          paramBaseArticleInfo.setTag(URLDrawableDecodeHandler.b(72, 72, DisplayUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.getContext(), 2.0F)));
          paramBaseArticleInfo.setDecodeHandler(URLDrawableDecodeHandler.j);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImageDrawable(paramBaseArticleInfo);
          return;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_JavaLangString);
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_JavaLangString);
        return;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_Long = paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long;
      } while ((paramBaseArticleInfo.mGroupSubArticleList == null) || (paramBaseArticleInfo.mGroupSubArticleList.size() <= 0));
      paramString = (BaseArticleInfo)paramBaseArticleInfo.mGroupSubArticleList.get(0);
      if (((paramString instanceof ArticleInfo)) && (RIJItemViewType.o((ArticleInfo)paramString)))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImageDrawable(SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, String.valueOf(this.jdField_a_of_type_Long), 1));
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(this.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setNickNameByUin(this.jdField_a_of_type_Long);
      return;
    }
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    ArticleInfo localArticleInfo = ((IReadInJoyModel)paramObject).a();
    if ((localArticleInfo != null) && (localArticleInfo.mPolymericInfo != null))
    {
      String str = a(localArticleInfo);
      a(localArticleInfo);
      a(localArticleInfo, str);
    }
    a(paramObject, localArticleInfo);
  }
  
  void a(Object paramObject, BaseArticleInfo paramBaseArticleInfo)
  {
    int j = 1;
    int i = 1;
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mGroupSubArticleList == null) || (paramBaseArticleInfo.mGroupSubArticleList.isEmpty()) || (paramBaseArticleInfo.mPolymericInfo == null) || ((paramBaseArticleInfo.mPolymericInfo.e != 2) && (paramBaseArticleInfo.mPolymericInfo.e != 1)))
    {
      this.c.setVisibility(8);
      if ((QLog.isColorLevel()) && (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mPolymericInfo != null)) {
        QLog.d("ComponentHeaderPolymeric", 2, "articleInfo.mPolymericInfo = " + paramBaseArticleInfo.mPolymericInfo.toString());
      }
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 11)
    {
      if (paramBaseArticleInfo.mPolymericInfo.e == 2) {}
      for (i = 1;; i = 0)
      {
        this.c.setTag(String.valueOf(paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long));
        paramBaseArticleInfo = ((BaseArticleInfo)paramBaseArticleInfo.mGroupSubArticleList.get(0)).mSocialFeedInfo;
        if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.a != null)) {
          break;
        }
        this.c.setVisibility(8);
        return;
      }
      if (paramBaseArticleInfo.a != null) {
        if (paramBaseArticleInfo.a.jdField_a_of_type_Int == 1)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          if (i != 0) {
            break label402;
          }
          this.c.setVisibility(0);
          a(false);
          label249:
          paramBaseArticleInfo = (LinearLayout.LayoutParams)this.c.getLayoutParams();
          if (!a()) {
            break label414;
          }
        }
      }
    }
    label402:
    label414:
    for (paramBaseArticleInfo.rightMargin = DisplayUtil.a(getContext(), 12.0F);; paramBaseArticleInfo.rightMargin = DisplayUtil.a(getContext(), 0.0F))
    {
      this.c.setLayoutParams(paramBaseArticleInfo);
      if (!(paramObject instanceof ReadInJoyModelImpl)) {
        break label439;
      }
      if ((((ReadInJoyModelImpl)paramObject).e() != 56) || (((ReadInJoyModelImpl)paramObject).jdField_b_of_type_Int == 0)) {
        break label429;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      if (paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int != 9) {
        break;
      }
      if (paramBaseArticleInfo.mPolymericInfo.e == 2) {}
      for (i = j;; i = 0)
      {
        this.c.setTag(String.valueOf(paramBaseArticleInfo.mPolymericInfo.f));
        break;
      }
      this.c.setVisibility(8);
      break label249;
    }
    label429:
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    return;
    label439:
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
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
      if (i == 10) {
        return true;
      }
    }
    return super.a();
  }
  
  protected void d()
  {
    AppRuntime localAppRuntime = ReadInJoyUtils.a();
    ArticleInfo localArticleInfo;
    String str;
    if (localAppRuntime != null)
    {
      this.jdField_a_of_type_Boolean = false;
      localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a();
      if (!ReadinjoyReportUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.e())) {
        break label157;
      }
      str = "0X800941D";
      RIJFrameworkReportManager.a(localArticleInfo, str, str, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.e());
      ReadInJoyLogicEngine.d(localArticleInfo);
      str = String.valueOf(localArticleInfo.mPolymericInfo.jdField_b_of_type_Long);
      if ((localArticleInfo.mGroupSubArticleList == null) || (localArticleInfo.mGroupSubArticleList.size() <= 0)) {
        break label173;
      }
      BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)localArticleInfo.mGroupSubArticleList.get(0);
      if ((!(localBaseArticleInfo instanceof ArticleInfo)) || (!RIJItemViewType.o((ArticleInfo)localBaseArticleInfo))) {
        break label173;
      }
    }
    label157:
    label173:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        a(localAppRuntime, str, localArticleInfo);
        return;
        str = "0X80080EC";
        break;
      }
      b(localAppRuntime, str, localArticleInfo);
      return;
    }
  }
  
  protected void e()
  {
    boolean bool = false;
    Object localObject = ReadInJoyUtils.a();
    ArticleInfo localArticleInfo = (ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mGroupSubArticleList.get(0);
    localObject = ((AppRuntime)localObject).getAccount();
    if (QLog.isColorLevel()) {
      QLog.d("ComponentHeaderPolymeric", 2, "followPGCAccount topicID = " + localArticleInfo.mPolymericInfo.f + ", followStatus = " + localArticleInfo.mPolymericInfo.e + ", articleInfoID = " + localArticleInfo.mArticleID);
    }
    UserOperationModule localUserOperationModule = ReadInJoyLogicEngine.a().a();
    String str = Long.toString(localArticleInfo.mPolymericInfo.f);
    if (localArticleInfo.mPolymericInfo.e != 2) {
      bool = true;
    }
    localUserOperationModule.a((String)localObject, str, bool, localArticleInfo.mPolymericInfo.c, new ComponentHeaderPolymeric.4(this, localArticleInfo), 3);
  }
  
  public void onAttachedToWindow()
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
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (localArticleInfo.mPolymericInfo.jdField_a_of_type_Int)
      {
      }
      for (;;)
      {
        b(localArticleInfo);
        break;
        String str = ReadInJoyConstants.g + Base64Util.encodeToString(String.valueOf(localArticleInfo.mPolymericInfo.jdField_b_of_type_Long).getBytes(), 2);
        ReadInJoyUtils.a(getContext(), str);
        continue;
        str = ReadInJoyConstants.k + Base64Util.encodeToString(String.valueOf(localArticleInfo.mPolymericInfo.jdField_b_of_type_Long).getBytes(), 2);
        ReadInJoyUtils.a(getContext(), str);
        continue;
        ReadInJoyUtils.a(getContext(), localArticleInfo.mPolymericInfo.d);
      }
      if ((localArticleInfo.mPolymericInfo.e == 2) || (localArticleInfo.mPolymericInfo.e == 1)) {
        if (!this.jdField_a_of_type_Boolean)
        {
          QQToast.a(getContext(), HardCodeUtil.a(2131702332), 0).a();
          if (QLog.isColorLevel()) {
            QLog.d("ComponentHeaderPolymeric", 2, "click when the button is disabled");
          }
        }
        else if (localArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 11)
        {
          d();
        }
        else if (localArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 9)
        {
          e();
        }
      }
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderPolymeric
 * JD-Core Version:    0.7.0.1
 */