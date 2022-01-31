package com.tencent.biz.qqstory.playmode;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ElasticImageView;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder;

public class PlayPanelController
{
  public static void a(LayoutInflater paramLayoutInflater, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, VideoPlayModeBase.TopViewHolder paramTopViewHolder)
  {
    paramLayoutInflater.inflate(2130970900, paramTopViewHolder.c, true);
    paramLayoutInflater = (TextView)paramTopViewHolder.c.findViewById(2131372134);
    paramTopViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131372134, paramLayoutInflater);
    paramLayoutInflater.setOnClickListener(paramVideoPlayerPagerAdapter);
  }
  
  public static void a(LayoutInflater paramLayoutInflater, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder)
  {
    paramLayoutInflater.inflate(2130970907, paramVideoViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout, true);
    paramLayoutInflater = (ImageView)paramVideoViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372145);
    TextView localTextView1 = (TextView)paramVideoViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131369189);
    TextView localTextView2 = (TextView)paramVideoViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131369120);
    TextView localTextView3 = (TextView)paramVideoViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372138);
    View localView1 = paramVideoViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372148);
    View localView2 = paramVideoViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371693);
    ImageView localImageView = (ImageView)paramVideoViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371680);
    TextView localTextView4 = (TextView)paramVideoViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372149);
    TextView localTextView5 = (TextView)paramVideoViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372150);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131372145, paramLayoutInflater);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131369189, localTextView1);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131369120, localTextView2);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131372138, localTextView3);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131372147, paramVideoViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372147));
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131372148, localView1);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131371693, localView2);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131371680, localImageView);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131372149, localTextView4);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131372150, localTextView5);
    paramLayoutInflater.setOnClickListener(paramVideoPlayerPagerAdapter);
    localTextView1.setOnClickListener(paramVideoPlayerPagerAdapter);
    localTextView2.setOnClickListener(paramVideoPlayerPagerAdapter);
    localTextView3.setOnClickListener(paramVideoPlayerPagerAdapter);
    localView1.setOnClickListener(paramVideoPlayerPagerAdapter);
    localView2.setOnClickListener(paramVideoPlayerPagerAdapter);
    localTextView4.setOnClickListener(paramVideoPlayerPagerAdapter);
    localTextView5.setOnClickListener(paramVideoPlayerPagerAdapter);
  }
  
  public static void b(LayoutInflater paramLayoutInflater, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, VideoPlayModeBase.TopViewHolder paramTopViewHolder)
  {
    paramLayoutInflater.inflate(2130970899, paramTopViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout, true);
    paramLayoutInflater = (TextView)paramTopViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372133);
    paramTopViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131372133, paramLayoutInflater);
    paramLayoutInflater.setOnClickListener(paramVideoPlayerPagerAdapter);
  }
  
  public static void b(LayoutInflater paramLayoutInflater, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder)
  {
    paramLayoutInflater.inflate(2130970894, paramVideoViewHolder.b, true);
    paramLayoutInflater = paramVideoViewHolder.b.findViewById(2131368335);
    TextView localTextView1 = (TextView)paramVideoViewHolder.b.findViewById(2131372114);
    ImageView localImageView1 = (ImageView)paramVideoViewHolder.b.findViewById(2131372113);
    View localView = paramVideoViewHolder.b.findViewById(2131366986);
    TextView localTextView2 = (TextView)paramVideoViewHolder.b.findViewById(2131372116);
    ImageView localImageView2 = (ImageView)paramVideoViewHolder.b.findViewById(2131372115);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131368335, paramLayoutInflater);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131372114, localTextView1);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131372113, localImageView1);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131366986, localView);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131372116, localTextView2);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131372115, localImageView2);
    paramLayoutInflater.setOnClickListener(paramVideoPlayerPagerAdapter);
    localTextView1.setOnClickListener(paramVideoPlayerPagerAdapter);
    localImageView1.setOnClickListener(paramVideoPlayerPagerAdapter);
    localView.setOnClickListener(paramVideoPlayerPagerAdapter);
    localTextView2.setOnClickListener(paramVideoPlayerPagerAdapter);
    localImageView2.setOnClickListener(paramVideoPlayerPagerAdapter);
  }
  
  public static void c(LayoutInflater paramLayoutInflater, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder)
  {
    paramLayoutInflater.inflate(2130970898, paramVideoViewHolder.c, true);
    paramLayoutInflater = (TextView)paramVideoViewHolder.c.findViewById(2131372132);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131372132, paramLayoutInflater);
    ElasticImageView localElasticImageView = (ElasticImageView)paramVideoViewHolder.c.findViewById(2131364603);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131364603, localElasticImageView);
    paramLayoutInflater.setOnClickListener(paramVideoPlayerPagerAdapter);
    localElasticImageView.setOnClickListener(paramVideoPlayerPagerAdapter);
  }
  
  public static void d(LayoutInflater paramLayoutInflater, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder)
  {
    paramLayoutInflater.inflate(2130970897, paramVideoViewHolder.d, true);
    paramLayoutInflater = (ElasticImageView)paramVideoViewHolder.d.findViewById(2131372130);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131372130, paramLayoutInflater);
    paramLayoutInflater.setOnClickListener(paramVideoPlayerPagerAdapter);
  }
  
  public static void e(LayoutInflater paramLayoutInflater, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130970906, paramVideoViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
    paramVideoViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramLayoutInflater);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131372140, paramLayoutInflater);
    paramLayoutInflater.setOnClickListener(paramVideoPlayerPagerAdapter);
    paramVideoPlayerPagerAdapter = (ImageView)paramVideoViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131372141);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131372141, paramVideoPlayerPagerAdapter);
    paramVideoPlayerPagerAdapter = (ProgressBar)paramLayoutInflater.findViewById(2131372142);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131372142, paramVideoPlayerPagerAdapter);
    paramLayoutInflater = (TextView)paramLayoutInflater.findViewById(2131372143);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131372143, paramLayoutInflater);
  }
  
  public static void f(LayoutInflater paramLayoutInflater, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder)
  {
    paramLayoutInflater.inflate(2130970901, paramVideoViewHolder.d, true);
    paramLayoutInflater = paramVideoViewHolder.d.findViewById(2131372135);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131372135, paramLayoutInflater);
    paramLayoutInflater.setOnClickListener(paramVideoPlayerPagerAdapter);
  }
  
  public static void g(LayoutInflater paramLayoutInflater, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130970913, paramVideoViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
    paramLayoutInflater.setVisibility(4);
    paramVideoViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramLayoutInflater);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131364837, paramLayoutInflater);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.PlayPanelController
 * JD-Core Version:    0.7.0.1
 */