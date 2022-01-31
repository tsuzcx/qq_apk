import android.graphics.Point;
import android.os.Bundle;
import com.tencent.mobileqq.colornote.data.ColorNote;

public class aobz
{
  public void onAddColorNote(Bundle paramBundle, boolean paramBoolean)
  {
    if (paramBundle != null)
    {
      int i = paramBundle.getInt("param_service_type");
      String str = paramBundle.getString("param_sub_type");
      if (paramBundle.getInt("param_extra", 1) != 2) {
        aoct.a().a(i, str, paramBoolean);
      }
      aoct.a().a(new Point(paramBundle.getInt("key_float_window_position_x"), paramBundle.getInt("key_float_window_position_y")));
    }
  }
  
  public void onDeleteColorNote(int paramInt, String paramString, boolean paramBoolean)
  {
    aoct.a().a(paramInt, paramString, paramBoolean);
  }
  
  public void onUpdateColorNote(ColorNote paramColorNote, boolean paramBoolean) {}
  
  public void onUpdateColorNoteState(int paramInt, String paramString, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      aoct.a().a(paramInt, paramString, paramBundle.getBoolean("extra_is_colornote_exists"));
      aoct.a().c(paramBundle.getBoolean("extra_can_add_colornote"));
      aoct.a().a(new Point(paramBundle.getInt("key_float_window_position_x"), paramBundle.getInt("key_float_window_position_y")));
      boolean bool = paramBundle.getBoolean("extra_after_sync_msg");
      aoct.a().b(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aobz
 * JD-Core Version:    0.7.0.1
 */