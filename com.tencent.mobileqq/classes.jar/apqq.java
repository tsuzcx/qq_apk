import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.download.ArkDownloadController.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class apqq
{
  private static apqq jdField_a_of_type_Apqq;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private bgpa jdField_a_of_type_Bgpa;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private ArrayList<apqt> jdField_a_of_type_JavaUtilArrayList = new ArrayList(4);
  private boolean jdField_a_of_type_Boolean;
  private ArrayList<apqt> b = new ArrayList(4);
  
  public static apqq a()
  {
    if (jdField_a_of_type_Apqq == null) {}
    try
    {
      if (jdField_a_of_type_Apqq == null) {
        jdField_a_of_type_Apqq = new apqq();
      }
      return jdField_a_of_type_Apqq;
    }
    finally {}
  }
  
  private void a(Context paramContext, ArrayList<apqt> paramArrayList, LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2)
  {
    if (paramArrayList.size() <= 4) {
      paramLinearLayout2.setVisibility(8);
    }
    Drawable localDrawable = paramContext.getResources().getDrawable(2130838647);
    int i = 0;
    if (i < paramArrayList.size())
    {
      Object localObject = (apqt)paramArrayList.get(i);
      View localView = LayoutInflater.from(paramContext).inflate(2131558693, null, false);
      URLImageView localURLImageView = (URLImageView)localView.findViewById(2131368140);
      TextView localTextView = (TextView)localView.findViewById(2131371885);
      QLog.d("ark.download.ctrl", 1, new Object[] { "ark.dctrl [initAppView] item[", Integer.valueOf(i), "],app name:", ((apqt)localObject).b, ",appid:", ((apqt)localObject).jdField_a_of_type_JavaLangString, ",icon:", ((apqt)localObject).c });
      if (i < 7)
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = afur.a(47.0F, paramContext.getResources());
        localURLDrawableOptions.mRequestHeight = localURLDrawableOptions.mRequestWidth;
        localURLDrawableOptions.mLoadingDrawable = localDrawable;
        localURLDrawableOptions.mFailedDrawable = localDrawable;
        localObject = URLDrawable.getDrawable(((apqt)localObject).c, localURLDrawableOptions);
        ((URLDrawable)localObject).setTargetDensity(paramContext.getResources().getDisplayMetrics().densityDpi);
        if (((URLDrawable)localObject).getStatus() == 2) {
          ((URLDrawable)localObject).restartDownload();
        }
        localURLImageView.setImageDrawable((Drawable)localObject);
        localTextView.setVisibility(8);
        label256:
        if (i >= 4) {
          break label336;
        }
        paramLinearLayout1.addView(localView, i);
      }
      for (;;)
      {
        i += 1;
        break;
        if (i != 7) {
          return;
        }
        localURLImageView.setImageDrawable(paramContext.getResources().getDrawable(2130838649));
        localTextView.setText(String.format("+%d", new Object[] { Integer.valueOf(paramArrayList.size() - 7) }));
        localTextView.setVisibility(0);
        break label256;
        label336:
        paramLinearLayout2.addView(localView, i - 4);
      }
    }
  }
  
  private void a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      QLog.e("ark.download.ctrl", 1, new Object[] { "ark.dctrl [checkWaitQueueToShowDialog] waite size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) });
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        this.b.clear();
        this.b.addAll((ArrayList)this.jdField_a_of_type_JavaUtilArrayList.clone());
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        b(paramString);
      }
      return;
    }
  }
  
  private void b(String paramString)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localBaseActivity == null) || (localBaseActivity.isFinishing()) || (this.b == null) || (this.b.size() <= 0))
    {
      if (this.b != null) {}
      for (int i = this.b.size();; i = 0)
      {
        QLog.e("ark.download.ctrl", 1, new Object[] { "ark.dctrl [showDownloadDialog] error,showlist size:", Integer.valueOf(i) });
        return;
      }
    }
    Object localObject = new apqr(this, paramString);
    try
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Int = this.b.size();
      QLog.e("ark.download.ctrl", 1, new Object[] { "ark.dctrl [showDownloadDialog] arkappname:", paramString, ",showlist size:", Integer.valueOf(this.jdField_a_of_type_Int) });
      this.jdField_a_of_type_Bgpa = bglp.a(localBaseActivity, 230, 2131558692, null, String.format(localBaseActivity.getString(2131690109), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }), localBaseActivity.getString(2131690582), localBaseActivity.getString(2131690106), (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
      localObject = (LinearLayout)this.jdField_a_of_type_Bgpa.findViewById(2131369888);
      LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_Bgpa.findViewById(2131369887);
      a(localBaseActivity, this.b, (LinearLayout)localObject, localLinearLayout);
      this.jdField_a_of_type_Bgpa.setOnDismissListener(new apqs(this));
      this.jdField_a_of_type_Bgpa.show();
      bcst.a(null, "dc00898", "", "", "0X800AD1C", "0X800AD1C", 3, 0, String.valueOf(this.jdField_a_of_type_Int), "", paramString, "");
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ark.download.ctrl", 1, "ark.dctrl [showDownloadDialog] exception:", paramString);
    }
  }
  
  public void a(String paramString1, String arg2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener)
  {
    QLog.d("ark.download.ctrl", 1, new Object[] { "ark.dctrl [showDownloadPermissionDialog] arkAppName:", paramString1, ", queue size[", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()), "], app:" + paramString3 + ",iconUrl:" + paramString4 });
    apqt localapqt = new apqt();
    localapqt.jdField_a_of_type_JavaLangString = ???;
    localapqt.c = paramString4;
    localapqt.b = paramString3;
    localapqt.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = paramOnClickListener;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(localapqt);
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_JavaLangRunnable = new ArkDownloadController.1(this, paramString1);
        ArkDispatchTask.getInstance().postToMainThreadDelayed(this.jdField_a_of_type_JavaLangRunnable, 150L);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apqq
 * JD-Core Version:    0.7.0.1
 */