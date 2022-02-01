package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import agej;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import anzj;
import bghf;
import blqm;
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
import ozs;
import ppu;
import qjg;
import qjp;
import qno;
import qnz;
import qoa;
import qob;
import qoc;
import qod;
import qoe;
import qxu;
import qyg;
import qyh;
import qyl;
import qym;
import qyp;
import sel;
import smv;

public class ComponentContentGridImage
  extends GridView
  implements qjg
{
  public int a;
  public Object a;
  private qno jdField_a_of_type_Qno;
  private qoa jdField_a_of_type_Qoa;
  private qod jdField_a_of_type_Qod;
  private qoe jdField_a_of_type_Qoe;
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
    this.jdField_a_of_type_Int = agej.a(12.0F, getResources());
    this.jdField_b_of_type_Int = agej.a(12.0F, getResources());
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
  
  public static qob a(ArticleInfo paramArticleInfo)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_a_of_type_JavaUtilArrayList.iterator();
    qym localqym;
    if (paramArticleInfo.hasNext()) {
      localqym = (qym)paramArticleInfo.next();
    }
    for (;;)
    {
      try
      {
        int i = localArrayList1.size();
        if (i >= 9) {
          return new qoc().a(localArrayList1).b(localArrayList2).a();
        }
        i = localqym.jdField_a_of_type_Int;
        int j = localqym.jdField_b_of_type_Int;
        URL localURL = new URL(localqym.jdField_c_of_type_JavaLangString);
        if (localqym.jdField_c_of_type_Int != 1) {
          break label207;
        }
        bool = true;
        localArrayList1.add(new smv(i, j, localURL, bool));
        localArrayList2.add(new URL(localqym.jdField_b_of_type_JavaLangString));
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
  
  public static qob a(Object paramObject, int paramInt)
  {
    qoc localqoc = new qoc();
    ArticleInfo localArticleInfo;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    int i;
    boolean bool2;
    boolean bool1;
    long l1;
    int j;
    if ((paramObject instanceof ppu))
    {
      localArticleInfo = ((ppu)paramObject).a();
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      if ((localArticleInfo != null) && (localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg.jdField_a_of_type_JavaUtilArrayList != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        localArrayList3 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg.jdField_a_of_type_JavaUtilArrayList;
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
        if (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg.jdField_a_of_type_Qxu == null) {
          break label739;
        }
        bool1 = true;
        l2 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg.jdField_a_of_type_Qxu.a;
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
            localqoc.b(localArrayList1);
            localqoc.a(localArrayList2);
            if (localArticleInfo != null)
            {
              if (!TextUtils.isEmpty(localArticleInfo.mArticleContentUrl)) {
                localqoc.a(localArticleInfo.mArticleContentUrl);
              }
              if ((localArticleInfo.mSocialFeedInfo == null) || (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg == null) || (TextUtils.isEmpty(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg.jdField_a_of_type_JavaLangString))) {
                break label714;
              }
              localqoc.b(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg.jdField_a_of_type_JavaLangString);
            }
            localqoc.a(paramInt);
            return localqoc.a();
          }
          qyh localqyh = (qyh)localArrayList3.get(j);
          if ((localqyh.jdField_b_of_type_JavaLangString == null) && (localqyh.jdField_c_of_type_JavaLangString == null)) {
            break;
          }
          blqm.a("ComponentContentGridImage.log");
          if (QLog.isColorLevel())
          {
            if (localqyh.jdField_b_of_type_JavaLangString != null) {
              QLog.d("Q.readinjoy.ui", 2, "Grid Image url [" + j + "]: " + localqyh.jdField_b_of_type_JavaLangString);
            }
            if (localqyh.jdField_c_of_type_JavaLangString != null) {
              QLog.d("Q.readinjoy.ui", 2, "Grid thumbNail Image url [" + j + "]: " + localqyh.jdField_c_of_type_JavaLangString);
            }
          }
          blqm.a();
          blqm.a("ComponentContentGridImage.setImageUrl");
          if (localqyh.jdField_b_of_type_JavaLangString != null)
          {
            paramObject = localqyh.jdField_b_of_type_JavaLangString;
            URL localURL = new URL(paramObject);
            if (localqyh.jdField_c_of_type_JavaLangString != null)
            {
              paramObject = localqyh.jdField_c_of_type_JavaLangString;
              paramObject = new URL(paramObject);
              blqm.a();
              localArrayList1.add(localURL);
              blqm.a("ComponentContentGridImage.PicInfo");
              k = localqyh.jdField_a_of_type_Int;
              int m = localqyh.jdField_b_of_type_Int;
              if (localqyh.jdField_c_of_type_Int != 1) {
                continue;
              }
              bool2 = true;
              paramObject = new smv(k, m, paramObject, bool2);
              if ((bool1) && (j == i - 1))
              {
                paramObject.b(bool1);
                paramObject.a(l1 + anzj.a(2131701229));
              }
              blqm.a();
              localArrayList2.add(paramObject);
              break;
            }
          }
          else
          {
            paramObject = localqyh.jdField_c_of_type_JavaLangString;
            continue;
          }
          paramObject = localqyh.jdField_b_of_type_JavaLangString;
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
          localqoc.b(localArticleInfo.mTitle);
        }
      }
      label739:
      break;
      j += 1;
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_JavaLangObject instanceof ppu))
    {
      ArticleInfo localArticleInfo = ((ppu)this.jdField_a_of_type_JavaLangObject).a();
      if (localArticleInfo != null)
      {
        sel.a(localArticleInfo, paramInt1, paramInt2);
        paramInt2 = -1;
        paramInt1 = paramInt2;
        if (this.jdField_a_of_type_Qno != null)
        {
          paramInt1 = paramInt2;
          if (this.jdField_a_of_type_Qno.a != null) {
            paramInt1 = this.jdField_a_of_type_Qno.a.e();
          }
        }
        sel.b(localArticleInfo, paramInt1);
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
    String str1 = this.jdField_a_of_type_Qoa.a();
    String str2 = this.jdField_a_of_type_Qoa.b();
    ArticleInfo localArticleInfo = null;
    if ((this.jdField_a_of_type_JavaLangObject instanceof ppu)) {
      localArticleInfo = ((ppu)this.jdField_a_of_type_JavaLangObject).a();
    }
    if (ozs.l(localArticleInfo))
    {
      str1 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyp.f;
      str2 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyp.jdField_b_of_type_JavaLangString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.ui", 2, new Object[] { "ReadInJoy grid image show content url and title, articleUrl: " + str1, " articleTitle: " + str2 });
    }
    if ((localArticleInfo != null) && (localArticleInfo.isPGCShortContent())) {}
    try
    {
      localArticleInfo.clickArea = d();
      ozs.b(this.jdField_a_of_type_Qno.a.a().a().getContext(), localArticleInfo, (int)localArticleInfo.mChannelID);
      if ((this.jdField_a_of_type_Qno != null) && (this.jdField_a_of_type_Qno.a != null) && (this.jdField_a_of_type_Qno.a.a() != null) && (this.jdField_a_of_type_Qno.a.a().a() != null)) {
        bghf.a(this.jdField_a_of_type_Qno.a.a().a(), paramInt, a(paramList), null, null, false, false, "4", 100, null, str1, str2, localArticleInfo, "");
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
  
  public void a()
  {
    setOnItemClickListener(new qnz(this));
  }
  
  public void a(Context paramContext)
  {
    setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    setNumColumns(3);
    setVerticalSpacing(agej.a(1.0F, paramContext.getResources()));
    setHorizontalSpacing(agej.a(1.0F, paramContext.getResources()));
    setSelector(17170445);
    a();
    this.jdField_a_of_type_Qno = new qno();
  }
  
  public void a(View paramView)
  {
    ((SquareCornerTextImageView)paramView).jdField_a_of_type_Boolean = false;
  }
  
  public void a(Object paramObject)
  {
    if (!(paramObject instanceof qob))
    {
      QLog.e("ComponentContentGridImage", 1, "unsupported model type.", new IllegalArgumentException());
      return;
    }
    this.jdField_c_of_type_Int = ((qob)paramObject).a();
    if (this.jdField_a_of_type_Qoa == null)
    {
      this.jdField_a_of_type_Qoa = new qoa(this, (qob)paramObject);
      setAdapter(this.jdField_a_of_type_Qoa);
    }
    for (;;)
    {
      b();
      if ((this.jdField_a_of_type_Qno == null) || (!(this.jdField_a_of_type_JavaLangObject instanceof ppu))) {
        break;
      }
      this.jdField_a_of_type_Qno.a((ppu)this.jdField_a_of_type_JavaLangObject);
      return;
      this.jdField_a_of_type_Qoa.a((qob)paramObject);
      this.jdField_a_of_type_Qoa.notifyDataSetChanged();
    }
  }
  
  public void a(qjp paramqjp) {}
  
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
  
  protected int d()
  {
    return 9;
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
      if ((pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()) == -1) && (paramMotionEvent.getAction() == 1) && (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Qoe != null)) {
        this.jdField_a_of_type_Qoe.a();
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
  
  public void setGalleryClickListener(qod paramqod)
  {
    this.jdField_a_of_type_Qod = paramqod;
  }
  
  public void setMIReadInJoyModel(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void setOnNoItemClickListener(qoe paramqoe)
  {
    this.jdField_a_of_type_Qoe = paramqoe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage
 * JD-Core Version:    0.7.0.1
 */