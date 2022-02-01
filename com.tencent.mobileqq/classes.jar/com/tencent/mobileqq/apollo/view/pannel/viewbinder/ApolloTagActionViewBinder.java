package com.tencent.mobileqq.apollo.view.pannel.viewbinder;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.api.IApolloActionUsedManagerService;
import com.tencent.mobileqq.apollo.api.handler.IApolloExtensionObserver;
import com.tencent.mobileqq.apollo.api.impl.ApolloActionUsedManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloInfo;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanelListAdapter;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanelListView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ApolloTagButtonData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ApolloTagActionViewBinder
  extends ApolloSecondaryViewBinder
{
  private View jdField_a_of_type_AndroidViewView;
  private IApolloExtensionObserver jdField_a_of_type_ComTencentMobileqqApolloApiHandlerIApolloExtensionObserver = new ApolloTagActionViewBinder.5(this);
  private ApolloTagActionViewBinder.ApolloActionTagsAdapter jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder$ApolloActionTagsAdapter;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  String jdField_a_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("CMShow", "CMShowActionUsedTag", "最近使用");
  private ConcurrentHashMap<String, List<ApolloInfo>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private List<ApolloTagButtonData> b;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private List<Integer> jdField_c_of_type_JavaUtilList;
  private List<String> d;
  private List<ApolloInfo> e;
  
  public ApolloTagActionViewBinder(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    super(paramContext, paramQQAppInterface, paramSessionInfo);
    d();
  }
  
  public View a()
  {
    View localView = super.a();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqApolloApiHandlerIApolloExtensionObserver);
    }
    if (this.jdField_b_of_type_Int == 0) {
      a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView);
    }
    return localView;
  }
  
  public void a(View paramView, int paramInt)
  {
    super.a(paramView, paramInt);
  }
  
  public void a(ApolloPanelListView paramApolloPanelListView)
  {
    if (paramApolloPanelListView != null)
    {
      View localView = b();
      if ((localView != null) && (localView.getParent() == null) && (paramApolloPanelListView.findHeaderViewPosition(localView) == -1)) {
        paramApolloPanelListView.addHeaderView(localView);
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionWithTagsViewBinder", 4, "getTagAction.");
      }
      if (!paramBoolean) {
        break label297;
      }
      try
      {
        if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString) != null) && (((List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).size() > 0))
        {
          b((List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString));
          this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListAdapter.notifyDataSetChanged();
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("ApolloActionWithTagsViewBinder", 1, paramString, new Object[0]);
        return;
      }
      if (!this.jdField_a_of_type_JavaLangString.equals(paramString)) {
        break;
      }
      paramString = (ApolloActionUsedManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloActionUsedManagerService.class, "all");
    } while (paramString == null);
    Object localObject = paramString.getActionIdData(this.jdField_d_of_type_Int);
    if ((localObject == null) || (((List)localObject).size() < 1))
    {
      ThreadManagerV2.executeOnSubThread(new ApolloTagActionViewBinder.3(this, paramString));
      return;
    }
    paramString = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      int i = ((Integer)((Iterator)localObject).next()).intValue();
      Iterator localIterator = this.e.iterator();
      while (localIterator.hasNext())
      {
        ApolloInfo localApolloInfo = (ApolloInfo)localIterator.next();
        if ((localApolloInfo != null) && (i == localApolloInfo.mAction.actionId)) {
          paramString.add(localApolloInfo);
        }
      }
    }
    b(paramString);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListAdapter.notifyDataSetChanged();
    return;
    ThreadManagerV2.executeOnSubThread(new ApolloTagActionViewBinder.4(this, paramString));
    return;
    label297:
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView.removeHeaderView(this.jdField_c_of_type_AndroidWidgetTextView);
      }
    }
    b(this.e);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListAdapter.notifyDataSetChanged();
  }
  
  public void a(List<ApolloInfo> paramList)
  {
    super.a(paramList);
    if (paramList != null) {
      this.e.addAll(paramList);
    }
  }
  
  @NonNull
  public View b()
  {
    View localView = null;
    if (this.jdField_a_of_type_AndroidViewView != null) {
      localView = this.jdField_a_of_type_AndroidViewView;
    }
    while (this.jdField_a_of_type_AndroidContentContext == null) {
      return localView;
    }
    this.jdField_a_of_type_AndroidViewView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131558717, null);
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368524));
    }
    ThreadManagerV2.executeOnSubThread(new ApolloTagActionViewBinder.1(this));
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_c_of_type_JavaUtilList != null) {
      this.jdField_c_of_type_JavaUtilList.clear();
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    if (this.e != null) {
      this.e.clear();
    }
    if (this.jdField_d_of_type_JavaUtilList != null) {
      this.jdField_d_of_type_JavaUtilList.clear();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqApolloApiHandlerIApolloExtensionObserver);
    }
  }
  
  public void b(List<ApolloInfo> paramList)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      if (paramList != null) {
        this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      }
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.e = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  public void e()
  {
    ThreadManagerV2.getUIHandlerV2().post(new ApolloTagActionViewBinder.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloTagActionViewBinder
 * JD-Core Version:    0.7.0.1
 */