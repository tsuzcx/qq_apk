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
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import lhe;
import mgm;
import mgs;
import mhm;
import mhn;
import mqo;

public class MakeupView
  extends BeautyBaseView
  implements mgs
{
  int jdField_a_of_type_Int = 50;
  final TextView jdField_a_of_type_AndroidWidgetTextView;
  final BeautySeekView jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView;
  final HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  String jdField_a_of_type_JavaLangString = null;
  final ArrayList<mhm> jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
  lhe jdField_a_of_type_Lhe = null;
  mgm jdField_a_of_type_Mgm = null;
  mhn jdField_a_of_type_Mhn = null;
  
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
    inflate(paramContext, 2131559739, this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378735));
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView = ((BeautySeekView)findViewById(2131363358));
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.setBeautySeekActionListener(this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)findViewById(2131368121));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setStayDisplayOffsetZero(true);
    b();
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Mgm != null) && (this.jdField_a_of_type_Lhe != null))
    {
      d();
      this.jdField_a_of_type_Mgm.a(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_Mgm.notifyDataSetChanged();
      c();
    }
  }
  
  public void a(long paramLong)
  {
    EffectSettingUi.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramLong);
  }
  
  public void a(long paramLong, mhm parammhm)
  {
    PendantItem localPendantItem = null;
    if (QLog.isColorLevel()) {
      QLog.i("MakeupView", 2, "onEffectClick, seq[" + paramLong + "], info[" + parammhm + "]");
    }
    EffectSettingUi.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramLong);
    if (parammhm == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Lhe != null) {
        this.jdField_a_of_type_Lhe.a(paramLong, "onEffectClick");
      }
      if (TextUtils.equals("0", parammhm.jdField_a_of_type_JavaLangString))
      {
        if (this.jdField_a_of_type_Lhe != null) {
          this.jdField_a_of_type_Lhe.a(paramLong, null);
        }
        a(null);
        mqo.a("0X800AA64", 0, 0, "", "", "", "");
        return;
      }
      if (this.jdField_a_of_type_Lhe != null) {
        localPendantItem = (PendantItem)this.jdField_a_of_type_Lhe.a(parammhm.jdField_a_of_type_JavaLangString);
      }
    } while ((localPendantItem == null) || (TextUtils.isEmpty(localPendantItem.getId())));
    if (this.jdField_a_of_type_Lhe != null) {
      this.jdField_a_of_type_Lhe.a(paramLong, localPendantItem);
    }
    a(parammhm.jdField_a_of_type_JavaLangString);
    try
    {
      mqo.a("0X800AA62", Integer.parseInt(parammhm.jdField_a_of_type_JavaLangString));
      return;
    }
    catch (Throwable parammhm) {}
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Lhe != null) {
      this.jdField_a_of_type_Lhe.a(paramLong, this.jdField_a_of_type_Mhn);
    }
    a();
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.equals(paramString, this.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("MakeupView", 2, "changeCurSelItem, cur[" + paramString + "], pre[" + this.jdField_a_of_type_JavaLangString + "]");
      }
      this.jdField_a_of_type_JavaLangString = paramString;
      if (this.jdField_a_of_type_Lhe != null)
      {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_Lhe.a(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Lhe.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, false);
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
      } while (this.jdField_a_of_type_Lhe == null);
      this.jdField_a_of_type_Lhe.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, false);
      return;
    }
    this.jdField_a_of_type_Int = paramInt2;
    if (this.jdField_a_of_type_Lhe != null) {
      this.jdField_a_of_type_Lhe.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, true);
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
    String str = getContext().getResources().getString(2131694756);
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.a(str, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 0);
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Lhe != null) {
      this.jdField_a_of_type_Lhe.b(paramLong, this.jdField_a_of_type_Mhn);
    }
  }
  
  public void c()
  {
    Object localObject2 = null;
    int j = 0;
    if (this.jdField_a_of_type_Lhe != null) {
      if (this.jdField_a_of_type_Lhe.a()) {
        break label123;
      }
    }
    label123:
    for (Object localObject1 = this.jdField_a_of_type_Lhe.d;; localObject1 = null)
    {
      int i = 0;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        mhm localmhm = (mhm)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localmhm == null) || (!TextUtils.equals((CharSequence)localObject1, localmhm.jdField_a_of_type_JavaLangString))) {}
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
          if (this.jdField_a_of_type_Mgm != null) {
            BaseToolbar.setSelectedListViewItemAndShow(this.jdField_a_of_type_ComTencentWidgetHorizontalListView, this.jdField_a_of_type_Mgm, i);
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
    ArrayList localArrayList = this.jdField_a_of_type_Mhn.a(getContext());
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
  }
  
  public void onClick(View paramView) {}
  
  public void setAppInterface(VideoAppInterface paramVideoAppInterface)
  {
    super.setAppInterface(paramVideoAppInterface);
    long l = AudioHelper.b();
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_Lhe = ((lhe)paramVideoAppInterface.a(13));
      this.jdField_a_of_type_Lhe.a(l, this.jdField_a_of_type_Mhn);
    }
    this.jdField_a_of_type_Mhn = new mhn(4, this.jdField_a_of_type_Lhe);
    d();
    this.jdField_a_of_type_Mgm = new mgm(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, getContext(), this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentWidgetHorizontalListView, 5.6F);
    this.jdField_a_of_type_Mhn.a(this.jdField_a_of_type_Mgm);
    this.jdField_a_of_type_Mgm.a(this);
    this.jdField_a_of_type_Mgm.a(this.jdField_a_of_type_Mhn);
    this.jdField_a_of_type_Mgm.a(true);
    this.jdField_a_of_type_Mgm.b(true);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Mgm);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.beauty.MakeupView
 * JD-Core Version:    0.7.0.1
 */