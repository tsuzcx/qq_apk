package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.CmpCtxt;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BuluoInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.biz.pubaccount.readinjoy.viewmodels.ArticleViewModel;
import com.tencent.biz.pubaccount.readinjoy.viewmodels.Observable;
import com.tencent.biz.pubaccount.readinjoy.viewmodels.Observer;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class NativeCommentView
  extends ReadInJoyYAFolderTextView
  implements IView, Observer<CharSequence>
{
  protected int a;
  protected long a;
  protected CmpCtxt a;
  protected Observable<CharSequence> a;
  protected String a;
  public boolean a;
  public boolean b;
  
  public NativeCommentView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt = new CmpCtxt();
    setShouldCallClick(true);
  }
  
  private void b()
  {
    ArticleInfo localArticleInfo;
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mSocialFeedInfo != null))
    {
      localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewmodelsObservable = localArticleInfo.articleViewModel.a();
      a(localArticleInfo);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewmodelsObservable.a(this);
      localObject = (CharSequence)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewmodelsObservable.a();
      QLog.d("NativeCommentView", 2, "setDesc: " + localObject);
      if ((localArticleInfo.mFeedType != 30) && ((localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo == null) || (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.b.longValue() != 30L)) && ((localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BuluoInfo == null) || (TextUtils.isEmpty(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BuluoInfo.c)))) {
        break label553;
      }
      localObject = new QQText(TroopBarUtils.a(((CharSequence)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewmodelsObservable.a()).toString().replaceAll("\024", "")), 3, 16);
    }
    label553:
    for (;;)
    {
      setVisibility(0);
      if (this.jdField_b_of_type_Boolean)
      {
        setMaxLines(2);
        setSpanText("");
        setMoreSpan(null);
        setEllipsis("...");
        setText((CharSequence)localObject);
        return;
      }
      if ((RIJItemViewType.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a())) || (RIJItemViewType.i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a())) || (RIJItemViewType.h(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a())))
      {
        setMaxLines(a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a()));
        if (localArticleInfo.mArticleType == BaseArticleInfo.TYPE_ARTICLE_NOVEL) {
          setSpanText(BaseApplication.getContext().getString(2131718337));
        }
        for (;;)
        {
          setMoreSpan(new NativeCommentView.1(this, this.jdField_b_of_type_Int, 16777215, 860716207));
          setCustomViewLinkTextColor(this.jdField_b_of_type_Int);
          if (!this.jdField_b_of_type_Boolean) {
            break;
          }
          setHeight(0);
          return;
          if (localArticleInfo.isPGCShortContent()) {
            setSpanText(HardCodeUtil.a(2131707084));
          }
        }
        setText((CharSequence)localObject);
        return;
      }
      if (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo != null)
      {
        setMaxLines(a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a()));
        if (((RIJFeedsType.l(localArticleInfo)) || (RIJFeedsType.m(localArticleInfo))) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mChannelID != 0L))
        {
          setSpanText("");
          setMoreSpan(null);
        }
        while (!TextUtils.isEmpty((CharSequence)localObject))
        {
          setText((CharSequence)localObject);
          return;
          setMoreSpan(new NativeCommentView.2(this, this.jdField_b_of_type_Int, 16777215, 860716207, localArticleInfo));
          setCustomViewLinkTextColor(this.jdField_b_of_type_Int);
        }
        setVisibility(8);
        return;
      }
      setVisibility(8);
      return;
    }
  }
  
  protected void a(ArticleInfo paramArticleInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("current text: ");
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewmodelsObservable != null)
    {
      localObject = (CharSequence)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewmodelsObservable.a();
      QLog.d("NativeCommentView", 1, localObject);
      if ((paramArticleInfo != null) && (paramArticleInfo.articleViewModel != null))
      {
        paramArticleInfo.articleViewModel.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        paramArticleInfo.articleViewModel.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
        paramArticleInfo.articleViewModel.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
        if (this.jdField_a_of_type_Long != 0L) {
          paramArticleInfo.articleViewModel.a();
        }
      }
      localObject = new StringBuilder().append("current text: ");
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewmodelsObservable == null) {
        break label158;
      }
    }
    label158:
    for (paramArticleInfo = (CharSequence)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewmodelsObservable.a();; paramArticleInfo = null)
    {
      QLog.d("NativeCommentView", 1, paramArticleInfo);
      return;
      localObject = null;
      break;
    }
  }
  
  public void a(Observable<CharSequence> paramObservable)
  {
    paramObservable = (CharSequence)paramObservable.a();
    ThreadManager.getUIHandler().post(new NativeCommentView.3(this, paramObservable));
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d("NativeCommentView", 1, "showPreCommentText: " + paramBoolean);
    if (paramBoolean) {
      this.jdField_a_of_type_JavaLangString = (HardCodeUtil.a(2131718566) + "：");
    }
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onComLayout(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int getComMeasuredHeight()
  {
    return getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return getMeasuredWidth();
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    onComMeasure(paramInt1, paramInt2);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewmodelsObservable != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewmodelsObservable.b(this);
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewmodelsObservable != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewmodelsObservable.b(this);
    }
  }
  
  public void setModel(IReadInJoyModel paramIReadInJoyModel)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a(paramIReadInJoyModel);
    switch (paramIReadInJoyModel.a())
    {
    }
    for (;;)
    {
      b();
      setShouldCallClick(this.jdField_b_of_type_Boolean);
      return;
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public void setPreAccountUin(long paramLong)
  {
    QLog.d("NativeCommentView", 1, "setPreAccountUin: " + paramLong);
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void setPreBlankNum(int paramInt)
  {
    QLog.d("NativeCommentView", 1, "setPreBlankNum: " + paramInt);
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeCommentView
 * JD-Core Version:    0.7.0.1
 */