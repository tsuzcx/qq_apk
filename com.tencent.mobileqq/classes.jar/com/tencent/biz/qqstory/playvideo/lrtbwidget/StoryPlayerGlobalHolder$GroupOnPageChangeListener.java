package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.text.TextUtils;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeClickRequest;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupInfo;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayPageLoader.MsgTabGroupId;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class StoryPlayerGlobalHolder$GroupOnPageChangeListener
  implements XViewPager.OnPageChangeListener
{
  int jdField_a_of_type_Int = 0;
  private String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  int b = -1;
  
  private StoryPlayerGlobalHolder$GroupOnPageChangeListener(StoryPlayerGlobalHolder paramStoryPlayerGlobalHolder) {}
  
  public void a(int paramInt)
  {
    StoryPlayerGlobalHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder);
    Object localObject1 = StoryPlayerGlobalHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder).a();
    if ((localObject1 != null) && (paramInt < ((List)localObject1).size())) {
      StoryPlayerGlobalHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder, ((IDataProvider.GroupInfo)((List)localObject1).get(paramInt)).a);
    }
    localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder.a(paramInt);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((StoryPlayerGroupHolder)localObject1).a();
      SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, Group=%s, Video=%s", localObject1, localObject2);
      if (localObject2 != null)
      {
        boolean bool1;
        if (((StoryPlayerGroupHolder)localObject1).b == ((StoryPlayerGroupHolder)localObject1).a.size() - 1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        boolean bool2;
        if (((StoryPlayerGroupHolder)localObject1).b == 0) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        boolean bool3 = bool1;
        if (bool1)
        {
          bool3 = bool1;
          if (((StoryPlayerGroupHolder)localObject1).d()) {
            bool3 = false;
          }
        }
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder.a.setEnableScrollDirection(bool3, bool2, true, true);
        if (StoryPlayerGlobalHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder) != null) {
          StoryPlayerGlobalHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder).a(paramInt, ((VideoHolderBase)localObject2).b, ((VideoHolderBase)localObject2).b);
        }
      }
    }
    else
    {
      SLog.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, GroupHolder=null");
    }
    if ((StoryPlayerGlobalHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder) instanceof MsgTabPlayPageLoader.MsgTabGroupId))
    {
      localObject1 = ((MsgTabPlayPageLoader.MsgTabGroupId)StoryPlayerGlobalHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder)).a;
      if (localObject1 != null) {
        if (!TextUtils.equals(((MsgTabNodeInfo)localObject1).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_JavaLangString = ((MsgTabNodeInfo)localObject1).jdField_a_of_type_JavaLangString;
          localObject2 = new MsgTabNodeClickRequest();
          ((MsgTabNodeClickRequest)localObject2).c = ((MsgTabNodeInfo)localObject1).jdField_a_of_type_Int;
          ((MsgTabNodeClickRequest)localObject2).jdField_b_of_type_JavaLangString = ((MsgTabNodeInfo)localObject1).jdField_a_of_type_JavaLangString;
          ((MsgTabNodeClickRequest)localObject2).jdField_b_of_type_Long = ((MsgTabNodeInfo)localObject1).e;
          ((MsgTabNodeInfo)localObject1).c = false;
          CmdTaskManger.a().a((NetworkRequest)localObject2, null);
          SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, send MsgTabNodeClickRequest:%s", localObject1);
        }
        else
        {
          SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, repeat unionId : %s", this.jdField_a_of_type_JavaLangString);
        }
      }
    }
    else
    {
      SLog.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, read node event error");
    }
    c(paramInt);
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
    if (StoryPlayerGlobalHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder) != null) {
      StoryPlayerGlobalHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder.a.c(), paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void b(int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder.a.c();
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder.a(i);
    if (localObject != null)
    {
      localObject = ((StoryPlayerGroupHolder)localObject).a();
      if ((localObject instanceof VideoHolderContainer))
      {
        localObject = (VideoViewVideoHolder)((VideoHolderContainer)localObject).b(VideoViewVideoHolder.class);
        if (localObject != null) {
          if (paramInt == 1)
          {
            SLog.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "Vertical, pause because of dragging");
            ((VideoViewVideoHolder)localObject).e();
          }
          else if (paramInt == 0)
          {
            SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "Vertical, start because of idle. direction=%d", Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder.a.b()));
            if (!((VideoViewVideoHolder)localObject).a.a()) {
              ((VideoViewVideoHolder)localObject).d();
            }
            ThreadManager.executeOnSubThread(new StoryPlayerGlobalHolder.GroupOnPageChangeListener.1(this));
          }
        }
      }
    }
    if (StoryPlayerGlobalHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder) != null) {
      StoryPlayerGlobalHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder).a(i, paramInt);
    }
  }
  
  public void c(int paramInt)
  {
    Iterator localIterator = StoryPlayerGlobalHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder).a.values().iterator();
    int i = 0;
    do
    {
      paramInt = i;
      if (!localIterator.hasNext()) {
        break;
      }
      StoryPlayerGroupHolder localStoryPlayerGroupHolder = (StoryPlayerGroupHolder)localIterator.next();
      if ((i == 0) && (!localStoryPlayerGroupHolder.e())) {
        paramInt = 0;
      } else {
        paramInt = 1;
      }
      i = paramInt;
    } while (paramInt == 0);
    if (paramInt == 0) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGlobalHolder.GroupOnPageChangeListener
 * JD-Core Version:    0.7.0.1
 */