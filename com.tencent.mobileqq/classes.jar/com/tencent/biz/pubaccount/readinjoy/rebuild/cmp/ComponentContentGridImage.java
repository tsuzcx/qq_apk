package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import aepi;
import alud;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import bcgq;
import bdgk;
import biby;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.SquareCornerTextImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.GridView;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ors;
import pgd;
import pxk;
import pxt;
import qbs;
import qcd;
import qce;
import qcf;
import qcg;
import qch;
import qci;
import qmf;
import qmr;
import qms;
import qmw;
import qmx;
import qna;
import rqj;
import rxv;

public class ComponentContentGridImage
  extends GridView
  implements pxk
{
  public int a;
  public Object a;
  private qbs jdField_a_of_type_Qbs;
  private qce jdField_a_of_type_Qce;
  private qch jdField_a_of_type_Qch;
  private qci jdField_a_of_type_Qci;
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
    this.jdField_a_of_type_Int = aepi.a(12.0F, getResources());
    this.jdField_b_of_type_Int = aepi.a(12.0F, getResources());
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
  
  public static qcf a(ArticleInfo paramArticleInfo)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_JavaUtilArrayList.iterator();
    qmx localqmx;
    if (paramArticleInfo.hasNext()) {
      localqmx = (qmx)paramArticleInfo.next();
    }
    for (;;)
    {
      try
      {
        int i = localArrayList1.size();
        if (i >= 9) {
          return new qcg().a(localArrayList1).b(localArrayList2).a();
        }
        i = localqmx.jdField_a_of_type_Int;
        int j = localqmx.jdField_b_of_type_Int;
        URL localURL = new URL(localqmx.jdField_c_of_type_JavaLangString);
        if (localqmx.jdField_c_of_type_Int != 1) {
          break label207;
        }
        bool = true;
        localArrayList1.add(new rxv(i, j, localURL, bool));
        localArrayList2.add(new URL(localqmx.jdField_b_of_type_JavaLangString));
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
  
  public static qcf a(Object paramObject, int paramInt)
  {
    qcg localqcg = new qcg();
    ArticleInfo localArticleInfo;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    int i;
    boolean bool2;
    boolean bool1;
    long l1;
    int j;
    if ((paramObject instanceof pgd))
    {
      localArticleInfo = ((pgd)paramObject).a();
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      if ((localArticleInfo != null) && (localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_JavaUtilArrayList != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        localArrayList3 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_JavaUtilArrayList;
        i = localArrayList3.size();
        long l2 = 0L;
        bool2 = false;
        if ((paramInt != 62) && (paramInt != 63) && (paramInt != 64))
        {
          bool1 = bool2;
          l1 = l2;
          if (paramInt != 65) {
            break label742;
          }
        }
        bool1 = bool2;
        l1 = l2;
        if (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_Qmf == null) {
          break label742;
        }
        bool1 = true;
        l2 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_Qmf.a;
        l1 = l2;
        if (i <= 0) {
          break label742;
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
            localqcg.b(localArrayList1);
            localqcg.a(localArrayList2);
            if (localArticleInfo != null)
            {
              if (!TextUtils.isEmpty(localArticleInfo.mArticleContentUrl)) {
                localqcg.a(localArticleInfo.mArticleContentUrl);
              }
              if ((localArticleInfo.mSocialFeedInfo == null) || (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr == null) || (TextUtils.isEmpty(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_JavaLangString))) {
                break label717;
              }
              localqcg.b(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_JavaLangString);
            }
            localqcg.a(paramInt);
            return localqcg.a();
          }
          qms localqms = (qms)localArrayList3.get(j);
          if ((localqms.jdField_b_of_type_JavaLangString == null) && (localqms.jdField_c_of_type_JavaLangString == null)) {
            break;
          }
          biby.a("ComponentContentGridImage.log");
          if (QLog.isColorLevel())
          {
            if (localqms.jdField_b_of_type_JavaLangString != null) {
              QLog.d("Q.readinjoy.ui", 2, "Grid Image url [" + j + "]: " + localqms.jdField_b_of_type_JavaLangString);
            }
            if (localqms.jdField_c_of_type_JavaLangString != null) {
              QLog.d("Q.readinjoy.ui", 2, "Grid thumbNail Image url [" + j + "]: " + localqms.jdField_c_of_type_JavaLangString);
            }
          }
          biby.a();
          biby.a("ComponentContentGridImage.setImageUrl");
          if (localqms.jdField_b_of_type_JavaLangString != null)
          {
            paramObject = localqms.jdField_b_of_type_JavaLangString;
            URL localURL = new URL(paramObject);
            if (localqms.jdField_c_of_type_JavaLangString != null)
            {
              paramObject = localqms.jdField_c_of_type_JavaLangString;
              paramObject = new URL(paramObject);
              biby.a();
              localArrayList1.add(localURL);
              biby.a("ComponentContentGridImage.PicInfo");
              k = localqms.jdField_a_of_type_Int;
              int m = localqms.jdField_b_of_type_Int;
              if (localqms.jdField_c_of_type_Int != 1) {
                continue;
              }
              bool2 = true;
              paramObject = new rxv(k, m, paramObject, bool2);
              if ((bool1) && (j == i - 1))
              {
                paramObject.b(bool1);
                paramObject.a(String.valueOf(l1) + alud.a(2131702702));
              }
              biby.a();
              localArrayList2.add(paramObject);
              break;
            }
          }
          else
          {
            paramObject = localqms.jdField_c_of_type_JavaLangString;
            continue;
          }
          paramObject = localqms.jdField_b_of_type_JavaLangString;
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
        label717:
        if (!TextUtils.isEmpty(localArticleInfo.mTitle)) {
          localqcg.b(localArticleInfo.mTitle);
        }
      }
      label742:
      break;
      j += 1;
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_JavaLangObject instanceof pgd))
    {
      ArticleInfo localArticleInfo = ((pgd)this.jdField_a_of_type_JavaLangObject).a();
      if (localArticleInfo != null)
      {
        rqj.a(localArticleInfo, paramInt1, paramInt2);
        paramInt2 = -1;
        paramInt1 = paramInt2;
        if (this.jdField_a_of_type_Qbs != null)
        {
          paramInt1 = paramInt2;
          if (this.jdField_a_of_type_Qbs.a != null) {
            paramInt1 = this.jdField_a_of_type_Qbs.a.e();
          }
        }
        rqj.b(localArticleInfo, paramInt1);
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
    String str1 = this.jdField_a_of_type_Qce.a();
    String str2 = this.jdField_a_of_type_Qce.b();
    ArticleInfo localArticleInfo = null;
    if ((this.jdField_a_of_type_JavaLangObject instanceof pgd)) {
      localArticleInfo = ((pgd)this.jdField_a_of_type_JavaLangObject).a();
    }
    if (ors.l(localArticleInfo))
    {
      str1 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qna.f;
      str2 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qna.jdField_b_of_type_JavaLangString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.ui", 2, new Object[] { "ReadInJoy grid image show content url and title, articleUrl: " + str1, " articleTitle: " + str2 });
    }
    if ((localArticleInfo != null) && (localArticleInfo.isPGCShortContent())) {}
    try
    {
      localArticleInfo.click_area = d();
      ors.b(this.jdField_a_of_type_Qbs.a.a().a().getContext(), localArticleInfo, (int)localArticleInfo.mChannelID);
      bcgq.a((Activity)getContext(), paramInt, a(paramList), null, null, false, false, "4", 100, null, str1, str2, localArticleInfo, "");
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
  
  public void a()
  {
    setOnItemClickListener(new qcd(this));
  }
  
  public void a(Context paramContext)
  {
    setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    setNumColumns(3);
    setVerticalSpacing(aepi.a(2.0F, paramContext.getResources()));
    setHorizontalSpacing(aepi.a(2.0F, paramContext.getResources()));
    setSelector(17170445);
    a();
    this.jdField_a_of_type_Qbs = new qbs();
  }
  
  public void a(View paramView)
  {
    ((SquareCornerTextImageView)paramView).jdField_a_of_type_Boolean = true;
  }
  
  public void a(Object paramObject)
  {
    if (!(paramObject instanceof qcf))
    {
      QLog.e("ComponentContentGridImage", 1, "unsupported model type.", new IllegalArgumentException());
      return;
    }
    this.jdField_c_of_type_Int = ((qcf)paramObject).a();
    if (this.jdField_a_of_type_Qce == null)
    {
      this.jdField_a_of_type_Qce = new qce(this, (qcf)paramObject);
      setAdapter(this.jdField_a_of_type_Qce);
    }
    for (;;)
    {
      b();
      if ((this.jdField_a_of_type_Qbs == null) || (!(this.jdField_a_of_type_JavaLangObject instanceof pgd))) {
        break;
      }
      this.jdField_a_of_type_Qbs.a((pgd)this.jdField_a_of_type_JavaLangObject);
      return;
      this.jdField_a_of_type_Qce.a((qcf)paramObject);
      this.jdField_a_of_type_Qce.notifyDataSetChanged();
    }
  }
  
  public void a(pxt parampxt) {}
  
  public void b()
  {
    int i = getCount();
    ViewGroup.LayoutParams localLayoutParams;
    if (i == 1)
    {
      setNumColumns(1);
      localLayoutParams = getLayoutParams();
      if (i != 4) {
        break label181;
      }
      if ((localLayoutParams != null) && (localLayoutParams.width < 0))
      {
        i = (int)bdgk.a(true) - this.jdField_a_of_type_Int - this.jdField_b_of_type_Int;
        localLayoutParams.width = ((i - aepi.a(4.0F, getResources())) * 2 / 3 + aepi.a(2.0F, getResources()));
        if (QLog.isColorLevel()) {
          QLog.d("ComponentContentGridImage", 2, new Object[] { "contentWidth: ", Integer.valueOf(i), ", layout.width: ", Integer.valueOf(localLayoutParams.width), ", MinOfWidthAndHeight: ", Long.valueOf(bdgk.i()) });
        }
        if (localLayoutParams.width > 0) {
          setLayoutParams(localLayoutParams);
        }
      }
    }
    label181:
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
  
  protected int d()
  {
    return 9;
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
      if ((pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()) == -1) && (paramMotionEvent.getAction() == 1) && (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Qci != null)) {
        this.jdField_a_of_type_Qci.a();
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
  
  public void setGalleryClickListener(qch paramqch)
  {
    this.jdField_a_of_type_Qch = paramqch;
  }
  
  public void setMIReadInJoyModel(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void setOnNoItemClickListener(qci paramqci)
  {
    this.jdField_a_of_type_Qci = paramqci;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage
 * JD-Core Version:    0.7.0.1
 */