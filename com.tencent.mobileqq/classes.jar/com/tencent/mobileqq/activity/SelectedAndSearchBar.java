package com.tencent.mobileqq.activity;

import adru;
import adrv;
import adrw;
import adrx;
import adry;
import adrz;
import adsa;
import adsb;
import adsc;
import aekt;
import ajvi;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.text.Editable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bcvq;
import bcws;
import bcwt;
import com.tencent.mobileqq.activity.selectmember.CustomGridView;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.widget.CustomHorizontalScrollView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectedAndSearchBar
  extends RelativeLayout
  implements bcwt
{
  private float jdField_a_of_type_Float;
  private adsb jdField_a_of_type_Adsb;
  private adsc jdField_a_of_type_Adsc;
  private final ajvi jdField_a_of_type_Ajvi = new ajvi();
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private bcws jdField_a_of_type_Bcws;
  private CustomGridView jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCustomGridView;
  private CustomHorizontalScrollView jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView;
  private List<ResultRecord> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private ImageView b;
  
  public SelectedAndSearchBar(Context paramContext)
  {
    super(paramContext);
    e();
    f();
  }
  
  public SelectedAndSearchBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    e();
    f();
  }
  
  public SelectedAndSearchBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e();
    f();
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131562622, this);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCustomGridView = ((CustomGridView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376321));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131376217));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368172));
    this.b = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376211));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView = ((CustomHorizontalScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376154));
    bcvq.a(this.jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView, false);
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView.setOverScrollMode(2);
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCustomGridView.setOverScrollMode(2);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCustomGridView.setOnItemClickListener(new adru(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(new adrv(this));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new adrw(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new adrx(this));
  }
  
  private void f()
  {
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidContentContext = getContext();
  }
  
  public Editable a()
  {
    return this.jdField_a_of_type_AndroidWidgetEditText.getText();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
  }
  
  public void a(long paramLong)
  {
    int i = aekt.a(60.0F, getResources());
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { -i, 0 });
    localValueAnimator.setDuration(paramLong);
    localValueAnimator.addUpdateListener(new adrz(this, localLayoutParams));
    localValueAnimator.start();
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new adry(this, paramOnClickListener));
  }
  
  public void a(List<ResultRecord> paramList, bcws parambcws, adsc paramadsc)
  {
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList = paramList;
    }
    this.jdField_a_of_type_Bcws = parambcws;
    this.jdField_a_of_type_Adsc = paramadsc;
    this.jdField_a_of_type_Adsb = new adsb(this);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCustomGridView.setAdapter(this.jdField_a_of_type_Adsb);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCustomGridView.setSmoothScrollbarEnabled(false);
    this.jdField_a_of_type_Bcws.a(this);
  }
  
  public void a(List<ResultRecord> paramList, boolean paramBoolean)
  {
    Collections.sort(paramList, this.jdField_a_of_type_Ajvi);
    this.jdField_a_of_type_JavaUtilList = paramList;
    a(paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCustomGridView.setNumColumns(this.jdField_a_of_type_JavaUtilList.size());
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCustomGridView.getLayoutParams();
    localLayoutParams.width = ((int)((this.jdField_a_of_type_JavaUtilList.size() * 40 + this.jdField_a_of_type_JavaUtilList.size() * 10) * this.jdField_a_of_type_Float));
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCustomGridView.setLayoutParams(localLayoutParams);
    d();
    if (paramBoolean) {
      postDelayed(new SelectedAndSearchBar.6(this), 200L);
    }
    this.jdField_a_of_type_Adsb.notifyDataSetChanged();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidWidgetEditText.hasFocus();
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
  }
  
  public void b(long paramLong)
  {
    int i = aekt.a(60.0F, getResources());
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, -i });
    localValueAnimator.setDuration(paramLong);
    localValueAnimator.addUpdateListener(new adsa(this, localLayoutParams));
    localValueAnimator.start();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView.scrollTo(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCustomGridView.getLayoutParams().width, 0);
  }
  
  public void d()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)(this.jdField_a_of_type_Float * 40.0F));
    int i = (int)(this.jdField_a_of_type_Float * 40.0F);
    int j = (int)(this.jdField_a_of_type_Float * 10.0F);
    if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
      if (this.jdField_a_of_type_JavaUtilList.size() < 5)
      {
        i = (int)((this.jdField_a_of_type_JavaUtilList.size() * 40 + this.jdField_a_of_type_JavaUtilList.size() * 10) * this.jdField_a_of_type_Float) + (int)(this.jdField_a_of_type_Float * 10.0F);
        this.b.setVisibility(8);
      }
    }
    for (;;)
    {
      localLayoutParams.addRule(15);
      localLayoutParams.setMargins(i, 0, j, 0);
      this.jdField_a_of_type_AndroidWidgetEditText.setLayoutParams(localLayoutParams);
      return;
      i = (int)(230.0F * this.jdField_a_of_type_Float);
      break;
      this.b.setVisibility(0);
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCustomGridView == null) {}
    for (;;)
    {
      return;
      paramInt1 = 0;
      while (paramInt1 < this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCustomGridView.getChildCount())
      {
        View localView = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCustomGridView.getChildAt(paramInt1);
        Object localObject = localView.getTag();
        if ((localObject != null) && ((localObject instanceof ResultRecord)))
        {
          localObject = (ResultRecord)localObject;
          if ((paramString.equals(((ResultRecord)localObject).jdField_a_of_type_JavaLangString)) && (((ResultRecord)localObject).jdField_a_of_type_Int == paramInt2)) {
            ((ImageView)localView.findViewById(2131365910)).setBackgroundDrawable(new BitmapDrawable(getResources(), paramBitmap));
          }
        }
        paramInt1 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SelectedAndSearchBar
 * JD-Core Version:    0.7.0.1
 */