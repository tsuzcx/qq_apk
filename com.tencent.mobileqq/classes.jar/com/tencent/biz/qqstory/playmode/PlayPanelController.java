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
    paramLayoutInflater.inflate(2130970835, paramTopViewHolder.c, true);
    paramLayoutInflater = (TextView)paramTopViewHolder.c.findViewById(2131371953);
    paramTopViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131371953, paramLayoutInflater);
    paramLayoutInflater.setOnClickListener(paramVideoPlayerPagerAdapter);
  }
  
  public static void a(LayoutInflater paramLayoutInflater, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder)
  {
    paramLayoutInflater.inflate(2130970842, paramVideoViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout, true);
    paramLayoutInflater = (ImageView)paramVideoViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371964);
    TextView localTextView1 = (TextView)paramVideoViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131369122);
    TextView localTextView2 = (TextView)paramVideoViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131369053);
    TextView localTextView3 = (TextView)paramVideoViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371957);
    View localView1 = paramVideoViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371967);
    View localView2 = paramVideoViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371529);
    ImageView localImageView = (ImageView)paramVideoViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371516);
    TextView localTextView4 = (TextView)paramVideoViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371968);
    TextView localTextView5 = (TextView)paramVideoViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371969);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131371964, paramLayoutInflater);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131369122, localTextView1);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131369053, localTextView2);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131371957, localTextView3);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131371966, paramVideoViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371966));
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131371967, localView1);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131371529, localView2);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131371516, localImageView);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131371968, localTextView4);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131371969, localTextView5);
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
    paramLayoutInflater.inflate(2130970834, paramTopViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout, true);
    paramLayoutInflater = (TextView)paramTopViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371952);
    paramTopViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131371952, paramLayoutInflater);
    paramLayoutInflater.setOnClickListener(paramVideoPlayerPagerAdapter);
  }
  
  public static void b(LayoutInflater paramLayoutInflater, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder)
  {
    paramLayoutInflater.inflate(2130970829, paramVideoViewHolder.b, true);
    paramLayoutInflater = paramVideoViewHolder.b.findViewById(2131368266);
    TextView localTextView1 = (TextView)paramVideoViewHolder.b.findViewById(2131371933);
    ImageView localImageView1 = (ImageView)paramVideoViewHolder.b.findViewById(2131371932);
    View localView = paramVideoViewHolder.b.findViewById(2131366946);
    TextView localTextView2 = (TextView)paramVideoViewHolder.b.findViewById(2131371935);
    ImageView localImageView2 = (ImageView)paramVideoViewHolder.b.findViewById(2131371934);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131368266, paramLayoutInflater);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131371933, localTextView1);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131371932, localImageView1);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131366946, localView);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131371935, localTextView2);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131371934, localImageView2);
    paramLayoutInflater.setOnClickListener(paramVideoPlayerPagerAdapter);
    localTextView1.setOnClickListener(paramVideoPlayerPagerAdapter);
    localImageView1.setOnClickListener(paramVideoPlayerPagerAdapter);
    localView.setOnClickListener(paramVideoPlayerPagerAdapter);
    localTextView2.setOnClickListener(paramVideoPlayerPagerAdapter);
    localImageView2.setOnClickListener(paramVideoPlayerPagerAdapter);
  }
  
  public static void c(LayoutInflater paramLayoutInflater, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder)
  {
    paramLayoutInflater.inflate(2130970833, paramVideoViewHolder.c, true);
    paramLayoutInflater = (TextView)paramVideoViewHolder.c.findViewById(2131371951);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131371951, paramLayoutInflater);
    ElasticImageView localElasticImageView = (ElasticImageView)paramVideoViewHolder.c.findViewById(2131364555);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131364555, localElasticImageView);
    paramLayoutInflater.setOnClickListener(paramVideoPlayerPagerAdapter);
    localElasticImageView.setOnClickListener(paramVideoPlayerPagerAdapter);
  }
  
  public static void d(LayoutInflater paramLayoutInflater, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder)
  {
    paramLayoutInflater.inflate(2130970832, paramVideoViewHolder.d, true);
    paramLayoutInflater = (ElasticImageView)paramVideoViewHolder.d.findViewById(2131371949);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131371949, paramLayoutInflater);
    paramLayoutInflater.setOnClickListener(paramVideoPlayerPagerAdapter);
  }
  
  public static void e(LayoutInflater paramLayoutInflater, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130970841, paramVideoViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
    paramVideoViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramLayoutInflater);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131371959, paramLayoutInflater);
    paramLayoutInflater.setOnClickListener(paramVideoPlayerPagerAdapter);
    paramVideoPlayerPagerAdapter = (ImageView)paramVideoViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131371960);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131371960, paramVideoPlayerPagerAdapter);
    paramVideoPlayerPagerAdapter = (ProgressBar)paramLayoutInflater.findViewById(2131371961);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131371961, paramVideoPlayerPagerAdapter);
    paramLayoutInflater = (TextView)paramLayoutInflater.findViewById(2131371962);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131371962, paramLayoutInflater);
  }
  
  public static void f(LayoutInflater paramLayoutInflater, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder)
  {
    paramLayoutInflater.inflate(2130970836, paramVideoViewHolder.d, true);
    paramLayoutInflater = paramVideoViewHolder.d.findViewById(2131371954);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131371954, paramLayoutInflater);
    paramLayoutInflater.setOnClickListener(paramVideoPlayerPagerAdapter);
  }
  
  public static void g(LayoutInflater paramLayoutInflater, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130970848, paramVideoViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
    paramLayoutInflater.setVisibility(4);
    paramVideoViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramLayoutInflater);
    paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.put(2131364788, paramLayoutInflater);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.PlayPanelController
 * JD-Core Version:    0.7.0.1
 */