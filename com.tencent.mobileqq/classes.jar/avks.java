import com.etrump.mixlayout.EMEmoticon;
import com.tencent.commonsdk.cache.QQLruCache;

public final class avks
  extends QQLruCache<String, EMEmoticon>
{
  public avks(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  protected void a(boolean paramBoolean, String paramString, EMEmoticon paramEMEmoticon1, EMEmoticon paramEMEmoticon2)
  {
    super.entryRemoved(paramBoolean, paramString, paramEMEmoticon1, paramEMEmoticon2);
    if (paramEMEmoticon1 != null) {
      paramEMEmoticon1.deleteDescriptor();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avks
 * JD-Core Version:    0.7.0.1
 */