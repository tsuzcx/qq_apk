package com.tencent.avgame.gamelogic.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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
    Object localObject = paramSurvivalPkResultInfo.rankingUins;
    if (localObject != null) {
      this.rankingUins = new ArrayList((Collection)localObject);
    }
    localObject = paramSurvivalPkResultInfo.pkDrawRes;
    if (localObject != null) {
      this.pkDrawRes = new SurvivalPkResultInfo.PKDrawRes(((SurvivalPkResultInfo.PKDrawRes)localObject).isDraw, paramSurvivalPkResultInfo.pkDrawRes.selfCost, paramSurvivalPkResultInfo.pkDrawRes.peerCost);
    }
    this.winTips = paramSurvivalPkResultInfo.winTips;
    this.score = paramSurvivalPkResultInfo.score;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gameSur:");
    localStringBuilder.append(this.gameSur);
    localStringBuilder.append("|");
    localStringBuilder.append("winReason:");
    localStringBuilder.append(this.winReason);
    localStringBuilder.append("|");
    localStringBuilder.append("winRound:");
    localStringBuilder.append(this.winRound);
    localStringBuilder.append("|");
    localStringBuilder.append("rank:");
    localStringBuilder.append(this.rank);
    localStringBuilder.append("|");
    localStringBuilder.append("total:");
    localStringBuilder.append(this.total);
    localStringBuilder.append("|");
    localStringBuilder.append("awardText:");
    localStringBuilder.append(this.awardText);
    localStringBuilder.append("|");
    localStringBuilder.append("awardUrl:");
    localStringBuilder.append(this.awardUrl);
    localStringBuilder.append("|");
    localStringBuilder.append("delayAward:");
    localStringBuilder.append(this.delayAward);
    localStringBuilder.append("|");
    localStringBuilder.append("delayAwardTip:");
    localStringBuilder.append(this.delayAwardTip);
    localStringBuilder.append("|");
    localStringBuilder.append("awardUrlStr:");
    localStringBuilder.append(this.awardUrlStr);
    localStringBuilder.append("|");
    localStringBuilder.append("rankingUins:");
    localStringBuilder.append(this.rankingUins);
    localStringBuilder.append("|");
    localStringBuilder.append("pkDrawRes:");
    localStringBuilder.append(this.pkDrawRes);
    localStringBuilder.append("isBothClose");
    localStringBuilder.append(this.isBothClose);
    localStringBuilder.append("score");
    localStringBuilder.append(this.score);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo
 * JD-Core Version:    0.7.0.1
 */