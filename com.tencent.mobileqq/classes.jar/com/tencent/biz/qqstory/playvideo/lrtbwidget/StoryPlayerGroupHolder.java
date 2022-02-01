package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import bclx;
import bqcd;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.UIStyle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import wsl;
import xix;
import xiy;
import xjl;
import xlr;
import xlu;
import xma;
import xmd;
import xmg;
import xmu;
import xmz;
import xna;
import xnb;
import xne;
import xng;
import xnl;
import xnm;
import xos;
import xoy;
import xpc;
import xso;
import xsw;
import xts;
import xui;
import xvg;
import xvi;
import xvm;
import xvu;
import yqp;

public class StoryPlayerGroupHolder
  extends xlu
{
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public StoryPlayerGroupHolder.StoryPlayerVideoAdapter a;
  public XViewPager a;
  private xmd jdField_a_of_type_Xmd;
  private xmu jdField_a_of_type_Xmu;
  private xos jdField_a_of_type_Xos;
  private xpc jdField_a_of_type_Xpc = new xna(this);
  public int b;
  private xos b;
  private int c = 0;
  
  public StoryPlayerGroupHolder(@NonNull ViewGroup paramViewGroup, xmu paramxmu)
  {
    super(paramViewGroup);
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_Xos = new xnb(this);
    this.jdField_a_of_type_Xmu = paramxmu;
    d();
    a(new xng((ViewGroup)this.jdField_a_of_type_AndroidViewView));
    a(new xlr((ViewGroup)this.jdField_a_of_type_AndroidViewView));
    a(new xmg((ViewGroup)this.jdField_a_of_type_AndroidViewView));
    a(new xvu(this.jdField_a_of_type_AndroidViewView.findViewById(2131381178)));
    a(new xvm((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131380285)));
    a(new xts((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365397)));
    a(new xso((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363267)));
    a(new xvi((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131372937)));
    a(new xsw((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363612)));
    a(new xma((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370194)));
    a(new xui(this.jdField_a_of_type_AndroidViewView.findViewById(2131376573).findViewById(2131371293)));
    a(new xvg(this.jdField_a_of_type_AndroidViewView.findViewById(2131371634)));
  }
  
  private int b()
  {
    boolean bool = bclx.a(this.jdField_a_of_type_AndroidViewView.getContext());
    yqp.b("FredguoFix", "StoryPlayerGroupHolder: hasNavi " + bool);
    if (bool) {
      return 0;
    }
    return (int)Math.min(bclx.jdField_b_of_type_Int - bclx.jdField_a_of_type_Int / 9.0F * 16.0F, 140.0F);
  }
  
  private void d()
  {
    if (bqcd.jdField_a_of_type_Boolean)
    {
      View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131372674);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.height = (bqcd.jdField_a_of_type_Int / 2);
      localView.setLayoutParams(localLayoutParams);
    }
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561833, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup.findViewById(2131376494));
    return paramViewGroup;
  }
  
  public VideoViewVideoHolder a()
  {
    xnl localxnl = a();
    if (localxnl != null) {
      return (VideoViewVideoHolder)localxnl.a(VideoViewVideoHolder.class);
    }
    return null;
  }
  
  public xnl a()
  {
    return a(this.jdField_b_of_type_Int);
  }
  
  public xnl a(int paramInt)
  {
    xnl localxnl = null;
    if (paramInt >= 0)
    {
      xoy localxoy = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.a(paramInt);
      if (localxoy != null) {
        localxnl = (xnl)localxoy.a;
      }
      return localxnl;
    }
    yqp.d(this.jdField_a_of_type_JavaLangString, "getPageHolderOfPosition, return null ! position=%d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
  
  public void a(int paramInt, xiy paramxiy, @NonNull ArrayList<xne> paramArrayList)
  {
    boolean bool = this.jdField_a_of_type_Boolean;
    super.a(paramInt, paramxiy, paramArrayList);
    if (bool)
    {
      yqp.b(this.jdField_a_of_type_JavaLangString, "onReBind, verticalPosition: %d => %d, old-data.size=%d, new-data.size=%d, groupId=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()), Integer.valueOf(paramArrayList.size()), paramxiy.jdField_a_of_type_Xix.jdField_a_of_type_JavaLangString });
      this.c = a().mUIStyle.mPlayerRepeatMode;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter.a(paramArrayList, paramInt);
      paramxiy = a(paramxiy.jdField_a_of_type_Xix.jdField_a_of_type_JavaLangString);
      if (paramxiy == null) {
        break label619;
      }
      paramInt = 0;
      label124:
      if (paramInt >= paramArrayList.size()) {
        break label619;
      }
      if (!TextUtils.equals(((xne)paramArrayList.get(paramInt)).jdField_a_of_type_JavaLangString, paramxiy)) {
        break label304;
      }
    }
    for (;;)
    {
      paramxiy = (xma)b(xma.class);
      if ((d()) && (paramxiy != null) && (paramxiy.c()))
      {
        yqp.a(this.jdField_a_of_type_JavaLangString + "Q.qqstory.weishi", "onBind, weishi hide loading state", Integer.valueOf(paramInt));
        paramxiy.e();
        if ((paramInt > 0) && (paramInt + 1 < paramArrayList.size()))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(paramInt + 1);
          yqp.a(this.jdField_a_of_type_JavaLangString + "Q.qqstory.weishi", "onBind, change to next video", Integer.valueOf(paramInt));
          return;
          yqp.a(this.jdField_a_of_type_JavaLangString, "onBind, verticalPosition: %d, data.size=%d, groupId=%s", Integer.valueOf(paramInt), Integer.valueOf(paramArrayList.size()), paramxiy.jdField_a_of_type_Xix.jdField_a_of_type_JavaLangString);
          break;
          label304:
          paramInt += 1;
          break label124;
        }
        paramxiy = a();
        if ((paramxiy instanceof xnm))
        {
          paramxiy = (VideoViewVideoHolder)((xnm)paramxiy).b(VideoViewVideoHolder.class);
          if (paramxiy != null)
          {
            paramxiy.d();
            yqp.a(this.jdField_a_of_type_JavaLangString + "Q.qqstory.weishi", "onBind, resume play", Integer.valueOf(paramInt));
          }
        }
      }
      if (paramInt == -1)
      {
        paramInt = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c();
        yqp.a(this.jdField_a_of_type_JavaLangString, "onBind, -1 ==>> getCurrentItem=%d", Integer.valueOf(paramInt));
      }
      for (;;)
      {
        if (paramInt >= 0) {}
        for (;;)
        {
          yqp.b(this.jdField_a_of_type_JavaLangString, "onBind, verticalPosition=%d, data.size=%d, groupId=%s, current=%d, selected=%d, mPlayerRepeatMode=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramArrayList.size()), this.jdField_a_of_type_Xix.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c()), Integer.valueOf(paramInt), Integer.valueOf(this.c) });
          if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() != paramInt) {
            break label607;
          }
          paramxiy = a(paramInt);
          yqp.a(this.jdField_a_of_type_JavaLangString, "onBind, getPageHolderOfPosition = %s", paramxiy);
          if ((paramxiy != null) && (paramxiy.c())) {
            break label591;
          }
          yqp.a(this.jdField_a_of_type_JavaLangString, "onBind, fake onPageSelected, position = %d", Integer.valueOf(paramInt));
          this.jdField_a_of_type_Xpc.a(paramInt);
          paramxiy = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.a().iterator();
          while (paramxiy.hasNext()) {
            ((xpc)paramxiy.next()).a(paramInt);
          }
          break;
          paramInt = 0;
        }
        label591:
        yqp.a(this.jdField_a_of_type_JavaLangString, "onBind, setCurrentItem ignore position = %d, selectedItem=%s", Integer.valueOf(paramInt), paramxiy);
        return;
        label607:
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(paramInt);
        return;
      }
      label619:
      paramInt = -1;
    }
  }
  
  public void a(xmd paramxmd, xos paramxos)
  {
    this.jdField_a_of_type_Xmd = paramxmd;
    this.jdField_a_of_type_Xos = paramxos;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    xlr localxlr;
    if (paramBoolean1)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      if (paramBoolean2)
      {
        localxlr = (xlr)a(xlr.class);
        if (localxlr != null) {
          localxlr.jdField_a_of_type_AndroidViewView.setVisibility(0);
        }
      }
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      } while (!paramBoolean2);
      localxlr = (xlr)a(xlr.class);
    } while (localxlr == null);
    localxlr.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager = ((XViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131380863));
    int i = (int)this.jdField_a_of_type_AndroidViewView.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setPageTurningThreshold(0.3F);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setDistanceAndVelocityThreshold(i * 10, i * 80);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setEnableScrollDirection(true, true, false, false);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setEnableOverScroll(true);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setPageMargin(10);
    XViewPager localXViewPager = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager;
    StoryPlayerGroupHolder.StoryPlayerVideoAdapter localStoryPlayerVideoAdapter = new StoryPlayerGroupHolder.StoryPlayerVideoAdapter(this, a(), this);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter = localStoryPlayerVideoAdapter;
    localXViewPager.setAdapter(localStoryPlayerVideoAdapter);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter.a(this.jdField_b_of_type_Xos);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setOnPageChangeListener(this.jdField_a_of_type_Xpc);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.post(new StoryPlayerGroupHolder.1(this));
    super.b();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setOnVisibilityChangeListener(new xmz(this));
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter.a(new ArrayList(0), this.jdField_a_of_type_Int);
  }
  
  public boolean c()
  {
    return this.jdField_b_of_type_Int == this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter.getCount() - 1;
  }
  
  public boolean d()
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_Xix instanceof xjl)) {
      bool = wsl.a(QQStoryContext.a()).a(((xjl)this.jdField_a_of_type_Xix).a());
    }
    return bool;
  }
  
  public boolean e()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    Object localObject;
    if (TextUtils.equals(this.jdField_a_of_type_Xmu.a().jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Xix.jdField_a_of_type_JavaLangString))
    {
      localObject = a(this.jdField_a_of_type_Xix.jdField_a_of_type_JavaLangString);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label83;
      }
      localObject = a();
      yqp.a(this.jdField_a_of_type_JavaLangString, "no selected Vid, current = %s", localObject);
      bool1 = bool2;
      if (localObject != null)
      {
        a((xnl)localObject);
        bool1 = true;
      }
    }
    return bool1;
    label83:
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= StoryPlayerGroupHolder.StoryPlayerVideoAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter).size()) {
        break;
      }
      xnl localxnl = (xnl)StoryPlayerGroupHolder.StoryPlayerVideoAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter).valueAt(i);
      if (TextUtils.equals(localxnl.a.jdField_a_of_type_JavaLangString, (CharSequence)localObject))
      {
        a(localxnl);
        return true;
      }
      i += 1;
    }
  }
  
  public String toString()
  {
    return "VerticalPagerHolder{mPosition=" + this.jdField_a_of_type_Int + ", mData=" + this.jdField_a_of_type_JavaUtilList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder
 * JD-Core Version:    0.7.0.1
 */