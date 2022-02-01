package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.playvideo.VideoCoverListBar;
import com.tencent.biz.qqstory.playvideo.dataprovider.HoriziotalVideoCoverListDataProvider;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.UIStyle;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.List;

public class VideoCoverListGroupHolder
  extends GroupHolderBase
  implements IEventReceiver
{
  private long jdField_a_of_type_Long = 0L;
  private VideoCoverListBar jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar;
  private HoriziotalVideoCoverListDataProvider jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderHoriziotalVideoCoverListDataProvider;
  private VideoCoverListGroupHolder.GetVideoBasicListReceiver jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoCoverListGroupHolder$GetVideoBasicListReceiver;
  private volatile boolean c = false;
  private boolean d = false;
  private boolean e = false;
  
  public VideoCoverListGroupHolder(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar = ((VideoCoverListBar)paramViewGroup.findViewById(2131381316));
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar;
  }
  
  public void a(int paramInt, IDataProvider.GroupInfo paramGroupInfo, @NonNull ArrayList<StoryPlayerVideoData> paramArrayList)
  {
    SLog.a("VideoCoverListGroupHolder", "onBind() pos=%d, group=%s", Integer.valueOf(paramInt), paramGroupInfo);
    boolean bool = this.b;
    super.a(paramInt, paramGroupInfo, paramArrayList);
    if (!bool)
    {
      this.e = true;
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoCoverListGroupHolder$GetVideoBasicListReceiver == null) {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoCoverListGroupHolder$GetVideoBasicListReceiver = new VideoCoverListGroupHolder.GetVideoBasicListReceiver(this);
      }
      StoryDispatcher.a().registerSubscriber("", this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoCoverListGroupHolder$GetVideoBasicListReceiver);
    }
    if ((paramGroupInfo.c()) || (paramGroupInfo.b())) {}
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderHoriziotalVideoCoverListDataProvider.a().size();
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderHoriziotalVideoCoverListDataProvider.a(paramInt, paramArrayList, paramGroupInfo.a);
    } while (i == this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderHoriziotalVideoCoverListDataProvider.a().size());
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.a();
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.a(paramString);
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderHoriziotalVideoCoverListDataProvider = new HoriziotalVideoCoverListDataProvider(a().mUIStyle.showVideoCoverList);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderHoriziotalVideoCoverListDataProvider);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.setOnVideoClickListener(new VideoCoverListGroupHolder.1(this));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.setOnScrollListener(new VideoCoverListGroupHolder.2(this));
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoCoverListGroupHolder$GetVideoBasicListReceiver != null)
    {
      this.e = false;
      StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoCoverListGroupHolder$GetVideoBasicListReceiver);
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.b();
  }
  
  public boolean isValidate()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoCoverListGroupHolder
 * JD-Core Version:    0.7.0.1
 */