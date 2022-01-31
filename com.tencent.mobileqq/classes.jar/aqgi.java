import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.utils.LightAppSettingInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.miniaio.MiniMultiForwardFragment;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppActivity;

public class aqgi
  extends aqbc
{
  private URLDrawableDownListener.Adapter jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new aqgj(this);
  AbsShareMsg jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
  String h = "";
  boolean i = false;
  
  public aqgi(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  private void a(boolean paramBoolean, String paramString, long paramLong)
  {
    String str2 = c();
    String str1 = str2;
    Intent localIntent;
    if (!TextUtils.isEmpty(str2))
    {
      if (str2.startsWith(ajyc.a(2131704830))) {
        str1 = str2.substring(4);
      }
    }
    else
    {
      str2 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
      int j = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype", 0);
      localIntent = new Intent();
      localIntent.setClass(this.jdField_a_of_type_AndroidAppActivity, MiniChatActivity.class);
      localIntent.addFlags(268435456);
      localIntent.putExtra("uin", str2);
      localIntent.putExtra("uintype", j);
      localIntent.putExtra("uinname", str1);
      localIntent.putExtra("public_fragment_window_feature", 1);
      localIntent.putExtra("minaio_scaled_ration", a(0.78F));
      localIntent.putExtra("minaio_height_ration", 0.86F);
      localIntent.putExtra("member_dialog_title", str1);
      if (!paramBoolean) {
        break label228;
      }
      localIntent.putExtra("multi_forward_type", 1);
    }
    for (;;)
    {
      localIntent.putExtra("key_mini_from", 4);
      abtu.a(this.jdField_a_of_type_AndroidAppActivity, localIntent, MiniChatActivity.class, MiniMultiForwardFragment.class);
      return;
      str1 = str2;
      if (!str2.startsWith(ajyc.a(2131704801))) {
        break;
      }
      str1 = str2.substring(3);
      break;
      label228:
      localIntent.putExtra("multi_forward_type", 2);
      localIntent.putExtra("multi_forward_title", paramString);
      localIntent.putExtra("structmsg_uniseq", paramLong);
    }
  }
  
  private boolean a(AbsShareMsg paramAbsShareMsg)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int j;
    if ((paramAbsShareMsg instanceof StructMsgForGeneralShare))
    {
      paramAbsShareMsg = ((StructMsgForGeneralShare)paramAbsShareMsg).getStructMsgItemLists();
      bool1 = bool2;
      if (paramAbsShareMsg != null) {
        j = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      Object localObject;
      int k;
      if (j < paramAbsShareMsg.size())
      {
        localObject = (axun)paramAbsShareMsg.get(j);
        if (!(localObject instanceof axye)) {
          break label139;
        }
        localObject = ((axye)localObject).a;
        if (localObject == null) {
          break label179;
        }
        k = 0;
        if (k >= ((List)localObject).size()) {
          break label179;
        }
        axun localaxun = (axun)((List)localObject).get(k);
        if ((!(localaxun instanceof axzq)) || (((axzq)localaxun).a())) {
          break label132;
        }
        bool1 = true;
      }
      label132:
      label139:
      do
      {
        do
        {
          return bool1;
          k += 1;
          break;
          if (!(localObject instanceof axxg)) {
            break label179;
          }
          paramAbsShareMsg = (axxg)localObject;
          bool1 = bool2;
        } while (paramAbsShareMsg.k == 1);
        bool1 = bool2;
      } while (paramAbsShareMsg.k == 3);
      return true;
      label179:
      j += 1;
    }
  }
  
  private boolean a(AbsStructMsg paramAbsStructMsg)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int j;
    if ((paramAbsStructMsg instanceof StructMsgForGeneralShare))
    {
      paramAbsStructMsg = ((StructMsgForGeneralShare)paramAbsStructMsg).getStructMsgItemLists();
      bool1 = bool2;
      if (paramAbsStructMsg != null) {
        j = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (j < paramAbsStructMsg.size())
      {
        axun localaxun = (axun)paramAbsStructMsg.get(j);
        if (!(localaxun instanceof axxg)) {
          break label95;
        }
        paramAbsStructMsg = (axxg)localaxun;
        bool1 = bool2;
        if (paramAbsStructMsg.k != 1)
        {
          bool1 = bool2;
          if (paramAbsStructMsg.k != 3) {
            bool1 = true;
          }
        }
      }
      return bool1;
      label95:
      j += 1;
    }
  }
  
  private View b()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidAppActivity);
    localLinearLayout.setOrientation(0);
    localLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null), new LinearLayout.LayoutParams(0, -2, 1.0F));
    int j = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 32) {
      j = 0;
    }
    for (;;)
    {
      FrameLayout localFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidAppActivity);
      localFrameLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
      if (j != 0)
      {
        Object localObject = new ImageView(this.jdField_a_of_type_AndroidAppActivity);
        ((ImageView)localObject).setImageResource(2130839611);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(bbkx.a(8.0F), bbkx.a(14.0F));
        localLayoutParams.setMargins(bbkx.a(7.0F), 0, 0, 0);
        localLayoutParams.gravity = 16;
        localLinearLayout.addView((View)localObject, localLayoutParams);
        localObject = new View(this.jdField_a_of_type_AndroidAppActivity);
        ((View)localObject).setBackgroundResource(2130839621);
        localFrameLayout.addView((View)localObject, new FrameLayout.LayoutParams(-1, bbkx.a(33.0F), 16));
        ((View)localObject).setOnClickListener(new aqgk(this));
        ((View)localObject).setContentDescription(ajyc.a(2131704802));
      }
      localFrameLayout.addView(localLinearLayout, new FrameLayout.LayoutParams(-1, -1));
      return localFrameLayout;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl)) {
        j = 0;
      }
    }
  }
  
  private void b(bbgg parambbgg)
  {
    parambbgg.setBodyLayoutNoMargin();
    Object localObject1 = new URLImageView(this.jdField_a_of_type_AndroidAppActivity);
    Object localObject2 = new LinearLayout.LayoutParams(-1, actn.a(152.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 114) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 116))
    {
      ((LinearLayout.LayoutParams)localObject2).leftMargin = actn.a(24.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      ((LinearLayout.LayoutParams)localObject2).rightMargin = actn.a(24.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    }
    ((URLImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((URLImageView)localObject1).setBackgroundColor(Color.parseColor("#dcdfe4"));
    Object localObject3 = aimf.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg, "cover");
    Drawable localDrawable = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130849344);
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject3 = URLDrawable.getDrawable((String)localObject3, -1, actn.a(165.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), localDrawable, localDrawable, true);
      ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      if ((localObject3 != null) && (((URLDrawable)localObject3).getStatus() == 2)) {
        ((URLDrawable)localObject3).restartDownload();
      }
      if ((localObject3 != null) && (((URLDrawable)localObject3).getStatus() == 1))
      {
        ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_CROP);
        ((URLImageView)localObject1).setBackgroundDrawable(null);
        ((URLImageView)localObject1).setImageDrawable((Drawable)localObject3);
      }
    }
    for (;;)
    {
      parambbgg.addView((View)localObject1, (LinearLayout.LayoutParams)localObject2);
      localObject1 = aimf.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg, "title");
      localObject2 = new TextView(this.jdField_a_of_type_AndroidAppActivity);
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setTextSize(16.0F);
      ((TextView)localObject2).setIncludeFontPadding(false);
      ((TextView)localObject2).setTextColor(-16777216);
      ((TextView)localObject2).setMaxLines(1);
      ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject2).setPadding(actn.a(24.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), actn.a(8.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), actn.a(24.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), actn.a(20.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      parambbgg.addView((View)localObject2);
      return;
      ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      ((URLImageView)localObject1).setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
      break;
      ((URLImageView)localObject1).setImageDrawable(localDrawable);
      ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }
  }
  
  private View c()
  {
    Object localObject1 = ajyc.a(2131704819);
    Object localObject2 = String.format((String)localObject1, new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mTSum) });
    int k = this.jdField_a_of_type_AndroidOsBundle.getInt("forward_msg_from_together", -1);
    if (k == 1) {
      localObject1 = ajyc.a(2131704818) + (String)localObject2;
    }
    int j;
    if ((k == 0) || (k == -1))
    {
      localObject1 = (axun)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mStructMsgItemLists.get(0);
      if ((localObject1 instanceof axuo))
      {
        localObject1 = (axun)((axuo)localObject1).a.get(0);
        if ((localObject1 instanceof StructMsgItemTitle))
        {
          localObject1 = ((StructMsgItemTitle)localObject1).Y;
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.hasTSum()) && (((String)localObject1).endsWith(ajyc.a(2131704799))))
          {
            j = 1;
            if (j == 0) {
              break label565;
            }
            label183:
            localObject2 = ajyc.a(2131704788) + (String)localObject1;
          }
        }
      }
    }
    for (;;)
    {
      Object localObject3 = new LinearLayout(this.jdField_a_of_type_AndroidAppActivity);
      ((LinearLayout)localObject3).setOrientation(0);
      Object localObject4 = new EllipsizingTextView(this.jdField_a_of_type_AndroidAppActivity, null);
      ((EllipsizingTextView)localObject4).setText(new ayki((CharSequence)localObject2, 3, 16));
      ((EllipsizingTextView)localObject4).setMaxLines(2);
      ((EllipsizingTextView)localObject4).setEllipsize(TextUtils.TruncateAt.END);
      ((EllipsizingTextView)localObject4).setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColorStateList(2131165584));
      ((EllipsizingTextView)localObject4).setTextSize(14.0F);
      localObject2 = new ImageView(this.jdField_a_of_type_AndroidAppActivity);
      ((ImageView)localObject2).setImageResource(2130839611);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2, 1.0F);
      localLayoutParams.gravity = 17;
      ((LinearLayout)localObject3).addView((View)localObject4, localLayoutParams);
      localObject4 = new LinearLayout.LayoutParams(bbkx.a(8.0F), bbkx.a(14.0F));
      ((LinearLayout.LayoutParams)localObject4).gravity = 17;
      ((LinearLayout.LayoutParams)localObject4).setMargins(bbkx.a(3.0F), 0, 0, 0);
      ((LinearLayout)localObject3).addView((View)localObject2, (ViewGroup.LayoutParams)localObject4);
      ((LinearLayout)localObject3).setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
      localObject2 = new View(this.jdField_a_of_type_AndroidAppActivity);
      ((View)localObject2).setBackgroundResource(2130839621);
      long l = this.jdField_a_of_type_AndroidOsBundle.getLong("structmsg_uniseq", 0L);
      boolean bool;
      if (k == 1)
      {
        bool = true;
        label450:
        ((View)localObject2).setOnClickListener(new aqgl(this, bool, (String)localObject1, l));
        localObject1 = new FrameLayout(this.jdField_a_of_type_AndroidAppActivity);
        j = bbkx.a(20.0F);
        ((FrameLayout)localObject1).setPadding(0, j, 0, j);
        ((FrameLayout)localObject1).setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        ((FrameLayout)localObject1).addView((View)localObject2, new FrameLayout.LayoutParams(-1, -1, 16));
        ((FrameLayout)localObject1).addView((View)localObject3, new FrameLayout.LayoutParams(-1, -2));
        if (k != 1) {
          break label582;
        }
        this.jdField_b_of_type_Int = 2;
      }
      label565:
      label582:
      while ((k != 0) && (k != -1))
      {
        return localObject1;
        j = 0;
        break;
        localObject1 = ajyc.a(2131704796);
        break label183;
        bool = false;
        break label450;
      }
      this.jdField_b_of_type_Int = 1;
      return localObject1;
      localObject1 = localObject2;
      break label183;
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
  }
  
  private void e()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl))
    {
      str = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl.trim();
      if (QLog.isColorLevel()) {
        QLog.e("ForwardOption.ForwardStructingMsgOption", 2, "gotoWeb " + str);
      }
      if (ayfv.a(str))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("url", str);
        ((Bundle)localObject).putBoolean("doc_from_forward_dialog", true);
        TeamWorkDocEditBrowserActivity.a(this.jdField_a_of_type_AndroidAppActivity, (Bundle)localObject, false);
        D();
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        String str;
        return;
        Object localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserDelegationActivity.class);
        ((Intent)localObject).putExtra("param_force_internal_browser", true);
        ((Intent)localObject).putExtra("reqType", 7);
        ((Intent)localObject).putExtra("hideRightButton", true);
        ((Intent)localObject).putExtra("hide_more_button", true);
        ((Intent)localObject).putExtra("url", str);
        acqz.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject, str);
      }
    }
    QLog.e("ForwardOption.ForwardStructingMsgOption", 2, "empty url");
  }
  
  protected View a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg == null) {
      return null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 35) {
      return c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 33) {
      return b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 95) {
      return b();
    }
    return b();
  }
  
  protected void a()
  {
    if (k()) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
    if (l()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if (m()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
    }
    if ((this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_smartdevice", true)) && (super.o())) {
      this.jdField_a_of_type_JavaUtilSet.add(j);
    }
  }
  
  public boolean a()
  {
    super.a();
    Object localObject = axuy.a(this.jdField_a_of_type_AndroidOsBundle.getByteArray("stuctmsg_bytes"));
    if ((localObject != null) && ((localObject instanceof AbsShareMsg))) {
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)localObject);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID != 83) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID != 108) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID != 114) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID != 116) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID != 151) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID != 156)) {
        break label172;
      }
      this.i = true;
      this.jdField_a_of_type_AndroidOsBundle.putInt("emoInputType", 3);
    }
    for (;;)
    {
      localObject = Uri.parse(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl);
      try
      {
        this.h = ((Uri)localObject).getQueryParameter("article_id");
        if (this.h == null) {
          this.h = "";
        }
        return true;
        label172:
        if ((!this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl.startsWith("http://article.mp.qq.com")) && (!this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl.startsWith("http://post.mp.qq.com"))) {
          continue;
        }
        this.jdField_a_of_type_AndroidOsBundle.putInt("emoInputType", 2);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  protected boolean a(bbgg parambbgg)
  {
    int k = 0;
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)
    {
      boolean bool = a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForGeneralShare)) {
        if ((!bool) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID != 97)) {
          localLayoutParams.setMargins(actn.a(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, actn.a(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), actn.a(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardStructingMsgOption", 2, "updateImageView addStructView");
        }
        if (!this.i) {
          break;
        }
        b(parambbgg);
        return false;
        if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForAudioShare)) {
          localLayoutParams.setMargins(0, actn.a(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, actn.a(10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        } else if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForImageShare)) {
          localLayoutParams.setMargins(actn.a(-10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, actn.a(-7.5F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0);
        }
      }
      parambbgg.addView(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null), localLayoutParams);
      if (((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForImageShare)) || (bool) || (!this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("is_need_show_sources", true))) {
        break label307;
      }
      j = 1;
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID != 35) {
        break label312;
      }
      j = k;
    }
    label307:
    label312:
    for (;;)
    {
      if (j != 0) {
        a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName, parambbgg);
      }
      return true;
      j = 0;
      break;
    }
  }
  
  protected boolean a(LightAppSettingInfo paramLightAppSettingInfo)
  {
    boolean bool2 = true;
    if (paramLightAppSettingInfo == null) {}
    do
    {
      return false;
      paramLightAppSettingInfo = paramLightAppSettingInfo.a;
    } while ((paramLightAppSettingInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg == null));
    boolean bool1 = bool2;
    switch (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID)
    {
    default: 
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      if (!paramLightAppSettingInfo.contains(Integer.valueOf(11005))) {
        break;
      }
      bool1 = bool2;
      continue;
      if (!paramLightAppSettingInfo.contains(Integer.valueOf(11003))) {
        break;
      }
      bool1 = bool2;
    }
  }
  
  public DeviceInfo[] a(DeviceInfo[] paramArrayOfDeviceInfo)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = (yak)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    localObject = new yml();
    int k = paramArrayOfDeviceInfo.length;
    int j = 0;
    while (j < k)
    {
      DeviceInfo localDeviceInfo = paramArrayOfDeviceInfo[j];
      if (localDeviceInfo != null)
      {
        LightAppSettingInfo localLightAppSettingInfo = ((yml)localObject).a(localDeviceInfo);
        if (QLog.isColorLevel()) {
          QLog.e("ForwardStructingMsgOption", 2, "settingInfo = " + localLightAppSettingInfo);
        }
        if ((a(j)) && (a(localLightAppSettingInfo))) {
          localArrayList.add(localDeviceInfo);
        }
      }
      j += 1;
    }
    return (DeviceInfo[])localArrayList.toArray(new DeviceInfo[localArrayList.size()]);
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_Bbgg.adjustMessageBottomMargin(17.0F);
    this.jdField_a_of_type_Bbgg.setMessageTextColor(2131165613);
    this.jdField_a_of_type_Bbgg.setMessageTextSize(14.0F);
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 97))
    {
      ViewGroup.LayoutParams localLayoutParams = ((LinearLayout)this.jdField_a_of_type_Bbgg.findViewById(2131363315)).getLayoutParams();
      if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
        ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins(0, 0, 0, 0);
      }
    }
  }
  
  public boolean b()
  {
    return true;
  }
  
  protected boolean c()
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", false);
    if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)) {
      QLog.d("forward", 2, "ForwardStructingMsgOption realForwardTo  mShareMsg.mMsgServiceID=" + this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID);
    }
    Object localObject1;
    if (f())
    {
      localObject1 = b();
      Object localObject2;
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForImageShare))
      {
        localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject2).next();
          StructMsgForImageShare.sendAndUploadImageShare(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (StructMsgForImageShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg, localResultRecord.a, localResultRecord.a(), null, 0);
        }
        if (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("k_back", true))
        {
          localObject2 = actn.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class), null);
          ((Intent)localObject2).putExtras(this.jdField_a_of_type_AndroidOsBundle);
          this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject2);
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null) && ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 32) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 97)))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ResultRecord)((Iterator)localObject1).next();
          localObject2 = ForwardUtils.a(localIntent, ((ResultRecord)localObject2).a, ((ResultRecord)localObject2).a(), ((ResultRecord)localObject2).c);
          ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (SessionInfo)localObject2, localIntent);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 97) {
          return false;
        }
      }
      if ((this.jdField_a_of_type_AndroidOsBundle.getBoolean("forwardDirect", false)) && ((this.jdField_a_of_type_AndroidAppActivity instanceof AppActivity))) {
        ForwardUtils.a((QQAppInterface)((AppActivity)this.jdField_a_of_type_AndroidAppActivity).getAppRuntime(), this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), localIntent, null);
      }
    }
    for (;;)
    {
      localIntent.putExtra("uin", this.jdField_a_of_type_AndroidOsBundle.getString("uin", ""));
      localIntent.putExtra("uintype", this.jdField_a_of_type_AndroidOsBundle.getInt("uintype", 0));
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return false;
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForImageShare))
      {
        StructMsgForImageShare.sendAndUploadImageShare(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (StructMsgForImageShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg, this.jdField_a_of_type_AndroidOsBundle.getString("uin"), this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"), null, 0);
        if (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("k_back", true))
        {
          localObject1 = actn.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class), null);
          ((Intent)localObject1).putExtras(this.jdField_a_of_type_AndroidOsBundle);
          this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject1);
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null) && ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 32) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 97) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 145) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 155)))
      {
        localObject1 = ForwardUtils.a(localIntent);
        ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (SessionInfo)localObject1, localIntent);
        if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 97) {
          break;
        }
      }
      if ((this.jdField_a_of_type_AndroidOsBundle.getBoolean("forwardDirect", false)) && ((this.jdField_a_of_type_AndroidAppActivity instanceof AppActivity))) {
        ForwardUtils.a((QQAppInterface)((AppActivity)this.jdField_a_of_type_AndroidAppActivity).getAppRuntime(), this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), localIntent, null);
      }
    }
  }
  
  protected int d()
  {
    Object localObject1;
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForImageShare))
    {
      localObject1 = bgpv.a((StructMsgForImageShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg);
      if ((localObject1 == null) || (!bgpd.b(((axwt)localObject1).S).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null))) {}
    }
    else
    {
      for (j = 0;; j = 0)
      {
        if (j == 0) {
          bgpr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_AddFav", -1, 0, 69, 0, "", "");
        }
        return j;
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgActionData)) {
          break;
        }
        String[] arrayOfString1 = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgActionData.split("&");
        int k = arrayOfString1.length;
        j = 0;
        Object localObject4 = null;
        Object localObject3 = null;
        Object localObject2 = null;
        localObject1 = null;
        if (j < k)
        {
          String[] arrayOfString2 = arrayOfString1[j].split("=");
          Object localObject5 = localObject4;
          Object localObject6 = localObject3;
          Object localObject7 = localObject2;
          Object localObject8 = localObject1;
          if (arrayOfString2.length > 1)
          {
            if (!arrayOfString2[0].trim().equals("lat")) {
              break label225;
            }
            localObject8 = arrayOfString2[1];
            localObject7 = localObject2;
            localObject6 = localObject3;
            localObject5 = localObject4;
          }
          for (;;)
          {
            j += 1;
            localObject4 = localObject5;
            localObject3 = localObject6;
            localObject2 = localObject7;
            localObject1 = localObject8;
            break;
            label225:
            if (arrayOfString2[0].trim().equals("lon"))
            {
              localObject7 = arrayOfString2[1];
              localObject5 = localObject4;
              localObject6 = localObject3;
              localObject8 = localObject1;
            }
            else if (arrayOfString2[0].trim().equals("loc"))
            {
              localObject6 = arrayOfString2[1];
              localObject5 = localObject4;
              localObject7 = localObject2;
              localObject8 = localObject1;
            }
            else
            {
              localObject5 = localObject4;
              localObject6 = localObject3;
              localObject7 = localObject2;
              localObject8 = localObject1;
              if (arrayOfString2[0].trim().equals("title"))
              {
                localObject5 = arrayOfString2[1];
                localObject6 = localObject3;
                localObject7 = localObject2;
                localObject8 = localObject1;
              }
            }
          }
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID != 32) || (TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(localObject2)) || (TextUtils.isEmpty(localObject3)) || (!bgpd.a(Float.valueOf((String)localObject1).floatValue(), Float.valueOf(localObject2).floatValue(), localObject4, localObject3, null).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null))) {
          break label540;
        }
      }
      localObject1 = bgpv.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getXmlBytes());
      if (!(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForAudioShare)) {
        break label545;
      }
    }
    label540:
    label545:
    for (int j = 2;; j = 0)
    {
      if (bgpd.a(j, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentTitle, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentSummary, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentCover, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentSrc, (byte[])localObject1, false, 0L).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null))
      {
        j = 0;
        break;
      }
      j = -1;
      break;
    }
  }
  
  protected void d()
  {
    int j = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("structmsg_service_id", -1);
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800567B", "0X800567B", 0, 0, j + "", "", "", "");
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007C3A", "0X8007C3A", 0, 0, "2", "", "", "");
    Object localObject1;
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForGeneralShare))
    {
      localObject1 = (StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
      Iterator localIterator = ((StructMsgForGeneralShare)localObject1).iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (axun)localIterator.next();
        if ((localObject2 instanceof axye))
        {
          localObject2 = ((axye)localObject2).a.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (axun)((Iterator)localObject2).next();
            if ((localObject3 instanceof axzq))
            {
              localObject3 = (axzq)localObject3;
              if (((axzq)localObject3).a()) {
                npx.a("0X80065FF", ((StructMsgForGeneralShare)localObject1).uinType, npx.a(((axzq)localObject3).r, ((StructMsgForGeneralShare)localObject1).mSourceName), ((axzq)localObject3).U, "");
              }
            }
          }
        }
      }
      d("1");
    }
    for (;;)
    {
      j = c();
      localObject1 = "";
      if (j != 0) {
        localObject1 = this.jdField_a_of_type_Bbgg.getInputValue();
      }
      this.jdField_a_of_type_AndroidOsBundle.putString("share_comment_message", (String)localObject1);
      super.d();
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForImageShare))
      {
        if (aehv.b(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgActionData))
        {
          localObject1 = aehv.b(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgActionData);
          if ((localObject1 != null) && (localObject1.length > 3))
          {
            localObject1 = localObject1[3];
            if ((localObject1 != null) && (((String)localObject1).equals("1")))
            {
              noo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X80072A5", "0X80072A5", 0, 0, "", "", "", "");
              noo.a("0X80072A5", "", "", "", "", "");
            }
          }
        }
        F();
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForAudioShare))
      {
        d("2");
      }
    }
  }
  
  protected boolean g()
  {
    return false;
  }
  
  protected boolean h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg == null) {}
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.e("ForwardOption.ForwardStructingMsgOption", 2, "msgId = " + this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 35) {
        return true;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 33)
      {
        this.jdField_b_of_type_Int = 8;
        return true;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 95)
      {
        this.jdField_b_of_type_Int = 9;
        return true;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl == null) || (!a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg)));
    this.jdField_b_of_type_Int = 8;
    return true;
  }
  
  protected void r()
  {
    super.r();
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007C3A", "0X8007C3A", 0, 0, "1", "", "", "");
  }
  
  protected void y()
  {
    ((yeu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(this.jdField_a_of_type_AndroidOsBundle.getString("uin"), this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg);
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqgi
 * JD-Core Version:    0.7.0.1
 */