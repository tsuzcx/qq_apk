package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import agej;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import bghf;
import bhlo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.GridView;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qbb;
import qdv;
import qdw;
import qdx;
import sel;

public class NativeGridImageView
  extends GridView
  implements IView
{
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private qdw jdField_a_of_type_Qdw;
  
  public NativeGridImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NativeGridImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842865);
  }
  
  public NativeGridImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
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
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      QLog.d("Proteus.NativeGridImageView", 1, "reportData, but articleInfo is null.");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
    {
      sel.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramInt1, paramInt2);
      paramInt1 = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
      sel.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramInt1);
      return;
    }
    QLog.d("Proteus.NativeGridImageView", 1, "reportData failed, articleInfo is null!");
  }
  
  private void a(int paramInt, List<URL> paramList)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (paramList == null)) {
      QLog.d("Proteus.NativeGridImageView", 1, "showPicture failed, mArticleInfo is null.");
    }
    for (;;)
    {
      return;
      String str1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl;
      String str2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTitle;
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Proteus.NativeGridImageView", 2, new Object[] { "ReadInJoy grid image show content url and title, articleUrl: " + str1, " articleTitle: " + str2 });
        }
        bghf.a((Activity)getContext(), paramInt, a(paramList), null, null, false, false, "4", 100, null, str1, str2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "");
      }
      while (paramList != null)
      {
        a(paramInt, paramList.size());
        return;
        bghf.a((Activity)getContext(), paramInt, a(paramList), null, null, false, false, "4", 100, null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "");
      }
    }
  }
  
  public void a()
  {
    setOnItemClickListener(new qdv(this));
  }
  
  public void a(Context paramContext)
  {
    setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    setNumColumns(3);
    setVerticalSpacing(agej.a(3.0F, paramContext.getResources()));
    setHorizontalSpacing(agej.a(3.0F, paramContext.getResources()));
    setSelector(17170445);
    a();
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo != null)
    {
      if (this.jdField_a_of_type_Qdw != null) {
        break label53;
      }
      this.jdField_a_of_type_Qdw = new qdw(this);
      this.jdField_a_of_type_Qdw.a(new qdx(this, paramArticleInfo));
      setAdapter(this.jdField_a_of_type_Qdw);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
      return;
      label53:
      this.jdField_a_of_type_Qdw.a(new qdx(this, paramArticleInfo));
    }
  }
  
  public void a(qbb paramqbb)
  {
    if (this.jdField_a_of_type_Qdw != null) {
      this.jdField_a_of_type_Qdw.notifyDataSetChanged();
    }
    b(paramqbb);
  }
  
  public void b(qbb paramqbb)
  {
    int i = getCount();
    Layout.Params localParams;
    if (i == 1)
    {
      setNumColumns(1);
      localParams = paramqbb.getComLayoutParams();
      if (i != 4) {
        break label173;
      }
      if (localParams != null)
      {
        i = (int)bhlo.m() - agej.a(24.0F, getResources());
        localParams.mLayoutWidth = ((i - agej.a(6.0F, getResources())) * 2 / 3 + agej.a(3.0F, getResources()));
        if (localParams.mLayoutWidth > 0) {
          paramqbb.setComLayoutParams(localParams);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Proteus.NativeGridImageView", 2, new Object[] { "contentWidth: ", Integer.valueOf(i), ", layout.width: ", Integer.valueOf(localParams.mLayoutWidth), ", MinOfWidthAndHeight: ", Long.valueOf(bhlo.m()) });
        }
      }
    }
    label173:
    do
    {
      do
      {
        return;
        if ((i == 2) || (i == 4))
        {
          setNumColumns(2);
          break;
        }
        setNumColumns(3);
        break;
      } while (localParams == null);
      i = (int)bhlo.m() - agej.a(24.0F, getResources());
      localParams.mLayoutWidth = i;
      if (localParams.mLayoutWidth > 0) {
        paramqbb.setComLayoutParams(localParams);
      }
    } while (!QLog.isColorLevel());
    QLog.d("Proteus.NativeGridImageView", 2, new Object[] { "contentWidth: ", Integer.valueOf(i), ", layout.width: ", Integer.valueOf(localParams.mLayoutWidth), ", MinOfWidthAndHeight: ", Long.valueOf(bhlo.m()) });
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onComLayout(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int getComMeasuredHeight()
  {
    return getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return getMeasuredWidth();
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    onComMeasure(paramInt1, paramInt2);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (getLayoutParams().height == -2) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(536870911, -2147483648);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeGridImageView
 * JD-Core Version:    0.7.0.1
 */