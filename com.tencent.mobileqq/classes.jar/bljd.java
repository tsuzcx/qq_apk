import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel;

public class bljd
  implements SeekBar.OnSeekBarChangeListener
{
  public bljd(AEEditorFilterControlPanel paramAEEditorFilterControlPanel) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramSeekBar.getVisibility() == 0))
    {
      if (AEEditorFilterControlPanel.a(this.a) != null) {
        AEEditorFilterControlPanel.a(this.a).setText(paramInt + "%");
      }
      if (AEEditorFilterControlPanel.a(this.a) != null) {
        AEEditorFilterControlPanel.a(this.a).a(this.a.a(), paramInt / 100.0F);
      }
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    if (AEEditorFilterControlPanel.a(this.a) != null) {
      AEEditorFilterControlPanel.a(this.a).setVisibility(0);
    }
    if (AEEditorFilterControlPanel.a(this.a) != null) {
      AEEditorFilterControlPanel.a(this.a).k();
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (AEEditorFilterControlPanel.a(this.a) != null) {
      AEEditorFilterControlPanel.a(this.a).setVisibility(4);
    }
    if (AEEditorFilterControlPanel.a(this.a) != null) {
      AEEditorFilterControlPanel.a(this.a).l();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bljd
 * JD-Core Version:    0.7.0.1
 */