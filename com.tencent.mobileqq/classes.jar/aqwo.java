import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;

class aqwo
  implements aqvn
{
  aqwo(aqwl paramaqwl) {}
  
  public void a(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    if (Build.VERSION.SDK_INT >= 9)
    {
      localIntent.setAction(aqwl.a(this.a));
      localIntent.setData(Uri.fromParts("package", paramContext.getPackageName(), null));
    }
    for (;;)
    {
      paramContext.startActivity(localIntent);
      return;
      if (Build.VERSION.SDK_INT <= 8)
      {
        localIntent.setAction("android.intent.action.VIEW");
        localIntent.setClassName("com.android.settings", aqwl.a(this.a));
        localIntent.putExtra("com.android.settings.ApplicationPkgName", paramContext.getPackageName());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqwo
 * JD-Core Version:    0.7.0.1
 */