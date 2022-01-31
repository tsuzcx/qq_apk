package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import twg;
import urk;

public class StoryPlayerWebToolFragment
  extends PublicBaseFragment
  implements twg
{
  private View jdField_a_of_type_AndroidViewView;
  private StoryPlayerWebFragment jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetStoryPlayerWebFragment;
  
  public void a()
  {
    getActivity().finish();
  }
  
  public void b() {}
  
  public boolean needImmersive()
  {
    return true;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    paramActivity.setTheme(16973841);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131495744, null);
    paramViewGroup = getChildFragmentManager();
    paramLayoutInflater = getArguments().getString("url");
    paramViewGroup = paramViewGroup.beginTransaction();
    paramBundle = new Intent();
    paramBundle.putExtra("url", paramLayoutInflater);
    paramBundle.putExtra("isFullScreen", true);
    urk.a("StoryPlayerWebToolFragment", "initPromoteFragment() with url: %s", paramLayoutInflater);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetStoryPlayerWebFragment = StoryPlayerWebFragment.a(paramBundle);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetStoryPlayerWebFragment.a(this);
    paramViewGroup.replace(2131313545, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetStoryPlayerWebFragment).commit();
    return this.jdField_a_of_type_AndroidViewView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.StoryPlayerWebToolFragment
 * JD-Core Version:    0.7.0.1
 */