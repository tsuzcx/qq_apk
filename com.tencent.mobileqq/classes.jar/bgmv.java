import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public class bgmv
  extends Dialog
{
  public bgmv(Context paramContext, String paramString)
  {
    super(paramContext, 2131755794);
    a(paramContext, paramString);
  }
  
  @TargetApi(14)
  private void a(Context paramContext, String paramString)
  {
    super.requestWindowFeature(1);
    Object localObject1 = LayoutInflater.from(paramContext);
    View localView = ((LayoutInflater)localObject1).inflate(2131558877, null);
    try
    {
      Object localObject2 = ((LayoutInflater)localObject1).inflate(2131561453, (ViewGroup)localView, false);
      localObject1 = (RelativeLayout)localView.findViewById(2131377452);
      Object localObject3 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject3).addRule(3, 2131375329);
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = (TextView)localView.findViewById(2131368429);
      IphoneTitleBarActivity.setLayerType((View)localObject2);
      if (localObject2 != null) {
        ((TextView)localObject2).setText(ajya.a(2131708291));
      }
      localObject3 = (TextView)localView.findViewById(2131368472);
      IphoneTitleBarActivity.setLayerType((View)localObject2);
      if (localObject3 != null) {
        ((TextView)localObject3).setText(paramString);
      }
      super.setContentView((View)localObject1);
      paramString = getWindow();
      localObject1 = paramString.getAttributes();
      ((WindowManager.LayoutParams)localObject1).width = -1;
      ((WindowManager.LayoutParams)localObject1).height = -1;
      paramString.setAttributes((WindowManager.LayoutParams)localObject1);
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        paramString.addFlags(67108864);
        new SystemBarCompact(this, true, paramContext.getResources().getColor(2131166910)).init();
        localView.setFitsSystemWindows(true);
        localView.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramContext), 0, 0);
      }
      return;
    }
    catch (InflateException paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQWIFIPluginLoadDialog", 2, "layout with merge ,use framelayout to immersive");
      }
      super.setContentView(2131561453);
      getWindow().setFeatureInt(7, 2131558875);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgmv
 * JD-Core Version:    0.7.0.1
 */