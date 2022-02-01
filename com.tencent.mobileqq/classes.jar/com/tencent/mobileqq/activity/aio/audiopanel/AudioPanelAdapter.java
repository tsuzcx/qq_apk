package com.tencent.mobileqq.activity.aio.audiopanel;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.receipt.ReceiptHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class AudioPanelAdapter
  extends PagerAdapter
{
  public AudioPanel a;
  public ViewGroup b;
  public ViewGroup c;
  private QQAppInterface d;
  private BaseChatPie e;
  private ViewGroup f;
  private ViewGroup g;
  private ViewGroup h;
  private boolean i;
  
  public AudioPanelAdapter(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, AudioPanel paramAudioPanel, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, ViewGroup paramViewGroup3)
  {
    this.d = paramQQAppInterface;
    this.e = paramBaseChatPie;
    this.a = paramAudioPanel;
    this.f = paramViewGroup1;
    this.g = paramViewGroup2;
    this.h = paramViewGroup3;
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
    notifyDataSetChanged();
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    paramObject = (View)paramObject;
    ((ViewGroup)paramView).removeView(paramObject);
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("AudioPanelAdapter.destroyItem() is called,position is:");
      paramView.append(paramInt);
      QLog.d("AIOAudioPanel", 2, paramView.toString());
    }
  }
  
  public int getCount()
  {
    if (this.i) {
      return 1;
    }
    return 3;
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("AudioPanelAdapter.instantiateItem() is called,position is:");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2;
    Object localObject3;
    if ((!((ReceiptHelper)this.e.q(118)).a) && (paramInt != 1))
    {
      if (paramInt == 0)
      {
        localObject1 = new FrameLayout(this.d.getApp());
        ((FrameLayout)localObject1).setId(1000);
        localObject2 = (PressToChangeVoicePanel)LayoutInflater.from(this.d.getApp()).inflate(2131627267, null);
        ((PressToChangeVoicePanel)localObject2).a(this.d, this.e, (ViewGroup)localObject1, this.a, this.f, this.g, this.h, this);
        ((FrameLayout)localObject1).addView((View)localObject2, new FrameLayout.LayoutParams(-1, -1));
        if ((!Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) || (!Build.MODEL.toUpperCase().startsWith("HM NOTE"))) {
          ThreadManager.getSubThreadHandler().postDelayed(new AudioPanelAdapter.1(this), 100L);
        }
        ((PressToChangeVoicePanel)localObject2).g();
        ((PressToChangeVoicePanel)localObject2).setVisibility(0);
        localObject2 = (ViewGroup)((FrameLayout)localObject1).getParent();
        if (localObject2 == null)
        {
          ((ViewGroup)paramView).addView((View)localObject1);
        }
        else if (localObject2 != paramView)
        {
          ((ViewGroup)localObject2).removeView((View)localObject1);
          ((ViewGroup)paramView).addView((View)localObject1);
        }
        return localObject1;
      }
      if (paramInt == 2)
      {
        localObject2 = new FrameLayout(this.d.getApp());
        ((FrameLayout)localObject2).setId(1002);
        localObject1 = (RecordSoundPanel)LayoutInflater.from(this.d.getApp()).inflate(2131627271, null);
        ((RecordSoundPanel)localObject1).a(this.d, this.e, (ViewGroup)localObject2, this.a, this.f, this.g, this.h);
        localObject3 = (ListenPanel)LayoutInflater.from(this.d.getApp()).inflate(2131627265, null);
        ((ListenPanel)localObject3).a(this.d, this.e, (ViewGroup)localObject2, this.a, this.f, 2);
        ((ListenPanel)localObject3).setNeedAudioData(true);
        ((FrameLayout)localObject2).addView((View)localObject1, new FrameLayout.LayoutParams(-1, -1));
        ((FrameLayout)localObject2).addView((View)localObject3, new FrameLayout.LayoutParams(-1, -1));
        ((RecordSoundPanel)localObject1).a();
        ((RecordSoundPanel)localObject1).setVisibility(0);
        ((ListenPanel)localObject3).setVisibility(8);
        localObject3 = (ViewGroup)((FrameLayout)localObject2).getParent();
        if (localObject3 == null)
        {
          ((ViewGroup)paramView).addView((View)localObject2);
          return localObject2;
        }
        localObject1 = localObject2;
        if (localObject3 != paramView)
        {
          ((ViewGroup)localObject3).removeView((View)localObject2);
          ((ViewGroup)paramView).addView((View)localObject2);
          return localObject2;
        }
      }
      else
      {
        return null;
      }
    }
    else
    {
      localObject2 = new FrameLayout(this.d.getApp());
      ((FrameLayout)localObject2).setId(1001);
      localObject1 = (PressToSpeakPanel)LayoutInflater.from(this.d.getApp()).inflate(2131627268, null);
      ((PressToSpeakPanel)localObject1).a(this.d, this.e, (ViewGroup)localObject2, this.a, this.f, this.g, this.h);
      localObject3 = (ListenPanel)LayoutInflater.from(this.d.getApp()).inflate(2131627265, null);
      ((ListenPanel)localObject3).a(this.d, this.e, (ViewGroup)localObject2, this.a, this.f, 1);
      ((ListenPanel)localObject3).setNeedAudioData(true);
      ((FrameLayout)localObject2).addView((View)localObject1, new FrameLayout.LayoutParams(-1, -1));
      ((FrameLayout)localObject2).addView((View)localObject3, new FrameLayout.LayoutParams(-1, -1));
      ((PressToSpeakPanel)localObject1).a();
      ((PressToSpeakPanel)localObject1).setVisibility(0);
      ((ListenPanel)localObject3).setVisibility(8);
      localObject3 = (ViewGroup)((FrameLayout)localObject2).getParent();
      if (localObject3 == null)
      {
        ((ViewGroup)paramView).addView((View)localObject2);
        return localObject2;
      }
      localObject1 = localObject2;
      if (localObject3 != paramView)
      {
        ((ViewGroup)localObject3).removeView((View)localObject2);
        ((ViewGroup)paramView).addView((View)localObject2);
        localObject1 = localObject2;
      }
    }
    return localObject1;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void setPrimaryItem(View paramView, int paramInt, Object paramObject)
  {
    super.setPrimaryItem(paramView, paramInt, paramObject);
    if ((paramObject instanceof ViewGroup)) {
      this.b = ((ViewGroup)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelAdapter
 * JD-Core Version:    0.7.0.1
 */