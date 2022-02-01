package com.tencent.avgame.gamelobby.rv;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.avgame.gamelobby.data.AVGameLobbyRandomMatchContentInfo;
import com.tencent.avgame.gameroom.GameRoomViewLayoutParamsDef;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.utils.ViewUtils;

public class AVGameLobbyRandomMatchCellViewHolder
  extends BaseViewHolder<AVGameLobbyRandomMatchContentInfo>
  implements View.OnTouchListener
{
  private static final String d = "com.tencent.avgame.gamelobby.rv.AVGameLobbyRandomMatchCellViewHolder";
  private AsyncImageView e;
  private AsyncImageView f;
  private TextView g;
  private RelativeLayout h;
  private RelativeLayout i;
  private Context j = null;
  
  public AVGameLobbyRandomMatchCellViewHolder(@NonNull View paramView)
  {
    super(paramView);
    this.j = paramView.getContext();
    this.h = ((RelativeLayout)paramView.findViewById(2131428957));
    this.i = ((RelativeLayout)paramView.findViewById(2131428958));
    this.g = ((TextView)paramView.findViewById(2131440397));
    this.e = ((AsyncImageView)paramView.findViewById(2131439121));
    this.f = ((AsyncImageView)paramView.findViewById(2131428956));
    this.h.setOnTouchListener(this);
    a(this.h);
  }
  
  protected void a()
  {
    super.a();
  }
  
  public void a(ViewHolderContext paramViewHolderContext, AVGameLobbyRandomMatchContentInfo paramAVGameLobbyRandomMatchContentInfo, int paramInt)
  {
    super.a(paramViewHolderContext, paramAVGameLobbyRandomMatchContentInfo, paramInt);
    if (paramAVGameLobbyRandomMatchContentInfo == null) {
      return;
    }
    paramViewHolderContext = (RelativeLayout.LayoutParams)this.h.getLayoutParams();
    paramViewHolderContext.width = GameRoomViewLayoutParamsDef.p;
    paramViewHolderContext.height = GameRoomViewLayoutParamsDef.q;
    paramInt = ViewUtils.dip2px(15.0F);
    int k = paramAVGameLobbyRandomMatchContentInfo.g % 3;
    if (k != 0)
    {
      if (k != 1)
      {
        if (k == 2)
        {
          this.i.setGravity(53);
          this.i.setPadding(0, 0, GameRoomViewLayoutParamsDef.u, paramInt);
        }
      }
      else
      {
        this.i.setGravity(49);
        this.i.setPadding(0, 0, 0, paramInt);
      }
    }
    else
    {
      this.i.setGravity(51);
      this.i.setPadding(GameRoomViewLayoutParamsDef.u, 0, 0, paramInt);
    }
    if (TextUtils.isEmpty(paramAVGameLobbyRandomMatchContentInfo.f)) {
      this.g.setText(String.format(this.j.getResources().getString(2131887289), new Object[] { Integer.valueOf(0) }));
    } else {
      this.g.setText(paramAVGameLobbyRandomMatchContentInfo.f);
    }
    this.e.setUrlIconAsyncImage(paramAVGameLobbyRandomMatchContentInfo.d);
    this.f.setUrlIconAsyncImage(paramAVGameLobbyRandomMatchContentInfo.e);
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
 * Qualified Name:     com.tencent.avgame.gamelobby.rv.AVGameLobbyRandomMatchCellViewHolder
 * JD-Core Version:    0.7.0.1
 */