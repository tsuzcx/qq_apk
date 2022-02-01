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
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.voicechange.VoiceChangeData;
import com.tencent.mobileqq.voicechange.VoiceChangeData.IconData;
import com.tencent.mobileqq.voicechange.VoiceChangeManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ChangeVoiceView
  extends RelativeLayout
{
  public static String a;
  public int a;
  private long jdField_a_of_type_Long = 0L;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CircleProgressView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView;
  private VolumeIndicateSquareView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView;
  public VoiceChangeData a;
  private boolean jdField_a_of_type_Boolean = false;
  public int b;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public int c;
  private ImageView c;
  private int d = 0;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131701584);
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
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setRingColor(getResources().getColor(2131167021));
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeData == null) {
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
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130838496);
      if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeData.jdField_b_of_type_Int != 1) {
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
        setContentDescription(getContext().getString(2131691209) + " " + this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeData.jdField_b_of_type_JavaLangString);
        break label28;
      }
      setContentDescription(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeData.jdField_b_of_type_JavaLangString);
      break label28;
      label180:
      break;
      label182:
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getContext().getResources().getColor(2131165282));
      continue;
      label204:
      if (paramInt == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.setVisibility(8);
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130848156);
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        }
        else
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130838497);
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
          this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130848156);
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        }
        else
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130838497);
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
  
  public void a(VoiceChangeData paramVoiceChangeData)
  {
    int i = 1;
    if (paramVoiceChangeData != null) {}
    for (boolean bool = true;; bool = false)
    {
      super.setEnabled(bool);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131367116));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131367117));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131364563));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131364565));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView = ((CircleProgressView)super.findViewById(2131364564));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131364568));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView = ((VolumeIndicateSquareView)super.findViewById(2131364569));
      if (paramVoiceChangeData != null) {
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
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130838496);
      return;
    }
    this.d = DisplayUtil.a(getContext(), 4.0F);
    this.jdField_a_of_type_Int = paramVoiceChangeData.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setStrokeWidth(4);
    this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeData = paramVoiceChangeData;
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    label295:
    Object localObject1;
    label326:
    Object localObject3;
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    if (paramVoiceChangeData.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeData$IconData.jdField_a_of_type_Int > 0)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(paramVoiceChangeData.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeData$IconData.jdField_a_of_type_Int);
      if (paramVoiceChangeData.jdField_c_of_type_Int == 0) {
        break label805;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramVoiceChangeData.jdField_c_of_type_Int != 1) {
        break label792;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847727);
      if (paramVoiceChangeData.d == 1) {
        break label857;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramVoiceChangeData.d != 4) {
        break label817;
      }
      localObject1 = VoiceChangeManager.jdField_a_of_type_ArrayOfJavaLangString[0];
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label874;
      }
      localObject3 = new File(VoiceChangeManager.jdField_a_of_type_JavaLangString + ((String)localObject1).substring(((String)localObject1).lastIndexOf("/") + 1));
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
      localObject3 = paramVoiceChangeData.jdField_a_of_type_JavaLangString;
      localObject1 = localObject3;
      if (localObject3 != null)
      {
        localObject1 = localObject3;
        if (((String)localObject3).length() > 4) {
          localObject1 = ((String)localObject3).substring(0, 3) + "...";
        }
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      super.setContentDescription(paramVoiceChangeData.jdField_b_of_type_JavaLangString);
      if (paramVoiceChangeData.jdField_a_of_type_Int == this.jdField_b_of_type_Int) {}
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
            localObject1 = paramVoiceChangeData.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeData$IconData.jdField_a_of_type_JavaLangString;
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
              localURLDrawableOptions.mFailedDrawable = ((Resources)localObject3).getDrawable(2130847839);
              localURLDrawableOptions.mLoadingDrawable = ((Resources)localObject3).getDrawable(2130847839);
              File localFile = new File(VoiceChangeManager.jdField_a_of_type_JavaLangString + ((String)localObject1).substring(((String)localObject1).lastIndexOf("/") + 1));
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
              if (paramVoiceChangeData.jdField_b_of_type_Int != 1) {
                break label781;
              }
              ((Drawable)localObject1).setAlpha(127);
              paramVoiceChangeData.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeData$IconData.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)localObject1);
              this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject1);
              break;
              localObject1 = URLDrawable.getDrawable((String)localObject1, localURLDrawableOptions);
              continue;
              QLog.d("ChangeVoiceView", 2, "init drawable url = null, name=" + paramVoiceChangeData.jdField_a_of_type_JavaLangString + ",type=" + paramVoiceChangeData.jdField_a_of_type_Int);
              localObject1 = ((Resources)localObject3).getDrawable(2130847839);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localObject2 = ((Resources)localObject3).getDrawable(2130847839);
              continue;
              label781:
              ((Drawable)localObject2).setAlpha(255);
            }
          }
        }
        label792:
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847726);
        break label295;
        label805:
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break label295;
        label817:
        if (paramVoiceChangeData.d == 5)
        {
          localObject2 = VoiceChangeManager.jdField_a_of_type_ArrayOfJavaLangString[1];
          break label326;
        }
        localObject2 = VoiceChangeManager.jdField_a_of_type_ArrayOfJavaLangString[2];
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.ChangeVoiceView
 * JD-Core Version:    0.7.0.1
 */