package com.tencent.mobileqq.activity.aio.intimate.view;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.aio.intimate.BaseIntimateView;
import com.tencent.mobileqq.activity.aio.intimate.IntimateUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipBean;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipConfProcessor;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.data.IntimateInfo.DNAInfo;
import com.tencent.mobileqq.multicard.MultiCardCustomViewDelegate;
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
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559260, this, true);
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131366070);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131367304));
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  protected void a(View paramView)
  {
    if (paramView.getId() != 2131366070) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a() != null)
    {
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), FriendProfileMoreInfoActivity.class);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a().startActivity(paramView);
    }
  }
  
  protected void a(IntimateInfo paramIntimateInfo, int paramInt)
  {
    int i;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a() == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    }
    else
    {
      i = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a().a(this.jdField_a_of_type_AndroidWidgetLinearLayout, (View)localObject);
        paramInt += 1;
      }
    }
    if ((paramIntimateInfo.dnaInfoList != null) && (paramIntimateInfo.dnaInfoList.size() > 0))
    {
      Iterator localIterator = paramIntimateInfo.dnaInfoList.iterator();
      while (localIterator.hasNext())
      {
        IntimateInfo.DNAInfo localDNAInfo = (IntimateInfo.DNAInfo)localIterator.next();
        paramIntimateInfo = null;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a() != null) {
          paramIntimateInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a().a();
        }
        localObject = paramIntimateInfo;
        if (paramIntimateInfo == null) {
          localObject = IntimateUtil.a(this.jdField_a_of_type_AndroidContentContext);
        }
        paramIntimateInfo = (TextView)((View)localObject).findViewById(2131378884);
        TextView localTextView = (TextView)((View)localObject).findViewById(2131378768);
        paramIntimateInfo.setText(localDNAInfo.wording);
        if (localDNAInfo.viceTitle != null)
        {
          paramIntimateInfo = new SpannableString(localDNAInfo.viceTitle);
          if (!TextUtils.isEmpty(localDNAInfo.linkWording))
          {
            int j = localDNAInfo.viceTitle.indexOf(localDNAInfo.linkWording);
            i = localDNAInfo.linkWording.length() + j;
            paramInt = j;
            if (j < 0)
            {
              paramIntimateInfo = new StringBuilder();
              paramIntimateInfo.append(localDNAInfo.viceTitle);
              paramIntimateInfo.append(localDNAInfo.linkWording);
              String str = paramIntimateInfo.toString();
              paramIntimateInfo = new SpannableString(str);
              paramInt = localDNAInfo.viceTitle.length();
              i = str.length();
            }
            paramIntimateInfo.setSpan(new IntimateContentItemOldDnaView.1(this, localDNAInfo), paramInt, i, 33);
            localTextView.setText(paramIntimateInfo);
            localTextView.setMovementMethod(LinkMovementMethod.getInstance());
          }
          else
          {
            localTextView.setText(paramIntimateInfo);
          }
        }
        else
        {
          localTextView.setVisibility(8);
        }
        paramIntimateInfo = new LinearLayout.LayoutParams(-1, -1);
        paramIntimateInfo.topMargin = ViewUtils.a(16.0F);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject, paramIntimateInfo);
      }
    }
  }
  
  protected boolean a()
  {
    return (FriendIntimateRelationshipConfProcessor.a().c) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.dnaInfoList != null) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.dnaInfoList.size() > 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemOldDnaView
 * JD-Core Version:    0.7.0.1
 */