package com.tencent.av.ui.beauty;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.makeup.MakeupMng;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.ui.BaseToolbar;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.QAVPtvTemplateAdapter;
import com.tencent.av.ui.QAVPtvTemplateAdapter.IEffectCallback;
import com.tencent.av.ui.QavListItemBase.ItemInfo;
import com.tencent.av.ui.QavListItemHelper;
import com.tencent.av.utils.AVUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;

public class MakeupView
  extends BeautyBaseView
  implements QAVPtvTemplateAdapter.IEffectCallback
{
  int jdField_a_of_type_Int = 50;
  final TextView jdField_a_of_type_AndroidWidgetTextView;
  MakeupMng jdField_a_of_type_ComTencentAvBusinessManagerMakeupMakeupMng = null;
  QAVPtvTemplateAdapter jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter = null;
  QavListItemHelper jdField_a_of_type_ComTencentAvUiQavListItemHelper = null;
  final BeautySeekView jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView;
  final HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  String jdField_a_of_type_JavaLangString = null;
  final ArrayList<QavListItemBase.ItemInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
  
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
    inflate(paramContext, 2131559860, this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379392));
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView = ((BeautySeekView)findViewById(2131363565));
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.setBeautySeekActionListener(this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)findViewById(2131368580));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setStayDisplayOffsetZero(true);
    b();
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter != null) && (this.jdField_a_of_type_ComTencentAvBusinessManagerMakeupMakeupMng != null))
    {
      d();
      this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter.notifyDataSetChanged();
      c();
    }
  }
  
  public void a(long paramLong)
  {
    EffectSettingUi.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramLong);
  }
  
  public void a(long paramLong, QavListItemBase.ItemInfo paramItemInfo)
  {
    PendantItem localPendantItem = null;
    if (QLog.isColorLevel()) {
      QLog.i("MakeupView", 2, "onEffectClick, seq[" + paramLong + "], info[" + paramItemInfo + "]");
    }
    EffectSettingUi.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramLong);
    if (paramItemInfo == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentAvBusinessManagerMakeupMakeupMng != null) {
        this.jdField_a_of_type_ComTencentAvBusinessManagerMakeupMakeupMng.a(paramLong, "onEffectClick");
      }
      if (TextUtils.equals("0", paramItemInfo.jdField_a_of_type_JavaLangString))
      {
        if (this.jdField_a_of_type_ComTencentAvBusinessManagerMakeupMakeupMng != null) {
          this.jdField_a_of_type_ComTencentAvBusinessManagerMakeupMakeupMng.a(paramLong, null);
        }
        a(null);
        AVUtil.a("0X800AA64", 0, 0, "", "", "", "");
        return;
      }
      if (this.jdField_a_of_type_ComTencentAvBusinessManagerMakeupMakeupMng != null) {
        localPendantItem = (PendantItem)this.jdField_a_of_type_ComTencentAvBusinessManagerMakeupMakeupMng.a(paramItemInfo.jdField_a_of_type_JavaLangString);
      }
    } while ((localPendantItem == null) || (TextUtils.isEmpty(localPendantItem.getId())));
    if (this.jdField_a_of_type_ComTencentAvBusinessManagerMakeupMakeupMng != null) {
      this.jdField_a_of_type_ComTencentAvBusinessManagerMakeupMakeupMng.a(paramLong, localPendantItem);
    }
    a(paramItemInfo.jdField_a_of_type_JavaLangString);
    try
    {
      AVUtil.a("0X800AA62", Integer.parseInt(paramItemInfo.jdField_a_of_type_JavaLangString));
      return;
    }
    catch (Throwable paramItemInfo) {}
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvBusinessManagerMakeupMakeupMng != null) {
      this.jdField_a_of_type_ComTencentAvBusinessManagerMakeupMakeupMng.a(paramLong, this.jdField_a_of_type_ComTencentAvUiQavListItemHelper);
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
      if (this.jdField_a_of_type_ComTencentAvBusinessManagerMakeupMakeupMng != null)
      {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentAvBusinessManagerMakeupMakeupMng.a(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentAvBusinessManagerMakeupMakeupMng.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, false);
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
      } while (this.jdField_a_of_type_ComTencentAvBusinessManagerMakeupMakeupMng == null);
      this.jdField_a_of_type_ComTencentAvBusinessManagerMakeupMakeupMng.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, false);
      return;
    }
    this.jdField_a_of_type_Int = paramInt2;
    if (this.jdField_a_of_type_ComTencentAvBusinessManagerMakeupMakeupMng != null) {
      this.jdField_a_of_type_ComTencentAvBusinessManagerMakeupMakeupMng.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, true);
    }
    try
    {
      AVUtil.a("0X800AA63", Integer.parseInt(this.jdField_a_of_type_JavaLangString));
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
    String str = getContext().getResources().getString(2131695395);
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.a(str, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 0);
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvBusinessManagerMakeupMakeupMng != null) {
      this.jdField_a_of_type_ComTencentAvBusinessManagerMakeupMakeupMng.b(paramLong, this.jdField_a_of_type_ComTencentAvUiQavListItemHelper);
    }
  }
  
  public void c()
  {
    Object localObject2 = null;
    int j = 0;
    if (this.jdField_a_of_type_ComTencentAvBusinessManagerMakeupMakeupMng != null) {
      if (this.jdField_a_of_type_ComTencentAvBusinessManagerMakeupMakeupMng.a()) {
        break label123;
      }
    }
    label123:
    for (Object localObject1 = this.jdField_a_of_type_ComTencentAvBusinessManagerMakeupMakeupMng.d;; localObject1 = null)
    {
      int i = 0;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        QavListItemBase.ItemInfo localItemInfo = (QavListItemBase.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localItemInfo == null) || (!TextUtils.equals((CharSequence)localObject1, localItemInfo.jdField_a_of_type_JavaLangString))) {}
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
          if (this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter != null) {
            BaseToolbar.setSelectedListViewItemAndShow(this.jdField_a_of_type_ComTencentWidgetHorizontalListView, this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter, i);
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
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentAvUiQavListItemHelper.a(getContext());
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
      this.jdField_a_of_type_ComTencentAvBusinessManagerMakeupMakeupMng = ((MakeupMng)paramVideoAppInterface.a(13));
      this.jdField_a_of_type_ComTencentAvBusinessManagerMakeupMakeupMng.a(l, this.jdField_a_of_type_ComTencentAvUiQavListItemHelper);
    }
    this.jdField_a_of_type_ComTencentAvUiQavListItemHelper = new QavListItemHelper(4, this.jdField_a_of_type_ComTencentAvBusinessManagerMakeupMakeupMng);
    d();
    this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter = new QAVPtvTemplateAdapter(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, getContext(), this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentWidgetHorizontalListView, 5.6F);
    this.jdField_a_of_type_ComTencentAvUiQavListItemHelper.a(this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter);
    this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter.a(this);
    this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter.a(this.jdField_a_of_type_ComTencentAvUiQavListItemHelper);
    this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter.a(true);
    this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter.b(true);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.beauty.MakeupView
 * JD-Core Version:    0.7.0.1
 */