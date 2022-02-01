package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.QueryCallback;
import java.util.Iterator;
import java.util.List;

class EmosmActivity$9
  implements QueryCallback<List<EmoticonPackage>>
{
  EmosmActivity$9(EmosmActivity paramEmosmActivity) {}
  
  public void a(List<EmoticonPackage> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)paramList.next();
        if ((3 == localEmoticonPackage.jobType) || (5 == localEmoticonPackage.jobType)) {
          this.a.hasMagic = true;
        }
      }
      if (!this.a.hasMagic) {
        this.a.emosmMagicCon.setVisibility(8);
      }
      return;
    }
    this.a.emosmMagicCon.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EmosmActivity.9
 * JD-Core Version:    0.7.0.1
 */