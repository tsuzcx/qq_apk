package com.tencent.avgame.gamelobby.rv;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.avgame.gamelobby.data.AVGameLobbySurvivalContentInfo;
import com.tencent.avgame.gamelobby.view.AutoResizeAsyncImageView;
import com.tencent.avgame.gamelobby.view.OverlappingImgLayout;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class AVGameLobbySurvivalCellViewHolder
  extends BaseViewHolder<AVGameLobbySurvivalContentInfo>
  implements View.OnTouchListener
{
  private static final String d = "com.tencent.avgame.gamelobby.rv.AVGameLobbySurvivalCellViewHolder";
  private AsyncImageView e;
  private TextView f;
  private AutoResizeAsyncImageView g;
  private View h;
  private LinearLayout i;
  private OverlappingImgLayout j;
  private TextView k;
  private RelativeLayout l;
  private AsyncImageView m;
  private TextView n;
  private TextView o;
  private View p;
  private IFaceDecoder q = null;
  
  public AVGameLobbySurvivalCellViewHolder(@NonNull View paramView)
  {
    super(paramView);
    this.e = ((AsyncImageView)paramView.findViewById(2131429113));
    this.f = ((TextView)paramView.findViewById(2131429107));
    this.h = paramView.findViewById(2131429105);
    this.g = ((AutoResizeAsyncImageView)paramView.findViewById(2131429108));
    this.i = ((LinearLayout)paramView.findViewById(2131429103));
    this.j = ((OverlappingImgLayout)paramView.findViewById(2131429102));
    this.k = ((TextView)paramView.findViewById(2131429104));
    this.l = ((RelativeLayout)paramView.findViewById(2131429111));
    this.m = ((AsyncImageView)paramView.findViewById(2131429110));
    this.n = ((TextView)paramView.findViewById(2131429112));
    this.o = ((TextView)paramView.findViewById(2131429114));
    this.p = paramView.findViewById(2131429106);
    paramView.setOnTouchListener(this);
    this.m.setOnTouchListener(this);
    a(this.m);
    a(paramView);
  }
  
  protected void a()
  {
    IFaceDecoder localIFaceDecoder = this.q;
    if (localIFaceDecoder != null) {
      localIFaceDecoder.destory();
    }
    super.a();
  }
  
  public void a(ViewHolderContext paramViewHolderContext, AVGameLobbySurvivalContentInfo paramAVGameLobbySurvivalContentInfo, int paramInt)
  {
    super.a(paramViewHolderContext, paramAVGameLobbySurvivalContentInfo, paramInt);
    if (paramAVGameLobbySurvivalContentInfo == null) {
      return;
    }
    this.e.setUrlIconAsyncImage(paramAVGameLobbySurvivalContentInfo.g());
    this.f.setText(paramAVGameLobbySurvivalContentInfo.l());
    if (!TextUtils.isEmpty(paramAVGameLobbySurvivalContentInfo.s()))
    {
      paramViewHolderContext = URLDrawable.getDrawable(paramAVGameLobbySurvivalContentInfo.s(), URLDrawableHelperConstants.a, URLDrawableHelperConstants.a);
    }
    else
    {
      float f1 = ViewUtils.dip2px(6.0F);
      paramInt = paramAVGameLobbySurvivalContentInfo.p();
      int i1 = paramAVGameLobbySurvivalContentInfo.q();
      paramViewHolderContext = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[] { paramInt | 0xFF000000, i1 | 0xFF000000 });
      paramViewHolderContext.setCornerRadius(f1);
      paramViewHolderContext.setGradientType(0);
    }
    this.h.setBackgroundDrawable(paramViewHolderContext);
    this.o.setVisibility(0);
    if (!TextUtils.isEmpty(paramAVGameLobbySurvivalContentInfo.r())) {
      this.o.setText(paramAVGameLobbySurvivalContentInfo.r());
    } else {
      this.o.setText(paramAVGameLobbySurvivalContentInfo.e());
    }
    if (paramAVGameLobbySurvivalContentInfo.b())
    {
      this.l.setVisibility(0);
      this.i.setVisibility(8);
      this.g.setVisibility(8);
      if (paramAVGameLobbySurvivalContentInfo.o()) {
        this.m.setClickable(true);
      } else {
        this.m.setClickable(false);
      }
      if (QLog.isColorLevel())
      {
        paramViewHolderContext = d;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("mReserveImageView isClickable:");
        localStringBuilder.append(this.m.isClickable());
        QLog.d(paramViewHolderContext, 2, localStringBuilder.toString());
      }
      if (paramAVGameLobbySurvivalContentInfo.i())
      {
        this.m.setUrlIconAsyncImage(paramAVGameLobbySurvivalContentInfo.n());
        this.n.setVisibility(8);
      }
      else
      {
        this.m.setUrlIconAsyncImage(paramAVGameLobbySurvivalContentInfo.m());
        this.n.setVisibility(0);
        this.n.setText(String.format(this.itemView.getContext().getString(2131887298), new Object[] { Integer.valueOf(paramAVGameLobbySurvivalContentInfo.j()) }));
      }
      ((RelativeLayout.LayoutParams)this.p.getLayoutParams()).rightMargin = ViewUtils.dip2px(10.0F);
      return;
    }
    paramViewHolderContext = d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ApngImage url:");
    localStringBuilder.append(paramAVGameLobbySurvivalContentInfo.h());
    QLog.d(paramViewHolderContext, 2, localStringBuilder.toString());
    this.g.a(paramAVGameLobbySurvivalContentInfo.h());
    this.g.setVisibility(0);
    this.l.setVisibility(8);
    this.i.setVisibility(8);
    ((RelativeLayout.LayoutParams)this.p.getLayoutParams()).rightMargin = ViewUtils.dip2px(90.0F);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionMasked();
    if (i1 != 0)
    {
      if ((i1 == 1) || (i1 == 3)) {
        paramView.setAlpha(1.0F);
      }
    }
    else {
      paramView.setAlpha(0.5F);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.rv.AVGameLobbySurvivalCellViewHolder
 * JD-Core Version:    0.7.0.1
 */