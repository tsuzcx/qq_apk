package com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewParent;
import bggq;
import bgme;
import bgtn;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qlv;
import qlw;
import qlx;

public class ProteusRecycleView
  extends RecyclerViewWithHeaderFooter
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private SideBarView jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericSideBarView;
  private List<qlw> jdField_a_of_type_JavaUtilList;
  private qlx jdField_a_of_type_Qlx;
  private float jdField_b_of_type_Float;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
  public ProteusRecycleView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericSideBarView != null)
    {
      setClipToPadding(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericSideBarView.a(new qlv(this));
    }
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericSideBarView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericSideBarView.a(paramInt, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericSideBarView.d());
      int i = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericSideBarView.a();
      paramInt = i;
      if (i >= this.jdField_a_of_type_Int)
      {
        this.d = true;
        paramInt = this.jdField_a_of_type_Int;
      }
      scrollBy(paramInt, 0);
      setPadding(0, 0, paramInt, 0);
    }
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_Int = ((int)bgme.a(paramContext, 28.0F));
    setOverScrollMode(2);
  }
  
  private void b()
  {
    if (this.d)
    {
      this.d = false;
      if (this.jdField_a_of_type_Qlx != null) {
        this.jdField_a_of_type_Qlx.a();
      }
    }
  }
  
  public SideBarView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericSideBarView;
  }
  
  public void a(qlw paramqlw)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramqlw);
  }
  
  public void b(qlw paramqlw)
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.remove(paramqlw);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((qlw)localIterator.next()).a(paramMotionEvent);
      }
    }
    if (this.jdField_a_of_type_Qlx == null) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    int i = paramMotionEvent.getAction();
    float f2 = paramMotionEvent.getX();
    float f1 = paramMotionEvent.getY();
    if (i == 0)
    {
      this.jdField_a_of_type_Float = f2;
      this.jdField_b_of_type_Float = f1;
      this.jdField_b_of_type_Boolean = true;
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    boolean bool1;
    if (i == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProteusRecycleView", 2, "dispatchTouchEvent:ACTION_MOVE. mIsPress=" + this.jdField_b_of_type_Boolean);
      }
      if (this.c) {
        break label478;
      }
      if (!canScrollHorizontally(1)) {
        bool1 = true;
      }
    }
    for (;;)
    {
      f2 -= this.jdField_a_of_type_Float;
      f1 -= this.jdField_b_of_type_Float;
      if ((this.jdField_b_of_type_Boolean) && (Math.abs(f1) * 5.0F > Math.abs(f2) * 4.0F) && (Math.abs(f1) > bggq.a(getContext(), 3.0F)))
      {
        getParent().requestDisallowInterceptTouchEvent(false);
        bool1 = bool2;
        label234:
        if (QLog.isColorLevel()) {
          QLog.d("ProteusRecycleView", 2, "dispatchTouchEvent:bottom" + bool1 + " isCurShowSideBarView " + this.c + " dY:" + f1 + " dX:" + f2);
        }
        if ((bool1) || (this.c))
        {
          getParent().requestDisallowInterceptTouchEvent(true);
          this.c = true;
          a((int)-f2);
        }
      }
      for (;;)
      {
        return super.dispatchTouchEvent(paramMotionEvent);
        bool1 = false;
        break;
        getParent().requestDisallowInterceptTouchEvent(true);
        break label234;
        if ((i == 3) || (i == 1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ProteusRecycleView", 2, "dispatchTouchEvent:ACTION_CANCEL or UP. action=" + i + " mIsPress=" + this.jdField_b_of_type_Boolean + " isCurShowSideBarView:" + this.c);
          }
          getParent().requestDisallowInterceptTouchEvent(false);
          this.jdField_b_of_type_Boolean = false;
          if (this.c) {
            a();
          }
          this.c = false;
          if (f2 - this.jdField_a_of_type_Float < -bgtn.b(15.0F)) {
            b();
          }
        }
      }
      label478:
      bool1 = false;
    }
  }
  
  public void setOnStateChangeListener(qlx paramqlx)
  {
    this.jdField_a_of_type_Qlx = paramqlx;
  }
  
  public void setSideBarView(SideBarView paramSideBarView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericSideBarView = paramSideBarView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.ProteusRecycleView
 * JD-Core Version:    0.7.0.1
 */