package com.tencent.aelight.camera.ae.camera.ui.bottom;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.utils.UIUtils;

public class AEBottomListAdapter$ViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public AEMaterialMetaData a;
  private ImageView b;
  private View c;
  private ImageView d;
  private ImageView e;
  private ImageView f;
  private RelativeLayout g;
  private AEBottomListScrollView h;
  private boolean i;
  
  public AEBottomListAdapter$ViewHolder(View paramView, AEBottomListScrollView paramAEBottomListScrollView, boolean paramBoolean)
  {
    super(paramView);
    this.b = ((ImageView)paramView.findViewById(2063991592));
    this.f = ((ImageView)paramView.findViewById(2063991599));
    this.c = paramView.findViewById(2063991605);
    this.d = ((ImageView)paramView.findViewById(2063991606));
    this.e = ((ImageView)paramView.findViewById(2063991601));
    this.g = ((RelativeLayout)paramView.findViewById(2063991608));
    this.h = paramAEBottomListScrollView;
    this.i = paramBoolean;
  }
  
  public void a(int paramInt)
  {
    View localView;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return;
            }
            this.b.setSelected(false);
            this.g.setVisibility(4);
            return;
          }
          this.b.setSelected(true);
          if ((this.a.u) && (!this.i) && (!"0".equals(this.a.m)))
          {
            this.g.setVisibility(0);
            return;
          }
          this.g.setVisibility(4);
          return;
        }
        localView = this.c;
        if (localView != null) {
          localView.setVisibility(8);
        }
      }
      else
      {
        localView = this.c;
        if (localView != null) {
          localView.setVisibility(0);
        }
      }
    }
    else
    {
      localView = this.c;
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
  }
  
  public void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    this.a = paramAEMaterialMetaData;
    if (this.a != null)
    {
      this.g.setVisibility(4);
      if ((!"0".equals(this.a.m)) && (!"call_material_id".equals(this.a.m)))
      {
        if ("stub_placeholder_material_id".equals(this.a.m))
        {
          this.b.setVisibility(0);
          this.c.setVisibility(8);
          this.d.setVisibility(8);
          this.f.setVisibility(0);
          this.f.setImageResource(2063925645);
        }
        else if (this.a.a())
        {
          this.b.setVisibility(8);
          this.f.setVisibility(0);
          this.f.setTag(2131446833, this.a.q);
          this.f.setTag(2131446799, Boolean.valueOf(false));
          UIUtils.a(this.f, this.a.q, UIUtils.a(this.itemView.getContext(), AEBottomListAdapter.e()), UIUtils.a(this.itemView.getContext(), AEBottomListAdapter.e()), this.itemView.getContext().getResources().getDrawable(2063925645), null);
          this.f.setVisibility(0);
          this.c.setVisibility(8);
          this.d.setVisibility(0);
          this.d.setImageResource(2130847606);
        }
        else
        {
          this.b.setVisibility(0);
          this.f.setVisibility(0);
          this.f.setTag(2131446833, this.a.q);
          this.f.setTag(2131446799, Boolean.valueOf(false));
          UIUtils.a(this.f, this.a.q, UIUtils.a(this.itemView.getContext(), AEBottomListAdapter.e()), UIUtils.a(this.itemView.getContext(), AEBottomListAdapter.e()), this.itemView.getContext().getResources().getDrawable(2063925645), null);
          if (this.a.A) {
            a(2);
          } else if (this.a.B) {
            a(1);
          } else {
            a(0);
          }
          this.d.setVisibility(8);
        }
      }
      else
      {
        this.c.setVisibility(8);
        this.d.setVisibility(8);
        this.f.setVisibility(8);
        if (this.i)
        {
          if ("0".equals(this.a.m))
          {
            this.b.setVisibility(8);
          }
          else
          {
            this.f.setVisibility(0);
            UIUtils.a(this.f, "https://downv6.qq.com/shadow_qqcamera/Android/image/material_more.png", UIUtils.a(this.itemView.getContext(), AEBottomListAdapter.e()), UIUtils.a(this.itemView.getContext(), AEBottomListAdapter.e()), this.itemView.getContext().getResources().getDrawable(2063925653), null);
          }
        }
        else {
          this.b.setVisibility(0);
        }
      }
      if (this.a.b())
      {
        this.d.setVisibility(0);
        this.d.setImageResource(this.a.c());
      }
      else if (this.a.a())
      {
        this.d.setVisibility(0);
        this.d.setImageResource(2130847606);
      }
      else
      {
        this.d.setVisibility(8);
      }
      this.itemView.setOnClickListener(this);
      if (this.i)
      {
        this.b.setImageResource(AEBottomListAdapter.c);
        return;
      }
      if ("call_material_id".equals(this.a.m))
      {
        this.b.setVisibility(0);
        this.f.setVisibility(8);
        UIUtils.a(this.b, "https://qd.myapp.com/myapp/qqteam/youqingzhiyuan/more.png", UIUtils.a(this.itemView.getContext(), 52.0F), UIUtils.a(this.itemView.getContext(), 52.0F), ResourcesCompat.getDrawable(this.itemView.getResources(), 2063925653, null), null);
        return;
      }
      this.b.setVisibility(0);
      this.f.setVisibility(0);
      if ("0".equals(this.a.m)) {
        this.f.setImageResource(2063925620);
      }
      paramAEMaterialMetaData = this.b;
      int j;
      if ("0".equals(this.a.m)) {
        j = 2063925269;
      } else {
        j = 2063925268;
      }
      paramAEMaterialMetaData.setBackgroundResource(j);
    }
  }
  
  public void b(AEMaterialMetaData paramAEMaterialMetaData)
  {
    this.a = paramAEMaterialMetaData;
  }
  
  public void onClick(View paramView)
  {
    int j = getAdapterPosition();
    if ((this.h != null) && (j >= 0))
    {
      AEBottomListAdapter.a = AEBottomListAdapter.b;
      AEBottomListAdapter.b = j;
      this.h.smoothScrollToPosition(j);
      if ((this.h.getAdapter() instanceof AEBottomListAdapter)) {
        ((AEBottomListAdapter)this.h.getAdapter()).a(true);
      }
    }
    paramView = this.a;
    if ((paramView != null) && ("call_material_id".equals(paramView.m)))
    {
      AEBaseDataReporter.a().ab();
      return;
    }
    AEBaseReportParam.a().r("none");
    AEBaseReportParam.a().q("2");
    AEBaseReportParam.a().g(0);
    if (j == 0) {
      AEBaseReportParam.a().f(-1);
    } else {
      AEBaseReportParam.a().f(j);
    }
    Object localObject = AEBaseDataReporter.a();
    paramView = this.a;
    String str = "";
    if (paramView == null) {
      paramView = "";
    } else {
      paramView = paramView.m;
    }
    ((AEBaseDataReporter)localObject).c(paramView);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("【Click】Item :");
    paramView = this.a;
    if (paramView == null) {
      paramView = "";
    } else {
      paramView = paramView.m;
    }
    ((StringBuilder)localObject).append(paramView);
    AEQLog.b("AEBottomListAdapter", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("【Click】Usable :");
    paramView = this.a;
    if (paramView == null) {
      paramView = str;
    } else {
      paramView = Boolean.valueOf(paramView.A);
    }
    ((StringBuilder)localObject).append(paramView);
    AEQLog.b("AEBottomListAdapter", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */