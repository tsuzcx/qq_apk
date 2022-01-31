package com.tencent.biz.qqstory.playvideo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewConfiguration;
import android.widget.ListView;
import apgg;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import uro;
import urr;
import vkh;
import vki;
import vkj;
import vkm;
import wsv;
import wta;
import xod;

public class VideoCoverListBar
  extends ListView
{
  private int jdField_a_of_type_Int;
  private apgg jdField_a_of_type_Apgg;
  private String jdField_a_of_type_JavaLangString;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private uro jdField_a_of_type_Uro;
  private vki jdField_a_of_type_Vki;
  private vkj jdField_a_of_type_Vkj;
  private vkm jdField_a_of_type_Vkm;
  private int jdField_b_of_type_Int;
  private apgg jdField_b_of_type_Apgg;
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
        this.jdField_a_of_type_Vkj.notifyDataSetChanged();
        if (this.jdField_a_of_type_JavaUtilList.size() > 1) {
          break;
        }
        setVisibility(8);
        wsv.b("Q.qqstory.player:VideoCoverListBar", "video list too small, hide");
        return;
      }
      setVisibility(0);
      if (paramInt >= 0) {
        ThreadManager.getUIHandler().postDelayed(new VideoCoverListBar.3(this, paramInt), 30L);
      }
    } while ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()));
    wta.a("play_video", "exp_mini", 0, 0, new String[] { "2", "", "", (String)this.jdField_a_of_type_JavaUtilList.get(paramInt) });
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_Uro = ((uro)urr.a(5));
    int i = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.jdField_a_of_type_Int = getContext().getResources().getDimensionPixelOffset(2131298808);
    this.jdField_b_of_type_Int = getContext().getResources().getDimensionPixelOffset(2131298807);
    this.c = getContext().getResources().getDimensionPixelOffset(2131298805);
    this.d = xod.a(paramContext, 11.0F);
    this.jdField_a_of_type_Apgg = new apgg(-2631721, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    this.jdField_b_of_type_Apgg = new apgg(0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_Vkj = new vkj(this, null);
    setOverScrollMode(2);
    setDivider(new ColorDrawable(0));
    setDividerHeight(this.d);
    setHeaderDividersEnabled(false);
    setFooterDividersEnabled(false);
    setVerticalScrollBarEnabled(false);
    setAdapter(this.jdField_a_of_type_Vkj);
    setOnTouchListener(new vkh(this, i));
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(String paramString)
  {
    List localList = this.jdField_a_of_type_Vkm.a();
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        if (TextUtils.equals((CharSequence)localList.get(i), paramString))
        {
          this.jdField_a_of_type_JavaLangString = paramString;
          wsv.a("Q.qqstory.player:VideoCoverListBar", "notify ! vid = %s , index = %d", paramString, Integer.valueOf(i));
          a(i, localList);
          return;
        }
        i += 1;
      }
    }
    a(-1, localList);
    wsv.d("Q.qqstory.player:VideoCoverListBar", "vid not found ! vid = %s", new Object[] { paramString });
  }
  
  public void a(vkm paramvkm)
  {
    this.jdField_a_of_type_Vkm = paramvkm;
  }
  
  public void b()
  {
    a(-1, this.jdField_a_of_type_Vkm.a());
  }
  
  public void setOnVideoClickListener(vki paramvki)
  {
    this.jdField_a_of_type_Vki = paramvki;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.VideoCoverListBar
 * JD-Core Version:    0.7.0.1
 */