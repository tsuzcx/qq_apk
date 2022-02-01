package com.tencent.biz.qqstory.storyHome;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.Subscriber;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class QQStoryBaseFragment
  extends IphoneTitleBarFragment
  implements IEventReceiver
{
  protected final boolean j = false;
  protected boolean k = false;
  protected Map<Subscriber, String> l = new HashMap();
  protected Handler m = new Handler(Looper.getMainLooper());
  protected Dialog n;
  protected QQStoryBaseFragment.ProgressView o;
  public AppInterface p;
  
  public <T extends View> T a(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  public void a(String paramString, View.OnClickListener paramOnClickListener)
  {
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(paramString);
    this.rightViewText.setEnabled(true);
    if (paramOnClickListener != null) {
      this.rightViewText.setOnClickListener(paramOnClickListener);
    }
    if (AppSetting.e)
    {
      paramString = this.rightViewText;
      paramOnClickListener = new StringBuilder();
      paramOnClickListener.append(this.rightViewText.getText());
      paramOnClickListener.append(HardCodeUtil.a(2131908431));
      paramString.setContentDescription(paramOnClickListener.toString());
    }
  }
  
  protected void a(@NonNull Map<Subscriber, String> paramMap) {}
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QQStoryContext.a();
    Object localObject1 = new HashMap();
    a((Map)localObject1);
    this.l.clear();
    this.l.putAll((Map)localObject1);
    localObject1 = this.l.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      Subscriber localSubscriber = (Subscriber)((Map.Entry)localObject2).getKey();
      localObject2 = (String)((Map.Entry)localObject2).getValue();
      StoryDispatcher.a().registerSubscriber((String)localObject2, localSubscriber);
    }
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.k = true;
    QQStoryContext.a();
    this.p = QQStoryContext.k();
    Bosses.get().postLightWeightJob(new QQStoryBaseFragment.1(this), 10);
  }
  
  public void e()
  {
    if (this.n != null)
    {
      this.m.removeCallbacksAndMessages(null);
      this.m.post(new QQStoryBaseFragment.3(this));
    }
  }
  
  public boolean f()
  {
    return (getBaseActivity() != null) && (getBaseActivity().isFinishing());
  }
  
  public boolean isValidate()
  {
    return (this.k) && (!f());
  }
  
  public void onDestroyView()
  {
    e();
    this.k = false;
    Iterator localIterator = this.l.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Subscriber localSubscriber = (Subscriber)((Map.Entry)localIterator.next()).getKey();
      StoryDispatcher.a().unRegisterSubscriber(localSubscriber);
    }
    super.onDestroyView();
  }
  
  public void onStop()
  {
    this.m.removeCallbacks(null);
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryBaseFragment
 * JD-Core Version:    0.7.0.1
 */