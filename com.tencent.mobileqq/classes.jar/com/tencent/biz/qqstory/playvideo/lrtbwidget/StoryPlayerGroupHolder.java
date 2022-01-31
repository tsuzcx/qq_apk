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
import axlk;
import bkvi;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.UIStyle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tfy;
import twl;
import twm;
import twz;
import tzf;
import tzi;
import tzo;
import tzr;
import tzu;
import uai;
import uan;
import uao;
import uap;
import uas;
import uau;
import uaz;
import uba;
import ucg;
import ucm;
import ucq;
import ugc;
import ugk;
import uhg;
import uhw;
import uiu;
import uiw;
import uja;
import uji;
import ved;

public class StoryPlayerGroupHolder
  extends tzi
{
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public StoryPlayerGroupHolder.StoryPlayerVideoAdapter a;
  public XViewPager a;
  private tzr jdField_a_of_type_Tzr;
  private uai jdField_a_of_type_Uai;
  private ucg jdField_a_of_type_Ucg;
  private ucq jdField_a_of_type_Ucq = new uao(this);
  public int b;
  private ucg b;
  private int c = 0;
  
  public StoryPlayerGroupHolder(@NonNull ViewGroup paramViewGroup, uai paramuai)
  {
    super(paramViewGroup);
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_Ucg = new uap(this);
    this.jdField_a_of_type_Uai = paramuai;
    d();
    a(new uau((ViewGroup)this.jdField_a_of_type_AndroidViewView));
    a(new tzf((ViewGroup)this.jdField_a_of_type_AndroidViewView));
    a(new tzu((ViewGroup)this.jdField_a_of_type_AndroidViewView));
    a(new uji(this.jdField_a_of_type_AndroidViewView.findViewById(2131379426)));
    a(new uja((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131378683)));
    a(new uhg((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365069)));
    a(new ugc((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363046)));
    a(new uiw((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131372006)));
    a(new ugk((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363379)));
    a(new tzo((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369482)));
    a(new uhw(this.jdField_a_of_type_AndroidViewView.findViewById(2131375306).findViewById(2131370412)));
    a(new uiu(this.jdField_a_of_type_AndroidViewView.findViewById(2131370743)));
  }
  
  private int b()
  {
    boolean bool = axlk.a(this.jdField_a_of_type_AndroidViewView.getContext());
    ved.b("FredguoFix", "StoryPlayerGroupHolder: hasNavi " + bool);
    if (bool) {
      return 0;
    }
    return (int)Math.min(axlk.jdField_b_of_type_Int - axlk.jdField_a_of_type_Int / 9.0F * 16.0F, 140.0F);
  }
  
  private void d()
  {
    if (bkvi.jdField_a_of_type_Boolean)
    {
      View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131371763);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.height = (bkvi.jdField_a_of_type_Int / 2);
      localView.setLayoutParams(localLayoutParams);
    }
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561390, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup.findViewById(2131375233));
    return paramViewGroup;
  }
  
  public VideoViewVideoHolder a()
  {
    uaz localuaz = a();
    if (localuaz != null) {
      return (VideoViewVideoHolder)localuaz.a(VideoViewVideoHolder.class);
    }
    return null;
  }
  
  public uaz a()
  {
    return a(this.jdField_b_of_type_Int);
  }
  
  public uaz a(int paramInt)
  {
    uaz localuaz = null;
    if (paramInt >= 0)
    {
      ucm localucm = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.a(paramInt);
      if (localucm != null) {
        localuaz = (uaz)localucm.a;
      }
      return localuaz;
    }
    ved.d(this.jdField_a_of_type_JavaLangString, "getPageHolderOfPosition, return null ! position=%d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
  
  public void a(int paramInt, twm paramtwm, @NonNull ArrayList<uas> paramArrayList)
  {
    boolean bool = this.jdField_a_of_type_Boolean;
    super.a(paramInt, paramtwm, paramArrayList);
    if (bool)
    {
      ved.b(this.jdField_a_of_type_JavaLangString, "onReBind, verticalPosition: %d => %d, old-data.size=%d, new-data.size=%d, groupId=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()), Integer.valueOf(paramArrayList.size()), paramtwm.jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString });
      this.c = a().mUIStyle.mPlayerRepeatMode;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter.a(paramArrayList, paramInt);
      paramtwm = a(paramtwm.jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString);
      if (paramtwm == null) {
        break label619;
      }
      paramInt = 0;
      label124:
      if (paramInt >= paramArrayList.size()) {
        break label619;
      }
      if (!TextUtils.equals(((uas)paramArrayList.get(paramInt)).jdField_a_of_type_JavaLangString, paramtwm)) {
        break label304;
      }
    }
    for (;;)
    {
      paramtwm = (tzo)b(tzo.class);
      if ((d()) && (paramtwm != null) && (paramtwm.c()))
      {
        ved.a(this.jdField_a_of_type_JavaLangString + "Q.qqstory.weishi", "onBind, weishi hide loading state", Integer.valueOf(paramInt));
        paramtwm.e();
        if ((paramInt > 0) && (paramInt + 1 < paramArrayList.size()))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(paramInt + 1);
          ved.a(this.jdField_a_of_type_JavaLangString + "Q.qqstory.weishi", "onBind, change to next video", Integer.valueOf(paramInt));
          return;
          ved.a(this.jdField_a_of_type_JavaLangString, "onBind, verticalPosition: %d, data.size=%d, groupId=%s", Integer.valueOf(paramInt), Integer.valueOf(paramArrayList.size()), paramtwm.jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString);
          break;
          label304:
          paramInt += 1;
          break label124;
        }
        paramtwm = a();
        if ((paramtwm instanceof uba))
        {
          paramtwm = (VideoViewVideoHolder)((uba)paramtwm).b(VideoViewVideoHolder.class);
          if (paramtwm != null)
          {
            paramtwm.d();
            ved.a(this.jdField_a_of_type_JavaLangString + "Q.qqstory.weishi", "onBind, resume play", Integer.valueOf(paramInt));
          }
        }
      }
      if (paramInt == -1)
      {
        paramInt = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c();
        ved.a(this.jdField_a_of_type_JavaLangString, "onBind, -1 ==>> getCurrentItem=%d", Integer.valueOf(paramInt));
      }
      for (;;)
      {
        if (paramInt >= 0) {}
        for (;;)
        {
          ved.b(this.jdField_a_of_type_JavaLangString, "onBind, verticalPosition=%d, data.size=%d, groupId=%s, current=%d, selected=%d, mPlayerRepeatMode=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramArrayList.size()), this.jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c()), Integer.valueOf(paramInt), Integer.valueOf(this.c) });
          if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() != paramInt) {
            break label607;
          }
          paramtwm = a(paramInt);
          ved.a(this.jdField_a_of_type_JavaLangString, "onBind, getPageHolderOfPosition = %s", paramtwm);
          if ((paramtwm != null) && (paramtwm.c())) {
            break label591;
          }
          ved.a(this.jdField_a_of_type_JavaLangString, "onBind, fake onPageSelected, position = %d", Integer.valueOf(paramInt));
          this.jdField_a_of_type_Ucq.a(paramInt);
          paramtwm = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.a().iterator();
          while (paramtwm.hasNext()) {
            ((ucq)paramtwm.next()).a(paramInt);
          }
          break;
          paramInt = 0;
        }
        label591:
        ved.a(this.jdField_a_of_type_JavaLangString, "onBind, setCurrentItem ignore position = %d, selectedItem=%s", Integer.valueOf(paramInt), paramtwm);
        return;
        label607:
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(paramInt);
        return;
      }
      label619:
      paramInt = -1;
    }
  }
  
  public void a(tzr paramtzr, ucg paramucg)
  {
    this.jdField_a_of_type_Tzr = paramtzr;
    this.jdField_a_of_type_Ucg = paramucg;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    tzf localtzf;
    if (paramBoolean1)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      if (paramBoolean2)
      {
        localtzf = (tzf)a(tzf.class);
        if (localtzf != null) {
          localtzf.jdField_a_of_type_AndroidViewView.setVisibility(0);
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
      localtzf = (tzf)a(tzf.class);
    } while (localtzf == null);
    localtzf.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager = ((XViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131379152));
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
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter.a(this.jdField_b_of_type_Ucg);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setOnPageChangeListener(this.jdField_a_of_type_Ucq);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.post(new StoryPlayerGroupHolder.1(this));
    super.b();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setOnVisibilityChangeListener(new uan(this));
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
    if ((this.jdField_a_of_type_Twl instanceof twz)) {
      bool = tfy.a(QQStoryContext.a()).a(((twz)this.jdField_a_of_type_Twl).a());
    }
    return bool;
  }
  
  public boolean e()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    Object localObject;
    if (TextUtils.equals(this.jdField_a_of_type_Uai.a().jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString))
    {
      localObject = a(this.jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label83;
      }
      localObject = a();
      ved.a(this.jdField_a_of_type_JavaLangString, "no selected Vid, current = %s", localObject);
      bool1 = bool2;
      if (localObject != null)
      {
        a((uaz)localObject);
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
      uaz localuaz = (uaz)StoryPlayerGroupHolder.StoryPlayerVideoAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter).valueAt(i);
      if (TextUtils.equals(localuaz.a.jdField_a_of_type_JavaLangString, (CharSequence)localObject))
      {
        a(localuaz);
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