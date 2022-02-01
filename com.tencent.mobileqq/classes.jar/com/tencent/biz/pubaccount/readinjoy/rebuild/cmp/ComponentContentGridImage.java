package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import anvx;
import bfxp;
import blfz;
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
import pqb;
import pqw;
import qfw;
import rbo;
import rbx;
import rfw;
import rgh;
import rgi;
import rgj;
import rgk;
import rgl;
import rgm;
import rqz;
import rrl;
import rrm;
import rrq;
import rrr;
import rru;
import szd;
import teh;

public class ComponentContentGridImage
  extends GridView
  implements rbo
{
  public int a;
  public Object a;
  private rfw jdField_a_of_type_Rfw;
  private rgi jdField_a_of_type_Rgi;
  private rgl jdField_a_of_type_Rgl;
  private rgm jdField_a_of_type_Rgm;
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
  
  public static rgj a(ArticleInfo paramArticleInfo)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_a_of_type_JavaUtilArrayList.iterator();
    rrr localrrr;
    if (paramArticleInfo.hasNext()) {
      localrrr = (rrr)paramArticleInfo.next();
    }
    for (;;)
    {
      try
      {
        int i = localArrayList1.size();
        if (i >= 9) {
          return new rgk().a(localArrayList1).b(localArrayList2).a();
        }
        i = localrrr.jdField_a_of_type_Int;
        int j = localrrr.jdField_b_of_type_Int;
        URL localURL = new URL(localrrr.jdField_c_of_type_JavaLangString);
        if (localrrr.jdField_c_of_type_Int != 1) {
          break label207;
        }
        bool = true;
        localArrayList1.add(new teh(i, j, localURL, bool));
        localArrayList2.add(new URL(localrrr.jdField_b_of_type_JavaLangString));
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
  
  public static rgj a(Object paramObject, int paramInt)
  {
    rgk localrgk = new rgk();
    if ((paramObject instanceof qfw))
    {
      paramObject = ((qfw)paramObject).a();
      a(paramInt, localrgk, paramObject);
      if (paramObject != null)
      {
        a(localrgk, paramObject);
        b(localrgk, paramObject);
      }
      localrgk.a(paramInt);
    }
    return localrgk.a();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_JavaLangObject instanceof qfw))
    {
      ArticleInfo localArticleInfo = ((qfw)this.jdField_a_of_type_JavaLangObject).a();
      if (localArticleInfo != null)
      {
        pqb.a(localArticleInfo, paramInt1, paramInt2);
        paramInt2 = -1;
        paramInt1 = paramInt2;
        if (this.jdField_a_of_type_Rfw != null)
        {
          paramInt1 = paramInt2;
          if (this.jdField_a_of_type_Rfw.a != null) {
            paramInt1 = this.jdField_a_of_type_Rfw.a.e();
          }
        }
        pqb.a(localArticleInfo, paramInt1);
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
    String str1 = this.jdField_a_of_type_Rgi.a();
    String str2 = this.jdField_a_of_type_Rgi.b();
    ArticleInfo localArticleInfo = null;
    if ((this.jdField_a_of_type_JavaLangObject instanceof qfw)) {
      localArticleInfo = ((qfw)this.jdField_a_of_type_JavaLangObject).a();
    }
    if (pqw.m(localArticleInfo))
    {
      str1 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rru.f;
      str2 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rru.jdField_b_of_type_JavaLangString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.ui", 2, new Object[] { "ReadInJoy grid image show content url and title, articleUrl: " + str1, " articleTitle: " + str2 });
    }
    if ((localArticleInfo != null) && (localArticleInfo.isPGCShortContent())) {}
    try
    {
      localArticleInfo.clickArea = a();
      pqb.a(this.jdField_a_of_type_Rfw.a.a().a().getContext(), localArticleInfo, (int)localArticleInfo.mChannelID);
      if ((this.jdField_a_of_type_Rfw != null) && (this.jdField_a_of_type_Rfw.a != null) && (this.jdField_a_of_type_Rfw.a.a() != null) && (this.jdField_a_of_type_Rfw.a.a().a() != null)) {
        bfxp.a(this.jdField_a_of_type_Rfw.a.a().a(), paramInt, a(paramList), null, null, false, false, "4", 100, null, str1, str2, localArticleInfo, "");
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
  
  static void a(int paramInt, rgk paramrgk, ArticleInfo paramArticleInfo)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3;
    int i;
    boolean bool2;
    boolean bool1;
    long l1;
    if ((paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.jdField_a_of_type_JavaUtilArrayList != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      localArrayList3 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.jdField_a_of_type_JavaUtilArrayList;
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
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.jdField_a_of_type_Rqz == null) {
        break label486;
      }
      bool1 = true;
      l2 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.jdField_a_of_type_Rqz.a;
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
          paramrgk.b(localArrayList1);
          paramrgk.a(localArrayList2);
          return;
        }
        rrm localrrm = (rrm)localArrayList3.get(i);
        if ((localrrm.jdField_b_of_type_JavaLangString == null) && (localrrm.jdField_c_of_type_JavaLangString == null)) {
          break label491;
        }
        a(i, localrrm);
        blfz.a("ComponentContentGridImage.setImageUrl");
        label309:
        int k;
        if (localrrm.jdField_b_of_type_JavaLangString != null)
        {
          paramArticleInfo = localrrm.jdField_b_of_type_JavaLangString;
          URL localURL = new URL(paramArticleInfo);
          if (localrrm.jdField_c_of_type_JavaLangString == null) {
            break label448;
          }
          paramArticleInfo = localrrm.jdField_c_of_type_JavaLangString;
          paramArticleInfo = new URL(paramArticleInfo);
          blfz.a();
          localArrayList1.add(localURL);
          blfz.a("ComponentContentGridImage.PicInfo");
          j = localrrm.jdField_a_of_type_Int;
          k = localrrm.jdField_b_of_type_Int;
          if (localrrm.jdField_c_of_type_Int != 1) {
            break label457;
          }
        }
        label448:
        label457:
        for (bool2 = true;; bool2 = false)
        {
          paramArticleInfo = new teh(j, k, paramArticleInfo, bool2);
          if ((bool1) && (i == paramInt - 1))
          {
            paramArticleInfo.b(bool1);
            paramArticleInfo.a(l1 + anvx.a(2131701815));
          }
          blfz.a();
          localArrayList2.add(paramArticleInfo);
          break label491;
          paramArticleInfo = localrrm.jdField_c_of_type_JavaLangString;
          break;
          paramArticleInfo = localrrm.jdField_b_of_type_JavaLangString;
          break label309;
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
  
  private static void a(int paramInt, rrm paramrrm)
  {
    blfz.a("ComponentContentGridImage.log");
    if (QLog.isColorLevel())
    {
      if (paramrrm.jdField_b_of_type_JavaLangString != null) {
        QLog.d("Q.readinjoy.ui", 2, "Grid Image url [" + paramInt + "]: " + paramrrm.jdField_b_of_type_JavaLangString);
      }
      if (paramrrm.jdField_c_of_type_JavaLangString != null) {
        QLog.d("Q.readinjoy.ui", 2, "Grid thumbNail Image url [" + paramInt + "]: " + paramrrm.jdField_c_of_type_JavaLangString);
      }
    }
    blfz.a();
  }
  
  static void a(rgk paramrgk, ArticleInfo paramArticleInfo)
  {
    if (!TextUtils.isEmpty(paramArticleInfo.mArticleContentUrl)) {
      paramrgk.a(paramArticleInfo.mArticleContentUrl);
    }
  }
  
  static void b(rgk paramrgk, ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl != null) && (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.jdField_a_of_type_JavaLangString))) {
      paramrgk.b(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.jdField_a_of_type_JavaLangString);
    }
    while (TextUtils.isEmpty(paramArticleInfo.mTitle)) {
      return;
    }
    paramrgk.b(paramArticleInfo.mTitle);
  }
  
  protected int a()
  {
    return 9;
  }
  
  public void a()
  {
    setOnItemClickListener(new rgh(this));
  }
  
  public void a(Context paramContext)
  {
    setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    setNumColumns(3);
    setVerticalSpacing(AIOUtils.dp2px(1.0F, paramContext.getResources()));
    setHorizontalSpacing(AIOUtils.dp2px(1.0F, paramContext.getResources()));
    setSelector(17170445);
    a();
    this.jdField_a_of_type_Rfw = new rfw();
  }
  
  public void a(View paramView)
  {
    ((SquareCornerTextImageView)paramView).jdField_a_of_type_Boolean = false;
  }
  
  public void a(Object paramObject)
  {
    if (!(paramObject instanceof rgj))
    {
      QLog.e("ComponentContentGridImage", 1, "unsupported model type.", new IllegalArgumentException());
      return;
    }
    this.jdField_c_of_type_Int = ((rgj)paramObject).a();
    if (this.jdField_a_of_type_Rgi == null)
    {
      this.jdField_a_of_type_Rgi = new rgi(this, (rgj)paramObject);
      setAdapter(this.jdField_a_of_type_Rgi);
    }
    for (;;)
    {
      b();
      if ((this.jdField_a_of_type_Rfw == null) || (!(this.jdField_a_of_type_JavaLangObject instanceof qfw))) {
        break;
      }
      this.jdField_a_of_type_Rfw.a((qfw)this.jdField_a_of_type_JavaLangObject);
      return;
      this.jdField_a_of_type_Rgi.a((rgj)paramObject);
      this.jdField_a_of_type_Rgi.notifyDataSetChanged();
    }
  }
  
  public void a(rbx paramrbx) {}
  
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
      if ((pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()) == -1) && (paramMotionEvent.getAction() == 1) && (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Rgm != null)) {
        this.jdField_a_of_type_Rgm.a();
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
  
  public void setGalleryClickListener(rgl paramrgl)
  {
    this.jdField_a_of_type_Rgl = paramrgl;
  }
  
  public void setMIReadInJoyModel(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void setOnNoItemClickListener(rgm paramrgm)
  {
    this.jdField_a_of_type_Rgm = paramrgm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage
 * JD-Core Version:    0.7.0.1
 */