package com.tencent.mobileqq.activity.aio.intimate.view;

import agll;
import aglp;
import agmw;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import arau;
import arav;
import axge;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.data.IntimateInfo.DNAInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.Iterator;
import java.util.List;

public class IntimateContentItemOldDnaView
  extends IntimateContentItemBaseView
{
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  
  public IntimateContentItemOldDnaView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public IntimateContentItemOldDnaView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IntimateContentItemOldDnaView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void a()
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559320, this, true);
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131366004);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131367359));
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  protected void a(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_Agll.a() == null);
    paramView = new Intent(this.jdField_a_of_type_Agll.a(), FriendProfileMoreInfoActivity.class);
    this.jdField_a_of_type_Agll.a().startActivity(paramView);
  }
  
  protected void a(IntimateInfo paramIntimateInfo, int paramInt)
  {
    label51:
    IntimateInfo.DNAInfo localDNAInfo;
    if (this.jdField_a_of_type_Agll.a() == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      if ((paramIntimateInfo.dnaInfoList == null) || (paramIntimateInfo.dnaInfoList.size() <= 0)) {
        break label411;
      }
      Iterator localIterator = paramIntimateInfo.dnaInfoList.iterator();
      paramInt = 0;
      if (!localIterator.hasNext()) {
        break label411;
      }
      localDNAInfo = (IntimateInfo.DNAInfo)localIterator.next();
      paramIntimateInfo = null;
      if (this.jdField_a_of_type_Agll.a() != null) {
        paramIntimateInfo = this.jdField_a_of_type_Agll.a().a();
      }
      if (paramIntimateInfo != null) {
        break label412;
      }
      paramIntimateInfo = aglp.a(this.jdField_a_of_type_AndroidContentContext);
    }
    label411:
    label412:
    for (;;)
    {
      Object localObject = (TextView)paramIntimateInfo.findViewById(2131379102);
      TextView localTextView = (TextView)paramIntimateInfo.findViewById(2131378985);
      ((TextView)localObject).setText(localDNAInfo.wording);
      int i;
      if (localDNAInfo.viceTitle != null)
      {
        localObject = new SpannableString(localDNAInfo.viceTitle);
        if (!TextUtils.isEmpty(localDNAInfo.linkWording))
        {
          int k = localDNAInfo.viceTitle.indexOf(localDNAInfo.linkWording);
          int j = localDNAInfo.linkWording.length() + k;
          i = k;
          if (k < 0)
          {
            String str = localDNAInfo.viceTitle + localDNAInfo.linkWording;
            localObject = new SpannableString(str);
            i = localDNAInfo.viceTitle.length();
            j = str.length();
          }
          ((SpannableString)localObject).setSpan(new agmw(this, localDNAInfo), i, j, 33);
          localTextView.setText((CharSequence)localObject);
          localTextView.setMovementMethod(LinkMovementMethod.getInstance());
        }
      }
      for (;;)
      {
        localObject = new LinearLayout.LayoutParams(-1, -1);
        ((LinearLayout.LayoutParams)localObject).topMargin = ViewUtils.dip2px(16.0F);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramIntimateInfo, (ViewGroup.LayoutParams)localObject);
        paramInt += 1;
        break label51;
        i = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0);
          this.jdField_a_of_type_Agll.a().a(this.jdField_a_of_type_AndroidWidgetLinearLayout, (View)localObject);
          paramInt += 1;
        }
        break;
        localTextView.setText((CharSequence)localObject);
        continue;
        localTextView.setVisibility(8);
      }
      return;
    }
  }
  
  protected boolean a()
  {
    return (arav.a().c) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.dnaInfoList != null) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.dnaInfoList.size() > 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemOldDnaView
 * JD-Core Version:    0.7.0.1
 */