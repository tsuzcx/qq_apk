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
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import lyz;
import lza;
import lzb;
import lzc;
import lze;
import lzf;
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new lzf(this);
  }
  
  public ComponentHeaderPolymeric(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new lzf(this);
  }
  
  public ComponentHeaderPolymeric(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new lzf(this);
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 1)
    {
      this.c.setText("关注");
      this.c.setTextColor(getResources().getColor(2131493399));
      QQToast.a(getContext(), "关注失败", 0).a();
    }
    while (paramInt != 2) {
      return;
    }
    this.c.setText("已关注");
    this.c.setTextColor(-4473925);
    QQToast.a(getContext(), "取消关注失败", 0).a();
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
      ThreadManager.post(new lze(this, paramArticleInfo, paramInt), 5, null, true);
      return;
    }
  }
  
  private void a(BaseArticleInfo paramBaseArticleInfo)
  {
    PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8008F55", "0X8008F55", 0, 0, "", "", "", ReadInJoyUtils.a(paramBaseArticleInfo.mPolymericInfo).toString(), false);
    if (ReadInJoyUtils.e(paramBaseArticleInfo))
    {
      BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)paramBaseArticleInfo.mGroupSubArticleList.get(0);
      String str = ReadinjoyReportUtils.a(getContext(), localBaseArticleInfo.mArticleID, localBaseArticleInfo.mAlgorithmID, 54, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(), localBaseArticleInfo.getInnerUniqueID(), localBaseArticleInfo.getVideoVid(), ReadinjoyReportUtils.a(localBaseArticleInfo), localBaseArticleInfo.videoReportInfo);
      PublicAccountReportUtils.a(null, "CliOper", "", String.valueOf(paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long), "0X8007625", "0X8007625", 0, 0, Long.toString(localBaseArticleInfo.mFeedId), String.valueOf(localBaseArticleInfo.mArticleID), Integer.toString(localBaseArticleInfo.mStrategyId), str, false);
      return;
    }
    ReadInJoyBaseAdapter.a((ArticleInfo)paramBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a());
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
      localUserOperationModule.a(paramAppRuntime, paramString, bool, new lyz(this, paramArticleInfo), 2);
      return;
    }
  }
  
  private void b(AppRuntime paramAppRuntime, String paramString, ArticleInfo paramArticleInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentHeaderPolymeric", 2, "followPGCAccount followUin = " + paramString + ", followStatus = " + paramArticleInfo.mPolymericInfo.e + ", articleInfoID = " + paramArticleInfo.mArticleID);
    }
    if ((paramAppRuntime instanceof QQAppInterface)) {}
    for (paramAppRuntime = (QQAppInterface)paramAppRuntime;; paramAppRuntime = null)
    {
      if (paramArticleInfo.mPolymericInfo.e == 1) {
        PublicAccountUtil.a(paramAppRuntime, getContext(), paramString, new lza(this, paramArticleInfo), false);
      }
      while (paramArticleInfo.mPolymericInfo.e != 2) {
        return;
      }
      PublicAccountUtil.a(paramAppRuntime, getContext(), paramString, true, new lzb(this, paramArticleInfo));
      return;
    }
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2130969576, this, true);
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
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131366815);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramView.findViewById(2131367040));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367041));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramView.findViewById(2131367039));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367025));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367042));
    this.c = ((TextView)paramView.findViewById(2131367043));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367024));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131362845);
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
    int j = 1;
    int i = 1;
    super.a(paramObject);
    ArticleInfo localArticleInfo = ((IReadInJoyModel)paramObject).a();
    Object localObject1;
    Object localObject2;
    if ((localArticleInfo != null) && (localArticleInfo.mPolymericInfo != null))
    {
      if (localArticleInfo.mPolymericInfo.jdField_a_of_type_Long <= 0L) {
        break label405;
      }
      localObject1 = ReadInJoyTimeUtils.a(localArticleInfo.mPolymericInfo.jdField_a_of_type_Long, true);
      localObject2 = localObject1;
      if (!TextUtils.isEmpty(localArticleInfo.mPolymericInfo.jdField_b_of_type_JavaLangString)) {
        localObject2 = (String)localObject1 + " " + localArticleInfo.mPolymericInfo.jdField_b_of_type_JavaLangString;
      }
      if (localArticleInfo.mPolymericInfo.jdField_a_of_type_Int != 10) {
        break label413;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setVisibility(8);
      label151:
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
            break label941;
          }
        }
        break;
      }
    }
    label405:
    label413:
    label941:
    for (boolean bool = true;; bool = false)
    {
      ((ReadInJoyHeadImageView)localObject1).setRound(bool);
      for (;;)
      {
        if ((localArticleInfo != null) && (localArticleInfo.mGroupSubArticleList != null) && (!localArticleInfo.mGroupSubArticleList.isEmpty()) && (localArticleInfo.mPolymericInfo != null) && ((localArticleInfo.mPolymericInfo.e == 2) || (localArticleInfo.mPolymericInfo.e == 1))) {
          break label947;
        }
        this.c.setVisibility(8);
        if ((QLog.isColorLevel()) && (localArticleInfo != null) && (localArticleInfo.mPolymericInfo != null)) {
          QLog.d("ComponentHeaderPolymeric", 2, "articleInfo.mPolymericInfo = " + localArticleInfo.mPolymericInfo.toString());
        }
        return;
        localObject1 = "刚刚";
        break;
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setVisibility(0);
        break label151;
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
          ((SpannableString)localObject1).setSpan(new ImageSpan(getContext(), 2130840818), 1, 2, 33);
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
    label947:
    this.jdField_a_of_type_Boolean = true;
    if (localArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 11)
    {
      if (localArticleInfo.mPolymericInfo.e == 2) {}
      for (i = 1;; i = 0)
      {
        this.c.setTag(String.valueOf(localArticleInfo.mPolymericInfo.jdField_b_of_type_Long));
        localObject1 = ((BaseArticleInfo)localArticleInfo.mGroupSubArticleList.get(0)).mSocialFeedInfo;
        if ((localObject1 != null) && (((SocializeFeedsInfo)localObject1).a != null)) {
          break;
        }
        this.c.setVisibility(8);
        return;
      }
      if (((SocializeFeedsInfo)localObject1).a != null) {
        if (((SocializeFeedsInfo)localObject1).a.jdField_a_of_type_Int == 1)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          if (i != 0) {
            break label1267;
          }
          this.c.setVisibility(0);
          this.c.setTextColor(getResources().getColor(2131493399));
          this.c.setText("关注");
          label1109:
          localObject1 = (LinearLayout.LayoutParams)this.c.getLayoutParams();
          if (!a()) {
            break label1279;
          }
        }
      }
    }
    label1267:
    label1279:
    for (((LinearLayout.LayoutParams)localObject1).rightMargin = DisplayUtil.a(getContext(), 12.0F);; ((LinearLayout.LayoutParams)localObject1).rightMargin = DisplayUtil.a(getContext(), 0.0F))
    {
      this.c.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (!(paramObject instanceof ReadInJoyModelImpl)) {
        break label1305;
      }
      if ((((ReadInJoyModelImpl)paramObject).e() != 56) || (((ReadInJoyModelImpl)paramObject).jdField_b_of_type_Int == 0)) {
        break label1295;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      if (localArticleInfo.mPolymericInfo.jdField_a_of_type_Int != 9) {
        break;
      }
      if (localArticleInfo.mPolymericInfo.e == 2) {}
      for (i = j;; i = 0)
      {
        this.c.setTag(String.valueOf(localArticleInfo.mPolymericInfo.f));
        break;
      }
      this.c.setVisibility(8);
      break label1109;
    }
    label1295:
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    return;
    label1305:
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
      ReadInJoyBaseAdapter.a(localArticleInfo, "0X80080EC", "0X80080EC", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.e());
      ReadInJoyLogicEngine.b(localArticleInfo);
      str = String.valueOf(localArticleInfo.mPolymericInfo.jdField_b_of_type_Long);
      if ((localArticleInfo.mGroupSubArticleList == null) || (localArticleInfo.mGroupSubArticleList.size() <= 0)) {
        break label141;
      }
      BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)localArticleInfo.mGroupSubArticleList.get(0);
      if ((!(localBaseArticleInfo instanceof ArticleInfo)) || (!ReadInJoyBaseAdapter.m((ArticleInfo)localBaseArticleInfo))) {
        break label141;
      }
    }
    label141:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        a(localAppRuntime, str, localArticleInfo);
        return;
      }
      b(localAppRuntime, str, localArticleInfo);
      return;
    }
  }
  
  protected void e()
  {
    boolean bool = false;
    AppRuntime localAppRuntime = ReadInJoyUtils.a();
    ArticleInfo localArticleInfo = (ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mGroupSubArticleList.get(0);
    String str1 = localAppRuntime.getAccount();
    if (QLog.isColorLevel()) {
      QLog.d("ComponentHeaderPolymeric", 2, "followPGCAccount topicID = " + localArticleInfo.mPolymericInfo.f + ", followStatus = " + localArticleInfo.mPolymericInfo.e + ", articleInfoID = " + localArticleInfo.mArticleID);
    }
    UserOperationModule localUserOperationModule = ReadInJoyLogicEngine.a().a();
    String str2 = Long.toString(localArticleInfo.mPolymericInfo.f);
    if (localArticleInfo.mPolymericInfo.e != 2) {
      bool = true;
    }
    localUserOperationModule.a(str1, str2, bool, new lzc(this, localArticleInfo, localAppRuntime), 3);
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
      do
      {
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
        } while ((localArticleInfo.mPolymericInfo.e != 2) && (localArticleInfo.mPolymericInfo.e != 1));
        if (this.jdField_a_of_type_Boolean) {
          break;
        }
        QQToast.a(getContext(), "操作太快啦，请稍后再试~", 0).a();
      } while (!QLog.isColorLevel());
      QLog.d("ComponentHeaderPolymeric", 2, "click when the button is disabled");
      return;
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