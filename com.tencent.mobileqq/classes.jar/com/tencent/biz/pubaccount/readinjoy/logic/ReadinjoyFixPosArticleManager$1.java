package com.tencent.biz.pubaccount.readinjoy.logic;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ptk;
import slt;

public class ReadinjoyFixPosArticleManager$1
  implements Runnable
{
  public ReadinjoyFixPosArticleManager$1(ptk paramptk, slt paramslt, int paramInt) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.jdField_a_of_type_Slt.a().iterator();
    while (((Iterator)localObject).hasNext())
    {
      BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)((Iterator)localObject).next();
      if (!ptk.a(localBaseArticleInfo.mRecommendSeq)) {
        localArrayList.add(localBaseArticleInfo);
      }
    }
    localObject = this.this$0.a(this.jdField_a_of_type_Int, localArrayList, localArrayList, 3);
    if (ptk.a(this.this$0, (List)localObject, localArrayList))
    {
      this.jdField_a_of_type_Slt.a((List)localObject);
      this.jdField_a_of_type_Slt.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.logic.ReadinjoyFixPosArticleManager.1
 * JD-Core Version:    0.7.0.1
 */