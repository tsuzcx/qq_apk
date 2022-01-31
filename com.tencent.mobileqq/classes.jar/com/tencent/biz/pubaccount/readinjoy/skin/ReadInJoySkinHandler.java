package com.tencent.biz.pubaccount.readinjoy.skin;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import lwy;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.GuideInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.RefreshInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.ReqBody;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.SkinInfo;

public class ReadInJoySkinHandler
  extends BusinessHandler
{
  public ReadInJoySkinHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  protected Class a()
  {
    return ReadInJoySkinHandler.ReadInJoySkinObserver.class;
  }
  
  public void a(SkinData paramSkinData, GuideData paramGuideData1, RefreshData paramRefreshData, GuideData paramGuideData2)
  {
    paramGuideData1 = new oidb_0x5bd.ReqBody();
    paramGuideData1.uint64_uin.set(this.b.getLongAccountUin(), true);
    if (paramSkinData != null) {
      paramGuideData1.msg_current_skin_info.set(paramSkinData.toBody(), true);
    }
    if (paramRefreshData != null) {
      paramGuideData1.msg_current_refresh_info.set(paramRefreshData.toRefreshInfoBody(), true);
    }
    if (paramGuideData2 != null) {
      paramGuideData1.msg_current_guide_info.set(paramGuideData2.toBody(), true);
    }
    ProtoUtils.a(this.b, new lwy(this), paramGuideData1.toByteArray(), "OidbSvc.0x5bd_1", 1469, 1, new Bundle(), 6000L);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinHandler
 * JD-Core Version:    0.7.0.1
 */