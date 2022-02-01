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
import com.tencent.av.ui.QAVPtvTemplateAdapter;
import com.tencent.av.ui.QavListItemBase.ItemInfo;
import com.tencent.av.ui.QavListItemHelper;
import com.tencent.av.ui.QavMenuBaseView;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.effect.interfaces.IEffectCallback;
import com.tencent.av.ui.effect.toolbar.BaseToolbar;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;

public class QavVirtualMenuView
  extends QavMenuBaseView
  implements View.OnClickListener, IEffectCallback
{
  private Button a;
  private HorizontalListView b;
  private QAVPtvTemplateAdapter c;
  private VirtualBgMng d = null;
  private QavListItemHelper e = null;
  
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
    localStringBuilder.append(AudioHelper.c());
    this.g = localStringBuilder.toString();
    setGravity(80);
    paramContext = LayoutInflater.from(paramContext).inflate(2131625734, this);
    paramContext.setOnTouchListener(new QavVirtualMenuView.1(this));
    this.a = ((Button)paramContext.findViewById(2131440997));
    this.a.setOnClickListener(this);
    this.b = ((HorizontalListView)paramContext.findViewById(2131435195));
  }
  
  public void a(long paramLong)
  {
    BaseToolbar.keepInToolbar(this.h, paramLong);
  }
  
  public void a(long paramLong, QavListItemBase.ItemInfo paramItemInfo)
  {
    BaseToolbar.keepInToolbar(this.h, paramLong);
    if (paramItemInfo == null) {
      return;
    }
    if (TextUtils.equals("-1", paramItemInfo.a)) {
      return;
    }
    boolean bool = TextUtils.equals("0", paramItemInfo.a);
    PendantItem localPendantItem = null;
    if (bool)
    {
      paramItemInfo = this.d;
      if (paramItemInfo != null) {
        paramItemInfo.a(paramLong, null);
      }
      if (this.h.d(13)) {
        ((MakeupMng)this.h.c(13)).b(paramLong, "onEffectClick_vb");
      }
    }
    else
    {
      VirtualBgMng localVirtualBgMng = this.d;
      if (localVirtualBgMng != null) {
        localPendantItem = (PendantItem)localVirtualBgMng.b(paramItemInfo.a);
      }
      if ((localPendantItem != null) && (!TextUtils.isEmpty(localPendantItem.getId())))
      {
        localVirtualBgMng = this.d;
        if (localVirtualBgMng != null) {
          localVirtualBgMng.a(paramLong, localPendantItem);
        }
      }
      AVUtil.a("0X800AF86", AVUtil.c(), 0, String.valueOf(paramItemInfo.a), "", "", "");
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    super.a(paramLong, paramBoolean);
    if (paramBoolean) {
      b();
    }
  }
  
  public void a(QavListItemBase.ItemInfo paramItemInfo) {}
  
  public void a(QavPanel paramQavPanel)
  {
    super.a(paramQavPanel);
    if (this.h != null)
    {
      paramQavPanel = getContext();
      this.d = ((VirtualBgMng)this.h.c(14));
      this.e = new QavListItemHelper(5, this.d);
      ArrayList localArrayList = this.e.a(getContext());
      this.c = new QAVPtvTemplateAdapter(this.h, paramQavPanel, localArrayList, this.b);
      this.e.a(this.c);
      this.c.b(true);
      this.c.a(this);
      this.c.a(this.e);
      this.b.setAdapter(this.c);
      paramQavPanel = this.d;
      if (paramQavPanel != null) {
        paramQavPanel.a(0L, this.e);
      }
    }
    if (GraphicRenderMgr.soloadedPTV) {
      ThreadManager.excute(new QavVirtualMenuView.2(this), 16, null, false);
    }
  }
  
  public void b()
  {
    super.b();
    if (this.c != null)
    {
      Object localObject1 = this.d;
      if (localObject1 != null)
      {
        localObject1 = (PendantItem)((VirtualBgMng)localObject1).c();
        if (localObject1 != null)
        {
          localObject1 = ((PendantItem)localObject1).getId();
          break label51;
        }
      }
      localObject1 = "0";
      label51:
      Object localObject2 = this.e.a(getContext());
      this.c.a((ArrayList)localObject2);
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
          if (TextUtils.equals("0", ((QavListItemBase.ItemInfo)localObject3).a)) {
            j = i;
          }
          k = j;
          if (TextUtils.equals((CharSequence)localObject1, ((QavListItemBase.ItemInfo)localObject3).a)) {
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
        localObject2 = this.d;
        if (localObject2 != null) {
          ((VirtualBgMng)localObject2).a(0L, null);
        }
        k = j;
      }
      if (QLog.isDevelopLevel())
      {
        localObject2 = this.g;
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
      BaseToolbar.setSelectedListViewItemAndShow(this.b, this.c, k);
    }
  }
  
  public void b(long paramLong)
  {
    VirtualBgMng localVirtualBgMng = this.d;
    if (localVirtualBgMng != null) {
      localVirtualBgMng.b(paramLong, this.e);
    }
    super.b(paramLong);
  }
  
  public void onClick(View paramView)
  {
    long l = AudioHelper.c();
    if ((paramView == this.a) && (this.i != null)) {
      this.i.a(l, 0, true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.virtual.QavVirtualMenuView
 * JD-Core Version:    0.7.0.1
 */