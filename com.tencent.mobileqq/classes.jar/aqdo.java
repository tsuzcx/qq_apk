import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aqdo
{
  public static final View.OnTouchListener a = new aqdp();
  
  public static Dialog a(Context paramContext)
  {
    Object localObject3 = null;
    View localView1 = LayoutInflater.from(paramContext).inflate(2131560938, null);
    View localView2 = localView1.findViewById(2131373930);
    View localView3 = localView1.findViewById(2131363577);
    ImageView localImageView = (ImageView)localView1.findViewById(2131373934);
    localView2.setOnTouchListener(a);
    localView3.setOnTouchListener(a);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(aekt.a(320.0F, paramContext.getResources()), -2);
    String str = aqcy.a("expand_question_dialog.png");
    Object localObject1 = localObject3;
    if (new File(str).exists()) {}
    try
    {
      localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inPreferredConfig = Bitmap.Config.RGB_565;
      localObject1 = aqcy.a(str, (BitmapFactory.Options)localObject1);
      localImageView.setImageBitmap((Bitmap)localObject1);
      localObject1 = new Dialog(paramContext, 2131755259);
      ((Dialog)localObject1).addContentView(localView1, localLayoutParams);
      ((Dialog)localObject1).setCanceledOnTouchOutside(false);
      localView2.setOnClickListener(new aqdq(paramContext, (Dialog)localObject1));
      localView3.setOnClickListener(new aqdr((Dialog)localObject1));
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ProfileGuideDialogUtils", 1, "createQuestionDialog decode bitmap fail.", localException);
        Object localObject2 = localObject3;
      }
    }
  }
  
  public static Dialog a(Context paramContext, int paramInt, View.OnClickListener paramOnClickListener)
  {
    Object localObject1 = LayoutInflater.from(paramContext).inflate(2131560937, null);
    Object localObject3 = ((View)localObject1).findViewById(2131363577);
    ((View)localObject3).setOnTouchListener(a);
    ((View)localObject3).setOnClickListener(paramOnClickListener);
    ImageView localImageView = (ImageView)((View)localObject1).findViewById(2131368111);
    TextView localTextView = (TextView)((View)localObject1).findViewById(2131379119);
    Button localButton = (Button)((View)localObject1).findViewById(2131363644);
    localButton.setOnClickListener(paramOnClickListener);
    paramOnClickListener = new ViewGroup.LayoutParams(aekt.a(320.0F, paramContext.getResources()), -2);
    Dialog localDialog = new Dialog(paramContext, 2131755259);
    localDialog.addContentView((View)localObject1, paramOnClickListener);
    localDialog.setCanceledOnTouchOutside(false);
    int i;
    switch (paramInt)
    {
    default: 
      localObject1 = aqcy.a("expand_guide_profile.png");
      paramOnClickListener = alpo.a(2131708870);
      localObject3 = alpo.a(2131708869);
      i = aekt.a(163.0F, paramContext.getResources());
      paramInt = aekt.a(102.0F, paramContext.getResources());
      paramContext = (Context)localObject3;
      if (!new File((String)localObject1).exists()) {
        break;
      }
    }
    for (;;)
    {
      try
      {
        localObject3 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject3).inPreferredConfig = Bitmap.Config.RGB_565;
        localObject1 = aqcy.a((String)localObject1, (BitmapFactory.Options)localObject3);
        localImageView.setImageBitmap((Bitmap)localObject1);
        localTextView.setText(paramOnClickListener);
        localButton.setText(paramContext);
        paramContext = localImageView.getLayoutParams();
        paramContext.width = i;
        paramContext.height = paramInt;
        localImageView.setLayoutParams(paramContext);
        return localDialog;
      }
      catch (Exception localException)
      {
        QLog.e("ProfileGuideDialogUtils", 1, "showFirstGuide decode bitmap fail.", localException);
      }
      localObject1 = aqcy.a("expand_guide_switch.png");
      paramOnClickListener = alpo.a(2131708871);
      localObject3 = alpo.a(2131708872);
      i = aekt.a(180.0F, paramContext.getResources());
      paramInt = aekt.a(102.0F, paramContext.getResources());
      paramContext = (Context)localObject3;
      break;
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqdo
 * JD-Core Version:    0.7.0.1
 */