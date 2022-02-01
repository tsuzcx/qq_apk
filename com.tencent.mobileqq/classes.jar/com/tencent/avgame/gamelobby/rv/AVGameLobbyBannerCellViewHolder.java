package com.tencent.avgame.gamelobby.rv;

import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.avgame.gamelobby.data.AVGameLobbyBannerContentInfo;
import com.tencent.avgame.gamelobby.view.AutoResizeAsyncImageView;
import com.tencent.avgame.ui.AVGameRoomCenterFragment.BannerInfo;
import java.util.List;

public class AVGameLobbyBannerCellViewHolder
  extends BaseViewHolder<AVGameLobbyBannerContentInfo>
{
  private AutoResizeAsyncImageView a;
  
  public AVGameLobbyBannerCellViewHolder(@NonNull View paramView)
  {
    super(paramView);
    this.a = ((AutoResizeAsyncImageView)paramView.findViewById(2131363271));
    a(paramView);
  }
  
  public void a(ViewHolderContext paramViewHolderContext, AVGameLobbyBannerContentInfo paramAVGameLobbyBannerContentInfo, int paramInt)
  {
    super.a(paramViewHolderContext, paramAVGameLobbyBannerContentInfo, paramInt);
    if (paramAVGameLobbyBannerContentInfo == null) {}
    do
    {
      return;
      paramViewHolderContext = paramAVGameLobbyBannerContentInfo.a();
    } while ((paramViewHolderContext == null) || (paramViewHolderContext.size() <= 0));
    this.a.a(((AVGameRoomCenterFragment.BannerInfo)paramViewHolderContext.get(0)).a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.rv.AVGameLobbyBannerCellViewHolder
 * JD-Core Version:    0.7.0.1
 */