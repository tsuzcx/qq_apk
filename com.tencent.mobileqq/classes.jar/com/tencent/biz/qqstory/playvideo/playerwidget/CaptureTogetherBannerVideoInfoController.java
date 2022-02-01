package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.VideoCompInfo;
import com.tencent.biz.qqstory.model.item.VideoLinkInfo;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.ActivityLifeCycle;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tribe.async.dispatch.Subscriber;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CaptureTogetherBannerVideoInfoController
  extends BannerVideoInfoWidget3.BannerVideoInfoController
{
  private int jdField_a_of_type_Int;
  private VideoLinkInfo jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo;
  private StoryPlayerVideoData jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData;
  private BannerVideoInfoWidget3.MyActivityLifeCycle jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3$MyActivityLifeCycle;
  private CaptureTogetherBannerVideoInfoController.StoryVideoDownloadResultReceiver jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetCaptureTogetherBannerVideoInfoController$StoryVideoDownloadResultReceiver;
  private String jdField_a_of_type_JavaLangString = "";
  private String b;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = false;
  
  private void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  private void b()
  {
    int i = this.jdField_a_of_type_Int;
    if ((i != 1) && (i != 2)) {
      return;
    }
    StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.a();
    Object localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoCompInfo;
    i = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.a().comparedLevel;
    int j = this.jdField_a_of_type_Int;
    String str1 = "2";
    String str2;
    if (j == 1)
    {
      Object localObject2 = ((VideoCompInfo)localObject1).jdField_a_of_type_JavaLangString;
      str2 = ((VideoCompInfo)localObject1).b;
      j = ((VideoCompInfo)localObject1).jdField_a_of_type_Int;
      localObject1 = (StoryManager)SuperManager.a(5);
      UserManager localUserManager = (UserManager)SuperManager.a(2);
      localObject1 = ((StoryManager)localObject1).b(str2);
      if (localObject1 != null)
      {
        a(str2, (String)localObject2, false, i, j);
        localObject2 = localUserManager.b(((StoryVideoItem)localObject1).mOwnerUid);
        if ((localObject2 != null) && (((QQUserUIItem)localObject2).isVip)) {
          i = 1;
        } else {
          i = 0;
        }
        if (i == 0) {
          str1 = "1";
        }
        StoryReportor.a("play_video", "multishoot_entry_clk", 0, j, new String[] { str1, str2, ((StoryVideoItem)localObject1).mOwnerUid, localStoryVideoItem.mVid });
        return;
      }
      this.b = str2;
      this.jdField_c_of_type_JavaLangString = ((String)localObject2);
      return;
    }
    if (j == 2)
    {
      str2 = localStoryVideoItem.mVid;
      a(str2, "", true, i, 0);
      localObject1 = ((UserManager)SuperManager.a(2)).b(localStoryVideoItem.mOwnerUid);
      if ((localObject1 != null) && (((QQUserUIItem)localObject1).isVip)) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        str1 = "1";
      }
      StoryReportor.a("play_video", "multishoot_entry_clk", 0, 0, new String[] { str1, str2, localStoryVideoItem.mOwnerUid, str2 });
    }
  }
  
  public Map<Subscriber, String> a()
  {
    HashMap localHashMap = new HashMap();
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetCaptureTogetherBannerVideoInfoController$StoryVideoDownloadResultReceiver == null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetCaptureTogetherBannerVideoInfoController$StoryVideoDownloadResultReceiver = new CaptureTogetherBannerVideoInfoController.StoryVideoDownloadResultReceiver(this);
    }
    localHashMap.put(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetCaptureTogetherBannerVideoInfoController$StoryVideoDownloadResultReceiver, "");
    localHashMap.put(new CaptureTogetherBannerVideoInfoController.GetVideoBasicInfoListEventReceiver(this), "");
    localHashMap.put(new CaptureTogetherBannerVideoInfoController.GetStoryTagInfoReceiver(this), "");
    return localHashMap;
  }
  
  public Set<ActivityLifeCycle> a()
  {
    HashSet localHashSet = new HashSet(1);
    BannerVideoInfoWidget3.MyActivityLifeCycle localMyActivityLifeCycle = new BannerVideoInfoWidget3.MyActivityLifeCycle();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3$MyActivityLifeCycle = localMyActivityLifeCycle;
    localHashSet.add(localMyActivityLifeCycle);
    return localHashSet;
  }
  
  public boolean a(View paramView)
  {
    if (!super.a(paramView)) {
      return false;
    }
    b();
    return true;
  }
  
  public void b(BannerVideoInfoWidget3.BannerViewHolder paramBannerViewHolder, StoryPlayerVideoData paramStoryPlayerVideoData)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData = paramStoryPlayerVideoData;
    this.b = null;
    this.jdField_c_of_type_JavaLangString = null;
    StoryVideoItem localStoryVideoItem = paramStoryPlayerVideoData.a();
    Object localObject = localStoryVideoItem.getOALinkInfo();
    VideoLinkInfo localVideoLinkInfo = localStoryVideoItem.getVideoLinkInfo();
    if ((localObject != null) && (((VideoLinkInfo)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemVideoCompInfo != null) && (!TextUtils.isEmpty(((VideoLinkInfo)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemVideoCompInfo.b)))
    {
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo = ((VideoLinkInfo)localObject);
      SLog.b("CaptureTogetherBannerVideoInfoController", "get video link info from oa, vid:%s, title:%s, comp_vid:%s, oa_task_id:%s, bg_url:%s, icon_url:%s", new Object[] { paramStoryPlayerVideoData.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo.b, this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoCompInfo.b, Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoCompInfo.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoCompInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoCompInfo.jdField_c_of_type_JavaLangString });
    }
    else
    {
      if ((localVideoLinkInfo == null) || (localVideoLinkInfo.jdField_a_of_type_Int != 3)) {
        break label522;
      }
      this.jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo = localVideoLinkInfo;
      SLog.a("CaptureTogetherBannerVideoInfoController", "get video link info from extern, vid:%s, title:%s", paramStoryPlayerVideoData.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo.b);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3.j();
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoCompInfo;
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramStoryPlayerVideoData.jdField_a_of_type_JavaLangString))
    {
      this.jdField_c_of_type_Boolean = false;
    }
    else
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_JavaLangString = paramStoryPlayerVideoData.jdField_a_of_type_JavaLangString;
    }
    paramBannerViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramBannerViewHolder.b.setVisibility(0);
    paramBannerViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramStoryPlayerVideoData = this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo.b;
    if (!TextUtils.isEmpty(paramStoryPlayerVideoData))
    {
      paramBannerViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramStoryPlayerVideoData);
      paramBannerViewHolder.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramStoryPlayerVideoData);
    }
    else
    {
      paramBannerViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131701654));
      paramBannerViewHolder.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(HardCodeUtil.a(2131701655));
    }
    paramBannerViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846663);
    if ((localObject != null) && (!TextUtils.isEmpty(((VideoCompInfo)localObject).jdField_c_of_type_JavaLangString))) {
      BannerVideoInfoWidget3.a(((VideoCompInfo)localObject).jdField_c_of_type_JavaLangString, paramBannerViewHolder.jdField_a_of_type_AndroidWidgetImageView, paramBannerViewHolder.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130846663), paramBannerViewHolder.jdField_a_of_type_Int, paramBannerViewHolder.jdField_a_of_type_Int);
    }
    paramBannerViewHolder = ((UserManager)SuperManager.a(2)).b(localStoryVideoItem.mOwnerUid);
    if (this.jdField_c_of_type_Boolean)
    {
      int i;
      if ((paramBannerViewHolder != null) && (paramBannerViewHolder.isVip)) {
        i = 1;
      } else {
        i = 0;
      }
      int j;
      if (localObject != null) {
        j = ((VideoCompInfo)localObject).jdField_a_of_type_Int;
      } else {
        j = 0;
      }
      if (i != 0) {
        paramBannerViewHolder = "2";
      } else {
        paramBannerViewHolder = "1";
      }
      if (localObject != null) {
        paramStoryPlayerVideoData = ((VideoCompInfo)localObject).b;
      } else {
        paramStoryPlayerVideoData = "";
      }
      StoryReportor.a("play_video", "multishoot_entry_exp", 0, j, new String[] { paramBannerViewHolder, paramStoryPlayerVideoData, "", localStoryVideoItem.mVid });
    }
    return;
    label522:
    SLog.a("CaptureTogetherBannerVideoInfoController", "VideoLinkInfo error, hide widget, vid:%s", paramStoryPlayerVideoData.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3.k();
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.CaptureTogetherBannerVideoInfoController
 * JD-Core Version:    0.7.0.1
 */