package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.qqstorylist.ILocalVideoPusher;
import com.tencent.biz.qqstory.storyHome.qqstorylist.LocalVideoPusher;
import com.tencent.biz.qqstory.storyHome.qqstorylist.LocalVideoPusher.EventCallBack;
import com.tencent.biz.qqstory.storyHome.qqstorylist.LocalVideoPusher.Response;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.ThumbSlideShowView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import java.util.ArrayList;
import ofi;
import ofj;
import ofk;
import ofl;

public class LocalVideoPushSegment
  extends SegmentView
  implements LocalVideoPusher.EventCallBack
{
  public static final String KEY = "LocalVideoPushSegment";
  public StoryConfigManager a;
  private LocalVideoPusher jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistLocalVideoPusher;
  private BaseViewHolder jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder;
  private LocalVideoPushSegment.EventListener jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentLocalVideoPushSegment$EventListener;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  
  public LocalVideoPushSegment(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistLocalVideoPusher = new LocalVideoPusher(paramContext);
    this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager = ((StoryConfigManager)SuperManager.a(10));
    h();
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentLocalVideoPushSegment$EventListener == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentLocalVideoPushSegment$EventListener.i();
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistLocalVideoPusher.a(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistLocalVideoPusher.a(new ofk(this)).a(new ofj(this));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistLocalVideoPusher.a(new ofl(this));
    long l = ((Long)this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("last_click_time", Long.valueOf(0L))).longValue();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistLocalVideoPusher.a(l);
  }
  
  public int a()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    while (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
      return 0;
    }
    return 1;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder == null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder = paramBaseViewHolder;
    }
    paramBaseViewHolder = (TextView)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a(2131371851);
    paramViewGroup = (Button)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a(2131371852);
    ThumbSlideShowView localThumbSlideShowView = (ThumbSlideShowView)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a(2131371853);
    ImageView localImageView = (ImageView)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a(2131371850);
    TextView localTextView = (TextView)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a(2131371854);
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        localThumbSlideShowView.a(this.jdField_a_of_type_JavaUtilArrayList);
      }
      localTextView.setText(String.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()));
      if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
        break label243;
      }
      paramBaseViewHolder.setText(this.jdField_b_of_type_JavaLangString + " · " + this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a().setOnClickListener(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder);
      paramViewGroup.setOnClickListener(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder);
      localImageView.setOnClickListener(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder);
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a == null) {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a(new ofi(this));
      }
      return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a();
      label243:
      paramBaseViewHolder.setText("和好友分享你的近况");
    }
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder = new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970777, paramViewGroup, false));
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder;
  }
  
  public LocalVideoPushSegment a(LocalVideoPushSegment.EventListener paramEventListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentLocalVideoPushSegment$EventListener = paramEventListener;
    return this;
  }
  
  public String a()
  {
    return "LocalVideoPushSegment";
  }
  
  public void a(LocalVideoPusher.Response paramResponse)
  {
    if ((paramResponse.jdField_a_of_type_JavaUtilArrayList != null) && (paramResponse.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      StoryReportor.a("home_page", "exp_album", 0, 0, new String[] { String.valueOf(paramResponse.jdField_a_of_type_JavaUtilArrayList.size()) });
    }
    a_(paramResponse);
    c(true);
  }
  
  public void a_(Object paramObject)
  {
    int i;
    if (a() > 0)
    {
      i = 1;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_b_of_type_JavaLangString = null;
      if (paramObject != null) {
        break label36;
      }
    }
    for (;;)
    {
      return;
      i = 0;
      break;
      try
      {
        label36:
        paramObject = (LocalVideoPusher.Response)paramObject;
        if ((paramObject.jdField_a_of_type_JavaUtilArrayList != null) && (paramObject.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          this.jdField_a_of_type_JavaUtilArrayList.addAll(paramObject.jdField_a_of_type_JavaUtilArrayList);
          this.jdField_a_of_type_JavaLangString = paramObject.jdField_b_of_type_JavaLangString;
          this.jdField_b_of_type_JavaLangString = paramObject.jdField_a_of_type_JavaLangString;
          this.jdField_b_of_type_Boolean = true;
        }
        if ((i != 0) || (a() <= 0)) {
          continue;
        }
        StoryReportor.a("home_page", "exp_album", 0, 0, new String[] { String.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) });
        return;
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          SLog.c("Q.qqstory.home.LocalVideoPushSegment", "set data error:%s", paramObject);
        }
      }
    }
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistLocalVideoPusher.a();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistLocalVideoPusher.b();
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistLocalVideoPusher.c();
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder != null)
    {
      ThumbSlideShowView localThumbSlideShowView = (ThumbSlideShowView)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a(2131371853);
      if (localThumbSlideShowView != null) {
        localThumbSlideShowView.a();
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder = null;
    }
  }
  
  protected void e()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistLocalVideoPusher.a(false);
  }
  
  protected void g()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistLocalVideoPusher.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.LocalVideoPushSegment
 * JD-Core Version:    0.7.0.1
 */