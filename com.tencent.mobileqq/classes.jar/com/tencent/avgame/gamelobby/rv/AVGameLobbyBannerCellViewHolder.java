package com.tencent.avgame.gamelobby.rv;

import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.avgame.gamelobby.data.AVGameLobbyBannerContentInfo;
import com.tencent.avgame.gamelobby.data.AVGameLobbyConstants.BannerInfo;
import com.tencent.avgame.gamelobby.view.AutoResizeAsyncImageView;
import java.util.List;

public class AVGameLobbyBannerCellViewHolder
  extends BaseViewHolder<AVGameLobbyBannerContentInfo>
{
  private AutoResizeAsyncImageView d;
  
  public AVGameLobbyBannerCellViewHolder(@NonNull View paramView)
  {
    super(paramView);
    this.d = ((AutoResizeAsyncImageView)paramView.findViewById(2131429077));
    a(paramView);
  }
  
  public void a(ViewHolderContext paramViewHolderContext, AVGameLobbyBannerContentInfo paramAVGameLobbyBannerContentInfo, int paramInt)
  {
    super.a(paramViewHolderContext, paramAVGameLobbyBannerContentInfo, paramInt);
    if (paramAVGameLobbyBannerContentInfo == null) {
      return;
    }
    paramViewHolderContext = paramAVGameLobbyBannerContentInfo.b();
    if ((paramViewHolderContext != null) && (paramViewHolderContext.size() > 0)) {
      this.d.a(((AVGameLobbyConstants.BannerInfo)paramViewHolderContext.get(0)).a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.rv.AVGameLobbyBannerCellViewHolder
 * JD-Core Version:    0.7.0.1
 */