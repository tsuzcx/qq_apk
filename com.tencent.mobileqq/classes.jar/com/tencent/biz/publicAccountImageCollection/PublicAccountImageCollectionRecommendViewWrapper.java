package com.tencent.biz.publicAccountImageCollection;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAlphaMaskView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import ncz;
import ndb;

public class PublicAccountImageCollectionRecommendViewWrapper
{
  private static int jdField_a_of_type_Int;
  private static Context jdField_a_of_type_AndroidContentContext;
  public static ArrayList a;
  static boolean jdField_a_of_type_Boolean;
  private static int b;
  private Activity jdField_a_of_type_AndroidAppActivity;
  protected AdapterView.OnItemClickListener a;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public PublicAccountImageCollectionRecommendViewWrapper(Activity paramActivity, ArrayList paramArrayList, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new ncz(this);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    jdField_a_of_type_AndroidContentContext = paramActivity.getApplicationContext();
    jdField_a_of_type_Int = paramInt1;
    b = paramInt2;
    jdField_a_of_type_Boolean = paramBoolean;
    jdField_a_of_type_JavaUtilArrayList = a(paramArrayList);
  }
  
  static int a()
  {
    if (jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    int i = jdField_a_of_type_JavaUtilArrayList.size();
    int j = (jdField_a_of_type_Int - AIOUtils.a(110.0F, jdField_a_of_type_AndroidContentContext.getResources())) / 3;
    if (i % 2 == 0) {
      return i / 2 * j;
    }
    return (i + 1) / 2 * j;
  }
  
  private ArrayList a(ArrayList paramArrayList)
  {
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1;
    if (paramArrayList == null)
    {
      localArrayList1 = null;
      return localArrayList1;
    }
    if (paramArrayList.size() <= 6)
    {
      localArrayList2.addAll(paramArrayList);
      return localArrayList2;
    }
    int i = 0;
    for (;;)
    {
      localArrayList1 = localArrayList2;
      if (i >= 6) {
        break;
      }
      localArrayList2.add(paramArrayList.get(i));
      i += 1;
    }
  }
  
  @TargetApi(9)
  private void a(RelativeLayout paramRelativeLayout)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "buildView!");
    }
    int i = AIOUtils.a(2.0F, jdField_a_of_type_AndroidContentContext.getResources());
    int j = (b - i) / 2;
    paramRelativeLayout = (GridView)paramRelativeLayout.findViewById(2131365571);
    paramRelativeLayout.setColumnWidth(j);
    paramRelativeLayout.setStretchMode(0);
    paramRelativeLayout.setHorizontalSpacing(i);
    paramRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, a()));
    paramRelativeLayout.setNumColumns(2);
    paramRelativeLayout.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
    if (Build.VERSION.SDK_INT >= 9) {
      paramRelativeLayout.setOverScrollMode(2);
    }
    paramRelativeLayout.setAdapter(new PublicAccountImageCollectionRecommendViewWrapper.PhotoAdapter(this));
  }
  
  public View a(Activity paramActivity, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView != null) && ((paramView instanceof RelativeLayout)))
    {
      paramView = (RelativeLayout)paramView;
      Object localObject = paramView.getTag();
      if ((localObject != null) && ((localObject instanceof ndb)))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "createView reuse!");
        }
        return paramView;
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "createView new create!");
    }
    paramActivity = (RelativeLayout)LayoutInflater.from(paramActivity).inflate(2130969196, paramViewGroup, false);
    paramView = paramActivity.getLayoutParams();
    paramView.height = jdField_a_of_type_Int;
    paramActivity.setLayoutParams(paramView);
    paramView = new ndb();
    paramView.jdField_a_of_type_ComTencentWidgetGridView = ((GridView)paramActivity.findViewById(2131365571));
    paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView = ((VideoFeedsAlphaMaskView)paramActivity.findViewById(2131365573));
    paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramActivity.findViewById(2131365572));
    paramActivity.setTag(paramView);
    if ((jdField_a_of_type_JavaUtilArrayList == null) && (jdField_a_of_type_Boolean))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "createView getRecommendInfo error");
      }
      paramView.jdField_a_of_type_ComTencentWidgetGridView.setVisibility(8);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewGroup = paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView.getLayoutParams();
      int i = AIOUtils.a(66.0F, jdField_a_of_type_AndroidContentContext.getResources());
      paramViewGroup.height = (jdField_a_of_type_Int - i);
      paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView.setLayoutParams(paramViewGroup);
    }
    for (;;)
    {
      return paramActivity;
      paramViewGroup = paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView.getLayoutParams();
      paramViewGroup.height = a();
      paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView.setLayoutParams(paramViewGroup);
      paramView.jdField_a_of_type_ComTencentWidgetGridView.setVisibility(0);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      a(paramActivity);
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    jdField_a_of_type_JavaUtilArrayList = a(paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionRecommendViewWrapper
 * JD-Core Version:    0.7.0.1
 */