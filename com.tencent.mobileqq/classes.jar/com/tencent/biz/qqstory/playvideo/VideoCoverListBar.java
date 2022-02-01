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
  private VideoCoverListBar.VideoCoverListBarAdapter a;
  private VideoCoverListBar.OnVideoClickListener b;
  private VideoCoverListBar.VideoCoverListDataProvider c;
  private List<String> d = new ArrayList();
  private String e;
  private int f;
  private int g;
  private int h;
  private int i;
  private EmptyDrawable j;
  private EmptyDrawable k;
  private StoryManager l;
  
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
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      ThreadManager.getUIHandler().post(new VideoCoverListBar.2(this, paramInt, paramList));
      return;
    }
    if (paramList == null) {
      this.d = new ArrayList();
    } else {
      this.d = paramList;
    }
    this.a.notifyDataSetChanged();
    if (this.d.size() <= 1)
    {
      setVisibility(8);
      SLog.b("Q.qqstory.player:VideoCoverListBar", "video list too small, hide");
      return;
    }
    setVisibility(0);
    if (paramInt >= 0) {
      ThreadManager.getUIHandler().postDelayed(new VideoCoverListBar.3(this, paramInt), 30L);
    }
    if ((paramInt >= 0) && (paramInt < this.d.size())) {
      StoryReportor.a("play_video", "exp_mini", 0, 0, new String[] { "2", "", "", (String)this.d.get(paramInt) });
    }
  }
  
  private void a(Context paramContext)
  {
    this.l = ((StoryManager)SuperManager.a(5));
    int m = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.f = getContext().getResources().getDimensionPixelOffset(2131299793);
    this.g = getContext().getResources().getDimensionPixelOffset(2131299792);
    this.h = getContext().getResources().getDimensionPixelOffset(2131299790);
    this.i = UIUtils.a(paramContext, 11.0F);
    this.j = new EmptyDrawable(-2631721, this.f, this.g);
    this.k = new EmptyDrawable(0, this.f, this.g);
    this.a = new VideoCoverListBar.VideoCoverListBarAdapter(this, null);
    setOverScrollMode(2);
    setDivider(new ColorDrawable(0));
    setDividerHeight(this.i);
    setHeaderDividersEnabled(false);
    setFooterDividersEnabled(false);
    setVerticalScrollBarEnabled(false);
    setAdapter(this.a);
    setOnTouchListener(new VideoCoverListBar.1(this, m));
  }
  
  public void a()
  {
    a(this.e);
  }
  
  public void a(VideoCoverListBar.VideoCoverListDataProvider paramVideoCoverListDataProvider)
  {
    this.c = paramVideoCoverListDataProvider;
  }
  
  public void a(String paramString)
  {
    List localList = this.c.a();
    if (localList != null)
    {
      int m = 0;
      while (m < localList.size())
      {
        if (TextUtils.equals((CharSequence)localList.get(m), paramString))
        {
          this.e = paramString;
          SLog.a("Q.qqstory.player:VideoCoverListBar", "notify ! vid = %s , index = %d", paramString, Integer.valueOf(m));
          a(m, localList);
          return;
        }
        m += 1;
      }
    }
    a(-1, localList);
    SLog.d("Q.qqstory.player:VideoCoverListBar", "vid not found ! vid = %s", new Object[] { paramString });
  }
  
  public void b()
  {
    a(-1, this.c.a());
  }
  
  public void setOnVideoClickListener(VideoCoverListBar.OnVideoClickListener paramOnVideoClickListener)
  {
    this.b = paramOnVideoClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.VideoCoverListBar
 * JD-Core Version:    0.7.0.1
 */