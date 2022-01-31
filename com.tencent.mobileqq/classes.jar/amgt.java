import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.colornote.data.ColorNote;
import mqq.app.AppRuntime;

public class amgt
{
  private amgo a;
  
  private static SharedPreferences a()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    str = "color_note_recent_view_switch" + str;
    return BaseApplicationImpl.getApplication().getSharedPreferences(str, 4);
  }
  
  public static void a(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null)
    {
      localSharedPreferences.edit().putBoolean("color_note_recently_viewed_switch", paramBoolean).apply();
      if (!paramBoolean) {
        amkf.a(BaseApplicationImpl.getContext(), 5, false);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteRecentView", 0, "setRecentColorNoteSwitch: " + paramBoolean);
      }
    }
  }
  
  public static boolean a()
  {
    boolean bool = true;
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      bool = localSharedPreferences.getBoolean("color_note_recently_viewed_switch", true);
    }
    return bool;
  }
  
  public static boolean b()
  {
    SharedPreferences localSharedPreferences = a();
    if ((localSharedPreferences != null) && (!localSharedPreferences.getBoolean("color_note_recent_first_visit", false)))
    {
      localSharedPreferences.edit().putBoolean("color_note_recent_first_visit", true).apply();
      return true;
    }
    return false;
  }
  
  public void a(amgo paramamgo)
  {
    this.a = paramamgo;
  }
  
  public void a(ColorNote paramColorNote)
  {
    Object localObject = amhg.a();
    if ((localObject != null) && (((amhf)localObject).a())) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (paramColorNote != null) && (this.a != null) && (amhj.a().a()))
      {
        localObject = amhh.a(paramColorNote);
        this.a.b((ColorNote)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("ColorNoteRecentView", 0, "updateRecentNote: " + paramColorNote.toString());
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amgt
 * JD-Core Version:    0.7.0.1
 */