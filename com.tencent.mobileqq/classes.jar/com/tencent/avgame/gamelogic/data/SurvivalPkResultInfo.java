package com.tencent.avgame.gamelogic.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SurvivalPkResultInfo
  implements Serializable
{
  public String awardText;
  public String awardUrl;
  public String awardUrlStr;
  public boolean delayAward;
  public String delayAwardTip;
  public boolean gameSur;
  public boolean hasAward;
  public boolean isBothClose;
  public SurvivalPkResultInfo.PKDrawRes pkDrawRes;
  public int rank;
  public List<SurvivalPkResultInfo.Pair<Integer, Long>> rankingUins;
  public int score;
  public int total;
  public int winReason;
  public int winRound = -1;
  public String winTips;
  
  public void copyFrom(SurvivalPkResultInfo paramSurvivalPkResultInfo)
  {
    if (paramSurvivalPkResultInfo == null) {
      return;
    }
    this.gameSur = paramSurvivalPkResultInfo.gameSur;
    this.winReason = paramSurvivalPkResultInfo.winReason;
    this.winRound = paramSurvivalPkResultInfo.winRound;
    this.rank = paramSurvivalPkResultInfo.rank;
    this.total = paramSurvivalPkResultInfo.total;
    this.hasAward = paramSurvivalPkResultInfo.hasAward;
    this.awardText = paramSurvivalPkResultInfo.awardText;
    this.awardUrl = paramSurvivalPkResultInfo.awardUrl;
    this.awardUrlStr = paramSurvivalPkResultInfo.awardUrlStr;
    this.delayAward = paramSurvivalPkResultInfo.delayAward;
    this.delayAwardTip = paramSurvivalPkResultInfo.delayAwardTip;
    this.isBothClose = paramSurvivalPkResultInfo.isBothClose;
    if (paramSurvivalPkResultInfo.rankingUins != null) {
      this.rankingUins = new ArrayList(paramSurvivalPkResultInfo.rankingUins);
    }
    if (paramSurvivalPkResultInfo.pkDrawRes != null) {
      this.pkDrawRes = new SurvivalPkResultInfo.PKDrawRes(paramSurvivalPkResultInfo.pkDrawRes.isDraw, paramSurvivalPkResultInfo.pkDrawRes.selfCost, paramSurvivalPkResultInfo.pkDrawRes.peerCost);
    }
    this.winTips = paramSurvivalPkResultInfo.winTips;
    this.score = paramSurvivalPkResultInfo.score;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gameSur:").append(this.gameSur).append("|");
    localStringBuilder.append("winReason:").append(this.winReason).append("|");
    localStringBuilder.append("winRound:").append(this.winRound).append("|");
    localStringBuilder.append("rank:").append(this.rank).append("|");
    localStringBuilder.append("total:").append(this.total).append("|");
    localStringBuilder.append("awardText:").append(this.awardText).append("|");
    localStringBuilder.append("awardUrl:").append(this.awardUrl).append("|");
    localStringBuilder.append("delayAward:").append(this.delayAward).append("|");
    localStringBuilder.append("delayAwardTip:").append(this.delayAwardTip).append("|");
    localStringBuilder.append("awardUrlStr:").append(this.awardUrlStr).append("|");
    localStringBuilder.append("rankingUins:").append(this.rankingUins).append("|");
    localStringBuilder.append("pkDrawRes:").append(this.pkDrawRes);
    localStringBuilder.append("isBothClose").append(this.isBothClose);
    localStringBuilder.append("score").append(this.score);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo
 * JD-Core Version:    0.7.0.1
 */