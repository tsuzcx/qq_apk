import android.annotation.TargetApi;
import android.content.res.Resources;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public class apih
  implements apkr
{
  public apih(FileBrowserActivity paramFileBrowserActivity) {}
  
  @TargetApi(14)
  public void a()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)this.a.findViewById(2131375494);
      localRelativeLayout.setFitsSystemWindows(true);
      localRelativeLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(this.a), 0, 0);
    }
  }
  
  public void a(int paramInt)
  {
    FileBrowserActivity.a(this.a, (TextView)this.a.findViewById(2131368472));
    FileBrowserActivity.a(this.a).setTextSize(1, 19.0F);
    FileBrowserActivity.a(this.a).setText(this.a.a.a());
  }
  
  public void a(boolean paramBoolean)
  {
    FileBrowserActivity.a(this.a, paramBoolean);
    View localView = this.a.findViewById(2131375332);
    if (!FileBrowserActivity.a(this.a))
    {
      localView.setVisibility(0);
      if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.a.mSystemBarComp != null))
      {
        int i = this.a.getResources().getColor(2131166910);
        this.a.mSystemBarComp.setStatusColor(i);
        this.a.mSystemBarComp.setStatusBarColor(i);
        if (ThemeUtil.isDefaultOrDIYTheme(false)) {
          this.a.mSystemBarComp.setStatusBarDrawable(this.a.getResources().getDrawable(2130845305));
        }
      }
      this.a.getWindow().setFlags(0, 1024);
      return;
    }
    localView.setVisibility(8);
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.a.mSystemBarComp != null))
    {
      this.a.mSystemBarComp.setStatusColor(0);
      this.a.mSystemBarComp.setStatusBarColor(0);
      if (ThemeUtil.isDefaultOrDIYTheme(false)) {
        this.a.mSystemBarComp.setStatusBarDrawable(null);
      }
    }
    this.a.getWindow().setFlags(1024, 1024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apih
 * JD-Core Version:    0.7.0.1
 */