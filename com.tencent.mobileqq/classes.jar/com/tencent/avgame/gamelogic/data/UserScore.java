package com.tencent.avgame.gamelogic.data;

import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.io.Serializable;
import trpc.qq_vgame.game_ranking.AvGameRanking.UserScoreInfo;

public class UserScore
  implements Serializable
{
  public int score;
  public long uin;
  
  public UserScore clone()
  {
    UserScore localUserScore = new UserScore();
    try
    {
      localUserScore.uin = this.uin;
      localUserScore.score = this.score;
      return localUserScore;
    }
    catch (Exception localException) {}
    return localUserScore;
  }
  
  public final void parseFrom(AvGameRanking.UserScoreInfo paramUserScoreInfo)
  {
    this.uin = paramUserScoreInfo.uin.get();
    this.score = paramUserScoreInfo.score.get();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin").append("=").append(this.uin).append("|");
    localStringBuilder.append("score").append("=").append(this.score).append("|");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.data.UserScore
 * JD-Core Version:    0.7.0.1
 */