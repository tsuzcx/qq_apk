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
import com.tencent.av.utils.AudioHelper;
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
    inflate(paramContext, 2131559736, this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378743));
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView = ((BeautySeekView)findViewById(2131363489));
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.setBeautySeekActionListener(this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)findViewById(2131368321));
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onEffectClick, seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("], info[");
      ((StringBuilder)localObject).append(paramItemInfo);
      ((StringBuilder)localObject).append("]");
      QLog.i("MakeupView", 2, ((StringBuilder)localObject).toString());
    }
    EffectSettingUi.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramLong);
    if (paramItemInfo == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvBusinessManagerMakeupMakeupMng;
    if (localObject != null) {
      ((MakeupMng)localObject).a(paramLong, "onEffectClick");
    }
    boolean bool = TextUtils.equals("0", paramItemInfo.jdField_a_of_type_JavaLangString);
    localObject = null;
    if (bool)
    {
      paramItemInfo = this.jdField_a_of_type_ComTencentAvBusinessManagerMakeupMakeupMng;
      if (paramItemInfo != null) {
        paramItemInfo.a(paramLong, null);
      }
      a(null);
      AVUtil.a("0X800AA64", 0, 0, "", "", "", "");
      return;
    }
    MakeupMng localMakeupMng = this.jdField_a_of_type_ComTencentAvBusinessManagerMakeupMakeupMng;
    if (localMakeupMng != null) {
      localObject = (PendantItem)localMakeupMng.a(paramItemInfo.jdField_a_of_type_JavaLangString);
    }
    if (localObject != null)
    {
      if (TextUtils.isEmpty(((PendantItem)localObject).getId())) {
        return;
      }
      localMakeupMng = this.jdField_a_of_type_ComTencentAvBusinessManagerMakeupMakeupMng;
      if (localMakeupMng != null) {
        localMakeupMng.a(paramLong, (PendantItem)localObject);
      }
      a(paramItemInfo.jdField_a_of_type_JavaLangString);
    }
    try
    {
      AVUtil.a("0X800AA62", Integer.parseInt(paramItemInfo.jdField_a_of_type_JavaLangString));
      return;
    }
    catch (Throwable paramItemInfo) {}
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    MakeupMng localMakeupMng = this.jdField_a_of_type_ComTencentAvBusinessManagerMakeupMakeupMng;
    if (localMakeupMng != null) {
      localMakeupMng.a(paramLong, this.jdField_a_of_type_ComTencentAvUiQavListItemHelper);
    }
    a();
  }
  
  public void a(QavListItemBase.ItemInfo paramItemInfo) {}
  
  public void a(String paramString)
  {
    if (!TextUtils.equals(paramString, this.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("changeCurSelItem, cur[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("], pre[");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append("]");
        QLog.i("MakeupView", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_JavaLangString = paramString;
      paramString = this.jdField_a_of_type_ComTencentAvBusinessManagerMakeupMakeupMng;
      if (paramString != null)
      {
        this.jdField_a_of_type_Int = paramString.a(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentAvBusinessManagerMakeupMakeupMng.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, false);
      }
      b();
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt1 != 1) {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3) {
          return;
        }
        this.jdField_a_of_type_Int = paramInt2;
        paramString = this.jdField_a_of_type_ComTencentAvBusinessManagerMakeupMakeupMng;
        if (paramString != null) {
          paramString.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, true);
        }
      }
    }
    try
    {
      AVUtil.a("0X800AA63", Integer.parseInt(this.jdField_a_of_type_JavaLangString));
      return;
    }
    catch (Throwable paramString) {}
    this.jdField_a_of_type_Int = paramInt2;
    paramString = this.jdField_a_of_type_ComTencentAvBusinessManagerMakeupMakeupMng;
    if (paramString != null) {
      paramString.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, false);
    }
    return;
  }
  
  public void b()
  {
    Object localObject;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView;
      if (localObject != null) {
        ((BeautySeekView)localObject).setVisibility(8);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
      localObject = this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView;
      if (localObject != null)
      {
        ((BeautySeekView)localObject).setVisibility(0);
        localObject = getContext().getResources().getString(2131695405);
        this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.a((String)localObject, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 0);
      }
    }
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    MakeupMng localMakeupMng = this.jdField_a_of_type_ComTencentAvBusinessManagerMakeupMakeupMng;
    if (localMakeupMng != null) {
      localMakeupMng.b(paramLong, this.jdField_a_of_type_ComTencentAvUiQavListItemHelper);
    }
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvBusinessManagerMakeupMakeupMng;
    if (localObject != null)
    {
      int k = -1;
      if (!((MakeupMng)localObject).b()) {
        localObject = this.jdField_a_of_type_ComTencentAvBusinessManagerMakeupMakeupMng.b;
      } else {
        localObject = null;
      }
      int j = 0;
      int i;
      for (;;)
      {
        i = k;
        if (j >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break;
        }
        QavListItemBase.ItemInfo localItemInfo = (QavListItemBase.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(j);
        if ((localItemInfo != null) && (TextUtils.equals((CharSequence)localObject, localItemInfo.jdField_a_of_type_JavaLangString)))
        {
          i = j;
          break;
        }
        j += 1;
      }
      j = i;
      if (i < 1)
      {
        localObject = null;
        j = 0;
      }
      a((String)localObject);
      localObject = this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter;
      if (localObject != null) {
        BaseToolbar.setSelectedListViewItemAndShow(this.jdField_a_of_type_ComTencentWidgetHorizontalListView, (QAVPtvTemplateAdapter)localObject, j);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.beauty.MakeupView
 * JD-Core Version:    0.7.0.1
 */