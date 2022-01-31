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
import lhp;
import lil;
import mgx;
import mhc;
import mhd;
import mhv;
import mhw;
import mqr;

public class MakeupView
  extends BeautyBaseView
  implements lhp<PendantItem>, mhc, mhd
{
  int jdField_a_of_type_Int = 50;
  final TextView jdField_a_of_type_AndroidWidgetTextView;
  final BeautySeekView jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView;
  final HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  String jdField_a_of_type_JavaLangString = null;
  final ArrayList<mhw> jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
  lil jdField_a_of_type_Lil = null;
  mgx jdField_a_of_type_Mgx = null;
  final ArrayList<mhw> b = new ArrayList(10);
  
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
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView = ((BeautySeekView)findViewById(2131363136));
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.setBeautySeekActionListener(this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)findViewById(2131367664));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setStayDisplayOffsetZero(true);
    b();
  }
  
  public static mhw a(PendantItem paramPendantItem)
  {
    mhw localmhw = new mhw();
    localmhw.jdField_a_of_type_Int = 4;
    localmhw.jdField_a_of_type_JavaLangString = paramPendantItem.getId();
    localmhw.jdField_c_of_type_JavaLangString = paramPendantItem.getDesc();
    localmhw.b = paramPendantItem.getIconurl();
    localmhw.jdField_d_of_type_JavaLangString = paramPendantItem.getDesc();
    localmhw.jdField_c_of_type_Boolean = false;
    localmhw.jdField_a_of_type_Boolean = paramPendantItem.isUsable();
    localmhw.jdField_a_of_type_JavaLangObject = paramPendantItem;
    localmhw.jdField_d_of_type_Boolean = true;
    return localmhw;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Mgx != null) && (this.jdField_a_of_type_Lil != null))
    {
      d();
      this.jdField_a_of_type_Mgx.a(this.b);
      this.jdField_a_of_type_Mgx.notifyDataSetChanged();
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
    if (this.jdField_a_of_type_Mgx != null) {
      this.jdField_a_of_type_Mgx.a(paramLong, paramPendantItem.getId(), paramBoolean);
    }
  }
  
  public void a(long paramLong, mhw parammhw)
  {
    PendantItem localPendantItem = null;
    if (QLog.isColorLevel()) {
      QLog.i("MakeupView", 2, "onEffectClick, seq[" + paramLong + "], info[" + parammhw + "]");
    }
    EffectSettingUi.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramLong);
    if (parammhw == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Lil != null) {
        this.jdField_a_of_type_Lil.a(paramLong, "onEffectClick");
      }
      if (TextUtils.equals("0", parammhw.jdField_a_of_type_JavaLangString))
      {
        if (this.jdField_a_of_type_Lil != null) {
          this.jdField_a_of_type_Lil.a(paramLong, null);
        }
        a(null);
        mqr.a("0X800AA64", 0, 0, "", "", "", "");
        return;
      }
      if (this.jdField_a_of_type_Lil != null) {
        localPendantItem = (PendantItem)this.jdField_a_of_type_Lil.a(parammhw.jdField_a_of_type_JavaLangString);
      }
    } while ((localPendantItem == null) || (TextUtils.isEmpty(localPendantItem.getId())));
    if (this.jdField_a_of_type_Lil != null) {
      this.jdField_a_of_type_Lil.a(paramLong, localPendantItem);
    }
    a(parammhw.jdField_a_of_type_JavaLangString);
    try
    {
      mqr.a("0X800AA62", Integer.parseInt(parammhw.jdField_a_of_type_JavaLangString));
      return;
    }
    catch (Throwable parammhw) {}
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Lil != null) {
      this.jdField_a_of_type_Lil.a(paramLong, this);
    }
    a();
  }
  
  public void a(PendantItem paramPendantItem, int paramInt)
  {
    if (this.jdField_a_of_type_Mgx != null) {
      this.jdField_a_of_type_Mgx.a(paramPendantItem.getId(), paramInt);
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
      if (this.jdField_a_of_type_Lil != null)
      {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_Lil.a(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Lil.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, false);
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
      } while (this.jdField_a_of_type_Lil == null);
      this.jdField_a_of_type_Lil.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, false);
      return;
    }
    this.jdField_a_of_type_Int = paramInt2;
    if (this.jdField_a_of_type_Lil != null) {
      this.jdField_a_of_type_Lil.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, true);
    }
    try
    {
      mqr.a("0X800AA63", Integer.parseInt(this.jdField_a_of_type_JavaLangString));
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
    String str = getContext().getResources().getString(2131695715);
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.a(str, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 0);
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Lil != null) {
      this.jdField_a_of_type_Lil.b(paramLong, this);
    }
  }
  
  public void c()
  {
    Object localObject2 = null;
    int j = 0;
    if (this.jdField_a_of_type_Lil != null) {
      if (this.jdField_a_of_type_Lil.a()) {
        break label123;
      }
    }
    label123:
    for (Object localObject1 = this.jdField_a_of_type_Lil.jdField_d_of_type_JavaLangString;; localObject1 = null)
    {
      int i = 0;
      if (i < this.b.size())
      {
        mhw localmhw = (mhw)this.b.get(i);
        if ((localmhw == null) || (!TextUtils.equals((CharSequence)localObject1, localmhw.jdField_a_of_type_JavaLangString))) {}
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
          if (this.jdField_a_of_type_Mgx != null) {
            BaseToolbar.setSelectedListViewItemAndShow(this.jdField_a_of_type_ComTencentWidgetHorizontalListView, this.jdField_a_of_type_Mgx, i);
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
    Object localObject1 = new mhw();
    ((mhw)localObject1).jdField_a_of_type_JavaLangString = "0";
    ((mhw)localObject1).b = String.valueOf(2130841686);
    ((mhw)localObject1).jdField_c_of_type_Boolean = false;
    ((mhw)localObject1).jdField_d_of_type_Boolean = true;
    ((mhw)localObject1).jdField_c_of_type_JavaLangString = getContext().getString(2131695704);
    ((mhw)localObject1).jdField_d_of_type_JavaLangString = getContext().getString(2131695705);
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
    if (this.jdField_a_of_type_Lil != null)
    {
      localObject1 = this.jdField_a_of_type_Lil.a(null);
      Object localObject2 = (PendantItem)this.jdField_a_of_type_Lil.a();
      if ((localObject2 != null) && (!((List)localObject1).contains(localObject2))) {
        this.jdField_a_of_type_Lil.a(l, null);
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
      this.jdField_a_of_type_Lil = ((lil)paramVideoAppInterface.a(13));
      this.jdField_a_of_type_Lil.a(l, this);
    }
    d();
    this.jdField_a_of_type_Mgx = new mgx(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, getContext(), this.b, this.jdField_a_of_type_ComTencentWidgetHorizontalListView, 5.6F);
    this.jdField_a_of_type_Mgx.a(this);
    this.jdField_a_of_type_Mgx.a(this);
    this.jdField_a_of_type_Mgx.a(true);
    this.jdField_a_of_type_Mgx.b(true);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Mgx);
    c();
  }
  
  public void startDownloadTemplate(AppInterface paramAppInterface, long paramLong, mhw parammhw, mhv parammhv)
  {
    paramAppInterface = null;
    if (this.jdField_a_of_type_Lil != null) {
      paramAppInterface = (PendantItem)this.jdField_a_of_type_Lil.a(parammhw.jdField_a_of_type_JavaLangString);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("MakeupView", 4, "startDownloadTemplate, seq[" + paramLong + "], item[" + paramAppInterface + "]");
    }
    if (paramAppInterface != null)
    {
      this.jdField_a_of_type_Lil.a(paramLong, paramAppInterface);
      return;
    }
    QLog.w("MakeupView", 1, "startDownloadTemplate, item为空, seq[" + paramLong + "]");
    parammhv.a(paramLong, parammhw.jdField_a_of_type_JavaLangString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.beauty.MakeupView
 * JD-Core Version:    0.7.0.1
 */