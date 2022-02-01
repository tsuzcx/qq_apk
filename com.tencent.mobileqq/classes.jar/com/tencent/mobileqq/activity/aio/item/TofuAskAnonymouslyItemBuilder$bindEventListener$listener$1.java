package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.bean.AnonymousQuestion;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.AnonymousViewHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class TofuAskAnonymouslyItemBuilder$bindEventListener$listener$1
  implements View.OnClickListener
{
  TofuAskAnonymouslyItemBuilder$bindEventListener$listener$1(TofuAskAnonymouslyItemBuilder paramTofuAskAnonymouslyItemBuilder, AnonymousQuestion paramAnonymousQuestion, TofuAskAnonymouslyItemBuilder.Holder paramHolder) {}
  
  public final void onClick(View paramView)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramView, "v");
    int i = paramView.getId();
    if (i != 2131374156) {}
    Object localObject;
    switch (i)
    {
    default: 
      switch (i)
      {
      }
      break;
    case 2131374151: 
      i = (int)this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessAnonymousBeanAnonymousQuestion.mTotalPraiseCount;
      localObject = this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessAnonymousBeanAnonymousQuestion;
      long l;
      if (((AnonymousQuestion)localObject).mPraised) {
        l = i - 1;
      } else {
        l = i + 1L;
      }
      ((AnonymousQuestion)localObject).mTotalPraiseCount = l;
      AnonymousViewHelper.onClickLike((AppInterface)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessAnonymousBeanAnonymousQuestion);
      localObject = this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessAnonymousBeanAnonymousQuestion;
      ((AnonymousQuestion)localObject).mPraised ^= true;
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder;
      if (TofuAskAnonymouslyItemBuilder.a((TofuAskAnonymouslyItemBuilder)localObject, TofuAskAnonymouslyItemBuilder.a((TofuAskAnonymouslyItemBuilder)localObject)))
      {
        TofuAskAnonymouslyItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder).b(this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessAnonymousBeanAnonymousQuestion.mPraised);
        TofuAskAnonymouslyItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder).a(this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessAnonymousBeanAnonymousQuestion.mTotalPraiseCount);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder;
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessAnonymousBeanAnonymousQuestion.mPraised;
      TextView localTextView = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder.d();
      if (localTextView == null) {
        Intrinsics.throwNpe();
      }
      ImageView localImageView = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder.i();
      if (localImageView == null) {
        Intrinsics.throwNpe();
      }
      TofuAskAnonymouslyItemBuilder.a((TofuAskAnonymouslyItemBuilder)localObject, bool, localTextView, localImageView, this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessAnonymousBeanAnonymousQuestion.mTotalPraiseCount);
      ReportController.b(null, "dc00898", "", TofuAskAnonymouslyItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder).a(), "0X800B5C2", "0X800B5C2", 0, 0, "", "", "", "");
      break;
    case 2131374150: 
      Utils.a(paramView);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder.jdField_a_of_type_AndroidContentContext;
      if (localObject != null)
      {
        AnonymousViewHelper.jumpToAnonymousDetail((Activity)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder.a(), this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessAnonymousBeanAnonymousQuestion.mId, "", 11, this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessAnonymousBeanAnonymousQuestion.mQuestTime);
        ReportController.b(null, "dc00898", "", TofuAskAnonymouslyItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder).a(), "0X800B5C3", "0X800B5C3", 0, 0, "", "", "", "");
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.BaseActivity");
        Utils.a(paramView);
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder.jdField_a_of_type_AndroidContentContext;
        if (localObject == null) {
          break label484;
        }
        AnonymousViewHelper.jumpToQuestionListAndAnswer((Activity)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder.a(), 10);
        ReportController.b(null, "dc00898", "", TofuAskAnonymouslyItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder).a(), "0X800B5C1", "0X800B5C1", 0, 0, "", "", "", "");
      }
      break;
    }
    EventCollector.getInstance().onViewClicked(paramView);
    return;
    label484:
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.BaseActivity");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TofuAskAnonymouslyItemBuilder.bindEventListener.listener.1
 * JD-Core Version:    0.7.0.1
 */