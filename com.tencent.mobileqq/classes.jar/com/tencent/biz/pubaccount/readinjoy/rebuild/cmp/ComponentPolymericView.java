package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.ComponentInheritView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell.CellListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.OnHorizontalSubArticleClick;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.List;
import lwm;
import org.json.JSONObject;

public class ComponentPolymericView
  extends HorizontalListView
  implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, ComponentInheritView
{
  private float jdField_a_of_type_Float;
  private Context jdField_a_of_type_AndroidContentContext;
  private CmpCtxt jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private lwm jdField_a_of_type_Lwm;
  private float b;
  private boolean e;
  
  public ComponentPolymericView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramContext);
  }
  
  public View a(Context paramContext)
  {
    return this;
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt = new CmpCtxt();
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    setOverScrollMode(2);
    this.jdField_a_of_type_Lwm = new lwm(this, null);
    setAdapter(this.jdField_a_of_type_Lwm);
    setDividerWidth(AIOUtils.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    setOnItemClickListener(this);
    setOnItemLongClickListener(this);
  }
  
  public void a(FeedItemCell.CellListener paramCellListener) {}
  
  public void a(Object paramObject)
  {
    paramObject = (IReadInJoyModel)paramObject;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a(paramObject);
    paramObject = paramObject.a().mGroupSubArticleList;
    if (paramObject.size() > 2) {
      setOverScrollMode(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilList = paramObject;
      this.jdField_a_of_type_Lwm.notifyDataSetChanged();
      return;
      setOverScrollMode(2);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f3 = paramMotionEvent.getY();
    if (i == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView dispatchTouchEvent:ACTION_DOWN. mIsPress=" + this.e);
      }
      this.jdField_a_of_type_Float = f1;
      this.b = f3;
      getParent().requestDisallowInterceptTouchEvent(true);
      this.e = true;
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (i == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView dispatchTouchEvent:ACTION_MOVE. mIsPress=" + this.e);
      }
      float f2 = this.jdField_a_of_type_Float;
      f3 -= this.b;
      if ((this.e) && (Math.abs(f3) * 5.0F > Math.abs(f1 - f2) * 4.0F) && (Math.abs(f3) > DisplayUtil.a(getContext(), 5.0F))) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      getParent().requestDisallowInterceptTouchEvent(true);
      continue;
      if ((i == 3) || (i == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView dispatchTouchEvent:ACTION_CANCEL or UP. action=" + i + " mIsPress=" + this.e);
        }
        this.e = false;
      }
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (BaseArticleInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().a().a(paramAdapterView, paramView, paramInt, paramLong);
    paramView = ReadInJoyUtils.a(paramAdapterView.mPolymericInfo);
    for (;;)
    {
      try
      {
        paramView.put("rowkey", paramAdapterView.innerUniqueID);
        i = 0;
        switch (this.jdField_a_of_type_Lwm.getItemViewType(paramInt))
        {
        }
      }
      catch (Exception localException)
      {
        int i;
        localException.printStackTrace();
        continue;
        continue;
      }
      paramView.put("content_type", i);
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8008F56", "0X8008F56", 0, 0, paramInt + "", paramAdapterView.mArticleID + "", paramAdapterView.mStrategyId + "", paramView.toString(), false);
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  public boolean onItemLongClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPolymericView
 * JD-Core Version:    0.7.0.1
 */