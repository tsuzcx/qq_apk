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

public class ayjn
  extends abjp
{
  protected ayjm a;
  public ayjp a;
  protected ayjt a;
  protected PicBrowserActivity a;
  protected boolean a;
  private boolean b;
  
  public ayjn(PicBrowserActivity paramPicBrowserActivity, abjt paramabjt)
  {
    super(paramPicBrowserActivity, paramabjt);
    this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity = paramPicBrowserActivity;
    this.jdField_a_of_type_Ayjt = ((ayjt)paramabjt);
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
    return (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561339, null);
  }
  
  protected AbstractImageAdapter a(Context paramContext)
  {
    if (this.jdField_a_of_type_Ayjm == null) {
      this.jdField_a_of_type_Ayjm = new ayjm(paramContext);
    }
    return this.jdField_a_of_type_Ayjm;
  }
  
  public void a()
  {
    ayjq localayjq = this.jdField_a_of_type_Ayjt.a();
    if (localayjq != null)
    {
      localayjq.jdField_a_of_type_AndroidGraphicsRect = ((Rect)this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity.getIntent().getParcelableExtra("KEY_THUMBNAL_BOUND"));
      localayjq.c = this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity.getIntent().getBooleanExtra("extra_is_image_center_crop", false);
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
      d(this.jdField_a_of_type_Ayjt.b());
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
    if ((this.jdField_a_of_type_Ayjt instanceof ayjt))
    {
      this.jdField_a_of_type_Ayjt.a();
      this.b = true;
    }
    super.c();
  }
  
  public void d()
  {
    int i = -1;
    int k;
    ayjq localayjq1;
    ayjq localayjq2;
    if (this.jdField_a_of_type_Ayjt != null)
    {
      j = this.jdField_a_of_type_Ayjt.b();
      k = this.jdField_a_of_type_Ayjt.a();
      if (k == 1)
      {
        localayjq1 = this.jdField_a_of_type_Ayjt.b(j);
        j = i;
        localayjq2 = localayjq1;
        if (this.jdField_a_of_type_Ayjm != null)
        {
          this.jdField_a_of_type_Ayjm.notifyDataSetChanged();
          localayjq2 = localayjq1;
        }
      }
    }
    for (int j = i;; j = i)
    {
      if (this.jdField_a_of_type_Ayjp != null) {
        this.jdField_a_of_type_Ayjp.a(localayjq2, j);
      }
      return;
      if (j == k - 1)
      {
        localayjq1 = this.jdField_a_of_type_Ayjt.b(j);
        i = j - 1;
        this.jdField_a_of_type_Ayjt.a(i);
        break;
      }
      if ((j >= 0) && (j < k))
      {
        localayjq1 = this.jdField_a_of_type_Ayjt.b(j);
        this.jdField_a_of_type_Ayjt.a(j);
        i = j;
        break;
      }
      localayjq1 = null;
      break;
      localayjq2 = null;
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
      if (this.jdField_a_of_type_Ayjt.a(paramInt) != null)
      {
        localObject1 = localObject4;
        localObject2 = localObject3;
        if (this.jdField_a_of_type_Ayjt.a(paramInt).jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo != null)
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_Ayjt.a(paramInt).jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.c)) {
            break label182;
          }
          localObject2 = this.jdField_a_of_type_Ayjt.a(paramInt).jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.c;
        }
      }
      for (localObject1 = new File(this.jdField_a_of_type_Ayjt.a(paramInt).jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.c); localObject1 != null; localObject1 = beqz.a(this.jdField_a_of_type_Ayjt.a(paramInt).jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.a))
      {
        localObject3 = blir.a(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity);
        ((blir)localObject3).c(anzj.a(2131707024));
        ((blir)localObject3).c("发送给QQ好友");
        ((blir)localObject3).d(anzj.a(2131707025));
        ((blir)localObject3).a(new ayjo(this, (blir)localObject3, (File)localObject1, (String)localObject2));
        ((blir)localObject3).show();
        return;
        label182:
        localObject2 = beqz.d(this.jdField_a_of_type_Ayjt.a(paramInt).jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo.a);
      }
    }
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void h_()
  {
    if (((this.jdField_a_of_type_Ayjt instanceof ayjt)) && (this.b) && (this.jdField_a_of_type_Ayjm != null)) {
      this.jdField_a_of_type_Ayjm.notifyDataSetChanged();
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
 * Qualified Name:     ayjn
 * JD-Core Version:    0.7.0.1
 */