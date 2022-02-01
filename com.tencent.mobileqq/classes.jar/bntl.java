import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.utils.QQCustomDialog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.widget.QzoneGuideBubbleHelper;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;

public class bntl
  extends bnec
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private bnss jdField_a_of_type_Bnss;
  private boolean jdField_a_of_type_Boolean;
  private View b;
  private View c;
  
  public bntl(@NonNull bnss parambnss, Activity paramActivity)
  {
    super(parambnss);
    this.jdField_a_of_type_Bnss = parambnss;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    if (ylg.a().b() == 22) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  private void a(String paramString)
  {
    String str = a().getString(2131717009);
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    QZoneHelper.forwardOpenQzoneVip2(this.jdField_a_of_type_AndroidAppActivity, localUserInfo, paramString, QQStoryContext.a().a(), "", 1010, str, false);
  }
  
  private void b()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)a(2131365917);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(a()).inflate(2131562209, localRelativeLayout, false);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(0, LiuHaiUtils.a, 0, 0);
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(10);
    this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131375226);
    this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131375225);
    if (this.jdField_a_of_type_Boolean)
    {
      this.b.setVisibility(8);
      this.c.setVisibility(8);
    }
    for (;;)
    {
      localRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
      return;
      this.b.setOnClickListener(new bntm(this));
      this.c.setOnClickListener(new bntn(this));
    }
  }
  
  private void c()
  {
    bfur.a(this.jdField_a_of_type_AndroidAppActivity, 230).setMessage(2131717143).setPositiveButton(2131716657, new bntp(this)).setNegativeButton(2131718433, new bnto(this)).show();
  }
  
  private void d()
  {
    bfur.a(this.jdField_a_of_type_AndroidAppActivity, 230).setMessage(2131717144).setPositiveButton(2131716657, new bntr(this)).setNegativeButton(2131690952, new bntq(this)).show();
  }
  
  public void a()
  {
    super.a();
    b();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1010) && (paramInt2 == -1))
    {
      bhzt.a().a(2131716879);
      this.jdField_a_of_type_Bnss.e = true;
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_AndroidViewView == null);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    } while (this.jdField_a_of_type_AndroidViewView == null);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void g()
  {
    super.g();
    QzoneGuideBubbleHelper.getInstance().dismissGuideBubble();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bntl
 * JD-Core Version:    0.7.0.1
 */