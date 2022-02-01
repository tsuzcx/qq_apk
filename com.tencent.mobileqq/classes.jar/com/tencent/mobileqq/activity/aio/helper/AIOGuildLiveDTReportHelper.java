package com.tencent.mobileqq.activity.aio.helper;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.guild.chatpie.helper.AIOGuildDTReportHelper;
import com.tencent.mobileqq.guild.data.QQGuildDTConstant;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.Map;

public class AIOGuildLiveDTReportHelper
  extends AIOGuildDTReportHelper
{
  private View e;
  
  public AIOGuildLiveDTReportHelper(@NonNull BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
    this.d = this.a.aW();
  }
  
  protected void a()
  {
    super.a();
  }
  
  protected void b(View paramView)
  {
    this.e = paramView;
    f();
  }
  
  public void f()
  {
    VideoReport.resetPageParams(this.e);
    IGProChannelInfo localIGProChannelInfo = ((GuildChatContext)this.a.bv()).U();
    if (localIGProChannelInfo == null) {
      return;
    }
    String str1 = ((GuildChatContext)this.a.bv()).S();
    Object localObject2 = ((GuildChatContext)this.a.bv()).a();
    Object localObject1 = ((GuildChatContext)this.a.bv()).O().d();
    localObject2 = ((IGPSService)((AppInterface)localObject2).getRuntimeService(IGPSService.class, "")).getGuildInfo(str1);
    String str2 = Long.toString(localIGProChannelInfo.getLiveAnchorTinyId());
    int j = 2;
    int i;
    if ((str2 != null) && (localObject1 != null) && (((String)localObject1).equals(str2))) {
      i = 1;
    } else {
      i = 2;
    }
    if (localIGProChannelInfo.getLiveRoomId() <= 0L) {
      j = 1;
    }
    localObject1 = new HashMap();
    if (localObject2 == null) {
      ((HashMap)localObject1).put("sgrp_user_type", "4");
    } else {
      ((HashMap)localObject1).put("sgrp_user_type", Integer.valueOf(QQGuildDTConstant.a(((IGProGuildInfo)localObject2).getUserType())));
    }
    ((HashMap)localObject1).put("sgrp_stream_aio_type", Integer.valueOf(i));
    ((HashMap)localObject1).put("sgrp_stream_status", Integer.valueOf(j));
    ((HashMap)localObject1).put("sgrp_sub_channel_id", localIGProChannelInfo.getChannelUin());
    ((HashMap)localObject1).put("sgrp_channel_id", str1);
    ((HashMap)localObject1).put("sgrp_sub_channel_type", Integer.valueOf(3));
    ((HashMap)localObject1).put("sgrp_sub_channel_limit", Integer.toString(localIGProChannelInfo.getTalkPermission()));
    ((HashMap)localObject1).put("sgrp_channel_name", localIGProChannelInfo.getChannelName());
    ((HashMap)localObject1).put("sgrp_channel_groupname", localIGProChannelInfo.getCategoryName());
    VideoReport.setPageParams(this.e, new PageParams((Map)localObject1));
    VideoReport.setPageId(this.d, "pg_sgrp_stream_aio");
    VideoReport.setPageContentId(this.d, String.valueOf(SystemClock.elapsedRealtime()), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOGuildLiveDTReportHelper
 * JD-Core Version:    0.7.0.1
 */