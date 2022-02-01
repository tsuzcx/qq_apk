package com.tencent.av.ui.virtual;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.ui.BaseToolbar;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.QavMenuBaseView;
import com.tencent.av.ui.QavPanel;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import lhg;
import lht;
import mgr;
import mgx;
import mhr;
import mhs;
import mqp;
import mqu;

public class QavVirtualMenuView
  extends QavMenuBaseView
  implements View.OnClickListener, mgx
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private lht jdField_a_of_type_Lht;
  private mgr jdField_a_of_type_Mgr;
  private mhs jdField_a_of_type_Mhs;
  
  public QavVirtualMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QavVirtualMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QavVirtualMenuView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = ("QavVirtualMenuView_" + AudioHelper.b());
    setGravity(80);
    paramContext = LayoutInflater.from(paramContext).inflate(2131559704, this);
    paramContext.setOnTouchListener(new mqp(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramContext.findViewById(2131373227));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)paramContext.findViewById(2131368218));
  }
  
  public void a(long paramLong)
  {
    EffectSettingUi.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramLong);
  }
  
  public void a(long paramLong, mhr parammhr)
  {
    PendantItem localPendantItem = null;
    EffectSettingUi.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramLong);
    if (parammhr == null) {}
    do
    {
      do
      {
        return;
      } while (TextUtils.equals("-1", parammhr.jdField_a_of_type_JavaLangString));
      if (!TextUtils.equals("0", parammhr.jdField_a_of_type_JavaLangString)) {
        break;
      }
      if (this.jdField_a_of_type_Lht != null) {
        this.jdField_a_of_type_Lht.a(paramLong, null);
      }
    } while (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(13));
    ((lhg)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(13)).a(paramLong, "onEffectClick_vb");
    return;
    if (this.jdField_a_of_type_Lht != null) {
      localPendantItem = (PendantItem)this.jdField_a_of_type_Lht.a(parammhr.jdField_a_of_type_JavaLangString);
    }
    if ((localPendantItem == null) || (TextUtils.isEmpty(localPendantItem.getId()))) {}
    for (;;)
    {
      mqu.a("0X800AF86", mqu.a(), 0, String.valueOf(parammhr.jdField_a_of_type_JavaLangString), "", "", "");
      return;
      if (this.jdField_a_of_type_Lht != null) {
        this.jdField_a_of_type_Lht.a(paramLong, localPendantItem);
      }
    }
  }
  
  public void a(QavPanel paramQavPanel)
  {
    super.a(paramQavPanel);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      paramQavPanel = getContext();
      this.jdField_a_of_type_Lht = ((lht)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(14));
      this.jdField_a_of_type_Mhs = new mhs(5, this.jdField_a_of_type_Lht);
      ArrayList localArrayList = this.jdField_a_of_type_Mhs.a(getContext());
      this.jdField_a_of_type_Mgr = new mgr(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramQavPanel, localArrayList, this.jdField_a_of_type_ComTencentWidgetHorizontalListView);
      this.jdField_a_of_type_Mhs.a(this.jdField_a_of_type_Mgr);
      this.jdField_a_of_type_Mgr.b(true);
      this.jdField_a_of_type_Mgr.a(this);
      this.jdField_a_of_type_Mgr.a(this.jdField_a_of_type_Mhs);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Mgr);
      if (this.jdField_a_of_type_Lht != null) {
        this.jdField_a_of_type_Lht.a(0L, this.jdField_a_of_type_Mhs);
      }
    }
    if (GraphicRenderMgr.soloadedPTV) {
      ThreadManager.excute(new QavVirtualMenuView.2(this), 16, null, false);
    }
  }
  
  public void b(long paramLong)
  {
    if (this.jdField_a_of_type_Lht != null) {
      this.jdField_a_of_type_Lht.b(paramLong, this.jdField_a_of_type_Mhs);
    }
    super.b(paramLong);
  }
  
  public void c(long paramLong, boolean paramBoolean)
  {
    super.c(paramLong, paramBoolean);
    if (paramBoolean) {
      f();
    }
  }
  
  public void f()
  {
    super.f();
    Object localObject1;
    int i;
    int j;
    int k;
    if (this.jdField_a_of_type_Mgr != null)
    {
      Object localObject2 = "0";
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Lht != null)
      {
        localObject3 = (PendantItem)this.jdField_a_of_type_Lht.a();
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((PendantItem)localObject3).getId();
        }
      }
      localObject2 = this.jdField_a_of_type_Mhs.a(getContext());
      this.jdField_a_of_type_Mgr.a((ArrayList)localObject2);
      i = 0;
      j = -1;
      if ((localObject2 == null) || (i >= ((ArrayList)localObject2).size())) {
        break label251;
      }
      Object localObject3 = (mhr)((ArrayList)localObject2).get(i);
      if (localObject3 == null) {
        k = j;
      }
      do
      {
        i += 1;
        j = k;
        break;
        if (TextUtils.equals("0", ((mhr)localObject3).jdField_a_of_type_JavaLangString)) {
          j = i;
        }
        k = j;
      } while (!TextUtils.equals((CharSequence)localObject1, ((mhr)localObject3).jdField_a_of_type_JavaLangString));
    }
    for (;;)
    {
      k = i;
      if (i == -1)
      {
        if (this.jdField_a_of_type_Lht != null) {
          this.jdField_a_of_type_Lht.a(0L, null);
        }
        k = j;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 4, "refreshUI, curSelItemId[" + (String)localObject1 + "], curSelItemIndex[" + k + "], curDefaultIndex[" + j + "]");
      }
      BaseToolbar.setSelectedListViewItemAndShow(this.jdField_a_of_type_ComTencentWidgetHorizontalListView, this.jdField_a_of_type_Mgr, k);
      return;
      label251:
      i = -1;
    }
  }
  
  public void onClick(View paramView)
  {
    long l = AudioHelper.b();
    if ((paramView == this.jdField_a_of_type_AndroidWidgetButton) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)) {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(l, 0, true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.virtual.QavVirtualMenuView
 * JD-Core Version:    0.7.0.1
 */