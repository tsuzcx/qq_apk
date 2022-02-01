package com.tencent.ilivesdk.service;

import android.content.Context;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.utils.DevOptUtil;
import com.tencent.ilivesdk.roomswitchservice_interface.RoomSwitchInterface;
import com.tencent.ilivesdk.roomswitchservice_interface.RoomSwitchInterface.IRoomList;
import com.tencent.ilivesdk.roomswitchservice_interface.RoomSwitchInterface.QueryRoomListTrigger;
import com.tencent.ilivesdk.roomswitchservice_interface.SwitchRoomInfo;
import java.util.List;

public class RoomSwitchCgiService
  implements RoomSwitchInterface
{
  private String DOMAIN = "https://now.qq.com/";
  private final String TAG = "RoomSwitchCgiService";
  private String TEST_DOMAIN = "https://fastest.now.qq.com/";
  private RoomSwitchServiceAdapter mAdapetr;
  private String mCgiUrl;
  private Context mContext;
  private RoomSwitchInterface.QueryRoomListTrigger mQueryRoomListTrigger = null;
  private String mUrl = "cgi-bin/now/web/user/get_personal_live_rcmd_read?offset=0&num=100&tab_id=2&bkn=1295380881";
  String video_url1 = "http://grouptalk.c2c.qq.com/qqBFdownload?ver=0&openid=87654321&bid=10011&authkey=30400201010439303702010102010102010002037a13f50204da49eedd0204ec49eedd02037a1afd02041b0f5b650204a43e5b6502045e7630a10204d74739a90400&fileid=30580201030451304f0201000408383736353433323102037a13f50204da49eedd02045e6e47cb0420373633306539616430376163383134313234373061393639663232663962303202010002020902020300c3540201000400&filetype=2306&filekey=7630e9ad07ac81412470a969f22f9b02&setnum=50004";
  String video_url2 = "http://grouptalk.c2c.qq.com/qqBFdownload?ver=0&openid=87654321&bid=10011&authkey=30400201010439303702010102010102010002037a1afd02041f16a3b402041b16a3b402037a1db902049fb6120e020448fd03b702045ede039a02048d9515670400&fileid=30580201030451304f0201000408383736353433323102037a1afd02041f16a3b402045ed61aa20420613737636536353636303138656635363831313666376138313162366639663302010002020902020300c3540201000400&filetype=2306&filekey=a77ce6566018ef568116f7a811b6f9f3&setnum=50004";
  String video_url3 = "http://grouptalk.c2c.qq.com/qqstocdnd?filekey=a09da4d5a85a6256aae0ff4819ddaeb6&fileid=305902010304523050020100040935323236323438353502037a1db902048bb1120e02045e42642e0420613039646134643561383561363235366161653066663438313964646165623602010002020902020300c3520201000400&bid=10011&setnum=50002&authkey=30400201010439303702010102010102010002037a1db902048bb1120e02044afd03b702037a13f502045a90977b0204784c977b02045e4a4d2a0204bdda52df0400&filetype=2306,segNum=0,segPos=48,whence=0";
  
  public void clearEventOutput() {}
  
  public boolean closeRoomSwitch()
  {
    return false;
  }
  
  public RoomSwitchInterface.QueryRoomListTrigger getQueryRoomListTrigger()
  {
    return this.mQueryRoomListTrigger;
  }
  
  public void init(RoomSwitchServiceAdapter paramRoomSwitchServiceAdapter)
  {
    this.mAdapetr = paramRoomSwitchServiceAdapter;
  }
  
  public void onCreate(Context paramContext)
  {
    this.mContext = paramContext;
    StringBuilder localStringBuilder = new StringBuilder();
    if (DevOptUtil.isTestEnv(paramContext)) {}
    for (paramContext = this.TEST_DOMAIN;; paramContext = this.DOMAIN)
    {
      this.mCgiUrl = (paramContext + this.mUrl);
      return;
    }
  }
  
  public void onDestroy() {}
  
  public void queryRoomList(List<SwitchRoomInfo> paramList, int paramInt1, int paramInt2, RoomSwitchInterface.IRoomList paramIRoomList)
  {
    this.mAdapetr.getHttpInterface().get(this.mCgiUrl, new RoomSwitchCgiService.1(this, paramList, paramIRoomList));
  }
  
  public void setQueryRoomListTrigger(RoomSwitchInterface.QueryRoomListTrigger paramQueryRoomListTrigger)
  {
    this.mQueryRoomListTrigger = paramQueryRoomListTrigger;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.service.RoomSwitchCgiService
 * JD-Core Version:    0.7.0.1
 */