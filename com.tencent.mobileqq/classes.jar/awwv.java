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
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.widget.AdapterView;
import java.io.File;

public class awwv
  extends aafy
{
  protected awwu a;
  public awwx a;
  protected awxb a;
  protected PicBrowserActivity a;
  protected boolean a;
  private boolean b;
  
  public awwv(PicBrowserActivity paramPicBrowserActivity, aagc paramaagc)
  {
    super(paramPicBrowserActivity, paramaagc);
    this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity = paramPicBrowserActivity;
    this.jdField_a_of_type_Awxb = ((awxb)paramaagc);
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
    return (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561214, null);
  }
  
  protected AbstractImageAdapter a(Context paramContext)
  {
    if (this.jdField_a_of_type_Awwu == null) {
      this.jdField_a_of_type_Awwu = new awwu(paramContext);
    }
    return this.jdField_a_of_type_Awwu;
  }
  
  public void a()
  {
    awwy localawwy = this.jdField_a_of_type_Awxb.a();
    if (localawwy != null)
    {
      localawwy.thubmRect = ((Rect)this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity.getIntent().getParcelableExtra("KEY_THUMBNAL_BOUND"));
      localawwy.isImgCenterCropMode = this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity.getIntent().getBooleanExtra("extra_is_image_center_crop", false);
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
      d(this.jdField_a_of_type_Awxb.b());
      return true;
    }
    return super.a(paramInt, paramKeyEvent);
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Awxb instanceof awxb))
    {
      this.jdField_a_of_type_Awxb.a();
      this.b = true;
    }
    super.c();
  }
  
  public void d()
  {
    int i = -1;
    int k;
    awwy localawwy1;
    awwy localawwy2;
    if (this.jdField_a_of_type_Awxb != null)
    {
      j = this.jdField_a_of_type_Awxb.b();
      k = this.jdField_a_of_type_Awxb.a();
      if (k == 1)
      {
        localawwy1 = this.jdField_a_of_type_Awxb.b(j);
        j = i;
        localawwy2 = localawwy1;
        if (this.jdField_a_of_type_Awwu != null)
        {
          this.jdField_a_of_type_Awwu.notifyDataSetChanged();
          localawwy2 = localawwy1;
        }
      }
    }
    for (int j = i;; j = i)
    {
      if (this.jdField_a_of_type_Awwx != null) {
        this.jdField_a_of_type_Awwx.a(localawwy2, j);
      }
      return;
      if (j == k - 1)
      {
        localawwy1 = this.jdField_a_of_type_Awxb.b(j);
        i = j - 1;
        this.jdField_a_of_type_Awxb.a(i);
        break;
      }
      if ((j >= 0) && (j < k))
      {
        localawwy1 = this.jdField_a_of_type_Awxb.b(j);
        this.jdField_a_of_type_Awxb.a(j);
        i = j;
        break;
      }
      localawwy1 = null;
      break;
      localawwy2 = null;
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
      if (this.jdField_a_of_type_Awxb.a(paramInt) != null)
      {
        localObject1 = localObject4;
        localObject2 = localObject3;
        if (this.jdField_a_of_type_Awxb.a(paramInt).a != null)
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_Awxb.a(paramInt).a.c)) {
            break label182;
          }
          localObject2 = this.jdField_a_of_type_Awxb.a(paramInt).a.c;
        }
      }
      for (localObject1 = new File(this.jdField_a_of_type_Awxb.a(paramInt).a.c); localObject1 != null; localObject1 = AbsDownloader.getFile(this.jdField_a_of_type_Awxb.a(paramInt).a.a))
      {
        localObject3 = bjnw.a(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity);
        ((bjnw)localObject3).c(amtj.a(2131707256));
        ((bjnw)localObject3).c("发送给QQ好友");
        ((bjnw)localObject3).d(amtj.a(2131707257));
        ((bjnw)localObject3).a(new awww(this, (bjnw)localObject3, (File)localObject1, (String)localObject2));
        ((bjnw)localObject3).show();
        return;
        label182:
        localObject2 = AbsDownloader.getFilePath(this.jdField_a_of_type_Awxb.a(paramInt).a.a);
      }
    }
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void h_()
  {
    if (((this.jdField_a_of_type_Awxb instanceof awxb)) && (this.b) && (this.jdField_a_of_type_Awwu != null)) {
      this.jdField_a_of_type_Awwu.notifyDataSetChanged();
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
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    d(paramInt);
    return super.onItemLongClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awwv
 * JD-Core Version:    0.7.0.1
 */