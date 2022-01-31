import android.view.View;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;

public class aoos
  implements bfpt
{
  public aoos(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (FileInfo)this.a.b.get(paramInt);
    if (paramAdapterView.c()) {
      LocalFileBrowserActivity.a(this.a, paramAdapterView.c(), true);
    }
    while (!this.a.f()) {
      return;
    }
    if (apel.a(paramAdapterView)) {
      apel.b(paramAdapterView);
    }
    for (;;)
    {
      this.a.l();
      LocalFileBrowserActivity.a(this.a);
      return;
      if (this.a.f) {
        apel.b();
      }
      apel.a(paramAdapterView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoos
 * JD-Core Version:    0.7.0.1
 */