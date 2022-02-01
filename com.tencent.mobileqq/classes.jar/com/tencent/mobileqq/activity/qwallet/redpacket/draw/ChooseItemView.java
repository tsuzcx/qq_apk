package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import akdh;
import akdi;
import akdj;
import akdk;
import akdl;
import akdn;
import akdo;
import akgd;
import amtj;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ChooseItemView
  extends FrameLayout
{
  private int jdField_a_of_type_Int = 4;
  public akdn a;
  public akdo a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(getContext());
  private String jdField_a_of_type_JavaLangString;
  private List<String> jdField_a_of_type_JavaUtilList = new LinkedList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private int jdField_c_of_type_Int = 0;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new akdj(this);
  
  public ChooseItemView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    paramContext = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    paramContext.width = -1;
    paramContext.height = -2;
    setOnClickListener(new akdh(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnTouchListener(new akdi(this));
  }
  
  private Paint a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
    {
      TextView localTextView = new TextView(getContext());
      localTextView.setTextSize(1, 13.0F);
      this.jdField_a_of_type_AndroidGraphicsPaint = localTextView.getPaint();
    }
    return this.jdField_a_of_type_AndroidGraphicsPaint;
  }
  
  private List<List<akdl>> a()
  {
    LinkedList localLinkedList2 = new LinkedList();
    int k = this.jdField_a_of_type_AndroidWidgetLinearLayout.getWidth();
    LinkedList localLinkedList1 = new LinkedList();
    int i = 0;
    int j = 0;
    if ((j < this.jdField_a_of_type_JavaUtilList.size()) && (a(localLinkedList2.size() + 1)))
    {
      String str = (String)this.jdField_a_of_type_JavaUtilList.get(j);
      boolean bool;
      label86:
      akdl localakdl;
      float f;
      if (j < this.jdField_b_of_type_Int)
      {
        bool = true;
        localakdl = new akdl(str, bool, false);
        f = a().measureText(str);
        f = DisplayUtil.dip2px(getContext(), 26.0F) + f;
        if (i + f + DisplayUtil.dip2px(getContext(), 12.0F) * 2 > k) {
          break label187;
        }
        localLinkedList1.add(localakdl);
      }
      for (i = (int)(i + (DisplayUtil.dip2px(getContext(), 12.0F) + f));; i = (int)f + DisplayUtil.dip2px(getContext(), 12.0F))
      {
        j += 1;
        break;
        bool = false;
        break label86;
        label187:
        localLinkedList2.add(localLinkedList1);
        localLinkedList1 = new LinkedList();
        localLinkedList1.add(localakdl);
      }
    }
    if (a(localLinkedList2.size() + 1)) {
      localLinkedList2.add(localLinkedList1);
    }
    return localLinkedList2;
  }
  
  private void a(View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, akdo paramakdo)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new akdk(this, paramOnClickListener1);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = paramOnClickListener2;
    this.jdField_a_of_type_Akdo = paramakdo;
  }
  
  private boolean a(int paramInt)
  {
    if (this.jdField_c_of_type_Int == 1) {}
    while (paramInt <= this.jdField_a_of_type_Int) {
      return true;
    }
    return false;
  }
  
  private void b()
  {
    QLog.i("ChooseItemView", 2, "updatePageInner....");
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(DisplayUtil.dip2px(getContext(), 8.0F), 0, this.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingRight(), DisplayUtil.dip2px(getContext(), 10.0F));
    c();
    Object localObject = new RecyclerView(getContext());
    this.jdField_a_of_type_Akdn = new akdn(a(), this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_Akdn.a(this.jdField_a_of_type_JavaLangString);
    ((RecyclerView)localObject).setAdapter(this.jdField_a_of_type_Akdn);
    ((RecyclerView)localObject).setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    localObject = (LinearLayout.LayoutParams)((RecyclerView)localObject).getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).width = -1;
    ((LinearLayout.LayoutParams)localObject).height = -1;
  }
  
  private void c()
  {
    if (this.jdField_c_of_type_Int == 0)
    {
      TextView localTextView = new TextView(getContext());
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localTextView);
      Object localObject = (LinearLayout.LayoutParams)localTextView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).height = -2;
      ((LinearLayout.LayoutParams)localObject).width = -2;
      ((LinearLayout.LayoutParams)localObject).gravity = 5;
      localObject = getContext().getResources().getDrawable(2130843469);
      ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
      localTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
      localTextView.setCompoundDrawablePadding(DisplayUtil.dip2px(getContext(), 7.0F));
      localTextView.setPadding(DisplayUtil.dip2px(getContext(), 5.0F), 0, DisplayUtil.dip2px(getContext(), 20.0F), DisplayUtil.dip2px(getContext(), 10.0F));
      localTextView.setText(amtj.a(2131700969));
      localTextView.setTextColor(-1694379);
      localTextView.setTextSize(1, 14.0F);
      localTextView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      akgd.a(localTextView, 0.6F);
    }
  }
  
  public void a()
  {
    setVisibility(8);
  }
  
  public void a(String paramString)
  {
    if (getVisibility() == 0)
    {
      a();
      return;
    }
    a(paramString, false);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (!a()) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaLangString = paramString;
      setVisibility(0);
    } while (this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.post(new ChooseItemView.3(this));
    QLog.i("ChooseItemView", 2, "show....");
  }
  
  public void a(List<String> paramList, boolean paramBoolean, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, akdo paramakdo)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      try
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          String str = (String)paramList.next();
          if (!TextUtils.isEmpty(str)) {
            this.jdField_a_of_type_JavaUtilList.add(str);
          }
        }
        return;
      }
      catch (Throwable paramList)
      {
        paramList.printStackTrace();
        if ((paramBoolean) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 1)) {
          Collections.shuffle(this.jdField_a_of_type_JavaUtilList);
        }
        a(paramOnClickListener1, paramOnClickListener2, paramakdo);
      }
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0);
  }
  
  public void setIsShow(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setMaxLines(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Int <= 0) {
      this.jdField_a_of_type_Int = 4;
    }
  }
  
  public void setRecommendCnt(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setStyle(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (this.jdField_a_of_type_Akdo != null) {
      this.jdField_a_of_type_Akdo.a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.ChooseItemView
 * JD-Core Version:    0.7.0.1
 */