package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.CmpCtxt;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.biz.pubaccount.readinjoy.viewmodels.ArticleViewModel;
import com.tencent.biz.pubaccount.readinjoy.viewmodels.Observable;
import com.tencent.biz.pubaccount.readinjoy.viewmodels.Observer;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class NativeBiuCommentView
  extends NativeCommentView
  implements IView, Observer<CharSequence>
{
  public NativeBiuCommentView(Context paramContext)
  {
    super(paramContext);
    setSpannableFactory(QQText.SPANNABLE_FACTORY);
    setShouldCallClick(false);
  }
  
  private void b()
  {
    QLog.d("NativeBiuCommentView", 2, "bindRecommendCommentHeader | linkTextColor " + this.b);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewmodelsArticleViewModel != null)
    {
      ArticleInfo localArticleInfo = (ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewmodelsArticleViewModel.a();
      a(localArticleInfo);
      setMaxLines(a(localArticleInfo));
      setSpanText(HardCodeUtil.a(2131707083));
      setMoreSpan(new NativeBiuCommentView.MoreSpan(this, localArticleInfo, this.b));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewmodelsArticleViewModel.a(this.b);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewmodelsObservable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewmodelsArticleViewModel.c();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewmodelsObservable.a(this);
      QLog.d("NativeBiuCommentView", 2, "bindRecommendCommentHeader: " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewmodelsObservable.a());
      setText((CharSequence)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewmodelsObservable.a());
    }
  }
  
  public void a(Observable<CharSequence> paramObservable)
  {
    paramObservable = (CharSequence)paramObservable.a();
    ThreadManager.getUIHandler().post(new NativeBiuCommentView.1(this, paramObservable));
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewmodelsArticleViewModel = paramIReadInJoyModel.a().articleViewModel;
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeBiuCommentView
 * JD-Core Version:    0.7.0.1
 */