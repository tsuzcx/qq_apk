package com.tencent.mobileqq.activity.aio.intimate.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.intimate.BaseIntimateView;
import com.tencent.mobileqq.activity.contact.troop.CommonTroopData;
import com.tencent.mobileqq.activity.contact.troop.TroopList;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipBean;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipConfProcessor;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.data.IntimateInfo.CommonTroopInfo;
import com.tencent.mobileqq.friends.intimate.CommonTroopListActivity;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;
import java.util.List;

public class IntimateContentItemCommonTroopView
  extends IntimateContentItemBaseView
{
  protected List<CommonTroopData> i = new ArrayList();
  protected TroopList j = new TroopList();
  protected int k = 0;
  private View l;
  private TextView m;
  private TextView n;
  private TextView o;
  private TextView p;
  private View q;
  private ImageView r;
  private TextView s;
  private TextView t;
  private boolean u = false;
  private int v = 1;
  
  public IntimateContentItemCommonTroopView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public IntimateContentItemCommonTroopView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IntimateContentItemCommonTroopView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void n()
  {
    List localList = this.i;
    if (localList != null)
    {
      if (localList.isEmpty()) {
        return;
      }
      TroopWithCommonFriendsFragment.a(this.h.k());
      TroopWithCommonFriendsFragment.a(this.h.l(), 2);
    }
  }
  
  protected void a(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131444397: 
      if ((this.d != null) && (this.d.recentChatTroopInfo != null))
      {
        paramView = this.d.recentChatTroopInfo;
        Intent localIntent = AIOUtils.a(new Intent(this.h.l(), SplashActivity.class), null);
        localIntent.putExtra("uin", paramView.troopCode);
        localIntent.putExtra("uintype", 1);
        localIntent.putExtra("uinname", paramView.troopName);
        this.h.l().startActivity(localIntent);
        ReportController.b(null, "dc00898", "", "", "0X8009F4F", "0X8009F4F", this.v, 0, "", "", "", "");
        return;
      }
      break;
    case 2131431165: 
      if ((this.d != null) && (this.d.commonTroopInfoList != null))
      {
        CommonTroopListActivity.a(this.h.l(), (ArrayList)this.d.commonTroopInfoList, this.v);
        ReportController.b(null, "dc00898", "", "", "0X8009F4E", "0X8009F4E", this.v, 0, "", "", "", "");
        return;
      }
      n();
      return;
    case 2131431162: 
    case 2131431167: 
      n();
    }
  }
  
  protected void a(IntimateInfo paramIntimateInfo, int paramInt)
  {
    Object localObject = paramIntimateInfo.commonTroopInfoList;
    int i1 = 1;
    if ((localObject != null) && (paramIntimateInfo.commonTroopInfoList.size() > 0)) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    localObject = this.i;
    if ((localObject == null) || (((List)localObject).size() <= 0)) {
      i1 = 0;
    }
    localObject = this.h.l().getResources().getString(2131890964);
    int i2;
    if (i1 != 0) {
      i2 = TroopWithCommonFriendsHelper.a(this.h.n(), this.h.k());
    } else {
      i2 = 0;
    }
    if (i2 == 2) {
      localObject = this.h.l().getResources().getString(2131890963);
    }
    if (paramInt != 0)
    {
      this.o.setVisibility(8);
      if ((paramIntimateInfo.commonTroopInfoList != null) && (paramIntimateInfo.commonTroopInfoList.size() > 0))
      {
        paramInt = paramIntimateInfo.commonTroopInfoList.size();
        this.m.setText(String.valueOf(paramInt));
        IntimateInfo.CommonTroopInfo localCommonTroopInfo = paramIntimateInfo.recentChatTroopInfo;
        this.r.setVisibility(8);
        this.s.setVisibility(8);
        this.t.setVisibility(8);
        if ((localCommonTroopInfo != null) && (!TextUtils.isEmpty(localCommonTroopInfo.troopUin)))
        {
          this.r.setVisibility(0);
          this.s.setVisibility(0);
          this.t.setVisibility(0);
          this.s.setText(localCommonTroopInfo.troopName);
          this.t.setText(paramIntimateInfo.commonTroopTips);
          paramIntimateInfo = FaceDrawable.getFaceDrawable(this.h.n(), 4, localCommonTroopInfo.troopCode);
          this.r.setImageDrawable(paramIntimateInfo);
        }
      }
      this.p.setVisibility(8);
      if (i1 != 0)
      {
        this.p.setVisibility(0);
        this.p.setText((CharSequence)localObject);
        ReportController.b(null, "dc00898", "", "", "0X800AD21", "0X800AD21", 0, 0, "0", "0", "", "");
      }
      if (this.u) {
        ReportController.b(null, "dc00898", "", "", "0X8009F51", "0X8009F51", this.v, 0, "", "", "", "");
      }
    }
    else
    {
      this.m.setVisibility(8);
      this.n.setText(this.h.l().getResources().getString(2131890966));
      paramIntimateInfo = (LinearLayout.LayoutParams)this.n.getLayoutParams();
      paramIntimateInfo.leftMargin = 0;
      this.n.setLayoutParams(paramIntimateInfo);
      paramIntimateInfo = (RelativeLayout.LayoutParams)this.l.getLayoutParams();
      paramIntimateInfo.topMargin = AIOUtils.b(10.0F, this.h.l().getResources());
      this.l.setLayoutParams(paramIntimateInfo);
      this.o.setVisibility(0);
      this.o.setText((CharSequence)localObject);
      this.p.setVisibility(8);
      this.q.setVisibility(8);
      this.r.setVisibility(8);
      this.s.setVisibility(8);
      this.t.setVisibility(8);
      ReportController.b(null, "dc00898", "", "", "0X800AD21", "0X800AD21", 0, 0, "0", "0", "", "");
    }
  }
  
  protected boolean a()
  {
    boolean bool2 = FriendIntimateRelationshipConfProcessor.a().Y;
    List localList = this.d.commonTroopInfoList;
    boolean bool1 = true;
    int i1;
    if ((localList != null) && (this.d.commonTroopInfoList.size() > 0)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    localList = this.i;
    int i2;
    if ((localList != null) && (localList.size() > 0)) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    if (bool2)
    {
      if (i1 != 0) {
        return bool1;
      }
      if (i2 != 0) {
        return true;
      }
    }
    bool1 = false;
    return bool1;
  }
  
  protected void b()
  {
    Object localObject = LayoutInflater.from(this.a).inflate(2131625174, this, true);
    this.l = ((View)localObject).findViewById(2131431165);
    this.m = ((TextView)((View)localObject).findViewById(2131431164));
    this.n = ((TextView)((View)localObject).findViewById(2131431163));
    this.o = ((TextView)((View)localObject).findViewById(2131431162));
    this.p = ((TextView)((View)localObject).findViewById(2131431167));
    this.q = ((View)localObject).findViewById(2131444397);
    this.r = ((ImageView)((View)localObject).findViewById(2131444395));
    this.s = ((TextView)((View)localObject).findViewById(2131444396));
    this.t = ((TextView)((View)localObject).findViewById(2131444398));
    this.l.setOnClickListener(this);
    this.q.setOnClickListener(this);
    this.l.setOnTouchListener(this);
    this.q.setOnTouchListener(this);
    float f = this.a.getResources().getDisplayMetrics().density;
    localObject = this.o;
    int i1 = (int)(f * 10.0F + 0.5F);
    AIOUtils.a((View)localObject, i1, i1, i1, i1);
    AIOUtils.a(this.p, i1, i1, i1, i1);
    localObject = new IntimateContentItemCommonTroopView.1(this);
    IntimateContentItemCommonTroopView.2 local2 = new IntimateContentItemCommonTroopView.2(this);
    this.o.setOnClickListener(local2);
    this.p.setOnClickListener((View.OnClickListener)localObject);
  }
  
  public void setNeedReportPage(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  public void setReportType(int paramInt)
  {
    this.v = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemCommonTroopView
 * JD-Core Version:    0.7.0.1
 */