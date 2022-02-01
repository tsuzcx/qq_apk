package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.ComponentView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell.CellListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.GalleryPGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCPicInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCPicInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.WendaInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.SquareCornerTextImageView;
import com.tencent.biz.pubaccount.readinjoy.view.SquareCornerTextImageView.PicInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.GridView;
import com.tencent.widget.TraceUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ComponentContentGridImage
  extends GridView
  implements ComponentView
{
  public int a;
  private CmpCtxt jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt;
  private ComponentContentGridImage.Adapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage$Adapter;
  private ComponentContentGridImage.OnGalleryItemClickListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage$OnGalleryItemClickListener;
  private ComponentContentGridImage.OnNoItemClickListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage$OnNoItemClickListener;
  protected Object a;
  private boolean jdField_a_of_type_Boolean = false;
  public int b;
  private int c;
  
  public ComponentContentGridImage(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ComponentContentGridImage(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = AIOUtils.a(12.0F, getResources());
    this.jdField_b_of_type_Int = AIOUtils.a(12.0F, getResources());
    a(paramContext);
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    int j = 9;
    int i = paramInt2;
    if (paramInt2 == 9)
    {
      paramInt2 = j;
      if (paramInt1 < 9) {
        i = 3;
      }
    }
    else
    {
      if ((i != 3) || (paramInt1 < 3)) {
        break label35;
      }
      paramInt2 = 3;
    }
    return paramInt2;
    label35:
    return 1;
  }
  
  public static ComponentContentGridImage.Model a(ArticleInfo paramArticleInfo)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
    SocializeFeedsInfo.UGCPicInfo localUGCPicInfo;
    if (paramArticleInfo.hasNext()) {
      localUGCPicInfo = (SocializeFeedsInfo.UGCPicInfo)paramArticleInfo.next();
    }
    for (;;)
    {
      try
      {
        int i = localArrayList1.size();
        if (i >= 9) {
          return new ComponentContentGridImage.Model.Builder().a(localArrayList1).b(localArrayList2).a();
        }
        i = localUGCPicInfo.jdField_a_of_type_Int;
        int j = localUGCPicInfo.jdField_b_of_type_Int;
        URL localURL = new URL(localUGCPicInfo.jdField_c_of_type_JavaLangString);
        if (localUGCPicInfo.jdField_c_of_type_Int != 1) {
          break label207;
        }
        bool = true;
        localArrayList1.add(new SquareCornerTextImageView.PicInfo(i, j, localURL, bool));
        localArrayList2.add(new URL(localUGCPicInfo.jdField_b_of_type_JavaLangString));
      }
      catch (MalformedURLException localMalformedURLException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ComponentContentGridImage", 2, "Malformed URL: " + localMalformedURLException.getMessage());
      break;
      label207:
      boolean bool = false;
    }
  }
  
  public static ComponentContentGridImage.Model a(Object paramObject, int paramInt)
  {
    ComponentContentGridImage.Model.Builder localBuilder = new ComponentContentGridImage.Model.Builder();
    if ((paramObject instanceof IReadInJoyModel))
    {
      paramObject = ((IReadInJoyModel)paramObject).a();
      a(paramInt, localBuilder, paramObject);
      if (paramObject != null)
      {
        a(localBuilder, paramObject);
        b(localBuilder, paramObject);
      }
      localBuilder.a(paramInt);
    }
    return localBuilder.a();
  }
  
  private ArrayList<String> a(List<URL> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = ((URL)localIterator.next()).toString();
      paramList = str;
      if (str.contains("https")) {
        paramList = str.replaceFirst("https", "http");
      }
      localArrayList.add(paramList);
    }
    return localArrayList;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_JavaLangObject instanceof IReadInJoyModel))
    {
      ArticleInfo localArticleInfo = ((IReadInJoyModel)this.jdField_a_of_type_JavaLangObject).a();
      if (localArticleInfo != null)
      {
        RIJFrameworkReportManager.a(localArticleInfo, paramInt1, paramInt2);
        paramInt2 = -1;
        paramInt1 = paramInt2;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt != null)
        {
          paramInt1 = paramInt2;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a != null) {
            paramInt1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.e();
          }
        }
        RIJFrameworkReportManager.a(localArticleInfo, paramInt1);
      }
    }
    else
    {
      return;
    }
    QLog.d("ComponentContentGridImage", 1, "ComponentContentGridImage report data, articleInfo is null!");
  }
  
  static void a(int paramInt, ComponentContentGridImage.Model.Builder paramBuilder, ArticleInfo paramArticleInfo)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3;
    int i;
    boolean bool2;
    boolean bool1;
    long l1;
    if ((paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      localArrayList3 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList;
      i = localArrayList3.size();
      long l2 = 0L;
      bool2 = false;
      if ((paramInt != 62) && (paramInt != 63) && (paramInt != 64))
      {
        bool1 = bool2;
        l1 = l2;
        if (paramInt != 65) {
          break label486;
        }
      }
      bool1 = bool2;
      l1 = l2;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$GalleryPGCFeedsInfo == null) {
        break label486;
      }
      bool1 = true;
      l2 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$GalleryPGCFeedsInfo.a;
      l1 = l2;
      if (i <= 0) {
        break label486;
      }
      paramInt = a(i, paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int);
      bool1 = true;
      l1 = l2;
      i = 0;
    }
    for (;;)
    {
      if (i < paramInt) {}
      try
      {
        int j = localArrayList2.size();
        if (j >= 9)
        {
          paramBuilder.b(localArrayList1);
          paramBuilder.a(localArrayList2);
          return;
        }
        SocializeFeedsInfo.PGCPicInfo localPGCPicInfo = (SocializeFeedsInfo.PGCPicInfo)localArrayList3.get(i);
        if ((localPGCPicInfo.jdField_b_of_type_JavaLangString == null) && (localPGCPicInfo.jdField_c_of_type_JavaLangString == null)) {
          break label491;
        }
        a(i, localPGCPicInfo);
        TraceUtils.traceBegin("ComponentContentGridImage.setImageUrl");
        label308:
        int k;
        if (localPGCPicInfo.jdField_b_of_type_JavaLangString != null)
        {
          paramArticleInfo = localPGCPicInfo.jdField_b_of_type_JavaLangString;
          URL localURL = new URL(paramArticleInfo);
          if (localPGCPicInfo.jdField_c_of_type_JavaLangString == null) {
            break label447;
          }
          paramArticleInfo = localPGCPicInfo.jdField_c_of_type_JavaLangString;
          paramArticleInfo = new URL(paramArticleInfo);
          TraceUtils.traceEnd();
          localArrayList1.add(localURL);
          TraceUtils.traceBegin("ComponentContentGridImage.PicInfo");
          j = localPGCPicInfo.jdField_a_of_type_Int;
          k = localPGCPicInfo.jdField_b_of_type_Int;
          if (localPGCPicInfo.jdField_c_of_type_Int != 1) {
            break label456;
          }
        }
        label447:
        label456:
        for (bool2 = true;; bool2 = false)
        {
          paramArticleInfo = new SquareCornerTextImageView.PicInfo(j, k, paramArticleInfo, bool2);
          if ((bool1) && (i == paramInt - 1))
          {
            paramArticleInfo.b(bool1);
            paramArticleInfo.a(l1 + HardCodeUtil.a(2131702370));
          }
          TraceUtils.traceEnd();
          localArrayList2.add(paramArticleInfo);
          break label491;
          paramArticleInfo = localPGCPicInfo.jdField_c_of_type_JavaLangString;
          break;
          paramArticleInfo = localPGCPicInfo.jdField_b_of_type_JavaLangString;
          break label308;
        }
        QLog.d("Q.readinjoy.ui", 2, "url error");
      }
      catch (Exception paramArticleInfo)
      {
        paramArticleInfo.printStackTrace();
        if (!QLog.isColorLevel()) {
          break label491;
        }
      }
      break label491;
      label486:
      paramInt = i;
      break;
      label491:
      i += 1;
    }
  }
  
  private static void a(int paramInt, SocializeFeedsInfo.PGCPicInfo paramPGCPicInfo)
  {
    TraceUtils.traceBegin("ComponentContentGridImage.log");
    if (QLog.isColorLevel())
    {
      if (paramPGCPicInfo.jdField_b_of_type_JavaLangString != null) {
        QLog.d("Q.readinjoy.ui", 2, "Grid Image url [" + paramInt + "]: " + paramPGCPicInfo.jdField_b_of_type_JavaLangString);
      }
      if (paramPGCPicInfo.jdField_c_of_type_JavaLangString != null) {
        QLog.d("Q.readinjoy.ui", 2, "Grid thumbNail Image url [" + paramInt + "]: " + paramPGCPicInfo.jdField_c_of_type_JavaLangString);
      }
    }
    TraceUtils.traceEnd();
  }
  
  private void a(int paramInt, List<URL> paramList)
  {
    String str1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage$Adapter.a();
    String str2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage$Adapter.b();
    ArticleInfo localArticleInfo = null;
    if ((this.jdField_a_of_type_JavaLangObject instanceof IReadInJoyModel)) {
      localArticleInfo = ((IReadInJoyModel)this.jdField_a_of_type_JavaLangObject).a();
    }
    if (RIJFeedsType.m(localArticleInfo))
    {
      str1 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$WendaInfo.f;
      str2 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$WendaInfo.jdField_b_of_type_JavaLangString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.ui", 2, new Object[] { "ReadInJoy grid image show content url and title, articleUrl: " + str1, " articleTitle: " + str2 });
    }
    if ((localArticleInfo != null) && (localArticleInfo.isPGCShortContent())) {}
    try
    {
      localArticleInfo.clickArea = a();
      RIJFrameworkReportManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().a().getContext(), localArticleInfo, (int)localArticleInfo.mChannelID);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().a() != null)) {
        TroopNoticeJsHandler.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().a(), paramInt, a(paramList), null, null, false, false, "4", 100, null, str1, str2, localArticleInfo, "");
      }
      if (paramList != null) {
        a(paramInt, paramList.size());
      }
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        QLog.e("ComponentContentGridImage", 2, localNullPointerException.getLocalizedMessage());
      }
    }
  }
  
  static void a(ComponentContentGridImage.Model.Builder paramBuilder, ArticleInfo paramArticleInfo)
  {
    if (!TextUtils.isEmpty(paramArticleInfo.mArticleContentUrl)) {
      paramBuilder.a(paramArticleInfo.mArticleContentUrl);
    }
  }
  
  static void b(ComponentContentGridImage.Model.Builder paramBuilder, ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo != null) && (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaLangString))) {
      paramBuilder.b(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaLangString);
    }
    while (TextUtils.isEmpty(paramArticleInfo.mTitle)) {
      return;
    }
    paramBuilder.b(paramArticleInfo.mTitle);
  }
  
  protected int a()
  {
    return 9;
  }
  
  public void a()
  {
    setOnItemClickListener(new ComponentContentGridImage.1(this));
  }
  
  public void a(Context paramContext)
  {
    setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    setNumColumns(3);
    setVerticalSpacing(AIOUtils.a(1.0F, paramContext.getResources()));
    setHorizontalSpacing(AIOUtils.a(1.0F, paramContext.getResources()));
    setSelector(17170445);
    a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt = new CmpCtxt();
  }
  
  protected void a(View paramView)
  {
    ((SquareCornerTextImageView)paramView).jdField_a_of_type_Boolean = false;
  }
  
  public void a(FeedItemCell.CellListener paramCellListener) {}
  
  public void a(Object paramObject)
  {
    if (!(paramObject instanceof ComponentContentGridImage.Model))
    {
      QLog.e("ComponentContentGridImage", 1, "unsupported model type.", new IllegalArgumentException());
      return;
    }
    this.jdField_c_of_type_Int = ((ComponentContentGridImage.Model)paramObject).a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage$Adapter == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage$Adapter = new ComponentContentGridImage.Adapter(this, (ComponentContentGridImage.Model)paramObject);
      setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage$Adapter);
    }
    for (;;)
    {
      b();
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt == null) || (!(this.jdField_a_of_type_JavaLangObject instanceof IReadInJoyModel))) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a((IReadInJoyModel)this.jdField_a_of_type_JavaLangObject);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage$Adapter.a((ComponentContentGridImage.Model)paramObject);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage$Adapter.notifyDataSetChanged();
    }
  }
  
  public void b()
  {
    int i = getCount();
    if (i == 1) {
      setNumColumns(1);
    }
    for (;;)
    {
      ViewGroup.LayoutParams localLayoutParams2 = getLayoutParams();
      ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
      if (localLayoutParams2 == null) {
        localLayoutParams1 = new ViewGroup.LayoutParams(-1, -2);
      }
      setLayoutParams(localLayoutParams1);
      return;
      if ((i == 2) || (i == 4)) {
        setNumColumns(2);
      } else {
        setNumColumns(3);
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      if (pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()) != -1) {
        break label87;
      }
    }
    label87:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      if ((pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()) == -1) && (paramMotionEvent.getAction() == 1) && (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage$OnNoItemClickListener != null)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage$OnNoItemClickListener.a();
      }
      return super.dispatchTouchEvent(paramMotionEvent);
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (getLayoutParams().height == -2) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(536870911, -2147483648);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setGalleryClickListener(ComponentContentGridImage.OnGalleryItemClickListener paramOnGalleryItemClickListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage$OnGalleryItemClickListener = paramOnGalleryItemClickListener;
  }
  
  public void setMIReadInJoyModel(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void setOnNoItemClickListener(ComponentContentGridImage.OnNoItemClickListener paramOnNoItemClickListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage$OnNoItemClickListener = paramOnNoItemClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage
 * JD-Core Version:    0.7.0.1
 */