package com.tencent.biz.qqstory.playvideo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewConfiguration;
import android.widget.ListView;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class VideoCoverListBar
  extends ListView
{
  private int jdField_a_of_type_Int;
  private StoryManager jdField_a_of_type_ComTencentBizQqstoryModelStoryManager;
  private VideoCoverListBar.OnVideoClickListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar$OnVideoClickListener;
  private VideoCoverListBar.VideoCoverListBarAdapter jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar$VideoCoverListBarAdapter;
  private VideoCoverListBar.VideoCoverListDataProvider jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar$VideoCoverListDataProvider;
  private EmptyDrawable jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable;
  private String jdField_a_of_type_JavaLangString;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int jdField_b_of_type_Int;
  private EmptyDrawable jdField_b_of_type_ComTencentMobileqqDrawableEmptyDrawable;
  private int c;
  private int d;
  
  public VideoCoverListBar(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public VideoCoverListBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(int paramInt, List<String> paramList)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
      ThreadManager.getUIHandler().post(new VideoCoverListBar.2(this, paramInt, paramList));
    }
    do
    {
      return;
      if (paramList == null) {}
      for (this.jdField_a_of_type_JavaUtilList = new ArrayList();; this.jdField_a_of_type_JavaUtilList = paramList)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar$VideoCoverListBarAdapter.notifyDataSetChanged();
        if (this.jdField_a_of_type_JavaUtilList.size() > 1) {
          break;
        }
        setVisibility(8);
        SLog.b("Q.qqstory.player:VideoCoverListBar", "video list too small, hide");
        return;
      }
      setVisibility(0);
      if (paramInt >= 0) {
        ThreadManager.getUIHandler().postDelayed(new VideoCoverListBar.3(this, paramInt), 30L);
      }
    } while ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()));
    StoryReportor.a("play_video", "exp_mini", 0, 0, new String[] { "2", "", "", (String)this.jdField_a_of_type_JavaUtilList.get(paramInt) });
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelStoryManager = ((StoryManager)SuperManager.a(5));
    int i = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.jdField_a_of_type_Int = getContext().getResources().getDimensionPixelOffset(2131299060);
    this.jdField_b_of_type_Int = getContext().getResources().getDimensionPixelOffset(2131299059);
    this.c = getContext().getResources().getDimensionPixelOffset(2131299057);
    this.d = UIUtils.a(paramContext, 11.0F);
    this.jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable = new EmptyDrawable(-2631721, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    this.jdField_b_of_type_ComTencentMobileqqDrawableEmptyDrawable = new EmptyDrawable(0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar$VideoCoverListBarAdapter = new VideoCoverListBar.VideoCoverListBarAdapter(this, null);
    setOverScrollMode(2);
    setDivider(new ColorDrawable(0));
    setDividerHeight(this.d);
    setHeaderDividersEnabled(false);
    setFooterDividersEnabled(false);
    setVerticalScrollBarEnabled(false);
    setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar$VideoCoverListBarAdapter);
    setOnTouchListener(new VideoCoverListBar.1(this, i));
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(VideoCoverListBar.VideoCoverListDataProvider paramVideoCoverListDataProvider)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar$VideoCoverListDataProvider = paramVideoCoverListDataProvider;
  }
  
  public void a(String paramString)
  {
    List localList = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar$VideoCoverListDataProvider.a();
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        if (TextUtils.equals((CharSequence)localList.get(i), paramString))
        {
          this.jdField_a_of_type_JavaLangString = paramString;
          SLog.a("Q.qqstory.player:VideoCoverListBar", "notify ! vid = %s , index = %d", paramString, Integer.valueOf(i));
          a(i, localList);
          return;
        }
        i += 1;
      }
    }
    a(-1, localList);
    SLog.d("Q.qqstory.player:VideoCoverListBar", "vid not found ! vid = %s", new Object[] { paramString });
  }
  
  public void b()
  {
    a(-1, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar$VideoCoverListDataProvider.a());
  }
  
  public void setOnVideoClickListener(VideoCoverListBar.OnVideoClickListener paramOnVideoClickListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar$OnVideoClickListener = paramOnVideoClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.VideoCoverListBar
 * JD-Core Version:    0.7.0.1
 */