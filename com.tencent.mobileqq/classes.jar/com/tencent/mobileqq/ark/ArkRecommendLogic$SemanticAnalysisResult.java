package com.tencent.mobileqq.ark;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkContextInfo;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public abstract interface ArkRecommendLogic$SemanticAnalysisResult
{
  public abstract void a(ArkMessageServerLogic.SearchArkBabyQInfo paramSearchArkBabyQInfo, SessionInfo paramSessionInfo, boolean paramBoolean);
  
  public abstract void a(RecommendCommonMessage paramRecommendCommonMessage, ArkAiInfo paramArkAiInfo, RecommendCommonMessage.ArkContextInfo paramArkContextInfo, String paramString);
  
  public abstract void a(RecommendCommonMessage paramRecommendCommonMessage, ArkMessageServerLogic.ArkPassiveSearchInfo paramArkPassiveSearchInfo);
  
  public abstract void a(String paramString, LinkedHashMap paramLinkedHashMap, ArrayList paramArrayList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkRecommendLogic.SemanticAnalysisResult
 * JD-Core Version:    0.7.0.1
 */