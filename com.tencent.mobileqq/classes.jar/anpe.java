import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import dov.com.tencent.mobileqq.activity.richmedia.EditVideoQzComment;

public class anpe
  implements CompoundButton.OnCheckedChangeListener
{
  public anpe(EditVideoQzComment paramEditVideoQzComment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    EditVideoQzComment.a(this.a).f = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anpe
 * JD-Core Version:    0.7.0.1
 */