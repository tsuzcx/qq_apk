package com.tencent.biz.qqstory.storyHome;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import anzj;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
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
import wjj;

public abstract class QQStoryBaseFragment
  extends IphoneTitleBarFragment
  implements IEventReceiver
{
  protected Dialog a;
  protected Handler a;
  protected QQStoryBaseFragment.ProgressView a;
  public AppInterface a;
  protected Map<Subscriber, String> a;
  protected final boolean b = false;
  protected boolean c;
  
  public QQStoryBaseFragment()
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
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
    if (AppSetting.c) {
      this.rightViewText.setContentDescription(this.rightViewText.getText() + anzj.a(2131709679));
    }
  }
  
  protected void a(@NonNull Map<Subscriber, String> paramMap) {}
  
  public boolean a()
  {
    return (getActivity() != null) && (getActivity().isFinishing());
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QQStoryContext.a();
    Object localObject1 = new HashMap();
    a((Map)localObject1);
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilMap.putAll((Map)localObject1);
    localObject1 = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      Subscriber localSubscriber = (Subscriber)((Map.Entry)localObject2).getKey();
      localObject2 = (String)((Map.Entry)localObject2).getValue();
      wjj.a().registerSubscriber((String)localObject2, localSubscriber);
    }
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.c = true;
    QQStoryContext.a();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = QQStoryContext.a();
    Bosses.get().postLightWeightJob(new QQStoryBaseFragment.1(this), 10);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.post(new QQStoryBaseFragment.3(this));
    }
  }
  
  public boolean isValidate()
  {
    return (this.c) && (!a());
  }
  
  public void onDestroyView()
  {
    e();
    this.c = false;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Subscriber localSubscriber = (Subscriber)((Map.Entry)localIterator.next()).getKey();
      wjj.a().unRegisterSubscriber(localSubscriber);
    }
    super.onDestroyView();
  }
  
  public void onStop()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(null);
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryBaseFragment
 * JD-Core Version:    0.7.0.1
 */