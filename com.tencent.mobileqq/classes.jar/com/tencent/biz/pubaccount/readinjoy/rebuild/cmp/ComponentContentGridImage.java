package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import afur;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import anni;
import bfhe;
import bkpj;
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
import pha;
import pxk;
import qqs;
import qrb;
import qva;
import qvl;
import qvm;
import qvn;
import qvo;
import qvp;
import qvq;
import rhb;
import rhn;
import rho;
import rhs;
import rht;
import rhw;
import snh;
import svs;

public class ComponentContentGridImage
  extends GridView
  implements qqs
{
  public int a;
  public Object a;
  private qva jdField_a_of_type_Qva;
  private qvm jdField_a_of_type_Qvm;
  private qvp jdField_a_of_type_Qvp;
  private qvq jdField_a_of_type_Qvq;
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
    this.jdField_a_of_type_Int = afur.a(12.0F, getResources());
    this.jdField_b_of_type_Int = afur.a(12.0F, getResources());
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
  
  public static qvn a(ArticleInfo paramArticleInfo)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhs.jdField_a_of_type_JavaUtilArrayList.iterator();
    rht localrht;
    if (paramArticleInfo.hasNext()) {
      localrht = (rht)paramArticleInfo.next();
    }
    for (;;)
    {
      try
      {
        int i = localArrayList1.size();
        if (i >= 9) {
          return new qvo().a(localArrayList1).b(localArrayList2).a();
        }
        i = localrht.jdField_a_of_type_Int;
        int j = localrht.jdField_b_of_type_Int;
        URL localURL = new URL(localrht.jdField_c_of_type_JavaLangString);
        if (localrht.jdField_c_of_type_Int != 1) {
          break label207;
        }
        bool = true;
        localArrayList1.add(new svs(i, j, localURL, bool));
        localArrayList2.add(new URL(localrht.jdField_b_of_type_JavaLangString));
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
  
  public static qvn a(Object paramObject, int paramInt)
  {
    qvo localqvo = new qvo();
    ArticleInfo localArticleInfo;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    int i;
    boolean bool2;
    boolean bool1;
    long l1;
    int j;
    if ((paramObject instanceof pxk))
    {
      localArticleInfo = ((pxk)paramObject).a();
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      if ((localArticleInfo != null) && (localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhn != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhn.jdField_a_of_type_JavaUtilArrayList != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhn.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        localArrayList3 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhn.jdField_a_of_type_JavaUtilArrayList;
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
        if (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhn.jdField_a_of_type_Rhb == null) {
          break label739;
        }
        bool1 = true;
        l2 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhn.jdField_a_of_type_Rhb.a;
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
            localqvo.b(localArrayList1);
            localqvo.a(localArrayList2);
            if (localArticleInfo != null)
            {
              if (!TextUtils.isEmpty(localArticleInfo.mArticleContentUrl)) {
                localqvo.a(localArticleInfo.mArticleContentUrl);
              }
              if ((localArticleInfo.mSocialFeedInfo == null) || (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhn == null) || (TextUtils.isEmpty(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhn.jdField_a_of_type_JavaLangString))) {
                break label714;
              }
              localqvo.b(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhn.jdField_a_of_type_JavaLangString);
            }
            localqvo.a(paramInt);
            return localqvo.a();
          }
          rho localrho = (rho)localArrayList3.get(j);
          if ((localrho.jdField_b_of_type_JavaLangString == null) && (localrho.jdField_c_of_type_JavaLangString == null)) {
            break;
          }
          bkpj.a("ComponentContentGridImage.log");
          if (QLog.isColorLevel())
          {
            if (localrho.jdField_b_of_type_JavaLangString != null) {
              QLog.d("Q.readinjoy.ui", 2, "Grid Image url [" + j + "]: " + localrho.jdField_b_of_type_JavaLangString);
            }
            if (localrho.jdField_c_of_type_JavaLangString != null) {
              QLog.d("Q.readinjoy.ui", 2, "Grid thumbNail Image url [" + j + "]: " + localrho.jdField_c_of_type_JavaLangString);
            }
          }
          bkpj.a();
          bkpj.a("ComponentContentGridImage.setImageUrl");
          if (localrho.jdField_b_of_type_JavaLangString != null)
          {
            paramObject = localrho.jdField_b_of_type_JavaLangString;
            URL localURL = new URL(paramObject);
            if (localrho.jdField_c_of_type_JavaLangString != null)
            {
              paramObject = localrho.jdField_c_of_type_JavaLangString;
              paramObject = new URL(paramObject);
              bkpj.a();
              localArrayList1.add(localURL);
              bkpj.a("ComponentContentGridImage.PicInfo");
              k = localrho.jdField_a_of_type_Int;
              int m = localrho.jdField_b_of_type_Int;
              if (localrho.jdField_c_of_type_Int != 1) {
                continue;
              }
              bool2 = true;
              paramObject = new svs(k, m, paramObject, bool2);
              if ((bool1) && (j == i - 1))
              {
                paramObject.b(bool1);
                paramObject.a(l1 + anni.a(2131701122));
              }
              bkpj.a();
              localArrayList2.add(paramObject);
              break;
            }
          }
          else
          {
            paramObject = localrho.jdField_c_of_type_JavaLangString;
            continue;
          }
          paramObject = localrho.jdField_b_of_type_JavaLangString;
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
          localqvo.b(localArticleInfo.mTitle);
        }
      }
      label739:
      break;
      j += 1;
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_JavaLangObject instanceof pxk))
    {
      ArticleInfo localArticleInfo = ((pxk)this.jdField_a_of_type_JavaLangObject).a();
      if (localArticleInfo != null)
      {
        snh.a(localArticleInfo, paramInt1, paramInt2);
        paramInt2 = -1;
        paramInt1 = paramInt2;
        if (this.jdField_a_of_type_Qva != null)
        {
          paramInt1 = paramInt2;
          if (this.jdField_a_of_type_Qva.a != null) {
            paramInt1 = this.jdField_a_of_type_Qva.a.e();
          }
        }
        snh.b(localArticleInfo, paramInt1);
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
    String str1 = this.jdField_a_of_type_Qvm.a();
    String str2 = this.jdField_a_of_type_Qvm.b();
    ArticleInfo localArticleInfo = null;
    if ((this.jdField_a_of_type_JavaLangObject instanceof pxk)) {
      localArticleInfo = ((pxk)this.jdField_a_of_type_JavaLangObject).a();
    }
    if (pha.l(localArticleInfo))
    {
      str1 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhw.f;
      str2 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhw.jdField_b_of_type_JavaLangString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.ui", 2, new Object[] { "ReadInJoy grid image show content url and title, articleUrl: " + str1, " articleTitle: " + str2 });
    }
    if ((localArticleInfo != null) && (localArticleInfo.isPGCShortContent())) {}
    try
    {
      localArticleInfo.clickArea = d();
      pha.b(this.jdField_a_of_type_Qva.a.a().a().getContext(), localArticleInfo, (int)localArticleInfo.mChannelID);
      if ((this.jdField_a_of_type_Qva != null) && (this.jdField_a_of_type_Qva.a != null) && (this.jdField_a_of_type_Qva.a.a() != null) && (this.jdField_a_of_type_Qva.a.a().a() != null)) {
        bfhe.a(this.jdField_a_of_type_Qva.a.a().a(), paramInt, a(paramList), null, null, false, false, "4", 100, null, str1, str2, localArticleInfo, "");
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
    setOnItemClickListener(new qvl(this));
  }
  
  public void a(Context paramContext)
  {
    setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    setNumColumns(3);
    setVerticalSpacing(afur.a(1.0F, paramContext.getResources()));
    setHorizontalSpacing(afur.a(1.0F, paramContext.getResources()));
    setSelector(17170445);
    a();
    this.jdField_a_of_type_Qva = new qva();
  }
  
  public void a(View paramView)
  {
    ((SquareCornerTextImageView)paramView).jdField_a_of_type_Boolean = false;
  }
  
  public void a(Object paramObject)
  {
    if (!(paramObject instanceof qvn))
    {
      QLog.e("ComponentContentGridImage", 1, "unsupported model type.", new IllegalArgumentException());
      return;
    }
    this.jdField_c_of_type_Int = ((qvn)paramObject).a();
    if (this.jdField_a_of_type_Qvm == null)
    {
      this.jdField_a_of_type_Qvm = new qvm(this, (qvn)paramObject);
      setAdapter(this.jdField_a_of_type_Qvm);
    }
    for (;;)
    {
      b();
      if ((this.jdField_a_of_type_Qva == null) || (!(this.jdField_a_of_type_JavaLangObject instanceof pxk))) {
        break;
      }
      this.jdField_a_of_type_Qva.a((pxk)this.jdField_a_of_type_JavaLangObject);
      return;
      this.jdField_a_of_type_Qvm.a((qvn)paramObject);
      this.jdField_a_of_type_Qvm.notifyDataSetChanged();
    }
  }
  
  public void a(qrb paramqrb) {}
  
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
      if ((pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()) == -1) && (paramMotionEvent.getAction() == 1) && (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Qvq != null)) {
        this.jdField_a_of_type_Qvq.a();
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
  
  public void setGalleryClickListener(qvp paramqvp)
  {
    this.jdField_a_of_type_Qvp = paramqvp;
  }
  
  public void setMIReadInJoyModel(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void setOnNoItemClickListener(qvq paramqvq)
  {
    this.jdField_a_of_type_Qvq = paramqvq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage
 * JD-Core Version:    0.7.0.1
 */