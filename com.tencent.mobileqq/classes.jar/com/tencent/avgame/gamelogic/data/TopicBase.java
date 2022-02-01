package com.tencent.avgame.gamelogic.data;

import androidx.annotation.Nullable;
import com.tencent.avgame.gamelogic.GameUtil;
import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.gamelogic.Indexable;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.util.Utils;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import trpc.qq_vgame.common.AvGameCommon.CommonQuestionInfo;
import trpc.qq_vgame.common.AvGameCommon.GameQuestionInfo;
import trpc.qq_vgame.common.AvGameCommon.QuestionFeedbackInfo;
import trpc.qq_vgame.common.AvGameCommon.QuestionItemInfo;
import trpc.qq_vgame.common.AvGameCommon.QuestionTipsInfo;

public abstract class TopicBase
  extends Topic
  implements Indexable
{
  List<TopicBase> g = new ArrayList();
  protected int h = 0;
  public AVRes i = new AVRes();
  public AVRes j = new AVRes();
  public ArrayList<Pair<Integer, String>> k = new ArrayList();
  public ArrayList<AVRes> l = new ArrayList();
  public int m;
  public ArrayList<String> n;
  public int o;
  public int p;
  public boolean q;
  public String r;
  public int s;
  
  public AVRes a(int paramInt)
  {
    if (this.l.size() > paramInt) {
      return (AVRes)this.l.get(paramInt);
    }
    return null;
  }
  
  protected void a(TopicBase paramTopicBase)
  {
    this.f = paramTopicBase.f;
    this.h = paramTopicBase.h;
    this.a = paramTopicBase.a;
    this.b = paramTopicBase.b;
    this.c = paramTopicBase.c;
    this.d = paramTopicBase.d;
    this.i.a(paramTopicBase.i);
    this.j.a(paramTopicBase.j);
    this.k.addAll(paramTopicBase.k);
    this.l.addAll(paramTopicBase.l);
    this.g.addAll(paramTopicBase.g);
    this.m = paramTopicBase.m;
    ArrayList localArrayList = paramTopicBase.n;
    if (localArrayList != null) {
      this.n = new ArrayList(localArrayList);
    }
    this.p = paramTopicBase.p;
    this.o = paramTopicBase.o;
    this.q = paramTopicBase.q;
    this.r = paramTopicBase.r;
    this.s = paramTopicBase.s;
  }
  
  protected void a(AvGameCommon.CommonQuestionInfo paramCommonQuestionInfo)
  {
    Object localObject1 = (AvGameCommon.QuestionItemInfo)paramCommonQuestionInfo.item.get();
    if (localObject1 != null)
    {
      this.i.a(((AvGameCommon.QuestionItemInfo)localObject1).question_content.get(), ((AvGameCommon.QuestionItemInfo)localObject1).question_md5.get(), ((AvGameCommon.QuestionItemInfo)localObject1).question_duration.get(), ((AvGameCommon.QuestionItemInfo)localObject1).question_url.get());
      this.j.a(((AvGameCommon.QuestionItemInfo)localObject1).answer_content.get(), ((AvGameCommon.QuestionItemInfo)localObject1).answer_md5.get(), ((AvGameCommon.QuestionItemInfo)localObject1).answer_duration.get(), "");
      this.d[0] = ((AvGameCommon.QuestionItemInfo)localObject1).reward_type.get();
      this.d[1] = ((AvGameCommon.QuestionItemInfo)localObject1).extra_reward.get();
      this.d[2] = ((AvGameCommon.QuestionItemInfo)localObject1).reward_stroke_color.get();
      if (((AvGameCommon.QuestionItemInfo)localObject1).answer_option.has()) {
        this.n = new ArrayList(((AvGameCommon.QuestionItemInfo)localObject1).answer_option.get());
      }
      this.o = ((AvGameCommon.QuestionItemInfo)localObject1).answer_index.get();
      this.q = ((AvGameCommon.QuestionItemInfo)localObject1).business_flag.get();
      this.r = ((AvGameCommon.QuestionItemInfo)localObject1).business_ads.get();
      this.s = ((AvGameCommon.QuestionItemInfo)localObject1).prize_id.get();
    }
    localObject1 = paramCommonQuestionInfo.feedbacks.get();
    Object localObject2;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AvGameCommon.QuestionFeedbackInfo)((Iterator)localObject1).next();
        AVRes localAVRes = new AVRes();
        localAVRes.a((AvGameCommon.QuestionFeedbackInfo)localObject2);
        this.l.add(localAVRes);
      }
    }
    localObject1 = paramCommonQuestionInfo.tips.get();
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AvGameCommon.QuestionTipsInfo)((Iterator)localObject1).next();
        localObject2 = new Pair(Integer.valueOf(((AvGameCommon.QuestionTipsInfo)localObject2).show_delay_ts.get()), ((AvGameCommon.QuestionTipsInfo)localObject2).tips.get());
        this.k.add(localObject2);
      }
    }
    this.m = paramCommonQuestionInfo.size.get();
    this.p = paramCommonQuestionInfo.score.get();
  }
  
  public void a(AvGameCommon.GameQuestionInfo paramGameQuestionInfo)
  {
    this.a = paramGameQuestionInfo.id.get();
    this.h = Math.max(0, paramGameQuestionInfo.index.get() - 1);
    if (paramGameQuestionInfo.questions.get() != null)
    {
      paramGameQuestionInfo = paramGameQuestionInfo.questions.get().iterator();
      while (paramGameQuestionInfo.hasNext())
      {
        AvGameCommon.CommonQuestionInfo localCommonQuestionInfo = (AvGameCommon.CommonQuestionInfo)paramGameQuestionInfo.next();
        TopicBase localTopicBase = n();
        localTopicBase.a(localCommonQuestionInfo);
        localTopicBase.h = this.h;
        localTopicBase.a = this.a;
        localTopicBase.f = false;
        this.g.add(localTopicBase);
      }
    }
    if ((!this.f) && (this.g.size() > 0)) {
      a((TopicBase)this.g.get(0));
    }
  }
  
  public boolean a(ITopic paramITopic)
  {
    boolean bool2 = false;
    if (paramITopic == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (Utils.a(e(), paramITopic.e()))
    {
      bool1 = bool2;
      if (Utils.a(d(), paramITopic.d())) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int aC_()
  {
    return this.h;
  }
  
  public String c()
  {
    return this.i.d;
  }
  
  @Nullable
  public String d()
  {
    return this.j.a;
  }
  
  public String e()
  {
    return this.i.a;
  }
  
  public int f()
  {
    AVRes localAVRes = this.i;
    if (localAVRes == null) {
      return 0;
    }
    return localAVRes.c;
  }
  
  public List<TopicBase> i()
  {
    return this.g;
  }
  
  public ITopic j()
  {
    TopicBase localTopicBase = n();
    try
    {
      localTopicBase.a(this);
      return localTopicBase;
    }
    catch (Exception localException) {}
    return localTopicBase;
  }
  
  public List<String> k()
  {
    return this.n;
  }
  
  public int l()
  {
    return this.o;
  }
  
  public int m()
  {
    return this.p;
  }
  
  protected abstract TopicBase n();
  
  public String o()
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    if (this.f)
    {
      localStringBuilder.append("\n【题库】:");
      localStringBuilder.append("topicsCount");
      localStringBuilder.append("=");
      localStringBuilder.append(this.g.size());
      localStringBuilder.append("|");
      localStringBuilder.append("【题目列表】");
      localStringBuilder.append("=");
      localStringBuilder.append(Arrays.toString(this.g.toArray()));
      localStringBuilder.append("|");
    }
    else
    {
      localStringBuilder.append("\n【题目】:");
      localStringBuilder.append("id");
      localStringBuilder.append("=");
      localStringBuilder.append(this.a);
      localStringBuilder.append("|");
      localStringBuilder.append("gameType");
      localStringBuilder.append("=");
      localStringBuilder.append(b());
      localStringBuilder.append("|");
      localStringBuilder.append("index");
      localStringBuilder.append("=");
      localStringBuilder.append(this.h);
      localStringBuilder.append("|");
      localStringBuilder.append("contentRes");
      localStringBuilder.append("=");
      localStringBuilder.append(this.i);
      localStringBuilder.append("|");
      localStringBuilder.append("answerRes");
      localStringBuilder.append("=");
      localStringBuilder.append(this.j);
      localStringBuilder.append("|");
      localStringBuilder.append("tips");
      localStringBuilder.append("=");
      localStringBuilder.append(GameUtil.a(this.k));
      localStringBuilder.append("|");
      localStringBuilder.append("feedBacks");
      localStringBuilder.append("=");
      localStringBuilder.append(Arrays.toString(this.l.toArray()));
      localStringBuilder.append("|");
      localStringBuilder.append("answerOptionForClick=");
      localStringBuilder.append(this.n);
      localStringBuilder.append("|");
      localStringBuilder.append("answerScoreForClick=");
      localStringBuilder.append(this.p);
      localStringBuilder.append("|");
      localStringBuilder.append("isBusinessFlag=");
      localStringBuilder.append(this.q);
      localStringBuilder.append("|");
      localStringBuilder.append("businessAdsTips=");
      localStringBuilder.append(this.r);
      localStringBuilder.append("|");
      localStringBuilder.append("prizeId=");
      localStringBuilder.append(this.s);
      localStringBuilder.append("|");
      localStringBuilder.append("answerIndexForClick=");
      localStringBuilder.append(this.o);
      localStringBuilder.append("|");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.data.TopicBase
 * JD-Core Version:    0.7.0.1
 */