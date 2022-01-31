package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import aciy;
import ajjy;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import azcm;
import babp;
import beoj;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.GridView;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import obz;
import opw;
import pey;
import pfh;
import pjg;
import pjr;
import pjs;
import pjt;
import pju;
import pjv;
import pjw;
import pqp;
import pqz;
import pra;
import pre;
import prf;
import pri;
import qoe;
import qvs;

public class ComponentContentGridImage
  extends GridView
  implements pey
{
  public int a;
  private Object jdField_a_of_type_JavaLangObject;
  private pjg jdField_a_of_type_Pjg;
  private pjs jdField_a_of_type_Pjs;
  private pjv jdField_a_of_type_Pjv;
  private pjw jdField_a_of_type_Pjw;
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
    this.jdField_a_of_type_Int = aciy.a(12.0F, getResources());
    this.jdField_b_of_type_Int = aciy.a(12.0F, getResources());
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
  
  public static pjt a(ArticleInfo paramArticleInfo)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_a_of_type_JavaUtilArrayList.iterator();
    prf localprf;
    if (paramArticleInfo.hasNext()) {
      localprf = (prf)paramArticleInfo.next();
    }
    for (;;)
    {
      try
      {
        int i = localArrayList1.size();
        if (i >= 9) {
          return new pju().a(localArrayList1).b(localArrayList2).a();
        }
        i = localprf.jdField_a_of_type_Int;
        int j = localprf.jdField_b_of_type_Int;
        URL localURL = new URL(localprf.jdField_c_of_type_JavaLangString);
        if (localprf.jdField_c_of_type_Int != 1) {
          break label207;
        }
        bool = true;
        localArrayList1.add(new qvs(i, j, localURL, bool));
        localArrayList2.add(new URL(localprf.jdField_b_of_type_JavaLangString));
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
  
  public static pjt a(Object paramObject, int paramInt)
  {
    pju localpju = new pju();
    ArticleInfo localArticleInfo;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    int i;
    boolean bool2;
    boolean bool1;
    long l1;
    int j;
    if ((paramObject instanceof opw))
    {
      localArticleInfo = ((opw)paramObject).a();
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      if ((localArticleInfo != null) && (localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqz != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqz.jdField_a_of_type_JavaUtilArrayList != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqz.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        localArrayList3 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqz.jdField_a_of_type_JavaUtilArrayList;
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
        if (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqz.jdField_a_of_type_Pqp == null) {
          break label742;
        }
        bool1 = true;
        l2 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqz.jdField_a_of_type_Pqp.a;
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
            localpju.b(localArrayList1);
            localpju.a(localArrayList2);
            if (localArticleInfo != null)
            {
              if (!TextUtils.isEmpty(localArticleInfo.mArticleContentUrl)) {
                localpju.a(localArticleInfo.mArticleContentUrl);
              }
              if ((localArticleInfo.mSocialFeedInfo == null) || (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqz == null) || (TextUtils.isEmpty(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqz.jdField_a_of_type_JavaLangString))) {
                break label717;
              }
              localpju.b(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqz.jdField_a_of_type_JavaLangString);
            }
            localpju.a(paramInt);
            return localpju.a();
          }
          pra localpra = (pra)localArrayList3.get(j);
          if ((localpra.jdField_b_of_type_JavaLangString == null) && (localpra.jdField_c_of_type_JavaLangString == null)) {
            break;
          }
          beoj.a("ComponentContentGridImage.log");
          if (QLog.isColorLevel())
          {
            if (localpra.jdField_b_of_type_JavaLangString != null) {
              QLog.d("Q.readinjoy.ui", 2, "Grid Image url [" + j + "]: " + localpra.jdField_b_of_type_JavaLangString);
            }
            if (localpra.jdField_c_of_type_JavaLangString != null) {
              QLog.d("Q.readinjoy.ui", 2, "Grid thumbNail Image url [" + j + "]: " + localpra.jdField_c_of_type_JavaLangString);
            }
          }
          beoj.a();
          beoj.a("ComponentContentGridImage.setImageUrl");
          if (localpra.jdField_b_of_type_JavaLangString != null)
          {
            paramObject = localpra.jdField_b_of_type_JavaLangString;
            URL localURL = new URL(paramObject);
            if (localpra.jdField_c_of_type_JavaLangString != null)
            {
              paramObject = localpra.jdField_c_of_type_JavaLangString;
              paramObject = new URL(paramObject);
              beoj.a();
              localArrayList1.add(localURL);
              beoj.a("ComponentContentGridImage.PicInfo");
              k = localpra.jdField_a_of_type_Int;
              int m = localpra.jdField_b_of_type_Int;
              if (localpra.jdField_c_of_type_Int != 1) {
                continue;
              }
              bool2 = true;
              paramObject = new qvs(k, m, paramObject, bool2);
              if ((bool1) && (j == i - 1))
              {
                paramObject.b(bool1);
                paramObject.a(String.valueOf(l1) + ajjy.a(2131636523));
              }
              beoj.a();
              localArrayList2.add(paramObject);
              break;
            }
          }
          else
          {
            paramObject = localpra.jdField_c_of_type_JavaLangString;
            continue;
          }
          paramObject = localpra.jdField_b_of_type_JavaLangString;
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
          localpju.b(localArticleInfo.mTitle);
        }
      }
      label742:
      break;
      j += 1;
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_JavaLangObject instanceof opw))
    {
      ArticleInfo localArticleInfo = ((opw)this.jdField_a_of_type_JavaLangObject).a();
      if (localArticleInfo != null)
      {
        qoe.a(localArticleInfo, paramInt1, paramInt2);
        paramInt2 = -1;
        paramInt1 = paramInt2;
        if (this.jdField_a_of_type_Pjg != null)
        {
          paramInt1 = paramInt2;
          if (this.jdField_a_of_type_Pjg.a != null) {
            paramInt1 = this.jdField_a_of_type_Pjg.a.e();
          }
        }
        qoe.b(localArticleInfo, paramInt1);
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
    String str1 = this.jdField_a_of_type_Pjs.a();
    String str2 = this.jdField_a_of_type_Pjs.b();
    ArticleInfo localArticleInfo = null;
    if ((this.jdField_a_of_type_JavaLangObject instanceof opw)) {
      localArticleInfo = ((opw)this.jdField_a_of_type_JavaLangObject).a();
    }
    if (obz.l(localArticleInfo))
    {
      str1 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pri.f;
      str2 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pri.jdField_b_of_type_JavaLangString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.ui", 2, new Object[] { "ReadInJoy grid image show content url and title, articleUrl: " + str1, " articleTitle: " + str2 });
    }
    if ((localArticleInfo != null) && (localArticleInfo.isPGCShortContent())) {}
    try
    {
      localArticleInfo.click_area = 9;
      obz.b(this.jdField_a_of_type_Pjg.a.a().a().getContext(), localArticleInfo, (int)localArticleInfo.mChannelID);
      azcm.a((Activity)getContext(), paramInt, a(paramList), null, null, false, false, "4", 100, null, str1, str2, localArticleInfo, "");
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
    setOnItemClickListener(new pjr(this));
  }
  
  public void a(Context paramContext)
  {
    setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    setNumColumns(3);
    setVerticalSpacing(aciy.a(2.0F, paramContext.getResources()));
    setHorizontalSpacing(aciy.a(2.0F, paramContext.getResources()));
    setSelector(17170445);
    a();
    this.jdField_a_of_type_Pjg = new pjg();
  }
  
  public void a(Object paramObject)
  {
    if (!(paramObject instanceof pjt))
    {
      QLog.e("ComponentContentGridImage", 1, "unsupported model type.", new IllegalArgumentException());
      return;
    }
    this.jdField_c_of_type_Int = ((pjt)paramObject).a();
    if (this.jdField_a_of_type_Pjs == null)
    {
      this.jdField_a_of_type_Pjs = new pjs((pjt)paramObject);
      setAdapter(this.jdField_a_of_type_Pjs);
    }
    for (;;)
    {
      b();
      if ((this.jdField_a_of_type_Pjg == null) || (!(this.jdField_a_of_type_JavaLangObject instanceof opw))) {
        break;
      }
      this.jdField_a_of_type_Pjg.a((opw)this.jdField_a_of_type_JavaLangObject);
      return;
      this.jdField_a_of_type_Pjs.a((pjt)paramObject);
      this.jdField_a_of_type_Pjs.notifyDataSetChanged();
    }
  }
  
  public void a(pfh parampfh) {}
  
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
        i = (int)babp.a(true) - this.jdField_a_of_type_Int - this.jdField_b_of_type_Int;
        localLayoutParams.width = ((i - aciy.a(4.0F, getResources())) * 2 / 3 + aciy.a(2.0F, getResources()));
        if (QLog.isColorLevel()) {
          QLog.d("ComponentContentGridImage", 2, new Object[] { "contentWidth: ", Integer.valueOf(i), ", layout.width: ", Integer.valueOf(localLayoutParams.width), ", MinOfWidthAndHeight: ", Long.valueOf(babp.i()) });
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
      if ((pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()) == -1) && (paramMotionEvent.getAction() == 1) && (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Pjw != null)) {
        this.jdField_a_of_type_Pjw.a();
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
  
  public void setGalleryClickListener(pjv parampjv)
  {
    this.jdField_a_of_type_Pjv = parampjv;
  }
  
  public void setMIReadInJoyModel(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void setOnNoItemClickListener(pjw parampjw)
  {
    this.jdField_a_of_type_Pjw = parampjw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage
 * JD-Core Version:    0.7.0.1
 */