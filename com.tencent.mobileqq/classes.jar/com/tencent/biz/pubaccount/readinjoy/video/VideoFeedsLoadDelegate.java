package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.PendingIntent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import anzj;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.qqstory.view.widget.DragFrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import rlo;
import rlp;
import rpt;
import rxx;

public class VideoFeedsLoadDelegate
  implements rlo
{
  protected static ArrayList<VideoInfo> a;
  protected int a;
  protected Bundle a;
  protected FragmentActivity a;
  protected ViewGroup a;
  protected VideoFeedsRecommendFragment a;
  protected QQAppInterface a;
  protected String a;
  protected rlp a;
  protected String[] a;
  protected int b;
  protected String b;
  protected boolean b;
  protected String c;
  
  public VideoFeedsLoadDelegate(rlp paramrlp, Bundle paramBundle, QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_Int = 2131365008;
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { anzj.a(2131714919), anzj.a(2131714954) };
    this.jdField_a_of_type_Rlp = paramrlp;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.c = paramString2;
    this.jdField_b_of_type_JavaLangString = paramString3;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_Int = paramInt;
  }
  
  private VideoInfo a()
  {
    Object localObject1 = new VideoInfo();
    if (this.jdField_a_of_type_AndroidOsBundle.getParcelable("VIDEO_OBJ") != null)
    {
      localObject1 = (VideoInfo)this.jdField_a_of_type_AndroidOsBundle.getParcelable("VIDEO_OBJ");
      rpt.a((VideoInfo)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsLoadDelegate", 2, "generateRequestVideoInfo: 外部传进来的VideoInfo=" + ((VideoInfo)localObject1).b());
      }
      this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_ARTICLE_ID", ((VideoInfo)localObject1).g);
    }
    Object localObject2;
    do
    {
      return localObject1;
      localObject2 = (MessageForShortVideo)this.jdField_a_of_type_AndroidOsBundle.getParcelable("key_message_for_shortvideo");
      if (localObject2 != null)
      {
        ((VideoInfo)localObject1).jdField_a_of_type_Int = 0;
        ((VideoInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = ((MessageForShortVideo)localObject2);
        return localObject1;
      }
      localObject2 = rpt.a(this.jdField_a_of_type_AndroidOsBundle);
      rpt.a((VideoInfo)localObject2);
      localObject1 = localObject2;
    } while (!QLog.isColorLevel());
    QLog.d("VideoFeedsLoadDelegate", 2, "generateRequestVideoInfo: 外部传进来的VideoInfo=" + ((VideoInfo)localObject2).b());
    return localObject2;
  }
  
  public static void a(PendingIntent paramPendingIntent)
  {
    jdField_a_of_type_JavaUtilArrayList = null;
  }
  
  private void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    if (paramBundle.getString("enable_video_feeds_default_anim", "0").equals("1"))
    {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.overridePendingTransition(0, 0);
      return;
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.overridePendingTransition(2130772225, 0);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment = a();
    this.jdField_a_of_type_AndroidViewViewGroup = a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment);
    paramLayoutInflater = new ViewGroup.LayoutParams(-1, -1);
    paramViewGroup.addView(this.jdField_a_of_type_AndroidViewViewGroup, 0, paramLayoutInflater);
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  protected ViewGroup a(int paramInt, Fragment paramFragment)
  {
    FrameLayout localFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    localFrameLayout.setId(paramInt);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSupportFragmentManager().beginTransaction().replace(paramInt, paramFragment).commitAllowingStateLoss();
    return localFrameLayout;
  }
  
  protected VideoFeedsRecommendFragment a()
  {
    Object localObject;
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("VIDEO_IS_CACHE_CACHE_INFO_LIST", false))
    {
      localObject = jdField_a_of_type_JavaUtilArrayList;
      jdField_a_of_type_JavaUtilArrayList = null;
    }
    for (;;)
    {
      int i;
      VideoInfo localVideoInfo;
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        i = this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FIRST_INFO_POSITION", 0);
        localVideoInfo = (VideoInfo)((ArrayList)localObject).remove(0);
        this.jdField_a_of_type_AndroidOsBundle.putParcelableArrayList("VIDEO_RECOMMEND_LIST", (ArrayList)localObject);
      }
      for (localObject = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_AndroidOsBundle, localVideoInfo, this.jdField_a_of_type_JavaLangString, this.c, this.jdField_b_of_type_JavaLangString, true, i);; localObject = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_AndroidOsBundle, a(), this.jdField_a_of_type_JavaLangString, this.c, this.jdField_b_of_type_JavaLangString))
      {
        if (this.jdField_a_of_type_Rlp != null) {
          this.jdField_a_of_type_Rlp.a((VideoFeedsRecommendFragment)localObject);
        }
        return localObject;
      }
      localObject = null;
    }
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {}
    while (this.jdField_a_of_type_AndroidOsBundle.getInt("KEY_OLD_LOAD_DELEGATE_TYPE", -1) != 2) {
      return;
    }
    new rxx(null, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_JavaLangString, this.c, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Boolean, this.jdField_b_of_type_Int).b(paramVideoInfo);
  }
  
  public void a(DragFrameLayout paramDragFrameLayout)
  {
    int k = this.jdField_a_of_type_AndroidOsBundle.getInt("item_x", 0);
    int m = this.jdField_a_of_type_AndroidOsBundle.getInt("item_y", 0);
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("item_width", 0);
    int n = this.jdField_a_of_type_AndroidOsBundle.getInt("item_height", 0);
    int j = rpt.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)[0];
    if (((k == 0) && (m == 0) && (i == 0)) || (i >= n))
    {
      a(this.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    int[] arrayOfInt = rpt.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, k, m);
    k = arrayOfInt[0];
    m = arrayOfInt[1];
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.overridePendingTransition(0, 0);
    paramDragFrameLayout.setSizeAndPosition(i * 1.0F / j, k, m);
    paramDragFrameLayout.post(new VideoFeedsLoadDelegate.1(this, paramDragFrameLayout));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsLoadDelegate
 * JD-Core Version:    0.7.0.1
 */