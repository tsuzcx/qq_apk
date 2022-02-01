package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.question.bean.QuestionSquareBean;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;

class ReadInJoyEngineModule$9
  implements IFindRemovedEntity<QuestionSquareBean>
{
  ReadInJoyEngineModule$9(ReadInJoyEngineModule paramReadInJoyEngineModule) {}
  
  public Entity a(EntityManager paramEntityManager, QuestionSquareBean paramQuestionSquareBean)
  {
    paramEntityManager = null;
    if (this.a.a.tabbleIsExist(QuestionSquareBean.class.getSimpleName())) {
      paramEntityManager = this.a.a.find(QuestionSquareBean.class, "uin = ? and rowKey = ?", new String[] { paramQuestionSquareBean.uin, paramQuestionSquareBean.rowKey });
    }
    return paramEntityManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyEngineModule.9
 * JD-Core Version:    0.7.0.1
 */