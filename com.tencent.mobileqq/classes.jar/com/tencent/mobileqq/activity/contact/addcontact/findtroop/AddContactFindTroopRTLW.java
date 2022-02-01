package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import android.content.Context;
import android.os.Build.VERSION;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.contact.recommendtroop.RecommendTroopAdapterForAddContact;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.troop.adapter.RecommendTroopAdapter;
import com.tencent.mobileqq.troop.recommend.RecommendTroopListWrapper;
import com.tencent.mobileqq.troop.recommend.RecommendTroopListWrapper.RecommendTroopListWrapperCallback;
import com.tencent.mobileqq.troop.recommend.api.ITroopRecommendHandler;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class AddContactFindTroopRTLW
  extends RecommendTroopListWrapper
{
  static int c = 50;
  public int a;
  public AddContactFindTroopRTLW.onRefreshCallback a;
  String jdField_a_of_type_JavaLangString;
  ArrayList<RecommendTroopItem> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean = false;
  
  public AddContactFindTroopRTLW(QQAppInterface paramQQAppInterface, Context paramContext, XListView paramXListView, RecommendTroopListWrapper.RecommendTroopListWrapperCallback paramRecommendTroopListWrapperCallback, int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_ComTencentMobileqqTroopRecommendRecommendTroopListWrapper$RecommendTroopListWrapperCallback = paramRecommendTroopListWrapperCallback;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.d = false;
    a();
  }
  
  protected RecommendTroopAdapter a()
  {
    return new RecommendTroopAdapterForAddContact(this.jdField_a_of_type_AndroidContentContext, (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, false);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    b(false);
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
  }
  
  protected void a(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList, boolean paramBoolean3)
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.size();
    int j = paramArrayList.size();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetAddContactFindTroopNearbyTroopList isSuccess = ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(",itemType = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",this.itemType = ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(",serverPageID = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(",dataListSize = ");
      localStringBuilder.append(i);
      localStringBuilder.append(",newDataListSize = ");
      localStringBuilder.append(j);
      QLog.d("ac_ft.AddContactFindTroopRTLW", 2, localStringBuilder.toString());
    }
    if (paramInt1 == this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Boolean = paramBoolean2;
      if (paramBoolean1)
      {
        if (!paramBoolean3)
        {
          this.jdField_b_of_type_Boolean = true;
          this.jdField_a_of_type_JavaUtilArrayList.clear();
        }
        i = this.jdField_a_of_type_JavaUtilArrayList.size();
        int k = c;
        if (i + j >= k)
        {
          this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList.subList(0, k - i));
          this.jdField_a_of_type_Boolean = true;
          if (QLog.isColorLevel())
          {
            paramArrayList = new StringBuilder();
            paramArrayList.append("onGetAddContactFindTroopRecommendTroopList reach limit,this.dataList.size() = ");
            paramArrayList.append(this.jdField_a_of_type_JavaUtilArrayList.size());
            QLog.d("ac_ft.AddContactFindTroopRTLW", 2, paramArrayList.toString());
          }
        }
        else
        {
          this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
        }
        i = this.jdField_a_of_type_JavaUtilArrayList.size();
        b();
        if (QLog.isColorLevel())
        {
          paramArrayList = new StringBuilder();
          paramArrayList.append("onGetAddContactFindTroopNearbyTroopList do update Data,itemType = ");
          paramArrayList.append(paramInt1);
          paramArrayList.append(",this.itemType = ");
          paramArrayList.append(this.jdField_a_of_type_Int);
          paramArrayList.append(",serverPageID = ");
          paramArrayList.append(paramInt2);
          paramArrayList.append(",dataListSize = ");
          paramArrayList.append(i);
          paramArrayList.append(",newDataListSize = ");
          paramArrayList.append(j);
          QLog.d("ac_ft.AddContactFindTroopRTLW", 2, paramArrayList.toString());
        }
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          if (this.jdField_a_of_type_Boolean) {
            this.jdField_a_of_type_AndroidWidgetTextView.setText("没有更多内容了");
          }
        }
        this.jdField_b_of_type_Int = paramInt2;
      }
      paramArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopAddContactFindTroopRTLW$onRefreshCallback;
      if (paramArrayList != null) {
        paramArrayList.a(paramBoolean1, i);
      }
    }
  }
  
  protected void a(boolean paramBoolean1, int paramInt1, String paramString, int paramInt2, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList, boolean paramBoolean3)
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.size();
    int j = paramArrayList.size();
    this.jdField_a_of_type_Boolean = paramBoolean2;
    if ((paramInt1 == this.jdField_a_of_type_Int) && (paramString.equals(this.jdField_a_of_type_JavaLangString)))
    {
      if (paramBoolean1)
      {
        if (!paramBoolean3)
        {
          this.jdField_b_of_type_Boolean = true;
          this.jdField_a_of_type_JavaUtilArrayList.clear();
        }
        i = this.jdField_a_of_type_JavaUtilArrayList.size();
        int k = c;
        if (i + j >= k)
        {
          this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList.subList(0, k - i));
          this.jdField_a_of_type_Boolean = true;
          if (QLog.isColorLevel())
          {
            paramArrayList = new StringBuilder();
            paramArrayList.append("onGetAddContactFindTroopRecommendTroopList reach limit,this.dataList.size() = ");
            paramArrayList.append(this.jdField_a_of_type_JavaUtilArrayList.size());
            QLog.d("ac_ft.AddContactFindTroopRTLW", 2, paramArrayList.toString());
          }
        }
        else
        {
          this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
        }
        i = this.jdField_a_of_type_JavaUtilArrayList.size();
        b();
        if (QLog.isColorLevel())
        {
          paramArrayList = new StringBuilder();
          paramArrayList.append("onGetAddContactFindTroopRecommendTroopList,do update Data ,itemType = ");
          paramArrayList.append(paramInt1);
          paramArrayList.append(",this.itemType = ");
          paramArrayList.append(this.jdField_a_of_type_Int);
          paramArrayList.append(",keyWord = ");
          paramArrayList.append(paramString);
          paramArrayList.append(",this.keyWord = ");
          paramArrayList.append(this.jdField_a_of_type_JavaLangString);
          paramArrayList.append(",serverPageID = ");
          paramArrayList.append(paramInt2);
          paramArrayList.append(",dataListSize = ");
          paramArrayList.append(i);
          paramArrayList.append(",newDataListSize = ");
          paramArrayList.append(j);
          paramArrayList.append(",this = ");
          paramArrayList.append(this);
          QLog.d("ac_ft.AddContactFindTroopRTLW", 2, paramArrayList.toString());
        }
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          if (this.jdField_a_of_type_Boolean) {
            this.jdField_a_of_type_AndroidWidgetTextView.setText("没有更多内容了");
          }
        }
        this.jdField_b_of_type_Int = paramInt2;
      }
      paramString = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopAddContactFindTroopRTLW$onRefreshCallback;
      if (paramString != null) {
        paramString.a(paramBoolean1, i);
      }
    }
  }
  
  protected boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  void aa_()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0) {
      this.jdField_a_of_type_AndroidWidgetTextView.post(new AddContactFindTroopRTLW.2(this));
    }
  }
  
  protected void b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshListView,this.dataList.size() = ");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList.size());
      localStringBuilder.append(",needResetListViewPostion = ");
      localStringBuilder.append(this.jdField_b_of_type_Boolean);
      QLog.d("ac_ft.AddContactFindTroopRTLW", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopAdapterRecommendTroopAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqTroopAdapterRecommendTroopAdapter.notifyDataSetChanged();
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    ITroopRecommendHandler localITroopRecommendHandler = (ITroopRecommendHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_RECOMMEND_HANDLER);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getRecommendTroopList ,itemType = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(",keyWord = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(",loadMore = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(",this = ");
      ((StringBuilder)localObject).append(this);
      QLog.d("ac_ft.AddContactFindTroopRTLW", 2, ((StringBuilder)localObject).toString());
    }
    if (!paramBoolean)
    {
      this.jdField_b_of_type_Int = -1;
      this.jdField_a_of_type_Boolean = false;
    }
    aa_();
    int i = this.jdField_a_of_type_Int;
    int j = 1;
    boolean bool = true;
    if (i == 1)
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        if ((this.jdField_a_of_type_AndroidContentContext.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == -1) || (this.jdField_a_of_type_AndroidContentContext.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == -1)) {
          bool = false;
        }
        j = bool;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getRecommendTroopList  >= M, canRequestLocation = ");
          ((StringBuilder)localObject).append(bool);
          QLog.w("ac_ft.AddContactFindTroopRTLW", 2, ((StringBuilder)localObject).toString());
          j = bool;
        }
      }
      if (j != 0)
      {
        localObject = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("recommend_troop");
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getRecommendTroopList  >= M, info = ");
          localStringBuilder.append(localObject);
          QLog.i("ac_ft.AddContactFindTroopRTLW", 2, localStringBuilder.toString());
        }
        if (localObject == null)
        {
          ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(new AddContactFindTroopRTLW.1(this, "recommend_troop", localITroopRecommendHandler, paramBoolean));
          return;
        }
        localITroopRecommendHandler.a(1, this.jdField_b_of_type_Int, 25, paramBoolean, a());
      }
    }
    else
    {
      if (i == 0)
      {
        localITroopRecommendHandler.b(i, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int, 25, paramBoolean);
        return;
      }
      localITroopRecommendHandler.a(i, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int, 25, paramBoolean);
    }
  }
  
  public void c()
  {
    super.c();
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList != null) {
      localArrayList.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactFindTroopRTLW
 * JD-Core Version:    0.7.0.1
 */