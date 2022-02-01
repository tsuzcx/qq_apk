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
  public final int a;
  public StoryPlayerContext a;
  public ArrayList<WeakReference<SelectVideoVideoHolder>> a;
  protected ConcurrentHashMap<String, Boolean> a;
  
  public SelectVideoPlayerStrategy(StoryPlayerContext paramStoryPlayerContext)
  {
    super(paramStoryPlayerContext);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerContext = paramStoryPlayerContext;
    paramStoryPlayerContext = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerContext.a().mBundle.getStringArrayList("EXTRA_VIDEO_ID_LIST");
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerContext.a().mBundle.getInt("EXTRA_INT_MAX_SELECT_COUNT", 10);
    if (paramStoryPlayerContext != null)
    {
      paramStoryPlayerContext = paramStoryPlayerContext.iterator();
      while (paramStoryPlayerContext.hasNext())
      {
        String str = (String)paramStoryPlayerContext.next();
        if (!TextUtils.isEmpty(str)) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, Boolean.valueOf(true));
        }
      }
    }
  }
  
  public void a()
  {
    SelectVideoPlayerStrategy.SelectedVideosEvent localSelectedVideosEvent = new SelectVideoPlayerStrategy.SelectedVideosEvent();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localEntry.getKey();
      if (((Boolean)localEntry.getValue()).booleanValue()) {
        localArrayList.add(str);
      }
    }
    localSelectedVideosEvent.jdField_a_of_type_Boolean = true;
    localSelectedVideosEvent.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    SLog.b("SelectVideoPlayerStrategy", "onPagerItemClick onClick complete: " + localSelectedVideosEvent.jdField_a_of_type_JavaUtilArrayList.toString());
    StoryDispatcher.a().dispatch(localSelectedVideosEvent);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerContext.a().finish();
  }
  
  public void a(SelectVideoVideoHolder paramSelectVideoVideoHolder)
  {
    super.a(paramSelectVideoVideoHolder);
    this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramSelectVideoVideoHolder));
  }
  
  @SuppressLint({"SetTextI18n"})
  public void a(SelectVideoVideoHolder paramSelectVideoVideoHolder, int paramInt1, int paramInt2, StoryPlayerVideoData paramStoryPlayerVideoData)
  {
    super.a(paramSelectVideoVideoHolder, paramInt1, paramInt2, paramStoryPlayerVideoData);
    paramStoryPlayerVideoData = paramStoryPlayerVideoData.a;
    if (TextUtils.isEmpty(paramStoryPlayerVideoData)) {
      return;
    }
    ImageView localImageView = (ImageView)paramSelectVideoVideoHolder.jdField_a_of_type_AndroidViewView.findViewById(2131368831);
    localImageView.setVisibility(0);
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramStoryPlayerVideoData)) && (((Boolean)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramStoryPlayerVideoData)).booleanValue()))
    {
      localImageView.setImageResource(2130844851);
      paramStoryPlayerVideoData = (TextView)paramSelectVideoVideoHolder.jdField_a_of_type_AndroidViewView.findViewById(2131379257);
      paramStoryPlayerVideoData.setVisibility(0);
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
        break label155;
      }
      paramSelectVideoVideoHolder = HardCodeUtil.a(2131713723);
      label118:
      paramStoryPlayerVideoData.setText(paramSelectVideoVideoHolder);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
        break label192;
      }
    }
    label155:
    label192:
    for (boolean bool = true;; bool = false)
    {
      paramStoryPlayerVideoData.setEnabled(bool);
      return;
      localImageView.setImageResource(2130845988);
      break;
      paramSelectVideoVideoHolder = HardCodeUtil.a(2131713726) + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() + ")";
      break label118;
    }
  }
  
  public void a(SelectVideoVideoHolder paramSelectVideoVideoHolder, View paramView)
  {
    super.a(paramSelectVideoVideoHolder, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368831: 
      paramSelectVideoVideoHolder = paramSelectVideoVideoHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.a;
      AssertUtils.a(paramSelectVideoVideoHolder);
      label87:
      TextView localTextView;
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramSelectVideoVideoHolder))
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramSelectVideoVideoHolder);
        ((ImageView)paramView).setImageResource(2130845988);
        paramView = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        do
        {
          if (!paramView.hasNext()) {
            break;
          }
          paramSelectVideoVideoHolder = (SelectVideoVideoHolder)((WeakReference)paramView.next()).get();
        } while (paramSelectVideoVideoHolder == null);
        localTextView = (TextView)paramSelectVideoVideoHolder.jdField_a_of_type_AndroidViewView.findViewById(2131379257);
        if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
          break label285;
        }
        paramSelectVideoVideoHolder = HardCodeUtil.a(2131713725);
        label147:
        localTextView.setText(paramSelectVideoVideoHolder);
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
          break label323;
        }
      }
      label285:
      label323:
      for (boolean bool = true;; bool = false)
      {
        localTextView.setEnabled(bool);
        break label87;
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() >= this.jdField_a_of_type_Int)
        {
          paramSelectVideoVideoHolder = DialogUtil.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerContext.a(), 230);
          paramSelectVideoVideoHolder.setMessage(String.format(HardCodeUtil.a(2131713728), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), QQStoryConstant.a }));
          paramSelectVideoVideoHolder.setPositiveButton(HardCodeUtil.a(2131713722), new SelectVideoPlayerStrategy.1(this));
          paramSelectVideoVideoHolder.show();
          return;
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramSelectVideoVideoHolder, Boolean.valueOf(true));
        ((ImageView)paramView).setImageResource(2130844851);
        break;
        paramSelectVideoVideoHolder = HardCodeUtil.a(2131713721) + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() + ")";
        break label147;
      }
    }
    a();
  }
  
  public void a(SelectVideoVideoHolder paramSelectVideoVideoHolder, boolean paramBoolean)
  {
    TextView localTextView = (TextView)paramSelectVideoVideoHolder.jdField_a_of_type_AndroidViewView.findViewById(2131379257);
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
    {
      paramSelectVideoVideoHolder = HardCodeUtil.a(2131713724);
      localTextView.setText(paramSelectVideoVideoHolder);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
        break label91;
      }
    }
    label91:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localTextView.setEnabled(paramBoolean);
      return;
      paramSelectVideoVideoHolder = HardCodeUtil.a(2131713727) + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() + ")";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.SelectVideoPlayerStrategy
 * JD-Core Version:    0.7.0.1
 */