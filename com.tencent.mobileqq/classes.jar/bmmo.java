import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qqfav.widget.LocationDetailActivity;
import java.lang.ref.WeakReference;

public class bmmo
  extends bmmh
{
  private WeakReference<LocationDetailActivity> a;
  
  public bmmo(LocationDetailActivity paramLocationDetailActivity)
  {
    this.a = new WeakReference(paramLocationDetailActivity);
  }
  
  public int a()
  {
    LocationDetailActivity localLocationDetailActivity = (LocationDetailActivity)this.a.get();
    if (localLocationDetailActivity == null) {
      return 0;
    }
    return LocationDetailActivity.a(localLocationDetailActivity);
  }
  
  public void a()
  {
    LocationDetailActivity localLocationDetailActivity = (LocationDetailActivity)this.a.get();
    if (localLocationDetailActivity == null) {
      return;
    }
    localLocationDetailActivity.b(true);
    bmky.a(null, "User_Modify", 7, 0, localLocationDetailActivity.getIntent().getIntExtra("category", 1));
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    LocationDetailActivity localLocationDetailActivity = (LocationDetailActivity)this.a.get();
    if (localLocationDetailActivity == null) {
      return;
    }
    localLocationDetailActivity.a(paramBundle);
  }
  
  public void b()
  {
    LocationDetailActivity localLocationDetailActivity = (LocationDetailActivity)this.a.get();
    if (localLocationDetailActivity == null) {
      return;
    }
    LocationDetailActivity.a(localLocationDetailActivity);
  }
  
  public void c()
  {
    LocationDetailActivity localLocationDetailActivity = (LocationDetailActivity)this.a.get();
    if (localLocationDetailActivity == null) {}
    while (!localLocationDetailActivity.d()) {
      return;
    }
    localLocationDetailActivity.finish();
  }
  
  public void d()
  {
    LocationDetailActivity localLocationDetailActivity = (LocationDetailActivity)this.a.get();
    if (localLocationDetailActivity == null) {
      return;
    }
    localLocationDetailActivity.A();
  }
  
  public void e()
  {
    LocationDetailActivity localLocationDetailActivity = (LocationDetailActivity)this.a.get();
    if (localLocationDetailActivity == null) {
      return;
    }
    Intent localIntent = LocationDetailActivity.a(localLocationDetailActivity);
    if (localIntent != null)
    {
      auxu.a(localLocationDetailActivity, localIntent, 103);
      return;
    }
    QQToast.a(localLocationDetailActivity, 2131692011, 1, 2000).b(5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmmo
 * JD-Core Version:    0.7.0.1
 */