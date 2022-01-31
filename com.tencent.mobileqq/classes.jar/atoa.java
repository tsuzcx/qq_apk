import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserActivity;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.widget.AdapterView;
import java.io.File;

public class atoa
  extends xpf
{
  protected atnz a;
  public atoc a;
  protected atog a;
  protected PicBrowserActivity a;
  protected boolean a;
  private boolean b;
  
  public atoa(PicBrowserActivity paramPicBrowserActivity, xpj paramxpj)
  {
    super(paramPicBrowserActivity, paramxpj);
    this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity = paramPicBrowserActivity;
    this.jdField_a_of_type_Atog = ((atog)paramxpj);
    paramPicBrowserActivity = this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity.getIntent();
    if (paramPicBrowserActivity != null) {
      this.jdField_a_of_type_Boolean = paramPicBrowserActivity.getBooleanExtra("is_forbid_action_sheet", false);
    }
  }
  
  private void a(String paramString)
  {
    if (!new File(paramString).exists()) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity, ForwardRecentActivity.class);
    localIntent.putExtra("forward_type", 1);
    localIntent.putExtra("forward_thumb", paramString);
    localIntent.putExtra("key_flag_from_plugin", true);
    this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity.startActivityForResult(localIntent, 1001);
  }
  
  protected RelativeLayout a()
  {
    return (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131560889, null);
  }
  
  protected AbstractImageAdapter a(Context paramContext)
  {
    if (this.jdField_a_of_type_Atnz == null) {
      this.jdField_a_of_type_Atnz = new atnz(paramContext);
    }
    return this.jdField_a_of_type_Atnz;
  }
  
  public void a()
  {
    atod localatod = this.jdField_a_of_type_Atog.a();
    if (localatod != null)
    {
      localatod.jdField_a_of_type_AndroidGraphicsRect = ((Rect)this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity.getIntent().getParcelableExtra("KEY_THUMBNAL_BOUND"));
      localatod.c = this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity.getIntent().getBooleanExtra("extra_is_image_center_crop", false);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1001)) {}
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (82 == paramKeyEvent.getKeyCode())
    {
      d(this.jdField_a_of_type_Atog.b());
      return true;
    }
    return super.a(paramInt, paramKeyEvent);
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    d(paramInt);
    return super.a(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  protected void d(int paramInt)
  {
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity.isFinishing())) {}
    for (;;)
    {
      return;
      Object localObject3 = "";
      Object localObject4 = null;
      Object localObject1 = localObject4;
      Object localObject2 = localObject3;
      if (this.jdField_a_of_type_Atog.a(paramInt) != null)
      {
        localObject1 = localObject4;
        localObject2 = localObject3;
        if (this.jdField_a_of_type_Atog.a(paramInt).jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo != null)
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_Atog.a(paramInt).jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.c)) {
            break label182;
          }
          localObject2 = this.jdField_a_of_type_Atog.a(paramInt).jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.c;
        }
      }
      for (localObject1 = new File(this.jdField_a_of_type_Atog.a(paramInt).jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.c); localObject1 != null; localObject1 = ayoi.a(this.jdField_a_of_type_Atog.a(paramInt).jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.a))
      {
        localObject3 = bfpc.a(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity);
        ((bfpc)localObject3).c(ajya.a(2131708154));
        ((bfpc)localObject3).c("发送给QQ好友");
        ((bfpc)localObject3).d(ajya.a(2131708155));
        ((bfpc)localObject3).a(new atob(this, (bfpc)localObject3, (File)localObject1, (String)localObject2));
        ((bfpc)localObject3).show();
        return;
        label182:
        localObject2 = ayoi.d(this.jdField_a_of_type_Atog.a(paramInt).jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.a);
      }
    }
  }
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity.e();
  }
  
  public void f()
  {
    super.f();
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void g()
  {
    int i = -1;
    int k;
    atod localatod1;
    atod localatod2;
    if (this.jdField_a_of_type_Atog != null)
    {
      j = this.jdField_a_of_type_Atog.b();
      k = this.jdField_a_of_type_Atog.a();
      if (k == 1)
      {
        localatod1 = this.jdField_a_of_type_Atog.b(j);
        j = i;
        localatod2 = localatod1;
        if (this.jdField_a_of_type_Atnz != null)
        {
          this.jdField_a_of_type_Atnz.notifyDataSetChanged();
          localatod2 = localatod1;
        }
      }
    }
    for (int j = i;; j = i)
    {
      if (this.jdField_a_of_type_Atoc != null) {
        this.jdField_a_of_type_Atoc.a(localatod2, j);
      }
      return;
      if (j == k - 1)
      {
        localatod1 = this.jdField_a_of_type_Atog.b(j);
        i = j - 1;
        this.jdField_a_of_type_Atog.a(i);
        break;
      }
      if ((j >= 0) && (j < k))
      {
        localatod1 = this.jdField_a_of_type_Atog.b(j);
        this.jdField_a_of_type_Atog.a(j);
        i = j;
        break;
      }
      localatod1 = null;
      break;
      localatod2 = null;
    }
  }
  
  public void p()
  {
    if ((this.jdField_a_of_type_Atog instanceof atog))
    {
      this.jdField_a_of_type_Atog.a();
      this.b = true;
    }
    super.p();
  }
  
  public void s()
  {
    if (((this.jdField_a_of_type_Atog instanceof atog)) && (this.b) && (this.jdField_a_of_type_Atnz != null)) {
      this.jdField_a_of_type_Atnz.notifyDataSetChanged();
    }
    this.b = false;
    super.s();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atoa
 * JD-Core Version:    0.7.0.1
 */