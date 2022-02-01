import android.view.View;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;

public class asrz
  implements bkij
{
  public asrz(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (FileInfo)this.a.b.get(paramInt);
    if (paramAdapterView.c()) {
      LocalFileBrowserActivity.a(this.a, paramAdapterView.c(), true);
    }
    while (!this.a.f()) {
      return;
    }
    if (athc.a(paramAdapterView)) {
      athc.b(paramAdapterView);
    }
    for (;;)
    {
      this.a.l();
      LocalFileBrowserActivity.a(this.a);
      return;
      if (this.a.h) {
        athc.b();
      }
      athc.a(paramAdapterView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asrz
 * JD-Core Version:    0.7.0.1
 */