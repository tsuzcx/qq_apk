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
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.forward.ForwardPluginShareStructMsgOption.2;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class asbj
  extends aryv
{
  private URLDrawableDownListener.Adapter jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new asbk(this);
  AbsShareMsg jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
  int d;
  int e;
  String h;
  String jdField_i_of_type_JavaLangString = "";
  boolean jdField_i_of_type_Boolean = false;
  
  public asbj(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  private void G()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl))
    {
      str = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl.trim();
      if (QLog.isColorLevel()) {
        QLog.e("ForwardOption.ForwardPluginShareStructMsgOption", 2, "gotoWeb " + str);
      }
      if (baic.a(str))
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
        aemu.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject, str);
      }
    }
    QLog.e("ForwardOption.ForwardPluginShareStructMsgOption", 2, "empty url");
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
        azus localazus = (azus)paramAbsStructMsg.get(j);
        if (!(localazus instanceof azxl)) {
          break label95;
        }
        paramAbsStructMsg = (azxl)localazus;
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
    Object localObject1 = new LinearLayout(this.jdField_a_of_type_AndroidAppActivity);
    ((LinearLayout)localObject1).setOrientation(0);
    ((LinearLayout)localObject1).addView(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null), new LinearLayout.LayoutParams(0, -2, 1.0F));
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
        Object localObject2 = new ImageView(this.jdField_a_of_type_AndroidAppActivity);
        ((ImageView)localObject2).setImageResource(2130839709);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(bdoo.a(8.0F), bdoo.a(14.0F));
        localLayoutParams.setMargins(bdoo.a(7.0F), 0, 0, 0);
        localLayoutParams.gravity = 16;
        ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
        localObject2 = new View(this.jdField_a_of_type_AndroidAppActivity);
        ((View)localObject2).setBackgroundResource(2130839719);
        localFrameLayout.addView((View)localObject2, new FrameLayout.LayoutParams(-1, bdoo.a(33.0F), 16));
        ((View)localObject2).setOnClickListener(new asbl(this));
        ((View)localObject2).setContentDescription(alud.a(2131705158));
      }
      localFrameLayout.addView((View)localObject1, new FrameLayout.LayoutParams(-1, -1));
      localObject1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("key_send_tips");
      if ((localObject1 != null) && ((this.jdField_a_of_type_Bdjz instanceof asau))) {
        ((asau)this.jdField_a_of_type_Bdjz).a((String)localObject1);
      }
      return localFrameLayout;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl)) {
        j = 0;
      }
    }
  }
  
  private void b(bdjz parambdjz)
  {
    int k = 1;
    parambdjz.setBodyLayoutNoMargin();
    Object localObject1 = new URLImageView(this.jdField_a_of_type_AndroidAppActivity);
    Object localObject2 = new LinearLayout.LayoutParams(-1, aepi.a(152.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 114) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 116))
    {
      ((LinearLayout.LayoutParams)localObject2).leftMargin = aepi.a(24.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      ((LinearLayout.LayoutParams)localObject2).rightMargin = aepi.a(24.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    }
    ((URLImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((URLImageView)localObject1).setBackgroundColor(Color.parseColor("#dcdfe4"));
    Object localObject3 = akid.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg, "cover");
    Drawable localDrawable = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130849859);
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject3 = URLDrawable.getDrawable((String)localObject3, (int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131296779), aepi.a(165.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), localDrawable, localDrawable, true);
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
      parambdjz.addView((View)localObject1, (LinearLayout.LayoutParams)localObject2);
      localObject1 = akid.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg, "title");
      localObject2 = new TextView(this.jdField_a_of_type_AndroidAppActivity);
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setTextSize(16.0F);
      ((TextView)localObject2).setIncludeFontPadding(false);
      ((TextView)localObject2).setTextColor(-16777216);
      int j = k;
      if (this.jdField_a_of_type_AndroidOsBundle != null)
      {
        j = k;
        if (this.jdField_a_of_type_AndroidOsBundle.getInt("title_max_line", -1) > 0) {
          j = this.jdField_a_of_type_AndroidOsBundle.getInt("title_max_line", 1);
        }
      }
      ((TextView)localObject2).setMaxLines(j);
      ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject2).setPadding(aepi.a(24.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), aepi.a(8.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), aepi.a(24.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), aepi.a(20.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      parambdjz.addView((View)localObject2);
      return;
      ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      ((URLImageView)localObject1).setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
      break;
      ((URLImageView)localObject1).setImageDrawable(localDrawable);
      ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }
  }
  
  private void e()
  {
    int j = 1;
    if (c() != 0) {}
    for (Object localObject1 = this.jdField_a_of_type_Bdjz.getInputValue();; localObject1 = "")
    {
      this.jdField_a_of_type_AndroidContentIntent.getAction();
      Object localObject2 = Boolean.valueOf(this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("key_flag_from_plugin", false));
      Object localObject3 = Boolean.valueOf(this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_back", false));
      if (QLog.isColorLevel()) {
        QLog.d("forward", 2, "ForwardPluginShareStructMsgOption forwardOnConfirm isFromPlugin=" + localObject2 + "iskeyBack=" + localObject3 + "isNOneedJumpToAIO=" + this.jdField_e_of_type_Boolean);
      }
      Object localObject4 = b();
      int k;
      if (((Boolean)localObject2).booleanValue())
      {
        localObject2 = aepi.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), new int[] { 2 });
        this.jdField_a_of_type_AndroidOsBundle.putString("share_comment_message", (String)localObject1);
        ((Intent)localObject2).putExtras(this.jdField_a_of_type_AndroidOsBundle);
        a((Intent)localObject2);
        if (((Boolean)localObject3).booleanValue())
        {
          localObject3 = azvd.a(((Intent)localObject2).getExtras());
          Object localObject5;
          Object localObject6;
          if ((this.jdField_d_of_type_Int == 13) && ((localObject3 instanceof StructMsgForGeneralShare)))
          {
            localObject5 = (StructMsgForGeneralShare)localObject3;
            localObject6 = new StringBuilder(((Intent)localObject2).getStringExtra("struct_share_key_content_action_DATA"));
            ((StringBuilder)localObject6).append("&msg=").append(((Intent)localObject2).getStringExtra("title")).append("&toUin=").append(this.jdField_a_of_type_AndroidOsBundle.getString("uin"));
            ((StructMsgForGeneralShare)localObject5).mMsgActionData = ((StringBuilder)localObject6).toString();
          }
          if (((AbsStructMsg)localObject3).mMsgServiceID == 83) {
            ((AbsStructMsg)localObject3).mMsgActionData = "";
          }
          if ((((AbsStructMsg)localObject3).mMsgServiceID == 108) || (((AbsStructMsg)localObject3).mMsgServiceID == 114) || (((AbsStructMsg)localObject3).mMsgServiceID == 116)) {
            ((AbsStructMsg)localObject3).mMsgActionData = "";
          }
          localObject4 = ((List)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (ResultRecord)((Iterator)localObject4).next();
            localObject6 = ForwardUtils.a((Intent)localObject2, ((ResultRecord)localObject5).a, ((ResultRecord)localObject5).a(), ((ResultRecord)localObject5).c);
            k = afcu.a().a();
            ((AbsStructMsg)localObject3).forwardID = k;
            afcu.a().a((SessionInfo)localObject6, (String)localObject1, k);
            bdna.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ResultRecord)localObject5).a, ((SessionInfo)localObject6).b, ((ResultRecord)localObject5).a(), (AbsStructMsg)localObject3, null);
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              nav.a().a = true;
            }
          }
        }
        localObject1 = ((List)localObject4).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (ResultRecord)((Iterator)localObject1).next();
          if (this.jdField_e_of_type_Boolean)
          {
            localObject3 = ForwardUtils.a((Intent)localObject2, ((ResultRecord)localObject3).a, ((ResultRecord)localObject3).a(), ((ResultRecord)localObject3).c);
            ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (SessionInfo)localObject3, (Intent)localObject2);
          }
          else if (asbe.a((Intent)localObject2))
          {
            localObject3 = ForwardUtils.a((Intent)localObject2, ((ResultRecord)localObject3).a, ((ResultRecord)localObject3).a(), ((ResultRecord)localObject3).c);
            ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (SessionInfo)localObject3, (Intent)localObject2);
          }
        }
        localObject1 = new Intent();
        ((Intent)localObject1).putExtras(this.jdField_a_of_type_AndroidOsBundle);
        this.jdField_a_of_type_AndroidAppActivity.setResult(-1, (Intent)localObject1);
        if ("public_account".equals(this.h))
        {
          localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("pubUin");
          if (localObject1 != null) {
            break label979;
          }
          localObject1 = "";
        }
      }
      label979:
      for (;;)
      {
        switch (this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"))
        {
        default: 
          j = -1;
          k = 0;
          if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_struct_forward", false))
          {
            if (this.jdField_a_of_type_AndroidContentIntent.getStringExtra("struct_uin") == null) {}
            localObject3 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("strurt_msgid");
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            localObject4 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("detail_url");
            localObject3 = localObject4;
            if (localObject4 == null) {
              localObject3 = "";
            }
            localObject4 = StructingMsgItemBuilder.a();
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005456", "0X8005456", 0, 0, (String)localObject4, (String)localObject2, (String)localObject3, "" + j);
          }
          PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, "Pb_account_lifeservice", "mp_msg_sys_11", "pbshare_success", k);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidAppActivity.finish();
          return;
          k = 1001;
          break;
          j = 2;
          k = 1002;
          break;
          j = 3;
          k = 1003;
          break;
          if ("struct_msg_from_h5".equals(this.h))
          {
            localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("pubUin");
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, "Pb_account_lifeservice", "mp_msg_sys_31", "share_succ");
            }
          }
          else if (asbe.a((Intent)localObject2))
          {
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_AndroidOsBundle.getString("uin"), "Music_gene", "Music_gene_send", 0, 1, 0, "", "", "", "");
          }
        }
        v();
        return;
      }
    }
  }
  
  private void e(String paramString)
  {
    ThreadManager.post(new ForwardPluginShareStructMsgOption.2(this, paramString), 5, null, true);
  }
  
  protected View a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg == null) {
      return null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 33)
    {
      this.jdField_b_of_type_Int = 8;
      return b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 95)
    {
      this.jdField_b_of_type_Int = 9;
      return b();
    }
    return b();
  }
  
  public List<RecentUser> a(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_d_of_type_Int == 13) || ("public_account".equals(this.h)) || ("web_share".equals(this.h)) || ("struct_msg_from_h5".equals(this.h)) || ("struct_favorite".equals(this.h)))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        RecentUser localRecentUser = (RecentUser)paramList.next();
        if ((localRecentUser != null) && (!bdeu.a(localRecentUser.uin)) && (localRecentUser.getType() != 1020) && (localRecentUser.getType() != 1008) && (localRecentUser.getType() != 1005) && (localRecentUser.getType() != 1009) && (localRecentUser.getType() != 1021) && (localRecentUser.getType() != 1001) && (localRecentUser.getType() != 10002) && (localRecentUser.getType() != 10004) && (localRecentUser.getType() != 1022) && ((localRecentUser.getType() != 1006) || (a(aryl.h))) && (localRecentUser.getType() != 7000) && (localRecentUser.getType() != 6004) && (localRecentUser.getType() != 9501) && ((localRecentUser.getType() != 0) || (!ndv.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, localRecentUser.getType()))) && (((localRecentUser.getType() == 0) && (a(jdField_b_of_type_JavaLangInteger))) || ((localRecentUser.getType() == 1) && (!a(localRecentUser.uin)) && (a(c))) || ((localRecentUser.getType() == 3000) && (a(jdField_d_of_type_JavaLangInteger)) && (((localRecentUser.getType() != 1004) && (localRecentUser.getType() != 1000)) || (this.jdField_b_of_type_Boolean))))) {
          localArrayList.add(localRecentUser);
        }
      }
    }
    return localArrayList;
  }
  
  protected void a()
  {
    int j = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("shareQQType", 13);
    if (((j & 0x8) != 0) && (k())) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_d_of_type_JavaLangInteger);
    }
    if (((j & 0x4) != 0) && (l())) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if (((j & 0x1) != 0) && (m())) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
    }
    if (super.o()) {
      this.jdField_a_of_type_JavaUtilSet.add(j);
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isWebCompShare", false))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("report_type", "102");
      localBundle.putString("act_type", "81");
      localBundle.putString("intext_1", "" + bfif.a(this.jdField_d_of_type_Int));
      localBundle.putString("intext_2", "" + bfif.a(paramBundle.getInt("uintype"), paramBundle.getString("uin")));
      localBundle.putString("intext_3", "1");
      bfhz.a().a(localBundle, "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
    }
    super.a(paramInt, paramBundle);
  }
  
  public void a(AbsStructMsg paramAbsStructMsg)
  {
    if ((paramAbsStructMsg == null) || (!(paramAbsStructMsg instanceof StructMsgForGeneralShare))) {}
    label454:
    label460:
    label461:
    label466:
    for (;;)
    {
      return;
      paramAbsStructMsg = ((StructMsgForGeneralShare)paramAbsStructMsg).getStructMsgItemLists();
      if ((paramAbsStructMsg != null) && (paramAbsStructMsg.size() != 0))
      {
        paramAbsStructMsg = paramAbsStructMsg.iterator();
        Object localObject1;
        do
        {
          if (!paramAbsStructMsg.hasNext()) {
            break;
          }
          localObject1 = (azus)paramAbsStructMsg.next();
        } while (!(localObject1 instanceof azxl));
        for (paramAbsStructMsg = (azxl)localObject1;; paramAbsStructMsg = null)
        {
          if (paramAbsStructMsg == null) {
            break label466;
          }
          paramAbsStructMsg = paramAbsStructMsg.a;
          if ((paramAbsStructMsg == null) || (paramAbsStructMsg.size() == 0)) {
            break;
          }
          localObject1 = paramAbsStructMsg.iterator();
          paramAbsStructMsg = null;
          label102:
          Object localObject2;
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (azus)((Iterator)localObject1).next();
            if (!(localObject2 instanceof azzm)) {
              break label460;
            }
            paramAbsStructMsg = (azzm)localObject2;
          }
          for (;;)
          {
            break label102;
            if (paramAbsStructMsg == null) {
              break label461;
            }
            localObject1 = paramAbsStructMsg.b();
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break;
            }
            aufn localaufn = (aufn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
            StringBuilder localStringBuilder = new StringBuilder((String)localObject1);
            int j = 0;
            int k;
            int[] arrayOfInt;
            if (j < localStringBuilder.length())
            {
              k = j;
              if ('ÿ' == localStringBuilder.charAt(j))
              {
                k = j;
                if (j + 3 < localStringBuilder.length())
                {
                  localObject1 = new char[4];
                  localObject1[0] = localStringBuilder.charAt(j + 3);
                  localObject1[1] = localStringBuilder.charAt(j + 2);
                  localObject1[2] = localStringBuilder.charAt(j + 1);
                  localObject1[3] = localStringBuilder.charAt(j);
                  k = 0;
                  if (k < 4)
                  {
                    if (localObject1[k] == 'ú') {
                      localObject1[k] = 10;
                    }
                    for (;;)
                    {
                      k += 1;
                      break;
                      if (localObject1[k] == 'þ') {
                        localObject1[k] = 13;
                      } else if (localObject1[k] == 'ý') {
                        localObject1[k] = 20;
                      }
                    }
                  }
                  arrayOfInt = apmq.a((char[])localObject1);
                  localObject2 = bamp.c;
                  if (localaufn == null) {
                    break label454;
                  }
                }
              }
            }
            for (localObject1 = localaufn.a(Integer.toString(arrayOfInt[0]), Integer.toString(arrayOfInt[1]));; localObject1 = null)
            {
              if (localObject1 != null) {}
              for (localObject1 = ((Emoticon)localObject1).character;; localObject1 = localObject2)
              {
                localStringBuilder.replace(j, j + 3, (String)localObject1);
                k = j + ((String)localObject1).length();
                j = k + 1;
                break;
                e(Integer.toString(arrayOfInt[0]));
              }
              if (TextUtils.isEmpty(localStringBuilder)) {
                break;
              }
              paramAbsStructMsg.a(localStringBuilder.toString());
              return;
            }
          }
          break;
        }
      }
    }
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "ForwardPluginShareStructMsgOption preloadData");
    }
    super.a();
    this.jdField_d_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("req_type", 2147483647);
    this.h = this.jdField_a_of_type_AndroidOsBundle.getString("pluginName");
    this.jdField_e_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward _key_nojump", false);
    Object localObject = azvd.a(this.jdField_a_of_type_AndroidOsBundle.getByteArray("stuctmsg_bytes"));
    if ((localObject != null) && ((localObject instanceof AbsShareMsg))) {
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)localObject);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg == null) {}
    for (;;)
    {
      return true;
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 83) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 108) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 114) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 116) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 151) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 156))
      {
        this.jdField_i_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidOsBundle.putInt("emoInputType", 3);
        this.jdField_e_of_type_Int = 2;
        label204:
        localObject = Uri.parse(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl);
      }
      try
      {
        this.jdField_i_of_type_JavaLangString = ((Uri)localObject).getQueryParameter("article_id");
        if (this.jdField_i_of_type_JavaLangString == null) {
          this.jdField_i_of_type_JavaLangString = "";
        }
        if (!this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isWebCompShare", false)) {
          continue;
        }
        localObject = new Bundle();
        ((Bundle)localObject).putString("report_type", "102");
        ((Bundle)localObject).putString("act_type", "80");
        ((Bundle)localObject).putString("intext_1", "" + bfif.a(this.jdField_d_of_type_Int));
        ((Bundle)localObject).putString("intext_3", "1");
        bfhz.a().a((Bundle)localObject, "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
        return true;
        if ((!this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl.startsWith("http://article.mp.qq.com")) && (!this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl.startsWith("http://post.mp.qq.com"))) {
          break label204;
        }
        this.jdField_e_of_type_Int = 1;
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
  
  protected boolean a(bdjz parambdjz)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentIntent.getByteArrayExtra("stuctmsg_bytes");
    if (localObject != null)
    {
      localObject = azvd.a((byte[])localObject);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      a((AbsStructMsg)localObject);
      boolean bool = a((AbsStructMsg)localObject);
      if ((localObject instanceof StructMsgForAudioShare)) {
        localLayoutParams.setMargins(0, aepi.a(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, aepi.a(10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      }
      while (this.jdField_i_of_type_Boolean)
      {
        b(parambdjz);
        return false;
        if (bool)
        {
          localLayoutParams.setMargins(0, 0, 0, 0);
          parambdjz.adjustMessageTopBottomMargin(0.0F, 0.0F);
        }
        else
        {
          localLayoutParams.setMargins(aepi.a(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, aepi.a(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), aepi.a(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        }
      }
      parambdjz.addView(((AbsStructMsg)localObject).getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null), localLayoutParams);
      if (!bool) {
        a(((AbsStructMsg)localObject).getSourceName(), parambdjz);
      }
    }
    return true;
  }
  
  public DeviceInfo[] a(DeviceInfo[] paramArrayOfDeviceInfo)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = (ztp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    localObject = new aafq();
    int k = paramArrayOfDeviceInfo.length;
    int j = 0;
    while (j < k)
    {
      DeviceInfo localDeviceInfo = paramArrayOfDeviceInfo[j];
      if (localDeviceInfo != null)
      {
        LightAppSettingInfo localLightAppSettingInfo = ((aafq)localObject).a(localDeviceInfo);
        if ((a(j)) && (super.a(localLightAppSettingInfo))) {
          localArrayList.add(localDeviceInfo);
        }
      }
      j += 1;
    }
    return (DeviceInfo[])localArrayList.toArray(new DeviceInfo[localArrayList.size()]);
  }
  
  protected int d()
  {
    String str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("detail_url");
    if ((!TextUtils.isEmpty(str)) && (biva.a(str).b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null))) {}
    for (int j = 0;; j = -1)
    {
      if (j == 0) {
        bivo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_AddFav", -1, 0, 69, 0, "", "");
      }
      return j;
    }
  }
  
  protected void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "ForwardPluginShareStructMsgOption forwardOnConfirm");
    }
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007C3A", "0X8007C3A", 0, 0, "2", "", "", "");
    E();
    if (f())
    {
      e();
      return;
    }
    if (this.jdField_a_of_type_AndroidOsBundle.getInt("uintype") == 1)
    {
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
      if (((bcnu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a((String)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131697834, 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298914));
        return;
      }
    }
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isWebCompShare", false))
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("report_type", "102");
      ((Bundle)localObject1).putString("act_type", "82");
      ((Bundle)localObject1).putString("intext_1", "" + bfif.a(this.jdField_d_of_type_Int));
      ((Bundle)localObject1).putString("intext_2", "" + bfif.a(this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"), this.jdField_a_of_type_AndroidOsBundle.getString("uin")));
      ((Bundle)localObject1).putString("intext_3", "1");
      bfhz.a().a((Bundle)localObject1, "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
    }
    if (this.jdField_d_of_type_Boolean)
    {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005793", "0X8005793", 0, 0, "", "", "", "");
      this.jdField_d_of_type_Boolean = false;
    }
    if (c() != 0) {}
    for (Object localObject1 = this.jdField_a_of_type_Bdjz.getInputValue();; localObject1 = "")
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl.startsWith("http://article.mp.qq.com")) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl.startsWith("http://post.mp.qq.com")))
      {
        localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
        nrt.a(null, "", "0X8007236", "0X8007236", 0, 0, this.jdField_i_of_type_JavaLangString, "" + this.jdField_e_of_type_Int, (String)localObject2, "");
        nrt.a("0X8007236", "", this.jdField_i_of_type_JavaLangString, "" + this.jdField_e_of_type_Int, (String)localObject2, "");
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) || (!"".equals(localObject1))) {
          nrt.a(null, "", "0X8007237", "0X8007237", 0, 0, this.jdField_i_of_type_JavaLangString, "" + this.jdField_e_of_type_Int, (String)localObject2, "");
        }
      }
      this.jdField_a_of_type_AndroidContentIntent.getAction();
      Object localObject2 = Boolean.valueOf(this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("key_flag_from_plugin", false));
      Object localObject3 = Boolean.valueOf(this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_back", false));
      if (QLog.isColorLevel()) {
        QLog.d("forward", 2, "ForwardPluginShareStructMsgOption forwardOnConfirm isFromPlugin=" + localObject2 + "iskeyBack=" + localObject3 + "isNOneedJumpToAIO=" + this.jdField_e_of_type_Boolean);
      }
      Object localObject4;
      int j;
      if (((Boolean)localObject2).booleanValue())
      {
        localObject2 = aepi.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), new int[] { 2 });
        this.jdField_a_of_type_AndroidOsBundle.putString("share_comment_message", (String)localObject1);
        ((Intent)localObject2).putExtras(this.jdField_a_of_type_AndroidOsBundle);
        a((Intent)localObject2);
        if (((Boolean)localObject3).booleanValue())
        {
          localObject3 = azvd.a(((Intent)localObject2).getExtras());
          if ((this.jdField_d_of_type_Int == 13) && ((localObject3 instanceof StructMsgForGeneralShare)))
          {
            localObject4 = (StructMsgForGeneralShare)localObject3;
            StringBuilder localStringBuilder = new StringBuilder(((Intent)localObject2).getStringExtra("struct_share_key_content_action_DATA"));
            localStringBuilder.append("&msg=").append(((Intent)localObject2).getStringExtra("title")).append("&toUin=").append(this.jdField_a_of_type_AndroidOsBundle.getString("uin"));
            ((StructMsgForGeneralShare)localObject4).mMsgActionData = localStringBuilder.toString();
          }
          if (((AbsStructMsg)localObject3).mMsgServiceID == 83) {
            ((AbsStructMsg)localObject3).mMsgActionData = "";
          }
          if ((((AbsStructMsg)localObject3).mMsgServiceID == 108) || (((AbsStructMsg)localObject3).mMsgServiceID == 114) || (((AbsStructMsg)localObject3).mMsgServiceID == 116)) {
            ((AbsStructMsg)localObject3).mMsgActionData = "";
          }
          localObject4 = ForwardUtils.a((Intent)localObject2);
          j = afcu.a().a();
          ((AbsStructMsg)localObject3).forwardID = j;
          afcu.a().a((SessionInfo)localObject4, (String)localObject1, j);
          bdna.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidOsBundle.getString("uin"), ((SessionInfo)localObject4).b, this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"), (AbsStructMsg)localObject3, null);
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            nav.a().a = true;
          }
          localObject1 = new Intent();
          ((Intent)localObject1).putExtras(this.jdField_a_of_type_AndroidOsBundle);
          this.jdField_a_of_type_AndroidAppActivity.setResult(-1, (Intent)localObject1);
          if (!"public_account".equals(this.h)) {
            break label1446;
          }
          localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("pubUin");
          if (localObject1 != null) {
            break label1552;
          }
          localObject1 = "";
        }
      }
      label1552:
      for (;;)
      {
        int k;
        switch (this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"))
        {
        default: 
          j = -1;
          k = 0;
          label1044:
          if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_struct_forward", false))
          {
            if (this.jdField_a_of_type_AndroidContentIntent.getStringExtra("struct_uin") == null) {}
            localObject3 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("strurt_msgid");
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            localObject4 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("detail_url");
            localObject3 = localObject4;
            if (localObject4 == null) {
              localObject3 = "";
            }
            localObject4 = StructingMsgItemBuilder.a();
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005456", "0X8005456", 0, 0, (String)localObject4, (String)localObject2, (String)localObject3, "" + j);
          }
          PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, "Pb_account_lifeservice", "mp_msg_sys_11", "pbshare_success", k);
        }
        for (;;)
        {
          if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isWebCompShare", false))
          {
            localObject1 = new Bundle();
            ((Bundle)localObject1).putString("report_type", "102");
            ((Bundle)localObject1).putString("act_type", "83");
            ((Bundle)localObject1).putString("intext_1", "" + bfif.a(this.jdField_d_of_type_Int));
            ((Bundle)localObject1).putString("intext_2", "" + bfif.a(this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"), this.jdField_a_of_type_AndroidOsBundle.getString("uin")));
            ((Bundle)localObject1).putString("intext_3", "1");
            bfhz.a().a((Bundle)localObject1, "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
          }
          this.jdField_a_of_type_AndroidAppActivity.finish();
          return;
          if (this.jdField_e_of_type_Boolean)
          {
            localObject1 = ForwardUtils.a((Intent)localObject2);
            ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (SessionInfo)localObject1, (Intent)localObject2);
            break;
          }
          if (asbe.a((Intent)localObject2))
          {
            localObject1 = ForwardUtils.a((Intent)localObject2);
            ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (SessionInfo)localObject1, (Intent)localObject2);
          }
          this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject2);
          break;
          j = 1;
          k = 1001;
          break label1044;
          j = 2;
          k = 1002;
          break label1044;
          j = 3;
          k = 1003;
          break label1044;
          label1446:
          if ("struct_msg_from_h5".equals(this.h))
          {
            localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("pubUin");
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, "Pb_account_lifeservice", "mp_msg_sys_31", "share_succ");
            }
          }
          else if (asbe.a((Intent)localObject2))
          {
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_AndroidOsBundle.getString("uin"), "Music_gene", "Music_gene_send", 0, 1, 0, "", "", "", "");
          }
        }
        v();
        return;
      }
    }
  }
  
  protected boolean h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg == null) {}
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.e("ForwardOption.ForwardPluginShareStructMsgOption", 2, "msgId = " + this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID);
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
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007C3A", "0X8007C3A", 0, 0, "1", "", "", "");
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_struct_forward", false)) {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005457", "0X8005457", 0, 0, "", "", "android", "");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl.startsWith("http://article.mp.qq.com")) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl.startsWith("http://post.mp.qq.com")))
    {
      String str = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
      nrt.a(null, "", "0X8007235", "0X8007235", 0, 0, this.jdField_i_of_type_JavaLangString, "" + this.jdField_e_of_type_Int, str, "");
    }
  }
  
  protected void y()
  {
    AbsStructMsg localAbsStructMsg = azvd.a(this.jdField_a_of_type_AndroidOsBundle);
    if (localAbsStructMsg != null) {
      ((zxz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(this.jdField_a_of_type_AndroidOsBundle.getString("uin"), localAbsStructMsg);
    }
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asbj
 * JD-Core Version:    0.7.0.1
 */