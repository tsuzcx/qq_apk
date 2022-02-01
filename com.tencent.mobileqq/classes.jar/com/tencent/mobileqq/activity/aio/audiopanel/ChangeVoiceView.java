package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anzj;
import bhgr;
import bilc;
import bild;
import bile;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ChangeVoiceView
  extends RelativeLayout
{
  public static String a;
  public int a;
  private long jdField_a_of_type_Long;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public bilc a;
  private CircleProgressView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView;
  private VolumeIndicateSquareView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView;
  private boolean jdField_a_of_type_Boolean;
  public int b;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public int c;
  private ImageView c;
  private int d;
  
  static
  {
    jdField_a_of_type_JavaLangString = anzj.a(2131700423);
  }
  
  public ChangeVoiceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_c_of_type_Int = 0;
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setRingWidth(10);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setRingColor(getResources().getColor(2131166978));
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bilc == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(0);
    if (paramInt == 2)
    {
      setContentDescription(jdField_a_of_type_JavaLangString);
      label28:
      if (this.jdField_c_of_type_Int == paramInt) {
        break label180;
      }
      this.jdField_c_of_type_Int = paramInt;
      if (paramInt != 0) {
        break label204;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130838389);
      if (this.jdField_a_of_type_Bilc.jdField_b_of_type_Int != 1) {
        break label182;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(2137417318);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setPadding(this.d, 0, this.d, 0);
      return;
      if (paramInt == 1)
      {
        setContentDescription(getContext().getString(2131690977) + " " + this.jdField_a_of_type_Bilc.jdField_b_of_type_JavaLangString);
        break label28;
      }
      setContentDescription(this.jdField_a_of_type_Bilc.jdField_b_of_type_JavaLangString);
      break label28;
      label180:
      break;
      label182:
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getContext().getResources().getColor(2131165275));
      continue;
      label204:
      if (paramInt == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.setVisibility(8);
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130847798);
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        }
        else
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130838390);
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
        }
      }
      else if (paramInt == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.a();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.setVisibility(0);
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130847798);
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        }
        else
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130838390);
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(paramInt1);
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    }
    while (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long >= 75L)
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      StringBuilder localStringBuilder = new StringBuilder();
      paramInt2 /= 1000;
      paramInt1 = paramInt2 / 60;
      paramInt2 %= 60;
      localStringBuilder.append(paramInt1).append(":");
      if (paramInt2 < 10) {
        localStringBuilder.append("0");
      }
      localStringBuilder.append(paramInt2);
      if (!localStringBuilder.equals(this.jdField_a_of_type_AndroidWidgetTextView.getText())) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localStringBuilder);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.a(paramInt3);
      return;
    }
  }
  
  public void a(bilc parambilc)
  {
    int i = 1;
    if (parambilc != null) {}
    for (boolean bool = true;; bool = false)
    {
      super.setEnabled(bool);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131366784));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131366785));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131364356));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131364358));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView = ((CircleProgressView)super.findViewById(2131364357));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131364361));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView = ((VolumeIndicateSquareView)super.findViewById(2131364362));
      if (parambilc != null) {
        break;
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(null);
      super.setContentDescription(null);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130838389);
      return;
    }
    this.d = bhgr.a(getContext(), 4.0F);
    this.jdField_a_of_type_Int = parambilc.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setStrokeWidth(4);
    this.jdField_a_of_type_Bilc = parambilc;
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    label295:
    Object localObject1;
    label326:
    Object localObject3;
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    if (parambilc.jdField_a_of_type_Bild.jdField_a_of_type_Int > 0)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(parambilc.jdField_a_of_type_Bild.jdField_a_of_type_Int);
      if (parambilc.jdField_c_of_type_Int == 0) {
        break label805;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (parambilc.jdField_c_of_type_Int != 1) {
        break label792;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847374);
      if (parambilc.d == 1) {
        break label857;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (parambilc.d != 4) {
        break label817;
      }
      localObject1 = bile.jdField_a_of_type_ArrayOfJavaLangString[0];
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label874;
      }
      localObject3 = new File(bile.jdField_a_of_type_JavaLangString + ((String)localObject1).substring(((String)localObject1).lastIndexOf("/") + 1));
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      if ((!((File)localObject3).exists()) || (!((File)localObject3).isFile())) {
        break label845;
      }
      localObject1 = URLDrawable.getDrawable((File)localObject3, localURLDrawableOptions);
    }
    for (;;)
    {
      label406:
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      label415:
      localObject3 = parambilc.jdField_a_of_type_JavaLangString;
      localObject1 = localObject3;
      if (localObject3 != null)
      {
        localObject1 = localObject3;
        if (((String)localObject3).length() > 4) {
          localObject1 = ((String)localObject3).substring(0, 3) + "...";
        }
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      super.setContentDescription(parambilc.jdField_b_of_type_JavaLangString);
      if (parambilc.jdField_a_of_type_Int == this.jdField_b_of_type_Int) {}
      for (;;)
      {
        for (;;)
        {
          this.jdField_c_of_type_Int = (i + 1);
          a(i);
          return;
          localObject3 = super.getResources();
          try
          {
            localObject1 = parambilc.jdField_a_of_type_Bild.jdField_a_of_type_JavaLangString;
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
              localURLDrawableOptions.mFailedDrawable = ((Resources)localObject3).getDrawable(2130847482);
              localURLDrawableOptions.mLoadingDrawable = ((Resources)localObject3).getDrawable(2130847482);
              File localFile = new File(bile.jdField_a_of_type_JavaLangString + ((String)localObject1).substring(((String)localObject1).lastIndexOf("/") + 1));
              if ((localFile.exists()) && (localFile.isFile())) {
                localObject1 = URLDrawable.getDrawable(localFile, localURLDrawableOptions);
              }
            }
            for (;;)
            {
              if ((localObject1 instanceof URLDrawable))
              {
                localObject3 = (URLDrawable)localObject1;
                if (((URLDrawable)localObject3).getStatus() == 2) {
                  ((URLDrawable)localObject3).restartDownload();
                }
              }
              if (parambilc.jdField_b_of_type_Int != 1) {
                break label781;
              }
              ((Drawable)localObject1).setAlpha(127);
              parambilc.jdField_a_of_type_Bild.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)localObject1);
              this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject1);
              break;
              localObject1 = URLDrawable.getDrawable((String)localObject1, localURLDrawableOptions);
              continue;
              QLog.d("ChangeVoiceView", 2, "init drawable url = null, name=" + parambilc.jdField_a_of_type_JavaLangString + ",type=" + parambilc.jdField_a_of_type_Int);
              localObject1 = ((Resources)localObject3).getDrawable(2130847482);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localObject2 = ((Resources)localObject3).getDrawable(2130847482);
              continue;
              label781:
              ((Drawable)localObject2).setAlpha(255);
            }
          }
        }
        label792:
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847373);
        break label295;
        label805:
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break label295;
        label817:
        if (parambilc.d == 5)
        {
          localObject2 = bile.jdField_a_of_type_ArrayOfJavaLangString[1];
          break label326;
        }
        localObject2 = bile.jdField_a_of_type_ArrayOfJavaLangString[2];
        break label326;
        label845:
        localObject2 = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
        break label406;
        label857:
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break label415;
        i = 0;
      }
      label874:
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.ChangeVoiceView
 * JD-Core Version:    0.7.0.1
 */