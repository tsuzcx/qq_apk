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
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.io.File;

public class atcx
{
  public static final View.OnTouchListener a = new atcy();
  
  public static Dialog a(Context paramContext)
  {
    Object localObject3 = null;
    View localView1 = LayoutInflater.from(paramContext).inflate(2131561202, null);
    View localView2 = localView1.findViewById(2131374840);
    View localView3 = localView1.findViewById(2131363801);
    ImageView localImageView = (ImageView)localView1.findViewById(2131374844);
    localView2.setOnTouchListener(a);
    localView3.setOnTouchListener(a);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(agej.a(320.0F, paramContext.getResources()), -2);
    String str = atcj.a("expand_question_dialog.png");
    Object localObject1 = localObject3;
    if (new File(str).exists()) {}
    try
    {
      localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inPreferredConfig = Bitmap.Config.RGB_565;
      localObject1 = atcj.a(str, (BitmapFactory.Options)localObject1);
      localImageView.setImageBitmap((Bitmap)localObject1);
      localObject1 = new ReportDialog(paramContext, 2131755266);
      ((Dialog)localObject1).addContentView(localView1, localLayoutParams);
      ((Dialog)localObject1).setCanceledOnTouchOutside(false);
      localView2.setOnClickListener(new atcz(paramContext, (Dialog)localObject1));
      localView3.setOnClickListener(new atda((Dialog)localObject1));
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
    Object localObject1 = LayoutInflater.from(paramContext).inflate(2131561201, null);
    Object localObject3 = ((View)localObject1).findViewById(2131363801);
    ((View)localObject3).setOnTouchListener(a);
    ((View)localObject3).setOnClickListener(paramOnClickListener);
    ImageView localImageView = (ImageView)((View)localObject1).findViewById(2131368521);
    TextView localTextView = (TextView)((View)localObject1).findViewById(2131380285);
    Button localButton = (Button)((View)localObject1).findViewById(2131363874);
    localButton.setOnClickListener(paramOnClickListener);
    paramOnClickListener = new ViewGroup.LayoutParams(agej.a(320.0F, paramContext.getResources()), -2);
    ReportDialog localReportDialog = new ReportDialog(paramContext, 2131755266);
    localReportDialog.addContentView((View)localObject1, paramOnClickListener);
    localReportDialog.setCanceledOnTouchOutside(false);
    int i;
    switch (paramInt)
    {
    default: 
      localObject1 = atcj.a("expand_guide_profile.png");
      paramOnClickListener = anzj.a(2131707367);
      localObject3 = anzj.a(2131707366);
      i = agej.a(163.0F, paramContext.getResources());
      paramInt = agej.a(102.0F, paramContext.getResources());
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
        localObject1 = atcj.a((String)localObject1, (BitmapFactory.Options)localObject3);
        localImageView.setImageBitmap((Bitmap)localObject1);
        localTextView.setText(paramOnClickListener);
        localButton.setText(paramContext);
        paramContext = localImageView.getLayoutParams();
        paramContext.width = i;
        paramContext.height = paramInt;
        localImageView.setLayoutParams(paramContext);
        return localReportDialog;
      }
      catch (Exception localException)
      {
        QLog.e("ProfileGuideDialogUtils", 1, "showFirstGuide decode bitmap fail.", localException);
      }
      localObject1 = atcj.a("expand_guide_switch.png");
      paramOnClickListener = anzj.a(2131707368);
      localObject3 = anzj.a(2131707369);
      i = agej.a(180.0F, paramContext.getResources());
      paramInt = agej.a(102.0F, paramContext.getResources());
      paramContext = (Context)localObject3;
      break;
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atcx
 * JD-Core Version:    0.7.0.1
 */