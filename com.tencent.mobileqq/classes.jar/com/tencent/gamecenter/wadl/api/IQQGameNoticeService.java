package com.tencent.gamecenter.wadl.api;

import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;
import org.json.JSONObject;

@Service(process={""})
public abstract interface IQQGameNoticeService
  extends IRuntimeService
{
  public static final int MSG_GAMECENTER_BAR_HIDE = 1134072;
  public static final int MSG_GAMECENTER_BAR_SHOW = 1134071;
  public static final int MSG_GAME_BAR_HIDE = 1134050;
  public static final int MSG_GAME_BAR_SHOW = 1134049;
  
  public abstract void checkBannerFromResume();
  
  public abstract void saveTipInfo(String paramString, JSONObject paramJSONObject);
  
  public abstract void updateGameCenterBar(View paramView, Message paramMessage);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.IQQGameNoticeService
 * JD-Core Version:    0.7.0.1
 */