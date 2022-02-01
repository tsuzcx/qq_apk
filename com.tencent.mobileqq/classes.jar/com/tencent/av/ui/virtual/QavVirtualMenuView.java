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
import lhe;
import lhr;
import mgm;
import mgs;
import mhm;
import mhn;
import mqj;
import mqo;

public class QavVirtualMenuView
  extends QavMenuBaseView
  implements View.OnClickListener, mgs
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private lhr jdField_a_of_type_Lhr;
  private mgm jdField_a_of_type_Mgm;
  private mhn jdField_a_of_type_Mhn;
  
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
    paramContext = LayoutInflater.from(paramContext).inflate(2131559696, this);
    paramContext.setOnTouchListener(new mqj(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramContext.findViewById(2131373182));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)paramContext.findViewById(2131368121));
  }
  
  public void a(long paramLong)
  {
    EffectSettingUi.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramLong);
  }
  
  public void a(long paramLong, mhm parammhm)
  {
    PendantItem localPendantItem = null;
    EffectSettingUi.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramLong);
    if (parammhm == null) {}
    do
    {
      do
      {
        return;
      } while (TextUtils.equals("-1", parammhm.jdField_a_of_type_JavaLangString));
      if (!TextUtils.equals("0", parammhm.jdField_a_of_type_JavaLangString)) {
        break;
      }
      if (this.jdField_a_of_type_Lhr != null) {
        this.jdField_a_of_type_Lhr.a(paramLong, null);
      }
    } while (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(13));
    ((lhe)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(13)).a(paramLong, "onEffectClick_vb");
    return;
    if (this.jdField_a_of_type_Lhr != null) {
      localPendantItem = (PendantItem)this.jdField_a_of_type_Lhr.a(parammhm.jdField_a_of_type_JavaLangString);
    }
    if ((localPendantItem == null) || (TextUtils.isEmpty(localPendantItem.getId()))) {}
    for (;;)
    {
      mqo.a("0X800AF86", mqo.a(), 0, String.valueOf(parammhm.jdField_a_of_type_JavaLangString), "", "", "");
      return;
      if (this.jdField_a_of_type_Lhr != null) {
        this.jdField_a_of_type_Lhr.a(paramLong, localPendantItem);
      }
    }
  }
  
  public void a(QavPanel paramQavPanel)
  {
    super.a(paramQavPanel);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      paramQavPanel = getContext();
      this.jdField_a_of_type_Lhr = ((lhr)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(14));
      this.jdField_a_of_type_Mhn = new mhn(5, this.jdField_a_of_type_Lhr);
      ArrayList localArrayList = this.jdField_a_of_type_Mhn.a(getContext());
      this.jdField_a_of_type_Mgm = new mgm(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramQavPanel, localArrayList, this.jdField_a_of_type_ComTencentWidgetHorizontalListView);
      this.jdField_a_of_type_Mhn.a(this.jdField_a_of_type_Mgm);
      this.jdField_a_of_type_Mgm.b(true);
      this.jdField_a_of_type_Mgm.a(this);
      this.jdField_a_of_type_Mgm.a(this.jdField_a_of_type_Mhn);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Mgm);
      if (this.jdField_a_of_type_Lhr != null) {
        this.jdField_a_of_type_Lhr.a(0L, this.jdField_a_of_type_Mhn);
      }
    }
    if (GraphicRenderMgr.soloadedPTV) {
      ThreadManager.excute(new QavVirtualMenuView.2(this), 16, null, false);
    }
  }
  
  public void b(long paramLong)
  {
    if (this.jdField_a_of_type_Lhr != null) {
      this.jdField_a_of_type_Lhr.b(paramLong, this.jdField_a_of_type_Mhn);
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
    if (this.jdField_a_of_type_Mgm != null)
    {
      Object localObject2 = "0";
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Lhr != null)
      {
        localObject3 = (PendantItem)this.jdField_a_of_type_Lhr.a();
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((PendantItem)localObject3).getId();
        }
      }
      localObject2 = this.jdField_a_of_type_Mhn.a(getContext());
      this.jdField_a_of_type_Mgm.a((ArrayList)localObject2);
      i = 0;
      j = -1;
      if ((localObject2 == null) || (i >= ((ArrayList)localObject2).size())) {
        break label251;
      }
      Object localObject3 = (mhm)((ArrayList)localObject2).get(i);
      if (localObject3 == null) {
        k = j;
      }
      do
      {
        i += 1;
        j = k;
        break;
        if (TextUtils.equals("0", ((mhm)localObject3).jdField_a_of_type_JavaLangString)) {
          j = i;
        }
        k = j;
      } while (!TextUtils.equals((CharSequence)localObject1, ((mhm)localObject3).jdField_a_of_type_JavaLangString));
    }
    for (;;)
    {
      k = i;
      if (i == -1)
      {
        if (this.jdField_a_of_type_Lhr != null) {
          this.jdField_a_of_type_Lhr.a(0L, null);
        }
        k = j;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 4, "refreshUI, curSelItemId[" + (String)localObject1 + "], curSelItemIndex[" + k + "], curDefaultIndex[" + j + "]");
      }
      BaseToolbar.setSelectedListViewItemAndShow(this.jdField_a_of_type_ComTencentWidgetHorizontalListView, this.jdField_a_of_type_Mgm, k);
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