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
import bdep;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.UIStyle;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import wwg;
import xms;
import xmt;
import xng;
import xpm;
import xpp;
import xpv;
import xpy;
import xqb;
import xqp;
import xqu;
import xqv;
import xqw;
import xqz;
import xrb;
import xrg;
import xrh;
import xsn;
import xst;
import xsx;
import xwj;
import xwr;
import xxn;
import xyd;
import xzb;
import xzd;
import xzh;
import xzp;
import yuk;

public class StoryPlayerGroupHolder
  extends xpp
{
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public StoryPlayerGroupHolder.StoryPlayerVideoAdapter a;
  public XViewPager a;
  private xpy jdField_a_of_type_Xpy;
  private xqp jdField_a_of_type_Xqp;
  private xsn jdField_a_of_type_Xsn;
  private xsx jdField_a_of_type_Xsx = new xqv(this);
  public int b;
  private xsn b;
  private int c = 0;
  
  public StoryPlayerGroupHolder(@NonNull ViewGroup paramViewGroup, xqp paramxqp)
  {
    super(paramViewGroup);
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_Xsn = new xqw(this);
    this.jdField_a_of_type_Xqp = paramxqp;
    d();
    a(new xrb((ViewGroup)this.jdField_a_of_type_AndroidViewView));
    a(new xpm((ViewGroup)this.jdField_a_of_type_AndroidViewView));
    a(new xqb((ViewGroup)this.jdField_a_of_type_AndroidViewView));
    a(new xzp(this.jdField_a_of_type_AndroidViewView.findViewById(2131381351)));
    a(new xzh((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131380471)));
    a(new xxn((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365441)));
    a(new xwj((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363291)));
    a(new xzd((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373050)));
    a(new xwr((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363636)));
    a(new xpv((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370295)));
    a(new xyd(this.jdField_a_of_type_AndroidViewView.findViewById(2131376705).findViewById(2131371400)));
    a(new xzb(this.jdField_a_of_type_AndroidViewView.findViewById(2131371742)));
  }
  
  private int b()
  {
    boolean bool = bdep.a(this.jdField_a_of_type_AndroidViewView.getContext());
    yuk.b("FredguoFix", "StoryPlayerGroupHolder: hasNavi " + bool);
    if (bool) {
      return 0;
    }
    return (int)Math.min(bdep.jdField_b_of_type_Int - bdep.jdField_a_of_type_Int / 9.0F * 16.0F, 140.0F);
  }
  
  private void d()
  {
    if (LiuHaiUtils.jdField_a_of_type_Boolean)
    {
      View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131372786);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.height = (LiuHaiUtils.jdField_a_of_type_Int / 2);
      localView.setLayoutParams(localLayoutParams);
    }
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561874, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup.findViewById(2131376626));
    return paramViewGroup;
  }
  
  public VideoViewVideoHolder a()
  {
    xrg localxrg = a();
    if (localxrg != null) {
      return (VideoViewVideoHolder)localxrg.a(VideoViewVideoHolder.class);
    }
    return null;
  }
  
  public xrg a()
  {
    return a(this.jdField_b_of_type_Int);
  }
  
  public xrg a(int paramInt)
  {
    xrg localxrg = null;
    if (paramInt >= 0)
    {
      xst localxst = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.a(paramInt);
      if (localxst != null) {
        localxrg = (xrg)localxst.a;
      }
      return localxrg;
    }
    yuk.d(this.jdField_a_of_type_JavaLangString, "getPageHolderOfPosition, return null ! position=%d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
  
  public void a(int paramInt, xmt paramxmt, @NonNull ArrayList<xqz> paramArrayList)
  {
    boolean bool = this.jdField_a_of_type_Boolean;
    super.a(paramInt, paramxmt, paramArrayList);
    if (bool)
    {
      yuk.b(this.jdField_a_of_type_JavaLangString, "onReBind, verticalPosition: %d => %d, old-data.size=%d, new-data.size=%d, groupId=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()), Integer.valueOf(paramArrayList.size()), paramxmt.jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString });
      this.c = a().mUIStyle.mPlayerRepeatMode;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter.a(paramArrayList, paramInt);
      paramxmt = a(paramxmt.jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString);
      if (paramxmt == null) {
        break label619;
      }
      paramInt = 0;
      label124:
      if (paramInt >= paramArrayList.size()) {
        break label619;
      }
      if (!TextUtils.equals(((xqz)paramArrayList.get(paramInt)).jdField_a_of_type_JavaLangString, paramxmt)) {
        break label304;
      }
    }
    for (;;)
    {
      paramxmt = (xpv)b(xpv.class);
      if ((d()) && (paramxmt != null) && (paramxmt.c()))
      {
        yuk.a(this.jdField_a_of_type_JavaLangString + "Q.qqstory.weishi", "onBind, weishi hide loading state", Integer.valueOf(paramInt));
        paramxmt.e();
        if ((paramInt > 0) && (paramInt + 1 < paramArrayList.size()))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(paramInt + 1);
          yuk.a(this.jdField_a_of_type_JavaLangString + "Q.qqstory.weishi", "onBind, change to next video", Integer.valueOf(paramInt));
          return;
          yuk.a(this.jdField_a_of_type_JavaLangString, "onBind, verticalPosition: %d, data.size=%d, groupId=%s", Integer.valueOf(paramInt), Integer.valueOf(paramArrayList.size()), paramxmt.jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString);
          break;
          label304:
          paramInt += 1;
          break label124;
        }
        paramxmt = a();
        if ((paramxmt instanceof xrh))
        {
          paramxmt = (VideoViewVideoHolder)((xrh)paramxmt).b(VideoViewVideoHolder.class);
          if (paramxmt != null)
          {
            paramxmt.d();
            yuk.a(this.jdField_a_of_type_JavaLangString + "Q.qqstory.weishi", "onBind, resume play", Integer.valueOf(paramInt));
          }
        }
      }
      if (paramInt == -1)
      {
        paramInt = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c();
        yuk.a(this.jdField_a_of_type_JavaLangString, "onBind, -1 ==>> getCurrentItem=%d", Integer.valueOf(paramInt));
      }
      for (;;)
      {
        if (paramInt >= 0) {}
        for (;;)
        {
          yuk.b(this.jdField_a_of_type_JavaLangString, "onBind, verticalPosition=%d, data.size=%d, groupId=%s, current=%d, selected=%d, mPlayerRepeatMode=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramArrayList.size()), this.jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c()), Integer.valueOf(paramInt), Integer.valueOf(this.c) });
          if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() != paramInt) {
            break label607;
          }
          paramxmt = a(paramInt);
          yuk.a(this.jdField_a_of_type_JavaLangString, "onBind, getPageHolderOfPosition = %s", paramxmt);
          if ((paramxmt != null) && (paramxmt.c())) {
            break label591;
          }
          yuk.a(this.jdField_a_of_type_JavaLangString, "onBind, fake onPageSelected, position = %d", Integer.valueOf(paramInt));
          this.jdField_a_of_type_Xsx.a(paramInt);
          paramxmt = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.a().iterator();
          while (paramxmt.hasNext()) {
            ((xsx)paramxmt.next()).a(paramInt);
          }
          break;
          paramInt = 0;
        }
        label591:
        yuk.a(this.jdField_a_of_type_JavaLangString, "onBind, setCurrentItem ignore position = %d, selectedItem=%s", Integer.valueOf(paramInt), paramxmt);
        return;
        label607:
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(paramInt);
        return;
      }
      label619:
      paramInt = -1;
    }
  }
  
  public void a(xpy paramxpy, xsn paramxsn)
  {
    this.jdField_a_of_type_Xpy = paramxpy;
    this.jdField_a_of_type_Xsn = paramxsn;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    xpm localxpm;
    if (paramBoolean1)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      if (paramBoolean2)
      {
        localxpm = (xpm)a(xpm.class);
        if (localxpm != null) {
          localxpm.jdField_a_of_type_AndroidViewView.setVisibility(0);
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
      localxpm = (xpm)a(xpm.class);
    } while (localxpm == null);
    localxpm.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager = ((XViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131381041));
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
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter.a(this.jdField_b_of_type_Xsn);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setOnPageChangeListener(this.jdField_a_of_type_Xsx);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.post(new StoryPlayerGroupHolder.1(this));
    super.b();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setOnVisibilityChangeListener(new xqu(this));
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
    if ((this.jdField_a_of_type_Xms instanceof xng)) {
      bool = wwg.a(QQStoryContext.a()).a(((xng)this.jdField_a_of_type_Xms).a());
    }
    return bool;
  }
  
  public boolean e()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    Object localObject;
    if (TextUtils.equals(this.jdField_a_of_type_Xqp.a().jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString))
    {
      localObject = a(this.jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label83;
      }
      localObject = a();
      yuk.a(this.jdField_a_of_type_JavaLangString, "no selected Vid, current = %s", localObject);
      bool1 = bool2;
      if (localObject != null)
      {
        a((xrg)localObject);
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
      xrg localxrg = (xrg)StoryPlayerGroupHolder.StoryPlayerVideoAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter).valueAt(i);
      if (TextUtils.equals(localxrg.a.jdField_a_of_type_JavaLangString, (CharSequence)localObject))
      {
        a(localxrg);
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