package com.tencent.biz.qqcircle.widgets;

import aaga;
import aage;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.QCircleInitBean.QCircleActionBean;
import com.tencent.biz.qqcircle.comment.QCircleCommentItemView;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudCommon.BytesEntry;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import qqcircle.QQCircleFeedBase.StBusiInfoCommentListData;
import uxo;
import uxp;
import uxx;
import uyc;
import uzc;
import uzk;
import vhu;
import vll;
import vrc;
import vrg;
import vrr;
import vrt;
import vtd;
import vth;
import vvc;
import vvd;
import vve;
import vvf;
import vvg;
import vvh;
import vvi;
import vvp;
import vvs;
import zvq;
import zwp;
import zwr;
import zxk;
import zxl;
import zxo;
import zxz;
import zyd;

public class QCircleCommentListView
  extends QCircleBaseWidgetView<uzc>
  implements aaga, View.OnClickListener, zwr
{
  private int jdField_a_of_type_Int;
  private aage jdField_a_of_type_Aage;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleBlockContainer jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private FeedCloudMeta.StComment jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
  private FeedCloudMeta.StReply jdField_a_of_type_FeedcloudFeedCloudMeta$StReply;
  private List<FeedCloudMeta.StComment> jdField_a_of_type_JavaUtilList;
  private uyc jdField_a_of_type_Uyc;
  private uzc jdField_a_of_type_Uzc;
  private vth jdField_a_of_type_Vth;
  private zxl<QCircleReportBean> jdField_a_of_type_Zxl;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 3;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public QCircleCommentListView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleCommentListView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleCommentListView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer == null)) {
      return -1;
    }
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a().getChildCount())
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a().getChildAt(i);
      if ((localObject instanceof QCircleCommentItemView))
      {
        localObject = (QCircleCommentItemView)localObject;
        if ((((QCircleCommentItemView)localObject).a() != null) && (((QCircleCommentItemView)localObject).a().id.get().equals(paramString)))
        {
          paramString = ((QCircleCommentItemView)localObject).a();
          if (paramString == null) {
            break;
          }
          return paramString.getHeight();
        }
      }
      i += 1;
    }
    return -1;
  }
  
  private int a(List<FeedCloudMeta.StComment> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      for (int i = 0;; i = ((FeedCloudMeta.StComment)paramList.next()).replyCount.get() + 1 + i)
      {
        j = i;
        if (!paramList.hasNext()) {
          break;
        }
      }
    }
    int j = 0;
    return j;
  }
  
  private QCircleInitBean a()
  {
    return (QCircleInitBean)((Activity)getContext()).getIntent().getSerializableExtra("key_bundle_common_init_bean");
  }
  
  private FeedCloudMeta.StFeed a()
  {
    if ((this.jdField_a_of_type_Uzc == null) || (this.jdField_a_of_type_Uzc.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null)) {
      return new FeedCloudMeta.StFeed();
    }
    return this.jdField_a_of_type_Uzc.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  }
  
  private vhu a()
  {
    return vhu.a();
  }
  
  private void a(int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a().a(getContext().hashCode(), this.jdField_b_of_type_Int, a(), true, false);
      QLog.d("QCircleCommentPanelPart", 1, "requestCommentList  loadMore  feedId : " + a().id.get());
      return;
    }
    if (a() != null)
    {
      QQCircleFeedBase.StBusiInfoCommentListData localStBusiInfoCommentListData = a();
      a().a(getContext().hashCode(), a(), localStBusiInfoCommentListData);
      QLog.d("QCircleCommentPanelPart", 1, "requestCommentList  refresh(have BusiInfo) feedId : " + a().id.get());
      return;
    }
    a().a(getContext().hashCode(), this.jdField_b_of_type_Int, a(), false, false);
    QLog.d("QCircleCommentPanelPart", 1, "requestCommentList  refresh  feedId : " + a().id.get());
  }
  
  private void b(int paramInt)
  {
    if (b())
    {
      vrg.a(paramInt, 2, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo, e());
      return;
    }
    vrc.a(paramInt, 2, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo, d());
  }
  
  private void b(boolean paramBoolean)
  {
    TextView localTextView;
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_Uyc != null))
    {
      localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
      if ((paramBoolean) || (a())) {
        break label38;
      }
    }
    label38:
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  private boolean b()
  {
    return QCircleReportBean.isContentDetailPage(d());
  }
  
  private String c()
  {
    String str2 = a().id.get();
    String str1 = str2;
    if (a() != null) {
      str1 = str2 + a().comment.id.get() + a().reply.id.get();
    }
    return str1;
  }
  
  private void c()
  {
    Object localObject = a();
    if ((localObject != null) && (((QCircleInitBean)localObject).mActionBean != null) && (((QCircleInitBean)localObject).mActionBean.mShowInputKeyboard) && (!this.jdField_a_of_type_Boolean))
    {
      localObject = a();
      if (localObject != null)
      {
        a(((QQCircleFeedBase.StBusiInfoCommentListData)localObject).comment, ((QQCircleFeedBase.StBusiInfoCommentListData)localObject).reply);
        this.jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if (paramInt > 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(uxx.d(paramInt));
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void c(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.setLayoutManagerType(1, 1);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = ((LinearLayoutManager)this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a());
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a().a(1);
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.setEnableLoadMore(true);
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.setEnableRefresh(false);
    if ((a() instanceof PublicFragmentActivity)) {
      this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.setParentFragment(((PublicFragmentActivity)a()).a());
    }
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a().setNestedScrollingEnabled(true);
    paramView = new ArrayList();
    this.jdField_a_of_type_Uyc = new uyc(null);
    this.jdField_a_of_type_Uyc.b(10);
    this.jdField_a_of_type_Uyc.a(1);
    if (this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean != null) {
      this.jdField_a_of_type_Uyc.a(this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
    }
    if (this.jdField_a_of_type_Zxl != null) {
      this.jdField_a_of_type_Uyc.a(this.jdField_a_of_type_Zxl);
    }
    paramView.add(this.jdField_a_of_type_Uyc);
    this.jdField_a_of_type_Uyc.setOnLoadDataDelegate(new vvf(this));
    this.jdField_a_of_type_Uyc.addOnScrollListener(new vvg(this));
    this.jdField_a_of_type_Uyc.a(this);
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a().setItemAnimator(new zvq());
    ((SimpleItemAnimator)this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a().getItemAnimator()).setSupportsChangeAnimations(false);
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a(paramView);
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.c();
  }
  
  private void d()
  {
    boolean bool = true;
    String str2 = c();
    int i = a().a(a().id.get());
    this.jdField_a_of_type_JavaUtilList = a().a(str2);
    String str1;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (!a()))
    {
      this.jdField_a_of_type_JavaUtilList = a().vecComment.get();
      if (a(a().vecComment.get()) >= i)
      {
        bool = true;
        if ((this.jdField_b_of_type_Int != 4) && (this.jdField_b_of_type_Int != 3)) {
          break label205;
        }
        str1 = null;
        Iterator localIterator = a().busiTranparent.get().iterator();
        label122:
        if (!localIterator.hasNext()) {
          break label181;
        }
        FeedCloudCommon.BytesEntry localBytesEntry = (FeedCloudCommon.BytesEntry)localIterator.next();
        if (!"FeedCommentListAttach".equals(localBytesEntry.key.get())) {
          break label365;
        }
        str1 = localBytesEntry.value.get().toStringUtf8();
      }
    }
    label181:
    label205:
    label365:
    for (;;)
    {
      break label122;
      bool = false;
      break;
      a().a(str2, str1, (ArrayList)a().vecComment.get(), bool);
      if (this.jdField_a_of_type_Uyc != null) {
        this.jdField_a_of_type_Uyc.a(a(), this.jdField_a_of_type_JavaUtilList);
      }
      if ((!bool) && (a())) {
        a(true);
      }
      QLog.d("QCircleCommentPanelPart", 1, "refreshPanelView commentBusiness no commentList  commentList.size : " + this.jdField_a_of_type_JavaUtilList.size());
      for (;;)
      {
        b(bool);
        c(i);
        e();
        return;
        QLog.d("QCircleCommentPanelPart", 1, "refreshPanelView use commentBusiness commentList  commentList.size : " + this.jdField_a_of_type_JavaUtilList.size());
        if (this.jdField_a_of_type_Uyc != null) {
          this.jdField_a_of_type_Uyc.a(a(), this.jdField_a_of_type_JavaUtilList);
        }
        if (a(this.jdField_a_of_type_JavaUtilList) < i) {
          bool = false;
        }
      }
    }
  }
  
  private void d(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer == null) || (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a().getChildCount() <= 0)) {}
    View localView;
    do
    {
      return;
      localView = this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a().getChildAt(this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a().getChildCount() - 1);
    } while ((localView == null) || (!(this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a().findContainingViewHolder(localView) instanceof zyd)));
    localView.setPadding(localView.getPaddingLeft(), localView.getPaddingTop(), localView.getPaddingRight(), paramInt);
    QLog.i("QCircleCommentPanelPart", 1, "changeMarginToFooterHolder   paddingTop: " + paramInt);
  }
  
  private void d(View paramView)
  {
    e(paramView);
  }
  
  private void e()
  {
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout == null) {}
    do
    {
      TextView localTextView;
      do
      {
        return;
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        if (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer != null) {
          this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.setVisibility(0);
        }
        localTextView = (TextView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131371338);
      } while ((localTextView == null) || (this.jdField_a_of_type_Uyc == null) || (this.jdField_a_of_type_Uyc.getItemCount() != 0));
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      localTextView.setText(2131693249);
    } while (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer == null);
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.setVisibility(8);
  }
  
  private void e(View paramView)
  {
    if (paramView == null) {}
    int[] arrayOfInt;
    int i;
    do
    {
      return;
      arrayOfInt = new int[2];
      paramView.getLocationOnScreen(arrayOfInt);
      arrayOfInt[1] += paramView.getHeight();
      i = vtd.a().a();
    } while ((arrayOfInt[1] <= i) || (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView == null));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.scrollBy(0, arrayOfInt[1] - i);
    QLog.i("QCircleCommentPanelPart", 1, "scrollItemToVisble  scrollBy: " + (arrayOfInt[1] - i));
    d(arrayOfInt[1] - i);
    ThreadManager.getUIHandler().postDelayed(new QCircleCommentListView.9(this, paramView, arrayOfInt, i), 1L);
  }
  
  private void f()
  {
    this.jdField_a_of_type_Aage = new aage(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_Aage.a(new vvd(this));
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Aage != null)
    {
      this.jdField_a_of_type_Aage.a();
      this.jdField_a_of_type_Aage = null;
    }
  }
  
  public int a()
  {
    return 2131560679;
  }
  
  public QCircleBlockContainer a()
  {
    return this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer;
  }
  
  public QCircleReportBean a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean != null) {
      return QCircleReportBean.getReportBean("QCircleCommentPanelPart", this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean).clone().setModuleIdStr(b());
    }
    if (this.jdField_a_of_type_Zxl != null) {
      return QCircleReportBean.getReportBean("QCircleCommentPanelPart", (QCircleReportBean)this.jdField_a_of_type_Zxl.getReportBean()).clone().setModuleIdStr(b());
    }
    return new QCircleReportBean();
  }
  
  public ExtraTypeInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  }
  
  protected String a()
  {
    return "QCircleCommentListView";
  }
  
  public QQCircleFeedBase.StBusiInfoCommentListData a()
  {
    try
    {
      QCircleInitBean localQCircleInitBean = a();
      QQCircleFeedBase.StBusiInfoCommentListData localStBusiInfoCommentListData = new QQCircleFeedBase.StBusiInfoCommentListData();
      localStBusiInfoCommentListData.mergeFrom(localQCircleInitBean.getBusiInfoData());
      localStBusiInfoCommentListData.setHasFlag(true);
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment = ((FeedCloudMeta.StComment)localStBusiInfoCommentListData.comment.get());
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply = ((FeedCloudMeta.StReply)localStBusiInfoCommentListData.reply.get());
      return localStBusiInfoCommentListData;
    }
    catch (Exception localException)
    {
      QLog.e("QCircleCommentPanelPart", 1, "getInfoError");
    }
    return null;
  }
  
  public void a()
  {
    if (a()) {
      this.jdField_b_of_type_Int = 4;
    }
  }
  
  public void a(Context paramContext, View paramView)
  {
    a();
    a(paramView);
    c(paramView);
    f();
    if (!a()) {}
    for (boolean bool = true;; bool = false)
    {
      setEnableClickToLoadMore(bool);
      return;
    }
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131364799));
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer = ((QCircleBlockContainer)paramView.findViewById(2131373780));
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a().setPadding(ImmersiveUtils.a(12.0F), 0, 0, 0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364787));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131380412);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131364768));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373786));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new vvc(this));
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, Object paramObject)
  {
    QLog.d("QCircleCommentPanelPart", 1, "onClick, pageId: " + d() + "  parentPageId: " + e());
    switch (paramInt1)
    {
    case 3: 
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 12: 
    default: 
    case 2: 
    case 1: 
    case 4: 
    case 13: 
    case 7: 
    case 10: 
    case 11: 
      do
      {
        do
        {
          return;
          if ((paramObject instanceof FeedCloudMeta.StUser))
          {
            QLog.d("QCircleCommentPanelPart", 1, "onClick nickName, feedId: " + a().id.get() + " userId: " + ((FeedCloudMeta.StUser)paramObject).id.get());
            uxo.a((FeedCloudMeta.StUser)paramObject, a().clone().setElementIdStr("portrait"));
          }
          b(15);
          return;
          if ((paramObject instanceof FeedCloudMeta.StUser))
          {
            QLog.d("QCircleCommentPanelPart", 1, "onClick avatar, feedId: " + a().id.get() + " userId: " + ((FeedCloudMeta.StUser)paramObject).id.get());
            uxo.a((FeedCloudMeta.StUser)paramObject, a().clone().setElementIdStr("portrait"));
          }
          b(14);
          return;
          if ((paramObject instanceof FeedCloudMeta.StComment))
          {
            paramObject = (FeedCloudMeta.StComment)paramObject;
            QLog.d("QCircleCommentPanelPart", 1, "onClick comment, feedId: " + a().id.get() + " commentId: " + paramObject.id.get());
            a(paramObject, null);
            d(paramView);
          }
          b(11);
          this.jdField_a_of_type_Int = 11;
          return;
          if ((paramObject instanceof FeedCloudMeta.StComment))
          {
            paramView = (FeedCloudMeta.StComment)paramObject;
            QLog.d("QCircleCommentPanelPart", 1, "onClick replyTextButton, feedId: " + a().id.get() + " commentId: " + paramView.id.get());
            a(paramView, null);
          }
          b(13);
          this.jdField_a_of_type_Int = 13;
          return;
          if ((paramObject instanceof Object[]))
          {
            localObject = (Object[])paramObject;
            if ((localObject.length > 1) && (localObject[0] != null) && (localObject[1] != null) && ((localObject[0] instanceof FeedCloudMeta.StComment)) && ((localObject[1] instanceof FeedCloudMeta.StReply)))
            {
              paramObject = (FeedCloudMeta.StComment)localObject[0];
              localObject = (FeedCloudMeta.StReply)localObject[1];
              QLog.d("QCircleCommentPanelPart", 1, "onClick reply, feedId: " + a().id.get() + " commentId: " + paramObject.id.get() + " replyId: " + ((FeedCloudMeta.StReply)localObject).id.get());
              a(paramObject, (FeedCloudMeta.StReply)localObject);
              d(paramView);
            }
          }
          b(12);
          this.jdField_a_of_type_Int = 12;
          return;
          if ((paramObject instanceof Object[]))
          {
            paramObject = (Object[])paramObject;
            if ((paramObject.length > 1) && ((paramObject[0] instanceof FeedCloudMeta.StComment)) && ((paramObject[1] instanceof Integer)))
            {
              paramView = (FeedCloudMeta.StComment)paramObject[0];
              paramObject = (Integer)paramObject[1];
              this.jdField_a_of_type_Uyc.a(paramInt2, paramObject.intValue());
              QLog.d("QCircleCommentPanelPart", 1, "onClick more reply, feedId: " + a().id.get() + " commentId: " + paramView.id.get());
            }
          }
          b(52);
          return;
        } while (!(paramObject instanceof Object[]));
        paramObject = (Object[])paramObject;
      } while ((paramObject.length <= 1) || (!(paramObject[0] instanceof FeedCloudMeta.StComment)) || (!(paramObject[1] instanceof Integer)));
      paramView = (FeedCloudMeta.StComment)paramObject[0];
      paramObject = (Integer)paramObject[1];
      this.jdField_a_of_type_Uyc.b(paramInt2, paramObject.intValue());
      this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.post(new QCircleCommentListView.4(this, paramInt2));
      QLog.d("QCircleCommentPanelPart", 1, "onClick less reply, feedId: " + a().id.get() + " commentId: " + paramView.id.get());
      return;
    case 14: 
      b(50);
      localObject = "";
      if ((paramObject instanceof FeedCloudMeta.StComment)) {
        paramView = ((FeedCloudMeta.StComment)paramObject).postUser.id.get();
      }
      for (;;)
      {
        vrr.a().a(new vrt().a("likecommentbutton").b("likecomment").a(this.jdField_a_of_type_Uzc.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed).a(a()).a(b()).c(paramView));
        return;
        paramView = (View)localObject;
        if ((paramObject instanceof Object[]))
        {
          paramObject = (Object[])paramObject;
          paramView = (View)localObject;
          if (paramObject.length > 1)
          {
            paramView = (View)localObject;
            if (paramObject[1] != null)
            {
              paramView = (View)localObject;
              if ((paramObject[1] instanceof FeedCloudMeta.StReply)) {
                paramView = ((FeedCloudMeta.StReply)paramObject[1]).postUser.id.get();
              }
            }
          }
        }
      }
    }
    b(51);
    Object localObject = "";
    if ((paramObject instanceof FeedCloudMeta.StComment)) {
      paramView = ((FeedCloudMeta.StComment)paramObject).postUser.id.get();
    }
    for (;;)
    {
      vrr.a().a(new vrt().a("likecommentbutton").b("unlikecomment").a(this.jdField_a_of_type_Uzc.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed).a(a()).a(b()).c(paramView));
      return;
      paramView = (View)localObject;
      if ((paramObject instanceof Object[]))
      {
        paramObject = (Object[])paramObject;
        paramView = (View)localObject;
        if (paramObject.length > 1)
        {
          paramView = (View)localObject;
          if (paramObject[1] != null)
          {
            paramView = (View)localObject;
            if ((paramObject[1] instanceof FeedCloudMeta.StReply)) {
              paramView = ((FeedCloudMeta.StReply)paramObject[1]).postUser.id.get();
            }
          }
        }
      }
    }
  }
  
  public void a(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    paramStReply = new uzk(a(), paramStComment, paramStReply);
    this.jdField_a_of_type_Vth = new vvs(this, paramStComment);
    vtd.a().a((Activity)getContext(), paramStReply, this.jdField_a_of_type_Vth, b());
  }
  
  protected void a(uzc paramuzc)
  {
    this.jdField_a_of_type_Uzc = paramuzc;
    setFeedData(this.jdField_a_of_type_Uzc.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed);
    setExtraTypeInfo(this.jdField_a_of_type_Uzc.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    d();
    a(this.jdField_a_of_type_Uzc.c);
  }
  
  public boolean a()
  {
    QCircleBaseFragment localQCircleBaseFragment = uxx.a(getContext());
    if ((localQCircleBaseFragment != null) && (localQCircleBaseFragment.a().a(vll.class.getSimpleName()) != null)) {
      return ((vll)localQCircleBaseFragment.a().a(vll.class.getSimpleName())).b();
    }
    return false;
  }
  
  public int b()
  {
    if ((this.jdField_a_of_type_Uzc != null) && (this.jdField_a_of_type_Uzc.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null)) {
      return this.jdField_a_of_type_Uzc.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.mDataPosition;
    }
    return 0;
  }
  
  protected String b()
  {
    return "commentlist";
  }
  
  public void b(View paramView, int paramInt1, int paramInt2, Object paramObject)
  {
    QLog.d("QCircleCommentPanelPart", 1, "onLongClick, pageId: " + d() + "  parentPageId: " + e());
    vvh localvvh = new vvh(this);
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramObject instanceof FeedCloudMeta.StComment));
        b(45);
        paramObject = (FeedCloudMeta.StComment)paramObject;
        QLog.d("QCircleCommentPanelPart", 1, "onLongClick comment, feedId: " + a().id.get() + " commentId: " + paramObject.id.get());
        uxp.a().a(paramView, a(), paramObject, new vvi(this, paramObject), localvvh);
        return;
      } while (!(paramObject instanceof Object[]));
      localObject = (Object[])paramObject;
    } while ((localObject.length <= 1) || (localObject[0] == null) || (localObject[1] == null) || (!(localObject[0] instanceof FeedCloudMeta.StComment)) || (!(localObject[1] instanceof FeedCloudMeta.StReply)));
    paramObject = (FeedCloudMeta.StComment)localObject[0];
    Object localObject = (FeedCloudMeta.StReply)localObject[1];
    QLog.d("QCircleCommentPanelPart", 1, "onLongClick reply, feedId: " + a().id.get() + " commentId: " + paramObject.id.get() + " replyId: " + ((FeedCloudMeta.StReply)localObject).id.get());
    uxp.a().a(paramView, a(), (FeedCloudMeta.StReply)localObject, new vvp(this, (FeedCloudMeta.StReply)localObject, paramObject), localvvh);
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean != null) {
      return QCircleReportBean.getPageId("QCircleCommentPanelPart", this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
    }
    if (this.jdField_a_of_type_Zxl != null) {
      return QCircleReportBean.getPageId("QCircleCommentPanelPart", (QCircleReportBean)this.jdField_a_of_type_Zxl.getReportBean());
    }
    return 0;
  }
  
  public int e()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean != null) {
      return QCircleReportBean.getParentPageId("QCircleCommentPanelPart", this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
    }
    if (this.jdField_a_of_type_Zxl != null) {
      return QCircleReportBean.getParentPageId("QCircleCommentPanelPart", (QCircleReportBean)this.jdField_a_of_type_Zxl.getReportBean());
    }
    return 0;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleCommentUpdateEvent.class);
    return localArrayList;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    zwp.a().a(this);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    QLog.d("QCircleCommentPanelPart", 1, "onClick, pageId: " + d() + "  parentPageId: " + e());
    switch (i)
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
      b(61);
      this.jdField_a_of_type_Int = 61;
      QLog.d("QCircleCommentPanelPart", 1, "onClick iv_comment, feedId: " + a().id.get());
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    zwp.a().b(this);
    g();
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if ((paramSimpleBaseEvent instanceof QCircleCommentUpdateEvent))
    {
      paramSimpleBaseEvent = (QCircleCommentUpdateEvent)paramSimpleBaseEvent;
      switch (paramSimpleBaseEvent.eventStatus)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return;
                      } while (!paramSimpleBaseEvent.feedId.equals(c()));
                      if (paramSimpleBaseEvent.needShowCommentPanel) {
                        c();
                      }
                      d();
                      if (a().a(a().id.get()) == null) {
                        bool1 = true;
                      }
                      if (this.jdField_a_of_type_Uyc != null)
                      {
                        this.jdField_a_of_type_Uyc.getLoadInfo().a(bool1);
                        this.jdField_a_of_type_Uyc.notifyLoadingComplete(true);
                      }
                      b(bool1);
                      return;
                    } while (!paramSimpleBaseEvent.feedId.equals(c()));
                    if (a().a(a().id.get()) == null) {}
                    for (bool1 = true;; bool1 = false)
                    {
                      if ((this.jdField_a_of_type_Uyc != null) && (paramSimpleBaseEvent.commentList != null))
                      {
                        this.jdField_a_of_type_Uyc.a(paramSimpleBaseEvent.commentList);
                        paramSimpleBaseEvent = this.jdField_a_of_type_Uyc.getLoadInfo();
                        if (a().a(a().id.get()) == null) {
                          bool2 = true;
                        }
                        paramSimpleBaseEvent.a(bool2);
                        this.jdField_a_of_type_Uyc.notifyLoadingComplete(true);
                        b(bool1);
                      }
                      if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
                        break;
                      }
                      this.jdField_b_of_type_AndroidWidgetTextView.setClickable(true);
                      return;
                    }
                  } while (!paramSimpleBaseEvent.feedId.equals(a().id.get()));
                  if ((this.jdField_a_of_type_Uyc != null) && (paramSimpleBaseEvent.comment != null)) {
                    this.jdField_a_of_type_Uyc.a(paramSimpleBaseEvent.fakeCommentId, paramSimpleBaseEvent.comment);
                  }
                  c(paramSimpleBaseEvent.commentTotalNum);
                  return;
                } while (!paramSimpleBaseEvent.feedId.equals(a().id.get()));
                if ((this.jdField_a_of_type_Uyc != null) && (paramSimpleBaseEvent.comment != null)) {
                  this.jdField_a_of_type_Uyc.a(paramSimpleBaseEvent.comment.id.get());
                }
                c(paramSimpleBaseEvent.commentTotalNum);
                e();
                return;
              } while (!paramSimpleBaseEvent.feedId.equals(a().id.get()));
              if ((this.jdField_a_of_type_Uyc != null) && (paramSimpleBaseEvent.comment != null) && (paramSimpleBaseEvent.reply != null)) {
                this.jdField_a_of_type_Uyc.a(paramSimpleBaseEvent.comment.id.get(), paramSimpleBaseEvent.fakeReplyId, paramSimpleBaseEvent.reply);
              }
              c(paramSimpleBaseEvent.commentTotalNum);
              return;
            } while (!paramSimpleBaseEvent.feedId.equals(a().id.get()));
            if ((this.jdField_a_of_type_Uyc != null) && (paramSimpleBaseEvent.comment != null) && (paramSimpleBaseEvent.reply != null)) {
              this.jdField_a_of_type_Uyc.a(paramSimpleBaseEvent.comment.id.get(), paramSimpleBaseEvent.reply.id.get());
            }
            c(paramSimpleBaseEvent.commentTotalNum);
            return;
          } while (!paramSimpleBaseEvent.feedId.equals(a().id.get()));
          if ((this.jdField_a_of_type_Uyc != null) && (paramSimpleBaseEvent.comment != null)) {
            this.jdField_a_of_type_Uyc.c(paramSimpleBaseEvent.comment.id.get());
          }
          c(paramSimpleBaseEvent.commentTotalNum);
          return;
        } while (!paramSimpleBaseEvent.feedId.equals(a().id.get()));
        if ((this.jdField_a_of_type_Uyc != null) && (paramSimpleBaseEvent.comment != null)) {
          this.jdField_a_of_type_Uyc.b(paramSimpleBaseEvent.comment.id.get());
        }
        c(paramSimpleBaseEvent.commentTotalNum);
        return;
      } while ((!paramSimpleBaseEvent.feedId.equals(a().id.get())) || (this.jdField_a_of_type_Uyc == null));
      this.jdField_a_of_type_Uyc.a(paramSimpleBaseEvent.comment.id.get());
      return;
    } while ((!paramSimpleBaseEvent.feedId.equals(a().id.get())) || (this.jdField_a_of_type_Uyc == null));
    this.jdField_a_of_type_Uyc.a(paramSimpleBaseEvent.comment.id.get(), paramSimpleBaseEvent.reply.id.get());
  }
  
  public void setEnableClickToLoadMore(boolean paramBoolean)
  {
    boolean bool2 = true;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer != null)
    {
      localObject = this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer;
      if (paramBoolean) {
        break label113;
      }
      bool1 = true;
      ((QCircleBlockContainer)localObject).setEnableLoadMore(bool1);
      localObject = this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a();
      if (paramBoolean) {
        break label118;
      }
      bool1 = true;
      label42:
      ((NestScrollRecyclerView)localObject).setHasFixedSize(bool1);
      localObject = this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a();
      if (paramBoolean) {
        break label123;
      }
      bool1 = true;
      label63:
      ((NestScrollRecyclerView)localObject).setNestedScrollingEnabled(bool1);
      localObject = this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a();
      if (paramBoolean) {
        break label128;
      }
    }
    label128:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((NestScrollRecyclerView)localObject).setNeedLimitHeightWidth(bool1);
      if (!paramBoolean) {
        this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a().setNestScrollDelegate(new vve(this));
      }
      return;
      label113:
      bool1 = false;
      break;
      label118:
      bool1 = false;
      break label42;
      label123:
      bool1 = false;
      break label63;
    }
  }
  
  public void setExtraTypeInfo(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = paramExtraTypeInfo;
  }
  
  public void setFeedData(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null) {
      a().a(paramStFeed.id.get(), paramStFeed.commentCount.get());
    }
  }
  
  public void setParentRecyclerView(RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
  
  public void setReportBean(QCircleReportBean paramQCircleReportBean)
  {
    if (this.jdField_a_of_type_Uyc != null) {
      this.jdField_a_of_type_Uyc.a(paramQCircleReportBean);
    }
  }
  
  public void setReportBeanAgent(zxl<QCircleReportBean> paramzxl)
  {
    this.jdField_a_of_type_Zxl = paramzxl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleCommentListView
 * JD-Core Version:    0.7.0.1
 */