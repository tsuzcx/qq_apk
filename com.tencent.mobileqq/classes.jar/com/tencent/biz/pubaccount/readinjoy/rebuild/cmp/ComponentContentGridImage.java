package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import actn;
import ajyc;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import badh;
import bbct;
import bfwd;
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
import onk;
import pax;
import pqs;
import prb;
import pvb;
import pvm;
import pvn;
import pvo;
import pvp;
import pvq;
import pvr;
import qcm;
import qcy;
import qcz;
import qdd;
import qde;
import qdh;
import rap;
import rie;

public class ComponentContentGridImage
  extends GridView
  implements pqs
{
  public int a;
  public Object a;
  private pvb jdField_a_of_type_Pvb;
  private pvn jdField_a_of_type_Pvn;
  private pvq jdField_a_of_type_Pvq;
  private pvr jdField_a_of_type_Pvr;
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
    this.jdField_a_of_type_Int = actn.a(12.0F, getResources());
    this.jdField_b_of_type_Int = actn.a(12.0F, getResources());
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
  
  public static pvo a(ArticleInfo paramArticleInfo)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdd.jdField_a_of_type_JavaUtilArrayList.iterator();
    qde localqde;
    if (paramArticleInfo.hasNext()) {
      localqde = (qde)paramArticleInfo.next();
    }
    for (;;)
    {
      try
      {
        int i = localArrayList1.size();
        if (i >= 9) {
          return new pvp().a(localArrayList1).b(localArrayList2).a();
        }
        i = localqde.jdField_a_of_type_Int;
        int j = localqde.jdField_b_of_type_Int;
        URL localURL = new URL(localqde.jdField_c_of_type_JavaLangString);
        if (localqde.jdField_c_of_type_Int != 1) {
          break label207;
        }
        bool = true;
        localArrayList1.add(new rie(i, j, localURL, bool));
        localArrayList2.add(new URL(localqde.jdField_b_of_type_JavaLangString));
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
  
  public static pvo a(Object paramObject, int paramInt)
  {
    pvp localpvp = new pvp();
    ArticleInfo localArticleInfo;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    int i;
    boolean bool2;
    boolean bool1;
    long l1;
    int j;
    if ((paramObject instanceof pax))
    {
      localArticleInfo = ((pax)paramObject).a();
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      if ((localArticleInfo != null) && (localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcy != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcy.jdField_a_of_type_JavaUtilArrayList != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcy.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        localArrayList3 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcy.jdField_a_of_type_JavaUtilArrayList;
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
        if (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcy.jdField_a_of_type_Qcm == null) {
          break label742;
        }
        bool1 = true;
        l2 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcy.jdField_a_of_type_Qcm.a;
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
            localpvp.b(localArrayList1);
            localpvp.a(localArrayList2);
            if (localArticleInfo != null)
            {
              if (!TextUtils.isEmpty(localArticleInfo.mArticleContentUrl)) {
                localpvp.a(localArticleInfo.mArticleContentUrl);
              }
              if ((localArticleInfo.mSocialFeedInfo == null) || (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcy == null) || (TextUtils.isEmpty(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcy.jdField_a_of_type_JavaLangString))) {
                break label717;
              }
              localpvp.b(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcy.jdField_a_of_type_JavaLangString);
            }
            localpvp.a(paramInt);
            return localpvp.a();
          }
          qcz localqcz = (qcz)localArrayList3.get(j);
          if ((localqcz.jdField_b_of_type_JavaLangString == null) && (localqcz.jdField_c_of_type_JavaLangString == null)) {
            break;
          }
          bfwd.a("ComponentContentGridImage.log");
          if (QLog.isColorLevel())
          {
            if (localqcz.jdField_b_of_type_JavaLangString != null) {
              QLog.d("Q.readinjoy.ui", 2, "Grid Image url [" + j + "]: " + localqcz.jdField_b_of_type_JavaLangString);
            }
            if (localqcz.jdField_c_of_type_JavaLangString != null) {
              QLog.d("Q.readinjoy.ui", 2, "Grid thumbNail Image url [" + j + "]: " + localqcz.jdField_c_of_type_JavaLangString);
            }
          }
          bfwd.a();
          bfwd.a("ComponentContentGridImage.setImageUrl");
          if (localqcz.jdField_b_of_type_JavaLangString != null)
          {
            paramObject = localqcz.jdField_b_of_type_JavaLangString;
            URL localURL = new URL(paramObject);
            if (localqcz.jdField_c_of_type_JavaLangString != null)
            {
              paramObject = localqcz.jdField_c_of_type_JavaLangString;
              paramObject = new URL(paramObject);
              bfwd.a();
              localArrayList1.add(localURL);
              bfwd.a("ComponentContentGridImage.PicInfo");
              k = localqcz.jdField_a_of_type_Int;
              int m = localqcz.jdField_b_of_type_Int;
              if (localqcz.jdField_c_of_type_Int != 1) {
                continue;
              }
              bool2 = true;
              paramObject = new rie(k, m, paramObject, bool2);
              if ((bool1) && (j == i - 1))
              {
                paramObject.b(bool1);
                paramObject.a(String.valueOf(l1) + ajyc.a(2131702307));
              }
              bfwd.a();
              localArrayList2.add(paramObject);
              break;
            }
          }
          else
          {
            paramObject = localqcz.jdField_c_of_type_JavaLangString;
            continue;
          }
          paramObject = localqcz.jdField_b_of_type_JavaLangString;
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
          localpvp.b(localArticleInfo.mTitle);
        }
      }
      label742:
      break;
      j += 1;
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_JavaLangObject instanceof pax))
    {
      ArticleInfo localArticleInfo = ((pax)this.jdField_a_of_type_JavaLangObject).a();
      if (localArticleInfo != null)
      {
        rap.a(localArticleInfo, paramInt1, paramInt2);
        paramInt2 = -1;
        paramInt1 = paramInt2;
        if (this.jdField_a_of_type_Pvb != null)
        {
          paramInt1 = paramInt2;
          if (this.jdField_a_of_type_Pvb.a != null) {
            paramInt1 = this.jdField_a_of_type_Pvb.a.e();
          }
        }
        rap.b(localArticleInfo, paramInt1);
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
    String str1 = this.jdField_a_of_type_Pvn.a();
    String str2 = this.jdField_a_of_type_Pvn.b();
    ArticleInfo localArticleInfo = null;
    if ((this.jdField_a_of_type_JavaLangObject instanceof pax)) {
      localArticleInfo = ((pax)this.jdField_a_of_type_JavaLangObject).a();
    }
    if (onk.l(localArticleInfo))
    {
      str1 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdh.f;
      str2 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdh.jdField_b_of_type_JavaLangString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.ui", 2, new Object[] { "ReadInJoy grid image show content url and title, articleUrl: " + str1, " articleTitle: " + str2 });
    }
    if ((localArticleInfo != null) && (localArticleInfo.isPGCShortContent())) {}
    try
    {
      localArticleInfo.click_area = d();
      onk.b(this.jdField_a_of_type_Pvb.a.a().a().getContext(), localArticleInfo, (int)localArticleInfo.mChannelID);
      badh.a((Activity)getContext(), paramInt, a(paramList), null, null, false, false, "4", 100, null, str1, str2, localArticleInfo, "");
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
    setOnItemClickListener(new pvm(this));
  }
  
  public void a(Context paramContext)
  {
    setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    setNumColumns(3);
    setVerticalSpacing(actn.a(2.0F, paramContext.getResources()));
    setHorizontalSpacing(actn.a(2.0F, paramContext.getResources()));
    setSelector(17170445);
    a();
    this.jdField_a_of_type_Pvb = new pvb();
  }
  
  public void a(View paramView)
  {
    ((SquareCornerTextImageView)paramView).jdField_a_of_type_Boolean = true;
  }
  
  public void a(Object paramObject)
  {
    if (!(paramObject instanceof pvo))
    {
      QLog.e("ComponentContentGridImage", 1, "unsupported model type.", new IllegalArgumentException());
      return;
    }
    this.jdField_c_of_type_Int = ((pvo)paramObject).a();
    if (this.jdField_a_of_type_Pvn == null)
    {
      this.jdField_a_of_type_Pvn = new pvn(this, (pvo)paramObject);
      setAdapter(this.jdField_a_of_type_Pvn);
    }
    for (;;)
    {
      b();
      if ((this.jdField_a_of_type_Pvb == null) || (!(this.jdField_a_of_type_JavaLangObject instanceof pax))) {
        break;
      }
      this.jdField_a_of_type_Pvb.a((pax)this.jdField_a_of_type_JavaLangObject);
      return;
      this.jdField_a_of_type_Pvn.a((pvo)paramObject);
      this.jdField_a_of_type_Pvn.notifyDataSetChanged();
    }
  }
  
  public void a(prb paramprb) {}
  
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
        i = (int)bbct.a(true) - this.jdField_a_of_type_Int - this.jdField_b_of_type_Int;
        localLayoutParams.width = ((i - actn.a(4.0F, getResources())) * 2 / 3 + actn.a(2.0F, getResources()));
        if (QLog.isColorLevel()) {
          QLog.d("ComponentContentGridImage", 2, new Object[] { "contentWidth: ", Integer.valueOf(i), ", layout.width: ", Integer.valueOf(localLayoutParams.width), ", MinOfWidthAndHeight: ", Long.valueOf(bbct.i()) });
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
      if ((pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()) == -1) && (paramMotionEvent.getAction() == 1) && (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Pvr != null)) {
        this.jdField_a_of_type_Pvr.a();
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
  
  public void setGalleryClickListener(pvq parampvq)
  {
    this.jdField_a_of_type_Pvq = parampvq;
  }
  
  public void setMIReadInJoyModel(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void setOnNoItemClickListener(pvr parampvr)
  {
    this.jdField_a_of_type_Pvr = parampvr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage
 * JD-Core Version:    0.7.0.1
 */