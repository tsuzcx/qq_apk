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
import axli;
import bkur;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.UIStyle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tgb;
import two;
import twp;
import txc;
import tzi;
import tzl;
import tzr;
import tzu;
import tzx;
import ual;
import uaq;
import uar;
import uas;
import uav;
import uax;
import ubc;
import ubd;
import ucj;
import ucp;
import uct;
import ugf;
import ugn;
import uhj;
import uhz;
import uix;
import uiz;
import ujd;
import ujl;
import veg;

public class StoryPlayerGroupHolder
  extends tzl
{
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public StoryPlayerGroupHolder.StoryPlayerVideoAdapter a;
  public XViewPager a;
  private tzu jdField_a_of_type_Tzu;
  private ual jdField_a_of_type_Ual;
  private ucj jdField_a_of_type_Ucj;
  private uct jdField_a_of_type_Uct = new uar(this);
  public int b;
  private ucj b;
  private int c = 0;
  
  public StoryPlayerGroupHolder(@NonNull ViewGroup paramViewGroup, ual paramual)
  {
    super(paramViewGroup);
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_Ucj = new uas(this);
    this.jdField_a_of_type_Ual = paramual;
    d();
    a(new uax((ViewGroup)this.jdField_a_of_type_AndroidViewView));
    a(new tzi((ViewGroup)this.jdField_a_of_type_AndroidViewView));
    a(new tzx((ViewGroup)this.jdField_a_of_type_AndroidViewView));
    a(new ujl(this.jdField_a_of_type_AndroidViewView.findViewById(2131379421)));
    a(new ujd((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131378678)));
    a(new uhj((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365070)));
    a(new ugf((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363047)));
    a(new uiz((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131372006)));
    a(new ugn((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363380)));
    a(new tzr((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369483)));
    a(new uhz(this.jdField_a_of_type_AndroidViewView.findViewById(2131375304).findViewById(2131370413)));
    a(new uix(this.jdField_a_of_type_AndroidViewView.findViewById(2131370743)));
  }
  
  private int b()
  {
    boolean bool = axli.a(this.jdField_a_of_type_AndroidViewView.getContext());
    veg.b("FredguoFix", "StoryPlayerGroupHolder: hasNavi " + bool);
    if (bool) {
      return 0;
    }
    return (int)Math.min(axli.jdField_b_of_type_Int - axli.jdField_a_of_type_Int / 9.0F * 16.0F, 140.0F);
  }
  
  private void d()
  {
    if (bkur.jdField_a_of_type_Boolean)
    {
      View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131371763);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.height = (bkur.jdField_a_of_type_Int / 2);
      localView.setLayoutParams(localLayoutParams);
    }
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561391, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup.findViewById(2131375231));
    return paramViewGroup;
  }
  
  public VideoViewVideoHolder a()
  {
    ubc localubc = a();
    if (localubc != null) {
      return (VideoViewVideoHolder)localubc.a(VideoViewVideoHolder.class);
    }
    return null;
  }
  
  public ubc a()
  {
    return a(this.jdField_b_of_type_Int);
  }
  
  public ubc a(int paramInt)
  {
    ubc localubc = null;
    if (paramInt >= 0)
    {
      ucp localucp = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.a(paramInt);
      if (localucp != null) {
        localubc = (ubc)localucp.a;
      }
      return localubc;
    }
    veg.d(this.jdField_a_of_type_JavaLangString, "getPageHolderOfPosition, return null ! position=%d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
  
  public void a(int paramInt, twp paramtwp, @NonNull ArrayList<uav> paramArrayList)
  {
    boolean bool = this.jdField_a_of_type_Boolean;
    super.a(paramInt, paramtwp, paramArrayList);
    if (bool)
    {
      veg.b(this.jdField_a_of_type_JavaLangString, "onReBind, verticalPosition: %d => %d, old-data.size=%d, new-data.size=%d, groupId=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()), Integer.valueOf(paramArrayList.size()), paramtwp.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString });
      this.c = a().mUIStyle.mPlayerRepeatMode;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter.a(paramArrayList, paramInt);
      paramtwp = a(paramtwp.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString);
      if (paramtwp == null) {
        break label619;
      }
      paramInt = 0;
      label124:
      if (paramInt >= paramArrayList.size()) {
        break label619;
      }
      if (!TextUtils.equals(((uav)paramArrayList.get(paramInt)).jdField_a_of_type_JavaLangString, paramtwp)) {
        break label304;
      }
    }
    for (;;)
    {
      paramtwp = (tzr)b(tzr.class);
      if ((d()) && (paramtwp != null) && (paramtwp.c()))
      {
        veg.a(this.jdField_a_of_type_JavaLangString + "Q.qqstory.weishi", "onBind, weishi hide loading state", Integer.valueOf(paramInt));
        paramtwp.e();
        if ((paramInt > 0) && (paramInt + 1 < paramArrayList.size()))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(paramInt + 1);
          veg.a(this.jdField_a_of_type_JavaLangString + "Q.qqstory.weishi", "onBind, change to next video", Integer.valueOf(paramInt));
          return;
          veg.a(this.jdField_a_of_type_JavaLangString, "onBind, verticalPosition: %d, data.size=%d, groupId=%s", Integer.valueOf(paramInt), Integer.valueOf(paramArrayList.size()), paramtwp.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString);
          break;
          label304:
          paramInt += 1;
          break label124;
        }
        paramtwp = a();
        if ((paramtwp instanceof ubd))
        {
          paramtwp = (VideoViewVideoHolder)((ubd)paramtwp).b(VideoViewVideoHolder.class);
          if (paramtwp != null)
          {
            paramtwp.d();
            veg.a(this.jdField_a_of_type_JavaLangString + "Q.qqstory.weishi", "onBind, resume play", Integer.valueOf(paramInt));
          }
        }
      }
      if (paramInt == -1)
      {
        paramInt = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c();
        veg.a(this.jdField_a_of_type_JavaLangString, "onBind, -1 ==>> getCurrentItem=%d", Integer.valueOf(paramInt));
      }
      for (;;)
      {
        if (paramInt >= 0) {}
        for (;;)
        {
          veg.b(this.jdField_a_of_type_JavaLangString, "onBind, verticalPosition=%d, data.size=%d, groupId=%s, current=%d, selected=%d, mPlayerRepeatMode=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramArrayList.size()), this.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c()), Integer.valueOf(paramInt), Integer.valueOf(this.c) });
          if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() != paramInt) {
            break label607;
          }
          paramtwp = a(paramInt);
          veg.a(this.jdField_a_of_type_JavaLangString, "onBind, getPageHolderOfPosition = %s", paramtwp);
          if ((paramtwp != null) && (paramtwp.c())) {
            break label591;
          }
          veg.a(this.jdField_a_of_type_JavaLangString, "onBind, fake onPageSelected, position = %d", Integer.valueOf(paramInt));
          this.jdField_a_of_type_Uct.a(paramInt);
          paramtwp = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.a().iterator();
          while (paramtwp.hasNext()) {
            ((uct)paramtwp.next()).a(paramInt);
          }
          break;
          paramInt = 0;
        }
        label591:
        veg.a(this.jdField_a_of_type_JavaLangString, "onBind, setCurrentItem ignore position = %d, selectedItem=%s", Integer.valueOf(paramInt), paramtwp);
        return;
        label607:
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(paramInt);
        return;
      }
      label619:
      paramInt = -1;
    }
  }
  
  public void a(tzu paramtzu, ucj paramucj)
  {
    this.jdField_a_of_type_Tzu = paramtzu;
    this.jdField_a_of_type_Ucj = paramucj;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    tzi localtzi;
    if (paramBoolean1)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      if (paramBoolean2)
      {
        localtzi = (tzi)a(tzi.class);
        if (localtzi != null) {
          localtzi.jdField_a_of_type_AndroidViewView.setVisibility(0);
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
      localtzi = (tzi)a(tzi.class);
    } while (localtzi == null);
    localtzi.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager = ((XViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131379147));
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
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter.a(this.jdField_b_of_type_Ucj);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setOnPageChangeListener(this.jdField_a_of_type_Uct);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.post(new StoryPlayerGroupHolder.1(this));
    super.b();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setOnVisibilityChangeListener(new uaq(this));
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
    if ((this.jdField_a_of_type_Two instanceof txc)) {
      bool = tgb.a(QQStoryContext.a()).a(((txc)this.jdField_a_of_type_Two).a());
    }
    return bool;
  }
  
  public boolean e()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    Object localObject;
    if (TextUtils.equals(this.jdField_a_of_type_Ual.a().jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString))
    {
      localObject = a(this.jdField_a_of_type_Two.jdField_a_of_type_JavaLangString);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label83;
      }
      localObject = a();
      veg.a(this.jdField_a_of_type_JavaLangString, "no selected Vid, current = %s", localObject);
      bool1 = bool2;
      if (localObject != null)
      {
        a((ubc)localObject);
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
      ubc localubc = (ubc)StoryPlayerGroupHolder.StoryPlayerVideoAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter).valueAt(i);
      if (TextUtils.equals(localubc.a.jdField_a_of_type_JavaLangString, (CharSequence)localObject))
      {
        a(localubc);
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