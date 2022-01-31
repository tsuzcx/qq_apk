package com.tencent.av.ui.beauty;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.ui.BaseToolbar;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ljn;
import lkj;
import mjk;
import mjp;
import mjq;
import mki;
import mkj;
import mti;

public class MakeupView
  extends BeautyBaseView
  implements ljn<PendantItem>, mjp, mjq
{
  int jdField_a_of_type_Int = 50;
  final TextView jdField_a_of_type_AndroidWidgetTextView;
  final BeautySeekView jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView;
  final HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  String jdField_a_of_type_JavaLangString = null;
  final ArrayList<mkj> jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
  lkj jdField_a_of_type_Lkj = null;
  mjk jdField_a_of_type_Mjk = null;
  final ArrayList<mkj> b = new ArrayList(10);
  
  public MakeupView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MakeupView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MakeupView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    inflate(paramContext, 2131559602, this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377896));
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView = ((BeautySeekView)findViewById(2131363171));
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.setBeautySeekActionListener(this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)findViewById(2131367803));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setStayDisplayOffsetZero(true);
    b();
  }
  
  public static mkj a(PendantItem paramPendantItem)
  {
    mkj localmkj = new mkj();
    localmkj.jdField_a_of_type_Int = 4;
    localmkj.jdField_a_of_type_JavaLangString = paramPendantItem.getId();
    localmkj.jdField_c_of_type_JavaLangString = paramPendantItem.getDesc();
    localmkj.b = paramPendantItem.getIconurl();
    localmkj.jdField_d_of_type_JavaLangString = paramPendantItem.getDesc();
    localmkj.jdField_c_of_type_Boolean = false;
    localmkj.jdField_a_of_type_Boolean = paramPendantItem.isUsable();
    localmkj.jdField_a_of_type_JavaLangObject = paramPendantItem;
    localmkj.jdField_d_of_type_Boolean = true;
    return localmkj;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Mjk != null) && (this.jdField_a_of_type_Lkj != null))
    {
      d();
      this.jdField_a_of_type_Mjk.a(this.b);
      this.jdField_a_of_type_Mjk.notifyDataSetChanged();
      c();
    }
  }
  
  public void a(long paramLong)
  {
    EffectSettingUi.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramLong);
  }
  
  public void a(long paramLong, PendantItem paramPendantItem)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MakeupView", 4, "onItemSelectedChanged, seq[" + paramLong + "], current[" + paramPendantItem + "]");
    }
  }
  
  public void a(long paramLong, PendantItem paramPendantItem, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MakeupView", 4, "onDownloadFinish, seq[" + paramLong + "], isSuc[" + paramBoolean + "], info[" + paramPendantItem + "]");
    }
    if (this.jdField_a_of_type_Mjk != null) {
      this.jdField_a_of_type_Mjk.a(paramLong, paramPendantItem.getId(), paramBoolean);
    }
  }
  
  public void a(long paramLong, mkj parammkj)
  {
    PendantItem localPendantItem = null;
    if (QLog.isColorLevel()) {
      QLog.i("MakeupView", 2, "onEffectClick, seq[" + paramLong + "], info[" + parammkj + "]");
    }
    EffectSettingUi.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramLong);
    if (parammkj == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Lkj != null) {
        this.jdField_a_of_type_Lkj.a(paramLong, "onEffectClick");
      }
      if (TextUtils.equals("0", parammkj.jdField_a_of_type_JavaLangString))
      {
        if (this.jdField_a_of_type_Lkj != null) {
          this.jdField_a_of_type_Lkj.a(paramLong, null);
        }
        a(null);
        mti.a("0X800AA64", 0, 0, "", "", "", "");
        return;
      }
      if (this.jdField_a_of_type_Lkj != null) {
        localPendantItem = (PendantItem)this.jdField_a_of_type_Lkj.a(parammkj.jdField_a_of_type_JavaLangString);
      }
    } while ((localPendantItem == null) || (TextUtils.isEmpty(localPendantItem.getId())));
    if (this.jdField_a_of_type_Lkj != null) {
      this.jdField_a_of_type_Lkj.a(paramLong, localPendantItem);
    }
    a(parammkj.jdField_a_of_type_JavaLangString);
    try
    {
      mti.a("0X800AA62", Integer.parseInt(parammkj.jdField_a_of_type_JavaLangString));
      return;
    }
    catch (Throwable parammkj) {}
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Lkj != null) {
      this.jdField_a_of_type_Lkj.a(paramLong, this);
    }
    a();
  }
  
  public void a(PendantItem paramPendantItem, int paramInt)
  {
    if (this.jdField_a_of_type_Mjk != null) {
      this.jdField_a_of_type_Mjk.a(paramPendantItem.getId(), paramInt);
    }
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.equals(paramString, this.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("MakeupView", 2, "changeCurSelItem, cur[" + paramString + "], pre[" + this.jdField_a_of_type_JavaLangString + "]");
      }
      this.jdField_a_of_type_JavaLangString = paramString;
      if (this.jdField_a_of_type_Lkj != null)
      {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_Lkj.a(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Lkj.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, false);
      }
      b();
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case 1: 
    default: 
    case 2: 
      do
      {
        return;
        this.jdField_a_of_type_Int = paramInt2;
      } while (this.jdField_a_of_type_Lkj == null);
      this.jdField_a_of_type_Lkj.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, false);
      return;
    }
    this.jdField_a_of_type_Int = paramInt2;
    if (this.jdField_a_of_type_Lkj != null) {
      this.jdField_a_of_type_Lkj.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, true);
    }
    try
    {
      mti.a("0X800AA63", Integer.parseInt(this.jdField_a_of_type_JavaLangString));
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public void b()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView != null) {
        this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.setVisibility(8);
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    } while (this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView == null);
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.setVisibility(0);
    String str = getContext().getResources().getString(2131695878);
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.a(str, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 0);
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Lkj != null) {
      this.jdField_a_of_type_Lkj.b(paramLong, this);
    }
  }
  
  public void c()
  {
    Object localObject2 = null;
    int j = 0;
    if (this.jdField_a_of_type_Lkj != null) {
      if (this.jdField_a_of_type_Lkj.a()) {
        break label123;
      }
    }
    label123:
    for (Object localObject1 = this.jdField_a_of_type_Lkj.jdField_d_of_type_JavaLangString;; localObject1 = null)
    {
      int i = 0;
      if (i < this.b.size())
      {
        mkj localmkj = (mkj)this.b.get(i);
        if ((localmkj == null) || (!TextUtils.equals((CharSequence)localObject1, localmkj.jdField_a_of_type_JavaLangString))) {}
      }
      for (;;)
      {
        if (i < 1)
        {
          i = j;
          localObject1 = localObject2;
        }
        for (;;)
        {
          a((String)localObject1);
          if (this.jdField_a_of_type_Mjk != null) {
            BaseToolbar.setSelectedListViewItemAndShow(this.jdField_a_of_type_ComTencentWidgetHorizontalListView, this.jdField_a_of_type_Mjk, i);
          }
          return;
          i += 1;
          break;
        }
        i = -1;
      }
    }
  }
  
  void d()
  {
    long l = AudioHelper.b();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    Object localObject1 = new mkj();
    ((mkj)localObject1).jdField_a_of_type_JavaLangString = "0";
    ((mkj)localObject1).b = String.valueOf(2130841850);
    ((mkj)localObject1).jdField_c_of_type_Boolean = false;
    ((mkj)localObject1).jdField_d_of_type_Boolean = true;
    ((mkj)localObject1).jdField_c_of_type_JavaLangString = getContext().getString(2131695867);
    ((mkj)localObject1).jdField_d_of_type_JavaLangString = getContext().getString(2131695868);
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
    if (this.jdField_a_of_type_Lkj != null)
    {
      localObject1 = this.jdField_a_of_type_Lkj.a(null);
      Object localObject2 = (PendantItem)this.jdField_a_of_type_Lkj.a();
      if ((localObject2 != null) && (!((List)localObject1).contains(localObject2))) {
        this.jdField_a_of_type_Lkj.a(l, null);
      }
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (PendantItem)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            localObject2 = a((PendantItem)localObject2);
            if (localObject2 != null) {
              this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
            }
          }
        }
      }
    }
    this.b.clear();
    this.b.addAll(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public void onClick(View paramView) {}
  
  public void setAppInterface(VideoAppInterface paramVideoAppInterface)
  {
    super.setAppInterface(paramVideoAppInterface);
    long l = AudioHelper.b();
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_Lkj = ((lkj)paramVideoAppInterface.a(13));
      this.jdField_a_of_type_Lkj.a(l, this);
    }
    d();
    this.jdField_a_of_type_Mjk = new mjk(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, getContext(), this.b, this.jdField_a_of_type_ComTencentWidgetHorizontalListView, 5.6F);
    this.jdField_a_of_type_Mjk.a(this);
    this.jdField_a_of_type_Mjk.a(this);
    this.jdField_a_of_type_Mjk.a(true);
    this.jdField_a_of_type_Mjk.b(true);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Mjk);
    c();
  }
  
  public void startDownloadTemplate(AppInterface paramAppInterface, long paramLong, mkj parammkj, mki parammki)
  {
    paramAppInterface = null;
    if (this.jdField_a_of_type_Lkj != null) {
      paramAppInterface = (PendantItem)this.jdField_a_of_type_Lkj.a(parammkj.jdField_a_of_type_JavaLangString);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("MakeupView", 4, "startDownloadTemplate, seq[" + paramLong + "], item[" + paramAppInterface + "]");
    }
    if (paramAppInterface != null)
    {
      this.jdField_a_of_type_Lkj.a(paramLong, paramAppInterface);
      return;
    }
    QLog.w("MakeupView", 1, "startDownloadTemplate, item为空, seq[" + paramLong + "]");
    parammki.a(paramLong, parammkj.jdField_a_of_type_JavaLangString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.beauty.MakeupView
 * JD-Core Version:    0.7.0.1
 */