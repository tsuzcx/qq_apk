package com.tencent.avgame.gamelogic.data;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.io.Serializable;
import trpc.qq_vgame.pk_manager.AvGamePkManager.PKOperationRsp;

public class PkCJOperationData
  implements Serializable
{
  public String answerTip;
  public String biaAdTip;
  public String biaAdWording;
  public String bizTitelPicUrl;
  public String bizTitlePicIdx;
  public boolean closeRealtimeReport;
  public int curRound;
  public boolean mavClose = false;
  public int scene = 0;
  public int sponsorId;
  
  public static PkCJOperationData convertFromPB(AvGamePkManager.PKOperationRsp paramPKOperationRsp)
  {
    PkCJOperationData localPkCJOperationData = new PkCJOperationData();
    localPkCJOperationData.scene = paramPKOperationRsp.scene.get();
    localPkCJOperationData.mavClose = paramPKOperationRsp.mav_closed.get();
    localPkCJOperationData.bizTitlePicIdx = paramPKOperationRsp.biz_title_pic_idx.get();
    localPkCJOperationData.bizTitelPicUrl = paramPKOperationRsp.biz_titel_pic_url.get();
    localPkCJOperationData.biaAdWording = paramPKOperationRsp.biz_ad_wording.get();
    localPkCJOperationData.biaAdTip = paramPKOperationRsp.biz_ad_tip.get();
    localPkCJOperationData.answerTip = paramPKOperationRsp.answer_tip.get();
    localPkCJOperationData.sponsorId = paramPKOperationRsp.sponsor_id.get();
    localPkCJOperationData.curRound = paramPKOperationRsp.curRound.get();
    localPkCJOperationData.closeRealtimeReport = paramPKOperationRsp.close_realtime_report.get();
    return localPkCJOperationData;
  }
  
  public boolean hasAVRoom()
  {
    return !this.mavClose;
  }
  
  public boolean isCJ()
  {
    return this.scene == 1;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{ scene=").append(this.scene).append(" mavClose=").append(this.mavClose).append(" bizTitlePicIdx=").append(this.bizTitlePicIdx).append(" bizTitelPicUrl=").append(this.bizTitelPicUrl);
    localStringBuilder.append(" biaAdWording=").append(this.biaAdWording).append(" biaAdTip=").append(this.biaAdTip).append(" answerTip=").append(this.answerTip).append(" curRound=").append(this.curRound);
    localStringBuilder.append(" closeRealtimeReport=").append(this.closeRealtimeReport).append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.data.PkCJOperationData
 * JD-Core Version:    0.7.0.1
 */