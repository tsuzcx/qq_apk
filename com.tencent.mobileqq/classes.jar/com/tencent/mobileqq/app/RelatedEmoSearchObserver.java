package com.tencent.mobileqq.app;

import com.tencent.mobileqq.emoticonview.relateemo.RelatedEmoticonManager.RelatedEmotionSearchResult;

public class RelatedEmoSearchObserver
  implements BusinessObserver
{
  public static final String TAG = "FavEmoRoamingObserver";
  
  protected void onSearchRelatedEmoError(int paramInt) {}
  
  protected void onSearchRelatedEmoResponse(RelatedEmoticonManager.RelatedEmotionSearchResult paramRelatedEmotionSearchResult) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 1) {
      return;
    }
    if ((paramBoolean) && (paramObject != null))
    {
      onSearchRelatedEmoResponse((RelatedEmoticonManager.RelatedEmotionSearchResult)paramObject);
      return;
    }
    if ((paramObject instanceof Integer)) {
      onSearchRelatedEmoError(((Integer)paramObject).intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.RelatedEmoSearchObserver
 * JD-Core Version:    0.7.0.1
 */