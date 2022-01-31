package com.tencent.biz.subscribe.widget.textview;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import bbkk;
import bcql;
import bfpc;
import bhpo;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.biz.subscribe.fragments.SubscribeHybirdFragment;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import sgg;
import wkk;
import wpt;
import wpv;
import wux;
import wwp;
import wwq;
import wwr;
import wws;
import wwt;
import xhb;

public class FollowTextView
  extends TextView
  implements View.OnClickListener, wpv
{
  private CertifiedAccountMeta.StFeed jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private wkk jdField_a_of_type_Wkk;
  private wwt jdField_a_of_type_Wwt;
  protected boolean a;
  private volatile boolean b = true;
  private boolean c;
  private boolean d;
  
  public FollowTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FollowTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FollowTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a(boolean paramBoolean, CertifiedAccountMeta.StFeed paramStFeed)
  {
    String str1;
    String str2;
    String str3;
    if (paramStFeed != null)
    {
      if (bbkk.a(paramStFeed.id.get())) {
        break label100;
      }
      str1 = paramStFeed.id.get();
      str2 = paramStFeed.poster.id.get();
      str3 = "auth_" + wux.a(a());
      if (!paramBoolean) {
        break label114;
      }
    }
    label100:
    label114:
    for (paramStFeed = "follow";; paramStFeed = "un_follow")
    {
      xhb.a(str2, str3, paramStFeed, 0, 0, new String[] { "", "", str1 });
      return;
      str1 = paramStFeed.poster.nick.get();
      break;
    }
  }
  
  private void d()
  {
    bfpc localbfpc = bfpc.a(getContext());
    localbfpc.a(String.format(getContext().getResources().getString(2131695619), new Object[] { this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get() }));
    localbfpc.a(2131696742, 3);
    localbfpc.c(2131690596);
    localbfpc.setOnDismissListener(new wwr(this));
    localbfpc.a(new wws(this, localbfpc));
    if (!localbfpc.isShowing())
    {
      this.b = true;
      localbfpc.show();
    }
  }
  
  public ExtraTypeInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  }
  
  public ArrayList<Class> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FollowUpdateEvent.class);
    return localArrayList;
  }
  
  protected void a()
  {
    setGravity(17);
    setTextColor(-1);
    setOnClickListener(this);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) {
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.followState.set(paramInt);
    }
    if (paramInt == 1)
    {
      b();
      return;
    }
    c();
  }
  
  public void a(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) && ((paramSimpleBaseEvent instanceof FollowUpdateEvent)))
    {
      FollowUpdateEvent localFollowUpdateEvent = (FollowUpdateEvent)paramSimpleBaseEvent;
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get().equals(localFollowUpdateEvent.useId))
      {
        a(localFollowUpdateEvent.followStatus);
        bhpo.a(getContext(), (FollowUpdateEvent)paramSimpleBaseEvent);
        SubscribeHybirdFragment.a(getContext(), (FollowUpdateEvent)paramSimpleBaseEvent);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FollowTextView", 2, "follow");
    }
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null) {
      QLog.e("FollowTextView", 2, "follow user failed! user is null");
    }
    do
    {
      return;
      this.b = false;
      localObject = BaseApplicationImpl.getApplication().getRuntime();
    } while (!(localObject instanceof QQAppInterface));
    Object localObject = (QQAppInterface)localObject;
    if (paramBoolean)
    {
      sgg.a((AppInterface)localObject, getContext(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), new wwp(this), false, 0, true);
      return;
    }
    sgg.a((QQAppInterface)localObject, getContext(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), false, new wwq(this), true);
  }
  
  protected boolean a()
  {
    return (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null) || (bbkk.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get()));
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      i = 2130838649;
      setBackgroundResource(i);
      if (!this.jdField_a_of_type_Boolean) {
        break label47;
      }
    }
    label47:
    for (int i = -9211021;; i = Color.parseColor("#bdbfc9"))
    {
      setTextColor(i);
      setText(2131690655);
      return;
      i = 2130838647;
      break;
    }
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      i = 2130838736;
      setBackgroundResource(i);
      if (!this.jdField_a_of_type_Boolean) {
        break label47;
      }
    }
    label47:
    for (int i = -1493172225;; i = -1)
    {
      setTextColor(i);
      setText(2131690661);
      return;
      i = 2130838734;
      break;
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (!isInEditMode()) {
      wpt.a().a(this);
    }
  }
  
  public void onClick(View paramView)
  {
    if (a()) {}
    do
    {
      return;
      if (!this.b)
      {
        bcql.a(getContext(), "请勿重复操作", 0).a();
        return;
      }
      if (this.jdField_a_of_type_Wkk != null) {
        this.jdField_a_of_type_Wkk.a();
      }
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.followState.get() == 0)
      {
        a(true);
        return;
      }
    } while (this.d);
    d();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    wpt.a().b(this);
  }
  
  public void setExtraTypeInfo(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = paramExtraTypeInfo;
  }
  
  public void setFeedData(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null)
    {
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = paramStFeed;
      a(paramStFeed.poster.followState.get());
    }
  }
  
  public void setFollowStateChangeListener(wwt paramwwt)
  {
    this.jdField_a_of_type_Wwt = paramwwt;
  }
  
  public void setIsInNightMode(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setItemPreClickListener(wkk paramwkk)
  {
    this.jdField_a_of_type_Wkk = paramwkk;
  }
  
  public void setNoneReportType(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setOnlyFollowMode(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setUserData(CertifiedAccountMeta.StUser paramStUser)
  {
    setUserData(paramStUser, -1);
  }
  
  public void setUserData(CertifiedAccountMeta.StUser paramStUser, int paramInt)
  {
    CertifiedAccountMeta.StFeed localStFeed = new CertifiedAccountMeta.StFeed();
    localStFeed.poster.set(paramStUser);
    localStFeed.type.set(paramInt);
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = localStFeed;
    if (paramInt == -1) {}
    for (boolean bool = true;; bool = false)
    {
      this.c = bool;
      a(localStFeed.poster.followState.get());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.textview.FollowTextView
 * JD-Core Version:    0.7.0.1
 */