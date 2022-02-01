package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tribe.async.dispatch.Dispatcher;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class SelectVideoPlayerStrategy
  extends PlayerStrategy
{
  protected ConcurrentHashMap<String, Boolean> a = new ConcurrentHashMap();
  public StoryPlayerContext b;
  public ArrayList<WeakReference<SelectVideoVideoHolder>> c = new ArrayList();
  public final int d;
  
  public SelectVideoPlayerStrategy(StoryPlayerContext paramStoryPlayerContext)
  {
    super(paramStoryPlayerContext);
    this.b = paramStoryPlayerContext;
    paramStoryPlayerContext = this.b.i().mBundle.getStringArrayList("EXTRA_VIDEO_ID_LIST");
    this.d = this.b.i().mBundle.getInt("EXTRA_INT_MAX_SELECT_COUNT", 10);
    if (paramStoryPlayerContext != null)
    {
      paramStoryPlayerContext = paramStoryPlayerContext.iterator();
      while (paramStoryPlayerContext.hasNext())
      {
        String str = (String)paramStoryPlayerContext.next();
        if (!TextUtils.isEmpty(str)) {
          this.a.put(str, Boolean.valueOf(true));
        }
      }
    }
  }
  
  public void a()
  {
    SelectVideoPlayerStrategy.SelectedVideosEvent localSelectedVideosEvent = new SelectVideoPlayerStrategy.SelectedVideosEvent();
    Object localObject = new ArrayList();
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localEntry.getKey();
      if (((Boolean)localEntry.getValue()).booleanValue()) {
        ((ArrayList)localObject).add(str);
      }
    }
    localSelectedVideosEvent.a = true;
    localSelectedVideosEvent.b = ((ArrayList)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPagerItemClick onClick complete: ");
    ((StringBuilder)localObject).append(localSelectedVideosEvent.b.toString());
    SLog.b("SelectVideoPlayerStrategy", ((StringBuilder)localObject).toString());
    StoryDispatcher.a().dispatch(localSelectedVideosEvent);
    this.b.a().finish();
  }
  
  public void a(SelectVideoVideoHolder paramSelectVideoVideoHolder)
  {
    super.a(paramSelectVideoVideoHolder);
    this.c.add(new WeakReference(paramSelectVideoVideoHolder));
  }
  
  @SuppressLint({"SetTextI18n"})
  public void a(SelectVideoVideoHolder paramSelectVideoVideoHolder, int paramInt1, int paramInt2, StoryPlayerVideoData paramStoryPlayerVideoData)
  {
    super.a(paramSelectVideoVideoHolder, paramInt1, paramInt2, paramStoryPlayerVideoData);
    paramStoryPlayerVideoData = paramStoryPlayerVideoData.b;
    if (TextUtils.isEmpty(paramStoryPlayerVideoData)) {
      return;
    }
    ImageView localImageView = (ImageView)paramSelectVideoVideoHolder.b.findViewById(2131435465);
    localImageView.setVisibility(0);
    if ((this.a.containsKey(paramStoryPlayerVideoData)) && (((Boolean)this.a.get(paramStoryPlayerVideoData)).booleanValue())) {
      localImageView.setImageResource(2130846159);
    } else {
      localImageView.setImageResource(2130847333);
    }
    paramStoryPlayerVideoData = (TextView)paramSelectVideoVideoHolder.b.findViewById(2131447249);
    paramStoryPlayerVideoData.setVisibility(0);
    if (this.a.isEmpty())
    {
      paramSelectVideoVideoHolder = HardCodeUtil.a(2131911226);
    }
    else
    {
      paramSelectVideoVideoHolder = new StringBuilder();
      paramSelectVideoVideoHolder.append(HardCodeUtil.a(2131911229));
      paramSelectVideoVideoHolder.append(this.a.size());
      paramSelectVideoVideoHolder.append(")");
      paramSelectVideoVideoHolder = paramSelectVideoVideoHolder.toString();
    }
    paramStoryPlayerVideoData.setText(paramSelectVideoVideoHolder);
    paramStoryPlayerVideoData.setEnabled(this.a.isEmpty() ^ true);
  }
  
  public void a(SelectVideoVideoHolder paramSelectVideoVideoHolder, View paramView)
  {
    super.a(paramSelectVideoVideoHolder, paramView);
    int i = paramView.getId();
    if (i != 2131435465)
    {
      if (i != 2131447249) {
        return;
      }
      a();
      return;
    }
    paramSelectVideoVideoHolder = paramSelectVideoVideoHolder.c.b;
    AssertUtils.checkNotNull(paramSelectVideoVideoHolder);
    if (this.a.containsKey(paramSelectVideoVideoHolder))
    {
      this.a.remove(paramSelectVideoVideoHolder);
      ((ImageView)paramView).setImageResource(2130847333);
    }
    else
    {
      if (this.a.size() >= this.d)
      {
        paramSelectVideoVideoHolder = DialogUtil.a(this.b.a(), 230);
        paramSelectVideoVideoHolder.setMessage(String.format(HardCodeUtil.a(2131911231), new Object[] { Integer.valueOf(this.d), QQStoryConstant.a }));
        paramSelectVideoVideoHolder.setPositiveButton(HardCodeUtil.a(2131911225), new SelectVideoPlayerStrategy.1(this));
        paramSelectVideoVideoHolder.show();
        return;
      }
      this.a.put(paramSelectVideoVideoHolder, Boolean.valueOf(true));
      ((ImageView)paramView).setImageResource(2130846159);
    }
    paramView = this.c.iterator();
    while (paramView.hasNext())
    {
      paramSelectVideoVideoHolder = (SelectVideoVideoHolder)((WeakReference)paramView.next()).get();
      if (paramSelectVideoVideoHolder != null)
      {
        TextView localTextView = (TextView)paramSelectVideoVideoHolder.b.findViewById(2131447249);
        if (this.a.isEmpty())
        {
          paramSelectVideoVideoHolder = HardCodeUtil.a(2131911228);
        }
        else
        {
          paramSelectVideoVideoHolder = new StringBuilder();
          paramSelectVideoVideoHolder.append(HardCodeUtil.a(2131911224));
          paramSelectVideoVideoHolder.append(this.a.size());
          paramSelectVideoVideoHolder.append(")");
          paramSelectVideoVideoHolder = paramSelectVideoVideoHolder.toString();
        }
        localTextView.setText(paramSelectVideoVideoHolder);
        localTextView.setEnabled(this.a.isEmpty() ^ true);
      }
    }
  }
  
  public void a(SelectVideoVideoHolder paramSelectVideoVideoHolder, boolean paramBoolean)
  {
    TextView localTextView = (TextView)paramSelectVideoVideoHolder.b.findViewById(2131447249);
    if (this.a.isEmpty())
    {
      paramSelectVideoVideoHolder = HardCodeUtil.a(2131911227);
    }
    else
    {
      paramSelectVideoVideoHolder = new StringBuilder();
      paramSelectVideoVideoHolder.append(HardCodeUtil.a(2131911230));
      paramSelectVideoVideoHolder.append(this.a.size());
      paramSelectVideoVideoHolder.append(")");
      paramSelectVideoVideoHolder = paramSelectVideoVideoHolder.toString();
    }
    localTextView.setText(paramSelectVideoVideoHolder);
    localTextView.setEnabled(this.a.isEmpty() ^ true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.SelectVideoPlayerStrategy
 * JD-Core Version:    0.7.0.1
 */