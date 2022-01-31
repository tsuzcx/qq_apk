package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.ComponentView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell.CellListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCPicInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCPicInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.SquareCornerTextImageView.PicInfo;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.GridView;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lvj;
import lvk;

public class ComponentContentGridImage
  extends GridView
  implements ComponentView
{
  private CmpCtxt jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt;
  private ComponentContentGridImage.OnNoItemClickListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage$OnNoItemClickListener;
  private Object jdField_a_of_type_JavaLangObject;
  private lvk jdField_a_of_type_Lvk;
  private boolean jdField_a_of_type_Boolean;
  
  public ComponentContentGridImage(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ComponentContentGridImage(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
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
        i = localUGCPicInfo.a;
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
  
  public static ComponentContentGridImage.Model a(Object paramObject)
  {
    ComponentContentGridImage.Model.Builder localBuilder = new ComponentContentGridImage.Model.Builder();
    ArticleInfo localArticleInfo;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    int i;
    if ((paramObject instanceof IReadInJoyModel))
    {
      localArticleInfo = ((IReadInJoyModel)paramObject).a();
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      if ((localArticleInfo != null) && (localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        localArrayList3 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList;
        i = 0;
      }
    }
    label407:
    label544:
    for (;;)
    {
      if (i < localArrayList3.size()) {}
      try
      {
        j = localArrayList2.size();
        if (j < 9) {
          break label242;
        }
        localBuilder.b(localArrayList1);
        localBuilder.a(localArrayList2);
        if (localArticleInfo != null)
        {
          if (!TextUtils.isEmpty(localArticleInfo.mArticleContentUrl)) {
            localBuilder.a(localArticleInfo.mArticleContentUrl);
          }
          if ((localArticleInfo.mSocialFeedInfo == null) || (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo == null) || (TextUtils.isEmpty(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaLangString))) {
            break label519;
          }
          localBuilder.b(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaLangString);
        }
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          int j;
          SocializeFeedsInfo.PGCPicInfo localPGCPicInfo;
          URL localURL;
          int k;
          boolean bool;
          paramObject.printStackTrace();
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.readinjoy.ui", 2, "url error");
          break;
          if (!TextUtils.isEmpty(localArticleInfo.mTitle)) {
            localBuilder.b(localArticleInfo.mTitle);
          }
        }
        i += 1;
      }
      return localBuilder.a();
      label242:
      localPGCPicInfo = (SocializeFeedsInfo.PGCPicInfo)localArrayList3.get(i);
      if ((localPGCPicInfo.jdField_b_of_type_JavaLangString != null) || (localPGCPicInfo.jdField_c_of_type_JavaLangString != null))
      {
        if (QLog.isColorLevel())
        {
          if (localPGCPicInfo.jdField_b_of_type_JavaLangString != null) {
            QLog.d("Q.readinjoy.ui", 2, "Grid Image url [" + i + "]: " + localPGCPicInfo.jdField_b_of_type_JavaLangString);
          }
          if (localPGCPicInfo.jdField_c_of_type_JavaLangString != null) {
            QLog.d("Q.readinjoy.ui", 2, "Grid thumbNail Image url [" + i + "]: " + localPGCPicInfo.jdField_c_of_type_JavaLangString);
          }
        }
        if (localPGCPicInfo.jdField_b_of_type_JavaLangString != null)
        {
          paramObject = localPGCPicInfo.jdField_b_of_type_JavaLangString;
          localURL = new URL(paramObject);
          if (localPGCPicInfo.jdField_c_of_type_JavaLangString == null) {
            break label482;
          }
          paramObject = localPGCPicInfo.jdField_c_of_type_JavaLangString;
          paramObject = new URL(paramObject);
          localArrayList1.add(localURL);
          j = localPGCPicInfo.a;
          k = localPGCPicInfo.jdField_b_of_type_Int;
          if (localPGCPicInfo.jdField_c_of_type_Int != 1) {
            break label491;
          }
        }
        label482:
        label491:
        for (bool = true;; bool = false)
        {
          localArrayList2.add(new SquareCornerTextImageView.PicInfo(j, k, paramObject, bool));
          break label544;
          paramObject = localPGCPicInfo.jdField_c_of_type_JavaLangString;
          break;
          paramObject = localPGCPicInfo.jdField_b_of_type_JavaLangString;
          break label407;
        }
      }
    }
  }
  
  private ArrayList a(List paramList)
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
        ReadInJoyBaseAdapter.a(localArticleInfo, paramInt1, paramInt2);
        paramInt2 = -1;
        paramInt1 = paramInt2;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt != null)
        {
          paramInt1 = paramInt2;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a != null) {
            paramInt1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.e();
          }
        }
        ReadInJoyBaseAdapter.b(localArticleInfo, paramInt1);
      }
    }
    else
    {
      return;
    }
    QLog.d("ComponentContentGridImage", 1, "ComponentContentGridImage report data, articleInfo is null!");
  }
  
  private void a(int paramInt, List paramList)
  {
    String str1 = this.jdField_a_of_type_Lvk.a();
    String str2 = this.jdField_a_of_type_Lvk.b();
    if ((this.jdField_a_of_type_JavaLangObject instanceof IReadInJoyModel)) {}
    for (ArticleInfo localArticleInfo = ((IReadInJoyModel)this.jdField_a_of_type_JavaLangObject).a();; localArticleInfo = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.ui", 2, new Object[] { "ReadInJoy grid image show content url and title, articleUrl: " + str1, " articleTitle: " + str2 });
      }
      TroopNoticeJsHandler.a((Activity)getContext(), paramInt, a(paramList), null, null, false, false, "4", 100, null, str1, str2, localArticleInfo);
      if (paramList != null) {
        a(paramInt, paramList.size());
      }
      return;
    }
  }
  
  public void a()
  {
    setOnItemClickListener(new lvj(this));
  }
  
  public void a(Context paramContext)
  {
    setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    setNumColumns(3);
    setVerticalSpacing(AIOUtils.a(3.0F, paramContext.getResources()));
    setHorizontalSpacing(AIOUtils.a(3.0F, paramContext.getResources()));
    setSelector(17170445);
    a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt = new CmpCtxt();
  }
  
  public void a(FeedItemCell.CellListener paramCellListener) {}
  
  public void a(Object paramObject)
  {
    if (!(paramObject instanceof ComponentContentGridImage.Model)) {
      throw new IllegalArgumentException("unsupported model type.");
    }
    if (this.jdField_a_of_type_Lvk == null)
    {
      this.jdField_a_of_type_Lvk = new lvk((ComponentContentGridImage.Model)paramObject);
      setAdapter(this.jdField_a_of_type_Lvk);
    }
    for (;;)
    {
      b();
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt != null) && ((this.jdField_a_of_type_JavaLangObject instanceof IReadInJoyModel))) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a((IReadInJoyModel)this.jdField_a_of_type_JavaLangObject);
      }
      return;
      this.jdField_a_of_type_Lvk.a((ComponentContentGridImage.Model)paramObject);
      this.jdField_a_of_type_Lvk.notifyDataSetChanged();
    }
  }
  
  public void b()
  {
    int i = getCount();
    ViewGroup.LayoutParams localLayoutParams;
    if (i == 1)
    {
      setNumColumns(1);
      localLayoutParams = getLayoutParams();
      if (i != 4) {
        break label184;
      }
      if ((localLayoutParams != null) && (localLayoutParams.width == -1))
      {
        i = (int)DeviceInfoUtil.n() - AIOUtils.a(24.0F, getResources());
        localLayoutParams.width = ((i - AIOUtils.a(6.0F, getResources())) * 2 / 3 + AIOUtils.a(3.0F, getResources()));
        if (QLog.isColorLevel()) {
          QLog.d("ComponentContentGridImage", 2, new Object[] { "contentWidth: ", Integer.valueOf(i), ", layout.width: ", Integer.valueOf(localLayoutParams.width), ", MinOfWidthAndHeight: ", Long.valueOf(DeviceInfoUtil.n()) });
        }
        if (localLayoutParams.width > 0) {
          setLayoutParams(localLayoutParams);
        }
      }
    }
    label184:
    while ((localLayoutParams == null) || (localLayoutParams.width == -1))
    {
      return;
      if ((i == 2) || (i == 4))
      {
        setNumColumns(2);
        break;
      }
      setNumColumns(3);
      break;
    }
    localLayoutParams.width = -1;
    setLayoutParams(localLayoutParams);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      if (pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()) != -1) {
        break label85;
      }
    }
    label85:
    for (this.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_Boolean = false)
    {
      if ((pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()) == -1) && (paramMotionEvent.getAction() == 1) && (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage$OnNoItemClickListener != null)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGridImage$OnNoItemClickListener.a();
      }
      return super.dispatchTouchEvent(paramMotionEvent);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (getLayoutParams().height == -2) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(536870911, -2147483648);
    }
    super.onMeasure(paramInt1, paramInt2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage
 * JD-Core Version:    0.7.0.1
 */