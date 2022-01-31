import android.content.Intent;
import cooperation.qqfav.widget.LocationDetailActivity;
import java.lang.ref.WeakReference;

public class bgrd
  extends bgqw
{
  private WeakReference<LocationDetailActivity> a;
  
  public bgrd(LocationDetailActivity paramLocationDetailActivity)
  {
    this.a = new WeakReference(paramLocationDetailActivity);
  }
  
  public void a()
  {
    LocationDetailActivity localLocationDetailActivity = (LocationDetailActivity)this.a.get();
    if (localLocationDetailActivity == null) {
      return;
    }
    localLocationDetailActivity.b(true);
    bgpr.a(null, "User_Modify", 7, 0, localLocationDetailActivity.getIntent().getIntExtra("category", 1));
  }
  
  public void a(String paramString)
  {
    LocationDetailActivity localLocationDetailActivity = (LocationDetailActivity)this.a.get();
    if (localLocationDetailActivity == null) {}
    while (localLocationDetailActivity.getString(2131692982).compareTo(paramString) != 0) {
      return;
    }
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
    if ((localLocationDetailActivity == null) || (localLocationDetailActivity.a == null)) {}
    while (!localLocationDetailActivity.c()) {
      return;
    }
    int i;
    if (localLocationDetailActivity.e())
    {
      i = 256;
      if (!localLocationDetailActivity.e()) {
        break label98;
      }
    }
    label98:
    for (String str = localLocationDetailActivity.getString(2131698109);; str = localLocationDetailActivity.getString(2131698085))
    {
      if (!localLocationDetailActivity.a.a(Integer.valueOf(128))) {
        break label108;
      }
      localLocationDetailActivity.a.a(Integer.valueOf(128), Integer.valueOf(i), str);
      return;
      i = 128;
      break;
    }
    label108:
    localLocationDetailActivity.a.a(Integer.valueOf(256), Integer.valueOf(i), str);
  }
  
  public void f()
  {
    LocationDetailActivity localLocationDetailActivity = (LocationDetailActivity)this.a.get();
    if (localLocationDetailActivity == null) {
      return;
    }
    if ((localLocationDetailActivity.r != null) && (localLocationDetailActivity.s != null))
    {
      Intent localIntent = LocationDetailActivity.a(localLocationDetailActivity);
      localIntent.putExtra("forward_type", -2).putExtra("forward_latitude", localIntent.getStringExtra("latitude")).putExtra("forward_longitude", localIntent.getStringExtra("longitude")).putExtra("forward_location", localLocationDetailActivity.m).putExtra("forward_location_string", localLocationDetailActivity.m).putExtra("forward_thumb", ajsf.cb + localLocationDetailActivity.r + "_" + localLocationDetailActivity.s + ".png").putExtra("isFromFavorites", true).putExtra("title", localLocationDetailActivity.l).putExtra("summary", localLocationDetailActivity.m);
      aqbc.a(localLocationDetailActivity, localIntent, 103);
      return;
    }
    bcpw.a(localLocationDetailActivity, 2131692345, 1, 2000).b(5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgrd
 * JD-Core Version:    0.7.0.1
 */