package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.ArrayList;
import java.util.List;

public class InnerListView
  extends LinearLayout
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private InnerListView.OnItemClickListener jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView$OnItemClickListener;
  private InnerListView.OnItemLongClickListener jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView$OnItemLongClickListener;
  private InnerListViewAdapter jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListViewAdapter;
  private List<BaseViewHolder> jdField_a_of_type_JavaUtilList;
  private List<View> b;
  
  public InnerListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public InnerListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InnerListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public int a()
  {
    if (this.b != null) {
      return this.b.size();
    }
    return 0;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListViewAdapter != null)
    {
      if ((this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListViewAdapter.a() != null) && (!this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListViewAdapter.a().isEmpty()))
      {
        int j = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListViewAdapter.a().size();
        if (j < getChildCount() - a()) {
          removeViews(j, getChildCount() - j - a());
        }
        int i = 0;
        if (i < j)
        {
          Object localObject;
          if (this.jdField_a_of_type_JavaUtilList.size() - 1 >= i) {
            localObject = (BaseViewHolder)this.jdField_a_of_type_JavaUtilList.get(i);
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListViewAdapter.a(i, (BaseViewHolder)localObject);
            localObject = ((BaseViewHolder)localObject).a();
            if (((View)localObject).getParent() == null) {
              addView((View)localObject, getChildCount() - a());
            }
            ((View)localObject).setOnClickListener(new InnerListView.1(this, i));
            ((View)localObject).setOnLongClickListener(new InnerListView.2(this, i));
            i += 1;
            break;
            localObject = new BaseViewHolder(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListViewAdapter.a(), this, false));
            this.jdField_a_of_type_JavaUtilList.add(localObject);
          }
        }
      }
      else
      {
        removeViews(0, getChildCount() - a());
      }
      return;
    }
    removeViews(0, getChildCount() - a());
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    long l = System.currentTimeMillis();
    int i = 0;
    while (i < paramInt2)
    {
      BaseViewHolder localBaseViewHolder = new BaseViewHolder(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(paramInt1, this, false));
      this.jdField_a_of_type_JavaUtilList.add(localBaseViewHolder);
      i += 1;
    }
    SLog.e("DEBUG_TIME", "InnerListView initVHCaches:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  public void a(View paramView)
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    this.b.add(paramView);
    addView(paramView);
  }
  
  public void setAdapter(InnerListViewAdapter paramInnerListViewAdapter)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListViewAdapter = paramInnerListViewAdapter;
    a();
  }
  
  public void setFooterView(int paramInt, View paramView)
  {
    if ((this.b == null) || (this.b.size() <= paramInt))
    {
      a(paramView);
      return;
    }
    this.b.set(paramInt, paramView);
    paramInt = getChildCount() - a() + paramInt;
    removeViewAt(paramInt);
    addView(paramView, paramInt);
  }
  
  public void setOnItemClickListener(InnerListView.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView$OnItemClickListener = paramOnItemClickListener;
  }
  
  public void setOnItemLongClickListener(InnerListView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView$OnItemLongClickListener = paramOnItemLongClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.InnerListView
 * JD-Core Version:    0.7.0.1
 */