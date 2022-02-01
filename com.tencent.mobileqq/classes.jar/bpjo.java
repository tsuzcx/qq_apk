import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import dov.com.qq.im.aeeditor.module.text.AEEditorColorSelectorView;

public class bpjo
  extends LinearLayoutManager
{
  public bpjo(AEEditorColorSelectorView paramAEEditorColorSelectorView, Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramInt, paramBoolean);
  }
  
  public boolean canScrollHorizontally()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpjo
 * JD-Core Version:    0.7.0.1
 */