package com.tencent.biz.qqcircle.fragments.person;

import aauy;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QCircleTimeLineCreateTimeEvent;
import com.tencent.biz.qqcircle.widgets.FrameAnimationView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.QCircleFolderTabViewPager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import uxx;
import vnj;
import vnk;
import vnl;
import vnm;
import vnn;
import vrf;
import vuf;
import zby;
import zvg;
import zvh;
import zwp;
import zwr;
import zxs;
import zxu;

public class QCirclePersonalBottomView
  extends QCircleBaseWidgetView<zxs>
  implements View.OnClickListener, zwr
{
  private int jdField_a_of_type_Int;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RadioButton jdField_a_of_type_AndroidWidgetRadioButton;
  private RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCirclePersonalDynamicFragment jdField_a_of_type_ComTencentBizQqcircleFragmentsPersonQCirclePersonalDynamicFragment;
  private QCirclePersonalPushFragment jdField_a_of_type_ComTencentBizQqcircleFragmentsPersonQCirclePersonalPushFragment;
  private QCirclePersonalWorksFragment jdField_a_of_type_ComTencentBizQqcircleFragmentsPersonQCirclePersonalWorksFragment;
  private FrameAnimationView jdField_a_of_type_ComTencentBizQqcircleWidgetsFrameAnimationView;
  private QCircleFolderTabViewPager jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFolderTabViewPager;
  private String jdField_a_of_type_JavaLangString;
  private List<QCirclePersonalBaseBottomFragment> jdField_a_of_type_JavaUtilList;
  private vnn jdField_a_of_type_Vnn;
  private zxu jdField_a_of_type_Zxu;
  private int jdField_b_of_type_Int;
  private RadioButton jdField_b_of_type_AndroidWidgetRadioButton;
  private RadioButton c;
  
  public QCirclePersonalBottomView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public QCirclePersonalBottomView(Context paramContext, zxu paramzxu)
  {
    this(paramContext);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_Zxu = paramzxu;
    setInteractor(paramzxu.getInteractor());
    c();
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFolderTabViewPager.setOffscreenPageLimit(2);
    this.jdField_a_of_type_Vnn = new vnn(this, ((PublicFragmentActivity)paramContext).getSupportFragmentManager());
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFolderTabViewPager.setAdapter(this.jdField_a_of_type_Vnn);
    d();
    a(this);
    ((vuf)paramzxu.getViewModel(vuf.class)).a.observe((BasePartFragment)paramzxu.getParentFragment(), new vnj(this));
  }
  
  private void a(int paramInt)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (i == paramInt) {
        ((QCirclePersonalBaseBottomFragment)this.jdField_a_of_type_JavaUtilList.get(i)).a(paramInt);
      }
      for (;;)
      {
        i += 1;
        break;
        ((QCirclePersonalBaseBottomFragment)this.jdField_a_of_type_JavaUtilList.get(i)).e();
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    String str2 = this.jdField_a_of_type_JavaLangString;
    if (uxx.a(this.jdField_a_of_type_JavaLangString)) {}
    for (String str1 = "1";; str1 = "2")
    {
      vrf.a(str2, 11, paramInt1, paramInt2, str1, "", "", "", "", d());
      return;
    }
  }
  
  private void a(@Nullable ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsFrameAnimationView = new FrameAnimationView(getContext());
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsFrameAnimationView.setDownloadZipFilePath("https://downv6.qq.com/video_story/personal_page_loading.zip", 1000, false);
      paramViewGroup.addView(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsFrameAnimationView, new ViewGroup.LayoutParams(-1, -1));
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Object localObject = "https://downv6.qq.com/video_story/qcircle/animation/list_to_grid.zip";; localObject = "https://downv6.qq.com/video_story/qcircle/animation/grid_to_list.zip")
    {
      localObject = new zvg((String)localObject);
      ((zvg)localObject).a(500);
      ((zvg)localObject).a(500L);
      ((zvg)localObject).a(true);
      ((zvg)localObject).b(true);
      zvh.a().a(hashCode(), ((zvg)localObject).a(), new vnk(this, paramBoolean));
      return;
    }
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetRadioButton != null)
    {
      String str = getResources().getString(2131697217);
      SpannableString localSpannableString = new SpannableString(str + " " + uxx.d(paramInt));
      localSpannableString.setSpan(new AbsoluteSizeSpan(zby.b(getContext(), 10.0F)), str.length(), str.length() + 1, 34);
      this.jdField_a_of_type_AndroidWidgetRadioButton.setText(localSpannableString);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaLangString = uxx.a(getContext());
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsPersonQCirclePersonalWorksFragment = new QCirclePersonalWorksFragment();
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsPersonQCirclePersonalDynamicFragment = new QCirclePersonalDynamicFragment();
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsPersonQCirclePersonalPushFragment = new QCirclePersonalPushFragment();
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentBizQqcircleFragmentsPersonQCirclePersonalWorksFragment);
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentBizQqcircleFragmentsPersonQCirclePersonalDynamicFragment);
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentBizQqcircleFragmentsPersonQCirclePersonalPushFragment);
  }
  
  private void c(int paramInt)
  {
    if (paramInt == 2)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130844000));
      return;
    }
    if (paramInt == 1)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130843999));
      return;
    }
    QLog.i("QCirclePersonalBottomView", 1, "unSupport layoutMode:" + paramInt);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130844000));
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(new vnl(this));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFolderTabViewPager.addOnPageChangeListener(new vnm(this));
  }
  
  public int a()
  {
    return 2131560742;
  }
  
  public String a()
  {
    return "QCirclePersonalBottomView";
  }
  
  public void a()
  {
    int j = 0;
    int i;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      if ((this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFolderTabViewPager.getCurrentItem() != 0) || (this.jdField_b_of_type_Int <= 0)) {
        break label77;
      }
      i = 1;
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      if (i == 0) {
        break label82;
      }
      label37:
      ((ImageView)localObject).setVisibility(j);
      if (i != 0) {
        if (!uxx.a(getContext())) {
          break label88;
        }
      }
    }
    label77:
    label82:
    label88:
    for (Object localObject = String.valueOf(1);; localObject = String.valueOf(2))
    {
      vrf.a("", 11, 18, 1, (String)localObject, d());
      return;
      i = 0;
      break;
      j = 8;
      break label37;
    }
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)paramView.findViewById(2131376491));
    this.jdField_a_of_type_AndroidWidgetRadioButton = ((RadioButton)paramView.findViewById(2131375955));
    this.jdField_b_of_type_AndroidWidgetRadioButton = ((RadioButton)paramView.findViewById(2131375953));
    this.c = ((RadioButton)paramView.findViewById(2131375954));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFolderTabViewPager = ((QCircleFolderTabViewPager)paramView.findViewById(2131372302));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369167));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379667));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_Int = 2;
    c(2);
  }
  
  public void a(zxs paramzxs) {}
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFolderTabViewPager != null) {
      return this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFolderTabViewPager.getCurrentItem();
    }
    return 0;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleTimeLineCreateTimeEvent.class);
    localArrayList.add(QCircleFeedEvent.class);
    return localArrayList;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    zwp.a().a(this);
  }
  
  public void onClick(View paramView)
  {
    String str;
    if ((!aauy.a(String.valueOf(paramView.getId()), 500L)) && (paramView.getId() == 2131369167))
    {
      if (!uxx.a(getContext())) {
        break label82;
      }
      str = String.valueOf(1);
      vrf.a("", 11, 18, 2, str, d());
      if (this.jdField_a_of_type_Int != 2) {
        break label90;
      }
      setLayoutMode(1);
      a(true);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label82:
      str = String.valueOf(2);
      break;
      label90:
      setLayoutMode(2);
      a(false);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    zwp.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleTimeLineCreateTimeEvent)) {}
    do
    {
      paramSimpleBaseEvent = (QCircleTimeLineCreateTimeEvent)paramSimpleBaseEvent;
      do
      {
        return;
      } while (!(paramSimpleBaseEvent instanceof QCircleFeedEvent));
      paramSimpleBaseEvent = (QCircleFeedEvent)paramSimpleBaseEvent;
      if (paramSimpleBaseEvent.mState == 2)
      {
        this.jdField_b_of_type_Int += 1;
        b(this.jdField_b_of_type_Int);
        a();
        return;
      }
    } while (paramSimpleBaseEvent.mState != 3);
    if (this.jdField_b_of_type_Int > 0) {
      this.jdField_b_of_type_Int -= 1;
    }
    b(this.jdField_b_of_type_Int);
    a();
  }
  
  public void setFeedCount(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    b(paramInt);
    a();
  }
  
  public void setLayoutMode(int paramInt)
  {
    a();
    c(paramInt);
    if (paramInt == this.jdField_a_of_type_Int) {
      QLog.i("QCirclePersonalBottomView", 1, "same layoutMode not change" + paramInt);
    }
    do
    {
      return;
      this.jdField_a_of_type_Int = paramInt;
    } while ((this.jdField_a_of_type_ComTencentBizQqcircleFragmentsPersonQCirclePersonalWorksFragment == null) || (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsPersonQCirclePersonalWorksFragment.a == null));
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsPersonQCirclePersonalWorksFragment.b(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonalBottomView
 * JD-Core Version:    0.7.0.1
 */