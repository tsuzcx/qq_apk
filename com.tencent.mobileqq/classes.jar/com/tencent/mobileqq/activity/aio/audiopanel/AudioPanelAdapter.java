package com.tencent.mobileqq.activity.aio.audiopanel;

import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class AudioPanelAdapter
  extends PagerAdapter
{
  public ViewGroup a;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  public AudioPanel a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  public ViewGroup b;
  private ViewGroup c;
  private ViewGroup d;
  private ViewGroup e;
  
  public AudioPanelAdapter(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, AudioPanel paramAudioPanel, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, ViewGroup paramViewGroup3)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel = paramAudioPanel;
    this.c = paramViewGroup1;
    this.d = paramViewGroup2;
    this.e = paramViewGroup3;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    notifyDataSetChanged();
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return;
      paramObject = (View)paramObject;
      ((ViewGroup)paramView).removeView(paramObject);
    } while (!QLog.isColorLevel());
    QLog.d("AIOAudioPanel", 2, "AudioPanelAdapter.destroyItem() is called,position is:" + paramInt);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Boolean) {
      return 1;
    }
    return 3;
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "AudioPanelAdapter.instantiateItem() is called,position is:" + paramInt);
    }
    FrameLayout localFrameLayout;
    Object localObject1;
    Object localObject2;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.K) || (paramInt == 1))
    {
      localFrameLayout = new FrameLayout(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
      localFrameLayout.setId(1001);
      localObject1 = (PressToSpeakPanel)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).inflate(2131560615, null);
      ((PressToSpeakPanel)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, localFrameLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel, this.c, this.d, this.e);
      localObject2 = (ListenPanel)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).inflate(2131560612, null);
      ((ListenPanel)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, localFrameLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel, this.c, 1);
      ((ListenPanel)localObject2).setNeedAudioData(true);
      localFrameLayout.addView((View)localObject1, new FrameLayout.LayoutParams(-1, -1));
      localFrameLayout.addView((View)localObject2, new FrameLayout.LayoutParams(-1, -1));
      ((PressToSpeakPanel)localObject1).b();
      ((PressToSpeakPanel)localObject1).setVisibility(0);
      ((ListenPanel)localObject2).setVisibility(8);
      localObject2 = (ViewGroup)localFrameLayout.getParent();
      if (localObject2 == null)
      {
        ((ViewGroup)paramView).addView(localFrameLayout);
        localObject1 = localFrameLayout;
      }
    }
    do
    {
      do
      {
        do
        {
          return localObject1;
          localObject1 = localFrameLayout;
        } while (localObject2 == paramView);
        ((ViewGroup)localObject2).removeView(localFrameLayout);
        ((ViewGroup)paramView).addView(localFrameLayout);
        return localFrameLayout;
        if (paramInt != 0) {
          break;
        }
        localFrameLayout = new FrameLayout(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
        localFrameLayout.setId(1000);
        localObject1 = (PressToChangeVoicePanel)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).inflate(2131560614, null);
        ((PressToChangeVoicePanel)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, localFrameLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel, this.c, this.d, this.e, this);
        localFrameLayout.addView((View)localObject1, new FrameLayout.LayoutParams(-1, -1));
        if ((Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) && (Build.MODEL.toUpperCase().startsWith("HM NOTE"))) {}
        for (;;)
        {
          ((PressToChangeVoicePanel)localObject1).g();
          ((PressToChangeVoicePanel)localObject1).setVisibility(0);
          localObject2 = (ViewGroup)localFrameLayout.getParent();
          if (localObject2 != null) {
            break;
          }
          ((ViewGroup)paramView).addView(localFrameLayout);
          return localFrameLayout;
          ThreadManager.getSubThreadHandler().postDelayed(new AudioPanelAdapter.1(this), 100L);
        }
        localObject1 = localFrameLayout;
      } while (localObject2 == paramView);
      ((ViewGroup)localObject2).removeView(localFrameLayout);
      ((ViewGroup)paramView).addView(localFrameLayout);
      return localFrameLayout;
      if (paramInt != 2) {
        break;
      }
      localFrameLayout = new FrameLayout(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
      localFrameLayout.setId(1002);
      localObject1 = (RecordSoundPanel)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).inflate(2131560618, null);
      ((RecordSoundPanel)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, localFrameLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel, this.c, this.d, this.e);
      localObject2 = (ListenPanel)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).inflate(2131560612, null);
      ((ListenPanel)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, localFrameLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel, this.c, 2);
      ((ListenPanel)localObject2).setNeedAudioData(true);
      localFrameLayout.addView((View)localObject1, new FrameLayout.LayoutParams(-1, -1));
      localFrameLayout.addView((View)localObject2, new FrameLayout.LayoutParams(-1, -1));
      ((RecordSoundPanel)localObject1).b();
      ((RecordSoundPanel)localObject1).setVisibility(0);
      ((ListenPanel)localObject2).setVisibility(8);
      localObject2 = (ViewGroup)localFrameLayout.getParent();
      if (localObject2 == null)
      {
        ((ViewGroup)paramView).addView(localFrameLayout);
        return localFrameLayout;
      }
      localObject1 = localFrameLayout;
    } while (localObject2 == paramView);
    ((ViewGroup)localObject2).removeView(localFrameLayout);
    ((ViewGroup)paramView).addView(localFrameLayout);
    return localFrameLayout;
    return null;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void setPrimaryItem(View paramView, int paramInt, Object paramObject)
  {
    super.setPrimaryItem(paramView, paramInt, paramObject);
    if ((paramObject instanceof ViewGroup)) {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelAdapter
 * JD-Core Version:    0.7.0.1
 */