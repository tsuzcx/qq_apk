import android.annotation.TargetApi;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;

public class atta
  implements atux
{
  public atta(FileBrowserActivity paramFileBrowserActivity) {}
  
  @TargetApi(14)
  public void a()
  {
    Object localObject = this.a.getResources().getConfiguration().toString();
    if ((((String)localObject).contains("hwMultiwindow-magic")) || (((String)localObject).contains("hw-magic-windows"))) {}
    for (int i = 1;; i = 0)
    {
      if ((ImmersiveUtils.isSupporImmersive() == 1) && (i == 0))
      {
        localObject = (RelativeLayout)this.a.findViewById(2131376948);
        ((RelativeLayout)localObject).setFitsSystemWindows(true);
        ((RelativeLayout)localObject).setPadding(0, ImmersiveUtils.getStatusBarHeight(this.a), 0, 0);
      }
      return;
    }
  }
  
  public void a(int paramInt)
  {
    FileBrowserActivity.a(this.a, (TextView)this.a.findViewById(2131369278));
    FileBrowserActivity.a(this.a).setTextSize(1, 19.0F);
    FileBrowserActivity.a(this.a).setText(this.a.a.a());
  }
  
  public void a(boolean paramBoolean)
  {
    FileBrowserActivity.a(this.a, paramBoolean);
    View localView = this.a.findViewById(2131376763);
    if (!FileBrowserActivity.a(this.a))
    {
      localView.setVisibility(0);
      if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.a.mSystemBarComp != null))
      {
        int i = this.a.getResources().getColor(2131167084);
        this.a.mSystemBarComp.setStatusColor(i);
        this.a.mSystemBarComp.setStatusBarColor(i);
        if (ThemeUtil.isDefaultOrDIYTheme(false)) {
          this.a.mSystemBarComp.setStatusBarDrawable(this.a.getResources().getDrawable(2130846157));
        }
      }
      LiuHaiUtils.b(this.a);
      this.a.getWindow().setFlags(0, 1024);
      return;
    }
    localView.setVisibility(4);
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.a.mSystemBarComp != null))
    {
      this.a.mSystemBarComp.setStatusColor(0);
      this.a.mSystemBarComp.setStatusBarColor(0);
      if (ThemeUtil.isDefaultOrDIYTheme(false)) {
        this.a.mSystemBarComp.setStatusBarDrawable(null);
      }
    }
    FileBrowserActivity.a(this.a, this.a.a.a());
    if ((FileBrowserActivity.a(this.a) != 2) && (FileBrowserActivity.a(this.a) != 0)) {
      LiuHaiUtils.c(this.a);
    }
    this.a.getWindow().setFlags(1024, 1024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atta
 * JD-Core Version:    0.7.0.1
 */