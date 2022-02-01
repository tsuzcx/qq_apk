package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import amtj;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import beqn;
import bjun;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.SquareCornerTextImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.GridView;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pay;
import pgw;
import pvc;
import qpj;
import qps;
import qtr;
import quc;
import qud;
import que;
import quf;
import qug;
import quh;
import res;
import rfe;
import rff;
import rfj;
import rfk;
import rfn;
import slt;
import sqw;

public class ComponentContentGridImage
  extends GridView
  implements qpj
{
  public int a;
  public Object a;
  private qtr jdField_a_of_type_Qtr;
  private qud jdField_a_of_type_Qud;
  private qug jdField_a_of_type_Qug;
  private quh jdField_a_of_type_Quh;
  private boolean jdField_a_of_type_Boolean;
  public int b;
  private int c;
  
  public ComponentContentGridImage(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ComponentContentGridImage(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = AIOUtils.dp2px(12.0F, getResources());
    this.jdField_b_of_type_Int = AIOUtils.dp2px(12.0F, getResources());
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
  
  public static que a(ArticleInfo paramArticleInfo)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_a_of_type_JavaUtilArrayList.iterator();
    rfk localrfk;
    if (paramArticleInfo.hasNext()) {
      localrfk = (rfk)paramArticleInfo.next();
    }
    for (;;)
    {
      try
      {
        int i = localArrayList1.size();
        if (i >= 9) {
          return new quf().a(localArrayList1).b(localArrayList2).a();
        }
        i = localrfk.jdField_a_of_type_Int;
        int j = localrfk.jdField_b_of_type_Int;
        URL localURL = new URL(localrfk.jdField_c_of_type_JavaLangString);
        if (localrfk.jdField_c_of_type_Int != 1) {
          break label207;
        }
        bool = true;
        localArrayList1.add(new sqw(i, j, localURL, bool));
        localArrayList2.add(new URL(localrfk.jdField_b_of_type_JavaLangString));
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
  
  public static que a(Object paramObject, int paramInt)
  {
    quf localquf = new quf();
    ArticleInfo localArticleInfo;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    int i;
    boolean bool2;
    boolean bool1;
    long l1;
    int j;
    if ((paramObject instanceof pvc))
    {
      localArticleInfo = ((pvc)paramObject).a();
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      if ((localArticleInfo != null) && (localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe.jdField_a_of_type_JavaUtilArrayList != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        localArrayList3 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe.jdField_a_of_type_JavaUtilArrayList;
        i = localArrayList3.size();
        long l2 = 0L;
        bool2 = false;
        if ((paramInt != 62) && (paramInt != 63) && (paramInt != 64))
        {
          bool1 = bool2;
          l1 = l2;
          if (paramInt != 65) {
            break label739;
          }
        }
        bool1 = bool2;
        l1 = l2;
        if (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe.jdField_a_of_type_Res == null) {
          break label739;
        }
        bool1 = true;
        l2 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe.jdField_a_of_type_Res.a;
        l1 = l2;
        if (i <= 0) {
          break label739;
        }
        i = a(i, localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int);
        bool1 = true;
        l1 = l2;
        j = 0;
      }
    }
    for (;;)
    {
      if (j < i) {}
      for (;;)
      {
        try
        {
          int k = localArrayList2.size();
          if (k >= 9)
          {
            localquf.b(localArrayList1);
            localquf.a(localArrayList2);
            if (localArticleInfo != null)
            {
              if (!TextUtils.isEmpty(localArticleInfo.mArticleContentUrl)) {
                localquf.a(localArticleInfo.mArticleContentUrl);
              }
              if ((localArticleInfo.mSocialFeedInfo == null) || (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe == null) || (TextUtils.isEmpty(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe.jdField_a_of_type_JavaLangString))) {
                break label714;
              }
              localquf.b(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe.jdField_a_of_type_JavaLangString);
            }
            localquf.a(paramInt);
            return localquf.a();
          }
          rff localrff = (rff)localArrayList3.get(j);
          if ((localrff.jdField_b_of_type_JavaLangString == null) && (localrff.jdField_c_of_type_JavaLangString == null)) {
            break;
          }
          bjun.a("ComponentContentGridImage.log");
          if (QLog.isColorLevel())
          {
            if (localrff.jdField_b_of_type_JavaLangString != null) {
              QLog.d("Q.readinjoy.ui", 2, "Grid Image url [" + j + "]: " + localrff.jdField_b_of_type_JavaLangString);
            }
            if (localrff.jdField_c_of_type_JavaLangString != null) {
              QLog.d("Q.readinjoy.ui", 2, "Grid thumbNail Image url [" + j + "]: " + localrff.jdField_c_of_type_JavaLangString);
            }
          }
          bjun.a();
          bjun.a("ComponentContentGridImage.setImageUrl");
          if (localrff.jdField_b_of_type_JavaLangString != null)
          {
            paramObject = localrff.jdField_b_of_type_JavaLangString;
            URL localURL = new URL(paramObject);
            if (localrff.jdField_c_of_type_JavaLangString != null)
            {
              paramObject = localrff.jdField_c_of_type_JavaLangString;
              paramObject = new URL(paramObject);
              bjun.a();
              localArrayList1.add(localURL);
              bjun.a("ComponentContentGridImage.PicInfo");
              k = localrff.jdField_a_of_type_Int;
              int m = localrff.jdField_b_of_type_Int;
              if (localrff.jdField_c_of_type_Int != 1) {
                continue;
              }
              bool2 = true;
              paramObject = new sqw(k, m, paramObject, bool2);
              if ((bool1) && (j == i - 1))
              {
                paramObject.b(bool1);
                paramObject.a(l1 + amtj.a(2131701464));
              }
              bjun.a();
              localArrayList2.add(paramObject);
              break;
            }
          }
          else
          {
            paramObject = localrff.jdField_c_of_type_JavaLangString;
            continue;
          }
          paramObject = localrff.jdField_b_of_type_JavaLangString;
          continue;
          bool2 = false;
          continue;
          QLog.d("Q.readinjoy.ui", 2, "url error");
        }
        catch (Exception paramObject)
        {
          paramObject.printStackTrace();
          if (!QLog.isColorLevel()) {
            break;
          }
        }
        break;
        label714:
        if (!TextUtils.isEmpty(localArticleInfo.mTitle)) {
          localquf.b(localArticleInfo.mTitle);
        }
      }
      label739:
      break;
      j += 1;
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_JavaLangObject instanceof pvc))
    {
      ArticleInfo localArticleInfo = ((pvc)this.jdField_a_of_type_JavaLangObject).a();
      if (localArticleInfo != null)
      {
        pgw.a(localArticleInfo, paramInt1, paramInt2);
        paramInt2 = -1;
        paramInt1 = paramInt2;
        if (this.jdField_a_of_type_Qtr != null)
        {
          paramInt1 = paramInt2;
          if (this.jdField_a_of_type_Qtr.a != null) {
            paramInt1 = this.jdField_a_of_type_Qtr.a.e();
          }
        }
        pgw.a(localArticleInfo, paramInt1);
      }
    }
    else
    {
      return;
    }
    QLog.d("ComponentContentGridImage", 1, "ComponentContentGridImage report data, articleInfo is null!");
  }
  
  private void a(int paramInt, List<URL> paramList)
  {
    String str1 = this.jdField_a_of_type_Qud.a();
    String str2 = this.jdField_a_of_type_Qud.b();
    ArticleInfo localArticleInfo = null;
    if ((this.jdField_a_of_type_JavaLangObject instanceof pvc)) {
      localArticleInfo = ((pvc)this.jdField_a_of_type_JavaLangObject).a();
    }
    if (pay.m(localArticleInfo))
    {
      str1 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfn.f;
      str2 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfn.jdField_b_of_type_JavaLangString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.ui", 2, new Object[] { "ReadInJoy grid image show content url and title, articleUrl: " + str1, " articleTitle: " + str2 });
    }
    if ((localArticleInfo != null) && (localArticleInfo.isPGCShortContent())) {}
    try
    {
      localArticleInfo.clickArea = a();
      pay.b(this.jdField_a_of_type_Qtr.a.a().a().getContext(), localArticleInfo, (int)localArticleInfo.mChannelID);
      if ((this.jdField_a_of_type_Qtr != null) && (this.jdField_a_of_type_Qtr.a != null) && (this.jdField_a_of_type_Qtr.a.a() != null) && (this.jdField_a_of_type_Qtr.a.a().a() != null)) {
        beqn.a(this.jdField_a_of_type_Qtr.a.a().a(), paramInt, a(paramList), null, null, false, false, "4", 100, null, str1, str2, localArticleInfo, "");
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
  
  protected int a()
  {
    return 9;
  }
  
  public void a()
  {
    setOnItemClickListener(new quc(this));
  }
  
  public void a(Context paramContext)
  {
    setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    setNumColumns(3);
    setVerticalSpacing(AIOUtils.dp2px(1.0F, paramContext.getResources()));
    setHorizontalSpacing(AIOUtils.dp2px(1.0F, paramContext.getResources()));
    setSelector(17170445);
    a();
    this.jdField_a_of_type_Qtr = new qtr();
  }
  
  public void a(View paramView)
  {
    ((SquareCornerTextImageView)paramView).jdField_a_of_type_Boolean = false;
  }
  
  public void a(Object paramObject)
  {
    if (!(paramObject instanceof que))
    {
      QLog.e("ComponentContentGridImage", 1, "unsupported model type.", new IllegalArgumentException());
      return;
    }
    this.jdField_c_of_type_Int = ((que)paramObject).a();
    if (this.jdField_a_of_type_Qud == null)
    {
      this.jdField_a_of_type_Qud = new qud(this, (que)paramObject);
      setAdapter(this.jdField_a_of_type_Qud);
    }
    for (;;)
    {
      b();
      if ((this.jdField_a_of_type_Qtr == null) || (!(this.jdField_a_of_type_JavaLangObject instanceof pvc))) {
        break;
      }
      this.jdField_a_of_type_Qtr.a((pvc)this.jdField_a_of_type_JavaLangObject);
      return;
      this.jdField_a_of_type_Qud.a((que)paramObject);
      this.jdField_a_of_type_Qud.notifyDataSetChanged();
    }
  }
  
  public void a(qps paramqps) {}
  
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
      if ((pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()) == -1) && (paramMotionEvent.getAction() == 1) && (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Quh != null)) {
        this.jdField_a_of_type_Quh.a();
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
  
  public void setGalleryClickListener(qug paramqug)
  {
    this.jdField_a_of_type_Qug = paramqug;
  }
  
  public void setMIReadInJoyModel(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void setOnNoItemClickListener(quh paramquh)
  {
    this.jdField_a_of_type_Quh = paramquh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage
 * JD-Core Version:    0.7.0.1
 */