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
import azkz;
import bnle;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.UIStyle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import uyz;
import vpm;
import vpn;
import vqa;
import vsg;
import vsj;
import vsp;
import vss;
import vsv;
import vtj;
import vto;
import vtp;
import vtq;
import vtt;
import vtv;
import vua;
import vub;
import vvh;
import vvn;
import vvr;
import vzd;
import vzl;
import wah;
import wax;
import wbv;
import wbx;
import wcb;
import wcj;
import wxe;

public class StoryPlayerGroupHolder
  extends vsj
{
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public StoryPlayerGroupHolder.StoryPlayerVideoAdapter a;
  public XViewPager a;
  private vss jdField_a_of_type_Vss;
  private vtj jdField_a_of_type_Vtj;
  private vvh jdField_a_of_type_Vvh;
  private vvr jdField_a_of_type_Vvr = new vtp(this);
  public int b;
  private vvh b;
  private int c = 0;
  
  public StoryPlayerGroupHolder(@NonNull ViewGroup paramViewGroup, vtj paramvtj)
  {
    super(paramViewGroup);
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_Vvh = new vtq(this);
    this.jdField_a_of_type_Vtj = paramvtj;
    d();
    a(new vtv((ViewGroup)this.jdField_a_of_type_AndroidViewView));
    a(new vsg((ViewGroup)this.jdField_a_of_type_AndroidViewView));
    a(new vsv((ViewGroup)this.jdField_a_of_type_AndroidViewView));
    a(new wcj(this.jdField_a_of_type_AndroidViewView.findViewById(2131380200)));
    a(new wcb((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131379359)));
    a(new wah((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365156)));
    a(new vzd((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363082)));
    a(new wbx((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131372343)));
    a(new vzl((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363418)));
    a(new vsp((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369763)));
    a(new wax(this.jdField_a_of_type_AndroidViewView.findViewById(2131375839).findViewById(2131370737)));
    a(new wbv(this.jdField_a_of_type_AndroidViewView.findViewById(2131371073)));
  }
  
  private int b()
  {
    boolean bool = azkz.a(this.jdField_a_of_type_AndroidViewView.getContext());
    wxe.b("FredguoFix", "StoryPlayerGroupHolder: hasNavi " + bool);
    if (bool) {
      return 0;
    }
    return (int)Math.min(azkz.jdField_b_of_type_Int - azkz.jdField_a_of_type_Int / 9.0F * 16.0F, 140.0F);
  }
  
  private void d()
  {
    if (bnle.jdField_a_of_type_Boolean)
    {
      View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131372101);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.height = (bnle.jdField_a_of_type_Int / 2);
      localView.setLayoutParams(localLayoutParams);
    }
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561598, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup.findViewById(2131375766));
    return paramViewGroup;
  }
  
  public VideoViewVideoHolder a()
  {
    vua localvua = a();
    if (localvua != null) {
      return (VideoViewVideoHolder)localvua.a(VideoViewVideoHolder.class);
    }
    return null;
  }
  
  public vua a()
  {
    return a(this.jdField_b_of_type_Int);
  }
  
  public vua a(int paramInt)
  {
    vua localvua = null;
    if (paramInt >= 0)
    {
      vvn localvvn = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.a(paramInt);
      if (localvvn != null) {
        localvua = (vua)localvvn.a;
      }
      return localvua;
    }
    wxe.d(this.jdField_a_of_type_JavaLangString, "getPageHolderOfPosition, return null ! position=%d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
  
  public void a(int paramInt, vpn paramvpn, @NonNull ArrayList<vtt> paramArrayList)
  {
    boolean bool = this.jdField_a_of_type_Boolean;
    super.a(paramInt, paramvpn, paramArrayList);
    if (bool)
    {
      wxe.b(this.jdField_a_of_type_JavaLangString, "onReBind, verticalPosition: %d => %d, old-data.size=%d, new-data.size=%d, groupId=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()), Integer.valueOf(paramArrayList.size()), paramvpn.jdField_a_of_type_Vpm.jdField_a_of_type_JavaLangString });
      this.c = a().mUIStyle.mPlayerRepeatMode;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter.a(paramArrayList, paramInt);
      paramvpn = a(paramvpn.jdField_a_of_type_Vpm.jdField_a_of_type_JavaLangString);
      if (paramvpn == null) {
        break label619;
      }
      paramInt = 0;
      label124:
      if (paramInt >= paramArrayList.size()) {
        break label619;
      }
      if (!TextUtils.equals(((vtt)paramArrayList.get(paramInt)).jdField_a_of_type_JavaLangString, paramvpn)) {
        break label304;
      }
    }
    for (;;)
    {
      paramvpn = (vsp)b(vsp.class);
      if ((d()) && (paramvpn != null) && (paramvpn.c()))
      {
        wxe.a(this.jdField_a_of_type_JavaLangString + "Q.qqstory.weishi", "onBind, weishi hide loading state", Integer.valueOf(paramInt));
        paramvpn.e();
        if ((paramInt > 0) && (paramInt + 1 < paramArrayList.size()))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(paramInt + 1);
          wxe.a(this.jdField_a_of_type_JavaLangString + "Q.qqstory.weishi", "onBind, change to next video", Integer.valueOf(paramInt));
          return;
          wxe.a(this.jdField_a_of_type_JavaLangString, "onBind, verticalPosition: %d, data.size=%d, groupId=%s", Integer.valueOf(paramInt), Integer.valueOf(paramArrayList.size()), paramvpn.jdField_a_of_type_Vpm.jdField_a_of_type_JavaLangString);
          break;
          label304:
          paramInt += 1;
          break label124;
        }
        paramvpn = a();
        if ((paramvpn instanceof vub))
        {
          paramvpn = (VideoViewVideoHolder)((vub)paramvpn).b(VideoViewVideoHolder.class);
          if (paramvpn != null)
          {
            paramvpn.d();
            wxe.a(this.jdField_a_of_type_JavaLangString + "Q.qqstory.weishi", "onBind, resume play", Integer.valueOf(paramInt));
          }
        }
      }
      if (paramInt == -1)
      {
        paramInt = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c();
        wxe.a(this.jdField_a_of_type_JavaLangString, "onBind, -1 ==>> getCurrentItem=%d", Integer.valueOf(paramInt));
      }
      for (;;)
      {
        if (paramInt >= 0) {}
        for (;;)
        {
          wxe.b(this.jdField_a_of_type_JavaLangString, "onBind, verticalPosition=%d, data.size=%d, groupId=%s, current=%d, selected=%d, mPlayerRepeatMode=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramArrayList.size()), this.jdField_a_of_type_Vpm.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c()), Integer.valueOf(paramInt), Integer.valueOf(this.c) });
          if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() != paramInt) {
            break label607;
          }
          paramvpn = a(paramInt);
          wxe.a(this.jdField_a_of_type_JavaLangString, "onBind, getPageHolderOfPosition = %s", paramvpn);
          if ((paramvpn != null) && (paramvpn.c())) {
            break label591;
          }
          wxe.a(this.jdField_a_of_type_JavaLangString, "onBind, fake onPageSelected, position = %d", Integer.valueOf(paramInt));
          this.jdField_a_of_type_Vvr.a(paramInt);
          paramvpn = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.a().iterator();
          while (paramvpn.hasNext()) {
            ((vvr)paramvpn.next()).a(paramInt);
          }
          break;
          paramInt = 0;
        }
        label591:
        wxe.a(this.jdField_a_of_type_JavaLangString, "onBind, setCurrentItem ignore position = %d, selectedItem=%s", Integer.valueOf(paramInt), paramvpn);
        return;
        label607:
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(paramInt);
        return;
      }
      label619:
      paramInt = -1;
    }
  }
  
  public void a(vss paramvss, vvh paramvvh)
  {
    this.jdField_a_of_type_Vss = paramvss;
    this.jdField_a_of_type_Vvh = paramvvh;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    vsg localvsg;
    if (paramBoolean1)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      if (paramBoolean2)
      {
        localvsg = (vsg)a(vsg.class);
        if (localvsg != null) {
          localvsg.jdField_a_of_type_AndroidViewView.setVisibility(0);
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
      localvsg = (vsg)a(vsg.class);
    } while (localvsg == null);
    localvsg.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager = ((XViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131379906));
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
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter.a(this.jdField_b_of_type_Vvh);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setOnPageChangeListener(this.jdField_a_of_type_Vvr);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.post(new StoryPlayerGroupHolder.1(this));
    super.b();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setOnVisibilityChangeListener(new vto(this));
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
    if ((this.jdField_a_of_type_Vpm instanceof vqa)) {
      bool = uyz.a(QQStoryContext.a()).a(((vqa)this.jdField_a_of_type_Vpm).a());
    }
    return bool;
  }
  
  public boolean e()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    Object localObject;
    if (TextUtils.equals(this.jdField_a_of_type_Vtj.a().jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Vpm.jdField_a_of_type_JavaLangString))
    {
      localObject = a(this.jdField_a_of_type_Vpm.jdField_a_of_type_JavaLangString);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label83;
      }
      localObject = a();
      wxe.a(this.jdField_a_of_type_JavaLangString, "no selected Vid, current = %s", localObject);
      bool1 = bool2;
      if (localObject != null)
      {
        a((vua)localObject);
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
      vua localvua = (vua)StoryPlayerGroupHolder.StoryPlayerVideoAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter).valueAt(i);
      if (TextUtils.equals(localvua.a.jdField_a_of_type_JavaLangString, (CharSequence)localObject))
      {
        a(localvua);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder
 * JD-Core Version:    0.7.0.1
 */