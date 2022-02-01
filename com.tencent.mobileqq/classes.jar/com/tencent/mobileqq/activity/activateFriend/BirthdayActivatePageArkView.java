package com.tencent.mobileqq.activity.activateFriend;

import afmi;
import agnx;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import bhid;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class BirthdayActivatePageArkView
  extends ActivateBasePage
{
  agnx jdField_a_of_type_Agnx;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public ArkAppView a;
  public final String a;
  private TextView f;
  
  public BirthdayActivatePageArkView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangString = "BirthdayActivatePageArkView";
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560950, this, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((ArkAppView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374312));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131361999));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366187));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362013));
    this.f = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366171));
    addView(this.jdField_a_of_type_AndroidViewView);
  }
  
  public void a(long paramLong, String paramString, int paramInt)
  {
    for (;;)
    {
      try
      {
        Object localObject = bhid.a(getContext(), 3, paramLong);
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        if (TextUtils.isEmpty(paramString))
        {
          g();
          return;
        }
        h();
        if (getContext() != null)
        {
          i = getContext().getResources().getDisplayMetrics().widthPixels;
          i -= ViewUtils.dpToPx(84.0F);
          paramInt -= ViewUtils.dpToPx(35.0F);
          localObject = new ArkAppMessage();
          ((ArkAppMessage)localObject).fromAppXml(paramString);
          if (this.jdField_a_of_type_Agnx != null)
          {
            QLog.i("BirthdayActivatePageArkView", 1, "@arkgif  initdata destroy");
            this.jdField_a_of_type_Agnx.doOnEvent(2);
          }
          this.jdField_a_of_type_Agnx = new agnx();
          QLog.i("BirthdayActivatePageArkView", 1, "@arkgif  arkAppContainer  init height =" + paramInt);
          this.jdField_a_of_type_Agnx.a(((ArkAppMessage)localObject).appName, ((ArkAppMessage)localObject).appView, ((ArkAppMessage)localObject).appMinVersion, ((ArkAppMessage)localObject).metaList, getResources().getDisplayMetrics().scaledDensity, new SessionInfo());
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView);
          this.jdField_a_of_type_Agnx.setFixSize(i, paramInt);
          this.jdField_a_of_type_Agnx.setMaxSize(i, paramInt);
          this.jdField_a_of_type_Agnx.setMinSize(i, paramInt);
          paramString = new afmi(this);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setLoadCallback(paramString);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.initArkView(this.jdField_a_of_type_Agnx);
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("BirthdayActivatePageArkView", 1, "@arkgif  initdata erro" + paramString.toString());
        return;
      }
      int i = ViewUtils.getScreenWidth();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setAlpha(1.0F);
    }
    for (;;)
    {
      findViewById(2131361997).setVisibility(8);
      QLog.i("BirthdayActivatePageArkView", 1, "@arkgif  hideLoading");
      return;
      g();
    }
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_Agnx != null)
    {
      QLog.i("BirthdayActivatePageArkView", 1, "@arkgif  destroy");
      this.jdField_a_of_type_Agnx.doOnEvent(2);
    }
  }
  
  public void e()
  {
    a(true);
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setAlpha(0.0F);
    findViewById(2131361997).setVisibility(0);
    QLog.i("BirthdayActivatePageArkView", 1, "@arkgif  showLoading");
  }
  
  public void g()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130844680));
    this.f.setVisibility(0);
  }
  
  public void h()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.BirthdayActivatePageArkView
 * JD-Core Version:    0.7.0.1
 */