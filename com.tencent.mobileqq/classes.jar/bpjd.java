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

public class bpjd
  extends botu
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private bpik jdField_a_of_type_Bpik;
  private boolean jdField_a_of_type_Boolean;
  private View b;
  private View c;
  
  public bpjd(@NonNull bpik parambpik, Activity paramActivity)
  {
    super(parambpik);
    this.jdField_a_of_type_Bpik = parambpik;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    if (yzz.a().b() == 22) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  private void a(String paramString)
  {
    String str = a().getString(2131717372);
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    QZoneHelper.forwardOpenQzoneVip2(this.jdField_a_of_type_AndroidAppActivity, localUserInfo, paramString, QQStoryContext.a().a(), "", 1010, str, false);
  }
  
  private void b()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)a(2131366018);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(a()).inflate(2131562277, localRelativeLayout, false);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(0, LiuHaiUtils.a, 0, 0);
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(10);
    this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131375468);
    this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131375467);
    if (this.jdField_a_of_type_Boolean)
    {
      this.b.setVisibility(8);
      this.c.setVisibility(8);
    }
    for (;;)
    {
      localRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
      return;
      this.b.setOnClickListener(new bpje(this));
      this.c.setOnClickListener(new bpjf(this));
    }
  }
  
  private void c()
  {
    bhdj.a(this.jdField_a_of_type_AndroidAppActivity, 230).setMessage(2131717506).setPositiveButton(2131717020, new bpjh(this)).setNegativeButton(2131718819, new bpjg(this)).show();
  }
  
  private void d()
  {
    bhdj.a(this.jdField_a_of_type_AndroidAppActivity, 230).setMessage(2131717507).setPositiveButton(2131717020, new bpjj(this)).setNegativeButton(2131691037, new bpji(this)).show();
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
      bjkv.a().a(2131717242);
      this.jdField_a_of_type_Bpik.e = true;
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
 * Qualified Name:     bpjd
 * JD-Core Version:    0.7.0.1
 */