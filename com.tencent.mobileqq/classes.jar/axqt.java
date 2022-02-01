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

public class axqt
  extends abfl
{
  protected axqs a;
  public axqv a;
  protected axqz a;
  protected PicBrowserActivity a;
  protected boolean a;
  private boolean b;
  
  public axqt(PicBrowserActivity paramPicBrowserActivity, abfp paramabfp)
  {
    super(paramPicBrowserActivity, paramabfp);
    this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity = paramPicBrowserActivity;
    this.jdField_a_of_type_Axqz = ((axqz)paramabfp);
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
    return (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561301, null);
  }
  
  protected AbstractImageAdapter a(Context paramContext)
  {
    if (this.jdField_a_of_type_Axqs == null) {
      this.jdField_a_of_type_Axqs = new axqs(paramContext);
    }
    return this.jdField_a_of_type_Axqs;
  }
  
  public void a()
  {
    axqw localaxqw = this.jdField_a_of_type_Axqz.a();
    if (localaxqw != null)
    {
      localaxqw.jdField_a_of_type_AndroidGraphicsRect = ((Rect)this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity.getIntent().getParcelableExtra("KEY_THUMBNAL_BOUND"));
      localaxqw.c = this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity.getIntent().getBooleanExtra("extra_is_image_center_crop", false);
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
      d(this.jdField_a_of_type_Axqz.b());
      return true;
    }
    return super.a(paramInt, paramKeyEvent);
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    d(paramInt);
    return super.a(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Axqz instanceof axqz))
    {
      this.jdField_a_of_type_Axqz.a();
      this.b = true;
    }
    super.c();
  }
  
  public void d()
  {
    int i = -1;
    int k;
    axqw localaxqw1;
    axqw localaxqw2;
    if (this.jdField_a_of_type_Axqz != null)
    {
      j = this.jdField_a_of_type_Axqz.b();
      k = this.jdField_a_of_type_Axqz.a();
      if (k == 1)
      {
        localaxqw1 = this.jdField_a_of_type_Axqz.b(j);
        j = i;
        localaxqw2 = localaxqw1;
        if (this.jdField_a_of_type_Axqs != null)
        {
          this.jdField_a_of_type_Axqs.notifyDataSetChanged();
          localaxqw2 = localaxqw1;
        }
      }
    }
    for (int j = i;; j = i)
    {
      if (this.jdField_a_of_type_Axqv != null) {
        this.jdField_a_of_type_Axqv.a(localaxqw2, j);
      }
      return;
      if (j == k - 1)
      {
        localaxqw1 = this.jdField_a_of_type_Axqz.b(j);
        i = j - 1;
        this.jdField_a_of_type_Axqz.a(i);
        break;
      }
      if ((j >= 0) && (j < k))
      {
        localaxqw1 = this.jdField_a_of_type_Axqz.b(j);
        this.jdField_a_of_type_Axqz.a(j);
        i = j;
        break;
      }
      localaxqw1 = null;
      break;
      localaxqw2 = null;
    }
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
      if (this.jdField_a_of_type_Axqz.a(paramInt) != null)
      {
        localObject1 = localObject4;
        localObject2 = localObject3;
        if (this.jdField_a_of_type_Axqz.a(paramInt).jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo != null)
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_Axqz.a(paramInt).jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.c)) {
            break label182;
          }
          localObject2 = this.jdField_a_of_type_Axqz.a(paramInt).jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.c;
        }
      }
      for (localObject1 = new File(this.jdField_a_of_type_Axqz.a(paramInt).jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.c); localObject1 != null; localObject1 = bdsh.a(this.jdField_a_of_type_Axqz.a(paramInt).jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.a))
      {
        localObject3 = bkho.a(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity);
        ((bkho)localObject3).c(anni.a(2131706915));
        ((bkho)localObject3).c("发送给QQ好友");
        ((bkho)localObject3).d(anni.a(2131706916));
        ((bkho)localObject3).a(new axqu(this, (bkho)localObject3, (File)localObject1, (String)localObject2));
        ((bkho)localObject3).show();
        return;
        label182:
        localObject2 = bdsh.d(this.jdField_a_of_type_Axqz.a(paramInt).jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.a);
      }
    }
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void h_()
  {
    if (((this.jdField_a_of_type_Axqz instanceof axqz)) && (this.b) && (this.jdField_a_of_type_Axqs != null)) {
      this.jdField_a_of_type_Axqs.notifyDataSetChanged();
    }
    this.b = false;
    super.h_();
  }
  
  public void i()
  {
    super.i();
    this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity.e();
  }
  
  public void j()
  {
    super.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axqt
 * JD-Core Version:    0.7.0.1
 */