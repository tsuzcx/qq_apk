import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.widget.AbsListView.LayoutParams;

public class bkkb
  extends bkke
{
  private final int b;
  private boolean d;
  private boolean e;
  
  public bkkb(Context paramContext, int paramInt)
  {
    super(paramContext, "", "", -1);
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    this.b = i;
  }
  
  public int a()
  {
    return 1;
  }
  
  public int a(int paramInt)
  {
    return 4;
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new RelativeLayout(this.a);
    paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(-1, this.b));
    paramViewGroup.setBackgroundColor(Color.parseColor("#F7F7F9"));
    View localView = new View(this.a);
    Object localObject = new RelativeLayout.LayoutParams(-1, vzo.a(this.a, 1.0F));
    ((RelativeLayout.LayoutParams)localObject).addRule(10);
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localView.setBackgroundColor(Color.parseColor("#DEDFE0"));
    localObject = new View(this.a);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, vzo.a(this.a, 1.0F));
    localLayoutParams.addRule(12);
    ((View)localObject).setLayoutParams(localLayoutParams);
    ((View)localObject).setBackgroundColor(Color.parseColor("#DEDFE0"));
    if (QQStoryContext.a())
    {
      paramViewGroup.setBackgroundColor(this.a.getResources().getColor(2131166349));
      ((View)localObject).setBackgroundColor(this.a.getResources().getColor(2131166349));
      localView.setBackgroundColor(this.a.getResources().getColor(2131166349));
    }
    paramViewGroup.addView(localView);
    paramViewGroup.addView((View)localObject);
    return paramViewGroup;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, View paramView)
  {
    View localView = ((ViewGroup)paramView).getChildAt(0);
    paramView = ((ViewGroup)paramView).getChildAt(1);
    if (this.d) {
      localView.setVisibility(0);
    }
    while (this.e)
    {
      paramView.setVisibility(0);
      return;
      localView.setVisibility(4);
    }
    paramView.setVisibility(4);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.d = paramBoolean1;
    this.e = paramBoolean2;
  }
  
  public void b(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkkb
 * JD-Core Version:    0.7.0.1
 */