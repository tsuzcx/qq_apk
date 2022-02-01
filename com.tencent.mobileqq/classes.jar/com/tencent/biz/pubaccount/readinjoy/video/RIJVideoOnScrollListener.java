package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.PlayableItem;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class RIJVideoOnScrollListener
  implements AbsListView.OnScrollListener
{
  public static boolean a;
  private static boolean jdField_c_of_type_Boolean;
  double jdField_a_of_type_Double = 0.0D;
  private int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 0L;
  private View jdField_a_of_type_AndroidViewView;
  private final VideoHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler;
  private AbsListView jdField_a_of_type_ComTencentWidgetAbsListView;
  final double jdField_b_of_type_Double = 200.0D;
  private int jdField_b_of_type_Int;
  long jdField_b_of_type_Long = 0L;
  private View jdField_b_of_type_AndroidViewView;
  boolean jdField_b_of_type_Boolean;
  long jdField_c_of_type_Long = 0L;
  private boolean d = true;
  
  public RIJVideoOnScrollListener(VideoHandler paramVideoHandler)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler = paramVideoHandler;
    this.jdField_a_of_type_ComTencentWidgetAbsListView = paramVideoHandler.a();
  }
  
  public static boolean a()
  {
    if (!jdField_a_of_type_Boolean)
    {
      Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.KDCfg.name(), null);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length >= 2) {
          jdField_c_of_type_Boolean = localObject[1].equals("1");
        }
        jdField_a_of_type_Boolean = true;
      }
    }
    return jdField_c_of_type_Boolean;
  }
  
  private boolean a(AbsListView paramAbsListView)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Double > 0.0D)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Double < 200.0D)
      {
        bool1 = bool2;
        if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.a().d())
        {
          bool1 = bool2;
          if (!a())
          {
            bool1 = bool2;
            if (paramAbsListView.getVisibility() == 0) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramAbsListView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.a();
    if ((paramAbsListView != null) && (paramAbsListView.h())) {}
    long l1;
    long l2;
    long l3;
    do
    {
      return;
      paramAbsListView = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(0);
      if (paramAbsListView == null) {
        break;
      }
      if (this.jdField_a_of_type_Long == 0L)
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        return;
      }
      this.jdField_b_of_type_Long = (paramAbsListView.getHeight() * paramInt1 - paramAbsListView.getTop());
      l1 = this.jdField_b_of_type_Long;
      l2 = this.jdField_c_of_type_Long;
      l3 = System.currentTimeMillis();
    } while (l3 == this.jdField_a_of_type_Long);
    this.jdField_a_of_type_Double = ((l1 - l2) * 1000L / (l3 - this.jdField_a_of_type_Long));
    this.jdField_a_of_type_Long = l3;
    this.jdField_c_of_type_Long = this.jdField_b_of_type_Long;
    if (a(this.jdField_a_of_type_ComTencentWidgetAbsListView))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "低速滚动触发自动播放检测");
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.b(this.jdField_a_of_type_ComTencentWidgetAbsListView, ReadInJoyBaseAdapter.jdField_a_of_type_Int);
    }
    if (paramInt1 > this.jdField_a_of_type_Int) {
      this.jdField_b_of_type_Boolean = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = (paramInt1 + paramInt2 - 1);
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(0);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(paramInt2 - 1);
      return;
      this.jdField_a_of_type_Long = 0L;
      this.jdField_b_of_type_Long = 0L;
      this.jdField_c_of_type_Long = 0L;
      break;
      if (paramInt1 < this.jdField_a_of_type_Int) {
        this.jdField_b_of_type_Boolean = false;
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.r();
      return;
      this.d = this.jdField_b_of_type_Boolean;
      paramAbsListView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.a(this.jdField_a_of_type_ComTencentWidgetAbsListView);
      if (paramAbsListView == null) {}
      for (paramInt = this.jdField_a_of_type_ComTencentWidgetAbsListView.getFirstVisiblePosition();; paramInt = paramAbsListView.a())
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.a(paramInt, this.d);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyBaseAdapter", 2, "predownload position: " + paramInt + " when scroll state idle");
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.b(this.jdField_a_of_type_ComTencentWidgetAbsListView, ReadInJoyBaseAdapter.jdField_b_of_type_Int);
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.k();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.RIJVideoOnScrollListener
 * JD-Core Version:    0.7.0.1
 */