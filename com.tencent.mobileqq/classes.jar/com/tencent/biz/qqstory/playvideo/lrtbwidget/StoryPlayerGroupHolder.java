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
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.UIStyle;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import wmr;
import xcy;
import xcz;
import xdm;
import xfs;
import xfv;
import xgb;
import xge;
import xgh;
import xgv;
import xha;
import xhb;
import xhc;
import xhf;
import xhh;
import xhm;
import xhn;
import xit;
import xiz;
import xjd;
import xmp;
import xmx;
import xnt;
import xoj;
import xph;
import xpj;
import xpn;
import xpv;
import ykq;

public class StoryPlayerGroupHolder
  extends xfv
{
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public StoryPlayerGroupHolder.StoryPlayerVideoAdapter a;
  public XViewPager a;
  private xge jdField_a_of_type_Xge;
  private xgv jdField_a_of_type_Xgv;
  private xit jdField_a_of_type_Xit;
  private xjd jdField_a_of_type_Xjd = new xhb(this);
  public int b;
  private xit b;
  private int c = 0;
  
  public StoryPlayerGroupHolder(@NonNull ViewGroup paramViewGroup, xgv paramxgv)
  {
    super(paramViewGroup);
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_Xit = new xhc(this);
    this.jdField_a_of_type_Xgv = paramxgv;
    d();
    a(new xhh((ViewGroup)this.jdField_a_of_type_AndroidViewView));
    a(new xfs((ViewGroup)this.jdField_a_of_type_AndroidViewView));
    a(new xgh((ViewGroup)this.jdField_a_of_type_AndroidViewView));
    a(new xpv(this.jdField_a_of_type_AndroidViewView.findViewById(2131381428)));
    a(new xpn((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131380530)));
    a(new xnt((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365566)));
    a(new xmp((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363386)));
    a(new xpj((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373230)));
    a(new xmx((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363737)));
    a(new xgb((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370442)));
    a(new xoj(this.jdField_a_of_type_AndroidViewView.findViewById(2131376728).findViewById(2131371553)));
    a(new xph(this.jdField_a_of_type_AndroidViewView.findViewById(2131371894)));
  }
  
  private int b()
  {
    boolean bool = ScreenUtil.checkDeviceHasNavigationBar(this.jdField_a_of_type_AndroidViewView.getContext());
    ykq.b("FredguoFix", "StoryPlayerGroupHolder: hasNavi " + bool);
    if (bool) {
      return 0;
    }
    return (int)Math.min(ScreenUtil.SCREEN_HIGHT - ScreenUtil.SCREEN_WIDTH / 9.0F * 16.0F, 140.0F);
  }
  
  private void d()
  {
    if (LiuHaiUtils.jdField_a_of_type_Boolean)
    {
      View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131372947);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.height = (LiuHaiUtils.jdField_a_of_type_Int / 2);
      localView.setLayoutParams(localLayoutParams);
    }
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561819, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup.findViewById(2131376646));
    return paramViewGroup;
  }
  
  public VideoViewVideoHolder a()
  {
    xhm localxhm = a();
    if (localxhm != null) {
      return (VideoViewVideoHolder)localxhm.a(VideoViewVideoHolder.class);
    }
    return null;
  }
  
  public xhm a()
  {
    return a(this.jdField_b_of_type_Int);
  }
  
  public xhm a(int paramInt)
  {
    xhm localxhm = null;
    if (paramInt >= 0)
    {
      xiz localxiz = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.a(paramInt);
      if (localxiz != null) {
        localxhm = (xhm)localxiz.a;
      }
      return localxhm;
    }
    ykq.d(this.jdField_a_of_type_JavaLangString, "getPageHolderOfPosition, return null ! position=%d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
  
  public void a(int paramInt, xcz paramxcz, @NonNull ArrayList<xhf> paramArrayList)
  {
    boolean bool = this.jdField_a_of_type_Boolean;
    super.a(paramInt, paramxcz, paramArrayList);
    if (bool)
    {
      ykq.b(this.jdField_a_of_type_JavaLangString, "onReBind, verticalPosition: %d => %d, old-data.size=%d, new-data.size=%d, groupId=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()), Integer.valueOf(paramArrayList.size()), paramxcz.jdField_a_of_type_Xcy.jdField_a_of_type_JavaLangString });
      this.c = a().mUIStyle.mPlayerRepeatMode;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter.a(paramArrayList, paramInt);
      paramxcz = a(paramxcz.jdField_a_of_type_Xcy.jdField_a_of_type_JavaLangString);
      if (paramxcz == null) {
        break label619;
      }
      paramInt = 0;
      label124:
      if (paramInt >= paramArrayList.size()) {
        break label619;
      }
      if (!TextUtils.equals(((xhf)paramArrayList.get(paramInt)).jdField_a_of_type_JavaLangString, paramxcz)) {
        break label304;
      }
    }
    for (;;)
    {
      paramxcz = (xgb)b(xgb.class);
      if ((d()) && (paramxcz != null) && (paramxcz.c()))
      {
        ykq.a(this.jdField_a_of_type_JavaLangString + "Q.qqstory.weishi", "onBind, weishi hide loading state", Integer.valueOf(paramInt));
        paramxcz.e();
        if ((paramInt > 0) && (paramInt + 1 < paramArrayList.size()))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(paramInt + 1);
          ykq.a(this.jdField_a_of_type_JavaLangString + "Q.qqstory.weishi", "onBind, change to next video", Integer.valueOf(paramInt));
          return;
          ykq.a(this.jdField_a_of_type_JavaLangString, "onBind, verticalPosition: %d, data.size=%d, groupId=%s", Integer.valueOf(paramInt), Integer.valueOf(paramArrayList.size()), paramxcz.jdField_a_of_type_Xcy.jdField_a_of_type_JavaLangString);
          break;
          label304:
          paramInt += 1;
          break label124;
        }
        paramxcz = a();
        if ((paramxcz instanceof xhn))
        {
          paramxcz = (VideoViewVideoHolder)((xhn)paramxcz).b(VideoViewVideoHolder.class);
          if (paramxcz != null)
          {
            paramxcz.d();
            ykq.a(this.jdField_a_of_type_JavaLangString + "Q.qqstory.weishi", "onBind, resume play", Integer.valueOf(paramInt));
          }
        }
      }
      if (paramInt == -1)
      {
        paramInt = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c();
        ykq.a(this.jdField_a_of_type_JavaLangString, "onBind, -1 ==>> getCurrentItem=%d", Integer.valueOf(paramInt));
      }
      for (;;)
      {
        if (paramInt >= 0) {}
        for (;;)
        {
          ykq.b(this.jdField_a_of_type_JavaLangString, "onBind, verticalPosition=%d, data.size=%d, groupId=%s, current=%d, selected=%d, mPlayerRepeatMode=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramArrayList.size()), this.jdField_a_of_type_Xcy.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c()), Integer.valueOf(paramInt), Integer.valueOf(this.c) });
          if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() != paramInt) {
            break label607;
          }
          paramxcz = a(paramInt);
          ykq.a(this.jdField_a_of_type_JavaLangString, "onBind, getPageHolderOfPosition = %s", paramxcz);
          if ((paramxcz != null) && (paramxcz.c())) {
            break label591;
          }
          ykq.a(this.jdField_a_of_type_JavaLangString, "onBind, fake onPageSelected, position = %d", Integer.valueOf(paramInt));
          this.jdField_a_of_type_Xjd.a(paramInt);
          paramxcz = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.a().iterator();
          while (paramxcz.hasNext()) {
            ((xjd)paramxcz.next()).a(paramInt);
          }
          break;
          paramInt = 0;
        }
        label591:
        ykq.a(this.jdField_a_of_type_JavaLangString, "onBind, setCurrentItem ignore position = %d, selectedItem=%s", Integer.valueOf(paramInt), paramxcz);
        return;
        label607:
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(paramInt);
        return;
      }
      label619:
      paramInt = -1;
    }
  }
  
  public void a(xge paramxge, xit paramxit)
  {
    this.jdField_a_of_type_Xge = paramxge;
    this.jdField_a_of_type_Xit = paramxit;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    xfs localxfs;
    if (paramBoolean1)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      if (paramBoolean2)
      {
        localxfs = (xfs)a(xfs.class);
        if (localxfs != null) {
          localxfs.jdField_a_of_type_AndroidViewView.setVisibility(0);
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
      localxfs = (xfs)a(xfs.class);
    } while (localxfs == null);
    localxfs.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager = ((XViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131381118));
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
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter.a(this.jdField_b_of_type_Xit);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setOnPageChangeListener(this.jdField_a_of_type_Xjd);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.post(new StoryPlayerGroupHolder.1(this));
    super.b();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setOnVisibilityChangeListener(new xha(this));
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
    if ((this.jdField_a_of_type_Xcy instanceof xdm)) {
      bool = wmr.a(QQStoryContext.a()).a(((xdm)this.jdField_a_of_type_Xcy).a());
    }
    return bool;
  }
  
  public boolean e()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    Object localObject;
    if (TextUtils.equals(this.jdField_a_of_type_Xgv.a().jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Xcy.jdField_a_of_type_JavaLangString))
    {
      localObject = a(this.jdField_a_of_type_Xcy.jdField_a_of_type_JavaLangString);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label83;
      }
      localObject = a();
      ykq.a(this.jdField_a_of_type_JavaLangString, "no selected Vid, current = %s", localObject);
      bool1 = bool2;
      if (localObject != null)
      {
        a((xhm)localObject);
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
      xhm localxhm = (xhm)StoryPlayerGroupHolder.StoryPlayerVideoAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter).valueAt(i);
      if (TextUtils.equals(localxhm.a.jdField_a_of_type_JavaLangString, (CharSequence)localObject))
      {
        a(localxhm);
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