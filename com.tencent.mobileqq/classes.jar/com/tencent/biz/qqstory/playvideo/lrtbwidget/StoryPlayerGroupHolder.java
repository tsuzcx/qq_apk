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
import azgq;
import bngs;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.UIStyle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import uuq;
import vld;
import vle;
import vlr;
import vnx;
import voa;
import vog;
import voj;
import vom;
import vpa;
import vpf;
import vpg;
import vph;
import vpk;
import vpm;
import vpr;
import vps;
import vqy;
import vre;
import vri;
import vuu;
import vvc;
import vvy;
import vwo;
import vxm;
import vxo;
import vxs;
import vya;
import wsv;

public class StoryPlayerGroupHolder
  extends voa
{
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public StoryPlayerGroupHolder.StoryPlayerVideoAdapter a;
  public XViewPager a;
  private voj jdField_a_of_type_Voj;
  private vpa jdField_a_of_type_Vpa;
  private vqy jdField_a_of_type_Vqy;
  private vri jdField_a_of_type_Vri = new vpg(this);
  public int b;
  private vqy b;
  private int c = 0;
  
  public StoryPlayerGroupHolder(@NonNull ViewGroup paramViewGroup, vpa paramvpa)
  {
    super(paramViewGroup);
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_Vqy = new vph(this);
    this.jdField_a_of_type_Vpa = paramvpa;
    d();
    a(new vpm((ViewGroup)this.jdField_a_of_type_AndroidViewView));
    a(new vnx((ViewGroup)this.jdField_a_of_type_AndroidViewView));
    a(new vom((ViewGroup)this.jdField_a_of_type_AndroidViewView));
    a(new vya(this.jdField_a_of_type_AndroidViewView.findViewById(2131380142)));
    a(new vxs((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131379301)));
    a(new vvy((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365154)));
    a(new vuu((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363082)));
    a(new vxo((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131372323)));
    a(new vvc((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363418)));
    a(new vog((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369744)));
    a(new vwo(this.jdField_a_of_type_AndroidViewView.findViewById(2131375788).findViewById(2131370718)));
    a(new vxm(this.jdField_a_of_type_AndroidViewView.findViewById(2131371054)));
  }
  
  private int b()
  {
    boolean bool = azgq.a(this.jdField_a_of_type_AndroidViewView.getContext());
    wsv.b("FredguoFix", "StoryPlayerGroupHolder: hasNavi " + bool);
    if (bool) {
      return 0;
    }
    return (int)Math.min(azgq.jdField_b_of_type_Int - azgq.jdField_a_of_type_Int / 9.0F * 16.0F, 140.0F);
  }
  
  private void d()
  {
    if (bngs.jdField_a_of_type_Boolean)
    {
      View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131372081);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.height = (bngs.jdField_a_of_type_Int / 2);
      localView.setLayoutParams(localLayoutParams);
    }
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561580, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup.findViewById(2131375715));
    return paramViewGroup;
  }
  
  public VideoViewVideoHolder a()
  {
    vpr localvpr = a();
    if (localvpr != null) {
      return (VideoViewVideoHolder)localvpr.a(VideoViewVideoHolder.class);
    }
    return null;
  }
  
  public vpr a()
  {
    return a(this.jdField_b_of_type_Int);
  }
  
  public vpr a(int paramInt)
  {
    vpr localvpr = null;
    if (paramInt >= 0)
    {
      vre localvre = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.a(paramInt);
      if (localvre != null) {
        localvpr = (vpr)localvre.a;
      }
      return localvpr;
    }
    wsv.d(this.jdField_a_of_type_JavaLangString, "getPageHolderOfPosition, return null ! position=%d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
  
  public void a(int paramInt, vle paramvle, @NonNull ArrayList<vpk> paramArrayList)
  {
    boolean bool = this.jdField_a_of_type_Boolean;
    super.a(paramInt, paramvle, paramArrayList);
    if (bool)
    {
      wsv.b(this.jdField_a_of_type_JavaLangString, "onReBind, verticalPosition: %d => %d, old-data.size=%d, new-data.size=%d, groupId=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()), Integer.valueOf(paramArrayList.size()), paramvle.jdField_a_of_type_Vld.jdField_a_of_type_JavaLangString });
      this.c = a().mUIStyle.mPlayerRepeatMode;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter.a(paramArrayList, paramInt);
      paramvle = a(paramvle.jdField_a_of_type_Vld.jdField_a_of_type_JavaLangString);
      if (paramvle == null) {
        break label619;
      }
      paramInt = 0;
      label124:
      if (paramInt >= paramArrayList.size()) {
        break label619;
      }
      if (!TextUtils.equals(((vpk)paramArrayList.get(paramInt)).jdField_a_of_type_JavaLangString, paramvle)) {
        break label304;
      }
    }
    for (;;)
    {
      paramvle = (vog)b(vog.class);
      if ((d()) && (paramvle != null) && (paramvle.c()))
      {
        wsv.a(this.jdField_a_of_type_JavaLangString + "Q.qqstory.weishi", "onBind, weishi hide loading state", Integer.valueOf(paramInt));
        paramvle.e();
        if ((paramInt > 0) && (paramInt + 1 < paramArrayList.size()))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(paramInt + 1);
          wsv.a(this.jdField_a_of_type_JavaLangString + "Q.qqstory.weishi", "onBind, change to next video", Integer.valueOf(paramInt));
          return;
          wsv.a(this.jdField_a_of_type_JavaLangString, "onBind, verticalPosition: %d, data.size=%d, groupId=%s", Integer.valueOf(paramInt), Integer.valueOf(paramArrayList.size()), paramvle.jdField_a_of_type_Vld.jdField_a_of_type_JavaLangString);
          break;
          label304:
          paramInt += 1;
          break label124;
        }
        paramvle = a();
        if ((paramvle instanceof vps))
        {
          paramvle = (VideoViewVideoHolder)((vps)paramvle).b(VideoViewVideoHolder.class);
          if (paramvle != null)
          {
            paramvle.d();
            wsv.a(this.jdField_a_of_type_JavaLangString + "Q.qqstory.weishi", "onBind, resume play", Integer.valueOf(paramInt));
          }
        }
      }
      if (paramInt == -1)
      {
        paramInt = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c();
        wsv.a(this.jdField_a_of_type_JavaLangString, "onBind, -1 ==>> getCurrentItem=%d", Integer.valueOf(paramInt));
      }
      for (;;)
      {
        if (paramInt >= 0) {}
        for (;;)
        {
          wsv.b(this.jdField_a_of_type_JavaLangString, "onBind, verticalPosition=%d, data.size=%d, groupId=%s, current=%d, selected=%d, mPlayerRepeatMode=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramArrayList.size()), this.jdField_a_of_type_Vld.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c()), Integer.valueOf(paramInt), Integer.valueOf(this.c) });
          if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() != paramInt) {
            break label607;
          }
          paramvle = a(paramInt);
          wsv.a(this.jdField_a_of_type_JavaLangString, "onBind, getPageHolderOfPosition = %s", paramvle);
          if ((paramvle != null) && (paramvle.c())) {
            break label591;
          }
          wsv.a(this.jdField_a_of_type_JavaLangString, "onBind, fake onPageSelected, position = %d", Integer.valueOf(paramInt));
          this.jdField_a_of_type_Vri.a(paramInt);
          paramvle = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.a().iterator();
          while (paramvle.hasNext()) {
            ((vri)paramvle.next()).a(paramInt);
          }
          break;
          paramInt = 0;
        }
        label591:
        wsv.a(this.jdField_a_of_type_JavaLangString, "onBind, setCurrentItem ignore position = %d, selectedItem=%s", Integer.valueOf(paramInt), paramvle);
        return;
        label607:
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(paramInt);
        return;
      }
      label619:
      paramInt = -1;
    }
  }
  
  public void a(voj paramvoj, vqy paramvqy)
  {
    this.jdField_a_of_type_Voj = paramvoj;
    this.jdField_a_of_type_Vqy = paramvqy;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    vnx localvnx;
    if (paramBoolean1)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      if (paramBoolean2)
      {
        localvnx = (vnx)a(vnx.class);
        if (localvnx != null) {
          localvnx.jdField_a_of_type_AndroidViewView.setVisibility(0);
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
      localvnx = (vnx)a(vnx.class);
    } while (localvnx == null);
    localvnx.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager = ((XViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131379848));
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
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter.a(this.jdField_b_of_type_Vqy);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setOnPageChangeListener(this.jdField_a_of_type_Vri);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.post(new StoryPlayerGroupHolder.1(this));
    super.b();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setOnVisibilityChangeListener(new vpf(this));
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
    if ((this.jdField_a_of_type_Vld instanceof vlr)) {
      bool = uuq.a(QQStoryContext.a()).a(((vlr)this.jdField_a_of_type_Vld).a());
    }
    return bool;
  }
  
  public boolean e()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    Object localObject;
    if (TextUtils.equals(this.jdField_a_of_type_Vpa.a().jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Vld.jdField_a_of_type_JavaLangString))
    {
      localObject = a(this.jdField_a_of_type_Vld.jdField_a_of_type_JavaLangString);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label83;
      }
      localObject = a();
      wsv.a(this.jdField_a_of_type_JavaLangString, "no selected Vid, current = %s", localObject);
      bool1 = bool2;
      if (localObject != null)
      {
        a((vpr)localObject);
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
      vpr localvpr = (vpr)StoryPlayerGroupHolder.StoryPlayerVideoAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter).valueAt(i);
      if (TextUtils.equals(localvpr.a.jdField_a_of_type_JavaLangString, (CharSequence)localObject))
      {
        a(localvpr);
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