import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class bbhl
  extends bbgg
{
  TextView a;
  RelativeLayout b;
  RelativeLayout c;
  RelativeLayout d;
  int i;
  
  public bbhl(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.i = actn.a(35.0F, paramContext.getResources());
  }
  
  public float a(Activity paramActivity, float paramFloat)
  {
    Display localDisplay = paramActivity.getWindowManager().getDefaultDisplay();
    float f2 = localDisplay.getWidth();
    int j = paramActivity.getResources().getDimensionPixelSize(2131296763);
    float f1 = paramFloat;
    if (j > f2 * paramFloat)
    {
      f2 = j / localDisplay.getWidth();
      f1 = paramFloat;
      if (f2 > paramFloat)
      {
        f1 = paramFloat;
        if (f2 < 1.0D) {
          f1 = f2;
        }
      }
    }
    return f1;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    QLog.i("Forward.Dialog", 1, "uin: " + paramString1 + " uinType: " + paramInt + " titleStr: " + paramString2);
    this.b.setVisibility(0);
    this.title.setVisibility(8);
    this.d.setVisibility(8);
    this.c.setVisibility(0);
    this.a.setText(paramString2);
    ImageView localImageView1 = (ImageView)this.b.findViewById(2131368031);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.b.findViewById(2131377387);
    ImageView localImageView2 = (ImageView)this.b.findViewById(2131368029);
    bbhm localbbhm = new bbhm(this, paramQQAppInterface, paramString2, paramString1, paramInt);
    paramActivity = new bbhn(this, paramInt, paramQQAppInterface, paramActivity, paramString1, paramString2);
    if ((paramInt == 0) || (paramInt == 1000))
    {
      localImageView1.setImageDrawable(baxt.a(paramQQAppInterface, 1, paramString1));
      this.c.setOnClickListener(paramActivity);
      this.c.setBackgroundResource(2130839621);
      return;
    }
    if (paramInt == 1)
    {
      if (paramBoolean) {}
      for (paramQQAppInterface = baxt.a(paramQQAppInterface, 113, paramString1);; paramQQAppInterface = baxt.a(paramQQAppInterface, 4, paramString1))
      {
        localImageView1.setImageDrawable(paramQQAppInterface);
        localImageView1.setOnClickListener(localbbhm);
        localRelativeLayout.setOnClickListener(paramActivity);
        localRelativeLayout.setBackgroundResource(2130839621);
        return;
      }
    }
    if (paramInt == 3000)
    {
      localImageView1.setImageDrawable(baxt.a(paramQQAppInterface, 101, paramString1));
      localImageView1.setOnClickListener(localbbhm);
      localRelativeLayout.setOnClickListener(paramActivity);
      localRelativeLayout.setBackgroundResource(2130839621);
      return;
    }
    if (paramInt == 1006)
    {
      localImageView1.setImageDrawable(baxt.a(paramQQAppInterface, 11, paramString1));
      this.c.setOnClickListener(paramActivity);
      this.c.setBackgroundResource(2130839621);
      return;
    }
    if (ajsf.z.equals(paramString1))
    {
      localImageView1.setImageResource(2130843408);
      localImageView1.setOnClickListener(localbbhm);
      this.c.setOnClickListener(paramActivity);
      this.c.setBackgroundResource(2130839621);
      return;
    }
    if (ajsf.A.equals(paramString1))
    {
      localImageView1.setImageResource(2130843406);
      localImageView1.setOnClickListener(localbbhm);
      this.c.setOnClickListener(paramActivity);
      this.c.setBackgroundResource(2130839621);
      return;
    }
    localImageView2.setVisibility(8);
    localImageView1.setImageDrawable(baxt.a(1, 3));
  }
  
  @TargetApi(16)
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, List<ResultRecord> paramList, boolean paramBoolean)
  {
    this.b.setVisibility(0);
    this.d.setVisibility(0);
    this.title.setVisibility(8);
    this.c.setVisibility(8);
    ((TextView)this.b.findViewById(2131378539)).setText(ajyc.a(2131710191));
    GridView localGridView = (GridView)this.b.findViewById(2131367288);
    localGridView.setNumColumns(5);
    localGridView.setHorizontalSpacing((actn.a(236.0F, getContext().getResources()) - this.i * 5) / 5);
    localGridView.setVerticalSpacing(actn.a(10.0F, getContext().getResources()));
    Object localObject = (RelativeLayout.LayoutParams)localGridView.getLayoutParams();
    if (Build.VERSION.SDK_INT >= 16) {}
    for (int j = localGridView.getVerticalSpacing();; j = 0)
    {
      if (paramList.size() <= 5) {}
      for (((RelativeLayout.LayoutParams)localObject).height = this.i;; ((RelativeLayout.LayoutParams)localObject).height = (j + this.i * 2))
      {
        localGridView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localGridView.setFocusable(false);
        localObject = null;
        if (paramBoolean) {
          localObject = new bbho(this, paramActivity);
        }
        localGridView.setAdapter(new bbhp(this, paramQQAppInterface, getContext(), paramList, (View.OnClickListener)localObject));
        return;
      }
    }
  }
  
  public void c()
  {
    if (this.d == null) {
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.d.getLayoutParams();
    localMarginLayoutParams.topMargin = actn.a(2.0F, getContext().getResources());
    this.d.setLayoutParams(localMarginLayoutParams);
  }
  
  public void c(String paramString)
  {
    this.title.setVisibility(8);
    this.b.setVisibility(0);
    ((TextView)this.b.findViewById(2131378539)).setText(paramString);
  }
  
  public void dismiss()
  {
    if (hasPreViewInDialog())
    {
      removePreviewView();
      return;
    }
    super.dismiss();
  }
  
  @TargetApi(11)
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.b = ((RelativeLayout)findViewById(2131375443));
    this.a = ((TextView)this.b.findViewById(2131378542));
    this.c = ((RelativeLayout)this.b.findViewById(2131367425));
    this.d = ((RelativeLayout)this.b.findViewById(2131367426));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bbhl
 * JD-Core Version:    0.7.0.1
 */