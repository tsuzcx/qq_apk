package com.tencent.av.ui.virtual;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.makeup.MakeupMng;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.business.manager.pendant.VirtualBgMng;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.ui.BaseToolbar;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.QAVPtvTemplateAdapter;
import com.tencent.av.ui.QAVPtvTemplateAdapter.IEffectCallback;
import com.tencent.av.ui.QavListItemBase.ItemInfo;
import com.tencent.av.ui.QavListItemHelper;
import com.tencent.av.ui.QavMenuBaseView;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.utils.AVUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;

public class QavVirtualMenuView
  extends QavMenuBaseView
  implements View.OnClickListener, QAVPtvTemplateAdapter.IEffectCallback
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private VirtualBgMng jdField_a_of_type_ComTencentAvBusinessManagerPendantVirtualBgMng = null;
  private QAVPtvTemplateAdapter jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter;
  private QavListItemHelper jdField_a_of_type_ComTencentAvUiQavListItemHelper = null;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  
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
    paramContext = LayoutInflater.from(paramContext).inflate(2131559816, this);
    paramContext.setOnTouchListener(new QavVirtualMenuView.1(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramContext.findViewById(2131373754));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)paramContext.findViewById(2131368580));
  }
  
  public void a(long paramLong)
  {
    EffectSettingUi.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramLong);
  }
  
  public void a(long paramLong, QavListItemBase.ItemInfo paramItemInfo)
  {
    PendantItem localPendantItem = null;
    EffectSettingUi.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramLong);
    if (paramItemInfo == null) {}
    do
    {
      do
      {
        return;
      } while (TextUtils.equals("-1", paramItemInfo.jdField_a_of_type_JavaLangString));
      if (!TextUtils.equals("0", paramItemInfo.jdField_a_of_type_JavaLangString)) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentAvBusinessManagerPendantVirtualBgMng != null) {
        this.jdField_a_of_type_ComTencentAvBusinessManagerPendantVirtualBgMng.a(paramLong, null);
      }
    } while (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(13));
    ((MakeupMng)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(13)).a(paramLong, "onEffectClick_vb");
    return;
    if (this.jdField_a_of_type_ComTencentAvBusinessManagerPendantVirtualBgMng != null) {
      localPendantItem = (PendantItem)this.jdField_a_of_type_ComTencentAvBusinessManagerPendantVirtualBgMng.a(paramItemInfo.jdField_a_of_type_JavaLangString);
    }
    if ((localPendantItem == null) || (TextUtils.isEmpty(localPendantItem.getId()))) {}
    for (;;)
    {
      AVUtil.a("0X800AF86", AVUtil.a(), 0, String.valueOf(paramItemInfo.jdField_a_of_type_JavaLangString), "", "", "");
      return;
      if (this.jdField_a_of_type_ComTencentAvBusinessManagerPendantVirtualBgMng != null) {
        this.jdField_a_of_type_ComTencentAvBusinessManagerPendantVirtualBgMng.a(paramLong, localPendantItem);
      }
    }
  }
  
  public void a(QavPanel paramQavPanel)
  {
    super.a(paramQavPanel);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      paramQavPanel = getContext();
      this.jdField_a_of_type_ComTencentAvBusinessManagerPendantVirtualBgMng = ((VirtualBgMng)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(14));
      this.jdField_a_of_type_ComTencentAvUiQavListItemHelper = new QavListItemHelper(5, this.jdField_a_of_type_ComTencentAvBusinessManagerPendantVirtualBgMng);
      ArrayList localArrayList = this.jdField_a_of_type_ComTencentAvUiQavListItemHelper.a(getContext());
      this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter = new QAVPtvTemplateAdapter(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramQavPanel, localArrayList, this.jdField_a_of_type_ComTencentWidgetHorizontalListView);
      this.jdField_a_of_type_ComTencentAvUiQavListItemHelper.a(this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter);
      this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter.b(true);
      this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter.a(this);
      this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter.a(this.jdField_a_of_type_ComTencentAvUiQavListItemHelper);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter);
      if (this.jdField_a_of_type_ComTencentAvBusinessManagerPendantVirtualBgMng != null) {
        this.jdField_a_of_type_ComTencentAvBusinessManagerPendantVirtualBgMng.a(0L, this.jdField_a_of_type_ComTencentAvUiQavListItemHelper);
      }
    }
    if (GraphicRenderMgr.soloadedPTV) {
      ThreadManager.excute(new QavVirtualMenuView.2(this), 16, null, false);
    }
  }
  
  public void b(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvBusinessManagerPendantVirtualBgMng != null) {
      this.jdField_a_of_type_ComTencentAvBusinessManagerPendantVirtualBgMng.b(paramLong, this.jdField_a_of_type_ComTencentAvUiQavListItemHelper);
    }
    super.b(paramLong);
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    super.b(paramLong, paramBoolean);
    if (paramBoolean) {
      g();
    }
  }
  
  public void g()
  {
    super.g();
    Object localObject1;
    int i;
    int j;
    int k;
    if (this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter != null)
    {
      Object localObject2 = "0";
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentAvBusinessManagerPendantVirtualBgMng != null)
      {
        localObject3 = (PendantItem)this.jdField_a_of_type_ComTencentAvBusinessManagerPendantVirtualBgMng.a();
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((PendantItem)localObject3).getId();
        }
      }
      localObject2 = this.jdField_a_of_type_ComTencentAvUiQavListItemHelper.a(getContext());
      this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter.a((ArrayList)localObject2);
      i = 0;
      j = -1;
      if ((localObject2 == null) || (i >= ((ArrayList)localObject2).size())) {
        break label251;
      }
      Object localObject3 = (QavListItemBase.ItemInfo)((ArrayList)localObject2).get(i);
      if (localObject3 == null) {
        k = j;
      }
      do
      {
        i += 1;
        j = k;
        break;
        if (TextUtils.equals("0", ((QavListItemBase.ItemInfo)localObject3).jdField_a_of_type_JavaLangString)) {
          j = i;
        }
        k = j;
      } while (!TextUtils.equals((CharSequence)localObject1, ((QavListItemBase.ItemInfo)localObject3).jdField_a_of_type_JavaLangString));
    }
    for (;;)
    {
      k = i;
      if (i == -1)
      {
        if (this.jdField_a_of_type_ComTencentAvBusinessManagerPendantVirtualBgMng != null) {
          this.jdField_a_of_type_ComTencentAvBusinessManagerPendantVirtualBgMng.a(0L, null);
        }
        k = j;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 4, "refreshUI, curSelItemId[" + (String)localObject1 + "], curSelItemIndex[" + k + "], curDefaultIndex[" + j + "]");
      }
      BaseToolbar.setSelectedListViewItemAndShow(this.jdField_a_of_type_ComTencentWidgetHorizontalListView, this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter, k);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.virtual.QavVirtualMenuView
 * JD-Core Version:    0.7.0.1
 */