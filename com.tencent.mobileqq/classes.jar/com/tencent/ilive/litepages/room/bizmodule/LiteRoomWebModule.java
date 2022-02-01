package com.tencent.ilive.litepages.room.bizmodule;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.ilive.litepages.room.webmodule.LiteWebView;
import com.tencent.ilive.litepages.room.webmodule.WebCookieManager;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilive.pages.room.bizmodule.RoomBizModule;
import com.tencent.ilivesdk.domain.factory.LiveCaseFactory;
import com.tencent.ilivesdk.domain.factory.LiveCaseType;
import com.tencent.ilivesdk.domain.factory.LiveUseCase;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.ilivesdk.roomswitchservice_interface.VideoType;
import com.tencent.livesdk.roomengine.RoomEngine;
import com.tencent.smtt.sdk.WebView;

public class LiteRoomWebModule
  extends RoomBizModule
{
  private final String LIVE_URL = "https://now.qq.com/lite/h5/lite_room.html?roomid=%s";
  private final String TEST_LIVE_URL = "https://fastest.now.qq.com/lite/h5/lite_room.html?roomid=%s";
  private final String TEST_VIDEO_URL = "https://fastest.now.qq.com/lite/h5/lite_record.html?vid=%s";
  private final String VIDEO_URL = "https://now.qq.com/lite/h5/lite_record.html?vid=%s";
  private LiveUseCase<Long, Boolean> listenVideoTimeCase;
  private String mUrl;
  private int mVideoType;
  private WebView mWebView;
  private ViewGroup viewGroup;
  
  private void plantCookie()
  {
    WebCookieManager.getInstance().plant(this.context, this.mUrl);
    WebCookieManager.getInstance().plant(this.context, "https://yutang.qq.com/");
    WebCookieManager.getInstance().plant(this.context, "https://ilive.qq.com/");
  }
  
  private void startListenVideoTime()
  {
    this.listenVideoTimeCase.roomExecute(getRoomEngine(), this.mLifecycleOwner, Boolean.valueOf(true), new LiteRoomWebModule.2(this));
  }
  
  private void stopListenVideoTime()
  {
    this.listenVideoTimeCase.onDestroy();
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    Object localObject = (ViewStub)getRootView().findViewById(2131363663);
    ((ViewStub)localObject).setLayoutResource(2131559226);
    this.viewGroup = ((ViewGroup)((ViewStub)localObject).inflate());
    this.viewGroup.setBackgroundColor(0);
    boolean bool = ((AppGeneralInfoService)getRoomEngine().getService(AppGeneralInfoService.class)).isSvrTestEnv();
    this.mVideoType = this.roomBizContext.getEnterRoomInfo().videoType;
    if (this.mVideoType == VideoType.VIDEO.ordinal())
    {
      String str = this.roomBizContext.getEnterRoomInfo().videoId;
      if (bool) {
        localObject = "https://fastest.now.qq.com/lite/h5/lite_record.html?vid=%s";
      } else {
        localObject = "https://now.qq.com/lite/h5/lite_record.html?vid=%s";
      }
      this.mUrl = String.format((String)localObject, new Object[] { str });
    }
    else
    {
      long l = this.roomBizContext.getEnterRoomInfo().roomId;
      if (bool) {
        localObject = "https://fastest.now.qq.com/lite/h5/lite_room.html?roomid=%s";
      } else {
        localObject = "https://now.qq.com/lite/h5/lite_room.html?roomid=%s";
      }
      this.mUrl = String.format((String)localObject, new Object[] { Long.valueOf(l) });
    }
    System.currentTimeMillis();
    this.mWebView = new LiteWebView(paramContext, getRootView(), new LiteRoomWebModule.1(this));
    this.mWebView.setBackgroundColor(0);
    this.mWebView.loadUrl(this.mUrl);
    this.viewGroup.addView(this.mWebView);
    plantCookie();
  }
  
  protected void onCreateCases()
  {
    this.listenVideoTimeCase = getLiveCaseFactory().getCase(LiveCaseType.LISTEN_VIDEO_CURRENT_POSITION);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.listenVideoTimeCase.onDestroy();
    this.viewGroup.removeAllViews();
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    super.onEnterRoom(paramBoolean);
    if (this.mVideoType == VideoType.VIDEO.ordinal()) {
      startListenVideoTime();
    }
  }
  
  public void onVisibleToUser(boolean paramBoolean)
  {
    super.onVisibleToUser(paramBoolean);
    if ((!paramBoolean) && (this.mVideoType == VideoType.VIDEO.ordinal())) {
      stopListenVideoTime();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.bizmodule.LiteRoomWebModule
 * JD-Core Version:    0.7.0.1
 */