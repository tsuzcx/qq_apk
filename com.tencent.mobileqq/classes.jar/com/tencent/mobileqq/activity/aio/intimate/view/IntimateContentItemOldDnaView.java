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
  private LinearLayout i;
  private View j;
  
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
  
  protected void a(View paramView)
  {
    if (paramView.getId() != 2131432346) {
      return;
    }
    if (this.h.l() != null)
    {
      paramView = new Intent(this.h.l(), FriendProfileMoreInfoActivity.class);
      this.h.l().startActivity(paramView);
    }
  }
  
  protected void a(IntimateInfo paramIntimateInfo, int paramInt)
  {
    int k;
    Object localObject;
    if (this.h.m() == null)
    {
      this.i.removeAllViews();
    }
    else
    {
      k = this.i.getChildCount();
      paramInt = 0;
      while (paramInt < k)
      {
        localObject = this.i.getChildAt(0);
        this.h.m().a(this.i, (View)localObject);
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
        if (this.h.m() != null) {
          paramIntimateInfo = this.h.m().r();
        }
        localObject = paramIntimateInfo;
        if (paramIntimateInfo == null) {
          localObject = IntimateUtil.a(this.a);
        }
        paramIntimateInfo = (TextView)((View)localObject).findViewById(2131447585);
        TextView localTextView = (TextView)((View)localObject).findViewById(2131447443);
        paramIntimateInfo.setText(localDNAInfo.wording);
        if (localDNAInfo.viceTitle != null)
        {
          paramIntimateInfo = new SpannableString(localDNAInfo.viceTitle);
          if (!TextUtils.isEmpty(localDNAInfo.linkWording))
          {
            int m = localDNAInfo.viceTitle.indexOf(localDNAInfo.linkWording);
            k = localDNAInfo.linkWording.length() + m;
            paramInt = m;
            if (m < 0)
            {
              paramIntimateInfo = new StringBuilder();
              paramIntimateInfo.append(localDNAInfo.viceTitle);
              paramIntimateInfo.append(localDNAInfo.linkWording);
              String str = paramIntimateInfo.toString();
              paramIntimateInfo = new SpannableString(str);
              paramInt = localDNAInfo.viceTitle.length();
              k = str.length();
            }
            paramIntimateInfo.setSpan(new IntimateContentItemOldDnaView.1(this, localDNAInfo), paramInt, k, 33);
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
        paramIntimateInfo.topMargin = ViewUtils.dip2px(16.0F);
        this.i.addView((View)localObject, paramIntimateInfo);
      }
    }
  }
  
  protected boolean a()
  {
    return (FriendIntimateRelationshipConfProcessor.a().Y) && (this.d.dnaInfoList != null) && (this.d.dnaInfoList.size() > 0);
  }
  
  protected void b()
  {
    View localView = LayoutInflater.from(this.a).inflate(2131625181, this, true);
    this.j = localView.findViewById(2131432346);
    this.i = ((LinearLayout)localView.findViewById(2131433761));
    this.j.setOnTouchListener(this);
    this.j.setOnClickListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemOldDnaView
 * JD-Core Version:    0.7.0.1
 */