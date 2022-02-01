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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.voicechange.IVoiceChangeManager;
import com.tencent.mobileqq.voicechange.VoiceChangeData;
import com.tencent.mobileqq.voicechange.VoiceChangeData.IconData;
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
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131701724);
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
    CircleProgressView localCircleProgressView = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView;
    if (localCircleProgressView != null)
    {
      localCircleProgressView.setRingWidth(10);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setRingColor(getResources().getColor(2131167044));
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
    }
    else if (paramInt == 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getContext().getString(2131691130));
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeData.jdField_b_of_type_JavaLangString);
      setContentDescription(((StringBuilder)localObject).toString());
    }
    else
    {
      setContentDescription(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeData.jdField_b_of_type_JavaLangString);
    }
    if (this.jdField_c_of_type_Int == paramInt) {
      return;
    }
    this.jdField_c_of_type_Int = paramInt;
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130838344);
      if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeData.jdField_b_of_type_Int == 1) {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(2137417318);
      } else {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getContext().getResources().getColor(2131165246));
      }
    }
    else if (paramInt == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.setVisibility(8);
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130848027);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      }
      else
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130838345);
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
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130848027);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      }
      else
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130838345);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      }
    }
    Object localObject = this.jdField_b_of_type_AndroidWidgetTextView;
    paramInt = this.d;
    ((TextView)localObject).setPadding(paramInt, 0, paramInt, 0);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(paramInt1);
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    } else if (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long < 75L) {
      return;
    }
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    paramInt2 /= 1000;
    paramInt1 = paramInt2 / 60;
    paramInt2 %= 60;
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(":");
    if (paramInt2 < 10) {
      localStringBuilder.append("0");
    }
    localStringBuilder.append(paramInt2);
    if (!localStringBuilder.equals(this.jdField_a_of_type_AndroidWidgetTextView.getText())) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localStringBuilder);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.a(paramInt3);
  }
  
  public void a(VoiceChangeData paramVoiceChangeData)
  {
    int i = 0;
    boolean bool;
    if (paramVoiceChangeData != null) {
      bool = true;
    } else {
      bool = false;
    }
    super.setEnabled(bool);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131366953));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131366954));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131364450));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131364452));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView = ((CircleProgressView)super.findViewById(2131364451));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setPresenter(((IAudioPanelPresenterCreater)QRoute.api(IAudioPanelPresenterCreater.class)).createCircleProcessViewPresenter(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131364455));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView = ((VolumeIndicateSquareView)super.findViewById(2131364456));
    Object localObject2 = null;
    if (paramVoiceChangeData == null)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(null);
      super.setContentDescription(null);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130838344);
      return;
    }
    this.d = DisplayUtil.a(getContext(), 4.0F);
    this.jdField_a_of_type_Int = paramVoiceChangeData.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setStrokeWidth(4);
    this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeData = paramVoiceChangeData;
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    Object localObject3;
    if (paramVoiceChangeData.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeData$IconData.jdField_a_of_type_Int > 0) {
      this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(paramVoiceChangeData.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeData$IconData.jdField_a_of_type_Int);
    } else {
      localObject3 = super.getResources();
    }
    try
    {
      localObject1 = paramVoiceChangeData.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeData$IconData.jdField_a_of_type_JavaLangString;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mFailedDrawable = ((Resources)localObject3).getDrawable(2130847706);
        localURLDrawableOptions.mLoadingDrawable = ((Resources)localObject3).getDrawable(2130847706);
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(((IVoiceChangeManager)QRoute.api(IVoiceChangeManager.class)).getVoiceChangeRootDir());
        ((StringBuilder)localObject4).append(((String)localObject1).substring(((String)localObject1).lastIndexOf("/") + 1));
        localObject4 = new File(((StringBuilder)localObject4).toString());
        if ((((File)localObject4).exists()) && (((File)localObject4).isFile())) {
          localObject1 = URLDrawable.getDrawable((File)localObject4, localURLDrawableOptions);
        } else {
          localObject1 = URLDrawable.getDrawable((String)localObject1, localURLDrawableOptions);
        }
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("init drawable url = null, name=");
        ((StringBuilder)localObject1).append(paramVoiceChangeData.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject1).append(",type=");
        ((StringBuilder)localObject1).append(paramVoiceChangeData.jdField_a_of_type_Int);
        QLog.d("ChangeVoiceView", 2, ((StringBuilder)localObject1).toString());
        localObject1 = ((Resources)localObject3).getDrawable(2130847706);
      }
    }
    catch (Exception localException)
    {
      Object localObject1;
      label520:
      break label520;
    }
    localObject1 = ((Resources)localObject3).getDrawable(2130847706);
    if ((localObject1 instanceof URLDrawable))
    {
      localObject3 = (URLDrawable)localObject1;
      if (((URLDrawable)localObject3).getStatus() == 2) {
        ((URLDrawable)localObject3).restartDownload();
      }
    }
    if (paramVoiceChangeData.jdField_b_of_type_Int == 1) {
      ((Drawable)localObject1).setAlpha(127);
    } else {
      ((Drawable)localObject1).setAlpha(255);
    }
    paramVoiceChangeData.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeData$IconData.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)localObject1);
    this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject1);
    if (paramVoiceChangeData.jdField_c_of_type_Int != 0)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramVoiceChangeData.jdField_c_of_type_Int == 1) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847596);
      } else {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847595);
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (paramVoiceChangeData.d != 1)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramVoiceChangeData.d == 4) {
        localObject1 = ((IVoiceChangeManager)QRoute.api(IVoiceChangeManager.class)).getTagIconURL(0);
      } else if (paramVoiceChangeData.d == 5) {
        localObject1 = ((IVoiceChangeManager)QRoute.api(IVoiceChangeManager.class)).getTagIconURL(1);
      } else {
        localObject1 = ((IVoiceChangeManager)QRoute.api(IVoiceChangeManager.class)).getTagIconURL(2);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(((IVoiceChangeManager)QRoute.api(IVoiceChangeManager.class)).getVoiceChangeRootDir());
        ((StringBuilder)localObject2).append(((String)localObject1).substring(((String)localObject1).lastIndexOf("/") + 1));
        localObject2 = new File(((StringBuilder)localObject2).toString());
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        if ((((File)localObject2).exists()) && (((File)localObject2).isFile())) {
          localObject2 = URLDrawable.getDrawable((File)localObject2, (URLDrawable.URLDrawableOptions)localObject3);
        } else {
          localObject2 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject3);
        }
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    localObject2 = paramVoiceChangeData.jdField_a_of_type_JavaLangString;
    localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() > 4)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(((String)localObject2).substring(0, 3));
        ((StringBuilder)localObject1).append("...");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
    super.setContentDescription(paramVoiceChangeData.jdField_b_of_type_JavaLangString);
    if (paramVoiceChangeData.jdField_a_of_type_Int == this.jdField_b_of_type_Int) {
      i = 1;
    }
    this.jdField_c_of_type_Int = (i + 1);
    a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.ChangeVoiceView
 * JD-Core Version:    0.7.0.1
 */