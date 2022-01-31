package com.tencent.biz.pubaccount.readinjoy.presenter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.OnLastReadRefreshListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyView;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.widget.KandianPopupWindow;
import com.tencent.widget.ListView;

public class ReadInJoyPresenterImpl
  implements IReadInJoyPresenter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private IReadInJoyModel jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel;
  private IReadInJoyPresenter jdField_a_of_type_ComTencentBizPubaccountReadinjoyPresenterIReadInJoyPresenter;
  private ReadInJoyView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView;
  private IReadInJoyPresenter b;
  
  public ReadInJoyPresenterImpl(Context paramContext, ReadInJoyBaseAdapter.OnLastReadRefreshListener paramOnLastReadRefreshListener, FaceDecoder paramFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, KandianPopupWindow paramKandianPopupWindow, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPresenterIReadInJoyPresenter = new ReadInJoyHeaderPresenter(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter, paramListView, paramKandianPopupWindow);
    this.b = new ReadInJoyFooterPresenter(paramContext, paramOnLastReadRefreshListener, paramReadInJoyBaseAdapter);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(ReadInJoyView paramReadInJoyView, IReadInJoyModel paramIReadInJoyModel, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyView = paramReadInJoyView;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel = paramIReadInJoyModel;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPresenterIReadInJoyPresenter.a(paramReadInJoyView, paramIReadInJoyModel, paramInt);
    this.b.a(paramReadInJoyView, paramIReadInJoyModel, paramInt);
    if ((paramReadInJoyView != null) && (paramReadInJoyView.e != null))
    {
      if (paramIReadInJoyModel.h()) {
        paramReadInJoyView.e.setVisibility(8);
      }
    }
    else {
      return;
    }
    paramReadInJoyView.e.setVisibility(0);
  }
  
  public void a(ReadInJoyView paramReadInJoyView, IReadInJoyModel paramIReadInJoyModel, long paramLong, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPresenterIReadInJoyPresenter.a(paramReadInJoyView, paramIReadInJoyModel, paramLong, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.presenter.ReadInJoyPresenterImpl
 * JD-Core Version:    0.7.0.1
 */