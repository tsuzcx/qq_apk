import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qqprotect.qsec.QSecFramework;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class aqgo
  extends aqbe
{
  public aqgo(Intent paramIntent)
  {
    super(paramIntent);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 3;
  }
  
  protected View a()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidAppActivity);
    localLinearLayout.setOrientation(0);
    AnimationTextView localAnimationTextView = new AnimationTextView(this.jdField_a_of_type_AndroidAppActivity);
    Object localObject2 = a();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localAnimationTextView.setText(new aykk((CharSequence)localObject1, 5, 16));
    localAnimationTextView.setMaxLines(2);
    localAnimationTextView.setEllipsize(TextUtils.TruncateAt.END);
    localAnimationTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColorStateList(2131165584));
    localAnimationTextView.setTextSize(14.0F);
    localObject1 = new ImageView(this.jdField_a_of_type_AndroidAppActivity);
    ((ImageView)localObject1).setImageResource(2130839611);
    localObject2 = new LinearLayout.LayoutParams(0, -2, 1.0F);
    ((LinearLayout.LayoutParams)localObject2).gravity = 17;
    localLinearLayout.addView(localAnimationTextView, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new LinearLayout.LayoutParams(bbll.a(8.0F), bbll.a(14.0F));
    ((LinearLayout.LayoutParams)localObject2).gravity = 17;
    ((LinearLayout.LayoutParams)localObject2).setMargins(bbll.a(3.0F), 0, 0, 0);
    localLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localLinearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    localObject1 = new View(this.jdField_a_of_type_AndroidAppActivity);
    ((View)localObject1).setId(2131366651);
    ((View)localObject1).setBackgroundResource(2130839621);
    ((View)localObject1).setOnClickListener(new aqgp(this));
    localObject2 = new FrameLayout(this.jdField_a_of_type_AndroidAppActivity);
    int i = bbll.a(20.0F);
    ((FrameLayout)localObject2).setPadding(0, i, 0, i);
    ((FrameLayout)localObject2).setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    ((FrameLayout)localObject2).addView((View)localObject1, new FrameLayout.LayoutParams(-1, -1, 16));
    ((FrameLayout)localObject2).addView(localLinearLayout, new FrameLayout.LayoutParams(-1, -2));
    return localObject2;
  }
  
  public List<RecentUser> a(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!bbbr.a(localRecentUser.uin)) && (localRecentUser.getType() != 1008) && (localRecentUser.getType() != 1021) && (localRecentUser.getType() != 10004) && (localRecentUser.getType() != 7000) && (localRecentUser.getType() != 6004) && (localRecentUser.getType() != 6002) && ((localRecentUser.getType() != 1) || (!a(localRecentUser.uin))) && ((localRecentUser.getType() != 1006) || (a(aqau.h))) && (localRecentUser.getType() != 9501) && ((localRecentUser.getType() != 0) || (!naz.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, localRecentUser.getType()))) && (((localRecentUser.getType() != 1004) && (localRecentUser.getType() != 1000)) || (this.jdField_b_of_type_Boolean))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  protected void a()
  {
    super.a();
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_dataline", true))
    {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_f_of_type_JavaLangInteger);
      this.jdField_a_of_type_JavaUtilSet.add(k);
    }
    if ((this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_smartdevice", true)) && (o())) {
      this.jdField_a_of_type_JavaUtilSet.add(j);
    }
  }
  
  public boolean a()
  {
    super.a();
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      SpannableString localSpannableString = (SpannableString)this.jdField_a_of_type_AndroidOsBundle.get("forward_text");
      if (localSpannableString != null) {
        this.jdField_a_of_type_JavaLangString = localSpannableString.toString();
      }
    }
    return true;
  }
  
  public DeviceInfo[] a(DeviceInfo[] paramArrayOfDeviceInfo)
  {
    ArrayList localArrayList = new ArrayList();
    yah localyah = (yah)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    int j = paramArrayOfDeviceInfo.length;
    int i = 0;
    while (i < j)
    {
      DeviceInfo localDeviceInfo = paramArrayOfDeviceInfo[i];
      if (localDeviceInfo != null)
      {
        ProductInfo localProductInfo = localyah.a(localDeviceInfo.productId);
        if ((localProductInfo != null) && (localProductInfo.isSupportMainMsgType(1)) && (a(j))) {
          localArrayList.add(localDeviceInfo);
        }
      }
      i += 1;
    }
    return (DeviceInfo[])localArrayList.toArray(new DeviceInfo[localArrayList.size()]);
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_Bbgu.adjustMessageBottomMargin(17.0F);
    this.jdField_a_of_type_Bbgu.setMessageTextColor(2131165613);
    this.jdField_a_of_type_Bbgu.setMessageTextSize(14.0F);
  }
  
  protected void b(Intent paramIntent)
  {
    paramIntent.putExtra("dataline_forward_type", 102);
    paramIntent.putExtra("dataline_forward_text", this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean b()
  {
    return true;
  }
  
  protected boolean c()
  {
    Intent localIntent;
    boolean bool;
    if (f())
    {
      localIntent = actj.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isFromShare", false))
      {
        this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", ajya.a(2131704858));
        localIntent.addFlags(268435456);
        localIntent.addFlags(67108864);
        this.jdField_a_of_type_AndroidOsBundle.putString("forward_text", this.jdField_a_of_type_JavaLangString);
        localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
        bool = a(localIntent);
        if (this.jdField_f_of_type_Boolean)
        {
          ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, localIntent, null);
          if (QSecFramework.a().a(1003).booleanValue())
          {
            localObject = b().iterator();
            while (((Iterator)localObject).hasNext())
            {
              ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject).next();
              bcxk.a().a(1, this.jdField_a_of_type_JavaLangString, localResultRecord.a(), localResultRecord.jdField_a_of_type_JavaLangString);
              bcxk.a().a();
            }
          }
        }
        else if (!bool)
        {
          ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, localIntent, null);
        }
      }
      this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", false);
      localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
      return false;
    }
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    if (i == 1008)
    {
      localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class);
      localIntent.putExtra("chat_subType", nnu.a((String)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isFromShare", false))
      {
        this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", ajya.a(2131704853));
        localIntent.addFlags(268435456);
        localIntent.addFlags(67108864);
        this.jdField_a_of_type_AndroidOsBundle.putString("forward_text", this.jdField_a_of_type_JavaLangString);
        localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
        bool = a(localIntent);
        if (!this.jdField_f_of_type_Boolean) {
          break label504;
        }
        this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
        if (QSecFramework.a().a(1003).booleanValue())
        {
          bcxk.a().a(1, this.jdField_a_of_type_JavaLangString, i, (String)localObject);
          bcxk.a().a();
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", false);
      localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return false;
      localIntent = actj.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
      break;
      label504:
      if (!bool) {
        ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, localIntent, null);
      }
    }
  }
  
  protected int d()
  {
    if (bgpu.a(null, this.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null)) {}
    for (int i = 0;; i = -1)
    {
      if (i == 0) {
        bgqi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_AddFav", -1, 0, 69, 0, "", "");
      }
      return i;
    }
  }
  
  protected boolean h()
  {
    return true;
  }
  
  public void j()
  {
    super.j();
    AbstractGifImage.pauseAll();
  }
  
  public void k()
  {
    super.k();
    AbstractGifImage.resumeAll();
  }
  
  protected void y()
  {
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqgo
 * JD-Core Version:    0.7.0.1
 */