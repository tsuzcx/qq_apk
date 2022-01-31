package com.tencent.biz.qqstory.playvideo;

import amym;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewConfiguration;
import android.widget.ListView;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import sqd;
import sqg;
import tiw;
import tix;
import tiy;
import tjb;
import urk;
import urp;
import vms;

public class VideoCoverListBar
  extends ListView
{
  private int jdField_a_of_type_Int;
  private amym jdField_a_of_type_Amym;
  private String jdField_a_of_type_JavaLangString;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private sqd jdField_a_of_type_Sqd;
  private tix jdField_a_of_type_Tix;
  private tiy jdField_a_of_type_Tiy;
  private tjb jdField_a_of_type_Tjb;
  private int jdField_b_of_type_Int;
  private amym jdField_b_of_type_Amym;
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
        this.jdField_a_of_type_Tiy.notifyDataSetChanged();
        if (this.jdField_a_of_type_JavaUtilList.size() > 1) {
          break;
        }
        setVisibility(8);
        urk.b("Q.qqstory.player:VideoCoverListBar", "video list too small, hide");
        return;
      }
      setVisibility(0);
      if (paramInt >= 0) {
        ThreadManager.getUIHandler().postDelayed(new VideoCoverListBar.3(this, paramInt), 30L);
      }
    } while ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()));
    urp.a("play_video", "exp_mini", 0, 0, new String[] { "2", "", "", (String)this.jdField_a_of_type_JavaUtilList.get(paramInt) });
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_Sqd = ((sqd)sqg.a(5));
    int i = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.jdField_a_of_type_Int = getContext().getResources().getDimensionPixelOffset(2131167681);
    this.jdField_b_of_type_Int = getContext().getResources().getDimensionPixelOffset(2131167680);
    this.c = getContext().getResources().getDimensionPixelOffset(2131167678);
    this.d = vms.a(paramContext, 11.0F);
    this.jdField_a_of_type_Amym = new amym(-2631721, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    this.jdField_b_of_type_Amym = new amym(0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_Tiy = new tiy(this, null);
    setOverScrollMode(2);
    setDivider(new ColorDrawable(0));
    setDividerHeight(this.d);
    setHeaderDividersEnabled(false);
    setFooterDividersEnabled(false);
    setVerticalScrollBarEnabled(false);
    setAdapter(this.jdField_a_of_type_Tiy);
    setOnTouchListener(new tiw(this, i));
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(String paramString)
  {
    List localList = this.jdField_a_of_type_Tjb.a();
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        if (TextUtils.equals((CharSequence)localList.get(i), paramString))
        {
          this.jdField_a_of_type_JavaLangString = paramString;
          urk.a("Q.qqstory.player:VideoCoverListBar", "notify ! vid = %s , index = %d", paramString, Integer.valueOf(i));
          a(i, localList);
          return;
        }
        i += 1;
      }
    }
    a(-1, localList);
    urk.d("Q.qqstory.player:VideoCoverListBar", "vid not found ! vid = %s", new Object[] { paramString });
  }
  
  public void a(tjb paramtjb)
  {
    this.jdField_a_of_type_Tjb = paramtjb;
  }
  
  public void b()
  {
    a(-1, this.jdField_a_of_type_Tjb.a());
  }
  
  public void setOnVideoClickListener(tix paramtix)
  {
    this.jdField_a_of_type_Tix = paramtix;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.VideoCoverListBar
 * JD-Core Version:    0.7.0.1
 */