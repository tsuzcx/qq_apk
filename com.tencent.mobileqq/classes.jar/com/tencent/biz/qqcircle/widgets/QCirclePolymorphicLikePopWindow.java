package com.tencent.biz.qqcircle.widgets;

import alud;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import azkz;
import com.app.hubert.guide.util.ScreenUtils;
import com.tencent.biz.qqcircle.events.QCircleFuelAnimationEvent;
import com.tencent.biz.qqcircle.events.QCirclePolyPraiseUpdateEvent;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqcircle.requests.QCircleDoLikeRequest;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;
import ndk;
import qqcircle.QQCircleFeedBase.StDoLikeReqDoPolyLikeBusiReqData;
import qqcircle.QQCircleFeedBase.StLikeBusiData;
import qqcircle.QQCircleFeedBase.StPolyLike;
import tra;
import twe;
import twi;
import tzs;
import tzw;
import tzy;
import uej;
import uem;
import ueo;
import uep;
import ueq;
import ybu;
import yiw;

public class QCirclePolymorphicLikePopWindow
  extends PopupWindow
{
  public static int a;
  public static HashMap<String, Integer> a;
  public static int b;
  public static int c;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ReportExtraTypeInfo jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  private List<QQCircleFeedBase.StPolyLike> jdField_a_of_type_JavaUtilList;
  private uej jdField_a_of_type_Uej;
  private boolean jdField_a_of_type_Boolean;
  private WeakReference<View> jdField_b_of_type_JavaLangRefWeakReference;
  private HashMap<String, ueq> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private volatile boolean jdField_b_of_type_Boolean = true;
  private WeakReference<QCirclePolymorphicAniView> jdField_c_of_type_JavaLangRefWeakReference;
  private HashMap<Integer, twi> jdField_c_of_type_JavaUtilHashMap = new HashMap();
  private volatile boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private WeakReference<View> jdField_d_of_type_JavaLangRefWeakReference;
  private boolean jdField_d_of_type_Boolean;
  private int e;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put("2", Integer.valueOf(2130843651));
    jdField_a_of_type_JavaUtilHashMap.put("3", Integer.valueOf(2130843657));
    jdField_a_of_type_JavaUtilHashMap.put("4", Integer.valueOf(2130843656));
    jdField_a_of_type_JavaUtilHashMap.put("6", Integer.valueOf(2130843655));
    jdField_a_of_type_JavaUtilHashMap.put("7", Integer.valueOf(2130843650));
    jdField_a_of_type_Int = azkz.a(88.0F);
    jdField_b_of_type_Int = azkz.a(48.0F);
    jdField_c_of_type_Int = 6;
  }
  
  public QCirclePolymorphicLikePopWindow(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    paramActivity = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramActivity != null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramActivity).inflate(2131560578, null);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373210));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373206));
    setContentView(this.jdField_a_of_type_AndroidViewView);
    setOutsideTouchable(true);
    setFocusable(true);
    setBackgroundDrawable(new ColorDrawable(0));
  }
  
  private void a(AnimationView paramAnimationView, String paramString)
  {
    if ((paramAnimationView != null) && (!TextUtils.isEmpty(paramString)))
    {
      if ((paramAnimationView.getDrawable() instanceof QQAnimationDrawable)) {
        ((QQAnimationDrawable)paramAnimationView.getDrawable()).start();
      }
    }
    else {
      return;
    }
    ThreadManager.getFileThreadHandler().post(new QCirclePolymorphicLikePopWindow.LoadGifRunnable(this, paramAnimationView, paramString));
  }
  
  private void a(QQCircleFeedBase.StPolyLike paramStPolyLike, int paramInt)
  {
    Object localObject2 = (ueq)this.jdField_b_of_type_JavaUtilHashMap.get(paramStPolyLike.polyLikeID.get());
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new ueq((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      this.jdField_b_of_type_JavaUtilHashMap.put(paramStPolyLike.polyLikeID.get(), localObject1);
    }
    ((ueq)localObject1).a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, paramStPolyLike, paramInt);
    localObject2 = new LinearLayout.LayoutParams(-1, -1);
    ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(ueq.a((ueq)localObject1), (ViewGroup.LayoutParams)localObject2);
    a((ueq)localObject1, paramStPolyLike);
    localObject2 = ((ueq)localObject1).a();
    ueq.a((ueq)localObject1).setOnClickListener(new uem(this, paramStPolyLike, (AnimationView)localObject2, (ueq)localObject1));
  }
  
  private void a(ueq paramueq, QQCircleFeedBase.StPolyLike paramStPolyLike)
  {
    if (twe.a().a(paramStPolyLike.polySource.get()))
    {
      paramStPolyLike = twe.a().a(paramStPolyLike.polySource.get());
      a(paramueq.a(), paramStPolyLike);
    }
    do
    {
      return;
      uep localuep = new uep(this, paramueq);
      this.jdField_c_of_type_JavaUtilHashMap.put(Integer.valueOf(paramueq.hashCode()), localuep);
      twe.a().a(paramStPolyLike.polySource.get(), localuep);
      try
      {
        paramueq.a().setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(((Integer)jdField_a_of_type_JavaUtilHashMap.get(paramStPolyLike.polyLikeID.get())).intValue()));
        return;
      }
      catch (Exception paramueq) {}
    } while (!QLog.isColorLevel());
    QLog.e("Q.profilecard.FrdProfileCard", 2, "makeOrRefreshPresent fail!", paramueq);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      if (this.jdField_a_of_type_JavaUtilList.size() <= jdField_c_of_type_Int) {
        break label66;
      }
    }
    label66:
    for (int i = jdField_c_of_type_Int;; i = this.jdField_a_of_type_JavaUtilList.size())
    {
      this.e = i;
      this.jdField_d_of_type_Int = (jdField_b_of_type_Int * this.e + azkz.a(32.0F));
      setWidth(this.jdField_d_of_type_Int);
      setHeight(jdField_a_of_type_Int);
      return;
    }
  }
  
  public void a()
  {
    int j = 0;
    label224:
    for (;;)
    {
      try
      {
        if (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null) {
          break;
        }
        int[] arrayOfInt = new int[2];
        ((View)this.jdField_b_of_type_JavaLangRefWeakReference.get()).getLocationInWindow(arrayOfInt);
        setAnimationStyle(2131755873);
        int i;
        if (arrayOfInt[1] > jdField_a_of_type_Int + azkz.a(60.0F) + ScreenUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidViewView.getContext()))
        {
          setAnimationStyle(2131755873);
          i = arrayOfInt[1] - jdField_a_of_type_Int;
          if (!this.jdField_a_of_type_Boolean) {
            break label224;
          }
          i -= azkz.a(5.0F);
          showAtLocation((View)this.jdField_b_of_type_JavaLangRefWeakReference.get(), 0, (azkz.jdField_a_of_type_Int - this.jdField_d_of_type_Int) / 2, i);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
          i = j;
          if (i < this.e)
          {
            a((QQCircleFeedBase.StPolyLike)this.jdField_a_of_type_JavaUtilList.get(i), i);
            i += 1;
            continue;
          }
        }
        else
        {
          setAnimationStyle(2131755872);
          i = arrayOfInt[1];
          i = ((View)this.jdField_b_of_type_JavaLangRefWeakReference.get()).getHeight() + i;
          continue;
        }
        if (ybu.a())
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          return;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
  }
  
  public void a(View paramView1, View paramView2, boolean paramBoolean1, QCirclePolymorphicAniView paramQCirclePolymorphicAniView, FeedCloudMeta.StFeed paramStFeed, List<QQCircleFeedBase.StPolyLike> paramList, ReportExtraTypeInfo paramReportExtraTypeInfo, boolean paramBoolean2)
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramView1);
    this.jdField_c_of_type_JavaLangRefWeakReference = new WeakReference(paramQCirclePolymorphicAniView);
    this.jdField_d_of_type_JavaLangRefWeakReference = new WeakReference(paramView2);
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo = paramReportExtraTypeInfo;
    this.jdField_d_of_type_Boolean = paramBoolean2;
    b();
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, QQCircleFeedBase.StPolyLike paramStPolyLike)
  {
    int j = 36;
    int i = 2;
    if (!ndk.a(this.jdField_a_of_type_AndroidViewView.getContext())) {
      QQToast.a(this.jdField_a_of_type_AndroidViewView.getContext(), alud.a(2131694772), 0).a();
    }
    while (!this.jdField_b_of_type_Boolean) {
      return;
    }
    for (;;)
    {
      try
      {
        QQCircleFeedBase.StLikeBusiData localStLikeBusiData = new QQCircleFeedBase.StLikeBusiData();
        localStLikeBusiData.mergeFrom(paramStFeed.likeInfo.busiData.get().toByteArray());
        QQCircleFeedBase.StPolyLike localStPolyLike = localStLikeBusiData.curPolyLikeInfo;
        this.jdField_c_of_type_Boolean = false;
        QQCircleFeedBase.StDoLikeReqDoPolyLikeBusiReqData localStDoLikeReqDoPolyLikeBusiReqData;
        if (paramStPolyLike.polyLikeID.get().equals(localStPolyLike.polyLikeID.get()))
        {
          a(true, false, paramStFeed, 0, localStPolyLike, new QQCircleFeedBase.StPolyLike());
          this.jdField_c_of_type_Boolean = true;
          i = 0;
          this.jdField_b_of_type_Boolean = false;
          QLog.d("QCirclePraise_", 4, "start zan id :" + paramStPolyLike.polyLikeID.get());
          FeedCloudMeta.StLike localStLike = tra.a(paramStFeed.likeInfo);
          localStDoLikeReqDoPolyLikeBusiReqData = new QQCircleFeedBase.StDoLikeReqDoPolyLikeBusiReqData();
          localStDoLikeReqDoPolyLikeBusiReqData.curPolyLikeInfo.set(localStLikeBusiData.curPolyLikeInfo);
          if (i == 0)
          {
            localStDoLikeReqDoPolyLikeBusiReqData.polyLikeInfo.set(new QQCircleFeedBase.StPolyLike());
            VSNetworkHelper.a().a(new QCircleDoLikeRequest(paramStFeed, i, localStLike, localStDoLikeReqDoPolyLikeBusiReqData), new ueo(this, paramStFeed, i, localStPolyLike, paramStPolyLike));
            if (i != 0) {
              continue;
            }
            if (!tzy.a().c(57)) {
              continue;
            }
            tzw.a(39, 2, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo);
          }
        }
        else
        {
          if (!TextUtils.isEmpty(localStPolyLike.polyLikeID.get())) {
            continue;
          }
          i = 1;
          continue;
        }
        localStDoLikeReqDoPolyLikeBusiReqData.polyLikeInfo.set(paramStPolyLike);
        continue;
        tzs.a(39, 2, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo);
        return;
        if (i == 1)
        {
          if (tzy.a().c(57))
          {
            if (this.jdField_d_of_type_Boolean)
            {
              i = j;
              tzw.a(i, 2, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo);
              yiw.a().a(new QCircleFuelAnimationEvent());
            }
          }
          else
          {
            if (!this.jdField_d_of_type_Boolean) {
              break label433;
            }
            i = 36;
            tzs.a(i, 2, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo);
            continue;
          }
        }
        else
        {
          if (tzy.a().c(57))
          {
            tzw.a(40, 2, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo);
            return;
          }
          tzs.a(40, 2, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo);
          return;
        }
      }
      catch (Exception paramStFeed)
      {
        return;
      }
      i = 38;
      continue;
      label433:
      i = 38;
    }
  }
  
  public void a(uej paramuej)
  {
    this.jdField_a_of_type_Uej = paramuej;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, FeedCloudMeta.StFeed paramStFeed, int paramInt, QQCircleFeedBase.StPolyLike paramStPolyLike1, QQCircleFeedBase.StPolyLike paramStPolyLike2)
  {
    int j = paramStFeed.likeInfo.count.get();
    int i;
    if (paramInt == 1) {
      i = j + 1;
    }
    for (;;)
    {
      paramStFeed.likeInfo.count.set(i);
      paramStFeed.likeInfo.status.set(paramInt);
      if (paramInt != 0) {
        break;
      }
      yiw.a().a(new QCirclePolyPraiseUpdateEvent(paramStFeed.id.get(), paramStPolyLike1, new QQCircleFeedBase.StPolyLike(), paramInt, i));
      return;
      i = j;
      if (paramInt == 0) {
        i = j - 1;
      }
    }
    yiw.a().a(new QCirclePolyPraiseUpdateEvent(paramStFeed.id.get(), paramStPolyLike1, paramStPolyLike2, paramInt, i));
  }
  
  public void dismiss()
  {
    super.dismiss();
    Iterator localIterator = this.jdField_b_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (ueq)this.jdField_b_of_type_JavaUtilHashMap.get(localObject);
      if ((localObject != null) && (((ueq)localObject).a() != null) && ((((ueq)localObject).a().getDrawable() instanceof QQAnimationDrawable))) {
        ((QQAnimationDrawable)((ueq)localObject).a().getDrawable()).stop();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePolymorphicLikePopWindow
 * JD-Core Version:    0.7.0.1
 */