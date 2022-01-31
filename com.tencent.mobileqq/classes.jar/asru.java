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

public class asru
  extends xgi
{
  protected asrt a;
  public asrw a;
  protected assa a;
  protected PicBrowserActivity a;
  protected boolean a;
  private boolean b;
  
  public asru(PicBrowserActivity paramPicBrowserActivity, xgm paramxgm)
  {
    super(paramPicBrowserActivity, paramxgm);
    this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity = paramPicBrowserActivity;
    this.jdField_a_of_type_Assa = ((assa)paramxgm);
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
    return (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131495312, null);
  }
  
  protected AbstractImageAdapter a(Context paramContext)
  {
    if (this.jdField_a_of_type_Asrt == null) {
      this.jdField_a_of_type_Asrt = new asrt(paramContext);
    }
    return this.jdField_a_of_type_Asrt;
  }
  
  public void a()
  {
    asrx localasrx = this.jdField_a_of_type_Assa.a();
    if (localasrx != null)
    {
      localasrx.jdField_a_of_type_AndroidGraphicsRect = ((Rect)this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity.getIntent().getParcelableExtra("KEY_THUMBNAL_BOUND"));
      localasrx.c = this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity.getIntent().getBooleanExtra("extra_is_image_center_crop", false);
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
      d(this.jdField_a_of_type_Assa.b());
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
      if (this.jdField_a_of_type_Assa.a(paramInt) != null)
      {
        localObject1 = localObject4;
        localObject2 = localObject3;
        if (this.jdField_a_of_type_Assa.a(paramInt).jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo != null)
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_Assa.a(paramInt).jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.c)) {
            break label182;
          }
          localObject2 = this.jdField_a_of_type_Assa.a(paramInt).jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.c;
        }
      }
      for (localObject1 = new File(this.jdField_a_of_type_Assa.a(paramInt).jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.c); localObject1 != null; localObject1 = axoa.a(this.jdField_a_of_type_Assa.a(paramInt).jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.a))
      {
        localObject3 = begr.a(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity);
        ((begr)localObject3).c(ajjy.a(2131642358));
        ((begr)localObject3).c("发送给QQ好友");
        ((begr)localObject3).d(ajjy.a(2131642359));
        ((begr)localObject3).a(new asrv(this, (begr)localObject3, (File)localObject1, (String)localObject2));
        ((begr)localObject3).show();
        return;
        label182:
        localObject2 = axoa.d(this.jdField_a_of_type_Assa.a(paramInt).jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.a);
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
    asrx localasrx1;
    asrx localasrx2;
    if (this.jdField_a_of_type_Assa != null)
    {
      j = this.jdField_a_of_type_Assa.b();
      k = this.jdField_a_of_type_Assa.a();
      if (k == 1)
      {
        localasrx1 = this.jdField_a_of_type_Assa.b(j);
        j = i;
        localasrx2 = localasrx1;
        if (this.jdField_a_of_type_Asrt != null)
        {
          this.jdField_a_of_type_Asrt.notifyDataSetChanged();
          localasrx2 = localasrx1;
        }
      }
    }
    for (int j = i;; j = i)
    {
      if (this.jdField_a_of_type_Asrw != null) {
        this.jdField_a_of_type_Asrw.a(localasrx2, j);
      }
      return;
      if (j == k - 1)
      {
        localasrx1 = this.jdField_a_of_type_Assa.b(j);
        i = j - 1;
        this.jdField_a_of_type_Assa.a(i);
        break;
      }
      if ((j >= 0) && (j < k))
      {
        localasrx1 = this.jdField_a_of_type_Assa.b(j);
        this.jdField_a_of_type_Assa.a(j);
        i = j;
        break;
      }
      localasrx1 = null;
      break;
      localasrx2 = null;
    }
  }
  
  public void p()
  {
    if ((this.jdField_a_of_type_Assa instanceof assa))
    {
      this.jdField_a_of_type_Assa.a();
      this.b = true;
    }
    super.p();
  }
  
  public void s()
  {
    if (((this.jdField_a_of_type_Assa instanceof assa)) && (this.b) && (this.jdField_a_of_type_Asrt != null)) {
      this.jdField_a_of_type_Asrt.notifyDataSetChanged();
    }
    this.b = false;
    super.s();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     asru
 * JD-Core Version:    0.7.0.1
 */