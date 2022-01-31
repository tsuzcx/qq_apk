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

public class aokw
{
  public static final View.OnTouchListener a = new aokx();
  
  public static Dialog a(Context paramContext)
  {
    Object localObject3 = null;
    View localView1 = LayoutInflater.from(paramContext).inflate(2131560757, null);
    View localView2 = localView1.findViewById(2131373478);
    View localView3 = localView1.findViewById(2131363534);
    ImageView localImageView = (ImageView)localView1.findViewById(2131373482);
    localView2.setOnTouchListener(a);
    localView3.setOnTouchListener(a);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(actj.a(320.0F, paramContext.getResources()), -2);
    String str = aokq.a("expand_question_dialog.png");
    Object localObject1 = localObject3;
    if (new File(str).exists()) {}
    try
    {
      localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inPreferredConfig = Bitmap.Config.RGB_565;
      localObject1 = aokq.a(str, (BitmapFactory.Options)localObject1);
      localImageView.setImageBitmap((Bitmap)localObject1);
      localObject1 = new Dialog(paramContext, 2131755255);
      ((Dialog)localObject1).addContentView(localView1, localLayoutParams);
      ((Dialog)localObject1).setCanceledOnTouchOutside(false);
      localView2.setOnClickListener(new aoky(paramContext, (Dialog)localObject1));
      localView3.setOnClickListener(new aokz((Dialog)localObject1));
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
    Object localObject1 = LayoutInflater.from(paramContext).inflate(2131560756, null);
    Object localObject3 = ((View)localObject1).findViewById(2131363534);
    ((View)localObject3).setOnTouchListener(a);
    ((View)localObject3).setOnClickListener(paramOnClickListener);
    ImageView localImageView = (ImageView)((View)localObject1).findViewById(2131367974);
    TextView localTextView = (TextView)((View)localObject1).findViewById(2131378507);
    Button localButton = (Button)((View)localObject1).findViewById(2131363599);
    localButton.setOnClickListener(paramOnClickListener);
    paramOnClickListener = new ViewGroup.LayoutParams(actj.a(320.0F, paramContext.getResources()), -2);
    Dialog localDialog = new Dialog(paramContext, 2131755255);
    localDialog.addContentView((View)localObject1, paramOnClickListener);
    localDialog.setCanceledOnTouchOutside(false);
    int i;
    switch (paramInt)
    {
    default: 
      localObject1 = aokq.a("expand_guide_profile.png");
      paramOnClickListener = ajya.a(2131708498);
      localObject3 = ajya.a(2131708497);
      i = actj.a(163.0F, paramContext.getResources());
      paramInt = actj.a(102.0F, paramContext.getResources());
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
        localObject1 = aokq.a((String)localObject1, (BitmapFactory.Options)localObject3);
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
      localObject1 = aokq.a("expand_guide_switch.png");
      paramOnClickListener = ajya.a(2131708499);
      localObject3 = ajya.a(2131708500);
      i = actj.a(180.0F, paramContext.getResources());
      paramInt = actj.a(102.0F, paramContext.getResources());
      paramContext = (Context)localObject3;
      break;
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aokw
 * JD-Core Version:    0.7.0.1
 */