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
  public AVRes a;
  public ArrayList<Pair<Integer, String>> a;
  List<TopicBase> a;
  protected int b;
  public AVRes b;
  public ArrayList<AVRes> b;
  public boolean b;
  public int c;
  public String c;
  public ArrayList<String> c;
  public int d;
  public int e;
  public int f;
  
  public TopicBase()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataAVRes = new AVRes();
    this.jdField_b_of_type_ComTencentAvgameGamelogicDataAVRes = new AVRes();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public ITopic a()
  {
    TopicBase localTopicBase = a();
    try
    {
      localTopicBase.a(this);
      return localTopicBase;
    }
    catch (Exception localException) {}
    return localTopicBase;
  }
  
  public AVRes a(int paramInt)
  {
    if (this.jdField_b_of_type_JavaUtilArrayList.size() > paramInt) {
      return (AVRes)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  protected abstract TopicBase a();
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataAVRes.jdField_c_of_type_JavaLangString;
  }
  
  public List<TopicBase> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  protected void a(TopicBase paramTopicBase)
  {
    this.jdField_a_of_type_Boolean = paramTopicBase.jdField_a_of_type_Boolean;
    this.jdField_b_of_type_Int = paramTopicBase.jdField_b_of_type_Int;
    this.jdField_a_of_type_Int = paramTopicBase.jdField_a_of_type_Int;
    this.jdField_a_of_type_JavaLangString = paramTopicBase.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramTopicBase.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramTopicBase.jdField_a_of_type_ArrayOfJavaLangString;
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataAVRes.a(paramTopicBase.jdField_a_of_type_ComTencentAvgameGamelogicDataAVRes);
    this.jdField_b_of_type_ComTencentAvgameGamelogicDataAVRes.a(paramTopicBase.jdField_b_of_type_ComTencentAvgameGamelogicDataAVRes);
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramTopicBase.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_b_of_type_JavaUtilArrayList.addAll(paramTopicBase.jdField_b_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_JavaUtilList.addAll(paramTopicBase.jdField_a_of_type_JavaUtilList);
    this.jdField_c_of_type_Int = paramTopicBase.jdField_c_of_type_Int;
    ArrayList localArrayList = paramTopicBase.jdField_c_of_type_JavaUtilArrayList;
    if (localArrayList != null) {
      this.jdField_c_of_type_JavaUtilArrayList = new ArrayList(localArrayList);
    }
    this.e = paramTopicBase.e;
    this.d = paramTopicBase.d;
    this.jdField_b_of_type_Boolean = paramTopicBase.jdField_b_of_type_Boolean;
    this.jdField_c_of_type_JavaLangString = paramTopicBase.jdField_c_of_type_JavaLangString;
    this.f = paramTopicBase.f;
  }
  
  protected void a(AvGameCommon.CommonQuestionInfo paramCommonQuestionInfo)
  {
    Object localObject1 = (AvGameCommon.QuestionItemInfo)paramCommonQuestionInfo.item.get();
    if (localObject1 != null)
    {
      this.jdField_a_of_type_ComTencentAvgameGamelogicDataAVRes.a(((AvGameCommon.QuestionItemInfo)localObject1).question_content.get(), ((AvGameCommon.QuestionItemInfo)localObject1).question_md5.get(), ((AvGameCommon.QuestionItemInfo)localObject1).question_duration.get(), ((AvGameCommon.QuestionItemInfo)localObject1).question_url.get());
      this.jdField_b_of_type_ComTencentAvgameGamelogicDataAVRes.a(((AvGameCommon.QuestionItemInfo)localObject1).answer_content.get(), ((AvGameCommon.QuestionItemInfo)localObject1).answer_md5.get(), ((AvGameCommon.QuestionItemInfo)localObject1).answer_duration.get(), "");
      this.jdField_a_of_type_ArrayOfJavaLangString[0] = ((AvGameCommon.QuestionItemInfo)localObject1).reward_type.get();
      this.jdField_a_of_type_ArrayOfJavaLangString[1] = ((AvGameCommon.QuestionItemInfo)localObject1).extra_reward.get();
      this.jdField_a_of_type_ArrayOfJavaLangString[2] = ((AvGameCommon.QuestionItemInfo)localObject1).reward_stroke_color.get();
      if (((AvGameCommon.QuestionItemInfo)localObject1).answer_option.has()) {
        this.jdField_c_of_type_JavaUtilArrayList = new ArrayList(((AvGameCommon.QuestionItemInfo)localObject1).answer_option.get());
      }
      this.d = ((AvGameCommon.QuestionItemInfo)localObject1).answer_index.get();
      this.jdField_b_of_type_Boolean = ((AvGameCommon.QuestionItemInfo)localObject1).business_flag.get();
      this.jdField_c_of_type_JavaLangString = ((AvGameCommon.QuestionItemInfo)localObject1).business_ads.get();
      this.f = ((AvGameCommon.QuestionItemInfo)localObject1).prize_id.get();
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
        this.jdField_b_of_type_JavaUtilArrayList.add(localAVRes);
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
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
      }
    }
    this.jdField_c_of_type_Int = paramCommonQuestionInfo.size.get();
    this.e = paramCommonQuestionInfo.score.get();
  }
  
  public void a(AvGameCommon.GameQuestionInfo paramGameQuestionInfo)
  {
    this.jdField_a_of_type_Int = paramGameQuestionInfo.id.get();
    this.jdField_b_of_type_Int = Math.max(0, paramGameQuestionInfo.index.get() - 1);
    if (paramGameQuestionInfo.questions.get() != null)
    {
      paramGameQuestionInfo = paramGameQuestionInfo.questions.get().iterator();
      while (paramGameQuestionInfo.hasNext())
      {
        AvGameCommon.CommonQuestionInfo localCommonQuestionInfo = (AvGameCommon.CommonQuestionInfo)paramGameQuestionInfo.next();
        TopicBase localTopicBase = a();
        localTopicBase.a(localCommonQuestionInfo);
        localTopicBase.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
        localTopicBase.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        localTopicBase.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_JavaUtilList.add(localTopicBase);
      }
    }
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      a((TopicBase)this.jdField_a_of_type_JavaUtilList.get(0));
    }
  }
  
  public boolean a(ITopic paramITopic)
  {
    boolean bool2 = false;
    if (paramITopic == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (Utils.a(c(), paramITopic.c()))
    {
      bool1 = bool2;
      if (Utils.a(b(), paramITopic.b())) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  @Nullable
  public String b()
  {
    return this.jdField_b_of_type_ComTencentAvgameGamelogicDataAVRes.jdField_a_of_type_JavaLangString;
  }
  
  public List<String> b()
  {
    return this.jdField_c_of_type_JavaUtilArrayList;
  }
  
  public int c()
  {
    AVRes localAVRes = this.jdField_a_of_type_ComTencentAvgameGamelogicDataAVRes;
    if (localAVRes == null) {
      return 0;
    }
    return localAVRes.jdField_a_of_type_Int;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataAVRes.jdField_a_of_type_JavaLangString;
  }
  
  public int c_()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public String d()
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    if (this.jdField_a_of_type_Boolean)
    {
      localStringBuilder.append("\n【题库】:");
      localStringBuilder.append("topicsCount");
      localStringBuilder.append("=");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilList.size());
      localStringBuilder.append("|");
      localStringBuilder.append("【题目列表】");
      localStringBuilder.append("=");
      localStringBuilder.append(Arrays.toString(this.jdField_a_of_type_JavaUtilList.toArray()));
      localStringBuilder.append("|");
    }
    else
    {
      localStringBuilder.append("\n【题目】:");
      localStringBuilder.append("id");
      localStringBuilder.append("=");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append("|");
      localStringBuilder.append("gameType");
      localStringBuilder.append("=");
      localStringBuilder.append(b());
      localStringBuilder.append("|");
      localStringBuilder.append("index");
      localStringBuilder.append("=");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append("|");
      localStringBuilder.append("contentRes");
      localStringBuilder.append("=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvgameGamelogicDataAVRes);
      localStringBuilder.append("|");
      localStringBuilder.append("answerRes");
      localStringBuilder.append("=");
      localStringBuilder.append(this.jdField_b_of_type_ComTencentAvgameGamelogicDataAVRes);
      localStringBuilder.append("|");
      localStringBuilder.append("tips");
      localStringBuilder.append("=");
      localStringBuilder.append(GameUtil.a(this.jdField_a_of_type_JavaUtilArrayList));
      localStringBuilder.append("|");
      localStringBuilder.append("feedBacks");
      localStringBuilder.append("=");
      localStringBuilder.append(Arrays.toString(this.jdField_b_of_type_JavaUtilArrayList.toArray()));
      localStringBuilder.append("|");
      localStringBuilder.append("answerOptionForClick=");
      localStringBuilder.append(this.jdField_c_of_type_JavaUtilArrayList);
      localStringBuilder.append("|");
      localStringBuilder.append("answerScoreForClick=");
      localStringBuilder.append(this.e);
      localStringBuilder.append("|");
      localStringBuilder.append("isBusinessFlag=");
      localStringBuilder.append(this.jdField_b_of_type_Boolean);
      localStringBuilder.append("|");
      localStringBuilder.append("businessAdsTips=");
      localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
      localStringBuilder.append("|");
      localStringBuilder.append("prizeId=");
      localStringBuilder.append(this.f);
      localStringBuilder.append("|");
      localStringBuilder.append("answerIndexForClick=");
      localStringBuilder.append(this.d);
      localStringBuilder.append("|");
    }
    return localStringBuilder.toString();
  }
  
  public int e()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.data.TopicBase
 * JD-Core Version:    0.7.0.1
 */