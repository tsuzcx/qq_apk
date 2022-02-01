import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.emoticonview.relateemo.RelatedEmoticonManager.RelatedEmotionSearchResult;

public class aocq
  implements BusinessObserver
{
  public static final String TAG = "FavEmoRoamingObserver";
  
  protected void onSearchRelatedEmoError(int paramInt) {}
  
  protected void onSearchRelatedEmoResponse(RelatedEmoticonManager.RelatedEmotionSearchResult paramRelatedEmotionSearchResult) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      if ((paramBoolean) && (paramObject != null))
      {
        onSearchRelatedEmoResponse((RelatedEmoticonManager.RelatedEmotionSearchResult)paramObject);
        return;
      }
    } while (!(paramObject instanceof Integer));
    onSearchRelatedEmoError(((Integer)paramObject).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aocq
 * JD-Core Version:    0.7.0.1
 */