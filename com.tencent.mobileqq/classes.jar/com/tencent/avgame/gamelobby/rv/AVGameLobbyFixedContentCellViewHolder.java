package com.tencent.avgame.gamelobby.rv;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import com.tencent.avgame.gamelobby.data.AVGameLobbyFixedContentInfo;
import com.tencent.avgame.gamelobby.view.AutoResizeAsyncImageView;
import com.tencent.avgame.gamelobby.view.OverlappingImgLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;

public class AVGameLobbyFixedContentCellViewHolder
  extends BaseViewHolder<AVGameLobbyFixedContentInfo>
{
  private AsyncImageView d;
  private TextView e;
  private AutoResizeAsyncImageView f;
  private View g;
  private LinearLayout h;
  private OverlappingImgLayout i;
  private TextView j;
  private int k;
  private int l;
  private RecyclerView.LayoutParams m;
  private IFaceDecoder n = null;
  
  public AVGameLobbyFixedContentCellViewHolder(@NonNull View paramView)
  {
    super(paramView);
    this.m = ((RecyclerView.LayoutParams)paramView.getLayoutParams());
    this.k = this.m.width;
    this.l = this.m.height;
    this.d = ((AsyncImageView)paramView.findViewById(2131429096));
    this.e = ((TextView)paramView.findViewById(2131429093));
    this.g = paramView.findViewById(2131429092);
    this.f = ((AutoResizeAsyncImageView)paramView.findViewById(2131429094));
    this.h = ((LinearLayout)paramView.findViewById(2131429090));
    this.i = ((OverlappingImgLayout)paramView.findViewById(2131429089));
    this.j = ((TextView)paramView.findViewById(2131429091));
    paramView.setOnTouchListener(new AVGameLobbyFixedContentCellViewHolder.1(this));
    a(paramView);
  }
  
  private void a(AppInterface paramAppInterface)
  {
    if (this.n == null) {
      this.n = ((IQQAvatarService)paramAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramAppInterface);
    }
  }
  
  protected void a()
  {
    IFaceDecoder localIFaceDecoder = this.n;
    if (localIFaceDecoder != null) {
      localIFaceDecoder.destory();
    }
    super.a();
  }
  
  public void a(ViewHolderContext paramViewHolderContext, AVGameLobbyFixedContentInfo paramAVGameLobbyFixedContentInfo, int paramInt)
  {
    super.a(paramViewHolderContext, paramAVGameLobbyFixedContentInfo, paramInt);
    if (paramAVGameLobbyFixedContentInfo == null) {
      return;
    }
    if ((paramAVGameLobbyFixedContentInfo.j()) && (!AVGameLobbyFixedContentInfo.k()))
    {
      this.itemView.setVisibility(8);
      paramViewHolderContext = this.m;
      paramViewHolderContext.width = 0;
      paramViewHolderContext.height = 0;
      return;
    }
    this.itemView.setVisibility(0);
    RecyclerView.LayoutParams localLayoutParams = this.m;
    localLayoutParams.width = this.k;
    localLayoutParams.height = this.l;
    this.d.setUrlIconAsyncImage(paramAVGameLobbyFixedContentInfo.b());
    this.e.setText(paramAVGameLobbyFixedContentInfo.d());
    this.g.setBackgroundResource(paramAVGameLobbyFixedContentInfo.e());
    this.f.a(paramAVGameLobbyFixedContentInfo.g());
    if (paramAVGameLobbyFixedContentInfo.j())
    {
      if ((paramViewHolderContext instanceof AVGameLobbyViewHolderContext)) {
        a(((AVGameLobbyViewHolderContext)paramViewHolderContext).a());
      }
      this.h.setVisibility(0);
      this.i.a(17, 17, paramAVGameLobbyFixedContentInfo.h(), this.n);
      this.j.setText(this.itemView.getContext().getString(2131887294, new Object[] { Integer.valueOf(paramAVGameLobbyFixedContentInfo.f()) }));
      if (paramAVGameLobbyFixedContentInfo.f() > 0)
      {
        this.h.setVisibility(0);
        return;
      }
      this.h.setVisibility(8);
      return;
    }
    this.h.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.rv.AVGameLobbyFixedContentCellViewHolder
 * JD-Core Version:    0.7.0.1
 */