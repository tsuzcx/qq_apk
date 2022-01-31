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
import lhk;
import lig;
import mgs;
import mgx;
import mgy;
import mhq;
import mhr;
import mqo;

public class MakeupView
  extends BeautyBaseView
  implements lhk<PendantItem>, mgx, mgy
{
  int jdField_a_of_type_Int = 50;
  final TextView jdField_a_of_type_AndroidWidgetTextView;
  final BeautySeekView jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView;
  final HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  String jdField_a_of_type_JavaLangString = null;
  final ArrayList<mhr> jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
  lig jdField_a_of_type_Lig = null;
  mgs jdField_a_of_type_Mgs = null;
  final ArrayList<mhr> b = new ArrayList(10);
  
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
    inflate(paramContext, 2131559551, this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377313));
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView = ((BeautySeekView)findViewById(2131363135));
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.setBeautySeekActionListener(this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)findViewById(2131367664));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setStayDisplayOffsetZero(true);
    b();
  }
  
  public static mhr a(PendantItem paramPendantItem)
  {
    mhr localmhr = new mhr();
    localmhr.jdField_a_of_type_Int = 4;
    localmhr.jdField_a_of_type_JavaLangString = paramPendantItem.getId();
    localmhr.jdField_c_of_type_JavaLangString = paramPendantItem.getDesc();
    localmhr.b = paramPendantItem.getIconurl();
    localmhr.jdField_d_of_type_JavaLangString = paramPendantItem.getDesc();
    localmhr.jdField_c_of_type_Boolean = false;
    localmhr.jdField_a_of_type_Boolean = paramPendantItem.isUsable();
    localmhr.jdField_a_of_type_JavaLangObject = paramPendantItem;
    localmhr.jdField_d_of_type_Boolean = true;
    return localmhr;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Mgs != null) && (this.jdField_a_of_type_Lig != null))
    {
      d();
      this.jdField_a_of_type_Mgs.a(this.b);
      this.jdField_a_of_type_Mgs.notifyDataSetChanged();
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
    if (this.jdField_a_of_type_Mgs != null) {
      this.jdField_a_of_type_Mgs.a(paramLong, paramPendantItem.getId(), paramBoolean);
    }
  }
  
  public void a(long paramLong, mhr parammhr)
  {
    PendantItem localPendantItem = null;
    if (QLog.isColorLevel()) {
      QLog.i("MakeupView", 2, "onEffectClick, seq[" + paramLong + "], info[" + parammhr + "]");
    }
    EffectSettingUi.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramLong);
    if (parammhr == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Lig != null) {
        this.jdField_a_of_type_Lig.a(paramLong, "onEffectClick");
      }
      if (TextUtils.equals("0", parammhr.jdField_a_of_type_JavaLangString))
      {
        if (this.jdField_a_of_type_Lig != null) {
          this.jdField_a_of_type_Lig.a(paramLong, null);
        }
        a(null);
        mqo.a("0X800AA64", 0, 0, "", "", "", "");
        return;
      }
      if (this.jdField_a_of_type_Lig != null) {
        localPendantItem = (PendantItem)this.jdField_a_of_type_Lig.a(parammhr.jdField_a_of_type_JavaLangString);
      }
    } while ((localPendantItem == null) || (TextUtils.isEmpty(localPendantItem.getId())));
    if (this.jdField_a_of_type_Lig != null) {
      this.jdField_a_of_type_Lig.a(paramLong, localPendantItem);
    }
    a(parammhr.jdField_a_of_type_JavaLangString);
    try
    {
      mqo.a("0X800AA62", Integer.parseInt(parammhr.jdField_a_of_type_JavaLangString));
      return;
    }
    catch (Throwable parammhr) {}
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Lig != null) {
      this.jdField_a_of_type_Lig.a(paramLong, this);
    }
    a();
  }
  
  public void a(PendantItem paramPendantItem, int paramInt)
  {
    if (this.jdField_a_of_type_Mgs != null) {
      this.jdField_a_of_type_Mgs.a(paramPendantItem.getId(), paramInt);
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
      if (this.jdField_a_of_type_Lig != null)
      {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_Lig.a(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Lig.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, false);
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
      } while (this.jdField_a_of_type_Lig == null);
      this.jdField_a_of_type_Lig.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, false);
      return;
    }
    this.jdField_a_of_type_Int = paramInt2;
    if (this.jdField_a_of_type_Lig != null) {
      this.jdField_a_of_type_Lig.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, true);
    }
    try
    {
      mqo.a("0X800AA63", Integer.parseInt(this.jdField_a_of_type_JavaLangString));
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
    String str = getContext().getResources().getString(2131695716);
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.a(str, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 0);
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Lig != null) {
      this.jdField_a_of_type_Lig.b(paramLong, this);
    }
  }
  
  public void c()
  {
    Object localObject2 = null;
    int j = 0;
    if (this.jdField_a_of_type_Lig != null) {
      if (this.jdField_a_of_type_Lig.a()) {
        break label123;
      }
    }
    label123:
    for (Object localObject1 = this.jdField_a_of_type_Lig.jdField_d_of_type_JavaLangString;; localObject1 = null)
    {
      int i = 0;
      if (i < this.b.size())
      {
        mhr localmhr = (mhr)this.b.get(i);
        if ((localmhr == null) || (!TextUtils.equals((CharSequence)localObject1, localmhr.jdField_a_of_type_JavaLangString))) {}
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
          if (this.jdField_a_of_type_Mgs != null) {
            BaseToolbar.setSelectedListViewItemAndShow(this.jdField_a_of_type_ComTencentWidgetHorizontalListView, this.jdField_a_of_type_Mgs, i);
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
    Object localObject1 = new mhr();
    ((mhr)localObject1).jdField_a_of_type_JavaLangString = "0";
    ((mhr)localObject1).b = String.valueOf(2130841686);
    ((mhr)localObject1).jdField_c_of_type_Boolean = false;
    ((mhr)localObject1).jdField_d_of_type_Boolean = true;
    ((mhr)localObject1).jdField_c_of_type_JavaLangString = getContext().getString(2131695705);
    ((mhr)localObject1).jdField_d_of_type_JavaLangString = getContext().getString(2131695706);
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
    if (this.jdField_a_of_type_Lig != null)
    {
      localObject1 = this.jdField_a_of_type_Lig.a(null);
      Object localObject2 = (PendantItem)this.jdField_a_of_type_Lig.a();
      if ((localObject2 != null) && (!((List)localObject1).contains(localObject2))) {
        this.jdField_a_of_type_Lig.a(l, null);
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
      this.jdField_a_of_type_Lig = ((lig)paramVideoAppInterface.a(13));
      this.jdField_a_of_type_Lig.a(l, this);
    }
    d();
    this.jdField_a_of_type_Mgs = new mgs(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, getContext(), this.b, this.jdField_a_of_type_ComTencentWidgetHorizontalListView, 5.6F);
    this.jdField_a_of_type_Mgs.a(this);
    this.jdField_a_of_type_Mgs.a(this);
    this.jdField_a_of_type_Mgs.a(true);
    this.jdField_a_of_type_Mgs.b(true);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Mgs);
    c();
  }
  
  public void startDownloadTemplate(AppInterface paramAppInterface, long paramLong, mhr parammhr, mhq parammhq)
  {
    paramAppInterface = null;
    if (this.jdField_a_of_type_Lig != null) {
      paramAppInterface = (PendantItem)this.jdField_a_of_type_Lig.a(parammhr.jdField_a_of_type_JavaLangString);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("MakeupView", 4, "startDownloadTemplate, seq[" + paramLong + "], item[" + paramAppInterface + "]");
    }
    if (paramAppInterface != null)
    {
      this.jdField_a_of_type_Lig.a(paramLong, paramAppInterface);
      return;
    }
    QLog.w("MakeupView", 1, "startDownloadTemplate, item为空, seq[" + paramLong + "]");
    parammhq.a(paramLong, parammhr.jdField_a_of_type_JavaLangString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.beauty.MakeupView
 * JD-Core Version:    0.7.0.1
 */