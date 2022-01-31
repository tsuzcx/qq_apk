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

public class bdle
  extends bdjz
{
  TextView a;
  RelativeLayout b;
  RelativeLayout c;
  RelativeLayout d;
  int i;
  
  public bdle(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.i = aepi.a(35.0F, paramContext.getResources());
  }
  
  public float a(Activity paramActivity, float paramFloat)
  {
    Display localDisplay = paramActivity.getWindowManager().getDefaultDisplay();
    float f2 = localDisplay.getWidth();
    int j = paramActivity.getResources().getDimensionPixelSize(2131296779);
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
    ImageView localImageView1 = (ImageView)this.b.findViewById(2131368180);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.b.findViewById(2131377976);
    ImageView localImageView2 = (ImageView)this.b.findViewById(2131368178);
    bdlf localbdlf = new bdlf(this, paramQQAppInterface, paramString2, paramString1, paramInt);
    paramActivity = new bdlg(this, paramInt, paramQQAppInterface, paramActivity, paramString1, paramString2);
    if ((paramInt == 0) || (paramInt == 1000))
    {
      localImageView1.setImageDrawable(bdbk.a(paramQQAppInterface, 1, paramString1));
      this.c.setOnClickListener(paramActivity);
      this.c.setBackgroundResource(2130839719);
      return;
    }
    if (paramInt == 1)
    {
      if (paramBoolean) {}
      for (paramQQAppInterface = bdbk.a(paramQQAppInterface, 113, paramString1);; paramQQAppInterface = bdbk.a(paramQQAppInterface, 4, paramString1))
      {
        localImageView1.setImageDrawable(paramQQAppInterface);
        localImageView1.setOnClickListener(localbdlf);
        localRelativeLayout.setOnClickListener(paramActivity);
        localRelativeLayout.setBackgroundResource(2130839719);
        return;
      }
    }
    if (paramInt == 3000)
    {
      localImageView1.setImageDrawable(bdbk.a(paramQQAppInterface, 101, paramString1));
      localImageView1.setOnClickListener(localbdlf);
      localRelativeLayout.setOnClickListener(paramActivity);
      localRelativeLayout.setBackgroundResource(2130839719);
      return;
    }
    if (paramInt == 1006)
    {
      localImageView1.setImageDrawable(bdbk.a(paramQQAppInterface, 11, paramString1));
      this.c.setOnClickListener(paramActivity);
      this.c.setBackgroundResource(2130839719);
      return;
    }
    if (alof.z.equals(paramString1))
    {
      localImageView1.setImageResource(2130843834);
      localImageView1.setOnClickListener(localbdlf);
      this.c.setOnClickListener(paramActivity);
      this.c.setBackgroundResource(2130839719);
      return;
    }
    if (alof.A.equals(paramString1))
    {
      localImageView1.setImageResource(2130843832);
      localImageView1.setOnClickListener(localbdlf);
      this.c.setOnClickListener(paramActivity);
      this.c.setBackgroundResource(2130839719);
      return;
    }
    localImageView2.setVisibility(8);
    localImageView1.setImageDrawable(bdbk.a(1, 3));
  }
  
  @TargetApi(16)
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, List<ResultRecord> paramList, boolean paramBoolean)
  {
    this.b.setVisibility(0);
    this.d.setVisibility(0);
    this.title.setVisibility(8);
    this.c.setVisibility(8);
    ((TextView)this.b.findViewById(2131379214)).setText(alud.a(2131710586));
    GridView localGridView = (GridView)this.b.findViewById(2131367429);
    localGridView.setNumColumns(5);
    localGridView.setHorizontalSpacing((aepi.a(236.0F, getContext().getResources()) - this.i * 5) / 5);
    localGridView.setVerticalSpacing(aepi.a(10.0F, getContext().getResources()));
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
          localObject = new bdlh(this, paramActivity);
        }
        localGridView.setAdapter(new bdli(this, paramQQAppInterface, getContext(), paramList, (View.OnClickListener)localObject));
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
    localMarginLayoutParams.topMargin = aepi.a(2.0F, getContext().getResources());
    this.d.setLayoutParams(localMarginLayoutParams);
  }
  
  public void c(String paramString)
  {
    this.title.setVisibility(8);
    this.b.setVisibility(0);
    ((TextView)this.b.findViewById(2131379214)).setText(paramString);
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
    this.b = ((RelativeLayout)findViewById(2131375985));
    this.a = ((TextView)this.b.findViewById(2131379217));
    this.c = ((RelativeLayout)this.b.findViewById(2131367563));
    this.d = ((RelativeLayout)this.b.findViewById(2131367564));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdle
 * JD-Core Version:    0.7.0.1
 */