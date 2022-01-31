package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import ajcg;
import ajch;
import ajci;
import ajcj;
import ajck;
import ajcl;
import ajeu;
import alud;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import bdaq;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;

public class ChooseItemView
  extends FrameLayout
{
  public ajcl a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(getContext());
  private String jdField_a_of_type_JavaLangString;
  private List<String> jdField_a_of_type_JavaUtilList = new LinkedList();
  private View.OnClickListener b;
  private View.OnClickListener c = new ajci(this);
  
  public ChooseItemView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    paramContext = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    paramContext.width = -1;
    paramContext.height = -2;
    setOnClickListener(new ajcg(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnTouchListener(new ajch(this));
  }
  
  private TextView a(Context paramContext, String paramString)
  {
    TextView localTextView = new TextView(paramContext);
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(paramString)))
    {
      localTextView.setTextColor(-1);
      localTextView.setBackgroundResource(2130846825);
    }
    for (;;)
    {
      localTextView.setTextSize(1, 13.0F);
      localTextView.setGravity(16);
      int i = bdaq.a(paramContext, 13.0F);
      localTextView.setPadding(i, 0, i, 0);
      localTextView.setText(paramString);
      localTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ajeu.a(localTextView, 0.6F);
      paramString = new LinearLayout.LayoutParams(-2, bdaq.a(paramContext, 30.0F));
      paramString.leftMargin = bdaq.a(paramContext, 12.0F);
      localTextView.setLayoutParams(paramString);
      localTextView.measure(0, 0);
      return localTextView;
      localTextView.setTextColor(-16578534);
      localTextView.setBackgroundResource(2130846824);
      if ((localTextView.getBackground() instanceof GradientDrawable)) {
        ((GradientDrawable)localTextView.getBackground()).setColor(-1315339);
      }
    }
  }
  
  private void b()
  {
    QLog.i("ChooseItemView", 2, "updatePageInner....");
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(bdaq.a(getContext(), 8.0F), 0, this.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingRight(), bdaq.a(getContext(), 10.0F));
    Object localObject1 = new TextView(getContext());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    Object localObject2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
    ((LinearLayout.LayoutParams)localObject2).height = -2;
    ((LinearLayout.LayoutParams)localObject2).width = -2;
    ((LinearLayout.LayoutParams)localObject2).gravity = 5;
    localObject2 = getContext().getResources().getDrawable(2130843042);
    ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
    ((TextView)localObject1).setCompoundDrawables((Drawable)localObject2, null, null, null);
    ((TextView)localObject1).setCompoundDrawablePadding(bdaq.a(getContext(), 7.0F));
    ((TextView)localObject1).setPadding(bdaq.a(getContext(), 5.0F), 0, bdaq.a(getContext(), 20.0F), bdaq.a(getContext(), 10.0F));
    ((TextView)localObject1).setText(alud.a(2131702207));
    ((TextView)localObject1).setTextColor(-1694379);
    ((TextView)localObject1).setTextSize(1, 14.0F);
    ((TextView)localObject1).setOnClickListener(this.c);
    ajeu.a((View)localObject1, 0.6F);
    int m = this.jdField_a_of_type_AndroidWidgetLinearLayout.getWidth();
    int i = 0;
    int j = 0;
    localObject2 = new LinearLayout(getContext());
    ((LinearLayout)localObject2).setOrientation(0);
    ((LinearLayout)localObject2).setGravity(16);
    int k = bdaq.a(getContext(), 6.0F);
    ((LinearLayout)localObject2).setPadding(0, k, 0, k);
    localObject1 = new LinearLayout.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    localObject1 = (String)this.jdField_a_of_type_JavaUtilList.get(i);
    localObject1 = a(getContext(), (String)localObject1);
    k = 0;
    for (;;)
    {
      k = ((TextView)localObject1).getMeasuredWidth() + bdaq.a(getContext(), 12.0F) + k;
      ((LinearLayout)localObject2).addView((View)localObject1);
      i += 1;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject1 = (String)this.jdField_a_of_type_JavaUtilList.get(i);
        localObject1 = a(getContext(), (String)localObject1);
      }
      if ((i >= this.jdField_a_of_type_JavaUtilList.size()) || (((TextView)localObject1).getMeasuredWidth() + k + bdaq.a(getContext(), 12.0F) * 2 > m))
      {
        j += 1;
        if ((j >= 4) || (i >= this.jdField_a_of_type_JavaUtilList.size())) {
          return;
        }
        break;
      }
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
  
  public void a(String paramString, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, ajcl paramajcl)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONArray(paramString);
        if (paramString != null)
        {
          int i = 0;
          while (i < paramString.length())
          {
            String str = paramString.optString(i);
            if (!TextUtils.isEmpty(str)) {
              this.jdField_a_of_type_JavaUtilList.add(str);
            }
            i += 1;
          }
        }
        this.jdField_a_of_type_AndroidViewView$OnClickListener = new ajck(this, paramOnClickListener1);
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 1)) {
          Collections.shuffle(this.jdField_a_of_type_JavaUtilList);
        }
      }
    }
    this.b = paramOnClickListener2;
    this.jdField_a_of_type_Ajcl = paramajcl;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if (!a()) {
      return;
    }
    setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.post(new ChooseItemView.3(this));
    QLog.i("ChooseItemView", 2, "show....");
  }
  
  public void a(List<String> paramList, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, ajcl paramajcl)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      try
      {
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
        if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 1)) {
          Collections.shuffle(this.jdField_a_of_type_JavaUtilList);
        }
        this.jdField_a_of_type_AndroidViewView$OnClickListener = new ajcj(this, paramOnClickListener1);
        this.b = paramOnClickListener2;
        this.jdField_a_of_type_Ajcl = paramajcl;
      }
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (this.jdField_a_of_type_Ajcl != null) {
      this.jdField_a_of_type_Ajcl.a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.ChooseItemView
 * JD-Core Version:    0.7.0.1
 */