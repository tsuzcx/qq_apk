package com.tencent.biz.pubaccount.readinjoy.report;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserActionCollector$OnScrollChangeListenerWrapper
  implements AbsListView.OnScrollListener
{
  private int jdField_a_of_type_Int;
  public long a;
  public ArrayList<UserActionCollector.FeedScrollStateInfo> a;
  public HashMap<String, Integer> a;
  public boolean a;
  public long b;
  public long c = 0L;
  
  public UserActionCollector$OnScrollChangeListenerWrapper(UserActionCollector paramUserActionCollector)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, AbsListView paramAbsListView)
  {
    int j = paramAbsListView.getChildCount();
    int k = paramAbsListView.getFirstVisiblePosition();
    int i = 0;
    if (i < j)
    {
      View localView = paramAbsListView.getChildAt(i);
      Object localObject1 = UserActionCollector.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReportUserActionCollector, paramAbsListView, k + i);
      label110:
      Object localObject2;
      if ((localObject1 instanceof BaseArticleInfo))
      {
        localObject1 = (BaseArticleInfo)localObject1;
        String str = UserActionCollector.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReportUserActionCollector, (BaseArticleInfo)localObject1);
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(str)) {
          break label262;
        }
        localObject1 = (UserActionCollector.FeedScrollStateInfo)this.jdField_a_of_type_JavaUtilArrayList.get(((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(str)).intValue());
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          this.jdField_a_of_type_Int += localView.getHeight();
          localObject2 = new UserActionCollector.FeedScrollStateInfo(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReportUserActionCollector);
          ((UserActionCollector.FeedScrollStateInfo)localObject2).jdField_a_of_type_JavaLangString = str;
          ((UserActionCollector.FeedScrollStateInfo)localObject2).jdField_a_of_type_Int = localView.getHeight();
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
          this.jdField_a_of_type_JavaUtilHashMap.put(str, Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size() - 1));
        }
        if (!paramBoolean1) {
          break label268;
        }
        ((UserActionCollector.FeedScrollStateInfo)localObject2).jdField_b_of_type_Int = localView.getTop();
        ((UserActionCollector.FeedScrollStateInfo)localObject2).d = localView.getBottom();
        label219:
        localObject1 = UserActionCollector.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReportUserActionCollector, localView);
        if ((localObject1 == null) || (((UserActionCollector.FeedScrollStateInfo)localObject2).jdField_a_of_type_Long != 0L)) {
          break label295;
        }
        ((UserActionCollector.FeedScrollStateInfo)localObject2).jdField_a_of_type_Long = System.currentTimeMillis();
      }
      for (;;)
      {
        i += 1;
        break;
        label262:
        localObject1 = null;
        break label110;
        label268:
        if (!paramBoolean2) {
          break label219;
        }
        ((UserActionCollector.FeedScrollStateInfo)localObject2).c = localView.getTop();
        ((UserActionCollector.FeedScrollStateInfo)localObject2).e = localView.getBottom();
        break label219;
        label295:
        if (localObject1 != null)
        {
          ((UserActionCollector.FeedScrollStateInfo)localObject2).jdField_b_of_type_Long = System.currentTimeMillis();
          localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReportUserActionCollector.a();
          ((UserActionCollector.FeedScrollStateInfo)localObject2).jdField_a_of_type_Double = ((localObject1[1] - localObject1[0]) * 1.0F / (float)(((UserActionCollector.FeedScrollStateInfo)localObject2).jdField_b_of_type_Long - ((UserActionCollector.FeedScrollStateInfo)localObject2).jdField_a_of_type_Long));
        }
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Boolean) {
      a(false, false, paramAbsListView);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramAbsListView == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReportUserActionCollector.jdField_a_of_type_Long == 0L)) {
      return;
    }
    UserActionCollector.GestureEvent localGestureEvent;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      a(false, true, paramAbsListView);
      float[] arrayOfFloat = ((ReadInJoyXListView)paramAbsListView).a;
      paramAbsListView = ((ReadInJoyXListView)paramAbsListView).b;
      UserActionCollector.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReportUserActionCollector, new int[4]);
      UserActionCollector.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReportUserActionCollector)[0] = ((int)arrayOfFloat[0]);
      UserActionCollector.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReportUserActionCollector)[1] = ((int)arrayOfFloat[1]);
      UserActionCollector.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReportUserActionCollector)[2] = ((int)paramAbsListView[0]);
      UserActionCollector.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReportUserActionCollector)[3] = ((int)paramAbsListView[1]);
      localGestureEvent = new UserActionCollector.GestureEvent(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReportUserActionCollector);
      if (paramAbsListView[1] - arrayOfFloat[1] > 0.0F)
      {
        paramInt = 2;
        localGestureEvent.jdField_a_of_type_Int = paramInt;
        localGestureEvent.jdField_b_of_type_Long = (this.jdField_a_of_type_Int - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReportUserActionCollector.i);
        localGestureEvent.c = (System.currentTimeMillis() - this.jdField_b_of_type_Long);
        localGestureEvent.jdField_a_of_type_Float = ((float)localGestureEvent.jdField_b_of_type_Long * 1.0F / (float)localGestureEvent.c);
        if (this.c != 0L) {
          break label443;
        }
      }
      break;
    }
    label443:
    for (long l = this.jdField_b_of_type_Long - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReportUserActionCollector.jdField_a_of_type_Long;; l = this.jdField_b_of_type_Long - this.c)
    {
      localGestureEvent.jdField_a_of_type_Long = l;
      localGestureEvent.jdField_a_of_type_JavaLangString = (UserActionCollector.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReportUserActionCollector)[0] + "_" + UserActionCollector.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReportUserActionCollector)[1] + "_" + UserActionCollector.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReportUserActionCollector)[2] + "_" + UserActionCollector.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReportUserActionCollector)[3]);
      localGestureEvent.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReportUserActionCollector.b.add(localGestureEvent);
      this.c = System.currentTimeMillis();
      this.jdField_a_of_type_Boolean = false;
      return;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReportUserActionCollector.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      if (this.jdField_a_of_type_Long == 0L) {
        this.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
      }
      UserActionCollector.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReportUserActionCollector, paramAbsListView, false);
      a(true, false, paramAbsListView);
      return;
      paramInt = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.report.UserActionCollector.OnScrollChangeListenerWrapper
 * JD-Core Version:    0.7.0.1
 */