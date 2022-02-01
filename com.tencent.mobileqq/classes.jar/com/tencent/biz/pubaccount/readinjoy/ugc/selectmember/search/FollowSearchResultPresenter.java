package com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.search;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.FollowingMember;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.presenter.ContactSearchResultPresenter.OnActionListener;
import com.tencent.mobileqq.search.presenter.SearchResultPresenter;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import java.util.HashSet;
import java.util.Set;

public class FollowSearchResultPresenter
  extends SearchResultPresenter
{
  private ContactSearchResultPresenter.OnActionListener jdField_a_of_type_ComTencentMobileqqSearchPresenterContactSearchResultPresenter$OnActionListener;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  
  FollowSearchResultPresenter(IFaceDecoder paramIFaceDecoder, ContactSearchResultPresenter.OnActionListener paramOnActionListener, Set<String> paramSet)
  {
    super(paramIFaceDecoder);
    this.jdField_a_of_type_ComTencentMobileqqSearchPresenterContactSearchResultPresenter$OnActionListener = paramOnActionListener;
    this.jdField_a_of_type_JavaUtilSet = paramSet;
  }
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    if ((paramISearchResultModel instanceof FollowingSearchResultModel))
    {
      paramISearchResultModel = ((FollowingSearchResultModel)paramISearchResultModel).a().b();
      paramISearchResultView = paramISearchResultView.b();
      Drawable localDrawable = paramISearchResultView.getResources().getDrawable(2130840452);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = localDrawable;
      localURLDrawableOptions.mFailedDrawable = localDrawable;
      paramISearchResultModel = URLDrawable.getDrawable(paramISearchResultModel, localURLDrawableOptions);
      paramISearchResultModel.setTag(URLDrawableDecodeHandler.a(140, 140));
      paramISearchResultModel.setDecodeHandler(URLDrawableDecodeHandler.p);
      paramISearchResultView.setImageDrawable(paramISearchResultModel);
      return;
    }
    super.a(paramISearchResultModel, paramISearchResultView);
  }
  
  public void b(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    super.b(paramISearchResultModel, paramISearchResultView);
  }
  
  public void c(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    super.c(paramISearchResultModel, paramISearchResultView);
    if ((this.jdField_a_of_type_ComTencentMobileqqSearchPresenterContactSearchResultPresenter$OnActionListener != null) && (!this.jdField_a_of_type_JavaUtilSet.contains(paramISearchResultModel.b()))) {
      paramISearchResultView.a().setOnClickListener(new FollowSearchResultPresenter.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.search.FollowSearchResultPresenter
 * JD-Core Version:    0.7.0.1
 */