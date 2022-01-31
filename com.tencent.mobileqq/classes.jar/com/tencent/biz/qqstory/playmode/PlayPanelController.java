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
    paramLayoutInflater.inflate(2130970883, paramTopViewHolder.c, true);
    paramLayoutInflater = (TextView)paramTopViewHolder.c.findViewById(2131372126);
    paramTopViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131372126, paramLayoutInflater);
    paramLayoutInflater.setOnClickListener(paramVideoPlayerPagerAdapter);
  }
  
  public static void a(LayoutInflater paramLayoutInflater, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder)
  {
    paramLayoutInflater.inflate(2130970890, paramVideoViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout, true);
    paramLayoutInflater = (ImageView)paramVideoViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372137);
    TextView localTextView1 = (TextView)paramVideoViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131369188);
    TextView localTextView2 = (TextView)paramVideoViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131369119);
    TextView localTextView3 = (TextView)paramVideoViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372130);
    View localView1 = paramVideoViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372140);
    View localView2 = paramVideoViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371695);
    ImageView localImageView = (ImageView)paramVideoViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371682);
    TextView localTextView4 = (TextView)paramVideoViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372141);
    TextView localTextView5 = (TextView)paramVideoViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372142);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131372137, paramLayoutInflater);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131369188, localTextView1);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131369119, localTextView2);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131372130, localTextView3);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131372139, paramVideoViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372139));
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131372140, localView1);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131371695, localView2);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131371682, localImageView);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131372141, localTextView4);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131372142, localTextView5);
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
    paramLayoutInflater.inflate(2130970882, paramTopViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout, true);
    paramLayoutInflater = (TextView)paramTopViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372125);
    paramTopViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131372125, paramLayoutInflater);
    paramLayoutInflater.setOnClickListener(paramVideoPlayerPagerAdapter);
  }
  
  public static void b(LayoutInflater paramLayoutInflater, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder)
  {
    paramLayoutInflater.inflate(2130970877, paramVideoViewHolder.b, true);
    paramLayoutInflater = paramVideoViewHolder.b.findViewById(2131368333);
    TextView localTextView1 = (TextView)paramVideoViewHolder.b.findViewById(2131372106);
    ImageView localImageView1 = (ImageView)paramVideoViewHolder.b.findViewById(2131372105);
    View localView = paramVideoViewHolder.b.findViewById(2131366988);
    TextView localTextView2 = (TextView)paramVideoViewHolder.b.findViewById(2131372108);
    ImageView localImageView2 = (ImageView)paramVideoViewHolder.b.findViewById(2131372107);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131368333, paramLayoutInflater);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131372106, localTextView1);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131372105, localImageView1);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131366988, localView);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131372108, localTextView2);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131372107, localImageView2);
    paramLayoutInflater.setOnClickListener(paramVideoPlayerPagerAdapter);
    localTextView1.setOnClickListener(paramVideoPlayerPagerAdapter);
    localImageView1.setOnClickListener(paramVideoPlayerPagerAdapter);
    localView.setOnClickListener(paramVideoPlayerPagerAdapter);
    localTextView2.setOnClickListener(paramVideoPlayerPagerAdapter);
    localImageView2.setOnClickListener(paramVideoPlayerPagerAdapter);
  }
  
  public static void c(LayoutInflater paramLayoutInflater, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder)
  {
    paramLayoutInflater.inflate(2130970881, paramVideoViewHolder.c, true);
    paramLayoutInflater = (TextView)paramVideoViewHolder.c.findViewById(2131372124);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131372124, paramLayoutInflater);
    ElasticImageView localElasticImageView = (ElasticImageView)paramVideoViewHolder.c.findViewById(2131364579);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131364579, localElasticImageView);
    paramLayoutInflater.setOnClickListener(paramVideoPlayerPagerAdapter);
    localElasticImageView.setOnClickListener(paramVideoPlayerPagerAdapter);
  }
  
  public static void d(LayoutInflater paramLayoutInflater, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder)
  {
    paramLayoutInflater.inflate(2130970880, paramVideoViewHolder.d, true);
    paramLayoutInflater = (ElasticImageView)paramVideoViewHolder.d.findViewById(2131372122);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131372122, paramLayoutInflater);
    paramLayoutInflater.setOnClickListener(paramVideoPlayerPagerAdapter);
  }
  
  public static void e(LayoutInflater paramLayoutInflater, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130970889, paramVideoViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
    paramVideoViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramLayoutInflater);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131372132, paramLayoutInflater);
    paramLayoutInflater.setOnClickListener(paramVideoPlayerPagerAdapter);
    paramVideoPlayerPagerAdapter = (ImageView)paramVideoViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131372133);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131372133, paramVideoPlayerPagerAdapter);
    paramVideoPlayerPagerAdapter = (ProgressBar)paramLayoutInflater.findViewById(2131372134);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131372134, paramVideoPlayerPagerAdapter);
    paramLayoutInflater = (TextView)paramLayoutInflater.findViewById(2131372135);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131372135, paramLayoutInflater);
  }
  
  public static void f(LayoutInflater paramLayoutInflater, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder)
  {
    paramLayoutInflater.inflate(2130970884, paramVideoViewHolder.d, true);
    paramLayoutInflater = paramVideoViewHolder.d.findViewById(2131372127);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131372127, paramLayoutInflater);
    paramLayoutInflater.setOnClickListener(paramVideoPlayerPagerAdapter);
  }
  
  public static void g(LayoutInflater paramLayoutInflater, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130970896, paramVideoViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
    paramLayoutInflater.setVisibility(4);
    paramVideoViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramLayoutInflater);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131364810, paramLayoutInflater);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.PlayPanelController
 * JD-Core Version:    0.7.0.1
 */