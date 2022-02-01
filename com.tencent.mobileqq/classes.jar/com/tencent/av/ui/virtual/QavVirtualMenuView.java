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
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.app.ThreadManager;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QavVirtualMenuView_");
    localStringBuilder.append(AudioHelper.b());
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    setGravity(80);
    paramContext = LayoutInflater.from(paramContext).inflate(2131559693, this);
    paramContext.setOnTouchListener(new QavVirtualMenuView.1(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramContext.findViewById(2131373326));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)paramContext.findViewById(2131368321));
  }
  
  public void a(long paramLong)
  {
    EffectSettingUi.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramLong);
  }
  
  public void a(long paramLong, QavListItemBase.ItemInfo paramItemInfo)
  {
    EffectSettingUi.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramLong);
    if (paramItemInfo == null) {
      return;
    }
    if (TextUtils.equals("-1", paramItemInfo.jdField_a_of_type_JavaLangString)) {
      return;
    }
    boolean bool = TextUtils.equals("0", paramItemInfo.jdField_a_of_type_JavaLangString);
    PendantItem localPendantItem = null;
    if (bool)
    {
      paramItemInfo = this.jdField_a_of_type_ComTencentAvBusinessManagerPendantVirtualBgMng;
      if (paramItemInfo != null) {
        paramItemInfo.a(paramLong, null);
      }
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(13)) {
        ((MakeupMng)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(13)).a(paramLong, "onEffectClick_vb");
      }
    }
    else
    {
      VirtualBgMng localVirtualBgMng = this.jdField_a_of_type_ComTencentAvBusinessManagerPendantVirtualBgMng;
      if (localVirtualBgMng != null) {
        localPendantItem = (PendantItem)localVirtualBgMng.a(paramItemInfo.jdField_a_of_type_JavaLangString);
      }
      if ((localPendantItem != null) && (!TextUtils.isEmpty(localPendantItem.getId())))
      {
        localVirtualBgMng = this.jdField_a_of_type_ComTencentAvBusinessManagerPendantVirtualBgMng;
        if (localVirtualBgMng != null) {
          localVirtualBgMng.a(paramLong, localPendantItem);
        }
      }
      AVUtil.a("0X800AF86", AVUtil.a(), 0, String.valueOf(paramItemInfo.jdField_a_of_type_JavaLangString), "", "", "");
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    super.a(paramLong, paramBoolean);
    if (paramBoolean) {
      d();
    }
  }
  
  public void a(QavListItemBase.ItemInfo paramItemInfo) {}
  
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
      paramQavPanel = this.jdField_a_of_type_ComTencentAvBusinessManagerPendantVirtualBgMng;
      if (paramQavPanel != null) {
        paramQavPanel.a(0L, this.jdField_a_of_type_ComTencentAvUiQavListItemHelper);
      }
    }
    if (GraphicRenderMgr.soloadedPTV) {
      ThreadManager.excute(new QavVirtualMenuView.2(this), 16, null, false);
    }
  }
  
  public void b(long paramLong)
  {
    VirtualBgMng localVirtualBgMng = this.jdField_a_of_type_ComTencentAvBusinessManagerPendantVirtualBgMng;
    if (localVirtualBgMng != null) {
      localVirtualBgMng.b(paramLong, this.jdField_a_of_type_ComTencentAvUiQavListItemHelper);
    }
    super.b(paramLong);
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter != null)
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentAvBusinessManagerPendantVirtualBgMng;
      if (localObject1 != null)
      {
        localObject1 = (PendantItem)((VirtualBgMng)localObject1).a();
        if (localObject1 != null)
        {
          localObject1 = ((PendantItem)localObject1).getId();
          break label51;
        }
      }
      localObject1 = "0";
      label51:
      Object localObject2 = this.jdField_a_of_type_ComTencentAvUiQavListItemHelper.a(getContext());
      this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter.a((ArrayList)localObject2);
      int i = 0;
      Object localObject3;
      for (int j = -1; (localObject2 != null) && (i < ((ArrayList)localObject2).size()); j = k)
      {
        localObject3 = (QavListItemBase.ItemInfo)((ArrayList)localObject2).get(i);
        if (localObject3 == null)
        {
          k = j;
        }
        else
        {
          if (TextUtils.equals("0", ((QavListItemBase.ItemInfo)localObject3).jdField_a_of_type_JavaLangString)) {
            j = i;
          }
          k = j;
          if (TextUtils.equals((CharSequence)localObject1, ((QavListItemBase.ItemInfo)localObject3).jdField_a_of_type_JavaLangString)) {
            break label156;
          }
        }
        i += 1;
      }
      i = -1;
      label156:
      int k = i;
      if (i == -1)
      {
        localObject2 = this.jdField_a_of_type_ComTencentAvBusinessManagerPendantVirtualBgMng;
        if (localObject2 != null) {
          ((VirtualBgMng)localObject2).a(0L, null);
        }
        k = j;
      }
      if (QLog.isDevelopLevel())
      {
        localObject2 = this.jdField_a_of_type_JavaLangString;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("refreshUI, curSelItemId[");
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append("], curSelItemIndex[");
        ((StringBuilder)localObject3).append(k);
        ((StringBuilder)localObject3).append("], curDefaultIndex[");
        ((StringBuilder)localObject3).append(j);
        ((StringBuilder)localObject3).append("]");
        QLog.i((String)localObject2, 4, ((StringBuilder)localObject3).toString());
      }
      BaseToolbar.setSelectedListViewItemAndShow(this.jdField_a_of_type_ComTencentWidgetHorizontalListView, this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter, k);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.virtual.QavVirtualMenuView
 * JD-Core Version:    0.7.0.1
 */