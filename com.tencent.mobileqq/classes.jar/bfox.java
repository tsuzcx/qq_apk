import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;

public abstract class bfox
{
  public static final int ITEM_TYPE_AUDIO = 2;
  public static final int ITEM_TYPE_MUSIC = 3;
  public static final int ITEM_TYPE_NONE = 0;
  public static final int ITEM_TYPE_PIC = 1;
  public static final int ITEM_TYPE_VIDEO = 4;
  protected static final String TAG = "publish_mediaInfo";
  
  public abstract String getJsonText();
  
  public abstract View getView(Context paramContext, View.OnClickListener paramOnClickListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfox
 * JD-Core Version:    0.7.0.1
 */