package com.tencent.biz.qqstory.playvideo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupId;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.StartInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.ActivityLifeCycle;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.PlayerStrategy;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerContext;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGlobalHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerObjectRecycler;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoHolderBase;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

class StoryPlayerImpl$StoryPlayerContextImpl
  extends StoryPlayerContext
  implements ActivityLifeCycle
{
  QQStoryObserver jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver = new StoryPlayerImpl.StoryPlayerContextImpl.1(this);
  private final StoryPlayerImpl.Ui jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$Ui;
  private final IDataProvider.StartInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo;
  private final OpenPlayerBuilder.Data jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data;
  private final PlayerStrategy jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetPlayerStrategy;
  StoryPlayerObjectRecycler jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerObjectRecycler = new StoryPlayerObjectRecycler();
  private final XViewPager jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final Set<QQStoryObserver> jdField_a_of_type_JavaUtilSet = new HashSet();
  private final CopyOnWriteArraySet<ActivityLifeCycle> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
  private final boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private StoryPlayerImpl$StoryPlayerContextImpl(StoryPlayerImpl paramStoryPlayerImpl, StoryPlayerImpl.Ui paramUi, XViewPager paramXViewPager, OpenPlayerBuilder.Data paramData, IDataProvider.StartInfo paramStartInfo)
  {
    paramStoryPlayerImpl = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramStoryPlayerImpl instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramStoryPlayerImpl);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$Ui = paramUi;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager = paramXViewPager;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data = paramData;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo = new IDataProvider.StartInfo(paramStartInfo);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetPlayerStrategy = PlayerStrategy.a(this);
      this.jdField_a_of_type_Boolean = TVK_SDKMgr.isInstalled(paramUi.a());
      SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "isUseTVKVideoView %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      return;
    }
    throw new IllegalStateException("AppRuntime is not instance of QQAppInterface");
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$Ui.getActivity();
  }
  
  public IDataProvider.GroupId a()
  {
    return StoryPlayerImpl.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl).a();
  }
  
  public IDataProvider.StartInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo;
  }
  
  public OpenPlayerBuilder.Data a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data;
  }
  
  public PlayerStrategy a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetPlayerStrategy;
  }
  
  public StoryPlayerObjectRecycler a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerObjectRecycler;
  }
  
  public XViewPager a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager;
  }
  
  public String a(String paramString)
  {
    return StoryPlayerImpl.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl).a(paramString);
  }
  
  public void a()
  {
    StoryPlayerImpl.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl).removeCallbacks(StoryPlayerImpl.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl));
    StoryPlayerImpl.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl).postDelayed(StoryPlayerImpl.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl), 500L);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = new HashSet(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet).iterator();
    while (localIterator.hasNext()) {
      ((ActivityLifeCycle)localIterator.next()).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$Ui.startActivity(paramIntent);
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver, false);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((ActivityLifeCycle)localIterator.next()).a(paramBundle1, paramBundle2);
    }
  }
  
  public void a(QQStoryObserver paramQQStoryObserver)
  {
    this.jdField_a_of_type_JavaUtilSet.add(paramQQStoryObserver);
  }
  
  public void a(ActivityLifeCycle paramActivityLifeCycle)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramActivityLifeCycle);
  }
  
  public void a(VideoHolderBase paramVideoHolderBase)
  {
    if (StoryPlayerImpl.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl).a(paramVideoHolderBase)) {
      StoryPlayerImpl.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl, paramVideoHolderBase);
    }
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public void b(QQStoryObserver paramQQStoryObserver)
  {
    this.jdField_a_of_type_JavaUtilSet.remove(paramQQStoryObserver);
  }
  
  public void b(ActivityLifeCycle paramActivityLifeCycle)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(paramActivityLifeCycle);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((ActivityLifeCycle)localIterator.next()).c();
    }
  }
  
  public void d()
  {
    this.b = true;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((ActivityLifeCycle)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    this.b = false;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((ActivityLifeCycle)localIterator.next()).e();
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((ActivityLifeCycle)localIterator.next()).f();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((ActivityLifeCycle)localIterator.next()).g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.StoryPlayerImpl.StoryPlayerContextImpl
 * JD-Core Version:    0.7.0.1
 */