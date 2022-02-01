package com.tencent.avgame.gamelobby.rv;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.tencent.avgame.gamelobby.data.AVGameLobbyCreateAndJoinContentInfo;
import com.tencent.avgame.gamelobby.view.AutoResizeAsyncImageView;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.utils.ViewUtils;

public class AVGameLobbyCreateAndJoinCellViewHolder
  extends BaseViewHolder<AVGameLobbyCreateAndJoinContentInfo>
  implements View.OnTouchListener
{
  private static final String d = "com.tencent.avgame.gamelobby.rv.AVGameLobbyCreateAndJoinCellViewHolder";
  private AsyncImageView e;
  private AsyncImageView f;
  private AutoResizeAsyncImageView g;
  private AutoResizeAsyncImageView h;
  private LinearLayout i;
  private Context j = null;
  
  public AVGameLobbyCreateAndJoinCellViewHolder(@NonNull View paramView)
  {
    super(paramView);
    this.j = paramView.getContext();
    this.e = ((AsyncImageView)paramView.findViewById(2131429088));
    this.f = ((AsyncImageView)paramView.findViewById(2131429100));
    this.g = ((AutoResizeAsyncImageView)paramView.findViewById(2131429086));
    this.h = ((AutoResizeAsyncImageView)paramView.findViewById(2131429098));
    this.i = ((LinearLayout)paramView.findViewById(2131429085));
    View localView = paramView.findViewById(2131429087);
    paramView = paramView.findViewById(2131429099);
    localView.setOnTouchListener(this);
    paramView.setOnTouchListener(this);
    a(paramView);
    a(localView);
  }
  
  protected void a()
  {
    super.a();
  }
  
  public void a(ViewHolderContext paramViewHolderContext, AVGameLobbyCreateAndJoinContentInfo paramAVGameLobbyCreateAndJoinContentInfo, int paramInt)
  {
    super.a(paramViewHolderContext, paramAVGameLobbyCreateAndJoinContentInfo, paramInt);
    if (paramAVGameLobbyCreateAndJoinContentInfo == null) {
      return;
    }
    this.g.a(paramAVGameLobbyCreateAndJoinContentInfo.a);
    this.h.a(paramAVGameLobbyCreateAndJoinContentInfo.b);
    this.e.setUrlIconAsyncImage(paramAVGameLobbyCreateAndJoinContentInfo.c);
    this.f.setUrlIconAsyncImage(paramAVGameLobbyCreateAndJoinContentInfo.d);
    int m = ViewUtils.dip2px(16.0F);
    int k;
    if (paramAVGameLobbyCreateAndJoinContentInfo.e)
    {
      paramInt = ViewUtils.dip2px(97.0F);
      k = ViewUtils.dip2px(27.0F);
    }
    else
    {
      paramInt = ViewUtils.dip2px(83.0F);
      k = ViewUtils.dip2px(13.0F);
    }
    this.i.getLayoutParams().height = paramInt;
    this.i.setPadding(m, k, m, 0);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int k = paramMotionEvent.getActionMasked();
    if (k != 0)
    {
      if ((k == 1) || (k == 3)) {
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
 * Qualified Name:     com.tencent.avgame.gamelobby.rv.AVGameLobbyCreateAndJoinCellViewHolder
 * JD-Core Version:    0.7.0.1
 */