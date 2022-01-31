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
import awmc;
import bjeh;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.UIStyle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import stf;
import tjs;
import tjt;
import tkg;
import tmm;
import tmp;
import tmv;
import tmy;
import tnb;
import tnp;
import tnu;
import tnv;
import tnw;
import tnz;
import tob;
import tog;
import toh;
import tpn;
import tpt;
import tpx;
import ttj;
import ttr;
import tun;
import tvd;
import twb;
import twd;
import twh;
import twp;
import urk;

public class StoryPlayerGroupHolder
  extends tmp
{
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public StoryPlayerGroupHolder.StoryPlayerVideoAdapter a;
  public XViewPager a;
  private tmy jdField_a_of_type_Tmy;
  private tnp jdField_a_of_type_Tnp;
  private tpn jdField_a_of_type_Tpn;
  private tpx jdField_a_of_type_Tpx = new tnv(this);
  public int b;
  private tpn b;
  private int c = 0;
  
  public StoryPlayerGroupHolder(@NonNull ViewGroup paramViewGroup, tnp paramtnp)
  {
    super(paramViewGroup);
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_Tpn = new tnw(this);
    this.jdField_a_of_type_Tnp = paramtnp;
    d();
    a(new tob((ViewGroup)this.jdField_a_of_type_AndroidViewView));
    a(new tmm((ViewGroup)this.jdField_a_of_type_AndroidViewView));
    a(new tnb((ViewGroup)this.jdField_a_of_type_AndroidViewView));
    a(new twp(this.jdField_a_of_type_AndroidViewView.findViewById(2131313586)));
    a(new twh((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131312854)));
    a(new tun((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299502)));
    a(new ttj((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131297506)));
    a(new twd((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131306309)));
    a(new ttr((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131297834)));
    a(new tmv((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131303808)));
    a(new tvd(this.jdField_a_of_type_AndroidViewView.findViewById(2131309556).findViewById(2131304756)));
    a(new twb(this.jdField_a_of_type_AndroidViewView.findViewById(2131305076)));
  }
  
  private int b()
  {
    boolean bool = awmc.a(this.jdField_a_of_type_AndroidViewView.getContext());
    urk.b("FredguoFix", "StoryPlayerGroupHolder: hasNavi " + bool);
    if (bool) {
      return 0;
    }
    return (int)Math.min(awmc.jdField_b_of_type_Int - awmc.jdField_a_of_type_Int / 9.0F * 16.0F, 140.0F);
  }
  
  private void d()
  {
    if (bjeh.jdField_a_of_type_Boolean)
    {
      View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131306066);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.height = (bjeh.jdField_a_of_type_Int / 2);
      localView.setLayoutParams(localLayoutParams);
    }
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131495800, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup.findViewById(2131309483));
    return paramViewGroup;
  }
  
  public VideoViewVideoHolder a()
  {
    tog localtog = a();
    if (localtog != null) {
      return (VideoViewVideoHolder)localtog.a(VideoViewVideoHolder.class);
    }
    return null;
  }
  
  public tog a()
  {
    return a(this.jdField_b_of_type_Int);
  }
  
  public tog a(int paramInt)
  {
    tog localtog = null;
    if (paramInt >= 0)
    {
      tpt localtpt = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.a(paramInt);
      if (localtpt != null) {
        localtog = (tog)localtpt.a;
      }
      return localtog;
    }
    urk.d(this.jdField_a_of_type_JavaLangString, "getPageHolderOfPosition, return null ! position=%d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
  
  public void a(int paramInt, tjt paramtjt, @NonNull ArrayList<tnz> paramArrayList)
  {
    boolean bool = this.jdField_a_of_type_Boolean;
    super.a(paramInt, paramtjt, paramArrayList);
    if (bool)
    {
      urk.b(this.jdField_a_of_type_JavaLangString, "onReBind, verticalPosition: %d => %d, old-data.size=%d, new-data.size=%d, groupId=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()), Integer.valueOf(paramArrayList.size()), paramtjt.jdField_a_of_type_Tjs.jdField_a_of_type_JavaLangString });
      this.c = a().mUIStyle.mPlayerRepeatMode;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter.a(paramArrayList, paramInt);
      paramtjt = a(paramtjt.jdField_a_of_type_Tjs.jdField_a_of_type_JavaLangString);
      if (paramtjt == null) {
        break label619;
      }
      paramInt = 0;
      label124:
      if (paramInt >= paramArrayList.size()) {
        break label619;
      }
      if (!TextUtils.equals(((tnz)paramArrayList.get(paramInt)).jdField_a_of_type_JavaLangString, paramtjt)) {
        break label304;
      }
    }
    for (;;)
    {
      paramtjt = (tmv)b(tmv.class);
      if ((d()) && (paramtjt != null) && (paramtjt.c()))
      {
        urk.a(this.jdField_a_of_type_JavaLangString + "Q.qqstory.weishi", "onBind, weishi hide loading state", Integer.valueOf(paramInt));
        paramtjt.e();
        if ((paramInt > 0) && (paramInt + 1 < paramArrayList.size()))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(paramInt + 1);
          urk.a(this.jdField_a_of_type_JavaLangString + "Q.qqstory.weishi", "onBind, change to next video", Integer.valueOf(paramInt));
          return;
          urk.a(this.jdField_a_of_type_JavaLangString, "onBind, verticalPosition: %d, data.size=%d, groupId=%s", Integer.valueOf(paramInt), Integer.valueOf(paramArrayList.size()), paramtjt.jdField_a_of_type_Tjs.jdField_a_of_type_JavaLangString);
          break;
          label304:
          paramInt += 1;
          break label124;
        }
        paramtjt = a();
        if ((paramtjt instanceof toh))
        {
          paramtjt = (VideoViewVideoHolder)((toh)paramtjt).b(VideoViewVideoHolder.class);
          if (paramtjt != null)
          {
            paramtjt.d();
            urk.a(this.jdField_a_of_type_JavaLangString + "Q.qqstory.weishi", "onBind, resume play", Integer.valueOf(paramInt));
          }
        }
      }
      if (paramInt == -1)
      {
        paramInt = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c();
        urk.a(this.jdField_a_of_type_JavaLangString, "onBind, -1 ==>> getCurrentItem=%d", Integer.valueOf(paramInt));
      }
      for (;;)
      {
        if (paramInt >= 0) {}
        for (;;)
        {
          urk.b(this.jdField_a_of_type_JavaLangString, "onBind, verticalPosition=%d, data.size=%d, groupId=%s, current=%d, selected=%d, mPlayerRepeatMode=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramArrayList.size()), this.jdField_a_of_type_Tjs.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c()), Integer.valueOf(paramInt), Integer.valueOf(this.c) });
          if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() != paramInt) {
            break label607;
          }
          paramtjt = a(paramInt);
          urk.a(this.jdField_a_of_type_JavaLangString, "onBind, getPageHolderOfPosition = %s", paramtjt);
          if ((paramtjt != null) && (paramtjt.c())) {
            break label591;
          }
          urk.a(this.jdField_a_of_type_JavaLangString, "onBind, fake onPageSelected, position = %d", Integer.valueOf(paramInt));
          this.jdField_a_of_type_Tpx.a(paramInt);
          paramtjt = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.a().iterator();
          while (paramtjt.hasNext()) {
            ((tpx)paramtjt.next()).a(paramInt);
          }
          break;
          paramInt = 0;
        }
        label591:
        urk.a(this.jdField_a_of_type_JavaLangString, "onBind, setCurrentItem ignore position = %d, selectedItem=%s", Integer.valueOf(paramInt), paramtjt);
        return;
        label607:
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(paramInt);
        return;
      }
      label619:
      paramInt = -1;
    }
  }
  
  public void a(tmy paramtmy, tpn paramtpn)
  {
    this.jdField_a_of_type_Tmy = paramtmy;
    this.jdField_a_of_type_Tpn = paramtpn;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    tmm localtmm;
    if (paramBoolean1)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      if (paramBoolean2)
      {
        localtmm = (tmm)a(tmm.class);
        if (localtmm != null) {
          localtmm.jdField_a_of_type_AndroidViewView.setVisibility(0);
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
      localtmm = (tmm)a(tmm.class);
    } while (localtmm == null);
    localtmm.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager = ((XViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131313312));
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
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter.a(this.jdField_b_of_type_Tpn);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setOnPageChangeListener(this.jdField_a_of_type_Tpx);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.post(new StoryPlayerGroupHolder.1(this));
    super.b();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setOnVisibilityChangeListener(new tnu(this));
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
    if ((this.jdField_a_of_type_Tjs instanceof tkg)) {
      bool = stf.a(QQStoryContext.a()).a(((tkg)this.jdField_a_of_type_Tjs).a());
    }
    return bool;
  }
  
  public boolean e()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    Object localObject;
    if (TextUtils.equals(this.jdField_a_of_type_Tnp.a().jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Tjs.jdField_a_of_type_JavaLangString))
    {
      localObject = a(this.jdField_a_of_type_Tjs.jdField_a_of_type_JavaLangString);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label83;
      }
      localObject = a();
      urk.a(this.jdField_a_of_type_JavaLangString, "no selected Vid, current = %s", localObject);
      bool1 = bool2;
      if (localObject != null)
      {
        a((tog)localObject);
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
      tog localtog = (tog)StoryPlayerGroupHolder.StoryPlayerVideoAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter).valueAt(i);
      if (TextUtils.equals(localtog.a.jdField_a_of_type_JavaLangString, (CharSequence)localObject))
      {
        a(localtog);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder
 * JD-Core Version:    0.7.0.1
 */