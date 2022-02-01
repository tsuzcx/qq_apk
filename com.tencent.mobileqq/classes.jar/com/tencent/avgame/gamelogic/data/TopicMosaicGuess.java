package com.tencent.avgame.gamelogic.data;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import trpc.qq_vgame.common.AvGameCommon.GameQuestionInfo;
import trpc.qq_vgame.common.AvGameCommon.GuessPictureQuestionInfo;
import trpc.qq_vgame.common.AvGameCommon.GuessPictureTipsInfo;

public class TopicMosaicGuess
  extends TopicBase
{
  public void a(AvGameCommon.GameQuestionInfo paramGameQuestionInfo)
  {
    if (paramGameQuestionInfo.type.get() == 2)
    {
      if (paramGameQuestionInfo.picture.has())
      {
        AvGameCommon.GuessPictureQuestionInfo localGuessPictureQuestionInfo = (AvGameCommon.GuessPictureQuestionInfo)paramGameQuestionInfo.picture.get();
        this.h = Math.max(0, paramGameQuestionInfo.index.get() - 1);
        int i;
        if (paramGameQuestionInfo.id.has()) {
          i = paramGameQuestionInfo.id.get();
        } else {
          i = this.a;
        }
        this.a = i;
        Object localObject2 = this.i;
        boolean bool = localGuessPictureQuestionInfo.url.has();
        Object localObject1 = "";
        if (bool) {
          paramGameQuestionInfo = localGuessPictureQuestionInfo.url.get();
        } else {
          paramGameQuestionInfo = "";
        }
        ((AVRes)localObject2).a(paramGameQuestionInfo, null, 0, "");
        localObject2 = this.j;
        if (localGuessPictureQuestionInfo.answer.has()) {
          paramGameQuestionInfo = localGuessPictureQuestionInfo.answer.get();
        } else {
          paramGameQuestionInfo = "";
        }
        ((AVRes)localObject2).a(paramGameQuestionInfo, null, 0, "");
        if (localGuessPictureQuestionInfo.size.has()) {
          i = localGuessPictureQuestionInfo.size.get();
        } else {
          i = this.m;
        }
        this.m = i;
        localObject2 = this.d;
        if (localGuessPictureQuestionInfo.reward_type.has()) {
          paramGameQuestionInfo = localGuessPictureQuestionInfo.reward_type.get();
        } else {
          paramGameQuestionInfo = "";
        }
        localObject2[0] = paramGameQuestionInfo;
        localObject2 = this.d;
        if (localGuessPictureQuestionInfo.extra_reward.has()) {
          paramGameQuestionInfo = localGuessPictureQuestionInfo.extra_reward.get();
        } else {
          paramGameQuestionInfo = "";
        }
        localObject2[1] = paramGameQuestionInfo;
        localObject2 = this.d;
        paramGameQuestionInfo = (AvGameCommon.GameQuestionInfo)localObject1;
        if (localGuessPictureQuestionInfo.reward_stroke_color.has()) {
          paramGameQuestionInfo = localGuessPictureQuestionInfo.reward_stroke_color.get();
        }
        localObject2[2] = paramGameQuestionInfo;
        paramGameQuestionInfo = localGuessPictureQuestionInfo.tip_list.get();
        if (paramGameQuestionInfo != null)
        {
          paramGameQuestionInfo = paramGameQuestionInfo.iterator();
          while (paramGameQuestionInfo.hasNext())
          {
            localObject1 = (AvGameCommon.GuessPictureTipsInfo)paramGameQuestionInfo.next();
            localObject1 = new Pair(Integer.valueOf(((AvGameCommon.GuessPictureTipsInfo)localObject1).show_delay_ts.get()), ((AvGameCommon.GuessPictureTipsInfo)localObject1).tips.get());
            this.k.add(localObject1);
          }
        }
      }
    }
    else {
      super.a(paramGameQuestionInfo);
    }
  }
  
  public int b()
  {
    return 2;
  }
  
  protected TopicBase n()
  {
    return new TopicMosaicGuess();
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(o());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.data.TopicMosaicGuess
 * JD-Core Version:    0.7.0.1
 */