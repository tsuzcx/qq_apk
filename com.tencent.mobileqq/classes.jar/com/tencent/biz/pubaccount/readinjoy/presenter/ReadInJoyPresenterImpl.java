package com.tencent.biz.pubaccount.readinjoy.presenter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.OnLastReadRefreshListener;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyView;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.widget.KandianNegativeWindow;
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
  
  public ReadInJoyPresenterImpl(Context paramContext, OnLastReadRefreshListener paramOnLastReadRefreshListener, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, KandianNegativeWindow paramKandianNegativeWindow, ListView paramListView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPresenterIReadInJoyPresenter = new ReadInJoyHeaderPresenter(this.jdField_a_of_type_AndroidContentContext, paramIFaceDecoder, paramReadInJoyBaseAdapter, paramListView, paramKandianNegativeWindow);
    this.b = new ReadInJoyFooterPresenter(this.jdField_a_of_type_AndroidContentContext, paramOnLastReadRefreshListener, paramReadInJoyBaseAdapter);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.presenter.ReadInJoyPresenterImpl
 * JD-Core Version:    0.7.0.1
 */