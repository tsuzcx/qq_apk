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
import com.tencent.av.ui.QAVPtvTemplateAdapter;
import com.tencent.av.ui.QavListItemBase.ItemInfo;
import com.tencent.av.ui.QavListItemHelper;
import com.tencent.av.ui.effect.interfaces.IEffectCallback;
import com.tencent.av.ui.effect.toolbar.BaseToolbar;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;

public class MakeupView
  extends BeautyBaseView
  implements IEffectCallback
{
  final ArrayList<QavListItemBase.ItemInfo> c = new ArrayList(10);
  final TextView d;
  final BeautySeekView e;
  final HorizontalListView f;
  QAVPtvTemplateAdapter g = null;
  MakeupMng h = null;
  String i = null;
  int j = 50;
  QavListItemHelper k = null;
  
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
    inflate(paramContext, 2131625776, this);
    this.d = ((TextView)findViewById(2131447416));
    this.e = ((BeautySeekView)findViewById(2131429389));
    this.e.setBeautySeekActionListener(this);
    this.f = ((HorizontalListView)findViewById(2131435195));
    this.f.setStayDisplayOffsetZero(true);
    b();
  }
  
  public void a()
  {
    if ((this.g != null) && (this.h != null))
    {
      d();
      this.g.a(this.c);
      this.g.notifyDataSetChanged();
      c();
    }
  }
  
  public void a(long paramLong)
  {
    BaseToolbar.keepInToolbar(this.a, paramLong);
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
    BaseToolbar.keepInToolbar(this.a, paramLong);
    if (paramItemInfo == null) {
      return;
    }
    Object localObject = this.h;
    if (localObject != null) {
      ((MakeupMng)localObject).b(paramLong, "onEffectClick");
    }
    boolean bool = TextUtils.equals("0", paramItemInfo.a);
    localObject = null;
    if (bool)
    {
      paramItemInfo = this.h;
      if (paramItemInfo != null) {
        paramItemInfo.a(paramLong, null);
      }
      a(null);
      AVUtil.a("0X800AA64", 0, 0, "", "", "", "");
      return;
    }
    MakeupMng localMakeupMng = this.h;
    if (localMakeupMng != null) {
      localObject = (PendantItem)localMakeupMng.b(paramItemInfo.a);
    }
    if (localObject != null)
    {
      if (TextUtils.isEmpty(((PendantItem)localObject).getId())) {
        return;
      }
      localMakeupMng = this.h;
      if (localMakeupMng != null) {
        localMakeupMng.a(paramLong, (PendantItem)localObject);
      }
      a(paramItemInfo.a);
    }
    try
    {
      AVUtil.a("0X800AA62", Integer.parseInt(paramItemInfo.a));
      return;
    }
    catch (Throwable paramItemInfo) {}
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    MakeupMng localMakeupMng = this.h;
    if (localMakeupMng != null) {
      localMakeupMng.a(paramLong, this.k);
    }
    a();
  }
  
  public void a(QavListItemBase.ItemInfo paramItemInfo) {}
  
  public void a(String paramString)
  {
    if (!TextUtils.equals(paramString, this.i))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("changeCurSelItem, cur[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("], pre[");
        localStringBuilder.append(this.i);
        localStringBuilder.append("]");
        QLog.i("MakeupView", 2, localStringBuilder.toString());
      }
      this.i = paramString;
      paramString = this.h;
      if (paramString != null)
      {
        this.j = paramString.d(this.i);
        this.h.a(this.i, this.j, false);
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
        this.j = paramInt2;
        paramString = this.h;
        if (paramString != null) {
          paramString.a(this.i, this.j, true);
        }
      }
    }
    try
    {
      AVUtil.a("0X800AA63", Integer.parseInt(this.i));
      return;
    }
    catch (Throwable paramString) {}
    this.j = paramInt2;
    paramString = this.h;
    if (paramString != null) {
      paramString.a(this.i, this.j, false);
    }
    return;
  }
  
  public void b()
  {
    Object localObject;
    if (TextUtils.isEmpty(this.i))
    {
      localObject = this.d;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = this.e;
      if (localObject != null) {
        ((BeautySeekView)localObject).setVisibility(8);
      }
    }
    else
    {
      localObject = this.d;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
      localObject = this.e;
      if (localObject != null)
      {
        ((BeautySeekView)localObject).setVisibility(0);
        localObject = getContext().getResources().getString(2131893151);
        this.e.a((String)localObject, this.i, this.j, 0);
      }
    }
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    MakeupMng localMakeupMng = this.h;
    if (localMakeupMng != null) {
      localMakeupMng.b(paramLong, this.k);
    }
  }
  
  public void c()
  {
    Object localObject = this.h;
    if (localObject != null)
    {
      int i1 = -1;
      if (!((MakeupMng)localObject).j()) {
        localObject = this.h.m;
      } else {
        localObject = null;
      }
      int n = 0;
      int m;
      for (;;)
      {
        m = i1;
        if (n >= this.c.size()) {
          break;
        }
        QavListItemBase.ItemInfo localItemInfo = (QavListItemBase.ItemInfo)this.c.get(n);
        if ((localItemInfo != null) && (TextUtils.equals((CharSequence)localObject, localItemInfo.a)))
        {
          m = n;
          break;
        }
        n += 1;
      }
      n = m;
      if (m < 1)
      {
        localObject = null;
        n = 0;
      }
      a((String)localObject);
      localObject = this.g;
      if (localObject != null) {
        BaseToolbar.setSelectedListViewItemAndShow(this.f, (QAVPtvTemplateAdapter)localObject, n);
      }
    }
  }
  
  void d()
  {
    ArrayList localArrayList = this.k.a(getContext());
    this.c.clear();
    this.c.addAll(localArrayList);
  }
  
  public void onClick(View paramView) {}
  
  public void setAppInterface(VideoAppInterface paramVideoAppInterface)
  {
    super.setAppInterface(paramVideoAppInterface);
    long l = AudioHelper.c();
    if (this.a != null)
    {
      this.h = ((MakeupMng)paramVideoAppInterface.c(13));
      this.h.a(l, this.k);
    }
    this.k = new QavListItemHelper(4, this.h);
    d();
    this.g = new QAVPtvTemplateAdapter(this.a, getContext(), this.c, this.f, 5.6F);
    this.k.a(this.g);
    this.g.a(this);
    this.g.a(this.k);
    this.g.a(true);
    this.g.b(true);
    this.f.setAdapter(this.g);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.beauty.MakeupView
 * JD-Core Version:    0.7.0.1
 */