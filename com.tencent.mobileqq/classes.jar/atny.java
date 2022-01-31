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

public class atny
  extends xpi
{
  protected atnx a;
  public atoa a;
  protected atoe a;
  protected PicBrowserActivity a;
  protected boolean a;
  private boolean b;
  
  public atny(PicBrowserActivity paramPicBrowserActivity, xpm paramxpm)
  {
    super(paramPicBrowserActivity, paramxpm);
    this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity = paramPicBrowserActivity;
    this.jdField_a_of_type_Atoe = ((atoe)paramxpm);
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
    return (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131560890, null);
  }
  
  protected AbstractImageAdapter a(Context paramContext)
  {
    if (this.jdField_a_of_type_Atnx == null) {
      this.jdField_a_of_type_Atnx = new atnx(paramContext);
    }
    return this.jdField_a_of_type_Atnx;
  }
  
  public void a()
  {
    atob localatob = this.jdField_a_of_type_Atoe.a();
    if (localatob != null)
    {
      localatob.jdField_a_of_type_AndroidGraphicsRect = ((Rect)this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity.getIntent().getParcelableExtra("KEY_THUMBNAL_BOUND"));
      localatob.c = this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity.getIntent().getBooleanExtra("extra_is_image_center_crop", false);
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
      d(this.jdField_a_of_type_Atoe.b());
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
      if (this.jdField_a_of_type_Atoe.a(paramInt) != null)
      {
        localObject1 = localObject4;
        localObject2 = localObject3;
        if (this.jdField_a_of_type_Atoe.a(paramInt).jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo != null)
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_Atoe.a(paramInt).jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.c)) {
            break label182;
          }
          localObject2 = this.jdField_a_of_type_Atoe.a(paramInt).jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.c;
        }
      }
      for (localObject1 = new File(this.jdField_a_of_type_Atoe.a(paramInt).jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.c); localObject1 != null; localObject1 = ayog.a(this.jdField_a_of_type_Atoe.a(paramInt).jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.a))
      {
        localObject3 = bfol.a(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity);
        ((bfol)localObject3).c(ajyc.a(2131708143));
        ((bfol)localObject3).c("发送给QQ好友");
        ((bfol)localObject3).d(ajyc.a(2131708144));
        ((bfol)localObject3).a(new atnz(this, (bfol)localObject3, (File)localObject1, (String)localObject2));
        ((bfol)localObject3).show();
        return;
        label182:
        localObject2 = ayog.d(this.jdField_a_of_type_Atoe.a(paramInt).jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.a);
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
    atob localatob1;
    atob localatob2;
    if (this.jdField_a_of_type_Atoe != null)
    {
      j = this.jdField_a_of_type_Atoe.b();
      k = this.jdField_a_of_type_Atoe.a();
      if (k == 1)
      {
        localatob1 = this.jdField_a_of_type_Atoe.b(j);
        j = i;
        localatob2 = localatob1;
        if (this.jdField_a_of_type_Atnx != null)
        {
          this.jdField_a_of_type_Atnx.notifyDataSetChanged();
          localatob2 = localatob1;
        }
      }
    }
    for (int j = i;; j = i)
    {
      if (this.jdField_a_of_type_Atoa != null) {
        this.jdField_a_of_type_Atoa.a(localatob2, j);
      }
      return;
      if (j == k - 1)
      {
        localatob1 = this.jdField_a_of_type_Atoe.b(j);
        i = j - 1;
        this.jdField_a_of_type_Atoe.a(i);
        break;
      }
      if ((j >= 0) && (j < k))
      {
        localatob1 = this.jdField_a_of_type_Atoe.b(j);
        this.jdField_a_of_type_Atoe.a(j);
        i = j;
        break;
      }
      localatob1 = null;
      break;
      localatob2 = null;
    }
  }
  
  public void p()
  {
    if ((this.jdField_a_of_type_Atoe instanceof atoe))
    {
      this.jdField_a_of_type_Atoe.a();
      this.b = true;
    }
    super.p();
  }
  
  public void s()
  {
    if (((this.jdField_a_of_type_Atoe instanceof atoe)) && (this.b) && (this.jdField_a_of_type_Atnx != null)) {
      this.jdField_a_of_type_Atnx.notifyDataSetChanged();
    }
    this.b = false;
    super.s();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atny
 * JD-Core Version:    0.7.0.1
 */